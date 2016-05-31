package com.example.hansity.syyyz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/31.
 */
public class MovieDetail extends Activity {

    private MovieDBHelper movieDB = new MovieDBHelper(this);

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        ImageView movie_pic = (ImageView)findViewById(R.id.movie);
        TextView movie_name = (TextView)findViewById(R.id.movie_name);
        TextView movie_type = (TextView)findViewById(R.id.movie_type);
        TextView movie_time = (TextView)findViewById(R.id.movie_time);
        TextView movie_director = (TextView)findViewById(R.id.movie_director);
        TextView movie_describe = (TextView)findViewById(R.id.movie_describe);
        Button buy_ticket = (Button)findViewById(R.id.buy_ticket);

        final Bundle bundle = this.getIntent().getExtras();
        int movieid = bundle.getInt("movieid");

        Movie movie = movieDB.queryById(movieid);
        movie_pic.setImageBitmap(movie.getMovieImage());
        movie_name.setText(movie.getMovieName());
        movie_type.setText(movie.getMovieType());
        movie_time.setText(String.valueOf(movie.getMovieDuration()) + "分钟");
        movie_director.setText("导演：" + movie.getMovieDirector());
        movie_describe.setText(movie.getMovieDescription());

        buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(MovieDetail.this, SelectTheater.class);
                startActivity(intent);
            }
        });


    }

}
