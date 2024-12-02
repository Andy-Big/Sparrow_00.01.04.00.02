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
public class AdapterMathArithBindingImpl extends AdapterMathArithBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.math_guideline_center, 15);
        sViewsWithIds.put(R.id.sourceA, 16);
        sViewsWithIds.put(R.id.sourceB, 17);
        sViewsWithIds.put(R.id.math_dividing_line, 18);
        sViewsWithIds.put(R.id.offset, 19);
        sViewsWithIds.put(R.id.math_offset_up, 20);
        sViewsWithIds.put(R.id.math_offset_down, 21);
        sViewsWithIds.put(R.id.scale, 22);
        sViewsWithIds.put(R.id.main_scale_vertical, 23);
        sViewsWithIds.put(R.id.main_scale_nomal, 24);
        sViewsWithIds.put(R.id.invert, 25);
        sViewsWithIds.put(R.id.auto_setting_btn, 26);
        sViewsWithIds.put(R.id.expand, 27);
        sViewsWithIds.put(R.id.expand_radio_group, 28);
        sViewsWithIds.put(R.id.label, 29);
        sViewsWithIds.put(R.id.grid_type, 30);
        sViewsWithIds.put(R.id.grid_type_radio_group, 31);
    }

    public AdapterMathArithBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 32, sIncludes, sViewsWithIds));
    }

    private AdapterMathArithBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (Button) objArr[26], (RadioButton) objArr[9], (TextView) objArr[27], (RadioGroup) objArr[28], (RadioButton) objArr[12], (RadioButton) objArr[8], (TextView) objArr[30], (RadioGroup) objArr[31], (RadioButton) objArr[13], (TextView) objArr[25], (SwitchButton) objArr[5], (TextView) objArr[29], (BaseEditText) objArr[10], (SwitchButton) objArr[11], (ImageButton) objArr[24], (ImageButton) objArr[23], (View) objArr[18], (Guideline) objArr[15], (ImageButton) objArr[21], (ImageButton) objArr[20], (RadioButton) objArr[14], (TextView) objArr[19], (EditText) objArr[3], (TextView) objArr[22], (EditText) objArr[4], (TextView) objArr[16], (TextView) objArr[1], (TextView) objArr[17], (TextView) objArr[2], (TextView) objArr[6], (SwitchButton) objArr[7]);
        this.mDirtyFlags = -1L;
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
        this.scaleEditText.setTag(null);
        this.sourceASpinner.setTag(null);
        this.sourceBSpinner.setTag(null);
        this.waveType.setTag(null);
        this.waveTypeSwitch.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 67108864L;
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

    @Override // com.rigol.scope.databinding.AdapterMathArithBinding
    public void setGridFullMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mGridFullMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(358);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathArithBinding
    public void setParam(MathParam mathParam) {
        updateRegistration(1, mathParam);
        this.mParam = mathParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathArithBinding
    public void setGridHalfMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mGridHalfMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(359);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathArithBinding
    public void setGridNoneMapping(MappingObject mappingObject) {
        updateRegistration(3, mappingObject);
        this.mGridNoneMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(361);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathArithBinding
    public void setItemPosition(Integer num) {
        this.mItemPosition = num;
    }

    @Override // com.rigol.scope.databinding.AdapterMathArithBinding
    public void setCenterMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mCenterMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathArithBinding
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
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgMathS32arithbParamSourceArithBIndexValue1((MappingObject) obj, i2);
            case 7:
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
                this.mDirtyFlags |= 512;
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
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 864) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 565) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 988) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 774) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 444) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 1089) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 1039) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 288) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 477) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 475) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 363) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
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
                this.mDirtyFlags |= 4194304;
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
                this.mDirtyFlags |= 8388608;
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
                this.mDirtyFlags |= 16777216;
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
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgMathS32arithbParamSourceArithBIndexValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgMathS32arithaParamSourceArithAIndexValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01f6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0205 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0161  */
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
        boolean z6;
        boolean z7;
        int i2;
        int i3;
        boolean z8;
        boolean z9;
        String str;
        float f;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        String str9;
        long j2;
        int i4;
        String str10;
        int i5;
        String str11;
        long j3;
        int i6;
        String str12;
        boolean z17;
        float f2;
        String str13;
        int i7;
        boolean z18;
        ServiceEnum.MathWaveType mathWaveType;
        int i8;
        ServiceEnum.Chan chan;
        int i9;
        long j4;
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
        int i10 = ((67109377 & j) > 0L ? 1 : ((67109377 & j) == 0L ? 0 : -1));
        String str14 = (i10 == 0 || mappingObject == null) ? null : mappingObject.getStr();
        boolean z19 = false;
        if ((71302338 & j) != 0) {
            if ((j & 67137538) != 0) {
                ServiceEnum.Unit unitIndex = mathParam != null ? mathParam.getUnitIndex() : null;
                if (unitIndex != null) {
                    str7 = unitIndex.value2;
                    String labelString = ((j & 67633154) != 0 || mathParam == null) ? null : mathParam.getLabelString();
                    if ((j & 67133442) == 0) {
                        if (mathParam != null) {
                            i = i10;
                            j4 = mathParam.getScale();
                        } else {
                            i = i10;
                            j4 = 0;
                        }
                        str8 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j4) + str7;
                    } else {
                        i = i10;
                        str8 = null;
                    }
                    if ((j & 67371010) == 0) {
                        ServiceEnum.VertExpand expandIndex = mathParam != null ? mathParam.getExpandIndex() : null;
                        z11 = expandIndex == ServiceEnum.VertExpand.vert_expand_center;
                        z10 = expandIndex == ServiceEnum.VertExpand.vert_expand_gnd;
                    } else {
                        z10 = false;
                        z11 = false;
                    }
                    if ((j & 69206018) == 0) {
                        ServiceEnum.EWaveGrids grids = mathParam != null ? mathParam.getGrids() : null;
                        boolean z20 = grids == ServiceEnum.EWaveGrids.GRID_IS_FULL;
                        boolean z21 = grids == ServiceEnum.EWaveGrids.GRID_IS_HALF;
                        boolean z22 = grids == ServiceEnum.EWaveGrids.GRID_IS_NONE;
                        z14 = z21;
                        z13 = z22;
                        z12 = z20;
                    } else {
                        z12 = false;
                        z13 = false;
                        z14 = false;
                    }
                    if ((j & 67110018) == 0) {
                        if (mathParam != null) {
                            z15 = z12;
                            chan = mathParam.getSourceArithAIndex();
                        } else {
                            z15 = z12;
                            chan = null;
                        }
                        z16 = z13;
                        if (chan != null) {
                            i9 = chan.value1;
                            str9 = str8;
                        } else {
                            str9 = str8;
                            i9 = 0;
                        }
                        MappingObject mappingObject6 = ViewUtil.getMappingObject(R.array.msg_math_s32aritha, i9);
                        updateRegistration(7, mappingObject6);
                        str10 = mappingObject6 != null ? mappingObject6.getStr() : null;
                        j2 = 0;
                        i4 = (j & 67109890) != 0 ? ColorUtil.getColor(getRoot().getContext(), chan) : 0;
                    } else {
                        z15 = z12;
                        z16 = z13;
                        str9 = str8;
                        j2 = 0;
                        i4 = 0;
                        str10 = null;
                    }
                    if ((j & 67110978) == j2) {
                        ServiceEnum.Chan sourceArithBIndex = mathParam != null ? mathParam.getSourceArithBIndex() : null;
                        i5 = i4;
                        if (sourceArithBIndex != null) {
                            i8 = sourceArithBIndex.value1;
                            str11 = str10;
                        } else {
                            str11 = str10;
                            i8 = 0;
                        }
                        MappingObject mappingObject7 = ViewUtil.getMappingObject(R.array.msg_math_s32arithb, i8);
                        updateRegistration(6, mappingObject7);
                        str12 = mappingObject7 != null ? mappingObject7.getStr() : null;
                        j3 = 0;
                        i6 = (j & 67110914) != 0 ? ColorUtil.getColor(getRoot().getContext(), sourceArithBIndex) : 0;
                    } else {
                        i5 = i4;
                        str11 = str10;
                        j3 = 0;
                        i6 = 0;
                        str12 = null;
                    }
                    if ((j & 67174402) == j3) {
                        boolean isZoomEn = mathParam != null ? mathParam.isZoomEn() : false;
                        z17 = isZoomEn;
                        f2 = ContextUtil.getAlpha(isZoomEn);
                    } else {
                        z17 = false;
                        f2 = 0.0f;
                    }
                    if ((j & 67239938) == j3) {
                        if (mathParam != null) {
                            i7 = i6;
                            str13 = str12;
                            mathWaveType = mathParam.getWaveType();
                        } else {
                            str13 = str12;
                            i7 = i6;
                            mathWaveType = null;
                        }
                        if (mathWaveType == ServiceEnum.MathWaveType.MathWave_Zoom) {
                            z18 = true;
                            boolean invert = ((j & 67141634) != 0 || mathParam == null) ? false : mathParam.getInvert();
                            if ((j & 68157442) != 0 && mathParam != null) {
                                z19 = mathParam.isLabel();
                            }
                            if ((j & 67121154) != 0) {
                                boolean z23 = invert;
                                String str15 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(mathParam != null ? mathParam.getOffset() : 0L) + str7;
                                z6 = z11;
                                z9 = z17;
                                z8 = z18;
                                z = z16;
                                str4 = str9;
                                i2 = i5;
                                i3 = i7;
                                z2 = z23;
                                str5 = str15;
                                z5 = z10;
                                z4 = z14;
                                z7 = z15;
                                str = labelString;
                                str3 = str11;
                            } else {
                                boolean z24 = invert;
                                z6 = z11;
                                str = labelString;
                                z9 = z17;
                                z8 = z18;
                                z = z16;
                                str4 = str9;
                                i2 = i5;
                                str3 = str11;
                                i3 = i7;
                                z2 = z24;
                                str5 = null;
                                z5 = z10;
                                z4 = z14;
                                z7 = z15;
                            }
                            f = f2;
                            z3 = z19;
                            str2 = str13;
                        }
                    } else {
                        str13 = str12;
                        i7 = i6;
                    }
                    z18 = false;
                    if ((j & 67141634) != 0) {
                    }
                    if ((j & 68157442) != 0) {
                        z19 = mathParam.isLabel();
                    }
                    if ((j & 67121154) != 0) {
                    }
                    f = f2;
                    z3 = z19;
                    str2 = str13;
                }
            }
            str7 = null;
            if ((j & 67633154) != 0) {
            }
            if ((j & 67133442) == 0) {
            }
            if ((j & 67371010) == 0) {
            }
            if ((j & 69206018) == 0) {
            }
            if ((j & 67110018) == 0) {
            }
            if ((j & 67110978) == j2) {
            }
            if ((j & 67174402) == j3) {
            }
            if ((j & 67239938) == j3) {
            }
            z18 = false;
            if ((j & 67141634) != 0) {
            }
            if ((j & 68157442) != 0) {
            }
            if ((j & 67121154) != 0) {
            }
            f = f2;
            z3 = z19;
            str2 = str13;
        } else {
            i = i10;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
            i2 = 0;
            i3 = 0;
            z8 = false;
            z9 = false;
            str = null;
            f = 0.0f;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
        }
        int i11 = ((j & 71303172) > 0L ? 1 : ((j & 71303172) == 0L ? 0 : -1));
        String str16 = (i11 == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        int i12 = ((j & 75497480) > 0L ? 1 : ((j & 75497480) == 0L ? 0 : -1));
        String str17 = (i12 == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        int i13 = ((j & 83886096) > 0L ? 1 : ((j & 83886096) == 0L ? 0 : -1));
        String str18 = (i13 == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        int i14 = ((j & 100663328) > 0L ? 1 : ((j & 100663328) == 0L ? 0 : -1));
        String str19 = (i14 == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        if ((j & 67371010) != 0) {
            str6 = str17;
            CompoundButtonBindingAdapter.setChecked(this.centerRadioButton, z6);
            CompoundButtonBindingAdapter.setChecked(this.gndRadioButton, z5);
        } else {
            str6 = str17;
        }
        if (i13 != 0) {
            TextViewBindingAdapter.setText(this.centerRadioButton, str18);
        }
        if ((j & 69206018) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.fullRadioButton, z7);
            CompoundButtonBindingAdapter.setChecked(this.halfRadioButton, z4);
            CompoundButtonBindingAdapter.setChecked(this.noneRadioButton, z);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.fullRadioButton, str14);
        }
        if (i14 != 0) {
            TextViewBindingAdapter.setText(this.gndRadioButton, str19);
        }
        if (i11 != 0) {
            TextViewBindingAdapter.setText(this.halfRadioButton, str16);
        }
        if ((j & 67141634) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.invertSwitch, z2);
        }
        if ((j & 67633154) != 0) {
            TextViewBindingAdapter.setText(this.labelEditText, str);
        }
        if ((j & 68157442) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.labelSwitch, z3);
        }
        if (i12 != 0) {
            TextViewBindingAdapter.setText(this.noneRadioButton, str6);
        }
        if ((67121154 & j) != 0) {
            TextViewBindingAdapter.setText(this.offsetEditText, str5);
        }
        if ((j & 67133442) != 0) {
            TextViewBindingAdapter.setText(this.scaleEditText, str4);
        }
        if ((j & 67110018) != 0) {
            TextViewBindingAdapter.setText(this.sourceASpinner, str3);
        }
        if ((j & 67109890) != 0) {
            this.sourceASpinner.setTextColor(i2);
        }
        if ((j & 67110978) != 0) {
            TextViewBindingAdapter.setText(this.sourceBSpinner, str2);
        }
        if ((j & 67110914) != 0) {
            this.sourceBSpinner.setTextColor(i3);
        }
        if ((j & 67174402) != 0) {
            if (getBuildSdkInt() >= 11) {
                float f3 = f;
                this.waveType.setAlpha(f3);
                this.waveTypeSwitch.setAlpha(f3);
            }
            this.waveTypeSwitch.setEnabled(z9);
        }
        if ((j & 67239938) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.waveTypeSwitch, z8);
        }
    }
}
