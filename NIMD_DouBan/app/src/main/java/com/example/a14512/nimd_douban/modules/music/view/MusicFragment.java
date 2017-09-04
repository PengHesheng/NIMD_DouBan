package com.example.a14512.nimd_douban.modules.music.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.example.a14512.nimd_douban.modules.music.model.entity.Music;

import java.util.ArrayList;

/**
 * Created by 14512 on 2017/9/5.
 */

public class MusicFragment extends BaseFragment implements MusicView, View.OnClickListener {

    private EditText edt_music;
    private Button btn_search;
    private RecyclerView music_recycler_view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, null);
        initView(view);
        return view;
    }

    @Override
    public String getSearchTag() {
        return edt_music.getText().toString();
    }

    @Override
    public void setAdapter(ArrayList<Music> musics) {

    }

    private void initView(View view) {
        edt_music = (EditText) view.findViewById(R.id.edt_music);
        btn_search = (Button) view.findViewById(R.id.btn_search);
        music_recycler_view = (RecyclerView) view.findViewById(R.id.music_recycler_view);

        btn_search.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_search:

                break;
        }
    }

    private void submit() {
        // validate
        String music = edt_music.getText().toString().trim();
        if (TextUtils.isEmpty(music)) {
            Toast.makeText(getContext(), "music不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
