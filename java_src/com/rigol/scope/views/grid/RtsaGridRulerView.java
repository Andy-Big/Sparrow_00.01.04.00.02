package com.rigol.scope.views.grid;

import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.FftViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: GridRulerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/rigol/scope/views/grid/RtsaGridRulerView;", "Lcom/rigol/scope/views/grid/GridRulerViewWrapper;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fftViewModel", "Lcom/rigol/scope/viewmodels/FftViewModel;", "updateXRulers", "", "updateYRulers", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class RtsaGridRulerView extends GridRulerViewWrapper {
    private final FftViewModel fftViewModel;

    public RtsaGridRulerView(Context context) {
        this(context, null, 0, 6, null);
    }

    public RtsaGridRulerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ RtsaGridRulerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public RtsaGridRulerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        MutableLiveData<Object> mutableLiveData;
        MutableLiveData<Object> mutableLiveData2;
        MutableLiveData<Object> mutableLiveData3;
        MutableLiveData<Object> mutableLiveData4;
        MutableLiveData<Object> mutableLiveData5;
        MutableLiveData<Object> mutableLiveData6;
        MutableLiveData<Object> mutableLiveData7;
        MutableLiveData<Object> mutableLiveData8;
        this.fftViewModel = (FftViewModel) ContextUtil.getAppViewModel(FftViewModel.class);
        if (context != null) {
            setRowTextColor(ColorUtil.getColor(context, 50));
        }
        if (context != null) {
            setColumnTextColor(ColorUtil.getColor(context, 50));
        }
        SyncDataViewModel syncDataViewModel = getSyncDataViewModel();
        if (syncDataViewModel != null && (mutableLiveData8 = syncDataViewModel.get(50, MessageID.MSG_DISPLAY_GRID)) != null) {
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData8.observe((LifecycleOwner) context, new Observer<Object>() { // from class: com.rigol.scope.views.grid.RtsaGridRulerView.5
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (obj instanceof ServiceEnum.EWaveGrids) {
                        RtsaGridRulerView.this.setType((ServiceEnum.EWaveGrids) obj);
                        RtsaGridRulerView.this.invalidate();
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel2 = getSyncDataViewModel();
        if (syncDataViewModel2 != null && (mutableLiveData7 = syncDataViewModel2.get(50, MessageID.MSG_FFT_CENTER)) != null) {
            Context context2 = getContext();
            if (context2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData7.observe((LifecycleOwner) context2, new Observer<Object>() { // from class: com.rigol.scope.views.grid.RtsaGridRulerView.6
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RtsaGridRulerView.this.updateXRulers();
                }
            });
        }
        SyncDataViewModel syncDataViewModel3 = getSyncDataViewModel();
        if (syncDataViewModel3 != null && (mutableLiveData6 = syncDataViewModel3.get(50, MessageID.MSG_FFT_SPAN)) != null) {
            Context context3 = getContext();
            if (context3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData6.observe((LifecycleOwner) context3, new Observer<Object>() { // from class: com.rigol.scope.views.grid.RtsaGridRulerView.7
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RtsaGridRulerView.this.updateXRulers();
                }
            });
        }
        SyncDataViewModel syncDataViewModel4 = getSyncDataViewModel();
        if (syncDataViewModel4 != null && (mutableLiveData5 = syncDataViewModel4.get(50, MessageID.MSG_FFT_START)) != null) {
            Context context4 = getContext();
            if (context4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData5.observe((LifecycleOwner) context4, new Observer<Object>() { // from class: com.rigol.scope.views.grid.RtsaGridRulerView.8
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RtsaGridRulerView.this.updateXRulers();
                }
            });
        }
        SyncDataViewModel syncDataViewModel5 = getSyncDataViewModel();
        if (syncDataViewModel5 != null && (mutableLiveData4 = syncDataViewModel5.get(50, MessageID.MSG_FFT_END)) != null) {
            Context context5 = getContext();
            if (context5 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData4.observe((LifecycleOwner) context5, new Observer<Object>() { // from class: com.rigol.scope.views.grid.RtsaGridRulerView.9
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RtsaGridRulerView.this.updateXRulers();
                }
            });
        }
        SyncDataViewModel syncDataViewModel6 = getSyncDataViewModel();
        if (syncDataViewModel6 != null && (mutableLiveData3 = syncDataViewModel6.get(50, MessageID.MSG_FFT_H_OFFSET)) != null) {
            Context context6 = getContext();
            if (context6 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData3.observe((LifecycleOwner) context6, new Observer<Object>() { // from class: com.rigol.scope.views.grid.RtsaGridRulerView.10
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RtsaGridRulerView.this.updateXRulers();
                }
            });
        }
        SyncDataViewModel syncDataViewModel7 = getSyncDataViewModel();
        if (syncDataViewModel7 != null && (mutableLiveData2 = syncDataViewModel7.get(50, MessageID.MSG_FFT_REF_LEVEL)) != null) {
            Context context7 = getContext();
            if (context7 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData2.observe((LifecycleOwner) context7, new Observer<Object>() { // from class: com.rigol.scope.views.grid.RtsaGridRulerView.11
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RtsaGridRulerView.this.updateYRulers();
                }
            });
        }
        SyncDataViewModel syncDataViewModel8 = getSyncDataViewModel();
        if (syncDataViewModel8 == null || (mutableLiveData = syncDataViewModel8.get(50, MessageID.MSG_FFT_SCALE)) == null) {
            return;
        }
        Context context8 = getContext();
        if (context8 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData.observe((LifecycleOwner) context8, new Observer<Object>() { // from class: com.rigol.scope.views.grid.RtsaGridRulerView.12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RtsaGridRulerView.this.updateYRulers();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateXRulers() {
        FftViewModel fftViewModel = this.fftViewModel;
        if (fftViewModel != null) {
            setColumnContents(ViewUtil.getRtsaXRulers(fftViewModel.getLiveData().getValue()));
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateYRulers() {
        FftViewModel fftViewModel = this.fftViewModel;
        if (fftViewModel != null) {
            setRowContents(ViewUtil.getRtsaYRulers(fftViewModel.getLiveData().getValue()));
        }
        invalidate();
    }
}
