package com.example.hansity.syyyz;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TicketDBHelper ticketDBHelper = new TicketDBHelper(this);
        TheaterDBHelper theaterDBHelper = new TheaterDBHelper(this);
        MovieDBHelper movieDBHelper = new MovieDBHelper(this);

        ticketDBHelper.drop();
        theaterDBHelper.drop();
        movieDBHelper.drop();

        /*
        Ticket t0 = new Ticket(0, 0, new GregorianCalendar(2015, 5, 25), 0, 0, 1, 10);
        //Ticket t1 = new Ticket(1, 0, 0, new GregorianCalendar(2015, 5, 25), 1, 1, 0, 20);
        Ticket t2 = new Ticket(0, 0, new GregorianCalendar(2015, 5, 25), 2, 2, 0, 30);
        Ticket t3 = new Ticket(0, 1, new GregorianCalendar(2015, 5, 26), 3, 3, 0, 40);
        Ticket t4 = new Ticket(0, 2, new GregorianCalendar(2015, 5, 27), 4, 4, 0, 50);
        Theater th0 = new Theater("a2", "b2");
        Theater th1 = new Theater("c", "d");

        ticketDBHelper.insert(t0);
        ticketDBHelper.update(t1);
        ticketDBHelper.insert(t2);
        ticketDBHelper.insert(t3);
        ticketDBHelper.insert(t4);
        theaterDBHelper.insert(th0);
        theaterDBHelper.insert(th1);
        */

        Bitmap bm = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Movie m0 = new Movie("name", "type", 120, "ss", "newMovie", bm);
        Movie m1 = new Movie("name2", "type2", 220, "ss2", "newMovie2", bm);
        movieDBHelper.insert(m0);
        movieDBHelper.insert(m1);

        /*
        ArrayList<Theater> theaterList = theaterDBHelper.queryAllTheaters();
        for ( Theater theater : theaterList ) {
            Log.e("myInfo", theater.getTheaterId() + theater.getTheaterName());
        }

        ArrayList<Ticket> ticketList = ticketDBHelper.queryTicketsBytheaterAndTime(0, 0, new GregorianCalendar(2015, 5, 25));
        for ( Ticket ticket : ticketList ) {
            Log.e("myInfo", ticket.getTicketId() + " " + ticket.getSeatRow() + " " + ticket.getAvailability() + " " + ticket.getPrice());
        }
        */
        ArrayList<Movie> movieList = movieDBHelper.queryAll();
        for ( Movie movie : movieList ) {
            Log.e("myInfo", movie.getMovieName());
        }

        movieList = movieDBHelper.queryById(1);
        for ( Movie movie : movieList ) {
            Log.e("myInfo", movie.getMovieName() + " " +  movie.getMovieType() + " " +
                    movie.getMovieDuration() + " " + movie.getMovieDirector() + " " + movie.getMovieDescription() );
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
