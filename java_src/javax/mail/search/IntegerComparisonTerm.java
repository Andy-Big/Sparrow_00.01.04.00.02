package javax.mail.search;
/* loaded from: classes2.dex */
public abstract class IntegerComparisonTerm extends ComparisonTerm {
    private static final long serialVersionUID = -6963571240154302484L;
    protected int number;

    /* JADX INFO: Access modifiers changed from: protected */
    public IntegerComparisonTerm(int i, int i2) {
        this.comparison = i;
        this.number = i2;
    }

    public int getNumber() {
        return this.number;
    }

    public int getComparison() {
        return this.comparison;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean match(int i) {
        switch (this.comparison) {
            case 1:
                return i <= this.number;
            case 2:
                return i < this.number;
            case 3:
                return i == this.number;
            case 4:
                return i != this.number;
            case 5:
                return i > this.number;
            case 6:
                return i >= this.number;
            default:
                return false;
        }
    }

    @Override // javax.mail.search.ComparisonTerm
    public boolean equals(Object obj) {
        return (obj instanceof IntegerComparisonTerm) && ((IntegerComparisonTerm) obj).number == this.number && super.equals(obj);
    }

    @Override // javax.mail.search.ComparisonTerm
    public int hashCode() {
        return this.number + super.hashCode();
    }
}
