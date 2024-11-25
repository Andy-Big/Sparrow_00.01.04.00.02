package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
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
public abstract class AdapterMathFftBinding extends ViewDataBinding {
    public final RadioButton AmpRadioButton;
    public final RadioButton FreqRadioButton;
    public final TextView X;
    public final RadioGroup XRadioGroup;
    public final Button autoSettingBtn;
    public final ConstraintLayout basicSetting;
    public final TextView colorGrade;
    public final Button colorGradeReset;
    public final SwitchButton colorGradeSwitch;
    public final RadioButton dbRadioButton;
    public final TextView excursion;
    public final EditText excursionEditText;
    public final Button exportBtn;
    public final TextView fftCenter;
    public final EditText fftCenterEditText;
    public final TextView fftEnd;
    public final EditText fftEndEditText;
    public final TextView fftSpan;
    public final EditText fftSpanEditText;
    public final TextView fftStart;
    public final EditText fftStartEditText;
    public final RadioButton fullRadioButton;
    public final TextView gridType;
    public final RadioGroup gridTypeRadioGroup;
    public final Guideline guidelineCenter;
    public final RadioButton halfRadioButton;
    public final TextView label;
    public final BaseEditText labelEditText;
    public final SwitchButton labelSwitch;
    @Bindable
    protected MappingObject mAmpOrderMapping;
    @Bindable
    protected MappingObject mDbMapping;
    @Bindable
    protected MappingObject mFreqOrderMapping;
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
    @Bindable
    protected MappingObject mSPanCenterMapping;
    @Bindable
    protected MappingObject mStartEndMapping;
    @Bindable
    protected MappingObject mVrmsMapping;
    public final ImageButton mainScaleNomal;
    public final ImageButton mainScaleVertical;
    public final View mathDividingLine;
    public final Guideline mathGuidelineCenter;
    public final ImageButton mathOffsetDown;
    public final ImageButton mathOffsetUp;
    public final RadioButton noneRadioButton;
    public final TextView offset;
    public final EditText offsetEditText;
    public final Guideline peakGuidelineCenter;
    public final TextView peakNumber;
    public final EditText peakNumberEditText;
    public final TextView peakSearch;
    public final ImageView peakSearchImage;
    public final ConstraintLayout peakSearchSetting;
    public final SwitchButton peakSearchSwitch;
    public final TextView peakSearchText;
    public final ConstraintLayout peakSearchTitle;
    public final TextView scale;
    public final EditText scaleEditText;
    public final TextView sourceA;
    public final TextView sourceASpinner;
    public final RadioButton spanCenterRadioButton;
    public final RadioButton startEndRadioButton;
    public final TextView tableOrder;
    public final RadioGroup tableOrderRadioGroup;
    public final TextView threshold;
    public final EditText thresholdEditText;
    public final TextView unit;
    public final RadioGroup unitRadioGroup;
    public final RadioButton vrmsRadioButton;
    public final TextView waveType;
    public final SwitchButton waveTypeSwitch;
    public final TextView window;
    public final TextView windowSpinner;

    public abstract void setAmpOrderMapping(MappingObject mappingObject);

    public abstract void setDbMapping(MappingObject mappingObject);

    public abstract void setFreqOrderMapping(MappingObject mappingObject);

    public abstract void setGridFullMapping(MappingObject mappingObject);

    public abstract void setGridHalfMapping(MappingObject mappingObject);

    public abstract void setGridNoneMapping(MappingObject mappingObject);

    public abstract void setItemPosition(Integer num);

    public abstract void setParam(MathParam mathParam);

    public abstract void setSPanCenterMapping(MappingObject mappingObject);

    public abstract void setStartEndMapping(MappingObject mappingObject);

