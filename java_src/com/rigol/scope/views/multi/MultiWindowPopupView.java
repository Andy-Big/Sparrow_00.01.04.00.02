package com.rigol.scope.views.multi;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.adapters.MultiWindowAdapter;
import com.rigol.scope.adapters.OnItemClickListener;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.EyeParam;
import com.rigol.scope.data.FftParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.data.OptionParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.databinding.PopupviewMultiWindowBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.KtUtilKt;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.StateManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.DecodeViewModel;
import com.rigol.scope.viewmodels.EyeViewModel;
import com.rigol.scope.viewmodels.FftViewModel;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.viewmodels.MeasureSettingViewModel;
import com.rigol.scope.viewmodels.OptionViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.XYViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.grid.GridSpaceItemDecoration;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.scope.views.window.WindowHolder;
import com.rigol.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MultiWindowPopupView extends BasePopupView implements View.OnClickListener {
    private AorBManager aorBManager;
    private View clickedView;
    private List<DecodeParam> decodeParamList;
    private MultiWindowAdapter diagramListAdapter;
    private final List<ServiceEnum.WindowType> diagramTypes;
    private FftParam fftParam;
    private List<AorBParam> list_aorbParam;
    private List<MappingObject> mappingObjects;
    private List<MathParam> mathParamList;
    private MeasureSettingParam measureSettingParam;
    private final ObservableBoolean okButtonEnable;
    private OptionParam optionParam;
    private PanelKeyViewModel panelKeyViewModel;
    private final WindowParam param;
    private PopupSpinner popupSpinner;
    private MultiWindowAdapter resultTableListAdapter;
    private final List<ServiceEnum.WindowType> resultTableTypes;
    private final ObservableBoolean showSource1;
    private final ObservableBoolean showSource2;
    private final ObservableBoolean showSource3;
    private final ObservableBoolean showType;
    private final ObservableInt sourceArrayId;
    private SpinnerAdapter spinnerAdapter;
    private final ObservableInt typeArrayId;
    private final ObservableBoolean uiEnable;

    public MultiWindowPopupView() {
        super((int) R.style.App_PopupWindow_MultiWindow);
        this.param = new WindowParam();
        this.diagramTypes = new ArrayList<ServiceEnum.WindowType>() { // from class: com.rigol.scope.views.multi.MultiWindowPopupView.1
            {
                add(ServiceEnum.WindowType.WIN_XY);
                add(ServiceEnum.WindowType.WIN_MATH);
            }
        };
        this.resultTableTypes = new ArrayList<ServiceEnum.WindowType>() { // from class: com.rigol.scope.views.multi.MultiWindowPopupView.2
            {
                add(ServiceEnum.WindowType.WIN_MEASURE);
                add(ServiceEnum.WindowType.WIN_ALL_MEASURE);
                add(ServiceEnum.WindowType.WIN_DECODE);
            }
        };
        this.diagramListAdapter = null;
        this.resultTableListAdapter = null;
        this.showSource1 = new ObservableBoolean();
        this.showSource2 = new ObservableBoolean();
        this.showSource3 = new ObservableBoolean();
        this.showType = new ObservableBoolean();
        this.sourceArrayId = new ObservableInt();
        this.typeArrayId = new ObservableInt();
        this.uiEnable = new ObservableBoolean();
        this.okButtonEnable = new ObservableBoolean();
        this.mathParamList = null;
        this.decodeParamList = null;
        this.fftParam = null;
        this.measureSettingParam = null;
        this.optionParam = null;
        this.list_aorbParam = new ArrayList();
        MathViewModel mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
        if (mathViewModel != null) {
            mathViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$4gzeKKo4hqzV7m7ROOQ2JLspToo
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MultiWindowPopupView.this.lambda$new$0$MultiWindowPopupView((ArrayList) obj);
                }
            });
        }
        FftViewModel fftViewModel = (FftViewModel) ContextUtil.getAppViewModel(FftViewModel.class);
        if (fftViewModel != null) {
            fftViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$qVwPb6xjNSWjfu96jEWULUtV6WA
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MultiWindowPopupView.this.lambda$new$1$MultiWindowPopupView((FftParam) obj);
                }
            });
        }
        MeasureSettingViewModel measureSettingViewModel = (MeasureSettingViewModel) ContextUtil.getAppViewModel(MeasureSettingViewModel.class);
        if (measureSettingViewModel != null) {
            measureSettingViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$eTkh1PV2n-2pByTl57-whlZr-vM
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MultiWindowPopupView.this.lambda$new$2$MultiWindowPopupView((MeasureSettingParam) obj);
                }
            });
        }
        DecodeViewModel decodeViewModel = (DecodeViewModel) ContextUtil.getAppViewModel(DecodeViewModel.class);
        if (decodeViewModel != null) {
            decodeViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$-z9Pff21B0T9bb6vZykdAtcBIkw
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MultiWindowPopupView.this.lambda$new$3$MultiWindowPopupView((ArrayList) obj);
                }
            });
        }
        OptionViewModel optionViewModel = (OptionViewModel) ContextUtil.getAppViewModel(OptionViewModel.class);
        if (optionViewModel != null) {
            optionViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$F0D9AabMWsygjemXIYzxQtOB7x8
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MultiWindowPopupView.this.lambda$new$4$MultiWindowPopupView((OptionParam) obj);
                }
            });
        }
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null) {
            syncDataViewModel.get(36, MessageID.MSG_LICENSE_CHANGED).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$KXJu0e4GRyAIaDY8wKpsU_6VARw
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MultiWindowPopupView.this.lambda$new$5$MultiWindowPopupView(obj);
                }
            });
        }
        PopupviewMultiWindowBinding inflate = PopupviewMultiWindowBinding.inflate(LayoutInflater.from(this.context));
        setContentView(inflate.getRoot());
        inflate.setWindowParam(this.param);
        inflate.setShowSource1(this.showSource1);
        inflate.setShowSource2(this.showSource2);
        inflate.setShowSource3(this.showSource3);
        inflate.setShowType(this.showType);
        inflate.setSourceArrayId(this.sourceArrayId);
        inflate.setTypeArrayId(this.typeArrayId);
        inflate.setUiEnable(this.uiEnable);
        inflate.setOkButtonEnable(this.okButtonEnable);
        inflate.setOnClickListener(this);
        this.list_aorbParam.add(new AorBParam(inflate.holder1Spinner, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(inflate.holder2Spinner, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(inflate.holder3Spinner, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(inflate.holder4Spinner, 0, false, "", 2));
        this.aorBManager = new AorBManager(this.context, this.list_aorbParam) { // from class: com.rigol.scope.views.multi.MultiWindowPopupView.3
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
            }
        };
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$Jm2r6jCWPBqVQFMAXyuBIg1Cs3k
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        MultiWindowPopupView.this.lambda$new$7$MultiWindowPopupView((KeyEvent) obj);
                    }
                });
            }
        }
        if (WindowHolderManager.getInstance().size(ServiceEnum.WindowType.WIN_MAIN_WAVEFORM) == 0) {
            this.diagramTypes.add(ServiceEnum.WindowType.WIN_MAIN_WAVEFORM);
        }
        MultiWindowAdapter multiWindowAdapter = new MultiWindowAdapter(this.context, this.diagramTypes, R.layout.adapter_item_simple2);
        this.diagramListAdapter = multiWindowAdapter;
        multiWindowAdapter.setCurrentItem(0);
        inflate.typeDiagramList.addItemDecoration(new GridSpaceItemDecoration(10, true));
        inflate.typeDiagramList.setAdapter(this.diagramListAdapter);
        MultiWindowAdapter multiWindowAdapter2 = new MultiWindowAdapter(this.context, this.resultTableTypes, R.layout.adapter_item_simple2);
        this.resultTableListAdapter = multiWindowAdapter2;
        multiWindowAdapter2.setCurrentItemForce(-1);
        inflate.typeResultTableList.addItemDecoration(new GridSpaceItemDecoration(10, true));
        inflate.typeResultTableList.setAdapter(this.resultTableListAdapter);
        this.diagramListAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$Q04XCAlB5Heoypx1kZAamnZXkc0
            @Override // com.rigol.scope.adapters.OnItemClickListener
            public final void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
                MultiWindowPopupView.this.lambda$new$8$MultiWindowPopupView(view, viewHolder, i);
            }
        });
        this.resultTableListAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$Snx6IaPFtwm9zljod-EqOcA3Xzw
            @Override // com.rigol.scope.adapters.OnItemClickListener
            public final void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
                MultiWindowPopupView.this.lambda$new$9$MultiWindowPopupView(view, viewHolder, i);
            }
        });
        reset();
    }

    public /* synthetic */ void lambda$new$0$MultiWindowPopupView(ArrayList arrayList) {
        this.mathParamList = arrayList;
    }

    public /* synthetic */ void lambda$new$1$MultiWindowPopupView(FftParam fftParam) {
        this.fftParam = fftParam;
    }

    public /* synthetic */ void lambda$new$2$MultiWindowPopupView(MeasureSettingParam measureSettingParam) {
        this.measureSettingParam = measureSettingParam;
    }

    public /* synthetic */ void lambda$new$3$MultiWindowPopupView(ArrayList arrayList) {
        this.decodeParamList = arrayList;
    }

    public /* synthetic */ void lambda$new$4$MultiWindowPopupView(OptionParam optionParam) {
        this.optionParam = optionParam;
    }

    public /* synthetic */ void lambda$new$5$MultiWindowPopupView(Object obj) {
        MultiWindowAdapter multiWindowAdapter = this.diagramListAdapter;
        if (multiWindowAdapter != null) {
            multiWindowAdapter.notifyDataSetChanged();
        }
        MultiWindowAdapter multiWindowAdapter2 = this.resultTableListAdapter;
        if (multiWindowAdapter2 != null) {
            multiWindowAdapter2.notifyDataSetChanged();
        }
    }

    public /* synthetic */ void lambda$new$7$MultiWindowPopupView(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(MultiWindowPopupView.class)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, null, null, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$SeCllL8xaDokgeinGYLzEncChBk
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    MultiWindowPopupView.this.lambda$new$6$MultiWindowPopupView(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$6$MultiWindowPopupView(int i, MappingObject mappingObject) {
        View view = this.clickedView;
        if (view == null) {
            return;
        }
        switch (view.getId()) {
            case R.id.holder1_spinner /* 2131363061 */:
                selectWindowType(mappingObject);
                return;
            case R.id.holder1_title /* 2131363062 */:
            case R.id.holder2_title /* 2131363064 */:
            case R.id.holder3_title /* 2131363066 */:
            default:
                return;
            case R.id.holder2_spinner /* 2131363063 */:
                selectSourceA(mappingObject);
                return;
            case R.id.holder3_spinner /* 2131363065 */:
                selectSourceB(mappingObject);
                return;
            case R.id.holder4_spinner /* 2131363067 */:
                selectSourceC(mappingObject);
                return;
        }
    }

    public /* synthetic */ void lambda$new$8$MultiWindowPopupView(View view, RecyclerView.ViewHolder viewHolder, int i) {
        if (i == -1) {
            return;
        }
        if (!KtUtilKt.windowTypeEnable(this.diagramTypes.get(i), this.optionParam)) {
            ToastUtils.showLong(this.context.getResources().getString(R.string.msg_opt_lic_unusable));
            return;
        }
        this.diagramListAdapter.setCurrentItem(i);
        this.diagramListAdapter.notifyDataSetChanged();
        this.resultTableListAdapter.setCurrentItemForce(-1);
        this.resultTableListAdapter.notifyDataSetChanged();
        updateWindowType(this.diagramTypes.get(i));
        refreshUI();
    }

    public /* synthetic */ void lambda$new$9$MultiWindowPopupView(View view, RecyclerView.ViewHolder viewHolder, int i) {
        if (i == -1) {
            return;
        }
        if (!KtUtilKt.windowTypeEnable(this.resultTableTypes.get(i), this.optionParam)) {
            ToastUtils.showLong(this.context.getResources().getString(R.string.msg_opt_lic_unusable));
            return;
        }
        this.diagramListAdapter.setCurrentItemForce(-1);
        this.diagramListAdapter.notifyDataSetChanged();
        this.resultTableListAdapter.setCurrentItem(i);
        this.resultTableListAdapter.notifyDataSetChanged();
        updateWindowType(this.resultTableTypes.get(i));
        refreshUI();
    }

    private void updateWindowType(ServiceEnum.WindowType windowType) {
        if (windowType == ServiceEnum.WindowType.WIN_MATH) {
            this.sourceArrayId.set(R.array.msg_math_s32aritha);
        } else if (windowType == ServiceEnum.WindowType.WIN_FFT) {
            this.sourceArrayId.set(R.array.msg_fft_src);
        } else if (windowType == ServiceEnum.WindowType.WIN_EYE) {
            this.sourceArrayId.set(R.array.msg_eye_source);
        } else {
            this.sourceArrayId.set(R.array.msg_chan_list);
        }
        boolean z = false;
        if (windowType == ServiceEnum.WindowType.WIN_MATH) {
            this.typeArrayId.set(R.array.msg_math_list);
        } else if (windowType == ServiceEnum.WindowType.WIN_DECODE) {
            this.typeArrayId.set(R.array.msg_decode_list);
        } else {
            this.typeArrayId.set(0);
        }
        if (windowType == ServiceEnum.WindowType.WIN_XY) {
            this.param.setServiceID(56);
            this.param.setSource1(ServiceEnum.Chan.chan1);
            this.param.setSource2(ServiceEnum.Chan.chan2);
        } else if (windowType == ServiceEnum.WindowType.WIN_MATH) {
            this.param.setServiceID(17);
            this.param.setSource1(ServiceEnum.Chan.chan1);
            this.param.setSource2(ServiceEnum.Chan.chan2);
        } else if (windowType == ServiceEnum.WindowType.WIN_FFT) {
            this.param.setServiceID(50);
            this.param.setSource1(ServiceEnum.Chan.chan1);
        } else if (windowType == ServiceEnum.WindowType.WIN_EYE) {
            this.param.setServiceID(51);
            this.param.setSource1(ServiceEnum.Chan.chan1);
        } else if (windowType == ServiceEnum.WindowType.WIN_MEASURE) {
            this.param.setServiceID(28);
        } else if (windowType == ServiceEnum.WindowType.WIN_ALL_MEASURE) {
            this.param.setServiceID(28);
            this.param.setSource1(ServiceEnum.Chan.chan1);
        } else if (windowType == ServiceEnum.WindowType.WIN_SEARCH) {
            this.param.setServiceID(25);
            this.param.setSource1(ServiceEnum.Chan.chan1);
        } else if (windowType == ServiceEnum.WindowType.WIN_DECODE) {
            this.param.setServiceID(42);
            this.param.setSource1(ServiceEnum.Chan.chan1);
        }
        this.showSource1.set((windowType == ServiceEnum.WindowType.WIN_MAIN_WAVEFORM || windowType == ServiceEnum.WindowType.WIN_MEASURE || windowType == ServiceEnum.WindowType.WIN_DECODE) ? false : true);
        this.showSource2.set(windowType == ServiceEnum.WindowType.WIN_XY || windowType == ServiceEnum.WindowType.WIN_MATH);
        this.showSource3.set(ViewUtil.filterChan(ViewUtil.getList(this.sourceArrayId.get())).size() == 4 && windowType == ServiceEnum.WindowType.WIN_XY);
        ObservableBoolean observableBoolean = this.showType;
        if (windowType == ServiceEnum.WindowType.WIN_MATH || windowType == ServiceEnum.WindowType.WIN_DECODE) {
            z = true;
        }
        observableBoolean.set(z);
        if (!this.showSource1.get()) {
            this.param.setSource1(ServiceEnum.Chan.chan_none);
        }
        if (!this.showSource2.get()) {
            this.param.setSource2(ServiceEnum.Chan.chan_none);
        }
        if (!this.showSource3.get()) {
            this.param.setSource3(ServiceEnum.Chan.chan_none);
        }
        this.param.setType(windowType);
    }

    private void refreshUI() {
        this.okButtonEnable.set(true);
        this.uiEnable.set(true);
        ServiceEnum.WindowType type = this.param.getType();
        switch (AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[type.ordinal()]) {
            case 1:
                if (FunctionManager.getInstance().checkUltraIsOpen()) {
                    this.okButtonEnable.set(false);
                    this.uiEnable.set(false);
                    return;
                } else if (WindowHolderManager.getInstance().size(ServiceEnum.WindowType.WIN_XY) >= 1) {
                    this.uiEnable.set(false);
                    return;
                } else {
                    return;
                }
            case 2:
                if (FunctionManager.getInstance().checkUltraIsOpen()) {
                    this.okButtonEnable.set(false);
                    this.uiEnable.set(false);
                    return;
                } else if (StateManager.INSTANCE.getState(ServiceEnum.WindowType.WIN_DECODE, 1, this.param.getServiceID() - 42)) {
                    this.okButtonEnable.set(false);
                    return;
                } else {
                    return;
                }
            case 3:
                this.okButtonEnable.set(WindowHolderManager.getInstance().size(ServiceEnum.WindowType.WIN_MATH, this.param.getServiceID()) < 1);
                return;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                this.uiEnable.set(WindowHolderManager.getInstance().size(type) < 1);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.multi.MultiWindowPopupView$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType;

        static {
            int[] iArr = new int[ServiceEnum.WindowType.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType = iArr;
            try {
                iArr[ServiceEnum.WindowType.WIN_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_DECODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_MATH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_ALL_MEASURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_FFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_MEASURE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_SEARCH.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_EYE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EyeParam value;
        MathParam mathParam;
        MathParam mathParam2;
        if (view.getId() == R.id.holder2_spinner) {
            if (this.param.getType() == ServiceEnum.WindowType.WIN_XY) {
                ViewUtil.showStateChanSpinner(this.anchor, view, ViewUtil.filterChan(ViewUtil.getList(this.sourceArrayId.get())), StateManager.INSTANCE.getColumnState(ServiceEnum.WindowType.WIN_XY, 2, this.param.getSource2().value1 - ServiceEnum.Chan.chan1.value1), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$73sqNRzTcyAGht565cCy1j4qwZA
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                        MultiWindowPopupView.this.lambda$onClick$10$MultiWindowPopupView(popupSpinner, spinnerAdapter, list, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$CbsA7ItMmYB54fIOA8rlEpxw1G8
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        MultiWindowPopupView.this.lambda$onClick$11$MultiWindowPopupView(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
            } else if (this.param.getType() == ServiceEnum.WindowType.WIN_MATH) {
                if (this.mathParamList != null && this.param.getServiceID() >= 17 && this.param.getServiceID() <= 20 && (mathParam2 = this.mathParamList.get(this.param.getServiceID() - 17)) != null) {
                    ViewUtil.showChanSpinner(this.anchor, view, ViewUtil.filterChan(mathParam2.getSpinnerList(this.param.getServiceID(), this.sourceArrayId.get())), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$n5YlPvwVZhcUBR75GDwvMHb7Mzo
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            MultiWindowPopupView.this.lambda$onClick$12$MultiWindowPopupView(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$kV_2EMbDjL6Ml3K9pA92n-sqVoU
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            MultiWindowPopupView.this.lambda$onClick$13$MultiWindowPopupView(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                }
            } else {
                ViewUtil.showChanSpinner(this.anchor, view, ViewUtil.filterChan(ViewUtil.getList(this.sourceArrayId.get())), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$BIDlnCmg0JfXmX8maIsZ3dkX-y4
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                        MultiWindowPopupView.this.lambda$onClick$14$MultiWindowPopupView(popupSpinner, spinnerAdapter, list, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$_P9RKgqJsShnJpYXipXg0AAtyBM
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        MultiWindowPopupView.this.lambda$onClick$15$MultiWindowPopupView(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
            }
        } else if (view.getId() == R.id.holder3_spinner) {
            if (this.param.getType() == ServiceEnum.WindowType.WIN_XY) {
                ViewUtil.showStateChanSpinner(this.anchor, view, ViewUtil.filterChan(ViewUtil.getList(this.sourceArrayId.get())), StateManager.INSTANCE.getSource2State(ServiceEnum.WindowType.WIN_XY, 2, this.param.getSource1().value1 - ServiceEnum.Chan.chan1.value1), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$Vlz8_KxB29jcaucgC4dfniuYFSY
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                        MultiWindowPopupView.this.lambda$onClick$16$MultiWindowPopupView(popupSpinner, spinnerAdapter, list, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$VT-qXIT9M01vdvBjmQvm9aVkMf8
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        MultiWindowPopupView.this.lambda$onClick$17$MultiWindowPopupView(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
            } else if (this.param.getType() == ServiceEnum.WindowType.WIN_MATH) {
                if (this.mathParamList != null && this.param.getServiceID() >= 17 && this.param.getServiceID() <= 20 && (mathParam = this.mathParamList.get(this.param.getServiceID() - 17)) != null) {
                    List<MappingObject> filterChan = ViewUtil.filterChan(mathParam.getSpinnerList(this.param.getServiceID(), this.sourceArrayId.get()));
                    this.clickedView = view;
                    this.mappingObjects = filterChan;
                    ViewUtil.showChanSpinner(this.anchor, view, filterChan, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$TGTbd-2lkXNgjbcGAfqQcdqt_io
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            MultiWindowPopupView.this.lambda$onClick$18$MultiWindowPopupView(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$i12zFyMCxz6wqj8ZbZMichSwT_4
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            MultiWindowPopupView.this.lambda$onClick$19$MultiWindowPopupView(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                }
            } else {
                List<MappingObject> list = ViewUtil.getList(this.sourceArrayId.get());
                this.clickedView = view;
                this.mappingObjects = list;
                ViewUtil.showChanSpinner(this.anchor, view, list, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$TCBrqfwAhDx_i7yvFjtbyAx3V3U
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                        MultiWindowPopupView.this.lambda$onClick$20$MultiWindowPopupView(popupSpinner, spinnerAdapter, list2, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$ZGimepguoSz-b08oBh6QmSzWiDk
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        MultiWindowPopupView.this.lambda$onClick$21$MultiWindowPopupView(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
            }
        } else if (view.getId() == R.id.holder4_spinner) {
            List<MappingObject> list2 = ViewUtil.getList((int) R.array.msg_chan_list2);
            this.clickedView = view;
            this.mappingObjects = list2;
            ViewUtil.showChanSpinner(this.anchor, view, list2, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$iHOoBqHcudSj8d50G2i-2IjR6SI
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list3, View view2) {
                    MultiWindowPopupView.this.lambda$onClick$22$MultiWindowPopupView(popupSpinner, spinnerAdapter, list3, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$s061m2n9xCv4L1fchNNgzCwcyL0
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    MultiWindowPopupView.this.lambda$onClick$23$MultiWindowPopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (view.getId() == R.id.holder1_spinner) {
            if (this.param.getType() == ServiceEnum.WindowType.WIN_MATH) {
                List<MappingObject> list3 = ViewUtil.getList((int) R.array.msg_math_list);
                this.clickedView = view;
                this.mappingObjects = list3;
                ViewUtil.showColorSpinner(this.anchor, view, list3, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$zgm8OZ32E1wiqGnBi4ATKJgv3-4
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list4, View view2) {
                        MultiWindowPopupView.this.lambda$onClick$24$MultiWindowPopupView(popupSpinner, spinnerAdapter, list4, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$QJFTtFsEVoO60DyGPUhBAIlTUDk
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        MultiWindowPopupView.this.lambda$onClick$25$MultiWindowPopupView(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
            } else if (this.param.getType() == ServiceEnum.WindowType.WIN_DECODE) {
                List<MappingObject> list4 = ViewUtil.getList((int) R.array.msg_decode_list);
                this.clickedView = view;
                this.mappingObjects = list4;
                ViewUtil.showColorSpinner(this.anchor, view, list4, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$qM-0-nJmlFGhqVR-APZ8qLFrhdE
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list5, View view2) {
                        MultiWindowPopupView.this.lambda$onClick$26$MultiWindowPopupView(popupSpinner, spinnerAdapter, list5, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.multi.-$$Lambda$MultiWindowPopupView$5t0yagHDcVtXeHz8mn2kUfAKZ5Q
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        MultiWindowPopupView.this.lambda$onClick$27$MultiWindowPopupView(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
            }
        } else if (view.getId() == R.id.ok_button) {
            if (this.param.getType() == ServiceEnum.WindowType.WIN_MATH) {
                MathParam mathItem = ViewUtil.getMathItem(this.mathParamList, this.param.getServiceID() - 17);
                if (mathItem != null) {
                    mathItem.saveStatus(true);
                    mathItem.saveSourceArithA(this.param.getSource1());
                    mathItem.saveSourceArithB(this.param.getSource2());
                }
            } else if (this.param.getType() == ServiceEnum.WindowType.WIN_FFT) {
                FftParam fftParam = this.fftParam;
                if (fftParam != null) {
                    fftParam.saveSrc(this.param.getSource1());
                    this.fftParam.saveEnable(true);
                }
            } else if (this.param.getType() == ServiceEnum.WindowType.WIN_DECODE) {
                DecodeParam decodeItem = ViewUtil.getDecodeItem(this.decodeParamList, this.param.getServiceID() - 42);
                if (decodeItem != null) {
                    if (!decodeItem.isOnOff()) {
                        decodeItem.saveOnOff(true);
                    }
                    if (!decodeItem.isEvent()) {
                        decodeItem.saveEvent(true);
                    }
                }
            } else if (this.param.getType() == ServiceEnum.WindowType.WIN_ALL_MEASURE) {
                MeasureSettingParam measureSettingParam = this.measureSettingParam;
                if (measureSettingParam != null) {
                    measureSettingParam.saveMeasureAllSrc(this.param.getSource1());
                }
            } else if (this.param.getType() == ServiceEnum.WindowType.WIN_EYE) {
                EyeViewModel eyeViewModel = (EyeViewModel) ContextUtil.getAppViewModel(EyeViewModel.class);
                if (eyeViewModel != null && (value = eyeViewModel.getLiveData().getValue()) != null) {
                    value.getChan().save(Integer.valueOf(this.param.getSource1().value1));
                    value.getEnabled().save(true);
                }
            } else if (this.param.getType() == ServiceEnum.WindowType.WIN_XY) {
                XYViewModel xYViewModel = (XYViewModel) ContextUtil.getAppViewModel(XYViewModel.class);
                xYViewModel.getLiveData().getValue().getSourceA().save(Integer.valueOf(this.param.getSource1().value1));
                xYViewModel.getLiveData().getValue().getSourceB().save(Integer.valueOf(this.param.getSource2().value1));
                WindowParam windowParam = new WindowParam();
                windowParam.setType(this.param.getType());
                windowParam.setServiceID(this.param.getServiceID());
                windowParam.setSource1(this.param.getSource1());
                windowParam.setSource2(this.param.getSource2());
                windowParam.setSource3(this.param.getSource3());
                if (this.context instanceof MainActivity) {
                    ((MainActivity) this.context).getWaveformFragment().addWindow(windowParam);
                }
            } else if (this.param.getType() == ServiceEnum.WindowType.WIN_MEASURE) {
                WindowParam windowParam2 = new WindowParam();
                windowParam2.setType(this.param.getType());
                windowParam2.setServiceID(this.param.getServiceID());
                windowParam2.setSource1(this.param.getSource1());
                windowParam2.setSource2(this.param.getSource2());
                windowParam2.setSource3(this.param.getSource3());
                if (this.context instanceof MainActivity) {
                    ((MainActivity) this.context).getWaveformFragment().addWindow(windowParam2);
                }
            } else if (this.param.getType() == ServiceEnum.WindowType.WIN_MAIN_WAVEFORM) {
                WindowParam windowParam3 = new WindowParam();
                windowParam3.setType(this.param.getType());
                if (this.context instanceof MainActivity) {
                    ((MainActivity) this.context).getWaveformFragment().addWindow(windowParam3);
                }
            }
            dismiss();
        }
    }

    public /* synthetic */ void lambda$onClick$10$MultiWindowPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$11$MultiWindowPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceA(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$12$MultiWindowPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$13$MultiWindowPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceA(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$14$MultiWindowPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$15$MultiWindowPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceA(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$16$MultiWindowPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$17$MultiWindowPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceB(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$18$MultiWindowPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$19$MultiWindowPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceB(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$20$MultiWindowPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$21$MultiWindowPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceB(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$22$MultiWindowPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$23$MultiWindowPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceC(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$24$MultiWindowPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$25$MultiWindowPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectWindowType(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$26$MultiWindowPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$27$MultiWindowPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectWindowType(mappingObject);
    }

    private void selectWindowType(MappingObject mappingObject) {
        if (this.param.getType() == ServiceEnum.WindowType.WIN_MATH) {
            if (mappingObject != null) {
                this.param.setServiceID(mappingObject.getValue());
                int i = this.param.getSource1().value1;
                int i2 = this.param.getSource2().value1;
                if (i >= ServiceEnum.Chan.m1.value1 && i <= ServiceEnum.Chan.m4.value1 && this.param.getServiceID() - 17 <= i - ServiceEnum.Chan.m1.value1) {
                    this.param.setSource1(ServiceEnum.Chan.chan1);
                }
                if (i2 >= ServiceEnum.Chan.m1.value1 && i2 <= ServiceEnum.Chan.m4.value1 && this.param.getServiceID() - 17 <= i2 - ServiceEnum.Chan.m1.value1) {
                    this.param.setSource2(ServiceEnum.Chan.chan2);
                }
            }
        } else if (this.param.getType() == ServiceEnum.WindowType.WIN_DECODE && mappingObject != null) {
            this.param.setServiceID(mappingObject.getValue());
        }
        refreshUI();
    }

    private void selectSourceC(MappingObject mappingObject) {
        ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(mappingObject.getValue());
        if (chanFromValue1 != null) {
            this.param.setSource3(chanFromValue1);
        }
    }

    private void selectSourceB(MappingObject mappingObject) {
        ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(mappingObject.getValue());
        if (chanFromValue1 != null) {
            this.param.setSource2(chanFromValue1);
            refreshUI();
        }
    }

    private void selectSourceA(MappingObject mappingObject) {
        ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(mappingObject.getValue());
        if (chanFromValue1 != null) {
            this.param.setSource1(chanFromValue1);
        }
        if (this.param.getType() == ServiceEnum.WindowType.WIN_XY) {
            refreshUI();
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        if (this.context instanceof MainActivity) {
            List<WindowHolder> list = WindowHolderManager.getInstance().get(ServiceEnum.WindowType.WIN_MAIN_WAVEFORM);
            if (list == null || list.isEmpty()) {
                if (!this.diagramTypes.contains(ServiceEnum.WindowType.WIN_MAIN_WAVEFORM)) {
                    this.diagramTypes.add(ServiceEnum.WindowType.WIN_MAIN_WAVEFORM);
                }
            } else {
                this.diagramTypes.remove(ServiceEnum.WindowType.WIN_MAIN_WAVEFORM);
            }
            this.diagramListAdapter.setItems(this.diagramTypes);
            this.diagramListAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        reset();
        notifyDataSetChanged();
        super.showAtLocation(view, i, i2, i3);
        refreshUI();
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        reset();
        notifyDataSetChanged();
        super.showAsDropDown(view, i, i2, i3);
        refreshUI();
    }

    private void reset() {
        this.okButtonEnable.set(true);
        this.uiEnable.set(true);
        this.param.setSource1(ServiceEnum.Chan.chan1);
        this.param.setSource2(ServiceEnum.Chan.chan2);
        this.param.setSource3(ServiceEnum.Chan.chan_none);
        this.param.setType(ServiceEnum.WindowType.WIN_XY);
        updateWindowType(this.param.getType());
        this.diagramListAdapter.setCurrentItem(0);
        this.resultTableListAdapter.setCurrentItemForce(-1);
        this.diagramListAdapter.notifyDataSetChanged();
        this.resultTableListAdapter.notifyDataSetChanged();
    }

    private void resetUIEnable() {
        this.uiEnable.set(true);
    }
}
