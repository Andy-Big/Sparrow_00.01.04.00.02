package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class AdapterStorageSaveBindingImpl extends AdapterStorageSaveBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline, 25);
        sViewsWithIds.put(R.id.choose, 26);
        sViewsWithIds.put(R.id.choose_dividing_line, 27);
        sViewsWithIds.put(R.id.storage_channel, 28);
        sViewsWithIds.put(R.id.file_dividing_line, 29);
        sViewsWithIds.put(R.id.prefix, 30);
        sViewsWithIds.put(R.id.auto_name, 31);
        sViewsWithIds.put(R.id.path_name, 32);
        sViewsWithIds.put(R.id.save, 33);
    }

    public AdapterStorageSaveBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 34, sIncludes, sViewsWithIds));
    }

    private AdapterStorageSaveBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (TextView) objArr[31], (SwitchButton) objArr[23], (CheckBox) objArr[16], (CheckBox) objArr[17], (CheckBox) objArr[18], (CheckBox) objArr[19], (TextView) objArr[26], (View) objArr[27], (TextView) objArr[1], (View) objArr[29], (Guideline) objArr[25], (TextView) objArr[8], (SwitchButton) objArr[9], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[10], (SwitchButton) objArr[11], (TextView) objArr[6], (SwitchButton) objArr[7], (TextView) objArr[32], (EditText) objArr[24], (TextView) objArr[30], (EditText) objArr[22], (Button) objArr[33], (TextView) objArr[20], (TextView) objArr[21], (TextView) objArr[2], (SwitchButton) objArr[3], (TextView) objArr[28], (TextView) objArr[12], (TextView) objArr[13], (TextView) objArr[14], (TextView) objArr[15]);
        this.mDirtyFlags = -1L;
        this.autoNameSwitch.setTag(null);
        this.checkBoxCH1.setTag(null);
        this.checkBoxCH2.setTag(null);
        this.checkBoxCH3.setTag(null);
        this.checkBoxCH4.setTag(null);
        this.chooseSpinnerSave.setTag(null);
        this.imageColor.setTag(null);
        this.imageColorSwitch.setTag(null);
        this.imageFormat.setTag(null);
        this.imageFormatSpinner.setTag(null);
        this.imageHeader.setTag(null);
        this.imageHeaderSwitch.setTag(null);
        this.imageInvert.setTag(null);
        this.imageInvertSwitch.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.pathNameEditText.setTag(null);
        this.prefixEditText.setTag(null);
        this.setupFormat.setTag(null);
        this.setupFormatSpinner.setTag(null);
        this.smbEnLabel.setTag(null);
        this.smbEnSwitch.setTag(null);
        this.waveDepth.setTag(null);
        this.waveDepthSpinner.setTag(null);
        this.waveFormat.setTag(null);
        this.waveFormatSpinner.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 134217728L;
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
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterStorageSaveBinding
    public void setParam(StorageSaveParam storageSaveParam) {
        updateRegistration(3, storageSaveParam);
        this.mParam = storageSaveParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(594);
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
                            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageWaveFormatParamWaveFileType((MappingObject) obj, i2);
                        }
                        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageSaveOptionParamChooseValue1((MappingObject) obj, i2);
                    }
                    return onChangeParam((StorageSaveParam) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageWaveDepthParamWaveDepth((MappingObject) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageImageFormatParamImageFileType((MappingObject) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageSetupFormatParamSetupFileType((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageSetupFormatParamSetupFileType(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageImageFormatParamImageFileType(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageWaveDepthParamWaveDepth(MappingObject mappingObject, int i) {
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

    private boolean onChangeParam(StorageSaveParam storageSaveParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 178) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 855) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 428) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 430) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 427) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 429) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 1035) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 1036) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 153) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 155) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 157) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 159) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 814) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 654) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 60) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 603) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageSaveOptionParamChooseValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageWaveFormatParamWaveFileType(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c4, code lost:
        if (r11 != false) goto L203;
     */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0200  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 900
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterStorageSaveBindingImpl.executeBindings():void");
    }
}
