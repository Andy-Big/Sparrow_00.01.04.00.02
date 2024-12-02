package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.utilities.ViewUtil;

/* loaded from: classes2.dex */
public class AdapterItemSparrpwMathBindingImpl extends AdapterItemSparrpwMathBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public AdapterItemSparrpwMathBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, sIncludes, sViewsWithIds));
    }

    private AdapterItemSparrpwMathBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ConstraintLayout) objArr[0], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.itemView.setTag(null);
        this.text1.setTag(null);
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
            setParam((MathParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterItemSparrpwMathBinding
    public void setParam(MathParam mathParam) {
        updateRegistration(0, mathParam);
        this.mParam = mathParam;
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
            return onChangeViewUtilGetListComRigolScopeRArrayMsgMathList2GetParamGetServiceIdInt17((MappingObject) obj, i2);
        }
        return onChangeParam((MathParam) obj, i2);
    }

    private boolean onChangeParam(MathParam mathParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 909) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetListComRigolScopeRArrayMsgMathList2GetParamGetServiceIdInt17(MappingObject mappingObject, int i) {
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

    /* JADX WARN: Removed duplicated region for block: B:40:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        boolean z;
        String str;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MathParam mathParam = this.mParam;
        if ((31 & j) != 0) {
            int i2 = ((j & 21) > 0L ? 1 : ((j & 21) == 0L ? 0 : -1));
            if (i2 != 0) {
                z = mathParam != null ? mathParam.getStatus() : false;
                if (i2 != 0) {
                    j = z ? j | 64 : j | 32;
                }
            } else {
                z = false;
            }
            if ((j & 27) != 0) {
                MappingObject mappingObject = ViewUtil.getList((int) R.array.msg_math_list2).get((mathParam != null ? mathParam.getServiceId() : 0) - 17);
                updateRegistration(1, mappingObject);
                if (mappingObject != null) {
                    str = mappingObject.getStr();
                    i = ((j & 21) > 0L ? 1 : ((j & 21) == 0L ? 0 : -1));
                    int defaultColor = i != 0 ? z ? ((64 & j) != 0 || mathParam == null) ? 0 : mathParam.getDefaultColor() : ((32 & j) != 0 || mathParam == null) ? 0 : mathParam.getClosedColor() : 0;
                    if (i != 0) {
                        ViewBindingAdapter.setBackground(this.text1, Converters.convertColorToDrawable(defaultColor));
                    }
                    if ((j & 27) == 0) {
                        TextViewBindingAdapter.setText(this.text1, str);
                        return;
                    }
                    return;
                }
            }
        } else {
            z = false;
        }
        str = null;
        if ((32 & j) != 0) {
        }
        i = ((j & 21) > 0L ? 1 : ((j & 21) == 0L ? 0 : -1));
        if (i != 0) {
        }
        if (i != 0) {
        }
        if ((j & 27) == 0) {
        }
    }
}
