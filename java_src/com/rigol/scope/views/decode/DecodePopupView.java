package com.rigol.scope.views.decode;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.ActivityUtils;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.rigol.scope.R;
import com.rigol.scope.adapters.DecodeCommonAdapter;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.databinding.PopupviewDecodeBinding;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.DecodeViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class DecodePopupView extends BasePopupView {
    private DecodeCommonAdapter adapter;
    public int anInt;
    private final PopupviewDecodeBinding binding;
    private DecodeParam decodeParam;
    private PanelKeyViewModel panelKeyViewModel;
    private List<DecodeParam> params;

    public DecodeParam getDecodeParam() {
        return this.decodeParam;
    }

    public DecodePopupView() {
        super((int) R.style.App_PopupWindow_Decode);
        this.anInt = 10076;
        PopupviewDecodeBinding inflate = PopupviewDecodeBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        final TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(this.binding.tabs, this.binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.rigol.scope.views.decode.-$$Lambda$DecodePopupView$OhoBVppdKh7hJoGqIU0jJYwtM0Y
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                DecodePopupView.this.lambda$new$0$DecodePopupView(tab, i);
            }
        });
        DecodeViewModel decodeViewModel = (DecodeViewModel) ContextUtil.getAppViewModel(DecodeViewModel.class);
        for (int i = 0; i < decodeViewModel.getValue().size(); i++) {
            decodeViewModel.getValue().get(i).setCurrentItem(i);
        }
        if (decodeViewModel != null) {
            decodeViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.decode.-$$Lambda$DecodePopupView$XLm00mAmjIvO5VbDYLHsxS34f-M
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DecodePopupView.this.lambda$new$1$DecodePopupView(tabLayoutMediator, (ArrayList) obj);
                }
            });
        }
        this.adapter = new DecodeCommonAdapter(this.context, R.layout.adapter_item_popupview_decode);
        if (this.panelKeyViewModel == null) {
            this.panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
        }
        this.adapter.setPanelKeyViewModel(this.panelKeyViewModel);
        this.binding.viewPager.setAdapter(this.adapter);
        this.binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.rigol.scope.views.decode.DecodePopupView.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i2) {
                super.onPageSelected(i2);
                DecodePopupView.this.adapter.setCurrentItem(i2);
                DecodePopupView.this.adapter.settabInt(i2);
                DecodePopupView decodePopupView = DecodePopupView.this;
                decodePopupView.decodeParam = (DecodeParam) decodePopupView.params.get(i2);
                DecodePopupView.this.anInt = i2;
                DecodePopupView.this.setDecodeLight();
                DecodePopupView.this.decodeParam.savePal_clk(ViewUtil.getMappingObject(R.array.msg_decode_pal_clk, DecodePopupView.this.decodeParam.getPal_clk()).getValue());
            }
        });
        this.binding.tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.rigol.scope.views.decode.DecodePopupView.2
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        });
    }

    public /* synthetic */ void lambda$new$0$DecodePopupView(TabLayout.Tab tab, int i) {
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

    public /* synthetic */ void lambda$new$1$DecodePopupView(TabLayoutMediator tabLayoutMediator, ArrayList arrayList) {
        this.params = arrayList;
        this.adapter.setItems(arrayList);
        tabLayoutMediator.detach();
        tabLayoutMediator.attach();
    }

    public void setDecodeLight() {
        PopupViewManager.getInstance().decodeLightType();
    }

    public void notifyData() {
        this.adapter.notifyDataSetChanged();
    }

    public void setCurrentItem(int i) {
        this.binding.viewPager.setCurrentItem(i, false);
    }

    public int getCurrentItem() {
        return this.binding.viewPager.getCurrentItem();
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        super.showAsDropDown(view, i, i2, i3);
        this.adapter.setAnchor(view);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        super.showAtLocation(view, i, i2, i3);
        this.adapter.setAnchor(view);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        List<DecodeParam> list = this.params;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.params.size(); i++) {
            if (this.params.get(i) != null) {
                ((TextView) this.binding.tabs.getTabAt(i).getCustomView()).setText(R.string.ids_decode1 + i);
                this.params.get(i).notifyPropertyChanged(939);
                this.params.get(i).notifyPropertyChanged(978);
                this.params.get(i).notifyPropertyChanged(334);
                this.params.get(i).notifyPropertyChanged(285);
                this.params.get(i).notifyPropertyChanged(286);
            }
        }
    }

    public DecodeCommonAdapter getDecodeCommonAdapter() {
        return this.adapter;
    }
}
