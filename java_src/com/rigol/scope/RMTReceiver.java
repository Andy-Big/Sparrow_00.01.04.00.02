package com.rigol.scope;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.SharedViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RMTReceiver.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/rigol/scope/RMTReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "sharedParam", "Lcom/rigol/scope/data/SharedParam;", "getSharedParam", "()Lcom/rigol/scope/data/SharedParam;", "setSharedParam", "(Lcom/rigol/scope/data/SharedParam;)V", "sharedViewModel", "Lcom/rigol/scope/viewmodels/SharedViewModel;", "kotlin.jvm.PlatformType", "getSharedViewModel", "()Lcom/rigol/scope/viewmodels/SharedViewModel;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class RMTReceiver extends BroadcastReceiver {
    private SharedParam sharedParam;
    private final SharedViewModel sharedViewModel;

    public RMTReceiver() {
        SharedViewModel sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
        this.sharedViewModel = sharedViewModel;
        if (sharedViewModel != null) {
            LiveData<SharedParam> liveData = sharedViewModel.getLiveData();
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            liveData.observe((LifecycleOwner) topActivity, new Observer<SharedParam>() { // from class: com.rigol.scope.RMTReceiver$$special$$inlined$let$lambda$1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(SharedParam sharedParam) {
                    RMTReceiver.this.setSharedParam(sharedParam);
                }
            });
        }
    }

    public final SharedViewModel getSharedViewModel() {
        return this.sharedViewModel;
    }

    public final SharedParam getSharedParam() {
        return this.sharedParam;
    }

    public final void setSharedParam(SharedParam sharedParam) {
        this.sharedParam = sharedParam;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        SharedParam sharedParam;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual("com.rigol.webcontrol.START_CONTROL", intent.getAction())) {
            SharedParam sharedParam2 = this.sharedParam;
            if (sharedParam2 != null) {
                sharedParam2.setShowRMT(true);
            }
        } else if (!Intrinsics.areEqual("com.rigol.webcontrol.END_CONTROL", intent.getAction()) || (sharedParam = this.sharedParam) == null) {
        } else {
            sharedParam.setShowRMT(false);
        }
    }
}
