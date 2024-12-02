package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.generated.callback.OnClickListener;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;

/* loaded from: classes2.dex */
public class PopupviewResultMeasureBindingImpl extends PopupviewResultMeasureBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback41;
    private final View.OnClickListener mCallback42;
    private final View.OnClickListener mCallback43;
    private final View.OnClickListener mCallback44;
    private final View.OnClickListener mCallback45;
    private final View.OnClickListener mCallback46;
    private final View.OnClickListener mCallback47;
    private final View.OnClickListener mCallback48;
    private final View.OnClickListener mCallback49;
    private final View.OnClickListener mCallback50;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 32);
        sViewsWithIds.put(R.id.guideline_left, 33);
        sViewsWithIds.put(R.id.guideline_right, 34);
        sViewsWithIds.put(R.id.guideline_right2, 35);
        sViewsWithIds.put(R.id.mode, 36);
        sViewsWithIds.put(R.id.mode_radio_group, 37);
        sViewsWithIds.put(R.id.histo_en, 38);
        sViewsWithIds.put(R.id.stat, 39);
        sViewsWithIds.put(R.id.stat_count, 40);
        sViewsWithIds.put(R.id.stat_reset, 41);
        sViewsWithIds.put(R.id.divider, 42);
        sViewsWithIds.put(R.id.threshold_display_type, 43);
        sViewsWithIds.put(R.id.threshold_source, 44);
        sViewsWithIds.put(R.id.threshold_diagram, 45);
        sViewsWithIds.put(R.id.high, 46);
        sViewsWithIds.put(R.id.mid, 47);
        sViewsWithIds.put(R.id.low, 48);
        sViewsWithIds.put(R.id.amp_method, 49);
        sViewsWithIds.put(R.id.measure_source, 50);
        sViewsWithIds.put(R.id.region, 51);
    }

    public PopupviewResultMeasureBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 52, sIncludes, sViewsWithIds));
    }

    private PopupviewResultMeasureBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 9, (TextView) objArr[49], (SwitchButton) objArr[18], (TextView) objArr[21], (SwitchButton) objArr[22], (TextView) objArr[26], (EditText) objArr[27], (TextView) objArr[24], (SwitchButton) objArr[25], (TextView) objArr[28], (EditText) objArr[29], (Button) objArr[31], (Button) objArr[30], (View) objArr[42], (Guideline) objArr[32], (Guideline) objArr[33], (Guideline) objArr[34], (Guideline) objArr[35], (TextView) objArr[46], (EditText) objArr[14], (TextView) objArr[38], (SwitchButton) objArr[4], (TextView) objArr[5], (SwitchButton) objArr[6], (TextView) objArr[48], (EditText) objArr[16], (TextView) objArr[50], (TextView) objArr[17], (TextView) objArr[47], (EditText) objArr[15], (TextView) objArr[36], (RadioGroup) objArr[37], (RadioButton) objArr[1], (TextView) objArr[51], (TextView) objArr[23], (CheckBox) objArr[12], (TextView) objArr[39], (TextView) objArr[40], (EditText) objArr[8], (TextView) objArr[41], (Button) objArr[9], (SwitchButton) objArr[7], (SwitchButton) objArr[3], (TextView) objArr[2], (Button) objArr[11], (ImageView) objArr[45], (TextView) objArr[43], (SwitchButton) objArr[10], (TextView) objArr[44], (TextView) objArr[13], (TextView) objArr[19], (SwitchButton) objArr[20]);
        this.mDirtyFlags = -1L;
        this.ampMethodSwitch.setTag(null);
        this.baseMethod.setTag(null);
        this.baseMethodSwitch.setTag(null);
        this.cursorA.setTag(null);
        this.cursorAEditText.setTag(null);
        this.cursorAb.setTag(null);
        this.cursorAbSwitch.setTag(null);
        this.cursorB.setTag(null);
        this.cursorBEditText.setTag(null);
        this.deleteAllButton.setTag(null);
        this.deleteButton.setTag(null);
        this.highEditText.setTag(null);
        this.histoEnSwitch.setTag(null);
        this.indicator.setTag(null);
        this.indicatorSwitch.setTag(null);
        this.lowEditText.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.measureSourceSpinner.setTag(null);
        this.midEditText.setTag(null);
        this.precisionRadioButton.setTag(null);
        this.regionSpinner.setTag(null);
        this.showLine.setTag(null);
        this.statCountEditText.setTag(null);
        this.statResetButton.setTag(null);
        this.statSwitch.setTag(null);
        this.threSwitch.setTag(null);
        this.threText.setTag(null);
        this.thresholdDefaultButton.setTag(null);
        this.thresholdDisplayTypeSwitch.setTag(null);
        this.thresholdSourceSpinner.setTag(null);
        this.topMethod.setTag(null);
        this.topMethodSwitch.setTag(null);
        setRootTag(view);
        this.mCallback43 = new OnClickListener(this, 3);
        this.mCallback42 = new OnClickListener(this, 2);
        this.mCallback44 = new OnClickListener(this, 4);
        this.mCallback49 = new OnClickListener(this, 9);
        this.mCallback41 = new OnClickListener(this, 1);
        this.mCallback47 = new OnClickListener(this, 7);
        this.mCallback50 = new OnClickListener(this, 10);
        this.mCallback48 = new OnClickListener(this, 8);
        this.mCallback45 = new OnClickListener(this, 5);
        this.mCallback46 = new OnClickListener(this, 6);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 17179869184L;
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
        if (1027 == i) {
            setVerticalParam((VerticalParam) obj);
        } else if (594 == i) {
            setParam((MeasureSettingParam) obj);
        } else if (569 == i) {
            setOnClickListener((View.OnClickListener) obj);
        } else if (380 == i) {
            setHorizontal((HorizontalParam) obj);
        } else if (653 == i) {
            setPrecisionMapping((MappingObject) obj);
        } else if (823 == i) {
            setSharedParam((SharedParam) obj);
        } else if (560 != i) {
            return false;
        } else {
            setNormalMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewResultMeasureBinding
    public void setVerticalParam(VerticalParam verticalParam) {
        updateRegistration(0, verticalParam);
        this.mVerticalParam = verticalParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1027);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultMeasureBinding
    public void setParam(MeasureSettingParam measureSettingParam) {
        updateRegistration(1, measureSettingParam);
        this.mParam = measureSettingParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultMeasureBinding
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(569);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultMeasureBinding
    public void setHorizontal(HorizontalParam horizontalParam) {
        updateRegistration(3, horizontalParam);
        this.mHorizontal = horizontalParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(380);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultMeasureBinding
    public void setPrecisionMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mPrecisionMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(653);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultMeasureBinding
    public void setSharedParam(SharedParam sharedParam) {
        updateRegistration(6, sharedParam);
        this.mSharedParam = sharedParam;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(823);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultMeasureBinding
    public void setNormalMapping(MappingObject mappingObject) {
        this.mNormalMapping = mappingObject;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeVerticalParam((VerticalParam) obj, i2);
            case 1:
                return onChangeParam((MeasureSettingParam) obj, i2);
            case 2:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAppMeasThSrcParamThresholdSourceValue1((MappingObject) obj, i2);
            case 3:
                return onChangeHorizontal((HorizontalParam) obj, i2);
            case 4:
                return onChangePrecisionMapping((MappingObject) obj, i2);
            case 5:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanListComRigolScopeRArrayMsgAppMeasSrcaParamAllItemSourceValue1((MappingObject) obj, i2);
            case 6:
                return onChangeSharedParam((SharedParam) obj, i2);
            case 7:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAppMeasRegionParamRegion((MappingObject) obj, i2);
            case 8:
                return onChangeNormalMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeVerticalParam(VerticalParam verticalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 987) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(MeasureSettingParam measureSettingParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 544) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 207) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 374) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 204) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 908) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 903) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 932) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 840) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 931) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 928) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 930) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 929) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 43) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 535) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 941) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else if (i == 72) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else if (i == 734) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else if (i == 199) {
            synchronized (this) {
                this.mDirtyFlags |= 268435456;
            }
            return true;
        } else if (i == 201) {
            synchronized (this) {
                this.mDirtyFlags |= 536870912;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAppMeasThSrcParamThresholdSourceValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeHorizontal(HorizontalParam horizontalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 28) {
            synchronized (this) {
                this.mDirtyFlags |= 1073741824;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangePrecisionMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgChanListComRigolScopeRArrayMsgAppMeasSrcaParamAllItemSourceValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSharedParam(SharedParam sharedParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 833) {
            synchronized (this) {
                this.mDirtyFlags |= 4294967296L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAppMeasRegionParamRegion(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 8589934592L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ec, code lost:
        if (r15 != false) goto L412;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01b3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x057b  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x05a8  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0623  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0636  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x063b  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0646  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0654  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0679  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0688  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x06b4  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0706  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0717  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0726  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0733  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0755  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0766  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0773  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x07a4  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x07ad  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x07be  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x07cf  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x07d8  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x07e9  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x07f6  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0807  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0814  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0821  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0832  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x083b  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x084e  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x085f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0870  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x087d  */
    /* JADX WARN: Removed duplicated region for block: B:430:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0168  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        boolean z;
        int i;
        boolean z2;
        int i2;
        boolean z3;
        boolean z4;
        int i3;
        boolean z5;
        int i4;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z11;
        float f;
        boolean z12;
        int i5;
        boolean z13;
        ServiceEnum.Unit unit;
        ServiceEnum.Unit unit2;
        float f2;
        float f3;
        boolean z14;
        int i6;
        String str8;
        boolean z15;
        boolean z16;
        String str9;
        long j2;
        long j3;
        long j4;
        String str10;
        String str11;
        int i7;
        String str12;
        boolean z17;
        int i8;
        boolean z18;
        boolean z19;
        String str13;
        String str14;
        String str15;
        int i9;
        String str16;
        int i10;
        int i11;
        ServiceEnum.Unit unit3;
        String str17;
        long j5;
        boolean z20;
        long j6;
        long j7;
        ServiceEnum.AcquireMode acquireMode;
        boolean z21;
        int i12;
        int i13;
        boolean z22;
        String str18;
        String str19;
        String str20;
        boolean z23;
        int i14;
        String str21;
        int i15;
        String str22;
        boolean z24;
        int i16;
        String str23;
        String str24;
        boolean z25;
        boolean z26;
        int i17;
        String str25;
        String str26;
        boolean z27;
        int i18;
        long j8;
        int i19;
        ServiceEnum.Chan chan;
        int i20;
        int i21;
        int i22;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        VerticalParam verticalParam = this.mVerticalParam;
        MeasureSettingParam measureSettingParam = this.mParam;
        View.OnClickListener onClickListener = this.mOnClickListener;
        HorizontalParam horizontalParam = this.mHorizontal;
        MappingObject mappingObject = this.mPrecisionMapping;
        SharedParam sharedParam = this.mSharedParam;
        boolean z28 = false;
        if ((26843524263L & j) != 0) {
            if ((j & 17213423618L) != 0) {
                if ((measureSettingParam != null ? measureSettingParam.getTopMethod() : 0) == 1) {
                    z21 = true;
                    boolean showThresLine = ((j & 17180131330L) != 0 || measureSettingParam == null) ? false : measureSettingParam.getShowThresLine();
                    i12 = ((j & 17196646402L) > 0L ? 1 : ((j & 17196646402L) == 0L ? 0 : -1));
                    int i23 = 8;
                    if (i12 == 0) {
                        z22 = measureSettingParam != null ? measureSettingParam.getMethodState() : false;
                        if (i12 != 0) {
                            j |= z22 ? 4398046511104L : 2199023255552L;
                        }
                        i13 = z22 ? 0 : 8;
                    } else {
                        i13 = 0;
                        z22 = false;
                    }
                    if ((j & 17179934722L) == 0) {
                        str18 = String.valueOf(measureSettingParam != null ? measureSettingParam.getStatCount() : 0);
                    } else {
                        str18 = null;
                    }
                    boolean statisticState = ((j & 17179901954L) != 0 || measureSettingParam == null) ? false : measureSettingParam.getStatisticState();
                    if ((j & 25904021634L) == 0) {
                        int region = measureSettingParam != null ? measureSettingParam.getRegion() : 0;
                        int i24 = ((j & 17314086914L) > 0L ? 1 : ((j & 17314086914L) == 0L ? 0 : -1));
                        if (i24 != 0) {
                            boolean z29 = region == 2;
                            if (i24 != 0) {
                                j |= z29 ? 17592186044416L : 8796093022208L;
                            }
                        }
                        i23 = 0;
                        MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_app_meas_region, region);
                        updateRegistration(7, mappingObject2);
                        if (mappingObject2 != null) {
                            str19 = mappingObject2.getStr();
                            if ((j & 17448304642L) != 0) {
                                str20 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(measureSettingParam != null ? measureSettingParam.getCursorA() : 0L, ServiceEnum.Unit.Unit_s);
                            } else {
                                str20 = null;
                            }
                            if ((17180000258L & j) != 0) {
                                if ((measureSettingParam != null ? measureSettingParam.getThresholdType() : null) == ServiceEnum.ThreType.TH_TYPE_ABS) {
                                    z23 = true;
                                    if ((17179869186L & j) != 0) {
                                        if ((measureSettingParam != null ? measureSettingParam.readCursorBothAB() : 0L) == 2) {
                                            z3 = true;
                                            if ((j & 17180393478L) != 0) {
                                                ServiceEnum.Chan thresholdSource = measureSettingParam != null ? measureSettingParam.getThresholdSource() : null;
                                                i14 = (j & 17180393474L) != 0 ? ColorUtil.getColor(getRoot().getContext(), thresholdSource) : 0;
                                                MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_app_meas_th_src, thresholdSource != null ? thresholdSource.value1 : 0);
                                                updateRegistration(2, mappingObject3);
                                                if (mappingObject3 != null) {
                                                    str21 = mappingObject3.getStr();
                                                    boolean histoEnable = ((j & 17179877378L) != 0 || measureSettingParam == null) ? false : measureSettingParam.getHistoEnable();
                                                    if ((j & 17188257826L) == 0) {
                                                        if (measureSettingParam != null) {
                                                            i15 = i14;
                                                            chan = measureSettingParam.getAllItemSource();
                                                        } else {
                                                            i15 = i14;
                                                            chan = null;
                                                        }
                                                        if ((j & 17188257794L) != 0) {
                                                            str22 = str21;
                                                            i20 = ColorUtil.getColor(getRoot().getContext(), chan);
                                                        } else {
                                                            str22 = str21;
                                                            i20 = 0;
                                                        }
                                                        if (chan != null) {
                                                            i22 = chan.value1;
                                                            i21 = i20;
                                                        } else {
                                                            i21 = i20;
                                                            i22 = 0;
                                                        }
                                                        z24 = z21;
                                                        MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_chan_list, R.array.msg_app_meas_srca, i22);
                                                        updateRegistration(5, mappingObject4);
                                                        if (mappingObject4 != null) {
                                                            str23 = mappingObject4.getStr();
                                                            i16 = i21;
                                                            if ((j & 17246978050L) != 0) {
                                                                if (measureSettingParam != null) {
                                                                    i19 = measureSettingParam.getBaseMethod();
                                                                    str24 = str23;
                                                                } else {
                                                                    str24 = str23;
                                                                    i19 = 0;
                                                                }
                                                                if (i19 == 1) {
                                                                    z25 = true;
                                                                    if ((j & 17716740098L) == 0) {
                                                                        if (measureSettingParam != null) {
                                                                            i18 = i16;
                                                                            z26 = z25;
                                                                            j8 = measureSettingParam.getCursorB();
                                                                        } else {
                                                                            z26 = z25;
                                                                            i18 = i16;
                                                                            j8 = 0;
                                                                        }
                                                                        i17 = i18;
                                                                        str25 = str20;
                                                                        str26 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j8, ServiceEnum.Unit.Unit_s);
                                                                    } else {
                                                                        z26 = z25;
                                                                        i17 = i16;
                                                                        str25 = str20;
                                                                        str26 = null;
                                                                    }
                                                                    if ((17179871234L & j) != 0) {
                                                                        if ((measureSettingParam != null ? measureSettingParam.getMode() : 0) == 1) {
                                                                            z27 = true;
                                                                            if ((j & 17187210243L) != 0) {
                                                                                boolean z30 = (measureSettingParam != null ? measureSettingParam.readThresholdType() : null) == ServiceEnum.ThreType.TH_TYPE_PER;
                                                                                if ((j & 17180918787L) != 0) {
                                                                                    j |= z30 ? 68719476736L : 34359738368L;
                                                                                }
                                                                                if ((j & 17184064515L) != 0) {
                                                                                    j |= z30 ? 281474976710656L : 140737488355328L;
                                                                                }
                                                                                if ((j & 17181967363L) != 0) {
                                                                                    j |= z30 ? 1125899906842624L : 562949953421312L;
                                                                                }
                                                                                z8 = z23;
                                                                                z9 = showThresLine;
                                                                                i2 = i13;
                                                                                str6 = str18;
                                                                                z10 = statisticState;
                                                                                i3 = i15;
                                                                                str5 = str24;
                                                                                str3 = str22;
                                                                                z7 = z24;
                                                                                str2 = str25;
                                                                                i4 = i17;
                                                                                z6 = histoEnable;
                                                                                z4 = z22;
                                                                                z5 = z27;
                                                                                i = i23;
                                                                                str4 = str19;
                                                                                z2 = z30;
                                                                                str = str26;
                                                                                z = z26;
                                                                            } else {
                                                                                str = str26;
                                                                                z8 = z23;
                                                                                z9 = showThresLine;
                                                                                i2 = i13;
                                                                                str6 = str18;
                                                                                z10 = statisticState;
                                                                                i3 = i15;
                                                                                str5 = str24;
                                                                                str3 = str22;
                                                                                z7 = z24;
                                                                                z = z26;
                                                                                str2 = str25;
                                                                                i4 = i17;
                                                                                z6 = histoEnable;
                                                                                z4 = z22;
                                                                                z5 = z27;
                                                                                i = i23;
                                                                                str4 = str19;
                                                                                z2 = false;
                                                                            }
                                                                        }
                                                                    }
                                                                    z27 = false;
                                                                    if ((j & 17187210243L) != 0) {
                                                                    }
                                                                }
                                                            } else {
                                                                str24 = str23;
                                                            }
                                                            z25 = false;
                                                            if ((j & 17716740098L) == 0) {
                                                            }
                                                            if ((17179871234L & j) != 0) {
                                                            }
                                                            z27 = false;
                                                            if ((j & 17187210243L) != 0) {
                                                            }
                                                        } else {
                                                            i16 = i21;
                                                        }
                                                    } else {
                                                        i15 = i14;
                                                        str22 = str21;
                                                        z24 = z21;
                                                        i16 = 0;
                                                    }
                                                    str23 = null;
                                                    if ((j & 17246978050L) != 0) {
                                                    }
                                                    z25 = false;
                                                    if ((j & 17716740098L) == 0) {
                                                    }
                                                    if ((17179871234L & j) != 0) {
                                                    }
                                                    z27 = false;
                                                    if ((j & 17187210243L) != 0) {
                                                    }
                                                }
                                            } else {
                                                i14 = 0;
                                            }
                                            str21 = null;
                                            if ((j & 17179877378L) != 0) {
                                            }
                                            if ((j & 17188257826L) == 0) {
                                            }
                                            str23 = null;
                                            if ((j & 17246978050L) != 0) {
                                            }
                                            z25 = false;
                                            if ((j & 17716740098L) == 0) {
                                            }
                                            if ((17179871234L & j) != 0) {
                                            }
                                            z27 = false;
                                            if ((j & 17187210243L) != 0) {
                                            }
                                        }
                                    }
                                    z3 = false;
                                    if ((j & 17180393478L) != 0) {
                                    }
                                    str21 = null;
                                    if ((j & 17179877378L) != 0) {
                                    }
                                    if ((j & 17188257826L) == 0) {
                                    }
                                    str23 = null;
                                    if ((j & 17246978050L) != 0) {
                                    }
                                    z25 = false;
                                    if ((j & 17716740098L) == 0) {
                                    }
                                    if ((17179871234L & j) != 0) {
                                    }
                                    z27 = false;
                                    if ((j & 17187210243L) != 0) {
                                    }
                                }
                            }
                            z23 = false;
                            if ((17179869186L & j) != 0) {
                            }
                            z3 = false;
                            if ((j & 17180393478L) != 0) {
                            }
                            str21 = null;
                            if ((j & 17179877378L) != 0) {
                            }
                            if ((j & 17188257826L) == 0) {
                            }
                            str23 = null;
                            if ((j & 17246978050L) != 0) {
                            }
                            z25 = false;
                            if ((j & 17716740098L) == 0) {
                            }
                            if ((17179871234L & j) != 0) {
                            }
                            z27 = false;
                            if ((j & 17187210243L) != 0) {
                            }
                        }
                    } else {
                        i23 = 0;
                    }
                    str19 = null;
                    if ((j & 17448304642L) != 0) {
                    }
                    if ((17180000258L & j) != 0) {
                    }
                    z23 = false;
                    if ((17179869186L & j) != 0) {
                    }
                    z3 = false;
                    if ((j & 17180393478L) != 0) {
                    }
                    str21 = null;
                    if ((j & 17179877378L) != 0) {
                    }
                    if ((j & 17188257826L) == 0) {
                    }
                    str23 = null;
                    if ((j & 17246978050L) != 0) {
                    }
                    z25 = false;
                    if ((j & 17716740098L) == 0) {
                    }
                    if ((17179871234L & j) != 0) {
                    }
                    z27 = false;
                    if ((j & 17187210243L) != 0) {
                    }
                }
            }
            z21 = false;
            if ((j & 17180131330L) != 0) {
            }
            i12 = ((j & 17196646402L) > 0L ? 1 : ((j & 17196646402L) == 0L ? 0 : -1));
            int i232 = 8;
            if (i12 == 0) {
            }
            if ((j & 17179934722L) == 0) {
            }
            if ((j & 17179901954L) != 0) {
            }
            if ((j & 25904021634L) == 0) {
            }
            str19 = null;
            if ((j & 17448304642L) != 0) {
            }
            if ((17180000258L & j) != 0) {
            }
            z23 = false;
            if ((17179869186L & j) != 0) {
            }
            z3 = false;
            if ((j & 17180393478L) != 0) {
            }
            str21 = null;
            if ((j & 17179877378L) != 0) {
            }
            if ((j & 17188257826L) == 0) {
            }
            str23 = null;
            if ((j & 17246978050L) != 0) {
            }
            z25 = false;
            if ((j & 17716740098L) == 0) {
            }
            if ((17179871234L & j) != 0) {
            }
            z27 = false;
            if ((j & 17187210243L) != 0) {
            }
        } else {
            z = false;
            i = 0;
            z2 = false;
            i2 = 0;
            z3 = false;
            z4 = false;
            i3 = 0;
            z5 = false;
            i4 = 0;
            z6 = false;
            z7 = false;
            z8 = false;
            z9 = false;
            z10 = false;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
        }
        float f4 = 0.0f;
        if ((j & 18253631498L) != 0) {
            if (horizontalParam != null) {
                acquireMode = horizontalParam.getAcquireMode();
                str7 = str;
            } else {
                str7 = str;
                acquireMode = null;
            }
            z11 = acquireMode != ServiceEnum.AcquireMode.Acquire_Ultra;
            if ((j & 18253627402L) != 0) {
                j = z11 ? j | 274877906944L : j | 137438953472L;
            }
            if ((j & 18253615114L) != 0) {
                j = z11 ? j | 1099511627776L : j | 549755813888L;
            }
            if ((j & 18253611016L) != 0) {
                j |= z11 ? 70368744177664L : 35184372088832L;
            }
            if ((j & 18253611016L) != 0) {
                f = z11 ? 1.0f : 0.5f;
                String str27 = ((j & 19327352848L) != 0 || mappingObject == null) ? null : mappingObject.getStr();
                if ((j & 21474836544L) == 0) {
                    z12 = sharedParam != null ? sharedParam.getShowResultBar() : false;
                    f4 = ContextUtil.getAlpha(z12);
                } else {
                    z12 = false;
                }
                float f5 = f4;
                String str28 = str27;
                i5 = ((j & 703721801515008L) > 0L ? 1 : ((j & 703721801515008L) == 0L ? 0 : -1));
                if (i5 == 0) {
                    unit = verticalParam != null ? verticalParam.getUnit() : null;
                    z13 = unit == null;
                    if (i5 != 0) {
                        j |= z13 ? 4503599627370496L : 2251799813685248L;
                    }
                } else {
                    z13 = false;
                    unit = null;
                }
                if ((j & 2112539794079744L) == 0) {
                    boolean cursorIndicator = ((j & 274877906944L) == 0 || measureSettingParam == null) ? false : measureSettingParam.getCursorIndicator();
                    unit2 = unit;
                    if ((j & 103079215104L) != 0) {
                        j5 = measureSettingParam != null ? measureSettingParam.getThresholdHigh() : 0L;
                        if ((j & 68719476736L) != 0) {
                            f2 = f;
                            str17 = String.valueOf(j5) + '%';
                        } else {
                            f2 = f;
                            str17 = null;
                        }
                    } else {
                        f2 = f;
                        str17 = null;
                        j5 = 0;
                    }
                    boolean cursorThreshold = ((j & 1099511627776L) == 0 || measureSettingParam == null) ? false : measureSettingParam.getCursorThreshold();
                    if ((j & 422212465065984L) != 0) {
                        j6 = measureSettingParam != null ? measureSettingParam.getThresholdLow() : 0L;
                        if ((j & 281474976710656L) != 0) {
                            str11 = str17;
                            z20 = cursorThreshold;
                            str9 = String.valueOf(j6) + '%';
                        } else {
                            str11 = str17;
                            z20 = cursorThreshold;
                            str9 = null;
                        }
                    } else {
                        str11 = str17;
                        z20 = cursorThreshold;
                        str9 = null;
                        j6 = 0;
                    }
                    if ((j & 1688849860263936L) != 0) {
                        long thresholdMiddle = measureSettingParam != null ? measureSettingParam.getThresholdMiddle() : 0L;
                        if ((j & 1125899906842624L) != 0) {
                            String str29 = str9;
                            j7 = thresholdMiddle;
                            f3 = f5;
                            j2 = j6;
                            z15 = z20;
                            str10 = String.valueOf(thresholdMiddle) + '%';
                            z16 = cursorIndicator;
                            str9 = str29;
                        } else {
                            j7 = thresholdMiddle;
                            f3 = f5;
                            j2 = j6;
                            z15 = z20;
                            str10 = null;
                            z16 = cursorIndicator;
                        }
                        z14 = z12;
                        j3 = j7;
                    } else {
                        f3 = f5;
                        j2 = j6;
                        z15 = z20;
                        str10 = null;
                        z16 = cursorIndicator;
                        z14 = z12;
                        j3 = 0;
                    }
                    long j9 = j5;
                    i6 = i;
                    str8 = str2;
                    j4 = j9;
                } else {
                    unit2 = unit;
                    f2 = f;
                    f3 = f5;
                    z14 = z12;
                    i6 = i;
                    str8 = str2;
                    z15 = false;
                    z16 = false;
                    str9 = null;
                    j2 = 0;
                    j3 = 0;
                    j4 = 0;
                    str10 = null;
                    str11 = null;
                }
                i7 = ((j & 18253627402L) > 0L ? 1 : ((j & 18253627402L) == 0L ? 0 : -1));
                if (i7 == 0) {
                    if (!z11) {
                        z16 = false;
                    }
                    str12 = str9;
                    z17 = z16;
                } else {
                    str12 = str9;
                    z17 = false;
                }
                i8 = ((j & 18253615114L) > 0L ? 1 : ((j & 18253615114L) == 0L ? 0 : -1));
                if (i8 != 0 && z11) {
                    z28 = z15;
                }
                boolean z31 = z28;
                if ((j & 703721801515008L) == 0) {
                    if (z13) {
                        z18 = z17;
                        unit3 = ServiceEnum.Unit.Unit_V;
                    } else {
                        z18 = z17;
                        unit3 = unit2;
                    }
                    if ((j & 140737488355328L) != 0) {
                        z19 = z11;
                        str14 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j2, unit3);
                    } else {
                        z19 = z11;
                        str14 = null;
                    }
                    str15 = (562949953421312L & j) != 0 ? UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j3, unit3) : null;
                    str13 = (34359738368L & j) != 0 ? UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j4, unit3) : null;
                } else {
                    z18 = z17;
                    z19 = z11;
                    str13 = null;
                    str14 = null;
                    str15 = null;
                }
                i9 = ((17180918787L & j) > 0L ? 1 : ((17180918787L & j) == 0L ? 0 : -1));
                if (i9 == 0) {
                    if (!z2) {
                        str11 = str13;
                    }
                    str16 = str11;
                } else {
                    str16 = null;
                }
                i10 = ((17184064515L & j) > 0L ? 1 : ((17184064515L & j) == 0L ? 0 : -1));
                if (i10 != 0) {
                    str14 = null;
                } else if (z2) {
                    str14 = str12;
                }
                i11 = ((17181967363L & j) > 0L ? 1 : ((17181967363L & j) == 0L ? 0 : -1));
                String str30 = i11 == 0 ? z2 ? str10 : str15 : null;
                if ((j & 17196646402L) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.ampMethodSwitch, z4);
                    this.baseMethod.setVisibility(i2);
                    this.baseMethodSwitch.setVisibility(i2);
                    this.topMethod.setVisibility(i2);
                    this.topMethodSwitch.setVisibility(i2);
                }
                if ((17246978050L & j) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.baseMethodSwitch, z);
                }
                if ((17314086914L & j) != 0) {
                    int i25 = i6;
                    this.cursorA.setVisibility(i25);
                    this.cursorAEditText.setVisibility(i25);
                    this.cursorAb.setVisibility(i25);
                    this.cursorAbSwitch.setVisibility(i25);
                    this.cursorB.setVisibility(i25);
                    this.cursorBEditText.setVisibility(i25);
                }
                if ((17179869184L & j) != 0) {
                    this.cursorAEditText.setOnClickListener(this.mCallback49);
                    this.cursorBEditText.setOnClickListener(this.mCallback50);
                    this.highEditText.setOnClickListener(this.mCallback45);
                    this.lowEditText.setOnClickListener(this.mCallback47);
                    this.measureSourceSpinner.setOnClickListener(this.mCallback48);
                    this.midEditText.setOnClickListener(this.mCallback46);
                    this.statCountEditText.setOnClickListener(this.mCallback41);
                    this.statResetButton.setOnClickListener(this.mCallback42);
                    this.thresholdDefaultButton.setOnClickListener(this.mCallback43);
                    this.thresholdSourceSpinner.setOnClickListener(this.mCallback44);
                }
                if ((17448304642L & j) != 0) {
                    TextViewBindingAdapter.setText(this.cursorAEditText, str8);
                }
                if ((17179869186L & j) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.cursorAbSwitch, z3);
                }
                if ((17716740098L & j) != 0) {
                    TextViewBindingAdapter.setText(this.cursorBEditText, str7);
                }
                if ((j & 21474836544L) != 0) {
                    if (getBuildSdkInt() >= 11) {
                        float f6 = f3;
                        this.deleteAllButton.setAlpha(f6);
                        this.deleteButton.setAlpha(f6);
                    }
                    boolean z32 = z14;
                    this.deleteAllButton.setEnabled(z32);
                    this.deleteButton.setEnabled(z32);
                }
                if (i9 != 0) {
                    TextViewBindingAdapter.setText(this.highEditText, str16);
                }
                if ((17179877378L & j) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.histoEnSwitch, z6);
                }
                if ((j & 18253611016L) != 0) {
                    if (getBuildSdkInt() >= 11) {
                        float f7 = f2;
                        this.indicator.setAlpha(f7);
                        this.indicatorSwitch.setAlpha(f7);
                        this.threSwitch.setAlpha(f7);
                        this.threText.setAlpha(f7);
                    }
                    boolean z33 = z19;
                    this.indicatorSwitch.setEnabled(z33);
                    this.precisionRadioButton.setEnabled(z33);
                    this.threSwitch.setEnabled(z33);
                }
                if (i7 != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.indicatorSwitch, z18);
                }
                if (i10 != 0) {
                    TextViewBindingAdapter.setText(this.lowEditText, str14);
                }
                if ((17188257826L & j) != 0) {
                    TextViewBindingAdapter.setText(this.measureSourceSpinner, str5);
                }
                if ((17188257794L & j) != 0) {
                    this.measureSourceSpinner.setTextColor(i4);
                }
                if (i11 != 0) {
                    TextViewBindingAdapter.setText(this.midEditText, str30);
                }
                if ((17179871234L & j) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.precisionRadioButton, z5);
                }
                if ((j & 19327352848L) != 0) {
                    TextViewBindingAdapter.setText(this.precisionRadioButton, str28);
                }
                if ((25904021634L & j) != 0) {
                    TextViewBindingAdapter.setText(this.regionSpinner, str4);
                }
                if ((j & 17180131330L) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.showLine, z9);
                }
                if ((j & 17179934722L) != 0) {
                    TextViewBindingAdapter.setText(this.statCountEditText, str6);
                }
                if ((17179901954L & j) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.statSwitch, z10);
                }
                if (i8 != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.threSwitch, z31);
                }
                if ((17180000258L & j) != 0) {
                    CompoundButtonBindingAdapter.setChecked(this.thresholdDisplayTypeSwitch, z8);
                }
                if ((17180393478L & j) != 0) {
                    TextViewBindingAdapter.setText(this.thresholdSourceSpinner, str3);
                }
                if ((17180393474L & j) != 0) {
                    this.thresholdSourceSpinner.setTextColor(i3);
                }
                if ((j & 17213423618L) == 0) {
                    CompoundButtonBindingAdapter.setChecked(this.topMethodSwitch, z7);
                    return;
                }
                return;
            }
        } else {
            str7 = str;
            z11 = false;
        }
        f = 0.0f;
        if ((j & 19327352848L) != 0) {
        }
        if ((j & 21474836544L) == 0) {
        }
        float f52 = f4;
        String str282 = str27;
        i5 = ((j & 703721801515008L) > 0L ? 1 : ((j & 703721801515008L) == 0L ? 0 : -1));
        if (i5 == 0) {
        }
        if ((j & 2112539794079744L) == 0) {
        }
        i7 = ((j & 18253627402L) > 0L ? 1 : ((j & 18253627402L) == 0L ? 0 : -1));
        if (i7 == 0) {
        }
        i8 = ((j & 18253615114L) > 0L ? 1 : ((j & 18253615114L) == 0L ? 0 : -1));
        if (i8 != 0) {
            z28 = z15;
        }
        boolean z312 = z28;
        if ((j & 703721801515008L) == 0) {
        }
        i9 = ((17180918787L & j) > 0L ? 1 : ((17180918787L & j) == 0L ? 0 : -1));
        if (i9 == 0) {
        }
        i10 = ((17184064515L & j) > 0L ? 1 : ((17184064515L & j) == 0L ? 0 : -1));
        if (i10 != 0) {
        }
        i11 = ((17181967363L & j) > 0L ? 1 : ((17181967363L & j) == 0L ? 0 : -1));
        if (i11 == 0) {
        }
        if ((j & 17196646402L) != 0) {
        }
        if ((17246978050L & j) != 0) {
        }
        if ((17314086914L & j) != 0) {
        }
        if ((17179869184L & j) != 0) {
        }
        if ((17448304642L & j) != 0) {
        }
        if ((17179869186L & j) != 0) {
        }
        if ((17716740098L & j) != 0) {
        }
        if ((j & 21474836544L) != 0) {
        }
        if (i9 != 0) {
        }
        if ((17179877378L & j) != 0) {
        }
        if ((j & 18253611016L) != 0) {
        }
        if (i7 != 0) {
        }
        if (i10 != 0) {
        }
        if ((17188257826L & j) != 0) {
        }
        if ((17188257794L & j) != 0) {
        }
        if (i11 != 0) {
        }
        if ((17179871234L & j) != 0) {
        }
        if ((j & 19327352848L) != 0) {
        }
        if ((25904021634L & j) != 0) {
        }
        if ((j & 17180131330L) != 0) {
        }
        if ((j & 17179934722L) != 0) {
        }
        if ((17179901954L & j) != 0) {
        }
        if (i8 != 0) {
        }
        if ((17180000258L & j) != 0) {
        }
        if ((17180393478L & j) != 0) {
        }
        if ((17180393474L & j) != 0) {
        }
        if ((j & 17213423618L) == 0) {
        }
    }

    @Override // com.rigol.scope.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        switch (i) {
            case 1:
                View.OnClickListener onClickListener = this.mOnClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                    return;
                }
                return;
            case 2:
                View.OnClickListener onClickListener2 = this.mOnClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                    return;
                }
                return;
            case 3:
                View.OnClickListener onClickListener3 = this.mOnClickListener;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                    return;
                }
                return;
            case 4:
                View.OnClickListener onClickListener4 = this.mOnClickListener;
                if (onClickListener4 != null) {
                    onClickListener4.onClick(view);
                    return;
                }
                return;
            case 5:
                View.OnClickListener onClickListener5 = this.mOnClickListener;
                if (onClickListener5 != null) {
                    onClickListener5.onClick(view);
                    return;
                }
                return;
            case 6:
                View.OnClickListener onClickListener6 = this.mOnClickListener;
                if (onClickListener6 != null) {
                    onClickListener6.onClick(view);
                    return;
                }
                return;
            case 7:
                View.OnClickListener onClickListener7 = this.mOnClickListener;
                if (onClickListener7 != null) {
                    onClickListener7.onClick(view);
                    return;
                }
                return;
            case 8:
                View.OnClickListener onClickListener8 = this.mOnClickListener;
                if (onClickListener8 != null) {
                    onClickListener8.onClick(view);
                    return;
                }
                return;
            case 9:
                View.OnClickListener onClickListener9 = this.mOnClickListener;
                if (onClickListener9 != null) {
                    onClickListener9.onClick(view);
                    return;
                }
                return;
            case 10:
                View.OnClickListener onClickListener10 = this.mOnClickListener;
                if (onClickListener10 != null) {
                    onClickListener10.onClick(view);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
