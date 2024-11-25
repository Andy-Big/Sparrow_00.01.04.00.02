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
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MathParam;
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
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterMathFunBindingImpl.executeBindings():void");
    }
}
