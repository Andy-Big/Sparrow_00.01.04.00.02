package ch.obermuhlner.math.big;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
/* loaded from: classes.dex */
public class DefaultBigDecimalMath {
    private static MathContext defaultMathContext = createDefaultMathContext();
    private static ThreadLocal<Deque<MathContext>> mathContextStack = new ThreadLocal<>();

    static /* synthetic */ MathContext access$100() {
        return popMathContext();
    }

    private static MathContext createDefaultMathContext() {
        return new MathContext(getIntSystemProperty("ch.obermuhlner.math.big.default.precision", MathContext.DECIMAL128.getPrecision()), getRoundingModeSystemProperty("ch.obermuhlner.math.big.default.rounding", MathContext.DECIMAL128.getRoundingMode()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pushMathContext(MathContext mathContext) {
        Deque<MathContext> deque = mathContextStack.get();
        if (deque == null) {
            deque = new ArrayDeque<>();
            mathContextStack.set(deque);
        }
        deque.addLast(mathContext);
    }

    private static MathContext popMathContext() {
        Deque<MathContext> deque = mathContextStack.get();
        MathContext removeLast = deque.removeLast();
        if (deque.isEmpty()) {
            mathContextStack.remove();
        }
        return removeLast;
    }

    private static int getIntSystemProperty(String str, int i) {
        String property = System.getProperty(str, Integer.toString(i));
        try {
            return Integer.parseInt(property);
        } catch (NumberFormatException unused) {
            return ((Integer) propertyException(str, property, Integer.valueOf(i))).intValue();
        }
    }

    private static RoundingMode getRoundingModeSystemProperty(String str, RoundingMode roundingMode) {
        String property = System.getProperty(str, roundingMode.name());
        try {
            return RoundingMode.valueOf(property);
        } catch (IllegalArgumentException unused) {
            return (RoundingMode) propertyException(str, property, roundingMode);
        }
    }

    private static <T> T propertyException(String str, String str2, T t) {
        PrintStream printStream = System.err;
        printStream.println("Property '" + str + "' is not valid: " + str2 + " (using " + t + " instead)");
        return t;
    }

    public static void setDefaultMathContext(MathContext mathContext) {
        Objects.requireNonNull(mathContext);
        defaultMathContext = mathContext;
    }

    public static MathContext getDefaultMathContext() {
        return defaultMathContext;
    }

    public static void withLocalMathContext(int i, Runnable runnable) {
        withLocalMathContext(new MathContext(i), runnable);
    }

    public static void withLocalMathContext(int i, RoundingMode roundingMode, Runnable runnable) {
        withLocalMathContext(new MathContext(i, roundingMode), runnable);
    }

    public static void withLocalMathContext(MathContext mathContext, Runnable runnable) {
        LocalMathContext createLocalMathContext = createLocalMathContext(mathContext);
        try {
            runnable.run();
            if (createLocalMathContext != null) {
                createLocalMathContext.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (createLocalMathContext != null) {
                    try {
                        createLocalMathContext.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static LocalMathContext createLocalMathContext(int i) {
        return createLocalMathContext(new MathContext(i));
    }

    public static LocalMathContext createLocalMathContext(int i, RoundingMode roundingMode) {
        return createLocalMathContext(new MathContext(i, roundingMode));
    }

    public static LocalMathContext createLocalMathContext(MathContext mathContext) {
        return new LocalMathContext(mathContext);
    }

    public static MathContext currentMathContext() {
        Deque<MathContext> deque = mathContextStack.get();
        if (deque == null || deque.isEmpty()) {
            return defaultMathContext;
        }
        return deque.getLast();
    }

    public static BigDecimal round(BigDecimal bigDecimal) {
        return BigDecimalMath.round(bigDecimal, defaultMathContext);
    }

    public static BigDecimal roundWithTrailingZeroes(BigDecimal bigDecimal) {
        return BigDecimalMath.roundWithTrailingZeroes(bigDecimal, currentMathContext());
    }

    public static BigDecimal add(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal.add(bigDecimal2, currentMathContext());
    }

    public static BigDecimal subtract(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal.subtract(bigDecimal2, currentMathContext());
    }

    public static BigDecimal multiply(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal.multiply(bigDecimal2, currentMathContext());
    }

    public static BigDecimal divide(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal.divide(bigDecimal2, currentMathContext());
    }

    public static BigDecimal remainder(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal.remainder(bigDecimal2, currentMathContext());
    }

    public static BigDecimal reciprocal(BigDecimal bigDecimal) {
        return BigDecimalMath.reciprocal(bigDecimal, currentMathContext());
    }

    public static BigDecimal factorial(BigDecimal bigDecimal) {
        return BigDecimalMath.factorial(bigDecimal, currentMathContext());
    }

    public static BigDecimal gamma(BigDecimal bigDecimal) {
        return BigDecimalMath.gamma(bigDecimal, currentMathContext());
    }

    public static BigDecimal bernoulli(int i) {
        return BigDecimalMath.bernoulli(i, currentMathContext());
    }

    public static BigDecimal pow(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return BigDecimalMath.pow(bigDecimal, bigDecimal2, currentMathContext());
    }

    public static BigDecimal pow(BigDecimal bigDecimal, long j) {
        return BigDecimalMath.pow(bigDecimal, j, currentMathContext());
    }

    public static BigDecimal sqrt(BigDecimal bigDecimal) {
        return BigDecimalMath.sqrt(bigDecimal, currentMathContext());
    }

    public static BigDecimal root(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return BigDecimalMath.root(bigDecimal, bigDecimal2, currentMathContext());
    }

    public static BigDecimal log(BigDecimal bigDecimal) {
        return BigDecimalMath.log(bigDecimal, currentMathContext());
    }

    public static BigDecimal log2(BigDecimal bigDecimal) {
        return BigDecimalMath.log2(bigDecimal, currentMathContext());
    }

    public static BigDecimal log10(BigDecimal bigDecimal) {
        return BigDecimalMath.log10(bigDecimal, currentMathContext());
    }

    public static BigDecimal pi() {
        return BigDecimalMath.pi(currentMathContext());
    }

    public static BigDecimal e() {
        return BigDecimalMath.e(currentMathContext());
    }

    public static BigDecimal exp(BigDecimal bigDecimal) {
        return BigDecimalMath.exp(bigDecimal, currentMathContext());
    }

    public static BigDecimal sin(BigDecimal bigDecimal) {
        return BigDecimalMath.sin(bigDecimal, currentMathContext());
    }

    public static BigDecimal asin(BigDecimal bigDecimal) {
        return BigDecimalMath.asin(bigDecimal, currentMathContext());
    }

    public static BigDecimal cos(BigDecimal bigDecimal) {
        return BigDecimalMath.cos(bigDecimal, currentMathContext());
    }

    public static BigDecimal acos(BigDecimal bigDecimal) {
        return BigDecimalMath.acos(bigDecimal, currentMathContext());
    }

    public static BigDecimal tan(BigDecimal bigDecimal) {
        return BigDecimalMath.tan(bigDecimal, currentMathContext());
    }

    public static BigDecimal atan(BigDecimal bigDecimal) {
        return BigDecimalMath.atan(bigDecimal, currentMathContext());
    }

    public static BigDecimal atan2(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return BigDecimalMath.atan2(bigDecimal, bigDecimal2, currentMathContext());
    }

    public static BigDecimal cot(BigDecimal bigDecimal) {
        return BigDecimalMath.cot(bigDecimal, currentMathContext());
    }

    public static BigDecimal acot(BigDecimal bigDecimal) {
        return BigDecimalMath.acot(bigDecimal, currentMathContext());
    }

    public static BigDecimal sinh(BigDecimal bigDecimal) {
        return BigDecimalMath.sinh(bigDecimal, currentMathContext());
    }

    public static BigDecimal cosh(BigDecimal bigDecimal) {
        return BigDecimalMath.cosh(bigDecimal, currentMathContext());
    }

    public static BigDecimal tanh(BigDecimal bigDecimal) {
        return BigDecimalMath.tanh(bigDecimal, currentMathContext());
    }

    public static BigDecimal coth(BigDecimal bigDecimal) {
        return BigDecimalMath.coth(bigDecimal, currentMathContext());
    }

    public static BigDecimal asinh(BigDecimal bigDecimal) {
        return BigDecimalMath.asinh(bigDecimal, currentMathContext());
    }

    public static BigDecimal acosh(BigDecimal bigDecimal) {
        return BigDecimalMath.acosh(bigDecimal, currentMathContext());
    }

    public static BigDecimal atanh(BigDecimal bigDecimal) {
        return BigDecimalMath.atanh(bigDecimal, currentMathContext());
    }

    public static BigDecimal acoth(BigDecimal bigDecimal) {
        return BigDecimalMath.acoth(bigDecimal, currentMathContext());
    }

    /* loaded from: classes.dex */
    public static class LocalMathContext implements AutoCloseable {
        public final MathContext mathContext;

        LocalMathContext(MathContext mathContext) {
            this.mathContext = mathContext;
            DefaultBigDecimalMath.pushMathContext(mathContext);
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            DefaultBigDecimalMath.access$100();
        }
    }
}
