package it.com.retrofitdemo;

import java.util.List;

/**
 * Created by tony on 2017/5/19.
 */

public class BannerBean {

    /**
     * bannerList : [{"bannerId":408,"id":25783,"title":"巴西爆发有史以来最大规模工人罢工活动！港口物流恐遭受波及","picture":"http://pic1.cifnews.com/uploads/carouse_article/2017-05/03/57b3670dd3ecefd42bbc77bf91bff472.jpg","type":1,"link":"http://app.cifnews.com/article/25783"},{"bannerId":406,"id":25748,"title":"注意！亚马逊升级品牌注册工具致力打假，还没注册品牌的卖家急需了解这些问题！","picture":"http://pic1.cifnews.com/uploads/carouse_article/2017-05/02/de9a3f640b73e646e8959ff1e63d3103.jpg","type":1,"link":"http://app.cifnews.com/article/25748"},{"bannerId":401,"id":5310,"title":"2017亚马逊全球开店绿色通道开启","picture":"http://pic1.cifnews.com/uploads/carouse_article/2017-04/26/434389ad99f31ac6d925bb2a7a0ba989.jpg","type":2,"link":"http://app.cifnews.com/post/5310"},{"bannerId":386,"id":0,"title":"2017CCEE雨果网（上海）跨境电商选品大会","picture":"http://pic1.cifnews.com/uploads/carouse_article/2017-04/14/6324c40f42d40a1e7d8896bc10cfab7f.jpg","type":3,"link":"http://m.cifnews.com/active/detail/42?origin=app"}]
     * state : 1
     * message : success
     */

    private int state;
    private String message;
    private List<BannerListBean> bannerList;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<BannerListBean> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<BannerListBean> bannerList) {
        this.bannerList = bannerList;
    }

    public static class BannerListBean {
        /**
         * bannerId : 408
         * id : 25783
         * title : 巴西爆发有史以来最大规模工人罢工活动！港口物流恐遭受波及
         * picture : http://pic1.cifnews.com/uploads/carouse_article/2017-05/03/57b3670dd3ecefd42bbc77bf91bff472.jpg
         * type : 1
         * link : http://app.cifnews.com/article/25783
         */

        private int bannerId;
        private int id;
        private String title;
        private String picture;
        private int type;
        private String link;

        public int getBannerId() {
            return bannerId;
        }

        public void setBannerId(int bannerId) {
            this.bannerId = bannerId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
