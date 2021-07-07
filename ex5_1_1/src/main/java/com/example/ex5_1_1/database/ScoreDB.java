package com.example.ex5_1_1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2019/9/21.
 */

public class ScoreDB extends SQLiteOpenHelper {

    //创建数据库的SQL语句
    final String Create_Table_SQL="create table tb_score(_id integer primary key autoincrement,CN varchar(50),EN varchar(50),SCORE varchar(50))";

    public ScoreDB(Context context,int version) {
        super(context,"tb_score",null,version);
    }

    /**
     * 创建数据库
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Create_Table_SQL);
        Log.d("--------------","-----------------数据库创建成功！");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
