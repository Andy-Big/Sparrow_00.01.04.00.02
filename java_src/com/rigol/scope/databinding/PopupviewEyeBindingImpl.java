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
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.BaseProperty;
import com.rigol.scope.data.EyeParam;
import com.rigol.scope.data.MappingObject;
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
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewEyeBindingImpl.executeBindings():void");
    }
}
