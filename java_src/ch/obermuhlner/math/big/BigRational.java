package ch.obermuhlner.math.big;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
/* loaded from: classes.dex */
public class BigRational implements Comparable<BigRational> {
    private final BigDecimal denominator;
    private final BigDecimal numerator;
    public static final BigRational ZERO = new BigRational(0);
    public static final BigRational ONE = new BigRational(1);
    public static final BigRational TWO = new BigRational(2);
    public static final BigRational TEN = new BigRational(10);
    private static List<BigRational> bernoulliCache = new ArrayList();

    private BigRational(int i) {
        this(BigDecimal.valueOf(i), BigDecimal.ONE);
    }

    private BigRational(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        if (bigDecimal2.signum() == 0) {
            throw new ArithmeticException("Divide by zero");
        }
        if (bigDecimal2.signum() < 0) {
            bigDecimal = bigDecimal.negate();
            bigDecimal2 = bigDecimal2.negate();
        }
        this.numerator = bigDecimal;
        this.denominator = bigDecimal2;
    }

    public BigInteger getNumeratorBigInteger() {
        return this.numerator.toBigInteger();
    }

    public BigDecimal getNumerator() {
        return this.numerator;
    }

    public BigInteger getDenominatorBigInteger() {
        return this.denominator.toBigInteger();
    }

    public BigDecimal getDenominator() {
        return this.denominator;
    }

    public BigRational reduce() {
        BigInteger bigInteger = this.numerator.toBigInteger();
        BigInteger bigInteger2 = this.denominator.toBigInteger();
        BigInteger gcd = bigInteger.gcd(bigInteger2);
        return valueOf(bigInteger.divide(gcd), bigInteger2.divide(gcd));
    }

    public BigRational integerPart() {
        BigDecimal bigDecimal = this.numerator;
        return of(bigDecimal.subtract(bigDecimal.remainder(this.denominator)), this.denominator);
    }

    public BigRational fractionPart() {
        return of(this.numerator.remainder(this.denominator), this.denominator);
    }

    public BigRational negate() {
        return isZero() ? this : of(this.numerator.negate(), this.denominator);
    }

    public BigRational reciprocal() {
        return of(this.denominator, this.numerator);
    }

    public BigRational abs() {
        return isPositive() ? this : negate();
    }

    public int signum() {
        return this.numerator.signum();
    }

    public BigRational increment() {
        return of(this.numerator.add(this.denominator), this.denominator);
    }

    public BigRational decrement() {
        return of(this.numerator.subtract(this.denominator), this.denominator);
    }

    public BigRational add(BigRational bigRational) {
        if (this.denominator.equals(bigRational.denominator)) {
            return of(this.numerator.add(bigRational.numerator), this.denominator);
        }
        return of(this.numerator.multiply(bigRational.denominator).add(bigRational.numerator.multiply(this.denominator)), this.denominator.multiply(bigRational.denominator));
    }

    private BigRational add(BigDecimal bigDecimal) {
        return of(this.numerator.add(bigDecimal.multiply(this.denominator)), this.denominator);
    }

    public BigRational add(BigInteger bigInteger) {
        return bigInteger.equals(BigInteger.ZERO) ? this : add(new BigDecimal(bigInteger));
    }

    public BigRational add(int i) {
        return i == 0 ? this : add(BigInteger.valueOf(i));
    }

    public BigRational subtract(BigRational bigRational) {
        if (this.denominator.equals(bigRational.denominator)) {
            return of(this.numerator.subtract(bigRational.numerator), this.denominator);
        }
        return of(this.numerator.multiply(bigRational.denominator).subtract(bigRational.numerator.multiply(this.denominator)), this.denominator.multiply(bigRational.denominator));
    }

    private BigRational subtract(BigDecimal bigDecimal) {
        return of(this.numerator.subtract(bigDecimal.multiply(this.denominator)), this.denominator);
    }

    public BigRational subtract(BigInteger bigInteger) {
        return bigInteger.equals(BigInteger.ZERO) ? this : subtract(new BigDecimal(bigInteger));
    }

    public BigRational subtract(int i) {
        return i == 0 ? this : subtract(BigInteger.valueOf(i));
    }

