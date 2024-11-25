package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
public class AdapterTriggerOverBindingImpl extends AdapterTriggerOverBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 22);
        sViewsWithIds.put(R.id.guideline_center, 23);
        sViewsWithIds.put(R.id.guideline_right, 24);
        sViewsWithIds.put(R.id.guideline_forth, 25);
        sViewsWithIds.put(R.id.guideline_fifth, 26);
        sViewsWithIds.put(R.id.view_top, 27);
        sViewsWithIds.put(R.id.view_1, 28);
        sViewsWithIds.put(R.id.over_trigger_label, 29);
        sViewsWithIds.put(R.id.trigger_source_label, 30);
        sViewsWithIds.put(R.id.trigger_levelB, 31);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 32);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper3, 33);
        sViewsWithIds.put(R.id.trigger_holdoff_label, 34);
        sViewsWithIds.put(R.id.trigger_noise_label, 35);
        sViewsWithIds.put(R.id.view_line_1, 36);
        sViewsWithIds.put(R.id.view_line_2, 37);
        sViewsWithIds.put(R.id.trigger_over_edge_label, 38);
    }

    public AdapterTriggerOverBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 39, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerOverBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 12, (Button) objArr[8], (Button) objArr[9], (Guideline) objArr[23], (Guideline) objArr[26], (Guideline) objArr[25], (Guideline) objArr[22], (Guideline) objArr[24], (ImageView) objArr[14], (RadioButton) objArr[1], (RadioButton) objArr[2], (TextView) objArr[29], (RadioButton) objArr[3], (TextView) objArr[4], (EditText) objArr[5], (EditText) objArr[19], (TextView) objArr[34], (TextView) objArr[13], (EditText) objArr[10], (VerticalSeekBar) objArr[15], (TextView) objArr[31], (EditText) objArr[11], (VerticalSeekBar) objArr[16], (TextView) objArr[7], (CheckBox) objArr[12], (TextView) objArr[35], (SwitchButton) objArr[20], (RadioButton) objArr[18], (RadioButton) objArr[17], (TextView) objArr[38], (RadioButton) objArr[21], (TextView) objArr[6], (TextView) objArr[30], (VerticalSeekBarWrapper) objArr[32], (VerticalSeekBarWrapper) objArr[33], (View) objArr[28], (View) objArr[36], (View) objArr[37], (View) objArr[27]);
        this.mDirtyFlags = -1L;
        this.buttonLevel.setTag(null);
        this.buttonLevelB.setTag(null);
        this.imageView2.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.overTriggerEnter.setTag(null);
        this.overTriggerExit.setTag(null);
        this.overTriggerTime.setTag(null);
        this.overTriggerTimeLabel.setTag(null);
        this.overTriggerTimeValue.setTag(null);
        this.triggerHoldoff.setTag(null);
        this.triggerLevel.setTag(null);
        this.triggerLevelAValue.setTag(null);
        this.triggerLevelAView.setTag(null);
        this.triggerLevelBValue.setTag(null);
        this.triggerLevelBView.setTag(null);
        this.triggerLevelSelect.setTag(null);
        this.triggerLevelSelectAb.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerOverEdgeEither.setTag(null);
        this.triggerOverEdgeFalling.setTag(null);
        this.triggerOverEdgeRising.setTag(null);
        this.triggerSource.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2147483648L;
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
        if (648 == i) {
            setPositionExitMapping((MappingObject) obj);
        } else if (847 == i) {
            setSlopeEitherMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (848 == i) {
            setSlopeFallingMapping((MappingObject) obj);
        } else if (647 == i) {
            setPositionEnterMapping((MappingObject) obj);
        } else if (649 == i) {
            setPositionTimeMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (850 != i) {
            return false;
        } else {
            setSlopeRisingMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setPositionExitMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mPositionExitMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(648);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setSlopeEitherMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mSlopeEitherMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(847);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(2, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setSlopeFallingMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mSlopeFallingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(848);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setPositionEnterMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mPositionEnterMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(647);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setPositionTimeMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mPositionTimeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(649);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerOverBinding
    public void setSlopeRisingMapping(MappingObject mappingObject) {
        updateRegistration(11, mappingObject);
        this.mSlopeRisingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(850);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangePositionExitMapping((MappingObject) obj, i2);
            case 1:
                return onChangeSlopeEitherMapping((MappingObject) obj, i2);
            case 2:
                return onChangeParam((TriggerParam) obj, i2);
            case 3:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 4:
                return onChangeSlopeFallingMapping((MappingObject) obj, i2);
            case 5:
                return onChangePositionEnterMapping((MappingObject) obj, i2);
            case 6:
                return onChangePositionTimeMapping((MappingObject) obj, i2);
            case 7:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceParamChanValue1((MappingObject) obj, i2);
            case 8:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 9:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerLevelselectParamOverTriggerLevelIDValue1((MappingObject) obj, i2);
            case 10:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 11:
                return onChangeSlopeRisingMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangePositionExitMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSlopeEitherMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 578) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 580) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 581) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 582) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 583) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 579) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 672) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 673) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 377) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
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
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangePositionEnterMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    private boolean onChangePositionTimeMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
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

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerLevelselectParamOverTriggerLevelIDValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
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

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSlopeRisingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
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

    /* JADX WARN: Removed duplicated region for block: B:140:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x025c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x015f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01bd  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1122
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterTriggerOverBindingImpl.executeBindings():void");
    }
}
