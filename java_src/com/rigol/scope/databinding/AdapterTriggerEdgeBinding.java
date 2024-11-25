package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.vertical.VerticalSeekBar;
import com.rigol.scope.views.vertical.VerticalSeekBarWrapper;
/* loaded from: classes2.dex */
public abstract class AdapterTriggerEdgeBinding extends ViewDataBinding {
    public final RadioButton autoRadioButton;
    public final Button buttonLevel;
    public final RadioButton edgeEither;
    public final RadioButton edgeFalling;
    public final RadioButton edgeRising;
    public final ImageView edgeSlopeImageButton;
    public final TextView edgeTypeLabel;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected MappingObject mEdgeEitherMapping;
    @Bindable
    protected MappingObject mEdgeFallingMapping;
    @Bindable
    protected MappingObject mEdgeRisingMapping;
    @Bindable
    protected TriggerParam mParam;
    @Bindable
    protected MappingObject mSweepAutoMapping;
    @Bindable
    protected MappingObject mSweepNormalMapping;
    @Bindable
    protected MappingObject mSweepSingleMapping;
    public final RadioGroup modeRadioGroup;
    public final RadioButton normalRadioButton;
    public final RadioButton singleRadioButton;
    public final TextView triggerCoupling;
    public final TextView triggerCouplingLabel;
    public final EditText triggerHoldoff;
    public final TextView triggerHoldoffLabel;
    public final TextView triggerLevel;
    public final EditText triggerLevelValue;
    public final VerticalSeekBar triggerLevelView;
    public final TextView triggerModeLabel;
    public final TextView triggerNoiseLabel;
    public final SwitchButton triggerNoiseSwitch;
    public final TextView triggerSource;
    public final TextView triggerSourceLabel;
    public final VerticalSeekBarWrapper verticalSeekBarWrapper2;
    public final View viewLine1;
    public final View viewLine2;
    public final View viewTop;

    public abstract void setEdgeEitherMapping(MappingObject mappingObject);

    public abstract void setEdgeFallingMapping(MappingObject mappingObject);

    public abstract void setEdgeRisingMapping(MappingObject mappingObject);

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTriggerEdgeBinding(Object obj, View view, int i, RadioButton radioButton, Button button, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, ImageView imageView, TextView textView, Guideline guideline, Guideline guideline2, Guideline guideline3, RadioGroup radioGroup, RadioButton radioButton5, RadioButton radioButton6, TextView textView2, TextView textView3, EditText editText, TextView textView4, TextView textView5, EditText editText2, VerticalSeekBar verticalSeekBar, TextView textView6, TextView textView7, SwitchButton switchButton, TextView textView8, TextView textView9, VerticalSeekBarWrapper verticalSeekBarWrapper, View view2, View view3, View view4) {
        super(obj, view, i);
        this.autoRadioButton = radioButton;
        this.buttonLevel = button;
        this.edgeEither = radioButton2;
        this.edgeFalling = radioButton3;
        this.edgeRising = radioButton4;
        this.edgeSlopeImageButton = imageView;
        this.edgeTypeLabel = textView;
        this.guidelineCenter = guideline;
        this.guidelineLeft = guideline2;
        this.guidelineRight = guideline3;
        this.modeRadioGroup = radioGroup;
        this.normalRadioButton = radioButton5;
        this.singleRadioButton = radioButton6;
        this.triggerCoupling = textView2;
        this.triggerCouplingLabel = textView3;
        this.triggerHoldoff = editText;
        this.triggerHoldoffLabel = textView4;
        this.triggerLevel = textView5;
        this.triggerLevelValue = editText2;
        this.triggerLevelView = verticalSeekBar;
        this.triggerModeLabel = textView6;
        this.triggerNoiseLabel = textView7;
        this.triggerNoiseSwitch = switchButton;
        this.triggerSource = textView8;
        this.triggerSourceLabel = textView9;
        this.verticalSeekBarWrapper2 = verticalSeekBarWrapper;
        this.viewLine1 = view2;
        this.viewLine2 = view3;
        this.viewTop = view4;
    }

    public TriggerParam getParam() {
        return this.mParam;
    }

    public MappingObject getEdgeRisingMapping() {
        return this.mEdgeRisingMapping;
    }

    public MappingObject getEdgeFallingMapping() {
        return this.mEdgeFallingMapping;
    }

    public MappingObject getEdgeEitherMapping() {
        return this.mEdgeEitherMapping;
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

    public static AdapterTriggerEdgeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerEdgeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTriggerEdgeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_edge, viewGroup, z, obj);
    }

    public static AdapterTriggerEdgeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerEdgeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTriggerEdgeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_edge, null, false, obj);
    }

    public static AdapterTriggerEdgeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerEdgeBinding bind(View view, Object obj) {
        return (AdapterTriggerEdgeBinding) bind(obj, view, R.layout.adapter_trigger_edge);
    }
}
