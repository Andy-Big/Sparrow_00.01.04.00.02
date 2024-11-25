package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
/* loaded from: classes2.dex */
public class AdapterDecodeSpiBindingImpl extends AdapterDecodeSpiBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private long mDirtyFlags_1;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.decode_spi_layout, 28);
        sViewsWithIds.put(R.id.guideline_left, 29);
        sViewsWithIds.put(R.id.guideline_center, 30);
        sViewsWithIds.put(R.id.guideline_right, 31);
        sViewsWithIds.put(R.id.guideline_33, 32);
        sViewsWithIds.put(R.id.guideline_66, 33);
        sViewsWithIds.put(R.id.decode_spi_clk_label, 34);
        sViewsWithIds.put(R.id.decode_spi_clk_thres_label, 35);
        sViewsWithIds.put(R.id.decode_spi_mosi_label, 36);
        sViewsWithIds.put(R.id.decode_spi_clk_edge_label, 37);
        sViewsWithIds.put(R.id.decode_spi_clk_edge_radioGroup, 38);
        sViewsWithIds.put(R.id.decode_spi_mode_label, 39);
        sViewsWithIds.put(R.id.decode_spi_mode_radioGroup, 40);
        sViewsWithIds.put(R.id.decode_spi_miso_label, 41);
        sViewsWithIds.put(R.id.divider1, 42);
        sViewsWithIds.put(R.id.decode_spi_width_label, 43);
        sViewsWithIds.put(R.id.decode_spi_endian_label, 44);
        sViewsWithIds.put(R.id.decode_spi_endian_radioGroup, 45);
        sViewsWithIds.put(R.id.decode_spi_polarity_label, 46);
        sViewsWithIds.put(R.id.decode_spi_polarity_radioGroup, 47);
    }

    public AdapterDecodeSpiBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 48, sIncludes, sViewsWithIds));
    }

    private AdapterDecodeSpiBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 15, (RadioButton) objArr[11], (TextView) objArr[37], (RadioGroup) objArr[38], (RadioButton) objArr[10], (TextView) objArr[34], (TextView) objArr[35], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[1], (TextView) objArr[24], (RadioButton) objArr[27], (RadioButton) objArr[26], (RadioGroup) objArr[25], (TextView) objArr[16], (TextView) objArr[19], (TextView) objArr[18], (RadioButton) objArr[21], (TextView) objArr[44], (RadioButton) objArr[20], (RadioGroup) objArr[45], (ConstraintLayout) objArr[28], (TextView) objArr[41], (TextView) objArr[5], (TextView) objArr[9], (TextView) objArr[15], (RadioButton) objArr[13], (TextView) objArr[39], (RadioGroup) objArr[40], (RadioButton) objArr[12], (TextView) objArr[36], (TextView) objArr[14], (TextView) objArr[8], (TextView) objArr[4], (TextView) objArr[46], (RadioButton) objArr[23], (RadioButton) objArr[22], (RadioGroup) objArr[47], (TextView) objArr[6], (TextView) objArr[7], (TextView) objArr[43], (TextView) objArr[17], (View) objArr[42], (Guideline) objArr[32], (Guideline) objArr[33], (Guideline) objArr[30], (Guideline) objArr[29], (Guideline) objArr[31]);
        this.mDirtyFlags = -1L;
        this.mDirtyFlags_1 = -1L;
        this.decodeSpiClkEdgeDownRadioButton.setTag(null);
        this.decodeSpiClkEdgeUpRadioButton.setTag(null);
        this.decodeSpiClkThresValue.setTag(null);
        this.decodeSpiClkValue.setTag(null);
        this.decodeSpiCsLabel.setTag(null);
        this.decodeSpiCsPolLabel.setTag(null);
        this.decodeSpiCsPolNegativeRadioButton.setTag(null);
        this.decodeSpiCsPolPositiveRadioButton.setTag(null);
        this.decodeSpiCsPolRadioGroup.setTag(null);
        this.decodeSpiCsThresLabel.setTag(null);
        this.decodeSpiCsThresValue.setTag(null);
        this.decodeSpiCsValue.setTag(null);
        this.decodeSpiEndianLSBRadioButton.setTag(null);
        this.decodeSpiEndianMSBRadioButton.setTag(null);
        this.decodeSpiMisoThresLabel.setTag(null);
        this.decodeSpiMisoThresValue.setTag(null);
        this.decodeSpiMisoValue.setTag(null);
        this.decodeSpiModeCsRadioButton.setTag(null);
        this.decodeSpiModeTimeoutRadioButton.setTag(null);
        this.decodeSpiMosiThresLabel.setTag(null);
        this.decodeSpiMosiThresValue.setTag(null);
        this.decodeSpiMosiValue.setTag(null);
        this.decodeSpiPolarityNegativeRadioButton.setTag(null);
        this.decodeSpiPolarityPositiveRadioButton.setTag(null);
        this.decodeSpiTmoLabel.setTag(null);
        this.decodeSpiTmoValue.setTag(null);
        this.decodeSpiWidthValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1099511627776L;
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
        if (643 == i) {
            setPolarityNegativeMapping((MappingObject) obj);
        } else if (548 == i) {
            setModeTimeoutMapping((MappingObject) obj);
        } else if (275 == i) {
            setEndianLsbMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((DecodeParam) obj);
        } else if (257 == i) {
            setEdgeDownMapping((MappingObject) obj);
        } else if (644 == i) {
            setPolarityPositiveMapping((MappingObject) obj);
        } else if (270 == i) {
            setEdgeUpMapping((MappingObject) obj);
        } else if (545 == i) {
            setModeCsMapping((MappingObject) obj);
        } else if (276 == i) {
            setEndianMsbMapping((MappingObject) obj);
        } else if (194 == i) {
            setCsNegativeMapping((MappingObject) obj);
        } else if (195 != i) {
            return false;
        } else {
            setCsPositiveMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setPolarityNegativeMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mPolarityNegativeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(643);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setModeTimeoutMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mModeTimeoutMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(548);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setEndianLsbMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mEndianLsbMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(275);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setParam(DecodeParam decodeParam) {
        updateRegistration(5, decodeParam);
        this.mParam = decodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setEdgeDownMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mEdgeDownMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(257);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setPolarityPositiveMapping(MappingObject mappingObject) {
        updateRegistration(8, mappingObject);
        this.mPolarityPositiveMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(644);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setEdgeUpMapping(MappingObject mappingObject) {
        updateRegistration(9, mappingObject);
        this.mEdgeUpMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(270);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setModeCsMapping(MappingObject mappingObject) {
        updateRegistration(11, mappingObject);
        this.mModeCsMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(545);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setEndianMsbMapping(MappingObject mappingObject) {
        updateRegistration(12, mappingObject);
        this.mEndianMsbMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(276);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setCsNegativeMapping(MappingObject mappingObject) {
        updateRegistration(13, mappingObject);
        this.mCsNegativeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        notifyPropertyChanged(194);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeSpiBinding
    public void setCsPositiveMapping(MappingObject mappingObject) {
        updateRegistration(14, mappingObject);
        this.mCsPositiveMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
        }
        notifyPropertyChanged(195);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangePolarityNegativeMapping((MappingObject) obj, i2);
            case 1:
                return onChangeModeTimeoutMapping((MappingObject) obj, i2);
            case 2:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSpiMisoParamSpiMiso((MappingObject) obj, i2);
            case 3:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSpiClkParamSpiClock((MappingObject) obj, i2);
            case 4:
                return onChangeEndianLsbMapping((MappingObject) obj, i2);
            case 5:
                return onChangeParam((DecodeParam) obj, i2);
            case 6:
                return onChangeEdgeDownMapping((MappingObject) obj, i2);
            case 7:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSpiMosiParamSpiMosi((MappingObject) obj, i2);
            case 8:
                return onChangePolarityPositiveMapping((MappingObject) obj, i2);
            case 9:
                return onChangeEdgeUpMapping((MappingObject) obj, i2);
            case 10:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSpiCsParamSpiCs((MappingObject) obj, i2);
            case 11:
                return onChangeModeCsMapping((MappingObject) obj, i2);
            case 12:
                return onChangeEndianMsbMapping((MappingObject) obj, i2);
            case 13:
                return onChangeCsNegativeMapping((MappingObject) obj, i2);
            case 14:
                return onChangeCsPositiveMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangePolarityNegativeMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeModeTimeoutMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSpiMisoParamSpiMiso(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSpiClkParamSpiClock(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeEndianLsbMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(DecodeParam decodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 888) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 878) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 880) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 889) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 886) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 891) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 890) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 887) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else if (i == 879) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else if (i == 892) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else if (i == 881) {
            synchronized (this) {
                this.mDirtyFlags |= 268435456;
            }
            return true;
        } else if (i == 883) {
            synchronized (this) {
                this.mDirtyFlags |= 536870912;
            }
            return true;
        } else if (i == 885) {
            synchronized (this) {
                this.mDirtyFlags |= 1073741824;
            }
            return true;
        } else if (i == 884) {
            synchronized (this) {
                this.mDirtyFlags |= 2147483648L;
            }
            return true;
        } else if (i == 882) {
            synchronized (this) {
                this.mDirtyFlags |= 4294967296L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeEdgeDownMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 8589934592L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSpiMosiParamSpiMosi(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean onChangePolarityPositiveMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 17179869184L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeEdgeUpMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 34359738368L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeSpiCsParamSpiCs(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeModeCsMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 68719476736L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeEndianMsbMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 137438953472L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeCsNegativeMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 274877906944L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeCsPositiveMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 549755813888L;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c4  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 2125
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterDecodeSpiBindingImpl.executeBindings():void");
    }
}
