package com.example.a14512.nimd_douban.modules.music.model;

import com.example.a14512.nimd_douban.http.RetrofitHelper;
import com.example.a14512.nimd_douban.modules.music.model.entity.Music;

import java.util.ArrayList;

import io.reactivex.Observer;

/**
 * Created by 14512 on 2017/9/5.
 */

public class MusicModelImp implements MusicModel {

    @Override
    public void searchMusic(Observer<ArrayList<Music>> observer, String q, String tag) {
        RetrofitHelper.getInstance().searchMusic(q, tag).subscribe(observer);
    }

    @Override
    public void getMusicDetail(Observer<Music> observer, String id) {
        RetrofitHelper.getInstance().getMusicDetail(id).subscribe(observer);
    }
}
