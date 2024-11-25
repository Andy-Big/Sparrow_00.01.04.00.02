package com.just.agentweb;

import android.webkit.DownloadListener;
import android.webkit.WebView;
/* loaded from: classes.dex */
public interface WebListenerManager {
    WebListenerManager setDownloader(WebView webView, DownloadListener downloadListener);

    WebListenerManager setWebChromeClient(WebView webView, android.webkit.WebChromeClient webChromeClient);

    WebListenerManager setWebViewClient(WebView webView, android.webkit.WebViewClient webViewClient);
}
