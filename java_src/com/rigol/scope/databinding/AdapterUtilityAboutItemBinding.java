package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterUtilityAboutItemBinding extends ViewDataBinding {
    public final ConstraintLayout left;
    public final RecyclerView recyclerDeviceInformation;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterUtilityAboutItemBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, RecyclerView recyclerView) {
        super(obj, view, i);
        this.left = constraintLayout;
        this.recyclerDeviceInformation = recyclerView;
    }

    public static AdapterUtilityAboutItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityAboutItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterUtilityAboutItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_about_item, viewGroup, z, obj);
    }

    public static AdapterUtilityAboutItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityAboutItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterUtilityAboutItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_about_item, null, false, obj);
    }

    public static AdapterUtilityAboutItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityAboutItemBinding bind(View view, Object obj) {
        return (AdapterUtilityAboutItemBinding) bind(obj, view, R.layout.adapter_utility_about_item);
    }
}
