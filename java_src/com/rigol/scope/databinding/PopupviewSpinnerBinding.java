package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;

/* loaded from: classes2.dex */
public abstract class PopupviewSpinnerBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;

    protected PopupviewSpinnerBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.recyclerView = recyclerView;
    }

    public static PopupviewSpinnerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewSpinnerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewSpinnerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_spinner, viewGroup, z, obj);
    }

    public static PopupviewSpinnerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewSpinnerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewSpinnerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_spinner, null, false, obj);
    }

    public static PopupviewSpinnerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewSpinnerBinding bind(View view, Object obj) {
        return (PopupviewSpinnerBinding) bind(obj, view, R.layout.popupview_spinner);
    }
}
