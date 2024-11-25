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
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ViewUtil;
/* loaded from: classes2.dex */
public class AdapterUtilityAllmeasureBindingImpl extends AdapterUtilityAllmeasureBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_allmeasure, 2);
    }

    public AdapterUtilityAllmeasureBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private AdapterUtilityAllmeasureBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (TextView) objArr[2], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvAllmeasureValue.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8L;
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

    @Override // com.rigol.scope.databinding.AdapterUtilityAllmeasureBinding
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
            if (i != 1) {
                return false;
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgQuickMeasAllSrcParamMeasSrcValue1((MappingObject) obj, i2);
        }
        return onChangeParam((UtilityParam) obj, i2);
    }

    private boolean onChangeParam(UtilityParam utilityParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 527) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgQuickMeasAllSrcParamMeasSrcValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        UtilityParam utilityParam = this.mParam;
        int i = ((15 & j) > 0L ? 1 : ((15 & j) == 0L ? 0 : -1));
        String str = null;
        if (i != 0) {
            ServiceEnum.Chan measSrc = utilityParam != null ? utilityParam.getMeasSrc() : null;
            int i2 = measSrc != null ? measSrc.value1 : 0;
            r8 = (j & 13) != 0 ? ColorUtil.getColor(getRoot().getContext(), i2) : 0;
            MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_quick_meas_all_src, i2);
            updateRegistration(1, mappingObject);
            if (mappingObject != null) {
                str = mappingObject.getStr();
            }
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.tvAllmeasureValue, str);
        }
        if ((j & 13) != 0) {
            this.tvAllmeasureValue.setTextColor(r8);
        }
    }
}
