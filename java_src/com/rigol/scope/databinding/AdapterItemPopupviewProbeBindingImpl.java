package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;

/* loaded from: classes2.dex */
public class AdapterItemPopupviewProbeBindingImpl extends AdapterItemPopupviewProbeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView8;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 19);
        sViewsWithIds.put(R.id.guideline_left, 20);
        sViewsWithIds.put(R.id.guideline_right, 21);
        sViewsWithIds.put(R.id.probe_delay, 22);
    }

    public AdapterItemPopupviewProbeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 23, sIncludes, sViewsWithIds));
    }

    private AdapterItemPopupviewProbeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (Guideline) objArr[19], (Guideline) objArr[20], (Guideline) objArr[21], (TextView) objArr[4], (EditText) objArr[5], (TextView) objArr[6], (Button) objArr[7], (TextView) objArr[17], (TextView) objArr[18], (TextView) objArr[22], (EditText) objArr[3], (TextView) objArr[9], (Button) objArr[10], (TextView) objArr[11], (TextView) objArr[12], (TextView) objArr[15], (TextView) objArr[16], (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[13], (TextView) objArr[14]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[8];
        this.mboundView8 = textView;
        textView.setTag(null);
        this.probeBias.setTag(null);
        this.probeBiasEditText.setTag(null);
        this.probeCal.setTag(null);
        this.probeCalButton.setTag(null);
        this.probeCalTime.setTag(null);
        this.probeCalTimeText.setTag(null);
        this.probeDelayEditText.setTag(null);
        this.probeDemag.setTag(null);
        this.probeDemagButton.setTag(null);
        this.probeMfr.setTag(null);
        this.probeMfrText.setTag(null);
        this.probeModel.setTag(null);
        this.probeModelText.setTag(null);
        this.probeRatio.setTag(null);
        this.probeRatioSpinner.setTag(null);
        this.probeSn.setTag(null);
        this.probeSnText.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
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
        if (1027 == i) {
            setVerticalParam((VerticalParam) obj);
        } else if (179 == i) {
            setClickListener((View.OnClickListener) obj);
        } else if (823 != i) {
            return false;
        } else {
            setSharedParam((SharedParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterItemPopupviewProbeBinding
    public void setVerticalParam(VerticalParam verticalParam) {
        updateRegistration(0, verticalParam);
        this.mVerticalParam = verticalParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1027);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterItemPopupviewProbeBinding
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(179);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterItemPopupviewProbeBinding
    public void setSharedParam(SharedParam sharedParam) {
        this.mSharedParam = sharedParam;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeSharedParam((SharedParam) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanProbeVerticalParamProbeRatioValue1((MappingObject) obj, i2);
        }
        return onChangeVerticalParam((VerticalParam) obj, i2);
    }

    private boolean onChangeVerticalParam(VerticalParam verticalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 666) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 662) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 670) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 665) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 659) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 664) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 658) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 655) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 656) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 660) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 663) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 669) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 657) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanProbeVerticalParamProbeRatioValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    private boolean onChangeSharedParam(SharedParam sharedParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x05fd  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0623  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0644  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0651  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x06a9  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x06c8  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x06d5  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x06e7  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x06fb  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0708  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x071c  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0729  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0753  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x0760  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0774  */
    /* JADX WARN: Removed duplicated region for block: B:433:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016b  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        long j2;
        float f;
        int i;
        int i2;
        boolean z;
        boolean z2;
        int i3;
        int i4;
        boolean z3;
        boolean z4;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        boolean z5;
        String str9;
        String str10;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        String str11;
        String str12;
        String str13;
        String str14;
        ServiceEnum.ProbeType probeType;
        String str15;
        String str16;
        float f2;
        boolean z12;
        float f3;
        boolean z13;
        float f4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z14;
        boolean z15;
        boolean z16;
        String str17;
        ServiceEnum.ProbeType probeType2;
        String str18;
        boolean z17;
        long j3;
        long j4;
        int i14;
        int i15;
        float f5;
        int i16;
        int i17;
        int i18;
        boolean z18;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        synchronized (this) {
            j = this.mDirtyFlags;
            j2 = 0;
            this.mDirtyFlags = 0L;
        }
        VerticalParam verticalParam = this.mVerticalParam;
        View.OnClickListener onClickListener = this.mClickListener;
        if ((524275 & j) != 0) {
            int i19 = ((j & 270337) > 0L ? 1 : ((j & 270337) == 0L ? 0 : -1));
            if (i19 != 0) {
                boolean probeDemagVisible = verticalParam != null ? verticalParam.getProbeDemagVisible() : false;
                if (i19 != 0) {
                    if (probeDemagVisible) {
                        j8 = j | 1125899906842624L;
                        j9 = 18014398509481984L;
                    } else {
                        j8 = j | 562949953421312L;
                        j9 = 9007199254740992L;
                    }
                    j = j8 | j9;
                }
                i = probeDemagVisible ? 0 : 8;
                i14 = probeDemagVisible ? 4 : 8;
            } else {
                i = 0;
                i14 = 0;
            }
            str4 = ((j & 294913) == 0 || verticalParam == null) ? null : verticalParam.getProbeSN();
            if ((j & 393347) != 0) {
                ServiceEnum.ProbeX probeRatio = verticalParam != null ? verticalParam.getProbeRatio() : null;
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_chan_probe, probeRatio != null ? probeRatio.value1 : 0);
                updateRegistration(1, mappingObject);
                if (mappingObject != null) {
                    str = mappingObject.getStr();
                    i15 = ((j & 266241) > 0L ? 1 : ((j & 266241) == 0L ? 0 : -1));
                    if (i15 == 0) {
                        z2 = verticalParam != null ? verticalParam.getProbeCal() : false;
                        if (i15 != 0) {
                            if (z2) {
                                j6 = j | 1073741824;
                                j7 = 4398046511104L;
                            } else {
                                j6 = j | 536870912;
                                j7 = 2199023255552L;
                            }
                            j = j6 | j7;
                        }
                        i2 = z2 ? 4 : 8;
                        i16 = z2 ? 0 : 8;
                        f5 = ContextUtil.getAlpha(z2);
                    } else {
                        f5 = 0.0f;
                        i2 = 0;
                        z2 = false;
                        i16 = 0;
                    }
                    if ((j & 377441) == 0) {
                        z3 = verticalParam != null ? verticalParam.getProbeInsert() : false;
                        if ((j & 295009) != 0) {
                            j = z3 ? j | 16777216 : j | 8388608;
                        }
                        if ((j & 278625) != 0) {
                            j = z3 ? j | 268435456 : j | 134217728;
                        }
                        if ((j & 262753) != 0) {
                            j = z3 ? j | 4294967296L : j | 2147483648L;
                        }
                        if ((j & 8590196833L) != 0) {
                            j = z3 ? j | 4503599627370496L : j | 2251799813685248L;
                        }
                        if ((j & 327777) != 0) {
                            j = z3 ? j | 72057594037927936L : j | 36028797018963968L;
                        }
                    } else {
                        z3 = false;
                    }
                    i17 = ((j & 262257) > 0L ? 1 : ((j & 262257) == 0L ? 0 : -1));
                    if (i17 == 0) {
                        z4 = verticalParam != null ? verticalParam.getProbeRatioEnable() : false;
                        if (i17 != 0) {
                            j = z4 ? j | 288230376151711744L : j | 144115188075855872L;
                        }
                    } else {
                        z4 = false;
                    }
                    str5 = ((j & 327681) != 0 || verticalParam == null) ? null : verticalParam.getProbeCalTime();
                    str6 = ((j & 278529) != 0 || verticalParam == null) ? null : verticalParam.getProbeMFR();
                    i18 = ((j & 265729) > 0L ? 1 : ((j & 265729) == 0L ? 0 : -1));
                    if (i18 == 0) {
                        str2 = verticalParam != null ? verticalParam.getProbeModel() : null;
                        z = str2 != null ? str2.startsWith("PCA") : false;
                        if (i18 != 0) {
                            j |= z ? 70368744177664L : 35184372088832L;
                        }
                    } else {
                        z = false;
                        str2 = null;
                    }
                    if ((j & 262401) == 0) {
                        if (verticalParam != null) {
                            z18 = z2;
                            j5 = verticalParam.getProbeDelay();
                        } else {
                            z18 = z2;
                            j5 = 0;
                        }
                        str3 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j5, ServiceEnum.Unit.Unit_s);
                        i3 = i14;
                        i4 = i16;
                        f = f5;
                        z2 = z18;
                    } else {
                        i3 = i14;
                        i4 = i16;
                        f = f5;
                        str3 = null;
                    }
                }
            }
            str = null;
            i15 = ((j & 266241) > 0L ? 1 : ((j & 266241) == 0L ? 0 : -1));
            if (i15 == 0) {
            }
            if ((j & 377441) == 0) {
            }
            i17 = ((j & 262257) > 0L ? 1 : ((j & 262257) == 0L ? 0 : -1));
            if (i17 == 0) {
            }
            if ((j & 327681) != 0) {
            }
            if ((j & 278529) != 0) {
            }
            i18 = ((j & 265729) > 0L ? 1 : ((j & 265729) == 0L ? 0 : -1));
            if (i18 == 0) {
            }
            if ((j & 262401) == 0) {
            }
        } else {
            f = 0.0f;
            i = 0;
            i2 = 0;
            z = false;
            z2 = false;
            i3 = 0;
            i4 = 0;
            z3 = false;
            z4 = false;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
        }
        if ((j & 288335929267978240L) != 0) {
            if ((j & 70368744177664L) != 0) {
                if (verticalParam != null) {
                    str8 = str2;
                    j2 = verticalParam.getProbeCurrentBias();
                } else {
                    str8 = str2;
                }
                str7 = str;
                str18 = UnitFormat.newBuilder(UnitFormat.PATTERN_SIGN, UnitFormat.SI.NONE).convert(j2) + ServiceEnum.Unit.Unit_percent.value2;
            } else {
                str7 = str;
                str8 = str2;
                str18 = null;
            }
            if ((j & 288230376151711744L) != 0) {
                if (verticalParam != null) {
                    z3 = verticalParam.getProbeInsert();
                }
                if ((j & 295009) != 0) {
                    j = z3 ? j | 16777216 : j | 8388608;
                }
                if ((j & 278625) != 0) {
                    j = z3 ? j | 268435456 : j | 134217728;
                }
                if ((j & 262753) != 0) {
                    j = z3 ? j | 4294967296L : j | 2147483648L;
                }
                if ((j & 8590196833L) != 0) {
                    j = z3 ? j | 4503599627370496L : j | 2251799813685248L;
                }
                if ((j & 327777) != 0) {
                    j = z3 ? j | 72057594037927936L : j | 36028797018963968L;
                }
                z17 = !z3;
                if ((j & 288230376151711744L) != 0) {
                    j |= z17 ? 17179869184L : 8589934592L;
                }
            } else {
                z17 = false;
            }
            if ((j & 35184372088832L) != 0) {
                if (verticalParam != null) {
                    long j10 = j;
                    j4 = verticalParam.getProbeBias();
                    j3 = j10;
                } else {
                    j3 = j;
                    j4 = 0;
                }
                z5 = z17;
                str10 = str18;
                str9 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j4, ServiceEnum.Unit.Unit_V);
                j = j3;
            } else {
                z5 = z17;
                str10 = str18;
                str9 = null;
            }
        } else {
            str7 = str;
            str8 = str2;
            z5 = false;
            str9 = null;
            str10 = null;
        }
        if ((j & 265729) == 0) {
            str9 = null;
        } else if (z) {
            str9 = str10;
        }
        if ((76561198245478400L & j) != 0) {
            if ((j & 16777216) != 0) {
                if (verticalParam != null) {
                    str4 = verticalParam.getProbeSN();
                }
                z14 = !TextUtils.isEmpty(str4);
            } else {
                z14 = false;
            }
            if ((j & 72057594037927936L) != 0) {
                if (verticalParam != null) {
                    str5 = verticalParam.getProbeCalTime();
                }
                z15 = !TextUtils.isEmpty(str5);
            } else {
                z15 = false;
            }
            if ((j & 268435456) != 0) {
                if (verticalParam != null) {
                    str6 = verticalParam.getProbeMFR();
                }
                z16 = !TextUtils.isEmpty(str6);
            } else {
                z16 = false;
            }
            if ((j & 4294967296L) != 0) {
                str17 = verticalParam != null ? verticalParam.getProbeModel() : str8;
                z6 = true;
                z8 = !TextUtils.isEmpty(str17);
            } else {
                z6 = true;
                z8 = false;
                str17 = str8;
            }
            if ((j & 4503599627370496L) != 0) {
                if (verticalParam != null) {
                    z10 = z15;
                    z9 = z14;
                    probeType2 = verticalParam.getProbeType();
                } else {
                    z9 = z14;
                    z10 = z15;
                    probeType2 = null;
                }
                probeType = probeType2;
                z11 = probeType2 != ServiceEnum.ProbeType.Probe_BNC ? z6 : false;
                str12 = str4;
                str13 = str5;
                str14 = str6;
            } else {
                z9 = z14;
                z10 = z15;
                z11 = false;
                str12 = str4;
                str13 = str5;
                str14 = str6;
                probeType = null;
            }
            String str19 = str17;
            z7 = z16;
            str11 = str19;
        } else {
            z6 = true;
            z7 = false;
            z8 = false;
            z9 = false;
            z10 = false;
            z11 = false;
            str11 = str8;
            str12 = str4;
            str13 = str5;
            str14 = str6;
            probeType = null;
        }
        int i20 = ((j & 295009) > 0L ? 1 : ((j & 295009) == 0L ? 0 : -1));
        if (i20 != 0) {
            if (!z3) {
                z9 = false;
            }
            if (i20 != 0) {
                j |= z9 ? 17592186044416L : 8796093022208L;
            }
        } else {
            z9 = false;
        }
        int i21 = ((j & 278625) > 0L ? 1 : ((j & 278625) == 0L ? 0 : -1));
        if (i21 != 0) {
            if (!z3) {
                z7 = false;
            }
            if (i21 != 0) {
                j |= z7 ? 274877906944L : 137438953472L;
            }
        } else {
            z7 = false;
        }
        int i22 = ((j & 262753) > 0L ? 1 : ((j & 262753) == 0L ? 0 : -1));
        if (i22 != 0) {
            if (!z3) {
                z8 = false;
            }
            if (i22 != 0) {
                j |= z8 ? 68719476736L : 34359738368L;
            }
        } else {
            z8 = false;
        }
        if ((j & 8590196833L) != 0) {
            boolean z19 = z3 ? z11 : false;
            if ((j & 262241) != 0) {
                str15 = str14;
                f2 = ContextUtil.getAlpha(z19);
                boolean z20 = z19;
                str16 = str11;
                z12 = z20;
            } else {
                str15 = str14;
                f2 = 0.0f;
                boolean z21 = z19;
                str16 = str11;
                z12 = z21;
            }
        } else {
            str15 = str14;
            str16 = str11;
            f2 = 0.0f;
            z12 = false;
        }
        int i23 = ((j & 327777) > 0L ? 1 : ((j & 327777) == 0L ? 0 : -1));
        if (i23 != 0) {
            if (!z3) {
                z10 = false;
            }
            if (i23 != 0) {
                j |= z10 ? 1099511627776L : 549755813888L;
            }
        } else {
            z10 = false;
        }
        boolean z22 = (j & 288230376151711744L) != 0 ? z5 ? z6 : z12 : false;
        if ((j & 262257) != 0) {
            if (!z4) {
                z22 = false;
            }
            z13 = z22;
            f3 = ContextUtil.getAlpha(z22);
        } else {
            f3 = 0.0f;
            z13 = false;
        }
        if ((j & 19035295055872L) != 0) {
            if (verticalParam != null) {
                probeType = verticalParam.getProbeType();
            }
            f4 = f3;
            if (probeType == ServiceEnum.ProbeType.Probe_BNC) {
                z6 = false;
            }
        } else {
            f4 = f3;
            z6 = z11;
        }
        int i24 = ((j & 262753) > 0L ? 1 : ((j & 262753) == 0L ? 0 : -1));
        if (i24 != 0) {
            boolean z23 = z8 ? z6 : false;
            if (i24 != 0) {
                j |= z23 ? 67108864L : 33554432L;
            }
            if (!z23) {
                i5 = 8;
                i6 = ((j & 278625) > 0L ? 1 : ((j & 278625) == 0L ? 0 : -1));
                if (i6 != 0) {
                    boolean z24 = z7 ? z6 : false;
                    if (i6 != 0) {
                        j |= z24 ? PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    }
                    if (!z24) {
                        i7 = 8;
                        i8 = ((j & 327777) > 0L ? 1 : ((j & 327777) == 0L ? 0 : -1));
                        if (i8 != 0) {
                            boolean z25 = z10 ? z6 : false;
                            if (i8 != 0) {
                                j |= z25 ? 4194304L : PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                            }
                            i9 = i5;
                            i10 = z25 ? 0 : 8;
                        } else {
                            i9 = i5;
                            i10 = 0;
                        }
                        i11 = ((j & 295009) > 0L ? 1 : ((j & 295009) == 0L ? 0 : -1));
                        if (i11 != 0) {
                            if (!z9) {
                                z6 = false;
                            }
                            if (i11 != 0) {
                                j |= z6 ? 281474976710656L : 140737488355328L;
                            }
                            i12 = z6 ? 0 : 8;
                        } else {
                            i12 = 0;
                        }
                        int i25 = i7;
                        if ((j & 266241) != 0) {
                            i13 = i;
                            if (getBuildSdkInt() >= 11) {
                                float f6 = f;
                                this.mboundView8.setAlpha(f6);
                                this.probeCal.setAlpha(f6);
                                this.probeCalButton.setAlpha(f6);
                            }
                            this.mboundView8.setEnabled(z2);
                            this.probeCal.setEnabled(z2);
                            this.probeCal.setVisibility(i2);
                            this.probeCalButton.setEnabled(z2);
                            this.probeCalButton.setVisibility(i4);
                        } else {
                            i13 = i;
                        }
                        if ((262241 & j) != 0) {
                            if (getBuildSdkInt() >= 11) {
                                this.probeBias.setAlpha(f2);
                                this.probeBiasEditText.setAlpha(f2);
                            }
                            this.probeBias.setEnabled(z12);
                            this.probeBiasEditText.setEnabled(z12);
                        }
                        if ((262152 & j) != 0) {
                            this.probeBiasEditText.setOnClickListener(onClickListener);
                            this.probeCalButton.setOnClickListener(onClickListener);
                            this.probeDelayEditText.setOnClickListener(onClickListener);
                            this.probeDemagButton.setOnClickListener(onClickListener);
                            this.probeRatioSpinner.setOnClickListener(onClickListener);
                        }
                        if ((j & 265729) != 0) {
                            TextViewBindingAdapter.setText(this.probeBiasEditText, str9);
                        }
                        if ((PlaybackStateCompat.ACTION_SET_REPEAT_MODE & j) != 0 && getBuildSdkInt() >= 11) {
                            this.probeCalTime.setAlpha(ContextUtil.getAlpha(false));
                            this.probeCalTimeText.setAlpha(ContextUtil.getAlpha(false));
                            this.probeMfr.setAlpha(ContextUtil.getAlpha(false));
                            this.probeMfrText.setAlpha(ContextUtil.getAlpha(false));
                            this.probeModel.setAlpha(ContextUtil.getAlpha(false));
                            this.probeModelText.setAlpha(ContextUtil.getAlpha(false));
                            this.probeSn.setAlpha(ContextUtil.getAlpha(false));
                            this.probeSnText.setAlpha(ContextUtil.getAlpha(false));
                        }
                        if ((j & 327777) != 0) {
                            this.probeCalTime.setVisibility(i10);
                            this.probeCalTimeText.setVisibility(i10);
                        }
                        if ((327681 & j) != 0) {
                            TextViewBindingAdapter.setText(this.probeCalTimeText, str13);
                        }
                        if ((262401 & j) != 0) {
                            TextViewBindingAdapter.setText(this.probeDelayEditText, str3);
                        }
                        if ((270337 & j) != 0) {
                            this.probeDemag.setVisibility(i3);
                            this.probeDemagButton.setVisibility(i13);
                        }
                        if ((j & 278625) != 0) {
                            this.probeMfr.setVisibility(i25);
                            this.probeMfrText.setVisibility(i25);
                        }
                        if ((278529 & j) != 0) {
                            TextViewBindingAdapter.setText(this.probeMfrText, str15);
                        }
                        if ((j & 262753) != 0) {
                            int i26 = i9;
                            this.probeModel.setVisibility(i26);
                            this.probeModelText.setVisibility(i26);
                        }
                        if ((262657 & j) != 0) {
                            TextViewBindingAdapter.setText(this.probeModelText, str16);
                        }
                        if ((j & 262257) != 0) {
                            if (getBuildSdkInt() >= 11) {
                                float f7 = f4;
                                this.probeRatio.setAlpha(f7);
                                this.probeRatioSpinner.setAlpha(f7);
                            }
                            boolean z26 = z13;
                            this.probeRatio.setEnabled(z26);
                            this.probeRatioSpinner.setEnabled(z26);
                        }
                        if ((393347 & j) != 0) {
                            TextViewBindingAdapter.setText(this.probeRatioSpinner, str7);
                        }
                        if ((j & 295009) != 0) {
                            int i27 = i12;
                            this.probeSn.setVisibility(i27);
                            this.probeSnText.setVisibility(i27);
                        }
                        if ((j & 294913) != 0) {
                            TextViewBindingAdapter.setText(this.probeSnText, str12);
                            return;
                        }
                        return;
                    }
                }
                i7 = 0;
                i8 = ((j & 327777) > 0L ? 1 : ((j & 327777) == 0L ? 0 : -1));
                if (i8 != 0) {
                }
                i11 = ((j & 295009) > 0L ? 1 : ((j & 295009) == 0L ? 0 : -1));
                if (i11 != 0) {
                }
                int i252 = i7;
                if ((j & 266241) != 0) {
                }
                if ((262241 & j) != 0) {
                }
                if ((262152 & j) != 0) {
                }
                if ((j & 265729) != 0) {
                }
                if ((PlaybackStateCompat.ACTION_SET_REPEAT_MODE & j) != 0) {
                    this.probeCalTime.setAlpha(ContextUtil.getAlpha(false));
                    this.probeCalTimeText.setAlpha(ContextUtil.getAlpha(false));
                    this.probeMfr.setAlpha(ContextUtil.getAlpha(false));
                    this.probeMfrText.setAlpha(ContextUtil.getAlpha(false));
                    this.probeModel.setAlpha(ContextUtil.getAlpha(false));
                    this.probeModelText.setAlpha(ContextUtil.getAlpha(false));
                    this.probeSn.setAlpha(ContextUtil.getAlpha(false));
                    this.probeSnText.setAlpha(ContextUtil.getAlpha(false));
                }
                if ((j & 327777) != 0) {
                }
                if ((327681 & j) != 0) {
                }
                if ((262401 & j) != 0) {
                }
                if ((270337 & j) != 0) {
                }
                if ((j & 278625) != 0) {
                }
                if ((278529 & j) != 0) {
                }
                if ((j & 262753) != 0) {
                }
                if ((262657 & j) != 0) {
                }
                if ((j & 262257) != 0) {
                }
                if ((393347 & j) != 0) {
                }
                if ((j & 295009) != 0) {
                }
                if ((j & 294913) != 0) {
                }
            }
        }
        i5 = 0;
        i6 = ((j & 278625) > 0L ? 1 : ((j & 278625) == 0L ? 0 : -1));
        if (i6 != 0) {
        }
        i7 = 0;
        i8 = ((j & 327777) > 0L ? 1 : ((j & 327777) == 0L ? 0 : -1));
        if (i8 != 0) {
        }
        i11 = ((j & 295009) > 0L ? 1 : ((j & 295009) == 0L ? 0 : -1));
        if (i11 != 0) {
        }
        int i2522 = i7;
        if ((j & 266241) != 0) {
        }
        if ((262241 & j) != 0) {
        }
        if ((262152 & j) != 0) {
        }
        if ((j & 265729) != 0) {
        }
        if ((PlaybackStateCompat.ACTION_SET_REPEAT_MODE & j) != 0) {
        }
        if ((j & 327777) != 0) {
        }
        if ((327681 & j) != 0) {
        }
        if ((262401 & j) != 0) {
        }
        if ((270337 & j) != 0) {
        }
        if ((j & 278625) != 0) {
        }
        if ((278529 & j) != 0) {
        }
        if ((j & 262753) != 0) {
        }
        if ((262657 & j) != 0) {
        }
        if ((j & 262257) != 0) {
        }
        if ((393347 & j) != 0) {
        }
        if ((j & 295009) != 0) {
        }
        if ((j & 294913) != 0) {
        }
    }
}
