package com.example.a14512.nimd_douban.modules.book.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a14512.nimd_douban.R;
import com.example.a14512.nimd_douban.base.BaseFragment;
import com.example.a14512.nimd_douban.modules.book.model.entity.Book;

import java.util.ArrayList;

/**
 * Created by 14512 on 2017/9/5.
 */

public class BookFragment extends BaseFragment implements BookView {

    private EditText edt_book;
    private RecyclerView book_recycler_view;

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

    }

    private void initView(View view) {
        edt_book = (EditText) view.findViewById(R.id.edt_book);
        book_recycler_view = (RecyclerView) view.findViewById(R.id.book_recycler_view);
    }

    private void submit() {
        // validate
        String book = edt_book.getText().toString().trim();
        if (TextUtils.isEmpty(book)) {
            Toast.makeText(getContext(), "搜索", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
