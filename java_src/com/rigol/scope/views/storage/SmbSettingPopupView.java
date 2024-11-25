package com.rigol.scope.views.storage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.pinyinkeyboard.ExternalInterface;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.DiskManageParam;
import com.rigol.scope.data.DiskParam;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.databinding.PopupviewSmbSettingBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UtilityUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.DiskManageViewModel;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import java.util.List;
import java.util.Objects;
/* loaded from: classes2.dex */
public class SmbSettingPopupView extends BasePopupView implements View.OnClickListener {
    private final PopupviewSmbSettingBinding binding;
    private DiskManageParam diskManageParam;
    private StorageSaveParam saveParam;

    public SmbSettingPopupView() {
        super((int) R.style.App_PopupWindow_smbSetting);
        this.saveParam = null;
        this.diskManageParam = null;
        this.dismissOthers = false;
        PopupviewSmbSettingBinding inflate = PopupviewSmbSettingBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        this.saveParam = ((StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class)).getSaveLiveData().getValue();
        DiskManageViewModel diskManageViewModel = (DiskManageViewModel) ContextUtil.getAppViewModel(DiskManageViewModel.class);
        if (diskManageViewModel != null) {
            this.diskManageParam = diskManageViewModel.getLiveData().getValue();
        }
        this.binding.smbAutoConnectSwitch.setOnClickListener(this);
        this.binding.disconnect.setOnClickListener(this);
        this.binding.connect.setOnClickListener(this);
        this.binding.serverPathSpinner.setOnClickListener(this);
        this.binding.userNameSpinner.setOnClickListener(this);
        this.binding.passwordSpinner.setOnClickListener(this);
        ViewUtil.setSwitchButton(this.binding.smbAutoConnectSwitch);
        UpdateUIViewModel updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        if (updateUIViewModel != null) {
            updateUIViewModel.get(12, MessageID.MSG_STORAGE_CONNECT_STATE).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.storage.-$$Lambda$SmbSettingPopupView$rhhvl7MYZNIiogXlVnWyViO739Q
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SmbSettingPopupView.this.lambda$new$0$SmbSettingPopupView((Boolean) obj);
                }
            });
        }
        this.binding.setParam(this.saveParam);
    }

    public /* synthetic */ void lambda$new$0$SmbSettingPopupView(Boolean bool) {
        this.saveParam.savePathName(DiskManageParam.DEFAULT_PATH);
        List<DiskParam> diskList = UtilityUtil.getDiskList();
        int i = 0;
        while (true) {
            if (i >= diskList.size()) {
                break;
            } else if (diskList.get(i).getPath().equals("/storage/smb")) {
                this.saveParam.savePathName("/storage/smb");
                break;
            } else {
                i++;
            }
        }
        DiskManageParam diskManageParam = this.diskManageParam;
        if (diskManageParam != null) {
            diskManageParam.loadFiles();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.server_path_spinner) {
            Context context = this.context;
            View view2 = this.anchor;
            String serverPath = this.saveParam.getServerPath();
            final StorageSaveParam storageSaveParam = this.saveParam;
            Objects.requireNonNull(storageSaveParam);
            ViewUtil.showSavePinyinKeyboard(context, view2, view, true, serverPath, new ExternalInterface() { // from class: com.rigol.scope.views.storage.-$$Lambda$UX3H1KvxnY7RO-Rr_htbdBFYvH4
                @Override // com.rigol.pinyinkeyboard.ExternalInterface
                public final void resultShow(String str) {
                    StorageSaveParam.this.saveServerPath(str);
                }
            }, 17, 0, 0);
        } else if (id == R.id.user_name_spinner) {
            Context context2 = this.context;
            View view3 = this.anchor;
            String userName = this.saveParam.getUserName();
            final StorageSaveParam storageSaveParam2 = this.saveParam;
            Objects.requireNonNull(storageSaveParam2);
            ViewUtil.showSavePinyinKeyboard(context2, view3, view, true, userName, new ExternalInterface() { // from class: com.rigol.scope.views.storage.-$$Lambda$9Jk1tyPPhidjWbA9ZBEZsQtxgs0
                @Override // com.rigol.pinyinkeyboard.ExternalInterface
                public final void resultShow(String str) {
                    StorageSaveParam.this.saveUserName(str);
                }
            }, 17, 0, 0);
        } else if (id == R.id.password_spinner) {
            Context context3 = this.context;
            View view4 = this.anchor;
            String password = this.saveParam.getPassword();
            final StorageSaveParam storageSaveParam3 = this.saveParam;
            Objects.requireNonNull(storageSaveParam3);
            ViewUtil.showSavePinyinKeyboard(context3, view4, view, true, password, new ExternalInterface() { // from class: com.rigol.scope.views.storage.-$$Lambda$KS2p3m69B3aSPP03s3QF5Mh-tI0
                @Override // com.rigol.pinyinkeyboard.ExternalInterface
                public final void resultShow(String str) {
                    StorageSaveParam.this.savePassword(str);
                }
            }, 17, 0, 0);
        } else if (id == R.id.connect) {
            API.getInstance().UI_PostInt32(12, MessageID.MSG_STORAGE_CONNECT, 0);
        } else if (id == R.id.disconnect) {
            API.getInstance().UI_PostInt32(12, MessageID.MSG_STORAGE_DISCONNECT, 0);
        } else if (id == R.id.smb_auto_connect_switch) {
            StorageSaveParam storageSaveParam4 = this.saveParam;
            storageSaveParam4.saveAutoConnect(!storageSaveParam4.getAutoConnect());
        }
    }
}
