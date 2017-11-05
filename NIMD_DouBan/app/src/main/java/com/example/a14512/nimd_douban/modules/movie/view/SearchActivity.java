package com.example.a14512.nimd_douban.modules.movie.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a14512.nimd_douban.R;
import com.example.a14512.nimd_douban.base.BaseSwipeBackActivity;
import com.example.a14512.nimd_douban.modules.movie.adpater.MoreMovieAdapter;
import com.example.a14512.nimd_douban.modules.movie.model.entity.Movie;
import com.example.a14512.nimd_douban.modules.movie.model.entity.MovieDetail;
import com.example.a14512.nimd_douban.modules.movie.model.entity.USMovie;
import com.example.a14512.nimd_douban.modules.movie.presenter.MoviePresenterImp;

import java.util.ArrayList;

/**
 * Created by 14512 on 2017/9/10.
 */

public class SearchActivity extends BaseSwipeBackActivity implements MovieView {
    private EditText edt_movie;
    private RecyclerView recyclerView;
    private MoreMovieAdapter movieAdapter;
    private MoviePresenterImp searchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setStatusBarColor(R.color.mainToolbar);
        ImageView back = (ImageView) findViewById(R.id.img_toolbar);
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        edt_movie = (EditText) findViewById(R.id.edt_movie);
        Button btn_search = (Button) findViewById(R.id.btn_search);
        recyclerView = (RecyclerView) findViewById(R.id.movie_recycler_view);

        tv_title.setText("搜索电影");
        searchPresenter = new MoviePresenterImp(this);
        btn_search.setOnClickListener(v -> submit());
        back.setOnClickListener(v -> finish());

        movieAdapter = new MoreMovieAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

    }

    private void submit() {
        // validate
        String movie = edt_movie.getText().toString().trim();
        if (TextUtils.isEmpty(movie)) {
            Toast.makeText(this, "movie不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        searchPresenter.searchMovie("", edt_movie.getText().toString());
    }

    @Override
    public void setAdapter(ArrayList<Movie> movies, String type) {
        movieAdapter.setMovies(movies, 2);
        recyclerView.setAdapter(movieAdapter);
    }

    @Override
    public void setUxBoxAdapter(ArrayList<USMovie> usMovies) {
        ArrayList<Movie> movies = new ArrayList<>();
        for (USMovie usMovie : usMovies) {
            movies.add(usMovie.getSubject());
        }
        movieAdapter.setMovies(movies, 2);
        recyclerView.setAdapter(movieAdapter);
    }

    @Override
    public void showMovie(MovieDetail movieDetail) {

    }
}
