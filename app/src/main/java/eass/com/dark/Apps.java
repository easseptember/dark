package eass.com.dark;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.view.View;
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



        //Toast.makeText(this, "apps", Toast.LENGTH_SHORT).show();
    }
}
