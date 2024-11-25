package com.just.agentweb;
/* loaded from: classes.dex */
public class MiddlewareWebChromeBase extends WebChromeClientDelegate {
    private MiddlewareWebChromeBase mMiddlewareWebChromeBase;

    /* JADX INFO: Access modifiers changed from: protected */
    public MiddlewareWebChromeBase(android.webkit.WebChromeClient webChromeClient) {
        super(webChromeClient);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MiddlewareWebChromeBase() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.just.agentweb.WebChromeClientDelegate
    public final void setDelegate(android.webkit.WebChromeClient webChromeClient) {
        super.setDelegate(webChromeClient);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MiddlewareWebChromeBase enq(MiddlewareWebChromeBase middlewareWebChromeBase) {
        setDelegate(middlewareWebChromeBase);
        this.mMiddlewareWebChromeBase = middlewareWebChromeBase;
        return middlewareWebChromeBase;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MiddlewareWebChromeBase next() {
        return this.mMiddlewareWebChromeBase;
    }
}
