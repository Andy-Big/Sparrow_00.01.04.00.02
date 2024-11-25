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
import com.rigol.scope.databinding.AdapterTriggerRuntBinding;
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
public class TriggerRuntAdapter extends RecyclerView.Adapter<TriggerRuntHolder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset, AorBManager.OnSetTextByTriggerLevelRoll {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterTriggerRuntBinding binding;
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

    public TriggerRuntAdapter(Context context, BasePopupView basePopupView, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        this.triggerViewModel = triggerViewModel;
        this.param = triggerParam;
        this.popupView = basePopupView;
        this.context = context;
        this.serviceId = triggerParam.getServiceId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TriggerRuntHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterTriggerRuntBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelAValue, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelBValue, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerHoldoff, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.upperLimitValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.lowerLimitValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSource, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this, this) { // from class: com.rigol.scope.adapters.TriggerRuntAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                TriggerRuntAdapter.this.aorBManager.showKey(TriggerRuntAdapter.this.context, ((AorBParam) TriggerRuntAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) TriggerRuntAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                TriggerRuntAdapter.this.aorBManager.showKey(TriggerRuntAdapter.this.context, ((AorBParam) TriggerRuntAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) TriggerRuntAdapter.this.list_aorbParam.get(i2)).getAorb());
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
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerRuntAdapter$0TtTTDvua8MGa-1vHUDU5Ac_Jc0
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TriggerRuntAdapter.this.lambda$onCreateViewHolder$2$TriggerRuntAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new TriggerRuntHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$TriggerRuntAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (this.popviewTriggerBinding.triggerView.getAdapter() instanceof TriggerRuntAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerRuntAdapter$pz5RzVVDOcdEnZr9F5TI-3Nnj_s
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerRuntAdapter.this.lambda$onCreateViewHolder$0$TriggerRuntAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerRuntAdapter$yz3GbKMErQDUc8M5WPx0I5Xd8FY
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    TriggerRuntAdapter.this.lambda$onCreateViewHolder$1$TriggerRuntAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$TriggerRuntAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$TriggerRuntAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.trigger_source) {
            selectSource(mappingObject);
        }
    }

