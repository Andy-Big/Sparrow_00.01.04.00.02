package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.vertical.VerticalSeekBar;
import com.rigol.scope.views.vertical.VerticalSeekBarWrapper;
/* loaded from: classes2.dex */
public abstract class AdapterTriggerRuntBinding extends ViewDataBinding {
    public final Button buttonLevel;
    public final Button buttonLevelB;
    public final Guideline guidelineCenter;
    public final Guideline guidelineFifth;
    public final Guideline guidelineForth;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final ImageView imageView2;
    public final RadioButton lessMore;
    public final RadioButton lessThan;
    public final TextView lowerLimit;
    public final EditText lowerLimitValue;
    @Bindable
    protected TriggerParam mParam;
    @Bindable
    protected MappingObject mPolarityNegativeMapping;
    @Bindable
    protected MappingObject mPolarityPositiveMapping;
    @Bindable
    protected MappingObject mSelectLevelABMapping;
    @Bindable
    protected MappingObject mSelectLevelAMapping;
    @Bindable
    protected MappingObject mSelectLevelBMapping;
    @Bindable
    protected MappingObject mSweepAutoMapping;
    @Bindable
    protected MappingObject mSweepNormalMapping;
    @Bindable
    protected MappingObject mSweepSingleMapping;
    @Bindable
    protected MappingObject mWhenNoneMapping;
    public final RadioButton moreThan;
    public final RadioButton none;
    public final RadioButton runtNegative;
    public final RadioButton runtPositive;
    public final TextView runtTriggerLabel;
    public final EditText triggerHoldoff;
    public final TextView triggerHoldoffLabel;
    public final TextView triggerLevel;
    public final EditText triggerLevelAValue;
    public final VerticalSeekBar triggerLevelAView;
    public final TextView triggerLevelB;
    public final EditText triggerLevelBValue;
    public final VerticalSeekBar triggerLevelBView;
    public final CheckBox triggerLevelSelectAb;
    public final TextView triggerNoiseLabel;
    public final SwitchButton triggerNoiseSwitch;
    public final TextView triggerRuntPolarityLabel;
    public final TextView triggerSource;
    public final TextView triggerSourceLabel;
    public final TextView upperLimit;
    public final EditText upperLimitValue;
    public final VerticalSeekBarWrapper verticalSeekBarWrapper2;
    public final VerticalSeekBarWrapper verticalSeekBarWrapper3;
    public final View view16;
    public final View view2;
    public final View viewTop;

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setPolarityNegativeMapping(MappingObject mappingObject);

    public abstract void setPolarityPositiveMapping(MappingObject mappingObject);

    public abstract void setSelectLevelABMapping(MappingObject mappingObject);

    public abstract void setSelectLevelAMapping(MappingObject mappingObject);

    public abstract void setSelectLevelBMapping(MappingObject mappingObject);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    public abstract void setWhenNoneMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTriggerRuntBinding(Object obj, View view, int i, Button button, Button button2, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, ImageView imageView, RadioButton radioButton, RadioButton radioButton2, TextView textView, EditText editText, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, TextView textView2, EditText editText2, TextView textView3, TextView textView4, EditText editText3, VerticalSeekBar verticalSeekBar, TextView textView5, EditText editText4, VerticalSeekBar verticalSeekBar2, CheckBox checkBox, TextView textView6, SwitchButton switchButton, TextView textView7, TextView textView8, TextView textView9, TextView textView10, EditText editText5, VerticalSeekBarWrapper verticalSeekBarWrapper, VerticalSeekBarWrapper verticalSeekBarWrapper2, View view2, View view3, View view4) {
        super(obj, view, i);
        this.buttonLevel = button;
        this.buttonLevelB = button2;
        this.guidelineCenter = guideline;
        this.guidelineFifth = guideline2;
        this.guidelineForth = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
        this.imageView2 = imageView;
        this.lessMore = radioButton;
        this.lessThan = radioButton2;
        this.lowerLimit = textView;
        this.lowerLimitValue = editText;
        this.moreThan = radioButton3;
        this.none = radioButton4;
        this.runtNegative = radioButton5;
        this.runtPositive = radioButton6;
        this.runtTriggerLabel = textView2;
        this.triggerHoldoff = editText2;
        this.triggerHoldoffLabel = textView3;
        this.triggerLevel = textView4;
        this.triggerLevelAValue = editText3;
        this.triggerLevelAView = verticalSeekBar;
        this.triggerLevelB = textView5;
        this.triggerLevelBValue = editText4;
        this.triggerLevelBView = verticalSeekBar2;
        this.triggerLevelSelectAb = checkBox;
        this.triggerNoiseLabel = textView6;
        this.triggerNoiseSwitch = switchButton;
        this.triggerRuntPolarityLabel = textView7;
        this.triggerSource = textView8;
        this.triggerSourceLabel = textView9;
        this.upperLimit = textView10;
        this.upperLimitValue = editText5;
        this.verticalSeekBarWrapper2 = verticalSeekBarWrapper;
        this.verticalSeekBarWrapper3 = verticalSeekBarWrapper2;
        this.view16 = view2;
        this.view2 = view3;
        this.viewTop = view4;
    }

    public TriggerParam getParam() {
        return this.mParam;
    }

    public MappingObject getSweepAutoMapping() {
        return this.mSweepAutoMapping;
    }

    public MappingObject getSweepNormalMapping() {
        return this.mSweepNormalMapping;
    }

    public MappingObject getSweepSingleMapping() {
        return this.mSweepSingleMapping;
    }

    public MappingObject getPolarityPositiveMapping() {
        return this.mPolarityPositiveMapping;
    }

    public MappingObject getPolarityNegativeMapping() {
        return this.mPolarityNegativeMapping;
    }

    public MappingObject getSelectLevelAMapping() {
        return this.mSelectLevelAMapping;
    }

    public MappingObject getSelectLevelBMapping() {
        return this.mSelectLevelBMapping;
    }

    public MappingObject getSelectLevelABMapping() {
        return this.mSelectLevelABMapping;
    }

    public MappingObject getWhenNoneMapping() {
        return this.mWhenNoneMapping;
    }

    public static AdapterTriggerRuntBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerRuntBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTriggerRuntBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_runt, viewGroup, z, obj);
    }

    public static AdapterTriggerRuntBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerRuntBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTriggerRuntBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_runt, null, false, obj);
    }

    public static AdapterTriggerRuntBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerRuntBinding bind(View view, Object obj) {
        return (AdapterTriggerRuntBinding) bind(obj, view, R.layout.adapter_trigger_runt);
    }
}
