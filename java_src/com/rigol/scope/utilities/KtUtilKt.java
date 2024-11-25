package com.rigol.scope.utilities;

import android.app.Activity;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.SPUtils;
import com.rigol.scope.MainActivity;
import com.rigol.scope.ResultsBarFragment;
import com.rigol.scope.adapters.ResultListAdapter;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AfgParam;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.data.CounterResultParam;
import com.rigol.scope.data.CursorResultParam;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.DisplayParam;
import com.rigol.scope.data.DvmResultParam;
import com.rigol.scope.data.FlexKnobParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.data.MaskParam;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.data.NavigateParam;
import com.rigol.scope.data.OptionParam;
import com.rigol.scope.data.RefParam;
import com.rigol.scope.data.SearchParam;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.data.TwoTuple;
import com.rigol.scope.data.UpaParam;
import com.rigol.scope.data.UpaRippleParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.data.WaveRecordParam;
import com.rigol.scope.data.XYParam;
import com.rigol.scope.viewmodels.AfgViewModel;
import com.rigol.scope.viewmodels.AutosetViewModel;
import com.rigol.scope.viewmodels.BodeViewModel;
import com.rigol.scope.viewmodels.CounterViewModel;
import com.rigol.scope.viewmodels.CursorViewModel;
import com.rigol.scope.viewmodels.DecodeViewModel;
import com.rigol.scope.viewmodels.DisplayViewModel;
import com.rigol.scope.viewmodels.DvmViewModel;
import com.rigol.scope.viewmodels.FlexKnobViewModel;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.LaViewModel;
import com.rigol.scope.viewmodels.MaskViewModel;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.viewmodels.MeasureSettingViewModel;
import com.rigol.scope.viewmodels.NavigateViewModel;
import com.rigol.scope.viewmodels.OptionViewModel;
import com.rigol.scope.viewmodels.RefViewModel;
import com.rigol.scope.viewmodels.SearchViewModel;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.viewmodels.TriggerViewModel;
import com.rigol.scope.viewmodels.UpaViewModel;
import com.rigol.scope.viewmodels.UpaViewRippleModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.viewmodels.WaveRecordViewModel;
import com.rigol.scope.viewmodels.XYViewModel;
import com.rigol.scope.views.auto.AutosetParam;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.histogram.HistogramResultParam;
import com.rigol.scope.views.histogram.HistogramViewModel;
import com.rigol.scope.views.measure.MeasurePopupView;
import com.rigol.scope.views.trigger.TriggerPopupView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
/* compiled from: KtUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0007\u001a4\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00010\r\u001a\u001a\u0010\u000e\u001a\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u000e\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014\u001a\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0006\u0010\u0019\u001a\u00020\u001a\u001a\u0006\u0010\u001b\u001a\u00020\u001a\u001a\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016\u001a\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016\u001a)\u0010\u001e\u001a\u00020\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010!\u001a\"\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140#2\u0006\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0014\u001a\u001a\u0010&\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006)"}, d2 = {"decodeBusTypeEnable", "", "decodeBusType", "Lcom/rigol/scope/cil/ServiceEnum$DecodeBusType;", "optionParam", "Lcom/rigol/scope/data/OptionParam;", "isDHO800", "(Lcom/rigol/scope/cil/ServiceEnum$DecodeBusType;Lcom/rigol/scope/data/OptionParam;Ljava/lang/Boolean;)Z", "filter", "", ExifInterface.GPS_DIRECTION_TRUE, "list", "predicate", "Lkotlin/Function1;", "functionEnable", "function", "Lcom/rigol/scope/cil/ServiceEnum$Function;", "isOptAuto", "needTrim", "logResult", "", "parseInt", "", "value", "", "printStackTrace", "", "resetAll", "toBinaryString", "toHexString", "triggerModeEnable", "triggerMode", "Lcom/rigol/scope/cil/ServiceEnum$TriggerMode;", "(Lcom/rigol/scope/cil/ServiceEnum$TriggerMode;Lcom/rigol/scope/data/OptionParam;Ljava/lang/Boolean;)Z", "trimByNth", "Lcom/rigol/scope/data/TwoTuple;", "num", "base", "windowTypeEnable", "windowType", "Lcom/rigol/scope/cil/ServiceEnum$WindowType;", "app_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class KtUtilKt {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[ServiceEnum.WindowType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ServiceEnum.WindowType.WIN_FFT.ordinal()] = 1;
            $EnumSwitchMapping$0[ServiceEnum.WindowType.WIN_EYE.ordinal()] = 2;
            int[] iArr2 = new int[ServiceEnum.Function.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ServiceEnum.Function.FUN_FFT.ordinal()] = 1;
            $EnumSwitchMapping$1[ServiceEnum.Function.FUN_EYE.ordinal()] = 2;
            $EnumSwitchMapping$1[ServiceEnum.Function.FUN_JITTER.ordinal()] = 3;
            $EnumSwitchMapping$1[ServiceEnum.Function.FUN_BUS_ANALYSE.ordinal()] = 4;
            int[] iArr3 = new int[ServiceEnum.DecodeBusType.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[ServiceEnum.DecodeBusType.Decode_RS232.ordinal()] = 1;
            $EnumSwitchMapping$2[ServiceEnum.DecodeBusType.Decode_I2C.ordinal()] = 2;
            $EnumSwitchMapping$2[ServiceEnum.DecodeBusType.Decode_SPI.ordinal()] = 3;
            $EnumSwitchMapping$2[ServiceEnum.DecodeBusType.Decode_CAN.ordinal()] = 4;
            $EnumSwitchMapping$2[ServiceEnum.DecodeBusType.Decode_LIN.ordinal()] = 5;
            $EnumSwitchMapping$2[ServiceEnum.DecodeBusType.Decode_FlexRay.ordinal()] = 6;
            $EnumSwitchMapping$2[ServiceEnum.DecodeBusType.Decode_I2S.ordinal()] = 7;
            $EnumSwitchMapping$2[ServiceEnum.DecodeBusType.Decode_1553B.ordinal()] = 8;
            int[] iArr4 = new int[ServiceEnum.TriggerMode.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[ServiceEnum.TriggerMode.Trigger_RS232.ordinal()] = 1;
            $EnumSwitchMapping$3[ServiceEnum.TriggerMode.Trigger_I2C.ordinal()] = 2;
            $EnumSwitchMapping$3[ServiceEnum.TriggerMode.Trigger_SPI.ordinal()] = 3;
            $EnumSwitchMapping$3[ServiceEnum.TriggerMode.Trigger_CAN.ordinal()] = 4;
            $EnumSwitchMapping$3[ServiceEnum.TriggerMode.Trigger_LIN.ordinal()] = 5;
            $EnumSwitchMapping$3[ServiceEnum.TriggerMode.Trigger_FlexRay.ordinal()] = 6;
            $EnumSwitchMapping$3[ServiceEnum.TriggerMode.Trigger_I2S.ordinal()] = 7;
            $EnumSwitchMapping$3[ServiceEnum.TriggerMode.Trigger_1553.ordinal()] = 8;
        }
    }

    public static final boolean needTrim(double d) {
        return d - ((double) ((int) d)) != 0.0d;
    }

    public static final void resetAll() {
        LiveData<SearchParam> liveData;
        SearchParam value;
        LiveData<XYParam> liveData2;
        XYParam value2;
        LiveData<ArrayList<DecodeParam>> liveData3;
        ArrayList<DecodeParam> value3;
        MutableLiveData<StorageSaveParam> saveLiveData;
        StorageSaveParam value4;
        LiveData<HistogramResultParam> liveData4;
        HistogramResultParam value5;
        LiveData<FlexKnobParam> liveData5;
        FlexKnobParam value6;
        LiveData<NavigateParam> liveData6;
        NavigateParam value7;
        LiveData<DvmResultParam> liveData7;
        DvmResultParam value8;
        LiveData<CounterResultParam> liveData8;
        CounterResultParam value9;
        LiveData<RefParam> liveData9;
        RefParam value10;
        LiveData<WaveRecordParam> liveData10;
        WaveRecordParam value11;
        LiveData<MaskParam> liveData11;
        MaskParam value12;
        LiveData<DisplayParam> liveData12;
        DisplayParam value13;
        LiveData<UpaRippleParam> liveData13;
        UpaRippleParam value14;
        LiveData<UpaParam> liveData14;
        UpaParam value15;
        LiveData<MeasureSettingParam> liveData15;
        MeasureSettingParam value16;
        LiveData<CursorResultParam> liveData16;
        CursorResultParam value17;
        LiveData<AutosetParam> liveData17;
        AutosetParam value18;
        LiveData<UtilityParam> liveData18;
        UtilityParam value19;
        LiveData<ArrayList<MathParam>> liveData19;
        ArrayList<MathParam> value20;
        LiveData<TriggerParam> liveData20;
        TriggerParam value21;
        LiveData<HorizontalParam> liveData21;
        HorizontalParam value22;
        LiveData<ArrayList<VerticalParam>> liveData22;
        ArrayList<VerticalParam> value23;
        SPUtils.getInstance().clear();
        FunctionManager.getInstance().resetArgsAboutUltra();
        FunctionManager functionManager = FunctionManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(functionManager, "FunctionManager.getInstance()");
        functionManager.setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Intensity);
        BasePopupView basePopupView = PopupViewManager.getInstance().get(MeasurePopupView.class);
        if (basePopupView != null && (basePopupView instanceof MeasurePopupView)) {
            ((MeasurePopupView) basePopupView).setPageCurrentItem(0);
        }
        VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        if (verticalViewModel != null && (liveData22 = verticalViewModel.getLiveData()) != null && (value23 = liveData22.getValue()) != null) {
            Iterator<VerticalParam> it = value23.iterator();
            while (it.hasNext()) {
                it.next().reset();
            }
        }
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        if (horizontalViewModel != null && (liveData21 = horizontalViewModel.getLiveData()) != null && (value22 = liveData21.getValue()) != null) {
            value22.reset();
        }
        TriggerViewModel triggerViewModel = (TriggerViewModel) ContextUtil.getAppViewModel(TriggerViewModel.class);
        if (triggerViewModel != null && (liveData20 = triggerViewModel.getLiveData()) != null && (value21 = liveData20.getValue()) != null) {
            value21.reset();
        }
        BasePopupView basePopupView2 = PopupViewManager.getInstance().get(TriggerPopupView.class);
        if (basePopupView2 != null) {
            ((TriggerPopupView) basePopupView2).showTrigger(ServiceEnum.TriggerMode.Trigger_Edge);
            MathViewModel mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
            if (mathViewModel != null && (liveData19 = mathViewModel.getLiveData()) != null && (value20 = liveData19.getValue()) != null) {
                Iterator<MathParam> it2 = value20.iterator();
                while (it2.hasNext()) {
                    it2.next().reset();
                }
            }
            UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
            if (utilityViewModel != null && (liveData18 = utilityViewModel.getLiveData()) != null && (value19 = liveData18.getValue()) != null) {
                value19.reset();
            }
            AutosetViewModel autosetViewModel = (AutosetViewModel) ContextUtil.getAppViewModel(AutosetViewModel.class);
            if (autosetViewModel != null && (liveData17 = autosetViewModel.getLiveData()) != null && (value18 = liveData17.getValue()) != null) {
                value18.reset();
            }
            CursorViewModel cursorViewModel = (CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class);
            if (cursorViewModel != null && (liveData16 = cursorViewModel.getLiveData()) != null && (value17 = liveData16.getValue()) != null) {
                value17.reset();
            }
            MeasureSettingViewModel measureSettingViewModel = (MeasureSettingViewModel) ContextUtil.getAppViewModel(MeasureSettingViewModel.class);
            if (measureSettingViewModel != null && (liveData15 = measureSettingViewModel.getLiveData()) != null && (value16 = liveData15.getValue()) != null) {
                value16.reset();
            }
            UpaViewModel upaViewModel = (UpaViewModel) ContextUtil.getActivityViewModel(UpaViewModel.class);
            if (upaViewModel != null && (liveData14 = upaViewModel.getLiveData()) != null && (value15 = liveData14.getValue()) != null) {
                value15.reset();
            }
            UpaViewRippleModel upaViewRippleModel = (UpaViewRippleModel) ContextUtil.getActivityViewModel(UpaViewRippleModel.class);
            if (upaViewRippleModel != null && (liveData13 = upaViewRippleModel.getLiveData()) != null && (value14 = liveData13.getValue()) != null) {
                value14.reset();
            }
            DisplayViewModel displayViewModel = (DisplayViewModel) ContextUtil.getAppViewModel(DisplayViewModel.class);
            if (displayViewModel != null && (liveData12 = displayViewModel.getLiveData()) != null && (value13 = liveData12.getValue()) != null) {
                value13.reset();
            }
            MaskViewModel maskViewModel = (MaskViewModel) ContextUtil.getAppViewModel(MaskViewModel.class);
            if (maskViewModel != null && (liveData11 = maskViewModel.getLiveData()) != null && (value12 = liveData11.getValue()) != null) {
                value12.reset();
            }
            WaveRecordViewModel waveRecordViewModel = (WaveRecordViewModel) ContextUtil.getAppViewModel(WaveRecordViewModel.class);
            if (waveRecordViewModel != null && (liveData10 = waveRecordViewModel.getLiveData()) != null && (value11 = liveData10.getValue()) != null) {
                value11.reset();
            }
            RefViewModel refViewModel = (RefViewModel) ContextUtil.getAppViewModel(RefViewModel.class);
            if (refViewModel != null && (liveData9 = refViewModel.getLiveData()) != null && (value10 = liveData9.getValue()) != null) {
                value10.reset();
            }
            CounterViewModel counterViewModel = (CounterViewModel) ContextUtil.getAppViewModel(CounterViewModel.class);
            if (counterViewModel != null && (liveData8 = counterViewModel.getLiveData()) != null && (value9 = liveData8.getValue()) != null) {
                value9.reset();
            }
            DvmViewModel dvmViewModel = (DvmViewModel) ContextUtil.getAppViewModel(DvmViewModel.class);
            if (dvmViewModel != null && (liveData7 = dvmViewModel.getLiveData()) != null && (value8 = liveData7.getValue()) != null) {
                value8.reset();
            }
            NavigateViewModel navigateViewModel = (NavigateViewModel) ContextUtil.getAppViewModel(NavigateViewModel.class);
            if (navigateViewModel != null && (liveData6 = navigateViewModel.getLiveData()) != null && (value7 = liveData6.getValue()) != null) {
                value7.reset();
            }
            FlexKnobViewModel flexKnobViewModel = (FlexKnobViewModel) ContextUtil.getAppViewModel(FlexKnobViewModel.class);
            if (flexKnobViewModel != null && (liveData5 = flexKnobViewModel.getLiveData()) != null && (value6 = liveData5.getValue()) != null) {
                value6.reset();
            }
            HistogramViewModel histogramViewModel = (HistogramViewModel) ContextUtil.getAppViewModel(HistogramViewModel.class);
            if (histogramViewModel != null && (liveData4 = histogramViewModel.getLiveData()) != null && (value5 = liveData4.getValue()) != null) {
                value5.reset();
            }
            StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
            if (storageViewModel != null && (saveLiveData = storageViewModel.getSaveLiveData()) != null && (value4 = saveLiveData.getValue()) != null) {
                value4.reset();
            }
            DecodeViewModel decodeViewModel = (DecodeViewModel) ContextUtil.getAppViewModel(DecodeViewModel.class);
            if (decodeViewModel != null && (liveData3 = decodeViewModel.getLiveData()) != null && (value3 = liveData3.getValue()) != null) {
                Iterator<DecodeParam> it3 = value3.iterator();
                while (it3.hasNext()) {
                    it3.next().reset();
                }
            }
            XYViewModel xYViewModel = (XYViewModel) ContextUtil.getAppViewModel(XYViewModel.class);
            if (xYViewModel != null && (liveData2 = xYViewModel.getLiveData()) != null && (value2 = liveData2.getValue()) != null) {
                value2.reset();
            }
            StateManager.INSTANCE.getStates().clear();
            SearchViewModel searchViewModel = (SearchViewModel) ContextUtil.getAppViewModel(SearchViewModel.class);
            if (searchViewModel != null && (liveData = searchViewModel.getLiveData()) != null && (value = liveData.getValue()) != null) {
                value.reset();
            }
            AfgParam value24 = ((AfgViewModel) ContextUtil.getAppViewModel(AfgViewModel.class)).getLiveData().getValue();
            if (value24 != null) {
                value24.reset();
            }
            BodeParam value25 = ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getLiveData().getValue();
            if (value25 != null) {
                value25.reset();
            }
            LaParam value26 = ((LaViewModel) ContextUtil.getAppViewModel(LaViewModel.class)).getLiveData().getValue();
            if (value26 != null) {
                value26.reset();
            }
            final Activity topActivity = ActivityUtils.getTopActivity();
            Intrinsics.checkNotNullExpressionValue(topActivity, "topActivity");
            Window window = topActivity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "topActivity.window");
            window.getDecorView().postDelayed(new Runnable() { // from class: com.rigol.scope.utilities.KtUtilKt$resetAll$5
                @Override // java.lang.Runnable
                public final void run() {
                    ResultsBarFragment resultBarFragment;
                    ResultListAdapter resultAdapter;
                    PopupViewManager.getInstance().dismissAll(new Class[0]);
                    WindowHolderManager.getInstance().removeAll();
                    Activity activity = topActivity;
                    if (!(activity instanceof MainActivity) || (resultBarFragment = ((MainActivity) activity).getResultBarFragment()) == null || (resultAdapter = resultBarFragment.getResultAdapter()) == null) {
                        return;
                    }
                    resultAdapter.removeAll();
                }
            }, 0L);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.rigol.scope.views.trigger.TriggerPopupView");
    }

    public static final <T> List<T> filter(List<? extends T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Object obj = (T) it.next();
            if (predicate.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final boolean windowTypeEnable(ServiceEnum.WindowType windowType, OptionParam optionParam) {
        if (optionParam != null && windowType != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[windowType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return true;
                }
                return optionParam.get(ServiceEnum.OptType.OPT_EYE);
            }
            return optionParam.get(ServiceEnum.OptType.OPT_RTSA);
        }
        return true;
    }

    public static final boolean functionEnable(ServiceEnum.Function function, OptionParam optionParam) {
        if (optionParam != null && function != null) {
            int i = WhenMappings.$EnumSwitchMapping$1[function.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return i != 4 || optionParam.get(ServiceEnum.OptType.OPT_CM_USB) || optionParam.get(ServiceEnum.OptType.OPT_CM_ENET);
                    }
                    return optionParam.get(ServiceEnum.OptType.OPT_JITTER);
                }
                return optionParam.get(ServiceEnum.OptType.OPT_EYE);
            }
            return optionParam.get(ServiceEnum.OptType.OPT_RTSA);
        }
        return true;
    }

    public static final boolean decodeBusTypeEnable(ServiceEnum.DecodeBusType decodeBusType, OptionParam optionParam, Boolean bool) {
        if (optionParam != null && decodeBusType != null) {
            switch (WhenMappings.$EnumSwitchMapping$2[decodeBusType.ordinal()]) {
                case 1:
                    return optionParam.get(ServiceEnum.OptType.OPT_COMP);
                case 2:
                case 3:
                    return optionParam.get(ServiceEnum.OptType.OPT_EMBD);
                case 4:
                    return optionParam.get(ServiceEnum.OptType.OPT_AUTO);
                case 5:
                    if (optionParam.get(ServiceEnum.OptType.OPT_AUTO)) {
                        Intrinsics.checkNotNull(bool);
                        if (!bool.booleanValue()) {
                            return true;
                        }
                    }
                    return false;
                case 6:
                    return optionParam.get(ServiceEnum.OptType.OPT_FLEX);
                case 7:
                    return optionParam.get(ServiceEnum.OptType.OPT_AUDIO);
                case 8:
                    return optionParam.get(ServiceEnum.OptType.OPT_AERO);
                default:
                    return true;
            }
        }
        return true;
    }

    public static final boolean isOptAuto() {
        OptionViewModel optionViewModel = (OptionViewModel) ContextUtil.getAppViewModel(OptionViewModel.class);
        if (optionViewModel != null) {
            optionViewModel.getLiveData();
            OptionParam value = optionViewModel.getLiveData().getValue();
            if (value != null) {
                return value.get(ServiceEnum.OptType.OPT_AUTO);
            }
        }
        return false;
    }

    public static final boolean triggerModeEnable(ServiceEnum.TriggerMode triggerMode, OptionParam optionParam, Boolean bool) {
        if (optionParam != null && triggerMode != null) {
            switch (WhenMappings.$EnumSwitchMapping$3[triggerMode.ordinal()]) {
                case 1:
                    return optionParam.get(ServiceEnum.OptType.OPT_COMP);
                case 2:
                case 3:
                    return optionParam.get(ServiceEnum.OptType.OPT_EMBD);
                case 4:
                    return optionParam.get(ServiceEnum.OptType.OPT_AUTO);
                case 5:
                    if (optionParam.get(ServiceEnum.OptType.OPT_AUTO)) {
                        Intrinsics.checkNotNull(bool);
                        if (!bool.booleanValue()) {
                            return true;
                        }
                    }
                    return false;
                case 6:
                    return optionParam.get(ServiceEnum.OptType.OPT_FLEX);
                case 7:
                    return optionParam.get(ServiceEnum.OptType.OPT_AUDIO);
                case 8:
                    return optionParam.get(ServiceEnum.OptType.OPT_AERO);
                default:
                    return true;
            }
        }
        return true;
    }

    public static final String toHexString(int i) {
        String hexString = Integer.toHexString(i);
        Intrinsics.checkNotNullExpressionValue(hexString, "Integer.toHexString(value)");
        return hexString;
    }

    public static final String toBinaryString(int i) {
        String binaryString = Integer.toBinaryString(i);
        Intrinsics.checkNotNullExpressionValue(binaryString, "Integer.toBinaryString(value)");
        return binaryString;
    }

    public static final int parseInt(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            return Integer.parseInt(value);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static final TwoTuple<Boolean, Double> trimByNth(double d, double d2) {
        double log = MathKt.log(d, d2);
        if (!needTrim(log)) {
            return new TwoTuple<>(false, Double.valueOf(d));
        }
        return new TwoTuple<>(true, Double.valueOf(Math.pow(d2, (int) log)));
    }

    public static final void printStackTrace() {
        new Exception().printStackTrace();
    }
}
