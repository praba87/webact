package com.gameboxmini.webviewmodel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

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

        @SuppressLint("SetJavaScriptEnabled")
        public void initializeWebView(WebView mWebView) {
            WebSettings webSettings = mWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setBuiltInZoomControls(false);
            webSettings.setSupportZoom(false);
            webSettings.setDomStorageEnabled(true);
            webSettings.setLoadWithOverviewMode(true);
            webSettings.setUseWideViewPort(true);
            mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            mWebView.setScrollbarFadingEnabled(true);
            webSettings.setAppCacheEnabled(true);
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            CookieManager.getInstance().setAcceptCookie(true);
        }
    }
}
