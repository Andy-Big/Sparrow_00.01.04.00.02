package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Response;
import com.sun.mail.util.PropUtil;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MailDateFormat;
/* loaded from: classes2.dex */
public class ENVELOPE implements Item {
    public InternetAddress[] bcc;
    public InternetAddress[] cc;
    public Date date;
    public InternetAddress[] from;
    public String inReplyTo;
    public String messageId;
    public int msgno;
    public InternetAddress[] replyTo;
    public InternetAddress[] sender;
    public String subject;
    public InternetAddress[] to;
    static final char[] name = {'E', 'N', 'V', 'E', 'L', 'O', 'P', 'E'};
    private static final MailDateFormat mailDateFormat = new MailDateFormat();
    private static final boolean parseDebug = PropUtil.getBooleanSystemProperty("mail.imap.parse.debug", false);

    public ENVELOPE(FetchResponse fetchResponse) throws ParsingException {
        this.date = null;
        if (parseDebug) {
            System.out.println("parse ENVELOPE");
        }
        this.msgno = fetchResponse.getNumber();
        fetchResponse.skipSpaces();
        if (fetchResponse.readByte() != 40) {
            throw new ParsingException("ENVELOPE parse error");
        }
        String readString = fetchResponse.readString();
        if (readString != null) {
            try {
                synchronized (mailDateFormat) {
                    this.date = mailDateFormat.parse(readString);
                }
            } catch (ParseException unused) {
            }
        }
        if (parseDebug) {
            PrintStream printStream = System.out;
            printStream.println("  Date: " + this.date);
        }
        this.subject = fetchResponse.readString();
        if (parseDebug) {
            PrintStream printStream2 = System.out;
            printStream2.println("  Subject: " + this.subject);
        }
        if (parseDebug) {
            System.out.println("  From addresses:");
        }
        this.from = parseAddressList(fetchResponse);
        if (parseDebug) {
            System.out.println("  Sender addresses:");
        }
        this.sender = parseAddressList(fetchResponse);
        if (parseDebug) {
            System.out.println("  Reply-To addresses:");
        }
        this.replyTo = parseAddressList(fetchResponse);
        if (parseDebug) {
            System.out.println("  To addresses:");
        }
        this.to = parseAddressList(fetchResponse);
        if (parseDebug) {
            System.out.println("  Cc addresses:");
        }
        this.cc = parseAddressList(fetchResponse);
        if (parseDebug) {
            System.out.println("  Bcc addresses:");
        }
        this.bcc = parseAddressList(fetchResponse);
        this.inReplyTo = fetchResponse.readString();
        if (parseDebug) {
            PrintStream printStream3 = System.out;
            printStream3.println("  In-Reply-To: " + this.inReplyTo);
        }
        this.messageId = fetchResponse.readString();
        if (parseDebug) {
            PrintStream printStream4 = System.out;
            printStream4.println("  Message-ID: " + this.messageId);
        }
        if (!fetchResponse.isNextNonSpace(')')) {
            throw new ParsingException("ENVELOPE parse error");
        }
    }

    private InternetAddress[] parseAddressList(Response response) throws ParsingException {
        response.skipSpaces();
        byte readByte = response.readByte();
        if (readByte != 40) {
            if (readByte == 78 || readByte == 110) {
                response.skip(2);
                return null;
            }
            throw new ParsingException("ADDRESS parse error");
        } else if (response.isNextNonSpace(')')) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            do {
                IMAPAddress iMAPAddress = new IMAPAddress(response);
                if (parseDebug) {
                    PrintStream printStream = System.out;
                    printStream.println("    Address: " + iMAPAddress);
                }
                if (!iMAPAddress.isEndOfGroup()) {
                    arrayList.add(iMAPAddress);
                }
            } while (!response.isNextNonSpace(')'));
            return (InternetAddress[]) arrayList.toArray(new InternetAddress[arrayList.size()]);
        }
    }
}
