package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterUtilitySelfcheckBinding extends ViewDataBinding {
    public final ImageView imageView11;
    public final ImageView imageView12;
    public final ImageView imageView13;
    public final ImageView imageView6;
    public final ConstraintLayout keycheckLayout;
    public final ConstraintLayout screenLayout;
    public final ConstraintLayout selfTest;
    public final ConstraintLayout touchLayout;
    public final TextView tvKeyboardCheck;
    public final TextView tvScreenTest;
    public final TextView tvSelfTest;
    public final TextView tvTouchTest;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterUtilitySelfcheckBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.imageView11 = imageView;
        this.imageView12 = imageView2;
        this.imageView13 = imageView3;
        this.imageView6 = imageView4;
        this.keycheckLayout = constraintLayout;
        this.screenLayout = constraintLayout2;
        this.selfTest = constraintLayout3;
        this.touchLayout = constraintLayout4;
        this.tvKeyboardCheck = textView;
        this.tvScreenTest = textView2;
        this.tvSelfTest = textView3;
        this.tvTouchTest = textView4;
    }

    public static AdapterUtilitySelfcheckBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilitySelfcheckBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterUtilitySelfcheckBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_selfcheck, viewGroup, z, obj);
    }

    public static AdapterUtilitySelfcheckBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilitySelfcheckBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterUtilitySelfcheckBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_selfcheck, null, false, obj);
    }

    public static AdapterUtilitySelfcheckBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilitySelfcheckBinding bind(View view, Object obj) {
        return (AdapterUtilitySelfcheckBinding) bind(obj, view, R.layout.adapter_utility_selfcheck);
    }
}
