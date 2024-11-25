package javax.mail;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.activation.DataHandler;
/* loaded from: classes2.dex */
public interface Part {
    public static final String ATTACHMENT = "attachment";
    public static final String INLINE = "inline";

    void addHeader(String str, String str2) throws MessagingException;

    Enumeration<Header> getAllHeaders() throws MessagingException;

    Object getContent() throws IOException, MessagingException;

    String getContentType() throws MessagingException;

    DataHandler getDataHandler() throws MessagingException;

    String getDescription() throws MessagingException;

    String getDisposition() throws MessagingException;

    String getFileName() throws MessagingException;

    String[] getHeader(String str) throws MessagingException;

    InputStream getInputStream() throws IOException, MessagingException;

    int getLineCount() throws MessagingException;

    Enumeration<Header> getMatchingHeaders(String[] strArr) throws MessagingException;

    Enumeration<Header> getNonMatchingHeaders(String[] strArr) throws MessagingException;

    int getSize() throws MessagingException;

    boolean isMimeType(String str) throws MessagingException;

    void removeHeader(String str) throws MessagingException;

    void setContent(Object obj, String str) throws MessagingException;

    void setContent(Multipart multipart) throws MessagingException;

    void setDataHandler(DataHandler dataHandler) throws MessagingException;

    void setDescription(String str) throws MessagingException;

    void setDisposition(String str) throws MessagingException;

    void setFileName(String str) throws MessagingException;

    void setHeader(String str, String str2) throws MessagingException;

    void setText(String str) throws MessagingException;

    void writeTo(OutputStream outputStream) throws IOException, MessagingException;
}
