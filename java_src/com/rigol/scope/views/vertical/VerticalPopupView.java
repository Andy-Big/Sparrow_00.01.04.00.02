package com.rigol.scope.views.vertical;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.ActivityUtils;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.rigol.scope.R;
import com.rigol.scope.adapters.VerticalViewPagerAdapter;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.databinding.PopupviewVerticalBinding;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import java.util.List;
/* loaded from: classes2.dex */
public class VerticalPopupView extends BasePopupView {
    private final PopupviewVerticalBinding binding;
    private PanelKeyViewModel panelKeyViewModel;
    private List<VerticalParam> params;
    private final VerticalViewPagerAdapter viewPagerAdapter;

    public PopupviewVerticalBinding getBinding() {
        return this.binding;
    }

    public VerticalViewPagerAdapter getViewPagerAdapter() {
        return this.viewPagerAdapter;
    }

    public VerticalPopupView() {
        super((int) R.style.App_PopupWindow_Vertical);
        VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        PopupviewVerticalBinding inflate = PopupviewVerticalBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        if (verticalViewModel != null) {
            verticalViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer<List<VerticalParam>>() { // from class: com.rigol.scope.views.vertical.VerticalPopupView.1
                @Override // androidx.lifecycle.Observer
                public void onChanged(List<VerticalParam> list) {
                    VerticalPopupView.this.params = list;
                    if (VerticalPopupView.this.viewPagerAdapter != null) {
                        VerticalPopupView.this.viewPagerAdapter.setItems(VerticalPopupView.this.params);
                        VerticalPopupView.this.viewPagerAdapter.notifyDataSetChanged();
                    }
                }
            });
        }
        this.viewPagerAdapter = new VerticalViewPagerAdapter(this.context, R.layout.adapter_item_popupview_vertical, this.anchor, this.binding);
        if (this.panelKeyViewModel == null) {
            this.panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
        }
        this.viewPagerAdapter.setPanelKeyViewModel(this.panelKeyViewModel);
        this.binding.viewPager.setAdapter(this.viewPagerAdapter);
        new TabLayoutMediator(this.binding.tabs, this.binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.rigol.scope.views.vertical.-$$Lambda$VerticalPopupView$80pVJcPKk7VnCawUj0X3JlIYQ3g
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                VerticalPopupView.this.lambda$new$0$VerticalPopupView(tab, i);
            }
        }).attach();
        this.binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.rigol.scope.views.vertical.VerticalPopupView.2
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                VerticalPopupView.this.viewPagerAdapter.setCurrentItemForce(i);
            }
        });
    }

    public /* synthetic */ void lambda$new$0$VerticalPopupView(TabLayout.Tab tab, int i) {
        TextView textView;
        tab.setCustomView(R.layout.adapter_item_tab);
        VerticalParam verticalParam = this.params.get(i);
        if (verticalParam == null || (textView = (TextView) tab.getCustomView()) == null) {
            return;
        }
        textView.setText("CH" + verticalParam.getTitle());
        int color = ColorUtil.getColor(this.context, verticalParam.getServiceId());
        if (verticalParam.getServiceId() == 4) {
            textView.setTextColor(ContextCompat.getColor(this.context, R.color.ch4));
        } else {
            textView.setTextColor(color);
        }
    }

    public void verticalPopupViewLight() {
        VerticalParam verticalParam = this.params.get(this.binding.tabs.getSelectedTabPosition());
        if (verticalParam.getStatus() == ServiceEnum.enChanStatus.CHAN_ACTIVE || verticalParam.getStatus() == ServiceEnum.enChanStatus.CHAN_ON) {
            PopupViewManager.getInstance().setLight(this.viewPagerAdapter.getAorBManager());
        } else {
            PopupViewManager.getInstance().closeAllLight();
        }
    }

    public void setCurrentItem(int i) {
        this.binding.viewPager.setCurrentItem(i, false);
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
}
