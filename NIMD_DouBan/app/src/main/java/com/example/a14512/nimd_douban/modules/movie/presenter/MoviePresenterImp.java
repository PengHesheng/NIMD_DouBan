package com.example.a14512.nimd_douban.modules.movie.presenter;

import android.util.Log;

import com.example.a14512.nimd_douban.C;
import com.example.a14512.nimd_douban.modules.movie.model.MovieModelImp;
import com.example.a14512.nimd_douban.modules.movie.model.entity.Movie;
import com.example.a14512.nimd_douban.modules.movie.model.entity.MovieDetail;
import com.example.a14512.nimd_douban.modules.movie.model.entity.USMovie;
import com.example.a14512.nimd_douban.modules.movie.view.MovieView;
import com.example.a14512.nimd_douban.utils.ToastUtil;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 14512 on 2017/9/5.
 */

public class MoviePresenterImp implements MoviePresenter {

    private MovieView movieView;
    private MovieModelImp modelImp;
    private ArrayList<Movie> movies;
    private ArrayList<USMovie> usMovies = new ArrayList<>();
    private MovieDetail movieDetail;

    public MoviePresenterImp(MovieView movieView) {
        this.movieView = movieView;
        modelImp = new MovieModelImp();
    }

    @Override
    public void getTop250(int start, int count) {
        movies = new ArrayList<>();
        Observer<ArrayList<Movie>> observer = new Observer<ArrayList<Movie>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<Movie> value) {
                movies = value;
            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.show("网络异常！");
            }

            @Override
            public void onComplete() {
                movieView.setAdapter(movies, C.TOP250);
            }
        };
        modelImp.getTop250(observer, start, count);
    }

    @Override
    public void getInTheaters(String city) {
        movies = new ArrayList<>();
        Observer<ArrayList<Movie>> observer = new Observer<ArrayList<Movie>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<Movie> value) {
                movies = value;
            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.show("网络异常！");
            }

            @Override
            public void onComplete() {
                movieView.setAdapter(movies, C.IN_THEATERS);
            }
        };
        modelImp.getInTheaters(observer, city);
    }

    @Override
    public void getWeekly() {

    }

    @Override
    public void getNewMovies() {
        movies = new ArrayList<>();
        Observer<ArrayList<Movie>> observer = new Observer<ArrayList<Movie>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<Movie> value) {
                Log.d("123456MP", ""+value.get(0).getTitleX());
                movies = value;
            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.show("网络异常！");
            }

            @Override
            public void onComplete() {
                movieView.setAdapter(movies, C.NEW_MOVIES);
            }
        };
        modelImp.getNewMovies(observer);
    }

    @Override
    public void getUSBox() {
        usMovies = new ArrayList<>();
        Observer<ArrayList<USMovie>> observer = new Observer<ArrayList<USMovie>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<USMovie> value) {
                usMovies = value;
            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.show("网络异常！");
            }

            @Override
            public void onComplete() {
                movieView.setUxBoxAdapter(usMovies);
            }
        };
        modelImp.getUSBox(observer);
    }

    @Override
    public void getComingSoon(int start, int count) {
        movies = new ArrayList<>();
        Observer<ArrayList<Movie>> observer = new Observer<ArrayList<Movie>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<Movie> value) {
                movies = value;
            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.show("网络异常！");
            }

            @Override
            public void onComplete() {
                movieView.setAdapter(movies, C.COMING_SOON);
            }
        };
        modelImp.getComingSoon(observer, start, count);
    }

    @Override
    public void searchMovie(String q, String tag) {
        movies = new ArrayList<>();
        Observer<ArrayList<Movie>> observer = new Observer<ArrayList<Movie>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<Movie> value) {
                movies = value;
            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.show("网络异常！");
            }

            @Override
            public void onComplete() {

            }
        };
        modelImp.searchMovie(observer, q, tag);
    }

    @Override
    public void getMovieDetail(String id) {
        movieDetail = new MovieDetail();
        Observer<MovieDetail> observer = new Observer<MovieDetail>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MovieDetail value) {
                movieDetail = value;
            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.show("网络异常！");
            }

            @Override
            public void onComplete() {
                movieView.showMovie(movieDetail);
            }
        };
        modelImp.getMovieDetail(observer, id);
    }

}
