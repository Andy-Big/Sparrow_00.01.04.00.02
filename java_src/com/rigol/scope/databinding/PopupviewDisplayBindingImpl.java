package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.DisplayParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;

/* loaded from: classes2.dex */
public class PopupviewDisplayBindingImpl extends PopupviewDisplayBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.type, 21);
        sViewsWithIds.put(R.id.type_radio_group, 22);
        sViewsWithIds.put(R.id.persis_time, 23);
        sViewsWithIds.put(R.id.wave_intensity, 24);
        sViewsWithIds.put(R.id.grid_type, 25);
        sViewsWithIds.put(R.id.grid_type_radio_group, 26);
        sViewsWithIds.put(R.id.grid_intensity, 27);
        sViewsWithIds.put(R.id.popup_view_bg_alpha, 28);
        sViewsWithIds.put(R.id.c_view_bg_alpha, 29);
    }

    public PopupviewDisplayBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 30, sIncludes, sViewsWithIds));
    }

    private PopupviewDisplayBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (TextView) objArr[19], (TextView) objArr[29], (SeekBar) objArr[18], (RadioButton) objArr[2], (TextView) objArr[15], (SwitchButton) objArr[16], (RadioButton) objArr[6], (TextView) objArr[27], (SeekBar) objArr[9], (TextView) objArr[10], (TextView) objArr[25], (RadioGroup) objArr[26], (RadioButton) objArr[7], (RadioButton) objArr[8], (TextView) objArr[13], (SwitchButton) objArr[14], (TextView) objArr[23], (TextView) objArr[3], (TextView) objArr[28], (SeekBar) objArr[17], (TextView) objArr[20], (TextView) objArr[11], (SwitchButton) objArr[12], (TextView) objArr[21], (RadioGroup) objArr[22], (RadioButton) objArr[1], (TextView) objArr[24], (SeekBar) objArr[4], (TextView) objArr[5]);
        this.mDirtyFlags = -1L;
        this.cIntensityText.setTag(null);
        this.cViewBgAlphaSeekbar.setTag(null);
        this.dotsRadioButton.setTag(null);
        this.freeze.setTag(null);
        this.freezeSwitchButton.setTag(null);
        this.fullRadioButton.setTag(null);
        this.gridIntensitySeekbar.setTag(null);
        this.gridIntensityText.setTag(null);
        this.halfRadioButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.noneRadioButton.setTag(null);
        this.palette.setTag(null);
        this.paletteSwitchButton.setTag(null);
        this.persisTimeText.setTag(null);
        this.popupViewBgAlphaSeekbar.setTag(null);
        this.popupViewBgAlphaText.setTag(null);
        this.ruler.setTag(null);
        this.rulerSwitchButton.setTag(null);
        this.vectorRadioButton.setTag(null);
        this.waveIntensitySeekbar.setTag(null);
        this.waveIntensityText.setTag(null);
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
        } else if (378 == i) {
            setHori((HorizontalParam) obj);
        } else if (983 == i) {
            setTypeVectorMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((DisplayParam) obj);
        } else if (359 == i) {
            setGridHalfMapping((MappingObject) obj);
        } else if (361 == i) {
            setGridNoneMapping((MappingObject) obj);
        } else if (980 != i) {
            return false;
        } else {
            setTypeDptsMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewDisplayBinding
    public void setGridFullMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mGridFullMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(358);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewDisplayBinding
    public void setHori(HorizontalParam horizontalParam) {
        updateRegistration(1, horizontalParam);
        this.mHori = horizontalParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(378);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewDisplayBinding
    public void setTypeVectorMapping(MappingObject mappingObject) {
        updateRegistration(3, mappingObject);
        this.mTypeVectorMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(983);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewDisplayBinding
    public void setParam(DisplayParam displayParam) {
        updateRegistration(4, displayParam);
        this.mParam = displayParam;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewDisplayBinding
    public void setGridHalfMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mGridHalfMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(359);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewDisplayBinding
    public void setGridNoneMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mGridNoneMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(361);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewDisplayBinding
    public void setTypeDptsMapping(MappingObject mappingObject) {
        updateRegistration(7, mappingObject);
        this.mTypeDptsMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(980);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeGridFullMapping((MappingObject) obj, i2);
            case 1:
                return onChangeHori((HorizontalParam) obj, i2);
            case 2:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDisplayPersistimeParamPersisTimeValue1((MappingObject) obj, i2);
            case 3:
                return onChangeTypeVectorMapping((MappingObject) obj, i2);
            case 4:
                return onChangeParam((DisplayParam) obj, i2);
            case 5:
                return onChangeGridHalfMapping((MappingObject) obj, i2);
            case 6:
                return onChangeGridNoneMapping((MappingObject) obj, i2);
            case 7:
                return onChangeTypeDptsMapping((MappingObject) obj, i2);
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

    private boolean onChangeHori(HorizontalParam horizontalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 935) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 28) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDisplayPersistimeParamPersisTimeValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
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

    private boolean onChangeTypeVectorMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
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

    private boolean onChangeParam(DisplayParam displayParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 978) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 619) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 593) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 1038) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 362) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 360) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 759) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 1037) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 1079) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 208) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeGridHalfMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    private boolean onChangeGridNoneMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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

    private boolean onChangeTypeDptsMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
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

    /* JADX WARN: Removed duplicated region for block: B:105:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01a5  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        float f;
        float f2;
        boolean z;
        boolean z2;
        String str;
        String str2;
        boolean z3;
        float f3;
        float f4;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i;
        boolean z8;
        boolean z9;
        int i2;
        int i3;
        int i4;
        boolean z10;
        boolean z11;
        boolean z12;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        float f5;
        boolean z13;
        boolean z14;
        String str9;
        String str10;
        int i5;
        String str11;
        boolean z15;
        int i6;
        String str12;
        int i7;
        String str13;
        String str14;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        int i8;
        int i9;
        String str15;
        String str16;
        int i10;
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        ServiceEnum.EWaveGrids eWaveGrids;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mGridFullMapping;
        HorizontalParam horizontalParam = this.mHori;
        MappingObject mappingObject2 = this.mTypeVectorMapping;
        DisplayParam displayParam = this.mParam;
        MappingObject mappingObject3 = this.mGridHalfMapping;
        MappingObject mappingObject4 = this.mGridNoneMapping;
        MappingObject mappingObject5 = this.mTypeDptsMapping;
        String str17 = ((j & 67109121) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        if ((j & 67110402) != 0) {
            if ((j & 67109378) != 0) {
                z2 = (horizontalParam != null ? horizontalParam.getTimeMode() : null) != ServiceEnum.HoriTimeMode.Horizontal_ROLL;
                f = ContextUtil.getAlpha(z2);
            } else {
                f = 0.0f;
                z2 = false;
            }
            if ((j & 67109890) != 0) {
                ServiceEnum.AcquireMode acquireMode = horizontalParam != null ? horizontalParam.getAcquireMode() : null;
                z = (acquireMode != null ? acquireMode.value1 : 0) != ServiceEnum.AcquireMode.Acquire_Ultra.value1;
                f2 = ContextUtil.getAlpha(z);
            } else {
                f2 = 0.0f;
                z = false;
            }
        } else {
            f = 0.0f;
            f2 = 0.0f;
            z = false;
            z2 = false;
        }
        String str18 = ((j & 67112968) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        if ((j & 75491348) != 0) {
            int i11 = ((j & 67141648) > 0L ? 1 : ((j & 67141648) == 0L ? 0 : -1));
            if (i11 != 0) {
                z13 = displayParam != null ? displayParam.getPaletteEnable() : false;
                if (i11 != 0) {
                    if (z13) {
                        j2 = j | 268435456;
                        j3 = 1073741824;
                    } else {
                        j2 = j | 134217728;
                        j3 = 536870912;
                    }
                    j = j2 | j3;
                }
                f5 = z13 ? 0.5f : 1.0f;
                z14 = !z13;
            } else {
                f5 = 0.0f;
                z13 = false;
                z14 = false;
            }
            if ((j & 67127316) != 0) {
                ServiceEnum.EWavePersis persisTime = displayParam != null ? displayParam.getPersisTime() : null;
                MappingObject mappingObject6 = ViewUtil.getMappingObject(R.array.msg_display_persistime, persisTime != null ? persisTime.value1 : 0);
                updateRegistration(2, mappingObject6);
                if (mappingObject6 != null) {
                    str9 = mappingObject6.getStr();
                    if ((j & 67371024) == 0) {
                        i5 = displayParam != null ? displayParam.getGridIntensity() : 0;
                        str10 = str9;
                        str = str18;
                        str11 = this.gridIntensityText.getResources().getString(R.string.percent_hodler, Integer.valueOf(i5));
                    } else {
                        str10 = str9;
                        str = str18;
                        i5 = 0;
                        str11 = null;
                    }
                    boolean waveFreeze = ((j & 68157456) != 0 || displayParam == null) ? false : displayParam.getWaveFreeze();
                    if ((j & 71303184) == 0) {
                        if (displayParam != null) {
                            i7 = displayParam.getCursorsIntensity();
                            z15 = waveFreeze;
                        } else {
                            z15 = waveFreeze;
                            i7 = 0;
                        }
                        i6 = i5;
                        str12 = str11;
                        str13 = this.cIntensityText.getResources().getString(R.string.percent_hodler, Integer.valueOf(i7));
                    } else {
                        z15 = waveFreeze;
                        i6 = i5;
                        str12 = str11;
                        i7 = 0;
                        str13 = null;
                    }
                    if ((j & 67117072) == 0) {
                        ServiceEnum.EWaveFormat type = displayParam != null ? displayParam.getType() : null;
                        str14 = str13;
                        z17 = type == ServiceEnum.EWaveFormat.FORMAT_IS_DOTS;
                        z16 = type == ServiceEnum.EWaveFormat.FORMAT_IS_VECTOR;
                    } else {
                        str14 = str13;
                        z16 = false;
                        z17 = false;
                    }
                    if ((j & 69206032) == 0) {
                        if (displayParam != null) {
                            i9 = displayParam.getWindowTransparency();
                            z18 = z16;
                        } else {
                            z18 = z16;
                            i9 = 0;
                        }
                        z19 = z17;
                        i8 = i7;
                        str15 = this.popupViewBgAlphaText.getResources().getString(R.string.percent_hodler, Integer.valueOf(i9));
                    } else {
                        z18 = z16;
                        z19 = z17;
                        i8 = i7;
                        i9 = 0;
                        str15 = null;
                    }
                    boolean rulerEnable = ((j & 67633168) != 0 || displayParam == null) ? false : displayParam.getRulerEnable();
                    if ((j & 67239952) == 0) {
                        if (displayParam != null) {
                            eWaveGrids = displayParam.getGridType();
                            str16 = str15;
                        } else {
                            str16 = str15;
                            eWaveGrids = null;
                        }
                        i10 = i9;
                        boolean z24 = eWaveGrids != ServiceEnum.EWaveGrids.GRID_IS_HALF;
                        z20 = rulerEnable;
                        boolean z25 = eWaveGrids != ServiceEnum.EWaveGrids.GRID_IS_NONE;
                        z23 = eWaveGrids == ServiceEnum.EWaveGrids.GRID_IS_HALF;
                        z22 = eWaveGrids == ServiceEnum.EWaveGrids.GRID_IS_NONE;
                        z21 = z24 & z25;
                    } else {
                        str16 = str15;
                        i10 = i9;
                        z20 = rulerEnable;
                        z21 = false;
                        z22 = false;
                        z23 = false;
                    }
                    if ((j & 67174416) == 0) {
                        int waveIntensity = displayParam != null ? displayParam.getWaveIntensity() : 0;
                        long j4 = j;
                        String string = this.waveIntensityText.getResources().getString(R.string.percent_hodler, Integer.valueOf(waveIntensity));
                        z9 = z21;
                        i4 = waveIntensity;
                        z5 = z22;
                        z11 = z13;
                        f4 = f5;
                        z12 = z14;
                        str5 = str10;
                        z7 = z15;
                        i2 = i6;
                        str7 = str12;
                        str3 = str14;
                        z6 = z18;
                        str6 = str16;
                        i3 = i10;
                        z10 = z20;
                        str2 = str17;
                        str4 = string;
                        z3 = z2;
                        f3 = f;
                        z8 = z19;
                        i = i8;
                        z4 = z23;
                        j = j4;
                    } else {
                        z9 = z21;
                        z5 = z22;
                        z11 = z13;
                        i4 = 0;
                        f4 = f5;
                        z12 = z14;
                        str5 = str10;
                        z7 = z15;
                        i2 = i6;
                        str7 = str12;
                        str3 = str14;
                        z6 = z18;
                        str6 = str16;
                        i3 = i10;
                        z10 = z20;
                        str4 = null;
                        str2 = str17;
                        z3 = z2;
                        f3 = f;
                        z8 = z19;
                        i = i8;
                        z4 = z23;
                    }
                }
            }
            str9 = null;
            if ((j & 67371024) == 0) {
            }
            if ((j & 68157456) != 0) {
            }
            if ((j & 71303184) == 0) {
            }
            if ((j & 67117072) == 0) {
            }
            if ((j & 69206032) == 0) {
            }
            if ((j & 67633168) != 0) {
            }
            if ((j & 67239952) == 0) {
            }
            if ((j & 67174416) == 0) {
            }
        } else {
            str = str18;
            str2 = str17;
            z3 = z2;
            f3 = f;
            f4 = 0.0f;
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
            i = 0;
            z8 = false;
            z9 = false;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            z10 = false;
            z11 = false;
            z12 = false;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
        }
        int i12 = ((j & 75497504) > 0L ? 1 : ((j & 75497504) == 0L ? 0 : -1));
        String str19 = (i12 == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        int i13 = ((j & 83886144) > 0L ? 1 : ((j & 83886144) == 0L ? 0 : -1));
        String str20 = (i13 == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        int i14 = ((j & 100663424) > 0L ? 1 : ((j & 100663424) == 0L ? 0 : -1));
        String str21 = (i14 == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        if ((j & 71303184) != 0) {
            str8 = str20;
            TextViewBindingAdapter.setText(this.cIntensityText, str3);
            SeekBarBindingAdapter.setProgress(this.cViewBgAlphaSeekbar, i);
        } else {
            str8 = str20;
        }
        if ((j & 67108864) != 0 && getBuildSdkInt() >= 11) {
            this.dotsRadioButton.setAlpha(ContextUtil.getAlpha(false));
        }
        if ((j & 67117072) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.dotsRadioButton, z8);
            CompoundButtonBindingAdapter.setChecked(this.vectorRadioButton, z6);
        }
        if (i14 != 0) {
            TextViewBindingAdapter.setText(this.dotsRadioButton, str21);
        }
        if ((j & 67109890) != 0) {
            this.freeze.setEnabled(z);
            this.freezeSwitchButton.setEnabled(z);
            this.palette.setEnabled(z);
            this.paletteSwitchButton.setEnabled(z);
            this.ruler.setEnabled(z);
            this.rulerSwitchButton.setEnabled(z);
            if (getBuildSdkInt() >= 11) {
                this.freeze.setAlpha(f2);
                this.freezeSwitchButton.setAlpha(f2);
                this.palette.setAlpha(f2);
                this.paletteSwitchButton.setAlpha(f2);
                this.ruler.setAlpha(f2);
                this.rulerSwitchButton.setAlpha(f2);
            }
        }
        if ((j & 68157456) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.freezeSwitchButton, z7);
        }
        if ((j & 67239952) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.fullRadioButton, z9);
            CompoundButtonBindingAdapter.setChecked(this.halfRadioButton, z4);
            CompoundButtonBindingAdapter.setChecked(this.noneRadioButton, z5);
        }
        if ((67109121 & j) != 0) {
            TextViewBindingAdapter.setText(this.fullRadioButton, str2);
        }
        if ((j & 67371024) != 0) {
            SeekBarBindingAdapter.setProgress(this.gridIntensitySeekbar, i2);
            TextViewBindingAdapter.setText(this.gridIntensityText, str7);
        }
        if (i12 != 0) {
            TextViewBindingAdapter.setText(this.halfRadioButton, str19);
        }
        if (i13 != 0) {
            TextViewBindingAdapter.setText(this.noneRadioButton, str8);
        }
        if ((j & 67141648) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.paletteSwitchButton, z11);
            this.waveIntensitySeekbar.setEnabled(z12);
            if (getBuildSdkInt() >= 11) {
                this.waveIntensitySeekbar.setAlpha(f4);
            }
        }
        if ((j & 67127316) != 0) {
            TextViewBindingAdapter.setText(this.persisTimeText, str5);
        }
        if ((j & 67109378) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.persisTimeText.setAlpha(f3);
            }
            this.persisTimeText.setEnabled(z3);
        }
        if ((j & 69206032) != 0) {
            SeekBarBindingAdapter.setProgress(this.popupViewBgAlphaSeekbar, i3);
            TextViewBindingAdapter.setText(this.popupViewBgAlphaText, str6);
        }
        if ((j & 67633168) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.rulerSwitchButton, z10);
        }
        if ((j & 67112968) != 0) {
            TextViewBindingAdapter.setText(this.vectorRadioButton, str);
        }
        if ((j & 67174416) != 0) {
            SeekBarBindingAdapter.setProgress(this.waveIntensitySeekbar, i4);
            TextViewBindingAdapter.setText(this.waveIntensityText, str4);
        }
    }
}
