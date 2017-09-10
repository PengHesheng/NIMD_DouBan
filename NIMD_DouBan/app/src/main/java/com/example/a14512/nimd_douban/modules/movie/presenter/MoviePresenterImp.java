package com.example.a14512.nimd_douban.modules.movie.presenter;

import android.util.Log;

import com.example.a14512.nimd_douban.C;
import com.example.a14512.nimd_douban.modules.movie.model.MovieModelImp;
import com.example.a14512.nimd_douban.modules.movie.model.entity.Movie;
import com.example.a14512.nimd_douban.modules.movie.model.entity.MovieDetail;
import com.example.a14512.nimd_douban.modules.movie.model.entity.USMovie;
import com.example.a14512.nimd_douban.modules.movie.view.MovieView;
import com.example.a14512.nimd_douban.utils.ACache;
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

    private static boolean isACache = false;

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
                ACache.getDefault().put(C.TOP250, movies);
                Log.d("123456", ""+ ACache.getDefault().getAsObject(C.TOP250));
                isACache = true;
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
                ACache.getDefault().put(C.IN_THEATERS, movies);
                isACache = true;
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
                ACache.getDefault().put(C.NEW_MOVIES, movies);
                isACache = true;
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
                ACache.getDefault().put(C.US_BOX, usMovies);
                isACache = true;
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
                ACache.getDefault().put(C.COMING_SOON, movies);
                isACache = true;
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
                movieView.setAdapter(movies, "");
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

    @Override
    public void getMovieFromLocal() {
        Log.d("123456", ""+(ArrayList<Movie>) ACache.getDefault().getAsObject(C.TOP250));
        movieView.setAdapter((ArrayList<Movie>) ACache.getDefault().getAsObject(C.TOP250), C.TOP250);
        movieView.setAdapter((ArrayList<Movie>) ACache.getDefault().getAsObject(C.IN_THEATERS), C.IN_THEATERS);
        movieView.setAdapter((ArrayList<Movie>) ACache.getDefault().getAsObject(C.COMING_SOON), C.COMING_SOON);
        movieView.setUxBoxAdapter((ArrayList<USMovie>) ACache.getDefault().getAsObject(C.US_BOX));
        movieView.setAdapter((ArrayList<Movie>) ACache.getDefault().getAsObject(C.NEW_MOVIES), C.NEW_MOVIES);
    }

    @Override
    public boolean isACache() {
        return false;
    }

}
