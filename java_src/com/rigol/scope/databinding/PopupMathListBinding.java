package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class PopupMathListBinding extends ViewDataBinding {
    public final RecyclerView otherLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupMathListBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.otherLayout = recyclerView;
    }

    public static PopupMathListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupMathListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupMathListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popup_math_list, viewGroup, z, obj);
    }

    public static PopupMathListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupMathListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupMathListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popup_math_list, null, false, obj);
    }

    public static PopupMathListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupMathListBinding bind(View view, Object obj) {
        return (PopupMathListBinding) bind(obj, view, R.layout.popup_math_list);
    }
}
