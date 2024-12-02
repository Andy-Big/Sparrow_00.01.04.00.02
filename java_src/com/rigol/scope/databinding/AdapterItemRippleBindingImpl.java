package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UpaParam;
import com.rigol.scope.data.UpaRippleParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ViewUtil;

/* loaded from: classes2.dex */
public class AdapterItemRippleBindingImpl extends AdapterItemRippleBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.right_guideline, 3);
        sViewsWithIds.put(R.id.left_guideline, 4);
        sViewsWithIds.put(R.id.left_guideline2, 5);
        sViewsWithIds.put(R.id.upa_spring, 6);
        sViewsWithIds.put(R.id.upa_spring1, 7);
        sViewsWithIds.put(R.id.upa_reccovery, 8);
        sViewsWithIds.put(R.id.upa_rippel_reccovery, 9);
    }

    public AdapterItemRippleBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private AdapterItemRippleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (Guideline) objArr[4], (Guideline) objArr[5], (Guideline) objArr[3], (Button) objArr[8], (Button) objArr[9], (EditText) objArr[2], (TextView) objArr[1], (TextView) objArr[6], (TextView) objArr[7]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.upaRippleEditText.setTag(null);
        this.upaRippleSpinner.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128L;
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
            setParam((UpaRippleParam) obj);
        } else if (992 == i) {
            setUpaMappingObj((MappingObject) obj);
        } else if (683 != i) {
            return false;
        } else {
            setQualityParam((UpaParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterItemRippleBinding
    public void setParam(UpaRippleParam upaRippleParam) {
        updateRegistration(0, upaRippleParam);
        this.mParam = upaRippleParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterItemRippleBinding
    public void setUpaMappingObj(MappingObject mappingObject) {
        this.mUpaMappingObj = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterItemRippleBinding
    public void setQualityParam(UpaParam upaParam) {
        this.mQualityParam = upaParam;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    return onChangeQualityParam((UpaParam) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaRippleSourceParamRefPowerCurr((MappingObject) obj, i2);
            }
            return onChangeUpaMappingObj((MappingObject) obj, i2);
        }
        return onChangeParam((UpaRippleParam) obj, i2);
    }

    private boolean onChangeParam(UpaRippleParam upaRippleParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 724) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 904) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeUpaMappingObj(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaRippleSourceParamRefPowerCurr(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeQualityParam(UpaParam upaParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        UpaRippleParam upaRippleParam = this.mParam;
        if ((245 & j) != 0) {
            if ((j & 213) != 0) {
                int refPowerCurr = upaRippleParam != null ? upaRippleParam.getRefPowerCurr() : 0;
                i = (j & 145) != 0 ? ColorUtil.getColor(getRoot().getContext(), ServiceEnum.getChanFromValue1(refPowerCurr)) : 0;
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_upa_ripple_source, refPowerCurr);
                updateRegistration(2, mappingObject);
                if (mappingObject != null) {
                    str = mappingObject.getStr();
                    if ((j & 161) == 0) {
                        r14 = i;
                        str2 = String.valueOf(upaRippleParam != null ? upaRippleParam.getStatCounts() : 0);
                        if ((161 & j) != 0) {
                            TextViewBindingAdapter.setText(this.upaRippleEditText, str2);
                        }
                        if ((213 & j) != 0) {
                            TextViewBindingAdapter.setText(this.upaRippleSpinner, str);
                        }
                        if ((j & 145) == 0) {
                            this.upaRippleSpinner.setTextColor(r14);
                            return;
                        }
                        return;
                    }
                    r14 = i;
                }
            } else {
                i = 0;
            }
            str = null;
            if ((j & 161) == 0) {
            }
        } else {
            str = null;
        }
        str2 = null;
        if ((161 & j) != 0) {
        }
        if ((213 & j) != 0) {
        }
        if ((j & 145) == 0) {
        }
    }
}
