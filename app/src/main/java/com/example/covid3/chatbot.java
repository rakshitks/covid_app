package com.example.covid3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class chatbot extends AppCompatActivity {
    private WebView webView_8;
    Activity activity_8 ;
    private ProgressDialog progDailog_8;
    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);
        activity_8 = this;
        setTitle("Report Fake News");

        progDailog_8 = ProgressDialog.show(activity_8, "Loading","Please wait...", true);
        progDailog_8.setCancelable(false);
        webView_8 = (WebView) findViewById(R.id.webview8);
        WebSettings settings = webView_8.getSettings();
        settings.setDomStorageEnabled(true);



        webView_8.getSettings().setJavaScriptEnabled(true);
        webView_8.getSettings().setBuiltInZoomControls(true);
        webView_8.getSettings().setLoadWithOverviewMode(true);
        webView_8.getSettings().setUseWideViewPort(true);
        webView_8.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                progDailog_8.show();
                view.loadUrl(url);

                return true;
            }
            @Override
            public void onPageFinished(WebView view, final String url) {
                progDailog_8.dismiss();
            }

        });

        webView_8.loadUrl("http://anticovid-chatbot.000webhostapp.com/");


    }
}

