package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AfgParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageLoadParam;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.baseview.BaseEditText;

/* loaded from: classes2.dex */
public class AdapterAfgBindingImpl extends AdapterAfgBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.left_guideline, 24);
        sViewsWithIds.put(R.id.left_guideline1, 25);
        sViewsWithIds.put(R.id.left_guideline2, 26);
        sViewsWithIds.put(R.id.sweep_out_text, 27);
        sViewsWithIds.put(R.id.source_type_text, 28);
        sViewsWithIds.put(R.id.basic_deviation_text, 29);
    }

    public AdapterAfgBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 30, sIncludes, sViewsWithIds));
    }

    private AdapterAfgBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (BaseEditText) objArr[11], (TextView) objArr[10], (TextView) objArr[18], (TextView) objArr[16], (BaseEditText) objArr[23], (TextView) objArr[29], (BaseEditText) objArr[13], (TextView) objArr[12], (BaseEditText) objArr[19], (BaseEditText) objArr[22], (TextView) objArr[21], (BaseEditText) objArr[15], (TextView) objArr[14], (BaseEditText) objArr[17], (TextView) objArr[5], (TextView) objArr[3], (ImageView) objArr[8], (BaseEditText) objArr[7], (BaseEditText) objArr[9], (BaseEditText) objArr[6], (SwitchButton) objArr[1], (Guideline) objArr[24], (Guideline) objArr[25], (Guideline) objArr[26], (Button) objArr[20], (TextView) objArr[4], (TextView) objArr[2], (TextView) objArr[28], (TextView) objArr[27]);
        this.mDirtyFlags = -1L;
        this.basicAmpEdit.setTag(null);
        this.basicAmpText.setTag(null);
        this.basicBasicPathText.setTag(null);
        this.basicBasicWidthText.setTag(null);
        this.basicDeviationEdit.setTag(null);
        this.basicDutycycleEdit.setTag(null);
        this.basicDutycycleText.setTag(null);
        this.basicPathEdit.setTag(null);
        this.basicPhaseEdit.setTag(null);
        this.basicPhaseText.setTag(null);
        this.basicSymmetryEdit.setTag(null);
        this.basicSymmetryText.setTag(null);
        this.basicWidthEdit.setTag(null);
        this.declineText.setTag(null);
        this.fraguencyText.setTag(null);
        this.iconAfg.setTag(null);
        this.labelDeclineText.setTag(null);
        this.labelEditText.setTag(null);
        this.labelRiseedgeText.setTag(null);
        this.labelSwitch.setTag(null);
        this.loadBtn.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.riseText.setTag(null);
        this.sourceTypeSpinner.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
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
            setParam((AfgParam) obj);
        } else if (913 != i) {
            return false;
        } else {
            setStorageLoadParam((StorageLoadParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterAfgBinding
    public void setParam(AfgParam afgParam) {
        updateRegistration(0, afgParam);
        this.mParam = afgParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterAfgBinding
    public void setStorageLoadParam(StorageLoadParam storageLoadParam) {
        this.mStorageLoadParam = storageLoadParam;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    return onChangeStorageLoadParam((StorageLoadParam) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveFunction1ParamWaveFunction((MappingObject) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveFunctionParamWaveFunction((MappingObject) obj, i2);
        }
        return onChangeParam((AfgParam) obj, i2);
    }

    private boolean onChangeParam(AfgParam afgParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 81) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 1040) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 85) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 76) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 77) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 75) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 86) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 74) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 84) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 1048) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 83) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 80) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveFunctionParamWaveFunction(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAfgWaveFunction1ParamWaveFunction(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 638) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeStorageLoadParam(StorageLoadParam storageLoadParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Drawable drawable;
        String str9;
        String str10;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        long j2;
        String str11;
        String str12;
        String str13;
        int i7;
        String str14;
        String str15;
        String str16;
        Drawable drawable2;
        String str17;
        int i8;
        int i9;
        boolean z5;
        int i10;
        int i11;
        int i12;
        boolean z6;
        int i13;
        Drawable drawable3;
        boolean z7;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        boolean z8;
        long j3;
        long j4;
        long j5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        AfgParam afgParam = this.mParam;
        if ((1048567 & j) != 0) {
            if ((j & 983079) != 0) {
                int wave_function = afgParam != null ? afgParam.getWave_function() : 0;
                if ((j & 720931) != 0) {
                    MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_afg_wave_function, wave_function);
                    updateRegistration(1, mappingObject);
                    int i14 = ((j & 655395) > 0L ? 1 : ((j & 655395) == 0L ? 0 : -1));
                    if (i14 != 0) {
                        int value = mappingObject != null ? mappingObject.getValue() : 0;
                        boolean z9 = value == 1;
                        boolean z10 = value == 2;
                        z6 = value != 4;
                        z5 = value != 5;
                        boolean z11 = value == 100;
                        boolean z12 = value == 3;
                        boolean z13 = value == 6;
                        if (i14 != 0) {
                            j |= z9 ? 137438953472L : 68719476736L;
                        }
                        if ((j & 655395) != 0) {
                            j |= z10 ? 8388608L : 4194304L;
                        }
                        if ((j & 655395) != 0) {
                            j |= z6 ? 2147483648L : 1073741824L;
                        }
                        if ((j & 655395) != 0) {
                            j |= z5 ? 8589934592L : 4294967296L;
                        }
                        if ((j & 655395) != 0) {
                            j |= z11 ? 134217728L : 67108864L;
                        }
                        if ((j & 655395) != 0) {
                            j |= z12 ? 34359738368L : 17179869184L;
                        }
                        if ((j & 655395) != 0) {
                            j |= z13 ? 33554432L : 16777216L;
                        }
                        i9 = z9 ? 0 : 8;
                        i12 = z10 ? 0 : 8;
                        i13 = z5 ? 0 : 8;
                        i10 = z11 ? 0 : 8;
                        i11 = z12 ? 0 : 8;
                        i8 = z13 ? 0 : 8;
                    } else {
                        i8 = 0;
                        i9 = 0;
                        z5 = false;
                        i10 = 0;
                        i11 = 0;
                        i12 = 0;
                        z6 = false;
                        i13 = 0;
                    }
                    str17 = ((j & 589859) == 0 || mappingObject == null) ? null : mappingObject.getStr();
                } else {
                    str17 = null;
                    i8 = 0;
                    i9 = 0;
                    z5 = false;
                    i10 = 0;
                    i11 = 0;
                    i12 = 0;
                    z6 = false;
                    i13 = 0;
                }
                if ((j & 786469) != 0) {
                    MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_afg_wave_function1, wave_function);
                    updateRegistration(2, mappingObject2);
                    Drawable pic = mappingObject2 != null ? mappingObject2.getPic() : null;
                    Drawable.ConstantState constantState = pic != null ? pic.getConstantState() : null;
                    Drawable newDrawable = constantState != null ? constantState.newDrawable() : null;
                    if (newDrawable != null) {
                        drawable2 = newDrawable.mutate();
                    }
                }
                drawable2 = null;
            } else {
                drawable2 = null;
                str17 = null;
                i8 = 0;
                i9 = 0;
                z5 = false;
                i10 = 0;
                i11 = 0;
                i12 = 0;
                z6 = false;
                i13 = 0;
            }
            boolean basic_output_enable = ((j & 524305) == 0 || afgParam == null) ? false : afgParam.getBasic_output_enable();
            if ((j & 525313) != 0) {
                drawable3 = drawable2;
                z7 = basic_output_enable;
                str18 = UnitFormat.newBuilder().convert(afgParam != null ? afgParam.getBasic_squ_duty() : 0, ServiceEnum.Unit.Unit_percent);
            } else {
                drawable3 = drawable2;
                z7 = basic_output_enable;
                str18 = null;
            }
            if ((j & 532481) != 0) {
                str19 = ViewUtil.getDiskUIPathName(afgParam != null ? afgParam.getWave_path() : null);
            } else {
                str19 = null;
            }
            if ((j & 526337) != 0) {
                str20 = str18;
                str21 = str19;
                str22 = UnitFormat.newBuilder().convert(afgParam != null ? afgParam.getBasic_SYMM() : 0, ServiceEnum.Unit.Unit_percent);
            } else {
                str20 = str18;
                str21 = str19;
                str22 = null;
            }
            if ((j & 524801) != 0) {
                str23 = str22;
                str24 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(afgParam != null ? afgParam.getBasic_amp() : 0L, ServiceEnum.Unit.Unit_V);
            } else {
                str23 = str22;
                str24 = null;
            }
            if ((j & 524353) != 0) {
                str25 = str24;
                str26 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(afgParam != null ? afgParam.getBasic_riseedge() : 0L, ServiceEnum.Unit.Unit_s);
            } else {
                str25 = str24;
                str26 = null;
            }
            if ((j & 528385) != 0) {
                str27 = str26;
                str28 = UnitFormat.newBuilder().convert(afgParam != null ? afgParam.getBasic_pul_duty() : 0, ServiceEnum.Unit.Unit_percent);
            } else {
                str27 = str26;
                str28 = null;
            }
            if ((j & 540673) != 0) {
                str10 = str28;
                str29 = UnitFormat.newBuilder(UnitFormat.SI.MILLI).convert(afgParam != null ? afgParam.getBasic_phase() : 0, ServiceEnum.Unit.Unit_degree);
            } else {
                str10 = str28;
                str29 = null;
            }
            if ((j & 524417) != 0) {
                str30 = str29;
                str31 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(afgParam != null ? afgParam.getBasic_falledge() : 0L, ServiceEnum.Unit.Unit_s);
            } else {
                str30 = str29;
                str31 = null;
            }
            int i15 = ((j & 524545) > 0L ? 1 : ((j & 524545) == 0L ? 0 : -1));
            if (i15 != 0) {
                j3 = afgParam != null ? afgParam.getBasic_freq() : 0L;
                z8 = j3 >= 1000000;
                if (i15 != 0) {
                    j = z8 ? j | 536870912 : j | 268435456;
                }
            } else {
                z8 = false;
                j3 = 0;
            }
            if ((j & 557057) != 0) {
                if (afgParam != null) {
                    long j6 = j;
                    j5 = afgParam.getBasic_offset();
                    j4 = j6;
                } else {
                    j4 = j;
                    j5 = 0;
                }
                str = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j5, ServiceEnum.Unit.Unit_V);
                str3 = str20;
                j = j4;
            } else {
                str = null;
                str3 = str20;
            }
            str8 = str31;
            str2 = str25;
            z4 = z8;
            z2 = z7;
            str7 = str27;
            str9 = str23;
            drawable = drawable3;
            z = z5;
            i3 = i11;
            i4 = i10;
            str5 = str21;
            z3 = z6;
            i6 = i8;
            i = i13;
            str6 = str17;
            j2 = j3;
            str4 = str30;
            int i16 = i12;
            i5 = i9;
            i2 = i16;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            drawable = null;
            str9 = null;
            str10 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            j2 = 0;
        }
        if ((j & 268435456) != 0) {
            str11 = str4;
            str12 = str5;
            str13 = UnitFormat.newBuilder("0", UnitFormat.SI.MICRO).convert(j2) + ServiceEnum.Unit.Unit_hz.value2;
        } else {
            str11 = str4;
            str12 = str5;
            str13 = null;
        }
        int i17 = ((j & 655395) > 0L ? 1 : ((j & 655395) == 0L ? 0 : -1));
        if (i17 != 0) {
            if (!z3) {
                z = false;
            }
            if (i17 != 0) {
                j |= z ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            i7 = z ? 0 : 8;
        } else {
            i7 = 0;
        }
        if ((j & 536870912) != 0) {
            str15 = str13;
            str14 = str3;
            str16 = ViewUtil.subNumber(UnitFormat.newBuilder("0.000", UnitFormat.SI.MICRO).convert(j2) + ServiceEnum.Unit.Unit_hz.value2, 7);
        } else {
            str14 = str3;
            str15 = str13;
            str16 = null;
        }
        int i18 = ((j & 524545) > 0L ? 1 : ((j & 524545) == 0L ? 0 : -1));
        String str32 = i18 != 0 ? z4 ? str16 : str15 : null;
        if ((j & 655395) != 0) {
            this.basicAmpEdit.setVisibility(i);
            this.basicAmpText.setVisibility(i);
            this.basicBasicPathText.setVisibility(i6);
            this.basicBasicWidthText.setVisibility(i3);
            this.basicDutycycleEdit.setVisibility(i5);
            this.basicDutycycleText.setVisibility(i5);
            this.basicPathEdit.setVisibility(i6);
            this.basicPhaseEdit.setVisibility(i7);
            this.basicPhaseText.setVisibility(i7);
            this.basicSymmetryEdit.setVisibility(i2);
            this.basicSymmetryText.setVisibility(i2);
            this.basicWidthEdit.setVisibility(i3);
            this.declineText.setVisibility(i4);
            this.fraguencyText.setVisibility(i7);
            this.labelDeclineText.setVisibility(i4);
            this.labelEditText.setVisibility(i7);
            this.labelRiseedgeText.setVisibility(i4);
            this.loadBtn.setVisibility(i6);
            this.riseText.setVisibility(i4);
        }
        if ((j & 524801) != 0) {
            TextViewBindingAdapter.setText(this.basicAmpEdit, str2);
        }
        if ((557057 & j) != 0) {
            TextViewBindingAdapter.setText(this.basicDeviationEdit, str);
        }
        if ((j & 525313) != 0) {
            TextViewBindingAdapter.setText(this.basicDutycycleEdit, str14);
        }
        if ((j & 532481) != 0) {
            TextViewBindingAdapter.setText(this.basicPathEdit, str12);
        }
        if ((540673 & j) != 0) {
            TextViewBindingAdapter.setText(this.basicPhaseEdit, str11);
        }
        if ((j & 526337) != 0) {
            TextViewBindingAdapter.setText(this.basicSymmetryEdit, str9);
        }
        if ((528385 & j) != 0) {
            TextViewBindingAdapter.setText(this.basicWidthEdit, str10);
        }
        if ((j & 786469) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.iconAfg, drawable);
        }
        if ((524417 & j) != 0) {
            TextViewBindingAdapter.setText(this.labelDeclineText, str8);
        }
        if (i18 != 0) {
            TextViewBindingAdapter.setText(this.labelEditText, str32);
        }
        if ((524353 & j) != 0) {
            TextViewBindingAdapter.setText(this.labelRiseedgeText, str7);
        }
        if ((j & 524305) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.labelSwitch, z2);
        }
        if ((j & 589859) != 0) {
            TextViewBindingAdapter.setText(this.sourceTypeSpinner, str6);
        }
    }
}
