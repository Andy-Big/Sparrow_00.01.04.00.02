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
public class AdapterTriggerOverBindingImpl extends AdapterTriggerOverBinding {
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
        sViewsWithIds.put(R.id.over_trigger_label, 29);
        sViewsWithIds.put(R.id.trigger_source_label, 30);
        sViewsWithIds.put(R.id.trigger_levelB, 31);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 32);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper3, 33);
        sViewsWithIds.put(R.id.trigger_holdoff_label, 34);
        sViewsWithIds.put(R.id.trigger_noise_label, 35);
        sViewsWithIds.put(R.id.view_line_1, 36);
        sViewsWithIds.put(R.id.view_line_2, 37);
        sViewsWithIds.put(R.id.trigger_over_edge_label, 38);
    }

    public AdapterTriggerOverBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 39, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerOverBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 12, (Button) objArr[8], (Button) objArr[9], (Guideline) objArr[23], (Guideline) objArr[26], (Guideline) objArr[25], (Guideline) objArr[22], (Guideline) objArr[24], (ImageView) objArr[14], (RadioButton) objArr[1], (RadioButton) objArr[2], (TextView) objArr[29], (RadioButton) objArr[3], (TextView) objArr[4], (EditText) objArr[5], (EditText) objArr[19], (TextView) objArr[34], (TextView) objArr[13], (EditText) objArr[10], (VerticalSeekBar) objArr[15], (TextView) objArr[31], (EditText) objArr[11], (VerticalSeekBar) objArr[16], (TextView) objArr[7], (CheckBox) objArr[12], (TextView) objArr[35], (SwitchButton) objArr[20], (RadioButton) objArr[18], (RadioButton) objArr[17], (TextView) objArr[38], (RadioButton) objArr[21], (TextView) objArr[6], (TextView) objArr[30], (VerticalSeekBarWrapper) objArr[32], (VerticalSeekBarWrapper) objArr[33], (View) objArr[28], (View) objArr[36], (View) objArr[37], (View) objArr[27]);
        this.mDirtyFlags = -1L;
        this.buttonLevel.setTag(null);
        this.buttonLevelB.setTag(null);
        this.imageView2.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.overTriggerEnter.setTag(null);
        this.overTriggerExit.setTag(null);
        this.overTriggerTime.setTag(null);
        this.overTriggerTimeLabel.setTag(null);
        this.overTriggerTimeValue.setTag(null);
        this.triggerHoldoff.setTag(null);
        this.triggerLevel.setTag(null);
        this.triggerLevelAValue.setTag(null);
        this.triggerLevelAView.setTag(null);
        this.triggerLevelBValue.setTag(null);
        this.triggerLevelBView.setTag(null);
        this.triggerLevelSelect.setTag(null);
        this.triggerLevelSelectAb.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerOverEdgeEither.setTag(null);
        this.triggerOverEdgeFalling.setTag(null);
        this.triggerOverEdgeRising.setTag(null);
        this.triggerSource.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2147483648L;
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
        if (648 == i) {
            setPositionExitMapping((MappingObject) obj);
        } else if (847 == i) {
            setSlopeEitherMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (848 == i) {
            setSlopeFallingMapping((MappingObject) obj);
        } else if (647 == i) {
            setPositionEnterMapping((MappingObject) obj);
        } else if (649 == i) {
            setPositionTimeMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (850 != i) {
            return false;
        } else {
            setSlopeRisingMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setPositionExitMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mPositionExitMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(648);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setSlopeEitherMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mSlopeEitherMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(847);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(2, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setSlopeFallingMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mSlopeFallingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(848);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setPositionEnterMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mPositionEnterMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(647);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setPositionTimeMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mPositionTimeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(649);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setSlopeRisingMapping(MappingObject mappingObject) {
        updateRegistration(11, mappingObject);
        this.mSlopeRisingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(850);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangePositionExitMapping((MappingObject) obj, i2);
            case 1:
                return onChangeSlopeEitherMapping((MappingObject) obj, i2);
            case 2:
                return onChangeParam((TriggerParam) obj, i2);
            case 3:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 4:
                return onChangeSlopeFallingMapping((MappingObject) obj, i2);
            case 5:
                return onChangePositionEnterMapping((MappingObject) obj, i2);
            case 6:
                return onChangePositionTimeMapping((MappingObject) obj, i2);
            case 7:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceParamChanValue1((MappingObject) obj, i2);
            case 8:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 9:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerLevelselectParamOverTriggerLevelIDValue1((MappingObject) obj, i2);
            case 10:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 11:
                return onChangeSlopeRisingMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangePositionExitMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeSlopeEitherMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 578) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 580) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 581) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 582) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 583) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 579) {
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
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
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

    private boolean onChangeSlopeFallingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangePositionEnterMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    private boolean onChangePositionTimeMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
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

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerLevelselectParamOverTriggerLevelIDValue1(MappingObject mappingObject, int i) {
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

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSlopeRisingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
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

    /* JADX WARN: Removed duplicated region for block: B:140:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x025c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x015f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01bd  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        long j2;
        String str;
        boolean z;
        String str2;
        Drawable drawable;
        String str3;
        boolean z2;
        int i;
        String str4;
        boolean z3;
        String str5;
        int i2;
        String str6;
        int i3;
        int i4;
        boolean z4;
        String str7;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        String str8;
        String str9;
        String str10;
        String str11;
        long j3;
        boolean z9;
        String str12;
        String str13;
        long j4;
        String str14;
        int i5;
        String str15;
        int i6;
        String str16;
        boolean z10;
        String str17;
        String str18;
        String str19;
        String str20;
        int i7;
        Drawable drawable2;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        ServiceEnum.EdgeSlope edgeSlope;
        ServiceEnum.OverEvent overEvent;
        boolean z16;
        long j5;
        int i8;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mPositionExitMapping;
        MappingObject mappingObject2 = this.mSlopeEitherMapping;
        TriggerParam triggerParam = this.mParam;
        MappingObject mappingObject3 = this.mSlopeFallingMapping;
        MappingObject mappingObject4 = this.mPositionEnterMapping;
        MappingObject mappingObject5 = this.mPositionTimeMapping;
        MappingObject mappingObject6 = this.mSlopeRisingMapping;
        String str21 = ((j & 2147487745L) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        String str22 = ((j & 2147491842L) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        if ((j & 2986328708L) != 0) {
            if ((j & 2148007940L) != 0) {
                long overlevelB = triggerParam != null ? triggerParam.getOverlevelB() : 0L;
                if (triggerParam != null) {
                    str10 = triggerParam.getTriggerLevelStr(overlevelB);
                    if ((j & 2147516420L) == 0) {
                        str11 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(triggerParam != null ? triggerParam.getOverTime() : 0L, ServiceEnum.Unit.Unit_s);
                    } else {
                        str11 = null;
                    }
                    int progressB = ((j & 2151677956L) != 0 || triggerParam == null) ? 0 : triggerParam.getProgressB();
                    if ((j & 2684486148L) == 0) {
                        ServiceEnum.Trigger_Level_ID overTrigger_Level_ID = triggerParam != null ? triggerParam.getOverTrigger_Level_ID() : null;
                        MappingObject mappingObject7 = ViewUtil.getMappingObject(R.array.msg_trigger_levelselect, overTrigger_Level_ID != null ? overTrigger_Level_ID.value1 : 0);
                        updateRegistration(9, mappingObject7);
                        str12 = mappingObject7 != null ? mappingObject7.getStr() : null;
                        j3 = 0;
                        z9 = (j & 2147614724L) != 0 && overTrigger_Level_ID == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double;
                    } else {
                        j3 = 0;
                        z9 = false;
                        str12 = null;
                    }
                    if ((j & 2415984772L) == j3) {
                        ServiceEnum.Chan chan = triggerParam != null ? triggerParam.getChan() : null;
                        str13 = str11;
                        if (chan != null) {
                            i8 = chan.value1;
                            i2 = progressB;
                        } else {
                            i2 = progressB;
                            i8 = 0;
                        }
                        MappingObject mappingObject8 = ViewUtil.getMappingObject(R.array.msg_trigger_source, i8);
                        updateRegistration(7, mappingObject8);
                        str14 = mappingObject8 != null ? mappingObject8.getStr() : null;
                        j4 = 0;
                        if ((j & 2147549188L) != 0) {
                            i5 = ColorUtil.getColor(getRoot().getContext(), chan);
                            boolean isNoise = ((j & 2164260868L) != j4 || triggerParam == null) ? false : triggerParam.getIsNoise();
                            if ((j & 2155872260L) != j4) {
                                if (triggerParam != null) {
                                    str15 = str14;
                                    i6 = i5;
                                    j5 = triggerParam.getHoldOff();
                                } else {
                                    str15 = str14;
                                    i6 = i5;
                                    j5 = 0;
                                }
                                str16 = str10;
                                z10 = z9;
                                str17 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j5, ServiceEnum.Unit.Unit_s);
                            } else {
                                str15 = str14;
                                i6 = i5;
                                str16 = str10;
                                z10 = z9;
                                str17 = null;
                            }
                            if ((j & 2147745796L) != 0) {
                                long overlevelA = triggerParam != null ? triggerParam.getOverlevelA() : 0L;
                                if (triggerParam != null) {
                                    str18 = triggerParam.getTriggerLevelStr(overlevelA);
                                    if ((j & 2148548612L) == 0) {
                                        if (triggerParam != null) {
                                            edgeSlope = triggerParam.getOverSlope();
                                            overEvent = triggerParam.getOverEvent();
                                        } else {
                                            edgeSlope = null;
                                            overEvent = null;
                                        }
                                        if ((j & 2148532228L) != 0) {
                                            str19 = str17;
                                            boolean z17 = edgeSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Falling;
                                            z13 = edgeSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
                                            boolean z18 = z17;
                                            z12 = edgeSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Any;
                                            z16 = z18;
                                        } else {
                                            str19 = str17;
                                            z16 = false;
                                            z12 = false;
                                            z13 = false;
                                        }
                                        int i9 = ((j & 2147500036L) > 0L ? 1 : ((j & 2147500036L) == 0L ? 0 : -1));
                                        z14 = z16;
                                        if (i9 != 0) {
                                            str20 = str18;
                                            z = overEvent == ServiceEnum.OverEvent.Trigger_over_time;
                                            z15 = overEvent == ServiceEnum.OverEvent.Trigger_over_exit;
                                            z11 = overEvent == ServiceEnum.OverEvent.Trigger_over_enter;
                                            if (i9 != 0) {
                                                j |= z ? 8589934592L : 4294967296L;
                                            }
                                            i7 = z ? 0 : 8;
                                        } else {
                                            str20 = str18;
                                            z = false;
                                            i7 = 0;
                                            z11 = false;
                                            z15 = false;
                                        }
                                        drawable2 = ViewUtil.getTriggerOverPic(edgeSlope, overEvent);
                                    } else {
                                        str19 = str17;
                                        str20 = str18;
                                        z = false;
                                        i7 = 0;
                                        drawable2 = null;
                                        z11 = false;
                                        z12 = false;
                                        z13 = false;
                                        z14 = false;
                                        z15 = false;
                                    }
                                    j2 = 0;
                                    if ((j & 2149580804L) != 0 || triggerParam == null) {
                                        i = i7;
                                        str7 = str12;
                                        z5 = isNoise;
                                        z3 = z11;
                                        str2 = str13;
                                        str5 = str15;
                                        i4 = i6;
                                        z4 = z10;
                                        str6 = str16;
                                        str3 = str19;
                                        z6 = z12;
                                        z7 = z13;
                                        z8 = z14;
                                        str4 = str20;
                                        i3 = 0;
                                        str = str22;
                                        drawable = drawable2;
                                    } else {
                                        i = i7;
                                        str7 = str12;
                                        z5 = isNoise;
                                        z3 = z11;
                                        str2 = str13;
                                        str5 = str15;
                                        i4 = i6;
                                        z4 = z10;
                                        str6 = str16;
                                        z6 = z12;
                                        z7 = z13;
                                        z8 = z14;
                                        str4 = str20;
                                        str = str22;
                                        i3 = triggerParam.getProgressA();
                                        drawable = drawable2;
                                        str3 = str19;
                                    }
                                    z2 = z15;
                                }
                            }
                            str18 = null;
                            if ((j & 2148548612L) == 0) {
                            }
                            j2 = 0;
                            if ((j & 2149580804L) != 0) {
                            }
                            i = i7;
                            str7 = str12;
                            z5 = isNoise;
                            z3 = z11;
                            str2 = str13;
                            str5 = str15;
                            i4 = i6;
                            z4 = z10;
                            str6 = str16;
                            str3 = str19;
                            z6 = z12;
                            z7 = z13;
                            z8 = z14;
                            str4 = str20;
                            i3 = 0;
                            str = str22;
                            drawable = drawable2;
                            z2 = z15;
                        }
                    } else {
                        str13 = str11;
                        i2 = progressB;
                        j4 = 0;
                        str14 = null;
                    }
                    i5 = 0;
                    if ((j & 2164260868L) != j4) {
                    }
                    if ((j & 2155872260L) != j4) {
                    }
                    if ((j & 2147745796L) != 0) {
                    }
                    str18 = null;
                    if ((j & 2148548612L) == 0) {
                    }
                    j2 = 0;
                    if ((j & 2149580804L) != 0) {
                    }
                    i = i7;
                    str7 = str12;
                    z5 = isNoise;
                    z3 = z11;
                    str2 = str13;
                    str5 = str15;
                    i4 = i6;
                    z4 = z10;
                    str6 = str16;
                    str3 = str19;
                    z6 = z12;
                    z7 = z13;
                    z8 = z14;
                    str4 = str20;
                    i3 = 0;
                    str = str22;
                    drawable = drawable2;
                    z2 = z15;
                }
            }
            str10 = null;
            if ((j & 2147516420L) == 0) {
            }
            if ((j & 2151677956L) != 0) {
            }
            if ((j & 2684486148L) == 0) {
            }
            if ((j & 2415984772L) == j3) {
            }
            i5 = 0;
            if ((j & 2164260868L) != j4) {
            }
            if ((j & 2155872260L) != j4) {
            }
            if ((j & 2147745796L) != 0) {
            }
            str18 = null;
            if ((j & 2148548612L) == 0) {
            }
            j2 = 0;
            if ((j & 2149580804L) != 0) {
            }
            i = i7;
            str7 = str12;
            z5 = isNoise;
            z3 = z11;
            str2 = str13;
            str5 = str15;
            i4 = i6;
            z4 = z10;
            str6 = str16;
            str3 = str19;
            z6 = z12;
            z7 = z13;
            z8 = z14;
            str4 = str20;
            i3 = 0;
            str = str22;
            drawable = drawable2;
            z2 = z15;
        } else {
            j2 = 0;
            str = str22;
            z = false;
            str2 = null;
            drawable = null;
            str3 = null;
            z2 = false;
            i = 0;
            str4 = null;
            z3 = false;
            str5 = null;
            i2 = 0;
            str6 = null;
            i3 = 0;
            i4 = 0;
            z4 = false;
            str7 = null;
            z5 = false;
            z6 = false;
            z7 = false;
            z8 = false;
        }
        int i10 = ((j & 2181038096L) > j2 ? 1 : ((j & 2181038096L) == j2 ? 0 : -1));
        String str23 = (i10 == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        int i11 = ((j & 2214592544L) > j2 ? 1 : ((j & 2214592544L) == j2 ? 0 : -1));
        String str24 = (i11 == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        int i12 = ((j & 2281701440L) > j2 ? 1 : ((j & 2281701440L) == j2 ? 0 : -1));
        String str25 = (i12 == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        int i13 = ((j & 3221227520L) > j2 ? 1 : ((j & 3221227520L) == j2 ? 0 : -1));
        String str26 = (i13 == 0 || mappingObject6 == null) ? null : mappingObject6.getStr();
        if ((j & 2147483648L) != j2) {
            str9 = str26;
            str8 = str23;
            this.buttonLevel.setVisibility(0);
            this.buttonLevelB.setVisibility(0);
            this.triggerLevel.setVisibility(0);
            this.triggerLevelAValue.setVisibility(0);
            this.triggerLevelAView.setVisibility(0);
            this.triggerLevelBValue.setVisibility(0);
            this.triggerLevelBView.setVisibility(0);
        } else {
            str8 = str23;
            str9 = str26;
        }
        if ((j & 2148548612L) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.imageView2, drawable);
        }
        if ((j & 2147500036L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.overTriggerEnter, z3);
            CompoundButtonBindingAdapter.setChecked(this.overTriggerExit, z2);
            CompoundButtonBindingAdapter.setChecked(this.overTriggerTime, z);
            this.overTriggerTimeLabel.setVisibility(i);
            this.overTriggerTimeValue.setVisibility(i);
        }
        if (i11 != 0) {
            TextViewBindingAdapter.setText(this.overTriggerEnter, str24);
        }
        if ((2147487745L & j) != 0) {
            TextViewBindingAdapter.setText(this.overTriggerExit, str21);
        }
        if (i12 != 0) {
            TextViewBindingAdapter.setText(this.overTriggerTime, str25);
        }
        if ((j & 2147516420L) != 0) {
            TextViewBindingAdapter.setText(this.overTriggerTimeValue, str2);
        }
        if ((j & 2155872260L) != 0) {
            TextViewBindingAdapter.setText(this.triggerHoldoff, str3);
        }
        if ((j & 2147745796L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelAValue, str4);
        }
        if ((j & 2149580804L) != 0) {
            SeekBarBindingAdapter.setProgress(this.triggerLevelAView, i3);
        }
        if ((j & 2148007940L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelBValue, str6);
        }
        if ((j & 2151677956L) != 0) {
            SeekBarBindingAdapter.setProgress(this.triggerLevelBView, i2);
        }
        if ((j & 2684486148L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelSelect, str7);
        }
        if ((j & 2147614724L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerLevelSelectAb, z4);
        }
        if ((j & 2164260868L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerNoiseSwitch, z5);
        }
        if ((j & 2148532228L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerOverEdgeEither, z6);
            CompoundButtonBindingAdapter.setChecked(this.triggerOverEdgeFalling, z8);
            CompoundButtonBindingAdapter.setChecked(this.triggerOverEdgeRising, z7);
        }
        if ((j & 2147491842L) != 0) {
            TextViewBindingAdapter.setText(this.triggerOverEdgeEither, str);
        }
        if (i10 != 0) {
            TextViewBindingAdapter.setText(this.triggerOverEdgeFalling, str8);
        }
        if (i13 != 0) {
            TextViewBindingAdapter.setText(this.triggerOverEdgeRising, str9);
        }
        if ((j & 2415984772L) != 0) {
            TextViewBindingAdapter.setText(this.triggerSource, str5);
        }
        if ((j & 2147549188L) != 0) {
            this.triggerSource.setTextColor(i4);
        }
    }
}
