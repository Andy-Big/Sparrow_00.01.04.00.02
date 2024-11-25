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
public abstract class AdapterTriggerNthBinding extends ViewDataBinding {
    public final Button buttonLevel;
    public final Guideline guidelineCenter;
    public final Guideline guidelineFifth;
    public final Guideline guidelineForth;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final ImageView imageView2;
    @Bindable
    protected TriggerParam mParam;
    @Bindable
    protected MappingObject mSlopeFallingMapping;
    @Bindable
    protected MappingObject mSlopeRisingMapping;
    @Bindable
    protected MappingObject mSweepAutoMapping;
    @Bindable
    protected MappingObject mSweepNormalMapping;
    @Bindable
    protected MappingObject mSweepSingleMapping;
    public final TextView triggerLevel;
    public final EditText triggerLevelValue;
    public final VerticalSeekBar triggerLevelView;
    public final View triggerNoise;
    public final TextView triggerNoiseLabel;
    public final SwitchButton triggerNoiseSwitch;
    public final RadioButton triggerNthEdgeFalling;
    public final TextView triggerNthEdgeLabel;
    public final TextView triggerNthEdgeNumberLabel;
    public final EditText triggerNthEdgeNumberValue;
    public final RadioButton triggerNthEdgeRising;
    public final TextView triggerNthIdleTimeLabel;
    public final EditText triggerNthIdleTimeValue;
    public final TextView triggerSource;
    public final TextView triggerSourceLabel;
    public final VerticalSeekBarWrapper verticalSeekBarWrapper2;
    public final View view;
    public final View view2;
    public final View viewTop;

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setSlopeFallingMapping(MappingObject mappingObject);

    public abstract void setSlopeRisingMapping(MappingObject mappingObject);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTriggerNthBinding(Object obj, View view, int i, Button button, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, ImageView imageView, TextView textView, EditText editText, VerticalSeekBar verticalSeekBar, View view2, TextView textView2, SwitchButton switchButton, RadioButton radioButton, TextView textView3, TextView textView4, EditText editText2, RadioButton radioButton2, TextView textView5, EditText editText3, TextView textView6, TextView textView7, VerticalSeekBarWrapper verticalSeekBarWrapper, View view3, View view4, View view5) {
        super(obj, view, i);
        this.buttonLevel = button;
        this.guidelineCenter = guideline;
        this.guidelineFifth = guideline2;
        this.guidelineForth = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
        this.imageView2 = imageView;
        this.triggerLevel = textView;
        this.triggerLevelValue = editText;
        this.triggerLevelView = verticalSeekBar;
        this.triggerNoise = view2;
        this.triggerNoiseLabel = textView2;
        this.triggerNoiseSwitch = switchButton;
        this.triggerNthEdgeFalling = radioButton;
        this.triggerNthEdgeLabel = textView3;
        this.triggerNthEdgeNumberLabel = textView4;
        this.triggerNthEdgeNumberValue = editText2;
        this.triggerNthEdgeRising = radioButton2;
        this.triggerNthIdleTimeLabel = textView5;
        this.triggerNthIdleTimeValue = editText3;
        this.triggerSource = textView6;
        this.triggerSourceLabel = textView7;
        this.verticalSeekBarWrapper2 = verticalSeekBarWrapper;
        this.view = view3;
        this.view2 = view4;
        this.viewTop = view5;
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

    public MappingObject getSlopeRisingMapping() {
        return this.mSlopeRisingMapping;
    }

    public MappingObject getSlopeFallingMapping() {
        return this.mSlopeFallingMapping;
    }

    public static AdapterTriggerNthBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerNthBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTriggerNthBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_nth, viewGroup, z, obj);
    }

    public static AdapterTriggerNthBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerNthBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTriggerNthBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_nth, null, false, obj);
    }

    public static AdapterTriggerNthBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerNthBinding bind(View view, Object obj) {
        return (AdapterTriggerNthBinding) bind(obj, view, R.layout.adapter_trigger_nth);
    }
}
