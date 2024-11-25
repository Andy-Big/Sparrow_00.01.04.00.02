package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
/* loaded from: classes2.dex */
public class UID implements Item {
    static final char[] name = {'U', 'I', 'D'};
    public int seqnum;
    public long uid;

    public UID(FetchResponse fetchResponse) throws ParsingException {
        this.seqnum = fetchResponse.getNumber();
        fetchResponse.skipSpaces();
        this.uid = fetchResponse.readLong();
    }
}
