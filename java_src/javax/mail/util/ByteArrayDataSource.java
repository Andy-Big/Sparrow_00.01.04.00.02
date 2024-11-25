package javax.mail.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.DataSource;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.ParseException;
/* loaded from: classes2.dex */
public class ByteArrayDataSource implements DataSource {
    private byte[] data;
    private int len;
    private String name;
    private String type;

    /* loaded from: classes2.dex */
    static class DSByteArrayOutputStream extends ByteArrayOutputStream {
        DSByteArrayOutputStream() {
        }

        public byte[] getBuf() {
            return this.buf;
        }

        public int getCount() {
            return this.count;
        }
    }

    public ByteArrayDataSource(InputStream inputStream, String str) throws IOException {
        this.len = -1;
        this.name = "";
        DSByteArrayOutputStream dSByteArrayOutputStream = new DSByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                break;
            }
            dSByteArrayOutputStream.write(bArr, 0, read);
        }
        this.data = dSByteArrayOutputStream.getBuf();
        int count = dSByteArrayOutputStream.getCount();
        this.len = count;
        if (this.data.length - count > 262144) {
            byte[] byteArray = dSByteArrayOutputStream.toByteArray();
            this.data = byteArray;
            this.len = byteArray.length;
        }
        this.type = str;
    }

    public ByteArrayDataSource(byte[] bArr, String str) {
        this.len = -1;
        this.name = "";
        this.data = bArr;
        this.type = str;
    }

    public ByteArrayDataSource(String str, String str2) throws IOException {
        String str3;
        this.len = -1;
        this.name = "";
        try {
            str3 = new ContentType(str2).getParameter("charset");
        } catch (ParseException unused) {
            str3 = null;
        }
        String javaCharset = MimeUtility.javaCharset(str3);
        this.data = str.getBytes(javaCharset == null ? MimeUtility.getDefaultJavaCharset() : javaCharset);
        this.type = str2;
    }

    @Override // javax.activation.DataSource
    public InputStream getInputStream() throws IOException {
        byte[] bArr = this.data;
        if (bArr == null) {
            throw new IOException("no data");
        }
        if (this.len < 0) {
            this.len = bArr.length;
        }
        return new SharedByteArrayInputStream(this.data, 0, this.len);
    }

    @Override // javax.activation.DataSource
    public OutputStream getOutputStream() throws IOException {
        throw new IOException("cannot do this");
    }

    @Override // javax.activation.DataSource
    public String getContentType() {
        return this.type;
    }

    @Override // javax.activation.DataSource
    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
