package com.example.hansity.syyyz;

/**
 * Created by sunsheng on 5/27/16.
 */
import java.util.GregorianCalendar;

/**
 * Created by sunsheng on 5/27/16.
 */
public class Ticket {
    private int movieTheaterId;
    private int movieId;
    private GregorianCalendar time;
    private int seatRow;
    private int seatCol;
    private boolean availability;

    public Ticket(int movieTheaterId, int movieId, GregorianCalendar time, int seatRow, int seatCol, boolean availability) {
        this.movieTheaterId = movieTheaterId;
        this.movieId = movieId;
        this.time = time;
        this.seatRow = seatRow;
        this.seatCol = seatCol;
        this.availability = availability;
    }

    public int getMovieTheaterId() {
        return movieTheaterId;
    }

    public int getMovieId() {
        return movieId;
    }

    public GregorianCalendar getTime() {
        return time;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public int getSeatCol() {
        return seatCol;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setMovieTheaterId(int movieTheaterId) {
        this.movieTheaterId = movieTheaterId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setTime(GregorianCalendar time) {
        this.time = time;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public void setSeatCol(int seatCol) {
        this.seatCol = seatCol;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
