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
import com.rigol.scope.databinding.AdapterTriggerCanBinding;
import com.rigol.scope.databinding.PopupviewTriggerBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.KtUtilKt;
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
public class TriggerCanAdapter extends RecyclerView.Adapter<TriggerCanHolder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, View.OnLongClickListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterTriggerCanBinding binding;
    private View clickedView;
    private Context context;
    private FormatTransformKey formatTransformKey;
    private FormatTransformKey formatTransformKeyId;
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
    private int idOffNumMax = 11;
    private int idOnNumMax = 29;
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

    public TriggerCanAdapter(Context context, BasePopupView basePopupView, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        this.triggerViewModel = triggerViewModel;
        this.popupView = basePopupView;
        this.context = context;
        this.serviceId = triggerParam.getServiceId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TriggerCanHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterTriggerCanBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSamplePointsValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerCanDataByteValue, 0, false, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSamplePointsFdValue, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSourceCanValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSourceCanHValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSourceCanBaudValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSourceCanFdBaudValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSamplePointsLabel, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSourceCanWhenValue, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.TriggerCanAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                showKey(TriggerCanAdapter.this.context, ((AorBParam) TriggerCanAdapter.this.list_aorbParam.get(i2)).getEditText() != null ? ((AorBParam) TriggerCanAdapter.this.list_aorbParam.get(i2)).getEditText() : ((AorBParam) TriggerCanAdapter.this.list_aorbParam.get(i2)).getTextView() != null ? ((AorBParam) TriggerCanAdapter.this.list_aorbParam.get(i2)).getTextView() : null, true, ((AorBParam) TriggerCanAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                showKey(TriggerCanAdapter.this.context, ((AorBParam) TriggerCanAdapter.this.list_aorbParam.get(i2)).getEditText() != null ? ((AorBParam) TriggerCanAdapter.this.list_aorbParam.get(i2)).getEditText() : ((AorBParam) TriggerCanAdapter.this.list_aorbParam.get(i2)).getTextView() != null ? ((AorBParam) TriggerCanAdapter.this.list_aorbParam.get(i2)).getTextView() : null, false, ((AorBParam) TriggerCanAdapter.this.list_aorbParam.get(i2)).getAorb());
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
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerCanAdapter$NouzhM4rjwl8g0kBgCGRfItElNs
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TriggerCanAdapter.this.lambda$onCreateViewHolder$2$TriggerCanAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new TriggerCanHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$TriggerCanAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (this.popviewTriggerBinding.triggerView.getAdapter() instanceof TriggerCanAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerCanAdapter$tJCR-XbjT0tv5CCb8sEZb4C_IYY
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerCanAdapter.this.lambda$onCreateViewHolder$0$TriggerCanAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerCanAdapter$4L2VUfMnVBlsjOg1KyOBTipLGLo
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    TriggerCanAdapter.this.lambda$onCreateViewHolder$1$TriggerCanAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$TriggerCanAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$TriggerCanAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.trigger_source_can_value) {
            selectSourceCanValue(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_source_can_h_value) {
            selectSourceCanHValue(mappingObject);
        } else if (this.clickedView.getId() == R.id.trigger_source_can_when_value) {
            selectSourceCanWhenValue(mappingObject);
        }
    }

    private void selectSourceCanWhenValue(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveCanWhen(mappingObject.getValue());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TriggerCanHolder triggerCanHolder, int i) {
        this.triggerViewModel.getLiveData().observe((LifecycleOwner) this.context, new Observer<TriggerParam>() { // from class: com.rigol.scope.adapters.TriggerCanAdapter.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            public void onChanged(TriggerParam triggerParam) {
                TriggerCanAdapter.this.param = triggerParam;
            }
        });
        ShowTriggerCan();
        triggerCanHolder.binding.executePendingBindings();
    }

    public void ShowTriggerCan() {
        ServiceEnum.Chan chan = this.param.getChan();
        if (chan == ServiceEnum.Chan.acline || chan == ServiceEnum.Chan.ext) {
            this.param.setChannel(ServiceEnum.Chan.chan1.value1);
            this.param.saveCanSource(ServiceEnum.Chan.chan1.value1);
        } else {
            this.param.setChan(ServiceEnum.getChanFromValue1(chan.value1));
        }
        this.param.setChanColor(this.binding.triggerSourceCanValue, chan);
        this.param.readCanSingnal();
        TriggerParam triggerParam = this.param;
        triggerParam.setFormatValue3DataStr(triggerParam.getFormatValue3DataStr());
        TriggerParam triggerParam2 = this.param;
        triggerParam2.setFormatValue3IdStr(triggerParam2.getFormatValue3IdStr());
        this.param.readCanBaud();
        this.param.readCanFdBaud();
        this.param.readCanSamplePoint();
        this.param.readCanFdSamplePoint();
        this.param.readCanIdExtended();
        this.param.readCanDefine();
        this.param.readCanWhen();
        this.binding.setDefineDataMapping(ViewUtil.getMappingObject(R.array.msg_trigger_can_define, 0));
        this.binding.setDefineIdMapping(ViewUtil.getMappingObject(R.array.msg_trigger_can_define, 1));
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        this.binding.setParam(this.param);
        ViewUtil.setSwitchButton(this.binding.triggerNoiseSwitch);
        ViewUtil.setSwitchButton(this.binding.triggerCanIdExtendedValue);
        this.binding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.triggerCanIdExtendedValue.setOnCheckedChangeListener(this);
        this.binding.buttonLevel.setOnClickListener(this);
        this.binding.triggerSourceCanValue.setOnClickListener(this);
        this.binding.triggerSourceCanHValue.setOnClickListener(this);
        this.binding.triggerSourceCanBaudValue.setOnClickListener(this);
        this.binding.triggerSourceCanFdBaudValue.setOnClickListener(this);
        this.binding.triggerSourceCanWhenValue.setOnClickListener(this);
        this.binding.triggerSourceCanBaudValue.setOnLongClickListener(this);
        this.binding.triggerLevelValue.setOnClickListener(this);
        this.binding.triggerSamplePointsValue.setOnClickListener(this);
        this.binding.triggerSamplePointsFdValue.setOnClickListener(this);
        this.binding.triggerCanDataValue.setOnClickListener(this);
        this.binding.triggerCanDataByteValue.setOnClickListener(this);
        this.binding.triggerCanIdValue.setOnClickListener(this);
        KtUtilKt.isOptAuto();
        API.getInstance().UI_QueryInt32(11, MessageID.MSG_PRODUCT_SERIES);
        int i = ServiceEnum.ProductSeries.SERIES_1000.value1;
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
                case R.id.trigger_can_id_extended_value /* 2131364179 */:
                    TriggerParam triggerParam = this.param;
                    if (triggerParam != null) {
                        if (z) {
                            triggerParam.setKeyNumMax(this.idOnNumMax);
                        } else {
                            triggerParam.setKeyNumMax(this.idOffNumMax);
                        }
                        this.param.saveCanIdExtendedValue(z);
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
            case R.id.trigger_can_data_byte_value /* 2131364174 */:
                if (this.aorBManager.setClick_showab_textview(id) && (this.context instanceof Activity)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_number, this.param.getCanDataByteAttr().getMaxIntValue(), this.param.getCanDataByteAttr().getMinIntValue(), this.param.getCanDataByteAttr().getDefIntValue(), this.param.getDataByte(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerCanAdapter.7
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerCanAdapter.this.param.saveDataByte(((Long) t).intValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerCanAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_can_data_value /* 2131364177 */:
                if (this.context instanceof Activity) {
                    this.param.saveCanDefine(false);
                    this.param.setCanDataIdType(0);
                    TriggerParam triggerParam = this.param;
                    triggerParam.setKeyNumMax(triggerParam.getDataByte() * 8);
                    if (this.formatTransformKey == null) {
                        FormatTransformKey formatTransformKey = new FormatTransformKey(this.context, this.popupView.getAnchor(), this.param);
                        this.formatTransformKey = formatTransformKey;
                        formatTransformKey.attachRefView(this.binding.triggerCanDataValue);
                        this.formatTransformKey.getFormatTransformValue(new FormatTransformKey.FormatTransformInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerCanAdapter$7bDrorTpsO7LGyl8W-DQTP8Y2k4
                            @Override // com.rigol.scope.views.FormatTransformKey.FormatTransformInterface
                            public final void FormatTransformListener(String str) {
                                TriggerCanAdapter.this.lambda$onClick$13$TriggerCanAdapter(str);
                            }
                        });
                    }
                    this.formatTransformKey.show();
                    this.formatTransformKey.init();
                    break;
                }
                break;
            case R.id.trigger_can_id_value /* 2131364181 */:
                if (this.context instanceof Activity) {
                    this.param.saveCanDefine(true);
                    this.param.setCanDataIdType(1);
                    if (this.formatTransformKeyId == null) {
                        FormatTransformKey formatTransformKey2 = new FormatTransformKey(this.context, this.popupView.getAnchor(), this.param);
                        this.formatTransformKeyId = formatTransformKey2;
                        formatTransformKey2.attachRefView(this.binding.triggerCanIdValue);
                        this.formatTransformKeyId.getFormatTransformValue(new FormatTransformKey.FormatTransformInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerCanAdapter$tUsHq74ajxK2mq1bf17M4nEoRiA
                            @Override // com.rigol.scope.views.FormatTransformKey.FormatTransformInterface
                            public final void FormatTransformListener(String str) {
                                TriggerCanAdapter.this.lambda$onClick$14$TriggerCanAdapter(str);
                            }
                        });
                    }
                    this.formatTransformKeyId.show();
                    this.formatTransformKeyId.init();
                    break;
                }
                break;
            case R.id.trigger_level_value /* 2131364280 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readLevelAttr();
                    TriggerParam triggerParam2 = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam2.getChanUnit(triggerParam2.getChannel()), this.param.getLevelAttr().getMaxLongValue(), this.param.getLevelAttr().getMinLongValue(), this.param.getLevelAttr().getDefLongValue(), this.param.getLevel(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerCanAdapter.8
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerCanAdapter.this.param.saveLevelSync(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerCanAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_sample_points_fd_value /* 2131364332 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_percent, this.param.getFdSamplePointsAttr().getMaxIntValue(), this.param.getFdSamplePointsAttr().getMinIntValue(), this.param.getFdSamplePointsAttr().getDefIntValue(), this.param.getFdSamplePoints(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerCanAdapter.6
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerCanAdapter.this.param.saveCanFdSamplePoints(Math.toIntExact(((Long) t).longValue()));
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerCanAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_sample_points_value /* 2131364334 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_percent, this.param.getSamplePointsAttr().getMaxIntValue(), this.param.getSamplePointsAttr().getMinIntValue(), this.param.getSamplePointsAttr().getDefIntValue(), this.param.getSamplePoints(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerCanAdapter.5
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerCanAdapter.this.param.saveCanSamplePoints(Math.toIntExact(((Long) t).longValue()));
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerCanAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source_can_baud_value /* 2131364342 */:
                if (this.popupView != null) {
                    final List<MappingObject> list = ViewUtil.getList((int) R.array.msg_trigger_can_baud);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerCanAdapter$Qge6A5leuA7fVl7gMuXuOmBJAN0
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                            TriggerCanAdapter.this.lambda$onClick$7$TriggerCanAdapter(popupSpinner, spinnerAdapter, list2, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerCanAdapter$e6w6SHbWTRNKlcU0k5TF948vMAQ
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerCanAdapter.this.lambda$onClick$8$TriggerCanAdapter(list, view, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source_can_fd_baud_value /* 2131364344 */:
                if (this.popupView != null) {
                    final List<MappingObject> list2 = ViewUtil.getList((int) R.array.msg_trigger_canfd_baud);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list2, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerCanAdapter$DbFDj-_4SS3EQxlvBfGNroEccSo
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list3, View view2) {
                            TriggerCanAdapter.this.lambda$onClick$9$TriggerCanAdapter(popupSpinner, spinnerAdapter, list3, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerCanAdapter$jKvX6M4xfHZjtlOozFaJGxYj8M4
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerCanAdapter.this.lambda$onClick$10$TriggerCanAdapter(list2, view, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source_can_h_value /* 2131364346 */:
                if (this.popupView != null) {
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_trigger_can_singnal), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerCanAdapter$W3pPZax-kcJpGZ1WEKBC51gBqW8
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list3, View view2) {
                            TriggerCanAdapter.this.lambda$onClick$5$TriggerCanAdapter(popupSpinner, spinnerAdapter, list3, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerCanAdapter$s9ANcLZQde__KNHQDT5NuOb3zvg
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerCanAdapter.this.lambda$onClick$6$TriggerCanAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source_can_value /* 2131364348 */:
                if (this.popupView != null) {
                    List<MappingObject> filterChan = ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_source_la));
                    this.clickedView = view;
                    this.mappingObjects = filterChan;
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, filterChan, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerCanAdapter$TIF-GQE6TXlo0_5_OgG8Joz8ZjE
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list3, View view2) {
                            TriggerCanAdapter.this.lambda$onClick$3$TriggerCanAdapter(popupSpinner, spinnerAdapter, list3, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerCanAdapter$XwamlltGabc-Nc62Vp9x8vNvaeg
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerCanAdapter.this.lambda$onClick$4$TriggerCanAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source_can_when_value /* 2131364349 */:
                if (this.popupView != null) {
                    List<MappingObject> list3 = ViewUtil.getList((int) R.array.msg_trigger_can_when);
                    this.clickedView = view;
                    this.mappingObjects = list3;
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list3, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerCanAdapter$MlZp8mDzQCtRGE8L6qvdvfDYU0s
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list4, View view2) {
                            TriggerCanAdapter.this.lambda$onClick$11$TriggerCanAdapter(popupSpinner, spinnerAdapter, list4, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerCanAdapter$HQSLow_0THNV81NNcMPR0LDSFT4
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerCanAdapter.this.lambda$onClick$12$TriggerCanAdapter(view2, viewHolder, i, (MappingObject) obj);
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

    public /* synthetic */ void lambda$onClick$3$TriggerCanAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$TriggerCanAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceCanValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$5$TriggerCanAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$TriggerCanAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceCanHValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$7$TriggerCanAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$8$TriggerCanAdapter(List list, View view, View view2, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        if (this.param != null) {
            MappingObject mappingObject2 = (MappingObject) list.get(i);
            if (mappingObject2.getValue() != 0) {
                this.param.saveCanBaud(mappingObject2.getValue());
                return;
            }
            TriggerParam triggerParam = this.param;
            triggerParam.setCanBaud(triggerParam.getCanBaud());
            ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_decimal, this.param.getCanBaudRateAttr().getMaxIntValue(), this.param.getCanBaudRateAttr().getMinIntValue(), this.param.getCanBaudRateAttr().getDefIntValue(), this.param.getCanBaud(), UnitFormat.SI.NONE, new UnitFormat.SI[]{UnitFormat.SI.MEGA, UnitFormat.SI.KILO}, "0.###", new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerCanAdapter.3
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    TriggerCanAdapter.this.param.saveCanBaud(((Long) t).intValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerCanAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$9$TriggerCanAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$10$TriggerCanAdapter(List list, View view, View view2, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        if (this.param != null) {
            MappingObject mappingObject2 = (MappingObject) list.get(i);
            if (mappingObject2.getValue() != 0) {
                this.param.saveCanFdBaud(mappingObject2.getValue());
                return;
            }
            TriggerParam triggerParam = this.param;
            triggerParam.setCanFdBaud(triggerParam.getCanFdBaud());
            ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_decimal, this.param.getCanFdBaudRateAttr().getMaxIntValue(), this.param.getCanFdBaudRateAttr().getMinIntValue(), this.param.getCanFdBaudRateAttr().getDefIntValue(), this.param.getCanFdBaud(), UnitFormat.SI.NONE, new UnitFormat.SI[]{UnitFormat.SI.MEGA, UnitFormat.SI.KILO}, "0.###", new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerCanAdapter.4
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    TriggerCanAdapter.this.param.saveCanFdBaud(((Long) t).intValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerCanAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$11$TriggerCanAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$12$TriggerCanAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceCanWhenValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$13$TriggerCanAdapter(String str) {
        this.param.setFormatValue3DataStr(str);
        if (str.contains("[bin]")) {
            this.param.setCanDataType(0);
        } else {
            this.param.setCanDataType(1);
        }
    }

    public /* synthetic */ void lambda$onClick$14$TriggerCanAdapter(String str) {
        this.param.setFormatValue3IdStr(str);
        if (str.contains("[bin]")) {
            this.param.setCanIdType(0);
        } else {
            this.param.setCanIdType(1);
        }
    }

    private void selectSourceCanHValue(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveCanSignal(mappingObject.getValue());
        }
    }

    private void selectSourceCanValue(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveCanSource(mappingObject.getValue());
            this.param.setChannel(mappingObject.getValue());
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == R.id.trigger_source_can_baud_value) {
            ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_decimal, this.param.getCanBaudRateAttr().getMaxIntValue(), this.param.getCanBaudRateAttr().getMinIntValue(), this.param.getCanBaudRateAttr().getDefIntValue(), this.param.getCanBaud(), UnitFormat.SI.NONE, new UnitFormat.SI[]{UnitFormat.SI.MEGA, UnitFormat.SI.KILO}, "0.###", new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerCanAdapter.9
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    TriggerCanAdapter.this.param.saveCanBaud(((Long) t).intValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerCanAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (view.getId() == R.id.trigger_source_can_fd_baud_value) {
            ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_decimal, this.param.getCanFdBaudRateAttr().getMaxIntValue(), this.param.getCanFdBaudRateAttr().getMinIntValue(), this.param.getCanFdBaudRateAttr().getDefIntValue(), this.param.getCanFdBaud(), UnitFormat.SI.NONE, new UnitFormat.SI[]{UnitFormat.SI.MEGA, UnitFormat.SI.KILO}, "0.###", new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerCanAdapter.10
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    TriggerCanAdapter.this.param.saveCanFdBaud(((Long) t).intValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerCanAdapter.this.keyboardPopupView = keyboardPopupView;
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
            case R.id.trigger_can_data_byte_value /* 2131364174 */:
                TriggerParam triggerParam = this.param;
                triggerParam.saveDataByte(triggerParam.getIntStep(triggerParam.getDataByte(), this.param.getCanDataByteAttr(), z, keyEvent));
                return;
            case R.id.trigger_level_value /* 2131364280 */:
                TriggerParam triggerParam2 = this.param;
                triggerParam2.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam2);
                return;
            case R.id.trigger_sample_points_fd_value /* 2131364332 */:
                TriggerParam triggerParam3 = this.param;
                triggerParam3.saveCanFdSamplePoints(triggerParam3.getIntStep(triggerParam3.getFdSamplePoints(), this.param.getFdSamplePointsAttr(), z, keyEvent));
                return;
            case R.id.trigger_sample_points_value /* 2131364334 */:
                TriggerParam triggerParam4 = this.param;
                triggerParam4.saveCanSamplePoints(triggerParam4.getIntStep(triggerParam4.getSamplePoints(), this.param.getSamplePointsAttr(), z, keyEvent));
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
            case R.id.trigger_can_data_byte_value /* 2131364174 */:
                TriggerParam triggerParam = this.param;
                triggerParam.saveDataByte(triggerParam.getIntDef(triggerParam.getCanDataByteAttr()));
                return;
            case R.id.trigger_level_value /* 2131364280 */:
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveLevelSync(triggerParam2.getLongDef(triggerParam2.getLevelAttr()));
                return;
            case R.id.trigger_sample_points_fd_value /* 2131364332 */:
                TriggerParam triggerParam3 = this.param;
                triggerParam3.saveCanFdSamplePoints(triggerParam3.getIntDef(triggerParam3.getFdSamplePointsAttr()));
                return;
            case R.id.trigger_sample_points_value /* 2131364334 */:
                TriggerParam triggerParam4 = this.param;
                triggerParam4.saveCanSamplePoints(triggerParam4.getIntDef(triggerParam4.getSamplePointsAttr()));
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public class TriggerCanHolder extends RecyclerView.ViewHolder {
        private AdapterTriggerCanBinding binding;

        public TriggerCanHolder(AdapterTriggerCanBinding adapterTriggerCanBinding) {
            super(adapterTriggerCanBinding.getRoot());
            this.binding = adapterTriggerCanBinding;
        }
    }
}
