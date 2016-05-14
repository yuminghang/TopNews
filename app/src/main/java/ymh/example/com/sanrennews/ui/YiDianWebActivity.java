package ymh.example.com.sanrennews.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import ymh.example.com.sanrennews.R;

public class YiDianWebActivity extends AppCompatActivity {

    private WebView mYidianWebWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yi_dian_web);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        mYidianWebWebView = (WebView) findViewById(R.id.yidianWeb);
        mYidianWebWebView.loadUrl(url);

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
