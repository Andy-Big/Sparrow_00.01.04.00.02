package com.rigol.scope.data;

import androidx.databinding.Bindable;
import androidx.lifecycle.ViewModelProvider;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewModelManager;
import com.rigol.scope.views.FileLoadLoading;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.util.ToastUtils;

/* loaded from: classes2.dex */
public class StorageLoadParam extends BaseParam {
    private int bodeFileType;
    private ServiceEnum.StorageOperationChoose choose;
    private String fileName;
    private ServiceEnum.StorageFunc fileProc;
    private int fileType;
    private String pathName;
    private int progress;
    private int result;
    private int setbodeFileType;
    private int setupFileType;
    private int waveFileType;

    public StorageLoadParam() {
        super(12);
        this.choose = ServiceEnum.StorageOperationChoose.SETUP;
        this.waveFileType = ServiceEnum.enFileType.FILETYPE_WFM.value1;
        this.setupFileType = ServiceEnum.enFileType.FILETYPE_STP.value1;
        int i = ServiceEnum.enFileType.FILETYPE_CSV.value1;
        this.setbodeFileType = i;
        this.pathName = null;
        this.fileType = this.setupFileType;
        this.bodeFileType = i;
        this.fileProc = ServiceEnum.StorageFunc.FUNC_LOAD_STP;
        this.progress = 0;
        this.result = 0;
        this.fileName = null;
    }

    @Bindable
    public ServiceEnum.StorageOperationChoose getChoose() {
        return this.choose;
    }

    public void setChoose(ServiceEnum.StorageOperationChoose storageOperationChoose) {
        this.choose = storageOperationChoose;
        notifyPropertyChanged(178);
    }

    @Bindable
    public int getWaveFileType() {
        return this.waveFileType;
    }

    public void setWaveFileType(int i) {
        this.waveFileType = i;
        notifyPropertyChanged(1036);
        saveFileType(i);
    }

    @Bindable
    public int getSetupFileType() {
        return this.setupFileType;
    }

    public void setSetupFileType(int i) {
        this.setupFileType = i;
        notifyPropertyChanged(814);
        saveFileType(i);
    }

    @Bindable
    public String getPathName() {
        return this.pathName;
    }

    public void setPathName(String str) {
        this.pathName = str;
        notifyPropertyChanged(603);
    }

    @Bindable
    public int getFileType() {
        return this.fileType;
    }

    @Bindable
    public int getBodeFileType() {
        return this.bodeFileType;
    }

    public void setBodeFileType(int i) {
        this.bodeFileType = i;
        notifyPropertyChanged(97);
    }

    public void setFileType(int i) {
        this.fileType = i;
        notifyPropertyChanged(311);
    }

    public ServiceEnum.StorageFunc getFileProc() {
        return this.fileProc;
    }

    public void setFileProc(ServiceEnum.StorageFunc storageFunc) {
        this.fileProc = storageFunc;
    }

