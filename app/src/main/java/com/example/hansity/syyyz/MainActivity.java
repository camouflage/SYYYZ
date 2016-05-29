package com.example.hansity.syyyz;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.GregorianCalendar;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TicketDBHelper ticketDBHelper = new TicketDBHelper(this);
        TheaterDBHelper theaterDBHelper = new TheaterDBHelper(this);

        //ticketDBHelper.drop();
        //theaterDBHelper.drop();

        Ticket t0 = new Ticket(0, 0, new GregorianCalendar(2015, 5, 25), 0, 0, 1, 10);
        Ticket t1 = new Ticket(0, 0, new GregorianCalendar(2015, 5, 25), 0, 0, 0, 20);
        //Ticket t2 = new Ticket(0, 1, new GregorianCalendar(2015, 5, 26), 0, 0, 0, 20);
        //Ticket t3 = new Ticket(0, 2, new GregorianCalendar(2015, 5, 26), 0, 0, 0, 20);
        Theater th0 = new Theater("a2", "b2");
        Theater th1 = new Theater("c", "d");

        ticketDBHelper.insert(t0);
        ticketDBHelper.update(t1);
        //ticketDBHelper.insert(t2);
        //ticketDBHelper.insert(t3);
        theaterDBHelper.insert(th0);
        theaterDBHelper.insert(th1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
