package com.sun.mail.imap;

import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.Utility;
import com.sun.mail.imap.protocol.BODY;
import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import com.sun.mail.imap.protocol.ENVELOPE;
import com.sun.mail.imap.protocol.FetchItem;
import com.sun.mail.imap.protocol.FetchResponse;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.INTERNALDATE;
import com.sun.mail.imap.protocol.Item;
import com.sun.mail.imap.protocol.MODSEQ;
import com.sun.mail.imap.protocol.RFC822DATA;
import com.sun.mail.imap.protocol.RFC822SIZE;
import com.sun.mail.imap.protocol.UID;
import com.sun.mail.util.ReadableMime;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.FolderClosedException;
import javax.mail.Header;
import javax.mail.IllegalWriteException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.UIDFolder;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
/* loaded from: classes2.dex */
public class IMAPMessage extends MimeMessage implements ReadableMime {
    static final String EnvelopeCmd = "ENVELOPE INTERNALDATE RFC822.SIZE";
    private volatile boolean bodyLoaded;
    protected BODYSTRUCTURE bs;
    private String description;
    protected ENVELOPE envelope;
    private volatile boolean headersLoaded;
    protected Map<String, Object> items;
    private Hashtable<String, String> loadedHeaders;
    private volatile long modseq;
    private Boolean peek;
    private Date receivedDate;
    protected String sectionId;
    private long size;
    private String subject;
    private String type;
    private volatile long uid;

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPMessage(IMAPFolder iMAPFolder, int i) {
        super(iMAPFolder, i);
        this.size = -1L;
        this.uid = -1L;
        this.modseq = -1L;
        this.headersLoaded = false;
        this.bodyLoaded = false;
        this.loadedHeaders = new Hashtable<>(1);
        this.flags = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPMessage(Session session) {
        super(session);
        this.size = -1L;
        this.uid = -1L;
        this.modseq = -1L;
        this.headersLoaded = false;
        this.bodyLoaded = false;
        this.loadedHeaders = new Hashtable<>(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPProtocol getProtocol() throws ProtocolException, FolderClosedException {
        ((IMAPFolder) this.folder).waitIfIdle();
        IMAPProtocol iMAPProtocol = ((IMAPFolder) this.folder).protocol;
        if (iMAPProtocol != null) {
            return iMAPProtocol;
        }
        throw new FolderClosedException(this.folder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isREV1() throws FolderClosedException {
        IMAPProtocol iMAPProtocol = ((IMAPFolder) this.folder).protocol;
        if (iMAPProtocol == null) {
            throw new FolderClosedException(this.folder);
        }
        return iMAPProtocol.isREV1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object getMessageCacheLock() {
        return ((IMAPFolder) this.folder).messageCacheLock;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSequenceNumber() {
        return ((IMAPFolder) this.folder).messageCache.seqnumOf(getMessageNumber());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.Message
    public void setMessageNumber(int i) {
        super.setMessageNumber(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getUID() {
        return this.uid;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUID(long j) {
        this.uid = j;
    }

    public synchronized long getModSeq() throws MessagingException {
        if (this.modseq != -1) {
            return this.modseq;
        }
        synchronized (getMessageCacheLock()) {
            try {
                IMAPProtocol protocol = getProtocol();
                checkExpunged();
                MODSEQ fetchMODSEQ = protocol.fetchMODSEQ(getSequenceNumber());
                if (fetchMODSEQ != null) {
                    this.modseq = fetchMODSEQ.modseq;
                }
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        return this.modseq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long _getModSeq() {
        return this.modseq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setModSeq(long j) {
        this.modseq = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.Message
    public void setExpunged(boolean z) {
        super.setExpunged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkExpunged() throws MessageRemovedException {
        if (this.expunged) {
            throw new MessageRemovedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void forceCheckExpunged() throws MessageRemovedException, FolderClosedException {
        synchronized (getMessageCacheLock()) {
            try {
                getProtocol().noop();
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException unused) {
            }
        }
        if (this.expunged) {
            throw new MessageRemovedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getFetchBlockSize() {
        return ((IMAPStore) this.folder.getStore()).getFetchBlockSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ignoreBodyStructureSize() {
        return ((IMAPStore) this.folder.getStore()).ignoreBodyStructureSize();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Address[] getFrom() throws MessagingException {
        checkExpunged();
        if (this.bodyLoaded) {
            return super.getFrom();
        }
        loadEnvelope();
        InternetAddress[] internetAddressArr = this.envelope.from;
        if (internetAddressArr == null || internetAddressArr.length == 0) {
            internetAddressArr = this.envelope.sender;
        }
        return aaclone(internetAddressArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setFrom(Address address) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void addFrom(Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage
    public Address getSender() throws MessagingException {
        checkExpunged();
        if (this.bodyLoaded) {
            return super.getSender();
        }
        loadEnvelope();
        if (this.envelope.sender == null || this.envelope.sender.length <= 0) {
            return null;
        }
        return this.envelope.sender[0];
    }

    @Override // javax.mail.internet.MimeMessage
    public void setSender(Address address) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Address[] getRecipients(Message.RecipientType recipientType) throws MessagingException {
        checkExpunged();
        if (this.bodyLoaded) {
            return super.getRecipients(recipientType);
        }
        loadEnvelope();
        if (recipientType == Message.RecipientType.TO) {
            return aaclone(this.envelope.to);
        }
        if (recipientType == Message.RecipientType.CC) {
            return aaclone(this.envelope.cc);
        }
        if (recipientType == Message.RecipientType.BCC) {
            return aaclone(this.envelope.bcc);
        }
        return super.getRecipients(recipientType);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setRecipients(Message.RecipientType recipientType, Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void addRecipients(Message.RecipientType recipientType, Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Address[] getReplyTo() throws MessagingException {
        checkExpunged();
        if (this.bodyLoaded) {
            return super.getReplyTo();
        }
        loadEnvelope();
        if (this.envelope.replyTo == null || this.envelope.replyTo.length == 0) {
            return getFrom();
        }
        return aaclone(this.envelope.replyTo);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setReplyTo(Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public String getSubject() throws MessagingException {
        checkExpunged();
        if (this.bodyLoaded) {
            return super.getSubject();
        }
        String str = this.subject;
        if (str != null) {
            return str;
        }
        loadEnvelope();
        if (this.envelope.subject == null) {
            return null;
        }
        try {
            this.subject = MimeUtility.decodeText(MimeUtility.unfold(this.envelope.subject));
        } catch (UnsupportedEncodingException unused) {
            this.subject = this.envelope.subject;
        }
        return this.subject;
    }

    @Override // javax.mail.internet.MimeMessage
    public void setSubject(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Date getSentDate() throws MessagingException {
        checkExpunged();
        if (this.bodyLoaded) {
            return super.getSentDate();
        }
        loadEnvelope();
        if (this.envelope.date == null) {
            return null;
        }
        return new Date(this.envelope.date.getTime());
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setSentDate(Date date) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Date getReceivedDate() throws MessagingException {
        checkExpunged();
        if (this.receivedDate == null) {
            loadEnvelope();
        }
        if (this.receivedDate == null) {
            return null;
        }
        return new Date(this.receivedDate.getTime());
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public int getSize() throws MessagingException {
        checkExpunged();
        if (this.size == -1) {
            loadEnvelope();
        }
        long j = this.size;
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    public long getSizeLong() throws MessagingException {
        checkExpunged();
        if (this.size == -1) {
            loadEnvelope();
        }
        return this.size;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public int getLineCount() throws MessagingException {
        checkExpunged();
        loadBODYSTRUCTURE();
        return this.bs.lines;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String[] getContentLanguage() throws MessagingException {
        checkExpunged();
        if (this.bodyLoaded) {
            return super.getContentLanguage();
        }
        loadBODYSTRUCTURE();
        if (this.bs.language != null) {
            return (String[]) this.bs.language.clone();
        }
        return null;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public void setContentLanguage(String[] strArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public String getInReplyTo() throws MessagingException {
        checkExpunged();
        if (this.bodyLoaded) {
            return super.getHeader("In-Reply-To", " ");
        }
        loadEnvelope();
        return this.envelope.inReplyTo;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public synchronized String getContentType() throws MessagingException {
        checkExpunged();
        if (this.bodyLoaded) {
            return super.getContentType();
        }
        if (this.type == null) {
            loadBODYSTRUCTURE();
            this.type = new ContentType(this.bs.type, this.bs.subtype, this.bs.cParams).toString();
        }
        return this.type;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getDisposition() throws MessagingException {
        checkExpunged();
        if (this.bodyLoaded) {
            return super.getDisposition();
        }
        loadBODYSTRUCTURE();
        return this.bs.disposition;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setDisposition(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getEncoding() throws MessagingException {
        checkExpunged();
        if (this.bodyLoaded) {
            return super.getEncoding();
        }
        loadBODYSTRUCTURE();
        return this.bs.encoding;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getContentID() throws MessagingException {
        checkExpunged();
        if (this.bodyLoaded) {
            return super.getContentID();
        }
        loadBODYSTRUCTURE();
        return this.bs.id;
    }

    @Override // javax.mail.internet.MimeMessage
    public void setContentID(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getContentMD5() throws MessagingException {
        checkExpunged();
        if (this.bodyLoaded) {
            return super.getContentMD5();
        }
        loadBODYSTRUCTURE();
        return this.bs.md5;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public void setContentMD5(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getDescription() throws MessagingException {
        checkExpunged();
        if (this.bodyLoaded) {
            return super.getDescription();
        }
        String str = this.description;
        if (str != null) {
            return str;
        }
        loadBODYSTRUCTURE();
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

    @Override // javax.mail.internet.MimeMessage
    public void setDescription(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage
    public String getMessageID() throws MessagingException {
        checkExpunged();
        if (this.bodyLoaded) {
            return super.getMessageID();
        }
        loadEnvelope();
        return this.envelope.messageId;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getFileName() throws MessagingException {
        checkExpunged();
        if (this.bodyLoaded) {
            return super.getFileName();
        }
        loadBODYSTRUCTURE();
        String str = this.bs.dParams != null ? this.bs.dParams.get("filename") : null;
        return (str != null || this.bs.cParams == null) ? str : this.bs.cParams.get(IMAPStore.ID_NAME);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setFileName(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.internet.MimeMessage
    public InputStream getContentStream() throws MessagingException {
        BODY fetchBody;
        if (this.bodyLoaded) {
            return super.getContentStream();
        }
        ByteArrayInputStream byteArrayInputStream = null;
        boolean peek = getPeek();
        synchronized (getMessageCacheLock()) {
            try {
                IMAPProtocol protocol = getProtocol();
                checkExpunged();
                if (protocol.isREV1()) {
                    int i = -1;
                    if (getFetchBlockSize() != -1) {
                        String section = toSection("TEXT");
                        if (this.bs != null && !ignoreBodyStructureSize()) {
                            i = this.bs.size;
                        }
                        return new IMAPInputStream(this, section, i, peek);
                    }
                }
                if (protocol.isREV1()) {
                    if (peek) {
                        fetchBody = protocol.peekBody(getSequenceNumber(), toSection("TEXT"));
                    } else {
                        fetchBody = protocol.fetchBody(getSequenceNumber(), toSection("TEXT"));
                    }
                    if (fetchBody != null) {
                        byteArrayInputStream = fetchBody.getByteArrayInputStream();
                    }
                } else {
                    RFC822DATA fetchRFC822 = protocol.fetchRFC822(getSequenceNumber(), "TEXT");
                    if (fetchRFC822 != null) {
                        byteArrayInputStream = fetchRFC822.getByteArrayInputStream();
                    }
                }
                if (byteArrayInputStream == null) {
                    forceCheckExpunged();
                    return new ByteArrayInputStream(new byte[0]);
                }
                return byteArrayInputStream;
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                forceCheckExpunged();
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public synchronized DataHandler getDataHandler() throws MessagingException {
        String str;
        checkExpunged();
        if (this.dh == null && !this.bodyLoaded) {
            loadBODYSTRUCTURE();
            if (this.type == null) {
                this.type = new ContentType(this.bs.type, this.bs.subtype, this.bs.cParams).toString();
            }
            if (this.bs.isMulti()) {
                this.dh = new DataHandler(new IMAPMultipartDataSource(this, this.bs.bodies, this.sectionId, this));
            } else if (this.bs.isNested() && isREV1() && this.bs.envelope != null) {
                BODYSTRUCTURE bodystructure = this.bs.bodies[0];
                ENVELOPE envelope = this.bs.envelope;
                if (this.sectionId == null) {
                    str = "1";
                } else {
                    str = this.sectionId + ".1";
                }
                this.dh = new DataHandler(new IMAPNestedMessage(this, bodystructure, envelope, str), this.type);
            }
        }
        return super.getDataHandler();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // com.sun.mail.util.ReadableMime
    public InputStream getMimeStream() throws MessagingException {
        BODY fetchBody;
        boolean peek = getPeek();
        synchronized (getMessageCacheLock()) {
            try {
                IMAPProtocol protocol = getProtocol();
                checkExpunged();
                if (protocol.isREV1() && getFetchBlockSize() != -1) {
                    return new IMAPInputStream(this, this.sectionId, -1, peek);
                }
                ByteArrayInputStream byteArrayInputStream = null;
                if (protocol.isREV1()) {
                    if (peek) {
                        fetchBody = protocol.peekBody(getSequenceNumber(), this.sectionId);
                    } else {
                        fetchBody = protocol.fetchBody(getSequenceNumber(), this.sectionId);
                    }
                    if (fetchBody != null) {
                        byteArrayInputStream = fetchBody.getByteArrayInputStream();
                    }
                } else {
                    RFC822DATA fetchRFC822 = protocol.fetchRFC822(getSequenceNumber(), null);
                    if (fetchRFC822 != null) {
                        byteArrayInputStream = fetchRFC822.getByteArrayInputStream();
                    }
                }
                if (byteArrayInputStream == null) {
                    forceCheckExpunged();
                    return new ByteArrayInputStream(new byte[0]);
                }
                return byteArrayInputStream;
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                forceCheckExpunged();
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        if (this.bodyLoaded) {
            super.writeTo(outputStream);
            return;
        }
        InputStream mimeStream = getMimeStream();
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = mimeStream.read(bArr);
                if (read == -1) {
                    return;
                }
                outputStream.write(bArr, 0, read);
            }
        } finally {
            mimeStream.close();
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String[] getHeader(String str) throws MessagingException {
        ByteArrayInputStream byteArrayInputStream;
        checkExpunged();
        if (isHeaderLoaded(str)) {
            return this.headers.getHeader(str);
        }
        synchronized (getMessageCacheLock()) {
            try {
                try {
                    IMAPProtocol protocol = getProtocol();
                    checkExpunged();
                    if (protocol.isREV1()) {
                        BODY peekBody = protocol.peekBody(getSequenceNumber(), toSection("HEADER.FIELDS (" + str + ")"));
                        if (peekBody != null) {
                            byteArrayInputStream = peekBody.getByteArrayInputStream();
                        }
                        byteArrayInputStream = null;
                    } else {
                        RFC822DATA fetchRFC822 = protocol.fetchRFC822(getSequenceNumber(), "HEADER.LINES (" + str + ")");
                        if (fetchRFC822 != null) {
                            byteArrayInputStream = fetchRFC822.getByteArrayInputStream();
                        }
                        byteArrayInputStream = null;
                    }
                } catch (ConnectionException e) {
                    throw new FolderClosedException(this.folder, e.getMessage());
                }
            } catch (ProtocolException e2) {
                forceCheckExpunged();
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        if (byteArrayInputStream == null) {
            return null;
        }
        if (this.headers == null) {
            this.headers = new InternetHeaders();
        }
        this.headers.load(byteArrayInputStream);
        setHeaderLoaded(str);
        return this.headers.getHeader(str);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getHeader(String str, String str2) throws MessagingException {
        checkExpunged();
        if (getHeader(str) == null) {
            return null;
        }
        return this.headers.getHeader(str, str2);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void addHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void removeHeader(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration<Header> getAllHeaders() throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getAllHeaders();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration<Header> getMatchingHeaders(String[] strArr) throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration<Header> getNonMatchingHeaders(String[] strArr) throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getNonMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public void addHeaderLine(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration<String> getAllHeaderLines() throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getAllHeaderLines();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration<String> getMatchingHeaderLines(String[] strArr) throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration<String> getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        checkExpunged();
        loadHeaders();
        return super.getNonMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized Flags getFlags() throws MessagingException {
        checkExpunged();
        loadFlags();
        return super.getFlags();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized boolean isSet(Flags.Flag flag) throws MessagingException {
        checkExpunged();
        loadFlags();
        return super.isSet(flag);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized void setFlags(Flags flags, boolean z) throws MessagingException {
        synchronized (getMessageCacheLock()) {
            try {
                IMAPProtocol protocol = getProtocol();
                checkExpunged();
                protocol.storeFlags(getSequenceNumber(), flags, z);
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
    }

    public synchronized void setPeek(boolean z) {
        this.peek = Boolean.valueOf(z);
    }

    public synchronized boolean getPeek() {
        if (this.peek == null) {
            return ((IMAPStore) this.folder.getStore()).getPeek();
        }
        return this.peek.booleanValue();
    }

    public synchronized void invalidateHeaders() {
        this.headersLoaded = false;
        this.loadedHeaders.clear();
        this.headers = null;
        this.envelope = null;
        this.bs = null;
        this.receivedDate = null;
        this.size = -1L;
        this.type = null;
        this.subject = null;
        this.description = null;
        this.flags = null;
        this.content = null;
        this.contentStream = null;
        this.bodyLoaded = false;
    }

    /* loaded from: classes2.dex */
    public static class FetchProfileCondition implements Utility.Condition {
        private String[] hdrs;
        private Set<FetchItem> need = new HashSet();
        private boolean needBodyStructure;
        private boolean needEnvelope;
        private boolean needFlags;
        private boolean needHeaders;
        private boolean needMessage;
        private boolean needRDate;
        private boolean needSize;
        private boolean needUID;

        public FetchProfileCondition(FetchProfile fetchProfile, FetchItem[] fetchItemArr) {
            this.needEnvelope = false;
            this.needFlags = false;
            this.needBodyStructure = false;
            this.needUID = false;
            this.needHeaders = false;
            this.needSize = false;
            this.needMessage = false;
            this.needRDate = false;
            this.hdrs = null;
            if (fetchProfile.contains(FetchProfile.Item.ENVELOPE)) {
                this.needEnvelope = true;
            }
            if (fetchProfile.contains(FetchProfile.Item.FLAGS)) {
                this.needFlags = true;
            }
            if (fetchProfile.contains(FetchProfile.Item.CONTENT_INFO)) {
                this.needBodyStructure = true;
            }
            if (fetchProfile.contains(FetchProfile.Item.SIZE)) {
                this.needSize = true;
            }
            if (fetchProfile.contains(UIDFolder.FetchProfileItem.UID)) {
                this.needUID = true;
            }
            if (fetchProfile.contains(IMAPFolder.FetchProfileItem.HEADERS)) {
                this.needHeaders = true;
            }
            if (fetchProfile.contains(IMAPFolder.FetchProfileItem.SIZE)) {
                this.needSize = true;
            }
            if (fetchProfile.contains(IMAPFolder.FetchProfileItem.MESSAGE)) {
                this.needMessage = true;
            }
            if (fetchProfile.contains(IMAPFolder.FetchProfileItem.INTERNALDATE)) {
                this.needRDate = true;
            }
            this.hdrs = fetchProfile.getHeaderNames();
            for (int i = 0; i < fetchItemArr.length; i++) {
                if (fetchProfile.contains(fetchItemArr[i].getFetchProfileItem())) {
                    this.need.add(fetchItemArr[i]);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:58:0x0090  */
        @Override // com.sun.mail.imap.Utility.Condition
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean test(com.sun.mail.imap.IMAPMessage r7) {
            /*
                r6 = this;
                boolean r0 = r6.needEnvelope
                r1 = 1
                if (r0 == 0) goto L12
                com.sun.mail.imap.protocol.ENVELOPE r0 = com.sun.mail.imap.IMAPMessage.access$000(r7)
                if (r0 != 0) goto L12
                boolean r0 = com.sun.mail.imap.IMAPMessage.access$100(r7)
                if (r0 != 0) goto L12
                return r1
            L12:
                boolean r0 = r6.needFlags
                if (r0 == 0) goto L1d
                javax.mail.Flags r0 = com.sun.mail.imap.IMAPMessage.access$200(r7)
                if (r0 != 0) goto L1d
                return r1
            L1d:
                boolean r0 = r6.needBodyStructure
                if (r0 == 0) goto L2e
                com.sun.mail.imap.protocol.BODYSTRUCTURE r0 = com.sun.mail.imap.IMAPMessage.access$300(r7)
                if (r0 != 0) goto L2e
                boolean r0 = com.sun.mail.imap.IMAPMessage.access$100(r7)
                if (r0 != 0) goto L2e
                return r1
            L2e:
                boolean r0 = r6.needUID
                r2 = -1
                if (r0 == 0) goto L3d
                long r4 = r7.getUID()
                int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r0 != 0) goto L3d
                return r1
            L3d:
                boolean r0 = r6.needHeaders
                if (r0 == 0) goto L48
                boolean r0 = com.sun.mail.imap.IMAPMessage.access$400(r7)
                if (r0 != 0) goto L48
                return r1
            L48:
                boolean r0 = r6.needSize
                if (r0 == 0) goto L5b
                long r4 = com.sun.mail.imap.IMAPMessage.access$500(r7)
                int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r0 != 0) goto L5b
                boolean r0 = com.sun.mail.imap.IMAPMessage.access$100(r7)
                if (r0 != 0) goto L5b
                return r1
            L5b:
                boolean r0 = r6.needMessage
                if (r0 == 0) goto L66
                boolean r0 = com.sun.mail.imap.IMAPMessage.access$100(r7)
                if (r0 != 0) goto L66
                return r1
            L66:
                boolean r0 = r6.needRDate
                if (r0 == 0) goto L71
                java.util.Date r0 = com.sun.mail.imap.IMAPMessage.access$600(r7)
                if (r0 != 0) goto L71
                return r1
            L71:
                r0 = 0
                r2 = r0
            L73:
                java.lang.String[] r3 = r6.hdrs
                int r4 = r3.length
                if (r2 >= r4) goto L84
                r3 = r3[r2]
                boolean r3 = com.sun.mail.imap.IMAPMessage.access$700(r7, r3)
                if (r3 != 0) goto L81
                return r1
            L81:
                int r2 = r2 + 1
                goto L73
            L84:
                java.util.Set<com.sun.mail.imap.protocol.FetchItem> r2 = r6.need
                java.util.Iterator r2 = r2.iterator()
            L8a:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto La7
                java.lang.Object r3 = r2.next()
                com.sun.mail.imap.protocol.FetchItem r3 = (com.sun.mail.imap.protocol.FetchItem) r3
                java.util.Map<java.lang.String, java.lang.Object> r4 = r7.items
                if (r4 == 0) goto La6
                java.util.Map<java.lang.String, java.lang.Object> r4 = r7.items
                java.lang.String r3 = r3.getName()
                java.lang.Object r3 = r4.get(r3)
                if (r3 != 0) goto L8a
            La6:
                return r1
            La7:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPMessage.FetchProfileCondition.test(com.sun.mail.imap.IMAPMessage):boolean");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleFetchItem(Item item, String[] strArr, boolean z) throws MessagingException {
        ByteArrayInputStream byteArrayInputStream;
        boolean isHeader;
        if (item instanceof Flags) {
            this.flags = (Flags) item;
        } else if (item instanceof ENVELOPE) {
            this.envelope = (ENVELOPE) item;
        } else if (item instanceof INTERNALDATE) {
            this.receivedDate = ((INTERNALDATE) item).getDate();
        } else if (item instanceof RFC822SIZE) {
            this.size = ((RFC822SIZE) item).size;
        } else if (item instanceof MODSEQ) {
            this.modseq = ((MODSEQ) item).modseq;
        } else if (item instanceof BODYSTRUCTURE) {
            this.bs = (BODYSTRUCTURE) item;
        } else if (item instanceof UID) {
            UID uid = (UID) item;
            this.uid = uid.uid;
            if (((IMAPFolder) this.folder).uidTable == null) {
                ((IMAPFolder) this.folder).uidTable = new Hashtable<>();
            }
            ((IMAPFolder) this.folder).uidTable.put(Long.valueOf(uid.uid), this);
        } else {
            boolean z2 = item instanceof RFC822DATA;
            if (!z2 && !(item instanceof BODY)) {
                return false;
            }
            if (z2) {
                RFC822DATA rfc822data = (RFC822DATA) item;
                byteArrayInputStream = rfc822data.getByteArrayInputStream();
                isHeader = rfc822data.isHeader();
            } else {
                BODY body = (BODY) item;
                byteArrayInputStream = body.getByteArrayInputStream();
                isHeader = body.isHeader();
            }
            if (!isHeader) {
                try {
                    this.size = byteArrayInputStream.available();
                } catch (IOException unused) {
                }
                parse(byteArrayInputStream);
                this.bodyLoaded = true;
                setHeadersLoaded(true);
            } else {
                InternetHeaders internetHeaders = new InternetHeaders();
                if (byteArrayInputStream != null) {
                    internetHeaders.load(byteArrayInputStream);
                }
                if (this.headers == null || z) {
                    this.headers = internetHeaders;
                } else {
                    Enumeration<Header> allHeaders = internetHeaders.getAllHeaders();
                    while (allHeaders.hasMoreElements()) {
                        Header nextElement = allHeaders.nextElement();
                        if (!isHeaderLoaded(nextElement.getName())) {
                            this.headers.addHeader(nextElement.getName(), nextElement.getValue());
                        }
                    }
                }
                if (z) {
                    setHeadersLoaded(true);
                } else {
                    for (String str : strArr) {
                        setHeaderLoaded(str);
                    }
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleExtensionFetchItems(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        if (this.items == null) {
            this.items = new HashMap();
        }
        this.items.putAll(map);
    }

    protected Object fetchItem(FetchItem fetchItem) throws MessagingException {
        Object obj;
        Object obj2;
        synchronized (getMessageCacheLock()) {
            try {
                try {
                    IMAPProtocol protocol = getProtocol();
                    checkExpunged();
                    int sequenceNumber = getSequenceNumber();
                    Response[] fetch = protocol.fetch(sequenceNumber, fetchItem.getName());
                    obj = null;
                    for (int i = 0; i < fetch.length; i++) {
                        if (fetch[i] != null && (fetch[i] instanceof FetchResponse) && ((FetchResponse) fetch[i]).getNumber() == sequenceNumber) {
                            handleExtensionFetchItems(((FetchResponse) fetch[i]).getExtensionItems());
                            if (this.items != null && (obj2 = this.items.get(fetchItem.getName())) != null) {
                                obj = obj2;
                            }
                        }
                    }
                    protocol.notifyResponseHandlers(fetch);
                    protocol.handleResult(fetch[fetch.length - 1]);
                } catch (ConnectionException e) {
                    throw new FolderClosedException(this.folder, e.getMessage());
                } catch (ProtocolException e2) {
                    forceCheckExpunged();
                    throw new MessagingException(e2.getMessage(), e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public synchronized Object getItem(FetchItem fetchItem) throws MessagingException {
        Object obj;
        obj = this.items == null ? null : this.items.get(fetchItem.getName());
        if (obj == null) {
            obj = fetchItem(fetchItem);
        }
        return obj;
    }

    private synchronized void loadEnvelope() throws MessagingException {
        if (this.envelope != null) {
            return;
        }
        synchronized (getMessageCacheLock()) {
            try {
                IMAPProtocol protocol = getProtocol();
                checkExpunged();
                int sequenceNumber = getSequenceNumber();
                Response[] fetch = protocol.fetch(sequenceNumber, EnvelopeCmd);
                for (int i = 0; i < fetch.length; i++) {
                    if (fetch[i] != null && (fetch[i] instanceof FetchResponse) && ((FetchResponse) fetch[i]).getNumber() == sequenceNumber) {
                        FetchResponse fetchResponse = (FetchResponse) fetch[i];
                        int itemCount = fetchResponse.getItemCount();
                        for (int i2 = 0; i2 < itemCount; i2++) {
                            Item item = fetchResponse.getItem(i2);
                            if (item instanceof ENVELOPE) {
                                this.envelope = (ENVELOPE) item;
                            } else if (item instanceof INTERNALDATE) {
                                this.receivedDate = ((INTERNALDATE) item).getDate();
                            } else if (item instanceof RFC822SIZE) {
                                this.size = ((RFC822SIZE) item).size;
                            }
                        }
                    }
                }
                protocol.notifyResponseHandlers(fetch);
                protocol.handleResult(fetch[fetch.length - 1]);
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                forceCheckExpunged();
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        if (this.envelope == null) {
            throw new MessagingException("Failed to load IMAP envelope");
        }
    }

    private synchronized void loadBODYSTRUCTURE() throws MessagingException {
        if (this.bs != null) {
            return;
        }
        synchronized (getMessageCacheLock()) {
            try {
                IMAPProtocol protocol = getProtocol();
                checkExpunged();
                BODYSTRUCTURE fetchBodyStructure = protocol.fetchBodyStructure(getSequenceNumber());
                this.bs = fetchBodyStructure;
                if (fetchBodyStructure == null) {
                    forceCheckExpunged();
                    throw new MessagingException("Unable to load BODYSTRUCTURE");
                }
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                forceCheckExpunged();
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
    }

    private synchronized void loadHeaders() throws MessagingException {
        if (this.headersLoaded) {
            return;
        }
        ByteArrayInputStream byteArrayInputStream = null;
        synchronized (getMessageCacheLock()) {
            try {
                IMAPProtocol protocol = getProtocol();
                checkExpunged();
                if (protocol.isREV1()) {
                    BODY peekBody = protocol.peekBody(getSequenceNumber(), toSection("HEADER"));
                    if (peekBody != null) {
                        byteArrayInputStream = peekBody.getByteArrayInputStream();
                    }
                } else {
                    RFC822DATA fetchRFC822 = protocol.fetchRFC822(getSequenceNumber(), "HEADER");
                    if (fetchRFC822 != null) {
                        byteArrayInputStream = fetchRFC822.getByteArrayInputStream();
                    }
                }
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                forceCheckExpunged();
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        if (byteArrayInputStream == null) {
            throw new MessagingException("Cannot load header");
        }
        this.headers = new InternetHeaders(byteArrayInputStream);
        this.headersLoaded = true;
    }

    private synchronized void loadFlags() throws MessagingException {
        if (this.flags != null) {
            return;
        }
        synchronized (getMessageCacheLock()) {
            try {
                IMAPProtocol protocol = getProtocol();
                checkExpunged();
                this.flags = protocol.fetchFlags(getSequenceNumber());
                if (this.flags == null) {
                    this.flags = new Flags();
                }
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                forceCheckExpunged();
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean areHeadersLoaded() {
        return this.headersLoaded;
    }

    private void setHeadersLoaded(boolean z) {
        this.headersLoaded = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHeaderLoaded(String str) {
        if (this.headersLoaded) {
            return true;
        }
        return this.loadedHeaders.containsKey(str.toUpperCase(Locale.ENGLISH));
    }

    private void setHeaderLoaded(String str) {
        this.loadedHeaders.put(str.toUpperCase(Locale.ENGLISH), str);
    }

    private String toSection(String str) {
        if (this.sectionId == null) {
            return str;
        }
        return this.sectionId + "." + str;
    }

    private InternetAddress[] aaclone(InternetAddress[] internetAddressArr) {
        if (internetAddressArr == null) {
            return null;
        }
        return (InternetAddress[]) internetAddressArr.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Flags _getFlags() {
        return this.flags;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ENVELOPE _getEnvelope() {
        return this.envelope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BODYSTRUCTURE _getBodyStructure() {
        return this.bs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void _setFlags(Flags flags) {
        this.flags = flags;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Session _getSession() {
        return this.session;
    }
}
