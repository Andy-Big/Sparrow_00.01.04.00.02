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
import com.rigol.scope.databinding.AdapterTriggerI2cBinding;
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
public class TriggerI2cAdapter extends RecyclerView.Adapter<TriggerI2cHolder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterTriggerI2cBinding binding;
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

    public TriggerI2cAdapter(Context context, BasePopupView basePopupView, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        this.triggerViewModel = triggerViewModel;
        this.popupView = basePopupView;
        this.context = context;
        this.serviceId = triggerParam.getServiceId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TriggerI2cHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterTriggerI2cBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelbValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerI2cAddrValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerI2cBytelengthValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSourceScl, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSourceSda, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerI2cDirectionValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerAddrWidthValue, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.TriggerI2cAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                TriggerI2cAdapter.this.aorBManager.showKey(TriggerI2cAdapter.this.context, ((AorBParam) TriggerI2cAdapter.this.list_aorbParam.get(i2)).getEditText() != null ? ((AorBParam) TriggerI2cAdapter.this.list_aorbParam.get(i2)).getEditText() : ((AorBParam) TriggerI2cAdapter.this.list_aorbParam.get(i2)).getTextView() != null ? ((AorBParam) TriggerI2cAdapter.this.list_aorbParam.get(i2)).getTextView() : null, true, ((AorBParam) TriggerI2cAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                TriggerI2cAdapter.this.aorBManager.showKey(TriggerI2cAdapter.this.context, ((AorBParam) TriggerI2cAdapter.this.list_aorbParam.get(i2)).getEditText() != null ? ((AorBParam) TriggerI2cAdapter.this.list_aorbParam.get(i2)).getEditText() : ((AorBParam) TriggerI2cAdapter.this.list_aorbParam.get(i2)).getTextView() != null ? ((AorBParam) TriggerI2cAdapter.this.list_aorbParam.get(i2)).getTextView() : null, false, ((AorBParam) TriggerI2cAdapter.this.list_aorbParam.get(i2)).getAorb());
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
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2cAdapter$6LYOYWOrhibd2G3N6Zeo7jiTOOk
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TriggerI2cAdapter.this.lambda$onCreateViewHolder$2$TriggerI2cAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new TriggerI2cHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$TriggerI2cAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (this.popviewTriggerBinding.triggerView.getAdapter() instanceof TriggerI2cAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2cAdapter$ApeTNRS-APoJqR9z1cx07jd1cpA
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerI2cAdapter.this.lambda$onCreateViewHolder$0$TriggerI2cAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2cAdapter$Wo2KWPQmfmCgjmxPTaW9o8AThIE
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    TriggerI2cAdapter.this.lambda$onCreateViewHolder$1$TriggerI2cAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$TriggerI2cAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$TriggerI2cAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.trigger_source_scl) {
            selectSourceScl(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_source_sda) {
            selectSourceSda(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_i2c_direction_value) {
            selectDirectionValue(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_addr_width_value) {
            selectAddressWidthValue(mappingObject);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TriggerI2cHolder triggerI2cHolder, int i) {
        this.triggerViewModel.getLiveData().observe((LifecycleOwner) this.context, new Observer<TriggerParam>() { // from class: com.rigol.scope.adapters.TriggerI2cAdapter.2
            @Override // androidx.lifecycle.Observer
            public void onChanged(TriggerParam triggerParam) {
                TriggerI2cAdapter.this.param = triggerParam;
            }
        });
        ShowTriggerI2c();
        triggerI2cHolder.binding.executePendingBindings();
    }

    public void ShowTriggerI2c() {
        ServiceEnum.Chan chan = this.param.getChan();
        if (chan == ServiceEnum.Chan.acline || chan == ServiceEnum.Chan.ext) {
            int i = ServiceEnum.Chan.chan1.value1;
            this.param.setChannel(i);
            this.param.saveI2cSourceScl(i);
        } else {
            int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_I2C_SCL);
            ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(UI_QueryInt32);
            this.param.setChannel(UI_QueryInt32);
            this.param.setIicChanA(chanFromValue1);
        }
        ServiceEnum.Chan chanB = this.param.getChanB();
        if (chanB == ServiceEnum.Chan.acline || chanB == ServiceEnum.Chan.ext) {
            API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_I2C_SDA, ServiceEnum.Chan.chan1.value1);
            int i2 = ServiceEnum.Chan.chan2.value1;
            ServiceEnum.Chan chanFromValue12 = ServiceEnum.getChanFromValue1(i2);
            this.param.setChannelB(i2);
            this.param.setIicChanB(chanFromValue12);
        } else {
            int UI_QueryInt322 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_I2C_SDA);
            ServiceEnum.Chan chanFromValue13 = ServiceEnum.getChanFromValue1(UI_QueryInt322);
            this.param.setChannelB(UI_QueryInt322);
            this.param.setIicChanB(chanFromValue13);
        }
        this.param.readI2CDirection();
        this.param.readI2CWhen();
        TriggerParam triggerParam = this.param;
        triggerParam.setFormatValue1Str(triggerParam.getFormatValue1Str());
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        this.binding.setWhenStartMapping(ViewUtil.getMappingObject(R.array.msg_trigger_i2c_when, ServiceEnum.Trigger_I2C_When.trig_i2c_start.value1));
        this.binding.setWhenStopMapping(ViewUtil.getMappingObject(R.array.msg_trigger_i2c_when, ServiceEnum.Trigger_I2C_When.trig_i2c_end.value1));
        this.binding.setWhenRestartMapping(ViewUtil.getMappingObject(R.array.msg_trigger_i2c_when, ServiceEnum.Trigger_I2C_When.trig_i2c_restart.value1));
        this.binding.setWhenMissMapping(ViewUtil.getMappingObject(R.array.msg_trigger_i2c_when, ServiceEnum.Trigger_I2C_When.trig_i2c_nack.value1));
        this.binding.setWhenAddressMapping(ViewUtil.getMappingObject(R.array.msg_trigger_i2c_when, ServiceEnum.Trigger_I2C_When.trig_i2c_addr.value1));
        this.binding.setWhenDataMapping(ViewUtil.getMappingObject(R.array.msg_trigger_i2c_when, ServiceEnum.Trigger_I2C_When.trig_i2c_data.value1));
        this.binding.setWhenAdMapping(ViewUtil.getMappingObject(R.array.msg_trigger_i2c_when, ServiceEnum.Trigger_I2C_When.trig_i2c_addr_data.value1));
        this.param.readI2CAddrData();
        this.binding.setParam(this.param);
        ViewUtil.setSwitchButton(this.binding.triggerNoiseSwitch);
        this.binding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.triggerI2cStart.setOnCheckedChangeListener(this);
        this.binding.triggerI2cStop.setOnCheckedChangeListener(this);
        this.binding.triggerI2cRestart.setOnCheckedChangeListener(this);
        this.binding.triggerI2cMissedAck.setOnCheckedChangeListener(this);
        this.binding.triggerI2cData.setOnCheckedChangeListener(this);
        this.binding.triggerI2cAddr.setOnCheckedChangeListener(this);
        this.binding.triggerI2cAddrData.setOnCheckedChangeListener(this);
        this.binding.buttonLevel.setOnClickListener(this);
        this.binding.buttonLevelb.setOnClickListener(this);
        this.binding.triggerSourceScl.setOnClickListener(this);
        this.binding.triggerSourceSda.setOnClickListener(this);
        this.binding.triggerI2cDirectionValue.setOnClickListener(this);
        this.binding.triggerAddrWidthValue.setOnClickListener(this);
        this.binding.triggerLevelValue.setOnClickListener(this);
        this.binding.triggerLevelbValue.setOnClickListener(this);
        this.binding.triggerI2cAddrValue.setOnClickListener(this);
        this.binding.triggerI2cDataValue.setOnClickListener(this);
        this.binding.triggerI2cBytelengthValue.setOnClickListener(this);
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
                case R.id.trigger_i2c_addr /* 2131364233 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveI2cWhen(z ? 4 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_i2c_addr_data /* 2131364234 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveI2cWhen(z ? 6 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_i2c_data /* 2131364239 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveI2cWhen(z ? 5 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_i2c_missed_ack /* 2131364244 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveI2cWhen(z ? 3 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_i2c_restart /* 2131364245 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveI2cWhen(z ? 2 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_i2c_start /* 2131364246 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveI2cWhen(0);
                        return;
                    }
                    return;
                case R.id.trigger_i2c_stop /* 2131364247 */:
                    this.aorBManager.set_RadioButton();
                    TriggerParam triggerParam = this.param;
                    if (triggerParam != null) {
                        triggerParam.saveI2cWhen(z ? 1 : 0);
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
                    triggerParam.setChan(triggerParam.getIicChanA());
                    API.getInstance().UI_PostInt32(this.serviceId, MessageID.MSG_TRIGGER_I2C_SCL, this.param.getIicChanA().value1);
                    this.param.saveButtonLevel();
                    break;
                }
                break;
            case R.id.button_levelb /* 2131362195 */:
                if (this.context instanceof Activity) {
                    TriggerParam triggerParam2 = this.param;
                    triggerParam2.setChan(triggerParam2.getIicChanB());
                    API.getInstance().UI_PostInt32(this.serviceId, MessageID.MSG_TRIGGER_I2C_SDA, this.param.getIicChanB().value1);
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
            case R.id.trigger_addr_width_value /* 2131364165 */:
                if (this.popupView != null) {
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_trigger_i2c_addrdata_bits), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2cAdapter$HUAIZhvr63gRlvusjFsd_zt4kYY
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerI2cAdapter.this.lambda$onClick$9$TriggerI2cAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2cAdapter$UXHe0b5mbrU5p4Geeis_ZxkQE38
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerI2cAdapter.this.lambda$onClick$10$TriggerI2cAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_i2c_addr_value /* 2131364236 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readI2cAddressAttr();
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_number, this.param.getI2cAddressAttr().getMaxIntValue(), this.param.getI2cAddressAttr().getMinIntValue(), this.param.getI2cAddressAttr().getDefIntValue(), this.param.getI2cAddress(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerI2cAdapter.4
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerI2cAdapter.this.param.saveI2cAddress(((Long) t).intValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerI2cAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_i2c_bytelength_value /* 2131364238 */:
                if (this.aorBManager.setClick_showab_textview(id) && (this.context instanceof Activity)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_number, this.param.getI2cByteLengthAttr().getMaxIntValue(), this.param.getI2cByteLengthAttr().getMinIntValue(), this.param.getI2cByteLengthAttr().getDefIntValue(), this.param.getByteLength(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerI2cAdapter.3
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerI2cAdapter.this.param.saveByteLength(((Long) t).intValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerI2cAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_i2c_data_value /* 2131364241 */:
                if (this.context instanceof Activity) {
                    TriggerParam triggerParam3 = this.param;
                    triggerParam3.setKeyNumMax(triggerParam3.getByteLength() * 8);
                    if (this.formatTransformKey == null) {
                        FormatTransformKey formatTransformKey = new FormatTransformKey(this.context, this.popupView.getAnchor(), this.param);
                        this.formatTransformKey = formatTransformKey;
                        formatTransformKey.attachRefView(this.binding.triggerI2cDataValue);
                        this.formatTransformKey.getFormatTransformValue(new FormatTransformKey.FormatTransformInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2cAdapter$HJKl_Jr3EnOZxHaCMmedu15S-c4
                            @Override // com.rigol.scope.views.FormatTransformKey.FormatTransformInterface
                            public final void FormatTransformListener(String str) {
                                TriggerI2cAdapter.this.lambda$onClick$11$TriggerI2cAdapter(str);
                            }
                        });
                    }
                    this.formatTransformKey.show();
                    this.formatTransformKey.init();
                    break;
                }
                break;
            case R.id.trigger_i2c_direction_value /* 2131364243 */:
                if (this.popupView != null) {
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_trigger_i2c_direction), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2cAdapter$qbJ2xgRJjxpEodK0sstlmhO9WtE
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerI2cAdapter.this.lambda$onClick$7$TriggerI2cAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2cAdapter$dktoha888jBy6_5kYXrCZULYVLo
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerI2cAdapter.this.lambda$onClick$8$TriggerI2cAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_level_value /* 2131364280 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readiicLevelAttr();
                    TriggerParam triggerParam4 = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam4.getChanUnit(triggerParam4.getChannel()), this.param.getiicLevelAttr().getMaxLongValue(), this.param.getiicLevelAttr().getMinLongValue(), this.param.getiicLevelAttr().getDefLongValue(), this.param.getIiclevelA(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerI2cAdapter.5
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerI2cAdapter.this.param.saveIicLevelA(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerI2cAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_levelb_value /* 2131364286 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readiicLevelBAttr();
                    TriggerParam triggerParam5 = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam5.getChanUnit(triggerParam5.getChannelB()), this.param.getiicLevelBAttr().getMaxLongValue(), this.param.getiicLevelBAttr().getMinLongValue(), this.param.getiicLevelBAttr().getDefLongValue(), this.param.getIiclevelB(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerI2cAdapter.6
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerI2cAdapter.this.param.saveIicLevelB(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerI2cAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source_scl /* 2131364362 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_i2c_scl)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2cAdapter$RYdzTiwxw60HJmCueoRNscPNsJQ
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerI2cAdapter.this.lambda$onClick$3$TriggerI2cAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2cAdapter$qJG179hn1MXe1WD1q5GLEWW2Ic4
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerI2cAdapter.this.lambda$onClick$4$TriggerI2cAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source_sda /* 2131364366 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_i2c_sda)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2cAdapter$E7FSVw1WSAimviSsO0ExcW1tltY
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerI2cAdapter.this.lambda$onClick$5$TriggerI2cAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2cAdapter$08hDrdiJ8E5O3XaCstzZlj2CvDA
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerI2cAdapter.this.lambda$onClick$6$TriggerI2cAdapter(view2, viewHolder, i, (MappingObject) obj);
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

    public /* synthetic */ void lambda$onClick$3$TriggerI2cAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$TriggerI2cAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceScl(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$5$TriggerI2cAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$TriggerI2cAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceSda(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$7$TriggerI2cAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$8$TriggerI2cAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectDirectionValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$9$TriggerI2cAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$10$TriggerI2cAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectAddressWidthValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$11$TriggerI2cAdapter(String str) {
        this.param.setFormatValue1Str(str);
        if (str.contains("[bin]")) {
            this.param.setI2cDataType(0);
        } else {
            this.param.setI2cDataType(1);
        }
    }

    private void selectAddressWidthValue(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveI2cAddrWidthValue(mappingObject.getValue());
        }
    }

    private void selectDirectionValue(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveI2cDirectionValue(mappingObject.getValue());
        }
    }

    private void selectSourceSda(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveI2cSourceSda(mappingObject.getValue());
            this.param.setChannelB(mappingObject.getValue());
        }
    }

    private void selectSourceScl(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveI2cSourceScl(mappingObject.getValue());
            this.param.setChannel(mappingObject.getValue());
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        switch (i) {
            case R.id.trigger_i2c_addr_value /* 2131364236 */:
                this.param.readI2cAddressAttr();
                TriggerParam triggerParam = this.param;
                triggerParam.saveI2cAddress(triggerParam.getIntStep(triggerParam.getI2cAddress(), this.param.getI2cAddressAttr(), z, keyEvent));
                return;
            case R.id.trigger_i2c_bytelength_value /* 2131364238 */:
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveByteLength(triggerParam2.getIntStep(triggerParam2.getByteLength(), this.param.getI2cByteLengthAttr(), z, keyEvent));
                return;
            case R.id.trigger_level_value /* 2131364280 */:
                TriggerParam triggerParam3 = this.param;
                triggerParam3.setChan(triggerParam3.getIicChanA());
                TriggerParam triggerParam4 = this.param;
                triggerParam4.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam4);
                return;
            case R.id.trigger_levelb_value /* 2131364286 */:
                TriggerParam triggerParam5 = this.param;
                triggerParam5.setChan(triggerParam5.getIicChanB());
                TriggerParam triggerParam6 = this.param;
                triggerParam6.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam6);
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
            case R.id.trigger_i2c_addr_value /* 2131364236 */:
                this.param.readI2cAddressAttr();
                TriggerParam triggerParam = this.param;
                triggerParam.saveI2cAddress(triggerParam.getIntDef(triggerParam.getI2cAddressAttr()));
                return;
            case R.id.trigger_i2c_bytelength_value /* 2131364238 */:
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveByteLength(triggerParam2.getIntDef(triggerParam2.getI2cByteLengthAttr()));
                return;
            case R.id.trigger_level_value /* 2131364280 */:
                TriggerParam triggerParam3 = this.param;
                triggerParam3.saveIicLevelA(triggerParam3.getLongDef(triggerParam3.getiicLevelAttr()));
                return;
            case R.id.trigger_levelb_value /* 2131364286 */:
                TriggerParam triggerParam4 = this.param;
                triggerParam4.saveIicLevelB(triggerParam4.getLongDef(triggerParam4.getiicLevelBAttr()));
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public class TriggerI2cHolder extends RecyclerView.ViewHolder {
        private AdapterTriggerI2cBinding binding;

        public TriggerI2cHolder(AdapterTriggerI2cBinding adapterTriggerI2cBinding) {
            super(adapterTriggerI2cBinding.getRoot());
            this.binding = adapterTriggerI2cBinding;
        }
    }
}
