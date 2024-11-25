package com.just.agentweb;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class WebParentLayout extends FrameLayout implements Provider<AbsAgentWebUIController> {
    private static final String TAG = WebParentLayout.class.getSimpleName();
    private AbsAgentWebUIController mAgentWebUIController;
    private int mClickId;
    private FrameLayout mErrorLayout;
    private int mErrorLayoutRes;
    private View mErrorView;
    private WebView mWebView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebParentLayout(Context context) {
        this(context, null);
        LogUtils.i(TAG, "WebParentLayout");
    }

    WebParentLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    WebParentLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAgentWebUIController = null;
        this.mClickId = -1;
        this.mErrorLayout = null;
        if (!(context instanceof Activity)) {
            throw new IllegalArgumentException("WebParentLayout context must be activity or activity sub class .");
        }
        this.mErrorLayoutRes = R.layout.agentweb_error_page;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bindController(AbsAgentWebUIController absAgentWebUIController) {
        this.mAgentWebUIController = absAgentWebUIController;
        absAgentWebUIController.bindWebParent(this, (Activity) getContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showPageMainFrameError() {
        View findViewById;
        FrameLayout frameLayout = this.mErrorLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        } else {
            createErrorLayout();
            frameLayout = this.mErrorLayout;
        }
        int i = this.mClickId;
        if (i != -1 && (findViewById = frameLayout.findViewById(i)) != null) {
            findViewById.setClickable(true);
        } else {
            frameLayout.setClickable(true);
        }
    }

    private void createErrorLayout() {
        final FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setBackgroundColor(-1);
        frameLayout.setId(R.id.mainframe_error_container_id);
        View view = this.mErrorView;
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(getContext());
            String str = TAG;
            LogUtils.i(str, "mErrorLayoutRes:" + this.mErrorLayoutRes);
            from.inflate(this.mErrorLayoutRes, (ViewGroup) frameLayout, true);
        } else {
            frameLayout.addView(view);
        }
        View view2 = (ViewStub) findViewById(R.id.mainframe_error_viewsub_id);
        int indexOfChild = indexOfChild(view2);
        removeViewInLayout(view2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            this.mErrorLayout = frameLayout;
            addView(frameLayout, indexOfChild, layoutParams);
        } else {
            this.mErrorLayout = frameLayout;
            addView(frameLayout, indexOfChild);
        }
        frameLayout.setVisibility(0);
        int i = this.mClickId;
        if (i != -1) {
            final View findViewById = frameLayout.findViewById(i);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.just.agentweb.WebParentLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (WebParentLayout.this.getWebView() != null) {
                            findViewById.setClickable(false);
                            WebParentLayout.this.getWebView().reload();
                        }
                    }
                });
                return;
            } else if (LogUtils.isDebug()) {
                LogUtils.e(TAG, "ClickView is null , cannot bind accurate view to refresh or reload .");
            }
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.just.agentweb.WebParentLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (WebParentLayout.this.getWebView() != null) {
                    frameLayout.setClickable(false);
                    WebParentLayout.this.getWebView().reload();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hideErrorLayout() {
        View findViewById = findViewById(R.id.mainframe_error_container_id);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setErrorView(View view) {
        this.mErrorView = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setErrorLayoutRes(int i, int i2) {
        this.mClickId = i2;
        if (i2 <= 0) {
            this.mClickId = -1;
        }
        this.mErrorLayoutRes = i;
        if (i <= 0) {
            this.mErrorLayoutRes = R.layout.agentweb_error_page;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.just.agentweb.Provider
    public AbsAgentWebUIController provide() {
        return this.mAgentWebUIController;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bindWebView(WebView webView) {
        if (this.mWebView == null) {
            this.mWebView = webView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebView getWebView() {
        return this.mWebView;
    }
}
