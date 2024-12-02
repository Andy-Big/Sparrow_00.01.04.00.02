package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;

/* loaded from: classes2.dex */
public class PopupviewPowerBindingImpl extends PopupviewPowerBinding {
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
        sparseIntArray.put(R.id.guideline_center, 1);
        sViewsWithIds.put(R.id.guideline_left, 2);
        sViewsWithIds.put(R.id.guideline_right, 3);
        sViewsWithIds.put(R.id.title, 4);
        sViewsWithIds.put(R.id.icon_sleep, 5);
        sViewsWithIds.put(R.id.icon_shutdown, 6);
        sViewsWithIds.put(R.id.icon_restart, 7);
        sViewsWithIds.put(R.id.dividing_line, 8);
        sViewsWithIds.put(R.id.button_sleep, 9);
        sViewsWithIds.put(R.id.button_shutdowm, 10);
        sViewsWithIds.put(R.id.button_restart, 11);
    }

    public PopupviewPowerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private PopupviewPowerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[11], (Button) objArr[10], (Button) objArr[9], (View) objArr[8], (Guideline) objArr[1], (Guideline) objArr[2], (Guideline) objArr[3], (ImageView) objArr[7], (ImageView) objArr[6], (ImageView) objArr[5], (TextView) objArr[4]);
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
