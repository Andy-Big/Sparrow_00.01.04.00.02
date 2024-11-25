package javax.jmdns;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import javax.jmdns.impl.JmmDNSImpl;
/* loaded from: classes2.dex */
public interface JmmDNS extends Closeable {
    void addNetworkTopologyListener(NetworkTopologyListener networkTopologyListener);

    void addServiceListener(String str, ServiceListener serviceListener);

    void addServiceTypeListener(ServiceTypeListener serviceTypeListener) throws IOException;

    JmDNS[] getDNS();

    String[] getHostNames();

    InetAddress[] getInetAddresses() throws IOException;

    @Deprecated
    InetAddress[] getInterfaces() throws IOException;

    String[] getNames();

    ServiceInfo[] getServiceInfos(String str, String str2);

    ServiceInfo[] getServiceInfos(String str, String str2, long j);

    ServiceInfo[] getServiceInfos(String str, String str2, boolean z);

    ServiceInfo[] getServiceInfos(String str, String str2, boolean z, long j);

    ServiceInfo[] list(String str);

    ServiceInfo[] list(String str, long j);

    Map<String, ServiceInfo[]> listBySubtype(String str);

    Map<String, ServiceInfo[]> listBySubtype(String str, long j);

    NetworkTopologyListener[] networkListeners();

    void registerService(ServiceInfo serviceInfo) throws IOException;

    void registerServiceType(String str);

    void removeNetworkTopologyListener(NetworkTopologyListener networkTopologyListener);

    void removeServiceListener(String str, ServiceListener serviceListener);

    void removeServiceTypeListener(ServiceTypeListener serviceTypeListener);

    void requestServiceInfo(String str, String str2);

    void requestServiceInfo(String str, String str2, long j);

    void requestServiceInfo(String str, String str2, boolean z);

    void requestServiceInfo(String str, String str2, boolean z, long j);

    void unregisterAllServices();

    void unregisterService(ServiceInfo serviceInfo);

    /* loaded from: classes2.dex */
    public static final class Factory {
        private static final AtomicReference<ClassDelegate> _databaseClassDelegate = new AtomicReference<>();
        private static volatile JmmDNS _instance;

        /* loaded from: classes2.dex */
        public interface ClassDelegate {
            JmmDNS newJmmDNS();
        }

        private Factory() {
        }

        public static void setClassDelegate(ClassDelegate classDelegate) {
            _databaseClassDelegate.set(classDelegate);
        }

        public static ClassDelegate classDelegate() {
            return _databaseClassDelegate.get();
        }

        protected static JmmDNS newJmmDNS() {
            ClassDelegate classDelegate = _databaseClassDelegate.get();
            JmmDNS newJmmDNS = classDelegate != null ? classDelegate.newJmmDNS() : null;
            return newJmmDNS != null ? newJmmDNS : new JmmDNSImpl();
        }

        public static JmmDNS getInstance() {
            JmmDNS jmmDNS;
            synchronized (Factory.class) {
                if (_instance == null) {
                    _instance = newJmmDNS();
                }
                jmmDNS = _instance;
            }
            return jmmDNS;
        }

        public static void close() throws IOException {
            synchronized (Factory.class) {
                _instance.close();
                _instance = null;
            }
        }
    }
}
