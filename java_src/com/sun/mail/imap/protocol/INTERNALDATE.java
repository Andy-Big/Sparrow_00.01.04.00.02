package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.mail.internet.MailDateFormat;
/* loaded from: classes2.dex */
public class INTERNALDATE implements Item {
    protected Date date;
    public int msgno;
    static final char[] name = {'I', 'N', 'T', 'E', 'R', 'N', 'A', 'L', 'D', 'A', 'T', 'E'};
    private static final MailDateFormat mailDateFormat = new MailDateFormat();
    private static SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss ", Locale.US);

    public INTERNALDATE(FetchResponse fetchResponse) throws ParsingException {
        this.msgno = fetchResponse.getNumber();
        fetchResponse.skipSpaces();
        String readString = fetchResponse.readString();
        if (readString == null) {
            throw new ParsingException("INTERNALDATE is NIL");
        }
        try {
            synchronized (mailDateFormat) {
                this.date = mailDateFormat.parse(readString);
            }
        } catch (ParseException unused) {
            throw new ParsingException("INTERNALDATE parse error");
        }
    }

    public Date getDate() {
        return this.date;
    }

    public static String format(Date date) {
        StringBuffer stringBuffer = new StringBuffer();
        synchronized (df) {
            df.format(date, stringBuffer, new FieldPosition(0));
        }
        int offset = (TimeZone.getDefault().getOffset(date.getTime()) / 60) / 1000;
        if (offset < 0) {
            stringBuffer.append('-');
            offset = -offset;
        } else {
            stringBuffer.append('+');
        }
        int i = offset / 60;
        int i2 = offset % 60;
        stringBuffer.append(Character.forDigit(i / 10, 10));
        stringBuffer.append(Character.forDigit(i % 10, 10));
        stringBuffer.append(Character.forDigit(i2 / 10, 10));
        stringBuffer.append(Character.forDigit(i2 % 10, 10));
        return stringBuffer.toString();
    }
}
