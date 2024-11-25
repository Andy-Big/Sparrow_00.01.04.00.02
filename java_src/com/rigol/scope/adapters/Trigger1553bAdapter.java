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
import com.rigol.scope.databinding.AdapterTrigger1553bBinding;
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
public class Trigger1553bAdapter extends RecyclerView.Adapter<Trigger1553bHolder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset, AorBManager.OnSetTextByTriggerLevelRoll {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterTrigger1553bBinding binding;
    private View clickedView;
    private Context context;
    private FormatTransformKey formatTransformKeyDownLimit;
    private FormatTransformKey formatTransformKeyRta;
    private FormatTransformKey formatTransformKeyRta11Bit;
    private FormatTransformKey formatTransformKeyUpLimit;
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
    private int dataMax = 16;
    private int rtaMax = 5;
    private int rta11BitMax = 11;
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

    public Trigger1553bAdapter(Context context, BasePopupView basePopupView, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        this.triggerViewModel = triggerViewModel;
        this.param = triggerParam;
        this.popupView = basePopupView;
        this.context = context;
        this.serviceId = triggerParam.getServiceId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public Trigger1553bHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterTrigger1553bBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelaValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelbValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSource, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.trigger1553bSyncValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.trigger1553bErrorValue, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this, this) { // from class: com.rigol.scope.adapters.Trigger1553bAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                Trigger1553bAdapter.this.aorBManager.showKey(Trigger1553bAdapter.this.context, ((AorBParam) Trigger1553bAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) Trigger1553bAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                Trigger1553bAdapter.this.aorBManager.showKey(Trigger1553bAdapter.this.context, ((AorBParam) Trigger1553bAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) Trigger1553bAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.triggerLevelaValue, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.triggerLevelbValue, true, ViewUtil.KEY_B);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$Trigger1553bAdapter$EVEk1uvDlyQ2uPL28AiotX-q5II
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        Trigger1553bAdapter.this.lambda$onCreateViewHolder$2$Trigger1553bAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new Trigger1553bHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$Trigger1553bAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (this.popviewTriggerBinding.triggerView.getAdapter() instanceof Trigger1553bAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$Trigger1553bAdapter$dF5udryi0g9bM06V06hFvKic-co
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    Trigger1553bAdapter.this.lambda$onCreateViewHolder$0$Trigger1553bAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$Trigger1553bAdapter$eqabx-epxGAGsWu3VxyurOQmXmU
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    Trigger1553bAdapter.this.lambda$onCreateViewHolder$1$Trigger1553bAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$Trigger1553bAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$Trigger1553bAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.trigger_source) {
            selectSource(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_1553b_sync_value) {
            selectSyncValue(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_1553b_error_value) {
            selectErrorValue(mappingObject);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(Trigger1553bHolder trigger1553bHolder, int i) {
        ShowTrigger1553b();
        trigger1553bHolder.binding.executePendingBindings();
    }

    public void ShowTrigger1553b() {
        ServiceEnum.Chan chan = this.param.getChan();
        if (chan == ServiceEnum.Chan.acline || chan == ServiceEnum.Chan.ext) {
            int i = ServiceEnum.Chan.chan1.value1;
            this.param.setChannel(i);
            this.param.saveMilstdSource(i);
        } else {
            this.param.setChan(ServiceEnum.getChanFromValue1(chan.value1));
        }
        this.param.setChanColor(this.binding.triggerSource, chan);
        this.param.readMilstdPolarity();
        this.param.readMilstdLevelSelect();
        this.param.readMilstdWhen();
        this.param.readMilstdDataComp();
        this.param.readMilstdSyncType();
        this.param.readMilstdErrType();
        this.param.readMilstdHighLevel();
        this.param.readMilstdLowLevel();
        this.param.checkLevel();
        TriggerParam triggerParam = this.param;
        triggerParam.setFormatValue6MaxStr(triggerParam.getFormatValue6MaxStr());
        TriggerParam triggerParam2 = this.param;
        triggerParam2.setFormatValue6Str(triggerParam2.getFormatValue6Str());
        TriggerParam triggerParam3 = this.param;
        triggerParam3.setFormatValue6RtaStr(triggerParam3.getFormatValue6RtaStr());
        TriggerParam triggerParam4 = this.param;
        triggerParam4.setFormatValue6BitStr(triggerParam4.getFormatValue6BitStr());
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        this.binding.setPolarityPositiveMapping(ViewUtil.getMappingObject(R.array.msg_trigger_polarity, ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive.value1));
        this.binding.setPolarityNegativeMapping(ViewUtil.getMappingObject(R.array.msg_trigger_polarity, ServiceEnum.TriggerPulsePolarity.Trigger_pulse_negative.value1));
        this.binding.setSelectLevelAMapping(ViewUtil.getMappingObject(R.array.msg_trigger_levelselect, ServiceEnum.Trigger_Level_ID.Trigger_Level_High.value1));
        this.binding.setSelectLevelBMapping(ViewUtil.getMappingObject(R.array.msg_trigger_levelselect, ServiceEnum.Trigger_Level_ID.Trigger_Level_Low.value1));
        this.binding.setSelectLevelABMapping(ViewUtil.getMappingObject(R.array.msg_trigger_levelselect, ServiceEnum.Trigger_Level_ID.Trigger_Level_Double.value1));
        this.binding.setWhenSyncMapping(ViewUtil.getMappingObject(R.array.msg_trigger_1553b_when, ServiceEnum.Trigger_1553_When.trig_1553_sync.value1));
        this.binding.setWhenDataMapping(ViewUtil.getMappingObject(R.array.msg_trigger_1553b_when, ServiceEnum.Trigger_1553_When.trig_1553_data.value1));
        this.binding.setWhenRtaMapping(ViewUtil.getMappingObject(R.array.msg_trigger_1553b_when, ServiceEnum.Trigger_1553_When.trig_1553_cmd.value1));
        this.binding.setWhenRtabitMapping(ViewUtil.getMappingObject(R.array.msg_trigger_1553b_when, ServiceEnum.Trigger_1553_When.trig_1553_status.value1));
        this.binding.setWhenErrorMapping(ViewUtil.getMappingObject(R.array.msg_trigger_1553b_when, ServiceEnum.Trigger_1553_When.trig_1553_err.value1));
        this.binding.setParam(this.param);
        ViewUtil.setSwitchButton(this.binding.triggerNoiseSwitch);
        this.binding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.trigger1553bPositive.setOnCheckedChangeListener(this);
        this.binding.trigger1553bNegative.setOnCheckedChangeListener(this);
        this.binding.trigger1553bLevela.setOnCheckedChangeListener(this);
        this.binding.trigger1553bLevelb.setOnCheckedChangeListener(this);
        this.binding.trigger1553bLevelab.setOnCheckedChangeListener(this);
        this.binding.trigger1553bSync.setOnCheckedChangeListener(this);
        this.binding.trigger1553bData.setOnCheckedChangeListener(this);
        this.binding.trigger1553bRta.setOnCheckedChangeListener(this);
        this.binding.trigger1553bRta11bit.setOnCheckedChangeListener(this);
        this.binding.trigger1553bError.setOnCheckedChangeListener(this);
        this.binding.trigger1553bEq.setOnCheckedChangeListener(this);
        this.binding.trigger1553bNeq.setOnCheckedChangeListener(this);
        this.binding.trigger1553bMorethan.setOnCheckedChangeListener(this);
        this.binding.trigger1553bLessthan.setOnCheckedChangeListener(this);
        this.binding.trigger1553bUnmoreless.setOnCheckedChangeListener(this);
        this.binding.trigger1553bMoreless.setOnCheckedChangeListener(this);
        this.binding.buttonLevela.setOnClickListener(this);
        this.binding.buttonLevelb.setOnClickListener(this);
        this.binding.triggerSource.setOnClickListener(this);
        this.binding.trigger1553bSyncValue.setOnClickListener(this);
        this.binding.trigger1553bErrorValue.setOnClickListener(this);
        this.binding.triggerLevelaValue.setOnClickListener(this);
        this.binding.triggerLevelbValue.setOnClickListener(this);
        this.binding.trigger1553bUpLimitValue.setOnClickListener(this);
        this.binding.trigger1553bDownLimitValue.setOnClickListener(this);
        this.binding.trigger1553bRtaValue.setOnClickListener(this);
        this.binding.trigger1553bRta11Value.setOnClickListener(this);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            int id = compoundButton.getId();
            switch (id) {
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
                case R.id.trigger_1553b_data /* 2131364135 */:
                    TriggerParam triggerParam = this.param;
                    if (triggerParam != null) {
                        triggerParam.saveMilstdWhen(z ? 1 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_1553b_rta_11bit /* 2131364155 */:
                    if (this.param != null) {
                        this.param.saveMilstdWhen(z ? 3 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_1553b_sync /* 2131364158 */:
                    if (this.param != null) {
                        this.param.saveMilstdWhen(0);
                        return;
                    }
                    return;
                case R.id.trigger_1553b_unmoreless /* 2131364161 */:
                    if (this.param != null) {
                        this.param.saveMilstdCompare(z ? 5 : 0);
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
                    switch (id) {
                        case R.id.trigger_1553b_eq /* 2131364138 */:
                            if (this.param != null) {
                                this.param.saveMilstdCompare(0);
                                return;
                            }
                            return;
                        case R.id.trigger_1553b_error /* 2131364139 */:
                            if (this.param != null) {
                                this.param.saveMilstdWhen(z ? 4 : 0);
                                return;
                            }
                            return;
                        default:
                            switch (id) {
                                case R.id.trigger_1553b_lessthan /* 2131364142 */:
                                    if (this.param != null) {
                                        this.param.saveMilstdCompare(z ? 3 : 0);
                                        return;
                                    }
                                    return;
                                case R.id.trigger_1553b_levela /* 2131364143 */:
                                    if (this.param != null) {
                                        this.param.saveMilstdLevelSelect(0);
                                        return;
                                    }
                                    return;
                                case R.id.trigger_1553b_levelab /* 2131364144 */:
                                    if (this.param != null) {
                                        this.param.saveMilstdLevelSelect(z ? 2 : 0);
                                        return;
                                    }
                                    return;
                                case R.id.trigger_1553b_levelb /* 2131364145 */:
                                    TriggerParam triggerParam2 = this.param;
                                    if (triggerParam2 != null) {
                                        triggerParam2.saveMilstdLevelSelect(z ? 1 : 0);
                                        return;
                                    }
                                    return;
                                case R.id.trigger_1553b_moreless /* 2131364146 */:
                                    if (this.param != null) {
                                        this.param.saveMilstdCompare(z ? 4 : 0);
                                        return;
                                    }
                                    return;
                                case R.id.trigger_1553b_morethan /* 2131364147 */:
                                    if (this.param != null) {
                                        this.param.saveMilstdCompare(z ? 2 : 0);
                                        return;
                                    }
                                    return;
                                case R.id.trigger_1553b_negative /* 2131364148 */:
                                    TriggerParam triggerParam3 = this.param;
                                    if (triggerParam3 != null) {
                                        triggerParam3.saveMilstdPolarity(true);
                                        return;
                                    }
                                    return;
                                case R.id.trigger_1553b_neq /* 2131364149 */:
                                    TriggerParam triggerParam4 = this.param;
                                    if (triggerParam4 != null) {
                                        triggerParam4.saveMilstdCompare(z ? 1 : 0);
                                        return;
                                    }
                                    return;
                                default:
                                    switch (id) {
                                        case R.id.trigger_1553b_positive /* 2131364151 */:
                                            TriggerParam triggerParam5 = this.param;
                                            if (triggerParam5 != null) {
                                                triggerParam5.saveMilstdPolarity(false);
                                                return;
                                            }
                                            return;
                                        case R.id.trigger_1553b_rta /* 2131364152 */:
                                            if (this.param != null) {
                                                this.param.saveMilstdWhen(z ? 2 : 0);
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                            }
                    }
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
            case R.id.button_levela /* 2131362194 */:
                if (this.context instanceof Activity) {
                    this.param.saveButtonLevelA();
                    break;
                }
                break;
            case R.id.button_levelb /* 2131362195 */:
                if (this.context instanceof Activity) {
                    this.param.saveButtonLevelB();
                    break;
                }
                break;
            case R.id.normal_radio_button /* 2131363483 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1);
                break;
            case R.id.single_radio_button /* 2131363859 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1);
                break;
            case R.id.trigger_1553b_down_limit_value /* 2131364137 */:
                if (this.context instanceof Activity) {
                    this.param.setMilstdDataType(1);
                    this.param.setKeyNumMax(this.dataMax);
                    if (this.formatTransformKeyDownLimit == null) {
                        FormatTransformKey formatTransformKey = new FormatTransformKey(this.context, this.popupView.getAnchor(), this.param);
                        this.formatTransformKeyDownLimit = formatTransformKey;
                        formatTransformKey.attachRefView(this.binding.trigger1553bDownLimitValue);
                        this.formatTransformKeyDownLimit.getFormatTransformValue(new FormatTransformKey.FormatTransformInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$Trigger1553bAdapter$4-FUqPyQeL4_K5ay38lufcIl7J0
                            @Override // com.rigol.scope.views.FormatTransformKey.FormatTransformInterface
                            public final void FormatTransformListener(String str) {
                                Trigger1553bAdapter.this.lambda$onClick$10$Trigger1553bAdapter(str);
                            }
                        });
                    }
                    this.formatTransformKeyDownLimit.show();
                    this.formatTransformKeyDownLimit.init();
                    break;
                }
                break;
            case R.id.trigger_1553b_error_value /* 2131364141 */:
                if (this.popupView != null) {
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_trigger_1553b_err_type), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$Trigger1553bAdapter$72SpjsJdKXTve3ZUQPIUZ9gQJ8U
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            Trigger1553bAdapter.this.lambda$onClick$7$Trigger1553bAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$Trigger1553bAdapter$4sdbKZg_M0PPRQpW4zG-7Kd5kks
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            Trigger1553bAdapter.this.lambda$onClick$8$Trigger1553bAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_1553b_rta11_value /* 2131364154 */:
                if (this.context instanceof Activity) {
                    this.param.setMilstdDataType(3);
                    this.param.setKeyNumMax(this.rta11BitMax);
                    if (this.formatTransformKeyRta11Bit == null) {
                        FormatTransformKey formatTransformKey2 = new FormatTransformKey(this.context, this.popupView.getAnchor(), this.param);
                        this.formatTransformKeyRta11Bit = formatTransformKey2;
                        formatTransformKey2.attachRefView(this.binding.trigger1553bRta11Value);
                        this.formatTransformKeyRta11Bit.getFormatTransformValue(new FormatTransformKey.FormatTransformInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$Trigger1553bAdapter$A5WkYk8gxZS7N8L57xKJVz1PCDc
                            @Override // com.rigol.scope.views.FormatTransformKey.FormatTransformInterface
                            public final void FormatTransformListener(String str) {
                                Trigger1553bAdapter.this.lambda$onClick$12$Trigger1553bAdapter(str);
                            }
                        });
                    }
                    this.formatTransformKeyRta11Bit.show();
                    this.formatTransformKeyRta11Bit.init();
                    break;
                }
                break;
            case R.id.trigger_1553b_rta_value /* 2131364157 */:
                if (this.context instanceof Activity) {
                    this.param.setMilstdDataType(2);
                    this.param.setKeyNumMax(this.rtaMax);
                    if (this.formatTransformKeyRta == null) {
                        FormatTransformKey formatTransformKey3 = new FormatTransformKey(this.context, this.popupView.getAnchor(), this.param);
                        this.formatTransformKeyRta = formatTransformKey3;
                        formatTransformKey3.attachRefView(this.binding.trigger1553bRtaValue);
                        this.formatTransformKeyRta.getFormatTransformValue(new FormatTransformKey.FormatTransformInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$Trigger1553bAdapter$Xt6VEtTxm_JLfPEpTIYiW7F9w9Y
                            @Override // com.rigol.scope.views.FormatTransformKey.FormatTransformInterface
                            public final void FormatTransformListener(String str) {
                                Trigger1553bAdapter.this.lambda$onClick$11$Trigger1553bAdapter(str);
                            }
                        });
                    }
                    this.formatTransformKeyRta.show();
                    this.formatTransformKeyRta.init();
                    break;
                }
                break;
            case R.id.trigger_1553b_sync_value /* 2131364160 */:
                if (this.popupView != null) {
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_trigger_1553b_sync_type), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$Trigger1553bAdapter$9ZYGQh3XBgl-QafSHRB1M2sbdUc
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            Trigger1553bAdapter.this.lambda$onClick$5$Trigger1553bAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$Trigger1553bAdapter$rU3zN88YhnY_nDR1KyeK3kVH_CA
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            Trigger1553bAdapter.this.lambda$onClick$6$Trigger1553bAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_1553b_up_limit_value /* 2131364163 */:
                if (this.context instanceof Activity) {
                    this.param.setMilstdDataType(0);
                    this.param.setKeyNumMax(this.dataMax);
                    if (this.formatTransformKeyUpLimit == null) {
                        FormatTransformKey formatTransformKey4 = new FormatTransformKey(this.context, this.popupView.getAnchor(), this.param);
                        this.formatTransformKeyUpLimit = formatTransformKey4;
                        formatTransformKey4.attachRefView(this.binding.trigger1553bUpLimitValue);
                        this.formatTransformKeyUpLimit.getFormatTransformValue(new FormatTransformKey.FormatTransformInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$Trigger1553bAdapter$Z2O76qYuBsAF4aOh7uo7OTtfYpk
                            @Override // com.rigol.scope.views.FormatTransformKey.FormatTransformInterface
                            public final void FormatTransformListener(String str) {
                                Trigger1553bAdapter.this.lambda$onClick$9$Trigger1553bAdapter(str);
                            }
                        });
                    }
                    this.formatTransformKeyUpLimit.show();
                    this.formatTransformKeyUpLimit.init();
                    break;
                }
                break;
            case R.id.trigger_levela_value /* 2131364283 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_LEVEL);
                    this.param.readmilstdLevelAttr();
                    TriggerParam triggerParam = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam.getChanUnit(triggerParam.getChannel()), this.param.getmilstdLevelAttr().getMaxLongValue(), this.param.getmilstdLevelAttr().getMinLongValue(), this.param.getmilstdLevelAttr().getDefLongValue(), this.param.getMilstdlevelA(), new KeyboardListener() { // from class: com.rigol.scope.adapters.Trigger1553bAdapter.2
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            if (Trigger1553bAdapter.this.param.getMilstdTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                                Trigger1553bAdapter.this.param.saveMilstdLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_High.value1);
                            }
                            Trigger1553bAdapter.this.param.saveMilstdLevelASync(((Long) t).longValue());
                            Trigger1553bAdapter.this.param.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, Trigger1553bAdapter.this.param.getMilstdlevelB());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            Trigger1553bAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_levelb_value /* 2131364286 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_LEVEL);
                    this.param.readmilstdLevelBAttr();
                    TriggerParam triggerParam2 = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam2.getChanUnit(triggerParam2.getChannel()), this.param.getmilstdLevelBAttr().getMaxLongValue(), this.param.getmilstdLevelBAttr().getMinLongValue(), this.param.getmilstdLevelBAttr().getDefLongValue(), this.param.getMilstdlevelB(), new KeyboardListener() { // from class: com.rigol.scope.adapters.Trigger1553bAdapter.3
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            if (Trigger1553bAdapter.this.param.getMilstdTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                                Trigger1553bAdapter.this.param.saveMilstdLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Low.value1);
                            }
                            Trigger1553bAdapter.this.param.saveMilstdLevelBSync(((Long) t).longValue());
                            Trigger1553bAdapter.this.param.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, Trigger1553bAdapter.this.param.getMilstdlevelA());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            Trigger1553bAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source /* 2131364336 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_source)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$Trigger1553bAdapter$ZBDBDfVUnOnknsF_v3M-iU9kKlk
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            Trigger1553bAdapter.this.lambda$onClick$3$Trigger1553bAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$Trigger1553bAdapter$zztTI4UAcv9pdhQ_KyG-DpVjw4U
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            Trigger1553bAdapter.this.lambda$onClick$4$Trigger1553bAdapter(view2, viewHolder, i, (MappingObject) obj);
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

    public /* synthetic */ void lambda$onClick$3$Trigger1553bAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$Trigger1553bAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSource(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$5$Trigger1553bAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$Trigger1553bAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSyncValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$7$Trigger1553bAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$8$Trigger1553bAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectErrorValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$9$Trigger1553bAdapter(String str) {
        this.param.setFormatValue6MaxStr(str);
        if (str.contains("[bin]")) {
            this.param.setUpType(0);
        } else {
            this.param.setUpType(1);
        }
    }

    public /* synthetic */ void lambda$onClick$10$Trigger1553bAdapter(String str) {
        this.param.setFormatValue6Str(str);
        if (str.contains("[bin]")) {
            this.param.setDownType(0);
        } else {
            this.param.setDownType(1);
        }
    }

    public /* synthetic */ void lambda$onClick$11$Trigger1553bAdapter(String str) {
        this.param.setFormatValue6RtaStr(str);
        if (str.contains("[bin]")) {
            this.param.setRtaType(0);
        } else {
            this.param.setRtaType(1);
        }
    }

    public /* synthetic */ void lambda$onClick$12$Trigger1553bAdapter(String str) {
        this.param.setFormatValue6BitStr(str);
        if (str.contains("[bin]")) {
            this.param.setBitType(0);
        } else {
            this.param.setBitType(1);
        }
    }

    private void selectErrorValue(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveMilstdErrorValue(mappingObject.getValue());
        }
    }

    private void selectSyncValue(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveMilstdSyncValue(mappingObject.getValue());
        }
    }

    private void selectSource(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveMilstdSource(mappingObject.getValue());
            this.param.setChannel(mappingObject.getValue());
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        if (i == R.id.trigger_levela_value) {
            if (!this.binding.trigger1553bLevelab.isChecked()) {
                this.param.setMilstdTrigger_Level_ID(ServiceEnum.Trigger_Level_ID.Trigger_Level_High);
            }
            TriggerParam triggerParam = this.param;
            triggerParam.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam);
        } else if (i != R.id.trigger_levelb_value) {
        } else {
            if (!this.binding.trigger1553bLevelab.isChecked()) {
                this.param.setMilstdTrigger_Level_ID(ServiceEnum.Trigger_Level_ID.Trigger_Level_Low);
            }
            TriggerParam triggerParam2 = this.param;
            triggerParam2.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam2);
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        if (this.param == null || !isMove()) {
            return;
        }
        if (i == R.id.trigger_levela_value) {
            if (this.param.getMilstdTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                TriggerParam triggerParam = this.param;
                if (triggerParam.getLongDef(triggerParam.getmilstdLevelAttr()) < this.param.getMilstdlevelB() + (this.param.getChanScale() / 10)) {
                    TriggerParam triggerParam2 = this.param;
                    triggerParam2.setLevelB(triggerParam2.getLongDef(triggerParam2.getmilstdLevelAttr()) - (this.param.getChanScale() / 10));
                    TriggerParam triggerParam3 = this.param;
                    triggerParam3.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, triggerParam3.getLongDef(triggerParam3.getmilstdLevelAttr()) - (this.param.getChanScale() / 10));
                    TriggerParam triggerParam4 = this.param;
                    triggerParam4.setMilstdlevelB(triggerParam4.getLongDef(triggerParam4.getmilstdLevelAttr()) - (this.param.getChanScale() / 10));
                    API api = API.getInstance();
                    TriggerParam triggerParam5 = this.param;
                    api.UI_PostInt64(41, MessageID.MSG_TRIGGER_1553B_LEVEL_L, triggerParam5.getLongDef(triggerParam5.getmilstdLevelAttr()) - (this.param.getChanScale() / 10));
                }
                TriggerParam triggerParam6 = this.param;
                triggerParam6.setLevel(triggerParam6.getLongDef(triggerParam6.getmilstdLevelAttr()));
                TriggerParam triggerParam7 = this.param;
                triggerParam7.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, triggerParam7.getLongDef(triggerParam7.getmilstdLevelAttr()));
                TriggerParam triggerParam8 = this.param;
                triggerParam8.setMilstdlevelA(triggerParam8.getLongDef(triggerParam8.getmilstdLevelAttr()));
                API api2 = API.getInstance();
                TriggerParam triggerParam9 = this.param;
                api2.UI_PostInt64(41, MessageID.MSG_TRIGGER_1553B_LEVEL_H, triggerParam9.getLongDef(triggerParam9.getmilstdLevelAttr()));
                this.param.saveMilstdLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Double.value1);
                return;
            }
            TriggerParam triggerParam10 = this.param;
            triggerParam10.saveMilstdLevelASync(this.aorBManager.getLongDef(triggerParam10.getmilstdLevelAttr()));
        } else if (i != R.id.trigger_levelb_value) {
        } else {
            if (this.param.getMilstdTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                TriggerParam triggerParam11 = this.param;
                if (triggerParam11.getLongDef(triggerParam11.getmilstdLevelBAttr()) > this.param.getMilstdlevelA() - (this.param.getChanScale() / 10)) {
                    TriggerParam triggerParam12 = this.param;
                    triggerParam12.setLevel(triggerParam12.getLongDef(triggerParam12.getmilstdLevelBAttr()) + (this.param.getChanScale() / 10));
                    TriggerParam triggerParam13 = this.param;
                    triggerParam13.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, triggerParam13.getLongDef(triggerParam13.getmilstdLevelBAttr()) + (this.param.getChanScale() / 10));
                    TriggerParam triggerParam14 = this.param;
                    triggerParam14.setMilstdlevelA(triggerParam14.getLongDef(triggerParam14.getmilstdLevelBAttr()) + (this.param.getChanScale() / 10));
                    API api3 = API.getInstance();
                    TriggerParam triggerParam15 = this.param;
                    api3.UI_PostInt64(41, MessageID.MSG_TRIGGER_1553B_LEVEL_H, triggerParam15.getLongDef(triggerParam15.getmilstdLevelBAttr()) + (this.param.getChanScale() / 10));
                }
                TriggerParam triggerParam16 = this.param;
                triggerParam16.setLevelB(triggerParam16.getLongDef(triggerParam16.getmilstdLevelBAttr()));
                TriggerParam triggerParam17 = this.param;
                triggerParam17.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, triggerParam17.getLongDef(triggerParam17.getmilstdLevelBAttr()));
                TriggerParam triggerParam18 = this.param;
                triggerParam18.setMilstdlevelB(triggerParam18.getLongDef(triggerParam18.getmilstdLevelBAttr()));
                API api4 = API.getInstance();
                TriggerParam triggerParam19 = this.param;
                api4.UI_PostInt64(41, MessageID.MSG_TRIGGER_1553B_LEVEL_L, triggerParam19.getLongDef(triggerParam19.getmilstdLevelBAttr()));
                this.param.saveMilstdLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Double.value1);
                return;
            }
            TriggerParam triggerParam20 = this.param;
            triggerParam20.saveMilstdLevelBSync(this.aorBManager.getLongDef(triggerParam20.getmilstdLevelBAttr()));
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
    public class Trigger1553bHolder extends RecyclerView.ViewHolder {
        private AdapterTrigger1553bBinding binding;

        public Trigger1553bHolder(AdapterTrigger1553bBinding adapterTrigger1553bBinding) {
            super(adapterTrigger1553bBinding.getRoot());
            this.binding = adapterTrigger1553bBinding;
        }
    }
}
