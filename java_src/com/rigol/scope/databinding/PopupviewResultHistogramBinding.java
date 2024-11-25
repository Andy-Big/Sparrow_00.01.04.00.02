package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.histogram.HistogramResultParam;
/* loaded from: classes2.dex */
public abstract class PopupviewResultHistogramBinding extends ViewDataBinding {
    public final TextView dispgrid;
    public final EditText dispgridEditText;
    public final View dividingLine;
    public final TextView enable;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final TextView highpos;
    public final EditText highposEditText;
    public final TextView histoReset;
    public final SwitchButton histogramEn;
    public final TextView histogramType;
    public final TextView histogramTypeSpinner;
    public final TextView leftpos;
    public final EditText leftposEditText;
    public final TextView lowpos;
    public final EditText lowposEditText;
    @Bindable
    protected MappingObject mChan1MappingObject;
    @Bindable
    protected MappingObject mChan2MappingObject;
    @Bindable
    protected MappingObject mChan3MappingObject;
    @Bindable
    protected MappingObject mChan4MappingObject;
    @Bindable
    protected MappingObject mChanNoneMappingObject;
    @Bindable
    protected MappingObject mHorizontalMappingObject;
    @Bindable
    protected MappingObject mMeasureMappingObject;
    @Bindable
    protected View.OnClickListener mOnClickListener;
    @Bindable
    protected HistogramResultParam mParam;
    @Bindable
    protected MappingObject mVerticalMappingObject;
    public final TextView rangSetup;
    public final Button resetButton;
    public final TextView rightpos;
    public final EditText rightposEditText;
    public final TextView source;
    public final TextView sourceSpinner;
    public final TextView statisen;
    public final SwitchButton statisenSwitch;

    public abstract void setChan1MappingObject(MappingObject mappingObject);

    public abstract void setChan2MappingObject(MappingObject mappingObject);

    public abstract void setChan3MappingObject(MappingObject mappingObject);

    public abstract void setChan4MappingObject(MappingObject mappingObject);

    public abstract void setChanNoneMappingObject(MappingObject mappingObject);

    public abstract void setHorizontalMappingObject(MappingObject mappingObject);

    public abstract void setMeasureMappingObject(MappingObject mappingObject);

    public abstract void setOnClickListener(View.OnClickListener onClickListener);

    public abstract void setParam(HistogramResultParam histogramResultParam);

    public abstract void setVerticalMappingObject(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewResultHistogramBinding(Object obj, View view, int i, TextView textView, EditText editText, View view2, TextView textView2, Guideline guideline, Guideline guideline2, Guideline guideline3, TextView textView3, EditText editText2, TextView textView4, SwitchButton switchButton, TextView textView5, TextView textView6, TextView textView7, EditText editText3, TextView textView8, EditText editText4, TextView textView9, Button button, TextView textView10, EditText editText5, TextView textView11, TextView textView12, TextView textView13, SwitchButton switchButton2) {
        super(obj, view, i);
        this.dispgrid = textView;
        this.dispgridEditText = editText;
        this.dividingLine = view2;
        this.enable = textView2;
        this.guidelineCenter = guideline;
        this.guidelineLeft = guideline2;
        this.guidelineRight = guideline3;
        this.highpos = textView3;
        this.highposEditText = editText2;
        this.histoReset = textView4;
        this.histogramEn = switchButton;
        this.histogramType = textView5;
        this.histogramTypeSpinner = textView6;
        this.leftpos = textView7;
        this.leftposEditText = editText3;
        this.lowpos = textView8;
        this.lowposEditText = editText4;
        this.rangSetup = textView9;
        this.resetButton = button;
        this.rightpos = textView10;
        this.rightposEditText = editText5;
        this.source = textView11;
        this.sourceSpinner = textView12;
        this.statisen = textView13;
        this.statisenSwitch = switchButton2;
    }

    public HistogramResultParam getParam() {
        return this.mParam;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public MappingObject getHorizontalMappingObject() {
        return this.mHorizontalMappingObject;
    }

    public MappingObject getVerticalMappingObject() {
        return this.mVerticalMappingObject;
    }

    public MappingObject getMeasureMappingObject() {
        return this.mMeasureMappingObject;
    }

    public MappingObject getChanNoneMappingObject() {
        return this.mChanNoneMappingObject;
    }

    public MappingObject getChan1MappingObject() {
        return this.mChan1MappingObject;
    }

    public MappingObject getChan2MappingObject() {
        return this.mChan2MappingObject;
    }

    public MappingObject getChan3MappingObject() {
        return this.mChan3MappingObject;
    }

    public MappingObject getChan4MappingObject() {
        return this.mChan4MappingObject;
    }

    public static PopupviewResultHistogramBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewResultHistogramBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewResultHistogramBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_result_histogram, viewGroup, z, obj);
    }

    public static PopupviewResultHistogramBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewResultHistogramBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewResultHistogramBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_result_histogram, null, false, obj);
    }

    public static PopupviewResultHistogramBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewResultHistogramBinding bind(View view, Object obj) {
        return (PopupviewResultHistogramBinding) bind(obj, view, R.layout.popupview_result_histogram);
    }
}
