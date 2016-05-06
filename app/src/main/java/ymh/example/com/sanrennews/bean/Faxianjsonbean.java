package ymh.example.com.sanrennews.bean;

import java.util.List;

/**
 * Created by ymh on 2016/3/11.
 */
public class Faxianjsonbean {

    /**
     * title : 马上我就能升职加薪，独步武林，迎娶白富美，走上人生巅峰。。。想想还真有点小激动呢
     * imgbig : http://p2.pstatp.com/large/330000167e523bd069c
     * imgsmall : http://p2.pstatp.com/w202/330000167e523bd069
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
        private String imgbig;
        private String imgsmall;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setImgbig(String imgbig) {
            this.imgbig = imgbig;
        }

        public void setImgsmall(String imgsmall) {
            this.imgsmall = imgsmall;
        }

        public String getTitle() {
            return title;
        }

        public String getImgbig() {
            return imgbig;
        }

        public String getImgsmall() {
            return imgsmall;
        }
    }
}
