package ch.obermuhlner.math.big.internal;

import ch.obermuhlner.math.big.BigDecimalMath;
import java.math.BigDecimal;
import java.math.MathContext;
/* loaded from: classes.dex */
public class PowerTwoNMinusOneIterator implements PowerIterator {
    private final MathContext mathContext;
    private BigDecimal powerOfX;
    private final BigDecimal xPowerTwo;

    public PowerTwoNMinusOneIterator(BigDecimal bigDecimal, MathContext mathContext) {
        this.mathContext = mathContext;
        this.xPowerTwo = bigDecimal.multiply(bigDecimal, mathContext);
        this.powerOfX = BigDecimalMath.reciprocal(bigDecimal, mathContext);
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
