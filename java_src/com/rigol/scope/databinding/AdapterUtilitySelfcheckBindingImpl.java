package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public class AdapterUtilitySelfcheckBindingImpl extends AdapterUtilitySelfcheckBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.keycheck_layout, 1);
        sViewsWithIds.put(R.id.tv_keyboard_check, 2);
        sViewsWithIds.put(R.id.imageView12, 3);
        sViewsWithIds.put(R.id.touch_layout, 4);
        sViewsWithIds.put(R.id.tv_touch_test, 5);
        sViewsWithIds.put(R.id.imageView11, 6);
        sViewsWithIds.put(R.id.screen_layout, 7);
        sViewsWithIds.put(R.id.tv_screen_test, 8);
        sViewsWithIds.put(R.id.imageView13, 9);
        sViewsWithIds.put(R.id.self_test, 10);
        sViewsWithIds.put(R.id.tv_self_test, 11);
        sViewsWithIds.put(R.id.imageView6, 12);
    }

    public AdapterUtilitySelfcheckBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private AdapterUtilitySelfcheckBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[6], (ImageView) objArr[3], (ImageView) objArr[9], (ImageView) objArr[12], (ConstraintLayout) objArr[1], (ConstraintLayout) objArr[7], (ConstraintLayout) objArr[10], (ConstraintLayout) objArr[4], (TextView) objArr[2], (TextView) objArr[8], (TextView) objArr[11], (TextView) objArr[5]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
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
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
