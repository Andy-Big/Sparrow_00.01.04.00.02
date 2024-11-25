package ch.obermuhlner.math.big;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
/* loaded from: classes.dex */
public class BigComplexMath {
    private static final BigDecimal TWO = BigDecimal.valueOf(2L);

    public static BigComplex reciprocal(BigComplex bigComplex, MathContext mathContext) {
        return bigComplex.reciprocal(mathContext);
    }

    public static BigComplex conjugate(BigComplex bigComplex) {
        return bigComplex.conjugate();
    }

    public static BigDecimal abs(BigComplex bigComplex, MathContext mathContext) {
        return bigComplex.abs(mathContext);
    }

    public static BigDecimal absSquare(BigComplex bigComplex, MathContext mathContext) {
        return bigComplex.absSquare(mathContext);
    }

    public static BigDecimal angle(BigComplex bigComplex, MathContext mathContext) {
        return bigComplex.angle(mathContext);
    }

    public static BigComplex factorial(BigComplex bigComplex, MathContext mathContext) {
        if (bigComplex.isReal() && BigDecimalMath.isIntValue(bigComplex.re)) {
            return BigComplex.valueOf(BigDecimalMath.factorial(bigComplex.re.intValueExact()).round(mathContext));
        }
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() * 2, mathContext.getRoundingMode());
        int precision = (mathContext.getPrecision() * 13) / 10;
        List<BigDecimal> spougeFactorialConstants = BigDecimalMath.getSpougeFactorialConstants(precision);
        BigDecimal valueOf = BigDecimal.valueOf(precision);
        BigComplex valueOf2 = BigComplex.valueOf(spougeFactorialConstants.get(0));
        for (int i = 1; i < precision; i++) {
            valueOf2 = valueOf2.add(BigComplex.valueOf(spougeFactorialConstants.get(i)).divide(bigComplex.add(BigDecimal.valueOf(i)), mathContext2), mathContext2);
        }
        return pow(bigComplex.add(valueOf, mathContext2), bigComplex.add(BigDecimal.valueOf(0.5d), mathContext2), mathContext2).multiply(exp(bigComplex.negate().subtract(valueOf, mathContext2), mathContext2), mathContext2).multiply(valueOf2, mathContext2).round(mathContext);
    }

    public static BigComplex gamma(BigComplex bigComplex, MathContext mathContext) {
        return factorial(bigComplex.subtract(BigComplex.ONE), mathContext);
    }

    public static BigComplex exp(BigComplex bigComplex, MathContext mathContext) {
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode());
        BigDecimal exp = BigDecimalMath.exp(bigComplex.re, mathContext2);
        return BigComplex.valueOf(exp.multiply(BigDecimalMath.cos(bigComplex.im, mathContext2), mathContext2).round(mathContext), exp.multiply(BigDecimalMath.sin(bigComplex.im, mathContext2), mathContext2)).round(mathContext);
    }

    public static BigComplex sin(BigComplex bigComplex, MathContext mathContext) {
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode());
        return BigComplex.valueOf(BigDecimalMath.sin(bigComplex.re, mathContext2).multiply(BigDecimalMath.cosh(bigComplex.im, mathContext2), mathContext2).round(mathContext), BigDecimalMath.cos(bigComplex.re, mathContext2).multiply(BigDecimalMath.sinh(bigComplex.im, mathContext2), mathContext2).round(mathContext));
    }

    public static BigComplex cos(BigComplex bigComplex, MathContext mathContext) {
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode());
        return BigComplex.valueOf(BigDecimalMath.cos(bigComplex.re, mathContext2).multiply(BigDecimalMath.cosh(bigComplex.im, mathContext2), mathContext2).round(mathContext), BigDecimalMath.sin(bigComplex.re, mathContext2).multiply(BigDecimalMath.sinh(bigComplex.im, mathContext2), mathContext2).negate().round(mathContext));
    }

    public static BigComplex tan(BigComplex bigComplex, MathContext mathContext) {
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode());
        return sin(bigComplex, mathContext2).divide(cos(bigComplex, mathContext2), mathContext2).round(mathContext);
    }

    public static BigComplex atan(BigComplex bigComplex, MathContext mathContext) {
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode());
        return log(BigComplex.I.subtract(bigComplex, mathContext2).divide(BigComplex.I.add(bigComplex, mathContext2), mathContext2), mathContext2).divide(BigComplex.I, mathContext2).divide(TWO, mathContext2).round(mathContext);
    }

    public static BigComplex acot(BigComplex bigComplex, MathContext mathContext) {
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode());
        return log(bigComplex.add(BigComplex.I, mathContext2).divide(bigComplex.subtract(BigComplex.I, mathContext2), mathContext2), mathContext2).divide(BigComplex.I, mathContext2).divide(TWO, mathContext2).round(mathContext);
    }

    public static BigComplex asin(BigComplex bigComplex, MathContext mathContext) {
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode());
        return BigComplex.I.negate().multiply(log(BigComplex.I.multiply(bigComplex, mathContext2).add(sqrt(BigComplex.ONE.subtract(bigComplex.multiply(bigComplex, mathContext2), mathContext2), mathContext2), mathContext2), mathContext2), mathContext2).round(mathContext);
    }

    public static BigComplex acos(BigComplex bigComplex, MathContext mathContext) {
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode());
        return BigComplex.I.negate().multiply(log(bigComplex.add(sqrt(bigComplex.multiply(bigComplex, mathContext2).subtract(BigComplex.ONE, mathContext2), mathContext2), mathContext2), mathContext2), mathContext2).round(mathContext);
    }

    public static BigComplex sqrt(BigComplex bigComplex, MathContext mathContext) {
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode());
        BigDecimal abs = bigComplex.abs(mathContext2);
        BigComplex add = bigComplex.add(abs, mathContext2);
        return add.divide(add.abs(mathContext2), mathContext2).multiply(BigDecimalMath.sqrt(abs, mathContext2), mathContext2).round(mathContext);
    }

    public static BigComplex log(BigComplex bigComplex, MathContext mathContext) {
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 20, mathContext.getRoundingMode());
        return BigComplex.valueOf(BigDecimalMath.log(bigComplex.abs(mathContext2), mathContext2).round(mathContext), bigComplex.angle(new MathContext(mathContext.getPrecision() + 5, mathContext.getRoundingMode()))).round(mathContext);
    }

    public static BigComplex pow(BigComplex bigComplex, long j, MathContext mathContext) {
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 10, mathContext.getRoundingMode());
        if (j < 0) {
            return BigComplex.ONE.divide(pow(bigComplex, -j, mathContext2), mathContext2).round(mathContext);
        }
        BigComplex bigComplex2 = BigComplex.ONE;
        while (j > 0) {
            if ((j & 1) == 1) {
                bigComplex2 = bigComplex2.multiply(bigComplex, mathContext2);
                j--;
            }
            if (j > 0) {
                bigComplex = bigComplex.multiply(bigComplex, mathContext2);
            }
            j >>= 1;
        }
        return bigComplex2.round(mathContext);
    }

    public static BigComplex pow(BigComplex bigComplex, BigDecimal bigDecimal, MathContext mathContext) {
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode());
        BigDecimal multiply = bigComplex.angle(mathContext2).multiply(bigDecimal, mathContext2);
        return BigComplex.valueOf(BigDecimalMath.cos(multiply, mathContext2), BigDecimalMath.sin(multiply, mathContext2)).multiply(BigDecimalMath.pow(bigComplex.abs(mathContext2), bigDecimal, mathContext2), mathContext2).round(mathContext);
    }

    public static BigComplex pow(BigComplex bigComplex, BigComplex bigComplex2, MathContext mathContext) {
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode());
        return exp(bigComplex2.multiply(log(bigComplex, mathContext2), mathContext2), mathContext2).round(mathContext);
    }

    public static BigComplex root(BigComplex bigComplex, BigDecimal bigDecimal, MathContext mathContext) {
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode());
        return pow(bigComplex, BigDecimal.ONE.divide(bigDecimal, mathContext2), mathContext2).round(mathContext);
    }

    public static BigComplex root(BigComplex bigComplex, BigComplex bigComplex2, MathContext mathContext) {
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode());
        return pow(bigComplex, BigComplex.ONE.divide(bigComplex2, mathContext2), mathContext2).round(mathContext);
    }
}
