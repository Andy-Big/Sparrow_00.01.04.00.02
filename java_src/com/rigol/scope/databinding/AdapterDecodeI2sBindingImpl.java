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
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;

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

    /* JADX DEBUG: Multi-variable search result rejected for r4v23, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r5v5, resolved type: boolean */
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
    */
    protected void executeBindings() {
        long j;
        String str;
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        boolean z4;
        int i2;
        int i3;
        int i4;
        int i5;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        int i6;
        String str14;
        int i7;
        long j2;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        String str15;
        ServiceEnum.Unit unit;
        String str16;
        int i8;
        String str17;
        String str18;
        int i9;
        String str19;
        String str20;
        long j3;
        int i10;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        int i11;
        String str26;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        long j4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mDataPositiveMapping;
        MappingObject mappingObject2 = this.mEndianLsbMapping;
        DecodeParam decodeParam = this.mParam;
        MappingObject mappingObject3 = this.mDataNegativeMapping;
        MappingObject mappingObject4 = this.mEdgeDownMapping;
        MappingObject mappingObject5 = this.mEdgeUpMapping;
        MappingObject mappingObject6 = this.mEndianMsbMapping;
        String str27 = ((j & 8589938689L) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        String str28 = ((j & 8589950992L) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        if ((j & 9126781550L) != 0) {
            if ((j & 8598323232L) != 0) {
                str13 = String.valueOf(decodeParam != null ? decodeParam.getI2s_word() : 0L);
            } else {
                str13 = null;
            }
            if ((j & 8592031784L) != 0) {
                int i2s_ws = decodeParam != null ? decodeParam.getI2s_ws() : 0;
                MappingObject mappingObject7 = ViewUtil.getMappingObject(R.array.msg_decode_i2s_ws, i2s_ws);
                updateRegistration(3, mappingObject7);
                str14 = mappingObject7 != null ? mappingObject7.getStr() : null;
                i6 = (j & 8592031776L) != 0 ? ColorUtil.getColor(getRoot().getContext(), i2s_ws) : 0;
            } else {
                i6 = 0;
                str14 = null;
            }
            int i20 = ((j & 8590000160L) > 0L ? 1 : ((j & 8590000160L) == 0L ? 0 : -1));
            if (i20 == 0 || decodeParam == null) {
                str6 = str14;
                i7 = i6;
                j2 = 0;
            } else {
                str6 = str14;
                i7 = i6;
                j2 = decodeParam.getI2s_sclock_thres();
            }
            if ((j & 8724152352L) != 0) {
                z5 = decodeParam != null ? decodeParam.isI2s_data_polarity() : false;
                z6 = !z5;
            } else {
                z5 = false;
                z6 = false;
            }
            if ((j & 8657043488L) != 0) {
                z7 = decodeParam != null ? decodeParam.isI2s_endian() : false;
                z8 = !z7;
            } else {
                z7 = false;
                z8 = false;
            }
            if ((j & 8594128928L) != 0) {
                str15 = String.valueOf(decodeParam != null ? decodeParam.getI2s_receive() : 0L);
            } else {
                str15 = null;
            }
            if ((j & 8590786592L) != 0) {
                unit = decodeParam != null ? decodeParam.getUnit() : null;
                if (i20 != 0) {
                    str16 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j2, unit);
                    if ((j & 8590066208L) == 0) {
                        int i2s_data = decodeParam != null ? decodeParam.getI2s_data() : 0;
                        i8 = (j & 8590065696L) != 0 ? ColorUtil.getColor(getRoot().getContext(), i2s_data) : 0;
                        MappingObject mappingObject8 = ViewUtil.getMappingObject(R.array.msg_decode_i2s_data, i2s_data);
                        updateRegistration(9, mappingObject8);
                        if (mappingObject8 != null) {
                            str17 = mappingObject8.getStr();
                            if ((j & 8590196768L) != 0) {
                                if (decodeParam != null) {
                                    str4 = str17;
                                    i9 = i8;
                                    j4 = decodeParam.getI2s_data_thres();
                                } else {
                                    str4 = str17;
                                    i9 = i8;
                                    j4 = 0;
                                }
                                str18 = str16;
                                str19 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j4, unit);
                            } else {
                                str18 = str16;
                                str4 = str17;
                                i9 = i8;
                                str19 = null;
                            }
                            if ((j & 8589967394L) != 0) {
                                if (decodeParam != null) {
                                    i19 = decodeParam.getI2s_sclock();
                                    str20 = str19;
                                } else {
                                    str20 = str19;
                                    i19 = 0;
                                }
                                MappingObject mappingObject9 = ViewUtil.getMappingObject(R.array.msg_decode_i2s_sclk, i19);
                                updateRegistration(1, mappingObject9);
                                str21 = mappingObject9 != null ? mappingObject9.getStr() : null;
                                j3 = 0;
                                i10 = (j & 8589967392L) != 0 ? ColorUtil.getColor(getRoot().getContext(), i19) : 0;
                            } else {
                                str20 = str19;
                                j3 = 0;
                                i10 = 0;
                                str21 = null;
                            }
                            if ((j & 8623497252L) != j3) {
                                if (decodeParam != null) {
                                    i18 = decodeParam.getI2s_ws_low();
                                    str22 = str21;
                                } else {
                                    str22 = str21;
                                    i18 = 0;
                                }
                                MappingObject mappingObject10 = ViewUtil.getMappingObject(R.array.msg_decode_i2s_wslow, i18);
                                updateRegistration(2, mappingObject10);
                                if (mappingObject10 != null) {
                                    str23 = mappingObject10.getStr();
                                    if ((j & 8875147360L) == 0) {
                                        if (decodeParam != null) {
                                            i17 = decodeParam.getI2s_align();
                                            str24 = str23;
                                        } else {
                                            str24 = str23;
                                            i17 = 0;
                                        }
                                        MappingObject mappingObject11 = ViewUtil.getMappingObject(R.array.msg_decode_i2s_align, i17);
                                        updateRegistration(6, mappingObject11);
                                        if (mappingObject11 != null) {
                                            str25 = mappingObject11.getStr();
                                            i11 = ((j & 8590983200L) > 0L ? 1 : ((j & 8590983200L) == 0L ? 0 : -1));
                                            if (i11 != 0) {
                                                if (decodeParam != null) {
                                                    str26 = str25;
                                                    i14 = decodeParam.getI2s_sclock_edge();
                                                } else {
                                                    str26 = str25;
                                                    i14 = 0;
                                                }
                                                i12 = i10;
                                                if (i14 == 0) {
                                                    i16 = 1;
                                                    i15 = 1;
                                                } else {
                                                    i15 = 0;
                                                    i16 = 1;
                                                }
                                                r50 = i14 == i16 ? i16 : 0;
                                                if (i11 != 0) {
                                                    j |= i15 != 0 ? 34359738368L : 17179869184L;
                                                }
                                                if ((j & 8590983200L) != 0) {
                                                    j |= r50 != 0 ? 137438953472L : 68719476736L;
                                                }
                                                i13 = r50;
                                                r50 = i15;
                                            } else {
                                                str26 = str25;
                                                i12 = i10;
                                                i13 = 0;
                                            }
                                            if ((j & 8590458912L) != 0) {
                                                String convert = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(decodeParam != null ? decodeParam.getI2s_wave_singal_thres() : 0L, unit);
                                                i4 = i13;
                                                i3 = r50;
                                                i5 = i7;
                                                z2 = z6;
                                                z3 = z8;
                                                str11 = str15;
                                                str3 = str20;
                                                str9 = str22;
                                                str5 = str24;
                                                str2 = str26;
                                                i2 = i12;
                                                str = str27;
                                                str7 = convert;
                                                z = z5;
                                                i = i9;
                                            } else {
                                                i4 = i13;
                                                i3 = r50;
                                                i5 = i7;
                                                z2 = z6;
                                                z3 = z8;
                                                str11 = str15;
                                                i = i9;
                                                str3 = str20;
                                                str9 = str22;
                                                str5 = str24;
                                                str2 = str26;
                                                i2 = i12;
                                                str7 = null;
                                                str = str27;
                                                z = z5;
                                            }
                                            str8 = str13;
                                            z4 = z7;
                                            str10 = str18;
                                        }
                                    } else {
                                        str24 = str23;
                                    }
                                    str25 = null;
                                    i11 = ((j & 8590983200L) > 0L ? 1 : ((j & 8590983200L) == 0L ? 0 : -1));
                                    if (i11 != 0) {
                                    }
                                    if ((j & 8590458912L) != 0) {
                                    }
                                    str8 = str13;
                                    z4 = z7;
                                    str10 = str18;
                                }
                            } else {
                                str22 = str21;
                            }
                            str23 = null;
                            if ((j & 8875147360L) == 0) {
                            }
                            str25 = null;
                            i11 = ((j & 8590983200L) > 0L ? 1 : ((j & 8590983200L) == 0L ? 0 : -1));
                            if (i11 != 0) {
                            }
                            if ((j & 8590458912L) != 0) {
                            }
                            str8 = str13;
                            z4 = z7;
                            str10 = str18;
                        }
                    } else {
                        i8 = 0;
                    }
                    str17 = null;
                    if ((j & 8590196768L) != 0) {
                    }
                    if ((j & 8589967394L) != 0) {
                    }
                    if ((j & 8623497252L) != j3) {
                    }
                    str23 = null;
                    if ((j & 8875147360L) == 0) {
                    }
                    str25 = null;
                    i11 = ((j & 8590983200L) > 0L ? 1 : ((j & 8590983200L) == 0L ? 0 : -1));
                    if (i11 != 0) {
                    }
                    if ((j & 8590458912L) != 0) {
                    }
                    str8 = str13;
                    z4 = z7;
                    str10 = str18;
                }
            } else {
                unit = null;
            }
            str16 = null;
            if ((j & 8590066208L) == 0) {
            }
            str17 = null;
            if ((j & 8590196768L) != 0) {
            }
            if ((j & 8589967394L) != 0) {
            }
            if ((j & 8623497252L) != j3) {
            }
            str23 = null;
            if ((j & 8875147360L) == 0) {
            }
            str25 = null;
            i11 = ((j & 8590983200L) > 0L ? 1 : ((j & 8590983200L) == 0L ? 0 : -1));
            if (i11 != 0) {
            }
            if ((j & 8590458912L) != 0) {
            }
            str8 = str13;
            z4 = z7;
            str10 = str18;
        } else {
            str = str27;
            z = false;
            i = 0;
            z2 = false;
            z3 = false;
            z4 = false;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
            str11 = null;
        }
        int i21 = ((j & 9126805632L) > 0L ? 1 : ((j & 9126805632L) == 0L ? 0 : -1));
        String str29 = (i21 == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        int i22 = ((j & 9663676672L) > 0L ? 1 : ((j & 9663676672L) == 0L ? 0 : -1));
        String str30 = (i22 == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        int i23 = ((j & 10737419264L) > 0L ? 1 : ((j & 10737419264L) == 0L ? 0 : -1));
        String str31 = (i23 == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        int i24 = ((j & 12884903936L) > 0L ? 1 : ((j & 12884903936L) == 0L ? 0 : -1));
        String str32 = (i24 == 0 || mappingObject6 == null) ? null : mappingObject6.getStr();
        if ((j & 8875147360L) != 0) {
            str12 = str31;
            TextViewBindingAdapter.setText(this.decodeI2sAlignValue, str2);
        } else {
            str12 = str31;
        }
        if ((j & 8590196768L) != 0) {
            TextViewBindingAdapter.setText(this.decodeI2sDataThresValue, str3);
        }
        if ((j & 8590066208L) != 0) {
            TextViewBindingAdapter.setText(this.decodeI2sDataValue, str4);
        }
        if ((j & 8590065696L) != 0) {
            this.decodeI2sDataValue.setTextColor(i);
        }
        if ((j & 8657043488L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.decodeI2sEndianLSBRadioButton, z4);
            CompoundButtonBindingAdapter.setChecked(this.decodeI2sEndianMSBRadioButton, z3);
        }
        if ((j & 8589950992L) != 0) {
            TextViewBindingAdapter.setText(this.decodeI2sEndianLSBRadioButton, str28);
        }
        if (i24 != 0) {
            TextViewBindingAdapter.setText(this.decodeI2sEndianMSBRadioButton, str32);
        }
        if ((j & 8724152352L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.decodeI2sPolNegativeRadioButton, z2);
            CompoundButtonBindingAdapter.setChecked(this.decodeI2sPolPositiveRadioButton, z);
        }
        if (i21 != 0) {
            TextViewBindingAdapter.setText(this.decodeI2sPolNegativeRadioButton, str29);
        }
        if ((8589938689L & j) != 0) {
            TextViewBindingAdapter.setText(this.decodeI2sPolPositiveRadioButton, str);
        }
        if ((j & 8594128928L) != 0) {
            TextViewBindingAdapter.setText(this.decodeI2sReceiveValue, str11);
        }
        if ((j & 8590000160L) != 0) {
            TextViewBindingAdapter.setText(this.decodeI2sSclkThresValue, str10);
        }
        if ((j & 8589967394L) != 0) {
            TextViewBindingAdapter.setText(this.decodeI2sSclkValue, str9);
        }
        if ((j & 8589967392L) != 0) {
            this.decodeI2sSclkValue.setTextColor(i2);
        }
        if ((j & 8590983200L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.decodeI2sSclkedgeDownRadioButton, i3);
            CompoundButtonBindingAdapter.setChecked(this.decodeI2sSclkedgeUpRadioButton, i4);
        }
        if (i22 != 0) {
            TextViewBindingAdapter.setText(this.decodeI2sSclkedgeDownRadioButton, str30);
        }
        if (i23 != 0) {
            TextViewBindingAdapter.setText(this.decodeI2sSclkedgeUpRadioButton, str12);
        }
        if ((j & 8598323232L) != 0) {
            TextViewBindingAdapter.setText(this.decodeI2sWordValue, str8);
        }
        if ((j & 8590458912L) != 0) {
            TextViewBindingAdapter.setText(this.decodeI2sWsThresValue, str7);
        }
        if ((j & 8592031784L) != 0) {
            TextViewBindingAdapter.setText(this.decodeI2sWsValue, str6);
        }
        if ((j & 8592031776L) != 0) {
            this.decodeI2sWsValue.setTextColor(i5);
        }
        if ((j & 8623497252L) != 0) {
            TextViewBindingAdapter.setText(this.decodeI2sWslowValue, str5);
        }
    }
}
