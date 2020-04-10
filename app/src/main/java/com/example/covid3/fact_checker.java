package com.example.covid3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class fact_checker extends AppCompatActivity {
    private WebView webView_2;
    Activity activity_2 ;
    private ProgressDialog progDailog_2;
    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fact_checker);
        activity_2 = this;
        setTitle("Beware of Fake News");
        progDailog_2 = ProgressDialog.show(activity_2, "Loading","Please wait...", true);
        progDailog_2.setCancelable(false);
        webView_2 = (WebView) findViewById(R.id.webview2);
        WebSettings settings = webView_2.getSettings();
        settings.setDomStorageEnabled(true);



        webView_2.getSettings().setJavaScriptEnabled(true);
        webView_2.getSettings().setLoadWithOverviewMode(true);
        webView_2.getSettings().setUseWideViewPort(true);
        webView_2.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                progDailog_2.show();
                view.loadUrl(url);

                return true;
            }
            @Override
            public void onPageFinished(WebView view, final String url) {
                progDailog_2.dismiss();
            }
        });

        webView_2.loadUrl("http://factcheck.ksp.gov.in/");

    }
}



