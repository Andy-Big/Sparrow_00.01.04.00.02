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
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.MeasureSettingViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.views.baseview.OrientationView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LineView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/rigol/scope/views/baseview/MeasureLowThresLine;", "Lcom/rigol/scope/views/baseview/LineView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "measureSettingParam", "Lcom/rigol/scope/data/MeasureSettingParam;", "sharedParam", "Lcom/rigol/scope/data/SharedParam;", "verticalParams", "", "Lcom/rigol/scope/data/VerticalParam;", "getVerticalParams", "()Ljava/util/List;", "setVerticalParams", "(Ljava/util/List;)V", "setPosition", "", "chanValue", "", "thres", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class MeasureLowThresLine extends LineView {
    private MeasureSettingParam measureSettingParam;
    private SharedParam sharedParam;
    private List<VerticalParam> verticalParams;

    public MeasureLowThresLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LiveData<MeasureSettingParam> liveData;
        LiveData<SharedParam> liveData2;
        LiveData<ArrayList<VerticalParam>> liveData3;
        VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        if (verticalViewModel != null && (liveData3 = verticalViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                liveData3.observe((LifecycleOwner) topActivity, new Observer<ArrayList<VerticalParam>>() { // from class: com.rigol.scope.views.baseview.MeasureLowThresLine.1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(ArrayList<VerticalParam> arrayList) {
                        MeasureLowThresLine.this.setVerticalParams(arrayList);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        SharedViewModel sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
        if (sharedViewModel != null && (liveData2 = sharedViewModel.getLiveData()) != null) {
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 != null) {
                liveData2.observe((LifecycleOwner) topActivity2, new Observer<SharedParam>() { // from class: com.rigol.scope.views.baseview.MeasureLowThresLine.2
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(SharedParam sharedParam) {
                        MeasureLowThresLine measureLowThresLine = MeasureLowThresLine.this;
                        Intrinsics.checkNotNullExpressionValue(sharedParam, "sharedParam");
                        measureLowThresLine.sharedParam = sharedParam;
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        MeasureSettingViewModel measureSettingViewModel = (MeasureSettingViewModel) ContextUtil.getAppViewModel(MeasureSettingViewModel.class);
        if (measureSettingViewModel != null && (liveData = measureSettingViewModel.getLiveData()) != null) {
            Activity topActivity3 = ActivityUtils.getTopActivity();
            if (topActivity3 != null) {
                liveData.observe((LifecycleOwner) topActivity3, new Observer<MeasureSettingParam>() { // from class: com.rigol.scope.views.baseview.MeasureLowThresLine.3
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(MeasureSettingParam measureSettingParam) {
                        MeasureLowThresLine measureLowThresLine = MeasureLowThresLine.this;
                        Intrinsics.checkNotNullExpressionValue(measureSettingParam, "measureSettingParam");
                        measureLowThresLine.measureSettingParam = measureSettingParam;
                        OrientationView.Companion companion = OrientationView.Companion;
                        companion.setStrThresholdLow(String.valueOf(MeasureLowThresLine.access$getMeasureSettingParam$p(MeasureLowThresLine.this).getThresholdLow()) + "%");
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        setId(View.generateViewId());
        setOrientation(0);
        setLinePathEffect(OrientationViewKt.getDEFAULT_DASH_PATH_EFFECT());
        setVisibility(8);
    }

    public static final /* synthetic */ MeasureSettingParam access$getMeasureSettingParam$p(MeasureLowThresLine measureLowThresLine) {
        MeasureSettingParam measureSettingParam = measureLowThresLine.measureSettingParam;
        if (measureSettingParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("measureSettingParam");
        }
        return measureSettingParam;
    }

    public static final /* synthetic */ SharedParam access$getSharedParam$p(MeasureLowThresLine measureLowThresLine) {
        SharedParam sharedParam = measureLowThresLine.sharedParam;
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
        MeasureSettingParam measureSettingParam = this.measureSettingParam;
        if (measureSettingParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("measureSettingParam");
        }
        if (measureSettingParam.getThresholdType() == ServiceEnum.ThreType.TH_TYPE_ABS) {
            OrientationView.Companion companion = OrientationView.Companion;
            UnitFormat newBuilder = UnitFormat.newBuilder(UnitFormat.SI.NANO);
            MeasureSettingParam measureSettingParam2 = this.measureSettingParam;
            if (measureSettingParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("measureSettingParam");
            }
            String convert = newBuilder.convert(measureSettingParam2.getThresholdLow(), ServiceEnum.Unit.Unit_V);
            Intrinsics.checkNotNullExpressionValue(convert, "UnitFormat.newBuilder( U…ServiceEnum.Unit.Unit_V )");
            companion.setStrThresholdLow(convert);
            MeasureSettingParam measureSettingParam3 = this.measureSettingParam;
            if (measureSettingParam3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("measureSettingParam");
            }
            if (measureSettingParam3.getShowThresLine()) {
                return;
            }
            hideLineDelay(3000L);
            return;
        }
        MeasureSettingParam measureSettingParam4 = this.measureSettingParam;
        if (measureSettingParam4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("measureSettingParam");
        }
        if (measureSettingParam4.getThresholdType() == ServiceEnum.ThreType.TH_TYPE_PER) {
            OrientationView.Companion companion2 = OrientationView.Companion;
            StringBuilder sb = new StringBuilder();
            MeasureSettingParam measureSettingParam5 = this.measureSettingParam;
            if (measureSettingParam5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("measureSettingParam");
            }
            sb.append(String.valueOf(measureSettingParam5.getThresholdLow()));
            sb.append("%");
            companion2.setStrThresholdLow(sb.toString());
            MeasureSettingParam measureSettingParam6 = this.measureSettingParam;
            if (measureSettingParam6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("measureSettingParam");
            }
            if (measureSettingParam6.getShowThresLine()) {
                return;
            }
            hideLineDelay(3000L);
            return;
        }
        hideLineDelay(0L);
    }
}
