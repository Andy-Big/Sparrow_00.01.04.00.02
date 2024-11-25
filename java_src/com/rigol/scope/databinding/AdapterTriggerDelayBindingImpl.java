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
public class AdapterTriggerDelayBindingImpl extends AdapterTriggerDelayBinding {
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
        sViewsWithIds.put(R.id.trigger_source_b_label2, 29);
        sViewsWithIds.put(R.id.trigger_edge_b_label, 30);
        sViewsWithIds.put(R.id.trigger_levelB, 31);
        sViewsWithIds.put(R.id.button_level, 32);
        sViewsWithIds.put(R.id.button_levelB, 33);
        sViewsWithIds.put(R.id.trigger_source_a_label, 34);
        sViewsWithIds.put(R.id.trigger_edge_a_label, 35);
        sViewsWithIds.put(R.id.slope_type_label, 36);
        sViewsWithIds.put(R.id.trigger_level, 37);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 38);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper3, 39);
        sViewsWithIds.put(R.id.trigger_holdoff_label, 40);
        sViewsWithIds.put(R.id.trigger_noise_label, 41);
        sViewsWithIds.put(R.id.view_line_1, 42);
        sViewsWithIds.put(R.id.view_line_2, 43);
    }

    public AdapterTriggerDelayBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 44, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerDelayBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 10, (Button) objArr[32], (Button) objArr[33], (RadioButton) objArr[19], (RadioButton) objArr[18], (RadioButton) objArr[3], (RadioButton) objArr[2], (Guideline) objArr[23], (Guideline) objArr[26], (Guideline) objArr[25], (Guideline) objArr[22], (Guideline) objArr[24], (ImageView) objArr[11], (RadioButton) objArr[16], (RadioButton) objArr[15], (TextView) objArr[6], (EditText) objArr[7], (RadioButton) objArr[17], (RadioButton) objArr[14], (TextView) objArr[36], (TextView) objArr[35], (TextView) objArr[30], (EditText) objArr[20], (TextView) objArr[40], (TextView) objArr[37], (EditText) objArr[9], (VerticalSeekBar) objArr[12], (TextView) objArr[31], (EditText) objArr[10], (VerticalSeekBar) objArr[13], (TextView) objArr[41], (SwitchButton) objArr[21], (TextView) objArr[8], (TextView) objArr[34], (TextView) objArr[1], (TextView) objArr[29], (TextView) objArr[4], (EditText) objArr[5], (VerticalSeekBarWrapper) objArr[38], (VerticalSeekBarWrapper) objArr[39], (View) objArr[28], (View) objArr[42], (View) objArr[43], (View) objArr[27]);
        this.mDirtyFlags = -1L;
        this.edgeAFalling.setTag(null);
        this.edgeARising.setTag(null);
        this.edgeBFalling.setTag(null);
        this.edgeBRising.setTag(null);
        this.imageView2.setTag(null);
        this.lessMore.setTag(null);
        this.lessThan.setTag(null);
        this.lowerLimit.setTag(null);
        this.lowerLimitValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.moreLess.setTag(null);
        this.moreThan.setTag(null);
        this.triggerHoldoff.setTag(null);
        this.triggerLevelAValue.setTag(null);
        this.triggerLevelAView.setTag(null);
        this.triggerLevelBValue.setTag(null);
        this.triggerLevelBView.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSourceA.setTag(null);
        this.triggerSourceB.setTag(null);
        this.upperLimit.setTag(null);
        this.upperLimitValue.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1073741824L;
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
        if (260 == i) {
            setEdgeFallingBMapping((MappingObject) obj);
        } else if (263 == i) {
            setEdgeRisingAMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (259 == i) {
            setEdgeFallingAMapping((MappingObject) obj);
        } else if (264 == i) {
            setEdgeRisingBMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (917 != i) {
            return false;
        } else {
            setSweepNormalMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDelayBinding
    public void setEdgeFallingBMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mEdgeFallingBMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(260);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDelayBinding
    public void setEdgeRisingAMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mEdgeRisingAMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(263);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDelayBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(2, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDelayBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDelayBinding
    public void setEdgeFallingAMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mEdgeFallingAMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(259);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDelayBinding
    public void setEdgeRisingBMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mEdgeRisingBMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(264);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDelayBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerDelayBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeEdgeFallingBMapping((MappingObject) obj, i2);
            case 1:
                return onChangeEdgeRisingAMapping((MappingObject) obj, i2);
            case 2:
                return onChangeParam((TriggerParam) obj, i2);
            case 3:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 4:
                return onChangeEdgeFallingAMapping((MappingObject) obj, i2);
            case 5:
                return onChangeEdgeRisingBMapping((MappingObject) obj, i2);
            case 6:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 7:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 8:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerDelaySrcbParamDelayChanBValue1((MappingObject) obj, i2);
            case 9:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerDelaySrcaParamDelayChanAValue1((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeEdgeFallingBMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeEdgeRisingAMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
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
        } else if (i == 230) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 268) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 256) {
            synchronized (this) {
                this.mDirtyFlags |= 8404992;
            }
            return true;
        } else if (i == 232) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 231) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 229) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 233) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 234) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 267) {
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
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
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

    private boolean onChangeEdgeFallingAMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangeEdgeRisingBMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerDelaySrcbParamDelayChanBValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerDelaySrcaParamDelayChanAValue1(MappingObject mappingObject, int i) {
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

    /* JADX WARN: Removed duplicated region for block: B:154:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02ee  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterTriggerDelayBindingImpl.executeBindings():void");
    }
}
