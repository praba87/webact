package com.gameboxmini.webviewmodel;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlUtils {
    public static String getHost(String url) throws MalformedURLException {
        System.out.println("cc");
        return new URL(url).getHost();
    }
}
