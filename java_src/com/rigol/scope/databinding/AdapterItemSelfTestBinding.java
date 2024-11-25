package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.SelfTestParam;
/* loaded from: classes2.dex */
public abstract class AdapterItemSelfTestBinding extends ViewDataBinding {
    @Bindable
    protected Integer mIndex;
    @Bindable
    protected SelfTestParam mParam;
    public final TextView tvId;
    public final TextView tvItemValue;
    public final TextView tvSelfRange;
    public final TextView tvSelfTestItem;

    public abstract void setIndex(Integer num);

    public abstract void setParam(SelfTestParam selfTestParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemSelfTestBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.tvId = textView;
        this.tvItemValue = textView2;
        this.tvSelfRange = textView3;
        this.tvSelfTestItem = textView4;
    }

    public SelfTestParam getParam() {
        return this.mParam;
    }

    public Integer getIndex() {
        return this.mIndex;
    }

    public static AdapterItemSelfTestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSelfTestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemSelfTestBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_self_test, viewGroup, z, obj);
    }

    public static AdapterItemSelfTestBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSelfTestBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemSelfTestBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_self_test, null, false, obj);
    }

    public static AdapterItemSelfTestBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSelfTestBinding bind(View view, Object obj) {
        return (AdapterItemSelfTestBinding) bind(obj, view, R.layout.adapter_item_self_test);
    }
}
