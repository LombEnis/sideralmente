package com.google.android.stardroid.activities;

import android.os.Bundle;
import android.webkit.WebView;

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
        webView.loadUrl("https://www.google.com");
    }

}