package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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
public abstract class AdapterTrigger1553bBinding extends ViewDataBinding {
    public final Button buttonLevela;
    public final Button buttonLevelb;
    public final Guideline guidelineCenter;
    public final Guideline guidelineFifth;
    public final Guideline guidelineForth;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final View height5;
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
    protected MappingObject mWhenDataMapping;
    @Bindable
    protected MappingObject mWhenErrorMapping;
    @Bindable
    protected MappingObject mWhenRtaMapping;
    @Bindable
    protected MappingObject mWhenRtabitMapping;
    @Bindable
    protected MappingObject mWhenSyncMapping;
    public final TextView trigger1553bCompareLabel;
    public final RadioButton trigger1553bData;
    public final TextView trigger1553bDownLimitLabel;
    public final EditText trigger1553bDownLimitValue;
    public final RadioButton trigger1553bEq;
    public final RadioButton trigger1553bError;
    public final TextView trigger1553bErrorLabel;
    public final TextView trigger1553bErrorValue;
    public final RadioButton trigger1553bLessthan;
    public final RadioButton trigger1553bLevela;
    public final CheckBox trigger1553bLevelab;
    public final RadioButton trigger1553bLevelb;
    public final RadioButton trigger1553bMoreless;
    public final RadioButton trigger1553bMorethan;
    public final RadioButton trigger1553bNegative;
    public final RadioButton trigger1553bNeq;
    public final TextView trigger1553bPolarityLabel;
    public final RadioButton trigger1553bPositive;
    public final RadioButton trigger1553bRta;
    public final TextView trigger1553bRta11Label;
    public final EditText trigger1553bRta11Value;
    public final RadioButton trigger1553bRta11bit;
    public final TextView trigger1553bRtaLabel;
    public final EditText trigger1553bRtaValue;
    public final RadioButton trigger1553bSync;
    public final TextView trigger1553bSyncLabel;
    public final TextView trigger1553bSyncValue;
    public final RadioButton trigger1553bUnmoreless;
    public final TextView trigger1553bUpLimitLabel;
    public final EditText trigger1553bUpLimitValue;
    public final TextView triggerLabel;
    public final TextView triggerLevelSelectLabel;
    public final TextView triggerLevelaLabel;
    public final EditText triggerLevelaValue;
    public final TextView triggerLevelbLabel;
    public final EditText triggerLevelbValue;
    public final TextView triggerNoiseLabel;
    public final SwitchButton triggerNoiseSwitch;
    public final TextView triggerSource;
    public final TextView triggerSourceLabel;
    public final TextView triggerSourceLabel2;
    public final View view16;
    public final View view2;
    public final View viewBottom;
    public final View viewMiddle;
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

    public abstract void setWhenDataMapping(MappingObject mappingObject);

    public abstract void setWhenErrorMapping(MappingObject mappingObject);

    public abstract void setWhenRtaMapping(MappingObject mappingObject);

    public abstract void setWhenRtabitMapping(MappingObject mappingObject);

    public abstract void setWhenSyncMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTrigger1553bBinding(Object obj, View view, int i, Button button, Button button2, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, View view2, TextView textView, RadioButton radioButton, TextView textView2, EditText editText, RadioButton radioButton2, RadioButton radioButton3, TextView textView3, TextView textView4, RadioButton radioButton4, RadioButton radioButton5, CheckBox checkBox, RadioButton radioButton6, RadioButton radioButton7, RadioButton radioButton8, RadioButton radioButton9, RadioButton radioButton10, TextView textView5, RadioButton radioButton11, RadioButton radioButton12, TextView textView6, EditText editText2, RadioButton radioButton13, TextView textView7, EditText editText3, RadioButton radioButton14, TextView textView8, TextView textView9, RadioButton radioButton15, TextView textView10, EditText editText4, TextView textView11, TextView textView12, TextView textView13, EditText editText5, TextView textView14, EditText editText6, TextView textView15, SwitchButton switchButton, TextView textView16, TextView textView17, TextView textView18, View view3, View view4, View view5, View view6, View view7) {
        super(obj, view, i);
        this.buttonLevela = button;
        this.buttonLevelb = button2;
        this.guidelineCenter = guideline;
        this.guidelineFifth = guideline2;
        this.guidelineForth = guideline3;
        this.guidelineLeft = guideline4;
        this.guidelineRight = guideline5;
        this.height5 = view2;
        this.trigger1553bCompareLabel = textView;
        this.trigger1553bData = radioButton;
        this.trigger1553bDownLimitLabel = textView2;
        this.trigger1553bDownLimitValue = editText;
        this.trigger1553bEq = radioButton2;
        this.trigger1553bError = radioButton3;
        this.trigger1553bErrorLabel = textView3;
        this.trigger1553bErrorValue = textView4;
        this.trigger1553bLessthan = radioButton4;
        this.trigger1553bLevela = radioButton5;
        this.trigger1553bLevelab = checkBox;
        this.trigger1553bLevelb = radioButton6;
        this.trigger1553bMoreless = radioButton7;
        this.trigger1553bMorethan = radioButton8;
        this.trigger1553bNegative = radioButton9;
        this.trigger1553bNeq = radioButton10;
        this.trigger1553bPolarityLabel = textView5;
        this.trigger1553bPositive = radioButton11;
        this.trigger1553bRta = radioButton12;
        this.trigger1553bRta11Label = textView6;
        this.trigger1553bRta11Value = editText2;
        this.trigger1553bRta11bit = radioButton13;
        this.trigger1553bRtaLabel = textView7;
        this.trigger1553bRtaValue = editText3;
        this.trigger1553bSync = radioButton14;
        this.trigger1553bSyncLabel = textView8;
        this.trigger1553bSyncValue = textView9;
        this.trigger1553bUnmoreless = radioButton15;
        this.trigger1553bUpLimitLabel = textView10;
        this.trigger1553bUpLimitValue = editText4;
        this.triggerLabel = textView11;
        this.triggerLevelSelectLabel = textView12;
        this.triggerLevelaLabel = textView13;
        this.triggerLevelaValue = editText5;
        this.triggerLevelbLabel = textView14;
        this.triggerLevelbValue = editText6;
        this.triggerNoiseLabel = textView15;
        this.triggerNoiseSwitch = switchButton;
        this.triggerSource = textView16;
        this.triggerSourceLabel = textView17;
        this.triggerSourceLabel2 = textView18;
        this.view16 = view3;
        this.view2 = view4;
        this.viewBottom = view5;
        this.viewMiddle = view6;
        this.viewTop = view7;
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

    public MappingObject getWhenSyncMapping() {
        return this.mWhenSyncMapping;
    }

    public MappingObject getWhenDataMapping() {
        return this.mWhenDataMapping;
    }

    public MappingObject getWhenRtaMapping() {
        return this.mWhenRtaMapping;
    }

    public MappingObject getWhenRtabitMapping() {
        return this.mWhenRtabitMapping;
    }

    public MappingObject getWhenErrorMapping() {
        return this.mWhenErrorMapping;
    }

    public static AdapterTrigger1553bBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTrigger1553bBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTrigger1553bBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_1553b, viewGroup, z, obj);
    }

    public static AdapterTrigger1553bBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTrigger1553bBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTrigger1553bBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_trigger_1553b, null, false, obj);
    }

    public static AdapterTrigger1553bBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTrigger1553bBinding bind(View view, Object obj) {
        return (AdapterTrigger1553bBinding) bind(obj, view, R.layout.adapter_trigger_1553b);
    }
}
