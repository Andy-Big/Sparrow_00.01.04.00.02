package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterTypeTextGroupBinding extends ViewDataBinding {
    public final TextView text1;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTypeTextGroupBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.text1 = textView;
    }

    public static AdapterTypeTextGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTypeTextGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTypeTextGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_type_text_group, viewGroup, z, obj);
    }

    public static AdapterTypeTextGroupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTypeTextGroupBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTypeTextGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_type_text_group, null, false, obj);
    }

    public static AdapterTypeTextGroupBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTypeTextGroupBinding bind(View view, Object obj) {
        return (AdapterTypeTextGroupBinding) bind(obj, view, R.layout.adapter_type_text_group);
    }
}
