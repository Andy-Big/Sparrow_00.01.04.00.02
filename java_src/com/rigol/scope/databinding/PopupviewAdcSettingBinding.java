package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.views.adc.AdcSettingParam;
/* loaded from: classes2.dex */
public abstract class PopupviewAdcSettingBinding extends ViewDataBinding {
    public final TextView adc1;
    public final TextView adc1A;
    public final SeekBar adc1ASeekBar;
    public final TextView adc1B;
    public final SeekBar adc1BSeekBar;
    public final TextView adc1C;
    public final SeekBar adc1CSeekBar;
    public final TextView adc1Coarse;
    public final SeekBar adc1CoarseSeekBar;
    public final TextView adc1D;
    public final SeekBar adc1DSeekBar;
    public final TextView adc1Fine;
    public final SeekBar adc1FineSeekBar;
    public final TextView adc1Flip;
    public final CheckBox adc1FlipCheckbox;
    public final TextView adc1Inter;
    public final SeekBar adc1InterSeekBar;
    public final TextView adc2;
    public final TextView adc2A;
    public final SeekBar adc2ASeekBar;
    public final TextView adc2B;
    public final SeekBar adc2BSeekBar;
    public final TextView adc2C;
    public final SeekBar adc2CSeekBar;
    public final TextView adc2Coarse;
    public final SeekBar adc2CoarseSeekBar;
    public final TextView adc2D;
    public final SeekBar adc2DSeekBar;
    public final TextView adc2Fine;
    public final SeekBar adc2FineSeekBar;
    public final TextView adc2Flip;
    public final CheckBox adc2FlipCheckbox;
    public final TextView adc2Inter;
    public final SeekBar adc2InterSeekBar;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected AdcSettingParam mParam;

    public abstract void setParam(AdcSettingParam adcSettingParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewAdcSettingBinding(Object obj, View view, int i, TextView textView, TextView textView2, SeekBar seekBar, TextView textView3, SeekBar seekBar2, TextView textView4, SeekBar seekBar3, TextView textView5, SeekBar seekBar4, TextView textView6, SeekBar seekBar5, TextView textView7, SeekBar seekBar6, TextView textView8, CheckBox checkBox, TextView textView9, SeekBar seekBar7, TextView textView10, TextView textView11, SeekBar seekBar8, TextView textView12, SeekBar seekBar9, TextView textView13, SeekBar seekBar10, TextView textView14, SeekBar seekBar11, TextView textView15, SeekBar seekBar12, TextView textView16, SeekBar seekBar13, TextView textView17, CheckBox checkBox2, TextView textView18, SeekBar seekBar14, Guideline guideline, Guideline guideline2, Guideline guideline3) {
        super(obj, view, i);
        this.adc1 = textView;
        this.adc1A = textView2;
        this.adc1ASeekBar = seekBar;
        this.adc1B = textView3;
        this.adc1BSeekBar = seekBar2;
        this.adc1C = textView4;
        this.adc1CSeekBar = seekBar3;
        this.adc1Coarse = textView5;
        this.adc1CoarseSeekBar = seekBar4;
        this.adc1D = textView6;
        this.adc1DSeekBar = seekBar5;
        this.adc1Fine = textView7;
        this.adc1FineSeekBar = seekBar6;
        this.adc1Flip = textView8;
        this.adc1FlipCheckbox = checkBox;
        this.adc1Inter = textView9;
        this.adc1InterSeekBar = seekBar7;
        this.adc2 = textView10;
        this.adc2A = textView11;
        this.adc2ASeekBar = seekBar8;
        this.adc2B = textView12;
        this.adc2BSeekBar = seekBar9;
        this.adc2C = textView13;
        this.adc2CSeekBar = seekBar10;
        this.adc2Coarse = textView14;
        this.adc2CoarseSeekBar = seekBar11;
        this.adc2D = textView15;
        this.adc2DSeekBar = seekBar12;
        this.adc2Fine = textView16;
        this.adc2FineSeekBar = seekBar13;
        this.adc2Flip = textView17;
        this.adc2FlipCheckbox = checkBox2;
        this.adc2Inter = textView18;
        this.adc2InterSeekBar = seekBar14;
        this.guidelineCenter = guideline;
        this.guidelineLeft = guideline2;
        this.guidelineRight = guideline3;
    }

    public AdcSettingParam getParam() {
        return this.mParam;
    }

    public static PopupviewAdcSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAdcSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewAdcSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_adc_setting, viewGroup, z, obj);
    }

    public static PopupviewAdcSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAdcSettingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewAdcSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_adc_setting, null, false, obj);
    }

    public static PopupviewAdcSettingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAdcSettingBinding bind(View view, Object obj) {
        return (PopupviewAdcSettingBinding) bind(obj, view, R.layout.popupview_adc_setting);
    }
}
