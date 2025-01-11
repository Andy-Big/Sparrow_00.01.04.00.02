package javax.activation;

import com.sun.activation.registries.LogSupport;
import com.sun.activation.registries.MimeTypeFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Vector;

/* loaded from: classes2.dex */
public class MimetypesFileTypeMap extends FileTypeMap {
    private static final int PROG = 0;
    private static final String confDir;
    private static final String defaultType = "application/octet-stream";
    private MimeTypeFile[] DB;

    static {
        String str;
        try {
            str = (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: javax.activation.MimetypesFileTypeMap.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    String property = System.getProperty("java.home");
                    String str2 = property + File.separator + "conf";
                    if (new File(str2).exists()) {
                        return str2 + File.separator;
                    }
                    return property + File.separator + "lib" + File.separator;
                }
            });
        } catch (Exception unused) {
            str = null;
        }
        confDir = str;
    }

    public MimetypesFileTypeMap() {
        Vector vector = new Vector(5);
        vector.addElement(null);
        LogSupport.log("MimetypesFileTypeMap: load HOME");
        try {
            String property = System.getProperty("user.home");
            if (property != null) {
                MimeTypeFile loadFile = loadFile(property + File.separator + ".mime.types");
                if (loadFile != null) {
                    vector.addElement(loadFile);
                }
            }
        } catch (SecurityException unused) {
        }
        LogSupport.log("MimetypesFileTypeMap: load SYS");
        try {
            if (confDir != null) {
                MimeTypeFile loadFile2 = loadFile(confDir + "mime.types");
                if (loadFile2 != null) {
                    vector.addElement(loadFile2);
                }
            }
        } catch (SecurityException unused2) {
        }
        LogSupport.log("MimetypesFileTypeMap: load JAR");
        loadAllResources(vector, "META-INF/mime.types");
        LogSupport.log("MimetypesFileTypeMap: load DEF");
        MimeTypeFile loadResource = loadResource("/META-INF/mimetypes.default");
        if (loadResource != null) {
            vector.addElement(loadResource);
        }
        MimeTypeFile[] mimeTypeFileArr = new MimeTypeFile[vector.size()];
        this.DB = mimeTypeFileArr;
        vector.copyInto(mimeTypeFileArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
        if (r2 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008f, code lost:
        if (r2 != null) goto L21;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0094: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:39:0x0094 */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private MimeTypeFile loadResource(String str) {
        InputStream inputStream;
        InputStream inputStream2;
        InputStream inputStream3 = null;
        try {
            try {
                inputStream = SecuritySupport.getResourceAsStream(getClass(), str);
            } catch (IOException e) {
                e = e;
                inputStream = null;
            } catch (SecurityException e2) {
                e = e2;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                if (inputStream3 != null) {
                }
                throw th;
            }
            try {
                if (inputStream != null) {
                    MimeTypeFile mimeTypeFile = new MimeTypeFile(inputStream);
                    if (LogSupport.isLoggable()) {
                        LogSupport.log("MimetypesFileTypeMap: successfully loaded mime types file: " + str);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return mimeTypeFile;
                } else if (LogSupport.isLoggable()) {
                    LogSupport.log("MimetypesFileTypeMap: not loading mime types file: " + str);
                }
            } catch (IOException e3) {
                e = e3;
                if (LogSupport.isLoggable()) {
                    LogSupport.log("MimetypesFileTypeMap: can't load " + str, e);
                }
            } catch (SecurityException e4) {
                e = e4;
                if (LogSupport.isLoggable()) {
                    LogSupport.log("MimetypesFileTypeMap: can't load " + str, e);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                        return null;
                    }
                }
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream3 = inputStream2;
            if (inputStream3 != null) {
                try {
                    inputStream3.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void loadAllResources(Vector vector, String str) {
        URL[] systemResources;
        try {
            ClassLoader contextClassLoader = SecuritySupport.getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = getClass().getClassLoader();
            }
            if (contextClassLoader != null) {
                systemResources = SecuritySupport.getResources(contextClassLoader, str);
            } else {
                systemResources = SecuritySupport.getSystemResources(str);
            }
            if (systemResources != null) {
                if (LogSupport.isLoggable()) {
                    LogSupport.log("MimetypesFileTypeMap: getResources");
                }
                int i = 0;
                while (r1 < systemResources.length) {
                    try {
                        URL url = systemResources[r1];
                        InputStream inputStream = null;
                        if (LogSupport.isLoggable()) {
                            LogSupport.log("MimetypesFileTypeMap: URL " + url);
                        }
                        try {
                            try {
                                inputStream = SecuritySupport.openStream(url);
                                if (inputStream != null) {
                                    vector.addElement(new MimeTypeFile(inputStream));
                                    try {
                                        if (LogSupport.isLoggable()) {
                                            LogSupport.log("MimetypesFileTypeMap: successfully loaded mime types from URL: " + url);
                                        }
                                        i = 1;
                                    } catch (IOException e) {
                                        e = e;
                                        i = 1;
                                        if (LogSupport.isLoggable()) {
                                            LogSupport.log("MimetypesFileTypeMap: can't load " + url, e);
                                        }
                                        r1 = inputStream == null ? r1 + 1 : 0;
                                        inputStream.close();
                                    } catch (SecurityException e2) {
                                        e = e2;
                                        i = 1;
                                        if (LogSupport.isLoggable()) {
                                            LogSupport.log("MimetypesFileTypeMap: can't load " + url, e);
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException unused) {
                                            }
                                        }
                                        throw th;
                                    }
                                } else if (LogSupport.isLoggable()) {
                                    LogSupport.log("MimetypesFileTypeMap: not loading mime types from URL: " + url);
                                }
                            } catch (IOException e3) {
                                e = e3;
                            } catch (SecurityException e4) {
                                e = e4;
                            }
                            if (inputStream == null) {
                            }
                            try {
                                inputStream.close();
                            } catch (IOException unused2) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        r1 = i;
                        if (LogSupport.isLoggable()) {
                            LogSupport.log("MimetypesFileTypeMap: can't load " + str, e);
                        }
                        if (r1 != 0) {
                        }
                    }
                }
                r1 = i;
            }
        } catch (Exception e6) {
            e = e6;
        }
        if (r1 != 0) {
            LogSupport.log("MimetypesFileTypeMap: !anyLoaded");
            MimeTypeFile loadResource = loadResource("/" + str);
            if (loadResource != null) {
                vector.addElement(loadResource);
            }
        }
    }

    private MimeTypeFile loadFile(String str) {
        try {
            return new MimeTypeFile(str);
        } catch (IOException unused) {
            return null;
        }
    }

    public MimetypesFileTypeMap(String str) throws IOException {
        this();
        this.DB[0] = new MimeTypeFile(str);
    }

    public MimetypesFileTypeMap(InputStream inputStream) {
        this();
        try {
            this.DB[0] = new MimeTypeFile(inputStream);
        } catch (IOException unused) {
        }
    }

    public synchronized void addMimeTypes(String str) {
        if (this.DB[0] == null) {
            this.DB[0] = new MimeTypeFile();
        }
        this.DB[0].appendToRegistry(str);
    }

    @Override // javax.activation.FileTypeMap
    public String getContentType(File file) {
        return getContentType(file.getName());
    }

    @Override // javax.activation.FileTypeMap
    public synchronized String getContentType(String str) {
        String mIMETypeString;
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return defaultType;
        }
        String substring = str.substring(lastIndexOf + 1);
        if (substring.length() == 0) {
            return defaultType;
        }
        for (int i = 0; i < this.DB.length; i++) {
            if (this.DB[i] != null && (mIMETypeString = this.DB[i].getMIMETypeString(substring)) != null) {
                return mIMETypeString;
            }
        }
        return defaultType;
    }
}
