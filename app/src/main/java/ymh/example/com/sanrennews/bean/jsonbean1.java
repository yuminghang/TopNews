package ymh.example.com.sanrennews.bean;

import java.util.List;

/**
 * Created by ymh on 2016/3/9.
 */
public class jsonbean1 {

    /**
     * title : 老外恶搞 盲人运动会
     * imgnums : 1
     * url : http://toutiao.com/item/6259648625735893506/
     * imgurl : http://p2.pstatp.com/list/2cd0009fb6f021de6b4
     * imgurl1 : null
     * imgurl2 : null
     * imgurl3 : null
     */

    private List<DataEntity> data;

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity {
        private String title;
        private int imgnums;
        private String url;
        private String imgurl;
        private Object imgurl1;
        private Object imgurl2;
        private Object imgurl3;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setImgnums(int imgnums) {
            this.imgnums = imgnums;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public void setImgurl1(Object imgurl1) {
            this.imgurl1 = imgurl1;
        }

        public void setImgurl2(Object imgurl2) {
            this.imgurl2 = imgurl2;
        }

        public void setImgurl3(Object imgurl3) {
            this.imgurl3 = imgurl3;
        }

        public String getTitle() {
            return title;
        }

        public int getImgnums() {
            return imgnums;
        }

        public String getUrl() {
            return url;
        }

        public String getImgurl() {
            return imgurl;
        }

        public Object getImgurl1() {
            return imgurl1;
        }

        public Object getImgurl2() {
            return imgurl2;
        }

        public Object getImgurl3() {
            return imgurl3;
        }
    }
}
