package javax.jmdns.impl;

import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.jmdns.ServiceTypeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* loaded from: classes2.dex */
public class ListenerStatus<T extends EventListener> {
    public static final boolean ASYNCHRONOUS = false;
    public static final boolean SYNCHRONOUS = true;
    private final T _listener;
    private final boolean _synch;

    /* loaded from: classes2.dex */
    public static class ServiceListenerStatus extends ListenerStatus<ServiceListener> {
        private static Logger logger = LoggerFactory.getLogger(ServiceListenerStatus.class.getName());
        private final ConcurrentMap<String, ServiceInfo> _addedServices;

        public ServiceListenerStatus(ServiceListener serviceListener, boolean z) {
            super(serviceListener, z);
            this._addedServices = new ConcurrentHashMap(32);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void serviceAdded(ServiceEvent serviceEvent) {
            if (this._addedServices.putIfAbsent(serviceEvent.getName() + "." + serviceEvent.getType(), serviceEvent.getInfo().clone()) == null) {
                getListener().serviceAdded(serviceEvent);
                ServiceInfo info = serviceEvent.getInfo();
                if (info == null || !info.hasData()) {
                    return;
                }
                getListener().serviceResolved(serviceEvent);
                return;
            }
            logger.debug("Service Added called for a service already added: {}", serviceEvent);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void serviceRemoved(ServiceEvent serviceEvent) {
            String str = serviceEvent.getName() + "." + serviceEvent.getType();
            ConcurrentMap<String, ServiceInfo> concurrentMap = this._addedServices;
            if (concurrentMap.remove(str, concurrentMap.get(str))) {
                getListener().serviceRemoved(serviceEvent);
            } else {
                logger.debug("Service Removed called for a service already removed: {}", serviceEvent);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public synchronized void serviceResolved(ServiceEvent serviceEvent) {
            ServiceInfo info = serviceEvent.getInfo();
            if (info != null && info.hasData()) {
                String str = serviceEvent.getName() + "." + serviceEvent.getType();
                ServiceInfo serviceInfo = this._addedServices.get(str);
                if (_sameInfo(info, serviceInfo)) {
                    logger.debug("Service Resolved called for a service already resolved: {}", serviceEvent);
                } else if (serviceInfo == null) {
                    if (this._addedServices.putIfAbsent(str, info.clone()) == null) {
                        getListener().serviceResolved(serviceEvent);
                    }
                } else if (this._addedServices.replace(str, serviceInfo, info.clone())) {
                    getListener().serviceResolved(serviceEvent);
                }
            } else {
                logger.warn("Service Resolved called for an unresolved event: {}", serviceEvent);
            }
        }

        private static final boolean _sameInfo(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) {
            if (serviceInfo == null || serviceInfo2 == null || !serviceInfo.equals(serviceInfo2)) {
                return false;
            }
            byte[] textBytes = serviceInfo.getTextBytes();
            byte[] textBytes2 = serviceInfo2.getTextBytes();
            if (textBytes.length != textBytes2.length) {
                return false;
            }
            for (int i = 0; i < textBytes.length; i++) {
                if (textBytes[i] != textBytes2[i]) {
                    return false;
                }
            }
            return serviceInfo.hasSameAddresses(serviceInfo2);
        }

        @Override // javax.jmdns.impl.ListenerStatus
        public String toString() {
            StringBuilder sb = new StringBuilder(2048);
            sb.append("[Status for ");
            sb.append(getListener().toString());
            if (this._addedServices.isEmpty()) {
                sb.append(" no type event ");
            } else {
                sb.append(" (");
                Iterator<String> it = this._addedServices.keySet().iterator();
                while (it.hasNext()) {
                    sb.append(it.next() + ", ");
                }
                sb.append(") ");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    public static class ServiceTypeListenerStatus extends ListenerStatus<ServiceTypeListener> {
        private static Logger logger = LoggerFactory.getLogger(ServiceTypeListenerStatus.class.getName());
        private final ConcurrentMap<String, String> _addedTypes;

        public ServiceTypeListenerStatus(ServiceTypeListener serviceTypeListener, boolean z) {
            super(serviceTypeListener, z);
            this._addedTypes = new ConcurrentHashMap(32);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void serviceTypeAdded(ServiceEvent serviceEvent) {
            if (this._addedTypes.putIfAbsent(serviceEvent.getType(), serviceEvent.getType()) == null) {
                getListener().serviceTypeAdded(serviceEvent);
            } else {
                logger.trace("Service Type Added called for a service type already added: {}", serviceEvent);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void subTypeForServiceTypeAdded(ServiceEvent serviceEvent) {
            if (this._addedTypes.putIfAbsent(serviceEvent.getType(), serviceEvent.getType()) == null) {
                getListener().subTypeForServiceTypeAdded(serviceEvent);
            } else {
                logger.trace("Service Sub Type Added called for a service sub type already added: {}", serviceEvent);
            }
        }

        @Override // javax.jmdns.impl.ListenerStatus
        public String toString() {
            StringBuilder sb = new StringBuilder(2048);
            sb.append("[Status for ");
            sb.append(getListener().toString());
            if (this._addedTypes.isEmpty()) {
                sb.append(" no type event ");
            } else {
                sb.append(" (");
                Iterator<String> it = this._addedTypes.keySet().iterator();
                while (it.hasNext()) {
                    sb.append(it.next() + ", ");
                }
                sb.append(") ");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public ListenerStatus(T t, boolean z) {
        this._listener = t;
        this._synch = z;
    }

    public T getListener() {
        return this._listener;
    }

    public boolean isSynchronous() {
        return this._synch;
    }

    public int hashCode() {
        return getListener().hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof ListenerStatus) && getListener().equals(((ListenerStatus) obj).getListener());
    }

    public String toString() {
        return "[Status for " + getListener().toString() + "]";
    }
}
