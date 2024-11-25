package com.rigol.scope;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GravityCompat;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.constant.CacheConstants;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.adapters.BaseAdapter;
import com.rigol.scope.adapters.BaseViewHolder;
import com.rigol.scope.adapters.LaFunctionAdapter;
import com.rigol.scope.adapters.OnItemGestureDetectorListener;
import com.rigol.scope.adapters.VerticalAdapter;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AfgParam;
import com.rigol.scope.data.FftParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.data.OptionParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.data.TwoTuple;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.data.UtilityParamKt;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.databinding.AdapterItemRtsaBinding;
import com.rigol.scope.databinding.AdapterItemSparrpwMathBinding;
import com.rigol.scope.databinding.FragmentSettingsBarBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.KeyCodeUtil;
import com.rigol.scope.utilities.KtUtilKt;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WeakRefHandler;
import com.rigol.scope.viewmodels.AfgViewModel;
import com.rigol.scope.viewmodels.FftViewModel;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.LaViewModel;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.viewmodels.OptionViewModel;
import com.rigol.scope.viewmodels.TriggerViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.views.UtilityPopupView;
import com.rigol.scope.views.afgawg.AfwAwgPopupView;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.baseview.BaseSimpleCallback;
import com.rigol.scope.views.grid.GridSpaceItemDecoration;
import com.rigol.scope.views.horizontal.HorizontalSpaceItemDecoration;
import com.rigol.scope.views.la.LapopupView;
import com.rigol.scope.views.math.MathListPopuView;
import com.rigol.scope.views.math.MathPopupView;
import com.rigol.scope.views.probe.ProbePopupView;
import com.rigol.scope.views.rtsa.RtsaPopupView;
import com.rigol.scope.views.startMenu.StartMenuPopupView;
import com.rigol.scope.views.vertical.VerticalPopupView;
import com.rigol.util.ToastUtils;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class SettingsBarFragment extends BaseFragment implements View.OnClickListener {
    private static final int MSG_UPDATE_TIME = 1;
    AfgViewModel afgViewModel;
    private FragmentSettingsBarBinding binding;
    private FftViewModel fftViewModel;
    private HorizontalViewModel horizontalViewModel;
    LaFunctionAdapter laFunctionAdapter;
    private LaParam laParam;
    private LaViewModel laViewModel;
    private MathViewModel mathViewModel;
    private OptionParam optionParam;
    private OptionViewModel optionViewModel;
    BaseAdapter<List<MappingObject>> otherFunAdapter;
    private SharedParam sharedParam;
    private TriggerViewModel triggerViewModel;
    private UtilityParam utilityParam;
    private UtilityViewModel utilityViewModel;
    private VerticalAdapter verticalAdapter;
    private VerticalViewModel verticalViewModel;
    ObservableBoolean hasUpdate = new ObservableBoolean();
    ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    final int[] locationOnScreen = new int[2];
    private final Handler updateTimeHandler = new WeakRefHandler(new Handler.Callback() { // from class: com.rigol.scope.SettingsBarFragment.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1 || SettingsBarFragment.this.utilityParam == null) {
                return false;
            }
            SettingsBarFragment.this.utilityParam.setTime(UtilityParamKt.millis2Time(System.currentTimeMillis() + (ServiceEnum.TimeZoneDiff.ZONE_DIFF.value1 * CacheConstants.HOUR * 1000)));
            return false;
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onCreateView$7(View view) {
    }

    @Override // com.rigol.scope.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.verticalViewModel = (VerticalViewModel) getAppViewModelProvider().get(VerticalViewModel.class);
        this.mathViewModel = (MathViewModel) getAppViewModelProvider().get(MathViewModel.class);
        this.triggerViewModel = (TriggerViewModel) getAppViewModelProvider().get(TriggerViewModel.class);
        this.utilityViewModel = (UtilityViewModel) getAppViewModelProvider().get(UtilityViewModel.class);
        this.optionViewModel = (OptionViewModel) getAppViewModelProvider().get(OptionViewModel.class);
        this.fftViewModel = (FftViewModel) getAppViewModelProvider().get(FftViewModel.class);
        this.horizontalViewModel = (HorizontalViewModel) getAppViewModelProvider().get(HorizontalViewModel.class);
        this.afgViewModel = (AfgViewModel) getAppViewModelProvider().get(AfgViewModel.class);
        LaViewModel laViewModel = (LaViewModel) getAppViewModelProvider().get(LaViewModel.class);
        this.laViewModel = laViewModel;
        this.laParam = laViewModel.getValue();
        if (this.syncDataViewModel != null) {
            this.syncDataViewModel.get(36, MessageID.MSG_LICENSE_CHANGED).observe(this.mActivity, new Observer() { // from class: com.rigol.scope.-$$Lambda$SettingsBarFragment$SIxwJW-7al1AIVVVErBKa5vf6EE
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SettingsBarFragment.this.lambda$onCreate$0$SettingsBarFragment(obj);
                }
            });
            this.syncDataViewModel.get(60, MessageID.MSG_LA_ENABLE).observe(this.mActivity, new Observer() { // from class: com.rigol.scope.-$$Lambda$SettingsBarFragment$1F7NiOPbkM7f6wb918WgPam4-_w
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SettingsBarFragment.this.lambda$onCreate$1$SettingsBarFragment(obj);
                }
            });
        }
        PopupViewManager.getInstance().DefaultLight_Open();
    }

    public /* synthetic */ void lambda$onCreate$0$SettingsBarFragment(Object obj) {
        BaseAdapter<List<MappingObject>> baseAdapter = this.otherFunAdapter;
        if (baseAdapter != null) {
            baseAdapter.notifyDataSetChanged();
        }
    }

    public /* synthetic */ void lambda$onCreate$1$SettingsBarFragment(Object obj) {
        LaFunctionAdapter laFunctionAdapter = this.laFunctionAdapter;
        if (laFunctionAdapter != null) {
            laFunctionAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentSettingsBarBinding inflate = FragmentSettingsBarBinding.inflate(LayoutInflater.from(this.mActivity));
        this.binding = inflate;
        inflate.setHasUpdate(this.hasUpdate);
        this.sharedViewModel.hasUpdate.observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$SettingsBarFragment$fRfXRKAP_2E1V8JoQnPiNv-EhrM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingsBarFragment.this.lambda$onCreateView$2$SettingsBarFragment((TwoTuple) obj);
            }
        });
        this.scheduledExecutorService.scheduleAtFixedRate(new Runnable() { // from class: com.rigol.scope.-$$Lambda$SettingsBarFragment$Gy5WIp5LowMWJw6rcXn1ZkuMMfE
            @Override // java.lang.Runnable
            public final void run() {
                SettingsBarFragment.this.lambda$onCreateView$3$SettingsBarFragment();
            }
        }, 0L, 1L, TimeUnit.SECONDS);
        this.binding.starterButton.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.-$$Lambda$SettingsBarFragment$ZBma4YPC1a5lNbWe1b9bVovsjCc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupViewManager.getInstance().toggle(StartMenuPopupView.class);
            }
        });
        this.binding.systemTimeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.-$$Lambda$SettingsBarFragment$A4OugMbWzY5SfoJEyBIejRKhcSI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupViewManager.getInstance().toggle(UtilityPopupView.class);
            }
        });
        this.binding.beeper.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.-$$Lambda$SettingsBarFragment$qDQ9NwXmf5TJHPL6ehbA-ffDebs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsBarFragment.this.lambda$onCreateView$6$SettingsBarFragment(view);
            }
        });
        ViewUtil.addOutsideEnableClickRects(this.locationOnScreen, this.binding.verticalD, LapopupView.class);
        ViewUtil.addOutsideEnableClickRects(this.locationOnScreen, this.binding.dItemList, LapopupView.class);
        this.binding.verticalD.setOnClickListener(this);
        this.binding.verticalD.setDragRate(1.0f);
        this.binding.verticalG.setDragRate(1.0f);
        this.binding.verticalG.setEnableRefresh(true);
        this.binding.verticalG.setEnableLoadMore(false);
        this.binding.verticalD.setEnableRefresh(true);
        this.binding.verticalG.setOnMultiPurposeListener(new OnMultiPurposeListener() { // from class: com.rigol.scope.SettingsBarFragment.2
            @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void onFooterFinish(RefreshFooter refreshFooter, boolean z) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void onFooterMoving(RefreshFooter refreshFooter, boolean z, float f, int i, int i2, int i3) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void onFooterReleased(RefreshFooter refreshFooter, int i, int i2) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void onFooterStartAnimator(RefreshFooter refreshFooter, int i, int i2) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void onHeaderFinish(RefreshHeader refreshHeader, boolean z) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void onHeaderReleased(RefreshHeader refreshHeader, int i, int i2) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void onHeaderStartAnimator(RefreshHeader refreshHeader, int i, int i2) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnStateChangedListener
            public void onStateChanged(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void onHeaderMoving(RefreshHeader refreshHeader, boolean z, float f, int i, int i2, int i3) {
                if (i == 0) {
                    SettingsBarFragment.this.afgViewModel.getLiveData().getValue().saveBasicOutputEnable(false);
                }
            }
        });
        this.binding.verticalD.setOnMultiPurposeListener(new OnMultiPurposeListener() { // from class: com.rigol.scope.SettingsBarFragment.3
            @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void onFooterFinish(RefreshFooter refreshFooter, boolean z) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void onFooterMoving(RefreshFooter refreshFooter, boolean z, float f, int i, int i2, int i3) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void onFooterReleased(RefreshFooter refreshFooter, int i, int i2) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void onFooterStartAnimator(RefreshFooter refreshFooter, int i, int i2) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void onHeaderFinish(RefreshHeader refreshHeader, boolean z) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void onHeaderReleased(RefreshHeader refreshHeader, int i, int i2) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void onHeaderStartAnimator(RefreshHeader refreshHeader, int i, int i2) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnStateChangedListener
            public void onStateChanged(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void onHeaderMoving(RefreshHeader refreshHeader, boolean z, float f, int i, int i2, int i3) {
                if (i == 0) {
                    SettingsBarFragment.this.laParam.savelaEnable(false);
                }
            }
        });
        ViewUtil.addOutsideEnableClickRects(this.locationOnScreen, this.binding.verticalG, AfwAwgPopupView.class);
        this.binding.verticalGView.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.SettingsBarFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PopupViewManager.getInstance().isShowing(AfwAwgPopupView.class) && SettingsBarFragment.this.afgViewModel.getLiveData().getValue().getBasic_output_enable()) {
                    SettingsBarFragment.this.afgViewModel.getLiveData().getValue().saveBasicOutputEnable(false);
                    PopupViewManager.getInstance().dismiss(AfwAwgPopupView.class);
                } else if (!PopupViewManager.getInstance().isShowing(AfwAwgPopupView.class) && !SettingsBarFragment.this.afgViewModel.getLiveData().getValue().getBasic_output_enable()) {
                    SettingsBarFragment.this.afgViewModel.getLiveData().getValue().saveBasicOutputEnable(true);
                } else {
                    PopupViewManager.getInstance().toggle(AfwAwgPopupView.class);
                }
            }
        });
        this.binding.powerIconView.setProgress(50);
        this.binding.powerIconView.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.-$$Lambda$SettingsBarFragment$p1ZKVp1GXZQioVQmsoBD7ZAiPYw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsBarFragment.lambda$onCreateView$7(view);
            }
        });
        return this.binding.getRoot();
    }

    public /* synthetic */ void lambda$onCreateView$2$SettingsBarFragment(TwoTuple twoTuple) {
        if (twoTuple != null) {
            this.hasUpdate.set(((Boolean) twoTuple.getFirst()).booleanValue());
        }
    }

    public /* synthetic */ void lambda$onCreateView$3$SettingsBarFragment() {
        this.updateTimeHandler.sendEmptyMessage(1);
    }

    public /* synthetic */ void lambda$onCreateView$6$SettingsBarFragment(View view) {
        UtilityParam utilityParam = this.utilityParam;
        if (utilityParam != null) {
            utilityParam.saveBeeper(!utilityParam.getBeeper());
        }
    }

    @Override // com.rigol.scope.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        OptionViewModel optionViewModel = this.optionViewModel;
        if (optionViewModel != null) {
            optionViewModel.getLiveData().observe(this.mActivity, new Observer() { // from class: com.rigol.scope.-$$Lambda$SettingsBarFragment$ESCTgBvKCFXUIzkZwSsQ7zphbnw
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SettingsBarFragment.this.lambda$onViewCreated$8$SettingsBarFragment((OptionParam) obj);
                }
            });
        }
        UtilityViewModel utilityViewModel = this.utilityViewModel;
        if (utilityViewModel != null) {
            utilityViewModel.getLiveData().observe(this.mActivity, new Observer() { // from class: com.rigol.scope.-$$Lambda$SettingsBarFragment$ROzQ61_aFhOvZZq_zvQLJOnXe08
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SettingsBarFragment.this.lambda$onViewCreated$9$SettingsBarFragment((UtilityParam) obj);
                }
            });
        }
        if (this.sharedViewModel != null) {
            this.sharedViewModel.getLiveData().observe(this.mActivity, new Observer() { // from class: com.rigol.scope.-$$Lambda$SettingsBarFragment$CHrJzetJL7znsrqEYza44dWHaqg
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SettingsBarFragment.this.lambda$onViewCreated$10$SettingsBarFragment((SharedParam) obj);
                }
            });
        }
        LaViewModel laViewModel = this.laViewModel;
        if (laViewModel != null) {
            laViewModel.getLiveData().observe(this.mActivity, new Observer() { // from class: com.rigol.scope.-$$Lambda$SettingsBarFragment$ngxHwt-q-sQBt14hXqp_Leghko8
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SettingsBarFragment.this.lambda$onViewCreated$11$SettingsBarFragment((LaParam) obj);
                }
            });
        }
        AfgViewModel afgViewModel = this.afgViewModel;
        if (afgViewModel != null) {
            afgViewModel.getLiveData().observe(this.mActivity, new Observer() { // from class: com.rigol.scope.-$$Lambda$SettingsBarFragment$SfaQxKUpgiw-tqGXr2zXeuUp8vI
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SettingsBarFragment.this.lambda$onViewCreated$12$SettingsBarFragment((AfgParam) obj);
                }
            });
        }
        loadVerticalInfo();
        showLa();
        loadMathInfo();
        loadOtherFunInfo();
        this.panelKeyViewModel.getOnKeyUpData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$SettingsBarFragment$-y2jQkWL858X2IWCSsLMteGzyCA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingsBarFragment.this.lambda$onViewCreated$13$SettingsBarFragment((KeyEvent) obj);
            }
        });
        this.panelKeyViewModel.getOnKeyDownData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$SettingsBarFragment$1zFlwb9htJt214jKPUPTBTXqhAE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingsBarFragment.this.lambda$onViewCreated$14$SettingsBarFragment((KeyEvent) obj);
            }
        });
        ViewUtil.addOutsideEnableClickRects(this.locationOnScreen, this.binding.starterLayout, StartMenuPopupView.class);
        ViewUtil.addOutsideEnableClickRects(this.locationOnScreen, this.binding.systemTimeLayout, UtilityPopupView.class);
    }

    public /* synthetic */ void lambda$onViewCreated$8$SettingsBarFragment(OptionParam optionParam) {
        this.optionParam = optionParam;
    }

    public /* synthetic */ void lambda$onViewCreated$9$SettingsBarFragment(UtilityParam utilityParam) {
        this.utilityParam = utilityParam;
        this.binding.setUtilityParam(utilityParam);
    }

    public /* synthetic */ void lambda$onViewCreated$10$SettingsBarFragment(SharedParam sharedParam) {
        this.sharedParam = sharedParam;
        this.binding.setSharedParam(sharedParam);
    }

    public /* synthetic */ void lambda$onViewCreated$11$SettingsBarFragment(LaParam laParam) {
        this.binding.setLaParam(laParam);
    }

    public /* synthetic */ void lambda$onViewCreated$12$SettingsBarFragment(AfgParam afgParam) {
        this.binding.setAfgParam(afgParam);
    }

    public /* synthetic */ void lambda$onViewCreated$13$SettingsBarFragment(KeyEvent keyEvent) {
        VerticalViewModel verticalViewModel;
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        if (panelKey <= 0 || (verticalViewModel = this.verticalViewModel) == null) {
            return;
        }
        verticalViewModel.getLiveData();
        this.panelKeyViewModel.onPanelKeyUp(panelKey, keyEvent, (List) Objects.requireNonNull(this.verticalViewModel.getLiveData().getValue()), (HorizontalParam) Objects.requireNonNull(this.horizontalViewModel.getLiveData().getValue()), this.laParam);
    }

    public /* synthetic */ void lambda$onViewCreated$14$SettingsBarFragment(KeyEvent keyEvent) {
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        if (panelKey > 0) {
            this.panelKeyViewModel.onPanelKeyDown(panelKey, keyEvent, this.verticalAdapter.getItems());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ScheduledExecutorService scheduledExecutorService = this.scheduledExecutorService;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }

    private void loadVerticalInfo() {
        VerticalAdapter verticalAdapter = new VerticalAdapter(this.mActivity, R.layout.adapter_item_vertical);
        this.verticalAdapter = verticalAdapter;
        verticalAdapter.setOnItemGestureDetectorListener(new OnItemGestureDetectorListener() { // from class: com.rigol.scope.SettingsBarFragment.5
            @Override // com.rigol.scope.adapters.OnItemGestureDetectorListener
            public boolean onDoubleTap(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
                SettingsBarFragment.this.showVerticalPopupView(i);
                return true;
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
            @Override // com.rigol.scope.adapters.OnItemGestureDetectorListener
            public void onLongPress(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
                VerticalParam verticalItem = ViewUtil.getVerticalItem((List<VerticalParam>) SettingsBarFragment.this.verticalAdapter.getItems(), i);
                if (verticalItem != null) {
                    verticalItem.turnOff();
                }
                if (PopupViewManager.getInstance().isShowing(VerticalPopupView.class)) {
                    PopupViewManager.getInstance().dismiss(VerticalPopupView.class);
                }
                SettingsBarFragment.this.verticalAdapter.notifyDataSetChanged();
            }

            /* JADX WARN: Type inference failed for: r1v14, types: [java.util.List] */
            @Override // com.rigol.scope.adapters.OnItemGestureDetectorListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
                VerticalParam item = SettingsBarFragment.this.verticalAdapter.getItem(i);
                if (item == null) {
                    return true;
                }
                ServiceEnum.enChanStatus status = item.getStatus();
                if (status == ServiceEnum.enChanStatus.CHAN_OFF || status == ServiceEnum.enChanStatus.CHAN_ON) {
                    SettingsBarFragment.this.verticalAdapter.setCurrentItem(i);
                    BasePopupView basePopupView = PopupViewManager.getInstance().get(VerticalPopupView.class);
                    if ((basePopupView instanceof VerticalPopupView) && basePopupView.isShowing()) {
                        ((VerticalPopupView) basePopupView).setCurrentItem(i);
                        PopupViewManager.getInstance().showCurrentWindowLight(basePopupView);
                    }
                } else if (status == ServiceEnum.enChanStatus.CHAN_ACTIVE) {
                    if (PopupViewManager.getInstance().isShowing(VerticalPopupView.class)) {
                        VerticalParam verticalItem = ViewUtil.getVerticalItem((List<VerticalParam>) SettingsBarFragment.this.verticalAdapter.getItems(), i);
                        if (verticalItem != null) {
                            verticalItem.turnOff();
                        }
                        PopupViewManager.getInstance().dismiss(VerticalPopupView.class);
                    } else {
                        SettingsBarFragment.this.showVerticalPopupView(i);
                    }
                }
                return true;
            }
        });
        ViewUtil.setSupportsChangeAnimations(this.binding.verticalList, false);
        this.binding.verticalList.addItemDecoration(new HorizontalSpaceItemDecoration(3));
        this.binding.verticalList.setAdapter(this.verticalAdapter);
        new ItemTouchHelper(new BaseSimpleCallback(0, 2) { // from class: com.rigol.scope.SettingsBarFragment.6
            /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
            @Override // com.rigol.scope.views.baseview.BaseSimpleCallback, androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
                super.onSwiped(viewHolder, i);
                VerticalParam verticalItem = ViewUtil.getVerticalItem((List<VerticalParam>) SettingsBarFragment.this.verticalAdapter.getItems(), viewHolder.getBindingAdapterPosition());
                if (verticalItem != null) {
                    verticalItem.turnOff();
                }
                if (PopupViewManager.getInstance().isShowing(VerticalPopupView.class)) {
                    PopupViewManager.getInstance().dismiss(VerticalPopupView.class);
                }
                SettingsBarFragment.this.verticalAdapter.notifyDataSetChanged();
            }
        }).attachToRecyclerView(this.binding.verticalList);
        this.verticalViewModel.getLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$SettingsBarFragment$C-ZDbOo-lBUhdguqNe2NklL5qvk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingsBarFragment.this.lambda$loadVerticalInfo$15$SettingsBarFragment((ArrayList) obj);
            }
        });
        this.updateUIViewModel.get(0, 0, MessageID.ERR_PROBE_CAL_SUCCEED).observe(this.mActivity, new Observer() { // from class: com.rigol.scope.-$$Lambda$SettingsBarFragment$enosXayxqOTLFI-Kigelw2mmwDc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingsBarFragment.this.lambda$loadVerticalInfo$16$SettingsBarFragment((Boolean) obj);
            }
        });
        this.updateUIViewModel.get(0, 0, MessageID.ERR_PROBE_REQUEST_CAL).observe(this.mActivity, new Observer() { // from class: com.rigol.scope.-$$Lambda$SettingsBarFragment$gxwv8Wwmj5FhZPhACcnDF8qzp48
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingsBarFragment.this.lambda$loadVerticalInfo$17$SettingsBarFragment((Boolean) obj);
            }
        });
        PopupViewManager.getInstance().add(VerticalPopupView.class, new VerticalPopupView());
        PopupViewManager.getInstance().add(ProbePopupView.class, new ProbePopupView());
    }

    public /* synthetic */ void lambda$loadVerticalInfo$15$SettingsBarFragment(ArrayList arrayList) {
        this.verticalAdapter.setItems(arrayList);
        this.verticalAdapter.notifyDataSetChanged();
        for (int i = 0; i < arrayList.size(); i++) {
            final VerticalParam verticalParam = (VerticalParam) arrayList.get(i);
            verticalParam.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.SettingsBarFragment.7
                @Override // androidx.databinding.Observable.OnPropertyChangedCallback
                public void onPropertyChanged(Observable observable, int i2) {
                    TriggerParam value;
                    if (i2 != 987 || (value = SettingsBarFragment.this.triggerViewModel.getLiveData().getValue()) == null) {
                        return;
                    }
                    value.loadStrings(SettingsBarFragment.this.mActivity);
                    value.setUnit(verticalParam.getUnit(), verticalParam.getChan().value1);
                }
            });
            this.updateUIViewModel.bind(getViewLifecycleOwner(), arrayList, i);
        }
    }

    public /* synthetic */ void lambda$loadVerticalInfo$16$SettingsBarFragment(Boolean bool) {
        SharedParam sharedParam = this.sharedParam;
        if (sharedParam != null) {
            sharedParam.setProbeRequestCal(false);
        }
    }

    public /* synthetic */ void lambda$loadVerticalInfo$17$SettingsBarFragment(Boolean bool) {
        SharedParam sharedParam = this.sharedParam;
        if (sharedParam != null) {
            sharedParam.setProbeRequestCal(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showVerticalPopupView(int i) {
        BasePopupView basePopupView = PopupViewManager.getInstance().get(VerticalPopupView.class);
        if (basePopupView instanceof VerticalPopupView) {
            ((VerticalPopupView) basePopupView).setCurrentItem(i);
        }
        basePopupView.show();
    }

    private void showLa() {
        List<MappingObject> list = ViewUtil.getList((int) R.array.msg_la_current_chan);
        this.binding.dItemList.setLayoutManager(new GridLayoutManager(getContext(), 4));
        this.laFunctionAdapter = new LaFunctionAdapter(getContext(), list, R.layout.adapter_item_la);
        this.binding.dItemList.setAdapter(this.laFunctionAdapter);
        this.binding.nothingView.setOnClickListener(this);
    }

    private void loadMathInfo() {
        final BaseAdapter<List<MathParam>> baseAdapter = new BaseAdapter<List<MathParam>>(this.mActivity, R.layout.adapter_item_sparrpw_math) { // from class: com.rigol.scope.SettingsBarFragment.8
            @Override // com.rigol.scope.adapters.BaseAdapter
            protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<MathParam> list, int i) {
                AdapterItemSparrpwMathBinding adapterItemSparrpwMathBinding = (AdapterItemSparrpwMathBinding) baseViewHolder.getBinding();
                MathParam mathParam = list.get(i);
                if (mathParam != null) {
                    adapterItemSparrpwMathBinding.setParam(mathParam);
                }
                adapterItemSparrpwMathBinding.getRoot().setTag(MathPopupView.class.getSimpleName());
            }

            @Override // com.rigol.scope.adapters.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup, int i) {
                BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup, i);
                ViewUtil.addOutsideEnableClickRects(SettingsBarFragment.this.locationOnScreen, onCreateViewHolder.getBinding().getRoot(), MathPopupView.class);
                return onCreateViewHolder;
            }
        };
        ViewUtil.setSupportsChangeAnimations(this.binding.mathItemList, false);
        this.binding.mathItemList.addItemDecoration(new GridSpaceItemDecoration(1, true));
        this.binding.mathItemList.setAdapter(baseAdapter);
        this.binding.verticalM.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.SettingsBarFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new MathListPopuView().showAsDropDown(SettingsBarFragment.this.binding.verticalM, -80, -20, GravityCompat.START);
            }
        });
        baseAdapter.setOnItemGestureDetectorListener(new OnItemGestureDetectorListener() { // from class: com.rigol.scope.SettingsBarFragment.10
            @Override // com.rigol.scope.adapters.OnItemGestureDetectorListener
            public boolean onDoubleTap(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
                SettingsBarFragment.this.showMathPopupView(i);
                return true;
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
            @Override // com.rigol.scope.adapters.OnItemGestureDetectorListener
            public void onLongPress(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
                ((MathParam) baseAdapter.getItems().get(i)).saveStatus(false);
                if (PopupViewManager.getInstance().isShowing(MathListPopuView.class)) {
                    PopupViewManager.getInstance().get(MathPopupView.class).dismiss();
                }
                baseAdapter.notifyDataSetChanged();
            }

            /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List] */
            @Override // com.rigol.scope.adapters.OnItemGestureDetectorListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
                ?? items = baseAdapter.getItems();
                if (i >= 0) {
                    if (((MathParam) items.get(i)).getStatus()) {
                        if (PopupViewManager.getInstance().isShowing(MathPopupView.class)) {
                            if (SettingsBarFragment.this.getMathCurrentItem() != i) {
                                SettingsBarFragment.this.setMathCurrentItem(i);
                            } else {
                                PopupViewManager.getInstance().get(MathPopupView.class).dismiss();
                                ((MathParam) items.get(i)).saveStatus(false);
                            }
                        } else {
                            SettingsBarFragment.this.showMathPopupView(i);
                        }
                    } else {
                        ((MathParam) items.get(i)).saveStatus(true);
                    }
                    baseAdapter.notifyDataSetChanged();
                }
                return true;
            }
        });
        new ItemTouchHelper(new BaseSimpleCallback(0, 2) { // from class: com.rigol.scope.SettingsBarFragment.11
            /* JADX WARN: Type inference failed for: r3v4, types: [java.util.List] */
            @Override // com.rigol.scope.views.baseview.BaseSimpleCallback, androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
                super.onSwiped(viewHolder, i);
                int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
                if (PopupViewManager.getInstance().isShowing(MathPopupView.class)) {
                    PopupViewManager.getInstance().get(MathPopupView.class).dismiss();
                }
                ((MathParam) baseAdapter.getItems().get(bindingAdapterPosition)).saveStatus(false);
                baseAdapter.notifyDataSetChanged();
            }
        }).attachToRecyclerView(this.binding.mathItemList);
        this.mathViewModel.getLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$SettingsBarFragment$ysVMqpE0_kpFc0omy-2ZsbgZDDQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingsBarFragment.this.lambda$loadMathInfo$18$SettingsBarFragment(baseAdapter, (ArrayList) obj);
            }
        });
        PopupViewManager.getInstance().add(MathPopupView.class, new MathPopupView());
    }

    public /* synthetic */ void lambda$loadMathInfo$18$SettingsBarFragment(BaseAdapter baseAdapter, ArrayList arrayList) {
        baseAdapter.setItems(arrayList);
        baseAdapter.notifyDataSetChanged();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.updateUIViewModel.bind(getViewLifecycleOwner(), (MathParam) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMathPopupView(int i) {
        BasePopupView basePopupView = PopupViewManager.getInstance().get(MathPopupView.class);
        if (basePopupView instanceof MathPopupView) {
            ((MathPopupView) basePopupView).setCurrentItem(i);
        }
        basePopupView.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMathCurrentItem() {
        BasePopupView basePopupView = PopupViewManager.getInstance().get(MathPopupView.class);
        if (basePopupView instanceof MathPopupView) {
            return ((MathPopupView) basePopupView).getCurrentItem();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMathCurrentItem(int i) {
        BasePopupView basePopupView = PopupViewManager.getInstance().get(MathPopupView.class);
        if (basePopupView instanceof MathPopupView) {
            ((MathPopupView) basePopupView).setCurrentItem(i);
        }
    }

    private void loadOtherFunInfo() {
        List<MappingObject> list = ViewUtil.getList((int) R.array.msg_other_fun_list);
        final FftParam value = this.fftViewModel.getLiveData().getValue();
        if (value == null) {
            return;
        }
        this.otherFunAdapter = new BaseAdapter<List<MappingObject>>(this.mActivity, list, R.layout.adapter_item_rtsa) { // from class: com.rigol.scope.SettingsBarFragment.12
            @Override // com.rigol.scope.adapters.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup, int i) {
                BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup, i);
                ViewUtil.addOutsideEnableClickRects(SettingsBarFragment.this.locationOnScreen, onCreateViewHolder.itemView, RtsaPopupView.class);
                return onCreateViewHolder;
            }

            @Override // com.rigol.scope.adapters.BaseAdapter
            protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<MappingObject> list2, int i) {
                AdapterItemRtsaBinding adapterItemRtsaBinding = (AdapterItemRtsaBinding) baseViewHolder.getBinding();
                ServiceEnum.Function functionFromValue1 = ServiceEnum.getFunctionFromValue1(list2.get(i).getValue());
                if (functionFromValue1 == ServiceEnum.Function.FUN_FFT) {
                    adapterItemRtsaBinding.setParam(value);
                }
                if (SettingsBarFragment.this.optionParam != null) {
                    adapterItemRtsaBinding.getRoot().setAlpha(ContextUtil.getAlpha(KtUtilKt.functionEnable(functionFromValue1, SettingsBarFragment.this.optionParam)));
                }
            }
        };
        ViewUtil.setSupportsChangeAnimations(this.binding.otherLayout, false);
        this.binding.otherLayout.addItemDecoration(new HorizontalSpaceItemDecoration(3));
        this.binding.otherLayout.setAdapter(this.otherFunAdapter);
        this.otherFunAdapter.setOnItemGestureDetectorListener(new OnItemGestureDetectorListener() { // from class: com.rigol.scope.SettingsBarFragment.13
            @Override // com.rigol.scope.adapters.OnItemGestureDetectorListener
            public boolean onDoubleTap(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
                if (SettingsBarFragment.this.optionParam != null && !KtUtilKt.functionEnable(ServiceEnum.Function.FUN_FFT, SettingsBarFragment.this.optionParam)) {
                    ToastUtils.showLong(SettingsBarFragment.this.getResources().getString(R.string.msg_opt_lic_unusable));
                    return true;
                }
                PopupViewManager.getInstance().toggle(RtsaPopupView.class);
                return true;
            }

            @Override // com.rigol.scope.adapters.OnItemGestureDetectorListener
            public void onLongPress(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
                if (SettingsBarFragment.this.optionParam != null && !KtUtilKt.functionEnable(ServiceEnum.Function.FUN_FFT, SettingsBarFragment.this.optionParam)) {
                    ToastUtils.showLong(SettingsBarFragment.this.getResources().getString(R.string.msg_opt_lic_unusable));
                    return;
                }
                value.saveEnable(false);
                if (PopupViewManager.getInstance().isShowing(RtsaPopupView.class)) {
                    PopupViewManager.getInstance().get(RtsaPopupView.class).dismiss();
                }
                SettingsBarFragment.this.otherFunAdapter.notifyDataSetChanged();
            }

            @Override // com.rigol.scope.adapters.OnItemGestureDetectorListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
                if (i >= 0) {
                    if (SettingsBarFragment.this.optionParam != null && !KtUtilKt.functionEnable(ServiceEnum.Function.FUN_FFT, SettingsBarFragment.this.optionParam)) {
                        ToastUtils.showLong(SettingsBarFragment.this.getResources().getString(R.string.msg_opt_lic_unusable));
                        return true;
                    }
                    if (value.isEnable()) {
                        if (PopupViewManager.getInstance().isShowing(RtsaPopupView.class)) {
                            PopupViewManager.getInstance().dismiss(RtsaPopupView.class);
                            value.saveEnable(false);
                        } else {
                            PopupViewManager.getInstance().show(RtsaPopupView.class);
                        }
                    } else {
                        value.saveEnable(true);
                    }
                    SettingsBarFragment.this.otherFunAdapter.notifyDataSetChanged();
                }
                return true;
            }
        });
        new ItemTouchHelper(new BaseSimpleCallback(0, 2) { // from class: com.rigol.scope.SettingsBarFragment.14
            @Override // com.rigol.scope.views.baseview.BaseSimpleCallback, androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
                super.onSwiped(viewHolder, i);
                if (SettingsBarFragment.this.optionParam != null && !KtUtilKt.functionEnable(ServiceEnum.Function.FUN_FFT, SettingsBarFragment.this.optionParam)) {
                    ToastUtils.showLong(SettingsBarFragment.this.getResources().getString(R.string.msg_opt_lic_unusable));
                    SettingsBarFragment.this.otherFunAdapter.notifyDataSetChanged();
                    return;
                }
                if (PopupViewManager.getInstance().isShowing(RtsaPopupView.class)) {
                    PopupViewManager.getInstance().get(RtsaPopupView.class).dismiss();
                }
                value.saveEnable(false);
                SettingsBarFragment.this.otherFunAdapter.notifyDataSetChanged();
            }
        }).attachToRecyclerView(this.binding.otherLayout);
    }

    public FragmentSettingsBarBinding getBinding() {
        return this.binding;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.nothing_view || view.getId() == R.id.d_item_list) {
            if (this.laParam.getLa_calibration_probe()) {
                if (PopupViewManager.getInstance().isShowing(LapopupView.class) && this.laViewModel.getLiveData().getValue().getLaEnable()) {
                    this.laViewModel.getLiveData().getValue().savelaEnable(false);
                    PopupViewManager.getInstance().dismiss(LapopupView.class);
                    return;
                } else if (!PopupViewManager.getInstance().isShowing(LapopupView.class) && !this.laViewModel.getLiveData().getValue().getLaEnable()) {
                    this.laViewModel.getLiveData().getValue().savelaEnable(true);
                    return;
                } else {
                    PopupViewManager.getInstance().toggle(LapopupView.class);
                    return;
                }
            }
            ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_la_insert_probe));
        }
    }
}
