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
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.databinding.AdapterTriggerOverBinding;
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
public class TriggerOverAdapter extends RecyclerView.Adapter<TriggerOverHolder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset, AorBManager.OnSetTextByTriggerLevelRoll {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterTriggerOverBinding binding;
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

    public TriggerOverAdapter(Context context, BasePopupView basePopupView, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        this.triggerViewModel = triggerViewModel;
        this.param = triggerParam;
        this.popupView = basePopupView;
        this.context = context;
        this.serviceId = triggerParam.getServiceId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TriggerOverHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterTriggerOverBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelAValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelBValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.overTriggerTimeValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerHoldoff, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSource, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelSelect, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this, this) { // from class: com.rigol.scope.adapters.TriggerOverAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                TriggerOverAdapter.this.aorBManager.showKey(TriggerOverAdapter.this.context, ((AorBParam) TriggerOverAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) TriggerOverAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                TriggerOverAdapter.this.aorBManager.showKey(TriggerOverAdapter.this.context, ((AorBParam) TriggerOverAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) TriggerOverAdapter.this.list_aorbParam.get(i2)).getAorb());
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
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerOverAdapter$seT-lY_kC1-U9hovHq6R9U3Ayic
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TriggerOverAdapter.this.lambda$onCreateViewHolder$2$TriggerOverAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new TriggerOverHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$TriggerOverAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (this.popviewTriggerBinding.triggerView.getAdapter() instanceof TriggerOverAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerOverAdapter$musEybtSDES2GgSsA3HBHDa6qFU
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerOverAdapter.this.lambda$onCreateViewHolder$0$TriggerOverAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerOverAdapter$abQN9kX4x7e5MDXKKnN0sxOFL9E
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    TriggerOverAdapter.this.lambda$onCreateViewHolder$1$TriggerOverAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$TriggerOverAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$TriggerOverAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.trigger_source) {
            selectSource(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_level_select) {
            selectLevel(mappingObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TriggerOverHolder triggerOverHolder, int i) {
        ShowTriggerOver();
        triggerOverHolder.binding.executePendingBindings();
    }

    public void ShowTriggerOver() {
        ServiceEnum.Chan chan = this.param.getChan();
        if (chan == ServiceEnum.Chan.acline || chan == ServiceEnum.Chan.ext) {
            this.param.setChannel(ServiceEnum.Chan.chan1.value1);
            this.param.saveOverSource(ServiceEnum.Chan.chan1.value1);
        } else {
            this.param.setChan(ServiceEnum.getChanFromValue1(chan.value1));
        }
        this.param.setChanColor(this.binding.triggerSource, chan);
        this.param.readOverPos();
        this.param.readOverSlope();
        this.param.readOverTime();
        this.param.readOverLevelSelect();
        this.param.readOverHighLevel();
        this.param.readOverLowLevel();
        this.param.checkLevel();
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        this.binding.setSlopeRisingMapping(ViewUtil.getMappingObject(R.array.msg_trigger_over_slope, ServiceEnum.EdgeSlope.Trigger_Edge_Rising.value1));
        this.binding.setSlopeFallingMapping(ViewUtil.getMappingObject(R.array.msg_trigger_over_slope, ServiceEnum.EdgeSlope.Trigger_Edge_Falling.value1));
        this.binding.setSlopeEitherMapping(ViewUtil.getMappingObject(R.array.msg_trigger_over_slope, ServiceEnum.EdgeSlope.Trigger_Edge_Alternating.value1));
        this.binding.setPositionEnterMapping(ViewUtil.getMappingObject(R.array.msg_trigger_over_pos, ServiceEnum.OverEvent.Trigger_over_enter.value1));
        this.binding.setPositionExitMapping(ViewUtil.getMappingObject(R.array.msg_trigger_over_pos, ServiceEnum.OverEvent.Trigger_over_exit.value1));
        this.binding.setPositionTimeMapping(ViewUtil.getMappingObject(R.array.msg_trigger_over_pos, ServiceEnum.OverEvent.Trigger_over_time.value1));
        this.binding.setParam(this.param);
        ViewUtil.setSwitchButton(this.binding.triggerNoiseSwitch);
        this.binding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.triggerOverEdgeRising.setOnCheckedChangeListener(this);
        this.binding.triggerOverEdgeFalling.setOnCheckedChangeListener(this);
        this.binding.triggerOverEdgeEither.setOnCheckedChangeListener(this);
        this.binding.overTriggerEnter.setOnCheckedChangeListener(this);
        this.binding.overTriggerExit.setOnCheckedChangeListener(this);
        this.binding.overTriggerTime.setOnCheckedChangeListener(this);
        this.binding.buttonLevel.setOnClickListener(this);
        this.binding.buttonLevelB.setOnClickListener(this);
        this.binding.imageView2.setOnClickListener(this);
        this.binding.triggerSource.setOnClickListener(this);
        this.binding.triggerLevelSelect.setOnClickListener(this);
        this.binding.triggerHoldoff.setOnClickListener(this);
        this.binding.triggerLevelAValue.setOnClickListener(this);
        this.binding.triggerLevelBValue.setOnClickListener(this);
        this.binding.triggerLevelSelectAb.setOnCheckedChangeListener(this);
        this.binding.overTriggerTimeValue.setOnClickListener(this);
        this.binding.triggerLevelAView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.adapters.TriggerOverAdapter.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long progress = (long) ((((seekBar.getProgress() / 100.0d) * (TriggerOverAdapter.this.param.getChanScale() * TriggerOverAdapter.this.param.getScaleNum())) - TriggerOverAdapter.this.param.getChanOffset()) - ((TriggerOverAdapter.this.param.getChanScale() * TriggerOverAdapter.this.param.getScaleNum()) / 2));
                    if (TriggerOverAdapter.this.param.getOverTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                        TriggerOverAdapter.this.param.saveOverLevelASync(progress);
                        return;
                    }
                    TriggerOverAdapter.this.param.saveOverLevelASync(progress);
                    TriggerOverAdapter.this.param.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, TriggerOverAdapter.this.param.getOverlevelB());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                long progress = (long) ((((seekBar.getProgress() / 100.0d) * (TriggerOverAdapter.this.param.getChanScale() * TriggerOverAdapter.this.param.getScaleNum())) - TriggerOverAdapter.this.param.getChanOffset()) - ((TriggerOverAdapter.this.param.getChanScale() * TriggerOverAdapter.this.param.getScaleNum()) / 2));
                if (TriggerOverAdapter.this.param.getOverTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                    TriggerOverAdapter.this.param.saveOverLevelASync(progress);
                    return;
                }
                TriggerOverAdapter.this.param.saveOverLevelASync(progress);
                TriggerOverAdapter.this.param.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, TriggerOverAdapter.this.param.getOverlevelB());
            }
        });
        this.binding.triggerLevelBView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.adapters.TriggerOverAdapter.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long overValue = TriggerOverAdapter.this.param.getOverValue();
                    long progress = (long) ((((seekBar.getProgress() / 100.0d) * (TriggerOverAdapter.this.param.getChanScale() * TriggerOverAdapter.this.param.getScaleNum())) - TriggerOverAdapter.this.param.getChanOffset()) - ((TriggerOverAdapter.this.param.getChanScale() * TriggerOverAdapter.this.param.getScaleNum()) / 2));
                    if (TriggerOverAdapter.this.param.getOverTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                        TriggerOverAdapter.this.param.readoverLevelAttr();
                        TriggerOverAdapter.this.param.readoverLevelBAttr();
                        if (progress < TriggerOverAdapter.this.param.getoverLevelAttr().getMaxLongValue() - overValue) {
                            TriggerOverAdapter.this.param.saveOverLevelBSync(progress);
                            TriggerOverAdapter.this.param.saveOverLevelASync(progress + overValue);
                            return;
                        }
                        TriggerOverAdapter.this.param.saveOverLevelBSync(TriggerOverAdapter.this.param.getoverLevelAttr().getMaxLongValue() - overValue);
                        TriggerOverAdapter.this.param.saveOverLevelASync(TriggerOverAdapter.this.param.getoverLevelAttr().getMaxLongValue());
                        return;
                    }
                    TriggerOverAdapter.this.param.saveOverLevelBSync(progress);
                    MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL_A), Long.valueOf(TriggerOverAdapter.this.param.getOverlevelA()));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                long overValue = TriggerOverAdapter.this.param.getOverValue();
                long progress = (long) ((((seekBar.getProgress() / 100.0d) * (TriggerOverAdapter.this.param.getChanScale() * TriggerOverAdapter.this.param.getScaleNum())) - TriggerOverAdapter.this.param.getChanOffset()) - ((TriggerOverAdapter.this.param.getChanScale() * TriggerOverAdapter.this.param.getScaleNum()) / 2));
                if (TriggerOverAdapter.this.param.getOverTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                    TriggerOverAdapter.this.param.readoverLevelAttr();
                    TriggerOverAdapter.this.param.readoverLevelBAttr();
                    if (progress < TriggerOverAdapter.this.param.getoverLevelAttr().getMaxLongValue() - overValue) {
                        TriggerOverAdapter.this.param.saveOverLevelBSync(progress);
                        TriggerOverAdapter.this.param.saveOverLevelASync(progress + overValue);
                        return;
                    }
                    TriggerOverAdapter.this.param.saveOverLevelBSync(TriggerOverAdapter.this.param.getoverLevelAttr().getMaxLongValue() - overValue);
                    TriggerOverAdapter.this.param.saveOverLevelASync(TriggerOverAdapter.this.param.getoverLevelAttr().getMaxLongValue());
                    return;
                }
                TriggerOverAdapter.this.param.saveOverLevelBSync(progress);
                MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL_A), Long.valueOf(TriggerOverAdapter.this.param.getOverlevelA()));
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
                case R.id.normal_radio_button /* 2131363483 */:
                    if (z) {
                        this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1);
                        return;
                    }
                    return;
                case R.id.over_trigger_enter /* 2131363522 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveOverEvent(0);
                        return;
                    }
                    return;
                case R.id.over_trigger_exit /* 2131363523 */:
                    this.aorBManager.set_RadioButton();
                    TriggerParam triggerParam = this.param;
                    if (triggerParam != null) {
                        triggerParam.saveOverEvent(z ? 1 : 0);
                        return;
                    }
                    return;
                case R.id.over_trigger_time /* 2131363525 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveOverEvent(z ? 2 : 0);
                        return;
                    }
                    return;
                case R.id.single_radio_button /* 2131363859 */:
                    if (z) {
                        this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1);
                        return;
                    }
                    return;
                case R.id.trigger_level_select_ab /* 2131364277 */:
                    if (this.param != null) {
                        this.param.saveOverSelect(z ? 2 : 0);
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
                case R.id.trigger_over_edge_either /* 2131364318 */:
                    if (this.param != null) {
                        this.param.saveOverSlope(z ? ServiceEnum.EdgeSlope.Trigger_Edge_Any.value1 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_over_edge_falling /* 2131364319 */:
                    if (this.param != null) {
                        this.param.saveOverSlope(z ? ServiceEnum.EdgeSlope.Trigger_Edge_Falling.value1 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_over_edge_rising /* 2131364321 */:
                    if (this.param != null) {
                        this.param.saveOverSlope(z ? ServiceEnum.EdgeSlope.Trigger_Edge_Rising.value1 : 0);
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
                if (this.param.getOverSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Rising) {
                    if (this.param.getOverEvent() == ServiceEnum.OverEvent.Trigger_over_enter) {
                        this.param.saveOverEvent(ServiceEnum.OverEvent.Trigger_over_exit.value1);
                        break;
                    } else if (this.param.getOverEvent() == ServiceEnum.OverEvent.Trigger_over_exit) {
                        this.param.saveOverEvent(ServiceEnum.OverEvent.Trigger_over_time.value1);
                        break;
                    } else {
                        this.param.saveOverSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Falling.value1);
                        this.param.saveOverEvent(ServiceEnum.OverEvent.Trigger_over_enter.value1);
                        break;
                    }
                } else if (this.param.getOverSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Falling) {
                    if (this.param.getOverEvent() == ServiceEnum.OverEvent.Trigger_over_enter) {
                        this.param.saveOverEvent(ServiceEnum.OverEvent.Trigger_over_exit.value1);
                        break;
                    } else if (this.param.getOverEvent() == ServiceEnum.OverEvent.Trigger_over_exit) {
                        this.param.saveOverEvent(ServiceEnum.OverEvent.Trigger_over_time.value1);
                        break;
                    } else {
                        this.param.saveOverSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Any.value1);
                        this.param.saveOverEvent(ServiceEnum.OverEvent.Trigger_over_enter.value1);
                        break;
                    }
                } else if (this.param.getOverSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Any) {
                    if (this.param.getOverEvent() == ServiceEnum.OverEvent.Trigger_over_enter) {
                        this.param.saveOverEvent(ServiceEnum.OverEvent.Trigger_over_exit.value1);
                        break;
                    } else if (this.param.getOverEvent() == ServiceEnum.OverEvent.Trigger_over_exit) {
                        this.param.saveOverEvent(ServiceEnum.OverEvent.Trigger_over_time.value1);
                        break;
                    } else {
                        this.param.saveOverSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Rising.value1);
                        this.param.saveOverEvent(ServiceEnum.OverEvent.Trigger_over_enter.value1);
                        break;
                    }
                }
                break;
            case R.id.normal_radio_button /* 2131363483 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1);
                break;
            case R.id.over_trigger_time_value /* 2131363527 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readOverTimeAttr();
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getOverTimeAttr().getMaxLongValue(), this.param.getOverTimeAttr().getMinLongValue(), this.param.getOverTimeAttr().getDefLongValue(), this.param.getOverTime(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerOverAdapter.7
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerOverAdapter.this.param.saveOverTimeValue(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerOverAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.single_radio_button /* 2131363859 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1);
                break;
            case R.id.trigger_holdoff /* 2131364231 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getHoldOffAttr().getMaxLongValue(), this.param.getHoldOffAttr().getMinLongValue(), this.param.getHoldOffAttr().getDefLongValue(), this.param.getHoldOff(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerOverAdapter.4
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerOverAdapter.this.param.saveholdOff(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerOverAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_levelA_value /* 2131364270 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_LEVEL);
                    this.param.readoverLevelAttr();
                    TriggerParam triggerParam = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam.getChanUnit(triggerParam.getChannel()), this.param.getoverLevelAttr().getMaxLongValue(), this.param.getoverLevelAttr().getMinLongValue(), this.param.getoverLevelAttr().getDefLongValue(), this.param.getOverlevelA(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerOverAdapter.5
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            if (TriggerOverAdapter.this.param.getOverTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                                TriggerOverAdapter.this.param.saveOverSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_High.value1);
                            }
                            TriggerOverAdapter.this.param.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, TriggerOverAdapter.this.param.getOverlevelB());
                            TriggerOverAdapter.this.param.saveOverLevelASync(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerOverAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_levelB_value /* 2131364273 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_LEVEL);
                    this.param.readoverLevelBAttr();
                    TriggerParam triggerParam2 = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam2.getChanUnit(triggerParam2.getChannel()), this.param.getoverLevelBAttr().getMaxLongValue(), this.param.getoverLevelBAttr().getMinLongValue(), this.param.getoverLevelBAttr().getDefLongValue(), this.param.getOverlevelB(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerOverAdapter.6
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            if (TriggerOverAdapter.this.param.getOverTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                                TriggerOverAdapter.this.param.saveOverSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Low.value1);
                            }
                            TriggerOverAdapter.this.param.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, TriggerOverAdapter.this.param.getOverlevelA());
                            TriggerOverAdapter.this.param.saveOverLevelBSync(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerOverAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_level_select /* 2131364275 */:
                if (this.popupView != null) {
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_trigger_levelselect), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerOverAdapter$6euZkSpllvAAo-zi6Hr6iVVnXp0
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerOverAdapter.this.lambda$onClick$5$TriggerOverAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerOverAdapter$qiKzUyiOWHTCu-GKLrWymB7IfcU
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerOverAdapter.this.lambda$onClick$6$TriggerOverAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source /* 2131364336 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_source)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerOverAdapter$mtWyH7VaiK9lJrIFQSSe5z2mSq8
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerOverAdapter.this.lambda$onClick$3$TriggerOverAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerOverAdapter$1HfBbDKKyBYaHK9TvuIacjMrmD4
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerOverAdapter.this.lambda$onClick$4$TriggerOverAdapter(view2, viewHolder, i, (MappingObject) obj);
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

    public /* synthetic */ void lambda$onClick$3$TriggerOverAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$TriggerOverAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSource(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$5$TriggerOverAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$TriggerOverAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectLevel(mappingObject);
    }

    private void selectLevel(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveOverSelect(mappingObject.getValue());
        }
    }

    private void selectSource(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveOverSource(mappingObject.getValue());
            this.param.setChannel(mappingObject.getValue());
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        switch (i) {
            case R.id.over_trigger_time_value /* 2131363527 */:
                this.param.readOverTimeAttr();
                TriggerParam triggerParam = this.param;
                triggerParam.saveOverTimeValue(triggerParam.getLongStep(triggerParam.getOverTime(), this.param.getOverTimeAttr(), z, keyEvent));
                return;
            case R.id.trigger_holdoff /* 2131364231 */:
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveholdOff(triggerParam2.getLongStep(triggerParam2.getHoldOff(), this.param.getHoldOffAttr(), z, keyEvent));
                return;
            case R.id.trigger_levelA_value /* 2131364270 */:
                if (!this.binding.triggerLevelSelectAb.isChecked()) {
                    this.param.setOverTrigger_Level_ID(ServiceEnum.Trigger_Level_ID.Trigger_Level_High);
                }
                TriggerParam triggerParam3 = this.param;
                triggerParam3.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam3);
                return;
            case R.id.trigger_levelB_value /* 2131364273 */:
                if (!this.binding.triggerLevelSelectAb.isChecked()) {
                    this.param.setOverTrigger_Level_ID(ServiceEnum.Trigger_Level_ID.Trigger_Level_Low);
                }
                TriggerParam triggerParam4 = this.param;
                triggerParam4.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam4);
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
            case R.id.over_trigger_time_value /* 2131363527 */:
                this.param.readOverTimeAttr();
                TriggerParam triggerParam = this.param;
                triggerParam.saveOverTimeValue(triggerParam.getLongDef(triggerParam.getOverTimeAttr()));
                return;
            case R.id.trigger_holdoff /* 2131364231 */:
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveholdOff(triggerParam2.getLongDef(triggerParam2.getHoldOffAttr()));
                return;
            case R.id.trigger_levelA_value /* 2131364270 */:
                if (this.param.getOverTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                    TriggerParam triggerParam3 = this.param;
                    if (triggerParam3.getLongDef(triggerParam3.getoverLevelAttr()) < this.param.getOverlevelB() + (this.param.getChanScale() / 10)) {
                        TriggerParam triggerParam4 = this.param;
                        triggerParam4.setLevelB(triggerParam4.getLongDef(triggerParam4.getoverLevelAttr()) - (this.param.getChanScale() / 10));
                        TriggerParam triggerParam5 = this.param;
                        triggerParam5.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, triggerParam5.getLongDef(triggerParam5.getoverLevelAttr()) - (this.param.getChanScale() / 10));
                        TriggerParam triggerParam6 = this.param;
                        triggerParam6.setOverlevelB(triggerParam6.getLongDef(triggerParam6.getoverLevelAttr()) - (this.param.getChanScale() / 10));
                        API api = API.getInstance();
                        TriggerParam triggerParam7 = this.param;
                        api.UI_PostInt64(41, MessageID.MSG_TRIGGER_OVER_LEVEL_L, triggerParam7.getLongDef(triggerParam7.getoverLevelAttr()) - (this.param.getChanScale() / 10));
                    }
                    TriggerParam triggerParam8 = this.param;
                    triggerParam8.setLevel(triggerParam8.getLongDef(triggerParam8.getoverLevelAttr()));
                    TriggerParam triggerParam9 = this.param;
                    triggerParam9.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, triggerParam9.getLongDef(triggerParam9.getoverLevelAttr()));
                    TriggerParam triggerParam10 = this.param;
                    triggerParam10.setOverlevelA(triggerParam10.getLongDef(triggerParam10.getoverLevelAttr()));
                    API api2 = API.getInstance();
                    TriggerParam triggerParam11 = this.param;
                    api2.UI_PostInt64(41, MessageID.MSG_TRIGGER_OVER_LEVEL_H, triggerParam11.getLongDef(triggerParam11.getoverLevelAttr()));
                    this.param.saveOverSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Double.value1);
                    return;
                }
                TriggerParam triggerParam12 = this.param;
                triggerParam12.saveOverLevelASync(triggerParam12.getLongDef(triggerParam12.getoverLevelAttr()));
                return;
            case R.id.trigger_levelB_value /* 2131364273 */:
                if (this.param.getOverTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                    TriggerParam triggerParam13 = this.param;
                    if (triggerParam13.getLongDef(triggerParam13.getoverLevelBAttr()) > this.param.getOverlevelA() - (this.param.getChanScale() / 10)) {
                        TriggerParam triggerParam14 = this.param;
                        triggerParam14.setLevel(triggerParam14.getLongDef(triggerParam14.getoverLevelBAttr()) + (this.param.getChanScale() / 10));
                        TriggerParam triggerParam15 = this.param;
                        triggerParam15.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, triggerParam15.getLongDef(triggerParam15.getoverLevelBAttr()) + (this.param.getChanScale() / 10));
                        TriggerParam triggerParam16 = this.param;
                        triggerParam16.setOverlevelA(triggerParam16.getLongDef(triggerParam16.getoverLevelBAttr()) + (this.param.getChanScale() / 10));
                        API api3 = API.getInstance();
                        TriggerParam triggerParam17 = this.param;
                        api3.UI_PostInt64(41, MessageID.MSG_TRIGGER_OVER_LEVEL_H, triggerParam17.getLongDef(triggerParam17.getoverLevelBAttr()) + (this.param.getChanScale() / 10));
                    }
                    TriggerParam triggerParam18 = this.param;
                    triggerParam18.setLevelB(triggerParam18.getLongDef(triggerParam18.getoverLevelBAttr()));
                    TriggerParam triggerParam19 = this.param;
                    triggerParam19.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, triggerParam19.getLongDef(triggerParam19.getoverLevelBAttr()));
                    TriggerParam triggerParam20 = this.param;
                    triggerParam20.setOverlevelB(triggerParam20.getLongDef(triggerParam20.getslopeLevelBAttr()));
                    API api4 = API.getInstance();
                    TriggerParam triggerParam21 = this.param;
                    api4.UI_PostInt64(41, MessageID.MSG_TRIGGER_OVER_LEVEL_L, triggerParam21.getLongDef(triggerParam21.getoverLevelBAttr()));
                    this.param.saveOverSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Double.value1);
                    return;
                }
                TriggerParam triggerParam22 = this.param;
                triggerParam22.saveOverLevelBSync(triggerParam22.getLongDef(triggerParam22.getoverLevelBAttr()));
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
    public class TriggerOverHolder extends RecyclerView.ViewHolder {
        private AdapterTriggerOverBinding binding;

        public TriggerOverHolder(AdapterTriggerOverBinding adapterTriggerOverBinding) {
            super(adapterTriggerOverBinding.getRoot());
            this.binding = adapterTriggerOverBinding;
        }
    }
}
