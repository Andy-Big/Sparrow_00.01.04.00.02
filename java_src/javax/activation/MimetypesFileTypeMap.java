package javax.activation;

import com.sun.activation.registries.LogSupport;
import com.sun.activation.registries.MimeTypeFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
        To view partially-correct add '--show-bad-code' argument
    */
    private com.sun.activation.registries.MimeTypeFile loadResource(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "MimetypesFileTypeMap: can't load "
            r1 = 0
            java.lang.Class r2 = r6.getClass()     // Catch: java.lang.Throwable -> L56 java.lang.SecurityException -> L58 java.io.IOException -> L75
            java.io.InputStream r2 = javax.activation.SecuritySupport.getResourceAsStream(r2, r7)     // Catch: java.lang.Throwable -> L56 java.lang.SecurityException -> L58 java.io.IOException -> L75
            if (r2 == 0) goto L32
            com.sun.activation.registries.MimeTypeFile r3 = new com.sun.activation.registries.MimeTypeFile     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
            r3.<init>(r2)     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
            boolean r4 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
            if (r4 == 0) goto L2c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
            r4.<init>()     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
            java.lang.String r5 = "MimetypesFileTypeMap: successfully loaded mime types file: "
            r4.append(r5)     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
            r4.append(r7)     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
            java.lang.String r4 = r4.toString()     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
            com.sun.activation.registries.LogSupport.log(r4)     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
        L2c:
            if (r2 == 0) goto L31
            r2.close()     // Catch: java.io.IOException -> L31
        L31:
            return r3
        L32:
            boolean r3 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
            if (r3 == 0) goto L4c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
            r3.<init>()     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
            java.lang.String r4 = "MimetypesFileTypeMap: not loading mime types file: "
            r3.append(r4)     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
            r3.append(r7)     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
            java.lang.String r3 = r3.toString()     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
            com.sun.activation.registries.LogSupport.log(r3)     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
        L4c:
            if (r2 == 0) goto L92
        L4e:
            r2.close()     // Catch: java.io.IOException -> L92
            goto L92
        L52:
            r3 = move-exception
            goto L5a
        L54:
            r3 = move-exception
            goto L77
        L56:
            r7 = move-exception
            goto L95
        L58:
            r3 = move-exception
            r2 = r1
        L5a:
            boolean r4 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch: java.lang.Throwable -> L93
            if (r4 == 0) goto L72
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            r4.<init>()     // Catch: java.lang.Throwable -> L93
            r4.append(r0)     // Catch: java.lang.Throwable -> L93
            r4.append(r7)     // Catch: java.lang.Throwable -> L93
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L93
            com.sun.activation.registries.LogSupport.log(r7, r3)     // Catch: java.lang.Throwable -> L93
        L72:
            if (r2 == 0) goto L92
            goto L4e
        L75:
            r3 = move-exception
            r2 = r1
        L77:
            boolean r4 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch: java.lang.Throwable -> L93
            if (r4 == 0) goto L8f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            r4.<init>()     // Catch: java.lang.Throwable -> L93
            r4.append(r0)     // Catch: java.lang.Throwable -> L93
            r4.append(r7)     // Catch: java.lang.Throwable -> L93
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L93
            com.sun.activation.registries.LogSupport.log(r7, r3)     // Catch: java.lang.Throwable -> L93
        L8f:
            if (r2 == 0) goto L92
            goto L4e
        L92:
            return r1
        L93:
            r7 = move-exception
            r1 = r2
        L95:
            if (r1 == 0) goto L9a
            r1.close()     // Catch: java.io.IOException -> L9a
        L9a:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MimetypesFileTypeMap.loadResource(java.lang.String):com.sun.activation.registries.MimeTypeFile");
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void loadAllResources(java.util.Vector r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MimetypesFileTypeMap.loadAllResources(java.util.Vector, java.lang.String):void");
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
