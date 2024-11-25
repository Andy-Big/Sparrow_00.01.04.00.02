package com.rigol.scope.views.ref;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.pinyinkeyboard.ExternalInterface;
import com.rigol.scope.R;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.RefParam;
import com.rigol.scope.data.StorageLoadParam;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.databinding.PopupviewRefBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ScaleNumUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.RefViewModel;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.load.LoadPopupView;
import com.rigol.scope.views.ref.RefPopupView;
import com.rigol.scope.views.save.SavePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class RefPopupView extends BasePopupView implements AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private AorBManager aorBManager;
    private final PopupviewRefBinding binding;
    private View clickedView;
    private boolean isSave;
    private KeyboardPopupView keyboardPopupView;
    private List<AorBParam> list_aorbParam;
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    private RefParam param;
    private PopupSpinner popupSpinner;
    private SpinnerAdapter spinnerAdapter;
    private SyncDataViewModel syncDataViewModel;

    public RefPopupView() {
        super((int) R.style.App_PopupWindow_Ref);
        this.list_aorbParam = new ArrayList();
        PopupviewRefBinding inflate = PopupviewRefBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.scaleEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.offsetEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.sourceSpinner, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.refChannelSpinner, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.refColorSpinner, 0, false, "", 2));
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.views.ref.RefPopupView.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
                showKey(RefPopupView.this.context, ((AorBParam) RefPopupView.this.list_aorbParam.get(i)).getEditText(), true, ((AorBParam) RefPopupView.this.list_aorbParam.get(i)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
                showKey(RefPopupView.this.context, ((AorBParam) RefPopupView.this.list_aorbParam.get(i)).getEditText(), false, ((AorBParam) RefPopupView.this.list_aorbParam.get(i)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.scaleEditText, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.offsetEditText, true, ViewUtil.KEY_B);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.ref.-$$Lambda$RefPopupView$qCYZjxvYGAl3U4unxXerou38tm8
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        RefPopupView.this.lambda$new$2$RefPopupView((KeyEvent) obj);
                    }
                });
            }
        }
        if (this.syncDataViewModel == null) {
            SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
            this.syncDataViewModel = syncDataViewModel;
            if (syncDataViewModel != null) {
                syncDataViewModel.get(57, MessageID.MSG_FLEX_KNOB_REFRESH_REF_CHAN).observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.ref.-$$Lambda$RefPopupView$gkK00Qmxe7GHCvWr_Yv3_nUqVBI
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        RefPopupView.this.lambda$new$3$RefPopupView(obj);
                    }
                });
                this.syncDataViewModel.get(22, MessageID.MSG_REF_SCPI_CURRENT).observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.ref.-$$Lambda$RefPopupView$F-Ij7n4xgzKjmeLW7-pdkKsvEJY
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        RefPopupView.this.lambda$new$4$RefPopupView(obj);
                    }
                });
            }
        }
        RefViewModel refViewModel = (RefViewModel) ContextUtil.getAppViewModel(RefViewModel.class);
        if (refViewModel != null) {
            refViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer<RefParam>() { // from class: com.rigol.scope.views.ref.RefPopupView.2
                @Override // androidx.lifecycle.Observer
                public void onChanged(RefParam refParam) {
                    RefPopupView.this.param = refParam;
                    RefPopupView.this.binding.setParam(RefPopupView.this.param);
                }
            });
        }
        init();
    }

    public /* synthetic */ void lambda$new$2$RefPopupView(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(RefPopupView.class)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.views.ref.-$$Lambda$RefPopupView$QG9HlFF4A3M2RdkE6OYU7axvIHM
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    RefPopupView.this.lambda$new$0$RefPopupView(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.ref.-$$Lambda$RefPopupView$Ws7_taSBUhxhIpNII-8_Cby6JyI
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    RefPopupView.this.lambda$new$1$RefPopupView(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$RefPopupView(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$new$1$RefPopupView(int i, MappingObject mappingObject) {
        View view = this.clickedView;
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.ref_channel_spinner) {
            selectChan(mappingObject);
        } else if (id != R.id.source_spinner) {
        } else {
            selectSource(i);
        }
    }

    public /* synthetic */ void lambda$new$3$RefPopupView(Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            RefParam refParam = this.param;
            if (refParam != null) {
                refParam.saveRefChan(intValue);
            }
        }
    }

    public /* synthetic */ void lambda$new$4$RefPopupView(Object obj) {
        this.param.saveRefChan(this.param.readInt(MessageID.MSG_REF_CHANNEL));
    }

    public void setRefLight() {
        RefParam refParam = this.param;
        if (refParam == null || refParam.getParam() == null) {
            PopupViewManager.getInstance().closeAllLight();
        } else if (this.isSave) {
            PopupViewManager.getInstance().setLight(this.aorBManager);
        } else {
            PopupViewManager.getInstance().closeAllLight();
        }
    }

    public void init() {
        ViewUtil.setSwitchButton(this.binding.labelSwitch);
        this.binding.refChannelSpinner.setOnClickListener(new AnonymousClass3());
        this.binding.sourceSpinner.setOnClickListener(new AnonymousClass4());
        this.binding.saveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.ref.RefPopupView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!FunctionManager.getInstance().checkUltraIsOpen()) {
                    FunctionManager.getInstance().setFlexKnobEnum(ServiceEnum.Function.FUN_REF, RefPopupView.this.param.getRefChan(), false);
                    API.getInstance().UI_PostBool(RefPopupView.this.param.getServiceId(), MessageID.MSG_REF_SAVE, true);
                    RefPopupView.this.isSave = true;
                    FunctionManager.getInstance().refSwitch = true;
                    RefPopupView.this.setRefLight();
                    return;
                }
                ToastUtils.showShort((int) R.string.err_action_disabled);
            }
        });
        this.binding.cleanBtn.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.ref.RefPopupView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                API.getInstance().UI_PostBool(RefPopupView.this.param.getServiceId(), MessageID.MSG_REF_CLEAR, true);
                RefPopupView.this.isSave = false;
                RefPopupView.this.setRefLight();
            }
        });
        this.binding.scaleEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.ref.RefPopupView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RefPopupView.this.aorBManager.setClick_showab(view.getId())) {
                    RefPopupView.this.param.getParam().readScaleAttr();
                    ViewUtil.showKeyboard(RefPopupView.this.anchor, view, RefPopupView.this.param.getParam().getUnit(), RefPopupView.this.param.getParam().getVerScaleAttr().getMaxLongValue(), RefPopupView.this.param.getParam().getVerScaleAttr().getMinLongValue(), RefPopupView.this.param.getParam().getVerScaleAttr().getDefLongValue(), RefPopupView.this.param.getParam().getVerScale(), UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.views.ref.RefPopupView.7.1
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            RefPopupView.this.param.getParam().saveVerScale(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            RefPopupView.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                }
            }
        });
        this.binding.mainScaleVertical.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.ref.-$$Lambda$RefPopupView$kMIcWYFlGGpoE-bmgHY33naAa7M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RefPopupView.this.lambda$init$5$RefPopupView(view);
            }
        });
        this.binding.mainScaleNomal.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.ref.-$$Lambda$RefPopupView$qZI_6Bki54bidF3aL67t1rpAZqU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RefPopupView.this.lambda$init$6$RefPopupView(view);
            }
        });
        this.binding.offsetEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.ref.RefPopupView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RefPopupView.this.aorBManager.setClick_showab(view.getId())) {
                    RefPopupView.this.param.getParam().readOffsetAttr();
                    ViewUtil.showKeyboard(RefPopupView.this.anchor, view, RefPopupView.this.param.getParam().getUnit(), RefPopupView.this.param.getParam().getVerOffsetAttr().getMaxLongValue(), RefPopupView.this.param.getParam().getVerOffsetAttr().getMinLongValue(), RefPopupView.this.param.getParam().getVerOffsetAttr().getDefLongValue(), RefPopupView.this.param.getParam().getVerOffset(), UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.views.ref.RefPopupView.8.1
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            RefPopupView.this.param.getParam().saveVerOffset(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            RefPopupView.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                }
            }
        });
        this.binding.mathOffsetUp.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.ref.-$$Lambda$RefPopupView$fkVwFxaefTNZm1ZRpB2wdYmQLdo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RefPopupView.this.lambda$init$7$RefPopupView(view);
            }
        });
        this.binding.mathOffsetDown.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.ref.-$$Lambda$RefPopupView$E0yC5b3nvR_cTiA8U9-8Pk7xSZo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RefPopupView.this.lambda$init$8$RefPopupView(view);
            }
        });
        this.binding.importBtn.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.ref.RefPopupView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StorageLoadParam value;
                StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
                if (storageViewModel != null && (value = storageViewModel.getLoadLiveData().getValue()) != null) {
                    value.saveFileProc(ServiceEnum.StorageFunc.FUNC_LOAD_REF);
                    value.saveFileType(ServiceEnum.enFileType.FILETYPE_REF.value1);
                }
                PopupViewManager.getInstance().toggle(LoadPopupView.class);
            }
        });
        this.binding.refExportBtn.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.ref.RefPopupView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StorageSaveParam value;
                if (RefPopupView.this.param.getParam().isOnOff()) {
                    StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
                    if (storageViewModel != null && (value = storageViewModel.getSaveLiveData().getValue()) != null) {
                        value.saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_REF);
                        value.saveFileType(ServiceEnum.enFileType.FILETYPE_REF.value1);
                    }
                    PopupViewManager.getInstance().toggle(SavePopupView.class);
                }
            }
        });
        this.binding.labelEditText.setOnClickListener(new AnonymousClass11());
        this.binding.labelSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.views.ref.-$$Lambda$RefPopupView$l5iUCkTeogNOohIRWx2d0q5Sgg8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RefPopupView.this.lambda$init$9$RefPopupView(compoundButton, z);
            }
        });
        this.binding.refColorSpinner.setOnClickListener(new AnonymousClass12());
        this.binding.refResetBtn.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.ref.RefPopupView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                API.getInstance().UI_PostBool(RefPopupView.this.param.getServiceId(), MessageID.MSG_REF_RESET, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.ref.RefPopupView$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RefPopupView.this.anchor != null) {
                ViewUtil.showSpinner(RefPopupView.this.anchor, view, ViewUtil.getList((int) R.array.msg_ref_channel), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.ref.-$$Lambda$RefPopupView$3$lE_UoGz3WPgKRB2b-eTlKMGXNo0
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                        RefPopupView.AnonymousClass3.this.lambda$onClick$0$RefPopupView$3(popupSpinner, spinnerAdapter, list, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.ref.-$$Lambda$RefPopupView$3$OJj-46pguJq6STsKATKSdm30gZs
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        RefPopupView.AnonymousClass3.this.lambda$onClick$1$RefPopupView$3(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onClick$0$RefPopupView$3(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            RefPopupView.this.popupSpinner = popupSpinner;
            RefPopupView.this.spinnerAdapter = spinnerAdapter;
            RefPopupView.this.mappingObjects = list;
            RefPopupView.this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$1$RefPopupView$3(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            RefPopupView.this.selectChan(mappingObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.ref.RefPopupView$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewUtil.showChanSpinner(RefPopupView.this.anchor, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_ref_source)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.ref.-$$Lambda$RefPopupView$4$6r82mDSAzdbmLfMD8IOGRoMPrw0
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    RefPopupView.AnonymousClass4.this.lambda$onClick$0$RefPopupView$4(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.ref.-$$Lambda$RefPopupView$4$ROTMZI8ZCyDFxF-7LmInRuNkrnU
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    RefPopupView.AnonymousClass4.this.lambda$onClick$1$RefPopupView$4(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        }

        public /* synthetic */ void lambda$onClick$0$RefPopupView$4(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            RefPopupView.this.popupSpinner = popupSpinner;
            RefPopupView.this.spinnerAdapter = spinnerAdapter;
            RefPopupView.this.mappingObjects = list;
            RefPopupView.this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$1$RefPopupView$4(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            RefPopupView.this.selectSource(i);
        }
    }

    public /* synthetic */ void lambda$init$5$RefPopupView(View view) {
        scaleUp();
    }

    public /* synthetic */ void lambda$init$6$RefPopupView(View view) {
        scaleDown();
    }

    public /* synthetic */ void lambda$init$7$RefPopupView(View view) {
        offsetUp();
    }

    public /* synthetic */ void lambda$init$8$RefPopupView(View view) {
        offsetDown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.ref.RefPopupView$11  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass11 implements View.OnClickListener {
        AnonymousClass11() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewUtil.showPinyinKeyboard(RefPopupView.this.context, RefPopupView.this.anchor, view, new ExternalInterface() { // from class: com.rigol.scope.views.ref.-$$Lambda$RefPopupView$11$Cj5tc3MbSolhscq97sjAePgc4iQ
                @Override // com.rigol.pinyinkeyboard.ExternalInterface
                public final void resultShow(String str) {
                    RefPopupView.AnonymousClass11.this.lambda$onClick$0$RefPopupView$11(str);
                }
            });
        }

        public /* synthetic */ void lambda$onClick$0$RefPopupView$11(String str) {
            RefPopupView.this.param.getParam().saveLabel(str);
        }
    }

    public /* synthetic */ void lambda$init$9$RefPopupView(CompoundButton compoundButton, boolean z) {
        this.param.saveShowLabel(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.ref.RefPopupView$12  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass12 implements View.OnClickListener {
        AnonymousClass12() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewUtil.showSpinner(RefPopupView.this.anchor, view, ViewUtil.getList((int) R.array.msg_ref_color), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.ref.-$$Lambda$RefPopupView$12$XBC5Sl78pYNM5SwZP1otrJJOwUs
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    RefPopupView.AnonymousClass12.this.lambda$onClick$0$RefPopupView$12(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.ref.-$$Lambda$RefPopupView$12$WwFBj6JwZNwWyb-M_M_1gxy-L8M
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    RefPopupView.AnonymousClass12.this.lambda$onClick$1$RefPopupView$12(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        }

        public /* synthetic */ void lambda$onClick$0$RefPopupView$12(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            RefPopupView.this.popupSpinner = popupSpinner;
            RefPopupView.this.spinnerAdapter = spinnerAdapter;
            RefPopupView.this.mappingObjects = list;
            RefPopupView.this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$1$RefPopupView$12(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            RefPopupView.this.param.getParam().saveRefColor(ServiceEnum.getRefColorFromValue1(mappingObject.getValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectSource(int i) {
        this.param.getParam().saveSrcChan(ServiceEnum.getChanFromValue1(ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_ref_source)).get(i).getValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectChan(MappingObject mappingObject) {
        this.param.saveRefChan(mappingObject.getValue());
    }

    private void scaleDown() {
        this.param.getParam().saveVerScale(ScaleNumUtil.getMinusNum(this.param.getParam().getVerScale(), 1.0f));
    }

    private void scaleUp() {
        this.param.getParam().saveVerScale(ScaleNumUtil.getPlusNum(this.param.getParam().getVerScale(), 1.0f));
    }

    private void offsetDown() {
        long verScale = this.param.getParam().getVerScale();
        long verOffset = this.param.getParam().getVerOffset();
        long j = (verScale * 40) / 1000;
        if (j <= 0) {
            j = 1;
        }
        this.param.getParam().saveVerOffset(verOffset - j);
    }

    private void offsetUp() {
        long verScale = this.param.getParam().getVerScale();
        long verOffset = this.param.getParam().getVerOffset();
        long j = (verScale * 40) / 1000;
        if (j <= 0) {
            j = 1;
        }
        this.param.getParam().saveVerOffset(verOffset + j);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        RefParam refParam = this.param;
        if (refParam != null) {
            refParam.notifyPropertyChanged(716);
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        RefParam refParam = this.param;
        if (refParam == null || refParam.getParam() == null || !this.param.getParam().isOnOff()) {
            return;
        }
        if (i == R.id.offset_edit_text) {
            if (z) {
                offsetUp();
            } else {
                offsetDown();
            }
        } else if (i == R.id.scale_edit_text && this.param.getParam().getSrcChan().value1 < ServiceEnum.Chan.d0.value1) {
            if (z) {
                scaleDown();
            } else {
                scaleUp();
            }
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        RefParam refParam = this.param;
        if (refParam == null || refParam.getParam() == null || !this.param.getParam().isOnOff()) {
            return;
        }
        if (i != R.id.offset_edit_text) {
            if (i == R.id.scale_edit_text && this.param.getParam().getSrcChan().value1 < ServiceEnum.Chan.d0.value1) {
                this.param.getParam().saveVerScale(this.aorBManager.getLongDef(this.param.getParam().getVerScaleAttr()));
                return;
            }
            return;
        }
        this.param.getParam().saveVerOffset(this.aorBManager.getLongDef(this.param.getParam().getVerOffsetAttr()));
    }
}
