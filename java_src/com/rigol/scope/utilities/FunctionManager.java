package com.rigol.scope.utilities;

import android.app.Activity;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.CounterResultParam;
import com.rigol.scope.data.CursorResultParam;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.DvmResultParam;
import com.rigol.scope.data.FftParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MaskParam;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.NavigateParam;
import com.rigol.scope.data.RefParam;
import com.rigol.scope.data.SearchParam;
import com.rigol.scope.data.TwoTuple;
import com.rigol.scope.data.UpaParam;
import com.rigol.scope.data.WaveRecordParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.data.XYParam;
import com.rigol.scope.viewmodels.BodeViewModel;
import com.rigol.scope.viewmodels.CounterViewModel;
import com.rigol.scope.viewmodels.CursorViewModel;
import com.rigol.scope.viewmodels.DecodeViewModel;
import com.rigol.scope.viewmodels.DvmViewModel;
import com.rigol.scope.viewmodels.FftViewModel;
import com.rigol.scope.viewmodels.HistogramViewModel;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.MaskViewModel;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.viewmodels.NavigateViewModel;
import com.rigol.scope.viewmodels.RefViewModel;
import com.rigol.scope.viewmodels.SearchViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.UpaViewModel;
import com.rigol.scope.viewmodels.WaveRecordViewModel;
import com.rigol.scope.viewmodels.XYViewModel;
import com.rigol.scope.views.UpdatePopupView;
import com.rigol.scope.views.UtilityPopupView;
import com.rigol.scope.views.alert.DefaultPopupView;
import com.rigol.scope.views.alert.RebootPopupView;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.bode.BodePopupWin;
import com.rigol.scope.views.busAnalyse.BusAnalysePopupView;
import com.rigol.scope.views.decode.DecodeNewPopupView;
import com.rigol.scope.views.display.DisplayPopupView;
import com.rigol.scope.views.eye.EyePopupView;
import com.rigol.scope.views.histogram.HistogramResultParam;
import com.rigol.scope.views.histogram.HistogramSettingPopupView;
import com.rigol.scope.views.horizontal.HorizontalPopupView;
import com.rigol.scope.views.jitter.JitterPopupView;
import com.rigol.scope.views.knob.FlexKnobPopupView;
import com.rigol.scope.views.mask.MaskPopupView;
import com.rigol.scope.views.math.MathPopupView;
import com.rigol.scope.views.measure.MeasurePopupView;
import com.rigol.scope.views.multi.MultiWindowPopupView;
import com.rigol.scope.views.navigate.NavigatePopupView;
import com.rigol.scope.views.openSourceLicense.HelpPopuwin;
import com.rigol.scope.views.power.PowerPopupView;
import com.rigol.scope.views.record.RecordPopupView;
import com.rigol.scope.views.ref.RefPopupView;
import com.rigol.scope.views.rtsa.RtsaPopupView;
import com.rigol.scope.views.search.SearchPopupView;
import com.rigol.scope.views.storage.StoragePopupView;
import com.rigol.scope.views.trigger.TriggerPopupView;
import com.rigol.scope.views.upa.UpaPopupview;
import com.rigol.scope.views.wave.WaveIntensityPopupView;
import com.rigol.scope.views.xy.XYPopupView;
import com.rigol.util.ToastUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
/* loaded from: classes2.dex */
public class FunctionManager {
    private static FunctionManager instance;
    public boolean cursorSwitch;
    public boolean decodeSwitch;
    public boolean maskSwitch;
    public boolean recordSwitch;
    public boolean refSwitch;
    public boolean searchSwitch;
    public boolean upaSwitch;
    public boolean xySwitch;
    private ServiceEnum.Function selectedFunction = ServiceEnum.Function.FUN_HORIZONTAL;
    private ServiceEnum.FlexKnobEnum currentFlexKnobEnum = ServiceEnum.FlexKnobEnum.Intensity;

    public static FunctionManager getInstance() {
        if (instance == null) {
            synchronized (FunctionManager.class) {
                if (instance == null) {
                    instance = new FunctionManager();
                }
            }
        }
        return instance;
    }

    private FunctionManager() {
    }

    public void resetArgsAboutUltra() {
        this.cursorSwitch = false;
        this.recordSwitch = false;
        this.refSwitch = false;
        this.maskSwitch = false;
        this.upaSwitch = false;
        this.decodeSwitch = false;
        this.searchSwitch = false;
        this.xySwitch = false;
    }

