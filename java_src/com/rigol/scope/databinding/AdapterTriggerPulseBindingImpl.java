package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.vertical.VerticalSeekBar;
import com.rigol.scope.views.vertical.VerticalSeekBarWrapper;

/* loaded from: classes2.dex */
public class AdapterTriggerPulseBindingImpl extends AdapterTriggerPulseBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 16);
        sViewsWithIds.put(R.id.guideline_center, 17);
        sViewsWithIds.put(R.id.guideline_right, 18);
        sViewsWithIds.put(R.id.view_top, 19);
        sViewsWithIds.put(R.id.view_1, 20);
        sViewsWithIds.put(R.id.trigger_noise, 21);
        sViewsWithIds.put(R.id.trigger_source_label, 22);
        sViewsWithIds.put(R.id.trigger_polarity_label, 23);
        sViewsWithIds.put(R.id.trigger_holdoff_label, 24);
        sViewsWithIds.put(R.id.trigger_noise_label, 25);
        sViewsWithIds.put(R.id.trigger_level, 26);
        sViewsWithIds.put(R.id.verticalSeekBarWrapper2, 27);
        sViewsWithIds.put(R.id.button_level, 28);
        sViewsWithIds.put(R.id.trigger_pulse_label, 29);
    }

    public AdapterTriggerPulseBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 30, sIncludes, sViewsWithIds));
    }

    private AdapterTriggerPulseBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (Button) objArr[28], (Guideline) objArr[17], (Guideline) objArr[16], (Guideline) objArr[18], (ImageView) objArr[10], (RadioButton) objArr[15], (RadioButton) objArr[14], (TextView) objArr[8], (EditText) objArr[9], (RadioButton) objArr[13], (RadioButton) objArr[2], (RadioButton) objArr[1], (EditText) objArr[4], (TextView) objArr[24], (TextView) objArr[26], (EditText) objArr[12], (VerticalSeekBar) objArr[11], (View) objArr[21], (TextView) objArr[25], (SwitchButton) objArr[5], (TextView) objArr[23], (TextView) objArr[29], (TextView) objArr[3], (TextView) objArr[22], (TextView) objArr[6], (EditText) objArr[7], (VerticalSeekBarWrapper) objArr[27], (View) objArr[20], (View) objArr[19]);
        this.mDirtyFlags = -1L;
        this.imageView2.setTag(null);
        this.lessMore.setTag(null);
        this.lessThan.setTag(null);
        this.lowerLimit.setTag(null);
        this.lowerLimitValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.moreThan.setTag(null);
        this.polarityN.setTag(null);
        this.polarityP.setTag(null);
        this.triggerHoldoff.setTag(null);
        this.triggerLevelValue.setTag(null);
        this.triggerLevelView.setTag(null);
        this.triggerNoiseSwitch.setTag(null);
        this.triggerSource.setTag(null);
        this.upperLimit.setTag(null);
        this.upperLimitValue.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
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
            setParam((TriggerParam) obj);
        } else if (916 != i) {
            return false;
        } else {
            setSweepAutoMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerPulseBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        this.mSweepSingleMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerPulseBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        this.mSweepNormalMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerPulseBinding
    public void setPolarityNegativeMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mPolarityNegativeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(643);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerPulseBinding
    public void setPolarityPositiveMapping(MappingObject mappingObject) {
        updateRegistration(3, mappingObject);
        this.mPolarityPositiveMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(644);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerPulseBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(5, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterTriggerPulseBinding
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
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1((MappingObject) obj, i2);
            case 5:
                return onChangeParam((TriggerParam) obj, i2);
            case 6:
                return onChangeSweepAutoMapping((MappingObject) obj, i2);
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerSourceLaParamChanValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 642) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 152) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 377) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 448) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 256) {
            synchronized (this) {
                this.mDirtyFlags |= 540672;
            }
            return true;
        } else if (i == 995) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 511) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 671) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 484) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepAutoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0206  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i2;
        int i3;
        boolean z6;
        int i4;
        String str;
        String str2;
        String str3;
        Drawable drawable;
        String str4;
        String str5;
        String str6;
        boolean z7;
        boolean z8;
        String str7;
        boolean z9;
        boolean z10;
        Drawable drawable2;
        boolean z11;
        long j2;
        int i5;
        String str8;
        String str9;
        int i6;
        String str10;
        String str11;
        boolean z12;
        boolean z13;
        int i7;
        int i8;
        long j3;
        long j4;
        int i9;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mPolarityNegativeMapping;
        MappingObject mappingObject2 = this.mPolarityPositiveMapping;
        TriggerParam triggerParam = this.mParam;
        String str12 = ((j & 1048708) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        String str13 = ((j & 1048840) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        if ((2096688 & j) != 0) {
            if ((j & 1052704) != 0) {
                str3 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(triggerParam != null ? triggerParam.getHoldOff() : 0L, ServiceEnum.Unit.Unit_s);
            } else {
                str3 = null;
            }
            if ((j & 1572896) != 0) {
                ServiceEnum.EMoreThan eMoreThan = triggerParam != null ? triggerParam.getEMoreThan() : null;
                z4 = eMoreThan == ServiceEnum.EMoreThan.Trigger_When_Lessthan;
                z8 = eMoreThan == ServiceEnum.EMoreThan.Trigger_When_Morethan;
                z7 = eMoreThan == ServiceEnum.EMoreThan.Trigger_When_MoreLess;
            } else {
                z7 = false;
                z8 = false;
                z4 = false;
            }
            int progress = ((j & 1179680) == 0 || triggerParam == null) ? 0 : triggerParam.getProgress();
            if ((j & 1081376) != 0) {
                str7 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(triggerParam != null ? triggerParam.getUperLimit() : 0L, ServiceEnum.Unit.Unit_s);
            } else {
                str7 = null;
            }
            if ((j & 1049632) != 0) {
                ServiceEnum.TriggerPulsePolarity polarity = triggerParam != null ? triggerParam.getPolarity() : null;
                z10 = polarity == ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive;
                drawable2 = ViewUtil.getTriggerPulsePolarityPic(polarity);
                z9 = polarity == ServiceEnum.TriggerPulsePolarity.Trigger_pulse_negative;
            } else {
                z9 = false;
                z10 = false;
                drawable2 = null;
            }
            String str14 = str7;
            if ((j & 1051184) != 0) {
                ServiceEnum.Chan chan = triggerParam != null ? triggerParam.getChan() : null;
                if (chan != null) {
                    i9 = chan.value1;
                    z11 = z9;
                } else {
                    z11 = z9;
                    i9 = 0;
                }
                MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_trigger_source_la, i9);
                updateRegistration(4, mappingObject3);
                str8 = mappingObject3 != null ? mappingObject3.getStr() : null;
                j2 = 0;
                i5 = (j & 1050656) != 0 ? ColorUtil.getColor(getRoot().getContext(), chan) : 0;
            } else {
                z11 = z9;
                j2 = 0;
                i5 = 0;
                str8 = null;
            }
            if ((j & 1310752) != j2) {
                if (triggerParam != null) {
                    str9 = str8;
                    i6 = i5;
                    j4 = triggerParam.getLevel();
                } else {
                    str9 = str8;
                    i6 = i5;
                    j4 = 0;
                }
                if (triggerParam != null) {
                    str10 = triggerParam.getTriggerLevelStr(j4);
                    boolean isNoise = ((j & 1056800) != 0 || triggerParam == null) ? false : triggerParam.getIsNoise();
                    if ((j & 1114144) == 0) {
                        if (triggerParam != null) {
                            str11 = str10;
                            z12 = isNoise;
                            j3 = triggerParam.getLowerLimit();
                        } else {
                            str11 = str10;
                            z12 = isNoise;
                            j3 = 0;
                        }
                        z13 = z7;
                        i7 = progress;
                        str = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j3, ServiceEnum.Unit.Unit_s);
                    } else {
                        str11 = str10;
                        z12 = isNoise;
                        z13 = z7;
                        i7 = progress;
                        str = null;
                    }
                    i8 = ((j & 1064992) > 0L ? 1 : ((j & 1064992) == 0L ? 0 : -1));
                    if (i8 == 0) {
                        ServiceEnum.EMoreThan eMoreThan2 = triggerParam != null ? triggerParam.getEMoreThan() : null;
                        boolean z14 = eMoreThan2 == ServiceEnum.EMoreThan.Trigger_When_Lessthan;
                        boolean z15 = eMoreThan2 == ServiceEnum.EMoreThan.Trigger_When_Morethan;
                        if (i8 != 0) {
                            j |= z14 ? 4194304L : PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                        }
                        if ((j & 1064992) != 0) {
                            j |= z15 ? 16777216L : 8388608L;
                        }
                        i = z14 ? 4 : 0;
                        z2 = z10;
                        drawable = drawable2;
                        str5 = str9;
                        i2 = z15 ? 4 : 0;
                    } else {
                        z2 = z10;
                        drawable = drawable2;
                        str5 = str9;
                        i = 0;
                        i2 = 0;
                    }
                    str4 = str14;
                    i4 = i6;
                    z = z11;
                    str2 = str11;
                    z6 = z12;
                    i3 = i7;
                    z5 = z8;
                    z3 = z13;
                }
            } else {
                str9 = str8;
                i6 = i5;
            }
            str10 = null;
            if ((j & 1056800) != 0) {
            }
            if ((j & 1114144) == 0) {
            }
            i8 = ((j & 1064992) > 0L ? 1 : ((j & 1064992) == 0L ? 0 : -1));
            if (i8 == 0) {
            }
            str4 = str14;
            i4 = i6;
            z = z11;
            str2 = str11;
            z6 = z12;
            i3 = i7;
            z5 = z8;
            z3 = z13;
        } else {
            i = 0;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            i2 = 0;
            i3 = 0;
            z6 = false;
            i4 = 0;
            str = null;
            str2 = null;
            str3 = null;
            drawable = null;
            str4 = null;
            str5 = null;
        }
        if ((j & 1049632) != 0) {
            str6 = str2;
            ImageViewBindingAdapter.setImageDrawable(this.imageView2, drawable);
            CompoundButtonBindingAdapter.setChecked(this.polarityN, z);
            CompoundButtonBindingAdapter.setChecked(this.polarityP, z2);
        } else {
            str6 = str2;
        }
        if ((j & 1572896) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.lessMore, z3);
            CompoundButtonBindingAdapter.setChecked(this.lessThan, z4);
            CompoundButtonBindingAdapter.setChecked(this.moreThan, z5);
        }
        if ((j & 1064992) != 0) {
            this.lowerLimit.setVisibility(i);
            this.lowerLimitValue.setVisibility(i);
            this.upperLimit.setVisibility(i2);
            this.upperLimitValue.setVisibility(i2);
        }
        if ((j & 1114144) != 0) {
            TextViewBindingAdapter.setText(this.lowerLimitValue, str);
        }
        if ((1048708 & j) != 0) {
            TextViewBindingAdapter.setText(this.polarityN, str12);
        }
        if ((1048840 & j) != 0) {
            TextViewBindingAdapter.setText(this.polarityP, str13);
        }
        if ((j & 1052704) != 0) {
            TextViewBindingAdapter.setText(this.triggerHoldoff, str3);
        }
        if ((j & 1310752) != 0) {
            TextViewBindingAdapter.setText(this.triggerLevelValue, str6);
        }
        if ((j & 1179680) != 0) {
            SeekBarBindingAdapter.setProgress(this.triggerLevelView, i3);
        }
        if ((j & 1056800) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.triggerNoiseSwitch, z6);
        }
        if ((j & 1051184) != 0) {
            TextViewBindingAdapter.setText(this.triggerSource, str5);
        }
        if ((1050656 & j) != 0) {
            this.triggerSource.setTextColor(i4);
        }
        if ((j & 1081376) != 0) {
            TextViewBindingAdapter.setText(this.upperLimitValue, str4);
        }
    }
}