    public abstract void setVrmsMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterMathFftBinding(Object obj, View view, int i, RadioButton radioButton, RadioButton radioButton2, TextView textView, RadioGroup radioGroup, Button button, ConstraintLayout constraintLayout, TextView textView2, Button button2, SwitchButton switchButton, RadioButton radioButton3, TextView textView3, EditText editText, Button button3, TextView textView4, EditText editText2, TextView textView5, EditText editText3, TextView textView6, EditText editText4, TextView textView7, EditText editText5, RadioButton radioButton4, TextView textView8, RadioGroup radioGroup2, Guideline guideline, RadioButton radioButton5, TextView textView9, BaseEditText baseEditText, SwitchButton switchButton2, ImageButton imageButton, ImageButton imageButton2, View view2, Guideline guideline2, ImageButton imageButton3, ImageButton imageButton4, RadioButton radioButton6, TextView textView10, EditText editText6, Guideline guideline3, TextView textView11, EditText editText7, TextView textView12, ImageView imageView, ConstraintLayout constraintLayout2, SwitchButton switchButton3, TextView textView13, ConstraintLayout constraintLayout3, TextView textView14, EditText editText8, TextView textView15, TextView textView16, RadioButton radioButton7, RadioButton radioButton8, TextView textView17, RadioGroup radioGroup3, TextView textView18, EditText editText9, TextView textView19, RadioGroup radioGroup4, RadioButton radioButton9, TextView textView20, SwitchButton switchButton4, TextView textView21, TextView textView22) {
        super(obj, view, i);
        this.AmpRadioButton = radioButton;
        this.FreqRadioButton = radioButton2;
        this.X = textView;
        this.XRadioGroup = radioGroup;
        this.autoSettingBtn = button;
        this.basicSetting = constraintLayout;
        this.colorGrade = textView2;
        this.colorGradeReset = button2;
        this.colorGradeSwitch = switchButton;
        this.dbRadioButton = radioButton3;
        this.excursion = textView3;
        this.excursionEditText = editText;
        this.exportBtn = button3;
        this.fftCenter = textView4;
        this.fftCenterEditText = editText2;
        this.fftEnd = textView5;
        this.fftEndEditText = editText3;
        this.fftSpan = textView6;
        this.fftSpanEditText = editText4;
        this.fftStart = textView7;
        this.fftStartEditText = editText5;
        this.fullRadioButton = radioButton4;
        this.gridType = textView8;
        this.gridTypeRadioGroup = radioGroup2;
        this.guidelineCenter = guideline;
        this.halfRadioButton = radioButton5;
        this.label = textView9;
        this.labelEditText = baseEditText;
        this.labelSwitch = switchButton2;
        this.mainScaleNomal = imageButton;
        this.mainScaleVertical = imageButton2;
        this.mathDividingLine = view2;
        this.mathGuidelineCenter = guideline2;
        this.mathOffsetDown = imageButton3;
        this.mathOffsetUp = imageButton4;
        this.noneRadioButton = radioButton6;
        this.offset = textView10;
        this.offsetEditText = editText6;
        this.peakGuidelineCenter = guideline3;
        this.peakNumber = textView11;
        this.peakNumberEditText = editText7;
        this.peakSearch = textView12;
        this.peakSearchImage = imageView;
        this.peakSearchSetting = constraintLayout2;
        this.peakSearchSwitch = switchButton3;
        this.peakSearchText = textView13;
        this.peakSearchTitle = constraintLayout3;
        this.scale = textView14;
        this.scaleEditText = editText8;
        this.sourceA = textView15;
        this.sourceASpinner = textView16;
        this.spanCenterRadioButton = radioButton7;
        this.startEndRadioButton = radioButton8;
        this.tableOrder = textView17;
        this.tableOrderRadioGroup = radioGroup3;
        this.threshold = textView18;
        this.thresholdEditText = editText9;
        this.unit = textView19;
        this.unitRadioGroup = radioGroup4;
        this.vrmsRadioButton = radioButton9;
        this.waveType = textView20;
        this.waveTypeSwitch = switchButton4;
        this.window = textView21;
        this.windowSpinner = textView22;
    }

    public MathParam getParam() {
        return this.mParam;
    }

    public Integer getItemPosition() {
        return this.mItemPosition;
    }

    public MappingObject getSPanCenterMapping() {
        return this.mSPanCenterMapping;
    }

    public MappingObject getStartEndMapping() {
        return this.mStartEndMapping;
    }

    public MappingObject getDbMapping() {
        return this.mDbMapping;
    }

    public MappingObject getVrmsMapping() {
        return this.mVrmsMapping;
    }

    public MappingObject getAmpOrderMapping() {
        return this.mAmpOrderMapping;
    }

    public MappingObject getFreqOrderMapping() {
        return this.mFreqOrderMapping;
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

    public static AdapterMathFftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMathFftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterMathFftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_math_fft, viewGroup, z, obj);
    }

    public static AdapterMathFftBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMathFftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterMathFftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_math_fft, null, false, obj);
    }

    public static AdapterMathFftBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMathFftBinding bind(View view, Object obj) {
        return (AdapterMathFftBinding) bind(obj, view, R.layout.adapter_math_fft);
    }
}
