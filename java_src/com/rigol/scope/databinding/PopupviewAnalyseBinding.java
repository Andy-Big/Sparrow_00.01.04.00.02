package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class PopupviewAnalyseBinding extends ViewDataBinding {
    public final RecyclerView analyseList;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewAnalyseBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.analyseList = recyclerView;
    }

    public static PopupviewAnalyseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAnalyseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewAnalyseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_analyse, viewGroup, z, obj);
    }

    public static PopupviewAnalyseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAnalyseBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewAnalyseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_analyse, null, false, obj);
    }

    public static PopupviewAnalyseBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewAnalyseBinding bind(View view, Object obj) {
        return (PopupviewAnalyseBinding) bind(obj, view, R.layout.popupview_analyse);
    }
}
