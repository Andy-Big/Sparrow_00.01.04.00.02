package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.views.multi.MultiWindow;
/* loaded from: classes2.dex */
public abstract class FragmentWaveformBinding extends ViewDataBinding {
    public final MultiWindow multiWindow;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentWaveformBinding(Object obj, View view, int i, MultiWindow multiWindow) {
        super(obj, view, i);
        this.multiWindow = multiWindow;
    }

    public static FragmentWaveformBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWaveformBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentWaveformBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_waveform, viewGroup, z, obj);
    }

    public static FragmentWaveformBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWaveformBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentWaveformBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_waveform, null, false, obj);
    }

    public static FragmentWaveformBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWaveformBinding bind(View view, Object obj) {
        return (FragmentWaveformBinding) bind(obj, view, R.layout.fragment_waveform);
    }
}
