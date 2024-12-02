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
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: classes2.dex */
public class AdapterTriggerLinBindingImpl extends AdapterTriggerLinBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 26);
        sViewsWithIds.put(R.id.guideline_center, 27);
        sViewsWithIds.put(R.id.guideline_right, 28);
        sViewsWithIds.put(R.id.guideline_forth, 29);
        sViewsWithIds.put(R.id.guideline_fifth, 30);
        sViewsWithIds.put(R.id.view_top, 31);
        sViewsWithIds.put(R.id.view_1, 32);
        sViewsWithIds.put(R.id.view_2, 33);
        sViewsWithIds.put(R.id.trigger_label, 34);
        sViewsWithIds.put(R.id.trigger_sample_points_label, 35);
        sViewsWithIds.put(R.id.trigger_source_lin_baud_label, 36);
        sViewsWithIds.put(R.id.trigger_source_lin_version_label, 37);
        sViewsWithIds.put(R.id.trigger_level, 38);
        sViewsWithIds.put(R.id.trigger_source_lin_label, 39);
        sViewsWithIds.put(R.id.button_level, 40);
        sViewsWithIds.put(R.id.trigger_noise_label, 41);
        sViewsWithIds.put(R.id.view_line_1, 42);
        sViewsWithIds.put(R.id.view_line_2, 43);
    }

    public AdapterTriggerLinBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 44, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerLinBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 16, (Button) objArr[40], (Guideline) objArr[27], (Guideline) objArr[30], (Guideline) objArr[29], (Guideline) objArr[26], (Guideline) objArr[28], (TextView) objArr[6], (TextView) objArr[3], (TextView) objArr[34], (TextView) objArr[38], (EditText) objArr[23], (TextView) objArr[22], (TextView) objArr[8], (TextView) objArr[5], (RadioButton) objArr[15], (RadioButton) objArr[14], (TextView) objArr[7], (EditText) objArr[9], (RadioButton) objArr[11], (RadioButton) objArr[16], (TextView) objArr[10], (EditText) objArr[4], (RadioButton) objArr[13], (RadioButton) objArr[17], (RadioButton) objArr[20], (RadioButton) objArr[19], (RadioButton) objArr[18], (RadioButton) objArr[12], (TextView) objArr[41], (SwitchButton) objArr[25], (TextView) objArr[35], (EditText) objArr[21], (TextView) objArr[36], (TextView) objArr[39], (TextView) objArr[24], (TextView) objArr[37], (View) objArr[32], (View) objArr[33], (View) objArr[1], (View) objArr[2], (View) objArr[42], (View) objArr[43], (View) objArr[31]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.triggerErrTypeLabel.setTag(null);
        this.triggerErrTypeValue.setTag(null);
        this.triggerLevelValue.setTag(null);
        this.triggerLinBaudValue.setTag(null);
        this.triggerLinBytelengthLabel.setTag(null);
        this.triggerLinBytelengthValue.setTag(null);
        this.triggerLinData.setTag(null);
        this.triggerLinDataId.setTag(null);
        this.triggerLinDataLabel.setTag(null);
        this.triggerLinDataValue.setTag(null);
        this.triggerLinError.setTag(null);
        this.triggerLinId.setTag(null);
        this.triggerLinIdLabel.setTag(null);
        this.triggerLinIdValue.setTag(null);
        this.triggerLinSleep.setTag(null);
        this.triggerLinSync.setTag(null);
        this.triggerLinVersion1.setTag(null);
        this.triggerLinVersion2.setTag(null);
        this.triggerLinVersionBoth.setTag(null);
        this.triggerLinWakeup.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSamplePointsValue.setTag(null);
        this.triggerSourceLinValue.setTag(null);
        this.view3.setTag(null);
        this.view4.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 549755813888L;
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
        if (1067 == i) {
            setWhenSleepMapping((MappingObject) obj);
        } else if (1073 == i) {
            setWhenWakeUpMapping((MappingObject) obj);
        } else if (1071 == i) {
            setWhenSyncMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (1055 == i) {
            setWhenErrorMapping((MappingObject) obj);
        } else if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (1023 == i) {
            setVersion2Mapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (1053 == i) {
            setWhenDataIdMapping((MappingObject) obj);
        } else if (1024 == i) {
            setVersionBothMapping((MappingObject) obj);
        } else if (1058 == i) {
            setWhenIdMapping((MappingObject) obj);
        } else if (1054 == i) {
            setWhenDataMapping((MappingObject) obj);
        } else if (1022 != i) {
            return false;
        } else {
            setVersion1Mapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setWhenSleepMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mWhenSleepMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1067);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setWhenWakeUpMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mWhenWakeUpMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(1073);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setWhenSyncMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mWhenSyncMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(1071);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(3, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setWhenErrorMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mWhenErrorMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(1055);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setVersion2Mapping(MappingObject mappingObject) {
        updateRegistration(8, mappingObject);
        this.mVersion2Mapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(1023);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setWhenDataIdMapping(MappingObject mappingObject) {
        updateRegistration(10, mappingObject);
        this.mWhenDataIdMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(1053);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setVersionBothMapping(MappingObject mappingObject) {
        updateRegistration(11, mappingObject);
        this.mVersionBothMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(1024);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setWhenIdMapping(MappingObject mappingObject) {
        updateRegistration(12, mappingObject);
        this.mWhenIdMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(1058);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setWhenDataMapping(MappingObject mappingObject) {
        updateRegistration(14, mappingObject);
        this.mWhenDataMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
        }
        notifyPropertyChanged(1054);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerLinBinding
    public void setVersion1Mapping(MappingObject mappingObject) {
        updateRegistration(15, mappingObject);
        this.mVersion1Mapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(1022);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeWhenSleepMapping((MappingObject) obj, i2);
            case 1:
                return onChangeWhenWakeUpMapping((MappingObject) obj, i2);
            case 2:
                return onChangeWhenSyncMapping((MappingObject) obj, i2);
            case 3:
                return onChangeParam((TriggerParam) obj, i2);
            case 4:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 5:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerLinErrTypeParamTriggerLinErrValue1((MappingObject) obj, i2);
            case 6:
                return onChangeWhenErrorMapping((MappingObject) obj, i2);
            case 7:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 8:
                return onChangeVersion2Mapping((MappingObject) obj, i2);
            case 9:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 10:
                return onChangeWhenDataIdMapping((MappingObject) obj, i2);
            case 11:
                return onChangeVersionBothMapping((MappingObject) obj, i2);
            case 12:
                return onChangeWhenIdMapping((MappingObject) obj, i2);
            case 13:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1((MappingObject) obj, i2);
            case 14:
                return onChangeWhenDataMapping((MappingObject) obj, i2);
            case 15:
                return onChangeVersion1Mapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeWhenSleepMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
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

    private boolean onChangeWhenWakeUpMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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
                this.mDirtyFlags |= 4;
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
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 970) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 968) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 493) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 491) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 339) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 969) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 494) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else if (i == 490) {
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
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= 536870912;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerLinErrTypeParamTriggerLinErrValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 1073741824;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeWhenErrorMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeVersion2Mapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
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

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeWhenDataIdMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
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

    private boolean onChangeVersionBothMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
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

    private boolean onChangeWhenIdMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
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

    private boolean onChangeWhenDataMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
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

    private boolean onChangeVersion1Mapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
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

    /* JADX WARN: Removed duplicated region for block: B:110:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0202 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0216  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        long j2;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        int i2;
        boolean z11;
        String str12;
        String str13;
        String str14;
        int i3;
        int i4;
        int i5;
        boolean z12;
        boolean z13;
        String str15;
        int i6;
        String str16;
        long j3;
        long j4;
        long j5;
        long j6;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        long j7;
        String str24;
        int i7;
        String str25;
        String str26;
        String str27;
        String str28;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        int i8;
        boolean z18;
        boolean z19;
        int i9;
        String str29;
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        long j8;
        ServiceEnum.Trigger_Lin_When trigger_Lin_When;
        ServiceEnum.Trigger_Lin_Ver trigger_Lin_Ver;
        long j9;
        int i10;
        int i11;
        String str30;
        int i12;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mWhenSleepMapping;
        MappingObject mappingObject2 = this.mWhenWakeUpMapping;
        MappingObject mappingObject3 = this.mWhenSyncMapping;
        TriggerParam triggerParam = this.mParam;
        MappingObject mappingObject4 = this.mWhenErrorMapping;
        MappingObject mappingObject5 = this.mVersion2Mapping;
        MappingObject mappingObject6 = this.mWhenDataIdMapping;
        MappingObject mappingObject7 = this.mVersionBothMapping;
        MappingObject mappingObject8 = this.mWhenIdMapping;
        MappingObject mappingObject9 = this.mWhenDataMapping;
        MappingObject mappingObject10 = this.mVersion1Mapping;
        String str31 = null;
        String str32 = ((j & 549755879425L) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        String str33 = ((j & 549755944962L) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        String str34 = ((j & 549756076036L) == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        int i13 = 0;
        if ((j & 620622258216L) != 0) {
            String formatValue4Str = ((j & 549764202504L) == 0 || triggerParam == null) ? null : triggerParam.getFormatValue4Str();
            if ((j & 549757911048L) != 0) {
                if (triggerParam != null) {
                    i12 = triggerParam.getLinId();
                    str30 = triggerParam.linIdConvert();
                } else {
                    str30 = null;
                    i12 = 0;
                }
                String valueOf = String.valueOf(i12);
                str2 = str33;
                str17 = ((valueOf + "(0x") + str30) + ")";
            } else {
                str2 = str33;
                str17 = null;
            }
            if ((j & 550830604328L) != 0) {
                ServiceEnum.Trigger_Lin_Err trigger_Lin_Err = triggerParam != null ? triggerParam.getTrigger_Lin_Err() : null;
                MappingObject mappingObject11 = ViewUtil.getMappingObject(R.array.msg_trigger_lin_err_type, trigger_Lin_Err != null ? trigger_Lin_Err.value1 : 0);
                updateRegistration(5, mappingObject11);
                if (mappingObject11 != null) {
                    str18 = mappingObject11.getStr();
                    if ((j & 549822922760L) == 0) {
                        if (triggerParam != null) {
                            i11 = triggerParam.getLinBaud();
                            str19 = str17;
                        } else {
                            str19 = str17;
                            i11 = 0;
                        }
                        str20 = str18;
                        str3 = str34;
                        str21 = UnitFormat.newBuilder(" 0.###  ", UnitFormat.SI.NONE).convert(i11, ServiceEnum.Unit.Unit_none) + "bps";
                    } else {
                        str19 = str17;
                        str20 = str18;
                        str3 = str34;
                        str21 = null;
                    }
                    if ((j & 549760008200L) == 0) {
                        str22 = String.valueOf(triggerParam != null ? triggerParam.getLinByte() : 0);
                    } else {
                        str22 = null;
                    }
                    if ((j & 618743734280L) == 0) {
                        ServiceEnum.Chan chan = triggerParam != null ? triggerParam.getChan() : null;
                        if (chan != null) {
                            i10 = chan.value1;
                            str23 = str21;
                        } else {
                            str23 = str21;
                            i10 = 0;
                        }
                        MappingObject mappingObject12 = ViewUtil.getMappingObject(R.array.msg_trigger_source_la, i10);
                        updateRegistration(13, mappingObject12);
                        str24 = mappingObject12 != null ? mappingObject12.getStr() : null;
                        j7 = 0;
                        if ((j & 550024249352L) != 0) {
                            i7 = ColorUtil.getColor(getRoot().getContext(), chan);
                            if ((j & 549890031624L) != j7) {
                                if (triggerParam != null) {
                                    str26 = str22;
                                    str25 = str24;
                                    j9 = triggerParam.getLevel();
                                } else {
                                    str25 = str24;
                                    str26 = str22;
                                    j9 = 0;
                                }
                                if (triggerParam != null) {
                                    str27 = triggerParam.getTriggerLevelStr(j9);
                                    boolean isNoise = ((j & 550292684808L) != 0 || triggerParam == null) ? false : triggerParam.getIsNoise();
                                    if ((j & 549772591112L) == 0) {
                                        if (triggerParam != null) {
                                            z14 = isNoise;
                                            str28 = str27;
                                            trigger_Lin_Ver = triggerParam.getTrigger_Lin_Ver();
                                        } else {
                                            str28 = str27;
                                            z14 = isNoise;
                                            trigger_Lin_Ver = null;
                                        }
                                        boolean z24 = trigger_Lin_Ver == ServiceEnum.Trigger_Lin_Ver.trig_lin_ver_1x;
                                        z17 = trigger_Lin_Ver == ServiceEnum.Trigger_Lin_Ver.trig_lin_ver_any;
                                        z15 = trigger_Lin_Ver == ServiceEnum.Trigger_Lin_Ver.trig_lin_ver_2x;
                                        z16 = z24;
                                    } else {
                                        str28 = str27;
                                        z14 = isNoise;
                                        z15 = false;
                                        z16 = false;
                                        z17 = false;
                                    }
                                    i8 = ((j & 549756338184L) > 0L ? 1 : ((j & 549756338184L) == 0L ? 0 : -1));
                                    if (i8 == 0) {
                                        if (triggerParam != null) {
                                            z19 = z16;
                                            z18 = z15;
                                            trigger_Lin_When = triggerParam.getTrigger_Lin_When();
                                        } else {
                                            z18 = z15;
                                            z19 = z16;
                                            trigger_Lin_When = null;
                                        }
                                        z22 = trigger_Lin_When == ServiceEnum.Trigger_Lin_When.trig_lin_sleep;
                                        i9 = i7;
                                        z20 = trigger_Lin_When == ServiceEnum.Trigger_Lin_When.trig_lin_id_data;
                                        z23 = trigger_Lin_When == ServiceEnum.Trigger_Lin_When.trig_lin_wakeup;
                                        str29 = str26;
                                        z5 = trigger_Lin_When == ServiceEnum.Trigger_Lin_When.trig_lin_id;
                                        boolean z25 = trigger_Lin_When == ServiceEnum.Trigger_Lin_When.trig_lin_sync;
                                        str = str32;
                                        boolean z26 = trigger_Lin_When == ServiceEnum.Trigger_Lin_When.trig_lin_err;
                                        z = trigger_Lin_When == ServiceEnum.Trigger_Lin_When.trig_lin_data;
                                        if (i8 != 0) {
                                            j |= z20 ? 2199023255552L : 1099511627776L;
                                        }
                                        if ((j & 549756338184L) != 0) {
                                            j |= z5 ? 562949953421312L : 281474976710656L;
                                        }
                                        if ((j & 549756338184L) != 0) {
                                            j |= z26 ? 36028797018963968L : 18014398509481984L;
                                        }
                                        if ((j & 288234774198222848L) != 0) {
                                            j |= z ? 140737488355328L : 70368744177664L;
                                        }
                                        if ((j & 549756338184L) != 0) {
                                            j |= z ? 9007199254740992L : 4503599627370496L;
                                        }
                                        i = z26 ? 0 : 8;
                                        z21 = z26;
                                        z6 = z25;
                                    } else {
                                        str = str32;
                                        z18 = z15;
                                        z19 = z16;
                                        i9 = i7;
                                        str29 = str26;
                                        z = false;
                                        i = 0;
                                        z20 = false;
                                        z5 = false;
                                        z6 = false;
                                        z21 = false;
                                        z22 = false;
                                        z23 = false;
                                    }
                                    if ((j & 549789368328L) == 0) {
                                        if (triggerParam != null) {
                                            long j10 = j;
                                            j8 = triggerParam.getLinSamplePosition();
                                            j2 = j10;
                                        } else {
                                            j2 = j;
                                            j8 = 0;
                                        }
                                        boolean z27 = z;
                                        String convert = UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(j8, ServiceEnum.Unit.Unit_percent);
                                        z7 = z20;
                                        str11 = formatValue4Str;
                                        str4 = str25;
                                        z10 = z14;
                                        z4 = z21;
                                        z11 = z17;
                                        z9 = z19;
                                        z3 = z22;
                                        i2 = i9;
                                        z2 = z23;
                                        str7 = str29;
                                        str10 = str20;
                                        str9 = str28;
                                        z8 = z18;
                                        str8 = str23;
                                        str6 = str19;
                                        str5 = convert;
                                        z = z27;
                                    } else {
                                        j2 = j;
                                        z7 = z20;
                                        str11 = formatValue4Str;
                                        str4 = str25;
                                        z10 = z14;
                                        z4 = z21;
                                        z11 = z17;
                                        z9 = z19;
                                        z3 = z22;
                                        i2 = i9;
                                        z2 = z23;
                                        str7 = str29;
                                        str10 = str20;
                                        str9 = str28;
                                        z8 = z18;
                                        str8 = str23;
                                        str6 = str19;
                                        str5 = null;
                                    }
                                }
                            } else {
                                str25 = str24;
                                str26 = str22;
                            }
                            str27 = null;
                            if ((j & 550292684808L) != 0) {
                            }
                            if ((j & 549772591112L) == 0) {
                            }
                            i8 = ((j & 549756338184L) > 0L ? 1 : ((j & 549756338184L) == 0L ? 0 : -1));
                            if (i8 == 0) {
                            }
                            if ((j & 549789368328L) == 0) {
                            }
                        }
                    } else {
                        str23 = str21;
                        j7 = 0;
                        str24 = null;
                    }
                    i7 = 0;
                    if ((j & 549890031624L) != j7) {
                    }
                    str27 = null;
                    if ((j & 550292684808L) != 0) {
                    }
                    if ((j & 549772591112L) == 0) {
                    }
                    i8 = ((j & 549756338184L) > 0L ? 1 : ((j & 549756338184L) == 0L ? 0 : -1));
                    if (i8 == 0) {
                    }
                    if ((j & 549789368328L) == 0) {
                    }
                }
            }
            str18 = null;
            if ((j & 549822922760L) == 0) {
            }
            if ((j & 549760008200L) == 0) {
            }
            if ((j & 618743734280L) == 0) {
            }
            i7 = 0;
            if ((j & 549890031624L) != j7) {
            }
            str27 = null;
            if ((j & 550292684808L) != 0) {
            }
            if ((j & 549772591112L) == 0) {
            }
            i8 = ((j & 549756338184L) > 0L ? 1 : ((j & 549756338184L) == 0L ? 0 : -1));
            if (i8 == 0) {
            }
            if ((j & 549789368328L) == 0) {
            }
        } else {
            str = str32;
            str2 = str33;
            str3 = str34;
            j2 = j;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
            str11 = null;
            z = false;
            z2 = false;
            z3 = false;
            i = 0;
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
            z8 = false;
            z9 = false;
            z10 = false;
            i2 = 0;
            z11 = false;
        }
        String str35 = ((j2 & 551903297600L) == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        String str36 = ((j2 & 554050781440L) == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        String str37 = ((j2 & 558345749504L) == 0 || mappingObject6 == null) ? null : mappingObject6.getStr();
        String str38 = ((j2 & 566935685120L) == 0 || mappingObject7 == null) ? null : mappingObject7.getStr();
        String str39 = ((j2 & 584115556352L) == 0 || mappingObject8 == null) ? null : mappingObject8.getStr();
        String str40 = ((j2 & 687194783744L) == 0 || mappingObject9 == null) ? null : mappingObject9.getStr();
        if ((j2 & 824633753600L) != 0 && mappingObject10 != null) {
            str31 = mappingObject10.getStr();
        }
        String str41 = str31;
        int i14 = ((j2 & 549756338184L) > 0L ? 1 : ((j2 & 549756338184L) == 0L ? 0 : -1));
        if (i14 != 0) {
            boolean z28 = z7 ? true : z;
            z12 = z5 ? true : z7;
            boolean z29 = z ? true : z7;
            if (i14 != 0) {
                j2 |= z28 ? 2251799813685248L : 1125899906842624L;
            }
            if ((j2 & 549756338184L) != 0) {
                if (z12) {
                    j5 = j2 | 8796093022208L;
                    j6 = 144115188075855872L;
                } else {
                    j5 = j2 | 4398046511104L;
                    j6 = 72057594037927936L;
                }
                j2 = j5 | j6;
            }
            if ((j2 & 549756338184L) != 0) {
                if (z29) {
                    j3 = j2 | 35184372088832L;
                    j4 = LockFreeTaskQueueCore.CLOSED_MASK;
                } else {
                    j3 = j2 | 17592186044416L;
                    j4 = LockFreeTaskQueueCore.FROZEN_MASK;
                }
                j2 = j3 | j4;
            }
            int i15 = z28 ? 0 : 8;
            str12 = str36;
            i3 = z29 ? 0 : 4;
            int i16 = i15;
            str13 = str38;
            i4 = i16;
            int i17 = z29 ? 0 : 8;
            str14 = str41;
            i5 = i17;
        } else {
            str12 = str36;
            str13 = str38;
            str14 = str41;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            z12 = false;
        }
        int i18 = (j2 & 4398046511104L) != 0 ? z ? 4 : 8 : 0;
        int i19 = ((j2 & 549756338184L) > 0L ? 1 : ((j2 & 549756338184L) == 0L ? 0 : -1));
        if (i19 != 0) {
            z13 = z12 ? true : z4;
            if (i19 != 0) {
                j2 |= z13 ? 576460752303423488L : 288230376151711744L;
            }
        } else {
            z13 = false;
        }
        int i20 = ((j2 & 549756338184L) > 0L ? 1 : ((j2 & 549756338184L) == 0L ? 0 : -1));
        if (i20 != 0) {
            str15 = str39;
            i6 = z12 ? 0 : i18;
        } else {
            str15 = str39;
            i6 = 0;
        }
        if ((j2 & 288230376151711744L) != 0) {
            i18 = z ? 4 : 8;
        }
        if (i20 != 0 && !z13) {
            i13 = i18;
        }
        String str42 = str35;
        int i21 = i13;
        if (i20 != 0) {
            str16 = str37;
            this.triggerErrTypeLabel.setVisibility(i);
            this.triggerErrTypeValue.setVisibility(i);
            this.triggerLinBytelengthLabel.setVisibility(i4);
            this.triggerLinBytelengthValue.setVisibility(i4);
            CompoundButtonBindingAdapter.setChecked(this.triggerLinData, z);
            CompoundButtonBindingAdapter.setChecked(this.triggerLinDataId, z7);
            this.triggerLinDataLabel.setVisibility(i5);
            this.triggerLinDataValue.setVisibility(i5);
            CompoundButtonBindingAdapter.setChecked(this.triggerLinError, z4);
            CompoundButtonBindingAdapter.setChecked(this.triggerLinId, z5);
            this.triggerLinIdLabel.setVisibility(i6);
            this.triggerLinIdValue.setVisibility(i6);
            CompoundButtonBindingAdapter.setChecked(this.triggerLinSleep, z3);
            CompoundButtonBindingAdapter.setChecked(this.triggerLinSync, z6);
            CompoundButtonBindingAdapter.setChecked(this.triggerLinWakeup, z2);
            this.view3.setVisibility(i3);
            this.view4.setVisibility(i21);
        } else {
            str16 = str37;
        }
        if ((j2 & 550830604328L) != 0) {
            TextViewBindingAdapter.setText(this.triggerErrTypeValue, str10);
        }
        if ((j2 & 549890031624L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelValue, str9);
        }
        if ((j2 & 549822922760L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLinBaudValue, str8);
        }
        if ((j2 & 549760008200L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLinBytelengthValue, str7);
        }
        if ((j2 & 687194783744L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLinData, str40);
        }
        if ((j2 & 558345749504L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLinDataId, str16);
        }
        if ((j2 & 549764202504L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLinDataValue, str11);
        }
        if ((j2 & 551903297600L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLinError, str42);
        }
        if ((j2 & 584115556352L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLinId, str15);
        }
        if ((j2 & 549757911048L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLinIdValue, str6);
        }
        if ((j2 & 549755879425L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLinSleep, str);
        }
        if ((j2 & 549756076036L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLinSync, str3);
        }
        if ((j2 & 549772591112L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerLinVersion1, z9);
            CompoundButtonBindingAdapter.setChecked(this.triggerLinVersion2, z8);
            CompoundButtonBindingAdapter.setChecked(this.triggerLinVersionBoth, z11);
        }
        if ((j2 & 824633753600L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLinVersion1, str14);
        }
        if ((j2 & 554050781440L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLinVersion2, str12);
        }
        if ((j2 & 566935685120L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLinVersionBoth, str13);
        }
        if ((j2 & 549755944962L) != 0) {
            TextViewBindingAdapter.setText(this.triggerLinWakeup, str2);
        }
        if ((j2 & 550292684808L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerNoiseSwitch, z10);
        }
        if ((j2 & 549789368328L) != 0) {
            TextViewBindingAdapter.setText(this.triggerSamplePointsValue, str5);
        }
        if ((j2 & 618743734280L) != 0) {
            TextViewBindingAdapter.setText(this.triggerSourceLinValue, str4);
        }
        if ((j2 & 550024249352L) != 0) {
            this.triggerSourceLinValue.setTextColor(i2);
        }
    }
}
