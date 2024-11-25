package com.rigol.scope.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public abstract class ActivityRigolKeyTest3Binding extends ViewDataBinding {
    public final TextView RUN;
    public final TextView RUN1;
    public final TextView RUN2;
    public final TextView RUN3;
    public final TextView RUN4;
    public final TextView RUN5;
    public final TextView RUN6;
    public final TextView RUN7;
    public final TextView acquireText;
    public final ImageButton ch1OffsetLeft;
    public final ImageButton ch1OffsetLeft2;
    public final ImageButton ch1OffsetLeft3;
    public final ImageButton ch1OffsetLeft3Text;
    public final ImageButton ch1OffsetLeft7;
    public final ImageButton ch1OffsetLeft7Text;
    public final ImageButton ch1ScaleLeft3Text;
    public final ImageButton ch1ScaleLeft7Text;
    public final TextView ch1Text;
    public final TextView ch2Text;
    public final TextView ch3Offset;
    public final TextView ch3Offset2;
    public final TextView ch3OffsetText;
    public final TextView ch3ScaleText;
    public final TextView ch3Text;
    public final TextView ch4Text;
    public final TextView exitText;
    public final TextView forceText;
    public final TextView giText;
    public final TextView hScaleOffset;
    public final ImageButton hScaleOffsetLeft;
    public final ImageButton hScaleOffsetLeft2;
    public final TextView laText;
    public final Guideline leftGuideline;
    public final Guideline leftGuideline1;
    public final Guideline leftGuideline2;
    public final ImageView logo;
    @Bindable
    protected View.OnClickListener mOnClickListener;
    public final TextView mathText;
    public final TextView playOffset;
    public final TextView playOffsetLeft;
    public final TextView playOffsetLeft2;
    public final TextView postionOffset;
    public final ImageButton postionOffsetLeft;
    public final ImageButton postionOffsetLeft2;
    public final TextView quickText;
    public final TextView refText;
    public final TextView searchText;
    public final TextView slopeText;
    public final TextView touchLockText;
    public final ImageButton triggeOffsetLeft;
    public final ImageButton triggeOffsetLeft2;
    public final TextView triggerOffset;
    public final TextView triggerText;

    public abstract void setOnClickListener(View.OnClickListener onClickListener);

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityRigolKeyTest3Binding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, ImageButton imageButton8, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, ImageButton imageButton9, ImageButton imageButton10, TextView textView22, Guideline guideline, Guideline guideline2, Guideline guideline3, ImageView imageView, TextView textView23, TextView textView24, TextView textView25, TextView textView26, TextView textView27, ImageButton imageButton11, ImageButton imageButton12, TextView textView28, TextView textView29, TextView textView30, TextView textView31, TextView textView32, ImageButton imageButton13, ImageButton imageButton14, TextView textView33, TextView textView34) {
        super(obj, view, i);
        this.RUN = textView;
        this.RUN1 = textView2;
        this.RUN2 = textView3;
        this.RUN3 = textView4;
        this.RUN4 = textView5;
        this.RUN5 = textView6;
        this.RUN6 = textView7;
        this.RUN7 = textView8;
        this.acquireText = textView9;
        this.ch1OffsetLeft = imageButton;
        this.ch1OffsetLeft2 = imageButton2;
        this.ch1OffsetLeft3 = imageButton3;
        this.ch1OffsetLeft3Text = imageButton4;
        this.ch1OffsetLeft7 = imageButton5;
        this.ch1OffsetLeft7Text = imageButton6;
        this.ch1ScaleLeft3Text = imageButton7;
        this.ch1ScaleLeft7Text = imageButton8;
        this.ch1Text = textView10;
        this.ch2Text = textView11;
        this.ch3Offset = textView12;
        this.ch3Offset2 = textView13;
        this.ch3OffsetText = textView14;
        this.ch3ScaleText = textView15;
        this.ch3Text = textView16;
        this.ch4Text = textView17;
        this.exitText = textView18;
        this.forceText = textView19;
        this.giText = textView20;
        this.hScaleOffset = textView21;
        this.hScaleOffsetLeft = imageButton9;
        this.hScaleOffsetLeft2 = imageButton10;
        this.laText = textView22;
        this.leftGuideline = guideline;
        this.leftGuideline1 = guideline2;
        this.leftGuideline2 = guideline3;
        this.logo = imageView;
        this.mathText = textView23;
        this.playOffset = textView24;
        this.playOffsetLeft = textView25;
        this.playOffsetLeft2 = textView26;
        this.postionOffset = textView27;
        this.postionOffsetLeft = imageButton11;
        this.postionOffsetLeft2 = imageButton12;
        this.quickText = textView28;
        this.refText = textView29;
        this.searchText = textView30;
        this.slopeText = textView31;
        this.touchLockText = textView32;
        this.triggeOffsetLeft = imageButton13;
        this.triggeOffsetLeft2 = imageButton14;
        this.triggerOffset = textView33;
        this.triggerText = textView34;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public static ActivityRigolKeyTest3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityRigolKeyTest3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityRigolKeyTest3Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_rigol_key_test3, viewGroup, z, obj);
    }

    public static ActivityRigolKeyTest3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityRigolKeyTest3Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityRigolKeyTest3Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_rigol_key_test3, null, false, obj);
    }

    public static ActivityRigolKeyTest3Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityRigolKeyTest3Binding bind(View view, Object obj) {
        return (ActivityRigolKeyTest3Binding) bind(obj, view, R.layout.activity_rigol_key_test3);
    }
}
