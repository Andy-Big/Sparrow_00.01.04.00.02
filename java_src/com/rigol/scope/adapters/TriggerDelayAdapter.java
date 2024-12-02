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
import com.rigol.scope.databinding.AdapterTriggerDelayBinding;
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
public class TriggerDelayAdapter extends RecyclerView.Adapter<TriggerDelayHolder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterTriggerDelayBinding binding;
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

    public TriggerDelayAdapter(Context context, BasePopupView basePopupView, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        this.triggerViewModel = triggerViewModel;
        this.param = triggerParam;
        this.popupView = basePopupView;
        this.context = context;
        this.serviceId = triggerParam.getServiceId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TriggerDelayHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterTriggerDelayBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelAValue, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelBValue, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerHoldoff, 0, false, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.upperLimitValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.lowerLimitValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSourceA, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSourceB, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.TriggerDelayAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                TriggerDelayAdapter.this.aorBManager.showKey(TriggerDelayAdapter.this.context, ((AorBParam) TriggerDelayAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) TriggerDelayAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                TriggerDelayAdapter.this.aorBManager.showKey(TriggerDelayAdapter.this.context, ((AorBParam) TriggerDelayAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) TriggerDelayAdapter.this.list_aorbParam.get(i2)).getAorb());
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
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerDelayAdapter$JDFEAf9qc6dggmSgdlxpfk7N_Q4
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TriggerDelayAdapter.this.lambda$onCreateViewHolder$2$TriggerDelayAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new TriggerDelayHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$TriggerDelayAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (this.popviewTriggerBinding.triggerView.getAdapter() instanceof TriggerDelayAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerDelayAdapter$6AsTNLyvkiriz4RxH-jRGNwnnn8
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerDelayAdapter.this.lambda$onCreateViewHolder$0$TriggerDelayAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerDelayAdapter$YW8aumfvrioIVTOzu8QLjtnG9Ho
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    TriggerDelayAdapter.this.lambda$onCreateViewHolder$1$TriggerDelayAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$TriggerDelayAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$TriggerDelayAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.trigger_source_a) {
            selectSourceA(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_source_b) {
            selectSourceB(mappingObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TriggerDelayHolder triggerDelayHolder, int i) {
        ShowTriggerDelay();
        triggerDelayHolder.binding.executePendingBindings();
    }

    public void ShowTriggerDelay() {
        ServiceEnum.Chan chan = this.param.getChan();
        if (chan == ServiceEnum.Chan.acline || chan == ServiceEnum.Chan.ext) {
            this.param.saveDelaySourceA(ServiceEnum.Chan.chan1.value1);
        } else {
            this.param.setDelayChanA(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_DELAY_SRCA)));
        }
        this.param.setDelayChanB(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_DELAY_SRCB)));
        this.param.readDelayWhen();
        this.param.readDelaySlopeA();
        this.param.readDelaySlopeB();
        this.param.readDelayLwidth();
        this.param.readDelayUwidth();
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        this.binding.setEdgeRisingAMapping(ViewUtil.getMappingObject(R.array.msg_trigger_edgea, ServiceEnum.EdgeSlope.Trigger_Edge_Rising.value1));
        this.binding.setEdgeFallingAMapping(ViewUtil.getMappingObject(R.array.msg_trigger_edgea, ServiceEnum.EdgeSlope.Trigger_Edge_Falling.value1));
        this.binding.setEdgeRisingBMapping(ViewUtil.getMappingObject(R.array.msg_trigger_edgeb, ServiceEnum.EdgeSlope.Trigger_Edge_Rising.value1));
        this.binding.setEdgeFallingBMapping(ViewUtil.getMappingObject(R.array.msg_trigger_edgeb, ServiceEnum.EdgeSlope.Trigger_Edge_Falling.value1));
        this.binding.setParam(this.param);
        ViewUtil.setSwitchButton(this.binding.triggerNoiseSwitch);
        this.binding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.moreThan.setOnCheckedChangeListener(this);
        this.binding.lessMore.setOnCheckedChangeListener(this);
        this.binding.moreLess.setOnCheckedChangeListener(this);
        this.binding.lessThan.setOnCheckedChangeListener(this);
        this.binding.edgeARising.setOnCheckedChangeListener(this);
        this.binding.edgeAFalling.setOnCheckedChangeListener(this);
        this.binding.edgeBRising.setOnCheckedChangeListener(this);
        this.binding.edgeBFalling.setOnCheckedChangeListener(this);
        this.binding.buttonLevel.setOnClickListener(this);
        this.binding.buttonLevelB.setOnClickListener(this);
        this.binding.imageView2.setOnClickListener(this);
        this.binding.triggerSourceA.setOnClickListener(this);
        this.binding.triggerSourceB.setOnClickListener(this);
        this.binding.triggerHoldoff.setOnClickListener(this);
        this.binding.triggerLevelAValue.setOnClickListener(this);
        this.binding.triggerLevelBValue.setOnClickListener(this);
        this.binding.upperLimitValue.setOnClickListener(this);
        this.binding.lowerLimitValue.setOnClickListener(this);
        this.binding.triggerLevelAView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.adapters.TriggerDelayAdapter.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    ServiceEnum.Chan delayChanA = TriggerDelayAdapter.this.param.getDelayChanA();
                    long UI_QueryInt64 = API.getInstance().UI_QueryInt64(delayChanA.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
                    long UI_QueryInt642 = API.getInstance().UI_QueryInt64(delayChanA.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
                    TriggerDelayAdapter.this.param.saveDelayLevelA((long) ((((seekBar.getProgress() / 100.0d) * (UI_QueryInt64 * TriggerDelayAdapter.this.param.getScaleNum())) - UI_QueryInt642) - ((UI_QueryInt64 * TriggerDelayAdapter.this.param.getScaleNum()) / 2)));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                ServiceEnum.Chan delayChanA = TriggerDelayAdapter.this.param.getDelayChanA();
                long UI_QueryInt64 = API.getInstance().UI_QueryInt64(delayChanA.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
                long UI_QueryInt642 = API.getInstance().UI_QueryInt64(delayChanA.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
                TriggerDelayAdapter.this.param.saveDelayLevelA((long) ((((seekBar.getProgress() / 100.0d) * (UI_QueryInt64 * TriggerDelayAdapter.this.param.getScaleNum())) - UI_QueryInt642) - ((UI_QueryInt64 * TriggerDelayAdapter.this.param.getScaleNum()) / 2)));
            }
        });
        this.binding.triggerLevelBView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.adapters.TriggerDelayAdapter.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    ServiceEnum.Chan delayChanB = TriggerDelayAdapter.this.param.getDelayChanB();
                    long UI_QueryInt64 = API.getInstance().UI_QueryInt64(delayChanB.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
                    long UI_QueryInt642 = API.getInstance().UI_QueryInt64(delayChanB.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
                    TriggerDelayAdapter.this.param.saveDelayLevelB((long) ((((seekBar.getProgress() / 100.0d) * (UI_QueryInt64 * TriggerDelayAdapter.this.param.getScaleNum())) - UI_QueryInt642) - ((UI_QueryInt64 * TriggerDelayAdapter.this.param.getScaleNum()) / 2)));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                ServiceEnum.Chan delayChanB = TriggerDelayAdapter.this.param.getDelayChanB();
                long UI_QueryInt64 = API.getInstance().UI_QueryInt64(delayChanB.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
                long UI_QueryInt642 = API.getInstance().UI_QueryInt64(delayChanB.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
                TriggerDelayAdapter.this.param.saveDelayLevelB((long) ((((seekBar.getProgress() / 100.0d) * (UI_QueryInt64 * TriggerDelayAdapter.this.param.getScaleNum())) - UI_QueryInt642) - ((UI_QueryInt64 * TriggerDelayAdapter.this.param.getScaleNum()) / 2)));
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
                case R.id.edge_a_falling /* 2131362729 */:
                    TriggerParam triggerParam = this.param;
                    if (triggerParam != null) {
                        triggerParam.saveDelaySlopeA(z);
                        return;
                    }
                    return;
                case R.id.edge_a_rising /* 2131362730 */:
                    if (this.param != null) {
                        this.param.saveDelaySlopeA(false);
                        return;
                    }
                    return;
                case R.id.edge_b_falling /* 2131362731 */:
                    TriggerParam triggerParam2 = this.param;
                    if (triggerParam2 != null) {
                        triggerParam2.saveDelaySlopeB(z);
                        return;
                    }
                    return;
                case R.id.edge_b_rising /* 2131362732 */:
                    if (this.param != null) {
                        this.param.saveDelaySlopeB(false);
                        return;
                    }
                    return;
                case R.id.less_more /* 2131363313 */:
                    this.aorBManager.set_RadioButton(0, 1);
                    this.aorBManager.set_RadioButton(0, 1);
                    if (this.param != null) {
                        this.param.saveDelayWhen(z ? 3 : 0);
                        return;
                    }
                    return;
                case R.id.less_than /* 2131363314 */:
                    this.aorBManager.set_RadioButton(0, 1);
                    this.aorBManager.set_RadioButton(0, 1);
                    if (this.param != null) {
                        this.param.saveDelayWhen(z ? 2 : 0);
                        return;
                    }
                    return;
                case R.id.more_less /* 2131363420 */:
                    this.aorBManager.set_RadioButton(0, 1);
                    this.aorBManager.set_RadioButton(0, 1);
                    if (this.param != null) {
                        this.param.saveDelayWhen(z ? 4 : 0);
                        return;
                    }
                    return;
                case R.id.more_than /* 2131363421 */:
                    this.aorBManager.set_RadioButton(0, 1);
                    this.aorBManager.set_RadioButton(0, 1);
                    TriggerParam triggerParam3 = this.param;
                    if (triggerParam3 != null) {
                        triggerParam3.saveDelayWhen(z ? 1 : 0);
                        return;
                    }
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
                    triggerParam.setChan(triggerParam.getDelayChanA());
                    API.getInstance().UI_PostInt32(this.serviceId, MessageID.MSG_TRIGGER_DELAY_SRCA, this.param.getDelayChanA().value1);
                    this.param.saveButtonLevel();
                    break;
                }
                break;
            case R.id.button_levelB /* 2131362193 */:
                if (this.context instanceof Activity) {
                    TriggerParam triggerParam2 = this.param;
                    triggerParam2.setChan(triggerParam2.getDelayChanB());
                    API.getInstance().UI_PostInt32(this.serviceId, MessageID.MSG_TRIGGER_DELAY_SRCB, this.param.getDelayChanB().value1);
                    this.param.saveButtonLevel();
                    break;
                }
                break;
            case R.id.imageView2 /* 2131363100 */:
                if (this.param.getEdgeSlopeA() == ServiceEnum.EdgeSlope.Trigger_Edge_Rising && this.param.getEdgeSlopeB() == ServiceEnum.EdgeSlope.Trigger_Edge_Rising) {
                    this.param.saveDelaySlopeB(true);
                    break;
                } else if (this.param.getEdgeSlopeA() == ServiceEnum.EdgeSlope.Trigger_Edge_Rising && this.param.getEdgeSlopeB() == ServiceEnum.EdgeSlope.Trigger_Edge_Falling) {
                    this.param.saveDelaySlopeA(true);
                    this.param.saveDelaySlopeB(false);
                    break;
                } else if (this.param.getEdgeSlopeA() == ServiceEnum.EdgeSlope.Trigger_Edge_Falling && this.param.getEdgeSlopeB() == ServiceEnum.EdgeSlope.Trigger_Edge_Rising) {
                    this.param.saveDelaySlopeB(true);
                    break;
                } else if (this.param.getEdgeSlopeA() == ServiceEnum.EdgeSlope.Trigger_Edge_Falling && this.param.getEdgeSlopeB() == ServiceEnum.EdgeSlope.Trigger_Edge_Falling) {
                    this.param.saveDelaySlopeA(false);
                    this.param.saveDelaySlopeB(false);
                    break;
                }
                break;
            case R.id.lower_limit_value /* 2131363342 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readDelayLowerLimitAttr();
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getdelayLowerAttr().getMaxLongValue(), this.param.getdelayLowerAttr().getMinLongValue(), this.param.getdelayLowerAttr().getDefLongValue(), this.param.getDelayLowerLimit(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerDelayAdapter.8
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerDelayAdapter.this.param.saveDelayLowerLimit(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerDelayAdapter.this.keyboardPopupView = keyboardPopupView;
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
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getHoldOffAttr().getMaxLongValue(), this.param.getHoldOffAttr().getMinLongValue(), this.param.getHoldOffAttr().getDefLongValue(), this.param.getHoldOff(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerDelayAdapter.4
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerDelayAdapter.this.param.saveholdOff(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerDelayAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_levelA_value /* 2131364270 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readdelayLevelAttr();
                    TriggerParam triggerParam3 = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam3.getChanUnit(triggerParam3.getChannel()), this.param.getdelayLevelAttr().getMaxLongValue(), this.param.getdelayLevelAttr().getMinLongValue(), this.param.getdelayLevelAttr().getDefLongValue(), this.param.getDelaylevelA(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerDelayAdapter.5
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerDelayAdapter.this.param.saveDelayLevelA(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerDelayAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_levelB_value /* 2131364273 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_DELAY_SRCB, this.param.getDelayChanB().value1);
                    this.param.readdelayLevelBAttr();
                    TriggerParam triggerParam4 = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam4.getChanUnit(triggerParam4.getChannelB()), this.param.getdelayLevelBAttr().getMaxLongValue(), this.param.getdelayLevelBAttr().getMinLongValue(), this.param.getdelayLevelBAttr().getDefLongValue(), this.param.getDelaylevelB(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerDelayAdapter.6
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerDelayAdapter.this.param.saveDelayLevelB(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerDelayAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source_a /* 2131364337 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_delay_srca)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerDelayAdapter$PPlnA6MwFyllD41WU7UXccIzuUo
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerDelayAdapter.this.lambda$onClick$3$TriggerDelayAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerDelayAdapter$59nF294XFLCImmz0oOGjxrCq63o
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerDelayAdapter.this.lambda$onClick$4$TriggerDelayAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source_b /* 2131364339 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_delay_srcb)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerDelayAdapter$oJguDl6ytuqMv8n2M5rJmO_8sNY
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerDelayAdapter.this.lambda$onClick$5$TriggerDelayAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerDelayAdapter$QvcwnBsfDFrvdSTxFM5_B9wr77c
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerDelayAdapter.this.lambda$onClick$6$TriggerDelayAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.upper_limit_value /* 2131364524 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readDelayUpperLimitAttr();
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getdelayUpperAttr().getMaxLongValue(), this.param.getdelayUpperAttr().getMinLongValue(), this.param.getdelayUpperAttr().getDefLongValue(), this.param.getDelayUperLimit(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerDelayAdapter.7
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerDelayAdapter.this.param.saveDelayUpperLimit(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerDelayAdapter.this.keyboardPopupView = keyboardPopupView;
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

    public /* synthetic */ void lambda$onClick$3$TriggerDelayAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$TriggerDelayAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceA(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$5$TriggerDelayAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$TriggerDelayAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceB(mappingObject);
    }

    private void selectSourceB(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveDelaySourceB(mappingObject.getValue());
            this.param.setChannelB(mappingObject.getValue());
        }
    }

    private void selectSourceA(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveDelaySourceA(mappingObject.getValue());
            this.param.setChannel(mappingObject.getValue());
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        switch (i) {
            case R.id.lower_limit_value /* 2131363342 */:
                this.param.readDelayLowerLimitAttr();
                TriggerParam triggerParam = this.param;
                triggerParam.saveDelayLowerLimit(triggerParam.getLongStep(triggerParam.getDelayLowerLimit(), this.param.getdelayLowerAttr(), z, keyEvent));
                return;
            case R.id.trigger_holdoff /* 2131364231 */:
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveholdOff(triggerParam2.getLongStep(triggerParam2.getHoldOff(), this.param.getHoldOffAttr(), z, keyEvent));
                return;
            case R.id.trigger_levelA_value /* 2131364270 */:
                TriggerParam triggerParam3 = this.param;
                triggerParam3.setChan(triggerParam3.getDelayChanA());
                TriggerParam triggerParam4 = this.param;
                triggerParam4.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam4);
                return;
            case R.id.trigger_levelB_value /* 2131364273 */:
                TriggerParam triggerParam5 = this.param;
                triggerParam5.setChan(triggerParam5.getDelayChanB());
                TriggerParam triggerParam6 = this.param;
                triggerParam6.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam6);
                return;
            case R.id.upper_limit_value /* 2131364524 */:
                this.param.readDelayUpperLimitAttr();
                TriggerParam triggerParam7 = this.param;
                triggerParam7.saveDelayUpperLimit(triggerParam7.getLongStep(triggerParam7.getDelayUperLimit(), this.param.getdelayUpperAttr(), z, keyEvent));
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
                this.param.readDelayLowerLimitAttr();
                TriggerParam triggerParam = this.param;
                triggerParam.saveDelayLowerLimit(triggerParam.getLongDef(triggerParam.getdelayLowerAttr()));
                return;
            case R.id.trigger_holdoff /* 2131364231 */:
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveholdOff(triggerParam2.getLongDef(triggerParam2.getHoldOffAttr()));
                return;
            case R.id.trigger_levelA_value /* 2131364270 */:
                TriggerParam triggerParam3 = this.param;
                triggerParam3.saveDelayLevelA(triggerParam3.getLongDef(triggerParam3.getdelayLevelAttr()));
                return;
            case R.id.trigger_levelB_value /* 2131364273 */:
                TriggerParam triggerParam4 = this.param;
                triggerParam4.saveDelayLevelB(triggerParam4.getLongDef(triggerParam4.getdelayLevelBAttr()));
                return;
            case R.id.upper_limit_value /* 2131364524 */:
                this.param.readDelayUpperLimitAttr();
                TriggerParam triggerParam5 = this.param;
                triggerParam5.saveDelayUpperLimit(triggerParam5.getLongDef(triggerParam5.getdelayUpperAttr()));
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public class TriggerDelayHolder extends RecyclerView.ViewHolder {
        private AdapterTriggerDelayBinding binding;

        public TriggerDelayHolder(AdapterTriggerDelayBinding adapterTriggerDelayBinding) {
            super(adapterTriggerDelayBinding.getRoot());
            this.binding = adapterTriggerDelayBinding;
        }
    }
}
