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
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageLoadParam;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;

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
    */
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        float f;
        String str6;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        StorageLoadParam storageLoadParam = this.mStorageParam;
        StorageSaveParam storageSaveParam = this.mParam;
        BodeParam bodeParam = this.mBodeParam;
        String str7 = null;
        if ((8549 & j) != 0) {
            if ((j & 8485) != 0) {
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_storage_filetype, storageLoadParam != null ? storageLoadParam.getBodeFileType() : 0);
                updateRegistration(2, mappingObject);
                if (mappingObject != null) {
                    str2 = mappingObject.getStr();
                    if ((j & 8257) == 0) {
                        str = ViewUtil.getDiskUIPathName(storageLoadParam != null ? storageLoadParam.getPathName() : null);
                    } else {
                        str = null;
                    }
                }
            }
            str2 = null;
            if ((j & 8257) == 0) {
            }
        } else {
            str = null;
            str2 = null;
        }
        if ((j & 11914) != 0) {
            if ((j & 10248) != 0) {
                str6 = ViewUtil.getDiskUIPathName(storageSaveParam != null ? storageSaveParam.getPathName() : null);
            } else {
                str6 = null;
            }
            String prefix = ((j & 9224) == 0 || storageSaveParam == null) ? null : storageSaveParam.getPrefix();
            if ((j & 8842) != 0) {
                MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_storage_filetype, storageSaveParam != null ? storageSaveParam.getBodeFileType() : 0);
                updateRegistration(1, mappingObject2);
                if (mappingObject2 != null) {
                    str7 = mappingObject2.getStr();
                }
            }
            str5 = str6;
            str3 = str7;
            str4 = prefix;
        } else {
            str3 = null;
            str4 = null;
            str5 = null;
        }
        int i = ((j & 12304) > 0L ? 1 : ((j & 12304) == 0L ? 0 : -1));
        if (i != 0) {
            r15 = bodeParam != null ? bodeParam.getBodeEnable() : false;
            f = ContextUtil.getAlpha(r15);
        } else {
            f = 0.0f;
        }
        if (i != 0) {
            if (getBuildSdkInt() >= 11) {
                this.fileFormat.setAlpha(f);
                this.fileFormatSpinner.setAlpha(f);
                this.fileName.setAlpha(f);
                this.fileNameText.setAlpha(f);
                this.filePath.setAlpha(f);
                this.filePathText.setAlpha(f);
                this.loadBtn.setAlpha(f);
                this.loadText.setAlpha(f);
                this.mboundView1.setAlpha(f);
                this.pathLoadName.setAlpha(f);
                this.pathNameEditLoad.setAlpha(f);
                this.saveBtn.setAlpha(f);
                this.waveFileFormatSpinner.setAlpha(f);
                this.waveFileLoadText.setAlpha(f);
            }
            this.fileFormat.setEnabled(r15);
            this.fileFormatSpinner.setEnabled(r15);
            this.fileName.setEnabled(r15);
            this.fileNameText.setEnabled(r15);
            this.filePath.setEnabled(r15);
            this.filePathText.setEnabled(r15);
            this.loadBtn.setEnabled(r15);
            this.loadText.setEnabled(r15);
            this.mboundView1.setEnabled(r15);
            this.pathLoadName.setEnabled(r15);
            this.pathNameEditLoad.setEnabled(r15);
            this.saveBtn.setEnabled(r15);
            this.waveFileFormatSpinner.setEnabled(r15);
            this.waveFileLoadText.setEnabled(r15);
        }
        if ((j & 8842) != 0) {
            TextViewBindingAdapter.setText(this.fileFormatSpinner, str3);
        }
        if ((j & 9224) != 0) {
            TextViewBindingAdapter.setText(this.fileNameText, str4);
        }
        if ((j & 10248) != 0) {
            TextViewBindingAdapter.setText(this.filePathText, str5);
        }
        if ((j & 8257) != 0) {
            TextViewBindingAdapter.setText(this.pathNameEditLoad, str);
        }
        if ((j & 8485) != 0) {
            TextViewBindingAdapter.setText(this.waveFileFormatSpinner, str2);
        }
    }
}
