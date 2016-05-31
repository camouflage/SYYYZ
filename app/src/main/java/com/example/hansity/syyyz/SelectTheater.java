package com.example.hansity.syyyz;

/**
 * Created by Hansity on 2016/5/28.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class SelectTheater extends Activity {
    private List<Theater> theaterList = new ArrayList<Theater>();
    private TheaterAdapter listViewAdapter;
    private TheaterDBHelper theaterDB = new TheaterDBHelper(this);

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.theater_list);

        Spinner sdate = (Spinner)findViewById(R.id.spinner_date);
        Spinner stime = (Spinner)findViewById(R.id.spinner_time);



        final Bundle bundle = this.getIntent().getExtras();
        int movieid = bundle.getInt("movieid");

        theaterList = theaterDB.queryAllTheaters();

        listViewAdapter = new TheaterAdapter(this, R.layout.theater_format, theaterList);
        ListView listview = (ListView)findViewById(R.id.theater_list);
        listview.setAdapter(listViewAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View view, int position, long id){
                Intent intent = new Intent();

                Theater theater = theaterList.get(position);
                bundle.putInt("movieid", theater.getTheaterId());
                intent.putExtras(bundle);
                intent.setClass(SelectTheater.this, MovieDetail.class);
                startActivity(intent);
            }
        });
    }
}
