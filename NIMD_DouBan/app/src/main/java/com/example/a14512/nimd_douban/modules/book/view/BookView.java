package com.example.a14512.nimd_douban.modules.book.view;

import com.example.a14512.nimd_douban.modules.book.model.entity.Book;

import java.util.ArrayList;

/**
 * Created by 14512 on 2017/9/5.
 */

public interface BookView {
    String getSearchTag();

    void setAdapter(ArrayList<Book> books);
}
