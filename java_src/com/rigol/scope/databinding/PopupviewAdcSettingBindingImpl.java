package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.views.adc.AdcSettingParam;
/* loaded from: classes2.dex */
public class PopupviewAdcSettingBindingImpl extends PopupviewAdcSettingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 31);
        sViewsWithIds.put(R.id.guideline_left, 32);
        sViewsWithIds.put(R.id.guideline_right, 33);
        sViewsWithIds.put(R.id.adc1, 34);
        sViewsWithIds.put(R.id.adc1_flip, 35);
        sViewsWithIds.put(R.id.adc2, 36);
        sViewsWithIds.put(R.id.adc2_flip, 37);
    }

    public PopupviewAdcSettingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 38, sIncludes, sViewsWithIds));
    }

    private PopupviewAdcSettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[34], (TextView) objArr[8], (SeekBar) objArr[9], (TextView) objArr[10], (SeekBar) objArr[11], (TextView) objArr[12], (SeekBar) objArr[13], (TextView) objArr[2], (SeekBar) objArr[3], (TextView) objArr[14], (SeekBar) objArr[15], (TextView) objArr[6], (SeekBar) objArr[7], (TextView) objArr[35], (CheckBox) objArr[1], (TextView) objArr[4], (SeekBar) objArr[5], (TextView) objArr[36], (TextView) objArr[23], (SeekBar) objArr[24], (TextView) objArr[25], (SeekBar) objArr[26], (TextView) objArr[27], (SeekBar) objArr[28], (TextView) objArr[17], (SeekBar) objArr[18], (TextView) objArr[29], (SeekBar) objArr[30], (TextView) objArr[21], (SeekBar) objArr[22], (TextView) objArr[37], (CheckBox) objArr[16], (TextView) objArr[19], (SeekBar) objArr[20], (Guideline) objArr[31], (Guideline) objArr[32], (Guideline) objArr[33]);
        this.mDirtyFlags = -1L;
        this.adc1A.setTag(null);
        this.adc1ASeekBar.setTag(null);
        this.adc1B.setTag(null);
        this.adc1BSeekBar.setTag(null);
        this.adc1C.setTag(null);
        this.adc1CSeekBar.setTag(null);
        this.adc1Coarse.setTag(null);
        this.adc1CoarseSeekBar.setTag(null);
        this.adc1D.setTag(null);
        this.adc1DSeekBar.setTag(null);
        this.adc1Fine.setTag(null);
        this.adc1FineSeekBar.setTag(null);
        this.adc1FlipCheckbox.setTag(null);
        this.adc1Inter.setTag(null);
        this.adc1InterSeekBar.setTag(null);
        this.adc2A.setTag(null);
        this.adc2ASeekBar.setTag(null);
        this.adc2B.setTag(null);
        this.adc2BSeekBar.setTag(null);
        this.adc2C.setTag(null);
        this.adc2CSeekBar.setTag(null);
        this.adc2Coarse.setTag(null);
        this.adc2CoarseSeekBar.setTag(null);
        this.adc2D.setTag(null);
        this.adc2DSeekBar.setTag(null);
        this.adc2Fine.setTag(null);
        this.adc2FineSeekBar.setTag(null);
        this.adc2FlipCheckbox.setTag(null);
        this.adc2Inter.setTag(null);
        this.adc2InterSeekBar.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
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
            setParam((AdcSettingParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.PopupviewAdcSettingBinding
    public void setParam(AdcSettingParam adcSettingParam) {
        updateRegistration(0, adcSettingParam);
        this.mParam = adcSettingParam;
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
        return onChangeParam((AdcSettingParam) obj, i2);
    }

    private boolean onChangeParam(AdcSettingParam adcSettingParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 329) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 181) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 438) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 315) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 622) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 623) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 624) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 625) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 330) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 182) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 439) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 316) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 626) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 627) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 628) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 629) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0222 A[ADDED_TO_REGION] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewAdcSettingBindingImpl.executeBindings():void");
    }
}
