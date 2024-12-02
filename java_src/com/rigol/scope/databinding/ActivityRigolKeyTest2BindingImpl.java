package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;

/* loaded from: classes2.dex */
public class ActivityRigolKeyTest2BindingImpl extends ActivityRigolKeyTest2Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guidelineh1, 2);
        sViewsWithIds.put(R.id.logo, 3);
        sViewsWithIds.put(R.id.RUN, 4);
        sViewsWithIds.put(R.id.RUN1, 5);
        sViewsWithIds.put(R.id.RUN2, 6);
        sViewsWithIds.put(R.id.RUN3, 7);
        sViewsWithIds.put(R.id.RUN4, 8);
        sViewsWithIds.put(R.id.RUN5, 9);
        sViewsWithIds.put(R.id.RUN6, 10);
        sViewsWithIds.put(R.id.RUN7, 11);
        sViewsWithIds.put(R.id.ch3_offset, 12);
        sViewsWithIds.put(R.id.ch1_offset_left, 13);
        sViewsWithIds.put(R.id.ch1_offset_left2, 14);
        sViewsWithIds.put(R.id.ch3_offset2, 15);
        sViewsWithIds.put(R.id.ch1_offset_left3, 16);
        sViewsWithIds.put(R.id.ch1_offset_left7, 17);
        sViewsWithIds.put(R.id.touch_lock_text, 18);
        sViewsWithIds.put(R.id.quick_text, 19);
        sViewsWithIds.put(R.id.trigger_text, 20);
        sViewsWithIds.put(R.id.slope_text, 21);
        sViewsWithIds.put(R.id.force_text, 22);
        sViewsWithIds.put(R.id.trigger_offset, 23);
        sViewsWithIds.put(R.id.trigge_offset_left, 24);
        sViewsWithIds.put(R.id.trigge_offset_left2, 25);
        sViewsWithIds.put(R.id.ch3_offset_text, 26);
        sViewsWithIds.put(R.id.ch1_offset_left3_text, 27);
        sViewsWithIds.put(R.id.ch1_offset_left7_text, 28);
        sViewsWithIds.put(R.id.ch1_text, 29);
        sViewsWithIds.put(R.id.ch2_text, 30);
        sViewsWithIds.put(R.id.ch3_text, 31);
        sViewsWithIds.put(R.id.ch4_text, 32);
        sViewsWithIds.put(R.id.la_text, 33);
        sViewsWithIds.put(R.id.g1_text, 34);
        sViewsWithIds.put(R.id.g2_text, 35);
        sViewsWithIds.put(R.id.math_text, 36);
        sViewsWithIds.put(R.id.ref_text, 37);
        sViewsWithIds.put(R.id.ch3_scale_text, 38);
        sViewsWithIds.put(R.id.ch1_scale_left3_text, 39);
        sViewsWithIds.put(R.id.ch1_scale_left7_text, 40);
        sViewsWithIds.put(R.id.postion_offset, 41);
        sViewsWithIds.put(R.id.postion__offset_left, 42);
        sViewsWithIds.put(R.id.postion_offset_left2, 43);
        sViewsWithIds.put(R.id.acquire_text, 44);
        sViewsWithIds.put(R.id.zoom_text, 45);
        sViewsWithIds.put(R.id.search_text, 46);
        sViewsWithIds.put(R.id.play_offset, 47);
        sViewsWithIds.put(R.id.play__offset_left, 48);
        sViewsWithIds.put(R.id.play_offset_left2, 49);
        sViewsWithIds.put(R.id.h_scale_offset, 50);
        sViewsWithIds.put(R.id.h_scale_offset_left, 51);
        sViewsWithIds.put(R.id.h_scale_offset_left2, 52);
    }

    public ActivityRigolKeyTest2BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 53, sIncludes, sViewsWithIds));
    }

    private ActivityRigolKeyTest2BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[7], (TextView) objArr[8], (TextView) objArr[9], (TextView) objArr[10], (TextView) objArr[11], (TextView) objArr[44], (ImageButton) objArr[13], (ImageButton) objArr[14], (ImageButton) objArr[16], (ImageButton) objArr[27], (ImageButton) objArr[17], (ImageButton) objArr[28], (ImageButton) objArr[39], (ImageButton) objArr[40], (TextView) objArr[29], (TextView) objArr[30], (TextView) objArr[12], (TextView) objArr[15], (TextView) objArr[26], (TextView) objArr[38], (TextView) objArr[31], (TextView) objArr[32], (TextView) objArr[1], (TextView) objArr[22], (TextView) objArr[34], (TextView) objArr[35], (Guideline) objArr[2], (TextView) objArr[50], (ImageButton) objArr[51], (ImageButton) objArr[52], (TextView) objArr[33], (ImageView) objArr[3], (TextView) objArr[36], (TextView) objArr[47], (TextView) objArr[48], (TextView) objArr[49], (TextView) objArr[41], (ImageButton) objArr[42], (ImageButton) objArr[43], (TextView) objArr[19], (TextView) objArr[37], (TextView) objArr[46], (TextView) objArr[21], (TextView) objArr[18], (ImageButton) objArr[24], (ImageButton) objArr[25], (TextView) objArr[23], (TextView) objArr[20], (TextView) objArr[45]);
        this.mDirtyFlags = -1L;
        this.exitText.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (569 == i) {
            setOnClickListener((View.OnClickListener) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.ActivityRigolKeyTest2Binding
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(569);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mOnClickListener;
        if ((j & 3) != 0) {
            this.exitText.setOnClickListener(onClickListener);
        }
    }
}
