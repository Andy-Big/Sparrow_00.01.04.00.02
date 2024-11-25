package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.busAnalyse.BusAnalyseParam;
/* loaded from: classes2.dex */
public class PopupviewBusAnalyseBindingImpl extends PopupviewBusAnalyseBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_left, 2);
        sViewsWithIds.put(R.id.guideline_right, 3);
        sViewsWithIds.put(R.id.bus_analyse_select_label, 4);
        sViewsWithIds.put(R.id.bus_analyse_divider1, 5);
        sViewsWithIds.put(R.id.bus_analyse_view, 6);
    }

    public PopupviewBusAnalyseBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private PopupviewBusAnalyseBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (View) objArr[5], (TextView) objArr[4], (TextView) objArr[1], (RecyclerView) objArr[6], (Guideline) objArr[2], (Guideline) objArr[3]);
        this.mDirtyFlags = -1L;
        this.busAnalyseSelectValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64L;
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
            setParam((BusAnalyseParam) obj);
        } else if (1032 == i) {
            setView((View) obj);
        } else if (569 != i) {
            return false;
        } else {
            setOnClickListener((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewBusAnalyseBinding
    public void setParam(BusAnalyseParam busAnalyseParam) {
        updateRegistration(1, busAnalyseParam);
        this.mParam = busAnalyseParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewBusAnalyseBinding
    public void setView(View view) {
        this.mView = view;
    }

    @Override // com.rigol.scope.databinding.PopupviewBusAnalyseBinding
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
                return false;
            }
            return onChangeParam((BusAnalyseParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAnalyseTypeListParamAnalyseSelect((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAnalyseTypeListParamAnalyseSelect(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
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

    private boolean onChangeParam(BusAnalyseParam busAnalyseParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 45) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
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
        BusAnalyseParam busAnalyseParam = this.mParam;
        String str = null;
        View.OnClickListener onClickListener = this.mOnClickListener;
        int i = ((115 & j) > 0L ? 1 : ((115 & j) == 0L ? 0 : -1));
        if (i != 0) {
            MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_analyse_type_list, busAnalyseParam != null ? busAnalyseParam.getAnalyse_select() : 0);
            updateRegistration(0, mappingObject);
            if (mappingObject != null) {
                str = mappingObject.getStr();
            }
        }
        if ((j & 72) != 0) {
            this.busAnalyseSelectValue.setOnClickListener(onClickListener);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.busAnalyseSelectValue, str);
        }
    }
}
