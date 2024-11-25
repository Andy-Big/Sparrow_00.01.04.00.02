package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.views.acquire.AcquireDepthView;
import com.rigol.scope.views.window.Window;
/* loaded from: classes2.dex */
public abstract class WindowWaveformBinding extends ViewDataBinding {
    public final AcquireDepthView acquireDepth;
    public final ConstraintLayout contentLayout;
    @Bindable
    protected SharedParam mSharedParam;
    public final TextView title;
    public final ConstraintLayout titleLayout;
    public final ImageButton windowClose;
    public final Window windowLayout;
    public final ImageButton windowMove;
    public final ImageButton windowSetting;

    public abstract void setSharedParam(SharedParam sharedParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public WindowWaveformBinding(Object obj, View view, int i, AcquireDepthView acquireDepthView, ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, ImageButton imageButton, Window window, ImageButton imageButton2, ImageButton imageButton3) {
        super(obj, view, i);
        this.acquireDepth = acquireDepthView;
        this.contentLayout = constraintLayout;
        this.title = textView;
        this.titleLayout = constraintLayout2;
        this.windowClose = imageButton;
        this.windowLayout = window;
        this.windowMove = imageButton2;
        this.windowSetting = imageButton3;
    }

    public SharedParam getSharedParam() {
        return this.mSharedParam;
    }

    public static WindowWaveformBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WindowWaveformBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (WindowWaveformBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.window_waveform, viewGroup, z, obj);
    }

    public static WindowWaveformBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WindowWaveformBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (WindowWaveformBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.window_waveform, null, false, obj);
    }

    public static WindowWaveformBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WindowWaveformBinding bind(View view, Object obj) {
        return (WindowWaveformBinding) bind(obj, view, R.layout.window_waveform);
    }
}