    public void enable(ServiceEnum.Function function) {
        DvmResultParam value;
        CounterResultParam value2;
        HistogramViewModel histogramViewModel;
        HistogramResultParam value3;
        if (function == null) {
            return;
        }
        int i = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[function.ordinal()];
        if (i == 1) {
            CursorViewModel cursorViewModel = (CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class);
            if (cursorViewModel != null) {
                CursorResultParam value4 = cursorViewModel.getLiveData().getValue();
                if (value4 != null) {
                    value4.saveMode(ServiceEnum.CursorMode.cursor_mode_manual);
                    this.cursorSwitch = true;
                    value4.saveCursorEnable(true);
                }
                setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Cursor);
            }
        } else if (i == 2) {
            DvmViewModel dvmViewModel = (DvmViewModel) ContextUtil.getAppViewModel(DvmViewModel.class);
            if (dvmViewModel == null || (value = dvmViewModel.getLiveData().getValue()) == null) {
                return;
            }
            value.saveEnable(true);
        } else if (i != 3) {
            if (i != 4 || (histogramViewModel = (HistogramViewModel) ContextUtil.getAppViewModel(HistogramViewModel.class)) == null || (value3 = histogramViewModel.getLiveData().getValue()) == null) {
                return;
            }
            value3.saveEnable(true);
        } else {
            CounterViewModel counterViewModel = (CounterViewModel) ContextUtil.getAppViewModel(CounterViewModel.class);
            if (counterViewModel == null || (value2 = counterViewModel.getLiveData().getValue()) == null) {
                return;
            }
            value2.saveEnable(true);
        }
    }

    public void disable(ServiceEnum.Function function) {
        CursorResultParam value;
        DvmResultParam value2;
        CounterResultParam value3;
        HistogramViewModel histogramViewModel;
        HistogramResultParam value4;
        if (function == null) {
            return;
        }
        int i = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[function.ordinal()];
        if (i == 1) {
            CursorViewModel cursorViewModel = (CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class);
            if (cursorViewModel == null || (value = cursorViewModel.getLiveData().getValue()) == null) {
                return;
            }
            value.saveMode(ServiceEnum.CursorMode.cursor_mode_off);
            this.cursorSwitch = false;
            value.saveCursorEnable(false);
            MessageBus.getInstance().onSyncData(21, MessageID.MSG_CURSOR_MODE, false);
        } else if (i == 2) {
            DvmViewModel dvmViewModel = (DvmViewModel) ContextUtil.getAppViewModel(DvmViewModel.class);
            if (dvmViewModel == null || (value2 = dvmViewModel.getLiveData().getValue()) == null) {
                return;
            }
            value2.saveEnable(false);
        } else if (i != 3) {
            if (i != 4 || (histogramViewModel = (HistogramViewModel) ContextUtil.getAppViewModel(HistogramViewModel.class)) == null || (value4 = histogramViewModel.getLiveData().getValue()) == null) {
                return;
            }
            value4.saveEnable(false);
        } else {
            CounterViewModel counterViewModel = (CounterViewModel) ContextUtil.getAppViewModel(CounterViewModel.class);
            if (counterViewModel == null || (value3 = counterViewModel.getLiveData().getValue()) == null) {
                return;
            }
            value3.saveEnable(false);
        }
    }

    public void toggle(ServiceEnum.Function function) {
        if (function == null) {
            return;
        }
        if (isEnabled(function)) {
            disable(function);
        } else {
            enable(function);
        }
    }

    public boolean isEnabled(ServiceEnum.Function function) {
        CursorResultParam value;
        boolean z = false;
        if (function == null) {
            return false;
        }
        int i = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[function.ordinal()];
        if (i == 1) {
            CursorViewModel cursorViewModel = (CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class);
            return (cursorViewModel == null || (value = cursorViewModel.getLiveData().getValue()) == null || value.getCursorMode() == ServiceEnum.CursorMode.cursor_mode_off) ? false : true;
        }
        switch (i) {
            case 5:
                WaveRecordViewModel waveRecordViewModel = (WaveRecordViewModel) ContextUtil.getAppViewModel(WaveRecordViewModel.class);
                if (waveRecordViewModel != null) {
                    waveRecordViewModel.getLiveData();
                    WaveRecordParam value2 = waveRecordViewModel.getLiveData().getValue();
                    if (value2 != null) {
                        return value2.isRecordOnOff();
                    }
                    return false;
                }
                return false;
            case 6:
                MathViewModel mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
                if (mathViewModel != null) {
                    mathViewModel.getLiveData();
                    ArrayList<MathParam> value3 = mathViewModel.getLiveData().getValue();
                    if (value3 != null && value3.size() > 0) {
                        Iterator<MathParam> it = value3.iterator();
                        while (it.hasNext()) {
                            if (it.next().getStatus()) {
                                z = true;
                            }
                        }
                    }
                    return z;
                }
                return false;
            case 7:
                RefViewModel refViewModel = (RefViewModel) ContextUtil.getAppViewModel(RefViewModel.class);
                if (refViewModel != null) {
                    refViewModel.getLiveData();
                    RefParam value4 = refViewModel.getLiveData().getValue();
                    return (value4 == null || value4.getParam() == null || !getInstance().refSwitch) ? false : true;
                }
                return false;
            case 8:
                MaskViewModel maskViewModel = (MaskViewModel) ContextUtil.getAppViewModel(MaskViewModel.class);
                if (maskViewModel != null) {
                    maskViewModel.getLiveData();
                    MaskParam value5 = maskViewModel.getLiveData().getValue();
                    if (value5 != null) {
                        return value5.isEnable();
                    }
                    return false;
                }
                return false;
            case 9:
                UpaViewModel upaViewModel = (UpaViewModel) ContextUtil.getAppViewModel(UpaViewModel.class);
                if (upaViewModel != null) {
                    upaViewModel.getLiveData();
                    UpaParam value6 = upaViewModel.getLiveData().getValue();
                    if (value6 != null) {
                        return value6.getRefPowerDisp();
                    }
                    return false;
                }
                return false;
            case 10:
                DecodeViewModel decodeViewModel = (DecodeViewModel) ContextUtil.getAppViewModel(DecodeViewModel.class);
                if (decodeViewModel != null) {
                    decodeViewModel.getLiveData();
                    ArrayList<DecodeParam> value7 = decodeViewModel.getLiveData().getValue();
                    if (value7 != null && value7.size() > 0) {
                        Iterator<DecodeParam> it2 = value7.iterator();
                        while (it2.hasNext()) {
                            if (it2.next().isOnOff()) {
                                z = true;
                            }
                        }
                    }
                    return z;
                }
                return false;
            case 11:
                SearchViewModel searchViewModel = (SearchViewModel) ContextUtil.getAppViewModel(SearchViewModel.class);
                if (searchViewModel != null) {
                    searchViewModel.getLiveData();
                    SearchParam value8 = searchViewModel.getLiveData().getValue();
                    if (value8 != null) {
                        return value8.isEnable();
                    }
                    return false;
                }
                return false;
            case 12:
                return WindowHolderManager.getInstance().size(ServiceEnum.WindowType.WIN_XY) >= 1;
            default:
                return false;
        }
    }

    public void setUltraEnable(boolean z) {
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        if (horizontalViewModel != null) {
            horizontalViewModel.getLiveData();
            HorizontalParam value = horizontalViewModel.getLiveData().getValue();
            if (value != null) {
                value.setUltraEnable(z);
            }
        }
    }

    public ServiceEnum.Function getSelectedFunction() {
        return this.selectedFunction;
    }

    public void setSelectedFunction(ServiceEnum.Function function) {
        if (function == null) {
            return;
        }
        int i = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[function.ordinal()];
        if (i == 1 || i == 10 || i == 13 || i == 14) {
            this.selectedFunction = function;
        } else {
            this.selectedFunction = ServiceEnum.Function.FUN_HORIZONTAL;
        }
    }

    public ServiceEnum.FlexKnobEnum getCurrentFlexKnobEnum() {
        return this.currentFlexKnobEnum;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.utilities.FunctionManager$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum;

        static {
            int[] iArr = new int[ServiceEnum.FlexKnobEnum.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum = iArr;
            try {
                iArr[ServiceEnum.FlexKnobEnum.Intensity.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Cursor.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Math1.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Math2.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Math3.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Math4.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.LA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.DG1.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.DG2.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref1.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref2.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref3.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref4.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref5.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref6.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref7.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref8.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref9.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref10.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Decoder1.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Decoder2.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Decoder3.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Decoder4.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            int[] iArr2 = new int[ServiceEnum.Function.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function = iArr2;
            try {
                iArr2[ServiceEnum.Function.FUN_CURSOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_DVM.ordinal()] = 2;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_COUNTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_HISTOGRAM.ordinal()] = 4;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_RECORD.ordinal()] = 5;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_MATH.ordinal()] = 6;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_REF.ordinal()] = 7;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_MASK.ordinal()] = 8;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_UPA.ordinal()] = 9;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_DECODE.ordinal()] = 10;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_SEARCH.ordinal()] = 11;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_XY.ordinal()] = 12;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_TRIGGER.ordinal()] = 13;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_WAVE_INTENSITY.ordinal()] = 14;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_AUTO.ordinal()] = 15;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_MEASURE.ordinal()] = 16;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_FLEX_KNOB.ordinal()] = 17;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_RESULT_TABLE.ordinal()] = 18;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_MULTI_WINDOW.ordinal()] = 19;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_FFT.ordinal()] = 20;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_EYE.ordinal()] = 21;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_JITTER.ordinal()] = 22;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_BUS_ANALYSE.ordinal()] = 23;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_ZONE_TRIGGER.ordinal()] = 24;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_DISPLAY.ordinal()] = 25;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_NOTE.ordinal()] = 26;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_QUICK.ordinal()] = 27;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_SHARE.ordinal()] = 28;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_STORAGE.ordinal()] = 29;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_HELP.ordinal()] = 30;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_UPDATE.ordinal()] = 31;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_UTILITY.ordinal()] = 32;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_RESTART.ordinal()] = 33;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_SHUTDOWN.ordinal()] = 34;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_RUN_STOP.ordinal()] = 35;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_DEFAULT.ordinal()] = 36;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_ACQUIRE.ordinal()] = 37;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_HORIZONTAL.ordinal()] = 38;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_SINGLE.ordinal()] = 39;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_FORCE.ordinal()] = 40;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_CLEAR.ordinal()] = 41;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_ZOOM.ordinal()] = 42;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_NAVIGATE.ordinal()] = 43;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_BODE.ordinal()] = 44;
            } catch (NoSuchFieldError unused67) {
            }
        }
    }

    public void setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum flexKnobEnum) {
        if (flexKnobEnum == null) {
            return;
        }
        switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[flexKnobEnum.ordinal()]) {
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
            case 21:
            case 22:
            case 23:
                this.currentFlexKnobEnum = flexKnobEnum;
                return;
            default:
                this.currentFlexKnobEnum = ServiceEnum.FlexKnobEnum.Intensity;
                return;
        }
    }

    public void setFlexKnobEnum(ServiceEnum.Function function, int i, boolean z) {
        if (ViewUtil.getFlexKnobParamViewModel().isAllowSetFlexParam(z) && function != null) {
            int i2 = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[function.ordinal()];
            if (i2 == 6) {
                if (i == 0) {
                    getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Math1);
                } else if (i == 1) {
                    getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Math2);
                } else if (i == 2) {
                    getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Math3);
                } else if (i == 3) {
                    getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Math4);
                }
                updateIconForMessage(getCurrentFlexKnobEnum());
            } else if (i2 != 7) {
                if (i2 != 10) {
                    return;
                }
                if (i == 0) {
                    getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Decoder1);
                } else if (i == 1) {
                    getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Decoder2);
                } else if (i == 2) {
                    getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Decoder3);
                } else if (i == 3) {
                    getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Decoder4);
                }
                getInstance().updateDecodeIconForMessage(i);
            } else {
                if (i == 0) {
                    getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Ref1);
                } else if (i == 1) {
                    getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Ref2);
                } else if (i == 2) {
                    getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Ref3);
                } else if (i == 3) {
                    getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Ref4);
                } else if (i == 4) {
                    getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Ref5);
                } else if (i == 5) {
                    getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Ref6);
                } else if (i == 6) {
                    getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Ref7);
                } else if (i == 7) {
                    getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Ref8);
                } else if (i == 8) {
                    getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Ref9);
                } else if (i == 9) {
                    getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Ref10);
                }
                getInstance().updateRefIconForMessage(i);
            }
        }
    }

    public void updateIconForMessage(ServiceEnum.FlexKnobEnum flexKnobEnum) {
        for (MappingObject mappingObject : ViewUtil.getList((int) R.array.msg_flex_knob_manual)) {
            if (flexKnobEnum.value1 == mappingObject.getValue()) {
                MessageBus.getInstance().onSyncData(MessageBus.getKey(57, MessageID.MSG_FLEX_KNOB_REFRESH_ICON), mappingObject);
                return;
            }
        }
    }

    public void updateRefIconForMessage(int i) {
        switch (i) {
            case 0:
                updateIconForMessage(ServiceEnum.FlexKnobEnum.Ref1);
                return;
            case 1:
                updateIconForMessage(ServiceEnum.FlexKnobEnum.Ref2);
                return;
            case 2:
                updateIconForMessage(ServiceEnum.FlexKnobEnum.Ref3);
                return;
            case 3:
                updateIconForMessage(ServiceEnum.FlexKnobEnum.Ref4);
                return;
            case 4:
                updateIconForMessage(ServiceEnum.FlexKnobEnum.Ref5);
                return;
            case 5:
                updateIconForMessage(ServiceEnum.FlexKnobEnum.Ref6);
                return;
            case 6:
                updateIconForMessage(ServiceEnum.FlexKnobEnum.Ref7);
                return;
            case 7:
                updateIconForMessage(ServiceEnum.FlexKnobEnum.Ref8);
                return;
            case 8:
                updateIconForMessage(ServiceEnum.FlexKnobEnum.Ref9);
                return;
            case 9:
                updateIconForMessage(ServiceEnum.FlexKnobEnum.Ref10);
                return;
            default:
                return;
        }
    }

    public void updateDecodeIconForMessage(int i) {
        if (i == 0) {
            updateIconForMessage(ServiceEnum.FlexKnobEnum.Decoder1);
        } else if (i == 1) {
            updateIconForMessage(ServiceEnum.FlexKnobEnum.Decoder2);
        } else if (i == 2) {
            updateIconForMessage(ServiceEnum.FlexKnobEnum.Decoder3);
        } else if (i != 3) {
        } else {
            updateIconForMessage(ServiceEnum.FlexKnobEnum.Decoder4);
        }
    }

    public MappingObject flexKnobEnum2MappingObject(ServiceEnum.FlexKnobEnum flexKnobEnum) {
        MappingObject mappingObject = null;
        for (MappingObject mappingObject2 : ViewUtil.getList((int) R.array.msg_flex_knob_manual)) {
            if (flexKnobEnum.value1 == mappingObject2.getValue()) {
                mappingObject = mappingObject2;
            }
        }
        return mappingObject;
    }

    public void selectLight(ServiceEnum.FlexKnobEnum flexKnobEnum) {
        if (PopupViewManager.getInstance().isShowing()) {
            PopupViewManager.getInstance().flexBeforeLight();
        } else if (flexKnobEnum == null) {
        } else {
            switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[flexKnobEnum.ordinal()]) {
                case 1:
                    PopupViewManager.getInstance().intensityLight();
                    return;
                case 2:
                    PopupViewManager.getInstance().cursorLight();
                    return;
                case 3:
                    PopupViewManager.getInstance().mathLight(0);
                    return;
                case 4:
                    PopupViewManager.getInstance().mathLight(1);
                    return;
                case 5:
                    PopupViewManager.getInstance().mathLight(2);
                    return;
                case 6:
                    PopupViewManager.getInstance().mathLight(3);
                    return;
                case 7:
                case 8:
                case 9:
                    return;
                case 10:
                    PopupViewManager.getInstance().refLight(0);
                    return;
                case 11:
                    PopupViewManager.getInstance().refLight(1);
                    return;
                case 12:
                    PopupViewManager.getInstance().refLight(2);
                    return;
                case 13:
                    PopupViewManager.getInstance().refLight(3);
                    return;
                case 14:
                    PopupViewManager.getInstance().refLight(4);
                    return;
                case 15:
                    PopupViewManager.getInstance().refLight(5);
                    return;
                case 16:
                    PopupViewManager.getInstance().refLight(6);
                    return;
                case 17:
                    PopupViewManager.getInstance().refLight(7);
                    return;
                case 18:
                    PopupViewManager.getInstance().refLight(8);
                    return;
                case 19:
                    PopupViewManager.getInstance().refLight(9);
                    return;
                case 20:
                case 21:
                case 22:
                case 23:
                    PopupViewManager.getInstance().decodeLight();
                    return;
                default:
                    this.currentFlexKnobEnum = ServiceEnum.FlexKnobEnum.Intensity;
                    return;
            }
        }
    }

    public void selectFlexLight(ServiceEnum.FlexKnobEnum flexKnobEnum) {
        if (flexKnobEnum == null) {
            return;
        }
        switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[flexKnobEnum.ordinal()]) {
            case 1:
                PopupViewManager.getInstance().intensityLight();
                return;
            case 2:
                PopupViewManager.getInstance().cursorLight();
                return;
            case 3:
                PopupViewManager.getInstance().mathLight(0);
                return;
            case 4:
                PopupViewManager.getInstance().mathLight(1);
                return;
            case 5:
                PopupViewManager.getInstance().mathLight(2);
                return;
            case 6:
                PopupViewManager.getInstance().mathLight(3);
                return;
            case 7:
            case 8:
            case 9:
                return;
            case 10:
                PopupViewManager.getInstance().refLight(0);
                return;
            case 11:
                PopupViewManager.getInstance().refLight(1);
                return;
            case 12:
                PopupViewManager.getInstance().refLight(2);
                return;
            case 13:
                PopupViewManager.getInstance().refLight(3);
                return;
            case 14:
                PopupViewManager.getInstance().refLight(4);
                return;
            case 15:
                PopupViewManager.getInstance().refLight(5);
                return;
            case 16:
                PopupViewManager.getInstance().refLight(6);
                return;
            case 17:
                PopupViewManager.getInstance().refLight(7);
                return;
            case 18:
                PopupViewManager.getInstance().refLight(8);
                return;
            case 19:
                PopupViewManager.getInstance().refLight(9);
                return;
            case 20:
            case 21:
            case 22:
            case 23:
                PopupViewManager.getInstance().decodeLight();
                return;
            default:
                this.currentFlexKnobEnum = ServiceEnum.FlexKnobEnum.Intensity;
                return;
        }
    }

    public void restoreSelectedFunction() {
        this.selectedFunction = ServiceEnum.Function.FUN_HORIZONTAL;
        MessageBus.getInstance().onSyncData(MessageBus.SYNC_DATA_KEY_FUNCTION_ITEM_CLICK, ServiceEnum.Function.FUN_HORIZONTAL);
    }

    public boolean handleItemLongClick(ServiceEnum.Function function) {
        boolean z = false;
        if (function == null) {
            return false;
        }
        setSelectedFunction(function);
        if (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[function.ordinal()] == 15) {
            if (!API.getInstance().UI_QueryBool(35, 776)) {
                API.getInstance().UI_PostInt32(35, 768, 0);
            } else {
                ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_auto_disabled));
            }
            z = true;
        }
        MessageBus.getInstance().onSyncData(MessageBus.SYNC_DATA_KEY_FUNCTION_ITEM_LONG_CLICK, function);
        return z;
    }

    public void handleItemClick(ServiceEnum.Function function) {
        XYParam value;
        HorizontalParam value2;
        FftParam value3;
        final HorizontalParam value4;
        ServiceEnum.ControlAction controlAction;
        HorizontalParam value5;
        NavigateParam value6;
        if (function == null) {
            return;
        }
        ServiceEnum.Function selectedFunction = getSelectedFunction();
        Activity topActivity = ActivityUtils.getTopActivity();
        boolean z = false;
        switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[function.ordinal()]) {
            case 1:
                if (checkUltraIsOpen()) {
                    ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                    return;
                }
                if (getInstance().isEnabled(ServiceEnum.Function.FUN_CURSOR)) {
                    getInstance().disable(ServiceEnum.Function.FUN_CURSOR);
                    z = true;
                } else {
                    getInstance().enable(ServiceEnum.Function.FUN_CURSOR);
                    getInstance().setSelectedFunction(ServiceEnum.Function.FUN_CURSOR);
                    MessageBus.getInstance().onSyncData(MessageBus.SYNC_DATA_KEY_FUNCTION_ITEM_CLICK, ServiceEnum.Function.FUN_CURSOR);
                }
                MessageBus.getInstance().onSyncData(MessageBus.getKey(10, MessageID.MSG_HOR_REFRESH_ULTRAL_ENABLE), null);
                break;
            case 2:
                getInstance().toggle(ServiceEnum.Function.FUN_DVM);
                break;
            case 3:
                getInstance().toggle(ServiceEnum.Function.FUN_COUNTER);
                break;
            case 4:
                PopupViewManager.getInstance().toggle(HistogramSettingPopupView.class);
                break;
            case 5:
                specialItemClick(ServiceEnum.Function.FUN_RECORD);
                break;
            case 6:
                PopupViewManager.getInstance().toggle(MathPopupView.class);
                break;
            case 7:
                specialItemClick(ServiceEnum.Function.FUN_REF);
                break;
            case 8:
                specialItemClick(ServiceEnum.Function.FUN_MASK);
                break;
            case 9:
                specialItemClick(ServiceEnum.Function.FUN_UPA);
                break;
            case 10:
                specialItemClick(ServiceEnum.Function.FUN_DECODE);
                break;
            case 11:
                specialItemClick(ServiceEnum.Function.FUN_SEARCH);
                break;
            case 12:
                if (checkUltraIsOpen()) {
                    ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                    return;
                } else if (WindowHolderManager.getInstance().size(ServiceEnum.WindowType.WIN_XY) == 0) {
                    if (topActivity instanceof MainActivity) {
                        WindowParam windowParam = new WindowParam();
                        ServiceEnum.Chan chan = ServiceEnum.Chan.chan1;
                        ServiceEnum.Chan chan2 = ServiceEnum.Chan.chan2;
                        XYViewModel xYViewModel = (XYViewModel) ContextUtil.getAppViewModel(XYViewModel.class);
                        if (xYViewModel != null && (value = xYViewModel.getLiveData().getValue()) != null) {
                            ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(value.getSourceA().getValue().intValue());
                            if (chanFromValue1 != null) {
                                chan = chanFromValue1;
                            }
                            ServiceEnum.Chan chanFromValue12 = ServiceEnum.getChanFromValue1(value.getSourceB().getValue().intValue());
                            if (chanFromValue12 != null) {
                                chan2 = chanFromValue12;
                            }
                        }
                        windowParam.setSource1(chan);
                        windowParam.setSource2(chan2);
                        windowParam.setServiceID(56);
                        windowParam.setType(ServiceEnum.WindowType.WIN_XY);
                        ((MainActivity) topActivity).getWaveformFragment().addWindow(windowParam);
                        break;
                    }
                } else {
                    BasePopupView basePopupView = PopupViewManager.getInstance().get(XYPopupView.class);
                    if (basePopupView instanceof XYPopupView) {
                        if (basePopupView.isShowing()) {
                            basePopupView.dismiss();
                            break;
                        } else {
                            WindowParam windowParam2 = new WindowParam();
                            XYViewModel xYViewModel2 = (XYViewModel) ContextUtil.getAppViewModel(XYViewModel.class);
                            if (xYViewModel2 != null) {
                                XYParam value7 = xYViewModel2.getLiveData().getValue();
                                if (value7 != null) {
                                    ServiceEnum.Chan chanFromValue13 = ServiceEnum.getChanFromValue1(value7.getSourceA().getValue().intValue());
                                    if (chanFromValue13 != null) {
                                        windowParam2.setSource1(chanFromValue13);
                                    }
                                    ServiceEnum.Chan chanFromValue14 = ServiceEnum.getChanFromValue1(value7.getSourceB().getValue().intValue());
                                    if (chanFromValue14 != null) {
                                        windowParam2.setSource2(chanFromValue14);
                                    }
                                }
                            } else {
                                windowParam2.setSource1(ServiceEnum.Chan.chan1);
                                windowParam2.setSource2(ServiceEnum.Chan.chan2);
                            }
                            windowParam2.setServiceID(56);
                            windowParam2.setType(ServiceEnum.WindowType.WIN_XY);
                            ((XYPopupView) basePopupView).setWindowParam(windowParam2);
                            basePopupView.show();
                            break;
                        }
                    }
                }
                break;
            case 13:
                HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
                if (horizontalViewModel != null && (value2 = horizontalViewModel.getLiveData().getValue()) != null) {
                    if (value2.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL) {
                        ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                        break;
                    } else {
                        PopupViewManager.getInstance().toggle(TriggerPopupView.class);
                        break;
                    }
                }
                break;
            case 14:
                BasePopupView basePopupView2 = PopupViewManager.getInstance().get(WaveIntensityPopupView.class);
                if (getInstance().getSelectedFunction() != function) {
                    if (basePopupView2 != null) {
                        basePopupView2.show();
                        break;
                    }
                } else if (basePopupView2 != null) {
                    if (basePopupView2.isShowing()) {
                        basePopupView2.dismiss();
                        z = true;
                        break;
                    } else {
                        basePopupView2.show();
                        break;
                    }
                }
                break;
            case 15:
                if (!API.getInstance().UI_QueryBool(35, 776)) {
                    API.getInstance().UI_PostInt32(35, 768, 0);
                    break;
                } else {
                    ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_auto_disabled));
                    break;
                }
            case 16:
                PopupViewManager.getInstance().toggle(MeasurePopupView.class);
                break;
            case 17:
                PopupViewManager.getInstance().toggle(FlexKnobPopupView.class);
                break;
            case 19:
                PopupViewManager.getInstance().toggle(MultiWindowPopupView.class);
                break;
            case 20:
                FftViewModel fftViewModel = (FftViewModel) ContextUtil.getAppViewModel(FftViewModel.class);
                if (fftViewModel != null && (value3 = fftViewModel.getLiveData().getValue()) != null) {
                    if (!value3.isEnable()) {
                        value3.saveEnable(true);
                    }
                    PopupViewManager.getInstance().toggle(RtsaPopupView.class);
                    break;
                } else {
                    return;
                }
                break;
            case 21:
                PopupViewManager.getInstance().toggle(EyePopupView.class);
                break;
            case 22:
                PopupViewManager.getInstance().toggle(JitterPopupView.class);
                break;
            case 23:
                PopupViewManager.getInstance().toggle(BusAnalysePopupView.class);
                break;
            case 25:
                PopupViewManager.getInstance().toggle(DisplayPopupView.class);
                break;
            case 27:
                BasePopupView basePopupView3 = PopupViewManager.getInstance().get(UtilityPopupView.class);
                if (basePopupView3 instanceof UtilityPopupView) {
                    ((UtilityPopupView) basePopupView3).setQuickAdapter();
                    basePopupView3.show();
                    break;
                }
                break;
            case 29:
                PopupViewManager.getInstance().toggle(StoragePopupView.class);
                break;
            case 30:
                new HelpPopuwin().show();
                break;
            case 31:
                if (topActivity instanceof MainActivity) {
                    MainActivity mainActivity = (MainActivity) topActivity;
                    SharedViewModel sharedViewModel = mainActivity.getSharedViewModel();
                    if (sharedViewModel != null) {
                        TwoTuple<Boolean, Boolean> value8 = sharedViewModel.hasUpdate.getValue();
                        if (value8 == null || !value8.getFirst().booleanValue()) {
                            mainActivity.checkNewVersion();
                            ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_check_firmware));
                            return;
                        }
                        PopupViewManager.getInstance().show(UpdatePopupView.class);
                        break;
                    } else {
                        return;
                    }
                }
                break;
            case 32:
                PopupViewManager.getInstance().toggle(UtilityPopupView.class);
                break;
            case 33:
                PopupViewManager.getInstance().show(RebootPopupView.class);
                break;
            case 34:
                PopupViewManager.getInstance().show(PowerPopupView.class);
                break;
            case 35:
                MaskViewModel maskViewModel = (MaskViewModel) ContextUtil.getAppViewModel(MaskViewModel.class);
                HorizontalViewModel horizontalViewModel2 = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
                if (horizontalViewModel2 != null && (value4 = horizontalViewModel2.getLiveData().getValue()) != null) {
                    if (value4.getRunStop() == ServiceEnum.ControlAction.Control_Stop) {
                        controlAction = ServiceEnum.ControlAction.Control_Run;
                    } else {
                        controlAction = ServiceEnum.ControlAction.Control_Stop;
                    }
                    value4.saveRunStop(controlAction);
                    Objects.requireNonNull(value4);
                    ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.utilities.-$$Lambda$mxLrpdfoHI4nwFrKf-viPyjN0ss
                        @Override // java.lang.Runnable
                        public final void run() {
                            HorizontalParam.this.readMainOffsetAttr();
                        }
                    }, 200L);
                    break;
                }
                break;
            case 36:
                PopupViewManager.getInstance().toggle(DefaultPopupView.class);
                break;
            case 37:
            case 38:
                if (getInstance().getSelectedFunction() == function) {
                    PopupViewManager.getInstance().toggle(HorizontalPopupView.class);
                    break;
                }
                z = true;
                break;
            case 39:
                if (selectedFunction == ServiceEnum.Function.FUN_TRIGGER) {
                    function = ServiceEnum.Function.FUN_TRIGGER;
                }
                API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_SINGLE, 0);
                break;
            case 40:
                API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_FORCE, 0);
                break;
            case 41:
                API.getInstance().UI_PostInt32(26, MessageID.MSG_DISPLAY_CLEAR, 0);
                break;
            case 42:
                HorizontalViewModel horizontalViewModel3 = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
                if (horizontalViewModel3 != null && (value5 = horizontalViewModel3.getLiveData().getValue()) != null) {
                    if (value5.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL && value5.getRunStop() != ServiceEnum.ControlAction.Control_Stop) {
                        ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                        break;
                    } else {
                        value5.saveZoom(!value5.isZoom());
                        break;
                    }
                }
                break;
            case 43:
                PopupViewManager.getInstance().toggle(NavigatePopupView.class);
                NavigateViewModel navigateViewModel = (NavigateViewModel) ContextUtil.getAppViewModel(NavigateViewModel.class);
                if (navigateViewModel != null && (value6 = navigateViewModel.getLiveData().getValue()) != null) {
                    value6.saveNavEnable(true);
                    break;
                }
                break;
            case 44:
                ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().setBodeMinPop(true);
                PopupViewManager.getInstance().toggle(BodePopupWin.class);
                break;
        }
        if (z) {
            restoreSelectedFunction();
        } else {
            setSelectedFunction(function);
        }
        MessageBus.getInstance().onSyncData(MessageBus.SYNC_DATA_KEY_FUNCTION_ITEM_CLICK, getSelectedFunction());
    }

    public boolean checkUltraIsOpen() {
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        if (horizontalViewModel != null) {
            horizontalViewModel.getLiveData();
            HorizontalParam value = horizontalViewModel.getLiveData().getValue();
            if (value != null && value.getAcquireMode() == ServiceEnum.AcquireMode.Acquire_Ultra) {
                return true;
            }
        }
        return false;
    }

    public boolean getUltraStatus(HorizontalParam horizontalParam) {
        boolean z = true;
        if (horizontalParam != null) {
            z = (horizontalParam.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL || horizontalParam.getMainScale() >= 200000000000000L || this.cursorSwitch || this.recordSwitch || this.refSwitch || this.maskSwitch || this.upaSwitch || this.decodeSwitch || this.searchSwitch || this.xySwitch) ? false : false;
            horizontalParam.setUltraEnable(z);
        }
        return z;
    }

    public boolean getXYEnable(HorizontalParam horizontalParam) {
        boolean z = true;
        if (horizontalParam != null) {
            z = (horizontalParam.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL || horizontalParam.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_SCAN || horizontalParam.getAcquireMode() == ServiceEnum.AcquireMode.Acquire_Ultra) ? false : false;
            horizontalParam.setXyCheckEnable(z);
        }
        return z;
    }

    private void specialItemClick(ServiceEnum.Function function) {
        RefParam.Param param;
        HorizontalParam value;
        HorizontalParam value2;
        if (checkUltraIsOpen()) {
            ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
            return;
        }
        switch (function) {
            case FUN_RECORD:
                PopupViewManager.getInstance().toggle(RecordPopupView.class);
                return;
            case FUN_MATH:
            default:
                return;
            case FUN_REF:
                RefViewModel refViewModel = (RefViewModel) ContextUtil.getAppViewModel(RefViewModel.class);
                if (refViewModel != null) {
                    refViewModel.getLiveData();
                    RefParam value3 = refViewModel.getLiveData().getValue();
                    if (value3 == null || (param = value3.getParam()) == null) {
                        return;
                    }
                    param.setRefColor(param.getRefColor());
                    PopupViewManager.getInstance().toggle(RefPopupView.class);
                    return;
                }
                return;
            case FUN_MASK:
                PopupViewManager.getInstance().toggle(MaskPopupView.class);
                return;
            case FUN_UPA:
                PopupViewManager.getInstance().toggle(UpaPopupview.class);
                return;
            case FUN_DECODE:
                HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
                if (horizontalViewModel == null || (value = horizontalViewModel.getLiveData().getValue()) == null) {
                    return;
                }
                if (value.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL && value.getRunStop() == ServiceEnum.ControlAction.Control_Run) {
                    ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                    return;
                } else {
                    PopupViewManager.getInstance().toggle(DecodeNewPopupView.class);
                    return;
                }
            case FUN_SEARCH:
                HorizontalViewModel horizontalViewModel2 = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
                if (horizontalViewModel2 == null || (value2 = horizontalViewModel2.getLiveData().getValue()) == null) {
                    return;
                }
                if (value2.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL && value2.getRunStop() == ServiceEnum.ControlAction.Control_Run) {
                    ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                    return;
                } else {
                    PopupViewManager.getInstance().toggle(SearchPopupView.class);
                    return;
                }
        }
    }
}
