package ch.obermuhlner.math.big.internal;

import ch.obermuhlner.math.big.BigRational;
import java.math.BigDecimal;
import java.math.MathContext;
/* loaded from: classes.dex */
public class SinCalculator extends SeriesCalculator {
    public static final SinCalculator INSTANCE = new SinCalculator();
    private BigRational factorial2nPlus1;
    private int n;
    private boolean negative;

    private SinCalculator() {
        super(true);
        this.n = 0;
        this.negative = false;
        this.factorial2nPlus1 = BigRational.ONE;
    }

    @Override // ch.obermuhlner.math.big.internal.SeriesCalculator
    protected BigRational getCurrentFactor() {
        BigRational reciprocal = this.factorial2nPlus1.reciprocal();
        return this.negative ? reciprocal.negate() : reciprocal;
    }

    @Override // ch.obermuhlner.math.big.internal.SeriesCalculator
    protected void calculateNextFactor() {
        int i = this.n + 1;
        this.n = i;
        BigRational multiply = this.factorial2nPlus1.multiply(i * 2);
        this.factorial2nPlus1 = multiply;
        this.factorial2nPlus1 = multiply.multiply((this.n * 2) + 1);
        this.negative = !this.negative;
    }

    @Override // ch.obermuhlner.math.big.internal.SeriesCalculator
    protected PowerIterator createPowerIterator(BigDecimal bigDecimal, MathContext mathContext) {
        return new PowerTwoNPlusOneIterator(bigDecimal, mathContext);
    }
}
