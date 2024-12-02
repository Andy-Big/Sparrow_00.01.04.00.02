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
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.CounterResultParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.generated.callback.OnClickListener;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ViewUtil;
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
    */
    protected void executeBindings() {
        long j;
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String str2;
        String str3;
        int i6;
        String str4;
        int i7;
        int i8;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mTotalizeMappingObject;
        MappingObject mappingObject2 = this.mPeriodMappingObject;
        MappingObject mappingObject3 = this.mFrequencyMappingObject;
        CounterResultParam counterResultParam = this.mParam;
        View.OnClickListener onClickListener = this.mOnClickListener;
        String str5 = ((j & 16449) == 0 || mappingObject == null) ? null : mappingObject.getStr();
        String str6 = ((j & 16514) == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        String str7 = ((j & 16644) == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        if ((j & 32280) != 0) {
            z = ((j & 24592) == 0 || counterResultParam == null) ? false : counterResultParam.isCounterSwitch();
            if ((j & 20496) != 0) {
                str4 = String.valueOf(counterResultParam != null ? counterResultParam.getResolution() : 0);
            } else {
                str4 = null;
            }
            if ((j & 17944) != 0) {
                ServiceEnum.Chan sourceA = counterResultParam != null ? counterResultParam.getSourceA() : null;
                i7 = (j & 17424) != 0 ? ColorUtil.getColor(getRoot().getContext(), sourceA) : 0;
                MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_counter_1_src, sourceA != null ? sourceA.value1 : 0);
                updateRegistration(3, mappingObject4);
                if (mappingObject4 != null) {
                    str2 = mappingObject4.getStr();
                    i8 = ((j & 18448) > 0L ? 1 : ((j & 18448) == 0L ? 0 : -1));
                    if (i8 == 0) {
                        ServiceEnum.CounterType counterType = counterResultParam != null ? counterResultParam.getCounterType() : null;
                        z2 = counterType == ServiceEnum.CounterType.FREQ;
                        z3 = counterType == ServiceEnum.CounterType.PERIOD;
                        z4 = counterType == ServiceEnum.CounterType.TOTALIZE;
                        boolean z5 = counterType != ServiceEnum.CounterType.TOTALIZE;
                        if (i8 != 0) {
                            j |= z4 ? PlaybackStateCompat.ACTION_SET_REPEAT_MODE : PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                        }
                        if ((j & 18448) != 0) {
                            if (z5) {
                                j2 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH | PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                                j3 = 4194304;
                            } else {
                                j2 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                                j3 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                            }
                            j = j2 | j3;
                        }
                        int i9 = z4 ? 4 : 0;
                        int i10 = z5 ? 8 : 0;
                        int i11 = z5 ? 0 : 4;
                        i2 = z5 ? 8 : 4;
                        str = str5;
                        i4 = i9;
                        i = i7;
                        i3 = i10;
                        i5 = i11;
                    } else {
                        str = str5;
                        i = i7;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                        i5 = 0;
                        z2 = false;
                        z3 = false;
                        z4 = false;
                    }
                    str3 = str4;
                }
            } else {
                i7 = 0;
            }
            str2 = null;
            i8 = ((j & 18448) > 0L ? 1 : ((j & 18448) == 0L ? 0 : -1));
            if (i8 == 0) {
            }
            str3 = str4;
        } else {
            str = str5;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            str2 = null;
            str3 = null;
        }
        if ((j & 18448) != 0) {
            i6 = i;
            this.clear.setVisibility(i2);
            this.clearButton.setVisibility(i3);
            this.counterStatSwitch.setVisibility(i4);
            CompoundButtonBindingAdapter.setChecked(this.frequencyRadioButton, z2);
            CompoundButtonBindingAdapter.setChecked(this.periodRadioButton, z3);
            this.resolution.setVisibility(i5);
            this.resolutionEditText.setVisibility(i5);
            this.stat.setVisibility(i4);
            CompoundButtonBindingAdapter.setChecked(this.totalizeRadioButton, z4);
        } else {
            i6 = i;
        }
        if ((PlaybackStateCompat.ACTION_PREPARE & j) != 0) {
            this.clearButton.setOnClickListener(this.mCallback32);
            this.resolutionEditText.setOnClickListener(this.mCallback31);
            this.sourceSpinner.setOnClickListener(this.mCallback30);
        }
        if ((j & 24592) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.counterStatSwitch, z);
        }
        if ((16644 & j) != 0) {
            TextViewBindingAdapter.setText(this.frequencyRadioButton, str7);
        }
        if ((16514 & j) != 0) {
            TextViewBindingAdapter.setText(this.periodRadioButton, str6);
        }
        if ((j & 20496) != 0) {
            TextViewBindingAdapter.setText(this.resolutionEditText, str3);
        }
        if ((j & 17944) != 0) {
            TextViewBindingAdapter.setText(this.sourceSpinner, str2);
        }
        if ((j & 17424) != 0) {
            this.sourceSpinner.setTextColor(i6);
        }
        if ((j & 16449) != 0) {
            TextViewBindingAdapter.setText(this.totalizeRadioButton, str);
        }
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
