package ch.obermuhlner.math.big.internal;

import ch.obermuhlner.math.big.BigRational;
import java.math.BigDecimal;
import java.math.MathContext;
/* loaded from: classes.dex */
public class ExpCalculator extends SeriesCalculator {
    public static final ExpCalculator INSTANCE = new ExpCalculator();
    private int n = 0;
    private BigRational oneOverFactorialOfN = BigRational.ONE;

    private ExpCalculator() {
    }

    @Override // ch.obermuhlner.math.big.internal.SeriesCalculator
    protected BigRational getCurrentFactor() {
        return this.oneOverFactorialOfN;
    }

    @Override // ch.obermuhlner.math.big.internal.SeriesCalculator
    protected void calculateNextFactor() {
        int i = this.n + 1;
        this.n = i;
        this.oneOverFactorialOfN = this.oneOverFactorialOfN.divide(i);
    }

    @Override // ch.obermuhlner.math.big.internal.SeriesCalculator
    protected PowerIterator createPowerIterator(BigDecimal bigDecimal, MathContext mathContext) {
        return new PowerNIterator(bigDecimal, mathContext);
    }
}
