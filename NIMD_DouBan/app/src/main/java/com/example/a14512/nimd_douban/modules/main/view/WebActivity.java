package com.example.a14512.nimd_douban.modules.main.view;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a14512.nimd_douban.R;
import com.example.a14512.nimd_douban.base.BaseSwipeBackActivity;

/**
 * Created by 14512 on 2017/9/6.
 */

public class WebActivity extends BaseSwipeBackActivity {
    private TextView tv_title;
    private TextView tv_right;
    private AppBarLayout appbarlayout;

    private String alt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        alt = getIntent().getStringExtra("alt");
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
        WebView webview = (WebView) findViewById(R.id.webview);

        back.setOnClickListener(v -> finish());

        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl(alt);
    }
}
