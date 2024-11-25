package com.just.agentweb;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DefaultWebCreator implements WebCreator {
    private static final String TAG = DefaultWebCreator.class.getSimpleName();
    private Activity mActivity;
    private BaseIndicatorSpec mBaseIndicatorSpec;
    private int mColor;
    private FrameLayout mFrameLayout;
    private int mHeight;
    private IWebLayout mIWebLayout;
    private int mIndex;
    private boolean mIsCreated;
    private boolean mIsNeedDefaultProgress;
    private ViewGroup.LayoutParams mLayoutParams;
    private BaseIndicatorView mProgressView;
    private View mTargetProgress;
    private ViewGroup mViewGroup;
    private WebView mWebView;
    private int mWebViewType;

    /* JADX INFO: Access modifiers changed from: protected */
    public DefaultWebCreator(Activity activity, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, int i2, int i3, WebView webView, IWebLayout iWebLayout) {
        this.mLayoutParams = null;
        this.mColor = -1;
        this.mIsCreated = false;
        this.mWebView = null;
        this.mFrameLayout = null;
        this.mWebViewType = 1;
        this.mActivity = activity;
        this.mViewGroup = viewGroup;
        this.mIsNeedDefaultProgress = true;
        this.mIndex = i;
        this.mColor = i2;
        this.mLayoutParams = layoutParams;
        this.mHeight = i3;
        this.mWebView = webView;
        this.mIWebLayout = iWebLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DefaultWebCreator(Activity activity, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, WebView webView, IWebLayout iWebLayout) {
        this.mLayoutParams = null;
        this.mColor = -1;
        this.mIsCreated = false;
        this.mWebView = null;
        this.mFrameLayout = null;
        this.mWebViewType = 1;
        this.mActivity = activity;
        this.mViewGroup = viewGroup;
        this.mIsNeedDefaultProgress = false;
        this.mIndex = i;
        this.mLayoutParams = layoutParams;
        this.mWebView = webView;
        this.mIWebLayout = iWebLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DefaultWebCreator(Activity activity, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, BaseIndicatorView baseIndicatorView, WebView webView, IWebLayout iWebLayout) {
        this.mLayoutParams = null;
        this.mColor = -1;
        this.mIsCreated = false;
        this.mWebView = null;
        this.mFrameLayout = null;
        this.mWebViewType = 1;
        this.mActivity = activity;
        this.mViewGroup = viewGroup;
        this.mIsNeedDefaultProgress = false;
        this.mIndex = i;
        this.mLayoutParams = layoutParams;
        this.mProgressView = baseIndicatorView;
        this.mWebView = webView;
        this.mIWebLayout = iWebLayout;
    }

    public void setWebView(WebView webView) {
        this.mWebView = webView;
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public View getTargetProgress() {
        return this.mTargetProgress;
    }

    public void setTargetProgress(View view) {
        this.mTargetProgress = view;
    }

    @Override // com.just.agentweb.WebCreator
    public DefaultWebCreator create() {
        if (this.mIsCreated) {
            return this;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Activity activity = this.mActivity;
            String currentProcessName = ProcessUtils.getCurrentProcessName(activity);
            if (!activity.getApplicationContext().getPackageName().equals(currentProcessName)) {
                try {
                    WebView.setDataDirectorySuffix(currentProcessName);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        this.mIsCreated = true;
        ViewGroup viewGroup = this.mViewGroup;
        if (viewGroup == null) {
            FrameLayout frameLayout = (FrameLayout) createLayout();
            this.mFrameLayout = frameLayout;
            this.mActivity.setContentView(frameLayout);
        } else if (this.mIndex == -1) {
            FrameLayout frameLayout2 = (FrameLayout) createLayout();
            this.mFrameLayout = frameLayout2;
            viewGroup.addView(frameLayout2, this.mLayoutParams);
        } else {
            FrameLayout frameLayout3 = (FrameLayout) createLayout();
            this.mFrameLayout = frameLayout3;
            viewGroup.addView(frameLayout3, this.mIndex, this.mLayoutParams);
        }
        return this;
    }

    @Override // com.just.agentweb.WebCreator
    public WebView getWebView() {
        return this.mWebView;
    }

    @Override // com.just.agentweb.WebCreator
    public FrameLayout getWebParentLayout() {
        return this.mFrameLayout;
    }

    @Override // com.just.agentweb.WebCreator
    public int getWebViewType() {
        return this.mWebViewType;
    }

    private ViewGroup createLayout() {
        View view;
        BaseIndicatorView baseIndicatorView;
        FrameLayout.LayoutParams offerLayoutParams;
        Activity activity = this.mActivity;
        WebParentLayout webParentLayout = new WebParentLayout(activity);
        webParentLayout.setId(R.id.web_parent_layout_id);
        webParentLayout.setBackgroundColor(-1);
        if (this.mIWebLayout == null) {
            WebView createWebView = createWebView();
            this.mWebView = createWebView;
            view = createWebView;
        } else {
            view = webLayout();
        }
        webParentLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        webParentLayout.bindWebView(this.mWebView);
        String str = TAG;
        LogUtils.i(str, "  instanceof  AgentWebView:" + (this.mWebView instanceof AgentWebView));
        if (this.mWebView instanceof AgentWebView) {
            this.mWebViewType = 2;
        }
        ViewStub viewStub = new ViewStub(activity);
        viewStub.setId(R.id.mainframe_error_viewsub_id);
        webParentLayout.addView(viewStub, new FrameLayout.LayoutParams(-1, -1));
        boolean z = this.mIsNeedDefaultProgress;
        if (z) {
            WebIndicator webIndicator = new WebIndicator(activity);
            if (this.mHeight > 0) {
                offerLayoutParams = new FrameLayout.LayoutParams(-2, AgentWebUtils.dp2px(activity, this.mHeight));
            } else {
                offerLayoutParams = webIndicator.offerLayoutParams();
            }
            int i = this.mColor;
            if (i != -1) {
                webIndicator.setColor(i);
            }
            offerLayoutParams.gravity = 48;
            this.mBaseIndicatorSpec = webIndicator;
            webParentLayout.addView(webIndicator, offerLayoutParams);
            webIndicator.setVisibility(8);
        } else if (!z && (baseIndicatorView = this.mProgressView) != null) {
            this.mBaseIndicatorSpec = baseIndicatorView;
            webParentLayout.addView(baseIndicatorView, baseIndicatorView.offerLayoutParams());
            this.mProgressView.setVisibility(8);
        }
        return webParentLayout;
    }

    private View webLayout() {
        WebView webView = this.mIWebLayout.getWebView();
        if (webView == null) {
            webView = createWebView();
            this.mIWebLayout.getLayout().addView(webView, -1, -1);
            LogUtils.i(TAG, "add webview");
        } else {
            this.mWebViewType = 3;
        }
        this.mWebView = webView;
        return this.mIWebLayout.getLayout();
    }

    private WebView createWebView() {
        WebView webView = this.mWebView;
        if (webView != null) {
            this.mWebViewType = 3;
            return webView;
        } else if (AgentWebConfig.IS_KITKAT_OR_BELOW_KITKAT) {
            AgentWebView agentWebView = new AgentWebView(this.mActivity);
            this.mWebViewType = 2;
            return agentWebView;
        } else {
            LollipopFixedWebView lollipopFixedWebView = new LollipopFixedWebView(this.mActivity);
            this.mWebViewType = 1;
            return lollipopFixedWebView;
        }
    }

    @Override // com.just.agentweb.IWebIndicator
    public BaseIndicatorSpec offer() {
        return this.mBaseIndicatorSpec;
    }
}
