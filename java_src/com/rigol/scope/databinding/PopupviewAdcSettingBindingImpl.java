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
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
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
    */
    protected void executeBindings() {
        long j;
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
        String str11;
        String str12;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z2;
        int i14;
        String str13;
        boolean z3;
        String str14;
        int i15;
        String str15;
        int i16;
        int i17;
        String str16;
        int i18;
        String str17;
        int i19;
        int i20;
        String str18;
        int i21;
        String str19;
        String str20;
        int i22;
        String str21;
        String str22;
        int i23;
        String str23;
        int i24;
        boolean z4;
        String str24;
        int i25;
        String str25;
        int i26;
        String str26;
        int i27;
        String str27;
        int i28;
        String str28;
        String str29;
        int i29;
        String str30;
        String str31;
        int i30;
        String str32;
        int i31;
        String str33;
        int i32;
        String str34;
        int i33;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        AdcSettingParam adcSettingParam = this.mParam;
        String str35 = null;
        int i34 = 0;
        if ((262143 & j) != 0) {
            if ((j & 131081) != 0) {
                int inter1 = adcSettingParam != null ? adcSettingParam.getInter1() : 0;
                i15 = adcSettingParam != null ? adcSettingParam.parseInterProgress(inter1) : 0;
                str14 = getRoot().getContext().getResources().getString(R.string.adc_inter, Integer.valueOf(inter1));
            } else {
                str14 = null;
                i15 = 0;
            }
            boolean flip2 = ((j & 131585) == 0 || adcSettingParam == null) ? false : adcSettingParam.getFlip2();
            if ((j & 135169) != 0) {
                int fine2 = adcSettingParam != null ? adcSettingParam.getFine2() : 0;
                i16 = adcSettingParam != null ? adcSettingParam.parseFineProgress(fine2) : 0;
                str15 = getRoot().getContext().getResources().getString(R.string.adc_fine, Integer.valueOf(fine2));
            } else {
                str15 = null;
                i16 = 0;
            }
            if ((j & 131105) != 0) {
                int phase1Core1 = adcSettingParam != null ? adcSettingParam.getPhase1Core1() : 0;
                i17 = adcSettingParam != null ? adcSettingParam.parseProgress2(phase1Core1) : 0;
                str5 = getRoot().getContext().getResources().getString(R.string.adc_a, Integer.valueOf(phase1Core1));
            } else {
                str5 = null;
                i17 = 0;
            }
            if ((j & 132097) != 0) {
                int coarse2 = adcSettingParam != null ? adcSettingParam.getCoarse2() : 0;
                str16 = getRoot().getContext().getResources().getString(R.string.adc_coarse, Integer.valueOf(coarse2));
                if (adcSettingParam != null) {
                    i18 = adcSettingParam.parseCoarseProgress(coarse2);
                    if ((j & 147457) == 0) {
                        int phase2Core2 = adcSettingParam != null ? adcSettingParam.getPhase2Core2() : 0;
                        str17 = getRoot().getContext().getResources().getString(R.string.adc_b, Integer.valueOf(phase2Core2));
                        if (adcSettingParam != null) {
                            i19 = adcSettingParam.parseProgress2(phase2Core2);
                            if ((j & 131201) != 0) {
                                int phase1Core3 = adcSettingParam != null ? adcSettingParam.getPhase1Core3() : 0;
                                str6 = getRoot().getContext().getResources().getString(R.string.adc_c, Integer.valueOf(phase1Core3));
                                if (adcSettingParam != null) {
                                    i20 = adcSettingParam.parseProgress2(phase1Core3);
                                    if ((j & 196609) == 0) {
                                        int phase2Core4 = adcSettingParam != null ? adcSettingParam.getPhase2Core4() : 0;
                                        i22 = adcSettingParam != null ? adcSettingParam.parseProgress2(phase2Core4) : 0;
                                        str18 = str17;
                                        i21 = i19;
                                        str19 = str14;
                                        str20 = getRoot().getContext().getResources().getString(R.string.adc_d, Integer.valueOf(phase2Core4));
                                    } else {
                                        str18 = str17;
                                        i21 = i19;
                                        str19 = str14;
                                        str20 = null;
                                        i22 = 0;
                                    }
                                    if ((133121 & j) == 0) {
                                        int inter2 = adcSettingParam != null ? adcSettingParam.getInter2() : 0;
                                        str21 = str20;
                                        str22 = getRoot().getContext().getResources().getString(R.string.adc_inter, Integer.valueOf(inter2));
                                        if (adcSettingParam != null) {
                                            i23 = adcSettingParam.parseInterProgress(inter2);
                                            boolean flip1 = ((j & 131075) != 0 || adcSettingParam == null) ? false : adcSettingParam.getFlip1();
                                            if ((j & 131089) != 0) {
                                                int fine1 = adcSettingParam != null ? adcSettingParam.getFine1() : 0;
                                                str23 = str22;
                                                i24 = i23;
                                                z4 = flip1;
                                                str24 = getRoot().getContext().getResources().getString(R.string.adc_fine, Integer.valueOf(fine1));
                                                if (adcSettingParam != null) {
                                                    i25 = adcSettingParam.parseFineProgress(fine1);
                                                    if ((j & 139265) == 0) {
                                                        int phase2Core1 = adcSettingParam != null ? adcSettingParam.getPhase2Core1() : 0;
                                                        str25 = str24;
                                                        i26 = i25;
                                                        str26 = getRoot().getContext().getResources().getString(R.string.adc_a, Integer.valueOf(phase2Core1));
                                                        if (adcSettingParam != null) {
                                                            i27 = adcSettingParam.parseProgress2(phase2Core1);
                                                            if ((j & 131077) != 0) {
                                                                int coarse1 = adcSettingParam != null ? adcSettingParam.getCoarse1() : 0;
                                                                i29 = adcSettingParam != null ? adcSettingParam.parseCoarseProgress(coarse1) : 0;
                                                                str27 = str26;
                                                                i28 = i27;
                                                                str28 = str15;
                                                                str29 = getRoot().getContext().getResources().getString(R.string.adc_coarse, Integer.valueOf(coarse1));
                                                            } else {
                                                                str27 = str26;
                                                                i28 = i27;
                                                                str28 = str15;
                                                                str29 = null;
                                                                i29 = 0;
                                                            }
                                                            if ((163841 & j) != 0) {
                                                                int phase2Core3 = adcSettingParam != null ? adcSettingParam.getPhase2Core3() : 0;
                                                                str30 = str29;
                                                                int parseProgress2 = adcSettingParam != null ? adcSettingParam.parseProgress2(phase2Core3) : 0;
                                                                str31 = getRoot().getContext().getResources().getString(R.string.adc_c, Integer.valueOf(phase2Core3));
                                                                i30 = parseProgress2;
                                                            } else {
                                                                str30 = str29;
                                                                str31 = null;
                                                                i30 = 0;
                                                            }
                                                            if ((j & 131137) != 0) {
                                                                int phase1Core2 = adcSettingParam != null ? adcSettingParam.getPhase1Core2() : 0;
                                                                str32 = str31;
                                                                i31 = i30;
                                                                str33 = getRoot().getContext().getResources().getString(R.string.adc_b, Integer.valueOf(phase1Core2));
                                                                if (adcSettingParam != null) {
                                                                    i32 = adcSettingParam.parseProgress2(phase1Core2);
                                                                    if ((j & 131329) == 0) {
                                                                        int phase1Core4 = adcSettingParam != null ? adcSettingParam.getPhase1Core4() : 0;
                                                                        str34 = str33;
                                                                        i33 = i32;
                                                                        str35 = getRoot().getContext().getResources().getString(R.string.adc_d, Integer.valueOf(phase1Core4));
                                                                        if (adcSettingParam != null) {
                                                                            i34 = adcSettingParam.parseProgress2(phase1Core4);
                                                                        }
                                                                    } else {
                                                                        str34 = str33;
                                                                        i33 = i32;
                                                                    }
                                                                    z2 = flip2;
                                                                    i11 = i18;
                                                                    i3 = i29;
                                                                    i12 = i22;
                                                                    str2 = str30;
                                                                    str3 = str35;
                                                                    i7 = i15;
                                                                    i14 = i24;
                                                                    i13 = i16;
                                                                    i6 = i17;
                                                                    str = str34;
                                                                    str4 = str25;
                                                                    i8 = i28;
                                                                    i9 = i21;
                                                                    i5 = i33;
                                                                    str9 = str18;
                                                                    str35 = str21;
                                                                    str11 = str19;
                                                                    str12 = str23;
                                                                    z = z4;
                                                                    i = i26;
                                                                    str10 = str27;
                                                                    str7 = str28;
                                                                    str8 = str32;
                                                                    i10 = i31;
                                                                    String str36 = str16;
                                                                    i4 = i20;
                                                                    i2 = i34;
                                                                    str13 = str36;
                                                                }
                                                            } else {
                                                                str32 = str31;
                                                                i31 = i30;
                                                                str33 = null;
                                                            }
                                                            i32 = 0;
                                                            if ((j & 131329) == 0) {
                                                            }
                                                            z2 = flip2;
                                                            i11 = i18;
                                                            i3 = i29;
                                                            i12 = i22;
                                                            str2 = str30;
                                                            str3 = str35;
                                                            i7 = i15;
                                                            i14 = i24;
                                                            i13 = i16;
                                                            i6 = i17;
                                                            str = str34;
                                                            str4 = str25;
                                                            i8 = i28;
                                                            i9 = i21;
                                                            i5 = i33;
                                                            str9 = str18;
                                                            str35 = str21;
                                                            str11 = str19;
                                                            str12 = str23;
                                                            z = z4;
                                                            i = i26;
                                                            str10 = str27;
                                                            str7 = str28;
                                                            str8 = str32;
                                                            i10 = i31;
                                                            String str362 = str16;
                                                            i4 = i20;
                                                            i2 = i34;
                                                            str13 = str362;
                                                        }
                                                    } else {
                                                        str25 = str24;
                                                        i26 = i25;
                                                        str26 = null;
                                                    }
                                                    i27 = 0;
                                                    if ((j & 131077) != 0) {
                                                    }
                                                    if ((163841 & j) != 0) {
                                                    }
                                                    if ((j & 131137) != 0) {
                                                    }
                                                    i32 = 0;
                                                    if ((j & 131329) == 0) {
                                                    }
                                                    z2 = flip2;
                                                    i11 = i18;
                                                    i3 = i29;
                                                    i12 = i22;
                                                    str2 = str30;
                                                    str3 = str35;
                                                    i7 = i15;
                                                    i14 = i24;
                                                    i13 = i16;
                                                    i6 = i17;
                                                    str = str34;
                                                    str4 = str25;
                                                    i8 = i28;
                                                    i9 = i21;
                                                    i5 = i33;
                                                    str9 = str18;
                                                    str35 = str21;
                                                    str11 = str19;
                                                    str12 = str23;
                                                    z = z4;
                                                    i = i26;
                                                    str10 = str27;
                                                    str7 = str28;
                                                    str8 = str32;
                                                    i10 = i31;
                                                    String str3622 = str16;
                                                    i4 = i20;
                                                    i2 = i34;
                                                    str13 = str3622;
                                                }
                                            } else {
                                                str23 = str22;
                                                i24 = i23;
                                                z4 = flip1;
                                                str24 = null;
                                            }
                                            i25 = 0;
                                            if ((j & 139265) == 0) {
                                            }
                                            i27 = 0;
                                            if ((j & 131077) != 0) {
                                            }
                                            if ((163841 & j) != 0) {
                                            }
                                            if ((j & 131137) != 0) {
                                            }
                                            i32 = 0;
                                            if ((j & 131329) == 0) {
                                            }
                                            z2 = flip2;
                                            i11 = i18;
                                            i3 = i29;
                                            i12 = i22;
                                            str2 = str30;
                                            str3 = str35;
                                            i7 = i15;
                                            i14 = i24;
                                            i13 = i16;
                                            i6 = i17;
                                            str = str34;
                                            str4 = str25;
                                            i8 = i28;
                                            i9 = i21;
                                            i5 = i33;
                                            str9 = str18;
                                            str35 = str21;
                                            str11 = str19;
                                            str12 = str23;
                                            z = z4;
                                            i = i26;
                                            str10 = str27;
                                            str7 = str28;
                                            str8 = str32;
                                            i10 = i31;
                                            String str36222 = str16;
                                            i4 = i20;
                                            i2 = i34;
                                            str13 = str36222;
                                        }
                                    } else {
                                        str21 = str20;
                                        str22 = null;
                                    }
                                    i23 = 0;
                                    if ((j & 131075) != 0) {
                                    }
                                    if ((j & 131089) != 0) {
                                    }
                                    i25 = 0;
                                    if ((j & 139265) == 0) {
                                    }
                                    i27 = 0;
                                    if ((j & 131077) != 0) {
                                    }
                                    if ((163841 & j) != 0) {
                                    }
                                    if ((j & 131137) != 0) {
                                    }
                                    i32 = 0;
                                    if ((j & 131329) == 0) {
                                    }
                                    z2 = flip2;
                                    i11 = i18;
                                    i3 = i29;
                                    i12 = i22;
                                    str2 = str30;
                                    str3 = str35;
                                    i7 = i15;
                                    i14 = i24;
                                    i13 = i16;
                                    i6 = i17;
                                    str = str34;
                                    str4 = str25;
                                    i8 = i28;
                                    i9 = i21;
                                    i5 = i33;
                                    str9 = str18;
                                    str35 = str21;
                                    str11 = str19;
                                    str12 = str23;
                                    z = z4;
                                    i = i26;
                                    str10 = str27;
                                    str7 = str28;
                                    str8 = str32;
                                    i10 = i31;
                                    String str362222 = str16;
                                    i4 = i20;
                                    i2 = i34;
                                    str13 = str362222;
                                }
                            } else {
                                str6 = null;
                            }
                            i20 = 0;
                            if ((j & 196609) == 0) {
                            }
                            if ((133121 & j) == 0) {
                            }
                            i23 = 0;
                            if ((j & 131075) != 0) {
                            }
                            if ((j & 131089) != 0) {
                            }
                            i25 = 0;
                            if ((j & 139265) == 0) {
                            }
                            i27 = 0;
                            if ((j & 131077) != 0) {
                            }
                            if ((163841 & j) != 0) {
                            }
                            if ((j & 131137) != 0) {
                            }
                            i32 = 0;
                            if ((j & 131329) == 0) {
                            }
                            z2 = flip2;
                            i11 = i18;
                            i3 = i29;
                            i12 = i22;
                            str2 = str30;
                            str3 = str35;
                            i7 = i15;
                            i14 = i24;
                            i13 = i16;
                            i6 = i17;
                            str = str34;
                            str4 = str25;
                            i8 = i28;
                            i9 = i21;
                            i5 = i33;
                            str9 = str18;
                            str35 = str21;
                            str11 = str19;
                            str12 = str23;
                            z = z4;
                            i = i26;
                            str10 = str27;
                            str7 = str28;
                            str8 = str32;
                            i10 = i31;
                            String str3622222 = str16;
                            i4 = i20;
                            i2 = i34;
                            str13 = str3622222;
                        }
                    } else {
                        str17 = null;
                    }
                    i19 = 0;
                    if ((j & 131201) != 0) {
                    }
                    i20 = 0;
                    if ((j & 196609) == 0) {
                    }
                    if ((133121 & j) == 0) {
                    }
                    i23 = 0;
                    if ((j & 131075) != 0) {
                    }
                    if ((j & 131089) != 0) {
                    }
                    i25 = 0;
                    if ((j & 139265) == 0) {
                    }
                    i27 = 0;
                    if ((j & 131077) != 0) {
                    }
                    if ((163841 & j) != 0) {
                    }
                    if ((j & 131137) != 0) {
                    }
                    i32 = 0;
                    if ((j & 131329) == 0) {
                    }
                    z2 = flip2;
                    i11 = i18;
                    i3 = i29;
                    i12 = i22;
                    str2 = str30;
                    str3 = str35;
                    i7 = i15;
                    i14 = i24;
                    i13 = i16;
                    i6 = i17;
                    str = str34;
                    str4 = str25;
                    i8 = i28;
                    i9 = i21;
                    i5 = i33;
                    str9 = str18;
                    str35 = str21;
                    str11 = str19;
                    str12 = str23;
                    z = z4;
                    i = i26;
                    str10 = str27;
                    str7 = str28;
                    str8 = str32;
                    i10 = i31;
                    String str36222222 = str16;
                    i4 = i20;
                    i2 = i34;
                    str13 = str36222222;
                }
            } else {
                str16 = null;
            }
            i18 = 0;
            if ((j & 147457) == 0) {
            }
            i19 = 0;
            if ((j & 131201) != 0) {
            }
            i20 = 0;
            if ((j & 196609) == 0) {
            }
            if ((133121 & j) == 0) {
            }
            i23 = 0;
            if ((j & 131075) != 0) {
            }
            if ((j & 131089) != 0) {
            }
            i25 = 0;
            if ((j & 139265) == 0) {
            }
            i27 = 0;
            if ((j & 131077) != 0) {
            }
            if ((163841 & j) != 0) {
            }
            if ((j & 131137) != 0) {
            }
            i32 = 0;
            if ((j & 131329) == 0) {
            }
            z2 = flip2;
            i11 = i18;
            i3 = i29;
            i12 = i22;
            str2 = str30;
            str3 = str35;
            i7 = i15;
            i14 = i24;
            i13 = i16;
            i6 = i17;
            str = str34;
            str4 = str25;
            i8 = i28;
            i9 = i21;
            i5 = i33;
            str9 = str18;
            str35 = str21;
            str11 = str19;
            str12 = str23;
            z = z4;
            i = i26;
            str10 = str27;
            str7 = str28;
            str8 = str32;
            i10 = i31;
            String str362222222 = str16;
            i4 = i20;
            i2 = i34;
            str13 = str362222222;
        } else {
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
            str11 = null;
            str12 = null;
            z = false;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
            i9 = 0;
            i10 = 0;
            i11 = 0;
            i12 = 0;
            i13 = 0;
            z2 = false;
            i14 = 0;
            str13 = null;
        }
        if ((j & 131105) != 0) {
            z3 = z;
            TextViewBindingAdapter.setText(this.adc1A, str5);
            SeekBarBindingAdapter.setProgress(this.adc1ASeekBar, i6);
        } else {
            z3 = z;
        }
        if ((j & 131137) != 0) {
            TextViewBindingAdapter.setText(this.adc1B, str);
            SeekBarBindingAdapter.setProgress(this.adc1BSeekBar, i5);
        }
        if ((j & 131201) != 0) {
            TextViewBindingAdapter.setText(this.adc1C, str6);
            SeekBarBindingAdapter.setProgress(this.adc1CSeekBar, i4);
        }
        if ((j & 131077) != 0) {
            TextViewBindingAdapter.setText(this.adc1Coarse, str2);
            SeekBarBindingAdapter.setProgress(this.adc1CoarseSeekBar, i3);
        }
        if ((j & 131329) != 0) {
            TextViewBindingAdapter.setText(this.adc1D, str3);
            SeekBarBindingAdapter.setProgress(this.adc1DSeekBar, i2);
        }
        if ((131089 & j) != 0) {
            TextViewBindingAdapter.setText(this.adc1Fine, str4);
            SeekBarBindingAdapter.setProgress(this.adc1FineSeekBar, i);
        }
        if ((131075 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.adc1FlipCheckbox, z3);
        }
        if ((j & 131081) != 0) {
            TextViewBindingAdapter.setText(this.adc1Inter, str11);
            SeekBarBindingAdapter.setProgress(this.adc1InterSeekBar, i7);
        }
        if ((139265 & j) != 0) {
            TextViewBindingAdapter.setText(this.adc2A, str10);
            SeekBarBindingAdapter.setProgress(this.adc2ASeekBar, i8);
        }
        if ((147457 & j) != 0) {
            TextViewBindingAdapter.setText(this.adc2B, str9);
            SeekBarBindingAdapter.setProgress(this.adc2BSeekBar, i9);
        }
        if ((163841 & j) != 0) {
            TextViewBindingAdapter.setText(this.adc2C, str8);
            SeekBarBindingAdapter.setProgress(this.adc2CSeekBar, i10);
        }
        if ((132097 & j) != 0) {
            TextViewBindingAdapter.setText(this.adc2Coarse, str13);
            SeekBarBindingAdapter.setProgress(this.adc2CoarseSeekBar, i11);
        }
        if ((196609 & j) != 0) {
            TextViewBindingAdapter.setText(this.adc2D, str35);
            SeekBarBindingAdapter.setProgress(this.adc2DSeekBar, i12);
        }
        if ((j & 135169) != 0) {
            TextViewBindingAdapter.setText(this.adc2Fine, str7);
            SeekBarBindingAdapter.setProgress(this.adc2FineSeekBar, i13);
        }
        if ((j & 131585) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.adc2FlipCheckbox, z2);
        }
        if ((j & 133121) != 0) {
            TextViewBindingAdapter.setText(this.adc2Inter, str12);
            SeekBarBindingAdapter.setProgress(this.adc2InterSeekBar, i14);
        }
    }
}
