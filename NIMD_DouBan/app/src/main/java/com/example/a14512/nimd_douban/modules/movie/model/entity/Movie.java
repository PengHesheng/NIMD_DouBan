package com.example.a14512.nimd_douban.modules.movie.model.entity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HP on 2017/5/11.
 */

public class Movie implements Serializable{
    /**
     * rating : {"max":10,"average":7.1,"stars":"35","min":0}
     * genres : ["动作","科幻","冒险"]
     * title : 星际特工：千星之城
     * casts : [{"alt":"https://movie.douban.com/celebrity/1317646/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1371656488.39.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1371656488.39.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1371656488.39.jpg"},"name":"戴恩·德哈恩","id":"1317646"},{"alt":"https://movie.douban.com/celebrity/1326177/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1365676042.23.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1365676042.23.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1365676042.23.jpg"},"name":"卡拉·迪瓦伊","id":"1326177"},{"alt":"https://movie.douban.com/celebrity/1025147/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/5321.jpg","large":"https://img3.doubanio.com/img/celebrity/large/5321.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/5321.jpg"},"name":"克里夫·欧文","id":"1025147"}]
     * collect_count : 37045
     * original_title : Valérian and the City of a Thousand Planets
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1031876/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/33301.jpg","large":"https://img3.doubanio.com/img/celebrity/large/33301.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/33301.jpg"},"name":"吕克·贝松","id":"1031876"}]
     * year : 2017
     * images : {"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2496088130.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2496088130.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2496088130.jpg"}
     * alt : https://movie.douban.com/subject/11502973/
     * id : 11502973
     */

    private RatingBean rating;
    @SerializedName("title")
    private String titleX;
    private int collect_count;
    private String original_title;
    private String subtype;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private List<String> genres;
    private List<CastsBean> casts;
    private List<DirectorsBean> directors;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getTitleX() {
        return titleX;
    }

    public void setTitleX(String titleX) {
        this.titleX = titleX;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
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

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
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

    public static class RatingBean {
        /**
         * max : 10
         * average : 7.1
         * stars : 35
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

    public static class ImagesBean {
        /**
         * small : https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2496088130.jpg
         * large : https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2496088130.jpg
         * medium : https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2496088130.jpg
         */

        private String small;
        private String large;
        private String medium;

        public static ImagesBean objectFromData(String str) {

            return new Gson().fromJson(str, ImagesBean.class);
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class CastsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1317646/
         * avatars : {"small":"https://img1.doubanio.com/img/celebrity/small/1371656488.39.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1371656488.39.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1371656488.39.jpg"}
         * name : 戴恩·德哈恩
         * id : 1317646
         */

        private String alt;
        private AvatarsBean avatars;
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

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
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

        public static class AvatarsBean {
            /**
             * small : https://img1.doubanio.com/img/celebrity/small/1371656488.39.jpg
             * large : https://img1.doubanio.com/img/celebrity/large/1371656488.39.jpg
             * medium : https://img1.doubanio.com/img/celebrity/medium/1371656488.39.jpg
             */

            private String small;
            private String large;
            private String medium;

            public static AvatarsBean objectFromData(String str) {

                return new Gson().fromJson(str, AvatarsBean.class);
            }

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class DirectorsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1031876/
         * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/33301.jpg","large":"https://img3.doubanio.com/img/celebrity/large/33301.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/33301.jpg"}
         * name : 吕克·贝松
         * id : 1031876
         */

        private String alt;
        private AvatarsBeanX avatars;
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

        public AvatarsBeanX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanX avatars) {
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

        public static class AvatarsBeanX {
            /**
             * small : https://img3.doubanio.com/img/celebrity/small/33301.jpg
             * large : https://img3.doubanio.com/img/celebrity/large/33301.jpg
             * medium : https://img3.doubanio.com/img/celebrity/medium/33301.jpg
             */

            private String small;
            private String large;
            private String medium;

            public static AvatarsBeanX objectFromData(String str) {

                return new Gson().fromJson(str, AvatarsBeanX.class);
            }

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }
}
