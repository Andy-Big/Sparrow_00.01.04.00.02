package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class PopupviewAutosetBinding extends ViewDataBinding {
    public final RecyclerView list;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewAutosetBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.list = recyclerView;
    }

    public static PopupviewAutosetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAutosetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewAutosetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_autoset, viewGroup, z, obj);
    }

    public static PopupviewAutosetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAutosetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewAutosetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_autoset, null, false, obj);
    }

    public static PopupviewAutosetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAutosetBinding bind(View view, Object obj) {
        return (PopupviewAutosetBinding) bind(obj, view, R.layout.popupview_autoset);
    }
}