    public BigRational multiply(BigRational bigRational) {
        if (isZero() || bigRational.isZero()) {
            return ZERO;
        }
        return equals(ONE) ? bigRational : bigRational.equals(ONE) ? this : of(this.numerator.multiply(bigRational.numerator), this.denominator.multiply(bigRational.denominator));
    }

    private BigRational multiply(BigDecimal bigDecimal) {
        return of(this.numerator.multiply(bigDecimal), this.denominator);
    }

    public BigRational multiply(BigInteger bigInteger) {
        if (isZero() || bigInteger.signum() == 0) {
            return ZERO;
        }
        if (equals(ONE)) {
            return valueOf(bigInteger);
        }
        return bigInteger.equals(BigInteger.ONE) ? this : multiply(new BigDecimal(bigInteger));
    }

    public BigRational multiply(int i) {
        return multiply(BigInteger.valueOf(i));
    }

    public BigRational divide(BigRational bigRational) {
        return bigRational.equals(ONE) ? this : of(this.numerator.multiply(bigRational.denominator), this.denominator.multiply(bigRational.numerator));
    }

    private BigRational divide(BigDecimal bigDecimal) {
        return of(this.numerator, this.denominator.multiply(bigDecimal));
    }

    public BigRational divide(BigInteger bigInteger) {
        return bigInteger.equals(BigInteger.ONE) ? this : divide(new BigDecimal(bigInteger));
    }

    public BigRational divide(int i) {
        return divide(BigInteger.valueOf(i));
    }

    public boolean isZero() {
        return this.numerator.signum() == 0;
    }

    private boolean isPositive() {
        return this.numerator.signum() > 0;
    }

    public boolean isInteger() {
        return isIntegerInternal() || reduce().isIntegerInternal();
    }

    private boolean isIntegerInternal() {
        return this.denominator.compareTo(BigDecimal.ONE) == 0;
    }

    public BigRational pow(int i) {
        BigInteger pow;
        BigInteger pow2;
        if (i == 0) {
            return ONE;
        }
        if (i == 1) {
            return this;
        }
        if (i > 0) {
            pow = this.numerator.toBigInteger().pow(i);
            pow2 = this.denominator.toBigInteger().pow(i);
        } else {
            int i2 = -i;
            pow = this.denominator.toBigInteger().pow(i2);
            pow2 = this.numerator.toBigInteger().pow(i2);
        }
        return valueOf(pow, pow2);
    }

    private BigRational min(BigRational bigRational) {
        return compareTo(bigRational) <= 0 ? this : bigRational;
    }

    private BigRational max(BigRational bigRational) {
        return compareTo(bigRational) >= 0 ? this : bigRational;
    }

    public BigRational withPrecision(int i) {
        return valueOf(toBigDecimal(new MathContext(i)));
    }

    public BigRational withScale(int i) {
        return valueOf(toBigDecimal().setScale(i, RoundingMode.HALF_UP));
    }

    private static int countDigits(BigInteger bigInteger) {
        int log = (int) (((Math.log(2.0d) / Math.log(10.0d)) * bigInteger.bitLength()) + 1.0d);
        int i = log - 1;
        return BigInteger.TEN.pow(i).compareTo(bigInteger) > 0 ? i : log;
    }

    private int precision() {
        return countDigits(this.numerator.toBigInteger()) + countDigits(this.denominator.toBigInteger());
    }

    public double toDouble() {
        return this.numerator.doubleValue() / this.denominator.doubleValue();
    }

    public float toFloat() {
        return this.numerator.floatValue() / this.denominator.floatValue();
    }

    public BigDecimal toBigDecimal() {
        return toBigDecimal(new MathContext(Math.max(precision(), MathContext.DECIMAL128.getPrecision())));
    }

    public BigDecimal toBigDecimal(MathContext mathContext) {
        return this.numerator.divide(this.denominator, mathContext);
    }

    @Override // java.lang.Comparable
    public int compareTo(BigRational bigRational) {
        if (this == bigRational) {
            return 0;
        }
        return this.numerator.multiply(bigRational.denominator).compareTo(this.denominator.multiply(bigRational.numerator));
    }

