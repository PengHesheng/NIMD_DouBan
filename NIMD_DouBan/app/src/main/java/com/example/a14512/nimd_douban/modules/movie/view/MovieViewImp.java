package com.example.a14512.nimd_douban.modules.movie.view;

import com.example.a14512.nimd_douban.modules.movie.model.entity.Movie;

import java.util.ArrayList;

/**
 * Created by 14512 on 2017/9/5.
 */

public interface MovieViewImp {
    String getSearchTag();

    void setAdapter(ArrayList<Movie> movies);
}
