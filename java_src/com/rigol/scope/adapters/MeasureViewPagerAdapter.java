package com.rigol.scope.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.MeasureViewPagerAdapter;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.data.ResultParam;
import com.rigol.scope.databinding.AdapterItemPopupviewMeasureBinding;
import com.rigol.scope.databinding.AdapterItemSimple2Binding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.MeasureResultViewModel;
import com.rigol.scope.viewmodels.MeasureSettingViewModel;
import com.rigol.scope.views.grid.GridSpaceItemDecoration;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MeasureViewPagerAdapter extends BaseAdapter<List<List<MappingObject>>> {
    private OnItemClickListener onItemClickListener;
    public static final List<List<MappingObject>> pagerResouces = new ArrayList<List<MappingObject>>() { // from class: com.rigol.scope.adapters.MeasureViewPagerAdapter.1
        {
            add(ViewUtil.getList((int) R.array.msg_app_meas_vertical_type));
            add(ViewUtil.getList((int) R.array.msg_app_meas_hor_type));
            add(ViewUtil.getList((int) R.array.msg_app_meas_other_type));
        }
    };
    public static final List<ListAdapter> adapters = new ArrayList();

    /* loaded from: classes.dex */
    public interface OnItemClickListener {
        void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i, List<?> list, boolean z);
    }

    public MeasureViewPagerAdapter(Context context, int i) {
        super(context, pagerResouces, i);
        adapters.add(new ListAdapter(context, R.layout.adapter_item_simple2));
        adapters.add(new ListAdapter(context, R.layout.adapter_item_simple2));
        adapters.add(new ListAdapter(context, R.layout.adapter_item_simple2));
    }

    @Override // com.rigol.scope.adapters.BaseAdapter
    protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<List<MappingObject>> list, int i) {
        AdapterItemPopupviewMeasureBinding adapterItemPopupviewMeasureBinding = (AdapterItemPopupviewMeasureBinding) baseViewHolder.getBinding();
        adapterItemPopupviewMeasureBinding.getRoot().setTag(Integer.valueOf(i));
        final ListAdapter listAdapter = adapters.get(i);
        listAdapter.setPageIndex(i);
        final List<MappingObject> list2 = list.get(i);
        listAdapter.setItems(list2);
        adapterItemPopupviewMeasureBinding.recyclerView.setAdapter(listAdapter);
        listAdapter.setOnItemClickListener(new com.rigol.scope.adapters.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MeasureViewPagerAdapter$k2USPdeh50Iyk6HVNpwWcc41mow
            @Override // com.rigol.scope.adapters.OnItemClickListener
            public final void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i2) {
                MeasureViewPagerAdapter.this.lambda$convert$0$MeasureViewPagerAdapter(list2, listAdapter, view, viewHolder, i2);
            }
        });
        listAdapter.notifyDataSetChanged();
    }

    public /* synthetic */ void lambda$convert$0$MeasureViewPagerAdapter(List list, ListAdapter listAdapter, View view, RecyclerView.ViewHolder viewHolder, int i) {
        OnItemClickListener onItemClickListener = this.onItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(view, viewHolder, i, list, listAdapter.isItemAdded(i));
        }
        listAdapter.setCurrentItem(i);
        listAdapter.notifyDataSetChanged();
    }

    @Override // com.rigol.scope.adapters.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup, int i) {
        BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup, i);
        ((AdapterItemPopupviewMeasureBinding) onCreateViewHolder.getBinding()).recyclerView.addItemDecoration(new GridSpaceItemDecoration(10, true));
        return onCreateViewHolder;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /* loaded from: classes.dex */
    public static class ListAdapter extends BaseAdapter<List<MappingObject>> {
        private MeasureSettingParam measureSettingParam;
        private int pageIndex;
        private List<? extends ResultParam> resultParams;

        public ListAdapter(Context context, int i) {
            super(context, i);
            this.pageIndex = 0;
            MeasureSettingViewModel measureSettingViewModel = (MeasureSettingViewModel) ContextUtil.getAppViewModel(MeasureSettingViewModel.class);
            if (measureSettingViewModel != null) {
                measureSettingViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$MeasureViewPagerAdapter$ListAdapter$Pr5BIw2ueZZbxfkUCX3luobg4wU
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        MeasureViewPagerAdapter.ListAdapter.this.lambda$new$0$MeasureViewPagerAdapter$ListAdapter((MeasureSettingParam) obj);
                    }
                });
            }
            MeasureResultViewModel measureResultViewModel = (MeasureResultViewModel) ContextUtil.getAppViewModel(MeasureResultViewModel.class);
            if (measureResultViewModel != null) {
                measureResultViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$MeasureViewPagerAdapter$ListAdapter$OTQ5C0ii38axKiRk44PvqCV8Ugk
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        MeasureViewPagerAdapter.ListAdapter.this.lambda$new$1$MeasureViewPagerAdapter$ListAdapter((List) obj);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$new$0$MeasureViewPagerAdapter$ListAdapter(MeasureSettingParam measureSettingParam) {
            this.measureSettingParam = measureSettingParam;
        }

        public /* synthetic */ void lambda$new$1$MeasureViewPagerAdapter$ListAdapter(List list) {
            this.resultParams = list;
        }

        @Override // com.rigol.scope.adapters.BaseAdapter
        protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<MappingObject> list, int i) {
            AdapterItemSimple2Binding adapterItemSimple2Binding = (AdapterItemSimple2Binding) baseViewHolder.getBinding();
            adapterItemSimple2Binding.text1.setText(list.get(i).getStr());
            ServiceEnum.MeasType measTypeFromValue1 = ServiceEnum.getMeasTypeFromValue1(list.get(i).getValue());
            if (measTypeFromValue1 != null && !TextUtils.isEmpty(measTypeFromValue1.pic1)) {
                adapterItemSimple2Binding.icon.setImageDrawable(ContextUtil.getDrawable(this.context, measTypeFromValue1.pic1));
            }
            adapterItemSimple2Binding.getRoot().setSelected(i == getCurrentItem());
            boolean isItemAdded = isItemAdded(measTypeFromValue1);
            adapterItemSimple2Binding.text1.setAlpha(isItemAdded ? 0.5f : 1.0f);
            adapterItemSimple2Binding.icon.setAlpha(isItemAdded ? 0.5f : 1.0f);
            adapterItemSimple2Binding.getRoot().setEnabled(true);
            if (this.measureSettingParam.getSelectSourceA().value1 <= ServiceEnum.Chan.chan4.value1 || this.measureSettingParam.getSelectSourceA().value1 == ServiceEnum.Chan.m1.value1 || this.measureSettingParam.getSelectSourceA().value1 == ServiceEnum.Chan.m2.value1 || this.measureSettingParam.getSelectSourceA().value1 == ServiceEnum.Chan.m3.value1 || this.measureSettingParam.getSelectSourceA().value1 == ServiceEnum.Chan.m4.value1) {
                return;
            }
            if (this.pageIndex == 0) {
                adapterItemSimple2Binding.text1.setAlpha(0.5f);
                adapterItemSimple2Binding.icon.setAlpha(0.5f);
                adapterItemSimple2Binding.getRoot().setEnabled(false);
            }
            if (this.pageIndex != 1 || i == 0 || i == 1 || i == 4 || i == 5 || i == 6 || i == 7) {
                return;
            }
            adapterItemSimple2Binding.text1.setAlpha(0.5f);
            adapterItemSimple2Binding.icon.setAlpha(0.5f);
            adapterItemSimple2Binding.getRoot().setEnabled(false);
        }

        public void setPageIndex(int i) {
            this.pageIndex = i;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List] */
        public boolean isItemAdded(int i) {
            if (i < 0 || i >= getItemCount() || getItemCount() == 0) {
                return false;
            }
            return isItemAdded(ServiceEnum.getMeasTypeFromValue1(((MappingObject) getItems().get(i)).getValue()));
        }

        private boolean isItemAdded(ServiceEnum.MeasType measType) {
            List<? extends ResultParam> list;
            if (this.measureSettingParam != null && (list = this.resultParams) != null && !list.isEmpty()) {
                for (ResultParam resultParam : this.resultParams) {
                    if (resultParam != null && measType == resultParam.getMeasType() && this.measureSettingParam.getSelectSourceA() == resultParam.getSourceA() && (!this.measureSettingParam.getShowSelectSourceB() || this.measureSettingParam.getSelectSourceB() == resultParam.getSourceB())) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
