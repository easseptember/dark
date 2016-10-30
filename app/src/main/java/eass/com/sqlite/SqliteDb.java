package eass.com.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Eass_September on 2016/10/26.
 */

public class SqliteDb extends SQLiteOpenHelper {

    public SqliteDb(Context context) {
        super(context, "dark.db", null, 5);
    }

    /**
     * 第一次创建时候的调用  适合表结构的初始化
     * @param db desc
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table info(id integer primary key autoincrement,name varchar(20))";
        db.execSQL(sql);
    }

    /**
     * 适合更新表结构   在数据更新时调用
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //String sql = "alter table info add password varchar(20)";
        String sql = "alter table info add money varchar(120)";
        db.execSQL(sql);
    }
}
