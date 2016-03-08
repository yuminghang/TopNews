package ymh.example.com.sanrennews.bean;

/**
 * Created by ymh on 2016/3/8.
 */
public class JsonBean {

    /**
     * title : 搞笑精选：家有二货媳妇！
     * h : http://toutiao.com/item/6257715953648271874/
     * imgurl1 : http://p2.pstatp.com/list/2f30000c4e73f9a8091
     * imgurl2 : http://p2.pstatp.com/list/2cc00045a3442f26f18
     * imgurl3 : http://p2.pstatp.com/list/2f30000c3905f2c588b
     */

    private String title;
    private String h;
    private String imgurl1;
    private String imgurl2;
    private String imgurl3;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setH(String h) {
        this.h = h;
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

    public String getH() {
        return h;
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