    @Bindable
    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int i) {
        this.progress = i;
        notifyPropertyChanged(671);
    }

    @Bindable
    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
        notifyPropertyChanged(310);
    }

    public int getResult() {
        return this.result;
    }

    public void setResult(int i) {
        this.result = i;
        ServiceEnum.StorageFunc storageFuncFromValue1 = ServiceEnum.getStorageFuncFromValue1(readInt(MessageID.MSG_STORAGE_FILE_PROC));
        if (isLoadOpertion(storageFuncFromValue1)) {
            if (i == 0) {
                loadSuccessToast();
                if (storageFuncFromValue1 == ServiceEnum.StorageFunc.FUNC_LOAD_STP) {
                    ThreadUtils.runOnUiThread(new Runnable() { // from class: com.rigol.scope.data.-$$Lambda$StorageLoadParam$XICN7HKJkmMIIInWoLYkw_ZRZxY
                        @Override // java.lang.Runnable
                        public final void run() {
                            StorageLoadParam.lambda$setResult$0();
                        }
                    });
                }
            } else {
                loadFailToast();
            }
            BasePopupView basePopupView = PopupViewManager.getInstance().get(FileLoadLoading.class);
            if (basePopupView != null) {
                basePopupView.dismiss();
            }
        }
    }

    static /* synthetic */ void lambda$setResult$0() {
        ViewModelProvider appViewModelProvider = ContextUtil.getAppViewModelProvider();
        if (appViewModelProvider != null) {
            ViewModelManager.INSTANCE.readAll(appViewModelProvider);
        }
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readPathName();
    }

    public int readWaveFileType() {
        setWaveFileType(readInt(MessageID.MSG_STORAGE_WAVE_FORMAT));
        return this.waveFileType;
    }

    public int readSetupFileType() {
        setSetupFileType(readInt(MessageID.MSG_STORAGE_SCR_FORMAT));
        return this.setupFileType;
    }

    public String readPathName() {
        setPathName(readStr(MessageID.MSG_STORAGE_PATHNAME));
        return this.pathName;
    }

    public ServiceEnum.StorageFunc readFileProc() {
        setFileProc(ServiceEnum.getStorageFuncFromValue1(readInt(MessageID.MSG_STORAGE_FILE_PROC)));
        return this.fileProc;
    }

    public int readProgress() {
        setProgress(readInt(MessageID.MSG_STORAGE_PROGRESS_NOW));
        return this.progress;
    }

    public String readFileName() {
        setFileName(readStr(MessageID.MSG_STORAGE_FILENAME));
        return this.fileName;
    }

    public void readResult() {
        setResult(readInt(MessageID.MSG_STORAGE_RESULT));
    }

    public void savePathName(String str) {
        setPathName(str);
        saveStr(MessageID.MSG_STORAGE_PATHNAME, str);
    }

    public void saveFileType(int i) {
        setFileType(i);
        saveInt(MessageID.MSG_STORAGE_FILETYPE, i);
    }

    public void saveFileProc(ServiceEnum.StorageFunc storageFunc) {
        setFileProc(storageFunc);
        saveInt(MessageID.MSG_STORAGE_FILE_PROC, storageFunc.value1);
    }

    public void saveFileName(String str) {
        setFileName(str);
        saveStr(MessageID.MSG_STORAGE_FILENAME, str);
    }

    public void doLoad() {
        saveInt(MessageID.MSG_STORAGE_LOAD, 0);
    }

    public void loadWaveSetting() {
        saveFileProc(ServiceEnum.StorageFunc.FUNC_LOAD_WAV);
        saveFileType(getWaveFileType());
        saveFileName("");
        savePathName(getPathName());
        PopupViewManager.getInstance().toggle(FileLoadLoading.class);
    }

    public void loadSetupSetting() {
        saveFileProc(ServiceEnum.StorageFunc.FUNC_LOAD_STP);
        saveFileType(getSetupFileType());
        saveFileName("");
        savePathName(getPathName());
        PopupViewManager.getInstance().toggle(FileLoadLoading.class);
    }

    public void loadSetupSetting_scpi(String str, String str2) {
        saveFileProc(ServiceEnum.StorageFunc.FUNC_LOAD_STP);
        saveFileType(ServiceEnum.enFileType.FILETYPE_STP.value1);
        saveFileName(str2);
        savePathName(str);
        PopupViewManager.getInstance().toggle(FileLoadLoading.class);
    }

    public void loadRefSetting() {
        saveFileProc(ServiceEnum.StorageFunc.FUNC_LOAD_REF);
        saveFileType(getFileType());
        saveFileName("");
        savePathName(getPathName());
        PopupViewManager.getInstance().toggle(FileLoadLoading.class);
    }

    public void loadMaskSetting() {
        saveFileProc(ServiceEnum.StorageFunc.FUNC_LOAD_MSK);
        saveFileType(getFileType());
        saveFileName("");
        savePathName(getPathName());
        PopupViewManager.getInstance().toggle(FileLoadLoading.class);
    }

    public void loadSuccessToast() {
        ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.msg_storage_toast_success));
    }

    public void loadFailToast() {
        ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.msg_storage_toast_fail));
    }

    /* renamed from: com.rigol.scope.data.StorageLoadParam$1 */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc;

        static {
            int[] iArr = new int[ServiceEnum.StorageFunc.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc = iArr;
            try {
                iArr[ServiceEnum.StorageFunc.FUNC_LOAD_ARB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_LOAD_ATT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_LOAD_DDR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_LOAD_GEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_LOAD_MSK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_LOAD_REF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_LOAD_SCR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_LOAD_STP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_LOAD_WAV.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_LOAD_BODE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_LOAD_AFG.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public boolean isLoadOpertion(ServiceEnum.StorageFunc storageFunc) {
        if (storageFunc == null) {
            return false;
        }
        switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[storageFunc.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return true;
            default:
                return false;
        }
    }

    public void loadBode() {
        saveFileProc(ServiceEnum.StorageFunc.FUNC_LOAD_BODE);
        saveFileType(getFileType());
        saveFileName("");
        savePathName(getPathName());
        PopupViewManager.getInstance().toggle(FileLoadLoading.class);
    }

    public void loadAfg() {
        saveFileProc(ServiceEnum.StorageFunc.FUNC_LOAD_AFG);
        saveFileType(ServiceEnum.enFileType.FILETYPE_CSV.value1);
        saveFileName("");
        savePathName(getPathName());
        PopupViewManager.getInstance().toggle(FileLoadLoading.class);
    }
}
