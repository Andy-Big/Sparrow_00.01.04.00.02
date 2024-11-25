package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UpaParam;
/* loaded from: classes2.dex */
public class AdapterItemQualityBindingImpl extends AdapterItemQualityBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.right_guideline, 9);
        sViewsWithIds.put(R.id.left_guideline, 10);
        sViewsWithIds.put(R.id.left_guideline2, 11);
        sViewsWithIds.put(R.id.left_guideline3, 12);
        sViewsWithIds.put(R.id.left_guideline4, 13);
        sViewsWithIds.put(R.id.dividing_line1, 14);
        sViewsWithIds.put(R.id.upa_option, 15);
        sViewsWithIds.put(R.id.upa_, 16);
        sViewsWithIds.put(R.id.dividing_line2, 17);
        sViewsWithIds.put(R.id.upa_consult, 18);
        sViewsWithIds.put(R.id.upa_settype, 19);
        sViewsWithIds.put(R.id.upa_max_mun, 20);
        sViewsWithIds.put(R.id.dividing_line3, 21);
        sViewsWithIds.put(R.id.upa_record_mun, 22);
        sViewsWithIds.put(R.id.upa_current, 23);
        sViewsWithIds.put(R.id.upa_current_text, 24);
        sViewsWithIds.put(R.id.upa_middle_mun, 25);
        sViewsWithIds.put(R.id.upa_found_default, 26);
        sViewsWithIds.put(R.id.low_edit_text, 27);
        sViewsWithIds.put(R.id.upa_reccovery, 28);
        sViewsWithIds.put(R.id.upa_link_drawing, 29);
    }

    public AdapterItemQualityBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 30, sIncludes, sViewsWithIds));
    }

    private AdapterItemQualityBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (View) objArr[14], (View) objArr[17], (View) objArr[21], (Guideline) objArr[10], (Guideline) objArr[11], (Guideline) objArr[12], (Guideline) objArr[13], (TextView) objArr[27], (Guideline) objArr[9], (TextView) objArr[16], (TextView) objArr[18], (TextView) objArr[23], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[24], (EditText) objArr[8], (EditText) objArr[3], (Button) objArr[26], (Button) objArr[29], (TextView) objArr[20], (TextView) objArr[25], (EditText) objArr[7], (TextView) objArr[15], (TextView) objArr[1], (Button) objArr[28], (TextView) objArr[22], (EditText) objArr[4], (TextView) objArr[2], (TextView) objArr[19]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.upaCurrentSpinner.setTag(null);
        this.upaCurrentSpinner2.setTag(null);
        this.upaDownEdit.setTag(null);
        this.upaEditText.setTag(null);
        this.upaMiddleText.setTag(null);
        this.upaPassageway.setTag(null);
        this.upaRecordText.setTag(null);
        this.upaSetTypeSpinner.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
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
            setParam((UpaParam) obj);
        } else if (992 != i) {
            return false;
        } else {
            setUpaMappingObj((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterItemQualityBinding
    public void setParam(UpaParam upaParam) {
        updateRegistration(3, upaParam);
        this.mParam = upaParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterItemQualityBinding
    public void setUpaMappingObj(MappingObject mappingObject) {
        this.mUpaMappingObj = mappingObject;
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
                            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaReflTypeParamRefPowerFref((MappingObject) obj, i2);
                        }
                        return onChangeUpaMappingObj((MappingObject) obj, i2);
                    }
                    return onChangeParam((UpaParam) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaPowerFrefParamReflevel((MappingObject) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaPowerVoltParamRefPowerVolt((MappingObject) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaPowerCurrParamRefPowerCurr((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaPowerCurrParamRefPowerCurr(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaPowerVoltParamRefPowerVolt(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaPowerFrefParamReflevel(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(UpaParam upaParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 729) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 727) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 722) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 711) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 903) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 733) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 724) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 721) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 713) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 720) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 712) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeUpaMappingObj(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgUpaReflTypeParamRefPowerFref(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0156  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 729
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterItemQualityBindingImpl.executeBindings():void");
    }
}
