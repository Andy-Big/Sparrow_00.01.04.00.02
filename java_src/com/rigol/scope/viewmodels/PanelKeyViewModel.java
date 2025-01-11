package com.rigol.scope.viewmodels;

import android.app.Activity;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ShellUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.data.CursorResultParam;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.DisplayParam;
import com.rigol.scope.data.FlexKnobParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MaskParam;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.NavigateParam;
import com.rigol.scope.data.RefParam;
import com.rigol.scope.data.SearchParam;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.data.WaveRecordParam;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.KeyCodeUtil;
import com.rigol.scope.utilities.KtUtilKt;
import com.rigol.scope.utilities.OffsetUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.views.UtilityPopupView;
import com.rigol.scope.views.afgawg.AfwAwgPopupView;
import com.rigol.scope.views.alert.DefaultPopupView;
import com.rigol.scope.views.analyse.AnalysePopupView;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.horizontal.HorizontalPopupView;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.knob.FlexKnobPopupView;
import com.rigol.scope.views.la.LapopupView;
import com.rigol.scope.views.mask.MaskPopupView;
import com.rigol.scope.views.measure.MeasurePopupView;
import com.rigol.scope.views.navigate.NavigatePopupView;
import com.rigol.scope.views.power.PowerPopupView;
import com.rigol.scope.views.record.RecordPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.scope.views.trigger.TriggerPopupView;
import com.rigol.scope.views.wave.WaveIntensityPopupView;
import com.rigol.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import timber.log.Timber;

/* loaded from: classes2.dex */
public class PanelKeyViewModel extends ViewModel {
    public static boolean isPowerDown = false;
    private long lastTime = 0;
    private long lastDownTime = 0;
    private final MutableLiveData<KeyEvent> onKeyUpData = new MutableLiveData<>();
    private final MutableLiveData<KeyEvent> onKeyDownData = new MutableLiveData<>();

    public void abText(KeyEvent keyEvent, int i) {
    }

    public void onPanelKeyDown(int i, KeyEvent keyEvent, List<VerticalParam> list) {
    }

    public MutableLiveData<KeyEvent> getOnKeyUpData() {
        return this.onKeyUpData;
    }

    public MutableLiveData<KeyEvent> getOnKeyDownData() {
        return this.onKeyDownData;
    }

