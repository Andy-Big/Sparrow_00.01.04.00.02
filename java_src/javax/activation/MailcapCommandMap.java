package javax.activation;

import com.sun.activation.registries.LogSupport;
import com.sun.activation.registries.MailcapFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes2.dex */
public class MailcapCommandMap extends CommandMap {
    private static final int PROG = 0;
    private static final String confDir;
    private MailcapFile[] DB;

    static {
        String str;
        try {
            str = (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: javax.activation.MailcapCommandMap.1
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

    public MailcapCommandMap() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(null);
        LogSupport.log("MailcapCommandMap: load HOME");
        try {
            String property = System.getProperty("user.home");
            if (property != null) {
                MailcapFile loadFile = loadFile(property + File.separator + ".mailcap");
                if (loadFile != null) {
                    arrayList.add(loadFile);
                }
            }
        } catch (SecurityException unused) {
        }
        LogSupport.log("MailcapCommandMap: load SYS");
        try {
            if (confDir != null) {
                MailcapFile loadFile2 = loadFile(confDir + "mailcap");
                if (loadFile2 != null) {
                    arrayList.add(loadFile2);
                }
            }
        } catch (SecurityException unused2) {
        }
        LogSupport.log("MailcapCommandMap: load JAR");
        loadAllResources(arrayList, "META-INF/mailcap");
        LogSupport.log("MailcapCommandMap: load DEF");
        MailcapFile loadResource = loadResource("/META-INF/mailcap.default");
        if (loadResource != null) {
            arrayList.add(loadResource);
        }
        MailcapFile[] mailcapFileArr = new MailcapFile[arrayList.size()];
        this.DB = mailcapFileArr;
        this.DB = (MailcapFile[]) arrayList.toArray(mailcapFileArr);
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
    private com.sun.activation.registries.MailcapFile loadResource(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "MailcapCommandMap: can't load "
            r1 = 0
            java.lang.Class r2 = r6.getClass()     // Catch: java.lang.Throwable -> L56 java.lang.SecurityException -> L58 java.io.IOException -> L75
            java.io.InputStream r2 = javax.activation.SecuritySupport.getResourceAsStream(r2, r7)     // Catch: java.lang.Throwable -> L56 java.lang.SecurityException -> L58 java.io.IOException -> L75
            if (r2 == 0) goto L32
            com.sun.activation.registries.MailcapFile r3 = new com.sun.activation.registries.MailcapFile     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
            r3.<init>(r2)     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
            boolean r4 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
            if (r4 == 0) goto L2c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
            r4.<init>()     // Catch: java.lang.SecurityException -> L52 java.io.IOException -> L54 java.lang.Throwable -> L93
            java.lang.String r5 = "MailcapCommandMap: successfully loaded mailcap file: "
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
            java.lang.String r4 = "MailcapCommandMap: not loading mailcap file: "
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
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MailcapCommandMap.loadResource(java.lang.String):com.sun.activation.registries.MailcapFile");
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void loadAllResources(java.util.List r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MailcapCommandMap.loadAllResources(java.util.List, java.lang.String):void");
    }

    private MailcapFile loadFile(String str) {
        try {
            return new MailcapFile(str);
        } catch (IOException unused) {
            return null;
        }
    }

    public MailcapCommandMap(String str) throws IOException {
        this();
        if (LogSupport.isLoggable()) {
            LogSupport.log("MailcapCommandMap: load PROG from " + str);
        }
        MailcapFile[] mailcapFileArr = this.DB;
        if (mailcapFileArr[0] == null) {
            mailcapFileArr[0] = new MailcapFile(str);
        }
    }

    public MailcapCommandMap(InputStream inputStream) {
        this();
        LogSupport.log("MailcapCommandMap: load PROG");
        MailcapFile[] mailcapFileArr = this.DB;
        if (mailcapFileArr[0] == null) {
            try {
                mailcapFileArr[0] = new MailcapFile(inputStream);
            } catch (IOException unused) {
            }
        }
    }

    @Override // javax.activation.CommandMap
    public synchronized CommandInfo[] getPreferredCommands(String str) {
        ArrayList arrayList;
        Map mailcapFallbackList;
        Map mailcapList;
        arrayList = new ArrayList();
        if (str != null) {
            str = str.toLowerCase(Locale.ENGLISH);
        }
        for (int i = 0; i < this.DB.length; i++) {
            if (this.DB[i] != null && (mailcapList = this.DB[i].getMailcapList(str)) != null) {
                appendPrefCmdsToList(mailcapList, arrayList);
            }
        }
        for (int i2 = 0; i2 < this.DB.length; i2++) {
            if (this.DB[i2] != null && (mailcapFallbackList = this.DB[i2].getMailcapFallbackList(str)) != null) {
                appendPrefCmdsToList(mailcapFallbackList, arrayList);
            }
        }
        return (CommandInfo[]) arrayList.toArray(new CommandInfo[arrayList.size()]);
    }

    private void appendPrefCmdsToList(Map map, List list) {
        for (String str : map.keySet()) {
            if (!checkForVerb(list, str)) {
                list.add(new CommandInfo(str, (String) ((List) map.get(str)).get(0)));
            }
        }
    }

    private boolean checkForVerb(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((CommandInfo) it.next()).getCommandName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.activation.CommandMap
    public synchronized CommandInfo[] getAllCommands(String str) {
        ArrayList arrayList;
        Map mailcapFallbackList;
        Map mailcapList;
        arrayList = new ArrayList();
        if (str != null) {
            str = str.toLowerCase(Locale.ENGLISH);
        }
        for (int i = 0; i < this.DB.length; i++) {
            if (this.DB[i] != null && (mailcapList = this.DB[i].getMailcapList(str)) != null) {
                appendCmdsToList(mailcapList, arrayList);
            }
        }
        for (int i2 = 0; i2 < this.DB.length; i2++) {
            if (this.DB[i2] != null && (mailcapFallbackList = this.DB[i2].getMailcapFallbackList(str)) != null) {
                appendCmdsToList(mailcapFallbackList, arrayList);
            }
        }
        return (CommandInfo[]) arrayList.toArray(new CommandInfo[arrayList.size()]);
    }

    private void appendCmdsToList(Map map, List list) {
        for (String str : map.keySet()) {
            for (String str2 : (List) map.get(str)) {
                list.add(new CommandInfo(str, str2));
            }
        }
    }

    @Override // javax.activation.CommandMap
    public synchronized CommandInfo getCommand(String str, String str2) {
        Map mailcapFallbackList;
        List list;
        String str3;
        Map mailcapList;
        List list2;
        String str4;
        if (str != null) {
            try {
                str = str.toLowerCase(Locale.ENGLISH);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (int i = 0; i < this.DB.length; i++) {
            if (this.DB[i] != null && (mailcapList = this.DB[i].getMailcapList(str)) != null && (list2 = (List) mailcapList.get(str2)) != null && (str4 = (String) list2.get(0)) != null) {
                return new CommandInfo(str2, str4);
            }
        }
        for (int i2 = 0; i2 < this.DB.length; i2++) {
            if (this.DB[i2] != null && (mailcapFallbackList = this.DB[i2].getMailcapFallbackList(str)) != null && (list = (List) mailcapFallbackList.get(str2)) != null && (str3 = (String) list.get(0)) != null) {
                return new CommandInfo(str2, str3);
            }
        }
        return null;
    }

    public synchronized void addMailcap(String str) {
        LogSupport.log("MailcapCommandMap: add to PROG");
        if (this.DB[0] == null) {
            this.DB[0] = new MailcapFile();
        }
        this.DB[0].appendToMailcap(str);
    }

    @Override // javax.activation.CommandMap
    public synchronized DataContentHandler createDataContentHandler(String str) {
        List list;
        DataContentHandler dataContentHandler;
        List list2;
        DataContentHandler dataContentHandler2;
        if (LogSupport.isLoggable()) {
            LogSupport.log("MailcapCommandMap: createDataContentHandler for " + str);
        }
        if (str != null) {
            str = str.toLowerCase(Locale.ENGLISH);
        }
        for (int i = 0; i < this.DB.length; i++) {
            if (this.DB[i] != null) {
                if (LogSupport.isLoggable()) {
                    LogSupport.log("  search DB #" + i);
                }
                Map mailcapList = this.DB[i].getMailcapList(str);
                if (mailcapList != null && (list2 = (List) mailcapList.get("content-handler")) != null && (dataContentHandler2 = getDataContentHandler((String) list2.get(0))) != null) {
                    return dataContentHandler2;
                }
            }
        }
        for (int i2 = 0; i2 < this.DB.length; i2++) {
            if (this.DB[i2] != null) {
                if (LogSupport.isLoggable()) {
                    LogSupport.log("  search fallback DB #" + i2);
                }
                Map mailcapFallbackList = this.DB[i2].getMailcapFallbackList(str);
                if (mailcapFallbackList != null && (list = (List) mailcapFallbackList.get("content-handler")) != null && (dataContentHandler = getDataContentHandler((String) list.get(0))) != null) {
                    return dataContentHandler;
                }
            }
        }
        return null;
    }

    private DataContentHandler getDataContentHandler(String str) {
        Class<?> cls;
        if (LogSupport.isLoggable()) {
            LogSupport.log("    got content-handler");
        }
        if (LogSupport.isLoggable()) {
            LogSupport.log("      class " + str);
        }
        try {
            ClassLoader contextClassLoader = SecuritySupport.getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = getClass().getClassLoader();
            }
            try {
                cls = contextClassLoader.loadClass(str);
            } catch (Exception unused) {
                cls = Class.forName(str);
            }
            if (cls != null) {
                return (DataContentHandler) cls.newInstance();
            }
            return null;
        } catch (ClassNotFoundException e) {
            if (LogSupport.isLoggable()) {
                LogSupport.log("Can't load DCH " + str, e);
                return null;
            }
            return null;
        } catch (IllegalAccessException e2) {
            if (LogSupport.isLoggable()) {
                LogSupport.log("Can't load DCH " + str, e2);
                return null;
            }
            return null;
        } catch (InstantiationException e3) {
            if (LogSupport.isLoggable()) {
                LogSupport.log("Can't load DCH " + str, e3);
                return null;
            }
            return null;
        }
    }

    @Override // javax.activation.CommandMap
    public synchronized String[] getMimeTypes() {
        ArrayList arrayList;
        String[] mimeTypes;
        arrayList = new ArrayList();
        for (int i = 0; i < this.DB.length; i++) {
            if (this.DB[i] != null && (mimeTypes = this.DB[i].getMimeTypes()) != null) {
                for (int i2 = 0; i2 < mimeTypes.length; i2++) {
                    if (!arrayList.contains(mimeTypes[i2])) {
                        arrayList.add(mimeTypes[i2]);
                    }
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public synchronized String[] getNativeCommands(String str) {
        ArrayList arrayList;
        String[] nativeCommands;
        arrayList = new ArrayList();
        if (str != null) {
            str = str.toLowerCase(Locale.ENGLISH);
        }
        for (int i = 0; i < this.DB.length; i++) {
            if (this.DB[i] != null && (nativeCommands = this.DB[i].getNativeCommands(str)) != null) {
                for (int i2 = 0; i2 < nativeCommands.length; i2++) {
                    if (!arrayList.contains(nativeCommands[i2])) {
                        arrayList.add(nativeCommands[i2]);
                    }
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
