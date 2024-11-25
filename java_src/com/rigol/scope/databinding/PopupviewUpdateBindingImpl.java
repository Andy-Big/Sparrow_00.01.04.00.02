package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.lib.data.Firmware;
import com.rigol.scope.R;
import com.rigol.scope.data.UpdateParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.views.NumberProgressBar;
/* loaded from: classes2.dex */
public class PopupviewUpdateBindingImpl extends PopupviewUpdateBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 7);
        sViewsWithIds.put(R.id.content_layout, 8);
        sViewsWithIds.put(R.id.install_progress, 9);
        sViewsWithIds.put(R.id.install_text, 10);
        sViewsWithIds.put(R.id.button_layout, 11);
    }

    public PopupviewUpdateBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private PopupviewUpdateBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (View) objArr[11], (Button) objArr[5], (TextView) objArr[1], (ScrollView) objArr[8], (NumberProgressBar) objArr[2], (TextView) objArr[4], (Guideline) objArr[7], (ConstraintLayout) objArr[3], (ContentLoadingProgressBar) objArr[9], (TextView) objArr[10], (Button) objArr[6]);
        this.mDirtyFlags = -1L;
        this.cancel.setTag(null);
        this.content.setTag(null);
        this.downloadProgress.setTag(null);
        this.errorText.setTag(null);
        this.installLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.ok.setTag(null);
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
        if (994 == i) {
            setUpdateParam((UpdateParam) obj);
        } else if (1013 == i) {
            setUtilityParam((UtilityParam) obj);
        } else if (320 != i) {
            return false;
        } else {
            setFirmware((Firmware) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewUpdateBinding
    public void setUpdateParam(UpdateParam updateParam) {
        updateRegistration(0, updateParam);
        this.mUpdateParam = updateParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(994);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewUpdateBinding
    public void setUtilityParam(UtilityParam utilityParam) {
        updateRegistration(1, utilityParam);
        this.mUtilityParam = utilityParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(1013);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewUpdateBinding
    public void setFirmware(Firmware firmware) {
        this.mFirmware = firmware;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(320);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                return false;
            }
            return onChangeUtilityParam((UtilityParam) obj, i2);
        }
        return onChangeUpdateParam((UpdateParam) obj, i2);
    }

    private boolean onChangeUpdateParam(UpdateParam updateParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 248) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 671) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 437) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 278) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 279) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeUtilityParam(UtilityParam utilityParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 478) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0161, code lost:
        if (r9 == 0) goto L86;
     */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewUpdateBindingImpl.executeBindings():void");
    }
}
