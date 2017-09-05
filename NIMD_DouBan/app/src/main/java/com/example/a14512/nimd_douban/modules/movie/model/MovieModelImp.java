package com.example.a14512.nimd_douban.modules.movie.model;

import com.example.a14512.nimd_douban.http.RetrofitHelper;
import com.example.a14512.nimd_douban.modules.movie.model.entity.Movie;
import com.example.a14512.nimd_douban.modules.movie.model.entity.MovieDetail;
import com.example.a14512.nimd_douban.modules.movie.model.entity.USMovie;

import java.util.ArrayList;

import io.reactivex.Observer;

/**
 * Created by 14512 on 2017/9/5.
 */

public class MovieModelImp implements MovieModel {

    @Override
    public void getTop250(Observer<ArrayList<Movie>> observer, int start, int count) {
        RetrofitHelper.getInstance().getTop250(start, count).subscribe(observer);
    }

    @Override
    public void getInTheaters(Observer<ArrayList<Movie>> observer, String city) {
        RetrofitHelper.getInstance().getInTheaters(city).subscribe(observer);
    }

    @Override
    public void getWeekly(Observer<ArrayList<Movie>> observer) {
        RetrofitHelper.getInstance().getWeekly().subscribe(observer);
    }

    @Override
    public void getNewMovies(Observer<ArrayList<Movie>> observer) {
        RetrofitHelper.getInstance().getNewMovies().subscribe(observer);
    }

    @Override
    public void getUSBox(Observer<ArrayList<USMovie>> observer) {
        RetrofitHelper.getInstance().getUSBox().subscribe(observer);
    }

    @Override
    public void getComingSoon(Observer<ArrayList<Movie>> observer, int start, int count) {
        RetrofitHelper.getInstance().getComingSoon(start, count).subscribe(observer);
    }

    @Override
    public void searchMovie(Observer<ArrayList<Movie>> observer, String q, String tag) {
        RetrofitHelper.getInstance().searchMovie(q, tag).subscribe(observer);
    }

    @Override
    public void getMovieDetail(Observer<MovieDetail> observer, String id) {
        RetrofitHelper.getInstance().getMovieDetail(id).subscribe(observer);
    }
}
