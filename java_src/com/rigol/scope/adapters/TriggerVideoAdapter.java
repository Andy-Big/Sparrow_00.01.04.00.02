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
import com.rigol.scope.databinding.AdapterTriggerVideoBinding;
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
public class TriggerVideoAdapter extends RecyclerView.Adapter<TriggerVideoHolder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterTriggerVideoBinding binding;
    private View clickedView;
    private Context context;
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

    public TriggerVideoAdapter(Context context, BasePopupView basePopupView, TriggerParam triggerParam, TriggerViewModel triggerViewModel) {
        this.triggerViewModel = triggerViewModel;
        this.param = triggerParam;
        this.popupView = basePopupView;
        this.context = context;
        this.serviceId = triggerParam.getServiceId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TriggerVideoHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterTriggerVideoBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.triggerLevelValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.linesNumberValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSource, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.videoStandardValue, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.TriggerVideoAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                TriggerVideoAdapter.this.aorBManager.showKey(TriggerVideoAdapter.this.context, ((AorBParam) TriggerVideoAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) TriggerVideoAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                TriggerVideoAdapter.this.aorBManager.showKey(TriggerVideoAdapter.this.context, ((AorBParam) TriggerVideoAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) TriggerVideoAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.triggerLevelValue, true, ViewUtil.KEY_A);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerVideoAdapter$WefL5Ryt-RdYl-wY3luPf51kOl8
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TriggerVideoAdapter.this.lambda$onCreateViewHolder$2$TriggerVideoAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new TriggerVideoHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$TriggerVideoAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class) && (this.popviewTriggerBinding.triggerView.getAdapter() instanceof TriggerVideoAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerVideoAdapter$_lOhBUW3SjKq14P_eG5ybR0ONt8
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    TriggerVideoAdapter.this.lambda$onCreateViewHolder$0$TriggerVideoAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerVideoAdapter$g1z9IA3jV30lW5d8hpa-CKarulQ
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    TriggerVideoAdapter.this.lambda$onCreateViewHolder$1$TriggerVideoAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$TriggerVideoAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$TriggerVideoAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.trigger_source) {
            selectSource(mappingObject);
        } else if (this.clickedView.getId() == R.id.video_standard_value) {
            selectStandard(mappingObject);
        }
    }

    private void selectSource(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveVideoSource(mappingObject.getValue());
            this.param.setChannel(mappingObject.getValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TriggerVideoHolder triggerVideoHolder, int i) {
        ShowTriggerVideo();
        triggerVideoHolder.binding.executePendingBindings();
    }

    public void ShowTriggerVideo() {
        ServiceEnum.Chan chan = this.param.getChan();
        if (chan == ServiceEnum.Chan.acline || chan == ServiceEnum.Chan.ext) {
            this.param.saveVideoSource(ServiceEnum.Chan.chan1.value1);
            this.param.setChannel(ServiceEnum.Chan.chan1.value1);
        } else {
            this.param.setChan(ServiceEnum.getChanFromValue1(chan.value1));
        }
        this.param.setChanColor(this.binding.triggerSource, chan);
        this.binding.setSweepAutoMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1));
        this.binding.setSweepNormalMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1));
        this.binding.setSweepSingleMapping(ViewUtil.getMappingObject(R.array.msg_trigger_sweep, ServiceEnum.TriggerSweep.Trigger_Sweep_Single.value1));
        this.binding.setPolarityPositiveMapping(ViewUtil.getMappingObject(R.array.msg_trigger_polarity, ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive.value1));
        this.binding.setPolarityNegativeMapping(ViewUtil.getMappingObject(R.array.msg_trigger_polarity, ServiceEnum.TriggerPulsePolarity.Trigger_pulse_negative.value1));
        this.param.readVideoStandard();
        this.param.readVideoSync();
        this.param.readVideoLine();
        this.param.readVideoPolarity();
        this.binding.setParam(this.param);
        this.aorBManager.set_RadioButton();
        ViewUtil.setSwitchButton(this.binding.triggerNoiseSwitch);
        this.binding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.lines.setOnCheckedChangeListener(this);
        this.binding.allLines.setOnCheckedChangeListener(this);
        this.binding.odd.setOnCheckedChangeListener(this);
        this.binding.even.setOnCheckedChangeListener(this);
        this.binding.polarityP.setOnCheckedChangeListener(this);
        this.binding.polarityN.setOnCheckedChangeListener(this);
        this.binding.buttonLevel.setOnClickListener(this);
        this.binding.imageView2.setOnClickListener(this);
        this.binding.triggerSource.setOnClickListener(this);
        this.binding.videoStandardValue.setOnClickListener(this);
        this.binding.triggerLevelValue.setOnClickListener(this);
        this.binding.linesNumberValue.setOnClickListener(this);
        this.binding.triggerLevelView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.adapters.TriggerVideoAdapter.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    TriggerVideoAdapter.this.param.saveLevelSync((long) ((((seekBar.getProgress() / 100.0d) * (TriggerVideoAdapter.this.param.getChanScale() * TriggerVideoAdapter.this.param.getScaleNum())) - TriggerVideoAdapter.this.param.getChanOffset()) - ((TriggerVideoAdapter.this.param.getChanScale() * TriggerVideoAdapter.this.param.getScaleNum()) / 2)));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                TriggerVideoAdapter.this.param.saveLevelSync((long) ((((seekBar.getProgress() / 100.0d) * (TriggerVideoAdapter.this.param.getChanScale() * TriggerVideoAdapter.this.param.getScaleNum())) - TriggerVideoAdapter.this.param.getChanOffset()) - ((TriggerVideoAdapter.this.param.getChanScale() * TriggerVideoAdapter.this.param.getScaleNum()) / 2)));
            }
        });
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            switch (compoundButton.getId()) {
                case R.id.all_lines /* 2131361958 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveVideoLines(0);
                        return;
                    }
                    return;
                case R.id.auto_radio_button /* 2131361987 */:
                    if (z) {
                        this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1);
                        return;
                    }
                    return;
                case R.id.even /* 2131362851 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveVideoLines(z ? 3 : 0);
                        return;
                    }
                    return;
                case R.id.lines /* 2131363321 */:
                    this.aorBManager.set_RadioButton();
                    TriggerParam triggerParam = this.param;
                    if (triggerParam != null) {
                        triggerParam.saveVideoLines(z ? 1 : 0);
                        return;
                    }
                    return;
                case R.id.normal_radio_button /* 2131363483 */:
                    if (z) {
                        this.param.saveSweep(ServiceEnum.TriggerSweep.Trigger_Sweep_Normal.value1);
                        return;
                    }
                    return;
                case R.id.odd /* 2131363497 */:
                    this.aorBManager.set_RadioButton();
                    if (this.param != null) {
                        this.param.saveVideoLines(z ? 2 : 0);
                        return;
                    }
                    return;
                case R.id.polarity_n /* 2131363608 */:
                    TriggerParam triggerParam2 = this.param;
                    if (triggerParam2 != null) {
                        triggerParam2.saveVideoPolarity(z ? 1 : 0);
                        return;
                    }
                    return;
                case R.id.polarity_p /* 2131363609 */:
                    if (this.param != null) {
                        this.param.saveVideoPolarity(0);
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
            case R.id.imageView2 /* 2131363100 */:
                if (this.param.getVideoPolarity() == ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive) {
                    this.param.saveVideoPolarity(ServiceEnum.TriggerPulsePolarity.Trigger_pulse_negative.value1);
                    break;
                } else if (this.param.getVideoPolarity() == ServiceEnum.TriggerPulsePolarity.Trigger_pulse_negative) {
                    this.param.saveVideoPolarity(ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive.value1);
                    break;
                }
                break;
            case R.id.lines_number_value /* 2131363323 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readvideoLineNumber();
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_number, this.param.getVideoLineNumberAttr().getMaxIntValue(), this.param.getVideoLineNumberAttr().getMinIntValue(), this.param.getVideoLineNumberAttr().getDefIntValue(), this.param.getLinesNumber(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerVideoAdapter.4
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerVideoAdapter.this.param.saveLinesNumber(((Long) t).intValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerVideoAdapter.this.keyboardPopupView = keyboardPopupView;
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
            case R.id.trigger_level_value /* 2131364280 */:
                if (this.aorBManager.setClick_showab(id) && (this.context instanceof Activity)) {
                    this.param.readLevelAttr();
                    TriggerParam triggerParam = this.param;
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, triggerParam.getChanUnit(triggerParam.getChannel()), this.param.getLevelAttr().getMaxLongValue(), this.param.getLevelAttr().getMinLongValue(), this.param.getLevelAttr().getDefLongValue(), this.param.getLevel(), new KeyboardListener() { // from class: com.rigol.scope.adapters.TriggerVideoAdapter.3
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            TriggerVideoAdapter.this.param.saveLevelSync(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            TriggerVideoAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source /* 2131364336 */:
                if (this.popupView != null) {
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_trigger_source)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerVideoAdapter$HcVIH4tQYnMnBzC7gKtLjrbApNc
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerVideoAdapter.this.lambda$onClick$3$TriggerVideoAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerVideoAdapter$cUQ55EP8L6gpBPohTZ5jj8LMXoI
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerVideoAdapter.this.lambda$onClick$4$TriggerVideoAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    break;
                }
                break;
            case R.id.video_standard_value /* 2131364581 */:
                if (this.popupView != null) {
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_trigger_video_standard), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerVideoAdapter$RbCZmFTGTFz7EEcqpW_bZgZMCWo
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            TriggerVideoAdapter.this.lambda$onClick$5$TriggerVideoAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$TriggerVideoAdapter$F6SZcWOJBvzcaICeZgRfde0SUQc
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            TriggerVideoAdapter.this.lambda$onClick$6$TriggerVideoAdapter(view2, viewHolder, i, (MappingObject) obj);
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

    public /* synthetic */ void lambda$onClick$3$TriggerVideoAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$TriggerVideoAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSource(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$5$TriggerVideoAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$TriggerVideoAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectStandard(mappingObject);
    }

    private void selectStandard(MappingObject mappingObject) {
        TriggerParam triggerParam = this.param;
        if (triggerParam != null) {
            triggerParam.saveVideoFormat(mappingObject.getValue());
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        if (i == R.id.lines_number_value) {
            this.param.readvideoLineNumber();
            TriggerParam triggerParam = this.param;
            triggerParam.saveLinesNumber(triggerParam.getIntStep(triggerParam.getLinesNumber(), this.param.getVideoLineNumberAttr(), z, keyEvent));
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
        if (i == R.id.lines_number_value) {
            TriggerParam triggerParam = this.param;
            triggerParam.saveLinesNumber(triggerParam.getIntDef(triggerParam.getVideoLineNumberAttr()));
        } else if (i != R.id.trigger_level_value) {
        } else {
            TriggerParam triggerParam2 = this.param;
            triggerParam2.saveLevelSync(triggerParam2.getLongDef(triggerParam2.getLevelAttr()));
        }
    }

    /* loaded from: classes.dex */
    public class TriggerVideoHolder extends RecyclerView.ViewHolder {
        private AdapterTriggerVideoBinding binding;

        public TriggerVideoHolder(AdapterTriggerVideoBinding adapterTriggerVideoBinding) {
            super(adapterTriggerVideoBinding.getRoot());
            this.binding = adapterTriggerVideoBinding;
        }
    }
}
