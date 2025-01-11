package com.sun.mail.util;

import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import javax.mail.internet.MimePart;

/* loaded from: classes2.dex */
public class MimeUtil {
    private static final Method cleanContentType;

    /* JADX WARN: Removed duplicated region for block: B:12:0x0018 A[Catch: all -> 0x002f, ClassNotFoundException | NoSuchMethodException | RuntimeException -> 0x0033, TRY_ENTER, TryCatch #1 {ClassNotFoundException | NoSuchMethodException | RuntimeException -> 0x0033, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0010, B:8:0x0010, B:12:0x0018, B:13:0x001c), top: B:24:0x0001 }] */
    static {
        Class<?> cls;
        Method method = null;
        try {
            try {
                String property = System.getProperty("mail.mime.contenttypehandler");
                if (property != null) {
                    ClassLoader contextClassLoader = getContextClassLoader();
                    if (contextClassLoader != null) {
                        try {
                            cls = Class.forName(property, false, contextClassLoader);
                        } catch (ClassNotFoundException unused) {
                        }
                        if (cls == null) {
                            cls = Class.forName(property);
                        }
                        method = cls.getMethod("cleanContentType", MimePart.class, String.class);
                    }
                    cls = null;
                    if (cls == null) {
                    }
                    method = cls.getMethod("cleanContentType", MimePart.class, String.class);
                }
            } finally {
                cleanContentType = null;
            }
        } catch (ClassNotFoundException | NoSuchMethodException | RuntimeException unused2) {
        }
    }

    private MimeUtil() {
    }

    public static String cleanContentType(MimePart mimePart, String str) {
        Method method = cleanContentType;
        if (method != null) {
            try {
                return (String) method.invoke(null, mimePart, str);
            } catch (Exception unused) {
            }
        }
        return str;
    }

    private static ClassLoader getContextClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: com.sun.mail.util.MimeUtil.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                try {
                    return Thread.currentThread().getContextClassLoader();
                } catch (SecurityException unused) {
                    return null;
                }
            }
        });
    }
}
