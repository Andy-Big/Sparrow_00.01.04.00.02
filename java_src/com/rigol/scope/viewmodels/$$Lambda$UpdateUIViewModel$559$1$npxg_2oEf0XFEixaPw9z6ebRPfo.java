package com.rigol.scope.viewmodels;

import com.rigol.scope.views.baseview.BasePopupView;

/* compiled from: lambda */
/* renamed from: com.rigol.scope.viewmodels.-$$Lambda$UpdateUIViewModel$559$1$npxg_2oEf0XFEixaPw9z6ebRPfo  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$UpdateUIViewModel$559$1$npxg_2oEf0XFEixaPw9z6ebRPfo implements Runnable {
    public final /* synthetic */ BasePopupView f$0;

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.viewmodels.UpdateUIViewModel.559.1.onDone():void, com.rigol.scope.viewmodels.UpdateUIViewModel.559.1.onSuccess(java.lang.Boolean):void] */
    public /* synthetic */ $$Lambda$UpdateUIViewModel$559$1$npxg_2oEf0XFEixaPw9z6ebRPfo(BasePopupView basePopupView) {
        this.f$0 = basePopupView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.dismiss();
    }
}
