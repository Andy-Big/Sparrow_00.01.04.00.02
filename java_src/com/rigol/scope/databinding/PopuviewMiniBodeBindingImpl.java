package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class PopuviewMiniBodeBindingImpl extends PopuviewMiniBodeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.left_guideline, 3);
        sViewsWithIds.put(R.id.left_guideline1, 4);
        sViewsWithIds.put(R.id.left_guideline2, 5);
        sViewsWithIds.put(R.id.left_guideline3, 6);
    }

    public PopuviewMiniBodeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private PopuviewMiniBodeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (Guideline) objArr[3], (Guideline) objArr[4], (Guideline) objArr[5], (Guideline) objArr[6], (ImageView) objArr[2], (SwitchButton) objArr[1]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.operateButton.setTag(null);
        this.showBodeSwitch.setTag(null);
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
        if (600 == i) {
            setParma((BodeParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.PopuviewMiniBodeBinding
    public void setParma(BodeParam bodeParam) {
        updateRegistration(0, bodeParam);
        this.mParma = bodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(600);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeParma((BodeParam) obj, i2);
    }

    private boolean onChangeParma(BodeParam bodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 96) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 104) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        float f;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Drawable drawable = null;
        BodeParam bodeParam = this.mParma;
        float f2 = 0.0f;
        if ((15 & j) != 0) {
            if ((j & 11) != 0) {
                z = bodeParam != null ? bodeParam.getBodeEnable() : false;
                f = ContextUtil.getAlpha(z);
            } else {
                f = 0.0f;
                z = false;
            }
            int i = ((j & 13) > 0L ? 1 : ((j & 13) == 0L ? 0 : -1));
            if (i != 0) {
                r12 = bodeParam != null ? bodeParam.getBodeRunStopEnable() : false;
                if (i != 0) {
                    j |= r12 ? 32L : 16L;
                }
                drawable = AppCompatResources.getDrawable(this.operateButton.getContext(), r12 ? 17301539 : 17301540);
            }
            r12 = z;
            f2 = f;
        }
        if ((11 & j) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.operateButton.setAlpha(f2);
            }
            this.operateButton.setEnabled(r12);
            CompoundButtonBindingAdapter.setChecked(this.showBodeSwitch, r12);
        }
        if ((j & 13) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.operateButton, drawable);
        }
    }
}
