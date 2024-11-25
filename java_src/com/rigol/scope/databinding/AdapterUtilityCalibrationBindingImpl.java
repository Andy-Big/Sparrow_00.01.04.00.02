package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.UtilityParam;
/* loaded from: classes2.dex */
public class AdapterUtilityCalibrationBindingImpl extends AdapterUtilityCalibrationBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.notice, 3);
        sViewsWithIds.put(R.id.notice_content, 4);
        sViewsWithIds.put(R.id.image, 5);
        sViewsWithIds.put(R.id.dividing, 6);
        sViewsWithIds.put(R.id.start, 7);
        sViewsWithIds.put(R.id.cal_load_user, 8);
        sViewsWithIds.put(R.id.cal_load_default, 9);
        sViewsWithIds.put(R.id.cal_export, 10);
    }

    public AdapterUtilityCalibrationBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private AdapterUtilityCalibrationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (Button) objArr[10], (TextView) objArr[1], (RecyclerView) objArr[2], (Button) objArr[9], (Button) objArr[8], (View) objArr[6], (ImageView) objArr[5], (TextView) objArr[3], (TextView) objArr[4], (Button) objArr[7]);
        this.mDirtyFlags = -1L;
        this.calItems.setTag(null);
        this.calItemsList.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
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
            setParam((UtilityParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterUtilityCalibrationBinding
    public void setParam(UtilityParam utilityParam) {
        updateRegistration(0, utilityParam);
        this.mParam = utilityParam;
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
        return onChangeParam((UtilityParam) obj, i2);
    }

    private boolean onChangeParam(UtilityParam utilityParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 677) {
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        UtilityParam utilityParam = this.mParam;
        int i = ((j & 7) > 0L ? 1 : ((j & 7) == 0L ? 0 : -1));
        int i2 = 0;
        if (i != 0) {
            boolean projectMode = utilityParam != null ? utilityParam.getProjectMode() : false;
            if (i != 0) {
                j |= projectMode ? 16L : 8L;
            }
            if (!projectMode) {
                i2 = 8;
            }
        }
        if ((j & 7) != 0) {
            this.calItems.setVisibility(i2);
            this.calItemsList.setVisibility(i2);
        }
    }
}
