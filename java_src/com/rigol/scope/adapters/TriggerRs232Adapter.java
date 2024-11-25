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
import com.rigol.scope.databinding.AdapterTriggerRs232Binding;
import com.rigol.scope.databinding.PopupviewTriggerBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.UnitFormat;
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
public class TriggerRs232Adapter extends RecyclerView.Adapter<TriggerRs232Holder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, View.OnLongClickListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterTriggerRs232Binding binding;
    private View clickedView;
    private Context context;
    private boolean isMove;
    private KeyboardPopupView keyboardPopupView;
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
    private int dataMax = 8;
    private List<AorBParam> list_aorbParam = new ArrayList();

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

    public TriggerRs232Adapter(Context context, BasePopupView basePopupView, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        this.triggerViewModel = triggerViewModel;
        this.param = triggerParam;
        this.popupView = basePopupView;
        this.context = context;
        this.serviceId = triggerParam.getServiceId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TriggerRs232Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterTriggerRs232Binding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.dataValue, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSource, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerBaudrate, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerDataWidth, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.TriggerRs232Adapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                TriggerRs232Adapter.this.aorBManager.showKey(TriggerRs232Adapter.this.context, ((AorBParam) TriggerRs232Adapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) TriggerRs232Adapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                TriggerRs232Adapter.this.aorBManager.showKey(TriggerRs232Adapter.this.context, ((AorBParam) TriggerRs232Adapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) TriggerRs232Adapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.triggerLevelValue, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.dataValue, true, ViewUtil.KEY_B);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerRs232Adapter$a3zFfqJGCIbTzRmkbcrjYVOmaK8
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TriggerRs232Adapter.this.lambda$onCreateViewHolder$2$TriggerRs232Adapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new TriggerRs232Holder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$TriggerRs232Adapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (this.popviewTriggerBinding.triggerView.getAdapter() instanceof TriggerRs232Adapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerRs232Adapter$gRWXWjK3Q3ORr7CvXomIjEYb1OM
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerRs232Adapter.this.lambda$onCreateViewHolder$0$TriggerRs232Adapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerRs232Adapter$RzxU2q7CwdQTGb91f8byfaXvl3s
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    TriggerRs232Adapter.this.lambda$onCreateViewHolder$1$TriggerRs232Adapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$TriggerRs232Adapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$TriggerRs232Adapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.trigger_source) {
            selectSource(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_data_width) {
            selectDataWidth(mappingObject);
        }
    }

    private void selectSource(MappingObject mappingObject) {
        if (this.param != null) {
            API.getInstance().UI_PostInt32(this.serviceId, MessageID.MSG_TRIGGER_RS232_SOURCE_LA, mappingObject.getValue());
            this.param.setChan(ServiceEnum.getChanFromValue1(mappingObject.getValue()));
            this.param.setChannel(mappingObject.getValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TriggerRs232Holder triggerRs232Holder, int i) {
        ShowTriggerRs232();
        triggerRs232Holder.binding.executePendingBindings();
    }

    public void ShowTriggerRs232() {
        ServiceEnum.Chan chan = this.param.getChan();
        if (chan == ServiceEnum.Chan.acline || chan == ServiceEnum.Chan.ext) {
            int i = ServiceEnum.Chan.chan1.value1;
            this.param.setChannel(i);
            this.param.saveRs232Source(i);
        } else {
            this.param.setChan(ServiceEnum.getChanFromValue1(chan.value1));
        }
        this.param.setChanColor(this.binding.triggerSource, chan);
        this.param.readRS232When();
        this.param.readRS232Polarity();
        this.binding.setStopBit1Mapping(ViewUtil.getMappingObject(R.array.msg_trigger_rs232_stopbit, 0));
        this.binding.setStopBit15Mapping(ViewUtil.getMappingObject(R.array.msg_trigger_rs232_stopbit, 2));
        this.binding.setStopBit2Mapping(ViewUtil.getMappingObject(R.array.msg_trigger_rs232_stopbit, 1));
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        this.binding.setPolarityPositiveMapping(ViewUtil.getMappingObject(R.array.msg_trigger_rs232_polarity, ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive.value1));
        this.binding.setPolarityNegativeMapping(ViewUtil.getMappingObject(R.array.msg_trigger_rs232_polarity, ServiceEnum.TriggerPulsePolarity.Trigger_pulse_negative.value1));
        this.binding.setWhenStartMapping(ViewUtil.getMappingObject(R.array.msg_trigger_rs232_when, ServiceEnum.Trigger_RS232_When.rs232_when_start.value1));
        this.binding.setWhenErrorMapping(ViewUtil.getMappingObject(R.array.msg_trigger_rs232_when, ServiceEnum.Trigger_RS232_When.rs232_when_error.value1));
        this.binding.setWhenCheckMapping(ViewUtil.getMappingObject(R.array.msg_trigger_rs232_when, ServiceEnum.Trigger_RS232_When.rs232_when_check_error.value1));
        this.binding.setWhenDataMapping(ViewUtil.getMappingObject(R.array.msg_trigger_rs232_when, ServiceEnum.Trigger_RS232_When.rs232_when_data.value1));
        this.binding.setParityNoneMapping(ViewUtil.getMappingObject(R.array.msg_trigger_rs232_check, ServiceEnum.Trigger_RS232_Parity.RS232_Parity_None.value1));
        this.binding.setParityEvenMapping(ViewUtil.getMappingObject(R.array.msg_trigger_rs232_check, ServiceEnum.Trigger_RS232_Parity.RS232_Parity_Even.value1));
        this.binding.setParityOddMapping(ViewUtil.getMappingObject(R.array.msg_trigger_rs232_check, ServiceEnum.Trigger_RS232_Parity.RS232_Parity_Odd.value1));
        this.param.readRS232Baudrate();
        this.param.readRS232DataWidth();
        this.param.readRS232StopBit();
        this.param.readRS232Parity();
        this.binding.setParam(this.param);
        ViewUtil.setSwitchButton(this.binding.triggerNoiseSwitch);
        this.binding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.triggerRs232Positive.setOnCheckedChangeListener(this);
        this.binding.triggerRs232Negative.setOnCheckedChangeListener(this);
        this.binding.triggerRs232Start.setOnCheckedChangeListener(this);
        this.binding.triggerRs232Error.setOnCheckedChangeListener(this);
        this.binding.triggerRs232Check.setOnCheckedChangeListener(this);
        this.binding.triggerRs232Data.setOnCheckedChangeListener(this);
        this.binding.triggerStopBit1.setOnCheckedChangeListener(this);
        this.binding.triggerStopBit15.setOnCheckedChangeListener(this);
        this.binding.triggerStopBit2.setOnCheckedChangeListener(this);
        this.binding.triggerCheckNone.setOnCheckedChangeListener(this);
        this.binding.triggerCheckOdd.setOnCheckedChangeListener(this);
        this.binding.triggerCheckEven.setOnCheckedChangeListener(this);
        this.binding.buttonLevel.setOnClickListener(this);
        this.binding.triggerSource.setOnClickListener(this);
        this.binding.triggerBaudrate.setOnClickListener(this);
        this.binding.triggerDataWidth.setOnClickListener(this);
        this.binding.triggerBaudrate.setOnLongClickListener(this);
        this.binding.triggerLevelValue.setOnClickListener(this);
        this.binding.dataValue.setOnClickListener(this);
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
                case R.id.normal_radio_button /* 2131363483 */:
                    if (z) {
                        this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1);
                        break;
                    }
                    break;
                case R.id.single_radio_button /* 2131363859 */:
                    if (z) {
                        this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1);
                        break;
                    }
                    break;
                case R.id.trigger_check_even /* 2131364186 */:
                    if (this.param != null) {
                        this.param.saveRs232Parity(z ? 2 : 0);
                        break;
                    }
                    break;
                case R.id.trigger_check_none /* 2131364188 */:
                    if (this.param != null) {
                        this.param.saveRs232Parity(0);
                        break;
                    }
                    break;
                case R.id.trigger_check_odd /* 2131364189 */:
                    TriggerParam triggerParam = this.param;
                    if (triggerParam != null) {
                        triggerParam.saveRs232Parity(z ? 1 : 0);
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
                case R.id.trigger_rs232_check /* 2131364324 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveRs232When(z ? 2 : 0);
                        break;
                    }
                    break;
                case R.id.trigger_rs232_data /* 2131364325 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveRs232When(z ? 3 : 0);
                        break;
                    }
                    break;
                case R.id.trigger_rs232_error /* 2131364326 */:
                    this.aorBManager.set_RadioButton();
                    TriggerParam triggerParam2 = this.param;
                    if (triggerParam2 != null) {
                        triggerParam2.saveRs232When(z ? 1 : 0);
                        break;
                    }
                    break;
                case R.id.trigger_rs232_negative /* 2131364327 */:
                    TriggerParam triggerParam3 = this.param;
                    if (triggerParam3 != null) {
                        triggerParam3.saveRs232Polarity(true);
                        break;
                    }
                    break;
                case R.id.trigger_rs232_positive /* 2131364328 */:
                    TriggerParam triggerParam4 = this.param;
                    if (triggerParam4 != null) {
                        triggerParam4.saveRs232Polarity(false);
                        break;
                    }
                    break;
                case R.id.trigger_rs232_start /* 2131364329 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveRs232When(0);
                        break;
                    }
                    break;
                case R.id.trigger_stop_bit_1 /* 2131364381 */:
                    if (this.param != null) {
                        this.param.saveRs232Stop(0);
                        break;
                    }
                    break;
                case R.id.trigger_stop_bit_1_5 /* 2131364382 */:
                    if (this.param != null) {
                        this.param.saveRs232Stop(z ? 2 : 0);
                        break;
                    }
                    break;
                case R.id.trigger_stop_bit_2 /* 2131364383 */:
                    TriggerParam triggerParam5 = this.param;
                    if (triggerParam5 != null) {
                        triggerParam5.saveRs232Stop(z ? 1 : 0);
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
    public void onClick(final View view) {
        int id = view.getId();
        switch (view.getId()) {
            case R.id.auto_radio_button /* 2131361987 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1);
                return;
            case R.id.button_level /* 2131362192 */:
                if (this.context instanceof Activity) {
                    this.param.saveButtonLevel();
                    return;
                }
                return;
            case R.id.data_value /* 2131362372 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readRs232DataAttr();
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_number, this.param.getRs232DataAttr().getMaxIntValue(), this.param.getRs232DataAttr().getMinIntValue(), this.param.getRs232DataAttr().getDefIntValue(), (int) this.param.getRs232Data(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerRs232Adapter.4
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerRs232Adapter.this.param.saveRs232Data(((Long) t).intValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerRs232Adapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                }
                return;
            case R.id.normal_radio_button /* 2131363483 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1);
                return;
            case R.id.single_radio_button /* 2131363859 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1);
                return;
            case R.id.trigger_baudrate /* 2131364170 */:
                if (this.popupView != null) {
                    final List<MappingObject> list = ViewUtil.getList((int) R.array.msg_trigger_rs232_baudrate);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerRs232Adapter$JMe5mUs2rePzhQiiJsztW6amFW4
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                            TriggerRs232Adapter.this.lambda$onClick$5$TriggerRs232Adapter(popupSpinner, spinnerAdapter, list2, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerRs232Adapter$I4roIYRGLIadrYg3sI8yG1nt160
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerRs232Adapter.this.lambda$onClick$6$TriggerRs232Adapter(list, view, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                }
                return;
            case R.id.trigger_data_width /* 2131364193 */:
                if (this.popupView != null) {
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_trigger_rs232_datawidth), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerRs232Adapter$icZ25ZapKPW5fheEg1S17hew2Ng
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                            TriggerRs232Adapter.this.lambda$onClick$7$TriggerRs232Adapter(popupSpinner, spinnerAdapter, list2, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerRs232Adapter$HOKYW4fqGTeS26jvXyKi8Yzt5Xk
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerRs232Adapter.this.lambda$onClick$8$TriggerRs232Adapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                }
                return;
            case R.id.trigger_level_value /* 2131364280 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readLevelAttr();
                    TriggerParam triggerParam = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam.getChanUnit(triggerParam.getChannel()), this.param.getLevelAttr().getMaxLongValue(), this.param.getLevelAttr().getMinLongValue(), this.param.getLevelAttr().getDefLongValue(), this.param.getLevel(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerRs232Adapter.3
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerRs232Adapter.this.param.saveLevelSync(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerRs232Adapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                }
                return;
            case R.id.trigger_source /* 2131364336 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_source_la)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerRs232Adapter$aS2TZouAQqcn22ReaMErQ1b-Guw
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                            TriggerRs232Adapter.this.lambda$onClick$3$TriggerRs232Adapter(popupSpinner, spinnerAdapter, list2, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerRs232Adapter$fViU8UyKCdzysm47hoT6yy_8yrg
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerRs232Adapter.this.lambda$onClick$4$TriggerRs232Adapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }

    public /* synthetic */ void lambda$onClick$3$TriggerRs232Adapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$TriggerRs232Adapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSource(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$5$TriggerRs232Adapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$TriggerRs232Adapter(List list, View view, View view2, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        if (this.param != null) {
            MappingObject mappingObject2 = (MappingObject) list.get(i);
            if (mappingObject2.getValue() != 0) {
                this.param.saveRs232BaudRate(mappingObject2.getValue());
                return;
            }
            TriggerParam triggerParam = this.param;
            triggerParam.setRs232BaudRate(triggerParam.getRs232BaudRate());
            ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_decimal, this.param.getRs232BaudRateAttr().getMaxIntValue(), this.param.getRs232BaudRateAttr().getMinIntValue(), this.param.getRs232BaudRateAttr().getDefIntValue(), this.param.getRs232BaudRate(), UnitFormat.SI.NONE, new UnitFormat.SI[]{UnitFormat.SI.MEGA, UnitFormat.SI.KILO}, "0.###", new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerRs232Adapter.2
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    TriggerRs232Adapter.this.param.saveRs232BaudRate(((Long) t).intValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerRs232Adapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$7$TriggerRs232Adapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$8$TriggerRs232Adapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectDataWidth(mappingObject);
    }

    private void selectDataWidth(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveRs232Width(mappingObject.getValue());
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == R.id.trigger_baudrate) {
            ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_decimal, this.param.getRs232BaudRateAttr().getMaxIntValue(), this.param.getRs232BaudRateAttr().getMinIntValue(), this.param.getRs232BaudRateAttr().getDefIntValue(), this.param.getRs232BaudRate(), UnitFormat.SI.NONE, new UnitFormat.SI[]{UnitFormat.SI.MEGA, UnitFormat.SI.KILO}, "0.###", new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerRs232Adapter.5
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    TriggerRs232Adapter.this.param.saveRs232BaudRate(((Long) t).intValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerRs232Adapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
        return true;
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        if (i == R.id.data_value) {
            this.param.readRs232DataAttr();
            TriggerParam triggerParam = this.param;
            triggerParam.saveRs232Data(triggerParam.getIntStep(triggerParam.getRs232Data(), this.param.getRs232DataAttr(), z, keyEvent));
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
        if (i == R.id.data_value) {
            TriggerParam triggerParam = this.param;
            triggerParam.saveRs232Data(triggerParam.getIntDef(triggerParam.getRs232DataAttr()));
        } else if (i != R.id.trigger_level_value) {
        } else {
            TriggerParam triggerParam2 = this.param;
            triggerParam2.saveLevelSync(triggerParam2.getLongDef(triggerParam2.getLevelAttr()));
        }
    }

    /* loaded from: classes.dex */
    public class TriggerRs232Holder extends RecyclerView.ViewHolder {
        private AdapterTriggerRs232Binding binding;

        public TriggerRs232Holder(AdapterTriggerRs232Binding adapterTriggerRs232Binding) {
            super(adapterTriggerRs232Binding.getRoot());
            this.binding = adapterTriggerRs232Binding;
        }
    }
}
