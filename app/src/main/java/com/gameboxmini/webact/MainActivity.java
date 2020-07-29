package com.gameboxmini.webact;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gameboxmini.webviewmodel.ToasterMessage;
import com.gameboxmini.webviewmodel.UrlWebView;
import com.gameboxmini.webviewmodel.util.UrlCheck;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ToasterMessage.s(MainActivity.this,"welcomeprabha");

        webView = findViewById(R.id.webView);
        new UrlWebView.init(this).initializeWebView(webView);
        webView.setWebViewClient(new Browser_home());
        webView.loadUrl("https://www.monstertechnocodes.com/");
    }

    private class Browser_home extends WebViewClient {

        Browser_home() {}

        @SuppressWarnings("deprecation")
        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {

            return UrlWebView.Urlloads(view,url) ? UrlCheck.createEmptyResource() :
                    super.shouldInterceptRequest(view, url);

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            System.out.println("welcome");
            super.onPageFinished(view, url);
        }

    }
}