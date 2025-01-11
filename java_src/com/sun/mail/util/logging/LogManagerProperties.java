package com.sun.mail.util.logging;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectStreamException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.UndeclaredThrowableException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.ErrorManager;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.LoggingPermission;

/* loaded from: classes2.dex */
final class LogManagerProperties extends Properties {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object LOG_MANAGER;
    private static final Method LR_GET_INSTANT;
    private static volatile String[] REFLECT_NAMES = null;
    private static final Method ZDT_OF_INSTANT;
    private static final Method ZI_SYSTEM_DEFAULT;
    private static final long serialVersionUID = -2239983349056806252L;
    private final String prefix;

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a4, code lost:
        if (r0 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ae, code lost:
        if (r0 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b8, code lost:
        if (r0 != null) goto L20;
     */
    static {
        Object obj;
        Method method;
        Method method2;
        Method method3;
        Method method4 = null;
        try {
            method2 = LogRecord.class.getMethod("getInstant", new Class[0]);
            try {
                method3 = findClass("java.time.ZoneId").getMethod("systemDefault", new Class[0]);
                try {
                } catch (RuntimeException unused) {
                    method = null;
                } catch (Exception unused2) {
                    method = null;
                } catch (LinkageError unused3) {
                    method = null;
                } catch (Throwable th) {
                    throw th;
                }
            } catch (RuntimeException unused4) {
                method = null;
                method3 = null;
            } catch (Exception unused5) {
                method = null;
                method3 = null;
            } catch (LinkageError unused6) {
                method = null;
                method3 = null;
            } catch (Throwable th2) {
                th = th2;
                obj = null;
                throw th;
            }
        } catch (LinkageError unused7) {
            method = null;
            method2 = null;
            method3 = null;
        } catch (RuntimeException unused8) {
            method = null;
            method2 = null;
            method3 = null;
        } catch (Exception unused9) {
            method = null;
            method2 = null;
            method3 = null;
        } catch (Throwable th3) {
            th = th3;
            obj = null;
        }
        if (!Modifier.isStatic(method3.getModifiers())) {
            throw new NoSuchMethodException(method3.toString());
        }
        method = findClass("java.time.ZonedDateTime").getMethod("ofInstant", findClass("java.time.Instant"), findClass("java.time.ZoneId"));
        try {
        } catch (LinkageError unused10) {
            if (method2 != null) {
                if (method3 != null) {
                }
            }
            method = null;
            method3 = null;
            LR_GET_INSTANT = method4;
            ZI_SYSTEM_DEFAULT = method3;
            ZDT_OF_INSTANT = method;
            LOG_MANAGER = loadLogManager();
        } catch (RuntimeException unused11) {
            if (method2 != null) {
                if (method3 != null) {
                }
            }
            method = null;
            method3 = null;
            LR_GET_INSTANT = method4;
            ZI_SYSTEM_DEFAULT = method3;
            ZDT_OF_INSTANT = method;
            LOG_MANAGER = loadLogManager();
        } catch (Exception unused12) {
            if (method2 != null) {
                if (method3 != null) {
                }
            }
            method = null;
            method3 = null;
            LR_GET_INSTANT = method4;
            ZI_SYSTEM_DEFAULT = method3;
            ZDT_OF_INSTANT = method;
            LOG_MANAGER = loadLogManager();
        } catch (Throwable th4) {
            throw th4;
        }
        if (!Modifier.isStatic(method.getModifiers())) {
            throw new NoSuchMethodException(method.toString());
        }
        if (!Comparable.class.isAssignableFrom(method.getReturnType())) {
            throw new NoSuchMethodException(method.toString());
        }
        if (method2 != null) {
            if (method3 != null) {
                if (method == null) {
                }
                method4 = method2;
                LR_GET_INSTANT = method4;
                ZI_SYSTEM_DEFAULT = method3;
                ZDT_OF_INSTANT = method;
                LOG_MANAGER = loadLogManager();
            }
        }
        method = null;
        method3 = null;
        LR_GET_INSTANT = method4;
        ZI_SYSTEM_DEFAULT = method3;
        ZDT_OF_INSTANT = method;
        LOG_MANAGER = loadLogManager();
    }

    private static Object loadLogManager() {
        try {
            return LogManager.getLogManager();
        } catch (LinkageError unused) {
            return readConfiguration();
        } catch (RuntimeException unused2) {
            return readConfiguration();
        }
    }

    private static Properties readConfiguration() {
        Properties properties = new Properties();
        try {
            String property = System.getProperty("java.util.logging.config.file");
            if (property != null) {
                FileInputStream fileInputStream = new FileInputStream(new File(property).getCanonicalFile());
                properties.load(fileInputStream);
                fileInputStream.close();
            }
        } catch (RuntimeException | Exception | LinkageError unused) {
        }
        return properties;
    }

    static String fromLogManager(String str) {
        if (str == null) {
            throw null;
        }
        Object obj = LOG_MANAGER;
        try {
            if (obj instanceof Properties) {
                return ((Properties) obj).getProperty(str);
            }
        } catch (RuntimeException unused) {
        }
        if (obj != null) {
            try {
                if (obj instanceof LogManager) {
                    return ((LogManager) obj).getProperty(str);
                }
            } catch (LinkageError | RuntimeException unused2) {
            }
        }
        return null;
    }

    static void checkLogManagerAccess() {
        Object obj = LOG_MANAGER;
        boolean z = false;
        if (obj != null) {
            try {
                if (obj instanceof LogManager) {
                    z = true;
                    ((LogManager) obj).checkAccess();
                }
            } catch (LinkageError | RuntimeException unused) {
            } catch (SecurityException e) {
                if (z) {
                    throw e;
                }
            }
        }
        if (z) {
            return;
        }
        checkLoggingAccess();
    }

    private static void checkLoggingAccess() {
        SecurityManager securityManager;
        Logger logger = Logger.getLogger("global");
        boolean z = false;
        try {
            if (Logger.class == logger.getClass()) {
                logger.removeHandler(null);
                z = true;
            }
        } catch (NullPointerException unused) {
        }
        if (z || (securityManager = System.getSecurityManager()) == null) {
            return;
        }
        securityManager.checkPermission(new LoggingPermission("control", null));
    }

    static boolean hasLogManager() {
        Object obj = LOG_MANAGER;
        return (obj == null || (obj instanceof Properties)) ? false : true;
    }

    static Comparable<?> getZonedDateTime(LogRecord logRecord) {
        if (logRecord == null) {
            throw null;
        }
        Method method = ZDT_OF_INSTANT;
        if (method != null) {
            try {
                return (Comparable) method.invoke(null, LR_GET_INSTANT.invoke(logRecord, new Object[0]), ZI_SYSTEM_DEFAULT.invoke(null, new Object[0]));
            } catch (RuntimeException | Exception unused) {
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new UndeclaredThrowableException(e);
            }
        }
        return null;
    }

    static String getLocalHost(Object obj) throws Exception {
        try {
            Method method = obj.getClass().getMethod("getLocalHost", new Class[0]);
            if (!Modifier.isStatic(method.getModifiers()) && method.getReturnType() == String.class) {
                return (String) method.invoke(obj, new Object[0]);
            }
            throw new NoSuchMethodException(method.toString());
        } catch (ExceptionInInitializerError e) {
            throw wrapOrThrow(e);
        } catch (InvocationTargetException e2) {
            throw paramOrError(e2);
        }
    }

    static long parseDurationToMillis(CharSequence charSequence) throws Exception {
        try {
            Class<?> findClass = findClass("java.time.Duration");
            Method method = findClass.getMethod("parse", CharSequence.class);
            if (!findClass.isAssignableFrom(method.getReturnType()) || !Modifier.isStatic(method.getModifiers())) {
                throw new NoSuchMethodException(method.toString());
            }
            Method method2 = findClass.getMethod("toMillis", new Class[0]);
            if (!Long.TYPE.isAssignableFrom(method2.getReturnType()) || Modifier.isStatic(method2.getModifiers())) {
                throw new NoSuchMethodException(method2.toString());
            }
            return ((Long) method2.invoke(method.invoke(null, charSequence), new Object[0])).longValue();
        } catch (ExceptionInInitializerError e) {
            throw wrapOrThrow(e);
        } catch (InvocationTargetException e2) {
            throw paramOrError(e2);
        }
    }

    static String toLanguageTag(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String variant = locale.getVariant();
        char[] cArr = new char[language.length() + country.length() + variant.length() + 2];
        int length = language.length();
        language.getChars(0, length, cArr, 0);
        if (country.length() != 0 || (language.length() != 0 && variant.length() != 0)) {
            cArr[length] = '-';
            int i = length + 1;
            country.getChars(0, country.length(), cArr, i);
            length = i + country.length();
        }
        if (variant.length() != 0 && (language.length() != 0 || country.length() != 0)) {
            cArr[length] = '-';
            int i2 = length + 1;
            variant.getChars(0, variant.length(), cArr, i2);
            length = i2 + variant.length();
        }
        return String.valueOf(cArr, 0, length);
    }

    static Filter newFilter(String str) throws Exception {
        return (Filter) newObjectFrom(str, Filter.class);
    }

    static Formatter newFormatter(String str) throws Exception {
        return (Formatter) newObjectFrom(str, Formatter.class);
    }

    static Comparator<? super LogRecord> newComparator(String str) throws Exception {
        return (Comparator) newObjectFrom(str, Comparator.class);
    }

    static <T> Comparator<T> reverseOrder(Comparator<T> comparator) {
        Comparator<T> comparator2 = null;
        if (comparator == null) {
            throw null;
        }
        try {
            try {
                Method method = comparator.getClass().getMethod("reversed", new Class[0]);
                if (!Modifier.isStatic(method.getModifiers()) && Comparator.class.isAssignableFrom(method.getReturnType())) {
                    try {
                        comparator2 = (Comparator) method.invoke(comparator, new Object[0]);
                    } catch (ExceptionInInitializerError e) {
                        throw wrapOrThrow(e);
                    }
                }
            } catch (IllegalAccessException | NoSuchMethodException | RuntimeException unused) {
            }
        } catch (InvocationTargetException e2) {
            paramOrError(e2);
        }
        return comparator2 == null ? Collections.reverseOrder(comparator) : comparator2;
    }

    static ErrorManager newErrorManager(String str) throws Exception {
        return (ErrorManager) newObjectFrom(str, ErrorManager.class);
    }

    static boolean isStaticUtilityClass(String str) throws Exception {
        Class<?> findClass = findClass(str);
        if (findClass != Object.class) {
            Method[] methods = findClass.getMethods();
            if (methods.length != 0) {
                for (Method method : methods) {
                    if (method.getDeclaringClass() != Object.class && !Modifier.isStatic(method.getModifiers())) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    static boolean isReflectionClass(String str) throws Exception {
        String[] strArr = REFLECT_NAMES;
        if (strArr == null) {
            strArr = reflectionClassNames();
            REFLECT_NAMES = strArr;
        }
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        findClass(str);
        return false;
    }

    private static String[] reflectionClassNames() throws Exception {
        StackTraceElement[] stackTrace;
        StackTraceElement[] stackTrace2;
        try {
            HashSet hashSet = new HashSet();
            Throwable th = (Throwable) Throwable.class.getConstructor(new Class[0]).newInstance(new Object[0]);
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (LogManagerProperties.class.getName().equals(stackTraceElement.getClassName())) {
                    break;
                }
                hashSet.add(stackTraceElement.getClassName());
            }
            Throwable.class.getMethod("fillInStackTrace", new Class[0]).invoke(th, new Object[0]);
            for (StackTraceElement stackTraceElement2 : th.getStackTrace()) {
                if (LogManagerProperties.class.getName().equals(stackTraceElement2.getClassName())) {
                    break;
                }
                hashSet.add(stackTraceElement2.getClassName());
            }
            return (String[]) hashSet.toArray(new String[hashSet.size()]);
        } catch (InvocationTargetException e) {
            throw paramOrError(e);
        }
    }

    static <T> T newObjectFrom(String str, Class<T> cls) throws Exception {
        try {
            Class<?> findClass = findClass(str);
            if (cls.isAssignableFrom(findClass)) {
                try {
                    return cls.cast(findClass.getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (InvocationTargetException e) {
                    throw paramOrError(e);
                }
            }
            throw new ClassCastException(findClass.getName() + " cannot be cast to " + cls.getName());
        } catch (ExceptionInInitializerError e2) {
            throw wrapOrThrow(e2);
        } catch (NoClassDefFoundError e3) {
            throw new ClassNotFoundException(e3.toString(), e3);
        }
    }

    private static Exception paramOrError(InvocationTargetException invocationTargetException) {
        Throwable cause = invocationTargetException.getCause();
        if (cause == null || (!(cause instanceof VirtualMachineError) && !(cause instanceof ThreadDeath))) {
            return invocationTargetException;
        }
        throw ((Error) cause);
    }

    private static InvocationTargetException wrapOrThrow(ExceptionInInitializerError exceptionInInitializerError) {
        if (exceptionInInitializerError.getCause() instanceof Error) {
            throw exceptionInInitializerError;
        }
        return new InvocationTargetException(exceptionInInitializerError);
    }

    private static Class<?> findClass(String str) throws ClassNotFoundException {
        ClassLoader[] classLoaders = getClassLoaders();
        if (classLoaders[0] != null) {
            try {
                return Class.forName(str, false, classLoaders[0]);
            } catch (ClassNotFoundException unused) {
                return tryLoad(str, classLoaders[1]);
            }
        }
        return tryLoad(str, classLoaders[1]);
    }

    private static Class<?> tryLoad(String str, ClassLoader classLoader) throws ClassNotFoundException {
        if (classLoader != null) {
            return Class.forName(str, false, classLoader);
        }
        return Class.forName(str);
    }

    private static ClassLoader[] getClassLoaders() {
        return (ClassLoader[]) AccessController.doPrivileged(new PrivilegedAction<ClassLoader[]>() { // from class: com.sun.mail.util.logging.LogManagerProperties.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.security.PrivilegedAction
            public ClassLoader[] run() {
                ClassLoader[] classLoaderArr = new ClassLoader[2];
                try {
                    classLoaderArr[0] = ClassLoader.getSystemClassLoader();
                } catch (SecurityException unused) {
                    classLoaderArr[0] = null;
                }
                try {
                    classLoaderArr[1] = Thread.currentThread().getContextClassLoader();
                } catch (SecurityException unused2) {
                    classLoaderArr[1] = null;
                }
                return classLoaderArr;
            }
        });
    }

    LogManagerProperties(Properties properties, String str) {
        super(properties);
        if (properties == null || str == null) {
            throw null;
        }
        this.prefix = str;
    }

    @Override // java.util.Hashtable
    public synchronized Object clone() {
        return exportCopy(this.defaults);
    }

    @Override // java.util.Properties
    public synchronized String getProperty(String str) {
        String property;
        property = this.defaults.getProperty(str);
        if (property == null) {
            if (str.length() > 0) {
                property = fromLogManager(this.prefix + '.' + str);
            }
            if (property == null) {
                property = fromLogManager(str);
            }
            if (property != null) {
                super.put(str, property);
            } else {
                Object obj = super.get(str);
                property = obj instanceof String ? (String) obj : null;
            }
        }
        return property;
    }

    @Override // java.util.Properties
    public String getProperty(String str, String str2) {
        String property = getProperty(str);
        return property == null ? str2 : property;
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized Object get(Object obj) {
        Object property;
        property = obj instanceof String ? getProperty((String) obj) : null;
        if (property == null && (property = this.defaults.get(obj)) == null && !this.defaults.containsKey(obj)) {
            property = super.get(obj);
        }
        return property;
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized Object put(Object obj, Object obj2) {
        if ((obj instanceof String) && (obj2 instanceof String)) {
            Object preWrite = preWrite(obj);
            Object put = super.put(obj, obj2);
            if (put != null) {
                preWrite = put;
            }
            return preWrite;
        }
        return super.put(obj, obj2);
    }

    @Override // java.util.Properties
    public Object setProperty(String str, String str2) {
        return put(str, str2);
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized boolean containsKey(Object obj) {
        boolean z;
        boolean z2 = true;
        z = (obj instanceof String) && getProperty((String) obj) != null;
        if (!z) {
            if (!this.defaults.containsKey(obj)) {
                if (!super.containsKey(obj)) {
                    z2 = false;
                }
            }
            z = z2;
        }
        return z;
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public synchronized Object remove(Object obj) {
        Object preWrite;
        preWrite = preWrite(obj);
        Object remove = super.remove(obj);
        if (remove != null) {
            preWrite = remove;
        }
        return preWrite;
    }

    @Override // java.util.Properties
    public Enumeration<?> propertyNames() {
        return super.propertyNames();
    }

    @Override // java.util.Hashtable, java.util.Map
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Properties) {
            return super.equals(obj);
        }
        return false;
    }

    @Override // java.util.Hashtable, java.util.Map
    public int hashCode() {
        return super.hashCode();
    }

    private Object preWrite(Object obj) {
        return get(obj);
    }

    private Properties exportCopy(Properties properties) {
        Thread.holdsLock(this);
        Properties properties2 = new Properties(properties);
        properties2.putAll(this);
        return properties2;
    }

    private synchronized Object writeReplace() throws ObjectStreamException {
        return exportCopy((Properties) this.defaults.clone());
    }
}
