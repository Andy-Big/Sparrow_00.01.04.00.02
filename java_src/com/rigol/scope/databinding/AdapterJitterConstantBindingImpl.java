package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.JitterParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;

/* loaded from: classes2.dex */
public class AdapterJitterConstantBindingImpl extends AdapterJitterConstantBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.jitter_constant_layout, 6);
        sViewsWithIds.put(R.id.jitter_type_label, 7);
        sViewsWithIds.put(R.id.jitter_type_radioGroup, 8);
    }

    public AdapterJitterConstantBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private AdapterJitterConstantBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (ConstraintLayout) objArr[6], (TextView) objArr[5], (TextView) objArr[1], (RadioButton) objArr[2], (TextView) objArr[7], (RadioButton) objArr[4], (RadioGroup) objArr[8], (RadioButton) objArr[3]);
        this.mDirtyFlags = -1L;
        this.jitterDataRateLabel.setTag(null);
        this.jitterDataRateValue.setTag(null);
        this.jitterTypeAtuoRadioButton.setTag(null);
        this.jitterTypeManualRadioButton.setTag(null);
        this.jitterTypeSemiautoRadioButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 512L;
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
        if (594 == i) {
            setParam((JitterParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterJitterConstantBinding
    public void setParam(JitterParam jitterParam) {
        updateRegistration(1, jitterParam);
        this.mParam = jitterParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterCrFreqtypeInt1((MappingObject) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterCrFreqtypeInt2((MappingObject) obj, i2);
            }
            return onChangeParam((JitterParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterCrFreqtypeInt0((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterCrFreqtypeInt0(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(JitterParam jitterParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 978) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 221) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterCrFreqtypeInt2(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterCrFreqtypeInt1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
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

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String str;
        float f;
        boolean z5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        JitterParam jitterParam = this.mParam;
        String str2 = (j & 640) != 0 ? ViewUtil.getMappingObject(R.array.msg_jitter_cr_freqtype, 2).getStr() : null;
        String str3 = (j & 768) != 0 ? ViewUtil.getMappingObject(R.array.msg_jitter_cr_freqtype, 1).getStr() : null;
        if ((j & 610) != 0) {
            int i = ((j & 546) > 0L ? 1 : ((j & 546) == 0L ? 0 : -1));
            if (i != 0) {
                int type = jitterParam != null ? jitterParam.getType() : 0;
                z4 = type == 0;
                boolean z6 = type == 2;
                z5 = type != 0;
                boolean z7 = type == 1;
                if (i != 0) {
                    j |= z4 ? PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH : PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                }
                if ((j & 546) != 0) {
                    j |= z6 ? PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                }
                if ((j & 546) != 0) {
                    j |= z7 ? PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : PlaybackStateCompat.ACTION_PREPARE;
                }
                boolean z8 = z6;
                z2 = z7;
                f = ContextUtil.getAlpha(z5);
                z3 = z8;
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
                f = 0.0f;
            }
            if ((j & 578) != 0) {
                str = UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(jitterParam != null ? jitterParam.getDataRate() : 0L, ServiceEnum.Unit.Unit_bps);
                z = z5;
            } else {
                z = z5;
                str = null;
            }
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            str = null;
            f = 0.0f;
        }
        int i2 = ((j & 528) > 0L ? 1 : ((j & 528) == 0L ? 0 : -1));
        String str4 = i2 != 0 ? ViewUtil.getMappingObject(R.array.msg_jitter_cr_freqtype, 0).getStr() : null;
        if ((j & 546) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.jitterDataRateLabel.setAlpha(f);
                this.jitterDataRateValue.setAlpha(f);
            }
            this.jitterDataRateValue.setEnabled(z);
            CompoundButtonBindingAdapter.setChecked(this.jitterTypeAtuoRadioButton, z4);
            CompoundButtonBindingAdapter.setChecked(this.jitterTypeManualRadioButton, z3);
            CompoundButtonBindingAdapter.setChecked(this.jitterTypeSemiautoRadioButton, z2);
        }
        if ((j & 578) != 0) {
            TextViewBindingAdapter.setText(this.jitterDataRateValue, str);
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.jitterTypeAtuoRadioButton, str4);
        }
        if ((640 & j) != 0) {
            TextViewBindingAdapter.setText(this.jitterTypeManualRadioButton, str2);
        }
        if ((j & 768) != 0) {
            TextViewBindingAdapter.setText(this.jitterTypeSemiautoRadioButton, str3);
        }
    }
}
