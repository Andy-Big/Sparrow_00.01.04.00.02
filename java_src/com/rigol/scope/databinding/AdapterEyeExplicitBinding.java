package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.EyeParam;
/* loaded from: classes2.dex */
public abstract class AdapterEyeExplicitBinding extends ViewDataBinding {
    public final ConstraintLayout eyeExplicitLayout;
    public final TextView eyeExternalClockSourceLabel;
    public final TextView eyeExternalClockSourceValue;
    @Bindable
    protected View.OnClickListener mOnClickListener;
    @Bindable
    protected EyeParam mParam;
    public final Guideline rightGuideline;

    public abstract void setOnClickListener(View.OnClickListener onClickListener);

    public abstract void setParam(EyeParam eyeParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterEyeExplicitBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, TextView textView2, Guideline guideline) {
        super(obj, view, i);
        this.eyeExplicitLayout = constraintLayout;
        this.eyeExternalClockSourceLabel = textView;
        this.eyeExternalClockSourceValue = textView2;
        this.rightGuideline = guideline;
    }

    public EyeParam getParam() {
        return this.mParam;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public static AdapterEyeExplicitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterEyeExplicitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterEyeExplicitBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_eye_explicit, viewGroup, z, obj);
    }

    public static AdapterEyeExplicitBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterEyeExplicitBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterEyeExplicitBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_eye_explicit, null, false, obj);
    }

    public static AdapterEyeExplicitBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterEyeExplicitBinding bind(View view, Object obj) {
        return (AdapterEyeExplicitBinding) bind(obj, view, R.layout.adapter_eye_explicit);
    }
}
