package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.adc.AdcSerParam;

/* loaded from: classes2.dex */
public class PopupviewAdcserBindingImpl extends PopupviewAdcserBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 13);
        sViewsWithIds.put(R.id.tcmp, 14);
        sViewsWithIds.put(R.id.tdmx, 15);
        sViewsWithIds.put(R.id.adc1, 16);
        sViewsWithIds.put(R.id.adc2, 17);
        sViewsWithIds.put(R.id.adc3, 18);
        sViewsWithIds.put(R.id.adc4, 19);
        sViewsWithIds.put(R.id.save_btn, 20);
    }

    public PopupviewAdcserBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, sIncludes, sViewsWithIds));
    }

    private PopupviewAdcserBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[16], (SeekBar) objArr[1], (SwitchButton) objArr[3], (TextView) objArr[2], (TextView) objArr[17], (SeekBar) objArr[4], (SwitchButton) objArr[6], (TextView) objArr[5], (TextView) objArr[18], (SeekBar) objArr[7], (SwitchButton) objArr[9], (TextView) objArr[8], (TextView) objArr[19], (SeekBar) objArr[10], (SwitchButton) objArr[12], (TextView) objArr[11], (Guideline) objArr[13], (Button) objArr[20], (TextView) objArr[14], (TextView) objArr[15]);
        this.mDirtyFlags = -1L;
        this.adc1TcmpSeekBar.setTag(null);
        this.adc1TdmxSwitch.setTag(null);
        this.adc1Value.setTag(null);
        this.adc2TcmpSeekBar.setTag(null);
        this.adc2TdmxSwitch.setTag(null);
        this.adc2Value.setTag(null);
        this.adc3TcmpSeekBar.setTag(null);
        this.adc3TdmxSwitch.setTag(null);
        this.adc3Value.setTag(null);
        this.adc4TcmpSeekBar.setTag(null);
        this.adc4TdmxSwitch.setTag(null);
        this.adc4Value.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
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
        if (594 == i) {
            setParam((AdcSerParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.PopupviewAdcserBinding
    public void setParam(AdcSerParam adcSerParam) {
        updateRegistration(0, adcSerParam);
        this.mParam = adcSerParam;
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
        return onChangeParam((AdcSerParam) obj, i2);
    }

    private boolean onChangeParam(AdcSerParam adcSerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 29) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 30) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 31) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 32) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 33) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 34) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 35) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 36) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
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
        String str2;
        String str3;
        String str4;
        int i;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        String str5;
        int i5;
        String str6;
        int i6;
        String str7;
        int i7;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        AdcSerParam adcSerParam = this.mParam;
        String str8 = null;
        if ((1023 & j) != 0) {
            if ((j & 641) != 0) {
                i5 = adcSerParam != null ? adcSerParam.getAdc4Tcmp() : 0;
                str5 = String.valueOf(i5);
            } else {
                str5 = null;
                i5 = 0;
            }
            boolean adc2Tdmx = ((j & 529) == 0 || adcSerParam == null) ? false : adcSerParam.getAdc2Tdmx();
            if ((j & 521) != 0) {
                i6 = adcSerParam != null ? adcSerParam.getAdc2Tcmp() : 0;
                str6 = String.valueOf(i6);
            } else {
                str6 = null;
                i6 = 0;
            }
            boolean adc1Tdmx = ((j & 517) == 0 || adcSerParam == null) ? false : adcSerParam.getAdc1Tdmx();
            boolean adc4Tdmx = ((j & 769) == 0 || adcSerParam == null) ? false : adcSerParam.getAdc4Tdmx();
            boolean adc3Tdmx = ((j & 577) == 0 || adcSerParam == null) ? false : adcSerParam.getAdc3Tdmx();
            if ((j & 545) != 0) {
                i7 = adcSerParam != null ? adcSerParam.getAdc3Tcmp() : 0;
                str7 = String.valueOf(i7);
            } else {
                str7 = null;
                i7 = 0;
            }
            if ((j & 515) != 0) {
                r24 = adcSerParam != null ? adcSerParam.getAdc1Tcmp() : 0;
                str8 = String.valueOf(r24);
            }
            i4 = i5;
            str = str8;
            i = r24;
            str4 = str5;
            z2 = adc2Tdmx;
            i2 = i6;
            str2 = str6;
            z = adc1Tdmx;
            z4 = adc4Tdmx;
            z3 = adc3Tdmx;
            i3 = i7;
            str3 = str7;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            i = 0;
            z = false;
            i2 = 0;
            z2 = false;
            i3 = 0;
            z3 = false;
            i4 = 0;
            z4 = false;
        }
        if ((j & 515) != 0) {
            SeekBarBindingAdapter.setProgress(this.adc1TcmpSeekBar, i);
            TextViewBindingAdapter.setText(this.adc1Value, str);
        }
        if ((j & 517) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.adc1TdmxSwitch, z);
        }
        if ((j & 521) != 0) {
            SeekBarBindingAdapter.setProgress(this.adc2TcmpSeekBar, i2);
            TextViewBindingAdapter.setText(this.adc2Value, str2);
        }
        if ((529 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.adc2TdmxSwitch, z2);
        }
        if ((545 & j) != 0) {
            SeekBarBindingAdapter.setProgress(this.adc3TcmpSeekBar, i3);
            TextViewBindingAdapter.setText(this.adc3Value, str3);
        }
        if ((577 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.adc3TdmxSwitch, z3);
        }
        if ((j & 641) != 0) {
            SeekBarBindingAdapter.setProgress(this.adc4TcmpSeekBar, i4);
            TextViewBindingAdapter.setText(this.adc4Value, str4);
        }
        if ((j & 769) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.adc4TdmxSwitch, z4);
        }
    }
}
