package com.example.hansity.syyyz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by YouWei on 2016/5/31.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper
{
    final String CREATE_TABLE_SQL =
            "create table news_inf(_id integer"
                    + " primary key autoincrement,"
                    + " news_title varchar(50),"
                    + " news_content varchar(255))";
    public MyDatabaseHelper(Context context, String name, int version)
    {
        super(context, name, null, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // 第一次使用数据库时自动建表
        db.execSQL(CREATE_TABLE_SQL);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db
            , int oldVersion, int newVersion)
    {
        System.out.println("--------onUpdate Called--------"
                + oldVersion + "--->" + newVersion);
    }
}


