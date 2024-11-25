package ch.obermuhlner.math.big;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;
import kotlin.jvm.internal.LongCompanionObject;
/* loaded from: classes.dex */
public class BigFloat implements Comparable<BigFloat>, Serializable {
    private static final long serialVersionUID = -7323679117445486894L;
    private final Context context;
    private final BigDecimal value;
    public static final BigFloat NaN = new SpecialBigFloat(SpecialBigFloat.Type.NaN, null);
    public static final BigFloat POSITIVE_INFINITY = new SpecialBigFloat(SpecialBigFloat.Type.POSITIVE_INFINITY, null);
    public static final BigFloat NEGATIVE_INFINITY = new SpecialBigFloat(SpecialBigFloat.Type.NEGATIVE_INFINITY, null);

    protected boolean isSpecial() {
        return false;
    }

    /* synthetic */ BigFloat(BigDecimal bigDecimal, Context context, AnonymousClass1 anonymousClass1) {
        this(bigDecimal, context);
    }

    private BigFloat(BigDecimal bigDecimal, Context context) {
        this.value = bigDecimal;
        this.context = context;
    }

    public static Context context(int i) {
        return new Context(new MathContext(i), null);
    }

    public static Context context(MathContext mathContext) {
        return new Context(mathContext, null);
    }

