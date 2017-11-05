package com.example.a14512.nimd_douban.modules.movie.presenter;

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

import static com.example.a14512.nimd_douban.C.TOP250;

/**
 * @author by 14512 on 2017/9/5.
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
                if (movies != null) {
                    ACache.getDefault().put(TOP250, movies);
                    movieView.setAdapter(movies, TOP250);
                }
            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.show("网络异常！");
            }

            @Override
            public void onComplete() {

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
                if (movies != null) {
                    ACache.getDefault().put(C.IN_THEATERS, movies);
                    movieView.setAdapter(movies, C.IN_THEATERS);
                }
            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.show("网络异常！");
            }

            @Override
            public void onComplete() {

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
                movies = value;
                if (movies != null) {
                    ACache.getDefault().put(C.NEW_MOVIES, movies);
                    movieView.setAdapter(movies, C.NEW_MOVIES);
                }
            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.show("网络异常！");
            }

            @Override
            public void onComplete() {

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
                if (usMovies != null) {
                    ACache.getDefault().put(C.US_BOX, usMovies);
                    movieView.setUxBoxAdapter(usMovies);
                }
            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.show("网络异常！");
            }

            @Override
            public void onComplete() {

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
                if (movies != null) {
                    ACache.getDefault().put(C.COMING_SOON, movies);
                    movieView.setAdapter(movies, C.COMING_SOON);
                }
            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.show("网络异常！");
            }

            @Override
            public void onComplete() {

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
    public boolean getTopMovieFromLocal() {
        ArrayList<Movie> movies = (ArrayList<Movie>) ACache.getDefault().getAsObject(C.TOP250);
        if (movies != null) {
            movieView.setAdapter(movies, C.TOP250);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean getInTheaterFromLocal() {
        ArrayList<Movie> movies = (ArrayList<Movie>) ACache.getDefault().getAsObject(C.IN_THEATERS);
        if (movies != null) {
            movieView.setAdapter(movies, C.IN_THEATERS);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean getComingFromLocal() {
        ArrayList<Movie> movies = (ArrayList<Movie>) ACache.getDefault().getAsObject(C.COMING_SOON);
        if (movies != null) {
            movieView.setAdapter(movies, C.COMING_SOON);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean getUsBoxFromLocal() {
        ArrayList<USMovie> usMovies = (ArrayList<USMovie>) ACache.getDefault().getAsObject(C.US_BOX);
        if (usMovies != null) {
            movieView.setUxBoxAdapter(usMovies);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean getNewMovieFromLocal() {
        ArrayList<Movie> movies = (ArrayList<Movie>) ACache.getDefault().getAsObject(C.NEW_MOVIES);
        if (movies != null) {
            movieView.setAdapter(movies, C.NEW_MOVIES);
            return true;
        } else {
            return false;
        }
    }
}
