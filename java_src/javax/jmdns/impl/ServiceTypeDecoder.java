package javax.jmdns.impl;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.jmdns.ServiceInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ServiceTypeDecoder {
    private static final Pattern SUBTYPE_PATTERN = Pattern.compile("^((.*)\\._)?_?(.*)\\._sub\\._([^.]*)\\._([^.]*)\\.(.*)\\.?$");
    private static final Pattern PATTERN = Pattern.compile("^((.*)?\\._)?([^.]*)\\._([^.]*)\\.(.*)\\.?$");

    private ServiceTypeDecoder() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<ServiceInfo.Fields, String> decodeQualifiedNameMap(String str, String str2, String str3) {
        Map<ServiceInfo.Fields, String> decodeQualifiedNameMapForType = decodeQualifiedNameMapForType(str);
        decodeQualifiedNameMapForType.put(ServiceInfo.Fields.Instance, str2);
        decodeQualifiedNameMapForType.put(ServiceInfo.Fields.Subtype, str3);
        return ServiceInfoImpl.checkQualifiedNameMap(decodeQualifiedNameMapForType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<ServiceInfo.Fields, String> decodeQualifiedNameMapForType(String str) {
        String removeSeparators;
        String substring;
        String str2;
        String str3;
        String originalCase;
        String lowerCase = str.toLowerCase();
        String str4 = "";
        if (lowerCase.contains("in-addr.arpa") || lowerCase.contains("ip6.arpa")) {
            int indexOf = lowerCase.contains("in-addr.arpa") ? lowerCase.indexOf("in-addr.arpa") : lowerCase.indexOf("ip6.arpa");
            removeSeparators = ServiceInfoImpl.removeSeparators(str.substring(0, indexOf));
            substring = str.substring(indexOf);
        } else if (!lowerCase.contains("_") && lowerCase.contains(".")) {
            int indexOf2 = lowerCase.indexOf(46);
            removeSeparators = ServiceInfoImpl.removeSeparators(str.substring(0, indexOf2));
            substring = ServiceInfoImpl.removeSeparators(str.substring(indexOf2));
        } else {
            Matcher matcher = SUBTYPE_PATTERN.matcher(lowerCase);
            if (matcher.matches()) {
                str4 = originalCase(str, matcher, 2);
                String originalCase2 = originalCase(str, matcher, 3);
                originalCase = originalCase(str, matcher, 4);
                str2 = originalCase(str, matcher, 5);
                substring = originalCase(str, matcher, 6);
                str3 = originalCase2;
            } else {
                Matcher matcher2 = PATTERN.matcher(lowerCase);
                if (matcher2.matches()) {
                    String originalCase3 = originalCase(str, matcher2, 2);
                    originalCase = originalCase(str, matcher2, 3);
                    String originalCase4 = originalCase(str, matcher2, 4);
                    substring = originalCase(str, matcher2, 5);
                    str2 = originalCase4;
                    str3 = "";
                    str4 = originalCase3;
                } else {
                    substring = "";
                    str3 = substring;
                    str2 = str3;
                    return ServiceInfoImpl.createQualifiedMap(str4, ServiceInfoImpl.removeSeparators(lowerCase), str2, ServiceInfoImpl.removeSeparators(substring), str3);
                }
            }
            lowerCase = originalCase;
            return ServiceInfoImpl.createQualifiedMap(str4, ServiceInfoImpl.removeSeparators(lowerCase), str2, ServiceInfoImpl.removeSeparators(substring), str3);
        }
        lowerCase = "";
        str2 = lowerCase;
        str4 = removeSeparators;
        str3 = str2;
        return ServiceInfoImpl.createQualifiedMap(str4, ServiceInfoImpl.removeSeparators(lowerCase), str2, ServiceInfoImpl.removeSeparators(substring), str3);
    }

    private static String originalCase(String str, Matcher matcher, int i) {
        return matcher.start(i) != -1 ? str.substring(matcher.start(i), matcher.end(i)) : "";
    }
}
