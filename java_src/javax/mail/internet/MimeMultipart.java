package javax.mail.internet;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.LineOutputStream;
import com.sun.mail.util.PropUtil;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

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

    protected synchronized void updateHeaders() throws MessagingException {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:268:0x032a */
    /* JADX DEBUG: Null dom frontier in handler: IOException -> 0x035a */
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
    */
    protected synchronized void parse() throws MessagingException {
        String readLine;
        boolean z;
        InternetHeaders createInternetHeaders;
        ByteArrayOutputStream byteArrayOutputStream;
        int i;
        int readFully;
        byte[] bArr;
        LineInputStream lineInputStream;
        byte[] bArr2;
        long j;
        int i2;
        ByteArrayOutputStream byteArrayOutputStream2;
        MimeBodyPart createMimeBodyPart;
        boolean z2;
        byte[] bArr3;
        byte[] bArr4;
        InternetHeaders internetHeaders;
        ByteArrayOutputStream byteArrayOutputStream3;
        boolean z3;
        int i3;
        ByteArrayOutputStream byteArrayOutputStream4;
        byte[] bArr5;
        byte b;
        String readLine2;
        String parameter;
        if (this.parsed) {
            return;
        }
        initializeProperties();
        try {
            InputStream inputStream = this.ds.getInputStream();
            InputStream bufferedInputStream = ((inputStream instanceof ByteArrayInputStream) || (inputStream instanceof BufferedInputStream) || (inputStream instanceof SharedInputStream)) ? inputStream : new BufferedInputStream(inputStream);
            SharedInputStream sharedInputStream = bufferedInputStream instanceof SharedInputStream ? (SharedInputStream) bufferedInputStream : null;
            String str = (this.ignoreExistingBoundaryParameter || (parameter = new ContentType(this.contentType).getParameter("boundary")) == null) ? null : "--" + parameter;
            if (str == null && !this.ignoreMissingBoundaryParameter && !this.ignoreExistingBoundaryParameter) {
                throw new ParseException("Missing boundary parameter");
            }
            try {
                LineInputStream lineInputStream2 = new LineInputStream(bufferedInputStream);
                StringBuilder sb = null;
                while (true) {
                    readLine = lineInputStream2.readLine();
                    z = false;
                    if (readLine == null) {
                        break;
                    }
                    int length = readLine.length() - 1;
                    while (length >= 0) {
                        char charAt = readLine.charAt(length);
                        if (charAt != ' ' && charAt != '\t') {
                            break;
                        }
                        length--;
                    }
                    readLine = readLine.substring(0, length + 1);
                    if (str != null) {
                        if (readLine.equals(str)) {
                            break;
                        }
                        if (readLine.length() == str.length() + 2 && readLine.startsWith(str) && readLine.endsWith("--")) {
                            readLine = null;
                            break;
                        }
                        if (readLine.length() > 0) {
                            if (sb == null) {
                                sb = new StringBuilder(readLine.length() + 2);
                            }
                            sb.append(readLine);
                            sb.append(System.lineSeparator());
                        }
                    } else {
                        if (readLine.length() > 2 && readLine.startsWith("--") && (readLine.length() <= 4 || !allDashes(readLine))) {
                            break;
                        }
                        if (readLine.length() > 0) {
                        }
                    }
                }
                if (sb != null) {
                    this.preamble = sb.toString();
                }
                if (readLine == null) {
                    if (!this.allowEmpty) {
                        throw new ParseException("Missing start boundary");
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    return;
                }
                byte[] bytes = ASCIIUtility.getBytes(str);
                int length2 = bytes.length;
                int[] iArr = new int[256];
                int i4 = 0;
                while (i4 < length2) {
                    i4++;
                    iArr[bytes[i4] & UByte.MAX_VALUE] = i4;
                }
                int[] iArr2 = new int[length2];
                for (int i5 = length2; i5 > 0; i5--) {
                    int i6 = length2 - 1;
                    while (true) {
                        if (i6 < i5) {
                            while (i6 > 0) {
                                i6--;
                                iArr2[i6] = i5;
                            }
                        } else if (bytes[i6] == bytes[i6 - i5]) {
                            iArr2[i6 - 1] = i5;
                            i6--;
                        }
                    }
                }
                int i7 = length2 - 1;
                iArr2[i7] = 1;
                long j2 = 0;
                boolean z4 = false;
                long j3 = 0;
                while (!z4) {
                    if (sharedInputStream != null) {
                        j2 = sharedInputStream.getPosition();
                        while (true) {
                            readLine2 = lineInputStream2.readLine();
                            if (readLine2 == null || readLine2.length() <= 0) {
                                break;
                            }
                        }
                        if (readLine2 != null) {
                            createInternetHeaders = null;
                        } else if (!this.ignoreMissingEndBoundary) {
                            throw new ParseException("missing multipart end boundary");
                        } else {
                            this.complete = z;
                        }
                    } else {
                        createInternetHeaders = createInternetHeaders(bufferedInputStream);
                    }
                    if (!bufferedInputStream.markSupported()) {
                        throw new MessagingException("Stream doesn't support mark");
                    }
                    if (sharedInputStream == null) {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } else {
                        j3 = sharedInputStream.getPosition();
                        byteArrayOutputStream = null;
                    }
                    byte[] bArr6 = new byte[length2];
                    byte[] bArr7 = new byte[length2];
                    int i8 = z;
                    boolean z5 = true;
                    while (true) {
                        bufferedInputStream.mark(length2 + 4 + 1000);
                        i = i7;
                        readFully = readFully(bufferedInputStream, bArr6, 0, length2);
                        if (readFully < length2) {
                            if (!this.ignoreMissingEndBoundary) {
                                throw new ParseException("missing multipart end boundary");
                            }
                            if (sharedInputStream != null) {
                                j3 = sharedInputStream.getPosition();
                            }
                            this.complete = false;
                            bArr = bytes;
                            lineInputStream = lineInputStream2;
                            bArr2 = bArr6;
                            j = j3;
                            z4 = true;
                            i2 = 0;
                        } else {
                            int i9 = i;
                            while (true) {
                                if (i9 < 0) {
                                    lineInputStream = lineInputStream2;
                                    z2 = z4;
                                    break;
                                }
                                lineInputStream = lineInputStream2;
                                z2 = z4;
                                if (bArr6[i9] != bytes[i9]) {
                                    break;
                                }
                                i9--;
                                lineInputStream2 = lineInputStream;
                                z4 = z2;
                            }
                            if (i9 < 0) {
                                if (z5 || !((b = bArr7[i8 - 1]) == 13 || b == 10)) {
                                    i2 = 0;
                                } else {
                                    i2 = (b == 10 && i8 >= 2 && bArr7[i8 + (-2)] == 13) ? 2 : 1;
                                }
                                if (!z5 && i2 <= 0) {
                                    bArr3 = bytes;
                                    bArr5 = bArr6;
                                    internetHeaders = createInternetHeaders;
                                    byteArrayOutputStream4 = byteArrayOutputStream;
                                    byteArrayOutputStream3 = byteArrayOutputStream4;
                                    bArr4 = bArr5;
                                    i9 = 0;
                                }
                                bArr2 = bArr6;
                                int read = bufferedInputStream.read();
                                if (read == 45 && bufferedInputStream.read() == 45) {
                                    this.complete = true;
                                    bArr = bytes;
                                    j = j3;
                                    z4 = true;
                                    break;
                                }
                                while (true) {
                                    if (read != 32 && read != 9) {
                                        break;
                                    }
                                    createInternetHeaders = createInternetHeaders;
                                    bArr2 = bArr2;
                                    read = bufferedInputStream.read();
                                    bytes = bytes;
                                    byteArrayOutputStream = byteArrayOutputStream;
                                }
                                if (read == 10) {
                                    break;
                                } else if (read == 13) {
                                    bufferedInputStream.mark(1);
                                    if (bufferedInputStream.read() != 10) {
                                        bufferedInputStream.reset();
                                    }
                                } else {
                                    bArr3 = bytes;
                                    internetHeaders = createInternetHeaders;
                                    byteArrayOutputStream4 = byteArrayOutputStream;
                                    bArr5 = bArr2;
                                    byteArrayOutputStream3 = byteArrayOutputStream4;
                                    bArr4 = bArr5;
                                    i9 = 0;
                                }
                            } else {
                                bArr3 = bytes;
                                bArr4 = bArr6;
                                internetHeaders = createInternetHeaders;
                                byteArrayOutputStream3 = byteArrayOutputStream;
                            }
                            int max = Math.max((i9 + 1) - iArr[bArr4[i9] & ByteCompanionObject.MAX_VALUE], iArr2[i9]);
                            if (max < 2) {
                                if (sharedInputStream == null && i8 > 1) {
                                    byteArrayOutputStream3.write(bArr7, 0, i8 - 1);
                                }
                                bufferedInputStream.reset();
                                int i10 = i8;
                                skipFully(bufferedInputStream, 1L);
                                if (i10 >= 1) {
                                    bArr7[0] = bArr7[i10 - 1];
                                    bArr7[1] = bArr4[0];
                                    z3 = false;
                                    i3 = 2;
                                } else {
                                    bArr7[0] = bArr4[0];
                                    z3 = false;
                                    i3 = 1;
                                }
                            } else {
                                int i11 = i8;
                                if (i11 <= 0 || sharedInputStream != null) {
                                    z3 = false;
                                } else {
                                    z3 = false;
                                    byteArrayOutputStream3.write(bArr7, 0, i11);
                                }
                                bufferedInputStream.reset();
                                skipFully(bufferedInputStream, max);
                                i3 = max;
                                byte[] bArr8 = bArr7;
                                bArr7 = bArr4;
                                bArr4 = bArr8;
                            }
                            createInternetHeaders = internetHeaders;
                            byteArrayOutputStream = byteArrayOutputStream3;
                            z5 = z3;
                            i7 = i;
                            lineInputStream2 = lineInputStream;
                            bytes = bArr3;
                            bArr6 = bArr4;
                            z4 = z2;
                            i8 = i3;
                        }
                    }
                    bArr = bytes;
                    j = j3;
                    z4 = z2;
                    if (sharedInputStream != null) {
                        createMimeBodyPart = createMimeBodyPartIs(sharedInputStream.newStream(j2, j));
                    } else {
                        int i12 = i8 - i2;
                        if (i12 > 0) {
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            byteArrayOutputStream2.write(bArr7, 0, i12);
                        } else {
                            byteArrayOutputStream2 = byteArrayOutputStream;
                        }
                        if (!this.complete && readFully > 0) {
                            byteArrayOutputStream2.write(bArr2, 0, readFully);
                        }
                        createMimeBodyPart = createMimeBodyPart(createInternetHeaders, byteArrayOutputStream2.toByteArray());
                    }
                    super.addBodyPart(createMimeBodyPart);
                    j3 = j;
                    i7 = i;
                    lineInputStream2 = lineInputStream;
                    bytes = bArr;
                    z = false;
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException unused2) {
                }
                this.parsed = true;
            } catch (IOException e) {
                throw new MessagingException("IO Error", e);
            }
        } catch (Exception e2) {
            throw new MessagingException("No inputstream from datasource", e2);
        }
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
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
