package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class AdapterUtilityQuickScreenshotBinding extends ViewDataBinding {
    public final ConstraintLayout colorLayout;
    public final ConstraintLayout inverseLayout;
    @Bindable
    protected StorageSaveParam mParam;
    public final RadioButton radioButtonBmp;
    public final RadioButton radioButtonJpg;
    public final RadioButton radioButtonPng;
    public final RadioGroup radiogroupImageType;
    public final SwitchButton switchButtonImagecolor;
    public final SwitchButton switchButtonInvert;
    public final TextView tvImagetype;
    public final TextView tvImgecolor;
    public final TextView tvInvert;

    public abstract void setParam(StorageSaveParam storageSaveParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterUtilityQuickScreenshotBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioGroup radioGroup, SwitchButton switchButton, SwitchButton switchButton2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.colorLayout = constraintLayout;
        this.inverseLayout = constraintLayout2;
        this.radioButtonBmp = radioButton;
        this.radioButtonJpg = radioButton2;
        this.radioButtonPng = radioButton3;
        this.radiogroupImageType = radioGroup;
        this.switchButtonImagecolor = switchButton;
        this.switchButtonInvert = switchButton2;
        this.tvImagetype = textView;
        this.tvImgecolor = textView2;
        this.tvInvert = textView3;
    }

    public StorageSaveParam getParam() {
        return this.mParam;
    }

    public static AdapterUtilityQuickScreenshotBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityQuickScreenshotBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterUtilityQuickScreenshotBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_quick_screenshot, viewGroup, z, obj);
    }

    public static AdapterUtilityQuickScreenshotBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityQuickScreenshotBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterUtilityQuickScreenshotBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_quick_screenshot, null, false, obj);
    }

    public static AdapterUtilityQuickScreenshotBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityQuickScreenshotBinding bind(View view, Object obj) {
        return (AdapterUtilityQuickScreenshotBinding) bind(obj, view, R.layout.adapter_utility_quick_screenshot);
    }
}
