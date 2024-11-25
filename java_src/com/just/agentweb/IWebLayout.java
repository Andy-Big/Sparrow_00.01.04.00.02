package com.just.agentweb;

import android.view.ViewGroup;
import android.webkit.WebView;
/* loaded from: classes.dex */
public interface IWebLayout<T extends WebView, V extends ViewGroup> {
    V getLayout();

    T getWebView();
}
