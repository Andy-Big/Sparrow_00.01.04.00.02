package com.rigol.scope.data;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.rigol.scope.cil.ServiceEnum;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WindowParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00108G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00108G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R&\u0010\u0019\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00108G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R&\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\u001c8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/rigol/scope/data/WindowParam;", "Landroidx/databinding/BaseObservable;", "()V", "closeable", "", "getCloseable", "()Z", "setCloseable", "(Z)V", "value", "", "serviceID", "getServiceID", "()I", "setServiceID", "(I)V", "Lcom/rigol/scope/cil/ServiceEnum$Chan;", "source1", "getSource1", "()Lcom/rigol/scope/cil/ServiceEnum$Chan;", "setSource1", "(Lcom/rigol/scope/cil/ServiceEnum$Chan;)V", "source2", "getSource2", "setSource2", "source3", "getSource3", "setSource3", "Lcom/rigol/scope/cil/ServiceEnum$WindowType;", "type", "getType", "()Lcom/rigol/scope/cil/ServiceEnum$WindowType;", "setType", "(Lcom/rigol/scope/cil/ServiceEnum$WindowType;)V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class WindowParam extends BaseObservable {
    private int serviceID;
    private ServiceEnum.WindowType type = ServiceEnum.WindowType.WIN_NONE;
    private ServiceEnum.Chan source1 = ServiceEnum.Chan.chan_none;
    private ServiceEnum.Chan source2 = ServiceEnum.Chan.chan_none;
    private ServiceEnum.Chan source3 = ServiceEnum.Chan.chan_none;
    private boolean closeable = true;

    @Bindable
    public final ServiceEnum.WindowType getType() {
        return this.type;
    }

    public final void setType(ServiceEnum.WindowType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.type = value;
        notifyPropertyChanged(978);
    }

    @Bindable
    public final int getServiceID() {
        return this.serviceID;
    }

    public final void setServiceID(int i) {
        this.serviceID = i;
        notifyPropertyChanged(810);
    }

    @Bindable
    public final ServiceEnum.Chan getSource1() {
        return this.source1;
    }

    public final void setSource1(ServiceEnum.Chan value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.source1 = value;
        notifyPropertyChanged(859);
    }

    @Bindable
    public final ServiceEnum.Chan getSource2() {
        return this.source2;
    }

    public final void setSource2(ServiceEnum.Chan value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.source2 = value;
        notifyPropertyChanged(860);
    }

    @Bindable
    public final ServiceEnum.Chan getSource3() {
        return this.source3;
    }

    public final void setSource3(ServiceEnum.Chan value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.source3 = value;
        notifyPropertyChanged(861);
    }

    public final boolean getCloseable() {
        return this.closeable;
    }

    public final void setCloseable(boolean z) {
        this.closeable = z;
    }
}
