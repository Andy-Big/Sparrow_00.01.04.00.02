package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.utilities.ContextUtil;

/* loaded from: classes2.dex */
public class AdapterUtilityScreensaverBindingImpl extends AdapterUtilityScreensaverBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_screen_saver, 12);
        sViewsWithIds.put(R.id.radiogroup_screen_type, 13);
        sViewsWithIds.put(R.id.view10, 14);
        sViewsWithIds.put(R.id.picture, 15);
        sViewsWithIds.put(R.id.watitime_layout, 16);
        sViewsWithIds.put(R.id.divider3, 17);
        sViewsWithIds.put(R.id.picture_path_layout, 18);
        sViewsWithIds.put(R.id.text_layout, 19);
    }

    public AdapterUtilityScreensaverBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
    }

    private AdapterUtilityScreensaverBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (View) objArr[17], (ConstraintLayout) objArr[15], (ConstraintLayout) objArr[18], (RadioButton) objArr[1], (RadioButton) objArr[2], (RadioButton) objArr[3], (RadioGroup) objArr[13], (ConstraintLayout) objArr[19], (TextView) objArr[4], (TextView) objArr[6], (TextView) objArr[8], (TextView) objArr[9], (TextView) objArr[7], (TextView) objArr[12], (TextView) objArr[10], (TextView) objArr[11], (TextView) objArr[5], (View) objArr[14], (ConstraintLayout) objArr[16]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.radioButtonClose.setTag(null);
        this.radioButtonPicture.setTag(null);
        this.radioButtonText.setTag(null);
        this.textView91.setTag(null);
        this.tvDefault.setTag(null);
        this.tvPicture.setTag(null);
        this.tvPictureValue.setTag(null);
        this.tvPreview.setTag(null);
        this.tvText.setTag(null);
        this.tvTextValue.setTag(null);
        this.tvWatitimeValue.setTag(null);
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
            setParam((UtilityParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterUtilityScreensaverBinding
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
        } else if (i == 783) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 784) {
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
        float f;
        float f2;
        float f3;
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        boolean z4;
        String str2;
        float f4;
        float f5;
        boolean z5;
        boolean z6;
        boolean z7;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        UtilityParam utilityParam = this.mParam;
        float f6 = 0.0f;
        if ((31 & j) != 0) {
            String screenTimeStr = ((j & 21) == 0 || utilityParam == null) ? null : utilityParam.getScreenTimeStr();
            if ((j & 19) != 0) {
                int screenSelect = utilityParam != null ? utilityParam.getScreenSelect() : 0;
                boolean z8 = screenSelect == ServiceEnum.UtilityScreenSaver.SCR_PICTURE.value1;
                boolean z9 = screenSelect == ServiceEnum.UtilityScreenSaver.SCR_TEXT.value1;
                boolean z10 = screenSelect != ServiceEnum.UtilityScreenSaver.SCR_OFF.value1;
                z7 = screenSelect == ServiceEnum.UtilityScreenSaver.SCR_OFF.value1;
                f3 = ContextUtil.getAlpha(z8);
                f6 = ContextUtil.getAlpha(z9);
                f4 = ContextUtil.getAlpha(z10);
                f5 = ContextUtil.getAlpha(z7);
                boolean z11 = z8;
                z6 = z10;
                z5 = z9;
                z4 = z11;
            } else {
                f3 = 0.0f;
                f4 = 0.0f;
                f5 = 0.0f;
                z5 = false;
                z6 = false;
                z4 = false;
                z7 = false;
            }
            if ((j & 25) == 0 || utilityParam == null) {
                z2 = z5;
                z3 = z6;
                f = f6;
                f2 = f4;
                f6 = f5;
                str = null;
                str2 = screenTimeStr;
                z = z7;
            } else {
                z2 = z5;
                z3 = z6;
                f2 = f4;
                str = utilityParam.getScreenWord();
                str2 = screenTimeStr;
                f = f6;
                z = z7;
                f6 = f5;
            }
        } else {
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
            z = false;
            z2 = false;
            z3 = false;
            str = null;
            z4 = false;
            str2 = null;
        }
        if ((19 & j) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.radioButtonClose.setAlpha(f6);
                this.radioButtonPicture.setAlpha(f3);
                this.radioButtonText.setAlpha(f);
                this.textView91.setAlpha(f2);
                this.tvDefault.setAlpha(f2);
                this.tvPicture.setAlpha(f3);
                this.tvPictureValue.setAlpha(f3);
                this.tvPreview.setAlpha(f2);
                this.tvText.setAlpha(f);
                this.tvTextValue.setAlpha(f);
                this.tvWatitimeValue.setAlpha(f2);
            }
            CompoundButtonBindingAdapter.setChecked(this.radioButtonClose, z);
            CompoundButtonBindingAdapter.setChecked(this.radioButtonPicture, z4);
            CompoundButtonBindingAdapter.setChecked(this.radioButtonText, z2);
            this.textView91.setEnabled(z3);
            this.tvDefault.setEnabled(z3);
            this.tvPicture.setEnabled(z4);
            this.tvPictureValue.setEnabled(z4);
            this.tvPreview.setEnabled(z3);
            this.tvText.setEnabled(z2);
            this.tvTextValue.setEnabled(z2);
            this.tvWatitimeValue.setEnabled(z3);
        }
        if ((25 & j) != 0) {
            TextViewBindingAdapter.setText(this.tvTextValue, str);
        }
        if ((j & 21) != 0) {
            TextViewBindingAdapter.setText(this.tvWatitimeValue, str2);
        }
    }
}
