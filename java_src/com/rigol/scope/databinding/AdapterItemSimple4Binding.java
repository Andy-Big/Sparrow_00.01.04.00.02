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
import com.rigol.scope.data.MappingObject;
/* loaded from: classes2.dex */
public abstract class AdapterItemSimple4Binding extends ViewDataBinding {
    public final ImageView icon;
    public final ConstraintLayout itemView;
    @Bindable
    protected MappingObject mObj;
    public final TextView text1;

    public abstract void setObj(MappingObject mappingObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemSimple4Binding(Object obj, View view, int i, ImageView imageView, ConstraintLayout constraintLayout, TextView textView) {
        super(obj, view, i);
        this.icon = imageView;
        this.itemView = constraintLayout;
        this.text1 = textView;
    }

    public MappingObject getObj() {
        return this.mObj;
    }

    public static AdapterItemSimple4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSimple4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemSimple4Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_simple4, viewGroup, z, obj);
    }

    public static AdapterItemSimple4Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSimple4Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemSimple4Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_simple4, null, false, obj);
    }

    public static AdapterItemSimple4Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemSimple4Binding bind(View view, Object obj) {
        return (AdapterItemSimple4Binding) bind(obj, view, R.layout.adapter_item_simple4);
    }
}
