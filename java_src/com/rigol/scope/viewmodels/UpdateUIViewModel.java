package com.rigol.scope.viewmodels;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ShellUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.rigol.scope.BaseActivity;
import com.rigol.scope.BaseApplicationContext;
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.adapters.ResultListAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AfgParam;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.data.CalibrationParam;
import com.rigol.scope.data.CounterResultParam;
import com.rigol.scope.data.CursorResultParam;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.DiskManageParam;
import com.rigol.scope.data.DiskParam;
import com.rigol.scope.data.DiskParamKt;
import com.rigol.scope.data.DisplayParam;
import com.rigol.scope.data.DvmResultParam;
import com.rigol.scope.data.EyeParam;
import com.rigol.scope.data.EyeResultParam;
import com.rigol.scope.data.FftParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.IOParam;
import com.rigol.scope.data.JitterParam;
import com.rigol.scope.data.JitterResultParam;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.data.MaskParam;
import com.rigol.scope.data.MaskResultParam;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.data.MeasureResultParam;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.NavigateParam;
import com.rigol.scope.data.OptionParam;
import com.rigol.scope.data.RefParam;
import com.rigol.scope.data.RtsaMarkerResultParam;
import com.rigol.scope.data.SearchParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.StorageLoadParam;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.data.UpaParam;
import com.rigol.scope.data.UpaRippleParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.data.WaveRecordParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.data.XYParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.ImageUtil;
import com.rigol.scope.utilities.KtUtilKt;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.SystemUtil;
import com.rigol.scope.utilities.UtilityUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import com.rigol.scope.views.AnalysingPopupView;
import com.rigol.scope.views.DeletingLoading;
import com.rigol.scope.views.FileSaveLoading;
import com.rigol.scope.views.SavingLoading;
import com.rigol.scope.views.analyse.AnalyseEthResultPopupView;
import com.rigol.scope.views.analyse.AnalyseRemindPopupView;
import com.rigol.scope.views.analyse.AnalyseUsbResultPopupView;
import com.rigol.scope.views.auto.AutosetParam;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.baseview.OrientationView;
import com.rigol.scope.views.calibration.CalibrationPopupView;
import com.rigol.scope.views.decode.DecodeNewPopupView;
import com.rigol.scope.views.histogram.HistogramResultParam;
import com.rigol.scope.views.histogram.MeasHistogramResultParam;
import com.rigol.scope.views.la.LapopupView;
import com.rigol.scope.views.mask.MaskPopupView;
import com.rigol.scope.views.math.MathPopupView;
import com.rigol.scope.views.math.MathRecyclerView;
import com.rigol.scope.views.measure.MeasurePopupView;
import com.rigol.scope.views.navigate.NavigatePopupView;
import com.rigol.scope.views.probe.ProbePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.scope.views.trigger.TriggerPopupView;
import com.rigol.util.ToastUtils;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import timber.log.Timber;
/* loaded from: classes2.dex */
public class UpdateUIViewModel extends ViewModel {
    private SharedParam sharedParam;
    private final Map<String, MutableLiveData<Boolean>> bus = new HashMap();
    private Handler mHandler = new Handler();
    private boolean isReceived = true;

    public MutableLiveData<Boolean> get(int i, int i2) {
        return get(MessageBus.getKey(i, i2));
    }

    public MutableLiveData<Boolean> get(int i, int i2, int i3) {
        return get(MessageBus.getKey(i, i2, i3));
    }

    public MutableLiveData<Boolean> get(String str) {
        if (!isContainsKey(str)) {
            put(str);
        }
        return this.bus.get(str);
    }

    public void put(String str) {
        this.bus.put(str, new MutableLiveData<>());
    }

