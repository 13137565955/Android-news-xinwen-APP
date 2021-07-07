package com.example.ex5_1_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ContentActivity extends AppCompatActivity {
    WebView wv_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        wv_content= (WebView) findViewById(R.id.wv_content);
        wv_content.getSettings().setJavaScriptEnabled(true);//启用JavaScript
        wv_content.setWebViewClient(new WebViewClient());//在同一个webview中显示超链接
        Intent intent=getIntent();
        String content_url=intent.getStringExtra("content_url");
        wv_content.loadUrl(content_url);
    }
}
