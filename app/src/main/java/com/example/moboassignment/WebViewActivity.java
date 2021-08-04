package com.example.moboassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class WebViewActivity extends AppCompatActivity {

    TextView tv;
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        tv = (TextView)findViewById(R.id.textCallNo);
        wv = (WebView)findViewById(R.id.webView);

        String Information = getIntent().getStringExtra("KeyLinkInfo");
        tv.setText("Website: "+Information);

        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("http://"+Information);


    }

    @Override
    public void onBackPressed() {
        if (wv.canGoBack()) {
            wv.goBack();
        } else {
            super.onBackPressed();
        }
    }
}