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
import com.rigol.scope.R;
import com.rigol.scope.data.BaseProperty;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.data.XYParam;
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
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1620
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewXyBindingImpl.executeBindings():void");
    }
}
