package com.example.a14512.nimd_douban.modules.movie.adpater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a14512.nimd_douban.R;
import com.example.a14512.nimd_douban.modules.movie.model.entity.Movie;
import com.example.a14512.nimd_douban.modules.movie.model.entity.USMovie;
import com.example.a14512.nimd_douban.modules.movie.view.MovieDetailActivity;

import java.util.ArrayList;

/**
 * Created by 14512 on 2017/9/5.
 */

public class MoreMovieAdapter extends RecyclerView.Adapter {

    private ArrayList<Movie> movies;
    private ArrayList<USMovie> usMovies;
    private int flag;  //0 为us_box, 其余为其他的
    private Context context;

    private int Last_Item_state = 99;
    //上拉加载更多
    public static final int PULLUP_LOAD_MORE = 100;
    //正在加载中
    public static final int LOADING_MORE = 101;
    //没有更多了
    public static final int NO_DATA_MORE = 102;

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
        if (viewType == Last_Item_state) {
            return new BottomHolder(LayoutInflater.from(context).inflate(R.layout.item_recycler_bottom, null));
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_movie_more, null);
            final MovieHolder movieHolder = new MovieHolder(view);
            movieHolder.movieView.setOnClickListener(v -> {
                if (flag == 0) {
                    USMovie usMovie = usMovies.get(movieHolder.getAdapterPosition());
                    startActivity(usMovie.getBox(), usMovie.getSubject().getId(), v);
                } else if (flag == 2){
                    Movie movie = movies.get(movieHolder.getAdapterPosition());
                    startActivity(0, movie.getId(), v);
                }
            });
            return movieHolder;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position+1 == getItemCount()){
            return Last_Item_state;
        } else {
            return 0;
        }
    }

    private void startActivity(int box, String id, View view) {
        Intent intent = new Intent(view.getContext(), MovieDetailActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("box", box);
        view.getContext().startActivity(intent);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BottomHolder) {
            BottomHolder bottomHolder = (BottomHolder) holder;
            switch (Last_Item_state){
                case PULLUP_LOAD_MORE:
                    bottomHolder.hintText.setText("上拉加载更多...");
                    bottomHolder.progressBar.setVisibility(View.VISIBLE);
                    break;
                case LOADING_MORE:
                    bottomHolder.hintText.setText("正在加载中...");
                    bottomHolder.progressBar.setVisibility(View.VISIBLE);
                    break;
                case NO_DATA_MORE:
                    bottomHolder.hintText.setText("----我是有底线的----");
                    bottomHolder.progressBar.setVisibility(View.GONE);
                    break;
            }
        } else if (holder instanceof MovieHolder) {
            MovieHolder movieHolder = (MovieHolder) holder;
            if (flag == 0) {
                USMovie usMovie = usMovies.get(position);
                if (usMovie != null) {
                    Glide.with(context).load(usMovie.getSubject().getImages().getSmall()).into(movieHolder.mImageView);
                    movieHolder.title.setText(usMovie.getSubject().getTitleX());
                    movieHolder.ratingAverage.setText("评分：" + usMovie.getSubject().getRating().getAverage());
                    movieHolder.englishTitle.setText(usMovie.getSubject().getOriginal_title());
                    movieHolder.usBox.setText("票房：" + usMovie.getBox());
                }
            } else {
                Movie movie = movies.get(position);
                if (movie != null) {
                    Glide.with(context).load(movie.getImages().getSmall()).into(movieHolder.mImageView);
                    movieHolder.title.setText(movie.getTitleX());
                    movieHolder.ratingAverage.setText("评分：" + movie.getRating().getAverage());
                    movieHolder.englishTitle.setText(movie.getOriginal_title());
                    movieHolder.usBox.setVisibility(View.GONE);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        if (flag == 0) {
            return usMovies.size();
        }
        else {
            return movies.size();
        }
    }

    private class MovieHolder extends RecyclerView.ViewHolder {
        View movieView;
        ImageView mImageView;
        TextView title;
        TextView ratingAverage;
        TextView englishTitle;
        TextView usBox;
        MovieHolder(View itemView) {
            super(itemView);
            movieView = itemView;
            mImageView = (ImageView) itemView.findViewById(R.id.iv_film);
            title = (TextView) itemView.findViewById(R.id.tv_film);
            ratingAverage = (TextView) itemView.findViewById(R.id.tv_film_grade);
            englishTitle = (TextView) itemView.findViewById(R.id.tv_film_english);
            usBox = (TextView) itemView.findViewById(R.id.tv_film_box);
        }
    }

    private class BottomHolder extends RecyclerView.ViewHolder {
        ProgressBar progressBar;
        TextView hintText;

        public BottomHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.recycler_bottom_progress);
            hintText = (TextView) itemView.findViewById(R.id.recycler_bottom_text);
        }
    }

    public void changeMoreStatus(int status) {
        Last_Item_state= status;
    }

    public void addData(ArrayList<Movie> movies) {
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }
}
