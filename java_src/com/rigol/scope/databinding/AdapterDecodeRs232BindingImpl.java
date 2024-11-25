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
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class AdapterDecodeRs232BindingImpl extends AdapterDecodeRs232Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.decode_rs232_layout, 16);
        sViewsWithIds.put(R.id.guideline_left, 17);
        sViewsWithIds.put(R.id.guideline_center, 18);
        sViewsWithIds.put(R.id.guideline_right, 19);
        sViewsWithIds.put(R.id.guideline_33, 20);
        sViewsWithIds.put(R.id.guideline_66, 21);
        sViewsWithIds.put(R.id.decode_rs232_tx_label, 22);
        sViewsWithIds.put(R.id.decode_rs232_rx_label, 23);
        sViewsWithIds.put(R.id.divider2, 24);
        sViewsWithIds.put(R.id.decode_rs232_baud_label, 25);
        sViewsWithIds.put(R.id.decode_rs232_pol_label, 26);
        sViewsWithIds.put(R.id.decode_rs232_pol_radioGroup, 27);
        sViewsWithIds.put(R.id.decode_rs232_endian_label, 28);
        sViewsWithIds.put(R.id.decode_rs232_parity_label, 29);
        sViewsWithIds.put(R.id.decode_rs232_packend_label, 30);
        sViewsWithIds.put(R.id.decode_rs232_width_label, 31);
        sViewsWithIds.put(R.id.decode_rs232_stop_label, 32);
        sViewsWithIds.put(R.id.decode_rs232_packen_label, 33);
    }

    public AdapterDecodeRs232BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 34, sIncludes, sViewsWithIds));
    }

    private AdapterDecodeRs232BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 10, (TextView) objArr[25], (TextView) objArr[7], (TextView) objArr[28], (TextView) objArr[13], (RadioButton) objArr[8], (ConstraintLayout) objArr[16], (RadioButton) objArr[9], (TextView) objArr[33], (SwitchButton) objArr[10], (TextView) objArr[30], (TextView) objArr[15], (TextView) objArr[29], (TextView) objArr[14], (TextView) objArr[26], (RadioGroup) objArr[27], (TextView) objArr[23], (TextView) objArr[1], (TextView) objArr[32], (TextView) objArr[11], (TextView) objArr[22], (TextView) objArr[2], (TextView) objArr[31], (TextView) objArr[12], (TextView) objArr[3], (TextView) objArr[5], (TextView) objArr[4], (TextView) objArr[6], (View) objArr[24], (Guideline) objArr[20], (Guideline) objArr[21], (Guideline) objArr[18], (Guideline) objArr[17], (Guideline) objArr[19]);
        this.mDirtyFlags = -1L;
        this.decodeRs232BaudValue.setTag(null);
        this.decodeRs232EndianValue.setTag(null);
        this.decodeRs232InvertRadioButton.setTag(null);
        this.decodeRs232NegativeRadioButton.setTag(null);
        this.decodeRs232PackenValue.setTag(null);
        this.decodeRs232PackendValue.setTag(null);
        this.decodeRs232ParityValue.setTag(null);
        this.decodeRs232RxValue.setTag(null);
        this.decodeRs232StopValue.setTag(null);
        this.decodeRs232TxValue.setTag(null);
        this.decodeRs232WidthValue.setTag(null);
        this.decodeRxThresLabel.setTag(null);
        this.decodeRxThresValue.setTag(null);
        this.decodeTxThresLabel.setTag(null);
        this.decodeTxThresValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 268435456L;
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
        if (650 == i) {
            setPositiveMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((DecodeParam) obj);
        } else if (558 != i) {
            return false;
        } else {
            setNegativeMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeRs232Binding
    public void setPositiveMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mPositiveMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(650);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeRs232Binding
    public void setParam(DecodeParam decodeParam) {
        updateRegistration(4, decodeParam);
        this.mParam = decodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeRs232Binding
    public void setNegativeMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mNegativeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(558);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangePositiveMapping((MappingObject) obj, i2);
            case 1:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeRs232TxParamRs232Tx((MappingObject) obj, i2);
            case 2:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeRs232EndianParamRs232EndianBooleanTrueInt1Int0((MappingObject) obj, i2);
            case 3:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeRs232StopParamRs232Stop((MappingObject) obj, i2);
            case 4:
                return onChangeParam((DecodeParam) obj, i2);
            case 5:
                return onChangeNegativeMapping((MappingObject) obj, i2);
            case 6:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeRs232PackendParamRs232PackageEnd((MappingObject) obj, i2);
            case 7:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeRs232WidthParamRs232Width((MappingObject) obj, i2);
            case 8:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeRs232RxParamRs232Rx((MappingObject) obj, i2);
            case 9:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeRs232ParityParamRs232Parity((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangePositiveMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeRs232TxParamRs232Tx(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeRs232EndianParamRs232EndianBooleanTrueInt1Int0(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeRs232StopParamRs232Stop(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
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

    private boolean onChangeParam(DecodeParam decodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 752) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 755) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 753) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 756) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 746) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 751) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 748) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 754) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 757) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 747) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 750) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 749) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeNegativeMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeRs232PackendParamRs232PackageEnd(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeRs232WidthParamRs232Width(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeRs232RxParamRs232Rx(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeRs232ParityParamRs232Parity(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01d8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0188 A[ADDED_TO_REGION] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1123
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterDecodeRs232BindingImpl.executeBindings():void");
    }
}
