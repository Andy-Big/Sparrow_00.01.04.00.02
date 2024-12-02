package com.rigol.scope.views.decode;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.ActivityUtils;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.databinding.AdapterItemPopupviewDecodeBindingImpl;
import com.rigol.scope.databinding.PopupviewDecodeBinding;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.viewmodels.DecodeViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import java.util.List;

/* loaded from: classes2.dex */
public class DecodeNewPopupView extends BasePopupView {
    private final PopupviewDecodeBinding binding;
    private int currentItem;
    private DecodeParam decodeParam;
    private DecodeRecyclerView decodeRecyclerView;
    private List<DecodeParam> params;
    ViewPagerAdapter viewPagerAdapter;

    public DecodeParam getDecodeParam() {
        return this.decodeParam;
    }

    public DecodeNewPopupView() {
        super((int) R.style.App_PopupWindow_Decode);
        this.viewPagerAdapter = new ViewPagerAdapter();
        DecodeViewModel decodeViewModel = (DecodeViewModel) ContextUtil.getAppViewModel(DecodeViewModel.class);
        if (decodeViewModel != null) {
            decodeViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer<List<DecodeParam>>() { // from class: com.rigol.scope.views.decode.DecodeNewPopupView.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.lifecycle.Observer
                public void onChanged(List<DecodeParam> list) {
                    DecodeNewPopupView.this.params = list;
                    DecodeNewPopupView.this.viewPagerAdapter.setParams(DecodeNewPopupView.this.params);
                    DecodeNewPopupView.this.viewPagerAdapter.notifyDataSetChanged();
                }
            });
        }
        PopupviewDecodeBinding inflate = PopupviewDecodeBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        this.viewPagerAdapter.setPopupviewDecodeBinding(this.binding);
        this.binding.viewPager.setAdapter(this.viewPagerAdapter);
        this.binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.rigol.scope.views.decode.DecodeNewPopupView.2
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                DecodeNewPopupView.this.binding.tabs.selectTab(DecodeNewPopupView.this.binding.tabs.getTabAt(i));
                ((DecodeParam) DecodeNewPopupView.this.params.get(i)).readPal_dat_thres();
                DecodeNewPopupView.this.setDecodeLight(i);
            }
        });
        new TabLayoutMediator(this.binding.tabs, this.binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.rigol.scope.views.decode.-$$Lambda$DecodeNewPopupView$K54KaSjShoKOQMnMK_qntHJuJZY
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                DecodeNewPopupView.this.lambda$new$0$DecodeNewPopupView(tab, i);
            }
        }).attach();
    }

    public /* synthetic */ void lambda$new$0$DecodeNewPopupView(TabLayout.Tab tab, int i) {
        TextView textView;
        tab.setCustomView(R.layout.adapter_item_tab);
        DecodeParam decodeParam = this.params.get(i);
        this.decodeParam = decodeParam;
        if (decodeParam == null || (textView = (TextView) tab.getCustomView()) == null) {
            return;
        }
        textView.setText(decodeParam.getTitle());
        textView.setTextColor(ColorUtil.getColor(this.context, decodeParam.getServiceId()));
    }

    public void setDecodeLight(int i) {
        List<DecodeParam> list = this.params;
        if (list == null || list.size() < i || i < 0) {
            return;
        }
        this.decodeParam = this.params.get(i);
        PopupViewManager.getInstance().decodeLight(i);
    }

    /* loaded from: classes2.dex */
    public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerHolder> {
        View anchorview;
        AdapterItemPopupviewDecodeBindingImpl binding;
        List<DecodeParam> params;
        PopupviewDecodeBinding popupviewDecodeBinding;

        public ViewPagerAdapter() {
        }

        public void setParams(List<DecodeParam> list) {
            this.params = list;
        }

        public void setPopupviewDecodeBinding(PopupviewDecodeBinding popupviewDecodeBinding) {
            this.popupviewDecodeBinding = popupviewDecodeBinding;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewPagerHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            this.binding = (AdapterItemPopupviewDecodeBindingImpl) AdapterItemPopupviewDecodeBindingImpl.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            return new ViewPagerHolder(this.binding);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewPagerHolder viewPagerHolder, int i) {
            AdapterItemPopupviewDecodeBindingImpl binding = viewPagerHolder.getBinding();
            DecodeNewPopupView.this.decodeRecyclerView = new DecodeRecyclerView(viewPagerHolder.itemView.getContext(), this.params.get(i), this.anchorview, binding, this.popupviewDecodeBinding, viewPagerHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<DecodeParam> list = this.params;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* loaded from: classes2.dex */
        public class ViewPagerHolder extends RecyclerView.ViewHolder {
            private AdapterItemPopupviewDecodeBindingImpl binding;

            public ViewPagerHolder(AdapterItemPopupviewDecodeBindingImpl adapterItemPopupviewDecodeBindingImpl) {
                super(adapterItemPopupviewDecodeBindingImpl.getRoot());
                this.binding = adapterItemPopupviewDecodeBindingImpl;
            }

            public AdapterItemPopupviewDecodeBindingImpl getBinding() {
                return this.binding;
            }
        }

        public void setAnchor(View view) {
            this.anchorview = view;
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        super.showAsDropDown(view, i, i2, i3);
        this.viewPagerAdapter.setAnchor(view);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        super.showAtLocation(view, i, i2, i3);
        this.viewPagerAdapter.setAnchor(view);
    }

    public void setCurrentItem(int i) {
        this.currentItem = i;
        if (this.binding != null) {
            ViewPagerAdapter viewPagerAdapter = this.viewPagerAdapter;
            if (viewPagerAdapter != null) {
                viewPagerAdapter.notifyItemChanged(i);
            }
            this.binding.viewPager.setCurrentItem(i, false);
        }
    }

    public int getCurrentItem() {
        return this.currentItem;
    }

    public DecodeRecyclerView getDecodeRecyclerView() {
        return this.decodeRecyclerView;
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        TextView textView;
        super.onLocaleChanged();
        List<DecodeParam> list = this.params;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.params.size(); i++) {
            if (this.params.get(i) != null) {
                TabLayout.Tab tabAt = this.binding.tabs.getTabAt(i);
                if (tabAt != null && (textView = (TextView) tabAt.getCustomView()) != null) {
                    textView.setText(R.string.ids_decode1 + i);
                }
                this.params.get(i).notifyPropertyChanged(939);
                this.params.get(i).notifyPropertyChanged(978);
                this.params.get(i).notifyPropertyChanged(334);
                this.params.get(i).notifyPropertyChanged(285);
                this.params.get(i).notifyPropertyChanged(286);
            }
        }
        MessageBus.getInstance().onSyncData(MessageBus.getKey(42, MessageID.MSG_DECODE_EVT_I2C), null);
    }
}
