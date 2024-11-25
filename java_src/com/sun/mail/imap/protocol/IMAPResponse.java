package com.sun.mail.imap.protocol;

import com.sun.mail.iap.Protocol;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.util.ASCIIUtility;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class IMAPResponse extends Response {
    private String key;
    private int number;

    public IMAPResponse(Protocol protocol) throws IOException, ProtocolException {
        super(protocol);
        init();
    }

    private void init() throws IOException, ProtocolException {
        if (!isUnTagged() || isOK() || isNO() || isBAD() || isBYE()) {
            return;
        }
        String readAtom = readAtom();
        this.key = readAtom;
        try {
            this.number = Integer.parseInt(readAtom);
            this.key = readAtom();
        } catch (NumberFormatException unused) {
        }
    }

    public IMAPResponse(IMAPResponse iMAPResponse) {
        super(iMAPResponse);
        this.key = iMAPResponse.key;
        this.number = iMAPResponse.number;
    }

    public IMAPResponse(String str) throws IOException, ProtocolException {
        this(str, true);
    }

    public IMAPResponse(String str, boolean z) throws IOException, ProtocolException {
        super(str, z);
        init();
    }

    public String[] readSimpleList() {
        skipSpaces();
        if (this.buffer[this.index] != 40) {
            return null;
        }
        this.index++;
        ArrayList arrayList = new ArrayList();
        int i = this.index;
        while (this.buffer[this.index] != 41) {
            if (this.buffer[this.index] == 32) {
                arrayList.add(ASCIIUtility.toString(this.buffer, i, this.index));
                i = this.index + 1;
            }
            this.index++;
        }
        if (this.index > i) {
            arrayList.add(ASCIIUtility.toString(this.buffer, i, this.index));
        }
        this.index++;
        int size = arrayList.size();
        if (size > 0) {
            return (String[]) arrayList.toArray(new String[size]);
        }
        return null;
    }

    public String getKey() {
        return this.key;
    }

    public boolean keyEquals(String str) {
        String str2 = this.key;
        return str2 != null && str2.equalsIgnoreCase(str);
    }

    public int getNumber() {
        return this.number;
    }
}
