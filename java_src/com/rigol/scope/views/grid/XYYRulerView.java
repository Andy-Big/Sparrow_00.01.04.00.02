package com.rigol.scope.views.grid;

import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: YRulerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B9\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017J\u001e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/rigol/scope/views/grid/XYYRulerView;", "Lcom/rigol/scope/views/grid/YRulerViewWrapper;", "context", "Landroid/content/Context;", "serviceID", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "windowParam", "Lcom/rigol/scope/data/WindowParam;", "(Landroid/content/Context;ILandroid/util/AttributeSet;ILcom/rigol/scope/data/WindowParam;)V", "verticalViewModel", "Lcom/rigol/scope/viewmodels/VerticalViewModel;", "getWindowParam", "()Lcom/rigol/scope/data/WindowParam;", "setWindowParam", "(Lcom/rigol/scope/data/WindowParam;)V", "setColumnTextColor", "", "color", "updateColumnRulers", "chan", "Lcom/rigol/scope/cil/ServiceEnum$Chan;", "param", "Lcom/rigol/scope/data/VerticalParam;", "verticalParams", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class XYYRulerView extends YRulerViewWrapper {
    private final VerticalViewModel verticalViewModel;
    private WindowParam windowParam;

    public XYYRulerView(Context context, int i, AttributeSet attributeSet, WindowParam windowParam) {
        this(context, i, attributeSet, 0, windowParam, 8, null);
    }

    public XYYRulerView(Context context, int i, WindowParam windowParam) {
        this(context, i, null, 0, windowParam, 12, null);
    }

    public XYYRulerView(Context context, WindowParam windowParam) {
        this(context, 0, null, 0, windowParam, 14, null);
    }

    public /* synthetic */ XYYRulerView(Context context, int i, AttributeSet attributeSet, int i2, WindowParam windowParam, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? null : attributeSet, (i3 & 8) != 0 ? 0 : i2, windowParam);
    }

    public final WindowParam getWindowParam() {
        return this.windowParam;
    }

    public final void setWindowParam(WindowParam windowParam) {
        Intrinsics.checkNotNullParameter(windowParam, "<set-?>");
        this.windowParam = windowParam;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XYYRulerView(Context context, int i, AttributeSet attributeSet, int i2, WindowParam windowParam) {
        super(context, attributeSet, i2);
        MutableLiveData<Object> mutableLiveData;
        MutableLiveData<Object> mutableLiveData2;
        MutableLiveData<Object> mutableLiveData3;
        MutableLiveData<Object> mutableLiveData4;
        LiveData<ArrayList<VerticalParam>> liveData;
        Intrinsics.checkNotNullParameter(windowParam, "windowParam");
        this.windowParam = windowParam;
        VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        this.verticalViewModel = verticalViewModel;
        final ArrayList<VerticalParam> value = (verticalViewModel == null || (liveData = verticalViewModel.getLiveData()) == null) ? null : liveData.getValue();
        if (value == null || !(!value.isEmpty())) {
            return;
        }
        Iterator<VerticalParam> it = value.iterator();
        while (it.hasNext()) {
            final VerticalParam next = it.next();
            int serviceId = next.getServiceId();
            SyncDataViewModel syncDataViewModel = getSyncDataViewModel();
            if (syncDataViewModel != null && (mutableLiveData4 = syncDataViewModel.get(40, MessageID.MSG_DISPLAY_GRID)) != null) {
                if (context == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData4.observe((LifecycleOwner) context, new Observer<Object>() { // from class: com.rigol.scope.views.grid.XYYRulerView.1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        if (obj instanceof Integer) {
                            XYYRulerView.this.invalidate();
                        }
                    }
                });
            }
            SyncDataViewModel syncDataViewModel2 = getSyncDataViewModel();
            if (syncDataViewModel2 != null && (mutableLiveData3 = syncDataViewModel2.get(serviceId, MessageID.MSG_CHAN_SCALE_REAL)) != null) {
                Context context2 = getContext();
                if (context2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData3.observe((LifecycleOwner) context2, new Observer<Object>() { // from class: com.rigol.scope.views.grid.XYYRulerView.2
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        if (XYYRulerView.this.isShown()) {
                            if (next.getChan() == XYYRulerView.this.getWindowParam().getSource1()) {
                                XYYRulerView xYYRulerView = XYYRulerView.this;
                                VerticalParam param = next;
                                Intrinsics.checkNotNullExpressionValue(param, "param");
                                xYYRulerView.updateColumnRulers(param, value);
                            }
                            next.getChan();
                            XYYRulerView.this.getWindowParam().getSource2();
                        }
                    }
                });
            }
            SyncDataViewModel syncDataViewModel3 = getSyncDataViewModel();
            if (syncDataViewModel3 != null && (mutableLiveData2 = syncDataViewModel3.get(serviceId, MessageID.MSG_CHAN_OFFSET_REAL)) != null) {
                Context context3 = getContext();
                if (context3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData2.observe((LifecycleOwner) context3, new Observer<Object>() { // from class: com.rigol.scope.views.grid.XYYRulerView.3
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        if (XYYRulerView.this.isShown()) {
                            if (next.getChan() == XYYRulerView.this.getWindowParam().getSource1()) {
                                XYYRulerView xYYRulerView = XYYRulerView.this;
                                VerticalParam param = next;
                                Intrinsics.checkNotNullExpressionValue(param, "param");
                                xYYRulerView.updateColumnRulers(param, value);
                            }
                            next.getChan();
                            XYYRulerView.this.getWindowParam().getSource2();
                        }
                    }
                });
            }
            SyncDataViewModel syncDataViewModel4 = getSyncDataViewModel();
            if (syncDataViewModel4 != null && (mutableLiveData = syncDataViewModel4.get(serviceId, MessageID.MSG_CHAN_UNIT)) != null) {
                Context context4 = getContext();
                if (context4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData.observe((LifecycleOwner) context4, new Observer<Object>() { // from class: com.rigol.scope.views.grid.XYYRulerView.4
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        if (XYYRulerView.this.isShown()) {
                            if (next.getChan() == XYYRulerView.this.getWindowParam().getSource1()) {
                                XYYRulerView xYYRulerView = XYYRulerView.this;
                                VerticalParam param = next;
                                Intrinsics.checkNotNullExpressionValue(param, "param");
                                xYYRulerView.updateColumnRulers(param, value);
                            }
                            next.getChan();
                            XYYRulerView.this.getWindowParam().getSource2();
                        }
                    }
                });
            }
        }
    }

    public final void setColumnTextColor(int i) {
        getColumnTextPaint().setColor(i);
    }

    public final void updateColumnRulers(VerticalParam param, List<VerticalParam> list) {
        Intrinsics.checkNotNullParameter(param, "param");
        setRowContents(ViewUtil.getReverseVerticalRulers(list, this.windowParam.getSource1().value1 - ServiceEnum.Chan.chan1.value1));
        setColumnTextColor(ColorUtil.getColor(getContext(), param.getChan()));
        invalidate();
    }

    public final void updateColumnRulers(ServiceEnum.Chan chan) {
        LiveData<ArrayList<VerticalParam>> liveData;
        ArrayList<VerticalParam> value;
        Intrinsics.checkNotNullParameter(chan, "chan");
        try {
            int i = chan.value1 - ServiceEnum.Chan.chan1.value1;
            if (i >= 0) {
                VerticalViewModel verticalViewModel = this.verticalViewModel;
                Integer valueOf = (verticalViewModel == null || (liveData = verticalViewModel.getLiveData()) == null || (value = liveData.getValue()) == null) ? null : Integer.valueOf(value.size());
                Intrinsics.checkNotNull(valueOf);
                if (i < valueOf.intValue()) {
                    ArrayList<VerticalParam> value2 = this.verticalViewModel.getLiveData().getValue();
                    VerticalParam verticalParam = value2 != null ? value2.get(i) : null;
                    if (verticalParam != null) {
                        updateColumnRulers(verticalParam, this.verticalViewModel.getLiveData().getValue());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
