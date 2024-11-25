package com.rigol.scope.databinding;

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
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
/* loaded from: classes2.dex */
public class AdapterDecode1553bBindingImpl extends AdapterDecode1553bBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.decode_1553b_layout, 3);
        sViewsWithIds.put(R.id.guideline_left, 4);
        sViewsWithIds.put(R.id.guideline_center, 5);
        sViewsWithIds.put(R.id.guideline_right, 6);
        sViewsWithIds.put(R.id.guideline_33, 7);
        sViewsWithIds.put(R.id.guideline_66, 8);
        sViewsWithIds.put(R.id.decode_1553b_src_label, 9);
        sViewsWithIds.put(R.id.decode_1553b_thres_label, 10);
    }

    public AdapterDecode1553bBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private AdapterDecode1553bBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ConstraintLayout) objArr[3], (TextView) objArr[9], (TextView) objArr[1], (TextView) objArr[10], (TextView) objArr[2], (Guideline) objArr[7], (Guideline) objArr[8], (Guideline) objArr[5], (Guideline) objArr[4], (Guideline) objArr[6]);
        this.mDirtyFlags = -1L;
        this.decode1553bSrcValue.setTag(null);
        this.decode1553bThresValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16L;
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

    @Override // com.rigol.scope.databinding.AdapterDecode1553bBinding
    public void setParam(DecodeParam decodeParam) {
        updateRegistration(1, decodeParam);
        this.mParam = decodeParam;
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
                return false;
            }
            return onChangeParam((DecodeParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecode1553bSrcParam1553bSource((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecode1553bSrcParam1553bSource(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParam(DecodeParam decodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 23) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 24) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
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
        long j2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        DecodeParam decodeParam = this.mParam;
        String str3 = null;
        ServiceEnum.Unit unit = null;
        String str4 = null;
        int i = 0;
        if ((31 & j) != 0) {
            if ((j & 23) != 0) {
                int i2 = decodeParam != null ? decodeParam.get_1553b_source() : 0;
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_decode_1553b_src, i2);
                updateRegistration(0, mappingObject);
                str2 = mappingObject != null ? mappingObject.getStr() : null;
                if ((j & 22) != 0) {
                    i = ColorUtil.getColor(getRoot().getContext(), i2);
                }
            } else {
                str2 = null;
            }
            if ((j & 26) != 0) {
                if (decodeParam != null) {
                    long j3 = decodeParam.get_1553b_thres1();
                    unit = decodeParam.getUnit();
                    j2 = j3;
                } else {
                    j2 = 0;
                }
                str4 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j2, unit);
            }
            str = str4;
            str3 = str2;
        } else {
            str = null;
        }
        if ((j & 23) != 0) {
            TextViewBindingAdapter.setText(this.decode1553bSrcValue, str3);
        }
        if ((j & 22) != 0) {
            this.decode1553bSrcValue.setTextColor(i);
        }
        if ((j & 26) != 0) {
            TextViewBindingAdapter.setText(this.decode1553bThresValue, str);
        }
    }
}
