package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;
import java.util.List;

/* loaded from: classes2.dex */
public class AbapterLaSeniorBindingImpl extends AbapterLaSeniorBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.la_source, 25);
        sViewsWithIds.put(R.id.la_source_on_off, 26);
        sViewsWithIds.put(R.id.trigger_noise_switch, 27);
        sViewsWithIds.put(R.id.la_source_group_text, 28);
        sViewsWithIds.put(R.id.la_wave_color, 29);
        sViewsWithIds.put(R.id.la_group_cancel, 30);
        sViewsWithIds.put(R.id.la_label_show, 31);
        sViewsWithIds.put(R.id.la_source_group_text1, 32);
        sViewsWithIds.put(R.id.la_source_group_text2, 33);
        sViewsWithIds.put(R.id.la_source_group_text3, 34);
    }

    public AbapterLaSeniorBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 35, sIncludes, sViewsWithIds));
    }

    private AbapterLaSeniorBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (AppCompatCheckBox) objArr[3], (AppCompatCheckBox) objArr[4], (AppCompatCheckBox) objArr[13], (AppCompatCheckBox) objArr[14], (AppCompatCheckBox) objArr[15], (AppCompatCheckBox) objArr[16], (AppCompatCheckBox) objArr[17], (AppCompatCheckBox) objArr[18], (AppCompatCheckBox) objArr[5], (AppCompatCheckBox) objArr[6], (AppCompatCheckBox) objArr[7], (AppCompatCheckBox) objArr[8], (AppCompatCheckBox) objArr[9], (AppCompatCheckBox) objArr[10], (AppCompatCheckBox) objArr[11], (AppCompatCheckBox) objArr[12], (Button) objArr[30], (TextView) objArr[20], (TextView) objArr[31], (TextView) objArr[19], (TextView) objArr[25], (TextView) objArr[22], (TextView) objArr[2], (TextView) objArr[28], (TextView) objArr[32], (TextView) objArr[33], (TextView) objArr[34], (TextView) objArr[21], (TextView) objArr[23], (TextView) objArr[26], (TextView) objArr[1], (TextView) objArr[29], (SwitchButton) objArr[24], (SwitchButton) objArr[27]);
        this.mDirtyFlags = -1L;
        this.d0.setTag(null);
        this.d1.setTag(null);
        this.d10.setTag(null);
        this.d11.setTag(null);
        this.d12.setTag(null);
        this.d13.setTag(null);
        this.d14.setTag(null);
        this.d15.setTag(null);
        this.d2.setTag(null);
        this.d3.setTag(null);
        this.d4.setTag(null);
        this.d5.setTag(null);
        this.d6.setTag(null);
        this.d7.setTag(null);
        this.d8.setTag(null);
        this.d9.setTag(null);
        this.laLabelEdit.setTag(null);
        this.laLabelText.setTag(null);
        this.laSourceCentre.setTag(null);
        this.laSourceGroup.setTag(null);
        this.laSourceHigh.setTag(null);
        this.laSourceLow.setTag(null);
        this.laSourceSpinner.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.showLabelSwitch.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
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
        if (600 == i) {
            setParma((LaParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AbapterLaSeniorBinding
    public void setParma(LaParam laParam) {
        updateRegistration(1, laParam);
        this.mParma = laParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(600);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return false;
                            }
                            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaHighColorParmaLaHighColor((MappingObject) obj, i2);
                        }
                        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaHighColorParmaLaEdgeColor((MappingObject) obj, i2);
                    }
                    return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaGroupSetParmaLaGroup1((MappingObject) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaHighColorParmaLaLowColor((MappingObject) obj, i2);
            }
            return onChangeParma((LaParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaCurrentChanParmaLaSource((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaCurrentChanParmaLaSource(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParma(LaParam laParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 473) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 457) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 355) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 475) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 434) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 461) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 456) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 465) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 476) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaHighColorParmaLaLowColor(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaGroupSetParmaLaGroup1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaHighColorParmaLaEdgeColor(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaHighColorParmaLaHighColor(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x029b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0094  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        long j2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        int i;
        boolean z24;
        boolean z25;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z30;
        boolean z31;
        boolean z32;
        boolean z33;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        float f;
        String str7;
        String str8;
        String str9;
        LaParam laParam;
        String str10;
        String str11;
        String str12;
        boolean z34;
        boolean z35;
        boolean z36;
        boolean z37;
        boolean z38;
        int i2;
        boolean z39;
        boolean z40;
        boolean z41;
        boolean z42;
        boolean z43;
        boolean z44;
        boolean z45;
        boolean z46;
        boolean z47;
        boolean z48;
        boolean z49;
        boolean z50;
        boolean z51;
        boolean z52;
        boolean z53;
        boolean z54;
        boolean z55;
        boolean z56;
        boolean z57;
        boolean z58;
        boolean z59;
        boolean z60;
        boolean z61;
        boolean z62;
        long j3;
        float f2;
        long j4;
        boolean z63;
        boolean z64;
        boolean z65;
        int i3;
        String str13;
        String str14;
        int i4;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Integer num7;
        Integer num8;
        Integer num9;
        Integer num10;
        Integer num11;
        Integer num12;
        Integer num13;
        Integer num14;
        Integer num15;
        Integer num16;
        int i5;
        int i6;
        int i7;
        int i8;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        LaParam laParam2 = this.mParma;
        String str15 = null;
        if ((1048575 & j) != 0) {
            if ((j & 659474) != 0) {
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_la_high_color, laParam2 != null ? laParam2.getLa_edge_color() : 0);
                updateRegistration(4, mappingObject);
                if (mappingObject != null) {
                    str7 = mappingObject.getStr();
                    if ((j & 565254) != 0) {
                        MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_la_high_color, laParam2 != null ? laParam2.getLa_low_color() : 0);
                        updateRegistration(2, mappingObject2);
                        if (mappingObject2 != null) {
                            str8 = mappingObject2.getStr();
                            if ((j & 788514) != 0) {
                                MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_la_high_color, laParam2 != null ? laParam2.getLa_high_color() : 0);
                                updateRegistration(5, mappingObject3);
                                if (mappingObject3 != null) {
                                    str9 = mappingObject3.getStr();
                                    if ((j & 524546) == 0) {
                                        List<Integer> glistNow = laParam2 != null ? laParam2.getGlistNow() : null;
                                        if (glistNow != null) {
                                            num9 = (Integer) getFromList(glistNow, 13);
                                            num10 = (Integer) getFromList(glistNow, 2);
                                            num11 = (Integer) getFromList(glistNow, 11);
                                            num12 = (Integer) getFromList(glistNow, 3);
                                            num8 = (Integer) getFromList(glistNow, 8);
                                            num13 = (Integer) getFromList(glistNow, 0);
                                            num14 = (Integer) getFromList(glistNow, 1);
                                            num7 = (Integer) getFromList(glistNow, 9);
                                            Integer num17 = (Integer) getFromList(glistNow, 14);
                                            num6 = (Integer) getFromList(glistNow, 7);
                                            num16 = (Integer) getFromList(glistNow, 15);
                                            num15 = (Integer) getFromList(glistNow, 4);
                                            num5 = (Integer) getFromList(glistNow, 10);
                                            num4 = (Integer) getFromList(glistNow, 6);
                                            num3 = (Integer) getFromList(glistNow, 5);
                                            num2 = (Integer) getFromList(glistNow, 12);
                                            num = num17;
                                        } else {
                                            num = null;
                                            num2 = null;
                                            num3 = null;
                                            num4 = null;
                                            num5 = null;
                                            num6 = null;
                                            num7 = null;
                                            num8 = null;
                                            num9 = null;
                                            num10 = null;
                                            num11 = null;
                                            num12 = null;
                                            num13 = null;
                                            num14 = null;
                                            num15 = null;
                                            num16 = null;
                                        }
                                        int safeUnbox = ViewDataBinding.safeUnbox(num3);
                                        int safeUnbox2 = ViewDataBinding.safeUnbox(num9);
                                        str10 = str7;
                                        int safeUnbox3 = ViewDataBinding.safeUnbox(num10);
                                        int safeUnbox4 = ViewDataBinding.safeUnbox(num5);
                                        str11 = str8;
                                        int safeUnbox5 = ViewDataBinding.safeUnbox(num11);
                                        str12 = str9;
                                        int safeUnbox6 = ViewDataBinding.safeUnbox(num12);
                                        int safeUnbox7 = ViewDataBinding.safeUnbox(num8);
                                        laParam = laParam2;
                                        int safeUnbox8 = ViewDataBinding.safeUnbox(num13);
                                        j2 = j;
                                        int safeUnbox9 = ViewDataBinding.safeUnbox(num14);
                                        int safeUnbox10 = ViewDataBinding.safeUnbox(num7);
                                        int safeUnbox11 = ViewDataBinding.safeUnbox(num4);
                                        int safeUnbox12 = ViewDataBinding.safeUnbox(num);
                                        int safeUnbox13 = ViewDataBinding.safeUnbox(num6);
                                        int safeUnbox14 = ViewDataBinding.safeUnbox(num16);
                                        int safeUnbox15 = ViewDataBinding.safeUnbox(num15);
                                        int safeUnbox16 = ViewDataBinding.safeUnbox(num2);
                                        if (safeUnbox != 2) {
                                            i5 = true;
                                            z47 = true;
                                        } else {
                                            i5 = true;
                                            z47 = false;
                                        }
                                        i2 = safeUnbox == i5 ? i5 : false;
                                        if (safeUnbox2 == i5) {
                                            z44 = i5;
                                            i6 = 2;
                                        } else {
                                            i6 = 2;
                                            z44 = false;
                                        }
                                        if (safeUnbox2 != i6) {
                                            z15 = true;
                                            z48 = true;
                                        } else {
                                            z15 = true;
                                            z48 = false;
                                        }
                                        z49 = safeUnbox3 == z15 ? z15 : false;
                                        z39 = safeUnbox3 != i6 ? z15 : false;
                                        z50 = safeUnbox4 == z15 ? z15 : false;
                                        z11 = safeUnbox4 != i6 ? z15 : false;
                                        z51 = safeUnbox5 == z15 ? z15 : false;
                                        z9 = safeUnbox5 != i6 ? z15 : false;
                                        z52 = safeUnbox6 == z15 ? z15 : false;
                                        z41 = safeUnbox6 != i6 ? z15 : false;
                                        z53 = safeUnbox7 != i6 ? z15 : false;
                                        z43 = safeUnbox7 == z15 ? z15 : false;
                                        z54 = safeUnbox8 == z15 ? z15 : false;
                                        z34 = safeUnbox8 != i6 ? z15 : false;
                                        z55 = safeUnbox9 != i6 ? z15 : false;
                                        z35 = safeUnbox9 == z15 ? z15 : false;
                                        z56 = safeUnbox10 == z15 ? z15 : false;
                                        z36 = safeUnbox10 != i6 ? z15 : false;
                                        z57 = safeUnbox11 == z15 ? z15 : false;
                                        z40 = safeUnbox11 != i6 ? z15 : false;
                                        z58 = safeUnbox12 == z15 ? z15 : false;
                                        z37 = safeUnbox12 != i6 ? z15 : false;
                                        z59 = safeUnbox13 != i6 ? z15 : false;
                                        if (safeUnbox13 == z15) {
                                            i7 = safeUnbox14;
                                            z45 = z15;
                                        } else {
                                            i7 = safeUnbox14;
                                            z45 = false;
                                        }
                                        z60 = i7 != i6 ? z15 : false;
                                        z42 = i7 == z15 ? z15 : false;
                                        z61 = safeUnbox15 != i6 ? z15 : false;
                                        if (safeUnbox15 == z15) {
                                            i8 = safeUnbox16;
                                            z46 = z15;
                                        } else {
                                            i8 = safeUnbox16;
                                            z46 = false;
                                        }
                                        z38 = i8 != i6 ? z15 : false;
                                        if (i8 != z15) {
                                            z15 = false;
                                        }
                                    } else {
                                        laParam = laParam2;
                                        j2 = j;
                                        str10 = str7;
                                        str11 = str8;
                                        str12 = str9;
                                        z34 = false;
                                        z35 = false;
                                        z36 = false;
                                        z37 = false;
                                        z38 = false;
                                        i2 = false;
                                        z39 = false;
                                        z40 = false;
                                        z9 = false;
                                        z41 = false;
                                        z11 = false;
                                        z42 = false;
                                        z43 = false;
                                        z15 = false;
                                        z44 = false;
                                        z45 = false;
                                        z46 = false;
                                        z47 = false;
                                        z48 = false;
                                        z49 = false;
                                        z50 = false;
                                        z51 = false;
                                        z52 = false;
                                        z53 = false;
                                        z54 = false;
                                        z55 = false;
                                        z56 = false;
                                        z57 = false;
                                        z58 = false;
                                        z59 = false;
                                        z60 = false;
                                        z61 = false;
                                    }
                                    String inputLabel = ((j2 & 525314) != 0 || laParam == null) ? null : laParam.getInputLabel();
                                    if ((j2 & 524802) == 0) {
                                        z62 = laParam != null ? laParam.getLabel() : false;
                                        f2 = ContextUtil.getAlpha(z62);
                                        j3 = 540674;
                                    } else {
                                        z62 = false;
                                        j3 = 540674;
                                        f2 = 0.0f;
                                    }
                                    if ((j2 & j3) != 0 || laParam == null) {
                                        j4 = 524355;
                                        z63 = false;
                                    } else {
                                        z63 = laParam.getLabelGroup();
                                        j4 = 524355;
                                    }
                                    if ((j2 & j4) == 0) {
                                        if (laParam != null) {
                                            z65 = z35;
                                            z64 = z34;
                                            i4 = laParam.getLa_source();
                                        } else {
                                            z64 = z34;
                                            z65 = z35;
                                            i4 = 0;
                                        }
                                        MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_la_current_chan, i4);
                                        i3 = 0;
                                        updateRegistration(0, mappingObject4);
                                        if (mappingObject4 != null) {
                                            str13 = mappingObject4.getStr();
                                            if ((j2 & 589962) != 0) {
                                                if (laParam != null) {
                                                    i3 = laParam.getLa_group1();
                                                }
                                                str14 = str13;
                                                MappingObject mappingObject5 = ViewUtil.getMappingObject(R.array.msg_la_group_set, i3);
                                                updateRegistration(3, mappingObject5);
                                                if (mappingObject5 != null) {
                                                    str15 = mappingObject5.getStr();
                                                }
                                            } else {
                                                str14 = str13;
                                            }
                                            z30 = z36;
                                            i = i2;
                                            z17 = z39;
                                            z24 = z40;
                                            z19 = z41;
                                            z16 = z42;
                                            str = inputLabel;
                                            z29 = z43;
                                            str5 = str11;
                                            str3 = str15;
                                            z32 = z62;
                                            z10 = z44;
                                            str4 = str12;
                                            str6 = str14;
                                            z27 = z45;
                                            z22 = z46;
                                            z23 = z47;
                                            z8 = z48;
                                            str2 = str10;
                                            z18 = z49;
                                            z20 = z52;
                                            z28 = z53;
                                            z = z54;
                                            z2 = z55;
                                            z31 = z56;
                                            z25 = z57;
                                            z13 = z58;
                                            z26 = z59;
                                            z14 = z60;
                                            z21 = z61;
                                            f = f2;
                                            z33 = z63;
                                            z6 = z64;
                                            z3 = z65;
                                            z12 = z37;
                                            z7 = z38;
                                            z4 = z50;
                                            z5 = z51;
                                        }
                                    } else {
                                        z64 = z34;
                                        z65 = z35;
                                        i3 = 0;
                                    }
                                    str13 = null;
                                    if ((j2 & 589962) != 0) {
                                    }
                                    z30 = z36;
                                    i = i2;
                                    z17 = z39;
                                    z24 = z40;
                                    z19 = z41;
                                    z16 = z42;
                                    str = inputLabel;
                                    z29 = z43;
                                    str5 = str11;
                                    str3 = str15;
                                    z32 = z62;
                                    z10 = z44;
                                    str4 = str12;
                                    str6 = str14;
                                    z27 = z45;
                                    z22 = z46;
                                    z23 = z47;
                                    z8 = z48;
                                    str2 = str10;
                                    z18 = z49;
                                    z20 = z52;
                                    z28 = z53;
                                    z = z54;
                                    z2 = z55;
                                    z31 = z56;
                                    z25 = z57;
                                    z13 = z58;
                                    z26 = z59;
                                    z14 = z60;
                                    z21 = z61;
                                    f = f2;
                                    z33 = z63;
                                    z6 = z64;
                                    z3 = z65;
                                    z12 = z37;
                                    z7 = z38;
                                    z4 = z50;
                                    z5 = z51;
                                }
                            }
                            str9 = null;
                            if ((j & 524546) == 0) {
                            }
                            if ((j2 & 525314) != 0) {
                            }
                            if ((j2 & 524802) == 0) {
                            }
                            if ((j2 & j3) != 0) {
                            }
                            j4 = 524355;
                            z63 = false;
                            if ((j2 & j4) == 0) {
                            }
                            str13 = null;
                            if ((j2 & 589962) != 0) {
                            }
                            z30 = z36;
                            i = i2;
                            z17 = z39;
                            z24 = z40;
                            z19 = z41;
                            z16 = z42;
                            str = inputLabel;
                            z29 = z43;
                            str5 = str11;
                            str3 = str15;
                            z32 = z62;
                            z10 = z44;
                            str4 = str12;
                            str6 = str14;
                            z27 = z45;
                            z22 = z46;
                            z23 = z47;
                            z8 = z48;
                            str2 = str10;
                            z18 = z49;
                            z20 = z52;
                            z28 = z53;
                            z = z54;
                            z2 = z55;
                            z31 = z56;
                            z25 = z57;
                            z13 = z58;
                            z26 = z59;
                            z14 = z60;
                            z21 = z61;
                            f = f2;
                            z33 = z63;
                            z6 = z64;
                            z3 = z65;
                            z12 = z37;
                            z7 = z38;
                            z4 = z50;
                            z5 = z51;
                        }
                    }
                    str8 = null;
                    if ((j & 788514) != 0) {
                    }
                    str9 = null;
                    if ((j & 524546) == 0) {
                    }
                    if ((j2 & 525314) != 0) {
                    }
                    if ((j2 & 524802) == 0) {
                    }
                    if ((j2 & j3) != 0) {
                    }
                    j4 = 524355;
                    z63 = false;
                    if ((j2 & j4) == 0) {
                    }
                    str13 = null;
                    if ((j2 & 589962) != 0) {
                    }
                    z30 = z36;
                    i = i2;
                    z17 = z39;
                    z24 = z40;
                    z19 = z41;
                    z16 = z42;
                    str = inputLabel;
                    z29 = z43;
                    str5 = str11;
                    str3 = str15;
                    z32 = z62;
                    z10 = z44;
                    str4 = str12;
                    str6 = str14;
                    z27 = z45;
                    z22 = z46;
                    z23 = z47;
                    z8 = z48;
                    str2 = str10;
                    z18 = z49;
                    z20 = z52;
                    z28 = z53;
                    z = z54;
                    z2 = z55;
                    z31 = z56;
                    z25 = z57;
                    z13 = z58;
                    z26 = z59;
                    z14 = z60;
                    z21 = z61;
                    f = f2;
                    z33 = z63;
                    z6 = z64;
                    z3 = z65;
                    z12 = z37;
                    z7 = z38;
                    z4 = z50;
                    z5 = z51;
                }
            }
            str7 = null;
            if ((j & 565254) != 0) {
            }
            str8 = null;
            if ((j & 788514) != 0) {
            }
            str9 = null;
            if ((j & 524546) == 0) {
            }
            if ((j2 & 525314) != 0) {
            }
            if ((j2 & 524802) == 0) {
            }
            if ((j2 & j3) != 0) {
            }
            j4 = 524355;
            z63 = false;
            if ((j2 & j4) == 0) {
            }
            str13 = null;
            if ((j2 & 589962) != 0) {
            }
            z30 = z36;
            i = i2;
            z17 = z39;
            z24 = z40;
            z19 = z41;
            z16 = z42;
            str = inputLabel;
            z29 = z43;
            str5 = str11;
            str3 = str15;
            z32 = z62;
            z10 = z44;
            str4 = str12;
            str6 = str14;
            z27 = z45;
            z22 = z46;
            z23 = z47;
            z8 = z48;
            str2 = str10;
            z18 = z49;
            z20 = z52;
            z28 = z53;
            z = z54;
            z2 = z55;
            z31 = z56;
            z25 = z57;
            z13 = z58;
            z26 = z59;
            z14 = z60;
            z21 = z61;
            f = f2;
            z33 = z63;
            z6 = z64;
            z3 = z65;
            z12 = z37;
            z7 = z38;
            z4 = z50;
            z5 = z51;
        } else {
            j2 = j;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
            z8 = false;
            z9 = false;
            z10 = false;
            z11 = false;
            z12 = false;
            z13 = false;
            z14 = false;
            z15 = false;
            z16 = false;
            z17 = false;
            z18 = false;
            z19 = false;
            z20 = false;
            z21 = false;
            z22 = false;
            z23 = false;
            i = false;
            z24 = false;
            z25 = false;
            z26 = false;
            z27 = false;
            z28 = false;
            z29 = false;
            z30 = false;
            z31 = false;
            z32 = false;
            z33 = false;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            f = 0.0f;
        }
        if ((j2 & 524546) != 0) {
            this.d0.setEnabled(z6);
            CompoundButtonBindingAdapter.setChecked(this.d0, z);
            this.d1.setEnabled(z2);
            CompoundButtonBindingAdapter.setChecked(this.d1, z3);
            this.d10.setEnabled(z11);
            CompoundButtonBindingAdapter.setChecked(this.d10, z4);
            this.d11.setEnabled(z9);
            CompoundButtonBindingAdapter.setChecked(this.d11, z5);
            this.d12.setEnabled(z7);
            CompoundButtonBindingAdapter.setChecked(this.d12, z15);
            this.d13.setEnabled(z8);
            CompoundButtonBindingAdapter.setChecked(this.d13, z10);
            this.d14.setEnabled(z12);
            CompoundButtonBindingAdapter.setChecked(this.d14, z13);
            this.d15.setEnabled(z14);
            CompoundButtonBindingAdapter.setChecked(this.d15, z16);
            this.d2.setEnabled(z17);
            CompoundButtonBindingAdapter.setChecked(this.d2, z18);
            this.d3.setEnabled(z19);
            CompoundButtonBindingAdapter.setChecked(this.d3, z20);
            this.d4.setEnabled(z21);
            CompoundButtonBindingAdapter.setChecked(this.d4, z22);
            this.d5.setEnabled(z23);
            CompoundButtonBindingAdapter.setChecked(this.d5, i);
            this.d6.setEnabled(z24);
            CompoundButtonBindingAdapter.setChecked(this.d6, z25);
            this.d7.setEnabled(z26);
            CompoundButtonBindingAdapter.setChecked(this.d7, z27);
            this.d8.setEnabled(z28);
            CompoundButtonBindingAdapter.setChecked(this.d8, z29);
            this.d9.setEnabled(z30);
            CompoundButtonBindingAdapter.setChecked(this.d9, z31);
        }
        if ((j2 & 525314) != 0) {
            TextViewBindingAdapter.setText(this.laLabelEdit, str);
        }
        if ((j2 & 524802) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.laLabelText.setAlpha(f);
            }
            this.laLabelText.setEnabled(z32);
        }
        if ((j2 & 659474) != 0) {
            TextViewBindingAdapter.setText(this.laSourceCentre, str2);
        }
        if ((j2 & 589962) != 0) {
            TextViewBindingAdapter.setText(this.laSourceGroup, str3);
        }
        if ((j2 & 788514) != 0) {
            TextViewBindingAdapter.setText(this.laSourceHigh, str4);
        }
        if ((j2 & 565254) != 0) {
            TextViewBindingAdapter.setText(this.laSourceLow, str5);
        }
        if ((j2 & 524355) != 0) {
            TextViewBindingAdapter.setText(this.laSourceSpinner, str6);
        }
        if ((j2 & 540674) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.showLabelSwitch, z33);
        }
    }
}
