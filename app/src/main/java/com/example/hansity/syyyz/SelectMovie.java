package com.example.hansity.syyyz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hansity on 2016/5/29.
 */



public class SelectMovie extends Activity {
    private List<Movie> movieList = new ArrayList<Movie>();
    private MovieAdapter listViewAdapter;
    private MovieDBHelper movieDB = new MovieDBHelper(this);

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_list);

        movieList = movieDB.queryAll();
        listViewAdapter = new MovieAdapter(this, R.layout.movie_format, movieList);
        ListView listview = (ListView)findViewById(R.id.movie_list);
        listview.setAdapter(listViewAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View view, int position, long id){
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                Movie movie = movieList.get(position);
                bundle.putInt("movieid", movie.getMovieId());
                intent.putExtras(bundle);
                intent.setClass(SelectMovie.this, MovieDetail.class);
                startActivity(intent);
            }
        });
    }
}


