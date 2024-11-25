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
public class AdapterDecodeI2sBindingImpl extends AdapterDecodeI2sBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.decode_i2s_layout, 17);
        sViewsWithIds.put(R.id.guideline_left, 18);
        sViewsWithIds.put(R.id.guideline_center, 19);
        sViewsWithIds.put(R.id.guideline_right, 20);
        sViewsWithIds.put(R.id.guideline_33, 21);
        sViewsWithIds.put(R.id.guideline_66, 22);
        sViewsWithIds.put(R.id.decode_i2s_align_label, 23);
        sViewsWithIds.put(R.id.decode_i2s_sclk_label, 24);
        sViewsWithIds.put(R.id.decode_i2s_sclk_thres_label, 25);
        sViewsWithIds.put(R.id.decode_i2s_data_label, 26);
        sViewsWithIds.put(R.id.decode_i2s_ws_thre_label, 27);
        sViewsWithIds.put(R.id.decode_i2s_sclkedge_label, 28);
        sViewsWithIds.put(R.id.decode_i2s_sclkedge_radioGroup, 29);
        sViewsWithIds.put(R.id.decode_i2s_ws_label, 30);
        sViewsWithIds.put(R.id.decode_i2s_data_thres_label, 31);
        sViewsWithIds.put(R.id.divider1, 32);
        sViewsWithIds.put(R.id.decode_i2s_word_label, 33);
        sViewsWithIds.put(R.id.decode_i2s_wslow_label, 34);
        sViewsWithIds.put(R.id.decode_i2s_receive_label, 35);
        sViewsWithIds.put(R.id.decode_i2s_endian_label, 36);
        sViewsWithIds.put(R.id.decode_i2s_endian_radioGroup, 37);
        sViewsWithIds.put(R.id.decode_i2s_pol_label, 38);
        sViewsWithIds.put(R.id.decode_i2s_pol_radioGroup, 39);
    }

    public AdapterDecodeI2sBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 40, sIncludes, sViewsWithIds));
    }

    private AdapterDecodeI2sBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 12, (TextView) objArr[23], (TextView) objArr[11], (TextView) objArr[26], (TextView) objArr[31], (TextView) objArr[4], (TextView) objArr[3], (RadioButton) objArr[14], (TextView) objArr[36], (RadioButton) objArr[13], (RadioGroup) objArr[37], (ConstraintLayout) objArr[17], (TextView) objArr[38], (RadioButton) objArr[16], (RadioButton) objArr[15], (RadioGroup) objArr[39], (TextView) objArr[35], (TextView) objArr[9], (TextView) objArr[24], (TextView) objArr[25], (TextView) objArr[2], (TextView) objArr[1], (RadioButton) objArr[7], (TextView) objArr[28], (RadioGroup) objArr[29], (RadioButton) objArr[6], (TextView) objArr[33], (TextView) objArr[10], (TextView) objArr[30], (TextView) objArr[27], (TextView) objArr[5], (TextView) objArr[8], (TextView) objArr[34], (TextView) objArr[12], (View) objArr[32], (Guideline) objArr[21], (Guideline) objArr[22], (Guideline) objArr[19], (Guideline) objArr[18], (Guideline) objArr[20]);
        this.mDirtyFlags = -1L;
        this.decodeI2sAlignValue.setTag(null);
        this.decodeI2sDataThresValue.setTag(null);
        this.decodeI2sDataValue.setTag(null);
        this.decodeI2sEndianLSBRadioButton.setTag(null);
        this.decodeI2sEndianMSBRadioButton.setTag(null);
        this.decodeI2sPolNegativeRadioButton.setTag(null);
        this.decodeI2sPolPositiveRadioButton.setTag(null);
        this.decodeI2sReceiveValue.setTag(null);
        this.decodeI2sSclkThresValue.setTag(null);
        this.decodeI2sSclkValue.setTag(null);
        this.decodeI2sSclkedgeDownRadioButton.setTag(null);
        this.decodeI2sSclkedgeUpRadioButton.setTag(null);
        this.decodeI2sWordValue.setTag(null);
        this.decodeI2sWsThresValue.setTag(null);
        this.decodeI2sWsValue.setTag(null);
        this.decodeI2sWslowValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8589934592L;
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
        if (220 == i) {
            setDataPositiveMapping((MappingObject) obj);
        } else if (275 == i) {
            setEndianLsbMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((DecodeParam) obj);
        } else if (219 == i) {
            setDataNegativeMapping((MappingObject) obj);
        } else if (257 == i) {
            setEdgeDownMapping((MappingObject) obj);
        } else if (270 == i) {
            setEdgeUpMapping((MappingObject) obj);
        } else if (276 != i) {
            return false;
        } else {
            setEndianMsbMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeI2sBinding
    public void setDataPositiveMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mDataPositiveMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(220);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeI2sBinding
    public void setEndianLsbMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mEndianLsbMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(275);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeI2sBinding
    public void setParam(DecodeParam decodeParam) {
        updateRegistration(5, decodeParam);
        this.mParam = decodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeI2sBinding
    public void setDataNegativeMapping(MappingObject mappingObject) {
        updateRegistration(7, mappingObject);
        this.mDataNegativeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(219);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeI2sBinding
    public void setEdgeDownMapping(MappingObject mappingObject) {
        updateRegistration(8, mappingObject);
        this.mEdgeDownMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(257);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeI2sBinding
    public void setEdgeUpMapping(MappingObject mappingObject) {
        updateRegistration(10, mappingObject);
        this.mEdgeUpMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(270);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeI2sBinding
    public void setEndianMsbMapping(MappingObject mappingObject) {
        updateRegistration(11, mappingObject);
        this.mEndianMsbMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(276);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeDataPositiveMapping((MappingObject) obj, i2);
            case 1:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeI2sSclkParamI2sSclock((MappingObject) obj, i2);
            case 2:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeI2sWslowParamI2sWsLow((MappingObject) obj, i2);
            case 3:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeI2sWsParamI2sWs((MappingObject) obj, i2);
            case 4:
                return onChangeEndianLsbMapping((MappingObject) obj, i2);
            case 5:
                return onChangeParam((DecodeParam) obj, i2);
            case 6:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeI2sAlignParamI2sAlign((MappingObject) obj, i2);
            case 7:
                return onChangeDataNegativeMapping((MappingObject) obj, i2);
            case 8:
                return onChangeEdgeDownMapping((MappingObject) obj, i2);
            case 9:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeI2sDataParamI2sData((MappingObject) obj, i2);
            case 10:
                return onChangeEdgeUpMapping((MappingObject) obj, i2);
            case 11:
                return onChangeEndianMsbMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeDataPositiveMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeI2sSclkParamI2sSclock(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeI2sWslowParamI2sWsLow(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeI2sWsParamI2sWs(MappingObject mappingObject, int i) {
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
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
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
        } else if (i == 401) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 403) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 396) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 398) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 404) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 402) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 406) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 400) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 405) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 395) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 407) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else if (i == 399) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else if (i == 397) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeI2sAlignParamI2sAlign(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 268435456;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeDataNegativeMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 536870912;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeEdgeDownMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 1073741824;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeI2sDataParamI2sData(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeEdgeUpMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 2147483648L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeEndianMsbMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 4294967296L;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e0  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterDecodeI2sBindingImpl.executeBindings():void");
    }
}
