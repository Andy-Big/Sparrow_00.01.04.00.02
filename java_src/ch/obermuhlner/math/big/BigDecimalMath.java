package ch.obermuhlner.math.big;

import ch.obermuhlner.math.big.internal.AsinCalculator;
import ch.obermuhlner.math.big.internal.CosCalculator;
import ch.obermuhlner.math.big.internal.CoshCalculator;
import ch.obermuhlner.math.big.internal.ExpCalculator;
import ch.obermuhlner.math.big.internal.SinCalculator;
import ch.obermuhlner.math.big.internal.SinhCalculator;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import kotlin.jvm.internal.LongCompanionObject;
/* loaded from: classes.dex */
public class BigDecimalMath {
    private static final int EXPECTED_INITIAL_PRECISION = 15;
    private static volatile BigDecimal eCache;
    private static volatile BigDecimal log10Cache;
    private static volatile BigDecimal log2Cache;
    private static volatile BigDecimal log3Cache;
    private static volatile BigDecimal piCache;
    private static final Map<Integer, List<BigDecimal>> spougeFactorialConstantsCache;
    private static final Object spougeFactorialConstantsCacheLock;
    private static final BigDecimal TWO = BigDecimal.valueOf(2L);
    private static final BigDecimal THREE = BigDecimal.valueOf(3L);
    private static final BigDecimal MINUS_ONE = BigDecimal.valueOf(-1L);
    private static final BigDecimal ONE_HALF = BigDecimal.valueOf(0.5d);
    private static final BigDecimal DOUBLE_MAX_VALUE = BigDecimal.valueOf(Double.MAX_VALUE);
    private static final Object log2CacheLock = new Object();
    private static final Object log3CacheLock = new Object();
    private static final Object log10CacheLock = new Object();
    private static final Object piCacheLock = new Object();
    private static final Object eCacheLock = new Object();
    private static final BigDecimal ROUGHLY_TWO_PI = new BigDecimal("3.141592653589793").multiply(TWO);
    private static BigDecimal[] factorialCache = new BigDecimal[100];

    static {
        BigDecimal bigDecimal = BigDecimal.ONE;
        factorialCache[0] = bigDecimal;
        for (int i = 1; i < factorialCache.length; i++) {
            bigDecimal = bigDecimal.multiply(BigDecimal.valueOf(i));
            factorialCache[i] = bigDecimal;
        }
        spougeFactorialConstantsCache = new HashMap();
        spougeFactorialConstantsCacheLock = new Object();
    }

    private BigDecimalMath() {
    }

    public static BigDecimal toBigDecimal(String str) {
        return toBigDecimal(str, MathContext.UNLIMITED);
    }

    public static BigDecimal toBigDecimal(String str, MathContext mathContext) {
        int length = str.length();
        if (length < 600) {
            return new BigDecimal(str, mathContext);
        }
        return toBigDecimal(str, mathContext, length / (length >= 10000 ? 8 : 5));
    }

    static BigDecimal toBigDecimal(String str, MathContext mathContext, int i) {
        int i2;
        int i3;
        BigDecimal bigDecimalRecursive;
        int length = str.length();
        if (length < i) {
            return new BigDecimal(str, mathContext);
        }
        char[] charArray = str.toCharArray();
        int i4 = -1;
        int i5 = 0;
        int i6 = -1;
        boolean z = false;
        boolean z2 = false;
        int i7 = 0;
        boolean z3 = false;
        for (int i8 = 0; i8 < length; i8++) {
            char c = charArray[i8];
            if (c != '+') {
                if (c == 'E' || c == 'e') {
                    if (i4 >= 0) {
                        throw new NumberFormatException("Multiple exponent markers");
                    }
                    i4 = i8;
                } else if (c != '-') {
                    if (c != '.') {
                        if (i6 >= 0 && i4 == -1) {
                            i5++;
                        }
                    } else if (i6 >= 0) {
                        throw new NumberFormatException("Multiple decimal points");
                    } else {
                        i6 = i8;
                    }
                } else if (i4 >= 0) {
                    if (z2) {
                        throw new NumberFormatException("Multiple signs in exponent");
                    }
                    z2 = true;
                } else if (z) {
                    throw new NumberFormatException("Multiple signs in number");
                } else {
                    i7 = i8 + 1;
                    z = true;
                    z3 = true;
                }
            } else if (i4 >= 0) {
                if (z2) {
                    throw new NumberFormatException("Multiple signs in exponent");
                }
                z2 = true;
            } else if (z) {
                throw new NumberFormatException("Multiple signs in number");
            } else {
                i7 = i8 + 1;
                z = true;
            }
        }
        if (i4 >= 0) {
            i2 = 1;
            i3 = Integer.parseInt(new String(charArray, i4 + 1, (length - i4) - 1));
            i5 = adjustScale(i5, i3);
            length = i4;
        } else {
            i2 = 1;
            i3 = 0;
        }
        if (i6 >= 0) {
            int i9 = (length - i6) - i2;
            bigDecimalRecursive = toBigDecimalRecursive(charArray, i7, i6 - i7, i3, i).add(toBigDecimalRecursive(charArray, i6 + i2, i9, i3 - i9, i));
        } else {
            bigDecimalRecursive = toBigDecimalRecursive(charArray, i7, length - i7, i3, i);
        }
        if (i5 != 0) {
            bigDecimalRecursive = bigDecimalRecursive.setScale(i5);
        }
        if (z3) {
            bigDecimalRecursive = bigDecimalRecursive.negate();
        }
        return mathContext.getPrecision() != 0 ? bigDecimalRecursive.round(mathContext) : bigDecimalRecursive;
    }

