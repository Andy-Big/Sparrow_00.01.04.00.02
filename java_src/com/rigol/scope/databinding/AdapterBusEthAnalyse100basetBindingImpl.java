package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.busAnalyse.BusAnalyseEthParam;
/* loaded from: classes2.dex */
public class AdapterBusEthAnalyse100basetBindingImpl extends AdapterBusEthAnalyse100basetBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.eth_analyse_1000baset_diff_voltage_checkbox, 3);
        sViewsWithIds.put(R.id.eth_analyse_100baset_sigas_checkbox, 4);
        sViewsWithIds.put(R.id.eth_analyse_100baset_rftime_checkbox, 5);
        sViewsWithIds.put(R.id.eth_analyse_100baset_rfsymmetry_checkbox, 6);
        sViewsWithIds.put(R.id.eth_analyse_100baset_overshoot_checkbox, 7);
        sViewsWithIds.put(R.id.eth_analyse_100baset_dutycycle_checkbox, 8);
        sViewsWithIds.put(R.id.eth_analyse_100baset_eye_checkbox, 9);
        sViewsWithIds.put(R.id.eth_analyse_100baset_jitter_checkbox, 10);
        sViewsWithIds.put(R.id.bus_analyse_divider1, 11);
        sViewsWithIds.put(R.id.eth_analyse_100baset_clk_label, 12);
    }

    public AdapterBusEthAnalyse100basetBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private AdapterBusEthAnalyse100basetBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (View) objArr[11], (CheckBox) objArr[3], (TextView) objArr[12], (CheckBox) objArr[1], (TextView) objArr[2], (CheckBox) objArr[8], (CheckBox) objArr[9], (CheckBox) objArr[10], (CheckBox) objArr[7], (CheckBox) objArr[6], (CheckBox) objArr[5], (CheckBox) objArr[4]);
        this.mDirtyFlags = -1L;
        this.ethAnalyse100basetClkTriggerCheckbox.setTag(null);
        this.ethAnalyse100basetClkValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32L;
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
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterBusEthAnalyse100basetBinding
    public void setParam(BusAnalyseEthParam busAnalyseEthParam) {
        updateRegistration(0, busAnalyseEthParam);
        this.mParam = busAnalyseEthParam;
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
                return false;
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgEthAnalyse100basetClkParamEth100Clk((MappingObject) obj, i2);
        }
        return onChangeParam((BusAnalyseEthParam) obj, i2);
    }

    private boolean onChangeParam(BusAnalyseEthParam busAnalyseEthParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 281) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 280) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgEthAnalyse100basetClkParamEth100Clk(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        BusAnalyseEthParam busAnalyseEthParam = this.mParam;
        boolean z = false;
        if ((63 & j) != 0) {
            if ((j & 59) != 0) {
                int eth100_clk = busAnalyseEthParam != null ? busAnalyseEthParam.getEth100_clk() : 0;
                int color = (j & 41) != 0 ? ColorUtil.getColor(getRoot().getContext(), ServiceEnum.getChanFromValue1(eth100_clk)) : 0;
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_eth_analyse_100baset_clk, eth100_clk);
                updateRegistration(1, mappingObject);
                if (mappingObject != null) {
                    String str2 = mappingObject.getStr();
                    i = color;
                    str = str2;
                    if ((j & 37) != 0 && busAnalyseEthParam != null) {
                        z = busAnalyseEthParam.isEth100_clk_trigger();
                    }
                } else {
                    i = color;
                }
            } else {
                i = 0;
            }
            str = null;
            if ((j & 37) != 0) {
                z = busAnalyseEthParam.isEth100_clk_trigger();
            }
        } else {
            i = 0;
            str = null;
        }
        if ((37 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.ethAnalyse100basetClkTriggerCheckbox, z);
        }
        if ((59 & j) != 0) {
            TextViewBindingAdapter.setText(this.ethAnalyse100basetClkValue, str);
        }
        if ((j & 41) != 0) {
            this.ethAnalyse100basetClkValue.setTextColor(i);
        }
    }
}
