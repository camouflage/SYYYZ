package com.example.hansity.syyyz;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

/**
 * Created by sunsheng on 6/1/16.
 */
public class TestDBHelper {
    private Context context;
    public TestDBHelper(Context context) {
        this.context = context;
    }

    void init() {
        TicketDBHelper ticketDBHelper = new TicketDBHelper(context);
        TheaterDBHelper theaterDBHelper = new TheaterDBHelper(context);
        MovieDBHelper movieDBHelper = new MovieDBHelper(context);

        ticketDBHelper.drop();
        theaterDBHelper.drop();
        movieDBHelper.drop();

        Ticket t0 = new Ticket(0, 0, new GregorianCalendar(2015, 5, 25), 0, 0, 1, 10);
        Ticket t1 = new Ticket(1, 0, 0, new GregorianCalendar(2015, 5, 25), 1, 1, 1, 20);
        Ticket t2 = new Ticket(0, 0, new GregorianCalendar(2015, 5, 25), 2, 2, 1, 30);
        Ticket t3 = new Ticket(0, 1, new GregorianCalendar(2015, 5, 26), 3, 3, 0, 40);
        Ticket t4 = new Ticket(0, 2, new GregorianCalendar(2015, 5, 27), 4, 4, 0, 50);
        Theater th0 = new Theater("a2", "b2", 30);
        Theater th1 = new Theater("c", "d", 50);

        ticketDBHelper.insert(t0);
        ticketDBHelper.update(t1);
        ticketDBHelper.insert(t2);
        ticketDBHelper.insert(t3);
        ticketDBHelper.insert(t4);
        theaterDBHelper.insert(th0);
        theaterDBHelper.insert(th1);

        Bitmap bm = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Movie m0 = new Movie("name", "type", 120, "ss", "newMovie", bm);
        Movie m1 = new Movie("name2", "type2", 220, "ss2", "newMovie2", bm);
        movieDBHelper.insert(m0);
        movieDBHelper.insert(m1);


        ArrayList<Theater> theaterList = theaterDBHelper.queryAllTheaters();
        for ( Theater theater : theaterList ) {
            Log.e("myInfoTheater", theater.getTheaterId() + " " +  theater.getTheaterName() + " " + theater.getPrice());
        }

        ArrayList<Movie> movieList = movieDBHelper.queryAll();
        for ( Movie movie : movieList ) {
            Log.e("myInfoMovie", movie.getMovieName());
        }

        Movie movie = movieDBHelper.queryById(1);

        int[][] sa = ticketDBHelper.queryTicketsBytheaterAndTime(0, 0, new GregorianCalendar(2015, 5, 25));
        for ( int i = 0; i < sa.length; ++i ) {
            Log.e("myInfoTicket", Arrays.toString(sa[i]));
        }

    }
}
