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
public class AdapterTriggerPulseBindingImpl extends AdapterTriggerPulseBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 16);
        sViewsWithIds.put(R.id.guideline_center, 17);
        sViewsWithIds.put(R.id.guideline_right, 18);
        sViewsWithIds.put(R.id.view_top, 19);
        sViewsWithIds.put(R.id.view_1, 20);
        sViewsWithIds.put(R.id.trigger_noise, 21);
        sViewsWithIds.put(R.id.trigger_source_label, 22);
        sViewsWithIds.put(R.id.trigger_polarity_label, 23);
        sViewsWithIds.put(R.id.trigger_holdoff_label, 24);
        sViewsWithIds.put(R.id.trigger_noise_label, 25);
        sViewsWithIds.put(R.id.trigger_level, 26);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 27);
        sViewsWithIds.put(R.id.button_level, 28);
        sViewsWithIds.put(R.id.trigger_pulse_label, 29);
    }

    public AdapterTriggerPulseBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 30, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerPulseBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (Button) objArr[28], (Guideline) objArr[17], (Guideline) objArr[16], (Guideline) objArr[18], (ImageView) objArr[10], (RadioButton) objArr[15], (RadioButton) objArr[14], (TextView) objArr[8], (EditText) objArr[9], (RadioButton) objArr[13], (RadioButton) objArr[2], (RadioButton) objArr[1], (EditText) objArr[4], (TextView) objArr[24], (TextView) objArr[26], (EditText) objArr[12], (VerticalSeekBar) objArr[11], (View) objArr[21], (TextView) objArr[25], (SwitchButton) objArr[5], (TextView) objArr[23], (TextView) objArr[29], (TextView) objArr[3], (TextView) objArr[22], (TextView) objArr[6], (EditText) objArr[7], (VerticalSeekBarWrapper) objArr[27], (View) objArr[20], (View) objArr[19]);
        this.mDirtyFlags = -1L;
        this.imageView2.setTag(null);
        this.lessMore.setTag(null);
        this.lessThan.setTag(null);
        this.lowerLimit.setTag(null);
        this.lowerLimitValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.moreThan.setTag(null);
        this.polarityN.setTag(null);
        this.polarityP.setTag(null);
        this.triggerHoldoff.setTag(null);
        this.triggerLevelValue.setTag(null);
        this.triggerLevelView.setTag(null);
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
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
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
        } else if (643 == i) {
            setPolarityNegativeMapping((MappingObject) obj);
        } else if (644 == i) {
            setPolarityPositiveMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 != i) {
            return false;
        } else {
            setSweepAutoMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerPulseBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerPulseBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerPulseBinding
    public void setPolarityNegativeMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mPolarityNegativeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(643);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerPulseBinding
    public void setPolarityPositiveMapping(MappingObject mappingObject) {
        updateRegistration(3, mappingObject);
        this.mPolarityPositiveMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(644);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerPulseBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(5, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerPulseBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 1:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 2:
                return onChangePolarityNegativeMapping((MappingObject) obj, i2);
            case 3:
                return onChangePolarityPositiveMapping((MappingObject) obj, i2);
            case 4:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1((MappingObject) obj, i2);
            case 5:
                return onChangeParam((TriggerParam) obj, i2);
            case 6:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
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

    private boolean onChangePolarityNegativeMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangePolarityPositiveMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 642) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 377) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 256) {
            synchronized (this) {
                this.mDirtyFlags |= 540672;
            }
            return true;
        } else if (i == 995) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 511) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 671) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 484) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepAutoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0206  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 772
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterTriggerPulseBindingImpl.executeBindings():void");
    }
}
