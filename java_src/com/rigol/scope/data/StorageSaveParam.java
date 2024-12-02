package com.rigol.scope.data;

import android.text.TextUtils;
import android.view.View;
import androidx.databinding.Bindable;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.StringUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.FileSaveLoading;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.util.ToastUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class StorageSaveParam extends BaseParam {
    private static final boolean DEFAULT_AUTONAME = false;
    private static final int DEFAULT_CONNECT_STATE = 0;
    private static final boolean DEFAULT_IMAGECOLOR = false;
    private static final boolean DEFAULT_IMAGEHEADER = true;
    private static final boolean DEFAULT_IMAGEINVERT = false;
    private static final String DEFAULT_PREFIX = "RigolDS";
    private static final boolean DEFAULT_SMBEN = false;
    private static final String DEFAULT_SMB_DRIVE_LETTER = "";
    private static final String DEFAULT_SMB_PASSWORD = "";
    private static final String DEFAULT_SMB_SERVER_PATH = "";
    private static final String DEFAULT_SMB_USER_NAME = "";
    private static final int DEFAULT_WAVEDEPTH = 0;
    private boolean autoConnect;
    private boolean autoName;
    private int bodeFileType;
    private boolean chan1;
    private boolean chan2;
    private boolean chan3;
    private boolean chan4;
    private List<Integer> chanBit;
    private int channel;
    private ServiceEnum.StorageOperationChoose choose;
    private int connectState;
    private String decodeDataPath;
    private String fileName;
    private ServiceEnum.StorageFunc fileProc;
    private int fileType;
    private int group;
    private boolean imageColor;
    private int imageFileType;
    private boolean imageHeader;
    private boolean imageInvert;
    private int loadfileType;
    private final ServiceEnum.StorageOperation operation;
    private String password;
    private String pathName;
    private String prefix;
    private int progress;
    private int result;
    private String serverPath;
    private int setupFileType;
    private boolean smbEn;
    private String userName;
    private int waveDepth;
    private int waveFileType;
    private static final ServiceEnum.StorageOperation DEFAULT_OPERATION = ServiceEnum.StorageOperation.SAVE;
    private static final ServiceEnum.StorageOperationChoose DEFAULT_CHOOSE = ServiceEnum.StorageOperationChoose.IMAGE;
    private static final int DEFAULT_IMAGETYPE = ServiceEnum.enFileType.FILETYPE_PNG.value1;
    private static final int DEFAULT_WAVETYPE = ServiceEnum.enFileType.FILETYPE_BIN.value1;
    private static final int DEFAULT_SETUPTYPE = ServiceEnum.enFileType.FILETYPE_STP.value1;
    private static final ServiceEnum.StorageFunc DEFAULT_FILEPROC = ServiceEnum.StorageFunc.FUNC_SAVE_IMG;

    public StorageSaveParam() {
        super(12);
        this.operation = DEFAULT_OPERATION;
        this.choose = DEFAULT_CHOOSE;
        this.fileName = null;
        this.pathName = DiskManageParam.DEFAULT_PATH;
        this.fileType = 0;
        this.bodeFileType = 0;
        this.loadfileType = 0;
        this.autoName = false;
        this.prefix = DEFAULT_PREFIX;
        this.imageInvert = false;
        this.imageColor = false;
        this.imageHeader = true;
        this.waveDepth = 0;
        this.imageFileType = DEFAULT_IMAGETYPE;
        this.waveFileType = DEFAULT_WAVETYPE;
        this.setupFileType = DEFAULT_SETUPTYPE;
        this.fileProc = DEFAULT_FILEPROC;
        this.progress = 0;
        this.channel = 0;
        this.result = 0;
        this.chanBit = new ArrayList();
        this.chan1 = true;
        this.chan2 = false;
        this.chan3 = false;
        this.chan4 = false;
        this.group = 0;
        this.decodeDataPath = null;
        this.smbEn = false;
        this.autoConnect = false;
        this.connectState = 0;
        this.serverPath = "";
        this.userName = "";
        this.password = "";
    }

    public String getDecodeDataPath() {
        return this.decodeDataPath;
    }

    public void setDecodeDataPath(String str) {
        this.decodeDataPath = str;
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
    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
        notifyPropertyChanged(310);
    }

    @Bindable
    public String getPathName() {
        return this.pathName;
    }

    public void setPathName(String str) {
        log("pathName", this.pathName, str);
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

    public void setFileType(int i) {
        this.fileType = i;
        notifyPropertyChanged(311);
    }

    public void setBodeFileType(int i) {
        this.bodeFileType = i;
        notifyPropertyChanged(97);
        saveInt(MessageID.MSG_STORAGE_FILETYPE, i);
    }

    @Bindable
    public int getLoadFileType() {
        return this.loadfileType;
    }

    public void setLoadFileType(int i) {
        this.loadfileType = i;
        notifyPropertyChanged(504);
    }

    @Bindable
    public boolean isAutoName() {
        return this.autoName;
    }

    public void setAutoName(boolean z) {
        this.autoName = z;
        notifyPropertyChanged(60);
    }

    @Bindable
    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String str) {
        this.prefix = str;
        notifyPropertyChanged(654);
    }

    @Bindable
    public boolean isImageInvert() {
        return this.imageInvert;
    }

    public void setImageInvert(boolean z) {
        this.imageInvert = z;
        notifyPropertyChanged(430);
    }

    @Bindable
    public boolean isImageColor() {
        return this.imageColor;
    }

    public void setImageColor(boolean z) {
        this.imageColor = z;
        notifyPropertyChanged(427);
    }

    @Bindable
    public boolean isImageHeader() {
        return this.imageHeader;
    }

    public void setImageHeader(boolean z) {
        this.imageHeader = z;
        notifyPropertyChanged(429);
    }

    @Bindable
    public int getWaveDepth() {
        return this.waveDepth;
    }

    public void setWaveDepth(int i) {
        this.waveDepth = i;
        notifyPropertyChanged(1035);
    }

    @Bindable
    public int getImageFileType() {
        return this.imageFileType;
    }

    public void setImageFileType(int i) {
        this.imageFileType = i;
        notifyPropertyChanged(428);
        saveFileType(i);
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

    public int getResult() {
        return this.result;
    }

    public void setResult(int i) {
        this.result = i;
        if (isSaveOpertion(ServiceEnum.getStorageFuncFromValue1(readInt(MessageID.MSG_STORAGE_FILE_PROC)))) {
            if (i == 0) {
                saveSuccessToast();
            } else {
                saveFailToast();
            }
            BasePopupView basePopupView = PopupViewManager.getInstance().get(FileSaveLoading.class);
            if (basePopupView != null) {
                basePopupView.dismiss();
                syncData(MessageID.MSG_STORAGE_RESULT, null);
            }
            if (getGroup() != 0) {
                this.group = 0;
                ViewUtil.doSaveSetup();
            }
        }
    }

    public int getChannel() {
        return this.channel;
    }

    public void setChannel(int i) {
        this.channel = i;
    }

    @Bindable
    public boolean isChan1() {
        return this.chan1;
    }

    public void setChan1(boolean z) {
        this.chan1 = z;
        updateChanBitList();
        notifyPropertyChanged(153);
    }

    @Bindable
    public boolean isChan2() {
        return this.chan2;
    }

    public void setChan2(boolean z) {
        this.chan2 = z;
        updateChanBitList();
        notifyPropertyChanged(155);
    }

    @Bindable
    public boolean isChan3() {
        return this.chan3;
    }

    public void setChan3(boolean z) {
        this.chan3 = z;
        updateChanBitList();
        notifyPropertyChanged(157);
    }

    @Bindable
    public boolean isChan4() {
        return this.chan4;
    }

    public void setChan4(boolean z) {
        this.chan4 = z;
        updateChanBitList();
        notifyPropertyChanged(159);
    }

    public List<Integer> getChanBit() {
        return this.chanBit;
    }

    public void setChanBit(List<Integer> list) {
        this.chanBit = list;
    }

    public int getGroup() {
        return this.group;
    }

    public void setGroup(int i) {
        this.group = i;
    }

    @Bindable
    public boolean getSmbEn() {
        return this.smbEn;
    }

    public void setSmbEn(boolean z) {
        this.smbEn = z;
        notifyPropertyChanged(855);
    }

    @Bindable
    public boolean getAutoConnect() {
        return this.autoConnect;
    }

    public void setAutoConnect(boolean z) {
        this.autoConnect = z;
        notifyPropertyChanged(58);
    }

    @Bindable
    public int getConnectState() {
        return this.connectState;
    }

    public void setConnectState(int i) {
        this.connectState = i;
        notifyPropertyChanged(188);
    }

    @Bindable
    public String getServerPath() {
        return this.serverPath;
    }

    public void setServerPath(String str) {
        this.serverPath = str;
        notifyPropertyChanged(809);
    }

    @Bindable
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
        notifyPropertyChanged(1012);
    }

    @Bindable
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
        notifyPropertyChanged(601);
    }

    public void resetFileType() {
        setFileType(0);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readFileName();
        readFileType();
        readAutoName();
        readPrefix();
        readImageInvert();
        readImageColor();
        readImageHeader();
        readWaveDepth();
        readAutoConnect();
        readConnectState();
        readConnectStateRe();
        readServerPath();
        readUserName();
        readPassword();
    }

    public String readFileName() {
        setFileName(readStr(MessageID.MSG_STORAGE_FILENAME));
        return this.fileName;
    }

    public String readPathName() {
        setPathName(readStr(MessageID.MSG_STORAGE_PATHNAME));
        return this.pathName;
    }

    public int readFileType() {
        setFileType(readInt(MessageID.MSG_STORAGE_FILETYPE));
        return this.fileType;
    }

    public boolean readAutoName() {
        setAutoName(readBool(MessageID.MSG_STORAGE_OVERLAY));
        return this.autoName;
    }

    public String readPrefix() {
        setPrefix(readStr(MessageID.MSG_STORAGE_PREFIX));
        return this.prefix;
    }

    public int readImageFormat() {
        setImageFileType(readInt(MessageID.MSG_STORAGE_IMAGE_FORMAT));
        return this.imageFileType;
    }

    public boolean readImageInvert() {
        setImageInvert(readBool(MessageID.MSG_STORAGE_IMAGE_INVERT));
        return this.imageInvert;
    }

    public boolean readImageColor() {
        setImageColor(readBool(MessageID.MSG_STORAGE_IMAGE_COLOR));
        return this.imageColor;
    }

    public boolean readImageHeader() {
        setImageHeader(readBool(MessageID.MSG_STORAGE_IMAGE_HEADER));
        return this.imageHeader;
    }

    public int readWaveDepth() {
        setWaveDepth(readInt(MessageID.MSG_STORAGE_WAVE_DEPTH));
        return this.waveDepth;
    }

    public ServiceEnum.StorageFunc readFileProc() {
        setFileProc(ServiceEnum.getStorageFuncFromValue1(readInt(MessageID.MSG_STORAGE_FILE_PROC)));
        return this.fileProc;
    }

    public int readProgress() {
        setProgress(readInt(MessageID.MSG_STORAGE_PROGRESS_NOW));
        return this.progress;
    }

    public int readChannel() {
        setChannel(readInt(MessageID.MSG_STORAGE_CHANNEL));
        return this.channel;
    }

    public boolean readSmbEn() {
        setSmbEn(readBool(MessageID.MSG_STORAGE_SMB_EN));
        return this.smbEn;
    }

    public boolean readAutoConnect() {
        setAutoConnect(readBool(MessageID.MSG_STORAGE_AUTO_CONNECT));
        return this.autoConnect;
    }

    public int readConnectState() {
        setConnectState(readInt(MessageID.MSG_STORAGE_CONNECT_STATE));
        return this.connectState;
    }

    public int readConnectStateRe() {
        if (this.connectState == 0) {
            ToastUtils.showShort("Connection Terminated");
        } else {
            ToastUtils.showShort("Connection Successful");
        }
        return this.connectState;
    }

    public String readServerPath() {
        setServerPath(readStr(MessageID.MSG_STORAGE_SERVER_PATH));
        return this.serverPath;
    }

    public String readUserName() {
        setUserName(readStr(MessageID.MSG_STORAGE_USER_NAME));
        return this.userName;
    }

    public String readPassword() {
        setPassword(readStr(MessageID.MSG_STORAGE_PASSWORD));
        return this.password;
    }

    public int readResult() {
        setResult(readInt(MessageID.MSG_STORAGE_RESULT));
        return this.result;
    }

    public void saveFileName(String str) {
        setFileName(str);
        saveStr(MessageID.MSG_STORAGE_FILENAME, str);
    }

    public void savePathName(String str) {
        setPathName(str);
        saveStr(MessageID.MSG_STORAGE_PATHNAME, str);
    }

    public void saveFileType(int i) {
        setFileType(i);
        saveInt(MessageID.MSG_STORAGE_FILETYPE, i);
    }

    public void saveAutoName(boolean z) {
        setAutoName(z);
        saveBool(MessageID.MSG_STORAGE_OVERLAY, z);
    }

    public void savePrefix(String str) {
        setPrefix(str);
        saveStr(MessageID.MSG_STORAGE_PREFIX, str);
    }

    public void saveImageInvert(boolean z) {
        setImageInvert(z);
        saveBool(MessageID.MSG_STORAGE_IMAGE_INVERT, z);
    }

    public void saveImageColor(boolean z) {
        setImageColor(z);
        saveBool(MessageID.MSG_STORAGE_IMAGE_COLOR, z);
    }

    public void saveImageHeader(boolean z) {
        setImageHeader(z);
        saveBool(MessageID.MSG_STORAGE_IMAGE_HEADER, z);
    }

    public void saveWaveDepth(int i) {
        setWaveDepth(i);
        saveInt(MessageID.MSG_STORAGE_WAVE_DEPTH, i);
    }

    public void saveFileProc(ServiceEnum.StorageFunc storageFunc) {
        setFileProc(storageFunc);
        saveInt(MessageID.MSG_STORAGE_FILE_PROC, storageFunc.value1);
    }

    public void saveChannel(int i) {
        if (i == 0) {
            setChan1(true);
            return;
        }
        setChannel(i);
        saveInt(MessageID.MSG_STORAGE_CHANNEL, i);
    }

    public void doSave() {
        saveInt(MessageID.MSG_STORAGE_SAVE, 0);
    }

    public void saveCancel() {
        saveBool(MessageID.MSG_STORAGE_CANCEL, true);
    }

    public void updateChanBitList() {
        if (getChanBit().size() != 5) {
            List<Integer> bitsFromValue = ViewUtil.getBitsFromValue(0);
            this.chanBit = bitsFromValue;
            this.chanBit = ViewUtil.checkLengthIfNotEnoughThenAdd(bitsFromValue, 5);
        }
        if (this.chan1) {
            getChanBit().set(1, 1);
        } else {
            getChanBit().set(1, 0);
        }
        if (!this.chan2) {
            getChanBit().set(2, 0);
        } else {
            getChanBit().set(2, 1);
        }
        if (!this.chan3) {
            getChanBit().set(3, 0);
        } else {
            getChanBit().set(3, 1);
        }
        if (!this.chan4) {
            getChanBit().set(4, 0);
        } else {
            getChanBit().set(4, 1);
        }
        saveChannel(ViewUtil.getValueFromBits(getChanBit()));
    }

    public void screenShotSetting() {
        String str;
        saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_IMG);
        savePathName(getPathName());
        savePrefix(this.prefix);
        saveFileType(getImageFileType());
        ServiceEnum.enFileType enfiletype = ServiceEnum.getenFileTypeFromValue1(getImageFileType());
        if (enfiletype == null) {
            return;
        }
        if (!readAutoName()) {
            str = ViewUtil.getNextFileName(new File(getPathName()), getPrefix(), enfiletype);
        } else {
            str = getPrefix() + "." + enfiletype.value2;
        }
        saveFileName(str);
        ToastUtils.showLong(StringUtils.getString(R.string.msg_storage_toast_save_success) + ViewUtil.getDiskUIPathName(getPathName()) + "\\" + ViewUtil.getDiskUIPathName(str));
    }

    public void screenShotSetting_scpi(String str, String str2, int i) {
        saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_IMG);
        savePathName(str);
        saveFileType(i);
        saveFileName(handleFileName(str, str2, i));
    }

    private String handleFileName(String str, String str2, int i) {
        if (isAutoName()) {
            return str2;
        }
        ServiceEnum.enFileType enfiletype = ServiceEnum.getenFileTypeFromValue1(i);
        String lowerCase = str2.toLowerCase();
        if (lowerCase.endsWith("." + ServiceEnum.enFileType.FILETYPE_PNG.value2)) {
            str2 = str2.replace("." + ServiceEnum.enFileType.FILETYPE_PNG.value2, "");
        } else {
            String lowerCase2 = str2.toLowerCase();
            if (lowerCase2.endsWith("." + ServiceEnum.enFileType.FILETYPE_BMP.value2)) {
                str2 = str2.replace("." + ServiceEnum.enFileType.FILETYPE_BMP.value2, "");
            } else {
                String lowerCase3 = str2.toLowerCase();
                if (lowerCase3.endsWith("." + ServiceEnum.enFileType.FILETYPE_JPG.value2)) {
                    str2 = str2.replace("." + ServiceEnum.enFileType.FILETYPE_JPG.value2, "");
                } else {
                    String lowerCase4 = str2.toLowerCase();
                    if (lowerCase4.endsWith("." + ServiceEnum.enFileType.FILETYPE_BIN.value2)) {
                        str2 = str2.replace("." + ServiceEnum.enFileType.FILETYPE_BIN.value2, "");
                    } else {
                        String lowerCase5 = str2.toLowerCase();
                        if (lowerCase5.endsWith("." + ServiceEnum.enFileType.FILETYPE_CSV.value2)) {
                            str2 = str2.replace("." + ServiceEnum.enFileType.FILETYPE_CSV.value2, "");
                        } else {
                            String lowerCase6 = str2.toLowerCase();
                            if (lowerCase6.endsWith("." + ServiceEnum.enFileType.FILETYPE_WFM.value2)) {
                                str2 = str2.replace("." + ServiceEnum.enFileType.FILETYPE_WFM.value2, "");
                            } else {
                                String lowerCase7 = str2.toLowerCase();
                                if (lowerCase7.endsWith("." + ServiceEnum.enFileType.FILETYPE_STP.value2)) {
                                    str2 = str2.replace("." + ServiceEnum.enFileType.FILETYPE_STP.value2, "");
                                }
                            }
                        }
                    }
                }
            }
        }
        return ViewUtil.getNextFileName(new File(str), str2, enfiletype);
    }

    public void saveWaveSetting() {
        String str;
        saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_WAV);
        savePathName(getPathName());
        savePrefix(this.prefix);
        saveFileType(getWaveFileType());
        ServiceEnum.enFileType enfiletype = ServiceEnum.getenFileTypeFromValue1(getWaveFileType());
        if (enfiletype == null) {
            return;
        }
        if (!readAutoName()) {
            str = ViewUtil.getNextFileName(new File(getPathName()), getPrefix(), enfiletype);
        } else {
            str = getPrefix() + "." + enfiletype.value2;
        }
        saveFileName(str);
        PopupViewManager.getInstance().toggle(FileSaveLoading.class);
        final BasePopupView basePopupView = PopupViewManager.getInstance().get(FileSaveLoading.class);
        ((FileSaveLoading) basePopupView).setCancelListener(new View.OnClickListener() { // from class: com.rigol.scope.data.-$$Lambda$StorageSaveParam$X3YmFfGaCz_Kk28tNTxv3QZ14YM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StorageSaveParam.this.lambda$saveWaveSetting$0$StorageSaveParam(basePopupView, view);
            }
        });
    }

    public /* synthetic */ void lambda$saveWaveSetting$0$StorageSaveParam(BasePopupView basePopupView, View view) {
        basePopupView.dismiss();
        saveCancel();
    }

    public void saveWaveSetting_scpi(String str, String str2, int i, int i2) {
        setChoose(ServiceEnum.StorageOperationChoose.WAVE);
        saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_WAV);
        savePathName(str);
        saveFileType(i);
        saveWaveDepth(i2);
        saveFileName(handleFileName(str, str2, i));
        PopupViewManager.getInstance().toggle(FileSaveLoading.class);
    }

    public void saveSetupSetting() {
        String str;
        saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_STP);
        savePathName(getPathName());
        savePrefix(this.prefix);
        saveFileType(getSetupFileType());
        ServiceEnum.enFileType enfiletype = ServiceEnum.getenFileTypeFromValue1(getSetupFileType());
        if (enfiletype == null) {
            return;
        }
        if (!readAutoName()) {
            str = ViewUtil.getNextFileName(new File(getPathName()), getPrefix(), enfiletype);
        } else {
            str = getPrefix() + "." + enfiletype.value2;
        }
        saveFileName(str);
        PopupViewManager.getInstance().toggle(FileSaveLoading.class);
    }

    public void saveSetupSetting_scpi(String str, String str2) {
        saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_STP);
        setFileType(ServiceEnum.enFileType.FILETYPE_STP.value1);
        savePathName(str);
        saveFileName(handleFileName(str, str2, ServiceEnum.enFileType.FILETYPE_STP.value1));
        setChoose(ServiceEnum.StorageOperationChoose.SETUP);
        PopupViewManager.getInstance().toggle(FileSaveLoading.class);
    }

    public void saveRefSetting() {
        String str;
        saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_REF);
        savePathName(getPathName());
        savePrefix(this.prefix);
        saveFileType(getFileType());
        ServiceEnum.enFileType enfiletype = ServiceEnum.getenFileTypeFromValue1(getFileType());
        if (enfiletype == null) {
            return;
        }
        if (!readAutoName()) {
            str = ViewUtil.getNextFileName(new File(getPathName()), getPrefix(), enfiletype);
        } else {
            str = getPrefix() + "." + enfiletype.value2;
        }
        saveFileName(str);
        PopupViewManager.getInstance().toggle(FileSaveLoading.class);
    }

    public void saveMaskSetting() {
        String str;
        saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_MSK);
        savePathName(getPathName());
        savePrefix(this.prefix);
        saveFileType(getFileType());
        ServiceEnum.enFileType enfiletype = ServiceEnum.getenFileTypeFromValue1(getFileType());
        if (enfiletype == null) {
            return;
        }
        if (!readAutoName()) {
            str = ViewUtil.getNextFileName(new File(getPathName()), getPrefix(), enfiletype);
        } else {
            str = getPrefix() + "." + enfiletype.value2;
        }
        saveFileName(str);
        PopupViewManager.getInstance().toggle(FileSaveLoading.class);
    }

    public void saveFFTSetting() {
        String str;
        saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_FFT);
        savePathName(getPathName());
        savePrefix(this.prefix);
        saveFileType(getFileType());
        ServiceEnum.enFileType enfiletype = ServiceEnum.getenFileTypeFromValue1(getFileType());
        if (enfiletype == null) {
            return;
        }
        if (!readAutoName()) {
            str = ViewUtil.getNextFileName(new File(getPathName()), getPrefix(), enfiletype);
        } else {
            str = getPrefix() + "." + enfiletype.value2;
        }
        saveFileName(str);
        PopupViewManager.getInstance().toggle(FileSaveLoading.class);
    }

    public void saveBODE() {
        String str;
        saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_BODE);
        savePathName(getPathName());
        savePrefix(this.prefix);
        saveFileType(getFileType());
        ServiceEnum.enFileType enfiletype = ServiceEnum.getenFileTypeFromValue1(getFileType());
        if (enfiletype == null) {
            return;
        }
        if (!readAutoName()) {
            str = ViewUtil.getNextFileName(new File(getPathName()), getPrefix(), enfiletype);
        } else {
            str = getPrefix() + "." + enfiletype.value2;
        }
        saveFileName(str);
        PopupViewManager.getInstance().toggle(FileSaveLoading.class);
    }

    public void saveSmbEn(boolean z) {
        setSmbEn(z);
        saveBool(MessageID.MSG_STORAGE_SMB_EN, z);
    }

    public void saveAutoConnect(boolean z) {
        setAutoConnect(z);
        saveBool(MessageID.MSG_STORAGE_AUTO_CONNECT, z);
    }

    public void saveConnectState(int i) {
        setConnectState(i);
        saveInt(MessageID.MSG_STORAGE_CONNECT_STATE, i);
    }

    public void saveServerPath(String str) {
        setServerPath(str);
        saveStr(MessageID.MSG_STORAGE_SERVER_PATH, str);
    }

    public void saveUserName(String str) {
        setUserName(str);
        saveStr(MessageID.MSG_STORAGE_USER_NAME, str);
    }

    public void savePassword(String str) {
        setPassword(str);
        saveStr(MessageID.MSG_STORAGE_PASSWORD, str);
    }

    public void saveSuccessToast() {
        if (ServiceEnum.getenFileTypeFromValue1(getFileType()) == null || TextUtils.isEmpty(this.fileName)) {
            return;
        }
        String diskUIPathName = ViewUtil.getDiskUIPathName(getPathName() + File.separator + this.fileName);
        String string = ActivityUtils.getTopActivity().getString(R.string.msg_storage_toast_save_success);
        ToastUtils.showLong(string + diskUIPathName);
    }

    public void saveFailToast() {
        ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.msg_storage_toast_fail));
    }

    /* renamed from: com.rigol.scope.data.StorageSaveParam$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc;

        static {
            int[] iArr = new int[ServiceEnum.StorageFunc.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc = iArr;
            try {
                iArr[ServiceEnum.StorageFunc.FUNC_SAVE_IMG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_STP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_REF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_MSK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_ARB.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_REC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_DEC.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_DG.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_DECDAT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_SEARCH.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_FFT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_DDR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_WAV.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$StorageFunc[ServiceEnum.StorageFunc.FUNC_SAVE_BODE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public boolean isSaveOpertion(ServiceEnum.StorageFunc storageFunc) {
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
            case 12:
            case 13:
            case 14:
                return true;
            default:
                return false;
        }
    }

    public String toString() {
        return "StorageSaveParam{operation=" + this.operation + ", choose=" + this.choose + ", fileName='" + this.fileName + "', pathName='" + this.pathName + "', fileType=" + this.fileType + ", autoName=" + this.autoName + ", prefix='" + this.prefix + "', imageInvert=" + this.imageInvert + ", imageColor=" + this.imageColor + ", imageHeader=" + this.imageHeader + ", waveDepth=" + this.waveDepth + '}';
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        setChoose(DEFAULT_CHOOSE);
        setAutoName(false);
        setPrefix(DEFAULT_PREFIX);
        setImageInvert(false);
        setImageColor(false);
        setImageHeader(true);
        setWaveDepth(0);
        setImageFileType(DEFAULT_IMAGETYPE);
        setWaveFileType(DEFAULT_WAVETYPE);
        setSetupFileType(DEFAULT_SETUPTYPE);
        setFileProc(DEFAULT_FILEPROC);
        setPathName(DiskManageParam.DEFAULT_PATH);
    }
}
