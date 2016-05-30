package com.example.hansity.syyyz;

/**
 * Created by Hansity on 2016/5/28.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import java.text.Format;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;

import org.w3c.dom.Text;


public class MovieAdapter extends ArrayAdapter<Movie> {

    private List<Movie> list;
    private Context context;
    private LayoutInflater listContainer;

    public final class ListItemView{                //�Զ���ؼ�����
        public ImageView pic;
        public TextView name;

    }
    public MovieAdapter (Context con, int resourceId, List<Movie> li) {
        super(con, resourceId, li);
        context = con;
        list = li;
        listContainer = LayoutInflater.from(con);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemView  listItemView = null;

        if (convertView == null) {

            listItemView = new ListItemView();

            convertView = listContainer.inflate(R.layout.movie_format, null);

            listItemView.pic = (ImageView)convertView.findViewById(R.id.imageView);

            listItemView.name = (TextView)convertView.findViewById(R.id.name);

            convertView.setTag(listItemView);

        } else {
            listItemView = (ListItemView)convertView.getTag();
        }
        listItemView.pic.setImageBitmap(list.get(position).getMovieImage());
        listItemView.name.setText(list.get(position).getMovieName());

        return convertView;
    }

}

