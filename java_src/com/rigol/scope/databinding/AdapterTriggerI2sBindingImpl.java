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
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;

/* loaded from: classes2.dex */
public class AdapterTriggerI2sBindingImpl extends AdapterTriggerI2sBinding {
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
        sViewsWithIds.put(R.id.view_middle, 31);
        sViewsWithIds.put(R.id.view_bottom, 32);
        sViewsWithIds.put(R.id.trigger_audio_label, 33);
        sViewsWithIds.put(R.id.trigger_source_sclk_edge_label, 34);
        sViewsWithIds.put(R.id.button_levelc, 35);
        sViewsWithIds.put(R.id.trigger_levelc, 36);
        sViewsWithIds.put(R.id.trigger_source_sda_label, 37);
        sViewsWithIds.put(R.id.button_levelb, 38);
        sViewsWithIds.put(R.id.trigger_levelb, 39);
        sViewsWithIds.put(R.id.trigger_level, 40);
        sViewsWithIds.put(R.id.trigger_source_scl_label, 41);
        sViewsWithIds.put(R.id.trigger_source_ws_label, 42);
        sViewsWithIds.put(R.id.button_level, 43);
        sViewsWithIds.put(R.id.trigger_label, 44);
        sViewsWithIds.put(R.id.height10, 45);
        sViewsWithIds.put(R.id.trigger_iis_alignment_label, 46);
        sViewsWithIds.put(R.id.trigger_iis_width_label, 47);
        sViewsWithIds.put(R.id.trigger_iis_allwidth_label, 48);
        sViewsWithIds.put(R.id.trigger_noise_label, 49);
        sViewsWithIds.put(R.id.view2, 50);
        sViewsWithIds.put(R.id.view16, 51);
    }

    public AdapterTriggerI2sBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 52, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerI2sBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 10, (Button) objArr[43], (Button) objArr[38], (Button) objArr[35], (Guideline) objArr[26], (Guideline) objArr[29], (Guideline) objArr[28], (Guideline) objArr[25], (Guideline) objArr[27], (View) objArr[45], (TextView) objArr[33], (TextView) objArr[1], (TextView) objArr[15], (TextView) objArr[17], (EditText) objArr[20], (TextView) objArr[18], (EditText) objArr[19], (EditText) objArr[23], (TextView) objArr[46], (TextView) objArr[16], (TextView) objArr[48], (EditText) objArr[22], (RadioButton) objArr[10], (RadioButton) objArr[11], (RadioButton) objArr[12], (RadioButton) objArr[13], (RadioButton) objArr[14], (RadioButton) objArr[9], (TextView) objArr[47], (EditText) objArr[21], (TextView) objArr[44], (TextView) objArr[40], (EditText) objArr[7], (TextView) objArr[39], (EditText) objArr[5], (TextView) objArr[36], (EditText) objArr[3], (TextView) objArr[49], (SwitchButton) objArr[24], (TextView) objArr[8], (TextView) objArr[41], (TextView) objArr[34], (TextView) objArr[2], (TextView) objArr[4], (TextView) objArr[37], (TextView) objArr[6], (TextView) objArr[42], (View) objArr[51], (View) objArr[50], (View) objArr[32], (View) objArr[31], (View) objArr[30]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.triggerAudioValue.setTag(null);
        this.triggerI2sDataLabel.setTag(null);
        this.triggerI2sDataLowLabel.setTag(null);
        this.triggerI2sDataLowValue.setTag(null);
        this.triggerI2sDataUpLabel.setTag(null);
        this.triggerI2sDataUpValue.setTag(null);
        this.triggerI2sDataValue.setTag(null);
        this.triggerIisAlignmentValue.setTag(null);
        this.triggerIisAllwidthValue.setTag(null);
        this.triggerIisEq.setTag(null);
        this.triggerIisLessthan.setTag(null);
        this.triggerIisMoreless.setTag(null);
        this.triggerIisMorethan.setTag(null);
        this.triggerIisNeq.setTag(null);
        this.triggerIisUnmoreless.setTag(null);
        this.triggerIisWidthValue.setTag(null);
        this.triggerLevelValue.setTag(null);
        this.triggerLevelbValue.setTag(null);
        this.triggerLevelcValue.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSourceScl.setTag(null);
        this.triggerSourceSclkEdgeValue.setTag(null);
        this.triggerSourceSda.setTag(null);
        this.triggerSourceWs.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4294967296L;
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
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (917 != i) {
            return false;
        } else {
            setSweepNormalMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerI2sBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(1, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerI2sBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerI2sBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerI2sBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerIisWsParamIisChanBValue1((MappingObject) obj, i2);
            case 1:
                return onChangeParam((TriggerParam) obj, i2);
            case 2:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 3:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerIisSclkParamIisChanAValue1((MappingObject) obj, i2);
            case 4:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 5:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 6:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerIisWsLowParamTriggerIISChValue1((MappingObject) obj, i2);
            case 7:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerIisSdaParamIisChanCValue1((MappingObject) obj, i2);
            case 8:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerIisAlignmentParamTriggerIISSpecValue1((MappingObject) obj, i2);
            case 9:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerIisSlopeParamIisSlopeValue1((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerIisWsParamIisChanBValue1(MappingObject mappingObject, int i) {
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

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 962) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 423) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 426) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 419) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 425) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 418) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 424) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 417) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 964) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 963) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 340) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 341) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 1074) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 44) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 342) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerIisSclkParamIisChanAValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
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
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerIisWsLowParamTriggerIISChValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerIisSdaParamIisChanCValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerIisAlignmentParamTriggerIISSpecValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerIisSlopeParamIisSlopeValue1(MappingObject mappingObject, int i) {
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

    /* JADX WARN: Removed duplicated region for block: B:109:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x035a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011a  */
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
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        int i2;
        boolean z7;
        int i3;
        String str15;
        int i4;
        boolean z8;
        boolean z9;
        String str16;
        String str17;
        int i5;
        int i6;
        String str18;
        String str19;
        int i7;
        String str20;
        String str21;
        String str22;
        int i8;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        long j3;
        String str30;
        int i9;
        String str31;
        int i10;
        String str32;
        String str33;
        int i11;
        int i12;
        String str34;
        String str35;
        String str36;
        String str37;
        String str38;
        int i13;
        int i14;
        long j4;
        int i15;
        int i16;
        int i17;
        long j5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        TriggerParam triggerParam = this.mParam;
        String str39 = null;
        if ((8589934539L & j) != 0) {
            String formatValue5MinStr = ((j & 4299161602L) == 0 || triggerParam == null) ? null : triggerParam.getFormatValue5MinStr();
            if ((j & 4831854722L) != 0) {
                ServiceEnum.Chan iisChanC = triggerParam != null ? triggerParam.getIisChanC() : null;
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_trigger_iis_sda, iisChanC != null ? iisChanC.value1 : 0);
                updateRegistration(7, mappingObject);
                str19 = mappingObject != null ? mappingObject.getStr() : null;
                if ((j & 4294983682L) != 0) {
                    i7 = ColorUtil.getColor(getRoot().getContext(), iisChanC);
                    if ((j & 6442455554L) != 0) {
                        ServiceEnum.EdgeSlope iisSlope = triggerParam != null ? triggerParam.getIisSlope() : null;
                        MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_trigger_iis_slope, iisSlope != null ? iisSlope.value1 : 0);
                        updateRegistration(9, mappingObject2);
                        if (mappingObject2 != null) {
                            str20 = mappingObject2.getStr();
                            if ((j & 4311744514L) != 0) {
                                str21 = UnitFormat.newBuilder(" # ", UnitFormat.SI.NONE).convert(triggerParam != null ? triggerParam.getAllWidth() : 0, ServiceEnum.Unit.Unit_none);
                            } else {
                                str21 = null;
                            }
                            str5 = ((j & 4328521730L) != 0 || triggerParam == null) ? null : triggerParam.getFormatValue5Str();
                            if ((j & 4294975490L) != 0) {
                                long iislevelC = triggerParam != null ? triggerParam.getIislevelC() : 0L;
                                if (triggerParam != null) {
                                    str22 = triggerParam.getTriggerLevelCStr(iislevelC);
                                    i8 = ((j & 4295491586L) > 0L ? 1 : ((j & 4295491586L) == 0L ? 0 : -1));
                                    if (i8 == 0) {
                                        ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp = triggerParam != null ? triggerParam.getTrigger_IIS_data_cmp() : null;
                                        z6 = trigger_IIS_data_cmp == ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_mt;
                                        boolean z16 = trigger_IIS_data_cmp == ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_neq;
                                        boolean z17 = trigger_IIS_data_cmp == ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_lt;
                                        z12 = trigger_IIS_data_cmp == ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_in;
                                        z13 = trigger_IIS_data_cmp == ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_out;
                                        boolean z18 = trigger_IIS_data_cmp == ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_eq;
                                        if (i8 != 0) {
                                            j |= z6 ? 68719476736L : 34359738368L;
                                        }
                                        if ((j & 4295491586L) != 0) {
                                            j |= z17 ? 4398046511104L : 2199023255552L;
                                        }
                                        if ((j & 4295491586L) != 0) {
                                            j |= z18 ? 17592186044416L : 8796093022208L;
                                        }
                                        z5 = z17;
                                        z11 = z18;
                                        z10 = z16;
                                    } else {
                                        z10 = false;
                                        z11 = false;
                                        z5 = false;
                                        z6 = false;
                                        z12 = false;
                                        z13 = false;
                                    }
                                    boolean isNoise = ((j & 4362076162L) != 0 || triggerParam == null) ? false : triggerParam.getIsNoise();
                                    if ((j & 4295000066L) == 0) {
                                        if (triggerParam != null) {
                                            z14 = z10;
                                            z15 = z11;
                                            j5 = triggerParam.getIislevelB();
                                        } else {
                                            z14 = z10;
                                            z15 = z11;
                                            j5 = 0;
                                        }
                                        if (triggerParam != null) {
                                            str23 = triggerParam.getTriggerLevelBStr(j5);
                                            if ((j & 5369757954L) != 0) {
                                                ServiceEnum.Trigger_IIS_Spec trigger_IIS_Spec = triggerParam != null ? triggerParam.getTrigger_IIS_Spec() : null;
                                                if (trigger_IIS_Spec != null) {
                                                    i17 = trigger_IIS_Spec.value1;
                                                    str24 = str23;
                                                } else {
                                                    str24 = str23;
                                                    i17 = 0;
                                                }
                                                MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_trigger_iis_alignment, i17);
                                                updateRegistration(8, mappingObject3);
                                                if (mappingObject3 != null) {
                                                    str25 = mappingObject3.getStr();
                                                    if ((j & 4563404866L) == 0) {
                                                        ServiceEnum.Trigger_IIS_Ch trigger_IIS_Ch = triggerParam != null ? triggerParam.getTrigger_IIS_Ch() : null;
                                                        if (trigger_IIS_Ch != null) {
                                                            i16 = trigger_IIS_Ch.value1;
                                                            str26 = str25;
                                                        } else {
                                                            str26 = str25;
                                                            i16 = 0;
                                                        }
                                                        MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_trigger_iis_ws_low, i16);
                                                        updateRegistration(6, mappingObject4);
                                                        if (mappingObject4 != null) {
                                                            str27 = mappingObject4.getStr();
                                                            if ((j & 4429447178L) != 0) {
                                                                ServiceEnum.Chan iisChanA = triggerParam != null ? triggerParam.getIisChanA() : null;
                                                                str28 = str27;
                                                                if (iisChanA != null) {
                                                                    i15 = iisChanA.value1;
                                                                    str29 = formatValue5MinStr;
                                                                } else {
                                                                    str29 = formatValue5MinStr;
                                                                    i15 = 0;
                                                                }
                                                                MappingObject mappingObject5 = ViewUtil.getMappingObject(R.array.msg_trigger_iis_sclk, i15);
                                                                updateRegistration(3, mappingObject5);
                                                                str30 = mappingObject5 != null ? mappingObject5.getStr() : null;
                                                                j3 = 0;
                                                                if ((j & 4295229442L) != 0) {
                                                                    i9 = ColorUtil.getColor(getRoot().getContext(), iisChanA);
                                                                    if ((j & 4295098370L) == j3) {
                                                                        if (triggerParam != null) {
                                                                            str31 = str30;
                                                                            i10 = i9;
                                                                            j4 = triggerParam.getIislevelA();
                                                                        } else {
                                                                            str31 = str30;
                                                                            i10 = i9;
                                                                            j4 = 0;
                                                                        }
                                                                        if (triggerParam != null) {
                                                                            str32 = triggerParam.getTriggerLevelStr(j4);
                                                                            if ((j & 4295033859L) != 0) {
                                                                                ServiceEnum.Chan iisChanB = triggerParam != null ? triggerParam.getIisChanB() : null;
                                                                                if ((j & 4295032834L) != 0) {
                                                                                    str33 = str32;
                                                                                    i13 = ColorUtil.getColor(getRoot().getContext(), iisChanB);
                                                                                } else {
                                                                                    str33 = str32;
                                                                                    i13 = 0;
                                                                                }
                                                                                if (iisChanB != null) {
                                                                                    i14 = iisChanB.value1;
                                                                                    i12 = i13;
                                                                                } else {
                                                                                    i12 = i13;
                                                                                    i14 = 0;
                                                                                }
                                                                                MappingObject mappingObject6 = ViewUtil.getMappingObject(R.array.msg_trigger_iis_ws, i14);
                                                                                i11 = 0;
                                                                                updateRegistration(0, mappingObject6);
                                                                                if (mappingObject6 != null) {
                                                                                    str34 = mappingObject6.getStr();
                                                                                    if ((j & 4303355906L) == 0) {
                                                                                        if (triggerParam != null) {
                                                                                            str35 = str34;
                                                                                            i11 = triggerParam.getWidth();
                                                                                        } else {
                                                                                            str35 = str34;
                                                                                        }
                                                                                        str36 = str31;
                                                                                        str37 = str19;
                                                                                        str38 = UnitFormat.newBuilder(" # ", UnitFormat.SI.NONE).convert(i11, ServiceEnum.Unit.Unit_none);
                                                                                    } else {
                                                                                        str35 = str34;
                                                                                        str36 = str31;
                                                                                        str37 = str19;
                                                                                        str38 = null;
                                                                                    }
                                                                                    j2 = 0;
                                                                                    if ((j & 4297064450L) != 0 && triggerParam != null) {
                                                                                        str39 = triggerParam.getFormatValue5MaxStr();
                                                                                    }
                                                                                    str12 = str20;
                                                                                    str10 = str22;
                                                                                    z = z13;
                                                                                    z3 = z15;
                                                                                    str8 = str24;
                                                                                    str2 = str26;
                                                                                    str6 = str28;
                                                                                    str = str29;
                                                                                    i3 = i12;
                                                                                    str9 = str33;
                                                                                    str14 = str35;
                                                                                    str11 = str36;
                                                                                    str13 = str37;
                                                                                    str4 = str38;
                                                                                    z2 = z14;
                                                                                    i = i7;
                                                                                    str3 = str21;
                                                                                    z4 = z12;
                                                                                    z7 = isNoise;
                                                                                    str7 = str39;
                                                                                    i2 = i10;
                                                                                }
                                                                            } else {
                                                                                str33 = str32;
                                                                                i11 = 0;
                                                                                i12 = 0;
                                                                            }
                                                                            str34 = null;
                                                                            if ((j & 4303355906L) == 0) {
                                                                            }
                                                                            j2 = 0;
                                                                            if ((j & 4297064450L) != 0) {
                                                                                str39 = triggerParam.getFormatValue5MaxStr();
                                                                            }
                                                                            str12 = str20;
                                                                            str10 = str22;
                                                                            z = z13;
                                                                            z3 = z15;
                                                                            str8 = str24;
                                                                            str2 = str26;
                                                                            str6 = str28;
                                                                            str = str29;
                                                                            i3 = i12;
                                                                            str9 = str33;
                                                                            str14 = str35;
                                                                            str11 = str36;
                                                                            str13 = str37;
                                                                            str4 = str38;
                                                                            z2 = z14;
                                                                            i = i7;
                                                                            str3 = str21;
                                                                            z4 = z12;
                                                                            z7 = isNoise;
                                                                            str7 = str39;
                                                                            i2 = i10;
                                                                        }
                                                                    } else {
                                                                        str31 = str30;
                                                                        i10 = i9;
                                                                    }
                                                                    str32 = null;
                                                                    if ((j & 4295033859L) != 0) {
                                                                    }
                                                                    str34 = null;
                                                                    if ((j & 4303355906L) == 0) {
                                                                    }
                                                                    j2 = 0;
                                                                    if ((j & 4297064450L) != 0) {
                                                                    }
                                                                    str12 = str20;
                                                                    str10 = str22;
                                                                    z = z13;
                                                                    z3 = z15;
                                                                    str8 = str24;
                                                                    str2 = str26;
                                                                    str6 = str28;
                                                                    str = str29;
                                                                    i3 = i12;
                                                                    str9 = str33;
                                                                    str14 = str35;
                                                                    str11 = str36;
                                                                    str13 = str37;
                                                                    str4 = str38;
                                                                    z2 = z14;
                                                                    i = i7;
                                                                    str3 = str21;
                                                                    z4 = z12;
                                                                    z7 = isNoise;
                                                                    str7 = str39;
                                                                    i2 = i10;
                                                                }
                                                            } else {
                                                                str28 = str27;
                                                                str29 = formatValue5MinStr;
                                                                j3 = 0;
                                                                str30 = null;
                                                            }
                                                            i9 = 0;
                                                            if ((j & 4295098370L) == j3) {
                                                            }
                                                            str32 = null;
                                                            if ((j & 4295033859L) != 0) {
                                                            }
                                                            str34 = null;
                                                            if ((j & 4303355906L) == 0) {
                                                            }
                                                            j2 = 0;
                                                            if ((j & 4297064450L) != 0) {
                                                            }
                                                            str12 = str20;
                                                            str10 = str22;
                                                            z = z13;
                                                            z3 = z15;
                                                            str8 = str24;
                                                            str2 = str26;
                                                            str6 = str28;
                                                            str = str29;
                                                            i3 = i12;
                                                            str9 = str33;
                                                            str14 = str35;
                                                            str11 = str36;
                                                            str13 = str37;
                                                            str4 = str38;
                                                            z2 = z14;
                                                            i = i7;
                                                            str3 = str21;
                                                            z4 = z12;
                                                            z7 = isNoise;
                                                            str7 = str39;
                                                            i2 = i10;
                                                        }
                                                    } else {
                                                        str26 = str25;
                                                    }
                                                    str27 = null;
                                                    if ((j & 4429447178L) != 0) {
                                                    }
                                                    i9 = 0;
                                                    if ((j & 4295098370L) == j3) {
                                                    }
                                                    str32 = null;
                                                    if ((j & 4295033859L) != 0) {
                                                    }
                                                    str34 = null;
                                                    if ((j & 4303355906L) == 0) {
                                                    }
                                                    j2 = 0;
                                                    if ((j & 4297064450L) != 0) {
                                                    }
                                                    str12 = str20;
                                                    str10 = str22;
                                                    z = z13;
                                                    z3 = z15;
                                                    str8 = str24;
                                                    str2 = str26;
                                                    str6 = str28;
                                                    str = str29;
                                                    i3 = i12;
                                                    str9 = str33;
                                                    str14 = str35;
                                                    str11 = str36;
                                                    str13 = str37;
                                                    str4 = str38;
                                                    z2 = z14;
                                                    i = i7;
                                                    str3 = str21;
                                                    z4 = z12;
                                                    z7 = isNoise;
                                                    str7 = str39;
                                                    i2 = i10;
                                                }
                                            } else {
                                                str24 = str23;
                                            }
                                            str25 = null;
                                            if ((j & 4563404866L) == 0) {
                                            }
                                            str27 = null;
                                            if ((j & 4429447178L) != 0) {
                                            }
                                            i9 = 0;
                                            if ((j & 4295098370L) == j3) {
                                            }
                                            str32 = null;
                                            if ((j & 4295033859L) != 0) {
                                            }
                                            str34 = null;
                                            if ((j & 4303355906L) == 0) {
                                            }
                                            j2 = 0;
                                            if ((j & 4297064450L) != 0) {
                                            }
                                            str12 = str20;
                                            str10 = str22;
                                            z = z13;
                                            z3 = z15;
                                            str8 = str24;
                                            str2 = str26;
                                            str6 = str28;
                                            str = str29;
                                            i3 = i12;
                                            str9 = str33;
                                            str14 = str35;
                                            str11 = str36;
                                            str13 = str37;
                                            str4 = str38;
                                            z2 = z14;
                                            i = i7;
                                            str3 = str21;
                                            z4 = z12;
                                            z7 = isNoise;
                                            str7 = str39;
                                            i2 = i10;
                                        }
                                    } else {
                                        z14 = z10;
                                        z15 = z11;
                                    }
                                    str23 = null;
                                    if ((j & 5369757954L) != 0) {
                                    }
                                    str25 = null;
                                    if ((j & 4563404866L) == 0) {
                                    }
                                    str27 = null;
                                    if ((j & 4429447178L) != 0) {
                                    }
                                    i9 = 0;
                                    if ((j & 4295098370L) == j3) {
                                    }
                                    str32 = null;
                                    if ((j & 4295033859L) != 0) {
                                    }
                                    str34 = null;
                                    if ((j & 4303355906L) == 0) {
                                    }
                                    j2 = 0;
                                    if ((j & 4297064450L) != 0) {
                                    }
                                    str12 = str20;
                                    str10 = str22;
                                    z = z13;
                                    z3 = z15;
                                    str8 = str24;
                                    str2 = str26;
                                    str6 = str28;
                                    str = str29;
                                    i3 = i12;
                                    str9 = str33;
                                    str14 = str35;
                                    str11 = str36;
                                    str13 = str37;
                                    str4 = str38;
                                    z2 = z14;
                                    i = i7;
                                    str3 = str21;
                                    z4 = z12;
                                    z7 = isNoise;
                                    str7 = str39;
                                    i2 = i10;
                                }
                            }
                            str22 = null;
                            i8 = ((j & 4295491586L) > 0L ? 1 : ((j & 4295491586L) == 0L ? 0 : -1));
                            if (i8 == 0) {
                            }
                            if ((j & 4362076162L) != 0) {
                            }
                            if ((j & 4295000066L) == 0) {
                            }
                            str23 = null;
                            if ((j & 5369757954L) != 0) {
                            }
                            str25 = null;
                            if ((j & 4563404866L) == 0) {
                            }
                            str27 = null;
                            if ((j & 4429447178L) != 0) {
                            }
                            i9 = 0;
                            if ((j & 4295098370L) == j3) {
                            }
                            str32 = null;
                            if ((j & 4295033859L) != 0) {
                            }
                            str34 = null;
                            if ((j & 4303355906L) == 0) {
                            }
                            j2 = 0;
                            if ((j & 4297064450L) != 0) {
                            }
                            str12 = str20;
                            str10 = str22;
                            z = z13;
                            z3 = z15;
                            str8 = str24;
                            str2 = str26;
                            str6 = str28;
                            str = str29;
                            i3 = i12;
                            str9 = str33;
                            str14 = str35;
                            str11 = str36;
                            str13 = str37;
                            str4 = str38;
                            z2 = z14;
                            i = i7;
                            str3 = str21;
                            z4 = z12;
                            z7 = isNoise;
                            str7 = str39;
                            i2 = i10;
                        }
                    }
                    str20 = null;
                    if ((j & 4311744514L) != 0) {
                    }
                    if ((j & 4328521730L) != 0) {
                    }
                    if ((j & 4294975490L) != 0) {
                    }
                    str22 = null;
                    i8 = ((j & 4295491586L) > 0L ? 1 : ((j & 4295491586L) == 0L ? 0 : -1));
                    if (i8 == 0) {
                    }
                    if ((j & 4362076162L) != 0) {
                    }
                    if ((j & 4295000066L) == 0) {
                    }
                    str23 = null;
                    if ((j & 5369757954L) != 0) {
                    }
                    str25 = null;
                    if ((j & 4563404866L) == 0) {
                    }
                    str27 = null;
                    if ((j & 4429447178L) != 0) {
                    }
                    i9 = 0;
                    if ((j & 4295098370L) == j3) {
                    }
                    str32 = null;
                    if ((j & 4295033859L) != 0) {
                    }
                    str34 = null;
                    if ((j & 4303355906L) == 0) {
                    }
                    j2 = 0;
                    if ((j & 4297064450L) != 0) {
                    }
                    str12 = str20;
                    str10 = str22;
                    z = z13;
                    z3 = z15;
                    str8 = str24;
                    str2 = str26;
                    str6 = str28;
                    str = str29;
                    i3 = i12;
                    str9 = str33;
                    str14 = str35;
                    str11 = str36;
                    str13 = str37;
                    str4 = str38;
                    z2 = z14;
                    i = i7;
                    str3 = str21;
                    z4 = z12;
                    z7 = isNoise;
                    str7 = str39;
                    i2 = i10;
                }
            } else {
                str19 = null;
            }
            i7 = 0;
            if ((j & 6442455554L) != 0) {
            }
            str20 = null;
            if ((j & 4311744514L) != 0) {
            }
            if ((j & 4328521730L) != 0) {
            }
            if ((j & 4294975490L) != 0) {
            }
            str22 = null;
            i8 = ((j & 4295491586L) > 0L ? 1 : ((j & 4295491586L) == 0L ? 0 : -1));
            if (i8 == 0) {
            }
            if ((j & 4362076162L) != 0) {
            }
            if ((j & 4295000066L) == 0) {
            }
            str23 = null;
            if ((j & 5369757954L) != 0) {
            }
            str25 = null;
            if ((j & 4563404866L) == 0) {
            }
            str27 = null;
            if ((j & 4429447178L) != 0) {
            }
            i9 = 0;
            if ((j & 4295098370L) == j3) {
            }
            str32 = null;
            if ((j & 4295033859L) != 0) {
            }
            str34 = null;
            if ((j & 4303355906L) == 0) {
            }
            j2 = 0;
            if ((j & 4297064450L) != 0) {
            }
            str12 = str20;
            str10 = str22;
            z = z13;
            z3 = z15;
            str8 = str24;
            str2 = str26;
            str6 = str28;
            str = str29;
            i3 = i12;
            str9 = str33;
            str14 = str35;
            str11 = str36;
            str13 = str37;
            str4 = str38;
            z2 = z14;
            i = i7;
            str3 = str21;
            z4 = z12;
            z7 = isNoise;
            str7 = str39;
            i2 = i10;
        } else {
            j2 = 0;
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
            str13 = null;
            str14 = null;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            i = 0;
            i2 = 0;
            z7 = false;
            i3 = 0;
        }
        int i18 = ((j & 4295491586L) > j2 ? 1 : ((j & 4295491586L) == j2 ? 0 : -1));
        if (i18 != 0) {
            z8 = z6 ? true : z4;
            z9 = z5 ? true : z4;
            boolean z19 = z3 ? true : z2;
            if (i18 != 0) {
                j |= z8 ? 281474976710656L : 140737488355328L;
            }
            if ((j & 4295491586L) != 0) {
                j |= z9 ? 1099511627776L : 549755813888L;
            }
            if ((j & 4295491586L) != 0) {
                j |= z19 ? 17179869184L : 8589934592L;
            }
            str15 = str4;
            i4 = z19 ? 0 : 8;
        } else {
            str15 = str4;
            i4 = 0;
            z8 = false;
            z9 = false;
        }
        int i19 = ((j & 4295491586L) > 0L ? 1 : ((j & 4295491586L) == 0L ? 0 : -1));
        if (i19 != 0) {
            boolean z20 = z9 ? true : z;
            boolean z21 = z8 ? true : z;
            if (i19 != 0) {
                j |= z20 ? 70368744177664L : 35184372088832L;
            }
            if ((j & 4295491586L) != 0) {
                j |= z21 ? 274877906944L : 137438953472L;
            }
            int i20 = z20 ? 0 : 8;
            int i21 = z21 ? 0 : 8;
            str16 = str2;
            str17 = str3;
            i6 = i21;
            i5 = i20;
        } else {
            str16 = str2;
            str17 = str3;
            i5 = 0;
            i6 = 0;
        }
        if ((j & 4563404866L) != 0) {
            str18 = str5;
            TextViewBindingAdapter.setText(this.triggerAudioValue, str6);
        } else {
            str18 = str5;
        }
        if ((j & 4295491586L) != 0) {
            this.triggerI2sDataLabel.setVisibility(i4);
            this.triggerI2sDataLowLabel.setVisibility(i6);
            this.triggerI2sDataLowValue.setVisibility(i6);
            this.triggerI2sDataUpLabel.setVisibility(i5);
            this.triggerI2sDataUpValue.setVisibility(i5);
            this.triggerI2sDataValue.setVisibility(i4);
            CompoundButtonBindingAdapter.setChecked(this.triggerIisEq, z3);
            CompoundButtonBindingAdapter.setChecked(this.triggerIisLessthan, z5);
            CompoundButtonBindingAdapter.setChecked(this.triggerIisMoreless, z);
            CompoundButtonBindingAdapter.setChecked(this.triggerIisMorethan, z6);
            CompoundButtonBindingAdapter.setChecked(this.triggerIisNeq, z2);
            CompoundButtonBindingAdapter.setChecked(this.triggerIisUnmoreless, z4);
        }
        if ((j & 4299161602L) != 0) {
            TextViewBindingAdapter.setText(this.triggerI2sDataLowValue, str);
        }
        if ((j & 4297064450L) != 0) {
            TextViewBindingAdapter.setText(this.triggerI2sDataUpValue, str7);
        }
        if ((j & 4328521730L) != 0) {
            TextViewBindingAdapter.setText(this.triggerI2sDataValue, str18);
        }
        if ((j & 5369757954L) != 0) {
            TextViewBindingAdapter.setText(this.triggerIisAlignmentValue, str16);
        }
        if ((j & 4311744514L) != 0) {
            TextViewBindingAdapter.setText(this.triggerIisAllwidthValue, str17);
        }
        if ((4303355906L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerIisWidthValue, str15);
        }
        if ((4295098370L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelValue, str9);
        }
        if ((4295000066L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelbValue, str8);
        }
        if ((j & 4294975490L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelcValue, str10);
        }
        if ((j & 4362076162L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerNoiseSwitch, z7);
        }
        if ((4429447178L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerSourceScl, str11);
        }
        if ((4295229442L & j) != 0) {
            this.triggerSourceScl.setTextColor(i2);
        }
        if ((j & 6442455554L) != 0) {
            TextViewBindingAdapter.setText(this.triggerSourceSclkEdgeValue, str12);
        }
        if ((j & 4831854722L) != 0) {
            TextViewBindingAdapter.setText(this.triggerSourceSda, str13);
        }
        if ((j & 4294983682L) != 0) {
            this.triggerSourceSda.setTextColor(i);
        }
        if ((4295033859L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerSourceWs, str14);
        }
        if ((j & 4295032834L) != 0) {
            this.triggerSourceWs.setTextColor(i3);
        }
    }
}
