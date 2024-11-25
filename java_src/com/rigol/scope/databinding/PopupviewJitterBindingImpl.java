package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.JitterParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class PopupviewJitterBindingImpl extends PopupviewJitterBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.jitter_divider, 19);
        sViewsWithIds.put(R.id.jitter_divider2, 20);
        sViewsWithIds.put(R.id.jitter_enabled_label, 21);
        sViewsWithIds.put(R.id.jitter_source_label, 22);
        sViewsWithIds.put(R.id.jitter_high_thres_label, 23);
        sViewsWithIds.put(R.id.jitter_mid_thres_label, 24);
        sViewsWithIds.put(R.id.jitter_low_thres_label, 25);
        sViewsWithIds.put(R.id.jitter_recoverType_label, 26);
        sViewsWithIds.put(R.id.jitter_recoverType_radioGroup, 27);
        sViewsWithIds.put(R.id.jitter_tie_slope_label, 28);
        sViewsWithIds.put(R.id.jitter_tie_slope_radioGroup, 29);
        sViewsWithIds.put(R.id.jitter_divider1, 30);
        sViewsWithIds.put(R.id.jitter_meas_en_label, 31);
        sViewsWithIds.put(R.id.jitter_persistance_label, 32);
        sViewsWithIds.put(R.id.reset_color_button, 33);
        sViewsWithIds.put(R.id.jitter_recoverType_view, 34);
        sViewsWithIds.put(R.id.jitter_smooth, 35);
    }

    public PopupviewJitterBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 36, sIncludes, sViewsWithIds));
    }

    private PopupviewJitterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (RadioButton) objArr[11], (RadioButton) objArr[6], (CheckBox) objArr[17], (View) objArr[19], (View) objArr[30], (View) objArr[20], (SwitchButton) objArr[1], (TextView) objArr[21], (RadioButton) objArr[8], (RadioButton) objArr[10], (TextView) objArr[23], (TextView) objArr[3], (CheckBox) objArr[16], (TextView) objArr[25], (TextView) objArr[5], (TextView) objArr[31], (SwitchButton) objArr[12], (TextView) objArr[24], (TextView) objArr[4], (TextView) objArr[32], (SwitchButton) objArr[13], (RadioButton) objArr[7], (TextView) objArr[26], (RadioGroup) objArr[27], (RecyclerView) objArr[34], (RadioButton) objArr[9], (TextView) objArr[35], (SwitchButton) objArr[18], (TextView) objArr[22], (TextView) objArr[2], (CheckBox) objArr[15], (TextView) objArr[28], (RadioGroup) objArr[29], (CheckBox) objArr[14], (Button) objArr[33]);
        this.mDirtyFlags = -1L;
        this.jitterBothRadioButton.setTag(null);
        this.jitterConstantRadioButton.setTag(null);
        this.jitterCurve.setTag(null);
        this.jitterEnSwitchButton.setTag(null);
        this.jitterExplicitRadioButton.setTag(null);
        this.jitterFallRadioButton.setTag(null);
        this.jitterHighThresValue.setTag(null);
        this.jitterHistogram.setTag(null);
        this.jitterLowThresValue.setTag(null);
        this.jitterMeasEnSwitchButton.setTag(null);
        this.jitterMidThresValue.setTag(null);
        this.jitterPersistanceSwitchButton.setTag(null);
        this.jitterPllRadioButton.setTag(null);
        this.jitterRiseRadioButton.setTag(null);
        this.jitterSmoothSwitchButton.setTag(null);
        this.jitterSourceValue.setTag(null);
        this.jitterSpectrum.setTag(null);
        this.jitterTrack.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1073741824L;
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
        if (1032 == i) {
            setView((View) obj);
        } else if (594 != i) {
            return false;
        } else {
            setParam((JitterParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewJitterBinding
    public void setView(View view) {
        this.mView = view;
    }

    @Override // com.rigol.scope.databinding.PopupviewJitterBinding
    public void setParam(JitterParam jitterParam) {
        updateRegistration(2, jitterParam);
        this.mParam = jitterParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterCrSelmethodInt1((MappingObject) obj, i2);
            case 1:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterTieSlopeInt1((MappingObject) obj, i2);
            case 2:
                return onChangeParam((JitterParam) obj, i2);
            case 3:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterCrSelmethodInt2((MappingObject) obj, i2);
            case 4:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterCrSelmethodInt0((MappingObject) obj, i2);
            case 5:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterTieSlopeInt2((MappingObject) obj, i2);
            case 6:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterTieSlopeInt0((MappingObject) obj, i2);
            case 7:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterSourceParamSourceValue1((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterCrSelmethodInt1(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterTieSlopeInt1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    private boolean onChangeParam(JitterParam jitterParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 272) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 858) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 373) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 536) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 510) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 710) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 933) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 739) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 621) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 943) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 871) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 375) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 87) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 856) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterCrSelmethodInt2(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterCrSelmethodInt0(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterTieSlopeInt2(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterTieSlopeInt0(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterSourceParamSourceValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
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

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        String str4;
        String str5;
        boolean z10;
        boolean z11;
        boolean z12;
        int i;
        boolean z13;
        boolean z14;
        String str6;
        boolean z15;
        String str7;
        int i2;
        String str8;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        String str9;
        boolean z21;
        String str10;
        String str11;
        boolean z22;
        boolean z23;
        boolean z24;
        int i3;
        int i4;
        int i5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        JitterParam jitterParam = this.mParam;
        String str12 = (j & 1342177280) != 0 ? ViewUtil.getMappingObject(R.array.msg_jitter_tie_slope, 0).getStr() : null;
        String str13 = (j & 1073742848) != 0 ? ViewUtil.getMappingObject(R.array.msg_jitter_tie_slope, 1).getStr() : null;
        String str14 = (j & 1073742336) != 0 ? ViewUtil.getMappingObject(R.array.msg_jitter_cr_selmethod, 1).getStr() : null;
        String str15 = (j & 1207959552) != 0 ? ViewUtil.getMappingObject(R.array.msg_jitter_tie_slope, 2).getStr() : null;
        String str16 = (j & 1140850688) != 0 ? ViewUtil.getMappingObject(R.array.msg_jitter_cr_selmethod, 0).getStr() : null;
        if ((j & 1644165252) != 0) {
            boolean isSpectrum = ((j & 1075838980) == 0 || jitterParam == null) ? false : jitterParam.isSpectrum();
            if ((j & 1073758212) != 0) {
                z15 = isSpectrum;
                str7 = UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(jitterParam != null ? jitterParam.getMidThres() : 0, ServiceEnum.Unit.Unit_percent);
            } else {
                z15 = isSpectrum;
                str7 = null;
            }
            boolean isTrack = ((j & 1074790404) == 0 || jitterParam == null) ? false : jitterParam.isTrack();
            if ((j & 1610616964) != 0) {
                ServiceEnum.Chan source = jitterParam != null ? jitterParam.getSource() : null;
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_jitter_source, source != null ? source.value1 : 0);
                updateRegistration(7, mappingObject);
                str8 = mappingObject != null ? mappingObject.getStr() : null;
                i2 = (j & 1073745924) != 0 ? ColorUtil.getColor(getRoot().getContext(), source) : 0;
            } else {
                i2 = 0;
                str8 = null;
            }
            int i6 = ((j & 1073807364) > 0L ? 1 : ((j & 1073807364) == 0L ? 0 : -1));
            if (i6 != 0) {
                int recoveryType = jitterParam != null ? jitterParam.getRecoveryType() : 0;
                z17 = recoveryType == 0;
                if (recoveryType == 1) {
                    z18 = true;
                    i5 = 2;
                } else {
                    i5 = 2;
                    z18 = false;
                }
                z16 = recoveryType == i5;
                if (i6 != 0) {
                    j |= z17 ? 4294967296L : 2147483648L;
                }
                if ((j & 1073807364) != 0) {
                    j |= z18 ? 17179869184L : 8589934592L;
                }
                if ((j & 1073807364) != 0) {
                    j |= z16 ? 68719476736L : 34359738368L;
                }
            } else {
                z16 = false;
                z17 = false;
                z18 = false;
            }
            boolean isSmooth = ((j & 1090519044) == 0 || jitterParam == null) ? false : jitterParam.isSmooth();
            boolean isBathtubCurve = ((j & 1082130436) == 0 || jitterParam == null) ? false : jitterParam.isBathtubCurve();
            if ((j & 1073774596) != 0) {
                if (jitterParam != null) {
                    z19 = z16;
                    i4 = jitterParam.getLowThres();
                } else {
                    z19 = z16;
                    i4 = 0;
                }
                z20 = isSmooth;
                str9 = str7;
                z21 = isTrack;
                str10 = UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(i4, ServiceEnum.Unit.Unit_percent);
            } else {
                z19 = z16;
                z20 = isSmooth;
                str9 = str7;
                z21 = isTrack;
                str10 = null;
            }
            boolean isEnabled = ((j & 1073743876) == 0 || jitterParam == null) ? false : jitterParam.isEnabled();
            boolean isPersistance = ((1074266116 & j) == 0 || jitterParam == null) ? false : jitterParam.isPersistance();
            if ((j & 1073872900) != 0) {
                if (jitterParam != null) {
                    i3 = jitterParam.getTieSlope();
                    str11 = str10;
                } else {
                    str11 = str10;
                    i3 = 0;
                }
                boolean z25 = i3 == ServiceEnum.ClockSlope.CLOCK_RISE.value1;
                z24 = i3 == ServiceEnum.ClockSlope.CLOCK_BOTH.value1;
                z23 = i3 == ServiceEnum.ClockSlope.CLOCK_FALL.value1;
                z22 = z25;
            } else {
                str11 = str10;
                z22 = false;
                z23 = false;
                z24 = false;
            }
            boolean isResult = ((j & 1074003972) == 0 || jitterParam == null) ? false : jitterParam.isResult();
            boolean isHistogram = ((j & 1077936132) == 0 || jitterParam == null) ? false : jitterParam.isHistogram();
            if ((j & 1073750020) != 0) {
                boolean z26 = z22;
                str3 = UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(jitterParam != null ? jitterParam.getHighThres() : 0, ServiceEnum.Unit.Unit_percent);
                str2 = str12;
                z11 = isPersistance;
                z10 = isResult;
                i = i2;
                str6 = str8;
                z13 = z15;
                z8 = z17;
                z4 = z18;
                str4 = str9;
                z12 = z20;
                z14 = z21;
                str5 = str11;
                z = isHistogram;
                z6 = z24;
                j = j;
                z7 = z26;
            } else {
                boolean z27 = z22;
                str2 = str12;
                z11 = isPersistance;
                z10 = isResult;
                i = i2;
                str6 = str8;
                z13 = z15;
                z8 = z17;
                z4 = z18;
                str4 = str9;
                z12 = z20;
                z14 = z21;
                str5 = str11;
                z = isHistogram;
                z6 = z24;
                z7 = z27;
                str3 = null;
            }
            z5 = isEnabled;
            str = str14;
            z3 = isBathtubCurve;
            z2 = z23;
            z9 = z19;
        } else {
            str = str14;
            str2 = str12;
            str3 = null;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
            z8 = false;
            z9 = false;
            str4 = null;
            str5 = null;
            z10 = false;
            z11 = false;
            z12 = false;
            i = 0;
            z13 = false;
            z14 = false;
            str6 = null;
        }
        int i7 = ((j & 1107296256) > 0L ? 1 : ((j & 1107296256) == 0L ? 0 : -1));
        String str17 = str3;
        boolean z28 = z;
        String str18 = i7 != 0 ? ViewUtil.getMappingObject(R.array.msg_jitter_cr_selmethod, 2).getStr() : null;
        if ((j & 1073872900) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.jitterBothRadioButton, z6);
            CompoundButtonBindingAdapter.setChecked(this.jitterFallRadioButton, z2);
            CompoundButtonBindingAdapter.setChecked(this.jitterRiseRadioButton, z7);
        }
        if ((j & 1207959552) != 0) {
            TextViewBindingAdapter.setText(this.jitterBothRadioButton, str15);
        }
        if ((j & 1073807364) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.jitterConstantRadioButton, z8);
            CompoundButtonBindingAdapter.setChecked(this.jitterExplicitRadioButton, z9);
            CompoundButtonBindingAdapter.setChecked(this.jitterPllRadioButton, z4);
        }
        if ((j & 1140850688) != 0) {
            TextViewBindingAdapter.setText(this.jitterConstantRadioButton, str16);
        }
        if ((j & 1082130436) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.jitterCurve, z3);
        }
        if ((j & 1073743876) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.jitterEnSwitchButton, z5);
        }
        if (i7 != 0) {
            TextViewBindingAdapter.setText(this.jitterExplicitRadioButton, str18);
        }
        if ((1073742848 & j) != 0) {
            TextViewBindingAdapter.setText(this.jitterFallRadioButton, str13);
        }
        if ((1073750020 & j) != 0) {
            TextViewBindingAdapter.setText(this.jitterHighThresValue, str17);
        }
        if ((1077936132 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.jitterHistogram, z28);
        }
        if ((j & 1073774596) != 0) {
            TextViewBindingAdapter.setText(this.jitterLowThresValue, str5);
        }
        if ((1074003972 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.jitterMeasEnSwitchButton, z10);
        }
        if ((j & 1073758212) != 0) {
            TextViewBindingAdapter.setText(this.jitterMidThresValue, str4);
        }
        if ((1074266116 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.jitterPersistanceSwitchButton, z11);
        }
        if ((j & 1073742336) != 0) {
            TextViewBindingAdapter.setText(this.jitterPllRadioButton, str);
        }
        if ((1342177280 & j) != 0) {
            TextViewBindingAdapter.setText(this.jitterRiseRadioButton, str2);
        }
        if ((j & 1090519044) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.jitterSmoothSwitchButton, z12);
        }
        if ((j & 1610616964) != 0) {
            TextViewBindingAdapter.setText(this.jitterSourceValue, str6);
        }
        if ((1073745924 & j) != 0) {
            this.jitterSourceValue.setTextColor(i);
        }
        if ((j & 1075838980) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.jitterSpectrum, z13);
        }
        if ((j & 1074790404) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.jitterTrack, z14);
        }
    }
}
