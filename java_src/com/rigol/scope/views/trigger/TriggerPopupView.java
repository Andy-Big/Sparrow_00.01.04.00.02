package com.rigol.scope.views.trigger;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.adapters.Trigger1553bAdapter;
import com.rigol.scope.adapters.TriggerCanAdapter;
import com.rigol.scope.adapters.TriggerDelayAdapter;
import com.rigol.scope.adapters.TriggerDurationAdapter;
import com.rigol.scope.adapters.TriggerEdgeAdapter;
import com.rigol.scope.adapters.TriggerFlexrayAdapter;
import com.rigol.scope.adapters.TriggerI2cAdapter;
import com.rigol.scope.adapters.TriggerI2sAdapter;
import com.rigol.scope.adapters.TriggerLinAdapter;
import com.rigol.scope.adapters.TriggerNthAdapter;
import com.rigol.scope.adapters.TriggerOverAdapter;
import com.rigol.scope.adapters.TriggerPatternAdapter;
import com.rigol.scope.adapters.TriggerPulseAdapter;
import com.rigol.scope.adapters.TriggerRs232Adapter;
import com.rigol.scope.adapters.TriggerRuntAdapter;
import com.rigol.scope.adapters.TriggerSetupHoldAdapter;
import com.rigol.scope.adapters.TriggerSlopeAdapter;
import com.rigol.scope.adapters.TriggerSpiAdapter;
import com.rigol.scope.adapters.TriggerTimeoutAdapter;
import com.rigol.scope.adapters.TriggerVideoAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.OptionParam;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.databinding.PopupviewTriggerBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.KtUtilKt;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.OptionViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.TriggerViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.scope.views.vertical.VerticalPopupView;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
/* loaded from: classes2.dex */
public class TriggerPopupView extends BasePopupView implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final int Trigger1553B;
    private final int TriggerCAN;
    private final int TriggerDelay;
    private final int TriggerDuration;
    private final int TriggerEdge;
    private final int TriggerFlexRay;
    private final int TriggerI2C;
    private final int TriggerI2S;
    private final int TriggerLIN;
    private final int TriggerNthEdge;
    private final int TriggerOver;
    private final int TriggerPattern;
    private final int TriggerPulse;
    private final int TriggerRS232;
    private final int TriggerRunt;
    private final int TriggerSPI;
    private final int TriggerSetupHold;
    private final int TriggerSlope;
    private final int TriggerTimeout;
    private final int TriggerVideo;
    private AorBManager aorBManager;
    private PopupviewTriggerBinding binding;
    private View clickedView;
    private boolean isEnable;
    private List<AorBParam> list_aorbParam;
    private List<MappingObject> mappingObjects;
    private OptionParam optionParam;
    private PanelKeyViewModel panelKeyViewModel;
    private TriggerParam param;
    private PopupSpinner popupSpinner;
    private int serviceId;
    private SpinnerAdapter spinnerAdapter;
    Trigger1553bAdapter trigger1553bAdapter;
    TriggerCanAdapter triggerCanAdapter;
    TriggerDelayAdapter triggerDelayAdapter;
    TriggerDurationAdapter triggerDurationAdapter;
    TriggerEdgeAdapter triggerEdgeAdapter;
    TriggerFlexrayAdapter triggerFlexrayAdapter;
    TriggerI2cAdapter triggerI2cAdapter;
    TriggerI2sAdapter triggerI2sAdapter;
    TriggerLinAdapter triggerLinAdapter;
    TriggerNthAdapter triggerNthAdapter;
    TriggerOverAdapter triggerOverAdapter;
    TriggerPatternAdapter triggerPatternAdapter;
    TriggerPulseAdapter triggerPulseAdapter;
    TriggerRs232Adapter triggerRs232Adapter;
    TriggerRuntAdapter triggerRuntAdapter;
    TriggerSetupHoldAdapter triggerSetupHoldAdapter;
    TriggerSlopeAdapter triggerSlopeAdapter;
    TriggerSpiAdapter triggerSpiAdapter;
    TriggerTimeoutAdapter triggerTimeoutAdapter;
    TriggerVideoAdapter triggerVideoAdapter;
    private TriggerViewModel triggerViewModel;

    public void setSharedViewModel(SharedViewModel sharedViewModel) {
    }

    public TriggerParam getParam() {
        return this.param;
    }

    public TriggerPopupView() {
        super((int) R.style.App_PopupWindow_Trigger);
        this.serviceId = 41;
        this.TriggerEdge = 0;
        this.TriggerPulse = 1;
        this.TriggerSlope = 2;
        this.TriggerVideo = 3;
        this.TriggerPattern = 4;
        this.TriggerDuration = 5;
        this.TriggerTimeout = 6;
        this.TriggerRunt = 7;
        this.TriggerOver = 8;
        this.TriggerDelay = 9;
        this.TriggerSetupHold = 10;
        this.TriggerNthEdge = 11;
        this.TriggerRS232 = 12;
        this.TriggerI2C = 13;
        this.TriggerSPI = 14;
        this.TriggerCAN = 15;
        this.TriggerFlexRay = 16;
        this.TriggerLIN = 17;
        this.TriggerI2S = 18;
        this.Trigger1553B = 19;
        this.list_aorbParam = new ArrayList();
        this.isEnable = true;
        TriggerViewModel triggerViewModel = (TriggerViewModel) ContextUtil.getAppViewModel(TriggerViewModel.class);
        this.triggerViewModel = triggerViewModel;
        if (this.param == null && triggerViewModel != null) {
            triggerViewModel.getLiveData();
            this.param = this.triggerViewModel.getLiveData().getValue();
        }
        OptionViewModel optionViewModel = (OptionViewModel) ContextUtil.getAppViewModel(OptionViewModel.class);
        if (optionViewModel != null) {
            optionViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$SWR8HPPKpgoiaBPH6vhpnx2C0vA
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TriggerPopupView.this.lambda$new$0$TriggerPopupView((OptionParam) obj);
                }
            });
        }
        PopupviewTriggerBinding inflate = PopupviewTriggerBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        this.binding.forceTrigger.setOnClickListener(this);
        this.binding.verticalSetting.setOnClickListener(this);
        this.binding.autoRadioButton.setOnCheckedChangeListener(this);
        this.binding.normalRadioButton.setOnCheckedChangeListener(this);
        this.binding.singleRadioButton.setOnCheckedChangeListener(this);
        this.binding.triggerType.setOnClickListener(this);
        this.triggerViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer<TriggerParam>() { // from class: com.rigol.scope.views.trigger.TriggerPopupView.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(TriggerParam triggerParam) {
                TriggerPopupView.this.param = triggerParam;
                TriggerPopupView.this.param.setServiceId(TriggerPopupView.this.param.getServiceID(TriggerPopupView.this.param.getTriggerMode()));
                TriggerPopupView.this.binding.setParam(TriggerPopupView.this.param);
                TriggerPopupView triggerPopupView = TriggerPopupView.this;
                triggerPopupView.showTrigger(triggerPopupView.param.getTriggerMode());
            }
        });
        this.list_aorbParam.add(new AorBParam(this.binding.triggerType, 0, false, "", 2));
        this.aorBManager = new AorBManager(this.context, this.list_aorbParam) { // from class: com.rigol.scope.views.trigger.TriggerPopupView.2
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
            }
        };
        PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
        this.panelKeyViewModel = panelKeyViewModel;
        if (panelKeyViewModel != null) {
            panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$Uh1OCD5GIsL5--vV7Qjz2AsgAwQ
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TriggerPopupView.this.lambda$new$1$TriggerPopupView((KeyEvent) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$TriggerPopupView(OptionParam optionParam) {
        this.optionParam = optionParam;
    }

    public /* synthetic */ void lambda$new$1$TriggerPopupView(KeyEvent keyEvent) {
        PopupSpinner popupSpinner;
        List<MappingObject> list;
        if (this.isEnable && PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (popupSpinner = this.popupSpinner) != null && popupSpinner.isShowing() && (list = this.mappingObjects) != null) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, list, this.spinnerAdapter, this.aorBManager, null, null, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$MJjLya1zPVZztwYGjvXJXujxTkU
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    TriggerPopupView.this.selectAdapter(i, mappingObject);
                }
            });
        }
    }

    private void initData() {
        TriggerViewModel triggerViewModel;
        if (this.param == null && (triggerViewModel = this.triggerViewModel) != null) {
            triggerViewModel.getLiveData();
            this.param = this.triggerViewModel.getLiveData().getValue();
        }
        if (this.param != null) {
            if (this.triggerEdgeAdapter == null) {
                this.triggerEdgeAdapter = new TriggerEdgeAdapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.triggerEdgeAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$F1hE7F7-4mNjS4LREFmmaVBOLkU
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$2$TriggerPopupView(z);
                }
            });
            if (this.triggerPulseAdapter == null) {
                this.triggerPulseAdapter = new TriggerPulseAdapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.triggerPulseAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$SRCZLxD2JqVzBx9Kw2SuJUdsm28
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$3$TriggerPopupView(z);
                }
            });
            if (this.triggerSlopeAdapter == null) {
                this.triggerSlopeAdapter = new TriggerSlopeAdapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.triggerSlopeAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$Z6Qrsq2vc1HtcjOn4gDv15NC2RQ
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$4$TriggerPopupView(z);
                }
            });
            if (this.triggerVideoAdapter == null) {
                this.triggerVideoAdapter = new TriggerVideoAdapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.triggerVideoAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$FUUBFZ4C5eQCyfEabDIpkT0GQO8
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$5$TriggerPopupView(z);
                }
            });
            if (this.triggerPatternAdapter == null) {
                this.triggerPatternAdapter = new TriggerPatternAdapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.triggerPatternAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$OK6KmqdqJjejG8BTPMftGY4GY3w
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$6$TriggerPopupView(z);
                }
            });
            if (this.triggerDurationAdapter == null) {
                this.triggerDurationAdapter = new TriggerDurationAdapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.triggerDurationAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$WVHJn9LXsefqag9tH0s0KtGwvtA
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$7$TriggerPopupView(z);
                }
            });
            if (this.triggerTimeoutAdapter == null) {
                this.triggerTimeoutAdapter = new TriggerTimeoutAdapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.triggerTimeoutAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$HcRFH2g1QfBwo5FJlB10cM9lzCc
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$8$TriggerPopupView(z);
                }
            });
            if (this.triggerRuntAdapter == null) {
                this.triggerRuntAdapter = new TriggerRuntAdapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.triggerRuntAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$4fu_wSqaQu5lbkzbzHSLlHUzqsY
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$9$TriggerPopupView(z);
                }
            });
            if (this.triggerOverAdapter == null) {
                this.triggerOverAdapter = new TriggerOverAdapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.triggerOverAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$Bxz2twjRb4Ds7btHFqQZK00jGDQ
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$10$TriggerPopupView(z);
                }
            });
            if (this.triggerDelayAdapter == null) {
                this.triggerDelayAdapter = new TriggerDelayAdapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.triggerDelayAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$sG9bL-2TTLoCFKte4sCCCoyyETY
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$11$TriggerPopupView(z);
                }
            });
            if (this.triggerSetupHoldAdapter == null) {
                this.triggerSetupHoldAdapter = new TriggerSetupHoldAdapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.triggerSetupHoldAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$b7UnObMuNcpNYiVkZkIHkzgSwzo
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$12$TriggerPopupView(z);
                }
            });
            if (this.triggerNthAdapter == null) {
                this.triggerNthAdapter = new TriggerNthAdapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.triggerNthAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$-knEWjo2uq_swi6Q3E-SE426Jk0
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$13$TriggerPopupView(z);
                }
            });
            if (this.triggerRs232Adapter == null) {
                this.triggerRs232Adapter = new TriggerRs232Adapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.triggerRs232Adapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$1_o35GWsQxE2aY3CEmzHNYhM_7A
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$14$TriggerPopupView(z);
                }
            });
            if (this.triggerI2cAdapter == null) {
                this.triggerI2cAdapter = new TriggerI2cAdapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.triggerI2cAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$Mja4BWSrEmQBEPE8wH7iU5MBZr0
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$15$TriggerPopupView(z);
                }
            });
            if (this.triggerSpiAdapter == null) {
                this.triggerSpiAdapter = new TriggerSpiAdapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.triggerSpiAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$3f9txeCCDyq89PAwGVF2f2Nxc7Q
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$16$TriggerPopupView(z);
                }
            });
            if (this.triggerCanAdapter == null) {
                this.triggerCanAdapter = new TriggerCanAdapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.triggerCanAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$vFiJLn1v65p_DjBIjbnMJG4sTgw
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$17$TriggerPopupView(z);
                }
            });
            if (this.triggerFlexrayAdapter == null) {
                this.triggerFlexrayAdapter = new TriggerFlexrayAdapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.triggerFlexrayAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$LbL22BMSU121yVYqkVJzkrxrEGY
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$18$TriggerPopupView(z);
                }
            });
            if (this.triggerLinAdapter == null) {
                this.triggerLinAdapter = new TriggerLinAdapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.triggerLinAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$7xTaIj9vcdk45qYF4F6ZDUt8lnM
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$19$TriggerPopupView(z);
                }
            });
            if (this.triggerI2sAdapter == null) {
                this.triggerI2sAdapter = new TriggerI2sAdapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.triggerI2sAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$SQzcMrZhWRUi3qQsqSFfWlpIc6k
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$20$TriggerPopupView(z);
                }
            });
            if (this.trigger1553bAdapter == null) {
                this.trigger1553bAdapter = new Trigger1553bAdapter(this.context, this, this.param, this.triggerViewModel);
            }
            this.trigger1553bAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$rxFmzK9X2AWH7CiKaxjpKjC_HUs
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    TriggerPopupView.this.lambda$initData$21$TriggerPopupView(z);
                }
            });
        }
    }

    public /* synthetic */ void lambda$initData$2$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$initData$3$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$initData$4$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$initData$5$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$initData$6$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$initData$7$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$initData$8$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$initData$9$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$initData$10$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$initData$11$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$initData$12$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$initData$13$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$initData$14$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$initData$15$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$initData$16$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$initData$17$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$initData$18$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$initData$19$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$initData$20$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$initData$21$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void resetAdapterIsMove() {
        this.triggerEdgeAdapter.setMove(false);
        this.triggerPulseAdapter.setMove(false);
        this.triggerSlopeAdapter.setMove(false);
        this.triggerVideoAdapter.setMove(false);
        this.triggerPatternAdapter.setMove(false);
        this.triggerDurationAdapter.setMove(false);
        this.triggerTimeoutAdapter.setMove(false);
        this.triggerRuntAdapter.setMove(false);
        this.triggerOverAdapter.setMove(false);
        this.triggerDelayAdapter.setMove(false);
        this.triggerSetupHoldAdapter.setMove(false);
        this.triggerNthAdapter.setMove(false);
        this.triggerRs232Adapter.setMove(false);
        this.triggerI2cAdapter.setMove(false);
        this.triggerSpiAdapter.setMove(false);
        this.triggerCanAdapter.setMove(false);
        this.triggerFlexrayAdapter.setMove(false);
        this.triggerLinAdapter.setMove(false);
        this.triggerI2sAdapter.setMove(false);
        this.trigger1553bAdapter.setMove(false);
        this.param.setChannel(3);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        resetAdapter();
        super.showAtLocation(view, i, i2, i3);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        resetAdapter();
        super.showAsDropDown(view, i, i2, i3);
    }

    public void resetAdapter() {
        RecyclerView.Adapter adapter = this.binding.triggerView.getAdapter();
        if (adapter != null) {
            this.binding.triggerView.setAdapter(adapter);
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            int id = compoundButton.getId();
            if (id == R.id.auto_radio_button) {
                if (z) {
                    this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1);
                }
            } else if (id == R.id.normal_radio_button) {
                if (z) {
                    this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1);
                }
            } else if (id == R.id.single_radio_button && z) {
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.force_trigger) {
            if (this.context instanceof Activity) {
                API.getInstance().UI_PostBool(41, MessageID.MSG_TRIGGER_FORCE, true);
            }
        } else if (id != R.id.trigger_type) {
            if (id != R.id.vertical_setting) {
                return;
            }
            PopupViewManager.getInstance().show(VerticalPopupView.class);
        } else {
            this.isEnable = true;
            if (this.anchor != null) {
                ViewUtil.showSpinner(this.anchor, view, KtUtilKt.filter(ViewUtil.getList((int) R.array.msg_trigger_type), new Function1() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$mTA2lz_4av8il8hOTvFP0BMc4lg
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TriggerPopupView.this.lambda$onClick$22$TriggerPopupView((MappingObject) obj);
                    }
                }), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$b-YLFrUBwLv4ku1JcJ62bpCAAS8
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                        TriggerPopupView.this.lambda$onClick$23$TriggerPopupView(popupSpinner, spinnerAdapter, list, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$j3jx8K9ikcU6_LG-_k4kWLc81Kw
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        TriggerPopupView.this.lambda$onClick$24$TriggerPopupView(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
            }
        }
    }

    public /* synthetic */ Boolean lambda$onClick$22$TriggerPopupView(MappingObject mappingObject) {
        ServiceEnum.TriggerMode triggerModeFromValue1;
        if (mappingObject == null || (triggerModeFromValue1 = ServiceEnum.getTriggerModeFromValue1(mappingObject.getValue())) == null) {
            return true;
        }
        if (ViewUtil.isDoubleChan() && triggerModeFromValue1.value1 == ServiceEnum.TriggerMode.Trigger_FlexRay.value1) {
            return false;
        }
        return Boolean.valueOf(KtUtilKt.triggerModeEnable(triggerModeFromValue1, this.optionParam, Boolean.valueOf(((UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class)).getValue().getSeries() == 800)));
    }

    public /* synthetic */ void lambda$onClick$23$TriggerPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$24$TriggerPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectAdapter(i, mappingObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectAdapter(int i, MappingObject mappingObject) {
        List filter = KtUtilKt.filter(ViewUtil.getList((int) R.array.msg_trigger_type), new Function1() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$lZP4tj2L-hUSdjlxJtEd8-YO4BY
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TriggerPopupView.this.lambda$selectAdapter$25$TriggerPopupView((MappingObject) obj);
            }
        });
        ServiceEnum.TriggerMode triggerModeFromValue1 = ServiceEnum.getTriggerModeFromValue1(mappingObject.getValue());
        this.param.setServiceId(this.serviceId);
        if (this.param != null) {
            API.getInstance().UI_PostInt32(this.serviceId, MessageID.MSG_TRIGGER_TYPE, ((MappingObject) filter.get(i)).getValue());
            this.param.setTriggerMode(triggerModeFromValue1);
            showTrigger(triggerModeFromValue1);
        }
    }

    public /* synthetic */ Boolean lambda$selectAdapter$25$TriggerPopupView(MappingObject mappingObject) {
        ServiceEnum.TriggerMode triggerModeFromValue1;
        if (mappingObject == null || (triggerModeFromValue1 = ServiceEnum.getTriggerModeFromValue1(mappingObject.getValue())) == null) {
            return true;
        }
        if (ViewUtil.isDoubleChan() && triggerModeFromValue1.value1 == ServiceEnum.TriggerMode.Trigger_FlexRay.value1) {
            return false;
        }
        return Boolean.valueOf(KtUtilKt.triggerModeEnable(triggerModeFromValue1, this.optionParam, Boolean.valueOf(((UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class)).getValue().getSeries() == 800)));
    }

    public void showTrigger(ServiceEnum.TriggerMode triggerMode) {
        test(triggerMode);
        PopupViewManager.getInstance().triggerLight(this);
    }

    private void test(ServiceEnum.TriggerMode triggerMode) {
        initData();
        resetAdapterIsMove();
        if (triggerMode != ServiceEnum.TriggerMode.Trigger_Edge) {
            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP1_LED_WHITE.value1, 0);
            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP2_LED_WHITE.value1, 0);
        } else if (this.param.getEdgeSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Any) {
            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP1_LED_WHITE.value1, 1);
            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP2_LED_WHITE.value1, 1);
        } else if (this.param.getEdgeSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Falling) {
            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP1_LED_WHITE.value1, 0);
            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP2_LED_WHITE.value1, 1);
        } else {
            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP2_LED_WHITE.value1, 0);
            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP1_LED_WHITE.value1, 1);
        }
        switch (AnonymousClass3.$SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[triggerMode.ordinal()]) {
            case 1:
                this.triggerEdgeAdapter.setMove(true);
                this.binding.triggerView.setAdapter(this.triggerEdgeAdapter);
                return;
            case 2:
                this.triggerPulseAdapter.setMove(true);
                this.binding.triggerView.setAdapter(this.triggerPulseAdapter);
                return;
            case 3:
                this.triggerSlopeAdapter.setMove(true);
                this.binding.triggerView.setAdapter(this.triggerSlopeAdapter);
                return;
            case 4:
                this.triggerVideoAdapter.setMove(true);
                this.binding.triggerView.setAdapter(this.triggerVideoAdapter);
                return;
            case 5:
                this.triggerPatternAdapter.setMove(true);
                this.binding.triggerView.setAdapter(this.triggerPatternAdapter);
                return;
            case 6:
                this.triggerDurationAdapter.setMove(true);
                this.binding.triggerView.setAdapter(this.triggerDurationAdapter);
                return;
            case 7:
                this.triggerTimeoutAdapter.setMove(true);
                this.binding.triggerView.setAdapter(this.triggerTimeoutAdapter);
                return;
            case 8:
                this.triggerRuntAdapter.setMove(true);
                this.binding.triggerView.setAdapter(this.triggerRuntAdapter);
                return;
            case 9:
                this.triggerOverAdapter.setMove(true);
                this.binding.triggerView.setAdapter(this.triggerOverAdapter);
                return;
            case 10:
                this.triggerDelayAdapter.setMove(true);
                this.binding.triggerView.setAdapter(this.triggerDelayAdapter);
                return;
            case 11:
                this.triggerSetupHoldAdapter.setMove(true);
                this.binding.triggerView.setAdapter(this.triggerSetupHoldAdapter);
                return;
            case 12:
                this.triggerNthAdapter.setMove(true);
                this.binding.triggerView.setAdapter(this.triggerNthAdapter);
                return;
            case 13:
                this.triggerRs232Adapter.setMove(true);
                this.binding.triggerView.setAdapter(this.triggerRs232Adapter);
                return;
            case 14:
                this.triggerI2cAdapter.setMove(true);
                this.binding.triggerView.setAdapter(this.triggerI2cAdapter);
                return;
            case 15:
                if (this.param.getTrigger_Spi_CS() == ServiceEnum.Trigger_Spi_CS.trig_spi_cs) {
                    TriggerParam triggerParam = this.param;
                    triggerParam.saveSpiLevelC(triggerParam.getSpilevelC());
                } else {
                    TriggerParam triggerParam2 = this.param;
                    triggerParam2.saveSpiLevelB(triggerParam2.getSpilevelB());
                }
                this.triggerSpiAdapter.setMove(true);
                this.binding.triggerView.setAdapter(this.triggerSpiAdapter);
                return;
            case 16:
                this.triggerCanAdapter.setMove(true);
                this.binding.triggerView.setAdapter(this.triggerCanAdapter);
                return;
            case 17:
                this.triggerFlexrayAdapter.setMove(true);
                this.binding.triggerView.setAdapter(this.triggerFlexrayAdapter);
                return;
            case 18:
                this.triggerLinAdapter.setMove(true);
                this.binding.triggerView.setAdapter(this.triggerLinAdapter);
                return;
            case 19:
                this.triggerI2sAdapter.setMove(true);
                this.binding.triggerView.setAdapter(this.triggerI2sAdapter);
                return;
            case 20:
                this.trigger1553bAdapter.setMove(true);
                this.binding.triggerView.setAdapter(this.trigger1553bAdapter);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.trigger.TriggerPopupView$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode;

        static {
            int[] iArr = new int[ServiceEnum.TriggerMode.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode = iArr;
            try {
                iArr[ServiceEnum.TriggerMode.Trigger_Edge.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Pulse.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Slope.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Video.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Pattern.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Duration.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Timeout.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Runt.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Over.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Delay.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Setup.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_NEdge.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_RS232.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_I2C.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_SPI.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_CAN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_FlexRay.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_LIN.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_I2S.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_1553.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    private void showEdgeTrigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        TriggerEdgeAdapter triggerEdgeAdapter = new TriggerEdgeAdapter(this.context, this, triggerParam, triggerViewModel);
        triggerEdgeAdapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$tFPQoA6fc0hbgKEFHMVqEOR5V7g
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$showEdgeTrigger$26$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(triggerEdgeAdapter);
    }

    public /* synthetic */ void lambda$showEdgeTrigger$26$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void showPulseTrigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        TriggerPulseAdapter triggerPulseAdapter = new TriggerPulseAdapter(this.context, this, triggerParam, triggerViewModel);
        triggerPulseAdapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$Zdy66nUX2ZlgVOMD81TauA9hBMY
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$showPulseTrigger$27$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(triggerPulseAdapter);
    }

    public /* synthetic */ void lambda$showPulseTrigger$27$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void showSlopeTrigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        TriggerSlopeAdapter triggerSlopeAdapter = new TriggerSlopeAdapter(this.context, this, triggerParam, triggerViewModel);
        triggerSlopeAdapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$7QBWpPBTp29NSoit-PrNBZazJ4w
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$showSlopeTrigger$28$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(triggerSlopeAdapter);
    }

    public /* synthetic */ void lambda$showSlopeTrigger$28$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void showVideoTrigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        TriggerVideoAdapter triggerVideoAdapter = new TriggerVideoAdapter(this.context, this, triggerParam, triggerViewModel);
        triggerVideoAdapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$Y9dVAkeTMaC3AXU5fDj4tHJw9is
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$showVideoTrigger$29$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(triggerVideoAdapter);
    }

    public /* synthetic */ void lambda$showVideoTrigger$29$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void showPatternTrigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        TriggerPatternAdapter triggerPatternAdapter = new TriggerPatternAdapter(this.context, this, triggerParam, triggerViewModel);
        triggerPatternAdapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$dOkaVK2dtBDN-Cq1bkAbIlQbYT8
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$showPatternTrigger$30$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(triggerPatternAdapter);
    }

    public /* synthetic */ void lambda$showPatternTrigger$30$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void showDurationTrigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        TriggerDurationAdapter triggerDurationAdapter = new TriggerDurationAdapter(this.context, this, triggerParam, triggerViewModel);
        triggerDurationAdapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$TXkQC9ZFAd8eovdbrKEm2nsUd8o
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$showDurationTrigger$31$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(triggerDurationAdapter);
    }

    public /* synthetic */ void lambda$showDurationTrigger$31$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void showTimeoutTrigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        TriggerTimeoutAdapter triggerTimeoutAdapter = new TriggerTimeoutAdapter(this.context, this, triggerParam, triggerViewModel);
        triggerTimeoutAdapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$RyHziXmQe7U-nq2Z_c_dWcjQnSg
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$showTimeoutTrigger$32$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(triggerTimeoutAdapter);
    }

    public /* synthetic */ void lambda$showTimeoutTrigger$32$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void showRuntTrigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        TriggerRuntAdapter triggerRuntAdapter = new TriggerRuntAdapter(this.context, this, triggerParam, triggerViewModel);
        triggerRuntAdapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$wxgWO4zvs5OSyGhWowgASKla39Q
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$showRuntTrigger$33$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(triggerRuntAdapter);
    }

    public /* synthetic */ void lambda$showRuntTrigger$33$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void showOverTrigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        TriggerOverAdapter triggerOverAdapter = new TriggerOverAdapter(this.context, this, triggerParam, triggerViewModel);
        triggerOverAdapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$msbn-zC8n6hdTwJuCv6uJYCDxkw
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$showOverTrigger$34$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(triggerOverAdapter);
    }

    public /* synthetic */ void lambda$showOverTrigger$34$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void showDelayTrigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        TriggerDelayAdapter triggerDelayAdapter = new TriggerDelayAdapter(this.context, this, triggerParam, triggerViewModel);
        triggerDelayAdapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$QrOjGczEBta0WpSgZ5R0cKmaZH0
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$showDelayTrigger$35$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(triggerDelayAdapter);
    }

    public /* synthetic */ void lambda$showDelayTrigger$35$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void showSetupHoldTrigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        TriggerSetupHoldAdapter triggerSetupHoldAdapter = new TriggerSetupHoldAdapter(this.context, this, triggerParam, triggerViewModel);
        triggerSetupHoldAdapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$6ytZli8D-60iA7gfHAfGyNXauUA
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$showSetupHoldTrigger$36$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(triggerSetupHoldAdapter);
    }

    public /* synthetic */ void lambda$showSetupHoldTrigger$36$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void showNthTrigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        TriggerNthAdapter triggerNthAdapter = new TriggerNthAdapter(this.context, this, triggerParam, triggerViewModel);
        triggerNthAdapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$sqXjSc1ADko3KwwOuKvi7saJ5jE
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$showNthTrigger$37$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(triggerNthAdapter);
    }

    public /* synthetic */ void lambda$showNthTrigger$37$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void showRs232Trigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        TriggerRs232Adapter triggerRs232Adapter = new TriggerRs232Adapter(this.context, this, triggerParam, triggerViewModel);
        triggerRs232Adapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$q6SwYbXC_L3y3QWvCxceUvTQtHE
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$showRs232Trigger$38$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(triggerRs232Adapter);
    }

    public /* synthetic */ void lambda$showRs232Trigger$38$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void showI2cTrigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        TriggerI2cAdapter triggerI2cAdapter = new TriggerI2cAdapter(this.context, this, triggerParam, triggerViewModel);
        triggerI2cAdapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$3RuFDSQ9Trlj9hSbMDmhko4eXbw
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$showI2cTrigger$39$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(triggerI2cAdapter);
    }

    public /* synthetic */ void lambda$showI2cTrigger$39$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void showSpiTrigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        TriggerSpiAdapter triggerSpiAdapter = new TriggerSpiAdapter(this.context, this, triggerParam, triggerViewModel);
        triggerSpiAdapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$P8Jwls9yM7rW1f7Oe7MVGyxsK-E
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$showSpiTrigger$40$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(triggerSpiAdapter);
    }

    public /* synthetic */ void lambda$showSpiTrigger$40$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void showCanTrigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        TriggerCanAdapter triggerCanAdapter = new TriggerCanAdapter(this.context, this, triggerParam, triggerViewModel);
        triggerCanAdapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$1kQOVdSTZkyym8YszPlydkGdbw8
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$showCanTrigger$41$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(triggerCanAdapter);
    }

    public /* synthetic */ void lambda$showCanTrigger$41$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void showFlexrayTrigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        TriggerFlexrayAdapter triggerFlexrayAdapter = new TriggerFlexrayAdapter(this.context, this, triggerParam, triggerViewModel);
        triggerFlexrayAdapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$RDQ37WaOglaHJXs2ut3G9EVkUIU
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$showFlexrayTrigger$42$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(triggerFlexrayAdapter);
    }

    public /* synthetic */ void lambda$showFlexrayTrigger$42$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void showLinTrigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        TriggerLinAdapter triggerLinAdapter = new TriggerLinAdapter(this.context, this, triggerParam, triggerViewModel);
        triggerLinAdapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$SxaAql0aCQl3_fzL4_Yzm4-BJpo
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$showLinTrigger$43$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(triggerLinAdapter);
    }

    public /* synthetic */ void lambda$showLinTrigger$43$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void showI2sTrigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        TriggerI2sAdapter triggerI2sAdapter = new TriggerI2sAdapter(this.context, this, triggerParam, triggerViewModel);
        triggerI2sAdapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$oZE8YMnNYZtyCjuOIlAI0ATwAKU
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$showI2sTrigger$44$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(triggerI2sAdapter);
    }

    public /* synthetic */ void lambda$showI2sTrigger$44$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }

    private void show1553bTrigger(PopupviewTriggerBinding popupviewTriggerBinding, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        Trigger1553bAdapter trigger1553bAdapter = new Trigger1553bAdapter(this.context, this, triggerParam, triggerViewModel);
        trigger1553bAdapter.setListener(popupviewTriggerBinding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.trigger.-$$Lambda$TriggerPopupView$3BH8-AHN9oqLnE8VX-o3-ZTeJi8
            @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
            public final void onChange(boolean z) {
                TriggerPopupView.this.lambda$show1553bTrigger$45$TriggerPopupView(z);
            }
        });
        popupviewTriggerBinding.triggerView.setAdapter(trigger1553bAdapter);
    }

    public /* synthetic */ void lambda$show1553bTrigger$45$TriggerPopupView(boolean z) {
        this.isEnable = z;
    }
}
