package ch.obermuhlner.math.big.internal;

import ch.obermuhlner.math.big.BigRational;
import java.math.BigDecimal;
import java.math.MathContext;
/* loaded from: classes.dex */
public class SinhCalculator extends SeriesCalculator {
    public static final SinhCalculator INSTANCE = new SinhCalculator();
    private BigRational factorial2nPlus1;
    private int n;

    private SinhCalculator() {
        super(true);
        this.n = 0;
        this.factorial2nPlus1 = BigRational.ONE;
    }

    @Override // ch.obermuhlner.math.big.internal.SeriesCalculator
    protected BigRational getCurrentFactor() {
        return this.factorial2nPlus1.reciprocal();
    }

    @Override // ch.obermuhlner.math.big.internal.SeriesCalculator
    protected void calculateNextFactor() {
        int i = this.n + 1;
        this.n = i;
        BigRational multiply = this.factorial2nPlus1.multiply(i * 2);
        this.factorial2nPlus1 = multiply;
        this.factorial2nPlus1 = multiply.multiply((this.n * 2) + 1);
    }

    @Override // ch.obermuhlner.math.big.internal.SeriesCalculator
    protected PowerIterator createPowerIterator(BigDecimal bigDecimal, MathContext mathContext) {
        return new PowerTwoNPlusOneIterator(bigDecimal, mathContext);
    }
}
