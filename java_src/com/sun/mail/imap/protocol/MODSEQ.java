package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
/* loaded from: classes2.dex */
public class MODSEQ implements Item {
    static final char[] name = {'M', 'O', 'D', 'S', 'E', 'Q'};
    public long modseq;
    public int seqnum;

    public MODSEQ(FetchResponse fetchResponse) throws ParsingException {
        this.seqnum = fetchResponse.getNumber();
        fetchResponse.skipSpaces();
        if (fetchResponse.readByte() != 40) {
            throw new ParsingException("MODSEQ parse error");
        }
        this.modseq = fetchResponse.readLong();
        if (!fetchResponse.isNextNonSpace(')')) {
            throw new ParsingException("MODSEQ parse error");
        }
    }
}
