package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.FftParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class AdapterRtsaBasesettingBinding extends ViewDataBinding {
    public final TextView ampt;
    public final ImageView amptRectangle;
    public final Button autoTuneBtn;
    public final TextView bw;
    public final ImageView bwRectangle;
    public final TextView fftCenter;
    public final EditText fftCenterEditText;
    public final TextView fftEnd;
    public final EditText fftEndEditText;
    public final TextView fftSpan;
    public final EditText fftSpanEditText;
    public final TextView fftStart;
    public final EditText fftStartEditText;
    public final TextView freq;
    public final ImageView freqRectangle;
    public final Button fullSpanBtn;
    public final Button lastSpanBtn;
    @Bindable
    protected HorizontalParam mHoriParam;
    @Bindable
    protected FftParam mParam;
    public final TextView persistTime;
    public final TextView persistTimeSpinner;
    public final Button presetBtn;
    public final TextView rbw;
    public final TextView rbwAuto;
    public final SwitchButton rbwAutoSwitch;
    public final TextView rbwSpinner;
    public final TextView refLevel;
    public final EditText refLevelEditText;
    public final TextView scale;
    public final EditText scaleEditText;
    public final TextView source;
    public final TextView sourceSpinner;
    public final TextView span;
    public final ImageView spanRectangle;
    public final TextView unit;
    public final TextView unitSpinner;
    public final TextView window;
    public final TextView windowSpinner;

    public abstract void setHoriParam(HorizontalParam horizontalParam);

    public abstract void setParam(FftParam fftParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterRtsaBasesettingBinding(Object obj, View view, int i, TextView textView, ImageView imageView, Button button, TextView textView2, ImageView imageView2, TextView textView3, EditText editText, TextView textView4, EditText editText2, TextView textView5, EditText editText3, TextView textView6, EditText editText4, TextView textView7, ImageView imageView3, Button button2, Button button3, TextView textView8, TextView textView9, Button button4, TextView textView10, TextView textView11, SwitchButton switchButton, TextView textView12, TextView textView13, EditText editText5, TextView textView14, EditText editText6, TextView textView15, TextView textView16, TextView textView17, ImageView imageView4, TextView textView18, TextView textView19, TextView textView20, TextView textView21) {
        super(obj, view, i);
        this.ampt = textView;
        this.amptRectangle = imageView;
        this.autoTuneBtn = button;
        this.bw = textView2;
        this.bwRectangle = imageView2;
        this.fftCenter = textView3;
        this.fftCenterEditText = editText;
        this.fftEnd = textView4;
        this.fftEndEditText = editText2;
        this.fftSpan = textView5;
        this.fftSpanEditText = editText3;
        this.fftStart = textView6;
        this.fftStartEditText = editText4;
        this.freq = textView7;
        this.freqRectangle = imageView3;
        this.fullSpanBtn = button2;
        this.lastSpanBtn = button3;
        this.persistTime = textView8;
        this.persistTimeSpinner = textView9;
        this.presetBtn = button4;
        this.rbw = textView10;
        this.rbwAuto = textView11;
        this.rbwAutoSwitch = switchButton;
        this.rbwSpinner = textView12;
        this.refLevel = textView13;
        this.refLevelEditText = editText5;
        this.scale = textView14;
        this.scaleEditText = editText6;
        this.source = textView15;
        this.sourceSpinner = textView16;
        this.span = textView17;
        this.spanRectangle = imageView4;
        this.unit = textView18;
        this.unitSpinner = textView19;
        this.window = textView20;
        this.windowSpinner = textView21;
    }

    public FftParam getParam() {
        return this.mParam;
    }

    public HorizontalParam getHoriParam() {
        return this.mHoriParam;
    }

    public static AdapterRtsaBasesettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterRtsaBasesettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterRtsaBasesettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_rtsa_basesetting, viewGroup, z, obj);
    }

    public static AdapterRtsaBasesettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterRtsaBasesettingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterRtsaBasesettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_rtsa_basesetting, null, false, obj);
    }

    public static AdapterRtsaBasesettingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterRtsaBasesettingBinding bind(View view, Object obj) {
        return (AdapterRtsaBasesettingBinding) bind(obj, view, R.layout.adapter_rtsa_basesetting);
    }
}
