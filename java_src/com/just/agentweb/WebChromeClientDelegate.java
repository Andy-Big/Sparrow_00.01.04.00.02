package com.just.agentweb;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
/* loaded from: classes.dex */
public class WebChromeClientDelegate extends android.webkit.WebChromeClient {
    private android.webkit.WebChromeClient mDelegate;

    protected android.webkit.WebChromeClient getDelegate() {
        return this.mDelegate;
    }

    public WebChromeClientDelegate(android.webkit.WebChromeClient webChromeClient) {
        this.mDelegate = webChromeClient;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDelegate(android.webkit.WebChromeClient webChromeClient) {
        this.mDelegate = webChromeClient;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onProgressChanged(webView, i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onReceivedTitle(webView, str);
        } else {
            super.onReceivedTitle(webView, str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onReceivedIcon(webView, bitmap);
        } else {
            super.onReceivedIcon(webView, bitmap);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onReceivedTouchIconUrl(webView, str, z);
        } else {
            super.onReceivedTouchIconUrl(webView, str, z);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onShowCustomView(view, customViewCallback);
        } else {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onShowCustomView(view, i, customViewCallback);
        } else {
            super.onShowCustomView(view, i, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onHideCustomView();
        } else {
            super.onHideCustomView();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            return webChromeClient.onCreateWindow(webView, z, z2, message);
        }
        return super.onCreateWindow(webView, z, z2, message);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView webView) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onRequestFocus(webView);
        } else {
            super.onRequestFocus(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onCloseWindow(webView);
        } else {
            super.onCloseWindow(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            return webChromeClient.onJsAlert(webView, str, str2, jsResult);
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            return webChromeClient.onJsConfirm(webView, str, str2, jsResult);
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            return webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            return webChromeClient.onJsBeforeUnload(webView, str, str2, jsResult);
        }
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        } else {
            super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        } else {
            super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onGeolocationPermissionsShowPrompt(str, callback);
        } else {
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onGeolocationPermissionsHidePrompt();
        } else {
            super.onGeolocationPermissionsHidePrompt();
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onPermissionRequest(permissionRequest);
        } else {
            super.onPermissionRequest(permissionRequest);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onPermissionRequestCanceled(permissionRequest);
        } else {
            super.onPermissionRequestCanceled(permissionRequest);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            return webChromeClient.onJsTimeout();
        }
        return super.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onConsoleMessage(String str, int i, String str2) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.onConsoleMessage(str, i, str2);
        } else {
            super.onConsoleMessage(str, i, str2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            return webChromeClient.onConsoleMessage(consoleMessage);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            return webChromeClient.getDefaultVideoPoster();
        }
        return super.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            return webChromeClient.getVideoLoadingProgressView();
        }
        return super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            webChromeClient.getVisitedHistory(valueCallback);
        } else {
            super.getVisitedHistory(valueCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        android.webkit.WebChromeClient webChromeClient = this.mDelegate;
        if (webChromeClient != null) {
            return webChromeClient.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }
        return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        commonRefect(this.mDelegate, "openFileChooser", new Object[]{valueCallback, str, str2}, ValueCallback.class, String.class, String.class);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        commonRefect(this.mDelegate, "openFileChooser", new Object[]{valueCallback}, ValueCallback.class);
    }

    public void openFileChooser(ValueCallback valueCallback, String str) {
        commonRefect(this.mDelegate, "openFileChooser", new Object[]{valueCallback, str}, ValueCallback.class, String.class);
    }

    private void commonRefect(android.webkit.WebChromeClient webChromeClient, String str, Object[] objArr, Class... clsArr) {
        if (webChromeClient == null) {
            return;
        }
        try {
            webChromeClient.getClass().getMethod(str, clsArr).invoke(webChromeClient, objArr);
        } catch (Exception e) {
            if (LogUtils.isDebug()) {
                e.printStackTrace();
            }
        }
    }
}