    public BigFloat add(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            return bigFloat.add(this);
        }
        Context max = max(this.context, bigFloat.context);
        return max.valueOf(this.value.add(bigFloat.value, max.mathContext));
    }

    public BigFloat add(BigDecimal bigDecimal) {
        return add(this.context.valueOf(bigDecimal));
    }

    public BigFloat add(int i) {
        return add(this.context.valueOf(i));
    }

    public BigFloat add(long j) {
        return add(this.context.valueOf(j));
    }

    public BigFloat add(double d) {
        return add(this.context.valueOf(d));
    }

    public BigFloat subtract(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            return negate(bigFloat).add(this);
        }
        Context max = max(this.context, bigFloat.context);
        return max.valueOf(this.value.subtract(bigFloat.value, max.mathContext));
    }

    public BigFloat subtract(BigDecimal bigDecimal) {
        return subtract(this.context.valueOf(bigDecimal));
    }

    public BigFloat subtract(int i) {
        return subtract(this.context.valueOf(i));
    }

    public BigFloat subtract(long j) {
        return subtract(this.context.valueOf(j));
    }

    public BigFloat subtract(double d) {
        return subtract(this.context.valueOf(d));
    }

    public BigFloat multiply(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            return bigFloat.multiply(this);
        }
        Context max = max(this.context, bigFloat.context);
        return max.valueOf(this.value.multiply(bigFloat.value, max.mathContext));
    }

    public BigFloat multiply(BigDecimal bigDecimal) {
        return multiply(this.context.valueOf(bigDecimal));
    }

    public BigFloat multiply(int i) {
        return multiply(this.context.valueOf(i));
    }

    public BigFloat multiply(long j) {
        return multiply(this.context.valueOf(j));
    }

    public BigFloat multiply(double d) {
        return multiply(this.context.valueOf(d));
    }

    public BigFloat divide(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            BigFloat bigFloat2 = NaN;
            return bigFloat == bigFloat2 ? bigFloat2 : this.context.valueOf(0);
        } else if (isZero() && !bigFloat.isZero()) {
            return this.context.valueOf(0);
        } else {
            if (bigFloat.isZero()) {
                if (isZero()) {
                    return NaN;
                }
                if (isNegative()) {
                    return NEGATIVE_INFINITY;
                }
                return POSITIVE_INFINITY;
            }
            Context max = max(this.context, bigFloat.context);
            return max.valueOf(this.value.divide(bigFloat.value, max.mathContext));
        }
    }

    public BigFloat divide(BigDecimal bigDecimal) {
        return divide(this.context.valueOf(bigDecimal));
    }

    public BigFloat divide(int i) {
        return divide(this.context.valueOf(i));
    }

    public BigFloat divide(long j) {
        return divide(this.context.valueOf(j));
    }

    public BigFloat divide(double d) {
        return divide(this.context.valueOf(d));
    }

    public BigFloat remainder(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            BigFloat bigFloat2 = NaN;
            return bigFloat == bigFloat2 ? bigFloat2 : this;
        } else if (isZero() && !bigFloat.isZero()) {
            return this.context.valueOf(0);
        } else {
            if (bigFloat.isZero()) {
                return NaN;
            }
            Context max = max(this.context, bigFloat.context);
            return max.valueOf(this.value.remainder(bigFloat.value, max.mathContext));
        }
    }

    public BigFloat remainder(BigDecimal bigDecimal) {
        return remainder(this.context.valueOf(bigDecimal));
    }

    public BigFloat remainder(int i) {
        return remainder(this.context.valueOf(i));
    }

    public BigFloat remainder(long j) {
        return remainder(this.context.valueOf(j));
    }

    public BigFloat remainder(double d) {
        return remainder(this.context.valueOf(d));
    }

    public BigFloat pow(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            if (isZero()) {
                BigFloat bigFloat2 = POSITIVE_INFINITY;
                if (bigFloat == bigFloat2) {
                    return this;
                }
                if (bigFloat == NEGATIVE_INFINITY) {
                    return bigFloat2;
                }
            }
            return bigFloat == NEGATIVE_INFINITY ? this.context.ZERO : bigFloat;
        } else if (isZero() && bigFloat.isNegative()) {
            return POSITIVE_INFINITY;
        } else {
            Context max = max(this.context, bigFloat.context);
            return max.valueOf(BigDecimalMath.pow(this.value, bigFloat.value, max.mathContext));
        }
    }

    public BigFloat pow(BigDecimal bigDecimal) {
        return pow(this.context.valueOf(bigDecimal));
    }

    public BigFloat pow(int i) {
        return pow(this.context.valueOf(i));
    }

    public BigFloat pow(long j) {
        return pow(this.context.valueOf(j));
    }

    public BigFloat pow(double d) {
        return pow(this.context.valueOf(d));
    }

    public BigFloat root(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            return bigFloat;
        }
        Context max = max(this.context, bigFloat.context);
        return max.valueOf(BigDecimalMath.root(this.value, bigFloat.value, max.mathContext));
    }

    public BigFloat root(BigDecimal bigDecimal) {
        return root(this.context.valueOf(bigDecimal));
    }

    public BigFloat root(int i) {
        return root(this.context.valueOf(i));
    }

    public BigFloat root(long j) {
        return root(this.context.valueOf(j));
    }

    public BigFloat root(double d) {
        return root(this.context.valueOf(d));
    }

    public int hashCode() {
        return this.value.stripTrailingZeros().hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.value.compareTo(((BigFloat) obj).value) == 0;
    }

    public int signum() {
        return this.value.signum();
    }

    public boolean isNegative() {
        return this.value.signum() < 0;
    }

    public boolean isZero() {
        return this.value.signum() == 0;
    }

    public boolean isPositive() {
        return this.value.signum() > 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            return -bigFloat.compareTo(this);
        }
        return this.value.compareTo(bigFloat.value);
    }

    public boolean isEqual(BigFloat bigFloat) {
        BigFloat bigFloat2 = NaN;
        return (this == bigFloat2 || bigFloat == bigFloat2 || compareTo(bigFloat) != 0) ? false : true;
    }

    public boolean isLessThan(BigFloat bigFloat) {
        BigFloat bigFloat2 = NaN;
        return (this == bigFloat2 || bigFloat == bigFloat2 || compareTo(bigFloat) >= 0) ? false : true;
    }

    public boolean isGreaterThan(BigFloat bigFloat) {
        BigFloat bigFloat2 = NaN;
        return (this == bigFloat2 || bigFloat == bigFloat2 || compareTo(bigFloat) <= 0) ? false : true;
    }

    public boolean isLessThanOrEqual(BigFloat bigFloat) {
        BigFloat bigFloat2 = NaN;
        return (this == bigFloat2 || bigFloat == bigFloat2 || compareTo(bigFloat) > 0) ? false : true;
    }

    public boolean isGreaterThanOrEqual(BigFloat bigFloat) {
        BigFloat bigFloat2 = NaN;
        return (this == bigFloat2 || bigFloat == bigFloat2 || compareTo(bigFloat) < 0) ? false : true;
    }

    public boolean isIntValue() {
        return BigDecimalMath.isIntValue(this.value);
    }

    public boolean isDoubleValue() {
        return BigDecimalMath.isDoubleValue(this.value);
    }

    public BigFloat getMantissa() {
        return this.context.valueOf(BigDecimalMath.mantissa(this.value));
    }

    public BigFloat getExponent() {
        return this.context.valueOf(BigDecimalMath.exponent(this.value));
    }

    public BigFloat getIntegralPart() {
        return this.context.valueOf(BigDecimalMath.integralPart(this.value));
    }

    public BigFloat getFractionalPart() {
        return this.context.valueOf(BigDecimalMath.fractionalPart(this.value));
    }

    public Context getContext() {
        return this.context;
    }

    public BigDecimal toBigDecimal() {
        return this.value;
    }

    public double toDouble() {
        return this.value.doubleValue();
    }

    public long toLong() {
        return this.value.longValue();
    }

    public int toInt() {
        return this.value.intValue();
    }

    public String toString() {
        return this.value.toString();
    }

    protected SpecialBigFloat.Type type() {
        return SpecialBigFloat.Type.NORMAL;
    }

    public boolean isNaN() {
        return this == NaN;
    }

    public boolean isInfinity() {
        return this == POSITIVE_INFINITY || this == NEGATIVE_INFINITY;
    }

    /* loaded from: classes.dex */
    private static final class SpecialBigFloat extends BigFloat {
        private static final Context DUMMY_CONTEXT = BigFloat.context(MathContext.DECIMAL32);
        private final Type type;

        @Override // ch.obermuhlner.math.big.BigFloat
        public BigFloat getExponent() {
            return this;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public BigFloat getFractionalPart() {
            return this;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public BigFloat getIntegralPart() {
            return this;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public BigFloat getMantissa() {
            return this;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public boolean isDoubleValue() {
            return false;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public boolean isIntValue() {
            return false;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        protected boolean isSpecial() {
            return true;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public boolean isZero() {
            return false;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public BigFloat root(BigFloat bigFloat) {
            return this;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public BigFloat subtract(BigDecimal bigDecimal) {
            return this;
        }

        /* synthetic */ SpecialBigFloat(Type type, AnonymousClass1 anonymousClass1) {
            this(type);
        }

        private SpecialBigFloat(Type type) {
            super(null, DUMMY_CONTEXT, null);
            this.type = type;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        protected Type type() {
            return this.type;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public BigFloat add(BigFloat bigFloat) {
            if (bigFloat.isSpecial()) {
                if (this == POSITIVE_INFINITY && bigFloat == POSITIVE_INFINITY) {
                    return POSITIVE_INFINITY;
                }
                if (this == NEGATIVE_INFINITY && bigFloat == NEGATIVE_INFINITY) {
                    return NEGATIVE_INFINITY;
                }
                return NaN;
            }
            return this;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public BigFloat subtract(BigFloat bigFloat) {
            if (bigFloat.isSpecial()) {
                if (this == POSITIVE_INFINITY && bigFloat == NEGATIVE_INFINITY) {
                    return POSITIVE_INFINITY;
                }
                if (this == NEGATIVE_INFINITY && bigFloat == POSITIVE_INFINITY) {
                    return NEGATIVE_INFINITY;
                }
                return NaN;
            }
            return this;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public BigFloat multiply(BigFloat bigFloat) {
            if (bigFloat.isZero() || bigFloat == NaN) {
                return NaN;
            }
            return bigFloat.isNegative() ? negate(this) : this;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public BigFloat divide(BigFloat bigFloat) {
            if (bigFloat == NaN || (isInfinity() && bigFloat.isInfinity())) {
                return NaN;
            }
            return bigFloat.isNegative() ? negate(this) : this;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public BigFloat remainder(BigFloat bigFloat) {
            return NaN;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public BigFloat pow(BigFloat bigFloat) {
            if (bigFloat.isZero()) {
                return bigFloat.context.ONE;
            }
            if (bigFloat == NaN) {
                return NaN;
            }
            if (isInfinity() && bigFloat.isNegative()) {
                return bigFloat.context.ZERO;
            }
            return (this == NEGATIVE_INFINITY && bigFloat.isPositive()) ? POSITIVE_INFINITY : this;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public int hashCode() {
            return this.type.hashCode;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BigFloat) {
                BigFloat bigFloat = (BigFloat) obj;
                if (bigFloat.isSpecial() && bigFloat.type() == this.type) {
                    return true;
                }
            }
            return false;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public int signum() {
            return this.type == Type.POSITIVE_INFINITY ? 1 : -1;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public boolean isNegative() {
            return signum() < 0;
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public boolean isPositive() {
            return signum() > 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // ch.obermuhlner.math.big.BigFloat, java.lang.Comparable
        public int compareTo(BigFloat bigFloat) {
            return Type.compare(this.type, bigFloat.type());
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public Context getContext() {
            throw new UnsupportedOperationException(this.type + " has no context");
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public BigDecimal toBigDecimal() {
            throw new UnsupportedOperationException(this.type + " has no corresponding BigDecimal representation");
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public double toDouble() {
            return this.type.toDouble();
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public long toLong() {
            return (long) toDouble();
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public int toInt() {
            return (int) toDouble();
        }

        @Override // ch.obermuhlner.math.big.BigFloat
        public String toString() {
            return this.type.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public enum Type {
            NaN(Objects.hashCode(Double.valueOf(Double.NaN))),
            POSITIVE_INFINITY(Objects.hashCode(Double.valueOf(Double.POSITIVE_INFINITY))),
            NORMAL(Objects.hashCode(0)),
            NEGATIVE_INFINITY(Objects.hashCode(Double.valueOf(Double.NEGATIVE_INFINITY)));
            
            final int hashCode;

            Type(int i) {
                this.hashCode = i;
            }

            public static int compare(Type type, Type type2) {
                return Double.compare(type.toDouble(), type2.toDouble());
            }

            public double toDouble() {
                int i = AnonymousClass1.$SwitchMap$ch$obermuhlner$math$big$BigFloat$SpecialBigFloat$Type[ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        return i != 3 ? 0.0d : Double.NaN;
                    }
                    return Double.NEGATIVE_INFINITY;
                }
                return Double.POSITIVE_INFINITY;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ch.obermuhlner.math.big.BigFloat$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ch$obermuhlner$math$big$BigFloat$SpecialBigFloat$Type;

        static {
            int[] iArr = new int[SpecialBigFloat.Type.values().length];
            $SwitchMap$ch$obermuhlner$math$big$BigFloat$SpecialBigFloat$Type = iArr;
            try {
                iArr[SpecialBigFloat.Type.POSITIVE_INFINITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ch$obermuhlner$math$big$BigFloat$SpecialBigFloat$Type[SpecialBigFloat.Type.NEGATIVE_INFINITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ch$obermuhlner$math$big$BigFloat$SpecialBigFloat$Type[SpecialBigFloat.Type.NaN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Context implements Serializable {
        private static final long serialVersionUID = -5787473786808803161L;
        public final BigFloat NEGATIVE_ONE;
        public final BigFloat ONE;
        public final BigFloat ZERO;
        private final MathContext mathContext;

        /* synthetic */ Context(MathContext mathContext, AnonymousClass1 anonymousClass1) {
            this(mathContext);
        }

        private Context(MathContext mathContext) {
            this.mathContext = mathContext;
            this.NEGATIVE_ONE = valueOf(-1);
            this.ZERO = valueOf(0);
            this.ONE = valueOf(1);
        }

        public MathContext getMathContext() {
            return this.mathContext;
        }

        public int getPrecision() {
            return this.mathContext.getPrecision();
        }

        public RoundingMode getRoundingMode() {
            return this.mathContext.getRoundingMode();
        }

        public BigFloat valueOf(BigFloat bigFloat) {
            return bigFloat.isSpecial() ? bigFloat : new BigFloat(bigFloat.value.round(this.mathContext), this, null);
        }

        public BigFloat valueOf(BigDecimal bigDecimal) {
            return new BigFloat(bigDecimal.round(this.mathContext), this, null);
        }

        public BigFloat valueOf(int i) {
            return new BigFloat(new BigDecimal(i, this.mathContext), this, null);
        }

        public BigFloat valueOf(int i, boolean z) {
            if (z) {
                if (i > -1) {
                    return valueOf(i, false);
                }
                return new BigFloat(new BigDecimal(Integer.MAX_VALUE).add(new BigDecimal(i & Integer.MAX_VALUE)).add(BigDecimal.ONE), this, null);
            }
            return new BigFloat(new BigDecimal(i, this.mathContext), this, null);
        }

        public BigFloat valueOf(long j) {
            return new BigFloat(new BigDecimal(j, this.mathContext), this, null);
        }

        public BigFloat valueOf(long j, boolean z) {
            if (z) {
                if (j > -1) {
                    return valueOf(j, false);
                }
                return new BigFloat(new BigDecimal((long) LongCompanionObject.MAX_VALUE).add(new BigDecimal(j & LongCompanionObject.MAX_VALUE)).add(BigDecimal.ONE), this, null);
            }
            return new BigFloat(new BigDecimal(j, this.mathContext), this, null);
        }

        public BigFloat valueOf(double d) {
            if (Double.isInfinite(d)) {
                return d == Double.POSITIVE_INFINITY ? BigFloat.POSITIVE_INFINITY : BigFloat.NEGATIVE_INFINITY;
            } else if (Double.isNaN(d)) {
                return BigFloat.NaN;
            } else {
                return new BigFloat(new BigDecimal(String.valueOf(d), this.mathContext), this, null);
            }
        }

        public BigFloat valueOf(String str) {
            return new BigFloat(new BigDecimal(str, this.mathContext), this, null);
        }

        public BigFloat pi() {
            return valueOf(BigDecimalMath.pi(this.mathContext));
        }

        public BigFloat e() {
            return valueOf(BigDecimalMath.e(this.mathContext));
        }

        public BigFloat factorial(int i) {
            return valueOf(BigDecimalMath.factorial(i));
        }

        public int hashCode() {
            return this.mathContext.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                return this.mathContext.equals(((Context) obj).mathContext);
            }
            return false;
        }

        public String toString() {
            return this.mathContext.toString();
        }
    }

    public static BigFloat negate(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            if (bigFloat.isInfinity()) {
                BigFloat bigFloat2 = POSITIVE_INFINITY;
                return bigFloat == bigFloat2 ? NEGATIVE_INFINITY : bigFloat2;
            }
            return NaN;
        }
        return bigFloat.context.valueOf(bigFloat.value.negate());
    }

    public static BigFloat abs(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            return bigFloat.isInfinity() ? POSITIVE_INFINITY : NaN;
        }
        return bigFloat.context.valueOf(bigFloat.value.abs());
    }

    public static BigFloat max(BigFloat bigFloat, BigFloat bigFloat2) {
        return bigFloat.compareTo(bigFloat2) >= 0 ? bigFloat : bigFloat2;
    }

    public static BigFloat max(BigFloat bigFloat, BigFloat... bigFloatArr) {
        for (BigFloat bigFloat2 : bigFloatArr) {
            bigFloat = max(bigFloat, bigFloat2);
        }
        return bigFloat;
    }

    public static BigFloat min(BigFloat bigFloat, BigFloat bigFloat2) {
        return bigFloat.compareTo(bigFloat2) < 0 ? bigFloat : bigFloat2;
    }

    public static BigFloat min(BigFloat bigFloat, BigFloat... bigFloatArr) {
        for (BigFloat bigFloat2 : bigFloatArr) {
            bigFloat = min(bigFloat, bigFloat2);
        }
        return bigFloat;
    }

    private static BigFloat logSpecial(BigFloat bigFloat) {
        if (bigFloat.isNaN() || bigFloat.isNegative()) {
            return NaN;
        }
        BigFloat bigFloat2 = POSITIVE_INFINITY;
        if (bigFloat == bigFloat2) {
            return bigFloat2;
        }
        if (bigFloat.isZero()) {
            return NEGATIVE_INFINITY;
        }
        return null;
    }

    public static BigFloat log(BigFloat bigFloat) {
        BigFloat logSpecial = logSpecial(bigFloat);
        if (logSpecial != null) {
            return logSpecial;
        }
        Context context = bigFloat.context;
        return context.valueOf(BigDecimalMath.log(bigFloat.value, context.mathContext));
    }

    public static BigFloat log2(BigFloat bigFloat) {
        BigFloat logSpecial = logSpecial(bigFloat);
        if (logSpecial != null) {
            return logSpecial;
        }
        Context context = bigFloat.context;
        return context.valueOf(BigDecimalMath.log2(bigFloat.value, context.mathContext));
    }

    public static BigFloat log10(BigFloat bigFloat) {
        BigFloat logSpecial = logSpecial(bigFloat);
        if (logSpecial != null) {
            return logSpecial;
        }
        Context context = bigFloat.context;
        return context.valueOf(BigDecimalMath.log10(bigFloat.value, context.mathContext));
    }

    public static BigFloat exp(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            return bigFloat != NEGATIVE_INFINITY ? bigFloat : bigFloat.context.ZERO;
        }
        Context context = bigFloat.context;
        return context.valueOf(BigDecimalMath.exp(bigFloat.value, context.mathContext));
    }

    public static BigFloat sqrt(BigFloat bigFloat) {
        if (bigFloat.isNaN() || bigFloat.isNegative()) {
            return NaN;
        }
        if (bigFloat.isZero() || bigFloat.isInfinity()) {
            return bigFloat;
        }
        Context context = bigFloat.context;
        return context.valueOf(BigDecimalMath.sqrt(bigFloat.value, context.mathContext));
    }

    public static BigFloat pow(BigFloat bigFloat, BigFloat bigFloat2) {
        Context max = max(bigFloat.context, bigFloat2.context);
        return max.valueOf(BigDecimalMath.pow(bigFloat.value, bigFloat2.value, max.mathContext));
    }

    public static BigFloat root(BigFloat bigFloat, BigFloat bigFloat2) {
        Context max = max(bigFloat.context, bigFloat2.context);
        return max.valueOf(BigDecimalMath.root(bigFloat.value, bigFloat2.value, max.mathContext));
    }

    public static BigFloat sin(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            return NaN;
        }
        if (bigFloat.isZero()) {
            return bigFloat;
        }
        Context context = bigFloat.context;
        return context.valueOf(BigDecimalMath.sin(bigFloat.value, context.mathContext));
    }

    public static BigFloat cos(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            return NaN;
        }
        Context context = bigFloat.context;
        return context.valueOf(BigDecimalMath.cos(bigFloat.value, context.mathContext));
    }

    public static BigFloat tan(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            return NaN;
        }
        if (bigFloat.isZero()) {
            return bigFloat;
        }
        Context context = bigFloat.context;
        return context.valueOf(BigDecimalMath.tan(bigFloat.value, context.mathContext));
    }

    public static BigFloat cot(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            return bigFloat;
        }
        if (bigFloat.isZero()) {
            return POSITIVE_INFINITY;
        }
        Context context = bigFloat.context;
        return context.valueOf(BigDecimalMath.cot(bigFloat.value, context.mathContext));
    }

    public static BigFloat asin(BigFloat bigFloat) {
        if (bigFloat.isZero()) {
            return bigFloat;
        }
        if (!bigFloat.isNaN() && isRangeAbs1(bigFloat)) {
            Context context = bigFloat.context;
            return context.valueOf(BigDecimalMath.asin(bigFloat.value, context.mathContext));
        }
        return NaN;
    }

    public static BigFloat acos(BigFloat bigFloat) {
        if (!bigFloat.isNaN() && isRangeAbs1(bigFloat)) {
            Context context = bigFloat.context;
            return context.valueOf(BigDecimalMath.acos(bigFloat.value, context.mathContext));
        }
        return NaN;
    }

    private static boolean isRangeAbs1(BigFloat bigFloat) {
        return isBetween(bigFloat.context.NEGATIVE_ONE, bigFloat.context.ONE, bigFloat);
    }

    public static BigFloat atan(BigFloat bigFloat) {
        if (bigFloat.isSpecial() || bigFloat.isZero()) {
            return bigFloat;
        }
        Context context = bigFloat.context;
        return context.valueOf(BigDecimalMath.atan(bigFloat.value, context.mathContext));
    }

    public static BigFloat acot(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            return bigFloat;
        }
        Context context = bigFloat.context;
        return context.valueOf(BigDecimalMath.acot(bigFloat.value, context.mathContext));
    }

    public static BigFloat sinh(BigFloat bigFloat) {
        if (bigFloat.isSpecial() || bigFloat.isZero()) {
            return bigFloat;
        }
        Context context = bigFloat.context;
        return context.valueOf(BigDecimalMath.sinh(bigFloat.value, context.mathContext));
    }

    public static BigFloat cosh(BigFloat bigFloat) {
        if (bigFloat.isNaN()) {
            return NaN;
        }
        if (bigFloat.isInfinity()) {
            return POSITIVE_INFINITY;
        }
        if (bigFloat.isZero()) {
            return bigFloat.context.ONE;
        }
        Context context = bigFloat.context;
        return context.valueOf(BigDecimalMath.cosh(bigFloat.value, context.mathContext));
    }

    public static BigFloat tanh(BigFloat bigFloat) {
        if (bigFloat.isNaN() || bigFloat.isZero()) {
            return bigFloat;
        }
        if (bigFloat.isInfinity()) {
            return bigFloat == POSITIVE_INFINITY ? bigFloat.context.ONE : bigFloat.context.NEGATIVE_ONE;
        }
        Context context = bigFloat.context;
        return context.valueOf(BigDecimalMath.tanh(bigFloat.value, context.mathContext));
    }

    public static BigFloat coth(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            return bigFloat;
        }
        Context context = bigFloat.context;
        return context.valueOf(BigDecimalMath.coth(bigFloat.value, context.mathContext));
    }

    public static BigFloat asinh(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            return bigFloat;
        }
        Context context = bigFloat.context;
        return context.valueOf(BigDecimalMath.asinh(bigFloat.value, context.mathContext));
    }

    public static BigFloat acosh(BigFloat bigFloat) {
        Context context = bigFloat.context;
        return context.valueOf(BigDecimalMath.acosh(bigFloat.value, context.mathContext));
    }

    public static BigFloat atanh(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            return bigFloat;
        }
        Context context = bigFloat.context;
        return context.valueOf(BigDecimalMath.atanh(bigFloat.value, context.mathContext));
    }

    public static BigFloat acoth(BigFloat bigFloat) {
        if (bigFloat.isSpecial()) {
            return bigFloat;
        }
        Context context = bigFloat.context;
        return context.valueOf(BigDecimalMath.acoth(bigFloat.value, context.mathContext));
    }

    public static boolean isBetween(BigFloat bigFloat, BigFloat bigFloat2, BigFloat bigFloat3) {
        return bigFloat3.compareTo(bigFloat) >= 0 && bigFloat3.compareTo(bigFloat2) <= 0;
    }

    private static Context max(Context context, Context context2) {
        return context.mathContext.getPrecision() > context2.mathContext.getPrecision() ? context : context2;
    }
}
