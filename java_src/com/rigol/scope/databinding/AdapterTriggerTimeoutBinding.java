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
public abstract class AdapterTriggerTimeoutBinding extends ViewDataBinding {
    public final Button buttonLevel;
    public final Guideline guidelineCenter;
    public final Guideline guidelineForth;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final ImageView imageView2;
    @Bindable
    protected TriggerParam mParam;
    @Bindable
    protected MappingObject mSlopeEitherMapping;
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
    public final TextView triggerNoiseLabel;
    public final SwitchButton triggerNoiseSwitch;
    public final TextView triggerSource;
    public final TextView triggerSourceLabel;
    public final RadioButton triggerTimeoutEdgeEither;
    public final RadioButton triggerTimeoutEdgeFalling;
    public final TextView triggerTimeoutEdgeLabel;
    public final RadioButton triggerTimeoutEdgeRising;
    public final TextView triggerTimeoutTimeLabel;
    public final EditText triggerTimeoutTimeValue;
    public final VerticalSeekBarWrapper verticalSeekBarWrapper2;
    public final View viewLine1;
    public final View viewLine2;
    public final View viewTop;

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setSlopeEitherMapping(MappingObject mappingObject);

    public abstract void setSlopeFallingMapping(MappingObject mappingObject);

    public abstract void setSlopeRisingMapping(MappingObject mappingObject);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTriggerTimeoutBinding(Object obj, View view, int i, Button button, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, ImageView imageView, TextView textView, EditText editText, VerticalSeekBar verticalSeekBar, TextView textView2, SwitchButton switchButton, TextView textView3, TextView textView4, RadioButton radioButton, RadioButton radioButton2, TextView textView5, RadioButton radioButton3, TextView textView6, EditText editText2, VerticalSeekBarWrapper verticalSeekBarWrapper, View view2, View view3, View view4) {
        super(obj, view, i);
        this.buttonLevel = button;
        this.guidelineCenter = guideline;
        this.guidelineForth = guideline2;
        this.guidelineLeft = guideline3;
        this.guidelineRight = guideline4;
        this.imageView2 = imageView;
        this.triggerLevel = textView;
        this.triggerLevelValue = editText;
        this.triggerLevelView = verticalSeekBar;
        this.triggerNoiseLabel = textView2;
        this.triggerNoiseSwitch = switchButton;
        this.triggerSource = textView3;
        this.triggerSourceLabel = textView4;
        this.triggerTimeoutEdgeEither = radioButton;
        this.triggerTimeoutEdgeFalling = radioButton2;
        this.triggerTimeoutEdgeLabel = textView5;
        this.triggerTimeoutEdgeRising = radioButton3;
        this.triggerTimeoutTimeLabel = textView6;
        this.triggerTimeoutTimeValue = editText2;
        this.verticalSeekBarWrapper2 = verticalSeekBarWrapper;
        this.viewLine1 = view2;
        this.viewLine2 = view3;
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

    public MappingObject getSlopeRisingMapping() {
        return this.mSlopeRisingMapping;
    }

    public MappingObject getSlopeFallingMapping() {
        return this.mSlopeFallingMapping;
    }

    public MappingObject getSlopeEitherMapping() {
        return this.mSlopeEitherMapping;
    }

    public static AdapterTriggerTimeoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerTimeoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTriggerTimeoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_timeout, viewGroup, z, obj);
    }

    public static AdapterTriggerTimeoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerTimeoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTriggerTimeoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_timeout, null, false, obj);
    }

    public static AdapterTriggerTimeoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerTimeoutBinding bind(View view, Object obj) {
        return (AdapterTriggerTimeoutBinding) bind(obj, view, R.layout.adapter_trigger_timeout);
    }
}
