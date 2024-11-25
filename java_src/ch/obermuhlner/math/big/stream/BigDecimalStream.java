package ch.obermuhlner.math.big.stream;

import ch.obermuhlner.math.big.BigDecimalMath;
import com.rigol.scope.cil.MessageID;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
/* loaded from: classes.dex */
public class BigDecimalStream {
    public static Stream<BigDecimal> range(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3, MathContext mathContext) {
        if (bigDecimal3.signum() == 0) {
            throw new IllegalArgumentException("invalid step: 0");
        }
        if (bigDecimal2.subtract(bigDecimal).signum() != bigDecimal3.signum()) {
            return Stream.empty();
        }
        return StreamSupport.stream(new BigDecimalSpliterator(bigDecimal, bigDecimal2, false, bigDecimal3, mathContext), false);
    }

    public static Stream<BigDecimal> range(long j, long j2, long j3, MathContext mathContext) {
        return range(BigDecimal.valueOf(j), BigDecimal.valueOf(j2), BigDecimal.valueOf(j3), mathContext);
    }

    public static Stream<BigDecimal> range(double d, double d2, double d3, MathContext mathContext) {
        return range(BigDecimal.valueOf(d), BigDecimal.valueOf(d2), BigDecimal.valueOf(d3), mathContext);
    }

    public static Stream<BigDecimal> rangeClosed(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3, MathContext mathContext) {
        if (bigDecimal3.signum() == 0) {
            throw new IllegalArgumentException("invalid step: 0");
        }
        if (bigDecimal2.subtract(bigDecimal).signum() == (-bigDecimal3.signum())) {
            return Stream.empty();
        }
        return StreamSupport.stream(new BigDecimalSpliterator(bigDecimal, bigDecimal2, true, bigDecimal3, mathContext), false);
    }

    public static Stream<BigDecimal> rangeClosed(long j, long j2, long j3, MathContext mathContext) {
        return rangeClosed(BigDecimal.valueOf(j), BigDecimal.valueOf(j2), BigDecimal.valueOf(j3), mathContext);
    }

    public static Stream<BigDecimal> rangeClosed(double d, double d2, double d3, MathContext mathContext) {
        return rangeClosed(BigDecimal.valueOf(d), BigDecimal.valueOf(d2), BigDecimal.valueOf(d3), mathContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class BigDecimalSpliterator extends Spliterators.AbstractSpliterator<BigDecimal> {
        private long count;
        private MathContext mathContext;
        private BigDecimal step;
        private BigDecimal value;

        public BigDecimalSpliterator(BigDecimal bigDecimal, BigDecimal bigDecimal2, long j, MathContext mathContext) {
            super(j, MessageID.CMD_SEARCH_SOURCE_CURR_PTR);
            this.value = bigDecimal;
            this.step = bigDecimal2;
            this.count = j;
            this.mathContext = mathContext;
        }

        public BigDecimalSpliterator(BigDecimal bigDecimal, BigDecimal bigDecimal2, boolean z, BigDecimal bigDecimal3, MathContext mathContext) {
            this(bigDecimal, bigDecimal3, estimatedCount(bigDecimal, bigDecimal2, z, bigDecimal3, mathContext), mathContext);
        }

        private static long estimatedCount(BigDecimal bigDecimal, BigDecimal bigDecimal2, boolean z, BigDecimal bigDecimal3, MathContext mathContext) {
            BigDecimal divide = bigDecimal2.subtract(bigDecimal).divide(bigDecimal3, mathContext);
            long longValue = divide.longValue();
            return (BigDecimalMath.fractionalPart(divide).signum() == 0 && !z) ? longValue : longValue + 1;
        }

        @Override // java.util.Spliterator
        public Comparator<? super BigDecimal> getComparator() {
            if (this.step.signum() < 0) {
                return Comparator.reverseOrder();
            }
            return null;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super BigDecimal> consumer) {
            if (this.count == 0) {
                return false;
            }
            consumer.accept(this.value);
            this.value = this.value.add(this.step, this.mathContext);
            this.count--;
            return true;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super BigDecimal> consumer) {
            while (this.count > 0) {
                consumer.accept(this.value);
                this.value = this.value.add(this.step, this.mathContext);
                this.count--;
            }
        }

        @Override // java.util.Spliterators.AbstractSpliterator, java.util.Spliterator
        public Spliterator<BigDecimal> trySplit() {
            long j = this.count;
            long j2 = j / 2;
            if (j2 == 0) {
                return null;
            }
            long j3 = j - j2;
            this.count = j2;
            return new BigDecimalSpliterator(this.value.add(this.step.multiply(new BigDecimal(j2), this.mathContext), this.mathContext), this.step, j3, this.mathContext);
        }
    }
}
