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



    private static final long DIRTY_FLAG_GRID_FULL_MAPPING = 0x1L;
    private static final long DIRTY_FLAG_WAVE_WIDTH = 0x2L;
    private static final long DIRTY_FLAG_GRIDS = 0x4L;
    private static final long DIRTY_FLAG_UTILITY_PARAM = 0x8L;
    private static final long DIRTY_FLAG_WAVE_INTENSITY = 0x10L;
    private static final long DIRTY_FLAG_GRID_HALF_MAPPING = 0x20L;
    private static final long DIRTY_FLAG_XY_PARAM = 0x40L;
    private static final long DIRTY_FLAG_GRID_NONE_MAPPING = 0x80L;
    private static final long DIRTY_FLAG_FRAME_PERSIST = 0x100L;
    private static final long DIRTY_FLAG_ADV_SETTING = 0x200L;
    private static final long DIRTY_FLAG_SOURCE2_MAPPING = 0x400L;
    private static final long DIRTY_FLAG_PERSIST_TIME = 0x800L;
    private static final long DIRTY_FLAG_WINDOW_PARAM = 0x1000L;
    private static final long DIRTY_FLAG_AUTO_COMPRESSION = 0x2000L;
    private static final long DIRTY_FLAG_SOURCE1_MAPPING = 0x4000L;
    private static final long DIRTY_FLAG_COMPRESSION_RATIO = 0x8000L;

    // Флаги для групповых обновлений
    private static final long DIRTY_FLAG_UI_UPDATE = 0x100000000L;
    private static final long DIRTY_FLAG_COLOR_UPDATE = 0x200000000L;
    private static final long DIRTY_FLAG_VISIBILITY_UPDATE = 0x400000000L;
    private static final long DIRTY_FLAG_UI_STATE = 0x800000000L;
    private static final long DIRTY_FLAG_PROJECT_MODE = 0x1000000000L;
    private static final long DIRTY_FLAG_AFTERGLOW_UPDATE = 0x2000000000L;
    private static final long DIRTY_FLAG_CONTROLS_INTERACTIVITY = 0x4000000000L;
    private static final long DIRTY_FLAG_TEXT_UPDATE = 0x8000000000L;
    private static final long DIRTY_FLAG_RADIO_BUTTONS = 0x10000000000L;
    private static final long DIRTY_FLAG_GRID_STATE = 0x20000000000L;
    private static final long DIRTY_FLAG_SOURCE1_CHANGE = 0x40000000000L;
    private static final long DIRTY_FLAG_SOURCE2_CHANGE = 0x80000000000L;
    private static final long DIRTY_FLAG_SOURCE1_COLOR = 0x100000000000L;
    private static final long DIRTY_FLAG_SOURCE2_COLOR = 0x200000000000L;

    // Комбинации флагов для часто используемых обновлений
    private static final long DIRTY_FLAG_GRID_AND_WAVE = DIRTY_FLAG_GRIDS | DIRTY_FLAG_WAVE_WIDTH;
    private static final long DIRTY_FLAG_ALL_MAPPINGS = DIRTY_FLAG_GRID_FULL_MAPPING | DIRTY_FLAG_GRID_HALF_MAPPING | DIRTY_FLAG_GRID_NONE_MAPPING;
    private static final long DIRTY_FLAG_ALL_SOURCES = DIRTY_FLAG_SOURCE1_MAPPING | DIRTY_FLAG_SOURCE2_MAPPING;
    private static final long DIRTY_FLAG_ALL_SETTINGS = DIRTY_FLAG_ADV_SETTING | DIRTY_FLAG_AUTO_COMPRESSION | DIRTY_FLAG_COMPRESSION_RATIO;
    private static final long DIRTY_FLAG_ALL_PERSIST = DIRTY_FLAG_FRAME_PERSIST | DIRTY_FLAG_PERSIST_TIME;
    private static final long DIRTY_FLAG_ALL_PARAMS = DIRTY_FLAG_XY_PARAM | DIRTY_FLAG_UTILITY_PARAM | DIRTY_FLAG_WINDOW_PARAM;
    private static final long DIRTY_FLAG_ALL_WAVE = DIRTY_FLAG_WAVE_WIDTH | DIRTY_FLAG_WAVE_INTENSITY;
    private static final long DIRTY_FLAG_ALL_UI_UPDATES = DIRTY_FLAG_UI_UPDATE | DIRTY_FLAG_COLOR_UPDATE | DIRTY_FLAG_VISIBILITY_UPDATE | DIRTY_FLAG_UI_STATE;
    private static final long DIRTY_FLAG_ALL_SOURCE_CHANGES = DIRTY_FLAG_SOURCE1_CHANGE | DIRTY_FLAG_SOURCE2_CHANGE | DIRTY_FLAG_SOURCE1_COLOR | DIRTY_FLAG_SOURCE2_COLOR;
    private static final long DIRTY_FLAG_ALL_CONTROLS = DIRTY_FLAG_CONTROLS_INTERACTIVITY | DIRTY_FLAG_TEXT_UPDATE | DIRTY_FLAG_RADIO_BUTTONS;





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
            this.mDirtyFlags = DIRTY_FLAG_UI_UPDATE;
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
            this.mDirtyFlags |= DIRTY_FLAG_GRID_FULL_MAPPING;
        }
        notifyPropertyChanged(358);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewXyBinding
    public void setUtilityParam(UtilityParam utilityParam) {
        updateRegistration(3, utilityParam);
        this.mUtilityParam = utilityParam;
        synchronized (this) {
            this.mDirtyFlags |= DIRTY_FLAG_UTILITY_PARAM;
        }
        notifyPropertyChanged(1013);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewXyBinding
    public void setGridHalfMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mGridHalfMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= DIRTY_FLAG_GRID_HALF_MAPPING;
        }
        notifyPropertyChanged(359);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewXyBinding
    public void setXyParam(XYParam xYParam) {
        updateRegistration(6, xYParam);
        this.mXyParam = xYParam;
        synchronized (this) {
            this.mDirtyFlags |= DIRTY_FLAG_XY_PARAM;
        }
        notifyPropertyChanged(1084);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewXyBinding
    public void setGridNoneMapping(MappingObject mappingObject) {
        updateRegistration(7, mappingObject);
        this.mGridNoneMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= DIRTY_FLAG_GRID_NONE_MAPPING;
        }
        notifyPropertyChanged(361);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewXyBinding
    public void setWindowParam(WindowParam windowParam) {
        updateRegistration(12, windowParam);
        this.mWindowParam = windowParam;
        synchronized (this) {
            this.mDirtyFlags |= DIRTY_FLAG_WINDOW_PARAM;
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
                this.mDirtyFlags |= DIRTY_FLAG_GRID_FULL_MAPPING;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= DIRTY_FLAG_AUTO_COMPRESSION;
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
                this.mDirtyFlags |= DIRTY_FLAG_SOURCE1_MAPPING;
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
                this.mDirtyFlags |= DIRTY_FLAG_COMPRESSION_RATIO;
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
                this.mDirtyFlags |= 0x200000L;
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
                this.mDirtyFlags |= 0x100000L;
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
                this.mDirtyFlags |= 0x80000L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeXyParam(XYParam xYParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= DIRTY_FLAG_XY_PARAM;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeGridNoneMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= DIRTY_FLAG_GRID_NONE_MAPPING;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 0x400000L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeXyParamFramePersist(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= DIRTY_FLAG_FRAME_PERSIST;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 0x800000L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeXyParamAdvSetting(BaseProperty<Boolean> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= DIRTY_FLAG_ADV_SETTING;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 0x1000000L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanListWindowParamSource2Value1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= DIRTY_FLAG_SOURCE2_MAPPING;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 0x2000000L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeXyParamPersistTime(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= DIRTY_FLAG_PERSIST_TIME;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 0x4000000L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeWindowParam(WindowParam windowParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= DIRTY_FLAG_WINDOW_PARAM;
            }
            return true;
        } else if (i == 859) {
            synchronized (this) {
                this.mDirtyFlags |= 0x8000000L;
            }
            return true;
        } else if (i == 860) {
            synchronized (this) {
                this.mDirtyFlags |= 0x10000000L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeXyParamAutoCompression(BaseProperty<Boolean> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= DIRTY_FLAG_AUTO_COMPRESSION;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 0x20000000L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanListWindowParamSource1Value1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= DIRTY_FLAG_SOURCE1_MAPPING;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 0x40000000L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeXyParamCompressionRatio(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= DIRTY_FLAG_COMPRESSION_RATIO;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 0x80000000L;
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
        long dirtyFlags;
        float alphaValue;
        boolean isProjectMode;
        String gridFullStr;
        String gridHalfStr;
        boolean isAdvSettingEnabled;
        float settingAlpha;
        boolean isNoneGridSelected;
        int waveWidthValue;
        boolean isAutoCompressionEnabled;
        int persistTimeValue;
        boolean isFullGridSelected;
        boolean isHalfGridSelected;
        int framePersistValue;
        int waveIntensityValue;
        int compressionRatioValue;
        int visibilityValue;
        String waveWidthText;
        String waveIntensityText;
        String framePersistText;
        String persistTimeText;
        String compressionRatioText;
        boolean isWindowParamVisible;
        String gridNoneStr;
        int sourceAColor;
        int sourceBColor;
        int sourceAValue;
        String sourceAText;
        String sourceBText;
        int sourceBValue;
        int visibilityState;
        int controlsVisibility;
        long updatedDirtyFlags;
        int channelValue;
        ServiceEnum.Chan sourceAChan;
        int colorValue;
        int channelId;
        int waveWidth;
        String waveWidthPercentText;
        boolean isProjectModeEnabled;
        boolean isAutoCompression;
        boolean isAdvSetting;
        boolean isNoneGrid;
        boolean isFullGrid;
        int settingsVisibility;
        String intensityPercentText;
        String persistPercentText;
        int persistValue;
        String framePersistPercentText;
        String afterglowPercentText;
        int afterglowValue;
        boolean isAdvancedMode;
        boolean isAutoCompress;
        int compressionValue;
        String compressionText;
        int seekbarValue;
        String seekbarText;
        boolean isAutoMode;
        int autoVisibility;
        long tempDirtyFlags;
        BaseProperty<Integer> waveWidthProperty;
        BaseProperty<Boolean> autoCompressionProperty;
        int propertyValue;
        BaseProperty<Integer> persistTimeProperty;
        BaseProperty<Boolean> advSettingProperty;
        int persistTime;
        BaseProperty<Integer> framePersistProperty;
        BaseProperty<Integer> intensityProperty;
        synchronized (this) {
            dirtyFlags = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mGridFullMapping;
        UtilityParam utilityParam = this.mUtilityParam;
        MappingObject mappingObject2 = this.mGridHalfMapping;
        XYParam xYParam = this.mXyParam;
        MappingObject mappingObject3 = this.mGridNoneMapping;
        WindowParam windowParam = this.mWindowParam;
        String str18 = ((dirtyFlags & DIRTY_FLAG_GRID_FULL) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        float f3 = 0.0f;
        if ((dirtyFlags & DIRTY_FLAG_UTILITY_PARAM) != 0) {
            isProjectMode = utilityParam != null ? utilityParam.getProjectMode() : false;
            alphaValue = ContextUtil.getAlpha(isProjectMode);
        } else {
            alphaValue = 0.0f;
            isProjectMode = false;
        }
        String str19 = ((dirtyFlags & DIRTY_FLAG_GRID_HALF) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        if ((dirtyFlags & DIRTY_FLAG_XY_PARAM) != 0) {
            if ((dirtyFlags & DIRTY_FLAG_WAVE_WIDTH) != 0) {
                BaseProperty<Integer> waveWidth = xYParam != null ? xYParam.getWaveWidth() : null;
                updateRegistration(1, waveWidth);
                waveWidthValue = ViewDataBinding.safeUnbox(waveWidth != null ? waveWidth.getValue() : null);
                waveWidthText = String.valueOf((waveWidthValue * 100) / 65535) + " % ";
            } else {
                waveWidthValue = 0;
                waveWidthText = null;
            }
            if ((dirtyFlags & DIRTY_FLAG_GRIDS) != 0) {
                BaseProperty<Integer> grids = xYParam != null ? xYParam.getGrids() : null;
                updateRegistration(2, grids);
                int gridValue = ViewDataBinding.safeUnbox(grids != null ? grids.getValue() : null);
                isNoneGridSelected = gridValue == ServiceEnum.EWaveGrids.GRID_IS_NONE.value1;
                isHalfGridSelected = gridValue == ServiceEnum.EWaveGrids.GRID_IS_HALF.value1;
                isFullGridSelected = gridValue == ServiceEnum.EWaveGrids.GRID_IS_FULL.value1;
                isNoneGrid = isNoneGridSelected;
            } else {
                isFullGridSelected = false;
                isNoneGrid = false;
                isHalfGridSelected = false;
            }
            if ((dirtyFlags & DIRTY_FLAG_WAVE_INTENSITY) != 0) {
                if (xYParam != null) {
                    isNoneGridSelected = isNoneGrid;
                    isFullGrid = isFullGridSelected;
                    intensityProperty = xYParam.getWaveIntensity();
                } else {
                    isFullGrid = isFullGridSelected;
                    isNoneGridSelected = isNoneGrid;
                    intensityProperty = null;
                }
                updateRegistration(4, intensityProperty);
                int intensityValue = ViewDataBinding.safeUnbox(intensityProperty != null ? intensityProperty.getValue() : null);
                waveIntensityValue = intensityValue;
                waveIntensityText = String.valueOf((intensityValue * 100) / 65535) + " % ";
            } else {
                isFullGrid = isFullGridSelected;
                isNoneGridSelected = isNoneGrid;
                waveIntensityValue = 0;
                waveIntensityText = null;
            }
            if ((dirtyFlags & DIRTY_FLAG_FRAME_PERSIST) != 0) {
                if (xYParam != null) {
                    framePersistProperty = xYParam.getFramePersist();
                    intensityPercentText = waveIntensityText;
                    persistTime = 8;
                } else {
                    intensityPercentText = waveIntensityText;
                    persistTime = 8;
                    framePersistProperty = null;
                }
                updateRegistration(persistTime, framePersistProperty);
                int persistValue = ViewDataBinding.safeUnbox(framePersistProperty != null ? framePersistProperty.getValue() : null);
                framePersistText = String.valueOf((persistValue * 100) / 65535) + " % ";
                framePersistValue = persistValue;
            } else {
                intensityPercentText = waveIntensityText;
                framePersistValue = 0;
                framePersistText = null;
            }
            int i26 = ((dirtyFlags & DIRTY_FLAG_ADV_SETTING) > 0L ? 1 : ((dirtyFlags & DIRTY_FLAG_ADV_SETTING) == 0L ? 0 : -1));
            if (i26 != 0) {
                if (xYParam != null) {
                    afterglowValue = framePersistValue;
                    afterglowPercentText = framePersistText;
                    advSettingProperty = xYParam.getAdvSetting();
                } else {
                    afterglowPercentText = framePersistText;
                    afterglowValue = framePersistValue;
                    advSettingProperty = null;
                }
                updateRegistration(9, advSettingProperty);
                isAdvancedMode = ViewDataBinding.safeUnbox(advSettingProperty != null ? advSettingProperty.getValue() : null);
                if (i26 != 0) {
                    dirtyFlags = isAdvancedMode ? dirtyFlags | DIRTY_FLAG_ADV_SETTING_TRUE : dirtyFlags | DIRTY_FLAG_ADV_SETTING_FALSE;
                }
            } else {
                afterglowPercentText = framePersistText;
                afterglowValue = framePersistValue;
                isAdvancedMode = false;
            }
            if ((dirtyFlags & DIRTY_FLAG_PERSIST_TIME) != 0) {
                if (xYParam != null) {
                    persistTimeProperty = xYParam.getPersistTime();
                    isAdvSetting = isAdvancedMode;
                    propertyValue = 11;
                } else {
                    isAdvSetting = isAdvancedMode;
                    propertyValue = 11;
                    persistTimeProperty = null;
                }
                updateRegistration(propertyValue, persistTimeProperty);
                int persistTimeValue = ViewDataBinding.safeUnbox(persistTimeProperty != null ? persistTimeProperty.getValue() : null);
                persistTimeText = String.valueOf((persistTimeValue * 100) / 65535) + " % ";
                this.persistTimeValue = persistTimeValue;
            } else {
                isAdvSetting = isAdvancedMode;
                this.persistTimeValue = 0;
                persistTimeText = null;
            }
            int i27 = ((dirtyFlags & DIRTY_FLAG_AUTO_COMPRESSION) > 0L ? 1 : ((dirtyFlags & DIRTY_FLAG_AUTO_COMPRESSION) == 0L ? 0 : -1));
            if (i27 != 0) {
                if (xYParam != null) {
                    seekbarText = persistTimeText;
                    seekbarValue = this.persistTimeValue;
                    autoCompressionProperty = xYParam.getAutoCompression();
                } else {
                    seekbarValue = this.persistTimeValue;
                    seekbarText = persistTimeText;
                    autoCompressionProperty = null;
                }
                updateRegistration(13, autoCompressionProperty);
                isAutoMode = ViewDataBinding.safeUnbox(autoCompressionProperty != null ? autoCompressionProperty.getValue() : null);
                if (i27 != 0) {
                    dirtyFlags |= isAutoMode ? DIRTY_FLAG_AUTO_COMPRESSION_TRUE : DIRTY_FLAG_AUTO_COMPRESSION_FALSE;
                }
                autoVisibility = isAutoMode ? 8 : 0;
            } else {
                seekbarValue = this.persistTimeValue;
                seekbarText = persistTimeText;
                isAutoMode = false;
                autoVisibility = 0;
            }
            if ((dirtyFlags & DIRTY_FLAG_COMPRESSION_RATIO) != 0) {
                if (xYParam != null) {
                    waveWidthProperty = xYParam.getCompressionRatio();
                    tempDirtyFlags = dirtyFlags;
                } else {
                    tempDirtyFlags = dirtyFlags;
                    waveWidthProperty = null;
                }
                updateRegistration(15, waveWidthProperty);
                int compressionValue = ViewDataBinding.safeUnbox(waveWidthProperty != null ? waveWidthProperty.getValue() : null);
                waveWidth = waveWidthValue;
                waveWidthPercentText = waveWidthText;
                isProjectModeEnabled = isProjectMode;
                isFullGrid = isFullGrid;
                waveIntensityValue = waveIntensityValue;
                isAdvSetting = isAdvSetting;
                persistTimeValue = seekbarValue;
                compressionText = String.valueOf(compressionValue);
                isAutoCompress = isAutoMode;
                visibilityValue = autoVisibility;
                gridHalfStr = str19;
                intensityPercentText = intensityPercentText;
                isNoneGridSelected = isNoneGridSelected;
                persistTimeText = seekbarText;
                compressionRatioValue = compressionValue;
                settingAlpha = alphaValue;
                framePersistValue = afterglowValue;
                dirtyFlags = tempDirtyFlags;
            } else {
                waveWidth = waveWidthValue;
                waveWidthPercentText = waveWidthText;
                isProjectModeEnabled = isProjectMode;
                isFullGrid = isFullGrid;
                waveIntensityValue = waveIntensityValue;
                isAdvSetting = isAdvSetting;
                persistTimeValue = seekbarValue;
                compressionText = null;
                isAutoCompress = isAutoMode;
                visibilityValue = autoVisibility;
                gridHalfStr = str19;
                intensityPercentText = intensityPercentText;
                isNoneGridSelected = isNoneGridSelected;
                persistTimeText = seekbarText;
                settingAlpha = alphaValue;
                framePersistValue = afterglowValue;
                compressionRatioValue = 0;
            }
            String afterglowText = afterglowPercentText;
            gridFullStr = str18;
            isHalfGridSelected = isHalfGridSelected;
            framePersistText = afterglowText;
        } else {
            gridFullStr = str18;
            gridHalfStr = str19;
            isProjectModeEnabled = isProjectMode;
            settingAlpha = alphaValue;
            isHalfGridSelected = false;
            visibilityValue = 0;
            isNoneGridSelected = false;
            persistTimeValue = 0;
            isAutoCompress = false;
            isAdvSetting = false;
            isFullGrid = false;
            framePersistValue = 0;
            compressionRatioValue = 0;
            waveWidth = 0;
            waveIntensityValue = 0;
            persistTimeText = null;
            framePersistText = null;
            compressionText = null;
            intensityPercentText = null;
            waveWidthPercentText = null;
        }
        String gridNoneStr = ((dirtyFlags & DIRTY_FLAG_GRID_NONE) == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        if ((dirtyFlags & DIRTY_FLAG_WINDOW_PARAM) != 0) {
            int i28 = ((dirtyFlags & DIRTY_FLAG_WINDOW_PARAM_VISIBILITY) > 0L ? 1 : ((dirtyFlags & DIRTY_FLAG_WINDOW_PARAM_VISIBILITY) == 0L ? 0 : -1));
            if (i28 != 0) {
                isWindowParamVisible = windowParam == null;
                if (i28 != 0) {
                    dirtyFlags |= isWindowParamVisible ? DIRTY_FLAG_WINDOW_PARAM_NULL : DIRTY_FLAG_WINDOW_PARAM_NOT_NULL;
                }
                if (isWindowParamVisible) {
                    controlsVisibility = 8;
                    if ((dirtyFlags & DIRTY_FLAG_SOURCE1) == 0) {
                        if (windowParam != null) {
                            gridNoneStr = gridNoneStr;
                            sourceAChan = windowParam.getSource1();
                        } else {
                            gridNoneStr = gridNoneStr;
                            sourceAChan = null;
                        }
                        if ((dirtyFlags & DIRTY_FLAG_SOURCE1_COLOR) != 0) {
                            isNoneGridSelected = isNoneGridSelected;
                            colorValue = ColorUtil.getColor(getRoot().getContext(), sourceAChan);
                        } else {
                            isNoneGridSelected = isNoneGridSelected;
                            colorValue = 0;
                        }
                        if (sourceAChan != null) {
                            channelId = sourceAChan.value1;
                            sourceAColor = colorValue;
                        } else {
                            sourceAColor = colorValue;
                            channelId = 0;
                        }
                        MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_chan_list, channelId);
                        updateRegistration(14, mappingObject4);
                        if (mappingObject4 != null) {
                            sourceAText = mappingObject4.getStr();
                            if ((dirtyFlags & DIRTY_FLAG_SOURCE2) != 0) {
                                ServiceEnum.Chan source2 = windowParam != null ? windowParam.getSource2() : null;
                                int sourceBColor = (dirtyFlags & DIRTY_FLAG_SOURCE2_COLOR) != 0 ? ColorUtil.getColor(getRoot().getContext(), source2) : 0;
                                if (source2 != null) {
                                    channelValue = source2.value1;
                                    updatedDirtyFlags = dirtyFlags;
                                } else {
                                    updatedDirtyFlags = dirtyFlags;
                                    channelValue = 0;
                                }
                                MappingObject mappingObject5 = ViewUtil.getMappingObject(R.array.msg_chan_list, channelValue);
                                updateRegistration(10, mappingObject5);
                                if (mappingObject5 != null) {
                                    sourceBColor = sourceBColor;
                                    sourceAColor = sourceAColor;
                                    visibilityState = controlsVisibility;
                                    sourceBText = mappingObject5.getStr();
                                    dirtyFlags = updatedDirtyFlags;
                                    boolean projectMode2 = ((dirtyFlags & DIRTY_FLAG_ADV_SETTING_TRUE) != 0 || utilityParam == null) ? isProjectModeEnabled : utilityParam.getProjectMode();
                                    i10 = ((dirtyFlags & DIRTY_FLAG_ADV_SETTING) > 0L ? 1 : ((dirtyFlags & DIRTY_FLAG_ADV_SETTING) == 0L ? 0 : -1));
                                    if (i10 != 0) {
                                        f3 = ContextUtil.getAlpha(isAdvSetting ? projectMode2 : false);
                                    }
                                    int sourceAColorValue = sourceAColor;
                                    float alphaValue2 = f3;
                                    String sourceAStr = sourceAText;
                                    if (i10 == 0) {
                                        visibilityState = visibilityState;
                                        if (getBuildSdkInt() >= 11) {
                                            this.afterglow.setAlpha(alphaValue2);
                                            this.afterglowInframe.setAlpha(alphaValue2);
                                            this.afterglowInframePercent.setAlpha(alphaValue2);
                                            this.afterglowInframeSeekBar.setAlpha(alphaValue2);
                                            this.afterglowPercent.setAlpha(alphaValue2);
                                            this.afterglowSeekBar.setAlpha(alphaValue2);
                                            this.autoCompression.setAlpha(alphaValue2);
                                            this.autoCompressionSwitchButton.setAlpha(alphaValue2);
                                            this.intensity.setAlpha(alphaValue2);
                                            this.intensityPercent.setAlpha(alphaValue2);
                                            this.intensitySeekBar.setAlpha(alphaValue2);
                                            this.samplerate.setAlpha(alphaValue2);
                                            this.samplerateSeekBar.setAlpha(alphaValue2);
                                            this.samplerateText.setAlpha(alphaValue2);
                                            this.waveformSize.setAlpha(alphaValue2);
                                            this.waveformSizePercent.setAlpha(alphaValue2);
                                            this.waveformSizeSeekBar.setAlpha(alphaValue2);
                                        }
                                    } else {
                                        visibilityState = visibilityState;
                                    }
                                    if ((dirtyFlags & DIRTY_FLAG_FRAME_PERSIST) != 0) {
                                        TextViewBindingAdapter.setText(this.afterglowInframePercent, framePersistText);
                                        SeekBarBindingAdapter.setProgress(this.afterglowInframeSeekBar, framePersistValue);
                                    }
                                    if ((DIRTY_FLAG_ADV_SETTING_CONTROLS & dirtyFlags) != 0) {
                                        this.afterglowInframeSeekBar.setTouchable(isAdvSetting);
                                        this.afterglowSeekBar.setTouchable(isAdvSetting);
                                        this.autoCompressionSwitchButton.setEnabled(isAdvSetting);
                                        this.intensitySeekBar.setTouchable(isAdvSetting);
                                        this.samplerateSeekBar.setTouchable(isAdvSetting);
                                        CompoundButtonBindingAdapter.setChecked(this.settingADVSwitchButton, isAdvSetting);
                                        this.waveformSizeSeekBar.setTouchable(isAdvSetting);
                                    }
                                    if ((DIRTY_FLAG_PERSIST_TIME & dirtyFlags) != 0) {
                                        TextViewBindingAdapter.setText(this.afterglowPercent, persistTimeText);
                                        SeekBarBindingAdapter.setProgress(this.afterglowSeekBar, persistTimeValue);
                                    }
                                    if ((DIRTY_FLAG_AUTO_COMPRESSION & dirtyFlags) != 0) {
                                        CompoundButtonBindingAdapter.setChecked(this.autoCompressionSwitchButton, isAutoCompress);
                                        this.samplerate.setVisibility(visibilityValue);
                                        this.samplerateSeekBar.setVisibility(visibilityValue);
                                        this.samplerateText.setVisibility(visibilityValue);
                                    }
                                    if ((dirtyFlags & DIRTY_FLAG_GRIDS) != 0) {
                                        CompoundButtonBindingAdapter.setChecked(this.fullRadioButton, isFullGrid);
                                        CompoundButtonBindingAdapter.setChecked(this.halfRadioButton, isHalfGridSelected);
                                        CompoundButtonBindingAdapter.setChecked(this.noneRadioButton, isNoneGridSelected);
                                    }
                                    if ((DIRTY_FLAG_GRID_FULL & dirtyFlags) != 0) {
                                        TextViewBindingAdapter.setText(this.fullRadioButton, gridFullStr);
                                    }
                                    if ((dirtyFlags & DIRTY_FLAG_GRID_HALF) != 0) {
                                        TextViewBindingAdapter.setText(this.halfRadioButton, gridHalfStr);
                                    }
                                    if ((dirtyFlags & DIRTY_FLAG_WAVE_INTENSITY) != 0) {
                                        TextViewBindingAdapter.setText(this.intensityPercent, intensityPercentText);
                                        SeekBarBindingAdapter.setProgress(this.intensitySeekBar, waveIntensityValue);
                                    }
                                    if ((dirtyFlags & DIRTY_FLAG_GRID_NONE) != 0) {
                                        TextViewBindingAdapter.setText(this.noneRadioButton, gridNoneStr);
                                    }
                                    if ((DIRTY_FLAG_COMPRESSION_RATIO & dirtyFlags) != 0) {
                                        SeekBarBindingAdapter.setProgress(this.samplerateSeekBar, compressionRatioValue);
                                        TextViewBindingAdapter.setText(this.samplerateText, compressionText);
                                    }
                                    if ((DIRTY_FLAG_UTILITY_PARAM & dirtyFlags) != 0) {
                                        if (getBuildSdkInt() >= 11) {
                                            float alphaValue3 = settingAlpha;
                                            this.settingADV.setAlpha(alphaValue3);
                                            this.settingADVSwitchButton.setAlpha(alphaValue3);
                                        }
                                        this.settingADVSwitchButton.setEnabled(projectMode2);
                                    }
                                    if ((dirtyFlags & DIRTY_FLAG_WINDOW_PARAM_VISIBILITY) != 0) {
                                        int visibility = visibilityState;
                                        this.sourceA.setVisibility(visibility);
                                        this.sourceASpinner.setVisibility(visibility);
                                        this.sourceB.setVisibility(visibility);
                                        this.sourceBSpinner.setVisibility(visibility);
                                    }
                                    if ((dirtyFlags & DIRTY_FLAG_SOURCE1) != 0) {
                                        TextViewBindingAdapter.setText(this.sourceASpinner, sourceAStr);
                                    }
                                    if ((DIRTY_FLAG_SOURCE1_COLOR & dirtyFlags) != 0) {
                                        this.sourceASpinner.setTextColor(sourceAColorValue);
                                    }
                                    if ((dirtyFlags & DIRTY_FLAG_SOURCE2) != 0) {
                                        TextViewBindingAdapter.setText(this.sourceBSpinner, sourceBText);
                                    }
                                    if ((DIRTY_FLAG_SOURCE2_COLOR & dirtyFlags) != 0) {
                                        this.sourceBSpinner.setTextColor(sourceBColor);
                                    }
                                    if ((dirtyFlags & DIRTY_FLAG_WAVE_WIDTH) == 0) {
                                        TextViewBindingAdapter.setText(this.waveformSizePercent, waveWidthPercentText);
                                        SeekBarBindingAdapter.setProgress(this.waveformSizeSeekBar, waveWidth);
                                        return;
                                    }
                                    return;
                                }
                                sourceBColor = sourceBColor;
                                sourceAColor = sourceAColor;
                                visibilityState = controlsVisibility;
                                dirtyFlags = updatedDirtyFlags;
                            } else {
                                sourceBColor = 0;
                                sourceAColor = sourceAColor;
                                visibilityState = controlsVisibility;
                            }
                        }
                    } else {
                        isNoneGridSelected = isNoneGridSelected;
                        gridNoneStr = gridNoneStr;
                        sourceAColor = 0;
                    }
                    sourceAText = null;
                    if ((dirtyFlags & DIRTY_FLAG_SOURCE2) != 0) {
                    }
                }
            }
            controlsVisibility = 0;
            if ((dirtyFlags & DIRTY_FLAG_SOURCE1) == 0) {
            }
            sourceAText = null;
            if ((dirtyFlags & DIRTY_FLAG_SOURCE2) != 0) {
            }
        } else {
            isNoneGridSelected = isNoneGridSelected;
            gridNoneStr = gridNoneStr;
            visibilityState = 0;
            sourceAColor = 0;
            sourceBColor = 0;
            sourceAText = null;
        }
        sourceBText = null;
        if ((dirtyFlags & DIRTY_FLAG_ADV_SETTING_TRUE) != 0) {
        }
        i10 = ((dirtyFlags & DIRTY_FLAG_ADV_SETTING) > 0L ? 1 : ((dirtyFlags & DIRTY_FLAG_ADV_SETTING) == 0L ? 0 : -1));
        if (i10 != 0) {
        }
        int sourceAColorValue2 = sourceAColor;
        float alphaValue22 = f3;
        String sourceAStr2 = sourceAText;
        if (i10 == 0) {
        }
        if ((dirtyFlags & DIRTY_FLAG_FRAME_PERSIST) != 0) {
        }
        if ((DIRTY_FLAG_ADV_SETTING_CONTROLS & dirtyFlags) != 0) {
        }
        if ((DIRTY_FLAG_PERSIST_TIME & dirtyFlags) != 0) {
        }
        if ((DIRTY_FLAG_AUTO_COMPRESSION & dirtyFlags) != 0) {
        }
        if ((dirtyFlags & DIRTY_FLAG_GRIDS) != 0) {
        }
        if ((DIRTY_FLAG_GRID_FULL & dirtyFlags) != 0) {
        }
        if ((dirtyFlags & DIRTY_FLAG_GRID_HALF) != 0) {
        }
        if ((dirtyFlags & DIRTY_FLAG_WAVE_INTENSITY) != 0) {
        }
        if ((dirtyFlags & DIRTY_FLAG_GRID_NONE) != 0) {
        }
        if ((DIRTY_FLAG_COMPRESSION_RATIO & dirtyFlags) != 0) {
        }
        if ((DIRTY_FLAG_UTILITY_PARAM & dirtyFlags) != 0) {
        }
        if ((dirtyFlags & DIRTY_FLAG_WINDOW_PARAM_VISIBILITY) != 0) {
        }
        if ((dirtyFlags & DIRTY_FLAG_SOURCE1) != 0) {
        }
        if ((DIRTY_FLAG_SOURCE1_COLOR & dirtyFlags) != 0) {
        }
        if ((dirtyFlags & DIRTY_FLAG_SOURCE2) != 0) {
        }
        if ((DIRTY_FLAG_SOURCE2_COLOR & dirtyFlags) != 0) {
        }
        if ((dirtyFlags & DIRTY_FLAG_WAVE_WIDTH) == 0) {
        }
    }
}
