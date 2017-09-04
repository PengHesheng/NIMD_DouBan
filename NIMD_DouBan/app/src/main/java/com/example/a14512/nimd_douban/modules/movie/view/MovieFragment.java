package com.example.a14512.nimd_douban.modules.movie.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a14512.nimd_douban.R;
import com.example.a14512.nimd_douban.base.BaseFragment;

/**
 * Created by 14512 on 2017/9/5.
 */

public class MovieFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, null);
        return view;
    }
}
