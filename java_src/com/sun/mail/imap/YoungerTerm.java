package com.sun.mail.imap;

import java.util.Date;
import javax.mail.Message;
import javax.mail.search.SearchTerm;
/* loaded from: classes2.dex */
public final class YoungerTerm extends SearchTerm {
    private static final long serialVersionUID = 1592714210688163496L;
    private int interval;

    public YoungerTerm(int i) {
        this.interval = i;
    }

    public int getInterval() {
        return this.interval;
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        try {
            Date receivedDate = message.getReceivedDate();
            return receivedDate != null && receivedDate.getTime() >= System.currentTimeMillis() - (((long) this.interval) * 1000);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof YoungerTerm) && this.interval == ((YoungerTerm) obj).interval;
    }

    public int hashCode() {
        return this.interval;
    }
}
