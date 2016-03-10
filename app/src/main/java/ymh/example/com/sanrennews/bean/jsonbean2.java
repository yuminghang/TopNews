package ymh.example.com.sanrennews.bean;

import java.util.List;

/**
 * Created by ymh on 2016/3/10.
 */
public class jsonbean2 {

    /**
     * title : 你的压岁钱够玩XX几次?新春特供福利！
     * imgnums : 3
     * url : http://toutiao.com/item/6249339945698198018/
     * imgurl : null
     * imgurl1 : http://p2.pstatp.com/list/14f0004b83779c5240f
     * imgurl2 : http://p2.pstatp.com/list/4d000f0a08208824fa
     * imgurl3 : http://p2.pstatp.com/list/14f0004b8398d551afd
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
        private Object imgurl;
        private String imgurl1;
        private String imgurl2;
        private String imgurl3;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setImgnums(int imgnums) {
            this.imgnums = imgnums;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setImgurl(Object imgurl) {
            this.imgurl = imgurl;
        }

        public void setImgurl1(String imgurl1) {
            this.imgurl1 = imgurl1;
        }

        public void setImgurl2(String imgurl2) {
            this.imgurl2 = imgurl2;
        }

        public void setImgurl3(String imgurl3) {
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

        public Object getImgurl() {
            return imgurl;
        }

        public String getImgurl1() {
            return imgurl1;
        }

        public String getImgurl2() {
            return imgurl2;
        }

        public String getImgurl3() {
            return imgurl3;
        }
    }
}
