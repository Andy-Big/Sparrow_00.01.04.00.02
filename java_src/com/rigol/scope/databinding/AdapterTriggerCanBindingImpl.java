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
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
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
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1099
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterTriggerCanBindingImpl.executeBindings():void");
    }
}
