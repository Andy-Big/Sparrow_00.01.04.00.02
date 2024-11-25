package kotlin.ranges;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: UIntRange.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u0018\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\t\u0010\bø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0018"}, d2 = {"Lkotlin/ranges/UIntRange;", "Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/UInt;", "start", "endInclusive", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEndInclusive-pVg5ArA", "()I", "getStart-pVg5ArA", "contains", "", "value", "contains-WZ4Q5Ns", "(I)Z", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class UIntRange extends UIntProgression implements ClosedRange<UInt> {
    public static final Companion Companion = new Companion(null);
    private static final UIntRange EMPTY = new UIntRange(-1, 0, null);

    private UIntRange(int i, int i2) {
        super(i, i2, 1, null);
    }

    public /* synthetic */ UIntRange(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(UInt uInt) {
        return m1212containsWZ4Q5Ns(uInt.m157unboximpl());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ UInt getEndInclusive() {
        return UInt.m108boximpl(m1213getEndInclusivepVg5ArA());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ UInt getStart() {
        return UInt.m108boximpl(m1214getStartpVg5ArA());
    }

    /* renamed from: getStart-pVg5ArA  reason: not valid java name */
    public int m1214getStartpVg5ArA() {
        return m1209getFirstpVg5ArA();
    }

    /* renamed from: getEndInclusive-pVg5ArA  reason: not valid java name */
    public int m1213getEndInclusivepVg5ArA() {
        return m1210getLastpVg5ArA();
    }

    /* renamed from: contains-WZ4Q5Ns  reason: not valid java name */
    public boolean m1212containsWZ4Q5Ns(int i) {
        return UnsignedKt.uintCompare(m1209getFirstpVg5ArA(), i) <= 0 && UnsignedKt.uintCompare(i, m1210getLastpVg5ArA()) <= 0;
    }

    @Override // kotlin.ranges.UIntProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return UnsignedKt.uintCompare(m1209getFirstpVg5ArA(), m1210getLastpVg5ArA()) > 0;
    }

    @Override // kotlin.ranges.UIntProgression
    public boolean equals(Object obj) {
        if (obj instanceof UIntRange) {
            if (!isEmpty() || !((UIntRange) obj).isEmpty()) {
                UIntRange uIntRange = (UIntRange) obj;
                if (m1209getFirstpVg5ArA() != uIntRange.m1209getFirstpVg5ArA() || m1210getLastpVg5ArA() != uIntRange.m1210getLastpVg5ArA()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.UIntProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (m1209getFirstpVg5ArA() * 31) + m1210getLastpVg5ArA();
    }

    @Override // kotlin.ranges.UIntProgression
    public String toString() {
        return UInt.m151toStringimpl(m1209getFirstpVg5ArA()) + ".." + UInt.m151toStringimpl(m1210getLastpVg5ArA());
    }

    /* compiled from: UIntRange.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/ranges/UIntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/UIntRange;", "getEMPTY", "()Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UIntRange getEMPTY() {
            return UIntRange.EMPTY;
        }
    }
}
