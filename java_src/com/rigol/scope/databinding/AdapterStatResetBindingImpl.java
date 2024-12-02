package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UtilityParam;

/* loaded from: classes2.dex */
public class AdapterStatResetBindingImpl extends AdapterStatResetBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_stat_reset, 3);
        sViewsWithIds.put(R.id.statReset_radio_group, 4);
    }

    public AdapterStatResetBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private AdapterStatResetBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (RadioButton) objArr[2], (RadioButton) objArr[1], (RadioGroup) objArr[4], (TextView) objArr[3]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.radioButtonMask.setTag(null);
        this.radioButtonMeasure.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64L;
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
        if (9 == i) {
            setMaskMapping((MappingObject) obj);
        } else if (10 == i) {
            setMeasureMapping((MappingObject) obj);
        } else if (594 != i) {
            return false;
        } else {
            setParam((UtilityParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterStatResetBinding
    public void setMaskMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mMaskMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(9);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterStatResetBinding
    public void setMeasureMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mMeasureMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterStatResetBinding
    public void setParam(UtilityParam utilityParam) {
        updateRegistration(2, utilityParam);
        this.mParam = utilityParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeParam((UtilityParam) obj, i2);
            }
            return onChangeMeasureMapping((MappingObject) obj, i2);
        }
        return onChangeMaskMapping((MappingObject) obj, i2);
    }

    private boolean onChangeMaskMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
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

    private boolean onChangeMeasureMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(UtilityParam utilityParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 905) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mMaskMapping;
        MappingObject mappingObject2 = this.mMeasureMapping;
        UtilityParam utilityParam = this.mParam;
        int i = ((73 & j) > 0L ? 1 : ((73 & j) == 0L ? 0 : -1));
        String str = (i == 0 || mappingObject == null) ? null : mappingObject.getStr();
        int i2 = ((82 & j) > 0L ? 1 : ((82 & j) == 0L ? 0 : -1));
        String str2 = (i2 == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        int i3 = ((j & 100) > 0L ? 1 : ((j & 100) == 0L ? 0 : -1));
        boolean z2 = false;
        if (i3 != 0) {
            ServiceEnum.UtilityQuickStatReset statReset = utilityParam != null ? utilityParam.getStatReset() : null;
            z = statReset == ServiceEnum.UtilityQuickStatReset.Measure;
            if (statReset == ServiceEnum.UtilityQuickStatReset.PassFail) {
                z2 = true;
            }
        } else {
            z = false;
        }
        if (i3 != 0) {
            CompoundButtonBindingAdapter.setChecked(this.radioButtonMask, z2);
            CompoundButtonBindingAdapter.setChecked(this.radioButtonMeasure, z);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.radioButtonMask, str);
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.radioButtonMeasure, str2);
        }
    }
}
