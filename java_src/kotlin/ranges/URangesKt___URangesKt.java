package kotlin.ranges;

import java.util.NoSuchElementException;
import javax.mail.UIDFolder;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.ranges.UIntProgression;
import kotlin.ranges.ULongProgression;
/* compiled from: _URanges.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\n\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001e\u0010\u0000\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001e\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0004\u001a\u001e\u0010\u000e\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0007\u001a\u001e\u0010\u000e\u001a\u00020\b*\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a\u001e\u0010\u000e\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\r\u001a&\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a&\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a$\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a&\u0010\u0014\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a$\u0010\u0014\u001a\u00020\b*\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a&\u0010\u0014\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0087\nø\u0001\u0000¢\u0006\u0002\b*\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\bH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0005H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\b\u0010)\u001a\u0004\u0018\u00010\bH\u0087\nø\u0001\u0000¢\u0006\u0002\b4\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u000bH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u001f\u00107\u001a\u000208*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a\u001f\u00107\u001a\u000208*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a\u001f\u00107\u001a\u00020>*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a\u001f\u00107\u001a\u000208*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a\u0015\u0010C\u001a\u00020\u0005*\u00020%H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010D\u001a\u001c\u0010C\u001a\u00020\u0005*\u00020%2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001\u0000¢\u0006\u0002\u0010F\u001a\u0015\u0010C\u001a\u00020\b*\u00020/H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010G\u001a\u001c\u0010C\u001a\u00020\b*\u00020/2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001\u0000¢\u0006\u0002\u0010H\u001a\u0012\u0010I\u001a\u0004\u0018\u00010\u0005*\u00020%H\u0087\bø\u0001\u0000\u001a\u0019\u0010I\u001a\u0004\u0018\u00010\u0005*\u00020%2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001\u0000\u001a\u0012\u0010I\u001a\u0004\u0018\u00010\b*\u00020/H\u0087\bø\u0001\u0000\u001a\u0019\u0010I\u001a\u0004\u0018\u00010\b*\u00020/2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001\u0000\u001a\f\u0010J\u001a\u000208*\u000208H\u0007\u001a\f\u0010J\u001a\u00020>*\u00020>H\u0007\u001a\u0015\u0010K\u001a\u000208*\u0002082\u0006\u0010K\u001a\u00020LH\u0087\u0004\u001a\u0015\u0010K\u001a\u00020>*\u00020>2\u0006\u0010K\u001a\u00020MH\u0087\u0004\u001a\u001f\u0010N\u001a\u00020%*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001a\u001f\u0010N\u001a\u00020%*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a\u001f\u0010N\u001a\u00020/*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u001f\u0010N\u001a\u00020%*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bU\u0010V\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006W"}, d2 = {"coerceAtLeast", "Lkotlin/UByte;", "minimumValue", "coerceAtLeast-Kr8caGY", "(BB)B", "Lkotlin/UInt;", "coerceAtLeast-J1ME1BU", "(II)I", "Lkotlin/ULong;", "coerceAtLeast-eb3DHEI", "(JJ)J", "Lkotlin/UShort;", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-Kr8caGY", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-WZ9TVnA", "(III)I", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "coerceIn-VKSA0NQ", "(SSS)S", "contains", "", "Lkotlin/ranges/UIntRange;", "value", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "element", "contains-biwQdVI", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "Lkotlin/ranges/ULongRange;", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-GYNo2lE", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "Lkotlin/ranges/UIntProgression;", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "random", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;)J", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "reversed", "step", "", "", "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xi = 1, xs = "kotlin/ranges/URangesKt")
/* loaded from: classes2.dex */
class URangesKt___URangesKt {
    private static final int random(UIntRange uIntRange) {
        return URangesKt.random(uIntRange, Random.Default);
    }

    private static final long random(ULongRange uLongRange) {
        return URangesKt.random(uLongRange, Random.Default);
    }

