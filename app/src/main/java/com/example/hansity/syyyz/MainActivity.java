package com.example.hansity.syyyz;

import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TestDBHelper testDBHelper = new TestDBHelper(this);
        testDBHelper.init();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
