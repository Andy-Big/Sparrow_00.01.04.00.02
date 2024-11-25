package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MeasureResultParam;
import com.rigol.scope.views.DisableTouchEventRecyclerView;
import com.rigol.scope.views.resultItem.ResultItemConstraintLayout;
/* loaded from: classes2.dex */
public class AdapterItemResultMeasureBindingImpl extends AdapterItemResultMeasureBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ResultItemConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_layout, 5);
        sViewsWithIds.put(R.id.title, 6);
    }

    public AdapterItemResultMeasureBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private AdapterItemResultMeasureBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[4], (TextView) objArr[3], (ImageView) objArr[1], (DisableTouchEventRecyclerView) objArr[2], (TextView) objArr[6], (LinearLayout) objArr[5]);
        this.mDirtyFlags = -1L;
        this.arrow.setTag(null);
        this.currentResult.setTag(null);
        this.icon.setTag(null);
        ResultItemConstraintLayout resultItemConstraintLayout = (ResultItemConstraintLayout) objArr[0];
        this.mboundView0 = resultItemConstraintLayout;
        resultItemConstraintLayout.setTag(null);
        this.resultList.setTag(null);
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
            setParam((MeasureResultParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterItemResultMeasureBinding
    public void setParam(MeasureResultParam measureResultParam) {
        updateRegistration(0, measureResultParam);
        this.mParam = measureResultParam;
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
        return onChangeParam((MeasureResultParam) obj, i2);
    }

    private boolean onChangeParam(MeasureResultParam measureResultParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 528) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterItemResultMeasureBindingImpl.executeBindings():void");
    }
}
