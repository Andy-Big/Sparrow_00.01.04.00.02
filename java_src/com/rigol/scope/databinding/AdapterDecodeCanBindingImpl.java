package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;

/* loaded from: classes2.dex */
public class AdapterDecodeCanBindingImpl extends AdapterDecodeCanBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.decode_can_layout, 8);
        sViewsWithIds.put(R.id.guideline_left, 9);
        sViewsWithIds.put(R.id.guideline_center, 10);
        sViewsWithIds.put(R.id.guideline_right, 11);
        sViewsWithIds.put(R.id.guideline_33, 12);
        sViewsWithIds.put(R.id.guideline_66, 13);
        sViewsWithIds.put(R.id.decode_can_src_label, 14);
        sViewsWithIds.put(R.id.decode_can_thres_label, 15);
        sViewsWithIds.put(R.id.decode_can_signal_label, 16);
        sViewsWithIds.put(R.id.decode_can_baud_label, 17);
        sViewsWithIds.put(R.id.decode_can_fd_baud_label, 18);
        sViewsWithIds.put(R.id.decode_can_samp_label, 19);
        sViewsWithIds.put(R.id.decode_can_fd_samp_label, 20);
    }

    public AdapterDecodeCanBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, sIncludes, sViewsWithIds));
    }

    private AdapterDecodeCanBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (TextView) objArr[17], (TextView) objArr[4], (TextView) objArr[18], (TextView) objArr[5], (TextView) objArr[20], (TextView) objArr[7], (ConstraintLayout) objArr[8], (TextView) objArr[19], (TextView) objArr[6], (TextView) objArr[16], (TextView) objArr[3], (TextView) objArr[14], (TextView) objArr[1], (TextView) objArr[15], (TextView) objArr[2], (Guideline) objArr[12], (Guideline) objArr[13], (Guideline) objArr[10], (Guideline) objArr[9], (Guideline) objArr[11]);
        this.mDirtyFlags = -1L;
        this.decodeCanBaudValue.setTag(null);
        this.decodeCanFdBaudValue.setTag(null);
        this.decodeCanFdSampValue.setTag(null);
        this.decodeCanSampValue.setTag(null);
        this.decodeCanSignalValue.setTag(null);
        this.decodeCanSrcValue.setTag(null);
        this.decodeCanThresValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
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
            setParam((DecodeParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeCanBinding
    public void setParam(DecodeParam decodeParam) {
        updateRegistration(0, decodeParam);
        this.mParam = decodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
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
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeCanSignalParamCanSingal((MappingObject) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeCanSrcParamCanSource((MappingObject) obj, i2);
        }
        return onChangeParam((DecodeParam) obj, i2);
    }

    private boolean onChangeParam(DecodeParam decodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 148) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 149) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 147) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 143) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 144) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 146) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 145) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeCanSrcParamCanSource(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeCanSignalParamCanSingal(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        float f;
        String str8;
        float f2;
        String str9;
        long j2;
        ServiceEnum.Unit unit;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        DecodeParam decodeParam = this.mParam;
        String str10 = null;
        if ((4095 & j) != 0) {
            if ((j & 2561) != 0) {
                str8 = UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(decodeParam != null ? decodeParam.getCan_fd_samp() : 0L, ServiceEnum.Unit.Unit_percent);
            } else {
                str8 = null;
            }
            if ((j & 2177) != 0) {
                str4 = UnitFormat.newBuilder(" 0.###  ", UnitFormat.SI.NONE).convert(decodeParam != null ? decodeParam.getCan_fd_baud() : 0, ServiceEnum.Unit.Unit_none) + "bps";
            } else {
                str4 = null;
            }
            if ((j & 2065) != 0) {
                if (decodeParam != null) {
                    unit = decodeParam.getUnit();
                    j2 = decodeParam.getCan_threas();
                } else {
                    j2 = 0;
                    unit = null;
                }
                str6 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j2, unit);
            } else {
                str6 = null;
            }
            if ((j & 2059) != 0) {
                int can_source = decodeParam != null ? decodeParam.getCan_source() : 0;
                if ((j & 2057) != 0) {
                    z = can_source < 8;
                    i = ColorUtil.getColorDoedCode(getRoot().getContext(), can_source);
                    f2 = ContextUtil.getAlpha(z);
                } else {
                    i = 0;
                    z = false;
                    f2 = 0.0f;
                }
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_decode_can_src, can_source);
                updateRegistration(1, mappingObject);
                str7 = mappingObject != null ? mappingObject.getStr() : null;
            } else {
                i = 0;
                z = false;
                str7 = null;
                f2 = 0.0f;
            }
            if ((j & 2113) != 0) {
                str = UnitFormat.newBuilder(" 0.###  ", UnitFormat.SI.NONE).convert(decodeParam != null ? decodeParam.getCan_baud() : 0, ServiceEnum.Unit.Unit_none) + "bps";
            } else {
                str = null;
            }
            if ((j & 2305) != 0) {
                str9 = UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(decodeParam != null ? decodeParam.getCan_samp() : 0L, ServiceEnum.Unit.Unit_percent);
            } else {
                str9 = null;
            }
            if ((j & 3109) != 0) {
                MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_decode_can_signal, decodeParam != null ? decodeParam.getCan_singal() : 0);
                updateRegistration(2, mappingObject2);
                if (mappingObject2 != null) {
                    str10 = mappingObject2.getStr();
                }
            }
            str3 = str9;
            str2 = str8;
            f = f2;
            str5 = str10;
        } else {
            i = 0;
            z = false;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            f = 0.0f;
        }
        if ((j & 2113) != 0) {
            TextViewBindingAdapter.setText(this.decodeCanBaudValue, str);
        }
        if ((j & 2177) != 0) {
            TextViewBindingAdapter.setText(this.decodeCanFdBaudValue, str4);
        }
        if ((j & 2561) != 0) {
            TextViewBindingAdapter.setText(this.decodeCanFdSampValue, str2);
        }
        if ((2305 & j) != 0) {
            TextViewBindingAdapter.setText(this.decodeCanSampValue, str3);
        }
        if ((3109 & j) != 0) {
            TextViewBindingAdapter.setText(this.decodeCanSignalValue, str5);
        }
        if ((2059 & j) != 0) {
            TextViewBindingAdapter.setText(this.decodeCanSrcValue, str7);
        }
        if ((2057 & j) != 0) {
            this.decodeCanSrcValue.setTextColor(i);
            this.decodeCanThresValue.setEnabled(z);
            if (getBuildSdkInt() >= 11) {
                this.decodeCanThresValue.setAlpha(f);
            }
        }
        if ((j & 2065) != 0) {
            TextViewBindingAdapter.setText(this.decodeCanThresValue, str6);
        }
    }
}
