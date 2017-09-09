package com.example.a14512.nimd_douban.modules.book.presenter;

import com.example.a14512.nimd_douban.modules.book.model.BookModelImp;
import com.example.a14512.nimd_douban.modules.book.model.entity.Book;
import com.example.a14512.nimd_douban.modules.book.view.BookView;
import com.example.a14512.nimd_douban.utils.ToastUtil;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 14512 on 2017/9/5.
 */

public class BookPresenterImp implements BookPresenter {

    private BookView bookView;
    private BookModelImp bookModel;
    private ArrayList<Book> books;
    private Book book;

    public BookPresenterImp(BookView bookView) {
        this.bookView = bookView;
        bookModel = new BookModelImp();
    }


    @Override
    public void searchBook() {
        String tag = bookView.getSearchTag();
        Observer<ArrayList<Book>> observer = new Observer<ArrayList<Book>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<Book> value) {
                books = value;
            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.show("网络请求异常!");
            }

            @Override
            public void onComplete() {
                if (books != null) {
                    bookView.setAdapter(books);
                }
            }
        };
        bookModel.searchBook(observer, tag, "");
    }

    @Override
    public void getBookDetail(String id) {
        book = new Book();
        Observer<Book> observer = new Observer<Book>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Book value) {
                book = value;
            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.show("网络请求异常!");
            }

            @Override
            public void onComplete() {
                bookView.setBook(book);
            }
        };
        bookModel.getBookDetail(observer, id);
    }

}
