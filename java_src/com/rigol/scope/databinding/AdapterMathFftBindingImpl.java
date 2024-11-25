package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
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
public class AdapterMathFftBindingImpl extends AdapterMathFftBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 35);
        sViewsWithIds.put(R.id.sourceA, 36);
        sViewsWithIds.put(R.id.auto_setting_btn, 37);
        sViewsWithIds.put(R.id.math_guideline_center, 38);
        sViewsWithIds.put(R.id.math_dividing_line, 39);
        sViewsWithIds.put(R.id.X, 40);
        sViewsWithIds.put(R.id.X_radio_group, 41);
        sViewsWithIds.put(R.id.unit, 42);
        sViewsWithIds.put(R.id.unit_radio_group, 43);
        sViewsWithIds.put(R.id.window, 44);
        sViewsWithIds.put(R.id.offset, 45);
        sViewsWithIds.put(R.id.math_offset_up, 46);
        sViewsWithIds.put(R.id.math_offset_down, 47);
        sViewsWithIds.put(R.id.scale, 48);
        sViewsWithIds.put(R.id.main_scale_vertical, 49);
        sViewsWithIds.put(R.id.main_scale_nomal, 50);
        sViewsWithIds.put(R.id.label, 51);
        sViewsWithIds.put(R.id.color_grade, 52);
        sViewsWithIds.put(R.id.color_grade_reset, 53);
        sViewsWithIds.put(R.id.grid_type, 54);
        sViewsWithIds.put(R.id.grid_type_radio_group, 55);
        sViewsWithIds.put(R.id.peak_search_title, 56);
        sViewsWithIds.put(R.id.peak_search_text, 57);
        sViewsWithIds.put(R.id.peak_guideline_center, 58);
        sViewsWithIds.put(R.id.peak_search, 59);
        sViewsWithIds.put(R.id.peak_number, 60);
        sViewsWithIds.put(R.id.threshold, 61);
        sViewsWithIds.put(R.id.excursion, 62);
        sViewsWithIds.put(R.id.table_order, 63);
        sViewsWithIds.put(R.id.table_order_radio_group, 64);
    }

    public AdapterMathFftBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 65, sIncludes, sViewsWithIds));
    }

    private AdapterMathFftBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 12, (RadioButton) objArr[32], (RadioButton) objArr[33], (TextView) objArr[40], (RadioGroup) objArr[41], (Button) objArr[37], (ConstraintLayout) objArr[2], (TextView) objArr[52], (Button) objArr[53], (SwitchButton) objArr[22], (RadioButton) objArr[5], (TextView) objArr[62], (EditText) objArr[31], (Button) objArr[34], (TextView) objArr[9], (EditText) objArr[10], (TextView) objArr[13], (EditText) objArr[14], (TextView) objArr[7], (EditText) objArr[8], (TextView) objArr[11], (EditText) objArr[12], (RadioButton) objArr[23], (TextView) objArr[54], (RadioGroup) objArr[55], (Guideline) objArr[35], (RadioButton) objArr[24], (TextView) objArr[51], (BaseEditText) objArr[20], (SwitchButton) objArr[21], (ImageButton) objArr[50], (ImageButton) objArr[49], (View) objArr[39], (Guideline) objArr[38], (ImageButton) objArr[47], (ImageButton) objArr[46], (RadioButton) objArr[25], (TextView) objArr[45], (EditText) objArr[18], (Guideline) objArr[58], (TextView) objArr[60], (EditText) objArr[29], (TextView) objArr[59], (ImageView) objArr[26], (ConstraintLayout) objArr[27], (SwitchButton) objArr[28], (TextView) objArr[57], (ConstraintLayout) objArr[56], (TextView) objArr[48], (EditText) objArr[19], (TextView) objArr[36], (TextView) objArr[1], (RadioButton) objArr[3], (RadioButton) objArr[4], (TextView) objArr[63], (RadioGroup) objArr[64], (TextView) objArr[61], (EditText) objArr[30], (TextView) objArr[42], (RadioGroup) objArr[43], (RadioButton) objArr[6], (TextView) objArr[16], (SwitchButton) objArr[17], (TextView) objArr[44], (TextView) objArr[15]);
        this.mDirtyFlags = -1L;
        this.AmpRadioButton.setTag(null);
        this.FreqRadioButton.setTag(null);
        this.basicSetting.setTag(null);
        this.colorGradeSwitch.setTag(null);
        this.dbRadioButton.setTag(null);
        this.excursionEditText.setTag(null);
        this.exportBtn.setTag(null);
        this.fftCenter.setTag(null);
        this.fftCenterEditText.setTag(null);
        this.fftEnd.setTag(null);
        this.fftEndEditText.setTag(null);
        this.fftSpan.setTag(null);
        this.fftSpanEditText.setTag(null);
        this.fftStart.setTag(null);
        this.fftStartEditText.setTag(null);
        this.fullRadioButton.setTag(null);
        this.halfRadioButton.setTag(null);
        this.labelEditText.setTag(null);
        this.labelSwitch.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.noneRadioButton.setTag(null);
        this.offsetEditText.setTag(null);
        this.peakNumberEditText.setTag(null);
        this.peakSearchImage.setTag(null);
        this.peakSearchSetting.setTag(null);
        this.peakSearchSwitch.setTag(null);
        this.scaleEditText.setTag(null);
        this.sourceASpinner.setTag(null);
        this.spanCenterRadioButton.setTag(null);
        this.startEndRadioButton.setTag(null);
        this.thresholdEditText.setTag(null);
        this.vrmsRadioButton.setTag(null);
        this.waveType.setTag(null);
        this.waveTypeSwitch.setTag(null);
        this.windowSpinner.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 35184372088832L;
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
            return true;
        } else if (4 == i) {
            setDbMapping((MappingObject) obj);
            return true;
        } else if (21 == i) {
            setVrmsMapping((MappingObject) obj);
            return true;
        } else if (594 == i) {
            setParam((MathParam) obj);
            return true;
        } else if (359 == i) {
            setGridHalfMapping((MappingObject) obj);
            return true;
        } else if (361 == i) {
            setGridNoneMapping((MappingObject) obj);
            return true;
        } else if (451 == i) {
            setItemPosition((Integer) obj);
            return true;
        } else if (6 == i) {
            setFreqOrderMapping((MappingObject) obj);
            return true;
        } else if (17 == i) {
            setSPanCenterMapping((MappingObject) obj);
            return true;
        } else if (20 == i) {
            setStartEndMapping((MappingObject) obj);
            return true;
        } else if (1 == i) {
            setAmpOrderMapping((MappingObject) obj);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.rigol.scope.databinding.AdapterMathFftBinding
    public void setGridFullMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mGridFullMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(358);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathFftBinding
    public void setDbMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mDbMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathFftBinding
    public void setVrmsMapping(MappingObject mappingObject) {
        updateRegistration(3, mappingObject);
        this.mVrmsMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(21);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathFftBinding
    public void setParam(MathParam mathParam) {
        updateRegistration(4, mathParam);
        this.mParam = mathParam;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathFftBinding
    public void setGridHalfMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mGridHalfMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(359);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathFftBinding
    public void setGridNoneMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mGridNoneMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(361);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathFftBinding
    public void setItemPosition(Integer num) {
        this.mItemPosition = num;
    }

    @Override // com.rigol.scope.databinding.AdapterMathFftBinding
    public void setFreqOrderMapping(MappingObject mappingObject) {
        updateRegistration(7, mappingObject);
        this.mFreqOrderMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathFftBinding
    public void setSPanCenterMapping(MappingObject mappingObject) {
        updateRegistration(8, mappingObject);
        this.mSPanCenterMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathFftBinding
    public void setStartEndMapping(MappingObject mappingObject) {
        updateRegistration(9, mappingObject);
        this.mStartEndMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterMathFftBinding
    public void setAmpOrderMapping(MappingObject mappingObject) {
        updateRegistration(10, mappingObject);
        this.mAmpOrderMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeGridFullMapping((MappingObject) obj, i2);
            case 1:
                return onChangeDbMapping((MappingObject) obj, i2);
            case 2:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgMathFftS32srcParamSourceFftIndexValue1((MappingObject) obj, i2);
            case 3:
                return onChangeVrmsMapping((MappingObject) obj, i2);
            case 4:
                return onChangeParam((MathParam) obj, i2);
            case 5:
                return onChangeGridHalfMapping((MappingObject) obj, i2);
            case 6:
                return onChangeGridNoneMapping((MappingObject) obj, i2);
            case 7:
                return onChangeFreqOrderMapping((MappingObject) obj, i2);
            case 8:
                return onChangeSPanCenterMapping((MappingObject) obj, i2);
            case 9:
                return onChangeStartEndMapping((MappingObject) obj, i2);
            case 10:
                return onChangeAmpOrderMapping((MappingObject) obj, i2);
            case 11:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgMathFftS32windowParamFftWindowIndexValue1((MappingObject) obj, i2);
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
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeDbMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgMathFftS32srcParamSourceFftIndexValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeVrmsMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(MathParam mathParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 867) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 831) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 309) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 303) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 301) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 1039) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 294) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 302) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 295) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 304) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else if (i == 1089) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else if (i == 297) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else if (i == 300) {
            synchronized (this) {
                this.mDirtyFlags |= 268435456;
            }
            return true;
        } else if (i == 477) {
            synchronized (this) {
                this.mDirtyFlags |= 536870912;
            }
            return true;
        } else if (i == 475) {
            synchronized (this) {
                this.mDirtyFlags |= 1073741824;
            }
            return true;
        } else if (i == 185) {
            synchronized (this) {
                this.mDirtyFlags |= 2147483648L;
            }
            return true;
        } else if (i == 363) {
            synchronized (this) {
                this.mDirtyFlags |= 4294967296L;
            }
            return true;
        } else if (i == 909) {
            synchronized (this) {
                this.mDirtyFlags |= 8589934592L;
            }
            return true;
        } else if (i == 614) {
            synchronized (this) {
                this.mDirtyFlags |= 17179869184L;
            }
            return true;
        } else if (i == 612) {
            synchronized (this) {
                this.mDirtyFlags |= 34359738368L;
            }
            return true;
        } else if (i == 617) {
            synchronized (this) {
                this.mDirtyFlags |= 68719476736L;
            }
            return true;
        } else if (i == 610) {
            synchronized (this) {
                this.mDirtyFlags |= 137438953472L;
            }
            return true;
        } else if (i == 298) {
            synchronized (this) {
                this.mDirtyFlags |= 274877906944L;
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
                this.mDirtyFlags |= 549755813888L;
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
                this.mDirtyFlags |= 1099511627776L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeFreqOrderMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 2199023255552L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSPanCenterMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 4398046511104L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeStartEndMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 8796093022208L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeAmpOrderMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 17592186044416L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgMathFftS32windowParamFftWindowIndexValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:234:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x04b4  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 2150
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterMathFftBindingImpl.executeBindings():void");
    }
}
