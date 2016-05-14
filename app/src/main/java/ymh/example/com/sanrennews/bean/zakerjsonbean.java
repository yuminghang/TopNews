package ymh.example.com.sanrennews.bean;

/**
 * Created by ymh on 2016/5/13.
 */
public class zakerjsonbean  {

    /**
     * url : http://app.myzaker.com/news/topic.php?topic_id=568b34e29490cbf43c000009
     * imgnums : 1
     * imgurl : http://zkres2.myzaker.com/201605/5735444df5a2246771000002_320.jpg
     * title :  习近平：谈供给侧不能少了这三个字
     */

    private String url;
    private int imgnums;
    private String imgurl;
    private String title;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImgnums(int imgnums) {
        this.imgnums = imgnums;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public int getImgnums() {
        return imgnums;
    }

    public String getImgurl() {
        return imgurl;
    }

    public String getTitle() {
        return title;
    }
}
