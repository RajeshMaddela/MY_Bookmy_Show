package com.example.bookmyshow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.bookmyshow.Adapter.MovieAdapter;
import com.example.bookmyshow.Model.MovieData;
import com.example.bookmyshow.WebService.MovieService;
import com.example.bookmyshow.WebService.MovieServiceGenerated;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

  /*  @BindView(R.id.recyclerview)
    RecyclerView lblTitle;*/

    private ArrayList<MovieData> mLstDtls = new ArrayList<MovieData>();
    private Retrofit retrofit;
    private MovieServiceGenerated movieService;
    private MovieService mService;
    private MovieAdapter mAdapter;
    private int id,percentage,voteCount;
    private String imagePath;
    private String title,rating,language,type;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);

        getMoviesFromServer();
    }


    public void getMoviesFromServer() {
        retrofit = new Retrofit.Builder()
                .baseUrl(MovieServiceGenerated.ENDPOINTS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mService = retrofit.create(MovieService.class);
        Call<JsonArray> call = mService.getMovieList();

        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                Log.v("Response", response.toString());

                try {
                    JSONArray mJsonArr = new JSONArray(response.body().toString());

                    for (int i = 0; i < mJsonArr.length(); i++) {
                        JSONObject jsonObject = mJsonArr.getJSONObject(i);
                       // id = jsonObject.getInt("id");
                        imagePath = jsonObject.getString("image");
                        title = jsonObject.getString("title");
                        rating = jsonObject.getString("rating");
                         percentage = jsonObject.getInt("like_percent");
                        voteCount = jsonObject.getInt("vote_count");
                        language = jsonObject.getString("language");
                        type = jsonObject.getString("type");
                        //imagePath = jsonObject.getString("image");

                        mLstDtls.add(new MovieData(1, imagePath, 1, rating, percentage,
                                voteCount, title, language, type));


                         setListAdapter(mLstDtls);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

                Log.v("Response", "Failure");
            }
        });

    }


    private void setListAdapter(ArrayList<MovieData> mLstDtls) {


        MovieAdapter mAdapter = new MovieAdapter(mLstDtls,this,this);
       // RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);

    }
}