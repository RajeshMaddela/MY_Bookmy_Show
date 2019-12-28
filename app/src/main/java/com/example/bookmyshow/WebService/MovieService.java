package com.example.bookmyshow.WebService;

import com.example.bookmyshow.Model.MovieData;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MovieService {

    @GET("recyclerview/movies")
    Call<JsonArray> getMovieList();

}
