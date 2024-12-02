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
public class AdapterMathFilterBindingImpl extends AdapterMathFilterBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.math_guideline_center, 26);
        sViewsWithIds.put(R.id.sourceA, 27);
        sViewsWithIds.put(R.id.math_dividing_line, 28);
        sViewsWithIds.put(R.id.offset, 29);
        sViewsWithIds.put(R.id.math_offset_up, 30);
        sViewsWithIds.put(R.id.math_offset_down, 31);
        sViewsWithIds.put(R.id.scale, 32);
        sViewsWithIds.put(R.id.main_scale_vertical, 33);
        sViewsWithIds.put(R.id.main_scale_nomal, 34);
        sViewsWithIds.put(R.id.invert, 35);
        sViewsWithIds.put(R.id.auto_setting_btn, 36);
        sViewsWithIds.put(R.id.label, 37);
        sViewsWithIds.put(R.id.expand, 38);
        sViewsWithIds.put(R.id.expand_radio_group, 39);
        sViewsWithIds.put(R.id.grid_type, 40);
        sViewsWithIds.put(R.id.grid_type_radio_group, 41);
    }

    public AdapterMathFilterBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 42, sIncludes, sViewsWithIds));
    }

    private AdapterMathFilterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (Button) objArr[36], (TextView) objArr[8], (EditText) objArr[9], (TextView) objArr[10], (EditText) objArr[11], (TextView) objArr[12], (EditText) objArr[13], (TextView) objArr[14], (EditText) objArr[15], (RadioButton) objArr[22], (TextView) objArr[38], (RadioGroup) objArr[39], (RadioButton) objArr[23], (RadioButton) objArr[21], (TextView) objArr[40], (RadioGroup) objArr[41], (RadioButton) objArr[24], (TextView) objArr[6], (EditText) objArr[7], (TextView) objArr[35], (SwitchButton) objArr[16], (TextView) objArr[37], (BaseEditText) objArr[19], (SwitchButton) objArr[20], (TextView) objArr[4], (EditText) objArr[5], (ImageButton) objArr[34], (ImageButton) objArr[33], (View) objArr[28], (Guideline) objArr[26], (ImageButton) objArr[31], (ImageButton) objArr[30], (RadioButton) objArr[25], (TextView) objArr[29], (EditText) objArr[2], (TextView) objArr[32], (EditText) objArr[3], (TextView) objArr[27], (TextView) objArr[1], (TextView) objArr[17], (SwitchButton) objArr[18]);
        this.mDirtyFlags = -1L;
        this.bpWc1.setTag(null);
        this.bpWc1EditText.setTag(null);
        this.bpWc2.setTag(null);
        this.bpWc2EditText.setTag(null);
        this.btWc1.setTag(null);
        this.btWc1EditText.setTag(null);
        this.btWc2.setTag(null);
        this.btWc2EditText.setTag(null);
        this.centerRadioButton.setTag(null);
        this.fullRadioButton.setTag(null);
        this.gndRadioButton.setTag(null);
        this.halfRadioButton.setTag(null);
        this.hpWc.setTag(null);
        this.hpWcEditText.setTag(null);
        this.invertSwitch.setTag(null);
        this.labelEditText.setTag(null);
        this.labelSwitch.setTag(null);
        this.lpWc.setTag(null);
        this.lpWcEditText.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.noneRadioButton.setTag(null);
        this.offsetEditText.setTag(null);
        this.scaleEditText.setTag(null);
        this.sourceASpinner.setTag(null);
        this.waveType.setTag(null);
        this.waveTypeSwitch.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2147483648L;
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

    @Override // com.rigol.scope.databinding.AdapterMathFilterBinding
    public void setGridFullMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mGridFullMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(358);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathFilterBinding
    public void setParam(MathParam mathParam) {
        updateRegistration(1, mathParam);
        this.mParam = mathParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathFilterBinding
    public void setGridHalfMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mGridHalfMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(359);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathFilterBinding
    public void setGridNoneMapping(MappingObject mappingObject) {
        updateRegistration(3, mappingObject);
        this.mGridNoneMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(361);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathFilterBinding
    public void setItemPosition(Integer num) {
        this.mItemPosition = num;
    }

    @Override // com.rigol.scope.databinding.AdapterMathFilterBinding
    public void setCenterMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mCenterMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathFilterBinding
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
        } else if (i == 512) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 384) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 122) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 123) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 124) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 125) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 444) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 1089) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 1039) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 477) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 475) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 288) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else if (i == 363) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
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
                this.mDirtyFlags |= 134217728;
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
                this.mDirtyFlags |= 268435456;
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
                this.mDirtyFlags |= 536870912;
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
                this.mDirtyFlags |= 1073741824;
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

    /* JADX WARN: Removed duplicated region for block: B:103:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02bf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01f4  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        String str;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i5;
        boolean z8;
        boolean z9;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        float f;
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
        long j2;
        int i6;
        String str19;
        boolean z17;
        float f2;
        String str20;
        int i7;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        boolean z18;
        String str26;
        boolean z19;
        boolean z20;
        String str27;
        int i8;
        String str28;
        boolean z21;
        boolean z22;
        int i9;
        int i10;
        int i11;
        int i12;
        String str29;
        long j3;
        long j4;
        int i13;
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
        String str30 = ((j & 2147483905L) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        int i14 = 0;
        if ((j & 2281700930L) != 0) {
            if ((j & 2147614722L) != 0) {
                str13 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(mathParam != null ? mathParam.getBpFreq2() : 0L) + ServiceEnum.Unit.Unit_hz.value2, 6);
            } else {
                str13 = null;
            }
            if ((j & 2148007938L) != 0) {
                str14 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(mathParam != null ? mathParam.getBtFreq2() : 0L) + ServiceEnum.Unit.Unit_hz.value2, 6);
            } else {
                str14 = null;
            }
            if ((2147490818L & j) != 0) {
                ServiceEnum.Unit unitIndex = mathParam != null ? mathParam.getUnitIndex() : null;
                if (unitIndex != null) {
                    str15 = unitIndex.value2;
                    String labelString = ((j & 2155872258L) != 0 || mathParam == null) ? null : mathParam.getLabelString();
                    if ((j & 2147489794L) == 0) {
                        str16 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(mathParam != null ? mathParam.getScale() : 0L) + str15;
                    } else {
                        str16 = null;
                    }
                    if ((j & 2181038082L) == 0) {
                        ServiceEnum.VertExpand expandIndex = mathParam != null ? mathParam.getExpandIndex() : null;
                        str17 = str14;
                        z11 = expandIndex == ServiceEnum.VertExpand.vert_expand_center;
                        z10 = expandIndex == ServiceEnum.VertExpand.vert_expand_gnd;
                    } else {
                        str17 = str14;
                        z10 = false;
                        z11 = false;
                    }
                    if ((j & 2214592514L) == 0) {
                        if (mathParam != null) {
                            eWaveGrids = mathParam.getGrids();
                            z12 = z10;
                        } else {
                            z12 = z10;
                            eWaveGrids = null;
                        }
                        z14 = eWaveGrids == ServiceEnum.EWaveGrids.GRID_IS_FULL;
                        z15 = eWaveGrids == ServiceEnum.EWaveGrids.GRID_IS_HALF;
                        z13 = eWaveGrids == ServiceEnum.EWaveGrids.GRID_IS_NONE;
                    } else {
                        z12 = z10;
                        z13 = false;
                        z14 = false;
                        z15 = false;
                    }
                    if ((j & 2147484226L) == 0) {
                        ServiceEnum.Chan sourceArithAIndex = mathParam != null ? mathParam.getSourceArithAIndex() : null;
                        z16 = z13;
                        if (sourceArithAIndex != null) {
                            i13 = sourceArithAIndex.value1;
                            str18 = str16;
                        } else {
                            str18 = str16;
                            i13 = 0;
                        }
                        MappingObject mappingObject6 = ViewUtil.getMappingObject(R.array.msg_math_s32aritha, i13);
                        updateRegistration(6, mappingObject6);
                        str19 = mappingObject6 != null ? mappingObject6.getStr() : null;
                        j2 = 0;
                        i6 = (j & 2147484162L) != 0 ? ColorUtil.getColor(getRoot().getContext(), sourceArithAIndex) : 0;
                    } else {
                        z16 = z13;
                        str18 = str16;
                        j2 = 0;
                        i6 = 0;
                        str19 = null;
                    }
                    if ((j & 2149580802L) == j2) {
                        z17 = mathParam != null ? mathParam.isZoomEn() : false;
                        f2 = ContextUtil.getAlpha(z17);
                    } else {
                        z17 = false;
                        f2 = 0.0f;
                    }
                    if ((j & 2147549186L) == j2) {
                        if (mathParam != null) {
                            str20 = str19;
                            i7 = i6;
                            str21 = str13;
                            j4 = mathParam.getBpFreq1();
                        } else {
                            str20 = str19;
                            i7 = i6;
                            str21 = str13;
                            j4 = 0;
                        }
                        str22 = labelString;
                        str23 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(j4) + ServiceEnum.Unit.Unit_hz.value2, 6);
                    } else {
                        str20 = str19;
                        i7 = i6;
                        str21 = str13;
                        str22 = labelString;
                        str23 = null;
                    }
                    if ((j & 2147745794L) == 0) {
                        str24 = str23;
                        str25 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(mathParam != null ? mathParam.getBtFreq1() : 0L) + ServiceEnum.Unit.Unit_hz.value2, 6);
                    } else {
                        str24 = str23;
                        str25 = null;
                    }
                    if ((j & 2151677954L) != 0) {
                        if ((mathParam != null ? mathParam.getWaveType() : null) == ServiceEnum.MathWaveType.MathWave_Zoom) {
                            z18 = true;
                            boolean invert = ((j & 2148532226L) != 0 || mathParam == null) ? false : mathParam.getInvert();
                            boolean isLabel = ((j & 2164260866L) != 0 || mathParam == null) ? false : mathParam.isLabel();
                            if ((j & 2147486722L) != 0) {
                                if (mathParam != null) {
                                    z19 = z18;
                                    z20 = invert;
                                    j3 = mathParam.getOffset();
                                } else {
                                    z19 = z18;
                                    z20 = invert;
                                    j3 = 0;
                                }
                                str26 = str25;
                                str27 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j3) + str15;
                            } else {
                                str26 = str25;
                                z19 = z18;
                                z20 = invert;
                                str27 = null;
                            }
                            i8 = ((j & 2147491842L) > 0L ? 1 : ((j & 2147491842L) == 0L ? 0 : -1));
                            if (i8 != 0) {
                                ServiceEnum.MathOperator operator = mathParam != null ? mathParam.getOperator() : null;
                                str28 = str27;
                                boolean z23 = operator == ServiceEnum.MathOperator.operator_bt;
                                z21 = isLabel;
                                boolean z24 = operator == ServiceEnum.MathOperator.operator_lp;
                                z22 = z17;
                                boolean z25 = operator == ServiceEnum.MathOperator.operator_hp;
                                boolean z26 = operator == ServiceEnum.MathOperator.operator_bp;
                                if (i8 != 0) {
                                    j |= z23 ? 137438953472L : 68719476736L;
                                }
                                if ((j & 2147491842L) != 0) {
                                    j |= z24 ? 34359738368L : 17179869184L;
                                }
                                if ((j & 2147491842L) != 0) {
                                    j |= z25 ? 549755813888L : 274877906944L;
                                }
                                if ((j & 2147491842L) != 0) {
                                    j |= z26 ? 8589934592L : 4294967296L;
                                }
                                i10 = z23 ? 0 : 8;
                                i9 = z24 ? 0 : 8;
                                i11 = z25 ? 0 : 8;
                                if (!z26) {
                                    i14 = 8;
                                }
                            } else {
                                str28 = str27;
                                z21 = isLabel;
                                z22 = z17;
                                i9 = 0;
                                i10 = 0;
                                i11 = 0;
                            }
                            if ((2147500034L & j) != 0) {
                                i12 = i9;
                                str29 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(mathParam != null ? mathParam.getLpFreq() : 0L) + ServiceEnum.Unit.Unit_hz.value2, 6);
                            } else {
                                i12 = i9;
                                str29 = null;
                            }
                            if ((2147516418L & j) != 0) {
                                String convert = UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(mathParam != null ? mathParam.getHpFreq() : 0L);
                                str9 = str29;
                                i3 = i11;
                                f = f2;
                                str4 = str17;
                                z2 = z12;
                                z3 = z14;
                                z4 = z15;
                                z5 = z16;
                                str7 = str18;
                                str5 = str21;
                                i5 = i7;
                                str10 = str22;
                                str2 = str24;
                                z8 = z19;
                                z6 = z20;
                                z7 = z21;
                                z9 = z22;
                                str = str30;
                                str11 = ViewUtil.subNumber(convert + ServiceEnum.Unit.Unit_hz.value2, 6);
                                i2 = i10;
                                z = z11;
                                i = i14;
                                i4 = i12;
                                str6 = str20;
                                str8 = str28;
                                str3 = str26;
                            } else {
                                str9 = str29;
                                i3 = i11;
                                f = f2;
                                str4 = str17;
                                z2 = z12;
                                z3 = z14;
                                z4 = z15;
                                z5 = z16;
                                str7 = str18;
                                str5 = str21;
                                i5 = i7;
                                str10 = str22;
                                str2 = str24;
                                z8 = z19;
                                z6 = z20;
                                str3 = str26;
                                z7 = z21;
                                z9 = z22;
                                str11 = null;
                                str = str30;
                                i2 = i10;
                                z = z11;
                                i = i14;
                                i4 = i12;
                                str6 = str20;
                                str8 = str28;
                            }
                        }
                    }
                    z18 = false;
                    if ((j & 2148532226L) != 0) {
                    }
                    if ((j & 2164260866L) != 0) {
                    }
                    if ((j & 2147486722L) != 0) {
                    }
                    i8 = ((j & 2147491842L) > 0L ? 1 : ((j & 2147491842L) == 0L ? 0 : -1));
                    if (i8 != 0) {
                    }
                    if ((2147500034L & j) != 0) {
                    }
                    if ((2147516418L & j) != 0) {
                    }
                }
            }
            str15 = null;
            if ((j & 2155872258L) != 0) {
            }
            if ((j & 2147489794L) == 0) {
            }
            if ((j & 2181038082L) == 0) {
            }
            if ((j & 2214592514L) == 0) {
            }
            if ((j & 2147484226L) == 0) {
            }
            if ((j & 2149580802L) == j2) {
            }
            if ((j & 2147549186L) == j2) {
            }
            if ((j & 2147745794L) == 0) {
            }
            if ((j & 2151677954L) != 0) {
            }
            z18 = false;
            if ((j & 2148532226L) != 0) {
            }
            if ((j & 2164260866L) != 0) {
            }
            if ((j & 2147486722L) != 0) {
            }
            i8 = ((j & 2147491842L) > 0L ? 1 : ((j & 2147491842L) == 0L ? 0 : -1));
            if (i8 != 0) {
            }
            if ((2147500034L & j) != 0) {
            }
            if ((2147516418L & j) != 0) {
            }
        } else {
            str = str30;
            z = false;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
            i5 = 0;
            z8 = false;
            z9 = false;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
            str11 = null;
            f = 0.0f;
        }
        int i15 = ((j & 2281701380L) > 0L ? 1 : ((j & 2281701380L) == 0L ? 0 : -1));
        String str31 = (i15 == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        int i16 = ((j & 2415919112L) > 0L ? 1 : ((j & 2415919112L) == 0L ? 0 : -1));
        String str32 = (i16 == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        int i17 = ((j & 2684354576L) > 0L ? 1 : ((j & 2684354576L) == 0L ? 0 : -1));
        String str33 = (i17 == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        int i18 = ((j & 3221225504L) > 0L ? 1 : ((j & 3221225504L) == 0L ? 0 : -1));
        String str34 = (i18 == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        if ((j & 2147491842L) != 0) {
            str12 = str32;
            this.bpWc1.setVisibility(i);
            this.bpWc1EditText.setVisibility(i);
            this.bpWc2.setVisibility(i);
            this.bpWc2EditText.setVisibility(i);
            this.btWc1.setVisibility(i2);
            this.btWc1EditText.setVisibility(i2);
            this.btWc2.setVisibility(i2);
            this.btWc2EditText.setVisibility(i2);
            this.hpWc.setVisibility(i3);
            this.hpWcEditText.setVisibility(i3);
            this.lpWc.setVisibility(i4);
            this.lpWcEditText.setVisibility(i4);
        } else {
            str12 = str32;
        }
        if ((j & 2147549186L) != 0) {
            TextViewBindingAdapter.setText(this.bpWc1EditText, str2);
        }
        if ((j & 2147614722L) != 0) {
            TextViewBindingAdapter.setText(this.bpWc2EditText, str5);
        }
        if ((j & 2147745794L) != 0) {
            TextViewBindingAdapter.setText(this.btWc1EditText, str3);
        }
        if ((j & 2148007938L) != 0) {
            TextViewBindingAdapter.setText(this.btWc2EditText, str4);
        }
        if ((j & 2181038082L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.centerRadioButton, z);
            CompoundButtonBindingAdapter.setChecked(this.gndRadioButton, z2);
        }
        if (i17 != 0) {
            TextViewBindingAdapter.setText(this.centerRadioButton, str33);
        }
        if ((j & 2214592514L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.fullRadioButton, z3);
            CompoundButtonBindingAdapter.setChecked(this.halfRadioButton, z4);
            CompoundButtonBindingAdapter.setChecked(this.noneRadioButton, z5);
        }
        if ((2147483905L & j) != 0) {
            TextViewBindingAdapter.setText(this.fullRadioButton, str);
        }
        if (i18 != 0) {
            TextViewBindingAdapter.setText(this.gndRadioButton, str34);
        }
        if (i15 != 0) {
            TextViewBindingAdapter.setText(this.halfRadioButton, str31);
        }
        if ((2147516418L & j) != 0) {
            TextViewBindingAdapter.setText(this.hpWcEditText, str11);
        }
        if ((j & 2148532226L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.invertSwitch, z6);
        }
        if ((j & 2155872258L) != 0) {
            TextViewBindingAdapter.setText(this.labelEditText, str10);
        }
        if ((j & 2164260866L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.labelSwitch, z7);
        }
        if ((2147500034L & j) != 0) {
            TextViewBindingAdapter.setText(this.lpWcEditText, str9);
        }
        if (i16 != 0) {
            TextViewBindingAdapter.setText(this.noneRadioButton, str12);
        }
        if ((2147486722L & j) != 0) {
            TextViewBindingAdapter.setText(this.offsetEditText, str8);
        }
        if ((j & 2147489794L) != 0) {
            TextViewBindingAdapter.setText(this.scaleEditText, str7);
        }
        if ((j & 2147484226L) != 0) {
            TextViewBindingAdapter.setText(this.sourceASpinner, str6);
        }
        if ((j & 2147484162L) != 0) {
            this.sourceASpinner.setTextColor(i5);
        }
        if ((j & 2149580802L) != 0) {
            if (getBuildSdkInt() >= 11) {
                float f3 = f;
                this.waveType.setAlpha(f3);
                this.waveTypeSwitch.setAlpha(f3);
            }
            this.waveTypeSwitch.setEnabled(z9);
        }
        if ((j & 2151677954L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.waveTypeSwitch, z8);
        }
    }
}
