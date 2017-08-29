package com.example.a14512.nimd_douban.modules.movie.model.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by 14512 on 2017/8/29.
 */

public class USMovie implements Serializable {
    /**
     * box : 10050000
     * new : false
     * rank : 1
     * subject : {"rating":{"max":10,"average":7.6,"stars":"40","min":0},"genres":["喜剧","动作"],"title":"王牌保镖","casts":[{"alt":"https://movie.douban.com/celebrity/1053623/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/48608.jpg","large":"http://img3.doubanio.com/img/celebrity/large/48608.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/48608.jpg"},"name":"瑞恩·雷诺兹","id":"1053623"},{"alt":"https://movie.douban.com/celebrity/1054408/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/31870.jpg","large":"http://img7.doubanio.com/img/celebrity/large/31870.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/31870.jpg"},"name":"塞缪尔·杰克逊","id":"1054408"},{"alt":"https://movie.douban.com/celebrity/1032370/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1367413373.36.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1367413373.36.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1367413373.36.jpg"},"name":"艾洛蒂·袁","id":"1032370"}],"collect_count":1417,"original_title":"The Hitman's Bodyguard","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1328352/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1366879444.07.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1366879444.07.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1366879444.07.jpg"},"name":"帕特里克·休斯","id":"1328352"}],"year":"2017","images":{"small":"http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2455368577.jpg","large":"http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2455368577.jpg","medium":"http://img3.doubanio.com/view/movie_poster_cover/spst/public/p2455368577.jpg"},"alt":"https://movie.douban.com/subject/22266126/","id":"22266126"}
     */

    private int box;
    @SerializedName("new")
    private boolean newX;
    private int rank;
    private Movie subject;

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

    public boolean isNewX() {
        return newX;
    }

    public void setNewX(boolean newX) {
        this.newX = newX;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }



}
