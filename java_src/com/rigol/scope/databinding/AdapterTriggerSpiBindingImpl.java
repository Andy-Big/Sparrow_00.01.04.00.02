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
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterTriggerSpiBindingImpl.executeBindings():void");
    }
}
