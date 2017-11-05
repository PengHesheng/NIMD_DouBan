package com.example.a14512.nimd_douban.modules.movie.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
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
import com.example.a14512.nimd_douban.utils.customView.MyRecyclerView;

import java.util.ArrayList;

/**
 * @author by 14512 on 2017/9/5.
 */

public class MovieFragment extends BaseFragment implements View.OnClickListener, MovieView{

    private MyRecyclerView inTheatersRecyclerView;
    private MyRecyclerView comingSoonRecyclerView;
    private MyRecyclerView usBoxRecyclerView;
    private MyRecyclerView top250RecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        LinearLayout moreInTheaters = (LinearLayout) view.findViewById(R.id.more_in_theaters);
        inTheatersRecyclerView = (MyRecyclerView) view.findViewById(R.id.in_theaters_recycler_view);
        LinearLayout moreComingSoon = (LinearLayout) view.findViewById(R.id.more_coming_soon);
        comingSoonRecyclerView = (MyRecyclerView) view.findViewById(R.id.coming_soon_recycler_view);
        LinearLayout moreUsBox = (LinearLayout) view.findViewById(R.id.more_us_box);
        usBoxRecyclerView = (MyRecyclerView) view.findViewById(R.id.us_box_recycler_view);
        LinearLayout moreTop250 = (LinearLayout) view.findViewById(R.id.more_top250);
        top250RecyclerView = (MyRecyclerView) view.findViewById(R.id.top250_recycler_view);

        moreComingSoon.setOnClickListener(this);
        moreInTheaters.setOnClickListener(this);
        moreTop250.setOnClickListener(this);
        moreUsBox.setOnClickListener(this);

        initRecyclerView();
        getData();
    }

    private void getData() {
        MoviePresenterImp moviePresenterImp = new MoviePresenterImp(this);
        boolean topLocal = moviePresenterImp.getTopMovieFromLocal();
        if (!topLocal) {
            moviePresenterImp.getTop250(0, 10);
        }
        boolean intheaterLocal = moviePresenterImp.getInTheaterFromLocal();
        if (!intheaterLocal) {
            moviePresenterImp.getInTheaters("重庆");
        }
        boolean comingLocal = moviePresenterImp.getComingFromLocal();
        if (!comingLocal) {
            moviePresenterImp.getComingSoon(0, 10);
        }
        boolean usLocal = moviePresenterImp.getUsBoxFromLocal();
        if (!usLocal) {
            moviePresenterImp.getUSBox();
        }
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getActivity());
        layoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager layoutManager4 = new LinearLayoutManager(getActivity());
        layoutManager4.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager layoutManager5 = new LinearLayoutManager(getActivity());
        layoutManager5.setOrientation(LinearLayoutManager.HORIZONTAL);
        inTheatersRecyclerView.setLayoutManager(layoutManager2);
        comingSoonRecyclerView.setLayoutManager(layoutManager3);
        usBoxRecyclerView.setLayoutManager(layoutManager4);
        top250RecyclerView.setLayoutManager(layoutManager5);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
            default:
                break;
        }
    }

    @Override
    public void setAdapter(ArrayList<Movie> movies, String type) {
        switch (type) {
            case "new_movies":
                break;
            case "in_theaters":
                MovieAdapter inTheatersMovieAdapter = new MovieAdapter();
                inTheatersMovieAdapter.setMovies(movies, 2);
                inTheatersMovieAdapter.notifyDataSetChanged();
                inTheatersRecyclerView.setAdapter(inTheatersMovieAdapter);
                break;
            case "coming_soon":
                MovieAdapter comingSoonMovieAdapter = new MovieAdapter();
                comingSoonMovieAdapter.setMovies(movies, 1);
                comingSoonMovieAdapter.notifyDataSetChanged();
                comingSoonRecyclerView.setAdapter(comingSoonMovieAdapter);
                break;
            case "top250":
                MovieAdapter top250Adapter = new MovieAdapter();
                top250Adapter.setMovies(movies, 2);
                top250Adapter.notifyDataSetChanged();
                top250RecyclerView.setAdapter(top250Adapter);
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
        usBoxRecyclerView.setAdapter(usBoxMovieAdapter);
    }

    @Override
    public void showMovie(MovieDetail movieDetail) {
        //unuse
    }
}
