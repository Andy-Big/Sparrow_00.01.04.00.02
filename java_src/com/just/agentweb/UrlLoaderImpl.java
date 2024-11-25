package com.just.agentweb;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import java.util.Map;
/* loaded from: classes.dex */
public class UrlLoaderImpl implements IUrlLoader {
    public static final String TAG = UrlLoaderImpl.class.getSimpleName();
    private Handler mHandler;
    private HttpHeaders mHttpHeaders;
    private WebView mWebView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UrlLoaderImpl(WebView webView, HttpHeaders httpHeaders) {
        this.mHandler = null;
        this.mWebView = webView;
        if (webView == null) {
            new NullPointerException("webview cannot be null .");
        }
        this.mHttpHeaders = httpHeaders;
        if (httpHeaders == null) {
            this.mHttpHeaders = HttpHeaders.create();
        }
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    private void safeLoadUrl(final String str) {
        this.mHandler.post(new Runnable() { // from class: com.just.agentweb.UrlLoaderImpl.1
            @Override // java.lang.Runnable
            public void run() {
                UrlLoaderImpl.this.loadUrl(str);
            }
        });
    }

    private void safeReload() {
        this.mHandler.post(new Runnable() { // from class: com.just.agentweb.UrlLoaderImpl.2
            @Override // java.lang.Runnable
            public void run() {
                UrlLoaderImpl.this.reload();
            }
        });
    }

    @Override // com.just.agentweb.IUrlLoader
    public void loadUrl(String str) {
        loadUrl(str, this.mHttpHeaders.getHeaders(str));
    }

    @Override // com.just.agentweb.IUrlLoader
    public void loadUrl(final String str, final Map<String, String> map) {
        if (!AgentWebUtils.isUIThread()) {
            AgentWebUtils.runInUiThread(new Runnable() { // from class: com.just.agentweb.UrlLoaderImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    UrlLoaderImpl.this.loadUrl(str, map);
                }
            });
        }
        String str2 = TAG;
        LogUtils.i(str2, "loadUrl:" + str + " headers:" + map);
        if (map == null || map.isEmpty()) {
            this.mWebView.loadUrl(str);
        } else {
            this.mWebView.loadUrl(str, map);
        }
    }

    @Override // com.just.agentweb.IUrlLoader
    public void reload() {
        if (!AgentWebUtils.isUIThread()) {
            this.mHandler.post(new Runnable() { // from class: com.just.agentweb.UrlLoaderImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    UrlLoaderImpl.this.reload();
                }
            });
        } else {
            this.mWebView.reload();
        }
    }

    @Override // com.just.agentweb.IUrlLoader
    public void loadData(final String str, final String str2, final String str3) {
        if (!AgentWebUtils.isUIThread()) {
            this.mHandler.post(new Runnable() { // from class: com.just.agentweb.UrlLoaderImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    UrlLoaderImpl.this.loadData(str, str2, str3);
                }
            });
        } else {
            this.mWebView.loadData(str, str2, str3);
        }
    }

    @Override // com.just.agentweb.IUrlLoader
    public void stopLoading() {
        if (!AgentWebUtils.isUIThread()) {
            this.mHandler.post(new Runnable() { // from class: com.just.agentweb.UrlLoaderImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    UrlLoaderImpl.this.stopLoading();
                }
            });
        } else {
            this.mWebView.stopLoading();
        }
    }

    @Override // com.just.agentweb.IUrlLoader
    public void loadDataWithBaseURL(final String str, final String str2, final String str3, final String str4, final String str5) {
        if (!AgentWebUtils.isUIThread()) {
            this.mHandler.post(new Runnable() { // from class: com.just.agentweb.UrlLoaderImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    UrlLoaderImpl.this.loadDataWithBaseURL(str, str2, str3, str4, str5);
                }
            });
        } else {
            this.mWebView.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // com.just.agentweb.IUrlLoader
    public void postUrl(final String str, final byte[] bArr) {
        if (!AgentWebUtils.isUIThread()) {
            this.mHandler.post(new Runnable() { // from class: com.just.agentweb.UrlLoaderImpl.8
                @Override // java.lang.Runnable
                public void run() {
                    UrlLoaderImpl.this.postUrl(str, bArr);
                }
            });
        } else {
            this.mWebView.postUrl(str, bArr);
        }
    }

    @Override // com.just.agentweb.IUrlLoader
    public HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = this.mHttpHeaders;
        if (httpHeaders == null) {
            HttpHeaders create = HttpHeaders.create();
            this.mHttpHeaders = create;
            return create;
        }
        return httpHeaders;
    }
}
