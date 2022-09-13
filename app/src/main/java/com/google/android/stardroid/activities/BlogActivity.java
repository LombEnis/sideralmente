package com.google.android.stardroid.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.stardroid.R;

public class BlogActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        setUpViews();
        setUpWebView();
    }

    private void setUpViews() {
        webView = findViewById(R.id.blog_web_view);
    }

    private void setUpWebView() {
        webView.loadUrl("https://www.google.com");
    }

}