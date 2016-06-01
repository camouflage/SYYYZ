package com.example.hansity.syyyz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.util.ArrayList;
import java.util.List;

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
                "theaterName text, theaterLocation text, price integer" +
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
        cv.put("price", entity.getPrice());

        long id = db.insert(TABLE_NAME, null, cv);
        db.close();
        return id;
    }

    public void drop() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<Theater> queryAllTheaters() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Theater> theaterList = new ArrayList<Theater>();
        if ( cursor != null ) {
            // Move cursor to the first row
            if ( cursor.moveToFirst() ) {
                do {
                    int id = cursor.getInt(cursor.getColumnIndex("theaterId"));
                    String theaterName = cursor.getString(cursor.getColumnIndex("theaterName"));
                    String theaterLocation = cursor.getString(cursor.getColumnIndex("theaterLocation"));
                    int price = cursor.getInt(cursor.getColumnIndex("price"));

                    theaterList.add(new Theater(id, theaterName, theaterLocation, price));
                } while (cursor.moveToNext());
            }
        }

        return theaterList;
    }
}
