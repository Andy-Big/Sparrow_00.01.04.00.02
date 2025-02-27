package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;

/* loaded from: classes2.dex */
public abstract class PopupviewStartMenuBinding extends ViewDataBinding {
    public final RecyclerView list;

    protected PopupviewStartMenuBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.list = recyclerView;
    }

    public static PopupviewStartMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewStartMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewStartMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_start_menu, viewGroup, z, obj);
    }

    public static PopupviewStartMenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewStartMenuBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewStartMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_start_menu, null, false, obj);
    }

    public static PopupviewStartMenuBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewStartMenuBinding bind(View view, Object obj) {
        return (PopupviewStartMenuBinding) bind(obj, view, R.layout.popupview_start_menu);
    }
}
