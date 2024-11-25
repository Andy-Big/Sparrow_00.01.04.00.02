package ch.obermuhlner.math.big.internal;

import ch.obermuhlner.math.big.BigRational;
import java.math.BigDecimal;
import java.math.MathContext;
/* loaded from: classes.dex */
public class AsinCalculator extends SeriesCalculator {
    public static final AsinCalculator INSTANCE = new AsinCalculator();
    private int n = 0;
    private BigRational factorial2n = BigRational.ONE;
    private BigRational factorialN = BigRational.ONE;
    private BigRational fourPowerN = BigRational.ONE;

    private AsinCalculator() {
    }

    @Override // ch.obermuhlner.math.big.internal.SeriesCalculator
    protected BigRational getCurrentFactor() {
        return this.factorial2n.divide(this.fourPowerN.multiply(this.factorialN).multiply(this.factorialN).multiply((this.n * 2) + 1));
    }

    @Override // ch.obermuhlner.math.big.internal.SeriesCalculator
    protected void calculateNextFactor() {
        int i = this.n + 1;
        this.n = i;
        this.factorial2n = this.factorial2n.multiply((i * 2) - 1).multiply(this.n * 2);
        this.factorialN = this.factorialN.multiply(this.n);
        this.fourPowerN = this.fourPowerN.multiply(4);
    }

    @Override // ch.obermuhlner.math.big.internal.SeriesCalculator
    protected PowerIterator createPowerIterator(BigDecimal bigDecimal, MathContext mathContext) {
        return new PowerTwoNPlusOneIterator(bigDecimal, mathContext);
    }
}
