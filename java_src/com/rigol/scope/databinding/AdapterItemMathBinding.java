package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MathParam;
/* loaded from: classes2.dex */
public abstract class AdapterItemMathBinding extends ViewDataBinding {
    @Bindable
    protected Integer mItemPosition;
    @Bindable
    protected MathParam mParam;
    public final TextView operator;
    public final TextView position;
    public final TextView scale;
    public final TextView title;

    public abstract void setItemPosition(Integer num);

    public abstract void setParam(MathParam mathParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemMathBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.operator = textView;
        this.position = textView2;
        this.scale = textView3;
        this.title = textView4;
    }

    public MathParam getParam() {
        return this.mParam;
    }

    public Integer getItemPosition() {
        return this.mItemPosition;
    }

    public static AdapterItemMathBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemMathBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemMathBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_math, viewGroup, z, obj);
    }

    public static AdapterItemMathBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemMathBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemMathBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_math, null, false, obj);
    }

    public static AdapterItemMathBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemMathBinding bind(View view, Object obj) {
        return (AdapterItemMathBinding) bind(obj, view, R.layout.adapter_item_math);
    }
}
