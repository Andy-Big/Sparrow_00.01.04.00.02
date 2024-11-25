package javax.mail.internet;

import java.util.concurrent.atomic.AtomicInteger;
import javax.mail.Session;
/* loaded from: classes2.dex */
class UniqueValue {
    private static AtomicInteger id = new AtomicInteger();

    UniqueValue() {
    }

    public static String getUniqueBoundaryValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("----=_Part_");
        sb.append(id.getAndIncrement());
        sb.append("_");
        sb.append(sb.hashCode());
        sb.append('.');
        sb.append(System.currentTimeMillis());
        return sb.toString();
    }

    public static String getUniqueMessageIDValue(Session session) {
        InternetAddress localAddress = InternetAddress.getLocalAddress(session);
        String address = localAddress != null ? localAddress.getAddress() : "jakartamailuser@localhost";
        int lastIndexOf = address.lastIndexOf(64);
        if (lastIndexOf >= 0) {
            address = address.substring(lastIndexOf);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(sb.hashCode());
        sb.append('.');
        sb.append(id.getAndIncrement());
        sb.append('.');
        sb.append(System.currentTimeMillis());
        sb.append(address);
        return sb.toString();
    }
}
