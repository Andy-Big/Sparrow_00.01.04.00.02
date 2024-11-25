package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class AdapterDecodeParallelBindingImpl extends AdapterDecodeParallelBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private long mDirtyFlags_1;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.decode_parallel_layout, 26);
        sViewsWithIds.put(R.id.guideline_left, 27);
        sViewsWithIds.put(R.id.guideline_center, 28);
        sViewsWithIds.put(R.id.guideline_right, 29);
        sViewsWithIds.put(R.id.guideline_33, 30);
        sViewsWithIds.put(R.id.guideline_66, 31);
        sViewsWithIds.put(R.id.decode_pal_clk_label, 32);
        sViewsWithIds.put(R.id.divider2, 33);
        sViewsWithIds.put(R.id.decode_pal_bus_label, 34);
        sViewsWithIds.put(R.id.decode_pal_dat_thres_label, 35);
        sViewsWithIds.put(R.id.decode_pal_endian_label, 36);
        sViewsWithIds.put(R.id.decode_pal_endian_radioGroup, 37);
        sViewsWithIds.put(R.id.decode_pal_polarity_label, 38);
        sViewsWithIds.put(R.id.decode_pal_polarity_radioGroup, 39);
        sViewsWithIds.put(R.id.trigger_noise_label, 40);
        sViewsWithIds.put(R.id.decode_pal_nrjtime_label, 41);
    }

    public AdapterDecodeParallelBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 42, sIncludes, sViewsWithIds));
    }

    private AdapterDecodeParallelBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (Button) objArr[19], (Button) objArr[21], (Button) objArr[20], (TextView) objArr[18], (TextView) objArr[22], (AppCompatTextView) objArr[23], (TextView) objArr[17], (TextView) objArr[16], (SwitchButton) objArr[24], (TextView) objArr[15], (TextView) objArr[34], (TextView) objArr[9], (TextView) objArr[4], (RadioGroup) objArr[5], (TextView) objArr[32], (TextView) objArr[1], (TextView) objArr[35], (TextView) objArr[10], (RadioButton) objArr[7], (TextView) objArr[36], (RadioGroup) objArr[37], (RadioButton) objArr[11], (RadioButton) objArr[13], (RadioButton) objArr[12], (TextView) objArr[41], (TextView) objArr[25], (TextView) objArr[38], (RadioGroup) objArr[39], (RadioButton) objArr[14], (TextView) objArr[2], (TextView) objArr[3], (RadioButton) objArr[6], (RadioButton) objArr[8], (ConstraintLayout) objArr[26], (View) objArr[33], (Guideline) objArr[30], (Guideline) objArr[31], (Guideline) objArr[28], (Guideline) objArr[27], (Guideline) objArr[29], (TextView) objArr[40]);
        this.mDirtyFlags = -1L;
        this.mDirtyFlags_1 = -1L;
        this.bitOne.setTag(null);
        this.bitThree.setTag(null);
        this.bitTwo.setTag(null);
        this.bitZero.setTag(null);
        this.decodeBusChLabel.setTag(null);
        this.decodeBusChValue.setTag(null);
        this.decodeBusWidthLabel.setTag(null);
        this.decodeBusWidthValue.setTag(null);
        this.decodeNoiseSwitch.setTag(null);
        this.decodePalBitxLabel.setTag(null);
        this.decodePalBusValue.setTag(null);
        this.decodePalClkEdgeLabel.setTag(null);
        this.decodePalClkEdgeRadioGroup.setTag(null);
        this.decodePalClkValue.setTag(null);
        this.decodePalDatThresValue.setTag(null);
        this.decodePalDownRadioButton.setTag(null);
        this.decodePalInvertRadioButton.setTag(null);
        this.decodePalNegativeRadioButton.setTag(null);
        this.decodePalNormalRadioButton.setTag(null);
        this.decodePalNrjtimeValue.setTag(null);
        this.decodePalPositiveRadioButton.setTag(null);
        this.decodePalThresLabel.setTag(null);
        this.decodePalThresValue.setTag(null);
        this.decodePalUpRadioButton.setTag(null);
        this.decodePalUpdownRadioButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            this.mDirtyFlags_1 = 0L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags == 0 && this.mDirtyFlags_1 == 0) {
                return false;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (594 == i) {
            setParam((DecodeParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeParallelBinding
    public void setParam(DecodeParam decodeParam) {
        updateRegistration(2, decodeParam);
        this.mParam = decodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
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
                    return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeBusChParamBusChan((MappingObject) obj, i2);
                }
                return onChangeParam((DecodeParam) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodePalClkParamPalClk((MappingObject) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodePalBusParamPalBus((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodePalBusParamPalBus(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodePalClkParamPalClk(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParam(DecodeParam decodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 585) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 588) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 586) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 584) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 127) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 590) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 591) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 642) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 128) {
            synchronized (this) {
                this.mDirtyFlags |= 12288;
            }
            return true;
        } else if (i == 126) {
            synchronized (this) {
                this.mDirtyFlags |= 49152;
            }
            return true;
        } else if (i == 559) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 736) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeBusChParamBusChan(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x05bc  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0685  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x06e3  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x06f1  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x0718  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0730  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x073c  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x074c  */
    /* JADX WARN: Removed duplicated region for block: B:433:0x0782  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x079d  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x07aa  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x07ed  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x07fc  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x080b  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x081a  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x0827  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x0843  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x0852  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x089c  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x08a5  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x08c3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:482:0x08d0  */
    /* JADX WARN: Removed duplicated region for block: B:485:0x08ef  */
    /* JADX WARN: Removed duplicated region for block: B:488:0x0905  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x091b  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x092a  */
    /* JADX WARN: Removed duplicated region for block: B:501:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0143  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 2357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterDecodeParallelBindingImpl.executeBindings():void");
    }
}
