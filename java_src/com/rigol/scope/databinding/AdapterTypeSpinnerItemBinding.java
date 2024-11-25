package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterTypeSpinnerItemBinding extends ViewDataBinding {
    public final ImageView arrow;
    public final TextView text1;
    public final TextView text2;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterTypeSpinnerItemBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.arrow = imageView;
        this.text1 = textView;
        this.text2 = textView2;
    }

    public static AdapterTypeSpinnerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTypeSpinnerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterTypeSpinnerItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_type_spinner_item, viewGroup, z, obj);
    }

    public static AdapterTypeSpinnerItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTypeSpinnerItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterTypeSpinnerItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_type_spinner_item, null, false, obj);
    }

    public static AdapterTypeSpinnerItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterTypeSpinnerItemBinding bind(View view, Object obj) {
        return (AdapterTypeSpinnerItemBinding) bind(obj, view, R.layout.adapter_type_spinner_item);
    }
}
