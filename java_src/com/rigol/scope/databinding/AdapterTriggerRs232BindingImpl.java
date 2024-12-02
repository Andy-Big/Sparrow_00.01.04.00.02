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
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
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
    */
    protected void executeBindings() {
        long j;
        String str;
        MappingObject mappingObject;
        MappingObject mappingObject2;
        String str2;
        long j2;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean z;
        boolean z2;
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        int i2;
        boolean z11;
        boolean z12;
        boolean z13;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        AdapterTriggerRs232BindingImpl adapterTriggerRs232BindingImpl;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        int i4;
        boolean z23;
        long j3;
        String str12;
        int i5;
        String str13;
        String str14;
        int i6;
        String str15;
        boolean z24;
        boolean z25;
        boolean z26;
        boolean z27;
        boolean z28;
        String str16;
        String str17;
        boolean z29;
        boolean z30;
        boolean z31;
        String str18;
        long j4;
        ServiceEnum.Trigger_RS232_Width trigger_RS232_Width;
        int i7;
        ServiceEnum.Trigger_RS232_Parity trigger_RS232_Parity;
        long j5;
        ServiceEnum.Chan chan;
        int i8;
        ServiceEnum.Trigger_RS232_When trigger_RS232_When;
        ServiceEnum.TriggerPulsePolarity triggerPulsePolarity;
        synchronized (this) {
            try {
                j = this.mDirtyFlags;
                this.mDirtyFlags = 0L;
            } catch (Throwable th) {
                th = th;
                while (true) {
                    try {
                        break;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                throw th;
            }
        }
        MappingObject mappingObject3 = this.mStopBit1Mapping;
        MappingObject mappingObject4 = this.mPolarityNegativeMapping;
        TriggerParam triggerParam = this.mParam;
        MappingObject mappingObject5 = this.mWhenCheckMapping;
        MappingObject mappingObject6 = this.mWhenStartMapping;
        MappingObject mappingObject7 = this.mWhenErrorMapping;
        MappingObject mappingObject8 = this.mPolarityPositiveMapping;
        MappingObject mappingObject9 = this.mParityNoneMapping;
        MappingObject mappingObject10 = this.mStopBit2Mapping;
        MappingObject mappingObject11 = this.mWhenDataMapping;
        MappingObject mappingObject12 = this.mParityEvenMapping;
        MappingObject mappingObject13 = this.mParityOddMapping;
        MappingObject mappingObject14 = this.mStopBit15Mapping;
        String str19 = null;
        String str20 = ((j & 4398046773249L) == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        String str21 = ((j & 4398047035394L) == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        if ((j & 4402340429868L) != 0) {
            boolean z32 = true;
            if ((j & 4398583382024L) != 0) {
                if (triggerParam != null) {
                    str2 = str21;
                    str = str20;
                    triggerPulsePolarity = triggerParam.getPulsePolarity();
                } else {
                    str = str20;
                    str2 = str21;
                    triggerPulsePolarity = null;
                }
                boolean z33 = triggerPulsePolarity == ServiceEnum.TriggerPulsePolarity.Trigger_pulse_negative;
                z14 = triggerPulsePolarity == ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive;
                z15 = z33;
            } else {
                str = str20;
                str2 = str21;
                z14 = false;
                z15 = false;
            }
            int i9 = ((j & 4398048608264L) > 0L ? 1 : ((j & 4398048608264L) == 0L ? 0 : -1));
            if (i9 != 0) {
                if (triggerParam != null) {
                    z17 = z15;
                    z16 = z14;
                    trigger_RS232_When = triggerParam.getTrigger_RS232_When();
                } else {
                    z16 = z14;
                    z17 = z15;
                    trigger_RS232_When = null;
                }
                mappingObject2 = mappingObject14;
                z19 = trigger_RS232_When == ServiceEnum.Trigger_RS232_When.rs232_when_data;
                z20 = trigger_RS232_When == ServiceEnum.Trigger_RS232_When.rs232_when_check_error;
                z21 = trigger_RS232_When == ServiceEnum.Trigger_RS232_When.rs232_when_error;
                z18 = trigger_RS232_When == ServiceEnum.Trigger_RS232_When.rs232_when_start;
                if (i9 != 0) {
                    j |= z19 ? 17592186044416L : 8796093022208L;
                }
                i3 = z19 ? 0 : 8;
            } else {
                z16 = z14;
                mappingObject2 = mappingObject14;
                z17 = z15;
                z18 = false;
                i3 = 0;
                z19 = false;
                z20 = false;
                z21 = false;
            }
            if ((j & 4398315995148L) != 0) {
                if (triggerParam != null) {
                    z22 = z18;
                    chan = triggerParam.getChan();
                } else {
                    z22 = z18;
                    chan = null;
                }
                i4 = i3;
                if (chan != null) {
                    i8 = chan.value1;
                    z23 = z19;
                } else {
                    z23 = z19;
                    i8 = 0;
                }
                MappingObject mappingObject15 = ViewUtil.getMappingObject(R.array.msg_trigger_source_la_ext_ac, i8);
                updateRegistration(2, mappingObject15);
                str12 = mappingObject15 != null ? mappingObject15.getStr() : null;
                j3 = 0;
                if ((j & 4398314946568L) != 0) {
                    i5 = ColorUtil.getColor(getRoot().getContext(), chan);
                    if ((j & 4398180728840L) == j3) {
                        if (triggerParam != null) {
                            str13 = str12;
                            j5 = triggerParam.getLevel();
                        } else {
                            str13 = str12;
                            j5 = 0;
                        }
                        if (triggerParam != null) {
                            str14 = triggerParam.getTriggerLevelStr(j5);
                            boolean isNoise = ((j & 4399120252936L) != 0 || triggerParam == null) ? false : triggerParam.getIsNoise();
                            if ((j & 4398050705416L) != 0) {
                                if (triggerParam != null) {
                                    str15 = str14;
                                    i6 = i5;
                                    trigger_RS232_Parity = triggerParam.getTrigger_RS232_Parity();
                                } else {
                                    i6 = i5;
                                    str15 = str14;
                                    trigger_RS232_Parity = null;
                                }
                                boolean z34 = trigger_RS232_Parity == ServiceEnum.Trigger_RS232_Parity.RS232_Parity_Odd;
                                z26 = trigger_RS232_Parity == ServiceEnum.Trigger_RS232_Parity.RS232_Parity_None;
                                z24 = trigger_RS232_Parity == ServiceEnum.Trigger_RS232_Parity.RS232_Parity_Even;
                                z25 = z34;
                            } else {
                                i6 = i5;
                                str15 = str14;
                                z24 = false;
                                z25 = false;
                                z26 = false;
                            }
                            if ((j & 4400210772008L) != 0) {
                                if (triggerParam != null) {
                                    z27 = z24;
                                    trigger_RS232_Width = triggerParam.getTrigger_RS232_Width();
                                } else {
                                    z27 = z24;
                                    trigger_RS232_Width = null;
                                }
                                if (trigger_RS232_Width != null) {
                                    i7 = trigger_RS232_Width.value1;
                                    z28 = z25;
                                } else {
                                    z28 = z25;
                                    i7 = 0;
                                }
                                MappingObject mappingObject16 = ViewUtil.getMappingObject(R.array.msg_trigger_rs232_datawidth, i7);
                                updateRegistration(5, mappingObject16);
                                if (mappingObject16 != null) {
                                    str16 = mappingObject16.getStr();
                                    if ((j & 4398113619976L) == 0) {
                                        if (triggerParam != null) {
                                            long rs232Data = triggerParam.getRs232Data();
                                            str18 = triggerParam.rs232DataConvert();
                                            str17 = str16;
                                            z29 = isNoise;
                                            j4 = rs232Data;
                                        } else {
                                            str17 = str16;
                                            z29 = isNoise;
                                            str18 = null;
                                            j4 = 0;
                                        }
                                        mappingObject = mappingObject13;
                                        str3 = ((UnitFormat.newBuilder(" # ", UnitFormat.SI.NONE).convert(j4, ServiceEnum.Unit.Unit_none) + "(0x") + str18) + ")";
                                    } else {
                                        str17 = str16;
                                        mappingObject = mappingObject13;
                                        z29 = isNoise;
                                        str3 = null;
                                    }
                                    if ((j & 4398054899720L) == 0) {
                                        ServiceEnum.Trigger_RS232_Stop trigger_RS232_Stop = triggerParam != null ? triggerParam.getTrigger_RS232_Stop() : null;
                                        z30 = trigger_RS232_Stop == ServiceEnum.Trigger_RS232_Stop.STOP_WIDTH_2;
                                        z31 = trigger_RS232_Stop == ServiceEnum.Trigger_RS232_Stop.STOP_WIDTH_1;
                                        if (trigger_RS232_Stop != ServiceEnum.Trigger_RS232_Stop.STOP_WIDTH_1_5) {
                                            z32 = false;
                                        }
                                    } else {
                                        z30 = false;
                                        z31 = false;
                                        z32 = false;
                                    }
                                    if ((j & 4398080065544L) == 0) {
                                        int rs232BaudRate = triggerParam != null ? triggerParam.getRs232BaudRate() : 0;
                                        String str22 = str3;
                                        j2 = j;
                                        str4 = UnitFormat.newBuilder(" 0.###  ", UnitFormat.SI.NONE).convert(rs232BaudRate, ServiceEnum.Unit.Unit_none) + "bps";
                                        z13 = z30;
                                        z11 = z31;
                                        str3 = str22;
                                    } else {
                                        j2 = j;
                                        z13 = z30;
                                        z11 = z31;
                                        str4 = null;
                                    }
                                    z12 = z32;
                                    z2 = z22;
                                    z10 = z16;
                                    z9 = z17;
                                    z4 = z20;
                                    z5 = z21;
                                    i = i4;
                                    z3 = z23;
                                    str7 = str13;
                                    i2 = i6;
                                    str5 = str15;
                                    z = z27;
                                    z6 = z26;
                                    z7 = z28;
                                    str6 = str17;
                                    z8 = z29;
                                }
                            } else {
                                z27 = z24;
                                z28 = z25;
                            }
                            str16 = null;
                            if ((j & 4398113619976L) == 0) {
                            }
                            if ((j & 4398054899720L) == 0) {
                            }
                            if ((j & 4398080065544L) == 0) {
                            }
                            z12 = z32;
                            z2 = z22;
                            z10 = z16;
                            z9 = z17;
                            z4 = z20;
                            z5 = z21;
                            i = i4;
                            z3 = z23;
                            str7 = str13;
                            i2 = i6;
                            str5 = str15;
                            z = z27;
                            z6 = z26;
                            z7 = z28;
                            str6 = str17;
                            z8 = z29;
                        }
                    } else {
                        str13 = str12;
                    }
                    str14 = null;
                    if ((j & 4399120252936L) != 0) {
                    }
                    if ((j & 4398050705416L) != 0) {
                    }
                    if ((j & 4400210772008L) != 0) {
                    }
                    str16 = null;
                    if ((j & 4398113619976L) == 0) {
                    }
                    if ((j & 4398054899720L) == 0) {
                    }
                    if ((j & 4398080065544L) == 0) {
                    }
                    z12 = z32;
                    z2 = z22;
                    z10 = z16;
                    z9 = z17;
                    z4 = z20;
                    z5 = z21;
                    i = i4;
                    z3 = z23;
                    str7 = str13;
                    i2 = i6;
                    str5 = str15;
                    z = z27;
                    z6 = z26;
                    z7 = z28;
                    str6 = str17;
                    z8 = z29;
                }
            } else {
                z22 = z18;
                i4 = i3;
                z23 = z19;
                j3 = 0;
                str12 = null;
            }
            i5 = 0;
            if ((j & 4398180728840L) == j3) {
            }
            str14 = null;
            if ((j & 4399120252936L) != 0) {
            }
            if ((j & 4398050705416L) != 0) {
            }
            if ((j & 4400210772008L) != 0) {
            }
            str16 = null;
            if ((j & 4398113619976L) == 0) {
            }
            if ((j & 4398054899720L) == 0) {
            }
            if ((j & 4398080065544L) == 0) {
            }
            z12 = z32;
            z2 = z22;
            z10 = z16;
            z9 = z17;
            z4 = z20;
            z5 = z21;
            i = i4;
            z3 = z23;
            str7 = str13;
            i2 = i6;
            str5 = str15;
            z = z27;
            z6 = z26;
            z7 = z28;
            str6 = str17;
            z8 = z29;
        } else {
            str = str20;
            mappingObject = mappingObject13;
            mappingObject2 = mappingObject14;
            str2 = str21;
            j2 = j;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            z = false;
            z2 = false;
            i = 0;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
            z8 = false;
            z9 = false;
            z10 = false;
            i2 = 0;
            z11 = false;
            z12 = false;
            z13 = false;
            str7 = null;
        }
        int i10 = ((j2 & 4402341478464L) > 0L ? 1 : ((j2 & 4402341478464L) == 0L ? 0 : -1));
        String str23 = (i10 == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        int i11 = ((j2 & 4406636445824L) > 0L ? 1 : ((j2 & 4406636445824L) == 0L ? 0 : -1));
        String str24 = (i11 == 0 || mappingObject6 == null) ? null : mappingObject6.getStr();
        int i12 = ((j2 & 4415226380544L) > 0L ? 1 : ((j2 & 4415226380544L) == 0L ? 0 : -1));
        String str25 = (i12 == 0 || mappingObject7 == null) ? null : mappingObject7.getStr();
        int i13 = ((j2 & 4432406251520L) > 0L ? 1 : ((j2 & 4432406251520L) == 0L ? 0 : -1));
        String str26 = (i13 == 0 || mappingObject8 == null) ? null : mappingObject8.getStr();
        int i14 = ((j2 & 4466765991936L) > 0L ? 1 : ((j2 & 4466765991936L) == 0L ? 0 : -1));
        String str27 = (i14 == 0 || mappingObject9 == null) ? null : mappingObject9.getStr();
        int i15 = ((j2 & 4535485472768L) > 0L ? 1 : ((j2 & 4535485472768L) == 0L ? 0 : -1));
        String str28 = (i15 == 0 || mappingObject10 == null) ? null : mappingObject10.getStr();
        int i16 = ((j2 & 4672924434432L) > 0L ? 1 : ((j2 & 4672924434432L) == 0L ? 0 : -1));
        String str29 = (i16 == 0 || mappingObject11 == null) ? null : mappingObject11.getStr();
        int i17 = ((j2 & 4947802357760L) > 0L ? 1 : ((j2 & 4947802357760L) == 0L ? 0 : -1));
        String str30 = (i17 == 0 || mappingObject12 == null) ? null : mappingObject12.getStr();
        int i18 = ((j2 & 5497558204416L) > 0L ? 1 : ((j2 & 5497558204416L) == 0L ? 0 : -1));
        if (i18 == 0 || mappingObject == null) {
            str8 = str28;
            str9 = null;
        } else {
            str8 = str28;
            str9 = mappingObject.getStr();
        }
        int i19 = ((j2 & 6597069897728L) > 0L ? 1 : ((j2 & 6597069897728L) == 0L ? 0 : -1));
        if (i19 != 0 && mappingObject2 != null) {
            str19 = mappingObject2.getStr();
        }
        String str31 = str19;
        if ((j2 & 4398048608264L) != 0) {
            str10 = str24;
            str11 = str26;
            adapterTriggerRs232BindingImpl = this;
            adapterTriggerRs232BindingImpl.dataLabel.setVisibility(i);
            adapterTriggerRs232BindingImpl.dataValue.setVisibility(i);
            CompoundButtonBindingAdapter.setChecked(adapterTriggerRs232BindingImpl.triggerRs232Check, z4);
            CompoundButtonBindingAdapter.setChecked(adapterTriggerRs232BindingImpl.triggerRs232Data, z3);
            CompoundButtonBindingAdapter.setChecked(adapterTriggerRs232BindingImpl.triggerRs232Error, z5);
            CompoundButtonBindingAdapter.setChecked(adapterTriggerRs232BindingImpl.triggerRs232Start, z2);
            adapterTriggerRs232BindingImpl.view2.setVisibility(i);
        } else {
            str10 = str24;
            str11 = str26;
            adapterTriggerRs232BindingImpl = this;
        }
        if ((j2 & 4398113619976L) != 0) {
            TextViewBindingAdapter.setText(adapterTriggerRs232BindingImpl.dataValue, str3);
        }
        if ((j2 & 4398080065544L) != 0) {
            TextViewBindingAdapter.setText(adapterTriggerRs232BindingImpl.triggerBaudrate, str4);
        }
        if ((j2 & 4398050705416L) != 0) {
            CompoundButtonBindingAdapter.setChecked(adapterTriggerRs232BindingImpl.triggerCheckEven, z);
            CompoundButtonBindingAdapter.setChecked(adapterTriggerRs232BindingImpl.triggerCheckNone, z6);
            CompoundButtonBindingAdapter.setChecked(adapterTriggerRs232BindingImpl.triggerCheckOdd, z7);
        }
        if (i17 != 0) {
            TextViewBindingAdapter.setText(adapterTriggerRs232BindingImpl.triggerCheckEven, str30);
        }
        if (i14 != 0) {
            TextViewBindingAdapter.setText(adapterTriggerRs232BindingImpl.triggerCheckNone, str27);
        }
        if (i18 != 0) {
            TextViewBindingAdapter.setText(adapterTriggerRs232BindingImpl.triggerCheckOdd, str9);
        }
        if ((j2 & 4400210772008L) != 0) {
            TextViewBindingAdapter.setText(adapterTriggerRs232BindingImpl.triggerDataWidth, str6);
        }
        if ((j2 & 4398180728840L) != 0) {
            TextViewBindingAdapter.setText(adapterTriggerRs232BindingImpl.triggerLevelValue, str5);
        }
        if ((j2 & 4399120252936L) != 0) {
            CompoundButtonBindingAdapter.setChecked(adapterTriggerRs232BindingImpl.triggerNoiseSwitch, z8);
        }
        if (i10 != 0) {
            TextViewBindingAdapter.setText(adapterTriggerRs232BindingImpl.triggerRs232Check, str23);
        }
        if (i16 != 0) {
            TextViewBindingAdapter.setText(adapterTriggerRs232BindingImpl.triggerRs232Data, str29);
        }
        if (i12 != 0) {
            TextViewBindingAdapter.setText(adapterTriggerRs232BindingImpl.triggerRs232Error, str25);
        }
        if ((j2 & 4398583382024L) != 0) {
            CompoundButtonBindingAdapter.setChecked(adapterTriggerRs232BindingImpl.triggerRs232Negative, z9);
            CompoundButtonBindingAdapter.setChecked(adapterTriggerRs232BindingImpl.triggerRs232Positive, z10);
        }
        if ((j2 & 4398047035394L) != 0) {
            TextViewBindingAdapter.setText(adapterTriggerRs232BindingImpl.triggerRs232Negative, str2);
        }
        if (i13 != 0) {
            TextViewBindingAdapter.setText(adapterTriggerRs232BindingImpl.triggerRs232Positive, str11);
        }
        if (i11 != 0) {
            TextViewBindingAdapter.setText(adapterTriggerRs232BindingImpl.triggerRs232Start, str10);
        }
        if ((j2 & 4398315995148L) != 0) {
            TextViewBindingAdapter.setText(adapterTriggerRs232BindingImpl.triggerSource, str7);
        }
        if ((j2 & 4398314946568L) != 0) {
            adapterTriggerRs232BindingImpl.triggerSource.setTextColor(i2);
        }
        if ((j2 & 4398054899720L) != 0) {
            CompoundButtonBindingAdapter.setChecked(adapterTriggerRs232BindingImpl.triggerStopBit1, z11);
            CompoundButtonBindingAdapter.setChecked(adapterTriggerRs232BindingImpl.triggerStopBit15, z12);
            CompoundButtonBindingAdapter.setChecked(adapterTriggerRs232BindingImpl.triggerStopBit2, z13);
        }
        if ((j2 & 4398046773249L) != 0) {
            TextViewBindingAdapter.setText(adapterTriggerRs232BindingImpl.triggerStopBit1, str);
        }
        if (i19 != 0) {
            TextViewBindingAdapter.setText(adapterTriggerRs232BindingImpl.triggerStopBit15, str31);
        }
        if (i15 != 0) {
            TextViewBindingAdapter.setText(adapterTriggerRs232BindingImpl.triggerStopBit2, str8);
        }
    }
}
