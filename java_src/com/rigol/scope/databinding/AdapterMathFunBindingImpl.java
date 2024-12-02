package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import com.rigol.scope.data.MathParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.baseview.BaseEditText;

/* loaded from: classes2.dex */
public class AdapterMathFunBindingImpl extends AdapterMathFunBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.math_guideline_center, 22);
        sViewsWithIds.put(R.id.sourceA, 23);
        sViewsWithIds.put(R.id.math_dividing_line, 24);
        sViewsWithIds.put(R.id.offset, 25);
        sViewsWithIds.put(R.id.math_offset_up, 26);
        sViewsWithIds.put(R.id.math_offset_down, 27);
        sViewsWithIds.put(R.id.scale, 28);
        sViewsWithIds.put(R.id.main_scale_vertical, 29);
        sViewsWithIds.put(R.id.main_scale_nomal, 30);
        sViewsWithIds.put(R.id.invert, 31);
        sViewsWithIds.put(R.id.auto_setting_btn, 32);
        sViewsWithIds.put(R.id.label, 33);
        sViewsWithIds.put(R.id.expand, 34);
        sViewsWithIds.put(R.id.expand_radio_group, 35);
        sViewsWithIds.put(R.id.grid_type, 36);
        sViewsWithIds.put(R.id.grid_type_radio_group, 37);
    }

    public AdapterMathFunBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 38, sIncludes, sViewsWithIds));
    }

    private AdapterMathFunBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (Button) objArr[32], (TextView) objArr[6], (EditText) objArr[7], (RadioButton) objArr[18], (TextView) objArr[34], (RadioGroup) objArr[35], (RadioButton) objArr[19], (RadioButton) objArr[17], (TextView) objArr[36], (RadioGroup) objArr[37], (RadioButton) objArr[20], (TextView) objArr[31], (SwitchButton) objArr[12], (TextView) objArr[33], (BaseEditText) objArr[15], (SwitchButton) objArr[16], (ImageButton) objArr[30], (ImageButton) objArr[29], (View) objArr[24], (Guideline) objArr[22], (ImageButton) objArr[27], (ImageButton) objArr[26], (RadioButton) objArr[21], (TextView) objArr[25], (EditText) objArr[2], (TextView) objArr[4], (EditText) objArr[5], (TextView) objArr[10], (EditText) objArr[11], (TextView) objArr[28], (EditText) objArr[3], (TextView) objArr[8], (EditText) objArr[9], (TextView) objArr[23], (TextView) objArr[1], (TextView) objArr[13], (SwitchButton) objArr[14]);
        this.mDirtyFlags = -1L;
        this.bias.setTag(null);
        this.biasEditText.setTag(null);
        this.centerRadioButton.setTag(null);
        this.fullRadioButton.setTag(null);
        this.gndRadioButton.setTag(null);
        this.halfRadioButton.setTag(null);
        this.invertSwitch.setTag(null);
        this.labelEditText.setTag(null);
        this.labelSwitch.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.noneRadioButton.setTag(null);
        this.offsetEditText.setTag(null);
        this.paramA.setTag(null);
        this.paramAEditText.setTag(null);
        this.paramB.setTag(null);
        this.paramBEditText.setTag(null);
        this.scaleEditText.setTag(null);
        this.smooth.setTag(null);
        this.smoothEditText.setTag(null);
        this.sourceASpinner.setTag(null);
        this.waveType.setTag(null);
        this.waveTypeSwitch.setTag(null);
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
        if (358 == i) {
            setGridFullMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((MathParam) obj);
        } else if (359 == i) {
            setGridHalfMapping((MappingObject) obj);
        } else if (361 == i) {
            setGridNoneMapping((MappingObject) obj);
        } else if (451 == i) {
            setItemPosition((Integer) obj);
        } else if (2 == i) {
            setCenterMapping((MappingObject) obj);
        } else if (7 != i) {
            return false;
        } else {
            setGndMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterMathFunBinding
    public void setGridFullMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mGridFullMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(358);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathFunBinding
    public void setParam(MathParam mathParam) {
        updateRegistration(1, mathParam);
        this.mParam = mathParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathFunBinding
    public void setGridHalfMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mGridHalfMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(359);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathFunBinding
    public void setGridNoneMapping(MappingObject mappingObject) {
        updateRegistration(3, mappingObject);
        this.mGridNoneMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(361);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathFunBinding
    public void setItemPosition(Integer num) {
        this.mItemPosition = num;
    }

    @Override // com.rigol.scope.databinding.AdapterMathFunBinding
    public void setCenterMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mCenterMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathFunBinding
    public void setGndMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mGndMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeGridFullMapping((MappingObject) obj, i2);
            case 1:
                return onChangeParam((MathParam) obj, i2);
            case 2:
                return onChangeGridHalfMapping((MappingObject) obj, i2);
            case 3:
                return onChangeGridNoneMapping((MappingObject) obj, i2);
            case 4:
                return onChangeCenterMapping((MappingObject) obj, i2);
            case 5:
                return onChangeGndMapping((MappingObject) obj, i2);
            case 6:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgMathS32arithaParamSourceArithAIndexValue1((MappingObject) obj, i2);
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
                this.mDirtyFlags |= 256;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(MathParam mathParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 863) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 565) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 988) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 774) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 573) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 501) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 442) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 443) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 241) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 502) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 444) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 1089) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 1039) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 477) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 475) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 288) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 363) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeGridHalfMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
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

    private boolean onChangeGridNoneMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
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

    private boolean onChangeCenterMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangeGndMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgMathS32arithaParamSourceArithAIndexValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0251 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0260 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x016d  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        boolean z4;
        int i2;
        boolean z5;
        int i3;
        boolean z6;
        boolean z7;
        int i4;
        boolean z8;
        boolean z9;
        String str2;
        float f;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        String str18;
        String str19;
        long j2;
        int i5;
        String str20;
        boolean z17;
        float f2;
        int i6;
        String str21;
        boolean z18;
        boolean z19;
        boolean z20;
        String str22;
        String str23;
        String str24;
        boolean z21;
        boolean z22;
        String str25;
        int i7;
        String str26;
        long j3;
        ServiceEnum.Unit unit;
        long j4;
        ServiceEnum.MathWaveType mathWaveType;
        ServiceEnum.Chan chan;
        int i8;
        ServiceEnum.EWaveGrids eWaveGrids;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mGridFullMapping;
        MathParam mathParam = this.mParam;
        MappingObject mappingObject2 = this.mGridHalfMapping;
        MappingObject mappingObject3 = this.mGridNoneMapping;
        MappingObject mappingObject4 = this.mCenterMapping;
        MappingObject mappingObject5 = this.mGndMapping;
        String str27 = ((j & 1073742081) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        if ((j & 1140850242) != 0) {
            if ((j & 1073758210) != 0) {
                str11 = UnitFormat.newBuilder(UnitFormat.SI.MICRO).convert(mathParam != null ? mathParam.getLineA() : 0L);
            } else {
                str11 = null;
            }
            if ((j & 1073872898) != 0) {
                str12 = String.valueOf(mathParam != null ? mathParam.getDiffSmooth() : 0);
            } else {
                str12 = null;
            }
            if ((j & 1073748994) != 0) {
                ServiceEnum.Unit unitIndex = mathParam != null ? mathParam.getUnitIndex() : null;
                if (unitIndex != null) {
                    str13 = unitIndex.value2;
                    if ((j & 1074003970) == 0) {
                        str14 = UnitFormat.newBuilder(UnitFormat.SI.MICRO).convert(mathParam != null ? mathParam.getLineB() : 0L);
                    } else {
                        str14 = null;
                    }
                    String labelString = ((j & 1077936130) != 0 || mathParam == null) ? null : mathParam.getLabelString();
                    if ((j & 1073747970) == 0) {
                        str15 = str14;
                        str16 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(mathParam != null ? mathParam.getScale() : 0L) + str13;
                    } else {
                        str15 = str14;
                        str16 = null;
                    }
                    if ((j & 1090519042) == 0) {
                        ServiceEnum.VertExpand expandIndex = mathParam != null ? mathParam.getExpandIndex() : null;
                        str17 = str16;
                        z11 = expandIndex == ServiceEnum.VertExpand.vert_expand_center;
                        z10 = expandIndex == ServiceEnum.VertExpand.vert_expand_gnd;
                    } else {
                        str17 = str16;
                        z10 = false;
                        z11 = false;
                    }
                    if ((j & 1107296258) == 0) {
                        if (mathParam != null) {
                            eWaveGrids = mathParam.getGrids();
                            z12 = z10;
                        } else {
                            z12 = z10;
                            eWaveGrids = null;
                        }
                        boolean z23 = eWaveGrids == ServiceEnum.EWaveGrids.GRID_IS_FULL;
                        z15 = eWaveGrids == ServiceEnum.EWaveGrids.GRID_IS_HALF;
                        z14 = eWaveGrids == ServiceEnum.EWaveGrids.GRID_IS_NONE;
                        z13 = z23;
                    } else {
                        z12 = z10;
                        z13 = false;
                        z14 = false;
                        z15 = false;
                    }
                    if ((j & 1073742402) == 0) {
                        if (mathParam != null) {
                            z16 = z13;
                            chan = mathParam.getSourceArithAIndex();
                        } else {
                            z16 = z13;
                            chan = null;
                        }
                        str18 = labelString;
                        if (chan != null) {
                            i8 = chan.value1;
                            str19 = str11;
                        } else {
                            str19 = str11;
                            i8 = 0;
                        }
                        MappingObject mappingObject6 = ViewUtil.getMappingObject(R.array.msg_math_s32aritha, i8);
                        updateRegistration(6, mappingObject6);
                        str20 = mappingObject6 != null ? mappingObject6.getStr() : null;
                        j2 = 0;
                        i5 = (j & 1073742338) != 0 ? ColorUtil.getColor(getRoot().getContext(), chan) : 0;
                    } else {
                        z16 = z13;
                        str18 = labelString;
                        str19 = str11;
                        j2 = 0;
                        i5 = 0;
                        str20 = null;
                    }
                    if ((j & 1074790402) == j2) {
                        z17 = mathParam != null ? mathParam.isZoomEn() : false;
                        f2 = ContextUtil.getAlpha(z17);
                    } else {
                        z17 = false;
                        f2 = 0.0f;
                    }
                    if ((j & 1075838978) == j2) {
                        if (mathParam != null) {
                            str21 = str20;
                            i6 = i5;
                            mathWaveType = mathParam.getWaveType();
                        } else {
                            i6 = i5;
                            str21 = str20;
                            mathWaveType = null;
                        }
                        if (mathWaveType == ServiceEnum.MathWaveType.MathWave_Zoom) {
                            z18 = true;
                            if ((j & 1073840130) != 0) {
                                if (mathParam != null) {
                                    long intgBias = mathParam.getIntgBias();
                                    unit = mathParam.getIntgBiasUnit();
                                    z20 = z17;
                                    str22 = str12;
                                    j4 = intgBias;
                                } else {
                                    z20 = z17;
                                    str22 = str12;
                                    unit = null;
                                    j4 = 0;
                                }
                                z19 = z18;
                                str23 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j4) + (unit != null ? unit.value2 : null);
                            } else {
                                z19 = z18;
                                z20 = z17;
                                str22 = str12;
                                str23 = null;
                            }
                            boolean invert = ((j & 1074266114) != 0 || mathParam == null) ? false : mathParam.getInvert();
                            boolean isLabel = ((j & 1082130434) != 0 || mathParam == null) ? false : mathParam.isLabel();
                            if ((j & 1073744898) != 0) {
                                if (mathParam != null) {
                                    str24 = str23;
                                    z21 = invert;
                                    j3 = mathParam.getOffset();
                                } else {
                                    str24 = str23;
                                    z21 = invert;
                                    j3 = 0;
                                }
                                z22 = isLabel;
                                str25 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j3) + str13;
                            } else {
                                str24 = str23;
                                z21 = invert;
                                z22 = isLabel;
                                str25 = null;
                            }
                            i7 = ((j & 1073750018) > 0L ? 1 : ((j & 1073750018) == 0L ? 0 : -1));
                            if (i7 != 0) {
                                ServiceEnum.MathOperator operator = mathParam != null ? mathParam.getOperator() : null;
                                boolean z24 = operator == ServiceEnum.MathOperator.operator_diff;
                                str26 = str25;
                                boolean z25 = operator == ServiceEnum.MathOperator.operator_ax_b;
                                boolean z26 = operator == ServiceEnum.MathOperator.operator_intg;
                                if (i7 != 0) {
                                    j |= z24 ? 17179869184L : 8589934592L;
                                }
                                if ((j & 1073750018) != 0) {
                                    j |= z25 ? 68719476736L : 34359738368L;
                                }
                                if ((j & 1073750018) != 0) {
                                    j |= z26 ? 4294967296L : 2147483648L;
                                }
                                int i9 = z24 ? 0 : 8;
                                int i10 = z25 ? 0 : 8;
                                i2 = i9;
                                i = i10;
                                str2 = str24;
                                z3 = z11;
                                i3 = z26 ? 0 : 8;
                            } else {
                                str26 = str25;
                                str2 = str24;
                                z3 = z11;
                                i = 0;
                                i2 = 0;
                                i3 = 0;
                            }
                            f = f2;
                            z2 = z16;
                            z4 = z15;
                            str9 = str18;
                            i4 = i6;
                            str3 = str21;
                            str4 = str22;
                            z9 = z20;
                            z6 = z21;
                            z8 = z19;
                            str8 = str26;
                            z7 = z22;
                            str = str27;
                            z = z14;
                            z5 = z12;
                            str7 = str19;
                            String str28 = str17;
                            str6 = str15;
                            str5 = str28;
                        }
                    } else {
                        i6 = i5;
                        str21 = str20;
                    }
                    z18 = false;
                    if ((j & 1073840130) != 0) {
                    }
                    if ((j & 1074266114) != 0) {
                    }
                    if ((j & 1082130434) != 0) {
                    }
                    if ((j & 1073744898) != 0) {
                    }
                    i7 = ((j & 1073750018) > 0L ? 1 : ((j & 1073750018) == 0L ? 0 : -1));
                    if (i7 != 0) {
                    }
                    f = f2;
                    z2 = z16;
                    z4 = z15;
                    str9 = str18;
                    i4 = i6;
                    str3 = str21;
                    str4 = str22;
                    z9 = z20;
                    z6 = z21;
                    z8 = z19;
                    str8 = str26;
                    z7 = z22;
                    str = str27;
                    z = z14;
                    z5 = z12;
                    str7 = str19;
                    String str282 = str17;
                    str6 = str15;
                    str5 = str282;
                }
            }
            str13 = null;
            if ((j & 1074003970) == 0) {
            }
            if ((j & 1077936130) != 0) {
            }
            if ((j & 1073747970) == 0) {
            }
            if ((j & 1090519042) == 0) {
            }
            if ((j & 1107296258) == 0) {
            }
            if ((j & 1073742402) == 0) {
            }
            if ((j & 1074790402) == j2) {
            }
            if ((j & 1075838978) == j2) {
            }
            z18 = false;
            if ((j & 1073840130) != 0) {
            }
            if ((j & 1074266114) != 0) {
            }
            if ((j & 1082130434) != 0) {
            }
            if ((j & 1073744898) != 0) {
            }
            i7 = ((j & 1073750018) > 0L ? 1 : ((j & 1073750018) == 0L ? 0 : -1));
            if (i7 != 0) {
            }
            f = f2;
            z2 = z16;
            z4 = z15;
            str9 = str18;
            i4 = i6;
            str3 = str21;
            str4 = str22;
            z9 = z20;
            z6 = z21;
            z8 = z19;
            str8 = str26;
            z7 = z22;
            str = str27;
            z = z14;
            z5 = z12;
            str7 = str19;
            String str2822 = str17;
            str6 = str15;
            str5 = str2822;
        } else {
            str = str27;
            z = false;
            z2 = false;
            z3 = false;
            i = 0;
            z4 = false;
            i2 = 0;
            z5 = false;
            i3 = 0;
            z6 = false;
            z7 = false;
            i4 = 0;
            z8 = false;
            z9 = false;
            str2 = null;
            f = 0.0f;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
        }
        int i11 = ((j & 1140850692) > 0L ? 1 : ((j & 1140850692) == 0L ? 0 : -1));
        String str29 = (i11 == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        int i12 = ((j & 1207959560) > 0L ? 1 : ((j & 1207959560) == 0L ? 0 : -1));
        String str30 = (i12 == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        int i13 = ((j & 1342177296) > 0L ? 1 : ((j & 1342177296) == 0L ? 0 : -1));
        String str31 = (i13 == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        int i14 = ((j & 1610612768) > 0L ? 1 : ((j & 1610612768) == 0L ? 0 : -1));
        String str32 = (i14 == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        if ((j & 1073750018) != 0) {
            str10 = str30;
            this.bias.setVisibility(i3);
            this.biasEditText.setVisibility(i3);
            this.paramA.setVisibility(i);
            this.paramAEditText.setVisibility(i);
            this.paramB.setVisibility(i);
            this.paramBEditText.setVisibility(i);
            this.smooth.setVisibility(i2);
            this.smoothEditText.setVisibility(i2);
        } else {
            str10 = str30;
        }
        if ((j & 1073840130) != 0) {
            TextViewBindingAdapter.setText(this.biasEditText, str2);
        }
        if ((j & 1090519042) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.centerRadioButton, z3);
            CompoundButtonBindingAdapter.setChecked(this.gndRadioButton, z5);
        }
        if (i13 != 0) {
            TextViewBindingAdapter.setText(this.centerRadioButton, str31);
        }
        if ((j & 1107296258) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.fullRadioButton, z2);
            CompoundButtonBindingAdapter.setChecked(this.halfRadioButton, z4);
            CompoundButtonBindingAdapter.setChecked(this.noneRadioButton, z);
        }
        if ((1073742081 & j) != 0) {
            TextViewBindingAdapter.setText(this.fullRadioButton, str);
        }
        if (i14 != 0) {
            TextViewBindingAdapter.setText(this.gndRadioButton, str32);
        }
        if (i11 != 0) {
            TextViewBindingAdapter.setText(this.halfRadioButton, str29);
        }
        if ((j & 1074266114) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.invertSwitch, z6);
        }
        if ((j & 1077936130) != 0) {
            TextViewBindingAdapter.setText(this.labelEditText, str9);
        }
        if ((j & 1082130434) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.labelSwitch, z7);
        }
        if (i12 != 0) {
            TextViewBindingAdapter.setText(this.noneRadioButton, str10);
        }
        if ((j & 1073744898) != 0) {
            TextViewBindingAdapter.setText(this.offsetEditText, str8);
        }
        if ((j & 1073758210) != 0) {
            TextViewBindingAdapter.setText(this.paramAEditText, str7);
        }
        if ((j & 1074003970) != 0) {
            TextViewBindingAdapter.setText(this.paramBEditText, str6);
        }
        if ((j & 1073747970) != 0) {
            TextViewBindingAdapter.setText(this.scaleEditText, str5);
        }
        if ((j & 1073872898) != 0) {
            TextViewBindingAdapter.setText(this.smoothEditText, str4);
        }
        if ((j & 1073742402) != 0) {
            TextViewBindingAdapter.setText(this.sourceASpinner, str3);
        }
        if ((j & 1073742338) != 0) {
            this.sourceASpinner.setTextColor(i4);
        }
        if ((j & 1074790402) != 0) {
            if (getBuildSdkInt() >= 11) {
                float f3 = f;
                this.waveType.setAlpha(f3);
                this.waveTypeSwitch.setAlpha(f3);
            }
            this.waveTypeSwitch.setEnabled(z9);
        }
        if ((j & 1075838978) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.waveTypeSwitch, z8);
        }
    }
}
