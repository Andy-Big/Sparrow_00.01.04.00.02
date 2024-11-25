package javax.mail.internet;

import com.sun.mail.util.FolderClosedIOException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.UnknownServiceException;
import javax.activation.DataSource;
import javax.mail.FolderClosedException;
import javax.mail.MessageAware;
import javax.mail.MessageContext;
import javax.mail.MessagingException;
/* loaded from: classes2.dex */
public class MimePartDataSource implements DataSource, MessageAware {
    private MessageContext context;
    protected MimePart part;

    public MimePartDataSource(MimePart mimePart) {
        this.part = mimePart;
    }

    @Override // javax.activation.DataSource
    public InputStream getInputStream() throws IOException {
        InputStream contentStream;
        try {
            if (this.part instanceof MimeBodyPart) {
                contentStream = ((MimeBodyPart) this.part).getContentStream();
            } else if (this.part instanceof MimeMessage) {
                contentStream = ((MimeMessage) this.part).getContentStream();
            } else {
                throw new MessagingException("Unknown part");
            }
            String restrictEncoding = MimeBodyPart.restrictEncoding(this.part, this.part.getEncoding());
            return restrictEncoding != null ? MimeUtility.decode(contentStream, restrictEncoding) : contentStream;
        } catch (FolderClosedException e) {
            throw new FolderClosedIOException(e.getFolder(), e.getMessage());
        } catch (MessagingException e2) {
            IOException iOException = new IOException(e2.getMessage());
            iOException.initCause(e2);
            throw iOException;
        }
    }

    @Override // javax.activation.DataSource
    public OutputStream getOutputStream() throws IOException {
        throw new UnknownServiceException("Writing not supported");
    }

    @Override // javax.activation.DataSource
    public String getContentType() {
        try {
            return this.part.getContentType();
        } catch (MessagingException unused) {
            return "application/octet-stream";
        }
    }

    @Override // javax.activation.DataSource
    public String getName() {
        try {
            return this.part instanceof MimeBodyPart ? ((MimeBodyPart) this.part).getFileName() : "";
        } catch (MessagingException unused) {
            return "";
        }
    }

    @Override // javax.mail.MessageAware
    public synchronized MessageContext getMessageContext() {
        if (this.context == null) {
            this.context = new MessageContext(this.part);
        }
        return this.context;
    }
}
