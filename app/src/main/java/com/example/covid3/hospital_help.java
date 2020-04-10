package com.example.covid3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class hospital_help extends AppCompatActivity {
    private WebView webView_4;
    Activity activity_4 ;
    private ProgressDialog progDailog_4;
    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_help);
        activity_4 = this;
        setTitle("Report Fake News");

        progDailog_4 = ProgressDialog.show(activity_4, "Loading","Please wait...", true);
        progDailog_4.setCancelable(false);
        webView_4 = (WebView) findViewById(R.id.webview4);
        WebSettings settings = webView_4.getSettings();
        settings.setDomStorageEnabled(true);



        webView_4.getSettings().setJavaScriptEnabled(true);
        webView_4.getSettings().setLoadWithOverviewMode(true);
        webView_4.getSettings().setUseWideViewPort(true);
        webView_4.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                progDailog_4.show();
                view.loadUrl(url);

                return true;
            }
            @Override
            public void onPageFinished(WebView view, final String url) {
                progDailog_4.dismiss();
            }
        });

        webView_4.loadUrl("https://covid-19iit.000webhostapp.com/");

    }
}

