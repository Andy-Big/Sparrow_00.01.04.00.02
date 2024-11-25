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
public abstract class AdapterItemSpinnerDiskBinding extends ViewDataBinding {
    public final TextView title;
    public final ConstraintLayout titleLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemSpinnerDiskBinding(Object obj, View view, int i, TextView textView, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.title = textView;
        this.titleLayout = constraintLayout;
    }

    public static AdapterItemSpinnerDiskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSpinnerDiskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemSpinnerDiskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_spinner_disk, viewGroup, z, obj);
    }

    public static AdapterItemSpinnerDiskBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSpinnerDiskBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemSpinnerDiskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_spinner_disk, null, false, obj);
    }

    public static AdapterItemSpinnerDiskBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSpinnerDiskBinding bind(View view, Object obj) {
        return (AdapterItemSpinnerDiskBinding) bind(obj, view, R.layout.adapter_item_spinner_disk);
    }
}
