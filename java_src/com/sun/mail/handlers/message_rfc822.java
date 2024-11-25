package com.sun.mail.handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessageAware;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
/* loaded from: classes2.dex */
public class message_rfc822 extends handler_base {
    private static ActivationDataFlavor[] ourDataFlavor = {new ActivationDataFlavor(Message.class, "message/rfc822", "Message")};

    @Override // com.sun.mail.handlers.handler_base
    protected ActivationDataFlavor[] getDataFlavors() {
        return ourDataFlavor;
    }

    @Override // javax.activation.DataContentHandler
    public Object getContent(DataSource dataSource) throws IOException {
        Session defaultInstance;
        try {
            if (dataSource instanceof MessageAware) {
                defaultInstance = ((MessageAware) dataSource).getMessageContext().getSession();
            } else {
                defaultInstance = Session.getDefaultInstance(new Properties(), null);
            }
            return new MimeMessage(defaultInstance, dataSource.getInputStream());
        } catch (MessagingException e) {
            IOException iOException = new IOException("Exception creating MimeMessage in message/rfc822 DataContentHandler");
            iOException.initCause(e);
            throw iOException;
        }
    }

    @Override // javax.activation.DataContentHandler
    public void writeTo(Object obj, String str, OutputStream outputStream) throws IOException {
        if (!(obj instanceof Message)) {
            throw new IOException("\"" + getDataFlavors()[0].getMimeType() + "\" DataContentHandler requires Message object, was given object of type " + obj.getClass().toString() + "; obj.cl " + obj.getClass().getClassLoader() + ", Message.cl " + Message.class.getClassLoader());
        }
        try {
            ((Message) obj).writeTo(outputStream);
        } catch (MessagingException e) {
            IOException iOException = new IOException("Exception writing message");
            iOException.initCause(e);
            throw iOException;
        }
    }
}
