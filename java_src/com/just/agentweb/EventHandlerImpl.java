package com.just.agentweb;

import android.view.KeyEvent;
import android.webkit.WebView;
/* loaded from: classes.dex */
public class EventHandlerImpl implements IEventHandler {
    private EventInterceptor mEventInterceptor;
    private WebView mWebView;

    public static final EventHandlerImpl getInstantce(WebView webView, EventInterceptor eventInterceptor) {
        return new EventHandlerImpl(webView, eventInterceptor);
    }

    public EventHandlerImpl(WebView webView, EventInterceptor eventInterceptor) {
        this.mWebView = webView;
        this.mEventInterceptor = eventInterceptor;
    }

    @Override // com.just.agentweb.IEventHandler
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return back();
        }
        return false;
    }

    @Override // com.just.agentweb.IEventHandler
    public boolean back() {
        EventInterceptor eventInterceptor = this.mEventInterceptor;
        if (eventInterceptor == null || !eventInterceptor.event()) {
            WebView webView = this.mWebView;
            if (webView == null || !webView.canGoBack()) {
                return false;
            }
            this.mWebView.goBack();
            return true;
        }
        return true;
    }
}
