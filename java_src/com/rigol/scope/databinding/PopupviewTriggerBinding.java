package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
/* loaded from: classes2.dex */
public abstract class PopupviewTriggerBinding extends ViewDataBinding {
    public final RadioButton autoRadioButton;
    public final Button forceTrigger;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected View.OnClickListener mClickListener;
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
    public final ConstraintLayout triggerLayout;
    public final TextView triggerModeLabel;
    public final TextView triggerType;
    public final TextView triggerTypeLabel;
    public final RecyclerView triggerView;
    public final Button verticalSetting;

    public abstract void setClickListener(View.OnClickListener onClickListener);

    public abstract void setParam(TriggerParam triggerParam);

    public abstract void setSweepAutoMapping(MappingObject mappingObject);

    public abstract void setSweepNormalMapping(MappingObject mappingObject);

    public abstract void setSweepSingleMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewTriggerBinding(Object obj, View view, int i, RadioButton radioButton, Button button, Guideline guideline, Guideline guideline2, Guideline guideline3, RadioGroup radioGroup, RadioButton radioButton2, RadioButton radioButton3, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, RecyclerView recyclerView, Button button2) {
        super(obj, view, i);
        this.autoRadioButton = radioButton;
        this.forceTrigger = button;
        this.guidelineCenter = guideline;
        this.guidelineLeft = guideline2;
        this.guidelineRight = guideline3;
        this.modeRadioGroup = radioGroup;
        this.normalRadioButton = radioButton2;
        this.singleRadioButton = radioButton3;
        this.triggerLayout = constraintLayout;
        this.triggerModeLabel = textView;
        this.triggerType = textView2;
        this.triggerTypeLabel = textView3;
        this.triggerView = recyclerView;
        this.verticalSetting = button2;
    }

    public TriggerParam getParam() {
        return this.mParam;
    }

    public View.OnClickListener getClickListener() {
        return this.mClickListener;
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

    public static PopupviewTriggerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewTriggerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewTriggerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_trigger, viewGroup, z, obj);
    }

    public static PopupviewTriggerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewTriggerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewTriggerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_trigger, null, false, obj);
    }

    public static PopupviewTriggerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewTriggerBinding bind(View view, Object obj) {
        return (PopupviewTriggerBinding) bind(obj, view, R.layout.popupview_trigger);
    }
}
