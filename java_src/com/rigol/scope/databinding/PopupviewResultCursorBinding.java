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
import com.rigol.scope.data.CursorResultParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class PopupviewResultCursorBinding extends ViewDataBinding {
    public final TextView aLocation;
    public final EditText aLocationEditText;
    public final TextView aSrc;
    public final TextView aSrcSpinnermanual;
    public final TextView aSrcSpinnertrack;
    public final TextView aSrcSpinnerxy;
    public final TextView bLocation;
    public final EditText bLocationEditText;
    public final TextView bSrc;
    public final TextView bSrcSpinner;
    public final TextView bothAb;
    public final SwitchButton bothAbSwitch;
    public final Button byLocationEditText;
    public final TextView delete;
    public final Button deleteButton;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    @Bindable
    protected CursorResultParam mCursorParam;
    @Bindable
    protected MappingObject mManualMapping;
    @Bindable
    protected View.OnClickListener mOnClickListener;
    @Bindable
    protected SharedParam mSharedParam;
    @Bindable
    protected MappingObject mTrackMapping;
    @Bindable
    protected MappingObject mXyMapping;
    public final RadioButton manualRadioButton;
    public final TextView mode;
    public final RadioGroup modeRadioGroup;
    public final TextView syncArea;
    public final TextView syncAreaSpinner;
    public final RadioButton trackRadioButton;
    public final TextView unit;
    public final TextView unitSpinner;
    public final TextView xOrY;
    public final SwitchButton xOrYSwitch;
    public final RadioButton xyRadioButton;

    public abstract void setCursorParam(CursorResultParam cursorResultParam);

    public abstract void setManualMapping(MappingObject mappingObject);

    public abstract void setOnClickListener(View.OnClickListener onClickListener);

    public abstract void setSharedParam(SharedParam sharedParam);

    public abstract void setTrackMapping(MappingObject mappingObject);

    public abstract void setXyMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewResultCursorBinding(Object obj, View view, int i, TextView textView, EditText editText, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, EditText editText2, TextView textView7, TextView textView8, TextView textView9, SwitchButton switchButton, Button button, TextView textView10, Button button2, Guideline guideline, Guideline guideline2, Guideline guideline3, RadioButton radioButton, TextView textView11, RadioGroup radioGroup, TextView textView12, TextView textView13, RadioButton radioButton2, TextView textView14, TextView textView15, TextView textView16, SwitchButton switchButton2, RadioButton radioButton3) {
        super(obj, view, i);
        this.aLocation = textView;
        this.aLocationEditText = editText;
        this.aSrc = textView2;
        this.aSrcSpinnermanual = textView3;
        this.aSrcSpinnertrack = textView4;
        this.aSrcSpinnerxy = textView5;
        this.bLocation = textView6;
        this.bLocationEditText = editText2;
        this.bSrc = textView7;
        this.bSrcSpinner = textView8;
        this.bothAb = textView9;
        this.bothAbSwitch = switchButton;
        this.byLocationEditText = button;
        this.delete = textView10;
        this.deleteButton = button2;
        this.guidelineCenter = guideline;
        this.guidelineLeft = guideline2;
        this.guidelineRight = guideline3;
        this.manualRadioButton = radioButton;
        this.mode = textView11;
        this.modeRadioGroup = radioGroup;
        this.syncArea = textView12;
        this.syncAreaSpinner = textView13;
        this.trackRadioButton = radioButton2;
        this.unit = textView14;
        this.unitSpinner = textView15;
        this.xOrY = textView16;
        this.xOrYSwitch = switchButton2;
        this.xyRadioButton = radioButton3;
    }

    public CursorResultParam getCursorParam() {
        return this.mCursorParam;
    }

    public SharedParam getSharedParam() {
        return this.mSharedParam;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public MappingObject getManualMapping() {
        return this.mManualMapping;
    }

    public MappingObject getTrackMapping() {
        return this.mTrackMapping;
    }

    public MappingObject getXyMapping() {
        return this.mXyMapping;
    }

    public static PopupviewResultCursorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewResultCursorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewResultCursorBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_result_cursor, viewGroup, z, obj);
    }

    public static PopupviewResultCursorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewResultCursorBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewResultCursorBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_result_cursor, null, false, obj);
    }

    public static PopupviewResultCursorBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewResultCursorBinding bind(View view, Object obj) {
        return (PopupviewResultCursorBinding) bind(obj, view, R.layout.popupview_result_cursor);
    }
}
