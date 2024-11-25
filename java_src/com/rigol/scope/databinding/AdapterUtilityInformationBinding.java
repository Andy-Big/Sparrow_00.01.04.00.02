package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterUtilityInformationBinding extends ViewDataBinding {
    public final TextView informationContent;
    public final TextView informationTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterUtilityInformationBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.informationContent = textView;
        this.informationTitle = textView2;
    }

    public static AdapterUtilityInformationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityInformationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterUtilityInformationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_information, viewGroup, z, obj);
    }

    public static AdapterUtilityInformationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityInformationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterUtilityInformationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_information, null, false, obj);
    }

    public static AdapterUtilityInformationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityInformationBinding bind(View view, Object obj) {
        return (AdapterUtilityInformationBinding) bind(obj, view, R.layout.adapter_utility_information);
    }
}
