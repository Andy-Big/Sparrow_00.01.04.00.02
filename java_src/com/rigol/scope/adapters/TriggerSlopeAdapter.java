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
import com.rigol.scope.databinding.AdapterTriggerSlopeBinding;
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
public class TriggerSlopeAdapter extends RecyclerView.Adapter<TriggerSlopeHolder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset, AorBManager.OnSetTextByTriggerLevelRoll {
    private AorBManager aorBManager;
    private AdapterTriggerSlopeBinding binding;
    private View clickedView;
    private Context context;
    private boolean isMove;
    private KeyboardPopupView keyboardPopupView;
    private List<AorBParam> list_aorbParam = new ArrayList();
    private AorBManager.OnOutOrInAdapterClickChangeListener listener;
    private List<MappingObject> mappingObjects;
    private AorBManager.OnAOrBManagerListener onAOrBManagerListener;
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

    public void setOnAOrBManagerListener(AorBManager.OnAOrBManagerListener onAOrBManagerListener) {
        this.onAOrBManagerListener = onAOrBManagerListener;
    }

    public void setListener(PopupviewTriggerBinding popupviewTriggerBinding, AorBManager.OnOutOrInAdapterClickChangeListener onOutOrInAdapterClickChangeListener) {
        this.popviewTriggerBinding = popupviewTriggerBinding;
        this.listener = onOutOrInAdapterClickChangeListener;
    }

