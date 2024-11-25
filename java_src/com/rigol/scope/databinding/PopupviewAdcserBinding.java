package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.adc.AdcSerParam;
/* loaded from: classes2.dex */
public abstract class PopupviewAdcserBinding extends ViewDataBinding {
    public final TextView adc1;
    public final SeekBar adc1TcmpSeekBar;
    public final SwitchButton adc1TdmxSwitch;
    public final TextView adc1Value;
    public final TextView adc2;
    public final SeekBar adc2TcmpSeekBar;
    public final SwitchButton adc2TdmxSwitch;
    public final TextView adc2Value;
    public final TextView adc3;
    public final SeekBar adc3TcmpSeekBar;
    public final SwitchButton adc3TdmxSwitch;
    public final TextView adc3Value;
    public final TextView adc4;
    public final SeekBar adc4TcmpSeekBar;
    public final SwitchButton adc4TdmxSwitch;
    public final TextView adc4Value;
    public final Guideline guidelineCenter;
    @Bindable
    protected AdcSerParam mParam;
    public final Button saveBtn;
    public final TextView tcmp;
    public final TextView tdmx;

    public abstract void setParam(AdcSerParam adcSerParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewAdcserBinding(Object obj, View view, int i, TextView textView, SeekBar seekBar, SwitchButton switchButton, TextView textView2, TextView textView3, SeekBar seekBar2, SwitchButton switchButton2, TextView textView4, TextView textView5, SeekBar seekBar3, SwitchButton switchButton3, TextView textView6, TextView textView7, SeekBar seekBar4, SwitchButton switchButton4, TextView textView8, Guideline guideline, Button button, TextView textView9, TextView textView10) {
        super(obj, view, i);
        this.adc1 = textView;
        this.adc1TcmpSeekBar = seekBar;
        this.adc1TdmxSwitch = switchButton;
        this.adc1Value = textView2;
        this.adc2 = textView3;
        this.adc2TcmpSeekBar = seekBar2;
        this.adc2TdmxSwitch = switchButton2;
        this.adc2Value = textView4;
        this.adc3 = textView5;
        this.adc3TcmpSeekBar = seekBar3;
        this.adc3TdmxSwitch = switchButton3;
        this.adc3Value = textView6;
        this.adc4 = textView7;
        this.adc4TcmpSeekBar = seekBar4;
        this.adc4TdmxSwitch = switchButton4;
        this.adc4Value = textView8;
        this.guidelineCenter = guideline;
        this.saveBtn = button;
        this.tcmp = textView9;
        this.tdmx = textView10;
    }

    public AdcSerParam getParam() {
        return this.mParam;
    }

    public static PopupviewAdcserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAdcserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewAdcserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_adcser, viewGroup, z, obj);
    }

    public static PopupviewAdcserBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAdcserBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewAdcserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_adcser, null, false, obj);
    }

    public static PopupviewAdcserBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAdcserBinding bind(View view, Object obj) {
        return (PopupviewAdcserBinding) bind(obj, view, R.layout.popupview_adcser);
    }
}
