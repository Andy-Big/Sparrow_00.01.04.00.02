package com.rigol.scope.views.grid;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.data.XYParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.viewmodels.XYViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: XRulerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0018H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/rigol/scope/views/grid/XYXRulerView;", "Lcom/rigol/scope/views/grid/XRulerViewWrapper;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "windowParam", "Lcom/rigol/scope/data/WindowParam;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/rigol/scope/data/WindowParam;)V", "long_time", "", "verticalViewModel", "Lcom/rigol/scope/viewmodels/VerticalViewModel;", "xyParam", "Lcom/rigol/scope/data/XYParam;", "xyViewModel", "Lcom/rigol/scope/viewmodels/XYViewModel;", "updateXRuler", "", "param", "Lcom/rigol/scope/data/VerticalParam;", "verticalParams", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class XYXRulerView extends XRulerViewWrapper {
    private long long_time;
    private final VerticalViewModel verticalViewModel;
    private WindowParam windowParam;
    private XYParam xyParam;
    private final XYViewModel xyViewModel;

    public XYXRulerView(Context context, AttributeSet attributeSet, WindowParam windowParam) {
        this(context, attributeSet, 0, windowParam, 4, null);
    }

    public XYXRulerView(Context context, WindowParam windowParam) {
        this(context, null, 0, windowParam, 6, null);
    }

    public /* synthetic */ XYXRulerView(Context context, AttributeSet attributeSet, int i, WindowParam windowParam, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i, windowParam);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XYXRulerView(Context context, AttributeSet attributeSet, int i, WindowParam windowParam) {
        super(context, attributeSet, i);
        MutableLiveData<Object> mutableLiveData;
        MutableLiveData<Object> mutableLiveData2;
        MutableLiveData<Object> mutableLiveData3;
        LiveData<ArrayList<VerticalParam>> liveData;
        MutableLiveData<Object> mutableLiveData4;
        LiveData<XYParam> liveData2;
        Intrinsics.checkNotNullParameter(windowParam, "windowParam");
        this.xyViewModel = (XYViewModel) ContextUtil.getAppViewModel(XYViewModel.class);
        this.verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        setFromStart(false);
        setFromTop(false);
        this.windowParam = windowParam;
        XYViewModel xYViewModel = this.xyViewModel;
        if (xYViewModel != null && (liveData2 = xYViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            liveData2.observe((LifecycleOwner) topActivity, new Observer<XYParam>() { // from class: com.rigol.scope.views.grid.XYXRulerView.1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(XYParam xYParam) {
                    XYXRulerView.this.xyParam = xYParam;
                }
            });
        }
        SyncDataViewModel syncDataViewModel = getSyncDataViewModel();
        if (syncDataViewModel != null && (mutableLiveData4 = syncDataViewModel.get(40, MessageID.MSG_DISPLAY_GRID)) != null) {
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData4.observe((LifecycleOwner) context, new Observer<Object>() { // from class: com.rigol.scope.views.grid.XYXRulerView.2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (obj instanceof Integer) {
                        XYXRulerView xYXRulerView = XYXRulerView.this;
                        ServiceEnum.EWaveGrids eWaveGridsFromValue1 = ServiceEnum.getEWaveGridsFromValue1(((Number) obj).intValue());
                        Intrinsics.checkNotNullExpressionValue(eWaveGridsFromValue1, "ServiceEnum.getEWaveGridsFromValue1(t)");
                        xYXRulerView.setType(eWaveGridsFromValue1);
                        XYXRulerView.this.invalidate();
                    }
                }
            });
        }
        VerticalViewModel verticalViewModel = this.verticalViewModel;
        final ArrayList<VerticalParam> value = (verticalViewModel == null || (liveData = verticalViewModel.getLiveData()) == null) ? null : liveData.getValue();
        if (value == null || !(!value.isEmpty())) {
            return;
        }
        Iterator<VerticalParam> it = value.iterator();
        while (it.hasNext()) {
            final VerticalParam next = it.next();
            int serviceId = next.getServiceId();
            SyncDataViewModel syncDataViewModel2 = getSyncDataViewModel();
            if (syncDataViewModel2 != null && (mutableLiveData3 = syncDataViewModel2.get(serviceId, MessageID.MSG_CHAN_SCALE_REAL)) != null) {
                Context context2 = getContext();
                if (context2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData3.observe((LifecycleOwner) context2, new Observer<Object>() { // from class: com.rigol.scope.views.grid.XYXRulerView.3
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        XYXRulerView xYXRulerView = XYXRulerView.this;
                        VerticalParam param = next;
                        Intrinsics.checkNotNullExpressionValue(param, "param");
                        xYXRulerView.updateXRuler(param, value);
                    }
                });
            }
            SyncDataViewModel syncDataViewModel3 = getSyncDataViewModel();
            if (syncDataViewModel3 != null && (mutableLiveData2 = syncDataViewModel3.get(serviceId, MessageID.MSG_CHAN_OFFSET_REAL)) != null) {
                Context context3 = getContext();
                if (context3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData2.observe((LifecycleOwner) context3, new Observer<Object>() { // from class: com.rigol.scope.views.grid.XYXRulerView.4
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        XYXRulerView xYXRulerView = XYXRulerView.this;
                        VerticalParam param = next;
                        Intrinsics.checkNotNullExpressionValue(param, "param");
                        xYXRulerView.updateXRuler(param, value);
                    }
                });
            }
            SyncDataViewModel syncDataViewModel4 = getSyncDataViewModel();
            if (syncDataViewModel4 != null && (mutableLiveData = syncDataViewModel4.get(serviceId, MessageID.MSG_CHAN_UNIT)) != null) {
                Context context4 = getContext();
                if (context4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData.observe((LifecycleOwner) context4, new Observer<Object>() { // from class: com.rigol.scope.views.grid.XYXRulerView.5
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        XYXRulerView xYXRulerView = XYXRulerView.this;
                        VerticalParam param = next;
                        Intrinsics.checkNotNullExpressionValue(param, "param");
                        xYXRulerView.updateXRuler(param, value);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateXRuler(VerticalParam verticalParam, List<VerticalParam> list) {
        WindowParam windowParam = this.windowParam;
        Intrinsics.checkNotNull(windowParam);
        setColumnContents(ViewUtil.getReverseVerticalRulers(list, windowParam.getSource1().value1 - ServiceEnum.Chan.chan1.value1));
        setColumnTextColor(ColorUtil.getColor(getContext(), verticalParam.getChan()));
        invalidate();
    }
}
