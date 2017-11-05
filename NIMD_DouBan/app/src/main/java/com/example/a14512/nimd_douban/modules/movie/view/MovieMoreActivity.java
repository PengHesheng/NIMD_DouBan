package com.example.a14512.nimd_douban.modules.movie.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a14512.nimd_douban.C;
import com.example.a14512.nimd_douban.R;
import com.example.a14512.nimd_douban.base.BaseSwipeBackActivity;
import com.example.a14512.nimd_douban.modules.movie.adpater.MoreMovieAdapter;
import com.example.a14512.nimd_douban.modules.movie.model.entity.Movie;
import com.example.a14512.nimd_douban.modules.movie.model.entity.MovieDetail;
import com.example.a14512.nimd_douban.modules.movie.model.entity.USMovie;
import com.example.a14512.nimd_douban.modules.movie.presenter.MoviePresenterImp;

import java.util.ArrayList;

/**
 * Created by 14512 on 2017/9/5.
 */

public class MovieMoreActivity extends BaseSwipeBackActivity implements MovieView {
    private TextView tv_title;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private MoreMovieAdapter movieAdapter;
    private SwipeRefreshLayout refresh;
    private MoviePresenterImp morePresenter;

    private int lastVisibleItem;
    private int addNum = 0;
    private String type;
    private boolean isFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moive_more);
        type = getIntent().getStringExtra("type");
        initView();
    }

    @Override
    public void setAdapter(ArrayList<Movie> movies, String type) {
        switch (type) {
            case "new_movies":
                if (isFirst) {
                    movieAdapter.setMovies(movies, 2);
                    isFirst = false;
                    recyclerView.setAdapter(movieAdapter);
                } else {
                    movieAdapter.addData(movies);
                }
                break;
            case "in_theaters":
                if (isFirst) {
                    movieAdapter.setMovies(movies, 2);
                    isFirst = false;
                    recyclerView.setAdapter(movieAdapter);
                } else {
                    movieAdapter.addData(movies);
                }
                break;
            case "coming_soon":
                if (isFirst) {
                    movieAdapter.setMovies(movies, 2);
                    isFirst = false;
                    recyclerView.setAdapter(movieAdapter);
                } else {
                    movieAdapter.addData(movies);
                }
                break;
            case "us_box":
                break;
            case "top250":
                if (isFirst) {
                    movieAdapter.setMovies(movies, 2);
                    isFirst = false;
                    recyclerView.setAdapter(movieAdapter);
                } else {
                    movieAdapter.addData(movies);
                }
                break;
            case "weekly":
                break;
            default:
                break;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == movieAdapter.getItemCount()) {
                    movieAdapter.changeMoreStatus(MoreMovieAdapter.PULLUP_LOAD_MORE);
                    addNum++;
                    getData(addNum);
                    movieAdapter.changeMoreStatus(MoreMovieAdapter.LOADING_MORE);
                } else {
                    movieAdapter.changeMoreStatus(MoreMovieAdapter.NO_DATA_MORE);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = layoutManager.findLastVisibleItemPosition(); //找到最后一个的位置
            }
        });
    }

    @Override
    public void setUxBoxAdapter(ArrayList<USMovie> usMovies) {
        ArrayList<Movie> movies = new ArrayList<>();
        for (USMovie usMovie : usMovies) {
            movies.add(usMovie.getSubject());
        }
        if (isFirst) {
            movieAdapter.setMovies(movies, 2);
            isFirst = false;
            recyclerView.setAdapter(movieAdapter);
        } else {
            movieAdapter.addData(movies);
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == movieAdapter.getItemCount()) {
                    movieAdapter.changeMoreStatus(MoreMovieAdapter.PULLUP_LOAD_MORE);
                    addNum++;
                    getData(addNum);
                    movieAdapter.changeMoreStatus(MoreMovieAdapter.LOADING_MORE);
                } else {
                    movieAdapter.changeMoreStatus(MoreMovieAdapter.NO_DATA_MORE);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = layoutManager.findLastVisibleItemPosition(); //找到最后一个的位置
            }
        });
    }

    @Override
    public void showMovie(MovieDetail movieDetail) {

    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setStatusBarColor(R.color.mainToolbar);
        ImageView back = (ImageView) findViewById(R.id.img_toolbar);
        tv_title = (TextView) findViewById(R.id.tv_title);
        recyclerView = (RecyclerView) findViewById(R.id.movie_more_recycler);
        refresh = (SwipeRefreshLayout) findViewById(R.id.movie_more_refresh);

        movieAdapter = new MoreMovieAdapter();
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        morePresenter = new MoviePresenterImp(this);
        getData(addNum);

        back.setOnClickListener(v -> finish());
        refresh.setOnRefreshListener(() -> {
            getData(0);
            isFirst = true;
            refresh.setRefreshing(false);
        });
    }

    private void getData(int addNum) {
        switch (type) {
            case C.NEW_MOVIES:
                tv_title.setText(R.string.new_movies);
                morePresenter.getNewMovies();
                break;
            case C.IN_THEATERS:
                tv_title.setText(R.string.in_theaters);
                morePresenter.getInTheaters("重庆");
                break;
            case C.COMING_SOON:
                tv_title.setText(R.string.coming_soon);
                morePresenter.getComingSoon(0, 10 + addNum);
                break;
            case C.US_BOX:
                tv_title.setText(R.string.us_box);
                morePresenter.getUSBox();
                break;
            case C.TOP250:
                tv_title.setText(R.string.top250);
                morePresenter.getTop250(0, 10 + addNum);
                break;
            case C.WEEKLY:
                tv_title.setText(R.string.weekly);
                morePresenter.getWeekly();
                break;
            default:
                break;
        }
    }
}
