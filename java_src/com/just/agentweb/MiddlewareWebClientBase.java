package com.just.agentweb;
/* loaded from: classes.dex */
public class MiddlewareWebClientBase extends WebViewClientDelegate {
    private static String TAG = MiddlewareWebClientBase.class.getSimpleName();
    private MiddlewareWebClientBase mMiddleWrareWebClientBase;

    MiddlewareWebClientBase(MiddlewareWebClientBase middlewareWebClientBase) {
        super(middlewareWebClientBase);
        this.mMiddleWrareWebClientBase = middlewareWebClientBase;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MiddlewareWebClientBase(android.webkit.WebViewClient webViewClient) {
        super(webViewClient);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MiddlewareWebClientBase() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MiddlewareWebClientBase next() {
        return this.mMiddleWrareWebClientBase;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.just.agentweb.WebViewClientDelegate
    public final void setDelegate(android.webkit.WebViewClient webViewClient) {
        super.setDelegate(webViewClient);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MiddlewareWebClientBase enq(MiddlewareWebClientBase middlewareWebClientBase) {
        setDelegate(middlewareWebClientBase);
        this.mMiddleWrareWebClientBase = middlewareWebClientBase;
        return middlewareWebClientBase;
    }
}
