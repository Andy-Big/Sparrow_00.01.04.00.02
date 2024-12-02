package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.BaseProperty;
import com.rigol.scope.data.EyeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ViewUtil;

/* loaded from: classes2.dex */
public class AdapterEyeExplicitBindingImpl extends AdapterEyeExplicitBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.eye_explicit_layout, 2);
        sViewsWithIds.put(R.id.right_guideline, 3);
        sViewsWithIds.put(R.id.eye_external_clock_source_label, 4);
    }

    public AdapterEyeExplicitBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private AdapterEyeExplicitBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ConstraintLayout) objArr[2], (TextView) objArr[4], (TextView) objArr[1], (Guideline) objArr[3]);
        this.mDirtyFlags = -1L;
        this.eyeExternalClockSourceValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
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
        if (594 == i) {
            setParam((EyeParam) obj);
        } else if (569 != i) {
            return false;
        } else {
            setOnClickListener((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterEyeExplicitBinding
    public void setParam(EyeParam eyeParam) {
        updateRegistration(1, eyeParam);
        this.mParam = eyeParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterEyeExplicitBinding
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(569);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeParamChanExternalClock((BaseProperty) obj, i2);
            }
            return onChangeParam((EyeParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgEyeExternalClockSrcParamChanExternalClockValue((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgEyeExternalClockSrcParamChanExternalClockValue(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
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

    private boolean onChangeParam(EyeParam eyeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParamChanExternalClock(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 1015) {
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        EyeParam eyeParam = this.mParam;
        View.OnClickListener onClickListener = this.mOnClickListener;
        int i = ((119 & j) > 0L ? 1 : ((119 & j) == 0L ? 0 : -1));
        int i2 = 0;
        if (i != 0) {
            BaseProperty<Integer> chanExternalClock = eyeParam != null ? eyeParam.getChanExternalClock() : null;
            updateRegistration(2, chanExternalClock);
            int safeUnbox = ViewDataBinding.safeUnbox(chanExternalClock != null ? chanExternalClock.getValue() : null);
            MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_eye_external_clock_src, safeUnbox);
            updateRegistration(0, mappingObject);
            r10 = mappingObject != null ? mappingObject.getStr() : null;
            if ((j & 102) != 0) {
                i2 = ColorUtil.getColor(getRoot().getContext(), ServiceEnum.getChanFromValue1(safeUnbox));
            }
        }
        if ((72 & j) != 0) {
            this.eyeExternalClockSourceValue.setOnClickListener(onClickListener);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.eyeExternalClockSourceValue, r10);
        }
        if ((j & 102) != 0) {
            this.eyeExternalClockSourceValue.setTextColor(i2);
        }
    }
}
