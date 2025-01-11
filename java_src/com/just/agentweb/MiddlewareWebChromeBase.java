package com.just.agentweb;

/* loaded from: classes.dex */
public class MiddlewareWebChromeBase extends WebChromeClientDelegate {
    private MiddlewareWebChromeBase mMiddlewareWebChromeBase;

    protected MiddlewareWebChromeBase(android.webkit.WebChromeClient webChromeClient) {
        super(webChromeClient);
    }

    protected MiddlewareWebChromeBase() {
        super(null);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate
    final void setDelegate(android.webkit.WebChromeClient webChromeClient) {
        super.setDelegate(webChromeClient);
    }

    final MiddlewareWebChromeBase enq(MiddlewareWebChromeBase middlewareWebChromeBase) {
        setDelegate(middlewareWebChromeBase);
        this.mMiddlewareWebChromeBase = middlewareWebChromeBase;
        return middlewareWebChromeBase;
    }

    final MiddlewareWebChromeBase next() {
        return this.mMiddlewareWebChromeBase;
    }
}