    public void remove(final String str) {
        this.bus.entrySet().removeIf(new Predicate() { // from class: com.rigol.scope.viewmodels.-$$Lambda$UpdateUIViewModel$k9DbCUNDOb5Ly-4_K0ILmMhfhgQ
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean equals;
                equals = ((String) ((Map.Entry) obj).getKey()).equals(str);
                return equals;
            }
        });
    }

    public boolean isContainsKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.bus.containsKey(str);
    }

    public void bindAll(BaseActivity baseActivity, ViewModelProvider viewModelProvider) {
        bind(baseActivity, ((FftViewModel) viewModelProvider.get(FftViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((SearchViewModel) viewModelProvider.get(SearchViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((CursorViewModel) viewModelProvider.get(CursorViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((CounterViewModel) viewModelProvider.get(CounterViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((DvmViewModel) viewModelProvider.get(DvmViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((DisplayViewModel) viewModelProvider.get(DisplayViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((UtilityViewModel) viewModelProvider.get(UtilityViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((AutosetViewModel) viewModelProvider.get(AutosetViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((MeasureSettingViewModel) viewModelProvider.get(MeasureSettingViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((RefViewModel) viewModelProvider.get(RefViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((MaskViewModel) viewModelProvider.get(MaskViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((WaveRecordViewModel) viewModelProvider.get(WaveRecordViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((StorageViewModel) viewModelProvider.get(StorageViewModel.class)).getLoadLiveData().getValue());
        bind(baseActivity, ((StorageViewModel) viewModelProvider.get(StorageViewModel.class)).getSaveLiveData().getValue());
        bind(baseActivity, ((CalibrationViewModel) viewModelProvider.get(CalibrationViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((EyeViewModel) viewModelProvider.get(EyeViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((XYViewModel) viewModelProvider.get(XYViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((JitterViewModel) viewModelProvider.get(JitterViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((IOViewModel) viewModelProvider.get(IOViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((NavigateViewModel) viewModelProvider.get(NavigateViewModel.class)).getLiveData().getValue());
        bind(baseActivity, (UpaViewModel) viewModelProvider.get(UpaViewModel.class));
        bind(baseActivity, ((UpaViewRippleModel) viewModelProvider.get(UpaViewRippleModel.class)).getLiveData().getValue());
        bind(baseActivity, ((com.rigol.scope.views.histogram.HistogramViewModel) viewModelProvider.get(com.rigol.scope.views.histogram.HistogramViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((LaViewModel) viewModelProvider.get(LaViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((BodeViewModel) viewModelProvider.get(BodeViewModel.class)).getLiveData().getValue());
        bind(baseActivity, ((AfgViewModel) viewModelProvider.get(AfgViewModel.class)).getLiveData().getValue());
        ArrayList<DecodeParam> value = ((DecodeViewModel) viewModelProvider.get(DecodeViewModel.class)).getLiveData().getValue();
        if (value != null) {
            for (DecodeParam decodeParam : value) {
                bind(baseActivity, decodeParam);
            }
        }
        get(12, MessageID.MSG_RESTORE_DEFAULT).observe(baseActivity, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (ViewUtil.isCalibrationStarted()) {
                    return;
                }
                KtUtilKt.resetAll();
            }
        });
        get(12, MessageID.MSG_STORAGE_RESULT).observe(baseActivity, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.2
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DiskManageParam value2;
                BasePopupView basePopupView = PopupViewManager.getInstance().get(DeletingLoading.class);
                if (basePopupView != null) {
                    basePopupView.dismiss();
                }
                BasePopupView basePopupView2 = PopupViewManager.getInstance().get(FileSaveLoading.class);
                if (basePopupView2 != null) {
                    basePopupView2.dismiss();
                }
                if (ServiceEnum.getStorageFuncFromValue1(API.getInstance().UI_QueryInt32(12, MessageID.MSG_STORAGE_FILE_PROC)) == ServiceEnum.StorageFunc.FUNC_SECURITYCLEAR) {
                    if (API.getInstance().UI_QueryInt32(12, MessageID.MSG_STORAGE_RESULT) == 0) {
                        ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.msg_storage_toast_success));
                        DiskManageViewModel diskManageViewModel = (DiskManageViewModel) ContextUtil.getAppViewModel(DiskManageViewModel.class);
                        if (diskManageViewModel == null || (value2 = diskManageViewModel.getLiveData().getValue()) == null) {
                            return;
                        }
                        value2.loadFiles();
                        return;
                    }
                    ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.msg_storage_toast_fail));
                }
            }
        });
        get(12, MessageID.MSG_STORAGE_PRNTSCR).observe(baseActivity, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.3
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                String UI_QueryStr = API.getInstance().UI_QueryStr(12, MessageID.MSG_STORAGE_PULLSCR);
                try {
                    Bitmap screenshot = ImageUtil.screenshot(SystemUtil.getWindowManager(), SystemUtil.getDisplayManager());
                    if (screenshot == null || !ImageUtil.save(screenshot, UI_QueryStr)) {
                        return;
                    }
                    API.getInstance().UI_PostBool(12, MessageID.MSG_STORAGE_PULLSCR, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        get(12, MessageID.MSG_STORAGE_SAVE_IMAGE).observe(baseActivity, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.4
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                String replace;
                int i;
                String UI_QueryStr = API.getInstance().UI_QueryStr(12, MessageID.MSG_STORAGE_SAVE_IMAGE);
                if (UI_QueryStr.toLowerCase().startsWith("c:/")) {
                    replace = UI_QueryStr.toLowerCase().replace("c:", DiskManageParam.DEFAULT_PATH);
                } else {
                    int i2 = 0;
                    if (UI_QueryStr.toLowerCase().startsWith("d:/")) {
                        List<DiskParam> diskList = UtilityUtil.getDiskList();
                        while (i2 < diskList.size()) {
                            DiskParam diskParam = diskList.get(i2);
                            String shorterName = diskParam.getShorterName();
                            if (shorterName == null) {
                                return;
                            }
                            if (shorterName.startsWith("D:")) {
                                replace = UI_QueryStr.toLowerCase().replace("d:", diskParam.getPath());
                                break;
                            }
                            i2++;
                        }
                        replace = "";
                    } else {
                        if (UI_QueryStr.toLowerCase().startsWith("i:/")) {
                            List<DiskParam> diskList2 = UtilityUtil.getDiskList();
                            while (i2 < diskList2.size()) {
                                DiskParam diskParam2 = diskList2.get(i2);
                                String shorterName2 = diskParam2.getShorterName();
                                if (shorterName2 == null) {
                                    return;
                                }
                                if (shorterName2.startsWith("I:")) {
                                    replace = UI_QueryStr.toLowerCase().replace("i:", diskParam2.getPath());
                                    break;
                                }
                                i2++;
                            }
                        }
                        replace = "";
                    }
                }
                if ("".equals(replace)) {
                    return;
                }
                if (replace.toLowerCase().endsWith(".png")) {
                    i = ServiceEnum.enFileType.FILETYPE_PNG.value1;
                } else if (replace.toLowerCase().endsWith(".bmp")) {
                    i = ServiceEnum.enFileType.FILETYPE_BMP.value1;
                } else if (!replace.toLowerCase().endsWith(".jpg")) {
                    return;
                } else {
                    i = ServiceEnum.enFileType.FILETYPE_JPG.value1;
                }
                StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
                if (storageViewModel == null) {
                    return;
                }
                StorageSaveParam value2 = storageViewModel.getSaveLiveData().getValue();
                File file = new File(replace);
                if (value2 == null || file.getParentFile() == null) {
                    return;
                }
                value2.screenShotSetting_scpi(file.getParentFile().getPath(), file.getName(), i);
                ImageUtil.save(value2);
            }
        });
        get(12, MessageID.MSG_STORAGE_SAVE_SETUP).observe(baseActivity, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.5
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                String replace;
                StorageViewModel storageViewModel;
                String UI_QueryStr = API.getInstance().UI_QueryStr(12, MessageID.MSG_STORAGE_SAVE_SETUP);
                if (UI_QueryStr.toLowerCase().startsWith("c:/")) {
                    replace = UI_QueryStr.toLowerCase().replace("c:", DiskManageParam.DEFAULT_PATH);
                } else {
                    int i = 0;
                    if (UI_QueryStr.toLowerCase().startsWith("d:/")) {
                        List<DiskParam> diskList = UtilityUtil.getDiskList();
                        while (i < diskList.size()) {
                            DiskParam diskParam = diskList.get(i);
                            String shorterName = diskParam.getShorterName();
                            if (shorterName == null) {
                                return;
                            }
                            if (shorterName.startsWith("D:")) {
                                replace = UI_QueryStr.toLowerCase().replace("d:", diskParam.getPath());
                                break;
                            }
                            i++;
                        }
                        replace = "";
                    } else {
                        if (UI_QueryStr.toLowerCase().startsWith("i:/")) {
                            List<DiskParam> diskList2 = UtilityUtil.getDiskList();
                            while (i < diskList2.size()) {
                                DiskParam diskParam2 = diskList2.get(i);
                                String shorterName2 = diskParam2.getShorterName();
                                if (shorterName2 == null) {
                                    return;
                                }
                                if (shorterName2.startsWith("I:")) {
                                    replace = UI_QueryStr.toLowerCase().replace("i:", diskParam2.getPath());
                                    break;
                                }
                                i++;
                            }
                        }
                        replace = "";
                    }
                }
                if ("".equals(replace) || !replace.toLowerCase().endsWith(".stp") || (storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class)) == null) {
                    return;
                }
                StorageSaveParam value2 = storageViewModel.getSaveLiveData().getValue();
                File file = new File(replace);
                if (value2 == null || file.getParentFile() == null) {
                    return;
                }
                value2.saveSetupSetting_scpi(file.getParentFile().getPath(), file.getName());
                value2.doSave();
            }
        });
        get(12, MessageID.MSG_STORAGE_LOAD_SETUP).observe(baseActivity, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.6
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                String replace;
                StorageViewModel storageViewModel;
                String UI_QueryStr = API.getInstance().UI_QueryStr(12, MessageID.MSG_STORAGE_LOAD_SETUP);
                if (UI_QueryStr.toLowerCase().startsWith("c:/")) {
                    replace = UI_QueryStr.toLowerCase().replace("c:", DiskManageParam.DEFAULT_PATH);
                } else {
                    int i = 0;
                    if (UI_QueryStr.toLowerCase().startsWith("d:/")) {
                        List<DiskParam> diskList = UtilityUtil.getDiskList();
                        while (i < diskList.size()) {
                            DiskParam diskParam = diskList.get(i);
                            String shorterName = diskParam.getShorterName();
                            if (shorterName == null) {
                                return;
                            }
                            if (shorterName.startsWith("D:")) {
                                replace = UI_QueryStr.toLowerCase().replace("d:", diskParam.getPath());
                                break;
                            }
                            i++;
                        }
                        replace = "";
                    } else {
                        if (UI_QueryStr.toLowerCase().startsWith("i:/")) {
                            List<DiskParam> diskList2 = UtilityUtil.getDiskList();
                            while (i < diskList2.size()) {
                                DiskParam diskParam2 = diskList2.get(i);
                                String shorterName2 = diskParam2.getShorterName();
                                if (shorterName2 == null) {
                                    return;
                                }
                                if (shorterName2.startsWith("I:")) {
                                    replace = UI_QueryStr.toLowerCase().replace("i:", diskParam2.getPath());
                                    break;
                                }
                                i++;
                            }
                        }
                        replace = "";
                    }
                }
                if ("".equals(replace) || !replace.toLowerCase().endsWith(".stp") || (storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class)) == null) {
                    return;
                }
                StorageLoadParam value2 = storageViewModel.getLoadLiveData().getValue();
                File file = new File(replace);
                if (value2 == null || file.getParentFile() == null) {
                    return;
                }
                value2.loadSetupSetting_scpi(file.getParentFile().getPath(), file.getName());
                value2.doLoad();
            }
        });
        get(12, MessageID.MSG_STORAGE_SAVE_WAVE_SCREEN).observe(baseActivity, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.7
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                String replace;
                int i;
                String UI_QueryStr = API.getInstance().UI_QueryStr(12, MessageID.MSG_STORAGE_SAVE_WAVE_SCREEN);
                if (UI_QueryStr.toLowerCase().startsWith("c:/")) {
                    replace = UI_QueryStr.toLowerCase().replace("c:", DiskManageParam.DEFAULT_PATH);
                } else {
                    int i2 = 0;
                    if (UI_QueryStr.toLowerCase().startsWith("d:/")) {
                        List<DiskParam> diskList = UtilityUtil.getDiskList();
                        while (i2 < diskList.size()) {
                            DiskParam diskParam = diskList.get(i2);
                            String shorterName = diskParam.getShorterName();
                            if (shorterName == null) {
                                return;
                            }
                            if (shorterName.startsWith("D:")) {
                                replace = UI_QueryStr.toLowerCase().replace("d:", diskParam.getPath());
                                break;
                            }
                            i2++;
                        }
                        replace = "";
                    } else {
                        if (UI_QueryStr.toLowerCase().startsWith("i:/")) {
                            List<DiskParam> diskList2 = UtilityUtil.getDiskList();
                            while (i2 < diskList2.size()) {
                                DiskParam diskParam2 = diskList2.get(i2);
                                String shorterName2 = diskParam2.getShorterName();
                                if (shorterName2 == null) {
                                    return;
                                }
                                if (shorterName2.startsWith("I:")) {
                                    replace = UI_QueryStr.toLowerCase().replace("i:", diskParam2.getPath());
                                    break;
                                }
                                i2++;
                            }
                        }
                        replace = "";
                    }
                }
                if ("".equals(replace)) {
                    return;
                }
                if (replace.toLowerCase().endsWith(".csv")) {
                    i = ServiceEnum.enFileType.FILETYPE_CSV.value1;
                } else if (!replace.toLowerCase().endsWith(".bin")) {
                    return;
                } else {
                    i = ServiceEnum.enFileType.FILETYPE_BIN.value1;
                }
                StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
                if (storageViewModel == null) {
                    return;
                }
                StorageSaveParam value2 = storageViewModel.getSaveLiveData().getValue();
                File file = new File(replace);
                if (value2 == null || file.getParentFile() == null) {
                    return;
                }
                value2.saveWaveSetting_scpi(file.getParentFile().getPath(), file.getName(), i, ServiceEnum.UtilityQuickDataSource.Screen.value1);
                value2.doSave();
            }
        });
        get(12, MessageID.MSG_STORAGE_SAVE_WAVE_MEMORY).observe(baseActivity, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.8
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                String replace;
                int i;
                String UI_QueryStr = API.getInstance().UI_QueryStr(12, MessageID.MSG_STORAGE_SAVE_WAVE_MEMORY);
                if (UI_QueryStr.toLowerCase().startsWith("c:/")) {
                    replace = UI_QueryStr.toLowerCase().replace("c:", DiskManageParam.DEFAULT_PATH);
                } else {
                    int i2 = 0;
                    if (UI_QueryStr.toLowerCase().startsWith("d:/")) {
                        List<DiskParam> diskList = UtilityUtil.getDiskList();
                        while (i2 < diskList.size()) {
                            DiskParam diskParam = diskList.get(i2);
                            String shorterName = diskParam.getShorterName();
                            if (shorterName == null) {
                                return;
                            }
                            if (shorterName.startsWith("D:")) {
                                replace = UI_QueryStr.toLowerCase().replace("d:", diskParam.getPath());
                                break;
                            }
                            i2++;
                        }
                        replace = "";
                    } else {
                        if (UI_QueryStr.toLowerCase().startsWith("i:/")) {
                            List<DiskParam> diskList2 = UtilityUtil.getDiskList();
                            while (i2 < diskList2.size()) {
                                DiskParam diskParam2 = diskList2.get(i2);
                                String shorterName2 = diskParam2.getShorterName();
                                if (shorterName2 == null) {
                                    return;
                                }
                                if (shorterName2.startsWith("I:")) {
                                    replace = UI_QueryStr.toLowerCase().replace("i:", diskParam2.getPath());
                                    break;
                                }
                                i2++;
                            }
                        }
                        replace = "";
                    }
                }
                if ("".equals(replace)) {
                    return;
                }
                if (replace.toLowerCase().endsWith(".csv")) {
                    i = ServiceEnum.enFileType.FILETYPE_CSV.value1;
                } else if (replace.toLowerCase().endsWith(".bin")) {
                    i = ServiceEnum.enFileType.FILETYPE_BIN.value1;
                } else if (!replace.toLowerCase().endsWith(".wfm")) {
                    return;
                } else {
                    i = ServiceEnum.enFileType.FILETYPE_WFM.value1;
                }
                StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
                if (storageViewModel == null) {
                    return;
                }
                StorageSaveParam value2 = storageViewModel.getSaveLiveData().getValue();
                File file = new File(replace);
                if (value2 == null || file.getParentFile() == null) {
                    return;
                }
                value2.saveWaveSetting_scpi(file.getParentFile().getPath(), file.getName(), i, ServiceEnum.UtilityQuickDataSource.Memory.value1);
                value2.doSave();
            }
        });
        get(48, MessageID.MSG_USB_ANALYSE_RESULT).observe(baseActivity, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.9
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                PopupViewManager.getInstance().dismiss(AnalysingPopupView.class);
                PopupViewManager.getInstance().show(AnalyseUsbResultPopupView.class);
            }
        });
        get(49, MessageID.MSG_APP_ANALYSE_ETH100_QUERY_EVT_CONTENT).observe(baseActivity, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.10
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                PopupViewManager.getInstance().dismiss(AnalysingPopupView.class);
                PopupViewManager.getInstance().show(AnalyseEthResultPopupView.class);
            }
        });
        get(49, MessageID.MSG_ANALYSE_RESULT_ERROR).observe(baseActivity, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.11
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                PopupViewManager.getInstance().dismiss(AnalysingPopupView.class);
                PopupViewManager.getInstance().show(AnalyseRemindPopupView.class);
            }
        });
        get(48, MessageID.MSG_ANALYSE_RESULT_ERROR).observe(baseActivity, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.12
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                PopupViewManager.getInstance().dismiss(AnalysingPopupView.class);
                PopupViewManager.getInstance().show(AnalyseRemindPopupView.class);
            }
        });
        get(49, MessageID.MSG_ANALYSE_RESULT_SAVE_COMPLETE).observe(baseActivity, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.13
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.msg_analyse_result_save_complete));
            }
        });
        get(48, MessageID.MSG_ANALYSE_RESULT_SAVE_COMPLETE).observe(baseActivity, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.14
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.msg_analyse_result_save_complete));
            }
        });
        final OptionParam value2 = ((OptionViewModel) viewModelProvider.get(OptionViewModel.class)).getLiveData().getValue();
        get(36, MessageID.MSG_LICENSE_CHANGED).observe(baseActivity, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.15
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                OptionParam optionParam = value2;
                if (optionParam != null) {
                    optionParam.readAll();
                }
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final List<VerticalParam> list, final int i) {
        final VerticalParam verticalParam;
        if (list == null || list.isEmpty() || i < 0 || i >= list.size() || (verticalParam = list.get(i)) == null) {
            return;
        }
        final int serviceId = verticalParam.getServiceId();
        get(serviceId, MessageID.API_SCOPE_CHANNEL_MASK).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.16
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                ViewUtil.updateStatus(list, verticalParam.readInt(MessageID.API_SCOPE_CHANNEL_MASK));
            }
        });
        get(serviceId, MessageID.MSG_CHAN_COUP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.17
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.readCoupling();
            }
        });
        get(serviceId, MessageID.MSG_CHAN_IMPEDANCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.18
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.readImpedance();
                VerticalParam verticalParam2 = verticalParam;
                verticalParam2.readAttr(MessageID.MSG_CHAN_SCALE_REAL, verticalParam2.getScaleAttr());
            }
        });
        get(serviceId, MessageID.MSG_CHAN_OFFSET_REAL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.19
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.readRealScale();
                verticalParam.readOffset();
                VerticalParam verticalParam2 = verticalParam;
                verticalParam2.readAttr(MessageID.MSG_CHAN_OFFSET_REAL, verticalParam2.getOffsetAttr());
            }
        });
        get(serviceId, MessageID.MSG_CHAN_POS_REAL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.20
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.readPosition();
                VerticalParam verticalParam2 = verticalParam;
                verticalParam2.readAttr(MessageID.MSG_CHAN_POS_REAL, verticalParam2.getPositionAttr());
            }
        });
        get(serviceId, MessageID.MSG_CHAN_SKEW).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.21
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.readChanDelay();
            }
        });
        get(serviceId, MessageID.MSG_CHAN_INVERT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.22
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.readInvert();
            }
        });
        get(serviceId, MessageID.MSG_CHAN_SCALE_REAL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.23
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.readScale();
                verticalParam.readRealScale();
                VerticalParam verticalParam2 = verticalParam;
                verticalParam2.readAttr(MessageID.MSG_CHAN_SCALE_REAL, verticalParam2.getScaleAttr());
                VerticalParam verticalParam3 = verticalParam;
                verticalParam3.readAttr(MessageID.MSG_CHAN_OFFSET_REAL, verticalParam3.getOffsetAttr());
                VerticalParam verticalParam4 = verticalParam;
                verticalParam4.readAttr(MessageID.MSG_CHAN_POS_REAL, verticalParam4.getPositionAttr());
            }
        });
        get(serviceId, MessageID.MSG_CHAN_BWLIMIT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.24
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.readBandLimit();
            }
        });
        get(serviceId, MessageID.MSG_CHAN_UNIT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.25
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.readUnit();
            }
        });
        get(serviceId, MessageID.MSG_CHAN_FINE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.26
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.readFine();
                ViewUtil.switchToast(R.string.msg_hor_fine_on, verticalParam.getFine());
            }
        });
        get(serviceId, MessageID.MSG_CHAN_LABEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.27
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.readLabel();
            }
        });
        get(serviceId, MessageID.MSG_CHAN_LABEL_SHOW).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.28
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.readShowLabel();
            }
        });
        get(serviceId, MessageID.MSG_CHAN_PROBE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.29
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.readProbeRatio();
            }
        });
        get(serviceId, MessageID.MSG_PROBE_INSERT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.30
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.readProbeInsert();
                verticalParam.readProbeBiasAttr();
                if (verticalParam.getProbeInsert()) {
                    BasePopupView basePopupView = PopupViewManager.getInstance().get(ProbePopupView.class);
                    if (basePopupView instanceof ProbePopupView) {
                        ((ProbePopupView) basePopupView).setCurrentItem(i);
                        if (!basePopupView.isShowing()) {
                            basePopupView.show();
                        }
                        PopupSpinner popupSpinner = verticalParam.getPopupSpinner();
                        if (popupSpinner == null || !popupSpinner.isShowing()) {
                            return;
                        }
                        popupSpinner.dismiss();
                        return;
                    }
                    return;
                }
                PopupViewManager.getInstance().dismiss(ProbePopupView.class);
                BasePopupView basePopupView2 = PopupViewManager.getInstance().get(CalibrationPopupView.class);
                if ((basePopupView2 instanceof CalibrationPopupView) && ((CalibrationPopupView) basePopupView2).isProbe() && basePopupView2.isShowing()) {
                    basePopupView2.dismiss();
                }
            }
        });
        get(serviceId, MessageID.MSG_PROBE_REMOVE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.31
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.setProbeInsert(false);
            }
        });
        get(serviceId, MessageID.MSG_CHAN_PROBE_DETAIL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.32
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.readProbeDetail();
            }
        });
        get(serviceId, MessageID.MSG_PROBE_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.33
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.readProbeType();
            }
        });
        get(serviceId, MessageID.MSG_CHAN_PROBE_DELAY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.34
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.readProbeDelay();
            }
        });
        get(serviceId, MessageID.MSG_CHAN_PROBE_BIAS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.35
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.readProbeBiasAttr();
                if (verticalParam.getProbeModel().startsWith("PCA")) {
                    verticalParam.readProbeCurrentBias();
                } else {
                    verticalParam.readProbeBias();
                }
            }
        });
        get(serviceId, MessageID.MSG_CHAN_PROBE_CAL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.36
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                CalibrationParam value;
                if (API.getInstance().UI_QueryBool(serviceId, MessageID.MSG_PROBE_INSERT)) {
                    CalibrationViewModel calibrationViewModel = (CalibrationViewModel) ContextUtil.getAppViewModel(CalibrationViewModel.class);
                    if (calibrationViewModel != null && (value = calibrationViewModel.getLiveData().getValue()) != null) {
                        value.setStarted(true);
                    }
                    BasePopupView basePopupView = PopupViewManager.getInstance().get(CalibrationPopupView.class);
                    if (basePopupView instanceof CalibrationPopupView) {
                        CalibrationPopupView calibrationPopupView = (CalibrationPopupView) basePopupView;
                        calibrationPopupView.setProbe(true);
                        calibrationPopupView.setProbeCalServiceID(serviceId);
                        basePopupView.show();
                    }
                }
            }
        });
        get(serviceId, MessageID.MSG_CHAN_LABEL_EDIT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.37
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                verticalParam.readLabel();
            }
        });
        get(serviceId, MessageID.MSG_CHAN_ON_OFF).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.38
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                WindowParam windowParam = new WindowParam();
                windowParam.setType(ServiceEnum.WindowType.WIN_MAIN_WAVEFORM);
                ((MainActivity) ActivityUtils.getTopActivity()).getWaveformFragment().addWindow(windowParam);
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final HorizontalParam horizontalParam) {
        if (horizontalParam == null) {
            return;
        }
        int serviceId = horizontalParam.getServiceId();
        get(serviceId, MessageID.MSG_ACQ_ULTRA_FRAME).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.39
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readMaxFrame();
                horizontalParam.readMaxFrameAttr();
            }
        });
        get(serviceId, MessageID.MSG_ACQ_ULTRA_TIMEOUT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.40
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readTimeOut();
            }
        });
        get(serviceId, MessageID.MSG_ACQ_MODE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.41
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readAcquireMode();
                horizontalParam.readMainScale();
                horizontalParam.readTimeMode();
                MessageBus.getInstance().onSyncData(MessageBus.getKey(10, MessageID.MSG_HOR_REFRESH_ULTRAL_ENABLE), null);
            }
        });
        get(serviceId, MessageID.MSG_HOR_MAIN_SCALE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.42
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readMainScale();
                horizontalParam.readMainScaleAttr();
                if (horizontalParam.getRunStop() == ServiceEnum.ControlAction.Control_Run) {
                    horizontalParam.readTimeMode();
                }
                MessageBus.getInstance().onSyncData(MessageBus.getKey(10, MessageID.MSG_HOR_REFRESH_ULTRAL_ENABLE), null);
            }
        });
        get(serviceId, MessageID.MSG_HOR_MAIN_OFFSET).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.43
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readMainOffset();
                horizontalParam.readMainOffsetAttr();
            }
        });
        get(serviceId, MessageID.MSG_HOR_ZOOM_SCALE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.44
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readZoomScale();
                horizontalParam.readZoomScaleAttr();
            }
        });
        get(serviceId, MessageID.MSG_HOR_ZOOM_OFFSET).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.45
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readZoomOffset();
                horizontalParam.readZoomOffsetAttr();
            }
        });
        get(serviceId, MessageID.MSG_HOR_FINE_ON).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.46
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readFine();
                ViewUtil.switchToast(R.string.msg_hor_fine_on, horizontalParam.isFine());
            }
        });
        get(serviceId, MessageID.MSG_HOR_ZOOM_ON).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.47
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                UpdateUIViewModel.this.isReceived = true;
                UpdateUIViewModel.this.mHandler.post(new Runnable() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.47.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UpdateUIViewModel.this.isReceived) {
                            UpdateUIViewModel.this.isReceived = false;
                            UpdateUIViewModel.this.mHandler.postDelayed(this, 200L);
                            return;
                        }
                        horizontalParam.readZoom();
                    }
                });
            }
        });
        get(serviceId, MessageID.MSG_ACQ_AVG_TIMES).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.48
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readAvgTimes();
            }
        });
        get(serviceId, MessageID.MSG_ACQ_ANTI_ALIASING).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.49
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readAntiAliasing();
            }
        });
        get(serviceId, MessageID.MSG_ACQ_MEMDEPTH).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.50
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readDepth();
            }
        });
        get(serviceId, MessageID.MSG_ACQ_MEMDEPTH_VALUE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.51
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readDepthValue();
            }
        });
        get(serviceId, MessageID.MSG_ACQ_SARATE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.52
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readSample();
                MessageBus.getInstance().onSyncData(MessageBus.getKey(10, MessageID.MSG_HOR_REFRESH_ULTRAL_ENABLE), null);
                MessageBus.getInstance().onSyncData(MessageBus.getKey(10, MessageID.MSG_ACQ_SARATE), true);
            }
        });
        get(serviceId, 8972).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.53
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readDotTime();
            }
        });
        get(serviceId, MessageID.MSG_HOR_EXPAND).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.54
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readExpandMode();
            }
        });
        get(serviceId, MessageID.MSG_HOR_EXPAND_USER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.55
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readExpandUser();
            }
        });
        get(serviceId, MessageID.MSG_HOR_EXPAND_GND).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.56
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readExpandGnd();
            }
        });
        get(serviceId, MessageID.MSG_HOR_AUTO_ROLL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.57
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readRoll();
            }
        });
        get(serviceId, MessageID.MSG_ACQ_HIGHRES_BIT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.58
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readHighBit();
            }
        });
        get(serviceId, MessageID.MSG_ACQ_ULTRA_DISPLAYMODE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.59
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readDisplayMode();
            }
        });
        get(serviceId, MessageID.MSG_ACQ_HIGHRES_BW).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.60
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readHighBw();
            }
        });
        get(serviceId, MessageID.MSG_HOR_RUN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.61
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readRunStop();
                horizontalParam.readMainOffsetAttr();
            }
        });
        get(serviceId, MessageID.MSG_HOR_GET_TRIGSTATUS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.62
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readTriggerStatus();
            }
        });
        get(serviceId, MessageID.MSG_HOR_FILTER1_EN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.63
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readFilter1();
            }
        });
        get(serviceId, MessageID.MSG_HOR_FILTER2_EN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.64
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                horizontalParam.readFilter2();
            }
        });
        get(serviceId, MessageID.MSG_HOR_UI_TIME_VIEW_MODE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.65
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                ArrayList<DecodeParam> value;
                horizontalParam.readTimeMode();
                horizontalParam.setUltraEnable(FunctionManager.getInstance().getUltraStatus(horizontalParam));
                horizontalParam.setXyCheckEnable(FunctionManager.getInstance().getXYEnable(horizontalParam));
                if (horizontalParam.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL) {
                    if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class)) {
                        PopupViewManager.getInstance().dismiss(TriggerPopupView.class);
                    }
                    DecodeViewModel decodeViewModel = (DecodeViewModel) ContextUtil.getAppViewModel(DecodeViewModel.class);
                    if (decodeViewModel == null || (value = decodeViewModel.getLiveData().getValue()) == null) {
                        return;
                    }
                    for (DecodeParam decodeParam : value) {
                        if (((HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class)).getLiveData().getValue().getRunStop() == ServiceEnum.ControlAction.Control_Run) {
                            decodeParam.saveOnOff(false);
                        }
                    }
                    if (PopupViewManager.getInstance().isShowing(DecodeNewPopupView.class)) {
                        PopupViewManager.getInstance().dismiss(DecodeNewPopupView.class);
                    }
                }
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final MathParam mathParam) {
        if (mathParam == null) {
            return;
        }
        int serviceId = mathParam.getServiceId();
        get(serviceId, MessageID.MSG_MATH_EN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.66
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                UpdateUIViewModel.this.isReceived = true;
                UpdateUIViewModel.this.mHandler.post(new Runnable() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.66.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UpdateUIViewModel.this.isReceived) {
                            UpdateUIViewModel.this.isReceived = false;
                            UpdateUIViewModel.this.mHandler.postDelayed(this, 150L);
                            return;
                        }
                        mathParam.readStatus();
                    }
                });
            }
        });
        get(serviceId, MessageID.MSG_MATH_OPERATOR).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.67
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readOperator();
                BasePopupView basePopupView = PopupViewManager.getInstance().get(MathPopupView.class);
                if ((basePopupView instanceof MathPopupView) && !basePopupView.isShowing()) {
                    MathRecyclerView mathRecyclerView = ((MathPopupView) basePopupView).getMathRecyclerView();
                    if (mathRecyclerView != null) {
                        mathRecyclerView.showMath(mathParam.getOperator());
                        return;
                    }
                    return;
                }
                MessageBus.getInstance().onSyncData(MessageBus.getKey(mathParam.getServiceId(), MessageID.MSG_MATH_OPERATOR), "");
            }
        });
        get(serviceId, MessageID.MSG_MATH_S32ARITHA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.68
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readSourceArithA();
            }
        });
        get(serviceId, MessageID.MSG_MATH_S32ARITHB).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.69
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readSourceArithB();
            }
        });
        get(serviceId, MessageID.MSG_MATH_S32LOGICA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.70
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readSourceLogicA();
            }
        });
        get(serviceId, MessageID.MSG_MATH_S32LOGICB).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.71
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readSourceLogicB();
            }
        });
        get(serviceId, MessageID.MSG_MATH_FFT_S32SRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.72
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readSourceFft();
            }
        });
        get(serviceId, MessageID.MSG_MATH_VIEW_OFFSET).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.73
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readOffset();
            }
        });
        get(serviceId, MessageID.MSG_MATH_ANALOG_S32SCALE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.74
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readScale();
            }
        });
        get(serviceId, MessageID.MSG_MATH_LOGIC_OFFSET).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.75
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readLogicOffset();
            }
        });
        get(serviceId, MessageID.MSG_MATH_LOGIC_SCALE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.76
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readLogicScale();
            }
        });
        get(serviceId, MessageID.MSG_MATH_FFT_OFFSET).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.77
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readFftOffset();
            }
        });
        get(serviceId, MessageID.MSG_MATH_FFT_SCALE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.78
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readFftScale();
            }
        });
        get(serviceId, MessageID.MSG_MATH_S32INVERT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.79
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readInvert();
            }
        });
        get(serviceId, MessageID.MSG_MATH_EXPAND).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.80
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readExpand();
            }
        });
        get(serviceId, MessageID.MSG_MATH_LOGIC_S32SENS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.81
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readSens();
            }
        });
        get(serviceId, MessageID.MSG_MATH_LOGIC_S32THRE1).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.82
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readThresholdCH1();
                MessageBus.getInstance().onSyncData(MessageBus.getKey(mathParam.getServiceId(), MessageID.MSG_MATH_LOGIC_S32THRE1), Long.valueOf(mathParam.getThresholdCH1()));
            }
        });
        get(serviceId, MessageID.MSG_MATH_LOGIC_S32THRE2).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.83
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readThresholdCH2();
                MessageBus.getInstance().onSyncData(MessageBus.getKey(mathParam.getServiceId(), MessageID.MSG_MATH_LOGIC_S32THRE2), Long.valueOf(mathParam.getThresholdCH2()));
            }
        });
        get(serviceId, MessageID.MSG_MATH_LOGIC_S32THRE3).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.84
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readThresholdCH3();
                MessageBus.getInstance().onSyncData(MessageBus.getKey(mathParam.getServiceId(), MessageID.MSG_MATH_LOGIC_S32THRE3), Long.valueOf(mathParam.getThresholdCH3()));
            }
        });
        get(serviceId, MessageID.MSG_MATH_LOGIC_S32THRE4).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.85
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readThresholdCH4();
                MessageBus.getInstance().onSyncData(MessageBus.getKey(mathParam.getServiceId(), MessageID.MSG_MATH_LOGIC_S32THRE4), Long.valueOf(mathParam.getThresholdCH4()));
            }
        });
        get(serviceId, MessageID.MSG_MATH_DIFF_SMOOTH).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.86
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readSmooth();
            }
        });
        get(serviceId, MessageID.MSG_MATH_DIFF_SMOOTH).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.87
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readSmooth();
            }
        });
        get(serviceId, MessageID.MSG_MATH_INTGOPT_BIAS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.88
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readIntgBias();
            }
        });
        get(serviceId, MessageID.MSG_MATH_INTGBIAS_UNIT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.89
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readIntgBiasUnit();
            }
        });
        get(serviceId, MessageID.MSG_MATH_S32FILTER_LP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.90
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readLpFreq();
            }
        });
        get(serviceId, MessageID.MSG_MATH_S32FILTER_HP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.91
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readHpFreq();
            }
        });
        get(serviceId, MessageID.MSG_MATH_S32FILTER_BP1).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.92
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readBpFreq1();
            }
        });
        get(serviceId, MessageID.MSG_MATH_S32FILTER_BP2).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.93
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readBpFreq2();
            }
        });
        get(serviceId, MessageID.MSG_MATH_S32FILTER_BT1).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.94
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readBtFreq1();
            }
        });
        get(serviceId, MessageID.MSG_MATH_S32FILTER_BT2).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.95
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readBtFreq2();
            }
        });
        get(serviceId, MessageID.MSG_MATH_FFT_X_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.96
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readFftXType();
            }
        });
        get(serviceId, MessageID.MSG_MATH_FFT_S32UNIT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.97
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readFftUnit();
            }
        });
        get(serviceId, MessageID.MSG_MATH_FFT_H_START).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.98
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readFftStart();
            }
        });
        get(serviceId, MessageID.MSG_MATH_FFT_H_END).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.99
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readFftEnd();
            }
        });
        get(serviceId, MessageID.MSG_MATH_FFT_H_CENTER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.100
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readFftCenter();
            }
        });
        get(serviceId, MessageID.MSG_MATH_FFT_H_SPAN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.101
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readFftSpan();
                mathParam.readFftSpanAttr();
            }
        });
        get(serviceId, MessageID.MSG_MATH_FFT_S32WINDOW).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.102
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readFftWindow();
            }
        });
        get(serviceId, MessageID.MSG_MATH_COLOR_ONOFF).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.103
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readColorGrade();
            }
        });
        get(serviceId, MessageID.MSG_MATH_FFT_PEAK_ENABLE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.104
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readPeakSearch();
            }
        });
        get(serviceId, MessageID.MSG_MATH_FFT_PEAK_MAXPEAKS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.105
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readPeakNum();
            }
        });
        get(serviceId, MessageID.MSG_MATH_FFT_PEAK_THRESHOLD).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.106
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readPeakThreshold();
            }
        });
        get(serviceId, MessageID.MSG_MATH_FFT_PEAK_EXCURSION).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.107
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readPeakExcursion();
            }
        });
        get(serviceId, MessageID.MSG_MATH_FFT_PEAK_TABELORDER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.108
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readFftPeakOrder();
            }
        });
        get(serviceId, MessageID.MSG_MATH_UNIT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.109
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readUnit();
            }
        });
        get(serviceId, MessageID.MSG_WINDOW_TITLE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.110
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.updateWindowTitle();
            }
        });
        get(serviceId, MessageID.MSG_MATH_LABEL_STR).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.111
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readLableString();
            }
        });
        get(serviceId, MessageID.MSG_MATH_SHOW_S32LABEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.112
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readLable();
            }
        });
        get(serviceId, MessageID.MSG_DISPLAY_GRID).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.113
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readGrids();
            }
        });
        get(serviceId, MessageID.MSG_MATH_SPY_ZOOM_EN).observe(lifecycleOwner, new AnonymousClass114(mathParam));
        get(serviceId, MessageID.MSG_MATH_WAVE_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.115
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readWaveType();
            }
        });
        get(serviceId, MessageID.MSG_MATH_FFT_START_ZOOM).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.116
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readFftZoomStart();
            }
        });
        get(serviceId, MessageID.MSG_MATH_FFT_SCALE_ZOOM).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.117
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readFftZoomHScale();
            }
        });
        get(serviceId, MessageID.MSG_MATH_SRC_SA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.118
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                mathParam.readSrcSa();
            }
        });
    }

    /* renamed from: com.rigol.scope.viewmodels.UpdateUIViewModel$114  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass114 implements Observer<Boolean> {
        final /* synthetic */ MathParam val$param;

        AnonymousClass114(MathParam mathParam) {
            this.val$param = mathParam;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(Boolean bool) {
            Handler handler = new Handler();
            final MathParam mathParam = this.val$param;
            handler.postDelayed(new Runnable() { // from class: com.rigol.scope.viewmodels.-$$Lambda$UpdateUIViewModel$114$teW3QX6NV2YnukKqs1gXwf7u0B0
                @Override // java.lang.Runnable
                public final void run() {
                    MathParam.this.readZoomEn();
                }
            }, 200L);
        }
    }

    public void bind(LifecycleOwner lifecycleOwner, EyeParam eyeParam) {
        if (eyeParam == null) {
            return;
        }
        eyeParam.bindAll(this, lifecycleOwner);
    }

    public void bind(LifecycleOwner lifecycleOwner, final RefParam refParam) {
        if (refParam == null) {
            return;
        }
        int serviceId = refParam.getServiceId();
        get(serviceId, MessageID.MSG_REF_CHANNEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.119
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                refParam.readRefChan();
            }
        });
        get(serviceId, MessageID.MSG_REF_SCPI_CURRENT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.120
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                MessageBus.getInstance().onSyncData(MessageBus.getKey(22, MessageID.MSG_REF_SCPI_CURRENT), null);
            }
        });
        get(serviceId, MessageID.MSG_REF_LABEL_ONOFF).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.121
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                refParam.readShowLabel();
            }
        });
        for (final int i = 0; i < (ServiceEnum.Chan.r10.value1 - ServiceEnum.Chan.r1.value1) + 1; i++) {
            get(serviceId, MessageID.MSG_REFID_SOURCE, i).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.122
                @Override // androidx.lifecycle.Observer
                public void onChanged(Boolean bool) {
                    refParam.getParam(i).readSrcChan();
                }
            });
            get(serviceId, MessageID.MSG_REFID_SCALE, i).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.123
                @Override // androidx.lifecycle.Observer
                public void onChanged(Boolean bool) {
                    refParam.getParam(i).readVerScale();
                }
            });
            get(serviceId, MessageID.MSG_REFID_OFFSET, i).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.124
                @Override // androidx.lifecycle.Observer
                public void onChanged(Boolean bool) {
                    refParam.getParam(i).readVerOffset();
                }
            });
            get(serviceId, MessageID.MSG_REFID_LABEL_EDIT, i).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.125
                @Override // androidx.lifecycle.Observer
                public void onChanged(Boolean bool) {
                    refParam.getParam(i).readLabel();
                }
            });
            get(serviceId, MessageID.MSG_REFID_COLOR, i).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.126
                @Override // androidx.lifecycle.Observer
                public void onChanged(Boolean bool) {
                    refParam.getParam(i).readRefColor();
                }
            });
            get(serviceId, MessageID.MSG_REF_UNIT, i).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.127
                @Override // androidx.lifecycle.Observer
                public void onChanged(Boolean bool) {
                    refParam.getParam(i).readUnit();
                }
            });
            get(serviceId, MessageID.MSG_REFID_ENABLE, i).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.128
                @Override // androidx.lifecycle.Observer
                public void onChanged(Boolean bool) {
                    refParam.getParam(i).readOnOff();
                    refParam.getRefIsOpen();
                }
            });
            get(serviceId, MessageID.MSG_REFID_SAVE_SRC, i).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.129
                @Override // androidx.lifecycle.Observer
                public void onChanged(Boolean bool) {
                    refParam.getParam(i).readSaveChan();
                    ViewUtil.getFlexKnobParamViewModel().refreshCHList();
                }
            });
        }
        get(serviceId, MessageID.MSG_REF_SOURCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.130
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                RefParam refParam2 = refParam;
                refParam2.getParam(refParam2.getRefChan()).readSrcChan();
            }
        });
        get(serviceId, MessageID.MSG_REF_SCALE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.131
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                RefParam refParam2 = refParam;
                refParam2.getParam(refParam2.getRefChan()).readVerScale();
            }
        });
        get(serviceId, MessageID.MSG_REF_OFFSET).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.132
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                RefParam refParam2 = refParam;
                refParam2.getParam(refParam2.getRefChan()).readVerOffset();
            }
        });
        get(serviceId, MessageID.MSG_REF_LABEL_EDIT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.133
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                RefParam refParam2 = refParam;
                refParam2.getParam(refParam2.getRefChan()).readLabel();
            }
        });
        get(serviceId, MessageID.MSG_REF_COLOR).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.134
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                RefParam refParam2 = refParam;
                refParam2.getParam(refParam2.getRefChan()).readRefColor();
            }
        });
        get(serviceId, MessageID.MSG_REF_UNIT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.135
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                RefParam refParam2 = refParam;
                refParam2.getParam(refParam2.getRefChan()).readUnit();
            }
        });
        get(serviceId, MessageID.MSG_REFID_ENABLE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.136
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                RefParam refParam2 = refParam;
                refParam2.getParam(refParam2.getRefChan()).readOnOff();
            }
        });
        get(serviceId, MessageID.MSG_REFID_SAVE_SRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.137
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                RefParam refParam2 = refParam;
                refParam2.getParam(refParam2.getRefChan()).readSaveChan();
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final MaskParam maskParam) {
        if (maskParam == null) {
            return;
        }
        int serviceId = maskParam.getServiceId();
        get(serviceId, MessageID.MSG_MASK_ENABLE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.138
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                maskParam.readEnable();
                FunctionManager.getInstance().maskSwitch = maskParam.readBool(MessageID.MSG_MASK_ENABLE);
                MessageBus.getInstance().onSyncData(MessageBus.getKey(10, MessageID.MSG_HOR_REFRESH_ULTRAL_ENABLE), null);
            }
        });
        get(serviceId, MessageID.MSG_MASK_OPERATE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.139
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                maskParam.readOperate();
            }
        });
        get(serviceId, MessageID.MSG_MASK_SOURCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.140
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                maskParam.readSource();
            }
        });
        get(serviceId, MessageID.MSG_MASK_RANGE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.141
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                maskParam.readRang();
            }
        });
        get(serviceId, MessageID.MSG_MASK_Y_MASK).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.142
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                maskParam.readYMask();
            }
        });
        get(serviceId, MessageID.MSG_MASK_X_MASK).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.143
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                maskParam.readXMask();
            }
        });
        get(serviceId, MessageID.MSG_MASK_OUT_ONOFF).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.144
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                maskParam.readAuxOut();
            }
        });
        get(serviceId, MessageID.MSG_MASK_OUT_PULSE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.145
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                maskParam.readOutPulse();
            }
        });
        get(serviceId, MessageID.MSG_MASK_OUT_EVENT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.146
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                maskParam.readOutEvent();
            }
        });
        get(serviceId, MessageID.MSG_MASK_OUT_HL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.147
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                maskParam.readOutHl();
            }
        });
        get(serviceId, MessageID.MSG_MASK_ERR_ACTION).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.148
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                maskParam.readErrAction();
            }
        });
        get(serviceId, MessageID.MSG_MASK_FORCESTOP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.149
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                maskParam.readForceStop();
            }
        });
        get(serviceId, MessageID.MSG_MASK_SCREEN_CAPTURE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.150
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                ViewUtil.doMaskScreenShot();
                if (ViewUtil.checkLengthIfNotEnoughThenAdd(ViewUtil.getBitsFromValue(maskParam.getErrAction()), 3).get(0).intValue() != 1) {
                    maskParam.readForceStop();
                    if (!maskParam.getForceStop()) {
                        maskParam.saveOperate(true);
                        return;
                    }
                    maskParam.saveForceStop(false);
                    maskParam.saveOperate(false);
                    PopupViewManager.getInstance().show(MaskPopupView.class);
                }
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final ResultListAdapter resultListAdapter) {
        get(ResultListAdapter.ON_LIST_CHANGED_KEY_MEASURE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.151
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onListChanged(MeasureResultParam.class);
            }
        });
        get(ResultListAdapter.ON_ITEM_DATA_CHANGED_KEY_MEASURE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.152
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onItemDataChanged(MeasureResultParam.class);
            }
        });
        get(ResultListAdapter.ON_LIST_CHANGED_KEY_CURSOR).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.153
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onListChanged(CursorResultParam.class);
            }
        });
        get(ResultListAdapter.ON_ITEM_DATA_CHANGED_KEY_CURSOR).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.154
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onItemDataChanged(CursorResultParam.class);
            }
        });
        get(ResultListAdapter.ON_LIST_CHANGED_KEY_DVM).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.155
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onListChanged(DvmResultParam.class);
            }
        });
        get(ResultListAdapter.ON_ITEM_DATA_CHANGED_KEY_DVM).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.156
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onItemDataChanged(DvmResultParam.class);
            }
        });
        get(ResultListAdapter.ON_LIST_CHANGED_KEY_COUNTER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.157
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onListChanged(CounterResultParam.class);
            }
        });
        get(ResultListAdapter.ON_ITEM_DATA_CHANGED_KEY_COUNTER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.158
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onItemDataChanged(CounterResultParam.class);
            }
        });
        get(ResultListAdapter.ON_LIST_CHANGED_KEY_HISTOGRAM).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.159
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onListChanged(HistogramResultParam.class);
            }
        });
        get(ResultListAdapter.ON_LIST_CHANGED_KEY_MEAS_HISTOGRAM).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.160
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onListChanged(MeasHistogramResultParam.class);
            }
        });
        get(ResultListAdapter.ON_ITEM_DATA_CHANGED_KEY_HISTOGRAM).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.161
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onItemDataChanged(HistogramResultParam.class);
            }
        });
        get(ResultListAdapter.ON_ITEM_DATA_CHANGED_KEY_MEAS_HISTOGRAM).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.162
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onItemDataChanged(MeasHistogramResultParam.class);
                MessageBus.getInstance().onSyncData(ResultListAdapter.ON_ITEM_DATA_CHANGED_KEY_MEAS_HISTOGRAM, true);
            }
        });
        get(ResultListAdapter.ON_LIST_CHANGED_KEY_EYE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.163
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onListChanged(EyeResultParam.class);
            }
        });
        get(ResultListAdapter.ON_ITEM_DATA_CHANGED_KEY_EYE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.164
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onItemDataChanged(EyeResultParam.class);
            }
        });
        get(ResultListAdapter.ON_LIST_CHANGED_KEY_JITTER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.165
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onListChanged(JitterResultParam.class);
            }
        });
        get(ResultListAdapter.ON_ITEM_DATA_CHANGED_KEY_JITTER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.166
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onItemDataChanged(JitterResultParam.class);
            }
        });
        get(ResultListAdapter.ON_LIST_CHANGED_KEY_MASK).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.167
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onListChanged(MaskResultParam.class);
            }
        });
        get(ResultListAdapter.ON_ITEM_DATA_CHANGED_KEY_MASK).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.168
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onItemDataChanged(MaskResultParam.class);
            }
        });
        get(ResultListAdapter.ON_LIST_CHANGED_KEY_MARKER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.169
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onListChanged(RtsaMarkerResultParam.class);
            }
        });
        get(ResultListAdapter.ON_ITEM_DATA_CHANGED_KEY_MARKER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.170
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onItemDataChanged(RtsaMarkerResultParam.class);
            }
        });
        get(ResultListAdapter.ON_ITEM_DATA_CHANGED_KEY_UPA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.171
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                resultListAdapter.onItemDataChanged(RtsaMarkerResultParam.class);
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final StorageSaveParam storageSaveParam) {
        if (storageSaveParam == null) {
            return;
        }
        int serviceId = storageSaveParam.getServiceId();
        get(serviceId, MessageID.MSG_STORAGE_FILENAME).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.172
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                storageSaveParam.readFileName();
            }
        });
        get(serviceId, MessageID.MSG_STORAGE_PATHNAME).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.173
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                storageSaveParam.readPathName();
            }
        });
        get(serviceId, MessageID.MSG_STORAGE_OVERLAY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.174
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                storageSaveParam.readAutoName();
            }
        });
        get(serviceId, MessageID.MSG_STORAGE_PREFIX).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.175
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                storageSaveParam.readPrefix();
            }
        });
        get(serviceId, MessageID.MSG_STORAGE_FILETYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.176
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                storageSaveParam.readFileType();
            }
        });
        get(serviceId, MessageID.MSG_STORAGE_IMAGE_FORMAT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.177
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                storageSaveParam.readImageFormat();
            }
        });
        get(serviceId, MessageID.MSG_STORAGE_IMAGE_INVERT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.178
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                storageSaveParam.readImageInvert();
            }
        });
        get(serviceId, MessageID.MSG_STORAGE_IMAGE_COLOR).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.179
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                storageSaveParam.readImageColor();
            }
        });
        get(serviceId, MessageID.MSG_STORAGE_IMAGE_HEADER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.180
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                storageSaveParam.readImageHeader();
            }
        });
        get(serviceId, MessageID.MSG_STORAGE_WAVE_DEPTH).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.181
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                storageSaveParam.readWaveDepth();
            }
        });
        get(serviceId, MessageID.MSG_STORAGE_PROGRESS_NOW).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.182
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                storageSaveParam.readProgress();
            }
        });
        get(serviceId, MessageID.MSG_STORAGE_RESULT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.183
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                storageSaveParam.readResult();
            }
        });
        get(serviceId, MessageID.MSG_STORAGE_SMB_EN).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$UpdateUIViewModel$xApaGnLUGuabAYjyOidCLaBVnuA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                Boolean bool = (Boolean) obj;
                StorageSaveParam.this.readSmbEn();
            }
        });
        get(serviceId, MessageID.MSG_STORAGE_SERVER_PATH).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$UpdateUIViewModel$OBS4EN5uQau1q-g-WkRp7888ak4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                Boolean bool = (Boolean) obj;
                StorageSaveParam.this.readServerPath();
            }
        });
        get(serviceId, MessageID.MSG_STORAGE_USER_NAME).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$UpdateUIViewModel$pRCdo8Ig8gZIsFWlK9Id4drBt2o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                Boolean bool = (Boolean) obj;
                StorageSaveParam.this.readUserName();
            }
        });
        get(serviceId, MessageID.MSG_STORAGE_PASSWORD).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$UpdateUIViewModel$RoGOI9cL8pMhKRHYXsdb2phqpYc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                Boolean bool = (Boolean) obj;
                StorageSaveParam.this.readPassword();
            }
        });
        get(serviceId, MessageID.MSG_STORAGE_AUTO_CONNECT).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$UpdateUIViewModel$poRDnkmy1UDcrK0cwzJ8o_RqANE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                Boolean bool = (Boolean) obj;
                StorageSaveParam.this.readAutoConnect();
            }
        });
        get(serviceId, MessageID.MSG_STORAGE_CONNECT_STATE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$UpdateUIViewModel$5KRiJsPkpQ-p2TshN1FXTuHxnz4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UpdateUIViewModel.this.lambda$bind$7$UpdateUIViewModel(storageSaveParam, (Boolean) obj);
            }
        });
    }

    public /* synthetic */ void lambda$bind$7$UpdateUIViewModel(StorageSaveParam storageSaveParam, Boolean bool) {
        storageSaveParam.readConnectState();
        storageSaveParam.readConnectStateRe();
        SharedViewModel sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
        if (sharedViewModel != null) {
            sharedViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$UpdateUIViewModel$zoMO78RDgtNOIMQyCD6Ju7DN0QE
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UpdateUIViewModel.this.lambda$bind$6$UpdateUIViewModel((SharedParam) obj);
                }
            });
        }
        if (storageSaveParam.readConnectState() == 1) {
            this.sharedParam.setShowSmb(true);
        } else {
            this.sharedParam.setShowSmb(false);
        }
    }

    public /* synthetic */ void lambda$bind$6$UpdateUIViewModel(SharedParam sharedParam) {
        this.sharedParam = sharedParam;
    }

    public void bind(LifecycleOwner lifecycleOwner, final StorageLoadParam storageLoadParam) {
        if (storageLoadParam == null) {
            return;
        }
        int serviceId = storageLoadParam.getServiceId();
        get(serviceId, MessageID.MSG_STORAGE_PATHNAME).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.184
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                storageLoadParam.readPathName();
            }
        });
        get(serviceId, MessageID.MSG_STORAGE_RESULT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.185
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                storageLoadParam.readResult();
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final CalibrationParam calibrationParam) {
        if (calibrationParam == null) {
            return;
        }
        int serviceId = calibrationParam.getServiceId();
        get(serviceId, MessageID.MSG_CAL_ITEMS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.186
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                calibrationParam.readItemBits();
                MessageBus.getInstance().onSyncData(MessageBus.getKey(9, MessageID.MSG_CAL_ITEMS), null);
            }
        });
        get(serviceId, MessageID.MSG_CAL_START).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.187
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                UtilityParam value;
                UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
                if (utilityViewModel != null && (value = utilityViewModel.getLiveData().getValue()) != null) {
                    value.setProjectMode(true);
                }
                if (!PopupViewManager.getInstance().isShowing(CalibrationPopupView.class)) {
                    CalibrationPopupView calibrationPopupView = (CalibrationPopupView) PopupViewManager.getInstance().get(CalibrationPopupView.class);
                    calibrationPopupView.setProbe(false);
                    calibrationPopupView.show();
                    MessageBus.getInstance().onSyncData(MessageBus.getKey(9, MessageID.MSG_CAL_START), null);
                    return;
                }
                MessageBus.getInstance().onSyncData(MessageBus.getKey(9, MessageID.MSG_SELF_CAL_START), null);
            }
        });
        get(serviceId, MessageID.MSG_CAL_DETAIL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.188
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                calibrationParam.readDetail();
            }
        });
        get(serviceId, MessageID.MSG_CAL_PROGRESS_NOW).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.189
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                calibrationParam.readProgressNow();
            }
        });
        get(serviceId, MessageID.MSG_CAL_RESULT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.190
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                calibrationParam.readResult();
                if (TextUtils.isEmpty(calibrationParam.getResult())) {
                    return;
                }
                if (Objects.equals(calibrationParam.getResult(), "Success") || Objects.equals(calibrationParam.getResult(), "Failed")) {
                    calibrationParam.setProgressNow(100);
                    calibrationParam.setStarted(false);
                    BasePopupView basePopupView = PopupViewManager.getInstance().get(CalibrationPopupView.class);
                    if ((basePopupView instanceof CalibrationPopupView) && ((CalibrationPopupView) basePopupView).isProbe() && basePopupView.isShowing()) {
                        basePopupView.dismiss();
                    }
                }
            }
        });
        get(serviceId, MessageID.MSG_CAL_DATE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.191
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                calibrationParam.readDate();
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final CursorResultParam cursorResultParam) {
        if (cursorResultParam == null) {
            return;
        }
        int serviceId = cursorResultParam.getServiceId();
        get(serviceId, MessageID.MSG_CURSOR_EN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.192
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                cursorResultParam.readCursorEnable();
            }
        });
        get(serviceId, MessageID.MSG_CURSOR_MODE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.193
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                cursorResultParam.readMode();
                ViewUtil.getFlexKnobParamViewModel().refreshCHList();
            }
        });
        get(serviceId, MessageID.MSG_CURSOR_MANUALSRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.194
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                cursorResultParam.readSourceA();
            }
        });
        get(serviceId, MessageID.MSG_CURSOR_MANUAL_MIRROR_SRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.195
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                cursorResultParam.readSyncArea();
            }
        });
        get(serviceId, MessageID.MSG_CURSOR_HAPOS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.196
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                cursorResultParam.readAx();
            }
        });
        get(serviceId, MessageID.MSG_CURSOR_HBPOS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.197
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                cursorResultParam.readBx();
            }
        });
        get(serviceId, MessageID.MSG_CURSOR_VAPOS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.198
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                cursorResultParam.readAy();
            }
        });
        get(serviceId, MessageID.MSG_CURSOR_VBPOS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.199
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                cursorResultParam.readBy();
            }
        });
        get(serviceId, MessageID.MSG_CURSOR_CHANED_AB).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.200
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                cursorResultParam.readBothAB();
            }
        });
        get(serviceId, MessageID.MSG_CURSOR_TIMEUNIT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.201
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                cursorResultParam.readUnit();
            }
        });
        get(serviceId, MessageID.MSG_CURSOR_VUNIT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.202
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                cursorResultParam.readUnit();
            }
        });
        get(serviceId, MessageID.MSG_CURSOR_TASRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.203
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                cursorResultParam.readSourceA();
            }
        });
        get(serviceId, MessageID.MSG_CURSOR_TBSRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.204
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                cursorResultParam.readSourceB();
            }
        });
        get(serviceId, MessageID.MSG_CURSOR_TAPOS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.205
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                cursorResultParam.readAx();
            }
        });
        get(serviceId, MessageID.MSG_CURSOR_TBPOS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.206
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                cursorResultParam.readBx();
            }
        });
        get(serviceId, MessageID.MSG_CURSOR_TAPOS_V).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.207
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                cursorResultParam.readAy();
            }
        });
        get(serviceId, MessageID.MSG_CURSOR_TBPOS_V).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.208
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                cursorResultParam.readBy();
            }
        });
        get(serviceId, MessageID.MSG_CURSOR_TRACK_MODE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.209
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                cursorResultParam.readXorY();
            }
        });
        get(serviceId, MessageID.MSG_CURSOR_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.210
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                cursorResultParam.readXorY();
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final TriggerParam triggerParam) {
        if (triggerParam == null) {
            return;
        }
        get(41, MessageID.MSG_TRIGGER_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.211
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                int readTriggerType = triggerParam.readTriggerType();
                ServiceEnum.TriggerMode triggerModeFromValue1 = ServiceEnum.getTriggerModeFromValue1(readTriggerType);
                if (readTriggerType == 0 && triggerParam.getTriggerMode() != ServiceEnum.TriggerMode.Trigger_Edge) {
                    int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_EDGE_SOURCE);
                    if (triggerModeFromValue1 == ServiceEnum.TriggerMode.Trigger_Edge) {
                        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SLOPE_LEVEL_H);
                        if (triggerParam.getfRatio() > 0.0f) {
                            if (triggerParam.getfRatio() >= 1.0f) {
                                API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_LEVEL, UI_QueryInt64 / triggerParam.getfRatio());
                            } else {
                                API api = API.getInstance();
                                TriggerParam triggerParam2 = triggerParam;
                                api.UI_PostInt64(41, MessageID.MSG_TRIGGER_LEVEL, UI_QueryInt64 * triggerParam2.floatToLong(triggerParam2.getfRatio()));
                            }
                        }
                        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_EDGE_SOURCE, UI_QueryInt32);
                    }
                }
                triggerParam.setTriggerMode(triggerModeFromValue1);
                BasePopupView basePopupView = PopupViewManager.getInstance().get(TriggerPopupView.class);
                if (!(basePopupView instanceof TriggerPopupView) || triggerModeFromValue1 == null) {
                    return;
                }
                ((TriggerPopupView) basePopupView).showTrigger(triggerModeFromValue1);
            }
        });
        get(41, MessageID.MSG_TRIGGER_COUPLING).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.212
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readEdgeCoupling();
            }
        });
        get(41, MessageID.MSG_TRIGGER_EDGE_SOURCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.213
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(triggerParam.readEdgeSource());
                triggerParam.setChan(chanFromValue1);
                if (chanFromValue1 == ServiceEnum.Chan.acline) {
                    triggerParam.saveNoise(false);
                }
            }
        });
        get(41, MessageID.MSG_TRIGGER_SWEEP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.214
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readEdgeSweep();
            }
        });
        get(41, MessageID.MSG_TRIGGER_EDGE_WHEN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.215
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readEdgeSlope();
                if (triggerParam.getEdgeSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Rising) {
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP1_LED_WHITE.value1, 1);
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP2_LED_WHITE.value1, 0);
                } else if (triggerParam.getEdgeSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Falling) {
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP1_LED_WHITE.value1, 0);
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP2_LED_WHITE.value1, 1);
                } else if (triggerParam.getEdgeSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Any) {
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP2_LED_WHITE.value1, 1);
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP1_LED_WHITE.value1, 1);
                }
            }
        });
        get(41, MessageID.MSG_TRIGGER_APPLY_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.216
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.checkLevel();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.217
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Slope || triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Runt || triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Over || triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Delay || triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Setup || triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C || triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI || triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S || triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
                    return;
                }
                long readLevel = triggerParam.readLevel();
                triggerParam.setLevel(readLevel);
                MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL), Long.valueOf(readLevel));
            }
        });
        get(41, MessageID.MSG_TRIGGER_NOISE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.218
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readNoise();
            }
        });
        get(41, MessageID.MSG_TRIGGER_HOLDOFF).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.219
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readHoldOff();
            }
        });
        get(41, MessageID.MSG_TRIGGER_PULSE_SOURCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.220
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readPulseChan();
            }
        });
        get(41, MessageID.MSG_TRIGGER_PULSE_POLARITY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.221
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readPulsePolarity();
            }
        });
        get(41, MessageID.MSG_TRIGGER_PULSE_LOWER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.222
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readPulseLwidth();
            }
        });
        get(41, MessageID.MSG_TRIGGER_PULSE_UPPER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.223
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readPulseUwidth();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_PULSE_WIDTH).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.224
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readPulseUwidth();
                triggerParam.readPulseLwidth();
            }
        });
        get(41, MessageID.MSG_TRIGGER_PULSE_WHEN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.225
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readPulseWhen();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SLOPE_SOURCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.226
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSlopeChan();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SLOPE_WHEN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.227
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSlopeWhen();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SLOPE_LOWER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.228
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSlopeLwidth();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SLOPE_UPPER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.229
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSlopeUwidth();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_SLOPE_TIME).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.230
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSlopeUwidth();
                triggerParam.readSlopeLwidth();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SLOPE_POLARITY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.231
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSlopePolarity();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SLOPE_LEVELSELECT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.232
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readLevelSelect();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.233
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSlopeHighLevel();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.234
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSlopeLowLevel();
            }
        });
        get(41, MessageID.MSG_TRIGGER_VIDEO_SOURCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.235
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readVideoChan();
            }
        });
        get(41, MessageID.MSG_TRIGGER_VIDEO_POLARITY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.236
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readVideoPolarity();
            }
        });
        get(41, MessageID.MSG_TRIGGER_VIDEO_STANDARD).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.237
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readVideoStandard();
            }
        });
        get(41, MessageID.MSG_TRIGGER_VIDEO_SYNC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.238
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readVideoSync();
            }
        });
        get(41, MessageID.MSG_TRIGGER_VIDEO_LINENUM).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.239
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readVideoLine();
            }
        });
        get(41, MessageID.MSG_TRIGGER_PATTERN_SOURCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.240
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readPatternChan();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_PATTERN_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.241
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readPatternLevel();
            }
        });
        get(41, MessageID.MSG_TRIGGER_PATTERN_SET_CODE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.242
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readpatternValue();
            }
        });
        get(41, MessageID.MSG_TRIGGER_DURATION_SOURCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.243
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readDurationSource();
            }
        });
        get(41, MessageID.MSG_TRIGGER_DURATION_WHEN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.244
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readDurationWhen();
            }
        });
        get(41, MessageID.MSG_TRIGGER_DURATION_LOWER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.245
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readDurationLwidth();
            }
        });
        get(41, MessageID.MSG_TRIGGER_DURATION_UPPER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.246
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readDurationUwidth();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_DURATION_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.247
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readDurationLevel();
            }
        });
        get(41, MessageID.MSG_TRIGGER_DURATION_SET_CODE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.248
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readdurationPatternValue();
            }
        });
        get(41, MessageID.MSG_TRIGGER_TIMEOUT_SOURCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.249
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readTimeoutSource();
            }
        });
        get(41, MessageID.MSG_TRIGGER_TIMEOUT_SLOPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.250
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readTimeoutSlope();
            }
        });
        get(41, MessageID.MSG_TRIGGER_TIMEOUT_TIME).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.251
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readTimeoutTime();
            }
        });
        get(41, MessageID.MSG_TRIGGER_RUNT_SOURCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.252
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readRuntSource();
            }
        });
        get(41, MessageID.MSG_TRIGGER_RUNT_POLARITY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.253
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readRuntPolarity();
            }
        });
        get(41, MessageID.MSG_TRIGGER_RUNT_LEVELSELECT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.254
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readRuntLevelSelect();
            }
        });
        get(41, MessageID.MSG_TRIGGER_RUNT_WHEN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.255
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readRuntWhen();
            }
        });
        get(41, MessageID.MSG_TRIGGER_RUNT_LOWER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.256
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readRuntLwidth();
            }
        });
        get(41, MessageID.MSG_TRIGGER_RUNT_UPPER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.257
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readRuntUwidth();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.258
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readRuntHighLevel();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.259
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readRuntLowLevel();
            }
        });
        get(41, MessageID.MSG_TRIGGER_OVER_SOURCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.260
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readOverSource();
            }
        });
        get(41, MessageID.MSG_TRIGGER_OVER_SLOPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.261
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readOverSlope();
            }
        });
        get(41, MessageID.MSG_TRIGGER_OVER_POS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.262
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readOverPos();
            }
        });
        get(41, MessageID.MSG_TRIGGER_OVER_TIME).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.263
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readOverTime();
            }
        });
        get(41, MessageID.MSG_TRIGGER_OVER_LEVELSELECT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.264
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readOverLevelSelect();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.265
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readOverHighLevel();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.266
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readOverLowLevel();
            }
        });
        get(41, MessageID.MSG_TRIGGER_DELAY_SRCA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.267
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readDelaySourceA();
            }
        });
        get(41, MessageID.MSG_TRIGGER_DELAY_SRCB).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.268
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readDelaySourceB();
            }
        });
        get(41, MessageID.MSG_TRIGGER_DELAY_WHEN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.269
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readDelayWhen();
            }
        });
        get(41, MessageID.MSG_TRIGGER_DELAY_EDGA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.270
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readDelaySlopeA();
            }
        });
        get(41, MessageID.MSG_TRIGGER_DELAY_EDGB).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.271
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readDelaySlopeB();
            }
        });
        get(41, MessageID.MSG_TRIGGER_DELAY_LOWER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.272
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readDelayLwidth();
            }
        });
        get(41, MessageID.MSG_TRIGGER_DELAY_UPPER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.273
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readDelayUwidth();
            }
        });
        get(41, MessageID.MSG_SCPI_DELAY_LEVEL_H).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.274
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                TriggerParam triggerParam2 = triggerParam;
                triggerParam2.setLevel(triggerParam2.getDelaylevelA());
                TriggerParam triggerParam3 = triggerParam;
                triggerParam3.syncData(MessageID.MSG_TRIGGER_LEVEL, Long.valueOf(triggerParam3.getDelaylevelA()));
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.275
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readDelayHighLevel();
            }
        });
        get(41, MessageID.MSG_SCPI_DELAY_LEVEL_L).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.276
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                TriggerParam triggerParam2 = triggerParam;
                triggerParam2.setLevel(triggerParam2.getDelaylevelB());
                TriggerParam triggerParam3 = triggerParam;
                triggerParam3.syncData(MessageID.MSG_TRIGGER_LEVEL, Long.valueOf(triggerParam3.getDelaylevelB()));
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.277
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readDelayLowLevel();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SETUP_SCL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.278
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSetupHoldSourceA();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SETUP_SDA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.279
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSetupHoldSourceB();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SETUP_SLOPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.280
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSetupHoldSlope();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SETUP_DATA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.281
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSetupHoldDataType();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SETUP_WHEN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.282
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSetupHoldWhen();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SETUP_TIME).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.283
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSetupTime();
            }
        });
        get(41, MessageID.MSG_TRIGGER_HOLD_TIME).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.284
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readHoldTime();
            }
        });
        get(41, MessageID.MSG_SCPI_SETUP_LEVEL_H).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.285
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                TriggerParam triggerParam2 = triggerParam;
                triggerParam2.setLevel(triggerParam2.getSetupHoldlevelB());
                TriggerParam triggerParam3 = triggerParam;
                triggerParam3.syncData(MessageID.MSG_TRIGGER_LEVEL, Long.valueOf(triggerParam3.getSetupHoldlevelB()));
            }
        });
        get(41, MessageID.MSG_SCPI_SETUP_LEVEL_L).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.286
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                TriggerParam triggerParam2 = triggerParam;
                triggerParam2.setLevel(triggerParam2.getSetupHoldlevelA());
                TriggerParam triggerParam3 = triggerParam;
                triggerParam3.syncData(MessageID.MSG_TRIGGER_LEVEL, Long.valueOf(triggerParam3.getSetupHoldlevelA()));
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.287
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSetupHoldHighLevel();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.288
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSetupHoldLowLevel();
            }
        });
        get(41, MessageID.MSG_TRIGGER_NTH_SOURCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.289
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readNthSource();
            }
        });
        get(41, MessageID.MSG_TRIGGER_NTH_SLOPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.290
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readNthSlope();
            }
        });
        get(41, MessageID.MSG_TRIGGER_NTH_IDLETIME).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.291
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readNthidelTime();
            }
        });
        get(41, MessageID.MSG_TRIGGER_NTH_EDGE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.292
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readNthedgeNumber();
            }
        });
        get(41, MessageID.MSG_TRIGGER_RS232_SOURCE_LA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.293
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readRS232Source();
            }
        });
        get(41, MessageID.MSG_TRIGGER_RS232_WHEN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.294
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readRS232When();
            }
        });
        get(41, MessageID.MSG_TRIGGER_RS232_CHECK).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.295
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readRS232Parity();
            }
        });
        get(41, MessageID.MSG_TRIGGER_RS232_POLARITY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.296
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readRS232Polarity();
            }
        });
        get(41, MessageID.MSG_TRIGGER_RS232_STOPBIT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.297
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readRS232StopBit();
            }
        });
        get(41, MessageID.MSG_TRIGGER_RS232_DATA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.298
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readRs232Data();
            }
        });
        get(41, MessageID.MSG_TRIGGER_RS232_DATAWIDTH).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.299
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readRS232DataWidth();
            }
        });
        get(41, MessageID.MSG_TRIGGER_RS232_BAUDRATE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.300
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readRS232Baudrate();
            }
        });
        get(41, MessageID.MSG_TRIGGER_I2C_SCL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.301
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readI2CScl();
            }
        });
        get(41, MessageID.MSG_TRIGGER_I2C_SDA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.302
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readI2CSda();
            }
        });
        get(41, MessageID.MSG_TRIGGER_I2C_WHEN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.303
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readI2CWhen();
            }
        });
        get(41, MessageID.MSG_TRIGGER_I2C_ADDRDATA_BITS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.304
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readI2CAddrData();
            }
        });
        get(41, MessageID.MSG_TRIGGER_I2C_ADDRESS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.305
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readI2cAddress();
            }
        });
        get(41, MessageID.MSG_TRIGGER_I2C_BYTELENGTH).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.306
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readByteLength();
            }
        });
        get(41, MessageID.MSG_TRIGGER_I2C_DIRECTION).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.307
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readI2CDirection();
            }
        });
        get(41, MessageID.MSG_TRIGGER_I2C_DATA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.308
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readI2CData();
            }
        });
        get(41, MessageID.MSG_TRIGGER_I2C_CODE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.309
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readI2cCode();
            }
        });
        get(41, MessageID.MSG_SCPI_I2C_LEVEL_CLK).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.310
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                TriggerParam triggerParam2 = triggerParam;
                triggerParam2.setLevel(triggerParam2.getIiclevelA());
                TriggerParam triggerParam3 = triggerParam;
                triggerParam3.syncData(MessageID.MSG_TRIGGER_LEVEL, Long.valueOf(triggerParam3.getIiclevelA()));
            }
        });
        get(41, MessageID.MSG_SCPI_I2C_LEVEL_DATA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.311
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                TriggerParam triggerParam2 = triggerParam;
                triggerParam2.setLevel(triggerParam2.getIiclevelB());
                TriggerParam triggerParam3 = triggerParam;
                triggerParam3.syncData(MessageID.MSG_TRIGGER_LEVEL, Long.valueOf(triggerParam3.getIiclevelB()));
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.312
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readI2CClkLevel();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.313
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readI2CDataLevel();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SPI_SCL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.314
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSpiScl();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SPI_SDA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.315
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSpiSda();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SPI_CS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.316
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSpiCs();
            }
        });
        get(41, MessageID.MSG_SCPI_SPI_LEVEL_CLK).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.317
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                TriggerParam triggerParam2 = triggerParam;
                triggerParam2.setLevel(triggerParam2.getSpilevelA());
                TriggerParam triggerParam3 = triggerParam;
                triggerParam3.syncData(MessageID.MSG_TRIGGER_LEVEL, Long.valueOf(triggerParam3.getSpilevelA()));
            }
        });
        get(41, MessageID.MSG_SCPI_SPI_LEVEL_DATA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.318
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                TriggerParam triggerParam2 = triggerParam;
                triggerParam2.setLevel(triggerParam2.getSpilevelB());
                TriggerParam triggerParam3 = triggerParam;
                triggerParam3.syncData(MessageID.MSG_TRIGGER_LEVEL, Long.valueOf(triggerParam3.getSpilevelB()));
            }
        });
        get(41, MessageID.MSG_SCPI_SPI_LEVEL_CS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.319
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                TriggerParam triggerParam2 = triggerParam;
                triggerParam2.setLevel(triggerParam2.getSpilevelC());
                TriggerParam triggerParam3 = triggerParam;
                triggerParam3.syncData(MessageID.MSG_TRIGGER_LEVEL, Long.valueOf(triggerParam3.getSpilevelC()));
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.320
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSpiClkLevel();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.321
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSpiDataLevel();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.322
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSpiCsLevel();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SPI_SLOPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.323
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSpiSlope();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SPI_WHEN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.324
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSpiWhen();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SPI_CSMODE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.325
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSpiCsMode();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SPI_TIMEOUT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.326
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSpiTimeout();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SPI_DATA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.327
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSpiData();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SPI_CODE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.328
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSpiCode();
            }
        });
        get(41, MessageID.MSG_TRIGGER_SPI_DATABITS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.329
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readSpiDataBits();
            }
        });
        get(41, MessageID.MSG_TRIGGER_CAN_SOURCE_LA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.330
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readCanSource();
            }
        });
        get(41, MessageID.MSG_TRIGGER_CAN_BAUD).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.331
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readCanBaud();
            }
        });
        get(41, MessageID.MSG_TRIGGER_CANFD_BAUD).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.332
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readCanFdBaud();
            }
        });
        get(41, MessageID.MSG_TRIGGER_CAN_SINGNAL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.333
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readCanSingnal();
            }
        });
        get(41, MessageID.MSG_TRIGGER_CAN_WHEN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.334
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readCanWhen();
            }
        });
        get(41, MessageID.MSG_TRIGGER_CAN_SAMPLE_POINT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.335
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readCanSamplePoint();
            }
        });
        get(41, MessageID.MSG_TRIGGER_CAN_FD_SAMPLE_POINT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.336
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readCanFdSamplePoint();
            }
        });
        get(41, MessageID.MSG_TRIGGER_CAN_ID_EXTENDED).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.337
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readCanIdExtended();
            }
        });
        get(41, MessageID.MSG_TRIGGER_CAN_DEFINE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.338
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readCanDefine();
            }
        });
        get(41, MessageID.MSG_TRIGGER_CAN_DATA_BYTE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.339
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readCanDataByte();
            }
        });
        get(41, MessageID.MSG_TRIGGER_CAN_ID_FILTER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.340
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readCanIdFilter();
            }
        });
        get(41, MessageID.MSG_TRIGGER_CAN_DATA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.341
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readCanData();
            }
        });
        get(41, MessageID.MSG_TRIGGER_CAN_CODE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.342
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readCanCode();
            }
        });
        get(41, MessageID.MSG_TRIGGER_FLEXRAY_SOURCE_LA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.343
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readFlexRaySource();
            }
        });
        get(41, MessageID.MSG_TRIGGER_FLEXRAY_BAUD).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.344
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readFlexRayBaud();
            }
        });
        get(41, MessageID.MSG_TRIGGER_FLEXRAY_WHEN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.345
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readFlexRayWhen();
            }
        });
        get(41, MessageID.MSG_TRIGGER_FLEXRAY_POST_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.346
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readFlexRayPost();
            }
        });
        get(41, MessageID.MSG_TRIGGER_FLEXRAY_ERROR_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.347
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readFlexRayError();
            }
        });
        get(41, MessageID.MSG_TRIGGER_FLEXRAY_SYMBOL_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.348
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readFlexRaySymbol();
            }
        });
        get(41, MessageID.MSG_TRIGGER_FLEXRAY_FRAME_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.349
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readFlexRayFrame();
            }
        });
        get(41, MessageID.MSG_TRIGGER_FLEXRAY_DEFINE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.350
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readFlexrayDefine();
            }
        });
        get(41, MessageID.MSG_TRIGGER_FLEXRAY_ID_COMP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.351
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readFlexRayIDcomp();
            }
        });
        get(41, MessageID.MSG_TRIGGER_FLEXRAY_CYC_COMP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.352
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readFlexRayCYCcomp();
            }
        });
        get(41, MessageID.MSG_TRIGGER_FLEXRAY_CH_A_B).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.353
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readFlexRayCH();
            }
        });
        get(41, MessageID.MSG_TRIGGER_FLEXRAY_CYC_MAX).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.354
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readFlexRayCYCmax();
            }
        });
        get(41, MessageID.MSG_TRIGGER_FLEXRAY_CYC_MIN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.355
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readFlexRayCYCmin();
            }
        });
        get(41, MessageID.MSG_TRIGGER_FLEXRAY_ID_MAX).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.356
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readFlexRayIDmax();
            }
        });
        get(41, MessageID.MSG_TRIGGER_FLEXRAY_ID_MIN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.357
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readFlexRayIDmin();
            }
        });
        get(41, MessageID.MSG_TRIGGER_LIN_SOURCE_LA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.358
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readLinSource();
            }
        });
        get(41, MessageID.MSG_TRIGGER_LIN_VERSION).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.359
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readLinVersion();
            }
        });
        get(41, MessageID.MSG_TRIGGER_LIN_BAUD).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.360
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readLinBaud();
            }
        });
        get(41, MessageID.MSG_TRIGGER_LIN_SAMPLE_POINT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.361
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readLinSamplePosition();
            }
        });
        get(41, MessageID.MSG_TRIGGER_LIN_WHEN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.362
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readLinWhen();
            }
        });
        get(41, MessageID.MSG_TRIGGER_LIN_ERR_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.363
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readLinErrType();
            }
        });
        get(41, MessageID.MSG_TRIGGER_LIN_ID).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.364
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readLinID();
            }
        });
        get(41, MessageID.MSG_TRIGGER_LIN_DATA_BYTE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.365
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readLinDataByte();
            }
        });
        get(41, MessageID.MSG_TRIGGER_LIN_DATA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.366
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readLinData();
            }
        });
        get(41, MessageID.MSG_TRIGGER_LIN_CODE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.367
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readLinCode();
            }
        });
        get(41, MessageID.MSG_TRIGGER_IIS_DATA_MIN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.368
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readDataMin();
            }
        });
        get(41, MessageID.MSG_TRIGGER_IIS_DATA_MAX).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.369
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readDataMax();
            }
        });
        get(41, MessageID.MSG_TRIGGER_IIS_SCLK).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.370
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readclkSource();
            }
        });
        get(41, MessageID.MSG_TRIGGER_IIS_WS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.371
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readwsSource();
            }
        });
        get(41, MessageID.MSG_TRIGGER_IIS_SDA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.372
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readsdaSource();
            }
        });
        get(41, MessageID.MSG_TRIGGER_IIS_SLOPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.373
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readclkEdge();
            }
        });
        get(41, MessageID.MSG_TRIGGER_IIS_WS_LOW).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.374
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readAudio();
            }
        });
        get(41, MessageID.MSG_TRIGGER_IIS_WHEN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.375
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readiisWhen();
            }
        });
        get(41, MessageID.MSG_TRIGGER_IIS_USER_WIDTH).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.376
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readwidth();
            }
        });
        get(41, MessageID.MSG_TRIGGER_IIS_WIDTH).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.377
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readallWidth();
            }
        });
        get(41, MessageID.MSG_TRIGGER_IIS_ALIGNMENT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.378
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readAlignment();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_DATA_IIS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.379
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readIisData();
            }
        });
        get(41, MessageID.MSG_TRIGGER_I2S_CODE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.380
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readIisCode();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.381
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readIisClkLevel();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.382
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readIisWsLevel();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.383
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readIisDataLevel();
            }
        });
        get(41, MessageID.MSG_SCPI_I2S_LEVEL_CLK).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.384
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                TriggerParam triggerParam2 = triggerParam;
                triggerParam2.setLevel(triggerParam2.getIislevelA());
                TriggerParam triggerParam3 = triggerParam;
                triggerParam3.syncData(MessageID.MSG_TRIGGER_LEVEL, Long.valueOf(triggerParam3.getIislevelA()));
            }
        });
        get(41, MessageID.MSG_SCPI_I2S_LEVEL_CS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.385
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                TriggerParam triggerParam2 = triggerParam;
                triggerParam2.setLevel(triggerParam2.getIislevelB());
                TriggerParam triggerParam3 = triggerParam;
                triggerParam3.syncData(MessageID.MSG_TRIGGER_LEVEL, Long.valueOf(triggerParam3.getIislevelB()));
            }
        });
        get(41, MessageID.MSG_SCPI_I2S_LEVEL_DATA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.386
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                TriggerParam triggerParam2 = triggerParam;
                triggerParam2.setLevel(triggerParam2.getIislevelC());
                TriggerParam triggerParam3 = triggerParam;
                triggerParam3.syncData(MessageID.MSG_TRIGGER_LEVEL, Long.valueOf(triggerParam3.getIislevelC()));
            }
        });
        get(41, MessageID.MSG_TRIGGER_1553B_DATA_MIN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.387
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readMilstdDataMin();
            }
        });
        get(41, MessageID.MSG_TRIGGER_1553B_DATA_MAX).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.388
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readMilstdDataMax();
            }
        });
        get(41, MessageID.MSG_TRIGGER_1553B_RTA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.389
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readMilstdDataRta();
            }
        });
        get(41, MessageID.MSG_TRIGGER_1553B_RTA_11).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.390
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readMilstdDataBit();
            }
        });
        get(41, MessageID.MSG_TRIGGER_1553B_SOURCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.391
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readMilstdSource();
            }
        });
        get(41, MessageID.MSG_TRIGGER_1553B_POLARITY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.392
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readMilstdPolarity();
            }
        });
        get(41, MessageID.MSG_TRIGGER_1553B_WHEN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.393
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readMilstdWhen();
            }
        });
        get(41, MessageID.MSG_TRIGGER_1553B_LEVELSELECT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.394
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readMilstdLevelSelect();
            }
        });
        get(41, MessageID.MSG_TRIGGER_1553B_SYNC_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.395
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readMilstdSyncType();
            }
        });
        get(41, MessageID.MSG_TRIGGER_1553B_ERR_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.396
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readMilstdErrType();
            }
        });
        get(41, MessageID.MSG_TRIGGER_1553B_DATA_COMP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.397
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readMilstdDataComp();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.398
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readMilstdHighLevel();
            }
        });
        get(41, MessageID.MSG_TRIGGER_1553B_LEVEL_H).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.399
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readMilstdHighLevel();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.400
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readMilstdLowLevel();
            }
        });
        get(41, MessageID.MSG_TRIGGER_1553B_LEVEL_L).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.401
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readMilstdLowLevel();
            }
        });
        get(41, MessageID.CMD_SCPI_TRIGGER_DATA_1553).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.402
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readMilstdData();
            }
        });
        get(41, MessageID.MSG_TRIGGER_1553B_CODE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.403
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                triggerParam.readMilstdCode();
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final DecodeParam decodeParam) {
        if (decodeParam == null) {
            return;
        }
        final int serviceId = decodeParam.getServiceId();
        get(serviceId, MessageID.MSG_DECODE_PAL_DAT_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.404
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readPal_dat_thres();
                decodeParam.readPalBusThresAttr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_PAL_CLK_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.405
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readPal_clk_thres();
                decodeParam.readPalClkThresAttr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_TX_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.406
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readRs232_tx_thres();
                decodeParam.readTxThresAttr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_RX_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.407
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readRs232_rx_thres();
                decodeParam.readRxThresAttr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SCL_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.408
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readI2c_scl_thres();
                decodeParam.readI2cClkThresAttr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SDA_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.409
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readI2c_sda_thres();
                decodeParam.readI2cDataThresAttr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2S_SCLK_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.410
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readI2s_sclock_thres();
                decodeParam.readI2sSclkThresAttr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2S_WS_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.411
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readI2s_wave_singal_thres();
                decodeParam.readI2sWsThresAttr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2S_DATA_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.412
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readI2s_data_thres();
                decodeParam.readI2sDataThresAttr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_CLK_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.413
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSpi_clock_thres();
                decodeParam.readSpiClkThresAttr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_MISO_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.414
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSpi_miso_thres();
                decodeParam.readSpiMisoThresAttr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_MOSI_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.415
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSpi_mosi_thres();
                decodeParam.readSpiMosiThresAttr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_MOSI_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.416
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSpi_cs_thres();
                decodeParam.readSpiCsThresAttr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_LIN_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.417
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readLin_thres();
                decodeParam.readLinThresAttr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_CAN_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.418
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readCan_threas();
                decodeParam.readCanThresAttr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_CAN_SAMP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.419
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readCan_samp();
                decodeParam.readCanSamplePosAttr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_CANFD_SAMP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.420
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readCan_fd_samp();
                decodeParam.readCanFdSamplePosAttr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_FLEX_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.421
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readFlex_thres();
                decodeParam.readFlexThresAttr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_FLEX_SAMP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.422
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readFlex_samp();
                decodeParam.readFlexSamplePosAttr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_1553B_THRE1).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.423
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.read_1553b_thres1();
                decodeParam.readMilstdThres1Attr();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_APPLY_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.424
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.checkThres();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_PAL_BUS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.425
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readPal_bus();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_BUS_WIDTH).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.426
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readPalBus_width();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_BUS_BITX).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.427
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readPalBus_bitx();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_BUS_CH).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.428
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readPalBus_chan();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.429
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readType();
                MessageBus.getInstance().onSyncData(MessageBus.getKey(serviceId, MessageID.MSG_DECODE_TYPE), "UPDATEUI");
            }
        });
        get(serviceId, MessageID.MSG_DECODE_ONOFF).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.430
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readBus_ONOFF();
                ViewUtil.getFlexKnobParamViewModel().refreshCHList();
                FunctionManager.getInstance().decodeSwitch = decodeParam.readBool(MessageID.MSG_DECODE_ONOFF);
                MessageBus.getInstance().onSyncData(MessageBus.getKey(10, MessageID.MSG_HOR_REFRESH_ULTRAL_ENABLE), null);
            }
        });
        get(serviceId, MessageID.MSG_DECODE_FORMAT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.431
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readBus_Format();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_EVT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.432
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readBus_Evt();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_EVT_FORMAT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.433
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readBus_EvtFormat();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_EVT_VIEW).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.434
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readBus_EvtView();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_LABEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.435
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readBus_Label();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_POS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.436
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readBus_Pos();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_PAL_CLK).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.437
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readPal_Clk();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_PAL_CLK_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.438
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readPalClkThresAttr();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_PAL_CLK_THRE, Long.valueOf(decodeParam2.getPal_clk_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.439
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_Parallel || decodeParam.getPal_clk_thres() == decodeParam.readLong(MessageID.MSG_DECODE_PAL_CLK_THRE)) {
                    return;
                }
                decodeParam.readPal_clk_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_PAL_CLK_THRE, Long.valueOf(decodeParam2.getPal_clk_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_PAL_DAT_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.440
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_PAL_DAT_THRE, Long.valueOf(decodeParam2.getPal_dat_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.441
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_Parallel || decodeParam.getPal_dat_thres() == decodeParam.readLong(MessageID.MSG_DECODE_PAL_DAT_THRE)) {
                    return;
                }
                decodeParam.readPal_dat_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_PAL_DAT_THRE, Long.valueOf(decodeParam2.getPal_dat_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_PAL_CLK_EDGE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.442
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readPal_ClkEdge();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_POLARITY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.443
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readPal_Polarity();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_PAL_NRJ).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.444
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readPal_Nrj();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_NRJ_TIME).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.445
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readPal_NrjTime();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_PAL_ENDIAN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.446
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readPal_Endian();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_RS232_TX).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.447
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readRs232_tx();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_TX_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.448
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_TX_THRE, Long.valueOf(decodeParam2.getRs232_tx_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.449
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_RS232 || decodeParam.getRs232_tx() == ServiceEnum.Chan.chan_none.value1 || decodeParam.getRs232_tx_thres() == decodeParam.readLong(MessageID.MSG_DECODE_TX_THRE)) {
                    return;
                }
                decodeParam.readRs232_tx_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_TX_THRE, Long.valueOf(decodeParam2.getRs232_tx_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_RS232_POL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.450
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readRs232_pol();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_RS232_RX).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.451
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readRs232_rx();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_RX_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.452
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_RX_THRE, Long.valueOf(decodeParam2.getRs232_rx_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.453
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_RS232 || decodeParam.getRs232_rx() == ServiceEnum.Chan.chan_none.value1 || decodeParam.getRs232_rx_thres() == decodeParam.readLong(MessageID.MSG_DECODE_RX_THRE)) {
                    return;
                }
                decodeParam.readRs232_rx_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_RX_THRE, Long.valueOf(decodeParam2.getRs232_rx_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_RS232_BAUD).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.454
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readRs232_baud();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_RS232_WIDTH).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.455
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readRs232_width();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_RS232_PARITY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.456
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readRs232_parity();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_RS232_STOP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.457
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readRs232_stop();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_RS232_ENDIAN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.458
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readRs232_endian();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_RS232_PACKEN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.459
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readRs232_package();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_RS232_PACKEND).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.460
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readRs232_package_end();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2C_SCL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.461
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readI2c_scl();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2C_SDA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.462
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readI2c_sda();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SCL_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.463
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_SCL_THRE, Long.valueOf(decodeParam2.getI2c_scl_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.464
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_I2C || decodeParam.getI2c_scl_thres() == decodeParam.readLong(MessageID.MSG_DECODE_SCL_THRE)) {
                    return;
                }
                decodeParam.readI2c_scl_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_SCL_THRE, Long.valueOf(decodeParam2.getI2c_scl_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SDA_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.465
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_SDA_THRE, Long.valueOf(decodeParam2.getI2c_sda_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.466
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_I2C || decodeParam.getI2c_sda_thres() == decodeParam.readLong(MessageID.MSG_DECODE_SDA_THRE)) {
                    return;
                }
                decodeParam.readI2c_sda_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_SDA_THRE, Long.valueOf(decodeParam2.getI2c_sda_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2C_EXC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.467
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readI2c_exchange();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2C_RW).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.468
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readI2c_read_write();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SPI_CLK).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.469
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSpi_clock();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_CLK_EDGE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.470
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSpi_clock_edge();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SPI_MISO).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.471
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSpi_miso();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SPI_MOSI).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.472
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSpi_mosi();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_CLK_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.473
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_CLK_THRE, Long.valueOf(decodeParam2.getSpi_clock_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.474
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_SPI || decodeParam.getSpi_clock_thres() == decodeParam.readLong(MessageID.MSG_DECODE_CLK_THRE)) {
                    return;
                }
                decodeParam.readSpi_clock_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_CLK_THRE, Long.valueOf(decodeParam2.getSpi_clock_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_MISO_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.475
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_MISO_THRE, Long.valueOf(decodeParam2.getSpi_miso_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.476
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_SPI || decodeParam.getSpi_miso_thres() == decodeParam.readLong(MessageID.MSG_DECODE_MISO_THRE)) {
                    return;
                }
                decodeParam.readSpi_miso_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_MISO_THRE, Long.valueOf(decodeParam2.getSpi_miso_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_MOSI_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.477
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_MOSI_THRE, Long.valueOf(decodeParam2.getSpi_mosi_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.478
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_SPI || decodeParam.getSpi_mosi_thres() == decodeParam.readLong(MessageID.MSG_DECODE_MOSI_THRE)) {
                    return;
                }
                decodeParam.readSpi_mosi_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_MOSI_THRE, Long.valueOf(decodeParam2.getSpi_mosi_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_DAT_POL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.479
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSpi_data_polarity();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SPI_MODE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.480
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSpi_mode();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SPI_ENDIAN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.481
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSpi_endian();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SPI_WIDTH).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.482
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSpi_width();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SPI_TMO).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.483
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSpi_timeout();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SPI_CS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.484
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSpi_cs();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_CS_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.485
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_CS_THRE, Long.valueOf(decodeParam2.getSpi_cs_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.486
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_SPI || decodeParam.getSpi_cs_thres() == decodeParam.readLong(MessageID.MSG_DECODE_CS_THRE)) {
                    return;
                }
                decodeParam.readSpi_cs_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_CS_THRE, Long.valueOf(decodeParam2.getSpi_cs_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_CS_POL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.487
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSpi_cs_polarity();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_CAN_SRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.488
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readCan_source();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_CAN_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.489
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_CAN_THRE, Long.valueOf(decodeParam2.getCan_threas()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.490
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_CAN || decodeParam.getCan_threas() == decodeParam.readLong(MessageID.MSG_DECODE_CAN_THRE)) {
                    return;
                }
                decodeParam.readCan_threas();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_CAN_THRE, Long.valueOf(decodeParam2.getCan_threas()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_CAN_SIGNAL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.491
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readCan_singal();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_CAN_BAUD).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.492
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readCan_baud();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_CAN_SAMP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.493
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readCan_samp();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_FLEX_SRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.494
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readFlex_source();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_FLEX_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.495
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_FLEX_THRE, Long.valueOf(decodeParam2.getFlex_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.496
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_FlexRay || decodeParam.getFlex_thres() == decodeParam.readLong(MessageID.MSG_DECODE_FLEX_THRE)) {
                    return;
                }
                decodeParam.readFlex_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_FLEX_THRE, Long.valueOf(decodeParam2.getFlex_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_FLEX_BAUD).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.497
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readFlex_baud();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_FLEX_SAMP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.498
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readFlex_samp();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_FLEX_SIGNAL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.499
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readFlex_signal();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_FLEX_CHANNEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.500
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readFlex_channel();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_LIN_SRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.501
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readLin_source();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_LIN_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.502
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_LIN_THRE, Long.valueOf(decodeParam2.getLin_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.503
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_LIN || decodeParam.getLin_thres() == decodeParam.readLong(MessageID.MSG_DECODE_LIN_THRE)) {
                    return;
                }
                decodeParam.readLin_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_LIN_THRE, Long.valueOf(decodeParam2.getLin_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_LIN_BAUD).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.504
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readLin_baud();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_LIN_VER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.505
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readLin_version();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_LIN_PARITY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.506
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readLin_parity_bit();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2S_SCLK).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.507
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readI2s_sclock();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2S_SCLKEDGE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.508
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readI2s_sclock_edge();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2S_WS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.509
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readI2s_ws();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2S_DATA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.510
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readI2s_data();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2S_SCLK_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.511
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_I2S_SCLK_THRE, Long.valueOf(decodeParam2.getI2s_sclock_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.512
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_I2S || decodeParam.getI2s_sclock_thres() == decodeParam.readLong(MessageID.MSG_DECODE_I2S_SCLK_THRE)) {
                    return;
                }
                decodeParam.readI2s_sclock_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_I2S_SCLK_THRE, Long.valueOf(decodeParam2.getI2s_sclock_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2S_WS_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.513
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_I2S_WS_THRE, Long.valueOf(decodeParam2.getI2s_wave_singal_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.514
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_I2S || decodeParam.getI2s_wave_singal_thres() == decodeParam.readLong(MessageID.MSG_DECODE_I2S_WS_THRE)) {
                    return;
                }
                decodeParam.readI2s_wave_singal_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_I2S_WS_THRE, Long.valueOf(decodeParam2.getI2s_wave_singal_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2S_DATA_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.515
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_I2S_DATA_THRE, Long.valueOf(decodeParam2.getI2s_data_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.516
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_I2S || decodeParam.getI2s_data_thres() == decodeParam.readLong(MessageID.MSG_DECODE_I2S_DATA_THRE)) {
                    return;
                }
                decodeParam.readI2s_data_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_I2S_DATA_THRE, Long.valueOf(decodeParam2.getI2s_data_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2S_ALIGN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.517
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readI2s_align();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2S_WORD).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.518
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readI2s_word();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2S_RECEIVE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.519
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readI2s_receive();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2S_WSLOW).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.520
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readI2s_ws_low();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2S_ENDIAN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.521
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readI2s_endian();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2S_POL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.522
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readI2s_data_polarity();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_1553B_SRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.523
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.read_1553b_source();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_1553B_THRE1).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.524
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_1553B_THRE1, Long.valueOf(decodeParam2.get_1553b_thres1()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.525
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_1553B || decodeParam.get_1553b_thres1() == decodeParam.readLong(MessageID.MSG_DECODE_1553B_THRE1)) {
                    return;
                }
                decodeParam.read_1553b_thres1();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_1553B_THRE1, Long.valueOf(decodeParam2.get_1553b_thres1()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_ARINC429_SRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.526
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readArinc429_source();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_ARINC429_UP_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.527
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_ARINC429_UP_THRE, Long.valueOf(decodeParam2.getArinc429_up_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.528
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_ARINC429 || decodeParam.getArinc429_up_thres() == decodeParam.readLong(MessageID.MSG_DECODE_ARINC429_UP_THRE)) {
                    return;
                }
                decodeParam.readArinc429_up_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_ARINC429_UP_THRE, Long.valueOf(decodeParam2.getArinc429_up_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_ARINC429_DOWN_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.529
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_ARINC429_DOWN_THRE, Long.valueOf(decodeParam2.getArinc429_down_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.530
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_ARINC429 || decodeParam.getArinc429_down_thres() == decodeParam.readLong(MessageID.MSG_DECODE_ARINC429_DOWN_THRE)) {
                    return;
                }
                decodeParam.readArinc429_down_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_ARINC429_DOWN_THRE, Long.valueOf(decodeParam2.getArinc429_down_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_ARINC429_SIGNAL_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.531
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readArinc429_singal_type();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_ARINC429_BAUD).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.532
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readArinc429_baud();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_ARINC429_BYTE_FORMAT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.533
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readArinc429_byte_format();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SENT_SRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.534
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSent_source();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SENT_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.535
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_SENT_THRE, Long.valueOf(decodeParam2.getSent_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.536
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_SENT || decodeParam.getSent_thres() == decodeParam.readLong(MessageID.MSG_DECODE_SENT_THRE)) {
                    return;
                }
                decodeParam.readSent_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_SENT_THRE, Long.valueOf(decodeParam2.getSent_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SENT_TICK).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.537
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSent_tick();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SENT_TOLERANCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.538
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSent_tolerance();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SENT_NIBBNUM).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.539
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSent_nibbnum();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SENT_IDLE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.540
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSent_idle_state();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SENT_CRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.541
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSent_crc_format();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SENT_PAUSE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.542
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSent_pause_plus();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SENT_SIGNAL_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.543
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readSent_signal_type();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_MOST_SRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.544
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readMost_source();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_MOST_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.545
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_MOST_THRE, Long.valueOf(decodeParam2.getMost_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.546
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_MOST || decodeParam.getMost_thres() == decodeParam.readLong(MessageID.MSG_DECODE_MOST_THRE)) {
                    return;
                }
                decodeParam.readMost_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_MOST_THRE, Long.valueOf(decodeParam2.getMost_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_MOST_SIGNAL_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.547
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readMost_signal_type();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_USB_DP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.548
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readUsb_dp();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_USB_DS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.549
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readUsb_ds();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_USB_DIFF).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.550
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                decodeParam.readUsb_diff();
            }
        });
        get(serviceId, MessageID.MSG_DECODE_USB_DP_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.551
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_USB_DP_THRE, Long.valueOf(decodeParam2.getUsb_dp_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.552
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_USB || decodeParam.getUsb_dp_thres() == decodeParam.readLong(MessageID.MSG_DECODE_USB_DP_THRE)) {
                    return;
                }
                decodeParam.readUsb_dp_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_USB_DP_THRE, Long.valueOf(decodeParam2.getUsb_dp_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_USB_DS_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.553
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_USB_DS_THRE, Long.valueOf(decodeParam2.getUsb_ds_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.554
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_USB || decodeParam.getUsb_ds_thres() == decodeParam.readLong(MessageID.MSG_DECODE_USB_DS_THRE)) {
                    return;
                }
                decodeParam.readUsb_ds_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_USB_DS_THRE, Long.valueOf(decodeParam2.getUsb_ds_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_USB_DIFF_THRE_H).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.555
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_USB_DIFF_THRE_H, Long.valueOf(decodeParam2.getUsb_diff_high_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.556
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_USB || decodeParam.getUsb_diff_high_thres() == decodeParam.readLong(MessageID.MSG_DECODE_USB_DIFF_THRE_H)) {
                    return;
                }
                decodeParam.readUsb_diff_high_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_USB_DIFF_THRE_H, Long.valueOf(decodeParam2.getUsb_diff_high_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_USB_DIFF_THRE_L).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.557
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_USB_DIFF_THRE_L, Long.valueOf(decodeParam2.getUsb_diff_low_thres()));
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SRC_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.558
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_USB || decodeParam.getUsb_diff_low_thres() == decodeParam.readLong(MessageID.MSG_DECODE_USB_DIFF_THRE_L)) {
                    return;
                }
                decodeParam.readUsb_diff_low_thres();
                DecodeParam decodeParam2 = decodeParam;
                decodeParam2.syncData(MessageID.MSG_DECODE_USB_DIFF_THRE_L, Long.valueOf(decodeParam2.getUsb_diff_low_thres()));
            }
        });
        get(serviceId, MessageID.MSG_SCPI_DECODE_EVT_SAVE).observe(lifecycleOwner, new AnonymousClass559(decodeParam, serviceId));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.viewmodels.UpdateUIViewModel$559  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass559 implements Observer<Boolean> {
        final /* synthetic */ DecodeParam val$param;
        final /* synthetic */ int val$serviceId;

        AnonymousClass559(DecodeParam decodeParam, int i) {
            this.val$param = decodeParam;
            this.val$serviceId = i;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(Boolean bool) {
            if (!this.val$param.isOnOff() || !this.val$param.isEvent()) {
                ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.msg_storage_toast_fail));
                return;
            }
            String UI_QueryStr = API.getInstance().UI_QueryStr(this.val$serviceId, MessageID.MSG_SCPI_DECODE_EVT_SAVE);
            if (TextUtils.isEmpty(UI_QueryStr)) {
                ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.msg_storage_toast_fail));
                return;
            }
            String str = null;
            List<DiskParam> diskList = UtilityUtil.getDiskList();
            int i = 0;
            while (true) {
                if (i >= diskList.size()) {
                    break;
                }
                DiskParam diskParam = diskList.get(i);
                if (diskParam != null) {
                    String shorterName = diskParam.getShorterName();
                    if (DiskParamKt.DEFAULT_SHORTER_NAME.equals(shorterName)) {
                        shorterName = "C:";
                    }
                    if (shorterName != null && UI_QueryStr.startsWith(shorterName)) {
                        str = UI_QueryStr.replace(shorterName, diskParam.getRoot());
                        break;
                    }
                }
                i++;
            }
            if (str == null) {
                ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.msg_storage_toast_fail));
                return;
            }
            String UI_QueryStr2 = API.getInstance().UI_QueryStr(this.val$serviceId, MessageID.MSG_APP_DECODE_QUERY_EVT_CONTENT);
            if (!TextUtils.isEmpty(str)) {
                str = str.replace("\\", "/");
            }
            final BasePopupView basePopupView = PopupViewManager.getInstance().get(SavingLoading.class);
            final AnonymousClass1 anonymousClass1 = new AnonymousClass1(UI_QueryStr2, str, basePopupView);
            if (basePopupView instanceof SavingLoading) {
                SavingLoading savingLoading = (SavingLoading) basePopupView;
                savingLoading.setCancelListener(new View.OnClickListener() { // from class: com.rigol.scope.viewmodels.-$$Lambda$UpdateUIViewModel$559$-d0DHWpfet_aYajT-mbpsZPOY8g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UpdateUIViewModel.AnonymousClass559.lambda$onChanged$0(BasePopupView.this, anonymousClass1, view);
                    }
                });
                savingLoading.isShowWrning().set(!str.startsWith(DiskManageParam.DEFAULT_PATH));
                Objects.requireNonNull(basePopupView);
                ThreadUtils.runOnUiThread(new Runnable() { // from class: com.rigol.scope.viewmodels.-$$Lambda$z-tarIOTQvB_bequvIW5VQCI6RI
                    @Override // java.lang.Runnable
                    public final void run() {
                        BasePopupView.this.show();
                    }
                });
            }
            ThreadUtils.executeByIo(anonymousClass1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.rigol.scope.viewmodels.UpdateUIViewModel$559$1  reason: invalid class name */
        /* loaded from: classes2.dex */
        public class AnonymousClass1 extends ThreadUtils.SimpleTask<Boolean> {
            final /* synthetic */ String val$csvFilePath;
            final /* synthetic */ String val$finalSavePath;
            final /* synthetic */ BasePopupView val$savingPopupView;

            AnonymousClass1(String str, String str2, BasePopupView basePopupView) {
                this.val$csvFilePath = str;
                this.val$finalSavePath = str2;
                this.val$savingPopupView = basePopupView;
            }

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public Boolean doInBackground() throws Throwable {
                return Boolean.valueOf(FileUtils.copy(this.val$csvFilePath, this.val$finalSavePath));
            }

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public void onSuccess(Boolean bool) {
                BasePopupView basePopupView = this.val$savingPopupView;
                if (basePopupView != null && basePopupView.isShowing()) {
                    BasePopupView basePopupView2 = this.val$savingPopupView;
                    Objects.requireNonNull(basePopupView2);
                    ThreadUtils.runOnUiThreadDelayed(new $$Lambda$UpdateUIViewModel$559$1$npxg_2oEf0XFEixaPw9z6ebRPfo(basePopupView2), 2000L);
                }
                if (bool.booleanValue()) {
                    ToastUtils.showShort((int) R.string.msg_storage_success);
                    ShellUtils.execCmdAsync("sync", true, (Utils.Consumer<ShellUtils.CommandResult>) new Utils.Consumer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$UpdateUIViewModel$559$1$0q8S42ze7OVjYllWgQ1KyDmUfuY
                        @Override // com.blankj.utilcode.util.Utils.Consumer
                        public final void accept(Object obj) {
                            Timber.d(((ShellUtils.CommandResult) obj).toString(), new Object[0]);
                        }
                    });
                    return;
                }
                ToastUtils.showShort((int) R.string.msg_storage_toast_fail);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public void onDone() {
                super.onDone();
                BasePopupView basePopupView = this.val$savingPopupView;
                if (basePopupView == null || !basePopupView.isShowing()) {
                    return;
                }
                BasePopupView basePopupView2 = this.val$savingPopupView;
                Objects.requireNonNull(basePopupView2);
                ThreadUtils.runOnUiThreadDelayed(new $$Lambda$UpdateUIViewModel$559$1$npxg_2oEf0XFEixaPw9z6ebRPfo(basePopupView2), 2000L);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$onChanged$0(BasePopupView basePopupView, ThreadUtils.SimpleTask simpleTask, View view) {
            basePopupView.dismiss();
            simpleTask.cancel();
        }
    }

    public void bind(LifecycleOwner lifecycleOwner, final CounterResultParam counterResultParam) {
        if (counterResultParam == null) {
            return;
        }
        int serviceId = counterResultParam.getServiceId();
        get(serviceId, MessageID.MSG_COUNTER_1_ENABLE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.560
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                counterResultParam.readEnable();
            }
        });
        get(serviceId, MessageID.MSG_COUNTER_1_MEAS_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.561
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                counterResultParam.readCounterType();
            }
        });
        get(serviceId, MessageID.MSG_COUNTER_1_RESOLUTION).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.562
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                counterResultParam.readResolution();
            }
        });
        get(serviceId, MessageID.MSG_COUNTER_1_SRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.563
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                counterResultParam.readSource();
            }
        });
        get(serviceId, MessageID.MSG_COUNTER_1_STAT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.564
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                counterResultParam.readCounterSwitch();
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final DvmResultParam dvmResultParam) {
        if (dvmResultParam == null) {
            return;
        }
        int serviceId = dvmResultParam.getServiceId();
        get(serviceId, MessageID.MSG_DVM_LIMIT_UPPER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.565
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                dvmResultParam.readLimitUpper();
                dvmResultParam.readUpperAttr();
            }
        });
        get(serviceId, MessageID.MSG_DVM_LIMIT_LOWER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.566
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                dvmResultParam.readLimitLower();
                dvmResultParam.readLowerAttr();
            }
        });
        get(serviceId, MessageID.MSG_DVM_MODE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.567
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                dvmResultParam.readMode();
            }
        });
        get(serviceId, MessageID.MSG_DVM_SRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.568
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                dvmResultParam.readSource();
            }
        });
        get(serviceId, MessageID.MSG_DVM_BEEP_ENABLE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.569
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                dvmResultParam.readBeeper();
            }
        });
        get(serviceId, MessageID.MSG_DVM_LIMIT_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.570
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                dvmResultParam.readLimitType();
            }
        });
        get(serviceId, MessageID.MSG_DVM_ENABLE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.571
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                dvmResultParam.readEnable();
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final NavigateParam navigateParam) {
        if (navigateParam == null) {
            return;
        }
        int serviceId = navigateParam.getServiceId();
        get(serviceId, MessageID.MSG_NAVIGATE_TIMEOFFSET_PLAYING).observe(lifecycleOwner, new Observer<Object>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.572
            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                MessageBus.getInstance().onSyncData(MessageBus.getKey(58, MessageID.MSG_NAVIGATE_TIMEOFFSET_PLAYING), "UPDATEUI");
            }
        });
        get(serviceId, MessageID.MSG_NAVIGATE_FRAMEDRAW_PLAYING).observe(lifecycleOwner, new Observer<Object>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.573
            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                MessageBus.getInstance().onSyncData(MessageBus.getKey(58, MessageID.MSG_NAVIGATE_TIMEOFFSET_PLAYING), "UPDATEUI");
            }
        });
        get(serviceId, MessageID.MSG_NAVIGATE_FRAMEDRAW_STARTFRAME).observe(lifecycleOwner, new Observer<Object>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.574
            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                navigateParam.readStartFrame();
            }
        });
        get(serviceId, MessageID.MSG_NAVIGATE_FRAMEDRAW_ENDFRAME).observe(lifecycleOwner, new Observer<Object>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.575
            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                navigateParam.readDisplayFrame();
                if (navigateParam.readIsOutFrame()) {
                    navigateParam.saveIsOutFrame();
                    ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.msg_navigate_framedraw_notout));
                }
            }
        });
        get(serviceId, MessageID.MSG_NAVIGATE_FRAMEDRAW_DISPLAYPAGE).observe(lifecycleOwner, new Observer<Object>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.576
            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                navigateParam.readPage();
            }
        });
        get(serviceId, MessageID.MSG_NAVIGATE_FRAMEDRAW_TOTALPAGE).observe(lifecycleOwner, new Observer<Object>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.577
            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                navigateParam.readMaxPage();
            }
        });
        get(serviceId, MessageID.MSG_NAVIGATE_MODE).observe(lifecycleOwner, new Observer<Object>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.578
            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                NavigateParam navigateParam2 = navigateParam;
                navigateParam2.setSelectMode(navigateParam2.readNavMode());
            }
        });
        get(serviceId, MessageID.MSG_NAVIGATE_TIMEOFFSET_SPEED).observe(lifecycleOwner, new Observer<Object>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.579
            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                navigateParam.readTimeSpeed();
            }
        });
        get(serviceId, MessageID.MSG_NAVIGATE_FRAMEDRAW_STARTFRAME).observe(lifecycleOwner, new Observer<Object>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.580
            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                navigateParam.readStartFrame();
            }
        });
        get(serviceId, MessageID.MSG_NAVIGATE_FRAMEDRAW_ENDFRAME).observe(lifecycleOwner, new Observer<Object>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.581
            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                navigateParam.readDisplayFrame();
            }
        });
        get(serviceId, MessageID.MSG_NAVIGATE_FRAMEDRAW_DISPLAYMODE).observe(lifecycleOwner, new Observer<Object>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.582
            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                navigateParam.readDisPlayMode();
            }
        });
        get(serviceId, MessageID.MSG_NAVIGATE_ENABLE).observe(lifecycleOwner, new Observer<Object>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.583
            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                if (navigateParam.readNavEnable()) {
                    PopupViewManager.getInstance().get(NavigatePopupView.class).show();
                } else {
                    PopupViewManager.getInstance().dismiss(NavigatePopupView.class);
                }
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final DisplayParam displayParam) {
        if (displayParam == null) {
            return;
        }
        int serviceId = displayParam.getServiceId();
        get(serviceId, MessageID.MSG_DISPLAY_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.584
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                displayParam.readType();
            }
        });
        get(serviceId, MessageID.MSG_DISPLAY_PERSISTIME).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.585
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                displayParam.readPersisTime();
            }
        });
        get(serviceId, MessageID.MSG_DISPLAY_WAVE_INTENSITY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.586
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                displayParam.readWaveIntensity();
            }
        });
        get(serviceId, MessageID.MSG_DISPLAY_GRID).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.587
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                displayParam.readGridType();
            }
        });
        get(serviceId, MessageID.MSG_DISPLAY_GRID_INTENSITY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.588
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                displayParam.readGridIntensity();
            }
        });
        get(serviceId, MessageID.MSG_WINDOW_TRANSPARENCY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.589
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                displayParam.readWindowTransparency();
            }
        });
        get(serviceId, MessageID.MSG_DISPLAY_APP_CURSORS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.590
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                displayParam.readCursorIntensity();
            }
        });
        get(serviceId, MessageID.MSG_DISPLAY_RULERS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.591
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                displayParam.readRulerEnable();
            }
        });
        get(serviceId, MessageID.MSG_DISPLAY_PALETTE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.592
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                displayParam.readPaletteEnable();
            }
        });
        get(serviceId, MessageID.MSG_DISPLAY_FREEZE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.593
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                displayParam.readWaveFreeze();
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final WaveRecordParam waveRecordParam) {
        if (waveRecordParam == null) {
            return;
        }
        int serviceId = waveRecordParam.getServiceId();
        get(serviceId, MessageID.MSG_RECORD_ONOFF).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.594
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                FunctionManager.getInstance().recordSwitch = waveRecordParam.readRecordOnOff();
                MessageBus.getInstance().onSyncData(MessageBus.getKey(10, MessageID.MSG_HOR_REFRESH_ULTRAL_ENABLE), null);
            }
        });
        get(serviceId, MessageID.MSG_RECORD_START).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.595
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                waveRecordParam.readRecordStart();
            }
        });
        get(serviceId, MessageID.MSG_RECORD_CURRENT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.596
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                waveRecordParam.readRecordCurrent();
            }
        });
        get(serviceId, MessageID.MSG_RECORD_FRAMESTART).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.597
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                waveRecordParam.readRecordFrameStart();
            }
        });
        get(serviceId, MessageID.MSG_RECORD_PLAYMODE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.598
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                waveRecordParam.readRecordPlayMode();
            }
        });
        get(serviceId, MessageID.MSG_RECORD_PLAYDIR).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.599
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                waveRecordParam.readRecordPlayDir();
            }
        });
        get(serviceId, MessageID.MSG_RECORD_PLAYINTERVAL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.600
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                waveRecordParam.readRecordPlayInterval();
            }
        });
        get(serviceId, MessageID.MSG_RECORD_STARTFRAME).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.601
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                waveRecordParam.readRecordStartFrame();
            }
        });
        get(serviceId, MessageID.MSG_RECORD_ENDFRAME).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.602
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                waveRecordParam.readRecordEndFrame();
            }
        });
        get(serviceId, MessageID.MSG_RECORD_INTERVAL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.603
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                waveRecordParam.readRecordInterval();
                waveRecordParam.readRecordIntervalAttr();
            }
        });
        get(serviceId, MessageID.MSG_RECORD_FRAMES).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.604
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                waveRecordParam.readRecordFrames();
            }
        });
        get(serviceId, MessageID.MSG_RECORD_MAXFRAMES).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.605
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                waveRecordParam.readRecordMaxFrames();
            }
        });
        get(serviceId, MessageID.MSG_RECORD_BEEPER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.606
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                waveRecordParam.readRecordBeeper();
            }
        });
        get(serviceId, MessageID.MSG_REC_RECED_COUNT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.607
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                waveRecordParam.readRecordCurrentFrames();
            }
        });
        get(serviceId, MessageID.MSG_REC_INNER_STATE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.608
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                waveRecordParam.readState();
            }
        });
        get(serviceId, MessageID.MSG_REC_TIME_STAMP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.609
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                waveRecordParam.readTime();
            }
        });
        get(serviceId, MessageID.MSG_RECORD_PLAY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.610
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                waveRecordParam.readRecordPlay();
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final UtilityParam utilityParam) {
        if (utilityParam == null) {
            return;
        }
        int serviceId = utilityParam.getServiceId();
        get(serviceId, MessageID.MSG_APP_UTILITY_LANGUAGE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.611
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readLanguage();
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_PROJECT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.612
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readProjectMode();
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_BEEPER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.613
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readBeeper();
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_TOUCH_VIBRATION_EN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.614
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readVibration();
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_POWER_STATUS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.615
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readPowerStatus();
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_AUXOUT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.616
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readAuxOut();
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_POWER_ON_SET).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.617
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readPowerOnSet();
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_SHOW_TIME).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.618
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readShowTime();
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_TIME).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.619
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readTime();
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_DATE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.620
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readDate();
            }
        });
        get(1, MessageID.MSG_CHAN_VER_EXPAND).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.621
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readVerticalExpand();
            }
        });
        get(1, MessageID.MSG_FLEX_ORDER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.622
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                ViewUtil.getFlexKnobParamViewModel().refreshCHList();
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_LOCK_KB).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.623
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readLockKeyboard();
                if (!utilityParam.getLockKeyboard()) {
                    ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_touch_enable));
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.TOUCH_LED_WHITE.value1, 0);
                } else {
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.TOUCH_LED_WHITE.value1, 1);
                    ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_touch_disable));
                }
                UtilityParam utilityParam2 = utilityParam;
                utilityParam2.saveReadInputKeyboard(utilityParam2.getLockKeyboard());
                PopupViewManager.getInstance().dismissAll(new Class[0]);
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_DISPLAY_BRIGHTNESS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.624
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readScreenBrightness();
            }
        });
        get(serviceId, MessageID.MSG_MISC_MODEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.625
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readModel();
            }
        });
        get(serviceId, MessageID.MSG_MISC_SERIAL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.626
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readSerial();
            }
        });
        get(11, MessageID.MSG_APP_UTILITY_QUICK_POWER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.627
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                Intent intent = new Intent();
                intent.setAction("com.rigol.watchdog.QuickOpenStatus");
                intent.putExtra("quickOpenStatus", "1");
                Context context = BaseApplicationContext.getContext();
                LogUtils.e("wxz data APP1");
                if (context != null) {
                    LogUtils.e("wxz data APP");
                    context.sendBroadcast(intent);
                }
            }
        });
        get(27, MessageID.MSG_QUICK_OPERATION).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.628
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readQuickOper();
            }
        });
        get(27, MessageID.MSG_QUICK_MEAS_ALL_SRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.629
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readMeasSrc();
            }
        });
        get(27, MessageID.MSG_QUICK_STAT_RESET).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.630
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readStatReet();
            }
        });
        get(27, MessageID.MSG_QUICK_SELECT_SAVE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.631
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readSaveGroup();
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_REF_CLOCK).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.632
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readRefClock();
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_SCREEN_WORD).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.633
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readScreenWord();
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_SCREEN_PICTURE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.634
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readScreenPicture();
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_SCREEN_TIME).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.635
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readScreenTime();
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_SCREEN_SELECT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.636
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                utilityParam.readScreenSelect();
            }
        });
        get(27, MessageID.MSG_QUICK_RESPONSE_PANEL_ACTION).observe(lifecycleOwner, new Observer<Object>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.637
            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                ViewUtil.quickAction();
            }
        });
        get(11, MessageID.MSG_APP_UTILITY_SCREEN_TOUCH).observe(lifecycleOwner, new Observer<Object>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.638
            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                long UI_QueryInt64 = API.getInstance().UI_QueryInt64(11, MessageID.MSG_APP_UTILITY_SCREEN_TOUCH);
                try {
                    ViewUtil.setKeyEven((float) (((-65536) & UI_QueryInt64) >> 32), (float) (UI_QueryInt64 & 65535));
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, AutosetParam autosetParam) {
        if (autosetParam == null) {
            return;
        }
        autosetParam.bindAll(this, lifecycleOwner);
    }

    public void bind(LifecycleOwner lifecycleOwner, final FftParam fftParam) {
        if (fftParam == null) {
            return;
        }
        int serviceId = fftParam.getServiceId();
        get(serviceId, MessageID.MSG_FFT_PRESET).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.639
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readAllPreset();
            }
        });
        get(serviceId, MessageID.MSG_FFT_EN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.640
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readEnable();
            }
        });
        get(serviceId, MessageID.MSG_FFT_SRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.641
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readSrc();
            }
        });
        get(serviceId, MessageID.MSG_FFT_UNIT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.642
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readUnit();
            }
        });
        get(serviceId, MessageID.MSG_FFT_RBW).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.643
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readRbw();
            }
        });
        get(serviceId, MessageID.MSG_FFT_RBW_AUTO).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.644
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readAutoRbw();
            }
        });
        get(serviceId, MessageID.MSG_FFT_START).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.645
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readStart();
            }
        });
        get(serviceId, MessageID.MSG_FFT_END).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.646
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readEnd();
            }
        });
        get(serviceId, MessageID.MSG_FFT_CENTER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.647
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readCenter();
            }
        });
        get(serviceId, MessageID.MSG_FFT_SPAN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.648
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readSpan();
            }
        });
        get(serviceId, MessageID.MSG_FFT_SCALE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.649
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readScale();
            }
        });
        get(serviceId, MessageID.MSG_FFT_REF_LEVEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.650
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readRefLevel();
            }
        });
        get(serviceId, MessageID.MSG_FFT_WINDOW).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.651
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readWindow();
            }
        });
        get(serviceId, MessageID.MSG_FFT_PERSISTIME).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.652
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readPersistTime();
            }
        });
        get(serviceId, MessageID.MSG_DISPLAY_GRID).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.653
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readGrids();
            }
        });
        get(serviceId, MessageID.MSG_WINDOW_TITLE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.654
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readTitle();
            }
        });
        get(serviceId, MessageID.MSG_FFT_MARKER_CHANGE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.655
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readAllMarkerParam();
            }
        });
        get(serviceId, MessageID.MSG_FFT_MARKER_STATE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.656
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readMarkersState();
            }
        });
        get(serviceId, MessageID.MSG_FFT_PEAK_ENABLE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.657
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readPeakEn();
            }
        });
        get(serviceId, MessageID.MSG_FFT_PEAK_NUM).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.658
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readPeakNum();
            }
        });
        get(serviceId, MessageID.MSG_FFT_PEAK_THRESHOLD).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.659
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readPeakThreshold();
            }
        });
        get(serviceId, MessageID.MSG_FFT_PEAK_EXCURSION).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.660
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readPeakExcur();
            }
        });
        get(serviceId, MessageID.MSG_FFT_PEAK_TABLE_EN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.661
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readPeakTableEn();
            }
        });
        get(serviceId, MessageID.MSG_FFT_PEAK_TABELORDER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.662
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.readPeakOrder();
            }
        });
        get(serviceId, MessageID.MSG_FFT_PEAK_ADDMARKER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.663
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.addPeakMarker();
            }
        });
        get(serviceId, MessageID.MSG_FFT_PEAK_REMOVEMARKER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.664
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                fftParam.removePeakMarker();
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final MeasureSettingParam measureSettingParam) {
        if (measureSettingParam == null) {
            return;
        }
        final int serviceId = measureSettingParam.getServiceId();
        get(serviceId, MessageID.MSG_APP_MEAS_RANGE_MODE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.665
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                measureSettingParam.readMode();
            }
        });
        get(serviceId, MessageID.MSG_APP_MEAS_INDICATOR).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.666
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (measureSettingParam.readCursorIndicator()) {
                    measureSettingParam.saveCursorThreshold(true);
                    OrientationView.Companion.setShowThreshold(true);
                }
            }
        });
        get(serviceId, MessageID.MSG_APP_MEAS_THRESHOLD).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.667
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (measureSettingParam.readCursorThreshold()) {
                    measureSettingParam.saveCursorIndicator(true);
                    OrientationView.Companion.setShowThreshold(true);
                }
            }
        });
        get(serviceId, MessageID.MSG_APP_MEAS_STAT_ENABLE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.668
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                measureSettingParam.readStatisticState();
                MessageBus.getInstance().onSyncData(MessageBus.getKey(serviceId, MessageID.MSG_MEAS_STAT_VALUE_SET), -1);
            }
        });
        get(serviceId, MessageID.MSG_APP_MEAS_STAT_COUNT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.669
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                measureSettingParam.readStatCount();
            }
        });
        get(serviceId, MessageID.MSG_APP_MEAS_TH_HIGH_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.670
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                measureSettingParam.readThresholdType();
            }
        });
        get(serviceId, MessageID.MSG_APP_MEAS_TH_SRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.671
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                measureSettingParam.readThresholdSource();
            }
        });
        get(serviceId, MessageID.MSG_MEAS_HIGH_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.672
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                measureSettingParam.readThresholdHigh();
            }
        });
        get(serviceId, MessageID.MSG_MEAS_MID_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.673
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                measureSettingParam.readThresholdMiddle();
            }
        });
        get(serviceId, MessageID.MSG_MEAS_LOW_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.674
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                measureSettingParam.readThresholdLow();
            }
        });
        get(serviceId, MessageID.MSG_APP_MEAS_SET_STATE_METHOD).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.675
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                measureSettingParam.readMethodState();
            }
        });
        get(serviceId, MessageID.MSG_APP_MEAS_SET_TOP_METHOD).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.676
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                measureSettingParam.readTopMethod();
            }
        });
        get(serviceId, MessageID.MSG_APP_MEAS_SET_BASE_METHOD).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.677
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                measureSettingParam.readBaseMethod();
            }
        });
        get(serviceId, MessageID.MSG_APP_MEAS_REGION).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.678
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                measureSettingParam.readRegion();
            }
        });
        get(serviceId, MessageID.MSG_APP_MEAS_RANGE_CURSOR_ABX).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.679
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                measureSettingParam.readCursorBothAB();
            }
        });
        get(serviceId, MessageID.MSG_APP_MEAS_RANGE_CURSOR_AX).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.680
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                measureSettingParam.readCursorA();
            }
        });
        get(serviceId, MessageID.MSG_APP_MEAS_RANGE_CURSOR_BX).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.681
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                measureSettingParam.readCursorB();
            }
        });
        get(serviceId, MessageID.MSG_APP_MEAS_ALL_SRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.682
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                measureSettingParam.readMeasureAllSrc();
            }
        });
        get(serviceId, MessageID.MSG_MEAS_STAT_VALUE_SET).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.683
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                MessageBus.getInstance().onSyncData(MessageBus.getKey(serviceId, MessageID.MSG_MEAS_STAT_VALUE_SET), Integer.valueOf(measureSettingParam.readMeaType()));
            }
        });
        get(serviceId, MessageID.MSG_APP_MEAS_SRCA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.684
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                measureSettingParam.readSelectSourceA();
                ((MeasurePopupView) PopupViewManager.getInstance().get(MeasurePopupView.class)).notifyData();
            }
        });
        get(serviceId, MessageID.MSG_APP_MEAS_SRCB).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.685
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                measureSettingParam.readSelectSourceB();
            }
        });
        get(serviceId, MessageID.MSG_APP_MEAS_CAT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.686
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                ((MeasurePopupView) PopupViewManager.getInstance().get(MeasurePopupView.class)).setPageCurrentItem(measureSettingParam.readPosition());
            }
        });
        get(serviceId, MessageID.MSG_APP_MEAS_HISTO_ENABLE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.687
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                MessageBus.getInstance().onSyncData(MessageBus.getKey(28, MessageID.MSG_APP_MEAS_HISTO_ENABLE), Boolean.valueOf(measureSettingParam.readHistoEnable()));
            }
        });
        get(serviceId, MessageID.MSG_APP_MEAS_HISTO_WINDOW_TITLE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.688
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                measureSettingParam.readMeasHistoWindowTitle();
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final SearchParam searchParam) {
        if (searchParam == null) {
            return;
        }
        int serviceId = searchParam.getServiceId();
        get(serviceId, MessageID.MSG_SEARCH_EN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.689
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                searchParam.readEnable();
                FunctionManager.getInstance().searchSwitch = searchParam.readBool(MessageID.MSG_SEARCH_EN);
                MessageBus.getInstance().onSyncData(MessageBus.getKey(10, MessageID.MSG_HOR_REFRESH_ULTRAL_ENABLE), null);
            }
        });
        get(serviceId, MessageID.MSG_APP_SEARCH_QUERY_DATA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.690
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (searchParam.isEnable()) {
                    MessageBus.getInstance().onSyncData(MessageBus.getKey(25, MessageID.MSG_APP_SEARCH_QUERY_DATA), API.getInstance().UI_QueryStr(25, MessageID.MSG_APP_SEARCH_QUERY_DATA));
                }
            }
        });
        get(serviceId, MessageID.MSG_SEARCH_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.691
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                searchParam.readType();
                MessageBus.getInstance().onSyncData(MessageBus.getKey(25, MessageID.MSG_SEARCH_EN), false);
            }
        });
        get(serviceId, MessageID.MSG_SEARCH_MARK_TABEL_EN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.692
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                searchParam.readMarkTableEn();
            }
        });
        get(serviceId, MessageID.MSG_SEARCH_NAVIGATION_EVENT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.693
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                searchParam.readNavigation();
            }
        });
        get(serviceId, MessageID.MSG_SEARCH_THRE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.694
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                searchParam.readThre();
            }
        });
        get(serviceId, MessageID.MSG_SEARCH_THRE_A).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.695
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                searchParam.readThreA();
            }
        });
        get(serviceId, MessageID.MSG_SEARCH_THRE_B).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.696
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                searchParam.readThreB();
            }
        });
        get(serviceId, MessageID.MSG_SEARCH_PULSE_SOURCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.697
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                searchParam.readPulseSrc();
            }
        });
        get(serviceId, MessageID.MSG_SEARCH_PULSE_POLARITY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.698
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                searchParam.readPulsePolarty();
            }
        });
        get(serviceId, MessageID.MSG_SEARCH_PULSE_WHEN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.699
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                searchParam.readPolaritySlope();
            }
        });
        get(serviceId, MessageID.MSG_SEARCH_PULSE_UPPER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.700
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                searchParam.readPulseMax();
            }
        });
        get(serviceId, MessageID.MSG_SEARCH_PULSE_LOWER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.701
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                searchParam.readpulseLower();
            }
        });
        get(serviceId, MessageID.MSG_SEARCH_EDGE_SOURCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.702
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                searchParam.readEdgeSrc();
            }
        });
        get(serviceId, MessageID.MSG_SEARCH_EDGE_SLOPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.703
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                searchParam.readEdgeSlope();
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final IOParam iOParam) {
        if (iOParam == null) {
            return;
        }
        int serviceId = iOParam.getServiceId();
        get(serviceId, MessageID.MSG_IO_MAC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.704
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                iOParam.readMacAddress();
            }
        });
        get(serviceId, MessageID.MSG_IO_VISA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.705
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                iOParam.readVISAAddress();
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_LXI_CFG).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.706
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                iOParam.readSelect();
                iOParam.readDhcp();
                iOParam.readAuto();
                iOParam.readStatic();
            }
        });
        get(serviceId, MessageID.MSG_IO_DHCP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.707
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                iOParam.readDhcp();
                iOParam.readSelect();
            }
        });
        get(serviceId, MessageID.MSG_IO_AUTO).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.708
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                iOParam.readAuto();
                iOParam.readSelect();
            }
        });
        get(serviceId, MessageID.MSG_IO_STATIC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.709
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                iOParam.readStatic();
                iOParam.readSelect();
            }
        });
        get(serviceId, MessageID.MSG_IO_IP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.710
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                iOParam.readIPAddress();
            }
        });
        get(serviceId, MessageID.MSG_IO_MASK).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.711
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                iOParam.readMask();
            }
        });
        get(serviceId, MessageID.MSG_IO_GATEWAY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.712
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                iOParam.readGateWay();
            }
        });
        get(serviceId, MessageID.MSG_IO_DNS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.713
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                iOParam.readDNS();
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_LXI_MDNS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.714
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                iOParam.readmDns();
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_LXI_HOST_NAME).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.715
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                iOParam.readHostName();
            }
        });
        get(serviceId, MessageID.MSG_APP_UTILITY_GPIB).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.716
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                iOParam.readGPIB();
            }
        });
        final Long[] lArr = {0L};
        get(serviceId, MessageID.MSG_APP_UTILITY_LXI_APPLY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.717
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                try {
                    Thread.sleep(100L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (System.currentTimeMillis() - lArr[0].longValue() > 2000) {
                    iOParam.apply();
                    lArr[0] = Long.valueOf(System.currentTimeMillis());
                }
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final XYParam xYParam) {
        if (xYParam == null) {
            return;
        }
        get(40, MessageID.MSG_XY_USABLE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.718
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                MessageBus.getInstance().onSyncData(40, MessageID.MSG_XY_USABLE, bool);
            }
        });
        get(40, MessageID.MSG_DISPLAY_GRID).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.719
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                xYParam.getGrids();
            }
        });
        xYParam.bindAll(this, lifecycleOwner);
    }

    public void bind(LifecycleOwner lifecycleOwner, final HistogramResultParam histogramResultParam) {
        if (histogramResultParam == null) {
            return;
        }
        get(34, MessageID.MSG_HISTO_LEFTPOS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.720
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                histogramResultParam.readLeftPosition();
            }
        });
        get(34, MessageID.MSG_HISTO_RIGHTPOS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.721
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                histogramResultParam.readRightPosition();
            }
        });
        get(34, MessageID.MSG_HISTO_HIGHPOS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.722
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                histogramResultParam.readTopPosition();
            }
        });
        get(34, MessageID.MSG_HISTO_LOWPOS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.723
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                histogramResultParam.readBottomPosition();
            }
        });
        get(34, MessageID.MSG_HISTO_REALLEFTPOS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.724
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                histogramResultParam.readRealLeft();
            }
        });
        get(34, MessageID.MSG_HISTO_REALRIGHTPOS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.725
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                histogramResultParam.readRealRight();
            }
        });
        get(34, MessageID.MSG_HISTO_REALHIGHPOS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.726
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                histogramResultParam.readRealTop();
            }
        });
        get(34, MessageID.MSG_HISTO_REALLOWPOS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.727
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                histogramResultParam.readRealBottom();
            }
        });
        get(34, MessageID.MSG_HISTO_EN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.728
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                histogramResultParam.readEnable();
            }
        });
        get(34, MessageID.MSG_HISTO_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.729
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                histogramResultParam.readType();
            }
        });
        get(34, MessageID.MSG_HISTO_SOURCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.730
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                histogramResultParam.readSource();
            }
        });
        get(34, MessageID.MSG_HISTO_DISPGRID).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.731
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                histogramResultParam.readHeight();
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final JitterParam jitterParam) {
        if (jitterParam == null) {
            return;
        }
        int serviceId = jitterParam.getServiceId();
        get(serviceId, MessageID.MSG_JITTER_EN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.732
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readEnable();
            }
        });
        get(serviceId, MessageID.MSG_JITTER_SOURCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.733
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readSource();
            }
        });
        get(serviceId, MessageID.MSG_JITTER_HIGHTHRE_PER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.734
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readHighThres();
            }
        });
        get(serviceId, MessageID.MSG_JITTER_MIDTHRE_PER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.735
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readMidThres();
            }
        });
        get(serviceId, MessageID.MSG_JITTER_LOWTHRE_PER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.736
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readLowThres();
            }
        });
        get(serviceId, MessageID.MSG_JITTER_CR_SELMETHOD).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.737
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readRecoveryType();
            }
        });
        get(serviceId, MessageID.MSG_JITTER_TIE_SLOPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.738
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readTieSlope();
            }
        });
        get(serviceId, MessageID.MSG_JITTER_CR_FREQTYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.739
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readType();
            }
        });
        get(serviceId, MessageID.MSG_JITTER_CR_DATEFREQ).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.740
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readDataRate();
                jitterParam.readDataRateThresAttr();
            }
        });
        get(serviceId, MessageID.MSG_JITTER_CR_PLLORDER).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.741
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readPllOrder();
            }
        });
        get(serviceId, MessageID.MSG_JITTER_CR_DAMPFACTOR).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.742
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readDampFactor();
            }
        });
        get(serviceId, MessageID.MSG_JITTER_CR_PLLWIDTH).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.743
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readLoopBw();
                jitterParam.readLoopBwThresAttr();
            }
        });
        get(serviceId, MessageID.MSG_JITTER_EXTERNAL_CLOCK_SRC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.744
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readExternalClock();
            }
        });
        get(serviceId, MessageID.MSG_JITTER_MEAS_EN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.745
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readResult();
            }
        });
        get(serviceId, MessageID.MSG_JITTER_OVERLAP_DISPLAY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.746
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readPersistance();
            }
        });
        get(serviceId, MessageID.MSG_JITTER_TRACK).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.747
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readTrack();
            }
        });
        get(serviceId, MessageID.MSG_JITTER_SPEC).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.748
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readSpectrum();
            }
        });
        get(serviceId, MessageID.MSG_JITTER_HISTO).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.749
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readHistogram();
            }
        });
        get(serviceId, MessageID.MSG_JITTER_CURVE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.750
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readBathtubCurve();
            }
        });
        get(serviceId, MessageID.MSG_JITTER_SMOOTH).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.751
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                jitterParam.readSmooth();
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final UpaViewModel upaViewModel) {
        get(31, MessageID.MSG_UPA_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.752
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                MessageBus.getInstance().onSyncData(MessageBus.getKey(31, MessageID.MSG_UPA_TYPE), false);
            }
        });
        get(31, MessageID.MSG_UPA_POWER_DISP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.753
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                upaViewModel.getLiveData().getValue().readPowerDisp();
                upaViewModel.getLiveData().getValue().getDisposeType();
                MessageBus.getInstance().onSyncData(MessageBus.getKey(31, MessageID.MSG_UPA_TYPE), false);
                if (upaViewModel.getLiveData().getValue().getRefPowerDisp()) {
                    return;
                }
                WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_UPA);
            }
        });
        get(31, MessageID.MSG_UPA_POWER_FREF).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.754
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                upaViewModel.getLiveData().getValue().readRefLevel();
            }
        });
        get(31, MessageID.MSG_UPA_REFL_PCT_HIGH).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.755
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                upaViewModel.getLiveData().getValue().readReflHigh();
                upaViewModel.getLiveData().getValue().updateRefPctAttr();
            }
        });
        get(31, MessageID.MSG_UPA_POWER_VOLT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.756
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                upaViewModel.getLiveData().getValue().readPowerVolt();
            }
        });
        get(31, MessageID.MSG_UPA_POWER_CURR).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.757
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                upaViewModel.getLiveData().getValue().readPowerCurr();
            }
        });
        get(31, MessageID.MSG_UPA_REFL_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.758
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                upaViewModel.getLiveData().getValue().readPowerFref();
            }
        });
        get(31, MessageID.MSG_UPA_REFL_PCT_MID).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.759
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                upaViewModel.getLiveData().getValue().readRefPctMid();
                upaViewModel.getLiveData().getValue().updateRefPctAttr();
            }
        });
        get(31, MessageID.MSG_UPA_REFL_PCT_LOW).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.760
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                upaViewModel.getLiveData().getValue().readRefPctLow();
                upaViewModel.getLiveData().getValue().updateRefPctAttr();
            }
        });
        get(31, MessageID.MSG_UPA_REFL_ABS_HIGH).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.761
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                upaViewModel.getLiveData().getValue().readReflAbsHigh();
                upaViewModel.getLiveData().getValue().updateRefAbsAttr();
            }
        });
        get(31, MessageID.MSG_UPA_REFL_ABS_MID).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.762
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                upaViewModel.getLiveData().getValue().readRefAbsMid();
                upaViewModel.getLiveData().getValue().updateRefAbsAttr();
            }
        });
        get(31, MessageID.MSG_UPA_REFL_ABS_LOW).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.763
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                upaViewModel.getLiveData().getValue().readRefAbsLow();
                upaViewModel.getLiveData().getValue().updateRefAbsAttr();
            }
        });
        get(31, MessageID.MSG_UPA_POWER_STAT_COUNT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.764
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                upaViewModel.getLiveData().getValue().readPowerCount();
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final UpaRippleParam upaRippleParam) {
        get(31, MessageID.MSG_UPA_RIPPLE_DISP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.765
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                UpaViewModel upaViewModel = (UpaViewModel) ContextUtil.getAppViewModel(UpaViewModel.class);
                if (upaViewModel != null) {
                    upaViewModel.getLiveData();
                    UpaParam value = upaViewModel.getLiveData().getValue();
                    if (value != null) {
                        value.getDisposeType();
                        MessageBus.getInstance().onSyncData(MessageBus.getKey(31, MessageID.MSG_UPA_TYPE), false);
                    }
                }
                upaRippleParam.readPowerDisp();
                if (upaRippleParam.getRefPowerDisp()) {
                    upaRippleParam.setRipplShowList(true);
                } else {
                    WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_UPA);
                    upaRippleParam.setRipplShowList(false);
                }
                FunctionManager.getInstance().upaSwitch = upaRippleParam.readBool(MessageID.MSG_UPA_RIPPLE_DISP);
                MessageBus.getInstance().onSyncData(MessageBus.getKey(10, MessageID.MSG_HOR_REFRESH_ULTRAL_ENABLE), null);
            }
        });
        get(31, MessageID.MSG_UPA_RIPPLE_SOURCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.766
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                upaRippleParam.readPowerCurr();
            }
        });
        get(31, MessageID.MSG_UPA_RIPPLE_STAT_COUNT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.767
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                upaRippleParam.readRippleCount();
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final LaParam laParam) {
        get(60, MessageID.MSG_LA_SHOW_CALNUM).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.768
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readLaProbeCalProString();
            }
        });
        get(60, MessageID.MSG_LA_D0D7_ONOFF).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.769
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readD0TOd7();
            }
        });
        get(60, MessageID.MSG_LA_D8D15_ONOFF).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.770
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readD8TOd15();
            }
        });
        get(60, MessageID.MSG_LA_WAVE_SIZE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.771
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readLaSize();
            }
        });
        get(60, MessageID.MSG_LA_LOW_THRE_VAL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.772
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readD0TOd7Threshold();
            }
        });
        get(60, MessageID.MSG_LA_HIGH_THRE_VAL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.773
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readD8TOd15Threshold();
            }
        });
        get(60, MessageID.MSG_LA_CURRENT_CHAN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.774
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readlaSource();
            }
        });
        get(60, MessageID.MSG_LA_LABEL_VIEW).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.775
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readlabel();
            }
        });
        get(60, MessageID.MSG_LA_ENABLE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.776
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readLaEnable();
                if (laParam.readLaEnable()) {
                    return;
                }
                PopupViewManager.getInstance().dismiss(LapopupView.class);
            }
        });
        get(60, MessageID.MSG_LA_INPUT_LABEL).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.777
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readInputLabel();
            }
        });
        get(60, MessageID.MSG_LA_SELECT_GROUP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.778
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readlabelGroup();
            }
        });
        get(60, MessageID.MSG_LA_GROUP_SET).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.779
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readGroup1();
            }
        });
        get(60, MessageID.MSG_LA_HIGH_COLOR).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.780
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readlaHighColor();
            }
        });
        get(60, MessageID.MSG_LA_EDGE_COLOR).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.781
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readlaedgeColor();
            }
        });
        get(60, MessageID.MSG_LA_LOW_COLOR).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.782
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readlalowColor();
            }
        });
        get(60, MessageID.MSG_LA_AUTO_SET).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.783
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readAutoOrder();
            }
        });
        get(60, MessageID.MSG_LA_LABEL_SELECT_CHAN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.784
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readlaSelectChan();
            }
        });
        get(60, MessageID.MSG_LA_LABEL_VIEW_SELECT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.785
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readLaLabelViewSelect();
            }
        });
        get(60, MessageID.MSG_LA_CHAN_STATE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.786
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readD0ToD7ChanState();
            }
        });
        get(60, MessageID.MSG_LA_CHAN_STATE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.787
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readD8ToD15ChanState();
            }
        });
        get(60, MessageID.MSG_LA_GROUP_DX_STATE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.788
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readGroupChanState();
            }
        });
        get(60, MessageID.MSG_LA_CHAN_STATE_ATTR).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.789
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readinputLabellist();
            }
        });
        get(59, MessageID.MSG_LA_PROBE_IDENTIFY).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.790
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readProbe();
                PopupViewManager.getInstance().dismissAll(new Class[0]);
            }
        });
        get(60, MessageID.MSG_LA_PROBE_CAL_PROGRESS).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.791
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                laParam.readLaProbeCalPro();
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final BodeParam bodeParam) {
        get(61, MessageID.MSG_BODE_PLOTDATA).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.792
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodeData();
            }
        });
        get(61, MessageID.MSG_BODE_PMGM).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.793
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readbodePmgmData();
            }
        });
        get(61, MessageID.MSG_BODE_RESULT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.794
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodeResult();
            }
        });
        get(61, MessageID.MSG_BODE_RUNSTOP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.795
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodeRunStopEnable();
            }
        });
        get(61, MessageID.MSG_BODE_SOURCE_OUT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.796
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodeSourceOut();
            }
        });
        get(61, MessageID.MSG_BODE_SOURCE_IN).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.797
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodeSourceIn();
            }
        });
        get(61, MessageID.MSG_BODE_SWEEP_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.798
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodeSweepType();
            }
        });
        get(61, MessageID.MSG_BODE_IMPEDANCE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.799
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodeImpedace();
            }
        });
        get(61, MessageID.MSG_BODE_VARAMP).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.800
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodeVaramp();
            }
        });
        get(61, MessageID.MSG_BODE_STOP_FREQ).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.801
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodeStopFreq();
            }
        });
        get(61, MessageID.MSG_BODE_START_FREQ).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.802
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodeStartFreq();
            }
        });
        get(61, MessageID.MSG_BODE_POINT_NUM).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.803
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodePointNum();
            }
        });
        get(61, MessageID.MSG_BODE_DISP_TYPE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.804
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodeRunDispType();
            }
        });
        get(61, MessageID.MSG_BODE_ENABLE).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.805
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodeEnable();
            }
        });
        get(61, MessageID.MSG_BODE_AMPOUT).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.806
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodeAmpout();
            }
        });
        get(61, MessageID.MSG_BODE_VARAMP1).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.807
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodevaramp1();
            }
        });
        get(61, MessageID.MSG_BODE_VARAMP2).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.808
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodevaramp2();
            }
        });
        get(61, MessageID.MSG_BODE_VARAMP3).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.809
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodevaramp3();
            }
        });
        get(61, MessageID.MSG_BODE_VARAMP4).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.810
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodevaramp4();
            }
        });
        get(61, MessageID.MSG_BODE_VARAMP5).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.811
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodevaramp5();
            }
        });
        get(61, MessageID.MSG_BODE_VARAMP6).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.812
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodevaramp6();
            }
        });
        get(61, MessageID.MSG_BODE_VARAMP7).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.813
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodevaramp7();
            }
        });
        get(61, MessageID.MSG_BODE_VARAMP8).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.814
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                bodeParam.readBodevaramp8();
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final AfgParam afgParam) {
        get(64, 335).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.815
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readBasicPulDuty();
            }
        });
        get(64, 274).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.816
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readBasicFalledge();
            }
        });
        get(64, 273).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.817
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readBasicRiseedge();
            }
        });
        get(64, 334).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.818
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readBasicSymm();
            }
        });
        get(64, 336).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.819
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readBasicSquDuty();
            }
        });
        get(64, 269).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.820
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readBasicSquDuty();
            }
        });
        get(64, 331).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.821
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readBasicPhase();
            }
        });
        get(64, 276).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.822
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readBasicLow();
            }
        });
        get(64, 275).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.823
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readBasicHigh();
            }
        });
        get(64, 333).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.824
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readOffset();
                afgParam.readOffsetAttr();
            }
        });
        get(64, 332).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.825
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readBasicamp();
                afgParam.readBasicampAttr();
            }
        });
        get(64, 312).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.826
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readBasicPeriod();
            }
        });
        get(64, 330).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.827
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readBasicFreq();
            }
        });
        get(64, 256).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.828
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readModeFunction();
            }
        });
        get(63, 329).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.829
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readWaveFunction();
            }
        });
        get(63, 327).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.830
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readBasicOutputEnable();
            }
        });
        get(65, 338).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.831
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readAfgWaveModType();
            }
        });
        get(66, 342).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.832
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readAfgWaveAmShape();
            }
        });
        get(66, 341).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.833
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readWaveModAmFreq();
            }
        });
        get(66, 339).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.834
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readWaveModAmDepth();
            }
        });
        get(68, 347).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.835
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readWaveModPmFreq();
            }
        });
        get(67, 344).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.836
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readWaveModFmFreq();
            }
        });
        get(67, 343).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.837
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readWaveModFmDeviation();
            }
        });
        get(68, 346).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.838
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readWaveModPmDev();
            }
        });
        get(66, 339).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.839
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readAfgModPmDev();
            }
        });
        get(67, 345).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.840
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readAfgWaveFmShape();
            }
        });
        get(68, 348).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.841
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readAfgWavePmShape();
            }
        });
        get(65, 337).observe(lifecycleOwner, new Observer<Boolean>() { // from class: com.rigol.scope.viewmodels.UpdateUIViewModel.842
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                afgParam.readServiceOutputEnable();
            }
        });
    }
}
