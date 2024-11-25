package com.rigol.scope.utilities;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.BaseParam;
import com.rigol.scope.data.CursorResultParam;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.DvmResultParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MaskParam;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.data.RefParam;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.viewmodels.BodeViewModel;
import com.rigol.scope.viewmodels.CursorViewModel;
import com.rigol.scope.viewmodels.DecodeViewModel;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.viewmodels.RefViewModel;
import com.rigol.scope.viewmodels.ViewABkeyViewModel;
import com.rigol.scope.views.AnalysingPopupView;
import com.rigol.scope.views.CopyingLoading;
import com.rigol.scope.views.CuttingLoading;
import com.rigol.scope.views.DeletingLoading;
import com.rigol.scope.views.FileLoadLoading;
import com.rigol.scope.views.FileSaveLoading;
import com.rigol.scope.views.LoadingPopupView;
import com.rigol.scope.views.LogcatPopupView;
import com.rigol.scope.views.SavingLoading;
import com.rigol.scope.views.ScreenFlipPopupView;
import com.rigol.scope.views.UpdatePopupView;
import com.rigol.scope.views.UpgradingPopupView;
import com.rigol.scope.views.UtilityPopupView;
import com.rigol.scope.views.adc.ADCSettingPopupView;
import com.rigol.scope.views.adc.AdcSerPopupView;
import com.rigol.scope.views.afgawg.AfwAwgPopupView;
import com.rigol.scope.views.alert.AppSwitchPopupView;
import com.rigol.scope.views.alert.AutoLockPopupView;
import com.rigol.scope.views.alert.CleanDiskPopupView;
import com.rigol.scope.views.alert.CopyFilePopupView;
import com.rigol.scope.views.alert.DefaultPopupView;
import com.rigol.scope.views.alert.DeleteFilePopupView;
import com.rigol.scope.views.alert.OnlineUpgradeTermsPopupView;
import com.rigol.scope.views.alert.RebootPopupView;
import com.rigol.scope.views.alert.RemoveAllMeasurePopupView;
import com.rigol.scope.views.alert.ShutDownPoupView;
import com.rigol.scope.views.analyse.AnalyseEthResultPopupView;
import com.rigol.scope.views.analyse.AnalysePopupView;
import com.rigol.scope.views.analyse.AnalyseRemindPopupView;
import com.rigol.scope.views.analyse.AnalyseUsbResultPopupView;
import com.rigol.scope.views.auto.AutoSetPopupView;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.bode.BodePopupWin;
import com.rigol.scope.views.bode.BodeResultPopuwin;
import com.rigol.scope.views.busAnalyse.BusAnalysePopupView;
import com.rigol.scope.views.calibration.CalibrationPopupView;
import com.rigol.scope.views.cursor.CounterSettingPopupView;
import com.rigol.scope.views.cursor.CursorSettingPopupView;
import com.rigol.scope.views.ddrDebug.DdrDebugPopupView;
import com.rigol.scope.views.decode.DecodeNewPopupView;
import com.rigol.scope.views.diskManage.DiskManagePopupView;
import com.rigol.scope.views.display.DisplayPopupView;
import com.rigol.scope.views.dvm.DvmSettingPopupView;
import com.rigol.scope.views.eye.EyePopupView;
import com.rigol.scope.views.histogram.HistogramSettingPopupView;
import com.rigol.scope.views.horizontal.HorizontalPopupView;
import com.rigol.scope.views.jitter.JitterPopupView;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.knob.FlexKnobPopupView;
import com.rigol.scope.views.la.LaCalibrationPopuView;
import com.rigol.scope.views.la.LapopupView;
import com.rigol.scope.views.load.LoadPopupView;
import com.rigol.scope.views.mask.MaskPopupView;
import com.rigol.scope.views.math.MathListPopuView;
import com.rigol.scope.views.math.MathPopupView;
import com.rigol.scope.views.measure.MeasurePopupView;
import com.rigol.scope.views.measure.MeasureSettingPopupView;
import com.rigol.scope.views.multi.MultiWindowPopupView;
import com.rigol.scope.views.navigate.NavigatePopupView;
import com.rigol.scope.views.power.PowerPopupView;
import com.rigol.scope.views.probe.ProbePopupView;
import com.rigol.scope.views.quick.CounterQuickPopupView;
import com.rigol.scope.views.quick.CursorQuickPopupView;
import com.rigol.scope.views.quick.DvmQuickPopupView;
import com.rigol.scope.views.quick.EyeQuickPopupView;
import com.rigol.scope.views.quick.HistogramQuickPopupView;
import com.rigol.scope.views.quick.JitterQuickPopupView;
import com.rigol.scope.views.quick.MEASHistogramQuickPopupView;
import com.rigol.scope.views.quick.MaskQuickPopupView;
import com.rigol.scope.views.quick.MeasureQuickPopupView;
import com.rigol.scope.views.quick.QuickPopupView;
import com.rigol.scope.views.record.RecordPopupView;
import com.rigol.scope.views.ref.RefPopupView;
import com.rigol.scope.views.rtsa.RtsaPopupView;
import com.rigol.scope.views.save.SavePopupView;
import com.rigol.scope.views.search.SearchPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.scope.views.startMenu.StartMenuPopupView;
import com.rigol.scope.views.storage.SmbSettingPopupView;
import com.rigol.scope.views.storage.StoragePopupView;
import com.rigol.scope.views.trigger.TriggerPopupView;
import com.rigol.scope.views.upa.UpaPopuViewRippel;
import com.rigol.scope.views.upa.UpaPopupViewConnection;
import com.rigol.scope.views.upa.UpaPopupview;
import com.rigol.scope.views.vertical.VerticalPopupView;
import com.rigol.scope.views.wave.WaveIntensityPopupView;
import com.rigol.scope.views.xy.XYPopupView;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PopupViewManager {
    private static PopupViewManager INSTANCE;
    public static Class<? extends BasePopupView> HORIZONTAL_CLASS = HorizontalPopupView.class;
    public static Class<? extends BasePopupView> TRIGGER_CLASS = TriggerPopupView.class;
    private final SimpleArrayMap<Class<? extends BasePopupView>, BasePopupView> list = new SimpleArrayMap<>();
    private boolean isShowingWhenClickDown = false;
    public boolean isTouchControlLight = true;

    private PopupViewManager() {
    }

    public static PopupViewManager getInstance() {
        if (INSTANCE == null) {
            synchronized (PopupViewManager.class) {
                if (INSTANCE == null) {
                    synchronized (PopupViewManager.class) {
                        INSTANCE = new PopupViewManager();
                    }
                }
            }
        }
        return INSTANCE;
    }

    public boolean isShowingWhenClickDown() {
        return this.isShowingWhenClickDown;
    }

    public void setShowingWhenClickDown(boolean z) {
        this.isShowingWhenClickDown = z;
    }

    public void add(Class<? extends BasePopupView> cls, BasePopupView basePopupView) {
        this.list.put(cls, basePopupView);
    }

    public BasePopupView get(Class<? extends BasePopupView> cls) {
        return this.list.get(cls);
    }

    public void show(Class<? extends BasePopupView> cls) {
        BasePopupView basePopupView = get(cls);
        if (basePopupView == null) {
            return;
        }
        basePopupView.show();
    }

    public void show(Class<? extends BasePopupView> cls, View view) {
        BasePopupView basePopupView = get(cls);
        if (basePopupView == null) {
            return;
        }
        if (!((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBodeEnable() || (basePopupView instanceof BodePopupWin)) {
            basePopupView.show(view);
        }
    }

    public void dismiss(Class<? extends BasePopupView> cls) {
        BasePopupView basePopupView = get(cls);
        if (basePopupView != null) {
            basePopupView.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public final void dismissAll(Class<? extends BasePopupView>... clsArr) {
        for (int i = 0; i < this.list.size(); i++) {
            BasePopupView valueAt = this.list.valueAt(i);
            if (valueAt != null) {
                Class<?> cls = valueAt.getClass();
                if (!inClasses(cls, clsArr) && cls != CalibrationPopupView.class) {
                    valueAt.dismiss();
                }
            }
        }
    }

    private boolean inClasses(Class<? extends BasePopupView> cls, Class<? extends BasePopupView>[] clsArr) {
        if (clsArr != null && clsArr.length != 0) {
            for (Class<? extends BasePopupView> cls2 : clsArr) {
                if (cls == cls2) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clearAll() {
        if (this.list.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.list.size(); i++) {
            BasePopupView valueAt = this.list.valueAt(i);
            if (valueAt != null && valueAt.isShowing()) {
                valueAt.dismiss();
            }
        }
        this.list.clear();
    }

    public void addAll() {
        add(StoragePopupView.class, new StoragePopupView());
        add(UtilityPopupView.class, new UtilityPopupView());
        add(MeasurePopupView.class, new MeasurePopupView());
        add(FlexKnobPopupView.class, new FlexKnobPopupView());
        add(RecordPopupView.class, new RecordPopupView());
        add(SearchPopupView.class, new SearchPopupView());
        add(StartMenuPopupView.class, new StartMenuPopupView());
        add(DecodeNewPopupView.class, new DecodeNewPopupView());
        add(JitterPopupView.class, new JitterPopupView());
        add(BusAnalysePopupView.class, new BusAnalysePopupView());
        add(MaskPopupView.class, new MaskPopupView());
        add(ADCSettingPopupView.class, new ADCSettingPopupView());
        add(AdcSerPopupView.class, new AdcSerPopupView());
        add(LogcatPopupView.class, new LogcatPopupView());
        add(EyePopupView.class, new EyePopupView());
        add(DisplayPopupView.class, new DisplayPopupView());
        add(DiskManagePopupView.class, new DiskManagePopupView());
        add(RefPopupView.class, new RefPopupView());
        add(SavePopupView.class, new SavePopupView());
        add(LoadPopupView.class, new LoadPopupView());
        add(DdrDebugPopupView.class, new DdrDebugPopupView());
        add(AppSwitchPopupView.class, new AppSwitchPopupView());
        add(AnalyseUsbResultPopupView.class, new AnalyseUsbResultPopupView());
        add(AnalyseEthResultPopupView.class, new AnalyseEthResultPopupView());
        add(AnalyseRemindPopupView.class, new AnalyseRemindPopupView());
        add(AutoSetPopupView.class, new AutoSetPopupView());
        add(XYPopupView.class, new XYPopupView());
        add(RtsaPopupView.class, new RtsaPopupView());
        add(WaveIntensityPopupView.class, new WaveIntensityPopupView());
        add(CalibrationPopupView.class, new CalibrationPopupView());
        add(MeasureSettingPopupView.class, new MeasureSettingPopupView());
        add(DvmSettingPopupView.class, new DvmSettingPopupView());
        add(CounterSettingPopupView.class, new CounterSettingPopupView());
        add(CursorSettingPopupView.class, new CursorSettingPopupView());
        add(HistogramSettingPopupView.class, new HistogramSettingPopupView());
        add(UpaPopupview.class, new UpaPopupview());
        add(UpaPopupViewConnection.class, new UpaPopupViewConnection());
        add(UpaPopuViewRippel.class, new UpaPopuViewRippel());
        add(NavigatePopupView.class, new NavigatePopupView());
        add(DecodeNewPopupView.class, new DecodeNewPopupView());
        add(AnalysePopupView.class, new AnalysePopupView());
        add(MathListPopuView.class, new MathListPopuView());
        add(LapopupView.class, new LapopupView());
        add(AfwAwgPopupView.class, new AfwAwgPopupView());
        add(BodePopupWin.class, new BodePopupWin());
        add(BodeResultPopuwin.class, new BodeResultPopuwin());
        add(SmbSettingPopupView.class, new SmbSettingPopupView());
        add(MeasureQuickPopupView.class, new QuickPopupView(R.array.msg_meas_quick_popup));
        add(CursorQuickPopupView.class, new QuickPopupView(R.array.msg_cursor_quick_popup));
        add(DvmQuickPopupView.class, new QuickPopupView(R.array.msg_dvm_quick_popup));
        add(CounterQuickPopupView.class, new QuickPopupView(R.array.msg_counter_quick_popup));
        add(HistogramQuickPopupView.class, new QuickPopupView(R.array.msg_histo_quick_popup));
        add(EyeQuickPopupView.class, new QuickPopupView(R.array.msg_eye_quick_popup));
        add(MaskQuickPopupView.class, new QuickPopupView(R.array.msg_mask_quick_popup));
        add(JitterQuickPopupView.class, new QuickPopupView(R.array.msg_jitter_quick_popup));
        add(MEASHistogramQuickPopupView.class, new QuickPopupView(R.array.msg_histo_quick_popup));
        add(ShutDownPoupView.class, new ShutDownPoupView());
        add(PowerPopupView.class, new PowerPopupView());
        add(RebootPopupView.class, new RebootPopupView());
        add(RemoveAllMeasurePopupView.class, new RemoveAllMeasurePopupView());
        add(DeleteFilePopupView.class, new DeleteFilePopupView());
        add(CleanDiskPopupView.class, new CleanDiskPopupView());
        add(DefaultPopupView.class, new DefaultPopupView());
        add(OnlineUpgradeTermsPopupView.class, new OnlineUpgradeTermsPopupView());
        add(AutoLockPopupView.class, new AutoLockPopupView());
        add(ScreenFlipPopupView.class, new ScreenFlipPopupView());
        add(UpdatePopupView.class, new UpdatePopupView());
        add(CopyFilePopupView.class, new CopyFilePopupView());
        add(FileSaveLoading.class, new FileSaveLoading());
        add(FileLoadLoading.class, new FileLoadLoading());
        add(CopyingLoading.class, new CopyingLoading());
        add(CuttingLoading.class, new CuttingLoading());
        add(DeletingLoading.class, new DeletingLoading());
        add(SavingLoading.class, new SavingLoading());
        add(UpgradingPopupView.class, new UpgradingPopupView());
        add(AnalysingPopupView.class, new AnalysingPopupView());
        add(LaCalibrationPopuView.class, new LaCalibrationPopuView());
    }

    public Class<? extends BasePopupView> getShowingClass() {
        for (int i = 0; i < this.list.size(); i++) {
            BasePopupView valueAt = this.list.valueAt(i);
            if (valueAt != null && valueAt.isShowing()) {
                return valueAt.getClass();
            }
        }
        return null;
    }

    public boolean isShowingCloseable() {
        for (int i = 0; i < this.list.size(); i++) {
            BasePopupView valueAt = this.list.valueAt(i);
            if (valueAt != null && valueAt.isShowing() && !valueAt.isOutsideTouchable()) {
                return false;
            }
        }
        return true;
    }

    public boolean isLoadingClassShowing() {
        for (int i = 0; i < this.list.size(); i++) {
            BasePopupView valueAt = this.list.valueAt(i);
            if ((valueAt instanceof LoadingPopupView) && valueAt.isShowing()) {
                return true;
            }
        }
        return false;
    }

    public boolean isShowing(Class<? extends BasePopupView> cls) {
        BasePopupView basePopupView = get(cls);
        if (basePopupView != null) {
            return basePopupView.isShowing();
        }
        return false;
    }

    public boolean isShowing() {
        return getShowingClass() != null;
    }

    public void toggle(Class<? extends BasePopupView> cls) {
        BasePopupView basePopupView = get(cls);
        if (basePopupView == null) {
            return;
        }
        if (basePopupView.isShowing()) {
            basePopupView.dismiss();
        } else if (!((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBodeEnable() || (basePopupView instanceof BodePopupWin) || (basePopupView instanceof BodeResultPopuwin)) {
            basePopupView.show();
        }
    }

    public void toggle(Class<? extends BasePopupView> cls, View view) {
        if (isShowing(cls)) {
            dismiss(cls);
        } else {
            show(cls, view);
        }
    }

    public void setTag(View view, Class<? extends BasePopupView> cls) {
        view.setTag(cls);
    }

    public View findViewWithTag(View view, Class<? extends BasePopupView> cls) {
        return view.findViewWithTag(cls);
    }

    public void setTag(View view, ServiceEnum.Function function) {
        int i = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[function.ordinal()];
        if (i == 19) {
            getInstance().setTag(view, RecordPopupView.class);
        } else if (i == 21) {
            view.setTag(DisplayPopupView.class.getSimpleName());
        } else if (i == 28) {
            view.setTag(UtilityPopupView.class.getSimpleName());
        } else if (i == 35) {
            view.setTag(TriggerPopupView.class.getSimpleName());
        } else if (i != 36) {
            switch (i) {
                case 1:
                    getInstance().setTag(view, MeasurePopupView.class);
                    return;
                case 2:
                    view.setTag(HistogramSettingPopupView.class.getSimpleName());
                    return;
                case 3:
                    view.setTag(CursorSettingPopupView.class.getSimpleName());
                    return;
                case 4:
                case 5:
                    getInstance().setTag(view, MultiWindowPopupView.class);
                    return;
                case 6:
                    getInstance().setTag(view, MathPopupView.class);
                    return;
                default:
                    switch (i) {
                        case 8:
                            view.setTag(MathPopupView.class);
                            return;
                        case 9:
                            view.setTag(CounterSettingPopupView.class.getSimpleName());
                            return;
                        case 10:
                            view.setTag(DvmSettingPopupView.class.getSimpleName());
                            return;
                        case 11:
                            getInstance().setTag(view, EyePopupView.class);
                            return;
                        case 12:
                            view.setTag(JitterPopupView.class.getSimpleName());
                            return;
                        case 13:
                            view.setTag(DecodeNewPopupView.class.getSimpleName());
                            return;
                        default:
                            switch (i) {
                                case 15:
                                    view.setTag(BusAnalysePopupView.class.getSimpleName());
                                    return;
                                case 16:
                                    view.setTag(MaskPopupView.class.getSimpleName());
                                    return;
                                case 17:
                                    view.setTag(SearchPopupView.class.getSimpleName());
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        } else {
            view.setTag(HorizontalPopupView.class.getSimpleName());
        }
    }

    public BasePopupView create(ServiceEnum.Function function) {
        if (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[function.ordinal()] != 1) {
            return null;
        }
        return new MeasurePopupView();
    }

    public void onLocaleChanged() {
        for (int i = 0; i < this.list.size(); i++) {
            BasePopupView valueAt = this.list.valueAt(i);
            if (valueAt != null) {
                valueAt.onLocaleChanged();
            }
        }
    }

    public void showCurrentWindowLight(BasePopupView basePopupView) {
        ViewUtil.getViewABkeyViewModel().getPopuwind_boolean().setValue(false);
        if (basePopupView instanceof FlexKnobPopupView) {
            ViewUtil.getFlexKnobParamViewModel().refreshCHList();
        } else if (basePopupView instanceof VerticalPopupView) {
            ((VerticalPopupView) basePopupView).verticalPopupViewLight();
        } else if (basePopupView instanceof HorizontalPopupView) {
            setLight(((HorizontalPopupView) basePopupView).getAorBManager());
        } else if (basePopupView instanceof CursorSettingPopupView) {
            ((CursorSettingPopupView) basePopupView).cursorSettingLight();
        } else if (basePopupView instanceof MathPopupView) {
            openMathLight(basePopupView);
        } else if (basePopupView instanceof TriggerPopupView) {
            triggerLight(basePopupView);
        } else if (basePopupView instanceof DecodeNewPopupView) {
            getInstance().decodeLightType();
        } else if (basePopupView instanceof MeasureSettingPopupView) {
            setLight(((MeasureSettingPopupView) basePopupView).getAorBManager());
        } else if (basePopupView instanceof CounterSettingPopupView) {
            ((CounterSettingPopupView) basePopupView).counterLight();
        } else if (basePopupView instanceof DvmSettingPopupView) {
            ((DvmSettingPopupView) basePopupView).dvmLight();
        } else if (basePopupView instanceof RefPopupView) {
            ((RefPopupView) basePopupView).setRefLight();
        } else if (basePopupView instanceof ProbePopupView) {
            ((ProbePopupView) basePopupView).probeLight();
        } else if (basePopupView instanceof RecordPopupView) {
            ((RecordPopupView) basePopupView).setRecordLight();
        } else if (basePopupView instanceof UpaPopupview) {
            ((UpaPopupview) basePopupView).upaLight();
        } else if (basePopupView instanceof SearchPopupView) {
            ((SearchPopupView) basePopupView).searchLight();
        } else if (basePopupView instanceof NavigatePopupView) {
            ((NavigatePopupView) basePopupView).navigateLight();
        } else if (basePopupView instanceof MaskPopupView) {
            ((MaskPopupView) basePopupView).maskLight();
        } else if (basePopupView instanceof LapopupView) {
            verticalLight();
        } else if ((basePopupView instanceof KeyboardPopupView) || (basePopupView instanceof PopupSpinner)) {
        } else {
            if (basePopupView instanceof QuickPopupView) {
                closeAllLight();
            } else if ((basePopupView instanceof MeasurePopupView) || (basePopupView instanceof AnalysePopupView) || (basePopupView instanceof UtilityPopupView) || (basePopupView instanceof MultiWindowPopupView) || (basePopupView instanceof StartMenuPopupView) || (basePopupView instanceof DefaultPopupView) || (basePopupView instanceof DisplayPopupView) || (basePopupView instanceof StoragePopupView) || (basePopupView instanceof XYPopupView) || (basePopupView instanceof AutoSetPopupView)) {
                closeAllLight();
            } else if (basePopupView != null) {
                setDefaultLight();
            }
        }
    }

    public void flexBeforeLight() {
        Class<? extends BasePopupView> showingClass = getInstance().getShowingClass();
        if (showingClass != null) {
            BasePopupView basePopupView = getInstance().get(showingClass);
            if (basePopupView instanceof MathPopupView) {
                return;
            }
            if (basePopupView instanceof FlexKnobPopupView) {
                FunctionManager.getInstance().selectFlexLight(FunctionManager.getInstance().getCurrentFlexKnobEnum());
            } else {
                showCurrentWindowLight(basePopupView);
            }
        }
    }

    public void setParamAOrBManager(BaseParam baseParam, AorBManager aorBManager) {
        if (baseParam == null) {
            return;
        }
        if (baseParam instanceof VerticalParam) {
            ((VerticalParam) baseParam).aorBManager = aorBManager;
        } else if (baseParam instanceof HorizontalParam) {
            ((HorizontalParam) baseParam).aorBManager = aorBManager;
        } else if (baseParam instanceof CursorResultParam) {
            ((CursorResultParam) baseParam).aorBManager = aorBManager;
        } else if (baseParam instanceof MathParam) {
            ((MathParam) baseParam).setAorBManager(aorBManager);
        } else if (baseParam instanceof TriggerParam) {
            ((TriggerParam) baseParam).setAorBManager(aorBManager);
        } else if (baseParam instanceof DecodeParam) {
            ((DecodeParam) baseParam).setAorBManager(aorBManager);
        } else if (baseParam instanceof MeasureSettingParam) {
            ((MeasureSettingParam) baseParam).aorBManager = aorBManager;
        } else if (baseParam instanceof DvmResultParam) {
            ((DvmResultParam) baseParam).setAorBManager(aorBManager);
        } else if (baseParam instanceof MaskParam) {
            ((MaskParam) baseParam).aorBManager = aorBManager;
        }
    }

    public void dismissCurrentWindowLight(BasePopupView basePopupView) {
        cursorABHint();
        if ((basePopupView instanceof KeyboardPopupView) || (basePopupView instanceof PopupSpinner) || (basePopupView instanceof FlexKnobPopupView) || isShowing()) {
            return;
        }
        ViewUtil.getFlexKnobParamViewModel().refreshCHList();
    }

    public void dismissBasePopupView(BasePopupView basePopupView) {
        if (this.isTouchControlLight) {
            dismissCurrentWindowLight(basePopupView);
        } else {
            this.isTouchControlLight = true;
            if (basePopupView instanceof QuickPopupView) {
                dismissCurrentWindowLight(basePopupView);
            }
        }
        cursorABHint();
    }

    public void cursorABHint() {
        if (!isShowing()) {
            if (FunctionManager.getInstance().getCurrentFlexKnobEnum() == ServiceEnum.FlexKnobEnum.Cursor && FunctionManager.getInstance().isEnabled(ServiceEnum.Function.FUN_CURSOR)) {
                ViewUtil.getViewABkeyViewModel().getPopuwind_boolean().setValue(true);
                return;
            } else {
                ViewUtil.getViewABkeyViewModel().getPopuwind_boolean().setValue(false);
                return;
            }
        }
        Class<? extends BasePopupView> showingClass = getInstance().getShowingClass();
        if (showingClass != null) {
            BasePopupView basePopupView = getInstance().get(showingClass);
            if (basePopupView instanceof FlexKnobPopupView) {
                if (FunctionManager.getInstance().getCurrentFlexKnobEnum() == ServiceEnum.FlexKnobEnum.Cursor && FunctionManager.getInstance().isEnabled(ServiceEnum.Function.FUN_CURSOR)) {
                    ViewUtil.getViewABkeyViewModel().getPopuwind_boolean().setValue(true);
                } else {
                    ViewUtil.getViewABkeyViewModel().getPopuwind_boolean().setValue(false);
                }
            } else if (basePopupView instanceof CursorSettingPopupView) {
                ViewUtil.getViewABkeyViewModel().getPopuwind_boolean().setValue(false);
            } else {
                ViewUtil.getViewABkeyViewModel().getPopuwind_boolean().setValue(false);
            }
        }
    }

    public void setDefaultLight() {
        CursorResultParam value;
        CursorViewModel cursorViewModel = (CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class);
        if (cursorViewModel == null || (value = cursorViewModel.getLiveData().getValue()) == null) {
            return;
        }
        ServiceEnum.CursorMode cursorMode = value.getCursorMode();
        if (!isShowing() && cursorMode == ServiceEnum.CursorMode.cursor_mode_off && FunctionManager.getInstance().getCurrentFlexKnobEnum() == ServiceEnum.FlexKnobEnum.Intensity) {
            DefaultLight_Open();
        }
    }

    public void setLight(AorBManager aorBManager) {
        try {
            if (aorBManager == null) {
                setWindowDefaultLight();
            } else if (aorBManager.getTextA() != null && TextUtils.isEmpty(aorBManager.getTextA().getText().toString())) {
                setWindowDefaultLight();
            } else {
                aorBManager.controlLight(aorBManager.getTextA(), true, true);
                aorBManager.controlLight(aorBManager.getTextB(), false, true);
            }
        } catch (Exception unused) {
        }
    }

    public void setWindowDefaultLight() {
        Class<? extends BasePopupView> showingClass = getShowingClass();
        if (showingClass != null) {
            setDefaultWindowLight(get(showingClass));
        }
    }

    public void setDefaultWindowLight(BasePopupView basePopupView) {
        if (basePopupView instanceof VerticalPopupView) {
            verticalLight();
        } else if (basePopupView instanceof HorizontalPopupView) {
            horizontalLight();
        } else if (basePopupView instanceof CursorSettingPopupView) {
            cursorLight();
            cursorABHint();
        } else if (basePopupView instanceof MathPopupView) {
            mathLight(0);
        } else if (basePopupView instanceof TriggerPopupView) {
            triggerLight(basePopupView);
        } else if (basePopupView instanceof DecodeNewPopupView) {
            getInstance().decodeLightType();
        } else if (basePopupView instanceof MeasureSettingPopupView) {
            measureLight();
        } else if (basePopupView instanceof CounterSettingPopupView) {
            counterLight();
        } else if (basePopupView instanceof DvmSettingPopupView) {
            dVMLight();
        } else if (basePopupView instanceof RefPopupView) {
            closeAllLight();
        } else if (basePopupView instanceof ProbePopupView) {
            ((ProbePopupView) basePopupView).probeLight();
        } else if (basePopupView instanceof RecordPopupView) {
            closeAllLight();
        } else if (basePopupView instanceof UpaPopupview) {
            upaLight();
        } else if (basePopupView instanceof SearchPopupView) {
            closeAllLight();
        } else if ((basePopupView instanceof KeyboardPopupView) || (basePopupView instanceof PopupSpinner) || (basePopupView instanceof FlexKnobPopupView)) {
        } else {
            DefaultLight_Open();
        }
    }

    public void AHorizontalLight_Open() {
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.A_LEFT_AND_RIGHT_LED_WHITE.value1, 1);
    }

    public void AVerticalLight_Open() {
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.A_UP_AND_DOWN_LED_WHITE.value1, 1);
    }

    public void BHorizontalLight_Open() {
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.B_LEFT_AND_RIGHT_LED_WHITE.value1, 1);
    }

    public void BVerticalLight_Open() {
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.B_UP_AND_DOWN_LED_WHITE.value1, 1);
    }

    public void DefaultLight_Open() {
        closeAllLight();
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.INTEN_LED_WHITE.value1, 1);
    }

    public void horizontalLight() {
        closeAllLight();
        AHorizontalLight_Open();
        BHorizontalLight_Open();
    }

    public void verticalLight() {
        closeAllLight();
        AVerticalLight_Open();
        BVerticalLight_Open();
    }

    public void closeAHorizontalLight() {
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.A_LEFT_AND_RIGHT_LED_WHITE.value1, 0);
    }

    public void closeAVerticalLight() {
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.A_UP_AND_DOWN_LED_WHITE.value1, 0);
    }

    public void closeBHorizontalLight() {
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.B_LEFT_AND_RIGHT_LED_WHITE.value1, 0);
    }

    public void closeBVerticalLight() {
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.B_UP_AND_DOWN_LED_WHITE.value1, 0);
    }

    public void closeDefaultLight() {
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.INTEN_LED_WHITE.value1, 0);
    }

    public void closeAllLight() {
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.A_UP_AND_DOWN_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.B_UP_AND_DOWN_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.A_LEFT_AND_RIGHT_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.B_LEFT_AND_RIGHT_LED_WHITE.value1, 0);
        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.INTEN_LED_WHITE.value1, 0);
    }

    public void openMathLight(BasePopupView basePopupView) {
        MathPopupView mathPopupView = (MathPopupView) basePopupView;
        FunctionManager.getInstance().setFlexKnobEnum(ServiceEnum.Function.FUN_MATH, mathPopupView.getCurrentItem(), false);
        switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[mathPopupView.getMathParam().getOperator().ordinal()]) {
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
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                closeAllLight();
                AVerticalLight_Open();
                BVerticalLight_Open();
                return;
            case 21:
                closeAllLight();
                AHorizontalLight_Open();
                BHorizontalLight_Open();
                return;
            default:
                return;
        }
    }

    public void triggerLight(BasePopupView basePopupView) {
        TriggerPopupView triggerPopupView = (TriggerPopupView) basePopupView;
        if (triggerPopupView.getParam() == null) {
            return;
        }
        switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[triggerPopupView.getParam().getTriggerMode().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                closeAllLight();
                AVerticalLight_Open();
                BHorizontalLight_Open();
                return;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                closeAllLight();
                verticalLight();
                return;
            case 19:
            case 20:
                closeAllLight();
                AVerticalLight_Open();
                return;
            default:
                return;
        }
    }

    public void decodeLightType() {
        DecodeParam decodeParam = ((DecodeNewPopupView) getInstance().get(DecodeNewPopupView.class)).getDecodeParam();
        if (decodeParam == null || decodeParam.getType() == null) {
            return;
        }
        ServiceEnum.DecodeBusType type = decodeParam.getType();
        closeAllLight();
        switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[type.ordinal()]) {
            case 1:
                if (decodeParam.getPal_clk() == 0) {
                    AVerticalLight_Open();
                    return;
                }
                AVerticalLight_Open();
                BVerticalLight_Open();
                return;
            case 2:
                if (decodeParam.getRs232_rx() == 0) {
                    AVerticalLight_Open();
                    return;
                }
                AVerticalLight_Open();
                BVerticalLight_Open();
                return;
            case 3:
            case 4:
                AVerticalLight_Open();
                return;
            case 5:
            case 6:
            case 7:
                AVerticalLight_Open();
                BVerticalLight_Open();
                return;
            case 8:
            case 9:
                AVerticalLight_Open();
                BHorizontalLight_Open();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.utilities.PopupViewManager$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType;
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function;
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator;
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode;

        static {
            int[] iArr = new int[ServiceEnum.DecodeBusType.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType = iArr;
            try {
                iArr[ServiceEnum.DecodeBusType.Decode_Parallel.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_RS232.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_LIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_1553B.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_I2C.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_SPI.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_I2S.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_CAN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_FlexRay.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_ARINC429.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_SENT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_MOST.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_USB.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            int[] iArr2 = new int[ServiceEnum.TriggerMode.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode = iArr2;
            try {
                iArr2[ServiceEnum.TriggerMode.Trigger_Edge.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Pulse.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Pattern.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Duration.ordinal()] = 4;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Timeout.ordinal()] = 5;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_NEdge.ordinal()] = 6;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_CAN.ordinal()] = 7;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_LIN.ordinal()] = 8;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Slope.ordinal()] = 9;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Runt.ordinal()] = 10;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Over.ordinal()] = 11;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Delay.ordinal()] = 12;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Setup.ordinal()] = 13;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_I2C.ordinal()] = 14;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_SPI.ordinal()] = 15;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_FlexRay.ordinal()] = 16;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_I2S.ordinal()] = 17;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_1553.ordinal()] = 18;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Video.ordinal()] = 19;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_RS232.ordinal()] = 20;
            } catch (NoSuchFieldError unused33) {
            }
            int[] iArr3 = new int[ServiceEnum.MathOperator.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator = iArr3;
            try {
                iArr3[ServiceEnum.MathOperator.operator_add.ordinal()] = 1;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_sub.ordinal()] = 2;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_mul.ordinal()] = 3;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_div.ordinal()] = 4;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_and.ordinal()] = 5;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_or.ordinal()] = 6;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_xor.ordinal()] = 7;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_not.ordinal()] = 8;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_intg.ordinal()] = 9;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_diff.ordinal()] = 10;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_root.ordinal()] = 11;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_lg.ordinal()] = 12;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_ln.ordinal()] = 13;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_exp.ordinal()] = 14;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_abs.ordinal()] = 15;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_ax_b.ordinal()] = 16;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_lp.ordinal()] = 17;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_hp.ordinal()] = 18;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_bp.ordinal()] = 19;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_bt.ordinal()] = 20;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_fft.ordinal()] = 21;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_trend.ordinal()] = 22;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_max.ordinal()] = 23;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_min.ordinal()] = 24;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_envelope.ordinal()] = 25;
            } catch (NoSuchFieldError unused58) {
            }
            int[] iArr4 = new int[ServiceEnum.Function.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function = iArr4;
            try {
                iArr4[ServiceEnum.Function.FUN_MEASURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_HISTOGRAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_CURSOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_RESULT_TABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_MULTI_WINDOW.ordinal()] = 5;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_MATH.ordinal()] = 6;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_REF.ordinal()] = 7;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_FFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_COUNTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_DVM.ordinal()] = 10;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_EYE.ordinal()] = 11;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_JITTER.ordinal()] = 12;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_DECODE.ordinal()] = 13;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_UPA.ordinal()] = 14;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_BUS_ANALYSE.ordinal()] = 15;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_MASK.ordinal()] = 16;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_SEARCH.ordinal()] = 17;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_ZONE_TRIGGER.ordinal()] = 18;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_RECORD.ordinal()] = 19;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_AUTO.ordinal()] = 20;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_DISPLAY.ordinal()] = 21;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_NOTE.ordinal()] = 22;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_QUICK.ordinal()] = 23;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_SHARE.ordinal()] = 24;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_STORAGE.ordinal()] = 25;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_HELP.ordinal()] = 26;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_UPDATE.ordinal()] = 27;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_UTILITY.ordinal()] = 28;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_BACK.ordinal()] = 29;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_RESTART.ordinal()] = 30;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_SHUTDOWN.ordinal()] = 31;
            } catch (NoSuchFieldError unused89) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_RUN_STOP.ordinal()] = 32;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_SINGLE.ordinal()] = 33;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_FORCE.ordinal()] = 34;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_TRIGGER.ordinal()] = 35;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_ACQUIRE.ordinal()] = 36;
            } catch (NoSuchFieldError unused94) {
            }
        }
    }

    public void measureLight() {
        closeAllLight();
        AVerticalLight_Open();
        BHorizontalLight_Open();
    }

    public void dVMLight() {
        closeAllLight();
        AVerticalLight_Open();
        BVerticalLight_Open();
    }

    private void counterLight() {
        closeAllLight();
        AVerticalLight_Open();
    }

    public void openRecordLight() {
        closeAllLight();
        AVerticalLight_Open();
        BHorizontalLight_Open();
    }

    private void upaLight() {
        closeAllLight();
        horizontalLight();
    }

    public void setCursorChangeLight(CursorResultParam cursorResultParam, ViewABkeyViewModel viewABkeyViewModel) {
        if (cursorResultParam == null || viewABkeyViewModel == null) {
            return;
        }
        getInstance().closeAllLight();
        if (viewABkeyViewModel.getAx_boolean().getValue() != null && !viewABkeyViewModel.getAx_boolean().getValue().booleanValue()) {
            getInstance().AVerticalLight_Open();
        }
        if (viewABkeyViewModel.getBx_boolean().getValue() != null && !viewABkeyViewModel.getBx_boolean().getValue().booleanValue()) {
            getInstance().BVerticalLight_Open();
        }
        if (viewABkeyViewModel.getAy_boolean().getValue() != null && !viewABkeyViewModel.getAy_boolean().getValue().booleanValue()) {
            getInstance().AHorizontalLight_Open();
        }
        if (viewABkeyViewModel.getBy_boolean().getValue() == null || viewABkeyViewModel.getBy_boolean().getValue().booleanValue()) {
            return;
        }
        getInstance().BHorizontalLight_Open();
    }

    public void intensityLight() {
        getInstance().DefaultLight_Open();
    }

    public void cursorLight() {
        CursorViewModel cursorViewModel = (CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class);
        if (cursorViewModel != null) {
            cursorViewModel.getLiveData();
            CursorResultParam value = cursorViewModel.getLiveData().getValue();
            if (value == null || !FunctionManager.getInstance().isEnabled(ServiceEnum.Function.FUN_CURSOR)) {
                return;
            }
            setCursorChangeLight(value, (ViewABkeyViewModel) ContextUtil.getAppViewModel(ViewABkeyViewModel.class));
        }
    }

    public void refLight(int i) {
        RefViewModel refViewModel = (RefViewModel) ContextUtil.getAppViewModel(RefViewModel.class);
        if (refViewModel != null) {
            refViewModel.getLiveData();
            RefParam value = refViewModel.getLiveData().getValue();
            if (value == null || !value.getParam(i).isOnOff()) {
                return;
            }
            verticalLight();
        }
    }

    public void mathLight(int i) {
        MathViewModel mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
        if (mathViewModel != null) {
            mathViewModel.getLiveData();
            ArrayList<MathParam> value = mathViewModel.getLiveData().getValue();
            if (value == null || value.size() <= i) {
                return;
            }
            MathParam mathParam = value.get(i);
            if (mathParam.getStatus()) {
                if (mathParam.getOperator() == ServiceEnum.MathOperator.operator_fft) {
                    horizontalLight();
                } else {
                    verticalLight();
                }
            }
        }
    }

    public void decodeLight(int i) {
        DecodeViewModel decodeViewModel = (DecodeViewModel) ContextUtil.getAppViewModel(DecodeViewModel.class);
        if (decodeViewModel != null) {
            decodeViewModel.getLiveData();
            ArrayList<DecodeParam> value = decodeViewModel.getLiveData().getValue();
            DecodeParam decodeParam = null;
            if (value != null && value.size() > i) {
                decodeParam = value.get(i);
            }
            if (decodeParam == null || decodeParam.getType() == null) {
                return;
            }
            ServiceEnum.DecodeBusType type = decodeParam.getType();
            closeAllLight();
            switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[type.ordinal()]) {
                case 1:
                    if (decodeParam.getPal_clk() == 0) {
                        AVerticalLight_Open();
                        return;
                    }
                    AVerticalLight_Open();
                    BVerticalLight_Open();
                    return;
                case 2:
                    if (decodeParam.getRs232_rx() == 0) {
                        AVerticalLight_Open();
                        return;
                    }
                    AVerticalLight_Open();
                    BVerticalLight_Open();
                    return;
                case 3:
                case 4:
                    AVerticalLight_Open();
                    return;
                case 5:
                case 6:
                case 7:
                    AVerticalLight_Open();
                    BVerticalLight_Open();
                    return;
                case 8:
                case 9:
                    AVerticalLight_Open();
                    BHorizontalLight_Open();
                    return;
                default:
                    return;
            }
        }
    }

    public void decodeLight() {
        verticalLight();
    }

    public long getAvailableSize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return (statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong()) / 1000000;
    }
}