    public TriggerSlopeAdapter(Context context, BasePopupView basePopupView, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        this.triggerViewModel = triggerViewModel;
        this.param = triggerParam;
        this.popupView = basePopupView;
        this.context = context;
        this.serviceId = triggerParam.getServiceId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TriggerSlopeHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterTriggerSlopeBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelAValue, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelBValue, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerHoldoff, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.upperLimitValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.lowerLimitValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSource, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this, this) { // from class: com.rigol.scope.adapters.TriggerSlopeAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                showKey(TriggerSlopeAdapter.this.context, ((AorBParam) TriggerSlopeAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) TriggerSlopeAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                showKey(TriggerSlopeAdapter.this.context, ((AorBParam) TriggerSlopeAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) TriggerSlopeAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.triggerLevelAValue, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.triggerLevelBValue, true, ViewUtil.KEY_B);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSlopeAdapter$VDpB6loGd7u02HvR37TuyTJV9Xs
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TriggerSlopeAdapter.this.lambda$onCreateViewHolder$2$TriggerSlopeAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        AorBManager.OnAOrBManagerListener onAOrBManagerListener = this.onAOrBManagerListener;
        if (onAOrBManagerListener != null) {
            onAOrBManagerListener.onCall(this.aorBManager);
        }
        return new TriggerSlopeHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$TriggerSlopeAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (this.popviewTriggerBinding.triggerView.getAdapter() instanceof TriggerSlopeAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSlopeAdapter$SaXI80JzAjnMHVoTPC34n77MpVs
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerSlopeAdapter.this.lambda$onCreateViewHolder$0$TriggerSlopeAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSlopeAdapter$1yP3tV7KdENh1yCadh_YtaWI0kU
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    TriggerSlopeAdapter.this.lambda$onCreateViewHolder$1$TriggerSlopeAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$TriggerSlopeAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$TriggerSlopeAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.trigger_source) {
            selectSource(mappingObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TriggerSlopeHolder triggerSlopeHolder, int i) {
        ShowTriggerSlope();
        triggerSlopeHolder.binding.executePendingBindings();
    }

    public void ShowTriggerSlope() {
        ServiceEnum.Chan chan = this.param.getChan();
        if (chan == ServiceEnum.Chan.acline || chan == ServiceEnum.Chan.ext) {
            this.param.saveSlopeSource(ServiceEnum.Chan.chan1.value1);
            this.param.setChannel(ServiceEnum.Chan.chan1.value1);
        } else {
            this.param.setChan(ServiceEnum.getChanFromValue1(chan.value1));
        }
        this.param.setChanColor(this.binding.triggerSource, chan);
        this.param.readLevelSelect();
        this.param.readSlopeWhen();
        this.param.readSlopeLwidth();
        this.param.readSlopeUwidth();
        this.param.readSlopePolarity();
        this.param.readSlopeHighLevel();
        this.param.readSlopeLowLevel();
        this.param.checkLevel();
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        this.binding.setSlopeRisingMapping(ViewUtil.getMappingObject(R.array.msg_trigger_slope_polarity, ServiceEnum.EdgeSlope.Trigger_Edge_Rising.value1));
        this.binding.setSlopeFallingMapping(ViewUtil.getMappingObject(R.array.msg_trigger_slope_polarity, ServiceEnum.EdgeSlope.Trigger_Edge_Falling.value1));
        this.binding.setSelectLevelAMapping(ViewUtil.getMappingObject(R.array.msg_trigger_levelselect, ServiceEnum.Trigger_Level_ID.Trigger_Level_High.value1));
        this.binding.setSelectLevelBMapping(ViewUtil.getMappingObject(R.array.msg_trigger_levelselect, ServiceEnum.Trigger_Level_ID.Trigger_Level_Low.value1));
        this.binding.setParam(this.param);
        ViewUtil.setSwitchButton(this.binding.triggerNoiseSwitch);
        this.binding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.triggerLevelSelectA.setOnCheckedChangeListener(this);
        this.binding.triggerLevelSelectB.setOnCheckedChangeListener(this);
        this.binding.triggerLevelSelectAb.setOnCheckedChangeListener(this);
        this.binding.moreThan.setOnCheckedChangeListener(this);
        this.binding.lessMore.setOnCheckedChangeListener(this);
        this.binding.lessThan.setOnCheckedChangeListener(this);
        this.binding.edgeRising.setOnCheckedChangeListener(this);
        this.binding.edgeFalling.setOnCheckedChangeListener(this);
        this.binding.buttonLevel.setOnClickListener(this);
        this.binding.buttonLevelB.setOnClickListener(this);
        this.binding.imageView2.setOnClickListener(this);
        this.binding.triggerSource.setOnClickListener(this);
        this.binding.triggerHoldoff.setOnClickListener(this);
        this.binding.triggerLevelAValue.setOnClickListener(this);
        this.binding.triggerLevelBValue.setOnClickListener(this);
        this.binding.upperLimitValue.setOnClickListener(this);
        this.binding.lowerLimitValue.setOnClickListener(this);
        this.binding.triggerLevelAView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.adapters.TriggerSlopeAdapter.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long progress = (long) ((((seekBar.getProgress() / 100.0d) * (TriggerSlopeAdapter.this.param.getChanScale() * TriggerSlopeAdapter.this.param.getScaleNum())) - TriggerSlopeAdapter.this.param.getChanOffset()) - ((TriggerSlopeAdapter.this.param.getChanScale() * TriggerSlopeAdapter.this.param.getScaleNum()) / 2));
                    if (TriggerSlopeAdapter.this.param.getSlopeTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                        TriggerSlopeAdapter.this.param.saveSlopeLevelASync(progress);
                        return;
                    }
                    TriggerSlopeAdapter.this.param.saveSlopeLevelASync(progress);
                    TriggerSlopeAdapter.this.param.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, TriggerSlopeAdapter.this.param.getSlopelevelB());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                long progress = (long) ((((seekBar.getProgress() / 100.0d) * (TriggerSlopeAdapter.this.param.getChanScale() * TriggerSlopeAdapter.this.param.getScaleNum())) - TriggerSlopeAdapter.this.param.getChanOffset()) - ((TriggerSlopeAdapter.this.param.getChanScale() * TriggerSlopeAdapter.this.param.getScaleNum()) / 2));
                if (TriggerSlopeAdapter.this.param.getSlopeTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                    TriggerSlopeAdapter.this.param.saveSlopeLevelASync(progress);
                    return;
                }
                TriggerSlopeAdapter.this.param.saveSlopeLevelASync(progress);
                TriggerSlopeAdapter.this.param.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, TriggerSlopeAdapter.this.param.getSlopelevelB());
            }
        });
        this.binding.triggerLevelBView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.adapters.TriggerSlopeAdapter.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    long updateSlopeLevelDifferenceValue = TriggerSlopeAdapter.this.param.updateSlopeLevelDifferenceValue();
                    long progress = (long) ((((seekBar.getProgress() / 100.0d) * (TriggerSlopeAdapter.this.param.getChanScale() * TriggerSlopeAdapter.this.param.getScaleNum())) - TriggerSlopeAdapter.this.param.getChanOffset()) - ((TriggerSlopeAdapter.this.param.getChanScale() * TriggerSlopeAdapter.this.param.getScaleNum()) / 2));
                    if (TriggerSlopeAdapter.this.param.getSlopeTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                        TriggerSlopeAdapter.this.param.readslopeLevelAttr();
                        TriggerSlopeAdapter.this.param.readslopeLevelBAttr();
                        if (progress < TriggerSlopeAdapter.this.param.getslopeLevelAttr().getMaxLongValue() - updateSlopeLevelDifferenceValue) {
                            TriggerSlopeAdapter.this.param.saveSlopeLevelBSync(progress);
                            TriggerSlopeAdapter.this.param.saveSlopeLevelASync(progress + updateSlopeLevelDifferenceValue);
                            return;
                        }
                        TriggerSlopeAdapter.this.param.saveSlopeLevelBSync(TriggerSlopeAdapter.this.param.getslopeLevelAttr().getMaxLongValue() - updateSlopeLevelDifferenceValue);
                        TriggerSlopeAdapter.this.param.saveSlopeLevelASync(TriggerSlopeAdapter.this.param.getslopeLevelAttr().getMaxLongValue());
                        return;
                    }
                    TriggerSlopeAdapter.this.param.saveSlopeLevelBSync(progress);
                    TriggerSlopeAdapter.this.param.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, TriggerSlopeAdapter.this.param.getSlopelevelA());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                long updateSlopeLevelDifferenceValue = TriggerSlopeAdapter.this.param.updateSlopeLevelDifferenceValue();
                long progress = (long) ((((seekBar.getProgress() / 100.0d) * (TriggerSlopeAdapter.this.param.getChanScale() * TriggerSlopeAdapter.this.param.getScaleNum())) - TriggerSlopeAdapter.this.param.getChanOffset()) - ((TriggerSlopeAdapter.this.param.getChanScale() * TriggerSlopeAdapter.this.param.getScaleNum()) / 2));
                if (TriggerSlopeAdapter.this.param.getSlopeTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                    TriggerSlopeAdapter.this.param.readslopeLevelAttr();
                    TriggerSlopeAdapter.this.param.readslopeLevelBAttr();
                    if (progress < TriggerSlopeAdapter.this.param.getslopeLevelAttr().getMaxLongValue() - updateSlopeLevelDifferenceValue) {
                        TriggerSlopeAdapter.this.param.saveSlopeLevelBSync(progress);
                        TriggerSlopeAdapter.this.param.saveSlopeLevelASync(progress + updateSlopeLevelDifferenceValue);
                        return;
                    }
                    TriggerSlopeAdapter.this.param.saveSlopeLevelBSync(TriggerSlopeAdapter.this.param.getslopeLevelAttr().getMaxLongValue() - updateSlopeLevelDifferenceValue);
                    TriggerSlopeAdapter.this.param.saveSlopeLevelASync(TriggerSlopeAdapter.this.param.getslopeLevelAttr().getMaxLongValue());
                    return;
                }
                TriggerSlopeAdapter.this.param.saveSlopeLevelBSync(progress);
                TriggerSlopeAdapter.this.param.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, TriggerSlopeAdapter.this.param.getSlopelevelA());
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
                case R.id.edge_falling /* 2131362737 */:
                    TriggerParam triggerParam = this.param;
                    if (triggerParam != null) {
                        triggerParam.saveSlope(z ? 1 : 0);
                        return;
                    }
                    return;
                case R.id.edge_rising /* 2131362739 */:
                    if (this.param != null) {
                        this.param.saveSlope(0);
                        return;
                    }
                    return;
                case R.id.less_more /* 2131363313 */:
                    this.aorBManager.set_RadioButton(0, 1);
                    this.aorBManager.set_RadioButton(0, 1);
                    if (this.param != null) {
                        this.param.saveSlopeWhen(z ? 3 : 0);
                        return;
                    }
                    return;
                case R.id.less_than /* 2131363314 */:
                    this.aorBManager.set_RadioButton(0, 1);
                    this.aorBManager.set_RadioButton(0, 1);
                    if (this.param != null) {
                        this.param.saveSlopeWhen(z ? 2 : 0);
                        return;
                    }
                    return;
                case R.id.more_than /* 2131363421 */:
                    this.aorBManager.set_RadioButton(0, 1);
                    this.aorBManager.set_RadioButton(0, 1);
                    TriggerParam triggerParam2 = this.param;
                    if (triggerParam2 != null) {
                        triggerParam2.saveSlopeWhen(z ? 1 : 0);
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
                case R.id.trigger_level_select_a /* 2131364276 */:
                    if (this.param != null) {
                        this.param.saveSlopeLevelSelect(0);
                        return;
                    }
                    return;
                case R.id.trigger_level_select_ab /* 2131364277 */:
                    if (this.param != null) {
                        this.binding.triggerLevelSelectAb.setChecked(z);
                        this.param.saveSlopeLevelSelect(z ? 2 : 0);
                        return;
                    }
                    return;
                case R.id.trigger_level_select_b /* 2131364278 */:
                    TriggerParam triggerParam3 = this.param;
                    if (triggerParam3 != null) {
                        triggerParam3.saveSlopeLevelSelect(z ? 1 : 0);
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
                    this.param.saveButtonLevelA();
                    break;
                }
                break;
            case R.id.button_levelB /* 2131362193 */:
                if (this.context instanceof Activity) {
                    this.param.saveButtonLevelB();
                    break;
                }
                break;
            case R.id.imageView2 /* 2131363100 */:
                if (this.param.getSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Rising) {
                    this.param.saveSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Falling.value1);
                    break;
                } else if (this.param.getSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Falling) {
                    this.param.saveSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Rising.value1);
                    break;
                }
                break;
            case R.id.lower_limit_value /* 2131363342 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readSlopeLowerLimitAttr();
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getslopeLowerAttr().getMaxLongValue(), this.param.getslopeLowerAttr().getMinLongValue(), this.param.getslopeLowerAttr().getDefLongValue(), this.param.getSlopeLowerLimit(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerSlopeAdapter.8
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerSlopeAdapter.this.param.saveSlopeLowerLimit(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerSlopeAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.normal_radio_button /* 2131363483 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1);
                break;
            case R.id.single_radio_button /* 2131363859 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1);
                break;
            case R.id.trigger_holdoff /* 2131364231 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getHoldOffAttr().getMaxLongValue(), this.param.getHoldOffAttr().getMinLongValue(), this.param.getHoldOffAttr().getDefLongValue(), this.param.getHoldOff(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerSlopeAdapter.4
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerSlopeAdapter.this.param.saveholdOff(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerSlopeAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_levelA_value /* 2131364270 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_LEVEL);
                    this.param.readslopeLevelAttr();
                    TriggerParam triggerParam = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam.getChanUnit(triggerParam.getChannel()), this.param.getslopeLevelAttr().getMaxLongValue(), this.param.getslopeLevelAttr().getMinLongValue(), this.param.getslopeLevelAttr().getDefLongValue(), this.param.getSlopelevelA(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerSlopeAdapter.5
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            if (TriggerSlopeAdapter.this.param.getSlopeTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                                TriggerSlopeAdapter.this.param.saveSlopeLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_High.value1);
                            }
                            TriggerSlopeAdapter.this.param.saveSlopeLevelASync(((Long) t).longValue());
                            TriggerSlopeAdapter.this.param.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, TriggerSlopeAdapter.this.param.getSlopelevelB());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerSlopeAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_levelB_value /* 2131364273 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_LEVEL);
                    this.param.readslopeLevelBAttr();
                    TriggerParam triggerParam2 = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam2.getChanUnit(triggerParam2.getChannel()), this.param.getslopeLevelBAttr().getMaxLongValue(), this.param.getslopeLevelBAttr().getMinLongValue(), this.param.getslopeLevelBAttr().getDefLongValue(), this.param.getSlopelevelB(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerSlopeAdapter.6
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            if (TriggerSlopeAdapter.this.param.getSlopeTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                                TriggerSlopeAdapter.this.param.saveSlopeLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Low.value1);
                            }
                            TriggerSlopeAdapter.this.param.saveSlopeLevelBSync(((Long) t).longValue());
                            TriggerSlopeAdapter.this.param.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, TriggerSlopeAdapter.this.param.getSlopelevelA());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerSlopeAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source /* 2131364336 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_source)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSlopeAdapter$ecgGGhcwu4ExVY8YvC9azmHy27M
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerSlopeAdapter.this.lambda$onClick$3$TriggerSlopeAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerSlopeAdapter$oPjmK6NLT-c8OIF_qXjlCg9g8Cg
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerSlopeAdapter.this.lambda$onClick$4$TriggerSlopeAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.upper_limit_value /* 2131364524 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readSlopeUpperLimitAttr();
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getslopeUpperAttr().getMaxLongValue(), this.param.getslopeUpperAttr().getMinLongValue(), this.param.getslopeUpperAttr().getDefLongValue(), this.param.getSlopeUperLimit(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerSlopeAdapter.7
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerSlopeAdapter.this.param.saveSlopeUperLimit(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerSlopeAdapter.this.keyboardPopupView = keyboardPopupView;
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

    public /* synthetic */ void lambda$onClick$3$TriggerSlopeAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$TriggerSlopeAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSource(mappingObject);
    }

    private void selectSource(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveSlopeSource(mappingObject.getValue());
            this.param.setChannel(mappingObject.getValue());
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        switch (i) {
            case R.id.lower_limit_value /* 2131363342 */:
                this.param.readSlopeLowerLimitAttr();
                TriggerParam triggerParam = this.param;
                triggerParam.saveSlopeLowerLimit(triggerParam.getLongStep(triggerParam.getSlopeLowerLimit(), this.param.getslopeLowerAttr(), z, keyEvent));
                return;
            case R.id.trigger_holdoff /* 2131364231 */:
                this.param.readHoldOffAttr();
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveholdOff(triggerParam2.getLongStep(triggerParam2.getHoldOff(), this.param.getHoldOffAttr(), z, keyEvent));
                return;
            case R.id.trigger_levelA_value /* 2131364270 */:
                if (!this.binding.triggerLevelSelectAb.isChecked()) {
                    this.param.setSlopeTrigger_Level_ID(ServiceEnum.Trigger_Level_ID.Trigger_Level_High);
                }
                TriggerParam triggerParam3 = this.param;
                triggerParam3.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam3);
                return;
            case R.id.trigger_levelB_value /* 2131364273 */:
                if (!this.binding.triggerLevelSelectAb.isChecked()) {
                    this.param.setSlopeTrigger_Level_ID(ServiceEnum.Trigger_Level_ID.Trigger_Level_Low);
                }
                TriggerParam triggerParam4 = this.param;
                triggerParam4.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam4);
                return;
            case R.id.upper_limit_value /* 2131364524 */:
                this.param.readSlopeUpperLimitAttr();
                TriggerParam triggerParam5 = this.param;
                triggerParam5.saveSlopeUperLimit(triggerParam5.getLongStep(triggerParam5.getSlopeUperLimit(), this.param.getslopeUpperAttr(), z, keyEvent));
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
            case R.id.lower_limit_value /* 2131363342 */:
                this.param.readSlopeLowerLimitAttr();
                TriggerParam triggerParam = this.param;
                triggerParam.saveSlopeLowerLimit(triggerParam.getLongDef(triggerParam.getslopeLowerAttr()));
                return;
            case R.id.trigger_holdoff /* 2131364231 */:
                this.param.readHoldOffAttr();
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveholdOff(triggerParam2.getLongDef(triggerParam2.getHoldOffAttr()));
                return;
            case R.id.trigger_levelA_value /* 2131364270 */:
                if (this.param.getSlopeTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                    TriggerParam triggerParam3 = this.param;
                    if (triggerParam3.getLongDef(triggerParam3.getslopeLevelAttr()) < this.param.getSlopelevelB() + (this.param.getChanScale() / 10)) {
                        TriggerParam triggerParam4 = this.param;
                        triggerParam4.setLevelB(triggerParam4.getLongDef(triggerParam4.getslopeLevelAttr()) - (this.param.getChanScale() / 10));
                        TriggerParam triggerParam5 = this.param;
                        triggerParam5.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, triggerParam5.getLongDef(triggerParam5.getslopeLevelAttr()) - (this.param.getChanScale() / 10));
                        TriggerParam triggerParam6 = this.param;
                        triggerParam6.setSlopelevelB(triggerParam6.getLongDef(triggerParam6.getslopeLevelAttr()) - (this.param.getChanScale() / 10));
                        API api = API.getInstance();
                        TriggerParam triggerParam7 = this.param;
                        api.UI_PostInt64(41, MessageID.MSG_SCPI_SLOPE_LEVEL_L, triggerParam7.getLongDef(triggerParam7.getslopeLevelAttr()) - (this.param.getChanScale() / 10));
                    }
                    TriggerParam triggerParam8 = this.param;
                    triggerParam8.setLevel(triggerParam8.getLongDef(triggerParam8.getslopeLevelAttr()));
                    TriggerParam triggerParam9 = this.param;
                    triggerParam9.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, triggerParam9.getLongDef(triggerParam9.getslopeLevelAttr()));
                    TriggerParam triggerParam10 = this.param;
                    triggerParam10.setSlopelevelA(triggerParam10.getLongDef(triggerParam10.getslopeLevelAttr()));
                    API api2 = API.getInstance();
                    TriggerParam triggerParam11 = this.param;
                    api2.UI_PostInt64(41, MessageID.MSG_SCPI_SLOPE_LEVEL_H, triggerParam11.getLongDef(triggerParam11.getslopeLevelAttr()));
                    this.param.saveSlopeLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Double.value1);
                    return;
                }
                TriggerParam triggerParam12 = this.param;
                triggerParam12.saveSlopeLevelASync(triggerParam12.getLongDef(triggerParam12.getslopeLevelAttr()));
                return;
            case R.id.trigger_levelB_value /* 2131364273 */:
                if (this.param.getSlopeTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                    TriggerParam triggerParam13 = this.param;
                    if (triggerParam13.getLongDef(triggerParam13.getslopeLevelBAttr()) > this.param.getSlopelevelA() - (this.param.getChanScale() / 10)) {
                        TriggerParam triggerParam14 = this.param;
                        triggerParam14.setLevel(triggerParam14.getLongDef(triggerParam14.getslopeLevelBAttr()) + (this.param.getChanScale() / 10));
                        TriggerParam triggerParam15 = this.param;
                        triggerParam15.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, triggerParam15.getLongDef(triggerParam15.getslopeLevelBAttr()) + (this.param.getChanScale() / 10));
                        TriggerParam triggerParam16 = this.param;
                        triggerParam16.setSlopelevelA(triggerParam16.getLongDef(triggerParam16.getslopeLevelBAttr()) + (this.param.getChanScale() / 10));
                        API api3 = API.getInstance();
                        TriggerParam triggerParam17 = this.param;
                        api3.UI_PostInt64(41, MessageID.MSG_SCPI_SLOPE_LEVEL_H, triggerParam17.getLongDef(triggerParam17.getslopeLevelBAttr()) + (this.param.getChanScale() / 10));
                    }
                    TriggerParam triggerParam18 = this.param;
                    triggerParam18.setLevelB(triggerParam18.getLongDef(triggerParam18.getslopeLevelBAttr()));
                    TriggerParam triggerParam19 = this.param;
                    triggerParam19.syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, triggerParam19.getLongDef(triggerParam19.getslopeLevelBAttr()));
                    TriggerParam triggerParam20 = this.param;
                    triggerParam20.setSlopelevelB(triggerParam20.getLongDef(triggerParam20.getslopeLevelBAttr()));
                    API api4 = API.getInstance();
                    TriggerParam triggerParam21 = this.param;
                    api4.UI_PostInt64(41, MessageID.MSG_SCPI_SLOPE_LEVEL_L, triggerParam21.getLongDef(triggerParam21.getslopeLevelBAttr()));
                    this.param.saveSlopeLevelSelect(ServiceEnum.Trigger_Level_ID.Trigger_Level_Double.value1);
                    return;
                }
                TriggerParam triggerParam22 = this.param;
                triggerParam22.saveSlopeLevelBSync(triggerParam22.getLongDef(triggerParam22.getslopeLevelBAttr()));
                return;
            case R.id.upper_limit_value /* 2131364524 */:
                this.param.readSlopeUpperLimitAttr();
                TriggerParam triggerParam23 = this.param;
                triggerParam23.saveSlopeUperLimit(triggerParam23.getLongDef(triggerParam23.getslopeUpperAttr()));
                return;
            default:
                return;
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
    public class TriggerSlopeHolder extends RecyclerView.ViewHolder {
        private AdapterTriggerSlopeBinding binding;

        public TriggerSlopeHolder(AdapterTriggerSlopeBinding adapterTriggerSlopeBinding) {
            super(adapterTriggerSlopeBinding.getRoot());
            this.binding = adapterTriggerSlopeBinding;
        }
    }
}
