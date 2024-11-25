package javax.mail.internet;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.LineOutputStream;
import com.sun.mail.util.PropUtil;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.MessageAware;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.MultipartDataSource;
/* loaded from: classes2.dex */
public class MimeMultipart extends Multipart {
    protected boolean allowEmpty;
    protected boolean complete;
    protected DataSource ds;
    protected boolean ignoreExistingBoundaryParameter;
    protected boolean ignoreMissingBoundaryParameter;
    protected boolean ignoreMissingEndBoundary;
    protected boolean parsed;
    protected String preamble;

    public MimeMultipart() {
        this("mixed");
    }

    public MimeMultipart(String str) {
        this.ds = null;
        this.parsed = true;
        this.complete = true;
        this.preamble = null;
        this.ignoreMissingEndBoundary = true;
        this.ignoreMissingBoundaryParameter = true;
        this.ignoreExistingBoundaryParameter = false;
        this.allowEmpty = false;
        String uniqueBoundaryValue = UniqueValue.getUniqueBoundaryValue();
        ContentType contentType = new ContentType("multipart", str, null);
        contentType.setParameter("boundary", uniqueBoundaryValue);
        this.contentType = contentType.toString();
        initializeProperties();
    }

    public MimeMultipart(BodyPart... bodyPartArr) throws MessagingException {
        this();
        for (BodyPart bodyPart : bodyPartArr) {
            super.addBodyPart(bodyPart);
        }
    }

    public MimeMultipart(String str, BodyPart... bodyPartArr) throws MessagingException {
        this(str);
        for (BodyPart bodyPart : bodyPartArr) {
            super.addBodyPart(bodyPart);
        }
    }

    public MimeMultipart(DataSource dataSource) throws MessagingException {
        this.ds = null;
        this.parsed = true;
        this.complete = true;
        this.preamble = null;
        this.ignoreMissingEndBoundary = true;
        this.ignoreMissingBoundaryParameter = true;
        this.ignoreExistingBoundaryParameter = false;
        this.allowEmpty = false;
        if (dataSource instanceof MessageAware) {
            setParent(((MessageAware) dataSource).getMessageContext().getPart());
        }
        if (dataSource instanceof MultipartDataSource) {
            setMultipartDataSource((MultipartDataSource) dataSource);
            return;
        }
        this.parsed = false;
        this.ds = dataSource;
        this.contentType = dataSource.getContentType();
    }

    protected void initializeProperties() {
        this.ignoreMissingEndBoundary = PropUtil.getBooleanSystemProperty("mail.mime.multipart.ignoremissingendboundary", true);
        this.ignoreMissingBoundaryParameter = PropUtil.getBooleanSystemProperty("mail.mime.multipart.ignoremissingboundaryparameter", true);
        this.ignoreExistingBoundaryParameter = PropUtil.getBooleanSystemProperty("mail.mime.multipart.ignoreexistingboundaryparameter", false);
        this.allowEmpty = PropUtil.getBooleanSystemProperty("mail.mime.multipart.allowempty", false);
    }

    public synchronized void setSubType(String str) throws MessagingException {
        ContentType contentType = new ContentType(this.contentType);
        contentType.setSubType(str);
        this.contentType = contentType.toString();
    }

    @Override // javax.mail.Multipart
    public synchronized int getCount() throws MessagingException {
        parse();
        return super.getCount();
    }

    @Override // javax.mail.Multipart
    public synchronized BodyPart getBodyPart(int i) throws MessagingException {
        parse();
        return super.getBodyPart(i);
    }

    public synchronized BodyPart getBodyPart(String str) throws MessagingException {
        parse();
        int count = getCount();
        for (int i = 0; i < count; i++) {
            MimeBodyPart mimeBodyPart = (MimeBodyPart) getBodyPart(i);
            String contentID = mimeBodyPart.getContentID();
            if (contentID != null && contentID.equals(str)) {
                return mimeBodyPart;
            }
        }
        return null;
    }

