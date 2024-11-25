package ch.obermuhlner.math.big.internal;

import java.math.BigDecimal;
import java.math.MathContext;
/* loaded from: classes.dex */
public class PowerTwoNPlusOneIterator implements PowerIterator {
    private final MathContext mathContext;
    private BigDecimal powerOfX;
    private final BigDecimal xPowerTwo;

    public PowerTwoNPlusOneIterator(BigDecimal bigDecimal, MathContext mathContext) {
        this.mathContext = mathContext;
        this.xPowerTwo = bigDecimal.multiply(bigDecimal, mathContext);
        this.powerOfX = bigDecimal;
    }

    @Override // ch.obermuhlner.math.big.internal.PowerIterator
    public BigDecimal getCurrentPower() {
        return this.powerOfX;
    }

    @Override // ch.obermuhlner.math.big.internal.PowerIterator
    public void calculateNextPower() {
        this.powerOfX = this.powerOfX.multiply(this.xPowerTwo, this.mathContext);
    }
}
