package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class PopupviewUtilityBinding extends ViewDataBinding {
    public final RecyclerView utilLeft;
    public final RecyclerView utilRight;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewUtilityBinding(Object obj, View view, int i, RecyclerView recyclerView, RecyclerView recyclerView2) {
        super(obj, view, i);
        this.utilLeft = recyclerView;
        this.utilRight = recyclerView2;
    }

    public static PopupviewUtilityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewUtilityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewUtilityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_utility, viewGroup, z, obj);
    }

    public static PopupviewUtilityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewUtilityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewUtilityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_utility, null, false, obj);
    }

    public static PopupviewUtilityBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewUtilityBinding bind(View view, Object obj) {
        return (PopupviewUtilityBinding) bind(obj, view, R.layout.popupview_utility);
    }
}
