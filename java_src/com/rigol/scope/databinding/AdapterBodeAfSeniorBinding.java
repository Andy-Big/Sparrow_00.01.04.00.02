package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class AdapterBodeAfSeniorBinding extends ViewDataBinding {
    public final TextView bodeAmpout;
    public final TextView bodeBodevaramp1;
    public final TextView bodeBodevaramp2;
    public final TextView bodeBodevaramp3;
    public final TextView bodeBodevaramp4;
    public final TextView bodeBodevaramp5;
    public final TextView bodeBodevaramp6;
    public final TextView bodeBodevaramp7;
    public final TextView bodeBodevaramp8;
    public final TextView bodePointNum;
    public final TextView bodeStartFreq;
    public final TextView bodeStopFreq;
    public final SwitchButton bodeVaramp;
    public final Guideline leftGuideline;
    public final Guideline leftGuideline1;
    public final Guideline leftGuideline2;
    public final Guideline leftGuideline3;
    @Bindable
    protected BodeParam mParam;

    public abstract void setParam(BodeParam bodeParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterBodeAfSeniorBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, SwitchButton switchButton, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4) {
        super(obj, view, i);
        this.bodeAmpout = textView;
        this.bodeBodevaramp1 = textView2;
        this.bodeBodevaramp2 = textView3;
        this.bodeBodevaramp3 = textView4;
        this.bodeBodevaramp4 = textView5;
        this.bodeBodevaramp5 = textView6;
        this.bodeBodevaramp6 = textView7;
        this.bodeBodevaramp7 = textView8;
        this.bodeBodevaramp8 = textView9;
        this.bodePointNum = textView10;
        this.bodeStartFreq = textView11;
        this.bodeStopFreq = textView12;
        this.bodeVaramp = switchButton;
        this.leftGuideline = guideline;
        this.leftGuideline1 = guideline2;
        this.leftGuideline2 = guideline3;
        this.leftGuideline3 = guideline4;
    }

    public BodeParam getParam() {
        return this.mParam;
    }

    public static AdapterBodeAfSeniorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBodeAfSeniorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterBodeAfSeniorBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bode_af_senior, viewGroup, z, obj);
    }

    public static AdapterBodeAfSeniorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBodeAfSeniorBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterBodeAfSeniorBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bode_af_senior, null, false, obj);
    }

    public static AdapterBodeAfSeniorBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBodeAfSeniorBinding bind(View view, Object obj) {
        return (AdapterBodeAfSeniorBinding) bind(obj, view, R.layout.adapter_bode_af_senior);
    }
}
