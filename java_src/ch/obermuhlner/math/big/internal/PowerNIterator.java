package ch.obermuhlner.math.big.internal;

import java.math.BigDecimal;
import java.math.MathContext;
/* loaded from: classes.dex */
public class PowerNIterator implements PowerIterator {
    private final MathContext mathContext;
    private BigDecimal powerOfX = BigDecimal.ONE;
    private final BigDecimal x;

    public PowerNIterator(BigDecimal bigDecimal, MathContext mathContext) {
        this.x = bigDecimal;
        this.mathContext = mathContext;
    }

    @Override // ch.obermuhlner.math.big.internal.PowerIterator
    public BigDecimal getCurrentPower() {
        return this.powerOfX;
    }

    @Override // ch.obermuhlner.math.big.internal.PowerIterator
    public void calculateNextPower() {
        this.powerOfX = this.powerOfX.multiply(this.x, this.mathContext);
    }
}
