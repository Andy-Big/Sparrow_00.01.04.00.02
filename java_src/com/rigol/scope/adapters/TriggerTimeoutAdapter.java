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
import com.rigol.scope.databinding.AdapterTriggerTimeoutBinding;
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
public class TriggerTimeoutAdapter extends RecyclerView.Adapter<TriggerTimeoutHolder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterTriggerTimeoutBinding binding;
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

    public TriggerTimeoutAdapter(Context context, BasePopupView basePopupView, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        this.triggerViewModel = triggerViewModel;
        this.param = triggerParam;
        this.popupView = basePopupView;
        this.context = context;
        this.serviceId = triggerParam.getServiceId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TriggerTimeoutHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterTriggerTimeoutBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerTimeoutTimeValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSource, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.TriggerTimeoutAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                TriggerTimeoutAdapter.this.aorBManager.showKey(TriggerTimeoutAdapter.this.context, ((AorBParam) TriggerTimeoutAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) TriggerTimeoutAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                TriggerTimeoutAdapter.this.aorBManager.showKey(TriggerTimeoutAdapter.this.context, ((AorBParam) TriggerTimeoutAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) TriggerTimeoutAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.triggerLevelValue, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.triggerTimeoutTimeValue, true, ViewUtil.KEY_B);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerTimeoutAdapter$wjaWZ9m9HhUcv8ExKoo4t5BwpI8
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TriggerTimeoutAdapter.this.lambda$onCreateViewHolder$2$TriggerTimeoutAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new TriggerTimeoutHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$TriggerTimeoutAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (this.popviewTriggerBinding.triggerView.getAdapter() instanceof TriggerTimeoutAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerTimeoutAdapter$0knY--j_8rDAJn_0OSezAkEMxFU
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerTimeoutAdapter.this.lambda$onCreateViewHolder$0$TriggerTimeoutAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerTimeoutAdapter$JDYPJ4SC-wKlYOCGtP59JD-LdXg
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    TriggerTimeoutAdapter.this.lambda$onCreateViewHolder$1$TriggerTimeoutAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$TriggerTimeoutAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$TriggerTimeoutAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.trigger_source) {
            selectSource(mappingObject);
        }
    }

    private void selectSource(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveTimeoutSource(mappingObject.getValue());
            this.param.setChannel(mappingObject.getValue());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TriggerTimeoutHolder triggerTimeoutHolder, int i) {
        ShowTriggerTimeout();
        triggerTimeoutHolder.binding.executePendingBindings();
    }

    public void ShowTriggerTimeout() {
        ServiceEnum.Chan chan = this.param.getChan();
        if (chan == ServiceEnum.Chan.acline || chan == ServiceEnum.Chan.ext) {
            this.param.setChannel(ServiceEnum.Chan.chan1.value1);
            this.param.saveTimeoutSource(ServiceEnum.Chan.chan1.value1);
        } else {
            this.param.setChan(ServiceEnum.getChanFromValue1(chan.value1));
        }
        this.param.setChanColor(this.binding.triggerSource, chan);
        this.param.readTimeoutSlope();
        this.binding.setParam(this.param);
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        this.binding.setSlopeRisingMapping(ViewUtil.getMappingObject(R.array.msg_trigger_edge_a, ServiceEnum.EdgeSlope.Trigger_Edge_Rising.value1));
        this.binding.setSlopeFallingMapping(ViewUtil.getMappingObject(R.array.msg_trigger_edge_a, ServiceEnum.EdgeSlope.Trigger_Edge_Falling.value1));
        this.binding.setSlopeEitherMapping(ViewUtil.getMappingObject(R.array.msg_trigger_edge_a, ServiceEnum.EdgeSlope.Trigger_Edge_Any.value1));
        ViewUtil.setSwitchButton(this.binding.triggerNoiseSwitch);
        this.binding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.triggerTimeoutEdgeRising.setOnCheckedChangeListener(this);
        this.binding.triggerTimeoutEdgeFalling.setOnCheckedChangeListener(this);
        this.binding.triggerTimeoutEdgeEither.setOnCheckedChangeListener(this);
        this.binding.buttonLevel.setOnClickListener(this);
        this.binding.imageView2.setOnClickListener(this);
        this.binding.triggerSource.setOnClickListener(this);
        this.binding.triggerTimeoutTimeValue.setOnClickListener(this);
        this.binding.triggerLevelValue.setOnClickListener(this);
        this.binding.triggerLevelView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.adapters.TriggerTimeoutAdapter.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    TriggerTimeoutAdapter.this.param.saveLevelSync((long) ((((seekBar.getProgress() / 100.0d) * (TriggerTimeoutAdapter.this.param.getChanScale() * TriggerTimeoutAdapter.this.param.getScaleNum())) - TriggerTimeoutAdapter.this.param.getChanOffset()) - ((TriggerTimeoutAdapter.this.param.getChanScale() * TriggerTimeoutAdapter.this.param.getScaleNum()) / 2)));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TriggerTimeoutAdapter.this.param.saveLevelSync((long) ((((seekBar.getProgress() / 100.0d) * (TriggerTimeoutAdapter.this.param.getChanScale() * TriggerTimeoutAdapter.this.param.getScaleNum())) - TriggerTimeoutAdapter.this.param.getChanOffset()) - ((TriggerTimeoutAdapter.this.param.getChanScale() * TriggerTimeoutAdapter.this.param.getScaleNum()) / 2)));
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
                case R.id.trigger_timeout_edge_either /* 2131364386 */:
                    TriggerParam triggerParam = this.param;
                    if (triggerParam == null || !z) {
                        return;
                    }
                    triggerParam.saveTimeoutSlope(3);
                    return;
                case R.id.trigger_timeout_edge_falling /* 2131364387 */:
                    TriggerParam triggerParam2 = this.param;
                    if (triggerParam2 == null || !z) {
                        return;
                    }
                    triggerParam2.saveTimeoutSlope(1);
                    return;
                case R.id.trigger_timeout_edge_rising /* 2131364389 */:
                    TriggerParam triggerParam3 = this.param;
                    if (triggerParam3 == null || !z) {
                        return;
                    }
                    triggerParam3.saveTimeoutSlope(0);
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
                    this.param.saveButtonLevel();
                    break;
                }
                break;
            case R.id.imageView2 /* 2131363100 */:
                if (this.param.getTimeoutSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Rising) {
                    this.param.saveTimeoutSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Falling.value1);
                    break;
                } else if (this.param.getTimeoutSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Falling) {
                    this.param.saveTimeoutSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Any.value1);
                    break;
                } else if (this.param.getTimeoutSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Any) {
                    this.param.saveTimeoutSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Rising.value1);
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
                    this.param.readLevelAttr();
                    TriggerParam triggerParam = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam.getChanUnit(triggerParam.getChannel()), this.param.getLevelAttr().getMaxLongValue(), this.param.getLevelAttr().getMinLongValue(), this.param.getLevelAttr().getDefLongValue(), this.param.getLevel(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerTimeoutAdapter.3
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerTimeoutAdapter.this.param.saveLevelSync(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerTimeoutAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source /* 2131364336 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_source_la)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerTimeoutAdapter$yICApNR7gz7ACLglumKV2EZ3o0g
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerTimeoutAdapter.this.lambda$onClick$3$TriggerTimeoutAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerTimeoutAdapter$LB50EdceIp2bqsq5lXTMGAO5AJI
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerTimeoutAdapter.this.lambda$onClick$4$TriggerTimeoutAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_timeout_time_value /* 2131364391 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getTimeoutTimeAttr().getMaxLongValue(), this.param.getTimeoutTimeAttr().getMinLongValue(), this.param.getTimeoutTimeAttr().getDefLongValue(), this.param.getTimeOut(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerTimeoutAdapter.4
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerTimeoutAdapter.this.param.saveTimeoutValue(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerTimeoutAdapter.this.keyboardPopupView = keyboardPopupView;
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

    public /* synthetic */ void lambda$onClick$3$TriggerTimeoutAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$TriggerTimeoutAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSource(mappingObject);
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        if (i == R.id.trigger_level_value) {
            TriggerParam triggerParam = this.param;
            triggerParam.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam);
        } else if (i != R.id.trigger_timeout_time_value) {
        } else {
            this.param.readTimeoutTimeAttr();
            TriggerParam triggerParam2 = this.param;
            triggerParam2.saveTimeoutValue(triggerParam2.getLongStep(triggerParam2.getTimeOut(), this.param.getTimeoutTimeAttr(), z, keyEvent));
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        if (this.param == null || !isMove()) {
            return;
        }
        if (i == R.id.trigger_level_value) {
            TriggerParam triggerParam = this.param;
            triggerParam.saveLevelSync(triggerParam.getLongDef(triggerParam.getLevelAttr()));
        } else if (i != R.id.trigger_timeout_time_value) {
        } else {
            this.param.readTimeoutTimeAttr();
            TriggerParam triggerParam2 = this.param;
            triggerParam2.saveTimeoutValue(triggerParam2.getLongDef(triggerParam2.getTimeoutTimeAttr()));
        }
    }

    /* loaded from: classes.dex */
    public class TriggerTimeoutHolder extends RecyclerView.ViewHolder {
        private AdapterTriggerTimeoutBinding binding;

        public TriggerTimeoutHolder(AdapterTriggerTimeoutBinding adapterTriggerTimeoutBinding) {
            super(adapterTriggerTimeoutBinding.getRoot());
            this.binding = adapterTriggerTimeoutBinding;
        }
    }
}
