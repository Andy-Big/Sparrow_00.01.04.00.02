package com.rigol.scope.views.save;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.FileUtils;
import com.rigol.pinyinkeyboard.ExternalInterface;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.DiskManageParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.databinding.PopupviewSaveBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.BusAnalyseViewModel;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.busAnalyse.BusAnalyseParam;
import com.rigol.scope.views.diskManage.DiskManagePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.util.ToastUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes2.dex */
public class SavePopupView extends BasePopupView implements View.OnClickListener {
    private final String DEFAULT_PREFIX;
    private final PopupviewSaveBinding binding;
    private StorageSaveParam param;

    public SavePopupView() {
        super((int) R.style.App_PopupWindow_Save);
        this.DEFAULT_PREFIX = "RigolDS";
        PopupviewSaveBinding inflate = PopupviewSaveBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
        if (storageViewModel != null) {
            storageViewModel.getSaveLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer<StorageSaveParam>() { // from class: com.rigol.scope.views.save.SavePopupView.1
                @Override // androidx.lifecycle.Observer
                public void onChanged(StorageSaveParam storageSaveParam) {
                    SavePopupView.this.param = storageSaveParam;
                    SavePopupView.this.binding.setParam(SavePopupView.this.param);
                }
            });
        }
        this.binding.fileNameText.setOnClickListener(this);
        this.binding.fileFormatSpinner.setOnClickListener(this);
        this.binding.filePathText.setOnClickListener(this);
        this.binding.saveBtn.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ServiceEnum.enFileType enfiletype;
        String str;
        BusAnalyseParam value;
        ServiceEnum.enFileType enfiletype2;
        String str2;
        int id = view.getId();
        if (id == R.id.file_name_text) {
            this.param.setPrefix("RigolDS");
            Context context = this.context;
            View view2 = this.anchor;
            String prefix = this.param.getPrefix();
            final StorageSaveParam storageSaveParam = this.param;
            Objects.requireNonNull(storageSaveParam);
            ViewUtil.showSavePinyinKeyboard(context, view2, view, true, prefix, new ExternalInterface() { // from class: com.rigol.scope.views.save.-$$Lambda$i9NRwQVRXRz5denMFitBirafr2w
                @Override // com.rigol.pinyinkeyboard.ExternalInterface
                public final void resultShow(String str3) {
                    StorageSaveParam.this.savePrefix(str3);
                }
            }, 17, 0, 0);
        } else if (id == R.id.file_format_spinner) {
            List<MappingObject> fileTypeList = getFileTypeList(this.param.getFileProc(), R.array.msg_storage_filetype);
            if (fileTypeList != null) {
                ViewUtil.showSpinner(this.anchor, view, fileTypeList, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.save.-$$Lambda$SavePopupView$vWTsLM0RiiMwmHwiuIGPmm_Voc0
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view3, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        SavePopupView.this.lambda$onClick$0$SavePopupView(view3, viewHolder, i, (MappingObject) obj);
                    }
                });
            }
        } else if (id == R.id.file_path_text) {
            $$Lambda$SavePopupView$JFpsMD7kDayUyldeqntizVkacQ __lambda_savepopupview_jfpsmd7kdayuyldeqntizvkacq = new FileFilter() { // from class: com.rigol.scope.views.save.-$$Lambda$SavePopupView$JFpsMD7kDayUyldeqnt-izVkacQ
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    return SavePopupView.lambda$onClick$1(file);
                }
            };
            String pathName = this.param.getPathName();
            DiskManageParam.SelectionMode selectionMode = DiskManageParam.SelectionMode.DIR;
            final StorageSaveParam storageSaveParam2 = this.param;
            Objects.requireNonNull(storageSaveParam2);
            ViewUtil.showDiskManage(pathName, selectionMode, __lambda_savepopupview_jfpsmd7kdayuyldeqntizvkacq, new DiskManagePopupView.Callback() { // from class: com.rigol.scope.views.save.-$$Lambda$FtnkS5Qj29C5AJZD93PQtkUcPos
                @Override // com.rigol.scope.views.diskManage.DiskManagePopupView.Callback
                public final void onFolderSelected(String str3) {
                    StorageSaveParam.this.savePathName(str3);
                }
            });
        } else if (id == R.id.save_btn) {
            if (this.param.getFileProc() == ServiceEnum.StorageFunc.FUNC_SAVE_REF) {
                this.param.saveRefSetting();
                this.param.doSave();
            } else if (this.param.getFileProc() == ServiceEnum.StorageFunc.FUNC_SAVE_MSK) {
                this.param.saveMaskSetting();
                this.param.doSave();
            } else if (this.param.getFileProc() == ServiceEnum.StorageFunc.FUNC_SAVE_DECDAT) {
                if (ServiceEnum.getenFileTypeFromValue1(this.param.getFileType()) == null) {
                    return;
                }
                String decodeDataPath = this.param.getDecodeDataPath();
                if (!this.param.readAutoName()) {
                    str2 = this.param.getPathName() + "/" + ViewUtil.getNextFileName(new File(this.param.getPathName()), this.param.getPrefix(), enfiletype2);
                } else {
                    str2 = this.param.getPathName() + "/" + this.param.getPrefix() + "." + enfiletype2.value2;
                }
                if (FileUtils.copy(decodeDataPath, str2)) {
                    String diskUIPathName = ViewUtil.getDiskUIPathName(str2);
                    ToastUtils.showLong(ActivityUtils.getTopActivity().getString(R.string.msg_storage_toast_save_success) + diskUIPathName);
                    return;
                }
                ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.msg_storage_toast_fail));
            } else if (this.param.getFileProc() == ServiceEnum.StorageFunc.FUNC_SAVE_HTML) {
                if (ServiceEnum.getenFileTypeFromValue1(this.param.getFileType()) == null) {
                    return;
                }
                if (!this.param.readAutoName()) {
                    str = this.param.getPathName() + "/" + ViewUtil.getNextFileName(new File(this.param.getPathName()), this.param.getPrefix(), enfiletype);
                } else {
                    str = this.param.getPathName() + "/" + this.param.getPrefix() + "." + enfiletype.value2;
                }
                BusAnalyseViewModel busAnalyseViewModel = (BusAnalyseViewModel) ContextUtil.getAppViewModel(BusAnalyseViewModel.class);
                if (busAnalyseViewModel == null || (value = busAnalyseViewModel.getLiveData().getValue()) == null) {
                    return;
                }
                if (value.getAnalyse_select() == 0) {
                    API.getInstance().UI_PostStr(48, MessageID.MSG_USB_ANALYSE_RESULT_SAVE, str);
                } else if (value.getAnalyse_select() == 1) {
                    API.getInstance().UI_PostStr(49, MessageID.MSG_ETH_ANALYSE_RESULT_SAVE, str);
                }
            } else if (this.param.getFileProc() == ServiceEnum.StorageFunc.FUNC_SAVE_FFT) {
                this.param.saveFFTSetting();
                this.param.doSave();
            } else if (this.param.getFileProc() == ServiceEnum.StorageFunc.FUNC_SAVE_BODE) {
                this.param.saveBODE();
                this.param.doSave();
            }
        }
    }

    public /* synthetic */ void lambda$onClick$0$SavePopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveFileType(ServiceEnum.getenFileTypeFromValue1(mappingObject.getValue()).value1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$onClick$1(File file) {
        return file != null && file.isDirectory();
    }

    public List<MappingObject> getFileTypeList(ServiceEnum.StorageFunc storageFunc, int i) {
        ArrayList arrayList = new ArrayList();
        List<MappingObject> list = ViewUtil.getList(i);
        switch (AnonymousClass2.$SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[storageFunc.ordinal()]) {
            case 1:
                for (MappingObject mappingObject : list) {
                    if (mappingObject.getValue() == ServiceEnum.enFileType.FILETYPE_REF.value1 || mappingObject.getValue() == ServiceEnum.enFileType.FILETYPE_BIN.value1 || mappingObject.getValue() == ServiceEnum.enFileType.FILETYPE_CSV.value1) {
                        arrayList.add(mappingObject);
                    }
                }
                break;
            case 2:
                for (MappingObject mappingObject2 : list) {
                    if (mappingObject2.getValue() == ServiceEnum.enFileType.FILETYPE_PF.value1) {
                        arrayList.add(mappingObject2);
                    }
                }
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                for (MappingObject mappingObject3 : list) {
                    if (mappingObject3.getValue() == ServiceEnum.enFileType.FILETYPE_CSV.value1) {
                        arrayList.add(mappingObject3);
                    }
                }
                break;
            case 7:
                for (MappingObject mappingObject4 : list) {
                    if (mappingObject4.getValue() == ServiceEnum.enFileType.FILETYPE_HTML.value1) {
                        arrayList.add(mappingObject4);
                    }
                }
                break;
            case 8:
                for (MappingObject mappingObject5 : list) {
                    if (mappingObject5.getValue() == ServiceEnum.enFileType.FILETYPE_HTML.value1 || mappingObject5.getValue() == ServiceEnum.enFileType.FILETYPE_CSV.value1) {
                        arrayList.add(mappingObject5);
                    }
                }
                break;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.save.SavePopupView$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc;

        static {
            int[] iArr = new int[ServiceEnum.StorageFunc.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc = iArr;
            try {
                iArr[ServiceEnum.StorageFunc.FUNC_SAVE_REF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_MSK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_FFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_DEC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_SEARCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_DECDAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_HTML.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_BODE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }
}
