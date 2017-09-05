package com.example.a14512.nimd_douban.modules.book.model;

import com.example.a14512.nimd_douban.http.RetrofitHelper;
import com.example.a14512.nimd_douban.modules.book.model.entity.Book;

import java.util.ArrayList;

import io.reactivex.Observer;

/**
 * Created by 14512 on 2017/9/5.
 */

public class BookModelImp implements BookModel {
    @Override
    public void getBookFromNet(Observer<ArrayList<Book>> observer, String q, String tag) {
        RetrofitHelper.getInstance().searchBook(q, tag).subscribe(observer);
    }
}
