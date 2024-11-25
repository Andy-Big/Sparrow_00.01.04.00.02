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
import com.rigol.scope.databinding.AdapterTriggerPatternBinding;
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
public class TriggerPatternAdapter extends RecyclerView.Adapter<TriggerPatternHolder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterTriggerPatternBinding binding;
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
    private boolean[] chEdgeIndex = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
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

    public TriggerPatternAdapter(Context context, BasePopupView basePopupView, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        this.triggerViewModel = triggerViewModel;
        this.param = triggerParam;
        this.popupView = basePopupView;
        this.context = context;
        this.serviceId = triggerParam.getServiceId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TriggerPatternHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterTriggerPatternBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerHoldoff, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSource, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.TriggerPatternAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                TriggerPatternAdapter.this.aorBManager.showKey(TriggerPatternAdapter.this.context, ((AorBParam) TriggerPatternAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) TriggerPatternAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                TriggerPatternAdapter.this.aorBManager.showKey(TriggerPatternAdapter.this.context, ((AorBParam) TriggerPatternAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) TriggerPatternAdapter.this.list_aorbParam.get(i2)).getAorb());
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
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerPatternAdapter$52mC0T55cdr7h6UYRmSvMJocqiA
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TriggerPatternAdapter.this.lambda$onCreateViewHolder$2$TriggerPatternAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new TriggerPatternHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$TriggerPatternAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (this.popviewTriggerBinding.triggerView.getAdapter() instanceof TriggerPatternAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerPatternAdapter$hLXK-v6CXxcp9FLeSoHRyqoU2N4
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerPatternAdapter.this.lambda$onCreateViewHolder$0$TriggerPatternAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerPatternAdapter$dstdCFNHsJulvhQU7Cni8FuzzdE
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    TriggerPatternAdapter.this.lambda$onCreateViewHolder$1$TriggerPatternAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$TriggerPatternAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$TriggerPatternAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.trigger_source) {
            selectSource(i, mappingObject);
        }
    }

    private void selectSource(int i, MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.savePatternSource(mappingObject.getValue());
            this.chSelect = mappingObject.getValue() - 1;
            this.param.setChannel(mappingObject.getValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TriggerPatternHolder triggerPatternHolder, int i) {
        ShowTriggerPattern();
        if (ViewUtil.isDoubleChanDecod()) {
            this.binding.ch3.setVisibility(8);
            this.binding.ch4.setVisibility(8);
            this.binding.valueCh3.setVisibility(8);
            this.binding.valueCh4.setVisibility(8);
        }
        triggerPatternHolder.binding.executePendingBindings();
    }

    public void ShowTriggerPattern() {
        this.param.setChan(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_PATTERN_SOURCE)));
        ServiceEnum.Chan chan = this.param.getChan();
        if (chan == ServiceEnum.Chan.acline || chan == ServiceEnum.Chan.ext) {
            this.param.savePatternSource(ServiceEnum.Chan.chan1.value1);
            this.param.setChannel(ServiceEnum.Chan.chan1.value1);
        } else {
            this.param.setChan(ServiceEnum.getChanFromValue1(chan.value1));
        }
        this.chSelect = this.param.getChan().value1 - 1;
        this.param.setChanColor(this.binding.triggerSource, chan);
        this.param.readpatternValue();
        String UI_QueryStr = API.getInstance().UI_QueryStr(41, MessageID.CMD_SCPI_PATTERN_GET_CODE);
        if (!UI_QueryStr.contains("R") && !UI_QueryStr.contains("F")) {
            boolean[] zArr = this.chEdgeIndex;
            zArr[0] = false;
            zArr[1] = false;
            zArr[2] = false;
            zArr[3] = false;
        }
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        this.binding.setParam(this.param);
        ViewUtil.setSwitchButton(this.binding.triggerNoiseSwitch);
        this.binding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.buttonLevel.setOnClickListener(this);
        this.binding.keyRising.setOnClickListener(this);
        this.binding.keyFalling.setOnClickListener(this);
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
        this.binding.triggerLevelView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.adapters.TriggerPatternAdapter.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    TriggerPatternAdapter.this.param.saveLevelSync((long) ((((seekBar.getProgress() / 100.0d) * (TriggerPatternAdapter.this.param.getChanScale() * TriggerPatternAdapter.this.param.getScaleNum())) - TriggerPatternAdapter.this.param.getChanOffset()) - ((TriggerPatternAdapter.this.param.getChanScale() * TriggerPatternAdapter.this.param.getScaleNum()) / 2)));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TriggerPatternAdapter.this.param.saveLevelSync((long) ((((seekBar.getProgress() / 100.0d) * (TriggerPatternAdapter.this.param.getChanScale() * TriggerPatternAdapter.this.param.getScaleNum())) - TriggerPatternAdapter.this.param.getChanOffset()) - ((TriggerPatternAdapter.this.param.getChanScale() * TriggerPatternAdapter.this.param.getScaleNum()) / 2)));
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
                    ServiceEnum.TriggerPattern triggerPattern = this.param.getChanPattern()[this.param.getChan().value1 - 1];
                    int i = R.drawable.ic_rising;
                    int i2 = AnonymousClass5.$SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPattern[triggerPattern.ordinal()];
                    if (i2 == 1) {
                        i = R.drawable.ic_trigger_one;
                        for (int i3 = 0; i3 < this.param.getChanPattern().length; i3++) {
                            this.param.getChanPattern()[i3] = ServiceEnum.TriggerPattern.Trigger_pat_h;
                        }
                    } else if (i2 == 2) {
                        i = R.drawable.ic_trigger_zero;
                        for (int i4 = 0; i4 < this.param.getChanPattern().length; i4++) {
                            this.param.getChanPattern()[i4] = ServiceEnum.TriggerPattern.Trigger_pat_l;
                        }
                    } else if (i2 == 3) {
                        i = R.drawable.ic_trigger_x;
                        for (int i5 = 0; i5 < this.param.getChanPattern().length; i5++) {
                            this.param.getChanPattern()[i5] = ServiceEnum.TriggerPattern.Trigger_pat_x;
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
                        this.binding.valueD15.setImageResource(i);
                        for (int i6 = 0; i6 < 4; i6++) {
                            this.chEdgeIndex[i6] = false;
                        }
                        API.getInstance().UI_PostInt32(this.serviceId, MessageID.MSG_TRIGGER_PATTERN_CODE_ALL, 0);
                        break;
                    }
                }
                break;
            case R.id.key_falling /* 2131363222 */:
                if (this.chSelect != -1) {
                    int i7 = 0;
                    while (i7 < 24 && !this.chEdgeIndex[i7]) {
                        i7++;
                    }
                    this.param.savePatternSource(this.chSelect + 1);
                    int i8 = this.param.getChan().value1 - 1;
                    this.chSelect = i8;
                    if ((i8 == i7 && this.chEdgeIndex[i8]) || i7 == 24) {
                        this.param.getChanPattern()[this.chSelect] = ServiceEnum.TriggerPattern.Trigger_pat_fall;
                        TriggerParam triggerParam = this.param;
                        triggerParam.setChanPattern(triggerParam.getChanPattern());
                        int i9 = this.param.getChan().value1 - 1;
                        this.chSelect = i9;
                        this.chEdgeIndex[i9] = true;
                        this.param.savePatternCode(ServiceEnum.TriggerPattern.Trigger_pat_fall.value1);
                        break;
                    } else {
                        ToastUtils.showShort(this.context.getResources().getString(R.string.msg_input_invalid));
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
                this.param.savePatternSource(this.chSelect + 1);
                break;
            case R.id.key_rising /* 2131363232 */:
                if (this.chSelect != -1) {
                    int i10 = 0;
                    while (i10 < 24 && !this.chEdgeIndex[i10]) {
                        i10++;
                    }
                    this.param.savePatternSource(this.chSelect + 1);
                    int i11 = this.param.getChan().value1 - 1;
                    this.chSelect = i11;
                    if ((i11 == i10 && this.chEdgeIndex[i11]) || i10 == 24) {
                        this.chSelect = this.param.getChan().value1 - 1;
                        this.param.getChanPattern()[this.chSelect] = ServiceEnum.TriggerPattern.Trigger_pat_rise;
                        TriggerParam triggerParam2 = this.param;
                        triggerParam2.setChanPattern(triggerParam2.getChanPattern());
                        this.chEdgeIndex[this.chSelect] = true;
                        this.param.savePatternCode(ServiceEnum.TriggerPattern.Trigger_pat_rise.value1);
                        break;
                    } else {
                        ToastUtils.showShort(this.context.getResources().getString(R.string.msg_input_invalid));
                        break;
                    }
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
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.param.getHoldOffAttr().getMaxLongValue(), this.param.getHoldOffAttr().getMinLongValue(), this.param.getHoldOffAttr().getDefLongValue(), this.param.getHoldOff(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerPatternAdapter.3
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerPatternAdapter.this.param.saveholdOff(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerPatternAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_level_value /* 2131364280 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readLevelAttr();
                    TriggerParam triggerParam3 = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam3.getChanUnit(triggerParam3.getChannel()), this.param.getLevelAttr().getMaxLongValue(), this.param.getLevelAttr().getMinLongValue(), this.param.getLevelAttr().getDefLongValue(), this.param.getLevel(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerPatternAdapter.4
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerPatternAdapter.this.param.saveLevelSync(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerPatternAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source /* 2131364336 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_source_la)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerPatternAdapter$H8WwXr7l53oAkpNI2_0U4QBCraY
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerPatternAdapter.this.lambda$onClick$3$TriggerPatternAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerPatternAdapter$6E-rE5Dr3X_0aFKfzpjXAQORngk
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i12, Object obj) {
                            TriggerPatternAdapter.this.lambda$onClick$4$TriggerPatternAdapter(view2, viewHolder, i12, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            default:
                switch (id2) {
                    case R.id.key_one /* 2131363229 */:
                        int i12 = this.chSelect;
                        if (i12 != -1) {
                            this.param.savePatternSource(i12 + 1);
                            this.chSelect = this.param.getChan().value1 - 1;
                            this.param.getChanPattern()[this.chSelect] = ServiceEnum.TriggerPattern.Trigger_pat_h;
                            TriggerParam triggerParam4 = this.param;
                            triggerParam4.setChanPattern(triggerParam4.getChanPattern());
                            this.chEdgeIndex[this.chSelect] = false;
                            this.param.savePatternCode(ServiceEnum.TriggerPattern.Trigger_pat_h.value1);
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
                        this.param.savePatternSource(this.chSelect + 1);
                        break;
                    default:
                        switch (id2) {
                            case R.id.key_x /* 2131363237 */:
                                int i13 = this.chSelect;
                                if (i13 != -1) {
                                    this.param.savePatternSource(i13 + 1);
                                    this.chSelect = this.param.getChan().value1 - 1;
                                    this.param.getChanPattern()[this.chSelect] = ServiceEnum.TriggerPattern.Trigger_pat_x;
                                    TriggerParam triggerParam5 = this.param;
                                    triggerParam5.setChanPattern(triggerParam5.getChanPattern());
                                    this.chEdgeIndex[this.chSelect] = false;
                                    this.param.savePatternCode(ServiceEnum.TriggerPattern.Trigger_pat_x.value1);
                                    break;
                                }
                                break;
                            case R.id.key_zero /* 2131363238 */:
                                int i14 = this.chSelect;
                                if (i14 != -1) {
                                    this.param.savePatternSource(i14 + 1);
                                    this.chSelect = this.param.getChan().value1 - 1;
                                    this.param.getChanPattern()[this.chSelect] = ServiceEnum.TriggerPattern.Trigger_pat_l;
                                    TriggerParam triggerParam6 = this.param;
                                    triggerParam6.setChanPattern(triggerParam6.getChanPattern());
                                    this.chEdgeIndex[this.chSelect] = false;
                                    this.param.savePatternCode(ServiceEnum.TriggerPattern.Trigger_pat_l.value1);
                                    break;
                                }
                                break;
                            default:
                                switch (id2) {
                                    case R.id.value_ch1 /* 2131364536 */:
                                        this.chSelect = 0;
                                        this.param.setChannel(0 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam7 = this.param;
                                        triggerParam7.savePatternCode(triggerParam7.getChanPattern()[0].value1);
                                        break;
                                    case R.id.value_ch2 /* 2131364537 */:
                                        this.chSelect = 1;
                                        this.param.setChannel(1 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam8 = this.param;
                                        triggerParam8.savePatternCode(triggerParam8.getChanPattern()[1].value1);
                                        break;
                                    case R.id.value_ch3 /* 2131364538 */:
                                        this.chSelect = 2;
                                        this.param.setChannel(2 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam9 = this.param;
                                        triggerParam9.savePatternCode(triggerParam9.getChanPattern()[2].value1);
                                        break;
                                    case R.id.value_ch4 /* 2131364539 */:
                                        this.chSelect = 3;
                                        this.param.setChannel(3 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam10 = this.param;
                                        triggerParam10.savePatternCode(triggerParam10.getChanPattern()[3].value1);
                                        break;
                                    case R.id.value_d0 /* 2131364540 */:
                                        this.chSelect = 8;
                                        this.param.setChannel(8 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam11 = this.param;
                                        triggerParam11.savePatternCode(triggerParam11.getChanPattern()[8].value1);
                                        break;
                                    case R.id.value_d1 /* 2131364541 */:
                                        this.chSelect = 9;
                                        this.param.setChannel(9 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam12 = this.param;
                                        triggerParam12.savePatternCode(triggerParam12.getChanPattern()[9].value1);
                                        break;
                                    case R.id.value_d10 /* 2131364542 */:
                                        this.chSelect = 18;
                                        this.param.setChannel(18 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam13 = this.param;
                                        triggerParam13.savePatternCode(triggerParam13.getChanPattern()[18].value1);
                                        break;
                                    case R.id.value_d11 /* 2131364543 */:
                                        this.chSelect = 19;
                                        this.param.setChannel(19 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam14 = this.param;
                                        triggerParam14.savePatternCode(triggerParam14.getChanPattern()[19].value1);
                                        break;
                                    case R.id.value_d12 /* 2131364544 */:
                                        this.chSelect = 20;
                                        this.param.setChannel(20 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam15 = this.param;
                                        triggerParam15.savePatternCode(triggerParam15.getChanPattern()[20].value1);
                                        break;
                                    case R.id.value_d13 /* 2131364545 */:
                                        this.chSelect = 21;
                                        this.param.setChannel(21 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam16 = this.param;
                                        triggerParam16.savePatternCode(triggerParam16.getChanPattern()[21].value1);
                                        break;
                                    case R.id.value_d14 /* 2131364546 */:
                                        this.chSelect = 22;
                                        this.param.setChannel(22 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam17 = this.param;
                                        triggerParam17.savePatternCode(triggerParam17.getChanPattern()[22].value1);
                                        break;
                                    case R.id.value_d15 /* 2131364547 */:
                                        this.chSelect = 23;
                                        this.param.setChannel(23 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam18 = this.param;
                                        triggerParam18.savePatternCode(triggerParam18.getChanPattern()[23].value1);
                                        break;
                                    case R.id.value_d2 /* 2131364548 */:
                                        this.chSelect = 10;
                                        this.param.setChannel(10 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam19 = this.param;
                                        triggerParam19.savePatternCode(triggerParam19.getChanPattern()[10].value1);
                                        break;
                                    case R.id.value_d3 /* 2131364549 */:
                                        this.chSelect = 11;
                                        this.param.setChannel(11 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam20 = this.param;
                                        triggerParam20.savePatternCode(triggerParam20.getChanPattern()[11].value1);
                                        break;
                                    case R.id.value_d4 /* 2131364550 */:
                                        this.chSelect = 12;
                                        this.param.setChannel(12 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam21 = this.param;
                                        triggerParam21.savePatternCode(triggerParam21.getChanPattern()[12].value1);
                                        break;
                                    case R.id.value_d5 /* 2131364551 */:
                                        this.chSelect = 13;
                                        this.param.setChannel(13 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam22 = this.param;
                                        triggerParam22.savePatternCode(triggerParam22.getChanPattern()[13].value1);
                                        break;
                                    case R.id.value_d6 /* 2131364552 */:
                                        this.chSelect = 14;
                                        this.param.setChannel(14 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam23 = this.param;
                                        triggerParam23.savePatternCode(triggerParam23.getChanPattern()[14].value1);
                                        break;
                                    case R.id.value_d7 /* 2131364553 */:
                                        this.chSelect = 15;
                                        this.param.setChannel(15 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam24 = this.param;
                                        triggerParam24.savePatternCode(triggerParam24.getChanPattern()[15].value1);
                                        break;
                                    case R.id.value_d8 /* 2131364554 */:
                                        this.chSelect = 16;
                                        this.param.setChannel(16 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam25 = this.param;
                                        triggerParam25.savePatternCode(triggerParam25.getChanPattern()[16].value1);
                                        break;
                                    case R.id.value_d9 /* 2131364555 */:
                                        this.chSelect = 17;
                                        this.param.setChannel(17 + 1);
                                        this.param.setChanColor(this.binding.triggerSource, ServiceEnum.getChanFromValue1(this.chSelect + 1));
                                        this.param.savePatternSource(this.chSelect + 1);
                                        TriggerParam triggerParam26 = this.param;
                                        triggerParam26.savePatternCode(triggerParam26.getChanPattern()[17].value1);
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

    public /* synthetic */ void lambda$onClick$3$TriggerPatternAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$TriggerPatternAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSource(i, mappingObject);
    }

    /* renamed from: com.rigol.scope.adapters.TriggerPatternAdapter$5  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass5 {
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
        if (i == R.id.trigger_holdoff) {
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
            TriggerParam triggerParam = this.param;
            triggerParam.saveholdOff(triggerParam.getLongDef(triggerParam.getHoldOffAttr()));
        } else if (i != R.id.trigger_level_value) {
        } else {
            TriggerParam triggerParam2 = this.param;
            triggerParam2.saveLevelSync(triggerParam2.getLongDef(triggerParam2.getLevelAttr()));
        }
    }

    /* loaded from: classes.dex */
    public class TriggerPatternHolder extends RecyclerView.ViewHolder {
        private AdapterTriggerPatternBinding binding;

        public TriggerPatternHolder(AdapterTriggerPatternBinding adapterTriggerPatternBinding) {
            super(adapterTriggerPatternBinding.getRoot());
            this.binding = adapterTriggerPatternBinding;
        }
    }
}