    public int hashCode() {
        if (isZero()) {
            return 0;
        }
        return this.numerator.hashCode() + this.denominator.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BigRational) {
            BigRational bigRational = (BigRational) obj;
            if (this.numerator.equals(bigRational.numerator)) {
                return this.denominator.equals(bigRational.denominator);
            }
            return false;
        }
        return false;
    }

    public String toString() {
        if (isZero()) {
            return "0";
        }
        if (isIntegerInternal()) {
            return this.numerator.toString();
        }
        return toBigDecimal().toString();
    }

    public String toPlainString() {
        if (isZero()) {
            return "0";
        }
        if (isIntegerInternal()) {
            return this.numerator.toPlainString();
        }
        return toBigDecimal().toPlainString();
    }

    public String toRationalString() {
        if (isZero()) {
            return "0";
        }
        if (isIntegerInternal()) {
            return this.numerator.toString();
        }
        return this.numerator + "/" + this.denominator;
    }

    public String toIntegerRationalString() {
        BigDecimal remainder = this.numerator.remainder(this.denominator);
        BigDecimal divide = this.numerator.subtract(remainder).divide(this.denominator);
        StringBuilder sb = new StringBuilder();
        if (divide.signum() != 0) {
            sb.append(divide);
        }
        if (remainder.signum() != 0) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(remainder.abs());
            sb.append('/');
            sb.append(this.denominator);
        }
        if (sb.length() == 0) {
            sb.append('0');
        }
        return sb.toString();
    }

    public static BigRational valueOf(int i) {
        if (i == 0) {
            return ZERO;
        }
        if (i == 1) {
            return ONE;
        }
        return new BigRational(i);
    }

    public static BigRational valueOf(int i, int i2) {
        return of(BigDecimal.valueOf(i), BigDecimal.valueOf(i2));
    }

    public static BigRational valueOf(int i, int i2, int i3) {
        if (i2 < 0 || i3 < 0) {
            throw new ArithmeticException("Negative value");
        }
        BigRational valueOf = valueOf(i);
        BigRational valueOf2 = valueOf(i2, i3);
        return valueOf.isPositive() ? valueOf.add(valueOf2) : valueOf.subtract(valueOf2);
    }

    public static BigRational valueOf(BigInteger bigInteger, BigInteger bigInteger2) {
        return of(new BigDecimal(bigInteger), new BigDecimal(bigInteger2));
    }

    public static BigRational valueOf(BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.ZERO) == 0) {
            return ZERO;
        }
        if (bigInteger.compareTo(BigInteger.ONE) == 0) {
            return ONE;
        }
        return valueOf(bigInteger, BigInteger.ONE);
    }

    public static BigRational valueOf(double d) {
        if (d == 0.0d) {
            return ZERO;
        }
        if (d == 1.0d) {
            return ONE;
        }
        if (Double.isInfinite(d)) {
            throw new NumberFormatException("Infinite");
        }
        if (Double.isNaN(d)) {
            throw new NumberFormatException("NaN");
        }
        return valueOf(new BigDecimal(String.valueOf(d)));
    }

    public static BigRational valueOf(BigDecimal bigDecimal) {
        if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            return ZERO;
        }
        if (bigDecimal.compareTo(BigDecimal.ONE) == 0) {
            return ONE;
        }
        int scale = bigDecimal.scale();
        if (scale == 0) {
            return new BigRational(bigDecimal, BigDecimal.ONE);
        }
        if (scale < 0) {
            return new BigRational(new BigDecimal(bigDecimal.unscaledValue()).multiply(BigDecimal.ONE.movePointLeft(bigDecimal.scale())), BigDecimal.ONE);
        }
        return new BigRational(new BigDecimal(bigDecimal.unscaledValue()), BigDecimal.ONE.movePointRight(bigDecimal.scale()));
    }

    public static BigRational valueOf(String str) {
        String[] split = str.split("/");
        BigRational valueOfSimple = valueOfSimple(split[0]);
        for (int i = 1; i < split.length; i++) {
            valueOfSimple = valueOfSimple.divide(valueOfSimple(split[i]));
        }
        return valueOfSimple;
    }

    private static BigRational valueOfSimple(String str) {
        return valueOf(new BigDecimal(str));
    }

    public static BigRational valueOf(boolean z, String str, String str2, String str3, String str4) {
        BigRational bigRational = ZERO;
        if (str3 != null && str3.length() > 0) {
            bigRational = valueOf(new BigInteger(str3), BigInteger.TEN.pow(str3.length()).subtract(BigInteger.ONE));
        }
        if (str2 != null && str2.length() > 0) {
            bigRational = bigRational.add(valueOf(new BigInteger(str2))).divide(BigInteger.TEN.pow(str2.length()));
        }
        if (str != null && str.length() > 0) {
            bigRational = bigRational.add(new BigInteger(str));
        }
        if (str4 != null && str4.length() > 0) {
            int parseInt = Integer.parseInt(str4);
            BigInteger pow = BigInteger.TEN.pow(Math.abs(parseInt));
            bigRational = parseInt >= 0 ? bigRational.multiply(pow) : bigRational.divide(pow);
        }
        return !z ? bigRational.negate() : bigRational;
    }

    public static BigRational valueOf(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return valueOf(bigDecimal).divide(valueOf(bigDecimal2));
    }

    private static BigRational of(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        if (bigDecimal.signum() == 0 && bigDecimal2.signum() != 0) {
            return ZERO;
        }
        if (bigDecimal.compareTo(BigDecimal.ONE) == 0 && bigDecimal2.compareTo(BigDecimal.ONE) == 0) {
            return ONE;
        }
        return new BigRational(bigDecimal, bigDecimal2);
    }

    public static BigRational min(BigRational... bigRationalArr) {
        if (bigRationalArr.length == 0) {
            return ZERO;
        }
        BigRational bigRational = bigRationalArr[0];
        for (int i = 1; i < bigRationalArr.length; i++) {
            bigRational = bigRational.min(bigRationalArr[i]);
        }
        return bigRational;
    }

    public static BigRational max(BigRational... bigRationalArr) {
        if (bigRationalArr.length == 0) {
            return ZERO;
        }
        BigRational bigRational = bigRationalArr[0];
        for (int i = 1; i < bigRationalArr.length; i++) {
            bigRational = bigRational.max(bigRationalArr[i]);
        }
        return bigRational;
    }

    public static BigRational bernoulli(int i) {
        BigRational bigRational;
        if (i < 0) {
            throw new ArithmeticException("Illegal bernoulli(n) for n < 0: n = " + i);
        } else if (i == 1) {
            return valueOf(-1, 2);
        } else {
            if (i % 2 == 1) {
                return ZERO;
            }
            synchronized (bernoulliCache) {
                int i2 = i / 2;
                if (bernoulliCache.size() <= i2) {
                    for (int size = bernoulliCache.size(); size <= i2; size++) {
                        bernoulliCache.add(calculateBernoulli(size * 2));
                    }
                }
                bigRational = bernoulliCache.get(i2);
            }
            return bigRational;
        }
    }

    private static BigRational calculateBernoulli(final int i) {
        return (BigRational) IntStream.rangeClosed(0, i).parallel().mapToObj(new IntFunction() { // from class: ch.obermuhlner.math.big.-$$Lambda$BigRational$AE5s5iKrLQryS6xcTYR32C2UQ54
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return BigRational.lambda$calculateBernoulli$0(i, i2);
            }
        }).reduce(ZERO, new BinaryOperator() { // from class: ch.obermuhlner.math.big.-$$Lambda$0L5IoAcsX6zpw7Jryk7g8l4e-PM
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((BigRational) obj).add((BigRational) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ BigRational lambda$calculateBernoulli$0(int i, int i2) {
        BigRational bigRational = ZERO;
        BigRational bigRational2 = ONE;
        int i3 = 0;
        while (i3 <= i2) {
            BigRational pow = valueOf(i3).pow(i);
            if (i3 % 2 == 0) {
                bigRational = bigRational.add(bigRational2.multiply(pow));
            } else {
                bigRational = bigRational.subtract(bigRational2.multiply(pow));
            }
            i3++;
            bigRational2 = bigRational2.multiply(valueOf(i2 - i3).divide(valueOf(i3)));
        }
        return bigRational.divide(valueOf(i2 + 1));
    }
}
