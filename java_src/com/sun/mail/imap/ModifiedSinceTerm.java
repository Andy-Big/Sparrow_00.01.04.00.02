package com.sun.mail.imap;

import javax.mail.Message;
import javax.mail.search.SearchTerm;
/* loaded from: classes2.dex */
public final class ModifiedSinceTerm extends SearchTerm {
    private static final long serialVersionUID = 5151457469634727992L;
    private long modseq;

    public ModifiedSinceTerm(long j) {
        this.modseq = j;
    }

    public long getModSeq() {
        return this.modseq;
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        try {
            if (message instanceof IMAPMessage) {
                return ((IMAPMessage) message).getModSeq() >= this.modseq;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ModifiedSinceTerm) && this.modseq == ((ModifiedSinceTerm) obj).modseq;
    }

    public int hashCode() {
        return (int) this.modseq;
    }
}
