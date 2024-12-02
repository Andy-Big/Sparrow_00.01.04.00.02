package com.rigol.scope.views.presentation;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Observable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.adapters.BaseAdapter;
import com.rigol.scope.adapters.BaseViewHolder;
import com.rigol.scope.adapters.MiniScreenFunctionAdapter;
import com.rigol.scope.adapters.OnItemClickListener;
import com.rigol.scope.adapters.OnItemLongClickListener;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.CursorResultParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.MiniScreenParam;
import com.rigol.scope.databinding.AdapterItemRecyclerviewBinding;
import com.rigol.scope.databinding.PresentationMiniscreenBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.CursorViewModel;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.views.VibrationTouchListener;
import com.rigol.scope.views.baseview.BasePresentation;
import com.rigol.scope.views.baseview.DisableScrollGridLayoutManager;
import com.rigol.scope.views.presentation.MiniScreenPresentation;
import com.rigol.scope.views.trigger.TriggerPopupView;
import com.rigol.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

/* loaded from: classes2.dex */
public class MiniScreenPresentation extends BasePresentation {
    private PresentationMiniscreenBinding binding;
    private final MiniScreenParam param;
    private BaseAdapter<List<List<MappingObject>>> viewPagerAdapter;

    public MiniScreenPresentation(Context context, Display display) {
        super(context, display);
        this.param = new MiniScreenParam();
        init(context);
    }

