package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import com.rigol.scope.views.busAnalyse.BusAnalyseEthParam;
/* loaded from: classes2.dex */
public class AdapterBusEthAnalyse10basetBindingImpl extends AdapterBusEthAnalyse10basetBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public AdapterBusEthAnalyse10basetBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private AdapterBusEthAnalyse10basetBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (CheckBox) objArr[5], (CheckBox) objArr[6], (CheckBox) objArr[4], (CheckBox) objArr[1], (CheckBox) objArr[3], (CheckBox) objArr[2]);
        this.mDirtyFlags = -1L;
        this.busAnalyseEthDifferentVoltageCheckbox.setTag(null);
        this.busAnalyseEthHarmonicsCheckbox.setTag(null);
        this.busAnalyseEthJitterCheckbox.setTag(null);
        this.busAnalyseEthLinkPluseCheckbox.setTag(null);
        this.busAnalyseEthMauCheckbox.setTag(null);
        this.busAnalyseEthTpidlCheckbox.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
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

    @Override // com.rigol.scope.databinding.AdapterBusEthAnalyse10basetBinding
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
            return false;
        }
        return onChangeParam((BusAnalyseEthParam) obj, i2);
    }

    private boolean onChangeParam(BusAnalyseEthParam busAnalyseEthParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        BusAnalyseEthParam busAnalyseEthParam = this.mParam;
        int i = ((j & 3) > 0L ? 1 : ((j & 3) == 0L ? 0 : -1));
        boolean z6 = false;
        if (i == 0 || busAnalyseEthParam == null) {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
        } else {
            boolean isEth10_mau = busAnalyseEthParam.isEth10_mau();
            boolean isEth10_different_voltage = busAnalyseEthParam.isEth10_different_voltage();
            z2 = busAnalyseEthParam.isEth10_jitter();
            z4 = busAnalyseEthParam.isEth10_harmonics();
            z5 = busAnalyseEthParam.isEth10_link_pluse();
            z3 = busAnalyseEthParam.isEth10_tp_idl();
            z = isEth10_mau;
            z6 = isEth10_different_voltage;
        }
        if (i != 0) {
            CompoundButtonBindingAdapter.setChecked(this.busAnalyseEthDifferentVoltageCheckbox, z6);
            CompoundButtonBindingAdapter.setChecked(this.busAnalyseEthHarmonicsCheckbox, z4);
            CompoundButtonBindingAdapter.setChecked(this.busAnalyseEthJitterCheckbox, z2);
            CompoundButtonBindingAdapter.setChecked(this.busAnalyseEthLinkPluseCheckbox, z5);
            CompoundButtonBindingAdapter.setChecked(this.busAnalyseEthMauCheckbox, z);
            CompoundButtonBindingAdapter.setChecked(this.busAnalyseEthTpidlCheckbox, z3);
        }
    }
}
