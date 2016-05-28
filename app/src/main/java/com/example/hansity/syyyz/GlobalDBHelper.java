package com.example.hansity.syyyz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sunsheng on 5/28/16.
 */
public class GlobalDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "syyyzGlobal.db";
    private static final String TABLE_NAME = "Global";
    private static final int DB_VERSION = 1;

    public GlobalDBHelper(Context context) {
        //super(context, "/mnt/sdcard/" + DB_NAME, null, DB_VERSION);
        //super(context,  Environment.getExternalStorageDirectory().getPath() + "/"+ DB_NAME, null, DB_VERSION);
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "create table if not exists " + TABLE_NAME + "(" +
                "varType text primary key, " +
                "count integer" +
                ");";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + TABLE_NAME);
        onCreate(db);
    }

    public long init() {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("userId", 0);
        cv.put("movieId", 0);
        cv.put("movieTheaterId", 0);
        cv.put("ticketId", 0);

        long id = db.insert(TABLE_NAME, null, cv);
        db.close();
        return id;
    }
}
