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
import com.rigol.scope.data.AfgParam;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.baseview.BaseEditText;
/* loaded from: classes2.dex */
public abstract class AdapterAwgBinding extends ViewDataBinding {
    public final BaseEditText basicAmpEdit;
    public final TextView basicAmpText;
    public final TextView fraguencyText;
    public final BaseEditText labelEditText;
    public final SwitchButton labelSwitch;
    public final Guideline leftGuideline;
    public final Guideline leftGuideline2;
    @Bindable
    protected AfgParam mParam;
    public final BaseEditText phaseDepthEdit;
    public final TextView phaseDepthText;
    public final BaseEditText phaseEditText;
    public final TextView phaseText;
    public final BaseEditText rangeDepthEdit;
    public final TextView rangeDepthText;
    public final BaseEditText rangeEditText;
    public final TextView rangeText;
    public final TextView sourceTypeSpinner;
    public final TextView sourceTypeText;
    public final TextView sweepOutText;
    public final TextView waveTypeSpinner;
    public final TextView waveTypeText;
    public final TextView waveTypefmSpinner;
    public final TextView waveTypefmText;
    public final TextView waveTypepmSpinner;
    public final TextView waveTypepmText;

    public abstract void setParam(AfgParam afgParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterAwgBinding(Object obj, View view, int i, BaseEditText baseEditText, TextView textView, TextView textView2, BaseEditText baseEditText2, SwitchButton switchButton, Guideline guideline, Guideline guideline2, BaseEditText baseEditText3, TextView textView3, BaseEditText baseEditText4, TextView textView4, BaseEditText baseEditText5, TextView textView5, BaseEditText baseEditText6, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15) {
        super(obj, view, i);
        this.basicAmpEdit = baseEditText;
        this.basicAmpText = textView;
        this.fraguencyText = textView2;
        this.labelEditText = baseEditText2;
        this.labelSwitch = switchButton;
        this.leftGuideline = guideline;
        this.leftGuideline2 = guideline2;
        this.phaseDepthEdit = baseEditText3;
        this.phaseDepthText = textView3;
        this.phaseEditText = baseEditText4;
        this.phaseText = textView4;
        this.rangeDepthEdit = baseEditText5;
        this.rangeDepthText = textView5;
        this.rangeEditText = baseEditText6;
        this.rangeText = textView6;
        this.sourceTypeSpinner = textView7;
        this.sourceTypeText = textView8;
        this.sweepOutText = textView9;
        this.waveTypeSpinner = textView10;
        this.waveTypeText = textView11;
        this.waveTypefmSpinner = textView12;
        this.waveTypefmText = textView13;
        this.waveTypepmSpinner = textView14;
        this.waveTypepmText = textView15;
    }

    public AfgParam getParam() {
        return this.mParam;
    }

    public static AdapterAwgBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterAwgBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterAwgBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_awg, viewGroup, z, obj);
    }

    public static AdapterAwgBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterAwgBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterAwgBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_awg, null, false, obj);
    }

    public static AdapterAwgBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterAwgBinding bind(View view, Object obj) {
        return (AdapterAwgBinding) bind(obj, view, R.layout.adapter_awg);
    }
}