    private void init(Context context) {
        PresentationMiniscreenBinding inflate = PresentationMiniscreenBinding.inflate(LayoutInflater.from(context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        this.binding.setParam(this.param);
        UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
        CursorViewModel cursorViewModel = (CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class);
        if (cursorViewModel != null) {
            cursorViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.presentation.-$$Lambda$MiniScreenPresentation$17h1po5CYKJit148WRJYqOeqUdw
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MiniScreenPresentation.this.lambda$init$0$MiniScreenPresentation((CursorResultParam) obj);
                }
            });
        }
        ArrayList<List<MappingObject>> lists = getLists();
        this.viewPagerAdapter = new AnonymousClass2(getContext(), lists, R.layout.adapter_item_recyclerview, context, lists, utilityViewModel);
        this.binding.content.setAdapter(this.viewPagerAdapter);
        this.binding.content.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.rigol.scope.views.presentation.MiniScreenPresentation.3
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i, float f, int i2) {
                super.onPageScrolled(i, f, i2);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                super.onPageSelected(i);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i) {
                super.onPageScrollStateChanged(i);
            }
        });
        this.binding.indicator.setViewPager(this.binding.content);
        this.binding.panelSwitch.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.presentation.-$$Lambda$MiniScreenPresentation$KLwLtSPyngvplRjuYqnQuCGZSQY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Timber.d("panelSwitch click", new Object[0]);
            }
        });
        this.binding.panelSwitch.setOnTouchListener(new VibrationTouchListener());
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) topActivity;
            mainActivity.getSyncDataViewModel().get(MessageBus.SYNC_DATA_KEY_FUNCTION_ITEM_CLICK).observe(mainActivity, new Observer() { // from class: com.rigol.scope.views.presentation.-$$Lambda$MiniScreenPresentation$HodwHJC7EMEFrgLMz-E8zE0zyyA
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MiniScreenPresentation.this.lambda$init$2$MiniScreenPresentation(obj);
                }
            });
            mainActivity.getSyncDataViewModel().get(MessageBus.SYNC_DATA_KEY_FUNCTION_ITEM_LONG_CLICK).observe(mainActivity, new Observer() { // from class: com.rigol.scope.views.presentation.-$$Lambda$MiniScreenPresentation$da2e1KeQZ3JZECk0gZ9RN9hFQyM
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MiniScreenPresentation.this.lambda$init$3$MiniScreenPresentation(obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$init$0$MiniScreenPresentation(CursorResultParam cursorResultParam) {
        if (cursorResultParam != null) {
            cursorResultParam.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.presentation.MiniScreenPresentation.1
                @Override // androidx.databinding.Observable.OnPropertyChangedCallback
                public void onPropertyChanged(Observable observable, int i) {
                    if (i == 1032 && MiniScreenPresentation.this.param != null && MiniScreenPresentation.this.param.getFunction() == ServiceEnum.Function.FUN_CURSOR) {
                        MiniScreenPresentation.this.param.setFunction(ServiceEnum.Function.FUN_CURSOR);
                    }
                }
            });
        }
    }

    /* renamed from: com.rigol.scope.views.presentation.MiniScreenPresentation$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass2 extends MiniScreenViewAdapter {
        final /* synthetic */ ArrayList val$lists;
        final /* synthetic */ Context val$outerContext;
        final /* synthetic */ UtilityViewModel val$utilityViewModel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, List list, int i, Context context2, ArrayList arrayList, UtilityViewModel utilityViewModel) {
            super(context, list, i);
            this.val$outerContext = context2;
            this.val$lists = arrayList;
            this.val$utilityViewModel = utilityViewModel;
        }

        @Override // com.rigol.scope.adapters.BaseAdapter
        protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<List<MappingObject>> list, int i) {
            ViewDataBinding binding = baseViewHolder.getBinding();
            if (binding instanceof AdapterItemRecyclerviewBinding) {
                List<MappingObject> list2 = list.get(i);
                AdapterItemRecyclerviewBinding adapterItemRecyclerviewBinding = (AdapterItemRecyclerviewBinding) binding;
                if (adapterItemRecyclerviewBinding.recyclerView.getAdapter() instanceof MiniScreenFunctionAdapter) {
                    ((MiniScreenFunctionAdapter) adapterItemRecyclerviewBinding.recyclerView.getAdapter()).setItems(list2);
                    adapterItemRecyclerviewBinding.recyclerView.getAdapter().notifyDataSetChanged();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.rigol.scope.adapters.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup, int i) {
            final BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup, i);
            ViewDataBinding binding = onCreateViewHolder.getBinding();
            if (binding instanceof AdapterItemRecyclerviewBinding) {
                MiniScreenFunctionAdapter miniScreenFunctionAdapter = new MiniScreenFunctionAdapter(this.val$outerContext, R.layout.adapter_item_simple2);
                final ArrayList arrayList = this.val$lists;
                miniScreenFunctionAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.rigol.scope.views.presentation.-$$Lambda$MiniScreenPresentation$2$af5MhE2WVtQvHL2zWAMA_ANWrkE
                    @Override // com.rigol.scope.adapters.OnItemClickListener
                    public final void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i2) {
                        MiniScreenPresentation.AnonymousClass2.this.lambda$onCreateViewHolder$0$MiniScreenPresentation$2(arrayList, onCreateViewHolder, view, viewHolder, i2);
                    }
                });
                final ArrayList arrayList2 = this.val$lists;
                miniScreenFunctionAdapter.setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.rigol.scope.views.presentation.-$$Lambda$MiniScreenPresentation$2$kAWw90Pj9ii7GvcLDW_HJ0u-lu0
                    @Override // com.rigol.scope.adapters.OnItemLongClickListener
                    public final boolean onItemLongClick(View view, RecyclerView.ViewHolder viewHolder, int i2) {
                        return MiniScreenPresentation.AnonymousClass2.this.lambda$onCreateViewHolder$1$MiniScreenPresentation$2(arrayList2, onCreateViewHolder, view, viewHolder, i2);
                    }
                });
                DisableScrollGridLayoutManager disableScrollGridLayoutManager = new DisableScrollGridLayoutManager(MiniScreenPresentation.this.getContext(), 3);
                disableScrollGridLayoutManager.setOrientation(1);
                AdapterItemRecyclerviewBinding adapterItemRecyclerviewBinding = (AdapterItemRecyclerviewBinding) binding;
                adapterItemRecyclerviewBinding.recyclerView.setLayoutManager(disableScrollGridLayoutManager);
                adapterItemRecyclerviewBinding.recyclerView.setAdapter(miniScreenFunctionAdapter);
                adapterItemRecyclerviewBinding.recyclerView.setScrollingTouchSlop(1);
                adapterItemRecyclerviewBinding.recyclerView.addOnItemTouchListener(new AnonymousClass1());
            }
            return onCreateViewHolder;
        }

        public /* synthetic */ void lambda$onCreateViewHolder$0$MiniScreenPresentation$2(ArrayList arrayList, BaseViewHolder baseViewHolder, View view, RecyclerView.ViewHolder viewHolder, int i) {
            ServiceEnum.Function functionFromValue1 = ServiceEnum.getFunctionFromValue1(((MappingObject) ((List) arrayList.get(baseViewHolder.getBindingAdapterPosition())).get(i)).getValue());
            if (functionFromValue1 == ServiceEnum.Function.FUN_NEXT_PAGE) {
                MiniScreenPresentation.this.binding.content.setCurrentItem(MiniScreenPresentation.this.binding.content.getCurrentItem() + 1);
            } else if (functionFromValue1 == ServiceEnum.Function.FUN_PREVIOUS_PAGE) {
                MiniScreenPresentation.this.binding.content.setCurrentItem(MiniScreenPresentation.this.binding.content.getCurrentItem() - 1);
            } else {
                MiniScreenPresentation.this.handleItemClick(functionFromValue1);
            }
        }

        public /* synthetic */ boolean lambda$onCreateViewHolder$1$MiniScreenPresentation$2(ArrayList arrayList, BaseViewHolder baseViewHolder, View view, RecyclerView.ViewHolder viewHolder, int i) {
            MiniScreenPresentation.this.handleItemLongClick(ServiceEnum.getFunctionFromValue1(((MappingObject) ((List) arrayList.get(baseViewHolder.getBindingAdapterPosition())).get(i)).getValue()));
            return true;
        }

        /* renamed from: com.rigol.scope.views.presentation.MiniScreenPresentation$2$1  reason: invalid class name */
        /* loaded from: classes2.dex */
        class AnonymousClass1 implements RecyclerView.OnItemTouchListener {
            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onRequestDisallowInterceptTouchEvent(boolean z) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            }

            AnonymousClass1() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    final UtilityViewModel utilityViewModel = AnonymousClass2.this.val$utilityViewModel;
                    ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.views.presentation.-$$Lambda$MiniScreenPresentation$2$1$nwPAsJ-AmmJGN3D-tdWS_uvv8c8
                        @Override // java.lang.Runnable
                        public final void run() {
                            MiniScreenPresentation.AnonymousClass2.AnonymousClass1.this.lambda$onInterceptTouchEvent$0$MiniScreenPresentation$2$1(utilityViewModel);
                        }
                    }, 50L);
                    return false;
                }
                return false;
            }

            public /* synthetic */ void lambda$onInterceptTouchEvent$0$MiniScreenPresentation$2$1(UtilityViewModel utilityViewModel) {
                if (MiniScreenPresentation.this.binding.content.getScrollState() != 1) {
                    ViewUtil.makeVibration(utilityViewModel);
                }
            }
        }
    }

    public /* synthetic */ void lambda$init$2$MiniScreenPresentation(Object obj) {
        if (obj instanceof ServiceEnum.Function) {
            this.param.setFunction((ServiceEnum.Function) obj);
        }
    }

    public /* synthetic */ void lambda$init$3$MiniScreenPresentation(Object obj) {
        if (obj instanceof ServiceEnum.Function) {
            this.param.setFunction((ServiceEnum.Function) obj);
        }
    }

    private ArrayList<List<MappingObject>> getLists() {
        List<MappingObject> list = ViewUtil.getList((int) R.array.msg_app_panel_list);
        ArrayList<List<MappingObject>> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int i2 = i % 9;
            if (i2 == 0) {
                arrayList.add(new ArrayList());
            }
            arrayList.get(i / 9).add(i2, list.get(i));
        }
        return arrayList;
    }

    /* renamed from: com.rigol.scope.views.presentation.MiniScreenPresentation$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function;

        static {
            int[] iArr = new int[ServiceEnum.Function.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function = iArr;
            try {
                iArr[ServiceEnum.Function.FUN_TRIGGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_AUTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleItemClick(ServiceEnum.Function function) {
        HorizontalParam value;
        if (function == null) {
            return;
        }
        int i = AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[function.ordinal()];
        if (i != 1) {
            if (i == 2) {
                ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_long_press_toast));
                return;
            } else {
                FunctionManager.getInstance().handleItemClick(function);
                return;
            }
        }
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        if (horizontalViewModel == null || (value = horizontalViewModel.getLiveData().getValue()) == null) {
            return;
        }
        if (FunctionManager.getInstance().getSelectedFunction() == function) {
            if (PopupViewManager.getInstance().isShowing(TriggerPopupView.class)) {
                PopupViewManager.getInstance().dismiss(TriggerPopupView.class);
            } else if (value.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL) {
                ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
            } else {
                PopupViewManager.getInstance().toggle(TriggerPopupView.class);
            }
        } else if (value.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL) {
            ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
        } else {
            FunctionManager.getInstance().setSelectedFunction(ServiceEnum.Function.FUN_TRIGGER);
            MessageBus.getInstance().onSyncData(MessageBus.SYNC_DATA_KEY_FUNCTION_ITEM_CLICK, ServiceEnum.Function.FUN_TRIGGER);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleItemLongClick(ServiceEnum.Function function) {
        if (function == null) {
            return;
        }
        FunctionManager.getInstance().handleItemLongClick(function);
    }

    /* loaded from: classes2.dex */
    static abstract class MiniScreenViewAdapter extends BaseAdapter<List<List<MappingObject>>> {
        public MiniScreenViewAdapter(Context context, List<List<MappingObject>> list, int i) {
            super(context, list, i);
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePresentation
    public void onLocaleChanged() {
        super.onLocaleChanged();
        if (this.viewPagerAdapter != null) {
            this.viewPagerAdapter.setItems(getLists());
            this.viewPagerAdapter.notifyDataSetChanged();
        }
    }
}
