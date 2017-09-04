package com.example.a14512.nimd_douban.modules.music.presenter;

import com.example.a14512.nimd_douban.modules.music.model.MusicModelImp;
import com.example.a14512.nimd_douban.modules.music.view.MusicView;

/**
 * Created by 14512 on 2017/9/5.
 */

public class MusicPresenterImp implements MusicPresenter {

    private MusicView musicView;
    private MusicModelImp musicModel;

    public MusicPresenterImp(MusicView musicView) {
        this.musicView = musicView;
        musicModel = new MusicModelImp();
    }

    @Override
    public void getMusicFromNet() {

    }
}
