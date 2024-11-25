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
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageSaveParam;
/* loaded from: classes2.dex */
public class PopupviewSaveBindingImpl extends PopupviewSaveBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 4);
        sViewsWithIds.put(R.id.file_format, 5);
        sViewsWithIds.put(R.id.file_name, 6);
        sViewsWithIds.put(R.id.file_path, 7);
        sViewsWithIds.put(R.id.save_btn, 8);
    }

    public PopupviewSaveBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private PopupviewSaveBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (TextView) objArr[5], (TextView) objArr[1], (TextView) objArr[6], (EditText) objArr[2], (TextView) objArr[7], (EditText) objArr[3], (Guideline) objArr[4], (Button) objArr[8]);
        this.mDirtyFlags = -1L;
        this.fileFormatSpinner.setTag(null);
        this.fileNameText.setTag(null);
        this.filePathText.setTag(null);
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
            setParam((StorageSaveParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.PopupviewSaveBinding
    public void setParam(StorageSaveParam storageSaveParam) {
        updateRegistration(1, storageSaveParam);
        this.mParam = storageSaveParam;
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
            return onChangeParam((StorageSaveParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageFiletypeParamFileType((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageFiletypeParamFileType(MappingObject mappingObject, int i) {
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

    private boolean onChangeParam(StorageSaveParam storageSaveParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 311) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 654) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 603) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
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
            long r2 = r1.mDirtyFlags     // Catch: java.lang.Throwable -> L7f
            r4 = 0
            r1.mDirtyFlags = r4     // Catch: java.lang.Throwable -> L7f
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L7f
            com.rigol.scope.data.StorageSaveParam r0 = r1.mParam
            r6 = 127(0x7f, double:6.27E-322)
            long r6 = r6 & r2
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r7 = 98
            r9 = 82
            r11 = 79
            r13 = 0
            if (r6 == 0) goto L5e
            long r14 = r2 & r11
            int r6 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r6 == 0) goto L3a
            r6 = 0
            if (r0 == 0) goto L28
            int r14 = r0.getFileType()
            goto L29
        L28:
            r14 = r6
        L29:
            r15 = 2130903496(0x7f0301c8, float:1.7413812E38)
            com.rigol.scope.data.MappingObject r14 = com.rigol.scope.utilities.ViewUtil.getMappingObject(r15, r14)
            r1.updateRegistration(r6, r14)
            if (r14 == 0) goto L3a
            java.lang.String r6 = r14.getStr()
            goto L3b
        L3a:
            r6 = r13
        L3b:
            long r14 = r2 & r7
            int r14 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r14 == 0) goto L4e
            if (r0 == 0) goto L48
            java.lang.String r14 = r0.getPathName()
            goto L49
        L48:
            r14 = r13
        L49:
            java.lang.String r14 = com.rigol.scope.utilities.ViewUtil.getDiskUIPathName(r14)
            goto L4f
        L4e:
            r14 = r13
        L4f:
            long r15 = r2 & r9
            int r15 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r15 == 0) goto L5b
            if (r0 == 0) goto L5b
            java.lang.String r13 = r0.getPrefix()
        L5b:
            r0 = r13
            r13 = r6
            goto L60
        L5e:
            r0 = r13
            r14 = r0
        L60:
            long r11 = r11 & r2
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 == 0) goto L6a
            android.widget.TextView r6 = r1.fileFormatSpinner
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r6, r13)
        L6a:
            long r9 = r9 & r2
            int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r6 == 0) goto L74
            android.widget.EditText r6 = r1.fileNameText
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r6, r0)
        L74:
            long r2 = r2 & r7
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L7e
            android.widget.EditText r0 = r1.filePathText
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r14)
        L7e:
            return
        L7f:
            r0 = move-exception
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L7f
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewSaveBindingImpl.executeBindings():void");
    }
}
