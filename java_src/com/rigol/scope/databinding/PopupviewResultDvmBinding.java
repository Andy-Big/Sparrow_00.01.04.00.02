package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.DvmResultParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class PopupviewResultDvmBinding extends ViewDataBinding {
    public final TextView beeper;
    public final SwitchButton beeperSwitch;
    public final TextView delete;
    public final Button deleteButton;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final TextView limitType;
    public final SwitchButton limitTypeSwitch;
    public final TextView lower;
    public final EditText lowerEditText;
    @Bindable
    protected MappingObject mAcMappingObject;
    @Bindable
    protected MappingObject mAcdcMappingObject;
    @Bindable
    protected MappingObject mDcMappingObject;
    @Bindable
    protected View.OnClickListener mOnClickListener;
    @Bindable
    protected DvmResultParam mParam;
    public final TextView mode;
    public final RadioButton modeAcDcRadioButton;
    public final RadioButton modeAcRadioButton;
    public final RadioButton modeDcRadioButton;
    public final RadioGroup modeRadioGroup;
    public final TextView source;
    public final TextView sourceSpinner;
    public final TextView upper;
    public final EditText upperEditText;

    public abstract void setAcMappingObject(MappingObject mappingObject);

    public abstract void setAcdcMappingObject(MappingObject mappingObject);

    public abstract void setDcMappingObject(MappingObject mappingObject);

    public abstract void setOnClickListener(View.OnClickListener onClickListener);

    public abstract void setParam(DvmResultParam dvmResultParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewResultDvmBinding(Object obj, View view, int i, TextView textView, SwitchButton switchButton, TextView textView2, Button button, Guideline guideline, Guideline guideline2, Guideline guideline3, TextView textView3, SwitchButton switchButton2, TextView textView4, EditText editText, TextView textView5, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioGroup radioGroup, TextView textView6, TextView textView7, TextView textView8, EditText editText2) {
        super(obj, view, i);
        this.beeper = textView;
        this.beeperSwitch = switchButton;
        this.delete = textView2;
        this.deleteButton = button;
        this.guidelineCenter = guideline;
        this.guidelineLeft = guideline2;
        this.guidelineRight = guideline3;
        this.limitType = textView3;
        this.limitTypeSwitch = switchButton2;
        this.lower = textView4;
        this.lowerEditText = editText;
        this.mode = textView5;
        this.modeAcDcRadioButton = radioButton;
        this.modeAcRadioButton = radioButton2;
        this.modeDcRadioButton = radioButton3;
        this.modeRadioGroup = radioGroup;
        this.source = textView6;
        this.sourceSpinner = textView7;
        this.upper = textView8;
        this.upperEditText = editText2;
    }

    public DvmResultParam getParam() {
        return this.mParam;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public MappingObject getAcMappingObject() {
        return this.mAcMappingObject;
    }

    public MappingObject getDcMappingObject() {
        return this.mDcMappingObject;
    }

    public MappingObject getAcdcMappingObject() {
        return this.mAcdcMappingObject;
    }

    public static PopupviewResultDvmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewResultDvmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewResultDvmBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_result_dvm, viewGroup, z, obj);
    }

    public static PopupviewResultDvmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewResultDvmBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewResultDvmBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_result_dvm, null, false, obj);
    }

    public static PopupviewResultDvmBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewResultDvmBinding bind(View view, Object obj) {
        return (PopupviewResultDvmBinding) bind(obj, view, R.layout.popupview_result_dvm);
    }
}
