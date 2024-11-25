package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.FftParam;
/* loaded from: classes2.dex */
public abstract class AdapterItemRtsaBinding extends ViewDataBinding {
    public final TextView center;
    @Bindable
    protected FftParam mParam;
    public final TextView span;
    public final TextView title;

    public abstract void setParam(FftParam fftParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemRtsaBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.center = textView;
        this.span = textView2;
        this.title = textView3;
    }

    public FftParam getParam() {
        return this.mParam;
    }

    public static AdapterItemRtsaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemRtsaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemRtsaBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_rtsa, viewGroup, z, obj);
    }

    public static AdapterItemRtsaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemRtsaBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemRtsaBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_rtsa, null, false, obj);
    }

    public static AdapterItemRtsaBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemRtsaBinding bind(View view, Object obj) {
        return (AdapterItemRtsaBinding) bind(obj, view, R.layout.adapter_item_rtsa);
    }
}
