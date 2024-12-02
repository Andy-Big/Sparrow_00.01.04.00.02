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
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.NumberProgressBar;

/* loaded from: classes2.dex */
public class PopupviewDdrBindingImpl extends PopupviewDdrBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 4);
        sViewsWithIds.put(R.id.start_addr, 5);
        sViewsWithIds.put(R.id.start_addr_text, 6);
        sViewsWithIds.put(R.id.size, 7);
        sViewsWithIds.put(R.id.size_text, 8);
        sViewsWithIds.put(R.id.file_name, 9);
        sViewsWithIds.put(R.id.file_path, 10);
        sViewsWithIds.put(R.id.save_btn, 11);
        sViewsWithIds.put(R.id.load_btn, 12);
    }

    public PopupviewDdrBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private PopupviewDdrBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[9], (EditText) objArr[1], (TextView) objArr[10], (EditText) objArr[2], (Guideline) objArr[4], (Button) objArr[12], (NumberProgressBar) objArr[3], (Button) objArr[11], (TextView) objArr[7], (EditText) objArr[8], (TextView) objArr[5], (EditText) objArr[6]);
        this.mDirtyFlags = -1L;
        this.fileNameText.setTag(null);
        this.filePathText.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.progress.setTag(null);
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

    @Override // com.rigol.scope.databinding.PopupviewDdrBinding
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
        } else if (i == 654) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 603) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 671) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        int i = 0;
        StorageSaveParam storageSaveParam = this.mParam;
        String str2 = null;
        if ((31 & j) != 0) {
            if ((j & 21) != 0) {
                str = ViewUtil.getDiskUIPathName(storageSaveParam != null ? storageSaveParam.getPathName() : null);
            } else {
                str = null;
            }
            if ((j & 25) != 0 && storageSaveParam != null) {
                i = storageSaveParam.getProgress();
            }
            if ((j & 19) != 0 && storageSaveParam != null) {
                str2 = storageSaveParam.getPrefix();
            }
        } else {
            str = null;
        }
        if ((19 & j) != 0) {
            TextViewBindingAdapter.setText(this.fileNameText, str2);
        }
        if ((21 & j) != 0) {
            TextViewBindingAdapter.setText(this.filePathText, str);
        }
        if ((j & 25) != 0) {
            this.progress.setProgress(i);
        }
    }
}
