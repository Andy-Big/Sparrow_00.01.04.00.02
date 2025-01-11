package javax.activation;

import com.sun.activation.registries.LogSupport;
import com.sun.activation.registries.MailcapFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
    */
    private MailcapFile loadResource(String str) {
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
                    MailcapFile mailcapFile = new MailcapFile(inputStream);
                    if (LogSupport.isLoggable()) {
                        LogSupport.log("MailcapCommandMap: successfully loaded mailcap file: " + str);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return mailcapFile;
                } else if (LogSupport.isLoggable()) {
                    LogSupport.log("MailcapCommandMap: not loading mailcap file: " + str);
                }
            } catch (IOException e3) {
                e = e3;
                if (LogSupport.isLoggable()) {
                    LogSupport.log("MailcapCommandMap: can't load " + str, e);
                }
            } catch (SecurityException e4) {
                e = e4;
                if (LogSupport.isLoggable()) {
                    LogSupport.log("MailcapCommandMap: can't load " + str, e);
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
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void loadAllResources(List list, String str) {
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
                    LogSupport.log("MailcapCommandMap: getResources");
                }
                int i = 0;
                while (r1 < systemResources.length) {
                    try {
                        URL url = systemResources[r1];
                        InputStream inputStream = null;
                        if (LogSupport.isLoggable()) {
                            LogSupport.log("MailcapCommandMap: URL " + url);
                        }
                        try {
                            try {
                                inputStream = SecuritySupport.openStream(url);
                                if (inputStream != null) {
                                    list.add(new MailcapFile(inputStream));
                                    try {
                                        if (LogSupport.isLoggable()) {
                                            LogSupport.log("MailcapCommandMap: successfully loaded mailcap file from URL: " + url);
                                        }
                                        i = 1;
                                    } catch (IOException e) {
                                        e = e;
                                        i = 1;
                                        if (LogSupport.isLoggable()) {
                                            LogSupport.log("MailcapCommandMap: can't load " + url, e);
                                        }
                                        r1 = inputStream == null ? r1 + 1 : 0;
                                        inputStream.close();
                                    } catch (SecurityException e2) {
                                        e = e2;
                                        i = 1;
                                        if (LogSupport.isLoggable()) {
                                            LogSupport.log("MailcapCommandMap: can't load " + url, e);
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
                                    LogSupport.log("MailcapCommandMap: not loading mailcap file from URL: " + url);
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
                            LogSupport.log("MailcapCommandMap: can't load " + str, e);
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
            if (LogSupport.isLoggable()) {
                LogSupport.log("MailcapCommandMap: !anyLoaded");
            }
            MailcapFile loadResource = loadResource("/" + str);
            if (loadResource != null) {
                list.add(loadResource);
            }
        }
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
