package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.WaveRecordParam;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.TouchableSeekBar;
/* loaded from: classes2.dex */
public abstract class PopupviewWaveRecordBinding extends ViewDataBinding {
    public final Guideline centerGuideline;
    public final View dividingLine1;
    public final View dividingLine2;
    public final Guideline leftGuideline;
    @Bindable
    protected HorizontalParam mHorizontalParam;
    @Bindable
    protected WaveRecordParam mParam;
    public final ImageView play;
    public final ImageView playLast;
    public final ImageView playMode;
    public final ImageView playNext;
    public final TextView playOption;
    public final ImageView playOrder;
    public final TouchableSeekBar playSeekBar;
    public final TextView recordBeeper;
    public final ImageView recordBeeperImageView;
    public final TextView recordCurrent;
    public final TextView recordCurrentValue;
    public final TextView recordEndframeValue;
    public final TextView recordFrames;
    public final TextView recordFramesValue;
    public final TextView recordInterval;
    public final TextView recordIntervalValue;
    public final TextView recordMaxframes;
    public final Button recordMaxframesButton;
    public final TextView recordMaxframesValue;
    public final TextView recordMin;
    public final SwitchButton recordMinSwitchButton;
    public final TextView recordOnoff;
    public final SwitchButton recordOnoffSwitchButton;
    public final TextView recordOption;
    public final TextView recordPlayinterval;
    public final TextView recordPlayintervalValue;
    public final TextView recordProgress;
    public final TouchableSeekBar recordSeekBar;
    public final TextView recordStart;
    public final ImageView recordStartImageView;
    public final TextView recordStartframeValue;
    public final TextView recordTime;
    public final TextView recordTimeValue;
    public final ImageView recordToend;
    public final ImageView recordTostart;
    public final Guideline rightGuideline;

    public abstract void setHorizontalParam(HorizontalParam horizontalParam);

    public abstract void setParam(WaveRecordParam waveRecordParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewWaveRecordBinding(Object obj, View view, int i, Guideline guideline, View view2, View view3, Guideline guideline2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, ImageView imageView5, TouchableSeekBar touchableSeekBar, TextView textView2, ImageView imageView6, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, Button button, TextView textView11, TextView textView12, SwitchButton switchButton, TextView textView13, SwitchButton switchButton2, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TouchableSeekBar touchableSeekBar2, TextView textView18, ImageView imageView7, TextView textView19, TextView textView20, TextView textView21, ImageView imageView8, ImageView imageView9, Guideline guideline3) {
        super(obj, view, i);
        this.centerGuideline = guideline;
        this.dividingLine1 = view2;
        this.dividingLine2 = view3;
        this.leftGuideline = guideline2;
        this.play = imageView;
        this.playLast = imageView2;
        this.playMode = imageView3;
        this.playNext = imageView4;
        this.playOption = textView;
        this.playOrder = imageView5;
        this.playSeekBar = touchableSeekBar;
        this.recordBeeper = textView2;
        this.recordBeeperImageView = imageView6;
        this.recordCurrent = textView3;
        this.recordCurrentValue = textView4;
        this.recordEndframeValue = textView5;
        this.recordFrames = textView6;
        this.recordFramesValue = textView7;
        this.recordInterval = textView8;
        this.recordIntervalValue = textView9;
        this.recordMaxframes = textView10;
        this.recordMaxframesButton = button;
        this.recordMaxframesValue = textView11;
        this.recordMin = textView12;
        this.recordMinSwitchButton = switchButton;
        this.recordOnoff = textView13;
        this.recordOnoffSwitchButton = switchButton2;
        this.recordOption = textView14;
        this.recordPlayinterval = textView15;
        this.recordPlayintervalValue = textView16;
        this.recordProgress = textView17;
        this.recordSeekBar = touchableSeekBar2;
        this.recordStart = textView18;
        this.recordStartImageView = imageView7;
        this.recordStartframeValue = textView19;
        this.recordTime = textView20;
        this.recordTimeValue = textView21;
        this.recordToend = imageView8;
        this.recordTostart = imageView9;
        this.rightGuideline = guideline3;
    }

    public WaveRecordParam getParam() {
        return this.mParam;
    }

    public HorizontalParam getHorizontalParam() {
        return this.mHorizontalParam;
    }

    public static PopupviewWaveRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewWaveRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewWaveRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_wave_record, viewGroup, z, obj);
    }

    public static PopupviewWaveRecordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewWaveRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewWaveRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_wave_record, null, false, obj);
    }

    public static PopupviewWaveRecordBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewWaveRecordBinding bind(View view, Object obj) {
        return (PopupviewWaveRecordBinding) bind(obj, view, R.layout.popupview_wave_record);
    }
}
