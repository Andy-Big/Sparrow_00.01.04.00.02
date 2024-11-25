package com.just.agentweb;

import android.os.Build;
import android.webkit.WebView;
/* loaded from: classes.dex */
public class DefaultWebLifeCycleImpl implements WebLifeCycle {
    private WebView mWebView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultWebLifeCycleImpl(WebView webView) {
        this.mWebView = webView;
    }

    @Override // com.just.agentweb.WebLifeCycle
    public void onResume() {
        if (this.mWebView != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.mWebView.onResume();
            }
            this.mWebView.resumeTimers();
        }
    }

    @Override // com.just.agentweb.WebLifeCycle
    public void onPause() {
        if (this.mWebView != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.mWebView.onPause();
            }
            this.mWebView.pauseTimers();
        }
    }

    @Override // com.just.agentweb.WebLifeCycle
    public void onDestroy() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.resumeTimers();
        }
        AgentWebUtils.clearWebView(this.mWebView);
    }
}
