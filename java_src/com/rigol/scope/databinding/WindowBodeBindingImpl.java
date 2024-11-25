package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.views.acquire.AcquireDepthView;
import com.rigol.scope.views.window.Window;
/* loaded from: classes2.dex */
public class WindowBodeBindingImpl extends WindowBodeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_layout, 1);
        sViewsWithIds.put(R.id.title, 2);
        sViewsWithIds.put(R.id.acquire_depth, 3);
        sViewsWithIds.put(R.id.window_setting, 4);
        sViewsWithIds.put(R.id.window_move, 5);
        sViewsWithIds.put(R.id.window_close, 6);
        sViewsWithIds.put(R.id.content_layout, 7);
        sViewsWithIds.put(R.id.bode_list, 8);
    }

    public WindowBodeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private WindowBodeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (AcquireDepthView) objArr[3], (RecyclerView) objArr[8], (ConstraintLayout) objArr[7], (TextView) objArr[2], (ConstraintLayout) objArr[1], (ImageButton) objArr[6], (Window) objArr[0], (ImageButton) objArr[5], (ImageButton) objArr[4]);
        this.mDirtyFlags = -1L;
        this.windowLayout.setTag(null);
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
        if (823 == i) {
            setSharedParam((SharedParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.WindowBodeBinding
    public void setSharedParam(SharedParam sharedParam) {
        this.mSharedParam = sharedParam;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeSharedParam((SharedParam) obj, i2);
    }

    private boolean onChangeSharedParam(SharedParam sharedParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