    public static final int random(UIntRange random, Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        try {
            return URandomKt.nextUInt(random2, random);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final long random(ULongRange random, Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        try {
            return URandomKt.nextULong(random2, random);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    private static final UInt randomOrNull(UIntRange uIntRange) {
        return URangesKt.randomOrNull(uIntRange, Random.Default);
    }

    private static final ULong randomOrNull(ULongRange uLongRange) {
        return URangesKt.randomOrNull(uLongRange, Random.Default);
    }

    public static final UInt randomOrNull(UIntRange randomOrNull, Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (randomOrNull.isEmpty()) {
            return null;
        }
        return UInt.m108boximpl(URandomKt.nextUInt(random, randomOrNull));
    }

    public static final ULong randomOrNull(ULongRange randomOrNull, Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (randomOrNull.isEmpty()) {
            return null;
        }
        return ULong.m178boximpl(URandomKt.nextULong(random, randomOrNull));
    }

    /* renamed from: contains-biwQdVI  reason: not valid java name */
    private static final boolean m1240containsbiwQdVI(UIntRange contains, UInt uInt) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return uInt != null && contains.m1212containsWZ4Q5Ns(uInt.m157unboximpl());
    }

    /* renamed from: contains-GYNo2lE  reason: not valid java name */
    private static final boolean m1236containsGYNo2lE(ULongRange contains, ULong uLong) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return uLong != null && contains.m1218containsVKZWuLQ(uLong.m227unboximpl());
    }

    /* renamed from: contains-68kG9v0  reason: not valid java name */
    public static final boolean m1235contains68kG9v0(UIntRange contains, byte b) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1212containsWZ4Q5Ns(UInt.m114constructorimpl(b & UByte.MAX_VALUE));
    }

    /* renamed from: contains-ULb-yJY  reason: not valid java name */
    public static final boolean m1238containsULbyJY(ULongRange contains, byte b) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1218containsVKZWuLQ(ULong.m184constructorimpl(b & 255));
    }