    private static int adjustScale(int i, long j) {
        long j2 = i - j;
        if (j2 > 2147483647L || j2 < -2147483648L) {
            throw new NumberFormatException("Scale out of range: " + j2 + " while adjusting scale " + i + " to exponent " + j);
        }
        return (int) j2;
    }

    private static BigDecimal toBigDecimalRecursive(char[] cArr, int i, int i2, int i3, int i4) {
        if (i2 > i4) {
            int i5 = i2 / 2;
            return toBigDecimalRecursive(cArr, i, i5, (i3 + i2) - i5, i4).add(toBigDecimalRecursive(cArr, i + i5, i2 - i5, i3, i4));
        } else if (i2 == 0) {
            return BigDecimal.ZERO;
        } else {
            return new BigDecimal(cArr, i, i2).movePointRight(i3);
        }
    }

    public static boolean isIntValue(BigDecimal bigDecimal) {
        try {
            bigDecimal.intValueExact();
            return true;
        } catch (ArithmeticException unused) {
            return false;
        }
    }

    public static boolean isLongValue(BigDecimal bigDecimal) {
        try {
            bigDecimal.longValueExact();
            return true;
        } catch (ArithmeticException unused) {
            return false;
        }
    }

    public static boolean isDoubleValue(BigDecimal bigDecimal) {
        return bigDecimal.compareTo(DOUBLE_MAX_VALUE) <= 0 && bigDecimal.compareTo(DOUBLE_MAX_VALUE.negate()) >= 0;
    }

    public static BigDecimal mantissa(BigDecimal bigDecimal) {
        int exponent = exponent(bigDecimal);
        return exponent == 0 ? bigDecimal : bigDecimal.movePointLeft(exponent);
    }

    public static int exponent(BigDecimal bigDecimal) {
        return (bigDecimal.precision() - bigDecimal.scale()) - 1;
    }

    public static int significantDigits(BigDecimal bigDecimal) {
        BigDecimal stripTrailingZeros = bigDecimal.stripTrailingZeros();
        if (stripTrailingZeros.scale() >= 0) {
            return stripTrailingZeros.precision();
        }
        return stripTrailingZeros.precision() - stripTrailingZeros.scale();
    }

    public static BigDecimal integralPart(BigDecimal bigDecimal) {
        return bigDecimal.setScale(0, 1);
    }

    public static BigDecimal fractionalPart(BigDecimal bigDecimal) {
        return bigDecimal.subtract(integralPart(bigDecimal));
    }

    public static BigDecimal round(BigDecimal bigDecimal, MathContext mathContext) {
        return bigDecimal.round(mathContext);
    }

    public static BigDecimal roundWithTrailingZeroes(BigDecimal bigDecimal, MathContext mathContext) {
        BigDecimal scale;
        if (bigDecimal.precision() == mathContext.getPrecision()) {
            return bigDecimal;
        }
        if (bigDecimal.signum() == 0) {
            return BigDecimal.ZERO.setScale(mathContext.getPrecision() - 1);
        }
        try {
            BigDecimal stripTrailingZeros = bigDecimal.stripTrailingZeros();
            int exponent = exponent(stripTrailingZeros);
            if (exponent < -1) {
                scale = BigDecimal.ZERO.setScale(mathContext.getPrecision() - exponent);
            } else {
                scale = BigDecimal.ZERO.setScale(mathContext.getPrecision() + exponent + 1);
            }
            return stripTrailingZeros.add(scale, mathContext);
        } catch (ArithmeticException unused) {
            return bigDecimal.round(mathContext);
        }
    }

    public static BigDecimal reciprocal(BigDecimal bigDecimal, MathContext mathContext) {
        return BigDecimal.ONE.divide(bigDecimal, mathContext);
    }

