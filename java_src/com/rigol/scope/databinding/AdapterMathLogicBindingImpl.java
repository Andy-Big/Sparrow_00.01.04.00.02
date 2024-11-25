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
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MathParam;
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
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1623
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterMathLogicBindingImpl.executeBindings():void");
    }
}
