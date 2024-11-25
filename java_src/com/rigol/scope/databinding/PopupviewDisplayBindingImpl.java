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
import com.rigol.scope.R;
import com.rigol.scope.data.DisplayParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
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
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1198
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewDisplayBindingImpl.executeBindings():void");
    }
}
