package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.KeyboardParam;
/* loaded from: classes2.dex */
public abstract class PopupviewKeyboardBinding extends ViewDataBinding {
    public final Button btnCls;
    public final Button btnDecimalPoint;
    public final Button btnDef;
    public final ImageButton btnDelete;
    public final Button btnEight;
    public final Button btnExp;
    public final Button btnFive;
    public final Button btnFour;
    public final Button btnMax;
    public final Button btnMin;
    public final Button btnNine;
    public final Button btnOk;
    public final Button btnOne;
    public final Button btnPositiveOrNegative;
    public final Button btnSeven;
    public final Button btnSix;
    public final Button btnThree;
    public final Button btnTwo;
    public final Button btnUnit1;
    public final Button btnUnit2;
    public final Button btnUnit3;
    public final Button btnUnit4;
    public final Button btnUnit5;
    public final Button btnZero;
    public final EditText edtValue;
    public final ImageView ivKey1;
    public final ImageView ivKey2;
    @Bindable
    protected KeyboardParam mParam;

    public abstract void setParam(KeyboardParam keyboardParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewKeyboardBinding(Object obj, View view, int i, Button button, Button button2, Button button3, ImageButton imageButton, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10, Button button11, Button button12, Button button13, Button button14, Button button15, Button button16, Button button17, Button button18, Button button19, Button button20, Button button21, Button button22, Button button23, EditText editText, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.btnCls = button;
        this.btnDecimalPoint = button2;
        this.btnDef = button3;
        this.btnDelete = imageButton;
        this.btnEight = button4;
        this.btnExp = button5;
        this.btnFive = button6;
        this.btnFour = button7;
        this.btnMax = button8;
        this.btnMin = button9;
        this.btnNine = button10;
        this.btnOk = button11;
        this.btnOne = button12;
        this.btnPositiveOrNegative = button13;
        this.btnSeven = button14;
        this.btnSix = button15;
        this.btnThree = button16;
        this.btnTwo = button17;
        this.btnUnit1 = button18;
        this.btnUnit2 = button19;
        this.btnUnit3 = button20;
        this.btnUnit4 = button21;
        this.btnUnit5 = button22;
        this.btnZero = button23;
        this.edtValue = editText;
        this.ivKey1 = imageView;
        this.ivKey2 = imageView2;
    }

    public KeyboardParam getParam() {
        return this.mParam;
    }

    public static PopupviewKeyboardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewKeyboardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewKeyboardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_keyboard, viewGroup, z, obj);
    }

    public static PopupviewKeyboardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewKeyboardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewKeyboardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_keyboard, null, false, obj);
    }

    public static PopupviewKeyboardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewKeyboardBinding bind(View view, Object obj) {
        return (PopupviewKeyboardBinding) bind(obj, view, R.layout.popupview_keyboard);
    }
}
