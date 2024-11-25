package javax.jmdns.impl;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import javax.jmdns.NetworkTopologyDiscovery;
import javax.jmdns.impl.DNSRecord;
import javax.jmdns.impl.DNSStatefulObject;
import javax.jmdns.impl.NameRegister;
import javax.jmdns.impl.constants.DNSConstants;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;
import javax.jmdns.impl.constants.DNSState;
import javax.jmdns.impl.tasks.DNSTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* loaded from: classes2.dex */
public class HostInfo implements DNSStatefulObject {
    private static Logger logger = LoggerFactory.getLogger(HostInfo.class.getName());
    protected InetAddress _address;
    protected NetworkInterface _interfaze;
    protected String _name;
    private final HostInfoState _state;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class HostInfoState extends DNSStatefulObject.DefaultImplementation {
        private static final long serialVersionUID = -8191476803620402088L;

        public HostInfoState(JmDNSImpl jmDNSImpl) {
            setDns(jmDNSImpl);
        }
    }

    public static HostInfo newHostInfo(InetAddress inetAddress, JmDNSImpl jmDNSImpl, String str) {
        InetAddress localHost;
        String str2 = str != null ? str : "";
        if (inetAddress == null) {
            try {
                String property = System.getProperty("net.mdns.interface");
                if (property != null) {
                    localHost = InetAddress.getByName(property);
                } else {
                    localHost = InetAddress.getLocalHost();
                    if (localHost.isLoopbackAddress()) {
                        InetAddress[] inetAddresses = NetworkTopologyDiscovery.Factory.getInstance().getInetAddresses();
                        if (inetAddresses.length > 0) {
                            localHost = inetAddresses[0];
                        }
                    }
                }
                if (localHost.isLoopbackAddress()) {
                    logger.warn("Could not find any address beside the loopback.");
                }
            } catch (IOException e) {
                Logger logger2 = logger;
                logger2.warn("Could not initialize the host network interface on " + inetAddress + "because of an error: " + e.getMessage(), (Throwable) e);
                localHost = loopbackAddress();
                if (str == null || str.length() <= 0) {
                    str = "computer";
                }
            }
        } else {
            localHost = inetAddress;
        }
        if (str2.length() == 0) {
            str2 = localHost.getHostName();
        }
        if (str2.contains("in-addr.arpa") || str2.equals(localHost.getHostAddress())) {
            if (str == null || str.length() <= 0) {
                str = localHost.getHostAddress();
            }
            str2 = str;
        }
        int indexOf = str2.indexOf(".local");
        if (indexOf > 0) {
            str2 = str2.substring(0, indexOf);
        }
        String replaceAll = str2.replaceAll("[:%\\.]", "-");
        return new HostInfo(localHost, replaceAll + ".local.", jmDNSImpl);
    }

