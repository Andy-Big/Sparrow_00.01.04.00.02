package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.AfgParam;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.utilities.DrawView1;
import com.rigol.scope.utilities.MRefreshHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
/* loaded from: classes2.dex */
public abstract class FragmentSettingsBarBinding extends ViewDataBinding {
    public final ImageView beeper;
    public final RecyclerView dItemList;
    public final TextView date;
    public final ImageView lxi;
    @Bindable
    protected AfgParam mAfgParam;
    @Bindable
    protected ObservableBoolean mHasUpdate;
    @Bindable
    protected LaParam mLaParam;
    @Bindable
    protected SharedParam mSharedParam;
    @Bindable
    protected UtilityParam mUtilityParam;
    public final RecyclerView mathItemList;
    public final RecyclerView mathList;
    public final MRefreshHeader msRefreshHeader;
    public final View nothingView;
    public final RecyclerView otherLayout;
    public final DrawView1 powerIconView;
    public final ImageView rmt;
    public final ImageButton starterButton;
    public final LinearLayoutCompat starterLayout;
    public final TextView starterMessage;
    public final ConstraintLayout systemTimeLayout;
    public final TextView time;
    public final ImageView usb;
    public final SmartRefreshLayout verticalD;
    public final ConstraintLayout verticalDTwo;
    public final SmartRefreshLayout verticalG;
    public final TextView verticalGText;
    public final ConstraintLayout verticalGView;
    public final RecyclerView verticalList;
    public final ConstraintLayout verticalListSystemTimeLayout;
    public final ConstraintLayout verticalM;

    public abstract void setAfgParam(AfgParam afgParam);

    public abstract void setHasUpdate(ObservableBoolean observableBoolean);

    public abstract void setLaParam(LaParam laParam);

    public abstract void setSharedParam(SharedParam sharedParam);

    public abstract void setUtilityParam(UtilityParam utilityParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSettingsBarBinding(Object obj, View view, int i, ImageView imageView, RecyclerView recyclerView, TextView textView, ImageView imageView2, RecyclerView recyclerView2, RecyclerView recyclerView3, MRefreshHeader mRefreshHeader, View view2, RecyclerView recyclerView4, DrawView1 drawView1, ImageView imageView3, ImageButton imageButton, LinearLayoutCompat linearLayoutCompat, TextView textView2, ConstraintLayout constraintLayout, TextView textView3, ImageView imageView4, SmartRefreshLayout smartRefreshLayout, ConstraintLayout constraintLayout2, SmartRefreshLayout smartRefreshLayout2, TextView textView4, ConstraintLayout constraintLayout3, RecyclerView recyclerView5, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5) {
        super(obj, view, i);
        this.beeper = imageView;
        this.dItemList = recyclerView;
        this.date = textView;
        this.lxi = imageView2;
        this.mathItemList = recyclerView2;
        this.mathList = recyclerView3;
        this.msRefreshHeader = mRefreshHeader;
        this.nothingView = view2;
        this.otherLayout = recyclerView4;
        this.powerIconView = drawView1;
        this.rmt = imageView3;
        this.starterButton = imageButton;
        this.starterLayout = linearLayoutCompat;
        this.starterMessage = textView2;
        this.systemTimeLayout = constraintLayout;
        this.time = textView3;
        this.usb = imageView4;
        this.verticalD = smartRefreshLayout;
        this.verticalDTwo = constraintLayout2;
        this.verticalG = smartRefreshLayout2;
        this.verticalGText = textView4;
        this.verticalGView = constraintLayout3;
        this.verticalList = recyclerView5;
        this.verticalListSystemTimeLayout = constraintLayout4;
        this.verticalM = constraintLayout5;
    }

    public ObservableBoolean getHasUpdate() {
        return this.mHasUpdate;
    }

    public SharedParam getSharedParam() {
        return this.mSharedParam;
    }

    public UtilityParam getUtilityParam() {
        return this.mUtilityParam;
    }

    public AfgParam getAfgParam() {
        return this.mAfgParam;
    }

    public LaParam getLaParam() {
        return this.mLaParam;
    }

    public static FragmentSettingsBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingsBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentSettingsBarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_settings_bar, viewGroup, z, obj);
    }

    public static FragmentSettingsBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingsBarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentSettingsBarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_settings_bar, null, false, obj);
    }

    public static FragmentSettingsBarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingsBarBinding bind(View view, Object obj) {
        return (FragmentSettingsBarBinding) bind(obj, view, R.layout.fragment_settings_bar);
    }
}