    private void selectSource(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveRuntSource(mappingObject.getValue());
            this.param.setChannel(mappingObject.getValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TriggerRuntHolder triggerRuntHolder, int i) {
        ShowTriggerRunt();
        triggerRuntHolder.binding.executePendingBindings();
    }

    public void ShowTriggerRunt() {
        ServiceEnum.Chan chan = this.param.getChan();
        if (chan == ServiceEnum.Chan.acline || chan == ServiceEnum.Chan.ext) {
            this.param.setChannel(ServiceEnum.Chan.chan1.value1);
            this.param.saveRuntSource(ServiceEnum.Chan.chan1.value1);
        } else {
            this.param.setChan(ServiceEnum.getChanFromValue1(chan.value1));
        }
        this.param.setChanColor(this.binding.triggerSource, chan);
        this.param.readRuntLevelSelect();
        this.param.readRuntWhen();
        this.param.readRuntPolarity();
        this.param.readRuntHighLevel();
        this.param.readRuntLowLevel();
        this.param.checkLevel();
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        this.binding.setPolarityPositiveMapping(ViewUtil.getMappingObject(R.array.msg_trigger_polarity, ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive.value1));
        this.binding.setPolarityNegativeMapping(ViewUtil.getMappingObject(R.array.msg_trigger_polarity, ServiceEnum.TriggerPulsePolarity.Trigger_pulse_negative.value1));
        this.binding.setSelectLevelAMapping(ViewUtil.getMappingObject(R.array.msg_trigger_levelselect, ServiceEnum.Trigger_Level_ID.Trigger_Level_High.value1));
        this.binding.setSelectLevelBMapping(ViewUtil.getMappingObject(R.array.msg_trigger_levelselect, ServiceEnum.Trigger_Level_ID.Trigger_Level_Low.value1));
        this.binding.setSelectLevelABMapping(ViewUtil.getMappingObject(R.array.msg_trigger_levelselect, ServiceEnum.Trigger_Level_ID.Trigger_Level_Double.value1));
        this.binding.setWhenNoneMapping(ViewUtil.getMappingObject(R.array.msg_trigger_runt_when, ServiceEnum.EMoreThan.Trigger_When_None.value1));
        this.binding.setParam(this.param);
        ViewUtil.setSwitchButton(this.binding.triggerNoiseSwitch);
        this.binding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.triggerLevelSelectAb.setOnCheckedChangeListener(this);
        this.binding.none.setOnCheckedChangeListener(this);
        this.binding.moreThan.setOnCheckedChangeListener(this);
        this.binding.lessMore.setOnCheckedChangeListener(this);
        this.binding.lessThan.setOnCheckedChangeListener(this);
        this.binding.runtPositive.setOnCheckedChangeListener(this);
        this.binding.runtNegative.setOnCheckedChangeListener(this);
        this.binding.buttonLevel.setOnClickListener(this);
        this.binding.buttonLevelB.setOnClickListener(this);
        this.binding.imageView2.setOnClickListener(this);
        this.binding.triggerSource.setOnClickListener(this);
        this.binding.triggerHoldoff.setOnClickListener(this);
        this.binding.triggerLevelAValue.setOnClickListener(this);
        this.binding.triggerLevelBValue.setOnClickListener(this);
        this.binding.upperLimitValue.setOnClickListener(this);
        this.binding.lowerLimitValue.setOnClickListener(this);
        this.binding.triggerLevelAView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.adapters.TriggerRuntAdapter.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long progress = (long) ((((seekBar.getProgress() / 100.0d) * (TriggerRuntAdapter.this.param.getChanScale() * TriggerRuntAdapter.this.param.getScaleNum())) - TriggerRuntAdapter.this.param.getChanOffset()) - ((TriggerRuntAdapter.this.param.getChanScale() * TriggerRuntAdapter.this.param.getScaleNum()) / 2));
                    if (TriggerRuntAdapter.this.param.getRuntTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                        TriggerRuntAdapter.this.param.saveRuntLevelASync(progress);
                        return;
                    }
                    TriggerRuntAdapter.this.param.saveRuntLevelASync(progress);
                    TriggerRuntAdapter.this.param.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, TriggerRuntAdapter.this.param.getRuntlevelB());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                long progress = (long) ((((seekBar.getProgress() / 100.0d) * (TriggerRuntAdapter.this.param.getChanScale() * TriggerRuntAdapter.this.param.getScaleNum())) - TriggerRuntAdapter.this.param.getChanOffset()) - ((TriggerRuntAdapter.this.param.getChanScale() * TriggerRuntAdapter.this.param.getScaleNum()) / 2));
                if (TriggerRuntAdapter.this.param.getRuntTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                    TriggerRuntAdapter.this.param.saveRuntLevelASync(progress);
                    return;
                }
                TriggerRuntAdapter.this.param.saveRuntLevelASync(progress);
                TriggerRuntAdapter.this.param.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, TriggerRuntAdapter.this.param.getRuntlevelB());
            }
        });
        this.binding.triggerLevelBView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.adapters.TriggerRuntAdapter.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long runtValue = TriggerRuntAdapter.this.param.getRuntValue();
                    long progress = (long) ((((seekBar.getProgress() / 100.0d) * (TriggerRuntAdapter.this.param.getChanScale() * TriggerRuntAdapter.this.param.getScaleNum())) - TriggerRuntAdapter.this.param.getChanOffset()) - ((TriggerRuntAdapter.this.param.getChanScale() * TriggerRuntAdapter.this.param.getScaleNum()) / 2));
                    if (TriggerRuntAdapter.this.param.getRuntTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                        TriggerRuntAdapter.this.param.readruntLevelAttr();
                        TriggerRuntAdapter.this.param.readruntLevelBAttr();
                        if (progress < TriggerRuntAdapter.this.param.getruntLevelAttr().getMaxLongValue() - runtValue) {
                            TriggerRuntAdapter.this.param.saveRuntLevelBSync(progress);
                            TriggerRuntAdapter.this.param.saveRuntLevelASync(progress + runtValue);
                            return;
                        }
                        TriggerRuntAdapter.this.param.saveRuntLevelBSync(TriggerRuntAdapter.this.param.getruntLevelAttr().getMaxLongValue() - runtValue);
                        TriggerRuntAdapter.this.param.saveRuntLevelASync(TriggerRuntAdapter.this.param.getruntLevelAttr().getMaxLongValue());
                        return;
                    }
                    TriggerRuntAdapter.this.param.saveRuntLevelBSync(progress);
                    TriggerRuntAdapter.this.param.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, TriggerRuntAdapter.this.param.getRuntlevelA());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                long runtValue = TriggerRuntAdapter.this.param.getRuntValue();
                long progress = (long) ((((seekBar.getProgress() / 100.0d) * (TriggerRuntAdapter.this.param.getChanScale() * TriggerRuntAdapter.this.param.getScaleNum())) - TriggerRuntAdapter.this.param.getChanOffset()) - ((TriggerRuntAdapter.this.param.getChanScale() * TriggerRuntAdapter.this.param.getScaleNum()) / 2));
                if (TriggerRuntAdapter.this.param.getRuntTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                    TriggerRuntAdapter.this.param.readruntLevelAttr();
                    TriggerRuntAdapter.this.param.readruntLevelBAttr();
                    if (progress < TriggerRuntAdapter.this.param.getruntLevelAttr().getMaxLongValue() - runtValue) {
                        TriggerRuntAdapter.this.param.saveRuntLevelBSync(progress);
                        TriggerRuntAdapter.this.param.saveRuntLevelASync(progress + runtValue);
                        return;
                    }
                    TriggerRuntAdapter.this.param.saveRuntLevelBSync(TriggerRuntAdapter.this.param.getruntLevelAttr().getMaxLongValue() - runtValue);
                    TriggerRuntAdapter.this.param.saveRuntLevelASync(TriggerRuntAdapter.this.param.getruntLevelAttr().getMaxLongValue());
                    return;
                }
                TriggerRuntAdapter.this.param.saveRuntLevelBSync(progress);
                TriggerRuntAdapter.this.param.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, TriggerRuntAdapter.this.param.getRuntlevelA());
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
                        return;
                    }
                    return;
                case R.id.less_more /* 2131363313 */:
                    this.aorBManager.set_RadioButton(0, 1);
                    if (this.param != null) {
                        this.param.saveRuntWhen(z ? 3 : 0);
                        return;
                    }
                    return;
                case R.id.less_than /* 2131363314 */:
                    this.aorBManager.set_RadioButton(0, 1);
                    if (this.param != null) {
                        this.param.saveRuntWhen(z ? 2 : 0);
                        return;
                    }
                    return;
                case R.id.more_than /* 2131363421 */:
                    this.aorBManager.set_RadioButton(0, 1);
                    TriggerParam triggerParam = this.param;
                    if (triggerParam != null) {
                        triggerParam.saveRuntWhen(z ? 1 : 0);
                        return;
                    }
                    return;
                case R.id.none /* 2131363480 */:
                    this.aorBManager.set_RadioButton(0, 1);
                    if (this.param != null) {
                        this.param.saveRuntWhen(0);
                        return;
                    }
                    return;
                case R.id.normal_radio_button /* 2131363483 */:
                    if (z) {
                        this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1);
                        return;
                    }
                    return;
                case R.id.runt_negative /* 2131363780 */:
                    TriggerParam triggerParam2 = this.param;
                    if (triggerParam2 != null) {
                        triggerParam2.saveRuntPolarity(z ? 1 : 0);
                        return;
                    }
                    return;
                case R.id.runt_positive /* 2131363781 */:
                    if (this.param != null) {
                        this.param.saveRuntPolarity(0);
                        return;
                    }
                    return;
                case R.id.single_radio_button /* 2131363859 */:
                    if (z) {
                        this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1);
                        return;
                    }
                    return;
                case R.id.trigger_level_select_a /* 2131364276 */:
                    if (this.param != null) {
                        this.param.saveRuntLevelSelect(0);
                        return;
                    }
                    return;
                case R.id.trigger_level_select_ab /* 2131364277 */:
                    if (this.param != null) {
                        this.param.saveRuntLevelSelect(z ? 2 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_level_select_b /* 2131364278 */:
                    TriggerParam triggerParam3 = this.param;
                    if (triggerParam3 != null) {
                        triggerParam3.saveRuntLevelSelect(z ? 1 : 0);
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
                    this.param.saveButtonLevelA();
                    break;
                }
                break;
            case R.id.button_levelB /* 2131362193 */:
                if (this.context instanceof Activity) {
                    this.param.saveButtonLevelB();
                    break;
                }
                break;
            case R.id.imageView2 /* 2131363100 */:
                if (this.param.getRuntPolarity() == ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive) {
                    this.param.saveRuntPolarity(ServiceEnum.TriggerPulsePolarity.Trigger_pulse_negative.value1);
                    break;
                } else if (this.param.getRuntPolarity() == ServiceEnum.TriggerPulsePolarity.Trigger_pulse_negative) {
                    this.param.saveRuntPolarity(ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive.value1);
                    break;
                }
                break;
            case R.id.lower_limit_value /* 2131363342 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readRuntLowerLimitAttr();
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getruntLowerAttr().getMaxLongValue(), this.param.getruntLowerAttr().getMinLongValue(), this.param.getruntLowerAttr().getDefLongValue(), this.param.getRuntLowerLimit(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerRuntAdapter.8
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerRuntAdapter.this.param.saveRuntLower(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerRuntAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.normal_radio_button /* 2131363483 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1);
                break;
            case R.id.single_radio_button /* 2131363859 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1);
                break;
            case R.id.trigger_holdoff /* 2131364231 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getHoldOffAttr().getMaxLongValue(), this.param.getHoldOffAttr().getMinLongValue(), this.param.getHoldOffAttr().getDefLongValue(), this.param.getHoldOff(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerRuntAdapter.4
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerRuntAdapter.this.param.saveholdOff(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerRuntAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_levelA_value /* 2131364270 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_LEVEL);
                    this.param.readruntLevelAttr();
                    TriggerParam triggerParam = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam.getChanUnit(triggerParam.getChannel()), this.param.getruntLevelAttr().getMaxLongValue(), this.param.getruntLevelAttr().getMinLongValue(), this.param.getruntLevelAttr().getDefLongValue(), this.param.getRuntlevelA(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerRuntAdapter.5
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            if (TriggerRuntAdapter.this.param.getRuntTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                                TriggerRuntAdapter.this.param.saveRuntLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_High.value1);
                            }
                            TriggerRuntAdapter.this.param.saveRuntLevelASync(((Long) t).longValue());
                            TriggerRuntAdapter.this.param.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, TriggerRuntAdapter.this.param.getRuntlevelB());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerRuntAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_levelB_value /* 2131364273 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_LEVEL);
                    this.param.readruntLevelBAttr();
                    TriggerParam triggerParam2 = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam2.getChanUnit(triggerParam2.getChannel()), this.param.getruntLevelBAttr().getMaxLongValue(), this.param.getruntLevelBAttr().getMinLongValue(), this.param.getruntLevelBAttr().getDefLongValue(), this.param.getRuntlevelB(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerRuntAdapter.6
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            if (TriggerRuntAdapter.this.param.getRuntTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                                TriggerRuntAdapter.this.param.saveRuntLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Low.value1);
                            }
                            TriggerRuntAdapter.this.param.saveRuntLevelBSync(((Long) t).longValue());
                            TriggerRuntAdapter.this.param.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, TriggerRuntAdapter.this.param.getRuntlevelA());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerRuntAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source /* 2131364336 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_source)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerRuntAdapter$VmgrxA70Y5pJ8KRQB_kXpRtnI74
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerRuntAdapter.this.lambda$onClick$3$TriggerRuntAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerRuntAdapter$ycQRxyfsE_T22nUgbsv4kGjVLU4
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerRuntAdapter.this.lambda$onClick$4$TriggerRuntAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.upper_limit_value /* 2131364524 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readRuntUpperLimitAttr();
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getruntUpperAttr().getMaxLongValue(), this.param.getruntUpperAttr().getMinLongValue(), this.param.getruntUpperAttr().getDefLongValue(), this.param.getRuntUperLimit(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerRuntAdapter.7
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerRuntAdapter.this.param.saveRuntUpper(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerRuntAdapter.this.keyboardPopupView = keyboardPopupView;
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

    public /* synthetic */ void lambda$onClick$3$TriggerRuntAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$TriggerRuntAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSource(mappingObject);
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        switch (i) {
            case R.id.lower_limit_value /* 2131363342 */:
                this.param.readRuntLowerLimitAttr();
                TriggerParam triggerParam = this.param;
                triggerParam.saveRuntLower(triggerParam.getLongStep(triggerParam.getRuntLowerLimit(), this.param.getruntLowerAttr(), z, keyEvent));
                return;
            case R.id.trigger_holdoff /* 2131364231 */:
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveholdOff(triggerParam2.getLongStep(triggerParam2.getHoldOff(), this.param.getHoldOffAttr(), z, keyEvent));
                return;
            case R.id.trigger_levelA_value /* 2131364270 */:
                if (!this.binding.triggerLevelSelectAb.isChecked()) {
                    this.param.setRuntTrigger_Level_ID(ServiceEnum.Trigger_Level_ID.Trigger_Level_High);
                }
                TriggerParam triggerParam3 = this.param;
                triggerParam3.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam3);
                return;
            case R.id.trigger_levelB_value /* 2131364273 */:
                if (!this.binding.triggerLevelSelectAb.isChecked()) {
                    this.param.setRuntTrigger_Level_ID(ServiceEnum.Trigger_Level_ID.Trigger_Level_Low);
                }
                TriggerParam triggerParam4 = this.param;
                triggerParam4.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam4);
                return;
            case R.id.upper_limit_value /* 2131364524 */:
                this.param.readRuntUpperLimitAttr();
                TriggerParam triggerParam5 = this.param;
                triggerParam5.saveRuntUpper(triggerParam5.getLongStep(triggerParam5.getRuntUperLimit(), this.param.getruntUpperAttr(), z, keyEvent));
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
            case R.id.lower_limit_value /* 2131363342 */:
                this.param.readRuntLowerLimitAttr();
                TriggerParam triggerParam = this.param;
                triggerParam.saveRuntLower(triggerParam.getLongDef(triggerParam.getruntLowerAttr()));
                return;
            case R.id.trigger_holdoff /* 2131364231 */:
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveholdOff(triggerParam2.getLongDef(triggerParam2.getHoldOffAttr()));
                return;
            case R.id.trigger_levelA_value /* 2131364270 */:
                if (this.param.getRuntTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                    TriggerParam triggerParam3 = this.param;
                    if (triggerParam3.getLongDef(triggerParam3.getruntLevelAttr()) < this.param.getRuntlevelB() + (this.param.getChanScale() / 10)) {
                        TriggerParam triggerParam4 = this.param;
                        triggerParam4.setLevelB(triggerParam4.getLongDef(triggerParam4.getruntLevelAttr()) - (this.param.getChanScale() / 10));
                        TriggerParam triggerParam5 = this.param;
                        triggerParam5.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, triggerParam5.getLongDef(triggerParam5.getruntLevelAttr()) - (this.param.getChanScale() / 10));
                        TriggerParam triggerParam6 = this.param;
                        triggerParam6.setRuntlevelB(triggerParam6.getLongDef(triggerParam6.getruntLevelAttr()) - (this.param.getChanScale() / 10));
                        API api = API.getInstance();
                        TriggerParam triggerParam7 = this.param;
                        api.UI_PostInt64(41, MessageID.MSG_SCPI_RUNT_LEVEL_L, triggerParam7.getLongDef(triggerParam7.getruntLevelAttr()) - (this.param.getChanScale() / 10));
                    }
                    TriggerParam triggerParam8 = this.param;
                    triggerParam8.setLevel(triggerParam8.getLongDef(triggerParam8.getruntLevelAttr()));
                    TriggerParam triggerParam9 = this.param;
                    triggerParam9.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, triggerParam9.getLongDef(triggerParam9.getruntLevelAttr()));
                    TriggerParam triggerParam10 = this.param;
                    triggerParam10.setRuntlevelA(triggerParam10.getLongDef(triggerParam10.getruntLevelAttr()));
                    API api2 = API.getInstance();
                    TriggerParam triggerParam11 = this.param;
                    api2.UI_PostInt64(41, MessageID.MSG_SCPI_RUNT_LEVEL_H, triggerParam11.getLongDef(triggerParam11.getruntLevelAttr()));
                    this.param.saveRuntLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Double.value1);
                    return;
                }
                TriggerParam triggerParam12 = this.param;
                triggerParam12.saveRuntLevelASync(triggerParam12.getLongDef(triggerParam12.getruntLevelAttr()));
                return;
            case R.id.trigger_levelB_value /* 2131364273 */:
                if (this.param.getRuntTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                    TriggerParam triggerParam13 = this.param;
                    if (triggerParam13.getLongDef(triggerParam13.getruntLevelBAttr()) > this.param.getRuntlevelA() - (this.param.getChanScale() / 10)) {
                        TriggerParam triggerParam14 = this.param;
                        triggerParam14.setLevel(triggerParam14.getLongDef(triggerParam14.getruntLevelBAttr()) + (this.param.getChanScale() / 10));
                        TriggerParam triggerParam15 = this.param;
                        triggerParam15.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, triggerParam15.getLongDef(triggerParam15.getruntLevelBAttr()) + (this.param.getChanScale() / 10));
                        TriggerParam triggerParam16 = this.param;
                        triggerParam16.setRuntlevelA(triggerParam16.getLongDef(triggerParam16.getruntLevelBAttr()) + (this.param.getChanScale() / 10));
                        API api3 = API.getInstance();
                        TriggerParam triggerParam17 = this.param;
                        api3.UI_PostInt64(41, MessageID.MSG_SCPI_RUNT_LEVEL_H, triggerParam17.getLongDef(triggerParam17.getruntLevelBAttr()) + (this.param.getChanScale() / 10));
                    }
                    TriggerParam triggerParam18 = this.param;
                    triggerParam18.setLevelB(triggerParam18.getLongDef(triggerParam18.getruntLevelBAttr()));
                    TriggerParam triggerParam19 = this.param;
                    triggerParam19.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, triggerParam19.getLongDef(triggerParam19.getruntLevelBAttr()));
                    TriggerParam triggerParam20 = this.param;
                    triggerParam20.setRuntlevelB(triggerParam20.getLongDef(triggerParam20.getruntLevelBAttr()));
                    API api4 = API.getInstance();
                    TriggerParam triggerParam21 = this.param;
                    api4.UI_PostInt64(41, MessageID.MSG_SCPI_RUNT_LEVEL_L, triggerParam21.getLongDef(triggerParam21.getruntLevelBAttr()));
                    this.param.saveRuntLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Double.value1);
                    return;
                }
                TriggerParam triggerParam22 = this.param;
                triggerParam22.saveRuntLevelBSync(triggerParam22.getLongDef(triggerParam22.getruntLevelBAttr()));
                return;
            case R.id.upper_limit_value /* 2131364524 */:
                this.param.readRuntUpperLimitAttr();
                TriggerParam triggerParam23 = this.param;
                triggerParam23.saveRuntUpper(triggerParam23.getLongDef(triggerParam23.getruntUpperAttr()));
                return;
            default:
                return;
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextByTriggerLevelRoll
    public void onTriggerLevelRollCallback(KeyEvent keyEvent, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        TriggerParam triggerParam = this.param;
        triggerParam.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam);
    }

    /* loaded from: classes.dex */
    public class TriggerRuntHolder extends RecyclerView.ViewHolder {
        private AdapterTriggerRuntBinding binding;

        public TriggerRuntHolder(AdapterTriggerRuntBinding adapterTriggerRuntBinding) {
            super(adapterTriggerRuntBinding.getRoot());
            this.binding = adapterTriggerRuntBinding;
        }
    }
}
