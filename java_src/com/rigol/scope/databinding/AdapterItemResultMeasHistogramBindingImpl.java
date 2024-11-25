package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.views.DisableTouchEventRecyclerView;
import com.rigol.scope.views.histogram.MeasHistogramResultParam;
import com.rigol.scope.views.resultItem.ResultItemConstraintLayout;
/* loaded from: classes2.dex */
public class AdapterItemResultMeasHistogramBindingImpl extends AdapterItemResultMeasHistogramBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ResultItemConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_layout, 3);
        sViewsWithIds.put(R.id.result_list, 4);
    }

    public AdapterItemResultMeasHistogramBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private AdapterItemResultMeasHistogramBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[1], (DisableTouchEventRecyclerView) objArr[4], (TextView) objArr[2], (ConstraintLayout) objArr[3]);
        this.mDirtyFlags = -1L;
        this.icon.setTag(null);
        ResultItemConstraintLayout resultItemConstraintLayout = (ResultItemConstraintLayout) objArr[0];
        this.mboundView0 = resultItemConstraintLayout;
        resultItemConstraintLayout.setTag(null);
        this.title.setTag(null);
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
            setParam((MeasHistogramResultParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterItemResultMeasHistogramBinding
    public void setParam(MeasHistogramResultParam measHistogramResultParam) {
        updateRegistration(0, measHistogramResultParam);
        this.mParam = measHistogramResultParam;
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
        return onChangeParam((MeasHistogramResultParam) obj, i2);
    }

    private boolean onChangeParam(MeasHistogramResultParam measHistogramResultParam, int i) {
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

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MeasHistogramResultParam measHistogramResultParam = this.mParam;
        int i = ((7 & j) > 0L ? 1 : ((7 & j) == 0L ? 0 : -1));
        Drawable drawable = null;
        if (i != 0) {
            ServiceEnum.MeasType measType = measHistogramResultParam != null ? measHistogramResultParam.getMeasType() : null;
            drawable = ContextUtil.getDrawable(getRoot().getContext(), measType != null ? measType.pic1 : null);
        }
        if (i != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.icon, drawable);
        }
        if ((j & 4) != 0) {
            TextViewBindingAdapter.setText(this.title, "MHistogram");
        }
    }
}
