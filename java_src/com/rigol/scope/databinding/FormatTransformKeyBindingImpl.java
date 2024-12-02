package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;

/* loaded from: classes2.dex */
public class FormatTransformKeyBindingImpl extends FormatTransformKeyBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.type_format_value, 5);
        sViewsWithIds.put(R.id.key_right, 6);
        sViewsWithIds.put(R.id.key_left, 7);
        sViewsWithIds.put(R.id.key_a, 8);
        sViewsWithIds.put(R.id.key_b, 9);
        sViewsWithIds.put(R.id.key_c, 10);
        sViewsWithIds.put(R.id.key_d, 11);
        sViewsWithIds.put(R.id.key_e, 12);
        sViewsWithIds.put(R.id.key_f, 13);
        sViewsWithIds.put(R.id.key_delete, 14);
        sViewsWithIds.put(R.id.key_clear, 15);
        sViewsWithIds.put(R.id.key_all, 16);
        sViewsWithIds.put(R.id.key_ok, 17);
        sViewsWithIds.put(R.id.key_zero, 18);
        sViewsWithIds.put(R.id.key_x, 19);
        sViewsWithIds.put(R.id.key_four, 20);
        sViewsWithIds.put(R.id.key_three, 21);
        sViewsWithIds.put(R.id.key_two, 22);
        sViewsWithIds.put(R.id.key_one, 23);
        sViewsWithIds.put(R.id.key_six, 24);
        sViewsWithIds.put(R.id.key_five, 25);
        sViewsWithIds.put(R.id.key_seven, 26);
        sViewsWithIds.put(R.id.key_eigth, 27);
        sViewsWithIds.put(R.id.trigger_layout, 28);
        sViewsWithIds.put(R.id.binary_value, 29);
        sViewsWithIds.put(R.id.trigger_type_label, 30);
        sViewsWithIds.put(R.id.key_nine, 31);
    }

    public FormatTransformKeyBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 32, sIncludes, sViewsWithIds));
    }

    private FormatTransformKeyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (EditText) objArr[29], (RadioButton) objArr[3], (RadioButton) objArr[2], (Button) objArr[8], (Button) objArr[16], (Button) objArr[9], (Button) objArr[10], (Button) objArr[15], (Button) objArr[11], (ImageButton) objArr[14], (Button) objArr[12], (Button) objArr[27], (Button) objArr[13], (Button) objArr[25], (Button) objArr[20], (ImageButton) objArr[7], (Button) objArr[31], (Button) objArr[17], (Button) objArr[23], (ImageButton) objArr[6], (Button) objArr[26], (Button) objArr[24], (Button) objArr[21], (Button) objArr[22], (Button) objArr[19], (Button) objArr[18], (ConstraintLayout) objArr[28], (TextView) objArr[30], (TextView) objArr[4], (TextView) objArr[1], (EditText) objArr[5]);
        this.mDirtyFlags = -1L;
        this.formatBin.setTag(null);
        this.formatHex.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.typeBinary.setTag(null);
        this.typeFormat.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32L;
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
        if (370 == i) {
            setHexMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (89 != i) {
            return false;
        } else {
            setBinMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.FormatTransformKeyBinding
    public void setHexMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mHexMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(370);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.FormatTransformKeyBinding
    public void setParam(TriggerParam triggerParam) {
        this.mParam = triggerParam;
    }

    @Override // com.rigol.scope.databinding.FormatTransformKeyBinding
    public void setBinMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mBinMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(89);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeBinMapping((MappingObject) obj, i2);
            }
            return onChangeParam((TriggerParam) obj, i2);
        }
        return onChangeHexMapping((MappingObject) obj, i2);
    }

    private boolean onChangeHexMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeBinMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
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

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mHexMapping;
        MappingObject mappingObject2 = this.mBinMapping;
        int i = ((41 & j) > 0L ? 1 : ((41 & j) == 0L ? 0 : -1));
        String str = null;
        String str2 = (i == 0 || mappingObject == null) ? null : mappingObject.getStr();
        int i2 = ((j & 52) > 0L ? 1 : ((j & 52) == 0L ? 0 : -1));
        if (i2 != 0 && mappingObject2 != null) {
            str = mappingObject2.getStr();
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.formatBin, str);
            TextViewBindingAdapter.setText(this.typeBinary, str);
            TextViewBindingAdapter.setText(this.typeFormat, str);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.formatHex, str2);
        }
    }
}
