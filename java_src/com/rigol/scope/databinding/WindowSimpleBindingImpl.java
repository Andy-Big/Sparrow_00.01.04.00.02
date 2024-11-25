package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.views.window.Window;
/* loaded from: classes2.dex */
public class WindowSimpleBindingImpl extends WindowSimpleBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

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
        sparseIntArray.put(R.id.title_layout, 1);
        sViewsWithIds.put(R.id.title, 2);
        sViewsWithIds.put(R.id.window_setting, 3);
        sViewsWithIds.put(R.id.window_move, 4);
        sViewsWithIds.put(R.id.window_close, 5);
        sViewsWithIds.put(R.id.content_layout, 6);
        sViewsWithIds.put(R.id.empty, 7);
        sViewsWithIds.put(R.id.loading, 8);
        sViewsWithIds.put(R.id.status, 9);
        sViewsWithIds.put(R.id.warning, 10);
    }

    public WindowSimpleBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private WindowSimpleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[6], (TextView) objArr[7], (TextView) objArr[8], (TextView) objArr[9], (TextView) objArr[2], (ConstraintLayout) objArr[1], (TextView) objArr[10], (ImageButton) objArr[5], (Window) objArr[0], (ImageButton) objArr[4], (ImageButton) objArr[3]);
        this.mDirtyFlags = -1L;
        this.windowLayout.setTag(null);
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
