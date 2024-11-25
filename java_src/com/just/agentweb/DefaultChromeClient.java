package com.just.agentweb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.just.agentweb.ActionActivity;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class DefaultChromeClient extends MiddlewareWebChromeBase {
    public static final String ANDROID_WEBCHROMECLIENT_PATH = "android.webkit.WebChromeClient";
    public static final int FROM_CODE_INTENTION = 24;
    public static final int FROM_CODE_INTENTION_LOCATION = 96;
    private String TAG;
    private WeakReference<Activity> mActivityWeakReference;
    private WeakReference<AbsAgentWebUIController> mAgentWebUIController;
    private GeolocationPermissions.Callback mCallback;
    private Object mFileChooser;
    private IVideo mIVideo;
    private IndicatorController mIndicatorController;
    private boolean mIsWrapper;
    private String mOrigin;
    private PermissionInterceptor mPermissionInterceptor;
    private ActionActivity.PermissionListener mPermissionListener;
    private android.webkit.WebChromeClient mWebChromeClient;
    private WebView mWebView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultChromeClient(Activity activity, IndicatorController indicatorController, android.webkit.WebChromeClient webChromeClient, IVideo iVideo, PermissionInterceptor permissionInterceptor, WebView webView) {
        super(webChromeClient);
        this.mActivityWeakReference = null;
        this.TAG = DefaultChromeClient.class.getSimpleName();
        this.mIsWrapper = false;
        this.mOrigin = null;
        this.mCallback = null;
        this.mAgentWebUIController = null;
        this.mPermissionListener = new ActionActivity.PermissionListener() { // from class: com.just.agentweb.DefaultChromeClient.1
            @Override // com.just.agentweb.ActionActivity.PermissionListener
            public void onRequestPermissionsResult(String[] strArr, int[] iArr, Bundle bundle) {
                if (bundle.getInt(ActionActivity.KEY_FROM_INTENTION) == 96) {
                    boolean hasPermission = AgentWebUtils.hasPermission((Context) DefaultChromeClient.this.mActivityWeakReference.get(), strArr);
                    if (DefaultChromeClient.this.mCallback != null) {
                        if (hasPermission) {
                            DefaultChromeClient.this.mCallback.invoke(DefaultChromeClient.this.mOrigin, true, false);
                        } else {
                            DefaultChromeClient.this.mCallback.invoke(DefaultChromeClient.this.mOrigin, false, false);
                        }
                        DefaultChromeClient.this.mCallback = null;
                        DefaultChromeClient.this.mOrigin = null;
                    }
                    if (hasPermission || DefaultChromeClient.this.mAgentWebUIController.get() == null) {
                        return;
                    }
                    ((AbsAgentWebUIController) DefaultChromeClient.this.mAgentWebUIController.get()).onPermissionsDeny(AgentWebPermissions.LOCATION, AgentWebPermissions.ACTION_LOCATION, AgentWebPermissions.ACTION_LOCATION);
                }
            }
        };
        this.mIndicatorController = indicatorController;
        this.mIsWrapper = webChromeClient != null;
        this.mWebChromeClient = webChromeClient;
        this.mActivityWeakReference = new WeakReference<>(activity);
        this.mIVideo = iVideo;
        this.mPermissionInterceptor = permissionInterceptor;
        this.mWebView = webView;
        this.mAgentWebUIController = new WeakReference<>(AgentWebUtils.getAgentWebUIControllerByWebView(webView));
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        IndicatorController indicatorController = this.mIndicatorController;
        if (indicatorController != null) {
            indicatorController.progress(webView, i);
        }
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        if (this.mIsWrapper) {
            super.onReceivedTitle(webView, str);
        }
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.mAgentWebUIController.get() != null) {
            this.mAgentWebUIController.get().onJsAlert(webView, str, str2);
        }
        jsResult.confirm();
        return true;
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        super.onReceivedIcon(webView, bitmap);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        super.onGeolocationPermissionsHidePrompt();
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        onGeolocationPermissionsShowPromptInternal(str, callback);
    }

    private void onGeolocationPermissionsShowPromptInternal(String str, GeolocationPermissions.Callback callback) {
        PermissionInterceptor permissionInterceptor = this.mPermissionInterceptor;
        if (permissionInterceptor != null && permissionInterceptor.intercept(this.mWebView.getUrl(), AgentWebPermissions.LOCATION, "location")) {
            callback.invoke(str, false, false);
            return;
        }
        Activity activity = this.mActivityWeakReference.get();
        if (activity == null) {
            callback.invoke(str, false, false);
            return;
        }
        List<String> deniedPermissions = AgentWebUtils.getDeniedPermissions(activity, AgentWebPermissions.LOCATION);
        if (deniedPermissions.isEmpty()) {
            LogUtils.i(this.TAG, "onGeolocationPermissionsShowPromptInternal:true");
            callback.invoke(str, true, false);
            return;
        }
        Action createPermissionsAction = Action.createPermissionsAction((String[]) deniedPermissions.toArray(new String[0]));
        createPermissionsAction.setFromIntention(96);
        ActionActivity.setPermissionListener(this.mPermissionListener);
        this.mCallback = callback;
        this.mOrigin = str;
        ActionActivity.start(activity, createPermissionsAction);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        try {
            if (this.mAgentWebUIController.get() != null) {
                this.mAgentWebUIController.get().onJsPrompt(this.mWebView, str, str2, str3, jsPromptResult);
                return true;
            }
            return true;
        } catch (Exception e) {
            if (LogUtils.isDebug()) {
                e.printStackTrace();
                return true;
            }
            return true;
        }
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.mAgentWebUIController.get() != null) {
            this.mAgentWebUIController.get().onJsConfirm(webView, str, str2, jsResult);
            return true;
        }
        return true;
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(j3 * 2);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(j * 2);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        LogUtils.i(this.TAG, "openFileChooser>=5.0");
        return openFileChooserAboveL(webView, valueCallback, fileChooserParams);
    }

    private boolean openFileChooserAboveL(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        String str = this.TAG;
        LogUtils.i(str, "fileChooserParams:" + fileChooserParams.getAcceptTypes() + "  getTitle:" + ((Object) fileChooserParams.getTitle()) + " accept:" + Arrays.toString(fileChooserParams.getAcceptTypes()) + " length:" + fileChooserParams.getAcceptTypes().length + "  isCaptureEnabled:" + fileChooserParams.isCaptureEnabled() + "  " + fileChooserParams.getFilenameHint() + "  intent:" + fileChooserParams.createIntent().toString() + "   mode:" + fileChooserParams.getMode());
        Activity activity = this.mActivityWeakReference.get();
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        return AgentWebUtils.showFileChooserCompat(activity, this.mWebView, valueCallback, fileChooserParams, this.mPermissionInterceptor, null, null, null);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        LogUtils.i(this.TAG, "openFileChooser>=4.1");
        createAndOpenCommonFileChooser(valueCallback, str);
    }

    @Override // com.just.agentweb.WebChromeClientDelegate
    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        Log.i(this.TAG, "openFileChooser<3.0");
        createAndOpenCommonFileChooser(valueCallback, "*/*");
    }

    @Override // com.just.agentweb.WebChromeClientDelegate
    public void openFileChooser(ValueCallback valueCallback, String str) {
        Log.i(this.TAG, "openFileChooser>3.0");
        createAndOpenCommonFileChooser(valueCallback, str);
    }

    private void createAndOpenCommonFileChooser(ValueCallback valueCallback, String str) {
        Activity activity = this.mActivityWeakReference.get();
        if (activity == null || activity.isFinishing()) {
            valueCallback.onReceiveValue(new Object());
        } else {
            AgentWebUtils.showFileChooserCompat(activity, this.mWebView, null, null, this.mPermissionInterceptor, valueCallback, str, null);
        }
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        super.onConsoleMessage(consoleMessage);
        return true;
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        IVideo iVideo = this.mIVideo;
        if (iVideo != null) {
            iVideo.onShowCustomView(view, customViewCallback);
        }
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onHideCustomView() {
        IVideo iVideo = this.mIVideo;
        if (iVideo != null) {
            iVideo.onHideCustomView();
        }
    }
}
