package com.gameboxmini.webviewmodel;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.gameboxmini.webviewmodel.util.UrlCheck;

import java.util.HashMap;
import java.util.Map;

public class UrlWebView {
    static Map<String, Boolean> loadedUrls = new HashMap<>();

    public static boolean Urlloads(WebView view, String url) {
        boolean ad;
        if (!loadedUrls.containsKey(url)) {
            ad = UrlCheck.isAd(url);
            loadedUrls.put(url, ad);
        } else {
            ad = loadedUrls.get(url);
        }
        return ad;
    }

    public static class init {
        Context context;

        public init(Context context) {
            UrlCheck.init(context);
            this.context = context;
        }

        public void initializeWebView(WebView mWebView) {
            WebSettings webSettings = mWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                webSettings.setDisplayZoomControls(false);
            }
            webSettings.setBuiltInZoomControls(true);
            webSettings.setSupportZoom(true);
            webSettings.setDomStorageEnabled(true);
        }
    }
}
