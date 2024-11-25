package com.rigol.scope.views.cursor;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.CounterResultParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.PopupviewResultCounterBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.CounterViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.views.baseview.BaseDeletePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class CounterSettingPopupView extends BaseDeletePopupView implements CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private AorBManager aorBManager;
    private View clickedView;
    private KeyboardPopupView keyboardPopupView;
    private List<AorBParam> list_aorbParam;
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    private CounterResultParam param;
    private PopupSpinner popupSpinner;
    private SpinnerAdapter spinnerAdapter;

    public AorBManager getAorBManager() {
        return this.aorBManager;
    }

    public CounterSettingPopupView() {
        super(R.style.App_PopupWindow_ResultCounter);
        this.list_aorbParam = new ArrayList();
        PopupviewResultCounterBinding inflate = PopupviewResultCounterBinding.inflate(LayoutInflater.from(this.context));
        setContentView(inflate.getRoot());
        inflate.setOnClickListener(this);
        CounterViewModel counterViewModel = (CounterViewModel) ContextUtil.getAppViewModel(CounterViewModel.class);
        if (counterViewModel == null) {
            return;
        }
        CounterResultParam value = counterViewModel.getLiveData().getValue();
        this.param = value;
        inflate.setParam(value);
        inflate.setFrequencyMappingObject(ViewUtil.getMappingObject(R.array.msg_counter_1_meas_type, ServiceEnum.CounterType.FREQ.value1));
        inflate.setPeriodMappingObject(ViewUtil.getMappingObject(R.array.msg_counter_1_meas_type, ServiceEnum.CounterType.PERIOD.value1));
        inflate.setTotalizeMappingObject(ViewUtil.getMappingObject(R.array.msg_counter_1_meas_type, ServiceEnum.CounterType.TOTALIZE.value1));
        ViewUtil.setSwitchButton(inflate.counterStatSwitch);
        inflate.frequencyRadioButton.setOnCheckedChangeListener(this);
        inflate.periodRadioButton.setOnCheckedChangeListener(this);
        inflate.totalizeRadioButton.setOnCheckedChangeListener(this);
        inflate.counterStatSwitch.setOnCheckedChangeListener(this);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(inflate.resolutionEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(inflate.sourceSpinner, 0, false, "", 2));
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.views.cursor.CounterSettingPopupView.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
                showKey(CounterSettingPopupView.this.context, ((AorBParam) CounterSettingPopupView.this.list_aorbParam.get(i)).getEditText(), true, ((AorBParam) CounterSettingPopupView.this.list_aorbParam.get(i)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
                showKey(CounterSettingPopupView.this.context, ((AorBParam) CounterSettingPopupView.this.list_aorbParam.get(i)).getEditText(), false, ((AorBParam) CounterSettingPopupView.this.list_aorbParam.get(i)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, inflate.resolutionEditText, true, ViewUtil.KEY_A);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CounterSettingPopupView$ZTHL7d-eWaN3FRom8T5jIXOPyHo
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        CounterSettingPopupView.this.lambda$new$2$CounterSettingPopupView((KeyEvent) obj);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$new$2$CounterSettingPopupView(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(CounterSettingPopupView.class)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CounterSettingPopupView$gcV6X9g9G9We1kp27ez61a7HJaI
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    CounterSettingPopupView.this.lambda$new$0$CounterSettingPopupView(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CounterSettingPopupView$tF5hbOv1Kf4ELtnbRQY77zPXnmU
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    CounterSettingPopupView.this.lambda$new$1$CounterSettingPopupView(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$CounterSettingPopupView(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$new$1$CounterSettingPopupView(int i, MappingObject mappingObject) {
        View view = this.clickedView;
        if (view != null && view.getId() == R.id.source_spinner) {
            selectSource(mappingObject);
        }
    }

    @Override // com.rigol.scope.views.baseview.BaseDeletePopupView, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.source_spinner) {
            List<MappingObject> filterChan = ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_counter_1_src));
            if (ViewUtil.checkModelS() && filterChan.get(filterChan.size() - 1).getValue() == 26) {
                filterChan.remove(filterChan.size() - 1);
            }
            ViewUtil.showChanSpinner(this.anchor, view, filterChan, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CounterSettingPopupView$sxixOh4JWzGkkontZlpQQKyC--I
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    CounterSettingPopupView.this.lambda$onClick$3$CounterSettingPopupView(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CounterSettingPopupView$FNO6kvHtBw71lliVJxeq96mYYgI
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    CounterSettingPopupView.this.lambda$onClick$4$CounterSettingPopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.resolution_edit_text) {
            if (this.aorBManager.setClick_showab(id)) {
                ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_number, this.param.getResolutionAttr().getMaxIntValue(), this.param.getResolutionAttr().getMinIntValue(), this.param.getResolutionAttr().getDefIntValue(), this.param.getResolution(), new KeyboardListener() { // from class: com.rigol.scope.views.cursor.CounterSettingPopupView.2
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        CounterSettingPopupView.this.param.saveResolution(((Long) t).intValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        CounterSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.clear_button) {
            API.getInstance().UI_PostInt32(29, MessageID.MSG_COUNTER_1_TOT_CLEAR, 0);
        }
    }

    public /* synthetic */ void lambda$onClick$3$CounterSettingPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$CounterSettingPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSource(mappingObject);
    }

    private void selectSource(MappingObject mappingObject) {
        this.param.saveSource(ServiceEnum.getChanFromValue1(mappingObject.getValue()));
    }

    public void counterLight() {
        if (this.param.getCounterType() == ServiceEnum.CounterType.TOTALIZE) {
            PopupViewManager.getInstance().closeAllLight();
            return;
        }
        PopupViewManager.getInstance().closeAllLight();
        PopupViewManager.getInstance().AVerticalLight_Open();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int id = compoundButton.getId();
        if (compoundButton.isPressed()) {
            if (id == R.id.frequency_radio_button) {
                if (z) {
                    this.param.saveCounterType(ServiceEnum.CounterType.FREQ);
                }
            } else if (id == R.id.period_radio_button) {
                if (z) {
                    this.param.saveCounterType(ServiceEnum.CounterType.PERIOD);
                }
            } else if (id == R.id.totalize_radio_button) {
                if (z) {
                    this.param.saveCounterType(ServiceEnum.CounterType.TOTALIZE);
                }
            } else if (id == R.id.counter_stat_switch) {
                this.param.setCounterSwitch(z);
            }
            counterLight();
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        CounterResultParam counterResultParam = this.param;
        if (counterResultParam != null && i == R.id.resolution_edit_text) {
            if (counterResultParam.getCounterType() == ServiceEnum.CounterType.FREQ || this.param.getCounterType() == ServiceEnum.CounterType.PERIOD) {
                CounterResultParam counterResultParam2 = this.param;
                counterResultParam2.saveResolution(this.aorBManager.getIntStep(counterResultParam2.getResolution(), this.param.getResolutionAttr(), z, keyEvent));
            }
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        CounterResultParam counterResultParam = this.param;
        if (counterResultParam != null && i == R.id.resolution_edit_text) {
            if (counterResultParam.getCounterType() == ServiceEnum.CounterType.FREQ || this.param.getCounterType() == ServiceEnum.CounterType.PERIOD) {
                CounterResultParam counterResultParam2 = this.param;
                counterResultParam2.saveResolution(counterResultParam2.getIntDef(counterResultParam2.getResolutionAttr()));
            }
        }
    }
}
