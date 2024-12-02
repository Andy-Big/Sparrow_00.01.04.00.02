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
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

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
    */
    protected void executeBindings() {
        long j;
        long j2;
        String str;
        MappingObject mappingObject;
        MappingObject mappingObject2;
        MappingObject mappingObject3;
        long j3;
        long j4;
        long j5;
        String str2;
        String str3;
        String str4;
        String str5;
        ServiceEnum.Trigger_value_cmp trigger_value_cmp;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        boolean z;
        int i;
        boolean z2;
        int i2;
        int i3;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        int i4;
        boolean z17;
        boolean z18;
        int i5;
        String str11;
        String str12;
        String str13;
        String str14;
        ServiceEnum.Trigger_value_cmp trigger_value_cmp2;
        String str15;
        String str16;
        boolean z19;
        int i6;
        int i7;
        int i8;
        int i9;
        String str17;
        int i10;
        int i11;
        int i12;
        boolean z20;
        boolean z21;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        boolean z26;
        boolean z27;
        boolean z28;
        long j6;
        ServiceEnum.Trigger_value_cmp trigger_value_cmp3;
        boolean z29;
        boolean z30;
        boolean z31;
        boolean z32;
        boolean z33;
        boolean z34;
        String str18;
        String str19;
        boolean z35;
        boolean z36;
        boolean z37;
        boolean z38;
        int i17;
        int i18;
        String str20;
        String str21;
        boolean z39;
        boolean z40;
        boolean z41;
        boolean z42;
        int i19;
        int i20;
        int i21;
        int i22;
        boolean z43;
        boolean z44;
        String str22;
        boolean z45;
        String str23;
        String str24;
        String str25;
        String str26;
        ServiceEnum.Trigger_1553_Err trigger_1553_Err;
        int i23;
        int i24;
        long j7;
        ServiceEnum.Trigger_1553_When trigger_1553_When;
        int i25;
        ServiceEnum.Chan chan;
        ServiceEnum.Trigger_Level_ID trigger_Level_ID;
        long j8;
        ServiceEnum.TriggerPulsePolarity triggerPulsePolarity;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
            j2 = this.mDirtyFlags_1;
            this.mDirtyFlags_1 = 0L;
        }
        MappingObject mappingObject4 = this.mPolarityNegativeMapping;
        MappingObject mappingObject5 = this.mWhenSyncMapping;
        TriggerParam triggerParam = this.mParam;
        MappingObject mappingObject6 = this.mWhenErrorMapping;
        MappingObject mappingObject7 = this.mSelectLevelBMapping;
        MappingObject mappingObject8 = this.mWhenRtabitMapping;
        MappingObject mappingObject9 = this.mPolarityPositiveMapping;
        MappingObject mappingObject10 = this.mWhenRtaMapping;
        MappingObject mappingObject11 = this.mWhenDataMapping;
        MappingObject mappingObject12 = this.mSelectLevelAMapping;
        String str27 = null;
        String str28 = ((j & 35184372219905L) == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        String str29 = ((j & 35184372350978L) == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        if ((j & 53944788783124L) != 0) {
            if ((j & 35184372613124L) != 0) {
                if ((triggerParam != null ? triggerParam.getMilstdTrigger_Level_ID() : null) == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                    z23 = true;
                    if ((j & 35184374185988L) == 0) {
                        if (triggerParam != null) {
                            triggerPulsePolarity = triggerParam.getPulsePolarity();
                            z24 = z23;
                        } else {
                            z24 = z23;
                            triggerPulsePolarity = null;
                        }
                        boolean z46 = triggerPulsePolarity == ServiceEnum.TriggerPulsePolarity.Trigger_pulse_negative;
                        z26 = triggerPulsePolarity == ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive;
                        z25 = z46;
                    } else {
                        z24 = z23;
                        z25 = false;
                        z26 = false;
                    }
                    if ((j & 35184506306564L) == 0) {
                        if (triggerParam != null) {
                            z28 = z26;
                            z27 = z25;
                            trigger_value_cmp3 = triggerParam.getTrigger_value_cmp();
                        } else {
                            z27 = z25;
                            z28 = z26;
                            trigger_value_cmp3 = null;
                        }
                        z30 = trigger_value_cmp3 == ServiceEnum.Trigger_value_cmp.cmp_neq;
                        z31 = trigger_value_cmp3 == ServiceEnum.Trigger_value_cmp.cmp_in;
                        z32 = trigger_value_cmp3 == ServiceEnum.Trigger_value_cmp.cmp_gt;
                        z33 = trigger_value_cmp3 == ServiceEnum.Trigger_value_cmp.cmp_eq;
                        z34 = trigger_value_cmp3 == ServiceEnum.Trigger_value_cmp.cmp_out;
                        z29 = trigger_value_cmp3 == ServiceEnum.Trigger_value_cmp.cmp_lt;
                        j6 = 0;
                        if ((j & 18014398509481984L) != 0) {
                            j = z29 ? j | 140737488355328L : j | 70368744177664L;
                        }
                    } else {
                        z27 = z25;
                        z28 = z26;
                        j6 = 0;
                        trigger_value_cmp3 = null;
                        z29 = false;
                        z30 = false;
                        z31 = false;
                        z32 = false;
                        z33 = false;
                        z34 = false;
                    }
                    String formatValue6MaxStr = ((j & 35186519572484L) != j6 || triggerParam == null) ? null : triggerParam.getFormatValue6MaxStr();
                    if ((j & 35184376283140L) == j6) {
                        if (triggerParam != null) {
                            mappingObject = mappingObject12;
                            trigger_value_cmp = trigger_value_cmp3;
                            j8 = triggerParam.getMilstdlevelB();
                        } else {
                            mappingObject = mappingObject12;
                            trigger_value_cmp = trigger_value_cmp3;
                            j8 = 0;
                        }
                        if (triggerParam != null) {
                            str18 = triggerParam.getTriggerLevelStr(j8);
                            if ((j & 35184373137412L) != 0) {
                                if (triggerParam != null) {
                                    trigger_Level_ID = triggerParam.getMilstdTrigger_Level_ID();
                                    str19 = str18;
                                } else {
                                    str19 = str18;
                                    trigger_Level_ID = null;
                                }
                                boolean z47 = trigger_Level_ID == ServiceEnum.Trigger_Level_ID.Trigger_Level_High;
                                z36 = trigger_Level_ID == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low;
                                z35 = z47;
                            } else {
                                str19 = str18;
                                z35 = false;
                                z36 = false;
                            }
                            if ((j & 35184405643268L) != 0) {
                                if (triggerParam != null) {
                                    z37 = z35;
                                    chan = triggerParam.getChan();
                                } else {
                                    z37 = z35;
                                    chan = null;
                                }
                                z38 = z36;
                                i17 = ColorUtil.getColor(getRoot().getContext(), chan);
                            } else {
                                z37 = z35;
                                z38 = z36;
                                i17 = 0;
                            }
                            if ((j & 36292473655300L) != 0) {
                                ServiceEnum.Trigger_1553_Sync trigger_1553_Sync = triggerParam != null ? triggerParam.getTrigger_1553_Sync() : null;
                                if (trigger_1553_Sync != null) {
                                    i25 = trigger_1553_Sync.value1;
                                    i18 = i17;
                                } else {
                                    i18 = i17;
                                    i25 = 0;
                                }
                                MappingObject mappingObject13 = ViewUtil.getMappingObject(R.array.msg_trigger_1553b_sync_type, i25);
                                updateRegistration(12, mappingObject13);
                                if (mappingObject13 != null) {
                                    str20 = mappingObject13.getStr();
                                    boolean isNoise = ((j & 35201551958020L) != 0 || triggerParam == null) ? false : triggerParam.getIsNoise();
                                    String formatValue6RtaStr = ((j & 35184908959748L) != 0 || triggerParam == null) ? null : triggerParam.getFormatValue6RtaStr();
                                    if ((j & 35184573415428L) == 0) {
                                        if (triggerParam != null) {
                                            str21 = str20;
                                            trigger_1553_When = triggerParam.getTrigger_1553_When();
                                        } else {
                                            str21 = str20;
                                            trigger_1553_When = null;
                                        }
                                        int i26 = ((j & 35184439197700L) > 0L ? 1 : ((j & 35184439197700L) == 0L ? 0 : -1));
                                        if (i26 != 0) {
                                            z39 = isNoise;
                                            z15 = z29;
                                            z41 = trigger_1553_When == ServiceEnum.Trigger_1553_When.trig_1553_data;
                                            str = str28;
                                            z3 = trigger_1553_When == ServiceEnum.Trigger_1553_When.trig_1553_status;
                                            mappingObject3 = mappingObject11;
                                            boolean z48 = trigger_1553_When == ServiceEnum.Trigger_1553_When.trig_1553_err;
                                            mappingObject2 = mappingObject10;
                                            z5 = trigger_1553_When == ServiceEnum.Trigger_1553_When.trig_1553_cmd;
                                            z42 = trigger_1553_When == ServiceEnum.Trigger_1553_When.trig_1553_sync;
                                            if (i26 != 0) {
                                                j |= z41 ? 562949953421312L : 281474976710656L;
                                            }
                                            int i27 = ((j & 35184439197700L) > 0L ? 1 : ((j & 35184439197700L) == 0L ? 0 : -1));
                                            if (i27 != 0) {
                                                j2 |= z3 ? 32L : 16L;
                                            }
                                            if (i27 != 0) {
                                                j2 |= z48 ? 8L : 4L;
                                            }
                                            if (i27 != 0) {
                                                j |= z5 ? 9007199254740992L : 4503599627370496L;
                                            }
                                            if ((j & 35184439197700L) != 0) {
                                                j |= z42 ? 576460752303423488L : 288230376151711744L;
                                            }
                                            i19 = z41 ? 0 : 8;
                                            i20 = z3 ? 0 : 8;
                                            i21 = z48 ? 0 : 8;
                                            i22 = z42 ? 0 : 8;
                                            z43 = z48;
                                        } else {
                                            str = str28;
                                            z39 = isNoise;
                                            z15 = z29;
                                            mappingObject2 = mappingObject10;
                                            mappingObject3 = mappingObject11;
                                            z41 = false;
                                            z3 = false;
                                            z42 = false;
                                            z5 = false;
                                            i19 = 0;
                                            i20 = 0;
                                            i21 = 0;
                                            i22 = 0;
                                            z43 = false;
                                        }
                                        z40 = trigger_1553_When != ServiceEnum.Trigger_1553_When.trig_1553_data;
                                        if ((j & 35184573415428L) != 0) {
                                            if (z40) {
                                                j |= 36028797018963968L;
                                                j2 |= 2;
                                            } else {
                                                j |= 18014398509481984L;
                                                j2 |= 1;
                                            }
                                        }
                                    } else {
                                        str = str28;
                                        str21 = str20;
                                        z39 = isNoise;
                                        z15 = z29;
                                        mappingObject2 = mappingObject10;
                                        mappingObject3 = mappingObject11;
                                        z40 = false;
                                        z41 = false;
                                        z3 = false;
                                        z42 = false;
                                        z5 = false;
                                        i19 = 0;
                                        i20 = 0;
                                        i21 = 0;
                                        i22 = 0;
                                        z43 = false;
                                    }
                                    if ((j & 35184380477444L) == 0) {
                                        if (triggerParam != null) {
                                            z44 = z41;
                                            j7 = triggerParam.getMilstdlevelA();
                                        } else {
                                            z44 = z41;
                                            j7 = 0;
                                        }
                                        if (triggerParam != null) {
                                            str22 = triggerParam.getTriggerLevelStr(j7);
                                            if ((j & 35218748604436L) != 0) {
                                                ServiceEnum.Chan chan2 = triggerParam != null ? triggerParam.getChan() : null;
                                                if (chan2 != null) {
                                                    i24 = chan2.value1;
                                                    z45 = z40;
                                                } else {
                                                    z45 = z40;
                                                    i24 = 0;
                                                }
                                                MappingObject mappingObject14 = ViewUtil.getMappingObject(R.array.msg_trigger_source, i24);
                                                updateRegistration(4, mappingObject14);
                                                if (mappingObject14 != null) {
                                                    str23 = mappingObject14.getStr();
                                                    String formatValue6BitStr = ((j & 35184640524292L) != 0 || triggerParam == null) ? null : triggerParam.getFormatValue6BitStr();
                                                    if ((j & 52780853166084L) == 0) {
                                                        if (triggerParam != null) {
                                                            str24 = str23;
                                                            trigger_1553_Err = triggerParam.getTrigger_1553_Err();
                                                        } else {
                                                            str24 = str23;
                                                            trigger_1553_Err = null;
                                                        }
                                                        if (trigger_1553_Err != null) {
                                                            i23 = trigger_1553_Err.value1;
                                                            str25 = str22;
                                                        } else {
                                                            str25 = str22;
                                                            i23 = 0;
                                                        }
                                                        MappingObject mappingObject15 = ViewUtil.getMappingObject(R.array.msg_trigger_1553b_err_type, i23);
                                                        updateRegistration(16, mappingObject15);
                                                        if (mappingObject15 != null) {
                                                            str26 = mappingObject15.getStr();
                                                            j3 = 0;
                                                            if ((j & 35185445830660L) != 0 || triggerParam == null) {
                                                                str8 = formatValue6BitStr;
                                                                z18 = z28;
                                                                str9 = formatValue6MaxStr;
                                                                i4 = i18;
                                                                z8 = z38;
                                                                str10 = formatValue6RtaStr;
                                                                z17 = z39;
                                                                i5 = i22;
                                                                str4 = str25;
                                                                str6 = str26;
                                                                j4 = j;
                                                                str7 = null;
                                                                z11 = z30;
                                                                z12 = z34;
                                                                str5 = str21;
                                                                i = i19;
                                                                z2 = z44;
                                                                z = z45;
                                                                z7 = z24;
                                                                z13 = z32;
                                                                z14 = z33;
                                                                str2 = str24;
                                                            } else {
                                                                str8 = formatValue6BitStr;
                                                                z18 = z28;
                                                                str9 = formatValue6MaxStr;
                                                                i4 = i18;
                                                                z8 = z38;
                                                                str10 = formatValue6RtaStr;
                                                                z17 = z39;
                                                                i5 = i22;
                                                                str4 = str25;
                                                                str6 = str26;
                                                                str7 = triggerParam.getFormatValue6Str();
                                                                z11 = z30;
                                                                z12 = z34;
                                                                str5 = str21;
                                                                z = z45;
                                                                j4 = j;
                                                                z7 = z24;
                                                                z13 = z32;
                                                                i = i19;
                                                                z2 = z44;
                                                                str2 = str24;
                                                                z14 = z33;
                                                            }
                                                            z6 = z27;
                                                            str3 = str19;
                                                            z9 = z37;
                                                            z10 = z31;
                                                            j5 = j2;
                                                            i3 = i20;
                                                            i2 = i21;
                                                            z16 = z42;
                                                            z4 = z43;
                                                        }
                                                    } else {
                                                        str24 = str23;
                                                        str25 = str22;
                                                    }
                                                    str26 = null;
                                                    j3 = 0;
                                                    if ((j & 35185445830660L) != 0) {
                                                    }
                                                    str8 = formatValue6BitStr;
                                                    z18 = z28;
                                                    str9 = formatValue6MaxStr;
                                                    i4 = i18;
                                                    z8 = z38;
                                                    str10 = formatValue6RtaStr;
                                                    z17 = z39;
                                                    i5 = i22;
                                                    str4 = str25;
                                                    str6 = str26;
                                                    j4 = j;
                                                    str7 = null;
                                                    z11 = z30;
                                                    z12 = z34;
                                                    str5 = str21;
                                                    i = i19;
                                                    z2 = z44;
                                                    z = z45;
                                                    z7 = z24;
                                                    z13 = z32;
                                                    z14 = z33;
                                                    str2 = str24;
                                                    z6 = z27;
                                                    str3 = str19;
                                                    z9 = z37;
                                                    z10 = z31;
                                                    j5 = j2;
                                                    i3 = i20;
                                                    i2 = i21;
                                                    z16 = z42;
                                                    z4 = z43;
                                                }
                                            } else {
                                                z45 = z40;
                                            }
                                            str23 = null;
                                            if ((j & 35184640524292L) != 0) {
                                            }
                                            if ((j & 52780853166084L) == 0) {
                                            }
                                            str26 = null;
                                            j3 = 0;
                                            if ((j & 35185445830660L) != 0) {
                                            }
                                            str8 = formatValue6BitStr;
                                            z18 = z28;
                                            str9 = formatValue6MaxStr;
                                            i4 = i18;
                                            z8 = z38;
                                            str10 = formatValue6RtaStr;
                                            z17 = z39;
                                            i5 = i22;
                                            str4 = str25;
                                            str6 = str26;
                                            j4 = j;
                                            str7 = null;
                                            z11 = z30;
                                            z12 = z34;
                                            str5 = str21;
                                            i = i19;
                                            z2 = z44;
                                            z = z45;
                                            z7 = z24;
                                            z13 = z32;
                                            z14 = z33;
                                            str2 = str24;
                                            z6 = z27;
                                            str3 = str19;
                                            z9 = z37;
                                            z10 = z31;
                                            j5 = j2;
                                            i3 = i20;
                                            i2 = i21;
                                            z16 = z42;
                                            z4 = z43;
                                        }
                                    } else {
                                        z44 = z41;
                                    }
                                    str22 = null;
                                    if ((j & 35218748604436L) != 0) {
                                    }
                                    str23 = null;
                                    if ((j & 35184640524292L) != 0) {
                                    }
                                    if ((j & 52780853166084L) == 0) {
                                    }
                                    str26 = null;
                                    j3 = 0;
                                    if ((j & 35185445830660L) != 0) {
                                    }
                                    str8 = formatValue6BitStr;
                                    z18 = z28;
                                    str9 = formatValue6MaxStr;
                                    i4 = i18;
                                    z8 = z38;
                                    str10 = formatValue6RtaStr;
                                    z17 = z39;
                                    i5 = i22;
                                    str4 = str25;
                                    str6 = str26;
                                    j4 = j;
                                    str7 = null;
                                    z11 = z30;
                                    z12 = z34;
                                    str5 = str21;
                                    i = i19;
                                    z2 = z44;
                                    z = z45;
                                    z7 = z24;
                                    z13 = z32;
                                    z14 = z33;
                                    str2 = str24;
                                    z6 = z27;
                                    str3 = str19;
                                    z9 = z37;
                                    z10 = z31;
                                    j5 = j2;
                                    i3 = i20;
                                    i2 = i21;
                                    z16 = z42;
                                    z4 = z43;
                                }
                            } else {
                                i18 = i17;
                            }
                            str20 = null;
                            if ((j & 35201551958020L) != 0) {
                            }
                            if ((j & 35184908959748L) != 0) {
                            }
                            if ((j & 35184573415428L) == 0) {
                            }
                            if ((j & 35184380477444L) == 0) {
                            }
                            str22 = null;
                            if ((j & 35218748604436L) != 0) {
                            }
                            str23 = null;
                            if ((j & 35184640524292L) != 0) {
                            }
                            if ((j & 52780853166084L) == 0) {
                            }
                            str26 = null;
                            j3 = 0;
                            if ((j & 35185445830660L) != 0) {
                            }
                            str8 = formatValue6BitStr;
                            z18 = z28;
                            str9 = formatValue6MaxStr;
                            i4 = i18;
                            z8 = z38;
                            str10 = formatValue6RtaStr;
                            z17 = z39;
                            i5 = i22;
                            str4 = str25;
                            str6 = str26;
                            j4 = j;
                            str7 = null;
                            z11 = z30;
                            z12 = z34;
                            str5 = str21;
                            i = i19;
                            z2 = z44;
                            z = z45;
                            z7 = z24;
                            z13 = z32;
                            z14 = z33;
                            str2 = str24;
                            z6 = z27;
                            str3 = str19;
                            z9 = z37;
                            z10 = z31;
                            j5 = j2;
                            i3 = i20;
                            i2 = i21;
                            z16 = z42;
                            z4 = z43;
                        }
                    } else {
                        mappingObject = mappingObject12;
                        trigger_value_cmp = trigger_value_cmp3;
                    }
                    str18 = null;
                    if ((j & 35184373137412L) != 0) {
                    }
                    if ((j & 35184405643268L) != 0) {
                    }
                    if ((j & 36292473655300L) != 0) {
                    }
                    str20 = null;
                    if ((j & 35201551958020L) != 0) {
                    }
                    if ((j & 35184908959748L) != 0) {
                    }
                    if ((j & 35184573415428L) == 0) {
                    }
                    if ((j & 35184380477444L) == 0) {
                    }
                    str22 = null;
                    if ((j & 35218748604436L) != 0) {
                    }
                    str23 = null;
                    if ((j & 35184640524292L) != 0) {
                    }
                    if ((j & 52780853166084L) == 0) {
                    }
                    str26 = null;
                    j3 = 0;
                    if ((j & 35185445830660L) != 0) {
                    }
                    str8 = formatValue6BitStr;
                    z18 = z28;
                    str9 = formatValue6MaxStr;
                    i4 = i18;
                    z8 = z38;
                    str10 = formatValue6RtaStr;
                    z17 = z39;
                    i5 = i22;
                    str4 = str25;
                    str6 = str26;
                    j4 = j;
                    str7 = null;
                    z11 = z30;
                    z12 = z34;
                    str5 = str21;
                    i = i19;
                    z2 = z44;
                    z = z45;
                    z7 = z24;
                    z13 = z32;
                    z14 = z33;
                    str2 = str24;
                    z6 = z27;
                    str3 = str19;
                    z9 = z37;
                    z10 = z31;
                    j5 = j2;
                    i3 = i20;
                    i2 = i21;
                    z16 = z42;
                    z4 = z43;
                }
            }
            z23 = false;
            if ((j & 35184374185988L) == 0) {
            }
            if ((j & 35184506306564L) == 0) {
            }
            if ((j & 35186519572484L) != j6) {
            }
            if ((j & 35184376283140L) == j6) {
            }
            str18 = null;
            if ((j & 35184373137412L) != 0) {
            }
            if ((j & 35184405643268L) != 0) {
            }
            if ((j & 36292473655300L) != 0) {
            }
            str20 = null;
            if ((j & 35201551958020L) != 0) {
            }
            if ((j & 35184908959748L) != 0) {
            }
            if ((j & 35184573415428L) == 0) {
            }
            if ((j & 35184380477444L) == 0) {
            }
            str22 = null;
            if ((j & 35218748604436L) != 0) {
            }
            str23 = null;
            if ((j & 35184640524292L) != 0) {
            }
            if ((j & 52780853166084L) == 0) {
            }
            str26 = null;
            j3 = 0;
            if ((j & 35185445830660L) != 0) {
            }
            str8 = formatValue6BitStr;
            z18 = z28;
            str9 = formatValue6MaxStr;
            i4 = i18;
            z8 = z38;
            str10 = formatValue6RtaStr;
            z17 = z39;
            i5 = i22;
            str4 = str25;
            str6 = str26;
            j4 = j;
            str7 = null;
            z11 = z30;
            z12 = z34;
            str5 = str21;
            i = i19;
            z2 = z44;
            z = z45;
            z7 = z24;
            z13 = z32;
            z14 = z33;
            str2 = str24;
            z6 = z27;
            str3 = str19;
            z9 = z37;
            z10 = z31;
            j5 = j2;
            i3 = i20;
            i2 = i21;
            z16 = z42;
            z4 = z43;
        } else {
            str = str28;
            mappingObject = mappingObject12;
            mappingObject2 = mappingObject10;
            mappingObject3 = mappingObject11;
            j3 = 0;
            j4 = j;
            j5 = j2;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            trigger_value_cmp = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
            z = false;
            i = 0;
            z2 = false;
            i2 = 0;
            i3 = 0;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
            z8 = false;
            z9 = false;
            z10 = false;
            z11 = false;
            z12 = false;
            z13 = false;
            z14 = false;
            z15 = false;
            z16 = false;
            i4 = 0;
            z17 = false;
            z18 = false;
            i5 = 0;
        }
        String str30 = ((j4 & 35253091565632L) == j3 || mappingObject6 == null) ? null : mappingObject6.getStr();
        String str31 = ((j4 & 35321811042560L) == j3 || mappingObject7 == null) ? null : mappingObject7.getStr();
        String str32 = ((j4 & 35459249996800L) == j3 || mappingObject8 == null) ? null : mappingObject8.getStr();
        String str33 = ((j4 & 35734127904768L) == j3 || mappingObject9 == null) ? null : mappingObject9.getStr();
        if ((j4 & 37383395352576L) == j3 || mappingObject2 == null) {
            str11 = str32;
            str12 = null;
        } else {
            String str34 = mappingObject2.getStr();
            str11 = str32;
            str12 = str34;
        }
        if ((j4 & 39582418616320L) == j3 || mappingObject3 == null) {
            str13 = str12;
            str14 = null;
        } else {
            String str35 = mappingObject3.getStr();
            str13 = str12;
            str14 = str35;
        }
        if ((j4 & 43980465143808L) != j3 && mappingObject != null) {
            str27 = mappingObject.getStr();
        }
        String str36 = str33;
        String str37 = str27;
        int i28 = ((j4 & 18014398509481984L) > j3 ? 1 : ((j4 & 18014398509481984L) == j3 ? 0 : -1));
        if (i28 == 0 && (j5 & 1) == j3) {
            str16 = str37;
            trigger_value_cmp2 = trigger_value_cmp;
            z19 = z15;
            str15 = str31;
        } else {
            if (triggerParam != null) {
                trigger_value_cmp = triggerParam.getTrigger_value_cmp();
            }
            trigger_value_cmp2 = trigger_value_cmp;
            str15 = str31;
            if (i28 != 0) {
                z15 = trigger_value_cmp2 == ServiceEnum.Trigger_value_cmp.cmp_lt;
                if (i28 != 0) {
                    j4 = z15 ? j4 | 140737488355328L : j4 | 70368744177664L;
                }
            }
            int i29 = ((j5 & 1) > 0L ? 1 : ((j5 & 1) == 0L ? 0 : -1));
            str16 = str37;
            if (i29 != 0) {
                boolean z49 = trigger_value_cmp2 != ServiceEnum.Trigger_value_cmp.cmp_lt;
                if (i29 != 0) {
                    j4 |= z49 ? LockFreeTaskQueueCore.CLOSED_MASK : LockFreeTaskQueueCore.FROZEN_MASK;
                }
                i6 = z49 ? 0 : 8;
                z19 = z15;
                i7 = ((j4 & 35184439197700L) > 0L ? 1 : ((j4 & 35184439197700L) == 0L ? 0 : -1));
                if (i7 == 0) {
                    boolean z50 = z5 ? true : z3;
                    if (i7 != 0) {
                        j4 |= z50 ? 144115188075855872L : 72057594037927936L;
                    }
                    i8 = i6;
                    i9 = z50 ? 0 : 8;
                } else {
                    i8 = i6;
                    i9 = 0;
                }
                if ((j4 & 35184573415428L) == 0) {
                    if (z) {
                        i8 = 8;
                    }
                    int i30 = i8;
                    str17 = str30;
                    i10 = i30;
                } else {
                    str17 = str30;
                    i10 = 0;
                }
                if ((j4 & 70368744177664L) == 0) {
                    i11 = i10;
                    z10 = trigger_value_cmp2 == ServiceEnum.Trigger_value_cmp.cmp_in;
                } else {
                    i11 = i10;
                }
                boolean z51 = z10;
                i12 = ((j4 & 18014398509481984L) > 0L ? 1 : ((j4 & 18014398509481984L) == 0L ? 0 : -1));
                if (i12 == 0) {
                    z20 = z19 ? true : z51;
                    if (i12 != 0) {
                        j4 |= z20 ? Long.MIN_VALUE : 4611686018427387904L;
                    }
                } else {
                    z20 = false;
                }
                if ((j4 & 4611686018427387904L) == 0) {
                    z21 = z51;
                    z12 = trigger_value_cmp2 == ServiceEnum.Trigger_value_cmp.cmp_out;
                } else {
                    z21 = z51;
                }
                boolean z52 = z12;
                i13 = ((j4 & 18014398509481984L) > 0L ? 1 : ((j4 & 18014398509481984L) == 0L ? 0 : -1));
                if (i13 != 0) {
                    boolean z53 = z20 ? true : z52;
                    if (i13 != 0) {
                        j4 |= z53 ? 2251799813685248L : 1125899906842624L;
                    }
                    if (!z53) {
                        i14 = 8;
                        i15 = ((j4 & 35184573415428L) > 0L ? 1 : ((j4 & 35184573415428L) == 0L ? 0 : -1));
                        if (i15 != 0) {
                            i16 = z ? 8 : i14;
                        } else {
                            i16 = 0;
                        }
                        if ((j4 & 35184372088832L) != 0) {
                            z22 = z52;
                            this.buttonLevela.setVisibility(0);
                            this.buttonLevelb.setVisibility(0);
                            this.triggerLevelaLabel.setVisibility(0);
                            this.triggerLevelaValue.setVisibility(0);
                            this.triggerLevelbLabel.setVisibility(0);
                            this.triggerLevelbValue.setVisibility(0);
                        } else {
                            z22 = z52;
                        }
                        if ((j4 & 35184439197700L) != 0) {
                            this.trigger1553bCompareLabel.setVisibility(i);
                            CompoundButtonBindingAdapter.setChecked(this.trigger1553bData, z2);
                            this.trigger1553bEq.setVisibility(i);
                            CompoundButtonBindingAdapter.setChecked(this.trigger1553bError, z4);
                            this.trigger1553bErrorLabel.setVisibility(i2);
                            this.trigger1553bErrorValue.setVisibility(i2);
                            this.trigger1553bLessthan.setVisibility(i);
                            this.trigger1553bMoreless.setVisibility(i);
                            this.trigger1553bMorethan.setVisibility(i);
                            this.trigger1553bNeq.setVisibility(i);
                            CompoundButtonBindingAdapter.setChecked(this.trigger1553bRta, z5);
                            this.trigger1553bRta11Label.setVisibility(i3);
                            this.trigger1553bRta11Value.setVisibility(i3);
                            CompoundButtonBindingAdapter.setChecked(this.trigger1553bRta11bit, z3);
                            this.trigger1553bRtaLabel.setVisibility(i9);
                            this.trigger1553bRtaValue.setVisibility(i9);
                            CompoundButtonBindingAdapter.setChecked(this.trigger1553bSync, z16);
                            int i31 = i5;
                            this.trigger1553bSyncLabel.setVisibility(i31);
                            this.trigger1553bSyncValue.setVisibility(i31);
                            this.trigger1553bUnmoreless.setVisibility(i);
                        }
                        if ((39582418616320L & j4) != 0) {
                            TextViewBindingAdapter.setText(this.trigger1553bData, str14);
                        }
                        if (i15 != 0) {
                            int i32 = i11;
                            this.trigger1553bDownLimitLabel.setVisibility(i32);
                            this.trigger1553bDownLimitValue.setVisibility(i32);
                            this.trigger1553bUpLimitLabel.setVisibility(i16);
                            this.trigger1553bUpLimitValue.setVisibility(i16);
                        }
                        if ((35185445830660L & j4) != 0) {
                            TextViewBindingAdapter.setText(this.trigger1553bDownLimitValue, str7);
                        }
                        if ((j4 & 35184506306564L) != 0) {
                            CompoundButtonBindingAdapter.setChecked(this.trigger1553bEq, z14);
                            CompoundButtonBindingAdapter.setChecked(this.trigger1553bLessthan, z19);
                            CompoundButtonBindingAdapter.setChecked(this.trigger1553bMoreless, z21);
                            CompoundButtonBindingAdapter.setChecked(this.trigger1553bMorethan, z13);
                            CompoundButtonBindingAdapter.setChecked(this.trigger1553bNeq, z11);
                            CompoundButtonBindingAdapter.setChecked(this.trigger1553bUnmoreless, z22);
                        }
                        if ((j4 & 35253091565632L) != 0) {
                            TextViewBindingAdapter.setText(this.trigger1553bError, str17);
                        }
                        if ((52780853166084L & j4) != 0) {
                            TextViewBindingAdapter.setText(this.trigger1553bErrorValue, str6);
                        }
                        if ((35184373137412L & j4) != 0) {
                            CompoundButtonBindingAdapter.setChecked(this.trigger1553bLevela, z9);
                            CompoundButtonBindingAdapter.setChecked(this.trigger1553bLevelb, z8);
                        }
                        if ((43980465143808L & j4) != 0) {
                            TextViewBindingAdapter.setText(this.trigger1553bLevela, str16);
                        }
                        if ((j4 & 35184372613124L) != 0) {
                            CompoundButtonBindingAdapter.setChecked(this.trigger1553bLevelab, z7);
                        }
                        if ((j4 & 35321811042560L) != 0) {
                            TextViewBindingAdapter.setText(this.trigger1553bLevelb, str15);
                        }
                        if ((j4 & 35184374185988L) != 0) {
                            CompoundButtonBindingAdapter.setChecked(this.trigger1553bNegative, z6);
                            CompoundButtonBindingAdapter.setChecked(this.trigger1553bPositive, z18);
                        }
                        if ((j4 & 35184372219905L) != 0) {
                            TextViewBindingAdapter.setText(this.trigger1553bNegative, str);
                        }
                        if ((j4 & 35734127904768L) != 0) {
                            TextViewBindingAdapter.setText(this.trigger1553bPositive, str36);
                        }
                        if ((j4 & 37383395352576L) != 0) {
                            TextViewBindingAdapter.setText(this.trigger1553bRta, str13);
                        }
                        if ((35184640524292L & j4) != 0) {
                            TextViewBindingAdapter.setText(this.trigger1553bRta11Value, str8);
                        }
                        if ((j4 & 35459249996800L) != 0) {
                            TextViewBindingAdapter.setText(this.trigger1553bRta11bit, str11);
                        }
                        if ((35184908959748L & j4) != 0) {
                            TextViewBindingAdapter.setText(this.trigger1553bRtaValue, str10);
                        }
                        if ((j4 & 35184372350978L) != 0) {
                            TextViewBindingAdapter.setText(this.trigger1553bSync, str29);
                        }
                        if ((36292473655300L & j4) != 0) {
                            TextViewBindingAdapter.setText(this.trigger1553bSyncValue, str5);
                        }
                        if ((j4 & 35186519572484L) != 0) {
                            TextViewBindingAdapter.setText(this.trigger1553bUpLimitValue, str9);
                        }
                        if ((35184380477444L & j4) != 0) {
                            TextViewBindingAdapter.setText(this.triggerLevelaValue, str4);
                        }
                        if ((j4 & 35184376283140L) != 0) {
                            TextViewBindingAdapter.setText(this.triggerLevelbValue, str3);
                        }
                        if ((35201551958020L & j4) != 0) {
                            CompoundButtonBindingAdapter.setChecked(this.triggerNoiseSwitch, z17);
                        }
                        if ((35218748604436L & j4) != 0) {
                            TextViewBindingAdapter.setText(this.triggerSource, str2);
                        }
                        if ((35184405643268L & j4) != 0) {
                            this.triggerSource.setTextColor(i4);
                            return;
                        }
                        return;
                    }
                }
                i14 = 0;
                i15 = ((j4 & 35184573415428L) > 0L ? 1 : ((j4 & 35184573415428L) == 0L ? 0 : -1));
                if (i15 != 0) {
                }
                if ((j4 & 35184372088832L) != 0) {
                }
                if ((j4 & 35184439197700L) != 0) {
                }
                if ((39582418616320L & j4) != 0) {
                }
                if (i15 != 0) {
                }
                if ((35185445830660L & j4) != 0) {
                }
                if ((j4 & 35184506306564L) != 0) {
                }
                if ((j4 & 35253091565632L) != 0) {
                }
                if ((52780853166084L & j4) != 0) {
                }
                if ((35184373137412L & j4) != 0) {
                }
                if ((43980465143808L & j4) != 0) {
                }
                if ((j4 & 35184372613124L) != 0) {
                }
                if ((j4 & 35321811042560L) != 0) {
                }
                if ((j4 & 35184374185988L) != 0) {
                }
                if ((j4 & 35184372219905L) != 0) {
                }
                if ((j4 & 35734127904768L) != 0) {
                }
                if ((j4 & 37383395352576L) != 0) {
                }
                if ((35184640524292L & j4) != 0) {
                }
                if ((j4 & 35459249996800L) != 0) {
                }
                if ((35184908959748L & j4) != 0) {
                }
                if ((j4 & 35184372350978L) != 0) {
                }
                if ((36292473655300L & j4) != 0) {
                }
                if ((j4 & 35186519572484L) != 0) {
                }
                if ((35184380477444L & j4) != 0) {
                }
                if ((j4 & 35184376283140L) != 0) {
                }
                if ((35201551958020L & j4) != 0) {
                }
                if ((35218748604436L & j4) != 0) {
                }
                if ((35184405643268L & j4) != 0) {
                }
            } else {
                z19 = z15;
            }
        }
        i6 = 0;
        i7 = ((j4 & 35184439197700L) > 0L ? 1 : ((j4 & 35184439197700L) == 0L ? 0 : -1));
        if (i7 == 0) {
        }
        if ((j4 & 35184573415428L) == 0) {
        }
        if ((j4 & 70368744177664L) == 0) {
        }
        boolean z512 = z10;
        i12 = ((j4 & 18014398509481984L) > 0L ? 1 : ((j4 & 18014398509481984L) == 0L ? 0 : -1));
        if (i12 == 0) {
        }
        if ((j4 & 4611686018427387904L) == 0) {
        }
        boolean z522 = z12;
        i13 = ((j4 & 18014398509481984L) > 0L ? 1 : ((j4 & 18014398509481984L) == 0L ? 0 : -1));
        if (i13 != 0) {
        }
        i14 = 0;
        i15 = ((j4 & 35184573415428L) > 0L ? 1 : ((j4 & 35184573415428L) == 0L ? 0 : -1));
        if (i15 != 0) {
        }
        if ((j4 & 35184372088832L) != 0) {
        }
        if ((j4 & 35184439197700L) != 0) {
        }
        if ((39582418616320L & j4) != 0) {
        }
        if (i15 != 0) {
        }
        if ((35185445830660L & j4) != 0) {
        }
        if ((j4 & 35184506306564L) != 0) {
        }
        if ((j4 & 35253091565632L) != 0) {
        }
        if ((52780853166084L & j4) != 0) {
        }
        if ((35184373137412L & j4) != 0) {
        }
        if ((43980465143808L & j4) != 0) {
        }
        if ((j4 & 35184372613124L) != 0) {
        }
        if ((j4 & 35321811042560L) != 0) {
        }
        if ((j4 & 35184374185988L) != 0) {
        }
        if ((j4 & 35184372219905L) != 0) {
        }
        if ((j4 & 35734127904768L) != 0) {
        }
        if ((j4 & 37383395352576L) != 0) {
        }
        if ((35184640524292L & j4) != 0) {
        }
        if ((j4 & 35459249996800L) != 0) {
        }
        if ((35184908959748L & j4) != 0) {
        }
        if ((j4 & 35184372350978L) != 0) {
        }
        if ((36292473655300L & j4) != 0) {
        }
        if ((j4 & 35186519572484L) != 0) {
        }
        if ((35184380477444L & j4) != 0) {
        }
        if ((j4 & 35184376283140L) != 0) {
        }
        if ((35201551958020L & j4) != 0) {
        }
        if ((35218748604436L & j4) != 0) {
        }
        if ((35184405643268L & j4) != 0) {
        }
    }
}
