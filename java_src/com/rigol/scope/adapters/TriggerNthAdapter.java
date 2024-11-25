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
import com.rigol.scope.databinding.AdapterTriggerNthBinding;
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
public class TriggerNthAdapter extends RecyclerView.Adapter<TriggerNthHolder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterTriggerNthBinding binding;
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

    public TriggerNthAdapter(Context context, BasePopupView basePopupView, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        this.triggerViewModel = triggerViewModel;
        this.param = triggerParam;
        this.popupView = basePopupView;
        this.context = context;
        this.serviceId = triggerParam.getServiceId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TriggerNthHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterTriggerNthBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerNthIdleTimeValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerNthEdgeNumberValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSource, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.TriggerNthAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                TriggerNthAdapter.this.aorBManager.showKey(TriggerNthAdapter.this.context, ((AorBParam) TriggerNthAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) TriggerNthAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                TriggerNthAdapter.this.aorBManager.showKey(TriggerNthAdapter.this.context, ((AorBParam) TriggerNthAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) TriggerNthAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.triggerLevelValue, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.triggerNthIdleTimeValue, true, ViewUtil.KEY_B);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerNthAdapter$VylnmEmksG3zVvjGq6DGbN7ZR58
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TriggerNthAdapter.this.lambda$onCreateViewHolder$2$TriggerNthAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new TriggerNthHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$TriggerNthAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (this.popviewTriggerBinding.triggerView.getAdapter() instanceof TriggerNthAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerNthAdapter$TehLX9CIL4wMhK02DCQANGtjDHQ
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerNthAdapter.this.lambda$onCreateViewHolder$0$TriggerNthAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerNthAdapter$GCVn4XMphcLQA3koGh3tSKoTWCQ
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    TriggerNthAdapter.this.lambda$onCreateViewHolder$1$TriggerNthAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$TriggerNthAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$TriggerNthAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.trigger_source) {
            selectSource(mappingObject);
        }
    }

    private void selectSource(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveNthSource(mappingObject.getValue());
            this.param.setChannel(mappingObject.getValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TriggerNthHolder triggerNthHolder, int i) {
        ShowTriggerNth();
        triggerNthHolder.binding.executePendingBindings();
    }

    public void ShowTriggerNth() {
        ServiceEnum.Chan chan = this.param.getChan();
        if (chan == ServiceEnum.Chan.acline || chan == ServiceEnum.Chan.ext) {
            this.param.setChannel(ServiceEnum.Chan.chan1.value1);
            this.param.saveNthSource(ServiceEnum.Chan.chan1.value1);
        } else {
            this.param.setChan(ServiceEnum.getChanFromValue1(chan.value1));
        }
        this.param.setChanColor(this.binding.triggerSource, chan);
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        this.binding.setSlopeRisingMapping(ViewUtil.getMappingObject(R.array.msg_trigger_slope_polarity, ServiceEnum.EdgeSlope.Trigger_Edge_Rising.value1));
        this.binding.setSlopeFallingMapping(ViewUtil.getMappingObject(R.array.msg_trigger_slope_polarity, ServiceEnum.EdgeSlope.Trigger_Edge_Falling.value1));
        this.param.readNthSlope();
        this.param.readNthidelTime();
        this.param.readNthedgeNumber();
        this.binding.setParam(this.param);
        ViewUtil.setSwitchButton(this.binding.triggerNoiseSwitch);
        this.binding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.triggerNthEdgeRising.setOnCheckedChangeListener(this);
        this.binding.triggerNthEdgeFalling.setOnCheckedChangeListener(this);
        this.binding.buttonLevel.setOnClickListener(this);
        this.binding.imageView2.setOnClickListener(this);
        this.binding.triggerSource.setOnClickListener(this);
        this.binding.triggerLevelValue.setOnClickListener(this);
        this.binding.triggerNthIdleTimeValue.setOnClickListener(this);
        this.binding.triggerNthEdgeNumberValue.setOnClickListener(this);
        this.binding.triggerLevelView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.adapters.TriggerNthAdapter.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    TriggerNthAdapter.this.param.saveLevelSync((long) ((((seekBar.getProgress() / 100.0d) * (TriggerNthAdapter.this.param.getChanScale() * TriggerNthAdapter.this.param.getScaleNum())) - TriggerNthAdapter.this.param.getChanOffset()) - ((TriggerNthAdapter.this.param.getChanScale() * TriggerNthAdapter.this.param.getScaleNum()) / 2)));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TriggerNthAdapter.this.param.saveLevelSync((long) ((((seekBar.getProgress() / 100.0d) * (TriggerNthAdapter.this.param.getChanScale() * TriggerNthAdapter.this.param.getScaleNum())) - TriggerNthAdapter.this.param.getChanOffset()) - ((TriggerNthAdapter.this.param.getChanScale() * TriggerNthAdapter.this.param.getScaleNum()) / 2)));
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
                case R.id.trigger_nth_edge_falling /* 2131364310 */:
                    TriggerParam triggerParam = this.param;
                    if (triggerParam == null || !z) {
                        return;
                    }
                    triggerParam.saveNthSlope(true);
                    return;
                case R.id.trigger_nth_edge_rising /* 2131364314 */:
                    TriggerParam triggerParam2 = this.param;
                    if (triggerParam2 == null || !z) {
                        return;
                    }
                    triggerParam2.saveNthSlope(false);
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
                if (this.param.getNthSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Rising) {
                    this.param.saveNthSlope(true);
                    break;
                } else if (this.param.getNthSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Falling) {
                    this.param.saveNthSlope(false);
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
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam.getChanUnit(triggerParam.getChannel()), this.param.getLevelAttr().getMaxLongValue(), this.param.getLevelAttr().getMinLongValue(), this.param.getLevelAttr().getDefLongValue(), this.param.getLevel(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerNthAdapter.3
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerNthAdapter.this.param.saveLevelSync(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerNthAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_nth_edge_number_value /* 2131364313 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_number, this.param.getNthedgeNumberAttr().getMaxIntValue(), this.param.getNthedgeNumberAttr().getMinIntValue(), this.param.getNthedgeNumberAttr().getDefIntValue(), this.param.getEdgeNumber(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerNthAdapter.5
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerNthAdapter.this.param.saveNthEdgeNumber(((Long) t).intValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerNthAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_nth_idle_time_value /* 2131364316 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getNthidelTimeAttr().getMaxLongValue(), this.param.getNthidelTimeAttr().getMinLongValue(), this.param.getNthidelTimeAttr().getDefLongValue(), this.param.getIdelTime(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerNthAdapter.4
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerNthAdapter.this.param.saveNthIdleTime(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerNthAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source /* 2131364336 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_source_la)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerNthAdapter$xYbA3w0rvkBIvellwskO9SksoGk
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerNthAdapter.this.lambda$onClick$3$TriggerNthAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerNthAdapter$YpVyg4_54eGP_oR5f9yN0Bx50ww
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerNthAdapter.this.lambda$onClick$4$TriggerNthAdapter(view2, viewHolder, i, (MappingObject) obj);
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

    public /* synthetic */ void lambda$onClick$3$TriggerNthAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$TriggerNthAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
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
        } else if (i == R.id.trigger_nth_edge_number_value) {
            TriggerParam triggerParam2 = this.param;
            triggerParam2.saveNthEdgeNumber(triggerParam2.getIntStep(triggerParam2.getEdgeNumber(), this.param.getNthedgeNumberAttr(), z, keyEvent));
        } else if (i != R.id.trigger_nth_idle_time_value) {
        } else {
            this.param.readNthidelTimeAttr();
            TriggerParam triggerParam3 = this.param;
            triggerParam3.saveNthIdleTime(triggerParam3.getLongStep(triggerParam3.getIdelTime(), this.param.getNthidelTimeAttr(), z, keyEvent));
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
        } else if (i == R.id.trigger_nth_edge_number_value) {
            TriggerParam triggerParam2 = this.param;
            triggerParam2.saveNthEdgeNumber(triggerParam2.getIntDef(triggerParam2.getNthedgeNumberAttr()));
        } else if (i != R.id.trigger_nth_idle_time_value) {
        } else {
            TriggerParam triggerParam3 = this.param;
            triggerParam3.saveNthIdleTime(triggerParam3.getLongDef(triggerParam3.getNthidelTimeAttr()));
        }
    }

    /* loaded from: classes.dex */
    public class TriggerNthHolder extends RecyclerView.ViewHolder {
        private AdapterTriggerNthBinding binding;

        public TriggerNthHolder(AdapterTriggerNthBinding adapterTriggerNthBinding) {
            super(adapterTriggerNthBinding.getRoot());
            this.binding = adapterTriggerNthBinding;
        }
    }
}
