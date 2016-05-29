package com.example.hansity.syyyz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by sunsheng on 5/27/16.
 */
public class TicketDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "syyyzTicket.db";
    private static final String TABLE_NAME = "Ticket";
    private static final int DB_VERSION = 1;

    public TicketDBHelper(Context context) {
        //super(context, "/mnt/sdcard/" + DB_NAME, null, DB_VERSION);
        //super(context, Environment.getExternalStorageDirectory().getPath() + "/" + DB_NAME, null, DB_VERSION);
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "create table if not exists " + TABLE_NAME + "(" +
                "ticketId integer primary key autoincrement, " +
                "theaterId integer not null, movieId integer not null, time integer not null, " +
                "seatRow integer not null, seatCol integer not null, " +
                "availability integer not null, price integer not null" +
                ");";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long insert(Ticket entity) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        //cv.put("ticketId", entity.getTicketId());
        cv.put("theaterId", entity.gettheaterId());
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
        cv.put("theaterId", entity.gettheaterId());
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

    public void drop() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<Ticket> queryTicketsBytheaterAndTime(int theaterId, int movieId, GregorianCalendar time) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME +
                " WHERE movieId = " + movieId +
                " AND theaterId = " + theaterId +
                " AND time = " + time.getTimeInMillis(), null);

        ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
        if ( cursor != null ) {
            // Move cursor to the first row
            if ( cursor.moveToFirst() ) {
                do {
                    int ticketId = cursor.getInt(cursor.getColumnIndex("ticketId"));
                    int seatRow = cursor.getInt(cursor.getColumnIndex("seatRow"));
                    int seatCol = cursor.getInt(cursor.getColumnIndex("seatCol"));
                    int availability = cursor.getInt(cursor.getColumnIndex("availability"));
                    int price = cursor.getInt(cursor.getColumnIndex("price"));

                    ticketList.add(new Ticket(ticketId, theaterId, movieId, time, seatRow, seatCol, availability, price));

                } while (cursor.moveToNext());
            }
        }

        return ticketList;
    }
}

