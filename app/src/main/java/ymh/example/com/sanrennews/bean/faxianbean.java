package ymh.example.com.sanrennews.bean;

import java.util.List;

/**
 * Created by ymh on 2016/5/14.
 */
public class faxianbean {

    /**
     * msg : success
     * message : 成功
     * data : [{"title":"汪:你吓不到我的。","imgbig":"http://p5.pstatp.com/large/1390/5260457957","imgsmall":"http://p5.pstatp.com/w202/1390/526045795"},{"title":"咦，这不是雪吗","imgbig":"http://p3.pstatp.com/large/11e000648479d7e7ce2","imgsmall":"http://p3.pstatp.com/w202/11e000648479d7e7ce"},{"title":"卧槽 命大啊","imgbig":"http://p2.pstatp.com/large/1fe00015eaae5385618","imgsmall":"http://p2.pstatp.com/w202/1fe00015eaae538561"},{"title":"求小孩的心里阴影面积","imgbig":"http://p3.pstatp.com/large/1ff00008904e367f73b","imgsmall":"http://p3.pstatp.com/w202/1ff00008904e367f73"},{"title":"iPhone70概念机","imgbig":"http://p2.pstatp.com/large/20000016010317bed8e","imgsmall":"http://p2.pstatp.com/w202/20000016010317bed8"},{"title":"这打字速度，没谁了","imgbig":"http://p2.pstatp.com/large/9063/4266187760","imgsmall":"http://p2.pstatp.com/w202/9063/426618776"},{"title":"田地里惊现一群发疯了的汪！！想知道他们到底在想什么？？","imgbig":"http://p3.pstatp.com/large/5df0002053a5412ac07","imgsmall":"http://p3.pstatp.com/w202/5df0002053a5412ac0"},{"title":"","imgbig":"http://p3.pstatp.com/large/5e000020ac09f2a9b55","imgsmall":"http://p3.pstatp.com/w202/5e000020ac09f2a9b5"},{"title":"","imgbig":"http://p3.pstatp.com/large/5e10002068b75501fde","imgsmall":"http://p3.pstatp.com/w202/5e10002068b75501fd"},{"title":"","imgbig":"http://p3.pstatp.com/large/5e100020681dcf1aced","imgsmall":"http://p3.pstatp.com/w202/5e100020681dcf1ace"},{"title":"面对镜子看着毕业照站的位子，我陷入了沉思\u2026\u2026","imgbig":"http://p9.pstatp.com/large/5e3000181b4df726e8c","imgsmall":"http://p9.pstatp.com/w202/5e3000181b4df726e8"},{"title":"喜当爹！","imgbig":"http://p2.pstatp.com/large/6847/8221670073","imgsmall":"http://p2.pstatp.com/w202/6847/822167007"},{"title":"","imgbig":"http://p2.pstatp.com/large/6959/3971344555","imgsmall":"http://p2.pstatp.com/w202/6959/397134455"},{"title":"我已经相信，有些人我永远不必等","imgbig":"http://p1.pstatp.com/large/6878/7104711464","imgsmall":"http://p1.pstatp.com/w202/6878/710471146"},{"title":"拼爹的","imgbig":"http://p3.pstatp.com/large/5e200020a6451db2fc8","imgsmall":"http://p3.pstatp.com/w202/5e200020a6451db2fc"},{"title":"","imgbig":"http://p2.pstatp.com/large/11e00040baa15c1b1d5","imgsmall":"http://p2.pstatp.com/w202/11e00040baa15c1b1d"},{"title":"！","imgbig":"http://p3.pstatp.com/large/e40004cff446d71fe1","imgsmall":"http://p3.pstatp.com/w202/e40004cff446d71fe"},{"title":"怎么看(⊙o⊙)","imgbig":"http://p3.pstatp.com/large/5e00001bfb5881dbd3f","imgsmall":"http://p3.pstatp.com/w202/5e00001bfb5881dbd3"},{"title":"这。。。","imgbig":"http://p3.pstatp.com/large/1740/8526336174","imgsmall":"http://p3.pstatp.com/w202/1740/852633617"},{"title":"很长很有爱的GIF，值得认真看完","imgbig":"http://p1.pstatp.com/large/1443/4918501734","imgsmall":"http://p1.pstatp.com/w202/1443/491850173"}]
     */

    private String msg;
    private String message;
    /**
     * title : 汪:你吓不到我的。
     * imgbig : http://p5.pstatp.com/large/1390/5260457957
     * imgsmall : http://p5.pstatp.com/w202/1390/526045795
     */

    private List<DataEntity> data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public String getMessage() {
        return message;
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
