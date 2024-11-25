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
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class AdapterDecodeI2cBindingImpl extends AdapterDecodeI2cBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.decode_i2c_layout, 8);
        sViewsWithIds.put(R.id.guideline_left, 9);
        sViewsWithIds.put(R.id.guideline_center, 10);
        sViewsWithIds.put(R.id.guideline_right, 11);
        sViewsWithIds.put(R.id.guideline_rightest, 12);
        sViewsWithIds.put(R.id.guideline_33, 13);
        sViewsWithIds.put(R.id.guideline_66, 14);
        sViewsWithIds.put(R.id.decode_i2c_clk_label, 15);
        sViewsWithIds.put(R.id.decode_i2c_scl_thres_label, 16);
        sViewsWithIds.put(R.id.decode_i2c_sda_label, 17);
        sViewsWithIds.put(R.id.decode_i2c_sda_thres_label, 18);
        sViewsWithIds.put(R.id.decode_i2c_exc_label, 19);
        sViewsWithIds.put(R.id.decode_i2c_rw_label, 20);
        sViewsWithIds.put(R.id.decode_i2c_rw_radioGroup, 21);
    }

    public AdapterDecodeI2cBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 22, sIncludes, sViewsWithIds));
    }

    private AdapterDecodeI2cBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (TextView) objArr[15], (TextView) objArr[1], (TextView) objArr[19], (SwitchButton) objArr[4], (ConstraintLayout) objArr[8], (TextView) objArr[20], (RadioGroup) objArr[21], (RadioButton) objArr[6], (RadioButton) objArr[5], (TextView) objArr[16], (TextView) objArr[2], (TextView) objArr[17], (TextView) objArr[18], (TextView) objArr[3], (TextView) objArr[7], (Guideline) objArr[13], (Guideline) objArr[14], (Guideline) objArr[10], (Guideline) objArr[9], (Guideline) objArr[11], (Guideline) objArr[12]);
        this.mDirtyFlags = -1L;
        this.decodeI2cClkValue.setTag(null);
        this.decodeI2cExcSwtichButton.setTag(null);
        this.decodeI2cRwWithRadioButton.setTag(null);
        this.decodeI2cRwWithoutRadioButton.setTag(null);
        this.decodeI2cSclThresValue.setTag(null);
        this.decodeI2cSdaThresValue.setTag(null);
        this.decodeI2cSdaValue.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
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
        if (768 == i) {
            setRwWithoutMapping((MappingObject) obj);
        } else if (767 == i) {
            setRwWithMapping((MappingObject) obj);
        } else if (172 == i) {
            setChannelAMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((DecodeParam) obj);
        } else if (174 != i) {
            return false;
        } else {
            setChannelBMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeI2cBinding
    public void setRwWithoutMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mRwWithoutMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(768);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeI2cBinding
    public void setRwWithMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mRwWithMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(767);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeI2cBinding
    public void setChannelAMapping(MappingObject mappingObject) {
        this.mChannelAMapping = mappingObject;
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeI2cBinding
    public void setParam(DecodeParam decodeParam) {
        updateRegistration(5, decodeParam);
        this.mParam = decodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeI2cBinding
    public void setChannelBMapping(MappingObject mappingObject) {
        this.mChannelBMapping = mappingObject;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeRwWithoutMapping((MappingObject) obj, i2);
            case 1:
                return onChangeRwWithMapping((MappingObject) obj, i2);
            case 2:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeI2cSclParamI2cScl((MappingObject) obj, i2);
            case 3:
                return onChangeChannelAMapping((MappingObject) obj, i2);
            case 4:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeI2cSdaParamI2cSda((MappingObject) obj, i2);
            case 5:
                return onChangeParam((DecodeParam) obj, i2);
            case 6:
                return onChangeChannelBMapping((MappingObject) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeRwWithoutMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
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

    private boolean onChangeRwWithMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeI2cSclParamI2cScl(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeChannelAMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeI2cSdaParamI2cSda(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeParam(DecodeParam decodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 390) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 391) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 878) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 393) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 392) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 388) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 389) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeChannelBMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00fc, code lost:
        if ((r7 != null ? r7.getSpi_clock() : 0) < 8) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0172  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 593
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterDecodeI2cBindingImpl.executeBindings():void");
    }
}
