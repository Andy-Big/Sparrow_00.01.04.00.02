package com.sun.mail.imap;

import com.sun.mail.iap.Literal;
import com.sun.mail.util.CRLFOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.mail.Message;
import javax.mail.MessagingException;
/* compiled from: IMAPFolder.java */
/* loaded from: classes2.dex */
class MessageLiteral implements Literal {
    private byte[] buf;
    private Message msg;
    private int msgSize;

    public MessageLiteral(Message message, int i) throws MessagingException, IOException {
        this.msgSize = -1;
        this.msg = message;
        LengthCounter lengthCounter = new LengthCounter(i);
        CRLFOutputStream cRLFOutputStream = new CRLFOutputStream(lengthCounter);
        message.writeTo(cRLFOutputStream);
        cRLFOutputStream.flush();
        this.msgSize = lengthCounter.getSize();
        this.buf = lengthCounter.getBytes();
    }

    @Override // com.sun.mail.iap.Literal
    public int size() {
        return this.msgSize;
    }

    @Override // com.sun.mail.iap.Literal
    public void writeTo(OutputStream outputStream) throws IOException {
        try {
            if (this.buf != null) {
                outputStream.write(this.buf, 0, this.msgSize);
                return;
            }
            this.msg.writeTo(new CRLFOutputStream(outputStream));
        } catch (MessagingException e) {
            throw new IOException("MessagingException while appending message: " + e);
        }
    }
}
