package com.just.agentweb;

/* loaded from: classes.dex */
public class MiddlewareWebClientBase extends WebViewClientDelegate {
    private static String TAG = MiddlewareWebClientBase.class.getSimpleName();
    private MiddlewareWebClientBase mMiddleWrareWebClientBase;

    MiddlewareWebClientBase(MiddlewareWebClientBase middlewareWebClientBase) {
        super(middlewareWebClientBase);
        this.mMiddleWrareWebClientBase = middlewareWebClientBase;
    }

    protected MiddlewareWebClientBase(android.webkit.WebViewClient webViewClient) {
        super(webViewClient);
    }

    protected MiddlewareWebClientBase() {
        super(null);
    }

    final MiddlewareWebClientBase next() {
        return this.mMiddleWrareWebClientBase;
    }

    @Override // com.just.agentweb.WebViewClientDelegate
    final void setDelegate(android.webkit.WebViewClient webViewClient) {
        super.setDelegate(webViewClient);
    }

    final MiddlewareWebClientBase enq(MiddlewareWebClientBase middlewareWebClientBase) {
        setDelegate(middlewareWebClientBase);
        this.mMiddleWrareWebClientBase = middlewareWebClientBase;
        return middlewareWebClientBase;
    }
}
