package com.sun.mail.handlers;

import java.io.IOException;
import java.io.OutputStream;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeMultipart;
/* loaded from: classes2.dex */
public class multipart_mixed extends handler_base {
    private static ActivationDataFlavor[] myDF = {new ActivationDataFlavor(Multipart.class, "multipart/mixed", "Multipart")};

    @Override // com.sun.mail.handlers.handler_base
    protected ActivationDataFlavor[] getDataFlavors() {
        return myDF;
    }

    @Override // javax.activation.DataContentHandler
    public Object getContent(DataSource dataSource) throws IOException {
        try {
            return new MimeMultipart(dataSource);
        } catch (MessagingException e) {
            IOException iOException = new IOException("Exception while constructing MimeMultipart");
            iOException.initCause(e);
            throw iOException;
        }
    }

    @Override // javax.activation.DataContentHandler
    public void writeTo(Object obj, String str, OutputStream outputStream) throws IOException {
        if (!(obj instanceof Multipart)) {
            throw new IOException("\"" + getDataFlavors()[0].getMimeType() + "\" DataContentHandler requires Multipart object, was given object of type " + obj.getClass().toString() + "; obj.cl " + obj.getClass().getClassLoader() + ", Multipart.cl " + Multipart.class.getClassLoader());
        }
        try {
            ((Multipart) obj).writeTo(outputStream);
        } catch (MessagingException e) {
            IOException iOException = new IOException("Exception writing Multipart");
            iOException.initCause(e);
            throw iOException;
        }
    }
}
