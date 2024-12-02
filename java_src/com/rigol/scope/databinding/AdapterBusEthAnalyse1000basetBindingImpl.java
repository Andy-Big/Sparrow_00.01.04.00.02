package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.views.busAnalyse.BusAnalyseEthParam;

/* loaded from: classes2.dex */
public class AdapterBusEthAnalyse1000basetBindingImpl extends AdapterBusEthAnalyse1000basetBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.eth_1000baset_diff_voltage_checkbox, 1);
        sViewsWithIds.put(R.id.eth_1000baset_master_jitter_checkbox, 2);
        sViewsWithIds.put(R.id.eth_1000baset_out_temp_checkbox, 3);
        sViewsWithIds.put(R.id.eth_1000baset_slave_jitter_checkbox, 4);
        sViewsWithIds.put(R.id.eth_1000baset_out_droop_checkbox, 5);
    }

    public AdapterBusEthAnalyse1000basetBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private AdapterBusEthAnalyse1000basetBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (CheckBox) objArr[1], (CheckBox) objArr[2], (CheckBox) objArr[5], (CheckBox) objArr[3], (CheckBox) objArr[4]);
        this.mDirtyFlags = -1L;
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

    @Override // com.rigol.scope.databinding.AdapterBusEthAnalyse1000basetBinding
    public void setParam(BusAnalyseEthParam busAnalyseEthParam) {
        this.mParam = busAnalyseEthParam;
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
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
