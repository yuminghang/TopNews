package ymh.example.com.sanrennews.bean;

import java.util.List;

/**
 * Created by ymh on 2016/5/14.
 */
public class jingpinbean {

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
            private String ctype;
            private String impid;
            private String pageid;
            private String meta;
            private String title;
            private String date;
            private String docid;
            private String itemid;
            private String url;
            private String source;
            private int mtype;
            private String image;
            private boolean auth;
            private boolean is_gov;
            private int dtype;
            private int comment_count;
            private List<String> image_urls;

            public void setCtype(String ctype) {
                this.ctype = ctype;
            }

            public void setImpid(String impid) {
                this.impid = impid;
            }

            public void setPageid(String pageid) {
                this.pageid = pageid;
            }

            public void setMeta(String meta) {
                this.meta = meta;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public void setDocid(String docid) {
                this.docid = docid;
            }

            public void setItemid(String itemid) {
                this.itemid = itemid;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public void setMtype(int mtype) {
                this.mtype = mtype;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public void setAuth(boolean auth) {
                this.auth = auth;
            }

            public void setIs_gov(boolean is_gov) {
                this.is_gov = is_gov;
            }

            public void setDtype(int dtype) {
                this.dtype = dtype;
            }

            public void setComment_count(int comment_count) {
                this.comment_count = comment_count;
            }

            public void setImage_urls(List<String> image_urls) {
                this.image_urls = image_urls;
            }

            public String getCtype() {
                return ctype;
            }

            public String getImpid() {
                return impid;
            }

            public String getPageid() {
                return pageid;
            }

            public String getMeta() {
                return meta;
            }

            public String getTitle() {
                return title;
            }

            public String getDate() {
                return date;
            }

            public String getDocid() {
                return docid;
            }

            public String getItemid() {
                return itemid;
            }

            public String getUrl() {
                return url;
            }

            public String getSource() {
                return source;
            }

            public int getMtype() {
                return mtype;
            }

            public String getImage() {
                return image;
            }

            public boolean isAuth() {
                return auth;
            }

            public boolean isIs_gov() {
                return is_gov;
            }

            public int getDtype() {
                return dtype;
            }

            public int getComment_count() {
                return comment_count;
            }

            public List<String> getImage_urls() {
                return image_urls;
            }
        }
    }
}
