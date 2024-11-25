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
public abstract class PopupviewPowerBinding extends ViewDataBinding {
    public final Button buttonRestart;
    public final Button buttonShutdowm;
    public final Button buttonSleep;
    public final View dividingLine;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final ImageView iconRestart;
    public final ImageView iconShutdown;
    public final ImageView iconSleep;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewPowerBinding(Object obj, View view, int i, Button button, Button button2, Button button3, View view2, Guideline guideline, Guideline guideline2, Guideline guideline3, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView) {
        super(obj, view, i);
        this.buttonRestart = button;
        this.buttonShutdowm = button2;
        this.buttonSleep = button3;
        this.dividingLine = view2;
        this.guidelineCenter = guideline;
        this.guidelineLeft = guideline2;
        this.guidelineRight = guideline3;
        this.iconRestart = imageView;
        this.iconShutdown = imageView2;
        this.iconSleep = imageView3;
        this.title = textView;
    }

    public static PopupviewPowerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewPowerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewPowerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_power, viewGroup, z, obj);
    }

    public static PopupviewPowerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewPowerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewPowerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_power, null, false, obj);
    }

    public static PopupviewPowerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewPowerBinding bind(View view, Object obj) {
        return (PopupviewPowerBinding) bind(obj, view, R.layout.popupview_power);
    }
}
