package com.example.hansity.syyyz;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.GregorianCalendar;

public class MainActivity extends Activity {
    private TicketDBHelper ticketDBHelper = new TicketDBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Ticket t0 = new Ticket(0, 0, 0, new GregorianCalendar(2015, 5, 25), 0, 0, 1, 10);
        Ticket t1 = new Ticket(0, 0, 0, new GregorianCalendar(2015, 5, 25), 0, 0, 0, 20);
        ticketDBHelper.insert(t0);
        //ticketDBHelper.update(t1);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
