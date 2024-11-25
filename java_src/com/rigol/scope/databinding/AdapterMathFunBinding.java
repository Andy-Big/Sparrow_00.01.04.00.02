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
public abstract class AdapterMathFunBinding extends ViewDataBinding {
    public final Button autoSettingBtn;
    public final TextView bias;
    public final EditText biasEditText;
    public final RadioButton centerRadioButton;
    public final TextView expand;
    public final RadioGroup expandRadioGroup;
    public final RadioButton fullRadioButton;
    public final RadioButton gndRadioButton;
    public final TextView gridType;
    public final RadioGroup gridTypeRadioGroup;
    public final RadioButton halfRadioButton;
    public final TextView invert;
    public final SwitchButton invertSwitch;
    public final TextView label;
    public final BaseEditText labelEditText;
    public final SwitchButton labelSwitch;
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
    public final TextView paramA;
    public final EditText paramAEditText;
    public final TextView paramB;
    public final EditText paramBEditText;
    public final TextView scale;
    public final EditText scaleEditText;
    public final TextView smooth;
    public final EditText smoothEditText;
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
    public AdapterMathFunBinding(Object obj, View view, int i, Button button, TextView textView, EditText editText, RadioButton radioButton, TextView textView2, RadioGroup radioGroup, RadioButton radioButton2, RadioButton radioButton3, TextView textView3, RadioGroup radioGroup2, RadioButton radioButton4, TextView textView4, SwitchButton switchButton, TextView textView5, BaseEditText baseEditText, SwitchButton switchButton2, ImageButton imageButton, ImageButton imageButton2, View view2, Guideline guideline, ImageButton imageButton3, ImageButton imageButton4, RadioButton radioButton5, TextView textView6, EditText editText2, TextView textView7, EditText editText3, TextView textView8, EditText editText4, TextView textView9, EditText editText5, TextView textView10, EditText editText6, TextView textView11, TextView textView12, TextView textView13, SwitchButton switchButton3) {
        super(obj, view, i);
        this.autoSettingBtn = button;
        this.bias = textView;
        this.biasEditText = editText;
        this.centerRadioButton = radioButton;
        this.expand = textView2;
        this.expandRadioGroup = radioGroup;
        this.fullRadioButton = radioButton2;
        this.gndRadioButton = radioButton3;
        this.gridType = textView3;
        this.gridTypeRadioGroup = radioGroup2;
        this.halfRadioButton = radioButton4;
        this.invert = textView4;
        this.invertSwitch = switchButton;
        this.label = textView5;
        this.labelEditText = baseEditText;
        this.labelSwitch = switchButton2;
        this.mainScaleNomal = imageButton;
        this.mainScaleVertical = imageButton2;
        this.mathDividingLine = view2;
        this.mathGuidelineCenter = guideline;
        this.mathOffsetDown = imageButton3;
        this.mathOffsetUp = imageButton4;
        this.noneRadioButton = radioButton5;
        this.offset = textView6;
        this.offsetEditText = editText2;
        this.paramA = textView7;
        this.paramAEditText = editText3;
        this.paramB = textView8;
        this.paramBEditText = editText4;
        this.scale = textView9;
        this.scaleEditText = editText5;
        this.smooth = textView10;
        this.smoothEditText = editText6;
        this.sourceA = textView11;
        this.sourceASpinner = textView12;
        this.waveType = textView13;
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

    public static AdapterMathFunBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMathFunBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterMathFunBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_math_fun, viewGroup, z, obj);
    }

    public static AdapterMathFunBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMathFunBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterMathFunBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_math_fun, null, false, obj);
    }

    public static AdapterMathFunBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMathFunBinding bind(View view, Object obj) {
        return (AdapterMathFunBinding) bind(obj, view, R.layout.adapter_math_fun);
    }
}
