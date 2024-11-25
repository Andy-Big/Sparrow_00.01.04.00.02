package javax.jmdns.impl;

import com.sun.mail.imap.IMAPStore;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.impl.DNSOutgoing;
import javax.jmdns.impl.NameRegister;
import javax.jmdns.impl.constants.DNSConstants;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;
import javax.jmdns.impl.util.ByteWrangler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* loaded from: classes2.dex */
public abstract class DNSRecord extends DNSEntry {
    private static Logger logger = LoggerFactory.getLogger(DNSRecord.class.getName());
    private long _created;
    private int _isStaleAndShouldBeRefreshedPercentage;
    private final int _randomStaleRefreshOffset;
    private InetAddress _source;
    private int _ttl;

    abstract DNSOutgoing addAnswer(JmDNSImpl jmDNSImpl, DNSIncoming dNSIncoming, InetAddress inetAddress, int i, DNSOutgoing dNSOutgoing) throws IOException;

    public abstract ServiceEvent getServiceEvent(JmDNSImpl jmDNSImpl);

    public abstract ServiceInfo getServiceInfo(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean handleQuery(JmDNSImpl jmDNSImpl, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean handleResponse(JmDNSImpl jmDNSImpl);

    public abstract boolean isSingleValued();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean sameValue(DNSRecord dNSRecord);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void write(DNSOutgoing.MessageOutputStream messageOutputStream);

    DNSRecord(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z, int i) {
        super(str, dNSRecordType, dNSRecordClass, z);
        this._ttl = i;
        this._created = System.currentTimeMillis();
        int nextInt = new Random().nextInt(3);
        this._randomStaleRefreshOffset = nextInt;
        this._isStaleAndShouldBeRefreshedPercentage = nextInt + 80;
    }

    @Override // javax.jmdns.impl.DNSEntry
    public boolean equals(Object obj) {
        return (obj instanceof DNSRecord) && super.equals(obj) && sameValue((DNSRecord) obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sameType(DNSRecord dNSRecord) {
        return getRecordType() == dNSRecord.getRecordType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean suppressedBy(DNSIncoming dNSIncoming) {
        try {
            for (DNSRecord dNSRecord : dNSIncoming.getAllAnswers()) {
                if (suppressedBy(dNSRecord)) {
                    return true;
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            Logger logger2 = logger;
            logger2.warn("suppressedBy() message " + dNSIncoming + " exception ", (Throwable) e);
            return false;
        }
    }

    boolean suppressedBy(DNSRecord dNSRecord) {
        return equals(dNSRecord) && dNSRecord._ttl > this._ttl / 2;
    }

    long getExpirationTime(int i) {
        return this._created + (i * this._ttl * 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getRemainingTTL(long j) {
        return (int) Math.max(0L, (getExpirationTime(100) - j) / 1000);
    }

    @Override // javax.jmdns.impl.DNSEntry
    public boolean isExpired(long j) {
        return getExpirationTime(100) <= j;
    }

    @Override // javax.jmdns.impl.DNSEntry
    public boolean isStale(long j) {
        return getExpirationTime(50) <= j;
    }

    public boolean isStaleAndShouldBeRefreshed(long j) {
        return getExpirationTime(this._isStaleAndShouldBeRefreshedPercentage) <= j;
    }

    public void incrementRefreshPercentage() {
        int i = this._isStaleAndShouldBeRefreshedPercentage + 5;
        this._isStaleAndShouldBeRefreshedPercentage = i;
        if (i > 100) {
            this._isStaleAndShouldBeRefreshedPercentage = 100;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetTTL(DNSRecord dNSRecord) {
        this._created = dNSRecord._created;
        this._ttl = dNSRecord._ttl;
        this._isStaleAndShouldBeRefreshedPercentage = this._randomStaleRefreshOffset + 80;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWillExpireSoon(long j) {
        this._created = j;
        this._ttl = 1;
    }

    /* loaded from: classes2.dex */
    public static class IPv4Address extends Address {
        /* JADX INFO: Access modifiers changed from: package-private */
        public IPv4Address(String str, DNSRecordClass dNSRecordClass, boolean z, int i, InetAddress inetAddress) {
            super(str, DNSRecordType.TYPE_A, dNSRecordClass, z, i, inetAddress);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public IPv4Address(String str, DNSRecordClass dNSRecordClass, boolean z, int i, byte[] bArr) {
            super(str, DNSRecordType.TYPE_A, dNSRecordClass, z, i, bArr);
        }

        @Override // javax.jmdns.impl.DNSRecord
        void write(DNSOutgoing.MessageOutputStream messageOutputStream) {
            if (this._addr != null) {
                byte[] address = this._addr.getAddress();
                if (!(this._addr instanceof Inet4Address)) {
                    byte[] bArr = new byte[4];
                    System.arraycopy(address, 12, bArr, 0, 4);
                    address = bArr;
                }
                messageOutputStream.writeBytes(address, 0, address.length);
            }
        }

        @Override // javax.jmdns.impl.DNSRecord.Address, javax.jmdns.impl.DNSRecord
        public ServiceInfo getServiceInfo(boolean z) {
            ServiceInfoImpl serviceInfoImpl = (ServiceInfoImpl) super.getServiceInfo(z);
            serviceInfoImpl.addAddress((Inet4Address) this._addr);
            return serviceInfoImpl;
        }
    }

    /* loaded from: classes2.dex */
    public static class IPv6Address extends Address {
        /* JADX INFO: Access modifiers changed from: package-private */
        public IPv6Address(String str, DNSRecordClass dNSRecordClass, boolean z, int i, InetAddress inetAddress) {
            super(str, DNSRecordType.TYPE_AAAA, dNSRecordClass, z, i, inetAddress);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public IPv6Address(String str, DNSRecordClass dNSRecordClass, boolean z, int i, byte[] bArr) {
            super(str, DNSRecordType.TYPE_AAAA, dNSRecordClass, z, i, bArr);
        }

        @Override // javax.jmdns.impl.DNSRecord
        void write(DNSOutgoing.MessageOutputStream messageOutputStream) {
            if (this._addr != null) {
                byte[] address = this._addr.getAddress();
                if (this._addr instanceof Inet4Address) {
                    byte[] bArr = new byte[16];
                    for (int i = 0; i < 16; i++) {
                        if (i < 11) {
                            bArr[i] = address[i - 12];
                        } else {
                            bArr[i] = 0;
                        }
                    }
                    address = bArr;
                }
                messageOutputStream.writeBytes(address, 0, address.length);
            }
        }

        @Override // javax.jmdns.impl.DNSRecord.Address, javax.jmdns.impl.DNSRecord
        public ServiceInfo getServiceInfo(boolean z) {
            ServiceInfoImpl serviceInfoImpl = (ServiceInfoImpl) super.getServiceInfo(z);
            serviceInfoImpl.addAddress((Inet6Address) this._addr);
            return serviceInfoImpl;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Address extends DNSRecord {
        private static Logger logger1 = LoggerFactory.getLogger(Address.class.getName());
        InetAddress _addr;

        @Override // javax.jmdns.impl.DNSRecord
        DNSOutgoing addAnswer(JmDNSImpl jmDNSImpl, DNSIncoming dNSIncoming, InetAddress inetAddress, int i, DNSOutgoing dNSOutgoing) throws IOException {
            return dNSOutgoing;
        }

        @Override // javax.jmdns.impl.DNSRecord
        public boolean isSingleValued() {
            return false;
        }

        protected Address(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z, int i, InetAddress inetAddress) {
            super(str, dNSRecordType, dNSRecordClass, z, i);
            this._addr = inetAddress;
        }

        protected Address(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z, int i, byte[] bArr) {
            super(str, dNSRecordType, dNSRecordClass, z, i);
            try {
                this._addr = InetAddress.getByAddress(bArr);
            } catch (UnknownHostException e) {
                logger1.warn("Address() exception ", (Throwable) e);
            }
        }

        boolean same(DNSRecord dNSRecord) {
            return (dNSRecord instanceof Address) && sameName(dNSRecord) && sameValue(dNSRecord);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean sameName(DNSRecord dNSRecord) {
            return getName().equalsIgnoreCase(dNSRecord.getName());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // javax.jmdns.impl.DNSRecord
        public boolean sameValue(DNSRecord dNSRecord) {
            try {
                if (dNSRecord instanceof Address) {
                    Address address = (Address) dNSRecord;
                    if (getAddress() != null || address.getAddress() == null) {
                        return getAddress().equals(address.getAddress());
                    }
                    return false;
                }
                return false;
            } catch (Exception e) {
                logger1.info("Failed to compare addresses of DNSRecords", (Throwable) e);
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public InetAddress getAddress() {
            return this._addr;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // javax.jmdns.impl.DNSEntry
        public void toByteArray(DataOutputStream dataOutputStream) throws IOException {
            super.toByteArray(dataOutputStream);
            for (byte b : getAddress().getAddress()) {
                dataOutputStream.writeByte(b);
            }
        }

        @Override // javax.jmdns.impl.DNSRecord
        boolean handleQuery(JmDNSImpl jmDNSImpl, long j) {
            Address dNSAddressRecord;
            if (!jmDNSImpl.getLocalHost().conflictWithRecord(this) || (dNSAddressRecord = jmDNSImpl.getLocalHost().getDNSAddressRecord(getRecordType(), isUnique(), DNSConstants.DNS_TTL)) == null) {
                return false;
            }
            int compareTo = compareTo(dNSAddressRecord);
            if (compareTo == 0) {
                logger1.debug("handleQuery() Ignoring an identical address query");
                return false;
            }
            logger1.debug("handleQuery() Conflicting query detected.");
            if (jmDNSImpl.isProbing() && compareTo > 0) {
                jmDNSImpl.getLocalHost().incrementHostName();
                jmDNSImpl.getCache().clear();
                Iterator<ServiceInfo> it = jmDNSImpl.getServices().values().iterator();
                while (it.hasNext()) {
                    ((ServiceInfoImpl) it.next()).revertState();
                }
            }
            jmDNSImpl.revertState();
            return true;
        }

        @Override // javax.jmdns.impl.DNSRecord
        boolean handleResponse(JmDNSImpl jmDNSImpl) {
            if (jmDNSImpl.getLocalHost().conflictWithRecord(this)) {
                logger1.debug("handleResponse() Denial detected");
                if (jmDNSImpl.isProbing()) {
                    jmDNSImpl.getLocalHost().incrementHostName();
                    jmDNSImpl.getCache().clear();
                    Iterator<ServiceInfo> it = jmDNSImpl.getServices().values().iterator();
                    while (it.hasNext()) {
                        ((ServiceInfoImpl) it.next()).revertState();
                    }
                }
                jmDNSImpl.revertState();
                return true;
            }
            return false;
        }

        @Override // javax.jmdns.impl.DNSRecord
        public ServiceInfo getServiceInfo(boolean z) {
            return new ServiceInfoImpl(getQualifiedNameMap(), 0, 0, 0, z, (byte[]) null);
        }

        @Override // javax.jmdns.impl.DNSRecord
        public ServiceEvent getServiceEvent(JmDNSImpl jmDNSImpl) {
            ServiceInfo serviceInfo = getServiceInfo(false);
            ((ServiceInfoImpl) serviceInfo).setDns(jmDNSImpl);
            return new ServiceEventImpl(jmDNSImpl, serviceInfo.getType(), serviceInfo.getName(), serviceInfo);
        }

        @Override // javax.jmdns.impl.DNSRecord, javax.jmdns.impl.DNSEntry
        protected void toString(StringBuilder sb) {
            super.toString(sb);
            sb.append(" address: '");
            sb.append(getAddress() != null ? getAddress().getHostAddress() : "null");
            sb.append('\'');
        }
    }

    /* loaded from: classes2.dex */
    public static class Pointer extends DNSRecord {
        private final String _alias;

        @Override // javax.jmdns.impl.DNSRecord
        DNSOutgoing addAnswer(JmDNSImpl jmDNSImpl, DNSIncoming dNSIncoming, InetAddress inetAddress, int i, DNSOutgoing dNSOutgoing) throws IOException {
            return dNSOutgoing;
        }

        @Override // javax.jmdns.impl.DNSRecord
        boolean handleQuery(JmDNSImpl jmDNSImpl, long j) {
            return false;
        }

        @Override // javax.jmdns.impl.DNSRecord
        boolean handleResponse(JmDNSImpl jmDNSImpl) {
            return false;
        }

        @Override // javax.jmdns.impl.DNSRecord
        public boolean isSingleValued() {
            return false;
        }

        public Pointer(String str, DNSRecordClass dNSRecordClass, boolean z, int i, String str2) {
            super(str, DNSRecordType.TYPE_PTR, dNSRecordClass, z, i);
            this._alias = str2;
        }

        @Override // javax.jmdns.impl.DNSEntry
        public boolean isSameEntry(DNSEntry dNSEntry) {
            return super.isSameEntry(dNSEntry) && (dNSEntry instanceof Pointer) && sameValue((Pointer) dNSEntry);
        }

        @Override // javax.jmdns.impl.DNSRecord
        void write(DNSOutgoing.MessageOutputStream messageOutputStream) {
            messageOutputStream.writeName(this._alias);
        }

        @Override // javax.jmdns.impl.DNSRecord
        boolean sameValue(DNSRecord dNSRecord) {
            if (dNSRecord instanceof Pointer) {
                Pointer pointer = (Pointer) dNSRecord;
                if (this._alias != null || pointer._alias == null) {
                    return this._alias.equals(pointer._alias);
                }
                return false;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getAlias() {
            return this._alias;
        }

        @Override // javax.jmdns.impl.DNSRecord
        public ServiceInfo getServiceInfo(boolean z) {
            if (isServicesDiscoveryMetaQuery()) {
                return new ServiceInfoImpl(ServiceTypeDecoder.decodeQualifiedNameMapForType(getAlias()), 0, 0, 0, z, (byte[]) null);
            }
            if (isReverseLookup()) {
                return new ServiceInfoImpl(getQualifiedNameMap(), 0, 0, 0, z, (byte[]) null);
            }
            if (isDomainDiscoveryQuery()) {
                return new ServiceInfoImpl(getQualifiedNameMap(), 0, 0, 0, z, (byte[]) null);
            }
            Map<ServiceInfo.Fields, String> decodeQualifiedNameMapForType = ServiceTypeDecoder.decodeQualifiedNameMapForType(getAlias());
            decodeQualifiedNameMapForType.put(ServiceInfo.Fields.Subtype, getQualifiedNameMap().get(ServiceInfo.Fields.Subtype));
            return new ServiceInfoImpl(decodeQualifiedNameMapForType, 0, 0, 0, z, getAlias());
        }

        @Override // javax.jmdns.impl.DNSRecord
        public ServiceEvent getServiceEvent(JmDNSImpl jmDNSImpl) {
            ServiceInfo serviceInfo = getServiceInfo(false);
            ((ServiceInfoImpl) serviceInfo).setDns(jmDNSImpl);
            String type = serviceInfo.getType();
            return new ServiceEventImpl(jmDNSImpl, type, JmDNSImpl.toUnqualifiedName(type, getAlias()), serviceInfo);
        }

        @Override // javax.jmdns.impl.DNSRecord, javax.jmdns.impl.DNSEntry
        protected void toString(StringBuilder sb) {
            super.toString(sb);
            sb.append(" alias: '");
            String str = this._alias;
            sb.append(str != null ? str.toString() : "null");
            sb.append('\'');
        }
    }

    /* loaded from: classes2.dex */
    public static class Text extends DNSRecord {
        private final byte[] _text;

        @Override // javax.jmdns.impl.DNSRecord
        DNSOutgoing addAnswer(JmDNSImpl jmDNSImpl, DNSIncoming dNSIncoming, InetAddress inetAddress, int i, DNSOutgoing dNSOutgoing) throws IOException {
            return dNSOutgoing;
        }

        @Override // javax.jmdns.impl.DNSRecord
        boolean handleQuery(JmDNSImpl jmDNSImpl, long j) {
            return false;
        }

        @Override // javax.jmdns.impl.DNSRecord
        boolean handleResponse(JmDNSImpl jmDNSImpl) {
            return false;
        }

        @Override // javax.jmdns.impl.DNSRecord
        public boolean isSingleValued() {
            return true;
        }

        public Text(String str, DNSRecordClass dNSRecordClass, boolean z, int i, byte[] bArr) {
            super(str, DNSRecordType.TYPE_TXT, dNSRecordClass, z, i);
            this._text = (bArr == null || bArr.length <= 0) ? ByteWrangler.EMPTY_TXT : bArr;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public byte[] getText() {
            return this._text;
        }

        @Override // javax.jmdns.impl.DNSRecord
        void write(DNSOutgoing.MessageOutputStream messageOutputStream) {
            byte[] bArr = this._text;
            messageOutputStream.writeBytes(bArr, 0, bArr.length);
        }

        @Override // javax.jmdns.impl.DNSRecord
        boolean sameValue(DNSRecord dNSRecord) {
            if (!(dNSRecord instanceof Text)) {
                return false;
            }
            Text text = (Text) dNSRecord;
            if (this._text == null && text._text != null) {
                return false;
            }
            int length = text._text.length;
            byte[] bArr = this._text;
            if (length != bArr.length) {
                return false;
            }
            int length2 = bArr.length;
            while (true) {
                int i = length2 - 1;
                if (length2 <= 0) {
                    return true;
                }
                if (text._text[i] != this._text[i]) {
                    return false;
                }
                length2 = i;
            }
        }

        @Override // javax.jmdns.impl.DNSRecord
        public ServiceInfo getServiceInfo(boolean z) {
            return new ServiceInfoImpl(getQualifiedNameMap(), 0, 0, 0, z, this._text);
        }

        @Override // javax.jmdns.impl.DNSRecord
        public ServiceEvent getServiceEvent(JmDNSImpl jmDNSImpl) {
            ServiceInfo serviceInfo = getServiceInfo(false);
            ((ServiceInfoImpl) serviceInfo).setDns(jmDNSImpl);
            return new ServiceEventImpl(jmDNSImpl, serviceInfo.getType(), serviceInfo.getName(), serviceInfo);
        }

        @Override // javax.jmdns.impl.DNSRecord, javax.jmdns.impl.DNSEntry
        protected void toString(StringBuilder sb) {
            super.toString(sb);
            sb.append(" text: '");
            String readUTF = ByteWrangler.readUTF(this._text);
            if (readUTF != null) {
                if (20 < readUTF.length()) {
                    sb.append((CharSequence) readUTF, 0, 17);
                    sb.append("...");
                } else {
                    sb.append(readUTF);
                }
            }
            sb.append('\'');
        }
    }

    /* loaded from: classes2.dex */
    public static class Service extends DNSRecord {
        private static Logger logger1 = LoggerFactory.getLogger(Service.class.getName());
        private final int _port;
        private final int _priority;
        private final String _server;
        private final int _weight;

        @Override // javax.jmdns.impl.DNSRecord
        public boolean isSingleValued() {
            return true;
        }

        public Service(String str, DNSRecordClass dNSRecordClass, boolean z, int i, int i2, int i3, int i4, String str2) {
            super(str, DNSRecordType.TYPE_SRV, dNSRecordClass, z, i);
            this._priority = i2;
            this._weight = i3;
            this._port = i4;
            this._server = str2;
        }

        @Override // javax.jmdns.impl.DNSRecord
        void write(DNSOutgoing.MessageOutputStream messageOutputStream) {
            messageOutputStream.writeShort(this._priority);
            messageOutputStream.writeShort(this._weight);
            messageOutputStream.writeShort(this._port);
            if (DNSIncoming.USE_DOMAIN_NAME_FORMAT_FOR_SRV_TARGET) {
                messageOutputStream.writeName(this._server);
                return;
            }
            String str = this._server;
            messageOutputStream.writeUTF(str, 0, str.length());
            messageOutputStream.writeByte(0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // javax.jmdns.impl.DNSEntry
        public void toByteArray(DataOutputStream dataOutputStream) throws IOException {
            super.toByteArray(dataOutputStream);
            dataOutputStream.writeShort(this._priority);
            dataOutputStream.writeShort(this._weight);
            dataOutputStream.writeShort(this._port);
            try {
                dataOutputStream.write(this._server.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getServer() {
            return this._server;
        }

        public int getPriority() {
            return this._priority;
        }

        public int getWeight() {
            return this._weight;
        }

        public int getPort() {
            return this._port;
        }

        @Override // javax.jmdns.impl.DNSRecord
        boolean sameValue(DNSRecord dNSRecord) {
            if (dNSRecord instanceof Service) {
                Service service = (Service) dNSRecord;
                return this._priority == service._priority && this._weight == service._weight && this._port == service._port && this._server.equals(service._server);
            }
            return false;
        }

        @Override // javax.jmdns.impl.DNSRecord
        boolean handleQuery(JmDNSImpl jmDNSImpl, long j) {
            ServiceInfoImpl serviceInfoImpl = (ServiceInfoImpl) jmDNSImpl.getServices().get(getKey());
            if (serviceInfoImpl != null && ((serviceInfoImpl.isAnnouncing() || serviceInfoImpl.isAnnounced()) && (this._port != serviceInfoImpl.getPort() || !this._server.equalsIgnoreCase(jmDNSImpl.getLocalHost().getName())))) {
                logger1.debug("handleQuery() Conflicting probe detected from: {}", getRecordSource());
                Service service = new Service(serviceInfoImpl.getQualifiedName(), DNSRecordClass.CLASS_IN, true, DNSConstants.DNS_TTL, serviceInfoImpl.getPriority(), serviceInfoImpl.getWeight(), serviceInfoImpl.getPort(), jmDNSImpl.getLocalHost().getName());
                try {
                    if (jmDNSImpl.getInetAddress().equals(getRecordSource())) {
                        logger1.warn("Got conflicting probe from ourselves\nincoming: {}\nlocal   : {}", toString(), service.toString());
                    }
                } catch (IOException e) {
                    logger1.warn("IOException", (Throwable) e);
                }
                int compareTo = compareTo(service);
                if (compareTo == 0) {
                    logger1.debug("handleQuery() Ignoring a identical service query");
                    return false;
                } else if (serviceInfoImpl.isProbing() && compareTo > 0) {
                    String lowerCase = serviceInfoImpl.getQualifiedName().toLowerCase();
                    serviceInfoImpl.setName(NameRegister.Factory.getRegistry().incrementName(jmDNSImpl.getLocalHost().getInetAddress(), serviceInfoImpl.getName(), NameRegister.NameType.SERVICE));
                    jmDNSImpl.getServices().remove(lowerCase);
                    jmDNSImpl.getServices().put(serviceInfoImpl.getQualifiedName().toLowerCase(), serviceInfoImpl);
                    logger1.debug("handleQuery() Lost tie break: new unique name chosen:{}", serviceInfoImpl.getName());
                    serviceInfoImpl.revertState();
                    return true;
                }
            }
            return false;
        }

        @Override // javax.jmdns.impl.DNSRecord
        boolean handleResponse(JmDNSImpl jmDNSImpl) {
            ServiceInfoImpl serviceInfoImpl = (ServiceInfoImpl) jmDNSImpl.getServices().get(getKey());
            if (serviceInfoImpl != null) {
                if (this._port == serviceInfoImpl.getPort() && this._server.equalsIgnoreCase(jmDNSImpl.getLocalHost().getName())) {
                    return false;
                }
                logger1.debug("handleResponse() Denial detected");
                if (serviceInfoImpl.isProbing()) {
                    String lowerCase = serviceInfoImpl.getQualifiedName().toLowerCase();
                    serviceInfoImpl.setName(NameRegister.Factory.getRegistry().incrementName(jmDNSImpl.getLocalHost().getInetAddress(), serviceInfoImpl.getName(), NameRegister.NameType.SERVICE));
                    jmDNSImpl.getServices().remove(lowerCase);
                    jmDNSImpl.getServices().put(serviceInfoImpl.getQualifiedName().toLowerCase(), serviceInfoImpl);
                    logger1.debug("handleResponse() New unique name chose:{}", serviceInfoImpl.getName());
                }
                serviceInfoImpl.revertState();
                return true;
            }
            return false;
        }

        @Override // javax.jmdns.impl.DNSRecord
        DNSOutgoing addAnswer(JmDNSImpl jmDNSImpl, DNSIncoming dNSIncoming, InetAddress inetAddress, int i, DNSOutgoing dNSOutgoing) throws IOException {
            ServiceInfoImpl serviceInfoImpl = (ServiceInfoImpl) jmDNSImpl.getServices().get(getKey());
            if (serviceInfoImpl != null) {
                if ((this._port == serviceInfoImpl.getPort()) != this._server.equals(jmDNSImpl.getLocalHost().getName())) {
                    return jmDNSImpl.addAnswer(dNSIncoming, inetAddress, i, dNSOutgoing, new Service(serviceInfoImpl.getQualifiedName(), DNSRecordClass.CLASS_IN, true, DNSConstants.DNS_TTL, serviceInfoImpl.getPriority(), serviceInfoImpl.getWeight(), serviceInfoImpl.getPort(), jmDNSImpl.getLocalHost().getName()));
                }
            }
            return dNSOutgoing;
        }

        @Override // javax.jmdns.impl.DNSRecord
        public ServiceInfo getServiceInfo(boolean z) {
            return new ServiceInfoImpl(getQualifiedNameMap(), this._port, this._weight, this._priority, z, (byte[]) null);
        }

        @Override // javax.jmdns.impl.DNSRecord
        public ServiceEvent getServiceEvent(JmDNSImpl jmDNSImpl) {
            ServiceInfo serviceInfo = getServiceInfo(false);
            ((ServiceInfoImpl) serviceInfo).setDns(jmDNSImpl);
            return new ServiceEventImpl(jmDNSImpl, serviceInfo.getType(), serviceInfo.getName(), serviceInfo);
        }

        @Override // javax.jmdns.impl.DNSRecord, javax.jmdns.impl.DNSEntry
        protected void toString(StringBuilder sb) {
            super.toString(sb);
            sb.append(" server: '");
            sb.append(this._server);
            sb.append(':');
            sb.append(this._port);
            sb.append('\'');
        }
    }

    /* loaded from: classes2.dex */
    public static class HostInformation extends DNSRecord {
        String _cpu;
        String _os;

        @Override // javax.jmdns.impl.DNSRecord
        DNSOutgoing addAnswer(JmDNSImpl jmDNSImpl, DNSIncoming dNSIncoming, InetAddress inetAddress, int i, DNSOutgoing dNSOutgoing) throws IOException {
            return dNSOutgoing;
        }

        @Override // javax.jmdns.impl.DNSRecord
        boolean handleQuery(JmDNSImpl jmDNSImpl, long j) {
            return false;
        }

        @Override // javax.jmdns.impl.DNSRecord
        boolean handleResponse(JmDNSImpl jmDNSImpl) {
            return false;
        }

        @Override // javax.jmdns.impl.DNSRecord
        public boolean isSingleValued() {
            return true;
        }

        public HostInformation(String str, DNSRecordClass dNSRecordClass, boolean z, int i, String str2, String str3) {
            super(str, DNSRecordType.TYPE_HINFO, dNSRecordClass, z, i);
            this._cpu = str2;
            this._os = str3;
        }

        @Override // javax.jmdns.impl.DNSRecord
        boolean sameValue(DNSRecord dNSRecord) {
            if (dNSRecord instanceof HostInformation) {
                HostInformation hostInformation = (HostInformation) dNSRecord;
                if (this._cpu != null || hostInformation._cpu == null) {
                    return (this._os != null || hostInformation._os == null) && this._cpu.equals(hostInformation._cpu) && this._os.equals(hostInformation._os);
                }
                return false;
            }
            return false;
        }

        @Override // javax.jmdns.impl.DNSRecord
        void write(DNSOutgoing.MessageOutputStream messageOutputStream) {
            String str = this._cpu + " " + this._os;
            messageOutputStream.writeUTF(str, 0, str.length());
        }

        @Override // javax.jmdns.impl.DNSRecord
        public ServiceInfo getServiceInfo(boolean z) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("cpu", this._cpu);
            hashMap.put(IMAPStore.ID_OS, this._os);
            return new ServiceInfoImpl(getQualifiedNameMap(), 0, 0, 0, z, hashMap);
        }

        @Override // javax.jmdns.impl.DNSRecord
        public ServiceEvent getServiceEvent(JmDNSImpl jmDNSImpl) {
            ServiceInfo serviceInfo = getServiceInfo(false);
            ((ServiceInfoImpl) serviceInfo).setDns(jmDNSImpl);
            return new ServiceEventImpl(jmDNSImpl, serviceInfo.getType(), serviceInfo.getName(), serviceInfo);
        }

        @Override // javax.jmdns.impl.DNSRecord, javax.jmdns.impl.DNSEntry
        protected void toString(StringBuilder sb) {
            super.toString(sb);
            sb.append(" cpu: '");
            sb.append(this._cpu);
            sb.append("' os: '");
            sb.append(this._os);
            sb.append('\'');
        }
    }

    public ServiceInfo getServiceInfo() {
        return getServiceInfo(false);
    }

    public void setRecordSource(InetAddress inetAddress) {
        this._source = inetAddress;
    }

    public InetAddress getRecordSource() {
        return this._source;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.jmdns.impl.DNSEntry
    public void toString(StringBuilder sb) {
        super.toString(sb);
        int remainingTTL = getRemainingTTL(System.currentTimeMillis());
        sb.append(" ttl: '");
        sb.append(remainingTTL);
        sb.append('/');
        sb.append(this._ttl);
        sb.append('\'');
    }

    public void setTTL(int i) {
        this._ttl = i;
    }

    public int getTTL() {
        return this._ttl;
    }

    public long getCreated() {
        return this._created;
    }
}
