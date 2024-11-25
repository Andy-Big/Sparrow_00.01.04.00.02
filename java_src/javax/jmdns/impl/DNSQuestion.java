package javax.jmdns.impl;

import java.net.InetAddress;
import java.util.Iterator;
import java.util.Set;
import javax.jmdns.ServiceInfo;
import javax.jmdns.impl.DNSRecord;
import javax.jmdns.impl.JmDNSImpl;
import javax.jmdns.impl.constants.DNSConstants;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* loaded from: classes2.dex */
public class DNSQuestion extends DNSEntry {
    private static Logger logger = LoggerFactory.getLogger(DNSQuestion.class.getName());

    public void addAnswers(JmDNSImpl jmDNSImpl, Set<DNSRecord> set) {
    }

    public boolean iAmTheOnlyOne(JmDNSImpl jmDNSImpl) {
        return false;
    }

    @Override // javax.jmdns.impl.DNSEntry
    public boolean isExpired(long j) {
        return false;
    }

    @Override // javax.jmdns.impl.DNSEntry
    public boolean isStale(long j) {
        return false;
    }

    @Override // javax.jmdns.impl.DNSEntry
    public void toString(StringBuilder sb) {
    }

    /* loaded from: classes2.dex */
    private static class DNS4Address extends DNSQuestion {
        DNS4Address(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
            super(str, dNSRecordType, dNSRecordClass, z);
        }

        @Override // javax.jmdns.impl.DNSQuestion
        public void addAnswers(JmDNSImpl jmDNSImpl, Set<DNSRecord> set) {
            DNSRecord.Address dNSAddressRecord = jmDNSImpl.getLocalHost().getDNSAddressRecord(getRecordType(), true, DNSConstants.DNS_TTL);
            if (dNSAddressRecord != null) {
                set.add(dNSAddressRecord);
            }
        }

        @Override // javax.jmdns.impl.DNSQuestion
        public boolean iAmTheOnlyOne(JmDNSImpl jmDNSImpl) {
            String lowerCase = getName().toLowerCase();
            return jmDNSImpl.getLocalHost().getName().equals(lowerCase) || jmDNSImpl.getServices().containsKey(lowerCase);
        }
    }

    /* loaded from: classes2.dex */
    private static class DNS6Address extends DNSQuestion {
        DNS6Address(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
            super(str, dNSRecordType, dNSRecordClass, z);
        }

        @Override // javax.jmdns.impl.DNSQuestion
        public void addAnswers(JmDNSImpl jmDNSImpl, Set<DNSRecord> set) {
            DNSRecord.Address dNSAddressRecord = jmDNSImpl.getLocalHost().getDNSAddressRecord(getRecordType(), true, DNSConstants.DNS_TTL);
            if (dNSAddressRecord != null) {
                set.add(dNSAddressRecord);
            }
        }

        @Override // javax.jmdns.impl.DNSQuestion
        public boolean iAmTheOnlyOne(JmDNSImpl jmDNSImpl) {
            String lowerCase = getName().toLowerCase();
            return jmDNSImpl.getLocalHost().getName().equals(lowerCase) || jmDNSImpl.getServices().containsKey(lowerCase);
        }
    }

    /* loaded from: classes2.dex */
    private static class HostInformation extends DNSQuestion {
        HostInformation(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
            super(str, dNSRecordType, dNSRecordClass, z);
        }
    }

    /* loaded from: classes2.dex */
    private static class Pointer extends DNSQuestion {
        Pointer(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
            super(str, dNSRecordType, dNSRecordClass, z);
        }

