package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.CursorResultParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.generated.callback.OnClickListener;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class PopupviewResultCursorBindingImpl extends PopupviewResultCursorBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback58;
    private final View.OnClickListener mCallback59;
    private final View.OnClickListener mCallback60;
    private final View.OnClickListener mCallback61;
    private final View.OnClickListener mCallback62;
    private final View.OnClickListener mCallback63;
    private final View.OnClickListener mCallback64;
    private final View.OnClickListener mCallback65;
    private final View.OnClickListener mCallback66;
    private long mDirtyFlags;
    private long mDirtyFlags_1;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 23);
        sViewsWithIds.put(R.id.guideline_left, 24);
        sViewsWithIds.put(R.id.guideline_right, 25);
        sViewsWithIds.put(R.id.mode, 26);
        sViewsWithIds.put(R.id.mode_radio_group, 27);
        sViewsWithIds.put(R.id.delete, 28);
        sViewsWithIds.put(R.id.delete_button, 29);
    }

    public PopupviewResultCursorBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 30, sIncludes, sViewsWithIds));
    }

    private PopupviewResultCursorBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 12, (TextView) objArr[16], (EditText) objArr[17], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[8], (TextView) objArr[9], (TextView) objArr[18], (EditText) objArr[19], (TextView) objArr[10], (TextView) objArr[11], (TextView) objArr[14], (SwitchButton) objArr[15], (Button) objArr[22], (TextView) objArr[28], (Button) objArr[29], (Guideline) objArr[23], (Guideline) objArr[24], (Guideline) objArr[25], (RadioButton) objArr[1], (TextView) objArr[26], (RadioGroup) objArr[27], (TextView) objArr[6], (TextView) objArr[7], (RadioButton) objArr[2], (TextView) objArr[20], (TextView) objArr[21], (TextView) objArr[12], (SwitchButton) objArr[13], (RadioButton) objArr[3]);
        this.mDirtyFlags = -1L;
        this.mDirtyFlags_1 = -1L;
        this.aLocation.setTag(null);
        this.aLocationEditText.setTag(null);
        this.aSrc.setTag(null);
        this.aSrcSpinnermanual.setTag(null);
        this.aSrcSpinnertrack.setTag(null);
        this.aSrcSpinnerxy.setTag(null);
        this.bLocation.setTag(null);
        this.bLocationEditText.setTag(null);
        this.bSrc.setTag(null);
        this.bSrcSpinner.setTag(null);
        this.bothAb.setTag(null);
        this.bothAbSwitch.setTag(null);
        this.byLocationEditText.setTag(null);
        this.manualRadioButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.syncArea.setTag(null);
        this.syncAreaSpinner.setTag(null);
        this.trackRadioButton.setTag(null);
        this.unit.setTag(null);
        this.unitSpinner.setTag(null);
        this.xOrY.setTag(null);
        this.xOrYSwitch.setTag(null);
        this.xyRadioButton.setTag(null);
        setRootTag(view);
        this.mCallback65 = new OnClickListener(this, 8);
        this.mCallback64 = new OnClickListener(this, 7);
        this.mCallback66 = new OnClickListener(this, 9);
        this.mCallback59 = new OnClickListener(this, 2);
        this.mCallback62 = new OnClickListener(this, 5);
        this.mCallback63 = new OnClickListener(this, 6);
        this.mCallback60 = new OnClickListener(this, 3);
        this.mCallback58 = new OnClickListener(this, 1);
        this.mCallback61 = new OnClickListener(this, 4);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 34359738368L;
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
        if (1083 == i) {
            setXyMapping((MappingObject) obj);
        } else if (944 == i) {
            setTrackMapping((MappingObject) obj);
        } else if (569 == i) {
            setOnClickListener((View.OnClickListener) obj);
        } else if (823 == i) {
            setSharedParam((SharedParam) obj);
        } else if (206 == i) {
            setCursorParam((CursorResultParam) obj);
        } else if (517 != i) {
            return false;
        } else {
            setManualMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewResultCursorBinding
    public void setXyMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mXyMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1083);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultCursorBinding
    public void setTrackMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mTrackMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(944);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultCursorBinding
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(569);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultCursorBinding
    public void setSharedParam(SharedParam sharedParam) {
        updateRegistration(7, sharedParam);
        this.mSharedParam = sharedParam;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(823);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultCursorBinding
    public void setCursorParam(CursorResultParam cursorResultParam) {
        updateRegistration(10, cursorResultParam);
        this.mCursorParam = cursorResultParam;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(206);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultCursorBinding
    public void setManualMapping(MappingObject mappingObject) {
        updateRegistration(11, mappingObject);
        this.mManualMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(517);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeXyMapping((MappingObject) obj, i2);
            case 1:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorTasrcCursorParamSourceAValue1((MappingObject) obj, i2);
            case 2:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorXysrcViewUtilGetWindowXyIndexCursorParamSourceACursorParamSourceB((MappingObject) obj, i2);
            case 3:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorTbsrcCursorParamSourceBValue1((MappingObject) obj, i2);
            case 4:
                return onChangeTrackMapping((MappingObject) obj, i2);
            case 5:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorSyncAreaCursorParamSyncAreaValue1((MappingObject) obj, i2);
            case 6:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorTimeunitCursorParamUnitValue1((MappingObject) obj, i2);
            case 7:
                return onChangeSharedParam((SharedParam) obj, i2);
            case 8:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorManualsrcCursorParamSourceAValue1((MappingObject) obj, i2);
            case 9:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorVunitCursorParamUnitValue1((MappingObject) obj, i2);
            case 10:
                return onChangeCursorParam((CursorResultParam) obj, i2);
            case 11:
                return onChangeManualMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeXyMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorTasrcCursorParamSourceAValue1(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorXysrcViewUtilGetWindowXyIndexCursorParamSourceACursorParamSourceB(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorTbsrcCursorParamSourceBValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeTrackMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorSyncAreaCursorParamSyncAreaValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorTimeunitCursorParamUnitValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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

    private boolean onChangeSharedParam(SharedParam sharedParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 1085) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorManualsrcCursorParamSourceAValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCursorVunitCursorParamUnitValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
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

    private boolean onChangeCursorParam(CursorResultParam cursorResultParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 205) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 862) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else if (i == 919) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else if (i == 866) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else if (i == 1032) {
            synchronized (this) {
                this.mDirtyFlags |= 134217728;
            }
            return true;
        } else if (i == 120) {
            synchronized (this) {
                this.mDirtyFlags |= 268435456;
            }
            return true;
        } else if (i == 68) {
            synchronized (this) {
                this.mDirtyFlags |= 536870912;
            }
            return true;
        } else if (i == 70) {
            synchronized (this) {
                this.mDirtyFlags |= 1073741824;
            }
            return true;
        } else if (i == 130) {
            synchronized (this) {
                this.mDirtyFlags |= 2147483648L;
            }
            return true;
        } else if (i == 132) {
            synchronized (this) {
                this.mDirtyFlags |= 4294967296L;
            }
            return true;
        } else if (i == 987) {
            synchronized (this) {
                this.mDirtyFlags |= 8589934592L;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeManualMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 17179869184L;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:206:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x062e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 2236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewResultCursorBindingImpl.executeBindings():void");
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
            default:
                return;
        }
    }
}
