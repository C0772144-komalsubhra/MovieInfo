package com.example.movieinfo.api;

import com.example.movieinfo.models.MovieDetail;
import com.example.movieinfo.models.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OmdbApi {

    @GET("/")
    Call<SearchResult> searchMovie(@Query("s") String name, @Query("apikey") String apiKey);

    @GET("/")
    Call<MovieDetail> getMovie(@Query("i") String id, @Query("apikey") String apiKey);
}
