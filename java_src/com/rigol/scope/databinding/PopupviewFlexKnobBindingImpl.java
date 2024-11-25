package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.FlexKnobParam;
import com.rigol.scope.data.MappingObject;
/* loaded from: classes2.dex */
public class PopupviewFlexKnobBindingImpl extends PopupviewFlexKnobBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_layout, 12);
        sViewsWithIds.put(R.id.guideline_left, 13);
        sViewsWithIds.put(R.id.guideline_right, 14);
        sViewsWithIds.put(R.id.guideline_center, 15);
        sViewsWithIds.put(R.id.direction_type, 16);
        sViewsWithIds.put(R.id.direction_radio_group, 17);
    }

    public PopupviewFlexKnobBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 18, sIncludes, sViewsWithIds));
    }

    private PopupviewFlexKnobBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (RadioButton) objArr[1], (RadioGroup) objArr[17], (TextView) objArr[16], (Guideline) objArr[15], (Guideline) objArr[13], (Guideline) objArr[14], (RadioButton) objArr[2], (ImageView) objArr[6], (RecyclerView) objArr[11], (View) objArr[12], (TextView) objArr[7], (TextView) objArr[9], (TextView) objArr[8], (TextView) objArr[10], (TextView) objArr[3], (TextView) objArr[4], (View) objArr[5]);
        this.mDirtyFlags = -1L;
        this.autoRadioButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.offRadioButton.setTag(null);
        this.pic.setTag(null);
        this.recyclerView.setTag(null);
        this.tvAHint.setTag(null);
        this.tvAHintContent.setTag(null);
        this.tvBHint.setTag(null);
        this.tvBHintContent.setTag(null);
        this.tvHint.setTag(null);
        this.tvHintContent.setTag(null);
        this.viewTop.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128L;
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
        if (15 == i) {
            setPopupviewFlexKnobBinding((FlexKnobParam) obj);
        } else if (594 == i) {
            setParam((FlexKnobParam) obj);
        } else if (177 != i) {
            return false;
        } else {
            setCheckedChangeListener((CompoundButton.OnCheckedChangeListener) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewFlexKnobBinding
    public void setPopupviewFlexKnobBinding(FlexKnobParam flexKnobParam) {
        this.mPopupviewFlexKnobBinding = flexKnobParam;
    }

    @Override // com.rigol.scope.databinding.PopupviewFlexKnobBinding
    public void setParam(FlexKnobParam flexKnobParam) {
        updateRegistration(1, flexKnobParam);
        this.mParam = flexKnobParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewFlexKnobBinding
    public void setCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mCheckedChangeListener = onCheckedChangeListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(177);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeParamCurrentMappingObject((MappingObject) obj, i2);
            }
            return onChangeParam((FlexKnobParam) obj, i2);
        }
        return onChangePopupviewFlexKnobBinding((FlexKnobParam) obj, i2);
    }

    private boolean onChangePopupviewFlexKnobBinding(FlexKnobParam flexKnobParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParam(FlexKnobParam flexKnobParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 176) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 196) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParamCurrentMappingObject(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 638) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00be  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewFlexKnobBindingImpl.executeBindings():void");
    }
}
