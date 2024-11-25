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
public class AdapterWaveSaveBindingImpl extends AdapterWaveSaveBinding {
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
        sparseIntArray.put(R.id.layout_sourcefrom, 1);
        sViewsWithIds.put(R.id.textView25, 2);
        sViewsWithIds.put(R.id.imageView3, 3);
        sViewsWithIds.put(R.id.tv_sourcefrom, 4);
        sViewsWithIds.put(R.id.layout_fromat, 5);
        sViewsWithIds.put(R.id.textView27, 6);
        sViewsWithIds.put(R.id.tv_formatValue, 7);
        sViewsWithIds.put(R.id.imageView5, 8);
        sViewsWithIds.put(R.id.layout_save_channel, 9);
        sViewsWithIds.put(R.id.textView29, 10);
        sViewsWithIds.put(R.id.tv_savechannel, 11);
    }

    public AdapterWaveSaveBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private AdapterWaveSaveBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3], (ImageView) objArr[8], (ConstraintLayout) objArr[5], (ConstraintLayout) objArr[9], (ConstraintLayout) objArr[1], (TextView) objArr[2], (TextView) objArr[6], (TextView) objArr[10], (TextView) objArr[7], (TextView) objArr[11], (TextView) objArr[4]);
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
