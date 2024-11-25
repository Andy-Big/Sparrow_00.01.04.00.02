package com.rigol.scope.views.openSourceLicense;

import android.view.LayoutInflater;
import android.widget.TextView;
import com.blankj.utilcode.util.LogUtils;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.just.agentweb.AgentWeb;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.databinding.PopuviewHelpBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HelpPopuwin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\u001a\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/rigol/scope/views/openSourceLicense/HelpPopuwin;", "Lcom/rigol/scope/views/baseview/BasePopupView;", "Lcom/github/barteksc/pdfviewer/listener/OnPageChangeListener;", "Lcom/github/barteksc/pdfviewer/listener/OnLoadCompleteListener;", "Lcom/github/barteksc/pdfviewer/listener/OnPageErrorListener;", "()V", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "mAgentWeb", "Lcom/just/agentweb/AgentWeb;", "getMAgentWeb", "()Lcom/just/agentweb/AgentWeb;", "setMAgentWeb", "(Lcom/just/agentweb/AgentWeb;)V", "utilityParam", "Lcom/rigol/scope/data/UtilityParam;", "loadComplete", "", "nbPages", "", "onPageChanged", "page", "pageCount", "onPageError", "t", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class HelpPopuwin extends BasePopupView implements OnPageChangeListener, OnLoadCompleteListener, OnPageErrorListener {
    private File file;
    private AgentWeb mAgentWeb;
    private UtilityParam utilityParam;

    @Override // com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
    public void loadComplete(int i) {
    }

    @Override // com.github.barteksc.pdfviewer.listener.OnPageChangeListener
    public void onPageChanged(int i, int i2) {
    }

    @Override // com.github.barteksc.pdfviewer.listener.OnPageErrorListener
    public void onPageError(int i, Throwable th) {
    }

    public HelpPopuwin() {
        super((int) R.style.App_PopupWindow_OpenSourceLicense);
        PopuviewHelpBinding inflate = PopuviewHelpBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(inflate, "PopuviewHelpBinding.infl…utInflater.from(context))");
        setContentView(inflate.getRoot());
        this.utilityParam = ((UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class)).getValue();
        TextView it = (TextView) inflate.getRoot().findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        it.setText("Help documentation");
        UtilityParam utilityParam = this.utilityParam;
        Intrinsics.checkNotNull(utilityParam);
        UtilityParam utilityParam2 = this.utilityParam;
        Intrinsics.checkNotNull(utilityParam2);
        LogUtils.e("series", Integer.valueOf(utilityParam.getSeries()), Integer.valueOf(utilityParam2.getLanguage()));
        UtilityParam utilityParam3 = this.utilityParam;
        Intrinsics.checkNotNull(utilityParam3);
        if (utilityParam3.getSeries() == 800) {
            UtilityParam utilityParam4 = this.utilityParam;
            Intrinsics.checkNotNull(utilityParam4);
            if (utilityParam4.getLanguage() == ServiceEnum.SystemLanguage.language_chinese.value1) {
                this.file = new File("/rigol/resource/DHO800_EmbeddedHelp_CN.pdf");
            } else {
                this.file = new File("/rigol/resource/DHO800_EmbeddedHelp_EN.pdf");
            }
        } else {
            UtilityParam utilityParam5 = this.utilityParam;
            Intrinsics.checkNotNull(utilityParam5);
            if (utilityParam5.getLanguage() == ServiceEnum.SystemLanguage.language_chinese.value1) {
                this.file = new File("/rigol/resource/DHO900_EmbeddedHelp_CN.pdf");
            } else {
                this.file = new File("/rigol/resource/DHO900_EmbeddedHelp_EN.pdf");
            }
        }
        if (this.file != null) {
            LogUtils.e("file", "kongjkos");
            inflate.webview.fromFile(this.file).defaultPage(1).onPageChange(this).enableAnnotationRendering(true).onLoad(this).scrollHandle(new DefaultScrollHandle(this.context)).spacing(10).onPageError(this).load();
        }
    }

    public final AgentWeb getMAgentWeb() {
        return this.mAgentWeb;
    }

    public final void setMAgentWeb(AgentWeb agentWeb) {
        this.mAgentWeb = agentWeb;
    }

    public final File getFile() {
        return this.file;
    }

    public final void setFile(File file) {
        this.file = file;
    }
}
