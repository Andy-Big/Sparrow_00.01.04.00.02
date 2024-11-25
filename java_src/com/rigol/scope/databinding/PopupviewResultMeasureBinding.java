package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class PopupviewResultMeasureBinding extends ViewDataBinding {
    public final TextView ampMethod;
    public final SwitchButton ampMethodSwitch;
    public final TextView baseMethod;
    public final SwitchButton baseMethodSwitch;
    public final TextView cursorA;
    public final EditText cursorAEditText;
    public final TextView cursorAb;
    public final SwitchButton cursorAbSwitch;
    public final TextView cursorB;
    public final EditText cursorBEditText;
    public final Button deleteAllButton;
    public final Button deleteButton;
    public final View divider;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final Guideline guidelineRight2;
    public final TextView high;
    public final EditText highEditText;
    public final TextView histoEn;
    public final SwitchButton histoEnSwitch;
    public final TextView indicator;
    public final SwitchButton indicatorSwitch;
    public final TextView low;
    public final EditText lowEditText;
    @Bindable
    protected HorizontalParam mHorizontal;
    @Bindable
    protected MappingObject mNormalMapping;
    @Bindable
    protected View.OnClickListener mOnClickListener;
    @Bindable
    protected MeasureSettingParam mParam;
    @Bindable
    protected MappingObject mPrecisionMapping;
    @Bindable
    protected SharedParam mSharedParam;
    @Bindable
    protected VerticalParam mVerticalParam;
    public final TextView measureSource;
    public final TextView measureSourceSpinner;
    public final TextView mid;
    public final EditText midEditText;
    public final TextView mode;
    public final RadioGroup modeRadioGroup;
    public final RadioButton precisionRadioButton;
    public final TextView region;
    public final TextView regionSpinner;
    public final CheckBox showLine;
    public final TextView stat;
    public final TextView statCount;
    public final EditText statCountEditText;
    public final TextView statReset;
    public final Button statResetButton;
    public final SwitchButton statSwitch;
    public final SwitchButton threSwitch;
    public final TextView threText;
    public final Button thresholdDefaultButton;
    public final ImageView thresholdDiagram;
    public final TextView thresholdDisplayType;
    public final SwitchButton thresholdDisplayTypeSwitch;
    public final TextView thresholdSource;
    public final TextView thresholdSourceSpinner;
    public final TextView topMethod;
    public final SwitchButton topMethodSwitch;

    public abstract void setHorizontal(HorizontalParam horizontalParam);

    public abstract void setNormalMapping(MappingObject mappingObject);

    public abstract void setOnClickListener(View.OnClickListener onClickListener);

    public abstract void setParam(MeasureSettingParam measureSettingParam);

    public abstract void setPrecisionMapping(MappingObject mappingObject);

    public abstract void setSharedParam(SharedParam sharedParam);

    public abstract void setVerticalParam(VerticalParam verticalParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewResultMeasureBinding(Object obj, View view, int i, TextView textView, SwitchButton switchButton, TextView textView2, SwitchButton switchButton2, TextView textView3, EditText editText, TextView textView4, SwitchButton switchButton3, TextView textView5, EditText editText2, Button button, Button button2, View view2, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, TextView textView6, EditText editText3, TextView textView7, SwitchButton switchButton4, TextView textView8, SwitchButton switchButton5, TextView textView9, EditText editText4, TextView textView10, TextView textView11, TextView textView12, EditText editText5, TextView textView13, RadioGroup radioGroup, RadioButton radioButton, TextView textView14, TextView textView15, CheckBox checkBox, TextView textView16, TextView textView17, EditText editText6, TextView textView18, Button button3, SwitchButton switchButton6, SwitchButton switchButton7, TextView textView19, Button button4, ImageView imageView, TextView textView20, SwitchButton switchButton8, TextView textView21, TextView textView22, TextView textView23, SwitchButton switchButton9) {
        super(obj, view, i);
        this.ampMethod = textView;
        this.ampMethodSwitch = switchButton;
        this.baseMethod = textView2;
        this.baseMethodSwitch = switchButton2;
        this.cursorA = textView3;
        this.cursorAEditText = editText;
        this.cursorAb = textView4;
        this.cursorAbSwitch = switchButton3;
        this.cursorB = textView5;
        this.cursorBEditText = editText2;
        this.deleteAllButton = button;
        this.deleteButton = button2;
        this.divider = view2;
        this.guidelineCenter = guideline;
        this.guidelineLeft = guideline2;
        this.guidelineRight = guideline3;
        this.guidelineRight2 = guideline4;
        this.high = textView6;
        this.highEditText = editText3;
        this.histoEn = textView7;
        this.histoEnSwitch = switchButton4;
        this.indicator = textView8;
        this.indicatorSwitch = switchButton5;
        this.low = textView9;
        this.lowEditText = editText4;
        this.measureSource = textView10;
        this.measureSourceSpinner = textView11;
        this.mid = textView12;
        this.midEditText = editText5;
        this.mode = textView13;
        this.modeRadioGroup = radioGroup;
        this.precisionRadioButton = radioButton;
        this.region = textView14;
        this.regionSpinner = textView15;
        this.showLine = checkBox;
        this.stat = textView16;
        this.statCount = textView17;
        this.statCountEditText = editText6;
        this.statReset = textView18;
        this.statResetButton = button3;
        this.statSwitch = switchButton6;
        this.threSwitch = switchButton7;
        this.threText = textView19;
        this.thresholdDefaultButton = button4;
        this.thresholdDiagram = imageView;
        this.thresholdDisplayType = textView20;
        this.thresholdDisplayTypeSwitch = switchButton8;
        this.thresholdSource = textView21;
        this.thresholdSourceSpinner = textView22;
        this.topMethod = textView23;
        this.topMethodSwitch = switchButton9;
    }

    public MeasureSettingParam getParam() {
        return this.mParam;
    }

    public VerticalParam getVerticalParam() {
        return this.mVerticalParam;
    }

    public SharedParam getSharedParam() {
        return this.mSharedParam;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public MappingObject getNormalMapping() {
        return this.mNormalMapping;
    }

    public MappingObject getPrecisionMapping() {
        return this.mPrecisionMapping;
    }

    public HorizontalParam getHorizontal() {
        return this.mHorizontal;
    }

    public static PopupviewResultMeasureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewResultMeasureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewResultMeasureBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_result_measure, viewGroup, z, obj);
    }

    public static PopupviewResultMeasureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewResultMeasureBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewResultMeasureBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_result_measure, null, false, obj);
    }

    public static PopupviewResultMeasureBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewResultMeasureBinding bind(View view, Object obj) {
        return (PopupviewResultMeasureBinding) bind(obj, view, R.layout.popupview_result_measure);
    }
}
