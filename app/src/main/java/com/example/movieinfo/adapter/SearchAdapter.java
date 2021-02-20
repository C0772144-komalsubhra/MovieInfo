package com.example.movieinfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.movieinfo.R;
import com.example.movieinfo.models.Search;

import java.util.List;

public class SearchAdapter extends ArrayAdapter<Search> {

    private final Context context;
    private final List<Search> searchList;

    public SearchAdapter(Context context, List<Search> searchList) {
        super(context, R.layout.search_item, searchList);
        this.context = context;
        this.searchList = searchList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Search search = searchList.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);

        // set grid item
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.search_item, parent, false);
        }

        // movie poster
        ImageView image = view.findViewById(R.id.item_poster);
        String poster = search.getPoster();
        if (poster != null) {
            new DownloadImageFromInternet(image).execute(poster);
        }

        // movie name
        TextView name = view.findViewById(R.id.item_name);
        name.setText(search.getTitle());

        // movie year
        TextView year = view.findViewById(R.id.item_year);
        year.setText(String.format("Released: %s", search.getYear()));

        return view;
    }


}
