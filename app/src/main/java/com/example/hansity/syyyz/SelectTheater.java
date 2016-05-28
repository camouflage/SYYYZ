package com.example.hansity.syyyz;

/**
 * Created by Hansity on 2016/5/28.
 */

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class SelectTheater extends Activity {
    private List<Theater> theaterList = new ArrayList<Theater>();

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.theater_list);

    }
}
