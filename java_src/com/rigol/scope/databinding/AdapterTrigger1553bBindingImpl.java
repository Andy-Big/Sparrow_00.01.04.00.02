package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
public class AdapterTrigger1553bBindingImpl extends AdapterTrigger1553bBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private long mDirtyFlags_1;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 38);
        sViewsWithIds.put(R.id.guideline_center, 39);
        sViewsWithIds.put(R.id.guideline_right, 40);
        sViewsWithIds.put(R.id.guideline_forth, 41);
        sViewsWithIds.put(R.id.guideline_fifth, 42);
        sViewsWithIds.put(R.id.view_top, 43);
        sViewsWithIds.put(R.id.view_middle, 44);
        sViewsWithIds.put(R.id.view_bottom, 45);
        sViewsWithIds.put(R.id.height5, 46);
        sViewsWithIds.put(R.id.trigger_1553b_polarity_label, 47);
        sViewsWithIds.put(R.id.trigger_source_label, 48);
        sViewsWithIds.put(R.id.trigger_source_label2, 49);
        sViewsWithIds.put(R.id.trigger_level_select_label, 50);
        sViewsWithIds.put(R.id.trigger_label, 51);
        sViewsWithIds.put(R.id.trigger_noise_label, 52);
        sViewsWithIds.put(R.id.view2, 53);
        sViewsWithIds.put(R.id.view16, 54);
    }

    public AdapterTrigger1553bBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 55, sIncludes, sViewsWithIds));
    }

    private AdapterTrigger1553bBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 17, (Button) objArr[9], (Button) objArr[6], (Guideline) objArr[39], (Guideline) objArr[42], (Guideline) objArr[41], (Guideline) objArr[38], (Guideline) objArr[40], (View) objArr[46], (TextView) objArr[31], (RadioButton) objArr[15], (TextView) objArr[27], (EditText) objArr[26], (RadioButton) objArr[29], (RadioButton) objArr[13], (TextView) objArr[34], (TextView) objArr[33], (RadioButton) objArr[19], (RadioButton) objArr[3], (CheckBox) objArr[1], (RadioButton) objArr[2], (RadioButton) objArr[20], (RadioButton) objArr[18], (RadioButton) objArr[4], (RadioButton) objArr[30], (TextView) objArr[47], (RadioButton) objArr[5], (RadioButton) objArr[16], (TextView) objArr[23], (EditText) objArr[22], (RadioButton) objArr[17], (TextView) objArr[25], (EditText) objArr[24], (RadioButton) objArr[14], (TextView) objArr[36], (TextView) objArr[35], (RadioButton) objArr[21], (TextView) objArr[32], (EditText) objArr[28], (TextView) objArr[51], (TextView) objArr[50], (TextView) objArr[11], (EditText) objArr[10], (TextView) objArr[8], (EditText) objArr[7], (TextView) objArr[52], (SwitchButton) objArr[37], (TextView) objArr[12], (TextView) objArr[48], (TextView) objArr[49], (View) objArr[54], (View) objArr[53], (View) objArr[45], (View) objArr[44], (View) objArr[43]);
        this.mDirtyFlags = -1L;
        this.mDirtyFlags_1 = -1L;
        this.buttonLevela.setTag(null);
        this.buttonLevelb.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.trigger1553bCompareLabel.setTag(null);
        this.trigger1553bData.setTag(null);
        this.trigger1553bDownLimitLabel.setTag(null);
        this.trigger1553bDownLimitValue.setTag(null);
        this.trigger1553bEq.setTag(null);
        this.trigger1553bError.setTag(null);
        this.trigger1553bErrorLabel.setTag(null);
        this.trigger1553bErrorValue.setTag(null);
        this.trigger1553bLessthan.setTag(null);
        this.trigger1553bLevela.setTag(null);
        this.trigger1553bLevelab.setTag(null);
        this.trigger1553bLevelb.setTag(null);
        this.trigger1553bMoreless.setTag(null);
        this.trigger1553bMorethan.setTag(null);
        this.trigger1553bNegative.setTag(null);
        this.trigger1553bNeq.setTag(null);
        this.trigger1553bPositive.setTag(null);
        this.trigger1553bRta.setTag(null);
        this.trigger1553bRta11Label.setTag(null);
        this.trigger1553bRta11Value.setTag(null);
        this.trigger1553bRta11bit.setTag(null);
        this.trigger1553bRtaLabel.setTag(null);
        this.trigger1553bRtaValue.setTag(null);
        this.trigger1553bSync.setTag(null);
        this.trigger1553bSyncLabel.setTag(null);
        this.trigger1553bSyncValue.setTag(null);
        this.trigger1553bUnmoreless.setTag(null);
        this.trigger1553bUpLimitLabel.setTag(null);
        this.trigger1553bUpLimitValue.setTag(null);
        this.triggerLevelaLabel.setTag(null);
        this.triggerLevelaValue.setTag(null);
        this.triggerLevelbLabel.setTag(null);
        this.triggerLevelbValue.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSource.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 35184372088832L;
            this.mDirtyFlags_1 = 0L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags == 0 && this.mDirtyFlags_1 == 0) {
                return false;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (643 == i) {
            setPolarityNegativeMapping((MappingObject) obj);
        } else if (1071 == i) {
            setWhenSyncMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (788 == i) {
            setSelectLevelABMapping((MappingObject) obj);
        } else if (1055 == i) {
            setWhenErrorMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (790 == i) {
            setSelectLevelBMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (1064 == i) {
            setWhenRtabitMapping((MappingObject) obj);
        } else if (644 == i) {
            setPolarityPositiveMapping((MappingObject) obj);
        } else if (1063 == i) {
            setWhenRtaMapping((MappingObject) obj);
        } else if (1054 == i) {
            setWhenDataMapping((MappingObject) obj);
        } else if (789 != i) {
            return false;
        } else {
            setSelectLevelAMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTrigger1553bBinding
    public void setPolarityNegativeMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mPolarityNegativeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(643);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTrigger1553bBinding
    public void setWhenSyncMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mWhenSyncMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(1071);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTrigger1553bBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(2, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTrigger1553bBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTrigger1553bBinding
    public void setSelectLevelABMapping(MappingObject mappingObject) {
        this.mSelectLevelABMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTrigger1553bBinding
    public void setWhenErrorMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mWhenErrorMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(1055);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTrigger1553bBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTrigger1553bBinding
    public void setSelectLevelBMapping(MappingObject mappingObject) {
        updateRegistration(8, mappingObject);
        this.mSelectLevelBMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(790);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTrigger1553bBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTrigger1553bBinding
    public void setWhenRtabitMapping(MappingObject mappingObject) {
        updateRegistration(10, mappingObject);
        this.mWhenRtabitMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(1064);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTrigger1553bBinding
    public void setPolarityPositiveMapping(MappingObject mappingObject) {
        updateRegistration(11, mappingObject);
        this.mPolarityPositiveMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(644);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTrigger1553bBinding
    public void setWhenRtaMapping(MappingObject mappingObject) {
        updateRegistration(13, mappingObject);
        this.mWhenRtaMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        notifyPropertyChanged(1063);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTrigger1553bBinding
    public void setWhenDataMapping(MappingObject mappingObject) {
        updateRegistration(14, mappingObject);
        this.mWhenDataMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
        }
        notifyPropertyChanged(1054);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTrigger1553bBinding
    public void setSelectLevelAMapping(MappingObject mappingObject) {
        updateRegistration(15, mappingObject);
        this.mSelectLevelAMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(789);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangePolarityNegativeMapping((MappingObject) obj, i2);
            case 1:
                return onChangeWhenSyncMapping((MappingObject) obj, i2);
            case 2:
                return onChangeParam((TriggerParam) obj, i2);
            case 3:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 4:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceParamChanValue1((MappingObject) obj, i2);
            case 5:
                return onChangeSelectLevelABMapping((MappingObject) obj, i2);
            case 6:
                return onChangeWhenErrorMapping((MappingObject) obj, i2);
            case 7:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 8:
                return onChangeSelectLevelBMapping((MappingObject) obj, i2);
            case 9:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 10:
                return onChangeWhenRtabitMapping((MappingObject) obj, i2);
            case 11:
                return onChangePolarityPositiveMapping((MappingObject) obj, i2);
            case 12:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTrigger1553bSyncTypeParamTrigger1553SyncValue1((MappingObject) obj, i2);
            case 13:
                return onChangeWhenRtaMapping((MappingObject) obj, i2);
            case 14:
                return onChangeWhenDataMapping((MappingObject) obj, i2);
            case 15:
                return onChangeSelectLevelAMapping((MappingObject) obj, i2);
            case 16:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTrigger1553bErrTypeParamTrigger1553ErrValue1((MappingObject) obj, i2);
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
                this.mDirtyFlags |= 2;
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
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 538) {
            synchronized (this) {
                this.mDirtyFlags |= 1572864;
            }
            return true;
        } else if (i == 680) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 540) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 539) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= 50331648;
            }
            return true;
        } else if (i == 950) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else if (i == 977) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else if (i == 343) {
            synchronized (this) {
                this.mDirtyFlags |= 268435456;
            }
            return true;
        } else if (i == 345) {
            synchronized (this) {
                this.mDirtyFlags |= 536870912;
            }
            return true;
        } else if (i == 346) {
            synchronized (this) {
                this.mDirtyFlags |= 1073741824;
            }
            return true;
        } else if (i == 344) {
            synchronized (this) {
                this.mDirtyFlags |= 2147483648L;
            }
            return true;
        } else if (i == 948) {
            synchronized (this) {
                this.mDirtyFlags |= 4294967296L;
            }
            return true;
        } else if (i == 949) {
            synchronized (this) {
                this.mDirtyFlags |= 8589934592L;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= 17179869184L;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangeSelectLevelABMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeWhenErrorMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSelectLevelBMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
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

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeWhenRtabitMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
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

    private boolean onChangePolarityPositiveMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 549755813888L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTrigger1553bSyncTypeParamTrigger1553SyncValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 1099511627776L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeWhenRtaMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 2199023255552L;
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
                this.mDirtyFlags |= 4398046511104L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSelectLevelAMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 8796093022208L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTrigger1553bErrTypeParamTrigger1553ErrValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 17592186044416L;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x022c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x023f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x040d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x05cc  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x05ec  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x05f7  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x060b  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0617  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0621  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0634  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0640  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x064c  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0656  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0675  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x067d  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x06ab  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0729  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0730  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x0752  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x075f  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x078f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x07a0  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x07b1  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x07c9  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x07d6  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x07e3  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x07f0  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x0804  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x0811  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x081e  */
    /* JADX WARN: Removed duplicated region for block: B:447:0x082f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x083c  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x084d  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x085a  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x086b  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x0878  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x0889  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x0896  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x08a7  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x08b8  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x08c9  */
    /* JADX WARN: Removed duplicated region for block: B:484:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0190  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 2260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterTrigger1553bBindingImpl.executeBindings():void");
    }
}
