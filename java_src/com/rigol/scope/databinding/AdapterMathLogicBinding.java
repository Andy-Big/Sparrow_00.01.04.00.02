package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.baseview.BaseEditText;
/* loaded from: classes2.dex */
public abstract class AdapterMathLogicBinding extends ViewDataBinding {
    public final RadioButton fullRadioButton;
    public final TextView gridType;
    public final RadioGroup gridTypeRadioGroup;
    public final RadioButton halfRadioButton;
    public final TextView label;
    public final BaseEditText labelEditText;
    public final SwitchButton labelSwitch;
    public final RadioButton largeRadioButton;
    @Bindable
    protected MappingObject mGridFullMapping;
    @Bindable
    protected MappingObject mGridHalfMapping;
    @Bindable
    protected MappingObject mGridNoneMapping;
    @Bindable
    protected Integer mItemPosition;
    @Bindable
    protected MappingObject mLargeMapping;
    @Bindable
    protected MappingObject mMediumMapping;
    @Bindable
    protected MathParam mParam;
    @Bindable
    protected MappingObject mSmallMapping;
    public final View mathDividingLine;
    public final Guideline mathGuidelineCenter;
    public final ImageButton mathOffsetDown;
    public final ImageButton mathOffsetUp;
    public final RadioButton mediumRadioButton;
    public final RadioButton noneRadioButton;
    public final TextView offset;
    public final EditText offsetEditText;
    public final TextView sensitivity;
    public final EditText sensitivityEditText;
    public final TextView size;
    public final RadioGroup sizeRadioGroup;
    public final RadioButton smallRadioButton;
    public final TextView sourceA;
    public final TextView sourceASpinner;
    public final TextView sourceB;
    public final TextView sourceBSpinner;
    public final TextView thresholdCh1;
    public final EditText thresholdCh1EditText;
    public final TextView thresholdCh2;
    public final EditText thresholdCh2EditText;
    public final TextView thresholdCh3;
    public final EditText thresholdCh3EditText;
    public final TextView thresholdCh4;
    public final EditText thresholdCh4EditText;
    public final TextView waveType;
    public final SwitchButton waveTypeSwitch;

    public abstract void setGridFullMapping(MappingObject mappingObject);

    public abstract void setGridHalfMapping(MappingObject mappingObject);

    public abstract void setGridNoneMapping(MappingObject mappingObject);

    public abstract void setItemPosition(Integer num);

    public abstract void setLargeMapping(MappingObject mappingObject);

    public abstract void setMediumMapping(MappingObject mappingObject);

    public abstract void setParam(MathParam mathParam);

    public abstract void setSmallMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterMathLogicBinding(Object obj, View view, int i, RadioButton radioButton, TextView textView, RadioGroup radioGroup, RadioButton radioButton2, TextView textView2, BaseEditText baseEditText, SwitchButton switchButton, RadioButton radioButton3, View view2, Guideline guideline, ImageButton imageButton, ImageButton imageButton2, RadioButton radioButton4, RadioButton radioButton5, TextView textView3, EditText editText, TextView textView4, EditText editText2, TextView textView5, RadioGroup radioGroup2, RadioButton radioButton6, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, EditText editText3, TextView textView11, EditText editText4, TextView textView12, EditText editText5, TextView textView13, EditText editText6, TextView textView14, SwitchButton switchButton2) {
        super(obj, view, i);
        this.fullRadioButton = radioButton;
        this.gridType = textView;
        this.gridTypeRadioGroup = radioGroup;
        this.halfRadioButton = radioButton2;
        this.label = textView2;
        this.labelEditText = baseEditText;
        this.labelSwitch = switchButton;
        this.largeRadioButton = radioButton3;
        this.mathDividingLine = view2;
        this.mathGuidelineCenter = guideline;
        this.mathOffsetDown = imageButton;
        this.mathOffsetUp = imageButton2;
        this.mediumRadioButton = radioButton4;
        this.noneRadioButton = radioButton5;
        this.offset = textView3;
        this.offsetEditText = editText;
        this.sensitivity = textView4;
        this.sensitivityEditText = editText2;
        this.size = textView5;
        this.sizeRadioGroup = radioGroup2;
        this.smallRadioButton = radioButton6;
        this.sourceA = textView6;
        this.sourceASpinner = textView7;
        this.sourceB = textView8;
        this.sourceBSpinner = textView9;
        this.thresholdCh1 = textView10;
        this.thresholdCh1EditText = editText3;
        this.thresholdCh2 = textView11;
        this.thresholdCh2EditText = editText4;
        this.thresholdCh3 = textView12;
        this.thresholdCh3EditText = editText5;
        this.thresholdCh4 = textView13;
        this.thresholdCh4EditText = editText6;
        this.waveType = textView14;
        this.waveTypeSwitch = switchButton2;
    }

    public MathParam getParam() {
        return this.mParam;
    }

    public Integer getItemPosition() {
        return this.mItemPosition;
    }

    public MappingObject getSmallMapping() {
        return this.mSmallMapping;
    }

    public MappingObject getMediumMapping() {
        return this.mMediumMapping;
    }

    public MappingObject getLargeMapping() {
        return this.mLargeMapping;
    }

    public MappingObject getGridFullMapping() {
        return this.mGridFullMapping;
    }

    public MappingObject getGridHalfMapping() {
        return this.mGridHalfMapping;
    }

    public MappingObject getGridNoneMapping() {
        return this.mGridNoneMapping;
    }

    public static AdapterMathLogicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMathLogicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterMathLogicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_math_logic, viewGroup, z, obj);
    }

    public static AdapterMathLogicBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMathLogicBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterMathLogicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_math_logic, null, false, obj);
    }

    public static AdapterMathLogicBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMathLogicBinding bind(View view, Object obj) {
        return (AdapterMathLogicBinding) bind(obj, view, R.layout.adapter_math_logic);
    }
}
