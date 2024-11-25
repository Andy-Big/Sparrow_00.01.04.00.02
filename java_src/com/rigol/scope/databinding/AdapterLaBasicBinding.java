package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.LaParam;
/* loaded from: classes2.dex */
public abstract class AdapterLaBasicBinding extends ViewDataBinding {
    public final AppCompatCheckBox d0;
    public final AppCompatCheckBox d0tod7;
    public final AppCompatCheckBox d1;
    public final AppCompatCheckBox d10;
    public final AppCompatCheckBox d11;
    public final AppCompatCheckBox d12;
    public final AppCompatCheckBox d13;
    public final AppCompatCheckBox d14;
    public final AppCompatCheckBox d15;
    public final AppCompatCheckBox d2;
    public final AppCompatCheckBox d3;
    public final AppCompatCheckBox d4;
    public final AppCompatCheckBox d5;
    public final AppCompatCheckBox d6;
    public final AppCompatCheckBox d7;
    public final AppCompatCheckBox d8;
    public final AppCompatCheckBox d8tod15;
    public final AppCompatCheckBox d9;
    public final EditText laBasic;
    public final EditText laBasicTwo;
    public final TextView laOrder;
    public final TextView laPeak;
    public final TextView laPeakSpinner;
    public final TextView laWaveSize;
    public final TextView laWaveSpinner;
    @Bindable
    protected CompoundButton.OnCheckedChangeListener mCheckedChangeListener;
    @Bindable
    protected LaParam mParma;

    public abstract void setCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener);

    public abstract void setParma(LaParam laParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterLaBasicBinding(Object obj, View view, int i, AppCompatCheckBox appCompatCheckBox, AppCompatCheckBox appCompatCheckBox2, AppCompatCheckBox appCompatCheckBox3, AppCompatCheckBox appCompatCheckBox4, AppCompatCheckBox appCompatCheckBox5, AppCompatCheckBox appCompatCheckBox6, AppCompatCheckBox appCompatCheckBox7, AppCompatCheckBox appCompatCheckBox8, AppCompatCheckBox appCompatCheckBox9, AppCompatCheckBox appCompatCheckBox10, AppCompatCheckBox appCompatCheckBox11, AppCompatCheckBox appCompatCheckBox12, AppCompatCheckBox appCompatCheckBox13, AppCompatCheckBox appCompatCheckBox14, AppCompatCheckBox appCompatCheckBox15, AppCompatCheckBox appCompatCheckBox16, AppCompatCheckBox appCompatCheckBox17, AppCompatCheckBox appCompatCheckBox18, EditText editText, EditText editText2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.d0 = appCompatCheckBox;
        this.d0tod7 = appCompatCheckBox2;
        this.d1 = appCompatCheckBox3;
        this.d10 = appCompatCheckBox4;
        this.d11 = appCompatCheckBox5;
        this.d12 = appCompatCheckBox6;
        this.d13 = appCompatCheckBox7;
        this.d14 = appCompatCheckBox8;
        this.d15 = appCompatCheckBox9;
        this.d2 = appCompatCheckBox10;
        this.d3 = appCompatCheckBox11;
        this.d4 = appCompatCheckBox12;
        this.d5 = appCompatCheckBox13;
        this.d6 = appCompatCheckBox14;
        this.d7 = appCompatCheckBox15;
        this.d8 = appCompatCheckBox16;
        this.d8tod15 = appCompatCheckBox17;
        this.d9 = appCompatCheckBox18;
        this.laBasic = editText;
        this.laBasicTwo = editText2;
        this.laOrder = textView;
        this.laPeak = textView2;
        this.laPeakSpinner = textView3;
        this.laWaveSize = textView4;
        this.laWaveSpinner = textView5;
    }

    public CompoundButton.OnCheckedChangeListener getCheckedChangeListener() {
        return this.mCheckedChangeListener;
    }

    public LaParam getParma() {
        return this.mParma;
    }

    public static AdapterLaBasicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterLaBasicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterLaBasicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_la_basic, viewGroup, z, obj);
    }

    public static AdapterLaBasicBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterLaBasicBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterLaBasicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_la_basic, null, false, obj);
    }

    public static AdapterLaBasicBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterLaBasicBinding bind(View view, Object obj) {
        return (AdapterLaBasicBinding) bind(obj, view, R.layout.adapter_la_basic);
    }
}
