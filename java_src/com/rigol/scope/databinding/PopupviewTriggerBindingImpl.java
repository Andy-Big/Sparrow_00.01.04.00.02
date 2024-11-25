package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
/* loaded from: classes2.dex */
public class PopupviewTriggerBindingImpl extends PopupviewTriggerBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.trigger_layout, 5);
        sViewsWithIds.put(R.id.trigger_view, 6);
        sViewsWithIds.put(R.id.guideline_left, 7);
        sViewsWithIds.put(R.id.guideline_center, 8);
        sViewsWithIds.put(R.id.guideline_right, 9);
        sViewsWithIds.put(R.id.trigger_type_label, 10);
        sViewsWithIds.put(R.id.trigger_mode_label, 11);
        sViewsWithIds.put(R.id.mode_radio_group, 12);
        sViewsWithIds.put(R.id.force_trigger, 13);
        sViewsWithIds.put(R.id.vertical_setting, 14);
    }

    public PopupviewTriggerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private PopupviewTriggerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (RadioButton) objArr[2], (Button) objArr[13], (Guideline) objArr[8], (Guideline) objArr[7], (Guideline) objArr[9], (RadioGroup) objArr[12], (RadioButton) objArr[3], (RadioButton) objArr[4], (ConstraintLayout) objArr[5], (TextView) objArr[11], (TextView) objArr[1], (TextView) objArr[10], (RecyclerView) objArr[6], (Button) objArr[14]);
        this.mDirtyFlags = -1L;
        this.autoRadioButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.normalRadioButton.setTag(null);
        this.singleRadioButton.setTag(null);
        this.triggerType.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
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
        if (918 == i) {
            setSweepSingleMapping((MappingObject) obj);
        } else if (917 == i) {
            setSweepNormalMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((TriggerParam) obj);
        } else if (916 == i) {
            setSweepAutoMapping((MappingObject) obj);
        } else if (179 != i) {
            return false;
        } else {
            setClickListener((View.OnClickListener) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewTriggerBinding
    public void setSweepSingleMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mSweepSingleMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(918);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewTriggerBinding
    public void setSweepNormalMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mSweepNormalMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(917);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewTriggerBinding
    public void setParam(TriggerParam triggerParam) {
        updateRegistration(2, triggerParam);
        this.mParam = triggerParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewTriggerBinding
    public void setSweepAutoMapping(MappingObject mappingObject) {
        updateRegistration(3, mappingObject);
        this.mSweepAutoMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(916);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.PopupviewTriggerBinding
    public void setClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return false;
                        }
                        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerTypeParamTriggerModeValue1((MappingObject) obj, i2);
                    }
                    return onChangeSweepAutoMapping((MappingObject) obj, i2);
                }
                return onChangeParam((TriggerParam) obj, i2);
            }
            return onChangeSweepNormalMapping((MappingObject) obj, i2);
        }
        return onChangeSweepSingleMapping((MappingObject) obj, i2);
    }

    private boolean onChangeSweepSingleMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
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

    private boolean onChangeSweepNormalMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(TriggerParam triggerParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 945) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 554) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeSweepAutoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgTriggerTypeParamTriggerModeValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.PopupviewTriggerBindingImpl.executeBindings():void");
    }
}
