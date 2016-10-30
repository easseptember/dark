package eass.com.dark;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import eass.com.sqlite.SqliteDb;

/**
 * Created by Eass_September on 2016/10/30.
 */
public class MyList extends AppCompatActivity {
    List<Person> list =new ArrayList<Person>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        //数据库读取
        SqliteDb sqliteDb = new SqliteDb(getApplicationContext());
        SQLiteDatabase db = sqliteDb.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from info", null);//查找
        if(cursor != null && cursor.getCount()>0){
            while (cursor.moveToNext()){
                String id       = cursor.getString(0);
                String name     = cursor.getString(1);
                String password = cursor.getString(2);
                String money    = cursor.getString(3);
                Person person = new Person();
                person.setId(id);
                person.setName(name);
                person.setPassword(password);
                person.setMoney(money);
                list.add(person);

            }
        }
        db.close();


        ListView lv = (ListView) findViewById(R.id.lists);
        lv.setAdapter(new myAdapter());

    }
    private class myAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        /**
         *
         * @param position
         * @param convertView  历史缓存对象
         * @param parent
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            /**
             * ============================================================================
             *  普通listview
             * ============================================================================
             */
            /*
            TextView tv;
            if(convertView == null){
                tv = new TextView(getApplicationContext());
                System.out.println("创建新的对象"+position);
            }else {
                tv = (TextView) convertView;
                System.out.println("复用历史缓存对象"+position);
            }


            tv.setText("====LINE==="+position);

           return tv;
           */
            /**
             * ============================================================================
             *  复杂listview[可以通过打气筒把一个布局资源转换为view对象]
             * ============================================================================
             */
            //View view = convertView==null?View.inflate(getApplicationContext(), R.layout.item, null):convertView;

            //LayoutInflater.from(getApplicationContext()).inflate(R.layout.item, null);//第二种写法
            //LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            //layoutInflater.inflate(R.layout.item, null);//第三种写法
            /**
             * ============================================================================
             *  数据库内容 listview
             * ============================================================================
             */
            View view = convertView==null?View.inflate(getApplicationContext(), R.layout.database_item, null):convertView;
            TextView itemId         = (TextView) view.findViewById(R.id.database_item_id);
            TextView itemName       = (TextView) view.findViewById(R.id.database_item_name);
            TextView itemPassword   = (TextView) view.findViewById(R.id.database_item_password);
            TextView itemMoney      = (TextView) view.findViewById(R.id.database_item_money);
            Person person = list.get(position);
            System.out.println(person.getId());
            itemId.setText(person.getId());
            itemName.setText(person.getName());
            itemPassword.setText(person.getPassword());
            String money = person.getMoney()==null || person.getMoney().equals("")?"0":person.getMoney();
            itemMoney.setText(money);

            return view;
        }
    }

}
