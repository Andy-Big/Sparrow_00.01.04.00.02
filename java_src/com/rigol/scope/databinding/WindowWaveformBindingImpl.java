package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.acquire.AcquireDepthView;
import com.rigol.scope.views.window.Window;
/* loaded from: classes2.dex */
public class WindowWaveformBindingImpl extends WindowWaveformBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_layout, 4);
        sViewsWithIds.put(R.id.acquire_depth, 5);
        sViewsWithIds.put(R.id.window_setting, 6);
        sViewsWithIds.put(R.id.content_layout, 7);
    }

    public WindowWaveformBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private WindowWaveformBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (AcquireDepthView) objArr[5], (ConstraintLayout) objArr[7], (TextView) objArr[1], (ConstraintLayout) objArr[4], (ImageButton) objArr[3], (Window) objArr[0], (ImageButton) objArr[2], (ImageButton) objArr[6]);
        this.mDirtyFlags = -1L;
        this.title.setTag(null);
        this.windowClose.setTag(null);
        this.windowLayout.setTag(null);
        this.windowMove.setTag(null);
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
        if (823 == i) {
            setSharedParam((SharedParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.WindowWaveformBinding
    public void setSharedParam(SharedParam sharedParam) {
        updateRegistration(0, sharedParam);
        this.mSharedParam = sharedParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(823);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                return false;
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayWindowTypeListComRigolScopeCilServiceEnumWindowTypeWINMAINWAVEFORMValue1((MappingObject) obj, i2);
        }
        return onChangeSharedParam((SharedParam) obj, i2);
    }

    private boolean onChangeSharedParam(SharedParam sharedParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 1076) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayWindowTypeListComRigolScopeCilServiceEnumWindowTypeWINMAINWAVEFORMValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 915) {
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SharedParam sharedParam = this.mSharedParam;
        int i = ((j & 21) > 0L ? 1 : ((j & 21) == 0L ? 0 : -1));
        int i2 = 0;
        if (i != 0) {
            boolean z = (sharedParam != null ? sharedParam.getWindowCount() : 0) > 1;
            if (i != 0) {
                j |= z ? 64L : 32L;
            }
            if (!z) {
                i2 = 8;
            }
        }
        int i3 = ((24 & j) > 0L ? 1 : ((24 & j) == 0L ? 0 : -1));
        String str = i3 != 0 ? ViewUtil.getMappingObject(R.array.window_type_list, ServiceEnum.WindowType.WIN_MAIN_WAVEFORM.value1).getStr() : null;
        if (i3 != 0) {
            TextViewBindingAdapter.setText(this.title, str);
        }
        if ((j & 21) != 0) {
            this.windowClose.setVisibility(i2);
            this.windowMove.setVisibility(i2);
        }
    }
}
