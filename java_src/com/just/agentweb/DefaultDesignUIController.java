package com.just.agentweb;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
/* loaded from: classes.dex */
public class DefaultDesignUIController extends DefaultUIController {
    private static final int RECYCLERVIEW_ID = 4097;
    private Activity mActivity = null;
    private BottomSheetDialog mBottomSheetDialog;
    private LayoutInflater mLayoutInflater;
    private WebParentLayout mWebParentLayout;

    @Override // com.just.agentweb.DefaultUIController, com.just.agentweb.AbsAgentWebUIController
    public void onJsAlert(WebView webView, String str, String str2) {
        onJsAlertInternal(webView, str2);
    }

    private void onJsAlertInternal(WebView webView, String str) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            try {
                AgentWebUtils.show(webView, str, -1, -1, activity.getResources().getColor(R.color.black), null, -1, null);
            } catch (Throwable th) {
                if (LogUtils.isDebug()) {
                    th.printStackTrace();
                }
            }
        }
    }

    @Override // com.just.agentweb.DefaultUIController, com.just.agentweb.AbsAgentWebUIController
    public void onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // com.just.agentweb.DefaultUIController, com.just.agentweb.AbsAgentWebUIController
    public void onSelectItemsPrompt(WebView webView, String str, String[] strArr, Handler.Callback callback) {
        showChooserInternal(webView, str, strArr, callback);
    }

    @Override // com.just.agentweb.DefaultUIController, com.just.agentweb.AbsAgentWebUIController
    public void onForceDownloadAlert(String str, Handler.Callback callback) {
        super.onForceDownloadAlert(str, callback);
    }

    private void showChooserInternal(WebView webView, String str, String[] strArr, final Handler.Callback callback) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            String str2 = this.TAG;
            LogUtils.i(str2, "url:" + str + "  ways:" + strArr[0]);
            if (this.mBottomSheetDialog == null) {
                this.mBottomSheetDialog = new BottomSheetDialog(activity);
                RecyclerView recyclerView = new RecyclerView(activity);
                recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                recyclerView.setId(4097);
                this.mBottomSheetDialog.setContentView(recyclerView);
            }
            ((RecyclerView) this.mBottomSheetDialog.getDelegate().findViewById(4097)).setAdapter(getAdapter(strArr, callback));
            this.mBottomSheetDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.just.agentweb.DefaultDesignUIController.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    Handler.Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.handleMessage(Message.obtain((Handler) null, -1));
                    }
                }
            });
            this.mBottomSheetDialog.show();
        }
    }

    private RecyclerView.Adapter getAdapter(final String[] strArr, final Handler.Callback callback) {
        return new RecyclerView.Adapter<BottomSheetHolder>() { // from class: com.just.agentweb.DefaultDesignUIController.2
            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public BottomSheetHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                return new BottomSheetHolder(DefaultDesignUIController.this.mLayoutInflater.inflate(17367043, viewGroup, false));
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void onBindViewHolder(BottomSheetHolder bottomSheetHolder, final int i) {
                TypedValue typedValue = new TypedValue();
                DefaultDesignUIController.this.mActivity.getTheme().resolveAttribute(16843534, typedValue, true);
                bottomSheetHolder.mTextView.setBackgroundResource(typedValue.resourceId);
                bottomSheetHolder.mTextView.setText(strArr[i]);
                bottomSheetHolder.mTextView.setOnClickListener(new View.OnClickListener() { // from class: com.just.agentweb.DefaultDesignUIController.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (DefaultDesignUIController.this.mBottomSheetDialog != null && DefaultDesignUIController.this.mBottomSheetDialog.isShowing()) {
                            DefaultDesignUIController.this.mBottomSheetDialog.dismiss();
                        }
                        Message obtain = Message.obtain();
                        obtain.what = i;
                        callback.handleMessage(obtain);
                    }
                });
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return strArr.length;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class BottomSheetHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public BottomSheetHolder(View view) {
            super(view);
            this.mTextView = (TextView) view.findViewById(16908308);
        }
    }

    @Override // com.just.agentweb.DefaultUIController, com.just.agentweb.AbsAgentWebUIController
    public void onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // com.just.agentweb.DefaultUIController, com.just.agentweb.AbsAgentWebUIController
    protected void bindSupportWebParent(WebParentLayout webParentLayout, Activity activity) {
        super.bindSupportWebParent(webParentLayout, activity);
        this.mActivity = activity;
        this.mWebParentLayout = webParentLayout;
        this.mLayoutInflater = LayoutInflater.from(activity);
    }

    @Override // com.just.agentweb.DefaultUIController, com.just.agentweb.AbsAgentWebUIController
    public void onShowMessage(String str, String str2) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            if (TextUtils.isEmpty(str2) || !str2.contains("performDownload")) {
                onJsAlertInternal(this.mWebParentLayout.getWebView(), str);
            }
        }
    }
}
