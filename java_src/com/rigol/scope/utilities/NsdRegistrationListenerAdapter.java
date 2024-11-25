package com.rigol.scope.utilities;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NsdRegistrationListenerAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/rigol/scope/utilities/NsdRegistrationListenerAdapter;", "Landroid/net/nsd/NsdManager$RegistrationListener;", "()V", "onRegistrationFailed", "", "serviceInfo", "Landroid/net/nsd/NsdServiceInfo;", "errorCode", "", "onServiceRegistered", "NServiceInfo", "onServiceUnregistered", "arg0", "onUnregistrationFailed", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class NsdRegistrationListenerAdapter implements NsdManager.RegistrationListener {
    @Override // android.net.nsd.NsdManager.RegistrationListener
    public void onRegistrationFailed(NsdServiceInfo serviceInfo, int i) {
        Intrinsics.checkNotNullParameter(serviceInfo, "serviceInfo");
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public void onServiceRegistered(NsdServiceInfo NServiceInfo) {
        Intrinsics.checkNotNullParameter(NServiceInfo, "NServiceInfo");
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public void onServiceUnregistered(NsdServiceInfo arg0) {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public void onUnregistrationFailed(NsdServiceInfo serviceInfo, int i) {
        Intrinsics.checkNotNullParameter(serviceInfo, "serviceInfo");
    }
}
