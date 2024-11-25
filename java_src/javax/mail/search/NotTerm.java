package javax.mail.search;

import javax.mail.Message;
/* loaded from: classes2.dex */
public final class NotTerm extends SearchTerm {
    private static final long serialVersionUID = 7152293214217310216L;
    private SearchTerm term;

    public NotTerm(SearchTerm searchTerm) {
        this.term = searchTerm;
    }

    public SearchTerm getTerm() {
        return this.term;
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        return !this.term.match(message);
    }

    public boolean equals(Object obj) {
        if (obj instanceof NotTerm) {
            return ((NotTerm) obj).term.equals(this.term);
        }
        return false;
    }

    public int hashCode() {
        return this.term.hashCode() << 1;
    }
}
