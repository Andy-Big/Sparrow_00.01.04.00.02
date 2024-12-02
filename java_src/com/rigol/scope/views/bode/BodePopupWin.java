package com.rigol.scope.views.bode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.databinding.Observable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.rigol.scope.R;
import com.rigol.scope.adapters.BodeViewPagerAdapter;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.databinding.PopupviewBodeBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.BodeViewModel;
import com.rigol.scope.views.baseview.BasePopupView;

/* loaded from: classes2.dex */
public class BodePopupWin extends BasePopupView implements TabLayoutMediator.TabConfigurationStrategy, View.OnClickListener {
    private final String BIGGER;
    private final String SMALLER;
    private final int TWOHUNDREDFIVE;
    private BodeParam bodeParam;
    private BodeViewPagerAdapter bodeViewPagerAdapter;
    private PopupviewBodeBinding popupviewBodeBinding;
    private ImageView small;

    public BodePopupWin() {
        super((int) R.style.App_PopupWindow_BODE);
        this.SMALLER = "ic_smaller";
        this.BIGGER = "ic_bigger";
        this.TWOHUNDREDFIVE = 250;
        PopupviewBodeBinding inflate = PopupviewBodeBinding.inflate(LayoutInflater.from(this.context));
        this.popupviewBodeBinding = inflate;
        setContentView(inflate.getRoot());
        this.bodeParam = ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue();
        this.bodeViewPagerAdapter = new BodeViewPagerAdapter(this.context, ViewUtil.getList((int) R.array.msg_bode_table), this);
        this.popupviewBodeBinding.viewPager.setAdapter(this.bodeViewPagerAdapter);
        this.popupviewBodeBinding.setParma(this.bodeParam);
        new TabLayoutMediator(this.popupviewBodeBinding.tabs, this.popupviewBodeBinding.viewPager, this).attach();
        ImageView imageView = (ImageView) this.popupviewBodeBinding.getRoot().findViewById(R.id.small);
        this.small = imageView;
        imageView.setTag("ic_smaller");
        this.small.setVisibility(0);
        this.small.setOnClickListener(this);
        this.small.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_smaller));
        this.bodeParam.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.bode.BodePopupWin.1
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (i == 104) {
                    BodePopupWin.this.popupviewBodeBinding.getRoot().findViewById(R.id.close);
                    if (BodePopupWin.this.bodeParam.getBodeRunStopEnable()) {
                        BodePopupWin.this.setOutsideTouchable(false);
                    } else {
                        BodePopupWin.this.setOutsideTouchable(true);
                    }
                    BodePopupWin.this.update();
                }
            }
        });
    }

    public BodePopupWin(Context context) {
        super(context);
        this.SMALLER = "ic_smaller";
        this.BIGGER = "ic_bigger";
        this.TWOHUNDREDFIVE = 250;
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        if (this.popupviewBodeBinding != null) {
            for (int i = 0; i < this.popupviewBodeBinding.tabs.getTabCount(); i++) {
                TabLayout.Tab tabAt = this.popupviewBodeBinding.tabs.getTabAt(i);
                if (tabAt != null) {
                    onConfigureTab(tabAt, i);
                }
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
    public void onConfigureTab(TabLayout.Tab tab, int i) {
        tab.setText(ViewUtil.getArray(R.array.msg_bode_table).valueAt(i).getStr());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bodeParam.getBodeMinPop()) {
            PopupViewManager.getInstance().dismiss(BodePopupWin.class);
            this.bodeParam.setBodeshow(false);
            PopupViewManager.getInstance().toggle(BodeResultPopuwin.class);
            return;
        }
        PopupViewManager.getInstance().dismiss(BodeResultPopuwin.class);
        this.bodeParam.setBodeshow(true);
        PopupViewManager.getInstance().toggle(BodePopupWin.class);
    }
}
