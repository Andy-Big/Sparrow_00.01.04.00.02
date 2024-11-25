package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.MeasureSettingParam;
/* loaded from: classes2.dex */
public class FragmentResultsBarBindingImpl extends FragmentResultsBarBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final ImageView mboundView2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.result_layout, 3);
        sViewsWithIds.put(R.id.result_title_bg, 4);
        sViewsWithIds.put(R.id.result_list, 5);
    }

    public FragmentResultsBarBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private FragmentResultsBarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ConstraintLayout) objArr[3], (RecyclerView) objArr[5], (TextView) objArr[1], (View) objArr[4]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        this.resultTitle.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
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
        if (594 == i) {
            setParam((MeasureSettingParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.FragmentResultsBarBinding
    public void setParam(MeasureSettingParam measureSettingParam) {
        updateRegistration(0, measureSettingParam);
        this.mParam = measureSettingParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeParam((MeasureSettingParam) obj, i2);
    }

    private boolean onChangeParam(MeasureSettingParam measureSettingParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 544) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MeasureSettingParam measureSettingParam = this.mParam;
        int i2 = ((j & 7) > 0L ? 1 : ((j & 7) == 0L ? 0 : -1));
        if (i2 != 0) {
            int mode = measureSettingParam != null ? measureSettingParam.getMode() : 0;
            boolean z = mode == 1;
            boolean z2 = mode == 0;
            if (i2 != 0) {
                j |= z ? 16L : 8L;
            }
            if ((j & 7) != 0) {
                j |= z2 ? 64L : 32L;
            }
            int i3 = z ? 0 : 8;
            i = z2 ? 0 : 8;
            r8 = i3;
        } else {
            i = 0;
        }
        if ((j & 7) != 0) {
            this.mboundView2.setVisibility(r8);
            this.resultTitle.setVisibility(i);
        }
    }
}
