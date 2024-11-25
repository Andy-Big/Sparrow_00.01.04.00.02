package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class PopupviewLoadingBinding extends ViewDataBinding {
    public final Button cancel;
    public final Button confirm;
    public final TextView content;
    public final View dividingLine;
    public final Guideline guidelineCenter;
    public final ContentLoadingProgressBar loading;
    @Bindable
    protected ObservableBoolean mShowCancel;
    @Bindable
    protected ObservableBoolean mShowConfirm;
    @Bindable
    protected ObservableBoolean mShowWrning;
    public final TextView title;
    public final TextView wrning;

    public abstract void setShowCancel(ObservableBoolean observableBoolean);

    public abstract void setShowConfirm(ObservableBoolean observableBoolean);

    public abstract void setShowWrning(ObservableBoolean observableBoolean);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewLoadingBinding(Object obj, View view, int i, Button button, Button button2, TextView textView, View view2, Guideline guideline, ContentLoadingProgressBar contentLoadingProgressBar, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.cancel = button;
        this.confirm = button2;
        this.content = textView;
        this.dividingLine = view2;
        this.guidelineCenter = guideline;
        this.loading = contentLoadingProgressBar;
        this.title = textView2;
        this.wrning = textView3;
    }

    public ObservableBoolean getShowCancel() {
        return this.mShowCancel;
    }

    public ObservableBoolean getShowConfirm() {
        return this.mShowConfirm;
    }

    public ObservableBoolean getShowWrning() {
        return this.mShowWrning;
    }

    public static PopupviewLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewLoadingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_loading, viewGroup, z, obj);
    }

    public static PopupviewLoadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewLoadingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewLoadingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_loading, null, false, obj);
    }

    public static PopupviewLoadingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewLoadingBinding bind(View view, Object obj) {
        return (PopupviewLoadingBinding) bind(obj, view, R.layout.popupview_loading);
    }
}
