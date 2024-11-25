package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.LeftStatusBarParam;
import com.rigol.scope.data.MenuParam;
import com.rigol.scope.views.waveview.AwgPlotView;
/* loaded from: classes2.dex */
public abstract class FragmentContBinding extends ViewDataBinding {
    public final AwgPlotView afgView;
    public final View bgView;
    public final View bottomView;
    public final TextView channelText;
    public final TextView dutyCycleEdit;
    public final TextView dutyCycleText;
    @Bindable
    protected LeftStatusBarParam mLeftStatusBarParam;
    @Bindable
    protected MenuParam mMenuParam;
    public final View middleView;
    public final TextView modeSpinner;
    public final TextView onText;
    public final AppCompatTextView rigol1View;
    public final AppCompatTextView rigol2View;
    public final AppCompatTextView rigol3View;
    public final AppCompatTextView rowListView;
    public final TextView startPhaseEdit;
    public final TextView startPhaseText;
    public final AppCompatTextView switch1View;
    public final AppCompatTextView switch2View;
    public final AppCompatTextView switch3View;
    public final TextView trigButton;
    public final TextView waveformSpinner;

    public abstract void setLeftStatusBarParam(LeftStatusBarParam leftStatusBarParam);

    public abstract void setMenuParam(MenuParam menuParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentContBinding(Object obj, View view, int i, AwgPlotView awgPlotView, View view2, View view3, TextView textView, TextView textView2, TextView textView3, View view4, TextView textView4, TextView textView5, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, TextView textView6, TextView textView7, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, TextView textView8, TextView textView9) {
        super(obj, view, i);
        this.afgView = awgPlotView;
        this.bgView = view2;
        this.bottomView = view3;
        this.channelText = textView;
        this.dutyCycleEdit = textView2;
        this.dutyCycleText = textView3;
        this.middleView = view4;
        this.modeSpinner = textView4;
        this.onText = textView5;
        this.rigol1View = appCompatTextView;
        this.rigol2View = appCompatTextView2;
        this.rigol3View = appCompatTextView3;
        this.rowListView = appCompatTextView4;
        this.startPhaseEdit = textView6;
        this.startPhaseText = textView7;
        this.switch1View = appCompatTextView5;
        this.switch2View = appCompatTextView6;
        this.switch3View = appCompatTextView7;
        this.trigButton = textView8;
        this.waveformSpinner = textView9;
    }

    public LeftStatusBarParam getLeftStatusBarParam() {
        return this.mLeftStatusBarParam;
    }

    public MenuParam getMenuParam() {
        return this.mMenuParam;
    }

    public static FragmentContBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentContBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentContBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_cont, viewGroup, z, obj);
    }

    public static FragmentContBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentContBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentContBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_cont, null, false, obj);
    }

    public static FragmentContBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentContBinding bind(View view, Object obj) {
        return (FragmentContBinding) bind(obj, view, R.layout.fragment_cont);
    }
}
