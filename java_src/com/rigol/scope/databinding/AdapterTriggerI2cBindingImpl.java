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
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;

/* loaded from: classes2.dex */
public class AdapterTriggerI2cBindingImpl extends AdapterTriggerI2cBinding {
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
        sViewsWithIds.put(R.id.view_2, 30);
        sViewsWithIds.put(R.id.view_3, 31);
        sViewsWithIds.put(R.id.trigger_label, 32);
        sViewsWithIds.put(R.id.button_levelb, 33);
        sViewsWithIds.put(R.id.trigger_levelb, 34);
        sViewsWithIds.put(R.id.trigger_level, 35);
        sViewsWithIds.put(R.id.trigger_source_scl_label, 36);
        sViewsWithIds.put(R.id.trigger_source_sda_label, 37);
        sViewsWithIds.put(R.id.button_level, 38);
        sViewsWithIds.put(R.id.trigger_noise_label, 39);
        sViewsWithIds.put(R.id.view_line_1, 40);
        sViewsWithIds.put(R.id.view_line_2, 41);
    }

    public AdapterTriggerI2cBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 42, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerI2cBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 15, (Button) objArr[38], (Button) objArr[33], (Guideline) objArr[24], (Guideline) objArr[27], (Guideline) objArr[26], (Guideline) objArr[23], (Guideline) objArr[25], (TextView) objArr[7], (TextView) objArr[1], (RadioButton) objArr[12], (RadioButton) objArr[11], (TextView) objArr[8], (EditText) objArr[3], (TextView) objArr[5], (TextView) objArr[6], (RadioButton) objArr[15], (TextView) objArr[10], (EditText) objArr[9], (TextView) objArr[4], (TextView) objArr[2], (RadioButton) objArr[17], (RadioButton) objArr[16], (RadioButton) objArr[13], (RadioButton) objArr[14], (TextView) objArr[32], (TextView) objArr[35], (EditText) objArr[20], (TextView) objArr[34], (EditText) objArr[18], (TextView) objArr[39], (SwitchButton) objArr[22], (TextView) objArr[21], (TextView) objArr[36], (TextView) objArr[19], (TextView) objArr[37], (View) objArr[29], (View) objArr[30], (View) objArr[31], (View) objArr[40], (View) objArr[41], (View) objArr[28]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.triggerAddrWidthLabel.setTag(null);
        this.triggerAddrWidthValue.setTag(null);
        this.triggerI2cAddr.setTag(null);
        this.triggerI2cAddrData.setTag(null);
        this.triggerI2cAddrLabel.setTag(null);
        this.triggerI2cAddrValue.setTag(null);
        this.triggerI2cBytelengthLabel.setTag(null);
        this.triggerI2cBytelengthValue.setTag(null);
        this.triggerI2cData.setTag(null);
        this.triggerI2cDataLabel.setTag(null);
        this.triggerI2cDataValue.setTag(null);
        this.triggerI2cDirectionLabel.setTag(null);
        this.triggerI2cDirectionValue.setTag(null);
        this.triggerI2cMissedAck.setTag(null);
        this.triggerI2cRestart.setTag(null);
        this.triggerI2cStart.setTag(null);
        this.triggerI2cStop.setTag(null);
        this.triggerLevelValue.setTag(null);
        this.triggerLevelbValue.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSourceScl.setTag(null);
        this.triggerSourceSda.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 137438953472L;
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
        if (1049 == i) {
            setWhenAdMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (1059 == i) {
            setWhenMissMapping((MappingObject) obj);
        } else if (1068 == i) {
            setWhenStartMapping((MappingObject) obj);
        } else if (1069 == i) {
            setWhenStopMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (1054 == i) {
            setWhenDataMapping((MappingObject) obj);
        } else if (1050 == i) {
            setWhenAddressMapping((MappingObject) obj);
        } else if (1062 != i) {
            return false;
        } else {
            setWhenRestartMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerI2cBinding
    public void setWhenAdMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mWhenAdMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1049);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerI2cBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(2, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerI2cBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerI2cBinding
    public void setWhenMissMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mWhenMissMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(1059);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerI2cBinding
    public void setWhenStartMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mWhenStartMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(1068);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerI2cBinding
    public void setWhenStopMapping(MappingObject mappingObject) {
        updateRegistration(8, mappingObject);
        this.mWhenStopMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(1069);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerI2cBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerI2cBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerI2cBinding
    public void setWhenDataMapping(MappingObject mappingObject) {
        updateRegistration(12, mappingObject);
        this.mWhenDataMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(1054);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerI2cBinding
    public void setWhenAddressMapping(MappingObject mappingObject) {
        updateRegistration(13, mappingObject);
        this.mWhenAddressMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        notifyPropertyChanged(1050);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerI2cBinding
    public void setWhenRestartMapping(MappingObject mappingObject) {
        updateRegistration(14, mappingObject);
        this.mWhenRestartMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
        }
        notifyPropertyChanged(1062);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeWhenAdMapping((MappingObject) obj, i2);
            case 1:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerI2cSclParamIicChanAValue1((MappingObject) obj, i2);
            case 2:
                return onChangeParam((TriggerParam) obj, i2);
            case 3:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 4:
                return onChangeWhenMissMapping((MappingObject) obj, i2);
            case 5:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerI2cAddrdataBitsParamTriggerI2CSpecValue1((MappingObject) obj, i2);
            case 6:
                return onChangeWhenStartMapping((MappingObject) obj, i2);
            case 7:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerI2cSdaParamIicChanBValue1((MappingObject) obj, i2);
            case 8:
                return onChangeWhenStopMapping((MappingObject) obj, i2);
            case 9:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 10:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 11:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerI2cDirectionParamTriggerI2CWRValue1((MappingObject) obj, i2);
            case 12:
                return onChangeWhenDataMapping((MappingObject) obj, i2);
            case 13:
                return onChangeWhenAddressMapping((MappingObject) obj, i2);
            case 14:
                return onChangeWhenRestartMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeWhenAdMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerI2cSclParamIicChanAValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 959) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 961) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 960) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 386) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 133) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 335) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 416) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 414) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 415) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else if (i == 413) {
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

    private boolean onChangeWhenMissMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerI2cAddrdataBitsParamTriggerI2CSpecValue1(MappingObject mappingObject, int i) {
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

    private boolean onChangeWhenStartMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerI2cSdaParamIicChanBValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
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

    private boolean onChangeWhenStopMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
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

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        }
        return false;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerI2cDirectionParamTriggerI2CWRValue1(MappingObject mappingObject, int i) {
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

    private boolean onChangeWhenDataMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeWhenAddressMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
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

    private boolean onChangeWhenRestartMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 68719476736L;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015f  */
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
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        int i;
        int i2;
        float f;
        String str11;
        String str12;
        String str13;
        String str14;
        boolean z10;
        boolean z11;
        float f2;
        float f3;
        String str15;
        String str16;
        boolean z12;
        float f4;
        long j2;
        String str17;
        int i3;
        String str18;
        String str19;
        int i4;
        String str20;
        String str21;
        boolean z13;
        String str22;
        String str23;
        ServiceEnum.Trigger_I2C_When trigger_I2C_When;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        String str24;
        int i5;
        int i6;
        boolean z23;
        String str25;
        String str26;
        String str27;
        boolean z24;
        float f5;
        long j3;
        int i7;
        int i8;
        long j4;
        ServiceEnum.Chan chan;
        int i9;
        int i10;
        int i11;
        long j5;
        String str28;
        int i12;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mWhenAdMapping;
        TriggerParam triggerParam = this.mParam;
        MappingObject mappingObject2 = this.mWhenMissMapping;
        MappingObject mappingObject3 = this.mWhenStartMapping;
        MappingObject mappingObject4 = this.mWhenStopMapping;
        MappingObject mappingObject5 = this.mWhenDataMapping;
        MappingObject mappingObject6 = this.mWhenAddressMapping;
        MappingObject mappingObject7 = this.mWhenRestartMapping;
        String str29 = null;
        String str30 = ((j & 137438986241L) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        if ((j & 148981614758L) != 0) {
            if ((j & 137506127878L) != 0) {
                ServiceEnum.Chan iicChanA = triggerParam != null ? triggerParam.getIicChanA() : null;
                MappingObject mappingObject8 = ViewUtil.getMappingObject(R.array.msg_trigger_i2c_scl, iicChanA != null ? iicChanA.value1 : 0);
                updateRegistration(1, mappingObject8);
                str17 = mappingObject8 != null ? mappingObject8.getStr() : null;
                j2 = 0;
                if ((j & 137506062340L) != 0) {
                    i3 = ColorUtil.getColor(getRoot().getContext(), iicChanA);
                    if ((j & 137440002052L) == j2) {
                        if (triggerParam != null) {
                            i12 = triggerParam.getI2cAddress();
                            str28 = triggerParam.i2cAddressConvert();
                        } else {
                            str28 = null;
                            i12 = 0;
                        }
                        str18 = ((String.valueOf(i12) + "(0x") + str28) + ")";
                    } else {
                        str18 = null;
                    }
                    String formatValue1Str = ((j & 137443147780L) != 0 || triggerParam == null) ? null : triggerParam.getFormatValue1Str();
                    if ((j & 137472507908L) == 0) {
                        if (triggerParam != null) {
                            str19 = str17;
                            i4 = i3;
                            j5 = triggerParam.getIiclevelA();
                        } else {
                            str19 = str17;
                            i4 = i3;
                            j5 = 0;
                        }
                        if (triggerParam != null) {
                            str20 = triggerParam.getTriggerLevelStr(j5);
                            boolean isNoise = ((j & 137573171204L) != 0 || triggerParam == null) ? false : triggerParam.getIsNoise();
                            if ((j & 137441050628L) != 0) {
                                str21 = String.valueOf(triggerParam != null ? triggerParam.getByteLength() : 0);
                            } else {
                                str21 = null;
                            }
                            if ((j & 137439346692L) != 0) {
                                if (triggerParam != null) {
                                    str3 = str20;
                                    trigger_I2C_When = triggerParam.getTrigger_I2C_When();
                                } else {
                                    str3 = str20;
                                    trigger_I2C_When = null;
                                }
                                int i13 = ((j & 137439215620L) > 0L ? 1 : ((j & 137439215620L) == 0L ? 0 : -1));
                                z13 = isNoise;
                                if (i13 != 0) {
                                    str22 = str18;
                                    z14 = trigger_I2C_When == ServiceEnum.Trigger_I2C_When.trig_i2c_data;
                                    boolean z25 = trigger_I2C_When == ServiceEnum.Trigger_I2C_When.trig_i2c_end;
                                    z18 = trigger_I2C_When == ServiceEnum.Trigger_I2C_When.trig_i2c_addr_data;
                                    z19 = trigger_I2C_When == ServiceEnum.Trigger_I2C_When.trig_i2c_restart;
                                    z20 = trigger_I2C_When == ServiceEnum.Trigger_I2C_When.trig_i2c_nack;
                                    str23 = formatValue1Str;
                                    boolean z26 = trigger_I2C_When == ServiceEnum.Trigger_I2C_When.trig_i2c_addr;
                                    boolean z27 = trigger_I2C_When == ServiceEnum.Trigger_I2C_When.trig_i2c_start;
                                    if (i13 != 0) {
                                        j |= z14 ? 8796093022208L : 4398046511104L;
                                    }
                                    if ((j & 137439215620L) != 0) {
                                        j |= z26 ? 2199023255552L : 1099511627776L;
                                    }
                                    z17 = z27;
                                    z16 = z26;
                                    z15 = z25;
                                    if ((j & 139603214468L) == 0) {
                                        if (triggerParam != null) {
                                            z21 = z14;
                                            chan = triggerParam.getIicChanB();
                                        } else {
                                            z21 = z14;
                                            chan = null;
                                        }
                                        if ((j & 137455730692L) != 0) {
                                            z22 = z15;
                                            i9 = ColorUtil.getColor(getRoot().getContext(), chan);
                                        } else {
                                            z22 = z15;
                                            i9 = 0;
                                        }
                                        if (chan != null) {
                                            i11 = chan.value1;
                                            i10 = i9;
                                        } else {
                                            i10 = i9;
                                            i11 = 0;
                                        }
                                        MappingObject mappingObject9 = ViewUtil.getMappingObject(R.array.msg_trigger_i2c_sda, i11);
                                        updateRegistration(7, mappingObject9);
                                        str24 = mappingObject9 != null ? mappingObject9.getStr() : null;
                                        i5 = i10;
                                    } else {
                                        z21 = z14;
                                        z22 = z15;
                                        str24 = null;
                                        i5 = 0;
                                    }
                                    if ((j & 137447342084L) == 0) {
                                        if (triggerParam != null) {
                                            z23 = z16;
                                            i6 = i5;
                                            j4 = triggerParam.getIiclevelB();
                                        } else {
                                            i6 = i5;
                                            z23 = z16;
                                            j4 = 0;
                                        }
                                        if (triggerParam != null) {
                                            str25 = triggerParam.getTriggerLevelBStr(j4);
                                            if ((j & 146029414404L) != 0) {
                                                ServiceEnum.Trigger_I2C_WR trigger_I2C_WR = triggerParam != null ? triggerParam.getTrigger_I2C_WR() : null;
                                                if (trigger_I2C_WR != null) {
                                                    i8 = trigger_I2C_WR.value1;
                                                    str26 = str24;
                                                } else {
                                                    str26 = str24;
                                                    i8 = 0;
                                                }
                                                MappingObject mappingObject10 = ViewUtil.getMappingObject(R.array.msg_trigger_i2c_direction, i8);
                                                updateRegistration(11, mappingObject10);
                                                if (mappingObject10 != null) {
                                                    str27 = mappingObject10.getStr();
                                                    if ((j & 137976217636L) == 0) {
                                                        ServiceEnum.Trigger_I2C_Spec trigger_I2C_Spec = triggerParam != null ? triggerParam.getTrigger_I2C_Spec() : null;
                                                        if ((j & 137439346692L) != 0) {
                                                            z24 = triggerParam != null ? triggerParam.ReadWriteDirection(trigger_I2C_When, trigger_I2C_Spec) : false;
                                                            f5 = ContextUtil.getAlpha(z24);
                                                        } else {
                                                            z24 = false;
                                                            f5 = 0.0f;
                                                        }
                                                        if ((j & 137975955492L) != 0) {
                                                            if (trigger_I2C_Spec != null) {
                                                                i7 = trigger_I2C_Spec.value1;
                                                                j3 = j;
                                                            } else {
                                                                j3 = j;
                                                                i7 = 0;
                                                            }
                                                            MappingObject mappingObject11 = ViewUtil.getMappingObject(R.array.msg_trigger_i2c_addrdata_bits, i7);
                                                            updateRegistration(5, mappingObject11);
                                                            if (mappingObject11 != null) {
                                                                str10 = str25;
                                                                i = i4;
                                                                z5 = z21;
                                                                z6 = z18;
                                                                str5 = str23;
                                                                i2 = i6;
                                                                str9 = str26;
                                                                str8 = mappingObject11.getStr();
                                                                str2 = str19;
                                                                str6 = str21;
                                                                z8 = z13;
                                                                z7 = z23;
                                                                j = j3;
                                                                f = f5;
                                                                z4 = z22;
                                                                boolean z28 = z20;
                                                                str = str30;
                                                                z = z19;
                                                                str7 = str22;
                                                                z9 = z24;
                                                                z2 = z28;
                                                                boolean z29 = z17;
                                                                str4 = str27;
                                                                z3 = z29;
                                                            }
                                                        } else {
                                                            j3 = j;
                                                        }
                                                        str10 = str25;
                                                        i = i4;
                                                        z5 = z21;
                                                        z6 = z18;
                                                        str5 = str23;
                                                        i2 = i6;
                                                        str9 = str26;
                                                        j = j3;
                                                        str2 = str19;
                                                        str8 = null;
                                                        str6 = str21;
                                                        z8 = z13;
                                                        z7 = z23;
                                                        f = f5;
                                                        z4 = z22;
                                                        boolean z282 = z20;
                                                        str = str30;
                                                        z = z19;
                                                        str7 = str22;
                                                        z9 = z24;
                                                        z2 = z282;
                                                        boolean z292 = z17;
                                                        str4 = str27;
                                                        z3 = z292;
                                                    } else {
                                                        str10 = str25;
                                                        i = i4;
                                                        z5 = z21;
                                                        z6 = z18;
                                                        z2 = z20;
                                                        str5 = str23;
                                                        z4 = z22;
                                                        i2 = i6;
                                                        str9 = str26;
                                                        str = str30;
                                                        str2 = str19;
                                                        str8 = null;
                                                        str6 = str21;
                                                        z8 = z13;
                                                        z = z19;
                                                        z7 = z23;
                                                        f = 0.0f;
                                                        str7 = str22;
                                                        z9 = false;
                                                        boolean z30 = z17;
                                                        str4 = str27;
                                                        z3 = z30;
                                                    }
                                                }
                                            } else {
                                                str26 = str24;
                                            }
                                            str27 = null;
                                            if ((j & 137976217636L) == 0) {
                                            }
                                        }
                                    } else {
                                        i6 = i5;
                                        z23 = z16;
                                    }
                                    str25 = null;
                                    if ((j & 146029414404L) != 0) {
                                    }
                                    str27 = null;
                                    if ((j & 137976217636L) == 0) {
                                    }
                                } else {
                                    str22 = str18;
                                    str23 = formatValue1Str;
                                }
                            } else {
                                str3 = str20;
                                z13 = isNoise;
                                str22 = str18;
                                str23 = formatValue1Str;
                                trigger_I2C_When = null;
                            }
                            z14 = false;
                            z15 = false;
                            z16 = false;
                            z17 = false;
                            z18 = false;
                            z19 = false;
                            z20 = false;
                            if ((j & 139603214468L) == 0) {
                            }
                            if ((j & 137447342084L) == 0) {
                            }
                            str25 = null;
                            if ((j & 146029414404L) != 0) {
                            }
                            str27 = null;
                            if ((j & 137976217636L) == 0) {
                            }
                        }
                    } else {
                        str19 = str17;
                        i4 = i3;
                    }
                    str20 = null;
                    if ((j & 137573171204L) != 0) {
                    }
                    if ((j & 137441050628L) != 0) {
                    }
                    if ((j & 137439346692L) != 0) {
                    }
                    z14 = false;
                    z15 = false;
                    z16 = false;
                    z17 = false;
                    z18 = false;
                    z19 = false;
                    z20 = false;
                    if ((j & 139603214468L) == 0) {
                    }
                    if ((j & 137447342084L) == 0) {
                    }
                    str25 = null;
                    if ((j & 146029414404L) != 0) {
                    }
                    str27 = null;
                    if ((j & 137976217636L) == 0) {
                    }
                }
            } else {
                j2 = 0;
                str17 = null;
            }
            i3 = 0;
            if ((j & 137440002052L) == j2) {
            }
            if ((j & 137443147780L) != 0) {
            }
            if ((j & 137472507908L) == 0) {
            }
            str20 = null;
            if ((j & 137573171204L) != 0) {
            }
            if ((j & 137441050628L) != 0) {
            }
            if ((j & 137439346692L) != 0) {
            }
            z14 = false;
            z15 = false;
            z16 = false;
            z17 = false;
            z18 = false;
            z19 = false;
            z20 = false;
            if ((j & 139603214468L) == 0) {
            }
            if ((j & 137447342084L) == 0) {
            }
            str25 = null;
            if ((j & 146029414404L) != 0) {
            }
            str27 = null;
            if ((j & 137976217636L) == 0) {
            }
        } else {
            str = str30;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
            z8 = false;
            z9 = false;
            i = 0;
            i2 = 0;
            f = 0.0f;
        }
        String str31 = ((j & 137707388944L) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        String str32 = ((j & 138512695360L) == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        String str33 = ((j & 141733921024L) == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        String str34 = ((j & 154618826752L) == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        String str35 = ((j & 171798700032L) == 0 || mappingObject6 == null) ? null : mappingObject6.getStr();
        if ((j & 206158446592L) != 0 && mappingObject7 != null) {
            str29 = mappingObject7.getStr();
        }
        String str36 = str29;
        int i14 = ((j & 137439215620L) > 0L ? 1 : ((j & 137439215620L) == 0L ? 0 : -1));
        if (i14 != 0) {
            boolean z31 = z7 ? true : z6;
            boolean z32 = z5 ? true : z6;
            if (i14 != 0) {
                j |= z31 ? 549755813888L : 274877906944L;
            }
            float alpha = ContextUtil.getAlpha(z31);
            str11 = str31;
            f2 = ContextUtil.getAlpha(z32);
            boolean z33 = z31;
            str12 = str32;
            z10 = z33;
            str13 = str33;
            f3 = alpha;
            boolean z34 = z32;
            str14 = str36;
            z11 = z34;
        } else {
            str11 = str31;
            str12 = str32;
            str13 = str33;
            str14 = str36;
            z10 = false;
            z11 = false;
            f2 = 0.0f;
            f3 = 0.0f;
        }
        int i15 = ((j & 137439215620L) > 0L ? 1 : ((j & 137439215620L) == 0L ? 0 : -1));
        if (i15 != 0) {
            boolean z35 = z10 ? true : z5;
            str16 = str35;
            z12 = z35;
            str15 = str34;
            f4 = ContextUtil.getAlpha(z35);
        } else {
            str15 = str34;
            str16 = str35;
            z12 = false;
            f4 = 0.0f;
        }
        long j6 = j;
        if (i15 != 0) {
            this.triggerAddrWidthLabel.setEnabled(z12);
            this.triggerAddrWidthValue.setEnabled(z12);
            CompoundButtonBindingAdapter.setChecked(this.triggerI2cAddr, z7);
            CompoundButtonBindingAdapter.setChecked(this.triggerI2cAddrData, z6);
            this.triggerI2cAddrLabel.setEnabled(z10);
            this.triggerI2cAddrValue.setEnabled(z10);
            this.triggerI2cBytelengthLabel.setEnabled(z11);
            this.triggerI2cBytelengthValue.setEnabled(z11);
            CompoundButtonBindingAdapter.setChecked(this.triggerI2cData, z5);
            this.triggerI2cDataLabel.setEnabled(z11);
            this.triggerI2cDataValue.setEnabled(z11);
            CompoundButtonBindingAdapter.setChecked(this.triggerI2cMissedAck, z2);
            CompoundButtonBindingAdapter.setChecked(this.triggerI2cRestart, z);
            CompoundButtonBindingAdapter.setChecked(this.triggerI2cStart, z3);
            CompoundButtonBindingAdapter.setChecked(this.triggerI2cStop, z4);
            if (getBuildSdkInt() >= 11) {
                this.triggerAddrWidthLabel.setAlpha(f4);
                this.triggerAddrWidthValue.setAlpha(f4);
                this.triggerI2cAddrLabel.setAlpha(f3);
                this.triggerI2cAddrValue.setAlpha(f3);
                this.triggerI2cBytelengthLabel.setAlpha(f2);
                this.triggerI2cBytelengthValue.setAlpha(f2);
                this.triggerI2cDataLabel.setAlpha(f2);
                this.triggerI2cDataValue.setAlpha(f2);
            }
        }
        if ((j6 & 137975955492L) != 0) {
            TextViewBindingAdapter.setText(this.triggerAddrWidthValue, str8);
        }
        if ((j6 & 171798700032L) != 0) {
            TextViewBindingAdapter.setText(this.triggerI2cAddr, str16);
        }
        if ((j6 & 137438986241L) != 0) {
            TextViewBindingAdapter.setText(this.triggerI2cAddrData, str);
        }
        if ((j6 & 137440002052L) != 0) {
            TextViewBindingAdapter.setText(this.triggerI2cAddrValue, str7);
        }
        if ((j6 & 137441050628L) != 0) {
            TextViewBindingAdapter.setText(this.triggerI2cBytelengthValue, str6);
        }
        if ((j6 & 154618826752L) != 0) {
            TextViewBindingAdapter.setText(this.triggerI2cData, str15);
        }
        if ((j6 & 137443147780L) != 0) {
            TextViewBindingAdapter.setText(this.triggerI2cDataValue, str5);
        }
        if ((j6 & 137439346692L) != 0) {
            boolean z36 = z9;
            this.triggerI2cDirectionLabel.setEnabled(z36);
            this.triggerI2cDirectionValue.setEnabled(z36);
            if (getBuildSdkInt() >= 11) {
                float f6 = f;
                this.triggerI2cDirectionLabel.setAlpha(f6);
                this.triggerI2cDirectionValue.setAlpha(f6);
            }
        }
        if ((j6 & 146029414404L) != 0) {
            TextViewBindingAdapter.setText(this.triggerI2cDirectionValue, str4);
        }
        if ((j6 & 137707388944L) != 0) {
            TextViewBindingAdapter.setText(this.triggerI2cMissedAck, str11);
        }
        if ((j6 & 206158446592L) != 0) {
            TextViewBindingAdapter.setText(this.triggerI2cRestart, str14);
        }
        if ((j6 & 138512695360L) != 0) {
            TextViewBindingAdapter.setText(this.triggerI2cStart, str12);
        }
        if ((j6 & 141733921024L) != 0) {
            TextViewBindingAdapter.setText(this.triggerI2cStop, str13);
        }
        if ((j6 & 137472507908L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelValue, str3);
        }
        if ((j6 & 137447342084L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelbValue, str10);
        }
        if ((j6 & 137573171204L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerNoiseSwitch, z8);
        }
        if ((j6 & 137506127878L) != 0) {
            TextViewBindingAdapter.setText(this.triggerSourceScl, str2);
        }
        if ((j6 & 137506062340L) != 0) {
            this.triggerSourceScl.setTextColor(i);
        }
        if ((j6 & 139603214468L) != 0) {
            TextViewBindingAdapter.setText(this.triggerSourceSda, str9);
        }
        if ((j6 & 137455730692L) != 0) {
            this.triggerSourceSda.setTextColor(i2);
        }
    }
}