    public static BigDecimal factorial(int i) {
        if (i < 0) {
            throw new ArithmeticException("Illegal factorial(n) for n < 0: n = " + i);
        }
        BigDecimal[] bigDecimalArr = factorialCache;
        if (i < bigDecimalArr.length) {
            return bigDecimalArr[i];
        }
        return bigDecimalArr[bigDecimalArr.length - 1].multiply(factorialRecursion(bigDecimalArr.length, i));
    }

    private static BigDecimal factorialLoop(int i, int i2) {
        long j = LongCompanionObject.MAX_VALUE / i2;
        BigDecimal bigDecimal = BigDecimal.ONE;
        long j2 = 1;
        while (i <= i2) {
            if (j2 <= j) {
                j2 *= i;
            } else {
                bigDecimal = bigDecimal.multiply(BigDecimal.valueOf(j2));
                j2 = i;
            }
            i++;
        }
        return bigDecimal.multiply(BigDecimal.valueOf(j2));
    }

    private static BigDecimal factorialRecursion(int i, int i2) {
        if (i2 - i < (i > 200 ? 80 : 150)) {
            return factorialLoop(i, i2);
        }
        int i3 = (i + i2) >> 1;
        return factorialRecursion(i3 + 1, i2).multiply(factorialRecursion(i, i3));
    }

