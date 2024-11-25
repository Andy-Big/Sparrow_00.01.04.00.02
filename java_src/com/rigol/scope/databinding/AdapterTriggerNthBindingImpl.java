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
public class AdapterTriggerNthBindingImpl extends AdapterTriggerNthBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 10);
        sViewsWithIds.put(R.id.guideline_center, 11);
        sViewsWithIds.put(R.id.guideline_right, 12);
        sViewsWithIds.put(R.id.guideline_forth, 13);
        sViewsWithIds.put(R.id.guideline_fifth, 14);
        sViewsWithIds.put(R.id.view_top, 15);
        sViewsWithIds.put(R.id.trigger_source_label, 16);
        sViewsWithIds.put(R.id.trigger_noise, 17);
        sViewsWithIds.put(R.id.trigger_noise_label, 18);
        sViewsWithIds.put(R.id.view, 19);
        sViewsWithIds.put(R.id.trigger_nth_idle_time_label, 20);
        sViewsWithIds.put(R.id.trigger_nth_edge_number_label, 21);
        sViewsWithIds.put(R.id.view2, 22);
        sViewsWithIds.put(R.id.trigger_level, 23);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 24);
        sViewsWithIds.put(R.id.button_level, 25);
        sViewsWithIds.put(R.id.trigger_nth_edge_label, 26);
    }

    public AdapterTriggerNthBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 27, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerNthBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (Button) objArr[25], (Guideline) objArr[11], (Guideline) objArr[14], (Guideline) objArr[13], (Guideline) objArr[10], (Guideline) objArr[12], (ImageView) objArr[5], (TextView) objArr[23], (EditText) objArr[7], (VerticalSeekBar) objArr[6], (View) objArr[17], (TextView) objArr[18], (SwitchButton) objArr[2], (RadioButton) objArr[8], (TextView) objArr[26], (TextView) objArr[21], (EditText) objArr[4], (RadioButton) objArr[9], (TextView) objArr[20], (EditText) objArr[3], (TextView) objArr[1], (TextView) objArr[16], (VerticalSeekBarWrapper) objArr[24], (View) objArr[19], (View) objArr[22], (View) objArr[15]);
        this.mDirtyFlags = -1L;
        this.imageView2.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.triggerLevelValue.setTag(null);
        this.triggerLevelView.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerNthEdgeFalling.setTag(null);
        this.triggerNthEdgeNumberValue.setTag(null);
        this.triggerNthEdgeRising.setTag(null);
        this.triggerNthIdleTimeValue.setTag(null);
        this.triggerSource.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
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
        if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (850 == i) {
            setSlopeRisingMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (848 != i) {
            return false;
        } else {
            setSlopeFallingMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerNthBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerNthBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerNthBinding
    public void setSlopeRisingMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mSlopeRisingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(850);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerNthBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(4, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerNthBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerNthBinding
    public void setSlopeFallingMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mSlopeFallingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(848);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 1:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 2:
                return onChangeSlopeRisingMapping((MappingObject) obj, i2);
            case 3:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1((MappingObject) obj, i2);
            case 4:
                return onChangeParam((TriggerParam) obj, i2);
            case 5:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 6:
                return onChangeSlopeFallingMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSlopeRisingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 411) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 262) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 562) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 671) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 484) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepAutoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSlopeFallingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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

    /* JADX WARN: Removed duplicated region for block: B:69:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0126  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterTriggerNthBindingImpl.executeBindings():void");
    }
}
