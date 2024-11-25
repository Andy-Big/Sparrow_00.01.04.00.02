package com.rigol.scope.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.rigol.lib.data.Firmware;
import kotlin.Metadata;
/* compiled from: UpdateViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/rigol/scope/viewmodels/UpdateViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "liveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/rigol/lib/data/Firmware;", "getLiveData", "()Landroidx/lifecycle/MutableLiveData;", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class UpdateViewModel extends ViewModel {
    private final MutableLiveData<Firmware> liveData = new MutableLiveData<>();

    public final MutableLiveData<Firmware> getLiveData() {
        return this.liveData;
    }
}
