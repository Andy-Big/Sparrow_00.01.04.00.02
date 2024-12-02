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
public class ActivityRigolKeyTest3BindingImpl extends ActivityRigolKeyTest3Binding {
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
        sparseIntArray.put(R.id.left_guideline, 2);
        sViewsWithIds.put(R.id.left_guideline1, 3);
        sViewsWithIds.put(R.id.left_guideline2, 4);
        sViewsWithIds.put(R.id.logo, 5);
        sViewsWithIds.put(R.id.ch3_offset, 6);
        sViewsWithIds.put(R.id.ch1_offset_left, 7);
        sViewsWithIds.put(R.id.ch1_offset_left2, 8);
        sViewsWithIds.put(R.id.ch3_offset2, 9);
        sViewsWithIds.put(R.id.ch1_offset_left3, 10);
        sViewsWithIds.put(R.id.ch1_offset_left7, 11);
        sViewsWithIds.put(R.id.ch1_text, 12);
        sViewsWithIds.put(R.id.ch2_text, 13);
        sViewsWithIds.put(R.id.ch3_text, 14);
        sViewsWithIds.put(R.id.ch4_text, 15);
        sViewsWithIds.put(R.id.ch3_scale_text, 16);
        sViewsWithIds.put(R.id.ch1_scale_left3_text, 17);
        sViewsWithIds.put(R.id.ch1_scale_left7_text, 18);
        sViewsWithIds.put(R.id.RUN, 19);
        sViewsWithIds.put(R.id.RUN1, 20);
        sViewsWithIds.put(R.id.RUN2, 21);
        sViewsWithIds.put(R.id.ch3_offset_text, 22);
        sViewsWithIds.put(R.id.ch1_offset_left3_text, 23);
        sViewsWithIds.put(R.id.ch1_offset_left7_text, 24);
        sViewsWithIds.put(R.id.math_text, 25);
        sViewsWithIds.put(R.id.ref_text, 26);
        sViewsWithIds.put(R.id.la_text, 27);
        sViewsWithIds.put(R.id.gi_text, 28);
        sViewsWithIds.put(R.id.postion_offset, 29);
        sViewsWithIds.put(R.id.postion__offset_left, 30);
        sViewsWithIds.put(R.id.postion_offset_left2, 31);
        sViewsWithIds.put(R.id.acquire_text, 32);
        sViewsWithIds.put(R.id.search_text, 33);
        sViewsWithIds.put(R.id.play_offset, 34);
        sViewsWithIds.put(R.id.play__offset_left, 35);
        sViewsWithIds.put(R.id.play_offset_left2, 36);
        sViewsWithIds.put(R.id.h_scale_offset, 37);
        sViewsWithIds.put(R.id.h_scale_offset_left, 38);
        sViewsWithIds.put(R.id.h_scale_offset_left2, 39);
        sViewsWithIds.put(R.id.touch_lock_text, 40);
        sViewsWithIds.put(R.id.quick_text, 41);
        sViewsWithIds.put(R.id.RUN5, 42);
        sViewsWithIds.put(R.id.RUN3, 43);
        sViewsWithIds.put(R.id.RUN4, 44);
        sViewsWithIds.put(R.id.RUN6, 45);
        sViewsWithIds.put(R.id.RUN7, 46);
        sViewsWithIds.put(R.id.trigger_text, 47);
        sViewsWithIds.put(R.id.trigger_offset, 48);
        sViewsWithIds.put(R.id.trigge_offset_left, 49);
        sViewsWithIds.put(R.id.trigge_offset_left2, 50);
        sViewsWithIds.put(R.id.slope_text, 51);
        sViewsWithIds.put(R.id.force_text, 52);
    }

    public ActivityRigolKeyTest3BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 53, sIncludes, sViewsWithIds));
    }

    private ActivityRigolKeyTest3BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[19], (TextView) objArr[20], (TextView) objArr[21], (TextView) objArr[43], (TextView) objArr[44], (TextView) objArr[42], (TextView) objArr[45], (TextView) objArr[46], (TextView) objArr[32], (ImageButton) objArr[7], (ImageButton) objArr[8], (ImageButton) objArr[10], (ImageButton) objArr[23], (ImageButton) objArr[11], (ImageButton) objArr[24], (ImageButton) objArr[17], (ImageButton) objArr[18], (TextView) objArr[12], (TextView) objArr[13], (TextView) objArr[6], (TextView) objArr[9], (TextView) objArr[22], (TextView) objArr[16], (TextView) objArr[14], (TextView) objArr[15], (TextView) objArr[1], (TextView) objArr[52], (TextView) objArr[28], (TextView) objArr[37], (ImageButton) objArr[38], (ImageButton) objArr[39], (TextView) objArr[27], (Guideline) objArr[2], (Guideline) objArr[3], (Guideline) objArr[4], (ImageView) objArr[5], (TextView) objArr[25], (TextView) objArr[34], (TextView) objArr[35], (TextView) objArr[36], (TextView) objArr[29], (ImageButton) objArr[30], (ImageButton) objArr[31], (TextView) objArr[41], (TextView) objArr[26], (TextView) objArr[33], (TextView) objArr[51], (TextView) objArr[40], (ImageButton) objArr[49], (ImageButton) objArr[50], (TextView) objArr[48], (TextView) objArr[47]);
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

    @Override // com.rigol.scope.databinding.ActivityRigolKeyTest3Binding
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
