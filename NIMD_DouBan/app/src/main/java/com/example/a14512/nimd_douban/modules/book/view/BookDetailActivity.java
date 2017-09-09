package com.example.a14512.nimd_douban.modules.book.view;

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
import com.example.a14512.nimd_douban.modules.book.model.entity.Book;
import com.example.a14512.nimd_douban.modules.book.presenter.BookPresenterImp;
import com.example.a14512.nimd_douban.modules.main.view.WebActivity;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by 14512 on 2017/9/5.
 */

public class BookDetailActivity extends BaseSwipeBackActivity implements BookView{

    private TextView tv_title;
    private AppBarLayout appbarlayout;
    private ImageView iv_book;
    private TextView tv_book_name;
    private TextView tv_book_grade;
    private TextView tv_book_art;
    private TextView tv_book_publish_time;
    private TextView tv_book_publish_address;
    private TextView tv_book_grade_num;
    private TextView tv_want_read;
    private TextView tv_more_info;
    private TextView tv_description;
    private TextView tv_author_description;
    private RelativeLayout rl_author;
    private TextView tv_chapters;
    private RelativeLayout bg_layout;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        id = getIntent().getStringExtra("id");
        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setStatusBarColor(R.color.mainToolbar);

        ImageView back = (ImageView) findViewById(R.id.img_toolbar);
        tv_title = (TextView) findViewById(R.id.tv_title);
        appbarlayout = (AppBarLayout) findViewById(R.id.appbarlayout);
        iv_book = (ImageView) findViewById(R.id.iv_book);
        tv_book_name = (TextView) findViewById(R.id.tv_book_name);
        tv_book_grade = (TextView) findViewById(R.id.tv_book_grade);
        tv_book_art = (TextView) findViewById(R.id.tv_book_art);
        tv_book_publish_time = (TextView) findViewById(R.id.tv_book_publish_time);
        tv_book_publish_address = (TextView) findViewById(R.id.tv_book_publish_address);
        tv_book_grade_num = (TextView) findViewById(R.id.tv_book_grade_num);
        tv_want_read = (TextView) findViewById(R.id.tv_want_read);
        tv_more_info = (TextView) findViewById(R.id.tv_more_info);
        tv_description = (TextView) findViewById(R.id.tv_description);
        tv_author_description = (TextView) findViewById(R.id.tv_author_description);
        rl_author = (RelativeLayout) findViewById(R.id.rl_author);
        tv_chapters = (TextView) findViewById(R.id.tv_chapters);
        bg_layout = (RelativeLayout) findViewById(R.id.bg_book_layout);

        back.setOnClickListener(v -> finish());
        getData();
    }

    private void getData() {
        BookPresenterImp bookPresenterImp = new BookPresenterImp(this);
        bookPresenterImp.getBookDetail(id);
    }

    @Override
    public String getSearchTag() {
        return null;
    }

    @Override
    public void setAdapter(ArrayList<Book> books) {

    }

    @Override
    public void setBook(Book book) {
        tv_title.setText(book.getTitle());
        Glide.with(this).load(book.getImage()).priority(Priority.HIGH).into(iv_book);
        Glide.with(this).load(book.getImage()).fitCenter().bitmapTransform(new BlurTransformation(this,25))
                .priority(Priority.LOW)
                .into(new SimpleTarget<GlideDrawable>() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        bg_layout.setBackground(resource);
                    }
                });
        tv_book_name.setText(book.getAlt_title());
        tv_book_grade.setText(book.getRating().getAverage());
        tv_book_grade_num.setText(book.getPrice() + "元");
        tv_book_publish_time.setText(book.getPubdate());
        tv_book_publish_address.setText(book.getPublisher());
        tv_book_art.setText(book.getAuthor().get(0));
        tv_more_info.setOnClickListener(v -> startIntentActivity(this, new WebActivity(), "alt", book.getAlt()));
        tv_description.setText(book.getSummary());
        tv_author_description.setText(book.getAuthor_intro());
        tv_chapters.setText(book.getCatalog());
    }
}
