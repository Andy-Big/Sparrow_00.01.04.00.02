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
import com.rigol.scope.databinding.AdapterTriggerI2sBinding;
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
public class TriggerI2sAdapter extends RecyclerView.Adapter<TriggerI2sHolder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterTriggerI2sBinding binding;
    private View clickedView;
    private Context context;
    private FormatTransformKey formatTransformKey;
    private FormatTransformKey formatTransformKeyLow;
    private FormatTransformKey formatTransformKeyUp;
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

    public TriggerI2sAdapter(Context context, BasePopupView basePopupView, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        this.triggerViewModel = triggerViewModel;
        this.popupView = basePopupView;
        this.context = context;
        this.serviceId = triggerParam.getServiceId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TriggerI2sHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterTriggerI2sBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelbValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelcValue, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerIisAllwidthValue, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerIisWidthValue, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerI2sDataLowValue, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerI2sDataUpValue, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSourceScl, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSourceWs, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSourceSda, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSourceSclkEdgeValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerAudioValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerIisAlignmentValue, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.TriggerI2sAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                TriggerI2sAdapter.this.aorBManager.showKey(TriggerI2sAdapter.this.context, ((AorBParam) TriggerI2sAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) TriggerI2sAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                TriggerI2sAdapter.this.aorBManager.showKey(TriggerI2sAdapter.this.context, ((AorBParam) TriggerI2sAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) TriggerI2sAdapter.this.list_aorbParam.get(i2)).getAorb());
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
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2sAdapter$wluRM5MooVaB6r3A7zYZuK96PuA
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TriggerI2sAdapter.this.lambda$onCreateViewHolder$2$TriggerI2sAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new TriggerI2sHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$TriggerI2sAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (this.popviewTriggerBinding.triggerView.getAdapter() instanceof TriggerI2sAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2sAdapter$UalpMyTDqt-3JMhI35cpwn2nR2I
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerI2sAdapter.this.lambda$onCreateViewHolder$0$TriggerI2sAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2sAdapter$13QjjyUtNmrEUUj5D1DRe7tiVZw
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    TriggerI2sAdapter.this.lambda$onCreateViewHolder$1$TriggerI2sAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$TriggerI2sAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$TriggerI2sAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.trigger_source_scl) {
            selectSourceScl(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_source_ws) {
            selectSourceWs(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_source_sda) {
            selectSourceSda(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_source_sclk_edge_value) {
            selectSourceSclkEdge(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_audio_value) {
            selectAudio(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_iis_alignment_value) {
            selectAlignment(mappingObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TriggerI2sHolder triggerI2sHolder, int i) {
        this.triggerViewModel.getLiveData().observe((LifecycleOwner) this.context, new Observer<TriggerParam>() { // from class: com.rigol.scope.adapters.TriggerI2sAdapter.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            public void onChanged(TriggerParam triggerParam) {
                TriggerI2sAdapter.this.param = triggerParam;
            }
        });
        ShowTriggerI2s();
        triggerI2sHolder.binding.executePendingBindings();
    }

    public void ShowTriggerI2s() {
        ServiceEnum.Chan chan = this.param.getChan();
        if (chan == ServiceEnum.Chan.acline || chan == ServiceEnum.Chan.ext) {
            int i = ServiceEnum.Chan.chan1.value1;
            this.param.setChannel(i);
            this.param.saveSourceScl(i);
        } else {
            int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_IIS_SCLK);
            ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(UI_QueryInt32);
            this.param.setChannel(UI_QueryInt32);
            this.param.setIisChanA(chanFromValue1);
        }
        int UI_QueryInt322 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_IIS_WS);
        ServiceEnum.Chan chanFromValue12 = ServiceEnum.getChanFromValue1(UI_QueryInt322);
        this.param.setChannelB(UI_QueryInt322);
        this.param.setIisChanB(chanFromValue12);
        this.param.setChanColor(this.binding.triggerSourceWs, chanFromValue12);
        int UI_QueryInt323 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_IIS_SDA);
        ServiceEnum.Chan chanFromValue13 = ServiceEnum.getChanFromValue1(UI_QueryInt323);
        this.param.setChannelC(UI_QueryInt323);
        this.param.setIisChanC(chanFromValue13);
        this.param.setChanColor(this.binding.triggerSourceSda, chanFromValue13);
        this.param.readclkEdge();
        this.param.readAudio();
        this.param.readiisWhen();
        this.param.readwidth();
        this.param.readallWidth();
        this.param.readAlignment();
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        TriggerParam triggerParam = this.param;
        triggerParam.setFormatValue5Str(triggerParam.getFormatValue5Str());
        TriggerParam triggerParam2 = this.param;
        triggerParam2.setFormatValue5MaxStr(triggerParam2.getFormatValue5MaxStr());
        TriggerParam triggerParam3 = this.param;
        triggerParam3.setFormatValue5MinStr(triggerParam3.getFormatValue5MinStr());
        this.binding.setParam(this.param);
        ViewUtil.setSwitchButton(this.binding.triggerNoiseSwitch);
        this.binding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.triggerIisEq.setOnCheckedChangeListener(this);
        this.binding.triggerIisNeq.setOnCheckedChangeListener(this);
        this.binding.triggerIisMorethan.setOnCheckedChangeListener(this);
        this.binding.triggerIisLessthan.setOnCheckedChangeListener(this);
        this.binding.triggerIisMoreless.setOnCheckedChangeListener(this);
        this.binding.triggerIisUnmoreless.setOnCheckedChangeListener(this);
        this.binding.buttonLevel.setOnClickListener(this);
        this.binding.buttonLevelb.setOnClickListener(this);
        this.binding.buttonLevelc.setOnClickListener(this);
        this.binding.triggerSourceScl.setOnClickListener(this);
        this.binding.triggerSourceWs.setOnClickListener(this);
        this.binding.triggerSourceSda.setOnClickListener(this);
        this.binding.triggerSourceSclkEdgeValue.setOnClickListener(this);
        this.binding.triggerAudioValue.setOnClickListener(this);
        this.binding.triggerIisAlignmentValue.setOnClickListener(this);
        this.binding.triggerLevelValue.setOnClickListener(this);
        this.binding.triggerLevelbValue.setOnClickListener(this);
        this.binding.triggerLevelcValue.setOnClickListener(this);
        this.binding.triggerIisWidthValue.setOnClickListener(this);
        this.binding.triggerIisAllwidthValue.setOnClickListener(this);
        this.binding.triggerI2sDataUpValue.setOnClickListener(this);
        this.binding.triggerI2sDataLowValue.setOnClickListener(this);
        this.binding.triggerI2sDataValue.setOnClickListener(this);
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
                case R.id.trigger_noise_switch /* 2131364309 */:
                    if (this.param != null) {
                        API.getInstance().UI_PostBool(this.serviceId, MessageID.MSG_TRIGGER_NOISE, z);
                        this.param.setIsNoise(z);
                        return;
                    }
                    return;
                default:
                    switch (id) {
                        case R.id.trigger_iis_eq /* 2131364258 */:
                            if (this.param != null) {
                                this.param.saveIisWhen(0);
                                return;
                            }
                            return;
                        case R.id.trigger_iis_lessthan /* 2131364259 */:
                            if (this.param != null) {
                                this.param.saveIisWhen(z ? 3 : 0);
                                return;
                            }
                            return;
                        case R.id.trigger_iis_moreless /* 2131364260 */:
                            if (this.param != null) {
                                this.param.saveIisWhen(z ? 5 : 0);
                                return;
                            }
                            return;
                        case R.id.trigger_iis_morethan /* 2131364261 */:
                            if (this.param != null) {
                                this.param.saveIisWhen(z ? 2 : 0);
                                return;
                            }
                            return;
                        case R.id.trigger_iis_neq /* 2131364262 */:
                            TriggerParam triggerParam = this.param;
                            if (triggerParam != null) {
                                triggerParam.saveIisWhen(z ? 1 : 0);
                                return;
                            }
                            return;
                        case R.id.trigger_iis_unmoreless /* 2131364263 */:
                            if (this.param != null) {
                                this.param.saveIisWhen(z ? 4 : 0);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
            }
        }
    }

    private void selectSourceScl(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveSourceScl(mappingObject.getValue());
            this.param.setChannel(mappingObject.getValue());
        }
    }

    private void selectSourceWs(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveSourceWs(mappingObject.getValue());
            this.param.setChannelB(mappingObject.getValue());
        }
    }

    private void selectSourceSda(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveSourceSda(mappingObject.getValue());
            this.param.setChannelC(mappingObject.getValue());
        }
    }

    private void selectSourceSclkEdge(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveI2sEdgeValue(mappingObject.getValue());
        }
    }

    private void selectAudio(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveI2sAudioValue(mappingObject.getValue());
        }
    }

    private void selectAlignment(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveI2sAlignmentValue(mappingObject.getValue());
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
                    triggerParam.setChan(triggerParam.getIisChanA());
                    API.getInstance().UI_PostInt32(this.serviceId, MessageID.MSG_TRIGGER_IIS_SCLK, this.param.getIisChanA().value1);
                    this.param.saveButtonLevel();
                    break;
                }
                break;
            case R.id.button_levelb /* 2131362195 */:
                if (this.context instanceof Activity) {
                    TriggerParam triggerParam2 = this.param;
                    triggerParam2.setChan(triggerParam2.getIisChanB());
                    API.getInstance().UI_PostInt32(this.serviceId, MessageID.MSG_TRIGGER_IIS_WS, this.param.getIisChanB().value1);
                    this.param.saveButtonLevel();
                    break;
                }
                break;
            case R.id.button_levelc /* 2131362196 */:
                if (this.context instanceof Activity) {
                    TriggerParam triggerParam3 = this.param;
                    triggerParam3.setChan(triggerParam3.getIisChanC());
                    API.getInstance().UI_PostInt32(this.serviceId, MessageID.MSG_TRIGGER_IIS_SDA, this.param.getIisChanC().value1);
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
            case R.id.trigger_audio_value /* 2131364167 */:
                if (this.popupView != null) {
                    final List<MappingObject> list = ViewUtil.getList((int) R.array.msg_trigger_iis_ws_low);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2sAdapter$OEsLu1QNH45BF2l_2VuAw-NkG7o
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                            TriggerI2sAdapter.this.lambda$onClick$11$TriggerI2sAdapter(popupSpinner, spinnerAdapter, list2, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2sAdapter$rpd4td99BBJwffqHQFv_5e1Sv4w
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerI2sAdapter.this.lambda$onClick$12$TriggerI2sAdapter(list, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_i2s_data_low_value /* 2131364250 */:
                if (this.context instanceof Activity) {
                    this.param.setKeyNumMax(this.param.getWidth());
                    this.param.setI2sDataType(1);
                    if (this.formatTransformKeyLow == null) {
                        FormatTransformKey formatTransformKey = new FormatTransformKey(this.context, this.popupView.getAnchor(), this.param);
                        this.formatTransformKeyLow = formatTransformKey;
                        formatTransformKey.attachRefView(this.binding.triggerI2sDataValue);
                        this.formatTransformKeyLow.getFormatTransformValue(new FormatTransformKey.FormatTransformInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2sAdapter$UHsaLQ842vmFFaHGq94GqnUFPCA
                            @Override // com.rigol.scope.views.FormatTransformKey.FormatTransformInterface
                            public final void FormatTransformListener(String str) {
                                TriggerI2sAdapter.this.lambda$onClick$16$TriggerI2sAdapter(str);
                            }
                        });
                    }
                    this.formatTransformKeyLow.show();
                    this.formatTransformKeyLow.init();
                    break;
                }
                break;
            case R.id.trigger_i2s_data_up_value /* 2131364252 */:
                if (this.context instanceof Activity) {
                    this.param.setKeyNumMax(this.param.getWidth());
                    this.param.setI2sDataType(2);
                    if (this.formatTransformKeyUp == null) {
                        FormatTransformKey formatTransformKey2 = new FormatTransformKey(this.context, this.popupView.getAnchor(), this.param);
                        this.formatTransformKeyUp = formatTransformKey2;
                        formatTransformKey2.attachRefView(this.binding.triggerI2sDataValue);
                        this.formatTransformKeyUp.getFormatTransformValue(new FormatTransformKey.FormatTransformInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2sAdapter$9tWnFvskeM0QWd_44g89pTnaKKg
                            @Override // com.rigol.scope.views.FormatTransformKey.FormatTransformInterface
                            public final void FormatTransformListener(String str) {
                                TriggerI2sAdapter.this.lambda$onClick$17$TriggerI2sAdapter(str);
                            }
                        });
                    }
                    this.formatTransformKeyUp.show();
                    this.formatTransformKeyUp.init();
                    break;
                }
                break;
            case R.id.trigger_i2s_data_value /* 2131364253 */:
                if (this.context instanceof Activity) {
                    this.param.setKeyNumMax(this.param.getWidth());
                    this.param.setI2sDataType(0);
                    if (this.formatTransformKey == null) {
                        FormatTransformKey formatTransformKey3 = new FormatTransformKey(this.context, this.popupView.getAnchor(), this.param);
                        this.formatTransformKey = formatTransformKey3;
                        formatTransformKey3.attachRefView(this.binding.triggerI2sDataValue);
                        this.formatTransformKey.getFormatTransformValue(new FormatTransformKey.FormatTransformInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2sAdapter$e2SpbLVOW4jsDLsmwdMQhazzxcQ
                            @Override // com.rigol.scope.views.FormatTransformKey.FormatTransformInterface
                            public final void FormatTransformListener(String str) {
                                TriggerI2sAdapter.this.lambda$onClick$15$TriggerI2sAdapter(str);
                            }
                        });
                    }
                    this.formatTransformKey.show();
                    this.formatTransformKey.init();
                    break;
                }
                break;
            case R.id.trigger_iis_alignment_value /* 2131364255 */:
                if (this.popupView != null) {
                    final List<MappingObject> list2 = ViewUtil.getList((int) R.array.msg_trigger_iis_alignment);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list2, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2sAdapter$i1kxFdkOmkdBEToRv9TvwLFj2-M
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list3, View view2) {
                            TriggerI2sAdapter.this.lambda$onClick$13$TriggerI2sAdapter(popupSpinner, spinnerAdapter, list3, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2sAdapter$2PFCDgxjOxceMixwo-yzjgSZj08
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerI2sAdapter.this.lambda$onClick$14$TriggerI2sAdapter(list2, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_iis_allwidth_value /* 2131364257 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readallWidthAttr();
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_number, this.param.getAllWidthAttr().getMaxIntValue(), this.param.getAllWidthAttr().getMinIntValue(), this.param.getAllWidthAttr().getDefIntValue(), this.param.getAllWidth(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerI2sAdapter.4
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerI2sAdapter.this.param.saveI2sAllWidthValue(Math.toIntExact(((Long) t).longValue()));
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerI2sAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_iis_width_value /* 2131364265 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readwidthAttr();
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_number, this.param.getWidthAttr().getMaxIntValue(), this.param.getWidthAttr().getMinIntValue(), this.param.getWidthAttr().getDefIntValue(), this.param.getWidth(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerI2sAdapter.3
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerI2sAdapter.this.param.saveI2sWidthValue(Math.toIntExact(((Long) t).longValue()));
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerI2sAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_level_value /* 2131364280 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readiisLevelAttr();
                    TriggerParam triggerParam4 = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam4.getChanUnit(triggerParam4.getChannel()), this.param.getiisLevelAttr().getMaxLongValue(), this.param.getiisLevelAttr().getMinLongValue(), this.param.getiisLevelAttr().getDefLongValue(), this.param.getIislevelA(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerI2sAdapter.5
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerI2sAdapter.this.param.saveIisLevelA(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerI2sAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_levelb_value /* 2131364286 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readiisLevelBAttr();
                    TriggerParam triggerParam5 = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam5.getChanUnit(triggerParam5.getChannelB()), this.param.getiisLevelBAttr().getMaxLongValue(), this.param.getiisLevelBAttr().getMinLongValue(), this.param.getiisLevelBAttr().getDefLongValue(), this.param.getIislevelB(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerI2sAdapter.6
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerI2sAdapter.this.param.saveIisLevelB(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerI2sAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_levelc_value /* 2131364288 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readiisLevelCAttr();
                    TriggerParam triggerParam6 = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam6.getChanUnit(triggerParam6.getChannelC()), this.param.getiisLevelCAttr().getMaxLongValue(), this.param.getiisLevelCAttr().getMinLongValue(), this.param.getiisLevelCAttr().getDefLongValue(), this.param.getIislevelC(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerI2sAdapter.7
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerI2sAdapter.this.param.saveIisLevelC(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerI2sAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source_scl /* 2131364362 */:
                if (this.popupView != null) {
                    final List<MappingObject> filterChan = ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_iis_sclk));
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, filterChan, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2sAdapter$Y7HLrzJsu81ZpZc87XJcSWExW6Q
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list3, View view2) {
                            TriggerI2sAdapter.this.lambda$onClick$3$TriggerI2sAdapter(popupSpinner, spinnerAdapter, list3, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2sAdapter$UH4Q09tJj8aRyo0MtrfB-Ay_rh0
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerI2sAdapter.this.lambda$onClick$4$TriggerI2sAdapter(filterChan, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source_sclk_edge_value /* 2131364365 */:
                if (this.popupView != null) {
                    final List<MappingObject> list3 = ViewUtil.getList((int) R.array.msg_trigger_iis_slope);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list3, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2sAdapter$XlVH34a1Gvr09i2bafJ5dRm0ld4
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list4, View view2) {
                            TriggerI2sAdapter.this.lambda$onClick$9$TriggerI2sAdapter(popupSpinner, spinnerAdapter, list4, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2sAdapter$yHJnHGD6IDUxXwaSDgOP5rB5xvs
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerI2sAdapter.this.lambda$onClick$10$TriggerI2sAdapter(list3, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source_sda /* 2131364366 */:
                if (this.popupView != null) {
                    final List<MappingObject> filterChan2 = ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_iis_sda));
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, filterChan2, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2sAdapter$K72fIsFsmOqBueGP-eY73Uxm-qM
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list4, View view2) {
                            TriggerI2sAdapter.this.lambda$onClick$7$TriggerI2sAdapter(popupSpinner, spinnerAdapter, list4, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2sAdapter$-epWw7_fHoDrDyIeknLrZW9Njhk
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerI2sAdapter.this.lambda$onClick$8$TriggerI2sAdapter(filterChan2, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source_ws /* 2131364368 */:
                if (this.popupView != null) {
                    final List<MappingObject> filterChan3 = ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_iis_ws));
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, filterChan3, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2sAdapter$mBRCzCV3aXJV4HUUm1YyXwCTQHQ
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list4, View view2) {
                            TriggerI2sAdapter.this.lambda$onClick$5$TriggerI2sAdapter(popupSpinner, spinnerAdapter, list4, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerI2sAdapter$Hi_x2WpxOxvGOwTUBXezscfTmy4
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerI2sAdapter.this.lambda$onClick$6$TriggerI2sAdapter(filterChan3, view2, viewHolder, i, (MappingObject) obj);
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

    public /* synthetic */ void lambda$onClick$3$TriggerI2sAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$TriggerI2sAdapter(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceScl((MappingObject) list.get(i));
    }

    public /* synthetic */ void lambda$onClick$5$TriggerI2sAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$TriggerI2sAdapter(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceWs((MappingObject) list.get(i));
    }

    public /* synthetic */ void lambda$onClick$7$TriggerI2sAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$8$TriggerI2sAdapter(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceSda((MappingObject) list.get(i));
    }

    public /* synthetic */ void lambda$onClick$9$TriggerI2sAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$10$TriggerI2sAdapter(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceSclkEdge((MappingObject) list.get(i));
    }

    public /* synthetic */ void lambda$onClick$11$TriggerI2sAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$12$TriggerI2sAdapter(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectAudio((MappingObject) list.get(i));
    }

    public /* synthetic */ void lambda$onClick$13$TriggerI2sAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$14$TriggerI2sAdapter(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectAlignment((MappingObject) list.get(i));
    }

    public /* synthetic */ void lambda$onClick$15$TriggerI2sAdapter(String str) {
        this.param.setFormatValue5Str(str);
        this.param.setFormatValue5MinStr(str);
        if (str.contains("[bin]")) {
            this.param.setIisDataType(0);
            this.param.setIisMinDataType(0);
            return;
        }
        this.param.setIisDataType(1);
        this.param.setIisMinDataType(1);
    }

    public /* synthetic */ void lambda$onClick$16$TriggerI2sAdapter(String str) {
        this.param.setFormatValue5MinStr(str);
        this.param.setFormatValue5Str(str);
        if (str.contains("[bin]")) {
            this.param.setIisDataType(0);
            this.param.setIisMinDataType(0);
            return;
        }
        this.param.setIisDataType(1);
        this.param.setIisMinDataType(1);
    }

    public /* synthetic */ void lambda$onClick$17$TriggerI2sAdapter(String str) {
        this.param.setFormatValue5MaxStr(str);
        if (str.contains("[bin]")) {
            this.param.setIisMaxDataType(0);
        } else {
            this.param.setIisMaxDataType(1);
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        switch (i) {
            case R.id.trigger_iis_allwidth_value /* 2131364257 */:
                TriggerParam triggerParam = this.param;
                triggerParam.saveI2sAllWidthValue(Math.toIntExact(this.aorBManager.getLongStep(triggerParam.getAllWidth(), this.param.getAllWidthAttr(), z, keyEvent)));
                return;
            case R.id.trigger_iis_width_value /* 2131364265 */:
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveI2sWidthValue(Math.toIntExact(this.aorBManager.getLongStep(triggerParam2.getWidth(), this.param.getWidthAttr(), z, keyEvent)));
                return;
            case R.id.trigger_level_value /* 2131364280 */:
                TriggerParam triggerParam3 = this.param;
                triggerParam3.setChan(triggerParam3.getIisChanA());
                TriggerParam triggerParam4 = this.param;
                triggerParam4.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam4);
                return;
            case R.id.trigger_levelb_value /* 2131364286 */:
                TriggerParam triggerParam5 = this.param;
                triggerParam5.setChan(triggerParam5.getIisChanB());
                TriggerParam triggerParam6 = this.param;
                triggerParam6.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam6);
                return;
            case R.id.trigger_levelc_value /* 2131364288 */:
                TriggerParam triggerParam7 = this.param;
                triggerParam7.setChan(triggerParam7.getIisChanC());
                TriggerParam triggerParam8 = this.param;
                triggerParam8.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam8);
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
            case R.id.trigger_iis_allwidth_value /* 2131364257 */:
                TriggerParam triggerParam = this.param;
                triggerParam.saveI2sAllWidthValue(Math.toIntExact(this.aorBManager.getLongDef(triggerParam.getAllWidthAttr())));
                return;
            case R.id.trigger_iis_width_value /* 2131364265 */:
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveI2sWidthValue(Math.toIntExact(this.aorBManager.getLongDef(triggerParam2.getWidthAttr())));
                return;
            case R.id.trigger_level_value /* 2131364280 */:
                TriggerParam triggerParam3 = this.param;
                triggerParam3.saveIisLevelA(this.aorBManager.getLongDef(triggerParam3.getiisLevelAttr()));
                return;
            case R.id.trigger_levelb_value /* 2131364286 */:
                TriggerParam triggerParam4 = this.param;
                triggerParam4.saveIisLevelB(this.aorBManager.getLongDef(triggerParam4.getiisLevelBAttr()));
                return;
            case R.id.trigger_levelc_value /* 2131364288 */:
                TriggerParam triggerParam5 = this.param;
                triggerParam5.saveIisLevelC(this.aorBManager.getLongDef(triggerParam5.getiisLevelCAttr()));
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public class TriggerI2sHolder extends RecyclerView.ViewHolder {
        private AdapterTriggerI2sBinding binding;

        public TriggerI2sHolder(AdapterTriggerI2sBinding adapterTriggerI2sBinding) {
            super(adapterTriggerI2sBinding.getRoot());
            this.binding = adapterTriggerI2sBinding;
        }
    }
}
