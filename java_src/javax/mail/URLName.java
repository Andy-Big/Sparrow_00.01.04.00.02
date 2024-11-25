package javax.mail;

import com.rigol.scope.utilities.UnitFormat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.BitSet;
import java.util.Locale;
/* loaded from: classes2.dex */
public class URLName {
    static final int caseDiff = 32;
    private static boolean doEncode = true;
    static BitSet dontNeedEncoding;
    private String file;
    protected String fullURL;
    private int hashCode;
    private String host;
    private InetAddress hostAddress;
    private boolean hostAddressKnown;
    private String password;
    private int port;
    private String protocol;
    private String ref;
    private String username;

    static {
        try {
            doEncode = !Boolean.getBoolean("mail.URLName.dontencode");
        } catch (Exception unused) {
        }
        dontNeedEncoding = new BitSet(256);
        for (int i = 97; i <= 122; i++) {
            dontNeedEncoding.set(i);
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            dontNeedEncoding.set(i2);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            dontNeedEncoding.set(i3);
        }
        dontNeedEncoding.set(32);
        dontNeedEncoding.set(45);
        dontNeedEncoding.set(95);
        dontNeedEncoding.set(46);
        dontNeedEncoding.set(42);
    }

    public URLName(String str, String str2, int i, String str3, String str4, String str5) {
        int indexOf;
        this.hostAddressKnown = false;
        this.port = -1;
        this.hashCode = 0;
        this.protocol = str;
        this.host = str2;
        this.port = i;
        if (str3 != null && (indexOf = str3.indexOf(35)) != -1) {
            this.file = str3.substring(0, indexOf);
            this.ref = str3.substring(indexOf + 1);
        } else {
            this.file = str3;
            this.ref = null;
        }
        this.username = doEncode ? encode(str4) : str4;
        this.password = doEncode ? encode(str5) : str5;
    }

    public URLName(URL url) {
        this(url.toString());
    }

    public URLName(String str) {
        this.hostAddressKnown = false;
        this.port = -1;
        this.hashCode = 0;
        parseString(str);
    }

    public String toString() {
        if (this.fullURL == null) {
            StringBuilder sb = new StringBuilder();
            String str = this.protocol;
            if (str != null) {
                sb.append(str);
                sb.append(":");
            }
            if (this.username != null || this.host != null) {
                sb.append("//");
                String str2 = this.username;
                if (str2 != null) {
                    sb.append(str2);
                    if (this.password != null) {
                        sb.append(":");
                        sb.append(this.password);
                    }
                    sb.append("@");
                }
                String str3 = this.host;
                if (str3 != null) {
                    sb.append(str3);
                }
                if (this.port != -1) {
                    sb.append(":");
                    sb.append(Integer.toString(this.port));
                }
                if (this.file != null) {
                    sb.append("/");
                }
            }
            String str4 = this.file;
            if (str4 != null) {
                sb.append(str4);
            }
            if (this.ref != null) {
                sb.append(UnitFormat.PATTERN_SIGN);
                sb.append(this.ref);
            }
            this.fullURL = sb.toString();
        }
        return this.fullURL;
    }

    protected void parseString(String str) {
        int indexOf;
        String substring;
        int indexOf2;
        this.password = null;
        this.username = null;
        this.host = null;
        this.ref = null;
        this.file = null;
        this.protocol = null;
        this.port = -1;
        int length = str.length();
        int indexOf3 = str.indexOf(58);
        if (indexOf3 != -1) {
            this.protocol = str.substring(0, indexOf3);
        }
        int i = indexOf3 + 1;
        if (str.regionMatches(i, "//", 0, 2)) {
            int i2 = indexOf3 + 3;
            int indexOf4 = str.indexOf(47, i2);
            if (indexOf4 != -1) {
                substring = str.substring(i2, indexOf4);
                int i3 = indexOf4 + 1;
                if (i3 < length) {
                    this.file = str.substring(i3);
                } else {
                    this.file = "";
                }
            } else {
                substring = str.substring(i2);
            }
            int indexOf5 = substring.indexOf(64);
            if (indexOf5 != -1) {
                String substring2 = substring.substring(0, indexOf5);
                substring = substring.substring(indexOf5 + 1);
                int indexOf6 = substring2.indexOf(58);
                if (indexOf6 != -1) {
                    this.username = substring2.substring(0, indexOf6);
                    this.password = substring2.substring(indexOf6 + 1);
                } else {
                    this.username = substring2;
                }
            }
            if (substring.length() > 0 && substring.charAt(0) == '[') {
                indexOf2 = substring.indexOf(58, substring.indexOf(93));
            } else {
                indexOf2 = substring.indexOf(58);
            }
            if (indexOf2 != -1) {
                String substring3 = substring.substring(indexOf2 + 1);
                if (substring3.length() > 0) {
                    try {
                        this.port = Integer.parseInt(substring3);
                    } catch (NumberFormatException unused) {
                        this.port = -1;
                    }
                }
                this.host = substring.substring(0, indexOf2);
            } else {
                this.host = substring;
            }
        } else if (i < length) {
            this.file = str.substring(i);
        }
        String str2 = this.file;
        if (str2 == null || (indexOf = str2.indexOf(35)) == -1) {
            return;
        }
        this.ref = this.file.substring(indexOf + 1);
        this.file = this.file.substring(0, indexOf);
    }

