package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.SearchParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
/* loaded from: classes2.dex */
public class AdapterSearchTriggerPulseBindingImpl extends AdapterSearchTriggerPulseBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.trigger_slope_layout, 17);
        sViewsWithIds.put(R.id.trigger_noise, 18);
        sViewsWithIds.put(R.id.view, 19);
        sViewsWithIds.put(R.id.view2, 20);
    }

    public AdapterSearchTriggerPulseBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, sIncludes, sViewsWithIds));
    }

    private AdapterSearchTriggerPulseBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (ImageView) objArr[12], (RadioButton) objArr[15], (RadioButton) objArr[14], (TextView) objArr[10], (EditText) objArr[11], (TextView) objArr[8], (RadioButton) objArr[16], (RadioButton) objArr[4], (RadioButton) objArr[3], (EditText) objArr[7], (View) objArr[18], (TextView) objArr[2], (TextView) objArr[13], (ConstraintLayout) objArr[17], (TextView) objArr[5], (TextView) objArr[1], (TextView) objArr[6], (EditText) objArr[9], (View) objArr[19], (View) objArr[20]);
        this.mDirtyFlags = -1L;
        this.imageView2.setTag(null);
        this.lessMore.setTag(null);
        this.lessThan.setTag(null);
        this.lowerLimit.setTag(null);
        this.lowerLimitEditText.setTag(null);
        this.maxLimit.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.moreThan.setTag(null);
        this.polarityN.setTag(null);
        this.polarityP.setTag(null);
        this.threEditText.setTag(null);
        this.triggerPolarityLabel.setTag(null);
        this.triggerPulseLabel.setTag(null);
        this.triggerSource.setTag(null);
        this.triggerSourceLabel.setTag(null);
        this.upperLimit.setTag(null);
        this.upperLimitEditText.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
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
        if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (643 == i) {
            setPolarityNegativeMapping((MappingObject) obj);
        } else if (644 == i) {
            setPolarityPositiveMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((SearchParam) obj);
        } else if (916 != i) {
            return false;
        } else {
            setSweepAutoMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterSearchTriggerPulseBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterSearchTriggerPulseBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterSearchTriggerPulseBinding
    public void setPolarityNegativeMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mPolarityNegativeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(643);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterSearchTriggerPulseBinding
    public void setPolarityPositiveMapping(MappingObject mappingObject) {
        updateRegistration(3, mappingObject);
        this.mPolarityPositiveMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(644);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterSearchTriggerPulseBinding
    public void setParam(SearchParam searchParam) {
        updateRegistration(4, searchParam);
        this.mParam = searchParam;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterSearchTriggerPulseBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        this.mSweepAutoMapping = mappingObject;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeSweepSingleMapping((MappingObject) obj, i2);
            case 1:
                return onChangeSweepNormalMapping((MappingObject) obj, i2);
            case 2:
                return onChangePolarityNegativeMapping((MappingObject) obj, i2);
            case 3:
                return onChangePolarityPositiveMapping((MappingObject) obj, i2);
            case 4:
                return onChangeParam((SearchParam) obj, i2);
            case 5:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
            case 6:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgSearchPulseSourceParamPulseSrcValue1((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangePolarityNegativeMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangePolarityPositiveMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(SearchParam searchParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 271) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 681) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 682) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 921) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 645) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 679) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 678) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepAutoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgSearchPulseSourceParamPulseSrcValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        float f;
        Drawable drawable;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i2;
        String str6;
        int i3;
        String str7;
        String str8;
        int i4;
        String str9;
        String str10;
        boolean z7;
        float f2;
        boolean z8;
        boolean z9;
        Drawable drawable2;
        SearchParam searchParam;
        String str11;
        Long l;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mPolarityNegativeMapping;
        MappingObject mappingObject2 = this.mPolarityPositiveMapping;
        SearchParam searchParam2 = this.mParam;
        String str12 = ((j & 131204) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        String str13 = ((j & 131336) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        if ((261712 & j) != 0) {
            if ((j & 198736) != 0) {
                ServiceEnum.Chan pulseSrc = searchParam2 != null ? searchParam2.getPulseSrc() : null;
                MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_search_pulse_source, pulseSrc != null ? pulseSrc.value1 : 0);
                updateRegistration(6, mappingObject3);
                str9 = mappingObject3 != null ? mappingObject3.getStr() : null;
                i4 = (j & 133136) != 0 ? ColorUtil.getColor(getRoot().getContext(), pulseSrc) : 0;
            } else {
                i4 = 0;
                str9 = null;
            }
            if ((j & 163856) != 0) {
                str10 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(ViewDataBinding.safeUnbox(searchParam2 != null ? searchParam2.getPulseLower() : null), ServiceEnum.Unit.Unit_s);
            } else {
                str10 = null;
            }
            if ((j & 135184) != 0) {
                str = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(searchParam2 != null ? searchParam2.getThre() : 0L) + ServiceEnum.Unit.Unit_V.value2;
            } else {
                str = null;
            }
            if ((j & 131600) != 0) {
                z7 = searchParam2 != null ? searchParam2.isEnable() : false;
                f2 = ContextUtil.getAlpha(z7);
            } else {
                z7 = false;
                f2 = 0.0f;
            }
            if ((j & 132112) != 0) {
                int pulsePolarty = searchParam2 != null ? searchParam2.getPulsePolarty() : 0;
                z9 = pulsePolarty == 1;
                drawable2 = ViewUtil.getPulsePic(pulsePolarty);
                z8 = pulsePolarty == 0;
            } else {
                z8 = false;
                z9 = false;
                drawable2 = null;
            }
            if ((j & 147472) != 0) {
                if (searchParam2 != null) {
                    l = searchParam2.getPulseMax();
                    searchParam = searchParam2;
                } else {
                    searchParam = searchParam2;
                    l = null;
                }
                str11 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(ViewDataBinding.safeUnbox(l), ServiceEnum.Unit.Unit_s);
            } else {
                searchParam = searchParam2;
                str11 = null;
            }
            int i5 = ((j & 139280) > 0L ? 1 : ((j & 139280) == 0L ? 0 : -1));
            if (i5 != 0) {
                ServiceEnum.EMoreThan polaritySlope = searchParam != null ? searchParam.getPolaritySlope() : null;
                boolean z10 = polaritySlope == ServiceEnum.getEMoreThanFromValue1(1);
                z3 = polaritySlope == ServiceEnum.getEMoreThanFromValue1(2);
                String str14 = str11;
                z = polaritySlope == ServiceEnum.getEMoreThanFromValue1(3);
                if (i5 != 0) {
                    j |= z10 ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                }
                if ((j & 139280) != 0) {
                    j |= z3 ? 8388608L : 4194304L;
                }
                z2 = z10;
                f = f2;
                str4 = str14;
                i = i4;
                z6 = z8;
                z4 = z9;
                z5 = z7;
            } else {
                String str15 = str11;
                z6 = z8;
                f = f2;
                z = false;
                z2 = false;
                z3 = false;
                str4 = str15;
                i = i4;
                z5 = z7;
                z4 = z9;
            }
            str3 = str9;
            str2 = str10;
            drawable = drawable2;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            i = 0;
            f = 0.0f;
            drawable = null;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
        }
        int i6 = ((j & 139280) > 0L ? 1 : ((j & 139280) == 0L ? 0 : -1));
        if (i6 != 0) {
            boolean z11 = z2 ? true : z;
            boolean z12 = z3 ? true : z;
            if (i6 != 0) {
                j |= z11 ? 33554432L : 16777216L;
            }
            if ((j & 139280) != 0) {
                j |= z12 ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            int i7 = z11 ? 0 : 8;
            str5 = str;
            i2 = z12 ? 0 : 4;
            str6 = str3;
            i3 = i7;
        } else {
            str5 = str;
            i2 = 0;
            str6 = str3;
            i3 = 0;
        }
        if ((j & 131600) != 0) {
            str8 = str13;
            str7 = str12;
            if (getBuildSdkInt() >= 11) {
                this.imageView2.setAlpha(f);
                this.lessMore.setAlpha(f);
                this.lessThan.setAlpha(f);
                this.lowerLimit.setAlpha(f);
                this.lowerLimitEditText.setAlpha(f);
                this.maxLimit.setAlpha(f);
                this.moreThan.setAlpha(f);
                this.polarityN.setAlpha(f);
                this.polarityP.setAlpha(f);
                this.threEditText.setAlpha(f);
                this.triggerPolarityLabel.setAlpha(f);
                this.triggerPulseLabel.setAlpha(f);
                this.triggerSource.setAlpha(f);
                this.triggerSourceLabel.setAlpha(f);
                this.upperLimit.setAlpha(f);
                this.upperLimitEditText.setAlpha(f);
            }
            this.lessMore.setEnabled(z5);
            this.lessThan.setEnabled(z5);
            this.lowerLimit.setEnabled(z5);
            this.lowerLimitEditText.setEnabled(z5);
            this.maxLimit.setEnabled(z5);
            this.moreThan.setEnabled(z5);
            this.polarityN.setEnabled(z5);
            this.polarityP.setEnabled(z5);
            this.triggerPolarityLabel.setEnabled(z5);
            this.triggerPulseLabel.setEnabled(z5);
            this.triggerSource.setEnabled(z5);
            this.triggerSourceLabel.setEnabled(z5);
            this.upperLimitEditText.setEnabled(z5);
        } else {
            str7 = str12;
            str8 = str13;
        }
        if ((j & 132112) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.imageView2, drawable);
            CompoundButtonBindingAdapter.setChecked(this.polarityN, z4);
            CompoundButtonBindingAdapter.setChecked(this.polarityP, z6);
        }
        if ((j & 139280) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.lessMore, z);
            CompoundButtonBindingAdapter.setChecked(this.lessThan, z3);
            this.lowerLimit.setVisibility(i3);
            this.lowerLimitEditText.setVisibility(i3);
            this.maxLimit.setVisibility(i2);
            CompoundButtonBindingAdapter.setChecked(this.moreThan, z2);
            this.upperLimitEditText.setVisibility(i2);
        }
        if ((j & 163856) != 0) {
            TextViewBindingAdapter.setText(this.lowerLimitEditText, str2);
        }
        if ((131204 & j) != 0) {
            TextViewBindingAdapter.setText(this.polarityN, str7);
        }
        if ((131336 & j) != 0) {
            TextViewBindingAdapter.setText(this.polarityP, str8);
        }
        if ((j & 135184) != 0) {
            TextViewBindingAdapter.setText(this.threEditText, str5);
        }
        if ((j & 198736) != 0) {
            TextViewBindingAdapter.setText(this.triggerSource, str6);
        }
        if ((j & 133136) != 0) {
            this.triggerSource.setTextColor(i);
        }
        if ((j & 147472) != 0) {
            TextViewBindingAdapter.setText(this.upperLimitEditText, str4);
        }
    }
}
