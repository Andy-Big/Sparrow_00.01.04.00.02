package javax.mail.internet;

import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.PropUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.mail.Header;
import javax.mail.MessagingException;
/* loaded from: classes2.dex */
public class InternetHeaders {
    private static final boolean ignoreWhitespaceLines = PropUtil.getBooleanSystemProperty("mail.mime.ignorewhitespacelines", false);
    protected List<InternetHeader> headers;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static final class InternetHeader extends Header {
        String line;

        public InternetHeader(String str) {
            super("", "");
            int indexOf = str.indexOf(58);
            if (indexOf < 0) {
                this.name = str.trim();
            } else {
                this.name = str.substring(0, indexOf).trim();
            }
            this.line = str;
        }

        public InternetHeader(String str, String str2) {
            super(str, "");
            if (str2 != null) {
                this.line = str + ": " + str2;
                return;
            }
            this.line = null;
        }

        @Override // javax.mail.Header
        public String getValue() {
            char charAt;
            int indexOf = this.line.indexOf(58);
            if (indexOf < 0) {
                return this.line;
            }
            while (true) {
                indexOf++;
                if (indexOf >= this.line.length() || ((charAt = this.line.charAt(indexOf)) != ' ' && charAt != '\t' && charAt != '\r' && charAt != '\n')) {
                    break;
                }
            }
            return this.line.substring(indexOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class MatchEnum {
        private Iterator<InternetHeader> e;
        private boolean match;
        private String[] names;
        private InternetHeader next_header = null;
        private boolean want_line;

        MatchEnum(List<InternetHeader> list, String[] strArr, boolean z, boolean z2) {
            this.e = list.iterator();
            this.names = strArr;
            this.match = z;
            this.want_line = z2;
        }

        public boolean hasMoreElements() {
            if (this.next_header == null) {
                this.next_header = nextMatch();
            }
            return this.next_header != null;
        }

        public Object nextElement() {
            if (this.next_header == null) {
                this.next_header = nextMatch();
            }
            InternetHeader internetHeader = this.next_header;
            if (internetHeader == null) {
                throw new NoSuchElementException("No more headers");
            }
            this.next_header = null;
            if (this.want_line) {
                return internetHeader.line;
            }
            return new Header(internetHeader.getName(), internetHeader.getValue());
        }

        private InternetHeader nextMatch() {
            while (this.e.hasNext()) {
                InternetHeader next = this.e.next();
                if (next.line != null) {
                    if (this.names == null) {
                        if (this.match) {
                            return null;
                        }
                        return next;
                    }
                    int i = 0;
                    while (true) {
                        String[] strArr = this.names;
                        if (i < strArr.length) {
                            if (!strArr[i].equalsIgnoreCase(next.getName())) {
                                i++;
                            } else if (this.match) {
                                return next;
                            }
                        } else if (!this.match) {
                            return next;
                        }
                    }
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class MatchStringEnum extends MatchEnum implements Enumeration<String> {
        MatchStringEnum(List<InternetHeader> list, String[] strArr, boolean z) {
            super(list, strArr, z, true);
        }

        @Override // javax.mail.internet.InternetHeaders.MatchEnum, java.util.Enumeration
        public String nextElement() {
            return (String) super.nextElement();
        }
    }

    /* loaded from: classes2.dex */
    static class MatchHeaderEnum extends MatchEnum implements Enumeration<Header> {
        MatchHeaderEnum(List<InternetHeader> list, String[] strArr, boolean z) {
            super(list, strArr, z, false);
        }

        @Override // javax.mail.internet.InternetHeaders.MatchEnum, java.util.Enumeration
        public Header nextElement() {
            return (Header) super.nextElement();
        }
    }

    public InternetHeaders() {
        ArrayList arrayList = new ArrayList(40);
        this.headers = arrayList;
        arrayList.add(new InternetHeader("Return-Path", null));
        this.headers.add(new InternetHeader("Received", null));
        this.headers.add(new InternetHeader("Resent-Date", null));
        this.headers.add(new InternetHeader("Resent-From", null));
        this.headers.add(new InternetHeader("Resent-Sender", null));
        this.headers.add(new InternetHeader("Resent-To", null));
        this.headers.add(new InternetHeader("Resent-Cc", null));
        this.headers.add(new InternetHeader("Resent-Bcc", null));
        this.headers.add(new InternetHeader("Resent-Message-Id", null));
        this.headers.add(new InternetHeader("Date", null));
        this.headers.add(new InternetHeader("From", null));
        this.headers.add(new InternetHeader("Sender", null));
        this.headers.add(new InternetHeader("Reply-To", null));
        this.headers.add(new InternetHeader("To", null));
        this.headers.add(new InternetHeader("Cc", null));
        this.headers.add(new InternetHeader("Bcc", null));
        this.headers.add(new InternetHeader("Message-Id", null));
        this.headers.add(new InternetHeader("In-Reply-To", null));
        this.headers.add(new InternetHeader("References", null));
        this.headers.add(new InternetHeader("Subject", null));
        this.headers.add(new InternetHeader("Comments", null));
        this.headers.add(new InternetHeader("Keywords", null));
        this.headers.add(new InternetHeader("Errors-To", null));
        this.headers.add(new InternetHeader("MIME-Version", null));
        this.headers.add(new InternetHeader("Content-Type", null));
        this.headers.add(new InternetHeader("Content-Transfer-Encoding", null));
        this.headers.add(new InternetHeader("Content-MD5", null));
        this.headers.add(new InternetHeader(":", null));
        this.headers.add(new InternetHeader("Content-Length", null));
        this.headers.add(new InternetHeader("Status", null));
    }

    public InternetHeaders(InputStream inputStream) throws MessagingException {
        this(inputStream, false);
    }

    public InternetHeaders(InputStream inputStream, boolean z) throws MessagingException {
        this.headers = new ArrayList(40);
        load(inputStream, z);
    }

    public void load(InputStream inputStream) throws MessagingException {
        load(inputStream, false);
    }

    public void load(InputStream inputStream, boolean z) throws MessagingException {
        LineInputStream lineInputStream = new LineInputStream(inputStream, z);
        StringBuilder sb = new StringBuilder();
        boolean z2 = true;
        String str = null;
        while (true) {
            try {
                String readLine = lineInputStream.readLine();
                if (readLine == null || !(readLine.startsWith(" ") || readLine.startsWith("\t"))) {
                    if (str != null) {
                        addHeaderLine(str);
                    } else if (sb.length() > 0) {
                        addHeaderLine(sb.toString());
                        sb.setLength(0);
                    }
                    str = readLine;
                } else {
                    if (str != null) {
                        sb.append(str);
                        str = null;
                    }
                    if (z2) {
                        String trim = readLine.trim();
                        if (trim.length() > 0) {
                            sb.append(trim);
                        }
                    } else {
                        if (sb.length() > 0) {
                            sb.append("\r\n");
                        }
                        sb.append(readLine);
                    }
                }
                if (readLine == null || isEmpty(readLine)) {
                    return;
                }
                z2 = false;
            } catch (IOException e) {
                throw new MessagingException("Error in input stream", e);
            }
        }
    }

    private static final boolean isEmpty(String str) {
        return str.length() == 0 || (ignoreWhitespaceLines && str.trim().length() == 0);
    }

    public String[] getHeader(String str) {
        ArrayList arrayList = new ArrayList();
        for (InternetHeader internetHeader : this.headers) {
            if (str.equalsIgnoreCase(internetHeader.getName()) && internetHeader.line != null) {
                arrayList.add(internetHeader.getValue());
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public String getHeader(String str, String str2) {
        String[] header = getHeader(str);
        if (header == null) {
            return null;
        }
        if (header.length == 1 || str2 == null) {
            return header[0];
        }
        StringBuilder sb = new StringBuilder(header[0]);
        for (int i = 1; i < header.length; i++) {
            sb.append(str2);
            sb.append(header[i]);
        }
        return sb.toString();
    }

    public void setHeader(String str, String str2) {
        int indexOf;
        int i = 0;
        boolean z = false;
        while (i < this.headers.size()) {
            InternetHeader internetHeader = this.headers.get(i);
            if (str.equalsIgnoreCase(internetHeader.getName())) {
                if (!z) {
                    if (internetHeader.line != null && (indexOf = internetHeader.line.indexOf(58)) >= 0) {
                        internetHeader.line = internetHeader.line.substring(0, indexOf + 1) + " " + str2;
                    } else {
                        internetHeader.line = str + ": " + str2;
                    }
                    z = true;
                } else {
                    this.headers.remove(i);
                    i--;
                }
            }
            i++;
        }
        if (z) {
            return;
        }
        addHeader(str, str2);
    }

    public void addHeader(String str, String str2) {
        int size = this.headers.size();
        boolean z = str.equalsIgnoreCase("Received") || str.equalsIgnoreCase("Return-Path");
        if (z) {
            size = 0;
        }
        for (int size2 = this.headers.size() - 1; size2 >= 0; size2--) {
            InternetHeader internetHeader = this.headers.get(size2);
            if (str.equalsIgnoreCase(internetHeader.getName())) {
                if (!z) {
                    this.headers.add(size2 + 1, new InternetHeader(str, str2));
                    return;
                }
                size = size2;
            }
            if (!z && internetHeader.getName().equals(":")) {
                size = size2;
            }
        }
        this.headers.add(size, new InternetHeader(str, str2));
    }

    public void removeHeader(String str) {
        for (int i = 0; i < this.headers.size(); i++) {
            InternetHeader internetHeader = this.headers.get(i);
            if (str.equalsIgnoreCase(internetHeader.getName())) {
                internetHeader.line = null;
            }
        }
    }

    public Enumeration<Header> getAllHeaders() {
        return new MatchHeaderEnum(this.headers, null, false);
    }

    public Enumeration<Header> getMatchingHeaders(String[] strArr) {
        return new MatchHeaderEnum(this.headers, strArr, true);
    }

    public Enumeration<Header> getNonMatchingHeaders(String[] strArr) {
        return new MatchHeaderEnum(this.headers, strArr, false);
    }

    public void addHeaderLine(String str) {
        try {
            char charAt = str.charAt(0);
            if (charAt != ' ' && charAt != '\t') {
                this.headers.add(new InternetHeader(str));
            }
            InternetHeader internetHeader = this.headers.get(this.headers.size() - 1);
            internetHeader.line += "\r\n" + str;
        } catch (StringIndexOutOfBoundsException | NoSuchElementException unused) {
        }
    }

    public Enumeration<String> getAllHeaderLines() {
        return getNonMatchingHeaderLines(null);
    }

    public Enumeration<String> getMatchingHeaderLines(String[] strArr) {
        return new MatchStringEnum(this.headers, strArr, true);
    }

    public Enumeration<String> getNonMatchingHeaderLines(String[] strArr) {
        return new MatchStringEnum(this.headers, strArr, false);
    }
}
