package com.just.agentweb;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.alipay.sdk.app.H5PayCallback;
import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.util.H5PayResultModel;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class DefaultWebClient extends MiddlewareWebClientBase {
    public static final String ALIPAYS_SCHEME = "alipays://";
    public static final int ASK_USER_OPEN_OTHER_PAGE = 250;
    private static final int CONSTANTS_ABNORMAL_BIG = 7;
    public static final int DERECT_OPEN_OTHER_PAGE = 1001;
    public static final int DISALLOW_OPEN_OTHER_APP = 62;
    private static final boolean HAS_ALIPAY_LIB;
    public static final String HTTPS_SCHEME = "https://";
    public static final String HTTP_SCHEME = "http://";
    public static final String INTENT_SCHEME = "intent://";
    public static final String SCHEME_SMS = "sms:";
    private static final String TAG = DefaultWebClient.class.getSimpleName();
    public static final String WEBCHAT_PAY_SCHEME = "weixin://wap/pay?";
    private WeakReference<AbsAgentWebUIController> mAgentWebUIController;
    private Handler.Callback mCallback;
    private Set<String> mErrorUrlsSet;
    private boolean mIsInterceptUnkownUrl;
    private Object mPayTask;
    private int mUrlHandleWays;
    private Set<String> mWaittingFinishSet;
    private WeakReference<Activity> mWeakReference;
    private WebView mWebView;
    private android.webkit.WebViewClient mWebViewClient;
    private Method onMainFrameErrorMethod;
    private boolean webClientHelper;

    static {
        boolean z;
        try {
            Class.forName("com.alipay.sdk.app.PayTask");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        HAS_ALIPAY_LIB = z;
        LogUtils.i(TAG, "HAS_ALIPAY_LIB:" + HAS_ALIPAY_LIB);
    }

    DefaultWebClient(Builder builder) {
        super(builder.mClient);
        this.mWeakReference = null;
        this.webClientHelper = true;
        this.mUrlHandleWays = 250;
        this.mIsInterceptUnkownUrl = true;
        this.mAgentWebUIController = null;
        this.mCallback = null;
        this.onMainFrameErrorMethod = null;
        this.mErrorUrlsSet = new HashSet();
        this.mWaittingFinishSet = new HashSet();
        this.mWebView = builder.mWebView;
        this.mWebViewClient = builder.mClient;
        this.mWeakReference = new WeakReference<>(builder.mActivity);
        this.webClientHelper = builder.mWebClientHelper;
        this.mAgentWebUIController = new WeakReference<>(AgentWebUtils.getAgentWebUIControllerByWebView(builder.mWebView));
        this.mIsInterceptUnkownUrl = builder.mIsInterceptUnkownScheme;
        if (builder.mUrlHandleWays <= 0) {
            this.mUrlHandleWays = 250;
        } else {
            this.mUrlHandleWays = builder.mUrlHandleWays;
        }
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        if (uri.startsWith(HTTP_SCHEME) || uri.startsWith(HTTPS_SCHEME)) {
            return this.webClientHelper && HAS_ALIPAY_LIB && isAlipay(webView, uri);
        } else if (!this.webClientHelper) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        } else {
            if (handleCommonLink(uri)) {
                return true;
            }
            if (uri.startsWith(INTENT_SCHEME)) {
                handleIntentUrl(uri);
                LogUtils.i(TAG, "intent url ");
                return true;
            } else if (uri.startsWith(WEBCHAT_PAY_SCHEME)) {
                LogUtils.i(TAG, "lookup wechat to pay ~~");
                startActivity(uri);
                return true;
            } else if (uri.startsWith(ALIPAYS_SCHEME) && lookup(uri)) {
                LogUtils.i(TAG, "alipays url lookup alipay ~~ ");
                return true;
            } else if (queryActiviesNumber(uri) > 0 && deepLink(uri)) {
                String str = TAG;
                LogUtils.i(str, "intercept url:" + uri);
                return true;
            } else if (this.mIsInterceptUnkownUrl) {
                String str2 = TAG;
                LogUtils.i(str2, "intercept UnkownUrl :" + webResourceRequest.getUrl());
                return true;
            } else {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
        }
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
    }

    private boolean deepLink(String str) {
        ResolveInfo lookupResolveInfo;
        int i = this.mUrlHandleWays;
        if (i != 250) {
            if (i != 1001) {
                return false;
            }
            lookup(str);
            return true;
        }
        Activity activity = this.mWeakReference.get();
        if (activity == null || (lookupResolveInfo = lookupResolveInfo(str)) == null) {
            return false;
        }
        ActivityInfo activityInfo = lookupResolveInfo.activityInfo;
        String str2 = TAG;
        LogUtils.e(str2, "resolve package:" + lookupResolveInfo.activityInfo.packageName + " app package:" + activity.getPackageName());
        if (activityInfo != null && !TextUtils.isEmpty(activityInfo.packageName) && activityInfo.packageName.equals(activity.getPackageName())) {
            return lookup(str);
        }
        if (this.mAgentWebUIController.get() != null) {
            WebView webView = this.mWebView;
            this.mAgentWebUIController.get().onOpenPagePrompt(webView, webView.getUrl(), getCallback(str));
        }
        return true;
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(HTTP_SCHEME) || str.startsWith(HTTPS_SCHEME)) {
            return this.webClientHelper && HAS_ALIPAY_LIB && isAlipay(webView, str);
        } else if (this.webClientHelper) {
            if (handleCommonLink(str)) {
                return true;
            }
            if (str.startsWith(INTENT_SCHEME)) {
                handleIntentUrl(str);
                return true;
            } else if (str.startsWith(WEBCHAT_PAY_SCHEME)) {
                startActivity(str);
                return true;
            } else if (str.startsWith(ALIPAYS_SCHEME) && lookup(str)) {
                return true;
            } else {
                if (queryActiviesNumber(str) > 0 && deepLink(str)) {
                    LogUtils.i(TAG, "intercept OtherAppScheme");
                    return true;
                } else if (this.mIsInterceptUnkownUrl) {
                    String str2 = TAG;
                    LogUtils.i(str2, "intercept InterceptUnkownScheme : " + str);
                    return true;
                } else {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
        } else {
            return false;
        }
    }

    private int queryActiviesNumber(String str) {
        try {
            if (this.mWeakReference.get() == null) {
                return 0;
            }
            List<ResolveInfo> queryIntentActivities = this.mWeakReference.get().getPackageManager().queryIntentActivities(Intent.parseUri(str, 1), 65536);
            if (queryIntentActivities == null) {
                return 0;
            }
            return queryIntentActivities.size();
        } catch (URISyntaxException e) {
            if (LogUtils.isDebug()) {
                e.printStackTrace();
            }
            return 0;
        }
    }

    private void handleIntentUrl(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith(INTENT_SCHEME)) {
                if (lookup(str)) {
                }
            }
        } catch (Throwable th) {
            if (LogUtils.isDebug()) {
                th.printStackTrace();
            }
        }
    }

    private ResolveInfo lookupResolveInfo(String str) {
        try {
            Activity activity = this.mWeakReference.get();
            if (activity == null) {
                return null;
            }
            return activity.getPackageManager().resolveActivity(Intent.parseUri(str, 1), 65536);
        } catch (Throwable th) {
            if (LogUtils.isDebug()) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lookup(String str) {
        try {
            Activity activity = this.mWeakReference.get();
            if (activity == null) {
                return true;
            }
            PackageManager packageManager = activity.getPackageManager();
            Intent parseUri = Intent.parseUri(str, 1);
            if (packageManager.resolveActivity(parseUri, 65536) != null) {
                activity.startActivity(parseUri);
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (LogUtils.isDebug()) {
                th.printStackTrace();
                return false;
            }
            return false;
        }
    }

    private boolean isAlipay(final WebView webView, String str) {
        try {
            Activity activity = this.mWeakReference.get();
            if (activity == null) {
                return false;
            }
            if (this.mPayTask == null) {
                this.mPayTask = Class.forName("com.alipay.sdk.app.PayTask").getConstructor(Activity.class).newInstance(activity);
            }
            boolean payInterceptorWithUrl = ((PayTask) this.mPayTask).payInterceptorWithUrl(str, true, new H5PayCallback() { // from class: com.just.agentweb.DefaultWebClient.1
                public void onPayResult(H5PayResultModel h5PayResultModel) {
                    final String returnUrl = h5PayResultModel.getReturnUrl();
                    if (TextUtils.isEmpty(returnUrl)) {
                        return;
                    }
                    AgentWebUtils.runInUiThread(new Runnable() { // from class: com.just.agentweb.DefaultWebClient.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            webView.loadUrl(returnUrl);
                        }
                    });
                }
            });
            if (payInterceptorWithUrl) {
                String str2 = TAG;
                LogUtils.i(str2, "alipay-isIntercepted:" + payInterceptorWithUrl + "  url:" + str);
            }
            return payInterceptorWithUrl;
        } catch (Throwable th) {
            if (AgentWebConfig.DEBUG) {
                th.printStackTrace();
            }
            return false;
        }
    }

    private boolean handleCommonLink(String str) {
        if (str.startsWith("tel:") || str.startsWith(SCHEME_SMS) || str.startsWith("mailto:") || str.startsWith("geo:0,0?q=")) {
            try {
                Activity activity = this.mWeakReference.get();
                if (activity == null) {
                    return false;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                activity.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException e) {
                if (AgentWebConfig.DEBUG) {
                    e.printStackTrace();
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (!this.mWaittingFinishSet.contains(str)) {
            this.mWaittingFinishSet.add(str);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        String str3 = TAG;
        LogUtils.i(str3, "onReceivedError：" + str + "  CODE:" + i);
        onMainFrameError(webView, i, str, str2);
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (webResourceRequest.isForMainFrame() && webResourceError.getErrorCode() != -1) {
            onMainFrameError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
        String str = TAG;
        LogUtils.i(str, "onReceivedError:" + ((Object) webResourceError.getDescription()) + " code:" + webResourceError.getErrorCode());
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0035, code lost:
        if (r1 != null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void onMainFrameError(WebView webView, int i, String str, String str2) {
        this.mErrorUrlsSet.add(str2);
        android.webkit.WebViewClient webViewClient = this.mWebViewClient;
        if (webViewClient != null && this.webClientHelper) {
            Method method = this.onMainFrameErrorMethod;
            if (method == null) {
                method = AgentWebUtils.isExistMethod(webViewClient, "onMainFrameError", AbsAgentWebUIController.class, WebView.class, Integer.TYPE, String.class, String.class);
                this.onMainFrameErrorMethod = method;
            }
            try {
                method.invoke(this.mWebViewClient, this.mAgentWebUIController.get(), webView, Integer.valueOf(i), str, str2);
                return;
            } catch (Throwable th) {
                if (LogUtils.isDebug()) {
                    th.printStackTrace();
                    return;
                }
                return;
            }
        }
        if (this.mAgentWebUIController.get() != null) {
            this.mAgentWebUIController.get().onMainFrameError(webView, i, str, str2);
        }
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (!this.mErrorUrlsSet.contains(str) && this.mWaittingFinishSet.contains(str)) {
            if (this.mAgentWebUIController.get() != null) {
                this.mAgentWebUIController.get().onShowMainFrame();
            }
        } else {
            webView.setVisibility(0);
        }
        if (this.mWaittingFinishSet.contains(str)) {
            this.mWaittingFinishSet.remove(str);
        }
        if (!this.mErrorUrlsSet.isEmpty()) {
            this.mErrorUrlsSet.clear();
        }
        super.onPageFinished(webView, str);
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    private void startActivity(String str) {
        try {
            if (this.mWeakReference.get() == null) {
                return;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            this.mWeakReference.get().startActivity(intent);
        } catch (Exception e) {
            if (LogUtils.isDebug()) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f, float f2) {
        String str = TAG;
        LogUtils.i(str, "onScaleChanged:" + f + "   n:" + f2);
        if (f2 - f > 7.0f) {
            webView.setInitialScale((int) ((f / f2) * 100.0f));
        }
    }

    private Handler.Callback getCallback(final String str) {
        Handler.Callback callback = this.mCallback;
        if (callback != null) {
            return callback;
        }
        Handler.Callback callback2 = new Handler.Callback() { // from class: com.just.agentweb.DefaultWebClient.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what != 1) {
                    return true;
                }
                DefaultWebClient.this.lookup(str);
                return true;
            }
        };
        this.mCallback = callback2;
        return callback2;
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private Activity mActivity;
        private android.webkit.WebViewClient mClient;
        private boolean mIsInterceptUnkownScheme = true;
        private PermissionInterceptor mPermissionInterceptor;
        private int mUrlHandleWays;
        private boolean mWebClientHelper;
        private WebView mWebView;

        public Builder setActivity(Activity activity) {
            this.mActivity = activity;
            return this;
        }

        public Builder setClient(android.webkit.WebViewClient webViewClient) {
            this.mClient = webViewClient;
            return this;
        }

        public Builder setWebClientHelper(boolean z) {
            this.mWebClientHelper = z;
            return this;
        }

        public Builder setPermissionInterceptor(PermissionInterceptor permissionInterceptor) {
            this.mPermissionInterceptor = permissionInterceptor;
            return this;
        }

        public Builder setWebView(WebView webView) {
            this.mWebView = webView;
            return this;
        }

        public Builder setInterceptUnkownUrl(boolean z) {
            this.mIsInterceptUnkownScheme = z;
            return this;
        }

        public Builder setUrlHandleWays(int i) {
            this.mUrlHandleWays = i;
            return this;
        }

        public DefaultWebClient build() {
            return new DefaultWebClient(this);
        }
    }

    /* loaded from: classes.dex */
    public enum OpenOtherPageWays {
        DERECT(1001),
        ASK(250),
        DISALLOW(62);
        
        int code;

        OpenOtherPageWays(int i) {
            this.code = i;
        }
    }
}
