package com.example.a14512.nimd_douban.modules.movie.model.entity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by HP on 2017/5/13.
 */

public class MovieDetail {
    public String title;
    public Rate rating;
    public String year;
    public MovieImage images;
    public List<String> countries;
    public List<String> genres;
    public int collect_count;  //看过人数
    public String summary;  //简介
    public int ratings_count;  //评分人数
    /**
     * rating : {"max":10,"average":7.4,"stars":"40","min":0}
     * reviews_count : 299
     * wish_count : 15413
     * douban_site :
     * alt : https://movie.douban.com/subject/1764796/
     * id : 1764796
     * mobile_url : https://movie.douban.com/subject/1764796/mobile
     * do_count : null
     * share_url : https://m.douban.com/movie/subject/1764796
     * seasons_count : null
     * schedule_url :
     * episodes_count : null
     * casts : [{"alt":"https://movie.douban.com/celebrity/1054395/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/51597.jpg","large":"https://img1.doubanio.com/img/celebrity/large/51597.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/51597.jpg"},"name":"伊利亚·伍德","id":"1054395"},{"alt":"https://movie.douban.com/celebrity/1016673/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/3996.jpg","large":"https://img3.doubanio.com/img/celebrity/large/3996.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/3996.jpg"},"name":"詹妮弗·康纳利","id":"1016673"},{"alt":"https://movie.douban.com/celebrity/1017907/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/55994.jpg","large":"https://img3.doubanio.com/img/celebrity/large/55994.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/55994.jpg"},"name":"约翰·C·赖利","id":"1017907"},{"alt":"https://movie.douban.com/celebrity/1036321/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/42033.jpg","large":"https://img3.doubanio.com/img/celebrity/large/42033.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/42033.jpg"},"name":"克里斯托弗·普卢默","id":"1036321"}]
     * current_season : null
     * original_title : 9
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1276787/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1351678808.44.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1351678808.44.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1351678808.44.jpg"},"name":"申·阿克","id":"1276787"}]
     * comments_count : 11807
     * aka : ["9：末世决战","九","Number 9","机器人9号"]
     */

    @SerializedName("rating")
    private RatingBean ratingX;
    private int reviews_count;
    private int wish_count;
    private String douban_site;
    private String alt;
    private String id;
    private String mobile_url;
    private Object do_count;
    private String share_url;
    private Object seasons_count;
    private String schedule_url;
    private Object episodes_count;
    private Object current_season;
    private String original_title;
    private String subtype;
    private int comments_count;
    private List<CastsBean> casts;
    private List<DirectorsBean> directors;
    private List<String> aka;

    public static MovieDetail objectFromData(String str) {

        return new Gson().fromJson(str, MovieDetail.class);
    }

    public RatingBean getRatingX() {
        return ratingX;
    }

    public void setRatingX(RatingBean ratingX) {
        this.ratingX = ratingX;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
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

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public Object getDo_count() {
        return do_count;
    }

    public void setDo_count(Object do_count) {
        this.do_count = do_count;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public Object getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(Object seasons_count) {
        this.seasons_count = seasons_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public Object getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(Object episodes_count) {
        this.episodes_count = episodes_count;
    }

    public Object getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(Object current_season) {
        this.current_season = current_season;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 7.4
         * stars : 40
         * min : 0
         */

        private int max;
        private double average;
        private String stars;
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

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class CastsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1054395/
         * avatars : {"small":"https://img1.doubanio.com/img/celebrity/small/51597.jpg","large":"https://img1.doubanio.com/img/celebrity/large/51597.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/51597.jpg"}
         * name : 伊利亚·伍德
         * id : 1054395
         */

        private String alt;
        private MovieImage avatars;
        private String name;
        private String id;

        public static CastsBean objectFromData(String str) {

            return new Gson().fromJson(str, CastsBean.class);
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public MovieImage getAvatars() {
            return avatars;
        }

        public void setAvatars(MovieImage avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class DirectorsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1276787/
         * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/1351678808.44.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1351678808.44.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1351678808.44.jpg"}
         * name : 申·阿克
         * id : 1276787
         */

        private String alt;
        private MovieImage avatars;
        private String name;
        private String id;

        public static DirectorsBean objectFromData(String str) {

            return new Gson().fromJson(str, DirectorsBean.class);
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public MovieImage getAvatars() {
            return avatars;
        }

        public void setAvatars(MovieImage avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }


    public class MovieImage {
        public String small;
        public String large;
        public String medium;
    }

    public class Rate {
        public int max;
        public int average;
        public String stars;
        public int min;
    }



}
