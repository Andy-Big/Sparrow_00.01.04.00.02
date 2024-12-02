package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
public class AdapterTriggerCanBindingImpl extends AdapterTriggerCanBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 18);
        sViewsWithIds.put(R.id.guideline_center, 19);
        sViewsWithIds.put(R.id.guideline_right, 20);
        sViewsWithIds.put(R.id.guideline_forth, 21);
        sViewsWithIds.put(R.id.guideline_fifth, 22);
        sViewsWithIds.put(R.id.trigger_can_data_layout, 23);
        sViewsWithIds.put(R.id.layout4_guideline_left, 24);
        sViewsWithIds.put(R.id.layout4_guideline_center, 25);
        sViewsWithIds.put(R.id.layout4_guideline_right, 26);
        sViewsWithIds.put(R.id.layout4_guideline_forth, 27);
        sViewsWithIds.put(R.id.layout4_guideline_fifth, 28);
        sViewsWithIds.put(R.id.trigger_delay_layout, 29);
        sViewsWithIds.put(R.id.layout3_guideline_left, 30);
        sViewsWithIds.put(R.id.layout3_guideline_center, 31);
        sViewsWithIds.put(R.id.layout3_guideline_right, 32);
        sViewsWithIds.put(R.id.layout3_guideline_forth, 33);
        sViewsWithIds.put(R.id.layout3_guideline_fifth, 34);
        sViewsWithIds.put(R.id.trigger_label, 35);
        sViewsWithIds.put(R.id.trigger_can_layout, 36);
        sViewsWithIds.put(R.id.layout2_guideline_left, 37);
        sViewsWithIds.put(R.id.layout2_guideline_center, 38);
        sViewsWithIds.put(R.id.layout2_guideline_right, 39);
        sViewsWithIds.put(R.id.layout2_guideline_forth, 40);
        sViewsWithIds.put(R.id.layout2_guideline_fifth, 41);
        sViewsWithIds.put(R.id.trigger_sample_points_label, 42);
        sViewsWithIds.put(R.id.trigger_source_can_baud_label2, 43);
        sViewsWithIds.put(R.id.trigger_source_can_fd_baud_label2, 44);
        sViewsWithIds.put(R.id.trigger_sample_points_fd_label, 45);
        sViewsWithIds.put(R.id.trigger_source_can_h_label, 46);
        sViewsWithIds.put(R.id.trigger_slope_layout, 47);
        sViewsWithIds.put(R.id.source_guideline_left, 48);
        sViewsWithIds.put(R.id.source_guideline_center, 49);
        sViewsWithIds.put(R.id.source_guideline_right, 50);
        sViewsWithIds.put(R.id.source_guideline_forth, 51);
        sViewsWithIds.put(R.id.source_guideline_fifth, 52);
        sViewsWithIds.put(R.id.trigger_level, 53);
        sViewsWithIds.put(R.id.trigger_source_can_label, 54);
        sViewsWithIds.put(R.id.button_level, 55);
        sViewsWithIds.put(R.id.trigger_noise_label, 56);
        sViewsWithIds.put(R.id.view2, 57);
        sViewsWithIds.put(R.id.view16, 58);
    }

    public AdapterTriggerCanBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 59, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerCanBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 10, (Button) objArr[55], (Guideline) objArr[19], (Guideline) objArr[22], (Guideline) objArr[21], (Guideline) objArr[18], (Guideline) objArr[20], (Guideline) objArr[38], (Guideline) objArr[41], (Guideline) objArr[40], (Guideline) objArr[37], (Guideline) objArr[39], (Guideline) objArr[31], (Guideline) objArr[34], (Guideline) objArr[33], (Guideline) objArr[30], (Guideline) objArr[32], (Guideline) objArr[25], (Guideline) objArr[28], (Guideline) objArr[27], (Guideline) objArr[24], (Guideline) objArr[26], (Guideline) objArr[49], (Guideline) objArr[52], (Guideline) objArr[51], (Guideline) objArr[48], (Guideline) objArr[50], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[5], (ConstraintLayout) objArr[23], (EditText) objArr[6], (TextView) objArr[7], (SwitchButton) objArr[8], (TextView) objArr[1], (EditText) objArr[2], (ConstraintLayout) objArr[36], (ConstraintLayout) objArr[29], (TextView) objArr[35], (TextView) objArr[53], (EditText) objArr[15], (TextView) objArr[56], (SwitchButton) objArr[17], (TextView) objArr[45], (EditText) objArr[11], (TextView) objArr[42], (EditText) objArr[10], (ConstraintLayout) objArr[47], (TextView) objArr[43], (TextView) objArr[14], (TextView) objArr[44], (TextView) objArr[12], (TextView) objArr[46], (TextView) objArr[13], (TextView) objArr[54], (TextView) objArr[16], (TextView) objArr[9], (View) objArr[58], (View) objArr[57]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.triggerCanDataByteLabel.setTag(null);
        this.triggerCanDataByteValue.setTag(null);
        this.triggerCanDataLabel.setTag(null);
        this.triggerCanDataValue.setTag(null);
        this.triggerCanIdExtendedLabel.setTag(null);
        this.triggerCanIdExtendedValue.setTag(null);
        this.triggerCanIdLabel.setTag(null);
        this.triggerCanIdValue.setTag(null);
        this.triggerLevelValue.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSamplePointsFdValue.setTag(null);
        this.triggerSamplePointsValue.setTag(null);
        this.triggerSourceCanBaudValue.setTag(null);
        this.triggerSourceCanFdBaudValue.setTag(null);
        this.triggerSourceCanHValue.setTag(null);
        this.triggerSourceCanValue.setTag(null);
        this.triggerSourceCanWhenValue.setTag(null);
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
        if (227 == i) {
            setDefineDataMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (228 == i) {
            setDefineIdMapping((MappingObject) obj);
        } else if (218 == i) {
            setDataMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (917 != i) {
            return false;
        } else {
            setSweepNormalMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerCanBinding
    public void setDefineDataMapping(MappingObject mappingObject) {
        this.mDefineDataMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerCanBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(1, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerCanBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerCanBinding
    public void setDefineIdMapping(MappingObject mappingObject) {
        this.mDefineIdMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerCanBinding
    public void setDataMapping(MappingObject mappingObject) {
        this.mDataMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerCanBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerCanBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeDefineDataMapping((MappingObject) obj, i2);
            case 1:
                return onChangeParam((TriggerParam) obj, i2);
            case 2:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 3:
                return onChangeDefineIdMapping((MappingObject) obj, i2);
            case 4:
                return onChangeDataMapping((MappingObject) obj, i2);
            case 5:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerCanWhenParamTriggerServCanWhenValue1((MappingObject) obj, i2);
            case 6:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 7:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 8:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1((MappingObject) obj, i2);
            case 9:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerCanSingnalParamTriggerCanPhyValue1((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeDefineDataMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 975) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 338) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 217) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 337) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 408) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 771) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 293) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 140) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 951) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 136) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 484) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= 6291456;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepAutoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeDefineIdMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeDataMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerCanWhenParamTriggerServCanWhenValue1(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerCanSingnalParamTriggerCanPhyValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01db A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01ed A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:231:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x019b  */
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
        ServiceEnum.Trigger_Serv_Can_When trigger_Serv_Can_When;
        String str8;
        String str9;
        String str10;
        String str11;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        String str12;
        boolean z6;
        int i2;
        String str13;
        boolean z7;
        boolean z8;
        float f;
        float f2;
        boolean z9;
        int i3;
        float f3;
        String str14;
        boolean z10;
        String str15;
        int i4;
        String str16;
        boolean z11;
        boolean z12;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        int i5;
        String str25;
        int i6;
        int i7;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        TriggerParam triggerParam = this.mParam;
        String str26 = null;
        if ((268435234 & j) != 0) {
            if ((j & 134250498) != 0) {
                str15 = UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(triggerParam != null ? triggerParam.getSamplePoints() : 0L, ServiceEnum.Unit.Unit_percent);
            } else {
                str15 = null;
            }
            if ((j & 138412034) != 0) {
                i4 = ColorUtil.getColor(getRoot().getContext(), triggerParam != null ? triggerParam.getChan() : null);
            } else {
                i4 = 0;
            }
            if ((j & 135266306) != 0) {
                long level = triggerParam != null ? triggerParam.getLevel() : 0L;
                if (triggerParam != null) {
                    str5 = triggerParam.getTriggerLevelStr(level);
                    str6 = ((j & 134219778) != 0 || triggerParam == null) ? null : triggerParam.getFormatValue3IdStr();
                    z2 = ((j & 142606338) != 0 || triggerParam == null) ? false : triggerParam.getIsNoise();
                    if ((j & 134283266) == 0) {
                        str7 = UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(triggerParam != null ? triggerParam.getFdSamplePoints() : 0L, ServiceEnum.Unit.Unit_percent);
                    } else {
                        str7 = null;
                    }
                    if ((j & 150996002) == 0) {
                        trigger_Serv_Can_When = triggerParam != null ? triggerParam.getTrigger_Serv_Can_When() : null;
                        int i8 = ((j & 134218754) > 0L ? 1 : ((j & 134218754) == 0L ? 0 : -1));
                        if (i8 != 0) {
                            z4 = trigger_Serv_Can_When == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_frame_data;
                            z5 = trigger_Serv_Can_When == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_frame_data_id;
                            z11 = trigger_Serv_Can_When == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_remote_id;
                            if (i8 != 0) {
                                j |= z4 ? 2147483648L : 1073741824L;
                            }
                            if ((j & 134218754) != 0) {
                                j |= z5 ? 8589934592L : 4294967296L;
                            }
                            if ((j & 134218754) != 0) {
                                j = z11 ? j | 34359738368L : j | 17179869184L;
                            }
                        } else {
                            z11 = false;
                            z4 = false;
                            z5 = false;
                        }
                        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_trigger_can_when, trigger_Serv_Can_When != null ? trigger_Serv_Can_When.value1 : 0);
                        updateRegistration(5, mappingObject);
                        str16 = mappingObject != null ? mappingObject.getStr() : null;
                    } else {
                        str16 = null;
                        trigger_Serv_Can_When = null;
                        z11 = false;
                        z4 = false;
                        z5 = false;
                    }
                    if ((j & 134742018) == 0) {
                        if (triggerParam != null) {
                            i7 = triggerParam.getCanBaud();
                            z12 = z11;
                        } else {
                            z12 = z11;
                            i7 = 0;
                        }
                        str17 = str16;
                        str18 = str15;
                        str19 = UnitFormat.newBuilder(" 0.###  ", UnitFormat.SI.NONE).convert(i7, ServiceEnum.Unit.Unit_none) + "bps";
                    } else {
                        z12 = z11;
                        str17 = str16;
                        str18 = str15;
                        str19 = null;
                    }
                    if ((j & 169869570) != 0) {
                        ServiceEnum.Chan chan = triggerParam != null ? triggerParam.getChan() : null;
                        MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_trigger_source_la, chan != null ? chan.value1 : 0);
                        updateRegistration(8, mappingObject2);
                        if (mappingObject2 != null) {
                            str20 = mappingObject2.getStr();
                            String formatValue3DataStr = ((j & 134225922) != 0 || triggerParam == null) ? null : triggerParam.getFormatValue3DataStr();
                            z3 = ((j & 134234114) != 0 || triggerParam == null) ? false : triggerParam.getIdExtended();
                            if ((j & 134221826) != 0) {
                                str21 = String.valueOf(triggerParam != null ? triggerParam.getDataByte() : 0);
                            } else {
                                str21 = null;
                            }
                            if ((j & 134348802) != 0) {
                                if (triggerParam != null) {
                                    str23 = str20;
                                    str22 = str19;
                                    i6 = triggerParam.getCanFdBaud();
                                } else {
                                    str22 = str19;
                                    str23 = str20;
                                    i6 = 0;
                                }
                                str24 = formatValue3DataStr;
                                i5 = i4;
                                str25 = UnitFormat.newBuilder(" 0.###  ", UnitFormat.SI.NONE).convert(i6, ServiceEnum.Unit.Unit_none) + "bps";
                            } else {
                                str22 = str19;
                                str23 = str20;
                                str24 = formatValue3DataStr;
                                i5 = i4;
                                str25 = null;
                            }
                            if ((j & 201589250) != 0) {
                                ServiceEnum.Trigger_Can_Phy trigger_Can_Phy = triggerParam != null ? triggerParam.getTrigger_Can_Phy() : null;
                                MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_trigger_can_singnal, trigger_Can_Phy != null ? trigger_Can_Phy.value1 : 0);
                                updateRegistration(9, mappingObject3);
                                if (mappingObject3 != null) {
                                    str26 = mappingObject3.getStr();
                                }
                            }
                            str8 = str25;
                            z = z12;
                            str9 = str26;
                            str11 = str17;
                            str3 = str18;
                            str = str21;
                            str4 = str22;
                            str10 = str23;
                            str2 = str24;
                            i = i5;
                        }
                    }
                    str20 = null;
                    if ((j & 134225922) != 0) {
                    }
                    if ((j & 134234114) != 0) {
                    }
                    if ((j & 134221826) != 0) {
                    }
                    if ((j & 134348802) != 0) {
                    }
                    if ((j & 201589250) != 0) {
                    }
                    str8 = str25;
                    z = z12;
                    str9 = str26;
                    str11 = str17;
                    str3 = str18;
                    str = str21;
                    str4 = str22;
                    str10 = str23;
                    str2 = str24;
                    i = i5;
                }
            }
            str5 = null;
            if ((j & 134219778) != 0) {
            }
            if ((j & 142606338) != 0) {
            }
            if ((j & 134283266) == 0) {
            }
            if ((j & 150996002) == 0) {
            }
            if ((j & 134742018) == 0) {
            }
            if ((j & 169869570) != 0) {
            }
            str20 = null;
            if ((j & 134225922) != 0) {
            }
            if ((j & 134234114) != 0) {
            }
            if ((j & 134221826) != 0) {
            }
            if ((j & 134348802) != 0) {
            }
            if ((j & 201589250) != 0) {
            }
            str8 = str25;
            z = z12;
            str9 = str26;
            str11 = str17;
            str3 = str18;
            str = str21;
            str4 = str22;
            str10 = str23;
            str2 = str24;
            i = i5;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            trigger_Serv_Can_When = null;
            str8 = null;
            str9 = null;
            str10 = null;
            str11 = null;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            i = 0;
        }
        if ((j & 17179869184L) != 0) {
            str12 = str4;
            if (trigger_Serv_Can_When == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_frame_id) {
                z6 = true;
                i2 = ((j & 134218754) > 0L ? 1 : ((j & 134218754) == 0L ? 0 : -1));
                if (i2 == 0) {
                    boolean z13 = z4 ? true : z5;
                    if (z5) {
                        z4 = true;
                    }
                    float alpha = ContextUtil.getAlpha(z13);
                    str13 = str3;
                    f = ContextUtil.getAlpha(z4);
                    boolean z14 = z13;
                    z7 = z6;
                    z9 = z14;
                    z8 = z5;
                    f2 = alpha;
                } else {
                    str13 = str3;
                    z7 = z6;
                    z8 = z5;
                    f = 0.0f;
                    f2 = 0.0f;
                    z9 = false;
                    z4 = false;
                }
                if (i2 == 0) {
                    if (z) {
                        z7 = true;
                    }
                    if (i2 != 0) {
                        j |= z7 ? 536870912L : 268435456L;
                    }
                } else {
                    z7 = false;
                }
                i3 = ((j & 134218754) > 0L ? 1 : ((j & 134218754) == 0L ? 0 : -1));
                if (i3 == 0) {
                    boolean z15 = z7 ? true : z8;
                    f3 = ContextUtil.getAlpha(z15);
                    str14 = str7;
                    z10 = z15;
                } else {
                    f3 = 0.0f;
                    str14 = str7;
                    z10 = false;
                }
                if (i3 != 0) {
                    this.triggerCanDataByteLabel.setEnabled(z4);
                    this.triggerCanDataByteValue.setEnabled(z4);
                    this.triggerCanDataLabel.setEnabled(z9);
                    this.triggerCanDataValue.setEnabled(z9);
                    this.triggerCanIdExtendedLabel.setEnabled(z10);
                    this.triggerCanIdExtendedValue.setEnabled(z10);
                    this.triggerCanIdLabel.setEnabled(z10);
                    this.triggerCanIdValue.setEnabled(z10);
                    if (getBuildSdkInt() >= 11) {
                        this.triggerCanDataByteLabel.setAlpha(f);
                        this.triggerCanDataByteValue.setAlpha(f);
                        this.triggerCanDataLabel.setAlpha(f2);
                        this.triggerCanDataValue.setAlpha(f2);
                        this.triggerCanIdExtendedLabel.setAlpha(f3);
                        this.triggerCanIdExtendedValue.setAlpha(f3);
                        this.triggerCanIdLabel.setAlpha(f3);
                        this.triggerCanIdValue.setAlpha(f3);
                    }
                }
                if ((j & 134221826) != 0) {
                    TextViewBindingAdapter.setText(this.triggerCanDataByteValue, str);
                }
                if ((j & 134225922) != 0) {
                    TextViewBindingAdapter.setText(this.triggerCanDataValue, str2);
                }
                if ((134234114 & j) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.triggerCanIdExtendedValue, z3);
                }
                if ((j & 134219778) != 0) {
                    TextViewBindingAdapter.setText(this.triggerCanIdValue, str6);
                }
                if ((j & 135266306) != 0) {
                    TextViewBindingAdapter.setText(this.triggerLevelValue, str5);
                }
                if ((j & 142606338) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.triggerNoiseSwitch, z2);
                }
                if ((j & 134283266) != 0) {
                    TextViewBindingAdapter.setText(this.triggerSamplePointsFdValue, str14);
                }
                if ((j & 134250498) != 0) {
                    TextViewBindingAdapter.setText(this.triggerSamplePointsValue, str13);
                }
                if ((134742018 & j) != 0) {
                    TextViewBindingAdapter.setText(this.triggerSourceCanBaudValue, str12);
                }
                if ((134348802 & j) != 0) {
                    TextViewBindingAdapter.setText(this.triggerSourceCanFdBaudValue, str8);
                }
                if ((201589250 & j) != 0) {
                    TextViewBindingAdapter.setText(this.triggerSourceCanHValue, str9);
                }
                if ((169869570 & j) != 0) {
                    TextViewBindingAdapter.setText(this.triggerSourceCanValue, str10);
                }
                if ((j & 138412034) != 0) {
                    this.triggerSourceCanValue.setTextColor(i);
                }
                if ((j & 150996002) == 0) {
                    TextViewBindingAdapter.setText(this.triggerSourceCanWhenValue, str11);
                    return;
                }
                return;
            }
        } else {
            str12 = str4;
        }
        z6 = false;
        i2 = ((j & 134218754) > 0L ? 1 : ((j & 134218754) == 0L ? 0 : -1));
        if (i2 == 0) {
        }
        if (i2 == 0) {
        }
        i3 = ((j & 134218754) > 0L ? 1 : ((j & 134218754) == 0L ? 0 : -1));
        if (i3 == 0) {
        }
        if (i3 != 0) {
        }
        if ((j & 134221826) != 0) {
        }
        if ((j & 134225922) != 0) {
        }
        if ((134234114 & j) != 0) {
        }
        if ((j & 134219778) != 0) {
        }
        if ((j & 135266306) != 0) {
        }
        if ((j & 142606338) != 0) {
        }
        if ((j & 134283266) != 0) {
        }
        if ((j & 134250498) != 0) {
        }
        if ((134742018 & j) != 0) {
        }
        if ((134348802 & j) != 0) {
        }
        if ((201589250 & j) != 0) {
        }
        if ((169869570 & j) != 0) {
        }
        if ((j & 138412034) != 0) {
        }
        if ((j & 150996002) == 0) {
        }
    }
}
