package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
/* loaded from: classes2.dex */
public abstract class AdapterTriggerSpiBinding extends ViewDataBinding {
    public final Button buttonLevel;
    public final Button buttonLevelb;
    public final Button buttonLevelc;
    public final RadioButton edgeFalling;
    public final RadioButton edgeRising;
    public final TextView edgeTypeLabel;
    public final Guideline guidelineCenter;
    public final Guideline guidelineFifth;
    public final Guideline guidelineForth;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected MappingObject mEdgeFallingMapping;
    @Bindable
    protected MappingObject mEdgeRisingMapping;
    @Bindable
    protected MappingObject mModeNegativeMapping;
    @Bindable
    protected MappingObject mModePositiveMapping;
    @Bindable
    protected TriggerParam mParam;
    @Bindable
    protected MappingObject mSweepAutoMapping;
    @Bindable
    protected MappingObject mSweepNormalMapping;
    @Bindable
    protected MappingObject mSweepSingleMapping;
    @Bindable
    protected MappingObject mWhenCsMapping;
    @Bindable
    protected MappingObject mWhenTimeoutMapping;
    public final TextView triggerLabel;
    public final TextView triggerLevel;
    public final EditText triggerLevelValue;
    public final TextView triggerLevelb;
    public final EditText triggerLevelbValue;
    public final TextView triggerLevelc;
    public final EditText triggerLevelcValue;
    public final TextView triggerNoiseLabel;
    public final SwitchButton triggerNoiseSwitch;
    public final TextView triggerSourceCs;
    public final TextView triggerSourceCsLabel;
    public final TextView triggerSourceScl;
    public final TextView triggerSourceSclLabel;
    public final TextView triggerSourceSda;
    public final TextView triggerSourceSdaLabel;
    public final TextView triggerSpiCsMode;
    public final RadioButton triggerSpiCsModeN;
    public final RadioButton triggerSpiCsModeP;
    public final TextView triggerSpiDataLabel;
    public final EditText triggerSpiDataValue;
    public final TextView triggerSpiDatabitsLabel;
    public final EditText triggerSpiDatabitsValue;
    public final RadioButton triggerSpiTimeout;
    public final TextView triggerSpiTimeoutLabel;
    public final EditText triggerSpiTimeoutValue;
    public final RadioButton triggerSpiWithCs;
    public final View view16;
    public final View view2;
    public final View viewHideData;
    public final View viewHideModel;
    public final View viewHideTimeout;
    public final View viewTop;
    public final View viewTriggerCondition;

    public abstract void setEdgeFallingMapping(MappingObject mappingObject);

    public abstract void setEdgeRisingMapping(MappingObject mappingObject);

    public abstract void setModeNegativeMapping(MappingObject mappingObject);

    public abstract void setModePositiveMapping(MappingObject mappingObject);

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    public abstract void setWhenCsMapping(MappingObject mappingObject);

    public abstract void setWhenTimeoutMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTriggerSpiBinding(Object obj, View view, int i, Button button, Button button2, Button button3, RadioButton radioButton, RadioButton radioButton2, TextView textView, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, TextView textView2, TextView textView3, EditText editText, TextView textView4, EditText editText2, TextView textView5, EditText editText3, TextView textView6, SwitchButton switchButton, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, RadioButton radioButton3, RadioButton radioButton4, TextView textView14, EditText editText4, TextView textView15, EditText editText5, RadioButton radioButton5, TextView textView16, EditText editText6, RadioButton radioButton6, View view2, View view3, View view4, View view5, View view6, View view7, View view8) {
        super(obj, view, i);
        this.buttonLevel = button;
        this.buttonLevelb = button2;
        this.buttonLevelc = button3;
        this.edgeFalling = radioButton;
        this.edgeRising = radioButton2;
        this.edgeTypeLabel = textView;
        this.guidelineCenter = guideline;
        this.guidelineFifth = guideline2;
        this.guidelineForth = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
        this.triggerLabel = textView2;
        this.triggerLevel = textView3;
        this.triggerLevelValue = editText;
        this.triggerLevelb = textView4;
        this.triggerLevelbValue = editText2;
        this.triggerLevelc = textView5;
        this.triggerLevelcValue = editText3;
        this.triggerNoiseLabel = textView6;
        this.triggerNoiseSwitch = switchButton;
        this.triggerSourceCs = textView7;
        this.triggerSourceCsLabel = textView8;
        this.triggerSourceScl = textView9;
        this.triggerSourceSclLabel = textView10;
        this.triggerSourceSda = textView11;
        this.triggerSourceSdaLabel = textView12;
        this.triggerSpiCsMode = textView13;
        this.triggerSpiCsModeN = radioButton3;
        this.triggerSpiCsModeP = radioButton4;
        this.triggerSpiDataLabel = textView14;
        this.triggerSpiDataValue = editText4;
        this.triggerSpiDatabitsLabel = textView15;
        this.triggerSpiDatabitsValue = editText5;
        this.triggerSpiTimeout = radioButton5;
        this.triggerSpiTimeoutLabel = textView16;
        this.triggerSpiTimeoutValue = editText6;
        this.triggerSpiWithCs = radioButton6;
        this.view16 = view2;
        this.view2 = view3;
        this.viewHideData = view4;
        this.viewHideModel = view5;
        this.viewHideTimeout = view6;
        this.viewTop = view7;
        this.viewTriggerCondition = view8;
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

    public MappingObject getEdgeRisingMapping() {
        return this.mEdgeRisingMapping;
    }

    public MappingObject getEdgeFallingMapping() {
        return this.mEdgeFallingMapping;
    }

    public MappingObject getWhenCsMapping() {
        return this.mWhenCsMapping;
    }

    public MappingObject getWhenTimeoutMapping() {
        return this.mWhenTimeoutMapping;
    }

    public MappingObject getModePositiveMapping() {
        return this.mModePositiveMapping;
    }

    public MappingObject getModeNegativeMapping() {
        return this.mModeNegativeMapping;
    }

    public static AdapterTriggerSpiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerSpiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTriggerSpiBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_spi, viewGroup, z, obj);
    }

    public static AdapterTriggerSpiBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerSpiBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTriggerSpiBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_spi, null, false, obj);
    }

    public static AdapterTriggerSpiBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerSpiBinding bind(View view, Object obj) {
        return (AdapterTriggerSpiBinding) bind(obj, view, R.layout.adapter_trigger_spi);
    }
}
