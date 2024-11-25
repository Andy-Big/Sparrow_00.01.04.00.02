package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
public abstract class AdapterTriggerPulseBinding extends ViewDataBinding {
    public final Button buttonLevel;
    public final Guideline guidelineCenter;
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
    protected MappingObject mSweepAutoMapping;
    @Bindable
    protected MappingObject mSweepNormalMapping;
    @Bindable
    protected MappingObject mSweepSingleMapping;
    public final RadioButton moreThan;
    public final RadioButton polarityN;
    public final RadioButton polarityP;
    public final EditText triggerHoldoff;
    public final TextView triggerHoldoffLabel;
    public final TextView triggerLevel;
    public final EditText triggerLevelValue;
    public final VerticalSeekBar triggerLevelView;
    public final View triggerNoise;
    public final TextView triggerNoiseLabel;
    public final SwitchButton triggerNoiseSwitch;
    public final TextView triggerPolarityLabel;
    public final TextView triggerPulseLabel;
    public final TextView triggerSource;
    public final TextView triggerSourceLabel;
    public final TextView upperLimit;
    public final EditText upperLimitValue;
    public final VerticalSeekBarWrapper verticalSeekBarWrapper2;
    public final View view1;
    public final View viewTop;

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setPolarityNegativeMapping(MappingObject mappingObject);

    public abstract void setPolarityPositiveMapping(MappingObject mappingObject);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTriggerPulseBinding(Object obj, View view, int i, Button button, Guideline guideline, Guideline guideline2, Guideline guideline3, ImageView imageView, RadioButton radioButton, RadioButton radioButton2, TextView textView, EditText editText, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, EditText editText2, TextView textView2, TextView textView3, EditText editText3, VerticalSeekBar verticalSeekBar, View view2, TextView textView4, SwitchButton switchButton, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, EditText editText4, VerticalSeekBarWrapper verticalSeekBarWrapper, View view3, View view4) {
        super(obj, view, i);
        this.buttonLevel = button;
        this.guidelineCenter = guideline;
        this.guidelineLeft = guideline2;
        this.guidelineRight = guideline3;
        this.imageView2 = imageView;
        this.lessMore = radioButton;
        this.lessThan = radioButton2;
        this.lowerLimit = textView;
        this.lowerLimitValue = editText;
        this.moreThan = radioButton3;
        this.polarityN = radioButton4;
        this.polarityP = radioButton5;
        this.triggerHoldoff = editText2;
        this.triggerHoldoffLabel = textView2;
        this.triggerLevel = textView3;
        this.triggerLevelValue = editText3;
        this.triggerLevelView = verticalSeekBar;
        this.triggerNoise = view2;
        this.triggerNoiseLabel = textView4;
        this.triggerNoiseSwitch = switchButton;
        this.triggerPolarityLabel = textView5;
        this.triggerPulseLabel = textView6;
        this.triggerSource = textView7;
        this.triggerSourceLabel = textView8;
        this.upperLimit = textView9;
        this.upperLimitValue = editText4;
        this.verticalSeekBarWrapper2 = verticalSeekBarWrapper;
        this.view1 = view3;
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

    public static AdapterTriggerPulseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerPulseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTriggerPulseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_pulse, viewGroup, z, obj);
    }

    public static AdapterTriggerPulseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerPulseBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTriggerPulseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_pulse, null, false, obj);
    }

    public static AdapterTriggerPulseBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerPulseBinding bind(View view, Object obj) {
        return (AdapterTriggerPulseBinding) bind(obj, view, R.layout.adapter_trigger_pulse);
    }
}
