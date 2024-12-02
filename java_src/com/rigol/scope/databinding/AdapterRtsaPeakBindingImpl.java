package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.rigol.scope.data.FftParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.views.SwitchButton;

/* loaded from: classes2.dex */
public class AdapterRtsaPeakBindingImpl extends AdapterRtsaPeakBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.peak, 8);
        sViewsWithIds.put(R.id.peak_rectangle, 9);
        sViewsWithIds.put(R.id.peaken, 10);
        sViewsWithIds.put(R.id.next_peak_btn, 11);
        sViewsWithIds.put(R.id.right_peak_btn, 12);
        sViewsWithIds.put(R.id.left_peak_btn, 13);
        sViewsWithIds.put(R.id.search_param_rectangle, 14);
        sViewsWithIds.put(R.id.span, 15);
        sViewsWithIds.put(R.id.peak_num, 16);
        sViewsWithIds.put(R.id.threshold, 17);
        sViewsWithIds.put(R.id.excursion, 18);
        sViewsWithIds.put(R.id.peak_table_rectangle, 19);
        sViewsWithIds.put(R.id.peak_table, 20);
        sViewsWithIds.put(R.id.peak_table_en, 21);
        sViewsWithIds.put(R.id.table_order, 22);
        sViewsWithIds.put(R.id.table_order_radio_group, 23);
    }

    public AdapterRtsaPeakBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 24, sIncludes, sViewsWithIds));
    }

    private AdapterRtsaPeakBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (RadioButton) objArr[6], (RadioButton) objArr[7], (TextView) objArr[18], (EditText) objArr[4], (Button) objArr[13], (Button) objArr[11], (TextView) objArr[8], (TextView) objArr[16], (EditText) objArr[2], (ImageView) objArr[9], (TextView) objArr[20], (TextView) objArr[21], (SwitchButton) objArr[5], (ImageView) objArr[19], (TextView) objArr[10], (SwitchButton) objArr[1], (Button) objArr[12], (ImageView) objArr[14], (TextView) objArr[15], (TextView) objArr[22], (RadioGroup) objArr[23], (TextView) objArr[17], (EditText) objArr[3]);
        this.mDirtyFlags = -1L;
        this.AmpRadioButton.setTag(null);
        this.FreqRadioButton.setTag(null);
        this.excursionText.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.peakNumText.setTag(null);
        this.peakTableEnswitch.setTag(null);
        this.peakenSwitch.setTag(null);
        this.thresholdText.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
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
        if (6 == i) {
            setFreqOrderMapping((MappingObject) obj);
            return true;
        } else if (1 == i) {
            setAmpOrderMapping((MappingObject) obj);
            return true;
        } else if (594 == i) {
            setParam((FftParam) obj);
            return true;
        } else if (379 == i) {
            setHoriParam((HorizontalParam) obj);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.rigol.scope.databinding.AdapterRtsaPeakBinding
    public void setFreqOrderMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mFreqOrderMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterRtsaPeakBinding
    public void setAmpOrderMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mAmpOrderMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterRtsaPeakBinding
    public void setParam(FftParam fftParam) {
        updateRegistration(2, fftParam);
        this.mParam = fftParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterRtsaPeakBinding
    public void setHoriParam(HorizontalParam horizontalParam) {
        updateRegistration(3, horizontalParam);
        this.mHoriParam = horizontalParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(379);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    return onChangeHoriParam((HorizontalParam) obj, i2);
                }
                return onChangeParam((FftParam) obj, i2);
            }
            return onChangeAmpOrderMapping((MappingObject) obj, i2);
        }
        return onChangeFreqOrderMapping((MappingObject) obj, i2);
    }

    private boolean onChangeFreqOrderMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeAmpOrderMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(FftParam fftParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 606) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 612) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 617) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 608) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 615) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 613) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeHoriParam(HorizontalParam horizontalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 935) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
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
        boolean z2;
        boolean z3;
        boolean z4;
        String str;
        String str2;
        String str3;
        float f2;
        boolean z5;
        float f3;
        long j2;
        String str4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mFreqOrderMapping;
        MappingObject mappingObject2 = this.mAmpOrderMapping;
        FftParam fftParam = this.mParam;
        HorizontalParam horizontalParam = this.mHoriParam;
        int i = ((8209 & j) > 0L ? 1 : ((8209 & j) == 0L ? 0 : -1));
        String str5 = (i == 0 || mappingObject == null) ? null : mappingObject.getStr();
        int i2 = ((8226 & j) > 0L ? 1 : ((8226 & j) == 0L ? 0 : -1));
        String str6 = (i2 == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        if ((12228 & j) != 0) {
            if ((j & 8260) != 0) {
                z2 = fftParam != null ? fftParam.isPeakEn() : false;
                f3 = ContextUtil.getAlpha(z2);
            } else {
                f3 = 0.0f;
                z2 = false;
            }
            if ((j & 10244) != 0) {
                ServiceEnum.enPeakOrder peakOrder = fftParam != null ? fftParam.getPeakOrder() : null;
                z3 = peakOrder == ServiceEnum.enPeakOrder.fft_peak_FreqOrder;
                z = peakOrder == ServiceEnum.enPeakOrder.fft_peak_AmpOrder;
            } else {
                z = false;
                z3 = false;
            }
            str2 = ((j & 8708) == 0 || fftParam == null) ? null : fftParam.getPeakExcurStr();
            boolean isPeakTableEn = ((j & 9220) == 0 || fftParam == null) ? false : fftParam.isPeakTableEn();
            if ((j & 8324) != 0) {
                str4 = String.valueOf(fftParam != null ? fftParam.getPeakNum() : 0);
                j2 = 8452;
            } else {
                j2 = 8452;
                str4 = null;
            }
            if ((j & j2) == 0 || fftParam == null) {
                f = f3;
                z4 = isPeakTableEn;
                str3 = str4;
                str = null;
            } else {
                str = fftParam.getPeakThresholdStr();
                f = f3;
                z4 = isPeakTableEn;
                str3 = str4;
            }
        } else {
            f = 0.0f;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            str = null;
            str2 = null;
            str3 = null;
        }
        int i3 = ((j & 12296) > 0L ? 1 : ((j & 12296) == 0L ? 0 : -1));
        if (i3 != 0) {
            boolean z6 = (horizontalParam != null ? horizontalParam.getTimeMode() : null) != ServiceEnum.HoriTimeMode.Horizontal_ROLL;
            f2 = ContextUtil.getAlpha(z6);
            z5 = z6;
        } else {
            f2 = 0.0f;
            z5 = false;
        }
        if ((j & 10244) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.AmpRadioButton, z);
            CompoundButtonBindingAdapter.setChecked(this.FreqRadioButton, z3);
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.AmpRadioButton, str6);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.FreqRadioButton, str5);
        }
        if ((j & 8708) != 0) {
            TextViewBindingAdapter.setText(this.excursionText, str2);
        }
        if ((8324 & j) != 0) {
            TextViewBindingAdapter.setText(this.peakNumText, str3);
        }
        if ((j & 9220) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.peakTableEnswitch, z4);
        }
        if ((j & 8260) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.peakTableEnswitch.setAlpha(f);
            }
            this.peakTableEnswitch.setEnabled(z2);
            CompoundButtonBindingAdapter.setChecked(this.peakenSwitch, z2);
        }
        if (i3 != 0) {
            if (getBuildSdkInt() >= 11) {
                this.peakenSwitch.setAlpha(f2);
            }
            this.peakenSwitch.setEnabled(z5);
        }
        if ((j & 8452) != 0) {
            TextViewBindingAdapter.setText(this.thresholdText, str);
        }
    }
}
