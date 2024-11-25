package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.TriggerParam;
/* loaded from: classes2.dex */
public abstract class FragmentNavigationBarBinding extends ViewDataBinding {
    public final Button acquireBtn;
    public final ConstraintLayout acquireInfo;
    public final TextView appCompatTextView2;
    public final TextView appCompatTextView3;
    public final TextView appCompatTextView4;
    public final ImageButton appSwitch;
    public final ConstraintLayout appSwitchLayout;
    public final RecyclerView functionList;
    public final ImageView functionListLeftArrow;
    public final ImageView functionListRightArrow;
    public final Button horizontalOffsetBtn;
    public final TextView horizontalOffsetInfo;
    public final Button horizontalScaleBtn;
    public final TextView horizontalScaleInfo;
    public final ImageView imageView2;
    public final ImageView logo;
    @Bindable
    protected HorizontalParam mHorizontalParam;
    @Bindable
    protected TriggerParam mTriggerParam;
    public final ConstraintLayout navigationBarLayout;
    public final TextView status;
    public final Button triggerBtn;
    public final ConstraintLayout triggerInfo;

    public abstract void setHorizontalParam(HorizontalParam horizontalParam);

    public abstract void setTriggerParam(TriggerParam triggerParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentNavigationBarBinding(Object obj, View view, int i, Button button, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, ImageButton imageButton, ConstraintLayout constraintLayout2, RecyclerView recyclerView, ImageView imageView, ImageView imageView2, Button button2, TextView textView4, Button button3, TextView textView5, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout3, TextView textView6, Button button4, ConstraintLayout constraintLayout4) {
        super(obj, view, i);
        this.acquireBtn = button;
        this.acquireInfo = constraintLayout;
        this.appCompatTextView2 = textView;
        this.appCompatTextView3 = textView2;
        this.appCompatTextView4 = textView3;
        this.appSwitch = imageButton;
        this.appSwitchLayout = constraintLayout2;
        this.functionList = recyclerView;
        this.functionListLeftArrow = imageView;
        this.functionListRightArrow = imageView2;
        this.horizontalOffsetBtn = button2;
        this.horizontalOffsetInfo = textView4;
        this.horizontalScaleBtn = button3;
        this.horizontalScaleInfo = textView5;
        this.imageView2 = imageView3;
        this.logo = imageView4;
        this.navigationBarLayout = constraintLayout3;
        this.status = textView6;
        this.triggerBtn = button4;
        this.triggerInfo = constraintLayout4;
    }

    public TriggerParam getTriggerParam() {
        return this.mTriggerParam;
    }

    public HorizontalParam getHorizontalParam() {
        return this.mHorizontalParam;
    }

    public static FragmentNavigationBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentNavigationBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentNavigationBarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_navigation_bar, viewGroup, z, obj);
    }

    public static FragmentNavigationBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentNavigationBarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentNavigationBarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_navigation_bar, null, false, obj);
    }

    public static FragmentNavigationBarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentNavigationBarBinding bind(View view, Object obj) {
        return (FragmentNavigationBarBinding) bind(obj, view, R.layout.fragment_navigation_bar);
    }
}
