package ch.obermuhlner.math.big.stream;

import ch.obermuhlner.math.big.BigFloat;
import com.rigol.scope.cil.MessageID;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
/* loaded from: classes.dex */
public class BigFloatStream {
    public static Stream<BigFloat> range(BigFloat bigFloat, BigFloat bigFloat2, BigFloat bigFloat3) {
        if (bigFloat3.isZero()) {
            throw new IllegalArgumentException("invalid step: 0");
        }
        if (bigFloat2.subtract(bigFloat).signum() != bigFloat3.signum()) {
            return Stream.empty();
        }
        return StreamSupport.stream(new BigFloatSpliterator(bigFloat, bigFloat2, false, bigFloat3), false);
    }

    public static Stream<BigFloat> range(long j, long j2, long j3, BigFloat.Context context) {
        return range(context.valueOf(j), context.valueOf(j2), context.valueOf(j3));
    }

    public static Stream<BigFloat> range(double d, double d2, double d3, BigFloat.Context context) {
        return range(context.valueOf(d), context.valueOf(d2), context.valueOf(d3));
    }

    public static Stream<BigFloat> rangeClosed(BigFloat bigFloat, BigFloat bigFloat2, BigFloat bigFloat3) {
        if (bigFloat3.isZero()) {
            throw new IllegalArgumentException("invalid step: 0");
        }
        if (bigFloat2.subtract(bigFloat).signum() == (-bigFloat3.signum())) {
            return Stream.empty();
        }
        return StreamSupport.stream(new BigFloatSpliterator(bigFloat, bigFloat2, true, bigFloat3), false);
    }

    public static Stream<BigFloat> rangeClosed(long j, long j2, long j3, BigFloat.Context context) {
        return rangeClosed(context.valueOf(j), context.valueOf(j2), context.valueOf(j3));
    }

    public static Stream<BigFloat> rangeClosed(double d, double d2, double d3, BigFloat.Context context) {
        return rangeClosed(context.valueOf(d), context.valueOf(d2), context.valueOf(d3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class BigFloatSpliterator extends Spliterators.AbstractSpliterator<BigFloat> {
        private long count;
        private BigFloat step;
        private BigFloat value;

        public BigFloatSpliterator(BigFloat bigFloat, BigFloat bigFloat2, long j) {
            super(j, MessageID.CMD_SEARCH_SOURCE_CURR_PTR);
            this.value = bigFloat;
            this.step = bigFloat2;
            this.count = j;
        }

        public BigFloatSpliterator(BigFloat bigFloat, BigFloat bigFloat2, boolean z, BigFloat bigFloat3) {
            this(bigFloat, bigFloat3, estimatedCount(bigFloat, bigFloat2, z, bigFloat3));
        }

        private static long estimatedCount(BigFloat bigFloat, BigFloat bigFloat2, boolean z, BigFloat bigFloat3) {
            BigFloat divide = bigFloat2.subtract(bigFloat).divide(bigFloat3);
            long j = divide.toLong();
            return (divide.getFractionalPart().signum() == 0 && !z) ? j : j + 1;
        }

        @Override // java.util.Spliterator
        public Comparator<? super BigFloat> getComparator() {
            if (this.step.signum() < 0) {
                return Comparator.reverseOrder();
            }
            return null;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super BigFloat> consumer) {
            if (this.count == 0) {
                return false;
            }
            consumer.accept(this.value);
            this.value = this.value.add(this.step);
            this.count--;
            return true;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super BigFloat> consumer) {
            while (this.count > 0) {
                consumer.accept(this.value);
                this.value = this.value.add(this.step);
                this.count--;
            }
        }

        @Override // java.util.Spliterators.AbstractSpliterator, java.util.Spliterator
        public Spliterator<BigFloat> trySplit() {
            long j = this.count;
            long j2 = j / 2;
            if (j2 == 0) {
                return null;
            }
            long j3 = j - j2;
            this.count = j2;
            return new BigFloatSpliterator(this.value.add(this.step.multiply(j2)), this.step, j3);
        }
    }
}
