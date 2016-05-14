package ymh.example.com.sanrennews.bean;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ymh on 2016/5/13.
 */
public class toutiaobean  {

    private String msg;
    private String content;

    private List<DataEntity> data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public String getContent() {
        return content;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity {

        private JsonStringEntity jsonString;

        public void setJsonString(JsonStringEntity jsonString) {
            this.jsonString = jsonString;
        }

        public JsonStringEntity getJsonString() {
            return jsonString;
        }

        public static class JsonStringEntity {
            @SerializedName("abstract")
            private String abstractX;
            private String datetime;
            private int article_type;
            private boolean more_mode;
            private String tag;
            private int is_favorite;
            private int has_m3u8_video;
            private String keywords;
            private int has_mp4_video;
            private int favorite_count;
            private String display_url;
            private int article_sub_type;
            private int bury_count;
            private String title;
            private boolean has_video;
            private String share_url;
            private long id;
            private String source;
            private int comment_count;
            private String article_url;
            private int create_time;
            private int recommend;
            private boolean middle_mode;
            private int aggr_type;
            private String item_source_url;
            private int display_time;
            private int publish_time;
            private int go_detail_count;
            private String display_title;
            private String item_seo_url;
            private long tag_id;
            private String source_url;
            private boolean large_mode;
            private long item_id;
            private int is_digg;
            private String seo_url;
            private int repin_count;
            private String url;
            private int level;
            private int digg_count;
            private int behot_time;
            private int hot;
            private int preload_web;
            private int comments_count;
            private boolean has_image;
            private int is_bury;
            private long group_id;
            private List<HashMap<String, String>> image_list;

            public void setAbstractX(String abstractX) {
                this.abstractX = abstractX;
            }

            public void setDatetime(String datetime) {
                this.datetime = datetime;
            }

            public void setArticle_type(int article_type) {
                this.article_type = article_type;
            }

            public void setMore_mode(boolean more_mode) {
                this.more_mode = more_mode;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public void setIs_favorite(int is_favorite) {
                this.is_favorite = is_favorite;
            }

            public void setHas_m3u8_video(int has_m3u8_video) {
                this.has_m3u8_video = has_m3u8_video;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public void setHas_mp4_video(int has_mp4_video) {
                this.has_mp4_video = has_mp4_video;
            }

            public void setFavorite_count(int favorite_count) {
                this.favorite_count = favorite_count;
            }

            public void setDisplay_url(String display_url) {
                this.display_url = display_url;
            }

            public void setArticle_sub_type(int article_sub_type) {
                this.article_sub_type = article_sub_type;
            }

            public void setBury_count(int bury_count) {
                this.bury_count = bury_count;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setHas_video(boolean has_video) {
                this.has_video = has_video;
            }

            public void setShare_url(String share_url) {
                this.share_url = share_url;
            }

            public void setId(long id) {
                this.id = id;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public void setComment_count(int comment_count) {
                this.comment_count = comment_count;
            }

            public void setArticle_url(String article_url) {
                this.article_url = article_url;
            }

            public void setCreate_time(int create_time) {
                this.create_time = create_time;
            }

            public void setRecommend(int recommend) {
                this.recommend = recommend;
            }

            public void setMiddle_mode(boolean middle_mode) {
                this.middle_mode = middle_mode;
            }

            public void setAggr_type(int aggr_type) {
                this.aggr_type = aggr_type;
            }

            public void setItem_source_url(String item_source_url) {
                this.item_source_url = item_source_url;
            }

            public void setDisplay_time(int display_time) {
                this.display_time = display_time;
            }

            public void setPublish_time(int publish_time) {
                this.publish_time = publish_time;
            }

            public void setGo_detail_count(int go_detail_count) {
                this.go_detail_count = go_detail_count;
            }

            public void setDisplay_title(String display_title) {
                this.display_title = display_title;
            }

            public void setItem_seo_url(String item_seo_url) {
                this.item_seo_url = item_seo_url;
            }

            public void setTag_id(long tag_id) {
                this.tag_id = tag_id;
            }

            public void setSource_url(String source_url) {
                this.source_url = source_url;
            }

            public void setLarge_mode(boolean large_mode) {
                this.large_mode = large_mode;
            }

            public void setItem_id(long item_id) {
                this.item_id = item_id;
            }

            public void setIs_digg(int is_digg) {
                this.is_digg = is_digg;
            }

            public void setSeo_url(String seo_url) {
                this.seo_url = seo_url;
            }

            public void setRepin_count(int repin_count) {
                this.repin_count = repin_count;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public void setDigg_count(int digg_count) {
                this.digg_count = digg_count;
            }

            public void setBehot_time(int behot_time) {
                this.behot_time = behot_time;
            }

            public void setHot(int hot) {
                this.hot = hot;
            }

            public void setPreload_web(int preload_web) {
                this.preload_web = preload_web;
            }

            public void setComments_count(int comments_count) {
                this.comments_count = comments_count;
            }

            public void setHas_image(boolean has_image) {
                this.has_image = has_image;
            }

            public void setIs_bury(int is_bury) {
                this.is_bury = is_bury;
            }

            public void setGroup_id(long group_id) {
                this.group_id = group_id;
            }

            public void setImage_list(List<HashMap<String, String>> image_list) {
                this.image_list = image_list;
            }

            public String getAbstractX() {
                return abstractX;
            }

            public String getDatetime() {
                return datetime;
            }

            public int getArticle_type() {
                return article_type;
            }

            public boolean isMore_mode() {
                return more_mode;
            }

            public String getTag() {
                return tag;
            }

            public int getIs_favorite() {
                return is_favorite;
            }

            public int getHas_m3u8_video() {
                return has_m3u8_video;
            }

            public String getKeywords() {
                return keywords;
            }

            public int getHas_mp4_video() {
                return has_mp4_video;
            }

            public int getFavorite_count() {
                return favorite_count;
            }

            public String getDisplay_url() {
                return display_url;
            }

            public int getArticle_sub_type() {
                return article_sub_type;
            }

            public int getBury_count() {
                return bury_count;
            }

            public String getTitle() {
                return title;
            }

            public boolean isHas_video() {
                return has_video;
            }

            public String getShare_url() {
                return share_url;
            }

            public long getId() {
                return id;
            }

            public String getSource() {
                return source;
            }

            public int getComment_count() {
                return comment_count;
            }

            public String getArticle_url() {
                return article_url;
            }

            public int getCreate_time() {
                return create_time;
            }

            public int getRecommend() {
                return recommend;
            }

            public boolean isMiddle_mode() {
                return middle_mode;
            }

            public int getAggr_type() {
                return aggr_type;
            }

            public String getItem_source_url() {
                return item_source_url;
            }

            public int getDisplay_time() {
                return display_time;
            }

            public int getPublish_time() {
                return publish_time;
            }

            public int getGo_detail_count() {
                return go_detail_count;
            }

            public String getDisplay_title() {
                return display_title;
            }

            public String getItem_seo_url() {
                return item_seo_url;
            }

            public long getTag_id() {
                return tag_id;
            }

            public String getSource_url() {
                return source_url;
            }

            public boolean isLarge_mode() {
                return large_mode;
            }

            public long getItem_id() {
                return item_id;
            }

            public int getIs_digg() {
                return is_digg;
            }

            public String getSeo_url() {
                return seo_url;
            }

            public int getRepin_count() {
                return repin_count;
            }

            public String getUrl() {
                return url;
            }

            public int getLevel() {
                return level;
            }

            public int getDigg_count() {
                return digg_count;
            }

            public int getBehot_time() {
                return behot_time;
            }

            public int getHot() {
                return hot;
            }

            public int getPreload_web() {
                return preload_web;
            }

            public int getComments_count() {
                return comments_count;
            }

            public boolean isHas_image() {
                return has_image;
            }

            public int getIs_bury() {
                return is_bury;
            }

            public long getGroup_id() {
                return group_id;
            }

            public List<HashMap<String, String>> getImage_list() {
                return image_list;
            }
        }
    }
}