    private static InetAddress loopbackAddress() {
        try {
            return InetAddress.getByName(null);
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    private HostInfo(InetAddress inetAddress, String str, JmDNSImpl jmDNSImpl) {
        this._state = new HostInfoState(jmDNSImpl);
        this._address = inetAddress;
        this._name = str;
        if (inetAddress != null) {
            try {
                this._interfaze = NetworkInterface.getByInetAddress(inetAddress);
            } catch (Exception e) {
                logger.warn("LocalHostInfo() exception ", (Throwable) e);
            }
        }
    }

    public String getName() {
        return this._name;
    }

    public InetAddress getInetAddress() {
        return this._address;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Inet4Address getInet4Address() {
        if (getInetAddress() instanceof Inet4Address) {
            return (Inet4Address) this._address;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Inet6Address getInet6Address() {
        if (getInetAddress() instanceof Inet6Address) {
            return (Inet6Address) this._address;
        }
        return null;
    }

    public NetworkInterface getInterface() {
        return this._interfaze;
    }

    public boolean conflictWithRecord(DNSRecord.Address address) {
        DNSRecord.Address dNSAddressRecord = getDNSAddressRecord(address.getRecordType(), address.isUnique(), DNSConstants.DNS_TTL);
        return dNSAddressRecord != null && dNSAddressRecord.sameType(address) && dNSAddressRecord.sameName(address) && !dNSAddressRecord.sameValue(address);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String incrementHostName() {
        String incrementName;
        incrementName = NameRegister.Factory.getRegistry().incrementName(getInetAddress(), this._name, NameRegister.NameType.HOST);
        this._name = incrementName;
        return incrementName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean shouldIgnorePacket(DatagramPacket datagramPacket) {
        InetAddress address;
        boolean z = false;
        if (getInetAddress() != null && (address = datagramPacket.getAddress()) != null) {
            if ((getInetAddress().isLinkLocalAddress() || getInetAddress().isMCLinkLocal()) && !address.isLinkLocalAddress()) {
                z = true;
            }
            if (address.isLoopbackAddress() && !getInetAddress().isLoopbackAddress()) {
                return true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: javax.jmdns.impl.HostInfo$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$javax$jmdns$impl$constants$DNSRecordType;

        static {
            int[] iArr = new int[DNSRecordType.values().length];
            $SwitchMap$javax$jmdns$impl$constants$DNSRecordType = iArr;
            try {
                iArr[DNSRecordType.TYPE_A.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$javax$jmdns$impl$constants$DNSRecordType[DNSRecordType.TYPE_A6.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$javax$jmdns$impl$constants$DNSRecordType[DNSRecordType.TYPE_AAAA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DNSRecord.Address getDNSAddressRecord(DNSRecordType dNSRecordType, boolean z, int i) {
        int i2 = AnonymousClass1.$SwitchMap$javax$jmdns$impl$constants$DNSRecordType[dNSRecordType.ordinal()];
        if (i2 != 1) {
            if (i2 == 2 || i2 == 3) {
                return getDNS6AddressRecord(z, i);
            }
            return null;
        }
        return getDNS4AddressRecord(z, i);
    }

    private DNSRecord.Address getDNS4AddressRecord(boolean z, int i) {
        if (getInetAddress() instanceof Inet4Address) {
            return new DNSRecord.IPv4Address(getName(), DNSRecordClass.CLASS_IN, z, i, getInetAddress());
        }
        return null;
    }

    private DNSRecord.Address getDNS6AddressRecord(boolean z, int i) {
        if (getInetAddress() instanceof Inet6Address) {
            return new DNSRecord.IPv6Address(getName(), DNSRecordClass.CLASS_IN, z, i, getInetAddress());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DNSRecord.Pointer getDNSReverseAddressRecord(DNSRecordType dNSRecordType, boolean z, int i) {
        int i2 = AnonymousClass1.$SwitchMap$javax$jmdns$impl$constants$DNSRecordType[dNSRecordType.ordinal()];
        if (i2 != 1) {
            if (i2 == 2 || i2 == 3) {
                return getDNS6ReverseAddressRecord(z, i);
            }
            return null;
        }
        return getDNS4ReverseAddressRecord(z, i);
    }

    private DNSRecord.Pointer getDNS4ReverseAddressRecord(boolean z, int i) {
        if (getInetAddress() instanceof Inet4Address) {
            return new DNSRecord.Pointer(getInetAddress().getHostAddress() + ".in-addr.arpa.", DNSRecordClass.CLASS_IN, z, i, getName());
        }
        return null;
    }

    private DNSRecord.Pointer getDNS6ReverseAddressRecord(boolean z, int i) {
        if (getInetAddress() instanceof Inet6Address) {
            return new DNSRecord.Pointer(getInetAddress().getHostAddress() + ".ip6.arpa.", DNSRecordClass.CLASS_IN, z, i, getName());
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(1024);
        sb.append("local host info[");
        sb.append(getName() != null ? getName() : "no name");
        sb.append(", ");
        sb.append(getInterface() != null ? getInterface().getDisplayName() : "???");
        sb.append(":");
        sb.append(getInetAddress() != null ? getInetAddress().getHostAddress() : "no address");
        sb.append(", ");
        sb.append(this._state);
        sb.append("]");
        return sb.toString();
    }

    public Collection<DNSRecord> answers(DNSRecordClass dNSRecordClass, boolean z, int i) {
        ArrayList arrayList = new ArrayList();
        DNSRecord.Address dNS4AddressRecord = getDNS4AddressRecord(z, i);
        if (dNS4AddressRecord != null && dNS4AddressRecord.matchRecordClass(dNSRecordClass)) {
            arrayList.add(dNS4AddressRecord);
        }
        DNSRecord.Address dNS6AddressRecord = getDNS6AddressRecord(z, i);
        if (dNS6AddressRecord != null && dNS6AddressRecord.matchRecordClass(dNSRecordClass)) {
            arrayList.add(dNS6AddressRecord);
        }
        return arrayList;
    }

    @Override // javax.jmdns.impl.DNSStatefulObject
    public JmDNSImpl getDns() {
        return this._state.getDns();
    }

    @Override // javax.jmdns.impl.DNSStatefulObject
    public boolean advanceState(DNSTask dNSTask) {
        return this._state.advanceState(dNSTask);
    }

    @Override // javax.jmdns.impl.DNSStatefulObject
    public void removeAssociationWithTask(DNSTask dNSTask) {
        this._state.removeAssociationWithTask(dNSTask);
    }

    @Override // javax.jmdns.impl.DNSStatefulObject
    public boolean revertState() {
        return this._state.revertState();
    }

    @Override // javax.jmdns.impl.DNSStatefulObject
    public void associateWithTask(DNSTask dNSTask, DNSState dNSState) {
        this._state.associateWithTask(dNSTask, dNSState);
    }

    @Override // javax.jmdns.impl.DNSStatefulObject
    public boolean isAssociatedWithTask(DNSTask dNSTask, DNSState dNSState) {
        return this._state.isAssociatedWithTask(dNSTask, dNSState);
    }

    @Override // javax.jmdns.impl.DNSStatefulObject
    public boolean cancelState() {
        return this._state.cancelState();
    }

    @Override // javax.jmdns.impl.DNSStatefulObject
    public boolean closeState() {
        return this._state.closeState();
    }

    @Override // javax.jmdns.impl.DNSStatefulObject
    public boolean recoverState() {
        return this._state.recoverState();
    }

    @Override // javax.jmdns.impl.DNSStatefulObject
    public boolean isProbing() {
        return this._state.isProbing();
    }

    @Override // javax.jmdns.impl.DNSStatefulObject
    public boolean isAnnouncing() {
        return this._state.isAnnouncing();
    }

    @Override // javax.jmdns.impl.DNSStatefulObject
    public boolean isAnnounced() {
        return this._state.isAnnounced();
    }

    @Override // javax.jmdns.impl.DNSStatefulObject
    public boolean isCanceling() {
        return this._state.isCanceling();
    }

    @Override // javax.jmdns.impl.DNSStatefulObject
    public boolean isCanceled() {
        return this._state.isCanceled();
    }

    @Override // javax.jmdns.impl.DNSStatefulObject
    public boolean isClosing() {
        return this._state.isClosing();
    }

    @Override // javax.jmdns.impl.DNSStatefulObject
    public boolean isClosed() {
        return this._state.isClosed();
    }

    @Override // javax.jmdns.impl.DNSStatefulObject
    public boolean waitForAnnounced(long j) {
        return this._state.waitForAnnounced(j);
    }

    @Override // javax.jmdns.impl.DNSStatefulObject
    public boolean waitForCanceled(long j) {
        if (this._address == null) {
            return true;
        }
        return this._state.waitForCanceled(j);
    }
}
