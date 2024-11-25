package com.rigol.scope.views.grid;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: GridRulerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002¨\u0006\f"}, d2 = {"Lcom/rigol/scope/views/grid/JitterSpectrumGridRulerView;", "Lcom/rigol/scope/views/grid/GridRulerViewWrapper;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "updateXRuler", "", "updateYRuler", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class JitterSpectrumGridRulerView extends GridRulerViewWrapper {
    public JitterSpectrumGridRulerView(Context context) {
        this(context, null, 0, 6, null);
    }

    public JitterSpectrumGridRulerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ JitterSpectrumGridRulerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public JitterSpectrumGridRulerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        MutableLiveData<Boolean> mutableLiveData;
        updateYRuler();
        updateXRuler();
        setFromTop(true);
        UpdateUIViewModel updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        if (updateUIViewModel == null || (mutableLiveData = updateUIViewModel.get(52, MessageID.MSG_JITTER_CR_DATEFREQ)) == null) {
            return;
        }
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData.observe((LifecycleOwner) topActivity, new Observer<Boolean>() { // from class: com.rigol.scope.views.grid.JitterSpectrumGridRulerView.1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Boolean bool) {
                JitterSpectrumGridRulerView.this.updateXRuler();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateXRuler() {
        setColumnContents(ViewUtil.getJitterSpectrumXRulers());
        invalidate();
    }

    private final void updateYRuler() {
        setRowContents(ViewUtil.getJitterSpectrumYRulers());
        invalidate();
    }
}
