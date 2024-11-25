package com.rigol.scope.views.openSourceLicense;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blankj.utilcode.util.ActivityUtils;
import com.just.agentweb.AgentWeb;
import com.rigol.scope.R;
import com.rigol.scope.databinding.PopupviewOpensourceBinding;
import com.rigol.scope.utilities.ReflectUtil;
import com.rigol.scope.views.baseview.BasePopupView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: OpenSourceLicensePopupView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/rigol/scope/views/openSourceLicense/OpenSourceLicensePopupView;", "Lcom/rigol/scope/views/baseview/BasePopupView;", "()V", "mAgentWeb", "Lcom/just/agentweb/AgentWeb;", "getMAgentWeb", "()Lcom/just/agentweb/AgentWeb;", "setMAgentWeb", "(Lcom/just/agentweb/AgentWeb;)V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class OpenSourceLicensePopupView extends BasePopupView {
    private AgentWeb mAgentWeb;

    public OpenSourceLicensePopupView() {
        super((int) R.style.App_PopupWindow_OpenSourceLicense);
        PopupviewOpensourceBinding inflate = PopupviewOpensourceBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(inflate, "PopupviewOpensourceBindi…utInflater.from(context))");
        setContentView(inflate.getRoot());
        TextView it = (TextView) inflate.getRoot().findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        it.setText("Open Source Acknowledgment");
        ReflectUtil.hookWebView();
        this.mAgentWeb = AgentWeb.with(ActivityUtils.getTopActivity()).setAgentWebParent(inflate.webview, new ViewGroup.LayoutParams(-1, -1)).useDefaultIndicator().createAgentWeb().ready().go("file:///android_asset/opensource.htm");
    }

    public final AgentWeb getMAgentWeb() {
        return this.mAgentWeb;
    }

    public final void setMAgentWeb(AgentWeb agentWeb) {
        this.mAgentWeb = agentWeb;
    }
}
