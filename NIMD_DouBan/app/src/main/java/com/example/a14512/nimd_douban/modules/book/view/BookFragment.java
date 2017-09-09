package com.example.a14512.nimd_douban.modules.book.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a14512.nimd_douban.R;
import com.example.a14512.nimd_douban.base.BaseFragment;
import com.example.a14512.nimd_douban.modules.book.adapter.BookAdapter;
import com.example.a14512.nimd_douban.modules.book.model.entity.Book;
import com.example.a14512.nimd_douban.modules.book.presenter.BookPresenterImp;

import java.util.ArrayList;

/**
 * Created by 14512 on 2017/9/5.
 */

public class BookFragment extends BaseFragment implements BookView {

    private EditText edt_book;
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private BookPresenterImp presenterImp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, null);
        initView(view);
        return view;
    }

    @Override
    public String getSearchTag() {
        return edt_book.getText().toString();
    }

    @Override
    public void setAdapter(ArrayList<Book> books) {
        bookAdapter.setBooks(books);
        bookAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(bookAdapter);
    }

    @Override
    public void setBook(Book book) {

    }

    private void initView(View view) {
        edt_book = (EditText) view.findViewById(R.id.edt_book);
        Button search = (Button) view.findViewById(R.id.btn_search);
        recyclerView = (RecyclerView) view.findViewById(R.id.book_recycler_view);

        presenterImp = new BookPresenterImp(this);
        search.setOnClickListener(v -> submit());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        bookAdapter = new BookAdapter();
    }

    private void submit() {
        // validate
        String searchTv = edt_book.getText().toString().trim();
        if (TextUtils.isEmpty(searchTv)) {
            Toast.makeText(getContext(), "输入不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        presenterImp.searchBook();

        // TODO validate success, do something


    }
}
