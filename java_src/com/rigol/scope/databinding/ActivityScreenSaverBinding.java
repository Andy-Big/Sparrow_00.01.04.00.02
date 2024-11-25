package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.UtilityParam;
/* loaded from: classes2.dex */
public abstract class ActivityScreenSaverBinding extends ViewDataBinding {
    public final LinearLayout IdleTimeLL;
    @Bindable
    protected UtilityParam mParam;
    public final ImageView mainAdBackground;
    public final RelativeLayout mainAdRelativeLayout;
    public final TextView mainAdTextview;

    public abstract void setParam(UtilityParam utilityParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityScreenSaverBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, RelativeLayout relativeLayout, TextView textView) {
        super(obj, view, i);
        this.IdleTimeLL = linearLayout;
        this.mainAdBackground = imageView;
        this.mainAdRelativeLayout = relativeLayout;
        this.mainAdTextview = textView;
    }

    public UtilityParam getParam() {
        return this.mParam;
    }

    public static ActivityScreenSaverBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityScreenSaverBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityScreenSaverBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_screen_saver, viewGroup, z, obj);
    }

    public static ActivityScreenSaverBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityScreenSaverBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityScreenSaverBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_screen_saver, null, false, obj);
    }

    public static ActivityScreenSaverBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityScreenSaverBinding bind(View view, Object obj) {
        return (ActivityScreenSaverBinding) bind(obj, view, R.layout.activity_screen_saver);
    }
}
