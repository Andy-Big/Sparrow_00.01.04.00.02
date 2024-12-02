package com.rigol.scope.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
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
    */
    protected void executeBindings() {
        long j;
        long j2;
        String str;
        String str2;
        int i;
        boolean z;
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i3;
        boolean z6;
        boolean z7;
        int i4;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int i5;
        boolean z14;
        Drawable drawable;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        float f;
        float f2;
        float f3;
        float f4;
        String str14;
        String str15;
        boolean z15;
        String str16;
        long j3;
        int i6;
        String str17;
        boolean z16;
        float f5;
        String str18;
        int i7;
        boolean z17;
        String str19;
        String str20;
        boolean z18;
        float f6;
        String str21;
        boolean z19;
        float f7;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        String str27;
        boolean z26;
        boolean z27;
        boolean z28;
        float f8;
        int i8;
        int i9;
        Drawable drawable2;
        String str28;
        boolean z29;
        boolean z30;
        boolean z31;
        String str29;
        String str30;
        boolean z32;
        int i10;
        boolean z33;
        boolean z34;
        boolean z35;
        boolean z36;
        boolean z37;
        String str31;
        String str32;
        boolean z38;
        ServiceEnum.MathWaveType mathWaveType;
        int i11;
        ServiceEnum.enPeakOrder enpeakorder;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        int i12;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mGridFullMapping;
        MappingObject mappingObject2 = this.mDbMapping;
        MappingObject mappingObject3 = this.mVrmsMapping;
        MathParam mathParam = this.mParam;
        MappingObject mappingObject4 = this.mGridHalfMapping;
        MappingObject mappingObject5 = this.mGridNoneMapping;
        MappingObject mappingObject6 = this.mFreqOrderMapping;
        MappingObject mappingObject7 = this.mSPanCenterMapping;
        MappingObject mappingObject8 = this.mStartEndMapping;
        MappingObject mappingObject9 = this.mAmpOrderMapping;
        String str33 = null;
        String str34 = ((j & 35184372097025L) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        String str35 = ((j & 35184372105218L) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        String str36 = ((j & 35184372121608L) == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        float f9 = 0.0f;
        boolean z39 = false;
        if ((j & 35734127839252L) != 0) {
            String peakExcursionStr = ((j & 35321811042320L) == 0 || mathParam == null) ? null : mathParam.getPeakExcursionStr();
            String fftScaleStr = ((j & 35184640524304L) == 0 || mathParam == null) ? null : mathParam.getFftScaleStr();
            if ((j & 35184372154388L) != 0) {
                ServiceEnum.Chan sourceFftIndex = mathParam != null ? mathParam.getSourceFftIndex() : null;
                MappingObject mappingObject10 = ViewUtil.getMappingObject(R.array.msg_math_fft_s32src, sourceFftIndex != null ? sourceFftIndex.value1 : 0);
                updateRegistration(2, mappingObject10);
                str17 = mappingObject10 != null ? mappingObject10.getStr() : null;
                j3 = 0;
                i6 = (j & 35184372154384L) != 0 ? ColorUtil.getColor(getRoot().getContext(), sourceFftIndex) : 0;
            } else {
                j3 = 0;
                i6 = 0;
                str17 = null;
            }
            if ((j & 35201551958032L) != j3) {
                z16 = mathParam != null ? mathParam.isPeakSearch() : false;
                f5 = ContextUtil.getAlpha(z16);
            } else {
                z16 = false;
                f5 = 0.0f;
            }
            if ((j & 35218731827216L) != j3) {
                if (mathParam != null) {
                    i7 = i6;
                    str18 = str17;
                    i12 = mathParam.getPeakNum();
                } else {
                    str18 = str17;
                    i7 = i6;
                    i12 = 0;
                }
                z17 = z16;
                str19 = str35;
                str = str36;
                str20 = UnitFormat.newBuilder(UnitFormat.PATTERN_SIGN, UnitFormat.SI.NONE).convert(i12);
            } else {
                str18 = str17;
                i7 = i6;
                str = str36;
                z17 = z16;
                str19 = str35;
                str20 = null;
            }
            String peakThresholdStr = ((j & 35253091565584L) == 0 || mathParam == null) ? null : mathParam.getPeakThresholdStr();
            if ((j & 35192962023440L) != 0) {
                z18 = mathParam != null ? mathParam.getStatus() : false;
                f6 = ContextUtil.getAlpha(z18);
            } else {
                z18 = false;
                f6 = 0.0f;
            }
            boolean isColorGrade = ((j & 35186519572496L) == 0 || mathParam == null) ? false : mathParam.isColorGrade();
            String str37 = str20;
            if ((j & 35184373137424L) != 0) {
                if (mathParam != null) {
                    str21 = peakThresholdStr;
                    j9 = mathParam.getFftSpan();
                    z19 = z18;
                } else {
                    str21 = peakThresholdStr;
                    z19 = z18;
                    j9 = 0;
                }
                f7 = f6;
                str22 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(j9) + ServiceEnum.Unit.Unit_hz.value2, 6);
            } else {
                str21 = peakThresholdStr;
                z19 = z18;
                f7 = f6;
                str22 = null;
            }
            String labelString = ((35184908959760L & j) == 0 || mathParam == null) ? null : mathParam.getLabelString();
            if ((35184388866064L & j) != 0) {
                if (mathParam != null) {
                    j8 = mathParam.getFftEnd();
                    str23 = str22;
                } else {
                    str23 = str22;
                    j8 = 0;
                }
                str24 = labelString;
                str25 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(j8) + ServiceEnum.Unit.Unit_hz.value2, 6);
            } else {
                str23 = str22;
                str24 = labelString;
                str25 = null;
            }
            if ((35188667056144L & j) != 0) {
                ServiceEnum.EWaveGrids grids = mathParam != null ? mathParam.getGrids() : null;
                z22 = grids == ServiceEnum.EWaveGrids.GRID_IS_FULL;
                str26 = str25;
                z21 = grids == ServiceEnum.EWaveGrids.GRID_IS_HALF;
                z20 = grids == ServiceEnum.EWaveGrids.GRID_IS_NONE;
            } else {
                str26 = str25;
                z20 = false;
                z21 = false;
                z22 = false;
            }
            if ((j & 35184380477456L) != 0) {
                if (mathParam != null) {
                    z23 = z20;
                    z24 = z21;
                    j7 = mathParam.getFftStart();
                } else {
                    z23 = z20;
                    z24 = z21;
                    j7 = 0;
                }
                z25 = z22;
                str27 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(j7) + ServiceEnum.Unit.Unit_hz.value2, 6);
            } else {
                z23 = z20;
                z24 = z21;
                z25 = z22;
                str27 = null;
            }
            if ((35184372613136L & j) != 0) {
                ServiceEnum.fftSpecUnit fftUnitIndex = mathParam != null ? mathParam.getFftUnitIndex() : null;
                z27 = fftUnitIndex == ServiceEnum.fftSpecUnit.fft_spec_db;
                z26 = fftUnitIndex == ServiceEnum.fftSpecUnit.fft_spec_rms;
            } else {
                z26 = false;
                z27 = false;
            }
            if ((j & 35184439197712L) != 0) {
                z28 = mathParam != null ? mathParam.isZoomEn() : false;
                f8 = ContextUtil.getAlpha(z28);
            } else {
                z28 = false;
                f8 = 0.0f;
            }
            int i13 = ((j & 35184372219920L) > 0L ? 1 : ((j & 35184372219920L) == 0L ? 0 : -1));
            int i14 = 8;
            if (i13 != 0) {
                boolean isShowPeakSetting = mathParam != null ? mathParam.isShowPeakSetting() : false;
                if (i13 != 0) {
                    if (isShowPeakSetting) {
                        j5 = j | 2251799813685248L | 9007199254740992L;
                        j6 = 36028797018963968L;
                    } else {
                        j5 = j | 1125899906842624L | 4503599627370496L;
                        j6 = 18014398509481984L;
                    }
                    j = j5 | j6;
                }
                int i15 = isShowPeakSetting ? 0 : 8;
                i9 = isShowPeakSetting ? 8 : 0;
                long j10 = j;
                Context context = this.peakSearchImage.getContext();
                int i16 = isShowPeakSetting ? R.drawable.ic_arrow_down3 : R.drawable.ic_arrow_up3;
                i8 = i15;
                drawable2 = AppCompatResources.getDrawable(context, i16);
                j = j10;
            } else {
                i8 = 0;
                i9 = 0;
                drawable2 = null;
            }
            if ((j & 35184376283152L) != 0) {
                if (mathParam != null) {
                    z30 = z27;
                    str28 = str27;
                    z29 = z26;
                    j4 = mathParam.getFftCenter();
                } else {
                    str28 = str27;
                    z29 = z26;
                    z30 = z27;
                    j4 = 0;
                }
                z31 = z28;
                str29 = ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(j4) + ServiceEnum.Unit.Unit_hz.value2, 6);
            } else {
                str28 = str27;
                z29 = z26;
                z30 = z27;
                z31 = z28;
                str29 = null;
            }
            int i17 = ((j & 35184372350992L) > 0L ? 1 : ((j & 35184372350992L) == 0L ? 0 : -1));
            if (i17 != 0) {
                ServiceEnum.FftxType fftxTypeIndex = mathParam != null ? mathParam.getFftxTypeIndex() : null;
                str30 = str29;
                z33 = fftxTypeIndex == ServiceEnum.FftxType.fft_start_end;
                z32 = fftxTypeIndex == ServiceEnum.FftxType.fft_span_center;
                if (i17 != 0) {
                    j |= z33 ? 140737488355328L : 70368744177664L;
                }
                if ((j & 35184372350992L) != 0) {
                    j |= z32 ? 562949953421312L : 281474976710656L;
                }
                i10 = z33 ? 0 : 8;
                if (z32) {
                    i14 = 0;
                }
            } else {
                str30 = str29;
                z32 = false;
                i10 = 0;
                z33 = false;
                i14 = 0;
            }
            if ((j & 35459249995792L) != 0) {
                if (mathParam != null) {
                    enpeakorder = mathParam.getFftPeakOrderIndex();
                    z34 = z32;
                } else {
                    z34 = z32;
                    enpeakorder = null;
                }
                z36 = enpeakorder == ServiceEnum.enPeakOrder.fft_peak_AmpOrder;
                z35 = enpeakorder == ServiceEnum.enPeakOrder.fft_peak_FreqOrder;
            } else {
                z34 = z32;
                z35 = false;
                z36 = false;
            }
            if ((j & 35184405645328L) != 0) {
                ServiceEnum.fftWindow fftWindowIndex = mathParam != null ? mathParam.getFftWindowIndex() : null;
                if (fftWindowIndex != null) {
                    i11 = fftWindowIndex.value1;
                    z37 = z35;
                } else {
                    z37 = z35;
                    i11 = 0;
                }
                MappingObject mappingObject11 = ViewUtil.getMappingObject(R.array.msg_math_fft_s32window, i11);
                updateRegistration(11, mappingObject11);
                if (mappingObject11 != null) {
                    str31 = mappingObject11.getStr();
                    if ((j & 35184374186000L) == 0) {
                        if (mathParam != null) {
                            mathWaveType = mathParam.getWaveType();
                            str32 = str31;
                        } else {
                            str32 = str31;
                            mathWaveType = null;
                        }
                        boolean z40 = mathWaveType == ServiceEnum.MathWaveType.MathWave_Zoom;
                        f9 = ContextUtil.getAlpha(mathWaveType == ServiceEnum.MathWaveType.MathWave_Main);
                        z38 = z40;
                    } else {
                        str32 = str31;
                        z38 = false;
                    }
                    j2 = 0;
                    String fftOffsetStr = ((j & 35184506306576L) != 0 || mathParam == null) ? null : mathParam.getFftOffsetStr();
                    if ((j & 35185445830672L) != 0 && mathParam != null) {
                        z39 = mathParam.isLabel();
                    }
                    z8 = z38;
                    i4 = i10;
                    z7 = z33;
                    z12 = z39;
                    str12 = peakExcursionStr;
                    f2 = f9;
                    str13 = fftScaleStr;
                    f = f5;
                    str3 = str18;
                    i5 = i7;
                    z5 = z17;
                    str11 = str21;
                    str14 = str37;
                    str9 = str30;
                    z13 = z19;
                    f3 = f7;
                    str7 = str23;
                    str5 = str24;
                    z11 = z23;
                    z10 = z24;
                    z9 = z25;
                    f4 = f8;
                    drawable = drawable2;
                    i3 = i14;
                    i2 = i8;
                    str6 = str28;
                    z4 = z29;
                    z = z30;
                    z14 = z31;
                    z6 = z34;
                    z2 = z36;
                    str10 = str32;
                    str2 = str34;
                    str4 = fftOffsetStr;
                    str15 = str19;
                    z15 = isColorGrade;
                    str8 = str26;
                    i = i9;
                    z3 = z37;
                }
            } else {
                z37 = z35;
            }
            str31 = null;
            if ((j & 35184374186000L) == 0) {
            }
            j2 = 0;
            if ((j & 35184506306576L) != 0) {
            }
            if ((j & 35185445830672L) != 0) {
                z39 = mathParam.isLabel();
            }
            z8 = z38;
            i4 = i10;
            z7 = z33;
            z12 = z39;
            str12 = peakExcursionStr;
            f2 = f9;
            str13 = fftScaleStr;
            f = f5;
            str3 = str18;
            i5 = i7;
            z5 = z17;
            str11 = str21;
            str14 = str37;
            str9 = str30;
            z13 = z19;
            f3 = f7;
            str7 = str23;
            str5 = str24;
            z11 = z23;
            z10 = z24;
            z9 = z25;
            f4 = f8;
            drawable = drawable2;
            i3 = i14;
            i2 = i8;
            str6 = str28;
            z4 = z29;
            z = z30;
            z14 = z31;
            z6 = z34;
            z2 = z36;
            str10 = str32;
            str2 = str34;
            str4 = fftOffsetStr;
            str15 = str19;
            z15 = isColorGrade;
            str8 = str26;
            i = i9;
            z3 = z37;
        } else {
            j2 = 0;
            str = str36;
            str2 = str34;
            i = 0;
            z = false;
            i2 = 0;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            i3 = 0;
            z6 = false;
            z7 = false;
            i4 = 0;
            z8 = false;
            z9 = false;
            z10 = false;
            z11 = false;
            z12 = false;
            z13 = false;
            i5 = 0;
            z14 = false;
            drawable = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
            str11 = null;
            str12 = null;
            str13 = null;
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
            f4 = 0.0f;
            str14 = null;
            str15 = str35;
            z15 = false;
        }
        int i18 = ((j & 35734127902752L) > j2 ? 1 : ((j & 35734127902752L) == j2 ? 0 : -1));
        String str38 = (i18 == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        int i19 = ((j & 36283883716672L) > j2 ? 1 : ((j & 36283883716672L) == j2 ? 0 : -1));
        String str39 = (i19 == 0 || mappingObject5 == null) ? null : mappingObject5.getStr();
        int i20 = ((j & 37383395344512L) > j2 ? 1 : ((j & 37383395344512L) == j2 ? 0 : -1));
        String str40 = (i20 == 0 || mappingObject6 == null) ? null : mappingObject6.getStr();
        int i21 = ((j & 39582418600192L) > j2 ? 1 : ((j & 39582418600192L) == j2 ? 0 : -1));
        String str41 = (i21 == 0 || mappingObject7 == null) ? null : mappingObject7.getStr();
        int i22 = ((j & 43980465111552L) > j2 ? 1 : ((j & 43980465111552L) == j2 ? 0 : -1));
        String str42 = (i22 == 0 || mappingObject8 == null) ? null : mappingObject8.getStr();
        int i23 = ((j & 52776558134272L) > j2 ? 1 : ((j & 52776558134272L) == j2 ? 0 : -1));
        if (i23 != 0 && mappingObject9 != null) {
            str33 = mappingObject9.getStr();
        }
        String str43 = str33;
        if ((j & 35459249995792L) != j2) {
            str16 = str42;
            CompoundButtonBindingAdapter.setChecked(this.AmpRadioButton, z2);
            CompoundButtonBindingAdapter.setChecked(this.FreqRadioButton, z3);
        } else {
            str16 = str42;
        }
        if (i23 != 0) {
            TextViewBindingAdapter.setText(this.AmpRadioButton, str43);
        }
        if (i20 != 0) {
            TextViewBindingAdapter.setText(this.FreqRadioButton, str40);
        }
        if ((35184372219920L & j) != 0) {
            this.basicSetting.setVisibility(i);
            ImageViewBindingAdapter.setImageDrawable(this.peakSearchImage, drawable);
            this.peakSearchSetting.setVisibility(i2);
        }
        if ((j & 35186519572496L) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.colorGradeSwitch, z15);
        }
        if ((35184372613136L & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.dbRadioButton, z);
            CompoundButtonBindingAdapter.setChecked(this.vrmsRadioButton, z4);
        }
        if ((j & 35184372105218L) != 0) {
            TextViewBindingAdapter.setText(this.dbRadioButton, str15);
        }
        if ((j & 35321811042320L) != 0) {
            TextViewBindingAdapter.setText(this.excursionEditText, str12);
        }
        if ((j & 35201551958032L) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.exportBtn.setAlpha(f);
            }
            boolean z41 = z5;
            this.exportBtn.setEnabled(z41);
            CompoundButtonBindingAdapter.setChecked(this.peakSearchSwitch, z41);
        }
        if ((35184374186000L & j) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.fftCenter.setAlpha(f2);
            }
            CompoundButtonBindingAdapter.setChecked(this.waveTypeSwitch, z8);
        }
        if ((j & 35184372350992L) != 0) {
            int i24 = i3;
            this.fftCenter.setVisibility(i24);
            this.fftCenterEditText.setVisibility(i24);
            int i25 = i4;
            this.fftEnd.setVisibility(i25);
            this.fftEndEditText.setVisibility(i25);
            this.fftSpan.setVisibility(i24);
            this.fftSpanEditText.setVisibility(i24);
            this.fftStart.setVisibility(i25);
            this.fftStartEditText.setVisibility(i25);
            CompoundButtonBindingAdapter.setChecked(this.spanCenterRadioButton, z6);
            CompoundButtonBindingAdapter.setChecked(this.startEndRadioButton, z7);
        }
        if ((35184376283152L & j) != 0) {
            TextViewBindingAdapter.setText(this.fftCenterEditText, str9);
        }
        if ((35184388866064L & j) != 0) {
            TextViewBindingAdapter.setText(this.fftEndEditText, str8);
        }
        if ((35184373137424L & j) != 0) {
            TextViewBindingAdapter.setText(this.fftSpanEditText, str7);
        }
        if ((35184380477456L & j) != 0) {
            TextViewBindingAdapter.setText(this.fftStartEditText, str6);
        }
        if ((35188667056144L & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.fullRadioButton, z9);
            CompoundButtonBindingAdapter.setChecked(this.halfRadioButton, z10);
            CompoundButtonBindingAdapter.setChecked(this.noneRadioButton, z11);
        }
        if ((35184372097025L & j) != 0) {
            TextViewBindingAdapter.setText(this.fullRadioButton, str2);
        }
        if (i18 != 0) {
            TextViewBindingAdapter.setText(this.halfRadioButton, str38);
        }
        if ((35184908959760L & j) != 0) {
            TextViewBindingAdapter.setText(this.labelEditText, str5);
        }
        if ((35185445830672L & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.labelSwitch, z12);
        }
        if (i19 != 0) {
            TextViewBindingAdapter.setText(this.noneRadioButton, str39);
        }
        if ((35184506306576L & j) != 0) {
            TextViewBindingAdapter.setText(this.offsetEditText, str4);
        }
        if ((j & 35218731827216L) != 0) {
            TextViewBindingAdapter.setText(this.peakNumberEditText, str14);
        }
        if ((j & 35192962023440L) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.peakSearchSwitch.setAlpha(f3);
            }
            this.peakSearchSwitch.setEnabled(z13);
        }
        if ((j & 35184640524304L) != 0) {
            TextViewBindingAdapter.setText(this.scaleEditText, str13);
        }
        if ((j & 35184372154388L) != 0) {
            TextViewBindingAdapter.setText(this.sourceASpinner, str3);
        }
        if ((j & 35184372154384L) != 0) {
            this.sourceASpinner.setTextColor(i5);
        }
        if (i21 != 0) {
            TextViewBindingAdapter.setText(this.spanCenterRadioButton, str41);
        }
        if (i22 != 0) {
            TextViewBindingAdapter.setText(this.startEndRadioButton, str16);
        }
        if ((j & 35253091565584L) != 0) {
            TextViewBindingAdapter.setText(this.thresholdEditText, str11);
        }
        if ((j & 35184372121608L) != 0) {
            TextViewBindingAdapter.setText(this.vrmsRadioButton, str);
        }
        if ((35184439197712L & j) != 0) {
            if (getBuildSdkInt() >= 11) {
                float f10 = f4;
                this.waveType.setAlpha(f10);
                this.waveTypeSwitch.setAlpha(f10);
            }
            this.waveTypeSwitch.setEnabled(z14);
        }
        if ((j & 35184405645328L) != 0) {
            TextViewBindingAdapter.setText(this.windowSpinner, str10);
        }
    }
}
