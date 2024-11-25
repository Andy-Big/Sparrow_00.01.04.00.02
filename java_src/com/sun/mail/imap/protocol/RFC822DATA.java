package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ByteArray;
import com.sun.mail.iap.ParsingException;
import java.io.ByteArrayInputStream;
/* loaded from: classes2.dex */
public class RFC822DATA implements Item {
    static final char[] name = {'R', 'F', 'C', '8', '2', '2'};
    private final ByteArray data;
    private final boolean isHeader;
    private final int msgno;

    public RFC822DATA(FetchResponse fetchResponse) throws ParsingException {
        this(fetchResponse, false);
    }

    public RFC822DATA(FetchResponse fetchResponse, boolean z) throws ParsingException {
        this.isHeader = z;
        this.msgno = fetchResponse.getNumber();
        fetchResponse.skipSpaces();
        this.data = fetchResponse.readByteArray();
    }

    public ByteArray getByteArray() {
        return this.data;
    }

    public ByteArrayInputStream getByteArrayInputStream() {
        ByteArray byteArray = this.data;
        if (byteArray != null) {
            return byteArray.toByteArrayInputStream();
        }
        return null;
    }

    public boolean isHeader() {
        return this.isHeader;
    }
}
