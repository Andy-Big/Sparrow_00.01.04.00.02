package javax.jmdns;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;
import javax.jmdns.impl.JmDNSImpl;
/* loaded from: classes2.dex */
public abstract class JmDNS implements Closeable {
    public static String VERSION;

    /* loaded from: classes2.dex */
    public interface Delegate {
        void cannotRecoverFromIOError(JmDNS jmDNS, Collection<ServiceInfo> collection);
    }

    public abstract void addServiceListener(String str, ServiceListener serviceListener);

    public abstract void addServiceTypeListener(ServiceTypeListener serviceTypeListener) throws IOException;

    public abstract Delegate getDelegate();

    public abstract String getHostName();

    public abstract InetAddress getInetAddress() throws IOException;

    @Deprecated
    public abstract InetAddress getInterface() throws IOException;

    public abstract String getName();

    public abstract ServiceInfo getServiceInfo(String str, String str2);

    public abstract ServiceInfo getServiceInfo(String str, String str2, long j);

    public abstract ServiceInfo getServiceInfo(String str, String str2, boolean z);

    public abstract ServiceInfo getServiceInfo(String str, String str2, boolean z, long j);

    public abstract ServiceInfo[] list(String str);

    public abstract ServiceInfo[] list(String str, long j);

    public abstract Map<String, ServiceInfo[]> listBySubtype(String str);

    public abstract Map<String, ServiceInfo[]> listBySubtype(String str, long j);

    @Deprecated
    public abstract void printServices();

    public abstract void registerService(ServiceInfo serviceInfo) throws IOException;

    public abstract boolean registerServiceType(String str);

    public abstract void removeServiceListener(String str, ServiceListener serviceListener);

    public abstract void removeServiceTypeListener(ServiceTypeListener serviceTypeListener);

    public abstract void requestServiceInfo(String str, String str2);

    public abstract void requestServiceInfo(String str, String str2, long j);

    public abstract void requestServiceInfo(String str, String str2, boolean z);

    public abstract void requestServiceInfo(String str, String str2, boolean z, long j);

    public abstract Delegate setDelegate(Delegate delegate);

    public abstract void unregisterAllServices();

    public abstract void unregisterService(ServiceInfo serviceInfo);

    static {
        try {
            InputStream resourceAsStream = JmDNS.class.getClassLoader().getResourceAsStream("version.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            VERSION = properties.getProperty("jmdns.version");
            resourceAsStream.close();
        } catch (Exception unused) {
            VERSION = "VERSION MISSING";
        }
    }

    public static JmDNS create() throws IOException {
        return new JmDNSImpl(null, null);
    }

    public static JmDNS create(InetAddress inetAddress) throws IOException {
        return new JmDNSImpl(inetAddress, null);
    }

    public static JmDNS create(String str) throws IOException {
        return new JmDNSImpl(null, str);
    }

    public static JmDNS create(InetAddress inetAddress, String str, long j) throws IOException {
        return new JmDNSImpl(inetAddress, str, j);
    }

    public static JmDNS create(InetAddress inetAddress, String str) throws IOException {
        return new JmDNSImpl(inetAddress, str, 0L);
    }
}
