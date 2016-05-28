package com.example.hansity.syyyz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by sunsheng on 5/27/16.
 */
public class TicketDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "syyyz.db";
    private static final String TABLE_NAME = "Ticket";
    private static final int DB_VERSION = 1;

    public TicketDBHelper(Context context) {
        super(context, "/mnt/sdcard/Android" + DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "create table " + TABLE_NAME + "(" +
                "ticketId integer primary key autoincrement, " +
                "movieTheaterId integer not null, movieId integer not null, time integer not null, " +
                "seatRow integer not null, seatCol integer not null, " +
                "availability integer not null, price integer not null" +
                ");";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + TABLE_NAME);
        onCreate(db);
    }

    public long insert(Ticket entity) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ticketId", entity.getTicketId());
        cv.put("movieTheaterId", entity.getMovieTheaterId());
        cv.put("movieId", entity.getMovieId());
        cv.put("time", entity.getTime().getTimeInMillis());
        cv.put("seatRow", entity.getSeatRow());
        cv.put("seatCol", entity.getSeatCol());
        cv.put("availability", entity.getAvailability());
        cv.put("price", entity.getPrice());

        long id = db.insert(TABLE_NAME, null, cv);
        db.close();
        return id;
    }

    public long update(Ticket entity) {
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = "ticketId = ?";
        String[] whereArgs = {"" + entity.getTicketId()};

        ContentValues cv = new ContentValues();
        cv.put("ticketId", entity.getTicketId());
        cv.put("movieTheaterId", entity.getMovieTheaterId());
        cv.put("movieId", entity.getMovieId());
        cv.put("time", entity.getTime().getTimeInMillis());
        cv.put("seatRow", entity.getSeatRow());
        cv.put("seatCol", entity.getSeatCol());
        cv.put("availability", entity.getAvailability());
        cv.put("price", entity.getPrice());

        int rows = db.update(TABLE_NAME, cv, whereClause, whereArgs);
        db.close();

        return rows;
    }




}
