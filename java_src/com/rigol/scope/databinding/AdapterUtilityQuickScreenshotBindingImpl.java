package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
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
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            r17 = this;
            r1 = r17
            monitor-enter(r17)
            long r2 = r1.mDirtyFlags     // Catch: java.lang.Throwable -> L9a
            r4 = 0
            r1.mDirtyFlags = r4     // Catch: java.lang.Throwable -> L9a
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L9a
            com.rigol.scope.data.StorageSaveParam r0 = r1.mParam
            r6 = 31
            long r6 = r6 & r2
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r7 = 25
            r9 = 21
            r11 = 19
            if (r6 == 0) goto L69
            long r14 = r2 & r9
            int r6 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r6 == 0) goto L26
            if (r0 == 0) goto L26
            boolean r6 = r0.isImageInvert()
            goto L27
        L26:
            r6 = 0
        L27:
            long r14 = r2 & r7
            int r14 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r14 == 0) goto L34
            if (r0 == 0) goto L34
            boolean r14 = r0.isImageColor()
            goto L35
        L34:
            r14 = 0
        L35:
            long r15 = r2 & r11
            int r15 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r15 == 0) goto L66
            if (r0 == 0) goto L42
            int r0 = r0.getImageFileType()
            goto L43
        L42:
            r0 = 0
        L43:
            com.rigol.scope.cil.ServiceEnum$enFileType r15 = com.rigol.scope.cil.ServiceEnum.enFileType.FILETYPE_PNG
            int r15 = r15.value1
            r16 = 1
            if (r0 != r15) goto L4e
            r15 = r16
            goto L4f
        L4e:
            r15 = 0
        L4f:
            com.rigol.scope.cil.ServiceEnum$enFileType r13 = com.rigol.scope.cil.ServiceEnum.enFileType.FILETYPE_JPG
            int r13 = r13.value1
            if (r0 != r13) goto L58
            r13 = r16
            goto L59
        L58:
            r13 = 0
        L59:
            com.rigol.scope.cil.ServiceEnum$enFileType r9 = com.rigol.scope.cil.ServiceEnum.enFileType.FILETYPE_BMP
            int r9 = r9.value1
            if (r0 != r9) goto L60
            goto L62
        L60:
            r16 = 0
        L62:
            r0 = r13
            r13 = r16
            goto L6e
        L66:
            r0 = 0
            r13 = 0
            goto L6d
        L69:
            r0 = 0
            r6 = 0
            r13 = 0
            r14 = 0
        L6d:
            r15 = 0
        L6e:
            long r9 = r2 & r11
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 == 0) goto L83
            android.widget.RadioButton r9 = r1.radioButtonBmp
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(r9, r13)
            android.widget.RadioButton r9 = r1.radioButtonJpg
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(r9, r0)
            android.widget.RadioButton r0 = r1.radioButtonPng
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(r0, r15)
        L83:
            long r7 = r7 & r2
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 == 0) goto L8d
            com.rigol.scope.views.SwitchButton r0 = r1.switchButtonImagecolor
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(r0, r14)
        L8d:
            r7 = 21
            long r2 = r2 & r7
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L99
            com.rigol.scope.views.SwitchButton r0 = r1.switchButtonInvert
            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(r0, r6)
        L99:
            return
        L9a:
            r0 = move-exception
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L9a
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterUtilityQuickScreenshotBindingImpl.executeBindings():void");
    }
}
