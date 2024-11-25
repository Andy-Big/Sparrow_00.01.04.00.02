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
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;
/* loaded from: classes2.dex */
public class PopupviewSmbSettingBindingImpl extends PopupviewSmbSettingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline_center, 6);
        sViewsWithIds.put(R.id.smb_auto_connect_label, 7);
        sViewsWithIds.put(R.id.smb_drive_letter, 8);
        sViewsWithIds.put(R.id.smb_drive_letter_text, 9);
        sViewsWithIds.put(R.id.smb_connect_state_label, 10);
        sViewsWithIds.put(R.id.server_path_lable, 11);
        sViewsWithIds.put(R.id.user_name_lable, 12);
        sViewsWithIds.put(R.id.password_lable, 13);
        sViewsWithIds.put(R.id.disconnect, 14);
        sViewsWithIds.put(R.id.connect, 15);
    }

    public PopupviewSmbSettingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private PopupviewSmbSettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (Button) objArr[15], (Button) objArr[14], (Guideline) objArr[6], (TextView) objArr[13], (EditText) objArr[5], (TextView) objArr[11], (EditText) objArr[3], (TextView) objArr[7], (SwitchButton) objArr[1], (TextView) objArr[10], (TextView) objArr[2], (TextView) objArr[8], (EditText) objArr[9], (TextView) objArr[12], (EditText) objArr[4]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.passwordSpinner.setTag(null);
        this.serverPathSpinner.setTag(null);
        this.smbAutoConnectSwitch.setTag(null);
        this.smbConnectStateValue.setTag(null);
        this.userNameSpinner.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256L;
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

    @Override // com.rigol.scope.databinding.PopupviewSmbSettingBinding
    public void setParam(StorageSaveParam storageSaveParam) {
        updateRegistration(1, storageSaveParam);
        this.mParam = storageSaveParam;
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
                return false;
            }
            return onChangeParam((StorageSaveParam) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageConnectStateParamConnectState((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageConnectStateParamConnectState(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(StorageSaveParam storageSaveParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 58) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 188) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 809) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 1012) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 601) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        boolean z;
        String str5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        StorageSaveParam storageSaveParam = this.mParam;
        String str6 = null;
        if ((511 & j) != 0) {
            if ((j & 279) != 0) {
                int connectState = storageSaveParam != null ? storageSaveParam.getConnectState() : 0;
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_storage_connect_state, connectState);
                updateRegistration(0, mappingObject);
                str5 = mappingObject != null ? mappingObject.getStr() : null;
                int i2 = ((j & 274) > 0L ? 1 : ((j & 274) == 0L ? 0 : -1));
                if (i2 != 0) {
                    boolean z2 = connectState == 1;
                    if (i2 != 0) {
                        j |= z2 ? PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID : 512L;
                    }
                    i = getColorFromResource(this.smbConnectStateValue, z2 ? R.color.lime_green : R.color.red);
                    z = ((j & 266) != 0 || storageSaveParam == null) ? false : storageSaveParam.getAutoConnect();
                    String userName = ((j & 322) != 0 || storageSaveParam == null) ? null : storageSaveParam.getUserName();
                    String serverPath = ((j & 290) != 0 || storageSaveParam == null) ? null : storageSaveParam.getServerPath();
                    if ((j & 386) != 0 && storageSaveParam != null) {
                        str6 = storageSaveParam.getPassword();
                    }
                    str2 = str5;
                    str = str6;
                    str3 = userName;
                    str4 = serverPath;
                }
            } else {
                str5 = null;
            }
            i = 0;
            if ((j & 266) != 0) {
            }
            if ((j & 322) != 0) {
            }
            if ((j & 290) != 0) {
            }
            if ((j & 386) != 0) {
                str6 = storageSaveParam.getPassword();
            }
            str2 = str5;
            str = str6;
            str3 = userName;
            str4 = serverPath;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            i = 0;
            z = false;
        }
        if ((j & 386) != 0) {
            TextViewBindingAdapter.setText(this.passwordSpinner, str);
        }
        if ((290 & j) != 0) {
            TextViewBindingAdapter.setText(this.serverPathSpinner, str4);
        }
        if ((j & 266) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.smbAutoConnectSwitch, z);
        }
        if ((j & 279) != 0) {
            TextViewBindingAdapter.setText(this.smbConnectStateValue, str2);
        }
        if ((274 & j) != 0) {
            this.smbConnectStateValue.setTextColor(i);
        }
        if ((j & 322) != 0) {
            TextViewBindingAdapter.setText(this.userNameSpinner, str3);
        }
    }
}
