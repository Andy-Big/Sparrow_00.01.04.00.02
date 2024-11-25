package com.rigol.scope.views.la;

import android.content.Context;
import android.view.LayoutInflater;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.rigol.scope.R;
import com.rigol.scope.adapters.LaViewPagerAdapter;
import com.rigol.scope.databinding.PopupviewLaBinding;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.baseview.BasePopupView;
/* loaded from: classes2.dex */
public class LapopupView extends BasePopupView implements TabLayoutMediator.TabConfigurationStrategy {
    private LaViewPagerAdapter laViewPagerAdapter;
    private PopupviewLaBinding popupviewLaBinding;

    public LapopupView() {
        super((int) R.style.App_PopupWindow_LA);
        PopupviewLaBinding inflate = PopupviewLaBinding.inflate(LayoutInflater.from(this.context));
        this.popupviewLaBinding = inflate;
        setContentView(inflate.getRoot());
        this.laViewPagerAdapter = new LaViewPagerAdapter(this.context, ViewUtil.getList((int) R.array.msg_la_settype), this);
        this.popupviewLaBinding.viewPager.setAdapter(this.laViewPagerAdapter);
        new TabLayoutMediator(this.popupviewLaBinding.tabs, this.popupviewLaBinding.viewPager, this).attach();
    }

    public LapopupView(Context context) {
        super(context);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        if (this.popupviewLaBinding != null) {
            for (int i = 0; i < this.popupviewLaBinding.tabs.getTabCount(); i++) {
                TabLayout.Tab tabAt = this.popupviewLaBinding.tabs.getTabAt(i);
                if (tabAt != null) {
                    onConfigureTab(tabAt, i);
                }
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
    public void onConfigureTab(TabLayout.Tab tab, int i) {
        tab.setText(ViewUtil.getArray(R.array.msg_la_settype).valueAt(i).getStr());
    }
}
