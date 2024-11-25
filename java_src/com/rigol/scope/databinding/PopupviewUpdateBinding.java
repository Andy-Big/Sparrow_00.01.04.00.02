package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.lib.data.Firmware;
import com.rigol.scope.R;
import com.rigol.scope.data.UpdateParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.views.NumberProgressBar;
/* loaded from: classes2.dex */
public abstract class PopupviewUpdateBinding extends ViewDataBinding {
    public final View buttonLayout;
    public final Button cancel;
    public final TextView content;
    public final ScrollView contentLayout;
    public final NumberProgressBar downloadProgress;
    public final TextView errorText;
    public final Guideline guidelineCenter;
    public final ConstraintLayout installLayout;
    public final ContentLoadingProgressBar installProgress;
    public final TextView installText;
    @Bindable
    protected Firmware mFirmware;
    @Bindable
    protected UpdateParam mUpdateParam;
    @Bindable
    protected UtilityParam mUtilityParam;
    public final Button ok;

    public abstract void setFirmware(Firmware firmware);

    public abstract void setUpdateParam(UpdateParam updateParam);

    public abstract void setUtilityParam(UtilityParam utilityParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewUpdateBinding(Object obj, View view, int i, View view2, Button button, TextView textView, ScrollView scrollView, NumberProgressBar numberProgressBar, TextView textView2, Guideline guideline, ConstraintLayout constraintLayout, ContentLoadingProgressBar contentLoadingProgressBar, TextView textView3, Button button2) {
        super(obj, view, i);
        this.buttonLayout = view2;
        this.cancel = button;
        this.content = textView;
        this.contentLayout = scrollView;
        this.downloadProgress = numberProgressBar;
        this.errorText = textView2;
        this.guidelineCenter = guideline;
        this.installLayout = constraintLayout;
        this.installProgress = contentLoadingProgressBar;
        this.installText = textView3;
        this.ok = button2;
    }

    public UtilityParam getUtilityParam() {
        return this.mUtilityParam;
    }

    public Firmware getFirmware() {
        return this.mFirmware;
    }

    public UpdateParam getUpdateParam() {
        return this.mUpdateParam;
    }

    public static PopupviewUpdateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewUpdateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewUpdateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_update, viewGroup, z, obj);
    }

    public static PopupviewUpdateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewUpdateBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewUpdateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_update, null, false, obj);
    }

    public static PopupviewUpdateBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewUpdateBinding bind(View view, Object obj) {
        return (PopupviewUpdateBinding) bind(obj, view, R.layout.popupview_update);
    }
}
