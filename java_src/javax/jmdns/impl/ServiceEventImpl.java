package javax.jmdns.impl;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
/* loaded from: classes2.dex */
public class ServiceEventImpl extends ServiceEvent {
    private static final long serialVersionUID = 7107973622016897488L;
    private final ServiceInfo _info;
    private final String _name;
    private final String _type;

    public ServiceEventImpl(JmDNSImpl jmDNSImpl, String str, String str2, ServiceInfo serviceInfo) {
        super(jmDNSImpl);
        this._type = str;
        this._name = str2;
        this._info = serviceInfo;
    }

    @Override // javax.jmdns.ServiceEvent
    public JmDNS getDNS() {
        return (JmDNS) getSource();
    }

    @Override // javax.jmdns.ServiceEvent
    public String getType() {
        return this._type;
    }

    @Override // javax.jmdns.ServiceEvent
    public String getName() {
        return this._name;
    }

    @Override // java.util.EventObject
    public String toString() {
        return '[' + getClass().getSimpleName() + '@' + System.identityHashCode(this) + "\n\tname: '" + getName() + "' type: '" + getType() + "' info: '" + getInfo() + "']";
    }

    @Override // javax.jmdns.ServiceEvent
    public ServiceInfo getInfo() {
        return this._info;
    }

    @Override // javax.jmdns.ServiceEvent
    /* renamed from: clone */
    public ServiceEventImpl mo19clone() {
        return new ServiceEventImpl((JmDNSImpl) getDNS(), getType(), getName(), new ServiceInfoImpl(getInfo()));
    }
}
