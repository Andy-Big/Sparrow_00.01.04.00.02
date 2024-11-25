package com.rigol.scope;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.SharedViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HDMIReceiver.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/rigol/scope/HDMIReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "sharedViewModel", "Lcom/rigol/scope/viewmodels/SharedViewModel;", "getSharedViewModel", "()Lcom/rigol/scope/viewmodels/SharedViewModel;", "setSharedViewModel", "(Lcom/rigol/scope/viewmodels/SharedViewModel;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class HDMIReceiver extends BroadcastReceiver {
    private SharedViewModel sharedViewModel;

    public final SharedViewModel getSharedViewModel() {
        return this.sharedViewModel;
    }

    public final void setSharedViewModel(SharedViewModel sharedViewModel) {
        this.sharedViewModel = sharedViewModel;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        SharedParam value;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual("android.intent.action.HDMI_PLUGGED", intent.getAction())) {
            SharedViewModel sharedViewModel = (SharedViewModel) ContextUtil.getActivityViewModel(SharedViewModel.class);
            this.sharedViewModel = sharedViewModel;
            if (sharedViewModel == null || (value = sharedViewModel.getValue()) == null) {
                return;
            }
            value.setLauncheNum(false);
        }
    }
}
