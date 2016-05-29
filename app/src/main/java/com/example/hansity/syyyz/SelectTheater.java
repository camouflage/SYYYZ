package com.example.hansity.syyyz;

/**
 * Created by Hansity on 2016/5/28.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class SelectTheater extends Activity {
    private List<Theater> theaterList = new ArrayList<Theater>();
    private TheaterAdapter listViewAdapter;
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.theater_list);

        listViewAdapter = new TheaterAdapter(this, R.layout.theater_format, theaterList);
        ListView listview = (ListView)findViewById(R.id.theater_list);
        listview.setAdapter(listViewAdapter);


    }
}
