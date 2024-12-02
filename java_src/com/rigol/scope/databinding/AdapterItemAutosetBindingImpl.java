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
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ViewUtil;

/* loaded from: classes2.dex */
public class AdapterItemAutosetBindingImpl extends AdapterItemAutosetBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public AdapterItemAutosetBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private AdapterItemAutosetBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageView) objArr[1], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.icon.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.title.setTag(null);
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
        if (352 == i) {
            setFunction((ServiceEnum.Function) obj);
        } else if (563 != i) {
            return false;
        } else {
            setObj((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterItemAutosetBinding
    public void setFunction(ServiceEnum.Function function) {
        this.mFunction = function;
    }

    @Override // com.rigol.scope.databinding.AdapterItemAutosetBinding
    public void setObj(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mObj = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(563);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                return false;
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAppShortcutObjValue((MappingObject) obj, i2);
        }
        return onChangeObj((MappingObject) obj, i2);
    }

    private boolean onChangeObj(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 638) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgAppShortcutObjValue(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 915) {
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
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mObj;
        Drawable drawable = null;
        r11 = null;
        String str2 = null;
        if ((123 & j) != 0) {
            Drawable pic = ((j & 81) == 0 || mappingObject == null) ? null : mappingObject.getPic();
            if ((j & 107) != 0) {
                MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_app_shortcut, mappingObject != null ? mappingObject.getValue() : 0);
                updateRegistration(1, mappingObject2);
                if (mappingObject2 != null) {
                    str2 = mappingObject2.getStr();
                }
            }
            str = str2;
            drawable = pic;
        } else {
            str = null;
        }
        if ((j & 81) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.icon, drawable);
        }
        if ((j & 107) != 0) {
            if (getBuildSdkInt() >= 4) {
                this.mboundView0.setContentDescription(str);
            }
            TextViewBindingAdapter.setText(this.title, str);
        }
    }
}
