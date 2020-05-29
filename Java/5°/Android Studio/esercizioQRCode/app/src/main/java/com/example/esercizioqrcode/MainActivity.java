package com.example.esercizioqrcode;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnScansiona = null;
    private WebView miaWebView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnScansiona = findViewById(R.id.btnScansiona);
        miaWebView = findViewById(R.id.wvsito);
        miaWebView.getSettings().setJavaScriptEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnScansiona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miaWebView.getSettings().setJavaScriptEnabled(true);
                miaWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                miaWebView.getSettings().setSupportMultipleWindows(true);
                miaWebView.setWebViewClient(new WebViewClient());
                miaWebView.setWebChromeClient(new WebChromeClient());
                miaWebView.loadUrl("http://www.google.com");
            }
        });
    }
}