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
public abstract class AdapterTriggerLinBinding extends ViewDataBinding {
    public final Button buttonLevel;
    public final Guideline guidelineCenter;
    public final Guideline guidelineFifth;
    public final Guideline guidelineForth;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected TriggerParam mParam;
    @Bindable
    protected MappingObject mSweepAutoMapping;
    @Bindable
    protected MappingObject mSweepNormalMapping;
    @Bindable
    protected MappingObject mSweepSingleMapping;
    @Bindable
    protected MappingObject mVersion1Mapping;
    @Bindable
    protected MappingObject mVersion2Mapping;
    @Bindable
    protected MappingObject mVersionBothMapping;
    @Bindable
    protected MappingObject mWhenDataIdMapping;
    @Bindable
    protected MappingObject mWhenDataMapping;
    @Bindable
    protected MappingObject mWhenErrorMapping;
    @Bindable
    protected MappingObject mWhenIdMapping;
    @Bindable
    protected MappingObject mWhenSleepMapping;
    @Bindable
    protected MappingObject mWhenSyncMapping;
    @Bindable
    protected MappingObject mWhenWakeUpMapping;
    public final TextView triggerErrTypeLabel;
    public final TextView triggerErrTypeValue;
    public final TextView triggerLabel;
    public final TextView triggerLevel;
    public final EditText triggerLevelValue;
    public final TextView triggerLinBaudValue;
    public final TextView triggerLinBytelengthLabel;
    public final TextView triggerLinBytelengthValue;
    public final RadioButton triggerLinData;
    public final RadioButton triggerLinDataId;
    public final TextView triggerLinDataLabel;
    public final EditText triggerLinDataValue;
    public final RadioButton triggerLinError;
    public final RadioButton triggerLinId;
    public final TextView triggerLinIdLabel;
    public final EditText triggerLinIdValue;
    public final RadioButton triggerLinSleep;
    public final RadioButton triggerLinSync;
    public final RadioButton triggerLinVersion1;
    public final RadioButton triggerLinVersion2;
    public final RadioButton triggerLinVersionBoth;
    public final RadioButton triggerLinWakeup;
    public final TextView triggerNoiseLabel;
    public final SwitchButton triggerNoiseSwitch;
    public final TextView triggerSamplePointsLabel;
    public final EditText triggerSamplePointsValue;
    public final TextView triggerSourceLinBaudLabel;
    public final TextView triggerSourceLinLabel;
    public final TextView triggerSourceLinValue;
    public final TextView triggerSourceLinVersionLabel;
    public final View view1;
    public final View view2;
    public final View view3;
    public final View view4;
    public final View viewLine1;
    public final View viewLine2;
    public final View viewTop;

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    public abstract void setVersion1Mapping(MappingObject mappingObject);

    public abstract void setVersion2Mapping(MappingObject mappingObject);

    public abstract void setVersionBothMapping(MappingObject mappingObject);

    public abstract void setWhenDataIdMapping(MappingObject mappingObject);

    public abstract void setWhenDataMapping(MappingObject mappingObject);

    public abstract void setWhenErrorMapping(MappingObject mappingObject);

    public abstract void setWhenIdMapping(MappingObject mappingObject);

    public abstract void setWhenSleepMapping(MappingObject mappingObject);

    public abstract void setWhenSyncMapping(MappingObject mappingObject);

    public abstract void setWhenWakeUpMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTriggerLinBinding(Object obj, View view, int i, Button button, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, TextView textView, TextView textView2, TextView textView3, TextView textView4, EditText editText, TextView textView5, TextView textView6, TextView textView7, RadioButton radioButton, RadioButton radioButton2, TextView textView8, EditText editText2, RadioButton radioButton3, RadioButton radioButton4, TextView textView9, EditText editText3, RadioButton radioButton5, RadioButton radioButton6, RadioButton radioButton7, RadioButton radioButton8, RadioButton radioButton9, RadioButton radioButton10, TextView textView10, SwitchButton switchButton, TextView textView11, EditText editText4, TextView textView12, TextView textView13, TextView textView14, TextView textView15, View view2, View view3, View view4, View view5, View view6, View view7, View view8) {
        super(obj, view, i);
        this.buttonLevel = button;
        this.guidelineCenter = guideline;
        this.guidelineFifth = guideline2;
        this.guidelineForth = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
        this.triggerErrTypeLabel = textView;
        this.triggerErrTypeValue = textView2;
        this.triggerLabel = textView3;
        this.triggerLevel = textView4;
        this.triggerLevelValue = editText;
        this.triggerLinBaudValue = textView5;
        this.triggerLinBytelengthLabel = textView6;
        this.triggerLinBytelengthValue = textView7;
        this.triggerLinData = radioButton;
        this.triggerLinDataId = radioButton2;
        this.triggerLinDataLabel = textView8;
        this.triggerLinDataValue = editText2;
        this.triggerLinError = radioButton3;
        this.triggerLinId = radioButton4;
        this.triggerLinIdLabel = textView9;
        this.triggerLinIdValue = editText3;
        this.triggerLinSleep = radioButton5;
        this.triggerLinSync = radioButton6;
        this.triggerLinVersion1 = radioButton7;
        this.triggerLinVersion2 = radioButton8;
        this.triggerLinVersionBoth = radioButton9;
        this.triggerLinWakeup = radioButton10;
        this.triggerNoiseLabel = textView10;
        this.triggerNoiseSwitch = switchButton;
        this.triggerSamplePointsLabel = textView11;
        this.triggerSamplePointsValue = editText4;
        this.triggerSourceLinBaudLabel = textView12;
        this.triggerSourceLinLabel = textView13;
        this.triggerSourceLinValue = textView14;
        this.triggerSourceLinVersionLabel = textView15;
        this.view1 = view2;
        this.view2 = view3;
        this.view3 = view4;
        this.view4 = view5;
        this.viewLine1 = view6;
        this.viewLine2 = view7;
        this.viewTop = view8;
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

    public MappingObject getWhenSyncMapping() {
        return this.mWhenSyncMapping;
    }

    public MappingObject getWhenIdMapping() {
        return this.mWhenIdMapping;
    }

    public MappingObject getWhenDataMapping() {
        return this.mWhenDataMapping;
    }

    public MappingObject getWhenDataIdMapping() {
        return this.mWhenDataIdMapping;
    }

    public MappingObject getWhenSleepMapping() {
        return this.mWhenSleepMapping;
    }

    public MappingObject getWhenWakeUpMapping() {
        return this.mWhenWakeUpMapping;
    }

    public MappingObject getWhenErrorMapping() {
        return this.mWhenErrorMapping;
    }

    public MappingObject getVersion1Mapping() {
        return this.mVersion1Mapping;
    }

    public MappingObject getVersion2Mapping() {
        return this.mVersion2Mapping;
    }

    public MappingObject getVersionBothMapping() {
        return this.mVersionBothMapping;
    }

    public static AdapterTriggerLinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerLinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTriggerLinBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_lin, viewGroup, z, obj);
    }

    public static AdapterTriggerLinBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerLinBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTriggerLinBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_lin, null, false, obj);
    }

    public static AdapterTriggerLinBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTriggerLinBinding bind(View view, Object obj) {
        return (AdapterTriggerLinBinding) bind(obj, view, R.layout.adapter_trigger_lin);
    }
}
