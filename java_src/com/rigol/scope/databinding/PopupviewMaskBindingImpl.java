package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MaskParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class PopupviewMaskBindingImpl extends PopupviewMaskBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 41);
        sViewsWithIds.put(R.id.enable, 42);
        sViewsWithIds.put(R.id.radioGroup_maskRange, 43);
    }

    public PopupviewMaskBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 44, sIncludes, sViewsWithIds));
    }

    private PopupviewMaskBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 9, (Button) objArr[20], (Button) objArr[21], (Button) objArr[22], (CheckBox) objArr[39], (CheckBox) objArr[40], (CheckBox) objArr[38], (View) objArr[7], (View) objArr[23], (TextView) objArr[42], (SwitchButton) objArr[1], (Guideline) objArr[41], (ImageButton) objArr[18], (ImageButton) objArr[19], (ImageButton) objArr[15], (ImageButton) objArr[14], (TextView) objArr[8], (TextView) objArr[2], (ImageView) objArr[3], (RadioButton) objArr[11], (RadioButton) objArr[31], (RadioButton) objArr[36], (RadioButton) objArr[32], (RadioButton) objArr[35], (RadioButton) objArr[10], (RadioGroup) objArr[30], (RadioGroup) objArr[34], (RadioGroup) objArr[43], (Button) objArr[6], (TextView) objArr[4], (TextView) objArr[5], (SwitchButton) objArr[26], (TextView) objArr[37], (TextView) objArr[25], (TextView) objArr[24], (TextView) objArr[29], (TextView) objArr[33], (TextView) objArr[27], (TextView) objArr[9], (TextView) objArr[16], (TextView) objArr[12], (TextView) objArr[28], (TextView) objArr[17], (TextView) objArr[13]);
        this.mDirtyFlags = -1L;
        this.buttonMaskCreateMenu.setTag(null);
        this.buttonMaskLoad.setTag(null);
        this.buttonMaskSave.setTag(null);
        this.checkBoxMaskBeeper.setTag(null);
        this.checkBoxMaskScreen.setTag(null);
        this.checkBoxMaskStop.setTag(null);
        this.dividingLine1.setTag(null);
        this.dividingLine2.setTag(null);
        this.enableSwitch.setTag(null);
        this.imageButtonMaskXmaskLeft.setTag(null);
        this.imageButtonMaskXmaskRight.setTag(null);
        this.imageButtonMaskYmaskDown.setTag(null);
        this.imageButtonMaskYmaskUP.setTag(null);
        this.mask.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.operate.setTag(null);
        this.operateButton.setTag(null);
        this.radioButtonMaskCursor.setTag(null);
        this.radioButtonMaskFaile.setTag(null);
        this.radioButtonMaskNegativePulse.setTag(null);
        this.radioButtonMaskPass.setTag(null);
        this.radioButtonMaskPositionPulse.setTag(null);
        this.radioButtonMaskScreen.setTag(null);
        this.radioGroupMaskOutEvent.setTag(null);
        this.radioGroupMaskOutHl.setTag(null);
        this.resetButton.setTag(null);
        this.source.setTag(null);
        this.sourceSpinner.setTag(null);
        this.switchButtonMaskOut.setTag(null);
        this.textViewMaskErrAction.setTag(null);
        this.textViewMaskOUt.setTag(null);
        this.textViewMaskOption.setTag(null);
        this.textViewMaskOutEvent.setTag(null);
        this.textViewMaskOutHl.setTag(null);
        this.textViewMaskOutPulse.setTag(null);
        this.textViewMaskRange.setTag(null);
        this.textViewMaskXmask.setTag(null);
        this.textViewMaskYmask.setTag(null);
        this.valueMaskOUtPulse.setTag(null);
        this.valueMaskXmask.setTag(null);
        this.valueMaskYmask.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 268435456L;
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
        if (13 == i) {
            setNegativeMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((MaskParam) obj);
        } else if (3 == i) {
            setCursorMapping((MappingObject) obj);
        } else if (18 == i) {
            setScreenMapping((MappingObject) obj);
        } else if (16 == i) {
            setPositiveMapping((MappingObject) obj);
        } else if (14 == i) {
            setPassMapping((MappingObject) obj);
        } else if (5 == i) {
            setFailMapping((MappingObject) obj);
        } else if (382 != i) {
            return false;
        } else {
            setHorizontalParam((HorizontalParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewMaskBinding
    public void setNegativeMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mNegativeMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(13);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMaskBinding
    public void setParam(MaskParam maskParam) {
        updateRegistration(1, maskParam);
        this.mParam = maskParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMaskBinding
    public void setCursorMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mCursorMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMaskBinding
    public void setScreenMapping(MappingObject mappingObject) {
        updateRegistration(3, mappingObject);
        this.mScreenMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMaskBinding
    public void setPositiveMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mPositiveMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMaskBinding
    public void setPassMapping(MappingObject mappingObject) {
        updateRegistration(6, mappingObject);
        this.mPassMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(14);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMaskBinding
    public void setFailMapping(MappingObject mappingObject) {
        updateRegistration(7, mappingObject);
        this.mFailMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewMaskBinding
    public void setHorizontalParam(HorizontalParam horizontalParam) {
        this.mHorizontalParam = horizontalParam;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeNegativeMapping((MappingObject) obj, i2);
            case 1:
                return onChangeParam((MaskParam) obj, i2);
            case 2:
                return onChangeCursorMapping((MappingObject) obj, i2);
            case 3:
                return onChangeScreenMapping((MappingObject) obj, i2);
            case 4:
                return onChangeViewUtilGetArrayComRigolScopeRArrayMsgMaskSourceGetParamSource((MappingObject) obj, i2);
            case 5:
                return onChangePositiveMapping((MappingObject) obj, i2);
            case 6:
                return onChangePassMapping((MappingObject) obj, i2);
            case 7:
                return onChangeFailMapping((MappingObject) obj, i2);
            case 8:
                return onChangeHorizontalParam((HorizontalParam) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeNegativeMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeParam(MaskParam maskParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 271) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 572) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 858) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 541) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 685) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 1086) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 1080) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 63) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 577) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 575) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 576) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 277) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeCursorMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeScreenMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetArrayComRigolScopeRArrayMsgMaskSourceGetParamSource(MappingObject mappingObject, int i) {
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

    private boolean onChangePositiveMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangePassMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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

    private boolean onChangeFailMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
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

    private boolean onChangeHorizontalParam(HorizontalParam horizontalParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02d9  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1745
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewMaskBindingImpl.executeBindings():void");
    }
}
