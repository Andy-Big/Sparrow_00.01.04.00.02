package com.rigol.scope.views.grid;

import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.BaseProperty;
import com.rigol.scope.data.EyeParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.EyeViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GridRulerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/rigol/scope/views/grid/EyeGridRulerView;", "Lcom/rigol/scope/views/grid/GridRulerViewWrapper;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "eyeParam", "Lcom/rigol/scope/data/EyeParam;", "eyeViewModel", "Lcom/rigol/scope/viewmodels/EyeViewModel;", "updateXRuler", "", "updateYRuler", "verticalParam", "Lcom/rigol/scope/data/VerticalParam;", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class EyeGridRulerView extends GridRulerViewWrapper {
    private final EyeParam eyeParam;
    private final EyeViewModel eyeViewModel;

    public EyeGridRulerView(Context context) {
        this(context, null, 0, 6, null);
    }

    public EyeGridRulerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ EyeGridRulerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public EyeGridRulerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        MutableLiveData<Object> mutableLiveData;
        MutableLiveData<Object> mutableLiveData2;
        LiveData<ArrayList<VerticalParam>> liveData;
        MutableLiveData<Object> mutableLiveData3;
        MutableLiveData<Object> mutableLiveData4;
        MutableLiveData<Object> mutableLiveData5;
        LiveData<EyeParam> liveData2;
        EyeViewModel eyeViewModel = (EyeViewModel) ContextUtil.getAppViewModel(EyeViewModel.class);
        this.eyeViewModel = eyeViewModel;
        ArrayList<VerticalParam> arrayList = null;
        this.eyeParam = (eyeViewModel == null || (liveData2 = eyeViewModel.getLiveData()) == null) ? null : liveData2.getValue();
        if (context != null) {
            setColumnTextColor(ColorUtil.getColor(context, (int) R.color.darkorange));
        }
        EyeParam eyeParam = this.eyeParam;
        if (eyeParam != null) {
            updateXRuler(eyeParam);
        }
        SyncDataViewModel syncDataViewModel = getSyncDataViewModel();
        if (syncDataViewModel != null && (mutableLiveData5 = syncDataViewModel.get(51, MessageID.MSG_DISPLAY_GRID)) != null) {
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData5.observe((LifecycleOwner) context, new Observer<Object>() { // from class: com.rigol.scope.views.grid.EyeGridRulerView.3
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (EyeGridRulerView.this.eyeParam != null) {
                        EyeGridRulerView eyeGridRulerView = EyeGridRulerView.this;
                        ServiceEnum.EWaveGrids eWaveGridsFromValue1 = ServiceEnum.getEWaveGridsFromValue1(eyeGridRulerView.eyeParam.getGrids().getValue().intValue());
                        Intrinsics.checkNotNullExpressionValue(eWaveGridsFromValue1, "ServiceEnum.getEWaveGrid…ue1(eyeParam.grids.value)");
                        eyeGridRulerView.setType(eWaveGridsFromValue1);
                        EyeGridRulerView.this.invalidate();
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel2 = getSyncDataViewModel();
        if (syncDataViewModel2 != null && (mutableLiveData4 = syncDataViewModel2.get(51, MessageID.MSG_EYE_UI_TIME)) != null) {
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData4.observe((LifecycleOwner) context, new Observer<Object>() { // from class: com.rigol.scope.views.grid.EyeGridRulerView.4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (EyeGridRulerView.this.eyeParam != null) {
                        EyeGridRulerView eyeGridRulerView = EyeGridRulerView.this;
                        eyeGridRulerView.updateXRuler(eyeGridRulerView.eyeParam);
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel3 = getSyncDataViewModel();
        if (syncDataViewModel3 != null && (mutableLiveData3 = syncDataViewModel3.get(51, MessageID.MSG_EYE_SOURCE)) != null) {
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData3.observe((LifecycleOwner) context, new Observer<Object>() { // from class: com.rigol.scope.views.grid.EyeGridRulerView.5
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseProperty<Integer> chan;
                    Integer value;
                    LiveData<ArrayList<VerticalParam>> liveData3;
                    VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
                    ArrayList<VerticalParam> value2 = (verticalViewModel == null || (liveData3 = verticalViewModel.getLiveData()) == null) ? null : liveData3.getValue();
                    EyeParam eyeParam2 = EyeGridRulerView.this.eyeParam;
                    VerticalParam verticalItem = ViewUtil.getVerticalItem(value2, ServiceEnum.getChanFromValue1((eyeParam2 == null || (chan = eyeParam2.getChan()) == null || (value = chan.getValue()) == null) ? ServiceEnum.Chan.chan1.value1 : value.intValue()));
                    if (verticalItem != null) {
                        EyeGridRulerView.this.updateYRuler(verticalItem);
                    }
                }
            });
        }
        VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        if (verticalViewModel != null && (liveData = verticalViewModel.getLiveData()) != null) {
            arrayList = liveData.getValue();
        }
        if (arrayList == null || !(!arrayList.isEmpty())) {
            return;
        }
        Iterator<VerticalParam> it = arrayList.iterator();
        while (it.hasNext()) {
            final int serviceId = it.next().getServiceId();
            SyncDataViewModel syncDataViewModel4 = getSyncDataViewModel();
            if (syncDataViewModel4 != null && (mutableLiveData2 = syncDataViewModel4.get(serviceId, MessageID.MSG_CHAN_SCALE_REAL)) != null) {
                Context context2 = getContext();
                if (context2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData2.observe((LifecycleOwner) context2, new Observer<Object>() { // from class: com.rigol.scope.views.grid.EyeGridRulerView.6
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        BaseProperty<Integer> chan;
                        LiveData<ArrayList<VerticalParam>> liveData3;
                        EyeParam eyeParam2 = EyeGridRulerView.this.eyeParam;
                        if (eyeParam2 == null || (chan = eyeParam2.getChan()) == null || chan.getValue().intValue() - ServiceEnum.Chan.chan1.value1 != serviceId - 1) {
                            return;
                        }
                        VerticalViewModel verticalViewModel2 = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
                        VerticalParam verticalItem = ViewUtil.getVerticalItem((verticalViewModel2 == null || (liveData3 = verticalViewModel2.getLiveData()) == null) ? null : liveData3.getValue(), ServiceEnum.getChanFromValue1(chan.getValue().intValue()));
                        if (verticalItem != null) {
                            EyeGridRulerView.this.updateYRuler(verticalItem);
                        }
                    }
                });
            }
            SyncDataViewModel syncDataViewModel5 = getSyncDataViewModel();
            if (syncDataViewModel5 != null && (mutableLiveData = syncDataViewModel5.get(serviceId, MessageID.MSG_CHAN_OFFSET_REAL)) != null) {
                Context context3 = getContext();
                if (context3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData.observe((LifecycleOwner) context3, new Observer<Object>() { // from class: com.rigol.scope.views.grid.EyeGridRulerView.7
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        BaseProperty<Integer> chan;
                        LiveData<ArrayList<VerticalParam>> liveData3;
                        EyeParam eyeParam2 = EyeGridRulerView.this.eyeParam;
                        if (eyeParam2 == null || (chan = eyeParam2.getChan()) == null || chan.getValue().intValue() - ServiceEnum.Chan.chan1.value1 != serviceId - 1) {
                            return;
                        }
                        VerticalViewModel verticalViewModel2 = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
                        VerticalParam verticalItem = ViewUtil.getVerticalItem((verticalViewModel2 == null || (liveData3 = verticalViewModel2.getLiveData()) == null) ? null : liveData3.getValue(), ServiceEnum.getChanFromValue1(chan.getValue().intValue()));
                        if (verticalItem != null) {
                            EyeGridRulerView.this.updateYRuler(verticalItem);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateXRuler(EyeParam eyeParam) {
        setColumnContents(ViewUtil.getEyeXRulers(eyeParam));
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateYRuler(VerticalParam verticalParam) {
        setRowContents(ViewUtil.getEyeYRulers(verticalParam));
        setRowTextColor(ColorUtil.getColor(getContext(), verticalParam.getChan()));
        invalidate();
    }
}
