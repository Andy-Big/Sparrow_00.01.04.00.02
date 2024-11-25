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
import com.rigol.scope.data.CounterResultParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.generated.callback.OnClickListener;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class PopupviewResultCounterBindingImpl extends PopupviewResultCounterBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback30;
    private final View.OnClickListener mCallback31;
    private final View.OnClickListener mCallback32;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 11);
        sViewsWithIds.put(R.id.source, 12);
        sViewsWithIds.put(R.id.type, 13);
        sViewsWithIds.put(R.id.type_radio_group, 14);
        sViewsWithIds.put(R.id.delete, 15);
        sViewsWithIds.put(R.id.delete_button, 16);
    }

    public PopupviewResultCounterBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private PopupviewResultCounterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (TextView) objArr[7], (Button) objArr[8], (SwitchButton) objArr[10], (TextView) objArr[15], (Button) objArr[16], (RadioButton) objArr[2], (Guideline) objArr[11], (RadioButton) objArr[3], (TextView) objArr[5], (EditText) objArr[6], (TextView) objArr[12], (TextView) objArr[1], (TextView) objArr[9], (RadioButton) objArr[4], (TextView) objArr[13], (RadioGroup) objArr[14]);
        this.mDirtyFlags = -1L;
        this.clear.setTag(null);
        this.clearButton.setTag(null);
        this.counterStatSwitch.setTag(null);
        this.frequencyRadioButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.periodRadioButton.setTag(null);
        this.resolution.setTag(null);
        this.resolutionEditText.setTag(null);
        this.sourceSpinner.setTag(null);
        this.stat.setTag(null);
        this.totalizeRadioButton.setTag(null);
        setRootTag(view);
        this.mCallback30 = new OnClickListener(this, 1);
        this.mCallback32 = new OnClickListener(this, 3);
        this.mCallback31 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE;
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
        if (942 == i) {
            setTotalizeMappingObject((MappingObject) obj);
        } else if (618 == i) {
            setPeriodMappingObject((MappingObject) obj);
        } else if (351 == i) {
            setFrequencyMappingObject((MappingObject) obj);
        } else if (594 == i) {
            setParam((CounterResultParam) obj);
        } else if (569 != i) {
            return false;
        } else {
            setOnClickListener((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewResultCounterBinding
    public void setTotalizeMappingObject(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mTotalizeMappingObject = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(942);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultCounterBinding
    public void setPeriodMappingObject(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mPeriodMappingObject = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(618);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultCounterBinding
    public void setFrequencyMappingObject(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mFrequencyMappingObject = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(351);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultCounterBinding
    public void setParam(CounterResultParam counterResultParam) {
        updateRegistration(4, counterResultParam);
        this.mParam = counterResultParam;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewResultCounterBinding
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(569);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return false;
                        }
                        return onChangeParam((CounterResultParam) obj, i2);
                    }
                    return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCounter1SrcParamSourceAValue1((MappingObject) obj, i2);
                }
                return onChangeFrequencyMappingObject((MappingObject) obj, i2);
            }
            return onChangePeriodMappingObject((MappingObject) obj, i2);
        }
        return onChangeTotalizeMappingObject((MappingObject) obj, i2);
    }

    private boolean onChangeTotalizeMappingObject(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangePeriodMappingObject(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeFrequencyMappingObject(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgCounter1SrcParamSourceAValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
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

    private boolean onChangeParam(CounterResultParam counterResultParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 862) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 192) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 738) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 191) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x013a  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewResultCounterBindingImpl.executeBindings():void");
    }

    @Override // com.rigol.scope.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        if (i == 1) {
            View.OnClickListener onClickListener = this.mOnClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        } else if (i == 2) {
            View.OnClickListener onClickListener2 = this.mOnClickListener;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
            }
        } else if (i != 3) {
        } else {
            View.OnClickListener onClickListener3 = this.mOnClickListener;
            if (onClickListener3 != null) {
                onClickListener3.onClick(view);
            }
        }
    }
}
