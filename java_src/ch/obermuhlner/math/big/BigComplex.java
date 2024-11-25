package ch.obermuhlner.math.big;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;
/* loaded from: classes.dex */
public final class BigComplex {
    public final BigDecimal im;
    public final BigDecimal re;
    public static final BigComplex ZERO = new BigComplex(BigDecimal.ZERO, BigDecimal.ZERO);
    public static final BigComplex ONE = new BigComplex(BigDecimal.ONE, BigDecimal.ZERO);
    public static final BigComplex I = new BigComplex(BigDecimal.ZERO, BigDecimal.ONE);

    private BigComplex(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        this.re = bigDecimal;
        this.im = bigDecimal2;
    }

    public BigComplex add(BigComplex bigComplex) {
        return valueOf(this.re.add(bigComplex.re), this.im.add(bigComplex.im));
    }

    public BigComplex add(BigComplex bigComplex, MathContext mathContext) {
        return valueOf(this.re.add(bigComplex.re, mathContext), this.im.add(bigComplex.im, mathContext));
    }

    public BigComplex add(BigDecimal bigDecimal, MathContext mathContext) {
        return valueOf(this.re.add(bigDecimal, mathContext), this.im);
    }

    public BigComplex add(BigDecimal bigDecimal) {
        return valueOf(this.re.add(bigDecimal), this.im);
    }

    public BigComplex add(double d) {
        return add(BigDecimal.valueOf(d));
    }

    public BigComplex subtract(BigComplex bigComplex) {
        return valueOf(this.re.subtract(bigComplex.re), this.im.subtract(bigComplex.im));
    }

    public BigComplex subtract(BigComplex bigComplex, MathContext mathContext) {
        return valueOf(this.re.subtract(bigComplex.re, mathContext), this.im.subtract(bigComplex.im, mathContext));
    }

    public BigComplex subtract(BigDecimal bigDecimal, MathContext mathContext) {
        return valueOf(this.re.subtract(bigDecimal, mathContext), this.im);
    }

    public BigComplex subtract(BigDecimal bigDecimal) {
        return valueOf(this.re.subtract(bigDecimal), this.im);
    }

    public BigComplex subtract(double d) {
        return subtract(BigDecimal.valueOf(d));
    }

    public BigComplex multiply(BigComplex bigComplex) {
        return valueOf(this.re.multiply(bigComplex.re).subtract(this.im.multiply(bigComplex.im)), this.re.multiply(bigComplex.im).add(this.im.multiply(bigComplex.re)));
    }

    public BigComplex multiply(BigComplex bigComplex, MathContext mathContext) {
        return valueOf(this.re.multiply(bigComplex.re, mathContext).subtract(this.im.multiply(bigComplex.im, mathContext), mathContext), this.re.multiply(bigComplex.im, mathContext).add(this.im.multiply(bigComplex.re, mathContext), mathContext));
    }

    public BigComplex multiply(BigDecimal bigDecimal, MathContext mathContext) {
        return valueOf(this.re.multiply(bigDecimal, mathContext), this.im.multiply(bigDecimal, mathContext));
    }

    public BigComplex multiply(BigDecimal bigDecimal) {
        return valueOf(this.re.multiply(bigDecimal), this.im.multiply(bigDecimal));
    }

    public BigComplex multiply(double d) {
        return multiply(BigDecimal.valueOf(d));
    }

    public BigComplex divide(BigComplex bigComplex, MathContext mathContext) {
        return multiply(bigComplex.reciprocal(mathContext), mathContext);
    }

    public BigComplex divide(BigDecimal bigDecimal, MathContext mathContext) {
        return valueOf(this.re.divide(bigDecimal, mathContext), this.im.divide(bigDecimal, mathContext));
    }

    public BigComplex divide(double d, MathContext mathContext) {
        return divide(BigDecimal.valueOf(d), mathContext);
    }

    public BigComplex reciprocal(MathContext mathContext) {
        BigDecimal absSquare = absSquare(mathContext);
        return valueOf(this.re.divide(absSquare, mathContext), this.im.negate().divide(absSquare, mathContext));
    }

    public BigComplex conjugate() {
        return valueOf(this.re, this.im.negate());
    }

    public BigComplex negate() {
        return valueOf(this.re.negate(), this.im.negate());
    }

    public BigDecimal abs(MathContext mathContext) {
        return BigDecimalMath.sqrt(absSquare(mathContext), mathContext);
    }

    public BigDecimal angle(MathContext mathContext) {
        return BigDecimalMath.atan2(this.im, this.re, mathContext);
    }

    public BigDecimal absSquare(MathContext mathContext) {
        BigDecimal bigDecimal = this.re;
        BigDecimal multiply = bigDecimal.multiply(bigDecimal, mathContext);
        BigDecimal bigDecimal2 = this.im;
        return multiply.add(bigDecimal2.multiply(bigDecimal2, mathContext), mathContext);
    }

    public boolean isReal() {
        return this.im.signum() == 0;
    }

    public BigComplex re() {
        return valueOf(this.re, BigDecimal.ZERO);
    }

    public BigComplex im() {
        return valueOf(BigDecimal.ZERO, this.im);
    }

    public BigComplex round(MathContext mathContext) {
        return valueOf(this.re.round(mathContext), this.im.round(mathContext));
    }

    public int hashCode() {
        return Objects.hash(this.re, this.im);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BigComplex bigComplex = (BigComplex) obj;
            return this.re.compareTo(bigComplex.re) == 0 && this.im.compareTo(bigComplex.im) == 0;
        }
        return false;
    }

    public boolean strictEquals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BigComplex bigComplex = (BigComplex) obj;
            return this.re.equals(bigComplex.re) && this.im.equals(bigComplex.im);
        }
        return false;
    }

    public String toString() {
        if (this.im.signum() >= 0) {
            return "(" + this.re + " + " + this.im + " i)";
        }
        return "(" + this.re + " - " + this.im.negate() + " i)";
    }

    public static BigComplex valueOf(BigDecimal bigDecimal) {
        return valueOf(bigDecimal, BigDecimal.ZERO);
    }

    public static BigComplex valueOf(double d) {
        return valueOf(BigDecimal.valueOf(d), BigDecimal.ZERO);
    }

    public static BigComplex valueOf(double d, double d2) {
        return valueOf(BigDecimal.valueOf(d), BigDecimal.valueOf(d2));
    }

    public static BigComplex valueOf(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        if (bigDecimal.signum() == 0) {
            if (bigDecimal2.signum() == 0) {
                return ZERO;
            }
            if (bigDecimal2.compareTo(BigDecimal.ONE) == 0) {
                return I;
            }
        }
        if (bigDecimal2.signum() == 0 && bigDecimal.compareTo(BigDecimal.ONE) == 0) {
            return ONE;
        }
        return new BigComplex(bigDecimal, bigDecimal2);
    }

    public static BigComplex valueOfPolar(BigDecimal bigDecimal, BigDecimal bigDecimal2, MathContext mathContext) {
        if (bigDecimal.signum() == 0) {
            return ZERO;
        }
        return valueOf(bigDecimal.multiply(BigDecimalMath.cos(bigDecimal2, mathContext), mathContext), bigDecimal.multiply(BigDecimalMath.sin(bigDecimal2, mathContext), mathContext));
    }

    public static BigComplex valueOfPolar(double d, double d2, MathContext mathContext) {
        return valueOfPolar(BigDecimal.valueOf(d), BigDecimal.valueOf(d2), mathContext);
    }
}
