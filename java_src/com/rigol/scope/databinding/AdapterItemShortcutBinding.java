package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;

/* loaded from: classes2.dex */
public abstract class AdapterItemShortcutBinding extends ViewDataBinding {
    public final ImageView icon;
    @Bindable
    protected ServiceEnum.Function mFunction;
    @Bindable
    protected MappingObject mObj;
    public final TextView title;

    public abstract void setFunction(ServiceEnum.Function function);

    public abstract void setObj(MappingObject mappingObject);

    protected AdapterItemShortcutBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.icon = imageView;
        this.title = textView;
    }

    public MappingObject getObj() {
        return this.mObj;
    }

    public ServiceEnum.Function getFunction() {
        return this.mFunction;
    }

    public static AdapterItemShortcutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemShortcutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemShortcutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_shortcut, viewGroup, z, obj);
    }

    public static AdapterItemShortcutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemShortcutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemShortcutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_shortcut, null, false, obj);
    }

    public static AdapterItemShortcutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemShortcutBinding bind(View view, Object obj) {
        return (AdapterItemShortcutBinding) bind(obj, view, R.layout.adapter_item_shortcut);
    }
}
