package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.generated.callback.OnClickListener;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class PopupviewHorizontalBindingImpl extends PopupviewHorizontalBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback100;
    private final View.OnClickListener mCallback101;
    private final View.OnClickListener mCallback102;
    private final View.OnClickListener mCallback103;
    private final View.OnClickListener mCallback104;
    private final View.OnClickListener mCallback105;
    private final View.OnClickListener mCallback106;
    private final View.OnClickListener mCallback107;
    private final View.OnClickListener mCallback88;
    private final View.OnClickListener mCallback89;
    private final View.OnClickListener mCallback90;
    private final View.OnClickListener mCallback91;
    private final View.OnClickListener mCallback92;
    private final View.OnClickListener mCallback93;
    private final View.OnClickListener mCallback94;
    private final View.OnClickListener mCallback95;
    private final View.OnClickListener mCallback96;
    private final View.OnClickListener mCallback97;
    private final View.OnClickListener mCallback98;
    private final View.OnClickListener mCallback99;
    private long mDirtyFlags;
    private long mDirtyFlags_1;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView22;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 50);
        sViewsWithIds.put(R.id.guideline_left, 51);
        sViewsWithIds.put(R.id.guideline_right, 52);
        sViewsWithIds.put(R.id.mode, 53);
        sViewsWithIds.put(R.id.mode_radio_group, 54);
        sViewsWithIds.put(R.id.anti_aliasing, 55);
        sViewsWithIds.put(R.id.sarate, 56);
        sViewsWithIds.put(R.id.dividing_line, 57);
        sViewsWithIds.put(R.id.roll, 58);
        sViewsWithIds.put(R.id.roll_radio_group, 59);
        sViewsWithIds.put(R.id.timescale, 60);
        sViewsWithIds.put(R.id.timescale_text, 61);
        sViewsWithIds.put(R.id.fine_on, 62);
        sViewsWithIds.put(R.id.main_scale, 63);
        sViewsWithIds.put(R.id.vertical_setting, 64);
    }

    public PopupviewHorizontalBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 65, sIncludes, sViewsWithIds));
    }

    private PopupviewHorizontalBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 13, (TextView) objArr[55], (RadioButton) objArr[23], (RadioButton) objArr[2], (TextView) objArr[7], (EditText) objArr[8], (SwitchButton) objArr[42], (TextView) objArr[41], (TextView) objArr[18], (TextView) objArr[17], (View) objArr[57], (TextView) objArr[26], (TextView) objArr[27], (TextView) objArr[29], (EditText) objArr[30], (TextView) objArr[62], (SwitchButton) objArr[28], (Guideline) objArr[50], (Guideline) objArr[51], (Guideline) objArr[52], (TextView) objArr[9], (TextView) objArr[10], (TextView) objArr[12], (TextView) objArr[11], (SwitchButton) objArr[6], (RadioButton) objArr[4], (TextView) objArr[34], (EditText) objArr[35], (ImageButton) objArr[36], (ImageButton) objArr[37], (TextView) objArr[63], (EditText) objArr[31], (ImageButton) objArr[32], (ImageButton) objArr[33], (EditText) objArr[14], (TextView) objArr[13], (TextView) objArr[19], (TextView) objArr[20], (TextView) objArr[53], (RadioGroup) objArr[54], (RadioButton) objArr[1], (RadioButton) objArr[24], (RadioButton) objArr[3], (TextView) objArr[58], (RadioGroup) objArr[59], (TextView) objArr[56], (TextView) objArr[21], (EditText) objArr[16], (TextView) objArr[15], (TextView) objArr[60], (TextView) objArr[61], (RadioButton) objArr[5], (Button) objArr[64], (CheckBox) objArr[25], (TextView) objArr[46], (EditText) objArr[47], (ImageButton) objArr[48], (ImageButton) objArr[49], (TextView) objArr[38], (SwitchButton) objArr[39], (TextView) objArr[40], (EditText) objArr[43], (ImageButton) objArr[44], (ImageButton) objArr[45]);
        this.mDirtyFlags = -1L;
        this.mDirtyFlags_1 = -1L;
        this.autoRadioButton.setTag(null);
        this.averageRadioButton.setTag(null);
        this.avgTimes.setTag(null);
        this.avgTimesEditText.setTag(null);
        this.delaySample.setTag(null);
        this.delaySampleText.setTag(null);
        this.displaySpinner.setTag(null);
        this.displayText.setTag(null);
        this.expand.setTag(null);
        this.expandSpinner.setTag(null);
        this.expandUser.setTag(null);
        this.expandUserEditText.setTag(null);
        this.fineOnSwitch.setTag(null);
        this.highBit.setTag(null);
        this.highBitSpinner.setTag(null);
        this.highBw.setTag(null);
        this.highInfo.setTag(null);
        this.histogramEn.setTag(null);
        this.hresRadioButton.setTag(null);
        this.mainOffset.setTag(null);
        this.mainOffsetEditText.setTag(null);
        this.mainOffsetLeft.setTag(null);
        this.mainOffsetRight.setTag(null);
        this.mainScaleEditText.setTag(null);
        this.mainScaleLeft.setTag(null);
        this.mainScaleRight.setTag(null);
        this.maxFrameEdit.setTag(null);
        this.maxFrameText.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[22];
        this.mboundView22 = textView;
        textView.setTag(null);
        this.memdepth.setTag(null);
        this.memdepthSpinner.setTag(null);
        this.normalRadioButton.setTag(null);
        this.offRadioButton.setTag(null);
        this.peakRadioButton.setTag(null);
        this.sarateText.setTag(null);
        this.timeOutEdit.setTag(null);
        this.timeOutText.setTag(null);
        this.ultraRadioButton.setTag(null);
        this.xyCheck.setTag(null);
        this.zoomOffset.setTag(null);
        this.zoomOffsetEditText.setTag(null);
        this.zoomOffsetLeft.setTag(null);
        this.zoomOffsetRight.setTag(null);
        this.zoomOn.setTag(null);
        this.zoomOnSwitch.setTag(null);
        this.zoomScale.setTag(null);
        this.zoomScaleEditText.setTag(null);
        this.zoomScaleLeft.setTag(null);
        this.zoomScaleRight.setTag(null);
        setRootTag(view);
        this.mCallback94 = new OnClickListener(this, 7);
        this.mCallback95 = new OnClickListener(this, 8);
        this.mCallback106 = new OnClickListener(this, 19);
        this.mCallback92 = new OnClickListener(this, 5);
        this.mCallback107 = new OnClickListener(this, 20);
        this.mCallback93 = new OnClickListener(this, 6);
        this.mCallback90 = new OnClickListener(this, 3);
        this.mCallback91 = new OnClickListener(this, 4);
        this.mCallback100 = new OnClickListener(this, 13);
        this.mCallback101 = new OnClickListener(this, 14);
        this.mCallback89 = new OnClickListener(this, 2);
        this.mCallback104 = new OnClickListener(this, 17);
        this.mCallback99 = new OnClickListener(this, 12);
        this.mCallback105 = new OnClickListener(this, 18);
        this.mCallback88 = new OnClickListener(this, 1);
        this.mCallback102 = new OnClickListener(this, 15);
        this.mCallback96 = new OnClickListener(this, 9);
        this.mCallback103 = new OnClickListener(this, 16);
        this.mCallback98 = new OnClickListener(this, 11);
        this.mCallback97 = new OnClickListener(this, 10);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 576460752303423488L;
            this.mDirtyFlags_1 = 0L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags == 0 && this.mDirtyFlags_1 == 0) {
                return false;
            }
            return true;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (986 == i) {
            setUltraMappingObj((MappingObject) obj);
        } else if (561 == i) {
            setNormalMappingObj((MappingObject) obj);
        } else if (385 == i) {
            setHresMappingObj((MappingObject) obj);
        } else if (353 == i) {
            setFunctionManager((FunctionManager) obj);
        } else if (177 == i) {
            setCheckedChangeListener((CompoundButton.OnCheckedChangeListener) obj);
        } else if (179 == i) {
            setClickListener((View.OnClickListener) obj);
        } else if (564 == i) {
            setOffMappingObj((MappingObject) obj);
        } else if (594 == i) {
            setParam((HorizontalParam) obj);
        } else if (100 == i) {
            setBodeParam((BodeParam) obj);
        } else if (64 == i) {
            setAverageMappingObj((MappingObject) obj);
        } else if (611 == i) {
            setPeakMappingObj((MappingObject) obj);
        } else if (59 != i) {
            return false;
        } else {
            setAutoMappingObj((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewHorizontalBinding
    public void setUltraMappingObj(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mUltraMappingObj = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(986);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewHorizontalBinding
    public void setNormalMappingObj(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mNormalMappingObj = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(561);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewHorizontalBinding
    public void setHresMappingObj(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mHresMappingObj = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(385);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewHorizontalBinding
    public void setFunctionManager(FunctionManager functionManager) {
        this.mFunctionManager = functionManager;
    }

    @Override // com.rigol.scope.databinding.PopupviewHorizontalBinding
    public void setCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mCheckedChangeListener = onCheckedChangeListener;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
        }
        notifyPropertyChanged(177);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewHorizontalBinding
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(179);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewHorizontalBinding
    public void setOffMappingObj(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mOffMappingObj = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(564);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewHorizontalBinding
    public void setParam(HorizontalParam horizontalParam) {
        updateRegistration(6, horizontalParam);
        this.mParam = horizontalParam;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewHorizontalBinding
    public void setBodeParam(BodeParam bodeParam) {
        updateRegistration(7, bodeParam);
        this.mBodeParam = bodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(100);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewHorizontalBinding
    public void setAverageMappingObj(MappingObject mappingObject) {
        updateRegistration(9, mappingObject);
        this.mAverageMappingObj = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(64);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewHorizontalBinding
    public void setPeakMappingObj(MappingObject mappingObject) {
        updateRegistration(11, mappingObject);
        this.mPeakMappingObj = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(611);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewHorizontalBinding
    public void setAutoMappingObj(MappingObject mappingObject) {
        updateRegistration(12, mappingObject);
        this.mAutoMappingObj = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(59);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeUltraMappingObj((MappingObject) obj, i2);
            case 1:
                return onChangeNormalMappingObj((MappingObject) obj, i2);
            case 2:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAcqHighresBitParamHighBitValue1((MappingObject) obj, i2);
            case 3:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgHorExpandParamExpandModeValue1((MappingObject) obj, i2);
            case 4:
                return onChangeHresMappingObj((MappingObject) obj, i2);
            case 5:
                return onChangeOffMappingObj((MappingObject) obj, i2);
            case 6:
                return onChangeParam((HorizontalParam) obj, i2);
            case 7:
                return onChangeBodeParam((BodeParam) obj, i2);
            case 8:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAcqUltraDisplaymodeParamDisplayMode((MappingObject) obj, i2);
            case 9:
                return onChangeAverageMappingObj((MappingObject) obj, i2);
            case 10:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAcqMemdepthParamDepthValue1((MappingObject) obj, i2);
            case 11:
                return onChangePeakMappingObj((MappingObject) obj, i2);
            case 12:
                return onChangeAutoMappingObj((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeUltraMappingObj(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 638) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeNormalMappingObj(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 638) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAcqHighresBitParamHighBitValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgHorExpandParamExpandModeValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
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

    private boolean onChangeHresMappingObj(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 638) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
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

    private boolean onChangeOffMappingObj(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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

    private boolean onChangeParam(HorizontalParam horizontalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 28) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else if (i == 935) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else if (i == 1088) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else if (i == 985) {
            synchronized (this) {
                this.mDirtyFlags |= 268435456;
            }
            return true;
        } else if (i == 49) {
            synchronized (this) {
                this.mDirtyFlags |= 536870912;
            }
            return true;
        } else if (i == 65) {
            synchronized (this) {
                this.mDirtyFlags |= 1073741824;
            }
            return true;
        } else if (i == 371) {
            synchronized (this) {
                this.mDirtyFlags |= 2147483648L;
            }
            return true;
        } else if (i == 372) {
            synchronized (this) {
                this.mDirtyFlags |= 4294967296L;
            }
            return true;
        } else if (i == 523) {
            synchronized (this) {
                this.mDirtyFlags |= 8589934592L;
            }
            return true;
        } else if (i == 936) {
            synchronized (this) {
                this.mDirtyFlags |= 17179869184L;
            }
            return true;
        } else if (i == 238) {
            synchronized (this) {
                this.mDirtyFlags |= 34359738368L;
            }
            return true;
        } else if (i == 244) {
            synchronized (this) {
                this.mDirtyFlags |= 68719476736L;
            }
            return true;
        } else if (i == 237) {
            synchronized (this) {
                this.mDirtyFlags |= 137438953472L;
            }
            return true;
        } else if (i == 770) {
            synchronized (this) {
                this.mDirtyFlags |= 274877906944L;
            }
            return true;
        } else if (i == 772) {
            synchronized (this) {
                this.mDirtyFlags |= 549755813888L;
            }
            return true;
        } else if (i == 742) {
            synchronized (this) {
                this.mDirtyFlags |= 1099511627776L;
            }
            return true;
        } else if (i == 1082) {
            synchronized (this) {
                this.mDirtyFlags |= 2199023255552L;
            }
            return true;
        } else if (i == 1081) {
            synchronized (this) {
                this.mDirtyFlags |= 4398046511104L;
            }
            return true;
        } else if (i == 289) {
            synchronized (this) {
                this.mDirtyFlags |= 8796093022208L;
            }
            return true;
        } else if (i == 314) {
            synchronized (this) {
                this.mDirtyFlags |= 17592186044416L;
            }
            return true;
        } else if (i == 290) {
            synchronized (this) {
                this.mDirtyFlags |= 35184372088832L;
            }
            return true;
        } else if (i == 516) {
            synchronized (this) {
                this.mDirtyFlags |= 70368744177664L;
            }
            return true;
        } else if (i == 760) {
            synchronized (this) {
                this.mDirtyFlags |= 140737488355328L;
            }
            return true;
        } else if (i == 515) {
            synchronized (this) {
                this.mDirtyFlags |= 281474976710656L;
            }
            return true;
        } else if (i == 1092) {
            synchronized (this) {
                this.mDirtyFlags |= 562949953421312L;
            }
            return true;
        } else if (i == 1091) {
            synchronized (this) {
                this.mDirtyFlags |= 1125899906842624L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeBodeParam(BodeParam bodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 96) {
            synchronized (this) {
                this.mDirtyFlags |= 2251799813685248L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAcqUltraDisplaymodeParamDisplayMode(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 4503599627370496L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeAverageMappingObj(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 638) {
            synchronized (this) {
                this.mDirtyFlags |= 9007199254740992L;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 18014398509481984L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAcqMemdepthParamDepthValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 36028797018963968L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangePeakMappingObj(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 638) {
            synchronized (this) {
                this.mDirtyFlags |= 72057594037927936L;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 144115188075855872L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeAutoMappingObj(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 288230376151711744L;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0235 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0249 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x025d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x041b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x04ad A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x06ec  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x08dd  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x08e9  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x08f3  */
    /* JADX WARN: Removed duplicated region for block: B:487:0x0902  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x090f  */
    /* JADX WARN: Removed duplicated region for block: B:497:0x0921  */
    /* JADX WARN: Removed duplicated region for block: B:500:0x092b  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x093c  */
    /* JADX WARN: Removed duplicated region for block: B:516:0x095c  */
    /* JADX WARN: Removed duplicated region for block: B:535:0x0996  */
    /* JADX WARN: Removed duplicated region for block: B:544:0x09b5  */
    /* JADX WARN: Removed duplicated region for block: B:548:0x09c1  */
    /* JADX WARN: Removed duplicated region for block: B:551:0x09cb  */
    /* JADX WARN: Removed duplicated region for block: B:563:0x09f0  */
    /* JADX WARN: Removed duplicated region for block: B:566:0x09fa  */
    /* JADX WARN: Removed duplicated region for block: B:575:0x0a14  */
    /* JADX WARN: Removed duplicated region for block: B:581:0x0a23  */
    /* JADX WARN: Removed duplicated region for block: B:584:0x0a30  */
    /* JADX WARN: Removed duplicated region for block: B:585:0x0a35  */
    /* JADX WARN: Removed duplicated region for block: B:589:0x0a3f  */
    /* JADX WARN: Removed duplicated region for block: B:593:0x0a4f  */
    /* JADX WARN: Removed duplicated region for block: B:596:0x0a59  */
    /* JADX WARN: Removed duplicated region for block: B:600:0x0a69  */
    /* JADX WARN: Removed duplicated region for block: B:603:0x0a78  */
    /* JADX WARN: Removed duplicated region for block: B:609:0x0a8b  */
    /* JADX WARN: Removed duplicated region for block: B:610:0x0a98  */
    /* JADX WARN: Removed duplicated region for block: B:613:0x0aa5  */
    /* JADX WARN: Removed duplicated region for block: B:616:0x0ab5  */
    /* JADX WARN: Removed duplicated region for block: B:619:0x0b06  */
    /* JADX WARN: Removed duplicated region for block: B:625:0x0b32  */
    /* JADX WARN: Removed duplicated region for block: B:628:0x0b9a  */
    /* JADX WARN: Removed duplicated region for block: B:631:0x0bac  */
    /* JADX WARN: Removed duplicated region for block: B:634:0x0bbb  */
    /* JADX WARN: Removed duplicated region for block: B:649:0x0c84  */
    /* JADX WARN: Removed duplicated region for block: B:652:0x0c96  */
    /* JADX WARN: Removed duplicated region for block: B:655:0x0cb8  */
    /* JADX WARN: Removed duplicated region for block: B:660:0x0ce3  */
    /* JADX WARN: Removed duplicated region for block: B:663:0x0cf5  */
    /* JADX WARN: Removed duplicated region for block: B:665:0x0cfe  */
    /* JADX WARN: Removed duplicated region for block: B:670:0x0d16  */
    /* JADX WARN: Removed duplicated region for block: B:673:0x0d2d  */
    /* JADX WARN: Removed duplicated region for block: B:676:0x0d3f  */
    /* JADX WARN: Removed duplicated region for block: B:679:0x0d51  */
    /* JADX WARN: Removed duplicated region for block: B:682:0x0d63  */
    /* JADX WARN: Removed duplicated region for block: B:685:0x0d75  */
    /* JADX WARN: Removed duplicated region for block: B:688:0x0d87  */
    /* JADX WARN: Removed duplicated region for block: B:691:0x0d99  */
    /* JADX WARN: Removed duplicated region for block: B:694:0x0dab  */
    /* JADX WARN: Removed duplicated region for block: B:700:0x0de3  */
    /* JADX WARN: Removed duplicated region for block: B:703:0x0df5  */
    /* JADX WARN: Removed duplicated region for block: B:706:0x0e02  */
    /* JADX WARN: Removed duplicated region for block: B:709:0x0e14  */
    /* JADX WARN: Removed duplicated region for block: B:712:0x0e26  */
    /* JADX WARN: Removed duplicated region for block: B:715:0x0e38  */
    /* JADX WARN: Removed duplicated region for block: B:718:0x0e4a  */
    /* JADX WARN: Removed duplicated region for block: B:721:0x0e5c  */
    /* JADX WARN: Removed duplicated region for block: B:724:0x0e6e  */
    /* JADX WARN: Removed duplicated region for block: B:727:0x0e80  */
    /* JADX WARN: Removed duplicated region for block: B:730:0x0e92  */
    /* JADX WARN: Removed duplicated region for block: B:732:0x0e9b  */
    /* JADX WARN: Removed duplicated region for block: B:738:0x0ebc  */
    /* JADX WARN: Removed duplicated region for block: B:741:0x0ece  */
    /* JADX WARN: Removed duplicated region for block: B:744:0x0ee0  */
    /* JADX WARN: Removed duplicated region for block: B:750:0x0f01  */
    /* JADX WARN: Removed duplicated region for block: B:753:0x0f0e  */
    /* JADX WARN: Removed duplicated region for block: B:756:0x0f4c  */
    /* JADX WARN: Removed duplicated region for block: B:758:0x0f55  */
    /* JADX WARN: Removed duplicated region for block: B:762:0x0f64  */
    /* JADX WARN: Removed duplicated region for block: B:768:0x0f85  */
    /* JADX WARN: Removed duplicated region for block: B:775:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 3984
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewHorizontalBindingImpl.executeBindings():void");
    }

    @Override // com.rigol.scope.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        switch (i) {
            case 1:
                View.OnClickListener onClickListener = this.mClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                    return;
                }
                return;
            case 2:
                View.OnClickListener onClickListener2 = this.mClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                    return;
                }
                return;
            case 3:
                View.OnClickListener onClickListener3 = this.mClickListener;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                    return;
                }
                return;
            case 4:
                View.OnClickListener onClickListener4 = this.mClickListener;
                if (onClickListener4 != null) {
                    onClickListener4.onClick(view);
                    return;
                }
                return;
            case 5:
                View.OnClickListener onClickListener5 = this.mClickListener;
                if (onClickListener5 != null) {
                    onClickListener5.onClick(view);
                    return;
                }
                return;
            case 6:
                View.OnClickListener onClickListener6 = this.mClickListener;
                if (onClickListener6 != null) {
                    onClickListener6.onClick(view);
                    return;
                }
                return;
            case 7:
                View.OnClickListener onClickListener7 = this.mClickListener;
                if (onClickListener7 != null) {
                    onClickListener7.onClick(view);
                    return;
                }
                return;
            case 8:
                View.OnClickListener onClickListener8 = this.mClickListener;
                if (onClickListener8 != null) {
                    onClickListener8.onClick(view);
                    return;
                }
                return;
            case 9:
                View.OnClickListener onClickListener9 = this.mClickListener;
                if (onClickListener9 != null) {
                    onClickListener9.onClick(view);
                    return;
                }
                return;
            case 10:
                View.OnClickListener onClickListener10 = this.mClickListener;
                if (onClickListener10 != null) {
                    onClickListener10.onClick(view);
                    return;
                }
                return;
            case 11:
                View.OnClickListener onClickListener11 = this.mClickListener;
                if (onClickListener11 != null) {
                    onClickListener11.onClick(view);
                    return;
                }
                return;
            case 12:
                View.OnClickListener onClickListener12 = this.mClickListener;
                if (onClickListener12 != null) {
                    onClickListener12.onClick(view);
                    return;
                }
                return;
            case 13:
                View.OnClickListener onClickListener13 = this.mClickListener;
                if (onClickListener13 != null) {
                    onClickListener13.onClick(view);
                    return;
                }
                return;
            case 14:
                View.OnClickListener onClickListener14 = this.mClickListener;
                if (onClickListener14 != null) {
                    onClickListener14.onClick(view);
                    return;
                }
                return;
            case 15:
                View.OnClickListener onClickListener15 = this.mClickListener;
                if (onClickListener15 != null) {
                    onClickListener15.onClick(view);
                    return;
                }
                return;
            case 16:
                View.OnClickListener onClickListener16 = this.mClickListener;
                if (onClickListener16 != null) {
                    onClickListener16.onClick(view);
                    return;
                }
                return;
            case 17:
                View.OnClickListener onClickListener17 = this.mClickListener;
                if (onClickListener17 != null) {
                    onClickListener17.onClick(view);
                    return;
                }
                return;
            case 18:
                View.OnClickListener onClickListener18 = this.mClickListener;
                if (onClickListener18 != null) {
                    onClickListener18.onClick(view);
                    return;
                }
                return;
            case 19:
                View.OnClickListener onClickListener19 = this.mClickListener;
                if (onClickListener19 != null) {
                    onClickListener19.onClick(view);
                    return;
                }
                return;
            case 20:
                View.OnClickListener onClickListener20 = this.mClickListener;
                if (onClickListener20 != null) {
                    onClickListener20.onClick(view);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
