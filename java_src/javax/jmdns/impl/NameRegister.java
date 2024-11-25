package javax.jmdns.impl;

import java.net.InetAddress;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes2.dex */
public interface NameRegister {

    /* loaded from: classes2.dex */
    public enum NameType {
        HOST,
        SERVICE
    }

    boolean checkName(InetAddress inetAddress, String str, NameType nameType);

    String incrementName(InetAddress inetAddress, String str, NameType nameType);

    void register(InetAddress inetAddress, String str, NameType nameType);

    /* loaded from: classes2.dex */
    public static abstract class BaseRegister implements NameRegister {
        protected String incrementNameWithDash(String str) {
            StringBuilder sb = new StringBuilder(str.length() + 5);
            int indexOf = str.indexOf(".local.");
            int lastIndexOf = str.lastIndexOf(45);
            int i = 1;
            if (lastIndexOf < 0) {
                sb.append(str.substring(0, indexOf));
            } else {
                try {
                    int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1, indexOf)) + 1;
                    sb.append(str.substring(0, lastIndexOf));
                    i = parseInt;
                } catch (Exception unused) {
                    sb.append(str.substring(0, indexOf));
                }
            }
            sb.append('-');
            sb.append(i);
            sb.append(".local.");
            return sb.toString();
        }

        protected String incrementNameWithParentesis(String str) {
            StringBuilder sb = new StringBuilder(str.length() + 5);
            int lastIndexOf = str.lastIndexOf(40);
            int lastIndexOf2 = str.lastIndexOf(41);
            if (lastIndexOf >= 0 && lastIndexOf < lastIndexOf2) {
                try {
                    sb.append(str.substring(0, lastIndexOf));
                    sb.append('(');
                    sb.append(Integer.parseInt(str.substring(lastIndexOf + 1, lastIndexOf2)) + 1);
                    sb.append(')');
                } catch (NumberFormatException unused) {
                    sb.setLength(0);
                    sb.append(str);
                    sb.append(" (2)");
                }
            } else {
                sb.append(str);
                sb.append(" (2)");
            }
            return sb.toString();
        }
    }

    /* renamed from: javax.jmdns.impl.NameRegister$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$javax$jmdns$impl$NameRegister$NameType;

        static {
            int[] iArr = new int[NameType.values().length];
            $SwitchMap$javax$jmdns$impl$NameRegister$NameType = iArr;
            try {
                iArr[NameType.HOST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$javax$jmdns$impl$NameRegister$NameType[NameType.SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class UniqueNamePerInterface extends BaseRegister {
        private final ConcurrentMap<InetAddress, String> _hostNames = new ConcurrentHashMap();
        private final ConcurrentMap<InetAddress, Set<String>> _serviceNames = new ConcurrentHashMap();

        @Override // javax.jmdns.impl.NameRegister
        public void register(InetAddress inetAddress, String str, NameType nameType) {
            int i = AnonymousClass1.$SwitchMap$javax$jmdns$impl$NameRegister$NameType[nameType.ordinal()];
        }

        @Override // javax.jmdns.impl.NameRegister
        public boolean checkName(InetAddress inetAddress, String str, NameType nameType) {
            Set<String> set;
            int i = AnonymousClass1.$SwitchMap$javax$jmdns$impl$NameRegister$NameType[nameType.ordinal()];
            if (i != 1) {
                return i == 2 && (set = this._serviceNames.get(inetAddress)) != null && set.contains(str);
            }
            String str2 = this._hostNames.get(inetAddress);
            return str2 != null && str2.equals(str);
        }

        @Override // javax.jmdns.impl.NameRegister
        public String incrementName(InetAddress inetAddress, String str, NameType nameType) {
            int i = AnonymousClass1.$SwitchMap$javax$jmdns$impl$NameRegister$NameType[nameType.ordinal()];
            if (i != 1) {
                return i != 2 ? str : incrementNameWithParentesis(str);
            }
            return incrementNameWithDash(str);
        }
    }

    /* loaded from: classes2.dex */
    public static class UniqueNameAcrossInterface extends BaseRegister {
        @Override // javax.jmdns.impl.NameRegister
        public void register(InetAddress inetAddress, String str, NameType nameType) {
            int i = AnonymousClass1.$SwitchMap$javax$jmdns$impl$NameRegister$NameType[nameType.ordinal()];
        }

        @Override // javax.jmdns.impl.NameRegister
        public boolean checkName(InetAddress inetAddress, String str, NameType nameType) {
            int i = AnonymousClass1.$SwitchMap$javax$jmdns$impl$NameRegister$NameType[nameType.ordinal()];
            return false;
        }

        @Override // javax.jmdns.impl.NameRegister
        public String incrementName(InetAddress inetAddress, String str, NameType nameType) {
            int i = AnonymousClass1.$SwitchMap$javax$jmdns$impl$NameRegister$NameType[nameType.ordinal()];
            if (i != 1) {
                return i != 2 ? str : incrementNameWithParentesis(str);
            }
            return incrementNameWithDash(str);
        }
    }

    /* loaded from: classes2.dex */
    public static class Factory {
        private static volatile NameRegister _register;

        public static void setRegistry(NameRegister nameRegister) throws IllegalStateException {
            if (_register != null) {
                throw new IllegalStateException("The register can only be set once.");
            }
            if (nameRegister != null) {
                _register = nameRegister;
            }
        }

        public static NameRegister getRegistry() {
            if (_register == null) {
                _register = new UniqueNamePerInterface();
            }
            return _register;
        }
    }
}
