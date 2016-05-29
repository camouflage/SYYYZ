package com.example.hansity.syyyz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

/**
 * Created by sunsheng on 5/28/16.
 */
public class TheaterDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "syyyzTheater.db";
    private static final String TABLE_NAME = "Theater";
    private static final int DB_VERSION = 1;

    public TheaterDBHelper(Context context) {
        //super(context, "/mnt/sdcard/" + DB_NAME, null, DB_VERSION);
        //super(context,  Environment.getExternalStorageDirectory().getPath() + "/"+ DB_NAME, null, DB_VERSION);
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "create table if not exists " + TABLE_NAME + "(" +
                "theaterId integer primary key autoincrement, " +
                "theaterName text, theaterLocation text" +
                ");";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long insert(Theater entity) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        //cv.put("theaterId", entity.getTheaterId());
        cv.put("theaterName", entity.getTheaterName());
        cv.put("theaterLocation", entity.getTheaterLocation());

        long id = db.insert(TABLE_NAME, null, cv);
        db.close();
        return id;
    }

    public void drop() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
