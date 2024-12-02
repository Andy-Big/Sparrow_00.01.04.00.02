package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.utilities.ViewUtil;
import java.util.List;

/* loaded from: classes2.dex */
public class AdapterUtilitySaveGroupBindingImpl extends AdapterUtilitySaveGroupBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.textView46, 4);
    }

    public AdapterUtilitySaveGroupBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private AdapterUtilitySaveGroupBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (CheckBox) objArr[2], (CheckBox) objArr[3], (CheckBox) objArr[1], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        this.checkBoxSaveWave.setTag(null);
        this.checkBoxSettingSave.setTag(null);
        this.checkboxScreenshot.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
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
            setParam((UtilityParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterUtilitySaveGroupBinding
    public void setParam(UtilityParam utilityParam) {
        updateRegistration(0, utilityParam);
        this.mParam = utilityParam;
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
        return onChangeParam((UtilityParam) obj, i2);
    }

    private boolean onChangeParam(UtilityParam utilityParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 773) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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
        Integer num;
        Integer num2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        UtilityParam utilityParam = this.mParam;
        int i = ((j & 7) > 0L ? 1 : ((j & 7) == 0L ? 0 : -1));
        boolean z3 = false;
        if (i != 0) {
            List<Integer> checkLengthIfNotEnoughThenAdd = ViewUtil.checkLengthIfNotEnoughThenAdd(ViewUtil.getBitsFromValue(utilityParam != null ? utilityParam.getSaveGroup() : 0), 3);
            Integer num3 = null;
            if (checkLengthIfNotEnoughThenAdd != null) {
                num3 = checkLengthIfNotEnoughThenAdd.get(2);
                num2 = checkLengthIfNotEnoughThenAdd.get(0);
                num = checkLengthIfNotEnoughThenAdd.get(1);
            } else {
                num = null;
                num2 = null;
            }
            int safeUnbox = ViewDataBinding.safeUnbox(num3);
            int safeUnbox2 = ViewDataBinding.safeUnbox(num2);
            int safeUnbox3 = ViewDataBinding.safeUnbox(num);
            z = safeUnbox == 1;
            z2 = safeUnbox2 == 1;
            if (safeUnbox3 == 1) {
                z3 = true;
            }
        } else {
            z = false;
            z2 = false;
        }
        if (i != 0) {
            CompoundButtonBindingAdapter.setChecked(this.checkBoxSaveWave, z3);
            CompoundButtonBindingAdapter.setChecked(this.checkBoxSettingSave, z);
            CompoundButtonBindingAdapter.setChecked(this.checkboxScreenshot, z2);
        }
    }
}
