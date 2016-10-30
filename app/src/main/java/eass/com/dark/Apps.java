package eass.com.dark;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import eass.com.sqlite.SqliteDb;

/**
 * Created by Eass_September on 2016/10/24.
 */

public class Apps extends AppCompatActivity {

    private SqliteDb sqliteDb;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apps);

        //数据库
        sqliteDb = new SqliteDb(getApplicationContext());
        //打开或者创建数据库  第一次打开
        //SQLiteDatabase sqlitedatabase = sqliteDb.getWritableDatabase();
        //同上 如果磁盘满了  返回只读的
        //SQLiteDatabase sqlitereadbledatabase = sqliteDb.getReadableDatabase();


    }

    public void showSome(View v){
        SQLiteDatabase db = sqliteDb.getWritableDatabase();

        /**
         * ============================================================================
         * //数据库操作
         * ============================================================================
         */
        /*
        db.execSQL("insert into info(name,password) values (?,?)", new Object[]{"eass", "123456"});//增加 修改 删除共用
        //查询

        Cursor cursor = db.rawQuery("select * from info", null);//查找
        if(cursor != null && cursor.getCount()>0){
            while (cursor.moveToNext()){
                String name = cursor.getString(1);
                String password = cursor.getString(2);
                System.out.println("name:"+name+"------password:"+password);
            }
        }
        db.close();
        */



        /**
         * ============================================================================
         *  GOOGLE API 数据库操作
         * ============================================================================
         */
        //---------------insert----------------//
        /*
        ContentValues values = new ContentValues();
        values.put("name", "张三");
        values.put("password", "32566678");
        long info = db.insert("info", null, values);
        if(info > 0){
            Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
        }
        */
        //---------------delete----------------//
        /*
        int info = db.delete("info", "id=?", new String[]{"8"});//返回值是影响的行数
        Toast.makeText(this, "删除的行数是"+info, Toast.LENGTH_SHORT).show();
        */
        //---------------update----------------//
        /*
        ContentValues values = new ContentValues();
        values.put("name", "ab");
        values.put("password", "775544");
        values.put("money", "100");
        int info = db.update("info", values, "id>? and id<?", new String[]{"7", "11"});
        Toast.makeText(this, "更新的行数是"+info, Toast.LENGTH_SHORT).show();
        */
        //---------------select----------------//
        /*
        Cursor cursor = db.query("info", new String[]{"password"}, "id=?", new String[]{"9"},null, null, null);

        if(cursor != null && cursor.getCount()>0){
            while (cursor.moveToNext()){
                String password = cursor.getString(0);

                System.out.println("password:"+password);
            }
        }
        */
        //---------------数据库事务   失败自动回滚----------------//
        db.beginTransaction(); //事务开启
        try{
            db.execSQL("update info set money=money-10 where id=?", new Object[]{"9"});


            db.execSQL("update info set money=money+10 where id=?", new Object[]{"10"});

            //int i = 10/0;//遇错误中断

            db.setTransactionSuccessful();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "服务器忙", Toast.LENGTH_SHORT).show();
        }finally {
            db.endTransaction();//关闭事务
        }




        db.close();



        //Toast.makeText(this, "apps", Toast.LENGTH_SHORT).show();
    }
    public void showListView(View v){
        Intent intent2 = new Intent();
        intent2.setClass(getApplicationContext(), MyList.class);//方法2  跳转
        startActivity(intent2);
        Toast.makeText(getApplicationContext(), "listView", Toast.LENGTH_SHORT).show();
    }


}
