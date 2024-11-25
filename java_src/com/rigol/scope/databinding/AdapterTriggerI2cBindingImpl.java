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
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
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
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1657
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterTriggerI2cBindingImpl.executeBindings():void");
    }
}
