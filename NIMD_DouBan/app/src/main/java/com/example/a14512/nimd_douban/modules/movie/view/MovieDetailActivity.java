package com.example.a14512.nimd_douban.modules.movie.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a14512.nimd_douban.R;
import com.example.a14512.nimd_douban.base.BaseSwipeBackActivity;
import com.example.a14512.nimd_douban.modules.main.view.WebActivity;
import com.example.a14512.nimd_douban.modules.movie.model.entity.Movie;
import com.example.a14512.nimd_douban.modules.movie.model.entity.MovieDetail;
import com.example.a14512.nimd_douban.modules.movie.model.entity.USMovie;
import com.example.a14512.nimd_douban.modules.movie.presenter.MoviePresenterImp;

import java.util.ArrayList;

/**
 * Created by 14512 on 2017/8/29.
 */

public class MovieDetailActivity extends BaseSwipeBackActivity implements MovieView {
    private TextView tv_title;
    private ImageView iv_film;
    private TextView tv_rating;
    private TextView tv_rating_num;
    private TextView tv_date_and_film_time;
    private TextView tv_film_type;
    private TextView tv_film_country;
    private TextView tv_film_name;
    private TextView tv_description;
    private TextView tv_more_info;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);
        id = getIntent().getStringExtra("id");
        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setStatusBarColor(R.color.mainToolbar);
        ImageView img_toolbar = (ImageView) findViewById(R.id.img_toolbar);
        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_film = (ImageView) findViewById(R.id.iv_film);
        tv_rating = (TextView) findViewById(R.id.tv_rating);
        tv_rating_num = (TextView) findViewById(R.id.tv_rating_num);
        tv_date_and_film_time = (TextView) findViewById(R.id.tv_date_and_film_time);
        tv_film_type = (TextView) findViewById(R.id.tv_film_type);
        tv_film_country = (TextView) findViewById(R.id.tv_film_country);
        tv_film_name = (TextView) findViewById(R.id.tv_film_name);
        tv_description = (TextView) findViewById(R.id.tv_description);
        tv_more_info = (TextView) findViewById(R.id.tv_more_info);

        getData();

        img_toolbar.setOnClickListener(v -> finish());

    }

    private void getData() {
        MoviePresenterImp movieDetail = new MoviePresenterImp(this);
        movieDetail.getMovieDetail(id);
    }

    @Override
    public void setAdapter(ArrayList<Movie> movies, String type) {

    }

    @Override
    public void setUxBoxAdapter(ArrayList<USMovie> usMovies) {

    }

    @Override
    public void showMovie(MovieDetail movieDetail) {
        tv_title.setText(movieDetail.getTitle());
        Glide.with(this).load(movieDetail.getImages().getSmall()).into(iv_film);
        tv_rating.setText("评分：" + movieDetail.getRating().getAverage());
        tv_rating_num.setText(movieDetail.getRatings_count() +"人评分");
        tv_film_name.setText(movieDetail.getOriginal_title());
        tv_date_and_film_time.setText(movieDetail.getYear() + "年");
        StringBuilder filmType = new StringBuilder();
        for (String string : movieDetail.getGenres()) {
            filmType = filmType.append(string).append("/");
        }
        tv_film_type.setText(filmType);
        tv_film_country.setText(movieDetail.getCountries().get(0));
        tv_description.setText(movieDetail.getSummary());
        tv_more_info.setOnClickListener(v -> startIntentActivity(this, new WebActivity(),
                        "alt", movieDetail.getAlt(), "title", movieDetail.getTitle()));
    }
}
