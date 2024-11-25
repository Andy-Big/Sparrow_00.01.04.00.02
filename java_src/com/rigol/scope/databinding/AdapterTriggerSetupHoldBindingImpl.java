package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.rigol.scope.views.vertical.VerticalSeekBar;
import com.rigol.scope.views.vertical.VerticalSeekBarWrapper;
/* loaded from: classes2.dex */
public class AdapterTriggerSetupHoldBindingImpl extends AdapterTriggerSetupHoldBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 21);
        sViewsWithIds.put(R.id.guideline_center, 22);
        sViewsWithIds.put(R.id.guideline_right, 23);
        sViewsWithIds.put(R.id.guideline_forth, 24);
        sViewsWithIds.put(R.id.guideline_fifth, 25);
        sViewsWithIds.put(R.id.view_top, 26);
        sViewsWithIds.put(R.id.view_1, 27);
        sViewsWithIds.put(R.id.view_2, 28);
        sViewsWithIds.put(R.id.trigger_source_data_label, 29);
        sViewsWithIds.put(R.id.trigger_data_type_label, 30);
        sViewsWithIds.put(R.id.trigger_levelB, 31);
        sViewsWithIds.put(R.id.button_level, 32);
        sViewsWithIds.put(R.id.button_levelB, 33);
        sViewsWithIds.put(R.id.trigger_source_clock_label, 34);
        sViewsWithIds.put(R.id.trigger_edge_clock_label, 35);
        sViewsWithIds.put(R.id.setup_type_label, 36);
        sViewsWithIds.put(R.id.trigger_level, 37);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 38);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper3, 39);
        sViewsWithIds.put(R.id.trigger_holdoff_label, 40);
        sViewsWithIds.put(R.id.trigger_noise_label, 41);
        sViewsWithIds.put(R.id.view_line_1, 42);
        sViewsWithIds.put(R.id.view_line_2, 43);
    }

    public AdapterTriggerSetupHoldBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 44, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerSetupHoldBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 13, (Button) objArr[32], (Button) objArr[33], (RadioButton) objArr[2], (RadioButton) objArr[3], (RadioButton) objArr[9], (RadioButton) objArr[8], (Guideline) objArr[22], (Guideline) objArr[25], (Guideline) objArr[24], (Guideline) objArr[21], (Guideline) objArr[23], (RadioButton) objArr[17], (TextView) objArr[6], (EditText) objArr[7], (ImageView) objArr[13], (RadioButton) objArr[16], (RadioButton) objArr[18], (TextView) objArr[4], (TextView) objArr[36], (EditText) objArr[5], (TextView) objArr[30], (TextView) objArr[35], (EditText) objArr[19], (TextView) objArr[40], (TextView) objArr[37], (EditText) objArr[11], (VerticalSeekBar) objArr[14], (TextView) objArr[31], (EditText) objArr[12], (VerticalSeekBar) objArr[15], (TextView) objArr[41], (SwitchButton) objArr[20], (TextView) objArr[10], (TextView) objArr[34], (TextView) objArr[1], (TextView) objArr[29], (VerticalSeekBarWrapper) objArr[38], (VerticalSeekBarWrapper) objArr[39], (View) objArr[27], (View) objArr[28], (View) objArr[42], (View) objArr[43], (View) objArr[26]);
        this.mDirtyFlags = -1L;
        this.dataTypeH.setTag(null);
        this.dataTypeL.setTag(null);
        this.edgeClockFalling.setTag(null);
        this.edgeClockRising.setTag(null);
        this.hold.setTag(null);
        this.holdLabel.setTag(null);
        this.holdValue.setTag(null);
        this.imageView2.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.setup.setTag(null);
        this.setupHold.setTag(null);
        this.setupLabel.setTag(null);
        this.setupValue.setTag(null);
        this.triggerHoldoff.setTag(null);
        this.triggerLevelAValue.setTag(null);
        this.triggerLevelAView.setTag(null);
        this.triggerLevelBValue.setTag(null);
        this.triggerLevelBView.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSourceClock.setTag(null);
        this.triggerSourceData.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 68719476736L;
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
        } else if (848 == i) {
            setSlopeFallingMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (1065 == i) {
            setWhenSetupHoldMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (850 == i) {
            setSlopeRisingMapping((MappingObject) obj);
        } else if (981 == i) {
            setTypeHMapping((MappingObject) obj);
        } else if (982 == i) {
            setTypeLMapping((MappingObject) obj);
        } else if (1066 == i) {
            setWhenSetupMapping((MappingObject) obj);
        } else if (1057 != i) {
            return false;
        } else {
            setWhenHoldMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(2, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setSlopeFallingMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mSlopeFallingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(848);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setWhenSetupHoldMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mWhenSetupHoldMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(1065);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setSlopeRisingMapping(MappingObject mappingObject) {
        updateRegistration(8, mappingObject);
        this.mSlopeRisingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(850);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setTypeHMapping(MappingObject mappingObject) {
        updateRegistration(9, mappingObject);
        this.mTypeHMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(981);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setTypeLMapping(MappingObject mappingObject) {
        updateRegistration(10, mappingObject);
        this.mTypeLMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(982);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setWhenSetupMapping(MappingObject mappingObject) {
        updateRegistration(11, mappingObject);
        this.mWhenSetupMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(1066);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding
    public void setWhenHoldMapping(MappingObject mappingObject) {
        updateRegistration(12, mappingObject);
        this.mWhenHoldMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(1057);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSetupSdaParamSetupHoldChanBValue1((MappingObject) obj, i2);
            case 1:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSetupSclParamSetupHoldChanAValue1((MappingObject) obj, i2);
            case 2:
                return onChangeParam((TriggerParam) obj, i2);
            case 3:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 4:
                return onChangeSlopeFallingMapping((MappingObject) obj, i2);
            case 5:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 6:
                return onChangeWhenSetupHoldMapping((MappingObject) obj, i2);
            case 7:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 8:
                return onChangeSlopeRisingMapping((MappingObject) obj, i2);
            case 9:
                return onChangeTypeHMapping((MappingObject) obj, i2);
            case 10:
                return onChangeTypeLMapping((MappingObject) obj, i2);
            case 11:
                return onChangeWhenSetupMapping((MappingObject) obj, i2);
            case 12:
                return onChangeWhenHoldMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSetupSdaParamSetupHoldChanBValue1(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSetupSclParamSetupHoldChanAValue1(MappingObject mappingObject, int i) {
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
        } else if (i == 817) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 818) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 769) {
            synchronized (this) {
                this.mDirtyFlags |= 16908288;
            }
            return true;
        } else if (i == 813) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 376) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 819) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 816) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 820) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 821) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 672) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else if (i == 673) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else if (i == 377) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= 268435456;
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

    private boolean onChangeSlopeFallingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeWhenSetupHoldMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSlopeRisingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
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

    private boolean onChangeTypeHMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
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

    private boolean onChangeTypeLMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeWhenSetupMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeWhenHoldMapping(MappingObject mappingObject, int i) {
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

    /* JADX WARN: Removed duplicated region for block: B:102:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02ca A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c8  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterTriggerSetupHoldBindingImpl.executeBindings():void");
    }
}
