package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public class PopupviewLoadingBindingImpl extends PopupviewLoadingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 5);
        sViewsWithIds.put(R.id.title, 6);
        sViewsWithIds.put(R.id.loading, 7);
        sViewsWithIds.put(R.id.content, 8);
    }

    public PopupviewLoadingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private PopupviewLoadingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (Button) objArr[3], (Button) objArr[4], (TextView) objArr[8], (View) objArr[2], (Guideline) objArr[5], (ContentLoadingProgressBar) objArr[7], (TextView) objArr[6], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.cancel.setTag(null);
        this.confirm.setTag(null);
        this.dividingLine.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.wrning.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8L;
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
        if (826 == i) {
            setShowConfirm((ObservableBoolean) obj);
        } else if (844 == i) {
            setShowWrning((ObservableBoolean) obj);
        } else if (825 != i) {
            return false;
        } else {
            setShowCancel((ObservableBoolean) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewLoadingBinding
    public void setShowConfirm(ObservableBoolean observableBoolean) {
        updateRegistration(0, observableBoolean);
        this.mShowConfirm = observableBoolean;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(826);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewLoadingBinding
    public void setShowWrning(ObservableBoolean observableBoolean) {
        updateRegistration(1, observableBoolean);
        this.mShowWrning = observableBoolean;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(844);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewLoadingBinding
    public void setShowCancel(ObservableBoolean observableBoolean) {
        updateRegistration(2, observableBoolean);
        this.mShowCancel = observableBoolean;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(825);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeShowCancel((ObservableBoolean) obj, i2);
            }
            return onChangeShowWrning((ObservableBoolean) obj, i2);
        }
        return onChangeShowConfirm((ObservableBoolean) obj, i2);
    }

    private boolean onChangeShowConfirm(ObservableBoolean observableBoolean, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeShowWrning(ObservableBoolean observableBoolean, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeShowCancel(ObservableBoolean observableBoolean, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewLoadingBindingImpl.executeBindings():void");
    }
}
