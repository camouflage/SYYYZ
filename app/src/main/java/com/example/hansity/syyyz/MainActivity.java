package com.example.hansity.syyyz;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    private TicketDBHelper ticketDBHelper = new TicketDBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
