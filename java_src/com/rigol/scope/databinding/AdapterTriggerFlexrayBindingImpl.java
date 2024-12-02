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
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

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
    */
    protected void executeBindings() {
        long j;
        long j2;
        String str;
        String str2;
        long j3;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        ServiceEnum.Trigger_Flex_When trigger_Flex_When;
        String str8;
        String str9;
        String str10;
        String str11;
        ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp;
        ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp2;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i;
        boolean z8;
        boolean z9;
        int i2;
        int i3;
        int i4;
        int i5;
        String str19;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z18;
        int i10;
        int i11;
        int i12;
        String str20;
        boolean z19;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z20;
        int i20;
        int i21;
        boolean z21;
        int i22;
        int i23;
        int i24;
        int i25;
        long j4;
        long j5;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        boolean z22;
        boolean z23;
        String str29;
        boolean z24;
        boolean z25;
        String str30;
        String str31;
        String str32;
        ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp3;
        String str33;
        String str34;
        String str35;
        String str36;
        String str37;
        String str38;
        String str39;
        String str40;
        long j6;
        String str41;
        int i26;
        String str42;
        String str43;
        int i27;
        ServiceEnum.Trigger_Flex_When trigger_Flex_When2;
        boolean z26;
        boolean z27;
        boolean z28;
        int i28;
        boolean z29;
        int i29;
        int i30;
        int i31;
        boolean z30;
        boolean z31;
        ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp4;
        String str44;
        String str45;
        String str46;
        ServiceEnum.Trigger_Flex_Baud trigger_Flex_Baud;
        int i32;
        ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp5;
        ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp6;
        int i33;
        boolean z32;
        int i34;
        int i35;
        int i36;
        boolean z33;
        int i37;
        long j7;
        int i38;
        int i39;
        ServiceEnum.Trigger_Flex_Pos trigger_Flex_Pos;
        int i40;
        ServiceEnum.Trigger_Flex_Phy trigger_Flex_Phy;
        int i41;
        long j8;
        long j9;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
            j2 = this.mDirtyFlags_1;
            this.mDirtyFlags_1 = 0L;
        }
        MappingObject mappingObject = this.mChanceBMapping;
        MappingObject mappingObject2 = this.mWhenErrorMapping;
        MappingObject mappingObject3 = this.mWhenFrameMapping;
        MappingObject mappingObject4 = this.mChanceAMapping;
        MappingObject mappingObject5 = this.mWhenPostMapping;
        MappingObject mappingObject6 = this.mDefineCycMapping;
        TriggerParam triggerParam = this.mParam;
        MappingObject mappingObject7 = this.mWhenSymbolMapping;
        String str47 = null;
        String str48 = ((9007199271518224L & j) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        String str49 = ((j & 9007199321849920L) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        String str50 = ((j & 9007199523177472L) == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        String str51 = ((j & 9007201402232832L) == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        String str52 = (j & 9007199255789568L) != 0 ? ViewUtil.getMappingObject(R.array.msg_trigger_flexray_define, 0).getStr() : null;
        String str53 = ((j & 9007203549724672L) == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        String str54 = ((j & 9007207844708352L) == 0 || mappingObject6 == null) ? null : mappingObject6.getStr();
        if ((j & 13510783495641262L) != 0) {
            if ((j & 9009398278062080L) != 0) {
                str21 = String.valueOf(triggerParam != null ? triggerParam.getIdUperLimit() : 0L);
            } else {
                str21 = null;
            }
            if ((j & 9007336693760000L) != 0) {
                if (triggerParam != null) {
                    str22 = str21;
                    str = str52;
                    j9 = triggerParam.getCompareLowerLimit();
                } else {
                    str = str52;
                    str22 = str21;
                    j9 = 0;
                }
                str2 = str53;
                str23 = UnitFormat.newBuilder(" 0.###  ", UnitFormat.SI.NONE).convert(j9, ServiceEnum.Unit.Unit_none);
            } else {
                str = str52;
                str2 = str53;
                str22 = str21;
                str23 = null;
            }
            if ((j & 9147936743161856L) != 0) {
                if (triggerParam != null) {
                    str24 = str23;
                    j8 = triggerParam.getLevel();
                } else {
                    str24 = str23;
                    j8 = 0;
                }
                if (triggerParam != null) {
                    str25 = triggerParam.getTriggerLevelStr(j8);
                    boolean isNoise = ((j & 10133099161649152L) != 0 || triggerParam == null) ? false : triggerParam.getIsNoise();
                    if ((j & 9024792514596864L) == 0) {
                        ServiceEnum.Trigger_Flex_Frame trigger_Flex_Frame = triggerParam != null ? triggerParam.getTrigger_Flex_Frame() : null;
                        if (trigger_Flex_Frame != null) {
                            i41 = trigger_Flex_Frame.value1;
                            str26 = str25;
                        } else {
                            str26 = str25;
                            i41 = 0;
                        }
                        MappingObject mappingObject8 = ViewUtil.getMappingObject(R.array.msg_trigger_flexray_frame_type, i41);
                        updateRegistration(12, mappingObject8);
                        if (mappingObject8 != null) {
                            str27 = mappingObject8.getStr();
                            if ((j & 9570149208227840L) != 0) {
                                if (triggerParam != null) {
                                    trigger_Flex_Phy = triggerParam.getTrigger_Flex_Phy();
                                    str28 = str27;
                                } else {
                                    str28 = str27;
                                    trigger_Flex_Phy = null;
                                }
                                z23 = trigger_Flex_Phy == ServiceEnum.Trigger_Flex_Phy.trig_flex_chb;
                                z22 = trigger_Flex_Phy == ServiceEnum.Trigger_Flex_Phy.trig_flex_cha;
                            } else {
                                str28 = str27;
                                z22 = false;
                                z23 = false;
                            }
                            if ((j & 9008298766434304L) != 0) {
                                str29 = String.valueOf(triggerParam != null ? triggerParam.getIdLowerLimit() : 0L);
                            } else {
                                str29 = null;
                            }
                            if ((j & 9011597334872096L) != 0) {
                                if (triggerParam != null) {
                                    z24 = z22;
                                    trigger_Flex_Pos = triggerParam.getTrigger_Flex_Pos();
                                } else {
                                    z24 = z22;
                                    trigger_Flex_Pos = null;
                                }
                                if (trigger_Flex_Pos != null) {
                                    i40 = trigger_Flex_Pos.value1;
                                    z25 = isNoise;
                                } else {
                                    z25 = isNoise;
                                    i40 = 0;
                                }
                                MappingObject mappingObject9 = ViewUtil.getMappingObject(R.array.msg_trigger_flexray_post_type, i40);
                                updateRegistration(5, mappingObject9);
                                if (mappingObject9 != null) {
                                    str30 = mappingObject9.getStr();
                                    if ((j & 9007267976380418L) == 0) {
                                        ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp_Cyc = triggerParam != null ? triggerParam.getTrigger_IIS_data_cmp_Cyc() : null;
                                        str31 = str30;
                                        if (trigger_IIS_data_cmp_Cyc != null) {
                                            i39 = trigger_IIS_data_cmp_Cyc.value1;
                                            trigger_IIS_data_cmp3 = trigger_IIS_data_cmp_Cyc;
                                        } else {
                                            trigger_IIS_data_cmp3 = trigger_IIS_data_cmp_Cyc;
                                            i39 = 0;
                                        }
                                        MappingObject mappingObject10 = ViewUtil.getMappingObject(R.array.msg_trigger_iis_when, i39);
                                        updateRegistration(1, mappingObject10);
                                        str32 = mappingObject10 != null ? mappingObject10.getStr() : null;
                                    } else {
                                        str31 = str30;
                                        str32 = null;
                                        trigger_IIS_data_cmp3 = null;
                                    }
                                    if ((j & 9015995884701696L) == 0) {
                                        ServiceEnum.Trigger_Flex_Err trigger_Flex_Err = triggerParam != null ? triggerParam.getTrigger_Flex_Err() : null;
                                        if (trigger_Flex_Err != null) {
                                            i38 = trigger_Flex_Err.value1;
                                            str33 = str32;
                                        } else {
                                            str33 = str32;
                                            i38 = 0;
                                        }
                                        MappingObject mappingObject11 = ViewUtil.getMappingObject(R.array.msg_trigger_flexray_error_type, i38);
                                        updateRegistration(11, mappingObject11);
                                        if (mappingObject11 != null) {
                                            str34 = mappingObject11.getStr();
                                            if ((j & 9007474132713472L) != 0) {
                                                if (triggerParam != null) {
                                                    str35 = str34;
                                                    str36 = str24;
                                                    j7 = triggerParam.getCompareUperLimit();
                                                } else {
                                                    str35 = str34;
                                                    str36 = str24;
                                                    j7 = 0;
                                                }
                                                str37 = str29;
                                                str38 = UnitFormat.newBuilder(" 0.###  ", UnitFormat.SI.NONE).convert(j7, ServiceEnum.Unit.Unit_none);
                                            } else {
                                                str35 = str34;
                                                str36 = str24;
                                                str37 = str29;
                                                str38 = null;
                                            }
                                            if ((j & 9042383635283976L) != 0) {
                                                ServiceEnum.Trigger_Flex_Symbol trigger_Flex_Symbol = triggerParam != null ? triggerParam.getTrigger_Flex_Symbol() : null;
                                                MappingObject mappingObject12 = ViewUtil.getMappingObject(R.array.msg_trigger_flexray_symbol_type, trigger_Flex_Symbol != null ? trigger_Flex_Symbol.value1 : 0);
                                                updateRegistration(3, mappingObject12);
                                                if (mappingObject12 != null) {
                                                    str39 = mappingObject12.getStr();
                                                    if ((j & 9288674365735040L) == 0) {
                                                        ServiceEnum.Chan chan = triggerParam != null ? triggerParam.getChan() : null;
                                                        if (chan != null) {
                                                            i37 = chan.value1;
                                                            str40 = str38;
                                                        } else {
                                                            str40 = str38;
                                                            i37 = 0;
                                                        }
                                                        MappingObject mappingObject13 = ViewUtil.getMappingObject(R.array.msg_trigger_source, i37);
                                                        updateRegistration(7, mappingObject13);
                                                        str41 = mappingObject13 != null ? mappingObject13.getStr() : null;
                                                        j6 = 0;
                                                        if ((j & 9288674231517184L) != 0) {
                                                            i26 = ColorUtil.getColor(getRoot().getContext(), chan);
                                                            if ((j & 9007869269704704L) != j6) {
                                                                trigger_Flex_When2 = triggerParam != null ? triggerParam.getTrigger_Flex_When() : null;
                                                                if ((j & 9007216434675712L) != j6) {
                                                                    str42 = str41;
                                                                    str43 = str39;
                                                                    boolean z34 = trigger_Flex_When2 == ServiceEnum.Trigger_Flex_When.trig_flex_symbol;
                                                                    i27 = i26;
                                                                    z32 = trigger_Flex_When2 == ServiceEnum.Trigger_Flex_When.trig_flex_frame;
                                                                    z29 = trigger_Flex_When2 == ServiceEnum.Trigger_Flex_When.trig_flex_err;
                                                                    if ((j2 & 1099511627776L) != 0) {
                                                                        j = z34 ? j | 36028797018963968L : j | 18014398509481984L;
                                                                    }
                                                                    if ((j2 & PlaybackStateCompat.ACTION_PREPARE) != 0) {
                                                                        j2 = z34 ? j2 | 128 : j2 | 64;
                                                                    }
                                                                    int i42 = ((j & 9007216434675712L) > 0L ? 1 : ((j & 9007216434675712L) == 0L ? 0 : -1));
                                                                    if (i42 != 0) {
                                                                        j2 |= z34 ? PlaybackStateCompat.ACTION_PREPARE_FROM_URI : PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                                                                    }
                                                                    if ((j2 & 83886080) != 0) {
                                                                        j2 = z34 ? j2 | 8589934592L : j2 | 4294967296L;
                                                                    }
                                                                    if (i42 != 0) {
                                                                        j2 |= z32 ? 512L : 256L;
                                                                    }
                                                                    if (i42 != 0) {
                                                                        j2 |= z29 ? PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                                                                    }
                                                                    i34 = z34 ? 0 : 8;
                                                                    i35 = z32 ? 0 : 8;
                                                                    i36 = z29 ? 0 : 8;
                                                                    z33 = z34;
                                                                } else {
                                                                    str42 = str41;
                                                                    str43 = str39;
                                                                    i27 = i26;
                                                                    z32 = false;
                                                                    z29 = false;
                                                                    i34 = 0;
                                                                    i35 = 0;
                                                                    i36 = 0;
                                                                    z33 = false;
                                                                }
                                                                boolean z35 = trigger_Flex_When2 == ServiceEnum.Trigger_Flex_When.trig_flex_pos;
                                                                if ((j & 9007319513890816L) != 0) {
                                                                    j |= z35 ? LockFreeTaskQueueCore.CLOSED_MASK : LockFreeTaskQueueCore.FROZEN_MASK;
                                                                }
                                                                int i43 = ((j & 9007216434675712L) > 0L ? 1 : ((j & 9007216434675712L) == 0L ? 0 : -1));
                                                                if (i43 != 0) {
                                                                    j2 |= z35 ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                                                                }
                                                                if ((j & 9007800550227968L) != 0) {
                                                                    j2 |= z35 ? 549755813888L : 274877906944L;
                                                                }
                                                                i31 = (i43 == 0 || z35) ? 0 : 8;
                                                                boolean z36 = z32;
                                                                z27 = z35;
                                                                z26 = z33;
                                                                i30 = i36;
                                                                i29 = i35;
                                                                long j10 = j2;
                                                                z28 = z36;
                                                                i28 = i34;
                                                                j3 = j10;
                                                            } else {
                                                                str42 = str41;
                                                                str43 = str39;
                                                                i27 = i26;
                                                                j3 = j2;
                                                                trigger_Flex_When2 = null;
                                                                z26 = false;
                                                                z27 = false;
                                                                z28 = false;
                                                                i28 = 0;
                                                                z29 = false;
                                                                i29 = 0;
                                                                i30 = 0;
                                                                i31 = 0;
                                                            }
                                                            if ((j & 9007749014814724L) != 0) {
                                                                if (triggerParam != null) {
                                                                    z30 = z26;
                                                                    trigger_IIS_data_cmp5 = triggerParam.getTrigger_IIS_data_cmp_ID();
                                                                } else {
                                                                    z30 = z26;
                                                                    trigger_IIS_data_cmp5 = null;
                                                                }
                                                                z31 = z27;
                                                                if (trigger_IIS_data_cmp5 != null) {
                                                                    i33 = trigger_IIS_data_cmp5.value1;
                                                                    trigger_IIS_data_cmp6 = trigger_IIS_data_cmp5;
                                                                } else {
                                                                    trigger_IIS_data_cmp6 = trigger_IIS_data_cmp5;
                                                                    i33 = 0;
                                                                }
                                                                MappingObject mappingObject14 = ViewUtil.getMappingObject(R.array.msg_trigger_iis_when, i33);
                                                                updateRegistration(2, mappingObject14);
                                                                str44 = mappingObject14 != null ? mappingObject14.getStr() : null;
                                                                trigger_IIS_data_cmp4 = trigger_IIS_data_cmp6;
                                                            } else {
                                                                z30 = z26;
                                                                z31 = z27;
                                                                trigger_IIS_data_cmp4 = null;
                                                                str44 = null;
                                                            }
                                                            if ((j & 11329367812931584L) != 0) {
                                                                if (triggerParam != null) {
                                                                    trigger_IIS_data_cmp2 = trigger_IIS_data_cmp4;
                                                                    trigger_Flex_Baud = triggerParam.getTrigger_Flex_Baud();
                                                                } else {
                                                                    trigger_IIS_data_cmp2 = trigger_IIS_data_cmp4;
                                                                    trigger_Flex_Baud = null;
                                                                }
                                                                if (trigger_Flex_Baud != null) {
                                                                    i32 = trigger_Flex_Baud.value1;
                                                                    str45 = str44;
                                                                } else {
                                                                    str45 = str44;
                                                                    i32 = 0;
                                                                }
                                                                MappingObject mappingObject15 = ViewUtil.getMappingObject(R.array.msg_trigger_flexray_baud, i32);
                                                                updateRegistration(18, mappingObject15);
                                                                if (mappingObject15 != null) {
                                                                    str46 = mappingObject15.getStr();
                                                                    if ((j & 9007233614544896L) == 0) {
                                                                        boolean isDefine = triggerParam != null ? triggerParam.isDefine() : false;
                                                                        if ((j3 & 4194304) != 0) {
                                                                            j |= isDefine ? 576460752303423488L : 288230376151711744L;
                                                                        }
                                                                        if ((j & 18014398509481984L) != 0) {
                                                                            j |= isDefine ? Long.MIN_VALUE : 4611686018427387904L;
                                                                        }
                                                                        if ((j3 & 64) != 0) {
                                                                            j3 = isDefine ? j3 | 32 : j3 | 16;
                                                                        }
                                                                        if ((j3 & 268435456) != 0) {
                                                                            j3 |= isDefine ? 34359738368L : 17179869184L;
                                                                        }
                                                                        if ((j3 & 1) != 0) {
                                                                            j3 |= isDefine ? 8796093022208L : 4398046511104L;
                                                                        }
                                                                        if ((j3 & 4294967296L) != 0) {
                                                                            j3 |= isDefine ? 35184372088832L : 17592186044416L;
                                                                        }
                                                                        boolean z37 = !isDefine;
                                                                        str18 = str22;
                                                                        str13 = str26;
                                                                        str10 = str28;
                                                                        z9 = z25;
                                                                        str12 = str31;
                                                                        str15 = str40;
                                                                        str14 = str42;
                                                                        str17 = str43;
                                                                        i2 = i27;
                                                                        i3 = i29;
                                                                        i4 = i30;
                                                                        i5 = i31;
                                                                        z5 = z30;
                                                                        str16 = str45;
                                                                        z6 = isDefine;
                                                                        str3 = str49;
                                                                        z7 = z29;
                                                                        trigger_Flex_When = trigger_Flex_When2;
                                                                        z2 = z24;
                                                                        str8 = str33;
                                                                        str11 = str35;
                                                                        str9 = str37;
                                                                        z8 = z28;
                                                                        trigger_IIS_data_cmp = trigger_IIS_data_cmp3;
                                                                        str6 = str46;
                                                                        i = i28;
                                                                        str7 = str36;
                                                                        z = z31;
                                                                        str5 = str54;
                                                                        z4 = z37;
                                                                    } else {
                                                                        str18 = str22;
                                                                        str13 = str26;
                                                                        str10 = str28;
                                                                        z2 = z24;
                                                                        z9 = z25;
                                                                        str12 = str31;
                                                                        str11 = str35;
                                                                        str15 = str40;
                                                                        str14 = str42;
                                                                        str17 = str43;
                                                                        i2 = i27;
                                                                        i3 = i29;
                                                                        i4 = i30;
                                                                        i5 = i31;
                                                                        z5 = z30;
                                                                        str16 = str45;
                                                                        z6 = false;
                                                                        str3 = str49;
                                                                        z7 = z29;
                                                                        trigger_Flex_When = trigger_Flex_When2;
                                                                        trigger_IIS_data_cmp = trigger_IIS_data_cmp3;
                                                                        str8 = str33;
                                                                        str9 = str37;
                                                                        z8 = z28;
                                                                        i = i28;
                                                                        str7 = str36;
                                                                        str6 = str46;
                                                                        str5 = str54;
                                                                        z = z31;
                                                                        z4 = false;
                                                                    }
                                                                    boolean z38 = z23;
                                                                    str4 = str50;
                                                                    z3 = z38;
                                                                }
                                                            } else {
                                                                trigger_IIS_data_cmp2 = trigger_IIS_data_cmp4;
                                                                str45 = str44;
                                                            }
                                                            str46 = null;
                                                            if ((j & 9007233614544896L) == 0) {
                                                            }
                                                            boolean z382 = z23;
                                                            str4 = str50;
                                                            z3 = z382;
                                                        }
                                                    } else {
                                                        str40 = str38;
                                                        j6 = 0;
                                                        str41 = null;
                                                    }
                                                    i26 = 0;
                                                    if ((j & 9007869269704704L) != j6) {
                                                    }
                                                    if ((j & 9007749014814724L) != 0) {
                                                    }
                                                    if ((j & 11329367812931584L) != 0) {
                                                    }
                                                    str46 = null;
                                                    if ((j & 9007233614544896L) == 0) {
                                                    }
                                                    boolean z3822 = z23;
                                                    str4 = str50;
                                                    z3 = z3822;
                                                }
                                            }
                                            str39 = null;
                                            if ((j & 9288674365735040L) == 0) {
                                            }
                                            i26 = 0;
                                            if ((j & 9007869269704704L) != j6) {
                                            }
                                            if ((j & 9007749014814724L) != 0) {
                                            }
                                            if ((j & 11329367812931584L) != 0) {
                                            }
                                            str46 = null;
                                            if ((j & 9007233614544896L) == 0) {
                                            }
                                            boolean z38222 = z23;
                                            str4 = str50;
                                            z3 = z38222;
                                        }
                                    } else {
                                        str33 = str32;
                                    }
                                    str34 = null;
                                    if ((j & 9007474132713472L) != 0) {
                                    }
                                    if ((j & 9042383635283976L) != 0) {
                                    }
                                    str39 = null;
                                    if ((j & 9288674365735040L) == 0) {
                                    }
                                    i26 = 0;
                                    if ((j & 9007869269704704L) != j6) {
                                    }
                                    if ((j & 9007749014814724L) != 0) {
                                    }
                                    if ((j & 11329367812931584L) != 0) {
                                    }
                                    str46 = null;
                                    if ((j & 9007233614544896L) == 0) {
                                    }
                                    boolean z382222 = z23;
                                    str4 = str50;
                                    z3 = z382222;
                                }
                            } else {
                                z24 = z22;
                                z25 = isNoise;
                            }
                            str30 = null;
                            if ((j & 9007267976380418L) == 0) {
                            }
                            if ((j & 9015995884701696L) == 0) {
                            }
                            str34 = null;
                            if ((j & 9007474132713472L) != 0) {
                            }
                            if ((j & 9042383635283976L) != 0) {
                            }
                            str39 = null;
                            if ((j & 9288674365735040L) == 0) {
                            }
                            i26 = 0;
                            if ((j & 9007869269704704L) != j6) {
                            }
                            if ((j & 9007749014814724L) != 0) {
                            }
                            if ((j & 11329367812931584L) != 0) {
                            }
                            str46 = null;
                            if ((j & 9007233614544896L) == 0) {
                            }
                            boolean z3822222 = z23;
                            str4 = str50;
                            z3 = z3822222;
                        }
                    } else {
                        str26 = str25;
                    }
                    str27 = null;
                    if ((j & 9570149208227840L) != 0) {
                    }
                    if ((j & 9008298766434304L) != 0) {
                    }
                    if ((j & 9011597334872096L) != 0) {
                    }
                    str30 = null;
                    if ((j & 9007267976380418L) == 0) {
                    }
                    if ((j & 9015995884701696L) == 0) {
                    }
                    str34 = null;
                    if ((j & 9007474132713472L) != 0) {
                    }
                    if ((j & 9042383635283976L) != 0) {
                    }
                    str39 = null;
                    if ((j & 9288674365735040L) == 0) {
                    }
                    i26 = 0;
                    if ((j & 9007869269704704L) != j6) {
                    }
                    if ((j & 9007749014814724L) != 0) {
                    }
                    if ((j & 11329367812931584L) != 0) {
                    }
                    str46 = null;
                    if ((j & 9007233614544896L) == 0) {
                    }
                    boolean z38222222 = z23;
                    str4 = str50;
                    z3 = z38222222;
                }
            } else {
                str24 = str23;
            }
            str25 = null;
            if ((j & 10133099161649152L) != 0) {
            }
            if ((j & 9024792514596864L) == 0) {
            }
            str27 = null;
            if ((j & 9570149208227840L) != 0) {
            }
            if ((j & 9008298766434304L) != 0) {
            }
            if ((j & 9011597334872096L) != 0) {
            }
            str30 = null;
            if ((j & 9007267976380418L) == 0) {
            }
            if ((j & 9015995884701696L) == 0) {
            }
            str34 = null;
            if ((j & 9007474132713472L) != 0) {
            }
            if ((j & 9042383635283976L) != 0) {
            }
            str39 = null;
            if ((j & 9288674365735040L) == 0) {
            }
            i26 = 0;
            if ((j & 9007869269704704L) != j6) {
            }
            if ((j & 9007749014814724L) != 0) {
            }
            if ((j & 11329367812931584L) != 0) {
            }
            str46 = null;
            if ((j & 9007233614544896L) == 0) {
            }
            boolean z382222222 = z23;
            str4 = str50;
            z3 = z382222222;
        } else {
            str = str52;
            str2 = str53;
            j3 = j2;
            str3 = str49;
            str4 = str50;
            str5 = str54;
            str6 = null;
            str7 = null;
            trigger_Flex_When = null;
            str8 = null;
            str9 = null;
            str10 = null;
            str11 = null;
            trigger_IIS_data_cmp = null;
            trigger_IIS_data_cmp2 = null;
            str12 = null;
            str13 = null;
            str14 = null;
            str15 = null;
            str16 = null;
            str17 = null;
            str18 = null;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
            i = 0;
            z8 = false;
            z9 = false;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        if ((j & 13510798882635776L) != 0 && mappingObject7 != null) {
            str47 = mappingObject7.getStr();
        }
        String str55 = str47;
        if ((j & LockFreeTaskQueueCore.FROZEN_MASK) != 0) {
            str19 = str55;
            z10 = trigger_Flex_When == ServiceEnum.Trigger_Flex_When.trig_flex_symbol;
            if ((j3 & 1099511627776L) != 0) {
                j = z10 ? j | 36028797018963968L : j | 18014398509481984L;
            }
            if ((j3 & PlaybackStateCompat.ACTION_PREPARE) != 0) {
                j3 = z10 ? j3 | 128 : j3 | 64;
            }
            if ((j & 9007216434675712L) != 0) {
                j3 |= z10 ? PlaybackStateCompat.ACTION_PREPARE_FROM_URI : PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            if ((j3 & 83886080) != 0) {
                j3 = z10 ? j3 | 8589934592L : j3 | 4294967296L;
            }
        } else {
            str19 = str55;
            z10 = z5;
        }
        if ((j3 & 274877906944L) != 0) {
            z11 = z10;
            z7 = trigger_Flex_When == ServiceEnum.Trigger_Flex_When.trig_flex_err;
            if ((j & 9007216434675712L) != 0) {
                j3 |= z7 ? PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
        } else {
            z11 = z10;
        }
        int i44 = ((j & 9007319513890816L) > 0L ? 1 : ((j & 9007319513890816L) == 0L ? 0 : -1));
        if (i44 != 0) {
            z12 = z ? true : z11;
            if (i44 != 0) {
                j3 |= z12 ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
        } else {
            z12 = false;
        }
        int i45 = ((j & 9007800550227968L) > 0L ? 1 : ((j & 9007800550227968L) == 0L ? 0 : -1));
        if (i45 != 0) {
            z13 = z ? true : z7;
            if (i45 != 0) {
                j3 = z13 ? j3 | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID | 2199023255552L : j3 | PlaybackStateCompat.ACTION_PREPARE | 1099511627776L;
            }
            if ((j & 9007250794414080L) != 0) {
                if (z13) {
                    j4 = j3 | 33554432;
                    j5 = 134217728;
                } else {
                    j4 = j3 | 16777216;
                    j5 = 67108864;
                }
                j3 = j4 | j5;
            }
        } else {
            z13 = false;
        }
        if ((j3 & 1099595530240L) != 0) {
            z14 = trigger_Flex_When == ServiceEnum.Trigger_Flex_When.trig_flex_symbol;
            if ((j3 & 1099511627776L) != 0) {
                j = z14 ? j | 36028797018963968L : j | 18014398509481984L;
            }
            if ((j3 & PlaybackStateCompat.ACTION_PREPARE) != 0) {
                j3 = z14 ? j3 | 128 : j3 | 64;
            }
            if ((j & 9007216434675712L) != 0) {
                j3 |= z14 ? PlaybackStateCompat.ACTION_PREPARE_FROM_URI : PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            if ((j3 & 83886080) != 0) {
                j3 = z14 ? j3 | 8589934592L : j3 | 4294967296L;
            }
        } else {
            z14 = z11;
        }
        if ((j3 & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) != 0) {
            z15 = z;
            z7 = trigger_Flex_When == ServiceEnum.Trigger_Flex_When.trig_flex_err;
            if ((j & 9007216434675712L) != 0) {
                j3 |= z7 ? PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
        } else {
            z15 = z;
        }
        boolean z39 = z7;
        int i46 = ((j & 9007319513890816L) > 0L ? 1 : ((j & 9007319513890816L) == 0L ? 0 : -1));
        if (i46 != 0) {
            z16 = z12 ? true : z39;
            if (i46 != 0) {
                j3 = z16 ? j3 | 2 | 536870912 : j3 | 1 | 268435456;
            }
            if ((j & 9007250794414080L) != 0) {
                j3 = z16 ? j3 | 8388608 : j3 | 4194304;
            }
        } else {
            z16 = false;
        }
        long j11 = 0;
        int i47 = 4;
        if ((j & 54043195528445952L) == 0 && (j3 & 4567597249L) == 0) {
            z17 = z39;
            z18 = z6;
            i6 = 0;
            i10 = 0;
            i9 = 0;
            i8 = 0;
        } else {
            int i48 = ((j & 36028797018963968L) > 0L ? 1 : ((j & 36028797018963968L) == 0L ? 0 : -1));
            if (i48 == 0 && (j3 & 128) == 0) {
                z17 = z39;
                i6 = 0;
            } else {
                if (triggerParam != null) {
                    trigger_IIS_data_cmp2 = triggerParam.getTrigger_IIS_data_cmp_ID();
                }
                z17 = z39;
                ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp7 = trigger_IIS_data_cmp2;
                if (i48 != 0) {
                    boolean symbolIDmax = triggerParam != null ? triggerParam.symbolIDmax(trigger_IIS_data_cmp7) : false;
                    if (i48 != 0) {
                        j3 |= symbolIDmax ? PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH : PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    }
                    if (!symbolIDmax) {
                        i6 = 4;
                        i7 = ((j3 & 128) > 0L ? 1 : ((j3 & 128) == 0L ? 0 : -1));
                        if (i7 == 0) {
                            boolean symbolIDmin = triggerParam != null ? triggerParam.symbolIDmin(trigger_IIS_data_cmp7) : false;
                            if (i7 != 0) {
                                j3 |= symbolIDmin ? 2147483648L : 1073741824L;
                            }
                            i8 = symbolIDmin ? 0 : 4;
                            trigger_IIS_data_cmp2 = trigger_IIS_data_cmp7;
                            j11 = 0;
                            if ((j & 18014398509481984L) == 0 || (j3 & 4567597121L) != 0) {
                                if (triggerParam != null) {
                                    z6 = triggerParam.isDefine();
                                }
                                if ((j3 & 4194304) != 0) {
                                    j |= z6 ? 576460752303423488L : 288230376151711744L;
                                }
                                if ((j & 18014398509481984L) != 0) {
                                    j |= z6 ? Long.MIN_VALUE : 4611686018427387904L;
                                }
                                if ((j3 & 64) != 0) {
                                    j3 = z6 ? j3 | 32 : j3 | 16;
                                }
                                if ((j3 & 268435456) != 0) {
                                    j3 |= z6 ? 34359738368L : 17179869184L;
                                }
                                if ((j3 & 1) != 0) {
                                    j3 |= z6 ? 8796093022208L : 4398046511104L;
                                }
                                if ((j3 & 4294967296L) != 0) {
                                    j3 |= z6 ? 35184372088832L : 17592186044416L;
                                }
                                int i49 = ((j3 & 4194304) != 0 || z6) ? 0 : 8;
                                if ((j3 & 4294967296L) == 0) {
                                    i10 = z6 ? 8 : 0;
                                    i9 = i49;
                                    z18 = z6;
                                } else {
                                    i9 = i49;
                                    z18 = z6;
                                    i10 = 0;
                                }
                            } else {
                                z18 = z6;
                                i10 = 0;
                                i9 = 0;
                            }
                        } else {
                            trigger_IIS_data_cmp2 = trigger_IIS_data_cmp7;
                        }
                    }
                }
                i6 = 0;
                i7 = ((j3 & 128) > 0L ? 1 : ((j3 & 128) == 0L ? 0 : -1));
                if (i7 == 0) {
                }
            }
            i8 = 0;
            j11 = 0;
            if ((j & 18014398509481984L) == 0) {
            }
            if (triggerParam != null) {
            }
            if ((j3 & 4194304) != 0) {
            }
            if ((j & 18014398509481984L) != 0) {
            }
            if ((j3 & 64) != 0) {
            }
            if ((j3 & 268435456) != 0) {
            }
            if ((j3 & 1) != 0) {
            }
            if ((j3 & 4294967296L) != 0) {
            }
            if ((j3 & 4194304) != 0) {
            }
            if ((j3 & 4294967296L) == 0) {
            }
        }
        int i50 = ((j & 9007250794414080L) > j11 ? 1 : ((j & 9007250794414080L) == j11 ? 0 : -1));
        if (i50 != 0) {
            if (z16) {
                i9 = 8;
            }
            int i51 = i9;
            i11 = i6;
            i12 = i51;
        } else {
            i11 = i6;
            i12 = 0;
        }
        i10 = ((j3 & 83886080) == j11 || z14) ? 0 : 0;
        if (i50 != 0) {
            int i52 = z13 ? 8 : i10;
            if (z13) {
                i10 = 4;
            }
            int i53 = i52;
            str20 = str8;
            i13 = i53;
            int i54 = i10;
            z19 = z4;
            i14 = i54;
        } else {
            str20 = str8;
            z19 = z4;
            i13 = 0;
            i14 = 0;
        }
        if ((j3 & 8830452760576L) != 0) {
            if (triggerParam != null) {
                trigger_IIS_data_cmp = triggerParam.getTrigger_IIS_data_cmp_Cyc();
            }
            i15 = i14;
            ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp8 = trigger_IIS_data_cmp;
            int i55 = ((j3 & 34359738368L) > 0L ? 1 : ((j3 & 34359738368L) == 0L ? 0 : -1));
            if (i55 != 0) {
                boolean Cycmin = triggerParam != null ? triggerParam.Cycmin(trigger_IIS_data_cmp8) : false;
                if (i55 != 0) {
                    j3 |= Cycmin ? 137438953472L : 68719476736L;
                }
                if (!Cycmin) {
                    i17 = 4;
                    i25 = ((j3 & 8796093022208L) > 0L ? 1 : ((j3 & 8796093022208L) == 0L ? 0 : -1));
                    if (i25 != 0) {
                        boolean Cycmax = triggerParam != null ? triggerParam.Cycmax(trigger_IIS_data_cmp8) : false;
                        if (i25 != 0) {
                            j |= Cycmax ? 144115188075855872L : 72057594037927936L;
                        }
                        if (!Cycmax) {
                            i16 = 4;
                        }
                    }
                    i16 = 0;
                }
            }
            i17 = 0;
            i25 = ((j3 & 8796093022208L) > 0L ? 1 : ((j3 & 8796093022208L) == 0L ? 0 : -1));
            if (i25 != 0) {
            }
            i16 = 0;
        } else {
            i15 = i14;
            i16 = 0;
            i17 = 0;
        }
        int i56 = ((j & 4611686018427387904L) > 0L ? 1 : ((j & 4611686018427387904L) == 0L ? 0 : -1));
        if (i56 == 0 && (j3 & 16) == 0) {
            i18 = i16;
            i19 = 0;
        } else {
            if (triggerParam != null) {
                trigger_IIS_data_cmp2 = triggerParam.getTrigger_IIS_data_cmp_ID();
            }
            i18 = i16;
            ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp9 = trigger_IIS_data_cmp2;
            int i57 = ((j3 & 16) > 0L ? 1 : ((j3 & 16) == 0L ? 0 : -1));
            if (i57 != 0) {
                boolean frameIDmin = triggerParam != null ? triggerParam.frameIDmin(trigger_IIS_data_cmp9) : false;
                if (i57 != 0) {
                    j3 |= frameIDmin ? 8L : 4L;
                }
                if (!frameIDmin) {
                    i19 = 4;
                    if (i56 != 0) {
                        boolean frameIDmax = triggerParam != null ? triggerParam.frameIDmax(trigger_IIS_data_cmp9) : false;
                        if (i56 != 0) {
                            j3 |= frameIDmax ? 140737488355328L : 70368744177664L;
                        }
                    }
                }
            }
            i19 = 0;
            if (i56 != 0) {
            }
        }
        i47 = 0;
        if ((j & 18014398509481984L) == 0) {
            i47 = 0;
        } else if (z18) {
            i47 = 8;
        }
        if ((j3 & 64) == 0) {
            i19 = 0;
        } else if (z18) {
            i19 = 8;
        }
        if ((j3 & 268435456) == 0) {
            i17 = 0;
        } else if (!z18) {
            i17 = 8;
        }
        int i58 = (j3 & 1) != 0 ? z18 ? i18 : 8 : 0;
        if ((j3 & 1099511627776L) == 0) {
            i11 = 0;
        } else if (!z14) {
            i11 = i47;
        }
        int i59 = ((j & 9007319513890816L) > 0L ? 1 : ((j & 9007319513890816L) == 0L ? 0 : -1));
        if (i59 != 0) {
            if (z16) {
                i58 = 8;
            }
            if (z16) {
                i17 = 8;
            }
            z20 = z18;
            i20 = i17;
        } else {
            z20 = z18;
            i20 = 0;
            i58 = 0;
        }
        if ((j3 & PlaybackStateCompat.ACTION_PREPARE) == 0) {
            i8 = 0;
        } else if (!z14) {
            i8 = i19;
        }
        int i60 = ((j & 9007800550227968L) > 0L ? 1 : ((j & 9007800550227968L) == 0L ? 0 : -1));
        if (i60 != 0) {
            if (z13) {
                i8 = 8;
            }
            i21 = i13;
            z21 = z14;
            i23 = i8;
            i22 = z13 ? 8 : i11;
        } else {
            i21 = i13;
            z21 = z14;
            i22 = 0;
            i23 = 0;
        }
        if ((j & 11329367812931584L) != 0) {
            i24 = i12;
            TextViewBindingAdapter.setText(this.triggerBaudValue, str6);
        } else {
            i24 = i12;
        }
        if ((j & 9570149208227840L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerChanceAValue, z2);
            CompoundButtonBindingAdapter.setChecked(this.triggerChanceBValue, z3);
        }
        if ((9007201402232832L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerChanceAValue, str51);
        }
        if ((9007199271518224L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerChanceBValue, str48);
        }
        if (i59 != 0) {
            this.triggerDownLimitCycLabel.setVisibility(i20);
            this.triggerDownLimitCycValue.setVisibility(i20);
            this.triggerUpLimitCycLabel.setVisibility(i58);
            this.triggerUpLimitCycValue.setVisibility(i58);
        }
        if ((9007336693760000L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerDownLimitCycValue, str7);
        }
        if (i60 != 0) {
            this.triggerDownLimitIdLabel.setVisibility(i23);
            this.triggerDownLimitIdValue.setVisibility(i23);
            this.triggerUpLimitIdLabel.setVisibility(i22);
            this.triggerUpLimitIdValue.setVisibility(i22);
        }
        if ((9008298766434304L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerDownLimitIdValue, str9);
        }
        if ((j & 9007250794414080L) != 0) {
            int i61 = i24;
            this.triggerFlexrayCycCompLabel.setVisibility(i61);
            this.triggerFlexrayCycCompValue.setVisibility(i61);
            int i62 = i21;
            this.triggerFlexrayIdCompLabel.setVisibility(i62);
            this.triggerFlexrayIdCompValue.setVisibility(i62);
            this.view3.setVisibility(i61);
            this.view4.setVisibility(i15);
        }
        if ((9007267976380418L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerFlexrayCycCompValue, str20);
        }
        if ((9007233614544896L & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerFlexrayDefineCyc, z20);
            CompoundButtonBindingAdapter.setChecked(this.triggerFlexrayDefineId, z19);
        }
        if ((9007207844708352L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerFlexrayDefineCyc, str5);
        }
        if ((j & 9007216434675712L) != 0) {
            int i63 = i3;
            this.triggerFlexrayDefineCyc.setVisibility(i63);
            this.triggerFlexrayDefineId.setVisibility(i63);
            this.triggerFlexrayDefineLabel.setVisibility(i63);
            CompoundButtonBindingAdapter.setChecked(this.triggerFlexrayError, z17);
            int i64 = i4;
            this.triggerFlexrayErrorLabel.setVisibility(i64);
            this.triggerFlexrayErrorValue.setVisibility(i64);
            CompoundButtonBindingAdapter.setChecked(this.triggerFlexrayFrame, z8);
            this.triggerFlexrayFrameLabel.setVisibility(i63);
            this.triggerFlexrayFrameValue.setVisibility(i63);
            CompoundButtonBindingAdapter.setChecked(this.triggerFlexrayPost, z15);
            int i65 = i5;
            this.triggerFlexrayPostTypeLabel.setVisibility(i65);
            this.triggerFlexrayPostTypeValue.setVisibility(i65);
            CompoundButtonBindingAdapter.setChecked(this.triggerFlexraySymbol, z21);
            int i66 = i;
            this.triggerFlexraySymbolLabel.setVisibility(i66);
            this.triggerFlexraySymbolValue.setVisibility(i66);
        }
        if ((9007199255789568L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerFlexrayDefineId, str);
        }
        if ((9007199321849920L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerFlexrayError, str3);
        }
        if ((9015995884701696L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerFlexrayErrorValue, str11);
        }
        if ((9007199523177472L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerFlexrayFrame, str4);
        }
        if ((9024792514596864L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerFlexrayFrameValue, str10);
        }
        if ((9007749014814724L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerFlexrayIdCompValue, str16);
        }
        if ((9007203549724672L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerFlexrayPost, str2);
        }
        if ((9011597334872096L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerFlexrayPostTypeValue, str12);
        }
        if ((13510798882635776L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerFlexraySymbol, str19);
        }
        if ((9042383635283976L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerFlexraySymbolValue, str17);
        }
        if ((9147936743161856L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelValue, str13);
        }
        if ((10133099161649152L & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerNoiseSwitch, z9);
        }
        if ((9288674365735040L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerSource, str14);
        }
        if ((9288674231517184L & j) != 0) {
            this.triggerSource.setTextColor(i2);
        }
        if ((9007474132713472L & j) != 0) {
            TextViewBindingAdapter.setText(this.triggerUpLimitCycValue, str15);
        }
        if ((j & 9009398278062080L) != 0) {
            TextViewBindingAdapter.setText(this.triggerUpLimitIdValue, str18);
        }
    }
}
