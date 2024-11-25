package javax.jmdns.impl.constants;

import com.blankj.utilcode.constant.CacheConstants;
/* loaded from: classes2.dex */
public final class DNSConstants {
    public static final int ANNOUNCED_RENEWAL_TTL_INTERVAL;
    public static final int ANNOUNCE_WAIT_INTERVAL = 1000;
    public static final long CLOSE_TIMEOUT = 5000;
    public static final int DNS_PORT = 53;
    public static final int DNS_TTL;
    public static final int FLAGS_AA = 1024;
    public static final int FLAGS_AD = 32;
    public static final int FLAGS_CD = 16;
    public static final int FLAGS_OPCODE = 30720;
    public static final int FLAGS_QR_MASK = 32768;
    public static final int FLAGS_QR_QUERY = 0;
    public static final int FLAGS_QR_RESPONSE = 32768;
    public static final int FLAGS_RA = 32768;
    public static final int FLAGS_RCODE = 15;
    public static final int FLAGS_RD = 256;
    public static final int FLAGS_TC = 512;
    public static final int FLAGS_Z = 64;
    public static final int FLUSH_RECORD_OLDER_THAN_1_SECOND = 1;
    public static final int KNOWN_ANSWER_TTL = 120;
    public static final int MAX_MSG_ABSOLUTE = 8972;
    public static final int MAX_MSG_TYPICAL = 1460;
    public static final String MDNS_GROUP = System.getProperty("net.mdns.ipv4", "224.0.0.251");
    public static final String MDNS_GROUP_IPV6 = System.getProperty("net.mdns.ipv6", "FF02::FB");
    public static final int MDNS_PORT = Integer.getInteger("net.mdns.port", 5353).intValue();
    public static final int NETWORK_CHECK_INTERVAL = 10000;
    public static final int PROBE_CONFLICT_INTERVAL = 1000;
    public static final int PROBE_THROTTLE_COUNT = 10;
    public static final int PROBE_THROTTLE_COUNT_INTERVAL = 5000;
    public static final int PROBE_WAIT_INTERVAL = 250;
    public static final int QUERY_WAIT_INTERVAL = 225;
    public static final int RECORD_EXPIRY_DELAY = 1;
    public static final int RECORD_REAPER_INTERVAL = 10000;
    public static final int RESPONSE_MAX_WAIT_INTERVAL = 115;
    public static final int RESPONSE_MIN_WAIT_INTERVAL = 20;
    public static final long SERVICE_INFO_TIMEOUT = 6000;
    public static final int SHARED_QUERY_TIME = 20;
    public static final int STALE_REFRESH_INCREMENT = 5;
    public static final int STALE_REFRESH_STARTING_PERCENTAGE = 80;

    static {
        int intValue = Integer.getInteger("net.dns.ttl", (int) CacheConstants.HOUR).intValue();
        DNS_TTL = intValue;
        ANNOUNCED_RENEWAL_TTL_INTERVAL = intValue * 500;
    }
}
