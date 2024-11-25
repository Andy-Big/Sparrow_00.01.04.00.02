package com.sun.mail.handlers;

import java.io.IOException;
import java.io.OutputStream;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataSource;
import javax.mail.internet.ContentType;
import javax.mail.internet.ParseException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
/* loaded from: classes2.dex */
public class text_xml extends text_plain {
    private static final ActivationDataFlavor[] flavors = {new ActivationDataFlavor(String.class, "text/xml", "XML String"), new ActivationDataFlavor(String.class, "application/xml", "XML String"), new ActivationDataFlavor(StreamSource.class, "text/xml", "XML"), new ActivationDataFlavor(StreamSource.class, "application/xml", "XML")};

    @Override // com.sun.mail.handlers.text_plain, com.sun.mail.handlers.handler_base
    protected ActivationDataFlavor[] getDataFlavors() {
        return flavors;
    }

    @Override // com.sun.mail.handlers.handler_base
    protected Object getData(ActivationDataFlavor activationDataFlavor, DataSource dataSource) throws IOException {
        if (activationDataFlavor.getRepresentationClass() == String.class) {
            return super.getContent(dataSource);
        }
        if (activationDataFlavor.getRepresentationClass() == StreamSource.class) {
            return new StreamSource(dataSource.getInputStream());
        }
        return null;
    }

    @Override // com.sun.mail.handlers.text_plain, javax.activation.DataContentHandler
    public void writeTo(Object obj, String str, OutputStream outputStream) throws IOException {
        if (!isXmlType(str)) {
            throw new IOException("Invalid content type \"" + str + "\" for text/xml DCH");
        } else if (obj instanceof String) {
            super.writeTo(obj, str, outputStream);
        } else if (!(obj instanceof DataSource) && !(obj instanceof Source)) {
            throw new IOException("Invalid Object type = " + obj.getClass() + ". XmlDCH can only convert DataSource or Source to XML.");
        } else {
            try {
                Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
                StreamResult streamResult = new StreamResult(outputStream);
                if (obj instanceof DataSource) {
                    newTransformer.transform(new StreamSource(((DataSource) obj).getInputStream()), streamResult);
                } else {
                    newTransformer.transform((Source) obj, streamResult);
                }
            } catch (RuntimeException e) {
                IOException iOException = new IOException("Unable to run the JAXP transformer on a stream " + e.getMessage());
                iOException.initCause(e);
                throw iOException;
            } catch (TransformerException e2) {
                IOException iOException2 = new IOException("Unable to run the JAXP transformer on a stream " + e2.getMessage());
                iOException2.initCause(e2);
                throw iOException2;
            }
        }
    }

    private boolean isXmlType(String str) {
        try {
            ContentType contentType = new ContentType(str);
            if (contentType.getSubType().equals("xml")) {
                if (!contentType.getPrimaryType().equals("text")) {
                    if (!contentType.getPrimaryType().equals("application")) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (RuntimeException | ParseException unused) {
            return false;
        }
    }
}
