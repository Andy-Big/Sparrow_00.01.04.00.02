package com.rigol.scope;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ThreadUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.rigol.scope.adapters.AdapterDelegate;
import com.rigol.scope.adapters.OnItemGestureDetectorListener;
import com.rigol.scope.adapters.ResultListAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.CounterResultParam;
import com.rigol.scope.data.CursorResultParam;
import com.rigol.scope.data.DvmResultParam;
import com.rigol.scope.data.EyeResultParam;
import com.rigol.scope.data.JitterResultParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MaskResultParam;
import com.rigol.scope.data.MeasureResultParam;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.ResultParam;
import com.rigol.scope.data.TwoTuple;
import com.rigol.scope.databinding.FragmentResultsBarBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.MeasureSettingViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.views.alert.RemoveAllMeasurePopupView;
import com.rigol.scope.views.baseview.BaseDeletePopupView;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.baseview.BaseSimpleCallback;
import com.rigol.scope.views.baseview.LinearSpaceItemDecoration;
import com.rigol.scope.views.baseview.OrientationView;
import com.rigol.scope.views.cursor.CounterSettingPopupView;
import com.rigol.scope.views.cursor.CursorSettingPopupView;
import com.rigol.scope.views.dvm.DvmSettingPopupView;
import com.rigol.scope.views.eye.EyePopupView;
import com.rigol.scope.views.histogram.HistogramResultParam;
import com.rigol.scope.views.histogram.HistogramSettingPopupView;
import com.rigol.scope.views.histogram.MeasHistogramResultParam;
import com.rigol.scope.views.jitter.JitterPopupView;
import com.rigol.scope.views.mask.MaskPopupView;
import com.rigol.scope.views.measure.MeasurePopupView;
import com.rigol.scope.views.measure.MeasureSettingPopupView;
import com.rigol.scope.views.quick.CounterQuickPopupView;
import com.rigol.scope.views.quick.CursorQuickPopupView;
import com.rigol.scope.views.quick.DvmQuickPopupView;
import com.rigol.scope.views.quick.EyeQuickPopupView;
import com.rigol.scope.views.quick.HistogramQuickPopupView;
import com.rigol.scope.views.quick.JitterQuickPopupView;
import com.rigol.scope.views.quick.MEASHistogramQuickPopupView;
import com.rigol.scope.views.quick.MaskQuickPopupView;
import com.rigol.scope.views.quick.MeasureQuickPopupView;
import com.rigol.scope.views.quick.QuickPopupView;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
/* loaded from: classes.dex */
public class ResultsBarFragment extends BaseFragment {
    private FragmentResultsBarBinding binding;
    private MeasureSettingParam measureSettingParam;
    private ResultListAdapter resultAdapter;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentResultsBarBinding inflate = FragmentResultsBarBinding.inflate(LayoutInflater.from(this.mActivity));
        this.binding = inflate;
        return inflate.getRoot();
    }

    @Override // com.rigol.scope.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((MeasureSettingViewModel) getAppViewModelProvider().get(MeasureSettingViewModel.class)).getLiveData().observe(this.mActivity, new Observer() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$fRxA0drDW0B0_SM2qpCcbNZsQWc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ResultsBarFragment.this.lambda$onViewCreated$0$ResultsBarFragment((MeasureSettingParam) obj);
            }
        });
        this.syncDataViewModel.get(21, MessageID.MSG_CURSOR_MODE).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$PIUBViw5uZQS-G3TEJJJw3P8y9k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ResultsBarFragment.this.lambda$onViewCreated$1$ResultsBarFragment(obj);
            }
        });
        this.syncDataViewModel.get(30, MessageID.MSG_DVM_ENABLE).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$9cqJ-663uWKxIq_1hv_jV8Ynj28
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ResultsBarFragment.this.lambda$onViewCreated$2$ResultsBarFragment(obj);
            }
        });
        this.syncDataViewModel.get(29, MessageID.MSG_COUNTER_1_ENABLE).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$oMs8FuSnR_C9y94sEi0ex02lM_E
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ResultsBarFragment.this.lambda$onViewCreated$3$ResultsBarFragment(obj);
            }
        });
        this.syncDataViewModel.get(51, MessageID.MSG_EYE_EN).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$PY3Ccu-tdspDPbjv5IUvJex5T8I
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ResultsBarFragment.this.lambda$onViewCreated$4$ResultsBarFragment(obj);
            }
        });
        this.syncDataViewModel.get(46, MessageID.MSG_MASK_ENABLE).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$MNRj1S0Hlv6_XfCES-Cp7Z1xjdc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ResultsBarFragment.this.lambda$onViewCreated$5$ResultsBarFragment(obj);
            }
        });
        this.syncDataViewModel.get(52, MessageID.MSG_JITTER_EN).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$F-lBUcCUhv3vOLMTL-tyxqF0Un4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ResultsBarFragment.this.lambda$onViewCreated$6$ResultsBarFragment(obj);
            }
        });
        this.syncDataViewModel.get(28, MessageID.MSG_APP_MEAS_ADD_MENU).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$GTQMZLK9CnZddCx8-WhNI5DWuxg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ResultsBarFragment.this.lambda$onViewCreated$7$ResultsBarFragment(obj);
            }
        });
        this.syncDataViewModel.get(28, MessageID.MSG_MEAS_STAT_VALUE_SET).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$T8kXQxjVpsDn4s_YsRNCiXlkIis
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ResultsBarFragment.this.lambda$onViewCreated$8$ResultsBarFragment(obj);
            }
        });
        initResultList(this.binding);
    }

    public /* synthetic */ void lambda$onViewCreated$0$ResultsBarFragment(MeasureSettingParam measureSettingParam) {
        this.measureSettingParam = measureSettingParam;
        this.binding.setParam(measureSettingParam);
    }

    public /* synthetic */ void lambda$onViewCreated$1$ResultsBarFragment(Object obj) {
        toggleFunction(obj, CursorSettingPopupView.class, CursorQuickPopupView.class);
    }

    public /* synthetic */ void lambda$onViewCreated$2$ResultsBarFragment(Object obj) {
        toggleFunction(obj, DvmSettingPopupView.class, DvmQuickPopupView.class);
    }

    public /* synthetic */ void lambda$onViewCreated$3$ResultsBarFragment(Object obj) {
        toggleFunction(obj, CounterSettingPopupView.class, CounterQuickPopupView.class);
    }

    public /* synthetic */ void lambda$onViewCreated$4$ResultsBarFragment(Object obj) {
        toggleFunction(obj, EyeQuickPopupView.class);
    }

    public /* synthetic */ void lambda$onViewCreated$5$ResultsBarFragment(Object obj) {
        toggleFunction(obj, MaskQuickPopupView.class);
    }

    public /* synthetic */ void lambda$onViewCreated$6$ResultsBarFragment(Object obj) {
        toggleFunction(obj, JitterQuickPopupView.class);
    }

    public /* synthetic */ void lambda$onViewCreated$7$ResultsBarFragment(Object obj) {
        ServiceEnum.Chan chanFromValue1;
        ServiceEnum.Chan chanFromValue12;
        ResultListAdapter resultListAdapter;
        if (obj instanceof TwoTuple) {
            TwoTuple twoTuple = (TwoTuple) obj;
            Object first = twoTuple.getFirst();
            if ((first instanceof Boolean) && ((Boolean) first).booleanValue()) {
                Object second = twoTuple.getSecond();
                if (second instanceof Integer) {
                    int intValue = ((Integer) second).intValue();
                    int i = (65280 & intValue) >> 8;
                    int i2 = intValue & 255;
                    ServiceEnum.MeasType measTypeFromValue1 = ServiceEnum.getMeasTypeFromValue1((16711680 & intValue) >> 16);
                    if (measTypeFromValue1 == null || (chanFromValue1 = ServiceEnum.getChanFromValue1(i)) == null || (chanFromValue12 = ServiceEnum.getChanFromValue1(i2)) == null || (resultListAdapter = this.resultAdapter) == null || resultListAdapter.getItemCount() == 0) {
                        return;
                    }
                    List<ResultParam> items = this.resultAdapter.getItems();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= items.size()) {
                            break;
                        }
                        ResultParam resultParam = items.get(i3);
                        if (resultParam != null && resultParam.getMeasType() == measTypeFromValue1 && resultParam.getSourceA() == chanFromValue1 && resultParam.getSourceB() == chanFromValue12) {
                            this.resultAdapter.remove(i3);
                            break;
                        }
                        i3++;
                    }
                }
            }
        }
        this.resultAdapter.notifyDataSetChanged();
    }

    public /* synthetic */ void lambda$onViewCreated$8$ResultsBarFragment(Object obj) {
        ResultParam resultParam;
        for (int i = 0; i < this.resultAdapter.getItems().size(); i++) {
            if (((ServiceEnum.MeasType) Objects.requireNonNull(this.resultAdapter.getItems().get(i).getMeasType())).value1 == ((Integer) obj).intValue()) {
                this.resultAdapter.setCurrentItem(i);
                this.resultAdapter.notifyDataSetChanged();
                boolean UI_QueryBool = API.getInstance().UI_QueryBool(28, MessageID.MSG_APP_MEAS_STAT_ENABLE);
                List<ResultParam> items = this.resultAdapter.getItems();
                if (items != null && (resultParam = items.get(i)) != null) {
                    resultParam.setStat(UI_QueryBool ? 1 : 0);
                }
            }
        }
    }

    private void toggleFunction(Object obj, Class<? extends BasePopupView> cls) {
        if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
            return;
        }
        PopupViewManager.getInstance().dismiss(cls);
    }

    private void toggleFunction(Object obj, Class<? extends BasePopupView> cls, Class<? extends BasePopupView> cls2) {
        if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
            return;
        }
        PopupViewManager.getInstance().dismiss(cls);
        PopupViewManager.getInstance().dismiss(cls2);
    }

    private void initResultList(FragmentResultsBarBinding fragmentResultsBarBinding) {
        this.resultAdapter = new ResultListAdapter(this.mActivity);
        ViewUtil.setSupportsChangeAnimations(fragmentResultsBarBinding.resultList, false);
        RecyclerView.RecycledViewPool recycledViewPool = fragmentResultsBarBinding.resultList.getRecycledViewPool();
        SparseArrayCompat<AdapterDelegate<List<ResultParam>>> delegates = this.resultAdapter.getDelegatesManager().getDelegates();
        if (delegates != null) {
            for (int i = 0; i < delegates.size(); i++) {
                recycledViewPool.setMaxRecycledViews(delegates.keyAt(i), 50);
            }
        }
        fragmentResultsBarBinding.resultList.setRecycledViewPool(recycledViewPool);
        fragmentResultsBarBinding.resultList.addItemDecoration(new LinearSpaceItemDecoration(5));
        fragmentResultsBarBinding.resultList.setAdapter(this.resultAdapter);
        fragmentResultsBarBinding.resultList.setItemAnimator(null);
        this.resultAdapter.setOnItemGestureDetectorListener(new OnItemGestureDetectorListener() { // from class: com.rigol.scope.ResultsBarFragment.1
            @Override // com.rigol.scope.adapters.OnItemGestureDetectorListener
            public boolean onDoubleTap(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i2) {
                if (i2 < 0) {
                    return true;
                }
                ResultsBarFragment.this.resultAdapter.setCurrentItem(i2);
                ResultsBarFragment.this.resultAdapter.notifyDataSetChanged();
                ResultsBarFragment.this.showSettingPopupView(view, i2);
                return true;
            }

            @Override // com.rigol.scope.adapters.OnItemGestureDetectorListener
            public void onLongPress(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i2) {
                if (i2 < 0) {
                    return;
                }
                ResultsBarFragment.this.resultAdapter.setCurrentItem(i2);
                ResultsBarFragment.this.resultAdapter.notifyDataSetChanged();
                ResultsBarFragment.this.showSettingPopupView(view, i2);
            }

            @Override // com.rigol.scope.adapters.OnItemGestureDetectorListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i2) {
                if (i2 < 0) {
                    return true;
                }
                MessageBus.getInstance().onSyncData(MessageBus.getKey(28, MessageID.MSG_APP_MEASURE), ResultsBarFragment.this.resultAdapter.getItems().get(i2).getMeasType());
                MessageBus messageBus = MessageBus.getInstance();
                String key = MessageBus.getKey(28, MessageID.MSG_APP_RESULT);
                messageBus.onSyncData(key, ResultsBarFragment.this.resultAdapter.getItems().get(i2).getSourceA().value1 + ";" + ResultsBarFragment.this.resultAdapter.getItems().get(i2).getSourceB().value1);
                ResultsBarFragment.this.resultAdapter.setCurrentItem(i2);
                ResultsBarFragment.this.resultAdapter.notifyDataSetChanged();
                if (ResultsBarFragment.this.resultAdapter.getItems().get(i2) instanceof MeasureResultParam) {
                    ResultsBarFragment.this.measureSettingParam.saveThresholdSource(ServiceEnum.getChanFromValue1(ResultsBarFragment.this.resultAdapter.getItems().get(i2).getSourceA().value1));
                }
                ResultsBarFragment.this.showQuickPopupView(view, i2);
                return true;
            }
        });
        new ItemTouchHelper(new BaseSimpleCallback(0, 8) { // from class: com.rigol.scope.ResultsBarFragment.2
            @Override // com.rigol.scope.views.baseview.BaseSimpleCallback, androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int i2) {
                super.onSwiped(viewHolder, i2);
                int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
                if (ResultsBarFragment.this.resultAdapter.getItems().get(bindingAdapterPosition).getMeasType() != ServiceEnum.MeasType.MASK_RESULT) {
                    if (ResultsBarFragment.this.resultAdapter.getItems().get(bindingAdapterPosition).getMeasType() == ServiceEnum.MeasType.Meas_Cursor) {
                        FunctionManager.getInstance().cursorSwitch = false;
                        MessageBus.getInstance().onSyncData(MessageBus.getKey(10, MessageID.MSG_HOR_REFRESH_ULTRAL_ENABLE), null);
                    }
                } else {
                    FunctionManager.getInstance().maskSwitch = false;
                    MessageBus.getInstance().onSyncData(MessageBus.getKey(10, MessageID.MSG_HOR_REFRESH_ULTRAL_ENABLE), null);
                }
                ResultsBarFragment.this.resultAdapter.remove(bindingAdapterPosition);
            }
        }).attachToRecyclerView(fragmentResultsBarBinding.resultList);
        this.updateUIViewModel.bind(getViewLifecycleOwner(), this.resultAdapter);
        ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$uuFPuLYenewgTFpCr1_UNcKeBeE
            @Override // java.lang.Runnable
            public final void run() {
                ResultsBarFragment.this.lambda$initResultList$9$ResultsBarFragment();
            }
        }, 1000L);
    }

    public /* synthetic */ void lambda$initResultList$9$ResultsBarFragment() {
        try {
            this.resultAdapter.recover();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showQuickPopupView(final View view, final int i) {
        final BasePopupView basePopupView;
        ResultParam resultParam = this.resultAdapter.getItems().get(i);
        final SharedViewModel sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
        if (resultParam instanceof MeasureResultParam) {
            basePopupView = PopupViewManager.getInstance().get(MeasureQuickPopupView.class);
            if (basePopupView instanceof QuickPopupView) {
                ((QuickPopupView) basePopupView).setOnItemClickListener(new QuickPopupView.OnItemClickListener() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$OVRmUkQa6kvOFa1BtR0CqD_dnb4
                    @Override // com.rigol.scope.views.quick.QuickPopupView.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i2, MappingObject mappingObject) {
                        ResultsBarFragment.this.lambda$showQuickPopupView$10$ResultsBarFragment(basePopupView, view, i, sharedViewModel, view2, viewHolder, i2, mappingObject);
                    }
                });
            }
        } else if (resultParam instanceof CounterResultParam) {
            basePopupView = PopupViewManager.getInstance().get(CounterQuickPopupView.class);
            if (basePopupView instanceof QuickPopupView) {
                ((QuickPopupView) basePopupView).setOnItemClickListener(new QuickPopupView.OnItemClickListener() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$AxZkdmNDu-6uXaxwo1qPmeOcOZg
                    @Override // com.rigol.scope.views.quick.QuickPopupView.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i2, MappingObject mappingObject) {
                        ResultsBarFragment.this.lambda$showQuickPopupView$11$ResultsBarFragment(basePopupView, view, i, view2, viewHolder, i2, mappingObject);
                    }
                });
            }
        } else if (resultParam instanceof DvmResultParam) {
            basePopupView = PopupViewManager.getInstance().get(DvmQuickPopupView.class);
            if (basePopupView instanceof QuickPopupView) {
                ((QuickPopupView) basePopupView).setOnItemClickListener(new QuickPopupView.OnItemClickListener() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$UZaYZI639Vdijv-CmFp-sZQJHxs
                    @Override // com.rigol.scope.views.quick.QuickPopupView.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i2, MappingObject mappingObject) {
                        ResultsBarFragment.this.lambda$showQuickPopupView$12$ResultsBarFragment(basePopupView, view, i, view2, viewHolder, i2, mappingObject);
                    }
                });
            }
        } else if (resultParam instanceof CursorResultParam) {
            basePopupView = PopupViewManager.getInstance().get(CursorQuickPopupView.class);
            if (basePopupView instanceof QuickPopupView) {
                ((QuickPopupView) basePopupView).setOnItemClickListener(new QuickPopupView.OnItemClickListener() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$AjpseuwOqGSBVQc2uOvcXRDtqU4
                    @Override // com.rigol.scope.views.quick.QuickPopupView.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i2, MappingObject mappingObject) {
                        ResultsBarFragment.this.lambda$showQuickPopupView$13$ResultsBarFragment(basePopupView, view, i, view2, viewHolder, i2, mappingObject);
                    }
                });
            }
        } else if (resultParam instanceof HistogramResultParam) {
            basePopupView = PopupViewManager.getInstance().get(HistogramQuickPopupView.class);
            if (basePopupView instanceof QuickPopupView) {
                ((QuickPopupView) basePopupView).setOnItemClickListener(new QuickPopupView.OnItemClickListener() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$lKG-zsrlIeUOEq0Mejh6Qd4b9LE
                    @Override // com.rigol.scope.views.quick.QuickPopupView.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i2, MappingObject mappingObject) {
                        ResultsBarFragment.this.lambda$showQuickPopupView$14$ResultsBarFragment(basePopupView, view, i, view2, viewHolder, i2, mappingObject);
                    }
                });
            }
        } else if (resultParam instanceof EyeResultParam) {
            basePopupView = PopupViewManager.getInstance().get(MEASHistogramQuickPopupView.class);
            if (basePopupView instanceof QuickPopupView) {
                ((QuickPopupView) basePopupView).setOnItemClickListener(new QuickPopupView.OnItemClickListener() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$O2521j-R89-6mTmwbopOpZZX8nQ
                    @Override // com.rigol.scope.views.quick.QuickPopupView.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i2, MappingObject mappingObject) {
                        ResultsBarFragment.this.lambda$showQuickPopupView$15$ResultsBarFragment(basePopupView, view, i, view2, viewHolder, i2, mappingObject);
                    }
                });
            }
        } else if (resultParam instanceof MaskResultParam) {
            basePopupView = PopupViewManager.getInstance().get(MaskQuickPopupView.class);
            if (basePopupView instanceof QuickPopupView) {
                ((QuickPopupView) basePopupView).setOnItemClickListener(new QuickPopupView.OnItemClickListener() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$e7_TqgM4kYCxQj9kmkyca22CGoU
                    @Override // com.rigol.scope.views.quick.QuickPopupView.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i2, MappingObject mappingObject) {
                        ResultsBarFragment.this.lambda$showQuickPopupView$16$ResultsBarFragment(basePopupView, view, i, view2, viewHolder, i2, mappingObject);
                    }
                });
            }
        } else if (resultParam instanceof JitterResultParam) {
            basePopupView = PopupViewManager.getInstance().get(JitterQuickPopupView.class);
            if (basePopupView instanceof QuickPopupView) {
                ((QuickPopupView) basePopupView).setOnItemClickListener(new QuickPopupView.OnItemClickListener() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$XqsbKWEMH8EJdTXCqoz6wHRnGhQ
                    @Override // com.rigol.scope.views.quick.QuickPopupView.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i2, MappingObject mappingObject) {
                        ResultsBarFragment.this.lambda$showQuickPopupView$17$ResultsBarFragment(basePopupView, view, i, view2, viewHolder, i2, mappingObject);
                    }
                });
            }
        } else if (resultParam instanceof MeasHistogramResultParam) {
            basePopupView = PopupViewManager.getInstance().get(MEASHistogramQuickPopupView.class);
            if (basePopupView instanceof QuickPopupView) {
                ((QuickPopupView) basePopupView).setOnItemClickListener(new QuickPopupView.OnItemClickListener() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$EAw3deoVNfD5AUUFfq4EdEEvcxA
                    @Override // com.rigol.scope.views.quick.QuickPopupView.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i2, MappingObject mappingObject) {
                        ResultsBarFragment.this.lambda$showQuickPopupView$18$ResultsBarFragment(basePopupView, view, i, view2, viewHolder, i2, mappingObject);
                    }
                });
            }
        } else {
            basePopupView = null;
        }
        if (basePopupView != null) {
            PopupViewManager.getInstance().isTouchControlLight = false;
            basePopupView.setAnchor(view);
            basePopupView.setYoff(-view.getHeight());
            basePopupView.setXoff(-180);
            basePopupView.show();
        }
    }

    public /* synthetic */ void lambda$showQuickPopupView$10$ResultsBarFragment(BasePopupView basePopupView, View view, int i, SharedViewModel sharedViewModel, View view2, RecyclerView.ViewHolder viewHolder, int i2, MappingObject mappingObject) {
        ServiceEnum.MeasureQuickItemType measureQuickItemTypeFromValue1;
        if (mappingObject == null || (measureQuickItemTypeFromValue1 = ServiceEnum.getMeasureQuickItemTypeFromValue1(mappingObject.getValue())) == null) {
            return;
        }
        switch (AnonymousClass3.$SwitchMap$com$rigol$scope$cil$ServiceEnum$MeasureQuickItemType[measureQuickItemTypeFromValue1.ordinal()]) {
            case 1:
                basePopupView.dismiss();
                showSettingPopupView(view, i);
                return;
            case 2:
                ResultListAdapter resultListAdapter = this.resultAdapter;
                if (resultListAdapter != null) {
                    resultListAdapter.remove(resultListAdapter.getCurrentItem());
                    basePopupView.dismiss();
                    return;
                }
                return;
            case 3:
                API.getInstance().UI_PostInt32(28, MessageID.MSG_APP_MEAS_STAT_RESET, 1);
                return;
            case 4:
                MeasureSettingParam measureSettingParam = this.measureSettingParam;
                if (measureSettingParam != null) {
                    measureSettingParam.saveCursorIndicator(true);
                    this.measureSettingParam.saveCursorThreshold(true);
                    OrientationView.Companion.setShowThreshold(true);
                    return;
                }
                return;
            case 5:
                basePopupView.dismiss();
                if (sharedViewModel != null) {
                    sharedViewModel.hasChangeMeasureItem.setValue(true);
                }
                showPopupView(view, MeasurePopupView.class);
                return;
            case 6:
                showDeleteAllAlertPopupView();
                return;
            default:
                return;
        }
    }

    public /* synthetic */ void lambda$showQuickPopupView$11$ResultsBarFragment(BasePopupView basePopupView, View view, int i, View view2, RecyclerView.ViewHolder viewHolder, int i2, MappingObject mappingObject) {
        ServiceEnum.MeasureQuickItemType measureQuickItemTypeFromValue1;
        if (mappingObject == null || (measureQuickItemTypeFromValue1 = ServiceEnum.getMeasureQuickItemTypeFromValue1(mappingObject.getValue())) == null) {
            return;
        }
        int i3 = AnonymousClass3.$SwitchMap$com$rigol$scope$cil$ServiceEnum$MeasureQuickItemType[measureQuickItemTypeFromValue1.ordinal()];
        if (i3 == 1) {
            basePopupView.dismiss();
            showSettingPopupView(view, i);
        } else if (i3 != 2) {
            if (i3 != 3) {
                return;
            }
            API.getInstance().UI_PostInt32(29, MessageID.MSG_COUNTER_1_TOT_CLEAR, 0);
        } else {
            ResultListAdapter resultListAdapter = this.resultAdapter;
            if (resultListAdapter != null) {
                resultListAdapter.remove(resultListAdapter.getCurrentItem());
                basePopupView.dismiss();
            }
        }
    }

    public /* synthetic */ void lambda$showQuickPopupView$12$ResultsBarFragment(BasePopupView basePopupView, View view, int i, View view2, RecyclerView.ViewHolder viewHolder, int i2, MappingObject mappingObject) {
        ServiceEnum.MeasureQuickItemType measureQuickItemTypeFromValue1;
        ResultListAdapter resultListAdapter;
        if (mappingObject == null || (measureQuickItemTypeFromValue1 = ServiceEnum.getMeasureQuickItemTypeFromValue1(mappingObject.getValue())) == null) {
            return;
        }
        int i3 = AnonymousClass3.$SwitchMap$com$rigol$scope$cil$ServiceEnum$MeasureQuickItemType[measureQuickItemTypeFromValue1.ordinal()];
        if (i3 == 1) {
            basePopupView.dismiss();
            showSettingPopupView(view, i);
        } else if (i3 == 2 && (resultListAdapter = this.resultAdapter) != null) {
            resultListAdapter.remove(resultListAdapter.getCurrentItem());
            basePopupView.dismiss();
        }
    }

    public /* synthetic */ void lambda$showQuickPopupView$13$ResultsBarFragment(BasePopupView basePopupView, View view, int i, View view2, RecyclerView.ViewHolder viewHolder, int i2, MappingObject mappingObject) {
        ServiceEnum.MeasureQuickItemType measureQuickItemTypeFromValue1;
        ResultListAdapter resultListAdapter;
        if (mappingObject == null || (measureQuickItemTypeFromValue1 = ServiceEnum.getMeasureQuickItemTypeFromValue1(mappingObject.getValue())) == null) {
            return;
        }
        int i3 = AnonymousClass3.$SwitchMap$com$rigol$scope$cil$ServiceEnum$MeasureQuickItemType[measureQuickItemTypeFromValue1.ordinal()];
        if (i3 == 1) {
            basePopupView.dismiss();
            showSettingPopupView(view, i);
        } else if (i3 == 2 && (resultListAdapter = this.resultAdapter) != null) {
            resultListAdapter.remove(resultListAdapter.getCurrentItem());
            basePopupView.dismiss();
        }
    }

    public /* synthetic */ void lambda$showQuickPopupView$14$ResultsBarFragment(BasePopupView basePopupView, View view, int i, View view2, RecyclerView.ViewHolder viewHolder, int i2, MappingObject mappingObject) {
        ServiceEnum.MeasureQuickItemType measureQuickItemTypeFromValue1;
        if (mappingObject == null || (measureQuickItemTypeFromValue1 = ServiceEnum.getMeasureQuickItemTypeFromValue1(mappingObject.getValue())) == null) {
            return;
        }
        int i3 = AnonymousClass3.$SwitchMap$com$rigol$scope$cil$ServiceEnum$MeasureQuickItemType[measureQuickItemTypeFromValue1.ordinal()];
        if (i3 == 1) {
            basePopupView.dismiss();
            showSettingPopupView(view, i);
        } else if (i3 != 2) {
            if (i3 != 3) {
                return;
            }
            API.getInstance().UI_PostInt32(34, MessageID.MSG_HISTO_RESET, 1);
        } else {
            ResultListAdapter resultListAdapter = this.resultAdapter;
            if (resultListAdapter != null) {
                resultListAdapter.remove(resultListAdapter.getCurrentItem());
                basePopupView.dismiss();
            }
        }
    }

    public /* synthetic */ void lambda$showQuickPopupView$15$ResultsBarFragment(BasePopupView basePopupView, View view, int i, View view2, RecyclerView.ViewHolder viewHolder, int i2, MappingObject mappingObject) {
        ServiceEnum.MeasureQuickItemType measureQuickItemTypeFromValue1;
        if (mappingObject == null || (measureQuickItemTypeFromValue1 = ServiceEnum.getMeasureQuickItemTypeFromValue1(mappingObject.getValue())) == null) {
            return;
        }
        int i3 = AnonymousClass3.$SwitchMap$com$rigol$scope$cil$ServiceEnum$MeasureQuickItemType[measureQuickItemTypeFromValue1.ordinal()];
        if (i3 == 1) {
            basePopupView.dismiss();
            showSettingPopupView(view, i);
        } else if (i3 != 2) {
            if (i3 != 3) {
                return;
            }
            API.getInstance().UI_PostInt32(34, MessageID.MSG_HISTO_MEAS_RESET, 1);
        } else {
            ResultListAdapter resultListAdapter = this.resultAdapter;
            if (resultListAdapter != null) {
                resultListAdapter.remove(resultListAdapter.getCurrentItem());
                basePopupView.dismiss();
            }
        }
    }

    public /* synthetic */ void lambda$showQuickPopupView$16$ResultsBarFragment(BasePopupView basePopupView, View view, int i, View view2, RecyclerView.ViewHolder viewHolder, int i2, MappingObject mappingObject) {
        ServiceEnum.MeasureQuickItemType measureQuickItemTypeFromValue1;
        if (mappingObject == null || (measureQuickItemTypeFromValue1 = ServiceEnum.getMeasureQuickItemTypeFromValue1(mappingObject.getValue())) == null) {
            return;
        }
        int i3 = AnonymousClass3.$SwitchMap$com$rigol$scope$cil$ServiceEnum$MeasureQuickItemType[measureQuickItemTypeFromValue1.ordinal()];
        if (i3 == 1) {
            basePopupView.dismiss();
            showSettingPopupView(view, i);
        } else if (i3 != 2) {
            if (i3 != 3) {
                return;
            }
            API.getInstance().UI_PostInt32(46, MessageID.MSG_MASK_RESET_STAT, 0);
        } else {
            ResultListAdapter resultListAdapter = this.resultAdapter;
            if (resultListAdapter != null) {
                resultListAdapter.remove(resultListAdapter.getCurrentItem());
                basePopupView.dismiss();
            }
        }
    }

    public /* synthetic */ void lambda$showQuickPopupView$17$ResultsBarFragment(BasePopupView basePopupView, View view, int i, View view2, RecyclerView.ViewHolder viewHolder, int i2, MappingObject mappingObject) {
        ServiceEnum.MeasureQuickItemType measureQuickItemTypeFromValue1;
        ResultListAdapter resultListAdapter;
        if (mappingObject == null || (measureQuickItemTypeFromValue1 = ServiceEnum.getMeasureQuickItemTypeFromValue1(mappingObject.getValue())) == null) {
            return;
        }
        int i3 = AnonymousClass3.$SwitchMap$com$rigol$scope$cil$ServiceEnum$MeasureQuickItemType[measureQuickItemTypeFromValue1.ordinal()];
        if (i3 == 1) {
            basePopupView.dismiss();
            showSettingPopupView(view, i);
        } else if (i3 == 2 && (resultListAdapter = this.resultAdapter) != null) {
            resultListAdapter.remove(resultListAdapter.getCurrentItem());
            basePopupView.dismiss();
        }
    }

    public /* synthetic */ void lambda$showQuickPopupView$18$ResultsBarFragment(BasePopupView basePopupView, View view, int i, View view2, RecyclerView.ViewHolder viewHolder, int i2, MappingObject mappingObject) {
        ServiceEnum.MeasureQuickItemType measureQuickItemTypeFromValue1;
        if (mappingObject == null || (measureQuickItemTypeFromValue1 = ServiceEnum.getMeasureQuickItemTypeFromValue1(mappingObject.getValue())) == null) {
            return;
        }
        int i3 = AnonymousClass3.$SwitchMap$com$rigol$scope$cil$ServiceEnum$MeasureQuickItemType[measureQuickItemTypeFromValue1.ordinal()];
        if (i3 == 1) {
            basePopupView.dismiss();
            showSettingPopupView(view, i);
        } else if (i3 != 2) {
            if (i3 != 3) {
                return;
            }
            API.getInstance().UI_PostInt32(34, MessageID.MSG_HISTO_MEAS_RESET, 1);
        } else {
            ResultListAdapter resultListAdapter = this.resultAdapter;
            if (resultListAdapter != null) {
                resultListAdapter.remove(resultListAdapter.getCurrentItem());
                basePopupView.dismiss();
            }
        }
    }

    /* renamed from: com.rigol.scope.ResultsBarFragment$3  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$MeasureQuickItemType;

        static {
            int[] iArr = new int[ServiceEnum.MeasureQuickItemType.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$MeasureQuickItemType = iArr;
            try {
                iArr[ServiceEnum.MeasureQuickItemType.SETTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MeasureQuickItemType[ServiceEnum.MeasureQuickItemType.REMOVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MeasureQuickItemType[ServiceEnum.MeasureQuickItemType.RESET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MeasureQuickItemType[ServiceEnum.MeasureQuickItemType.INDICATOR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MeasureQuickItemType[ServiceEnum.MeasureQuickItemType.CHANGE_ITEM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MeasureQuickItemType[ServiceEnum.MeasureQuickItemType.REMOVE_ALL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSettingPopupView(View view, int i) {
        if (i >= this.resultAdapter.getItems().size()) {
            return;
        }
        ResultParam resultParam = this.resultAdapter.getItems().get(i);
        if (resultParam instanceof MeasureResultParam) {
            showPopupView(view, MeasureSettingPopupView.class);
        } else if (resultParam instanceof CursorResultParam) {
            showPopupView(view, CursorSettingPopupView.class);
        } else if (resultParam instanceof DvmResultParam) {
            showPopupView(view, DvmSettingPopupView.class);
        } else if (resultParam instanceof CounterResultParam) {
            showPopupView(view, CounterSettingPopupView.class);
        } else if (resultParam instanceof HistogramResultParam) {
            showPopupView(view, HistogramSettingPopupView.class);
        } else if (resultParam instanceof EyeResultParam) {
            PopupViewManager.getInstance().show(EyePopupView.class);
        } else if (resultParam instanceof MaskResultParam) {
            PopupViewManager.getInstance().show(MaskPopupView.class);
        } else if (resultParam instanceof JitterResultParam) {
            PopupViewManager.getInstance().show(JitterPopupView.class);
        } else if (resultParam instanceof MeasHistogramResultParam) {
            PopupViewManager.getInstance().show(MeasureSettingPopupView.class);
        }
    }

    public void showPopupView(Class<? extends BasePopupView> cls) {
        final BasePopupView basePopupView = PopupViewManager.getInstance().get(cls);
        if (basePopupView instanceof BaseDeletePopupView) {
            BaseDeletePopupView baseDeletePopupView = (BaseDeletePopupView) basePopupView;
            baseDeletePopupView.setDeleteListener(new View.OnClickListener() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$WvbOjG5b7rKKz5UYmFQEkWng5tQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResultsBarFragment.this.lambda$showPopupView$19$ResultsBarFragment(basePopupView, view);
                }
            });
            baseDeletePopupView.setDeleteAllListener(new View.OnClickListener() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$FpumraDaZZJgYbYBxvHjuQZVDFw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResultsBarFragment.this.lambda$showPopupView$20$ResultsBarFragment(view);
                }
            });
        }
        basePopupView.show();
    }

    public /* synthetic */ void lambda$showPopupView$19$ResultsBarFragment(BasePopupView basePopupView, View view) {
        ResultListAdapter resultListAdapter = this.resultAdapter;
        resultListAdapter.remove(resultListAdapter.getCurrentItem());
        basePopupView.dismiss();
    }

    public /* synthetic */ void lambda$showPopupView$20$ResultsBarFragment(View view) {
        showDeleteAllAlertPopupView();
    }

    private void showPopupView(View view, Class<? extends BasePopupView> cls) {
        final BasePopupView basePopupView = PopupViewManager.getInstance().get(cls);
        if (basePopupView instanceof BaseDeletePopupView) {
            BaseDeletePopupView baseDeletePopupView = (BaseDeletePopupView) basePopupView;
            baseDeletePopupView.setDeleteListener(new View.OnClickListener() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$XORpcxYfKLBY3jqgcoa1nOsqOxw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ResultsBarFragment.this.lambda$showPopupView$21$ResultsBarFragment(basePopupView, view2);
                }
            });
            baseDeletePopupView.setDeleteAllListener(new View.OnClickListener() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$XcfH4X-2Qc8dAyzwE80gCkYbsCI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ResultsBarFragment.this.lambda$showPopupView$22$ResultsBarFragment(view2);
                }
            });
        }
        if (basePopupView instanceof MeasurePopupView) {
            ((MeasurePopupView) basePopupView).setGravity(BadgeDrawable.TOP_START);
        }
        basePopupView.setAnchor(view);
        basePopupView.setYoff(-view.getHeight());
        basePopupView.shoResults();
    }

    public /* synthetic */ void lambda$showPopupView$21$ResultsBarFragment(BasePopupView basePopupView, View view) {
        ResultListAdapter resultListAdapter = this.resultAdapter;
        resultListAdapter.remove(resultListAdapter.getCurrentItem());
        basePopupView.dismiss();
    }

    public /* synthetic */ void lambda$showPopupView$22$ResultsBarFragment(View view) {
        showDeleteAllAlertPopupView();
    }

    public ResultListAdapter getResultAdapter() {
        return this.resultAdapter;
    }

    private void showDeleteAllAlertPopupView() {
        BasePopupView basePopupView = PopupViewManager.getInstance().get(RemoveAllMeasurePopupView.class);
        if (basePopupView instanceof RemoveAllMeasurePopupView) {
            ((RemoveAllMeasurePopupView) basePopupView).setConfirmListener(new View.OnClickListener() { // from class: com.rigol.scope.-$$Lambda$ResultsBarFragment$sDX2t6cBnCX6xJx0Ne4h2FVsUaQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResultsBarFragment.this.lambda$showDeleteAllAlertPopupView$23$ResultsBarFragment(view);
                }
            });
            basePopupView.show();
        }
    }

    public /* synthetic */ void lambda$showDeleteAllAlertPopupView$23$ResultsBarFragment(View view) {
        if (this.resultAdapter != null) {
            PopupViewManager.getInstance().dismiss(MeasureSettingPopupView.class);
            this.resultAdapter.removeAll(MeasureResultParam.class);
        }
    }

    @Override // com.rigol.scope.BaseFragment
    public void onLocaleChanged() {
        super.onLocaleChanged();
        this.resultAdapter.refreshTitles(this.mActivity);
    }
}
