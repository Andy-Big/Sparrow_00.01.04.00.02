package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.RadioGroupBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.BaseProperty;
import com.rigol.scope.data.EyeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;

/* loaded from: classes2.dex */
public class AdapterEyeConstantBindingImpl extends AdapterEyeConstantBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.eye_constant_layout, 7);
        sViewsWithIds.put(R.id.left_guideline, 8);
        sViewsWithIds.put(R.id.right_guideline, 9);
        sViewsWithIds.put(R.id.eye_type_label, 10);
    }

    public AdapterEyeConstantBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private AdapterEyeConstantBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (ConstraintLayout) objArr[7], (TextView) objArr[6], (TextView) objArr[1], (RadioButton) objArr[3], (TextView) objArr[10], (RadioButton) objArr[5], (RadioGroup) objArr[2], (RadioButton) objArr[4], (Guideline) objArr[8], (Guideline) objArr[9]);
        this.mDirtyFlags = -1L;
        this.eyeDataRateLabel.setTag(null);
        this.eyeDataRateValue.setTag(null);
        this.eyeTypeAtuoRadioButton.setTag(null);
        this.eyeTypeManualRadioButton.setTag(null);
        this.eyeTypeRadioGroup.setTag(null);
        this.eyeTypeSemiautoRadioButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
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
        if (568 == i) {
            setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) obj);
        } else if (594 == i) {
            setParam((EyeParam) obj);
        } else if (517 == i) {
            setManualMapping((MappingObject) obj);
        } else if (569 == i) {
            setOnClickListener((View.OnClickListener) obj);
        } else if (57 == i) {
            setAtuoMapping((MappingObject) obj);
        } else if (796 != i) {
            return false;
        } else {
            setSemiautoMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterEyeConstantBinding
    public void setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnCheckedChangeListener = onCheckedChangeListener;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(568);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterEyeConstantBinding
    public void setParam(EyeParam eyeParam) {
        updateRegistration(1, eyeParam);
        this.mParam = eyeParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterEyeConstantBinding
    public void setManualMapping(MappingObject mappingObject) {
        updateRegistration(3, mappingObject);
        this.mManualMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(517);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterEyeConstantBinding
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(569);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterEyeConstantBinding
    public void setAtuoMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mAtuoMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(57);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterEyeConstantBinding
    public void setSemiautoMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mSemiautoMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(796);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return false;
                            }
                            return onChangeSemiautoMapping((MappingObject) obj, i2);
                        }
                        return onChangeAtuoMapping((MappingObject) obj, i2);
                    }
                    return onChangeManualMapping((MappingObject) obj, i2);
                }
                return onChangeParamType((BaseProperty) obj, i2);
            }
            return onChangeParam((EyeParam) obj, i2);
        }
        return onChangeParamDataRate((BaseProperty) obj, i2);
    }

    private boolean onChangeParamDataRate(BaseProperty<Long> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(EyeParam eyeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParamType(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeManualMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
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

    private boolean onChangeAtuoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSemiautoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    /* JADX WARN: Removed duplicated region for block: B:62:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        AdapterEyeConstantBindingImpl adapterEyeConstantBindingImpl;
        String str;
        float f;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        int i2;
        int i3;
        int i4;
        String str2;
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
        RadioGroup.OnCheckedChangeListener onCheckedChangeListener = this.mOnCheckedChangeListener;
        EyeParam eyeParam = this.mParam;
        MappingObject mappingObject = this.mManualMapping;
        View.OnClickListener onClickListener = this.mOnClickListener;
        MappingObject mappingObject2 = this.mAtuoMapping;
        MappingObject mappingObject3 = this.mSemiautoMapping;
        int i5 = ((8256 & j) > 0L ? 1 : ((8256 & j) == 0L ? 0 : -1));
        if ((8967 & j) != 0) {
            if ((j & 8451) != 0) {
                BaseProperty<Long> dataRate = eyeParam != null ? eyeParam.getDataRate() : null;
                updateRegistration(0, dataRate);
                str2 = UnitFormat.newBuilder(" 0.000", UnitFormat.SI.NONE).convert(ViewDataBinding.safeUnbox(dataRate != null ? dataRate.getValue() : null), ServiceEnum.Unit.Unit_bps);
            } else {
                str2 = null;
            }
            if ((j & 8710) != 0) {
                BaseProperty<Integer> type = eyeParam != null ? eyeParam.getType() : null;
                adapterEyeConstantBindingImpl = this;
                adapterEyeConstantBindingImpl.updateRegistration(2, type);
                int safeUnbox = ViewDataBinding.safeUnbox(type != null ? type.getValue() : null);
                z4 = safeUnbox == 0;
                boolean z5 = safeUnbox == 1;
                boolean z6 = safeUnbox != 0;
                boolean z7 = safeUnbox == 2;
                str = str2;
                f = ContextUtil.getAlpha(z6);
                z = z5;
                z3 = z7;
                z2 = z6;
                i = ((j & 9224) > 0L ? 1 : ((j & 9224) == 0L ? 0 : -1));
                String str3 = (i != 0 || mappingObject == null) ? null : mappingObject.getStr();
                i2 = ((j & 8320) > 0L ? 1 : ((j & 8320) == 0L ? 0 : -1));
                i3 = ((j & 10256) > 0L ? 1 : ((j & 10256) == 0L ? 0 : -1));
                String str4 = (i3 != 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
                i4 = ((j & 12320) > 0L ? 1 : ((j & 12320) == 0L ? 0 : -1));
                String str5 = (i4 != 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
                if ((8710 & j) != 0) {
                    if (getBuildSdkInt() >= 11) {
                        adapterEyeConstantBindingImpl.eyeDataRateLabel.setAlpha(f);
                        adapterEyeConstantBindingImpl.eyeDataRateValue.setAlpha(f);
                    }
                    adapterEyeConstantBindingImpl.eyeDataRateValue.setEnabled(z2);
                    CompoundButtonBindingAdapter.setChecked(adapterEyeConstantBindingImpl.eyeTypeAtuoRadioButton, z4);
                    CompoundButtonBindingAdapter.setChecked(adapterEyeConstantBindingImpl.eyeTypeManualRadioButton, z3);
                    CompoundButtonBindingAdapter.setChecked(adapterEyeConstantBindingImpl.eyeTypeSemiautoRadioButton, z);
                }
                if (i2 != 0) {
                    adapterEyeConstantBindingImpl.eyeDataRateValue.setOnClickListener(onClickListener);
                }
                if ((j & 8451) != 0) {
                    TextViewBindingAdapter.setText(adapterEyeConstantBindingImpl.eyeDataRateValue, str);
                }
                if (i3 != 0) {
                    TextViewBindingAdapter.setText(adapterEyeConstantBindingImpl.eyeTypeAtuoRadioButton, str4);
                }
                if (i != 0) {
                    TextViewBindingAdapter.setText(adapterEyeConstantBindingImpl.eyeTypeManualRadioButton, str3);
                }
                if (i5 != 0) {
                    RadioGroupBindingAdapter.setListeners(adapterEyeConstantBindingImpl.eyeTypeRadioGroup, onCheckedChangeListener, null);
                }
                if (i4 == 0) {
                    TextViewBindingAdapter.setText(adapterEyeConstantBindingImpl.eyeTypeSemiautoRadioButton, str5);
                    return;
                }
                return;
            }
            adapterEyeConstantBindingImpl = this;
            str = str2;
        } else {
            adapterEyeConstantBindingImpl = this;
            str = null;
        }
        f = 0.0f;
        z = false;
        z2 = false;
        z3 = false;
        z4 = false;
        i = ((j & 9224) > 0L ? 1 : ((j & 9224) == 0L ? 0 : -1));
        if (i != 0) {
        }
        i2 = ((j & 8320) > 0L ? 1 : ((j & 8320) == 0L ? 0 : -1));
        i3 = ((j & 10256) > 0L ? 1 : ((j & 10256) == 0L ? 0 : -1));
        if (i3 != 0) {
        }
        i4 = ((j & 12320) > 0L ? 1 : ((j & 12320) == 0L ? 0 : -1));
        if (i4 != 0) {
        }
        if ((8710 & j) != 0) {
        }
        if (i2 != 0) {
        }
        if ((j & 8451) != 0) {
        }
        if (i3 != 0) {
        }
        if (i != 0) {
        }
        if (i5 != 0) {
        }
        if (i4 == 0) {
        }
    }
}
