package com.sun.activation.registries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.slf4j.Marker;
/* loaded from: classes2.dex */
public class MailcapFile {
    private static boolean addReverse = false;
    private Map type_hash = new HashMap();
    private Map fallback_hash = new HashMap();
    private Map native_commands = new HashMap();

    static {
        try {
            addReverse = Boolean.getBoolean("javax.activation.addreverse");
        } catch (Throwable unused) {
        }
    }

    public MailcapFile(String str) throws IOException {
        if (LogSupport.isLoggable()) {
            LogSupport.log("new MailcapFile: file " + str);
        }
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader(str);
            try {
                parse(new BufferedReader(fileReader2));
                try {
                    fileReader2.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                th = th;
                fileReader = fileReader2;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public MailcapFile(InputStream inputStream) throws IOException {
        if (LogSupport.isLoggable()) {
            LogSupport.log("new MailcapFile: InputStream");
        }
        parse(new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1")));
    }

    public MailcapFile() {
        if (LogSupport.isLoggable()) {
            LogSupport.log("new MailcapFile: default");
        }
    }

    public Map getMailcapList(String str) {
        Map map = (Map) this.type_hash.get(str);
        int indexOf = str.indexOf(47) + 1;
        if (str.substring(indexOf).equals(Marker.ANY_MARKER)) {
            return map;
        }
        Map map2 = (Map) this.type_hash.get(str.substring(0, indexOf) + Marker.ANY_MARKER);
        return map2 != null ? map != null ? mergeResults(map, map2) : map2 : map;
    }

    public Map getMailcapFallbackList(String str) {
        Map map = (Map) this.fallback_hash.get(str);
        int indexOf = str.indexOf(47) + 1;
        if (str.substring(indexOf).equals(Marker.ANY_MARKER)) {
            return map;
        }
        Map map2 = (Map) this.fallback_hash.get(str.substring(0, indexOf) + Marker.ANY_MARKER);
        return map2 != null ? map != null ? mergeResults(map, map2) : map2 : map;
    }

    public String[] getMimeTypes() {
        HashSet hashSet = new HashSet(this.type_hash.keySet());
        hashSet.addAll(this.fallback_hash.keySet());
        hashSet.addAll(this.native_commands.keySet());
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public String[] getNativeCommands(String str) {
        List list = (List) this.native_commands.get(str.toLowerCase(Locale.ENGLISH));
        if (list != null) {
            return (String[]) list.toArray(new String[list.size()]);
        }
        return null;
    }

    private Map mergeResults(Map map, Map map2) {
        HashMap hashMap = new HashMap(map);
        for (String str : map2.keySet()) {
            List list = (List) hashMap.get(str);
            if (list == null) {
                hashMap.put(str, map2.get(str));
            } else {
                ArrayList arrayList = new ArrayList(list);
                arrayList.addAll((List) map2.get(str));
                hashMap.put(str, arrayList);
            }
        }
        return hashMap;
    }

    public void appendToMailcap(String str) {
        if (LogSupport.isLoggable()) {
            LogSupport.log("appendToMailcap: " + str);
        }
        try {
            parse(new StringReader(str));
        } catch (IOException unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0061, code lost:
        parseLine(r1 + r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void parse(java.io.Reader r7) throws java.io.IOException {
        /*
            r6 = this;
            java.io.BufferedReader r0 = new java.io.BufferedReader
            r0.<init>(r7)
            r7 = 0
        L6:
            r1 = r7
        L7:
            java.lang.String r2 = r0.readLine()
            if (r2 == 0) goto L69
            java.lang.String r2 = r2.trim()
            r3 = 0
            char r4 = r2.charAt(r3)     // Catch: java.lang.Throwable -> L7
            r5 = 35
            if (r4 != r5) goto L1b
            goto L7
        L1b:
            int r4 = r2.length()     // Catch: java.lang.Throwable -> L7
            int r4 = r4 + (-1)
            char r4 = r2.charAt(r4)     // Catch: java.lang.Throwable -> L7
            r5 = 92
            if (r4 != r5) goto L50
            if (r1 == 0) goto L45
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7
            r4.<init>()     // Catch: java.lang.Throwable -> L7
            r4.append(r1)     // Catch: java.lang.Throwable -> L7
            int r5 = r2.length()     // Catch: java.lang.Throwable -> L7
            int r5 = r5 + (-1)
            java.lang.String r2 = r2.substring(r3, r5)     // Catch: java.lang.Throwable -> L7
            r4.append(r2)     // Catch: java.lang.Throwable -> L7
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L7
            goto L7
        L45:
            int r4 = r2.length()     // Catch: java.lang.Throwable -> L7
            int r4 = r4 + (-1)
            java.lang.String r1 = r2.substring(r3, r4)     // Catch: java.lang.Throwable -> L7
            goto L7
        L50:
            if (r1 == 0) goto L65
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7
            r3.<init>()     // Catch: java.lang.Throwable -> L7
            r3.append(r1)     // Catch: java.lang.Throwable -> L7
            r3.append(r2)     // Catch: java.lang.Throwable -> L7
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L7
            r6.parseLine(r1)     // Catch: com.sun.activation.registries.MailcapParseException -> L6 java.lang.Throwable -> L7
            goto L6
        L65:
            r6.parseLine(r2)     // Catch: java.lang.Throwable -> L7
            goto L7
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.activation.registries.MailcapFile.parse(java.io.Reader):void");
    }

    protected void parseLine(String str) throws MailcapParseException, IOException {
        int i;
        String str2;
        int nextToken;
        MailcapTokenizer mailcapTokenizer = new MailcapTokenizer(str);
        mailcapTokenizer.setIsAutoquoting(false);
        if (LogSupport.isLoggable()) {
            LogSupport.log("parse: " + str);
        }
        int nextToken2 = mailcapTokenizer.nextToken();
        if (nextToken2 != 2) {
            reportParseError(2, nextToken2, mailcapTokenizer.getCurrentTokenValue());
        }
        String lowerCase = mailcapTokenizer.getCurrentTokenValue().toLowerCase(Locale.ENGLISH);
        int nextToken3 = mailcapTokenizer.nextToken();
        if (nextToken3 != 47 && nextToken3 != 59) {
            reportParseError(47, 59, nextToken3, mailcapTokenizer.getCurrentTokenValue());
        }
        if (nextToken3 == 47) {
            int nextToken4 = mailcapTokenizer.nextToken();
            if (nextToken4 != 2) {
                reportParseError(2, nextToken4, mailcapTokenizer.getCurrentTokenValue());
            }
            str2 = mailcapTokenizer.getCurrentTokenValue().toLowerCase(Locale.ENGLISH);
            i = mailcapTokenizer.nextToken();
        } else {
            i = nextToken3;
            str2 = Marker.ANY_MARKER;
        }
        String str3 = lowerCase + "/" + str2;
        if (LogSupport.isLoggable()) {
            LogSupport.log("  Type: " + str3);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (i != 59) {
            reportParseError(59, i, mailcapTokenizer.getCurrentTokenValue());
        }
        mailcapTokenizer.setIsAutoquoting(true);
        int nextToken5 = mailcapTokenizer.nextToken();
        mailcapTokenizer.setIsAutoquoting(false);
        if (nextToken5 != 2 && nextToken5 != 59) {
            reportParseError(2, 59, nextToken5, mailcapTokenizer.getCurrentTokenValue());
        }
        if (nextToken5 == 2) {
            List list = (List) this.native_commands.get(str3);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                this.native_commands.put(str3, arrayList);
            } else {
                list.add(str);
            }
        }
        if (nextToken5 != 59) {
            nextToken5 = mailcapTokenizer.nextToken();
        }
        if (nextToken5 != 59) {
            if (nextToken5 != 5) {
                reportParseError(5, 59, nextToken5, mailcapTokenizer.getCurrentTokenValue());
                return;
            }
            return;
        }
        boolean z = false;
        do {
            int nextToken6 = mailcapTokenizer.nextToken();
            if (nextToken6 != 2) {
                reportParseError(2, nextToken6, mailcapTokenizer.getCurrentTokenValue());
            }
            String lowerCase2 = mailcapTokenizer.getCurrentTokenValue().toLowerCase(Locale.ENGLISH);
            nextToken = mailcapTokenizer.nextToken();
            if (nextToken != 61 && nextToken != 59 && nextToken != 5) {
                reportParseError(61, 59, 5, nextToken, mailcapTokenizer.getCurrentTokenValue());
            }
            if (nextToken == 61) {
                mailcapTokenizer.setIsAutoquoting(true);
                int nextToken7 = mailcapTokenizer.nextToken();
                mailcapTokenizer.setIsAutoquoting(false);
                if (nextToken7 != 2) {
                    reportParseError(2, nextToken7, mailcapTokenizer.getCurrentTokenValue());
                }
                String currentTokenValue = mailcapTokenizer.getCurrentTokenValue();
                if (lowerCase2.startsWith("x-java-")) {
                    String substring = lowerCase2.substring(7);
                    if (substring.equals("fallback-entry") && currentTokenValue.equalsIgnoreCase("true")) {
                        z = true;
                    } else {
                        if (LogSupport.isLoggable()) {
                            LogSupport.log("    Command: " + substring + ", Class: " + currentTokenValue);
                        }
                        List list2 = (List) linkedHashMap.get(substring);
                        if (list2 == null) {
                            list2 = new ArrayList();
                            linkedHashMap.put(substring, list2);
                        }
                        if (addReverse) {
                            list2.add(0, currentTokenValue);
                        } else {
                            list2.add(currentTokenValue);
                        }
                    }
                }
                nextToken = mailcapTokenizer.nextToken();
                continue;
            }
        } while (nextToken == 59);
        Map map = z ? this.fallback_hash : this.type_hash;
        Map map2 = (Map) map.get(str3);
        if (map2 == null) {
            map.put(str3, linkedHashMap);
            return;
        }
        if (LogSupport.isLoggable()) {
            LogSupport.log("Merging commands for type " + str3);
        }
        for (String str4 : map2.keySet()) {
            List list3 = (List) map2.get(str4);
            List<String> list4 = (List) linkedHashMap.get(str4);
            if (list4 != null) {
                for (String str5 : list4) {
                    if (!list3.contains(str5)) {
                        if (addReverse) {
                            list3.add(0, str5);
                        } else {
                            list3.add(str5);
                        }
                    }
                }
            }
        }
        for (String str6 : linkedHashMap.keySet()) {
            if (!map2.containsKey(str6)) {
                map2.put(str6, (List) linkedHashMap.get(str6));
            }
        }
    }

    protected static void reportParseError(int i, int i2, String str) throws MailcapParseException {
        throw new MailcapParseException("Encountered a " + MailcapTokenizer.nameForToken(i2) + " token (" + str + ") while expecting a " + MailcapTokenizer.nameForToken(i) + " token.");
    }

    protected static void reportParseError(int i, int i2, int i3, String str) throws MailcapParseException {
        throw new MailcapParseException("Encountered a " + MailcapTokenizer.nameForToken(i3) + " token (" + str + ") while expecting a " + MailcapTokenizer.nameForToken(i) + " or a " + MailcapTokenizer.nameForToken(i2) + " token.");
    }

    protected static void reportParseError(int i, int i2, int i3, int i4, String str) throws MailcapParseException {
        if (LogSupport.isLoggable()) {
            LogSupport.log("PARSE ERROR: Encountered a " + MailcapTokenizer.nameForToken(i4) + " token (" + str + ") while expecting a " + MailcapTokenizer.nameForToken(i) + ", a " + MailcapTokenizer.nameForToken(i2) + ", or a " + MailcapTokenizer.nameForToken(i3) + " token.");
        }
        throw new MailcapParseException("Encountered a " + MailcapTokenizer.nameForToken(i4) + " token (" + str + ") while expecting a " + MailcapTokenizer.nameForToken(i) + ", a " + MailcapTokenizer.nameForToken(i2) + ", or a " + MailcapTokenizer.nameForToken(i3) + " token.");
    }
}
