package com.example.a14512.nimd_douban.modules.music.view;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a14512.nimd_douban.R;
import com.example.a14512.nimd_douban.base.BaseSwipeBackActivity;
import com.example.a14512.nimd_douban.modules.music.model.entity.Music;

/**
 * Created by 14512 on 2017/9/5.
 */

public class MusicDetailActivity extends BaseSwipeBackActivity {

    private Music music;
    private TextView tv_title;
    private TextView tv_right;
    private AppBarLayout appbarlayout;
    private ImageView iv_music;
    private TextView tv_music_name;
    private TextView tv_music_grade;
    private TextView tv_music_art;
    private TextView tv_music_publishtime;
    private TextView tv_music_grade_num;
    private TextView tv_listen;
    private TextView tv_more_info;
    private TextView tv_description;
    private TextView tv_songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_detail);
        initView();
    }


    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setStatusBarColor(R.color.mainToolbar);
        ImageView back = (ImageView) findViewById(R.id.img_toolbar);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_right = (TextView) findViewById(R.id.tv_right);
        appbarlayout = (AppBarLayout) findViewById(R.id.appbarlayout);
        iv_music = (ImageView) findViewById(R.id.iv_music);
        tv_music_name = (TextView) findViewById(R.id.tv_music_name);
        tv_music_grade = (TextView) findViewById(R.id.tv_music_grade);
        tv_music_art = (TextView) findViewById(R.id.tv_music_art);
        tv_music_publishtime = (TextView) findViewById(R.id.tv_music_publishtime);
        tv_music_grade_num = (TextView) findViewById(R.id.tv_music_grade_num);
        tv_listen = (TextView) findViewById(R.id.tv_listen);
        tv_more_info = (TextView) findViewById(R.id.tv_more_info);
        tv_description = (TextView) findViewById(R.id.tv_description);
        tv_songs = (TextView) findViewById(R.id.tv_songs);

        back.setOnClickListener(v -> finish());

        music = new Music();
        music = (Music) getIntent().getSerializableExtra("music");
        showData();
    }

    private void showData() {
        tv_title.setText(music.getTitle());
    }
}
