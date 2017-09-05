package com.example.a14512.nimd_douban.modules.movie.model;

import com.example.a14512.nimd_douban.modules.movie.model.entity.Movie;
import com.example.a14512.nimd_douban.modules.movie.model.entity.MovieDetail;
import com.example.a14512.nimd_douban.modules.movie.model.entity.USMovie;

import java.util.ArrayList;

import io.reactivex.Observer;

/**
 * Created by 14512 on 2017/9/5.
 */

public interface MovieModel {
    void getTop250(Observer<ArrayList<Movie>> observer, int start, int count);

    void getInTheaters(Observer<ArrayList<Movie>> observer, String city);

    void getWeekly(Observer<ArrayList<Movie>> observer);

    void getNewMovies(Observer<ArrayList<Movie>> observer);

    void getUSBox(Observer<ArrayList<USMovie>> observer);

    void getComingSoon(Observer<ArrayList<Movie>> observer, int start, int count);

    void searchMovie(Observer<ArrayList<Movie>> observer, String q, String tag);

    void getMovieDetail(Observer<MovieDetail> observer, String id);
}
