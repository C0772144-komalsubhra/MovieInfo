package com.example.movieinfo;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.movieinfo.models.MovieDetail;


public class MovieDetailActivity extends AppCompatActivity {

    private ListView listView;
    private MovieDetail movieDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        // action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        movieDetail = (MovieDetail) intent.getSerializableExtra("movieDetail");

        // set title
        this.setTitle(movieDetail.getTitle());

        // List
        listView = findViewById(R.id.item_info);
    }

    private void loadData() {
        // poster
        String poster = movieDetail.getPoster();
        if (poster != null) {
            ImageView image = findViewById(R.id.item_poster);
            new DownloadImageFromInternet(image).execute(poster);
        }

        // info list
        MovieAdapter adapter = new MovieAdapter(this, movieDetail);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
