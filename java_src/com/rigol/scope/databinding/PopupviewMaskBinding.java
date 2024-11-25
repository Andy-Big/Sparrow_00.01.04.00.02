package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MaskParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class PopupviewMaskBinding extends ViewDataBinding {
    public final Button buttonMaskCreateMenu;
    public final Button buttonMaskLoad;
    public final Button buttonMaskSave;
    public final CheckBox checkBoxMaskBeeper;
    public final CheckBox checkBoxMaskScreen;
    public final CheckBox checkBoxMaskStop;
    public final View dividingLine1;
    public final View dividingLine2;
    public final TextView enable;
    public final SwitchButton enableSwitch;
    public final Guideline guidelineCenter;
    public final ImageButton imageButtonMaskXmaskLeft;
    public final ImageButton imageButtonMaskXmaskRight;
    public final ImageButton imageButtonMaskYmaskDown;
    public final ImageButton imageButtonMaskYmaskUP;
    @Bindable
    protected MappingObject mCursorMapping;
    @Bindable
    protected MappingObject mFailMapping;
    @Bindable
    protected HorizontalParam mHorizontalParam;
    @Bindable
    protected MappingObject mNegativeMapping;
    @Bindable
    protected MaskParam mParam;
    @Bindable
    protected MappingObject mPassMapping;
    @Bindable
    protected MappingObject mPositiveMapping;
    @Bindable
    protected MappingObject mScreenMapping;
    public final TextView mask;
    public final TextView operate;
    public final ImageView operateButton;
    public final RadioButton radioButtonMaskCursor;
    public final RadioButton radioButtonMaskFaile;
    public final RadioButton radioButtonMaskNegativePulse;
    public final RadioButton radioButtonMaskPass;
    public final RadioButton radioButtonMaskPositionPulse;
    public final RadioButton radioButtonMaskScreen;
    public final RadioGroup radioGroupMaskOutEvent;
    public final RadioGroup radioGroupMaskOutHl;
    public final RadioGroup radioGroupMaskRange;
    public final Button resetButton;
    public final TextView source;
    public final TextView sourceSpinner;
    public final SwitchButton switchButtonMaskOut;
    public final TextView textViewMaskErrAction;
    public final TextView textViewMaskOUt;
    public final TextView textViewMaskOption;
    public final TextView textViewMaskOutEvent;
    public final TextView textViewMaskOutHl;
    public final TextView textViewMaskOutPulse;
    public final TextView textViewMaskRange;
    public final TextView textViewMaskXmask;
    public final TextView textViewMaskYmask;
    public final TextView valueMaskOUtPulse;
    public final TextView valueMaskXmask;
    public final TextView valueMaskYmask;

    public abstract void setCursorMapping(MappingObject mappingObject);

    public abstract void setFailMapping(MappingObject mappingObject);

    public abstract void setHorizontalParam(HorizontalParam horizontalParam);

    public abstract void setNegativeMapping(MappingObject mappingObject);

    public abstract void setParam(MaskParam maskParam);

    public abstract void setPassMapping(MappingObject mappingObject);

    public abstract void setPositiveMapping(MappingObject mappingObject);

    public abstract void setScreenMapping(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewMaskBinding(Object obj, View view, int i, Button button, Button button2, Button button3, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, View view2, View view3, TextView textView, SwitchButton switchButton, Guideline guideline, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, TextView textView2, TextView textView3, ImageView imageView, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioGroup radioGroup, RadioGroup radioGroup2, RadioGroup radioGroup3, Button button4, TextView textView4, TextView textView5, SwitchButton switchButton2, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17) {
        super(obj, view, i);
        this.buttonMaskCreateMenu = button;
        this.buttonMaskLoad = button2;
        this.buttonMaskSave = button3;
        this.checkBoxMaskBeeper = checkBox;
        this.checkBoxMaskScreen = checkBox2;
        this.checkBoxMaskStop = checkBox3;
        this.dividingLine1 = view2;
        this.dividingLine2 = view3;
        this.enable = textView;
        this.enableSwitch = switchButton;
        this.guidelineCenter = guideline;
        this.imageButtonMaskXmaskLeft = imageButton;
        this.imageButtonMaskXmaskRight = imageButton2;
        this.imageButtonMaskYmaskDown = imageButton3;
        this.imageButtonMaskYmaskUP = imageButton4;
        this.mask = textView2;
        this.operate = textView3;
        this.operateButton = imageView;
        this.radioButtonMaskCursor = radioButton;
        this.radioButtonMaskFaile = radioButton2;
        this.radioButtonMaskNegativePulse = radioButton3;
        this.radioButtonMaskPass = radioButton4;
        this.radioButtonMaskPositionPulse = radioButton5;
        this.radioButtonMaskScreen = radioButton6;
        this.radioGroupMaskOutEvent = radioGroup;
        this.radioGroupMaskOutHl = radioGroup2;
        this.radioGroupMaskRange = radioGroup3;
        this.resetButton = button4;
        this.source = textView4;
        this.sourceSpinner = textView5;
        this.switchButtonMaskOut = switchButton2;
        this.textViewMaskErrAction = textView6;
        this.textViewMaskOUt = textView7;
        this.textViewMaskOption = textView8;
        this.textViewMaskOutEvent = textView9;
        this.textViewMaskOutHl = textView10;
        this.textViewMaskOutPulse = textView11;
        this.textViewMaskRange = textView12;
        this.textViewMaskXmask = textView13;
        this.textViewMaskYmask = textView14;
        this.valueMaskOUtPulse = textView15;
        this.valueMaskXmask = textView16;
        this.valueMaskYmask = textView17;
    }

    public MaskParam getParam() {
        return this.mParam;
    }

    public MappingObject getScreenMapping() {
        return this.mScreenMapping;
    }

    public MappingObject getCursorMapping() {
        return this.mCursorMapping;
    }

    public MappingObject getFailMapping() {
        return this.mFailMapping;
    }

    public MappingObject getPassMapping() {
        return this.mPassMapping;
    }

    public MappingObject getPositiveMapping() {
        return this.mPositiveMapping;
    }

    public MappingObject getNegativeMapping() {
        return this.mNegativeMapping;
    }

    public HorizontalParam getHorizontalParam() {
        return this.mHorizontalParam;
    }

    public static PopupviewMaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewMaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewMaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_mask, viewGroup, z, obj);
    }

    public static PopupviewMaskBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewMaskBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewMaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_mask, null, false, obj);
    }

    public static PopupviewMaskBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewMaskBinding bind(View view, Object obj) {
        return (PopupviewMaskBinding) bind(obj, view, R.layout.popupview_mask);
    }
}
