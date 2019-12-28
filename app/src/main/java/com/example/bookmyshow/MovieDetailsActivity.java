package com.example.bookmyshow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetailsActivity extends AppCompatActivity {

    private TextView tvName,tvPercentage,vote_count,rating,format,language;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        ImageView img = findViewById(R.id.iv_image);
        vote_count = findViewById(R.id.vote);
        format = findViewById(R.id.format);
        language = findViewById(R.id.language);

        tvName = findViewById(R.id.title);
        tvPercentage = findViewById(R.id.percentage);
        rating = findViewById(R.id.rating);

        Intent intent = getIntent();

        String image = intent.getStringExtra("IMAGE_NAME");
        String name = intent.getStringExtra("TITLE");
        String percentage = intent.getStringExtra("PERCENTAGE");
        String votecount = intent.getStringExtra("VOTE_COUNT");
        String rating_pos = intent.getStringExtra("RATING");
        String langua = intent.getStringExtra("LANGUAGE");
        String type = intent.getStringExtra("TYPE");

        tvName.setText(name);
        tvPercentage.setText(percentage+"%");
        vote_count.setText(votecount+"votes");
        rating.setText(rating_pos);
        language.setText(langua);
        format.setText(type);


        Glide.with(MovieDetailsActivity.this).
                load(image).
                into(img);
    }
}
