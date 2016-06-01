package com.example.hansity.syyyz;

/**
 * Created by Hansity on 2016/5/28.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class SelectTheater extends Activity {
    private List<Theater> theaterList = new ArrayList<Theater>();
    private TheaterAdapter listViewAdapter;
    private TheaterDBHelper theaterDB = new TheaterDBHelper(this);
    private int date_spinnerID = -1;
    private int time_spinnerID = -1;
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

        sdate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                date_spinnerID = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        stime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                time_spinnerID = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View view, int position, long id){

                if (time_spinnerID != -1 && date_spinnerID != -1) {
                    Intent intent = new Intent();

                    Theater theater = theaterList.get(position);
                    bundle.putInt("movieid", theater.getTheaterId());
                    bundle.putInt("timeid", time_spinnerID);
                    bundle.putInt("dateid", date_spinnerID);
                    intent.putExtras(bundle);
                    intent.setClass(SelectTheater.this, MovieDetail.class);
                    startActivity(intent);

                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "请选择日期和场次", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

            }
        });
    }
}
