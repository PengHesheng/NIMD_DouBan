package com.example.a14512.nimd_douban.modules.movie.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.a14512.nimd_douban.R;
import com.example.a14512.nimd_douban.base.BaseFragment;
import com.example.a14512.nimd_douban.modules.movie.adpater.MovieAdapter;
import com.example.a14512.nimd_douban.modules.movie.model.entity.Movie;
import com.example.a14512.nimd_douban.modules.movie.model.entity.MovieDetail;
import com.example.a14512.nimd_douban.modules.movie.model.entity.USMovie;
import com.example.a14512.nimd_douban.modules.movie.presenter.MoviePresenterImp;

import java.util.ArrayList;

/**
 * Created by 14512 on 2017/9/5.
 */

public class MovieFragment extends BaseFragment implements View.OnClickListener, MovieView {

    private RecyclerView new_movies_recycler_view;
    private RecyclerView in_theaters_recycler_view;
    private RecyclerView coming_soon_recycler_view;
    private RecyclerView us_box_recycler_view;
    private RecyclerView top250_recycler_view;
    private RecyclerView weekly_recycler_view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        LinearLayout more_new_movies = (LinearLayout) view.findViewById(R.id.more_new_movies);
        new_movies_recycler_view = (RecyclerView) view.findViewById(R.id.new_movies_recycler_view);
        LinearLayout more_in_theaters = (LinearLayout) view.findViewById(R.id.more_in_theaters);
        in_theaters_recycler_view = (RecyclerView) view.findViewById(R.id.in_theaters_recycler_view);
        LinearLayout more_coming_soon = (LinearLayout) view.findViewById(R.id.more_coming_soon);
        coming_soon_recycler_view = (RecyclerView) view.findViewById(R.id.coming_soon_recycler_view);
        LinearLayout more_us_box = (LinearLayout) view.findViewById(R.id.more_us_box);
        us_box_recycler_view = (RecyclerView) view.findViewById(R.id.us_box_recycler_view);
        LinearLayout more_top250 = (LinearLayout) view.findViewById(R.id.more_top250);
        top250_recycler_view = (RecyclerView) view.findViewById(R.id.top250_recycler_view);
        LinearLayout more_weekly = (LinearLayout) view.findViewById(R.id.more_weekly);
        weekly_recycler_view = (RecyclerView) view.findViewById(R.id.weekly_recycler_view);

        getData();

        more_coming_soon.setOnClickListener(this);
        more_in_theaters.setOnClickListener(this);
        more_new_movies.setOnClickListener(this);
        more_top250.setOnClickListener(this);
        more_us_box.setOnClickListener(this);
        more_weekly.setOnClickListener(this);

        initRecyclerView();
    }

    private void getData() {
        MoviePresenterImp moviePresenterImp = new MoviePresenterImp(this);
        moviePresenterImp.getTop250(0, 10);
        moviePresenterImp.getComingSoon(0, 10);
        moviePresenterImp.getInTheaters("重庆");
        moviePresenterImp.getNewMovies();
        moviePresenterImp.getUSBox();
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getActivity());
        layoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager layoutManager4 = new LinearLayoutManager(getActivity());
        layoutManager4.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager layoutManager5 = new LinearLayoutManager(getActivity());
        layoutManager5.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager layoutManager6 = new LinearLayoutManager(getActivity());
        layoutManager6.setOrientation(LinearLayoutManager.HORIZONTAL);
        new_movies_recycler_view.setLayoutManager(layoutManager1);
        in_theaters_recycler_view.setLayoutManager(layoutManager2);
        coming_soon_recycler_view.setLayoutManager(layoutManager3);
        us_box_recycler_view.setLayoutManager(layoutManager4);
        top250_recycler_view.setLayoutManager(layoutManager5);
        weekly_recycler_view.setLayoutManager(layoutManager6);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.more_new_movies:
                startIntentActivity(getContext(), new MovieMoreActivity(), "type", "new_movies");
                break;
            case R.id.more_in_theaters:
                startIntentActivity(getContext(), new MovieMoreActivity(), "type", "in_theaters");
                break;
            case R.id.more_coming_soon:
                startIntentActivity(getContext(), new MovieMoreActivity(), "type", "coming_soon");
                break;
            case R.id.more_us_box:
                startIntentActivity(getContext(), new MovieMoreActivity(), "type", "us_box");
                break;
            case R.id.more_top250:
                startIntentActivity(getContext(), new MovieMoreActivity(), "type", "top250");
                break;
            case R.id.more_weekly:
                startIntentActivity(getContext(), new MovieMoreActivity(), "type", "weekly");
                break;
            default:
                break;
        }
    }

    @Override
    public void setAdapter(ArrayList<Movie> movies, String type) {
        switch (type) {
            case "new_movies":
                MovieAdapter newMoviesAdapter = new MovieAdapter();
                newMoviesAdapter.setMovies(movies, 2);
                newMoviesAdapter.notifyDataSetChanged();
                new_movies_recycler_view.setAdapter(newMoviesAdapter);
                break;
            case "in_theaters":
                MovieAdapter inTheatersMovieAdapter = new MovieAdapter();
                inTheatersMovieAdapter.setMovies(movies, 2);
                inTheatersMovieAdapter.notifyDataSetChanged();
                in_theaters_recycler_view.setAdapter(inTheatersMovieAdapter);
                break;
            case "coming_soon":
                MovieAdapter comingSoonMovieAdapter = new MovieAdapter();
                comingSoonMovieAdapter.setMovies(movies, 1);
                comingSoonMovieAdapter.notifyDataSetChanged();
                coming_soon_recycler_view.setAdapter(comingSoonMovieAdapter);
                break;
            case "us_box":
                break;
            case "top250":
                MovieAdapter top250Adapter = new MovieAdapter();
                top250Adapter.setMovies(movies, 2);
                top250Adapter.notifyDataSetChanged();
                top250_recycler_view.setAdapter(top250Adapter);
                break;
            case "weekly":
                break;
            default:
                break;
        }
    }

    @Override
    public void setUxBoxAdapter(ArrayList<USMovie> usMovies) {
        MovieAdapter usBoxMovieAdapter = new MovieAdapter();
        usBoxMovieAdapter.setUsBox(usMovies, 0);
        usBoxMovieAdapter.notifyDataSetChanged();
        us_box_recycler_view.setAdapter(usBoxMovieAdapter);
    }

    @Override
    public void showMovie(MovieDetail movieDetail) {

    }
}
