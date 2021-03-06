package ymh.example.com.sanrennews.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by ymh on 2016/3/9.
 */
public class HttpUtils {

    private static OkHttpClient client;
    private static String resString;



    public static String getHtml(String content) {
        final StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>");
        sb.append("<html dir=\"ltr\" lang=\"zh\">");
        sb.append("<head>");
        sb.append("<meta name=\"viewport\" content=\"width=50%; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;\" />");
//        sb.append("<link rel=\"stylesheet\" href='file:///android_asset/style.css' type=\"text/css\" media=\"screen\" />");
        sb.append("<style>");
        sb.append("img{max-width:30%;height:auto;}");
        sb.append("img {max-width:200px; width:200px;width:expression_r(document.body.clientWidth>280 ? \"280px\" : this.width); height:auto}");
        sb.append(".profile_avatar{font-size:50%;img-size:40%}");
//        sb.append(".time{font-size:50%}");subtitle clearfix
//        sb.append(".subtitle{display:none} ");
//        sb.append("h1 {color:red; font-size:30px;width:340px}");
        sb.append("</style>");
        sb.append("</head>");
        sb.append("<body style=\"padding:0px 0px 0px 8px;\">");
        sb.append("<div id=\"pagewrapper\">");
        sb.append("<div id=\"mainwrapper\" class=\"clearfix\">");
        sb.append("<div id=\"maincontent\">");
        sb.append("<div class=\"post\">");
        sb.append("<div class=\"posthit\">");
        sb.append("<div class=\"postinfo\">");
        sb.append("<h2 class=\"thetitle\">");
        sb.append("</h2>");
//        sb.append(freshNews.getAuthor().getName() + " @ " + String2TimeUtil
//                .dateString2GoodExperienceFormat(freshNews.getDate()));
        sb.append("</div>");
        sb.append("<div class=\"entry\">");
        sb.append(content);
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

    public static void getData(String url, final Handler handler) {
        client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                //NOT UI Thread
                if (response.isSuccessful()) {
                    String resString = response.body().string();

                    Message msg = new Message();
                    Bundle b = new Bundle();
                    b.putString("content", resString);
                    msg.setData(b);
                    handler.sendMessage(msg);
                }
            }
        });
    }
}
