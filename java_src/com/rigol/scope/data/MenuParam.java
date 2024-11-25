package com.rigol.scope.data;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MenuParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/rigol/scope/data/MenuParam;", "", "()V", "waveform", "Landroidx/lifecycle/MutableLiveData;", "", "getWaveform", "()Landroidx/lifecycle/MutableLiveData;", "setWaveform", "(Landroidx/lifecycle/MutableLiveData;)V", "waveform1", "getWaveform1", "setWaveform1", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class MenuParam {
    private MutableLiveData<String> waveform = new MutableLiveData<>("Sine");
    private MutableLiveData<String> waveform1 = new MutableLiveData<>("Sine");

    public final MutableLiveData<String> getWaveform() {
        return this.waveform;
    }

    public final void setWaveform(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.waveform = mutableLiveData;
    }

    public final MutableLiveData<String> getWaveform1() {
        return this.waveform1;
    }

    public final void setWaveform1(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.waveform1 = mutableLiveData;
    }
}
