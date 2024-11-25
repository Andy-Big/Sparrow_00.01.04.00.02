package com.rigol.scope.views.measure;

import android.app.Activity;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.ActivityUtils;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.ResultsBarFragment;
import com.rigol.scope.adapters.MeasureViewPagerAdapter;
import com.rigol.scope.adapters.MultiItemTypeAdapter;
import com.rigol.scope.adapters.ResultListAdapter;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MeasureResultParam;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.ResultParam;
import com.rigol.scope.data.TwoTuple;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.databinding.PopupviewMeasureBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.MeasureResultViewModel;
import com.rigol.scope.viewmodels.MeasureSettingViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.scope.views.vertical.VerticalPopupView;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;
/* loaded from: classes2.dex */
public class MeasurePopupView extends BasePopupView implements View.OnClickListener, MeasureViewPagerAdapter.OnItemClickListener {
    private AorBManager aorBManager;
    private final PopupviewMeasureBinding binding;
    private View clickedView;
    private boolean isChangeItem;
    private List<AorBParam> list_aorbParam;
    private List<MappingObject> mappingObjects;
    private final MeasureResultViewModel measureResultViewModel;
    private final ViewPager2.OnPageChangeCallback pageChangeCallback;
    private PanelKeyViewModel panelKeyViewModel;
    private MeasureSettingParam param;
    private final ObservableInt pic;
    private PopupSpinner popupSpinner;
    private final SharedViewModel sharedViewModel;
    private SpinnerAdapter spinnerAdapter;
    private List<MappingObject> tabTitles;
    private List<VerticalParam> verticalParams;
    private final MeasureViewPagerAdapter viewPagerAdapter;

