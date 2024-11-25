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
import com.rigol.scope.databinding.AdapterTriggerFlexrayBinding;
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
public class TriggerFlexrayAdapter extends RecyclerView.Adapter<TriggerFlexrayHolder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterTriggerFlexrayBinding binding;
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
    private int dataMax = 10;
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

    public TriggerFlexrayAdapter(Context context, BasePopupView basePopupView, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        this.triggerViewModel = triggerViewModel;
        this.param = triggerParam;
        this.popupView = basePopupView;
        this.context = context;
        this.serviceId = triggerParam.getServiceId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TriggerFlexrayHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterTriggerFlexrayBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerDownLimitIdValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerUpLimitIdValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerUpLimitCycValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerDownLimitCycValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSource, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerBaudValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerFlexrayPostTypeValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerFlexrayFrameValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerFlexraySymbolValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerFlexrayErrorValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerFlexrayIdCompValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerFlexrayCycCompValue, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.TriggerFlexrayAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                TriggerFlexrayAdapter.this.aorBManager.showKey(TriggerFlexrayAdapter.this.context, ((AorBParam) TriggerFlexrayAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) TriggerFlexrayAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                TriggerFlexrayAdapter.this.aorBManager.showKey(TriggerFlexrayAdapter.this.context, ((AorBParam) TriggerFlexrayAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) TriggerFlexrayAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.triggerLevelValue, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.triggerDownLimitIdValue, true, ViewUtil.KEY_B);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerFlexrayAdapter$XhHUGq7VkHNSb1mYh395Ew3znS0
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TriggerFlexrayAdapter.this.lambda$onCreateViewHolder$2$TriggerFlexrayAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new TriggerFlexrayHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$TriggerFlexrayAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (this.popviewTriggerBinding.triggerView.getAdapter() instanceof TriggerFlexrayAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerFlexrayAdapter$-NIBm0KUxVWpVMuqHUrtLCZUNAg
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerFlexrayAdapter.this.lambda$onCreateViewHolder$0$TriggerFlexrayAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerFlexrayAdapter$2rq5ZjYK6ubIUVp4XSRl7BncPdA
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    TriggerFlexrayAdapter.this.lambda$onCreateViewHolder$1$TriggerFlexrayAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$TriggerFlexrayAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$TriggerFlexrayAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.trigger_source) {
            selectSource(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_baud_value) {
            selectBaudValue(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_flexray_post_type_value) {
            selectPostTypeValue(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_flexray_frame_value) {
            selectFrameValue(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_flexray_symbol_value) {
            selectSymbolValue(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_flexray_error_value) {
            selectErrorValue(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_flexray_id_comp_value) {
            selectIdCompValue(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_flexray_cyc_comp_value) {
            selectCycCompValue(mappingObject);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TriggerFlexrayHolder triggerFlexrayHolder, int i) {
        ShowTriggerFlexray();
        triggerFlexrayHolder.binding.executePendingBindings();
    }

    public void ShowTriggerFlexray() {
        ServiceEnum.Chan chan = this.param.getChan();
        if (chan == ServiceEnum.Chan.acline || chan == ServiceEnum.Chan.ext) {
            int i = ServiceEnum.Chan.chan1.value1;
            this.param.setChannel(i);
            this.param.saveFlexraySource(i);
        } else {
            this.param.setChan(ServiceEnum.getChanFromValue1(chan.value1));
        }
        this.param.setChanColor(this.binding.triggerSource, chan);
        this.param.readFlexRayBaud();
        this.param.readFlexRayCH();
        this.param.readFlexRayIDcomp();
        this.param.readFlexRayCYCcomp();
        this.param.readFlexRayFrame();
        this.param.readFlexRayWhen();
        this.param.readFlexRayPost();
        this.param.readFlexRayFrame();
        this.param.readFlexRaySymbol();
        this.param.readFlexRayError();
        this.binding.setChanceAMapping(ViewUtil.getMappingObject(R.array.msg_trigger_flexray_ch_a_b, 0));
        this.binding.setChanceBMapping(ViewUtil.getMappingObject(R.array.msg_trigger_flexray_ch_a_b, 1));
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        this.binding.setWhenPostMapping(ViewUtil.getMappingObject(R.array.msg_trigger_flexray_when, ServiceEnum.Trigger_Flex_When.trig_flex_pos.value1));
        this.binding.setWhenFrameMapping(ViewUtil.getMappingObject(R.array.msg_trigger_flexray_when, ServiceEnum.Trigger_Flex_When.trig_flex_frame.value1));
        this.binding.setWhenSymbolMapping(ViewUtil.getMappingObject(R.array.msg_trigger_flexray_when, ServiceEnum.Trigger_Flex_When.trig_flex_symbol.value1));
        this.binding.setWhenErrorMapping(ViewUtil.getMappingObject(R.array.msg_trigger_flexray_when, ServiceEnum.Trigger_Flex_When.trig_flex_err.value1));
        this.binding.setDefineCycMapping(ViewUtil.getMappingObject(R.array.msg_trigger_flexray_define, ServiceEnum.Trigger_Flex_When.trig_flex_frame.value1));
        this.binding.setParam(this.param);
        ViewUtil.setSwitchButton(this.binding.triggerNoiseSwitch);
        this.binding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.triggerChanceAValue.setOnCheckedChangeListener(this);
        this.binding.triggerChanceBValue.setOnCheckedChangeListener(this);
        this.binding.triggerFlexrayPost.setOnCheckedChangeListener(this);
        this.binding.triggerFlexrayFrame.setOnCheckedChangeListener(this);
        this.binding.triggerFlexraySymbol.setOnCheckedChangeListener(this);
        this.binding.triggerFlexrayError.setOnCheckedChangeListener(this);
        this.binding.triggerFlexrayDefineId.setOnCheckedChangeListener(this);
        this.binding.triggerFlexrayDefineCyc.setOnCheckedChangeListener(this);
        this.binding.buttonLevel.setOnClickListener(this);
        this.binding.triggerSource.setOnClickListener(this);
        this.binding.triggerBaudValue.setOnClickListener(this);
        this.binding.triggerFlexrayPostTypeValue.setOnClickListener(this);
        this.binding.triggerFlexrayFrameValue.setOnClickListener(this);
        this.binding.triggerFlexraySymbolValue.setOnClickListener(this);
        this.binding.triggerFlexrayErrorValue.setOnClickListener(this);
        this.binding.triggerFlexrayIdCompValue.setOnClickListener(this);
        this.binding.triggerFlexrayCycCompValue.setOnClickListener(this);
        this.binding.triggerLevelValue.setOnClickListener(this);
        this.binding.triggerUpLimitIdValue.setOnClickListener(this);
        this.binding.triggerDownLimitIdValue.setOnClickListener(this);
        this.binding.triggerUpLimitCycValue.setOnClickListener(this);
        this.binding.triggerDownLimitCycValue.setOnClickListener(this);
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
                case R.id.trigger_chance_a_value /* 2131364184 */:
                    TriggerParam triggerParam = this.param;
                    if (triggerParam != null) {
                        triggerParam.saveFlexrayChanceValue(false);
                        return;
                    }
                    return;
                case R.id.trigger_chance_b_value /* 2131364185 */:
                    TriggerParam triggerParam2 = this.param;
                    if (triggerParam2 != null) {
                        triggerParam2.saveFlexrayChanceValue(true);
                        return;
                    }
                    return;
                case R.id.trigger_flexray_define_cyc /* 2131364214 */:
                    TriggerParam triggerParam3 = this.param;
                    if (triggerParam3 != null) {
                        triggerParam3.saveFlexrayDefine(true);
                        return;
                    }
                    return;
                case R.id.trigger_flexray_define_id /* 2131364215 */:
                    TriggerParam triggerParam4 = this.param;
                    if (triggerParam4 != null) {
                        triggerParam4.saveFlexrayDefine(false);
                        return;
                    }
                    return;
                case R.id.trigger_flexray_error /* 2131364217 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveFlexrayWhen(z ? 3 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_flexray_frame /* 2131364220 */:
                    this.aorBManager.set_RadioButton();
                    TriggerParam triggerParam5 = this.param;
                    if (triggerParam5 != null) {
                        triggerParam5.saveFlexrayWhen(z ? 1 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_flexray_post /* 2131364225 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveFlexrayWhen(0);
                        return;
                    }
                    return;
                case R.id.trigger_flexray_symbol /* 2131364228 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveFlexrayWhen(z ? 2 : 0);
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
            case R.id.trigger_baud_value /* 2131364169 */:
                if (this.popupView != null) {
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_trigger_flexray_baud), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerFlexrayAdapter$_jYYzE8Ko9y4RYGMaaJRicWZIlI
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerFlexrayAdapter.this.lambda$onClick$5$TriggerFlexrayAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerFlexrayAdapter$qxGAGlwKLNPriqRgT1GxeDFVD1A
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerFlexrayAdapter.this.lambda$onClick$6$TriggerFlexrayAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_down_limit_cyc_value /* 2131364197 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readcompareLowerLimitAttr();
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_number, this.param.getcompareLowerLimitAttr().getMaxIntValue(), this.param.getcompareLowerLimitAttr().getMinIntValue(), this.param.getcompareLowerLimitAttr().getDefIntValue(), this.param.getCompareLowerLimit(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerFlexrayAdapter.3
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerFlexrayAdapter.this.param.saveFlexrayDownCycValue(Math.toIntExact(((Long) t).longValue()));
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerFlexrayAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_down_limit_id_value /* 2131364199 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readidLowerLimitAttr();
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_number, this.param.getidLowerLimitAttr().getMaxIntValue(), this.param.getidLowerLimitAttr().getMinIntValue(), this.param.getidLowerLimitAttr().getDefIntValue(), this.param.getIdLowerLimit(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerFlexrayAdapter.5
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerFlexrayAdapter.this.param.saveFlexrayDownIdValue(Math.toIntExact(((Long) t).longValue()));
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerFlexrayAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_flexray_cyc_comp_value /* 2131364213 */:
                if (this.popupView != null) {
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_trigger_iis_when), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerFlexrayAdapter$ZCkC9PP2gObvsMhEgMKD22QsaGA
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerFlexrayAdapter.this.lambda$onClick$17$TriggerFlexrayAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerFlexrayAdapter$6ftlDgro2hqbIpt8FSx4m3MmD9I
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerFlexrayAdapter.this.lambda$onClick$18$TriggerFlexrayAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_flexray_error_value /* 2131364219 */:
                if (this.popupView != null) {
                    List<MappingObject> list = ViewUtil.getList((int) R.array.msg_trigger_flexray_error_type);
                    this.clickedView = view;
                    this.mappingObjects = list;
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerFlexrayAdapter$W2kQjFjYG6i0ffkMuk1EjU8VvZk
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                            TriggerFlexrayAdapter.this.lambda$onClick$13$TriggerFlexrayAdapter(popupSpinner, spinnerAdapter, list2, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerFlexrayAdapter$dZWEmCD8PfN_d59jcAlCyLAXfm4
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerFlexrayAdapter.this.lambda$onClick$14$TriggerFlexrayAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_flexray_frame_value /* 2131364222 */:
                if (this.popupView != null) {
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_trigger_flexray_frame_type), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerFlexrayAdapter$BjG_rkk_9fWE0IHC-kvnqf_wkl4
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                            TriggerFlexrayAdapter.this.lambda$onClick$9$TriggerFlexrayAdapter(popupSpinner, spinnerAdapter, list2, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerFlexrayAdapter$jHGx6EpW6z3yRUuU6qRPokgQ8Gc
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerFlexrayAdapter.this.lambda$onClick$10$TriggerFlexrayAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_flexray_id_comp_value /* 2131364224 */:
                if (this.popupView != null) {
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_trigger_iis_when), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerFlexrayAdapter$hd2jmYKY7xYWqG3X8-5Pf_de0pw
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                            TriggerFlexrayAdapter.this.lambda$onClick$15$TriggerFlexrayAdapter(popupSpinner, spinnerAdapter, list2, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerFlexrayAdapter$gIsEjJVvjJaA9Edquk_mrZd6K-g
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerFlexrayAdapter.this.lambda$onClick$16$TriggerFlexrayAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_flexray_post_type_value /* 2131364227 */:
                if (this.popupView != null) {
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_trigger_flexray_post_type), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerFlexrayAdapter$slE0ARKUBdm3zBhyJcTpOw5oUvI
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                            TriggerFlexrayAdapter.this.lambda$onClick$7$TriggerFlexrayAdapter(popupSpinner, spinnerAdapter, list2, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerFlexrayAdapter$19_qGARTnLUihBeYJ10KcXyEzg0
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerFlexrayAdapter.this.lambda$onClick$8$TriggerFlexrayAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_flexray_symbol_value /* 2131364230 */:
                if (this.popupView != null) {
                    List<MappingObject> list2 = ViewUtil.getList((int) R.array.msg_trigger_flexray_symbol_type);
                    this.clickedView = view;
                    this.mappingObjects = list2;
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list2, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerFlexrayAdapter$q-jFUoA8OWoNlGSL7wukLaWWiMA
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list3, View view2) {
                            TriggerFlexrayAdapter.this.lambda$onClick$11$TriggerFlexrayAdapter(popupSpinner, spinnerAdapter, list3, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerFlexrayAdapter$FojER-pZgDmbKun6KFgeaQJrX8k
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerFlexrayAdapter.this.lambda$onClick$12$TriggerFlexrayAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_level_value /* 2131364280 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readLevelAttr();
                    TriggerParam triggerParam = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam.getChanUnit(triggerParam.getChannel()), this.param.getLevelAttr().getMaxLongValue(), this.param.getLevelAttr().getMinLongValue(), this.param.getLevelAttr().getDefLongValue(), this.param.getLevel(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerFlexrayAdapter.6
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerFlexrayAdapter.this.param.saveLevelSync(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerFlexrayAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source /* 2131364336 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_source_la)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerFlexrayAdapter$fSb8vQAThcuWOSVwuHHr3b0yA2E
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list3, View view2) {
                            TriggerFlexrayAdapter.this.lambda$onClick$3$TriggerFlexrayAdapter(popupSpinner, spinnerAdapter, list3, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerFlexrayAdapter$hct3cq8PbQrQlaWTVDENo0meKi8
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerFlexrayAdapter.this.lambda$onClick$4$TriggerFlexrayAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_up_limit_cyc_value /* 2131364395 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readcompareUperLimitAttr();
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_number, this.param.getcompareUperLimitAttr().getMaxIntValue(), this.param.getcompareUperLimitAttr().getMinIntValue(), this.param.getcompareUperLimitAttr().getDefIntValue(), this.param.getCompareUperLimit(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerFlexrayAdapter.2
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerFlexrayAdapter.this.param.saveFlexrayUpCycValue(Math.toIntExact(((Long) t).longValue()));
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerFlexrayAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_up_limit_id_value /* 2131364397 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readidUperLimitAttr();
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_number, this.param.getidUperLimitAttr().getMaxIntValue(), this.param.getidUperLimitAttr().getMinIntValue(), this.param.getidUperLimitAttr().getDefIntValue(), this.param.getIdUperLimit(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerFlexrayAdapter.4
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerFlexrayAdapter.this.param.saveFlexrayUpIdValue(Math.toIntExact(((Long) t).longValue()));
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerFlexrayAdapter.this.keyboardPopupView = keyboardPopupView;
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

    public /* synthetic */ void lambda$onClick$3$TriggerFlexrayAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$TriggerFlexrayAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSource(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$5$TriggerFlexrayAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$TriggerFlexrayAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectBaudValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$7$TriggerFlexrayAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$8$TriggerFlexrayAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectPostTypeValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$9$TriggerFlexrayAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$10$TriggerFlexrayAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectFrameValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$11$TriggerFlexrayAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$12$TriggerFlexrayAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSymbolValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$13$TriggerFlexrayAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$14$TriggerFlexrayAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectErrorValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$15$TriggerFlexrayAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$16$TriggerFlexrayAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectIdCompValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$17$TriggerFlexrayAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$18$TriggerFlexrayAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectCycCompValue(mappingObject);
    }

    private void selectCycCompValue(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveFlexrayCycCompValue(mappingObject.getValue());
        }
    }

    private void selectIdCompValue(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveFlexrayIdCompValue(mappingObject.getValue());
        }
    }

    private void selectErrorValue(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveFlexrayErrorValue(mappingObject.getValue());
        }
    }

    private void selectSymbolValue(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveFlexraySymbolValue(mappingObject.getValue());
        }
    }

    private void selectFrameValue(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveFlexrayFrameValue(mappingObject.getValue());
        }
    }

    private void selectPostTypeValue(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveFlexrayPostTypeValue(mappingObject.getValue());
        }
    }

    private void selectBaudValue(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveFlexrayBaudValue(mappingObject.getValue());
        }
    }

    private void selectSource(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveFlexraySource(mappingObject.getValue());
            this.param.setChannel(mappingObject.getValue());
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        switch (i) {
            case R.id.trigger_down_limit_cyc_value /* 2131364197 */:
                TriggerParam triggerParam = this.param;
                triggerParam.saveFlexrayDownCycValue(Math.toIntExact(triggerParam.getLongStep(triggerParam.getCompareLowerLimit(), this.param.getcompareLowerLimitAttr(), z, keyEvent)));
                return;
            case R.id.trigger_down_limit_id_value /* 2131364199 */:
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveFlexrayDownIdValue(Math.toIntExact(triggerParam2.getLongStep(triggerParam2.getIdLowerLimit(), this.param.getidLowerLimitAttr(), z, keyEvent)));
                return;
            case R.id.trigger_level_value /* 2131364280 */:
                TriggerParam triggerParam3 = this.param;
                triggerParam3.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam3);
                return;
            case R.id.trigger_up_limit_cyc_value /* 2131364395 */:
                TriggerParam triggerParam4 = this.param;
                triggerParam4.saveFlexrayUpCycValue(Math.toIntExact(triggerParam4.getLongStep(triggerParam4.getCompareUperLimit(), this.param.getcompareUperLimitAttr(), z, keyEvent)));
                return;
            case R.id.trigger_up_limit_id_value /* 2131364397 */:
                TriggerParam triggerParam5 = this.param;
                triggerParam5.saveFlexrayUpIdValue(Math.toIntExact(triggerParam5.getLongStep(triggerParam5.getIdUperLimit(), this.param.getidUperLimitAttr(), z, keyEvent)));
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
            case R.id.trigger_down_limit_cyc_value /* 2131364197 */:
                TriggerParam triggerParam = this.param;
                triggerParam.saveFlexrayDownCycValue(Math.toIntExact(triggerParam.getLongDef(triggerParam.getcompareLowerLimitAttr())));
                return;
            case R.id.trigger_down_limit_id_value /* 2131364199 */:
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveFlexrayDownIdValue(Math.toIntExact(triggerParam2.getLongDef(triggerParam2.getidLowerLimitAttr())));
                return;
            case R.id.trigger_level_value /* 2131364280 */:
                TriggerParam triggerParam3 = this.param;
                triggerParam3.saveLevelSync(triggerParam3.getLongDef(triggerParam3.getLevelAttr()));
                return;
            case R.id.trigger_up_limit_cyc_value /* 2131364395 */:
                TriggerParam triggerParam4 = this.param;
                triggerParam4.saveFlexrayUpCycValue(Math.toIntExact(triggerParam4.getLongDef(triggerParam4.getcompareUperLimitAttr())));
                return;
            case R.id.trigger_up_limit_id_value /* 2131364397 */:
                TriggerParam triggerParam5 = this.param;
                triggerParam5.saveFlexrayUpIdValue(Math.toIntExact(triggerParam5.getLongDef(triggerParam5.getidUperLimitAttr())));
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public class TriggerFlexrayHolder extends RecyclerView.ViewHolder {
        private AdapterTriggerFlexrayBinding binding;

        public TriggerFlexrayHolder(AdapterTriggerFlexrayBinding adapterTriggerFlexrayBinding) {
            super(adapterTriggerFlexrayBinding.getRoot());
            this.binding = adapterTriggerFlexrayBinding;
        }
    }
}
