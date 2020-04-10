package com.example.covid3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class shop_order extends AppCompatActivity {
    private WebView webView_6;
    Activity activity_6 ;
    private ProgressDialog progDailog_6;
    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_order);
        activity_6 = this;
        setTitle("Groceries");

        progDailog_6 = ProgressDialog.show(activity_6, "Loading","Please wait...", true);
        progDailog_6.setCancelable(false);
        webView_6 = (WebView) findViewById(R.id.webview6);
        WebSettings settings = webView_6.getSettings();
        settings.setDomStorageEnabled(true);



        webView_6.getSettings().setJavaScriptEnabled(true);
        webView_6.getSettings().setLoadWithOverviewMode(true);
        webView_6.getSettings().setUseWideViewPort(true);
        webView_6.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                progDailog_6.show();
                view.loadUrl(url);

                return true;
            }
            @Override
            public void onPageFinished(WebView view, final String url) {
                progDailog_6.dismiss();
            }
        });

        webView_6.loadUrl("https://www.bigbasket.com/");

    }
}

