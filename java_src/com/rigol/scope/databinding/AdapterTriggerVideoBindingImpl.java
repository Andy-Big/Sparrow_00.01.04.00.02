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
public class AdapterTriggerVideoBindingImpl extends AdapterTriggerVideoBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 15);
        sViewsWithIds.put(R.id.guideline_center, 16);
        sViewsWithIds.put(R.id.guideline_right, 17);
        sViewsWithIds.put(R.id.guideline_forth, 18);
        sViewsWithIds.put(R.id.view_top, 19);
        sViewsWithIds.put(R.id.view_1, 20);
        sViewsWithIds.put(R.id.view_2, 21);
        sViewsWithIds.put(R.id.view15, 22);
        sViewsWithIds.put(R.id.trigger_source_label, 23);
        sViewsWithIds.put(R.id.trigger_polarity_label, 24);
        sViewsWithIds.put(R.id.button_level, 25);
        sViewsWithIds.put(R.id.video_standard, 26);
        sViewsWithIds.put(R.id.trigger_video_sync, 27);
        sViewsWithIds.put(R.id.trigger_level, 28);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 29);
        sViewsWithIds.put(R.id.trigger_noise_label, 30);
    }

    public AdapterTriggerVideoBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 31, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerVideoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 12, (RadioButton) objArr[8], (Button) objArr[25], (RadioButton) objArr[11], (Guideline) objArr[16], (Guideline) objArr[18], (Guideline) objArr[15], (Guideline) objArr[17], (ImageView) objArr[6], (RadioButton) objArr[9], (TextView) objArr[13], (EditText) objArr[14], (RadioButton) objArr[10], (RadioButton) objArr[3], (RadioButton) objArr[2], (TextView) objArr[28], (EditText) objArr[5], (VerticalSeekBar) objArr[7], (TextView) objArr[30], (SwitchButton) objArr[12], (TextView) objArr[24], (TextView) objArr[1], (TextView) objArr[23], (TextView) objArr[27], (VerticalSeekBarWrapper) objArr[29], (TextView) objArr[26], (TextView) objArr[4], (View) objArr[20], (View) objArr[22], (View) objArr[21], (View) objArr[19]);
        this.mDirtyFlags = -1L;
        this.allLines.setTag(null);
        this.even.setTag(null);
        this.imageView2.setTag(null);
        this.lines.setTag(null);
        this.linesNumber.setTag(null);
        this.linesNumberValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.odd.setTag(null);
        this.polarityN.setTag(null);
        this.polarityP.setTag(null);
        this.triggerLevelValue.setTag(null);
        this.triggerLevelView.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSource.setTag(null);
        this.videoStandardValue.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 268435456L;
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
        if (643 == i) {
            setPolarityNegativeMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (644 != i) {
            return false;
        } else {
            setPolarityPositiveMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerVideoBinding
    public void setPolarityNegativeMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mPolarityNegativeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(643);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerVideoBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(3, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerVideoBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerVideoBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerVideoBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerVideoBinding
    public void setPolarityPositiveMapping(MappingObject mappingObject) {
        updateRegistration(9, mappingObject);
        this.mPolarityPositiveMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(644);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangePolarityNegativeMapping((MappingObject) obj, i2);
            case 1:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoStandardParamVideoFormatValue1((MappingObject) obj, i2);
            case 2:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoSyncInt0((MappingObject) obj, i2);
            case 3:
                return onChangeParam((TriggerParam) obj, i2);
            case 4:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 5:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoSyncInt2((MappingObject) obj, i2);
            case 6:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 7:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoSyncInt3((MappingObject) obj, i2);
            case 8:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 9:
                return onChangePolarityPositiveMapping((MappingObject) obj, i2);
            case 10:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1((MappingObject) obj, i2);
            case 11:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoSyncInt1((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangePolarityNegativeMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoStandardParamVideoFormatValue1(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoSyncInt0(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
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
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 1030) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 1029) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 484) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 671) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 1031) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 503) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoSyncInt2(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoSyncInt3(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
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
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean onChangePolarityPositiveMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerVideoSyncInt1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
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

    /* JADX WARN: Removed duplicated region for block: B:103:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:222:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x015a A[ADDED_TO_REGION] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 948
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterTriggerVideoBindingImpl.executeBindings():void");
    }
}
