package ch.obermuhlner.math.big.internal;

import ch.obermuhlner.math.big.BigRational;
import java.math.BigDecimal;
import java.math.MathContext;
/* loaded from: classes.dex */
public class CoshCalculator extends SeriesCalculator {
    public static final CoshCalculator INSTANCE = new CoshCalculator();
    private BigRational factorial2n;
    private int n;

    private CoshCalculator() {
        super(true);
        this.n = 0;
        this.factorial2n = BigRational.ONE;
    }

    @Override // ch.obermuhlner.math.big.internal.SeriesCalculator
    protected BigRational getCurrentFactor() {
        return this.factorial2n.reciprocal();
    }

    @Override // ch.obermuhlner.math.big.internal.SeriesCalculator
    protected void calculateNextFactor() {
        int i = this.n + 1;
        this.n = i;
        this.factorial2n = this.factorial2n.multiply((i * 2) - 1).multiply(this.n * 2);
    }

    @Override // ch.obermuhlner.math.big.internal.SeriesCalculator
    protected PowerIterator createPowerIterator(BigDecimal bigDecimal, MathContext mathContext) {
        return new PowerTwoNIterator(bigDecimal, mathContext);
    }
}
