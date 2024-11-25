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
public class AdapterTriggerLinBindingImpl extends AdapterTriggerLinBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 26);
        sViewsWithIds.put(R.id.guideline_center, 27);
        sViewsWithIds.put(R.id.guideline_right, 28);
        sViewsWithIds.put(R.id.guideline_forth, 29);
        sViewsWithIds.put(R.id.guideline_fifth, 30);
        sViewsWithIds.put(R.id.view_top, 31);
        sViewsWithIds.put(R.id.view_1, 32);
        sViewsWithIds.put(R.id.view_2, 33);
        sViewsWithIds.put(R.id.trigger_label, 34);
        sViewsWithIds.put(R.id.trigger_sample_points_label, 35);
        sViewsWithIds.put(R.id.trigger_source_lin_baud_label, 36);
        sViewsWithIds.put(R.id.trigger_source_lin_version_label, 37);
        sViewsWithIds.put(R.id.trigger_level, 38);
        sViewsWithIds.put(R.id.trigger_source_lin_label, 39);
        sViewsWithIds.put(R.id.button_level, 40);
        sViewsWithIds.put(R.id.trigger_noise_label, 41);
        sViewsWithIds.put(R.id.view_line_1, 42);
        sViewsWithIds.put(R.id.view_line_2, 43);
    }

    public AdapterTriggerLinBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 44, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerLinBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 16, (Button) objArr[40], (Guideline) objArr[27], (Guideline) objArr[30], (Guideline) objArr[29], (Guideline) objArr[26], (Guideline) objArr[28], (TextView) objArr[6], (TextView) objArr[3], (TextView) objArr[34], (TextView) objArr[38], (EditText) objArr[23], (TextView) objArr[22], (TextView) objArr[8], (TextView) objArr[5], (RadioButton) objArr[15], (RadioButton) objArr[14], (TextView) objArr[7], (EditText) objArr[9], (RadioButton) objArr[11], (RadioButton) objArr[16], (TextView) objArr[10], (EditText) objArr[4], (RadioButton) objArr[13], (RadioButton) objArr[17], (RadioButton) objArr[20], (RadioButton) objArr[19], (RadioButton) objArr[18], (RadioButton) objArr[12], (TextView) objArr[41], (SwitchButton) objArr[25], (TextView) objArr[35], (EditText) objArr[21], (TextView) objArr[36], (TextView) objArr[39], (TextView) objArr[24], (TextView) objArr[37], (View) objArr[32], (View) objArr[33], (View) objArr[1], (View) objArr[2], (View) objArr[42], (View) objArr[43], (View) objArr[31]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.triggerErrTypeLabel.setTag(null);
        this.triggerErrTypeValue.setTag(null);
        this.triggerLevelValue.setTag(null);
        this.triggerLinBaudValue.setTag(null);
        this.triggerLinBytelengthLabel.setTag(null);
        this.triggerLinBytelengthValue.setTag(null);
        this.triggerLinData.setTag(null);
        this.triggerLinDataId.setTag(null);
        this.triggerLinDataLabel.setTag(null);
        this.triggerLinDataValue.setTag(null);
        this.triggerLinError.setTag(null);
        this.triggerLinId.setTag(null);
        this.triggerLinIdLabel.setTag(null);
        this.triggerLinIdValue.setTag(null);
        this.triggerLinSleep.setTag(null);
        this.triggerLinSync.setTag(null);
        this.triggerLinVersion1.setTag(null);
        this.triggerLinVersion2.setTag(null);
        this.triggerLinVersionBoth.setTag(null);
        this.triggerLinWakeup.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSamplePointsValue.setTag(null);
        this.triggerSourceLinValue.setTag(null);
        this.view3.setTag(null);
        this.view4.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 549755813888L;
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
        if (1067 == i) {
            setWhenSleepMapping((MappingObject) obj);
        } else if (1073 == i) {
            setWhenWakeUpMapping((MappingObject) obj);
        } else if (1071 == i) {
            setWhenSyncMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (1055 == i) {
            setWhenErrorMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (1023 == i) {
            setVersion2Mapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (1053 == i) {
            setWhenDataIdMapping((MappingObject) obj);
        } else if (1024 == i) {
            setVersionBothMapping((MappingObject) obj);
        } else if (1058 == i) {
            setWhenIdMapping((MappingObject) obj);
        } else if (1054 == i) {
            setWhenDataMapping((MappingObject) obj);
        } else if (1022 != i) {
            return false;
        } else {
            setVersion1Mapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setWhenSleepMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mWhenSleepMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1067);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setWhenWakeUpMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mWhenWakeUpMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(1073);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setWhenSyncMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mWhenSyncMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(1071);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(3, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setWhenErrorMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mWhenErrorMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(1055);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setVersion2Mapping(MappingObject mappingObject) {
        updateRegistration(8, mappingObject);
        this.mVersion2Mapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(1023);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setWhenDataIdMapping(MappingObject mappingObject) {
        updateRegistration(10, mappingObject);
        this.mWhenDataIdMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(1053);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setVersionBothMapping(MappingObject mappingObject) {
        updateRegistration(11, mappingObject);
        this.mVersionBothMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(1024);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setWhenIdMapping(MappingObject mappingObject) {
        updateRegistration(12, mappingObject);
        this.mWhenIdMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(1058);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setWhenDataMapping(MappingObject mappingObject) {
        updateRegistration(14, mappingObject);
        this.mWhenDataMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
        }
        notifyPropertyChanged(1054);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setVersion1Mapping(MappingObject mappingObject) {
        updateRegistration(15, mappingObject);
        this.mVersion1Mapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(1022);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeWhenSleepMapping((MappingObject) obj, i2);
            case 1:
                return onChangeWhenWakeUpMapping((MappingObject) obj, i2);
            case 2:
                return onChangeWhenSyncMapping((MappingObject) obj, i2);
            case 3:
                return onChangeParam((TriggerParam) obj, i2);
            case 4:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 5:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerLinErrTypeParamTriggerLinErrValue1((MappingObject) obj, i2);
            case 6:
                return onChangeWhenErrorMapping((MappingObject) obj, i2);
            case 7:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 8:
                return onChangeVersion2Mapping((MappingObject) obj, i2);
            case 9:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 10:
                return onChangeWhenDataIdMapping((MappingObject) obj, i2);
            case 11:
                return onChangeVersionBothMapping((MappingObject) obj, i2);
            case 12:
                return onChangeWhenIdMapping((MappingObject) obj, i2);
            case 13:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1((MappingObject) obj, i2);
            case 14:
                return onChangeWhenDataMapping((MappingObject) obj, i2);
            case 15:
                return onChangeVersion1Mapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeWhenSleepMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
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

    private boolean onChangeWhenWakeUpMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeWhenSyncMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 970) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 968) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 493) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 491) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 339) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 969) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 494) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else if (i == 490) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else if (i == 484) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= 268435456;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= 536870912;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepAutoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerLinErrTypeParamTriggerLinErrValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    private boolean onChangeWhenErrorMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeVersion2Mapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeWhenDataIdMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
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

    private boolean onChangeVersionBothMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
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

    private boolean onChangeWhenIdMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
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

    private boolean onChangeWhenDataMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 137438953472L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeVersion1Mapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 274877906944L;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0202 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0216  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1789
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterTriggerLinBindingImpl.executeBindings():void");
    }
}
