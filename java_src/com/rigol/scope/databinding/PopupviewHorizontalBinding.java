package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class PopupviewHorizontalBinding extends ViewDataBinding {
    public final TextView antiAliasing;
    public final RadioButton autoRadioButton;
    public final RadioButton averageRadioButton;
    public final TextView avgTimes;
    public final EditText avgTimesEditText;
    public final SwitchButton delaySample;
    public final TextView delaySampleText;
    public final TextView displaySpinner;
    public final TextView displayText;
    public final View dividingLine;
    public final TextView expand;
    public final TextView expandSpinner;
    public final TextView expandUser;
    public final EditText expandUserEditText;
    public final TextView fineOn;
    public final SwitchButton fineOnSwitch;
    public final Guideline guidelineCenter;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final TextView highBit;
    public final TextView highBitSpinner;
    public final TextView highBw;
    public final TextView highInfo;
    public final SwitchButton histogramEn;
    public final RadioButton hresRadioButton;
    @Bindable
    protected MappingObject mAutoMappingObj;
    @Bindable
    protected MappingObject mAverageMappingObj;
    @Bindable
    protected BodeParam mBodeParam;
    @Bindable
    protected CompoundButton.OnCheckedChangeListener mCheckedChangeListener;
    @Bindable
    protected View.OnClickListener mClickListener;
    @Bindable
    protected FunctionManager mFunctionManager;
    @Bindable
    protected MappingObject mHresMappingObj;
    @Bindable
    protected MappingObject mNormalMappingObj;
    @Bindable
    protected MappingObject mOffMappingObj;
    @Bindable
    protected HorizontalParam mParam;
    @Bindable
    protected MappingObject mPeakMappingObj;
    @Bindable
    protected MappingObject mUltraMappingObj;
    public final TextView mainOffset;
    public final EditText mainOffsetEditText;
    public final ImageButton mainOffsetLeft;
    public final ImageButton mainOffsetRight;
    public final TextView mainScale;
    public final EditText mainScaleEditText;
    public final ImageButton mainScaleLeft;
    public final ImageButton mainScaleRight;
    public final EditText maxFrameEdit;
    public final TextView maxFrameText;
    public final TextView memdepth;
    public final TextView memdepthSpinner;
    public final TextView mode;
    public final RadioGroup modeRadioGroup;
    public final RadioButton normalRadioButton;
    public final RadioButton offRadioButton;
    public final RadioButton peakRadioButton;
    public final TextView roll;
    public final RadioGroup rollRadioGroup;
    public final TextView sarate;
    public final TextView sarateText;
    public final EditText timeOutEdit;
    public final TextView timeOutText;
    public final TextView timescale;
    public final TextView timescaleText;
    public final RadioButton ultraRadioButton;
    public final Button verticalSetting;
    public final CheckBox xyCheck;
    public final TextView zoomOffset;
    public final EditText zoomOffsetEditText;
    public final ImageButton zoomOffsetLeft;
    public final ImageButton zoomOffsetRight;
    public final TextView zoomOn;
    public final SwitchButton zoomOnSwitch;
    public final TextView zoomScale;
    public final EditText zoomScaleEditText;
    public final ImageButton zoomScaleLeft;
    public final ImageButton zoomScaleRight;

    public abstract void setAutoMappingObj(MappingObject mappingObject);

    public abstract void setAverageMappingObj(MappingObject mappingObject);

    public abstract void setBodeParam(BodeParam bodeParam);

    public abstract void setCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener);

    public abstract void setClickListener(View.OnClickListener onClickListener);

    public abstract void setFunctionManager(FunctionManager functionManager);

    public abstract void setHresMappingObj(MappingObject mappingObject);

    public abstract void setNormalMappingObj(MappingObject mappingObject);

    public abstract void setOffMappingObj(MappingObject mappingObject);

    public abstract void setParam(HorizontalParam horizontalParam);

    public abstract void setPeakMappingObj(MappingObject mappingObject);

    public abstract void setUltraMappingObj(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewHorizontalBinding(Object obj, View view, int i, TextView textView, RadioButton radioButton, RadioButton radioButton2, TextView textView2, EditText editText, SwitchButton switchButton, TextView textView3, TextView textView4, TextView textView5, View view2, TextView textView6, TextView textView7, TextView textView8, EditText editText2, TextView textView9, SwitchButton switchButton2, Guideline guideline, Guideline guideline2, Guideline guideline3, TextView textView10, TextView textView11, TextView textView12, TextView textView13, SwitchButton switchButton3, RadioButton radioButton3, TextView textView14, EditText editText3, ImageButton imageButton, ImageButton imageButton2, TextView textView15, EditText editText4, ImageButton imageButton3, ImageButton imageButton4, EditText editText5, TextView textView16, TextView textView17, TextView textView18, TextView textView19, RadioGroup radioGroup, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, TextView textView20, RadioGroup radioGroup2, TextView textView21, TextView textView22, EditText editText6, TextView textView23, TextView textView24, TextView textView25, RadioButton radioButton7, Button button, CheckBox checkBox, TextView textView26, EditText editText7, ImageButton imageButton5, ImageButton imageButton6, TextView textView27, SwitchButton switchButton4, TextView textView28, EditText editText8, ImageButton imageButton7, ImageButton imageButton8) {
        super(obj, view, i);
        this.antiAliasing = textView;
        this.autoRadioButton = radioButton;
        this.averageRadioButton = radioButton2;
        this.avgTimes = textView2;
        this.avgTimesEditText = editText;
        this.delaySample = switchButton;
        this.delaySampleText = textView3;
        this.displaySpinner = textView4;
        this.displayText = textView5;
        this.dividingLine = view2;
        this.expand = textView6;
        this.expandSpinner = textView7;
        this.expandUser = textView8;
        this.expandUserEditText = editText2;
        this.fineOn = textView9;
        this.fineOnSwitch = switchButton2;
        this.guidelineCenter = guideline;
        this.guidelineLeft = guideline2;
        this.guidelineRight = guideline3;
        this.highBit = textView10;
        this.highBitSpinner = textView11;
        this.highBw = textView12;
        this.highInfo = textView13;
        this.histogramEn = switchButton3;
        this.hresRadioButton = radioButton3;
        this.mainOffset = textView14;
        this.mainOffsetEditText = editText3;
        this.mainOffsetLeft = imageButton;
        this.mainOffsetRight = imageButton2;
        this.mainScale = textView15;
        this.mainScaleEditText = editText4;
        this.mainScaleLeft = imageButton3;
        this.mainScaleRight = imageButton4;
        this.maxFrameEdit = editText5;
        this.maxFrameText = textView16;
        this.memdepth = textView17;
        this.memdepthSpinner = textView18;
        this.mode = textView19;
        this.modeRadioGroup = radioGroup;
        this.normalRadioButton = radioButton4;
        this.offRadioButton = radioButton5;
        this.peakRadioButton = radioButton6;
        this.roll = textView20;
        this.rollRadioGroup = radioGroup2;
        this.sarate = textView21;
        this.sarateText = textView22;
        this.timeOutEdit = editText6;
        this.timeOutText = textView23;
        this.timescale = textView24;
        this.timescaleText = textView25;
        this.ultraRadioButton = radioButton7;
        this.verticalSetting = button;
        this.xyCheck = checkBox;
        this.zoomOffset = textView26;
        this.zoomOffsetEditText = editText7;
        this.zoomOffsetLeft = imageButton5;
        this.zoomOffsetRight = imageButton6;
        this.zoomOn = textView27;
        this.zoomOnSwitch = switchButton4;
        this.zoomScale = textView28;
        this.zoomScaleEditText = editText8;
        this.zoomScaleLeft = imageButton7;
        this.zoomScaleRight = imageButton8;
    }

    public HorizontalParam getParam() {
        return this.mParam;
    }

    public BodeParam getBodeParam() {
        return this.mBodeParam;
    }

    public View.OnClickListener getClickListener() {
        return this.mClickListener;
    }

    public CompoundButton.OnCheckedChangeListener getCheckedChangeListener() {
        return this.mCheckedChangeListener;
    }

    public MappingObject getNormalMappingObj() {
        return this.mNormalMappingObj;
    }

    public MappingObject getAverageMappingObj() {
        return this.mAverageMappingObj;
    }

    public MappingObject getPeakMappingObj() {
        return this.mPeakMappingObj;
    }

    public MappingObject getHresMappingObj() {
        return this.mHresMappingObj;
    }

    public MappingObject getUltraMappingObj() {
        return this.mUltraMappingObj;
    }

    public MappingObject getAutoMappingObj() {
        return this.mAutoMappingObj;
    }

    public MappingObject getOffMappingObj() {
        return this.mOffMappingObj;
    }

    public FunctionManager getFunctionManager() {
        return this.mFunctionManager;
    }

    public static PopupviewHorizontalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewHorizontalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewHorizontalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_horizontal, viewGroup, z, obj);
    }

    public static PopupviewHorizontalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewHorizontalBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewHorizontalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_horizontal, null, false, obj);
    }

    public static PopupviewHorizontalBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewHorizontalBinding bind(View view, Object obj) {
        return (PopupviewHorizontalBinding) bind(obj, view, R.layout.popupview_horizontal);
    }
}
