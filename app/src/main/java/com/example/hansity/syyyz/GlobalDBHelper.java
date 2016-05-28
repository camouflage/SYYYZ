package com.example.hansity.syyyz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        String CREATE_TABLE = "create table " + TABLE_NAME + "(" +
                "userId integer, movieId integer, movieTheaterId integer, ticketId integer" +
                ");";
        db.execSQL(CREATE_TABLE);

        ContentValues cv = new ContentValues();
        cv.put("userId", 0);
        cv.put("movieId", 0);
        cv.put("movieTheaterId", 0);
        cv.put("ticketId", 0);

        long id = db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public int getUserId() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(TABLE_NAME, new String[] {"userId"}, null, null, null, null, null);
        return c.getColumnIndex("userId");
    }

    public int getMovieId() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(TABLE_NAME, new String[] {"movieId"}, null, null, null, null, null);
        return c.getColumnIndex("movieId");
    }

    public int getMovieTheaterId() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(TABLE_NAME, new String[] {"movieTheaterId"}, null, null, null, null, null);
        return c.getColumnIndex("movieTheaterId");
    }

    public int getTicketId() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(TABLE_NAME, new String[] {"ticketId"}, null, null, null, null, null);
        return c.getColumnIndex("ticketId");
    }

    public void setUserId(int userId) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_NAME +  " SET userId = " + userId);
        db.close();
    }

    public void setMovieId(int movieId) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_NAME +  " SET movieId = " + movieId);
        db.close();
    }

    public void setMovieTheaterId(int movieTheaterId) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_NAME +  " SET movieTheaterId = " + movieTheaterId);
        db.close();
    }

    public void setTicketId(int ticketId) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_NAME +  " SET ticketId = " + ticketId);
        db.close();
    }
}

