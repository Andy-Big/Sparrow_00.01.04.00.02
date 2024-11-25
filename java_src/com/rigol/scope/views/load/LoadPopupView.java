package com.rigol.scope.views.load;

import android.view.LayoutInflater;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.DiskManageParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageLoadParam;
import com.rigol.scope.databinding.PopupviewLoadBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.diskManage.DiskManagePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes2.dex */
public class LoadPopupView extends BasePopupView implements View.OnClickListener {
    private String loadPath;
    private StorageLoadParam param;

    public LoadPopupView() {
        super((int) R.style.App_PopupWindow_Load);
        final PopupviewLoadBinding inflate = PopupviewLoadBinding.inflate(LayoutInflater.from(this.context));
        setContentView(inflate.getRoot());
        StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
        if (storageViewModel != null) {
            storageViewModel.getLoadLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.load.-$$Lambda$LoadPopupView$f6HHFrpbrkQJPzFd5Uczbff8rBU
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    LoadPopupView.this.lambda$new$0$LoadPopupView(inflate, (StorageLoadParam) obj);
                }
            });
        }
        inflate.fileFormatSpinner.setOnClickListener(this);
        inflate.filePathText.setOnClickListener(this);
        inflate.loadBtn.setOnClickListener(this);
    }

    public /* synthetic */ void lambda$new$0$LoadPopupView(PopupviewLoadBinding popupviewLoadBinding, StorageLoadParam storageLoadParam) {
        this.param = storageLoadParam;
        popupviewLoadBinding.setParam(storageLoadParam);
        this.loadPath = this.param.getPathName();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.file_format_spinner) {
            List<MappingObject> fileTypeList = getFileTypeList(this.param.getFileProc(), R.array.msg_storage_filetype);
            if (fileTypeList != null) {
                ViewUtil.showSpinner(this.anchor, view, fileTypeList, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.load.-$$Lambda$LoadPopupView$5HXKaYlTW_W5NFjH_MChCRKwCWA
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        LoadPopupView.this.lambda$onClick$1$LoadPopupView(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
            }
        } else if (id == R.id.file_path_text) {
            final ServiceEnum.enFileType enfiletype = ServiceEnum.getenFileTypeFromValue1(this.param.getFileType());
            FileFilter fileFilter = enfiletype != null ? new FileFilter() { // from class: com.rigol.scope.views.load.-$$Lambda$LoadPopupView$hrbXbA4tPHmSh2Xp8j3jcpDT2dg
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    return LoadPopupView.lambda$onClick$2(ServiceEnum.enFileType.this, file);
                }
            } : null;
            String pathName = this.param.getPathName();
            DiskManageParam.SelectionMode selectionMode = DiskManageParam.SelectionMode.FILE;
            final StorageLoadParam storageLoadParam = this.param;
            Objects.requireNonNull(storageLoadParam);
            ViewUtil.showDiskManage(pathName, selectionMode, fileFilter, new DiskManagePopupView.Callback() { // from class: com.rigol.scope.views.load.-$$Lambda$gdWAoUf1TpGS31Lcs9y1uuv3718
                @Override // com.rigol.scope.views.diskManage.DiskManagePopupView.Callback
                public final void onFolderSelected(String str) {
                    StorageLoadParam.this.savePathName(str);
                }
            });
        } else if (id == R.id.load_btn) {
            if (this.param.getFileProc() == ServiceEnum.StorageFunc.FUNC_LOAD_REF) {
                this.param.loadRefSetting();
                this.param.doLoad();
            } else if (this.param.getFileProc() == ServiceEnum.StorageFunc.FUNC_LOAD_MSK) {
                this.param.loadMaskSetting();
                this.param.doLoad();
            } else if (this.param.getFileProc() == ServiceEnum.StorageFunc.FUNC_LOAD_AFG) {
                this.param.loadAfg();
                this.param.doLoad();
            }
        }
    }

    public /* synthetic */ void lambda$onClick$1$LoadPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        ServiceEnum.enFileType enfiletype = ServiceEnum.getenFileTypeFromValue1(mappingObject.getValue());
        if (enfiletype != null) {
            this.param.saveFileType(enfiletype.value1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$onClick$2(ServiceEnum.enFileType enfiletype, File file) {
        if (file != null) {
            String path = file.getPath();
            if (path.endsWith("." + enfiletype.value2) || file.isDirectory()) {
                return true;
            }
        }
        return false;
    }

    public List<MappingObject> getFileTypeList(ServiceEnum.StorageFunc storageFunc, int i) {
        ArrayList arrayList = new ArrayList();
        List<MappingObject> list = ViewUtil.getList(i);
        int i2 = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[storageFunc.ordinal()];
        if (i2 == 1) {
            for (MappingObject mappingObject : list) {
                if (mappingObject.getValue() == ServiceEnum.enFileType.FILETYPE_REF.value1) {
                    arrayList.add(mappingObject);
                }
            }
        } else if (i2 == 2) {
            for (MappingObject mappingObject2 : list) {
                if (mappingObject2.getValue() == ServiceEnum.enFileType.FILETYPE_PF.value1) {
                    arrayList.add(mappingObject2);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.load.LoadPopupView$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc;

        static {
            int[] iArr = new int[ServiceEnum.StorageFunc.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc = iArr;
            try {
                iArr[ServiceEnum.StorageFunc.FUNC_LOAD_REF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_LOAD_MSK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        String str;
        super.dismiss();
        StorageLoadParam storageLoadParam = this.param;
        if (storageLoadParam == null || (str = this.loadPath) == null) {
            return;
        }
        storageLoadParam.setPathName(str);
    }
}
