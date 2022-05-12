package com.example.qrcode_audisio;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class SitiWeb extends AppCompatActivity {

    private WebView miaWebView = null;
    private TextView urlText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siti_web);
        miaWebView = findViewById(R.id.miaWebView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        miaWebView.getSettings().setJavaScriptEnabled(true);
        miaWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        miaWebView.getSettings().setSupportMultipleWindows(true);
        miaWebView.setWebViewClient(new WebViewClient());
        miaWebView.setWebChromeClient(new WebChromeClient());
        miaWebView.loadUrl("urlText");
    }

    protected void setUrl(TextView txtUrl){
        urlText = txtUrl;
    }

}