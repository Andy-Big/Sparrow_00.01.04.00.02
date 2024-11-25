package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.rigol.scope.R;
import com.rigol.scope.data.MiniScreenParam;
import me.relex.circleindicator.CircleIndicator3;
/* loaded from: classes2.dex */
public abstract class PresentationMiniscreenBinding extends ViewDataBinding {
    public final Guideline bottomGuideline;
    public final ConstraintLayout bottomLeftCornerLayout;
    public final ImageView bottomLeftCornerPress;
    public final TextView bottomLeftCornerPressTv;
    public final ImageView bottomLeftCornerSlash;
    public final TextView bottomLeftCornerTv;
    public final ConstraintLayout bottomRightCornerLayout;
    public final ImageView bottomRightCornerPress;
    public final TextView bottomRightCornerPressTv;
    public final ImageView bottomRightCornerSlash;
    public final TextView bottomRightCornerTv;
    public final ViewPager2 content;
    public final CircleIndicator3 indicator;
    public final Guideline leftGuideline;
    @Bindable
    protected MiniScreenParam mParam;
    public final Button panelSwitch;
    public final Guideline rightGuideline;
    public final TextView topCenterPosition;
    public final Guideline topGuideline;
    public final ConstraintLayout topLeftCornerLayout;
    public final ImageView topLeftCornerPress;
    public final TextView topLeftCornerPressTv;
    public final ImageView topLeftCornerSlash;
    public final TextView topLeftCornerTv;
    public final ConstraintLayout topRightCornerLayout;
    public final ImageView topRightCornerPress;
    public final TextView topRightCornerPressTv;
    public final ImageView topRightCornerSlash;
    public final TextView topRightCornerTv;

    public abstract void setParam(MiniScreenParam miniScreenParam);

    /* JADX INFO: Access modifiers changed from: protected */
    public PresentationMiniscreenBinding(Object obj, View view, int i, Guideline guideline, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, ConstraintLayout constraintLayout2, ImageView imageView3, TextView textView3, ImageView imageView4, TextView textView4, ViewPager2 viewPager2, CircleIndicator3 circleIndicator3, Guideline guideline2, Button button, Guideline guideline3, TextView textView5, Guideline guideline4, ConstraintLayout constraintLayout3, ImageView imageView5, TextView textView6, ImageView imageView6, TextView textView7, ConstraintLayout constraintLayout4, ImageView imageView7, TextView textView8, ImageView imageView8, TextView textView9) {
        super(obj, view, i);
        this.bottomGuideline = guideline;
        this.bottomLeftCornerLayout = constraintLayout;
        this.bottomLeftCornerPress = imageView;
        this.bottomLeftCornerPressTv = textView;
        this.bottomLeftCornerSlash = imageView2;
        this.bottomLeftCornerTv = textView2;
        this.bottomRightCornerLayout = constraintLayout2;
        this.bottomRightCornerPress = imageView3;
        this.bottomRightCornerPressTv = textView3;
        this.bottomRightCornerSlash = imageView4;
        this.bottomRightCornerTv = textView4;
        this.content = viewPager2;
        this.indicator = circleIndicator3;
        this.leftGuideline = guideline2;
        this.panelSwitch = button;
        this.rightGuideline = guideline3;
        this.topCenterPosition = textView5;
        this.topGuideline = guideline4;
        this.topLeftCornerLayout = constraintLayout3;
        this.topLeftCornerPress = imageView5;
        this.topLeftCornerPressTv = textView6;
        this.topLeftCornerSlash = imageView6;
        this.topLeftCornerTv = textView7;
        this.topRightCornerLayout = constraintLayout4;
        this.topRightCornerPress = imageView7;
        this.topRightCornerPressTv = textView8;
        this.topRightCornerSlash = imageView8;
        this.topRightCornerTv = textView9;
    }

    public MiniScreenParam getParam() {
        return this.mParam;
    }

    public static PresentationMiniscreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PresentationMiniscreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PresentationMiniscreenBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.presentation_miniscreen, viewGroup, z, obj);
    }

    public static PresentationMiniscreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PresentationMiniscreenBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PresentationMiniscreenBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.presentation_miniscreen, null, false, obj);
    }

    public static PresentationMiniscreenBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PresentationMiniscreenBinding bind(View view, Object obj) {
        return (PresentationMiniscreenBinding) bind(obj, view, R.layout.presentation_miniscreen);
    }
}
