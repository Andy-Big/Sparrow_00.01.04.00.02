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
import com.rigol.scope.data.JitterParam;
/* loaded from: classes2.dex */
public abstract class AdapterJitterExplicitBinding extends ViewDataBinding {
    public final ConstraintLayout jitterExplicitLayout;
    public final TextView jitterExternalClockSourceLabel;
    public final TextView jitterExternalClockSourceValue;
    @Bindable
    protected JitterParam mParam;

    public abstract void setParam(JitterParam jitterParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterJitterExplicitBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.jitterExplicitLayout = constraintLayout;
        this.jitterExternalClockSourceLabel = textView;
        this.jitterExternalClockSourceValue = textView2;
    }

    public JitterParam getParam() {
        return this.mParam;
    }

    public static AdapterJitterExplicitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterJitterExplicitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterJitterExplicitBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_jitter_explicit, viewGroup, z, obj);
    }

    public static AdapterJitterExplicitBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterJitterExplicitBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterJitterExplicitBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_jitter_explicit, null, false, obj);
    }

    public static AdapterJitterExplicitBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterJitterExplicitBinding bind(View view, Object obj) {
        return (AdapterJitterExplicitBinding) bind(obj, view, R.layout.adapter_jitter_explicit);
    }
}
