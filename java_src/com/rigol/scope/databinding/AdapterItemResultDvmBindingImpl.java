package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.DvmResultParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.views.resultItem.ResultItemConstraintLayout;
/* loaded from: classes2.dex */
public class AdapterItemResultDvmBindingImpl extends AdapterItemResultDvmBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ResultItemConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_layout, 6);
        sViewsWithIds.put(R.id.result_layout, 7);
        sViewsWithIds.put(R.id.mode_title, 8);
        sViewsWithIds.put(R.id.mode_title_bw, 9);
    }

    public AdapterItemResultDvmBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private AdapterItemResultDvmBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (TextView) objArr[3], (ImageView) objArr[1], (TextView) objArr[4], (TextView) objArr[8], (TextView) objArr[9], (TextView) objArr[5], (ConstraintLayout) objArr[7], (TextView) objArr[2], (ConstraintLayout) objArr[6]);
        this.mDirtyFlags = -1L;
        this.currentResult.setTag(null);
        this.icon.setTag(null);
        ResultItemConstraintLayout resultItemConstraintLayout = (ResultItemConstraintLayout) objArr[0];
        this.mboundView0 = resultItemConstraintLayout;
        resultItemConstraintLayout.setTag(null);
        this.mode.setTag(null);
        this.modeWb.setTag(null);
        this.title.setTag(null);
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
            setParam((DvmResultParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterItemResultDvmBinding
    public void setParam(DvmResultParam dvmResultParam) {
        updateRegistration(0, dvmResultParam);
        this.mParam = dvmResultParam;
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
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDvmModeParamDvmModeValue1((MappingObject) obj, i2);
        }
        return onChangeParam((DvmResultParam) obj, i2);
    }

    private boolean onChangeParam(DvmResultParam dvmResultParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 528) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 939) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 862) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 252) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDvmModeParamDvmModeValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    /* JADX WARN: Removed duplicated region for block: B:102:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x016e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterItemResultDvmBindingImpl.executeBindings():void");
    }
}
