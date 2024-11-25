package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.JitterParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ViewUtil;
/* loaded from: classes2.dex */
public class AdapterJitterExplicitBindingImpl extends AdapterJitterExplicitBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.jitter_explicit_layout, 2);
        sViewsWithIds.put(R.id.jitter_external_clock_source_label, 3);
    }

    public AdapterJitterExplicitBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private AdapterJitterExplicitBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ConstraintLayout) objArr[2], (TextView) objArr[3], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.jitterExternalClockSourceValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16L;
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
            setParam((JitterParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterJitterExplicitBinding
    public void setParam(JitterParam jitterParam) {
        updateRegistration(0, jitterParam);
        this.mParam = jitterParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                return false;
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterExternalClockSrcParamExternalClockValue1((MappingObject) obj, i2);
        }
        return onChangeParam((JitterParam) obj, i2);
    }

    private boolean onChangeParam(JitterParam jitterParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 292) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterExternalClockSrcParamExternalClockValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
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
        JitterParam jitterParam = this.mParam;
        int i = ((31 & j) > 0L ? 1 : ((31 & j) == 0L ? 0 : -1));
        int i2 = 0;
        if (i != 0) {
            ServiceEnum.Chan externalClock = jitterParam != null ? jitterParam.getExternalClock() : null;
            MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_jitter_external_clock_src, externalClock != null ? externalClock.value1 : 0);
            updateRegistration(1, mappingObject);
            r9 = mappingObject != null ? mappingObject.getStr() : null;
            if ((j & 21) != 0) {
                i2 = ColorUtil.getColor(getRoot().getContext(), externalClock);
            }
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.jitterExternalClockSourceValue, r9);
        }
        if ((j & 21) != 0) {
            this.jitterExternalClockSourceValue.setTextColor(i2);
        }
    }
}