    @Override // javax.mail.Multipart
    public boolean removeBodyPart(BodyPart bodyPart) throws MessagingException {
        parse();
        return super.removeBodyPart(bodyPart);
    }

    @Override // javax.mail.Multipart
    public void removeBodyPart(int i) throws MessagingException {
        parse();
        super.removeBodyPart(i);
    }

    @Override // javax.mail.Multipart
    public synchronized void addBodyPart(BodyPart bodyPart) throws MessagingException {
        parse();
        super.addBodyPart(bodyPart);
    }

    @Override // javax.mail.Multipart
    public synchronized void addBodyPart(BodyPart bodyPart, int i) throws MessagingException {
        parse();
        super.addBodyPart(bodyPart, i);
    }

    public synchronized boolean isComplete() throws MessagingException {
        parse();
        return this.complete;
    }

    public synchronized String getPreamble() throws MessagingException {
        parse();
        return this.preamble;
    }

    public synchronized void setPreamble(String str) throws MessagingException {
        this.preamble = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void updateHeaders() throws MessagingException {
        parse();
        for (int i = 0; i < this.parts.size(); i++) {
            ((MimeBodyPart) this.parts.elementAt(i)).updateHeaders();
        }
    }

    @Override // javax.mail.Multipart
    public synchronized void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        parse();
        String str = "--" + new ContentType(this.contentType).getParameter("boundary");
        LineOutputStream lineOutputStream = new LineOutputStream(outputStream);
        if (this.preamble != null) {
            byte[] bytes = ASCIIUtility.getBytes(this.preamble);
            lineOutputStream.write(bytes);
            if (bytes.length > 0 && bytes[bytes.length - 1] != 13 && bytes[bytes.length - 1] != 10) {
                lineOutputStream.writeln();
            }
        }
        if (this.parts.size() == 0) {
            if (this.allowEmpty) {
                lineOutputStream.writeln(str);
                lineOutputStream.writeln();
            } else {
                throw new MessagingException("Empty multipart: " + this.contentType);
            }
        } else {
            for (int i = 0; i < this.parts.size(); i++) {
                lineOutputStream.writeln(str);
                ((MimeBodyPart) this.parts.elementAt(i)).writeTo(outputStream);
                lineOutputStream.writeln();
            }
        }
        lineOutputStream.writeln(str + "--");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x021b, code lost:
        r22 = r9;
        r17 = (r0.getPosition() - r6) - r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d4, code lost:
        r4 = r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:241:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x006e A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void parse() throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 871
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeMultipart.parse():void");
    }

    private static boolean allDashes(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '-') {
                return false;
            }
        }
        return true;
    }

    private static int readFully(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        while (i2 > 0) {
            int read = inputStream.read(bArr, i, i2);
            if (read <= 0) {
                break;
            }
            i += read;
            i3 += read;
            i2 -= read;
        }
        if (i3 > 0) {
            return i3;
        }
        return -1;
    }

    private void skipFully(InputStream inputStream, long j) throws IOException {
        while (j > 0) {
            long skip = inputStream.skip(j);
            if (skip <= 0) {
                throw new EOFException("can't skip");
            }
            j -= skip;
        }
    }

    protected InternetHeaders createInternetHeaders(InputStream inputStream) throws MessagingException {
        return new InternetHeaders(inputStream);
    }

    protected MimeBodyPart createMimeBodyPart(InternetHeaders internetHeaders, byte[] bArr) throws MessagingException {
        return new MimeBodyPart(internetHeaders, bArr);
    }

    protected MimeBodyPart createMimeBodyPart(InputStream inputStream) throws MessagingException {
        return new MimeBodyPart(inputStream);
    }

    private MimeBodyPart createMimeBodyPartIs(InputStream inputStream) throws MessagingException {
        try {
            return createMimeBodyPart(inputStream);
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }
}
