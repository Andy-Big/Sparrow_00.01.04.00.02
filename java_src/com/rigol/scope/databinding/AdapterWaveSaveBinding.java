package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class AdapterWaveSaveBinding extends ViewDataBinding {
    public final ImageView imageView3;
    public final ImageView imageView5;
    public final ConstraintLayout layoutFromat;
    public final ConstraintLayout layoutSaveChannel;
    public final ConstraintLayout layoutSourcefrom;
    public final TextView textView25;
    public final TextView textView27;
    public final TextView textView29;
    public final TextView tvFormatValue;
    public final TextView tvSavechannel;
    public final TextView tvSourcefrom;

    /* JADX INFO: Access modifiers changed from: protected */
    public AdapterWaveSaveBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.imageView3 = imageView;
        this.imageView5 = imageView2;
        this.layoutFromat = constraintLayout;
        this.layoutSaveChannel = constraintLayout2;
        this.layoutSourcefrom = constraintLayout3;
        this.textView25 = textView;
        this.textView27 = textView2;
        this.textView29 = textView3;
        this.tvFormatValue = textView4;
        this.tvSavechannel = textView5;
        this.tvSourcefrom = textView6;
    }

    public static AdapterWaveSaveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterWaveSaveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AdapterWaveSaveBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_wave_save, viewGroup, z, obj);
    }

    public static AdapterWaveSaveBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterWaveSaveBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AdapterWaveSaveBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.adapter_wave_save, null, false, obj);
    }

    public static AdapterWaveSaveBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterWaveSaveBinding bind(View view, Object obj) {
        return (AdapterWaveSaveBinding) bind(obj, view, R.layout.adapter_wave_save);
    }
}
