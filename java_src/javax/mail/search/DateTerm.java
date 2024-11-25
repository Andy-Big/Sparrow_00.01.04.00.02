package javax.mail.search;

import java.util.Date;
/* loaded from: classes2.dex */
public abstract class DateTerm extends ComparisonTerm {
    private static final long serialVersionUID = 4818873430063720043L;
    protected Date date;

    /* JADX INFO: Access modifiers changed from: protected */
    public DateTerm(int i, Date date) {
        this.comparison = i;
        this.date = date;
    }

    public Date getDate() {
        return new Date(this.date.getTime());
    }

    public int getComparison() {
        return this.comparison;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean match(Date date) {
        switch (this.comparison) {
            case 1:
                return date.before(this.date) || date.equals(this.date);
            case 2:
                return date.before(this.date);
            case 3:
                return date.equals(this.date);
            case 4:
                return !date.equals(this.date);
            case 5:
                return date.after(this.date);
            case 6:
                return date.after(this.date) || date.equals(this.date);
            default:
                return false;
        }
    }

    @Override // javax.mail.search.ComparisonTerm
    public boolean equals(Object obj) {
        return (obj instanceof DateTerm) && ((DateTerm) obj).date.equals(this.date) && super.equals(obj);
    }

    @Override // javax.mail.search.ComparisonTerm
    public int hashCode() {
        return this.date.hashCode() + super.hashCode();
    }
}
