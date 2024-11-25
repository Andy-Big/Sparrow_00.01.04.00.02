package javax.jmdns;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.concurrent.atomic.AtomicReference;
import javax.jmdns.impl.NetworkTopologyDiscoveryImpl;
/* loaded from: classes2.dex */
public interface NetworkTopologyDiscovery {
    InetAddress[] getInetAddresses();

    void lockInetAddress(InetAddress inetAddress);

    void unlockInetAddress(InetAddress inetAddress);

    boolean useInetAddress(NetworkInterface networkInterface, InetAddress inetAddress);

    /* loaded from: classes2.dex */
    public static final class Factory {
        private static final AtomicReference<ClassDelegate> _databaseClassDelegate = new AtomicReference<>();
        private static volatile NetworkTopologyDiscovery _instance;

        /* loaded from: classes2.dex */
        public interface ClassDelegate {
            NetworkTopologyDiscovery newNetworkTopologyDiscovery();
        }

        private Factory() {
        }

        public static void setClassDelegate(ClassDelegate classDelegate) {
            _databaseClassDelegate.set(classDelegate);
        }

        public static ClassDelegate classDelegate() {
            return _databaseClassDelegate.get();
        }

        protected static NetworkTopologyDiscovery newNetworkTopologyDiscovery() {
            ClassDelegate classDelegate = _databaseClassDelegate.get();
            NetworkTopologyDiscovery newNetworkTopologyDiscovery = classDelegate != null ? classDelegate.newNetworkTopologyDiscovery() : null;
            return newNetworkTopologyDiscovery != null ? newNetworkTopologyDiscovery : new NetworkTopologyDiscoveryImpl();
        }

        public static NetworkTopologyDiscovery getInstance() {
            if (_instance == null) {
                synchronized (Factory.class) {
                    if (_instance == null) {
                        _instance = newNetworkTopologyDiscovery();
                    }
                }
            }
            return _instance;
        }
    }
}
