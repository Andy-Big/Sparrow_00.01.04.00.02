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
import com.rigol.scope.data.MathParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LineView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082.¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/rigol/scope/views/baseview/MathThresholdLine;", "Lcom/rigol/scope/views/baseview/LineView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mathParams", "", "Lcom/rigol/scope/data/MathParam;", "verticalParams", "Lcom/rigol/scope/data/VerticalParam;", "getVerticalParams", "()Ljava/util/List;", "setVerticalParams", "(Ljava/util/List;)V", "setPosition", "", "chanValue", "", "thres", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class MathThresholdLine extends LineView {
    private List<? extends MathParam> mathParams;
    private List<VerticalParam> verticalParams;

    public MathThresholdLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LiveData<ArrayList<MathParam>> liveData;
        LiveData<ArrayList<VerticalParam>> liveData2;
        VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        if (verticalViewModel != null && (liveData2 = verticalViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            liveData2.observe((LifecycleOwner) topActivity, new Observer<ArrayList<VerticalParam>>() { // from class: com.rigol.scope.views.baseview.MathThresholdLine.1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(ArrayList<VerticalParam> arrayList) {
                    MathThresholdLine.this.setVerticalParams(arrayList);
                }
            });
        }
        MathViewModel mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
        if (mathViewModel != null && (liveData = mathViewModel.getLiveData()) != null) {
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            liveData.observe((LifecycleOwner) topActivity2, new Observer<ArrayList<MathParam>>() { // from class: com.rigol.scope.views.baseview.MathThresholdLine.2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(ArrayList<MathParam> mathParams) {
                    MathThresholdLine mathThresholdLine = MathThresholdLine.this;
                    Intrinsics.checkNotNullExpressionValue(mathParams, "mathParams");
                    mathThresholdLine.mathParams = mathParams;
                }
            });
        }
        setId(View.generateViewId());
        setOrientation(0);
        setLinePathEffect(OrientationViewKt.getDEFAULT_DASH_PATH_EFFECT());
        setVisibility(8);
    }

    public static final /* synthetic */ List access$getMathParams$p(MathThresholdLine mathThresholdLine) {
        List<? extends MathParam> list = mathThresholdLine.mathParams;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mathParams");
        }
        return list;
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
        showLine();
        hideLineDelay(3000L);
    }
}
