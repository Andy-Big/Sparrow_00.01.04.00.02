package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
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
public class AdapterTriggerDelayBindingImpl extends AdapterTriggerDelayBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 22);
        sViewsWithIds.put(R.id.guideline_center, 23);
        sViewsWithIds.put(R.id.guideline_right, 24);
        sViewsWithIds.put(R.id.guideline_forth, 25);
        sViewsWithIds.put(R.id.guideline_fifth, 26);
        sViewsWithIds.put(R.id.view_top, 27);
        sViewsWithIds.put(R.id.view_1, 28);
        sViewsWithIds.put(R.id.trigger_source_b_label2, 29);
        sViewsWithIds.put(R.id.trigger_edge_b_label, 30);
        sViewsWithIds.put(R.id.trigger_levelB, 31);
        sViewsWithIds.put(R.id.button_level, 32);
        sViewsWithIds.put(R.id.button_levelB, 33);
        sViewsWithIds.put(R.id.trigger_source_a_label, 34);
        sViewsWithIds.put(R.id.trigger_edge_a_label, 35);
        sViewsWithIds.put(R.id.slope_type_label, 36);
        sViewsWithIds.put(R.id.trigger_level, 37);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 38);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper3, 39);
        sViewsWithIds.put(R.id.trigger_holdoff_label, 40);
        sViewsWithIds.put(R.id.trigger_noise_label, 41);
        sViewsWithIds.put(R.id.view_line_1, 42);
        sViewsWithIds.put(R.id.view_line_2, 43);
    }

    public AdapterTriggerDelayBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 44, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerDelayBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 10, (Button) objArr[32], (Button) objArr[33], (RadioButton) objArr[19], (RadioButton) objArr[18], (RadioButton) objArr[3], (RadioButton) objArr[2], (Guideline) objArr[23], (Guideline) objArr[26], (Guideline) objArr[25], (Guideline) objArr[22], (Guideline) objArr[24], (ImageView) objArr[11], (RadioButton) objArr[16], (RadioButton) objArr[15], (TextView) objArr[6], (EditText) objArr[7], (RadioButton) objArr[17], (RadioButton) objArr[14], (TextView) objArr[36], (TextView) objArr[35], (TextView) objArr[30], (EditText) objArr[20], (TextView) objArr[40], (TextView) objArr[37], (EditText) objArr[9], (VerticalSeekBar) objArr[12], (TextView) objArr[31], (EditText) objArr[10], (VerticalSeekBar) objArr[13], (TextView) objArr[41], (SwitchButton) objArr[21], (TextView) objArr[8], (TextView) objArr[34], (TextView) objArr[1], (TextView) objArr[29], (TextView) objArr[4], (EditText) objArr[5], (VerticalSeekBarWrapper) objArr[38], (VerticalSeekBarWrapper) objArr[39], (View) objArr[28], (View) objArr[42], (View) objArr[43], (View) objArr[27]);
        this.mDirtyFlags = -1L;
        this.edgeAFalling.setTag(null);
        this.edgeARising.setTag(null);
        this.edgeBFalling.setTag(null);
        this.edgeBRising.setTag(null);
        this.imageView2.setTag(null);
        this.lessMore.setTag(null);
        this.lessThan.setTag(null);
        this.lowerLimit.setTag(null);
        this.lowerLimitValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.moreLess.setTag(null);
        this.moreThan.setTag(null);
        this.triggerHoldoff.setTag(null);
        this.triggerLevelAValue.setTag(null);
        this.triggerLevelAView.setTag(null);
        this.triggerLevelBValue.setTag(null);
        this.triggerLevelBView.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSourceA.setTag(null);
        this.triggerSourceB.setTag(null);
        this.upperLimit.setTag(null);
        this.upperLimitValue.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1073741824L;
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
        if (260 == i) {
            setEdgeFallingBMapping((MappingObject) obj);
        } else if (263 == i) {
            setEdgeRisingAMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (259 == i) {
            setEdgeFallingAMapping((MappingObject) obj);
        } else if (264 == i) {
            setEdgeRisingBMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (917 != i) {
            return false;
        } else {
            setSweepNormalMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDelayBinding
    public void setEdgeFallingBMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mEdgeFallingBMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(260);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDelayBinding
    public void setEdgeRisingAMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mEdgeRisingAMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(263);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDelayBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(2, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDelayBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDelayBinding
    public void setEdgeFallingAMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mEdgeFallingAMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(259);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDelayBinding
    public void setEdgeRisingBMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mEdgeRisingBMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(264);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDelayBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDelayBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeEdgeFallingBMapping((MappingObject) obj, i2);
            case 1:
                return onChangeEdgeRisingAMapping((MappingObject) obj, i2);
            case 2:
                return onChangeParam((TriggerParam) obj, i2);
            case 3:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 4:
                return onChangeEdgeFallingAMapping((MappingObject) obj, i2);
            case 5:
                return onChangeEdgeRisingBMapping((MappingObject) obj, i2);
            case 6:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 7:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 8:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerDelaySrcbParamDelayChanBValue1((MappingObject) obj, i2);
            case 9:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerDelaySrcaParamDelayChanAValue1((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeEdgeFallingBMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeEdgeRisingAMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 230) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 268) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 256) {
            synchronized (this) {
                this.mDirtyFlags |= 8404992;
            }
            return true;
        } else if (i == 232) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 231) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 229) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 233) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 234) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 267) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 672) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 673) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 377) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepAutoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeEdgeFallingAMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangeEdgeRisingBMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerDelaySrcbParamDelayChanBValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerDelaySrcaParamDelayChanAValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
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

    /* JADX WARN: Removed duplicated region for block: B:154:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02ee  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z9;
        int i5;
        int i6;
        Drawable drawable;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z10;
        String str8;
        boolean z11;
        boolean z12;
        boolean z13;
        Drawable drawable2;
        boolean z14;
        boolean z15;
        String str9;
        int i7;
        int i8;
        int i9;
        int i10;
        long j2;
        int i11;
        String str10;
        String str11;
        int i12;
        int i13;
        String str12;
        String str13;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        String str14;
        String str15;
        boolean z21;
        long j3;
        int i14;
        String str16;
        String str17;
        int i15;
        boolean z22;
        String str18;
        String str19;
        long j4;
        int i16;
        long j5;
        String str20;
        long j6;
        int i17;
        ServiceEnum.EMoreThan eMoreThan;
        ServiceEnum.EdgeSlope edgeSlope;
        ServiceEnum.EdgeSlope edgeSlope2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mEdgeFallingBMapping;
        MappingObject mappingObject2 = this.mEdgeRisingAMapping;
        TriggerParam triggerParam = this.mParam;
        MappingObject mappingObject3 = this.mEdgeFallingAMapping;
        MappingObject mappingObject4 = this.mEdgeRisingBMapping;
        String str21 = ((j & 1073742849) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        String str22 = ((j & 1073743874) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        int i18 = 0;
        if ((j & 1946153732) != 0) {
            if ((j & 1073807364) != 0) {
                str8 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(triggerParam != null ? triggerParam.getDelayLowerLimit() : 0L, ServiceEnum.Unit.Unit_s);
            } else {
                str8 = null;
            }
            int progressB = ((j & 1077936132) == 0 || triggerParam == null) ? 0 : triggerParam.getProgressB();
            if ((j & 1074798596) != 0) {
                if (triggerParam != null) {
                    edgeSlope = triggerParam.getEdgeSlopeA();
                    edgeSlope2 = triggerParam.getEdgeSlopeB();
                } else {
                    edgeSlope = null;
                    edgeSlope2 = null;
                }
                if ((j & 1074790404) != 0) {
                    z13 = edgeSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
                    z8 = edgeSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Falling;
                } else {
                    z13 = false;
                    z8 = false;
                }
                if ((j & 1073750020) != 0) {
                    z11 = edgeSlope2 == ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
                    z12 = edgeSlope2 == ServiceEnum.EdgeSlope.Trigger_Edge_Falling;
                } else {
                    z11 = false;
                    z12 = false;
                }
                drawable2 = ViewUtil.getTriggerDelayPic(edgeSlope, edgeSlope2);
            } else {
                z11 = false;
                z12 = false;
                z13 = false;
                z8 = false;
                drawable2 = null;
            }
            boolean isNoise = ((j & 1107296260) == 0 || triggerParam == null) ? false : triggerParam.getIsNoise();
            int i19 = ((j & 1073758212) > 0L ? 1 : ((j & 1073758212) == 0L ? 0 : -1));
            if (i19 != 0) {
                if (triggerParam != null) {
                    z15 = z12;
                    z14 = z11;
                    eMoreThan = triggerParam.getEMoreThan();
                } else {
                    z14 = z11;
                    z15 = z12;
                    eMoreThan = null;
                }
                str9 = str8;
                boolean z23 = eMoreThan == ServiceEnum.EMoreThan.Trigger_When_Lessthan;
                boolean z24 = eMoreThan == ServiceEnum.EMoreThan.Trigger_When_Morethan;
                if (i19 != 0) {
                    j |= z23 ? 4294967296L : 2147483648L;
                }
                if ((j & 1073758212) != 0) {
                    j |= z24 ? 17179869184L : 8589934592L;
                }
                i8 = z23 ? 4 : 0;
                i7 = z24 ? 4 : 0;
            } else {
                z14 = z11;
                z15 = z12;
                str9 = str8;
                i7 = 0;
                i8 = 0;
            }
            if ((j & 1610744324) != 0) {
                ServiceEnum.Chan delayChanA = triggerParam != null ? triggerParam.getDelayChanA() : null;
                i9 = i7;
                if (delayChanA != null) {
                    i17 = delayChanA.value1;
                    i10 = i8;
                } else {
                    i10 = i8;
                    i17 = 0;
                }
                MappingObject mappingObject5 = ViewUtil.getMappingObject(R.array.msg_trigger_delay_srca, i17);
                updateRegistration(9, mappingObject5);
                str10 = mappingObject5 != null ? mappingObject5.getStr() : null;
                j2 = 0;
                i11 = (j & 1073872900) != 0 ? ColorUtil.getColor(getRoot().getContext(), delayChanA) : 0;
            } else {
                i9 = i7;
                i10 = i8;
                j2 = 0;
                i11 = 0;
                str10 = null;
            }
            if ((j & 1090519044) != j2) {
                if (triggerParam != null) {
                    str20 = str10;
                    i12 = i11;
                    j6 = triggerParam.getHoldOff();
                } else {
                    str20 = str10;
                    i12 = i11;
                    j6 = 0;
                }
                str11 = str20;
                i13 = progressB;
                str12 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j6, ServiceEnum.Unit.Unit_s);
            } else {
                str11 = str10;
                i12 = i11;
                i13 = progressB;
                str12 = null;
            }
            if ((j & 1082130436) != 0) {
                ServiceEnum.EMoreThan eMoreThan2 = triggerParam != null ? triggerParam.getEMoreThan() : null;
                z17 = eMoreThan2 == ServiceEnum.EMoreThan.Trigger_When_UnMoreLess;
                str13 = str12;
                z18 = eMoreThan2 == ServiceEnum.EMoreThan.Trigger_When_Morethan;
                boolean z25 = eMoreThan2 == ServiceEnum.EMoreThan.Trigger_When_Lessthan;
                z19 = eMoreThan2 == ServiceEnum.EMoreThan.Trigger_When_MoreLess;
                z16 = z25;
            } else {
                str13 = str12;
                z16 = false;
                z17 = false;
                z18 = false;
                z19 = false;
            }
            if ((j & 1074003972) != 0) {
                if (triggerParam != null) {
                    z20 = z16;
                    j5 = triggerParam.getDelaylevelA();
                } else {
                    z20 = z16;
                    j5 = 0;
                }
                if (triggerParam != null) {
                    str14 = triggerParam.getTriggerLevelStr(j5);
                    if ((j & 1342181636) == 0) {
                        ServiceEnum.Chan delayChanB = triggerParam != null ? triggerParam.getDelayChanB() : null;
                        str15 = str14;
                        if (delayChanB != null) {
                            i16 = delayChanB.value1;
                            z21 = z17;
                        } else {
                            z21 = z17;
                            i16 = 0;
                        }
                        MappingObject mappingObject6 = ViewUtil.getMappingObject(R.array.msg_trigger_delay_srcb, i16);
                        updateRegistration(8, mappingObject6);
                        str16 = mappingObject6 != null ? mappingObject6.getStr() : null;
                        j3 = 0;
                        i14 = (j & 1073745924) != 0 ? ColorUtil.getColor(getRoot().getContext(), delayChanB) : 0;
                    } else {
                        str15 = str14;
                        z21 = z17;
                        j3 = 0;
                        i14 = 0;
                        str16 = null;
                    }
                    if ((j & 1073774596) == j3) {
                        if (triggerParam != null) {
                            str19 = str16;
                            i15 = i14;
                            j4 = triggerParam.getDelayUperLimit();
                        } else {
                            str19 = str16;
                            i15 = i14;
                            j4 = 0;
                        }
                        str17 = str19;
                        z22 = z18;
                        str18 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j4, ServiceEnum.Unit.Unit_s);
                    } else {
                        str17 = str16;
                        i15 = i14;
                        z22 = z18;
                        str18 = null;
                    }
                    if ((j & 1075838980) != 0 && triggerParam != null) {
                        i18 = triggerParam.getProgressA();
                    }
                    if ((j & 1074266116) != 0) {
                        long delaylevelB = triggerParam != null ? triggerParam.getDelaylevelB() : 0L;
                        if (triggerParam != null) {
                            String triggerLevelBStr = triggerParam.getTriggerLevelBStr(delaylevelB);
                            z9 = isNoise;
                            z5 = z13;
                            i3 = i18;
                            i2 = i9;
                            z3 = z14;
                            z4 = z15;
                            i = i10;
                            i5 = i12;
                            i4 = i13;
                            str3 = str11;
                            str5 = str15;
                            i6 = i15;
                            z7 = z22;
                            str = str18;
                            str4 = triggerLevelBStr;
                            drawable = drawable2;
                            z6 = z19;
                            str7 = str9;
                            str6 = str13;
                            z2 = z20;
                            z = z21;
                            str2 = str17;
                        }
                    }
                    z9 = isNoise;
                    z5 = z13;
                    i3 = i18;
                    i2 = i9;
                    z3 = z14;
                    z4 = z15;
                    i = i10;
                    i5 = i12;
                    i4 = i13;
                    str3 = str11;
                    z2 = z20;
                    str5 = str15;
                    i6 = i15;
                    z7 = z22;
                    str4 = null;
                    str = str18;
                    drawable = drawable2;
                    z6 = z19;
                    str7 = str9;
                    str6 = str13;
                    z = z21;
                    str2 = str17;
                }
            } else {
                z20 = z16;
            }
            str14 = null;
            if ((j & 1342181636) == 0) {
            }
            if ((j & 1073774596) == j3) {
            }
            if ((j & 1075838980) != 0) {
                i18 = triggerParam.getProgressA();
            }
            if ((j & 1074266116) != 0) {
            }
            z9 = isNoise;
            z5 = z13;
            i3 = i18;
            i2 = i9;
            z3 = z14;
            z4 = z15;
            i = i10;
            i5 = i12;
            i4 = i13;
            str3 = str11;
            z2 = z20;
            str5 = str15;
            i6 = i15;
            z7 = z22;
            str4 = null;
            str = str18;
            drawable = drawable2;
            z6 = z19;
            str7 = str9;
            str6 = str13;
            z = z21;
            str2 = str17;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
            z8 = false;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            z9 = false;
            i5 = 0;
            i6 = 0;
            drawable = null;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
        }
        int i20 = ((j & 1140850704) > 0L ? 1 : ((j & 1140850704) == 0L ? 0 : -1));
        String str23 = (i20 == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        int i21 = ((j & 1207959584) > 0L ? 1 : ((j & 1207959584) == 0L ? 0 : -1));
        String str24 = (i21 == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        if ((j & 1074790404) != 0) {
            z10 = z7;
            CompoundButtonBindingAdapter.setChecked(this.edgeAFalling, z8);
            CompoundButtonBindingAdapter.setChecked(this.edgeARising, z5);
        } else {
            z10 = z7;
        }
        if (i20 != 0) {
            TextViewBindingAdapter.setText(this.edgeAFalling, str23);
        }
        if ((j & 1073743874) != 0) {
            TextViewBindingAdapter.setText(this.edgeARising, str22);
        }
        if ((j & 1073750020) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.edgeBFalling, z4);
            CompoundButtonBindingAdapter.setChecked(this.edgeBRising, z3);
        }
        if ((1073742849 & j) != 0) {
            TextViewBindingAdapter.setText(this.edgeBFalling, str21);
        }
        if (i21 != 0) {
            TextViewBindingAdapter.setText(this.edgeBRising, str24);
        }
        if ((j & 1074798596) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.imageView2, drawable);
        }
        if ((j & 1082130436) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.lessMore, z6);
            CompoundButtonBindingAdapter.setChecked(this.lessThan, z2);
            CompoundButtonBindingAdapter.setChecked(this.moreLess, z);
            CompoundButtonBindingAdapter.setChecked(this.moreThan, z10);
        }
        if ((j & 1073758212) != 0) {
            int i22 = i;
            this.lowerLimit.setVisibility(i22);
            this.lowerLimitValue.setVisibility(i22);
            int i23 = i2;
            this.upperLimit.setVisibility(i23);
            this.upperLimitValue.setVisibility(i23);
        }
        if ((j & 1073807364) != 0) {
            TextViewBindingAdapter.setText(this.lowerLimitValue, str7);
        }
        if ((j & 1090519044) != 0) {
            TextViewBindingAdapter.setText(this.triggerHoldoff, str6);
        }
        if ((j & 1074003972) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelAValue, str5);
        }
        if ((j & 1075838980) != 0) {
            SeekBarBindingAdapter.setProgress(this.triggerLevelAView, i3);
        }
        if ((j & 1074266116) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelBValue, str4);
        }
        if ((j & 1077936132) != 0) {
            SeekBarBindingAdapter.setProgress(this.triggerLevelBView, i4);
        }
        if ((j & 1107296260) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerNoiseSwitch, z9);
        }
        if ((j & 1610744324) != 0) {
            TextViewBindingAdapter.setText(this.triggerSourceA, str3);
        }
        if ((j & 1073872900) != 0) {
            this.triggerSourceA.setTextColor(i5);
        }
        if ((j & 1342181636) != 0) {
            TextViewBindingAdapter.setText(this.triggerSourceB, str2);
        }
        if ((1073745924 & j) != 0) {
            this.triggerSourceB.setTextColor(i6);
        }
        if ((j & 1073774596) != 0) {
            TextViewBindingAdapter.setText(this.upperLimitValue, str);
        }
    }
}
