package com.rigol.scope.views.spinner;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.adapters.BaseAdapter;
import com.rigol.scope.databinding.PopupviewSpinnerBinding;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.ViewStateViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.grid.GridSpaceItemDecoration;
/* loaded from: classes2.dex */
public class PopupSpinner extends BasePopupView {
    private static final int DEFAULT_MAX_ROW_COUNT = 7;
    private final PopupviewSpinnerBinding binding;
    private ViewStateViewModel viewStateViewModel;

    /* loaded from: classes2.dex */
    public interface OnItemClickListener<T> {
        void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i, T t);
    }

    public PopupSpinner() {
        this(7);
    }

    public PopupSpinner(int i) {
        super((int) R.style.App_PopupWindow_Spinner);
        PopupviewSpinnerBinding inflate = PopupviewSpinnerBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        ViewStateViewModel viewStateViewModel = ViewUtil.getViewStateViewModel();
        this.viewStateViewModel = viewStateViewModel;
        viewStateViewModel.getViewState().postValue(2);
        RecyclerView.LayoutManager layoutManager = this.binding.recyclerView.getLayoutManager();
        if (i <= 0 || !(layoutManager instanceof GridLayoutManager)) {
            return;
        }
        ((GridLayoutManager) layoutManager).setSpanCount(i);
    }

    public void setAdapter(BaseAdapter<?> baseAdapter) {
        this.binding.recyclerView.addItemDecoration(new GridSpaceItemDecoration(5, false));
        this.binding.recyclerView.setAdapter(baseAdapter);
        RecyclerView.LayoutManager layoutManager = this.binding.recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            int itemCount = baseAdapter.getItemCount();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            int spanCount = gridLayoutManager.getSpanCount();
            if (itemCount <= spanCount) {
                gridLayoutManager.setSpanCount(baseAdapter.getItemCount());
                return;
            }
            int i = itemCount / spanCount;
            if (itemCount % spanCount != 0) {
                i++;
            }
            int i2 = itemCount / i;
            if (itemCount % i != 0) {
                i2++;
            }
            gridLayoutManager.setSpanCount(i2);
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void showAsDropDown(View view, View view2, int i, int i2, int i3) {
        int i4;
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity instanceof MainActivity) {
            FragmentContainerView fragmentContainerView = ((MainActivity) topActivity).getBinding().waveform;
            int[] iArr = new int[2];
            fragmentContainerView.getLocationOnScreen(iArr);
            int width = iArr[0] + fragmentContainerView.getWidth();
            int height = iArr[1] + fragmentContainerView.getHeight();
            int[] iArr2 = new int[2];
            view2.getLocationOnScreen(iArr2);
            int i5 = iArr2[0];
            view2.getWidth();
            RecyclerView.LayoutManager layoutManager = this.binding.recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                int spanCount = gridLayoutManager.getSpanCount();
                if (this.binding.recyclerView.getAdapter() != null) {
                    int itemCount = this.binding.recyclerView.getAdapter().getItemCount();
                    if (itemCount % spanCount == 0) {
                        i4 = itemCount / spanCount;
                    } else {
                        i4 = (itemCount / spanCount) + 1;
                        spanCount++;
                    }
                    int width2 = getWidth();
                    int height2 = getHeight();
                    if (width2 <= 0) {
                        getContentView().measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    }
                    if (width2 <= 0) {
                        width2 = getContentView().getMeasuredWidth();
                    }
                    if (height2 <= 0) {
                        height2 = getContentView().getMeasuredHeight();
                    }
                    int width3 = (view2.getWidth() * i4) + ((i4 - 1) * 5);
                    int height3 = (view2.getHeight() * spanCount) + ((spanCount - 1) * 5);
                    if (width2 >= width3) {
                        width3 = width2 + 2;
                    }
                    setWidth(width3 + 5);
                    if (height2 < height3) {
                        height2 = height3;
                    }
                    int i6 = iArr2[0] + width3;
                    int i7 = iArr2[1] + height2;
                    if (i6 > width) {
                        gridLayoutManager.setReverseLayout(true);
                        Log.d("charles", "showAsDropDown: 000" + i7 + ";" + height);
                        if (i7 > height) {
                            Log.d("charles", "showAsDropDown: 111");
                            super.showAsDropDown(view, view2, (-width3) + view2.getWidth(), ((-height2) - view2.getHeight()) + 50, i3);
                            return;
                        }
                        super.showAsDropDown(view, view2, (-width3) + view2.getWidth(), ((-height2) - view2.getHeight()) + 50, i3);
                        return;
                    } else if (i7 > height) {
                        Log.d("charles", "showAsDropDown: 222");
                        super.showAsDropDown(view, view2, i, ((-height2) - view2.getHeight()) + 50, i3);
                        return;
                    }
                }
            }
        }
        super.showAsDropDown(view, view2, i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onShow() {
        super.onShow();
        this.viewStateViewModel.getIsFirstShow().setValue(true);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        super.onDismiss();
        if (this.refView != null) {
            this.viewStateViewModel.getViewState().setValue(1);
            this.viewStateViewModel.resetIsFirstShow();
            this.refView.removeOnAttachStateChangeListener(this.onAttachStateChangeListener);
        }
    }
}
