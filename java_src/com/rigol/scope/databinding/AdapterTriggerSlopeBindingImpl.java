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
public class AdapterTriggerSlopeBindingImpl extends AdapterTriggerSlopeBinding {
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
        sViewsWithIds.put(R.id.trigger_noise, 30);
        sViewsWithIds.put(R.id.trigger_level_select_label, 31);
        sViewsWithIds.put(R.id.trigger_source_label, 32);
        sViewsWithIds.put(R.id.trigger_edge_label, 33);
        sViewsWithIds.put(R.id.trigger_levelB, 34);
        sViewsWithIds.put(R.id.slope_type_label, 35);
        sViewsWithIds.put(R.id.trigger_level, 36);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 37);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper3, 38);
        sViewsWithIds.put(R.id.trigger_holdoff_label, 39);
        sViewsWithIds.put(R.id.trigger_noise_label, 40);
    }

    public AdapterTriggerSlopeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 41, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerSlopeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 9, (Button) objArr[9], (Button) objArr[10], (RadioButton) objArr[8], (RadioButton) objArr[7], (Guideline) objArr[24], (Guideline) objArr[27], (Guideline) objArr[26], (Guideline) objArr[23], (Guideline) objArr[25], (ImageView) objArr[15], (RadioButton) objArr[20], (RadioButton) objArr[19], (TextView) objArr[11], (EditText) objArr[12], (RadioButton) objArr[18], (TextView) objArr[35], (TextView) objArr[33], (EditText) objArr[21], (TextView) objArr[39], (TextView) objArr[36], (EditText) objArr[13], (VerticalSeekBar) objArr[16], (TextView) objArr[34], (EditText) objArr[14], (VerticalSeekBar) objArr[17], (RadioButton) objArr[5], (CheckBox) objArr[3], (RadioButton) objArr[4], (TextView) objArr[31], (View) objArr[30], (TextView) objArr[40], (SwitchButton) objArr[22], (TextView) objArr[6], (TextView) objArr[32], (TextView) objArr[1], (EditText) objArr[2], (VerticalSeekBarWrapper) objArr[37], (VerticalSeekBarWrapper) objArr[38], (View) objArr[29], (View) objArr[28]);
        this.mDirtyFlags = -1L;
        this.buttonLevel.setTag(null);
        this.buttonLevelB.setTag(null);
        this.edgeFalling.setTag(null);
        this.edgeRising.setTag(null);
        this.imageView2.setTag(null);
        this.lessMore.setTag(null);
        this.lessThan.setTag(null);
        this.lowerLimit.setTag(null);
        this.lowerLimitValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.moreThan.setTag(null);
        this.triggerHoldoff.setTag(null);
        this.triggerLevelAValue.setTag(null);
        this.triggerLevelAView.setTag(null);
        this.triggerLevelBValue.setTag(null);
        this.triggerLevelBView.setTag(null);
        this.triggerLevelSelectA.setTag(null);
        this.triggerLevelSelectAb.setTag(null);
        this.triggerLevelSelectB.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSource.setTag(null);
        this.upperLimit.setTag(null);
        this.upperLimitValue.setTag(null);
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
        if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (848 == i) {
            setSlopeFallingMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (790 == i) {
            setSelectLevelBMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (850 == i) {
            setSlopeRisingMapping((MappingObject) obj);
        } else if (789 != i) {
            return false;
        } else {
            setSelectLevelAMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSlopeBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(0, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSlopeBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSlopeBinding
    public void setSlopeFallingMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mSlopeFallingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(848);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSlopeBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSlopeBinding
    public void setSelectLevelBMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mSelectLevelBMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(790);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSlopeBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSlopeBinding
    public void setSlopeRisingMapping(MappingObject mappingObject) {
        updateRegistration(7, mappingObject);
        this.mSlopeRisingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(850);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerSlopeBinding
    public void setSelectLevelAMapping(MappingObject mappingObject) {
        updateRegistration(8, mappingObject);
        this.mSelectLevelAMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(789);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeParam((TriggerParam) obj, i2);
            case 1:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 2:
                return onChangeSlopeFallingMapping((MappingObject) obj, i2);
            case 3:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceParamChanValue1((MappingObject) obj, i2);
            case 4:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 5:
                return onChangeSelectLevelBMapping((MappingObject) obj, i2);
            case 6:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 7:
                return onChangeSlopeRisingMapping((MappingObject) obj, i2);
            case 8:
                return onChangeSelectLevelAMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 256) {
            synchronized (this) {
                this.mDirtyFlags |= 524800;
            }
            return true;
        } else if (i == 852) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 851) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 846) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 849) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 853) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 854) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 672) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 673) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 377) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepAutoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSlopeFallingMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceParamChanValue1(MappingObject mappingObject, int i) {
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

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSelectLevelBMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSlopeRisingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
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

    private boolean onChangeSelectLevelAMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
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

    /* JADX WARN: Code restructure failed: missing block: B:111:0x0195, code lost:
        if (r4 != false) goto L88;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0261 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x013a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0148  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1111
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterTriggerSlopeBindingImpl.executeBindings():void");
    }
}
