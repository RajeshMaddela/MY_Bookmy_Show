package com.example.bookmyshow.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookmyshow.MainActivity;
import com.example.bookmyshow.Model.MovieData;
import com.example.bookmyshow.MovieDetailsActivity;
import com.example.bookmyshow.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<MovieData> mContactsList;
    private MainActivity mainActivity;
    private Context mContext;

    public MovieAdapter(List<MovieData> mContactsList, MainActivity mainActivity, Context mContext) {
        this.mContactsList = mContactsList;
        this.mainActivity = mainActivity;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item_list,parent,false);
        return new MovieAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyViewHolder holder, final int position) {
        MovieData chatingDetails = mContactsList.get(position);
        holder.name.setText(chatingDetails.getTitle());
        holder.likePercentage.setText(chatingDetails.getLikePercent().toString()+"%");

        Glide.with(mainActivity.getApplicationContext()).
                load(chatingDetails.getImage()).
                into(holder.imageView);

        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, MovieDetailsActivity.class);
                i.putExtra("IMAGE_NAME",mContactsList.get(position).getImage());
                i.putExtra("TITLE",mContactsList.get(position).getTitle());
                i.putExtra("PERCENTAGE",mContactsList.get(position).getLikePercent().toString());
                i.putExtra("VOTE_COUNT",mContactsList.get(position).getVoteCount().toString());
                i.putExtra("RATING",mContactsList.get(position).getRating().toString());
                i.putExtra("LANGUAGE",mContactsList.get(position).getLanguage());
                i.putExtra("TYPE",mContactsList.get(position).getType());

                mContext.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mContactsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,likePercentage;
        ImageView imageView;
        LinearLayout mLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.country_name);
            imageView = itemView.findViewById(R.id.iv_image);
            mLayout = itemView.findViewById(R.id.ll_main);
            likePercentage = itemView.findViewById(R.id.percentage);
        }
    }
}
