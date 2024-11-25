package com.rigol.scope.views.math;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.databinding.MathRecyclerviewBindingImpl;
import com.rigol.scope.databinding.PopupviewMathBinding;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import java.util.List;
import java.util.function.Consumer;
/* loaded from: classes2.dex */
public class MathPopupView extends BasePopupView {
    private final PopupviewMathBinding binding;
    private int currentItem;
    private MathParam mathParam;
    private MathRecyclerView mathRecyclerView;
    private List<MathParam> params;
    ViewPagerAdapter viewPagerAdapter;

    public MathParam getMathParam() {
        return this.mathParam;
    }

    public MathPopupView() {
        super((int) R.style.App_PopupWindow_Math);
        this.viewPagerAdapter = new ViewPagerAdapter();
        MathViewModel mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
        if (mathViewModel != null) {
            mathViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer<List<MathParam>>() { // from class: com.rigol.scope.views.math.MathPopupView.1
                @Override // androidx.lifecycle.Observer
                public void onChanged(List<MathParam> list) {
                    MathPopupView.this.params = list;
                    MathPopupView.this.viewPagerAdapter.setParams(MathPopupView.this.params);
                    MathPopupView.this.viewPagerAdapter.notifyDataSetChanged();
                }
            });
        }
        PopupviewMathBinding inflate = PopupviewMathBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        this.viewPagerAdapter.setPopupviewMathBinding(this.binding);
        this.binding.viewPager.setAdapter(this.viewPagerAdapter);
        this.binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.rigol.scope.views.math.MathPopupView.2
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                MathPopupView.this.binding.tabs.selectTab(MathPopupView.this.binding.tabs.getTabAt(i));
                MathPopupView.this.setMathLight(i);
            }
        });
        new TabLayoutMediator(this.binding.tabs, this.binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.rigol.scope.views.math.-$$Lambda$MathPopupView$vf8q4bvZI5aRFmJX7GKLIQytlAQ
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                MathPopupView.this.lambda$new$0$MathPopupView(tab, i);
            }
        }).attach();
    }

    public /* synthetic */ void lambda$new$0$MathPopupView(TabLayout.Tab tab, int i) {
        TextView textView;
        tab.setCustomView(R.layout.adapter_item_tab);
        MathParam mathParam = this.params.get(i);
        this.mathParam = mathParam;
        if (mathParam == null || (textView = (TextView) tab.getCustomView()) == null) {
            return;
        }
        textView.setText(mathParam.getTitle());
        textView.setTextColor(ColorUtil.getColor(this.context, mathParam.getServiceId()));
    }

    public void setMathLight(int i) {
        List<MathParam> list = this.params;
        if (list == null || list.size() < i || i < 0) {
            return;
        }
        this.mathParam = this.params.get(i);
        PopupViewManager.getInstance().setLight(this.mathParam.getAorBManager());
        FunctionManager.getInstance().setFlexKnobEnum(ServiceEnum.Function.FUN_MATH, i, false);
    }

    /* loaded from: classes2.dex */
    public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerHolder> {
        View anchorview;
        MathRecyclerviewBindingImpl binding;
        List<MathParam> params;
        PopupviewMathBinding popupviewMathBinding;

        public ViewPagerAdapter() {
        }

        public void setParams(List<MathParam> list) {
            this.params = list;
        }

        public void setPopupviewMathBinding(PopupviewMathBinding popupviewMathBinding) {
            this.popupviewMathBinding = popupviewMathBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewPagerHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            this.binding = (MathRecyclerviewBindingImpl) MathRecyclerviewBindingImpl.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            return new ViewPagerHolder(this.binding);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewPagerHolder viewPagerHolder, int i) {
            MathPopupView.this.mathRecyclerView = new MathRecyclerView(viewPagerHolder.itemView.getContext(), this.params.get(i), this.anchorview, viewPagerHolder.getBinding(), this.popupviewMathBinding, viewPagerHolder);
            LogUtils.e("mathArithAdapter", "mathArithAdapter");
            MathPopupView.this.mathRecyclerView.mathShowView();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<MathParam> list = this.params;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* loaded from: classes2.dex */
        public class ViewPagerHolder extends RecyclerView.ViewHolder {
            private MathRecyclerviewBindingImpl binding;

            public ViewPagerHolder(MathRecyclerviewBindingImpl mathRecyclerviewBindingImpl) {
                super(mathRecyclerviewBindingImpl.getRoot());
                this.binding = mathRecyclerviewBindingImpl;
            }

            public MathRecyclerviewBindingImpl getBinding() {
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
        PopupviewMathBinding popupviewMathBinding = this.binding;
        if (popupviewMathBinding != null) {
            popupviewMathBinding.viewPager.setCurrentItem(i, false);
        }
    }

    public int getCurrentItem() {
        return this.currentItem;
    }

    public MathRecyclerView getMathRecyclerView() {
        return this.mathRecyclerView;
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        List<MathParam> list = this.params;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.params.forEach(new Consumer() { // from class: com.rigol.scope.views.math.-$$Lambda$KpjLTuglpqlKiKcLNMXQyiv1WZ8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((MathParam) obj).updateScaleString();
            }
        });
    }
}
