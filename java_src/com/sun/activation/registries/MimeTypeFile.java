package com.sun.activation.registries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Hashtable;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
public class MimeTypeFile {
    private String fname;
    private Hashtable type_hash;

    public MimeTypeFile(String str) throws IOException {
        this.fname = null;
        this.type_hash = new Hashtable();
        this.fname = str;
        FileReader fileReader = new FileReader(new File(this.fname));
        try {
            parse(new BufferedReader(fileReader));
        } finally {
            try {
                fileReader.close();
            } catch (IOException unused) {
            }
        }
    }

    public MimeTypeFile(InputStream inputStream) throws IOException {
        this.fname = null;
        this.type_hash = new Hashtable();
        parse(new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1")));
    }

    public MimeTypeFile() {
        this.fname = null;
        this.type_hash = new Hashtable();
    }

    public MimeTypeEntry getMimeTypeEntry(String str) {
        return (MimeTypeEntry) this.type_hash.get(str);
    }

    public String getMIMETypeString(String str) {
        MimeTypeEntry mimeTypeEntry = getMimeTypeEntry(str);
        if (mimeTypeEntry != null) {
            return mimeTypeEntry.getMIMEType();
        }
        return null;
    }

    public void appendToRegistry(String str) {
        try {
            parse(new BufferedReader(new StringReader(str)));
        } catch (IOException unused) {
        }
    }

    private void parse(BufferedReader bufferedReader) throws IOException {
        String str;
        String readLine;
        loop0: while (true) {
            str = null;
            while (true) {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break loop0;
                }
                if (str != null) {
                    readLine = str + readLine;
                }
                int length = readLine.length();
                if (readLine.length() > 0) {
                    int i = length - 1;
                    if (readLine.charAt(i) == '\\') {
                        str = readLine.substring(0, i);
                    }
                }
            }
            parseEntry(readLine);
        }
        if (str != null) {
            parseEntry(str);
        }
    }

    private void parseEntry(String str) {
        MimeTypeEntry mimeTypeEntry;
        MimeTypeEntry mimeTypeEntry2;
        String trim = str.trim();
        if (trim.length() == 0 || trim.charAt(0) == '#') {
            return;
        }
        if (trim.indexOf(61) > 0) {
            LineTokenizer lineTokenizer = new LineTokenizer(trim);
            String str2 = null;
            while (lineTokenizer.hasMoreTokens()) {
                String nextToken = lineTokenizer.nextToken();
                String nextToken2 = (lineTokenizer.hasMoreTokens() && lineTokenizer.nextToken().equals("=") && lineTokenizer.hasMoreTokens()) ? lineTokenizer.nextToken() : null;
                if (nextToken2 == null) {
                    if (LogSupport.isLoggable()) {
                        LogSupport.log("Bad .mime.types entry: " + trim);
                        return;
                    }
                    return;
                } else if (nextToken.equals("type")) {
                    str2 = nextToken2;
                } else if (nextToken.equals("exts")) {
                    StringTokenizer stringTokenizer = new StringTokenizer(nextToken2, ",");
                    while (stringTokenizer.hasMoreTokens()) {
                        String nextToken3 = stringTokenizer.nextToken();
                        this.type_hash.put(nextToken3, new MimeTypeEntry(str2, nextToken3));
                        if (LogSupport.isLoggable()) {
                            LogSupport.log("Added: " + mimeTypeEntry2.toString());
                        }
                    }
                }
            }
            return;
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(trim);
        if (stringTokenizer2.countTokens() == 0) {
            return;
        }
        String nextToken4 = stringTokenizer2.nextToken();
        while (stringTokenizer2.hasMoreTokens()) {
            String nextToken5 = stringTokenizer2.nextToken();
            this.type_hash.put(nextToken5, new MimeTypeEntry(nextToken4, nextToken5));
            if (LogSupport.isLoggable()) {
                LogSupport.log("Added: " + mimeTypeEntry.toString());
            }
        }
    }
}
