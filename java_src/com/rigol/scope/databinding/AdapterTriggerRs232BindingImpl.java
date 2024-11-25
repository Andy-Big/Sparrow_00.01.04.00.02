package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
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
public class AdapterTriggerRs232BindingImpl extends AdapterTriggerRs232Binding {
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
        sViewsWithIds.put(R.id.view_3, 28);
        sViewsWithIds.put(R.id.trigger_check_label, 29);
        sViewsWithIds.put(R.id.trigger_stop_bit_label, 30);
        sViewsWithIds.put(R.id.trigger_data_width_label, 31);
        sViewsWithIds.put(R.id.trigger_baudrate_label, 32);
        sViewsWithIds.put(R.id.trigger_label, 33);
        sViewsWithIds.put(R.id.trigger_level, 34);
        sViewsWithIds.put(R.id.trigger_source_label, 35);
        sViewsWithIds.put(R.id.trigger_polarity_label, 36);
        sViewsWithIds.put(R.id.button_level, 37);
        sViewsWithIds.put(R.id.trigger_noise_label, 38);
        sViewsWithIds.put(R.id.view_line_1, 39);
        sViewsWithIds.put(R.id.view_line_2, 40);
    }

    public AdapterTriggerRs232BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 41, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerRs232BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 18, (Button) objArr[37], (TextView) objArr[14], (EditText) objArr[15], (Guideline) objArr[22], (Guideline) objArr[25], (Guideline) objArr[24], (Guideline) objArr[21], (Guideline) objArr[23], (TextView) objArr[9], (TextView) objArr[32], (RadioButton) objArr[2], (TextView) objArr[29], (RadioButton) objArr[4], (RadioButton) objArr[3], (TextView) objArr[8], (TextView) objArr[31], (TextView) objArr[33], (TextView) objArr[34], (EditText) objArr[16], (TextView) objArr[38], (SwitchButton) objArr[20], (TextView) objArr[36], (RadioButton) objArr[12], (RadioButton) objArr[13], (RadioButton) objArr[11], (RadioButton) objArr[19], (RadioButton) objArr[18], (RadioButton) objArr[10], (TextView) objArr[17], (TextView) objArr[35], (RadioButton) objArr[7], (RadioButton) objArr[6], (RadioButton) objArr[5], (TextView) objArr[30], (View) objArr[27], (View) objArr[1], (View) objArr[28], (View) objArr[39], (View) objArr[40], (View) objArr[26]);
        this.mDirtyFlags = -1L;
        this.dataLabel.setTag(null);
        this.dataValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.triggerBaudrate.setTag(null);
        this.triggerCheckEven.setTag(null);
        this.triggerCheckNone.setTag(null);
        this.triggerCheckOdd.setTag(null);
        this.triggerDataWidth.setTag(null);
        this.triggerLevelValue.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerRs232Check.setTag(null);
        this.triggerRs232Data.setTag(null);
        this.triggerRs232Error.setTag(null);
        this.triggerRs232Negative.setTag(null);
        this.triggerRs232Positive.setTag(null);
        this.triggerRs232Start.setTag(null);
        this.triggerSource.setTag(null);
        this.triggerStopBit1.setTag(null);
        this.triggerStopBit15.setTag(null);
        this.triggerStopBit2.setTag(null);
        this.view2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4398046511104L;
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
        if (911 == i) {
            setStopBit1Mapping((MappingObject) obj);
        } else if (643 == i) {
            setPolarityNegativeMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (1051 == i) {
            setWhenCheckMapping((MappingObject) obj);
        } else if (1068 == i) {
            setWhenStartMapping((MappingObject) obj);
        } else if (1055 == i) {
            setWhenErrorMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (644 == i) {
            setPolarityPositiveMapping((MappingObject) obj);
        } else if (596 == i) {
            setParityNoneMapping((MappingObject) obj);
        } else if (912 == i) {
            setStopBit2Mapping((MappingObject) obj);
        } else if (1054 == i) {
            setWhenDataMapping((MappingObject) obj);
        } else if (595 == i) {
            setParityEvenMapping((MappingObject) obj);
        } else if (597 == i) {
            setParityOddMapping((MappingObject) obj);
        } else if (910 != i) {
            return false;
        } else {
            setStopBit15Mapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRs232Binding
    public void setStopBit1Mapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mStopBit1Mapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(911);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRs232Binding
    public void setPolarityNegativeMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mPolarityNegativeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(643);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRs232Binding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(3, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRs232Binding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRs232Binding
    public void setWhenCheckMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mWhenCheckMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(1051);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRs232Binding
    public void setWhenStartMapping(MappingObject mappingObject) {
        updateRegistration(7, mappingObject);
        this.mWhenStartMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(1068);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRs232Binding
    public void setWhenErrorMapping(MappingObject mappingObject) {
        updateRegistration(8, mappingObject);
        this.mWhenErrorMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(1055);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRs232Binding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRs232Binding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRs232Binding
    public void setPolarityPositiveMapping(MappingObject mappingObject) {
        updateRegistration(11, mappingObject);
        this.mPolarityPositiveMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(644);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRs232Binding
    public void setParityNoneMapping(MappingObject mappingObject) {
        updateRegistration(12, mappingObject);
        this.mParityNoneMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(596);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRs232Binding
    public void setStopBit2Mapping(MappingObject mappingObject) {
        updateRegistration(13, mappingObject);
        this.mStopBit2Mapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        notifyPropertyChanged(912);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRs232Binding
    public void setWhenDataMapping(MappingObject mappingObject) {
        updateRegistration(14, mappingObject);
        this.mWhenDataMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
        }
        notifyPropertyChanged(1054);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRs232Binding
    public void setParityEvenMapping(MappingObject mappingObject) {
        updateRegistration(15, mappingObject);
        this.mParityEvenMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(595);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRs232Binding
    public void setParityOddMapping(MappingObject mappingObject) {
        updateRegistration(16, mappingObject);
        this.mParityOddMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        notifyPropertyChanged(597);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerRs232Binding
    public void setStopBit15Mapping(MappingObject mappingObject) {
        updateRegistration(17, mappingObject);
        this.mStopBit15Mapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        notifyPropertyChanged(910);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeStopBit1Mapping((MappingObject) obj, i2);
            case 1:
                return onChangePolarityNegativeMapping((MappingObject) obj, i2);
            case 2:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaExtAcParamChanValue1((MappingObject) obj, i2);
            case 3:
                return onChangeParam((TriggerParam) obj, i2);
            case 4:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 5:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerRs232DatawidthParamTriggerRS232WidthValue1((MappingObject) obj, i2);
            case 6:
                return onChangeWhenCheckMapping((MappingObject) obj, i2);
            case 7:
                return onChangeWhenStartMapping((MappingObject) obj, i2);
            case 8:
                return onChangeWhenErrorMapping((MappingObject) obj, i2);
            case 9:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 10:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 11:
                return onChangePolarityPositiveMapping((MappingObject) obj, i2);
            case 12:
                return onChangeParityNoneMapping((MappingObject) obj, i2);
            case 13:
                return onChangeStopBit2Mapping((MappingObject) obj, i2);
            case 14:
                return onChangeWhenDataMapping((MappingObject) obj, i2);
            case 15:
                return onChangeParityEvenMapping((MappingObject) obj, i2);
            case 16:
                return onChangeParityOddMapping((MappingObject) obj, i2);
            case 17:
                return onChangeStopBit15Mapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeStopBit1Mapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
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

    private boolean onChangePolarityNegativeMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaExtAcParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
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

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 973) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 971) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 972) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 974) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 744) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else if (i == 745) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else if (i == 484) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= 268435456;
            }
            return true;
        } else if (i == 680) {
            synchronized (this) {
                this.mDirtyFlags |= 536870912;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= 1073741824;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerRs232DatawidthParamTriggerRS232WidthValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    private boolean onChangeWhenCheckMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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

    private boolean onChangeWhenStartMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
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

    private boolean onChangeWhenErrorMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
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

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        }
        return false;
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

    private boolean onChangePolarityPositiveMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
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

    private boolean onChangeParityNoneMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
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

    private boolean onChangeStopBit2Mapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
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

    private boolean onChangeWhenDataMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
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

    private boolean onChangeParityEvenMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
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

    private boolean onChangeParityOddMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
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

    private boolean onChangeStopBit15Mapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
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

    /* JADX WARN: Removed duplicated region for block: B:113:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01be A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01cd  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterTriggerRs232BindingImpl.executeBindings():void");
    }
}
