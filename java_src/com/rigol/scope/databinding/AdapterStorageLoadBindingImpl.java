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
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageLoadParam;
import com.rigol.scope.utilities.ViewUtil;

/* loaded from: classes2.dex */
public class AdapterStorageLoadBindingImpl extends AdapterStorageLoadBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline, 7);
        sViewsWithIds.put(R.id.choose, 8);
        sViewsWithIds.put(R.id.choose_dividing_line, 9);
        sViewsWithIds.put(R.id.path_name, 10);
        sViewsWithIds.put(R.id.load, 11);
    }

    public AdapterStorageLoadBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private AdapterStorageLoadBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (TextView) objArr[8], (View) objArr[9], (TextView) objArr[1], (Guideline) objArr[7], (Button) objArr[11], (TextView) objArr[10], (EditText) objArr[6], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[2], (TextView) objArr[3]);
        this.mDirtyFlags = -1L;
        this.chooseSpinnerLoad.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.pathNameEditText.setTag(null);
        this.setupFileFormat.setTag(null);
        this.setupFileFormatSpinner.setTag(null);
        this.waveFileFormat.setTag(null);
        this.waveFileFormatSpinner.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
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
            setParam((StorageLoadParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterStorageLoadBinding
    public void setParam(StorageLoadParam storageLoadParam) {
        updateRegistration(1, storageLoadParam);
        this.mParam = storageLoadParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
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
                        return false;
                    }
                    return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageLoadSetupParamSetupFileType((MappingObject) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageLoadWaveParamWaveFileType((MappingObject) obj, i2);
            }
            return onChangeParam((StorageLoadParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageLoadOptionParamChooseValue1((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageLoadOptionParamChooseValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(StorageLoadParam storageLoadParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 178) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 1036) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 814) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 603) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageLoadWaveParamWaveFileType(MappingObject mappingObject, int i) {
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageLoadSetupParamSetupFileType(MappingObject mappingObject, int i) {
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

    /* JADX WARN: Removed duplicated region for block: B:51:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c5  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        int i2;
        int i3;
        int i4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        StorageLoadParam storageLoadParam = this.mParam;
        String str5 = null;
        if ((4095 & j) != 0) {
            if ((j & 2099) != 0) {
                ServiceEnum.StorageOperationChoose choose = storageLoadParam != null ? storageLoadParam.getChoose() : null;
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_storage_load_option, choose != null ? choose.value1 : 0);
                updateRegistration(0, mappingObject);
                str2 = mappingObject != null ? mappingObject.getStr() : null;
                int i5 = ((j & 2082) > 0L ? 1 : ((j & 2082) == 0L ? 0 : -1));
                if (i5 != 0) {
                    boolean z = choose == ServiceEnum.StorageOperationChoose.WAVE;
                    boolean z2 = choose == ServiceEnum.StorageOperationChoose.SETUP;
                    if (i5 != 0) {
                        j |= z ? PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : PlaybackStateCompat.ACTION_PREPARE;
                    }
                    if ((j & 2082) != 0) {
                        j |= z2 ? PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    }
                    i3 = 8;
                    i4 = z ? 0 : 8;
                    if (z2) {
                        i3 = 0;
                    }
                    if ((j & 2630) != 0) {
                        MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_storage_load_wave, storageLoadParam != null ? storageLoadParam.getWaveFileType() : 0);
                        updateRegistration(2, mappingObject2);
                        if (mappingObject2 != null) {
                            str3 = mappingObject2.getStr();
                            if ((j & 2306) != 0) {
                                str4 = ViewUtil.getDiskUIPathName(storageLoadParam != null ? storageLoadParam.getPathName() : null);
                            } else {
                                str4 = null;
                            }
                            if ((j & 3210) != 0) {
                                MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_storage_load_setup, storageLoadParam != null ? storageLoadParam.getSetupFileType() : 0);
                                updateRegistration(3, mappingObject3);
                                if (mappingObject3 != null) {
                                    str5 = mappingObject3.getStr();
                                }
                            }
                            i = i4;
                            j2 = 2099;
                            i2 = i3;
                            str = str5;
                        }
                    }
                    str3 = null;
                    if ((j & 2306) != 0) {
                    }
                    if ((j & 3210) != 0) {
                    }
                    i = i4;
                    j2 = 2099;
                    i2 = i3;
                    str = str5;
                }
            } else {
                str2 = null;
            }
            i3 = 0;
            i4 = 0;
            if ((j & 2630) != 0) {
            }
            str3 = null;
            if ((j & 2306) != 0) {
            }
            if ((j & 3210) != 0) {
            }
            i = i4;
            j2 = 2099;
            i2 = i3;
            str = str5;
        } else {
            j2 = 2099;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            i = 0;
            i2 = 0;
        }
        if ((j2 & j) != 0) {
            TextViewBindingAdapter.setText(this.chooseSpinnerLoad, str2);
        }
        if ((j & 2306) != 0) {
            TextViewBindingAdapter.setText(this.pathNameEditText, str4);
        }
        if ((j & 2082) != 0) {
            this.setupFileFormat.setVisibility(i2);
            this.setupFileFormatSpinner.setVisibility(i2);
            this.waveFileFormat.setVisibility(i);
            this.waveFileFormatSpinner.setVisibility(i);
        }
        if ((3210 & j) != 0) {
            TextViewBindingAdapter.setText(this.setupFileFormatSpinner, str);
        }
        if ((j & 2630) != 0) {
            TextViewBindingAdapter.setText(this.waveFileFormatSpinner, str3);
        }
    }
}
