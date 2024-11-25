package com.rigol.scope.views.upa;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.adapters.UpaQualityAdapter;
import com.rigol.scope.adapters.UpaRippleAdapter;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.UpaParam;
import com.rigol.scope.data.UpaRippleParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.databinding.PopupviewUpaBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UpaViewModel;
import com.rigol.scope.viewmodels.UpaViewRippleModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes2.dex */
public class UpaPopupview extends BasePopupView implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private AorBManager aorBManager;
    private final PopupviewUpaBinding binding;
    private View clickedView;
    private List<AorBParam> list_aorbParam;
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    private PopupSpinner popupSpinner;
    private SpinnerAdapter spinnerAdapter;
    private SyncDataViewModel syncDataViewModel;
    private UpaParam upaParam;
    private UpaQualityAdapter upaQualityAdapter;
    private UpaRippleAdapter upaRippleAdapter;
    private UpaRippleParam upaRippleParam;
    private UpaViewModel upaViewModel;
    private UpaViewRippleModel upaViewRippleModel;

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
    }

    public UpaPopupview() {
        super((int) R.style.App_PopupWindow_popuview_upa);
        this.list_aorbParam = new ArrayList();
        PopupviewUpaBinding inflate = PopupviewUpaBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        this.binding.upaAnalysisSpinner.setOnClickListener(this);
        this.binding.displayOnoffSwitchButton.setOnCheckedChangeListener(this);
        this.syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        ViewUtil.setSwitchButton(this.binding.displayOnoffSwitchButton);
        this.upaViewModel = (UpaViewModel) ContextUtil.getAppViewModel(UpaViewModel.class);
        this.upaViewRippleModel = (UpaViewRippleModel) ContextUtil.getAppViewModel(UpaViewRippleModel.class);
        UpaViewModel upaViewModel = this.upaViewModel;
        if (upaViewModel != null) {
            upaViewModel.getLiveData();
            this.upaViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.upa.-$$Lambda$UpaPopupview$UMHFa-7Gj8fPrHQW-AuE8I172Nc
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UpaPopupview.this.lambda$new$0$UpaPopupview((UpaParam) obj);
                }
            });
        }
        UpaViewRippleModel upaViewRippleModel = this.upaViewRippleModel;
        if (upaViewRippleModel != null) {
            upaViewRippleModel.getLiveData();
            this.upaViewRippleModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.upa.-$$Lambda$UpaPopupview$8XyAOn-d0WHY9oJQUa3hZ3-AkiA
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UpaPopupview.this.lambda$new$1$UpaPopupview((UpaRippleParam) obj);
                }
            });
        }
        this.list_aorbParam.add(new AorBParam(this.binding.upaAnalysisSpinner, 0, false, "", 2));
        this.aorBManager = new AorBManager(this.context, this.list_aorbParam) { // from class: com.rigol.scope.views.upa.UpaPopupview.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
            }
        };
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.upa.-$$Lambda$UpaPopupview$0Oq7FxNLmbxbxf-2Y-S60XueULM
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        UpaPopupview.this.lambda$new$2$UpaPopupview((KeyEvent) obj);
                    }
                });
            }
        }
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        if (horizontalViewModel != null) {
            final PopupviewUpaBinding popupviewUpaBinding = this.binding;
            Objects.requireNonNull(popupviewUpaBinding);
            horizontalViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.upa.-$$Lambda$bOTKTZwkZcuSZMg7G6Jzj2qlKsE
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    PopupviewUpaBinding.this.setHorizontalParam((HorizontalParam) obj);
                }
            });
        }
        this.syncDataViewModel.get(31, MessageID.MSG_UPA_POWER_DISP).observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.upa.-$$Lambda$UpaPopupview$gxMv7LRGFPkUHvOkIW2Ilm8gGx8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UpaPopupview.this.lambda$new$3$UpaPopupview(obj);
            }
        });
        this.syncDataViewModel.get(31, MessageID.MSG_UPA_RIPPLE_DISP).observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.upa.-$$Lambda$UpaPopupview$vigVrAxDhwMPmM4BKowMxjW_OE4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UpaPopupview.this.lambda$new$4$UpaPopupview(obj);
            }
        });
        this.syncDataViewModel.get(31, MessageID.MSG_UPA_TYPE).observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.upa.-$$Lambda$UpaPopupview$6oWoF9sDYvjVFD2VlV6vsCuE0to
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UpaPopupview.this.lambda$new$5$UpaPopupview(obj);
            }
        });
    }

    public /* synthetic */ void lambda$new$0$UpaPopupview(UpaParam upaParam) {
        this.upaParam = upaParam;
        this.binding.setParam(upaParam);
        UpaQualityAdapter upaQualityAdapter = new UpaQualityAdapter(this.context, this, upaParam);
        this.upaQualityAdapter = upaQualityAdapter;
        upaQualityAdapter.setMove(true);
        this.binding.adaperUpaView.setAdapter(this.upaQualityAdapter);
    }

    public /* synthetic */ void lambda$new$1$UpaPopupview(UpaRippleParam upaRippleParam) {
        this.upaRippleParam = upaRippleParam;
        this.binding.setUpaRippleParam(upaRippleParam);
        UpaRippleAdapter upaRippleAdapter = new UpaRippleAdapter(this.context, this, upaRippleParam, this.upaParam);
        this.upaRippleAdapter = upaRippleAdapter;
        upaRippleAdapter.setMove(false);
    }

    public /* synthetic */ void lambda$new$2$UpaPopupview(KeyEvent keyEvent) {
        PopupSpinner popupSpinner;
        List<MappingObject> list;
        if (!PopupViewManager.getInstance().isShowing(UpaPopupview.class) || (popupSpinner = this.popupSpinner) == null || !popupSpinner.isShowing() || (list = this.mappingObjects) == null) {
            return;
        }
        this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, list, this.spinnerAdapter, this.aorBManager, null, null, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.upa.-$$Lambda$UpaPopupview$DrCpVZszRZI-VFs6E2JenUCprY4
            @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
            public final void onCall(int i, MappingObject mappingObject) {
                UpaPopupview.this.selectAdapter(i, mappingObject);
            }
        });
    }

    public /* synthetic */ void lambda$new$3$UpaPopupview(Object obj) {
        this.upaParam.readPowerDisp();
        if (this.upaParam.getRefPowerDisp()) {
            return;
        }
        FunctionManager.getInstance().upaSwitch = false;
        MessageBus.getInstance().onSyncData(MessageBus.getKey(10, MessageID.MSG_HOR_REFRESH_ULTRAL_ENABLE), null);
    }

    public /* synthetic */ void lambda$new$4$UpaPopupview(Object obj) {
        this.upaRippleParam.readPowerDisp();
    }

    public /* synthetic */ void lambda$new$5$UpaPopupview(Object obj) {
        selectAdapter1(this.upaParam.getDisposeType(), ViewUtil.getList((int) R.array.msg_upa_type).get(this.upaParam.getDisposeType()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectAdapter(int i, MappingObject mappingObject) {
        setSpinnerAdapterNew();
        this.upaParam.disposeType(mappingObject.getValue());
        WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_UPA);
        this.upaParam.savePowerDisp(false);
        this.upaRippleParam.savePowerDisp(false);
        if (mappingObject.getValue() == 0) {
            this.upaQualityAdapter.setMove(true);
            this.binding.adaperUpaView.setAdapter(this.upaQualityAdapter);
            this.binding.displayOnoffSwitchButton.setChecked(this.upaParam.getRefPowerDisp());
        } else {
            this.upaRippleAdapter.setMove(true);
            this.binding.adaperUpaView.setAdapter(this.upaRippleAdapter);
            this.binding.displayOnoffSwitchButton.setChecked(this.upaRippleParam.getRefPowerDisp());
        }
        upaLight();
    }

    private void selectAdapter1(int i, MappingObject mappingObject) {
        setSpinnerAdapterNew();
        this.upaParam.readPowerDisp();
        this.upaRippleParam.readPowerDisp();
        if (mappingObject.getValue() == 0) {
            this.upaQualityAdapter.setMove(true);
            this.binding.adaperUpaView.setAdapter(this.upaQualityAdapter);
            this.binding.displayOnoffSwitchButton.setChecked(this.upaParam.getRefPowerDisp());
        } else {
            this.upaRippleAdapter.setMove(true);
            this.binding.adaperUpaView.setAdapter(this.upaRippleAdapter);
            this.binding.displayOnoffSwitchButton.setChecked(this.upaRippleParam.getRefPowerDisp());
        }
        upaLight();
        WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_UPA);
        if (this.binding.displayOnoffSwitchButton.isChecked()) {
            WindowParam windowParam = new WindowParam();
            ServiceEnum.Chan chan = ServiceEnum.Chan.chan1;
            ServiceEnum.Chan chan2 = ServiceEnum.Chan.chan2;
            windowParam.setSource1(chan);
            windowParam.setServiceID(31);
            windowParam.setType(ServiceEnum.WindowType.WIN_UPA);
            ((MainActivity) ActivityUtils.getTopActivity()).getWaveformFragment().addWindow(windowParam);
            return;
        }
        WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_UPA);
    }

    public void upaLight() {
        if (this.upaParam != null) {
            PopupViewManager.getInstance().closeAllLight();
            if (this.upaParam.getType() == 0) {
                PopupViewManager.getInstance().setLight(this.upaParam.getAorBManager());
                return;
            }
            UpaRippleParam upaRippleParam = this.upaRippleParam;
            if (upaRippleParam != null) {
                if (upaRippleParam.getAorBManager() == null) {
                    PopupViewManager.getInstance().AVerticalLight_Open();
                } else {
                    PopupViewManager.getInstance().setLight(this.upaRippleParam.getAorBManager());
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.upa_analysis_spinner) {
            return;
        }
        ViewUtil.showSpinner(this.anchor, view, ViewUtil.getList((int) R.array.msg_upa_type), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.upa.-$$Lambda$UpaPopupview$E7R6YMvRSL7s4RfMH24vQPCtIns
            @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
            public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                UpaPopupview.this.lambda$onClick$6$UpaPopupview(popupSpinner, spinnerAdapter, list, view2);
            }
        }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.upa.-$$Lambda$UpaPopupview$KcIcgfZF3sg6Ap5OPIxxAQB9ZWI
            @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
            public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                UpaPopupview.this.lambda$onClick$7$UpaPopupview(view2, viewHolder, i, (MappingObject) obj);
            }
        });
    }

    public /* synthetic */ void lambda$onClick$6$UpaPopupview(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$7$UpaPopupview(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectAdapter(i, mappingObject);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            if (this.upaParam.getDisposeType() == 0) {
                this.upaParam.savePowerDisp(z);
            } else {
                this.upaRippleParam.savePowerDisp(z);
            }
            if (z) {
                WindowParam windowParam = new WindowParam();
                ServiceEnum.Chan chan = ServiceEnum.Chan.chan1;
                ServiceEnum.Chan chan2 = ServiceEnum.Chan.chan2;
                windowParam.setSource1(chan);
                windowParam.setServiceID(31);
                windowParam.setType(ServiceEnum.WindowType.WIN_UPA);
                ((MainActivity) ActivityUtils.getTopActivity()).getWaveformFragment().addWindow(windowParam);
            } else {
                WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_UPA);
            }
            if (FunctionManager.getInstance().checkUltraIsOpen()) {
                ToastUtils.showShort((int) R.string.err_action_disabled);
            }
        }
    }

    public void setSpinnerAdapterNew() {
        this.upaQualityAdapter.setMove(false);
        this.upaRippleAdapter.setMove(false);
    }
}
