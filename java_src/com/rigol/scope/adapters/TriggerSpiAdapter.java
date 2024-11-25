package com.rigol.scope.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.databinding.AdapterTriggerSpiBinding;
import com.rigol.scope.databinding.PopupviewTriggerBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.TriggerViewModel;
import com.rigol.scope.views.FormatTransformKey;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.scope.views.trigger.TriggerPopupView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TriggerSpiAdapter extends RecyclerView.Adapter<TriggerSpiHolder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterTriggerSpiBinding binding;
    private View clickedView;
    private Context context;
    private FormatTransformKey formatTransformKey;
    private boolean isMove;
    private KeyboardPopupView keyboardPopupView;
    private List<AorBParam> list_aorbParam = new ArrayList();
    private AorBManager.OnOutOrInAdapterClickChangeListener listener;
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    private TriggerParam param;
    private PopupSpinner popupSpinner;
    private BasePopupView popupView;
    private PopupviewTriggerBinding popviewTriggerBinding;
    private int serviceId;
    private SpinnerAdapter spinnerAdapter;
    private TriggerViewModel triggerViewModel;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public boolean isMove() {
        return this.isMove;
    }

    public void setMove(boolean z) {
        this.isMove = z;
    }

    public AorBManager getAorBManager() {
        return this.aorBManager;
    }

    public void setListener(PopupviewTriggerBinding popupviewTriggerBinding, AorBManager.OnOutOrInAdapterClickChangeListener onOutOrInAdapterClickChangeListener) {
        this.popviewTriggerBinding = popupviewTriggerBinding;
        this.listener = onOutOrInAdapterClickChangeListener;
    }

    public TriggerSpiAdapter(Context context, BasePopupView basePopupView, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        this.triggerViewModel = triggerViewModel;
        this.popupView = basePopupView;
        this.context = context;
        this.serviceId = triggerParam.getServiceId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TriggerSpiHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        AdapterTriggerSpiBinding inflate = AdapterTriggerSpiBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        this.binding = inflate;
        inflate.setEdgeRisingMapping(ViewUtil.getMappingObject(R.array.msg_trigger_edge_b, ServiceEnum.EdgeSlope.Trigger_Edge_Rising.value1));
        this.binding.setEdgeFallingMapping(ViewUtil.getMappingObject(R.array.msg_trigger_edge_b, ServiceEnum.EdgeSlope.Trigger_Edge_Falling.value1));
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelbValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelcValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSpiTimeoutValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSpiDatabitsValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSourceScl, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSourceSda, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSourceCs, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.TriggerSpiAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                TriggerSpiAdapter.this.aorBManager.showKey(TriggerSpiAdapter.this.context, ((AorBParam) TriggerSpiAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) TriggerSpiAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                TriggerSpiAdapter.this.aorBManager.showKey(TriggerSpiAdapter.this.context, ((AorBParam) TriggerSpiAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) TriggerSpiAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.triggerLevelValue, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.triggerLevelbValue, true, ViewUtil.KEY_B);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSpiAdapter$TJMjH2jlN1OAAGTKiZlcnJ-ug4U
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TriggerSpiAdapter.this.lambda$onCreateViewHolder$2$TriggerSpiAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new TriggerSpiHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$TriggerSpiAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (this.popviewTriggerBinding.triggerView.getAdapter() instanceof TriggerSpiAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSpiAdapter$_wEA7LeFK308Q9ZL9WQhjgneEpw
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerSpiAdapter.this.lambda$onCreateViewHolder$0$TriggerSpiAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSpiAdapter$qjHpjyT3axnupAa5YoJfbXNigos
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    TriggerSpiAdapter.this.lambda$onCreateViewHolder$1$TriggerSpiAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$TriggerSpiAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$TriggerSpiAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.trigger_source_scl) {
            selectSourceScl(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_source_sda) {
            selectSourceSda(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_source_cs) {
            selectSourceCS(mappingObject);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TriggerSpiHolder triggerSpiHolder, int i) {
        this.triggerViewModel.getLiveData().observe((LifecycleOwner) this.context, new Observer<TriggerParam>() { // from class: com.rigol.scope.adapters.TriggerSpiAdapter.2
            @Override // androidx.lifecycle.Observer
            public void onChanged(TriggerParam triggerParam) {
                TriggerSpiAdapter.this.param = triggerParam;
            }
        });
        ShowTriggerSpi();
        if (ViewUtil.isDoubleChan()) {
            this.binding.triggerSourceCs.setVisibility(8);
            this.binding.triggerSourceCsLabel.setVisibility(8);
        }
        triggerSpiHolder.binding.executePendingBindings();
    }

    public void ShowTriggerSpi() {
        ServiceEnum.Chan chan = this.param.getChan();
        if (chan == ServiceEnum.Chan.acline || chan == ServiceEnum.Chan.ext) {
            int i = ServiceEnum.Chan.chan1.value1;
            this.param.setChannel(i);
            this.param.saveSpiSourceScl(i);
        } else {
            int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SPI_SCL);
            ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(UI_QueryInt32);
            this.param.setChannel(UI_QueryInt32);
            this.param.setSpiChanA(chanFromValue1);
        }
        ServiceEnum.Chan chanB = this.param.getChanB();
        if (chanB == ServiceEnum.Chan.acline || chanB == ServiceEnum.Chan.ext) {
            API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_SPI_SDA, ServiceEnum.Chan.chan2.value1);
            int i2 = ServiceEnum.Chan.chan2.value1;
            ServiceEnum.Chan chanFromValue12 = ServiceEnum.getChanFromValue1(i2);
            this.param.setChannelB(i2);
            this.param.setSpiChanB(chanFromValue12);
            chanB = chanFromValue12;
        } else {
            int UI_QueryInt322 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SPI_SDA);
            ServiceEnum.Chan chanFromValue13 = ServiceEnum.getChanFromValue1(UI_QueryInt322);
            this.param.setChannelB(UI_QueryInt322);
            this.param.setSpiChanB(chanFromValue13);
        }
        this.param.setChanColor(this.binding.triggerSourceSda, chanB);
        ServiceEnum.Chan chanC = this.param.getChanC();
        if (chanC == ServiceEnum.Chan.acline || chanC == ServiceEnum.Chan.ext) {
            API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_SPI_CS, ServiceEnum.Chan.chan3.value1);
            int i3 = ServiceEnum.Chan.chan3.value1;
            ServiceEnum.Chan chanFromValue14 = ServiceEnum.getChanFromValue1(i3);
            this.param.setChannelC(i3);
            this.param.setSpiChanC(chanFromValue14);
            chanC = chanFromValue14;
        } else {
            int UI_QueryInt323 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SPI_CS);
            ServiceEnum.Chan chanFromValue15 = ServiceEnum.getChanFromValue1(UI_QueryInt323);
            this.param.setChannelC(UI_QueryInt323);
            this.param.setSpiChanC(chanFromValue15);
        }
        this.param.setChanColor(this.binding.triggerSourceCs, chanC);
        this.param.readSpiSlope();
        this.param.readSpiDataBits();
        this.param.readSpiWhen();
        this.param.readSpiCsMode();
        TriggerParam triggerParam = this.param;
        triggerParam.setFormatValue2Str(triggerParam.getFormatValue2Str());
        this.param.readSpiTimeout();
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        this.binding.setWhenCsMapping(ViewUtil.getMappingObject(R.array.msg_trigger_spi_when, ServiceEnum.Trigger_Spi_CS.trig_spi_cs.value1));
        this.binding.setWhenTimeoutMapping(ViewUtil.getMappingObject(R.array.msg_trigger_spi_when, ServiceEnum.Trigger_Spi_CS.trig_spi_idle.value1));
        this.binding.setModePositiveMapping(ViewUtil.getMappingObject(R.array.msg_trigger_polarity, ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive.value1));
        this.binding.setModeNegativeMapping(ViewUtil.getMappingObject(R.array.msg_trigger_polarity, ServiceEnum.TriggerPulsePolarity.Trigger_pulse_negative.value1));
        this.binding.setParam(this.param);
        ViewUtil.setSwitchButton(this.binding.triggerNoiseSwitch);
        this.binding.edgeRising.setOnCheckedChangeListener(this);
        this.binding.edgeFalling.setOnCheckedChangeListener(this);
        this.binding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.triggerSpiWithCs.setOnCheckedChangeListener(this);
        this.binding.triggerSpiTimeout.setOnCheckedChangeListener(this);
        this.binding.triggerSpiCsModeP.setOnCheckedChangeListener(this);
        this.binding.triggerSpiCsModeN.setOnCheckedChangeListener(this);
        this.binding.buttonLevel.setOnClickListener(this);
        this.binding.buttonLevelb.setOnClickListener(this);
        this.binding.buttonLevelc.setOnClickListener(this);
        this.binding.triggerSourceScl.setOnClickListener(this);
        this.binding.triggerSourceSda.setOnClickListener(this);
        this.binding.triggerSourceCs.setOnClickListener(this);
        this.binding.triggerLevelValue.setOnClickListener(this);
        this.binding.triggerLevelbValue.setOnClickListener(this);
        this.binding.triggerLevelcValue.setOnClickListener(this);
        this.binding.triggerSpiTimeout.setOnClickListener(this);
        this.binding.triggerSpiTimeoutValue.setOnClickListener(this);
        this.binding.triggerSpiDatabitsValue.setOnClickListener(this);
        this.binding.triggerSpiDataValue.setOnClickListener(this);
        this.binding.triggerSpiDatabitsValue.setOnClickListener(this);
        if (ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_spi_scl)).size() == 2) {
            this.binding.triggerSpiWithCs.setVisibility(8);
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            switch (compoundButton.getId()) {
                case R.id.auto_radio_button /* 2131361987 */:
                    if (z) {
                        this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1);
                        return;
                    }
                    return;
                case R.id.edge_falling /* 2131362737 */:
                    TriggerParam triggerParam = this.param;
                    if (triggerParam == null || !z) {
                        return;
                    }
                    triggerParam.saveSpiSlope(true);
                    return;
                case R.id.edge_rising /* 2131362739 */:
                    TriggerParam triggerParam2 = this.param;
                    if (triggerParam2 == null || !z) {
                        return;
                    }
                    triggerParam2.saveSpiSlope(false);
                    return;
                case R.id.normal_radio_button /* 2131363483 */:
                    if (z) {
                        this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1);
                        return;
                    }
                    return;
                case R.id.single_radio_button /* 2131363859 */:
                    if (z) {
                        this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1);
                        return;
                    }
                    return;
                case R.id.trigger_noise_switch /* 2131364309 */:
                    if (this.param != null) {
                        API.getInstance().UI_PostBool(this.serviceId, MessageID.MSG_TRIGGER_NOISE, z);
                        this.param.setIsNoise(z);
                        return;
                    }
                    return;
                case R.id.trigger_spi_cs_mode_n /* 2131364371 */:
                    TriggerParam triggerParam3 = this.param;
                    if (triggerParam3 != null) {
                        triggerParam3.saveSpiCsMode(true);
                        return;
                    }
                    return;
                case R.id.trigger_spi_cs_mode_p /* 2131364372 */:
                    TriggerParam triggerParam4 = this.param;
                    if (triggerParam4 != null) {
                        triggerParam4.saveSpiCsMode(false);
                        return;
                    }
                    return;
                case R.id.trigger_spi_timeout /* 2131364377 */:
                    this.aorBManager.set_RadioButton();
                    TriggerParam triggerParam5 = this.param;
                    if (triggerParam5 != null) {
                        triggerParam5.saveSpiLevelB(triggerParam5.getSpilevelB());
                        this.param.saveSpiTimeout(z);
                        return;
                    }
                    return;
                case R.id.trigger_spi_with_cs /* 2131364380 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveSpiTimeout(false);
                        TriggerParam triggerParam6 = this.param;
                        triggerParam6.saveSpiLevelC(triggerParam6.getSpilevelC());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        switch (view.getId()) {
            case R.id.auto_radio_button /* 2131361987 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1);
                break;
            case R.id.button_level /* 2131362192 */:
                if (this.context instanceof Activity) {
                    TriggerParam triggerParam = this.param;
                    triggerParam.setChan(triggerParam.getSpiChanA());
                    API.getInstance().UI_PostInt32(this.serviceId, MessageID.MSG_TRIGGER_SPI_SCL, this.param.getSpiChanA().value1);
                    this.param.saveButtonLevel();
                    break;
                }
                break;
            case R.id.button_levelb /* 2131362195 */:
                if (this.context instanceof Activity) {
                    TriggerParam triggerParam2 = this.param;
                    triggerParam2.setChan(triggerParam2.getSpiChanB());
                    API.getInstance().UI_PostInt32(this.serviceId, MessageID.MSG_TRIGGER_SPI_SDA, this.param.getSpiChanB().value1);
                    this.param.saveButtonLevel();
                    break;
                }
                break;
            case R.id.button_levelc /* 2131362196 */:
                if (this.context instanceof Activity) {
                    TriggerParam triggerParam3 = this.param;
                    triggerParam3.setChan(triggerParam3.getSpiChanC());
                    API.getInstance().UI_PostInt32(this.serviceId, MessageID.MSG_TRIGGER_SPI_CS, this.param.getSpiChanC().value1);
                    this.param.saveButtonLevel();
                    break;
                }
                break;
            case R.id.normal_radio_button /* 2131363483 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1);
                break;
            case R.id.single_radio_button /* 2131363859 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1);
                break;
            case R.id.trigger_level_value /* 2131364280 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readspiLevelAttr();
                    TriggerParam triggerParam4 = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam4.getChanUnit(triggerParam4.getChannel()), this.param.getspiLevelAttr().getMaxLongValue(), this.param.getspiLevelAttr().getMinLongValue(), this.param.getspiLevelAttr().getDefLongValue(), this.param.getSpilevelA(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerSpiAdapter.4
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerSpiAdapter.this.param.saveSpiLevelA(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerSpiAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_levelb_value /* 2131364286 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readspiLevelBAttr();
                    TriggerParam triggerParam5 = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam5.getChanUnit(triggerParam5.getChannelB()), this.param.getspiLevelBAttr().getMaxLongValue(), this.param.getspiLevelBAttr().getMinLongValue(), this.param.getspiLevelBAttr().getDefLongValue(), this.param.getSpilevelB(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerSpiAdapter.5
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerSpiAdapter.this.param.saveSpiLevelB(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerSpiAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_levelc_value /* 2131364288 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readspiLevelCAttr();
                    TriggerParam triggerParam6 = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam6.getChanUnit(triggerParam6.getChannelC()), this.param.getspiLevelCAttr().getMaxLongValue(), this.param.getspiLevelCAttr().getMinLongValue(), this.param.getspiLevelCAttr().getDefLongValue(), this.param.getSpilevelC(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerSpiAdapter.6
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerSpiAdapter.this.param.saveSpiLevelC(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerSpiAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source_cs /* 2131364352 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_spi_cs)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSpiAdapter$awj9USauIbSYjL6ASGE3CBKcMWs
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerSpiAdapter.this.lambda$onClick$7$TriggerSpiAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSpiAdapter$9SNN3z_vxlMaBg-LERig2vm81Ec
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerSpiAdapter.this.lambda$onClick$8$TriggerSpiAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source_scl /* 2131364362 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_spi_scl)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSpiAdapter$PJk4UUbFTQmNEwo-Fym8hsji8GY
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerSpiAdapter.this.lambda$onClick$3$TriggerSpiAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSpiAdapter$fVb96JtPvEgkHIykXxpJ5ABk2U8
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerSpiAdapter.this.lambda$onClick$4$TriggerSpiAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source_sda /* 2131364366 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_spi_sda)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSpiAdapter$8cEYCpi0LX3aX1UyuinU8JpADk0
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerSpiAdapter.this.lambda$onClick$5$TriggerSpiAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSpiAdapter$AeUfNFHgTEJLtpriL9KQ53U2XPk
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerSpiAdapter.this.lambda$onClick$6$TriggerSpiAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_spi_data_value /* 2131364374 */:
                if (this.context instanceof Activity) {
                    TriggerParam triggerParam7 = this.param;
                    triggerParam7.setKeyNumMax(triggerParam7.getDataBits());
                    if (this.formatTransformKey == null) {
                        FormatTransformKey formatTransformKey = new FormatTransformKey(this.context, this.popupView.getAnchor(), this.param);
                        this.formatTransformKey = formatTransformKey;
                        formatTransformKey.attachRefView(this.binding.triggerSpiDataValue);
                        this.formatTransformKey.getFormatTransformValue(new FormatTransformKey.FormatTransformInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSpiAdapter$uCerWazFDqe3MRHxVN_xIbjLEz4
                            @Override // com.rigol.scope.views.FormatTransformKey.FormatTransformInterface
                            public final void FormatTransformListener(String str) {
                                TriggerSpiAdapter.this.lambda$onClick$9$TriggerSpiAdapter(str);
                            }
                        });
                    }
                    this.formatTransformKey.show();
                    this.formatTransformKey.init();
                    break;
                }
                break;
            case R.id.trigger_spi_databits_value /* 2131364376 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_number, this.param.getDataBitsAttr().getMaxIntValue(), this.param.getDataBitsAttr().getMinIntValue(), this.param.getDataBitsAttr().getDefIntValue(), this.param.getDataBits(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerSpiAdapter.7
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            Long l = (Long) t;
                            TriggerSpiAdapter.this.param.setDataBits(Math.toIntExact(l.longValue()));
                            API.getInstance().UI_PostInt32(TriggerSpiAdapter.this.serviceId, MessageID.MSG_TRIGGER_SPI_DATABITS, Math.toIntExact(l.longValue()));
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerSpiAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_spi_timeout_value /* 2131364379 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getspiTimeoutAttr().getMaxLongValue(), this.param.getspiTimeoutAttr().getMinLongValue(), this.param.getspiTimeoutAttr().getDefLongValue(), this.param.getTimeOut(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerSpiAdapter.3
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerSpiAdapter.this.param.saveSpiTimeout(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerSpiAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
        }
        AorBManager.OnOutOrInAdapterClickChangeListener onOutOrInAdapterClickChangeListener = this.listener;
        if (onOutOrInAdapterClickChangeListener != null) {
            onOutOrInAdapterClickChangeListener.onChange(false);
        }
    }

    public /* synthetic */ void lambda$onClick$3$TriggerSpiAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$TriggerSpiAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceScl(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$5$TriggerSpiAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$TriggerSpiAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceSda(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$7$TriggerSpiAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$8$TriggerSpiAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceCS(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$9$TriggerSpiAdapter(String str) {
        this.param.setFormatValue2Str(str);
        if (str.contains("[bin]")) {
            this.param.setSpiDataType(0);
        } else {
            this.param.setSpiDataType(1);
        }
    }

    private void selectSourceCS(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveSpiSourceCs(mappingObject.getValue());
            this.param.setChannelC(mappingObject.getValue());
        }
    }

    private void selectSourceSda(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveSpiSourceSda(mappingObject.getValue());
            this.param.setChannelB(mappingObject.getValue());
        }
    }

    private void selectSourceScl(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveSpiSourceScl(mappingObject.getValue());
            this.param.setChannel(mappingObject.getValue());
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        switch (i) {
            case R.id.trigger_level_value /* 2131364280 */:
                TriggerParam triggerParam = this.param;
                triggerParam.setChan(triggerParam.getSpiChanA());
                TriggerParam triggerParam2 = this.param;
                triggerParam2.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam2);
                return;
            case R.id.trigger_levelb_value /* 2131364286 */:
                TriggerParam triggerParam3 = this.param;
                triggerParam3.setChan(triggerParam3.getSpiChanB());
                TriggerParam triggerParam4 = this.param;
                triggerParam4.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam4);
                return;
            case R.id.trigger_levelc_value /* 2131364288 */:
                TriggerParam triggerParam5 = this.param;
                triggerParam5.setChan(triggerParam5.getSpiChanC());
                TriggerParam triggerParam6 = this.param;
                triggerParam6.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam6);
                return;
            case R.id.trigger_spi_databits_value /* 2131364376 */:
                TriggerParam triggerParam7 = this.param;
                triggerParam7.setDataBits(triggerParam7.getIntStep(triggerParam7.getDataBits(), this.param.getDataBitsAttr(), z, keyEvent));
                API.getInstance().UI_PostInt32(this.serviceId, MessageID.MSG_TRIGGER_SPI_DATABITS, this.param.getDataBits());
                return;
            case R.id.trigger_spi_timeout_value /* 2131364379 */:
                this.param.readspiTimeOutAttr();
                TriggerParam triggerParam8 = this.param;
                triggerParam8.saveSpiTimeout(triggerParam8.getLongStep(triggerParam8.getSpiTimeOut(), this.param.getspiTimeoutAttr(), z, keyEvent));
                return;
            default:
                return;
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        if (this.param == null || !isMove()) {
            return;
        }
        switch (i) {
            case R.id.trigger_level_value /* 2131364280 */:
                TriggerParam triggerParam = this.param;
                triggerParam.saveSpiLevelA(triggerParam.getLongDef(triggerParam.getspiLevelAttr()));
                return;
            case R.id.trigger_levelb_value /* 2131364286 */:
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveSpiLevelB(triggerParam2.getLongDef(triggerParam2.getspiLevelBAttr()));
                return;
            case R.id.trigger_levelc_value /* 2131364288 */:
                TriggerParam triggerParam3 = this.param;
                triggerParam3.saveSpiLevelC(triggerParam3.getLongDef(triggerParam3.getspiLevelCAttr()));
                return;
            case R.id.trigger_spi_databits_value /* 2131364376 */:
                TriggerParam triggerParam4 = this.param;
                triggerParam4.setDataBits(triggerParam4.getIntDef(triggerParam4.getDataBitsAttr()));
                return;
            case R.id.trigger_spi_timeout_value /* 2131364379 */:
                TriggerParam triggerParam5 = this.param;
                triggerParam5.saveSpiTimeout(triggerParam5.getLongDef(triggerParam5.getspiTimeoutAttr()));
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public class TriggerSpiHolder extends RecyclerView.ViewHolder {
        private AdapterTriggerSpiBinding binding;

        public TriggerSpiHolder(AdapterTriggerSpiBinding adapterTriggerSpiBinding) {
            super(adapterTriggerSpiBinding.getRoot());
            this.binding = adapterTriggerSpiBinding;
        }
    }
}
