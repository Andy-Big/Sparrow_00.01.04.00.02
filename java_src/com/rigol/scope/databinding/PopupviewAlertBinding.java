package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class PopupviewAlertBinding extends ViewDataBinding {
    public final View buttonBackground;
    public final Button cancel;
    public final TextView content;
    public final View dividingLine;
    public final Guideline guidelineCenter;
    public final ImageView icon;
    public final Button ok;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewAlertBinding(Object obj, View view, int i, View view2, Button button, TextView textView, View view3, Guideline guideline, ImageView imageView, Button button2, TextView textView2) {
        super(obj, view, i);
        this.buttonBackground = view2;
        this.cancel = button;
        this.content = textView;
        this.dividingLine = view3;
        this.guidelineCenter = guideline;
        this.icon = imageView;
        this.ok = button2;
        this.title = textView2;
    }

    public static PopupviewAlertBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAlertBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewAlertBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_alert, viewGroup, z, obj);
    }

    public static PopupviewAlertBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAlertBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewAlertBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_alert, null, false, obj);
    }

    public static PopupviewAlertBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAlertBinding bind(View view, Object obj) {
        return (PopupviewAlertBinding) bind(obj, view, R.layout.popupview_alert);
    }
}
