package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
public abstract class AdapterMathFilterBinding extends ViewDataBinding {
    public final Button autoSettingBtn;
    public final TextView bpWc1;
    public final EditText bpWc1EditText;
    public final TextView bpWc2;
    public final EditText bpWc2EditText;
    public final TextView btWc1;
    public final EditText btWc1EditText;
    public final TextView btWc2;
    public final EditText btWc2EditText;
    public final RadioButton centerRadioButton;
    public final TextView expand;
    public final RadioGroup expandRadioGroup;
    public final RadioButton fullRadioButton;
    public final RadioButton gndRadioButton;
    public final TextView gridType;
    public final RadioGroup gridTypeRadioGroup;
    public final RadioButton halfRadioButton;
    public final TextView hpWc;
    public final EditText hpWcEditText;
    public final TextView invert;
    public final SwitchButton invertSwitch;
    public final TextView label;
    public final BaseEditText labelEditText;
    public final SwitchButton labelSwitch;
    public final TextView lpWc;
    public final EditText lpWcEditText;
    @Bindable
    protected MappingObject mCenterMapping;
    @Bindable
    protected MappingObject mGndMapping;
    @Bindable
    protected MappingObject mGridFullMapping;
    @Bindable
    protected MappingObject mGridHalfMapping;
    @Bindable
    protected MappingObject mGridNoneMapping;
    @Bindable
    protected Integer mItemPosition;
    @Bindable
    protected MathParam mParam;
    public final ImageButton mainScaleNomal;
    public final ImageButton mainScaleVertical;
    public final View mathDividingLine;
    public final Guideline mathGuidelineCenter;
    public final ImageButton mathOffsetDown;
    public final ImageButton mathOffsetUp;
    public final RadioButton noneRadioButton;
    public final TextView offset;
    public final EditText offsetEditText;
    public final TextView scale;
    public final EditText scaleEditText;
    public final TextView sourceA;
    public final TextView sourceASpinner;
    public final TextView waveType;
    public final SwitchButton waveTypeSwitch;

    public abstract void setCenterMapping(MappingObject mappingObject);

    public abstract void setGndMapping(MappingObject mappingObject);

    public abstract void setGridFullMapping(MappingObject mappingObject);

    public abstract void setGridHalfMapping(MappingObject mappingObject);

    public abstract void setGridNoneMapping(MappingObject mappingObject);

    public abstract void setItemPosition(Integer num);

    public abstract void setParam(MathParam mathParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterMathFilterBinding(Object obj, View view, int i, Button button, TextView textView, EditText editText, TextView textView2, EditText editText2, TextView textView3, EditText editText3, TextView textView4, EditText editText4, RadioButton radioButton, TextView textView5, RadioGroup radioGroup, RadioButton radioButton2, RadioButton radioButton3, TextView textView6, RadioGroup radioGroup2, RadioButton radioButton4, TextView textView7, EditText editText5, TextView textView8, SwitchButton switchButton, TextView textView9, BaseEditText baseEditText, SwitchButton switchButton2, TextView textView10, EditText editText6, ImageButton imageButton, ImageButton imageButton2, View view2, Guideline guideline, ImageButton imageButton3, ImageButton imageButton4, RadioButton radioButton5, TextView textView11, EditText editText7, TextView textView12, EditText editText8, TextView textView13, TextView textView14, TextView textView15, SwitchButton switchButton3) {
        super(obj, view, i);
        this.autoSettingBtn = button;
        this.bpWc1 = textView;
        this.bpWc1EditText = editText;
        this.bpWc2 = textView2;
        this.bpWc2EditText = editText2;
        this.btWc1 = textView3;
        this.btWc1EditText = editText3;
        this.btWc2 = textView4;
        this.btWc2EditText = editText4;
        this.centerRadioButton = radioButton;
        this.expand = textView5;
        this.expandRadioGroup = radioGroup;
        this.fullRadioButton = radioButton2;
        this.gndRadioButton = radioButton3;
        this.gridType = textView6;
        this.gridTypeRadioGroup = radioGroup2;
        this.halfRadioButton = radioButton4;
        this.hpWc = textView7;
        this.hpWcEditText = editText5;
        this.invert = textView8;
        this.invertSwitch = switchButton;
        this.label = textView9;
        this.labelEditText = baseEditText;
        this.labelSwitch = switchButton2;
        this.lpWc = textView10;
        this.lpWcEditText = editText6;
        this.mainScaleNomal = imageButton;
        this.mainScaleVertical = imageButton2;
        this.mathDividingLine = view2;
        this.mathGuidelineCenter = guideline;
        this.mathOffsetDown = imageButton3;
        this.mathOffsetUp = imageButton4;
        this.noneRadioButton = radioButton5;
        this.offset = textView11;
        this.offsetEditText = editText7;
        this.scale = textView12;
        this.scaleEditText = editText8;
        this.sourceA = textView13;
        this.sourceASpinner = textView14;
        this.waveType = textView15;
        this.waveTypeSwitch = switchButton3;
    }

    public MathParam getParam() {
        return this.mParam;
    }

    public Integer getItemPosition() {
        return this.mItemPosition;
    }

    public MappingObject getGndMapping() {
        return this.mGndMapping;
    }

    public MappingObject getCenterMapping() {
        return this.mCenterMapping;
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

    public static AdapterMathFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMathFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterMathFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_math_filter, viewGroup, z, obj);
    }

    public static AdapterMathFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMathFilterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterMathFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_math_filter, null, false, obj);
    }

    public static AdapterMathFilterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMathFilterBinding bind(View view, Object obj) {
        return (AdapterMathFilterBinding) bind(obj, view, R.layout.adapter_math_filter);
    }
}
