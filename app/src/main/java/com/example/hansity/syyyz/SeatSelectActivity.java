package com.example.hansity.syyyz;


import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatSelectActivity extends Activity {

    private GridView gridView;
    private int[]imageIds = new int[] {R.drawable.empty_seat};
    private Button button;
    private String s="";
    private int[]seat_state = new int[] {
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,2,0,0,0,
            0,0,0,2,0,0,0,0,0,0,
            0,2,0,0,0,2,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,2,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0
    };
    static int seat_num = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();

        for(int i = 0; i<seat_num;i++) {
            Map<String,Object> listItem = new HashMap<String,Object>();
            if(seat_state[i]==0) {
                listItem.put("image", R.drawable.empty_seat);
            } else if (seat_state[i]==1) {
                listItem.put("image", R.drawable.seleced_seat);
            } else {
                listItem.put("image", R.drawable.sold_seat);
            }
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.item, new String[]{"image"}, new int[]{R.id.itemImage});

        gridView = (GridView) findViewById(R.id.grid01);

        gridView.setAdapter(simpleAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView imageView = (ImageView) view.findViewById(R.id.itemImage);
                if(seat_state[position]==0) {
                    imageView.setImageResource(R.drawable.seleced_seat);
                    seat_state[position]=1;
                }
                else if(seat_state[position]==1) {
                    imageView.setImageResource(R.drawable.empty_seat);
                    seat_state[position]=0;
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "傻儿子，有人预订了你还点？", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                }
            }
        });
        final TextView textView = (TextView) findViewById(R.id.seat_id);
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = "";
                reservation_information();
                textView.setText(s);
            }
        });

    }

    public void reservation_information() {
        Seat t = new Seat();
        for(int i = 0; i<seat_num;i++) {
            if(seat_state[i]==1) {
                t.setRow(i / 10 +1);
                t.setColumn(i % 10+1);
                s += t.getRow() +"排"+t.getColumn()+"列\n";
            }
        }

    }

}

