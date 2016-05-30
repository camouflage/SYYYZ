package com.example.hansity.syyyz;

/**
 * Created by samsung- on 2016/5/30.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
public class UserDBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "syyyzUser.db";
    private static final String TABLE_NAME = "Users";
    private static final int Version = 1;
    public UserDBHandler(Context context, String name, CursorFactory factory, int version) {
        super(context, DB_NAME, factory, Version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists"+ TABLE_NAME +
                "(id integer primary key autoincrement, UserName varchar(200), PassWord varchar(200) );");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }
    public long insert(User users) {// 插入记录
        SQLiteDatabase db = getWritableDatabase();// 取得数据库操作
        ContentValues values = new ContentValues();
        values.put("UserName",users.getUserName());
        values.put("PassWord",users.getPassWord());
        values.put("id", users.getId());
        long rowid = db.insert(TABLE_NAME,null,values);
        if (rowid>0) {
            long count = users.getId();
            users.setId(count++);
        }
        return rowid;
    }
    public boolean CheckUserNameExist(String username) {
        SQLiteDatabase db =  getWritableDatabase();
        Cursor cursor = null ;
        cursor = db.rawQuery("select * from "+TABLE_NAME+" where UserName = ?", new String[] {username});
        if(cursor.getCount()>0) {
            return true;
        } else {
            return false;
        }
    }
}

