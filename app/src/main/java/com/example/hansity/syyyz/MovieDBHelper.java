
package com.example.hansity.syyyz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by sunsheng on 5/29/16.
 */
public class MovieDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "syyyzMoive.db";
    private static final String TABLE_NAME = "Movie";
    private static final int DB_VERSION = 1;
    private BitmapUtil bitmapUtil = new BitmapUtil();

    public MovieDBHelper(Context context) {
        //super(context, "/mnt/sdcard/" + DB_NAME, null, DB_VERSION);
        //super(context, Environment.getExternalStorageDirectory().getPath() + "/" + DB_NAME, null, DB_VERSION);
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "create table if not exists " + TABLE_NAME + "(" +
                "movieId integer primary key autoincrement, " +
                "movieName text not null, movieType text not null, movieDuration integer not null, " +
                "movieDirector text not null, movieDescription text not null, " +
                "movieImg blob not null" +
                ");";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long insert(Movie entity) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        //cv.put("movieId", entity.getMovieId());
        cv.put("movieName", entity.getMovieName());
        cv.put("movieType", entity.getMovieType());
        cv.put("movieDuration", entity.getMovieDuration());
        cv.put("movieDirector", entity.getMovieDirector());
        cv.put("movieDescription", entity.getMovieDescription());
        cv.put("movieImage", bitmapUtil.getBytes(entity.getMovieImage()));

        long id = db.insert(TABLE_NAME, null, cv);
        db.close();
        return id;
    }

    public long update(Movie entity) {
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = "movieId = ?";
        String[] whereArgs = {"" + entity.getMovieId()};

        ContentValues cv = new ContentValues();
        cv.put("movieId", entity.getMovieId());
        cv.put("movieName", entity.getMovieName());
        cv.put("movieType", entity.getMovieType());
        cv.put("movieDuration", entity.getMovieDuration());
        cv.put("movieDirector", entity.getMovieDirector());
        cv.put("movieDescription", entity.getMovieDescription());
        cv.put("movieImage", bitmapUtil.getBytes(entity.getMovieImage()));

        int rows = db.update(TABLE_NAME, cv, whereClause, whereArgs);
        db.close();

        return rows;
    }

    public void drop() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<Movie> queryAll() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT movieName, movieImage FROM " + TABLE_NAME, null);

        ArrayList<Movie> movieList = new ArrayList<Movie>();
        if ( cursor != null ) {
            // Move cursor to the first row
            if ( cursor.moveToFirst() ) {
                do {
                    String movieName  = cursor.getString(cursor.getColumnIndex("movieName"));
                    Bitmap movieImage = bitmapUtil.getImage(cursor.getBlob(cursor.getColumnIndex("movieImage")));

                    movieList.add(new Movie(movieName, movieImage));
                } while (cursor.moveToNext());
            }
        }

        return movieList;
    }

    public ArrayList<Movie> queryById(int movieId) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT movieName, movieImage FROM " + TABLE_NAME +
                " WHERE movieId = " + movieId, null);

        ArrayList<Movie> movieList = new ArrayList<Movie>();
        if ( cursor != null ) {
            // Move cursor to the first row
            if ( cursor.moveToFirst() ) {
                do {
                    String movieName  = cursor.getString(cursor.getColumnIndex("movieName"));
                    String movieType  = cursor.getString(cursor.getColumnIndex("movieType"));
                    int movieDuration = cursor.getInt(cursor.getColumnIndex("movieDuration"));
                    String movieDirector  = cursor.getString(cursor.getColumnIndex("movieDirecror"));
                    String movieDescription  = cursor.getString(cursor.getColumnIndex("movieDescripton"));
                    Bitmap movieImage = bitmapUtil.getImage(cursor.getBlob(cursor.getColumnIndex("movieImage")));

                    movieList.add(new Movie(movieName, movieType, movieDuration, movieDirector, movieDescription, movieImage));
                } while (cursor.moveToNext());
            }
        }

        return movieList;
    }
}
