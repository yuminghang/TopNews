package ymh.example.com.sanrennews.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import ymh.example.com.sanrennews.R;
import ymh.example.com.sanrennews.base.BaseActivity;
import ymh.example.com.sanrennews.utils.HttpUtils;

public class ZakerWebViewActivity extends BaseActivity {
    private WebView webview;
    private String url, title;
    private String content;
    private SwipeBackLayout mSwipeBackLayout;
    private SwipeRefreshLayout swipeRefreshLayout;
    private static ProgressBar pb;

    private ListView listView;
    private String html;
    private Document doc;
    private Elements elements;
    private RelativeLayout back;
    private TextView tv_title;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            // 收到消息后执行handler
            webview.loadDataWithBaseURL("", html, "text/html", "utf-8", "");
            pb.setVisibility(View.INVISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zaker_web_view);
        url = getIntent().getStringExtra("url");
        initView();
        parseData();
    }

    private void initView() {
        back = (RelativeLayout) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_title = (TextView) findViewById(R.id.tv_title);
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        url = getIntent().getStringExtra("url");
        title = getIntent().getStringExtra("title");
        webview = (WebView) findViewById(R.id.webView);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        pb = (ProgressBar) findViewById(R.id.pb);
        pb.setVisibility(View.VISIBLE);
    }

    private void parseData() {
        try {
            new Thread(runnable).start();  // 子线程
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            getData();
            handler.sendEmptyMessage(0);
        }
    };


    private void getData() {
        //申明给服务端传递一个json串
        //创建一个OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request;
        request = new com.squareup.okhttp.Request.Builder()
                .url(url)
                .build();
        //发送请求获取响应
        try {
            Response response = okHttpClient.newCall(request).execute();
            //判断请求是否成功
            if (response.isSuccessful()) {
                //打印服务端返回结果
                html = response.body().string();
            } else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
