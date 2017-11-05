package com.example.a14512.nimd_douban.modules.movie.presenter;

/**
 * Created by 14512 on 2017/9/5.
 */

public interface MoviePresenter {
    void getTop250(int start, int count);

    void getInTheaters(String city);

    void getWeekly();

    void getNewMovies();

    void getUSBox();

    void getComingSoon(int start, int count);

    void searchMovie(String q, String tag);

    void getMovieDetail(String id);

    boolean getTopMovieFromLocal();

    boolean getInTheaterFromLocal();

    boolean getComingFromLocal();

    boolean getUsBoxFromLocal();

    boolean getNewMovieFromLocal();


}
