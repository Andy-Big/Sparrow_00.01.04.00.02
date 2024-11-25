package com.sun.mail.imap;

import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import com.sun.mail.imap.protocol.ENVELOPE;
import com.sun.mail.imap.protocol.IMAPProtocol;
import javax.mail.Flags;
import javax.mail.FolderClosedException;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;
/* loaded from: classes2.dex */
public class IMAPNestedMessage extends IMAPMessage {
    private IMAPMessage msg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMAPNestedMessage(IMAPMessage iMAPMessage, BODYSTRUCTURE bodystructure, ENVELOPE envelope, String str) {
        super(iMAPMessage._getSession());
        this.msg = iMAPMessage;
        this.bs = bodystructure;
        this.envelope = envelope;
        this.sectionId = str;
        setPeek(iMAPMessage.getPeek());
    }

    @Override // com.sun.mail.imap.IMAPMessage
    protected IMAPProtocol getProtocol() throws ProtocolException, FolderClosedException {
        return this.msg.getProtocol();
    }

    @Override // com.sun.mail.imap.IMAPMessage
    protected boolean isREV1() throws FolderClosedException {
        return this.msg.isREV1();
    }

    @Override // com.sun.mail.imap.IMAPMessage
    protected Object getMessageCacheLock() {
        return this.msg.getMessageCacheLock();
    }

    @Override // com.sun.mail.imap.IMAPMessage
    protected int getSequenceNumber() {
        return this.msg.getSequenceNumber();
    }

    @Override // com.sun.mail.imap.IMAPMessage
    protected void checkExpunged() throws MessageRemovedException {
        this.msg.checkExpunged();
    }

    @Override // javax.mail.Message
    public boolean isExpunged() {
        return this.msg.isExpunged();
    }

    @Override // com.sun.mail.imap.IMAPMessage
    protected int getFetchBlockSize() {
        return this.msg.getFetchBlockSize();
    }

    @Override // com.sun.mail.imap.IMAPMessage
    protected boolean ignoreBodyStructureSize() {
        return this.msg.ignoreBodyStructureSize();
    }

    @Override // com.sun.mail.imap.IMAPMessage, javax.mail.internet.MimeMessage, javax.mail.Part
    public int getSize() throws MessagingException {
        return this.bs.size;
    }

    @Override // com.sun.mail.imap.IMAPMessage, javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized void setFlags(Flags flags, boolean z) throws MessagingException {
        throw new MethodNotSupportedException("Cannot set flags on this nested message");
    }
}
