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
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1691
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterMathFilterBindingImpl.executeBindings():void");
    }
}
