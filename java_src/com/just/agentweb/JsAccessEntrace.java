package com.just.agentweb;

import android.webkit.ValueCallback;
/* loaded from: classes.dex */
public interface JsAccessEntrace extends QuickCallJs {
    void callJs(String str);

    void callJs(String str, ValueCallback<String> valueCallback);
}
