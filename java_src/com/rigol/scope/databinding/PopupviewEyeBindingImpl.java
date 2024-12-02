package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.RadioGroupBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.BaseProperty;
import com.rigol.scope.data.EyeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;

/* loaded from: classes2.dex */
public class PopupviewEyeBindingImpl extends PopupviewEyeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.center_guideline, 20);
        sViewsWithIds.put(R.id.left_guideline, 21);
        sViewsWithIds.put(R.id.right_guideline, 22);
        sViewsWithIds.put(R.id.eye_enabled_label, 23);
        sViewsWithIds.put(R.id.eye_source_label, 24);
        sViewsWithIds.put(R.id.eye_high_thres_label, 25);
        sViewsWithIds.put(R.id.eye_mid_thres_label, 26);
        sViewsWithIds.put(R.id.eye_low_thres_label, 27);
        sViewsWithIds.put(R.id.eye_recoverType_label, 28);
        sViewsWithIds.put(R.id.eye_divider1, 29);
        sViewsWithIds.put(R.id.eye_recoverType_view, 30);
        sViewsWithIds.put(R.id.eye_template, 31);
        sViewsWithIds.put(R.id.eye_template_status_label, 32);
        sViewsWithIds.put(R.id.eye_divider, 33);
        sViewsWithIds.put(R.id.eye_noise_holdup_label, 34);
        sViewsWithIds.put(R.id.eye_persistance_label, 35);
        sViewsWithIds.put(R.id.eye_divider2, 36);
        sViewsWithIds.put(R.id.eye_meas_en_label, 37);
        sViewsWithIds.put(R.id.grid_type, 38);
    }

    public PopupviewEyeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 39, sIncludes, sViewsWithIds));
    }

    private PopupviewEyeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 21, (Guideline) objArr[20], (RadioButton) objArr[7], (View) objArr[33], (View) objArr[29], (View) objArr[36], (TextView) objArr[23], (RadioButton) objArr[9], (SwitchButton) objArr[1], (TextView) objArr[25], (TextView) objArr[3], (TextView) objArr[27], (TextView) objArr[5], (TextView) objArr[37], (SwitchButton) objArr[14], (TextView) objArr[26], (TextView) objArr[4], (TextView) objArr[34], (TextView) objArr[12], (TextView) objArr[35], (SwitchButton) objArr[13], (RadioButton) objArr[8], (TextView) objArr[28], (RadioGroup) objArr[6], (RecyclerView) objArr[30], (TextView) objArr[24], (TextView) objArr[2], (TextView) objArr[31], (TextView) objArr[32], (SwitchButton) objArr[11], (TextView) objArr[10], (RadioButton) objArr[17], (TextView) objArr[38], (RadioGroup) objArr[16], (RadioButton) objArr[18], (Guideline) objArr[21], (RadioButton) objArr[19], (Button) objArr[15], (Guideline) objArr[22]);
        this.mDirtyFlags = -1L;
        this.eyeConstantRadioButton.setTag(null);
        this.eyeExplicitRadioButton.setTag(null);
        this.eyeEyeEnSwitchButton.setTag(null);
        this.eyeHighThresValue.setTag(null);
        this.eyeLowThresValue.setTag(null);
        this.eyeMeasEnSwitchButton.setTag(null);
        this.eyeMidThresValue.setTag(null);
        this.eyeNoiseHoldupValue.setTag(null);
        this.eyePersistanceSwitchButton.setTag(null);
        this.eyePllRadioButton.setTag(null);
        this.eyeRecoverTypeRadioGroup.setTag(null);
        this.eyeSourceValue.setTag(null);
        this.eyeTemplateStatusSwitchButton.setTag(null);
        this.eyeTemplateValue.setTag(null);
        this.fullRadioButton.setTag(null);
        this.gridTypeRadioGroup.setTag(null);
        this.halfRadioButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.noneRadioButton.setTag(null);
        this.resetColorButton.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 35184372088832L;
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
        if (358 == i) {
            setGridFullMapping((MappingObject) obj);
        } else if (640 == i) {
            setPllMapping((MappingObject) obj);
        } else if (1032 == i) {
            setView((View) obj);
        } else if (568 == i) {
            setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) obj);
        } else if (189 == i) {
            setConstantMapping((MappingObject) obj);
        } else if (571 == i) {
            setOnSwitchCheckedChangeListener((CompoundButton.OnCheckedChangeListener) obj);
        } else if (594 == i) {
            setParam((EyeParam) obj);
        } else if (569 == i) {
            setOnClickListener((View.OnClickListener) obj);
        } else if (359 == i) {
            setGridHalfMapping((MappingObject) obj);
        } else if (361 == i) {
            setGridNoneMapping((MappingObject) obj);
        } else if (291 != i) {
            return false;
        } else {
            setExplicitMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewEyeBinding
    public void setGridFullMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mGridFullMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(358);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewEyeBinding
    public void setPllMapping(MappingObject mappingObject) {
        updateRegistration(3, mappingObject);
        this.mPllMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(640);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewEyeBinding
    public void setView(View view) {
        this.mView = view;
    }

    @Override // com.rigol.scope.databinding.PopupviewEyeBinding
    public void setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnCheckedChangeListener = onCheckedChangeListener;
        synchronized (this) {
            this.mDirtyFlags |= 4194304;
        }
        notifyPropertyChanged(568);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewEyeBinding
    public void setConstantMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mConstantMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(189);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewEyeBinding
    public void setOnSwitchCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnSwitchCheckedChangeListener = onCheckedChangeListener;
        synchronized (this) {
            this.mDirtyFlags |= 8388608;
        }
        notifyPropertyChanged(571);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewEyeBinding
    public void setParam(EyeParam eyeParam) {
        updateRegistration(6, eyeParam);
        this.mParam = eyeParam;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewEyeBinding
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 16777216;
        }
        notifyPropertyChanged(569);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewEyeBinding
    public void setGridHalfMapping(MappingObject mappingObject) {
        updateRegistration(8, mappingObject);
        this.mGridHalfMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(359);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewEyeBinding
    public void setGridNoneMapping(MappingObject mappingObject) {
        updateRegistration(9, mappingObject);
        this.mGridNoneMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(361);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewEyeBinding
    public void setExplicitMapping(MappingObject mappingObject) {
        updateRegistration(15, mappingObject);
        this.mExplicitMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(291);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeGridFullMapping((MappingObject) obj, i2);
            case 1:
                return onChangeParamNoiseHoldUp((BaseProperty) obj, i2);
            case 2:
                return onChangeParamMidThres((BaseProperty) obj, i2);
            case 3:
                return onChangePllMapping((MappingObject) obj, i2);
            case 4:
                return onChangeConstantMapping((MappingObject) obj, i2);
            case 5:
                return onChangeParamChan((BaseProperty) obj, i2);
            case 6:
                return onChangeParam((EyeParam) obj, i2);
            case 7:
                return onChangeParamRecoveryType((BaseProperty) obj, i2);
            case 8:
                return onChangeGridHalfMapping((MappingObject) obj, i2);
            case 9:
                return onChangeGridNoneMapping((MappingObject) obj, i2);
            case 10:
                return onChangeParamGrids((BaseProperty) obj, i2);
            case 11:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgEyeSourceParamChanValue((MappingObject) obj, i2);
            case 12:
                return onChangeParamEyeTemplate((BaseProperty) obj, i2);
            case 13:
                return onChangeParamLowThres((BaseProperty) obj, i2);
            case 14:
                return onChangeParamEnabled((BaseProperty) obj, i2);
            case 15:
                return onChangeExplicitMapping((MappingObject) obj, i2);
            case 16:
                return onChangeParamPersistance((BaseProperty) obj, i2);
            case 17:
                return onChangeParamResult((BaseProperty) obj, i2);
            case 18:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgEyeTemplateParamEyeTemplateValue((MappingObject) obj, i2);
            case 19:
                return onChangeParamHighThres((BaseProperty) obj, i2);
            case 20:
                return onChangeParamTemplateFlag((BaseProperty) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeGridFullMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
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

    private boolean onChangeParamNoiseHoldUp(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParamMidThres(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangePllMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
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

    private boolean onChangeConstantMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangeParamChan(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 1073741824;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(EyeParam eyeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParamRecoveryType(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 2147483648L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeGridHalfMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeGridNoneMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
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

    private boolean onChangeParamGrids(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 17179869184L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgEyeSourceParamChanValue(MappingObject mappingObject, int i) {
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

    private boolean onChangeParamEyeTemplate(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 68719476736L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParamLowThres(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 137438953472L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParamEnabled(BaseProperty<Boolean> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 274877906944L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeExplicitMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeParamPersistance(BaseProperty<Boolean> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 1099511627776L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParamResult(BaseProperty<Boolean> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 2199023255552L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgEyeTemplateParamEyeTemplateValue(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
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

    private boolean onChangeParamHighThres(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 8796093022208L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParamTemplateFlag(BaseProperty<Boolean> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 17592186044416L;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01eb  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        int i;
        RadioGroup.OnCheckedChangeListener onCheckedChangeListener;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i2;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        String str8;
        String str9;
        String str10;
        RadioGroup.OnCheckedChangeListener onCheckedChangeListener2;
        String str11;
        long j2;
        String str12;
        int i3;
        boolean z11;
        boolean z12;
        int i4;
        boolean z13;
        String str13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        String str14;
        String str15;
        int i5;
        String str16;
        String str17;
        boolean z18;
        boolean z19;
        String str18;
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        BaseProperty<Integer> baseProperty;
        BaseProperty<Boolean> baseProperty2;
        BaseProperty<Integer> baseProperty3;
        BaseProperty<Integer> baseProperty4;
        BaseProperty<Integer> baseProperty5;
        BaseProperty<Integer> baseProperty6;
        int i6;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mGridFullMapping;
        MappingObject mappingObject2 = this.mPllMapping;
        RadioGroup.OnCheckedChangeListener onCheckedChangeListener3 = this.mOnCheckedChangeListener;
        MappingObject mappingObject3 = this.mConstantMapping;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener4 = this.mOnSwitchCheckedChangeListener;
        EyeParam eyeParam = this.mParam;
        View.OnClickListener onClickListener = this.mOnClickListener;
        MappingObject mappingObject4 = this.mGridHalfMapping;
        MappingObject mappingObject5 = this.mGridNoneMapping;
        MappingObject mappingObject6 = this.mExplicitMapping;
        int i7 = ((35184405643265L & j) > 0L ? 1 : ((35184405643265L & j) == 0L ? 0 : -1));
        String str19 = (i7 == 0 || mappingObject == null) ? null : mappingObject.getStr();
        int i8 = ((j & 35184640524296L) > 0L ? 1 : ((j & 35184640524296L) == 0L ? 0 : -1));
        String str20 = (i8 == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        int i9 = ((j & 35184376283136L) > 0L ? 1 : ((j & 35184376283136L) == 0L ? 0 : -1));
        int i10 = ((j & 35184908959760L) > 0L ? 1 : ((j & 35184908959760L) == 0L ? 0 : -1));
        String str21 = (i10 == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        int i11 = ((j & 35184380477440L) > 0L ? 1 : ((j & 35184380477440L) == 0L ? 0 : -1));
        boolean z24 = false;
        if ((j & 69805233110246L) != 0) {
            if ((j & 35184439197762L) != 0) {
                BaseProperty<Integer> noiseHoldUp = eyeParam != null ? eyeParam.getNoiseHoldUp() : null;
                updateRegistration(1, noiseHoldUp);
                str = str19;
                i = i7;
                str10 = UnitFormat.newBuilder(" 0.000", UnitFormat.SI.MICRO).convert(ViewDataBinding.safeUnbox(noiseHoldUp != null ? noiseHoldUp.getValue() : null), ServiceEnum.Unit.Unit_V);
            } else {
                str = str19;
                i = i7;
                str10 = null;
            }
            if ((j & 35184506306628L) != 0) {
                BaseProperty<Integer> midThres = eyeParam != null ? eyeParam.getMidThres() : null;
                updateRegistration(2, midThres);
                str2 = str20;
                onCheckedChangeListener2 = onCheckedChangeListener3;
                str11 = UnitFormat.newBuilder(UnitFormat.PATTERN_SIGN, UnitFormat.SI.NONE).convert(ViewDataBinding.safeUnbox(midThres != null ? midThres.getValue() : null)) + ServiceEnum.Unit.Unit_percent.value2;
            } else {
                str2 = str20;
                onCheckedChangeListener2 = onCheckedChangeListener3;
                str11 = null;
            }
            if ((j & 35219805571168L) != 0) {
                BaseProperty<Integer> chan = eyeParam != null ? eyeParam.getChan() : null;
                updateRegistration(5, chan);
                int safeUnbox = ViewDataBinding.safeUnbox(chan != null ? chan.getValue() : null);
                MappingObject mappingObject7 = ViewUtil.getMappingObject(R.array.msg_eye_source, safeUnbox);
                updateRegistration(11, mappingObject7);
                str12 = mappingObject7 != null ? mappingObject7.getStr() : null;
                j2 = 0;
                if ((j & 35185445830752L) != 0) {
                    i3 = ColorUtil.getColor(getRoot().getContext(), ServiceEnum.getChanFromValue1(safeUnbox));
                    if ((j & 35186519572672L) == j2) {
                        if (eyeParam != null) {
                            baseProperty6 = eyeParam.getRecoveryType();
                            str6 = str10;
                        } else {
                            str6 = str10;
                            baseProperty6 = null;
                        }
                        updateRegistration(7, baseProperty6);
                        int safeUnbox2 = ViewDataBinding.safeUnbox(baseProperty6 != null ? baseProperty6.getValue() : null);
                        if (safeUnbox2 == 2) {
                            i6 = true;
                            z12 = true;
                        } else {
                            z12 = false;
                            i6 = true;
                        }
                        i4 = safeUnbox2 == i6 ? i6 : false;
                        z11 = safeUnbox2 == 0 ? i6 : false;
                    } else {
                        str6 = str10;
                        z11 = false;
                        z12 = false;
                        i4 = false;
                    }
                    if ((j & 35201551959104L) == 0) {
                        if (eyeParam != null) {
                            z13 = z11;
                            baseProperty5 = eyeParam.getGrids();
                        } else {
                            z13 = z11;
                            baseProperty5 = null;
                        }
                        updateRegistration(10, baseProperty5);
                        int safeUnbox3 = ViewDataBinding.safeUnbox(baseProperty5 != null ? baseProperty5.getValue() : null);
                        str13 = str11;
                        z15 = safeUnbox3 == ServiceEnum.EWaveGrids.GRID_IS_HALF.value1;
                        z16 = safeUnbox3 == ServiceEnum.EWaveGrids.GRID_IS_NONE.value1;
                        z14 = safeUnbox3 == ServiceEnum.EWaveGrids.GRID_IS_FULL.value1;
                    } else {
                        z13 = z11;
                        str13 = str11;
                        z14 = false;
                        z15 = false;
                        z16 = false;
                    }
                    if ((j & 39651138342976L) == 0) {
                        if (eyeParam != null) {
                            baseProperty4 = eyeParam.getEyeTemplate();
                            z17 = z14;
                        } else {
                            z17 = z14;
                            baseProperty4 = null;
                        }
                        updateRegistration(12, baseProperty4);
                        MappingObject mappingObject8 = ViewUtil.getMappingObject(R.array.msg_eye_template, ViewDataBinding.safeUnbox(baseProperty4 != null ? baseProperty4.getValue() : null));
                        updateRegistration(18, mappingObject8);
                        if (mappingObject8 != null) {
                            str14 = mappingObject8.getStr();
                            if ((j & 35321811050560L) != 0) {
                                if (eyeParam != null) {
                                    baseProperty3 = eyeParam.getLowThres();
                                    str15 = str14;
                                } else {
                                    str15 = str14;
                                    baseProperty3 = null;
                                }
                                updateRegistration(13, baseProperty3);
                                i5 = i3;
                                str16 = str12;
                                str17 = UnitFormat.newBuilder(UnitFormat.PATTERN_SIGN, UnitFormat.SI.NONE).convert(ViewDataBinding.safeUnbox(baseProperty3 != null ? baseProperty3.getValue() : null)) + ServiceEnum.Unit.Unit_percent.value2;
                            } else {
                                str15 = str14;
                                i5 = i3;
                                str16 = str12;
                                str17 = null;
                            }
                            if ((j & 35459250012224L) != 0) {
                                BaseProperty<Boolean> enabled = eyeParam != null ? eyeParam.getEnabled() : null;
                                updateRegistration(14, enabled);
                                z18 = ViewDataBinding.safeUnbox(enabled != null ? enabled.getValue() : null);
                            } else {
                                z18 = false;
                            }
                            if ((j & 36283883782208L) != 0) {
                                BaseProperty<Boolean> persistance = eyeParam != null ? eyeParam.getPersistance() : null;
                                updateRegistration(16, persistance);
                                z19 = ViewDataBinding.safeUnbox(persistance != null ? persistance.getValue() : null);
                            } else {
                                z19 = false;
                            }
                            if ((j & 37383395475520L) != 0) {
                                if (eyeParam != null) {
                                    baseProperty2 = eyeParam.getResult();
                                    str18 = str17;
                                } else {
                                    str18 = str17;
                                    baseProperty2 = null;
                                }
                                updateRegistration(17, baseProperty2);
                                z20 = ViewDataBinding.safeUnbox(baseProperty2 != null ? baseProperty2.getValue() : null);
                            } else {
                                str18 = str17;
                                z20 = false;
                            }
                            if ((j & 43980465635392L) != 0) {
                                if (eyeParam != null) {
                                    baseProperty = eyeParam.getHighThres();
                                    z21 = z20;
                                } else {
                                    z21 = z20;
                                    baseProperty = null;
                                }
                                updateRegistration(19, baseProperty);
                                z22 = z18;
                                z23 = z19;
                                str3 = UnitFormat.newBuilder(UnitFormat.PATTERN_SIGN, UnitFormat.SI.NONE).convert(ViewDataBinding.safeUnbox(baseProperty != null ? baseProperty.getValue() : null)) + ServiceEnum.Unit.Unit_percent.value2;
                            } else {
                                z21 = z20;
                                z22 = z18;
                                z23 = z19;
                                str3 = null;
                            }
                            if ((j & 52776559181888L) != 0) {
                                BaseProperty<Boolean> templateFlag = eyeParam != null ? eyeParam.getTemplateFlag() : null;
                                updateRegistration(20, templateFlag);
                                z24 = ViewDataBinding.safeUnbox(templateFlag != null ? templateFlag.getValue() : null);
                            }
                            z9 = z15;
                            z7 = z24;
                            z2 = i4;
                            z8 = z17;
                            z4 = z13;
                            str7 = str13;
                            z10 = z16;
                            str8 = str15;
                            i2 = i5;
                            str5 = str16;
                            str4 = str18;
                            z3 = z21;
                            z = z22;
                            z6 = z23;
                            boolean z25 = z12;
                            onCheckedChangeListener = onCheckedChangeListener2;
                            z5 = z25;
                        }
                    } else {
                        z17 = z14;
                    }
                    str14 = null;
                    if ((j & 35321811050560L) != 0) {
                    }
                    if ((j & 35459250012224L) != 0) {
                    }
                    if ((j & 36283883782208L) != 0) {
                    }
                    if ((j & 37383395475520L) != 0) {
                    }
                    if ((j & 43980465635392L) != 0) {
                    }
                    if ((j & 52776559181888L) != 0) {
                    }
                    z9 = z15;
                    z7 = z24;
                    z2 = i4;
                    z8 = z17;
                    z4 = z13;
                    str7 = str13;
                    z10 = z16;
                    str8 = str15;
                    i2 = i5;
                    str5 = str16;
                    str4 = str18;
                    z3 = z21;
                    z = z22;
                    z6 = z23;
                    boolean z252 = z12;
                    onCheckedChangeListener = onCheckedChangeListener2;
                    z5 = z252;
                }
            } else {
                j2 = 0;
                str12 = null;
            }
            i3 = 0;
            if ((j & 35186519572672L) == j2) {
            }
            if ((j & 35201551959104L) == 0) {
            }
            if ((j & 39651138342976L) == 0) {
            }
            str14 = null;
            if ((j & 35321811050560L) != 0) {
            }
            if ((j & 35459250012224L) != 0) {
            }
            if ((j & 36283883782208L) != 0) {
            }
            if ((j & 37383395475520L) != 0) {
            }
            if ((j & 43980465635392L) != 0) {
            }
            if ((j & 52776559181888L) != 0) {
            }
            z9 = z15;
            z7 = z24;
            z2 = i4;
            z8 = z17;
            z4 = z13;
            str7 = str13;
            z10 = z16;
            str8 = str15;
            i2 = i5;
            str5 = str16;
            str4 = str18;
            z3 = z21;
            z = z22;
            z6 = z23;
            boolean z2522 = z12;
            onCheckedChangeListener = onCheckedChangeListener2;
            z5 = z2522;
        } else {
            str = str19;
            str2 = str20;
            i = i7;
            onCheckedChangeListener = onCheckedChangeListener3;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            i2 = 0;
            z7 = false;
            z8 = false;
            z9 = false;
            z10 = false;
            str8 = null;
        }
        int i12 = ((j & 35184388866048L) > 0L ? 1 : ((j & 35184388866048L) == 0L ? 0 : -1));
        int i13 = ((j & 35188667056384L) > 0L ? 1 : ((j & 35188667056384L) == 0L ? 0 : -1));
        String str22 = (i13 == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        int i14 = ((j & 35192962023936L) > 0L ? 1 : ((j & 35192962023936L) == 0L ? 0 : -1));
        String str23 = (i14 == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        int i15 = ((j & 35734127935488L) > 0L ? 1 : ((j & 35734127935488L) == 0L ? 0 : -1));
        String str24 = (i15 == 0 || mappingObject6 == null) ? null : mappingObject6.getStr();
        if ((j & 35186519572672L) != 0) {
            str9 = str23;
            CompoundButtonBindingAdapter.setChecked(this.eyeConstantRadioButton, z4);
            CompoundButtonBindingAdapter.setChecked(this.eyeExplicitRadioButton, z5);
            CompoundButtonBindingAdapter.setChecked(this.eyePllRadioButton, z2);
        } else {
            str9 = str23;
        }
        if (i10 != 0) {
            TextViewBindingAdapter.setText(this.eyeConstantRadioButton, str21);
        }
        if (i15 != 0) {
            TextViewBindingAdapter.setText(this.eyeExplicitRadioButton, str24);
        }
        if ((j & 35459250012224L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.eyeEyeEnSwitchButton, z);
        }
        if (i11 != 0) {
            InverseBindingListener inverseBindingListener = null;
            CompoundButtonBindingAdapter.setListeners(this.eyeEyeEnSwitchButton, onCheckedChangeListener4, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.eyeMeasEnSwitchButton, onCheckedChangeListener4, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.eyePersistanceSwitchButton, onCheckedChangeListener4, inverseBindingListener);
            CompoundButtonBindingAdapter.setListeners(this.eyeTemplateStatusSwitchButton, onCheckedChangeListener4, inverseBindingListener);
        }
        if (i12 != 0) {
            this.eyeHighThresValue.setOnClickListener(onClickListener);
            this.eyeLowThresValue.setOnClickListener(onClickListener);
            this.eyeMidThresValue.setOnClickListener(onClickListener);
            this.eyeNoiseHoldupValue.setOnClickListener(onClickListener);
            this.eyeSourceValue.setOnClickListener(onClickListener);
            this.eyeTemplateValue.setOnClickListener(onClickListener);
            this.resetColorButton.setOnClickListener(onClickListener);
        }
        if ((j & 43980465635392L) != 0) {
            TextViewBindingAdapter.setText(this.eyeHighThresValue, str3);
        }
        if ((j & 35321811050560L) != 0) {
            TextViewBindingAdapter.setText(this.eyeLowThresValue, str4);
        }
        if ((j & 37383395475520L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.eyeMeasEnSwitchButton, z3);
        }
        if ((j & 35184506306628L) != 0) {
            TextViewBindingAdapter.setText(this.eyeMidThresValue, str7);
        }
        if ((j & 35184439197762L) != 0) {
            TextViewBindingAdapter.setText(this.eyeNoiseHoldupValue, str6);
        }
        if ((j & 36283883782208L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.eyePersistanceSwitchButton, z6);
        }
        if (i8 != 0) {
            TextViewBindingAdapter.setText(this.eyePllRadioButton, str2);
        }
        if (i9 != 0) {
            InverseBindingListener inverseBindingListener2 = null;
            RadioGroup.OnCheckedChangeListener onCheckedChangeListener5 = onCheckedChangeListener;
            RadioGroupBindingAdapter.setListeners(this.eyeRecoverTypeRadioGroup, onCheckedChangeListener5, inverseBindingListener2);
            RadioGroupBindingAdapter.setListeners(this.gridTypeRadioGroup, onCheckedChangeListener5, inverseBindingListener2);
        }
        if ((j & 35219805571168L) != 0) {
            TextViewBindingAdapter.setText(this.eyeSourceValue, str5);
        }
        if ((j & 35185445830752L) != 0) {
            this.eyeSourceValue.setTextColor(i2);
        }
        if ((j & 52776559181888L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.eyeTemplateStatusSwitchButton, z7);
        }
        if ((j & 39651138342976L) != 0) {
            TextViewBindingAdapter.setText(this.eyeTemplateValue, str8);
        }
        if ((j & 35201551959104L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.fullRadioButton, z8);
            CompoundButtonBindingAdapter.setChecked(this.halfRadioButton, z9);
            CompoundButtonBindingAdapter.setChecked(this.noneRadioButton, z10);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.fullRadioButton, str);
        }
        if (i13 != 0) {
            TextViewBindingAdapter.setText(this.halfRadioButton, str22);
        }
        if (i14 != 0) {
            TextViewBindingAdapter.setText(this.noneRadioButton, str9);
        }
    }
}
