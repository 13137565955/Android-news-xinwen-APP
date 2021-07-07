package com.example.ex5_1_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by admin on 2021/5/8.
 */

public class DBOPenHelper extends SQLiteOpenHelper {
    private Context context;
    public DBOPenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }
    /*
    *在第一次创建数据库的的时候执行，仅执行一次。
    * 在改方法内执行创建数据表的操作
    * @param db
    * */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table user ("
                    + "id integer primary key autoincrement,"
                    + "account text,"
                    + "password text)";
        db.execSQL(sql);
        Toast.makeText(context, "数据库创建成功", Toast.LENGTH_SHORT).show();
    }
    /*
    * 改方法实现升级数据库的逻辑（代码）
    * */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
