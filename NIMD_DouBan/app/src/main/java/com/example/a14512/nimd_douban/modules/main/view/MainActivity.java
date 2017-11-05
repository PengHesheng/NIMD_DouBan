package com.example.a14512.nimd_douban.modules.main.view;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a14512.nimd_douban.R;
import com.example.a14512.nimd_douban.base.BaseActivity;
import com.example.a14512.nimd_douban.modules.book.view.BookFragment;
import com.example.a14512.nimd_douban.modules.login.LoginActivity;
import com.example.a14512.nimd_douban.modules.movie.view.MovieFragment;
import com.example.a14512.nimd_douban.modules.movie.view.SearchActivity;
import com.example.a14512.nimd_douban.modules.music.view.MusicFragment;
import com.example.a14512.nimd_douban.utils.ToastUtil;
import com.example.a14512.nimd_douban.utils.customView.SlidingView;

import jp.wasabeef.glide.transformations.CropCircleTransformation;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private ImageView img_toolbar;
    private TextView tv_title;
    private TextView tv_movie, tv_book, tv_music;

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
        tv_movie = (TextView) findViewById(R.id.tv_movie);
        tv_book = (TextView) findViewById(R.id.tv_book);
        tv_music = (TextView) findViewById(R.id.tv_music);
        LinearLayout activity_main_id = (LinearLayout) findViewById(R.id.activity_main_id);
        slidingView = (SlidingView) findViewById(R.id.sliding_view);
        ImageButton head_portrait = (ImageButton) findViewById(R.id.head_portrait);
        TextView tv_right = (TextView) findViewById(R.id.tv_right);
        TextView tv_login = (TextView) findViewById(R.id.tv_login);


        Glide.with(this).load(R.mipmap.icon)
                .bitmapTransform(new CropCircleTransformation(this))
                .into(img_toolbar);
        tv_title.setText("逗伴");
        tv_right.setText("搜索");
        //初始化字体颜色
        tv_movie.setTextColor(this.getResources().getColor(R.color.mainToolbar));
        tv_book.setTextColor(Color.GRAY);
        tv_music.setTextColor(Color.GRAY);

        tv_book.setOnClickListener(this);
        tv_movie.setOnClickListener(this);
        tv_music.setOnClickListener(this);
        img_toolbar.setOnClickListener(v -> slidingView.changeMenu());
        activity_main_id.setOnClickListener(v -> slidingView.closeMenu());
        head_portrait.setOnClickListener(v -> startIntentActivity(this, new LoginActivity()));
        tv_right.setOnClickListener(v -> startIntentActivity(this, new SearchActivity()));
        tv_login.setOnClickListener(v -> startIntentActivity(this, new LoginActivity()));

        setDefaultFragment();  //设置默认Fragment
    }

    private void setDefaultFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        movieFragment = new MovieFragment();
        transaction.add(R.id.frame_layout, movieFragment);
        transaction.commit();
    }

    //集中处理Fragment的逻辑
    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        switch (v.getId()) {
            case R.id.tv_movie:
                tv_movie.setTextColor(this.getResources().getColor(R.color.mainToolbar));
                tv_book.setTextColor(Color.GRAY);
                tv_music.setTextColor(Color.GRAY);
                if (movieFragment == null) {
                    movieFragment = new MovieFragment();
                }
                transaction.replace(R.id.frame_layout, movieFragment);
                break;
            case R.id.tv_book:
                tv_book.setTextColor(this.getResources().getColor(R.color.mainToolbar));
                tv_movie.setTextColor(Color.GRAY);
                tv_music.setTextColor(Color.GRAY);
                if (bookFragment == null) {
                    bookFragment = new BookFragment();
                }
                transaction.replace(R.id.frame_layout, bookFragment);
                break;
            case R.id.tv_music:
                tv_music.setTextColor(this.getResources().getColor(R.color.mainToolbar));
                tv_book.setTextColor(Color.GRAY);
                tv_movie.setTextColor(Color.GRAY);
                if (musicFragment == null) {
                    musicFragment = new MusicFragment();
                }
                transaction.replace(R.id.frame_layout, musicFragment);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    public void click_1(View view) {
        startIntentActivity(this, new Setting_1Activity());
    }

    public void click_2(View view) {
        ToastUtil.show("期待与你下次的相遇！");
    }

}
