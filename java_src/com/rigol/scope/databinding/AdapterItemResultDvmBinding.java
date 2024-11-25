package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.DvmResultParam;
/* loaded from: classes2.dex */
public abstract class AdapterItemResultDvmBinding extends ViewDataBinding {
    public final TextView currentResult;
    public final ImageView icon;
    @Bindable
    protected DvmResultParam mParam;
    public final TextView mode;
    public final TextView modeTitle;
    public final TextView modeTitleBw;
    public final TextView modeWb;
    public final ConstraintLayout resultLayout;
    public final TextView title;
    public final ConstraintLayout titleLayout;

    public abstract void setParam(DvmResultParam dvmResultParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemResultDvmBinding(Object obj, View view, int i, TextView textView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ConstraintLayout constraintLayout, TextView textView6, ConstraintLayout constraintLayout2) {
        super(obj, view, i);
        this.currentResult = textView;
        this.icon = imageView;
        this.mode = textView2;
        this.modeTitle = textView3;
        this.modeTitleBw = textView4;
        this.modeWb = textView5;
        this.resultLayout = constraintLayout;
        this.title = textView6;
        this.titleLayout = constraintLayout2;
    }

    public DvmResultParam getParam() {
        return this.mParam;
    }

    public static AdapterItemResultDvmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultDvmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemResultDvmBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_dvm, viewGroup, z, obj);
    }

    public static AdapterItemResultDvmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultDvmBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemResultDvmBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_dvm, null, false, obj);
    }

    public static AdapterItemResultDvmBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultDvmBinding bind(View view, Object obj) {
        return (AdapterItemResultDvmBinding) bind(obj, view, R.layout.adapter_item_result_dvm);
    }
}
