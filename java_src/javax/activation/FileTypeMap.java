package javax.activation;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes2.dex */
public abstract class FileTypeMap {
    private static FileTypeMap defaultMap;
    private static Map<ClassLoader, FileTypeMap> map = new WeakHashMap();

    public abstract String getContentType(File file);

    public abstract String getContentType(String str);

    public static synchronized void setDefaultFileTypeMap(FileTypeMap fileTypeMap) {
        synchronized (FileTypeMap.class) {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                try {
                    securityManager.checkSetFactory();
                } catch (SecurityException e) {
                    ClassLoader classLoader = FileTypeMap.class.getClassLoader();
                    if (classLoader == null || classLoader.getParent() == null || classLoader != fileTypeMap.getClass().getClassLoader()) {
                        throw e;
                    }
                }
            }
            map.remove(SecuritySupport.getContextClassLoader());
            defaultMap = fileTypeMap;
        }
    }

    public static synchronized FileTypeMap getDefaultFileTypeMap() {
        synchronized (FileTypeMap.class) {
            if (defaultMap != null) {
                return defaultMap;
            }
            ClassLoader contextClassLoader = SecuritySupport.getContextClassLoader();
            FileTypeMap fileTypeMap = map.get(contextClassLoader);
            if (fileTypeMap == null) {
                fileTypeMap = new MimetypesFileTypeMap();
                map.put(contextClassLoader, fileTypeMap);
            }
            return fileTypeMap;
        }
    }
}
