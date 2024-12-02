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
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;

/* loaded from: classes2.dex */
public class AdapterJitterPllBindingImpl extends AdapterJitterPllBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.jitter_pll_layout, 7);
        sViewsWithIds.put(R.id.jitter_pllOrder_label, 8);
        sViewsWithIds.put(R.id.jitter_pllOrder_radioGroup, 9);
        sViewsWithIds.put(R.id.jitter_dataRate_label, 10);
        sViewsWithIds.put(R.id.jitter_pllWidth_label, 11);
    }

    public AdapterJitterPllBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private AdapterJitterPllBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[10], (TextView) objArr[5], (RadioButton) objArr[1], (ConstraintLayout) objArr[7], (TextView) objArr[8], (RadioGroup) objArr[9], (TextView) objArr[11], (TextView) objArr[6], (RadioButton) objArr[2]);
        this.mDirtyFlags = -1L;
        this.jitterDampFactorLabel.setTag(null);
        this.jitterDampFactorValue.setTag(null);
        this.jitterDataRateValue.setTag(null);
        this.jitterFirstOrderRadioButton.setTag(null);
        this.jitterPllWidthValue.setTag(null);
        this.jitterSecondOrderRadioButton.setTag(null);
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

    @Override // com.rigol.scope.databinding.AdapterJitterPllBinding
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
                    return false;
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterCrPllorderInt0((MappingObject) obj, i2);
            }
            return onChangeParam((JitterParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterCrPllorderInt1((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterCrPllorderInt1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
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
        } else if (i == 641) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 214) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 221) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 509) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgJitterCrPllorderInt0(MappingObject mappingObject, int i) {
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

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        int i;
        boolean z;
        String str3;
        boolean z2;
        boolean z3;
        boolean z4;
        long j2;
        long j3;
        long j4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        JitterParam jitterParam = this.mParam;
        String str4 = (j & 520) != 0 ? ViewUtil.getMappingObject(R.array.msg_jitter_cr_pllorder, 1).getStr() : null;
        if ((754 & j) != 0) {
            int i2 = ((j & 530) > 0L ? 1 : ((j & 530) == 0L ? 0 : -1));
            if (i2 != 0) {
                int pllOrder = jitterParam != null ? jitterParam.getPllOrder() : 0;
                z = pllOrder == 0;
                z3 = pllOrder == 1;
                if (i2 != 0) {
                    j |= z ? PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                }
                if ((j & 530) != 0) {
                    if (z3) {
                        j3 = j | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                        j4 = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    } else {
                        j3 = j | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                        j4 = PlaybackStateCompat.ACTION_PREPARE;
                    }
                    j = j3 | j4;
                }
                i = z3 ? 0 : 8;
            } else {
                i = 0;
                z = false;
                z3 = false;
            }
            if ((j & 578) != 0) {
                if (jitterParam != null) {
                    z4 = z3;
                    j2 = jitterParam.getDataRate();
                } else {
                    z4 = z3;
                    j2 = 0;
                }
                str3 = UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(j2, ServiceEnum.Unit.Unit_bps);
            } else {
                z4 = z3;
                str3 = null;
            }
            if ((j & 546) != 0) {
                str2 = UnitFormat.newBuilder(UnitFormat.SI.MILLI).convert(jitterParam != null ? jitterParam.getDampFactor() : 0, ServiceEnum.Unit.Unit_U);
            } else {
                str2 = null;
            }
            if ((j & 642) != 0) {
                str = UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(jitterParam != null ? jitterParam.getLoopBw() : 0L, ServiceEnum.Unit.Unit_hz);
                z2 = z4;
            } else {
                z2 = z4;
                str = null;
            }
        } else {
            str = null;
            str2 = null;
            i = 0;
            z = false;
            str3 = null;
            z2 = false;
        }
        int i3 = ((768 & j) > 0L ? 1 : ((768 & j) == 0L ? 0 : -1));
        String str5 = i3 != 0 ? ViewUtil.getMappingObject(R.array.msg_jitter_cr_pllorder, 0).getStr() : null;
        if ((j & 530) != 0) {
            this.jitterDampFactorLabel.setVisibility(i);
            this.jitterDampFactorValue.setVisibility(i);
            CompoundButtonBindingAdapter.setChecked(this.jitterFirstOrderRadioButton, z);
            CompoundButtonBindingAdapter.setChecked(this.jitterSecondOrderRadioButton, z2);
        }
        if ((j & 546) != 0) {
            TextViewBindingAdapter.setText(this.jitterDampFactorValue, str2);
        }
        if ((j & 578) != 0) {
            TextViewBindingAdapter.setText(this.jitterDataRateValue, str3);
        }
        if (i3 != 0) {
            TextViewBindingAdapter.setText(this.jitterFirstOrderRadioButton, str5);
        }
        if ((j & 642) != 0) {
            TextViewBindingAdapter.setText(this.jitterPllWidthValue, str);
        }
        if ((j & 520) != 0) {
            TextViewBindingAdapter.setText(this.jitterSecondOrderRadioButton, str4);
        }
    }
}
