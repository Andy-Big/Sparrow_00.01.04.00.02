package com.rigol.scope.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.rigol.scope.data.ResultParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MeasureResultViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/rigol/scope/viewmodels/MeasureResultViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "liveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/rigol/scope/data/ResultParam;", "getLiveData", "()Landroidx/lifecycle/MutableLiveData;", "resultBarStatus", "", "getResultBarStatus", "setResultBarStatus", "(Landroidx/lifecycle/MutableLiveData;)V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class MeasureResultViewModel extends ViewModel {
    private final MutableLiveData<List<ResultParam>> liveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> resultBarStatus = new MutableLiveData<>();

    public final MutableLiveData<List<ResultParam>> getLiveData() {
        return this.liveData;
    }

    public final MutableLiveData<Boolean> getResultBarStatus() {
        return this.resultBarStatus;
    }

    public final void setResultBarStatus(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.resultBarStatus = mutableLiveData;
    }
}
