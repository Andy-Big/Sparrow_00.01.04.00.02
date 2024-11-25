package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public abstract class AdapterLaColorBinding extends ViewDataBinding {
    public final TextView laLabelEdit;
    public final TextView laLabelEn;
    public final TextView laLabelText;
    public final TextView laSourceGroup;
    public final TextView laSourceGroup2;
    public final TextView laSourceGroupText;
    public final TextView laSourceGroupText2;
    @Bindable
    protected LaParam mParma;
    public final SwitchButton showLabelSwitch;

    public abstract void setParma(LaParam laParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterLaColorBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, SwitchButton switchButton) {
        super(obj, view, i);
        this.laLabelEdit = textView;
        this.laLabelEn = textView2;
        this.laLabelText = textView3;
        this.laSourceGroup = textView4;
        this.laSourceGroup2 = textView5;
        this.laSourceGroupText = textView6;
        this.laSourceGroupText2 = textView7;
        this.showLabelSwitch = switchButton;
    }

    public LaParam getParma() {
        return this.mParma;
    }

    public static AdapterLaColorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterLaColorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterLaColorBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_la_color, viewGroup, z, obj);
    }

    public static AdapterLaColorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterLaColorBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterLaColorBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_la_color, null, false, obj);
    }

    public static AdapterLaColorBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterLaColorBinding bind(View view, Object obj) {
        return (AdapterLaColorBinding) bind(obj, view, R.layout.adapter_la_color);
    }
}
