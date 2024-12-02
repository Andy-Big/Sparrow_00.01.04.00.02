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
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.utilities.ViewUtil;

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
    */
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        StorageSaveParam storageSaveParam = this.mParam;
        String str4 = null;
        if ((127 & j) != 0) {
            if ((j & 79) != 0) {
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_storage_filetype, storageSaveParam != null ? storageSaveParam.getFileType() : 0);
                updateRegistration(0, mappingObject);
                if (mappingObject != null) {
                    str3 = mappingObject.getStr();
                    if ((j & 98) == 0) {
                        str2 = ViewUtil.getDiskUIPathName(storageSaveParam != null ? storageSaveParam.getPathName() : null);
                    } else {
                        str2 = null;
                    }
                    if ((j & 82) != 0 && storageSaveParam != null) {
                        str4 = storageSaveParam.getPrefix();
                    }
                    str = str4;
                    str4 = str3;
                }
            }
            str3 = null;
            if ((j & 98) == 0) {
            }
            if ((j & 82) != 0) {
                str4 = storageSaveParam.getPrefix();
            }
            str = str4;
            str4 = str3;
        } else {
            str = null;
            str2 = null;
        }
        if ((79 & j) != 0) {
            TextViewBindingAdapter.setText(this.fileFormatSpinner, str4);
        }
        if ((82 & j) != 0) {
            TextViewBindingAdapter.setText(this.fileNameText, str);
        }
        if ((j & 98) != 0) {
            TextViewBindingAdapter.setText(this.filePathText, str2);
        }
    }
}