    public int getPort() {
        return this.port;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getFile() {
        return this.file;
    }

    public String getRef() {
        return this.ref;
    }

    public String getHost() {
        return this.host;
    }

    public String getUsername() {
        return doEncode ? decode(this.username) : this.username;
    }

    public String getPassword() {
        return doEncode ? decode(this.password) : this.password;
    }

    public URL getURL() throws MalformedURLException {
        String str;
        String file = getFile();
        if (file == null) {
            str = "";
        } else {
            str = "/" + file;
        }
        return new URL(getProtocol(), getHost(), getPort(), str);
    }

    public boolean equals(Object obj) {
        String str;
        if (obj instanceof URLName) {
            URLName uRLName = (URLName) obj;
            String str2 = this.protocol;
            String str3 = uRLName.protocol;
            if (str2 == str3 || (str2 != null && str2.equals(str3))) {
                InetAddress hostAddress = getHostAddress();
                InetAddress hostAddress2 = uRLName.getHostAddress();
                if (hostAddress != null && hostAddress2 != null) {
                    if (!hostAddress.equals(hostAddress2)) {
                        return false;
                    }
                } else {
                    String str4 = this.host;
                    if (str4 != null && (str = uRLName.host) != null) {
                        if (!str4.equalsIgnoreCase(str)) {
                            return false;
                        }
                    } else if (this.host != uRLName.host) {
                        return false;
                    }
                }
                String str5 = this.username;
                String str6 = uRLName.username;
                if (str5 == str6 || (str5 != null && str5.equals(str6))) {
                    String str7 = this.file;
                    if (str7 == null) {
                        str7 = "";
                    }
                    String str8 = uRLName.file;
                    return str7.equals(str8 != null ? str8 : "") && this.port == uRLName.port;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.protocol;
        if (str != null) {
            this.hashCode = i + str.hashCode();
        }
        InetAddress hostAddress = getHostAddress();
        if (hostAddress != null) {
            this.hashCode += hostAddress.hashCode();
        } else {
            String str2 = this.host;
            if (str2 != null) {
                this.hashCode += str2.toLowerCase(Locale.ENGLISH).hashCode();
            }
        }
        String str3 = this.username;
        if (str3 != null) {
            this.hashCode += str3.hashCode();
        }
        String str4 = this.file;
        if (str4 != null) {
            this.hashCode += str4.hashCode();
        }
        int i2 = this.hashCode + this.port;
        this.hashCode = i2;
        return i2;
    }

    private synchronized InetAddress getHostAddress() {
        if (this.hostAddressKnown) {
            return this.hostAddress;
        } else if (this.host == null) {
            return null;
        } else {
            try {
                this.hostAddress = InetAddress.getByName(this.host);
            } catch (UnknownHostException unused) {
                this.hostAddress = null;
            }
            this.hostAddressKnown = true;
            return this.hostAddress;
        }
    }

    static String encode(String str) {
        if (str == null) {
            return null;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == ' ' || !dontNeedEncoding.get(charAt)) {
                return _encode(str);
            }
        }
        return str;
    }

    private static String _encode(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(10);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (dontNeedEncoding.get(charAt)) {
                if (charAt == ' ') {
                    charAt = '+';
                }
                sb.append(charAt);
            } else {
                try {
                    outputStreamWriter.write(charAt);
                    outputStreamWriter.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    for (int i2 = 0; i2 < byteArray.length; i2++) {
                        sb.append('%');
                        char forDigit = Character.forDigit((byteArray[i2] >> 4) & 15, 16);
                        if (Character.isLetter(forDigit)) {
                            forDigit = (char) (forDigit - ' ');
                        }
                        sb.append(forDigit);
                        char forDigit2 = Character.forDigit(byteArray[i2] & 15, 16);
                        if (Character.isLetter(forDigit2)) {
                            forDigit2 = (char) (forDigit2 - ' ');
                        }
                        sb.append(forDigit2);
                    }
                    byteArrayOutputStream.reset();
                } catch (IOException unused) {
                    byteArrayOutputStream.reset();
                }
            }
        }
        return sb.toString();
    }

    static String decode(String str) {
        if (str == null) {
            return null;
        }
        if (indexOfAny(str, "+%") == -1) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == '%') {
                int i2 = i + 3;
                try {
                    sb.append((char) Integer.parseInt(str.substring(i + 1, i2), 16));
                    i += 2;
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException("Illegal URL encoded value: " + str.substring(i, i2));
                }
            } else if (charAt == '+') {
                sb.append(' ');
            } else {
                sb.append(charAt);
            }
            i++;
        }
        String sb2 = sb.toString();
        try {
            return new String(sb2.getBytes("8859_1"));
        } catch (UnsupportedEncodingException unused2) {
            return sb2;
        }
    }

    private static int indexOfAny(String str, String str2) {
        return indexOfAny(str, str2, 0);
    }

    private static int indexOfAny(String str, String str2, int i) {
        try {
            int length = str.length();
            while (i < length) {
                if (str2.indexOf(str.charAt(i)) >= 0) {
                    return i;
                }
                i++;
            }
        } catch (StringIndexOutOfBoundsException unused) {
        }
        return -1;
    }
}
