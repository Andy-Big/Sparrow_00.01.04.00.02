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
import com.rigol.scope.databinding.AdapterTriggerDurationBinding;
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
import com.rigol.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TriggerDurationAdapter extends RecyclerView.Adapter<TriggerDurationHolder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterTriggerDurationBinding binding;
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
    private int chSelect = -1;
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

    public TriggerDurationAdapter(Context context, BasePopupView basePopupView, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        this.triggerViewModel = triggerViewModel;
        this.param = triggerParam;
        this.popupView = basePopupView;
        this.context = context;
        this.serviceId = triggerParam.getServiceId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TriggerDurationHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterTriggerDurationBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelValue, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerDurationLimitUpValues, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerDurationLimitLowValues, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerHoldoff, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSource, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.TriggerDurationAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                TriggerDurationAdapter.this.aorBManager.showKey(TriggerDurationAdapter.this.context, ((AorBParam) TriggerDurationAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) TriggerDurationAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                TriggerDurationAdapter.this.aorBManager.showKey(TriggerDurationAdapter.this.context, ((AorBParam) TriggerDurationAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) TriggerDurationAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.triggerLevelValue, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.triggerDurationLimitLowValues, true, ViewUtil.KEY_B);
        this.aorBManager.set_RadioButton(0, 2);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerDurationAdapter$6i3tzS-LmR2CEXTk8FuqwGtORmE
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TriggerDurationAdapter.this.lambda$onCreateViewHolder$2$TriggerDurationAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new TriggerDurationHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$TriggerDurationAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (this.popviewTriggerBinding.triggerView.getAdapter() instanceof TriggerDurationAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerDurationAdapter$zJVn4ExlmkVRECbtB-TnPlIAg58
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerDurationAdapter.this.lambda$onCreateViewHolder$0$TriggerDurationAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerDurationAdapter$eewR0bbI0niXRvlb7om6TUPZvrc
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    TriggerDurationAdapter.this.lambda$onCreateViewHolder$1$TriggerDurationAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$TriggerDurationAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$TriggerDurationAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.trigger_source) {
            selectSource(i, mappingObject);
        }
    }

    private void selectSource(int i, MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveDurationSource(mappingObject.getValue());
            this.chSelect = mappingObject.getValue() - 1;
            this.param.setChannel(mappingObject.getValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TriggerDurationHolder triggerDurationHolder, int i) {
        ShowTriggerDuration();
        if (ViewUtil.isDoubleChanDecod()) {
            this.binding.ch3.setVisibility(8);
            this.binding.ch4.setVisibility(8);
            this.binding.valueCh3.setVisibility(8);
            this.binding.valueCh4.setVisibility(8);
        }
        triggerDurationHolder.binding.executePendingBindings();
    }

    public void ShowTriggerDuration() {
        this.param.setChan(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_DURATION_SOURCE)));
        ServiceEnum.Chan chan = this.param.getChan();
        if (chan == ServiceEnum.Chan.acline || chan == ServiceEnum.Chan.ext) {
            this.param.setChannel(ServiceEnum.Chan.chan1.value1);
            this.param.saveDurationSource(ServiceEnum.Chan.chan1.value1);
        } else {
            this.param.setChan(ServiceEnum.getChanFromValue1(chan.value1));
        }
        this.chSelect = this.param.getChan().value1 - 1;
        this.param.setChanColor(this.binding.triggerSource, chan);
        this.param.readDurationWhen();
        this.param.readDurationLwidth();
        this.param.readDurationUwidth();
        this.param.readdurationPatternValue();
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        this.binding.setParam(this.param);
        ViewUtil.setSwitchButton(this.binding.triggerNoiseSwitch);
        this.binding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.durationMorethan.setOnCheckedChangeListener(this);
        this.binding.durationLessthan.setOnCheckedChangeListener(this);
        this.binding.durationMoreless.setOnCheckedChangeListener(this);
        this.binding.durationUnmoreless.setOnCheckedChangeListener(this);
        this.binding.buttonLevel.setOnClickListener(this);
        this.binding.keyAll.setOnClickListener(this);
        this.binding.keyNext.setOnClickListener(this);
        this.binding.keyReturn.setOnClickListener(this);
        this.binding.keyZero.setOnClickListener(this);
        this.binding.keyOne.setOnClickListener(this);
        this.binding.keyX.setOnClickListener(this);
        this.binding.valueCh1.setOnClickListener(this);
        this.binding.valueCh2.setOnClickListener(this);
        this.binding.valueCh3.setOnClickListener(this);
        this.binding.valueCh4.setOnClickListener(this);
        this.binding.valueD0.setOnClickListener(this);
        this.binding.valueD1.setOnClickListener(this);
        this.binding.valueD2.setOnClickListener(this);
        this.binding.valueD3.setOnClickListener(this);
        this.binding.valueD4.setOnClickListener(this);
        this.binding.valueD5.setOnClickListener(this);
        this.binding.valueD6.setOnClickListener(this);
        this.binding.valueD7.setOnClickListener(this);
        this.binding.valueD8.setOnClickListener(this);
        this.binding.valueD9.setOnClickListener(this);
        this.binding.valueD10.setOnClickListener(this);
        this.binding.valueD11.setOnClickListener(this);
        this.binding.valueD12.setOnClickListener(this);
        this.binding.valueD13.setOnClickListener(this);
        this.binding.valueD14.setOnClickListener(this);
        this.binding.valueD15.setOnClickListener(this);
        this.binding.triggerSource.setOnClickListener(this);
        this.binding.triggerHoldoff.setOnClickListener(this);
        this.binding.triggerLevelValue.setOnClickListener(this);
        this.binding.triggerDurationLimitUpValues.setOnClickListener(this);
        this.binding.triggerDurationLimitLowValues.setOnClickListener(this);
        this.binding.triggerLevelView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.adapters.TriggerDurationAdapter.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    TriggerDurationAdapter.this.param.saveLevelSync((long) ((((seekBar.getProgress() / 100.0d) * (TriggerDurationAdapter.this.param.getChanScale() * TriggerDurationAdapter.this.param.getScaleNum())) - TriggerDurationAdapter.this.param.getChanOffset()) - ((TriggerDurationAdapter.this.param.getChanScale() * TriggerDurationAdapter.this.param.getScaleNum()) / 2)));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TriggerDurationAdapter.this.param.saveLevelSync((long) ((((seekBar.getProgress() / 100.0d) * (TriggerDurationAdapter.this.param.getChanScale() * TriggerDurationAdapter.this.param.getScaleNum())) - TriggerDurationAdapter.this.param.getChanOffset()) - ((TriggerDurationAdapter.this.param.getChanScale() * TriggerDurationAdapter.this.param.getScaleNum()) / 2)));
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
                case R.id.duration_lessthan /* 2131362718 */:
                    this.aorBManager.set_RadioButton(0, 1);
                    if (this.param != null) {
                        this.param.saveDurationWhen(z ? 2 : 0);
                        return;
                    }
                    return;
                case R.id.duration_moreless /* 2131362719 */:
                    this.aorBManager.set_RadioButton(0, 2);
                    if (this.param != null) {
                        this.param.saveDurationWhen(z ? 3 : 0);
                        return;
                    }
                    return;
                case R.id.duration_morethan /* 2131362720 */:
                    this.aorBManager.set_RadioButton(0, 2);
                    TriggerParam triggerParam = this.param;
                    if (triggerParam != null) {
                        triggerParam.saveDurationWhen(z ? 1 : 0);
                        return;
                    }
                    return;
                case R.id.duration_unmoreless /* 2131362721 */:
                    this.aorBManager.set_RadioButton(0, 2);
                    if (this.param != null) {
                        this.param.saveDurationWhen(z ? 4 : 0);
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
                    return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int id = view.getId();
        ServiceEnum.Chan chan = ServiceEnum.Chan.chan_none;
        int id2 = view.getId();
        switch (id2) {
            case R.id.auto_radio_button /* 2131361987 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1);
                break;
            case R.id.button_level /* 2131362192 */:
                if (this.context instanceof Activity) {
                    this.param.saveButtonLevel();
                    break;
                }
                break;
            case R.id.key_all /* 2131363213 */:
                if (this.chSelect != -1) {
                    int i2 = AnonymousClass7.$SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPattern[this.param.getChanDurationPattern()[this.param.getChan().value1 - 1].ordinal()];
                    if (i2 == 1) {
                        i = R.drawable.ic_trigger_one;
                        for (int i3 = 0; i3 < this.param.getChanDurationPattern().length; i3++) {
                            this.param.getChanDurationPattern()[i3] = ServiceEnum.TriggerPattern.Trigger_pat_h;
                        }
                    } else if (i2 == 2) {
                        i = R.drawable.ic_trigger_zero;
                        for (int i4 = 0; i4 < this.param.getChanDurationPattern().length; i4++) {
                            this.param.getChanDurationPattern()[i4] = ServiceEnum.TriggerPattern.Trigger_pat_l;
                        }
                    } else if (i2 != 3) {
                        i = R.drawable.ic_rising;
                    } else {
                        i = R.drawable.ic_trigger_x;
                        for (int i5 = 0; i5 < this.param.getChanDurationPattern().length; i5++) {
                            this.param.getChanDurationPattern()[i5] = ServiceEnum.TriggerPattern.Trigger_pat_x;
                        }
                    }
                    if (i == R.drawable.ic_rising) {
                        ToastUtils.showShort(this.context.getResources().getString(R.string.msg_input_invalid));
                        break;
                    } else {
                        this.binding.valueCh1.setImageResource(i);
                        this.binding.valueCh2.setImageResource(i);
                        this.binding.valueCh3.setImageResource(i);
                        this.binding.valueCh4.setImageResource(i);
                        this.binding.valueD0.setImageResource(i);
                        this.binding.valueD1.setImageResource(i);
                        this.binding.valueD2.setImageResource(i);
                        this.binding.valueD3.setImageResource(i);
                        this.binding.valueD4.setImageResource(i);
                        this.binding.valueD5.setImageResource(i);
                        this.binding.valueD6.setImageResource(i);
                        this.binding.valueD7.setImageResource(i);
                        this.binding.valueD8.setImageResource(i);
                        this.binding.valueD9.setImageResource(i);
                        this.binding.valueD10.setImageResource(i);
                        this.binding.valueD11.setImageResource(i);
                        this.binding.valueD12.setImageResource(i);
                        this.binding.valueD13.setImageResource(i);
                        this.binding.valueD14.setImageResource(i);
                        this.binding.valueD14.setImageResource(i);
                        this.binding.valueD15.setImageResource(i);
                        API.getInstance().UI_PostInt32(this.serviceId, MessageID.MSG_TRIGGER_DURATION_CODE_ALL, 0);
                        break;
                    }
                }
                break;
            case R.id.key_next /* 2131363226 */:
                this.chSelect++;
                List<MappingObject> filterChan = ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_source_la));
                if (filterChan.size() == 2) {
                    if (this.chSelect > 1) {
                        this.chSelect = 0;
                    }
                } else if (filterChan.size() == 4) {
                    if (this.chSelect > 3) {
                        this.chSelect = 0;
                    }
                } else {
                    if (this.chSelect == 4) {
                        this.chSelect = 8;
                    }
                    if (this.chSelect > 23) {
                        this.chSelect = 0;
                    }
                }
                ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(this.chSelect + 1);
                this.param.setChannel(this.chSelect + 1);
                this.param.setChanColor(this.binding.triggerSource, chanFromValue1);
                this.param.saveDurationSource(this.chSelect + 1);
                break;
            case R.id.normal_radio_button /* 2131363483 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1);
                break;
            case R.id.single_radio_button /* 2131363859 */:
                this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1);
                break;
            case R.id.trigger_duration_limit_low_values /* 2131364201 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readDurationLowerLimitAttr();
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getdurationLowerAttr().getMaxLongValue(), this.param.getdurationLowerAttr().getMinLongValue(), this.param.getdurationLowerAttr().getDefLongValue(), this.param.getDurationLowerLimit(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerDurationAdapter.6
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerDurationAdapter.this.param.saveDurationLowerLimit(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerDurationAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_duration_limit_up_values /* 2131364203 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readDurationUpperLimitAttr();
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getdurationUpperAttr().getMaxLongValue(), this.param.getdurationUpperAttr().getMinLongValue(), this.param.getdurationUpperAttr().getDefLongValue(), this.param.getDurationUperLimit(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerDurationAdapter.5
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerDurationAdapter.this.param.saveDurationUperLimit(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerDurationAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_holdoff /* 2131364231 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getHoldOffAttr().getMaxLongValue(), this.param.getHoldOffAttr().getMinLongValue(), this.param.getHoldOffAttr().getDefLongValue(), this.param.getHoldOff(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerDurationAdapter.3
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerDurationAdapter.this.param.saveholdOff(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerDurationAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_level_value /* 2131364280 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readLevelAttr();
                    TriggerParam triggerParam = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam.getChanUnit(triggerParam.getChannel()), this.param.getLevelAttr().getMaxLongValue(), this.param.getLevelAttr().getMinLongValue(), this.param.getLevelAttr().getDefLongValue(), this.param.getLevel(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerDurationAdapter.4
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerDurationAdapter.this.param.saveLevelSync(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerDurationAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source /* 2131364336 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_source_la)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerDurationAdapter$2Pgtogq4XLlg69iFu6xpfGIU6Bw
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerDurationAdapter.this.lambda$onClick$3$TriggerDurationAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerDurationAdapter$XTB0WJLzzwJpb5KrSqJNyX-htDA
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i6, Object obj) {
                            TriggerDurationAdapter.this.lambda$onClick$4$TriggerDurationAdapter(view2, viewHolder, i6, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            default:
                switch (id2) {
                    case R.id.key_one /* 2131363229 */:
                        int i6 = this.chSelect;
                        if (i6 != -1) {
                            this.param.saveDurationSource(i6 + 1);
                            this.chSelect = this.param.getChan().value1 - 1;
                            this.param.getChanDurationPattern()[this.chSelect] = ServiceEnum.TriggerPattern.Trigger_pat_h;
                            TriggerParam triggerParam2 = this.param;
                            triggerParam2.setChanDurationPattern(triggerParam2.getChanDurationPattern());
                            this.param.saveDurationCode(ServiceEnum.TriggerPattern.Trigger_pat_h.value1);
                            break;
                        }
                        break;
                    case R.id.key_return /* 2131363230 */:
                        this.chSelect--;
                        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(11, MessageID.MSG_APP_UTILITY_CHANNEL_COUNT);
                        List<MappingObject> filterChan2 = ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_source_la));
                        if (filterChan2.size() == 2) {
                            if (UI_QueryInt32 == 2 && this.chSelect < 0) {
                                this.chSelect = 1;
                            }
                        } else if (filterChan2.size() == 4) {
                            if (this.chSelect < 0) {
                                this.chSelect = 3;
                            }
                        } else {
                            if (this.chSelect == 7) {
                                this.chSelect = 3;
                            }
                            if (this.chSelect < 0) {
                                this.chSelect = 23;
                            }
                        }
                        ServiceEnum.Chan chanFromValue12 = ServiceEnum.getChanFromValue1(this.chSelect + 1);
                        this.param.setChannel(this.chSelect + 1);
                        this.param.setChanColor(this.binding.triggerSource, chanFromValue12);
                        this.param.saveDurationSource(this.chSelect + 1);
                        break;
                    default:
                        switch (id2) {
                            case R.id.key_x /* 2131363237 */:
                                int i7 = this.chSelect;
                                if (i7 != -1) {
                                    this.param.saveDurationSource(i7 + 1);
                                    this.chSelect = this.param.getChan().value1 - 1;
                                    this.param.getChanDurationPattern()[this.chSelect] = ServiceEnum.TriggerPattern.Trigger_pat_x;
                                    TriggerParam triggerParam3 = this.param;
                                    triggerParam3.setChanDurationPattern(triggerParam3.getChanDurationPattern());
                                    this.param.saveDurationCode(ServiceEnum.TriggerPattern.Trigger_pat_x.value1);
                                    break;
                                }
                                break;
                            case R.id.key_zero /* 2131363238 */:
                                int i8 = this.chSelect;
                                if (i8 != -1) {
                                    this.param.saveDurationSource(i8 + 1);
                                    this.chSelect = this.param.getChan().value1 - 1;
                                    this.param.getChanDurationPattern()[this.chSelect] = ServiceEnum.TriggerPattern.Trigger_pat_l;
                                    TriggerParam triggerParam4 = this.param;
                                    triggerParam4.setChanDurationPattern(triggerParam4.getChanDurationPattern());
                                    this.param.saveDurationCode(ServiceEnum.TriggerPattern.Trigger_pat_l.value1);
                                    break;
                                }
                                break;
                            default:
                                switch (id2) {
                                    case R.id.value_ch1 /* 2131364536 */:
                                        this.chSelect = 0;
                                        ServiceEnum.Chan chanFromValue13 = ServiceEnum.getChanFromValue1(0 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue13);
                                        TriggerParam triggerParam5 = this.param;
                                        triggerParam5.saveDurationCode(triggerParam5.getChanDurationPattern()[0].value1);
                                        break;
                                    case R.id.value_ch2 /* 2131364537 */:
                                        this.chSelect = 1;
                                        ServiceEnum.Chan chanFromValue14 = ServiceEnum.getChanFromValue1(1 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue14);
                                        TriggerParam triggerParam6 = this.param;
                                        triggerParam6.saveDurationCode(triggerParam6.getChanDurationPattern()[1].value1);
                                        break;
                                    case R.id.value_ch3 /* 2131364538 */:
                                        this.chSelect = 2;
                                        ServiceEnum.Chan chanFromValue15 = ServiceEnum.getChanFromValue1(2 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue15);
                                        TriggerParam triggerParam7 = this.param;
                                        triggerParam7.saveDurationCode(triggerParam7.getChanDurationPattern()[2].value1);
                                        break;
                                    case R.id.value_ch4 /* 2131364539 */:
                                        this.chSelect = 3;
                                        ServiceEnum.Chan chanFromValue16 = ServiceEnum.getChanFromValue1(3 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue16);
                                        TriggerParam triggerParam8 = this.param;
                                        triggerParam8.saveDurationCode(triggerParam8.getChanDurationPattern()[3].value1);
                                        break;
                                    case R.id.value_d0 /* 2131364540 */:
                                        this.chSelect = 8;
                                        ServiceEnum.Chan chanFromValue17 = ServiceEnum.getChanFromValue1(8 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue17);
                                        TriggerParam triggerParam9 = this.param;
                                        triggerParam9.saveDurationCode(triggerParam9.getChanDurationPattern()[3].value1);
                                        break;
                                    case R.id.value_d1 /* 2131364541 */:
                                        this.chSelect = 9;
                                        ServiceEnum.Chan chanFromValue18 = ServiceEnum.getChanFromValue1(9 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue18);
                                        TriggerParam triggerParam10 = this.param;
                                        triggerParam10.saveDurationCode(triggerParam10.getChanDurationPattern()[3].value1);
                                        break;
                                    case R.id.value_d10 /* 2131364542 */:
                                        this.chSelect = 18;
                                        ServiceEnum.Chan chanFromValue19 = ServiceEnum.getChanFromValue1(18 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue19);
                                        TriggerParam triggerParam11 = this.param;
                                        triggerParam11.saveDurationCode(triggerParam11.getChanDurationPattern()[3].value1);
                                        break;
                                    case R.id.value_d11 /* 2131364543 */:
                                        this.chSelect = 19;
                                        ServiceEnum.Chan chanFromValue110 = ServiceEnum.getChanFromValue1(19 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue110);
                                        TriggerParam triggerParam12 = this.param;
                                        triggerParam12.saveDurationCode(triggerParam12.getChanDurationPattern()[3].value1);
                                        break;
                                    case R.id.value_d12 /* 2131364544 */:
                                        this.chSelect = 20;
                                        ServiceEnum.Chan chanFromValue111 = ServiceEnum.getChanFromValue1(20 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue111);
                                        TriggerParam triggerParam13 = this.param;
                                        triggerParam13.saveDurationCode(triggerParam13.getChanDurationPattern()[3].value1);
                                        break;
                                    case R.id.value_d13 /* 2131364545 */:
                                        this.chSelect = 21;
                                        ServiceEnum.Chan chanFromValue112 = ServiceEnum.getChanFromValue1(21 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue112);
                                        TriggerParam triggerParam14 = this.param;
                                        triggerParam14.saveDurationCode(triggerParam14.getChanDurationPattern()[3].value1);
                                        break;
                                    case R.id.value_d14 /* 2131364546 */:
                                        this.chSelect = 22;
                                        ServiceEnum.Chan chanFromValue113 = ServiceEnum.getChanFromValue1(22 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue113);
                                        TriggerParam triggerParam15 = this.param;
                                        triggerParam15.saveDurationCode(triggerParam15.getChanDurationPattern()[3].value1);
                                        break;
                                    case R.id.value_d15 /* 2131364547 */:
                                        this.chSelect = 23;
                                        ServiceEnum.Chan chanFromValue114 = ServiceEnum.getChanFromValue1(23 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue114);
                                        TriggerParam triggerParam16 = this.param;
                                        triggerParam16.saveDurationCode(triggerParam16.getChanDurationPattern()[3].value1);
                                        break;
                                    case R.id.value_d2 /* 2131364548 */:
                                        this.chSelect = 10;
                                        ServiceEnum.Chan chanFromValue115 = ServiceEnum.getChanFromValue1(10 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue115);
                                        TriggerParam triggerParam17 = this.param;
                                        triggerParam17.saveDurationCode(triggerParam17.getChanDurationPattern()[3].value1);
                                        break;
                                    case R.id.value_d3 /* 2131364549 */:
                                        this.chSelect = 11;
                                        ServiceEnum.Chan chanFromValue116 = ServiceEnum.getChanFromValue1(11 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue116);
                                        TriggerParam triggerParam18 = this.param;
                                        triggerParam18.saveDurationCode(triggerParam18.getChanDurationPattern()[3].value1);
                                        break;
                                    case R.id.value_d4 /* 2131364550 */:
                                        this.chSelect = 12;
                                        ServiceEnum.Chan chanFromValue117 = ServiceEnum.getChanFromValue1(12 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue117);
                                        TriggerParam triggerParam19 = this.param;
                                        triggerParam19.saveDurationCode(triggerParam19.getChanDurationPattern()[3].value1);
                                        break;
                                    case R.id.value_d5 /* 2131364551 */:
                                        this.chSelect = 13;
                                        ServiceEnum.Chan chanFromValue118 = ServiceEnum.getChanFromValue1(13 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue118);
                                        TriggerParam triggerParam20 = this.param;
                                        triggerParam20.saveDurationCode(triggerParam20.getChanDurationPattern()[3].value1);
                                        break;
                                    case R.id.value_d6 /* 2131364552 */:
                                        this.chSelect = 14;
                                        ServiceEnum.Chan chanFromValue119 = ServiceEnum.getChanFromValue1(14 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue119);
                                        TriggerParam triggerParam21 = this.param;
                                        triggerParam21.saveDurationCode(triggerParam21.getChanDurationPattern()[3].value1);
                                        break;
                                    case R.id.value_d7 /* 2131364553 */:
                                        this.chSelect = 15;
                                        ServiceEnum.Chan chanFromValue120 = ServiceEnum.getChanFromValue1(15 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue120);
                                        TriggerParam triggerParam22 = this.param;
                                        triggerParam22.saveDurationCode(triggerParam22.getChanDurationPattern()[3].value1);
                                        break;
                                    case R.id.value_d8 /* 2131364554 */:
                                        this.chSelect = 16;
                                        ServiceEnum.Chan chanFromValue121 = ServiceEnum.getChanFromValue1(16 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue121);
                                        TriggerParam triggerParam23 = this.param;
                                        triggerParam23.saveDurationCode(triggerParam23.getChanDurationPattern()[3].value1);
                                        break;
                                    case R.id.value_d9 /* 2131364555 */:
                                        this.chSelect = 17;
                                        ServiceEnum.Chan chanFromValue122 = ServiceEnum.getChanFromValue1(17 + 1);
                                        this.param.setChannel(this.chSelect + 1);
                                        this.param.saveDurationSource(this.chSelect + 1);
                                        this.param.setChanColor(this.binding.triggerSource, chanFromValue122);
                                        TriggerParam triggerParam24 = this.param;
                                        triggerParam24.saveDurationCode(triggerParam24.getChanDurationPattern()[3].value1);
                                        break;
                                }
                        }
                }
        }
        AorBManager.OnOutOrInAdapterClickChangeListener onOutOrInAdapterClickChangeListener = this.listener;
        if (onOutOrInAdapterClickChangeListener != null) {
            onOutOrInAdapterClickChangeListener.onChange(false);
        }
    }

    public /* synthetic */ void lambda$onClick$3$TriggerDurationAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$TriggerDurationAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSource(i, mappingObject);
    }

    /* renamed from: com.rigol.scope.adapters.TriggerDurationAdapter$7  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPattern;

        static {
            int[] iArr = new int[ServiceEnum.TriggerPattern.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPattern = iArr;
            try {
                iArr[ServiceEnum.TriggerPattern.Trigger_pat_h.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPattern[ServiceEnum.TriggerPattern.Trigger_pat_l.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPattern[ServiceEnum.TriggerPattern.Trigger_pat_x.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        switch (i) {
            case R.id.trigger_duration_limit_low_values /* 2131364201 */:
                this.param.readDurationLowerLimitAttr();
                TriggerParam triggerParam = this.param;
                triggerParam.saveDurationLowerLimit(triggerParam.getLongStep(triggerParam.getDurationLowerLimit(), this.param.getdurationLowerAttr(), z, keyEvent));
                return;
            case R.id.trigger_duration_limit_up_values /* 2131364203 */:
                this.param.readDurationUpperLimitAttr();
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveDurationUperLimit(triggerParam2.getLongStep(triggerParam2.getDurationUperLimit(), this.param.getdurationUpperAttr(), z, keyEvent));
                return;
            case R.id.trigger_holdoff /* 2131364231 */:
                this.param.readHoldOffAttr();
                TriggerParam triggerParam3 = this.param;
                triggerParam3.saveholdOff(triggerParam3.getLongStep(triggerParam3.getHoldOff(), this.param.getHoldOffAttr(), z, keyEvent));
                return;
            case R.id.trigger_level_value /* 2131364280 */:
                TriggerParam triggerParam4 = this.param;
                triggerParam4.rollTriggerLevel(keyEvent, z, this.panelKeyViewModel, triggerParam4);
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
            case R.id.trigger_duration_limit_low_values /* 2131364201 */:
                this.param.readDurationLowerLimitAttr();
                TriggerParam triggerParam = this.param;
                triggerParam.saveDurationLowerLimit(triggerParam.getLongDef(triggerParam.getdurationLowerAttr()));
                return;
            case R.id.trigger_duration_limit_up_values /* 2131364203 */:
                this.param.readDurationUpperLimitAttr();
                TriggerParam triggerParam2 = this.param;
                triggerParam2.saveDurationUperLimit(triggerParam2.getLongDef(triggerParam2.getdurationUpperAttr()));
                return;
            case R.id.trigger_holdoff /* 2131364231 */:
                TriggerParam triggerParam3 = this.param;
                triggerParam3.saveholdOff(triggerParam3.getLongDef(triggerParam3.getHoldOffAttr()));
                return;
            case R.id.trigger_level_value /* 2131364280 */:
                TriggerParam triggerParam4 = this.param;
                triggerParam4.saveLevelSync(triggerParam4.getLongDef(triggerParam4.getLevelAttr()));
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public class TriggerDurationHolder extends RecyclerView.ViewHolder {
        private AdapterTriggerDurationBinding binding;

        public TriggerDurationHolder(AdapterTriggerDurationBinding adapterTriggerDurationBinding) {
            super(adapterTriggerDurationBinding.getRoot());
            this.binding = adapterTriggerDurationBinding;
        }
    }
}
