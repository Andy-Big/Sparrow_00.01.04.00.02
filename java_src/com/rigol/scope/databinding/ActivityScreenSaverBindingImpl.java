package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.UtilityParam;
/* loaded from: classes2.dex */
public class ActivityScreenSaverBindingImpl extends ActivityScreenSaverBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.Idle_time_LL, 3);
        sViewsWithIds.put(R.id.main_ad_relative_layout, 4);
    }

    public ActivityScreenSaverBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ActivityScreenSaverBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[3], (ImageView) objArr[1], (RelativeLayout) objArr[4], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.mainAdBackground.setTag(null);
        this.mainAdTextview.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
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
        if (594 == i) {
            setParam((UtilityParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.ActivityScreenSaverBinding
    public void setParam(UtilityParam utilityParam) {
        updateRegistration(0, utilityParam);
        this.mParam = utilityParam;
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
        return onChangeParam((UtilityParam) obj, i2);
    }

    private boolean onChangeParam(UtilityParam utilityParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 781) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 784) {
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
        int i;
        String str;
        int i2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        UtilityParam utilityParam = this.mParam;
        int i3 = 0;
        if ((15 & j) != 0) {
            int i4 = ((j & 11) > 0L ? 1 : ((j & 11) == 0L ? 0 : -1));
            if (i4 != 0) {
                int screenSelect = utilityParam != null ? utilityParam.getScreenSelect() : 0;
                boolean z = screenSelect == ServiceEnum.UtilityScreenSaver.SCR_PICTURE.value1;
                boolean z2 = screenSelect == ServiceEnum.UtilityScreenSaver.SCR_TEXT.value1;
                if (i4 != 0) {
                    j |= z ? 128L : 64L;
                }
                if ((j & 11) != 0) {
                    j |= z2 ? 32L : 16L;
                }
                i2 = z ? 0 : 8;
                if (!z2) {
                    i3 = 8;
                }
            } else {
                i2 = 0;
            }
            if ((j & 13) == 0 || utilityParam == null) {
                i = i3;
                str = null;
            } else {
                str = utilityParam.getScreenWord();
                i = i3;
            }
            i3 = i2;
        } else {
            i = 0;
            str = null;
        }
        if ((11 & j) != 0) {
            this.mainAdBackground.setVisibility(i3);
            this.mainAdTextview.setVisibility(i);
        }
        if ((j & 13) != 0) {
            TextViewBindingAdapter.setText(this.mainAdTextview, str);
        }
    }
}
