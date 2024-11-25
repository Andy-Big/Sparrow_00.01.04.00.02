package com.rigol.scope.views.ddrDebug;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.pinyinkeyboard.ExternalInterface;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.DiskManageParam;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.databinding.PopupviewDdrBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.diskManage.DiskManagePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import java.util.Objects;
import javax.mail.UIDFolder;
/* loaded from: classes2.dex */
public class DdrDebugPopupView extends BasePopupView implements View.OnClickListener {
    private final PopupviewDdrBinding binding;
    private KeyboardPopupView keyboardPopupView;
    private StorageSaveParam param;
    private int size;
    private int startAddr;

    public DdrDebugPopupView() {
        super((int) R.style.App_PopupWindow_Ddr);
        this.startAddr = 0;
        this.size = 0;
        PopupviewDdrBinding inflate = PopupviewDdrBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
        if (storageViewModel != null) {
            storageViewModel.getSaveLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer<StorageSaveParam>() { // from class: com.rigol.scope.views.ddrDebug.DdrDebugPopupView.1
                @Override // androidx.lifecycle.Observer
                public void onChanged(StorageSaveParam storageSaveParam) {
                    DdrDebugPopupView.this.param = storageSaveParam;
                    DdrDebugPopupView.this.binding.setParam(DdrDebugPopupView.this.param);
                }
            });
        }
        this.binding.startAddrText.setOnClickListener(this);
        this.binding.sizeText.setOnClickListener(this);
        this.binding.fileNameText.setOnClickListener(this);
        this.binding.filePathText.setOnClickListener(this);
        this.binding.saveBtn.setOnClickListener(this);
        this.binding.loadBtn.setOnClickListener(this);
    }

    public int getStartAddr() {
        return this.startAddr;
    }

    public void setStartAddr(int i) {
        this.startAddr = i;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int i) {
        this.size = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.start_addr_text) {
            ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_number, UIDFolder.MAXUID, 0L, 0L, getStartAddr(), new KeyboardListener() { // from class: com.rigol.scope.views.ddrDebug.DdrDebugPopupView.2
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DdrDebugPopupView.this.setStartAddr(((Long) t).intValue());
                    DdrDebugPopupView.this.binding.startAddrText.setText(String.valueOf(DdrDebugPopupView.this.getStartAddr()));
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DdrDebugPopupView.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.size_text) {
            ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_number, UIDFolder.MAXUID, 0L, 0L, getSize(), new KeyboardListener() { // from class: com.rigol.scope.views.ddrDebug.DdrDebugPopupView.3
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DdrDebugPopupView.this.setSize(((Long) t).intValue());
                    DdrDebugPopupView.this.binding.sizeText.setText(String.valueOf(DdrDebugPopupView.this.getSize()));
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DdrDebugPopupView.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.file_name_text) {
            Context context = this.context;
            View view2 = this.anchor;
            EditText editText = this.binding.fileNameText;
            String prefix = this.param.getPrefix();
            final StorageSaveParam storageSaveParam = this.param;
            Objects.requireNonNull(storageSaveParam);
            ViewUtil.showPinyinKeyboard(context, view2, editText, prefix, new ExternalInterface() { // from class: com.rigol.scope.views.ddrDebug.-$$Lambda$i9NRwQVRXRz5denMFitBirafr2w
                @Override // com.rigol.pinyinkeyboard.ExternalInterface
                public final void resultShow(String str) {
                    StorageSaveParam.this.savePrefix(str);
                }
            }, 17, 0, 0);
        } else if (id == R.id.file_path_text) {
            String pathName = this.param.getPathName();
            DiskManageParam.SelectionMode selectionMode = DiskManageParam.SelectionMode.FILE;
            final StorageSaveParam storageSaveParam2 = this.param;
            Objects.requireNonNull(storageSaveParam2);
            ViewUtil.showDiskManage(pathName, selectionMode, new DiskManagePopupView.Callback() { // from class: com.rigol.scope.views.ddrDebug.-$$Lambda$FtnkS5Qj29C5AJZD93PQtkUcPos
                @Override // com.rigol.scope.views.diskManage.DiskManagePopupView.Callback
                public final void onFolderSelected(String str) {
                    StorageSaveParam.this.savePathName(str);
                }
            });
        } else if (id == R.id.save_btn) {
            API.getInstance().UI_PostInt32(12, MessageID.MSG_STORAGE_MEM_ADDR, getStartAddr());
            API.getInstance().UI_PostInt32(12, MessageID.MSG_STORAGE_MEM_LEN, getSize());
            this.param.saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_DDR);
            StorageSaveParam storageSaveParam3 = this.param;
            storageSaveParam3.saveFileName(this.param.getPrefix() + "." + ServiceEnum.enFileType.FILETYPE_BIN.value2);
            StorageSaveParam storageSaveParam4 = this.param;
            storageSaveParam4.savePathName(storageSaveParam4.getPathName());
            API.getInstance().UI_PostBool(12, MessageID.MSG_STORAGE_SAVE_MEM, true);
        }
    }
}
