package com.example.hansity.syyyz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sunsheng on 5/27/16.
 */
public class TicketDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "syyyz.db";
    private static final String TABLE_NAME = "Ticket";
    private static final int DB_VERSION = 1;

    public TicketDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "create table " + TABLE_NAME + "(" +
                "ticketId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "movieTheaterId INTEGER NOT NULL, movieId INTEGER NOT NULL, time INTEGER NOT NULL, " +
                "seatRow INTEGER NOT NULL, seatCol INTEGER NOT NULL, " +
                "availability INTEGER NOT NULL, price INTEGER NOT NULL, " +
                ");";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS " + TABLE_NAME);
        onCreate(db);
    }
}
