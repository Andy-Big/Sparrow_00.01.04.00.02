package com.rigol.scope.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
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
import com.rigol.scope.databinding.AdapterTriggerSetupHoldBinding;
import com.rigol.scope.databinding.PopupviewTriggerBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.TriggerViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.scope.views.trigger.TriggerPopupView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TriggerSetupHoldAdapter extends RecyclerView.Adapter<TriggerSetupHoldHolder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterTriggerSetupHoldBinding binding;
    private View clickedView;
    private Context context;
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

    public TriggerSetupHoldAdapter(Context context, BasePopupView basePopupView, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        this.triggerViewModel = triggerViewModel;
        this.param = triggerParam;
        this.popupView = basePopupView;
        this.context = context;
        this.serviceId = triggerParam.getServiceId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TriggerSetupHoldHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterTriggerSetupHoldBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelAValue, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelBValue, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerHoldoff, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.setupValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.holdValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSourceClock, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSourceData, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.TriggerSetupHoldAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                TriggerSetupHoldAdapter.this.aorBManager.showKey(TriggerSetupHoldAdapter.this.context, ((AorBParam) TriggerSetupHoldAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) TriggerSetupHoldAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                TriggerSetupHoldAdapter.this.aorBManager.showKey(TriggerSetupHoldAdapter.this.context, ((AorBParam) TriggerSetupHoldAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) TriggerSetupHoldAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.triggerLevelAValue, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.triggerLevelBValue, true, ViewUtil.KEY_B);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSetupHoldAdapter$VpuSQL-UqDck6nxpAgMcTNfwEu4
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TriggerSetupHoldAdapter.this.lambda$onCreateViewHolder$2$TriggerSetupHoldAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new TriggerSetupHoldHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$TriggerSetupHoldAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (this.popviewTriggerBinding.triggerView.getAdapter() instanceof TriggerSetupHoldAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSetupHoldAdapter$DMXDHOKig9v6ILEso_cuuiUKLns
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerSetupHoldAdapter.this.lambda$onCreateViewHolder$0$TriggerSetupHoldAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSetupHoldAdapter$gjHe7ueR7EXFqkXBV3A2UTTVbks
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    TriggerSetupHoldAdapter.this.lambda$onCreateViewHolder$1$TriggerSetupHoldAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$TriggerSetupHoldAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$TriggerSetupHoldAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.trigger_source_clock) {
            selectSourceCLK(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_source_data) {
            selectSourceData(mappingObject);
        }
    }

    private void selectSourceCLK(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveSourceClock(mappingObject.getValue());
            this.param.setChannel(mappingObject.getValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TriggerSetupHoldHolder triggerSetupHoldHolder, int i) {
        ShowTriggerSetupHold();
        triggerSetupHoldHolder.binding.executePendingBindings();
    }

    public void ShowTriggerSetupHold() {
        ServiceEnum.Chan chan = this.param.getChan();
        if (chan == ServiceEnum.Chan.acline || chan == ServiceEnum.Chan.ext) {
            this.param.saveSourceClock(ServiceEnum.Chan.chan1.value1);
        } else {
            this.param.setSetupHoldChanA(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SETUP_SCL)));
        }
        this.param.setSetupHoldChanB(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SETUP_SDA)));
        this.param.readSetupHoldWhen();
        this.param.readSetupHoldSlope();
        this.param.readSetupHoldDataType();
        this.param.readSetupTime();
        this.param.readHoldTime();
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        this.binding.setSlopeRisingMapping(ViewUtil.getMappingObject(R.array.msg_trigger_slope_polarity, ServiceEnum.EdgeSlope.Trigger_Edge_Rising.value1));
        this.binding.setSlopeFallingMapping(ViewUtil.getMappingObject(R.array.msg_trigger_slope_polarity, ServiceEnum.EdgeSlope.Trigger_Edge_Falling.value1));
        this.binding.setTypeHMapping(ViewUtil.getMappingObject(R.array.msg_trigger_setup_data, ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive.value1));
        this.binding.setTypeLMapping(ViewUtil.getMappingObject(R.array.msg_trigger_setup_data, ServiceEnum.TriggerPulsePolarity.Trigger_pulse_negative.value1));
        this.binding.setWhenSetupMapping(ViewUtil.getMappingObject(R.array.msg_trigger_setup_when, ServiceEnum.SHEvent.Trigger_SH_setup.value1));
        this.binding.setWhenHoldMapping(ViewUtil.getMappingObject(R.array.msg_trigger_setup_when, ServiceEnum.SHEvent.Trigger_SH_hold.value1));
        this.binding.setWhenSetupHoldMapping(ViewUtil.getMappingObject(R.array.msg_trigger_setup_when, ServiceEnum.SHEvent.Trigger_SH_setup_hold.value1));
        this.binding.setParam(this.param);
        ViewUtil.setSwitchButton(this.binding.triggerNoiseSwitch);
        this.binding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.setup.setOnCheckedChangeListener(this);
        this.binding.hold.setOnCheckedChangeListener(this);
        this.binding.setupHold.setOnCheckedChangeListener(this);
        this.binding.edgeClockRising.setOnCheckedChangeListener(this);
        this.binding.edgeClockFalling.setOnCheckedChangeListener(this);
        this.binding.dataTypeL.setOnCheckedChangeListener(this);
        this.binding.dataTypeH.setOnCheckedChangeListener(this);
        this.binding.buttonLevel.setOnClickListener(this);
        this.binding.buttonLevelB.setOnClickListener(this);
        this.binding.imageView2.setOnClickListener(this);
        this.binding.triggerSourceClock.setOnClickListener(this);
        this.binding.triggerSourceData.setOnClickListener(this);
        this.binding.triggerHoldoff.setOnClickListener(this);
        this.binding.triggerLevelAValue.setOnClickListener(this);
        this.binding.triggerLevelBValue.setOnClickListener(this);
        this.binding.setupValue.setOnClickListener(this);
        this.binding.holdValue.setOnClickListener(this);
        this.binding.triggerLevelAView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.adapters.TriggerSetupHoldAdapter.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    ServiceEnum.Chan setupHoldChanA = TriggerSetupHoldAdapter.this.param.getSetupHoldChanA();
                    long UI_QueryInt64 = API.getInstance().UI_QueryInt64(setupHoldChanA.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
                    long UI_QueryInt642 = API.getInstance().UI_QueryInt64(setupHoldChanA.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
                    TriggerSetupHoldAdapter.this.param.saveSetupHoldLevelA((long) ((((seekBar.getProgress() / 100.0d) * (UI_QueryInt64 * TriggerSetupHoldAdapter.this.param.getScaleNum())) - UI_QueryInt642) - ((UI_QueryInt64 * TriggerSetupHoldAdapter.this.param.getScaleNum()) / 2)));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                ServiceEnum.Chan setupHoldChanA = TriggerSetupHoldAdapter.this.param.getSetupHoldChanA();
                long UI_QueryInt64 = API.getInstance().UI_QueryInt64(setupHoldChanA.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
                long UI_QueryInt642 = API.getInstance().UI_QueryInt64(setupHoldChanA.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
                TriggerSetupHoldAdapter.this.param.saveSetupHoldLevelA((long) ((((seekBar.getProgress() / 100.0d) * (UI_QueryInt64 * TriggerSetupHoldAdapter.this.param.getScaleNum())) - UI_QueryInt642) - ((UI_QueryInt64 * TriggerSetupHoldAdapter.this.param.getScaleNum()) / 2)));
            }
        });
        this.binding.triggerLevelBView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.adapters.TriggerSetupHoldAdapter.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    ServiceEnum.Chan setupHoldChanB = TriggerSetupHoldAdapter.this.param.getSetupHoldChanB();
                    long UI_QueryInt64 = API.getInstance().UI_QueryInt64(setupHoldChanB.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
                    long UI_QueryInt642 = API.getInstance().UI_QueryInt64(setupHoldChanB.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
                    TriggerSetupHoldAdapter.this.param.saveSetupHoldLevelB((long) ((((seekBar.getProgress() / 100.0d) * (UI_QueryInt64 * TriggerSetupHoldAdapter.this.param.getScaleNum())) - UI_QueryInt642) - ((UI_QueryInt64 * TriggerSetupHoldAdapter.this.param.getScaleNum()) / 2)));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                ServiceEnum.Chan setupHoldChanB = TriggerSetupHoldAdapter.this.param.getSetupHoldChanB();
                long UI_QueryInt64 = API.getInstance().UI_QueryInt64(setupHoldChanB.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
                long UI_QueryInt642 = API.getInstance().UI_QueryInt64(setupHoldChanB.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
                TriggerSetupHoldAdapter.this.param.saveSetupHoldLevelB((long) ((((seekBar.getProgress() / 100.0d) * (UI_QueryInt64 * TriggerSetupHoldAdapter.this.param.getScaleNum())) - UI_QueryInt642) - ((UI_QueryInt64 * TriggerSetupHoldAdapter.this.param.getScaleNum()) / 2)));
            }
        });
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            switch (compoundButton.getId()) {
                case R.id.auto_radio_button /* 2131361987 */:
                    if (z) {
                        this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1);
                        break;
                    }
                    break;
                case R.id.data_type_h /* 2131362370 */:
                    if (this.param != null) {
                        this.param.saveSetupHoldData(false);
                        break;
                    }
                    break;
                case R.id.data_type_l /* 2131362371 */:
                    TriggerParam triggerParam = this.param;
                    if (triggerParam != null) {
                        triggerParam.saveSetupHoldData(z);
                        break;
                    }
                    break;
                case R.id.edge_clock_falling /* 2131362733 */:
                    TriggerParam triggerParam2 = this.param;
                    if (triggerParam2 != null) {
                        triggerParam2.saveSetupHoldSlope(z);
                        break;
                    }
                    break;
                case R.id.edge_clock_rising /* 2131362734 */:
                    if (this.param != null) {
                        this.param.saveSetupHoldSlope(false);
                        break;
                    }
                    break;
                case R.id.hold /* 2131363058 */:
                    this.aorBManager.set_RadioButton(0, 1);
                    TriggerParam triggerParam3 = this.param;
                    if (triggerParam3 != null) {
                        triggerParam3.saveSetupHold(z ? 1 : 0);
                        break;
                    }
                    break;
                case R.id.normal_radio_button /* 2131363483 */:
                    if (z) {
                        this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1);
                        break;
                    }
                    break;
                case R.id.setup /* 2131363839 */:
                    this.aorBManager.set_RadioButton(0, 1);
                    this.aorBManager.set_RadioButton(0, 1);
                    if (this.param != null) {
                        this.param.saveSetupHold(0);
                        break;
                    }
                    break;
                case R.id.setup_hold /* 2131363844 */:
                    this.aorBManager.set_RadioButton(0, 1);
                    if (this.param != null) {
                        this.param.saveSetupHold(z ? 2 : 0);
                        break;
                    }
                    break;
                case R.id.single_radio_button /* 2131363859 */:
                    if (z) {
                        this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1);
                        break;
                    }
                    break;
                case R.id.trigger_noise_switch /* 2131364309 */:
                    if (this.param != null) {
                        API.getInstance().UI_PostBool(this.serviceId, MessageID.MSG_TRIGGER_NOISE, z);
                        this.param.setIsNoise(z);
                        break;
                    }
                    break;
            }
        }
        AorBManager.OnOutOrInAdapterClickChangeListener onOutOrInAdapterClickChangeListener = this.listener;
        if (onOutOrInAdapterClickChangeListener != null) {
            onOutOrInAdapterClickChangeListener.onChange(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        switch (view.getId()) {
            case R.id.auto_radio_button /* 2131361987 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1);
                return;
            case R.id.button_level /* 2131362192 */:
                if (this.context instanceof Activity) {
                    TriggerParam triggerParam = this.param;
                    triggerParam.setChan(triggerParam.getSetupHoldChanA());
                    API.getInstance().UI_PostInt32(this.serviceId, MessageID.MSG_TRIGGER_SETUP_SCL, this.param.getSetupHoldChanA().value1);
                    this.param.saveButtonLevel();
                    return;
                }
                return;
            case R.id.button_levelB /* 2131362193 */:
                if (this.context instanceof Activity) {
                    TriggerParam triggerParam2 = this.param;
                    triggerParam2.setChan(triggerParam2.getSetupHoldChanB());
                    API.getInstance().UI_PostInt32(this.serviceId, MessageID.MSG_TRIGGER_SETUP_SDA, this.param.getSetupHoldChanB().value1);
                    this.param.saveButtonLevel();
                    return;
                }
                return;
            case R.id.hold_value /* 2131363060 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getHoldTimeAttr().getMaxLongValue(), this.param.getHoldTimeAttr().getMinLongValue(), this.param.getHoldTimeAttr().getDefLongValue(), this.param.getHold(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerSetupHoldAdapter.8
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerSetupHoldAdapter.this.param.saveHoldValue(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerSetupHoldAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                }
                return;
            case R.id.imageView2 /* 2131363100 */:
                if (this.param.getSetupHoldSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Rising && this.param.getSHEvent() == ServiceEnum.SHEvent.Trigger_SH_setup) {
                    this.param.saveSetupHold(1);
                    return;
                } else if (this.param.getSetupHoldSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Rising && this.param.getSHEvent() == ServiceEnum.SHEvent.Trigger_SH_hold) {
                    this.param.saveSetupHold(2);
                    return;
                } else if (this.param.getSetupHoldSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Rising && this.param.getSHEvent() == ServiceEnum.SHEvent.Trigger_SH_setup_hold) {
                    this.param.saveSetupHoldSlope(true);
                    this.param.saveSetupHold(0);
                    return;
                } else if (this.param.getSetupHoldSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Falling && this.param.getSHEvent() == ServiceEnum.SHEvent.Trigger_SH_setup) {
                    this.param.saveSetupHold(1);
                    return;
                } else if (this.param.getSetupHoldSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Falling && this.param.getSHEvent() == ServiceEnum.SHEvent.Trigger_SH_hold) {
                    this.param.saveSetupHold(2);
                    return;
                } else if (this.param.getSetupHoldSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Falling && this.param.getSHEvent() == ServiceEnum.SHEvent.Trigger_SH_setup_hold) {
                    this.param.saveSetupHoldSlope(false);
                    this.param.saveSetupHold(0);
                    return;
                } else {
                    return;
                }
            case R.id.normal_radio_button /* 2131363483 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1);
                return;
            case R.id.setup_value /* 2131363847 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getSetupTimeAttr().getMaxLongValue(), this.param.getSetupTimeAttr().getMinLongValue(), this.param.getSetupTimeAttr().getDefLongValue(), this.param.getSetup(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerSetupHoldAdapter.7
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerSetupHoldAdapter.this.param.saveSetupValue(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerSetupHoldAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                }
                return;
            case R.id.single_radio_button /* 2131363859 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1);
                return;
            case R.id.trigger_holdoff /* 2131364231 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getHoldOffAttr().getMaxLongValue(), this.param.getHoldOffAttr().getMinLongValue(), this.param.getHoldOffAttr().getDefLongValue(), this.param.getHoldOff(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerSetupHoldAdapter.4
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerSetupHoldAdapter.this.param.saveholdOff(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerSetupHoldAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                }
                return;
            case R.id.trigger_levelA_value /* 2131364270 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readsetupHoldLevelAttr();
                    TriggerParam triggerParam3 = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam3.getChanUnit(triggerParam3.getChannel()), this.param.getsetupHoldLevelAttr().getMaxLongValue(), this.param.getsetupHoldLevelAttr().getMinLongValue(), this.param.getsetupHoldLevelAttr().getDefLongValue(), this.param.getSetupHoldlevelA(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerSetupHoldAdapter.5
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerSetupHoldAdapter.this.param.saveSetupHoldLevelA(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerSetupHoldAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                }
                return;
            case R.id.trigger_levelB_value /* 2131364273 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readsetupHoldLevelBAttr();
                    TriggerParam triggerParam4 = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam4.getChanUnit(triggerParam4.getChannelB()), this.param.getsetupHoldLevelBAttr().getMaxLongValue(), this.param.getsetupHoldLevelBAttr().getMinLongValue(), this.param.getsetupHoldLevelBAttr().getDefLongValue(), this.param.getSetupHoldlevelB(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerSetupHoldAdapter.6
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerSetupHoldAdapter.this.param.saveSetupHoldLevelB(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerSetupHoldAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                }
                return;
            case R.id.trigger_source_clock /* 2131364350 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_setup_scl)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSetupHoldAdapter$cbjGVWrL4Vp5SNE6NpC0gh_iT8w
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerSetupHoldAdapter.this.lambda$onClick$3$TriggerSetupHoldAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSetupHoldAdapter$gg1Vw_Z3xQCJgJyccmPvmPsrtO0
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerSetupHoldAdapter.this.lambda$onClick$4$TriggerSetupHoldAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                }
                return;
            case R.id.trigger_source_data /* 2131364354 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_trigger_setup_sda), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSetupHoldAdapter$EqBfR2BbIv0lPe6IQ7yUrc89MEc
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerSetupHoldAdapter.this.lambda$onClick$5$TriggerSetupHoldAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSetupHoldAdapter$R9RdvT31d-Dx6HeBk7ZnTA1YVWg
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerSetupHoldAdapter.this.lambda$onClick$6$TriggerSetupHoldAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }

    public /* synthetic */ void lambda$onClick$3$TriggerSetupHoldAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$TriggerSetupHoldAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceCLK(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$5$TriggerSetupHoldAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$TriggerSetupHoldAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceData(mappingObject);
    }

    private void selectSourceData(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveSourceData(mappingObject.getValue());
            this.param.setChannelB(mappingObject.getValue());
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        switch (i) {
            case R.id.hold_value /* 2131363060 */:
                this.param.readHoldTimeAttr();
                TriggerParam triggerParam = this.param;
                triggerParam.saveHoldValue(triggerParam.getLongStep(triggerParam.getHold(), this.param.getHoldTimeAttr(), z, keyEvent));
                return;
            case R.id.setup_value /* 2131363847 */:
                this.param.readSetupTimeAttr();
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveSetupValue(triggerParam2.getLongStep(triggerParam2.getSetup(), this.param.getSetupTimeAttr(), z, keyEvent));
                return;
            case R.id.trigger_holdoff /* 2131364231 */:
                TriggerParam triggerParam3 = this.param;
                triggerParam3.saveholdOff(triggerParam3.getLongStep(triggerParam3.getHoldOff(), this.param.getHoldOffAttr(), z, keyEvent));
                return;
            case R.id.trigger_levelA_value /* 2131364270 */:
                TriggerParam triggerParam4 = this.param;
                triggerParam4.setChan(triggerParam4.getSetupHoldChanA());
                TriggerParam triggerParam5 = this.param;
                triggerParam5.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam5);
                return;
            case R.id.trigger_levelB_value /* 2131364273 */:
                TriggerParam triggerParam6 = this.param;
                triggerParam6.setChan(triggerParam6.getSetupHoldChanB());
                TriggerParam triggerParam7 = this.param;
                triggerParam7.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam7);
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
            case R.id.hold_value /* 2131363060 */:
                TriggerParam triggerParam = this.param;
                triggerParam.saveHoldValue(triggerParam.getLongDef(triggerParam.getHoldTimeAttr()));
                return;
            case R.id.setup_value /* 2131363847 */:
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveSetupValue(triggerParam2.getLongDef(triggerParam2.getSetupTimeAttr()));
                return;
            case R.id.trigger_holdoff /* 2131364231 */:
                TriggerParam triggerParam3 = this.param;
                triggerParam3.saveholdOff(triggerParam3.getLongDef(triggerParam3.getHoldOffAttr()));
                return;
            case R.id.trigger_levelA_value /* 2131364270 */:
                TriggerParam triggerParam4 = this.param;
                triggerParam4.saveSetupHoldLevelA(triggerParam4.getLongDef(triggerParam4.getsetupHoldLevelAttr()));
                return;
            case R.id.trigger_levelB_value /* 2131364273 */:
                TriggerParam triggerParam5 = this.param;
                triggerParam5.saveSetupHoldLevelB(triggerParam5.getLongDef(triggerParam5.getsetupHoldLevelBAttr()));
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public class TriggerSetupHoldHolder extends RecyclerView.ViewHolder {
        private AdapterTriggerSetupHoldBinding binding;

        public TriggerSetupHoldHolder(AdapterTriggerSetupHoldBinding adapterTriggerSetupHoldBinding) {
            super(adapterTriggerSetupHoldBinding.getRoot());
            this.binding = adapterTriggerSetupHoldBinding;
        }
    }
}
