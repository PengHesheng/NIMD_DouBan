package com.example.a14512.nimd_douban.modules.music.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a14512.nimd_douban.R;
import com.example.a14512.nimd_douban.modules.music.model.entity.Music;
import com.example.a14512.nimd_douban.modules.music.view.MusicDetailActivity;

import java.util.ArrayList;

/**
 * Created by 14512 on 2017/9/5.
 */

public class MusicAdapter extends RecyclerView.Adapter {

    private ArrayList<Music> musics;
    private Context context;

    private int Last_Item_state = 99;
    //上拉加载更多
    public static final int PULLUP_LOAD_MORE = 100;
    //正在加载中
    public static final int LOADING_MORE = 101;
    //没有更多了
    public static final int NO_DATA_MORE = 102;

    public void setMusics(ArrayList<Music> musics) {
        this.musics = musics;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        if (viewType == Last_Item_state) {
            return new BottomHolder(LayoutInflater.from(context).inflate(R.layout.item_recycler_bottom, null));
        } else {
            View view = LayoutInflater.from(context)
                    .inflate(R.layout.item_music, null);
            final MusicHolder musicHolder = new MusicHolder(view);
            musicHolder.musicView.setOnClickListener(v -> {
                int position = musicHolder.getAdapterPosition();

            });
            return musicHolder;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position+1 == getItemCount()){
            return Last_Item_state;
        } else {
            return 0;
        }
    }

    private void startActivity(String id, View v) {
        Intent intent = new Intent(v.getContext(), MusicDetailActivity.class);
        intent.putExtra("id", id);
        v.getContext().startActivity(intent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BottomHolder) {
            BottomHolder bottomHolder = (BottomHolder) holder;
            switch (Last_Item_state){
                case PULLUP_LOAD_MORE:
                    bottomHolder.hintText.setText("上拉加载更多...");
                    bottomHolder.progressBar.setVisibility(View.VISIBLE);
                    break;
                case LOADING_MORE:
                    bottomHolder.hintText.setText("正在加载中...");
                    bottomHolder.progressBar.setVisibility(View.VISIBLE);
                    break;
                case NO_DATA_MORE:
                    bottomHolder.hintText.setText("----我是有底线的----");
                    bottomHolder.progressBar.setVisibility(View.GONE);
                    break;
            }
        } else if (holder instanceof MusicHolder) {
            MusicHolder musicHolder = (MusicHolder) holder;
            Music music = musics.get(position);
            if (music != null) {
                Glide.with(context).load(music.getImage()).into(musicHolder.ivMusic);
                musicHolder.musicName.setText(music.getTitle());
                musicHolder.musicGrade.setText(music.getRating().getAverage());
                musicHolder.musicArt.setText(music.getAlt());
            }
        }
    }

    @Override
    public int getItemCount() {
        return musics.size();
    }

    private class MusicHolder extends RecyclerView.ViewHolder {
        View musicView;
        ImageView ivMusic;
        TextView musicName;
        TextView musicGrade;
        TextView musicArt;
        public MusicHolder(View itemView) {
            super(itemView);
            musicView = itemView;
            ivMusic = (ImageView) itemView.findViewById(R.id.iv_music);
            musicName = (TextView) itemView.findViewById(R.id.tv_music_name);
            musicGrade = (TextView) itemView.findViewById(R.id.tv_music_grade);
            musicArt = (TextView) itemView.findViewById(R.id.tv_music_art);
        }
    }

    private class BottomHolder extends RecyclerView.ViewHolder {
        ProgressBar progressBar;
        TextView hintText;

        public BottomHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.recycler_bottom_progress);
            hintText = (TextView) itemView.findViewById(R.id.recycler_bottom_text);
        }
    }

    public void addData(ArrayList<Music> musics) {
        this.musics.addAll(musics);
        notifyDataSetChanged();
    }

    public void changeMoreStatus(int status) {
        Last_Item_state= status;
    }
}
