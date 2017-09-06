package com.example.a14512.nimd_douban.modules.movie.view;

import com.example.a14512.nimd_douban.modules.movie.model.entity.Movie;
import com.example.a14512.nimd_douban.modules.movie.model.entity.MovieDetail;
import com.example.a14512.nimd_douban.modules.movie.model.entity.USMovie;

import java.util.ArrayList;

/**
 * Created by 14512 on 2017/9/5.
 */

public interface MovieView {
    void setAdapter(ArrayList<Movie> movies, String type);

    void setUxBoxAdapter(ArrayList<USMovie> usMovies);

    void showMovie(MovieDetail movieDetail);
}