    public static BigDecimal factorial(BigDecimal bigDecimal, MathContext mathContext) {
        if (isIntValue(bigDecimal)) {
            return round(factorial(bigDecimal.intValueExact()), mathContext);
        }
        checkMathContext(mathContext);
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() << 1, mathContext.getRoundingMode());
        int precision = (mathContext.getPrecision() * 13) / 10;
        List<BigDecimal> spougeFactorialConstants = getSpougeFactorialConstants(precision);
        BigDecimal valueOf = BigDecimal.valueOf(precision);
        BigDecimal bigDecimal2 = spougeFactorialConstants.get(0);
        for (int i = 1; i < precision; i++) {
            bigDecimal2 = bigDecimal2.add(spougeFactorialConstants.get(i).divide(bigDecimal.add(BigDecimal.valueOf(i)), mathContext2));
        }
        return round(pow(bigDecimal.add(valueOf), bigDecimal.add(BigDecimal.valueOf(0.5d)), mathContext2).multiply(exp(bigDecimal.negate().subtract(valueOf), mathContext2)).multiply(bigDecimal2), mathContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<BigDecimal> getSpougeFactorialConstants(final int i) {
        List<BigDecimal> computeIfAbsent;
        synchronized (spougeFactorialConstantsCacheLock) {
            computeIfAbsent = spougeFactorialConstantsCache.computeIfAbsent(Integer.valueOf(i), new Function() { // from class: ch.obermuhlner.math.big.-$$Lambda$BigDecimalMath$vZx39_0DDeETKJPrkY5hQCVMiqo
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return BigDecimalMath.lambda$getSpougeFactorialConstants$0(i, (Integer) obj);
                }
            });
        }
        return computeIfAbsent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List lambda$getSpougeFactorialConstants$0(int i, Integer num) {
        ArrayList arrayList = new ArrayList(i);
        MathContext mathContext = new MathContext((i * 15) / 10);
        arrayList.add(sqrt(pi(mathContext).multiply(TWO, mathContext), mathContext));
        boolean z = false;
        for (int i2 = 1; i2 < i; i2++) {
            long j = i2;
            long j2 = i - j;
            BigDecimal divide = pow(BigDecimal.valueOf(j2), BigDecimal.valueOf(j).subtract(ONE_HALF), mathContext).multiply(exp(BigDecimal.valueOf(j2), mathContext), mathContext).divide(factorial(i2 - 1), mathContext);
            if (z) {
                divide = divide.negate();
            }
            arrayList.add(divide);
            z = !z;
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static BigDecimal gamma(BigDecimal bigDecimal, MathContext mathContext) {
        return factorial(bigDecimal.subtract(BigDecimal.ONE), mathContext);
    }

    public static BigDecimal bernoulli(int i, MathContext mathContext) {
        if (i < 0) {
            throw new ArithmeticException("Illegal bernoulli(n) for n < 0: n = " + i);
        }
        return BigRational.bernoulli(i).toBigDecimal(mathContext);
    }

    public static BigDecimal pow(BigDecimal bigDecimal, BigDecimal bigDecimal2, MathContext mathContext) {
        checkMathContext(mathContext);
        if (bigDecimal.signum() == 0) {
            int signum = bigDecimal2.signum();
            if (signum == 0) {
                return round(BigDecimal.ONE, mathContext);
            }
            if (signum == 1) {
                return round(BigDecimal.ZERO, mathContext);
            }
        }
        try {
            return pow(bigDecimal, bigDecimal2.longValueExact(), mathContext);
        } catch (ArithmeticException unused) {
            if (fractionalPart(bigDecimal2).signum() == 0) {
                return powInteger(bigDecimal, bigDecimal2, mathContext);
            }
            MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 6, mathContext.getRoundingMode());
            return round(exp(bigDecimal2.multiply(log(bigDecimal, mathContext2), mathContext2), mathContext2), mathContext);
        }
    }

    public static BigDecimal pow(BigDecimal bigDecimal, long j, MathContext mathContext) {
        MathContext mathContext2 = mathContext.getPrecision() == 0 ? mathContext : new MathContext(mathContext.getPrecision() + 10, mathContext.getRoundingMode());
        if (j < 0) {
            return round(reciprocal(pow(bigDecimal, -j, mathContext2), mathContext2), mathContext);
        }
        BigDecimal bigDecimal2 = BigDecimal.ONE;
        while (j > 0) {
            if ((j & 1) == 1) {
                bigDecimal2 = bigDecimal2.multiply(bigDecimal, mathContext2);
                j--;
            }
            if (j > 0) {
                bigDecimal = bigDecimal.multiply(bigDecimal, mathContext2);
            }
            j >>= 1;
        }
        return round(bigDecimal2, mathContext);
    }

    private static BigDecimal powInteger(BigDecimal bigDecimal, BigDecimal bigDecimal2, MathContext mathContext) {
        if (fractionalPart(bigDecimal2).signum() != 0) {
            throw new IllegalArgumentException("Not integer value: " + bigDecimal2);
        } else if (bigDecimal2.signum() < 0) {
            return BigDecimal.ONE.divide(powInteger(bigDecimal, bigDecimal2.negate(), mathContext), mathContext);
        } else {
            MathContext mathContext2 = new MathContext(Math.max(mathContext.getPrecision(), -bigDecimal2.scale()) + 30, mathContext.getRoundingMode());
            BigDecimal bigDecimal3 = BigDecimal.ONE;
            while (bigDecimal2.signum() > 0) {
                BigDecimal divide = bigDecimal2.divide(TWO, mathContext2);
                if (fractionalPart(divide).signum() != 0) {
                    bigDecimal3 = bigDecimal3.multiply(bigDecimal, mathContext2);
                    bigDecimal2 = bigDecimal2.subtract(BigDecimal.ONE).divide(TWO, mathContext2);
                } else {
                    bigDecimal2 = divide;
                }
                if (bigDecimal2.signum() > 0) {
                    bigDecimal = bigDecimal.multiply(bigDecimal, mathContext2);
                }
            }
            return round(bigDecimal3, mathContext);
        }
    }

    public static BigDecimal sqrt(BigDecimal bigDecimal, MathContext mathContext) {
        BigDecimal multiply;
        int i;
        BigDecimal multiply2;
        checkMathContext(mathContext);
        int signum = bigDecimal.signum();
        if (signum == -1) {
            throw new ArithmeticException("Illegal sqrt(x) for x < 0: x = " + bigDecimal);
        } else if (signum == 0) {
            return BigDecimal.ZERO;
        } else {
            int precision = mathContext.getPrecision() + 6;
            BigDecimal movePointLeft = BigDecimal.ONE.movePointLeft(mathContext.getPrecision() + 1);
            if (isDoubleValue(bigDecimal)) {
                multiply = BigDecimal.valueOf(Math.sqrt(bigDecimal.doubleValue()));
                i = 15;
            } else {
                multiply = bigDecimal.multiply(ONE_HALF, mathContext);
                i = 1;
            }
            if (i < precision) {
                if (multiply.multiply(multiply).compareTo(bigDecimal) == 0) {
                    return round(multiply, mathContext);
                }
                while (true) {
                    i <<= 1;
                    if (i > precision) {
                        i = precision;
                    }
                    MathContext mathContext2 = new MathContext(i, mathContext.getRoundingMode());
                    multiply2 = bigDecimal.divide(multiply, mathContext2).add(multiply).multiply(ONE_HALF, mathContext2);
                    if (i >= precision && multiply2.subtract(multiply).abs().compareTo(movePointLeft) <= 0) {
                        break;
                    }
                    multiply = multiply2;
                }
                multiply = multiply2;
            }
            return round(multiply, mathContext);
        }
    }

    public static BigDecimal root(BigDecimal bigDecimal, BigDecimal bigDecimal2, MathContext mathContext) {
        checkMathContext(mathContext);
        int signum = bigDecimal.signum();
        if (signum == -1) {
            throw new ArithmeticException("Illegal root(x) for x < 0: x = " + bigDecimal);
        } else if (signum == 0) {
            return BigDecimal.ZERO;
        } else {
            if (bigDecimal2.compareTo(BigDecimal.ONE) <= 0) {
                return pow(bigDecimal, BigDecimal.ONE.divide(bigDecimal2, new MathContext(mathContext.getPrecision() + 6, mathContext.getRoundingMode())), mathContext);
            }
            int precision = mathContext.getPrecision() + 4;
            BigDecimal movePointLeft = BigDecimal.ONE.movePointLeft(mathContext.getPrecision() + 1);
            BigDecimal subtract = bigDecimal2.subtract(BigDecimal.ONE);
            BigDecimal divide = bigDecimal.divide(TWO, MathContext.DECIMAL32);
            int i = 2;
            while (true) {
                i *= 3;
                if (i > precision) {
                    i = precision;
                }
                MathContext mathContext2 = new MathContext(i, mathContext.getRoundingMode());
                BigDecimal divide2 = bigDecimal.divide(pow(divide, subtract, mathContext2), mathContext2).subtract(divide).divide(bigDecimal2, mathContext2);
                divide = divide.add(divide2);
                if (i >= precision && divide2.abs().compareTo(movePointLeft) <= 0) {
                    return round(divide, mathContext);
                }
            }
        }
    }

    public static BigDecimal log(BigDecimal bigDecimal, MathContext mathContext) {
        BigDecimal logTen;
        checkMathContext(mathContext);
        if (bigDecimal.signum() <= 0) {
            throw new ArithmeticException("Illegal log(x) for x <= 0: x = " + bigDecimal);
        } else if (bigDecimal.compareTo(BigDecimal.ONE) == 0) {
            return BigDecimal.ZERO;
        } else {
            int compareTo = bigDecimal.compareTo(BigDecimal.TEN);
            if (compareTo == 0) {
                logTen = logTen(mathContext);
            } else if (compareTo == 1) {
                logTen = logUsingExponent(bigDecimal, mathContext);
            } else {
                logTen = logUsingTwoThree(bigDecimal, mathContext);
            }
            return round(logTen, mathContext);
        }
    }

    public static BigDecimal log2(BigDecimal bigDecimal, MathContext mathContext) {
        checkMathContext(mathContext);
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode());
        return round(log(bigDecimal, mathContext2).divide(logTwo(mathContext2), mathContext2), mathContext);
    }

    public static BigDecimal log10(BigDecimal bigDecimal, MathContext mathContext) {
        checkMathContext(mathContext);
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 2, mathContext.getRoundingMode());
        return round(log(bigDecimal, mathContext2).divide(logTen(mathContext2), mathContext2), mathContext);
    }

