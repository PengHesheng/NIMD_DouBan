package com.example.a14512.nimd_douban.modules.book.view;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.a14512.nimd_douban.R;
import com.example.a14512.nimd_douban.base.BaseSwipeBackActivity;
import com.example.a14512.nimd_douban.modules.book.model.entity.Book;

/**
 * Created by 14512 on 2017/9/5.
 */

public class BookDetailActivity extends BaseSwipeBackActivity {

    private Book book;

    private TextView tv_title;
    private AppBarLayout appbarlayout;
    private ImageView iv_music;
    private TextView tv_book_name;
    private TextView tv_book_grade;
    private TextView tv_book_art;
    private TextView tv_book_publishtime;
    private TextView tv_book_publish_address;
    private TextView tv_book_grade_num;
    private TextView tv_want_read;
    private TextView tv_more_info;
    private TextView tv_description;
    private TextView tv_author_description;
    private RelativeLayout rl_author;
    private TextView tv_chapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setStatusBarColor(R.color.mainToolbar);

        ImageView back = (ImageView) findViewById(R.id.img_toolbar);
        tv_title = (TextView) findViewById(R.id.tv_title);
        appbarlayout = (AppBarLayout) findViewById(R.id.appbarlayout);
        iv_music = (ImageView) findViewById(R.id.iv_music);
        tv_book_name = (TextView) findViewById(R.id.tv_book_name);
        tv_book_grade = (TextView) findViewById(R.id.tv_book_grade);
        tv_book_art = (TextView) findViewById(R.id.tv_book_art);
        tv_book_publishtime = (TextView) findViewById(R.id.tv_book_publishtime);
        tv_book_publish_address = (TextView) findViewById(R.id.tv_book_publish_address);
        tv_book_grade_num = (TextView) findViewById(R.id.tv_book_grade_num);
        tv_want_read = (TextView) findViewById(R.id.tv_want_read);
        tv_more_info = (TextView) findViewById(R.id.tv_more_info);
        tv_description = (TextView) findViewById(R.id.tv_description);
        tv_author_description = (TextView) findViewById(R.id.tv_author_description);
        rl_author = (RelativeLayout) findViewById(R.id.rl_author);
        tv_chapters = (TextView) findViewById(R.id.tv_chapters);

        back.setOnClickListener(v -> finish());

        book = new Book();
        book = (Book) getIntent().getSerializableExtra("book");
        showData();
    }

    private void showData() {
        tv_title.setText(book.getTitle());
    }
}
