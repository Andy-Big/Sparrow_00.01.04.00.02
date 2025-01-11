package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import com.sun.mail.imap.IMAPStore;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: Duration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0087@\u0018\u0000 s2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001sB\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,J\u001e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\tH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010-J\u001b\u0010)\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010,J\u0013\u0010/\u001a\u0002002\b\u0010&\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\tHÖ\u0001J\r\u00103\u001a\u000200¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u000200¢\u0006\u0004\b7\u00105J\r\u00108\u001a\u000200¢\u0006\u0004\b9\u00105J\r\u0010:\u001a\u000200¢\u0006\u0004\b;\u00105J\u001b\u0010<\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010,J\u001b\u0010>\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010,J\u0017\u0010@\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0004\bA\u0010(J\u001e\u0010B\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010,J\u001e\u0010B\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\tH\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010-J\u009d\u0001\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2u\u0010F\u001aq\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0GH\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010PJ\u0088\u0001\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2`\u0010F\u001a\\\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0QH\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010RJs\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2K\u0010F\u001aG\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0SH\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010TJ^\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E26\u0010F\u001a2\u0012\u0013\u0012\u00110V¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0UH\u0086\bø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010WJ\u0019\u0010X\u001a\u00020\u00032\n\u0010Y\u001a\u00060Zj\u0002`[¢\u0006\u0004\b\\\u0010]J\u0019\u0010^\u001a\u00020\t2\n\u0010Y\u001a\u00060Zj\u0002`[¢\u0006\u0004\b_\u0010`J\r\u0010a\u001a\u00020b¢\u0006\u0004\bc\u0010dJ\u0019\u0010e\u001a\u00020V2\n\u0010Y\u001a\u00060Zj\u0002`[¢\u0006\u0004\bf\u0010gJ\r\u0010h\u001a\u00020V¢\u0006\u0004\bi\u0010jJ\r\u0010k\u001a\u00020V¢\u0006\u0004\bl\u0010jJ\u000f\u0010m\u001a\u00020bH\u0016¢\u0006\u0004\bn\u0010dJ#\u0010m\u001a\u00020b2\n\u0010Y\u001a\u00060Zj\u0002`[2\b\b\u0002\u0010o\u001a\u00020\t¢\u0006\u0004\bn\u0010pJ\u0016\u0010q\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\br\u0010\u0005R\u0017\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0011\u0010\u0016\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0011\u0010\u0018\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0011\u0010\u001a\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u001a\u0010\u001c\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\rR\u001a\u0010\u001f\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\rR\u001a\u0010\"\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000ø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006t"}, d2 = {"Lkotlin/time/Duration;", "", "value", "", "constructor-impl", "(D)D", "absoluteValue", "getAbsoluteValue-UwyO8pc", "hoursComponent", "", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "(D)I", "inDays", "getInDays-impl", "inHours", "getInHours-impl", "inMicroseconds", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds-impl", "inMinutes", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds-impl", "inSeconds", "getInSeconds-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "compareTo", "other", "compareTo-LRDsOJo", "(DD)I", "div", "scale", "div-UwyO8pc", "(DD)D", "(DI)D", "div-LRDsOJo", "equals", "", "", "hashCode", "isFinite", "isFinite-impl", "(D)Z", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "plus", "plus-LRDsOJo", "precision", "precision-impl", "times", "times-UwyO8pc", "toComponents", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", IMAPStore.ID_NAME, "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(DLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(DLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(DLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "", "(DLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "toDouble-impl", "(DLjava/util/concurrent/TimeUnit;)D", "toInt", "toInt-impl", "(DLjava/util/concurrent/TimeUnit;)I", "toIsoString", "", "toIsoString-impl", "(D)Ljava/lang/String;", "toLong", "toLong-impl", "(DLjava/util/concurrent/TimeUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "(D)J", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(DLjava/util/concurrent/TimeUnit;I)Ljava/lang/String;", "unaryMinus", "unaryMinus-UwyO8pc", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class Duration implements Comparable<Duration> {
    private final double value;
    public static final Companion Companion = new Companion(null);
    private static final double ZERO = m1286constructorimpl(0.0d);
    private static final double INFINITE = m1286constructorimpl(Double.POSITIVE_INFINITY);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Duration m1284boximpl(double d) {
        return new Duration(d);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static double m1286constructorimpl(double d) {
        return d;
    }

    /* renamed from: div-LRDsOJo  reason: not valid java name */
    public static final double m1287divLRDsOJo(double d, double d2) {
        return d / d2;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1290equalsimpl(double d, Object obj) {
        return (obj instanceof Duration) && Double.compare(d, ((Duration) obj).m1329unboximpl()) == 0;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1291equalsimpl0(double d, double d2) {
        return Double.compare(d, d2) == 0;
    }

    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1304hashCodeimpl(double d) {
        long doubleToLongBits = Double.doubleToLongBits(d);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    /* renamed from: isNegative-impl  reason: not valid java name */
    public static final boolean m1307isNegativeimpl(double d) {
        return d < ((double) 0);
    }

    /* renamed from: isPositive-impl  reason: not valid java name */
    public static final boolean m1308isPositiveimpl(double d) {
        return d > ((double) 0);
    }

    /* renamed from: precision-impl  reason: not valid java name */
    private static final int m1311precisionimpl(double d, double d2) {
        if (d2 < 1) {
            return 3;
        }
        if (d2 < 10) {
            return 2;
        }
        return d2 < ((double) 100) ? 1 : 0;
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public int m1328compareToLRDsOJo(double d) {
        return m1285compareToLRDsOJo(this.value, d);
    }

    public boolean equals(Object obj) {
        return m1290equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1304hashCodeimpl(this.value);
    }

    public String toString() {
        return m1324toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ double m1329unboximpl() {
        return this.value;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [kotlin.time.Duration.box-impl(double):kotlin.time.Duration] */
    private /* synthetic */ Duration(double d) {
        this.value = d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m1328compareToLRDsOJo(duration.m1329unboximpl());
    }

    /* compiled from: Duration.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0011"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE-UwyO8pc", "()D", "D", "ZERO", "getZERO-UwyO8pc", "convert", "", "value", "sourceUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "targetUnit", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZERO-UwyO8pc  reason: not valid java name */
        public final double m1331getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        /* renamed from: getINFINITE-UwyO8pc  reason: not valid java name */
        public final double m1330getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        public final double convert(double d, TimeUnit sourceUnit, TimeUnit targetUnit) {
            Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
            return DurationUnitKt.convertDurationUnit(d, sourceUnit, targetUnit);
        }
    }

    /* renamed from: unaryMinus-UwyO8pc  reason: not valid java name */
    public static final double m1327unaryMinusUwyO8pc(double d) {
        return m1286constructorimpl(-d);
    }

    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    public static final double m1310plusLRDsOJo(double d, double d2) {
        return m1286constructorimpl(d + d2);
    }

    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public static final double m1309minusLRDsOJo(double d, double d2) {
        return m1286constructorimpl(d - d2);
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final double m1313timesUwyO8pc(double d, int i) {
        return m1286constructorimpl(d * i);
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final double m1312timesUwyO8pc(double d, double d2) {
        return m1286constructorimpl(d * d2);
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final double m1289divUwyO8pc(double d, int i) {
        return m1286constructorimpl(d / i);
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final double m1288divUwyO8pc(double d, double d2) {
        return m1286constructorimpl(d / d2);
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m1306isInfiniteimpl(double d) {
        return Double.isInfinite(d);
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m1305isFiniteimpl(double d) {
        return (Double.isInfinite(d) || Double.isNaN(d)) ? false : true;
    }

    /* renamed from: getAbsoluteValue-UwyO8pc  reason: not valid java name */
    public static final double m1292getAbsoluteValueUwyO8pc(double d) {
        return m1307isNegativeimpl(d) ? m1327unaryMinusUwyO8pc(d) : d;
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public static int m1285compareToLRDsOJo(double d, double d2) {
        return Double.compare(d, d2);
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m1317toComponentsimpl(double d, Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Integer.valueOf((int) m1294getInDaysimpl(d)), Integer.valueOf(m1293getHoursComponentimpl(d)), Integer.valueOf(m1301getMinutesComponentimpl(d)), Integer.valueOf(m1303getSecondsComponentimpl(d)), Integer.valueOf(m1302getNanosecondsComponentimpl(d)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m1316toComponentsimpl(double d, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Integer.valueOf((int) m1295getInHoursimpl(d)), Integer.valueOf(m1301getMinutesComponentimpl(d)), Integer.valueOf(m1303getSecondsComponentimpl(d)), Integer.valueOf(m1302getNanosecondsComponentimpl(d)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m1315toComponentsimpl(double d, Function3<? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Integer.valueOf((int) m1298getInMinutesimpl(d)), Integer.valueOf(m1303getSecondsComponentimpl(d)), Integer.valueOf(m1302getNanosecondsComponentimpl(d)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m1314toComponentsimpl(double d, Function2<? super Long, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf((long) m1300getInSecondsimpl(d)), Integer.valueOf(m1302getNanosecondsComponentimpl(d)));
    }

    /* renamed from: getHoursComponent-impl  reason: not valid java name */
    public static final int m1293getHoursComponentimpl(double d) {
        return (int) (m1295getInHoursimpl(d) % 24);
    }

    /* renamed from: getMinutesComponent-impl  reason: not valid java name */
    public static final int m1301getMinutesComponentimpl(double d) {
        return (int) (m1298getInMinutesimpl(d) % 60);
    }

    /* renamed from: getSecondsComponent-impl  reason: not valid java name */
    public static final int m1303getSecondsComponentimpl(double d) {
        return (int) (m1300getInSecondsimpl(d) % 60);
    }

    /* renamed from: getNanosecondsComponent-impl  reason: not valid java name */
    public static final int m1302getNanosecondsComponentimpl(double d) {
        return (int) (m1299getInNanosecondsimpl(d) % 1.0E9d);
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m1318toDoubleimpl(double d, TimeUnit unit) {
        TimeUnit storageUnit;
        Intrinsics.checkNotNullParameter(unit, "unit");
        storageUnit = DurationKt.getStorageUnit();
        return DurationUnitKt.convertDurationUnit(d, storageUnit, unit);
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m1321toLongimpl(double d, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (long) m1318toDoubleimpl(d, unit);
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m1319toIntimpl(double d, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (int) m1318toDoubleimpl(d, unit);
    }

    /* renamed from: getInDays-impl  reason: not valid java name */
    public static final double m1294getInDaysimpl(double d) {
        return m1318toDoubleimpl(d, TimeUnit.DAYS);
    }

    /* renamed from: getInHours-impl  reason: not valid java name */
    public static final double m1295getInHoursimpl(double d) {
        return m1318toDoubleimpl(d, TimeUnit.HOURS);
    }

    /* renamed from: getInMinutes-impl  reason: not valid java name */
    public static final double m1298getInMinutesimpl(double d) {
        return m1318toDoubleimpl(d, TimeUnit.MINUTES);
    }

    /* renamed from: getInSeconds-impl  reason: not valid java name */
    public static final double m1300getInSecondsimpl(double d) {
        return m1318toDoubleimpl(d, TimeUnit.SECONDS);
    }

    /* renamed from: getInMilliseconds-impl  reason: not valid java name */
    public static final double m1297getInMillisecondsimpl(double d) {
        return m1318toDoubleimpl(d, TimeUnit.MILLISECONDS);
    }

    /* renamed from: getInMicroseconds-impl  reason: not valid java name */
    public static final double m1296getInMicrosecondsimpl(double d) {
        return m1318toDoubleimpl(d, TimeUnit.MICROSECONDS);
    }

    /* renamed from: getInNanoseconds-impl  reason: not valid java name */
    public static final double m1299getInNanosecondsimpl(double d) {
        return m1318toDoubleimpl(d, TimeUnit.NANOSECONDS);
    }

    /* renamed from: toLongNanoseconds-impl  reason: not valid java name */
    public static final long m1323toLongNanosecondsimpl(double d) {
        return m1321toLongimpl(d, TimeUnit.NANOSECONDS);
    }

    /* renamed from: toLongMilliseconds-impl  reason: not valid java name */
    public static final long m1322toLongMillisecondsimpl(double d) {
        return m1321toLongimpl(d, TimeUnit.MILLISECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a0  */
    /* renamed from: toString-impl  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m1324toStringimpl(double d) {
        TimeUnit timeUnit;
        int i;
        String formatToExactDecimals;
        if (m1306isInfiniteimpl(d)) {
            return String.valueOf(d);
        }
        if (d == 0.0d) {
            return "0s";
        }
        double m1299getInNanosecondsimpl = m1299getInNanosecondsimpl(m1292getAbsoluteValueUwyO8pc(d));
        boolean z = false;
        if (m1299getInNanosecondsimpl < 1.0E-6d) {
            timeUnit = TimeUnit.SECONDS;
        } else {
            if (m1299getInNanosecondsimpl < 1) {
                timeUnit = TimeUnit.NANOSECONDS;
                i = 7;
            } else {
                if (m1299getInNanosecondsimpl < 1000.0d) {
                    timeUnit = TimeUnit.NANOSECONDS;
                } else if (m1299getInNanosecondsimpl < 1000000.0d) {
                    timeUnit = TimeUnit.MICROSECONDS;
                } else if (m1299getInNanosecondsimpl < 1.0E9d) {
                    timeUnit = TimeUnit.MILLISECONDS;
                } else if (m1299getInNanosecondsimpl < 1.0E12d) {
                    timeUnit = TimeUnit.SECONDS;
                } else if (m1299getInNanosecondsimpl < 6.0E13d) {
                    timeUnit = TimeUnit.MINUTES;
                } else if (m1299getInNanosecondsimpl < 3.6E15d) {
                    timeUnit = TimeUnit.HOURS;
                } else if (m1299getInNanosecondsimpl < 8.64E20d) {
                    timeUnit = TimeUnit.DAYS;
                } else {
                    timeUnit = TimeUnit.DAYS;
                }
                i = 0;
            }
            double m1318toDoubleimpl = m1318toDoubleimpl(d, timeUnit);
            StringBuilder sb = new StringBuilder();
            if (!z) {
                formatToExactDecimals = FormatToDecimalsKt.formatScientific(m1318toDoubleimpl);
            } else if (i > 0) {
                formatToExactDecimals = FormatToDecimalsKt.formatUpToDecimals(m1318toDoubleimpl, i);
            } else {
                formatToExactDecimals = FormatToDecimalsKt.formatToExactDecimals(m1318toDoubleimpl, m1311precisionimpl(d, Math.abs(m1318toDoubleimpl)));
            }
            sb.append(formatToExactDecimals);
            sb.append(DurationUnitKt.shortName(timeUnit));
            return sb.toString();
        }
        i = 0;
        z = true;
        double m1318toDoubleimpl2 = m1318toDoubleimpl(d, timeUnit);
        StringBuilder sb2 = new StringBuilder();
        if (!z) {
        }
        sb2.append(formatToExactDecimals);
        sb2.append(DurationUnitKt.shortName(timeUnit));
        return sb2.toString();
    }

    /* renamed from: toString-impl$default  reason: not valid java name */
    public static /* synthetic */ String m1326toStringimpl$default(double d, TimeUnit timeUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m1325toStringimpl(d, timeUnit, i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static final String m1325toStringimpl(double d, TimeUnit unit, int i) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("decimals must be not negative, but was " + i).toString());
        } else if (m1306isInfiniteimpl(d)) {
            return String.valueOf(d);
        } else {
            double m1318toDoubleimpl = m1318toDoubleimpl(d, unit);
            StringBuilder sb = new StringBuilder();
            sb.append(Math.abs(m1318toDoubleimpl) < 1.0E14d ? FormatToDecimalsKt.formatToExactDecimals(m1318toDoubleimpl, RangesKt.coerceAtMost(i, 12)) : FormatToDecimalsKt.formatScientific(m1318toDoubleimpl));
            sb.append(DurationUnitKt.shortName(unit));
            return sb.toString();
        }
    }

    /* renamed from: toIsoString-impl  reason: not valid java name */
    public static final String m1320toIsoStringimpl(double d) {
        StringBuilder sb = new StringBuilder();
        if (m1307isNegativeimpl(d)) {
            sb.append('-');
        }
        sb.append("PT");
        double m1292getAbsoluteValueUwyO8pc = m1292getAbsoluteValueUwyO8pc(d);
        int m1295getInHoursimpl = (int) m1295getInHoursimpl(m1292getAbsoluteValueUwyO8pc);
        int m1301getMinutesComponentimpl = m1301getMinutesComponentimpl(m1292getAbsoluteValueUwyO8pc);
        int m1303getSecondsComponentimpl = m1303getSecondsComponentimpl(m1292getAbsoluteValueUwyO8pc);
        int m1302getNanosecondsComponentimpl = m1302getNanosecondsComponentimpl(m1292getAbsoluteValueUwyO8pc);
        boolean z = true;
        boolean z2 = m1295getInHoursimpl != 0;
        boolean z3 = (m1303getSecondsComponentimpl == 0 && m1302getNanosecondsComponentimpl == 0) ? false : true;
        if (m1301getMinutesComponentimpl == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(m1295getInHoursimpl);
            sb.append('H');
        }
        if (z) {
            sb.append(m1301getMinutesComponentimpl);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            sb.append(m1303getSecondsComponentimpl);
            if (m1302getNanosecondsComponentimpl != 0) {
                sb.append('.');
                String padStart = StringsKt.padStart(String.valueOf(m1302getNanosecondsComponentimpl), 9, '0');
                if (m1302getNanosecondsComponentimpl % 1000000 == 0) {
                    sb.append((CharSequence) padStart, 0, 3);
                    Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
                } else if (m1302getNanosecondsComponentimpl % 1000 == 0) {
                    sb.append((CharSequence) padStart, 0, 6);
                    Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
                } else {
                    sb.append(padStart);
                }
            }
            sb.append('S');
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
