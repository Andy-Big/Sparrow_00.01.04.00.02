package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class UpaPoppviewRipperBinding extends ViewDataBinding {
    public final View titleLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public UpaPoppviewRipperBinding(Object obj, View view, int i, View view2) {
        super(obj, view, i);
        this.titleLayout = view2;
    }

    public static UpaPoppviewRipperBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UpaPoppviewRipperBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UpaPoppviewRipperBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.upa_poppview_ripper, viewGroup, z, obj);
    }

    public static UpaPoppviewRipperBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UpaPoppviewRipperBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UpaPoppviewRipperBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.upa_poppview_ripper, null, false, obj);
    }

    public static UpaPoppviewRipperBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UpaPoppviewRipperBinding bind(View view, Object obj) {
        return (UpaPoppviewRipperBinding) bind(obj, view, R.layout.upa_poppview_ripper);
    }
}
