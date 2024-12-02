package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
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
public class AdapterMathLogicBindingImpl extends AdapterMathLogicBinding {
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
        sViewsWithIds.put(R.id.size, 28);
        sViewsWithIds.put(R.id.size_radio_group, 29);
        sViewsWithIds.put(R.id.sensitivity, 30);
        sViewsWithIds.put(R.id.threshold_ch1, 31);
        sViewsWithIds.put(R.id.threshold_ch2, 32);
        sViewsWithIds.put(R.id.label, 33);
        sViewsWithIds.put(R.id.grid_type, 34);
        sViewsWithIds.put(R.id.grid_type_radio_group, 35);
    }

    public AdapterMathLogicBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 36, sIncludes, sViewsWithIds));
    }

    private AdapterMathLogicBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 9, (RadioButton) objArr[19], (TextView) objArr[34], (RadioGroup) objArr[35], (RadioButton) objArr[20], (TextView) objArr[33], (BaseEditText) objArr[17], (SwitchButton) objArr[18], (RadioButton) objArr[7], (View) objArr[24], (Guideline) objArr[22], (ImageButton) objArr[27], (ImageButton) objArr[26], (RadioButton) objArr[6], (RadioButton) objArr[21], (TextView) objArr[25], (EditText) objArr[4], (TextView) objArr[30], (EditText) objArr[8], (TextView) objArr[28], (RadioGroup) objArr[29], (RadioButton) objArr[5], (TextView) objArr[23], (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[31], (EditText) objArr[11], (TextView) objArr[32], (EditText) objArr[12], (TextView) objArr[13], (EditText) objArr[14], (TextView) objArr[15], (EditText) objArr[16], (TextView) objArr[9], (SwitchButton) objArr[10]);
        this.mDirtyFlags = -1L;
        this.fullRadioButton.setTag(null);
        this.halfRadioButton.setTag(null);
        this.labelEditText.setTag(null);
        this.labelSwitch.setTag(null);
        this.largeRadioButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.mediumRadioButton.setTag(null);
        this.noneRadioButton.setTag(null);
        this.offsetEditText.setTag(null);
        this.sensitivityEditText.setTag(null);
        this.smallRadioButton.setTag(null);
        this.sourceASpinner.setTag(null);
        this.sourceB.setTag(null);
        this.sourceBSpinner.setTag(null);
        this.thresholdCh1EditText.setTag(null);
        this.thresholdCh2EditText.setTag(null);
        this.thresholdCh3.setTag(null);
        this.thresholdCh3EditText.setTag(null);
        this.thresholdCh4.setTag(null);
        this.thresholdCh4EditText.setTag(null);
        this.waveType.setTag(null);
        this.waveTypeSwitch.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4294967296L;
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
        } else if (19 == i) {
            setSmallMapping((MappingObject) obj);
        } else if (359 == i) {
            setGridHalfMapping((MappingObject) obj);
        } else if (361 == i) {
            setGridNoneMapping((MappingObject) obj);
        } else if (451 == i) {
            setItemPosition((Integer) obj);
        } else if (8 == i) {
            setLargeMapping((MappingObject) obj);
        } else if (11 != i) {
            return false;
        } else {
            setMediumMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterMathLogicBinding
    public void setGridFullMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mGridFullMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(358);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathLogicBinding
    public void setParam(MathParam mathParam) {
        updateRegistration(2, mathParam);
        this.mParam = mathParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathLogicBinding
    public void setSmallMapping(MappingObject mappingObject) {
        updateRegistration(3, mappingObject);
        this.mSmallMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathLogicBinding
    public void setGridHalfMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mGridHalfMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(359);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathLogicBinding
    public void setGridNoneMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mGridNoneMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(361);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathLogicBinding
    public void setItemPosition(Integer num) {
        this.mItemPosition = num;
    }

    @Override // com.rigol.scope.databinding.AdapterMathLogicBinding
    public void setLargeMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mLargeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathLogicBinding
    public void setMediumMapping(MappingObject mappingObject) {
        updateRegistration(7, mappingObject);
        this.mMediumMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(11);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeGridFullMapping((MappingObject) obj, i2);
            case 1:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgMathS32logicbParamSourceLogicBIndexValue1((MappingObject) obj, i2);
            case 2:
                return onChangeParam((MathParam) obj, i2);
            case 3:
                return onChangeSmallMapping((MappingObject) obj, i2);
            case 4:
                return onChangeGridHalfMapping((MappingObject) obj, i2);
            case 5:
                return onChangeGridNoneMapping((MappingObject) obj, i2);
            case 6:
                return onChangeLargeMapping((MappingObject) obj, i2);
            case 7:
                return onChangeMediumMapping((MappingObject) obj, i2);
            case 8:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgMathS32logicaParamSourceLogicAIndexValue1((MappingObject) obj, i2);
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
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgMathS32logicbParamSourceLogicBIndexValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParam(MathParam mathParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 868) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 573) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 869) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 507) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 988) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 508) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 797) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 1089) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 1039) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 924) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 925) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 926) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 927) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 477) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 475) {
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

    private boolean onChangeSmallMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeGridHalfMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeGridNoneMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeLargeMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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

    private boolean onChangeMediumMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 2147483648L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgMathS32logicaParamSourceLogicAIndexValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0202  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
        String str9;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        int i2;
        int i3;
        boolean z7;
        boolean z8;
        boolean z9;
        float f;
        String str10;
        String str11;
        String str12;
        int i4;
        String str13;
        String str14;
        String str15;
        int i5;
        String str16;
        String str17;
        String str18;
        String str19;
        int i6;
        int i7;
        boolean z10;
        boolean z11;
        boolean z12;
        String str20;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        boolean z18;
        float f2;
        String str26;
        boolean z19;
        String str27;
        boolean z20;
        String str28;
        boolean z21;
        String str29;
        int i8;
        int i9;
        long j2;
        ServiceEnum.EWaveGrids eWaveGrids;
        ServiceEnum.LaScale laScale;
        int i10;
        int i11;
        int i12;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mGridFullMapping;
        MathParam mathParam = this.mParam;
        MappingObject mappingObject2 = this.mSmallMapping;
        MappingObject mappingObject3 = this.mGridHalfMapping;
        MappingObject mappingObject4 = this.mGridNoneMapping;
        MappingObject mappingObject5 = this.mLargeMapping;
        MappingObject mappingObject6 = this.mMediumMapping;
        String str30 = null;
        String str31 = ((j & 4294968321L) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        int i13 = ((j & 4294967296L) > 0L ? 1 : ((j & 4294967296L) == 0L ? 0 : -1));
        if (i13 != 0 && i13 != 0) {
            j |= ViewUtil.isDoubleChanS() ? 68719476736L : 34359738368L;
        }
        if ((j & 4429183238L) != 0) {
            int i14 = ((j & 4297064452L) > 0L ? 1 : ((j & 4297064452L) == 0L ? 0 : -1));
            if (i14 != 0) {
                str11 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(mathParam != null ? mathParam.getThresholdCH2() : 0L);
            } else {
                str11 = null;
            }
            if ((j & 4294975494L) != 0) {
                ServiceEnum.Chan sourceLogicBIndex = mathParam != null ? mathParam.getSourceLogicBIndex() : null;
                i4 = (j & 4294975492L) != 0 ? ColorUtil.getColor(getRoot().getContext(), sourceLogicBIndex) : 0;
                MappingObject mappingObject7 = ViewUtil.getMappingObject(R.array.msg_math_s32logicb, sourceLogicBIndex != null ? sourceLogicBIndex.value1 : 0);
                updateRegistration(1, mappingObject7);
                str12 = mappingObject7 != null ? mappingObject7.getStr() : null;
            } else {
                str12 = null;
                i4 = 0;
            }
            if ((j & 4310695940L) != 0) {
                ServiceEnum.Unit thresholdUnit = mathParam != null ? mathParam.getThresholdUnit() : null;
                str14 = thresholdUnit != null ? thresholdUnit.value2 : null;
                if (i14 != 0) {
                    str13 = str11 + str14;
                } else {
                    str13 = null;
                }
            } else {
                str13 = null;
                str14 = null;
            }
            if ((j & 4295147524L) != 0) {
                ServiceEnum.Unit unitIndex = mathParam != null ? mathParam.getUnitIndex() : null;
                if (unitIndex != null) {
                    str15 = unitIndex.value2;
                    if ((j & 4299161604L) == 0) {
                        if (mathParam != null) {
                            str16 = str15;
                            j3 = mathParam.getThresholdCH3();
                        } else {
                            str16 = str15;
                            j3 = 0;
                        }
                        i5 = i4;
                        str17 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j3) + str14;
                    } else {
                        i5 = i4;
                        str16 = str15;
                        str17 = null;
                    }
                    String labelString = ((j & 4311744516L) != 0 || mathParam == null) ? null : mathParam.getLabelString();
                    if ((j & 4294969604L) == 0) {
                        ServiceEnum.Chan sourceLogicAIndex = mathParam != null ? mathParam.getSourceLogicAIndex() : null;
                        if ((j & 4294969348L) != 0) {
                            str18 = str17;
                            i10 = ColorUtil.getColor(getRoot().getContext(), sourceLogicAIndex);
                        } else {
                            str18 = str17;
                            i10 = 0;
                        }
                        if (sourceLogicAIndex != null) {
                            i12 = sourceLogicAIndex.value1;
                            i11 = i10;
                        } else {
                            i11 = i10;
                            i12 = 0;
                        }
                        MappingObject mappingObject8 = ViewUtil.getMappingObject(R.array.msg_math_s32logica, i12);
                        updateRegistration(8, mappingObject8);
                        str19 = mappingObject8 != null ? mappingObject8.getStr() : null;
                        i6 = i11;
                    } else {
                        str18 = str17;
                        str19 = null;
                        i6 = 0;
                    }
                    if ((j & 4295032836L) == 0) {
                        if (mathParam != null) {
                            i7 = i6;
                            laScale = mathParam.getLogicSizeIndex();
                        } else {
                            i7 = i6;
                            laScale = null;
                        }
                        boolean z22 = laScale == ServiceEnum.LaScale.Large;
                        z7 = laScale == ServiceEnum.LaScale.Small;
                        z11 = laScale == ServiceEnum.LaScale.Medium;
                        z10 = z22;
                    } else {
                        i7 = i6;
                        z10 = false;
                        z11 = false;
                        z7 = false;
                    }
                    if ((j & 4362076164L) == 0) {
                        if (mathParam != null) {
                            str20 = str12;
                            z12 = z10;
                            eWaveGrids = mathParam.getGrids();
                        } else {
                            z12 = z10;
                            str20 = str12;
                            eWaveGrids = null;
                        }
                        boolean z23 = eWaveGrids == ServiceEnum.EWaveGrids.GRID_IS_FULL;
                        z15 = eWaveGrids == ServiceEnum.EWaveGrids.GRID_IS_HALF;
                        z13 = eWaveGrids == ServiceEnum.EWaveGrids.GRID_IS_NONE;
                        z14 = z23;
                    } else {
                        z12 = z10;
                        str20 = str12;
                        z13 = false;
                        z14 = false;
                        z15 = false;
                    }
                    if ((j & 4303355908L) == 0) {
                        if (mathParam != null) {
                            z16 = z13;
                            z17 = z14;
                            j2 = mathParam.getThresholdCH4();
                        } else {
                            z16 = z13;
                            z17 = z14;
                            j2 = 0;
                        }
                        str21 = str13;
                        str22 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j2) + str14;
                    } else {
                        z16 = z13;
                        z17 = z14;
                        str21 = str13;
                        str22 = null;
                    }
                    if ((j & 4295016452L) == 0) {
                        str23 = str22;
                        String convert = UnitFormat.newBuilder(UnitFormat.SI.MILLI).convert((mathParam != null ? mathParam.getLogicOffset() : 0L) / 1000000);
                        StringBuilder sb = new StringBuilder();
                        sb.append(convert);
                        str24 = str16;
                        sb.append(str24);
                        str25 = sb.toString();
                    } else {
                        str23 = str22;
                        str24 = str16;
                        str25 = null;
                    }
                    if ((j & 4295229444L) == 0) {
                        z18 = mathParam != null ? mathParam.isZoomEn() : false;
                        f2 = ContextUtil.getAlpha(z18);
                    } else {
                        z18 = false;
                        f2 = 0.0f;
                    }
                    if ((j & 4295131140L) == 0) {
                        if (mathParam != null) {
                            str26 = str25;
                            i9 = mathParam.getSens();
                        } else {
                            str26 = str25;
                            i9 = 0;
                        }
                        z19 = z18;
                        str27 = labelString;
                        z20 = z11;
                        str28 = UnitFormat.newBuilder(UnitFormat.SI.MILLI).convert(i9) + str24;
                    } else {
                        str26 = str25;
                        z19 = z18;
                        str27 = labelString;
                        z20 = z11;
                        str28 = null;
                    }
                    if ((j & 4295491588L) != 0) {
                        if ((mathParam != null ? mathParam.getWaveType() : null) == ServiceEnum.MathWaveType.MathWave_Zoom) {
                            z21 = true;
                            if ((4296015876L & j) != 0) {
                                str29 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(mathParam != null ? mathParam.getThresholdCH1() : 0L) + str14;
                            } else {
                                str29 = null;
                            }
                            z4 = ((j & 4328521732L) != 0 || mathParam == null) ? false : mathParam.isLabel();
                            i8 = ((4294971396L & j) > 0L ? 1 : ((4294971396L & j) == 0L ? 0 : -1));
                            if (i8 != 0) {
                                boolean z24 = (mathParam != null ? mathParam.getOperator() : null) == ServiceEnum.MathOperator.operator_not;
                                if (i8 != 0) {
                                    j |= z24 ? 17179869184L : 8589934592L;
                                }
                                int i15 = z24 ? 8 : 0;
                                z8 = z21;
                                str7 = str29;
                                f = f2;
                                str9 = str19;
                                i = i5;
                                str3 = str18;
                                i3 = i7;
                                z2 = z12;
                                z5 = z15;
                                z6 = z17;
                                str = str27;
                                str8 = str21;
                                str2 = str23;
                                z9 = z19;
                                str5 = str28;
                                i2 = i15;
                                str6 = str26;
                                str4 = str20;
                                z = z16;
                                z3 = z20;
                            } else {
                                z8 = z21;
                                str7 = str29;
                                f = f2;
                                str9 = str19;
                                i = i5;
                                str3 = str18;
                                i3 = i7;
                                z2 = z12;
                                z5 = z15;
                                z6 = z17;
                                str = str27;
                                str8 = str21;
                                str2 = str23;
                                z9 = z19;
                                z3 = z20;
                                str5 = str28;
                                i2 = 0;
                                str6 = str26;
                                str4 = str20;
                                z = z16;
                            }
                        }
                    }
                    z21 = false;
                    if ((4296015876L & j) != 0) {
                    }
                    if ((j & 4328521732L) != 0) {
                    }
                    i8 = ((4294971396L & j) > 0L ? 1 : ((4294971396L & j) == 0L ? 0 : -1));
                    if (i8 != 0) {
                    }
                }
            }
            str15 = null;
            if ((j & 4299161604L) == 0) {
            }
            if ((j & 4311744516L) != 0) {
            }
            if ((j & 4294969604L) == 0) {
            }
            if ((j & 4295032836L) == 0) {
            }
            if ((j & 4362076164L) == 0) {
            }
            if ((j & 4303355908L) == 0) {
            }
            if ((j & 4295016452L) == 0) {
            }
            if ((j & 4295229444L) == 0) {
            }
            if ((j & 4295131140L) == 0) {
            }
            if ((j & 4295491588L) != 0) {
            }
            z21 = false;
            if ((4296015876L & j) != 0) {
            }
            if ((j & 4328521732L) != 0) {
            }
            i8 = ((4294971396L & j) > 0L ? 1 : ((4294971396L & j) == 0L ? 0 : -1));
            if (i8 != 0) {
            }
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            i = 0;
            i2 = 0;
            i3 = 0;
            z7 = false;
            z8 = false;
            z9 = false;
            f = 0.0f;
        }
        int i16 = ((j & 4429185032L) > 0L ? 1 : ((j & 4429185032L) == 0L ? 0 : -1));
        String str32 = (i16 == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        int i17 = ((j & 4563402768L) > 0L ? 1 : ((j & 4563402768L) == 0L ? 0 : -1));
        String str33 = (i17 == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        int i18 = ((j & 4831838240L) > 0L ? 1 : ((j & 4831838240L) == 0L ? 0 : -1));
        String str34 = (i18 == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        int i19 = ((j & 5368709184L) > 0L ? 1 : ((j & 5368709184L) == 0L ? 0 : -1));
        String str35 = (i19 == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        int i20 = ((j & 6442451072L) > 0L ? 1 : ((j & 6442451072L) == 0L ? 0 : -1));
        if (i20 != 0 && mappingObject6 != null) {
            str30 = mappingObject6.getStr();
        }
        String str36 = str30;
        if ((j & 4362076164L) != 0) {
            str10 = str32;
            CompoundButtonBindingAdapter.setChecked(this.fullRadioButton, z6);
            CompoundButtonBindingAdapter.setChecked(this.halfRadioButton, z5);
            CompoundButtonBindingAdapter.setChecked(this.noneRadioButton, z);
        } else {
            str10 = str32;
        }
        if ((4294968321L & j) != 0) {
            TextViewBindingAdapter.setText(this.fullRadioButton, str31);
        }
        if (i17 != 0) {
            TextViewBindingAdapter.setText(this.halfRadioButton, str33);
        }
        if ((j & 4311744516L) != 0) {
            TextViewBindingAdapter.setText(this.labelEditText, str);
        }
        if ((j & 4328521732L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.labelSwitch, z4);
        }
        if ((j & 4295032836L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.largeRadioButton, z2);
            CompoundButtonBindingAdapter.setChecked(this.mediumRadioButton, z3);
            CompoundButtonBindingAdapter.setChecked(this.smallRadioButton, z7);
        }
        if (i19 != 0) {
            TextViewBindingAdapter.setText(this.largeRadioButton, str35);
        }
        if (i20 != 0) {
            TextViewBindingAdapter.setText(this.mediumRadioButton, str36);
        }
        if (i18 != 0) {
            TextViewBindingAdapter.setText(this.noneRadioButton, str34);
        }
        if ((j & 4295016452L) != 0) {
            TextViewBindingAdapter.setText(this.offsetEditText, str6);
        }
        if ((j & 4295131140L) != 0) {
            TextViewBindingAdapter.setText(this.sensitivityEditText, str5);
        }
        if (i16 != 0) {
            TextViewBindingAdapter.setText(this.smallRadioButton, str10);
        }
        if ((j & 4294969604L) != 0) {
            TextViewBindingAdapter.setText(this.sourceASpinner, str9);
        }
        if ((j & 4294969348L) != 0) {
            this.sourceASpinner.setTextColor(i3);
        }
        if ((4294971396L & j) != 0) {
            int i21 = i2;
            this.sourceB.setVisibility(i21);
            this.sourceBSpinner.setVisibility(i21);
        }
        if ((j & 4294975494L) != 0) {
            TextViewBindingAdapter.setText(this.sourceBSpinner, str4);
        }
        if ((j & 4294975492L) != 0) {
            this.sourceBSpinner.setTextColor(i);
        }
        if ((4296015876L & j) != 0) {
            TextViewBindingAdapter.setText(this.thresholdCh1EditText, str7);
        }
        if ((j & 4297064452L) != 0) {
            TextViewBindingAdapter.setText(this.thresholdCh2EditText, str8);
        }
        if ((j & 4294967296L) != 0) {
            this.thresholdCh3.setVisibility(ViewUtil.isDoubleChanS() ? 8 : 0);
            this.thresholdCh3EditText.setVisibility(ViewUtil.isDoubleChanS() ? 8 : 0);
            this.thresholdCh4.setVisibility(ViewUtil.isDoubleChanS() ? 8 : 0);
            this.thresholdCh4EditText.setVisibility(ViewUtil.isDoubleChanS() ? 8 : 0);
        }
        if ((j & 4299161604L) != 0) {
            TextViewBindingAdapter.setText(this.thresholdCh3EditText, str3);
        }
        if ((j & 4303355908L) != 0) {
            TextViewBindingAdapter.setText(this.thresholdCh4EditText, str2);
        }
        if ((j & 4295229444L) != 0) {
            if (getBuildSdkInt() >= 11) {
                float f3 = f;
                this.waveType.setAlpha(f3);
                this.waveTypeSwitch.setAlpha(f3);
            }
            this.waveTypeSwitch.setEnabled(z9);
        }
        if ((j & 4295491588L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.waveTypeSwitch, z8);
        }
    }
}
