package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public class PopupviewBoardTestBindingImpl extends PopupviewBoardTestBinding {
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
        sparseIntArray.put(R.id.tv_self_test_item, 1);
        sViewsWithIds.put(R.id.tv_item_value, 2);
        sViewsWithIds.put(R.id.tv_self_range, 3);
        sViewsWithIds.put(R.id.self_test_recycler, 4);
        sViewsWithIds.put(R.id.tv_warning, 5);
        sViewsWithIds.put(R.id.divider5, 6);
        sViewsWithIds.put(R.id.textView14, 7);
        sViewsWithIds.put(R.id.divider6, 8);
        sViewsWithIds.put(R.id.textView48, 9);
        sViewsWithIds.put(R.id.textView52, 10);
        sViewsWithIds.put(R.id.textView57, 11);
        sViewsWithIds.put(R.id.textView59, 12);
    }

    public PopupviewBoardTestBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private PopupviewBoardTestBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[6], (View) objArr[8], (RecyclerView) objArr[4], (TextView) objArr[7], (TextView) objArr[9], (TextView) objArr[10], (TextView) objArr[11], (TextView) objArr[12], (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[1], (TextView) objArr[5]);
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
