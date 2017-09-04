package com.example.a14512.nimd_douban.http;

import com.example.a14512.nimd_douban.http.RxUtil.RetrofitServiceManager;
import com.example.a14512.nimd_douban.http.RxUtil.RxUtil;
import com.example.a14512.nimd_douban.modules.book.model.entity.BookObject;
import com.example.a14512.nimd_douban.modules.book.model.entity.Book;
import com.example.a14512.nimd_douban.modules.movie.model.entity.Movie;
import com.example.a14512.nimd_douban.modules.movie.model.entity.MovieDetail;
import com.example.a14512.nimd_douban.modules.movie.model.entity.USMovie;
import com.example.a14512.nimd_douban.modules.movie.model.entity.USMovieSubject;
import com.example.a14512.nimd_douban.modules.music.model.entity.MusicSubject;
import com.example.a14512.nimd_douban.modules.music.model.entity.Music;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by HP on 2017/5/11.
 */

public class RetrofitHelper {
    private ApiService mApiService;

    private RetrofitHelper() {
        mApiService = RetrofitServiceManager
                .getInstance()
                .create(ApiService.class);
    }

    public static RetrofitHelper getInstance() {
        return new RetrofitHelper();
    }

    /**
     * 获取电影列表
     */
    public Observable<ArrayList<Movie>> getTop250(int start, int count) {
        return mApiService.getTop250(start, count)
                .compose(RxUtil.rxSchedulerHelper()).map(movieSubject -> movieSubject.subjects);
    }

    public Observable<ArrayList<Movie>> getInTheaters(String city) {
        return mApiService.getInTheaters(city).
                compose(RxUtil.rxSchedulerHelper()).map(movieSubject -> movieSubject.subjects);
    }

    public Observable<ArrayList<Movie>> getWeekly() {
        return mApiService.getWeekly()
                .compose(RxUtil.rxSchedulerHelper()).map(movieSubject -> movieSubject.subjects);
    }

    public Observable<ArrayList<Movie>> getNewMovies() {
        return mApiService.getNewMovies()
                .compose(RxUtil.rxSchedulerHelper()).map(movieSubject -> movieSubject.subjects);
    }

    public Observable<ArrayList<Movie>> getComingSoon(int start, int count) {
        return mApiService.getComingSoon(start, count)
                .compose(RxUtil.rxSchedulerHelper()).map(movieSubject -> movieSubject.subjects);
    }

    public Observable<ArrayList<Movie>> searchMovie(String q, String tag) {
        return mApiService.searchMovie(q, tag)
                .compose(RxUtil.rxSchedulerHelper()).map(movieSubject -> movieSubject.subjects);
    }

    public Observable<ArrayList<USMovie>> getUSBox() {
        return mApiService.getUsBox()
                .compose(RxUtil.rxSchedulerHelper()).map(USMovieSubject::getSubjects);
    }


    public Observable<MovieDetail> getMovieDetail(String id) {
        return mApiService.getMovieDetail(id)
                .compose(RxUtil.rxSchedulerHelper());
    }

    /**
     * 获取图书
     *
     */
    public Observable<ArrayList<Book>> searchBook(String q, String tag) {
        return mApiService.searchBook(q, tag)
                .compose(RxUtil.rxSchedulerHelper()).map(BookObject::getBooks);
    }

    public Observable<Book> getBookDetial(String id) {
        return mApiService.getBookDetail(id).compose(RxUtil.rxSchedulerHelper());
    }

    /**
    * 获取音乐
    */
    public Observable<ArrayList<Music>> searchMusic(String q, String tag) {
        return mApiService.searchMusic(q, tag)
                .compose(RxUtil.rxSchedulerHelper()).map(MusicSubject::getMusics);
    }

    public Observable<Music> getMusicDetail(String id) {
        return mApiService.getMusicDetail(id).compose(RxUtil.rxSchedulerHelper());
    }


}
