package ch.obermuhlner.math.big.internal;

import ch.obermuhlner.math.big.BigRational;
import java.math.BigDecimal;
import java.math.MathContext;
/* loaded from: classes.dex */
public class AtanhCalculator extends SeriesCalculator {
    public static final AtanhCalculator INSTANCE = new AtanhCalculator();
    private int n;

    private AtanhCalculator() {
        super(true);
        this.n = 0;
    }

    @Override // ch.obermuhlner.math.big.internal.SeriesCalculator
    protected BigRational getCurrentFactor() {
        return BigRational.valueOf(1, (this.n * 2) + 1);
    }

    @Override // ch.obermuhlner.math.big.internal.SeriesCalculator
    protected void calculateNextFactor() {
        this.n++;
    }

    @Override // ch.obermuhlner.math.big.internal.SeriesCalculator
    protected PowerIterator createPowerIterator(BigDecimal bigDecimal, MathContext mathContext) {
        return new PowerTwoNPlusOneIterator(bigDecimal, mathContext);
    }
}
