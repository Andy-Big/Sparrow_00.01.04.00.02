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
import com.rigol.scope.databinding.AdapterTriggerLinBinding;
import com.rigol.scope.databinding.PopupviewTriggerBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.UnitFormat;
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
public class TriggerLinAdapter extends RecyclerView.Adapter<TriggerLinHolder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, View.OnLongClickListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterTriggerLinBinding binding;
    private View clickedView;
    private Context context;
    private FormatTransformKey formatTransformKeyData;
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

    public TriggerLinAdapter(Context context, BasePopupView basePopupView, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        this.triggerViewModel = triggerViewModel;
        this.popupView = basePopupView;
        this.context = context;
        this.serviceId = triggerParam.getServiceId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TriggerLinHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterTriggerLinBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSamplePointsValue, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLinIdValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLinBytelengthValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSourceLinValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLinBaudValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerErrTypeValue, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.TriggerLinAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                TriggerLinAdapter.this.aorBManager.showKey(TriggerLinAdapter.this.context, ((AorBParam) TriggerLinAdapter.this.list_aorbParam.get(i2)).getEditText() != null ? ((AorBParam) TriggerLinAdapter.this.list_aorbParam.get(i2)).getEditText() : ((AorBParam) TriggerLinAdapter.this.list_aorbParam.get(i2)).getTextView() != null ? ((AorBParam) TriggerLinAdapter.this.list_aorbParam.get(i2)).getTextView() : null, true, ((AorBParam) TriggerLinAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                TriggerLinAdapter.this.aorBManager.showKey(TriggerLinAdapter.this.context, ((AorBParam) TriggerLinAdapter.this.list_aorbParam.get(i2)).getEditText() != null ? ((AorBParam) TriggerLinAdapter.this.list_aorbParam.get(i2)).getEditText() : ((AorBParam) TriggerLinAdapter.this.list_aorbParam.get(i2)).getTextView() != null ? ((AorBParam) TriggerLinAdapter.this.list_aorbParam.get(i2)).getTextView() : null, false, ((AorBParam) TriggerLinAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.triggerLevelValue, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.triggerSamplePointsValue, true, ViewUtil.KEY_B);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerLinAdapter$P7cA5D_qO0ySR_ayad1ywqEq-WU
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TriggerLinAdapter.this.lambda$onCreateViewHolder$2$TriggerLinAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new TriggerLinHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$TriggerLinAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (this.popviewTriggerBinding.triggerView.getAdapter() instanceof TriggerLinAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerLinAdapter$ponWVy-YEy_pKguL2j6lHigqHes
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerLinAdapter.this.lambda$onCreateViewHolder$0$TriggerLinAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerLinAdapter$QzIkxYpUC5xRWmIC-Q2tR_ZXEK8
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    TriggerLinAdapter.this.lambda$onCreateViewHolder$1$TriggerLinAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$TriggerLinAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$TriggerLinAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.trigger_source_lin_value) {
            selectLinSource(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_lin_baud_value) {
            selectLinBaud(mappingObject, this.clickedView);
        } else if (this.clickedView.getId() == R.id.trigger_err_type_value) {
            selectLinErrorType(mappingObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TriggerLinHolder triggerLinHolder, int i) {
        this.triggerViewModel.getLiveData().observe((LifecycleOwner) this.context, new Observer<TriggerParam>() { // from class: com.rigol.scope.adapters.TriggerLinAdapter.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            public void onChanged(TriggerParam triggerParam) {
                TriggerLinAdapter.this.param = triggerParam;
            }
        });
        ShowTriggerLin();
        triggerLinHolder.binding.executePendingBindings();
    }

    public void ShowTriggerLin() {
        ServiceEnum.Chan chan = this.param.getChan();
        if (chan == ServiceEnum.Chan.acline || chan == ServiceEnum.Chan.ext) {
            this.param.setChannel(ServiceEnum.Chan.chan1.value1);
            this.param.saveLinSource(ServiceEnum.Chan.chan1.value1);
        } else {
            this.param.setChan(ServiceEnum.getChanFromValue1(chan.value1));
        }
        this.param.setChanColor(this.binding.triggerSourceLinValue, chan);
        this.param.readLinVersion();
        this.param.readLinBaud();
        this.param.readLinSamplePosition();
        this.param.readLinErrType();
        this.param.readLinWhen();
        this.binding.setVersion1Mapping(ViewUtil.getMappingObject(R.array.msg_trigger_lin_version, 0));
        this.binding.setVersion2Mapping(ViewUtil.getMappingObject(R.array.msg_trigger_lin_version, 1));
        this.binding.setVersionBothMapping(ViewUtil.getMappingObject(R.array.msg_trigger_lin_version, 2));
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        this.binding.setWhenSyncMapping(ViewUtil.getMappingObject(R.array.msg_trigger_lin_when, ServiceEnum.Trigger_Lin_When.trig_lin_sync.value1));
        this.binding.setWhenIdMapping(ViewUtil.getMappingObject(R.array.msg_trigger_lin_when, ServiceEnum.Trigger_Lin_When.trig_lin_id.value1));
        this.binding.setWhenDataMapping(ViewUtil.getMappingObject(R.array.msg_trigger_lin_when, ServiceEnum.Trigger_Lin_When.trig_lin_data.value1));
        this.binding.setWhenDataIdMapping(ViewUtil.getMappingObject(R.array.msg_trigger_lin_when, ServiceEnum.Trigger_Lin_When.trig_lin_id_data.value1));
        this.binding.setWhenSleepMapping(ViewUtil.getMappingObject(R.array.msg_trigger_lin_when, ServiceEnum.Trigger_Lin_When.trig_lin_sleep.value1));
        this.binding.setWhenWakeUpMapping(ViewUtil.getMappingObject(R.array.msg_trigger_lin_when, ServiceEnum.Trigger_Lin_When.trig_lin_wakeup.value1));
        this.binding.setWhenErrorMapping(ViewUtil.getMappingObject(R.array.msg_trigger_lin_when, ServiceEnum.Trigger_Lin_When.trig_lin_err.value1));
        TriggerParam triggerParam = this.param;
        triggerParam.setFormatValue4Str(triggerParam.getFormatValue4Str());
        this.binding.setParam(this.param);
        ViewUtil.setSwitchButton(this.binding.triggerNoiseSwitch);
        this.binding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.triggerLinVersion1.setOnCheckedChangeListener(this);
        this.binding.triggerLinVersion2.setOnCheckedChangeListener(this);
        this.binding.triggerLinVersionBoth.setOnCheckedChangeListener(this);
        this.binding.triggerLinSync.setOnCheckedChangeListener(this);
        this.binding.triggerLinId.setOnCheckedChangeListener(this);
        this.binding.triggerLinData.setOnCheckedChangeListener(this);
        this.binding.triggerLinDataId.setOnCheckedChangeListener(this);
        this.binding.triggerLinSleep.setOnCheckedChangeListener(this);
        this.binding.triggerLinWakeup.setOnCheckedChangeListener(this);
        this.binding.triggerLinError.setOnCheckedChangeListener(this);
        this.binding.buttonLevel.setOnClickListener(this);
        this.binding.triggerSourceLinValue.setOnClickListener(this);
        this.binding.triggerLinBaudValue.setOnClickListener(this);
        this.binding.triggerErrTypeValue.setOnClickListener(this);
        this.binding.triggerLinBaudValue.setOnLongClickListener(this);
        this.binding.triggerLevelValue.setOnClickListener(this);
        this.binding.triggerSamplePointsValue.setOnClickListener(this);
        this.binding.triggerLinIdValue.setOnClickListener(this);
        this.binding.triggerLinDataValue.setOnClickListener(this);
        this.binding.triggerLinBytelengthValue.setOnClickListener(this);
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
                case R.id.trigger_lin_data /* 2131364292 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveLinWhen(z ? 2 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_lin_data_id /* 2131364293 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveLinWhen(z ? 3 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_lin_error /* 2131364296 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveLinWhen(z ? 6 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_lin_id /* 2131364297 */:
                    this.aorBManager.set_RadioButton();
                    TriggerParam triggerParam = this.param;
                    if (triggerParam != null) {
                        triggerParam.saveLinWhen(z ? 1 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_lin_sleep /* 2131364300 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveLinWhen(z ? 4 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_lin_sync /* 2131364301 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveLinWhen(0);
                        return;
                    }
                    return;
                case R.id.trigger_lin_version_1 /* 2131364302 */:
                    if (this.param != null) {
                        this.param.saveLinVersion(0);
                        return;
                    }
                    return;
                case R.id.trigger_lin_version_2 /* 2131364303 */:
                    TriggerParam triggerParam2 = this.param;
                    if (triggerParam2 != null) {
                        triggerParam2.saveLinVersion(z ? 1 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_lin_version_both /* 2131364304 */:
                    if (this.param != null) {
                        this.param.saveLinVersion(z ? 2 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_lin_wakeup /* 2131364305 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveLinWhen(z ? 5 : 0);
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

    private void selectLinSource(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveLinSource(mappingObject.getValue());
            this.param.setChannel(mappingObject.getValue());
        }
    }

    private void selectLinBaud(MappingObject mappingObject, View view) {
        if (this.param != null) {
            if (mappingObject.getValue() != 0) {
                this.param.saveLinBaud(mappingObject.getValue());
                return;
            }
            TriggerParam triggerParam = this.param;
            triggerParam.setLinBaud(triggerParam.getLinBaud());
            ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_decimal, this.param.getLinBaudRateAttr().getMaxIntValue(), this.param.getLinBaudRateAttr().getMinIntValue(), this.param.getLinBaudRateAttr().getDefIntValue(), this.param.getLinBaud(), UnitFormat.SI.NONE, new UnitFormat.SI[]{UnitFormat.SI.MEGA, UnitFormat.SI.KILO}, "0.###", new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerLinAdapter.3
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    TriggerLinAdapter.this.param.saveLinBaud(((Long) t).intValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerLinAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    private void selectLinErrorType(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveLinErrorType(mappingObject.getValue());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
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
            case R.id.normal_radio_button /* 2131363483 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1);
                break;
            case R.id.single_radio_button /* 2131363859 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1);
                break;
            case R.id.trigger_err_type_value /* 2131364210 */:
                if (this.popupView != null) {
                    final List<MappingObject> list = ViewUtil.getList((int) R.array.msg_trigger_lin_err_type);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerLinAdapter$WvSMiFVHXU-6YuiMRuQ0Ut_7HFI
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                            TriggerLinAdapter.this.lambda$onClick$7$TriggerLinAdapter(popupSpinner, spinnerAdapter, list2, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerLinAdapter$Q8PMExAunssrcemtgaS9ten0Tck
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerLinAdapter.this.lambda$onClick$8$TriggerLinAdapter(list, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_level_value /* 2131364280 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readLevelAttr();
                    TriggerParam triggerParam = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam.getChanUnit(triggerParam.getChannel()), this.param.getLevelAttr().getMaxLongValue(), this.param.getLevelAttr().getMinLongValue(), this.param.getLevelAttr().getDefLongValue(), this.param.getLevel(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerLinAdapter.7
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerLinAdapter.this.param.saveLevelSync(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerLinAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_lin_baud_value /* 2131364289 */:
                if (this.popupView != null) {
                    final List<MappingObject> list2 = ViewUtil.getList((int) R.array.msg_trigger_lin_baud);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list2, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerLinAdapter$WDBokeIDplJFFZeYfOs89Xiaaik
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list3, View view2) {
                            TriggerLinAdapter.this.lambda$onClick$5$TriggerLinAdapter(popupSpinner, spinnerAdapter, list3, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerLinAdapter$sDiL5pSxIHgATGOltOF05UcU9Z4
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerLinAdapter.this.lambda$onClick$6$TriggerLinAdapter(list2, view, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_lin_bytelength_value /* 2131364291 */:
                if (this.aorBManager.setClick_showab_textview(id) && (this.context instanceof Activity)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_number, this.param.getLinByteAttr().getMaxIntValue(), this.param.getLinByteAttr().getMinIntValue(), this.param.getLinByteAttr().getDefIntValue(), this.param.getLinByte(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerLinAdapter.5
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerLinAdapter.this.param.saveLinByte(((Long) t).intValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerLinAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_lin_data_value /* 2131364295 */:
                if (this.context instanceof Activity) {
                    TriggerParam triggerParam2 = this.param;
                    triggerParam2.setKeyNumMax(triggerParam2.getLinByte() * 8);
                    if (this.formatTransformKeyData == null) {
                        FormatTransformKey formatTransformKey = new FormatTransformKey(this.context, this.popupView.getAnchor(), this.param);
                        this.formatTransformKeyData = formatTransformKey;
                        formatTransformKey.attachRefView(this.binding.triggerLinDataValue);
                        this.formatTransformKeyData.getFormatTransformValue(new FormatTransformKey.FormatTransformInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerLinAdapter$XwV0ZO9TiOV4-JBtVcr5PGTtbGs
                            @Override // com.rigol.scope.views.FormatTransformKey.FormatTransformInterface
                            public final void FormatTransformListener(String str) {
                                TriggerLinAdapter.this.lambda$onClick$9$TriggerLinAdapter(str);
                            }
                        });
                    }
                    this.formatTransformKeyData.show();
                    this.formatTransformKeyData.init();
                    break;
                }
                break;
            case R.id.trigger_lin_id_value /* 2131364299 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readLinIdAttr();
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_number, this.param.getLinIdAttr().getMaxIntValue(), this.param.getLinIdAttr().getMinIntValue(), this.param.getLinIdAttr().getDefIntValue(), this.param.getLinId(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerLinAdapter.6
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerLinAdapter.this.param.saveLinId(((Long) t).intValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerLinAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_sample_points_value /* 2131364334 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_percent, this.param.getlinSamplePositonsAttr().getMaxIntValue(), this.param.getlinSamplePositonsAttr().getMinIntValue(), this.param.getlinSamplePositonsAttr().getDefIntValue(), this.param.getLinSamplePosition(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerLinAdapter.4
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerLinAdapter.this.param.saveLinSamplePoints(Math.toIntExact(((Long) t).longValue()));
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerLinAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source_lin_value /* 2131364360 */:
                if (this.popupView != null) {
                    final List<MappingObject> filterChan = ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_source_la));
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, filterChan, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerLinAdapter$Qal0QosBSrxQQvmPo21hEzCXTfI
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list3, View view2) {
                            TriggerLinAdapter.this.lambda$onClick$3$TriggerLinAdapter(popupSpinner, spinnerAdapter, list3, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerLinAdapter$dYQRCE1dNCacFvjonJchmTFy-xc
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerLinAdapter.this.lambda$onClick$4$TriggerLinAdapter(filterChan, view2, viewHolder, i, (MappingObject) obj);
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

    public /* synthetic */ void lambda$onClick$3$TriggerLinAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$TriggerLinAdapter(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectLinSource((MappingObject) list.get(i));
    }

    public /* synthetic */ void lambda$onClick$5$TriggerLinAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$TriggerLinAdapter(List list, View view, View view2, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectLinBaud((MappingObject) list.get(i), view);
    }

    public /* synthetic */ void lambda$onClick$7$TriggerLinAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$8$TriggerLinAdapter(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectLinErrorType((MappingObject) list.get(i));
    }

    public /* synthetic */ void lambda$onClick$9$TriggerLinAdapter(String str) {
        this.param.setFormatValue4Str(str);
        if (str.contains("[bin]")) {
            this.param.setLinDataType(0);
        } else {
            this.param.setLinDataType(1);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == R.id.trigger_lin_baud_value) {
            ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_decimal, this.param.getLinBaudRateAttr().getMaxIntValue(), this.param.getLinBaudRateAttr().getMinIntValue(), this.param.getLinBaudRateAttr().getDefIntValue(), this.param.getLinBaud(), UnitFormat.SI.NONE, new UnitFormat.SI[]{UnitFormat.SI.MEGA, UnitFormat.SI.KILO}, "0.###", new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerLinAdapter.8
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    TriggerLinAdapter.this.param.saveLinBaud(((Long) t).intValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerLinAdapter.this.keyboardPopupView = keyboardPopupView;
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
        switch (i) {
            case R.id.trigger_level_value /* 2131364280 */:
                TriggerParam triggerParam = this.param;
                triggerParam.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam);
                return;
            case R.id.trigger_lin_bytelength_value /* 2131364291 */:
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveLinByte(Math.toIntExact(triggerParam2.getLongStep(triggerParam2.getLinByte(), this.param.getLinByteAttr(), z, keyEvent)));
                return;
            case R.id.trigger_lin_id_value /* 2131364299 */:
                TriggerParam triggerParam3 = this.param;
                triggerParam3.saveLinId(Math.toIntExact(triggerParam3.getLongStep(triggerParam3.getLinId(), this.param.getLinIdAttr(), z, keyEvent)));
                return;
            case R.id.trigger_sample_points_value /* 2131364334 */:
                TriggerParam triggerParam4 = this.param;
                triggerParam4.saveLinSamplePoints(Math.toIntExact(triggerParam4.getLongStep(triggerParam4.getLinSamplePosition(), this.param.getlinSamplePositonsAttr(), z, keyEvent)));
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
            case R.id.trigger_level_value /* 2131364280 */:
                TriggerParam triggerParam = this.param;
                triggerParam.saveLevelSync(triggerParam.getLongDef(triggerParam.getLevelAttr()));
                return;
            case R.id.trigger_lin_bytelength_value /* 2131364291 */:
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveLinByte(Math.toIntExact(triggerParam2.getLongDef(triggerParam2.getLinByteAttr())));
                return;
            case R.id.trigger_lin_id_value /* 2131364299 */:
                TriggerParam triggerParam3 = this.param;
                triggerParam3.saveLinId(Math.toIntExact(triggerParam3.getLongDef(triggerParam3.getLinIdAttr())));
                return;
            case R.id.trigger_sample_points_value /* 2131364334 */:
                TriggerParam triggerParam4 = this.param;
                triggerParam4.saveLinSamplePoints(Math.toIntExact(triggerParam4.getLongDef(triggerParam4.getlinSamplePositonsAttr())));
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public class TriggerLinHolder extends RecyclerView.ViewHolder {
        private AdapterTriggerLinBinding binding;

        public TriggerLinHolder(AdapterTriggerLinBinding adapterTriggerLinBinding) {
            super(adapterTriggerLinBinding.getRoot());
            this.binding = adapterTriggerLinBinding;
        }
    }
}
