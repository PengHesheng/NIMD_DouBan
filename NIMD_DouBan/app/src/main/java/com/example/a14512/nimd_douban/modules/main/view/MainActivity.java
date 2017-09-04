package com.example.a14512.nimd_douban.modules.main.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a14512.nimd_douban.R;
import com.example.a14512.nimd_douban.base.BaseActivity;
import com.example.a14512.nimd_douban.modules.book.view.BookFragment;
import com.example.a14512.nimd_douban.modules.movie.view.MovieFragment;
import com.example.a14512.nimd_douban.modules.music.view.MusicFragment;
import com.example.a14512.nimd_douban.utils.customView.SlidingView;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private ImageView img_toolbar;
    private TextView tv_title;
    private AppBarLayout appbarlayout;
    private TextView tv_movie, tv_book, tv_music;
    private LinearLayout activity_main_id;

    private SlidingView slidingView;
    private MovieFragment movieFragment;
    private BookFragment bookFragment;
    private MusicFragment musicFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setStatusBarColor(R.color.mainToolbar);
        img_toolbar = (ImageView) findViewById(R.id.img_toolbar);
        tv_title = (TextView) findViewById(R.id.tv_title);
        appbarlayout = (AppBarLayout) findViewById(R.id.appbarlayout);
        tv_movie = (TextView) findViewById(R.id.tv_movie);
        tv_book = (TextView) findViewById(R.id.tv_book);
        tv_music = (TextView) findViewById(R.id.tv_music);
        activity_main_id = (LinearLayout) findViewById(R.id.activity_main_id);
        slidingView = (SlidingView) findViewById(R.id.sliding_view);

        img_toolbar.setImageResource(R.mipmap.ic_launcher_round);
        tv_title.setText(tv_movie.getText());
        //初始化字体颜色
        tv_movie.setTextColor(this.getResources().getColor(R.color.mainToolbar));
        tv_book.setTextColor(Color.GRAY);
        tv_music.setTextColor(Color.GRAY);

        img_toolbar.setOnClickListener(this);
        tv_book.setOnClickListener(this);
        tv_movie.setOnClickListener(this);
        tv_music.setOnClickListener(this);
        activity_main_id.setOnClickListener(this);

        setDefaultFragment();  //设置默认Fragment
    }

    private void setDefaultFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        movieFragment = new MovieFragment();
        transaction.add(R.id.frame_layout, movieFragment);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        switch (v.getId()) {
            case R.id.img_toolbar:
                slidingView.openMenu();
                break;
            case R.id.tv_movie:
                tv_title.setText(tv_movie.getText());
                tv_movie.setTextColor(this.getResources().getColor(R.color.mainToolbar));
                tv_book.setTextColor(Color.GRAY);
                tv_music.setTextColor(Color.GRAY);
                if (movieFragment == null) {
                    movieFragment = new MovieFragment();
                }
                transaction.replace(R.id.frame_layout, movieFragment);
                break;
            case R.id.tv_book:
                tv_title.setText(tv_book.getText());
                tv_book.setTextColor(this.getResources().getColor(R.color.mainToolbar));
                tv_movie.setTextColor(Color.GRAY);
                tv_music.setTextColor(Color.GRAY);
                if (bookFragment == null) {
                    bookFragment = new BookFragment();
                }
                transaction.replace(R.id.frame_layout, bookFragment);
                break;
            case R.id.tv_music:
                tv_title.setText(tv_music.getText());
                tv_music.setTextColor(this.getResources().getColor(R.color.mainToolbar));
                tv_book.setTextColor(Color.GRAY);
                tv_movie.setTextColor(Color.GRAY);
                if (musicFragment == null) {
                    musicFragment = new MusicFragment();
                }
                transaction.replace(R.id.frame_layout, musicFragment);
                break;
            case R.id.activity_main_id:
                slidingView.closeMenu();
                break;
            default:
                break;
        }
        transaction.commit();
    }
}
