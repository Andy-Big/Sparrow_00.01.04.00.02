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
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: GridRulerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/rigol/scope/views/grid/JitterTrackGridRulerView;", "Lcom/rigol/scope/views/grid/GridRulerViewWrapper;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "horizontalParam", "Lcom/rigol/scope/data/HorizontalParam;", "horizontalViewModel", "Lcom/rigol/scope/viewmodels/HorizontalViewModel;", "updateXRuler", "", "updateYRuler", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class JitterTrackGridRulerView extends GridRulerViewWrapper {
    private final HorizontalParam horizontalParam;
    private final HorizontalViewModel horizontalViewModel;

    public JitterTrackGridRulerView(Context context) {
        this(context, null, 0, 6, null);
    }

    public JitterTrackGridRulerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ JitterTrackGridRulerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public JitterTrackGridRulerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        MutableLiveData<Boolean> mutableLiveData;
        MutableLiveData<Object> mutableLiveData2;
        MutableLiveData<Object> mutableLiveData3;
        LiveData<HorizontalParam> liveData;
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        this.horizontalViewModel = horizontalViewModel;
        HorizontalParam value = (horizontalViewModel == null || (liveData = horizontalViewModel.getLiveData()) == null) ? null : liveData.getValue();
        this.horizontalParam = value;
        if (value != null) {
            updateXRuler(value);
        }
        updateYRuler();
        SyncDataViewModel syncDataViewModel = getSyncDataViewModel();
        if (syncDataViewModel != null && (mutableLiveData3 = syncDataViewModel.get(10, MessageID.MSG_HOR_MAIN_SCALE)) != null) {
            Context context2 = getContext();
            if (context2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData3.observe((LifecycleOwner) context2, new Observer<Object>() { // from class: com.rigol.scope.views.grid.JitterTrackGridRulerView.1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (JitterTrackGridRulerView.this.horizontalParam != null) {
                        JitterTrackGridRulerView jitterTrackGridRulerView = JitterTrackGridRulerView.this;
                        jitterTrackGridRulerView.updateXRuler(jitterTrackGridRulerView.horizontalParam);
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel2 = getSyncDataViewModel();
        if (syncDataViewModel2 != null && (mutableLiveData2 = syncDataViewModel2.get(10, MessageID.MSG_HOR_MAIN_OFFSET)) != null) {
            Context context3 = getContext();
            if (context3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData2.observe((LifecycleOwner) context3, new Observer<Object>() { // from class: com.rigol.scope.views.grid.JitterTrackGridRulerView.2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (JitterTrackGridRulerView.this.horizontalParam != null) {
                        JitterTrackGridRulerView jitterTrackGridRulerView = JitterTrackGridRulerView.this;
                        jitterTrackGridRulerView.updateXRuler(jitterTrackGridRulerView.horizontalParam);
                    }
                }
            });
        }
        UpdateUIViewModel updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        if (updateUIViewModel == null || (mutableLiveData = updateUIViewModel.get(52, MessageID.MSG_JITTER_MAX_TREND)) == null) {
            return;
        }
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData.observe((LifecycleOwner) topActivity, new Observer<Boolean>() { // from class: com.rigol.scope.views.grid.JitterTrackGridRulerView.3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Boolean bool) {
                JitterTrackGridRulerView.this.updateYRuler();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateXRuler(HorizontalParam horizontalParam) {
        setColumnContents(ViewUtil.getJitterTrackXRulers(horizontalParam));
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateYRuler() {
        setRowContents(ViewUtil.getJitterTrackYRulers());
        invalidate();
    }
}
