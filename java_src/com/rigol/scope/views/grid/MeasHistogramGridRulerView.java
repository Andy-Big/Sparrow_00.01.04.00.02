package com.rigol.scope.views.grid;

import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.rigol.scope.adapters.ResultListAdapter;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: GridRulerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002¨\u0006\f"}, d2 = {"Lcom/rigol/scope/views/grid/MeasHistogramGridRulerView;", "Lcom/rigol/scope/views/grid/GridRulerViewWrapper;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "updateXRuler", "", "updateYRuler", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class MeasHistogramGridRulerView extends GridRulerViewWrapper {
    public MeasHistogramGridRulerView(Context context) {
        this(context, null, 0, 6, null);
    }

    public MeasHistogramGridRulerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ MeasHistogramGridRulerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public MeasHistogramGridRulerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        MutableLiveData<Object> mutableLiveData;
        setFromTop(false);
        setFromStart(false);
        updateXRuler();
        updateYRuler();
        SyncDataViewModel syncDataViewModel = getSyncDataViewModel();
        if (syncDataViewModel == null || (mutableLiveData = syncDataViewModel.get(ResultListAdapter.ON_ITEM_DATA_CHANGED_KEY_MEAS_HISTOGRAM)) == null) {
            return;
        }
        Context context2 = getContext();
        if (context2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData.observe((LifecycleOwner) context2, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MeasHistogramGridRulerView.1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MeasHistogramGridRulerView.this.updateXRuler();
                MeasHistogramGridRulerView.this.updateYRuler();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateXRuler() {
        setColumnContents(ViewUtil.getMeasHistogramXRulers());
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateYRuler() {
        setRowContents(ViewUtil.getMeasHistogramYRulers());
        invalidate();
    }
}
