package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageSaveParam;

/* loaded from: classes2.dex */
public class AdapterUtilitySaveWaveBindingImpl extends AdapterUtilitySaveWaveBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.textView35, 6);
        sViewsWithIds.put(R.id.radiogroup_dataSource, 7);
        sViewsWithIds.put(R.id.radiogroup_format, 8);
        sViewsWithIds.put(R.id.tv_savechannel, 9);
        sViewsWithIds.put(R.id.savechannel_layout, 10);
        sViewsWithIds.put(R.id.checkBox_ch1, 11);
        sViewsWithIds.put(R.id.checkBox_ch2, 12);
        sViewsWithIds.put(R.id.checkBox_ch3, 13);
        sViewsWithIds.put(R.id.checkBox_ch4, 14);
        sViewsWithIds.put(R.id.tv_format, 15);
    }

    public AdapterUtilitySaveWaveBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private AdapterUtilitySaveWaveBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (CheckBox) objArr[11], (CheckBox) objArr[12], (CheckBox) objArr[13], (CheckBox) objArr[14], (RadioButton) objArr[3], (RadioButton) objArr[4], (RadioButton) objArr[2], (RadioButton) objArr[1], (RadioButton) objArr[5], (RadioGroup) objArr[7], (RadioGroup) objArr[8], (ConstraintLayout) objArr[10], (TextView) objArr[6], (TextView) objArr[15], (TextView) objArr[9]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.radioButtonBin.setTag(null);
        this.radioButtonCsv.setTag(null);
        this.radioButtonMemory.setTag(null);
        this.radioButtonScreen.setTag(null);
        this.radioButtonWfm.setTag(null);
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
        if (594 == i) {
            setParam((StorageSaveParam) obj);
        } else if (18 == i) {
            setScreenMapping((MappingObject) obj);
        } else if (12 != i) {
            return false;
        } else {
            setMemoryMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterUtilitySaveWaveBinding
    public void setParam(StorageSaveParam storageSaveParam) {
        updateRegistration(0, storageSaveParam);
        this.mParam = storageSaveParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterUtilitySaveWaveBinding
    public void setScreenMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mScreenMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterUtilitySaveWaveBinding
    public void setMemoryMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mMemoryMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(12);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeMemoryMapping((MappingObject) obj, i2);
            }
            return onChangeScreenMapping((MappingObject) obj, i2);
        }
        return onChangeParam((StorageSaveParam) obj, i2);
    }

    private boolean onChangeParam(StorageSaveParam storageSaveParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 1035) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 1036) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeScreenMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeMemoryMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        StorageSaveParam storageSaveParam = this.mParam;
        MappingObject mappingObject = this.mScreenMapping;
        MappingObject mappingObject2 = this.mMemoryMapping;
        if ((153 & j) != 0) {
            if ((j & 145) != 0) {
                int waveFileType = storageSaveParam != null ? storageSaveParam.getWaveFileType() : 0;
                z7 = waveFileType == ServiceEnum.enFileType.FILETYPE_BIN.value1;
                z6 = waveFileType == ServiceEnum.enFileType.FILETYPE_WFM.value1;
                z2 = waveFileType == ServiceEnum.enFileType.FILETYPE_CSV.value1;
            } else {
                z2 = false;
                z6 = false;
                z7 = false;
            }
            if ((j & 137) != 0) {
                int waveDepth = storageSaveParam != null ? storageSaveParam.getWaveDepth() : 0;
                z3 = waveDepth == 1;
                boolean z8 = waveDepth == 0;
                z = z6;
                z5 = z7;
                z4 = z8;
            } else {
                z = z6;
                z5 = z7;
                z3 = false;
                z4 = false;
            }
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
        }
        int i = ((162 & j) > 0L ? 1 : ((162 & j) == 0L ? 0 : -1));
        String str = null;
        String str2 = (i == 0 || mappingObject == null) ? null : mappingObject.getStr();
        int i2 = ((j & 196) > 0L ? 1 : ((j & 196) == 0L ? 0 : -1));
        if (i2 != 0 && mappingObject2 != null) {
            str = mappingObject2.getStr();
        }
        if ((j & 145) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.radioButtonBin, z5);
            CompoundButtonBindingAdapter.setChecked(this.radioButtonCsv, z2);
            CompoundButtonBindingAdapter.setChecked(this.radioButtonWfm, z);
        }
        if ((j & 137) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.radioButtonMemory, z3);
            CompoundButtonBindingAdapter.setChecked(this.radioButtonScreen, z4);
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.radioButtonMemory, str);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.radioButtonScreen, str2);
        }
    }
}
