package com.example.movieinfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.movieinfo.R;
import com.example.movieinfo.models.MovieDetail;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends ArrayAdapter<MovieAdapter.Contents> {

    private final Context context;
    private final List<Contents> contentsList;

    public MovieAdapter(Context context, MovieDetail movieDetail) {
        super(context, R.layout.movie_item);
        this.context = context;
        this.contentsList = convertContents(movieDetail);
        addAll(contentsList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contents content = contentsList.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);

        // set grid item
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.movie_item, parent, false);
        }

        TextView key = view.findViewById(R.id.key);
        key.setText(content.getKey());

        TextView value = view.findViewById(R.id.value);
        value.setText(content.getValue());

        return view;
    }

    private List<Contents> convertContents(MovieDetail detail) {
        ContentList list = new ContentList();
        list.add("Title", detail.getTitle());
        list.add("Released", detail.getReleased());
        list.add("Runtime", detail.getRuntime());
        list.add("Language", detail.getLanguage());
        list.add("Director", "\n" + detail.getDirector());
        list.add("Writer", "\n" + detail.getWriter());
        list.add("Actors", "\n" + detail.getActors());
        list.add("Plot", "\n" + detail.getPlot());
        list.add("Awards", "\n" + detail.getAwards());
        list.add("Production", "\n" + detail.getProduction());
        return list;
    }

    class Contents {
        private String key;
        private String value;

        Contents(String key, String value) {
            this.key = key;
            this.value = value;
        }

        String getKey() {
            return key;
        }

        String getValue() {
            return value;
        }
    }

    class ContentList extends ArrayList<MovieAdapter.Contents> {

        void add(String key, String value) {
            if (notEmpty(value)) {
                this.add(new Contents(key, value));
            }
        }

        private boolean notEmpty(String str) {
            return str != null && !str.isEmpty();
        }
    }


}
