package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
/* loaded from: classes2.dex */
public class AdapterDecodeUsbBindingImpl extends AdapterDecodeUsbBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.decode_usb_layout, 18);
        sViewsWithIds.put(R.id.divider1, 19);
        sViewsWithIds.put(R.id.decode_usb_sig_label, 20);
        sViewsWithIds.put(R.id.decode_usb_sig_radioGroup, 21);
    }

    public AdapterDecodeUsbBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 22, sIncludes, sViewsWithIds));
    }

    private AdapterDecodeUsbBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (TextView) objArr[12], (TextView) objArr[14], (TextView) objArr[17], (TextView) objArr[15], (TextView) objArr[16], (TextView) objArr[13], (TextView) objArr[1], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[2], (TextView) objArr[8], (TextView) objArr[11], (TextView) objArr[10], (TextView) objArr[9], (RadioButton) objArr[7], (ConstraintLayout) objArr[18], (RadioButton) objArr[5], (RadioButton) objArr[6], (TextView) objArr[20], (RadioGroup) objArr[21], (View) objArr[19]);
        this.mDirtyFlags = -1L;
        this.decodeUsbDiffLabel.setTag(null);
        this.decodeUsbDiffThreHLabel.setTag(null);
        this.decodeUsbDiffThreHValue.setTag(null);
        this.decodeUsbDiffThreLLabel.setTag(null);
        this.decodeUsbDiffThreLValue.setTag(null);
        this.decodeUsbDiffValue.setTag(null);
        this.decodeUsbDpLabel.setTag(null);
        this.decodeUsbDpThresLabel.setTag(null);
        this.decodeUsbDpThresValue.setTag(null);
        this.decodeUsbDpValue.setTag(null);
        this.decodeUsbDsLabel.setTag(null);
        this.decodeUsbDsThresLabel.setTag(null);
        this.decodeUsbDsThresValue.setTag(null);
        this.decodeUsbDsValue.setTag(null);
        this.decodeUsbHighRadioButton.setTag(null);
        this.decodeUsbLowRadioButton.setTag(null);
        this.decodeUsbMidRadioButton.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
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
        if (996 == i) {
            setUsbHighMapping((MappingObject) obj);
        } else if (998 == i) {
            setUsbMidMapping((MappingObject) obj);
        } else if (997 == i) {
            setUsbLowMapping((MappingObject) obj);
        } else if (594 != i) {
            return false;
        } else {
            setParam((DecodeParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeUsbBinding
    public void setUsbHighMapping(MappingObject mappingObject) {
        updateRegistration(1, mappingObject);
        this.mUsbHighMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(996);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeUsbBinding
    public void setUsbMidMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mUsbMidMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(998);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeUsbBinding
    public void setUsbLowMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mUsbLowMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(997);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterDecodeUsbBinding
    public void setParam(DecodeParam decodeParam) {
        updateRegistration(6, decodeParam);
        this.mParam = decodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeUsbDiffParamUsbDiff((MappingObject) obj, i2);
            case 1:
                return onChangeUsbHighMapping((MappingObject) obj, i2);
            case 2:
                return onChangeUsbMidMapping((MappingObject) obj, i2);
            case 3:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeUsbDsParamUsbDs((MappingObject) obj, i2);
            case 4:
                return onChangeUsbLowMapping((MappingObject) obj, i2);
            case 5:
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeUsbDpParamUsbDp((MappingObject) obj, i2);
            case 6:
                return onChangeParam((DecodeParam) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeUsbDiffParamUsbDiff(MappingObject mappingObject, int i) {
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

    private boolean onChangeUsbHighMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeUsbMidMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeUsbDsParamUsbDs(MappingObject mappingObject, int i) {
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

    private boolean onChangeUsbLowMapping(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgDecodeUsbDpParamUsbDp(MappingObject mappingObject, int i) {
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

    private boolean onChangeParam(DecodeParam decodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 1008) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 1003) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 1004) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 1005) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 1006) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 999) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 1001) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 1000) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x016c  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 882
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterDecodeUsbBindingImpl.executeBindings():void");
    }
}
