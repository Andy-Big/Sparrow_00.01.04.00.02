package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class AbapterLaSeniorBinding extends ViewDataBinding {
    public final AppCompatCheckBox d0;
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
    public final AppCompatCheckBox d9;
    public final Button laGroupCancel;
    public final TextView laLabelEdit;
    public final TextView laLabelShow;
    public final TextView laLabelText;
    public final TextView laSource;
    public final TextView laSourceCentre;
    public final TextView laSourceGroup;
    public final TextView laSourceGroupText;
    public final TextView laSourceGroupText1;
    public final TextView laSourceGroupText2;
    public final TextView laSourceGroupText3;
    public final TextView laSourceHigh;
    public final TextView laSourceLow;
    public final TextView laSourceOnOff;
    public final TextView laSourceSpinner;
    public final TextView laWaveColor;
    @Bindable
    protected LaParam mParma;
    public final SwitchButton showLabelSwitch;
    public final SwitchButton triggerNoiseSwitch;

    public abstract void setParma(LaParam laParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AbapterLaSeniorBinding(Object obj, View view, int i, AppCompatCheckBox appCompatCheckBox, AppCompatCheckBox appCompatCheckBox2, AppCompatCheckBox appCompatCheckBox3, AppCompatCheckBox appCompatCheckBox4, AppCompatCheckBox appCompatCheckBox5, AppCompatCheckBox appCompatCheckBox6, AppCompatCheckBox appCompatCheckBox7, AppCompatCheckBox appCompatCheckBox8, AppCompatCheckBox appCompatCheckBox9, AppCompatCheckBox appCompatCheckBox10, AppCompatCheckBox appCompatCheckBox11, AppCompatCheckBox appCompatCheckBox12, AppCompatCheckBox appCompatCheckBox13, AppCompatCheckBox appCompatCheckBox14, AppCompatCheckBox appCompatCheckBox15, AppCompatCheckBox appCompatCheckBox16, Button button, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, SwitchButton switchButton, SwitchButton switchButton2) {
        super(obj, view, i);
        this.d0 = appCompatCheckBox;
        this.d1 = appCompatCheckBox2;
        this.d10 = appCompatCheckBox3;
        this.d11 = appCompatCheckBox4;
        this.d12 = appCompatCheckBox5;
        this.d13 = appCompatCheckBox6;
        this.d14 = appCompatCheckBox7;
        this.d15 = appCompatCheckBox8;
        this.d2 = appCompatCheckBox9;
        this.d3 = appCompatCheckBox10;
        this.d4 = appCompatCheckBox11;
        this.d5 = appCompatCheckBox12;
        this.d6 = appCompatCheckBox13;
        this.d7 = appCompatCheckBox14;
        this.d8 = appCompatCheckBox15;
        this.d9 = appCompatCheckBox16;
        this.laGroupCancel = button;
        this.laLabelEdit = textView;
        this.laLabelShow = textView2;
        this.laLabelText = textView3;
        this.laSource = textView4;
        this.laSourceCentre = textView5;
        this.laSourceGroup = textView6;
        this.laSourceGroupText = textView7;
        this.laSourceGroupText1 = textView8;
        this.laSourceGroupText2 = textView9;
        this.laSourceGroupText3 = textView10;
        this.laSourceHigh = textView11;
        this.laSourceLow = textView12;
        this.laSourceOnOff = textView13;
        this.laSourceSpinner = textView14;
        this.laWaveColor = textView15;
        this.showLabelSwitch = switchButton;
        this.triggerNoiseSwitch = switchButton2;
    }

    public LaParam getParma() {
        return this.mParma;
    }

    public static AbapterLaSeniorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AbapterLaSeniorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AbapterLaSeniorBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.abapter_la_senior, viewGroup, z, obj);
    }

    public static AbapterLaSeniorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AbapterLaSeniorBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AbapterLaSeniorBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.abapter_la_senior, null, false, obj);
    }

    public static AbapterLaSeniorBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AbapterLaSeniorBinding bind(View view, Object obj) {
        return (AbapterLaSeniorBinding) bind(obj, view, R.layout.abapter_la_senior);
    }
}