        @Override // javax.jmdns.impl.DNSQuestion
        public void addAnswers(JmDNSImpl jmDNSImpl, Set<DNSRecord> set) {
            Iterator<ServiceInfo> it = jmDNSImpl.getServices().values().iterator();
            while (it.hasNext()) {
                addAnswersForServiceInfo(jmDNSImpl, set, (ServiceInfoImpl) it.next());
            }
            if (isServicesDiscoveryMetaQuery()) {
                for (JmDNSImpl.ServiceTypeEntry serviceTypeEntry : jmDNSImpl.getServiceTypes().values()) {
                    set.add(new DNSRecord.Pointer("_services._dns-sd._udp.local.", DNSRecordClass.CLASS_IN, false, DNSConstants.DNS_TTL, serviceTypeEntry.getType()));
                }
            } else if (isReverseLookup()) {
                String str = getQualifiedNameMap().get(ServiceInfo.Fields.Instance);
                if (str == null || str.length() <= 0) {
                    return;
                }
                InetAddress inetAddress = jmDNSImpl.getLocalHost().getInetAddress();
                if (str.equalsIgnoreCase(inetAddress != null ? inetAddress.getHostAddress() : "")) {
                    if (isV4ReverseLookup()) {
                        set.add(jmDNSImpl.getLocalHost().getDNSReverseAddressRecord(DNSRecordType.TYPE_A, false, DNSConstants.DNS_TTL));
                    }
                    if (isV6ReverseLookup()) {
                        set.add(jmDNSImpl.getLocalHost().getDNSReverseAddressRecord(DNSRecordType.TYPE_AAAA, false, DNSConstants.DNS_TTL));
                    }
                }
            } else {
                isDomainDiscoveryQuery();
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class Service extends DNSQuestion {
        Service(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
            super(str, dNSRecordType, dNSRecordClass, z);
        }

        @Override // javax.jmdns.impl.DNSQuestion
        public void addAnswers(JmDNSImpl jmDNSImpl, Set<DNSRecord> set) {
            String lowerCase = getName().toLowerCase();
            if (jmDNSImpl.getLocalHost().getName().equalsIgnoreCase(lowerCase)) {
                set.addAll(jmDNSImpl.getLocalHost().answers(getRecordClass(), isUnique(), DNSConstants.DNS_TTL));
            } else if (jmDNSImpl.getServiceTypes().containsKey(lowerCase)) {
                new Pointer(getName(), DNSRecordType.TYPE_PTR, getRecordClass(), isUnique()).addAnswers(jmDNSImpl, set);
            } else {
                addAnswersForServiceInfo(jmDNSImpl, set, (ServiceInfoImpl) jmDNSImpl.getServices().get(lowerCase));
            }
        }

        @Override // javax.jmdns.impl.DNSQuestion
        public boolean iAmTheOnlyOne(JmDNSImpl jmDNSImpl) {
            String lowerCase = getName().toLowerCase();
            return jmDNSImpl.getLocalHost().getName().equals(lowerCase) || jmDNSImpl.getServices().containsKey(lowerCase);
        }
    }

    /* loaded from: classes2.dex */
    private static class Text extends DNSQuestion {
        Text(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
            super(str, dNSRecordType, dNSRecordClass, z);
        }

        @Override // javax.jmdns.impl.DNSQuestion
        public void addAnswers(JmDNSImpl jmDNSImpl, Set<DNSRecord> set) {
            addAnswersForServiceInfo(jmDNSImpl, set, (ServiceInfoImpl) jmDNSImpl.getServices().get(getName().toLowerCase()));
        }

        @Override // javax.jmdns.impl.DNSQuestion
        public boolean iAmTheOnlyOne(JmDNSImpl jmDNSImpl) {
            String lowerCase = getName().toLowerCase();
            return jmDNSImpl.getLocalHost().getName().equals(lowerCase) || jmDNSImpl.getServices().containsKey(lowerCase);
        }
    }

    /* loaded from: classes2.dex */
    private static class AllRecords extends DNSQuestion {
        @Override // javax.jmdns.impl.DNSEntry
        public boolean isSameType(DNSEntry dNSEntry) {
            return dNSEntry != null;
        }

        AllRecords(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
            super(str, dNSRecordType, dNSRecordClass, z);
        }

        @Override // javax.jmdns.impl.DNSQuestion
        public void addAnswers(JmDNSImpl jmDNSImpl, Set<DNSRecord> set) {
            String lowerCase = getName().toLowerCase();
            if (jmDNSImpl.getLocalHost().getName().equalsIgnoreCase(lowerCase)) {
                set.addAll(jmDNSImpl.getLocalHost().answers(getRecordClass(), isUnique(), DNSConstants.DNS_TTL));
            } else if (jmDNSImpl.getServiceTypes().containsKey(lowerCase)) {
                new Pointer(getName(), DNSRecordType.TYPE_PTR, getRecordClass(), isUnique()).addAnswers(jmDNSImpl, set);
            } else {
                Iterator<ServiceInfo> it = jmDNSImpl.getServices().values().iterator();
                while (it.hasNext()) {
                    addAnswersForServiceInfo(jmDNSImpl, set, (ServiceInfoImpl) it.next());
                }
            }
        }

        @Override // javax.jmdns.impl.DNSQuestion
        public boolean iAmTheOnlyOne(JmDNSImpl jmDNSImpl) {
            String lowerCase = getName().toLowerCase();
            return jmDNSImpl.getLocalHost().getName().equals(lowerCase) || jmDNSImpl.getServices().containsKey(lowerCase);
        }
    }

    DNSQuestion(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
        super(str, dNSRecordType, dNSRecordClass, z);
    }

    /* renamed from: javax.jmdns.impl.DNSQuestion$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
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
            try {
                $SwitchMap$javax$jmdns$impl$constants$DNSRecordType[DNSRecordType.TYPE_ANY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$javax$jmdns$impl$constants$DNSRecordType[DNSRecordType.TYPE_HINFO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$javax$jmdns$impl$constants$DNSRecordType[DNSRecordType.TYPE_PTR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$javax$jmdns$impl$constants$DNSRecordType[DNSRecordType.TYPE_SRV.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$javax$jmdns$impl$constants$DNSRecordType[DNSRecordType.TYPE_TXT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static DNSQuestion newQuestion(String str, DNSRecordType dNSRecordType, DNSRecordClass dNSRecordClass, boolean z) {
        switch (AnonymousClass1.$SwitchMap$javax$jmdns$impl$constants$DNSRecordType[dNSRecordType.ordinal()]) {
            case 1:
                return new DNS4Address(str, dNSRecordType, dNSRecordClass, z);
            case 2:
                return new DNS6Address(str, dNSRecordType, dNSRecordClass, z);
            case 3:
                return new DNS6Address(str, dNSRecordType, dNSRecordClass, z);
            case 4:
                return new AllRecords(str, dNSRecordType, dNSRecordClass, z);
            case 5:
                return new HostInformation(str, dNSRecordType, dNSRecordClass, z);
            case 6:
                return new Pointer(str, dNSRecordType, dNSRecordClass, z);
            case 7:
                return new Service(str, dNSRecordType, dNSRecordClass, z);
            case 8:
                return new Text(str, dNSRecordType, dNSRecordClass, z);
            default:
                return new DNSQuestion(str, dNSRecordType, dNSRecordClass, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean answeredBy(DNSEntry dNSEntry) {
        return isSameRecordClass(dNSEntry) && isSameType(dNSEntry) && getName().equals(dNSEntry.getName());
    }

    protected void addAnswersForServiceInfo(JmDNSImpl jmDNSImpl, Set<DNSRecord> set, ServiceInfoImpl serviceInfoImpl) {
        if (serviceInfoImpl == null || !serviceInfoImpl.isAnnounced()) {
            return;
        }
        if (getName().equalsIgnoreCase(serviceInfoImpl.getQualifiedName()) || getName().equalsIgnoreCase(serviceInfoImpl.getType()) || getName().equalsIgnoreCase(serviceInfoImpl.getTypeWithSubtype())) {
            set.addAll(jmDNSImpl.getLocalHost().answers(getRecordClass(), true, DNSConstants.DNS_TTL));
            set.addAll(serviceInfoImpl.answers(getRecordClass(), true, DNSConstants.DNS_TTL, jmDNSImpl.getLocalHost()));
        }
        logger.debug("{} DNSQuestion({}).addAnswersForServiceInfo(): info: {}\n{}", jmDNSImpl.getName(), getName(), serviceInfoImpl, set);
    }
}
