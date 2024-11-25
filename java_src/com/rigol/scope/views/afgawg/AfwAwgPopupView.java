package com.rigol.scope.views.afgawg;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.rigol.scope.R;
import com.rigol.scope.adapters.AfgAwgViewPagerAdapter;
import com.rigol.scope.databinding.PopupviewAfgAwgBinding;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.baseview.BasePopupView;
/* loaded from: classes2.dex */
public class AfwAwgPopupView extends BasePopupView implements TabLayoutMediator.TabConfigurationStrategy {
    AfgAwgViewPagerAdapter afgAwgViewPagerAdapter;
    PopupviewAfgAwgBinding popupviewAfgAwgBinding;

    public AfwAwgPopupView() {
        super((int) R.style.App_PopupWindow_AFG);
        PopupviewAfgAwgBinding inflate = PopupviewAfgAwgBinding.inflate(LayoutInflater.from(this.context));
        this.popupviewAfgAwgBinding = inflate;
        setContentView(inflate.getRoot());
        this.afgAwgViewPagerAdapter = new AfgAwgViewPagerAdapter(this.context, ViewUtil.getList((int) R.array.msg_afg_wave_mod_signal_occurs), this);
        this.popupviewAfgAwgBinding.viewPager.setAdapter(this.afgAwgViewPagerAdapter);
        new TabLayoutMediator(this.popupviewAfgAwgBinding.tabs, this.popupviewAfgAwgBinding.viewPager, this).attach();
        this.popupviewAfgAwgBinding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.rigol.scope.views.afgawg.AfwAwgPopupView.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                if (i == 0) {
                    AfwAwgPopupView.this.afgAwgViewPagerAdapter.awgBasicDelegate.setIsMove(false);
                    AfwAwgPopupView.this.afgAwgViewPagerAdapter.afgBasicDelegate.setIsMove(true);
                    return;
                }
                AfwAwgPopupView.this.afgAwgViewPagerAdapter.awgBasicDelegate.setIsMove(true);
                AfwAwgPopupView.this.afgAwgViewPagerAdapter.afgBasicDelegate.setIsMove(false);
            }
        });
    }

    public AfwAwgPopupView(Context context) {
        super(context);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        if (this.popupviewAfgAwgBinding != null) {
            for (int i = 0; i < this.popupviewAfgAwgBinding.tabs.getTabCount(); i++) {
                TabLayout.Tab tabAt = this.popupviewAfgAwgBinding.tabs.getTabAt(i);
                if (tabAt != null) {
                    onConfigureTab(tabAt, i);
                }
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
    public void onConfigureTab(TabLayout.Tab tab, int i) {
        tab.setText(ViewUtil.getArray(R.array.msg_afg_wave_mod_signal_occurs).valueAt(i).getStr());
    }
}
