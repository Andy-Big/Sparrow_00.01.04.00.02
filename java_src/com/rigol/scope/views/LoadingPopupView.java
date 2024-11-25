package com.rigol.scope.views;

import android.view.LayoutInflater;
import android.view.View;
import androidx.databinding.ObservableBoolean;
import com.rigol.scope.R;
import com.rigol.scope.databinding.PopupviewLoadingBinding;
import com.rigol.scope.views.baseview.BasePopupView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LoadingPopupView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R$\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000b¨\u0006!"}, d2 = {"Lcom/rigol/scope/views/LoadingPopupView;", "Lcom/rigol/scope/views/baseview/BasePopupView;", "()V", "binding", "Lcom/rigol/scope/databinding/PopupviewLoadingBinding;", "value", "", "contentResId", "getContentResId", "()I", "setContentResId", "(I)V", "isShowCancel", "Landroidx/databinding/ObservableBoolean;", "()Landroidx/databinding/ObservableBoolean;", "setShowCancel", "(Landroidx/databinding/ObservableBoolean;)V", "isShowConfirm", "setShowConfirm", "isShowWrning", "setShowWrning", "titleResId", "getTitleResId", "setTitleResId", "wrningResId", "getWrningResId", "setWrningResId", "onLocaleChanged", "", "setCancelListener", "listener", "Landroid/view/View$OnClickListener;", "setConfirmListener", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public class LoadingPopupView extends BasePopupView {
    private final PopupviewLoadingBinding binding;
    private int contentResId;
    private ObservableBoolean isShowCancel;
    private ObservableBoolean isShowConfirm;
    private ObservableBoolean isShowWrning;
    private int titleResId;
    private int wrningResId;

    public LoadingPopupView() {
        super((int) R.style.App_PopupWindow_Common_Loading);
        this.isShowCancel = new ObservableBoolean(false);
        this.isShowConfirm = new ObservableBoolean(false);
        this.isShowWrning = new ObservableBoolean(false);
        PopupviewLoadingBinding inflate = PopupviewLoadingBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(inflate, "PopupviewLoadingBinding.…utInflater.from(context))");
        inflate.setShowCancel(this.isShowCancel);
        inflate.setShowConfirm(this.isShowConfirm);
        inflate.setShowWrning(this.isShowWrning);
        Unit unit = Unit.INSTANCE;
        this.binding = inflate;
        this.titleResId = -1;
        this.contentResId = -1;
        this.wrningResId = -1;
        setContentView(inflate.getRoot());
    }

    public final ObservableBoolean isShowCancel() {
        return this.isShowCancel;
    }

    public final void setShowCancel(ObservableBoolean observableBoolean) {
        Intrinsics.checkNotNullParameter(observableBoolean, "<set-?>");
        this.isShowCancel = observableBoolean;
    }

    public final ObservableBoolean isShowConfirm() {
        return this.isShowConfirm;
    }

    public final void setShowConfirm(ObservableBoolean observableBoolean) {
        Intrinsics.checkNotNullParameter(observableBoolean, "<set-?>");
        this.isShowConfirm = observableBoolean;
    }

    public final ObservableBoolean isShowWrning() {
        return this.isShowWrning;
    }

    public final void setShowWrning(ObservableBoolean observableBoolean) {
        Intrinsics.checkNotNullParameter(observableBoolean, "<set-?>");
        this.isShowWrning = observableBoolean;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public final void setTitleResId(int i) {
        this.titleResId = i;
        if (i != -1) {
            this.binding.title.setText(this.titleResId);
        }
    }

    public final int getContentResId() {
        return this.contentResId;
    }

    public final void setContentResId(int i) {
        this.contentResId = i;
        if (i != -1) {
            this.binding.content.setText(this.contentResId);
        }
    }

    public final int getWrningResId() {
        return this.wrningResId;
    }

    public final void setWrningResId(int i) {
        this.wrningResId = i;
        if (i != -1) {
            this.binding.wrning.setText(this.wrningResId);
        }
    }

    public final void setCancelListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.binding.cancel.setOnClickListener(listener);
    }

    public final void setConfirmListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.binding.confirm.setOnClickListener(listener);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        setTitleResId(this.titleResId);
        setContentResId(this.contentResId);
    }
}
