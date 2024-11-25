package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.busAnalyse.BusAnalyseEthParam;
/* loaded from: classes2.dex */
public class AdapterBusEthAnalyseBindingImpl extends AdapterBusEthAnalyseBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 5);
        sViewsWithIds.put(R.id.guideline_center, 6);
        sViewsWithIds.put(R.id.guideline_right, 7);
        sViewsWithIds.put(R.id.bus_analyse_eth_type_label, 8);
        sViewsWithIds.put(R.id.bus_analyse_eth_source_label, 9);
        sViewsWithIds.put(R.id.bus_eth_analyse_view, 10);
        sViewsWithIds.put(R.id.bus_analyse_eth_divider1, 11);
        sViewsWithIds.put(R.id.bus_analyse_eth_divider2, 12);
    }

    public AdapterBusEthAnalyseBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private AdapterBusEthAnalyseBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (Button) objArr[3], (ConstraintLayout) objArr[0], (View) objArr[11], (View) objArr[12], (TextView) objArr[9], (TextView) objArr[2], (Button) objArr[4], (TextView) objArr[8], (TextView) objArr[1], (RecyclerView) objArr[10], (Guideline) objArr[6], (Guideline) objArr[5], (Guideline) objArr[7]);
        this.mDirtyFlags = -1L;
        this.busAnalyseEthAutoSetButton.setTag(null);
        this.busAnalyseEthCommonLayout.setTag(null);
        this.busAnalyseEthSourceValue.setTag(null);
        this.busAnalyseEthTestButton.setTag(null);
        this.busAnalyseEthTypeValue.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256L;
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
            setParam((BusAnalyseEthParam) obj);
        } else if (569 != i) {
            return false;
        } else {
            setOnClickListener((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterBusEthAnalyseBinding
    public void setParam(BusAnalyseEthParam busAnalyseEthParam) {
        updateRegistration(0, busAnalyseEthParam);
        this.mParam = busAnalyseEthParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterBusEthAnalyseBinding
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(569);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgEthAnalyseSignalParamEthType((MappingObject) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgEthAnalyseSrcParamEthSource((MappingObject) obj, i2);
        }
        return onChangeParam((BusAnalyseEthParam) obj, i2);
    }

    private boolean onChangeParam(BusAnalyseEthParam busAnalyseEthParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 283) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 282) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgEthAnalyseSrcParamEthSource(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgEthAnalyseSignalParamEthType(MappingObject mappingObject, int i) {
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

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        int i;
        int i2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        BusAnalyseEthParam busAnalyseEthParam = this.mParam;
        View.OnClickListener onClickListener = this.mOnClickListener;
        if ((503 & j) != 0) {
            if ((j & 355) != 0) {
                int eth_source = busAnalyseEthParam != null ? busAnalyseEthParam.getEth_source() : 0;
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_eth_analyse_src, eth_source);
                updateRegistration(1, mappingObject);
                str2 = mappingObject != null ? mappingObject.getStr() : null;
                i2 = (j & 289) != 0 ? ColorUtil.getColor(getRoot().getContext(), ServiceEnum.getChanFromValue1(eth_source)) : 0;
            } else {
                i2 = 0;
                str2 = null;
            }
            if ((j & 405) != 0) {
                MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_eth_analyse_signal, busAnalyseEthParam != null ? busAnalyseEthParam.getEth_type() : 0);
                updateRegistration(2, mappingObject2);
                if (mappingObject2 != null) {
                    str = mappingObject2.getStr();
                    i = i2;
                }
            }
            i = i2;
            str = null;
        } else {
            str = null;
            str2 = null;
            i = 0;
        }
        if ((j & 264) != 0) {
            this.busAnalyseEthAutoSetButton.setOnClickListener(onClickListener);
            this.busAnalyseEthSourceValue.setOnClickListener(onClickListener);
            this.busAnalyseEthTestButton.setOnClickListener(onClickListener);
            this.busAnalyseEthTypeValue.setOnClickListener(onClickListener);
        }
        if ((j & 355) != 0) {
            TextViewBindingAdapter.setText(this.busAnalyseEthSourceValue, str2);
        }
        if ((j & 289) != 0) {
            this.busAnalyseEthSourceValue.setTextColor(i);
        }
        if ((j & 405) != 0) {
            TextViewBindingAdapter.setText(this.busAnalyseEthTypeValue, str);
        }
    }
}
