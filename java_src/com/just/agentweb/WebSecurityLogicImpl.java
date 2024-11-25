package com.just.agentweb;

import android.os.Build;
import android.webkit.WebView;
import androidx.collection.ArrayMap;
import com.just.agentweb.AgentWeb;
/* loaded from: classes.dex */
public class WebSecurityLogicImpl implements WebSecurityCheckLogic {
    private String TAG = getClass().getSimpleName();
    private int webviewType;

    public static WebSecurityLogicImpl getInstance(int i) {
        return new WebSecurityLogicImpl(i);
    }

    public WebSecurityLogicImpl(int i) {
        this.webviewType = i;
    }

    @Override // com.just.agentweb.WebSecurityCheckLogic
    public void dealHoneyComb(WebView webView) {
        if (11 > Build.VERSION.SDK_INT || Build.VERSION.SDK_INT > 17) {
            return;
        }
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
    }

    @Override // com.just.agentweb.WebSecurityCheckLogic
    public void dealJsInterface(ArrayMap<String, Object> arrayMap, AgentWeb.SecurityType securityType) {
        if (securityType != AgentWeb.SecurityType.STRICT_CHECK || this.webviewType == 2 || Build.VERSION.SDK_INT >= 17) {
            return;
        }
        LogUtils.e(this.TAG, "Give up all inject objects");
        arrayMap.clear();
        System.gc();
    }
}
