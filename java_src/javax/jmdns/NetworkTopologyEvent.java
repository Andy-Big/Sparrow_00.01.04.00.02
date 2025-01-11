package javax.jmdns;

import java.net.InetAddress;
import java.util.EventObject;

/* loaded from: classes2.dex */
public abstract class NetworkTopologyEvent extends EventObject {
    private static final long serialVersionUID = -8630033521752540987L;

    public abstract JmDNS getDNS();

    public abstract InetAddress getInetAddress();

    protected NetworkTopologyEvent(Object obj) {
        super(obj);
    }
}
