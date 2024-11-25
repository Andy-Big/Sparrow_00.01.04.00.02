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
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageLoadParam;
import com.rigol.scope.data.StorageSaveParam;
/* loaded from: classes2.dex */
public class AdapterBodeSavingSeniorBindingImpl extends AdapterBodeSavingSeniorBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 15);
    }

    public AdapterBodeSavingSeniorBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private AdapterBodeSavingSeniorBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[4], (EditText) objArr[5], (TextView) objArr[6], (EditText) objArr[7], (Guideline) objArr[15], (Button) objArr[14], (TextView) objArr[9], (TextView) objArr[12], (EditText) objArr[13], (Button) objArr[8], (TextView) objArr[11], (TextView) objArr[10]);
        this.mDirtyFlags = -1L;
        this.fileFormat.setTag(null);
        this.fileFormatSpinner.setTag(null);
        this.fileName.setTag(null);
        this.fileNameText.setTag(null);
        this.filePath.setTag(null);
        this.filePathText.setTag(null);
        this.loadBtn.setTag(null);
        this.loadText.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        this.pathLoadName.setTag(null);
        this.pathNameEditLoad.setTag(null);
        this.saveBtn.setTag(null);
        this.waveFileFormatSpinner.setTag(null);
        this.waveFileLoadText.setTag(null);
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
        if (914 == i) {
            setStorageParam((StorageLoadParam) obj);
        } else if (594 == i) {
            setParam((StorageSaveParam) obj);
        } else if (100 != i) {
            return false;
        } else {
            setBodeParam((BodeParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterBodeSavingSeniorBinding
    public void setStorageParam(StorageLoadParam storageLoadParam) {
        updateRegistration(0, storageLoadParam);
        this.mStorageParam = storageLoadParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(914);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterBodeSavingSeniorBinding
    public void setParam(StorageSaveParam storageSaveParam) {
        updateRegistration(3, storageSaveParam);
        this.mParam = storageSaveParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterBodeSavingSeniorBinding
    public void setBodeParam(BodeParam bodeParam) {
        updateRegistration(4, bodeParam);
        this.mBodeParam = bodeParam;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(100);
        super.requestRebind();
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
                        return onChangeBodeParam((BodeParam) obj, i2);
                    }
                    return onChangeParam((StorageSaveParam) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageFiletypeStorageParamBodeFileType((MappingObject) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageFiletypeParamBodeFileType((MappingObject) obj, i2);
        }
        return onChangeStorageParam((StorageLoadParam) obj, i2);
    }

    private boolean onChangeStorageParam(StorageLoadParam storageLoadParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 97) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 603) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageFiletypeParamBodeFileType(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageFiletypeStorageParamBodeFileType(MappingObject mappingObject, int i) {
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
        } else if (i == 97) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 654) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 603) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeBodeParam(BodeParam bodeParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 96) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.databinding.AdapterBodeSavingSeniorBindingImpl.executeBindings():void");
    }
}
