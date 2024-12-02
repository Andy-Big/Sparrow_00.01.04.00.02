package com.rigol.scope.views.grid;

import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: YRulerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/rigol/scope/views/grid/YRulerViewWrapper;", "Lcom/rigol/scope/views/grid/YRulerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "syncDataViewModel", "Lcom/rigol/scope/viewmodels/SyncDataViewModel;", "getSyncDataViewModel", "()Lcom/rigol/scope/viewmodels/SyncDataViewModel;", "setSyncDataViewModel", "(Lcom/rigol/scope/viewmodels/SyncDataViewModel;)V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public class YRulerViewWrapper extends YRulerView {
    private SyncDataViewModel syncDataViewModel;

    public YRulerViewWrapper(Context context) {
        this(context, null, 0, 6, null);
    }

    public YRulerViewWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ YRulerViewWrapper(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public YRulerViewWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        MutableLiveData<Object> mutableLiveData;
        MutableLiveData<Object> mutableLiveData2;
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        this.syncDataViewModel = syncDataViewModel;
        if (syncDataViewModel != null && (mutableLiveData2 = syncDataViewModel.get(26, MessageID.MSG_DISPLAY_RULERS)) != null) {
            Context context2 = getContext();
            if (context2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData2.observe((LifecycleOwner) context2, new Observer<Object>() { // from class: com.rigol.scope.views.grid.YRulerViewWrapper.1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (obj instanceof Boolean) {
                        YRulerViewWrapper.this.setShowRuler(((Boolean) obj).booleanValue());
                        YRulerViewWrapper.this.invalidate();
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel2 = this.syncDataViewModel;
        if (syncDataViewModel2 == null || (mutableLiveData = syncDataViewModel2.get(10, MessageID.MSG_ACQ_MODE)) == null) {
            return;
        }
        Context context3 = getContext();
        if (context3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData.observe((LifecycleOwner) context3, new Observer<Object>() { // from class: com.rigol.scope.views.grid.YRulerViewWrapper.2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                if (obj instanceof ServiceEnum.AcquireMode) {
                    YRulerViewWrapper.this.setShowRuler(obj != ServiceEnum.AcquireMode.Acquire_Ultra);
                    YRulerViewWrapper.this.invalidate();
                }
            }
        });
    }

    public final SyncDataViewModel getSyncDataViewModel() {
        return this.syncDataViewModel;
    }

    public final void setSyncDataViewModel(SyncDataViewModel syncDataViewModel) {
        this.syncDataViewModel = syncDataViewModel;
    }
}
