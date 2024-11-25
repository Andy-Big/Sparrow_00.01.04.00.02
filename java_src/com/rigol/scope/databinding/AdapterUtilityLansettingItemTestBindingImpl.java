package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class AdapterUtilityLansettingItemTestBindingImpl extends AdapterUtilityLansettingItemTestBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.configuration, 1);
        sViewsWithIds.put(R.id.view5, 2);
        sViewsWithIds.put(R.id.ipconfig_layout, 3);
        sViewsWithIds.put(R.id.ip_dhcp, 4);
        sViewsWithIds.put(R.id.ip_auto, 5);
        sViewsWithIds.put(R.id.ip_static, 6);
        sViewsWithIds.put(R.id.ip_layout, 7);
        sViewsWithIds.put(R.id.textView51, 8);
        sViewsWithIds.put(R.id.edtipAddress, 9);
        sViewsWithIds.put(R.id.submask_layout, 10);
        sViewsWithIds.put(R.id.textView38, 11);
        sViewsWithIds.put(R.id.edtsubMask, 12);
        sViewsWithIds.put(R.id.gateway_layout, 13);
        sViewsWithIds.put(R.id.textView40, 14);
        sViewsWithIds.put(R.id.edtdefaultGateway, 15);
        sViewsWithIds.put(R.id.constraintLayout25, 16);
        sViewsWithIds.put(R.id.dns_layout, 17);
        sViewsWithIds.put(R.id.edtdns, 18);
        sViewsWithIds.put(R.id.view, 19);
        sViewsWithIds.put(R.id.mDnslayout, 20);
        sViewsWithIds.put(R.id.switch_mdns, 21);
        sViewsWithIds.put(R.id.mdns, 22);
        sViewsWithIds.put(R.id.hostNamelayout, 23);
        sViewsWithIds.put(R.id.textView53, 24);
        sViewsWithIds.put(R.id.edt_hostName_value, 25);
        sViewsWithIds.put(R.id.gpiblayout, 26);
        sViewsWithIds.put(R.id.textView54, 27);
        sViewsWithIds.put(R.id.tvgpib, 28);
        sViewsWithIds.put(R.id.view2, 29);
        sViewsWithIds.put(R.id.visa_layout, 30);
        sViewsWithIds.put(R.id.textView49, 31);
        sViewsWithIds.put(R.id.tvvisaAddress, 32);
        sViewsWithIds.put(R.id.mac_layout, 33);
        sViewsWithIds.put(R.id.textView47, 34);
        sViewsWithIds.put(R.id.tvmacAddress, 35);
        sViewsWithIds.put(R.id.constraintLayout4, 36);
        sViewsWithIds.put(R.id.textView43, 37);
        sViewsWithIds.put(R.id.tvnetState, 38);
    }

    public AdapterUtilityLansettingItemTestBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 39, sIncludes, sViewsWithIds));
    }

    private AdapterUtilityLansettingItemTestBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[1], (ConstraintLayout) objArr[16], (ConstraintLayout) objArr[36], (TextView) objArr[17], (EditText) objArr[25], (EditText) objArr[15], (EditText) objArr[18], (EditText) objArr[9], (EditText) objArr[12], (ConstraintLayout) objArr[13], (ConstraintLayout) objArr[26], (ConstraintLayout) objArr[23], (CheckBox) objArr[5], (CheckBox) objArr[4], (ConstraintLayout) objArr[7], (CheckBox) objArr[6], (ConstraintLayout) objArr[3], (ConstraintLayout) objArr[20], (ConstraintLayout) objArr[33], (TextView) objArr[22], (ConstraintLayout) objArr[10], (SwitchButton) objArr[21], (TextView) objArr[11], (TextView) objArr[14], (TextView) objArr[37], (TextView) objArr[34], (TextView) objArr[31], (TextView) objArr[8], (TextView) objArr[24], (TextView) objArr[27], (EditText) objArr[28], (TextView) objArr[35], (TextView) objArr[38], (TextView) objArr[32], (View) objArr[19], (View) objArr[29], (View) objArr[2], (ConstraintLayout) objArr[30]);
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
            this.mDirtyFlags = 1L;
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
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
