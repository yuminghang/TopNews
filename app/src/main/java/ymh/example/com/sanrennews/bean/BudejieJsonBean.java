package ymh.example.com.sanrennews.bean;

import java.util.List;

/**
 * Created by ymh on 2016/3/11.
 */
public class BudejieJsonBean {

    /**
     * ctime : 2016-03-11T00:45:06.000Z
     * title : 小小年纪推开了...
     * imgbig : null
     * imgsmall : http://mpic.spriteapp.cn/crop/566x360/picture/2016/0309/56dfa4d8511d0_wpd.jpg
     * type : 1
     * video : http://mvideo.spriteapp.cn/video/2016/0309/56dfa4d8511d0_wpd.mp4
     */

    private List<DataEntity> data;

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity {
        private String ctime;
        private String title;
        private Object imgbig;
        private String imgsmall;
        private int type;
        private String video;

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setImgbig(Object imgbig) {
            this.imgbig = imgbig;
        }

        public void setImgsmall(String imgsmall) {
            this.imgsmall = imgsmall;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getCtime() {
            return ctime;
        }

        public String getTitle() {
            return title;
        }

        public Object getImgbig() {
            return imgbig;
        }

        public String getImgsmall() {
            return imgsmall;
        }

        public int getType() {
            return type;
        }

        public String getVideo() {
            return video;
        }
    }
}
