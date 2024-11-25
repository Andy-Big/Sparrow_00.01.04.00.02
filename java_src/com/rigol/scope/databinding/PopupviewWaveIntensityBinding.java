package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.DisplayParam;
/* loaded from: classes2.dex */
public abstract class PopupviewWaveIntensityBinding extends ViewDataBinding {
    @Bindable
    protected DisplayParam mParam;
    public final TextView waveIntensity;
    public final SeekBar waveIntensitySeekbar;
    public final TextView waveIntensityText;

    public abstract void setParam(DisplayParam displayParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupviewWaveIntensityBinding(Object obj, View view, int i, TextView textView, SeekBar seekBar, TextView textView2) {
        super(obj, view, i);
        this.waveIntensity = textView;
        this.waveIntensitySeekbar = seekBar;
        this.waveIntensityText = textView2;
    }

    public DisplayParam getParam() {
        return this.mParam;
    }

    public static PopupviewWaveIntensityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewWaveIntensityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupviewWaveIntensityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_wave_intensity, viewGroup, z, obj);
    }

    public static PopupviewWaveIntensityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewWaveIntensityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupviewWaveIntensityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popupview_wave_intensity, null, false, obj);
    }

    public static PopupviewWaveIntensityBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupviewWaveIntensityBinding bind(View view, Object obj) {
        return (PopupviewWaveIntensityBinding) bind(obj, view, R.layout.popupview_wave_intensity);
    }
}
