package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;

/* loaded from: classes2.dex */
public class AdapterLaColorBindingImpl extends AdapterLaColorBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.la_label_en, 8);
    }

    public AdapterLaColorBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    private AdapterLaColorBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (TextView) objArr[5], (TextView) objArr[8], (TextView) objArr[4], (TextView) objArr[3], (TextView) objArr[7], (TextView) objArr[2], (TextView) objArr[6], (SwitchButton) objArr[1]);
        this.mDirtyFlags = -1L;
        this.laLabelEdit.setTag(null);
        this.laLabelText.setTag(null);
        this.laSourceGroup.setTag(null);
        this.laSourceGroup2.setTag(null);
        this.laSourceGroupText.setTag(null);
        this.laSourceGroupText2.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.showLabelSwitch.setTag(null);
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
        if (600 == i) {
            setParma((LaParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterLaColorBinding
    public void setParma(LaParam laParam) {
        updateRegistration(2, laParam);
        this.mParma = laParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(600);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return onChangeParma((LaParam) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaCurrentChanParmaLaLabelViewSelectChan((MappingObject) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaLabelViewSelectParmaLaLabelViewSelect((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaLabelViewSelectParmaLaLabelViewSelect(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaCurrentChanParmaLaLabelViewSelectChan(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParma(LaParam laParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 464) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 463) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 434) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 462) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007d A[ADDED_TO_REGION] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        boolean z;
        String str;
        String str2;
        String str3;
        float f;
        String str4;
        float f2;
        String str5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        LaParam laParam = this.mParma;
        String str6 = null;
        if ((255 & j) != 0) {
            if ((j & 197) != 0) {
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_la_label_view_select, laParam != null ? laParam.getLa_label_view_select() : 0);
                updateRegistration(0, mappingObject);
                if (mappingObject != null) {
                    str4 = mappingObject.getStr();
                    if ((j & 140) == 0) {
                        z = laParam != null ? laParam.getLa_labels_en() : false;
                        f2 = ContextUtil.getAlpha(z);
                    } else {
                        z = false;
                        f2 = 0.0f;
                    }
                    if ((j & 150) != 0) {
                        MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_la_current_chan, laParam != null ? laParam.getLa_label_view_select_chan() : 0);
                        updateRegistration(1, mappingObject2);
                        if (mappingObject2 != null) {
                            str5 = mappingObject2.getStr();
                            if ((j & 164) != 0 && laParam != null) {
                                str6 = laParam.getInputLabel();
                            }
                            str3 = str4;
                            str = str6;
                            str2 = str5;
                            f = f2;
                        }
                    }
                    str5 = null;
                    if ((j & 164) != 0) {
                        str6 = laParam.getInputLabel();
                    }
                    str3 = str4;
                    str = str6;
                    str2 = str5;
                    f = f2;
                }
            }
            str4 = null;
            if ((j & 140) == 0) {
            }
            if ((j & 150) != 0) {
            }
            str5 = null;
            if ((j & 164) != 0) {
            }
            str3 = str4;
            str = str6;
            str2 = str5;
            f = f2;
        } else {
            z = false;
            str = null;
            str2 = null;
            str3 = null;
            f = 0.0f;
        }
        if ((140 & j) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.laLabelEdit.setAlpha(f);
                this.laLabelText.setAlpha(f);
                this.laSourceGroup.setAlpha(f);
                this.laSourceGroup2.setAlpha(f);
                this.laSourceGroupText.setAlpha(f);
                this.laSourceGroupText2.setAlpha(f);
            }
            this.laLabelEdit.setEnabled(z);
            this.laLabelText.setEnabled(z);
            this.laSourceGroup.setEnabled(z);
            this.laSourceGroup2.setEnabled(z);
            this.laSourceGroupText.setEnabled(z);
            this.laSourceGroupText2.setEnabled(z);
            CompoundButtonBindingAdapter.setChecked(this.showLabelSwitch, z);
        }
        if ((164 & j) != 0) {
            TextViewBindingAdapter.setText(this.laLabelEdit, str);
        }
        if ((150 & j) != 0) {
            TextViewBindingAdapter.setText(this.laSourceGroup, str2);
        }
        if ((j & 197) != 0) {
            TextViewBindingAdapter.setText(this.laSourceGroup2, str3);
        }
    }
}
