package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.data.XYParam;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.TouchableSeekBar;
/* loaded from: classes2.dex */
public abstract class PopupviewXyBinding extends ViewDataBinding {
    public final TextView afterglow;
    public final TextView afterglowInframe;
    public final TextView afterglowInframePercent;
    public final TouchableSeekBar afterglowInframeSeekBar;
    public final TextView afterglowPercent;
    public final TouchableSeekBar afterglowSeekBar;
    public final TextView autoCompression;
    public final SwitchButton autoCompressionSwitchButton;
    public final RadioButton fullRadioButton;
    public final TextView gridType;
    public final RadioGroup gridTypeRadioGroup;
    public final RadioButton halfRadioButton;
    public final TextView intensity;
    public final TextView intensityPercent;
    public final TouchableSeekBar intensitySeekBar;
    @Bindable
    protected MappingObject mGridFullMapping;
    @Bindable
    protected MappingObject mGridHalfMapping;
    @Bindable
    protected MappingObject mGridNoneMapping;
    @Bindable
    protected UtilityParam mUtilityParam;
    @Bindable
    protected WindowParam mWindowParam;
    @Bindable
    protected XYParam mXyParam;
    public final Guideline mathGuidelineCenter;
    public final RadioButton noneRadioButton;
    public final TextView samplerate;
    public final TouchableSeekBar samplerateSeekBar;
    public final TextView samplerateText;
    public final TextView settingADV;
    public final SwitchButton settingADVSwitchButton;
    public final TextView sourceA;
    public final TextView sourceASpinner;
    public final TextView sourceB;
    public final TextView sourceBSpinner;
    public final TextView waveformSize;
    public final TextView waveformSizePercent;
    public final TouchableSeekBar waveformSizeSeekBar;

    public abstract void setGridFullMapping(MappingObject mappingObject);

    public abstract void setGridHalfMapping(MappingObject mappingObject);

    public abstract void setGridNoneMapping(MappingObject mappingObject);

    public abstract void setUtilityParam(UtilityParam utilityParam);

    public abstract void setWindowParam(WindowParam windowParam);

    public abstract void setXyParam(XYParam xYParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewXyBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TouchableSeekBar touchableSeekBar, TextView textView4, TouchableSeekBar touchableSeekBar2, TextView textView5, SwitchButton switchButton, RadioButton radioButton, TextView textView6, RadioGroup radioGroup, RadioButton radioButton2, TextView textView7, TextView textView8, TouchableSeekBar touchableSeekBar3, Guideline guideline, RadioButton radioButton3, TextView textView9, TouchableSeekBar touchableSeekBar4, TextView textView10, TextView textView11, SwitchButton switchButton2, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TouchableSeekBar touchableSeekBar5) {
        super(obj, view, i);
        this.afterglow = textView;
        this.afterglowInframe = textView2;
        this.afterglowInframePercent = textView3;
        this.afterglowInframeSeekBar = touchableSeekBar;
        this.afterglowPercent = textView4;
        this.afterglowSeekBar = touchableSeekBar2;
        this.autoCompression = textView5;
        this.autoCompressionSwitchButton = switchButton;
        this.fullRadioButton = radioButton;
        this.gridType = textView6;
        this.gridTypeRadioGroup = radioGroup;
        this.halfRadioButton = radioButton2;
        this.intensity = textView7;
        this.intensityPercent = textView8;
        this.intensitySeekBar = touchableSeekBar3;
        this.mathGuidelineCenter = guideline;
        this.noneRadioButton = radioButton3;
        this.samplerate = textView9;
        this.samplerateSeekBar = touchableSeekBar4;
        this.samplerateText = textView10;
        this.settingADV = textView11;
        this.settingADVSwitchButton = switchButton2;
        this.sourceA = textView12;
        this.sourceASpinner = textView13;
        this.sourceB = textView14;
        this.sourceBSpinner = textView15;
        this.waveformSize = textView16;
        this.waveformSizePercent = textView17;
        this.waveformSizeSeekBar = touchableSeekBar5;
    }

    public XYParam getXyParam() {
        return this.mXyParam;
    }

    public UtilityParam getUtilityParam() {
        return this.mUtilityParam;
    }

    public WindowParam getWindowParam() {
        return this.mWindowParam;
    }

    public MappingObject getGridFullMapping() {
        return this.mGridFullMapping;
    }

    public MappingObject getGridHalfMapping() {
        return this.mGridHalfMapping;
    }

    public MappingObject getGridNoneMapping() {
        return this.mGridNoneMapping;
    }

    public static PopupviewXyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewXyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewXyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_xy, viewGroup, z, obj);
    }

    public static PopupviewXyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewXyBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewXyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_xy, null, false, obj);
    }

    public static PopupviewXyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewXyBinding bind(View view, Object obj) {
        return (PopupviewXyBinding) bind(obj, view, R.layout.popupview_xy);
    }
}
