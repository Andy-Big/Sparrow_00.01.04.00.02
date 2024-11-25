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
public class AdapterTriggerFlexrayBindingImpl extends AdapterTriggerFlexrayBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private long mDirtyFlags_1;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 36);
        sViewsWithIds.put(R.id.guideline_center, 37);
        sViewsWithIds.put(R.id.guideline_right, 38);
        sViewsWithIds.put(R.id.guideline_forth, 39);
        sViewsWithIds.put(R.id.guideline_fifth, 40);
        sViewsWithIds.put(R.id.guideline_special_1, 41);
        sViewsWithIds.put(R.id.guideline_special_2, 42);
        sViewsWithIds.put(R.id.view_top, 43);
        sViewsWithIds.put(R.id.view_2, 44);
        sViewsWithIds.put(R.id.layout2_guideline_left, 45);
        sViewsWithIds.put(R.id.layout2_guideline_center, 46);
        sViewsWithIds.put(R.id.layout2_guideline_right, 47);
        sViewsWithIds.put(R.id.layout2_guideline_forth, 48);
        sViewsWithIds.put(R.id.layout2_guideline_fifth, 49);
        sViewsWithIds.put(R.id.layout2_guideline_special_1, 50);
        sViewsWithIds.put(R.id.layout2_guideline_special_2, 51);
        sViewsWithIds.put(R.id.trigger_label, 52);
        sViewsWithIds.put(R.id.trigger_baud_label, 53);
        sViewsWithIds.put(R.id.trigger_level, 54);
        sViewsWithIds.put(R.id.trigger_source_label, 55);
        sViewsWithIds.put(R.id.trigger_source_label2, 56);
        sViewsWithIds.put(R.id.trigger_chan_ab_label, 57);
        sViewsWithIds.put(R.id.button_level, 58);
        sViewsWithIds.put(R.id.trigger_noise_label, 59);
        sViewsWithIds.put(R.id.view_line_1, 60);
        sViewsWithIds.put(R.id.view_line_2, 61);
    }

    public AdapterTriggerFlexrayBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 62, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerFlexrayBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 20, (Button) objArr[58], (Guideline) objArr[37], (Guideline) objArr[40], (Guideline) objArr[39], (Guideline) objArr[36], (Guideline) objArr[38], (Guideline) objArr[41], (Guideline) objArr[42], (Guideline) objArr[46], (Guideline) objArr[49], (Guideline) objArr[48], (Guideline) objArr[45], (Guideline) objArr[47], (Guideline) objArr[50], (Guideline) objArr[51], (TextView) objArr[53], (TextView) objArr[30], (TextView) objArr[57], (RadioButton) objArr[33], (RadioButton) objArr[34], (TextView) objArr[6], (EditText) objArr[5], (TextView) objArr[11], (EditText) objArr[12], (TextView) objArr[4], (TextView) objArr[3], (RadioButton) objArr[27], (RadioButton) objArr[28], (TextView) objArr[29], (RadioButton) objArr[16], (TextView) objArr[21], (TextView) objArr[22], (RadioButton) objArr[17], (TextView) objArr[23], (TextView) objArr[24], (TextView) objArr[10], (TextView) objArr[9], (RadioButton) objArr[15], (TextView) objArr[19], (TextView) objArr[20], (RadioButton) objArr[18], (TextView) objArr[25], (TextView) objArr[26], (TextView) objArr[52], (TextView) objArr[54], (EditText) objArr[31], (TextView) objArr[59], (SwitchButton) objArr[35], (TextView) objArr[32], (TextView) objArr[55], (TextView) objArr[56], (TextView) objArr[8], (EditText) objArr[7], (TextView) objArr[13], (EditText) objArr[14], (ConstraintLayout) objArr[44], (View) objArr[1], (View) objArr[2], (View) objArr[60], (View) objArr[61], (View) objArr[43]);
        this.mDirtyFlags = -1L;
        this.mDirtyFlags_1 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.triggerBaudValue.setTag(null);
        this.triggerChanceAValue.setTag(null);
        this.triggerChanceBValue.setTag(null);
        this.triggerDownLimitCycLabel.setTag(null);
        this.triggerDownLimitCycValue.setTag(null);
        this.triggerDownLimitIdLabel.setTag(null);
        this.triggerDownLimitIdValue.setTag(null);
        this.triggerFlexrayCycCompLabel.setTag(null);
        this.triggerFlexrayCycCompValue.setTag(null);
        this.triggerFlexrayDefineCyc.setTag(null);
        this.triggerFlexrayDefineId.setTag(null);
        this.triggerFlexrayDefineLabel.setTag(null);
        this.triggerFlexrayError.setTag(null);
        this.triggerFlexrayErrorLabel.setTag(null);
        this.triggerFlexrayErrorValue.setTag(null);
        this.triggerFlexrayFrame.setTag(null);
        this.triggerFlexrayFrameLabel.setTag(null);
        this.triggerFlexrayFrameValue.setTag(null);
        this.triggerFlexrayIdCompLabel.setTag(null);
        this.triggerFlexrayIdCompValue.setTag(null);
        this.triggerFlexrayPost.setTag(null);
        this.triggerFlexrayPostTypeLabel.setTag(null);
        this.triggerFlexrayPostTypeValue.setTag(null);
        this.triggerFlexraySymbol.setTag(null);
        this.triggerFlexraySymbolLabel.setTag(null);
        this.triggerFlexraySymbolValue.setTag(null);
        this.triggerLevelValue.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSource.setTag(null);
        this.triggerUpLimitCycLabel.setTag(null);
        this.triggerUpLimitCycValue.setTag(null);
        this.triggerUpLimitIdLabel.setTag(null);
        this.triggerUpLimitIdValue.setTag(null);
        this.view3.setTag(null);
        this.view4.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 9007199254740992L;
            this.mDirtyFlags_1 = 0L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags == 0 && this.mDirtyFlags_1 == 0) {
                return false;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (170 == i) {
            setChanceBMapping((MappingObject) obj);
        } else if (1055 == i) {
            setWhenErrorMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (1056 == i) {
            setWhenFrameMapping((MappingObject) obj);
        } else if (169 == i) {
            setChanceAMapping((MappingObject) obj);
        } else if (1061 == i) {
            setWhenPostMapping((MappingObject) obj);
        } else if (226 == i) {
            setDefineCycMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (1070 != i) {
            return false;
        } else {
            setWhenSymbolMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerFlexrayBinding
    public void setChanceBMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mChanceBMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(170);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerFlexrayBinding
    public void setWhenErrorMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mWhenErrorMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(1055);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerFlexrayBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerFlexrayBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerFlexrayBinding
    public void setWhenFrameMapping(MappingObject mappingObject) {
        updateRegistration(10, mappingObject);
        this.mWhenFrameMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(1056);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerFlexrayBinding
    public void setChanceAMapping(MappingObject mappingObject) {
        updateRegistration(13, mappingObject);
        this.mChanceAMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        notifyPropertyChanged(169);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerFlexrayBinding
    public void setWhenPostMapping(MappingObject mappingObject) {
        updateRegistration(14, mappingObject);
        this.mWhenPostMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
        }
        notifyPropertyChanged(1061);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerFlexrayBinding
    public void setDefineCycMapping(MappingObject mappingObject) {
        updateRegistration(15, mappingObject);
        this.mDefineCycMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(226);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerFlexrayBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(16, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerFlexrayBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerFlexrayBinding
    public void setWhenSymbolMapping(MappingObject mappingObject) {
        updateRegistration(19, mappingObject);
        this.mWhenSymbolMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        notifyPropertyChanged(1070);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerFlexrayDefineInt0((MappingObject) obj, i2);
            case 1:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerIisWhenParamTriggerIISDataCmpCycValue1((MappingObject) obj, i2);
            case 2:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerIisWhenParamTriggerIISDataCmpIDValue1((MappingObject) obj, i2);
            case 3:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerFlexraySymbolTypeParamTriggerFlexSymbolValue1((MappingObject) obj, i2);
            case 4:
                return onChangeChanceBMapping((MappingObject) obj, i2);
            case 5:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerFlexrayPostTypeParamTriggerFlexPosValue1((MappingObject) obj, i2);
            case 6:
                return onChangeWhenErrorMapping((MappingObject) obj, i2);
            case 7:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceParamChanValue1((MappingObject) obj, i2);
            case 8:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 9:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 10:
                return onChangeWhenFrameMapping((MappingObject) obj, i2);
            case 11:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerFlexrayErrorTypeParamTriggerFlexErrValue1((MappingObject) obj, i2);
            case 12:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerFlexrayFrameTypeParamTriggerFlexFrameValue1((MappingObject) obj, i2);
            case 13:
                return onChangeChanceAMapping((MappingObject) obj, i2);
            case 14:
                return onChangeWhenPostMapping((MappingObject) obj, i2);
            case 15:
                return onChangeDefineCycMapping((MappingObject) obj, i2);
            case 16:
                return onChangeParam((TriggerParam) obj, i2);
            case 17:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 18:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerFlexrayBaudParamTriggerFlexBaudValue1((MappingObject) obj, i2);
            case 19:
                return onChangeWhenSymbolMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerFlexrayDefineInt0(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerIisWhenParamTriggerIISDataCmpCycValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerIisWhenParamTriggerIISDataCmpIDValue1(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerFlexraySymbolTypeParamTriggerFlexSymbolValue1(MappingObject mappingObject, int i) {
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

    private boolean onChangeChanceBMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerFlexrayPostTypeParamTriggerFlexPosValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    private boolean onChangeWhenErrorMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
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
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeWhenFrameMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerFlexrayErrorTypeParamTriggerFlexErrValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerFlexrayFrameTypeParamTriggerFlexFrameValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
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

    private boolean onChangeChanceAMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
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

    private boolean onChangeWhenPostMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
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

    private boolean onChangeDefineCycMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
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

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 958) {
            synchronized (this) {
                this.mDirtyFlags |= 17179869184L;
            }
            return true;
        } else if (i == 225) {
            synchronized (this) {
                this.mDirtyFlags |= 34359738368L;
            }
            return true;
        } else if (i == 965) {
            synchronized (this) {
                this.mDirtyFlags |= 68719476736L;
            }
            return true;
        } else if (i == 186) {
            synchronized (this) {
                this.mDirtyFlags |= 137438953472L;
            }
            return true;
        } else if (i == 187) {
            synchronized (this) {
                this.mDirtyFlags |= 274877906944L;
            }
            return true;
        } else if (i == 966) {
            synchronized (this) {
                this.mDirtyFlags |= 549755813888L;
            }
            return true;
        } else if (i == 409) {
            synchronized (this) {
                this.mDirtyFlags |= 1099511627776L;
            }
            return true;
        } else if (i == 410) {
            synchronized (this) {
                this.mDirtyFlags |= 2199023255552L;
            }
            return true;
        } else if (i == 956) {
            synchronized (this) {
                this.mDirtyFlags |= 4398046511104L;
            }
            return true;
        } else if (i == 953) {
            synchronized (this) {
                this.mDirtyFlags |= 8796093022208L;
            }
            return true;
        } else if (i == 954) {
            synchronized (this) {
                this.mDirtyFlags |= 17592186044416L;
            }
            return true;
        } else if (i == 957) {
            synchronized (this) {
                this.mDirtyFlags |= 35184372088832L;
            }
            return true;
        } else if (i == 952) {
            synchronized (this) {
                this.mDirtyFlags |= 70368744177664L;
            }
            return true;
        } else if (i == 484) {
            synchronized (this) {
                this.mDirtyFlags |= 140737488355328L;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= 281474976710656L;
            }
            return true;
        } else if (i == 955) {
            synchronized (this) {
                this.mDirtyFlags |= 562949953421312L;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= 1125899906842624L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepAutoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerFlexrayBaudParamTriggerFlexBaudValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 2251799813685248L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeWhenSymbolMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 4503599627370496L;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:653:0x0a64, code lost:
        if (r12 != false) goto L436;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x05df  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x0878  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x089c  */
    /* JADX WARN: Removed duplicated region for block: B:521:0x08bd  */
    /* JADX WARN: Removed duplicated region for block: B:524:0x08c7  */
    /* JADX WARN: Removed duplicated region for block: B:530:0x08d6  */
    /* JADX WARN: Removed duplicated region for block: B:536:0x08e5  */
    /* JADX WARN: Removed duplicated region for block: B:541:0x08f4  */
    /* JADX WARN: Removed duplicated region for block: B:547:0x0909  */
    /* JADX WARN: Removed duplicated region for block: B:553:0x091e  */
    /* JADX WARN: Removed duplicated region for block: B:565:0x0942  */
    /* JADX WARN: Removed duplicated region for block: B:569:0x094e  */
    /* JADX WARN: Removed duplicated region for block: B:608:0x09e3  */
    /* JADX WARN: Removed duplicated region for block: B:645:0x0a49  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01f1  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 3430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterTriggerFlexrayBindingImpl.executeBindings():void");
    }
}
