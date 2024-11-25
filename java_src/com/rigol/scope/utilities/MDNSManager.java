package com.rigol.scope.utilities;

import android.os.Looper;
import android.text.TextUtils;
import java.net.InetAddress;
import javax.jmdns.ServiceInfo;
import javax.jmdns.impl.HostInfo;
import javax.jmdns.impl.JmDNSImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MDNSManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0006J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0003R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/rigol/scope/utilities/MDNSManager;", "", "()V", "jmDNS", "Ljavax/jmdns/impl/JmDNSImpl;", "addService", "", "info", "Ljavax/jmdns/ServiceInfo;", "addServiceInternal", "getHostName", "", "init", "ip", "hostName", "initInternal", "isInit", "", "removeAllServices", "removeAllServicesInternal", "update", "updateInternal", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class MDNSManager {
    public static final MDNSManager INSTANCE = new MDNSManager();
    private static JmDNSImpl jmDNS;

    private MDNSManager() {
    }

    public final void init(final String ip, final String hostName) {
        Intrinsics.checkNotNullParameter(ip, "ip");
        Intrinsics.checkNotNullParameter(hostName, "hostName");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            ThreadsKt.thread$default(false, false, null, null, 0, new Function0<Unit>() { // from class: com.rigol.scope.utilities.MDNSManager$init$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MDNSManager.INSTANCE.initInternal(ip, hostName);
                }
            }, 31, null);
        } else {
            initInternal(ip, hostName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initInternal(String str, String str2) {
        InetAddress inetAddress;
        HostInfo localHost;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        JmDNSImpl jmDNSImpl = jmDNS;
        boolean z = true;
        if (jmDNSImpl != null) {
            HostInfo localHost2 = jmDNSImpl.getLocalHost();
            Intrinsics.checkNotNullExpressionValue(localHost2, "it.localHost");
            Intrinsics.checkNotNullExpressionValue(localHost2.getInetAddress(), "it.localHost.inetAddress");
            if (!(!Intrinsics.areEqual(str, inetAddress.getHostName()))) {
                Intrinsics.checkNotNullExpressionValue(jmDNSImpl.getLocalHost(), "it.localHost");
                if (!(!Intrinsics.areEqual(str2, localHost.getName()))) {
                    z = false;
                }
            }
            jmDNSImpl.unregisterAllServices();
            jmDNSImpl.close();
        }
        if (z) {
            jmDNS = new JmDNSImpl(InetAddress.getByName(str), str2);
        }
    }

    public final boolean isInit() {
        return jmDNS != null;
    }

    public final void update(final String ip, final String hostName) {
        Intrinsics.checkNotNullParameter(ip, "ip");
        Intrinsics.checkNotNullParameter(hostName, "hostName");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            ThreadsKt.thread$default(false, false, null, null, 0, new Function0<Unit>() { // from class: com.rigol.scope.utilities.MDNSManager$update$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MDNSManager.INSTANCE.updateInternal(ip, hostName);
                }
            }, 31, null);
        } else {
            updateInternal(ip, hostName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateInternal(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        removeAllServicesInternal();
        initInternal(str, str2);
    }

    public final void addService(final ServiceInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            ThreadsKt.thread$default(false, false, null, null, 0, new Function0<Unit>() { // from class: com.rigol.scope.utilities.MDNSManager$addService$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MDNSManager.INSTANCE.addServiceInternal(ServiceInfo.this);
                }
            }, 31, null);
        } else {
            addServiceInternal(info);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addServiceInternal(ServiceInfo serviceInfo) {
        JmDNSImpl jmDNSImpl = jmDNS;
        if (jmDNSImpl != null) {
            jmDNSImpl.registerService(serviceInfo);
        }
    }

    public final void removeAllServices() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            ThreadsKt.thread$default(false, false, null, null, 0, new Function0<Unit>() { // from class: com.rigol.scope.utilities.MDNSManager$removeAllServices$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MDNSManager.INSTANCE.removeAllServicesInternal();
                }
            }, 31, null);
        } else {
            removeAllServicesInternal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeAllServicesInternal() {
        JmDNSImpl jmDNSImpl = jmDNS;
        if (jmDNSImpl != null) {
            jmDNSImpl.unregisterAllServices();
        }
        JmDNSImpl jmDNSImpl2 = jmDNS;
        if (jmDNSImpl2 != null) {
            jmDNSImpl2.close();
        }
        jmDNS = null;
    }

    public final String getHostName() {
        String hostName;
        JmDNSImpl jmDNSImpl = jmDNS;
        return (jmDNSImpl == null || (hostName = jmDNSImpl.getHostName()) == null) ? "" : hostName;
    }
}
