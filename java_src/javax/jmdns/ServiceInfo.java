package javax.jmdns;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Enumeration;
import java.util.Map;
import javax.jmdns.impl.ServiceInfoImpl;
/* loaded from: classes2.dex */
public abstract class ServiceInfo implements Cloneable {

    /* loaded from: classes2.dex */
    public enum Fields {
        Domain,
        Protocol,
        Application,
        Instance,
        Subtype
    }

    @Deprecated
    public abstract InetAddress getAddress();

    public abstract String getApplication();

    public abstract String getDomain();

    @Deprecated
    public abstract String getHostAddress();

    public abstract String[] getHostAddresses();

    @Deprecated
    public abstract Inet4Address getInet4Address();

    public abstract Inet4Address[] getInet4Addresses();

    @Deprecated
    public abstract Inet6Address getInet6Address();

    public abstract Inet6Address[] getInet6Addresses();

    @Deprecated
    public abstract InetAddress getInetAddress();

    public abstract InetAddress[] getInetAddresses();

    public abstract String getKey();

    public abstract String getName();

    public abstract String getNiceTextString();

    public abstract int getPort();

    public abstract int getPriority();

    public abstract byte[] getPropertyBytes(String str);

    public abstract Enumeration<String> getPropertyNames();

    public abstract String getPropertyString(String str);

    public abstract String getProtocol();

    public abstract String getQualifiedName();

    public abstract Map<Fields, String> getQualifiedNameMap();

    public abstract String getServer();

    public abstract String getSubtype();

    public abstract byte[] getTextBytes();

    @Deprecated
    public abstract String getTextString();

    public abstract String getType();

    public abstract String getTypeWithSubtype();

    @Deprecated
    public abstract String getURL();

    @Deprecated
    public abstract String getURL(String str);

    public abstract String[] getURLs();

    public abstract String[] getURLs(String str);

    public abstract int getWeight();

    public abstract boolean hasData();

    public abstract boolean hasSameAddresses(ServiceInfo serviceInfo);

    public abstract boolean hasServer();

    public abstract boolean isPersistent();

    public abstract void setText(Map<String, ?> map) throws IllegalStateException;

    public abstract void setText(byte[] bArr) throws IllegalStateException;

    public static ServiceInfo create(String str, String str2, int i, String str3) {
        return new ServiceInfoImpl(str, str2, "", i, 0, 0, false, str3);
    }

    public static ServiceInfo create(String str, String str2, String str3, int i, String str4) {
        return new ServiceInfoImpl(str, str2, str3, i, 0, 0, false, str4);
    }

    public static ServiceInfo create(String str, String str2, int i, int i2, int i3, String str3) {
        return new ServiceInfoImpl(str, str2, "", i, i2, i3, false, str3);
    }

    public static ServiceInfo create(String str, String str2, String str3, int i, int i2, int i3, String str4) {
        return new ServiceInfoImpl(str, str2, str3, i, i2, i3, false, str4);
    }

    public static ServiceInfo create(String str, String str2, int i, int i2, int i3, Map<String, ?> map) {
        return new ServiceInfoImpl(str, str2, "", i, i2, i3, false, map);
    }

    public static ServiceInfo create(String str, String str2, String str3, int i, int i2, int i3, Map<String, ?> map) {
        return new ServiceInfoImpl(str, str2, str3, i, i2, i3, false, map);
    }

    public static ServiceInfo create(String str, String str2, int i, int i2, int i3, byte[] bArr) {
        return new ServiceInfoImpl(str, str2, "", i, i2, i3, false, bArr);
    }

    public static ServiceInfo create(String str, String str2, String str3, int i, int i2, int i3, byte[] bArr) {
        return new ServiceInfoImpl(str, str2, str3, i, i2, i3, false, bArr);
    }

    public static ServiceInfo create(String str, String str2, int i, int i2, int i3, boolean z, String str3) {
        return new ServiceInfoImpl(str, str2, "", i, i2, i3, z, str3);
    }

    public static ServiceInfo create(String str, String str2, String str3, int i, int i2, int i3, boolean z, String str4) {
        return new ServiceInfoImpl(str, str2, str3, i, i2, i3, z, str4);
    }

    public static ServiceInfo create(String str, String str2, int i, int i2, int i3, boolean z, Map<String, ?> map) {
        return new ServiceInfoImpl(str, str2, "", i, i2, i3, z, map);
    }

    public static ServiceInfo create(String str, String str2, String str3, int i, int i2, int i3, boolean z, Map<String, ?> map) {
        return new ServiceInfoImpl(str, str2, str3, i, i2, i3, z, map);
    }

    public static ServiceInfo create(String str, String str2, int i, int i2, int i3, boolean z, byte[] bArr) {
        return new ServiceInfoImpl(str, str2, "", i, i2, i3, z, bArr);
    }

    public static ServiceInfo create(String str, String str2, String str3, int i, int i2, int i3, boolean z, byte[] bArr) {
        return new ServiceInfoImpl(str, str2, str3, i, i2, i3, z, bArr);
    }

    public static ServiceInfo create(Map<Fields, String> map, int i, int i2, int i3, boolean z, Map<String, ?> map2) {
        return new ServiceInfoImpl(map, i, i2, i3, z, map2);
    }

    @Override // 
    public ServiceInfo clone() {
        try {
            return (ServiceInfo) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
