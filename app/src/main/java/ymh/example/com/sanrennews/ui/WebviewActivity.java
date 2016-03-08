package ymh.example.com.sanrennews.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import java.util.ArrayList;

import ymh.example.com.sanrennews.R;
import ymh.example.com.sanrennews.bean.JsonBean;

public class WebviewActivity extends AppCompatActivity {

    private WebView webview;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);

        data = getIntent().getStringExtra("data");
        webview = (WebView) findViewById(R.id.webView1);
        webview.loadUrl(data);
    }
}
