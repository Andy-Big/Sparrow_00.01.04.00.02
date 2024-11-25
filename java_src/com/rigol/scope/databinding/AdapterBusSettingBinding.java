package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterBusSettingBinding extends ViewDataBinding {
    public final ConstraintLayout constraintLayout8;
    public final ImageView imageView4;
    public final ConstraintLayout layoutSettingType;
    public final RecyclerView recyclerContent;
    public final TextView settingType;
    public final TextView textView23;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterBusSettingBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.constraintLayout8 = constraintLayout;
        this.imageView4 = imageView;
        this.layoutSettingType = constraintLayout2;
        this.recyclerContent = recyclerView;
        this.settingType = textView;
        this.textView23 = textView2;
    }

    public static AdapterBusSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterBusSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bus_setting, viewGroup, z, obj);
    }

    public static AdapterBusSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusSettingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterBusSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_bus_setting, null, false, obj);
    }

    public static AdapterBusSettingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterBusSettingBinding bind(View view, Object obj) {
        return (AdapterBusSettingBinding) bind(obj, view, R.layout.adapter_bus_setting);
    }
}
