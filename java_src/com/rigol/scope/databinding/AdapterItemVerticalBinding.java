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
import com.rigol.scope.data.VerticalParam;
/* loaded from: classes2.dex */
public abstract class AdapterItemVerticalBinding extends ViewDataBinding {
    public final ImageView bandLimit;
    public final TextView bandLimitText;
    public final ImageView coupling1;
    public final ImageView impedance;
    public final ImageView invert;
    @Bindable
    protected VerticalParam mParam;
    public final TextView position;
    public final TextView scale;
    public final TextView title;

    public abstract void setParam(VerticalParam verticalParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterItemVerticalBinding(Object obj, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.bandLimit = imageView;
        this.bandLimitText = textView;
        this.coupling1 = imageView2;
        this.impedance = imageView3;
        this.invert = imageView4;
        this.position = textView2;
        this.scale = textView3;
        this.title = textView4;
    }

    public VerticalParam getParam() {
        return this.mParam;
    }

    public static AdapterItemVerticalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemVerticalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterItemVerticalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_vertical, viewGroup, z, obj);
    }

    public static AdapterItemVerticalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemVerticalBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterItemVerticalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_item_vertical, null, false, obj);
    }

    public static AdapterItemVerticalBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterItemVerticalBinding bind(View view, Object obj) {
        return (AdapterItemVerticalBinding) bind(obj, view, R.layout.adapter_item_vertical);
    }
}
