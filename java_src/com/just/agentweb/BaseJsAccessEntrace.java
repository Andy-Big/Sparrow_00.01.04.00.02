package com.just.agentweb;

import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebView;
/* loaded from: classes.dex */
public abstract class BaseJsAccessEntrace implements JsAccessEntrace {
    public static final String TAG = BaseJsAccessEntrace.class.getSimpleName();
    private WebView mWebView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseJsAccessEntrace(WebView webView) {
        this.mWebView = webView;
    }

    @Override // com.just.agentweb.JsAccessEntrace
    public void callJs(String str, ValueCallback<String> valueCallback) {
        if (Build.VERSION.SDK_INT >= 19) {
            evaluateJs(str, valueCallback);
        } else {
            loadJs(str);
        }
    }

    @Override // com.just.agentweb.JsAccessEntrace
    public void callJs(String str) {
        callJs(str, null);
    }

    private void loadJs(String str) {
        this.mWebView.loadUrl(str);
    }

    private void evaluateJs(String str, final ValueCallback<String> valueCallback) {
        this.mWebView.evaluateJavascript(str, new ValueCallback<String>() { // from class: com.just.agentweb.BaseJsAccessEntrace.1
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str2) {
                ValueCallback valueCallback2 = valueCallback;
                if (valueCallback2 != null) {
                    valueCallback2.onReceiveValue(str2);
                }
            }
        });
    }

    @Override // com.just.agentweb.QuickCallJs
    public void quickCallJs(String str, ValueCallback<String> valueCallback, String... strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:" + str);
        if (strArr == null || strArr.length == 0) {
            sb.append("()");
        } else {
            sb.append("(");
            sb.append(concat(strArr));
            sb.append(")");
        }
        callJs(sb.toString(), valueCallback);
    }

    private String concat(String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (!AgentWebUtils.isJson(str)) {
                sb.append("\"");
                sb.append(str);
                sb.append("\"");
            } else {
                sb.append(str);
            }
            if (i != strArr.length - 1) {
                sb.append(" , ");
            }
        }
        return sb.toString();
    }

    @Override // com.just.agentweb.QuickCallJs
    public void quickCallJs(String str, String... strArr) {
        quickCallJs(str, null, strArr);
    }

    @Override // com.just.agentweb.QuickCallJs
    public void quickCallJs(String str) {
        quickCallJs(str, null);
    }
}
