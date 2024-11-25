package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterUtilityQuickTitleBinding extends ViewDataBinding {
    public final TextView utilityQuickTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterUtilityQuickTitleBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.utilityQuickTitle = textView;
    }

    public static AdapterUtilityQuickTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityQuickTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterUtilityQuickTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_quick_title, viewGroup, z, obj);
    }

    public static AdapterUtilityQuickTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityQuickTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterUtilityQuickTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_utility_quick_title, null, false, obj);
    }

    public static AdapterUtilityQuickTitleBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterUtilityQuickTitleBinding bind(View view, Object obj) {
        return (AdapterUtilityQuickTitleBinding) bind(obj, view, R.layout.adapter_utility_quick_title);
    }
}
