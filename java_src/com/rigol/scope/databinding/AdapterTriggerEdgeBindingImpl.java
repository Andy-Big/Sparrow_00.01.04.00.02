package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
public class AdapterTriggerEdgeBindingImpl extends AdapterTriggerEdgeBinding {
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
        sViewsWithIds.put(R.id.view_top, 21);
        sViewsWithIds.put(R.id.view_line_1, 22);
        sViewsWithIds.put(R.id.view_line_2, 23);
        sViewsWithIds.put(R.id.trigger_source_label, 24);
        sViewsWithIds.put(R.id.trigger_holdoff_label, 25);
        sViewsWithIds.put(R.id.trigger_mode_label, 26);
        sViewsWithIds.put(R.id.mode_radio_group, 27);
        sViewsWithIds.put(R.id.edge_type_label, 28);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 29);
    }

    public AdapterTriggerEdgeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 30, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerEdgeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 9, (RadioButton) objArr[7], (Button) objArr[16], (RadioButton) objArr[12], (RadioButton) objArr[11], (RadioButton) objArr[10], (ImageView) objArr[13], (TextView) objArr[28], (Guideline) objArr[19], (Guideline) objArr[18], (Guideline) objArr[20], (RadioGroup) objArr[27], (RadioButton) objArr[8], (RadioButton) objArr[9], (TextView) objArr[3], (TextView) objArr[1], (EditText) objArr[4], (TextView) objArr[25], (TextView) objArr[14], (EditText) objArr[17], (VerticalSeekBar) objArr[15], (TextView) objArr[26], (TextView) objArr[6], (SwitchButton) objArr[5], (TextView) objArr[2], (TextView) objArr[24], (VerticalSeekBarWrapper) objArr[29], (View) objArr[22], (View) objArr[23], (View) objArr[21]);
        this.mDirtyFlags = -1L;
        this.autoRadioButton.setTag(null);
        this.buttonLevel.setTag(null);
        this.edgeEither.setTag(null);
        this.edgeFalling.setTag(null);
        this.edgeRising.setTag(null);
        this.edgeSlopeImageButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.normalRadioButton.setTag(null);
        this.singleRadioButton.setTag(null);
        this.triggerCoupling.setTag(null);
        this.triggerCouplingLabel.setTag(null);
        this.triggerHoldoff.setTag(null);
        this.triggerLevel.setTag(null);
        this.triggerLevelValue.setTag(null);
        this.triggerLevelView.setTag(null);
        this.triggerNoiseLabel.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSource.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 33554432L;
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
        } else if (265 == i) {
            setEdgeRisingMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (258 == i) {
            setEdgeEitherMapping((MappingObject) obj);
        } else if (261 != i) {
            return false;
        } else {
            setEdgeFallingMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerEdgeBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(2, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerEdgeBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        updateRegistration(3, mappingObject);
        this.mSweepAutoMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(916);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerEdgeBinding
    public void setEdgeRisingMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mEdgeRisingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(265);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerEdgeBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mSweepSingleMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(918);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerEdgeBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mSweepNormalMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(917);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerEdgeBinding
    public void setEdgeEitherMapping(MappingObject mappingObject) {
        updateRegistration(7, mappingObject);
        this.mEdgeEitherMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(258);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerEdgeBinding
    public void setEdgeFallingMapping(MappingObject mappingObject) {
        updateRegistration(8, mappingObject);
        this.mEdgeFallingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(261);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerCouplingParamCouplingValue1((MappingObject) obj, i2);
            case 1:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaExtAcParamChanValue1((MappingObject) obj, i2);
            case 2:
                return onChangeParam((TriggerParam) obj, i2);
            case 3:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 4:
                return onChangeEdgeRisingMapping((MappingObject) obj, i2);
            case 5:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 6:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 7:
                return onChangeEdgeEitherMapping((MappingObject) obj, i2);
            case 8:
                return onChangeEdgeFallingMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerCouplingParamCouplingValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaExtAcParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 193) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 377) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 554) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 266) {
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
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeEdgeRisingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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

    private boolean onChangeEdgeEitherMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
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

    private boolean onChangeEdgeFallingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:224:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0172 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01b8 A[ADDED_TO_REGION] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1065
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterTriggerEdgeBindingImpl.executeBindings():void");
    }
}
