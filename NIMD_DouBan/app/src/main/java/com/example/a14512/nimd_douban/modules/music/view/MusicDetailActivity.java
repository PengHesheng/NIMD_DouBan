package com.example.a14512.nimd_douban.modules.music.view;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.a14512.nimd_douban.R;
import com.example.a14512.nimd_douban.base.BaseSwipeBackActivity;
import com.example.a14512.nimd_douban.modules.main.view.WebActivity;
import com.example.a14512.nimd_douban.modules.music.model.entity.Music;
import com.example.a14512.nimd_douban.modules.music.presenter.MusicPresenterImp;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by 14512 on 2017/9/5.
 */

public class MusicDetailActivity extends BaseSwipeBackActivity implements MusicView{

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
    private RelativeLayout bg_layout;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_detail);
        id = getIntent().getStringExtra("id");
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
        bg_layout = (RelativeLayout) findViewById(R.id.bg_music_layout);

        back.setOnClickListener(v -> finish());

        getData();
    }

    private void getData() {
        MusicPresenterImp musicDetailPresenter = new MusicPresenterImp(this);
        musicDetailPresenter.getMusicDetail(id);
    }


    @Override
    public String getSearchTag() {
        return null;
    }

    @Override
    public void setAdapter(ArrayList<Music> musics) {

    }

    @Override
    public void setMusic(Music music) {
        tv_title.setText(music.getTitle());
        Glide.with(this).load(music.getImage()).priority(Priority.HIGH).into(iv_music);
        Glide.with(this).load(music.getImage()).fitCenter().bitmapTransform(new BlurTransformation(this,25))
                .priority(Priority.LOW)
                .into(new SimpleTarget<GlideDrawable>() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onResourceReady(GlideDrawable resource,
                                                GlideAnimation<? super GlideDrawable> glideAnimation) {
                        bg_layout.setBackground(resource);
                    }
                });
        tv_music_name.setText(music.getTitle());
        tv_music_grade.setText(music.getRating().getAverage());
        tv_music_grade_num.setText("" + music.getRating().getNumRaters());
        tv_music_publishtime.setText(music.getAttrs().getPubdate().get(0));
        tv_music_art.setText(music.getAuthor().get(0).getName());
        tv_more_info.setOnClickListener(v -> startIntentActivity(this, new WebActivity(),
                "alt", music.getAlt(), "title", music.getTitle()));
        tv_songs.setText(music.getAttrs().getTracks().get(0));
    }
}
