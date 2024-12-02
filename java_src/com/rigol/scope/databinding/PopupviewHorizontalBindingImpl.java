package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
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
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.Roll;
import com.rigol.scope.generated.callback.OnClickListener;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

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
    */
    protected void executeBindings() {
        long j;
        long j2;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        int i;
        Drawable drawable;
        String str;
        Drawable drawable2;
        Drawable drawable3;
        String str2;
        String str3;
        Drawable drawable4;
        String str4;
        Drawable drawable5;
        Drawable drawable6;
        String str5;
        long j3;
        long j4;
        boolean z;
        boolean z2;
        int i2;
        boolean z3;
        int i3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int i6;
        boolean z15;
        boolean z16;
        boolean z17;
        int i7;
        boolean z18;
        int i8;
        int i9;
        boolean z19;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        ServiceEnum.HoriTimeMode horiTimeMode;
        String str14;
        ServiceEnum.HorizontalExpand horizontalExpand;
        String str15;
        String str16;
        String str17;
        String str18;
        float f;
        float f2;
        float f3;
        long j5;
        long j6;
        Drawable drawable7;
        String str19;
        Drawable drawable8;
        String str20;
        Drawable drawable9;
        Drawable drawable10;
        boolean z20;
        boolean z21;
        boolean z22;
        String str21;
        int i10;
        int i11;
        int i12;
        String str22;
        boolean z23;
        long j7;
        boolean ultraEnable;
        boolean z24;
        int i13;
        boolean z25;
        float f4;
        float f5;
        boolean z26;
        float alpha;
        boolean z27;
        int i14;
        boolean z28;
        float f6;
        int i15;
        boolean z29;
        float f7;
        int i16;
        float f8;
        long j8;
        long j9;
        boolean z30;
        boolean z31;
        ServiceEnum.HoriTimeMode horiTimeMode2;
        float f9;
        ServiceEnum.HoriTimeMode horiTimeMode3;
        String str23;
        boolean z32;
        float f10;
        int i17;
        int i18;
        boolean z33;
        int i19;
        String str24;
        boolean z34;
        String str25;
        String str26;
        boolean z35;
        int i20;
        ServiceEnum.HorizontalExpand horizontalExpand2;
        String str27;
        String str28;
        int i21;
        String str29;
        boolean z36;
        boolean z37;
        int i22;
        boolean z38;
        String str30;
        boolean z39;
        boolean z40;
        boolean z41;
        String str31;
        String str32;
        String str33;
        String str34;
        String str35;
        String str36;
        String str37;
        int i23;
        int i24;
        String str38;
        String str39;
        String str40;
        boolean z42;
        float f11;
        String str41;
        String str42;
        boolean z43;
        int i25;
        int i26;
        int i27;
        int i28;
        boolean z44;
        boolean z45;
        boolean z46;
        boolean z47;
        long j10;
        int i29;
        int i30;
        long j11;
        MessageAttr messageAttr;
        long j12;
        long j13;
        long j14;
        long j15;
        ServiceEnum.HighResBit highResBit;
        int i31;
        boolean z48;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
            j2 = this.mDirtyFlags_1;
            this.mDirtyFlags_1 = 0L;
        }
        MappingObject mappingObject = this.mUltraMappingObj;
        MappingObject mappingObject2 = this.mNormalMappingObj;
        MappingObject mappingObject3 = this.mHresMappingObj;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener2 = this.mCheckedChangeListener;
        View.OnClickListener onClickListener = this.mClickListener;
        MappingObject mappingObject4 = this.mOffMappingObj;
        HorizontalParam horizontalParam = this.mParam;
        BodeParam bodeParam = this.mBodeParam;
        MappingObject mappingObject5 = this.mAverageMappingObj;
        MappingObject mappingObject6 = this.mPeakMappingObj;
        MappingObject mappingObject7 = this.mAutoMappingObj;
        int i32 = ((j & 576461851815051328L) > 0L ? 1 : ((j & 576461851815051328L) == 0L ? 0 : -1));
        if (i32 != 0) {
            onCheckedChangeListener = onCheckedChangeListener2;
            i = Roll.OFF.getValue();
        } else {
            onCheckedChangeListener = onCheckedChangeListener2;
            i = 0;
        }
        if ((j & 576460752303620097L) != 0) {
            String str43 = ((j & 576460752303554561L) == 0 || mappingObject == null) ? null : mappingObject.getStr();
            if ((j & 576460752303489025L) == 0 || mappingObject == null) {
                str = str43;
                drawable = null;
            } else {
                drawable = mappingObject.getPic();
                str = str43;
            }
        } else {
            drawable = null;
            str = null;
        }
        if ((j & 576460752304209922L) != 0) {
            Drawable pic = ((j & 576460752303685634L) == 0 || mappingObject2 == null) ? null : mappingObject2.getPic();
            str2 = ((j & 576460752303947778L) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
            Drawable drawable11 = pic;
            drawable2 = drawable;
            drawable3 = drawable11;
        } else {
            drawable2 = drawable;
            drawable3 = null;
            str2 = null;
        }
        if ((j & 576460752316006416L) != 0) {
            Drawable pic2 = ((j & 576460752307617808L) == 0 || mappingObject3 == null) ? null : mappingObject3.getPic();
            str4 = ((j & 576460752311812112L) == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
            Drawable drawable12 = pic2;
            str3 = str2;
            drawable4 = drawable12;
        } else {
            str3 = str2;
            drawable4 = null;
            str4 = null;
        }
        String str44 = ((j & 576460752320200736L) == 0 || mappingObject4 == null) ? null : mappingObject4.getStr();
        float f12 = 0.0f;
        if ((j & 621496748546721228L) != 0) {
            long j16 = 0;
            if ((j & 576610286354563136L) != 0) {
                horiTimeMode2 = horizontalParam != null ? horizontalParam.getTimeMode() : null;
                int i33 = ((j & 576460752773185600L) > 0L ? 1 : ((j & 576460752773185600L) == 0L ? 0 : -1));
                drawable5 = drawable3;
                if (i33 != 0) {
                    z48 = horiTimeMode2 == ServiceEnum.HoriTimeMode.Horizontal_YT;
                    if (i33 != 0) {
                        j2 |= z48 ? 2L : 1L;
                    }
                } else {
                    z48 = false;
                }
                j16 = 0;
                if ((j & 576610285951909952L) != 0) {
                    z31 = z48;
                    z30 = horiTimeMode2 != ServiceEnum.HoriTimeMode.Horizontal_ROLL;
                    if ((j & 2882444499072581696L) != 0 || (j2 & 8388608) != 0) {
                        j2 = z30 ? j2 | PlaybackStateCompat.ACTION_PREPARE_FROM_URI : j2 | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    }
                    if ((j & 576469548463554624L) != 0) {
                        j2 = z30 ? j2 | 536870912 : j2 | 268435456;
                    }
                    if ((j & 576460752370532416L) != 0) {
                        f9 = ContextUtil.getAlpha(z30);
                        if ((j & 576460754451955780L) == j16) {
                            if (horizontalParam != null) {
                                z6 = z30;
                                highResBit = horizontalParam.getHighBit();
                            } else {
                                z6 = z30;
                                highResBit = null;
                            }
                            if (highResBit != null) {
                                i31 = highResBit.value1;
                                horiTimeMode3 = horiTimeMode2;
                            } else {
                                horiTimeMode3 = horiTimeMode2;
                                i31 = 0;
                            }
                            MappingObject mappingObject8 = ViewUtil.getMappingObject(R.array.msg_acq_highres_bit, i31);
                            updateRegistration(2, mappingObject8);
                            if (mappingObject8 != null) {
                                str23 = mappingObject8.getStr();
                                boolean isFine = ((j & 576478344489467968L) != 0 || horizontalParam == null) ? false : horizontalParam.isFine();
                                boolean xyCheck = ((j & 576465150349934656L) != 0 || horizontalParam == null) ? false : horizontalParam.getXyCheck();
                                String highBw = ((j & 576460756598390848L) != 0 || horizontalParam == null) ? null : horizontalParam.getHighBw();
                                if ((j & 576462951326679104L) != 0) {
                                    z32 = horizontalParam != null ? horizontalParam.getXyCheckEnable() : false;
                                    f10 = ContextUtil.getAlpha(z32);
                                } else {
                                    z32 = false;
                                    f10 = 0.0f;
                                }
                                i17 = ((j & 576461302059237440L) > 0L ? 1 : ((j & 576461302059237440L) == 0L ? 0 : -1));
                                if (i17 != 0) {
                                    z33 = horizontalParam != null ? horizontalParam.getSapmassa() : false;
                                    if (i17 != 0) {
                                        if (z33) {
                                            j14 = j2 | PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                                            j15 = 134217728;
                                        } else {
                                            j14 = j2 | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                                            j15 = 67108864;
                                        }
                                        j2 = j14 | j15;
                                    }
                                    i18 = z33 ? 0 : 4;
                                    i19 = z33 ? 4 : 0;
                                } else {
                                    i18 = 0;
                                    z33 = false;
                                    i19 = 0;
                                }
                                if ((j & 576531121047601216L) != 0) {
                                    if (horizontalParam != null) {
                                        drawable6 = drawable4;
                                        str5 = str4;
                                        j13 = horizontalParam.getMainScale();
                                    } else {
                                        drawable6 = drawable4;
                                        str5 = str4;
                                        j13 = 0;
                                    }
                                    str24 = str23;
                                    z34 = isFine;
                                    str25 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j13, ServiceEnum.Unit.Unit_s);
                                } else {
                                    str24 = str23;
                                    drawable6 = drawable4;
                                    str5 = str4;
                                    z34 = isFine;
                                    str25 = null;
                                }
                                if ((576469548398542920L & j) != 0) {
                                    horizontalExpand2 = horizontalParam != null ? horizontalParam.getExpandMode() : null;
                                    MappingObject mappingObject9 = ViewUtil.getMappingObject(R.array.msg_hor_expand, horizontalExpand2 != null ? horizontalExpand2.value1 : 0);
                                    updateRegistration(3, mappingObject9);
                                    str27 = mappingObject9 != null ? mappingObject9.getStr() : null;
                                    int i34 = ((j & 576469548396445760L) > 0L ? 1 : ((j & 576469548396445760L) == 0L ? 0 : -1));
                                    str26 = str25;
                                    if (i34 != 0) {
                                        z35 = horizontalExpand2 == ServiceEnum.HorizontalExpand.Horizontal_Expand_User;
                                        if (i34 != 0) {
                                            j2 |= z35 ? 32L : 16L;
                                        }
                                        i20 = z35 ? 0 : 8;
                                    } else {
                                        z35 = false;
                                        i20 = 0;
                                    }
                                } else {
                                    str26 = str25;
                                    z35 = false;
                                    i20 = 0;
                                    horizontalExpand2 = null;
                                    str27 = null;
                                }
                                if ((j & 576460769483292736L) != 0) {
                                    if (horizontalParam != null) {
                                        horizontalExpand = horizontalExpand2;
                                        str28 = str27;
                                        j12 = horizontalParam.getTimeOut();
                                    } else {
                                        horizontalExpand = horizontalExpand2;
                                        str28 = str27;
                                        j12 = 0;
                                    }
                                    z11 = z35;
                                    i21 = i20;
                                    str29 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(j12, ServiceEnum.Unit.Unit_s);
                                } else {
                                    z11 = z35;
                                    horizontalExpand = horizontalExpand2;
                                    str28 = str27;
                                    i21 = i20;
                                    str29 = null;
                                }
                                boolean isAntiAliasing = ((576460752840294464L & j) != 0 || horizontalParam == null) ? false : horizontalParam.isAntiAliasing();
                                if (i32 != 0) {
                                    int roll = horizontalParam != null ? horizontalParam.getRoll() : 0;
                                    z37 = roll != i;
                                    z36 = roll == i;
                                } else {
                                    z36 = false;
                                    z37 = false;
                                }
                                i22 = ((j & 576460760893358144L) > 0L ? 1 : ((j & 576460760893358144L) == 0L ? 0 : -1));
                                if (i22 != 0) {
                                    if (horizontalParam != null) {
                                        j5 = horizontalParam.getMaxFrame();
                                        messageAttr = horizontalParam.getMaxFrameAttr();
                                    } else {
                                        messageAttr = null;
                                        j5 = 0;
                                    }
                                    j6 = messageAttr != null ? messageAttr.getMaxLongValue() : 0L;
                                    z38 = j5 > j6;
                                    if (i22 != 0) {
                                        j2 |= z38 ? 2147483648L : 1073741824L;
                                    }
                                } else {
                                    z38 = false;
                                    j5 = 0;
                                    j6 = 0;
                                }
                                String mainOffsetStr = ((j & 576742227280134208L) != 0 || horizontalParam == null) ? null : horizontalParam.getMainOffsetStr();
                                if ((j & 576461027181330496L) != 0) {
                                    if (horizontalParam != null) {
                                        z40 = isAntiAliasing;
                                        z41 = z37;
                                        j11 = horizontalParam.getSample();
                                    } else {
                                        z40 = isAntiAliasing;
                                        z41 = z37;
                                        j11 = 0;
                                    }
                                    str30 = str29;
                                    z39 = z36;
                                    str31 = UnitFormat.newBuilder("0.00").convert(j11, ServiceEnum.Unit.Unit_SaS);
                                } else {
                                    str30 = str29;
                                    z39 = z36;
                                    z40 = isAntiAliasing;
                                    z41 = z37;
                                    str31 = null;
                                }
                                if ((577023702256844864L & j) != 0) {
                                    str32 = str31;
                                    str33 = UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(horizontalParam != null ? horizontalParam.getZoomScale() : 0L, ServiceEnum.Unit.Unit_s);
                                } else {
                                    str32 = str31;
                                    str33 = null;
                                }
                                if ((576495936675512384L & j) != 0) {
                                    str34 = String.valueOf(horizontalParam != null ? horizontalParam.getExpandUser() : 0);
                                } else {
                                    str34 = null;
                                }
                                String zoomOffsetStr = ((577586652210266176L & j) != 0 || horizontalParam == null) ? null : horizontalParam.getZoomOffsetStr();
                                if ((j & 612489686761342016L) != 0) {
                                    ServiceEnum.AcquireDepth depth = horizontalParam != null ? horizontalParam.getDepth() : null;
                                    if (depth != null) {
                                        i30 = depth.value1;
                                        str35 = str33;
                                    } else {
                                        str35 = str33;
                                        i30 = 0;
                                    }
                                    MappingObject mappingObject10 = ViewUtil.getMappingObject(R.array.msg_acq_memdepth, i30);
                                    updateRegistration(10, mappingObject10);
                                    if (mappingObject10 != null) {
                                        str36 = mappingObject10.getStr();
                                        if ((j & 576460753377165376L) == 0) {
                                            str37 = String.valueOf(horizontalParam != null ? horizontalParam.getAvgTimes() : 0);
                                        } else {
                                            str37 = null;
                                        }
                                        i23 = ((j & 576460752437641280L) > 0L ? 1 : ((j & 576460752437641280L) == 0L ? 0 : -1));
                                        if (i23 == 0) {
                                            z14 = horizontalParam != null ? horizontalParam.isZoom() : false;
                                            if (i23 != 0) {
                                                j2 |= z14 ? PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : PlaybackStateCompat.ACTION_PREPARE;
                                            }
                                            i24 = z14 ? 0 : 8;
                                        } else {
                                            i24 = 0;
                                            z14 = false;
                                        }
                                        if ((j & 580964420650271040L) == 0) {
                                            if (horizontalParam != null) {
                                                str39 = str34;
                                                str38 = str36;
                                                i29 = horizontalParam.getDisplayMode();
                                            } else {
                                                str38 = str36;
                                                str39 = str34;
                                                i29 = 0;
                                            }
                                            MappingObject mappingObject11 = ViewUtil.getMappingObject(R.array.msg_acq_ultra_displaymode, i29);
                                            updateRegistration(8, mappingObject11);
                                            if (mappingObject11 != null) {
                                                str40 = mappingObject11.getStr();
                                                if ((j & 576460786663161920L) != 0) {
                                                    z42 = horizontalParam != null ? horizontalParam.isDepthEn() : false;
                                                    f11 = ContextUtil.getAlpha(z42);
                                                } else {
                                                    z42 = false;
                                                    f11 = 0.0f;
                                                }
                                                if ((j & 578853289706127552L) != 0) {
                                                    ServiceEnum.AcquireMode acquireMode = horizontalParam != null ? horizontalParam.getAcquireMode() : null;
                                                    int i35 = ((j & 576460752336977984L) > 0L ? 1 : ((j & 576460752336977984L) == 0L ? 0 : -1));
                                                    String str45 = str40;
                                                    if (i35 != 0) {
                                                        str41 = zoomOffsetStr;
                                                        boolean z49 = acquireMode == ServiceEnum.AcquireMode.Acquire_HighResolution;
                                                        str42 = str37;
                                                        boolean z50 = acquireMode == ServiceEnum.AcquireMode.Acquire_Average;
                                                        boolean z51 = acquireMode == ServiceEnum.AcquireMode.Acquire_Ultra;
                                                        if (i35 != 0) {
                                                            j2 |= z49 ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                                                        }
                                                        if (i35 != 0) {
                                                            j2 |= z50 ? PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH : PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                                                        }
                                                        if (i35 != 0) {
                                                            if (z51) {
                                                                j |= Long.MIN_VALUE;
                                                                j10 = 8;
                                                            } else {
                                                                j |= 4611686018427387904L;
                                                                j10 = 4;
                                                            }
                                                            j2 |= j10;
                                                        }
                                                        j3 = j;
                                                        int i36 = acquireMode != null ? acquireMode.value1 : 0;
                                                        int i37 = z49 ? 0 : 4;
                                                        i25 = z50 ? 0 : 4;
                                                        i26 = z51 ? 0 : 4;
                                                        i28 = i37;
                                                        i27 = z51 ? 0 : 8;
                                                        z44 = i36 == ServiceEnum.AcquireMode.Acquire_Ultra.value1;
                                                        z45 = i36 == ServiceEnum.AcquireMode.Acquire_Average.value1;
                                                        z46 = i36 == ServiceEnum.AcquireMode.Acquire_HighResolution.value1;
                                                        z47 = i36 == ServiceEnum.AcquireMode.Acquire_Peak.value1;
                                                        z43 = i36 == ServiceEnum.AcquireMode.Acquire_Normal.value1;
                                                    } else {
                                                        str41 = zoomOffsetStr;
                                                        str42 = str37;
                                                        j3 = j;
                                                        z43 = false;
                                                        i25 = 0;
                                                        i26 = 0;
                                                        i27 = 0;
                                                        i28 = 0;
                                                        z44 = false;
                                                        z45 = false;
                                                        z46 = false;
                                                        z47 = false;
                                                    }
                                                    z = acquireMode != ServiceEnum.AcquireMode.Acquire_Ultra;
                                                    if ((j3 & 578853289706127552L) != 0) {
                                                        j2 |= z ? 128L : 64L;
                                                    }
                                                    if ((j3 & 576601489892442176L) != 0) {
                                                        j2 = z ? j2 | 8388608 : j2 | 4194304;
                                                    }
                                                    i2 = i27;
                                                    str17 = mainOffsetStr;
                                                    z16 = xyCheck;
                                                    str18 = highBw;
                                                    z17 = z32;
                                                    f2 = f10;
                                                    i7 = i18;
                                                    z18 = z33;
                                                    i8 = i19;
                                                    z15 = z34;
                                                    str11 = str24;
                                                    str10 = str26;
                                                    str13 = str28;
                                                    i6 = i21;
                                                    z7 = z40;
                                                    z4 = z39;
                                                    i9 = i24;
                                                    str9 = str38;
                                                    str12 = str39;
                                                    f3 = f11;
                                                    str14 = str45;
                                                    str16 = str41;
                                                    str15 = str42;
                                                    z19 = z47;
                                                    z13 = z43;
                                                    i5 = i25;
                                                    z8 = z38;
                                                    z10 = z42;
                                                    z9 = z31;
                                                    f = f9;
                                                    horiTimeMode = horiTimeMode3;
                                                    str7 = str30;
                                                    str8 = str32;
                                                    str6 = str35;
                                                    z2 = z45;
                                                    z5 = z46;
                                                    j4 = j2;
                                                    i3 = i26;
                                                    z3 = z41;
                                                    i4 = i28;
                                                    z12 = z44;
                                                } else {
                                                    String str46 = str40;
                                                    String str47 = zoomOffsetStr;
                                                    String str48 = str37;
                                                    j3 = j;
                                                    str17 = mainOffsetStr;
                                                    z = false;
                                                    z2 = false;
                                                    i2 = 0;
                                                    i4 = 0;
                                                    i5 = 0;
                                                    z19 = false;
                                                    f = f9;
                                                    z16 = xyCheck;
                                                    str18 = highBw;
                                                    z17 = z32;
                                                    f2 = f10;
                                                    i7 = i18;
                                                    z18 = z33;
                                                    i8 = i19;
                                                    z15 = z34;
                                                    str11 = str24;
                                                    str10 = str26;
                                                    str13 = str28;
                                                    i6 = i21;
                                                    z7 = z40;
                                                    z4 = z39;
                                                    str8 = str32;
                                                    i9 = i24;
                                                    str9 = str38;
                                                    str12 = str39;
                                                    f3 = f11;
                                                    str14 = str46;
                                                    str16 = str47;
                                                    str15 = str48;
                                                    z8 = z38;
                                                    z5 = false;
                                                    z13 = false;
                                                    z10 = z42;
                                                    z9 = z31;
                                                    horiTimeMode = horiTimeMode3;
                                                    str7 = str30;
                                                    str6 = str35;
                                                    j4 = j2;
                                                    i3 = 0;
                                                    z3 = z41;
                                                    z12 = false;
                                                }
                                            }
                                        } else {
                                            str38 = str36;
                                            str39 = str34;
                                        }
                                        str40 = null;
                                        if ((j & 576460786663161920L) != 0) {
                                        }
                                        if ((j & 578853289706127552L) != 0) {
                                        }
                                    }
                                } else {
                                    str35 = str33;
                                }
                                str36 = null;
                                if ((j & 576460753377165376L) == 0) {
                                }
                                i23 = ((j & 576460752437641280L) > 0L ? 1 : ((j & 576460752437641280L) == 0L ? 0 : -1));
                                if (i23 == 0) {
                                }
                                if ((j & 580964420650271040L) == 0) {
                                }
                                str40 = null;
                                if ((j & 576460786663161920L) != 0) {
                                }
                                if ((j & 578853289706127552L) != 0) {
                                }
                            }
                        } else {
                            z6 = z30;
                            horiTimeMode3 = horiTimeMode2;
                        }
                        str23 = null;
                        if ((j & 576478344489467968L) != 0) {
                        }
                        if ((j & 576465150349934656L) != 0) {
                        }
                        if ((j & 576460756598390848L) != 0) {
                        }
                        if ((j & 576462951326679104L) != 0) {
                        }
                        i17 = ((j & 576461302059237440L) > 0L ? 1 : ((j & 576461302059237440L) == 0L ? 0 : -1));
                        if (i17 != 0) {
                        }
                        if ((j & 576531121047601216L) != 0) {
                        }
                        if ((576469548398542920L & j) != 0) {
                        }
                        if ((j & 576460769483292736L) != 0) {
                        }
                        if ((576460752840294464L & j) != 0) {
                        }
                        if (i32 != 0) {
                        }
                        i22 = ((j & 576460760893358144L) > 0L ? 1 : ((j & 576460760893358144L) == 0L ? 0 : -1));
                        if (i22 != 0) {
                        }
                        if ((j & 576742227280134208L) != 0) {
                        }
                        if ((j & 576461027181330496L) != 0) {
                        }
                        if ((577023702256844864L & j) != 0) {
                        }
                        if ((576495936675512384L & j) != 0) {
                        }
                        if ((577586652210266176L & j) != 0) {
                        }
                        if ((j & 612489686761342016L) != 0) {
                        }
                        str36 = null;
                        if ((j & 576460753377165376L) == 0) {
                        }
                        i23 = ((j & 576460752437641280L) > 0L ? 1 : ((j & 576460752437641280L) == 0L ? 0 : -1));
                        if (i23 == 0) {
                        }
                        if ((j & 580964420650271040L) == 0) {
                        }
                        str40 = null;
                        if ((j & 576460786663161920L) != 0) {
                        }
                        if ((j & 578853289706127552L) != 0) {
                        }
                    }
                } else {
                    z31 = z48;
                    z30 = false;
                }
            } else {
                drawable5 = drawable3;
                z30 = false;
                z31 = false;
                horiTimeMode2 = null;
            }
            f9 = 0.0f;
            if ((j & 576460754451955780L) == j16) {
            }
            str23 = null;
            if ((j & 576478344489467968L) != 0) {
            }
            if ((j & 576465150349934656L) != 0) {
            }
            if ((j & 576460756598390848L) != 0) {
            }
            if ((j & 576462951326679104L) != 0) {
            }
            i17 = ((j & 576461302059237440L) > 0L ? 1 : ((j & 576461302059237440L) == 0L ? 0 : -1));
            if (i17 != 0) {
            }
            if ((j & 576531121047601216L) != 0) {
            }
            if ((576469548398542920L & j) != 0) {
            }
            if ((j & 576460769483292736L) != 0) {
            }
            if ((576460752840294464L & j) != 0) {
            }
            if (i32 != 0) {
            }
            i22 = ((j & 576460760893358144L) > 0L ? 1 : ((j & 576460760893358144L) == 0L ? 0 : -1));
            if (i22 != 0) {
            }
            if ((j & 576742227280134208L) != 0) {
            }
            if ((j & 576461027181330496L) != 0) {
            }
            if ((577023702256844864L & j) != 0) {
            }
            if ((576495936675512384L & j) != 0) {
            }
            if ((577586652210266176L & j) != 0) {
            }
            if ((j & 612489686761342016L) != 0) {
            }
            str36 = null;
            if ((j & 576460753377165376L) == 0) {
            }
            i23 = ((j & 576460752437641280L) > 0L ? 1 : ((j & 576460752437641280L) == 0L ? 0 : -1));
            if (i23 == 0) {
            }
            if ((j & 580964420650271040L) == 0) {
            }
            str40 = null;
            if ((j & 576460786663161920L) != 0) {
            }
            if ((j & 578853289706127552L) != 0) {
            }
        } else {
            drawable5 = drawable3;
            drawable6 = drawable4;
            str5 = str4;
            j3 = j;
            j4 = j2;
            z = false;
            z2 = false;
            i2 = 0;
            z3 = false;
            i3 = 0;
            i4 = 0;
            z4 = false;
            i5 = 0;
            z5 = false;
            z6 = false;
            z7 = false;
            z8 = false;
            z9 = false;
            z10 = false;
            z11 = false;
            z12 = false;
            z13 = false;
            z14 = false;
            i6 = 0;
            z15 = false;
            z16 = false;
            z17 = false;
            i7 = 0;
            z18 = false;
            i8 = 0;
            i9 = 0;
            z19 = false;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
            str11 = null;
            str12 = null;
            str13 = null;
            horiTimeMode = null;
            str14 = null;
            horizontalExpand = null;
            str15 = null;
            str16 = null;
            str17 = null;
            str18 = null;
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
            j5 = 0;
            j6 = 0;
        }
        if ((j3 & 603482350067646976L) != 0) {
            Drawable pic3 = ((j3 & 585467951558164992L) == 0 || mappingObject5 == null) ? null : mappingObject5.getPic();
            if ((j3 & 594475150812905984L) == 0 || mappingObject5 == null) {
                drawable7 = pic3;
                str19 = null;
            } else {
                Drawable drawable13 = pic3;
                str19 = mappingObject5.getStr();
                drawable7 = drawable13;
            }
        } else {
            drawable7 = null;
            str19 = null;
        }
        int i38 = ((j3 & 576460752303423488L) > 0L ? 1 : ((j3 & 576460752303423488L) == 0L ? 0 : -1));
        if (i38 != 0 && i38 != 0) {
            if (ViewUtil.checkModelEDU()) {
                j8 = j4 | 512;
                j9 = 33554432;
            } else {
                j8 = j4 | 256;
                j9 = 16777216;
            }
            j4 = j8 | j9;
        }
        long j17 = 0;
        if ((j3 & 792633534417209344L) != 0) {
            Drawable pic4 = ((j3 & 648518346341353472L) == 0 || mappingObject6 == null) ? null : mappingObject6.getPic();
            if ((j3 & 720575940379281408L) == 0 || mappingObject6 == null) {
                drawable8 = pic4;
                str20 = null;
            } else {
                Drawable drawable14 = pic4;
                str20 = mappingObject6.getStr();
                drawable8 = drawable14;
            }
        } else {
            drawable8 = null;
            str20 = null;
        }
        String str49 = ((j3 & 864691128455139328L) == 0 || mappingObject7 == null) ? null : mappingObject7.getStr();
        if ((j4 & 8388610) != 0) {
            int i39 = ((j4 & 8388608) > 0L ? 1 : ((j4 & 8388608) == 0L ? 0 : -1));
            if (i39 != 0) {
                if (horizontalParam != null) {
                    horiTimeMode = horizontalParam.getTimeMode();
                }
                drawable9 = drawable7;
                drawable10 = drawable8;
                ServiceEnum.HoriTimeMode horiTimeMode4 = horiTimeMode;
                z6 = horiTimeMode4 != ServiceEnum.HoriTimeMode.Horizontal_ROLL;
                if ((j3 & 2882444499072581696L) != 0 || i39 != 0) {
                    j4 = z6 ? j4 | PlaybackStateCompat.ACTION_PREPARE_FROM_URI : j4 | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                }
                j17 = 0;
                if ((j3 & 576469548463554624L) != 0) {
                    j4 = z6 ? j4 | 536870912 : j4 | 268435456;
                }
                horiTimeMode = horiTimeMode4;
            } else {
                drawable9 = drawable7;
                drawable10 = drawable8;
            }
            if ((j4 & 2) != j17) {
                if (horizontalParam != null) {
                    z14 = horizontalParam.isZoom();
                }
                if ((j3 & 576460752437641280L) != j17) {
                    j4 |= z14 ? PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : PlaybackStateCompat.ACTION_PREPARE;
                }
                z20 = !z14;
                boolean z52 = z14;
                if ((j4 & 128) == 0) {
                    z21 = !(bodeParam != null ? bodeParam.getBodeEnable() : false);
                } else {
                    z21 = false;
                }
                if ((j3 & 576460760893358144L) == 0) {
                    if (z8) {
                        j5 = j6;
                    }
                    z22 = z21;
                    str21 = String.valueOf(j5);
                } else {
                    z22 = z21;
                    str21 = null;
                }
                i10 = ((j3 & 576460752773185600L) > 0L ? 1 : ((j3 & 576460752773185600L) == 0L ? 0 : -1));
                if (i10 == 0) {
                    if (!z9) {
                        z20 = false;
                    }
                    if (i10 != 0) {
                        j4 = z20 ? j4 | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE : j4 | PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                    }
                } else {
                    z20 = false;
                }
                i11 = ((j3 & 578853289706127552L) > 0L ? 1 : ((j3 & 578853289706127552L) == 0L ? 0 : -1));
                if (i11 == 0) {
                    if (!z) {
                        z22 = false;
                    }
                    if (i11 != 0) {
                        j3 |= z22 ? LockFreeTaskQueueCore.CLOSED_MASK : LockFreeTaskQueueCore.FROZEN_MASK;
                    }
                } else {
                    z22 = false;
                }
                i12 = ((j3 & LockFreeTaskQueueCore.CLOSED_MASK) > 0L ? 1 : ((j3 & LockFreeTaskQueueCore.CLOSED_MASK) == 0L ? 0 : -1));
                if (i12 == 0 || (j4 & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) != 0) {
                    if (i12 == 0) {
                        if (horizontalParam != null) {
                            horiTimeMode = horizontalParam.getTimeMode();
                        }
                        z23 = z52;
                        ServiceEnum.HoriTimeMode horiTimeMode5 = horiTimeMode;
                        str22 = str21;
                        z6 = horiTimeMode5 != ServiceEnum.HoriTimeMode.Horizontal_ROLL;
                        j7 = 0;
                        if ((j3 & 2882444499072581696L) != 0 || (j4 & 8388608) != 0) {
                            j4 = z6 ? j4 | PlaybackStateCompat.ACTION_PREPARE_FROM_URI : j4 | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                        }
                        if ((j3 & 576469548463554624L) != 0) {
                            j4 = z6 ? j4 | 536870912 : j4 | 268435456;
                        }
                    } else {
                        str22 = str21;
                        z23 = z52;
                        j7 = 0;
                    }
                    ultraEnable = ((j4 & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) != j7 || horizontalParam == null) ? false : horizontalParam.getUltraEnable();
                    z24 = z6;
                } else {
                    str22 = str21;
                    z23 = z52;
                    ultraEnable = false;
                    z24 = z6;
                    j7 = 0;
                }
                i13 = ((j3 & 576460752773185600L) > j7 ? 1 : ((j3 & 576460752773185600L) == j7 ? 0 : -1));
                if (i13 == 0) {
                    if (!z20) {
                        ultraEnable = false;
                    }
                    f4 = ContextUtil.getAlpha(ultraEnable);
                    z25 = ultraEnable;
                } else {
                    z25 = false;
                    f4 = 0.0f;
                }
                if ((j4 & 536870912) == j7) {
                    if (horizontalParam != null) {
                        horizontalExpand = horizontalParam.getExpandMode();
                    }
                    f5 = f4;
                    z11 = horizontalExpand == ServiceEnum.HorizontalExpand.Horizontal_Expand_User;
                    if ((j3 & 576469548396445760L) != 0) {
                        j4 |= z11 ? 32L : 16L;
                    }
                } else {
                    f5 = f4;
                }
                if ((j4 & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
                    if ((horizontalParam != null ? horizontalParam.getRunStop() : null) == ServiceEnum.ControlAction.Control_Stop) {
                        z26 = true;
                        if ((j3 & 2882444499072581696L) == 0 || (j4 & 8388608) != 0) {
                            boolean z53 = z24 ? true : z26;
                            alpha = (j3 & 576601489858887744L) != 0 ? ContextUtil.getAlpha(z53) : 0.0f;
                            z27 = z53;
                        } else {
                            z27 = false;
                            alpha = 0.0f;
                        }
                        i14 = ((j3 & 576469548463554624L) > 0L ? 1 : ((j3 & 576469548463554624L) == 0L ? 0 : -1));
                        if (i14 != 0) {
                            if (!z24) {
                                z11 = false;
                            }
                            z28 = z27;
                            f6 = ContextUtil.getAlpha(z11);
                        } else {
                            z28 = z27;
                            f6 = 0.0f;
                        }
                        i15 = ((j3 & 578853289706127552L) > 0L ? 1 : ((j3 & 578853289706127552L) == 0L ? 0 : -1));
                        if (i15 != 0) {
                            boolean z54 = z22 ? z28 : false;
                            z29 = z54;
                            f7 = ContextUtil.getAlpha(z54);
                        } else {
                            z29 = false;
                            f7 = 0.0f;
                        }
                        i16 = ((j3 & 576601489892442176L) > 0L ? 1 : ((j3 & 576601489892442176L) == 0L ? 0 : -1));
                        if (i16 != 0) {
                            f12 = ContextUtil.getAlpha(z ? z28 : false);
                        }
                        float f13 = f12;
                        if ((j3 & 576461851815051328L) != 0) {
                            f8 = f13;
                            CompoundButtonBindingAdapter.setChecked(this.autoRadioButton, z3);
                            CompoundButtonBindingAdapter.setChecked(this.offRadioButton, z4);
                        } else {
                            f8 = f13;
                        }
                        if ((j3 & 864691128455139328L) != 0) {
                            TextViewBindingAdapter.setText(this.autoRadioButton, str49);
                        }
                        if ((j3 & 576460752303439872L) != 0) {
                            InverseBindingListener inverseBindingListener = null;
                            CompoundButton.OnCheckedChangeListener onCheckedChangeListener3 = onCheckedChangeListener;
                            CompoundButtonBindingAdapter.setListeners(this.autoRadioButton, onCheckedChangeListener3, inverseBindingListener);
                            CompoundButtonBindingAdapter.setListeners(this.averageRadioButton, onCheckedChangeListener3, inverseBindingListener);
                            CompoundButtonBindingAdapter.setListeners(this.delaySample, onCheckedChangeListener3, inverseBindingListener);
                            CompoundButtonBindingAdapter.setListeners(this.fineOnSwitch, onCheckedChangeListener3, inverseBindingListener);
                            CompoundButtonBindingAdapter.setListeners(this.histogramEn, onCheckedChangeListener3, inverseBindingListener);
                            CompoundButtonBindingAdapter.setListeners(this.hresRadioButton, onCheckedChangeListener3, inverseBindingListener);
                            CompoundButtonBindingAdapter.setListeners(this.normalRadioButton, onCheckedChangeListener3, inverseBindingListener);
                            CompoundButtonBindingAdapter.setListeners(this.offRadioButton, onCheckedChangeListener3, inverseBindingListener);
                            CompoundButtonBindingAdapter.setListeners(this.peakRadioButton, onCheckedChangeListener3, inverseBindingListener);
                            CompoundButtonBindingAdapter.setListeners(this.ultraRadioButton, onCheckedChangeListener3, inverseBindingListener);
                            CompoundButtonBindingAdapter.setListeners(this.xyCheck, onCheckedChangeListener3, inverseBindingListener);
                            CompoundButtonBindingAdapter.setListeners(this.zoomOnSwitch, onCheckedChangeListener3, inverseBindingListener);
                        }
                        if ((j3 & 576460752370532416L) != 0) {
                            if (getBuildSdkInt() >= 11) {
                                this.averageRadioButton.setAlpha(f);
                                this.expand.setAlpha(f);
                                this.expandSpinner.setAlpha(f);
                            }
                            this.averageRadioButton.setEnabled(z24);
                            this.expandSpinner.setEnabled(z24);
                        }
                        if ((j3 & 576460752336977984L) != 0) {
                            CompoundButtonBindingAdapter.setChecked(this.averageRadioButton, z2);
                            this.avgTimes.setVisibility(i5);
                            this.avgTimesEditText.setVisibility(i5);
                            this.displaySpinner.setVisibility(i2);
                            this.displayText.setVisibility(i2);
                            this.highBit.setVisibility(i4);
                            this.highBitSpinner.setVisibility(i4);
                            this.highBw.setVisibility(i4);
                            this.highInfo.setVisibility(i4);
                            CompoundButtonBindingAdapter.setChecked(this.hresRadioButton, z5);
                            this.maxFrameEdit.setVisibility(i3);
                            this.maxFrameText.setVisibility(i3);
                            CompoundButtonBindingAdapter.setChecked(this.normalRadioButton, z13);
                            CompoundButtonBindingAdapter.setChecked(this.peakRadioButton, z19);
                            this.timeOutEdit.setVisibility(i2);
                            this.timeOutText.setVisibility(i2);
                            CompoundButtonBindingAdapter.setChecked(this.ultraRadioButton, z12);
                        }
                        if ((j3 & 585467951558164992L) != 0) {
                            TextViewBindingAdapter.setDrawableRight(this.averageRadioButton, drawable9);
                        }
                        if ((j3 & 594475150812905984L) != 0) {
                            TextViewBindingAdapter.setText(this.averageRadioButton, str19);
                        }
                        if ((j3 & 576460752303423488L) != 0) {
                            this.avgTimesEditText.setOnClickListener(this.mCallback88);
                            this.delaySample.setVisibility(ViewUtil.checkModelEDU() ? 4 : 0);
                            this.delaySampleText.setVisibility(ViewUtil.checkModelEDU() ? 4 : 0);
                            this.displaySpinner.setOnClickListener(this.mCallback92);
                            this.expandSpinner.setOnClickListener(this.mCallback94);
                            this.expandUserEditText.setOnClickListener(this.mCallback95);
                            this.highBitSpinner.setOnClickListener(this.mCallback89);
                            this.hresRadioButton.setVisibility(ViewUtil.checkModelEDU() ? 8 : 0);
                            this.mainOffsetEditText.setOnClickListener(this.mCallback99);
                            this.mainOffsetLeft.setOnClickListener(this.mCallback100);
                            this.mainOffsetRight.setOnClickListener(this.mCallback101);
                            this.mainScaleEditText.setOnClickListener(this.mCallback96);
                            this.mainScaleLeft.setOnClickListener(this.mCallback97);
                            this.mainScaleRight.setOnClickListener(this.mCallback98);
                            this.maxFrameEdit.setOnClickListener(this.mCallback90);
                            this.memdepthSpinner.setOnClickListener(this.mCallback93);
                            this.timeOutEdit.setOnClickListener(this.mCallback91);
                            this.zoomOffsetEditText.setOnClickListener(this.mCallback105);
                            this.zoomOffsetLeft.setOnClickListener(this.mCallback106);
                            this.zoomOffsetRight.setOnClickListener(this.mCallback107);
                            this.zoomScaleEditText.setOnClickListener(this.mCallback102);
                            this.zoomScaleLeft.setOnClickListener(this.mCallback103);
                            this.zoomScaleRight.setOnClickListener(this.mCallback104);
                        }
                        if ((j3 & 576460753377165376L) != 0) {
                            TextViewBindingAdapter.setText(this.avgTimesEditText, str15);
                        }
                        if ((j3 & 576461302059237440L) != 0) {
                            CompoundButtonBindingAdapter.setChecked(this.delaySample, z18);
                            this.mboundView22.setVisibility(i7);
                            this.sarateText.setVisibility(i8);
                        }
                        if ((j3 & 576460786663161920L) != 0) {
                            boolean z55 = z10;
                            this.displaySpinner.setEnabled(z55);
                            this.memdepthSpinner.setEnabled(z55);
                            if (getBuildSdkInt() >= 11) {
                                float f14 = f3;
                                this.memdepth.setAlpha(f14);
                                this.memdepthSpinner.setAlpha(f14);
                            }
                        }
                        if ((j3 & 580964420650271040L) != 0) {
                            TextViewBindingAdapter.setText(this.displaySpinner, str14);
                        }
                        if ((j3 & 576469548398542920L) != 0) {
                            TextViewBindingAdapter.setText(this.expandSpinner, str13);
                        }
                        if (i14 != 0 && getBuildSdkInt() >= 11) {
                            this.expandUser.setAlpha(f6);
                            this.expandUserEditText.setAlpha(f6);
                        }
                        if ((j3 & 576469548396445760L) != 0) {
                            int i40 = i6;
                            this.expandUser.setVisibility(i40);
                            this.expandUserEditText.setVisibility(i40);
                        }
                        if ((j3 & 576495936675512384L) != 0) {
                            TextViewBindingAdapter.setText(this.expandUserEditText, str12);
                        }
                        if ((j3 & 576478344489467968L) != 0) {
                            CompoundButtonBindingAdapter.setChecked(this.fineOnSwitch, z15);
                        }
                        if ((j3 & 576460754451955780L) != 0) {
                            TextViewBindingAdapter.setText(this.highBitSpinner, str11);
                        }
                        if ((j3 & 576460756598390848L) != 0) {
                            TextViewBindingAdapter.setText(this.highBw, str18);
                        }
                        if ((j3 & 576460752840294464L) != 0) {
                            CompoundButtonBindingAdapter.setChecked(this.histogramEn, z7);
                        }
                        if ((j3 & 576460752307617808L) != 0) {
                            TextViewBindingAdapter.setDrawableRight(this.hresRadioButton, drawable6);
                        }
                        if ((j3 & 576460752311812112L) != 0) {
                            TextViewBindingAdapter.setText(this.hresRadioButton, str5);
                        }
                        if ((j3 & 576601489858887744L) != 0) {
                            if (getBuildSdkInt() >= 11) {
                                this.mainOffset.setAlpha(alpha);
                                this.mainOffsetEditText.setAlpha(alpha);
                                this.mainOffsetLeft.setAlpha(alpha);
                                this.mainOffsetRight.setAlpha(alpha);
                            }
                            boolean z56 = z28;
                            this.mainOffsetEditText.setEnabled(z56);
                            this.mainOffsetLeft.setEnabled(z56);
                            this.mainOffsetRight.setEnabled(z56);
                        }
                        if ((j3 & 576742227280134208L) != 0) {
                            TextViewBindingAdapter.setText(this.mainOffsetEditText, str17);
                        }
                        if ((j3 & 576531121047601216L) != 0) {
                            TextViewBindingAdapter.setText(this.mainScaleEditText, str10);
                        }
                        if ((j3 & 576460760893358144L) != 0) {
                            TextViewBindingAdapter.setText(this.maxFrameEdit, str22);
                        }
                        if ((j3 & 612489686761342016L) != 0) {
                            TextViewBindingAdapter.setText(this.memdepthSpinner, str9);
                        }
                        if ((j3 & 576460752303685634L) != 0) {
                            TextViewBindingAdapter.setDrawableRight(this.normalRadioButton, drawable5);
                        }
                        if ((j3 & 576460752303947778L) != 0) {
                            TextViewBindingAdapter.setText(this.normalRadioButton, str3);
                        }
                        if ((j3 & 576460752320200736L) != 0) {
                            TextViewBindingAdapter.setText(this.offRadioButton, str44);
                        }
                        if ((j3 & 648518346341353472L) != 0) {
                            TextViewBindingAdapter.setDrawableRight(this.peakRadioButton, drawable10);
                        }
                        if ((j3 & 720575940379281408L) != 0) {
                            TextViewBindingAdapter.setText(this.peakRadioButton, str20);
                        }
                        if ((j3 & 576461027181330496L) != 0) {
                            TextViewBindingAdapter.setText(this.sarateText, str8);
                        }
                        if ((j3 & 576460769483292736L) != 0) {
                            TextViewBindingAdapter.setText(this.timeOutEdit, str7);
                        }
                        if (i13 != 0) {
                            if (getBuildSdkInt() >= 11) {
                                this.ultraRadioButton.setAlpha(f5);
                            }
                            this.ultraRadioButton.setEnabled(z25);
                        }
                        if ((j3 & 576460752303489025L) != 0) {
                            TextViewBindingAdapter.setDrawableRight(this.ultraRadioButton, drawable2);
                        }
                        if ((j3 & 576460752303554561L) != 0) {
                            TextViewBindingAdapter.setText(this.ultraRadioButton, str);
                        }
                        if ((j3 & 576462951326679104L) != 0) {
                            if (getBuildSdkInt() >= 11) {
                                this.xyCheck.setAlpha(f2);
                            }
                            this.xyCheck.setEnabled(z17);
                        }
                        if ((j3 & 576465150349934656L) != 0) {
                            CompoundButtonBindingAdapter.setChecked(this.xyCheck, z16);
                        }
                        if ((j3 & 576460752437641280L) != 0) {
                            int i41 = i9;
                            this.zoomOffset.setVisibility(i41);
                            this.zoomOffsetEditText.setVisibility(i41);
                            this.zoomOffsetLeft.setVisibility(i41);
                            this.zoomOffsetRight.setVisibility(i41);
                            CompoundButtonBindingAdapter.setChecked(this.zoomOnSwitch, z23);
                            this.zoomScale.setVisibility(i41);
                            this.zoomScaleEditText.setVisibility(i41);
                            this.zoomScaleLeft.setVisibility(i41);
                            this.zoomScaleRight.setVisibility(i41);
                        }
                        if ((j3 & 577586652210266176L) != 0) {
                            TextViewBindingAdapter.setText(this.zoomOffsetEditText, str16);
                        }
                        if (i16 != 0 && getBuildSdkInt() >= 11) {
                            this.zoomOn.setAlpha(f8);
                        }
                        if (i15 != 0) {
                            if (getBuildSdkInt() >= 11) {
                                this.zoomOnSwitch.setAlpha(f7);
                            }
                            this.zoomOnSwitch.setEnabled(z29);
                        }
                        if ((j3 & 577023702256844864L) != 0) {
                            TextViewBindingAdapter.setText(this.zoomScaleEditText, str6);
                            return;
                        }
                        return;
                    }
                }
                z26 = false;
                if ((j3 & 2882444499072581696L) == 0) {
                }
                if (z24) {
                }
                if ((j3 & 576601489858887744L) != 0) {
                }
                z27 = z53;
                i14 = ((j3 & 576469548463554624L) > 0L ? 1 : ((j3 & 576469548463554624L) == 0L ? 0 : -1));
                if (i14 != 0) {
                }
                i15 = ((j3 & 578853289706127552L) > 0L ? 1 : ((j3 & 578853289706127552L) == 0L ? 0 : -1));
                if (i15 != 0) {
                }
                i16 = ((j3 & 576601489892442176L) > 0L ? 1 : ((j3 & 576601489892442176L) == 0L ? 0 : -1));
                if (i16 != 0) {
                }
                float f132 = f12;
                if ((j3 & 576461851815051328L) != 0) {
                }
                if ((j3 & 864691128455139328L) != 0) {
                }
                if ((j3 & 576460752303439872L) != 0) {
                }
                if ((j3 & 576460752370532416L) != 0) {
                }
                if ((j3 & 576460752336977984L) != 0) {
                }
                if ((j3 & 585467951558164992L) != 0) {
                }
                if ((j3 & 594475150812905984L) != 0) {
                }
                if ((j3 & 576460752303423488L) != 0) {
                }
                if ((j3 & 576460753377165376L) != 0) {
                }
                if ((j3 & 576461302059237440L) != 0) {
                }
                if ((j3 & 576460786663161920L) != 0) {
                }
                if ((j3 & 580964420650271040L) != 0) {
                }
                if ((j3 & 576469548398542920L) != 0) {
                }
                if (i14 != 0) {
                    this.expandUser.setAlpha(f6);
                    this.expandUserEditText.setAlpha(f6);
                }
                if ((j3 & 576469548396445760L) != 0) {
                }
                if ((j3 & 576495936675512384L) != 0) {
                }
                if ((j3 & 576478344489467968L) != 0) {
                }
                if ((j3 & 576460754451955780L) != 0) {
                }
                if ((j3 & 576460756598390848L) != 0) {
                }
                if ((j3 & 576460752840294464L) != 0) {
                }
                if ((j3 & 576460752307617808L) != 0) {
                }
                if ((j3 & 576460752311812112L) != 0) {
                }
                if ((j3 & 576601489858887744L) != 0) {
                }
                if ((j3 & 576742227280134208L) != 0) {
                }
                if ((j3 & 576531121047601216L) != 0) {
                }
                if ((j3 & 576460760893358144L) != 0) {
                }
                if ((j3 & 612489686761342016L) != 0) {
                }
                if ((j3 & 576460752303685634L) != 0) {
                }
                if ((j3 & 576460752303947778L) != 0) {
                }
                if ((j3 & 576460752320200736L) != 0) {
                }
                if ((j3 & 648518346341353472L) != 0) {
                }
                if ((j3 & 720575940379281408L) != 0) {
                }
                if ((j3 & 576461027181330496L) != 0) {
                }
                if ((j3 & 576460769483292736L) != 0) {
                }
                if (i13 != 0) {
                }
                if ((j3 & 576460752303489025L) != 0) {
                }
                if ((j3 & 576460752303554561L) != 0) {
                }
                if ((j3 & 576462951326679104L) != 0) {
                }
                if ((j3 & 576465150349934656L) != 0) {
                }
                if ((j3 & 576460752437641280L) != 0) {
                }
                if ((j3 & 577586652210266176L) != 0) {
                }
                if (i16 != 0) {
                    this.zoomOn.setAlpha(f8);
                }
                if (i15 != 0) {
                }
                if ((j3 & 577023702256844864L) != 0) {
                }
            }
        } else {
            drawable9 = drawable7;
            drawable10 = drawable8;
        }
        z20 = false;
        boolean z522 = z14;
        if ((j4 & 128) == 0) {
        }
        if ((j3 & 576460760893358144L) == 0) {
        }
        i10 = ((j3 & 576460752773185600L) > 0L ? 1 : ((j3 & 576460752773185600L) == 0L ? 0 : -1));
        if (i10 == 0) {
        }
        i11 = ((j3 & 578853289706127552L) > 0L ? 1 : ((j3 & 578853289706127552L) == 0L ? 0 : -1));
        if (i11 == 0) {
        }
        i12 = ((j3 & LockFreeTaskQueueCore.CLOSED_MASK) > 0L ? 1 : ((j3 & LockFreeTaskQueueCore.CLOSED_MASK) == 0L ? 0 : -1));
        if (i12 == 0) {
        }
        if (i12 == 0) {
        }
        if ((j4 & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) != j7) {
        }
        z24 = z6;
        i13 = ((j3 & 576460752773185600L) > j7 ? 1 : ((j3 & 576460752773185600L) == j7 ? 0 : -1));
        if (i13 == 0) {
        }
        if ((j4 & 536870912) == j7) {
        }
        if ((j4 & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
        }
        z26 = false;
        if ((j3 & 2882444499072581696L) == 0) {
        }
        if (z24) {
        }
        if ((j3 & 576601489858887744L) != 0) {
        }
        z27 = z53;
        i14 = ((j3 & 576469548463554624L) > 0L ? 1 : ((j3 & 576469548463554624L) == 0L ? 0 : -1));
        if (i14 != 0) {
        }
        i15 = ((j3 & 578853289706127552L) > 0L ? 1 : ((j3 & 578853289706127552L) == 0L ? 0 : -1));
        if (i15 != 0) {
        }
        i16 = ((j3 & 576601489892442176L) > 0L ? 1 : ((j3 & 576601489892442176L) == 0L ? 0 : -1));
        if (i16 != 0) {
        }
        float f1322 = f12;
        if ((j3 & 576461851815051328L) != 0) {
        }
        if ((j3 & 864691128455139328L) != 0) {
        }
        if ((j3 & 576460752303439872L) != 0) {
        }
        if ((j3 & 576460752370532416L) != 0) {
        }
        if ((j3 & 576460752336977984L) != 0) {
        }
        if ((j3 & 585467951558164992L) != 0) {
        }
        if ((j3 & 594475150812905984L) != 0) {
        }
        if ((j3 & 576460752303423488L) != 0) {
        }
        if ((j3 & 576460753377165376L) != 0) {
        }
        if ((j3 & 576461302059237440L) != 0) {
        }
        if ((j3 & 576460786663161920L) != 0) {
        }
        if ((j3 & 580964420650271040L) != 0) {
        }
        if ((j3 & 576469548398542920L) != 0) {
        }
        if (i14 != 0) {
        }
        if ((j3 & 576469548396445760L) != 0) {
        }
        if ((j3 & 576495936675512384L) != 0) {
        }
        if ((j3 & 576478344489467968L) != 0) {
        }
        if ((j3 & 576460754451955780L) != 0) {
        }
        if ((j3 & 576460756598390848L) != 0) {
        }
        if ((j3 & 576460752840294464L) != 0) {
        }
        if ((j3 & 576460752307617808L) != 0) {
        }
        if ((j3 & 576460752311812112L) != 0) {
        }
        if ((j3 & 576601489858887744L) != 0) {
        }
        if ((j3 & 576742227280134208L) != 0) {
        }
        if ((j3 & 576531121047601216L) != 0) {
        }
        if ((j3 & 576460760893358144L) != 0) {
        }
        if ((j3 & 612489686761342016L) != 0) {
        }
        if ((j3 & 576460752303685634L) != 0) {
        }
        if ((j3 & 576460752303947778L) != 0) {
        }
        if ((j3 & 576460752320200736L) != 0) {
        }
        if ((j3 & 648518346341353472L) != 0) {
        }
        if ((j3 & 720575940379281408L) != 0) {
        }
        if ((j3 & 576461027181330496L) != 0) {
        }
        if ((j3 & 576460769483292736L) != 0) {
        }
        if (i13 != 0) {
        }
        if ((j3 & 576460752303489025L) != 0) {
        }
        if ((j3 & 576460752303554561L) != 0) {
        }
        if ((j3 & 576462951326679104L) != 0) {
        }
        if ((j3 & 576465150349934656L) != 0) {
        }
        if ((j3 & 576460752437641280L) != 0) {
        }
        if ((j3 & 577586652210266176L) != 0) {
        }
        if (i16 != 0) {
        }
        if (i15 != 0) {
        }
        if ((j3 & 577023702256844864L) != 0) {
        }
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
