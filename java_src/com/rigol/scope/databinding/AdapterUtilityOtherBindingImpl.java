package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class AdapterUtilityOtherBindingImpl extends AdapterUtilityOtherBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.filter1_layout, 8);
        sViewsWithIds.put(R.id.tv_filter1, 9);
        sViewsWithIds.put(R.id.tv_filter2, 10);
        sViewsWithIds.put(R.id.refClock_layout, 11);
        sViewsWithIds.put(R.id.refClock, 12);
        sViewsWithIds.put(R.id.zbd_layout, 13);
        sViewsWithIds.put(R.id.zbd, 14);
        sViewsWithIds.put(R.id.open_source_license_layout, 15);
        sViewsWithIds.put(R.id.open_source_license, 16);
        sViewsWithIds.put(R.id.imageView11, 17);
    }

    public AdapterUtilityOtherBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 18, sIncludes, sViewsWithIds));
    }

    private AdapterUtilityOtherBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ConstraintLayout) objArr[8], (ConstraintLayout) objArr[2], (TextView) objArr[6], (TextView) objArr[7], (ImageView) objArr[17], (TextView) objArr[16], (ConstraintLayout) objArr[15], (TextView) objArr[12], (ConstraintLayout) objArr[11], (SwitchButton) objArr[1], (SwitchButton) objArr[3], (SwitchButton) objArr[4], (SwitchButton) objArr[5], (TextView) objArr[9], (TextView) objArr[10], (TextView) objArr[14], (ConstraintLayout) objArr[13]);
        this.mDirtyFlags = -1L;
        this.filter2Layout.setTag(null);
        this.hdmi.setTag(null);
        this.hdmiSpinner.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.switchButtonFilter1.setTag(null);
        this.switchButtonFilter2.setTag(null);
        this.switchButtonRefClock.setTag(null);
        this.switchButtonZbd.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 512L;
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
        if (1013 == i) {
            setUtilityParam((UtilityParam) obj);
        } else if (382 != i) {
            return false;
        } else {
            setHorizontalParam((HorizontalParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterUtilityOtherBinding
    public void setUtilityParam(UtilityParam utilityParam) {
        updateRegistration(0, utilityParam);
        this.mUtilityParam = utilityParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1013);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterUtilityOtherBinding
    public void setHorizontalParam(HorizontalParam horizontalParam) {
        updateRegistration(2, horizontalParam);
        this.mHorizontalParam = horizontalParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(382);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeHorizontalParam((HorizontalParam) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAppUtilityHdmiRatioUtilityParamHdmiRatioValue1((MappingObject) obj, i2);
        }
        return onChangeUtilityParam((UtilityParam) obj, i2);
    }

    private boolean onChangeUtilityParam(UtilityParam utilityParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 677) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 715) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 1087) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 368) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAppUtilityHdmiRatioUtilityParamHdmiRatioValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeHorizontalParam(HorizontalParam horizontalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 312) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 313) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0067 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0076  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterUtilityOtherBindingImpl.executeBindings():void");
    }
}
