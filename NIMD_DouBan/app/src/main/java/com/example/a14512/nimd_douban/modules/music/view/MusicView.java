package com.example.a14512.nimd_douban.modules.music.view;

import com.example.a14512.nimd_douban.modules.music.model.entity.Music;

import java.util.ArrayList;

/**
 * Created by 14512 on 2017/9/5.
 */

public interface MusicView {
    String getSearchTag();

    void setAdapter(ArrayList<Music> musics);
}
