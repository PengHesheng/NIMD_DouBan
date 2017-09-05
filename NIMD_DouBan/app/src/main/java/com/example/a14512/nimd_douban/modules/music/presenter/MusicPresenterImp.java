package com.example.a14512.nimd_douban.modules.music.presenter;

import com.example.a14512.nimd_douban.modules.music.model.MusicModelImp;
import com.example.a14512.nimd_douban.modules.music.model.entity.Music;
import com.example.a14512.nimd_douban.modules.music.view.MusicView;
import com.example.a14512.nimd_douban.utils.ToastUtil;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 14512 on 2017/9/5.
 */

public class MusicPresenterImp implements MusicPresenter {

    private MusicView musicView;
    private MusicModelImp musicModel;
    private ArrayList<Music> musics = new ArrayList<>();

    public MusicPresenterImp(MusicView musicView) {
        this.musicView = musicView;
        musicModel = new MusicModelImp();
    }

    @Override
    public void searchMusic() {
        String tag = musicView.getSearchTag();
        Observer<ArrayList<Music>> observer = new Observer<ArrayList<Music>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<Music> value) {
                musics = value;
            }

            @Override
            public void onError(Throwable e) {
                ToastUtil.show("网络请求异常!");
            }

            @Override
            public void onComplete() {
                if (musics != null) {
                    musicView.setAdapter(musics);
                }
            }
        };
        musicModel.getMusicFromNet(observer, tag, "");

    }
}
