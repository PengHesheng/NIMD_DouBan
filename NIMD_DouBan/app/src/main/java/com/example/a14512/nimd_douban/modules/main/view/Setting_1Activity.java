package com.example.a14512.nimd_douban.modules.main.view;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
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

import jp.wasabeef.glide.transformations.BlurTransformation;

public class Setting_1Activity extends BaseSwipeBackActivity {

    private RelativeLayout setting_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        initView();


    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setStatusBarColor(R.color.mainToolbar);
        ImageView back = (ImageView) findViewById(R.id.img_toolbar);
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        ImageView iv_topic = (ImageView) findViewById(R.id.iv_topic);
        setting_layout = (RelativeLayout) findViewById(R.id.setting_layout);

        back.setOnClickListener(v -> finish());
        tv_title.setText("简介");
        Glide.with(this).load(R.mipmap.icon).priority(Priority.HIGH).into(iv_topic);
        Glide.with(this).load(R.mipmap.icon).fitCenter().bitmapTransform(new BlurTransformation(this,25))
                .priority(Priority.LOW)
                .into(new SimpleTarget<GlideDrawable>() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        setting_layout.setBackground(resource);
                    }
                });
    }
}
