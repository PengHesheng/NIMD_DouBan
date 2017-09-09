package com.example.a14512.nimd_douban.modules.music.model.entity;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 14512 on 2017/8/29.
 */

public class Music implements Serializable{
    /**
     * rating : {"max":10,"average":"9.4","numRaters":821,"min":0}
     * author : [{"name":"邓丽君"}]
     * alt_title : 留聲經典復刻版
     * image : https://img3.doubanio.com/spic/s2396306.jpg
     * tags : [{"count":235,"name":"邓丽君"},{"count":79,"name":"我只在乎你"},{"count":77,"name":"经典"},{"count":64,"name":"台湾"},{"count":32,"name":"Pop"},{"count":29,"name":"旧时光"},{"count":29,"name":"华语"},{"count":28,"name":"鄧麗君"}]
     * mobile_link : https://m.douban.com/music/subject/2073550/
     * attrs : {"publisher":["环球"],"singer":["邓丽君"],"version":["专辑"],"pubdate":["1987-01-02"],"title":["我只在乎你"],"media":["CD"],"tracks":["01. 酒醉的探戈\n02. 像故事般温柔\n03. 命运之川\n04. 爱人\n05. 午夜微风\n06. 夏日圣诞\n07. 非龙非彲\n08. 不着痕迹\n09. 心路过黄昏\n10. 我只在乎你"],"discs":["1"]}
     * title : 我只在乎你
     * alt : https://music.douban.com/subject/2073550/
     * id : 2073550
     */

    private RatingBean rating;
    private String alt_title;
    private String image;
    private String mobile_link;
    private AttrsBean attrs;
    private String title;
    private String alt;
    private String id;
    private List<AuthorBean> author;
    private List<TagsBean> tags;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getAlt_title() {
        return alt_title;
    }

    public void setAlt_title(String alt_title) {
        this.alt_title = alt_title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMobile_link() {
        return mobile_link;
    }

    public void setMobile_link(String mobile_link) {
        this.mobile_link = mobile_link;
    }

    public AttrsBean getAttrs() {
        return attrs;
    }

    public void setAttrs(AttrsBean attrs) {
        this.attrs = attrs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<AuthorBean> getAuthor() {
        return author;
    }

    public void setAuthor(List<AuthorBean> author) {
        this.author = author;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 9.4
         * numRaters : 821
         * min : 0
         */

        private int max;
        private String average;
        private int numRaters;
        private int min;

        public static RatingBean objectFromData(String str) {

            return new Gson().fromJson(str, RatingBean.class);
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public String getAverage() {
            return average;
        }

        public void setAverage(String average) {
            this.average = average;
        }

        public int getNumRaters() {
            return numRaters;
        }

        public void setNumRaters(int numRaters) {
            this.numRaters = numRaters;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class AttrsBean {
        private List<String> publisher;
        private List<String> singer;
        private List<String> version;
        private List<String> pubdate;
        private List<String> title;
        private List<String> media;
        private List<String> tracks;
        private List<String> discs;

        public static AttrsBean objectFromData(String str) {

            return new Gson().fromJson(str, AttrsBean.class);
        }

        public List<String> getPublisher() {
            return publisher;
        }

        public void setPublisher(List<String> publisher) {
            this.publisher = publisher;
        }

        public List<String> getSinger() {
            return singer;
        }

        public void setSinger(List<String> singer) {
            this.singer = singer;
        }

        public List<String> getVersion() {
            return version;
        }

        public void setVersion(List<String> version) {
            this.version = version;
        }

        public List<String> getPubdate() {
            return pubdate;
        }

        public void setPubdate(List<String> pubdate) {
            this.pubdate = pubdate;
        }

        public List<String> getTitle() {
            return title;
        }

        public void setTitle(List<String> title) {
            this.title = title;
        }

        public List<String> getMedia() {
            return media;
        }

        public void setMedia(List<String> media) {
            this.media = media;
        }

        public List<String> getTracks() {
            return tracks;
        }

        public void setTracks(List<String> tracks) {
            this.tracks = tracks;
        }

        public List<String> getDiscs() {
            return discs;
        }

        public void setDiscs(List<String> discs) {
            this.discs = discs;
        }
    }

    public static class AuthorBean {
        /**
         * name : 邓丽君
         */

        private String name;

        public static AuthorBean objectFromData(String str) {

            return new Gson().fromJson(str, AuthorBean.class);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class TagsBean {
        /**
         * count : 235
         * name : 邓丽君
         */

        private int count;
        private String name;

        public static TagsBean objectFromData(String str) {

            return new Gson().fromJson(str, TagsBean.class);
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

