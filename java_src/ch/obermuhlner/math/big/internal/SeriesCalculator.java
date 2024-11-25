package ch.obermuhlner.math.big.internal;

import ch.obermuhlner.math.big.BigRational;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public abstract class SeriesCalculator {
    private final boolean calculateInPairs;
    private final List<BigRational> factors;

    protected abstract void calculateNextFactor();

    protected abstract PowerIterator createPowerIterator(BigDecimal bigDecimal, MathContext mathContext);

    protected abstract BigRational getCurrentFactor();

    /* JADX INFO: Access modifiers changed from: protected */
    public SeriesCalculator() {
        this(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SeriesCalculator(boolean z) {
        this.factors = new ArrayList();
        this.calculateInPairs = z;
    }

    public BigDecimal calculate(BigDecimal bigDecimal, MathContext mathContext) {
        BigDecimal divide;
        BigDecimal movePointLeft = BigDecimal.ONE.movePointLeft(mathContext.getPrecision() + 1);
        PowerIterator createPowerIterator = createPowerIterator(bigDecimal, mathContext);
        BigDecimal bigDecimal2 = BigDecimal.ZERO;
        int i = 0;
        do {
            BigRational factor = getFactor(i);
            BigDecimal currentPower = createPowerIterator.getCurrentPower();
            createPowerIterator.calculateNextPower();
            divide = factor.getNumerator().multiply(currentPower).divide(factor.getDenominator(), mathContext);
            i++;
            if (this.calculateInPairs) {
                BigRational factor2 = getFactor(i);
                BigDecimal currentPower2 = createPowerIterator.getCurrentPower();
                createPowerIterator.calculateNextPower();
                divide = divide.add(factor2.getNumerator().multiply(currentPower2).divide(factor2.getDenominator(), mathContext));
                i++;
            }
            bigDecimal2 = bigDecimal2.add(divide);
        } while (divide.abs().compareTo(movePointLeft) > 0);
        return bigDecimal2.round(mathContext);
    }

    protected synchronized BigRational getFactor(int i) {
        while (this.factors.size() <= i) {
            addFactor(getCurrentFactor());
            calculateNextFactor();
        }
        return this.factors.get(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addFactor(BigRational bigRational) {
        this.factors.add(Objects.requireNonNull(bigRational, "Factor cannot be null"));
    }
}
