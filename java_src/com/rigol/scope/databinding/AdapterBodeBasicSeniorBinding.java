package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class AdapterBodeBasicSeniorBinding extends ViewDataBinding {
    public final TextView bodeDisp;
    public final SwitchButton bodeFirEnable;
    public final SwitchButton bodeImpedance;
    public final TextView bodeSourceOut;
    public final TextView bodeSweepType;
    public final Guideline leftGuideline;
    public final Guideline leftGuideline1;
    public final Guideline leftGuideline2;
    public final Guideline leftGuideline3;
    @Bindable
    protected BodeParam mParma;
    public final TextView msgBodeSourceIn;
    public final ImageView operateButton;
    public final SwitchButton showBodeSwitch;
    public final TextView tipsButton;

    public abstract void setParma(BodeParam bodeParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterBodeBasicSeniorBinding(Object obj, View view, int i, TextView textView, SwitchButton switchButton, SwitchButton switchButton2, TextView textView2, TextView textView3, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, TextView textView4, ImageView imageView, SwitchButton switchButton3, TextView textView5) {
        super(obj, view, i);
        this.bodeDisp = textView;
        this.bodeFirEnable = switchButton;
        this.bodeImpedance = switchButton2;
        this.bodeSourceOut = textView2;
        this.bodeSweepType = textView3;
        this.leftGuideline = guideline;
        this.leftGuideline1 = guideline2;
        this.leftGuideline2 = guideline3;
        this.leftGuideline3 = guideline4;
        this.msgBodeSourceIn = textView4;
        this.operateButton = imageView;
        this.showBodeSwitch = switchButton3;
        this.tipsButton = textView5;
    }

    public BodeParam getParma() {
        return this.mParma;
    }

    public static AdapterBodeBasicSeniorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBodeBasicSeniorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterBodeBasicSeniorBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bode_basic_senior, viewGroup, z, obj);
    }

    public static AdapterBodeBasicSeniorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBodeBasicSeniorBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterBodeBasicSeniorBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bode_basic_senior, null, false, obj);
    }

    public static AdapterBodeBasicSeniorBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBodeBasicSeniorBinding bind(View view, Object obj) {
        return (AdapterBodeBasicSeniorBinding) bind(obj, view, R.layout.adapter_bode_basic_senior);
    }
}
