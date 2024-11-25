package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class MathRecyclerviewBindingImpl extends MathRecyclerviewBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.math_guideline_center, 3);
        sViewsWithIds.put(R.id.operation, 4);
        sViewsWithIds.put(R.id.operator, 5);
        sViewsWithIds.put(R.id.math_viewRecycle, 6);
    }

    public MathRecyclerviewBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private MathRecyclerviewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (Guideline) objArr[3], (ConstraintLayout) objArr[0], (RecyclerView) objArr[6], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[2], (SwitchButton) objArr[1]);
        this.mDirtyFlags = -1L;
        this.mathView.setTag(null);
        this.operatorSpinner.setTag(null);
        this.operatorSwitch.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32L;
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
            setParam((MathParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.MathRecyclerviewBinding
    public void setParam(MathParam mathParam) {
        updateRegistration(1, mathParam);
        this.mParam = mathParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
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
            return onChangeParam((MathParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgMathOperatorParamOperatorValue1((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgMathOperatorParamOperatorValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(MathParam mathParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 909) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 573) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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
        MathParam mathParam = this.mParam;
        String str = null;
        boolean z = false;
        if ((63 & j) != 0) {
            boolean status = ((j & 42) == 0 || mathParam == null) ? false : mathParam.getStatus();
            if ((j & 55) != 0) {
                ServiceEnum.MathOperator operator = mathParam != null ? mathParam.getOperator() : null;
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_math_operator, operator != null ? operator.value1 : 0);
                updateRegistration(0, mappingObject);
                if (mappingObject != null) {
                    str = mappingObject.getStr();
                }
            }
            z = status;
        }
        if ((j & 55) != 0) {
            TextViewBindingAdapter.setText(this.operatorSpinner, str);
        }
        if ((j & 42) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.operatorSwitch, z);
        }
    }
}
