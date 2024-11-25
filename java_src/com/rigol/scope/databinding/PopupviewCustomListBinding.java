package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class PopupviewCustomListBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewCustomListBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.recyclerView = recyclerView;
    }

    public static PopupviewCustomListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewCustomListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewCustomListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_custom_list, viewGroup, z, obj);
    }

    public static PopupviewCustomListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewCustomListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewCustomListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_custom_list, null, false, obj);
    }

    public static PopupviewCustomListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewCustomListBinding bind(View view, Object obj) {
        return (PopupviewCustomListBinding) bind(obj, view, R.layout.popupview_custom_list);
    }
}
