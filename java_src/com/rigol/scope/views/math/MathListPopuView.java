package com.rigol.scope.views.math;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.BaseAdapter;
import com.rigol.scope.adapters.BaseViewHolder;
import com.rigol.scope.adapters.OnItemGestureDetectorListener;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.databinding.AdapterItemMathBinding;
import com.rigol.scope.databinding.PopupMathListBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.baseview.BaseSimpleCallback;
import com.rigol.scope.views.grid.GridSpaceItemDecoration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class MathListPopuView extends BasePopupView {
    private final PopupMathListBinding binding;
    private MathParam mathParam;
    private MathRecyclerView mathRecyclerView;
    private MathViewModel mathViewModel;
    private List<MathParam> params;

    public MathParam getMathParam() {
        return this.mathParam;
    }

    public MathListPopuView() {
        super((int) R.style.App_PopupWindow_ListMath);
        this.binding = PopupMathListBinding.inflate(LayoutInflater.from(this.context));
        this.mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
        setContentView(this.binding.getRoot());
        loadMathInfo();
    }

    private void loadMathInfo() {
        final BaseAdapter<List<MathParam>> baseAdapter = new BaseAdapter<List<MathParam>>(this.context, R.layout.adapter_item_math) { // from class: com.rigol.scope.views.math.MathListPopuView.1
            @Override // com.rigol.scope.adapters.BaseAdapter
            protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<MathParam> list, int i) {
                AdapterItemMathBinding adapterItemMathBinding = (AdapterItemMathBinding) baseViewHolder.getBinding();
                MathParam mathParam = list.get(i);
                if (mathParam != null) {
                    adapterItemMathBinding.setItemPosition(Integer.valueOf(i));
                    adapterItemMathBinding.setParam(mathParam);
                }
                adapterItemMathBinding.getRoot().setTag(MathListPopuView.class.getSimpleName());
            }

            @Override // com.rigol.scope.adapters.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup, int i) {
                BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup, i);
                onCreateViewHolder.getBinding().getRoot();
                return onCreateViewHolder;
            }
        };
        ViewUtil.setSupportsChangeAnimations(this.binding.otherLayout, false);
        this.binding.otherLayout.addItemDecoration(new GridSpaceItemDecoration(5, true));
        this.binding.otherLayout.setAdapter(baseAdapter);
        baseAdapter.setOnItemGestureDetectorListener(new OnItemGestureDetectorListener() { // from class: com.rigol.scope.views.math.MathListPopuView.2
            @Override // com.rigol.scope.adapters.OnItemGestureDetectorListener
            public boolean onDoubleTap(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
                return true;
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
            @Override // com.rigol.scope.adapters.OnItemGestureDetectorListener
            public void onLongPress(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
                ((MathParam) baseAdapter.getItems().get(i)).saveStatus(false);
                if (PopupViewManager.getInstance().isShowing(MathPopupView.class)) {
                    PopupViewManager.getInstance().get(MathPopupView.class).dismiss();
                }
                baseAdapter.notifyDataSetChanged();
            }

            /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List] */
            @Override // com.rigol.scope.adapters.OnItemGestureDetectorListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
                ?? items = baseAdapter.getItems();
                if (i >= 0) {
                    if (((MathParam) items.get(i)).getStatus()) {
                        if (PopupViewManager.getInstance().isShowing(MathPopupView.class)) {
                            if (MathListPopuView.this.getMathCurrentItem() != i) {
                                MathListPopuView.this.setMathCurrentItem(i);
                            } else {
                                PopupViewManager.getInstance().get(MathPopupView.class).dismiss();
                                ((MathParam) items.get(i)).saveStatus(false);
                            }
                        } else {
                            MathListPopuView.this.dismiss();
                            MathListPopuView.this.showMathPopupView(i);
                        }
                    } else {
                        ((MathParam) items.get(i)).saveStatus(true);
                        MathListPopuView.this.dismiss();
                    }
                    baseAdapter.notifyDataSetChanged();
                }
                return true;
            }
        });
        new ItemTouchHelper(new BaseSimpleCallback(0, 2) { // from class: com.rigol.scope.views.math.MathListPopuView.3
            /* JADX WARN: Type inference failed for: r3v4, types: [java.util.List] */
            @Override // com.rigol.scope.views.baseview.BaseSimpleCallback, androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
                super.onSwiped(viewHolder, i);
                int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
                if (PopupViewManager.getInstance().isShowing(MathPopupView.class)) {
                    PopupViewManager.getInstance().get(MathPopupView.class).dismiss();
                }
                ((MathParam) baseAdapter.getItems().get(bindingAdapterPosition)).saveStatus(false);
                baseAdapter.notifyDataSetChanged();
            }
        }).attachToRecyclerView(this.binding.otherLayout);
        this.mathViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.math.-$$Lambda$MathListPopuView$JMGquD5o2T9fdB2E8IUDUIndM1Y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MathListPopuView.lambda$loadMathInfo$0(BaseAdapter.this, (ArrayList) obj);
            }
        });
        PopupViewManager.getInstance().add(MathPopupView.class, new MathPopupView());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$loadMathInfo$0(BaseAdapter baseAdapter, ArrayList arrayList) {
        baseAdapter.setItems(arrayList);
        baseAdapter.notifyDataSetChanged();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            MathParam mathParam = (MathParam) it.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMathPopupView(int i) {
        BasePopupView basePopupView = PopupViewManager.getInstance().get(MathPopupView.class);
        if (basePopupView instanceof MathPopupView) {
            ((MathPopupView) basePopupView).setCurrentItem(i);
        }
        basePopupView.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMathCurrentItem() {
        BasePopupView basePopupView = PopupViewManager.getInstance().get(MathPopupView.class);
        if (basePopupView instanceof MathPopupView) {
            return ((MathPopupView) basePopupView).getCurrentItem();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMathCurrentItem(int i) {
        BasePopupView basePopupView = PopupViewManager.getInstance().get(MathPopupView.class);
        if (basePopupView instanceof MathPopupView) {
            ((MathPopupView) basePopupView).setCurrentItem(i);
        }
    }
}
