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
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.views.SwitchButton;

/* loaded from: classes2.dex */
public class AdapterUtilityQuickScreenshotBindingImpl extends AdapterUtilityQuickScreenshotBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_imagetype, 6);
        sViewsWithIds.put(R.id.radiogroup_image_type, 7);
        sViewsWithIds.put(R.id.inverse_layout, 8);
        sViewsWithIds.put(R.id.tv_invert, 9);
        sViewsWithIds.put(R.id.color_layout, 10);
        sViewsWithIds.put(R.id.tv_imgecolor, 11);
    }

    public AdapterUtilityQuickScreenshotBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private AdapterUtilityQuickScreenshotBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ConstraintLayout) objArr[10], (ConstraintLayout) objArr[8], (RadioButton) objArr[2], (RadioButton) objArr[3], (RadioButton) objArr[1], (RadioGroup) objArr[7], (SwitchButton) objArr[5], (SwitchButton) objArr[4], (TextView) objArr[6], (TextView) objArr[11], (TextView) objArr[9]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.radioButtonBmp.setTag(null);
        this.radioButtonJpg.setTag(null);
        this.radioButtonPng.setTag(null);
        this.switchButtonImagecolor.setTag(null);
        this.switchButtonInvert.setTag(null);
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
            setParam((StorageSaveParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterUtilityQuickScreenshotBinding
    public void setParam(StorageSaveParam storageSaveParam) {
        updateRegistration(0, storageSaveParam);
        this.mParam = storageSaveParam;
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
        return onChangeParam((StorageSaveParam) obj, i2);
    }

    private boolean onChangeParam(StorageSaveParam storageSaveParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 428) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 430) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 427) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        StorageSaveParam storageSaveParam = this.mParam;
        if ((31 & j) != 0) {
            z2 = ((j & 21) == 0 || storageSaveParam == null) ? false : storageSaveParam.isImageInvert();
            z4 = ((j & 25) == 0 || storageSaveParam == null) ? false : storageSaveParam.isImageColor();
            if ((j & 19) != 0) {
                int imageFileType = storageSaveParam != null ? storageSaveParam.getImageFileType() : 0;
                z5 = imageFileType == ServiceEnum.enFileType.FILETYPE_PNG.value1;
                boolean z6 = imageFileType == ServiceEnum.enFileType.FILETYPE_JPG.value1;
                boolean z7 = imageFileType == ServiceEnum.enFileType.FILETYPE_BMP.value1;
                z = z6;
                z3 = z7;
                if ((j & 19) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.radioButtonBmp, z3);
                    CompoundButtonBindingAdapter.setChecked(this.radioButtonJpg, z);
                    CompoundButtonBindingAdapter.setChecked(this.radioButtonPng, z5);
                }
                if ((25 & j) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.switchButtonImagecolor, z4);
                }
                if ((j & 21) == 0) {
                    CompoundButtonBindingAdapter.setChecked(this.switchButtonInvert, z2);
                    return;
                }
                return;
            }
            z = false;
            z3 = false;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
        }
        z5 = false;
        if ((j & 19) != 0) {
        }
        if ((25 & j) != 0) {
        }
        if ((j & 21) == 0) {
        }
    }
}
