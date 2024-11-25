package com.rigol.scope.views.measure;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.data.ResultParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.databinding.PopupviewResultMeasureBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.MeasureResultViewModel;
import com.rigol.scope.viewmodels.MeasureSettingViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.views.baseview.BaseDeletePopupView;
import com.rigol.scope.views.baseview.OrientationView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.measure.MeasureSettingPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MeasureSettingPopupView extends BaseDeletePopupView implements RadioGroup.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private AorBManager aorBManager;
    private final PopupviewResultMeasureBinding binding;
    private View clickedView;
    private HorizontalViewModel horizontalViewModel;
    private KeyboardPopupView keyboardPopupView;
    private List<AorBParam> list_aorbParam;
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    private MeasureSettingParam param;
    private PopupSpinner popupSpinner;
    private List<? extends ResultParam> resultParams;
    private SharedParam sharedParam;
    private SpinnerAdapter spinnerAdapter;
    private List<VerticalParam> verticalParams;

    public AorBManager getAorBManager() {
        return this.aorBManager;
    }

    public MeasureSettingPopupView() {
        super(R.style.App_PopupWindow_ResultMeasure);
        this.param = null;
        this.verticalParams = null;
        this.list_aorbParam = new ArrayList();
        this.binding = PopupviewResultMeasureBinding.inflate(LayoutInflater.from(this.context));
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.statCountEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.highEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.midEditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.lowEditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.cursorAEditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.cursorBEditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.thresholdSourceSpinner, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.regionSpinner, 0, false, "", 2));
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.views.measure.MeasureSettingPopupView.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
                MeasureSettingPopupView.this.aorBManager.showKey(MeasureSettingPopupView.this.context, ((AorBParam) MeasureSettingPopupView.this.list_aorbParam.get(i)).getEditText(), true, ((AorBParam) MeasureSettingPopupView.this.list_aorbParam.get(i)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
                MeasureSettingPopupView.this.aorBManager.showKey(MeasureSettingPopupView.this.context, ((AorBParam) MeasureSettingPopupView.this.list_aorbParam.get(i)).getEditText(), false, ((AorBParam) MeasureSettingPopupView.this.list_aorbParam.get(i)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.statCountEditText, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.highEditText, true, ViewUtil.KEY_B);
        this.panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
        this.horizontalViewModel = (HorizontalViewModel) ((MainActivity) ActivityUtils.getTopActivity()).getActivityViewModelProvider().get(HorizontalViewModel.class);
        PanelKeyViewModel panelKeyViewModel = this.panelKeyViewModel;
        if (panelKeyViewModel != null) {
            panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$1u3I8ydbkLkTE03k4jVkp478WAs
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MeasureSettingPopupView.this.lambda$new$2$MeasureSettingPopupView((KeyEvent) obj);
                }
            });
        }
        setContentView(this.binding.getRoot());
        MeasureResultViewModel measureResultViewModel = (MeasureResultViewModel) ContextUtil.getAppViewModel(MeasureResultViewModel.class);
        if (measureResultViewModel != null) {
            measureResultViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$z8pRWf9gTMFSFpkgMG2qzVmjfsQ
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MeasureSettingPopupView.this.lambda$new$3$MeasureSettingPopupView((List) obj);
                }
            });
        }
        SharedViewModel sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
        if (sharedViewModel != null) {
            sharedViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$53U2d6ifd6a2Mh-eJ05x7FHBCbM
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MeasureSettingPopupView.this.lambda$new$4$MeasureSettingPopupView((SharedParam) obj);
                }
            });
        }
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null) {
            syncDataViewModel.get(28, MessageID.MSG_APP_MEAS_STAT_ENABLE).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$Z1CQYq0xNFbDPfhEg6fkQ9kwnNI
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MeasureSettingPopupView.this.lambda$new$5$MeasureSettingPopupView(obj);
                }
            });
        }
        syncDataViewModel.get(28, MessageID.MSG_APP_MEAS_HISTO_ENABLE).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$SzTy2RX049nEj66o1cdYgSJ_vVs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MeasureSettingPopupView.this.lambda$new$6$MeasureSettingPopupView(obj);
            }
        });
        syncDataViewModel.get(28, MessageID.MSG_MEAS_STAT_VALUE_SET).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$eWzcUTLAYLSmPvDC-bUjfo5guHM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MeasureSettingPopupView.this.lambda$new$7$MeasureSettingPopupView(obj);
            }
        });
        VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        if (verticalViewModel != null) {
            verticalViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$b23RDQcbAvLJAtMf6aap8lN0IoQ
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MeasureSettingPopupView.this.lambda$new$8$MeasureSettingPopupView((ArrayList) obj);
                }
            });
        }
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        if (horizontalViewModel != null) {
            horizontalViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer<HorizontalParam>() { // from class: com.rigol.scope.views.measure.MeasureSettingPopupView.2
                @Override // androidx.lifecycle.Observer
                public void onChanged(HorizontalParam horizontalParam) {
                    MeasureSettingPopupView.this.binding.setHorizontal(horizontalParam);
                }
            });
        }
        MeasureSettingViewModel measureSettingViewModel = (MeasureSettingViewModel) ContextUtil.getAppViewModel(MeasureSettingViewModel.class);
        if (measureSettingViewModel != null) {
            measureSettingViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$nDutIVVqsEQMDw2_DMw0cElBTB8
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MeasureSettingPopupView.this.lambda$new$9$MeasureSettingPopupView((MeasureSettingParam) obj);
                }
            });
            this.param = measureSettingViewModel.getLiveData().getValue();
        }
        this.binding.setOnClickListener(this);
        this.binding.setNormalMapping(ViewUtil.getMappingObject(R.array.msg_app_meas_range_mode, 0));
        this.binding.setPrecisionMapping(ViewUtil.getMappingObject(R.array.msg_app_meas_range_mode, 1));
        this.binding.modeRadioGroup.setOnCheckedChangeListener(this);
        setupSwitchButton(this.binding);
        this.binding.statSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$t1SWi12aOQzSn6pNRxpHC0Cvl98
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MeasureSettingPopupView.this.lambda$new$10$MeasureSettingPopupView(compoundButton, z);
            }
        });
        this.binding.threSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$cjjjGh9EL-NQ19XJS9k-qQV5b8w
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MeasureSettingPopupView.this.lambda$new$11$MeasureSettingPopupView(compoundButton, z);
            }
        });
        this.binding.histoEnSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$cxABYe-T3Btc1ivcUGbasEqLvLw
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MeasureSettingPopupView.this.lambda$new$12$MeasureSettingPopupView(compoundButton, z);
            }
        });
        this.binding.indicatorSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$rC-W4SS0U0MagWsG9T_h2nmx-NQ
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MeasureSettingPopupView.this.lambda$new$13$MeasureSettingPopupView(compoundButton, z);
            }
        });
        this.binding.thresholdDisplayTypeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$PSduI74OcX5ItJcpEgGmDJULwMs
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MeasureSettingPopupView.this.lambda$new$14$MeasureSettingPopupView(compoundButton, z);
            }
        });
        this.binding.ampMethodSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$HkP-5eOjX16Z0j6cvm-7WLpVqjU
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MeasureSettingPopupView.this.lambda$new$15$MeasureSettingPopupView(compoundButton, z);
            }
        });
        this.binding.topMethodSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$FVyNrZAwUIaJ2iLkoSchKn-3pGA
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MeasureSettingPopupView.this.lambda$new$16$MeasureSettingPopupView(compoundButton, z);
            }
        });
        this.binding.baseMethodSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$A-h4fCdrMUBowlhpSg9r_72hSFM
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MeasureSettingPopupView.this.lambda$new$17$MeasureSettingPopupView(compoundButton, z);
            }
        });
        this.binding.cursorAbSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$UpoKOzFbDAh-ElWTkUJmpsKtP7M
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MeasureSettingPopupView.this.lambda$new$18$MeasureSettingPopupView(compoundButton, z);
            }
        });
        this.binding.showLine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$spKYW-qqqAWZt7_rHQqf5Cz9jn0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MeasureSettingPopupView.this.lambda$new$19$MeasureSettingPopupView(compoundButton, z);
            }
        });
        this.binding.regionSpinner.setOnClickListener(new AnonymousClass3());
    }

    public /* synthetic */ void lambda$new$2$MeasureSettingPopupView(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(MeasureSettingPopupView.class)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$btcwpOveVWcLhevUpK1T0g2U23k
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    MeasureSettingPopupView.this.lambda$new$0$MeasureSettingPopupView(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$r8LmezDpj8Ct2kYrmbJy94pTWAY
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    MeasureSettingPopupView.this.lambda$new$1$MeasureSettingPopupView(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$MeasureSettingPopupView(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$new$1$MeasureSettingPopupView(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.threshold_source_spinner) {
            selectThresholdSource(mappingObject);
        } else if (this.clickedView.getId() == R.id.region_spinner) {
            selectRegion(i, mappingObject);
        } else if (this.clickedView.getId() == R.id.measure_source_spinner) {
            selectThresholdSource(mappingObject);
        }
    }

    public /* synthetic */ void lambda$new$3$MeasureSettingPopupView(List list) {
        this.resultParams = list;
    }

    public /* synthetic */ void lambda$new$4$MeasureSettingPopupView(SharedParam sharedParam) {
        this.sharedParam = sharedParam;
        this.binding.setSharedParam(sharedParam);
    }

    public /* synthetic */ void lambda$new$5$MeasureSettingPopupView(Object obj) {
        setStatChecked();
    }

    public /* synthetic */ void lambda$new$6$MeasureSettingPopupView(Object obj) {
        if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
            return;
        }
        this.param.readHistoEnable();
    }

    public /* synthetic */ void lambda$new$7$MeasureSettingPopupView(Object obj) {
        SharedParam sharedParam;
        int currentResultItem;
        ResultParam resultParam;
        if (-1 != ((Integer) obj).intValue() || (sharedParam = this.sharedParam) == null || this.resultParams == null || (currentResultItem = sharedParam.getCurrentResultItem()) < 0 || currentResultItem >= this.resultParams.size() || (resultParam = this.resultParams.get(currentResultItem)) == null) {
            return;
        }
        resultParam.setStat(this.param.readStatisticState() ? 1 : 0);
    }

    public /* synthetic */ void lambda$new$8$MeasureSettingPopupView(ArrayList arrayList) {
        this.verticalParams = arrayList;
        MeasureSettingParam measureSettingParam = this.param;
        if (measureSettingParam != null) {
            this.binding.setVerticalParam(ViewUtil.getVerticalItem(arrayList, measureSettingParam.getThresholdSource()));
        }
    }

    public /* synthetic */ void lambda$new$9$MeasureSettingPopupView(MeasureSettingParam measureSettingParam) {
        this.param = measureSettingParam;
        this.binding.setParam(measureSettingParam);
        List<VerticalParam> list = this.verticalParams;
        if (list != null) {
            this.binding.setVerticalParam(ViewUtil.getVerticalItem(list, this.param.getThresholdSource()));
        }
    }

    public /* synthetic */ void lambda$new$10$MeasureSettingPopupView(CompoundButton compoundButton, boolean z) {
        SharedParam sharedParam;
        int currentResultItem;
        ResultParam resultParam;
        if (compoundButton.isPressed() && (sharedParam = this.sharedParam) != null && this.resultParams != null && (currentResultItem = sharedParam.getCurrentResultItem()) >= 0 && currentResultItem < this.resultParams.size() && (resultParam = this.resultParams.get(currentResultItem)) != null) {
            resultParam.setStat(z ? 1 : 0);
            this.param.saveStatisticState(z);
        }
    }

    public /* synthetic */ void lambda$new$11$MeasureSettingPopupView(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            if (z) {
                this.param.saveCursorIndicator(z);
                this.param.saveCursorThreshold(z);
            } else {
                this.param.saveCursorThreshold(z);
            }
            if (compoundButton.isChecked()) {
                OrientationView.Companion.setShowThreshold(true);
            } else {
                OrientationView.Companion.setShowThreshold(false);
            }
        }
    }

    public /* synthetic */ void lambda$new$12$MeasureSettingPopupView(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            this.param.saveHistoEnable(z);
        }
    }

    public /* synthetic */ void lambda$new$13$MeasureSettingPopupView(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            if (z) {
                this.param.saveCursorThreshold(z);
                this.param.saveCursorIndicator(z);
                OrientationView.Companion.setShowThreshold(true);
                return;
            }
            this.param.saveCursorIndicator(z);
        }
    }

    public /* synthetic */ void lambda$new$14$MeasureSettingPopupView(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            this.param.saveThresholdType(compoundButton.isChecked() ? ServiceEnum.ThreType.TH_TYPE_ABS : ServiceEnum.ThreType.TH_TYPE_PER);
        }
    }

    public /* synthetic */ void lambda$new$15$MeasureSettingPopupView(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            this.param.saveMethodState(compoundButton.isChecked());
        }
    }

    public /* synthetic */ void lambda$new$16$MeasureSettingPopupView(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            this.param.saveTopMethod(compoundButton.isChecked() ? 1 : 0);
        }
    }

    public /* synthetic */ void lambda$new$17$MeasureSettingPopupView(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            this.param.saveBaseMethod(compoundButton.isChecked() ? 1 : 0);
        }
    }

    public /* synthetic */ void lambda$new$18$MeasureSettingPopupView(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            this.param.setRegionSelect(compoundButton.isChecked() ? 2 : 0);
            this.param.saveCursorAB(compoundButton.isChecked() ? 0L : 1L);
        }
    }

    public /* synthetic */ void lambda$new$19$MeasureSettingPopupView(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            MeasureSettingParam measureSettingParam = this.param;
            measureSettingParam.setShowThresLine(!measureSettingParam.getShowThresLine());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.measure.MeasureSettingPopupView$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final List<MappingObject> list = ViewUtil.getList((int) R.array.msg_app_meas_region);
            ViewUtil.showSpinner(MeasureSettingPopupView.this.anchor, view, list, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$3$uutAwa83TElP7tVg3BeYuUXEVTo
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                    MeasureSettingPopupView.AnonymousClass3.this.lambda$onClick$0$MeasureSettingPopupView$3(popupSpinner, spinnerAdapter, list2, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$3$AxLWEGCMIXdNWSBc1R6KGByySGE
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    MeasureSettingPopupView.AnonymousClass3.this.lambda$onClick$1$MeasureSettingPopupView$3(list, view2, viewHolder, i, (MappingObject) obj);
                }
            });
        }

        public /* synthetic */ void lambda$onClick$0$MeasureSettingPopupView$3(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            MeasureSettingPopupView.this.popupSpinner = popupSpinner;
            MeasureSettingPopupView.this.spinnerAdapter = spinnerAdapter;
            MeasureSettingPopupView.this.mappingObjects = list;
            MeasureSettingPopupView.this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$1$MeasureSettingPopupView$3(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            MeasureSettingPopupView.this.selectRegion(i, (MappingObject) list.get(i));
        }
    }

    private void setStatChecked() {
        int currentResultItem;
        SharedParam sharedParam = this.sharedParam;
        if (sharedParam == null || this.resultParams == null || (currentResultItem = sharedParam.getCurrentResultItem()) < 0 || currentResultItem >= this.resultParams.size()) {
            return;
        }
        this.param.saveStatisticState(this.resultParams.get(currentResultItem).getStat() == 1);
    }

    private void setupSwitchButton(PopupviewResultMeasureBinding popupviewResultMeasureBinding) {
        ViewUtil.setSwitchButton(popupviewResultMeasureBinding.indicatorSwitch);
        ViewUtil.setSwitchButton(popupviewResultMeasureBinding.statSwitch);
        ViewUtil.setSwitchButton(popupviewResultMeasureBinding.cursorAbSwitch);
        ViewUtil.setSwitchButton(popupviewResultMeasureBinding.threSwitch);
        ViewUtil.setSwitchButton(popupviewResultMeasureBinding.histoEnSwitch);
        ViewUtil.setSwitchButton(R.array.msg_app_meas_th_type, popupviewResultMeasureBinding.thresholdDisplayTypeSwitch);
        ViewUtil.setSwitchButton(R.array.msg_app_meas_set_state_method, popupviewResultMeasureBinding.ampMethodSwitch);
        ViewUtil.setSwitchButton(R.array.msg_app_meas_set_top_method, popupviewResultMeasureBinding.topMethodSwitch);
        ViewUtil.setSwitchButton(R.array.msg_app_meas_set_base_method, popupviewResultMeasureBinding.baseMethodSwitch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectRegion(int i, MappingObject mappingObject) {
        if (i == 1 && this.horizontalViewModel.getLiveData().getValue().readZoom()) {
            this.param.saveRegion(mappingObject.getValue());
        } else if (i == 0) {
            this.param.saveRegion(mappingObject.getValue());
        } else if (i == 2) {
            this.param.saveRegion(mappingObject.getValue());
        } else {
            this.param.saveRegion(mappingObject.getValue());
            ToastUtils.showShort(this.context.getResources().getString(R.string.msg_meas_open_zoom));
        }
    }

    private void selectThresholdSource(MappingObject mappingObject) {
        ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(mappingObject.getValue());
        if (chanFromValue1 != null) {
            this.param.saveThresholdSource(chanFromValue1);
            List<VerticalParam> list = this.verticalParams;
            if (list != null) {
                this.binding.setVerticalParam(ViewUtil.getVerticalItem(list, this.param.getThresholdSource()));
            }
            if (ServiceEnum.ThreType.TH_TYPE_ABS == this.param.getThresholdType()) {
                API.getInstance().UI_PostInt32(28, MessageID.MSG_APP_MEAS_TH_DEFAULT, 1);
            } else {
                this.param.saveThresholdType(ServiceEnum.ThreType.TH_TYPE_ABS);
                API.getInstance().UI_PostInt32(28, MessageID.MSG_APP_MEAS_TH_DEFAULT, 1);
                this.param.saveThresholdType(ServiceEnum.ThreType.TH_TYPE_PER);
            }
            if (OrientationView.Companion.getSourceA().equals(String.valueOf(chanFromValue1.value1))) {
                if (ServiceEnum.ThreType.TH_TYPE_ABS == this.param.getThresholdType()) {
                    OrientationView.Companion.setSourceAMiddle(UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(this.param.getThresholdMiddle(), ServiceEnum.Unit.Unit_V));
                    return;
                }
                OrientationView.Companion companion = OrientationView.Companion;
                companion.setSourceAMiddle(this.param.getThresholdMiddle() + "%");
            } else if (OrientationView.Companion.getSourceB().equals(String.valueOf(chanFromValue1.value1))) {
                if (ServiceEnum.ThreType.TH_TYPE_ABS == this.param.getThresholdType()) {
                    OrientationView.Companion.setSourceBMiddle(UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(this.param.getThresholdMiddle(), ServiceEnum.Unit.Unit_V));
                    return;
                }
                OrientationView.Companion companion2 = OrientationView.Companion;
                companion2.setSourceBMiddle(this.param.getThresholdMiddle() + "%");
            }
        }
    }

    private void selectAllItemSource(MappingObject mappingObject) {
        ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(mappingObject.getValue());
        if (chanFromValue1 != null) {
            this.param.saveAllItemSource(chanFromValue1);
            ViewUtil.changeItemAllSource(chanFromValue1.value1);
        }
    }

    @Override // com.rigol.scope.views.baseview.BaseDeletePopupView, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.high_edit_text) {
            if (this.aorBManager.setClick_showab(id)) {
                MeasureSettingParam measureSettingParam = this.param;
                measureSettingParam.saveThresholdHigh(measureSettingParam.getThresholdHigh());
                ViewUtil.showKeyboard(this.anchor, view, getUnit(), this.param.getThresholdHighAttr().getMaxLongValue(), this.param.getThresholdHighAttr().getMinLongValue(), this.param.getThresholdType() == ServiceEnum.ThreType.TH_TYPE_PER ? this.param.getThresholdHighAttr().getDefLongValue() : this.param.getThresholdHighAttr().getDefHighLongValue(), this.param.getThresholdHigh(), new KeyboardListener() { // from class: com.rigol.scope.views.measure.MeasureSettingPopupView.4
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        Long l = (Long) t;
                        MeasureSettingPopupView.this.param.saveThresholdHigh(l.longValue());
                        MeasureSettingPopupView.this.queryThresholdValue(l.longValue(), 3);
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        MeasureSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.mid_edit_text) {
            if (this.aorBManager.setClick_showab(id)) {
                MeasureSettingParam measureSettingParam2 = this.param;
                measureSettingParam2.saveThresholdMiddle(measureSettingParam2.getThresholdMiddle());
                ViewUtil.showKeyboard(this.anchor, view, getUnit(), this.param.getThresholdMiddleAttr().getMaxLongValue(), this.param.getThresholdMiddleAttr().getMinLongValue(), this.param.getThresholdType() == ServiceEnum.ThreType.TH_TYPE_PER ? this.param.getThresholdMiddleAttr().getDefLongValue() : this.param.getThresholdMiddleAttr().getDefMidLongValue(), this.param.getThresholdMiddle(), new KeyboardListener() { // from class: com.rigol.scope.views.measure.MeasureSettingPopupView.5
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        Long l = (Long) t;
                        MeasureSettingPopupView.this.param.saveThresholdMiddle(l.longValue());
                        MeasureSettingPopupView.this.queryThresholdValue(l.longValue(), 2);
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        MeasureSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.low_edit_text) {
            if (this.aorBManager.setClick_showab(id)) {
                MeasureSettingParam measureSettingParam3 = this.param;
                measureSettingParam3.saveThresholdLow(measureSettingParam3.getThresholdLow());
                ViewUtil.showKeyboard(this.anchor, view, getUnit(), this.param.getThresholdLowAttr().getMaxLongValue(), this.param.getThresholdLowAttr().getMinLongValue(), this.param.getThresholdType() == ServiceEnum.ThreType.TH_TYPE_PER ? this.param.getThresholdLowAttr().getDefLongValue() : this.param.getThresholdLowAttr().getDefLowLongValue(), this.param.getThresholdLow(), new KeyboardListener() { // from class: com.rigol.scope.views.measure.MeasureSettingPopupView.6
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        Long l = (Long) t;
                        MeasureSettingPopupView.this.param.saveThresholdLow(l.longValue());
                        MeasureSettingPopupView.this.queryThresholdValue(l.longValue(), 1);
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        MeasureSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.stat_count_edit_text) {
            if (this.aorBManager.setClick_showab(id)) {
                ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_number, this.param.getStatCountAttr().getMaxLongValue(), this.param.getStatCountAttr().getMinLongValue(), this.param.getStatCountAttr().getDefLongValue(), this.param.getStatCount(), new KeyboardListener() { // from class: com.rigol.scope.views.measure.MeasureSettingPopupView.7
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        MeasureSettingPopupView.this.param.saveStatCount(((Long) t).intValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        MeasureSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.threshold_default_button) {
            API.getInstance().UI_PostInt32(28, MessageID.MSG_APP_MEAS_TH_DEFAULT, 1);
        } else if (id == R.id.stat_reset_button) {
            API.getInstance().UI_PostInt32(28, MessageID.MSG_APP_MEAS_STAT_RESET, 1);
        } else if (id == R.id.region_spinner) {
            Log.e("region_spinner", "region_spinner");
            final List<MappingObject> list = ViewUtil.getList((int) R.array.msg_app_meas_region);
            ViewUtil.showSpinner(this.anchor, view, list, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$A2agn4ULVh_A82V7sc44PJY_LHs
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                    MeasureSettingPopupView.this.lambda$onClick$20$MeasureSettingPopupView(popupSpinner, spinnerAdapter, list2, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$vRrdm0Gt3I-CEr-KMaUOZwzf8h4
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    MeasureSettingPopupView.this.lambda$onClick$21$MeasureSettingPopupView(list, view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.cursor_a_edit_text) {
            if (this.aorBManager.setClick_showab(id)) {
                ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_s, this.param.getCursorAAttr().getMaxLongValue(), this.param.getCursorAAttr().getMinLongValue(), this.param.getCursorAAttr().getDefLongValue(), this.param.getCursorA(), new KeyboardListener() { // from class: com.rigol.scope.views.measure.MeasureSettingPopupView.8
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        MeasureSettingPopupView.this.param.saveCursorA(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        MeasureSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.cursor_b_edit_text) {
            if (this.aorBManager.setClick_showab(id)) {
                ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_s, this.param.getCursorBAttr().getMaxLongValue(), this.param.getCursorBAttr().getMinLongValue(), this.param.getCursorBAttr().getDefLongValue(), this.param.getCursorB(), new KeyboardListener() { // from class: com.rigol.scope.views.measure.MeasureSettingPopupView.9
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        MeasureSettingPopupView.this.param.saveCursorB(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        MeasureSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.threshold_source_spinner) {
            ViewUtil.showChanSpinner(this.anchor, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_app_meas_th_src)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$--0_kIMXWFTtfkT90ua_IDW0EX0
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                    MeasureSettingPopupView.this.lambda$onClick$22$MeasureSettingPopupView(popupSpinner, spinnerAdapter, list2, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$OibBUcg0wtaUTa2A4G_nXhNdL0g
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    MeasureSettingPopupView.this.lambda$onClick$23$MeasureSettingPopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.measure_source_spinner) {
            ViewUtil.showChanSpinner(this.anchor, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_app_meas_srca)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$P4cxDXrNUCAFQ8hURxbOnGkr09k
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                    MeasureSettingPopupView.this.lambda$onClick$24$MeasureSettingPopupView(popupSpinner, spinnerAdapter, list2, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasureSettingPopupView$Ur0umbIzvRvjJY5s46Kh2KJvBRQ
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    MeasureSettingPopupView.this.lambda$onClick$25$MeasureSettingPopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$20$MeasureSettingPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$21$MeasureSettingPopupView(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveRegion(((MappingObject) list.get(i)).getValue());
    }

    public /* synthetic */ void lambda$onClick$22$MeasureSettingPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$23$MeasureSettingPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectThresholdSource(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$24$MeasureSettingPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$25$MeasureSettingPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectAllItemSource(mappingObject);
    }

    private ServiceEnum.Unit getUnit() {
        if (this.param.getThresholdType() == ServiceEnum.ThreType.TH_TYPE_PER) {
            return ServiceEnum.Unit.Unit_percent;
        }
        VerticalParam verticalItem = ViewUtil.getVerticalItem(this.verticalParams, this.param.getThresholdSource());
        if (verticalItem != null) {
            return verticalItem.getUnit();
        }
        return ServiceEnum.Unit.Unit_V;
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        ViewUtil.updateSwitchText(R.array.msg_app_meas_th_type, this.binding.thresholdDisplayTypeSwitch);
        ViewUtil.updateSwitchText(R.array.msg_app_meas_set_state_method, this.binding.ampMethodSwitch);
        ViewUtil.updateSwitchText(R.array.msg_app_meas_set_top_method, this.binding.topMethodSwitch);
        ViewUtil.updateSwitchText(R.array.msg_app_meas_set_base_method, this.binding.baseMethodSwitch);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.normal_radio_button) {
            this.param.saveMode(0);
        } else if (i == R.id.precision_radio_button) {
            this.param.saveMode(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onPrepare() {
        super.onPrepare();
        setStatChecked();
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        MeasureSettingParam measureSettingParam = this.param;
        if (measureSettingParam == null) {
            return;
        }
        switch (i) {
            case R.id.cursor_a_edit_text /* 2131362336 */:
                measureSettingParam.saveCursorA(this.aorBManager.getLongStep(measureSettingParam.getCursorA(), this.param.getCursorAAttr(), z, keyEvent));
                if (this.param.getRegionSelect() == 2) {
                    MeasureSettingParam measureSettingParam2 = this.param;
                    measureSettingParam2.saveCursorB(this.aorBManager.getLongStep(measureSettingParam2.getCursorB(), this.param.getCursorBAttr(), z, keyEvent));
                    return;
                }
                return;
            case R.id.cursor_b_edit_text /* 2131362342 */:
                measureSettingParam.saveCursorB(this.aorBManager.getLongStep(measureSettingParam.getCursorB(), this.param.getCursorBAttr(), z, keyEvent));
                if (this.param.getRegionSelect() == 2) {
                    MeasureSettingParam measureSettingParam3 = this.param;
                    measureSettingParam3.saveCursorA(this.aorBManager.getLongStep(measureSettingParam3.getCursorA(), this.param.getCursorAAttr(), z, keyEvent));
                    return;
                }
                return;
            case R.id.high_edit_text /* 2131363048 */:
                measureSettingParam.saveThresholdHigh(this.aorBManager.getLongStep(measureSettingParam.getThresholdHigh(), this.param.getThresholdHighAttr(), z, keyEvent));
                queryThresholdValue(this.param.getThresholdHigh(), 3);
                return;
            case R.id.low_edit_text /* 2131363337 */:
                measureSettingParam.saveThresholdLow(this.aorBManager.getLongStep(measureSettingParam.getThresholdLow(), this.param.getThresholdLowAttr(), z, keyEvent));
                queryThresholdValue(this.param.getThresholdLow(), 1);
                return;
            case R.id.mid_edit_text /* 2131363397 */:
                measureSettingParam.saveThresholdMiddle(this.aorBManager.getLongStep(measureSettingParam.getThresholdMiddle(), this.param.getThresholdMiddleAttr(), z, keyEvent));
                queryThresholdValue(this.param.getThresholdMiddle(), 2);
                return;
            case R.id.stat_count_edit_text /* 2131363940 */:
                measureSettingParam.saveStatCount(this.aorBManager.getIntStep(measureSettingParam.getStatCount(), this.param.getStatCountAttr(), z, keyEvent));
                return;
            default:
                return;
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        MeasureSettingParam measureSettingParam = this.param;
        if (measureSettingParam == null) {
            return;
        }
        switch (i) {
            case R.id.cursor_a_edit_text /* 2131362336 */:
                measureSettingParam.saveCursorA(this.aorBManager.getLongDef(measureSettingParam.getCursorAAttr()));
                if (this.param.getRegionSelect() == 2) {
                    MeasureSettingParam measureSettingParam2 = this.param;
                    measureSettingParam2.saveCursorB(this.aorBManager.getLongDef(measureSettingParam2.getCursorBAttr()));
                    return;
                }
                return;
            case R.id.cursor_b_edit_text /* 2131362342 */:
                measureSettingParam.saveCursorB(this.aorBManager.getLongDef(measureSettingParam.getCursorBAttr()));
                if (this.param.getRegionSelect() == 2) {
                    MeasureSettingParam measureSettingParam3 = this.param;
                    measureSettingParam3.saveCursorA(this.aorBManager.getLongDef(measureSettingParam3.getCursorAAttr()));
                    return;
                }
                return;
            case R.id.high_edit_text /* 2131363048 */:
                measureSettingParam.saveThresholdHigh(this.aorBManager.getMeasureLongDef(measureSettingParam.getThresholdHighAttr(), this.param.getThresholdType(), "HIGH"));
                queryThresholdValue(this.aorBManager.getMeasureLongDef(this.param.getThresholdHighAttr(), this.param.getThresholdType(), "HIGH"), 3);
                return;
            case R.id.low_edit_text /* 2131363337 */:
                measureSettingParam.saveThresholdLow(this.aorBManager.getMeasureLongDef(measureSettingParam.getThresholdLowAttr(), this.param.getThresholdType(), "LOW"));
                queryThresholdValue(this.aorBManager.getMeasureLongDef(this.param.getThresholdLowAttr(), this.param.getThresholdType(), "LOW"), 1);
                return;
            case R.id.mid_edit_text /* 2131363397 */:
                measureSettingParam.saveThresholdMiddle(this.aorBManager.getMeasureLongDef(measureSettingParam.getThresholdMiddleAttr(), this.param.getThresholdType(), "MID"));
                queryThresholdValue(this.aorBManager.getMeasureLongDef(this.param.getThresholdMiddleAttr(), this.param.getThresholdType(), "MID"), 2);
                return;
            case R.id.stat_count_edit_text /* 2131363940 */:
                measureSettingParam.saveStatCount(this.aorBManager.getIntDef(measureSettingParam.getStatCountAttr()));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queryThresholdValue(long j, int i) {
        if (1 == i) {
            if (this.binding.thresholdDisplayTypeSwitch.isChecked()) {
                OrientationView.Companion.setStrThresholdLow(UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j, ServiceEnum.Unit.Unit_V));
                return;
            }
            OrientationView.Companion companion = OrientationView.Companion;
            companion.setStrThresholdLow(j + "%");
        } else if (2 == i) {
            if (this.binding.thresholdDisplayTypeSwitch.isChecked()) {
                OrientationView.Companion.setStrThresholdMiddle(UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j, ServiceEnum.Unit.Unit_V));
                return;
            }
            OrientationView.Companion companion2 = OrientationView.Companion;
            companion2.setStrThresholdMiddle(String.valueOf(j) + "%");
        } else if (this.binding.thresholdDisplayTypeSwitch.isChecked()) {
            OrientationView.Companion.setStrThresholdHigh(UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j, ServiceEnum.Unit.Unit_V));
        } else {
            OrientationView.Companion companion3 = OrientationView.Companion;
            companion3.setStrThresholdHigh(j + "%");
        }
    }
}
