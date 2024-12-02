package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.vertical.VerticalSeekBar;
import com.rigol.scope.views.vertical.VerticalSeekBarWrapper;

/* loaded from: classes2.dex */
public class AdapterTriggerSlopeBindingImpl extends AdapterTriggerSlopeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 23);
        sViewsWithIds.put(R.id.guideline_center, 24);
        sViewsWithIds.put(R.id.guideline_right, 25);
        sViewsWithIds.put(R.id.guideline_forth, 26);
        sViewsWithIds.put(R.id.guideline_fifth, 27);
        sViewsWithIds.put(R.id.view_top, 28);
        sViewsWithIds.put(R.id.view_1, 29);
        sViewsWithIds.put(R.id.trigger_noise, 30);
        sViewsWithIds.put(R.id.trigger_level_select_label, 31);
        sViewsWithIds.put(R.id.trigger_source_label, 32);
        sViewsWithIds.put(R.id.trigger_edge_label, 33);
        sViewsWithIds.put(R.id.trigger_levelB, 34);
        sViewsWithIds.put(R.id.slope_type_label, 35);
        sViewsWithIds.put(R.id.trigger_level, 36);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 37);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper3, 38);
        sViewsWithIds.put(R.id.trigger_holdoff_label, 39);
        sViewsWithIds.put(R.id.trigger_noise_label, 40);
    }

    public AdapterTriggerSlopeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 41, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerSlopeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 9, (Button) objArr[9], (Button) objArr[10], (RadioButton) objArr[8], (RadioButton) objArr[7], (Guideline) objArr[24], (Guideline) objArr[27], (Guideline) objArr[26], (Guideline) objArr[23], (Guideline) objArr[25], (ImageView) objArr[15], (RadioButton) objArr[20], (RadioButton) objArr[19], (TextView) objArr[11], (EditText) objArr[12], (RadioButton) objArr[18], (TextView) objArr[35], (TextView) objArr[33], (EditText) objArr[21], (TextView) objArr[39], (TextView) objArr[36], (EditText) objArr[13], (VerticalSeekBar) objArr[16], (TextView) objArr[34], (EditText) objArr[14], (VerticalSeekBar) objArr[17], (RadioButton) objArr[5], (CheckBox) objArr[3], (RadioButton) objArr[4], (TextView) objArr[31], (View) objArr[30], (TextView) objArr[40], (SwitchButton) objArr[22], (TextView) objArr[6], (TextView) objArr[32], (TextView) objArr[1], (EditText) objArr[2], (VerticalSeekBarWrapper) objArr[37], (VerticalSeekBarWrapper) objArr[38], (View) objArr[29], (View) objArr[28]);
        this.mDirtyFlags = -1L;
        this.buttonLevel.setTag(null);
        this.buttonLevelB.setTag(null);
        this.edgeFalling.setTag(null);
        this.edgeRising.setTag(null);
        this.imageView2.setTag(null);
        this.lessMore.setTag(null);
        this.lessThan.setTag(null);
        this.lowerLimit.setTag(null);
        this.lowerLimitValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.moreThan.setTag(null);
        this.triggerHoldoff.setTag(null);
        this.triggerLevelAValue.setTag(null);
        this.triggerLevelAView.setTag(null);
        this.triggerLevelBValue.setTag(null);
        this.triggerLevelBView.setTag(null);
        this.triggerLevelSelectA.setTag(null);
        this.triggerLevelSelectAb.setTag(null);
        this.triggerLevelSelectB.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSource.setTag(null);
        this.upperLimit.setTag(null);
        this.upperLimitValue.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 134217728L;
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
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (848 == i) {
            setSlopeFallingMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (790 == i) {
            setSelectLevelBMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (850 == i) {
            setSlopeRisingMapping((MappingObject) obj);
        } else if (789 != i) {
            return false;
        } else {
            setSelectLevelAMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSlopeBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(0, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSlopeBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSlopeBinding
    public void setSlopeFallingMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mSlopeFallingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(848);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSlopeBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSlopeBinding
    public void setSelectLevelBMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mSelectLevelBMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(790);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSlopeBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSlopeBinding
    public void setSlopeRisingMapping(MappingObject mappingObject) {
        updateRegistration(7, mappingObject);
        this.mSlopeRisingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(850);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSlopeBinding
    public void setSelectLevelAMapping(MappingObject mappingObject) {
        updateRegistration(8, mappingObject);
        this.mSelectLevelAMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(789);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeParam((TriggerParam) obj, i2);
            case 1:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 2:
                return onChangeSlopeFallingMapping((MappingObject) obj, i2);
            case 3:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceParamChanValue1((MappingObject) obj, i2);
            case 4:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 5:
                return onChangeSelectLevelBMapping((MappingObject) obj, i2);
            case 6:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 7:
                return onChangeSlopeRisingMapping((MappingObject) obj, i2);
            case 8:
                return onChangeSelectLevelAMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 256) {
            synchronized (this) {
                this.mDirtyFlags |= 524800;
            }
            return true;
        } else if (i == 852) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 851) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 846) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 849) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 853) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 854) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 672) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 673) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 377) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepAutoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSlopeFallingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSelectLevelBMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSlopeRisingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
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

    private boolean onChangeSelectLevelAMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
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

    /* JADX WARN: Code restructure failed: missing block: B:111:0x0195, code lost:
        if (r4 != false) goto L88;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0261 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x013a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0148  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Drawable drawable;
        int i;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i5;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        Drawable drawable2;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        String str7;
        long j3;
        String str8;
        int i6;
        String str9;
        int i7;
        String str10;
        int i8;
        String str11;
        boolean z18;
        String str12;
        int i9;
        int i10;
        int i11;
        String str13;
        String str14;
        int i12;
        String str15;
        String str16;
        String str17;
        long j4;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        String str18;
        long j5;
        long j6;
        ServiceEnum.EMoreThan eMoreThan;
        long j7;
        long j8;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        TriggerParam triggerParam = this.mParam;
        MappingObject mappingObject = this.mSlopeFallingMapping;
        MappingObject mappingObject2 = this.mSelectLevelBMapping;
        MappingObject mappingObject3 = this.mSlopeRisingMapping;
        MappingObject mappingObject4 = this.mSelectLevelAMapping;
        String str19 = null;
        if ((146800137 & j) != 0) {
            if ((j & 134219777) != 0) {
                ServiceEnum.Trigger_Level_ID slopeTrigger_Level_ID = triggerParam != null ? triggerParam.getSlopeTrigger_Level_ID() : null;
                z12 = slopeTrigger_Level_ID == ServiceEnum.Trigger_Level_ID.Trigger_Level_High;
                z11 = slopeTrigger_Level_ID == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double;
                z10 = slopeTrigger_Level_ID == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low;
            } else {
                z10 = false;
                z11 = false;
                z12 = false;
            }
            int progressB = ((j & 134479873) == 0 || triggerParam == null) ? 0 : triggerParam.getProgressB();
            if ((j & 134225921) != 0) {
                ServiceEnum.EdgeSlope slope = triggerParam != null ? triggerParam.getSlope() : null;
                z14 = slope == ServiceEnum.EdgeSlope.Trigger_Edge_Falling;
                drawable2 = ViewUtil.getTriggerSslopePic(slope);
                z13 = slope == ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
            } else {
                drawable2 = null;
                z13 = false;
                z14 = false;
            }
            if ((j & 134234113) != 0) {
                if (triggerParam != null) {
                    z15 = z13;
                    j8 = triggerParam.getSlopeLowerLimit();
                } else {
                    z15 = z13;
                    j8 = 0;
                }
                z16 = z10;
                z17 = z11;
                str7 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j8, ServiceEnum.Unit.Unit_s);
            } else {
                z15 = z13;
                z16 = z10;
                z17 = z11;
                str7 = null;
            }
            if ((j & 142610441) != 0) {
                ServiceEnum.Chan chan = triggerParam != null ? triggerParam.getChan() : null;
                MappingObject mappingObject5 = ViewUtil.getMappingObject(R.array.msg_trigger_source, chan != null ? chan.value1 : 0);
                updateRegistration(3, mappingObject5);
                str8 = mappingObject5 != null ? mappingObject5.getStr() : null;
                j3 = 0;
                if ((j & 134221825) != 0) {
                    i6 = ColorUtil.getColor(getRoot().getContext(), chan);
                    if ((j & 134283265) == j3) {
                        if (triggerParam != null) {
                            str9 = str7;
                            i7 = i6;
                            j7 = triggerParam.getSlopelevelB();
                        } else {
                            str9 = str7;
                            i7 = i6;
                            j7 = 0;
                        }
                        if (triggerParam != null) {
                            str10 = triggerParam.getTriggerLevelStr(j7);
                            boolean isNoise = ((j & 136314881) != 0 || triggerParam == null) ? false : triggerParam.getIsNoise();
                            i8 = ((j & 134218241) > 0L ? 1 : ((j & 134218241) == 0L ? 0 : -1));
                            if (i8 != 0) {
                                if (triggerParam != null) {
                                    z18 = isNoise;
                                    str11 = str10;
                                    eMoreThan = triggerParam.getEMoreThan();
                                } else {
                                    str11 = str10;
                                    z18 = isNoise;
                                    eMoreThan = null;
                                }
                                str12 = str8;
                                boolean z24 = eMoreThan == ServiceEnum.EMoreThan.Trigger_When_Lessthan;
                                boolean z25 = eMoreThan == ServiceEnum.EMoreThan.Trigger_When_Morethan;
                                if (i8 != 0) {
                                    j |= z24 ? 536870912L : 268435456L;
                                }
                                if ((j & 134218241) != 0) {
                                    j |= z25 ? 2147483648L : 1073741824L;
                                }
                                i10 = 4;
                                i9 = z24 ? 4 : 0;
                            } else {
                                str11 = str10;
                                z18 = isNoise;
                                str12 = str8;
                                i9 = 0;
                            }
                            i10 = 0;
                            if ((j & 134250497) != 0) {
                                if (triggerParam != null) {
                                    i11 = i9;
                                    j6 = triggerParam.getSlopelevelA();
                                } else {
                                    i11 = i9;
                                    j6 = 0;
                                }
                                if (triggerParam != null) {
                                    str13 = triggerParam.getTriggerLevelStr(j6);
                                    if ((j & 135266305) == 0) {
                                        if (triggerParam != null) {
                                            str14 = str13;
                                            j5 = triggerParam.getHoldOff();
                                        } else {
                                            str14 = str13;
                                            j5 = 0;
                                        }
                                        i12 = i10;
                                        str15 = str9;
                                        str16 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j5, ServiceEnum.Unit.Unit_s);
                                    } else {
                                        str14 = str13;
                                        i12 = i10;
                                        str15 = str9;
                                        str16 = null;
                                    }
                                    if ((j & 134742017) == 0) {
                                        ServiceEnum.EMoreThan eMoreThan2 = triggerParam != null ? triggerParam.getEMoreThan() : null;
                                        z19 = eMoreThan2 == ServiceEnum.EMoreThan.Trigger_When_Morethan;
                                        str17 = str16;
                                        z20 = eMoreThan2 == ServiceEnum.EMoreThan.Trigger_When_Lessthan;
                                        z21 = eMoreThan2 == ServiceEnum.EMoreThan.Trigger_When_MoreLess;
                                        j4 = 134218753;
                                    } else {
                                        str17 = str16;
                                        j4 = 134218753;
                                        z19 = false;
                                        z20 = false;
                                        z21 = false;
                                    }
                                    if ((j & j4) == 0) {
                                        z22 = z19;
                                        z23 = z20;
                                        str18 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(triggerParam != null ? triggerParam.getSlopeUperLimit() : 0L, ServiceEnum.Unit.Unit_s);
                                    } else {
                                        z22 = z19;
                                        z23 = z20;
                                        str18 = null;
                                    }
                                    j2 = 0;
                                    if ((j & 134348801) != 0 || triggerParam == null) {
                                        z7 = z12;
                                        i5 = progressB;
                                        z8 = z14;
                                        drawable = drawable2;
                                        z9 = z21;
                                        z6 = z17;
                                        z4 = z16;
                                        i3 = i7;
                                        i2 = i11;
                                        z2 = z18;
                                        str6 = str12;
                                        str3 = str14;
                                        str = str15;
                                        i4 = i12;
                                        str2 = str17;
                                        z5 = z23;
                                        z3 = z22;
                                        i = 0;
                                    } else {
                                        i = triggerParam.getProgressA();
                                        z7 = z12;
                                        i5 = progressB;
                                        z8 = z14;
                                        drawable = drawable2;
                                        z9 = z21;
                                        z6 = z17;
                                        z4 = z16;
                                        i3 = i7;
                                        i2 = i11;
                                        z2 = z18;
                                        str6 = str12;
                                        str3 = str14;
                                        str = str15;
                                        i4 = i12;
                                        str2 = str17;
                                        z5 = z23;
                                        z3 = z22;
                                    }
                                    str5 = str18;
                                    z = z15;
                                    str4 = str11;
                                }
                            } else {
                                i11 = i9;
                            }
                            str13 = null;
                            if ((j & 135266305) == 0) {
                            }
                            if ((j & 134742017) == 0) {
                            }
                            if ((j & j4) == 0) {
                            }
                            j2 = 0;
                            if ((j & 134348801) != 0) {
                            }
                            z7 = z12;
                            i5 = progressB;
                            z8 = z14;
                            drawable = drawable2;
                            z9 = z21;
                            z6 = z17;
                            z4 = z16;
                            i3 = i7;
                            i2 = i11;
                            z2 = z18;
                            str6 = str12;
                            str3 = str14;
                            str = str15;
                            i4 = i12;
                            str2 = str17;
                            z5 = z23;
                            z3 = z22;
                            i = 0;
                            str5 = str18;
                            z = z15;
                            str4 = str11;
                        }
                    } else {
                        str9 = str7;
                        i7 = i6;
                    }
                    str10 = null;
                    if ((j & 136314881) != 0) {
                    }
                    i8 = ((j & 134218241) > 0L ? 1 : ((j & 134218241) == 0L ? 0 : -1));
                    if (i8 != 0) {
                    }
                    i10 = 0;
                    if ((j & 134250497) != 0) {
                    }
                    str13 = null;
                    if ((j & 135266305) == 0) {
                    }
                    if ((j & 134742017) == 0) {
                    }
                    if ((j & j4) == 0) {
                    }
                    j2 = 0;
                    if ((j & 134348801) != 0) {
                    }
                    z7 = z12;
                    i5 = progressB;
                    z8 = z14;
                    drawable = drawable2;
                    z9 = z21;
                    z6 = z17;
                    z4 = z16;
                    i3 = i7;
                    i2 = i11;
                    z2 = z18;
                    str6 = str12;
                    str3 = str14;
                    str = str15;
                    i4 = i12;
                    str2 = str17;
                    z5 = z23;
                    z3 = z22;
                    i = 0;
                    str5 = str18;
                    z = z15;
                    str4 = str11;
                }
            } else {
                j3 = 0;
                str8 = null;
            }
            i6 = 0;
            if ((j & 134283265) == j3) {
            }
            str10 = null;
            if ((j & 136314881) != 0) {
            }
            i8 = ((j & 134218241) > 0L ? 1 : ((j & 134218241) == 0L ? 0 : -1));
            if (i8 != 0) {
            }
            i10 = 0;
            if ((j & 134250497) != 0) {
            }
            str13 = null;
            if ((j & 135266305) == 0) {
            }
            if ((j & 134742017) == 0) {
            }
            if ((j & j4) == 0) {
            }
            j2 = 0;
            if ((j & 134348801) != 0) {
            }
            z7 = z12;
            i5 = progressB;
            z8 = z14;
            drawable = drawable2;
            z9 = z21;
            z6 = z17;
            z4 = z16;
            i3 = i7;
            i2 = i11;
            z2 = z18;
            str6 = str12;
            str3 = str14;
            str = str15;
            i4 = i12;
            str2 = str17;
            z5 = z23;
            z3 = z22;
            i = 0;
            str5 = str18;
            z = z15;
            str4 = str11;
        } else {
            j2 = 0;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            drawable = null;
            i = 0;
            z = false;
            i2 = 0;
            z2 = false;
            i3 = 0;
            z3 = false;
            i4 = 0;
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
            i5 = 0;
            z8 = false;
            z9 = false;
        }
        int i13 = ((j & 138412036) > j2 ? 1 : ((j & 138412036) == j2 ? 0 : -1));
        String str20 = (i13 == 0 || mappingObject == null) ? null : mappingObject.getStr();
        int i14 = ((j & 150994976) > j2 ? 1 : ((j & 150994976) == j2 ? 0 : -1));
        String str21 = (i14 == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        int i15 = ((j & 167772288) > j2 ? 1 : ((j & 167772288) == j2 ? 0 : -1));
        String str22 = (i15 == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        int i16 = ((j & 201326848) > j2 ? 1 : ((j & 201326848) == j2 ? 0 : -1));
        if (i16 != 0 && mappingObject4 != null) {
            str19 = mappingObject4.getStr();
        }
        String str23 = str19;
        if ((j & 134217728) != j2) {
            this.buttonLevel.setVisibility(0);
            this.buttonLevelB.setVisibility(0);
            this.triggerLevelAValue.setVisibility(0);
            this.triggerLevelAView.setVisibility(0);
            this.triggerLevelBValue.setVisibility(0);
            this.triggerLevelBView.setVisibility(0);
        }
        if ((j & 134225921) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.edgeFalling, z8);
            CompoundButtonBindingAdapter.setChecked(this.edgeRising, z);
            ImageViewBindingAdapter.setImageDrawable(this.imageView2, drawable);
        }
        if (i13 != 0) {
            TextViewBindingAdapter.setText(this.edgeFalling, str20);
        }
        if (i15 != 0) {
            TextViewBindingAdapter.setText(this.edgeRising, str22);
        }
        if ((j & 134742017) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.lessMore, z9);
            CompoundButtonBindingAdapter.setChecked(this.lessThan, z5);
            CompoundButtonBindingAdapter.setChecked(this.moreThan, z3);
        }
        if ((j & 134218241) != 0) {
            int i17 = i2;
            this.lowerLimit.setVisibility(i17);
            this.lowerLimitValue.setVisibility(i17);
            int i18 = i4;
            this.upperLimit.setVisibility(i18);
            this.upperLimitValue.setVisibility(i18);
        }
        if ((j & 134234113) != 0) {
            TextViewBindingAdapter.setText(this.lowerLimitValue, str);
        }
        if ((135266305 & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerHoldoff, str2);
        }
        if ((j & 134250497) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelAValue, str3);
        }
        if ((134348801 & j) != 0) {
            SeekBarBindingAdapter.setProgress(this.triggerLevelAView, i);
        }
        if ((j & 134283265) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelBValue, str4);
        }
        if ((j & 134479873) != 0) {
            SeekBarBindingAdapter.setProgress(this.triggerLevelBView, i5);
        }
        if ((j & 134219777) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerLevelSelectA, z7);
            CompoundButtonBindingAdapter.setChecked(this.triggerLevelSelectAb, z6);
            CompoundButtonBindingAdapter.setChecked(this.triggerLevelSelectB, z4);
        }
        if (i16 != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelSelectA, str23);
        }
        if (i14 != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelSelectB, str21);
        }
        if ((j & 136314881) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerNoiseSwitch, z2);
        }
        if ((j & 142610441) != 0) {
            TextViewBindingAdapter.setText(this.triggerSource, str6);
        }
        if ((j & 134221825) != 0) {
            this.triggerSource.setTextColor(i3);
        }
        if ((j & 134218753) != 0) {
            TextViewBindingAdapter.setText(this.upperLimitValue, str5);
        }
    }
}
