package com.rigol.scope.views.startMenu;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.adapters.OnItemGestureDetectorListener;
import com.rigol.scope.adapters.StartMenuFunctionAdapter;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.OptionParam;
import com.rigol.scope.data.TwoTuple;
import com.rigol.scope.databinding.PopupviewStartMenuBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.KtUtilKt;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.OptionViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.grid.GridSpaceItemDecoration;
import com.rigol.util.ToastUtils;
import java.util.List;
/* loaded from: classes2.dex */
public class StartMenuPopupView extends BasePopupView {
    private final StartMenuFunctionAdapter functionAdapter;
    private OptionParam optionParam;

    /* loaded from: classes2.dex */
    public interface Callback {
        void onItemClick(ServiceEnum.Function function);
    }

    public StartMenuPopupView() {
        super((int) R.style.App_PopupWindow_StartMenu);
        this.optionParam = null;
        PopupviewStartMenuBinding inflate = PopupviewStartMenuBinding.inflate(LayoutInflater.from(this.context));
        setContentView(inflate.getRoot());
        OptionViewModel optionViewModel = (OptionViewModel) ContextUtil.getAppViewModel(OptionViewModel.class);
        if (optionViewModel != null) {
            optionViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.startMenu.-$$Lambda$StartMenuPopupView$uv78CI5M7uhHjEIjzZcufo6HhRI
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    StartMenuPopupView.this.lambda$new$0$StartMenuPopupView((OptionParam) obj);
                }
            });
        }
        final List<MappingObject> list = ViewUtil.getList((int) R.array.msg_app_start_menu);
        if (ViewUtil.serialize == ServiceEnum.ProductSeries.SERIES_800.value1 && list.get(12).getValue() == 49) {
            list.remove(12);
        }
        if (ViewUtil.checkModel() && list.get(12).getValue() == 49) {
            list.remove(12);
        }
        if (ViewUtil.checkModelEDU() && list.get(10).getValue() == 14) {
            list.remove(10);
        }
        final StartMenuItemDecoration startMenuItemDecoration = new StartMenuItemDecoration(2, true);
        inflate.list.addItemDecoration(startMenuItemDecoration);
        StartMenuFunctionAdapter startMenuFunctionAdapter = new StartMenuFunctionAdapter(this.context, list, R.layout.adapter_item_simple2);
        this.functionAdapter = startMenuFunctionAdapter;
        startMenuFunctionAdapter.setOnItemGestureDetectorListener(new OnItemGestureDetectorListener() { // from class: com.rigol.scope.views.startMenu.StartMenuPopupView.1
            @Override // com.rigol.scope.adapters.OnItemGestureDetectorListener
            public boolean onDown(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
                return true;
            }

            @Override // com.rigol.scope.adapters.OnItemGestureDetectorListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
                ServiceEnum.Function functionFromValue1 = ServiceEnum.getFunctionFromValue1(((MappingObject) list.get(i)).getValue());
                if (!KtUtilKt.functionEnable(functionFromValue1, StartMenuPopupView.this.optionParam)) {
                    ToastUtils.showLong(StartMenuPopupView.this.context.getResources().getString(R.string.msg_opt_lic_unusable));
                } else {
                    PopupViewManager.getInstance().isTouchControlLight = false;
                    StartMenuPopupView.this.dismiss();
                    FunctionManager.getInstance().handleItemClick(functionFromValue1);
                }
                return super.onSingleTapConfirmed(motionEvent, view, viewHolder, i);
            }

            @Override // com.rigol.scope.adapters.OnItemGestureDetectorListener
            public void onLongPress(MotionEvent motionEvent, View view, RecyclerView.ViewHolder viewHolder, int i) {
                if (FunctionManager.getInstance().handleItemLongClick(ServiceEnum.getFunctionFromValue1(((MappingObject) list.get(i)).getValue()))) {
                    StartMenuPopupView.this.dismiss();
                }
                super.onLongPress(motionEvent, view, viewHolder, i);
            }
        });
        inflate.list.setAdapter(this.functionAdapter);
        SharedViewModel sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
        if (sharedViewModel != null) {
            sharedViewModel.hasUpdate.observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.startMenu.-$$Lambda$StartMenuPopupView$_w6UfaHTvAR86zYm-AtQMaOeSls
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    StartMenuPopupView.this.lambda$new$1$StartMenuPopupView(list, startMenuItemDecoration, (TwoTuple) obj);
                }
            });
        }
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null) {
            syncDataViewModel.get(36, MessageID.MSG_LICENSE_CHANGED).observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.startMenu.-$$Lambda$StartMenuPopupView$psbdUwrwXPlmLmvLQLSAqGAc2SQ
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    StartMenuPopupView.this.lambda$new$2$StartMenuPopupView(obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$StartMenuPopupView(OptionParam optionParam) {
        this.optionParam = optionParam;
    }

    public /* synthetic */ void lambda$new$1$StartMenuPopupView(List list, StartMenuItemDecoration startMenuItemDecoration, TwoTuple twoTuple) {
        if (twoTuple != null) {
            for (int i = 0; i < list.size(); i++) {
                if (((MappingObject) list.get(i)).getValue() == ServiceEnum.Function.FUN_UPDATE.value1) {
                    startMenuItemDecoration.setUpdateItemPosition(i);
                    startMenuItemDecoration.setShowUpdatePoint(((Boolean) twoTuple.getFirst()).booleanValue());
                    this.functionAdapter.notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    public /* synthetic */ void lambda$new$2$StartMenuPopupView(Object obj) {
        this.functionAdapter.notifyDataSetChanged();
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        if (this.functionAdapter != null) {
            this.functionAdapter.setItems(ViewUtil.getList((int) R.array.msg_app_start_menu));
            this.functionAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class StartMenuItemDecoration extends GridSpaceItemDecoration {
        private static final int UPDATE_POINT_SIZE = 20;
        private boolean isShowUpdatePoint;
        Paint paint;
        private int updateItemPosition;

        public void setUpdateItemPosition(int i) {
            this.updateItemPosition = i;
        }

        public void setShowUpdatePoint(boolean z) {
            this.isShowUpdatePoint = z;
        }

        public StartMenuItemDecoration(int i, boolean z) {
            super(i, z);
            Paint paint = new Paint();
            this.paint = paint;
            paint.setColor(SupportMenu.CATEGORY_MASK);
            this.paint.setAntiAlias(true);
            this.paint.setStrokeWidth(1.0f);
            this.updateItemPosition = 0;
            this.isShowUpdatePoint = false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            int i;
            int i2;
            super.onDrawOver(canvas, recyclerView, state);
            if (this.isShowUpdatePoint && this.updateItemPosition >= 0) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                int spanCount = layoutManager instanceof GridLayoutManager ? ((GridLayoutManager) layoutManager).getSpanCount() : 0;
                if (spanCount == 0 || recyclerView.getChildCount() == 0) {
                    return;
                }
                int i3 = this.updateItemPosition;
                int i4 = i3 / spanCount;
                int i5 = i3 % spanCount;
                int width = recyclerView.getChildAt(0).getWidth();
                int height = recyclerView.getChildAt(0).getHeight();
                if (this.includeEdge) {
                    i = ((i5 + 1) * (this.spacing + width)) - 20;
                    i2 = ((i4 + 1) * this.spacing) + (i4 * height);
                } else {
                    i = ((this.spacing * i5) + ((i5 + 1) * width)) - 20;
                    i2 = (this.spacing + height) * i4;
                }
                canvas.drawOval(i, i2, i + 20, i2 + 20, this.paint);
            }
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    protected View findAnchor() {
        if (ActivityUtils.getTopActivity() instanceof MainActivity) {
            return ((MainActivity) ActivityUtils.getTopActivity()).getSettingsBarFragment().getBinding().starterLayout;
        }
        return null;
    }
}
