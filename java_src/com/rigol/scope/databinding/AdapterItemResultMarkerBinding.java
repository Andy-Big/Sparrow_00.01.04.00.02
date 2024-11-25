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
import com.rigol.scope.data.ResultParam;
import com.rigol.scope.views.DisableTouchEventRecyclerView;
/* loaded from: classes2.dex */
public abstract class AdapterItemResultMarkerBinding extends ViewDataBinding {
    @Bindable
    protected ResultParam mParam;
    public final DisableTouchEventRecyclerView resultList;
    public final TextView title;
    public final ConstraintLayout titleLayout;

    public abstract void setParam(ResultParam resultParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemResultMarkerBinding(Object obj, View view, int i, DisableTouchEventRecyclerView disableTouchEventRecyclerView, TextView textView, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.resultList = disableTouchEventRecyclerView;
        this.title = textView;
        this.titleLayout = constraintLayout;
    }

    public ResultParam getParam() {
        return this.mParam;
    }

    public static AdapterItemResultMarkerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultMarkerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemResultMarkerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_marker, viewGroup, z, obj);
    }

    public static AdapterItemResultMarkerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultMarkerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemResultMarkerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_result_marker, null, false, obj);
    }

    public static AdapterItemResultMarkerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemResultMarkerBinding bind(View view, Object obj) {
        return (AdapterItemResultMarkerBinding) bind(obj, view, R.layout.adapter_item_result_marker);
    }
}
