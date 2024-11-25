package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.JitterParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class PopupviewJitterBinding extends ViewDataBinding {
    public final RadioButton jitterBothRadioButton;
    public final RadioButton jitterConstantRadioButton;
    public final CheckBox jitterCurve;
    public final View jitterDivider;
    public final View jitterDivider1;
    public final View jitterDivider2;
    public final SwitchButton jitterEnSwitchButton;
    public final TextView jitterEnabledLabel;
    public final RadioButton jitterExplicitRadioButton;
    public final RadioButton jitterFallRadioButton;
    public final TextView jitterHighThresLabel;
    public final TextView jitterHighThresValue;
    public final CheckBox jitterHistogram;
    public final TextView jitterLowThresLabel;
    public final TextView jitterLowThresValue;
    public final TextView jitterMeasEnLabel;
    public final SwitchButton jitterMeasEnSwitchButton;
    public final TextView jitterMidThresLabel;
    public final TextView jitterMidThresValue;
    public final TextView jitterPersistanceLabel;
    public final SwitchButton jitterPersistanceSwitchButton;
    public final RadioButton jitterPllRadioButton;
    public final TextView jitterRecoverTypeLabel;
    public final RadioGroup jitterRecoverTypeRadioGroup;
    public final RecyclerView jitterRecoverTypeView;
    public final RadioButton jitterRiseRadioButton;
    public final TextView jitterSmooth;
    public final SwitchButton jitterSmoothSwitchButton;
    public final TextView jitterSourceLabel;
    public final TextView jitterSourceValue;
    public final CheckBox jitterSpectrum;
    public final TextView jitterTieSlopeLabel;
    public final RadioGroup jitterTieSlopeRadioGroup;
    public final CheckBox jitterTrack;
    @Bindable
    protected JitterParam mParam;
    @Bindable
    protected View mView;
    public final Button resetColorButton;

    public abstract void setParam(JitterParam jitterParam);

    public abstract void setView(View view);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewJitterBinding(Object obj, View view, int i, RadioButton radioButton, RadioButton radioButton2, CheckBox checkBox, View view2, View view3, View view4, SwitchButton switchButton, TextView textView, RadioButton radioButton3, RadioButton radioButton4, TextView textView2, TextView textView3, CheckBox checkBox2, TextView textView4, TextView textView5, TextView textView6, SwitchButton switchButton2, TextView textView7, TextView textView8, TextView textView9, SwitchButton switchButton3, RadioButton radioButton5, TextView textView10, RadioGroup radioGroup, RecyclerView recyclerView, RadioButton radioButton6, TextView textView11, SwitchButton switchButton4, TextView textView12, TextView textView13, CheckBox checkBox3, TextView textView14, RadioGroup radioGroup2, CheckBox checkBox4, Button button) {
        super(obj, view, i);
        this.jitterBothRadioButton = radioButton;
        this.jitterConstantRadioButton = radioButton2;
        this.jitterCurve = checkBox;
        this.jitterDivider = view2;
        this.jitterDivider1 = view3;
        this.jitterDivider2 = view4;
        this.jitterEnSwitchButton = switchButton;
        this.jitterEnabledLabel = textView;
        this.jitterExplicitRadioButton = radioButton3;
        this.jitterFallRadioButton = radioButton4;
        this.jitterHighThresLabel = textView2;
        this.jitterHighThresValue = textView3;
        this.jitterHistogram = checkBox2;
        this.jitterLowThresLabel = textView4;
        this.jitterLowThresValue = textView5;
        this.jitterMeasEnLabel = textView6;
        this.jitterMeasEnSwitchButton = switchButton2;
        this.jitterMidThresLabel = textView7;
        this.jitterMidThresValue = textView8;
        this.jitterPersistanceLabel = textView9;
        this.jitterPersistanceSwitchButton = switchButton3;
        this.jitterPllRadioButton = radioButton5;
        this.jitterRecoverTypeLabel = textView10;
        this.jitterRecoverTypeRadioGroup = radioGroup;
        this.jitterRecoverTypeView = recyclerView;
        this.jitterRiseRadioButton = radioButton6;
        this.jitterSmooth = textView11;
        this.jitterSmoothSwitchButton = switchButton4;
        this.jitterSourceLabel = textView12;
        this.jitterSourceValue = textView13;
        this.jitterSpectrum = checkBox3;
        this.jitterTieSlopeLabel = textView14;
        this.jitterTieSlopeRadioGroup = radioGroup2;
        this.jitterTrack = checkBox4;
        this.resetColorButton = button;
    }

    public View getView() {
        return this.mView;
    }

    public JitterParam getParam() {
        return this.mParam;
    }

    public static PopupviewJitterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewJitterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewJitterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_jitter, viewGroup, z, obj);
    }

    public static PopupviewJitterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewJitterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewJitterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_jitter, null, false, obj);
    }

    public static PopupviewJitterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewJitterBinding bind(View view, Object obj) {
        return (PopupviewJitterBinding) bind(obj, view, R.layout.popupview_jitter);
    }
}
