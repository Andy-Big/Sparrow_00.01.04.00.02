package com.rigol.scope.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

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
    */
    protected void executeBindings() {
        long j;
        long j2;
        long j3;
        float f;
        float f2;
        Drawable drawable;
        Drawable drawable2;
        String str;
        String str2;
        Drawable drawable3;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        int i;
        boolean z;
        boolean z2;
        int i2;
        int i3;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        int i6;
        boolean z10;
        int i7;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        int i8;
        int i9;
        boolean z18;
        float f3;
        String str9;
        String str10;
        int i10;
        float f4;
        float f5;
        float f6;
        float f7;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        Drawable drawable4;
        String str11;
        boolean z23;
        boolean z24;
        int i11;
        float f8;
        int i12;
        float f9;
        boolean z25;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        String str12;
        int i13;
        String str13;
        int i14;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        int i15;
        boolean z30;
        boolean z31;
        boolean z32;
        int i16;
        boolean z33;
        boolean z34;
        String str14;
        ServiceEnum.Unit unit;
        int i17;
        boolean z35;
        long j14;
        float f10;
        String str15;
        int i18;
        int i19;
        String str16;
        int i20;
        Drawable drawable5;
        Drawable drawable6;
        long j15;
        Drawable drawable7;
        Drawable drawable8;
        Drawable drawable9;
        float f11;
        String str17;
        int i21;
        boolean z36;
        int i22;
        int i23;
        boolean z37;
        int i24;
        String str18;
        long j16;
        int i25;
        int i26;
        Drawable drawable10;
        Context context;
        boolean z38;
        long j17;
        float f12;
        boolean z39;
        int i27;
        int i28;
        long j18;
        long j19;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
            j2 = this.mDirtyFlags_1;
            this.mDirtyFlags_1 = 0L;
        }
        DecodeParam decodeParam = this.mParam;
        if ((524287 & j) != 0) {
            if ((j & 266244) != 0) {
                i13 = decodeParam != null ? decodeParam.getBus_width() : 0;
                str12 = String.valueOf(i13);
            } else {
                str12 = null;
                i13 = 0;
            }
            if ((j & 262412) != 0) {
                i14 = decodeParam != null ? decodeParam.getBus_chan() : 0;
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_decode_bus_ch, i14);
                updateRegistration(3, mappingObject);
                str13 = mappingObject != null ? mappingObject.getStr() : null;
                if ((j & 262404) != 0) {
                    i3 = ColorUtil.getColorDoedCode(getRoot().getContext(), i14);
                    if ((j & 264196) == 0) {
                        z26 = decodeParam != null ? decodeParam.isPolarity() : false;
                        z27 = !z26;
                    } else {
                        z26 = false;
                        z27 = false;
                    }
                    long pal_dat_thres = ((j & 262660) != 0 || decodeParam == null) ? 0L : decodeParam.getPal_dat_thres();
                    if ((j & 263172) == 0) {
                        z28 = decodeParam != null ? decodeParam.isPal_endian() : false;
                        z29 = !z28;
                    } else {
                        z28 = false;
                        z29 = false;
                    }
                    i15 = ((j & 262212) > 0L ? 1 : ((j & 262212) == 0L ? 0 : -1));
                    if (i15 == 0) {
                        int pal_clk_edge = decodeParam != null ? decodeParam.getPal_clk_edge() : 0;
                        z31 = pal_clk_edge == 1;
                        z32 = pal_clk_edge == 0;
                        z30 = pal_clk_edge == 2;
                        if (i15 != 0) {
                            j |= z31 ? 72057594037927936L : 36028797018963968L;
                        }
                        if ((j & 262212) != 0) {
                            j |= z32 ? 4398046511104L : 2199023255552L;
                        }
                        if ((j & 262212) != 0) {
                            j |= z30 ? 1073741824L : 536870912L;
                        }
                    } else {
                        z30 = false;
                        z31 = false;
                        z32 = false;
                    }
                    boolean isNoiseProject = ((j & 327684) != 0 || decodeParam == null) ? false : decodeParam.isNoiseProject();
                    i16 = ((j & 270340) > 0L ? 1 : ((j & 270340) == 0L ? 0 : -1));
                    if (i16 == 0) {
                        int bus_width = decodeParam != null ? decodeParam.getBus_width() : 0;
                        z34 = bus_width > 2;
                        z7 = bus_width > 1;
                        z8 = bus_width > 3;
                        z33 = bus_width > 0;
                        if (i16 != 0) {
                            j |= z34 ? PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                        }
                        if ((j & 270340) != 0) {
                            j |= z7 ? 16777216L : 8388608L;
                        }
                        if ((j & 270340) != 0) {
                            j |= z8 ? 1099511627776L : 549755813888L;
                        }
                        if ((j & 270340) != 0) {
                            j2 |= z33 ? 4L : 2L;
                        }
                    } else {
                        z33 = false;
                        z34 = false;
                        z7 = false;
                        z8 = false;
                    }
                    if ((j & 262692) == 0) {
                        unit = decodeParam != null ? decodeParam.getUnit() : null;
                        if ((j & 262660) != 0) {
                            i6 = i14;
                            str14 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(pal_dat_thres, unit);
                        } else {
                            i6 = i14;
                            str14 = null;
                        }
                    } else {
                        i6 = i14;
                        str14 = null;
                        unit = null;
                    }
                    if ((278532 & j) == 0) {
                        str = String.valueOf(decodeParam != null ? decodeParam.getBus_bitx() : 0);
                    } else {
                        str = null;
                    }
                    if ((j & 266629) == 0) {
                        i2 = decodeParam != null ? decodeParam.getPal_bus() : 0;
                        int i29 = ((j & 262532) > 0L ? 1 : ((j & 262532) == 0L ? 0 : -1));
                        z5 = z33;
                        if (i29 != 0) {
                            z38 = i2 < 5;
                            if (i29 != 0) {
                                j2 = z38 ? j2 | 16 : j2 | 8;
                            }
                        } else {
                            z38 = false;
                        }
                        int i30 = ((j & 266372) > 0L ? 1 : ((j & 266372) == 0L ? 0 : -1));
                        z6 = z38;
                        if (i30 != 0) {
                            z39 = i2 == 33;
                            if (i30 != 0) {
                                j = z39 ? j | 4194304 : j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                            }
                            if ((j2 & 8) != 0) {
                                j = z39 ? j | 17592186044416L : j | 8796093022208L;
                            }
                            if ((j & 262276) != 0) {
                                if (z39) {
                                    j18 = j | 1125899906842624L;
                                    j19 = 4503599627370496L;
                                } else {
                                    j18 = j | 562949953421312L;
                                    j19 = 2251799813685248L;
                                }
                                j = j18 | j19;
                            }
                            j17 = 0;
                            if ((j & 262276) != 0) {
                                f12 = z39 ? 1.0f : 0.5f;
                                z35 = z39;
                                if ((j & 262276) == j17) {
                                    z10 = z39;
                                    i27 = ColorUtil.getColorDoedCode(getRoot().getContext(), i2);
                                } else {
                                    z10 = z39;
                                    i27 = 0;
                                }
                                long j20 = j;
                                if ((j & 262277) == j17) {
                                    MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_decode_pal_bus, i2);
                                    i28 = 0;
                                    updateRegistration(0, mappingObject2);
                                    if (mappingObject2 != null) {
                                        f10 = f12;
                                        j14 = j2;
                                        str15 = mappingObject2.getStr();
                                        i18 = i27;
                                        i17 = i28;
                                        j = j20;
                                    }
                                } else {
                                    i28 = 0;
                                }
                                f10 = f12;
                                j14 = j2;
                                str15 = null;
                                i18 = i27;
                                i17 = i28;
                                j = j20;
                            } else {
                                f12 = 0.0f;
                            }
                        } else {
                            j17 = 0;
                            f12 = 0.0f;
                            z39 = false;
                        }
                        z35 = false;
                        if ((j & 262276) == j17) {
                        }
                        long j202 = j;
                        if ((j & 262277) == j17) {
                        }
                        f10 = f12;
                        j14 = j2;
                        str15 = null;
                        i18 = i27;
                        i17 = i28;
                        j = j202;
                    } else {
                        z5 = z33;
                        i17 = 0;
                        i2 = 0;
                        z35 = false;
                        z6 = false;
                        z10 = false;
                        j14 = j2;
                        f10 = 0.0f;
                        str15 = null;
                        i18 = 0;
                    }
                    i19 = ((j & 294916) > 0L ? 1 : ((j & 294916) == 0L ? 0 : -1));
                    if (i19 == 0) {
                        if (decodeParam != null) {
                            z9 = z34;
                            i17 = decodeParam.getBus_bitx();
                        } else {
                            z9 = z34;
                        }
                        str16 = str15;
                        boolean z40 = i17 == 3;
                        i20 = i18;
                        boolean z41 = i17 == 1;
                        boolean z42 = i17 == 2;
                        if (i19 != 0) {
                            j |= z40 ? 68719476736L : 34359738368L;
                        }
                        if ((j & 294916) != 0) {
                            j |= z41 ? 70368744177664L : 35184372088832L;
                        }
                        if ((j & 294916) != 0) {
                            j14 |= z42 ? 64L : 32L;
                        }
                        drawable6 = z40 ? AppCompatResources.getDrawable(this.bitThree.getContext(), R.drawable.bg_rectangle_selected) : AppCompatResources.getDrawable(this.bitThree.getContext(), R.drawable.bg_rectangle_normal);
                        if (z41) {
                            drawable10 = AppCompatResources.getDrawable(this.bitOne.getContext(), R.drawable.bg_rectangle_selected);
                            i26 = R.drawable.bg_rectangle_normal;
                        } else {
                            Context context2 = this.bitOne.getContext();
                            i26 = R.drawable.bg_rectangle_normal;
                            drawable10 = AppCompatResources.getDrawable(context2, R.drawable.bg_rectangle_normal);
                        }
                        if (z42) {
                            context = this.bitTwo.getContext();
                            i26 = R.drawable.bg_rectangle_selected;
                        } else {
                            context = this.bitTwo.getContext();
                        }
                        drawable5 = AppCompatResources.getDrawable(context, i26);
                        long j21 = j14;
                        drawable7 = drawable10;
                        j15 = j21;
                    } else {
                        z9 = z34;
                        str16 = str15;
                        i20 = i18;
                        drawable5 = null;
                        drawable6 = null;
                        j15 = j14;
                        drawable7 = null;
                    }
                    if ((j & 262166) == 0) {
                        if (decodeParam != null) {
                            drawable9 = drawable6;
                            drawable8 = drawable5;
                            i25 = decodeParam.getPal_clk();
                        } else {
                            drawable8 = drawable5;
                            drawable9 = drawable6;
                            i25 = 0;
                        }
                        MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_decode_pal_clk, i25);
                        j3 = j15;
                        updateRegistration(1, mappingObject3);
                        String str19 = mappingObject3 != null ? mappingObject3.getStr() : null;
                        int i31 = ((262164 & j) > 0L ? 1 : ((262164 & j) == 0L ? 0 : -1));
                        if (i31 != 0) {
                            str17 = str19;
                            boolean z43 = i25 == ServiceEnum.Chan.chan_none.value1;
                            z36 = i25 < 8;
                            i7 = i13;
                            i21 = ColorUtil.getColorDoedCode(getRoot().getContext(), i25);
                            if (i31 != 0) {
                                j |= z43 ? 4611686018427387904L : LockFreeTaskQueueCore.CLOSED_MASK;
                            }
                            i22 = z43 ? 8 : 0;
                            f11 = ContextUtil.getAlpha(z36);
                            if ((j & 262180) != 0) {
                                if (decodeParam != null) {
                                    i23 = i21;
                                    z37 = z36;
                                    j16 = decodeParam.getPal_clk_thres();
                                } else {
                                    i23 = i21;
                                    z37 = z36;
                                    j16 = 0;
                                }
                                i24 = i22;
                                str18 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j16, unit);
                            } else {
                                i23 = i21;
                                z37 = z36;
                                i24 = i22;
                                str18 = null;
                            }
                            if ((393220 & j) != 0) {
                                str8 = str18;
                                str5 = str14;
                                str6 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(decodeParam != null ? decodeParam.getRejectTime() : 0L, ServiceEnum.Unit.Unit_s);
                                z11 = z26;
                                f = f10;
                                z12 = z27;
                                z13 = z28;
                                z14 = z29;
                                z = z35;
                                z15 = z31;
                                z16 = z32;
                                i = i20;
                                drawable2 = drawable7;
                                drawable3 = drawable9;
                                str4 = str16;
                                str7 = str17;
                                i4 = i23;
                                i5 = i24;
                                j = j;
                            } else {
                                str8 = str18;
                                str5 = str14;
                                str6 = null;
                                z11 = z26;
                                f = f10;
                                z12 = z27;
                                z13 = z28;
                                z14 = z29;
                                z = z35;
                                z15 = z31;
                                z16 = z32;
                                i = i20;
                                drawable2 = drawable7;
                                drawable3 = drawable9;
                                str4 = str16;
                                str7 = str17;
                                i4 = i23;
                                i5 = i24;
                            }
                            z4 = z37;
                            z3 = z30;
                            z2 = isNoiseProject;
                            str3 = str13;
                            str2 = str12;
                            f2 = f11;
                            drawable = drawable8;
                        } else {
                            str17 = str19;
                            i7 = i13;
                            f11 = 0.0f;
                        }
                    } else {
                        drawable8 = drawable5;
                        drawable9 = drawable6;
                        j3 = j15;
                        i7 = i13;
                        f11 = 0.0f;
                        str17 = null;
                    }
                    i21 = 0;
                    z36 = false;
                    i22 = 0;
                    if ((j & 262180) != 0) {
                    }
                    if ((393220 & j) != 0) {
                    }
                    z4 = z37;
                    z3 = z30;
                    z2 = isNoiseProject;
                    str3 = str13;
                    str2 = str12;
                    f2 = f11;
                    drawable = drawable8;
                }
            } else {
                str13 = null;
                i14 = 0;
            }
            i3 = 0;
            if ((j & 264196) == 0) {
            }
            if ((j & 262660) != 0) {
            }
            if ((j & 263172) == 0) {
            }
            i15 = ((j & 262212) > 0L ? 1 : ((j & 262212) == 0L ? 0 : -1));
            if (i15 == 0) {
            }
            if ((j & 327684) != 0) {
            }
            i16 = ((j & 270340) > 0L ? 1 : ((j & 270340) == 0L ? 0 : -1));
            if (i16 == 0) {
            }
            if ((j & 262692) == 0) {
            }
            if ((278532 & j) == 0) {
            }
            if ((j & 266629) == 0) {
            }
            i19 = ((j & 294916) > 0L ? 1 : ((j & 294916) == 0L ? 0 : -1));
            if (i19 == 0) {
            }
            if ((j & 262166) == 0) {
            }
            i21 = 0;
            z36 = false;
            i22 = 0;
            if ((j & 262180) != 0) {
            }
            if ((393220 & j) != 0) {
            }
            z4 = z37;
            z3 = z30;
            z2 = isNoiseProject;
            str3 = str13;
            str2 = str12;
            f2 = f11;
            drawable = drawable8;
        } else {
            j3 = j2;
            f = 0.0f;
            f2 = 0.0f;
            drawable = null;
            drawable2 = null;
            str = null;
            str2 = null;
            drawable3 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            i = 0;
            z = false;
            z2 = false;
            i2 = 0;
            i3 = 0;
            z3 = false;
            z4 = false;
            i4 = 0;
            i5 = 0;
            z5 = false;
            z6 = false;
            z7 = false;
            z8 = false;
            z9 = false;
            i6 = 0;
            z10 = false;
            i7 = 0;
            z11 = false;
            z12 = false;
            z13 = false;
            z14 = false;
            z15 = false;
            z16 = false;
        }
        int i32 = ((j3 & 8) > 0L ? 1 : ((j3 & 8) == 0L ? 0 : -1));
        boolean z44 = z2;
        if (i32 != 0) {
            boolean z45 = i2 == 33;
            if ((j & 266372) != 0) {
                j = z45 ? j | 4194304 : j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            if (i32 != 0) {
                j = z45 ? j | 17592186044416L : j | 8796093022208L;
            }
            if ((j & 262276) != 0) {
                if (z45) {
                    j12 = j | 1125899906842624L;
                    j13 = 4503599627370496L;
                } else {
                    j12 = j | 562949953421312L;
                    j13 = 2251799813685248L;
                }
                j = j12 | j13;
            }
            z10 = z45;
        }
        if ((j & 1099529453568L) != 0 || (j3 & 4) != 0) {
            if ((decodeParam != null ? decodeParam.getPal_bus() : 0) == 33) {
                z17 = true;
                i8 = ((j & 270340) > 0L ? 1 : ((j & 270340) == 0L ? 0 : -1));
                if (i8 == 0) {
                    boolean z46 = z9 ? z17 : false;
                    boolean z47 = z7 ? z17 : false;
                    boolean z48 = z8 ? z17 : false;
                    if (!z5) {
                        z17 = false;
                    }
                    if (i8 != 0) {
                        if (z46) {
                            j10 = j | 281474976710656L;
                            j11 = 18014398509481984L;
                        } else {
                            j10 = j | 140737488355328L;
                            j11 = 9007199254740992L;
                        }
                        j = j10 | j11;
                    }
                    if ((j & 270340) != 0) {
                        if (z47) {
                            j |= 4294967296L;
                            j3 |= 1;
                        } else {
                            j = j | 2147483648L | Long.MIN_VALUE;
                        }
                    }
                    if ((j & 270340) != 0) {
                        if (z48) {
                            j8 = j | 268435456;
                            j9 = 288230376151711744L;
                        } else {
                            j8 = j | 134217728;
                            j9 = 144115188075855872L;
                        }
                        j = j8 | j9;
                    }
                    if ((j & 270340) != 0) {
                        if (z17) {
                            j6 = j | 17179869184L;
                            j7 = LockFreeTaskQueueCore.FROZEN_MASK;
                        } else {
                            j6 = j | 8589934592L;
                            j7 = 576460752303423488L;
                        }
                        j = j6 | j7;
                    }
                    float f13 = z46 ? 1.0f : 0.5f;
                    float f14 = z47 ? 1.0f : 0.5f;
                    float f15 = z48 ? 1.0f : 0.5f;
                    float f16 = z17 ? 1.0f : 0.5f;
                    boolean z49 = z48;
                    i9 = i;
                    f4 = f14;
                    str10 = str3;
                    f7 = f13;
                    z20 = z47;
                    i10 = i3;
                    z22 = z17;
                    z19 = z49;
                    float f17 = f15;
                    z18 = z;
                    f5 = f17;
                    float f18 = f16;
                    f3 = f;
                    f6 = f18;
                    boolean z50 = z46;
                    str9 = str2;
                    z21 = z50;
                } else {
                    i9 = i;
                    z18 = z;
                    f3 = f;
                    str9 = str2;
                    str10 = str3;
                    i10 = i3;
                    f4 = 0.0f;
                    f5 = 0.0f;
                    f6 = 0.0f;
                    f7 = 0.0f;
                    z19 = false;
                    z20 = false;
                    z21 = false;
                    z22 = false;
                }
                if ((j & 17592190238720L) == 0) {
                    if ((j & 4194304) != 0) {
                        if (decodeParam != null) {
                            i7 = decodeParam.getBus_width();
                        }
                        drawable4 = drawable;
                        str11 = str;
                        if (i7 > 1) {
                            z24 = true;
                            if ((j & 17592186044416L) != 0) {
                                if (decodeParam != null) {
                                    i6 = decodeParam.getBus_chan();
                                }
                                if (i6 < 5) {
                                    z23 = true;
                                }
                            }
                            z23 = false;
                        }
                    } else {
                        drawable4 = drawable;
                        str11 = str;
                    }
                    z24 = false;
                    if ((j & 17592186044416L) != 0) {
                    }
                    z23 = false;
                } else {
                    drawable4 = drawable;
                    str11 = str;
                    z23 = false;
                    z24 = false;
                }
                i11 = ((j & 266372) > 0L ? 1 : ((j & 266372) == 0L ? 0 : -1));
                if (i11 == 0) {
                    if (!z10) {
                        z24 = false;
                    }
                    if (i11 != 0) {
                        if (z24) {
                            j4 = j | 67108864;
                            j5 = 274877906944L;
                        } else {
                            j4 = j | 33554432;
                            j5 = 137438953472L;
                        }
                        j = j4 | j5;
                    }
                    f8 = z24 ? 1.0f : 0.5f;
                } else {
                    f8 = 0.0f;
                    z24 = false;
                }
                z23 = ((j3 & 8) == 0 && z10) ? false : false;
                i12 = ((j & 262532) > 0L ? 1 : ((j & 262532) == 0L ? 0 : -1));
                if (i12 == 0) {
                    if (z6) {
                        z23 = true;
                    }
                    z25 = z23;
                    f9 = ContextUtil.getAlpha(z23);
                } else {
                    f9 = 0.0f;
                    z25 = false;
                }
                float f19 = f9;
                boolean z51 = z24;
                if ((j & 270340) != 0) {
                    if (getBuildSdkInt() >= 11) {
                        this.bitOne.setAlpha(f4);
                        this.bitThree.setAlpha(f5);
                        this.bitTwo.setAlpha(f7);
                        this.bitZero.setAlpha(f6);
                    }
                    this.bitOne.setEnabled(z20);
                    this.bitThree.setEnabled(z19);
                    this.bitTwo.setEnabled(z21);
                    this.bitZero.setEnabled(z22);
                }
                if ((j & 294916) != 0) {
                    ViewBindingAdapter.setBackground(this.bitOne, drawable2);
                    ViewBindingAdapter.setBackground(this.bitThree, drawable3);
                    ViewBindingAdapter.setBackground(this.bitTwo, drawable4);
                }
                if ((278532 & j) != 0) {
                    TextViewBindingAdapter.setText(this.bitZero, str11);
                }
                if ((j & 262276) != 0) {
                    if (getBuildSdkInt() >= 11) {
                        float f20 = f3;
                        this.decodeBusChLabel.setAlpha(f20);
                        this.decodeBusChValue.setAlpha(f20);
                        this.decodeBusWidthLabel.setAlpha(f20);
                        this.decodeBusWidthValue.setAlpha(f20);
                    }
                    boolean z52 = z18;
                    this.decodeBusChLabel.setEnabled(z52);
                    this.decodeBusChValue.setEnabled(z52);
                    this.decodeBusWidthLabel.setEnabled(z52);
                    this.decodeBusWidthValue.setEnabled(z52);
                    this.decodePalBusValue.setTextColor(i9);
                }
                if ((262412 & j) != 0) {
                    TextViewBindingAdapter.setText(this.decodeBusChValue, str10);
                }
                if ((262404 & j) != 0) {
                    this.decodeBusChValue.setTextColor(i10);
                }
                if ((266244 & j) != 0) {
                    TextViewBindingAdapter.setText(this.decodeBusWidthValue, str9);
                }
                if ((327684 & j) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.decodeNoiseSwitch, z44);
                }
                if ((j & 266372) != 0) {
                    if (getBuildSdkInt() >= 11) {
                        this.decodePalBitxLabel.setAlpha(f8);
                    }
                    this.decodePalBitxLabel.setEnabled(z51);
                }
                if ((262277 & j) != 0) {
                    TextViewBindingAdapter.setText(this.decodePalBusValue, str4);
                }
                if ((262164 & j) != 0) {
                    int i33 = i5;
                    this.decodePalClkEdgeLabel.setVisibility(i33);
                    this.decodePalClkEdgeRadioGroup.setVisibility(i33);
                    this.decodePalClkValue.setTextColor(i4);
                    this.decodePalDownRadioButton.setVisibility(i33);
                    this.decodePalThresLabel.setVisibility(i33);
                    this.decodePalThresValue.setEnabled(z4);
                    this.decodePalThresValue.setVisibility(i33);
                    this.decodePalUpRadioButton.setVisibility(i33);
                    this.decodePalUpdownRadioButton.setVisibility(i33);
                    if (getBuildSdkInt() >= 11) {
                        this.decodePalThresValue.setAlpha(f2);
                    }
                }
                if ((262166 & j) != 0) {
                    TextViewBindingAdapter.setText(this.decodePalClkValue, str7);
                }
                if (i12 != 0) {
                    if (getBuildSdkInt() >= 11) {
                        this.decodePalDatThresValue.setAlpha(f19);
                    }
                    this.decodePalDatThresValue.setEnabled(z25);
                }
                if ((262660 & j) != 0) {
                    TextViewBindingAdapter.setText(this.decodePalDatThresValue, str5);
                }
                if ((j & 262212) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.decodePalDownRadioButton, z15);
                    CompoundButtonBindingAdapter.setChecked(this.decodePalUpRadioButton, z16);
                    CompoundButtonBindingAdapter.setChecked(this.decodePalUpdownRadioButton, z3);
                }
                if ((263172 & j) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.decodePalInvertRadioButton, z14);
                    CompoundButtonBindingAdapter.setChecked(this.decodePalNormalRadioButton, z13);
                }
                if ((264196 & j) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.decodePalNegativeRadioButton, z12);
                    CompoundButtonBindingAdapter.setChecked(this.decodePalPositiveRadioButton, z11);
                }
                if ((393220 & j) != 0) {
                    TextViewBindingAdapter.setText(this.decodePalNrjtimeValue, str6);
                }
                if ((j & 262180) == 0) {
                    TextViewBindingAdapter.setText(this.decodePalThresValue, str8);
                    return;
                }
                return;
            }
        }
        z17 = false;
        i8 = ((j & 270340) > 0L ? 1 : ((j & 270340) == 0L ? 0 : -1));
        if (i8 == 0) {
        }
        if ((j & 17592190238720L) == 0) {
        }
        i11 = ((j & 266372) > 0L ? 1 : ((j & 266372) == 0L ? 0 : -1));
        if (i11 == 0) {
        }
        if ((j3 & 8) == 0) {
        }
        i12 = ((j & 262532) > 0L ? 1 : ((j & 262532) == 0L ? 0 : -1));
        if (i12 == 0) {
        }
        float f192 = f9;
        boolean z512 = z24;
        if ((j & 270340) != 0) {
        }
        if ((j & 294916) != 0) {
        }
        if ((278532 & j) != 0) {
        }
        if ((j & 262276) != 0) {
        }
        if ((262412 & j) != 0) {
        }
        if ((262404 & j) != 0) {
        }
        if ((266244 & j) != 0) {
        }
        if ((327684 & j) != 0) {
        }
        if ((j & 266372) != 0) {
        }
        if ((262277 & j) != 0) {
        }
        if ((262164 & j) != 0) {
        }
        if ((262166 & j) != 0) {
        }
        if (i12 != 0) {
        }
        if ((262660 & j) != 0) {
        }
        if ((j & 262212) != 0) {
        }
        if ((263172 & j) != 0) {
        }
        if ((264196 & j) != 0) {
        }
        if ((393220 & j) != 0) {
        }
        if ((j & 262180) == 0) {
        }
    }
}