    public void onPanelKeyUp(int i, KeyEvent keyEvent, List<VerticalParam> list, HorizontalParam horizontalParam, LaParam laParam) {
        VerticalParam verticalParam = null;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).getStatus() == ServiceEnum.enChanStatus.CHAN_ACTIVE) {
                verticalParam = list.get(i2);
            }
        }
        if (i != 2) {
            if (i != 3) {
                switch (i) {
                    case 21:
                        verticalParam = list.get(0);
                        break;
                    case 22:
                        verticalParam = list.get(1);
                        break;
                    case 23:
                        if (list.size() > 3) {
                            verticalParam = list.get(2);
                            break;
                        }
                        break;
                    case 24:
                        if (list.size() > 3) {
                            verticalParam = list.get(3);
                            break;
                        }
                        break;
                    default:
                        switch (i) {
                            case 241:
                                if (list.get(0).readImpedance() == ServiceEnum.Impedance.IMP_50) {
                                    list.get(0).saveImpedance(ServiceEnum.Impedance.IMP_1M_OL);
                                    break;
                                }
                                break;
                            case 242:
                                if (list.size() > 1 && list.get(1).readImpedance() == ServiceEnum.Impedance.IMP_50) {
                                    list.get(1).setImpedance(ServiceEnum.Impedance.IMP_1M);
                                    list.get(1).saveImpedance(ServiceEnum.Impedance.IMP_1M_OL);
                                    break;
                                }
                                break;
                            case 243:
                                if (list.size() > 2 && list.get(2).readImpedance() == ServiceEnum.Impedance.IMP_50) {
                                    list.get(2).setImpedance(ServiceEnum.Impedance.IMP_1M);
                                    list.get(2).saveImpedance(ServiceEnum.Impedance.IMP_1M_OL);
                                    break;
                                }
                                break;
                            case 244:
                                if (list.size() > 3 && list.get(3).readImpedance() == ServiceEnum.Impedance.IMP_50) {
                                    list.get(3).setImpedance(ServiceEnum.Impedance.IMP_1M);
                                    list.get(3).saveImpedance(ServiceEnum.Impedance.IMP_1M_OL);
                                    break;
                                }
                                break;
                        }
                }
            } else {
                AfgViewModel afgViewModel = (AfgViewModel) ContextUtil.getAppViewModel(AfgViewModel.class);
                if (PopupViewManager.getInstance().isShowing(AfwAwgPopupView.class) && afgViewModel.getLiveData().getValue().getBasic_output_enable()) {
                    afgViewModel.getLiveData().getValue().saveBasicOutputEnable(false);
                    PopupViewManager.getInstance().dismiss(AfwAwgPopupView.class);
                } else if (!PopupViewManager.getInstance().isShowing(AfwAwgPopupView.class) && !afgViewModel.getLiveData().getValue().getBasic_output_enable()) {
                    afgViewModel.getLiveData().getValue().saveBasicOutputEnable(true);
                } else {
                    PopupViewManager.getInstance().toggle(AfwAwgPopupView.class);
                }
            }
        } else if (laParam.getLa_calibration_probe()) {
            if (PopupViewManager.getInstance().isShowing(LapopupView.class) && laParam.getLaEnable()) {
                laParam.savelaEnable(false);
                PopupViewManager.getInstance().dismiss(LapopupView.class);
            } else if (!PopupViewManager.getInstance().isShowing(LapopupView.class) && !laParam.getLaEnable()) {
                laParam.savelaEnable(true);
            } else {
                PopupViewManager.getInstance().toggle(LapopupView.class);
            }
        } else {
            ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_la_insert_probe));
        }
        if (verticalParam == null || verticalParam.getStatus() == ServiceEnum.enChanStatus.CHAN_HIDE) {
            return;
        }
        switch (i) {
            case 21:
            case 22:
            case 23:
            case 24:
                verticalParam.toggleStatus();
                return;
            default:
                switch (i) {
                    case 154:
                        if (verticalParam.getStatus() == ServiceEnum.enChanStatus.CHAN_OFF) {
                            return;
                        }
                        if (verticalParam.getStatus() != ServiceEnum.enChanStatus.CHAN_ACTIVE) {
                            verticalParam.turnActive();
                        }
                        verticalParam.saveOffset(verticalParam.offsetLarger(keyEvent.getRepeatCount()));
                        return;
                    case 155:
                        if (verticalParam.getStatus() == ServiceEnum.enChanStatus.CHAN_OFF) {
                            return;
                        }
                        if (verticalParam.getStatus() != ServiceEnum.enChanStatus.CHAN_ACTIVE) {
                            verticalParam.turnActive();
                        }
                        verticalParam.saveOffset(verticalParam.offsetSmaller(keyEvent.getRepeatCount()));
                        return;
                    case 156:
                        verticalParam.resetOffset();
                        return;
                    default:
                        switch (i) {
                            case 218:
                                if (horizontalParam.getAcquireMode() == ServiceEnum.AcquireMode.Acquire_Ultra && horizontalParam.getRunStop() == ServiceEnum.ControlAction.Control_Stop) {
                                    ToastUtils.showShort((int) R.string.err_action_disabled);
                                    return;
                                } else {
                                    verticalParam.scaleSmaller(keyEvent.getRepeatCount());
                                    return;
                                }
                            case 219:
                                if (horizontalParam.getAcquireMode() == ServiceEnum.AcquireMode.Acquire_Ultra && horizontalParam.getRunStop() == ServiceEnum.ControlAction.Control_Stop) {
                                    ToastUtils.showShort((int) R.string.err_action_disabled);
                                    return;
                                } else {
                                    verticalParam.scaleLarger(keyEvent.getRepeatCount());
                                    return;
                                }
                            case 220:
                                verticalParam.toggleFine();
                                ViewUtil.switchToast(R.string.msg_chan_fine, verticalParam.getFine());
                                return;
                            default:
                                return;
                        }
                }
        }
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.viewmodels.-$$Lambda$PanelKeyViewModel$1eVsqZQMYKK3-kOA3162iNIUYHg.accept(java.lang.Object):void] */
    static /* synthetic */ void lambda$onPanelKeyUp$0(ShellUtils.CommandResult commandResult) {
        Timber.d(commandResult.toString(), new Object[0]);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.viewmodels.-$$Lambda$PanelKeyViewModel$siSbSJOePjXw0lYgex3OFVgq2W0.accept(java.lang.Object):void] */
    static /* synthetic */ void lambda$onPanelKeyUp$1(ShellUtils.CommandResult commandResult) {
        Timber.d(commandResult.toString(), new Object[0]);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.viewmodels.-$$Lambda$PanelKeyViewModel$_NFAhMPlZmZu0ph9fWTLtpMsues.run():void] */
    static /* synthetic */ void lambda$onPanelKeyUp$2() {
        PopupViewManager.getInstance().toggle(DefaultPopupView.class);
    }

    static /* synthetic */ void lambda$onPanelKeyUp$3(MeasureSettingParam measureSettingParam) {
        measureSettingParam.saveThresholdType(ServiceEnum.ThreType.TH_TYPE_ABS);
        API.getInstance().UI_PostInt32(28, MessageID.MSG_APP_MEAS_TH_DEFAULT, 1);
        measureSettingParam.saveThresholdType(ServiceEnum.ThreType.TH_TYPE_PER);
    }

    public void onPanelKeyUp(int i, KeyEvent keyEvent, HorizontalParam horizontalParam, List<VerticalParam> list, TriggerParam triggerParam, CursorResultParam cursorResultParam, List<MathParam> list2, DisplayParam displayParam, NavigateParam navigateParam, SearchParam searchParam, MaskParam maskParam, ViewABkeyViewModel viewABkeyViewModel) {
        if (horizontalParam == null || list == null || triggerParam == null || cursorResultParam == null || list2 == null || displayParam == null || navigateParam == null || searchParam == null || maskParam == null || viewABkeyViewModel == null) {
            return;
        }
        if (i == 1) {
            ((RefViewModel) ContextUtil.getAppViewModel(RefViewModel.class)).getLiveData().getValue().getParam().setRefColor(((RefViewModel) ContextUtil.getAppViewModel(RefViewModel.class)).getLiveData().getValue().getParam().getRefColor());
            FunctionManager.getInstance().handleItemClick(ServiceEnum.Function.FUN_REF);
            return;
        }
        boolean z = false;
        if (i == 32) {
            if (horizontalParam.getAcquireMode() == ServiceEnum.AcquireMode.Acquire_Ultra) {
                ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                return;
            }
            if (horizontalParam.getAcquireMode() != ServiceEnum.AcquireMode.Acquire_Ultra && (horizontalParam.getTimeMode() != ServiceEnum.HoriTimeMode.Horizontal_ROLL || horizontalParam.getRunStop() == ServiceEnum.ControlAction.Control_Stop)) {
                z = true;
            }
            if (z) {
                horizontalParam.saveZoom(!horizontalParam.readZoom());
                return;
            } else {
                ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                return;
            }
        }
        switch (i) {
            case 4:
                FunctionManager.getInstance().handleItemClick(ServiceEnum.Function.FUN_HORIZONTAL);
                return;
            case 5:
                PopupViewManager.getInstance().toggle(NavigatePopupView.class);
                return;
            case 6:
                NavigatePopupView navigatePopupView = (NavigatePopupView) PopupViewManager.getInstance().get(NavigatePopupView.class);
                RecordPopupView recordPopupView = (RecordPopupView) PopupViewManager.getInstance().get(RecordPopupView.class);
                onPlayKey(navigatePopupView, R.id.playLastImage);
                onPlayKey(recordPopupView, R.id.play_last);
                if (navigatePopupView.getContentView().findViewById(R.id.playLastImage).isEnabled() && navigatePopupView.isShowing()) {
                    return;
                }
                if (recordPopupView.getContentView().findViewById(R.id.play_last).isEnabled() && recordPopupView.isShowing()) {
                    return;
                }
                ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                return;
            case 7:
                NavigatePopupView navigatePopupView2 = (NavigatePopupView) PopupViewManager.getInstance().get(NavigatePopupView.class);
                RecordPopupView recordPopupView2 = (RecordPopupView) PopupViewManager.getInstance().get(RecordPopupView.class);
                onPlayKey(navigatePopupView2, R.id.playImage);
                onPlayKey(recordPopupView2, R.id.play);
                if (navigatePopupView2.getContentView().findViewById(R.id.playImage).isEnabled() && navigatePopupView2.isShowing()) {
                    return;
                }
                if (recordPopupView2.getContentView().findViewById(R.id.play).isEnabled() && recordPopupView2.isShowing()) {
                    return;
                }
                ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                return;
            case 8:
                NavigatePopupView navigatePopupView3 = (NavigatePopupView) PopupViewManager.getInstance().get(NavigatePopupView.class);
                RecordPopupView recordPopupView3 = (RecordPopupView) PopupViewManager.getInstance().get(RecordPopupView.class);
                onPlayKey(navigatePopupView3, R.id.playNextImage);
                onPlayKey(recordPopupView3, R.id.play_next);
                if (navigatePopupView3.getContentView().findViewById(R.id.playNextImage).isEnabled() && navigatePopupView3.isShowing()) {
                    return;
                }
                if (recordPopupView3.getContentView().findViewById(R.id.play_next).isEnabled() && recordPopupView3.isShowing()) {
                    return;
                }
                ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                return;
            case 9:
                if (triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Edge) {
                    if (triggerParam.getEdgeSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Rising) {
                        triggerParam.setEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Falling);
                        triggerParam.saveEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Falling.value1);
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP1_LED_WHITE.value1, 0);
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP2_LED_WHITE.value1, 1);
                        return;
                    } else if (triggerParam.getEdgeSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Falling) {
                        triggerParam.setEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Any);
                        triggerParam.saveEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Any.value1);
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP1_LED_WHITE.value1, 1);
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP2_LED_WHITE.value1, 1);
                        return;
                    } else if (triggerParam.getEdgeSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Any) {
                        triggerParam.setEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Rising);
                        triggerParam.saveEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Rising.value1);
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP2_LED_WHITE.value1, 0);
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP1_LED_WHITE.value1, 1);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case 10:
                API.getInstance().UI_PostBool(41, MessageID.MSG_TRIGGER_FORCE, true);
                return;
            case 11:
                API.getInstance().UI_PostInt32(26, MessageID.MSG_DISPLAY_CLEAR, 0);
                FunctionManager.getInstance().refSwitch = false;
                return;
            case 12:
                if (!navigateParam.getIfPlaying()) {
                    FunctionManager.getInstance().handleItemClick(ServiceEnum.Function.FUN_RUN_STOP);
                } else {
                    ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                }
                if (maskParam == null || PopupViewManager.getInstance().isShowing(MaskPopupView.class)) {
                    return;
                }
                maskParam.readForceStop();
                if (maskParam.getErrAction() == 4 || maskParam.getErrAction() == 6) {
                    z = true;
                }
                if (maskParam.isEnable() && z) {
                    maskParam.saveForceStop(true);
                    return;
                }
                return;
            case 13:
                long downTime = keyEvent.getDownTime();
                if (downTime - this.lastDownTime < 1100) {
                    this.lastDownTime = downTime;
                    return;
                }
                if (!API.getInstance().UI_QueryBool(35, 776)) {
                    API.getInstance().UI_PostInt32(35, 768, 0);
                } else {
                    ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_auto_disabled));
                }
                this.lastDownTime = downTime;
                return;
            case 14:
                if (horizontalParam.getTimeMode() != ServiceEnum.HoriTimeMode.Horizontal_ROLL) {
                    triggerParam.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1);
                    return;
                }
                return;
            case 15:
                PopupViewManager.getInstance().toggle(MeasurePopupView.class);
                return;
            case 16:
                FunctionManager.getInstance().handleItemClick(ServiceEnum.Function.FUN_CURSOR);
                return;
            case 17:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.lastTime > 2000) {
                    ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.viewmodels.-$$Lambda$PanelKeyViewModel$_NFAhMPlZmZu0ph9fWTLtpMsues
                        @Override // java.lang.Runnable
                        public final void run() {
                            PanelKeyViewModel.lambda$onPanelKeyUp$2();
                        }
                    }, 200L);
                    ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_click_to_default));
                    this.lastTime = currentTimeMillis;
                    return;
                }
                ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_restored_to_default));
                PopupViewManager.getInstance().dismiss(DefaultPopupView.class);
                API.getInstance().UI_PostInt32(12, MessageID.MSG_RESTORE_DEFAULT, 0);
                MessageBus.getInstance().onSyncData(MessageBus.getKey(25, MessageID.MSG_SEARCH_MARK_TABEL_EN), false);
                KtUtilKt.resetAll();
                this.lastTime = 0L;
                MeasureSettingViewModel measureSettingViewModel = (MeasureSettingViewModel) ContextUtil.getAppViewModel(MeasureSettingViewModel.class);
                if (measureSettingViewModel != null) {
                    measureSettingViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$PanelKeyViewModel$hmleiXqjULF6ueQTplD8uL5WjoA
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            PanelKeyViewModel.lambda$onPanelKeyUp$3((MeasureSettingParam) obj);
                        }
                    });
                    return;
                }
                return;
            case 18:
                PopupViewManager.getInstance().toggle(AnalysePopupView.class);
                return;
            case 19:
                boolean readReadInputKeyboard = ((UtilityParam) Objects.requireNonNull(((UtilityViewModel) Objects.requireNonNull((UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class))).getLiveData().getValue())).readReadInputKeyboard();
                if (readReadInputKeyboard) {
                    ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_touch_enable));
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.TOUCH_LED_WHITE.value1, 0);
                    ShellUtils.execCmdAsync("insmod /rigol/driver/focaltech_ts.ko", true, (Utils.Consumer<ShellUtils.CommandResult>) new Utils.Consumer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$PanelKeyViewModel$1eVsqZQMYKK3-kOA3162iNIUYHg
                        @Override // com.blankj.utilcode.util.Utils.Consumer
                        public final void accept(Object obj) {
                            PanelKeyViewModel.lambda$onPanelKeyUp$0((ShellUtils.CommandResult) obj);
                        }
                    });
                } else {
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.TOUCH_LED_WHITE.value1, 1);
                    ShellUtils.execCmdAsync("rmmod /rigol/driver/focaltech_ts.ko", true, (Utils.Consumer<ShellUtils.CommandResult>) new Utils.Consumer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$PanelKeyViewModel$siSbSJOePjXw0lYgex3OFVgq2W0
                        @Override // com.blankj.utilcode.util.Utils.Consumer
                        public final void accept(Object obj) {
                            PanelKeyViewModel.lambda$onPanelKeyUp$1((ShellUtils.CommandResult) obj);
                        }
                    });
                    ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_touch_disable));
                }
                ViewUtil.lock(ActivityUtils.getTopActivity().getWindow(), !readReadInputKeyboard);
                ((UtilityParam) Objects.requireNonNull((UtilityParam) Objects.requireNonNull(((UtilityViewModel) Objects.requireNonNull((UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class))).getLiveData().getValue()))).saveReadInputKeyboard(!readReadInputKeyboard);
                PopupViewManager.getInstance().dismiss(UtilityPopupView.class);
                PopupViewManager.getInstance().dismissAll(new Class[0]);
                return;
            case 20:
                ToastUtils.INSTANCE.cancel();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() { // from class: com.rigol.scope.viewmodels.PanelKeyViewModel.1
                    {
                        PanelKeyViewModel.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        ViewUtil.quickAction();
                        handler.removeCallbacks(null);
                    }
                }, 100L);
                return;
            default:
                switch (i) {
                    case 25:
                        FunctionManager.getInstance().handleItemClick(ServiceEnum.Function.FUN_MATH);
                        return;
                    case 26:
                        FunctionManager.getInstance().handleItemClick(ServiceEnum.Function.FUN_TRIGGER);
                        return;
                    case 27:
                        if (!isPowerDown) {
                            isPowerDown = true;
                            WaveRecordViewModel waveRecordViewModel = (WaveRecordViewModel) ContextUtil.getAppViewModel(WaveRecordViewModel.class);
                            if (waveRecordViewModel != null) {
                                waveRecordViewModel.getLiveData();
                                WaveRecordParam value = waveRecordViewModel.getLiveData().getValue();
                                if (value != null) {
                                    if (!value.isRecordPlay()) {
                                        PopupViewManager.getInstance().toggle(PowerPopupView.class);
                                        return;
                                    } else {
                                        ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        API.getInstance().UI_PostInt32(11, MessageID.MSG_HARDWARE_POWERDOWN, 1);
                        isPowerDown = false;
                        return;
                    default:
                        switch (i) {
                            case 138:
                                if (horizontalParam.getZoomScale() == horizontalParam.getMainScale() && horizontalParam.isZoom()) {
                                    return;
                                }
                                if (horizontalParam.getAcquireMode() == ServiceEnum.AcquireMode.Acquire_Ultra && horizontalParam.getRunStop() == ServiceEnum.ControlAction.Control_Stop) {
                                    ToastUtils.showShort((int) R.string.err_action_disabled);
                                    return;
                                } else {
                                    handleOffsetCW(horizontalParam, keyEvent.getRepeatCount());
                                    return;
                                }
                            case 139:
                                if (horizontalParam.getZoomScale() == horizontalParam.getMainScale() && horizontalParam.isZoom()) {
                                    return;
                                }
                                if (horizontalParam.getAcquireMode() == ServiceEnum.AcquireMode.Acquire_Ultra && horizontalParam.getRunStop() == ServiceEnum.ControlAction.Control_Stop) {
                                    ToastUtils.showShort((int) R.string.err_action_disabled);
                                    return;
                                } else {
                                    handleOffsetCCW(horizontalParam, keyEvent.getRepeatCount());
                                    return;
                                }
                            case 140:
                                if (horizontalParam.getZoomScale() == horizontalParam.getMainScale() && horizontalParam.isZoom()) {
                                    return;
                                }
                                handleOffsetZ(horizontalParam);
                                return;
                            default:
                                switch (i) {
                                    case 202:
                                        if (horizontalParam.getAcquireMode() == ServiceEnum.AcquireMode.Acquire_Ultra && horizontalParam.getRunStop() == ServiceEnum.ControlAction.Control_Stop) {
                                            ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                                            return;
                                        } else {
                                            handleScaleCW(horizontalParam);
                                            return;
                                        }
                                    case 203:
                                        if (horizontalParam.getAcquireMode() == ServiceEnum.AcquireMode.Acquire_Ultra && horizontalParam.getRunStop() == ServiceEnum.ControlAction.Control_Stop) {
                                            ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                                            return;
                                        } else {
                                            handleScaleCCW(horizontalParam, searchParam);
                                            return;
                                        }
                                    case 204:
                                        if (((UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class)).getValue().getShowzoom()) {
                                            if (horizontalParam.getAcquireMode() == ServiceEnum.AcquireMode.Acquire_Ultra || API.getInstance().UI_QueryBool(61, MessageID.MSG_BODE_ENABLE)) {
                                                ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                                                return;
                                            }
                                            if (horizontalParam.getAcquireMode() != ServiceEnum.AcquireMode.Acquire_Ultra && (horizontalParam.getTimeMode() != ServiceEnum.HoriTimeMode.Horizontal_ROLL || horizontalParam.getRunStop() == ServiceEnum.ControlAction.Control_Stop)) {
                                                if (horizontalParam.isZoom()) {
                                                    horizontalParam.saveZoom(false);
                                                    return;
                                                } else {
                                                    horizontalParam.saveZoom(true);
                                                    return;
                                                }
                                            }
                                            ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                                            return;
                                        } else if (horizontalParam.getAcquireMode() == ServiceEnum.AcquireMode.Acquire_Ultra && horizontalParam.getRunStop() == ServiceEnum.ControlAction.Control_Stop && PopupViewManager.getInstance().isShowing(NavigatePopupView.class)) {
                                            ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                                            return;
                                        } else {
                                            handleScaleZ(horizontalParam);
                                            return;
                                        }
                                    default:
                                        switch (i) {
                                            case 234:
                                                if (triggerParam.getTrigger_Spi_CS() != ServiceEnum.Trigger_Spi_CS.trig_spi_cs && triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
                                                    HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
                                                    VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
                                                    HorizontalParam horizontalParam2 = null;
                                                    List<VerticalParam> arrayList = new ArrayList<>();
                                                    if (horizontalViewModel != null) {
                                                        horizontalViewModel.getLiveData();
                                                        horizontalParam2 = horizontalViewModel.getLiveData().getValue();
                                                    }
                                                    if (verticalViewModel != null) {
                                                        verticalViewModel.getLiveData();
                                                        arrayList = verticalViewModel.getLiveData().getValue();
                                                    }
                                                    handleLevelCW(horizontalParam2, arrayList, triggerParam, keyEvent);
                                                    return;
                                                } else if (horizontalParam.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL) {
                                                    return;
                                                } else {
                                                    ServiceEnum.Chan chan = triggerParam.getChan();
                                                    if (chan == ServiceEnum.Chan.acline) {
                                                        triggerParam.saveLevel(0L, keyEvent.getRepeatCount());
                                                        return;
                                                    } else if (chan == ServiceEnum.Chan.ext) {
                                                        long level = triggerParam.getLevel();
                                                        int i2 = (level > (-10000000L) ? 1 : (level == (-10000000L) ? 0 : -1));
                                                        if (i2 > 0 && level < 10000000) {
                                                            triggerParam.setLevel(0L);
                                                            triggerParam.saveLevel(10000000L, keyEvent.getRepeatCount());
                                                            return;
                                                        } else if ((level < 10000000 || level >= 1000000000) && (level <= -1000000000 || i2 > 0)) {
                                                            if ((level >= 1000000000 && level <= 7990000000L) || (level >= -8000000000L && i2 <= 0)) {
                                                                triggerParam.saveLevel(10000000L, keyEvent.getRepeatCount());
                                                                return;
                                                            }
                                                            triggerParam.setLevel(8000000000L);
                                                            triggerParam.saveLevel(0L, keyEvent.getRepeatCount());
                                                            return;
                                                        } else {
                                                            long j = (level / 1000000) % 10;
                                                            triggerParam.setLevel((level / 10000000) * 10000000);
                                                            if ((j >= 0 && j <= 4) || j <= -5) {
                                                                triggerParam.saveLevel(10000000L, keyEvent.getRepeatCount());
                                                                return;
                                                            } else {
                                                                triggerParam.saveLevel(20000000L, keyEvent.getRepeatCount());
                                                                return;
                                                            }
                                                        }
                                                    } else if (chan.value1 >= ServiceEnum.Chan.chan1.value1 && chan.value1 <= ServiceEnum.Chan.chan4.value1) {
                                                        long verticalOffsetStep = OffsetUtil.getVerticalOffsetStep(ViewUtil.getVerticalItem(list, triggerParam.getChan()).getScale(), keyEvent.getRepeatCount());
                                                        double chanScale = ((5 * triggerParam.getChanScale()) * 0.9d) - triggerParam.getChanOffset();
                                                        if (triggerParam.getLevel() <= chanScale - verticalOffsetStep) {
                                                            triggerParam.saveLevel(verticalOffsetStep, keyEvent.getRepeatCount());
                                                            return;
                                                        }
                                                        triggerParam.setLevel((long) chanScale);
                                                        triggerParam.saveLevel(0L, keyEvent.getRepeatCount());
                                                        return;
                                                    } else if (chan.value1 < ServiceEnum.Chan.d0.value1 || chan.value1 > ServiceEnum.Chan.d15.value1 || triggerParam.getLevel() > triggerParam.getLevelAttr().getMaxLongValue()) {
                                                        return;
                                                    } else {
                                                        triggerParam.saveLevel(10000000, keyEvent.getRepeatCount());
                                                        return;
                                                    }
                                                }
                                            case 235:
                                                if (horizontalParam.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL) {
                                                    return;
                                                }
                                                ServiceEnum.Chan chan2 = triggerParam.getChan();
                                                if (chan2 == ServiceEnum.Chan.acline) {
                                                    triggerParam.saveLevel(0L, keyEvent.getRepeatCount());
                                                    return;
                                                } else if (chan2 == ServiceEnum.Chan.ext) {
                                                    long level2 = triggerParam.getLevel();
                                                    int i3 = (level2 > (-10000000L) ? 1 : (level2 == (-10000000L) ? 0 : -1));
                                                    if (i3 > 0 && level2 < 10000000) {
                                                        triggerParam.setLevel(0L);
                                                        triggerParam.saveLevel(-10000000L, keyEvent.getRepeatCount());
                                                        return;
                                                    } else if ((level2 < 10000000 || level2 >= 1000000000) && (level2 <= -1000000000 || i3 > 0)) {
                                                        if ((level2 >= 1000000000 && level2 <= 8000000000L) || (level2 >= -7990000000L && i3 <= 0)) {
                                                            triggerParam.saveLevel(-10000000L, keyEvent.getRepeatCount());
                                                            return;
                                                        }
                                                        triggerParam.setLevel(-8000000000L);
                                                        triggerParam.saveLevel(0L, keyEvent.getRepeatCount());
                                                        return;
                                                    } else {
                                                        long j2 = (level2 / 1000000) % 10;
                                                        triggerParam.setLevel((level2 / 10000000) * 10000000);
                                                        if ((j2 >= 0 && j2 <= 4) || j2 <= -5) {
                                                            triggerParam.saveLevel(-10000000L, keyEvent.getRepeatCount());
                                                            return;
                                                        } else {
                                                            triggerParam.saveLevel(-20000000L, keyEvent.getRepeatCount());
                                                            return;
                                                        }
                                                    }
                                                } else if (chan2.value1 >= ServiceEnum.Chan.chan1.value1 && chan2.value1 <= ServiceEnum.Chan.chan4.value1) {
                                                    long verticalOffsetStep2 = OffsetUtil.getVerticalOffsetStep(ViewUtil.getVerticalItem(list, triggerParam.getChan()).getScale(), keyEvent.getRepeatCount());
                                                    double chanScale2 = (((-5) * triggerParam.getChanScale()) * 0.9d) - triggerParam.getChanOffset();
                                                    if (triggerParam.getLevel() >= verticalOffsetStep2 + chanScale2) {
                                                        triggerParam.saveLevel(-verticalOffsetStep2, keyEvent.getRepeatCount());
                                                        return;
                                                    }
                                                    triggerParam.setLevel((long) chanScale2);
                                                    triggerParam.saveLevel(0L, keyEvent.getRepeatCount());
                                                    return;
                                                } else if (chan2.value1 < ServiceEnum.Chan.d0.value1 || chan2.value1 > ServiceEnum.Chan.d15.value1) {
                                                    return;
                                                } else {
                                                    if (triggerParam.getLevel() <= triggerParam.getLevelAttr().getMaxLongValue()) {
                                                        LogUtils.e("step", Long.valueOf(triggerParam.getLevelAttr().getStepValue()));
                                                    }
                                                    triggerParam.saveLevel(-10000000, keyEvent.getRepeatCount());
                                                    return;
                                                }
                                            case 236:
                                                if (horizontalParam.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL || triggerParam.getChan() == ServiceEnum.Chan.acline) {
                                                    return;
                                                }
                                                if (triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Slope) {
                                                    if (triggerParam.getSlopeTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_High) {
                                                        triggerParam.saveSlopeLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Low.value1);
                                                        return;
                                                    } else if (triggerParam.getSlopeTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
                                                        triggerParam.saveSlopeLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Double.value1);
                                                        return;
                                                    } else {
                                                        triggerParam.saveSlopeLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_High.value1);
                                                        return;
                                                    }
                                                } else if (triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Runt) {
                                                    if (triggerParam.getRuntTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_High) {
                                                        triggerParam.saveRuntLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Low.value1);
                                                        return;
                                                    } else if (triggerParam.getRuntTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
                                                        triggerParam.saveRuntLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Double.value1);
                                                        return;
                                                    } else {
                                                        triggerParam.saveRuntLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_High.value1);
                                                        return;
                                                    }
                                                } else if (triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Over) {
                                                    if (triggerParam.getOverTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_High) {
                                                        triggerParam.saveOverSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Low.value1);
                                                        return;
                                                    } else if (triggerParam.getOverTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
                                                        triggerParam.saveOverSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Double.value1);
                                                        return;
                                                    } else {
                                                        triggerParam.saveOverSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_High.value1);
                                                        return;
                                                    }
                                                } else if (triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
                                                    if (triggerParam.getMilstdTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_High) {
                                                        triggerParam.saveMilstdLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Low.value1);
                                                        return;
                                                    } else if (triggerParam.getMilstdTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
                                                        triggerParam.saveMilstdLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Double.value1);
                                                        return;
                                                    } else {
                                                        triggerParam.saveMilstdLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_High.value1);
                                                        return;
                                                    }
                                                } else {
                                                    API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_LEVEL_Z, 0);
                                                    return;
                                                }
                                            default:
                                                return;
                                        }
                                }
                        }
                }
        }
    }

    private void onPlayKey(BasePopupView basePopupView, int i) {
        if (basePopupView.getContentView().findViewById(i).isEnabled() && basePopupView.getContentView().findViewById(i).getVisibility() == 0 && basePopupView.isShowing()) {
            basePopupView.getContentView().findViewById(i).performClick();
        }
    }

    private void handleScaleZ(HorizontalParam horizontalParam) {
        if (ActivityUtils.getTopActivity() instanceof MainActivity) {
            horizontalParam.saveFine(!horizontalParam.readBool(MessageID.MSG_HOR_FINE_ON));
            ViewUtil.switchToast(R.string.msg_hor_fine_on, horizontalParam.isFine());
        }
    }

    private void handleScaleCW(HorizontalParam horizontalParam) {
        boolean UI_QueryBool = API.getInstance().UI_QueryBool(40, MessageID.MSG_PRE_PLAY);
        if ((horizontalParam.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_SCAN && horizontalParam.getRunStop() != ServiceEnum.ControlAction.Control_Stop) || UI_QueryBool) {
            API.getInstance().UI_PostInt32(40, MessageID.MSG_PRE_PLAY, ServiceEnum.Function.FUN_HORIZONTAL.value1);
        }
        if (horizontalParam.isZoom()) {
            horizontalParam.saveZoomScale(horizontalParam.getScaleSmaller(horizontalParam.getZoomScale()));
        } else {
            horizontalParam.saveMainScale(horizontalParam.getScaleSmaller(horizontalParam.getMainScale()));
        }
    }

    private void handleScaleCCW(HorizontalParam horizontalParam, SearchParam searchParam) {
        boolean UI_QueryBool = API.getInstance().UI_QueryBool(40, MessageID.MSG_PRE_PLAY);
        if ((horizontalParam.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_SCAN && horizontalParam.getRunStop() != ServiceEnum.ControlAction.Control_Stop) || UI_QueryBool) {
            API.getInstance().UI_PostInt32(40, MessageID.MSG_PRE_PLAY, ServiceEnum.Function.FUN_HORIZONTAL.value1);
        }
        if (horizontalParam.isZoom()) {
            horizontalParam.saveZoomScale(horizontalParam.getScaleLager(horizontalParam.getZoomScale()));
        } else {
            horizontalParam.saveMainScale(horizontalParam.getScaleLager(horizontalParam.getMainScale()));
        }
        if (horizontalParam.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL && horizontalParam.getRunStop() == ServiceEnum.ControlAction.Control_Run) {
            searchParam.saveEnable(false);
            WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_SEARCH);
            searchParam.saveMarkTableEn(false);
            MessageBus.getInstance().onSyncData(MessageBus.getKey(25, MessageID.MSG_SEARCH_MARK_TABEL_EN), false);
        }
    }

    private void handleHorizontalMenu(CursorResultParam cursorResultParam) {
        if (ActivityUtils.getTopActivity() instanceof MainActivity) {
            ServiceEnum.Function selectedFunction = FunctionManager.getInstance().getSelectedFunction();
            if (selectedFunction == ServiceEnum.Function.FUN_TRIGGER) {
                PopupViewManager.getInstance().toggle(TriggerPopupView.class);
            } else if (selectedFunction == ServiceEnum.Function.FUN_MEASURE) {
                PopupViewManager.getInstance().toggle(MeasurePopupView.class);
            } else if (selectedFunction == ServiceEnum.Function.FUN_CURSOR) {
                cursorResultParam.saveXorY(cursorResultParam.getView() != ServiceEnum.CursorView.cursor_view_hori);
            } else {
                PopupViewManager.getInstance().toggle(HorizontalPopupView.class);
            }
        }
    }

    public void handleOffsetCW(HorizontalParam horizontalParam, int i) {
        if (((MainActivity) ActivityUtils.getTopActivity()).isMotorShowing()) {
            return;
        }
        if (horizontalParam.isZoom()) {
            long offsetLarger = horizontalParam.offsetLarger(horizontalParam.getZoomScale(), horizontalParam.getZoomOffset(), i);
            if (horizontalParam.getTimeMode() != ServiceEnum.HoriTimeMode.Horizontal_SCAN) {
                horizontalParam.moveZoomOffset(offsetLarger);
            } else {
                horizontalParam.moveZoomOffset(offsetLarger);
            }
        } else if (horizontalParam.getTimeMode() != ServiceEnum.HoriTimeMode.Horizontal_ROLL || horizontalParam.getRunStop() == ServiceEnum.ControlAction.Control_Stop) {
            long offsetSmaller = horizontalParam.offsetSmaller(horizontalParam.getMainScale(), horizontalParam.getMainOffset(), i);
            if (horizontalParam.getTimeMode() != ServiceEnum.HoriTimeMode.Horizontal_SCAN) {
                horizontalParam.moveMainOffset(offsetSmaller);
            } else {
                horizontalParam.moveMainOffset(offsetSmaller);
            }
        }
    }

    public void handleOffsetCCW(HorizontalParam horizontalParam, int i) {
        if (((MainActivity) ActivityUtils.getTopActivity()).isMotorShowing()) {
            return;
        }
        if (horizontalParam.isZoom()) {
            long offsetSmaller = horizontalParam.offsetSmaller(horizontalParam.getZoomScale(), horizontalParam.getZoomOffset(), i);
            if (horizontalParam.getTimeMode() != ServiceEnum.HoriTimeMode.Horizontal_SCAN) {
                horizontalParam.moveZoomOffset(offsetSmaller);
            } else {
                horizontalParam.moveZoomOffset(offsetSmaller);
            }
        } else if (horizontalParam.getTimeMode() != ServiceEnum.HoriTimeMode.Horizontal_ROLL || horizontalParam.getRunStop() == ServiceEnum.ControlAction.Control_Stop) {
            long offsetLarger = horizontalParam.offsetLarger(horizontalParam.getMainScale(), horizontalParam.getMainOffset(), i);
            if (horizontalParam.getTimeMode() != ServiceEnum.HoriTimeMode.Horizontal_SCAN) {
                horizontalParam.moveMainOffset(offsetLarger);
            } else {
                horizontalParam.moveMainOffset(offsetLarger);
            }
        }
    }

    private void handleOffsetZ(HorizontalParam horizontalParam) {
        Activity topActivity = ActivityUtils.getTopActivity();
        if (!(topActivity instanceof MainActivity) || ((MainActivity) topActivity).isMotorShowing()) {
            return;
        }
        if (horizontalParam.isZoom()) {
            horizontalParam.moveZoomOffset(0L);
        } else if (horizontalParam.getTimeMode() != ServiceEnum.HoriTimeMode.Horizontal_ROLL || horizontalParam.getRunStop() == ServiceEnum.ControlAction.Control_Stop) {
            horizontalParam.saveMainOffset(0L);
        }
    }

    public void handleLevelCW(HorizontalParam horizontalParam, List<VerticalParam> list, TriggerParam triggerParam, KeyEvent keyEvent) {
        if (horizontalParam == null || horizontalParam.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL || triggerParam == null) {
            return;
        }
        ServiceEnum.Chan chan = triggerParam.getChan();
        if (chan == ServiceEnum.Chan.acline) {
            triggerParam.saveLevel(0L, keyEvent.getRepeatCount());
        } else if (chan == ServiceEnum.Chan.ext) {
            long level = triggerParam.getLevel();
            int i = (level > (-10000000L) ? 1 : (level == (-10000000L) ? 0 : -1));
            if (i > 0 && level < 10000000) {
                triggerParam.setLevel(0L);
                triggerParam.saveLevel(10000000L, keyEvent.getRepeatCount());
            } else if ((level < 10000000 || level >= 1000000000) && (level <= -1000000000 || i > 0)) {
                if ((level >= 1000000000 && level <= 7990000000L) || (level >= -8000000000L && i <= 0)) {
                    triggerParam.saveLevel(10000000L, keyEvent.getRepeatCount());
                    return;
                }
                triggerParam.setLevel(8000000000L);
                triggerParam.saveLevel(0L, keyEvent.getRepeatCount());
            } else {
                long j = (level / 1000000) % 10;
                triggerParam.setLevel((level / 10000000) * 10000000);
                if ((j >= 0 && j <= 4) || j <= -5) {
                    triggerParam.saveLevel(10000000L, keyEvent.getRepeatCount());
                } else {
                    triggerParam.saveLevel(20000000L, keyEvent.getRepeatCount());
                }
            }
        } else if (chan.value1 >= ServiceEnum.Chan.chan1.value1 && chan.value1 <= ServiceEnum.Chan.chan4.value1) {
            VerticalParam verticalItem = ViewUtil.getVerticalItem(list, triggerParam.getChan());
            if (verticalItem == null) {
                LogUtils.e("verticalItem is null");
                return;
            }
            long verticalOffsetStep = OffsetUtil.getVerticalOffsetStep(verticalItem.getScale(), keyEvent.getRepeatCount());
            long chanOffset = triggerParam.getChanOffset();
            long chanScale = triggerParam.getChanScale();
            long level2 = triggerParam.getLevel();
            if (triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Slope) {
                if (triggerParam.getSlopeTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
                    level2 = triggerParam.getSlopelevelB();
                } else if (triggerParam.getSlopeTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_High) {
                    level2 = triggerParam.getSlopelevelA();
                }
            } else if (triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Runt) {
                if (triggerParam.getRuntTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
                    level2 = triggerParam.getRuntlevelB();
                } else if (triggerParam.getRuntTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_High) {
                    level2 = triggerParam.getRuntlevelA();
                }
            } else if (triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Over) {
                if (triggerParam.getOverTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
                    level2 = triggerParam.getOverlevelB();
                } else if (triggerParam.getOverTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_High) {
                    level2 = triggerParam.getOverlevelA();
                }
            } else if (triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
                if (triggerParam.getMilstdTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
                    level2 = triggerParam.getMilstdlevelB();
                } else if (triggerParam.getMilstdTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_High) {
                    level2 = triggerParam.getMilstdlevelA();
                }
            }
            double d = ((5 * chanScale) * 0.9d) - chanOffset;
            if (level2 <= d - verticalOffsetStep) {
                triggerParam.saveLevel(verticalOffsetStep, keyEvent.getRepeatCount());
            } else {
                triggerParam.setLevel((long) d);
                triggerParam.saveLevel(0L, keyEvent.getRepeatCount());
            }
            triggerParam.releaseCurrentKeyEvent(keyEvent);
        } else if (chan.value1 < ServiceEnum.Chan.d0.value1 || chan.value1 > ServiceEnum.Chan.d15.value1) {
        } else {
            if (triggerParam.getLevel() <= triggerParam.getLevelAttr().getMaxLongValue()) {
                LogUtils.e("step", Long.valueOf(triggerParam.getLevelAttr().getStepValue()));
            }
            triggerParam.saveLevel(10000000, keyEvent.getRepeatCount());
        }
    }

    public void handleLevelCCW(HorizontalParam horizontalParam, List<VerticalParam> list, TriggerParam triggerParam, KeyEvent keyEvent) {
        if (horizontalParam == null || horizontalParam.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL || triggerParam == null) {
            return;
        }
        ServiceEnum.Chan chan = triggerParam.getChan();
        if (chan == ServiceEnum.Chan.acline) {
            triggerParam.saveLevel(0L, keyEvent.getRepeatCount());
        } else if (chan == ServiceEnum.Chan.ext) {
            long level = triggerParam.getLevel();
            int i = (level > (-10000000L) ? 1 : (level == (-10000000L) ? 0 : -1));
            if (i > 0 && level < 10000000) {
                triggerParam.setLevel(0L);
                triggerParam.saveLevel(-10000000L, keyEvent.getRepeatCount());
            } else if ((level >= 10000000 && level < 1000000000) || (level > -1000000000 && i <= 0)) {
                long j = (level / 1000000) % 10;
                triggerParam.setLevel((level / 10000000) * 10000000);
                if ((j >= 0 && j <= 4) || j <= -5) {
                    triggerParam.saveLevel(-10000000L, keyEvent.getRepeatCount());
                } else {
                    triggerParam.saveLevel(-20000000L, keyEvent.getRepeatCount());
                }
            } else if ((level >= 1000000000 && level <= 8000000000L) || (level >= -7990000000L && i <= 0)) {
                triggerParam.saveLevel(-10000000L, keyEvent.getRepeatCount());
            } else {
                triggerParam.setLevel(-8000000000L);
                triggerParam.saveLevel(0L, keyEvent.getRepeatCount());
            }
        } else if (chan.value1 >= ServiceEnum.Chan.chan1.value1 && chan.value1 <= ServiceEnum.Chan.chan4.value1) {
            long verticalOffsetStep = OffsetUtil.getVerticalOffsetStep(ViewUtil.getVerticalItem(list, triggerParam.getChan()).getScale(), keyEvent.getRepeatCount());
            double chanScale = (((-5) * triggerParam.getChanScale()) * 0.9d) - triggerParam.getChanOffset();
            if (triggerParam.getLevel() >= verticalOffsetStep + chanScale) {
                triggerParam.saveLevel(-verticalOffsetStep, keyEvent.getRepeatCount());
            } else {
                triggerParam.setLevel((long) chanScale);
                triggerParam.saveLevel(0L, keyEvent.getRepeatCount());
            }
        } else if (chan.value1 >= ServiceEnum.Chan.d0.value1 && chan.value1 <= ServiceEnum.Chan.d15.value1) {
            if (triggerParam.getLevel() >= triggerParam.getLevelAttr().getMinLongValue()) {
                LogUtils.e("step", Long.valueOf(triggerParam.getLevelAttr().getStepValue()));
            }
            triggerParam.saveLevel(-10000000, keyEvent.getRepeatCount());
        }
        triggerParam.releaseCurrentKeyEvent(keyEvent);
    }

    public void abSwitch(KeyEvent keyEvent, View view, PopupSpinner popupSpinner, List<MappingObject> list, SpinnerAdapter spinnerAdapter, AorBManager aorBManager, KeyboardPopupView keyboardPopupView, AorBManager.OnKeyboardItemChangeListener onKeyboardItemChangeListener, AorBManager.OnSpinnerItemChangeListener onSpinnerItemChangeListener) {
        if (aorBManager == null) {
            return;
        }
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        if (panelKey == 234) {
            aorBManager.rollTrigger(keyEvent, true);
        } else if (panelKey != 235) {
            switch (panelKey) {
                case 170:
                    aorBManager.rollB(keyEvent, view, popupSpinner, list, spinnerAdapter, true, keyboardPopupView, onKeyboardItemChangeListener);
                    return;
                case 171:
                    aorBManager.rollB(keyEvent, view, popupSpinner, list, spinnerAdapter, false, keyboardPopupView, onKeyboardItemChangeListener);
                    return;
                case 172:
                    aorBManager.selectB(view, popupSpinner, list, spinnerAdapter, keyboardPopupView, onKeyboardItemChangeListener, onSpinnerItemChangeListener);
                    return;
                default:
                    switch (panelKey) {
                        case 186:
                            aorBManager.rollA(keyEvent, view, popupSpinner, list, spinnerAdapter, true, keyboardPopupView, onKeyboardItemChangeListener);
                            return;
                        case 187:
                            aorBManager.rollA(keyEvent, view, popupSpinner, list, spinnerAdapter, false, keyboardPopupView, onKeyboardItemChangeListener);
                            return;
                        case 188:
                            aorBManager.selectA(view, popupSpinner, list, spinnerAdapter, keyboardPopupView, onKeyboardItemChangeListener, onSpinnerItemChangeListener);
                            return;
                        default:
                            return;
                    }
            }
        } else {
            aorBManager.rollTrigger(keyEvent, false);
        }
    }

    public void abSwitch(KeyEvent keyEvent, View view, PopupSpinner popupSpinner, List<MappingObject> list, SpinnerAdapter spinnerAdapter, AorBManager aorBManager, KeyboardPopupView keyboardPopupView, AorBManager.OnKeyboardItemChangeListener onKeyboardItemChangeListener) {
        LogUtils.e("AB_KEY_ENABLE", true);
        if (aorBManager == null) {
            return;
        }
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        if (panelKey == 234) {
            aorBManager.rollTrigger(keyEvent, true);
        } else if (panelKey != 235) {
            switch (panelKey) {
                case 170:
                    aorBManager.rollB(keyEvent, view, popupSpinner, list, spinnerAdapter, true, keyboardPopupView, onKeyboardItemChangeListener);
                    return;
                case 171:
                    aorBManager.rollB(keyEvent, view, popupSpinner, list, spinnerAdapter, false, keyboardPopupView, onKeyboardItemChangeListener);
                    return;
                case 172:
                    aorBManager.selectB(view, popupSpinner, list, spinnerAdapter, keyboardPopupView, onKeyboardItemChangeListener, null);
                    return;
                default:
                    switch (panelKey) {
                        case 186:
                            aorBManager.rollA(keyEvent, view, popupSpinner, list, spinnerAdapter, true, keyboardPopupView, onKeyboardItemChangeListener);
                            return;
                        case 187:
                            aorBManager.rollA(keyEvent, view, popupSpinner, list, spinnerAdapter, false, keyboardPopupView, onKeyboardItemChangeListener);
                            return;
                        case 188:
                            aorBManager.selectA(view, popupSpinner, list, spinnerAdapter, keyboardPopupView, onKeyboardItemChangeListener, null);
                            return;
                        default:
                            return;
                    }
            }
        } else {
            aorBManager.rollTrigger(keyEvent, false);
        }
    }

    public void setCursor(KeyEvent keyEvent, CursorResultParam cursorResultParam, DisplayParam displayParam, ViewABkeyViewModel viewABkeyViewModel) {
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        switch (panelKey) {
            case 170:
                if (cursorResultParam != null && FunctionManager.getInstance().isEnabled(ServiceEnum.Function.FUN_CURSOR)) {
                    cursorResultParam.saveBPosition(keyEvent.getRepeatCount());
                }
                if (((CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class)).getLiveData().getValue().readMode().value1 == 4) {
                    cursorResultParam.saveBPosition(keyEvent.getRepeatCount());
                    return;
                }
                return;
            case 171:
                if (cursorResultParam != null && FunctionManager.getInstance().isEnabled(ServiceEnum.Function.FUN_CURSOR)) {
                    cursorResultParam.saveBPosition(-keyEvent.getRepeatCount());
                }
                if (((CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class)).getLiveData().getValue().readMode().value1 == 4) {
                    cursorResultParam.saveBPosition(-keyEvent.getRepeatCount());
                    return;
                }
                return;
            case 172:
                if (FunctionManager.getInstance().isEnabled(ServiceEnum.Function.FUN_CURSOR) || ((CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class)).getLiveData().getValue().readMode().value1 == 4) {
                    if (cursorResultParam.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                        cursorResultParam.setView(ServiceEnum.CursorView.cursor_view_vert);
                        cursorResultParam.saveBPosition(0);
                        viewABkeyViewModel.getBx_boolean().setValue(false);
                        viewABkeyViewModel.getBy_boolean().setValue(true);
                    } else {
                        cursorResultParam.saveBPosition(0);
                        cursorResultParam.setView(ServiceEnum.CursorView.cursor_view_hori);
                        viewABkeyViewModel.getBx_boolean().setValue(true);
                        viewABkeyViewModel.getBy_boolean().setValue(false);
                    }
                }
                PopupViewManager.getInstance().setCursorChangeLight(cursorResultParam, viewABkeyViewModel);
                return;
            default:
                switch (panelKey) {
                    case 186:
                        if (FunctionManager.getInstance().isEnabled(ServiceEnum.Function.FUN_CURSOR) || ((CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class)).getLiveData().getValue().readMode().value1 == 4) {
                            if (cursorResultParam != null) {
                                cursorResultParam.saveAPosition(keyEvent.getRepeatCount());
                                return;
                            }
                            return;
                        }
                        if (displayParam.readWaveIntensity() + 1 < 100) {
                            displayParam.saveWaveIntensity(displayParam.readWaveIntensity() + 1);
                            MessageBus.getInstance().onSyncData(MessageBus.getKey(26, MessageID.MSG_DISPLAY_WAVE_INTENSITY), Integer.valueOf(displayParam.readWaveIntensity() + 1));
                        }
                        if (PopupViewManager.getInstance().isShowing(WaveIntensityPopupView.class)) {
                            return;
                        }
                        PopupViewManager.getInstance().toggle(WaveIntensityPopupView.class);
                        return;
                    case 187:
                        if (FunctionManager.getInstance().isEnabled(ServiceEnum.Function.FUN_CURSOR) || ((CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class)).getLiveData().getValue().readMode().value1 == 4) {
                            if (cursorResultParam != null) {
                                cursorResultParam.saveAPosition(-keyEvent.getRepeatCount());
                                return;
                            }
                            return;
                        }
                        if (displayParam.readWaveIntensity() - 1 > 0) {
                            displayParam.saveWaveIntensity(displayParam.readWaveIntensity() - 1);
                            MessageBus.getInstance().onSyncData(MessageBus.getKey(26, MessageID.MSG_DISPLAY_WAVE_INTENSITY), Integer.valueOf(displayParam.readWaveIntensity() - 1));
                        }
                        if (PopupViewManager.getInstance().isShowing(WaveIntensityPopupView.class)) {
                            return;
                        }
                        PopupViewManager.getInstance().toggle(WaveIntensityPopupView.class);
                        return;
                    case 188:
                        if (API.getInstance().UI_QueryInt32(10, MessageID.MSG_ACQ_MODE) == ServiceEnum.AcquireMode.Acquire_Ultra.value1) {
                            ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                        } else if (FunctionManager.getInstance().isEnabled(ServiceEnum.Function.FUN_CURSOR) || ((CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class)).getLiveData().getValue().readMode().value1 == 4) {
                            if (cursorResultParam.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                                cursorResultParam.saveAPosition(0);
                                cursorResultParam.setView(ServiceEnum.CursorView.cursor_view_vert);
                                ViewUtil.getViewABkeyViewModel().getAy_boolean().setValue(true);
                                ViewUtil.getViewABkeyViewModel().getAx_boolean().setValue(false);
                            } else {
                                cursorResultParam.saveAPosition(0);
                                ViewUtil.getViewABkeyViewModel().getAx_boolean().setValue(true);
                                ViewUtil.getViewABkeyViewModel().getAy_boolean().setValue(false);
                                cursorResultParam.setView(ServiceEnum.CursorView.cursor_view_hori);
                            }
                        }
                        PopupViewManager.getInstance().setCursorChangeLight(cursorResultParam, viewABkeyViewModel);
                        return;
                    default:
                        return;
                }
        }
    }

    public void handleFlexKnob(KeyEvent keyEvent, FlexKnobParam flexKnobParam, CursorResultParam cursorResultParam, List<MathParam> list, DisplayParam displayParam, RefParam refParam, List<DecodeParam> list2, ViewABkeyViewModel viewABkeyViewModel, BodeParam bodeParam) {
        if (PopupViewManager.getInstance().isShowing(FlexKnobPopupView.class)) {
            ((FlexKnobPopupView) PopupViewManager.getInstance().get(FlexKnobPopupView.class)).dismiss();
        }
        manualDirection(keyEvent, cursorResultParam, list, displayParam, refParam, list2, viewABkeyViewModel, bodeParam);
    }

    public void manualDirection(KeyEvent keyEvent, CursorResultParam cursorResultParam, List<MathParam> list, DisplayParam displayParam, RefParam refParam, List<DecodeParam> list2, ViewABkeyViewModel viewABkeyViewModel, BodeParam bodeParam) {
        switch (AnonymousClass2.$SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[FunctionManager.getInstance().getCurrentFlexKnobEnum().ordinal()]) {
            case 1:
                rollCursor(keyEvent, cursorResultParam, viewABkeyViewModel);
                return;
            case 2:
                rollMath(keyEvent, list.get(0));
                return;
            case 3:
                rollMath(keyEvent, list.get(1));
                return;
            case 4:
                rollMath(keyEvent, list.get(2));
                return;
            case 5:
                rollMath(keyEvent, list.get(3));
                return;
            case 6:
                rollRef(keyEvent, refParam.getParamByValue(0));
                return;
            case 7:
                rollRef(keyEvent, refParam.getParamByValue(1));
                return;
            case 8:
                rollRef(keyEvent, refParam.getParamByValue(2));
                return;
            case 9:
                rollRef(keyEvent, refParam.getParamByValue(3));
                return;
            case 10:
                rollRef(keyEvent, refParam.getParamByValue(4));
                return;
            case 11:
                rollRef(keyEvent, refParam.getParamByValue(5));
                return;
            case 12:
                rollRef(keyEvent, refParam.getParamByValue(6));
                return;
            case 13:
                rollRef(keyEvent, refParam.getParamByValue(7));
                return;
            case 14:
                rollRef(keyEvent, refParam.getParamByValue(8));
                return;
            case 15:
                rollRef(keyEvent, refParam.getParamByValue(9));
                return;
            case 16:
                rollDecoder(keyEvent, list2.get(0));
                return;
            case 17:
                rollDecoder(keyEvent, list2.get(1));
                return;
            case 18:
                rollDecoder(keyEvent, list2.get(2));
                return;
            case 19:
                rollDecoder(keyEvent, list2.get(3));
                return;
            case 20:
                rollIntensity(keyEvent, displayParam, bodeParam);
                return;
            default:
                return;
        }
    }

    public void autoDirection(KeyEvent keyEvent, CursorResultParam cursorResultParam, List<MathParam> list, DisplayParam displayParam, RefParam refParam, List<DecodeParam> list2, ViewABkeyViewModel viewABkeyViewModel, ServiceEnum.FlexKnobEnum flexKnobEnum) {
        switch (AnonymousClass2.$SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[flexKnobEnum.ordinal()]) {
            case 1:
                if (FunctionManager.getInstance().isEnabled(ServiceEnum.Function.FUN_CURSOR)) {
                    rollCursor(keyEvent, cursorResultParam, viewABkeyViewModel);
                    return;
                }
                return;
            case 2:
                rollMath(keyEvent, list.get(0));
                return;
            case 3:
                rollMath(keyEvent, list.get(1));
                return;
            case 4:
                rollMath(keyEvent, list.get(2));
                return;
            case 5:
                rollMath(keyEvent, list.get(3));
                return;
            case 6:
                rollRef(keyEvent, refParam.getParamByValue(0));
                return;
            case 7:
                rollRef(keyEvent, refParam.getParamByValue(1));
                return;
            case 8:
                rollRef(keyEvent, refParam.getParamByValue(2));
                return;
            case 9:
                rollRef(keyEvent, refParam.getParamByValue(3));
                return;
            case 10:
                rollRef(keyEvent, refParam.getParamByValue(4));
                return;
            case 11:
                rollRef(keyEvent, refParam.getParamByValue(5));
                return;
            case 12:
                rollRef(keyEvent, refParam.getParamByValue(6));
                return;
            case 13:
                rollRef(keyEvent, refParam.getParamByValue(7));
                return;
            case 14:
                rollRef(keyEvent, refParam.getParamByValue(8));
                return;
            case 15:
                rollRef(keyEvent, refParam.getParamByValue(9));
                return;
            case 16:
                rollDecoder(keyEvent, list2.get(0));
                return;
            case 17:
                rollDecoder(keyEvent, list2.get(1));
                return;
            case 18:
                rollDecoder(keyEvent, list2.get(2));
                return;
            case 19:
                rollDecoder(keyEvent, list2.get(3));
                return;
            default:
                return;
        }
    }

    public void rollMath(KeyEvent keyEvent, MathParam mathParam) {
        ServiceEnum.MathOperator operator = mathParam.getOperator();
        if (operator == null) {
            return;
        }
        if (operator == ServiceEnum.MathOperator.operator_add || operator == ServiceEnum.MathOperator.operator_sub || operator == ServiceEnum.MathOperator.operator_mul || operator == ServiceEnum.MathOperator.operator_div) {
            mathArithmetic(keyEvent, mathParam);
        } else if (operator == ServiceEnum.MathOperator.operator_fft) {
            mathFFT(keyEvent, mathParam);
        } else if (operator == ServiceEnum.MathOperator.operator_and || operator == ServiceEnum.MathOperator.operator_or || operator == ServiceEnum.MathOperator.operator_xor || operator == ServiceEnum.MathOperator.operator_not) {
            mathLogic(keyEvent, mathParam);
        } else if (operator == ServiceEnum.MathOperator.operator_intg || operator == ServiceEnum.MathOperator.operator_diff || operator == ServiceEnum.MathOperator.operator_root || operator == ServiceEnum.MathOperator.operator_lg || operator == ServiceEnum.MathOperator.operator_ln || operator == ServiceEnum.MathOperator.operator_exp || operator == ServiceEnum.MathOperator.operator_abs || operator == ServiceEnum.MathOperator.operator_ax_b) {
            mathFun(keyEvent, mathParam);
        } else if (operator == ServiceEnum.MathOperator.operator_lp || operator == ServiceEnum.MathOperator.operator_hp || operator == ServiceEnum.MathOperator.operator_bp || operator == ServiceEnum.MathOperator.operator_bt) {
            mathFilter(keyEvent, mathParam);
        }
    }

    public void mathArithmetic(KeyEvent keyEvent, MathParam mathParam) {
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        switch (panelKey) {
            case 170:
                mathParam.offsetRoll(true);
                return;
            case 171:
                mathParam.offsetRoll(false);
                return;
            case 172:
                mathParam.offsetReset();
                return;
            default:
                switch (panelKey) {
                    case 186:
                        mathParam.scaleRoll(true);
                        return;
                    case 187:
                        mathParam.scaleRoll(false);
                        return;
                    case 188:
                        mathParam.scaleReset();
                        return;
                    default:
                        return;
                }
        }
    }

    public void mathFFT(KeyEvent keyEvent, MathParam mathParam) {
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        switch (panelKey) {
            case 170:
                mathParam.fftSpanRoll(keyEvent, true);
                return;
            case 171:
                mathParam.fftSpanRoll(keyEvent, false);
                return;
            case 172:
                mathParam.fftSpanReset();
                return;
            default:
                switch (panelKey) {
                    case 186:
                        mathParam.fftCenterRoll(keyEvent, true);
                        return;
                    case 187:
                        mathParam.fftCenterRoll(keyEvent, false);
                        return;
                    case 188:
                        mathParam.fftCenterReset();
                        return;
                    default:
                        return;
                }
        }
    }

    public void mathLogic(KeyEvent keyEvent, MathParam mathParam) {
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        switch (panelKey) {
            case 170:
                mathParam.logicOffsetRoll(keyEvent, true);
                return;
            case 171:
                mathParam.logicOffsetRoll(keyEvent, false);
                return;
            case 172:
                mathParam.logicOffsetReset();
                return;
            default:
                switch (panelKey) {
                    case 186:
                        mathParam.logicScaleRoll(keyEvent, true);
                        return;
                    case 187:
                        mathParam.logicScaleRoll(keyEvent, false);
                        return;
                    case 188:
                        mathParam.logicScaleReset();
                        return;
                    default:
                        return;
                }
        }
    }

    public void mathFun(KeyEvent keyEvent, MathParam mathParam) {
        mathArithmetic(keyEvent, mathParam);
    }

    public void mathFilter(KeyEvent keyEvent, MathParam mathParam) {
        mathArithmetic(keyEvent, mathParam);
    }

    private void rollRef(KeyEvent keyEvent, RefParam.Param param) {
        if (param == null) {
            return;
        }
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        switch (panelKey) {
            case 170:
                param.offsetUp();
                return;
            case 171:
                param.offsetDown();
                return;
            case 172:
                param.saveVerOffset(param.getLongDef(param.getVerOffsetAttr()));
                return;
            default:
                switch (panelKey) {
                    case 186:
                        param.scaleDown();
                        return;
                    case 187:
                        param.scaleUp();
                        return;
                    case 188:
                        param.saveVerScale(param.getLongDef(param.getVerScaleAttr()));
                        return;
                    default:
                        return;
                }
        }
    }

    private void rollDecoder(KeyEvent keyEvent, DecodeParam decodeParam) {
        ServiceEnum.DecodeBusType type = decodeParam.getType();
        if (type == null) {
            return;
        }
        MessageAttr messageAttr = new MessageAttr();
        messageAttr.setMinValue(-250);
        messageAttr.setMaxValue(250);
        messageAttr.setDefValue(0);
        messageAttr.setStepValue(1L);
        switch (AnonymousClass2.$SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[type.ordinal()]) {
            case 1:
                decoderParallel(keyEvent, decodeParam, messageAttr);
                return;
            case 2:
                decoderRs232(keyEvent, decodeParam, messageAttr);
                return;
            case 3:
                decoderI2C(keyEvent, decodeParam, messageAttr);
                return;
            case 4:
                decoderSPI(keyEvent, decodeParam, messageAttr);
                return;
            case 5:
                decoderLIN(keyEvent, decodeParam, messageAttr);
                return;
            case 6:
                decoderCAN(keyEvent, decodeParam, messageAttr);
                return;
            case 7:
                decoderFlexRay(keyEvent, decodeParam, messageAttr);
                return;
            case 8:
                decoderI2S(keyEvent, decodeParam, messageAttr);
                return;
            case 9:
                decoder1553B(keyEvent, decodeParam, messageAttr);
                return;
            default:
                return;
        }
    }

    /* renamed from: com.rigol.scope.viewmodels.PanelKeyViewModel$2 */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType;
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum;

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
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_I2C.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_SPI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_LIN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_CAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_FlexRay.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_I2S.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_1553B.ordinal()] = 9;
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
            int[] iArr2 = new int[ServiceEnum.FlexKnobEnum.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum = iArr2;
            try {
                iArr2[ServiceEnum.FlexKnobEnum.Cursor.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Math1.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Math2.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Math3.ordinal()] = 4;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Math4.ordinal()] = 5;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref1.ordinal()] = 6;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref2.ordinal()] = 7;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref3.ordinal()] = 8;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref4.ordinal()] = 9;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref5.ordinal()] = 10;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref6.ordinal()] = 11;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref7.ordinal()] = 12;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref8.ordinal()] = 13;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref9.ordinal()] = 14;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref10.ordinal()] = 15;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Decoder1.ordinal()] = 16;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Decoder2.ordinal()] = 17;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Decoder3.ordinal()] = 18;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Decoder4.ordinal()] = 19;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Intensity.ordinal()] = 20;
            } catch (NoSuchFieldError unused33) {
            }
        }
    }

    private void decoderParallel(KeyEvent keyEvent, DecodeParam decodeParam, MessageAttr messageAttr) {
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        switch (panelKey) {
            case 170:
                decodeParam.setPosition(decodeParam.getIntStep(decodeParam.getPosition(), messageAttr, true, keyEvent));
                return;
            case 171:
                decodeParam.setPosition(decodeParam.getIntStep(decodeParam.getPosition(), messageAttr, false, keyEvent));
                return;
            case 172:
                decodeParam.setPosition(decodeParam.getIntDef(messageAttr));
                return;
            default:
                switch (panelKey) {
                    case 186:
                        decodeParam.savePal_dat_thres(decodeParam.getLongStep(decodeParam.getPal_dat_thres(), decodeParam.getPalBusThresAttr(), true, keyEvent));
                        return;
                    case 187:
                        decodeParam.savePal_dat_thres(decodeParam.getLongStep(decodeParam.getPal_dat_thres(), decodeParam.getPalBusThresAttr(), false, keyEvent));
                        return;
                    case 188:
                        decodeParam.savePal_clk_thres(decodeParam.getLongDef(decodeParam.getPalClkThresAttr()));
                        return;
                    default:
                        return;
                }
        }
    }

    private void decoderRs232(KeyEvent keyEvent, DecodeParam decodeParam, MessageAttr messageAttr) {
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        switch (panelKey) {
            case 170:
                decodeParam.setPosition(decodeParam.getIntStep(decodeParam.getPosition(), messageAttr, true, keyEvent));
                return;
            case 171:
                decodeParam.setPosition(decodeParam.getIntStep(decodeParam.getPosition(), messageAttr, false, keyEvent));
                return;
            case 172:
                decodeParam.setPosition(decodeParam.getIntDef(messageAttr));
                return;
            default:
                switch (panelKey) {
                    case 186:
                        decodeParam.saveRs232_tx_thres(decodeParam.getLongStep(decodeParam.getRs232_tx_thres(), decodeParam.getTxThresAttr(), true, keyEvent));
                        return;
                    case 187:
                        decodeParam.saveRs232_tx_thres(decodeParam.getLongStep(decodeParam.getRs232_tx_thres(), decodeParam.getTxThresAttr(), false, keyEvent));
                        return;
                    case 188:
                        decodeParam.saveRs232_tx_thres(decodeParam.getIntDef(decodeParam.getTxThresAttr()));
                        return;
                    default:
                        return;
                }
        }
    }

    private void decoderI2C(KeyEvent keyEvent, DecodeParam decodeParam, MessageAttr messageAttr) {
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        switch (panelKey) {
            case 170:
                decodeParam.setPosition(decodeParam.getIntStep(decodeParam.getPosition(), messageAttr, true, keyEvent));
                return;
            case 171:
                decodeParam.setPosition(decodeParam.getIntStep(decodeParam.getPosition(), messageAttr, false, keyEvent));
                return;
            case 172:
                decodeParam.setPosition(decodeParam.getIntDef(messageAttr));
                return;
            default:
                switch (panelKey) {
                    case 186:
                        decodeParam.saveI2c_scl_thres(decodeParam.getLongStep(decodeParam.getI2c_scl_thres(), decodeParam.getI2cClkThresAttr(), true, keyEvent));
                        return;
                    case 187:
                        decodeParam.saveI2c_scl_thres(decodeParam.getLongStep(decodeParam.getI2c_scl_thres(), decodeParam.getI2cClkThresAttr(), false, keyEvent));
                        return;
                    case 188:
                        decodeParam.saveI2c_scl_thres(decodeParam.getLongDef(decodeParam.getI2cClkThresAttr()));
                        return;
                    default:
                        return;
                }
        }
    }

    private void decoderSPI(KeyEvent keyEvent, DecodeParam decodeParam, MessageAttr messageAttr) {
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        switch (panelKey) {
            case 170:
                decodeParam.setPosition(decodeParam.getIntStep(decodeParam.getPosition(), messageAttr, true, keyEvent));
                return;
            case 171:
                decodeParam.setPosition(decodeParam.getIntStep(decodeParam.getPosition(), messageAttr, false, keyEvent));
                return;
            case 172:
                decodeParam.setPosition(decodeParam.getIntDef(messageAttr));
                return;
            default:
                switch (panelKey) {
                    case 186:
                        API.getInstance().UI_QueryInt64(decodeParam.getServiceId(), MessageID.MSG_DECODE_CLK_THRE);
                        decodeParam.readSpiClkThresAttr();
                        decodeParam.saveSpi_clock_thres(decodeParam.getLongStep(decodeParam.getSpi_clock_thres(), decodeParam.getSpiClkThresAttr(), true, keyEvent));
                        return;
                    case 187:
                        API.getInstance().UI_QueryInt64(decodeParam.getServiceId(), MessageID.MSG_DECODE_CLK_THRE);
                        decodeParam.readSpiClkThresAttr();
                        decodeParam.saveSpi_clock_thres(decodeParam.getLongStep(decodeParam.getSpi_clock_thres(), decodeParam.getSpiClkThresAttr(), false, keyEvent));
                        return;
                    case 188:
                        decodeParam.saveSpi_clock_thres(decodeParam.getLongDef(decodeParam.getSpiClkThresAttr()));
                        return;
                    default:
                        return;
                }
        }
    }

    private void decoderLIN(KeyEvent keyEvent, DecodeParam decodeParam, MessageAttr messageAttr) {
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        switch (panelKey) {
            case 170:
                decodeParam.setPosition(decodeParam.getIntStep(decodeParam.getPosition(), messageAttr, true, keyEvent));
                return;
            case 171:
                decodeParam.setPosition(decodeParam.getIntStep(decodeParam.getPosition(), messageAttr, false, keyEvent));
                return;
            case 172:
                decodeParam.setPosition(decodeParam.getIntDef(messageAttr));
                return;
            default:
                switch (panelKey) {
                    case 186:
                        decodeParam.saveLin_thres(decodeParam.getLongStep(decodeParam.getLin_thres(), decodeParam.getLinThresAttr(), true, keyEvent));
                        return;
                    case 187:
                        decodeParam.saveLin_thres(decodeParam.getLongStep(decodeParam.getLin_thres(), decodeParam.getLinThresAttr(), false, keyEvent));
                        return;
                    case 188:
                        decodeParam.saveLin_thres(decodeParam.getLongDef(decodeParam.getLinThresAttr()));
                        return;
                    default:
                        return;
                }
        }
    }

    private void decoderCAN(KeyEvent keyEvent, DecodeParam decodeParam, MessageAttr messageAttr) {
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        switch (panelKey) {
            case 170:
                decodeParam.setPosition(decodeParam.getIntStep(decodeParam.getPosition(), messageAttr, true, keyEvent));
                return;
            case 171:
                decodeParam.setPosition(decodeParam.getIntStep(decodeParam.getPosition(), messageAttr, false, keyEvent));
                return;
            case 172:
                decodeParam.setPosition(decodeParam.getIntDef(messageAttr));
                return;
            default:
                switch (panelKey) {
                    case 186:
                        decodeParam.saveCan_threas(decodeParam.getLongStep(decodeParam.getCan_threas(), decodeParam.getCanThresAttr(), true, keyEvent));
                        return;
                    case 187:
                        decodeParam.saveCan_threas(decodeParam.getLongStep(decodeParam.getCan_threas(), decodeParam.getCanThresAttr(), false, keyEvent));
                        return;
                    case 188:
                        decodeParam.saveCan_threas(decodeParam.getLongDef(decodeParam.getCanThresAttr()));
                        return;
                    default:
                        return;
                }
        }
    }

    private void decoderFlexRay(KeyEvent keyEvent, DecodeParam decodeParam, MessageAttr messageAttr) {
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        switch (panelKey) {
            case 170:
                decodeParam.setPosition(decodeParam.getIntStep(decodeParam.getPosition(), messageAttr, true, keyEvent));
                return;
            case 171:
                decodeParam.setPosition(decodeParam.getIntStep(decodeParam.getPosition(), messageAttr, false, keyEvent));
                return;
            case 172:
                decodeParam.setPosition(decodeParam.getIntDef(messageAttr));
                return;
            default:
                switch (panelKey) {
                    case 186:
                        decodeParam.saveFlex_thres(decodeParam.getLongStep(decodeParam.getFlex_thres(), decodeParam.getFlexThresAttr(), true, keyEvent));
                        return;
                    case 187:
                        decodeParam.saveFlex_thres(decodeParam.getLongStep(decodeParam.getFlex_thres(), decodeParam.getFlexThresAttr(), false, keyEvent));
                        return;
                    case 188:
                        decodeParam.saveFlex_thres(decodeParam.getLongDef(decodeParam.getFlexThresAttr()));
                        return;
                    default:
                        return;
                }
        }
    }

    private void decoderI2S(KeyEvent keyEvent, DecodeParam decodeParam, MessageAttr messageAttr) {
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        switch (panelKey) {
            case 170:
                decodeParam.setPosition(decodeParam.getIntStep(decodeParam.getPosition(), messageAttr, true, keyEvent));
                return;
            case 171:
                decodeParam.setPosition(decodeParam.getIntStep(decodeParam.getPosition(), messageAttr, false, keyEvent));
                return;
            case 172:
                decodeParam.setPosition(decodeParam.getIntDef(messageAttr));
                return;
            default:
                switch (panelKey) {
                    case 186:
                        decodeParam.saveI2s_sclock_thres(decodeParam.getLongStep(decodeParam.getI2s_sclock(), decodeParam.getI2sSclkThresAttr(), true, keyEvent));
                        return;
                    case 187:
                        decodeParam.saveI2s_sclock_thres(decodeParam.getLongStep(decodeParam.getI2s_sclock(), decodeParam.getI2sSclkThresAttr(), false, keyEvent));
                        return;
                    case 188:
                        decodeParam.saveI2s_sclock_thres(decodeParam.getLongDef(decodeParam.getI2sSclkThresAttr()));
                        return;
                    default:
                        return;
                }
        }
    }

    private void decoder1553B(KeyEvent keyEvent, DecodeParam decodeParam, MessageAttr messageAttr) {
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        switch (panelKey) {
            case 170:
                decodeParam.setPosition(decodeParam.getIntStep(decodeParam.getPosition(), messageAttr, true, keyEvent));
                return;
            case 171:
                decodeParam.setPosition(decodeParam.getIntStep(decodeParam.getPosition(), messageAttr, false, keyEvent));
                return;
            case 172:
                decodeParam.setPosition(decodeParam.getIntDef(messageAttr));
                return;
            default:
                switch (panelKey) {
                    case 186:
                        decodeParam.save_1553b_thres1(decodeParam.getLongStep(decodeParam.get_1553b_thres1(), decodeParam.getPalBusThresAttr(), true, keyEvent));
                        return;
                    case 187:
                        decodeParam.save_1553b_thres1(decodeParam.getLongStep(decodeParam.get_1553b_thres1(), decodeParam.getPalBusThresAttr(), false, keyEvent));
                        return;
                    case 188:
                        decodeParam.save_1553b_thres1(decodeParam.getLongDef(decodeParam.getPalBusThresAttr()));
                        return;
                    default:
                        return;
                }
        }
    }

    public void rollIntensity(KeyEvent keyEvent, DisplayParam displayParam, BodeParam bodeParam) {
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        switch (panelKey) {
            case 170:
            case 171:
            case 172:
                ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                return;
            default:
                switch (panelKey) {
                    case 186:
                        if (bodeParam.getBodeEnable() && bodeParam.getBode_resultDatalist().size() > 0 && bodeParam.getBodeCursorPosition() <= bodeParam.getPosition_listx().size() - 1) {
                            bodeParam.setBodeCursorPosition(bodeParam.getBodeCursorPosition() + 1);
                            MessageBus.getInstance().onSyncData(MessageBus.getKey(61, MessageID.MSG_BODE_SOURCE_OUT), 50);
                            return;
                        } else if (displayParam.getPaletteEnable()) {
                            ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                            return;
                        } else {
                            if (displayParam.readWaveIntensity() + keyEvent.getRepeatCount() <= 100) {
                                displayParam.saveWaveIntensity(displayParam.readWaveIntensity() + keyEvent.getRepeatCount());
                                MessageBus.getInstance().onSyncData(MessageBus.getKey(26, MessageID.MSG_DISPLAY_WAVE_INTENSITY), Integer.valueOf(displayParam.readWaveIntensity() + keyEvent.getRepeatCount()));
                            }
                            if (PopupViewManager.getInstance().isShowing(WaveIntensityPopupView.class)) {
                                return;
                            }
                            PopupViewManager.getInstance().toggle(WaveIntensityPopupView.class);
                            return;
                        }
                    case 187:
                        if (bodeParam.getBodeEnable() && bodeParam.getBode_resultDatalist().size() > 0 && bodeParam.getBodeCursorPosition() <= bodeParam.getPosition_listx().size() - 1) {
                            bodeParam.setBodeCursorPosition(bodeParam.getBodeCursorPosition() - 1);
                            MessageBus.getInstance().onSyncData(MessageBus.getKey(61, MessageID.MSG_BODE_SOURCE_OUT), 50);
                            return;
                        } else if (displayParam.getPaletteEnable()) {
                            ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                            return;
                        } else {
                            if (displayParam.readWaveIntensity() - keyEvent.getRepeatCount() >= 0) {
                                displayParam.saveWaveIntensity(displayParam.readWaveIntensity() - keyEvent.getRepeatCount());
                                MessageBus.getInstance().onSyncData(MessageBus.getKey(26, MessageID.MSG_DISPLAY_WAVE_INTENSITY), Integer.valueOf(displayParam.readWaveIntensity() - keyEvent.getRepeatCount()));
                            }
                            if (PopupViewManager.getInstance().isShowing(WaveIntensityPopupView.class)) {
                                return;
                            }
                            PopupViewManager.getInstance().toggle(WaveIntensityPopupView.class);
                            return;
                        }
                    case 188:
                        if (!PopupViewManager.getInstance().isShowing(WaveIntensityPopupView.class) || displayParam.getPaletteEnable()) {
                            ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                            return;
                        }
                        MessageBus.getInstance().onSyncData(MessageBus.getKey(26, MessageID.MSG_DISPLAY_WAVE_INTENSITY), 50);
                        displayParam.saveWaveIntensity(50);
                        return;
                    default:
                        return;
                }
        }
    }

    public void rollCursor(KeyEvent keyEvent, CursorResultParam cursorResultParam, ViewABkeyViewModel viewABkeyViewModel) {
        if ((KeyCodeUtil.getPanelKey(keyEvent.getKeyCode()) == 186 || KeyCodeUtil.getPanelKey(keyEvent.getKeyCode()) == 187 || KeyCodeUtil.getPanelKey(keyEvent.getKeyCode()) == 188 || KeyCodeUtil.getPanelKey(keyEvent.getKeyCode()) == 170 || KeyCodeUtil.getPanelKey(keyEvent.getKeyCode()) == 171 || KeyCodeUtil.getPanelKey(keyEvent.getKeyCode()) == 172) && cursorResultParam != null) {
            boolean z = FunctionManager.getInstance().isEnabled(ServiceEnum.Function.FUN_CURSOR) || cursorResultParam.readMode() == ServiceEnum.CursorMode.cursor_mode_xy;
            int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
            switch (panelKey) {
                case 170:
                    if (z) {
                        cursorResultParam.saveBPosition(keyEvent.getRepeatCount());
                        cursorResultParam.saveBothAB(cursorResultParam.isBothAB());
                        return;
                    }
                    return;
                case 171:
                    if (z) {
                        cursorResultParam.saveBPosition(-keyEvent.getRepeatCount());
                        cursorResultParam.saveBothAB(cursorResultParam.isBothAB());
                        return;
                    }
                    return;
                case 172:
                    if (z && cursorResultParam.readMode() != ServiceEnum.CursorMode.cursor_mode_track) {
                        cursorResultParam.saveBPosition(0);
                        cursorResultParam.saveBothAB(cursorResultParam.isBothAB());
                        if (cursorResultParam.getCursorLineBMode() == ServiceEnum.CursorView.cursor_view_hori) {
                            cursorResultParam.setCursorLineBMode(ServiceEnum.CursorView.cursor_view_vert);
                            viewABkeyViewModel.getBx_boolean().setValue(false);
                            viewABkeyViewModel.getBy_boolean().setValue(true);
                        } else {
                            cursorResultParam.setCursorLineBMode(ServiceEnum.CursorView.cursor_view_hori);
                            viewABkeyViewModel.getBx_boolean().setValue(true);
                            viewABkeyViewModel.getBy_boolean().setValue(false);
                        }
                    }
                    PopupViewManager.getInstance().setCursorChangeLight(cursorResultParam, viewABkeyViewModel);
                    return;
                default:
                    switch (panelKey) {
                        case 186:
                            if (z) {
                                cursorResultParam.saveAPosition(keyEvent.getRepeatCount());
                                cursorResultParam.saveBothAB(cursorResultParam.isBothAB());
                                return;
                            }
                            return;
                        case 187:
                            if (z) {
                                cursorResultParam.saveAPosition(-keyEvent.getRepeatCount());
                                cursorResultParam.saveBothAB(cursorResultParam.isBothAB());
                                return;
                            }
                            return;
                        case 188:
                            if (z && cursorResultParam.readMode() != ServiceEnum.CursorMode.cursor_mode_track) {
                                cursorResultParam.saveAPosition(0);
                                cursorResultParam.saveBothAB(cursorResultParam.isBothAB());
                                if (cursorResultParam.getCursorLineAMode() == ServiceEnum.CursorView.cursor_view_hori) {
                                    cursorResultParam.setCursorLineAMode(ServiceEnum.CursorView.cursor_view_vert);
                                    viewABkeyViewModel.getAy_boolean().setValue(true);
                                    viewABkeyViewModel.getAx_boolean().setValue(false);
                                } else {
                                    cursorResultParam.setCursorLineAMode(ServiceEnum.CursorView.cursor_view_hori);
                                    viewABkeyViewModel.getAx_boolean().setValue(true);
                                    viewABkeyViewModel.getAy_boolean().setValue(false);
                                }
                            }
                            PopupViewManager.getInstance().setCursorChangeLight(cursorResultParam, viewABkeyViewModel);
                            return;
                        default:
                            return;
                    }
            }
        }
    }
}
