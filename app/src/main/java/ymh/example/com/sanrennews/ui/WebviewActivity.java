package ymh.example.com.sanrennews.ui;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.ArrayList;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import ymh.example.com.sanrennews.R;
import ymh.example.com.sanrennews.bean.JsonBean;
import ymh.example.com.sanrennews.utils.HttpUtils;

public class WebviewActivity extends SwipeBackActivity {

    private WebView webview;
    private String url, title;
    private String content;
    private SwipeBackLayout mSwipeBackLayout;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            content = msg.getData().getString("content");
//            spilt(content);
            webview.loadDataWithBaseURL("", content, "text/html", "utf-8", "");
        }
    };

    public void spilt(String s) {
        int start = s.indexOf("投诉指引");
        start += 4;
        content = s.substring(start);
        int end = content.indexOf("相关标签");
//        if(end>0)
        content = content.substring(0, end);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        url = getIntent().getStringExtra("url");
        title = getIntent().getStringExtra("title");
        webview = (WebView) findViewById(R.id.webView1);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        HttpUtils.getData(url, handler);
//        webview.getSettings().setBuiltInZoomControls(true); //显示放大缩小 controler
//        webview.getSettings().setSupportZoom(true); //可以缩放
//        webview.loadUrl(data);
    }
}
