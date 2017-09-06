package com.example.a14512.nimd_douban.modules.movie.model.entity;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HP on 2017/5/13.
 */

public class MovieDetail implements Serializable {

    /**
     * rating : {"max":10,"average":7.7,"stars":"40","min":0}
     * reviews_count : 150
     * wish_count : 46074
     * douban_site :
     * year : 2017
     * images : {"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2497756471.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2497756471.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2497756471.jpg"}
     * alt : https://movie.douban.com/subject/24753477/
     * id : 24753477
     * mobile_url : https://movie.douban.com/subject/24753477/mobile
     * title : 蜘蛛侠：英雄归来
     * do_count : null
     * share_url : https://m.douban.com/movie/subject/24753477
     * seasons_count : null
     * schedule_url : https://movie.douban.com/subject/24753477/cinema/
     * episodes_count : null
     * countries : ["美国"]
     * genres : ["动作","科幻","冒险"]
     * collect_count : 10264
     * casts : [{"alt":"https://movie.douban.com/celebrity/1325351/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1467942867.09.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1467942867.09.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1467942867.09.jpg"},"name":"汤姆·霍兰德","id":"1325351"},{"alt":"https://movie.douban.com/celebrity/1016681/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/56339.jpg","large":"https://img1.doubanio.com/img/celebrity/large/56339.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/56339.jpg"},"name":"小罗伯特·唐尼","id":"1016681"},{"alt":"https://movie.douban.com/celebrity/1047974/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/231.jpg","large":"https://img3.doubanio.com/img/celebrity/large/231.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/231.jpg"},"name":"玛丽莎·托梅","id":"1047974"},{"alt":"https://movie.douban.com/celebrity/1049486/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1420615848.64.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1420615848.64.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1420615848.64.jpg"},"name":"迈克尔·基顿","id":"1049486"}]
     * current_season : null
     * original_title : Spider-Man: Homecoming
     * summary : 影片讲述了蜘蛛侠在钢铁侠“导师”的帮助下对抗终极反派秃鹰的故事。经历了美队3中的复联内战后，彼得·帕克（汤姆·霍兰德 Tom Holland 饰）回到普通高中生活，并受到钢铁侠托尼·斯塔克（小罗伯特·唐尼 Robert Downey Jr. 饰）的指导与暗中关注。一心想要证明自己能力的小蜘蛛，在一场银行劫案后遭遇了拥有外星终极武器的反派秃鹰（迈克尔·基顿 Michael Keaton 饰），却因一时心急而使万千生命陷入危机。此时，钢铁侠却意外收回了赠予蜘蛛侠的无敌战衣，这对于遭遇重创的蜘蛛侠无异于雪上加霜。他能否证明自己的能力，成功保卫家园成为悬念，而他“获得复联入场券”的梦想，也看似遥遥无期……
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1350194/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1435142487.62.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1435142487.62.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1435142487.62.jpg"},"name":"乔·沃茨","id":"1350194"}]
     * comments_count : 4498
     * ratings_count : 9487
     * aka : ["蜘蛛侠：强势回归(港)","蜘蛛人：返校日(台)","新蜘蛛侠","蜘蛛侠：归来","蜘蛛侠：回家","蜘蛛侠：返校季","蜘蛛侠：返校节","蜘蛛侠：归乡","蜘蛛侠：新复仇者","The Amazing Spider-Man 3","Spider-Man: The New Avenger","Spiderman"]
     */

    private RatingBean rating;
    private int reviews_count;
    private int wish_count;
    private String douban_site;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private String mobile_url;
    private String title;
    private Object do_count;
    private String share_url;
    private Object seasons_count;
    private String schedule_url;
    private Object episodes_count;
    private int collect_count;
    private Object current_season;
    private String original_title;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<String> countries;
    private List<String> genres;
    private List<CastsBean> casts;
    private List<DirectorsBean> directors;
    private List<String> aka;

    public static MovieDetail objectFromData(String str) {

        return new Gson().fromJson(str, MovieDetail.class);
    }

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
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

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
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

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 7.7
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

    public static class ImagesBean {
        /**
         * small : https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2497756471.jpg
         * large : https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2497756471.jpg
         * medium : https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2497756471.jpg
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
         * alt : https://movie.douban.com/celebrity/1325351/
         * avatars : {"small":"https://img1.doubanio.com/img/celebrity/small/1467942867.09.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1467942867.09.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1467942867.09.jpg"}
         * name : 汤姆·霍兰德
         * id : 1325351
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
             * small : https://img1.doubanio.com/img/celebrity/small/1467942867.09.jpg
             * large : https://img1.doubanio.com/img/celebrity/large/1467942867.09.jpg
             * medium : https://img1.doubanio.com/img/celebrity/medium/1467942867.09.jpg
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
         * alt : https://movie.douban.com/celebrity/1350194/
         * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/1435142487.62.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1435142487.62.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1435142487.62.jpg"}
         * name : 乔·沃茨
         * id : 1350194
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
             * small : https://img3.doubanio.com/img/celebrity/small/1435142487.62.jpg
             * large : https://img3.doubanio.com/img/celebrity/large/1435142487.62.jpg
             * medium : https://img3.doubanio.com/img/celebrity/medium/1435142487.62.jpg
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