    private static BigDecimal logUsingNewton(BigDecimal bigDecimal, MathContext mathContext) {
        BigDecimal divide;
        int precision = mathContext.getPrecision() + 20;
        int i = 1;
        BigDecimal movePointLeft = BigDecimal.ONE.movePointLeft(mathContext.getPrecision() + 1);
        double doubleValue = bigDecimal.doubleValue();
        if (doubleValue > 0.0d && isDoubleValue(bigDecimal)) {
            divide = BigDecimal.valueOf(Math.log(doubleValue));
            i = 15;
        } else {
            divide = bigDecimal.divide(TWO, mathContext);
        }
        while (true) {
            i *= 3;
            if (i > precision) {
                i = precision;
            }
            MathContext mathContext2 = new MathContext(i, mathContext.getRoundingMode());
            BigDecimal exp = exp(divide, mathContext2);
            BigDecimal divide2 = TWO.multiply(bigDecimal.subtract(exp)).divide(bigDecimal.add(exp), mathContext2);
            divide = divide.add(divide2);
            if (i >= precision && divide2.abs().compareTo(movePointLeft) <= 0) {
                return divide;
            }
        }
    }

    private static BigDecimal logUsingExponent(BigDecimal bigDecimal, MathContext mathContext) {
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() << 1, mathContext.getRoundingMode());
        MathContext mathContext3 = new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode());
        int exponent = exponent(bigDecimal);
        BigDecimal logUsingTwoThree = logUsingTwoThree(mantissa(bigDecimal), mathContext3);
        return exponent != 0 ? logUsingTwoThree.add(BigDecimal.valueOf(exponent).multiply(logTen(mathContext2), mathContext3)) : logUsingTwoThree;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.math.BigDecimal logUsingTwoThree(java.math.BigDecimal r22, java.math.MathContext r23) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.obermuhlner.math.big.BigDecimalMath.logUsingTwoThree(java.math.BigDecimal, java.math.MathContext):java.math.BigDecimal");
    }

    public static BigDecimal pi(MathContext mathContext) {
        checkMathContext(mathContext);
        synchronized (piCacheLock) {
            if (piCache != null && mathContext.getPrecision() <= piCache.precision()) {
                return round(piCache, mathContext);
            }
            piCache = piChudnovski(mathContext);
            return piCache;
        }
    }

    private static BigDecimal piChudnovski(MathContext mathContext) {
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 10, mathContext.getRoundingMode());
        BigDecimal valueOf = BigDecimal.valueOf(24L);
        BigDecimal valueOf2 = BigDecimal.valueOf(640320L);
        BigDecimal valueOf3 = BigDecimal.valueOf(13591409L);
        BigDecimal valueOf4 = BigDecimal.valueOf(545140134L);
        BigDecimal divide = valueOf2.pow(3).divide(valueOf, mathContext2);
        BigDecimal bigDecimal = BigDecimal.ONE;
        BigDecimal bigDecimal2 = BigDecimal.ZERO;
        BigDecimal bigDecimal3 = BigDecimal.ONE;
        BigDecimal bigDecimal4 = BigDecimal.ZERO;
        long j = -1;
        long j2 = 5;
        long j3 = 1;
        long j4 = -1;
        for (long precision = (mathContext2.getPrecision() + 13) / 14; j3 <= precision; precision = precision) {
            BigDecimal valueOf5 = BigDecimal.valueOf(j3);
            j2 -= 6;
            j += 2;
            j4 += 6;
            bigDecimal3 = bigDecimal3.multiply(BigDecimal.valueOf(j2).multiply(BigDecimal.valueOf(j)).multiply(BigDecimal.valueOf(j4))).divide(valueOf5.pow(3).multiply(divide, mathContext2), mathContext2);
            BigDecimal multiply = valueOf5.multiply(bigDecimal3, mathContext2);
            bigDecimal = bigDecimal.add(bigDecimal3);
            bigDecimal2 = bigDecimal2.add(multiply);
            j3++;
        }
        return round(BigDecimal.valueOf(426880L).multiply(sqrt(BigDecimal.valueOf(10005L), mathContext2)).divide(valueOf3.multiply(bigDecimal, mathContext2).add(valueOf4.multiply(bigDecimal2, mathContext2)), mathContext2), mathContext);
    }

    public static BigDecimal e(MathContext mathContext) {
        checkMathContext(mathContext);
        synchronized (eCacheLock) {
            if (eCache != null && mathContext.getPrecision() <= eCache.precision()) {
                return round(eCache, mathContext);
            }
            eCache = exp(BigDecimal.ONE, mathContext);
            return eCache;
        }
    }

    private static BigDecimal logTen(MathContext mathContext) {
        synchronized (log10CacheLock) {
            if (log10Cache != null && mathContext.getPrecision() <= log10Cache.precision()) {
                return round(log10Cache, mathContext);
            }
            log10Cache = logUsingNewton(BigDecimal.TEN, mathContext);
            return log10Cache;
        }
    }

    private static BigDecimal logTwo(MathContext mathContext) {
        synchronized (log2CacheLock) {
            if (log2Cache != null && mathContext.getPrecision() <= log2Cache.precision()) {
                return round(log2Cache, mathContext);
            }
            log2Cache = logUsingNewton(TWO, mathContext);
            return log2Cache;
        }
    }

    private static BigDecimal logThree(MathContext mathContext) {
        synchronized (log3CacheLock) {
            if (log3Cache != null && mathContext.getPrecision() <= log3Cache.precision()) {
                return round(log3Cache, mathContext);
            }
            log3Cache = logUsingNewton(THREE, mathContext);
            return log3Cache;
        }
    }

    public static BigDecimal exp(BigDecimal bigDecimal, MathContext mathContext) {
        checkMathContext(mathContext);
        if (bigDecimal.signum() == 0) {
            return BigDecimal.ONE;
        }
        return expIntegralFractional(bigDecimal, mathContext);
    }

    private static BigDecimal expIntegralFractional(BigDecimal bigDecimal, MathContext mathContext) {
        BigDecimal integralPart = integralPart(bigDecimal);
        if (integralPart.signum() == 0) {
            return expTaylor(bigDecimal, mathContext);
        }
        BigDecimal subtract = bigDecimal.subtract(integralPart);
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 10, mathContext.getRoundingMode());
        return round(pow(expTaylor(BigDecimal.ONE.add(subtract.divide(integralPart, mathContext2)), mathContext2), integralPart.intValueExact(), mathContext2), mathContext);
    }

    private static BigDecimal expTaylor(BigDecimal bigDecimal, MathContext mathContext) {
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 6, mathContext.getRoundingMode());
        return round(pow(ExpCalculator.INSTANCE.calculate(bigDecimal.divide(BigDecimal.valueOf(256L), mathContext2), mathContext2), 256L, mathContext2), mathContext);
    }

    public static BigDecimal sin(BigDecimal bigDecimal, MathContext mathContext) {
        checkMathContext(mathContext);
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 6, mathContext.getRoundingMode());
        if (bigDecimal.abs().compareTo(ROUGHLY_TWO_PI) > 0) {
            MathContext mathContext3 = new MathContext(mathContext2.getPrecision() + 4, mathContext.getRoundingMode());
            bigDecimal = bigDecimal.remainder(TWO.multiply(pi(mathContext3)), mathContext3);
        }
        return round(SinCalculator.INSTANCE.calculate(bigDecimal, mathContext2), mathContext);
    }

    public static BigDecimal asin(BigDecimal bigDecimal, MathContext mathContext) {
        checkMathContext(mathContext);
        if (bigDecimal.compareTo(BigDecimal.ONE) > 0) {
            throw new ArithmeticException("Illegal asin(x) for x > 1: x = " + bigDecimal);
        } else if (bigDecimal.compareTo(MINUS_ONE) < 0) {
            throw new ArithmeticException("Illegal asin(x) for x < -1: x = " + bigDecimal);
        } else if (bigDecimal.signum() == -1) {
            return asin(bigDecimal.negate(), mathContext).negate();
        } else {
            MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 6, mathContext.getRoundingMode());
            if (bigDecimal.compareTo(BigDecimal.valueOf(0.707107d)) >= 0) {
                return acos(sqrt(BigDecimal.ONE.subtract(bigDecimal.multiply(bigDecimal)), mathContext2), mathContext);
            }
            return round(AsinCalculator.INSTANCE.calculate(bigDecimal, mathContext2), mathContext);
        }
    }

    public static BigDecimal cos(BigDecimal bigDecimal, MathContext mathContext) {
        checkMathContext(mathContext);
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 6, mathContext.getRoundingMode());
        if (bigDecimal.abs().compareTo(ROUGHLY_TWO_PI) > 0) {
            MathContext mathContext3 = new MathContext(mathContext2.getPrecision() + 4, mathContext.getRoundingMode());
            bigDecimal = bigDecimal.remainder(TWO.multiply(pi(mathContext3), mathContext3), mathContext3);
        }
        return round(CosCalculator.INSTANCE.calculate(bigDecimal, mathContext2), mathContext);
    }

    public static BigDecimal acos(BigDecimal bigDecimal, MathContext mathContext) {
        checkMathContext(mathContext);
        if (bigDecimal.compareTo(BigDecimal.ONE) > 0) {
            throw new ArithmeticException("Illegal acos(x) for x > 1: x = " + bigDecimal);
        } else if (bigDecimal.compareTo(MINUS_ONE) < 0) {
            throw new ArithmeticException("Illegal acos(x) for x < -1: x = " + bigDecimal);
        } else {
            MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 6, mathContext.getRoundingMode());
            return round(pi(mathContext2).divide(TWO, mathContext2).subtract(asin(bigDecimal, mathContext2)), mathContext);
        }
    }

    public static BigDecimal tan(BigDecimal bigDecimal, MathContext mathContext) {
        checkMathContext(mathContext);
        if (bigDecimal.signum() == 0) {
            return BigDecimal.ZERO;
        }
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode());
        return round(sin(bigDecimal, mathContext2).divide(cos(bigDecimal, mathContext2), mathContext2), mathContext);
    }

    public static BigDecimal atan(BigDecimal bigDecimal, MathContext mathContext) {
        checkMathContext(mathContext);
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 6, mathContext.getRoundingMode());
        return round(asin(bigDecimal.divide(sqrt(BigDecimal.ONE.add(bigDecimal.multiply(bigDecimal, mathContext2)), mathContext2), mathContext2), mathContext2), mathContext);
    }

    public static BigDecimal atan2(BigDecimal bigDecimal, BigDecimal bigDecimal2, MathContext mathContext) {
        checkMathContext(mathContext);
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 3, mathContext.getRoundingMode());
        if (bigDecimal2.signum() > 0) {
            return atan(bigDecimal.divide(bigDecimal2, mathContext2), mathContext);
        }
        if (bigDecimal2.signum() < 0) {
            if (bigDecimal.signum() > 0) {
                return atan(bigDecimal.divide(bigDecimal2, mathContext2), mathContext2).add(pi(mathContext2), mathContext);
            }
            if (bigDecimal.signum() < 0) {
                return atan(bigDecimal.divide(bigDecimal2, mathContext2), mathContext2).subtract(pi(mathContext2), mathContext);
            }
            return pi(mathContext);
        } else if (bigDecimal.signum() > 0) {
            return pi(mathContext2).divide(TWO, mathContext);
        } else {
            if (bigDecimal.signum() < 0) {
                return pi(mathContext2).divide(TWO, mathContext).negate();
            }
            throw new ArithmeticException("Illegal atan2(y, x) for x = 0; y = 0");
        }
    }

    public static BigDecimal cot(BigDecimal bigDecimal, MathContext mathContext) {
        checkMathContext(mathContext);
        if (bigDecimal.signum() == 0) {
            throw new ArithmeticException("Illegal cot(x) for x = 0");
        }
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode());
        return round(cos(bigDecimal, mathContext2).divide(sin(bigDecimal, mathContext2), mathContext2), mathContext);
    }

    public static BigDecimal acot(BigDecimal bigDecimal, MathContext mathContext) {
        checkMathContext(mathContext);
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode());
        return round(pi(mathContext2).divide(TWO, mathContext2).subtract(atan(bigDecimal, mathContext2)), mathContext);
    }

    public static BigDecimal sinh(BigDecimal bigDecimal, MathContext mathContext) {
        checkMathContext(mathContext);
        return round(SinhCalculator.INSTANCE.calculate(bigDecimal, new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode())), mathContext);
    }

    public static BigDecimal cosh(BigDecimal bigDecimal, MathContext mathContext) {
        checkMathContext(mathContext);
        return round(CoshCalculator.INSTANCE.calculate(bigDecimal, new MathContext(mathContext.getPrecision() + 4, mathContext.getRoundingMode())), mathContext);
    }

    public static BigDecimal tanh(BigDecimal bigDecimal, MathContext mathContext) {
        checkMathContext(mathContext);
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 6, mathContext.getRoundingMode());
        return round(sinh(bigDecimal, mathContext2).divide(cosh(bigDecimal, mathContext2), mathContext2), mathContext);
    }

    public static BigDecimal coth(BigDecimal bigDecimal, MathContext mathContext) {
        checkMathContext(mathContext);
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 6, mathContext.getRoundingMode());
        return round(cosh(bigDecimal, mathContext2).divide(sinh(bigDecimal, mathContext2), mathContext2), mathContext);
    }

    public static BigDecimal asinh(BigDecimal bigDecimal, MathContext mathContext) {
        checkMathContext(mathContext);
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 10, mathContext.getRoundingMode());
        return round(log(bigDecimal.add(sqrt(bigDecimal.multiply(bigDecimal, mathContext2).add(BigDecimal.ONE, mathContext2), mathContext2)), mathContext2), mathContext);
    }

    public static BigDecimal acosh(BigDecimal bigDecimal, MathContext mathContext) {
        checkMathContext(mathContext);
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 6, mathContext.getRoundingMode());
        return round(log(bigDecimal.add(sqrt(bigDecimal.multiply(bigDecimal).subtract(BigDecimal.ONE), mathContext2)), mathContext2), mathContext);
    }

    public static BigDecimal atanh(BigDecimal bigDecimal, MathContext mathContext) {
        if (bigDecimal.compareTo(BigDecimal.ONE) >= 0) {
            throw new ArithmeticException("Illegal atanh(x) for x >= 1: x = " + bigDecimal);
        } else if (bigDecimal.compareTo(MINUS_ONE) <= 0) {
            throw new ArithmeticException("Illegal atanh(x) for x <= -1: x = " + bigDecimal);
        } else {
            checkMathContext(mathContext);
            MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 6, mathContext.getRoundingMode());
            return round(log(BigDecimal.ONE.add(bigDecimal).divide(BigDecimal.ONE.subtract(bigDecimal), mathContext2), mathContext2).multiply(ONE_HALF), mathContext);
        }
    }

    public static BigDecimal acoth(BigDecimal bigDecimal, MathContext mathContext) {
        checkMathContext(mathContext);
        MathContext mathContext2 = new MathContext(mathContext.getPrecision() + 6, mathContext.getRoundingMode());
        return round(log(bigDecimal.add(BigDecimal.ONE).divide(bigDecimal.subtract(BigDecimal.ONE), mathContext2), mathContext2).multiply(ONE_HALF), mathContext);
    }

    private static void checkMathContext(MathContext mathContext) {
        if (mathContext.getPrecision() == 0) {
            throw new UnsupportedOperationException("Unlimited MathContext not supported");
        }
    }
}
