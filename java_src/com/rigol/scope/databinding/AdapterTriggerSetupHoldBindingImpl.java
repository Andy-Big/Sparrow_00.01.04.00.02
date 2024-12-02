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
public class AdapterTriggerSetupHoldBindingImpl extends AdapterTriggerSetupHoldBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 21);
        sViewsWithIds.put(R.id.guideline_center, 22);
        sViewsWithIds.put(R.id.guideline_right, 23);
        sViewsWithIds.put(R.id.guideline_forth, 24);
        sViewsWithIds.put(R.id.guideline_fifth, 25);
        sViewsWithIds.put(R.id.view_top, 26);
        sViewsWithIds.put(R.id.view_1, 27);
        sViewsWithIds.put(R.id.view_2, 28);
        sViewsWithIds.put(R.id.trigger_source_data_label, 29);
        sViewsWithIds.put(R.id.trigger_data_type_label, 30);
        sViewsWithIds.put(R.id.trigger_levelB, 31);
        sViewsWithIds.put(R.id.button_level, 32);
        sViewsWithIds.put(R.id.button_levelB, 33);
        sViewsWithIds.put(R.id.trigger_source_clock_label, 34);
        sViewsWithIds.put(R.id.trigger_edge_clock_label, 35);
        sViewsWithIds.put(R.id.setup_type_label, 36);
        sViewsWithIds.put(R.id.trigger_level, 37);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 38);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper3, 39);
        sViewsWithIds.put(R.id.trigger_holdoff_label, 40);
        sViewsWithIds.put(R.id.trigger_noise_label, 41);
        sViewsWithIds.put(R.id.view_line_1, 42);
        sViewsWithIds.put(R.id.view_line_2, 43);
    }

    public AdapterTriggerSetupHoldBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 44, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerSetupHoldBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 13, (Button) objArr[32], (Button) objArr[33], (RadioButton) objArr[2], (RadioButton) objArr[3], (RadioButton) objArr[9], (RadioButton) objArr[8], (Guideline) objArr[22], (Guideline) objArr[25], (Guideline) objArr[24], (Guideline) objArr[21], (Guideline) objArr[23], (RadioButton) objArr[17], (TextView) objArr[6], (EditText) objArr[7], (ImageView) objArr[13], (RadioButton) objArr[16], (RadioButton) objArr[18], (TextView) objArr[4], (TextView) objArr[36], (EditText) objArr[5], (TextView) objArr[30], (TextView) objArr[35], (EditText) objArr[19], (TextView) objArr[40], (TextView) objArr[37], (EditText) objArr[11], (VerticalSeekBar) objArr[14], (TextView) objArr[31], (EditText) objArr[12], (VerticalSeekBar) objArr[15], (TextView) objArr[41], (SwitchButton) objArr[20], (TextView) objArr[10], (TextView) objArr[34], (TextView) objArr[1], (TextView) objArr[29], (VerticalSeekBarWrapper) objArr[38], (VerticalSeekBarWrapper) objArr[39], (View) objArr[27], (View) objArr[28], (View) objArr[42], (View) objArr[43], (View) objArr[26]);
        this.mDirtyFlags = -1L;
        this.dataTypeH.setTag(null);
        this.dataTypeL.setTag(null);
        this.edgeClockFalling.setTag(null);
        this.edgeClockRising.setTag(null);
        this.hold.setTag(null);
        this.holdLabel.setTag(null);
        this.holdValue.setTag(null);
        this.imageView2.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.setup.setTag(null);
        this.setupHold.setTag(null);
        this.setupLabel.setTag(null);
        this.setupValue.setTag(null);
        this.triggerHoldoff.setTag(null);
        this.triggerLevelAValue.setTag(null);
        this.triggerLevelAView.setTag(null);
        this.triggerLevelBValue.setTag(null);
        this.triggerLevelBView.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSourceClock.setTag(null);
        this.triggerSourceData.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 68719476736L;
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
        } else if (1065 == i) {
            setWhenSetupHoldMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (850 == i) {
            setSlopeRisingMapping((MappingObject) obj);
        } else if (981 == i) {
            setTypeHMapping((MappingObject) obj);
        } else if (982 == i) {
            setTypeLMapping((MappingObject) obj);
        } else if (1066 == i) {
            setWhenSetupMapping((MappingObject) obj);
        } else if (1057 != i) {
            return false;
        } else {
            setWhenHoldMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(2, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setSlopeFallingMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mSlopeFallingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(848);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setWhenSetupHoldMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mWhenSetupHoldMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(1065);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setSlopeRisingMapping(MappingObject mappingObject) {
        updateRegistration(8, mappingObject);
        this.mSlopeRisingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(850);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setTypeHMapping(MappingObject mappingObject) {
        updateRegistration(9, mappingObject);
        this.mTypeHMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(981);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setTypeLMapping(MappingObject mappingObject) {
        updateRegistration(10, mappingObject);
        this.mTypeLMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(982);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setWhenSetupMapping(MappingObject mappingObject) {
        updateRegistration(11, mappingObject);
        this.mWhenSetupMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(1066);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setWhenHoldMapping(MappingObject mappingObject) {
        updateRegistration(12, mappingObject);
        this.mWhenHoldMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(1057);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSetupSdaParamSetupHoldChanBValue1((MappingObject) obj, i2);
            case 1:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSetupSclParamSetupHoldChanAValue1((MappingObject) obj, i2);
            case 2:
                return onChangeParam((TriggerParam) obj, i2);
            case 3:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 4:
                return onChangeSlopeFallingMapping((MappingObject) obj, i2);
            case 5:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 6:
                return onChangeWhenSetupHoldMapping((MappingObject) obj, i2);
            case 7:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 8:
                return onChangeSlopeRisingMapping((MappingObject) obj, i2);
            case 9:
                return onChangeTypeHMapping((MappingObject) obj, i2);
            case 10:
                return onChangeTypeLMapping((MappingObject) obj, i2);
            case 11:
                return onChangeWhenSetupMapping((MappingObject) obj, i2);
            case 12:
                return onChangeWhenHoldMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSetupSdaParamSetupHoldChanBValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSetupSclParamSetupHoldChanAValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 817) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 818) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 769) {
            synchronized (this) {
                this.mDirtyFlags |= 16908288;
            }
            return true;
        } else if (i == 813) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 376) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 819) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 816) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 820) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 821) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 672) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else if (i == 673) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else if (i == 377) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= 268435456;
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
                this.mDirtyFlags |= 536870912;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeWhenSetupHoldMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSlopeRisingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
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

    private boolean onChangeTypeHMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
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

    private boolean onChangeTypeLMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 8589934592L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeWhenSetupMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 17179869184L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeWhenHoldMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 34359738368L;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02ca A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c8  */
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
        String str7;
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i2;
        int i3;
        int i4;
        boolean z8;
        int i5;
        int i6;
        String str8;
        String str9;
        String str10;
        String str11;
        int i7;
        String str12;
        String str13;
        Drawable drawable2;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        Drawable drawable3;
        String str14;
        String str15;
        String str16;
        long j3;
        String str17;
        int i8;
        String str18;
        int i9;
        boolean z15;
        String str19;
        int i10;
        String str20;
        boolean z16;
        int i11;
        int i12;
        boolean z17;
        boolean z18;
        boolean z19;
        int i13;
        int i14;
        String str21;
        int i15;
        ServiceEnum.Chan chan;
        int i16;
        String str22;
        long j4;
        int i17;
        long j5;
        ServiceEnum.TriggerPulsePolarity triggerPulsePolarity;
        ServiceEnum.EdgeSlope edgeSlope;
        ServiceEnum.SHEvent sHEvent;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        TriggerParam triggerParam = this.mParam;
        MappingObject mappingObject = this.mSlopeFallingMapping;
        MappingObject mappingObject2 = this.mWhenSetupHoldMapping;
        MappingObject mappingObject3 = this.mSlopeRisingMapping;
        MappingObject mappingObject4 = this.mTypeHMapping;
        MappingObject mappingObject5 = this.mTypeLMapping;
        MappingObject mappingObject6 = this.mWhenSetupMapping;
        MappingObject mappingObject7 = this.mWhenHoldMapping;
        String str23 = null;
        if ((69256339463L & j) != 0) {
            if ((j & 68720001028L) != 0) {
                str9 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(triggerParam != null ? triggerParam.getHold() : 0L, ServiceEnum.Unit.Unit_s);
            } else {
                str9 = null;
            }
            int progressB = ((j & 68786585604L) == 0 || triggerParam == null) ? 0 : triggerParam.getProgressB();
            if ((j & 68723671044L) != 0) {
                long setupHoldlevelA = triggerParam != null ? triggerParam.getSetupHoldlevelA() : 0L;
                if (triggerParam != null) {
                    str10 = triggerParam.getTriggerLevelStr(setupHoldlevelA);
                    if ((j & 68719738884L) == 0) {
                        str11 = str9;
                        i7 = progressB;
                        str12 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(triggerParam != null ? triggerParam.getSetup() : 0L, ServiceEnum.Unit.Unit_s);
                    } else {
                        str11 = str9;
                        i7 = progressB;
                        str12 = null;
                    }
                    if ((j & 68737302532L) == 0) {
                        if (triggerParam != null) {
                            edgeSlope = triggerParam.getSetupHoldSlope();
                            sHEvent = triggerParam.getSHEvent();
                        } else {
                            edgeSlope = null;
                            sHEvent = null;
                        }
                        if ((j & 68720525316L) != 0) {
                            str13 = str12;
                            z10 = edgeSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Falling;
                            z9 = edgeSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
                        } else {
                            str13 = str12;
                            z9 = false;
                            z10 = false;
                        }
                        drawable2 = ViewUtil.getTriggerSetupHoldPic(edgeSlope, sHEvent);
                    } else {
                        str13 = str12;
                        drawable2 = null;
                        z9 = false;
                        z10 = false;
                    }
                    if ((j & 68719542276L) == 0) {
                        if (triggerParam != null) {
                            triggerPulsePolarity = triggerParam.getSetupHoldPolarity();
                            z11 = z9;
                        } else {
                            z11 = z9;
                            triggerPulsePolarity = null;
                        }
                        boolean z20 = triggerPulsePolarity == ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive;
                        z13 = triggerPulsePolarity == ServiceEnum.TriggerPulsePolarity.Trigger_pulse_negative;
                        z12 = z20;
                    } else {
                        z11 = z9;
                        z12 = false;
                        z13 = false;
                    }
                    boolean isNoise = ((j & 68987912196L) != 0 || triggerParam == null) ? false : triggerParam.getIsNoise();
                    if ((j & 68727865348L) == 0) {
                        if (triggerParam != null) {
                            z14 = z12;
                            drawable3 = drawable2;
                            j5 = triggerParam.getSetupHoldlevelB();
                        } else {
                            z14 = z12;
                            drawable3 = drawable2;
                            j5 = 0;
                        }
                        if (triggerParam != null) {
                            str14 = triggerParam.getTriggerLevelBStr(j5);
                            if ((j & 68719517701L) != 0) {
                                ServiceEnum.Chan setupHoldChanB = triggerParam != null ? triggerParam.getSetupHoldChanB() : null;
                                str15 = str14;
                                if (setupHoldChanB != null) {
                                    i17 = setupHoldChanB.value1;
                                    str16 = str10;
                                } else {
                                    str16 = str10;
                                    i17 = 0;
                                }
                                MappingObject mappingObject8 = ViewUtil.getMappingObject(R.array.msg_trigger_setup_sda, i17);
                                updateRegistration(0, mappingObject8);
                                str17 = mappingObject8 != null ? mappingObject8.getStr() : null;
                                j3 = 0;
                                if ((j & 68719509508L) != 0) {
                                    i8 = ColorUtil.getColor(getRoot().getContext(), setupHoldChanB);
                                    if ((j & 68853694468L) == j3) {
                                        if (triggerParam != null) {
                                            str22 = str17;
                                            i9 = i8;
                                            j4 = triggerParam.getHoldOff();
                                        } else {
                                            str22 = str17;
                                            i9 = i8;
                                            j4 = 0;
                                        }
                                        str18 = str22;
                                        z15 = z10;
                                        str19 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j4, ServiceEnum.Unit.Unit_s);
                                    } else {
                                        str18 = str17;
                                        i9 = i8;
                                        z15 = z10;
                                        str19 = null;
                                    }
                                    i10 = ((j & 68719607812L) > 0L ? 1 : ((j & 68719607812L) == 0L ? 0 : -1));
                                    if (i10 == 0) {
                                        ServiceEnum.SHEvent sHEvent2 = triggerParam != null ? triggerParam.getSHEvent() : null;
                                        str20 = str19;
                                        z17 = sHEvent2 == ServiceEnum.SHEvent.Trigger_SH_setup;
                                        z18 = sHEvent2 == ServiceEnum.SHEvent.Trigger_SH_setup_hold;
                                        z16 = sHEvent2 == ServiceEnum.SHEvent.Trigger_SH_hold;
                                        if (i10 != 0) {
                                            j |= z17 ? 1099511627776L : 549755813888L;
                                        }
                                        if ((j & 68719607812L) != 0) {
                                            j |= z16 ? 274877906944L : 137438953472L;
                                        }
                                        i11 = 4;
                                        i12 = z17 ? 4 : 0;
                                        if (!z16) {
                                            i11 = 0;
                                        }
                                    } else {
                                        str20 = str19;
                                        z16 = false;
                                        i11 = 0;
                                        i12 = 0;
                                        z17 = false;
                                        z18 = false;
                                    }
                                    if ((j & 68721590278L) == 0) {
                                        if (triggerParam != null) {
                                            z19 = z16;
                                            chan = triggerParam.getSetupHoldChanA();
                                        } else {
                                            z19 = z16;
                                            chan = null;
                                        }
                                        i13 = i11;
                                        if (chan != null) {
                                            i16 = chan.value1;
                                            i14 = i12;
                                        } else {
                                            i14 = i12;
                                            i16 = 0;
                                        }
                                        MappingObject mappingObject9 = ViewUtil.getMappingObject(R.array.msg_trigger_setup_scl, i16);
                                        updateRegistration(1, mappingObject9);
                                        str21 = mappingObject9 != null ? mappingObject9.getStr() : null;
                                        j2 = 0;
                                        if ((j & 68721573892L) != 0) {
                                            i15 = ColorUtil.getColor(getRoot().getContext(), chan);
                                            if ((j & 68753031172L) != j2 || triggerParam == null) {
                                                i5 = i15;
                                                z6 = z17;
                                                z4 = z13;
                                                i4 = i7;
                                                i6 = i9;
                                                z = z11;
                                                z8 = isNoise;
                                                drawable = drawable3;
                                                z3 = z14;
                                                str4 = str16;
                                                str = str18;
                                                z7 = z18;
                                                z5 = z19;
                                                i2 = i13;
                                                i = i14;
                                                i3 = 0;
                                            } else {
                                                i3 = triggerParam.getProgressA();
                                                i5 = i15;
                                                z6 = z17;
                                                z4 = z13;
                                                i4 = i7;
                                                i6 = i9;
                                                z = z11;
                                                z8 = isNoise;
                                                drawable = drawable3;
                                                z3 = z14;
                                                str4 = str16;
                                                str = str18;
                                                z7 = z18;
                                                z5 = z19;
                                                i2 = i13;
                                                i = i14;
                                            }
                                            str2 = str21;
                                            str7 = str11;
                                            str6 = str13;
                                            str3 = str15;
                                            z2 = z15;
                                            str5 = str20;
                                        }
                                    } else {
                                        z19 = z16;
                                        i13 = i11;
                                        i14 = i12;
                                        j2 = 0;
                                        str21 = null;
                                    }
                                    i15 = 0;
                                    if ((j & 68753031172L) != j2) {
                                    }
                                    i5 = i15;
                                    z6 = z17;
                                    z4 = z13;
                                    i4 = i7;
                                    i6 = i9;
                                    z = z11;
                                    z8 = isNoise;
                                    drawable = drawable3;
                                    z3 = z14;
                                    str4 = str16;
                                    str = str18;
                                    z7 = z18;
                                    z5 = z19;
                                    i2 = i13;
                                    i = i14;
                                    i3 = 0;
                                    str2 = str21;
                                    str7 = str11;
                                    str6 = str13;
                                    str3 = str15;
                                    z2 = z15;
                                    str5 = str20;
                                }
                            } else {
                                str15 = str14;
                                str16 = str10;
                                j3 = 0;
                                str17 = null;
                            }
                            i8 = 0;
                            if ((j & 68853694468L) == j3) {
                            }
                            i10 = ((j & 68719607812L) > 0L ? 1 : ((j & 68719607812L) == 0L ? 0 : -1));
                            if (i10 == 0) {
                            }
                            if ((j & 68721590278L) == 0) {
                            }
                            i15 = 0;
                            if ((j & 68753031172L) != j2) {
                            }
                            i5 = i15;
                            z6 = z17;
                            z4 = z13;
                            i4 = i7;
                            i6 = i9;
                            z = z11;
                            z8 = isNoise;
                            drawable = drawable3;
                            z3 = z14;
                            str4 = str16;
                            str = str18;
                            z7 = z18;
                            z5 = z19;
                            i2 = i13;
                            i = i14;
                            i3 = 0;
                            str2 = str21;
                            str7 = str11;
                            str6 = str13;
                            str3 = str15;
                            z2 = z15;
                            str5 = str20;
                        }
                    } else {
                        z14 = z12;
                        drawable3 = drawable2;
                    }
                    str14 = null;
                    if ((j & 68719517701L) != 0) {
                    }
                    i8 = 0;
                    if ((j & 68853694468L) == j3) {
                    }
                    i10 = ((j & 68719607812L) > 0L ? 1 : ((j & 68719607812L) == 0L ? 0 : -1));
                    if (i10 == 0) {
                    }
                    if ((j & 68721590278L) == 0) {
                    }
                    i15 = 0;
                    if ((j & 68753031172L) != j2) {
                    }
                    i5 = i15;
                    z6 = z17;
                    z4 = z13;
                    i4 = i7;
                    i6 = i9;
                    z = z11;
                    z8 = isNoise;
                    drawable = drawable3;
                    z3 = z14;
                    str4 = str16;
                    str = str18;
                    z7 = z18;
                    z5 = z19;
                    i2 = i13;
                    i = i14;
                    i3 = 0;
                    str2 = str21;
                    str7 = str11;
                    str6 = str13;
                    str3 = str15;
                    z2 = z15;
                    str5 = str20;
                }
            }
            str10 = null;
            if ((j & 68719738884L) == 0) {
            }
            if ((j & 68737302532L) == 0) {
            }
            if ((j & 68719542276L) == 0) {
            }
            if ((j & 68987912196L) != 0) {
            }
            if ((j & 68727865348L) == 0) {
            }
            str14 = null;
            if ((j & 68719517701L) != 0) {
            }
            i8 = 0;
            if ((j & 68853694468L) == j3) {
            }
            i10 = ((j & 68719607812L) > 0L ? 1 : ((j & 68719607812L) == 0L ? 0 : -1));
            if (i10 == 0) {
            }
            if ((j & 68721590278L) == 0) {
            }
            i15 = 0;
            if ((j & 68753031172L) != j2) {
            }
            i5 = i15;
            z6 = z17;
            z4 = z13;
            i4 = i7;
            i6 = i9;
            z = z11;
            z8 = isNoise;
            drawable = drawable3;
            z3 = z14;
            str4 = str16;
            str = str18;
            z7 = z18;
            z5 = z19;
            i2 = i13;
            i = i14;
            i3 = 0;
            str2 = str21;
            str7 = str11;
            str6 = str13;
            str3 = str15;
            z2 = z15;
            str5 = str20;
        } else {
            j2 = 0;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            drawable = null;
            str7 = null;
            z = false;
            i = 0;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            z8 = false;
            i5 = 0;
            i6 = 0;
        }
        int i18 = ((j & 69256347664L) > j2 ? 1 : ((j & 69256347664L) == j2 ? 0 : -1));
        String str24 = (i18 == 0 || mappingObject == null) ? null : mappingObject.getStr();
        int i19 = ((j & 69793218624L) > j2 ? 1 : ((j & 69793218624L) == j2 ? 0 : -1));
        String str25 = (i19 == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        int i20 = ((j & 70866960640L) > j2 ? 1 : ((j & 70866960640L) == j2 ? 0 : -1));
        String str26 = (i20 == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        int i21 = ((j & 73014444544L) > j2 ? 1 : ((j & 73014444544L) == j2 ? 0 : -1));
        String str27 = (i21 == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        int i22 = ((j & 77309412352L) > j2 ? 1 : ((j & 77309412352L) == j2 ? 0 : -1));
        String str28 = (i22 == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        int i23 = ((j & 85899347968L) > j2 ? 1 : ((j & 85899347968L) == j2 ? 0 : -1));
        String str29 = (i23 == 0 || mappingObject6 == null) ? null : mappingObject6.getStr();
        int i24 = ((j & 103079219200L) > j2 ? 1 : ((j & 103079219200L) == j2 ? 0 : -1));
        if (i24 != 0 && mappingObject7 != null) {
            str23 = mappingObject7.getStr();
        }
        String str30 = str23;
        if ((j & 68719542276L) != j2) {
            str8 = str25;
            CompoundButtonBindingAdapter.setChecked(this.dataTypeH, z3);
            CompoundButtonBindingAdapter.setChecked(this.dataTypeL, z4);
        } else {
            str8 = str25;
        }
        if (i21 != 0) {
            TextViewBindingAdapter.setText(this.dataTypeH, str27);
        }
        if (i22 != 0) {
            TextViewBindingAdapter.setText(this.dataTypeL, str28);
        }
        if ((j & 68720525316L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.edgeClockFalling, z2);
            CompoundButtonBindingAdapter.setChecked(this.edgeClockRising, z);
        }
        if (i18 != 0) {
            TextViewBindingAdapter.setText(this.edgeClockFalling, str24);
        }
        if (i20 != 0) {
            TextViewBindingAdapter.setText(this.edgeClockRising, str26);
        }
        if ((j & 68719607812L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.hold, z5);
            this.holdLabel.setVisibility(i);
            this.holdValue.setVisibility(i);
            CompoundButtonBindingAdapter.setChecked(this.setup, z6);
            CompoundButtonBindingAdapter.setChecked(this.setupHold, z7);
            int i25 = i2;
            this.setupLabel.setVisibility(i25);
            this.setupValue.setVisibility(i25);
        }
        if (i24 != 0) {
            TextViewBindingAdapter.setText(this.hold, str30);
        }
        if ((j & 68720001028L) != 0) {
            TextViewBindingAdapter.setText(this.holdValue, str7);
        }
        if ((j & 68737302532L) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.imageView2, drawable);
        }
        if (i23 != 0) {
            TextViewBindingAdapter.setText(this.setup, str29);
        }
        if (i19 != 0) {
            TextViewBindingAdapter.setText(this.setupHold, str8);
        }
        if ((j & 68719738884L) != 0) {
            TextViewBindingAdapter.setText(this.setupValue, str6);
        }
        if ((j & 68853694468L) != 0) {
            TextViewBindingAdapter.setText(this.triggerHoldoff, str5);
        }
        if ((j & 68723671044L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelAValue, str4);
        }
        if ((j & 68753031172L) != 0) {
            SeekBarBindingAdapter.setProgress(this.triggerLevelAView, i3);
        }
        if ((j & 68727865348L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelBValue, str3);
        }
        if ((j & 68786585604L) != 0) {
            SeekBarBindingAdapter.setProgress(this.triggerLevelBView, i4);
        }
        if ((j & 68987912196L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerNoiseSwitch, z8);
        }
        if ((j & 68721590278L) != 0) {
            TextViewBindingAdapter.setText(this.triggerSourceClock, str2);
        }
        if ((68721573892L & j) != 0) {
            this.triggerSourceClock.setTextColor(i5);
        }
        if ((j & 68719517701L) != 0) {
            TextViewBindingAdapter.setText(this.triggerSourceData, str);
        }
        if ((j & 68719509508L) != 0) {
            this.triggerSourceData.setTextColor(i6);
        }
    }
}
