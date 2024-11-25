package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class UpaPopupviewConnectionBinding extends ViewDataBinding {
    public final View titleLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public UpaPopupviewConnectionBinding(Object obj, View view, int i, View view2) {
        super(obj, view, i);
        this.titleLayout = view2;
    }

    public static UpaPopupviewConnectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UpaPopupviewConnectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UpaPopupviewConnectionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.upa_popupview_connection, viewGroup, z, obj);
    }

    public static UpaPopupviewConnectionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UpaPopupviewConnectionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UpaPopupviewConnectionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.upa_popupview_connection, null, false, obj);
    }

    public static UpaPopupviewConnectionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UpaPopupviewConnectionBinding bind(View view, Object obj) {
        return (UpaPopupviewConnectionBinding) bind(obj, view, R.layout.upa_popupview_connection);
    }
}
