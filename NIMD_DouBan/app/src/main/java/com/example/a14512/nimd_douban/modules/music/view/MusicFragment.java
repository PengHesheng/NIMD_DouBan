package com.example.a14512.nimd_douban.modules.music.view;

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
import com.example.a14512.nimd_douban.modules.music.adapter.MusicAdapter;
import com.example.a14512.nimd_douban.modules.music.model.entity.Music;
import com.example.a14512.nimd_douban.modules.music.presenter.MusicPresenterImp;

import java.util.ArrayList;

/**
 * Created by 14512 on 2017/9/5.
 */

public class MusicFragment extends BaseFragment implements MusicView{

    private EditText edt_music;
    private RecyclerView recyclerView;
    private MusicAdapter musicAdapter;
    private  MusicPresenterImp presenterImp;

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
        musicAdapter.setMusics(musics);
        musicAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(musicAdapter);
    }

    @Override
    public void setMusic(Music music) {

    }

    private void initView(View view) {
        edt_music = (EditText) view.findViewById(R.id.edt_music);
        Button btn_search = (Button) view.findViewById(R.id.btn_search);
        recyclerView = (RecyclerView) view.findViewById(R.id.music_recycler_view);

        presenterImp = new MusicPresenterImp(this);
        btn_search.setOnClickListener(v -> submit());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        musicAdapter = new MusicAdapter();
    }

    private void submit() {
        // validate
        String searchTv = edt_music.getText().toString().trim();
        if (TextUtils.isEmpty(searchTv)) {
            Toast.makeText(getContext(), "输入不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        presenterImp.searchMusic();

        // TODO validate success, do something


    }
}
