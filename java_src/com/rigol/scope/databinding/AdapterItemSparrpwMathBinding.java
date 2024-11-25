package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MathParam;
/* loaded from: classes2.dex */
public abstract class AdapterItemSparrpwMathBinding extends ViewDataBinding {
    public final ConstraintLayout itemView;
    @Bindable
    protected MathParam mParam;
    public final TextView text1;

    public abstract void setParam(MathParam mathParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemSparrpwMathBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView) {
        super(obj, view, i);
        this.itemView = constraintLayout;
        this.text1 = textView;
    }

    public MathParam getParam() {
        return this.mParam;
    }

    public static AdapterItemSparrpwMathBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSparrpwMathBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemSparrpwMathBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_sparrpw_math, viewGroup, z, obj);
    }

    public static AdapterItemSparrpwMathBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSparrpwMathBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemSparrpwMathBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_sparrpw_math, null, false, obj);
    }

    public static AdapterItemSparrpwMathBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSparrpwMathBinding bind(View view, Object obj) {
        return (AdapterItemSparrpwMathBinding) bind(obj, view, R.layout.adapter_item_sparrpw_math);
    }
}
