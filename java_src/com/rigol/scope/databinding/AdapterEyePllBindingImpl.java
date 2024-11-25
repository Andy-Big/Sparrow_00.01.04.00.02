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
import com.rigol.scope.utilities.UnitFormat;
/* loaded from: classes2.dex */
public class AdapterEyePllBindingImpl extends AdapterEyePllBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.eye_pll_layout, 8);
        sViewsWithIds.put(R.id.center_guideline, 9);
        sViewsWithIds.put(R.id.left_guideline, 10);
        sViewsWithIds.put(R.id.right_guideline, 11);
        sViewsWithIds.put(R.id.eye_pllOrder_label, 12);
        sViewsWithIds.put(R.id.eye_dataRate_label, 13);
        sViewsWithIds.put(R.id.eye_pllWidth_label, 14);
    }

    public AdapterEyePllBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private AdapterEyePllBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (Guideline) objArr[9], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[13], (TextView) objArr[6], (RadioButton) objArr[2], (ConstraintLayout) objArr[8], (TextView) objArr[12], (RadioGroup) objArr[1], (TextView) objArr[14], (TextView) objArr[7], (RadioButton) objArr[3], (Guideline) objArr[10], (Guideline) objArr[11]);
        this.mDirtyFlags = -1L;
        this.eyeDampFactorLabel.setTag(null);
        this.eyeDampFactorValue.setTag(null);
        this.eyeDataRateValue.setTag(null);
        this.eyeFirstOrderRadioButton.setTag(null);
        this.eyePllOrderRadioGroup.setTag(null);
        this.eyePllWidthValue.setTag(null);
        this.eyeSecondOrderRadioButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
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
        if (786 == i) {
            setSecondOrderMapping((MappingObject) obj);
        } else if (568 == i) {
            setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) obj);
        } else if (594 == i) {
            setParam((EyeParam) obj);
        } else if (569 == i) {
            setOnClickListener((View.OnClickListener) obj);
        } else if (321 != i) {
            return false;
        } else {
            setFirstOrderMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterEyePllBinding
    public void setSecondOrderMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mSecondOrderMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(786);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterEyePllBinding
    public void setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnCheckedChangeListener = onCheckedChangeListener;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(568);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterEyePllBinding
    public void setParam(EyeParam eyeParam) {
        updateRegistration(4, eyeParam);
        this.mParam = eyeParam;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterEyePllBinding
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(569);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterEyePllBinding
    public void setFirstOrderMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mFirstOrderMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(321);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeSecondOrderMapping((MappingObject) obj, i2);
            case 1:
                return onChangeParamPllOrder((BaseProperty) obj, i2);
            case 2:
                return onChangeParamDataRate((BaseProperty) obj, i2);
            case 3:
                return onChangeParamDampFactor((BaseProperty) obj, i2);
            case 4:
                return onChangeParam((EyeParam) obj, i2);
            case 5:
                return onChangeFirstOrderMapping((MappingObject) obj, i2);
            case 6:
                return onChangeParamLoopBw((BaseProperty) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeSecondOrderMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParamPllOrder(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParamDataRate(BaseProperty<Long> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParamDampFactor(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(EyeParam eyeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeFirstOrderMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    private boolean onChangeParamLoopBw(BaseProperty<Long> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r32v0, types: [com.rigol.scope.databinding.AdapterEyePllBindingImpl] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        int i;
        boolean z2;
        String str;
        String str2;
        String str3;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mSecondOrderMapping;
        RadioGroup.OnCheckedChangeListener onCheckedChangeListener = this.mOnCheckedChangeListener;
        EyeParam eyeParam = this.mParam;
        View.OnClickListener onClickListener = this.mOnClickListener;
        MappingObject mappingObject2 = this.mFirstOrderMapping;
        String str4 = ((j & 33281) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        if ((56414 & j) != 0) {
            int i2 = ((j & 33810) > 0L ? 1 : ((j & 33810) == 0L ? 0 : -1));
            if (i2 != 0) {
                BaseProperty<Integer> pllOrder = eyeParam != null ? eyeParam.getPllOrder() : null;
                updateRegistration(1, pllOrder);
                int safeUnbox = ViewDataBinding.safeUnbox(pllOrder != null ? pllOrder.getValue() : null);
                int i3 = safeUnbox == 0 ? 1 : 0;
                z2 = safeUnbox == 1;
                if (i2 != 0) {
                    j |= i3 != 0 ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                }
                if ((j & 33810) != 0) {
                    if (z2) {
                        j2 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                        j3 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    } else {
                        j2 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                        j3 = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    }
                    j = j2 | j3;
                }
                i = z2 ? 0 : 8;
                r22 = i3;
            } else {
                i = 0;
                z2 = false;
            }
            if ((j & 34836) != 0) {
                BaseProperty<Long> dataRate = eyeParam != null ? eyeParam.getDataRate() : null;
                updateRegistration(2, dataRate);
                str3 = UnitFormat.newBuilder(" 0.000", UnitFormat.SI.NONE).convert(ViewDataBinding.safeUnbox(dataRate != null ? dataRate.getValue() : null), ServiceEnum.Unit.Unit_bps);
            } else {
                str3 = null;
            }
            if ((j & 36888) != 0) {
                BaseProperty<Integer> dampFactor = eyeParam != null ? eyeParam.getDampFactor() : null;
                updateRegistration(3, dampFactor);
                str = UnitFormat.newBuilder(UnitFormat.SI.MICRO).convert(ViewDataBinding.safeUnbox(dampFactor != null ? dampFactor.getValue() : null), ServiceEnum.Unit.Unit_U);
            } else {
                str = null;
            }
            if ((j & 49232) != 0) {
                BaseProperty<Long> loopBw = eyeParam != null ? eyeParam.getLoopBw() : null;
                updateRegistration(6, loopBw);
                str2 = UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(ViewDataBinding.safeUnbox(loopBw != null ? loopBw.getValue() : null), ServiceEnum.Unit.Unit_hz);
                z = r22;
            } else {
                z = r22;
                str2 = null;
            }
        } else {
            z = false;
            i = 0;
            z2 = false;
            str = null;
            str2 = null;
            str3 = null;
        }
        int i4 = ((33024 & j) > 0L ? 1 : ((33024 & j) == 0L ? 0 : -1));
        int i5 = ((40992 & j) > 0L ? 1 : ((40992 & j) == 0L ? 0 : -1));
        String str5 = (i5 == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        if ((j & 33810) != 0) {
            this.eyeDampFactorLabel.setVisibility(i);
            this.eyeDampFactorValue.setVisibility(i);
            CompoundButtonBindingAdapter.setChecked(this.eyeFirstOrderRadioButton, z);
            CompoundButtonBindingAdapter.setChecked(this.eyeSecondOrderRadioButton, z2);
        }
        if (i4 != 0) {
            this.eyeDampFactorValue.setOnClickListener(onClickListener);
            this.eyeDataRateValue.setOnClickListener(onClickListener);
            this.eyePllWidthValue.setOnClickListener(onClickListener);
        }
        if ((j & 36888) != 0) {
            TextViewBindingAdapter.setText(this.eyeDampFactorValue, str);
        }
        if ((j & 34836) != 0) {
            TextViewBindingAdapter.setText(this.eyeDataRateValue, str3);
        }
        if (i5 != 0) {
            TextViewBindingAdapter.setText(this.eyeFirstOrderRadioButton, str5);
        }
        if ((32896 & j) != 0) {
            RadioGroupBindingAdapter.setListeners(this.eyePllOrderRadioGroup, onCheckedChangeListener, null);
        }
        if ((49232 & j) != 0) {
            TextViewBindingAdapter.setText(this.eyePllWidthValue, str2);
        }
        if ((j & 33281) != 0) {
            TextViewBindingAdapter.setText(this.eyeSecondOrderRadioButton, str4);
        }
    }
}
