package com.example.a14512.nimd_douban.http;

import com.example.a14512.nimd_douban.modules.book.model.entity.Book;
import com.example.a14512.nimd_douban.modules.book.model.entity.BookObject;
import com.example.a14512.nimd_douban.modules.movie.model.MovieSubject;
import com.example.a14512.nimd_douban.modules.movie.model.entity.Movie;
import com.example.a14512.nimd_douban.modules.movie.model.entity.MovieDetail;
import com.example.a14512.nimd_douban.modules.movie.model.entity.USMovieSubject;
import com.example.a14512.nimd_douban.modules.music.model.entity.MusicSubject;
import com.example.a14512.nimd_douban.modules.music.model.entity.Music;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 定义一个接口，包含多个Api，简化代码
 * Created by HP on 2017/5/11.
 */

public interface ApiService {

    String BASE_URL = "https://api.douban.com/v2/";

    /**
     * 电影Api
     * */
    @GET("movie/top250")
    Observable<MovieSubject<Movie>> getTop250(@Query("start") int start, @Query("count") int count);

    @GET("movie/in_theaters")
    Observable<MovieSubject<Movie>> getInTheaters(@Query("city") String city);

    @GET("movie/us_box")
    Observable<USMovieSubject> getUsBox();

    @GET("movie/weekly")
    Observable<MovieSubject<Movie>> getWeekly();

    @GET("movie/new_movies")
    Observable<MovieSubject<Movie>> getNewMovies();

    @GET("movie/coming_soon")
    Observable<MovieSubject<Movie>> getComingSoon(@Query("start") int start, @Query("count") int count);

    @GET("movie/subject/{id}")
    Observable<MovieDetail> getMovieDetail(@Path("id") String id);

    @GET("movie/search")
    Observable<MovieSubject<Movie>> searchMovie(@Query("q") String q, @Query("tag") String tag);

    /**
     * 图书Api
     * */
    @GET("book/search")
    Observable<BookObject> searchBook(@Query("q") String q, @Query("tag") String tag);

    @GET("book/{id}")
    Observable<Book> getBookDetail(@Path("id") String id);

    /**
     * 音乐Api
     * */
    @GET("music/search")
    Observable<MusicSubject> searchMusic(@Query("q") String q, @Query("tag") String tag);

    @GET("music/{id}")
    Observable<Music> getMusicDetail(@Path("id") String id);

}
