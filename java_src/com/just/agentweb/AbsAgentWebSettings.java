package com.just.agentweb;

import android.os.Build;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import kotlin.jvm.internal.LongCompanionObject;
/* loaded from: classes.dex */
public abstract class AbsAgentWebSettings implements IAgentWebSettings, WebListenerManager {
    private static final String TAG = AbsAgentWebSettings.class.getSimpleName();
    public static final String USERAGENT_AGENTWEB = " AgentWeb/4.1.3 ";
    public static final String USERAGENT_QQ_BROWSER = " MQQBrowser/8.0 ";
    public static final String USERAGENT_UC = " UCBrowser/11.6.4.950 ";
    protected AgentWeb mAgentWeb;
    private WebSettings mWebSettings;

    protected abstract void bindAgentWebSupport(AgentWeb agentWeb);

    public static AbsAgentWebSettings getInstance() {
        return new AgentWebSettingsImpl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void bindAgentWeb(AgentWeb agentWeb) {
        this.mAgentWeb = agentWeb;
        bindAgentWebSupport(agentWeb);
    }

    @Override // com.just.agentweb.IAgentWebSettings
    public IAgentWebSettings toSetting(WebView webView) {
        settings(webView);
        return this;
    }

    private void settings(WebView webView) {
        WebSettings settings = webView.getSettings();
        this.mWebSettings = settings;
        settings.setJavaScriptEnabled(true);
        this.mWebSettings.setSupportZoom(true);
        this.mWebSettings.setBuiltInZoomControls(false);
        this.mWebSettings.setSavePassword(false);
        if (AgentWebUtils.checkNetwork(webView.getContext())) {
            this.mWebSettings.setCacheMode(-1);
        } else {
            this.mWebSettings.setCacheMode(1);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.mWebSettings.setMixedContentMode(0);
            webView.setLayerType(2, null);
        } else if (Build.VERSION.SDK_INT >= 19) {
            webView.setLayerType(2, null);
        } else if (Build.VERSION.SDK_INT < 19) {
            webView.setLayerType(1, null);
        }
        this.mWebSettings.setTextZoom(100);
        this.mWebSettings.setDatabaseEnabled(true);
        this.mWebSettings.setAppCacheEnabled(true);
        this.mWebSettings.setLoadsImagesAutomatically(true);
        this.mWebSettings.setSupportMultipleWindows(false);
        this.mWebSettings.setBlockNetworkImage(false);
        this.mWebSettings.setAllowFileAccess(true);
        if (Build.VERSION.SDK_INT >= 16) {
            this.mWebSettings.setAllowFileAccessFromFileURLs(false);
            this.mWebSettings.setAllowUniversalAccessFromFileURLs(false);
        }
        this.mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 19) {
            this.mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        } else {
            this.mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        }
        this.mWebSettings.setLoadWithOverviewMode(false);
        this.mWebSettings.setUseWideViewPort(false);
        this.mWebSettings.setDomStorageEnabled(true);
        this.mWebSettings.setNeedInitialFocus(true);
        this.mWebSettings.setDefaultTextEncodingName("utf-8");
        this.mWebSettings.setDefaultFontSize(16);
        this.mWebSettings.setMinimumFontSize(12);
        this.mWebSettings.setGeolocationEnabled(true);
        String cachePath = AgentWebConfig.getCachePath(webView.getContext());
        String str = TAG;
        LogUtils.i(str, "dir:" + cachePath + "   appcache:" + AgentWebConfig.getCachePath(webView.getContext()));
        this.mWebSettings.setGeolocationDatabasePath(cachePath);
        this.mWebSettings.setDatabasePath(cachePath);
        this.mWebSettings.setAppCachePath(cachePath);
        this.mWebSettings.setAppCacheMaxSize(LongCompanionObject.MAX_VALUE);
        this.mWebSettings.setUserAgentString(getWebSettings().getUserAgentString().concat(USERAGENT_AGENTWEB).concat(USERAGENT_UC));
        String str2 = TAG;
        LogUtils.i(str2, "UserAgentString : " + this.mWebSettings.getUserAgentString());
    }

    @Override // com.just.agentweb.IAgentWebSettings
    public WebSettings getWebSettings() {
        return this.mWebSettings;
    }

    @Override // com.just.agentweb.WebListenerManager
    public WebListenerManager setWebChromeClient(WebView webView, android.webkit.WebChromeClient webChromeClient) {
        webView.setWebChromeClient(webChromeClient);
        return this;
    }

    @Override // com.just.agentweb.WebListenerManager
    public WebListenerManager setWebViewClient(WebView webView, android.webkit.WebViewClient webViewClient) {
        webView.setWebViewClient(webViewClient);
        return this;
    }

    @Override // com.just.agentweb.WebListenerManager
    public WebListenerManager setDownloader(WebView webView, DownloadListener downloadListener) {
        webView.setDownloadListener(downloadListener);
        return this;
    }
}
