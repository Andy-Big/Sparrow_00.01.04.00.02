package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;

/* loaded from: classes2.dex */
public class AdapterTriggerSpiBindingImpl extends AdapterTriggerSpiBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 25);
        sViewsWithIds.put(R.id.guideline_center, 26);
        sViewsWithIds.put(R.id.guideline_right, 27);
        sViewsWithIds.put(R.id.guideline_forth, 28);
        sViewsWithIds.put(R.id.guideline_fifth, 29);
        sViewsWithIds.put(R.id.view_top, 30);
        sViewsWithIds.put(R.id.view_trigger_condition, 31);
        sViewsWithIds.put(R.id.view_hide_data, 32);
        sViewsWithIds.put(R.id.trigger_spi_databits_label, 33);
        sViewsWithIds.put(R.id.trigger_spi_data_label, 34);
        sViewsWithIds.put(R.id.button_levelb, 35);
        sViewsWithIds.put(R.id.trigger_levelb, 36);
        sViewsWithIds.put(R.id.trigger_level, 37);
        sViewsWithIds.put(R.id.trigger_source_scl_label, 38);
        sViewsWithIds.put(R.id.trigger_source_sda_label, 39);
        sViewsWithIds.put(R.id.edge_type_label, 40);
        sViewsWithIds.put(R.id.button_level, 41);
        sViewsWithIds.put(R.id.trigger_noise_label, 42);
        sViewsWithIds.put(R.id.view2, 43);
        sViewsWithIds.put(R.id.view16, 44);
    }

    public AdapterTriggerSpiBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 45, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerSpiBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 13, (Button) objArr[41], (Button) objArr[35], (Button) objArr[13], (RadioButton) objArr[23], (RadioButton) objArr[22], (TextView) objArr[40], (Guideline) objArr[26], (Guideline) objArr[29], (Guideline) objArr[28], (Guideline) objArr[25], (Guideline) objArr[27], (TextView) objArr[12], (TextView) objArr[37], (EditText) objArr[20], (TextView) objArr[36], (EditText) objArr[18], (TextView) objArr[15], (EditText) objArr[14], (TextView) objArr[42], (SwitchButton) objArr[24], (TextView) objArr[16], (TextView) objArr[17], (TextView) objArr[21], (TextView) objArr[38], (TextView) objArr[19], (TextView) objArr[39], (TextView) objArr[7], (RadioButton) objArr[5], (RadioButton) objArr[6], (TextView) objArr[34], (EditText) objArr[9], (TextView) objArr[33], (EditText) objArr[4], (RadioButton) objArr[11], (TextView) objArr[8], (EditText) objArr[3], (RadioButton) objArr[10], (View) objArr[44], (View) objArr[43], (View) objArr[32], (View) objArr[1], (View) objArr[2], (View) objArr[30], (View) objArr[31]);
        this.mDirtyFlags = -1L;
        this.buttonLevelc.setTag(null);
        this.edgeFalling.setTag(null);
        this.edgeRising.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.triggerLabel.setTag(null);
        this.triggerLevelValue.setTag(null);
        this.triggerLevelbValue.setTag(null);
        this.triggerLevelc.setTag(null);
        this.triggerLevelcValue.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSourceCs.setTag(null);
        this.triggerSourceCsLabel.setTag(null);
        this.triggerSourceScl.setTag(null);
        this.triggerSourceSda.setTag(null);
        this.triggerSpiCsMode.setTag(null);
        this.triggerSpiCsModeN.setTag(null);
        this.triggerSpiCsModeP.setTag(null);
        this.triggerSpiDataValue.setTag(null);
        this.triggerSpiDatabitsValue.setTag(null);
        this.triggerSpiTimeout.setTag(null);
        this.triggerSpiTimeoutLabel.setTag(null);
        this.triggerSpiTimeoutValue.setTag(null);
        this.triggerSpiWithCs.setTag(null);
        this.viewHideModel.setTag(null);
        this.viewHideTimeout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 34359738368L;
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
        if (1072 == i) {
            setWhenTimeoutMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (1052 == i) {
            setWhenCsMapping((MappingObject) obj);
        } else if (265 == i) {
            setEdgeRisingMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (547 == i) {
            setModePositiveMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (261 == i) {
            setEdgeFallingMapping((MappingObject) obj);
        } else if (546 != i) {
            return false;
        } else {
            setModeNegativeMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSpiBinding
    public void setWhenTimeoutMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mWhenTimeoutMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1072);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSpiBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(2, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSpiBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSpiBinding
    public void setWhenCsMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mWhenCsMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(1052);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSpiBinding
    public void setEdgeRisingMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mEdgeRisingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(265);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSpiBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSpiBinding
    public void setModePositiveMapping(MappingObject mappingObject) {
        updateRegistration(7, mappingObject);
        this.mModePositiveMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(547);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSpiBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSpiBinding
    public void setEdgeFallingMapping(MappingObject mappingObject) {
        updateRegistration(11, mappingObject);
        this.mEdgeFallingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(261);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSpiBinding
    public void setModeNegativeMapping(MappingObject mappingObject) {
        updateRegistration(12, mappingObject);
        this.mModeNegativeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(546);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeWhenTimeoutMapping((MappingObject) obj, i2);
            case 1:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSpiSclParamSpiChanAValue1((MappingObject) obj, i2);
            case 2:
                return onChangeParam((TriggerParam) obj, i2);
            case 3:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 4:
                return onChangeWhenCsMapping((MappingObject) obj, i2);
            case 5:
                return onChangeEdgeRisingMapping((MappingObject) obj, i2);
            case 6:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 7:
                return onChangeModePositiveMapping((MappingObject) obj, i2);
            case 8:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 9:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSpiCsParamSpiChanCValue1((MappingObject) obj, i2);
            case 10:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSpiSdaParamSpiChanBValue1((MappingObject) obj, i2);
            case 11:
                return onChangeEdgeFallingMapping((MappingObject) obj, i2);
            case 12:
                return onChangeModeNegativeMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeWhenTimeoutMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSpiSclParamSpiChanAValue1(MappingObject mappingObject, int i) {
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
        } else if (i == 976) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 877) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 216) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 680) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 336) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 895) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 874) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 894) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 873) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 893) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 872) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else if (i == 876) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
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

    private boolean onChangeWhenCsMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangeEdgeRisingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeModePositiveMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
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
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSpiCsParamSpiChanCValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSpiSdaParamSpiChanBValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
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

    private boolean onChangeEdgeFallingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
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

    private boolean onChangeModeNegativeMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
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

    /* JADX WARN: Removed duplicated region for block: B:104:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01e3  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        boolean z;
        float f;
        boolean z2;
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
        int i;
        int i2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i3;
        int i4;
        int i5;
        boolean z7;
        boolean z8;
        boolean z9;
        String str11;
        String str12;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        long j2;
        String str13;
        int i6;
        boolean z14;
        String str14;
        String str15;
        int i7;
        String str16;
        int i8;
        String str17;
        String str18;
        String str19;
        int i9;
        boolean z15;
        boolean z16;
        boolean z17;
        String str20;
        String str21;
        long j3;
        String str22;
        int i10;
        int i11;
        String str23;
        boolean z18;
        String str24;
        String str25;
        int i12;
        long j4;
        ServiceEnum.Chan chan;
        int i13;
        ServiceEnum.EdgeSlope edgeSlope;
        long j5;
        int i14;
        int i15;
        int i16;
        long j6;
        ServiceEnum.Chan chan2;
        int i17;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mWhenTimeoutMapping;
        TriggerParam triggerParam = this.mParam;
        MappingObject mappingObject2 = this.mWhenCsMapping;
        MappingObject mappingObject3 = this.mEdgeRisingMapping;
        MappingObject mappingObject4 = this.mModePositiveMapping;
        MappingObject mappingObject5 = this.mEdgeFallingMapping;
        MappingObject mappingObject6 = this.mModeNegativeMapping;
        if ((j & 34359738368L) != 0) {
            z = ViewUtil.serialize != ServiceEnum.ProductSeries.SERIES_1000.value1;
            f = ContextUtil.getAlpha(z);
        } else {
            z = false;
            f = 0.0f;
        }
        String str26 = null;
        String str27 = ((j & 34359746561L) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        if ((j & 41070609926L) != 0) {
            if ((j & 34359869444L) != 0) {
                z2 = z;
                str12 = UnitFormat.newBuilder(" # ", UnitFormat.SI.NONE).convert(triggerParam != null ? triggerParam.getDataBits() : 0, ServiceEnum.Unit.Unit_none);
            } else {
                z2 = z;
                str12 = null;
            }
            if ((j & 34360000516L) != 0) {
                ServiceEnum.TriggerPulsePolarity pulsePolarity = triggerParam != null ? triggerParam.getPulsePolarity() : null;
                z11 = pulsePolarity == ServiceEnum.TriggerPulsePolarity.Trigger_pulse_negative;
                z10 = pulsePolarity == ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive;
            } else {
                z10 = false;
                z11 = false;
            }
            String formatValue2Str = ((j & 34360262660L) == 0 || triggerParam == null) ? null : triggerParam.getFormatValue2Str();
            if ((j & 34393309190L) != 0) {
                if (triggerParam != null) {
                    str2 = str12;
                    chan2 = triggerParam.getSpiChanA();
                } else {
                    str2 = str12;
                    chan2 = null;
                }
                z12 = z10;
                if (chan2 != null) {
                    i17 = chan2.value1;
                    z13 = z11;
                } else {
                    z13 = z11;
                    i17 = 0;
                }
                MappingObject mappingObject7 = ViewUtil.getMappingObject(R.array.msg_trigger_spi_scl, i17);
                updateRegistration(1, mappingObject7);
                str13 = mappingObject7 != null ? mappingObject7.getStr() : null;
                j2 = 0;
                if ((j & 34393292804L) != 0) {
                    i6 = ColorUtil.getColor(getRoot().getContext(), chan2);
                    boolean isNoise = ((j & 34493956100L) != j2 || triggerParam == null) ? false : triggerParam.getIsNoise();
                    if ((j & 34376515588L) == j2) {
                        if (triggerParam != null) {
                            str14 = formatValue2Str;
                            z14 = isNoise;
                            j6 = triggerParam.getSpilevelA();
                        } else {
                            z14 = isNoise;
                            str14 = formatValue2Str;
                            j6 = 0;
                        }
                        if (triggerParam != null) {
                            str15 = triggerParam.getTriggerLevelStr(j6);
                            if ((j & 38663095300L) != 0) {
                                ServiceEnum.Chan spiChanB = triggerParam != null ? triggerParam.getSpiChanB() : null;
                                if ((j & 34368126980L) != 0) {
                                    i7 = i6;
                                    i14 = ColorUtil.getColor(getRoot().getContext(), spiChanB);
                                } else {
                                    i7 = i6;
                                    i14 = 0;
                                }
                                if (spiChanB != null) {
                                    i16 = spiChanB.value1;
                                    i15 = i14;
                                } else {
                                    i15 = i14;
                                    i16 = 0;
                                }
                                MappingObject mappingObject8 = ViewUtil.getMappingObject(R.array.msg_trigger_spi_sda, i16);
                                updateRegistration(10, mappingObject8);
                                str16 = mappingObject8 != null ? mappingObject8.getStr() : null;
                                i8 = i15;
                            } else {
                                i7 = i6;
                                str16 = null;
                                i8 = 0;
                            }
                            if ((j & 34363932676L) != 0) {
                                if (triggerParam != null) {
                                    str17 = str15;
                                    str18 = str16;
                                    j5 = triggerParam.getSpilevelB();
                                } else {
                                    str17 = str15;
                                    str18 = str16;
                                    j5 = 0;
                                }
                                if (triggerParam != null) {
                                    str19 = triggerParam.getTriggerLevelBStr(j5);
                                    if ((j & 34426847236L) == 0) {
                                        if (triggerParam != null) {
                                            edgeSlope = triggerParam.getSpiSlope();
                                            i9 = i8;
                                        } else {
                                            i9 = i8;
                                            edgeSlope = null;
                                        }
                                        boolean z19 = edgeSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Falling;
                                        z16 = edgeSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
                                        z15 = z19;
                                    } else {
                                        i9 = i8;
                                        z15 = false;
                                        z16 = false;
                                    }
                                    if ((j & 36509319684L) == 0) {
                                        if (triggerParam != null) {
                                            z17 = z15;
                                            chan = triggerParam.getSpiChanC();
                                        } else {
                                            z17 = z15;
                                            chan = null;
                                        }
                                        str20 = str13;
                                        if (chan != null) {
                                            i13 = chan.value1;
                                            str21 = str19;
                                        } else {
                                            str21 = str19;
                                            i13 = 0;
                                        }
                                        MappingObject mappingObject9 = ViewUtil.getMappingObject(R.array.msg_trigger_spi_cs, i13);
                                        updateRegistration(9, mappingObject9);
                                        str22 = mappingObject9 != null ? mappingObject9.getStr() : null;
                                        j3 = 0;
                                        if ((j & 34361835524L) != 0) {
                                            i10 = ColorUtil.getColor(getRoot().getContext(), chan);
                                            if ((j & 34359803908L) != j3) {
                                                if (triggerParam != null) {
                                                    z18 = z16;
                                                    j4 = triggerParam.getSpiTimeOut();
                                                } else {
                                                    z18 = z16;
                                                    j4 = 0;
                                                }
                                                i11 = i10;
                                                str23 = str22;
                                                str24 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j4, ServiceEnum.Unit.Unit_s);
                                            } else {
                                                i11 = i10;
                                                str23 = str22;
                                                z18 = z16;
                                                str24 = null;
                                            }
                                            if ((j & 34360786948L) != 0) {
                                                long spilevelC = triggerParam != null ? triggerParam.getSpilevelC() : 0L;
                                                if (triggerParam != null) {
                                                    str25 = triggerParam.getTriggerLevelCStr(spilevelC);
                                                    i12 = ((j & 34359771140L) > 0L ? 1 : ((j & 34359771140L) == 0L ? 0 : -1));
                                                    if (i12 == 0) {
                                                        ServiceEnum.Trigger_Spi_CS trigger_Spi_CS = triggerParam != null ? triggerParam.getTrigger_Spi_CS() : null;
                                                        String str28 = str24;
                                                        z6 = trigger_Spi_CS == ServiceEnum.Trigger_Spi_CS.trig_spi_cs;
                                                        boolean z20 = trigger_Spi_CS == ServiceEnum.Trigger_Spi_CS.trig_spi_idle;
                                                        if (i12 != 0) {
                                                            j |= z6 ? 137438953472L : 68719476736L;
                                                        }
                                                        if ((j & 34359771140L) != 0) {
                                                            j |= z20 ? 549755813888L : 274877906944L;
                                                        }
                                                        i2 = z6 ? 0 : 8;
                                                        str10 = str14;
                                                        z7 = z12;
                                                        z9 = z13;
                                                        z8 = z14;
                                                        i4 = i7;
                                                        str9 = str18;
                                                        i3 = i9;
                                                        str8 = str20;
                                                        str5 = str21;
                                                        z5 = z18;
                                                        str3 = str23;
                                                        str7 = str28;
                                                        str = str27;
                                                        i = z20 ? 0 : 8;
                                                        str6 = str17;
                                                        z3 = z17;
                                                        str4 = str25;
                                                        z4 = z20;
                                                        i5 = i11;
                                                    } else {
                                                        str10 = str14;
                                                        z7 = z12;
                                                        z9 = z13;
                                                        z8 = z14;
                                                        i4 = i7;
                                                        str9 = str18;
                                                        i3 = i9;
                                                        z3 = z17;
                                                        str8 = str20;
                                                        str5 = str21;
                                                        z5 = z18;
                                                        str3 = str23;
                                                        i5 = i11;
                                                        str7 = str24;
                                                        i2 = 0;
                                                        z6 = false;
                                                        str = str27;
                                                        str6 = str17;
                                                        i = 0;
                                                        str4 = str25;
                                                        z4 = false;
                                                    }
                                                }
                                            }
                                            str25 = null;
                                            i12 = ((j & 34359771140L) > 0L ? 1 : ((j & 34359771140L) == 0L ? 0 : -1));
                                            if (i12 == 0) {
                                            }
                                        }
                                    } else {
                                        z17 = z15;
                                        str20 = str13;
                                        str21 = str19;
                                        j3 = 0;
                                        str22 = null;
                                    }
                                    i10 = 0;
                                    if ((j & 34359803908L) != j3) {
                                    }
                                    if ((j & 34360786948L) != 0) {
                                    }
                                    str25 = null;
                                    i12 = ((j & 34359771140L) > 0L ? 1 : ((j & 34359771140L) == 0L ? 0 : -1));
                                    if (i12 == 0) {
                                    }
                                }
                            } else {
                                str17 = str15;
                                str18 = str16;
                            }
                            str19 = null;
                            if ((j & 34426847236L) == 0) {
                            }
                            if ((j & 36509319684L) == 0) {
                            }
                            i10 = 0;
                            if ((j & 34359803908L) != j3) {
                            }
                            if ((j & 34360786948L) != 0) {
                            }
                            str25 = null;
                            i12 = ((j & 34359771140L) > 0L ? 1 : ((j & 34359771140L) == 0L ? 0 : -1));
                            if (i12 == 0) {
                            }
                        }
                    } else {
                        z14 = isNoise;
                        str14 = formatValue2Str;
                    }
                    str15 = null;
                    if ((j & 38663095300L) != 0) {
                    }
                    if ((j & 34363932676L) != 0) {
                    }
                    str19 = null;
                    if ((j & 34426847236L) == 0) {
                    }
                    if ((j & 36509319684L) == 0) {
                    }
                    i10 = 0;
                    if ((j & 34359803908L) != j3) {
                    }
                    if ((j & 34360786948L) != 0) {
                    }
                    str25 = null;
                    i12 = ((j & 34359771140L) > 0L ? 1 : ((j & 34359771140L) == 0L ? 0 : -1));
                    if (i12 == 0) {
                    }
                }
            } else {
                str2 = str12;
                z12 = z10;
                z13 = z11;
                j2 = 0;
                str13 = null;
            }
            i6 = 0;
            if ((j & 34493956100L) != j2) {
            }
            if ((j & 34376515588L) == j2) {
            }
            str15 = null;
            if ((j & 38663095300L) != 0) {
            }
            if ((j & 34363932676L) != 0) {
            }
            str19 = null;
            if ((j & 34426847236L) == 0) {
            }
            if ((j & 36509319684L) == 0) {
            }
            i10 = 0;
            if ((j & 34359803908L) != j3) {
            }
            if ((j & 34360786948L) != 0) {
            }
            str25 = null;
            i12 = ((j & 34359771140L) > 0L ? 1 : ((j & 34359771140L) == 0L ? 0 : -1));
            if (i12 == 0) {
            }
        } else {
            z2 = z;
            str = str27;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
            i = 0;
            i2 = 0;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            z7 = false;
            z8 = false;
            z9 = false;
        }
        int i18 = ((j & 34628173840L) > 0L ? 1 : ((j & 34628173840L) == 0L ? 0 : -1));
        String str29 = (i18 == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        int i19 = ((j & 34896609312L) > 0L ? 1 : ((j & 34896609312L) == 0L ? 0 : -1));
        String str30 = (i19 == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        int i20 = ((j & 35433480320L) > 0L ? 1 : ((j & 35433480320L) == 0L ? 0 : -1));
        String str31 = (i20 == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        int i21 = ((j & 42949675008L) > 0L ? 1 : ((j & 42949675008L) == 0L ? 0 : -1));
        String str32 = (i21 == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        int i22 = ((j & 51539611648L) > 0L ? 1 : ((j & 51539611648L) == 0L ? 0 : -1));
        if (i22 != 0 && mappingObject6 != null) {
            str26 = mappingObject6.getStr();
        }
        String str33 = str26;
        if ((j & 34359771140L) != 0) {
            str11 = str29;
            this.buttonLevelc.setVisibility(i2);
            this.triggerLevelc.setVisibility(i2);
            this.triggerLevelcValue.setVisibility(i2);
            this.triggerSourceCs.setVisibility(i2);
            this.triggerSourceCsLabel.setVisibility(i2);
            this.triggerSpiCsMode.setVisibility(i2);
            this.triggerSpiCsModeN.setVisibility(i2);
            this.triggerSpiCsModeP.setVisibility(i2);
            CompoundButtonBindingAdapter.setChecked(this.triggerSpiTimeout, z4);
            this.triggerSpiTimeoutLabel.setVisibility(i);
            this.triggerSpiTimeoutValue.setVisibility(i);
            CompoundButtonBindingAdapter.setChecked(this.triggerSpiWithCs, z6);
            this.viewHideModel.setVisibility(i2);
            this.viewHideTimeout.setVisibility(i);
        } else {
            str11 = str29;
        }
        if ((j & 34426847236L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.edgeFalling, z3);
            CompoundButtonBindingAdapter.setChecked(this.edgeRising, z5);
        }
        if (i21 != 0) {
            TextViewBindingAdapter.setText(this.edgeFalling, str32);
        }
        if (i19 != 0) {
            TextViewBindingAdapter.setText(this.edgeRising, str30);
        }
        if ((34359738368L & j) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.triggerLabel.setAlpha(f);
                this.triggerSpiTimeout.setAlpha(f);
                this.triggerSpiWithCs.setAlpha(f);
            }
            this.triggerLabel.setEnabled(z2);
            this.triggerSpiDatabitsValue.setVisibility(0);
            this.triggerSpiTimeout.setEnabled(z2);
            this.triggerSpiWithCs.setEnabled(z2);
        }
        if ((j & 34376515588L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelValue, str6);
        }
        if ((j & 34363932676L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelbValue, str5);
        }
        if ((j & 34360786948L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelcValue, str4);
        }
        if ((j & 34493956100L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerNoiseSwitch, z8);
        }
        if ((j & 36509319684L) != 0) {
            TextViewBindingAdapter.setText(this.triggerSourceCs, str3);
        }
        if ((j & 34361835524L) != 0) {
            this.triggerSourceCs.setTextColor(i5);
        }
        if ((j & 34393309190L) != 0) {
            TextViewBindingAdapter.setText(this.triggerSourceScl, str8);
        }
        if ((j & 34393292804L) != 0) {
            this.triggerSourceScl.setTextColor(i4);
        }
        if ((j & 38663095300L) != 0) {
            TextViewBindingAdapter.setText(this.triggerSourceSda, str9);
        }
        if ((j & 34368126980L) != 0) {
            this.triggerSourceSda.setTextColor(i3);
        }
        if ((j & 34360000516L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerSpiCsModeN, z9);
            CompoundButtonBindingAdapter.setChecked(this.triggerSpiCsModeP, z7);
        }
        if (i22 != 0) {
            TextViewBindingAdapter.setText(this.triggerSpiCsModeN, str33);
        }
        if (i20 != 0) {
            TextViewBindingAdapter.setText(this.triggerSpiCsModeP, str31);
        }
        if ((j & 34360262660L) != 0) {
            TextViewBindingAdapter.setText(this.triggerSpiDataValue, str10);
        }
        if ((j & 34359869444L) != 0) {
            TextViewBindingAdapter.setText(this.triggerSpiDatabitsValue, str2);
        }
        if ((j & 34359746561L) != 0) {
            TextViewBindingAdapter.setText(this.triggerSpiTimeout, str);
        }
        if ((j & 34359803908L) != 0) {
            TextViewBindingAdapter.setText(this.triggerSpiTimeoutValue, str7);
        }
        if (i18 != 0) {
            TextViewBindingAdapter.setText(this.triggerSpiWithCs, str11);
        }
    }
}
