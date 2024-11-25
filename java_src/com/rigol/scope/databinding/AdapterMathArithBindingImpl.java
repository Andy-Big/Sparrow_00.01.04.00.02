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
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 977
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterMathArithBindingImpl.executeBindings():void");
    }
}
