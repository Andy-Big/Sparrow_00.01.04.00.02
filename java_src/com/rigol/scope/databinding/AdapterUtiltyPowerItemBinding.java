package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterUtiltyPowerItemBinding extends ViewDataBinding {
    public final RadioButton autoRadioButton;
    public final ConstraintLayout left;
    public final RadioButton offRadioButton;
    public final TextView pnmText;
    public final RadioGroup rollRadioGroup;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterUtiltyPowerItemBinding(Object obj, View view, int i, RadioButton radioButton, ConstraintLayout constraintLayout, RadioButton radioButton2, TextView textView, RadioGroup radioGroup) {
        super(obj, view, i);
        this.autoRadioButton = radioButton;
        this.left = constraintLayout;
        this.offRadioButton = radioButton2;
        this.pnmText = textView;
        this.rollRadioGroup = radioGroup;
    }

    public static AdapterUtiltyPowerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtiltyPowerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterUtiltyPowerItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utilty_power_item, viewGroup, z, obj);
    }

    public static AdapterUtiltyPowerItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtiltyPowerItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterUtiltyPowerItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utilty_power_item, null, false, obj);
    }

    public static AdapterUtiltyPowerItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtiltyPowerItemBinding bind(View view, Object obj) {
        return (AdapterUtiltyPowerItemBinding) bind(obj, view, R.layout.adapter_utilty_power_item);
    }
}
