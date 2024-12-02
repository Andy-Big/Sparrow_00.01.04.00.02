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
import com.rigol.scope.databinding.AdapterTriggerEdgeBinding;
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
public class TriggerEdgeAdapter extends RecyclerView.Adapter<TriggerEdgeHolder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private AorBManager aorBManager;
    private AdapterTriggerEdgeBinding binding;
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

    public TriggerEdgeAdapter(Context context, BasePopupView basePopupView, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        this.triggerViewModel = triggerViewModel;
        this.param = triggerParam;
        this.popupView = basePopupView;
        this.context = context;
        this.serviceId = triggerParam.getServiceId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TriggerEdgeHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        AdapterTriggerEdgeBinding inflate = AdapterTriggerEdgeBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        this.binding = inflate;
        inflate.setEdgeRisingMapping(ViewUtil.getMappingObject(R.array.msg_trigger_edge_b, ServiceEnum.EdgeSlope.Trigger_Edge_Rising.value1));
        this.binding.setEdgeFallingMapping(ViewUtil.getMappingObject(R.array.msg_trigger_edge_b, ServiceEnum.EdgeSlope.Trigger_Edge_Falling.value1));
        this.binding.setEdgeEitherMapping(ViewUtil.getMappingObject(R.array.msg_trigger_edge_b, ServiceEnum.EdgeSlope.Trigger_Edge_Any.value1));
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerHoldoff, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSource, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerCoupling, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.TriggerEdgeAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                showKey(TriggerEdgeAdapter.this.context, ((AorBParam) TriggerEdgeAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) TriggerEdgeAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                showKey(TriggerEdgeAdapter.this.context, ((AorBParam) TriggerEdgeAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) TriggerEdgeAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.triggerLevelValue, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.triggerHoldoff, true, ViewUtil.KEY_B);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerEdgeAdapter$MgPQS7-gChCWkEOWyDmKLkfQBNo
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TriggerEdgeAdapter.this.lambda$onCreateViewHolder$2$TriggerEdgeAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new TriggerEdgeHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$TriggerEdgeAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (this.popviewTriggerBinding.triggerView.getAdapter() instanceof TriggerEdgeAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerEdgeAdapter$6wU4-y5IGEvblzdwgxGZRQKR2mo
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerEdgeAdapter.this.lambda$onCreateViewHolder$0$TriggerEdgeAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerEdgeAdapter$sS50Br1H8hovjv5pIEgAC9LfSTo
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    TriggerEdgeAdapter.this.lambda$onCreateViewHolder$1$TriggerEdgeAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$TriggerEdgeAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$TriggerEdgeAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.trigger_source) {
            selectSource(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_coupling) {
            selectCoupling(mappingObject);
        }
    }

    private void selectSource(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveEdgeSource(mappingObject.getValue());
            ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(mappingObject.getValue());
            this.param.setChan(chanFromValue1);
            this.param.setChannel(mappingObject.getValue());
            if (chanFromValue1 == ServiceEnum.Chan.acline) {
                this.param.saveNoise(false);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TriggerEdgeHolder triggerEdgeHolder, int i) {
        ShowTriggerEdge();
        triggerEdgeHolder.binding.executePendingBindings();
    }

    public void ShowTriggerEdge() {
        int readEdgeSource = this.param.readEdgeSource();
        ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(readEdgeSource);
        this.param.setChannel(readEdgeSource);
        this.param.setChan(chanFromValue1);
        this.param.setChanColor(this.binding.triggerSource, chanFromValue1);
        this.param.readEdgeSlope();
        this.binding.setParam(this.param);
        ViewUtil.setSwitchButton(this.binding.triggerNoiseSwitch);
        this.binding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.edgeRising.setOnCheckedChangeListener(this);
        this.binding.edgeFalling.setOnCheckedChangeListener(this);
        this.binding.edgeEither.setOnCheckedChangeListener(this);
        this.binding.autoRadioButton.setOnCheckedChangeListener(this);
        this.binding.normalRadioButton.setOnCheckedChangeListener(this);
        this.binding.singleRadioButton.setOnCheckedChangeListener(this);
        this.binding.buttonLevel.setOnClickListener(this);
        this.binding.edgeSlopeImageButton.setOnClickListener(this);
        this.binding.triggerSource.setOnClickListener(this);
        this.binding.triggerCoupling.setOnClickListener(this);
        this.binding.autoRadioButton.setOnClickListener(this);
        this.binding.normalRadioButton.setOnClickListener(this);
        this.binding.singleRadioButton.setOnClickListener(this);
        this.binding.triggerHoldoff.setOnClickListener(this);
        this.binding.triggerLevelValue.setOnClickListener(this);
        this.binding.triggerLevelView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.adapters.TriggerEdgeAdapter.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    TriggerEdgeAdapter.this.param.saveLevelSync((long) ((((seekBar.getProgress() / 100.0d) * (TriggerEdgeAdapter.this.param.getChanScale() * TriggerEdgeAdapter.this.param.getScaleNum())) - TriggerEdgeAdapter.this.param.getChanOffset()) - ((TriggerEdgeAdapter.this.param.getChanScale() * TriggerEdgeAdapter.this.param.getScaleNum()) / 2)));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TriggerEdgeAdapter.this.param.saveLevelSync((long) ((((seekBar.getProgress() / 100.0d) * (TriggerEdgeAdapter.this.param.getChanScale() * TriggerEdgeAdapter.this.param.getScaleNum())) - TriggerEdgeAdapter.this.param.getChanOffset()) - ((TriggerEdgeAdapter.this.param.getChanScale() * TriggerEdgeAdapter.this.param.getScaleNum()) / 2)));
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
                case R.id.edge_either /* 2131362735 */:
                    if (this.param == null || !z) {
                        return;
                    }
                    this.param.saveEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Any.value1);
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP2_LED_WHITE.value1, 1);
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP1_LED_WHITE.value1, 1);
                    return;
                case R.id.edge_falling /* 2131362737 */:
                    if (this.param == null || !z) {
                        return;
                    }
                    this.param.saveEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Falling.value1);
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP1_LED_WHITE.value1, 0);
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP2_LED_WHITE.value1, 1);
                    return;
                case R.id.edge_rising /* 2131362739 */:
                    if (this.param == null || !z) {
                        return;
                    }
                    int i = ServiceEnum.EdgeSlope.Trigger_Edge_Rising.value1;
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP1_LED_WHITE.value1, 1);
                    API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.SLOP2_LED_WHITE.value1, 0);
                    this.param.saveEdgeSlope(i);
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
                    TriggerParam triggerParam = this.param;
                    if (triggerParam != null) {
                        triggerParam.saveNoise(z);
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
                    this.param.saveButtonLevel();
                    break;
                }
                break;
            case R.id.edge_slope_imageButton /* 2131362742 */:
                if (this.param.getEdgeSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Rising) {
                    this.param.setEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Falling);
                    this.param.saveEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Falling.value1);
                    break;
                } else if (this.param.getEdgeSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Falling) {
                    this.param.setEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Any);
                    this.param.saveEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Any.value1);
                    break;
                } else if (this.param.getEdgeSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Any) {
                    this.param.setEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Rising);
                    this.param.saveEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Rising.value1);
                    break;
                }
                break;
            case R.id.normal_radio_button /* 2131363483 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1);
                break;
            case R.id.single_radio_button /* 2131363859 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1);
                break;
            case R.id.trigger_coupling /* 2131364190 */:
                if (this.popupView != null) {
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_trigger_coupling), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerEdgeAdapter$WZMI0nOmSsAZIzzq8MPjamRrUhI
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerEdgeAdapter.this.lambda$onClick$5$TriggerEdgeAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerEdgeAdapter$JwsnMlnJ2xVgihrSl0VfvASNSYo
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerEdgeAdapter.this.lambda$onClick$6$TriggerEdgeAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_holdoff /* 2131364231 */:
                if (this.aorBManager.setClick_showab(id)) {
                    this.param.readHoldOffAttr();
                    if (this.context instanceof Activity) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getHoldOffAttr().getMaxLongValue(), this.param.getHoldOffAttr().getMinLongValue(), this.param.getHoldOffAttr().getDefLongValue(), this.param.getHoldOff(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerEdgeAdapter.3
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                TriggerEdgeAdapter.this.param.saveholdOff(((Long) t).longValue());
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                                TriggerEdgeAdapter.this.keyboardPopupView = keyboardPopupView;
                            }
                        });
                        break;
                    }
                }
                break;
            case R.id.trigger_level_value /* 2131364280 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readLevelAttr();
                    TriggerParam triggerParam = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam.getChanUnit(triggerParam.getChannel()), this.param.getLevelAttr().getMaxLongValue(), this.param.getLevelAttr().getMinLongValue(), this.param.getLevelAttr().getDefLongValue(), this.param.getLevel(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerEdgeAdapter.4
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerEdgeAdapter.this.param.saveLevelSync(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerEdgeAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source /* 2131364336 */:
                int UI_QueryInt32 = API.getInstance().UI_QueryInt32(11, MessageID.MSG_PRODUCT_SERIES);
                int UI_QueryInt322 = API.getInstance().UI_QueryInt32(11, MessageID.MSG_APP_UTILITY_CHANNEL_COUNT);
                if (this.popupView != null) {
                    List<MappingObject> filterChan = ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_source_la_ext_ac));
                    if (!ViewUtil.isDoubleChan() || UI_QueryInt32 != ServiceEnum.ProductSeries.SERIES_800.value1 || UI_QueryInt322 != 2) {
                        for (int i = 0; i < filterChan.size(); i++) {
                            if (filterChan.get(i).getValue() == ServiceEnum.Chan.ext.value1) {
                                filterChan.remove(i);
                            }
                        }
                    }
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, filterChan, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerEdgeAdapter$62EgGnywrtYTTOc5Wj4G-zcOZDM
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerEdgeAdapter.this.lambda$onClick$3$TriggerEdgeAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerEdgeAdapter$zvRo-7X1oy9WUDOj6TByixRkYT0
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i2, Object obj) {
                            TriggerEdgeAdapter.this.lambda$onClick$4$TriggerEdgeAdapter(view2, viewHolder, i2, (MappingObject) obj);
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

    public /* synthetic */ void lambda$onClick$3$TriggerEdgeAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$TriggerEdgeAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSource(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$5$TriggerEdgeAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$TriggerEdgeAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectCoupling(mappingObject);
    }

    private void selectCoupling(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveEdgeCoupling(mappingObject.getValue());
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        if (i == R.id.trigger_holdoff) {
            this.param.readHoldOffAttr();
            TriggerParam triggerParam = this.param;
            triggerParam.saveholdOff(triggerParam.getLongStep(triggerParam.getHoldOff(), this.param.getHoldOffAttr(), z, keyEvent));
        } else if (i != R.id.trigger_level_value) {
        } else {
            TriggerParam triggerParam2 = this.param;
            triggerParam2.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam2);
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        if (this.param == null || !isMove()) {
            return;
        }
        if (i == R.id.trigger_holdoff) {
            this.param.readHoldOffAttr();
            TriggerParam triggerParam = this.param;
            triggerParam.saveholdOff(triggerParam.getLongDef(triggerParam.getHoldOffAttr()));
        } else if (i != R.id.trigger_level_value) {
        } else {
            TriggerParam triggerParam2 = this.param;
            triggerParam2.saveLevelSync(triggerParam2.getLongDef(triggerParam2.getLevelAttr()));
        }
    }

    /* loaded from: classes.dex */
    public class TriggerEdgeHolder extends RecyclerView.ViewHolder {
        private AdapterTriggerEdgeBinding binding;

        public TriggerEdgeHolder(AdapterTriggerEdgeBinding adapterTriggerEdgeBinding) {
            super(adapterTriggerEdgeBinding.getRoot());
            this.binding = adapterTriggerEdgeBinding;
        }
    }
}
