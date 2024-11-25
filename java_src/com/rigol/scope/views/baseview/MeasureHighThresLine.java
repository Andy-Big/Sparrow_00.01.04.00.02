package com.rigol.scope.views.baseview;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.cil.MessageID;
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
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.views.baseview.OrientationView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
/* compiled from: LineView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/rigol/scope/views/baseview/MeasureHighThresLine;", "Lcom/rigol/scope/views/baseview/LineView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "measureSettingParam", "Lcom/rigol/scope/data/MeasureSettingParam;", "sharedParam", "Lcom/rigol/scope/data/SharedParam;", "verticalParams", "Ljava/util/ArrayList;", "Lcom/rigol/scope/data/VerticalParam;", "Lkotlin/collections/ArrayList;", "getVerticalParams", "()Ljava/util/ArrayList;", "setVerticalParams", "(Ljava/util/ArrayList;)V", "setPosition", "", "chanValue", "", "thres", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class MeasureHighThresLine extends LineView {
    private MeasureSettingParam measureSettingParam;
    private SharedParam sharedParam;
    private ArrayList<VerticalParam> verticalParams;

    public MeasureHighThresLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LiveData<MeasureSettingParam> liveData;
        LiveData<SharedParam> liveData2;
        LiveData<ArrayList<VerticalParam>> liveData3;
        MutableLiveData<Object> mutableLiveData;
        MutableLiveData<Object> mutableLiveData2;
        this.verticalParams = new ArrayList<>();
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null && (mutableLiveData2 = syncDataViewModel.get(28, MessageID.MSG_APP_MEASURE)) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                mutableLiveData2.observe((LifecycleOwner) topActivity, new Observer<Object>() { // from class: com.rigol.scope.views.baseview.MeasureHighThresLine.1
                    @Override // androidx.lifecycle.Observer
                    public void onChanged(Object obj) {
                        OrientationView.Companion.setDrawType(String.valueOf(obj));
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        SyncDataViewModel syncDataViewModel2 = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel2 != null && (mutableLiveData = syncDataViewModel2.get(28, MessageID.MSG_APP_RESULT)) != null) {
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 != null) {
                mutableLiveData.observe((LifecycleOwner) topActivity2, new Observer<Object>() { // from class: com.rigol.scope.views.baseview.MeasureHighThresLine.2
                    @Override // androidx.lifecycle.Observer
                    public void onChanged(Object obj) {
                        List<String> split = new Regex(";").split(String.valueOf(obj), 0);
                        OrientationView.Companion.setSourceA(split.get(0));
                        OrientationView.Companion.setSourceB(split.get(1));
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        if (verticalViewModel != null && (liveData3 = verticalViewModel.getLiveData()) != null) {
            Activity topActivity3 = ActivityUtils.getTopActivity();
            if (topActivity3 != null) {
                liveData3.observe((LifecycleOwner) topActivity3, new Observer<ArrayList<VerticalParam>>() { // from class: com.rigol.scope.views.baseview.MeasureHighThresLine.3
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(ArrayList<VerticalParam> verticalParams) {
                        MeasureHighThresLine measureHighThresLine = MeasureHighThresLine.this;
                        Intrinsics.checkNotNullExpressionValue(verticalParams, "verticalParams");
                        measureHighThresLine.setVerticalParams(verticalParams);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        SharedViewModel sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
        if (sharedViewModel != null && (liveData2 = sharedViewModel.getLiveData()) != null) {
            Activity topActivity4 = ActivityUtils.getTopActivity();
            if (topActivity4 != null) {
                liveData2.observe((LifecycleOwner) topActivity4, new Observer<SharedParam>() { // from class: com.rigol.scope.views.baseview.MeasureHighThresLine.4
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(SharedParam sharedParam) {
                        MeasureHighThresLine measureHighThresLine = MeasureHighThresLine.this;
                        Intrinsics.checkNotNullExpressionValue(sharedParam, "sharedParam");
                        measureHighThresLine.sharedParam = sharedParam;
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        MeasureSettingViewModel measureSettingViewModel = (MeasureSettingViewModel) ContextUtil.getAppViewModel(MeasureSettingViewModel.class);
        if (measureSettingViewModel != null && (liveData = measureSettingViewModel.getLiveData()) != null) {
            Activity topActivity5 = ActivityUtils.getTopActivity();
            if (topActivity5 != null) {
                liveData.observe((LifecycleOwner) topActivity5, new Observer<MeasureSettingParam>() { // from class: com.rigol.scope.views.baseview.MeasureHighThresLine.5
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(MeasureSettingParam measureSettingParam) {
                        MeasureHighThresLine measureHighThresLine = MeasureHighThresLine.this;
                        Intrinsics.checkNotNullExpressionValue(measureSettingParam, "measureSettingParam");
                        measureHighThresLine.measureSettingParam = measureSettingParam;
                        OrientationView.Companion.setStrThresholdHigh(String.valueOf(MeasureHighThresLine.access$getMeasureSettingParam$p(MeasureHighThresLine.this).getThresholdHigh()));
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

    public static final /* synthetic */ MeasureSettingParam access$getMeasureSettingParam$p(MeasureHighThresLine measureHighThresLine) {
        MeasureSettingParam measureSettingParam = measureHighThresLine.measureSettingParam;
        if (measureSettingParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("measureSettingParam");
        }
        return measureSettingParam;
    }

    public static final /* synthetic */ SharedParam access$getSharedParam$p(MeasureHighThresLine measureHighThresLine) {
        SharedParam sharedParam = measureHighThresLine.sharedParam;
        if (sharedParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedParam");
        }
        return sharedParam;
    }

    public final ArrayList<VerticalParam> getVerticalParams() {
        return this.verticalParams;
    }

    public final void setVerticalParams(ArrayList<VerticalParam> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.verticalParams = arrayList;
    }

    public final void setPosition(int i, long j) {
        int i2;
        if (getParent() != null && (i2 = i - ServiceEnum.Chan.chan1.value1) >= 0 && i2 < this.verticalParams.size()) {
            VerticalParam verticalParam = this.verticalParams.get(i2);
            Intrinsics.checkNotNullExpressionValue(verticalParam, "verticalParams[verticalParamIndex]");
            VerticalParam verticalParam2 = verticalParam;
            if (getVisibility() == 8 || getVisibility() == 4) {
                setVisibility(0);
            }
            Context context = getContext();
            if (context != null) {
                setLineColor(ColorUtil.getColor(context, verticalParam2.getServiceId()));
            }
            float valuePercent = ViewUtil.getValuePercent(verticalParam2, j);
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
                String convert = newBuilder.convert(measureSettingParam2.getThresholdHigh(), ServiceEnum.Unit.Unit_V);
                Intrinsics.checkNotNullExpressionValue(convert, "UnitFormat.newBuilder( U…ServiceEnum.Unit.Unit_V )");
                companion.setStrThresholdHigh(convert);
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
                sb.append(String.valueOf(measureSettingParam5.getThresholdHigh()));
                sb.append("%");
                companion2.setStrThresholdHigh(sb.toString());
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
}
