package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
/* loaded from: classes2.dex */
public abstract class FormatTransformKeyBinding extends ViewDataBinding {
    public final EditText binaryValue;
    public final RadioButton formatBin;
    public final RadioButton formatHex;
    public final Button keyA;
    public final Button keyAll;
    public final Button keyB;
    public final Button keyC;
    public final Button keyClear;
    public final Button keyD;
    public final ImageButton keyDelete;
    public final Button keyE;
    public final Button keyEigth;
    public final Button keyF;
    public final Button keyFive;
    public final Button keyFour;
    public final ImageButton keyLeft;
    public final Button keyNine;
    public final Button keyOk;
    public final Button keyOne;
    public final ImageButton keyRight;
    public final Button keySeven;
    public final Button keySix;
    public final Button keyThree;
    public final Button keyTwo;
    public final Button keyX;
    public final Button keyZero;
    @Bindable
    protected MappingObject mBinMapping;
    @Bindable
    protected MappingObject mHexMapping;
    @Bindable
    protected TriggerParam mParam;
    public final ConstraintLayout triggerLayout;
    public final TextView triggerTypeLabel;
    public final TextView typeBinary;
    public final TextView typeFormat;
    public final EditText typeFormatValue;

    public abstract void setBinMapping(MappingObject mappingObject);

    public abstract void setHexMapping(MappingObject mappingObject);

    public abstract void setParam(TriggerParam triggerParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public FormatTransformKeyBinding(Object obj, View view, int i, EditText editText, RadioButton radioButton, RadioButton radioButton2, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, ImageButton imageButton, Button button7, Button button8, Button button9, Button button10, Button button11, ImageButton imageButton2, Button button12, Button button13, Button button14, ImageButton imageButton3, Button button15, Button button16, Button button17, Button button18, Button button19, Button button20, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, EditText editText2) {
        super(obj, view, i);
        this.binaryValue = editText;
        this.formatBin = radioButton;
        this.formatHex = radioButton2;
        this.keyA = button;
        this.keyAll = button2;
        this.keyB = button3;
        this.keyC = button4;
        this.keyClear = button5;
        this.keyD = button6;
        this.keyDelete = imageButton;
        this.keyE = button7;
        this.keyEigth = button8;
        this.keyF = button9;
        this.keyFive = button10;
        this.keyFour = button11;
        this.keyLeft = imageButton2;
        this.keyNine = button12;
        this.keyOk = button13;
        this.keyOne = button14;
        this.keyRight = imageButton3;
        this.keySeven = button15;
        this.keySix = button16;
        this.keyThree = button17;
        this.keyTwo = button18;
        this.keyX = button19;
        this.keyZero = button20;
        this.triggerLayout = constraintLayout;
        this.triggerTypeLabel = textView;
        this.typeBinary = textView2;
        this.typeFormat = textView3;
        this.typeFormatValue = editText2;
    }

    public TriggerParam getParam() {
        return this.mParam;
    }

    public MappingObject getBinMapping() {
        return this.mBinMapping;
    }

    public MappingObject getHexMapping() {
        return this.mHexMapping;
    }

    public static FormatTransformKeyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FormatTransformKeyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FormatTransformKeyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.format_transform_key, viewGroup, z, obj);
    }

    public static FormatTransformKeyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FormatTransformKeyBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FormatTransformKeyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.format_transform_key, null, false, obj);
    }

    public static FormatTransformKeyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FormatTransformKeyBinding bind(View view, Object obj) {
        return (FormatTransformKeyBinding) bind(obj, view, R.layout.format_transform_key);
    }
}
