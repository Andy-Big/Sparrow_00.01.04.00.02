package com.rigol.scope.views.baseview;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.SearchParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.SearchViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LineView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/rigol/scope/views/baseview/SearchThresholdLine;", "Lcom/rigol/scope/views/baseview/LineView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isFirst", "", "searchParam", "Lcom/rigol/scope/data/SearchParam;", "sharedParam", "Lcom/rigol/scope/data/SharedParam;", "verticalParams", "", "Lcom/rigol/scope/data/VerticalParam;", "getVerticalParams", "()Ljava/util/List;", "setVerticalParams", "(Ljava/util/List;)V", "setPosition", "", "chanValue", "", "thres", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class SearchThresholdLine extends LineView {
    private boolean isFirst;
    private SearchParam searchParam;
    private SharedParam sharedParam;
    private List<VerticalParam> verticalParams;

    public SearchThresholdLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LiveData<SearchParam> liveData;
        LiveData<SharedParam> liveData2;
        LiveData<ArrayList<VerticalParam>> liveData3;
        VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        if (verticalViewModel != null && (liveData3 = verticalViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            liveData3.observe((LifecycleOwner) topActivity, new Observer<ArrayList<VerticalParam>>() { // from class: com.rigol.scope.views.baseview.SearchThresholdLine.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.lifecycle.Observer
                public final void onChanged(ArrayList<VerticalParam> arrayList) {
                    SearchThresholdLine.this.setVerticalParams(arrayList);
                }
            });
        }
        SharedViewModel sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
        if (sharedViewModel != null && (liveData2 = sharedViewModel.getLiveData()) != null) {
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            liveData2.observe((LifecycleOwner) topActivity2, new Observer<SharedParam>() { // from class: com.rigol.scope.views.baseview.SearchThresholdLine.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.lifecycle.Observer
                public final void onChanged(SharedParam sharedParam) {
                    SearchThresholdLine searchThresholdLine = SearchThresholdLine.this;
                    Intrinsics.checkNotNullExpressionValue(sharedParam, "sharedParam");
                    searchThresholdLine.sharedParam = sharedParam;
                }
            });
        }
        SearchViewModel searchViewModel = (SearchViewModel) ContextUtil.getAppViewModel(SearchViewModel.class);
        if (searchViewModel != null && (liveData = searchViewModel.getLiveData()) != null) {
            Activity topActivity3 = ActivityUtils.getTopActivity();
            if (topActivity3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            liveData.observe((LifecycleOwner) topActivity3, new Observer<SearchParam>() { // from class: com.rigol.scope.views.baseview.SearchThresholdLine.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.lifecycle.Observer
                public final void onChanged(SearchParam searchParam) {
                    SearchThresholdLine searchThresholdLine = SearchThresholdLine.this;
                    Intrinsics.checkNotNullExpressionValue(searchParam, "searchParam");
                    searchThresholdLine.searchParam = searchParam;
                }
            });
        }
        setId(View.generateViewId());
        setOrientation(0);
        setLinePathEffect(OrientationViewKt.getDEFAULT_DASH_PATH_EFFECT());
        setVisibility(8);
    }

    public static final /* synthetic */ SearchParam access$getSearchParam$p(SearchThresholdLine searchThresholdLine) {
        SearchParam searchParam = searchThresholdLine.searchParam;
        if (searchParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchParam");
        }
        return searchParam;
    }

    public static final /* synthetic */ SharedParam access$getSharedParam$p(SearchThresholdLine searchThresholdLine) {
        SharedParam sharedParam = searchThresholdLine.sharedParam;
        if (sharedParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedParam");
        }
        return sharedParam;
    }

    public final List<VerticalParam> getVerticalParams() {
        return this.verticalParams;
    }

    public final void setVerticalParams(List<VerticalParam> list) {
        this.verticalParams = list;
    }

    public final void setPosition(int i, long j) {
        if (getParent() == null) {
            return;
        }
        int i2 = i - ServiceEnum.Chan.chan1.value1;
        List<VerticalParam> list = this.verticalParams;
        if (list == null || i2 < 0) {
            return;
        }
        Intrinsics.checkNotNull(list);
        if (i2 >= list.size()) {
            return;
        }
        List<VerticalParam> list2 = this.verticalParams;
        Intrinsics.checkNotNull(list2);
        VerticalParam verticalParam = list2.get(i2);
        if (getVisibility() == 8 || getVisibility() == 4) {
            setVisibility(0);
        }
        Context context = getContext();
        if (context != null) {
            setLineColor(ColorUtil.getColor(context, verticalParam.getServiceId()));
        }
        float valuePercent = ViewUtil.getValuePercent(verticalParam, j);
        ViewParent parent = getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        setPosition((int) (valuePercent * ((ViewGroup) parent).getHeight()));
        if (this.isFirst) {
            showLine();
        } else {
            this.isFirst = true;
        }
        hideLineDelay(3000L);
    }
}
