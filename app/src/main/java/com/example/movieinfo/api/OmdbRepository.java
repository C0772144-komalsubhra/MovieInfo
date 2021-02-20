package com.example.movieinfo.api;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;


import com.example.movieinfo.models.MovieDetail;
import com.example.movieinfo.models.SearchResult;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OmdbRepository {

    private static final String API_KEY = "94a221d";

    private static OmdbRepository repository;
    private final OmdbApi api;

    private OmdbRepository(OmdbApi api) {
        this.api = api;
    }

    /**
     * Get instance
     *
     * @return OMDB repository
     */
    public static OmdbRepository getInstance() {
        if (repository == null) {
            repository = new OmdbRepository(OmdbClient.getInstance().create(OmdbApi.class));
        }
        return repository;
    }

    /**
     * Search movie
     *
     * @param context {@link Context}
     * @param name    　Search keyword
     */
    public void searchMovie(Context context, String name, OnSuccess<SearchResult> success) {
        Call<SearchResult> call = api.searchMovie(name, API_KEY);
        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                Log.d("success", Objects.requireNonNull(response.body()).toString());
                success.result(response.body());
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                failMessage(context, t);
            }
        });
    }

    /**
     * Get movie information
     *
     * @param context {@link Context}
     * @param imdbID  movie ID
     */
    public void getMovie(Context context, String imdbID, OnSuccess<MovieDetail> success) {
        Call<MovieDetail> call = api.getMovie(imdbID, API_KEY);
        call.enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
                Log.d("success", response.body().toString());
                success.result(response.body());
            }

            @Override
            public void onFailure(Call<MovieDetail> call, Throwable t) {
                Log.w("Fail", t.getMessage());
                failMessage(context, t);
            }
        });
    }

    private void failMessage(Context context, Throwable t) {
        Log.w("Fail", t.getMessage());
        Toast.makeText(context, "Something went wrong... Please try later!",
                Toast.LENGTH_SHORT).show();
    }

}
