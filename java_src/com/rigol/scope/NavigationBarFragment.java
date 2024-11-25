package com.rigol.scope;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.AppUtils;
import com.rigol.scope.adapters.BaseAdapter;
import com.rigol.scope.adapters.BaseViewHolder;
import com.rigol.scope.adapters.OnItemClickListener;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.OptionParam;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.databinding.AdapterItemShortcutBinding;
import com.rigol.scope.databinding.FragmentNavigationBarBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.KeyCodeUtil;
import com.rigol.scope.utilities.KtUtilKt;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.CursorViewModel;
import com.rigol.scope.viewmodels.DisplayViewModel;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.MaskViewModel;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.viewmodels.NavigateViewModel;
import com.rigol.scope.viewmodels.OptionViewModel;
import com.rigol.scope.viewmodels.SearchViewModel;
import com.rigol.scope.viewmodels.TriggerViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.viewmodels.ViewABkeyViewModel;
import com.rigol.scope.views.alert.AppSwitchPopupView;
import com.rigol.scope.views.horizontal.HorizontalPopupView;
import com.rigol.scope.views.horizontal.HorizontalSpaceItemDecoration;
import com.rigol.scope.views.trigger.TriggerPopupView;
import com.rigol.util.PackageUtilKt;
import com.rigol.util.ToastUtils;
import java.util.List;
import kotlin.jvm.functions.Function1;
import timber.log.Timber;
/* loaded from: classes.dex */
public class NavigationBarFragment extends BaseFragment {
    private static final int GET_TRIGGER_STATUS_DELAY_TIME = 500;
    private static final int GET_TRIGGER_STATUS_MSG_WHAT = 0;
    private FragmentNavigationBarBinding binding;
    private CursorViewModel cursorViewModel;
    private DisplayViewModel displayViewModel;
    private HorizontalParam horizontalParam;
    private HorizontalViewModel horizontalViewModel;
    private MaskViewModel maskViewModel;
    private MathViewModel mathViewModel;
    private NavigateViewModel navigateViewModel;
    private OptionParam optionParam;
    private OptionViewModel optionViewModel;
    private SearchViewModel searchViewModel;
    private BaseAdapter<List<MappingObject>> shortcutAdapter;
    private List<MappingObject> shortcutData;
    private TriggerViewModel triggerViewModel;
    private UtilityParam utilityParam;
    private UtilityViewModel utilityViewModel;
    private VerticalViewModel verticalViewModel;
    private ViewABkeyViewModel viewABkeyViewModel;
    final int[] locationOnScreen = new int[2];
    private final Handler.Callback callback = new Handler.Callback() { // from class: com.rigol.scope.NavigationBarFragment.1
        private int i = 0;

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 0) {
                if (NavigationBarFragment.this.horizontalParam != null) {
                    ServiceEnum.ControlStatus readTriggerStatus = NavigationBarFragment.this.horizontalParam.readTriggerStatus();
                    if (readTriggerStatus != ServiceEnum.ControlStatus.Status_Running && readTriggerStatus != ServiceEnum.ControlStatus.Status_Autoing && readTriggerStatus != ServiceEnum.ControlStatus.Status_Waiting) {
                        this.i = 0;
                        NavigationBarFragment.this.binding.status.setBackground(ContextCompat.getDrawable(NavigationBarFragment.this.mActivity, R.drawable.ic_state_bg));
                    } else {
                        if (this.i % 2 == 0) {
                            NavigationBarFragment.this.binding.status.setBackgroundColor(ContextCompat.getColor(NavigationBarFragment.this.mActivity, 17170445));
                        } else {
                            NavigationBarFragment.this.binding.status.setBackground(ContextCompat.getDrawable(NavigationBarFragment.this.mActivity, R.drawable.ic_state_bg));
                        }
                        this.i++;
                    }
                    NavigationBarFragment.this.binding.status.setText(NavigationBarFragment.this.horizontalParam.getTriggerStatus().value2);
                    int i = AnonymousClass6.$SwitchMap$com$rigol$scope$cil$ServiceEnum$ControlStatus[readTriggerStatus.ordinal()];
                    if (i == 1) {
                        NavigationBarFragment.this.binding.status.setTextColor(ContextCompat.getColor(NavigationBarFragment.this.mActivity, R.color.red));
                    } else if (i == 2 || i == 3 || i == 4 || i == 5) {
                        NavigationBarFragment.this.binding.status.setTextColor(ContextCompat.getColor(NavigationBarFragment.this.mActivity, R.color.spring_green));
                    }
                }
                if (NavigationBarFragment.this.utilityParam != null) {
                    NavigationBarFragment.this.utilityParam.readDate();
                }
                if (NavigationBarFragment.this.handler != null) {
                    NavigationBarFragment.this.handler.sendEmptyMessageDelayed(0, 500L);
                }
            }
            return true;
        }
    };
    private Handler handler = new Handler(this.callback);

    public FragmentNavigationBarBinding getBinding() {
        return this.binding;
    }

    /* renamed from: com.rigol.scope.NavigationBarFragment$6  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$ControlStatus;

        static {
            int[] iArr = new int[ServiceEnum.ControlStatus.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$ControlStatus = iArr;
            try {
                iArr[ServiceEnum.ControlStatus.Status_Stoped.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$ControlStatus[ServiceEnum.ControlStatus.Status_Running.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$ControlStatus[ServiceEnum.ControlStatus.Status_Autoing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$ControlStatus[ServiceEnum.ControlStatus.Status_Waiting.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$ControlStatus[ServiceEnum.ControlStatus.Status_TD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.rigol.scope.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.horizontalViewModel = (HorizontalViewModel) getAppViewModelProvider().get(HorizontalViewModel.class);
        this.verticalViewModel = (VerticalViewModel) getAppViewModelProvider().get(VerticalViewModel.class);
        this.triggerViewModel = (TriggerViewModel) getAppViewModelProvider().get(TriggerViewModel.class);
        this.cursorViewModel = (CursorViewModel) getAppViewModelProvider().get(CursorViewModel.class);
        this.mathViewModel = (MathViewModel) getAppViewModelProvider().get(MathViewModel.class);
        this.displayViewModel = (DisplayViewModel) getAppViewModelProvider().get(DisplayViewModel.class);
        this.optionViewModel = (OptionViewModel) getAppViewModelProvider().get(OptionViewModel.class);
        this.viewABkeyViewModel = (ViewABkeyViewModel) getAppViewModelProvider().get(ViewABkeyViewModel.class);
        this.utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
        this.navigateViewModel = (NavigateViewModel) getAppViewModelProvider().get(NavigateViewModel.class);
        this.searchViewModel = (SearchViewModel) getAppViewModelProvider().get(SearchViewModel.class);
        this.maskViewModel = (MaskViewModel) getAppViewModelProvider().get(MaskViewModel.class);
        UtilityViewModel utilityViewModel = this.utilityViewModel;
        if (utilityViewModel != null) {
            this.utilityParam = utilityViewModel.getLiveData().getValue();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        OptionViewModel optionViewModel = this.optionViewModel;
        if (optionViewModel != null) {
            this.optionParam = optionViewModel.getLiveData().getValue();
            this.optionViewModel.getLiveData().observe(this.mActivity, new Observer() { // from class: com.rigol.scope.-$$Lambda$NavigationBarFragment$nMbTToVCFBb9C_3NZhxg8xp9PdU
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    NavigationBarFragment.this.lambda$onCreateView$0$NavigationBarFragment((OptionParam) obj);
                }
            });
        }
        this.binding = FragmentNavigationBarBinding.inflate(LayoutInflater.from(this.mActivity));
        PopupViewManager.getInstance().setTag(this.binding.horizontalScaleBtn, HorizontalPopupView.class);
        this.binding.triggerBtn.setTag(TriggerPopupView.class.getSimpleName());
        this.binding.triggerInfo.setTag(TriggerPopupView.class.getSimpleName());
        final boolean isAppInstalled = AppUtils.isAppInstalled(PackageUtilKt.PACKAGE_NAME_AWG);
        this.binding.appSwitch.setEnabled(isAppInstalled);
        this.binding.appSwitch.setAlpha(ContextUtil.getAlpha(isAppInstalled));
        if (this.utilityViewModel.getLiveData().getValue().getSeries() == 800) {
            this.binding.logo.setImageResource(R.drawable.ic_logo100);
        }
        this.binding.appSwitch.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.-$$Lambda$NavigationBarFragment$NGI3hwtVBf_KHuUVJzxtDD-qz84
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NavigationBarFragment.this.lambda$onCreateView$1$NavigationBarFragment(isAppInstalled, view);
            }
        });
        this.binding.functionListLeftArrow.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.-$$Lambda$NavigationBarFragment$WOC-Uta9osJtDY0EIgMRZW4mopk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NavigationBarFragment.this.lambda$onCreateView$2$NavigationBarFragment(view);
            }
        });
        this.binding.functionListRightArrow.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.-$$Lambda$NavigationBarFragment$WrJWkilUYzEQ7k0kIn3STbGeI98
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NavigationBarFragment.this.lambda$onCreateView$3$NavigationBarFragment(view);
            }
        });
        this.binding.functionList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.rigol.scope.NavigationBarFragment.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    NavigationBarFragment.this.refreshArrowState();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
            }
        });
        this.handler.sendEmptyMessageDelayed(0, 500L);
        this.horizontalViewModel.getLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$NavigationBarFragment$nBwngPU74xxQXxApYac50P7cvH0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NavigationBarFragment.this.lambda$onCreateView$4$NavigationBarFragment((HorizontalParam) obj);
            }
        });
        this.horizontalViewModel.get(new Object[0]);
        PopupViewManager.getInstance().add(HorizontalPopupView.class, new HorizontalPopupView());
        this.triggerViewModel.getLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$NavigationBarFragment$4EqMXoXdBKeCpaoyqqMyHVJepqo
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NavigationBarFragment.this.lambda$onCreateView$5$NavigationBarFragment((TriggerParam) obj);
            }
        });
        this.triggerViewModel.get(new Object[0]);
        this.triggerViewModel.getLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$NavigationBarFragment$okb6XxcnI-qSqmS7cHT_n3g26Jo
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NavigationBarFragment.this.lambda$onCreateView$6$NavigationBarFragment((TriggerParam) obj);
            }
        });
        TriggerPopupView triggerPopupView = new TriggerPopupView();
        triggerPopupView.setSharedViewModel(this.sharedViewModel);
        PopupViewManager.getInstance().add(TriggerPopupView.class, triggerPopupView);
        filterData();
        ViewUtil.setSupportsChangeAnimations(this.binding.functionList, false);
        this.binding.functionList.addItemDecoration(new HorizontalSpaceItemDecoration(5));
        this.shortcutAdapter = new BaseAdapter<List<MappingObject>>(this.mActivity, this.shortcutData, R.layout.adapter_item_shortcut) { // from class: com.rigol.scope.NavigationBarFragment.3
            @Override // com.rigol.scope.adapters.BaseAdapter
            protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<MappingObject> list, int i) {
                AdapterItemShortcutBinding adapterItemShortcutBinding = (AdapterItemShortcutBinding) baseViewHolder.getBinding();
                MappingObject mappingObject = list.get(i);
                ServiceEnum.Function functionFromValue1 = ServiceEnum.getFunctionFromValue1(mappingObject.getValue());
                adapterItemShortcutBinding.setObj(mappingObject);
                adapterItemShortcutBinding.setFunction(functionFromValue1);
                adapterItemShortcutBinding.executePendingBindings();
                if (functionFromValue1 == ServiceEnum.Function.FUN_RUN_STOP || functionFromValue1 == ServiceEnum.Function.FUN_DEFAULT || functionFromValue1 == ServiceEnum.Function.FUN_FFT) {
                    adapterItemShortcutBinding.title.setVisibility(8);
                } else {
                    adapterItemShortcutBinding.title.setVisibility(0);
                }
                if (functionFromValue1 != null) {
                    PopupViewManager.getInstance().setTag(adapterItemShortcutBinding.getRoot(), functionFromValue1);
                }
                adapterItemShortcutBinding.icon.setColorFilter(-1);
                if (functionFromValue1 != ServiceEnum.Function.FUN_RUN_STOP || NavigationBarFragment.this.horizontalParam == null) {
                    return;
                }
                if (NavigationBarFragment.this.horizontalParam.getRunStop() == ServiceEnum.ControlAction.Control_Stop) {
                    adapterItemShortcutBinding.icon.setColorFilter(SupportMenu.CATEGORY_MASK);
                } else {
                    adapterItemShortcutBinding.icon.setColorFilter(-16711936);
                }
            }
        };
        this.binding.functionList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.rigol.scope.NavigationBarFragment.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    ViewUtil.setListOutsideEnableClickRects(NavigationBarFragment.this.binding.functionList, NavigationBarFragment.this.shortcutData, NavigationBarFragment.this.locationOnScreen);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
            }
        });
        this.shortcutAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.rigol.scope.-$$Lambda$NavigationBarFragment$-aAcecFR5G_IDGmgiJ38MxVMROI
            @Override // com.rigol.scope.adapters.OnItemClickListener
            public final void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
                NavigationBarFragment.this.lambda$onCreateView$7$NavigationBarFragment(view, viewHolder, i);
            }
        });
        this.binding.functionList.setAdapter(this.shortcutAdapter);
        this.binding.functionList.post(new Runnable() { // from class: com.rigol.scope.-$$Lambda$NavigationBarFragment$ratRMEqwBT1K4dzCJM15v2qskm0
            @Override // java.lang.Runnable
            public final void run() {
                NavigationBarFragment.this.lambda$onCreateView$8$NavigationBarFragment();
            }
        });
        if (this.syncDataViewModel != null) {
            this.syncDataViewModel.get(36, MessageID.MSG_LICENSE_CHANGED).observe(this.mActivity, new Observer() { // from class: com.rigol.scope.-$$Lambda$NavigationBarFragment$hyS5FerMDabpWqvLuclq11c5m-o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    NavigationBarFragment.this.lambda$onCreateView$9$NavigationBarFragment(obj);
                }
            });
            this.syncDataViewModel.get(57, MessageID.MSG_FLEX_KNOB_REFRESH_ICON).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$NavigationBarFragment$_eMdCNg2gstSg3XvvUFbte-8hUc
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    NavigationBarFragment.this.lambda$onCreateView$10$NavigationBarFragment(obj);
                }
            });
        }
        return this.binding.getRoot();
    }

    public /* synthetic */ void lambda$onCreateView$0$NavigationBarFragment(OptionParam optionParam) {
        this.optionParam = optionParam;
    }

    public /* synthetic */ void lambda$onCreateView$1$NavigationBarFragment(boolean z, View view) {
        if (z) {
            PopupViewManager.getInstance().toggle(AppSwitchPopupView.class);
        } else {
            ToastUtils.showShort(getResources().getString(R.string.msg_toast_not_instlled));
        }
    }

    public /* synthetic */ void lambda$onCreateView$2$NavigationBarFragment(View view) {
        RecyclerView.LayoutManager layoutManager = this.binding.functionList.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() - 3;
            if (findFirstVisibleItemPosition < 0) {
                findFirstVisibleItemPosition = 0;
            }
            this.binding.functionList.smoothScrollToPosition(findFirstVisibleItemPosition);
        }
    }

    public /* synthetic */ void lambda$onCreateView$3$NavigationBarFragment(View view) {
        RecyclerView.LayoutManager layoutManager = this.binding.functionList.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() + 3;
            if (findLastVisibleItemPosition >= this.shortcutAdapter.getItemCount()) {
                findLastVisibleItemPosition = this.shortcutAdapter.getItemCount() - 1;
            }
            this.binding.functionList.smoothScrollToPosition(findLastVisibleItemPosition);
        }
    }

    public /* synthetic */ void lambda$onCreateView$4$NavigationBarFragment(HorizontalParam horizontalParam) {
        this.horizontalParam = horizontalParam;
        this.binding.setHorizontalParam(horizontalParam);
        this.updateUIViewModel.bind(getViewLifecycleOwner(), horizontalParam);
    }

    public /* synthetic */ void lambda$onCreateView$5$NavigationBarFragment(TriggerParam triggerParam) {
        this.binding.setTriggerParam(triggerParam);
    }

    public /* synthetic */ void lambda$onCreateView$6$NavigationBarFragment(TriggerParam triggerParam) {
        this.updateUIViewModel.bind(getViewLifecycleOwner(), triggerParam);
    }

    public /* synthetic */ void lambda$onCreateView$7$NavigationBarFragment(View view, RecyclerView.ViewHolder viewHolder, int i) {
        FunctionManager.getInstance().handleItemClick(ServiceEnum.getFunctionFromValue1(this.shortcutData.get(i).getValue()));
    }

    public /* synthetic */ void lambda$onCreateView$8$NavigationBarFragment() {
        ViewUtil.setListOutsideEnableClickRects(this.binding.functionList, this.shortcutData, this.locationOnScreen);
        refreshArrowState();
    }

    public /* synthetic */ void lambda$onCreateView$9$NavigationBarFragment(Object obj) {
        filterData();
        BaseAdapter<List<MappingObject>> baseAdapter = this.shortcutAdapter;
        if (baseAdapter != null) {
            baseAdapter.setItems(this.shortcutData);
            this.shortcutAdapter.notifyDataSetChanged();
        }
    }

    public /* synthetic */ void lambda$onCreateView$10$NavigationBarFragment(Object obj) {
        if (this.shortcutAdapter == null || !(obj instanceof MappingObject)) {
            return;
        }
        MappingObject mappingObject = (MappingObject) obj;
        this.shortcutData.get(3).setPic(mappingObject.getPic());
        this.shortcutData.get(3).setPi(mappingObject.getPi());
        this.shortcutData.get(3).setStr(mappingObject.getStr());
        this.shortcutAdapter.notifyItemChanged(3);
        ServiceEnum.FlexKnobEnum flexKnobEnumFromValue1 = ServiceEnum.getFlexKnobEnumFromValue1(mappingObject.getValue());
        FunctionManager.getInstance().setCurrentFlexKnobEnum(flexKnobEnumFromValue1);
        FunctionManager.getInstance().selectLight(flexKnobEnumFromValue1);
        PopupViewManager.getInstance().cursorABHint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshArrowState() {
        RecyclerView.LayoutManager layoutManager = this.binding.functionList.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            this.binding.functionListLeftArrow.setAlpha(ContextUtil.getAlpha(findFirstCompletelyVisibleItemPosition != 0));
            this.binding.functionListLeftArrow.setEnabled(findFirstCompletelyVisibleItemPosition != 0);
            int itemCount = this.shortcutAdapter.getItemCount() - 1;
            this.binding.functionListRightArrow.setAlpha(ContextUtil.getAlpha(findLastCompletelyVisibleItemPosition != itemCount));
            this.binding.functionListRightArrow.setEnabled(findLastCompletelyVisibleItemPosition != itemCount);
        }
    }

    private void filterData() {
        this.shortcutData = KtUtilKt.filter(ViewUtil.getList((int) R.array.msg_app_shortcut), new Function1() { // from class: com.rigol.scope.-$$Lambda$NavigationBarFragment$j2rrDB_yucjjHgIk0-fKiINcch0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationBarFragment.this.lambda$filterData$11$NavigationBarFragment((MappingObject) obj);
            }
        });
    }

    public /* synthetic */ Boolean lambda$filterData$11$NavigationBarFragment(MappingObject mappingObject) {
        ServiceEnum.Function functionFromValue1;
        if (mappingObject == null || (functionFromValue1 = ServiceEnum.getFunctionFromValue1(mappingObject.getValue())) == null) {
            return true;
        }
        return Boolean.valueOf(KtUtilKt.functionEnable(functionFromValue1, this.optionParam));
    }

    @Override // com.rigol.scope.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.panelKeyViewModel.getOnKeyUpData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$NavigationBarFragment$6vRHDuj8vG6ahs9ibOKI_w-7QeQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NavigationBarFragment.this.lambda$onViewCreated$12$NavigationBarFragment((KeyEvent) obj);
            }
        });
        this.syncDataViewModel.get(10, MessageID.MSG_HOR_RUN).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$NavigationBarFragment$ZT_JWxIEmVgez4pAb5kcJZsPPx4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NavigationBarFragment.this.lambda$onViewCreated$13$NavigationBarFragment(obj);
            }
        });
        this.updateUIViewModel.get(11, MessageID.MSG_APP_SW_WORK_MODE).observe(getViewLifecycleOwner(), new Observer<Boolean>() { // from class: com.rigol.scope.NavigationBarFragment.5
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (API.getInstance().UI_QueryInt32(11, MessageID.MSG_APP_SW_WORK_MODE) == 2) {
                    ViewUtil.gotoAWG();
                }
            }
        });
        ViewUtil.addOutsideEnableClickRects(this.locationOnScreen, this.binding.horizontalScaleBtn, HorizontalPopupView.class);
        ViewUtil.addOutsideEnableClickRects(this.locationOnScreen, this.binding.horizontalScaleInfo, HorizontalPopupView.class);
        ViewUtil.addOutsideEnableClickRects(this.locationOnScreen, this.binding.horizontalOffsetBtn, HorizontalPopupView.class);
        ViewUtil.addOutsideEnableClickRects(this.locationOnScreen, this.binding.horizontalOffsetInfo, HorizontalPopupView.class);
        ViewUtil.addOutsideEnableClickRects(this.locationOnScreen, this.binding.acquireBtn, HorizontalPopupView.class);
        ViewUtil.addOutsideEnableClickRects(this.locationOnScreen, this.binding.acquireInfo, HorizontalPopupView.class);
        ViewUtil.addOutsideEnableClickRects(this.locationOnScreen, this.binding.triggerBtn, TriggerPopupView.class);
        ViewUtil.addOutsideEnableClickRects(this.locationOnScreen, this.binding.triggerInfo, TriggerPopupView.class);
    }

    public /* synthetic */ void lambda$onViewCreated$12$NavigationBarFragment(KeyEvent keyEvent) {
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        if (panelKey > 0) {
            this.panelKeyViewModel.onPanelKeyUp(panelKey, keyEvent, this.horizontalViewModel.getLiveData().getValue(), this.verticalViewModel.getLiveData().getValue(), this.triggerViewModel.getLiveData().getValue(), this.cursorViewModel.getLiveData().getValue(), this.mathViewModel.getLiveData().getValue(), this.displayViewModel.getLiveData().getValue(), this.navigateViewModel.getLiveData().getValue(), this.searchViewModel.getLiveData().getValue(), this.maskViewModel.getLiveData().getValue(), this.viewABkeyViewModel);
        }
    }

    public /* synthetic */ void lambda$onViewCreated$13$NavigationBarFragment(Object obj) {
        BaseAdapter<List<MappingObject>> baseAdapter;
        for (int i = 0; i < this.shortcutData.size(); i++) {
            if (ServiceEnum.getFunctionFromValue1(this.shortcutData.get(i).getValue()) == ServiceEnum.Function.FUN_RUN_STOP && (baseAdapter = this.shortcutAdapter) != null) {
                baseAdapter.notifyItemChanged(i);
            }
        }
    }

    @Override // com.rigol.scope.BaseFragment
    public void onLocaleChanged() {
        super.onLocaleChanged();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.handler.removeMessages(0);
        this.handler = null;
        super.onDestroy();
        Timber.d("%s: onDestroy", getClass().getName());
    }
}
