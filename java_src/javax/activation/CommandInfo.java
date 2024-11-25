package javax.activation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes2.dex */
public class CommandInfo {
    private String className;
    private String verb;

    public CommandInfo(String str, String str2) {
        this.verb = str;
        this.className = str2;
    }

    public String getCommandName() {
        return this.verb;
    }

    public String getCommandClass() {
        return this.className;
    }

    public Object getCommandObject(DataHandler dataHandler, ClassLoader classLoader) throws IOException, ClassNotFoundException {
        InputStream inputStream;
        Object instantiate = Beans.instantiate(classLoader, this.className);
        if (instantiate != null) {
            if (instantiate instanceof CommandObject) {
                ((CommandObject) instantiate).setCommandContext(this.verb, dataHandler);
            } else if ((instantiate instanceof Externalizable) && dataHandler != null && (inputStream = dataHandler.getInputStream()) != null) {
                ((Externalizable) instantiate).readExternal(new ObjectInputStream(inputStream));
            }
        }
        return instantiate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Beans {
        static final Method instantiateMethod;

        private Beans() {
        }

        static {
            Method method = null;
            try {
                method = Class.forName("java.beans.Beans").getDeclaredMethod("instantiate", ClassLoader.class, String.class);
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
            }
            instantiateMethod = method;
        }

        static Object instantiate(ClassLoader classLoader, String str) throws IOException, ClassNotFoundException {
            int lastIndexOf;
            Method method = instantiateMethod;
            if (method != null) {
                try {
                    return method.invoke(null, classLoader, str);
                } catch (IllegalAccessException | InvocationTargetException unused) {
                    return null;
                }
            }
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                String replace = str.replace('/', '.');
                if (replace.startsWith("[") && (lastIndexOf = replace.lastIndexOf(91) + 2) > 1 && lastIndexOf < replace.length()) {
                    replace = replace.substring(lastIndexOf);
                }
                int lastIndexOf2 = replace.lastIndexOf(46);
                if (lastIndexOf2 != -1) {
                    securityManager.checkPackageAccess(replace.substring(0, lastIndexOf2));
                }
            }
            if (classLoader == null) {
                classLoader = (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: javax.activation.CommandInfo.Beans.1
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            return ClassLoader.getSystemClassLoader();
                        } catch (SecurityException unused2) {
                            return null;
                        }
                    }
                });
            }
            Class<?> cls = Class.forName(str, true, classLoader);
            try {
                return cls.newInstance();
            } catch (Exception e) {
                throw new ClassNotFoundException(cls + ": " + e, e);
            }
        }
    }
}
