package com.example.hansity.syyyz;

import java.util.GregorianCalendar;

/**
 * Created by sunsheng on 5/27/16.
 */
public class Ticket {
    private int ticketId;
    private int movieTheaterId;
    private int movieId;
    private GregorianCalendar time;
    private int seatRow;
    private int seatCol;
    private int availability;
    private int price;

    public Ticket(int ticketId, int movieTheaterId, int movieId, GregorianCalendar time, int seatRow, int seatCol, int availability, int price) {
        this.ticketId = ticketId;
        this.movieTheaterId = movieTheaterId;
        this.movieId = movieId;
        this.time = time;
        this.seatRow = seatRow;
        this.seatCol = seatCol;
        this.availability = availability;
        this.price = price;
    }

    public Ticket() {
    }

    public int getTicketId() {
        return ticketId;
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

    public int getAvailability() {
        return availability;
    }

    public int getPrice() {
        return price;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
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

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
