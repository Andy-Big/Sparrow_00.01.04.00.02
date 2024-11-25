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
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GridRulerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B1\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/rigol/scope/views/grid/WaveformGridRulderView;", "Lcom/rigol/scope/views/grid/GridRulerViewWrapper;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "isZoom", "", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "horizontalViewModel", "Lcom/rigol/scope/viewmodels/HorizontalViewModel;", "verticalViewModel", "Lcom/rigol/scope/viewmodels/VerticalViewModel;", "updateHorizontalRulers", "", "updateVerticalRuler", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class WaveformGridRulderView extends GridRulerViewWrapper {
    private final HorizontalViewModel horizontalViewModel;
    private final boolean isZoom;
    private final VerticalViewModel verticalViewModel;

    public WaveformGridRulderView(Context context) {
        this(context, null, 0, false, 14, null);
    }

    public WaveformGridRulderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, false, 12, null);
    }

    public WaveformGridRulderView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false, 8, null);
    }

    public /* synthetic */ WaveformGridRulderView(Context context, AttributeSet attributeSet, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? false : z);
    }

    public WaveformGridRulderView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i);
        MutableLiveData<Object> mutableLiveData;
        MutableLiveData<Object> mutableLiveData2;
        MutableLiveData<Object> mutableLiveData3;
        MutableLiveData<Object> mutableLiveData4;
        MutableLiveData<Object> mutableLiveData5;
        LiveData<ArrayList<VerticalParam>> liveData;
        MutableLiveData<Object> mutableLiveData6;
        MutableLiveData<Object> mutableLiveData7;
        MutableLiveData<Object> mutableLiveData8;
        MutableLiveData<Object> mutableLiveData9;
        MutableLiveData<Object> mutableLiveData10;
        this.isZoom = z;
        this.horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        this.verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        SyncDataViewModel syncDataViewModel = getSyncDataViewModel();
        if (syncDataViewModel != null && (mutableLiveData10 = syncDataViewModel.get(26, MessageID.MSG_DISPLAY_GRID)) != null) {
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData10.observe((LifecycleOwner) context, new Observer<Object>() { // from class: com.rigol.scope.views.grid.WaveformGridRulderView.1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (obj instanceof Integer) {
                        WaveformGridRulderView waveformGridRulderView = WaveformGridRulderView.this;
                        ServiceEnum.EWaveGrids eWaveGridsFromValue1 = ServiceEnum.getEWaveGridsFromValue1(((Number) obj).intValue());
                        Intrinsics.checkNotNullExpressionValue(eWaveGridsFromValue1, "ServiceEnum.getEWaveGridsFromValue1(t)");
                        waveformGridRulderView.setType(eWaveGridsFromValue1);
                        WaveformGridRulderView.this.invalidate();
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel2 = getSyncDataViewModel();
        if (syncDataViewModel2 != null && (mutableLiveData9 = syncDataViewModel2.get(10, MessageID.MSG_HOR_MAIN_SCALE)) != null) {
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData9.observe((LifecycleOwner) context, new Observer<Object>() { // from class: com.rigol.scope.views.grid.WaveformGridRulderView.2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformGridRulderView.this.updateHorizontalRulers();
                }
            });
        }
        SyncDataViewModel syncDataViewModel3 = getSyncDataViewModel();
        if (syncDataViewModel3 != null && (mutableLiveData8 = syncDataViewModel3.get(10, MessageID.MSG_HOR_MAIN_OFFSET)) != null) {
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData8.observe((LifecycleOwner) context, new Observer<Object>() { // from class: com.rigol.scope.views.grid.WaveformGridRulderView.3
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformGridRulderView.this.updateHorizontalRulers();
                }
            });
        }
        SyncDataViewModel syncDataViewModel4 = getSyncDataViewModel();
        if (syncDataViewModel4 != null && (mutableLiveData7 = syncDataViewModel4.get(10, MessageID.MSG_HOR_ZOOM_SCALE)) != null) {
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData7.observe((LifecycleOwner) context, new Observer<Object>() { // from class: com.rigol.scope.views.grid.WaveformGridRulderView.4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformGridRulderView.this.updateHorizontalRulers();
                }
            });
        }
        SyncDataViewModel syncDataViewModel5 = getSyncDataViewModel();
        if (syncDataViewModel5 != null && (mutableLiveData6 = syncDataViewModel5.get(10, MessageID.MSG_HOR_ZOOM_OFFSET)) != null) {
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData6.observe((LifecycleOwner) context, new Observer<Object>() { // from class: com.rigol.scope.views.grid.WaveformGridRulderView.5
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformGridRulderView.this.updateHorizontalRulers();
                }
            });
        }
        VerticalViewModel verticalViewModel = this.verticalViewModel;
        ArrayList<VerticalParam> value = (verticalViewModel == null || (liveData = verticalViewModel.getLiveData()) == null) ? null : liveData.getValue();
        if (value == null || !(!value.isEmpty())) {
            return;
        }
        Iterator<VerticalParam> it = value.iterator();
        while (it.hasNext()) {
            int serviceId = it.next().getServiceId();
            SyncDataViewModel syncDataViewModel6 = getSyncDataViewModel();
            if (syncDataViewModel6 != null && (mutableLiveData5 = syncDataViewModel6.get(serviceId, MessageID.MSG_CHAN_SCALE_REAL)) != null) {
                Context context2 = getContext();
                if (context2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData5.observe((LifecycleOwner) context2, new Observer<Object>() { // from class: com.rigol.scope.views.grid.WaveformGridRulderView.6
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WaveformGridRulderView.this.updateVerticalRuler();
                    }
                });
            }
            SyncDataViewModel syncDataViewModel7 = getSyncDataViewModel();
            if (syncDataViewModel7 != null && (mutableLiveData4 = syncDataViewModel7.get(serviceId, MessageID.MSG_CHAN_OFFSET_REAL)) != null) {
                Context context3 = getContext();
                if (context3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData4.observe((LifecycleOwner) context3, new Observer<Object>() { // from class: com.rigol.scope.views.grid.WaveformGridRulderView.7
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WaveformGridRulderView.this.updateVerticalRuler();
                    }
                });
            }
            SyncDataViewModel syncDataViewModel8 = getSyncDataViewModel();
            if (syncDataViewModel8 != null && (mutableLiveData3 = syncDataViewModel8.get(serviceId, MessageID.MSG_CHAN_ACTIVE)) != null) {
                Context context4 = getContext();
                if (context4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData3.observe((LifecycleOwner) context4, new Observer<Object>() { // from class: com.rigol.scope.views.grid.WaveformGridRulderView.8
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WaveformGridRulderView.this.updateVerticalRuler();
                    }
                });
            }
            SyncDataViewModel syncDataViewModel9 = getSyncDataViewModel();
            if (syncDataViewModel9 != null && (mutableLiveData2 = syncDataViewModel9.get(serviceId, MessageID.MSG_CHAN_ON_OFF)) != null) {
                Context context5 = getContext();
                if (context5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData2.observe((LifecycleOwner) context5, new Observer<Object>() { // from class: com.rigol.scope.views.grid.WaveformGridRulderView.9
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WaveformGridRulderView.this.updateVerticalRuler();
                    }
                });
            }
            SyncDataViewModel syncDataViewModel10 = getSyncDataViewModel();
            if (syncDataViewModel10 != null && (mutableLiveData = syncDataViewModel10.get(serviceId, MessageID.MSG_CHAN_UNIT)) != null) {
                Context context6 = getContext();
                if (context6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData.observe((LifecycleOwner) context6, new Observer<Object>() { // from class: com.rigol.scope.views.grid.WaveformGridRulderView.10
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WaveformGridRulderView.this.updateVerticalRuler();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateHorizontalRulers() {
        String[] horizontalMainRulers;
        HorizontalViewModel horizontalViewModel = this.horizontalViewModel;
        if (horizontalViewModel != null) {
            if (this.isZoom) {
                horizontalMainRulers = ViewUtil.getHorizontalZoomRulers(horizontalViewModel.getLiveData().getValue());
            } else {
                horizontalMainRulers = ViewUtil.getHorizontalMainRulers(horizontalViewModel.getLiveData().getValue());
            }
            setColumnContents(horizontalMainRulers);
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateVerticalRuler() {
        ArrayList<VerticalParam> arrayList;
        VerticalParam defaultItem;
        LiveData<ArrayList<VerticalParam>> liveData;
        VerticalViewModel verticalViewModel = this.verticalViewModel;
        ArrayList<VerticalParam> value = (verticalViewModel == null || (liveData = verticalViewModel.getLiveData()) == null) ? null : liveData.getValue();
        if (value == null || value.isEmpty() || (defaultItem = ViewUtil.getDefaultItem((arrayList = value))) == null) {
            return;
        }
        setRowContents(ViewUtil.getVerticalRulers(arrayList));
        setRowTextColor(ColorUtil.getColor(getContext(), defaultItem.getChan()));
        invalidate();
    }
}
