package com.example.hansity.syyyz;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.GregorianCalendar;

public class MainActivity extends Activity {
    private TicketDBHelper ticketDBHelper;
    private TheaterDBHelper theaterDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ticketDBHelper = new TicketDBHelper(this);
        theaterDBHelper = new TheaterDBHelper(this);

        Ticket t0 = new Ticket(0, 0, 0, new GregorianCalendar(2015, 5, 25), 0, 0, 1, 10);
        Ticket t1 = new Ticket(0, 0, 0, new GregorianCalendar(2015, 5, 25), 0, 0, 0, 20);
        Theater th0 = new Theater(0, "a", "b");

        ticketDBHelper.insert(t0);
        ticketDBHelper.update(t1);
        theaterDBHelper.insert(th0);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
