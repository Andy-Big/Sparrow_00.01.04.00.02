package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.FftParam;
import com.rigol.scope.utilities.ViewUtil;
import java.util.List;
/* loaded from: classes2.dex */
public class AdapterRtsaMarkerBindingImpl extends AdapterRtsaMarkerBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.add_all_btn, 9);
        sViewsWithIds.put(R.id.remove_all_btn, 10);
    }

    public AdapterRtsaMarkerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private AdapterRtsaMarkerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (Button) objArr[9], (CheckBox) objArr[1], (CheckBox) objArr[2], (CheckBox) objArr[3], (CheckBox) objArr[4], (CheckBox) objArr[5], (CheckBox) objArr[6], (CheckBox) objArr[7], (CheckBox) objArr[8], (Button) objArr[10]);
        this.mDirtyFlags = -1L;
        this.checkBoxMarker1.setTag(null);
        this.checkBoxMarker2.setTag(null);
        this.checkBoxMarker3.setTag(null);
        this.checkBoxMarker4.setTag(null);
        this.checkBoxMarker5.setTag(null);
        this.checkBoxMarker6.setTag(null);
        this.checkBoxMarker7.setTag(null);
        this.checkBoxMarker8.setTag(null);
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
            setParam((FftParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterRtsaMarkerBinding
    public void setParam(FftParam fftParam) {
        updateRegistration(0, fftParam);
        this.mParam = fftParam;
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
        return onChangeParam((FftParam) obj, i2);
    }

    private boolean onChangeParam(FftParam fftParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 520) {
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
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Integer num7;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        FftParam fftParam = this.mParam;
        int i = ((j & 7) > 0L ? 1 : ((j & 7) == 0L ? 0 : -1));
        if (i != 0) {
            List<Integer> checkLengthIfNotEnoughThenAdd = ViewUtil.checkLengthIfNotEnoughThenAdd(ViewUtil.getBitsFromValue(fftParam != null ? fftParam.getMarkersState() : 0), 8);
            Integer num8 = null;
            if (checkLengthIfNotEnoughThenAdd != null) {
                num8 = checkLengthIfNotEnoughThenAdd.get(7);
                num2 = checkLengthIfNotEnoughThenAdd.get(1);
                num3 = checkLengthIfNotEnoughThenAdd.get(0);
                num4 = checkLengthIfNotEnoughThenAdd.get(4);
                num5 = checkLengthIfNotEnoughThenAdd.get(3);
                num6 = checkLengthIfNotEnoughThenAdd.get(2);
                num7 = checkLengthIfNotEnoughThenAdd.get(6);
                num = checkLengthIfNotEnoughThenAdd.get(5);
            } else {
                num = null;
                num2 = null;
                num3 = null;
                num4 = null;
                num5 = null;
                num6 = null;
                num7 = null;
            }
            int safeUnbox = ViewDataBinding.safeUnbox(num8);
            int safeUnbox2 = ViewDataBinding.safeUnbox(num2);
            int safeUnbox3 = ViewDataBinding.safeUnbox(num3);
            int safeUnbox4 = ViewDataBinding.safeUnbox(num4);
            int safeUnbox5 = ViewDataBinding.safeUnbox(num5);
            int safeUnbox6 = ViewDataBinding.safeUnbox(num6);
            int safeUnbox7 = ViewDataBinding.safeUnbox(num7);
            int safeUnbox8 = ViewDataBinding.safeUnbox(num);
            z2 = safeUnbox == 1;
            z3 = safeUnbox2 == 1;
            boolean z8 = safeUnbox3 == 1;
            z4 = safeUnbox4 == 1;
            z5 = safeUnbox5 == 1;
            z6 = safeUnbox6 == 1;
            z7 = safeUnbox7 == 1;
            z = safeUnbox8 == 1;
            r1 = z8;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
        }
        if (i != 0) {
            CompoundButtonBindingAdapter.setChecked(this.checkBoxMarker1, r1);
            CompoundButtonBindingAdapter.setChecked(this.checkBoxMarker2, z3);
            CompoundButtonBindingAdapter.setChecked(this.checkBoxMarker3, z6);
            CompoundButtonBindingAdapter.setChecked(this.checkBoxMarker4, z5);
            CompoundButtonBindingAdapter.setChecked(this.checkBoxMarker5, z4);
            CompoundButtonBindingAdapter.setChecked(this.checkBoxMarker6, z);
            CompoundButtonBindingAdapter.setChecked(this.checkBoxMarker7, z7);
            CompoundButtonBindingAdapter.setChecked(this.checkBoxMarker8, z2);
        }
    }
}
