package com.example.covid3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class prediction extends AppCompatActivity {
    private WebView webView_1;
    Activity activity_1 ;
    private ProgressDialog progDailog_1;
    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);
        activity_1 = this;
        setTitle("Covid19 Symptoms Checker");

        progDailog_1 = ProgressDialog.show(activity_1, "Loading","Please wait...", true);
        progDailog_1.setCancelable(false);
        webView_1 = (WebView) findViewById(R.id.webview1);
        WebSettings settings = webView_1.getSettings();
        settings.setDomStorageEnabled(true);



        webView_1.getSettings().setJavaScriptEnabled(true);
        webView_1.getSettings().setLoadWithOverviewMode(true);
        webView_1.getSettings().setUseWideViewPort(true);
        webView_1.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                progDailog_1.show();
                view.loadUrl(url);

                return true;
            }
            @Override
            public void onPageFinished(WebView view, final String url) {
                progDailog_1.dismiss();
            }
        });

        webView_1.loadUrl("https://covid.bhaarat.ai/workflow");

    }
}

