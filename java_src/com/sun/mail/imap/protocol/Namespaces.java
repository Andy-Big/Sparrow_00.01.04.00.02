package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class Namespaces {
    public Namespace[] otherUsers;
    public Namespace[] personal;
    public Namespace[] shared;

    /* loaded from: classes2.dex */
    public static class Namespace {
        public char delimiter;
        public String prefix;

        public Namespace(Response response) throws ProtocolException {
            if (!response.isNextNonSpace('(')) {
                throw new ProtocolException("Missing '(' at start of Namespace");
            }
            this.prefix = response.readString();
            if (!response.supportsUtf8()) {
                this.prefix = BASE64MailboxDecoder.decode(this.prefix);
            }
            response.skipSpaces();
            if (response.peekByte() == 34) {
                response.readByte();
                char readByte = (char) response.readByte();
                this.delimiter = readByte;
                if (readByte == '\\') {
                    this.delimiter = (char) response.readByte();
                }
                if (response.readByte() != 34) {
                    throw new ProtocolException("Missing '\"' at end of QUOTED_CHAR");
                }
            } else {
                String readAtom = response.readAtom();
                if (readAtom == null) {
                    throw new ProtocolException("Expected NIL, got null");
                }
                if (!readAtom.equalsIgnoreCase("NIL")) {
                    throw new ProtocolException("Expected NIL, got " + readAtom);
                }
                this.delimiter = (char) 0;
            }
            if (response.isNextNonSpace(')')) {
                return;
            }
            response.readString();
            response.skipSpaces();
            response.readStringList();
            if (!response.isNextNonSpace(')')) {
                throw new ProtocolException("Missing ')' at end of Namespace");
            }
        }
    }

    public Namespaces(Response response) throws ProtocolException {
        this.personal = getNamespaces(response);
        this.otherUsers = getNamespaces(response);
        this.shared = getNamespaces(response);
    }

    private Namespace[] getNamespaces(Response response) throws ProtocolException {
        if (response.isNextNonSpace('(')) {
            ArrayList arrayList = new ArrayList();
            do {
                arrayList.add(new Namespace(response));
            } while (!response.isNextNonSpace(')'));
            return (Namespace[]) arrayList.toArray(new Namespace[arrayList.size()]);
        }
        String readAtom = response.readAtom();
        if (readAtom == null) {
            throw new ProtocolException("Expected NIL, got null");
        }
        if (readAtom.equalsIgnoreCase("NIL")) {
            return null;
        }
        throw new ProtocolException("Expected NIL, got " + readAtom);
    }
}
