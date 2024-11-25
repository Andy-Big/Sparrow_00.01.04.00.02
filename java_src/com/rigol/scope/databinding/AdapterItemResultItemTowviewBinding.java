package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterItemResultItemTowviewBinding extends ViewDataBinding {
    public final AppCompatTextView itemData;
    public final AppCompatTextView itemTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemResultItemTowviewBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.itemData = appCompatTextView;
        this.itemTitle = appCompatTextView2;
    }

    public static AdapterItemResultItemTowviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultItemTowviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemResultItemTowviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_item_towview, viewGroup, z, obj);
    }

    public static AdapterItemResultItemTowviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultItemTowviewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemResultItemTowviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_item_towview, null, false, obj);
    }

    public static AdapterItemResultItemTowviewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultItemTowviewBinding bind(View view, Object obj) {
        return (AdapterItemResultItemTowviewBinding) bind(obj, view, R.layout.adapter_item_result_item_towview);
    }
}