    /* renamed from: contains-Gab390E  reason: not valid java name */
    public static final boolean m1237containsGab390E(ULongRange contains, int i) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1218containsVKZWuLQ(ULong.m184constructorimpl(i & UIDFolder.MAXUID));
    }

    /* renamed from: contains-fz5IDCE  reason: not valid java name */
    public static final boolean m1241containsfz5IDCE(UIntRange contains, long j) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return ULong.m184constructorimpl(j >>> 32) == 0 && contains.m1212containsWZ4Q5Ns(UInt.m114constructorimpl((int) j));
    }

    /* renamed from: contains-ZsK3CEQ  reason: not valid java name */
    public static final boolean m1239containsZsK3CEQ(UIntRange contains, short s) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1212containsWZ4Q5Ns(UInt.m114constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: contains-uhHAxoY  reason: not valid java name */
    public static final boolean m1242containsuhHAxoY(ULongRange contains, short s) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1218containsVKZWuLQ(ULong.m184constructorimpl(s & 65535));
    }

    /* renamed from: downTo-Kr8caGY  reason: not valid java name */
    public static final UIntProgression m1245downToKr8caGY(byte b, byte b2) {
        return UIntProgression.Companion.m1211fromClosedRangeNkh28Cs(UInt.m114constructorimpl(b & UByte.MAX_VALUE), UInt.m114constructorimpl(b2 & UByte.MAX_VALUE), -1);
    }

    /* renamed from: downTo-J1ME1BU  reason: not valid java name */
    public static final UIntProgression m1244downToJ1ME1BU(int i, int i2) {
        return UIntProgression.Companion.m1211fromClosedRangeNkh28Cs(i, i2, -1);
    }

    /* renamed from: downTo-eb3DHEI  reason: not valid java name */
    public static final ULongProgression m1246downToeb3DHEI(long j, long j2) {
        return ULongProgression.Companion.m1217fromClosedRange7ftBX0g(j, j2, -1L);
    }

    /* renamed from: downTo-5PvTz6A  reason: not valid java name */
    public static final UIntProgression m1243downTo5PvTz6A(short s, short s2) {
        return UIntProgression.Companion.m1211fromClosedRangeNkh28Cs(UInt.m114constructorimpl(s & UShort.MAX_VALUE), UInt.m114constructorimpl(s2 & UShort.MAX_VALUE), -1);
    }

    public static final UIntProgression reversed(UIntProgression reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        return UIntProgression.Companion.m1211fromClosedRangeNkh28Cs(reversed.m1210getLastpVg5ArA(), reversed.m1209getFirstpVg5ArA(), -reversed.getStep());
    }

    public static final ULongProgression reversed(ULongProgression reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        return ULongProgression.Companion.m1217fromClosedRange7ftBX0g(reversed.m1216getLastsVKNKU(), reversed.m1215getFirstsVKNKU(), -reversed.getStep());
    }

    public static final UIntProgression step(UIntProgression step, int i) {
        Intrinsics.checkNotNullParameter(step, "$this$step");
        RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        UIntProgression.Companion companion = UIntProgression.Companion;
        int m1209getFirstpVg5ArA = step.m1209getFirstpVg5ArA();
        int m1210getLastpVg5ArA = step.m1210getLastpVg5ArA();
        if (step.getStep() <= 0) {
            i = -i;
        }
        return companion.m1211fromClosedRangeNkh28Cs(m1209getFirstpVg5ArA, m1210getLastpVg5ArA, i);
    }

    public static final ULongProgression step(ULongProgression step, long j) {
        Intrinsics.checkNotNullParameter(step, "$this$step");
        RangesKt.checkStepIsPositive(j > 0, Long.valueOf(j));
        ULongProgression.Companion companion = ULongProgression.Companion;
        long m1215getFirstsVKNKU = step.m1215getFirstsVKNKU();
        long m1216getLastsVKNKU = step.m1216getLastsVKNKU();
        if (step.getStep() <= 0) {
            j = -j;
        }
        return companion.m1217fromClosedRange7ftBX0g(m1215getFirstsVKNKU, m1216getLastsVKNKU, j);
    }

    /* renamed from: until-Kr8caGY  reason: not valid java name */
    public static final UIntRange m1249untilKr8caGY(byte b, byte b2) {
        int i = b2 & UByte.MAX_VALUE;
        return Intrinsics.compare(i, 0) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange(UInt.m114constructorimpl(b & UByte.MAX_VALUE), UInt.m114constructorimpl(UInt.m114constructorimpl(i) - 1), null);
    }

    /* renamed from: until-J1ME1BU  reason: not valid java name */
    public static final UIntRange m1248untilJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i2, 0) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange(i, UInt.m114constructorimpl(i2 - 1), null);
    }

    /* renamed from: until-eb3DHEI  reason: not valid java name */
    public static final ULongRange m1250untileb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j2, 0L) <= 0 ? ULongRange.Companion.getEMPTY() : new ULongRange(j, ULong.m184constructorimpl(j2 - ULong.m184constructorimpl(1 & UIDFolder.MAXUID)), null);
    }

    /* renamed from: until-5PvTz6A  reason: not valid java name */
    public static final UIntRange m1247until5PvTz6A(short s, short s2) {
        int i = s2 & UShort.MAX_VALUE;
        return Intrinsics.compare(i, 0) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange(UInt.m114constructorimpl(s & UShort.MAX_VALUE), UInt.m114constructorimpl(UInt.m114constructorimpl(i) - 1), null);
    }

    /* renamed from: coerceAtLeast-J1ME1BU  reason: not valid java name */
    public static final int m1222coerceAtLeastJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2) < 0 ? i2 : i;
    }

    /* renamed from: coerceAtLeast-eb3DHEI  reason: not valid java name */
    public static final long m1224coerceAtLeasteb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) < 0 ? j2 : j;
    }

    /* renamed from: coerceAtLeast-Kr8caGY  reason: not valid java name */
    public static final byte m1223coerceAtLeastKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & UByte.MAX_VALUE, b2 & UByte.MAX_VALUE) < 0 ? b2 : b;
    }

    /* renamed from: coerceAtLeast-5PvTz6A  reason: not valid java name */
    public static final short m1221coerceAtLeast5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) < 0 ? s2 : s;
    }

    /* renamed from: coerceAtMost-J1ME1BU  reason: not valid java name */
    public static final int m1226coerceAtMostJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2) > 0 ? i2 : i;
    }

    /* renamed from: coerceAtMost-eb3DHEI  reason: not valid java name */
    public static final long m1228coerceAtMosteb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) > 0 ? j2 : j;
    }

    /* renamed from: coerceAtMost-Kr8caGY  reason: not valid java name */
    public static final byte m1227coerceAtMostKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & UByte.MAX_VALUE, b2 & UByte.MAX_VALUE) > 0 ? b2 : b;
    }

    /* renamed from: coerceAtMost-5PvTz6A  reason: not valid java name */
    public static final short m1225coerceAtMost5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) > 0 ? s2 : s;
    }

    /* renamed from: coerceIn-WZ9TVnA  reason: not valid java name */
    public static final int m1231coerceInWZ9TVnA(int i, int i2, int i3) {
        if (UnsignedKt.uintCompare(i2, i3) <= 0) {
            return UnsignedKt.uintCompare(i, i2) < 0 ? i2 : UnsignedKt.uintCompare(i, i3) > 0 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UInt.m151toStringimpl(i3) + " is less than minimum " + UInt.m151toStringimpl(i2) + '.');
    }

    /* renamed from: coerceIn-sambcqE  reason: not valid java name */
    public static final long m1233coerceInsambcqE(long j, long j2, long j3) {
        if (UnsignedKt.ulongCompare(j2, j3) <= 0) {
            return UnsignedKt.ulongCompare(j, j2) < 0 ? j2 : UnsignedKt.ulongCompare(j, j3) > 0 ? j3 : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ULong.m221toStringimpl(j3) + " is less than minimum " + ULong.m221toStringimpl(j2) + '.');
    }

    /* renamed from: coerceIn-b33U2AM  reason: not valid java name */
    public static final byte m1232coerceInb33U2AM(byte b, byte b2, byte b3) {
        int i = b2 & UByte.MAX_VALUE;
        int i2 = b3 & UByte.MAX_VALUE;
        if (Intrinsics.compare(i, i2) <= 0) {
            int i3 = b & UByte.MAX_VALUE;
            return Intrinsics.compare(i3, i) < 0 ? b2 : Intrinsics.compare(i3, i2) > 0 ? b3 : b;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UByte.m81toStringimpl(b3) + " is less than minimum " + UByte.m81toStringimpl(b2) + '.');
    }

    /* renamed from: coerceIn-VKSA0NQ  reason: not valid java name */
    public static final short m1230coerceInVKSA0NQ(short s, short s2, short s3) {
        int i = s2 & UShort.MAX_VALUE;
        int i2 = s3 & UShort.MAX_VALUE;
        if (Intrinsics.compare(i, i2) <= 0) {
            int i3 = 65535 & s;
            return Intrinsics.compare(i3, i) < 0 ? s2 : Intrinsics.compare(i3, i2) > 0 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UShort.m317toStringimpl(s3) + " is less than minimum " + UShort.m317toStringimpl(s2) + '.');
    }

    /* renamed from: coerceIn-wuiCnnA  reason: not valid java name */
    public static final int m1234coerceInwuiCnnA(int i, ClosedRange<UInt> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((UInt) RangesKt.coerceIn(UInt.m108boximpl(i), (ClosedFloatingPointRange<UInt>) range)).m157unboximpl();
        }
        if (!range.isEmpty()) {
            return UnsignedKt.uintCompare(i, range.getStart().m157unboximpl()) < 0 ? range.getStart().m157unboximpl() : UnsignedKt.uintCompare(i, range.getEndInclusive().m157unboximpl()) > 0 ? range.getEndInclusive().m157unboximpl() : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    /* renamed from: coerceIn-JPwROB0  reason: not valid java name */
    public static final long m1229coerceInJPwROB0(long j, ClosedRange<ULong> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((ULong) RangesKt.coerceIn(ULong.m178boximpl(j), (ClosedFloatingPointRange<ULong>) range)).m227unboximpl();
        }
        if (!range.isEmpty()) {
            return UnsignedKt.ulongCompare(j, range.getStart().m227unboximpl()) < 0 ? range.getStart().m227unboximpl() : UnsignedKt.ulongCompare(j, range.getEndInclusive().m227unboximpl()) > 0 ? range.getEndInclusive().m227unboximpl() : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }
}
