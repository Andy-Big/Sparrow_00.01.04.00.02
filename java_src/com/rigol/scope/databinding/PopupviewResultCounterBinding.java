package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.CounterResultParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class PopupviewResultCounterBinding extends ViewDataBinding {
    public final TextView clear;
    public final Button clearButton;
    public final SwitchButton counterStatSwitch;
    public final TextView delete;
    public final Button deleteButton;
    public final RadioButton frequencyRadioButton;
    public final Guideline guidelineLeft;
    @Bindable
    protected MappingObject mFrequencyMappingObject;
    @Bindable
    protected View.OnClickListener mOnClickListener;
    @Bindable
    protected CounterResultParam mParam;
    @Bindable
    protected MappingObject mPeriodMappingObject;
    @Bindable
    protected MappingObject mTotalizeMappingObject;
    public final RadioButton periodRadioButton;
    public final TextView resolution;
    public final EditText resolutionEditText;
    public final TextView source;
    public final TextView sourceSpinner;
    public final TextView stat;
    public final RadioButton totalizeRadioButton;
    public final TextView type;
    public final RadioGroup typeRadioGroup;

    public abstract void setFrequencyMappingObject(MappingObject mappingObject);

    public abstract void setOnClickListener(View.OnClickListener onClickListener);

    public abstract void setParam(CounterResultParam counterResultParam);

    public abstract void setPeriodMappingObject(MappingObject mappingObject);

    public abstract void setTotalizeMappingObject(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewResultCounterBinding(Object obj, View view, int i, TextView textView, Button button, SwitchButton switchButton, TextView textView2, Button button2, RadioButton radioButton, Guideline guideline, RadioButton radioButton2, TextView textView3, EditText editText, TextView textView4, TextView textView5, TextView textView6, RadioButton radioButton3, TextView textView7, RadioGroup radioGroup) {
        super(obj, view, i);
        this.clear = textView;
        this.clearButton = button;
        this.counterStatSwitch = switchButton;
        this.delete = textView2;
        this.deleteButton = button2;
        this.frequencyRadioButton = radioButton;
        this.guidelineLeft = guideline;
        this.periodRadioButton = radioButton2;
        this.resolution = textView3;
        this.resolutionEditText = editText;
        this.source = textView4;
        this.sourceSpinner = textView5;
        this.stat = textView6;
        this.totalizeRadioButton = radioButton3;
        this.type = textView7;
        this.typeRadioGroup = radioGroup;
    }

    public CounterResultParam getParam() {
        return this.mParam;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public MappingObject getFrequencyMappingObject() {
        return this.mFrequencyMappingObject;
    }

    public MappingObject getPeriodMappingObject() {
        return this.mPeriodMappingObject;
    }

    public MappingObject getTotalizeMappingObject() {
        return this.mTotalizeMappingObject;
    }

    public static PopupviewResultCounterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewResultCounterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewResultCounterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_result_counter, viewGroup, z, obj);
    }

    public static PopupviewResultCounterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewResultCounterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewResultCounterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_result_counter, null, false, obj);
    }

    public static PopupviewResultCounterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewResultCounterBinding bind(View view, Object obj) {
        return (PopupviewResultCounterBinding) bind(obj, view, R.layout.popupview_result_counter);
    }
}
