package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class AdapterUtilityLansettingItemTestBinding extends ViewDataBinding {
    public final Button configuration;
    public final ConstraintLayout constraintLayout25;
    public final ConstraintLayout constraintLayout4;
    public final TextView dnsLayout;
    public final EditText edtHostNameValue;
    public final EditText edtdefaultGateway;
    public final EditText edtdns;
    public final EditText edtipAddress;
    public final EditText edtsubMask;
    public final ConstraintLayout gatewayLayout;
    public final ConstraintLayout gpiblayout;
    public final ConstraintLayout hostNamelayout;
    public final CheckBox ipAuto;
    public final CheckBox ipDhcp;
    public final ConstraintLayout ipLayout;
    public final CheckBox ipStatic;
    public final ConstraintLayout ipconfigLayout;
    public final ConstraintLayout mDnslayout;
    public final ConstraintLayout macLayout;
    public final TextView mdns;
    public final ConstraintLayout submaskLayout;
    public final SwitchButton switchMdns;
    public final TextView textView38;
    public final TextView textView40;
    public final TextView textView43;
    public final TextView textView47;
    public final TextView textView49;
    public final TextView textView51;
    public final TextView textView53;
    public final TextView textView54;
    public final EditText tvgpib;
    public final TextView tvmacAddress;
    public final TextView tvnetState;
    public final TextView tvvisaAddress;
    public final View view;
    public final View view2;
    public final View view5;
    public final ConstraintLayout visaLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterUtilityLansettingItemTestBinding(Object obj, View view, int i, Button button, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, CheckBox checkBox, CheckBox checkBox2, ConstraintLayout constraintLayout6, CheckBox checkBox3, ConstraintLayout constraintLayout7, ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, TextView textView2, ConstraintLayout constraintLayout10, SwitchButton switchButton, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, EditText editText6, TextView textView11, TextView textView12, TextView textView13, View view2, View view3, View view4, ConstraintLayout constraintLayout11) {
        super(obj, view, i);
        this.configuration = button;
        this.constraintLayout25 = constraintLayout;
        this.constraintLayout4 = constraintLayout2;
        this.dnsLayout = textView;
        this.edtHostNameValue = editText;
        this.edtdefaultGateway = editText2;
        this.edtdns = editText3;
        this.edtipAddress = editText4;
        this.edtsubMask = editText5;
        this.gatewayLayout = constraintLayout3;
        this.gpiblayout = constraintLayout4;
        this.hostNamelayout = constraintLayout5;
        this.ipAuto = checkBox;
        this.ipDhcp = checkBox2;
        this.ipLayout = constraintLayout6;
        this.ipStatic = checkBox3;
        this.ipconfigLayout = constraintLayout7;
        this.mDnslayout = constraintLayout8;
        this.macLayout = constraintLayout9;
        this.mdns = textView2;
        this.submaskLayout = constraintLayout10;
        this.switchMdns = switchButton;
        this.textView38 = textView3;
        this.textView40 = textView4;
        this.textView43 = textView5;
        this.textView47 = textView6;
        this.textView49 = textView7;
        this.textView51 = textView8;
        this.textView53 = textView9;
        this.textView54 = textView10;
        this.tvgpib = editText6;
        this.tvmacAddress = textView11;
        this.tvnetState = textView12;
        this.tvvisaAddress = textView13;
        this.view = view2;
        this.view2 = view3;
        this.view5 = view4;
        this.visaLayout = constraintLayout11;
    }

    public static AdapterUtilityLansettingItemTestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityLansettingItemTestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterUtilityLansettingItemTestBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_lansetting_item_test, viewGroup, z, obj);
    }

    public static AdapterUtilityLansettingItemTestBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityLansettingItemTestBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterUtilityLansettingItemTestBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_lansetting_item_test, null, false, obj);
    }

    public static AdapterUtilityLansettingItemTestBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityLansettingItemTestBinding bind(View view, Object obj) {
        return (AdapterUtilityLansettingItemTestBinding) bind(obj, view, R.layout.adapter_utility_lansetting_item_test);
    }
}
