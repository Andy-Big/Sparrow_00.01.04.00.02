package javax.mail.internet;

import com.sun.mail.util.LineOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.mail.MessagingException;

/* loaded from: classes2.dex */
public class PreencodedMimeBodyPart extends MimeBodyPart {
    private String encoding;

    public PreencodedMimeBodyPart(String str) {
        this.encoding = str;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public String getEncoding() throws MessagingException {
        return this.encoding;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        LineOutputStream lineOutputStream;
        if (outputStream instanceof LineOutputStream) {
            lineOutputStream = (LineOutputStream) outputStream;
        } else {
            lineOutputStream = new LineOutputStream(outputStream);
        }
        Enumeration<String> allHeaderLines = getAllHeaderLines();
        while (allHeaderLines.hasMoreElements()) {
            lineOutputStream.writeln(allHeaderLines.nextElement());
        }
        lineOutputStream.writeln();
        getDataHandler().writeTo(outputStream);
        outputStream.flush();
    }

    @Override // javax.mail.internet.MimeBodyPart
    protected void updateHeaders() throws MessagingException {
        super.updateHeaders();
        MimeBodyPart.setEncoding(this, this.encoding);
    }
}
