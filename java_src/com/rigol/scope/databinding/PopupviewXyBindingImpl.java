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
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.BaseProperty;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.data.XYParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.TouchableSeekBar;

/* loaded from: classes2.dex */
public class PopupviewXyBindingImpl extends PopupviewXyBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.math_guideline_center, 27);
        sViewsWithIds.put(R.id.grid_type, 28);
        sViewsWithIds.put(R.id.grid_type_radio_group, 29);
    }

    public PopupviewXyBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 30, sIncludes, sViewsWithIds));
    }

    private PopupviewXyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 16, (TextView) objArr[7], (TextView) objArr[10], (TextView) objArr[12], (TouchableSeekBar) objArr[11], (TextView) objArr[9], (TouchableSeekBar) objArr[8], (TextView) objArr[19], (SwitchButton) objArr[20], (RadioButton) objArr[24], (TextView) objArr[28], (RadioGroup) objArr[29], (RadioButton) objArr[25], (TextView) objArr[16], (TextView) objArr[18], (TouchableSeekBar) objArr[17], (Guideline) objArr[27], (RadioButton) objArr[26], (TextView) objArr[21], (TouchableSeekBar) objArr[22], (TextView) objArr[23], (TextView) objArr[5], (SwitchButton) objArr[6], (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[13], (TextView) objArr[15], (TouchableSeekBar) objArr[14]);
        this.mDirtyFlags = -1L;
        this.afterglow.setTag(null);
        this.afterglowInframe.setTag(null);
        this.afterglowInframePercent.setTag(null);
        this.afterglowInframeSeekBar.setTag(null);
        this.afterglowPercent.setTag(null);
        this.afterglowSeekBar.setTag(null);
        this.autoCompression.setTag(null);
        this.autoCompressionSwitchButton.setTag(null);
        this.fullRadioButton.setTag(null);
        this.halfRadioButton.setTag(null);
        this.intensity.setTag(null);
        this.intensityPercent.setTag(null);
        this.intensitySeekBar.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.noneRadioButton.setTag(null);
        this.samplerate.setTag(null);
        this.samplerateSeekBar.setTag(null);
        this.samplerateText.setTag(null);
        this.settingADV.setTag(null);
        this.settingADVSwitchButton.setTag(null);
        this.sourceA.setTag(null);
        this.sourceASpinner.setTag(null);
        this.sourceB.setTag(null);
        this.sourceBSpinner.setTag(null);
        this.waveformSize.setTag(null);
        this.waveformSizePercent.setTag(null);
        this.waveformSizeSeekBar.setTag(null);
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
        } else if (1013 == i) {
            setUtilityParam((UtilityParam) obj);
        } else if (359 == i) {
            setGridHalfMapping((MappingObject) obj);
        } else if (1084 == i) {
            setXyParam((XYParam) obj);
        } else if (361 == i) {
            setGridNoneMapping((MappingObject) obj);
        } else if (1077 != i) {
            return false;
        } else {
            setWindowParam((WindowParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewXyBinding
    public void setGridFullMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mGridFullMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(358);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewXyBinding
    public void setUtilityParam(UtilityParam utilityParam) {
        updateRegistration(3, utilityParam);
        this.mUtilityParam = utilityParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(1013);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewXyBinding
    public void setGridHalfMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mGridHalfMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(359);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewXyBinding
    public void setXyParam(XYParam xYParam) {
        updateRegistration(6, xYParam);
        this.mXyParam = xYParam;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(1084);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewXyBinding
    public void setGridNoneMapping(MappingObject mappingObject) {
        updateRegistration(7, mappingObject);
        this.mGridNoneMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(361);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewXyBinding
    public void setWindowParam(WindowParam windowParam) {
        updateRegistration(12, windowParam);
        this.mWindowParam = windowParam;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(1077);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeGridFullMapping((MappingObject) obj, i2);
            case 1:
                return onChangeXyParamWaveWidth((BaseProperty) obj, i2);
            case 2:
                return onChangeXyParamGrids((BaseProperty) obj, i2);
            case 3:
                return onChangeUtilityParam((UtilityParam) obj, i2);
            case 4:
                return onChangeXyParamWaveIntensity((BaseProperty) obj, i2);
            case 5:
                return onChangeGridHalfMapping((MappingObject) obj, i2);
            case 6:
                return onChangeXyParam((XYParam) obj, i2);
            case 7:
                return onChangeGridNoneMapping((MappingObject) obj, i2);
            case 8:
                return onChangeXyParamFramePersist((BaseProperty) obj, i2);
            case 9:
                return onChangeXyParamAdvSetting((BaseProperty) obj, i2);
            case 10:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanListWindowParamSource2Value1((MappingObject) obj, i2);
            case 11:
                return onChangeXyParamPersistTime((BaseProperty) obj, i2);
            case 12:
                return onChangeWindowParam((WindowParam) obj, i2);
            case 13:
                return onChangeXyParamAutoCompression((BaseProperty) obj, i2);
            case 14:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanListWindowParamSource1Value1((MappingObject) obj, i2);
            case 15:
                return onChangeXyParamCompressionRatio((BaseProperty) obj, i2);
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
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeXyParamWaveWidth(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeXyParamGrids(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeUtilityParam(UtilityParam utilityParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 677) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeXyParamWaveIntensity(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
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
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeXyParam(XYParam xYParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeGridNoneMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
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

    private boolean onChangeXyParamFramePersist(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeXyParamAdvSetting(BaseProperty<Boolean> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanListWindowParamSource2Value1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
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

    private boolean onChangeXyParamPersistTime(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeWindowParam(WindowParam windowParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 859) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else if (i == 860) {
            synchronized (this) {
                this.mDirtyFlags |= 268435456;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeXyParamAutoCompression(BaseProperty<Boolean> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 536870912;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanListWindowParamSource1Value1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
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

    private boolean onChangeXyParamCompressionRatio(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 2147483648L;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0570  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x057d  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x058a  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x05af  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x05e8  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0606  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0617  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0624  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0635  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0642  */
    /* JADX WARN: Removed duplicated region for block: B:271:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        float f;
        boolean z;
        String str;
        String str2;
        boolean z2;
        float f2;
        boolean z3;
        int i;
        boolean z4;
        int i2;
        boolean z5;
        boolean z6;
        boolean z7;
        int i3;
        int i4;
        int i5;
        int i6;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z8;
        String str8;
        int i7;
        int i8;
        int i9;
        String str9;
        String str10;
        int i10;
        int i11;
        int i12;
        int i13;
        long j2;
        int i14;
        ServiceEnum.Chan chan;
        int i15;
        int i16;
        int i17;
        String str11;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int i18;
        String str12;
        String str13;
        int i19;
        String str14;
        String str15;
        int i20;
        boolean z14;
        boolean z15;
        int i21;
        String str16;
        int i22;
        String str17;
        boolean z16;
        int i23;
        long j3;
        BaseProperty<Integer> baseProperty;
        BaseProperty<Boolean> baseProperty2;
        int i24;
        BaseProperty<Integer> baseProperty3;
        BaseProperty<Boolean> baseProperty4;
        int i25;
        BaseProperty<Integer> baseProperty5;
        BaseProperty<Integer> baseProperty6;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mGridFullMapping;
        UtilityParam utilityParam = this.mUtilityParam;
        MappingObject mappingObject2 = this.mGridHalfMapping;
        XYParam xYParam = this.mXyParam;
        MappingObject mappingObject3 = this.mGridNoneMapping;
        WindowParam windowParam = this.mWindowParam;
        String str18 = ((j & 4295032833L) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        float f3 = 0.0f;
        if ((j & 4295491592L) != 0) {
            z = utilityParam != null ? utilityParam.getProjectMode() : false;
            f = ContextUtil.getAlpha(z);
        } else {
            f = 0.0f;
            z = false;
        }
        String str19 = ((j & 4297064480L) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        if ((j & 7073606494L) != 0) {
            if ((j & 4295098434L) != 0) {
                BaseProperty<Integer> waveWidth = xYParam != null ? xYParam.getWaveWidth() : null;
                updateRegistration(1, waveWidth);
                i17 = ViewDataBinding.safeUnbox(waveWidth != null ? waveWidth.getValue() : null);
                str11 = String.valueOf((i17 * 100) / 65535) + " % ";
            } else {
                i17 = 0;
                str11 = null;
            }
            if ((j & 4295229508L) != 0) {
                BaseProperty<Integer> grids = xYParam != null ? xYParam.getGrids() : null;
                updateRegistration(2, grids);
                int safeUnbox = ViewDataBinding.safeUnbox(grids != null ? grids.getValue() : null);
                boolean z17 = safeUnbox == ServiceEnum.EWaveGrids.GRID_IS_NONE.value1;
                z11 = safeUnbox == ServiceEnum.EWaveGrids.GRID_IS_HALF.value1;
                z9 = safeUnbox == ServiceEnum.EWaveGrids.GRID_IS_FULL.value1;
                z10 = z17;
            } else {
                z9 = false;
                z10 = false;
                z11 = false;
            }
            if ((j & 4296015952L) != 0) {
                if (xYParam != null) {
                    z13 = z10;
                    z12 = z9;
                    baseProperty6 = xYParam.getWaveIntensity();
                } else {
                    z12 = z9;
                    z13 = z10;
                    baseProperty6 = null;
                }
                updateRegistration(4, baseProperty6);
                int safeUnbox2 = ViewDataBinding.safeUnbox(baseProperty6 != null ? baseProperty6.getValue() : null);
                i18 = safeUnbox2;
                str12 = String.valueOf((safeUnbox2 * 100) / 65535) + " % ";
            } else {
                z12 = z9;
                z13 = z10;
                i18 = 0;
                str12 = null;
            }
            if ((j & 4303356224L) != 0) {
                if (xYParam != null) {
                    baseProperty5 = xYParam.getFramePersist();
                    str13 = str12;
                    i25 = 8;
                } else {
                    str13 = str12;
                    i25 = 8;
                    baseProperty5 = null;
                }
                updateRegistration(i25, baseProperty5);
                int safeUnbox3 = ViewDataBinding.safeUnbox(baseProperty5 != null ? baseProperty5.getValue() : null);
                str14 = String.valueOf((safeUnbox3 * 100) / 65535) + " % ";
                i19 = safeUnbox3;
            } else {
                str13 = str12;
                i19 = 0;
                str14 = null;
            }
            int i26 = ((j & 4312269384L) > 0L ? 1 : ((j & 4312269384L) == 0L ? 0 : -1));
            if (i26 != 0) {
                if (xYParam != null) {
                    i20 = i19;
                    str15 = str14;
                    baseProperty4 = xYParam.getAdvSetting();
                } else {
                    str15 = str14;
                    i20 = i19;
                    baseProperty4 = null;
                }
                updateRegistration(9, baseProperty4);
                z14 = ViewDataBinding.safeUnbox(baseProperty4 != null ? baseProperty4.getValue() : null);
                if (i26 != 0) {
                    j = z14 ? j | 274877906944L : j | 137438953472L;
                }
            } else {
                str15 = str14;
                i20 = i19;
                z14 = false;
            }
            if ((j & 4362078272L) != 0) {
                if (xYParam != null) {
                    baseProperty3 = xYParam.getPersistTime();
                    z15 = z14;
                    i24 = 11;
                } else {
                    z15 = z14;
                    i24 = 11;
                    baseProperty3 = null;
                }
                updateRegistration(i24, baseProperty3);
                int safeUnbox4 = ViewDataBinding.safeUnbox(baseProperty3 != null ? baseProperty3.getValue() : null);
                str16 = String.valueOf((safeUnbox4 * 100) / 65535) + " % ";
                i21 = safeUnbox4;
            } else {
                z15 = z14;
                i21 = 0;
                str16 = null;
            }
            int i27 = ((j & 4831846464L) > 0L ? 1 : ((j & 4831846464L) == 0L ? 0 : -1));
            if (i27 != 0) {
                if (xYParam != null) {
                    str17 = str16;
                    i22 = i21;
                    baseProperty2 = xYParam.getAutoCompression();
                } else {
                    i22 = i21;
                    str17 = str16;
                    baseProperty2 = null;
                }
                updateRegistration(13, baseProperty2);
                z16 = ViewDataBinding.safeUnbox(baseProperty2 != null ? baseProperty2.getValue() : null);
                if (i27 != 0) {
                    j |= z16 ? 17179869184L : 8589934592L;
                }
                i23 = z16 ? 8 : 0;
            } else {
                i22 = i21;
                str17 = str16;
                z16 = false;
                i23 = 0;
            }
            if ((j & 6442483776L) != 0) {
                if (xYParam != null) {
                    baseProperty = xYParam.getCompressionRatio();
                    j3 = j;
                } else {
                    j3 = j;
                    baseProperty = null;
                }
                updateRegistration(15, baseProperty);
                int safeUnbox5 = ViewDataBinding.safeUnbox(baseProperty != null ? baseProperty.getValue() : null);
                i5 = i17;
                str7 = str11;
                z2 = z;
                z7 = z12;
                i6 = i18;
                z6 = z15;
                i2 = i22;
                str5 = String.valueOf(safeUnbox5);
                z5 = z16;
                i = i23;
                str2 = str19;
                str6 = str13;
                z4 = z13;
                str3 = str17;
                i4 = safeUnbox5;
                f2 = f;
                i3 = i20;
                j = j3;
            } else {
                i5 = i17;
                str7 = str11;
                z2 = z;
                z7 = z12;
                i6 = i18;
                z6 = z15;
                i2 = i22;
                str5 = null;
                z5 = z16;
                i = i23;
                str2 = str19;
                str6 = str13;
                z4 = z13;
                str3 = str17;
                f2 = f;
                i4 = 0;
                i3 = i20;
            }
            String str20 = str15;
            str = str18;
            z3 = z11;
            str4 = str20;
        } else {
            str = str18;
            str2 = str19;
            z2 = z;
            f2 = f;
            z3 = false;
            i = 0;
            z4 = false;
            i2 = 0;
            z5 = false;
            z6 = false;
            z7 = false;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
        }
        String str21 = ((j & 4299161728L) == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        if ((j & 5804938240L) != 0) {
            int i28 = ((j & 4294971392L) > 0L ? 1 : ((j & 4294971392L) == 0L ? 0 : -1));
            if (i28 != 0) {
                boolean z18 = windowParam == null;
                if (i28 != 0) {
                    j |= z18 ? 68719476736L : 34359738368L;
                }
                if (z18) {
                    i12 = 8;
                    if ((j & 5502947328L) == 0) {
                        if (windowParam != null) {
                            str8 = str21;
                            chan = windowParam.getSource1();
                        } else {
                            str8 = str21;
                            chan = null;
                        }
                        if ((j & 4429189120L) != 0) {
                            z8 = z4;
                            i15 = ColorUtil.getColor(getRoot().getContext(), chan);
                        } else {
                            z8 = z4;
                            i15 = 0;
                        }
                        if (chan != null) {
                            i16 = chan.value1;
                            i13 = i15;
                        } else {
                            i13 = i15;
                            i16 = 0;
                        }
                        MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_chan_list, i16);
                        updateRegistration(14, mappingObject4);
                        if (mappingObject4 != null) {
                            str9 = mappingObject4.getStr();
                            if ((j & 4596962304L) != 0) {
                                ServiceEnum.Chan source2 = windowParam != null ? windowParam.getSource2() : null;
                                int color = (j & 4563406848L) != 0 ? ColorUtil.getColor(getRoot().getContext(), source2) : 0;
                                if (source2 != null) {
                                    i14 = source2.value1;
                                    j2 = j;
                                } else {
                                    j2 = j;
                                    i14 = 0;
                                }
                                MappingObject mappingObject5 = ViewUtil.getMappingObject(R.array.msg_chan_list, i14);
                                updateRegistration(10, mappingObject5);
                                if (mappingObject5 != null) {
                                    i9 = color;
                                    i8 = i13;
                                    i7 = i12;
                                    str10 = mappingObject5.getStr();
                                    j = j2;
                                    boolean projectMode = ((j & 274877906944L) != 0 || utilityParam == null) ? z2 : utilityParam.getProjectMode();
                                    i10 = ((j & 4312269384L) > 0L ? 1 : ((j & 4312269384L) == 0L ? 0 : -1));
                                    if (i10 != 0) {
                                        f3 = ContextUtil.getAlpha(z6 ? projectMode : false);
                                    }
                                    int i29 = i8;
                                    float f4 = f3;
                                    String str22 = str9;
                                    if (i10 == 0) {
                                        i11 = i7;
                                        if (getBuildSdkInt() >= 11) {
                                            this.afterglow.setAlpha(f4);
                                            this.afterglowInframe.setAlpha(f4);
                                            this.afterglowInframePercent.setAlpha(f4);
                                            this.afterglowInframeSeekBar.setAlpha(f4);
                                            this.afterglowPercent.setAlpha(f4);
                                            this.afterglowSeekBar.setAlpha(f4);
                                            this.autoCompression.setAlpha(f4);
                                            this.autoCompressionSwitchButton.setAlpha(f4);
                                            this.intensity.setAlpha(f4);
                                            this.intensityPercent.setAlpha(f4);
                                            this.intensitySeekBar.setAlpha(f4);
                                            this.samplerate.setAlpha(f4);
                                            this.samplerateSeekBar.setAlpha(f4);
                                            this.samplerateText.setAlpha(f4);
                                            this.waveformSize.setAlpha(f4);
                                            this.waveformSizePercent.setAlpha(f4);
                                            this.waveformSizeSeekBar.setAlpha(f4);
                                        }
                                    } else {
                                        i11 = i7;
                                    }
                                    if ((j & 4303356224L) != 0) {
                                        TextViewBindingAdapter.setText(this.afterglowInframePercent, str4);
                                        SeekBarBindingAdapter.setProgress(this.afterglowInframeSeekBar, i3);
                                    }
                                    if ((4311745088L & j) != 0) {
                                        this.afterglowInframeSeekBar.setTouchable(z6);
                                        this.afterglowSeekBar.setTouchable(z6);
                                        this.autoCompressionSwitchButton.setEnabled(z6);
                                        this.intensitySeekBar.setTouchable(z6);
                                        this.samplerateSeekBar.setTouchable(z6);
                                        CompoundButtonBindingAdapter.setChecked(this.settingADVSwitchButton, z6);
                                        this.waveformSizeSeekBar.setTouchable(z6);
                                    }
                                    if ((4362078272L & j) != 0) {
                                        TextViewBindingAdapter.setText(this.afterglowPercent, str3);
                                        SeekBarBindingAdapter.setProgress(this.afterglowSeekBar, i2);
                                    }
                                    if ((4831846464L & j) != 0) {
                                        CompoundButtonBindingAdapter.setChecked(this.autoCompressionSwitchButton, z5);
                                        this.samplerate.setVisibility(i);
                                        this.samplerateSeekBar.setVisibility(i);
                                        this.samplerateText.setVisibility(i);
                                    }
                                    if ((j & 4295229508L) != 0) {
                                        CompoundButtonBindingAdapter.setChecked(this.fullRadioButton, z7);
                                        CompoundButtonBindingAdapter.setChecked(this.halfRadioButton, z3);
                                        CompoundButtonBindingAdapter.setChecked(this.noneRadioButton, z8);
                                    }
                                    if ((4295032833L & j) != 0) {
                                        TextViewBindingAdapter.setText(this.fullRadioButton, str);
                                    }
                                    if ((j & 4297064480L) != 0) {
                                        TextViewBindingAdapter.setText(this.halfRadioButton, str2);
                                    }
                                    if ((j & 4296015952L) != 0) {
                                        TextViewBindingAdapter.setText(this.intensityPercent, str6);
                                        SeekBarBindingAdapter.setProgress(this.intensitySeekBar, i6);
                                    }
                                    if ((j & 4299161728L) != 0) {
                                        TextViewBindingAdapter.setText(this.noneRadioButton, str8);
                                    }
                                    if ((6442483776L & j) != 0) {
                                        SeekBarBindingAdapter.setProgress(this.samplerateSeekBar, i4);
                                        TextViewBindingAdapter.setText(this.samplerateText, str5);
                                    }
                                    if ((4295491592L & j) != 0) {
                                        if (getBuildSdkInt() >= 11) {
                                            float f5 = f2;
                                            this.settingADV.setAlpha(f5);
                                            this.settingADVSwitchButton.setAlpha(f5);
                                        }
                                        this.settingADVSwitchButton.setEnabled(projectMode);
                                    }
                                    if ((j & 4294971392L) != 0) {
                                        int i30 = i11;
                                        this.sourceA.setVisibility(i30);
                                        this.sourceASpinner.setVisibility(i30);
                                        this.sourceB.setVisibility(i30);
                                        this.sourceBSpinner.setVisibility(i30);
                                    }
                                    if ((j & 5502947328L) != 0) {
                                        TextViewBindingAdapter.setText(this.sourceASpinner, str22);
                                    }
                                    if ((4429189120L & j) != 0) {
                                        this.sourceASpinner.setTextColor(i29);
                                    }
                                    if ((j & 4596962304L) != 0) {
                                        TextViewBindingAdapter.setText(this.sourceBSpinner, str10);
                                    }
                                    if ((4563406848L & j) != 0) {
                                        this.sourceBSpinner.setTextColor(i9);
                                    }
                                    if ((j & 4295098434L) == 0) {
                                        TextViewBindingAdapter.setText(this.waveformSizePercent, str7);
                                        SeekBarBindingAdapter.setProgress(this.waveformSizeSeekBar, i5);
                                        return;
                                    }
                                    return;
                                }
                                i9 = color;
                                i8 = i13;
                                i7 = i12;
                                j = j2;
                            } else {
                                i9 = 0;
                                i8 = i13;
                                i7 = i12;
                            }
                        }
                    } else {
                        z8 = z4;
                        str8 = str21;
                        i13 = 0;
                    }
                    str9 = null;
                    if ((j & 4596962304L) != 0) {
                    }
                }
            }
            i12 = 0;
            if ((j & 5502947328L) == 0) {
            }
            str9 = null;
            if ((j & 4596962304L) != 0) {
            }
        } else {
            z8 = z4;
            str8 = str21;
            i7 = 0;
            i8 = 0;
            i9 = 0;
            str9 = null;
        }
        str10 = null;
        if ((j & 274877906944L) != 0) {
        }
        i10 = ((j & 4312269384L) > 0L ? 1 : ((j & 4312269384L) == 0L ? 0 : -1));
        if (i10 != 0) {
        }
        int i292 = i8;
        float f42 = f3;
        String str222 = str9;
        if (i10 == 0) {
        }
        if ((j & 4303356224L) != 0) {
        }
        if ((4311745088L & j) != 0) {
        }
        if ((4362078272L & j) != 0) {
        }
        if ((4831846464L & j) != 0) {
        }
        if ((j & 4295229508L) != 0) {
        }
        if ((4295032833L & j) != 0) {
        }
        if ((j & 4297064480L) != 0) {
        }
        if ((j & 4296015952L) != 0) {
        }
        if ((j & 4299161728L) != 0) {
        }
        if ((6442483776L & j) != 0) {
        }
        if ((4295491592L & j) != 0) {
        }
        if ((j & 4294971392L) != 0) {
        }
        if ((j & 5502947328L) != 0) {
        }
        if ((4429189120L & j) != 0) {
        }
        if ((j & 4596962304L) != 0) {
        }
        if ((4563406848L & j) != 0) {
        }
        if ((j & 4295098434L) == 0) {
        }
    }
}
