package com.example.a14512.nimd_douban.modules.movie.adpater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a14512.nimd_douban.R;
import com.example.a14512.nimd_douban.modules.movie.model.entity.Movie;
import com.example.a14512.nimd_douban.modules.movie.model.entity.USMovie;
import com.example.a14512.nimd_douban.modules.movie.view.MovieDetailActivity;

import java.util.ArrayList;

/**
 * Created by HP on 2017/5/11.
 */

public class MovieAdapter extends RecyclerView.Adapter{

    private ArrayList<Movie> movies;
    private ArrayList<USMovie> usMovies;
    private int flag;  //0 为us_box, 1为coming_soon, 其余为其他的
    private Context context;

    public void setMovies(ArrayList<Movie> movies, int flag) {
        this.movies = movies;
        this.flag = flag;
    }

    public void setUsBox(ArrayList<USMovie> usMovies, int flag) {
        this.usMovies = usMovies;
        this.flag = flag;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, null);
        final MovieHolder movieHolder = new MovieHolder(view);
        movieHolder.movieView.setOnClickListener(v -> {
            if (flag == 0) {
                USMovie usMovie = usMovies.get(movieHolder.getAdapterPosition());
                startActivity(usMovie.getBox(), usMovie.getSubject().getId(), v);
            } else {
                Movie movie = movies.get(movieHolder.getAdapterPosition());
                startActivity(0, movie.getId(), v);
            }
        });
        return movieHolder;
    }

    private void startActivity(int box, String id, View view) {
        Intent intent = new Intent(view.getContext(), MovieDetailActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("box", box);
        view.getContext().startActivity(intent);  //序列化有问题，使用Parceable
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       if (holder instanceof MovieHolder) {
            MovieHolder movieHolder = (MovieHolder) holder;
            if (flag == 0) {
                USMovie usMovie = usMovies.get(position);
                if (usMovie != null) {
                    Glide.with(context).load(usMovie.getSubject().getImages().getSmall()).into(movieHolder.mImageView);
                    movieHolder.title.setText(usMovie.getSubject().getTitleX());
                    movieHolder.usBox.setText("票房：" + usMovie.getBox());
                    movieHolder.wishCount.setVisibility(View.GONE);
                    movieHolder.ratingAverage.setVisibility(View.GONE);
                }
            } else if (flag == 1) {
                Movie movie = movies.get(position);
                if (movie != null) {
                    Glide.with(context).load(movie.getImages().getSmall()).into(movieHolder.mImageView);
                    movieHolder.title.setText(movie.getTitleX());
                    movieHolder.wishCount.setText("想看人数：" + movie.getCollect_count());
                    movieHolder.ratingAverage.setVisibility(View.GONE);
                    movieHolder.usBox.setVisibility(View.GONE);
                }
            } else if (flag == 2) {
                Movie movie = movies.get(position);
                if (movie != null) {
                    Glide.with(context).load(movie.getImages().getSmall()).into(movieHolder.mImageView);
                    movieHolder.title.setText(movie.getTitleX());
                    movieHolder.ratingAverage.setText("评分：" + movie.getRating().getAverage());
                    movieHolder.usBox.setVisibility(View.GONE);
                    movieHolder.wishCount.setVisibility(View.GONE);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        if (flag == 0) {
            return usMovies == null ? 0 : usMovies.size();
        }
        else {
            return movies == null ? 0 : movies.size();
        }
    }

    private class MovieHolder extends RecyclerView.ViewHolder {
        View movieView;
        ImageView mImageView;
        TextView title;
        TextView ratingAverage;
        TextView wishCount;
        TextView usBox;
        MovieHolder(View itemView) {
            super(itemView);
            movieView = itemView;
            mImageView = (ImageView) itemView.findViewById(R.id.img_movie);
            title = (TextView) itemView.findViewById(R.id.tv_title_movie);
            ratingAverage = (TextView) itemView.findViewById(R.id.tv_rating_average_movie);
            wishCount = (TextView) itemView.findViewById(R.id.tv_wish_count_movie);
            usBox = (TextView) itemView.findViewById(R.id.tv_box_us);
        }
    }
}
