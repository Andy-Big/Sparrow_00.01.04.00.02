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
import com.rigol.scope.data.StorageLoadParam;
/* loaded from: classes2.dex */
public class PopupviewLoadBindingImpl extends PopupviewLoadBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 3);
        sViewsWithIds.put(R.id.file_format, 4);
        sViewsWithIds.put(R.id.file_path, 5);
        sViewsWithIds.put(R.id.load_btn, 6);
    }

    public PopupviewLoadBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private PopupviewLoadBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (TextView) objArr[4], (TextView) objArr[1], (TextView) objArr[5], (EditText) objArr[2], (Guideline) objArr[3], (Button) objArr[6]);
        this.mDirtyFlags = -1L;
        this.fileFormatSpinner.setTag(null);
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
            setParam((StorageLoadParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.PopupviewLoadBinding
    public void setParam(StorageLoadParam storageLoadParam) {
        updateRegistration(1, storageLoadParam);
        this.mParam = storageLoadParam;
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
            return onChangeParam((StorageLoadParam) obj, i2);
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

    private boolean onChangeParam(StorageLoadParam storageLoadParam, int i) {
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
        } else if (i == 603) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            r13 = this;
            monitor-enter(r13)
            long r0 = r13.mDirtyFlags     // Catch: java.lang.Throwable -> L60
            r2 = 0
            r13.mDirtyFlags = r2     // Catch: java.lang.Throwable -> L60
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L60
            com.rigol.scope.data.StorageLoadParam r4 = r13.mParam
            r5 = 63
            long r5 = r5 & r0
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            r6 = 50
            r8 = 47
            r10 = 0
            if (r5 == 0) goto L4a
            long r11 = r0 & r8
            int r5 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r5 == 0) goto L36
            r5 = 0
            if (r4 == 0) goto L24
            int r11 = r4.getFileType()
            goto L25
        L24:
            r11 = r5
        L25:
            r12 = 2130903496(0x7f0301c8, float:1.7413812E38)
            com.rigol.scope.data.MappingObject r11 = com.rigol.scope.utilities.ViewUtil.getMappingObject(r12, r11)
            r13.updateRegistration(r5, r11)
            if (r11 == 0) goto L36
            java.lang.String r5 = r11.getStr()
            goto L37
        L36:
            r5 = r10
        L37:
            long r11 = r0 & r6
            int r11 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r11 == 0) goto L47
            if (r4 == 0) goto L43
            java.lang.String r10 = r4.getPathName()
        L43:
            java.lang.String r10 = com.rigol.scope.utilities.ViewUtil.getDiskUIPathName(r10)
        L47:
            r4 = r10
            r10 = r5
            goto L4b
        L4a:
            r4 = r10
        L4b:
            long r8 = r8 & r0
            int r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r5 == 0) goto L55
            android.widget.TextView r5 = r13.fileFormatSpinner
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r5, r10)
        L55:
            long r0 = r0 & r6
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L5f
            android.widget.EditText r0 = r13.filePathText
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r4)
        L5f:
            return
        L60:
            r0 = move-exception
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L60
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewLoadBindingImpl.executeBindings():void");
    }
}
