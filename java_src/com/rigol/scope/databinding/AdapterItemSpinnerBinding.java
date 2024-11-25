package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterItemSpinnerBinding extends ViewDataBinding {
    public final TextView title;
    public final ConstraintLayout titleLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemSpinnerBinding(Object obj, View view, int i, TextView textView, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.title = textView;
        this.titleLayout = constraintLayout;
    }

    public static AdapterItemSpinnerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSpinnerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemSpinnerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_spinner, viewGroup, z, obj);
    }

    public static AdapterItemSpinnerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSpinnerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemSpinnerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_spinner, null, false, obj);
    }

    public static AdapterItemSpinnerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSpinnerBinding bind(View view, Object obj) {
        return (AdapterItemSpinnerBinding) bind(obj, view, R.layout.adapter_item_spinner);
    }
}
