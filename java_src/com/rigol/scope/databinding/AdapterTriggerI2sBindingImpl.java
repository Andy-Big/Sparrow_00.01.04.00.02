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
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterTriggerI2sBindingImpl.executeBindings():void");
    }
}
