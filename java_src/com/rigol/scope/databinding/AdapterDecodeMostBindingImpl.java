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
public class AdapterDecodeMostBindingImpl extends AdapterDecodeMostBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.decode_most_layout, 4);
        sViewsWithIds.put(R.id.guideline_left, 5);
        sViewsWithIds.put(R.id.guideline_center, 6);
        sViewsWithIds.put(R.id.guideline_right, 7);
        sViewsWithIds.put(R.id.guideline_33, 8);
        sViewsWithIds.put(R.id.guideline_66, 9);
        sViewsWithIds.put(R.id.decode_most_src_label, 10);
        sViewsWithIds.put(R.id.decode_most_thres_label, 11);
        sViewsWithIds.put(R.id.decode_most_signal_type_label, 12);
    }

    public AdapterDecodeMostBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private AdapterDecodeMostBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ConstraintLayout) objArr[4], (TextView) objArr[12], (TextView) objArr[3], (TextView) objArr[10], (TextView) objArr[1], (TextView) objArr[11], (TextView) objArr[2], (Guideline) objArr[8], (Guideline) objArr[9], (Guideline) objArr[6], (Guideline) objArr[5], (Guideline) objArr[7]);
        this.mDirtyFlags = -1L;
        this.decodeMostSignalTypeValue.setTag(null);
        this.decodeMostSrcValue.setTag(null);
        this.decodeMostThresValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128L;
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

    @Override // com.rigol.scope.databinding.AdapterDecodeMostBinding
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
                if (i != 2) {
                    return false;
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeMostSignalTypeParamMostSignalType((MappingObject) obj, i2);
            }
            return onChangeParam((DecodeParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeMostSrcParamMostSource((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeMostSrcParamMostSource(MappingObject mappingObject, int i) {
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
        } else if (i == 552) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 553) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 551) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeMostSignalTypeParamMostSignalType(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        long j2;
        ServiceEnum.Unit unit;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        DecodeParam decodeParam = this.mParam;
        long j3 = 230;
        int i = 0;
        if ((255 & j) != 0) {
            if ((j & 230) != 0) {
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_decode_most_signal_type, decodeParam != null ? decodeParam.getMost_signal_type() : 0);
                updateRegistration(2, mappingObject);
                if (mappingObject != null) {
                    str2 = mappingObject.getStr();
                    if ((j & 146) == 0) {
                        if (decodeParam != null) {
                            j2 = decodeParam.getMost_thres();
                            unit = decodeParam.getUnit();
                        } else {
                            j2 = 0;
                            unit = null;
                        }
                        str3 = UnitFormat.newBuilder(UnitFormat.SI.MICRO).convert(j2, unit);
                    } else {
                        str3 = null;
                    }
                    if ((j & 139) != 0) {
                        int most_source = decodeParam != null ? decodeParam.getMost_source() : 0;
                        MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_decode_most_src, most_source);
                        updateRegistration(0, mappingObject2);
                        r16 = mappingObject2 != null ? mappingObject2.getStr() : null;
                        if ((j & 138) != 0) {
                            i = ColorUtil.getColor(getRoot().getContext(), most_source);
                        }
                    }
                    str = r16;
                    j3 = 230;
                }
            }
            str2 = null;
            if ((j & 146) == 0) {
            }
            if ((j & 139) != 0) {
            }
            str = r16;
            j3 = 230;
        } else {
            str = null;
            str2 = null;
            str3 = null;
        }
        if ((j3 & j) != 0) {
            TextViewBindingAdapter.setText(this.decodeMostSignalTypeValue, str2);
        }
        if ((j & 138) != 0) {
            this.decodeMostSrcValue.setTextColor(i);
        }
        if ((j & 139) != 0) {
            TextViewBindingAdapter.setText(this.decodeMostSrcValue, str);
        }
        if ((j & 146) != 0) {
            TextViewBindingAdapter.setText(this.decodeMostThresValue, str3);
        }
    }
}
