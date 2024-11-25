package com.rigol.scope.viewmodels;

import android.app.Application;
import com.rigol.scope.data.TriggerParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TriggerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/rigol/scope/viewmodels/TriggerViewModel;", "Lcom/rigol/scope/viewmodels/BaseAndroidViewModel;", "Lcom/rigol/scope/data/TriggerParam;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class TriggerViewModel extends BaseAndroidViewModel<TriggerParam> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerViewModel(Application application) {
        super(application, new TriggerParam(application));
        Intrinsics.checkNotNullParameter(application, "application");
    }
}
