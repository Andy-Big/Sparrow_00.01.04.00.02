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
import com.rigol.scope.R;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.generated.callback.OnClickListener;
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
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 2184
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewResultMeasureBindingImpl.executeBindings():void");
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
