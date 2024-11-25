package com.rigol.scope.views.search;

import android.text.TextUtils;
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
import com.rigol.scope.adapters.SearchEdgeAdapter;
import com.rigol.scope.adapters.SearchPulseAdapter;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.NavigateParam;
import com.rigol.scope.data.SearchParam;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.databinding.PopupviewSearchBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.NavigateViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.SearchViewModel;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.navigate.NavigatePopupView;
import com.rigol.scope.views.save.SavePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;
/* loaded from: classes2.dex */
public class SearchPopupView extends BasePopupView implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private AorBManager aorBManager;
    private PopupviewSearchBinding binding;
    private View clickedView;
    private HorizontalParam horizontalParam;
    private final HorizontalViewModel horizontalViewModel;
    private boolean isEnable;
    private KeyboardPopupView keyboardPopupView;
    private List<AorBParam> list_aorbParam;
    private List<MappingObject> mappingObjects;
    private NavigateParam navigateParam;
    private final NavigateViewModel navigateViewModel;
    private PanelKeyViewModel panelKeyViewModel;
    private PopupSpinner popupSpinner;
    SearchEdgeAdapter searchEdgeAdapter;
    private SearchParam searchParam;
    SearchPulseAdapter searchPulseAdapter;
    private final SearchViewModel searchViewModel;
    private SpinnerAdapter spinnerAdapter;
    private SyncDataViewModel syncDataViewModel;
    private UpdateUIViewModel updateUIViewModel;

    public SearchPopupView() {
        super((int) R.style.App_PopupWindow_Search);
        this.list_aorbParam = new ArrayList();
        this.isEnable = true;
        PopupviewSearchBinding inflate = PopupviewSearchBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        SearchViewModel searchViewModel = (SearchViewModel) ContextUtil.getAppViewModel(SearchViewModel.class);
        this.searchViewModel = searchViewModel;
        if (searchViewModel != null) {
            searchViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer<SearchParam>() { // from class: com.rigol.scope.views.search.SearchPopupView.1
                @Override // androidx.lifecycle.Observer
                public void onChanged(SearchParam searchParam) {
                    SearchPopupView.this.searchParam = searchParam;
                    SearchPopupView.this.binding.setParam(searchParam);
                    if (searchParam != null) {
                        SearchPopupView.this.showSearch(searchParam.getType());
                    }
                }
            });
        }
        Timber.d("searchParam:%s", this.searchParam);
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        this.horizontalViewModel = horizontalViewModel;
        if (horizontalViewModel != null) {
            horizontalViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer<HorizontalParam>() { // from class: com.rigol.scope.views.search.SearchPopupView.2
                @Override // androidx.lifecycle.Observer
                public void onChanged(HorizontalParam horizontalParam) {
                    SearchPopupView.this.horizontalParam = horizontalParam;
                    SearchPopupView.this.binding.setHorizontal(horizontalParam);
                }
            });
        }
        NavigateViewModel navigateViewModel = (NavigateViewModel) ContextUtil.getAppViewModel(NavigateViewModel.class);
        this.navigateViewModel = navigateViewModel;
        if (navigateViewModel != null) {
            navigateViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.search.-$$Lambda$SearchPopupView$Gk-Q81ckHP8TWoWbrzy6W1X9doA
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SearchPopupView.this.lambda$new$0$SearchPopupView((NavigateParam) obj);
                }
            });
        }
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.typeSpinner, 0, false, "", 2));
        this.aorBManager = new AorBManager(this.context, this.list_aorbParam) { // from class: com.rigol.scope.views.search.SearchPopupView.3
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
                showKey(SearchPopupView.this.context, ((AorBParam) SearchPopupView.this.list_aorbParam.get(i)).getEditText(), true, ((AorBParam) SearchPopupView.this.list_aorbParam.get(i)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
                showKey(SearchPopupView.this.context, ((AorBParam) SearchPopupView.this.list_aorbParam.get(i)).getEditText(), false, ((AorBParam) SearchPopupView.this.list_aorbParam.get(i)).getAorb());
            }
        };
        this.updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.search.-$$Lambda$SearchPopupView$xcD99hpgE_8lPcr9f27ELySPncQ
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        SearchPopupView.this.lambda$new$3$SearchPopupView((KeyEvent) obj);
                    }
                });
            }
        }
        initPopWindow();
    }

    public /* synthetic */ void lambda$new$0$SearchPopupView(NavigateParam navigateParam) {
        this.navigateParam = navigateParam;
    }

    public /* synthetic */ void lambda$new$3$SearchPopupView(KeyEvent keyEvent) {
        PopupSpinner popupSpinner;
        List<MappingObject> list;
        if (this.isEnable && PopupViewManager.getInstance().isShowing(SearchPopupView.class) && (popupSpinner = this.popupSpinner) != null && popupSpinner.isShowing() && (list = this.mappingObjects) != null) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, list, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.views.search.-$$Lambda$SearchPopupView$XCw6OlJJ6kQwPUF3yps-VV6OZDU
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    SearchPopupView.this.lambda$new$1$SearchPopupView(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.search.-$$Lambda$SearchPopupView$v3BRBfCQjJ823F5gVNJPDQToT0I
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    SearchPopupView.this.lambda$new$2$SearchPopupView(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$1$SearchPopupView(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$new$2$SearchPopupView(int i, MappingObject mappingObject) {
        selectAdapter(mappingObject);
    }

    private void initPopWindow() {
        ViewUtil.setSwitchButton(this.binding.enableSwitchButton);
        ViewUtil.setSwitchButton(this.binding.markTableSwitchButton);
        this.binding.enableSwitchButton.setOnCheckedChangeListener(this);
        this.binding.typeSpinner.setOnClickListener(this);
        this.binding.markTableSwitchButton.setOnCheckedChangeListener(this);
        this.binding.copyToTriggerBtn.setOnClickListener(this);
        this.binding.copyFromTriggerBtn.setOnClickListener(this);
        this.binding.saveBtn.setOnClickListener(this);
        this.binding.playLastImage.setOnClickListener(this);
        this.binding.playnextImage.setOnClickListener(this);
        this.binding.navigateBut.setOnClickListener(this);
        if (this.syncDataViewModel == null) {
            SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
            this.syncDataViewModel = syncDataViewModel;
            if (syncDataViewModel != null) {
                syncDataViewModel.get(25, MessageID.MSG_SEARCH_MARK_TABEL_EN).observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.search.-$$Lambda$SearchPopupView$9kKCihNXACq2fVTZ5ToxNNhhabU
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        SearchPopupView.this.lambda$initPopWindow$4$SearchPopupView(obj);
                    }
                });
                this.syncDataViewModel.get(25, MessageID.MSG_SEARCH_NAVIGATION_EVENT).observe((LifecycleOwner) this.context, new Observer<Object>() { // from class: com.rigol.scope.views.search.SearchPopupView.4
                    @Override // androidx.lifecycle.Observer
                    public void onChanged(Object obj) {
                        SearchPopupView.this.searchParam.saveNavigation(((Integer) obj).intValue());
                    }
                });
                this.syncDataViewModel.get(25, MessageID.MSG_SEARCH_EN).observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.search.-$$Lambda$SearchPopupView$D4RYyZsdgjKln1bAByOtUXT-fjg
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        SearchPopupView.this.lambda$initPopWindow$5$SearchPopupView(obj);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$initPopWindow$4$SearchPopupView(Object obj) {
        this.searchParam.setTabelOnOff(false);
    }

    public /* synthetic */ void lambda$initPopWindow$5$SearchPopupView(Object obj) {
        this.binding.enableSwitchButton.setChecked(this.searchParam.isEnable());
        showSearch(this.searchParam.getType());
    }

    private void selectAdapter(MappingObject mappingObject) {
        if (mappingObject != null) {
            this.searchParam.saveType(ServiceEnum.getenumSearchTypeFromValue1(mappingObject.getValue()));
        }
    }

    private void initView() {
        if (this.searchEdgeAdapter == null) {
            this.searchEdgeAdapter = new SearchEdgeAdapter(this.searchParam, this.context);
        }
        if (this.searchPulseAdapter == null) {
            this.searchPulseAdapter = new SearchPulseAdapter(this.searchParam, this.context);
        }
        this.searchEdgeAdapter.setMove(false);
        this.searchPulseAdapter.setMove(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.search.SearchPopupView$5  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$enumSearchType;

        static {
            int[] iArr = new int[ServiceEnum.enumSearchType.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$enumSearchType = iArr;
            try {
                iArr[ServiceEnum.enumSearchType.SEARCH_TYPE_EDGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$enumSearchType[ServiceEnum.enumSearchType.SEARCH_TYPE_PULSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$enumSearchType[ServiceEnum.enumSearchType.SEARCH_TYPE_RUNT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$enumSearchType[ServiceEnum.enumSearchType.SEARCH_TYPE_SLOPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$enumSearchType[ServiceEnum.enumSearchType.SEARCH_TYPE_RS232.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$enumSearchType[ServiceEnum.enumSearchType.SEARCH_TYPE_IIC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$enumSearchType[ServiceEnum.enumSearchType.SEARCH_TYPE_SPI.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public void showSearch(ServiceEnum.enumSearchType enumsearchtype) {
        if (enumsearchtype == null) {
            return;
        }
        initView();
        int i = AnonymousClass5.$SwitchMap$com$rigol$scope$cil$ServiceEnum$enumSearchType[enumsearchtype.ordinal()];
        if (i == 1) {
            this.searchEdgeAdapter.setMove(this.binding.enableSwitchButton.isChecked());
            this.searchEdgeAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.search.-$$Lambda$SearchPopupView$Nj_Xdm8ePj6navKpWMlQ9xOR24g
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    SearchPopupView.this.lambda$showSearch$6$SearchPopupView(z);
                }
            });
            this.binding.searchView.setAdapter(this.searchEdgeAdapter);
        } else if (i == 2) {
            this.searchPulseAdapter.setMove(true);
            this.searchPulseAdapter.setListener(this.binding, new AorBManager.OnOutOrInAdapterClickChangeListener() { // from class: com.rigol.scope.views.search.-$$Lambda$SearchPopupView$nUd52SWD1TAgblOXkW14zoQP5ck
                @Override // com.rigol.scope.utilities.AorBManager.OnOutOrInAdapterClickChangeListener
                public final void onChange(boolean z) {
                    SearchPopupView.this.lambda$showSearch$7$SearchPopupView(z);
                }
            });
            this.binding.searchView.setAdapter(this.searchPulseAdapter);
        }
        searchLight();
    }

    public /* synthetic */ void lambda$showSearch$6$SearchPopupView(boolean z) {
        this.isEnable = z;
    }

    public /* synthetic */ void lambda$showSearch$7$SearchPopupView(boolean z) {
        this.isEnable = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StorageSaveParam value;
        int id = view.getId();
        if (view.isPressed()) {
            this.isEnable = true;
            if (id == R.id.type_spinner) {
                ViewUtil.showSpinner(this.anchor, view, ViewUtil.getList((int) R.array.msg_search_type), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.search.-$$Lambda$SearchPopupView$FOqYAJ3QjY16KX0VFNPziQp4XA4
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                        SearchPopupView.this.lambda$onClick$8$SearchPopupView(popupSpinner, spinnerAdapter, list, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.search.-$$Lambda$SearchPopupView$tZKMew7dJjRvB8qPiDIfiUHi5F8
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        SearchPopupView.this.lambda$onClick$9$SearchPopupView(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
            } else if (id == R.id.copyToTrigger_btn) {
                this.searchParam.copyToTrigger();
            } else if (id == R.id.copyFromTrigger_btn) {
                this.searchParam.copyFromTrigger();
            } else if (id != R.id.save_btn) {
                if (id == R.id.playLastImage) {
                    this.searchParam.savenewNavigation(ServiceEnum.NavigationType.BACKWARD.value1);
                } else if (id == R.id.playnextImage) {
                    this.searchParam.savenewNavigation(ServiceEnum.NavigationType.FORWARD.value1);
                } else if (id == R.id.navigateBut) {
                    this.navigateParam.setSelectMode(1);
                    PopupViewManager.getInstance().toggle(NavigatePopupView.class);
                }
            } else {
                String UI_QueryStr = API.getInstance().UI_QueryStr(25, MessageID.MSG_APP_SEARCH_QUERY_DATA_EVT);
                if (TextUtils.isEmpty(UI_QueryStr)) {
                    ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.msg_storage_toast_fail));
                    return;
                }
                StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
                if (storageViewModel != null && (value = storageViewModel.getSaveLiveData().getValue()) != null) {
                    value.setDecodeDataPath(UI_QueryStr);
                    value.saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_DECDAT);
                    value.saveFileType(ServiceEnum.enFileType.FILETYPE_CSV.value1);
                }
                PopupViewManager.getInstance().toggle(SavePopupView.class);
            }
        }
    }

    public /* synthetic */ void lambda$onClick$8$SearchPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$9$SearchPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectAdapter(mappingObject);
    }

    public void searchLight() {
        if (this.binding.enableSwitchButton.isChecked()) {
            SearchParam searchParam = this.searchParam;
            if (searchParam != null) {
                ServiceEnum.enumSearchType type = searchParam.getType();
                PopupViewManager.getInstance().closeAllLight();
                if (type == ServiceEnum.enumSearchType.SEARCH_TYPE_EDGE) {
                    PopupViewManager.getInstance().setLight(this.searchParam.getEdgeAorBManager());
                    return;
                } else if (type == ServiceEnum.enumSearchType.SEARCH_TYPE_PULSE) {
                    if (this.searchParam.getPulseAorBManager() == null) {
                        PopupViewManager.getInstance().AVerticalLight_Open();
                        PopupViewManager.getInstance().BHorizontalLight_Open();
                        return;
                    }
                    PopupViewManager.getInstance().setLight(this.searchParam.getPulseAorBManager());
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        PopupViewManager.getInstance().closeAllLight();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            searchLight();
            if (compoundButton.getId() == R.id.enable_switchButton) {
                if (FunctionManager.getInstance().checkUltraIsOpen()) {
                    ToastUtils.showShort((int) R.string.err_action_disabled);
                }
                this.searchParam.saveEnable(z);
                SearchEdgeAdapter searchEdgeAdapter = this.searchEdgeAdapter;
                if (searchEdgeAdapter != null) {
                    searchEdgeAdapter.setMove(this.binding.enableSwitchButton.isChecked());
                }
                if (z) {
                    SearchParam searchParam = this.searchParam;
                    searchParam.saveNavigation(searchParam.readNavigation());
                } else {
                    this.searchParam.saveMarkTableEn(z);
                }
                MessageBus.getInstance().onSyncData(MessageBus.getKey(25, MessageID.MSG_SEARCH_EN), false);
                if (z) {
                    return;
                }
                WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_SEARCH);
            } else if (compoundButton.getId() == R.id.markTable_switchButton) {
                this.searchParam.saveTabelOnOff(z);
                if (z) {
                    WindowParam windowParam = new WindowParam();
                    ServiceEnum.Chan chan = ServiceEnum.Chan.chan1;
                    ServiceEnum.Chan chan2 = ServiceEnum.Chan.chan2;
                    windowParam.setSource1(chan);
                    windowParam.setServiceID(25);
                    windowParam.setType(ServiceEnum.WindowType.WIN_SEARCH);
                    ((MainActivity) ActivityUtils.getTopActivity()).getWaveformFragment().addWindow(windowParam);
                    this.searchParam.saveMarkTableEn(z);
                    return;
                }
                WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_SEARCH);
                this.searchParam.saveMarkTableEn(z);
                MessageBus.getInstance().onSyncData(MessageBus.getKey(25, MessageID.MSG_SEARCH_MARK_TABEL_EN), false);
            }
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        this.searchViewModel.get(new Object[0]);
        super.showAtLocation(view, i, i2, i3);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        this.searchViewModel.get(new Object[0]);
        super.showAsDropDown(view, i, i2, i3);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
    }
}
