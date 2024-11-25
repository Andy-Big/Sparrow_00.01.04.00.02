package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.BaseProperty;
import com.rigol.scope.data.EyeParam;
import com.rigol.scope.data.MappingObject;
/* loaded from: classes2.dex */
public class AdapterEyeConstantBindingImpl extends AdapterEyeConstantBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.eye_constant_layout, 7);
        sViewsWithIds.put(R.id.left_guideline, 8);
        sViewsWithIds.put(R.id.right_guideline, 9);
        sViewsWithIds.put(R.id.eye_type_label, 10);
    }

    public AdapterEyeConstantBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private AdapterEyeConstantBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (ConstraintLayout) objArr[7], (TextView) objArr[6], (TextView) objArr[1], (RadioButton) objArr[3], (TextView) objArr[10], (RadioButton) objArr[5], (RadioGroup) objArr[2], (RadioButton) objArr[4], (Guideline) objArr[8], (Guideline) objArr[9]);
        this.mDirtyFlags = -1L;
        this.eyeDataRateLabel.setTag(null);
        this.eyeDataRateValue.setTag(null);
        this.eyeTypeAtuoRadioButton.setTag(null);
        this.eyeTypeManualRadioButton.setTag(null);
        this.eyeTypeRadioGroup.setTag(null);
        this.eyeTypeSemiautoRadioButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
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
        if (568 == i) {
            setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) obj);
        } else if (594 == i) {
            setParam((EyeParam) obj);
        } else if (517 == i) {
            setManualMapping((MappingObject) obj);
        } else if (569 == i) {
            setOnClickListener((View.OnClickListener) obj);
        } else if (57 == i) {
            setAtuoMapping((MappingObject) obj);
        } else if (796 != i) {
            return false;
        } else {
            setSemiautoMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterEyeConstantBinding
    public void setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnCheckedChangeListener = onCheckedChangeListener;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(568);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterEyeConstantBinding
    public void setParam(EyeParam eyeParam) {
        updateRegistration(1, eyeParam);
        this.mParam = eyeParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterEyeConstantBinding
    public void setManualMapping(MappingObject mappingObject) {
        updateRegistration(3, mappingObject);
        this.mManualMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(517);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterEyeConstantBinding
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(569);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterEyeConstantBinding
    public void setAtuoMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mAtuoMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(57);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterEyeConstantBinding
    public void setSemiautoMapping(MappingObject mappingObject) {
        updateRegistration(5, mappingObject);
        this.mSemiautoMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(796);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return false;
                            }
                            return onChangeSemiautoMapping((MappingObject) obj, i2);
                        }
                        return onChangeAtuoMapping((MappingObject) obj, i2);
                    }
                    return onChangeManualMapping((MappingObject) obj, i2);
                }
                return onChangeParamType((BaseProperty) obj, i2);
            }
            return onChangeParam((EyeParam) obj, i2);
        }
        return onChangeParamDataRate((BaseProperty) obj, i2);
    }

    private boolean onChangeParamDataRate(BaseProperty<Long> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(EyeParam eyeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParamType(BaseProperty<Integer> baseProperty, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 1015) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeManualMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeAtuoMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeSemiautoMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterEyeConstantBindingImpl.executeBindings():void");
    }
}
