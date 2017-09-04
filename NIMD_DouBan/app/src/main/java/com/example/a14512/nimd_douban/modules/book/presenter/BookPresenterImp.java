package com.example.a14512.nimd_douban.modules.book.presenter;

import com.example.a14512.nimd_douban.modules.book.model.BookModelImp;
import com.example.a14512.nimd_douban.modules.book.view.BookView;

/**
 * Created by 14512 on 2017/9/5.
 */

public class BookPresenterImp implements BookPresenter {

    private BookView bookView;
    private BookModelImp bookModel;

    public BookPresenterImp(BookView bookView) {
        this.bookView = bookView;
        bookModel = new BookModelImp();
    }


    @Override
    public void getBookFromNetWork() {

    }
}
