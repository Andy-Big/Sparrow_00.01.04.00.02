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
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
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
    */
    protected void executeBindings() {
        long j;
        float f;
        float f2;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i2;
        int i3;
        int i4;
        boolean z5;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        boolean z6;
        float f3;
        int i5;
        int i6;
        boolean z7;
        String str11;
        String str12;
        int i7;
        boolean z8;
        int i8;
        String str13;
        boolean z9;
        boolean z10;
        int i9;
        int i10;
        boolean z11;
        long j2;
        String str14;
        String str15;
        String str16;
        String str17;
        boolean z12;
        String str18;
        String str19;
        int i11;
        String str20;
        String str21;
        String str22;
        String str23;
        ServiceEnum.Unit unit;
        int i12;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mPositiveMapping;
        DecodeParam decodeParam = this.mParam;
        MappingObject mappingObject2 = this.mNegativeMapping;
        String str24 = ((j & 268436481) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        float f4 = 0.0f;
        if ((503315422 & j) != 0) {
            if ((j & 268443920) != 0) {
                int rs232_rx = decodeParam != null ? decodeParam.getRs232_rx() : 0;
                int i13 = ((j & 268443664) > 0L ? 1 : ((j & 268443664) == 0L ? 0 : -1));
                if (i13 != 0) {
                    z7 = rs232_rx < 8;
                    boolean z13 = rs232_rx == 0;
                    i5 = ColorUtil.getColorDoedCode(getRoot().getContext(), rs232_rx);
                    if (i13 != 0) {
                        j |= z13 ? 1073741824L : 536870912L;
                    }
                    f3 = ContextUtil.getAlpha(z7);
                    i6 = z13 ? 4 : 0;
                } else {
                    f3 = 0.0f;
                    i5 = 0;
                    i6 = 0;
                    z7 = false;
                }
                MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_decode_rs232_rx, rs232_rx);
                updateRegistration(8, mappingObject3);
                if (mappingObject3 != null) {
                    str11 = mappingObject3.getStr();
                    long rs232_rx_thres = ((j & 268468240) != 0 || decodeParam == null) ? 0L : decodeParam.getRs232_rx_thres();
                    if ((j & 337641616) != 0) {
                        MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_decode_rs232_width, decodeParam != null ? decodeParam.getRs232_width() : 0);
                        updateRegistration(7, mappingObject4);
                        if (mappingObject4 != null) {
                            str12 = mappingObject4.getStr();
                            if ((j & 268451858) != 0) {
                                int rs232_tx = decodeParam != null ? decodeParam.getRs232_tx() : 0;
                                MappingObject mappingObject5 = ViewUtil.getMappingObject(R.array.msg_decode_rs232_tx, rs232_tx);
                                updateRegistration(1, mappingObject5);
                                String str25 = mappingObject5 != null ? mappingObject5.getStr() : null;
                                int i14 = ((j & 268451856) > 0L ? 1 : ((j & 268451856) == 0L ? 0 : -1));
                                if (i14 != 0) {
                                    str13 = str25;
                                    int colorDoedCode = ColorUtil.getColorDoedCode(getRoot().getContext(), rs232_tx);
                                    boolean z14 = rs232_tx < 8;
                                    boolean z15 = rs232_tx == 0;
                                    if (i14 != 0) {
                                        j |= z15 ? 4294967296L : 2147483648L;
                                    }
                                    float alpha = ContextUtil.getAlpha(z14);
                                    i8 = z15 ? 4 : 0;
                                    z8 = z14;
                                    i7 = colorDoedCode;
                                    f4 = alpha;
                                } else {
                                    str13 = str25;
                                    i7 = 0;
                                    z8 = false;
                                    i8 = 0;
                                }
                            } else {
                                i7 = 0;
                                z8 = false;
                                i8 = 0;
                                str13 = null;
                            }
                            if ((j & 268697616) != 0) {
                                z9 = decodeParam != null ? decodeParam.isRs232_pol() : false;
                                z10 = !z9;
                            } else {
                                z9 = false;
                                z10 = false;
                            }
                            i9 = ((j & 268501008) > 0L ? 1 : ((j & 268501008) == 0L ? 0 : -1));
                            if (i9 != 0 || decodeParam == null) {
                                i10 = i7;
                                z11 = z8;
                                j2 = 0;
                            } else {
                                i10 = i7;
                                z11 = z8;
                                j2 = decodeParam.getRs232_tx_thres();
                            }
                            if ((j & 411042320) != 0) {
                                if (decodeParam != null) {
                                    str15 = str11;
                                    str14 = str12;
                                    i12 = decodeParam.getRs232_parity();
                                } else {
                                    str14 = str12;
                                    str15 = str11;
                                    i12 = 0;
                                }
                                MappingObject mappingObject6 = ViewUtil.getMappingObject(R.array.msg_decode_rs232_parity, i12);
                                updateRegistration(9, mappingObject6);
                                if (mappingObject6 != null) {
                                    str16 = mappingObject6.getStr();
                                    boolean isRs232_package = ((j & 268959760) != 0 || decodeParam == null) ? false : decodeParam.isRs232_package();
                                    if ((j & 268533776) == 0) {
                                        if (decodeParam != null) {
                                            str17 = str16;
                                            unit = decodeParam.getUnit();
                                        } else {
                                            str17 = str16;
                                            unit = null;
                                        }
                                        if ((j & 268468240) != 0) {
                                            z12 = isRs232_package;
                                            str19 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(rs232_rx_thres, unit);
                                        } else {
                                            z12 = isRs232_package;
                                            str19 = null;
                                        }
                                        str18 = i9 != 0 ? UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j2, unit) : null;
                                    } else {
                                        str17 = str16;
                                        z12 = isRs232_package;
                                        str18 = null;
                                        str19 = null;
                                    }
                                    i11 = ((j & 272631828) > 0L ? 1 : ((j & 272631828) == 0L ? 0 : -1));
                                    if (i11 != 0) {
                                        int i15 = decodeParam != null ? decodeParam.getRs232_endian() : false ? 1 : 0;
                                        if (i11 != 0) {
                                            j |= i15 != 0 ? 17179869184L : 8589934592L;
                                        }
                                        MappingObject mappingObject7 = ViewUtil.getMappingObject(R.array.msg_decode_rs232_endian, i15);
                                        updateRegistration(2, mappingObject7);
                                        if (mappingObject7 != null) {
                                            str20 = mappingObject7.getStr();
                                            if ((j & 268566544) != 0) {
                                                str21 = str18;
                                                str22 = str20;
                                                str = UnitFormat.newBuilder(" 0.###  ", UnitFormat.SI.NONE).convert(decodeParam != null ? decodeParam.getRs232_baud() : 0, ServiceEnum.Unit.Unit_none) + "bps";
                                            } else {
                                                str21 = str18;
                                                str22 = str20;
                                                str = null;
                                            }
                                            if ((j & 269488152) != 0) {
                                                MappingObject mappingObject8 = ViewUtil.getMappingObject(R.array.msg_decode_rs232_stop, decodeParam != null ? decodeParam.getRs232_stop() : 0);
                                                updateRegistration(3, mappingObject8);
                                                if (mappingObject8 != null) {
                                                    str23 = mappingObject8.getStr();
                                                    if ((j & 285212752) != 0) {
                                                        MappingObject mappingObject9 = ViewUtil.getMappingObject(R.array.msg_decode_rs232_packend, decodeParam != null ? decodeParam.getRs232_package_end() : 0);
                                                        updateRegistration(6, mappingObject9);
                                                        if (mappingObject9 != null) {
                                                            str3 = mappingObject9.getStr();
                                                            str7 = str19;
                                                            i = i6;
                                                            i4 = i8;
                                                            z2 = z10;
                                                            str10 = str13;
                                                            i3 = i10;
                                                            z5 = z11;
                                                            str8 = str14;
                                                            str4 = str17;
                                                            str9 = str23;
                                                            i2 = i5;
                                                            z4 = z7;
                                                            str2 = str22;
                                                            f2 = f3;
                                                            f = f4;
                                                            z = z12;
                                                            str6 = str21;
                                                            z3 = z9;
                                                            str5 = str15;
                                                        }
                                                    }
                                                    str7 = str19;
                                                    i = i6;
                                                    i4 = i8;
                                                    z2 = z10;
                                                    str10 = str13;
                                                    i3 = i10;
                                                    z5 = z11;
                                                    str8 = str14;
                                                    str4 = str17;
                                                    str3 = null;
                                                    str9 = str23;
                                                    i2 = i5;
                                                    z4 = z7;
                                                    str2 = str22;
                                                    f2 = f3;
                                                    f = f4;
                                                    z = z12;
                                                    str6 = str21;
                                                    z3 = z9;
                                                    str5 = str15;
                                                }
                                            }
                                            str23 = null;
                                            if ((j & 285212752) != 0) {
                                            }
                                            str7 = str19;
                                            i = i6;
                                            i4 = i8;
                                            z2 = z10;
                                            str10 = str13;
                                            i3 = i10;
                                            z5 = z11;
                                            str8 = str14;
                                            str4 = str17;
                                            str3 = null;
                                            str9 = str23;
                                            i2 = i5;
                                            z4 = z7;
                                            str2 = str22;
                                            f2 = f3;
                                            f = f4;
                                            z = z12;
                                            str6 = str21;
                                            z3 = z9;
                                            str5 = str15;
                                        }
                                    }
                                    str20 = null;
                                    if ((j & 268566544) != 0) {
                                    }
                                    if ((j & 269488152) != 0) {
                                    }
                                    str23 = null;
                                    if ((j & 285212752) != 0) {
                                    }
                                    str7 = str19;
                                    i = i6;
                                    i4 = i8;
                                    z2 = z10;
                                    str10 = str13;
                                    i3 = i10;
                                    z5 = z11;
                                    str8 = str14;
                                    str4 = str17;
                                    str3 = null;
                                    str9 = str23;
                                    i2 = i5;
                                    z4 = z7;
                                    str2 = str22;
                                    f2 = f3;
                                    f = f4;
                                    z = z12;
                                    str6 = str21;
                                    z3 = z9;
                                    str5 = str15;
                                }
                            } else {
                                str14 = str12;
                                str15 = str11;
                            }
                            str16 = null;
                            if ((j & 268959760) != 0) {
                            }
                            if ((j & 268533776) == 0) {
                            }
                            i11 = ((j & 272631828) > 0L ? 1 : ((j & 272631828) == 0L ? 0 : -1));
                            if (i11 != 0) {
                            }
                            str20 = null;
                            if ((j & 268566544) != 0) {
                            }
                            if ((j & 269488152) != 0) {
                            }
                            str23 = null;
                            if ((j & 285212752) != 0) {
                            }
                            str7 = str19;
                            i = i6;
                            i4 = i8;
                            z2 = z10;
                            str10 = str13;
                            i3 = i10;
                            z5 = z11;
                            str8 = str14;
                            str4 = str17;
                            str3 = null;
                            str9 = str23;
                            i2 = i5;
                            z4 = z7;
                            str2 = str22;
                            f2 = f3;
                            f = f4;
                            z = z12;
                            str6 = str21;
                            z3 = z9;
                            str5 = str15;
                        }
                    }
                    str12 = null;
                    if ((j & 268451858) != 0) {
                    }
                    if ((j & 268697616) != 0) {
                    }
                    i9 = ((j & 268501008) > 0L ? 1 : ((j & 268501008) == 0L ? 0 : -1));
                    if (i9 != 0) {
                    }
                    i10 = i7;
                    z11 = z8;
                    j2 = 0;
                    if ((j & 411042320) != 0) {
                    }
                    str16 = null;
                    if ((j & 268959760) != 0) {
                    }
                    if ((j & 268533776) == 0) {
                    }
                    i11 = ((j & 272631828) > 0L ? 1 : ((j & 272631828) == 0L ? 0 : -1));
                    if (i11 != 0) {
                    }
                    str20 = null;
                    if ((j & 268566544) != 0) {
                    }
                    if ((j & 269488152) != 0) {
                    }
                    str23 = null;
                    if ((j & 285212752) != 0) {
                    }
                    str7 = str19;
                    i = i6;
                    i4 = i8;
                    z2 = z10;
                    str10 = str13;
                    i3 = i10;
                    z5 = z11;
                    str8 = str14;
                    str4 = str17;
                    str3 = null;
                    str9 = str23;
                    i2 = i5;
                    z4 = z7;
                    str2 = str22;
                    f2 = f3;
                    f = f4;
                    z = z12;
                    str6 = str21;
                    z3 = z9;
                    str5 = str15;
                }
            } else {
                f3 = 0.0f;
                i5 = 0;
                i6 = 0;
                z7 = false;
            }
            str11 = null;
            if ((j & 268468240) != 0) {
            }
            if ((j & 337641616) != 0) {
            }
            str12 = null;
            if ((j & 268451858) != 0) {
            }
            if ((j & 268697616) != 0) {
            }
            i9 = ((j & 268501008) > 0L ? 1 : ((j & 268501008) == 0L ? 0 : -1));
            if (i9 != 0) {
            }
            i10 = i7;
            z11 = z8;
            j2 = 0;
            if ((j & 411042320) != 0) {
            }
            str16 = null;
            if ((j & 268959760) != 0) {
            }
            if ((j & 268533776) == 0) {
            }
            i11 = ((j & 272631828) > 0L ? 1 : ((j & 272631828) == 0L ? 0 : -1));
            if (i11 != 0) {
            }
            str20 = null;
            if ((j & 268566544) != 0) {
            }
            if ((j & 269488152) != 0) {
            }
            str23 = null;
            if ((j & 285212752) != 0) {
            }
            str7 = str19;
            i = i6;
            i4 = i8;
            z2 = z10;
            str10 = str13;
            i3 = i10;
            z5 = z11;
            str8 = str14;
            str4 = str17;
            str3 = null;
            str9 = str23;
            i2 = i5;
            z4 = z7;
            str2 = str22;
            f2 = f3;
            f = f4;
            z = z12;
            str6 = str21;
            z3 = z9;
            str5 = str15;
        } else {
            f = 0.0f;
            f2 = 0.0f;
            i = 0;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            z5 = false;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
        }
        int i16 = ((j & 301989920) > 0L ? 1 : ((j & 301989920) == 0L ? 0 : -1));
        String str26 = (i16 == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        if ((j & 268566544) != 0) {
            z6 = z4;
            TextViewBindingAdapter.setText(this.decodeRs232BaudValue, str);
        } else {
            z6 = z4;
        }
        if ((j & 272631828) != 0) {
            TextViewBindingAdapter.setText(this.decodeRs232EndianValue, str2);
        }
        if ((j & 268697616) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.decodeRs232InvertRadioButton, z3);
            CompoundButtonBindingAdapter.setChecked(this.decodeRs232NegativeRadioButton, z2);
        }
        if ((268436481 & j) != 0) {
            TextViewBindingAdapter.setText(this.decodeRs232InvertRadioButton, str24);
        }
        if (i16 != 0) {
            TextViewBindingAdapter.setText(this.decodeRs232NegativeRadioButton, str26);
        }
        if ((j & 268959760) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.decodeRs232PackenValue, z);
        }
        if ((285212752 & j) != 0) {
            TextViewBindingAdapter.setText(this.decodeRs232PackendValue, str3);
        }
        if ((j & 411042320) != 0) {
            TextViewBindingAdapter.setText(this.decodeRs232ParityValue, str4);
        }
        if ((j & 268443920) != 0) {
            TextViewBindingAdapter.setText(this.decodeRs232RxValue, str5);
        }
        if ((j & 268443664) != 0) {
            this.decodeRs232RxValue.setTextColor(i2);
            this.decodeRxThresLabel.setVisibility(i);
            this.decodeRxThresValue.setEnabled(z6);
            this.decodeRxThresValue.setVisibility(i);
            if (getBuildSdkInt() >= 11) {
                this.decodeRxThresValue.setAlpha(f2);
            }
        }
        if ((269488152 & j) != 0) {
            TextViewBindingAdapter.setText(this.decodeRs232StopValue, str9);
        }
        if ((j & 268451858) != 0) {
            TextViewBindingAdapter.setText(this.decodeRs232TxValue, str10);
        }
        if ((j & 268451856) != 0) {
            this.decodeRs232TxValue.setTextColor(i3);
            int i17 = i4;
            this.decodeTxThresLabel.setVisibility(i17);
            this.decodeTxThresValue.setEnabled(z5);
            this.decodeTxThresValue.setVisibility(i17);
            if (getBuildSdkInt() >= 11) {
                this.decodeTxThresValue.setAlpha(f);
            }
        }
        if ((j & 337641616) != 0) {
            TextViewBindingAdapter.setText(this.decodeRs232WidthValue, str8);
        }
        if ((j & 268468240) != 0) {
            TextViewBindingAdapter.setText(this.decodeRxThresValue, str7);
        }
        if ((j & 268501008) != 0) {
            TextViewBindingAdapter.setText(this.decodeTxThresValue, str6);
        }
    }
}
