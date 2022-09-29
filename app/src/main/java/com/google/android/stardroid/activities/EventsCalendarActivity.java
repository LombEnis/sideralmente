package com.google.android.stardroid.activities;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.stardroid.R;

public class EventsCalendarActivity extends InjectableActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getApplicationComponent().inject(this);
        setContentView(R.layout.activity_events_calendar);

        setUpViews();
        setUpWebView();
    }

    private void setUpViews() {
        webView = findViewById(R.id.events_calendar_web_view);
    }

    private void setUpWebView() {
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.sideralmente.it/app/eventi");
    }

}