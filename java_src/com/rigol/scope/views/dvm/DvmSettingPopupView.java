package com.rigol.scope.views.dvm;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.DvmResultParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.PopupviewResultDvmBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.DvmViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.views.baseview.BaseDeletePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class DvmSettingPopupView extends BaseDeletePopupView implements CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private AorBManager aorBManager;
    final PopupviewResultDvmBinding binding;
    private View clickedView;
    private KeyboardPopupView keyboardPopupView;
    private List<AorBParam> list_aorbParam;
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    private DvmResultParam param;
    private PopupSpinner popupSpinner;
    private SpinnerAdapter spinnerAdapter;

    public AorBManager getAorBManager() {
        return this.aorBManager;
    }

    public DvmSettingPopupView() {
        super(R.style.App_PopupWindow_ResultDVM);
        this.list_aorbParam = new ArrayList();
        this.binding = PopupviewResultDvmBinding.inflate(LayoutInflater.from(this.context));
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.upperEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.lowerEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.sourceSpinner, 0, false, "", 2));
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.views.dvm.DvmSettingPopupView.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
                DvmSettingPopupView.this.aorBManager.showKey(DvmSettingPopupView.this.context, ((AorBParam) DvmSettingPopupView.this.list_aorbParam.get(i)).getEditText(), true, ((AorBParam) DvmSettingPopupView.this.list_aorbParam.get(i)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
                DvmSettingPopupView.this.aorBManager.showKey(DvmSettingPopupView.this.context, ((AorBParam) DvmSettingPopupView.this.list_aorbParam.get(i)).getEditText(), false, ((AorBParam) DvmSettingPopupView.this.list_aorbParam.get(i)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.upperEditText, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.lowerEditText, true, ViewUtil.KEY_B);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.dvm.-$$Lambda$DvmSettingPopupView$aPH6Y21rgNxqteK8LIUdepvT2ow
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DvmSettingPopupView.this.lambda$new$1$DvmSettingPopupView((KeyEvent) obj);
                    }
                });
            }
        }
        setContentView(this.binding.getRoot());
        this.binding.setOnClickListener(this);
        DvmViewModel dvmViewModel = (DvmViewModel) ContextUtil.getAppViewModel(DvmViewModel.class);
        if (dvmViewModel != null) {
            dvmViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.dvm.-$$Lambda$DvmSettingPopupView$9hcD1Uy82G99Fz9aF-ZLbmVsy74
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DvmSettingPopupView.this.lambda$new$2$DvmSettingPopupView((DvmResultParam) obj);
                }
            });
        }
        this.binding.setAcMappingObject(ViewUtil.getMappingObject(R.array.msg_dvm_mode, ServiceEnum.DvmMode.DVM_AC_RMS.value1));
        this.binding.setDcMappingObject(ViewUtil.getMappingObject(R.array.msg_dvm_mode, ServiceEnum.DvmMode.DVM_DC.value1));
        this.binding.setAcdcMappingObject(ViewUtil.getMappingObject(R.array.msg_dvm_mode, ServiceEnum.DvmMode.DVM_DC_RMS.value1));
        this.binding.modeAcRadioButton.setOnCheckedChangeListener(this);
        this.binding.modeDcRadioButton.setOnCheckedChangeListener(this);
        this.binding.modeAcDcRadioButton.setOnCheckedChangeListener(this);
        ViewUtil.setSwitchButton(this.binding.beeperSwitch);
        ViewUtil.setSwitchButton(R.array.msg_dvm_limit_type, this.binding.limitTypeSwitch);
        this.binding.limitTypeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.views.dvm.-$$Lambda$DvmSettingPopupView$W01EKxnT6sWZcYIszEHnbBUdpZ4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DvmSettingPopupView.this.lambda$new$3$DvmSettingPopupView(compoundButton, z);
            }
        });
        this.binding.beeperSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.views.dvm.-$$Lambda$DvmSettingPopupView$zzRLpC1O_FrMiworWbuqaoDoH-4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DvmSettingPopupView.this.lambda$new$4$DvmSettingPopupView(compoundButton, z);
            }
        });
    }

    public /* synthetic */ void lambda$new$1$DvmSettingPopupView(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(DvmSettingPopupView.class)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.views.dvm.-$$Lambda$DvmSettingPopupView$bgSan4N_l18dbXyig-BQcqXbSLE
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    DvmSettingPopupView.this.lambda$new$0$DvmSettingPopupView(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.dvm.DvmSettingPopupView.2
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public void onCall(int i, MappingObject mappingObject) {
                    if (DvmSettingPopupView.this.clickedView != null && DvmSettingPopupView.this.clickedView.getId() == R.id.source_spinner) {
                        DvmSettingPopupView.this.selectSource(mappingObject);
                    }
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$DvmSettingPopupView(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$new$2$DvmSettingPopupView(DvmResultParam dvmResultParam) {
        this.param = dvmResultParam;
        this.binding.setParam(dvmResultParam);
    }

    public /* synthetic */ void lambda$new$3$DvmSettingPopupView(CompoundButton compoundButton, boolean z) {
        DvmResultParam dvmResultParam;
        if (compoundButton.isPressed() && (dvmResultParam = this.param) != null) {
            dvmResultParam.saveLimitType(z ? 1 : 0);
        }
    }

    public /* synthetic */ void lambda$new$4$DvmSettingPopupView(CompoundButton compoundButton, boolean z) {
        DvmResultParam dvmResultParam;
        if (compoundButton.isPressed() && (dvmResultParam = this.param) != null) {
            dvmResultParam.saveBeeper(z);
        }
    }

    public void dvmLight() {
        PopupViewManager.getInstance().verticalLight();
    }

    @Override // com.rigol.scope.views.baseview.BaseDeletePopupView, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.param == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.source_spinner) {
            ViewUtil.showChanSpinner(this.anchor, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_dvm_src)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.dvm.-$$Lambda$DvmSettingPopupView$yBAbobjXsnZhwQPZA4pPbyPPUfE
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DvmSettingPopupView.this.lambda$onClick$5$DvmSettingPopupView(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.dvm.-$$Lambda$DvmSettingPopupView$T1wMgdomdLxirrhNThNPlX9C0Dg
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DvmSettingPopupView.this.lambda$onClick$6$DvmSettingPopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.lower_edit_text) {
            if (this.aorBManager.setClick_showab(id)) {
                this.param.readLowerAttr();
                ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_V, this.param.getLowerAttr().getMaxLongValue(), this.param.getLowerAttr().getMinLongValue(), this.param.getLowerAttr().getDefLongValue(), this.param.getLimitLower(), new KeyboardListener() { // from class: com.rigol.scope.views.dvm.DvmSettingPopupView.3
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        DvmSettingPopupView.this.param.saveLimitLower(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        DvmSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.upper_edit_text && this.aorBManager.setClick_showab(id)) {
            this.param.readUpperAttr();
            ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_V, this.param.getUpperAttr().getMaxLongValue(), this.param.getUpperAttr().getMinLongValue(), this.param.getUpperAttr().getDefLongValue(), this.param.getLimitUpper(), new KeyboardListener() { // from class: com.rigol.scope.views.dvm.DvmSettingPopupView.4
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DvmSettingPopupView.this.param.saveLimitUpper(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DvmSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$5$DvmSettingPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$DvmSettingPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSource(mappingObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectSource(MappingObject mappingObject) {
        this.param.saveSource(ServiceEnum.getChanFromValue1(mappingObject.getValue()));
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && this.param != null) {
            int id = compoundButton.getId();
            if (id == R.id.mode_ac_radio_button) {
                this.param.saveMode(ServiceEnum.DvmMode.DVM_AC_RMS);
            } else if (id == R.id.mode_dc_radio_button) {
                this.param.saveMode(ServiceEnum.DvmMode.DVM_DC);
            } else if (id == R.id.mode_ac_dc_radio_button) {
                this.param.saveMode(ServiceEnum.DvmMode.DVM_DC_RMS);
            }
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        PopupviewResultDvmBinding popupviewResultDvmBinding = this.binding;
        if (popupviewResultDvmBinding != null) {
            ViewUtil.updateSwitchText(R.array.msg_dvm_limit_type, popupviewResultDvmBinding.limitTypeSwitch);
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        DvmResultParam dvmResultParam = this.param;
        if (dvmResultParam == null) {
            return;
        }
        if (i == R.id.lower_edit_text) {
            dvmResultParam.saveLimitLower(this.aorBManager.getLongStep(dvmResultParam.getLimitLower(), this.param.getLowerAttr(), z, keyEvent));
        } else if (i != R.id.upper_edit_text) {
        } else {
            dvmResultParam.saveLimitUpper(this.aorBManager.getLongStep(dvmResultParam.getLimitUpper(), this.param.getUpperAttr(), z, keyEvent));
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        DvmResultParam dvmResultParam = this.param;
        if (dvmResultParam == null) {
            return;
        }
        if (i == R.id.lower_edit_text) {
            dvmResultParam.saveLimitLower(this.aorBManager.getLongDef(dvmResultParam.getLowerAttr()));
        } else if (i != R.id.upper_edit_text) {
        } else {
            dvmResultParam.saveLimitUpper(this.aorBManager.getLongDef(dvmResultParam.getUpperAttr()));
        }
    }
}
