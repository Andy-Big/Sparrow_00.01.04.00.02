package com.just.agentweb;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebView;
/* loaded from: classes.dex */
public class LollipopFixedWebView extends WebView {
    public LollipopFixedWebView(Context context) {
        super(getFixedContext(context));
    }

    public LollipopFixedWebView(Context context, AttributeSet attributeSet) {
        super(getFixedContext(context), attributeSet);
    }

    public LollipopFixedWebView(Context context, AttributeSet attributeSet, int i) {
        super(getFixedContext(context), attributeSet, i);
    }

    public LollipopFixedWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(getFixedContext(context), attributeSet, i, i2);
    }

    public LollipopFixedWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(getFixedContext(context), attributeSet, i, z);
    }

    public static Context getFixedContext(Context context) {
        return (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT >= 23) ? context : context.createConfigurationContext(new Configuration());
    }
}