    public MeasurePopupView() {
        super((int) R.style.App_PopupWindow_Measure);
        this.measureResultViewModel = (MeasureResultViewModel) ContextUtil.getAppViewModel(MeasureResultViewModel.class);
        this.pic = new ObservableInt();
        this.isChangeItem = false;
        this.param = null;
        this.list_aorbParam = new ArrayList();
        this.pageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: com.rigol.scope.views.measure.MeasurePopupView.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                MultiItemTypeAdapter multiItemTypeAdapter;
                super.onPageSelected(i);
                View findViewWithTag = ((RecyclerView) MeasurePopupView.this.binding.viewPager.getChildAt(0)).findViewWithTag(Integer.valueOf(i));
                if ((findViewWithTag instanceof RecyclerView) && (multiItemTypeAdapter = (MultiItemTypeAdapter) ((RecyclerView) findViewWithTag).getAdapter()) != null) {
                    Object obj = multiItemTypeAdapter.getItems().get(0);
                    if (obj instanceof MappingObject) {
                        MeasurePopupView.this.pic.set(((MappingObject) obj).getValue());
                    }
                    int currentItem = multiItemTypeAdapter.getCurrentItem();
                    multiItemTypeAdapter.setCurrentItem(0);
                    multiItemTypeAdapter.notifyItemChanged(0);
                    multiItemTypeAdapter.notifyItemChanged(currentItem);
                }
                MeasurePopupView.this.param.setShowSelectSourceB(i == MeasurePopupView.this.viewPagerAdapter.getItemCount() - 1);
            }
        };
        this.tabTitles = ViewUtil.getList((int) R.array.msg_app_meas_cat);
        PopupviewMeasureBinding inflate = PopupviewMeasureBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        this.binding.setOnClickListener(this);
        this.binding.setPicObservable(this.pic);
        MeasureSettingViewModel measureSettingViewModel = (MeasureSettingViewModel) ContextUtil.getAppViewModel(MeasureSettingViewModel.class);
        if (measureSettingViewModel != null) {
            measureSettingViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasurePopupView$tGt0YfkIW28-vO1Wx3mN_ez1joo
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MeasurePopupView.this.lambda$new$0$MeasurePopupView((MeasureSettingParam) obj);
                }
            });
        }
        VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        if (verticalViewModel != null) {
            verticalViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasurePopupView$ScCPiXANQVy4w2Ft8M6CN1tBi54
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MeasurePopupView.this.lambda$new$1$MeasurePopupView((ArrayList) obj);
                }
            });
        }
        SharedViewModel sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
        this.sharedViewModel = sharedViewModel;
        if (sharedViewModel != null) {
            sharedViewModel.hasChangeMeasureItem.observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer<Boolean>() { // from class: com.rigol.scope.views.measure.MeasurePopupView.2
                @Override // androidx.lifecycle.Observer
                public void onChanged(Boolean bool) {
                    MeasurePopupView.this.isChangeItem = bool.booleanValue();
                }
            });
        }
        MeasureViewPagerAdapter measureViewPagerAdapter = new MeasureViewPagerAdapter(this.context, R.layout.adapter_item_popupview_measure);
        this.viewPagerAdapter = measureViewPagerAdapter;
        measureViewPagerAdapter.setOnItemClickListener(this);
        this.binding.viewPager.setOffscreenPageLimit(MeasureViewPagerAdapter.pagerResouces.size());
        this.binding.viewPager.registerOnPageChangeCallback(this.pageChangeCallback);
        this.binding.viewPager.setAdapter(this.viewPagerAdapter);
        new TabLayoutMediator(this.binding.tabs, this.binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasurePopupView$iyc92APB92dHvetFScl9Tr1eGRw
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                MeasurePopupView.this.lambda$new$2$MeasurePopupView(tab, i);
            }
        }).attach();
        UpdateUIViewModel updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        if (updateUIViewModel != null) {
            updateUIViewModel.get(ResultListAdapter.ON_LIST_CHANGED_KEY_MEASURE).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasurePopupView$gNOvSBa7UbSXuPMAOtDXGuwNV7Y
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MeasurePopupView.this.lambda$new$3$MeasurePopupView((Boolean) obj);
                }
            });
        }
        this.list_aorbParam.add(new AorBParam(this.binding.holder1Spinner, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.holder2Spinner, 0, false, "", 2));
        this.aorBManager = new AorBManager(this.context, this.list_aorbParam) { // from class: com.rigol.scope.views.measure.MeasurePopupView.3
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
            }
        };
        PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
        this.panelKeyViewModel = panelKeyViewModel;
        if (panelKeyViewModel != null) {
            panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasurePopupView$BHOe5XB36qEgDs3x_Dhp3e9kRsE
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MeasurePopupView.this.lambda$new$5$MeasurePopupView((KeyEvent) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$MeasurePopupView(MeasureSettingParam measureSettingParam) {
        this.param = measureSettingParam;
        this.binding.setParam(measureSettingParam);
    }

    public /* synthetic */ void lambda$new$1$MeasurePopupView(ArrayList arrayList) {
        this.verticalParams = arrayList;
        setSelectSourceA(arrayList);
    }

    public /* synthetic */ void lambda$new$2$MeasurePopupView(TabLayout.Tab tab, int i) {
        tab.setCustomView(R.layout.adapter_item_tab);
        TextView textView = (TextView) tab.getCustomView();
        if (textView != null) {
            textView.setText(this.tabTitles.get(i).getStr());
        }
    }

    public /* synthetic */ void lambda$new$3$MeasurePopupView(Boolean bool) {
        MeasureViewPagerAdapter measureViewPagerAdapter = this.viewPagerAdapter;
        if (measureViewPagerAdapter != null) {
            measureViewPagerAdapter.notifyDataSetChanged();
        }
    }

    public /* synthetic */ void lambda$new$5$MeasurePopupView(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(MeasurePopupView.class)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, null, null, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasurePopupView$da7YyUktLcXryrRUwLZWVstR2XA
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    MeasurePopupView.this.lambda$new$4$MeasurePopupView(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$4$MeasurePopupView(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.holder1_spinner) {
            selectSourceA(mappingObject);
        } else if (this.clickedView.getId() == R.id.holder2_spinner) {
            selectSourceB(mappingObject);
        }
    }

    private void setSelectSourceA(List<VerticalParam> list) {
        MeasureSettingParam measureSettingParam;
        VerticalParam defaultItem = ViewUtil.getDefaultItem(list);
        if (defaultItem == null || (measureSettingParam = this.param) == null) {
            return;
        }
        measureSettingParam.setSelectSourceA(defaultItem.getChan());
    }

    public void setPageCurrentItem(int i) {
        setPageCurrentItem(i, true);
    }

    public void setPageCurrentItem(int i, boolean z) {
        this.binding.viewPager.setCurrentItem(i, z);
    }

    private void selectSourceA(MappingObject mappingObject) {
        ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(mappingObject.getValue());
        if (chanFromValue1 != null) {
            this.param.saveSelectSourceA(chanFromValue1);
        }
        MeasureViewPagerAdapter measureViewPagerAdapter = this.viewPagerAdapter;
        if (measureViewPagerAdapter != null) {
            measureViewPagerAdapter.notifyDataSetChanged();
        }
    }

    private void selectSourceB(MappingObject mappingObject) {
        ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(mappingObject.getValue());
        if (chanFromValue1 != null) {
            this.param.saveSelectSourceB(chanFromValue1);
        }
        MeasureViewPagerAdapter measureViewPagerAdapter = this.viewPagerAdapter;
        if (measureViewPagerAdapter != null) {
            measureViewPagerAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ResultsBarFragment resultBarFragment;
        int id = view.getId();
        if (id == R.id.holder1_spinner) {
            ViewUtil.showChanSpinner(this.anchor, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_app_meas_srca)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasurePopupView$e3qcakGkn3xIKUAxWLmR6R5lV4o
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    MeasurePopupView.this.lambda$onClick$6$MeasurePopupView(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasurePopupView$DyvGtkG8WVwIeZ5AsNfe3vgo8Ok
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    MeasurePopupView.this.lambda$onClick$7$MeasurePopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.holder2_spinner) {
            ViewUtil.showChanSpinner(this.anchor, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_app_meas_srcb)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasurePopupView$V4BWOu3sUo1sbnEZB6aMA2VKUPs
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    MeasurePopupView.this.lambda$onClick$8$MeasurePopupView(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.measure.-$$Lambda$MeasurePopupView$_109urUtxQwqrJ_4-5ixhXgkRmk
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    MeasurePopupView.this.lambda$onClick$9$MeasurePopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.vertical_setting) {
            PopupViewManager.getInstance().show(VerticalPopupView.class);
        } else if (id == R.id.setting_btn) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (!(topActivity instanceof MainActivity) || (resultBarFragment = ((MainActivity) topActivity).getResultBarFragment()) == null) {
                return;
            }
            resultBarFragment.showPopupView(MeasureSettingPopupView.class);
        }
    }

    public /* synthetic */ void lambda$onClick$6$MeasurePopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$7$MeasurePopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceA(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$8$MeasurePopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$9$MeasurePopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceB(mappingObject);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onPanelKeyUp(int i, KeyEvent keyEvent) {
        super.onPanelKeyUp(i, keyEvent);
        if (i != 81) {
            if (i == 2131) {
                selectedItemCW();
                return;
            } else if (i != 4179) {
                return;
            } else {
                selectedItemCCW();
                return;
            }
        }
        RecyclerView recyclerView = (RecyclerView) this.binding.viewPager.getChildAt(0);
        RecyclerView recyclerView2 = (RecyclerView) recyclerView.getChildAt(0);
        Timber.d("pages.getChildCount():" + recyclerView.getChildCount() + ", items.getChildCount():" + recyclerView2.getChildCount(), new Object[0]);
        MultiItemTypeAdapter multiItemTypeAdapter = (MultiItemTypeAdapter) recyclerView2.getAdapter();
        if (multiItemTypeAdapter != null) {
            recyclerView2.getChildAt(multiItemTypeAdapter.getCurrentItem()).performClick();
        }
    }

    private void selectedItemCW() {
        RecyclerView recyclerView = (RecyclerView) this.binding.viewPager.getChildAt(0);
        RecyclerView recyclerView2 = (RecyclerView) recyclerView.getChildAt(0);
        Timber.d("pages.getChildCount():" + recyclerView.getChildCount() + ", items.getChildCount():" + recyclerView2.getChildCount(), new Object[0]);
        MultiItemTypeAdapter multiItemTypeAdapter = (MultiItemTypeAdapter) recyclerView2.getAdapter();
        if (multiItemTypeAdapter != null) {
            multiItemTypeAdapter.setCurrentItem(multiItemTypeAdapter.getCurrentItem() + 1);
            multiItemTypeAdapter.notifyDataSetChanged();
        }
    }

    private void selectedItemCCW() {
        RecyclerView recyclerView = (RecyclerView) this.binding.viewPager.getChildAt(0);
        RecyclerView recyclerView2 = (RecyclerView) recyclerView.getChildAt(0);
        Timber.d("pages.getChildCount():" + recyclerView.getChildCount() + ", items.getChildCount():" + recyclerView2.getChildCount(), new Object[0]);
        MultiItemTypeAdapter multiItemTypeAdapter = (MultiItemTypeAdapter) recyclerView2.getAdapter();
        if (multiItemTypeAdapter != null) {
            multiItemTypeAdapter.setCurrentItem(multiItemTypeAdapter.getCurrentItem() - 1);
            multiItemTypeAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        refreshPageCurrentItem();
        super.showAsDropDown(view, i, i2, i3);
    }

    private void refreshPageCurrentItem() {
        setPageCurrentItem(this.binding.viewPager.getCurrentItem(), false);
        this.viewPagerAdapter.notifyDataSetChanged();
    }

    public void notifyData() {
        MeasureViewPagerAdapter measureViewPagerAdapter = this.viewPagerAdapter;
        if (measureViewPagerAdapter != null) {
            measureViewPagerAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        refreshPageCurrentItem();
        super.showAtLocation(view, i, i2, i3);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        this.tabTitles = ViewUtil.getList((int) R.array.msg_app_meas_cat);
        MeasureViewPagerAdapter.pagerResouces.clear();
        MeasureViewPagerAdapter.pagerResouces.add(ViewUtil.getList((int) R.array.msg_app_meas_vertical_type));
        MeasureViewPagerAdapter.pagerResouces.add(ViewUtil.getList((int) R.array.msg_app_meas_hor_type));
        MeasureViewPagerAdapter.pagerResouces.add(ViewUtil.getList((int) R.array.msg_app_meas_other_type));
        this.viewPagerAdapter.notifyDataSetChanged();
    }

    @Override // com.rigol.scope.adapters.MeasureViewPagerAdapter.OnItemClickListener
    public void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i, List<?> list, boolean z) {
        int measureItem;
        MessageBus.getInstance().onSyncData(MessageBus.getKey(28, MessageID.MSG_APP_MEASURE), Integer.valueOf(((MappingObject) list.get(i)).getValue()));
        MessageBus.getInstance().onSyncData(MessageBus.getKey(28, MessageID.MSG_APP_RESULT), this.param.getSelectSourceA().value1 + ";" + this.param.getSelectSourceB().value1);
        int value = ((MappingObject) list.get(i)).getValue();
        this.pic.set(value);
        int currentItem = this.binding.viewPager.getCurrentItem();
        if (currentItem == 0 || currentItem == 1) {
            measureItem = ViewUtil.getMeasureItem(value, this.param.getSelectSourceA().value1);
        } else {
            measureItem = ViewUtil.getMeasureItem(value, this.param.getSelectSourceA().value1, this.param.getSelectSourceB().value1);
        }
        final List<ResultParam> value2 = this.measureResultViewModel.getLiveData().getValue();
        if (z && this.isChangeItem) {
            return;
        }
        if (!z && !this.isChangeItem) {
            if (value2 != null) {
                int i2 = 0;
                for (int i3 = 0; i3 < value2.size(); i3++) {
                    if (value2.get(i3) instanceof MeasureResultParam) {
                        i2++;
                    }
                }
                int i4 = 14;
                if (i2 + 1 > 14) {
                    for (int size = value2.size() - 1; size >= 0; size--) {
                        ResultParam resultParam = value2.get(size);
                        if ((resultParam instanceof MeasureResultParam) && i4 - 1 <= 0) {
                            ((MeasureResultParam) resultParam).remove();
                        }
                    }
                }
            }
            SharedViewModel sharedViewModel = this.sharedViewModel;
            if (sharedViewModel != null) {
                sharedViewModel.hasRemoveMeasureItem.setValue(false);
            }
            ViewUtil.addMeasureItem(measureItem);
        } else {
            ViewUtil.changeMeasureItem(measureItem);
        }
        MessageBus.getInstance().onSyncData(28, MessageID.MSG_APP_MEAS_ADD_MENU, new TwoTuple(Boolean.valueOf(z), Integer.valueOf(measureItem)));
        new Handler().postDelayed(new Runnable() { // from class: com.rigol.scope.views.measure.MeasurePopupView.4
            @Override // java.lang.Runnable
            public void run() {
                List list2 = value2;
                if (list2 != null && list2.size() > 0) {
                    List list3 = value2;
                    ((ResultParam) list3.get(list3.size() - 1)).setStat(0);
                }
                MeasurePopupView.this.param.saveStatisticState(false);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onPrepare() {
        super.onPrepare();
        setSelectSourceA(this.verticalParams);
    }

    public void setGravity(int i) {
        this.gravity = i;
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.param.saveInt(MessageID.MSG_APP_MEAS_CAT, 0);
        this.isChangeItem = false;
        setGravity(17);
        super.onDismiss();
    }
}
