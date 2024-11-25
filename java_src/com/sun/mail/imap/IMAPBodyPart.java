package com.sun.mail.imap;

import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.protocol.BODY;
import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.util.LineOutputStream;
import com.sun.mail.util.PropUtil;
import com.sun.mail.util.ReadableMime;
import com.sun.mail.util.SharedByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import javax.activation.DataHandler;
import javax.mail.FolderClosedException;
import javax.mail.Header;
import javax.mail.IllegalWriteException;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeUtility;
/* loaded from: classes2.dex */
public class IMAPBodyPart extends MimeBodyPart implements ReadableMime {
    private static final boolean decodeFileName = PropUtil.getBooleanSystemProperty("mail.mime.decodefilename", false);
    private BODYSTRUCTURE bs;
    private String description;
    private boolean headersLoaded = false;
    private IMAPMessage message;
    private String sectionId;
    private String type;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.internet.MimeBodyPart
    public void updateHeaders() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPBodyPart(BODYSTRUCTURE bodystructure, String str, IMAPMessage iMAPMessage) {
        this.bs = bodystructure;
        this.sectionId = str;
        this.message = iMAPMessage;
        this.type = new ContentType(bodystructure.type, bodystructure.subtype, bodystructure.cParams).toString();
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public int getSize() throws MessagingException {
        return this.bs.size;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public int getLineCount() throws MessagingException {
        return this.bs.lines;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getContentType() throws MessagingException {
        return this.type;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getDisposition() throws MessagingException {
        return this.bs.disposition;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setDisposition(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public String getEncoding() throws MessagingException {
        return this.bs.encoding;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public String getContentID() throws MessagingException {
        return this.bs.id;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public String getContentMD5() throws MessagingException {
        return this.bs.md5;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public void setContentMD5(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getDescription() throws MessagingException {
        String str = this.description;
        if (str != null) {
            return str;
        }
        if (this.bs.description == null) {
            return null;
        }
        try {
            this.description = MimeUtility.decodeText(this.bs.description);
        } catch (UnsupportedEncodingException unused) {
            this.description = this.bs.description;
        }
        return this.description;
    }

    @Override // javax.mail.internet.MimeBodyPart
    public void setDescription(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getFileName() throws MessagingException {
        String str = this.bs.dParams != null ? this.bs.dParams.get("filename") : null;
        if ((str == null || str.isEmpty()) && this.bs.cParams != null) {
            str = this.bs.cParams.get(IMAPStore.ID_NAME);
        }
        if (!decodeFileName || str == null) {
            return str;
        }
        try {
            return MimeUtility.decodeText(str);
        } catch (UnsupportedEncodingException e) {
            throw new MessagingException("Can't decode filename", e);
        }
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setFileName(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.internet.MimeBodyPart
    public InputStream getContentStream() throws MessagingException {
        BODY fetchBody;
        boolean peek = this.message.getPeek();
        synchronized (this.message.getMessageCacheLock()) {
            try {
                IMAPProtocol protocol = this.message.getProtocol();
                this.message.checkExpunged();
                if (protocol.isREV1()) {
                    int i = -1;
                    if (this.message.getFetchBlockSize() != -1) {
                        IMAPMessage iMAPMessage = this.message;
                        String str = this.sectionId;
                        if (!this.message.ignoreBodyStructureSize()) {
                            i = this.bs.size;
                        }
                        return new IMAPInputStream(iMAPMessage, str, i, peek);
                    }
                }
                int sequenceNumber = this.message.getSequenceNumber();
                if (peek) {
                    fetchBody = protocol.peekBody(sequenceNumber, this.sectionId);
                } else {
                    fetchBody = protocol.fetchBody(sequenceNumber, this.sectionId);
                }
                ByteArrayInputStream byteArrayInputStream = fetchBody != null ? fetchBody.getByteArrayInputStream() : null;
                if (byteArrayInputStream == null) {
                    this.message.forceCheckExpunged();
                    return new ByteArrayInputStream(new byte[0]);
                }
                return byteArrayInputStream;
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.message.getFolder(), e.getMessage());
            } catch (ProtocolException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
    }

    private InputStream getHeaderStream() throws MessagingException {
        ByteArrayInputStream byteArrayInputStream;
        if (!this.message.isREV1()) {
            loadHeaders();
        }
        synchronized (this.message.getMessageCacheLock()) {
            try {
                try {
                    IMAPProtocol protocol = this.message.getProtocol();
                    this.message.checkExpunged();
                    if (protocol.isREV1()) {
                        int sequenceNumber = this.message.getSequenceNumber();
                        BODY peekBody = protocol.peekBody(sequenceNumber, this.sectionId + ".MIME");
                        if (peekBody == null) {
                            throw new MessagingException("Failed to fetch headers");
                        }
                        byteArrayInputStream = peekBody.getByteArrayInputStream();
                        if (byteArrayInputStream == null) {
                            throw new MessagingException("Failed to fetch headers");
                        }
                    } else {
                        SharedByteArrayOutputStream sharedByteArrayOutputStream = new SharedByteArrayOutputStream(0);
                        LineOutputStream lineOutputStream = new LineOutputStream(sharedByteArrayOutputStream);
                        try {
                            Enumeration<String> allHeaderLines = super.getAllHeaderLines();
                            while (allHeaderLines.hasMoreElements()) {
                                lineOutputStream.writeln(allHeaderLines.nextElement());
                            }
                            lineOutputStream.writeln();
                        } catch (IOException unused) {
                        } catch (Throwable th) {
                            try {
                                lineOutputStream.close();
                            } catch (IOException unused2) {
                            }
                            throw th;
                        }
                        try {
                            lineOutputStream.close();
                        } catch (IOException unused3) {
                            return sharedByteArrayOutputStream.toStream();
                        }
                    }
                } finally {
                }
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.message.getFolder(), e.getMessage());
            } catch (ProtocolException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        return byteArrayInputStream;
    }

    @Override // com.sun.mail.util.ReadableMime
    public InputStream getMimeStream() throws MessagingException {
        return new SequenceInputStream(getHeaderStream(), getContentStream());
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public synchronized DataHandler getDataHandler() throws MessagingException {
        if (this.dh == null) {
            if (this.bs.isMulti()) {
                this.dh = new DataHandler(new IMAPMultipartDataSource(this, this.bs.bodies, this.sectionId, this.message));
            } else if (this.bs.isNested() && this.message.isREV1() && this.bs.envelope != null) {
                this.dh = new DataHandler(new IMAPNestedMessage(this.message, this.bs.bodies[0], this.bs.envelope, this.sectionId), this.type);
            }
        }
        return super.getDataHandler();
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setContent(Object obj, String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setContent(Multipart multipart) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String[] getHeader(String str) throws MessagingException {
        loadHeaders();
        return super.getHeader(str);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void addHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void removeHeader(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public Enumeration<Header> getAllHeaders() throws MessagingException {
        loadHeaders();
        return super.getAllHeaders();
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public Enumeration<Header> getMatchingHeaders(String[] strArr) throws MessagingException {
        loadHeaders();
        return super.getMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public Enumeration<Header> getNonMatchingHeaders(String[] strArr) throws MessagingException {
        loadHeaders();
        return super.getNonMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public void addHeaderLine(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public Enumeration<String> getAllHeaderLines() throws MessagingException {
        loadHeaders();
        return super.getAllHeaderLines();
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public Enumeration<String> getMatchingHeaderLines(String[] strArr) throws MessagingException {
        loadHeaders();
        return super.getMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public Enumeration<String> getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        loadHeaders();
        return super.getNonMatchingHeaderLines(strArr);
    }

    private synchronized void loadHeaders() throws MessagingException {
        if (this.headersLoaded) {
            return;
        }
        if (this.headers == null) {
            this.headers = new InternetHeaders();
        }
        synchronized (this.message.getMessageCacheLock()) {
            try {
                try {
                    IMAPProtocol protocol = this.message.getProtocol();
                    this.message.checkExpunged();
                    if (protocol.isREV1()) {
                        int sequenceNumber = this.message.getSequenceNumber();
                        BODY peekBody = protocol.peekBody(sequenceNumber, this.sectionId + ".MIME");
                        if (peekBody == null) {
                            throw new MessagingException("Failed to fetch headers");
                        }
                        ByteArrayInputStream byteArrayInputStream = peekBody.getByteArrayInputStream();
                        if (byteArrayInputStream == null) {
                            throw new MessagingException("Failed to fetch headers");
                        }
                        this.headers.load(byteArrayInputStream);
                    } else {
                        this.headers.addHeader("Content-Type", this.type);
                        this.headers.addHeader("Content-Transfer-Encoding", this.bs.encoding);
                        if (this.bs.description != null) {
                            this.headers.addHeader("Content-Description", this.bs.description);
                        }
                        if (this.bs.id != null) {
                            this.headers.addHeader("Content-ID", this.bs.id);
                        }
                        if (this.bs.md5 != null) {
                            this.headers.addHeader("Content-MD5", this.bs.md5);
                        }
                    }
                } catch (ConnectionException e) {
                    throw new FolderClosedException(this.message.getFolder(), e.getMessage());
                }
            } catch (ProtocolException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        this.headersLoaded = true;
    }
}
