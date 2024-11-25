package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Duration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010%\u001a\u00020\u0007*\u00020\b2\u0006\u0010&\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u001f\u0010%\u001a\u00020\u0007*\u00020\r2\u0006\u0010&\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a \u0010+\u001a\u00020\u0007*\u00020\b2\n\u0010,\u001a\u00060\u0001j\u0002`-H\u0007ø\u0001\u0000¢\u0006\u0002\u0010.\u001a \u0010+\u001a\u00020\u0007*\u00020\r2\n\u0010,\u001a\u00060\u0001j\u0002`-H\u0007ø\u0001\u0000¢\u0006\u0002\u0010/\u001a \u0010+\u001a\u00020\u0007*\u00020\u00102\n\u0010,\u001a\u00060\u0001j\u0002`-H\u0007ø\u0001\u0000¢\u0006\u0002\u00100\"\u001b\u0010\u0000\u001a\u00020\u00018Â\u0002X\u0082\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\u0006\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"!\u0010\u0006\u001a\u00020\u0007*\u00020\r8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\u000e\u001a\u0004\b\u000b\u0010\u000f\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00108FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012\"!\u0010\u0013\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"!\u0010\u0013\u001a\u00020\u0007*\u00020\r8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u000f\"!\u0010\u0013\u001a\u00020\u0007*\u00020\u00108FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0012\"!\u0010\u0016\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\f\"!\u0010\u0016\u001a\u00020\u0007*\u00020\r8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u000f\"!\u0010\u0016\u001a\u00020\u0007*\u00020\u00108FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0012\"!\u0010\u0019\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001a\u0010\n\u001a\u0004\b\u001b\u0010\f\"!\u0010\u0019\u001a\u00020\u0007*\u00020\r8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u000f\"!\u0010\u0019\u001a\u00020\u0007*\u00020\u00108FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0012\"!\u0010\u001c\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001d\u0010\n\u001a\u0004\b\u001e\u0010\f\"!\u0010\u001c\u001a\u00020\u0007*\u00020\r8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u000f\"!\u0010\u001c\u001a\u00020\u0007*\u00020\u00108FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0012\"!\u0010\u001f\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b \u0010\n\u001a\u0004\b!\u0010\f\"!\u0010\u001f\u001a\u00020\u0007*\u00020\r8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u000f\"!\u0010\u001f\u001a\u00020\u0007*\u00020\u00108FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0012\"!\u0010\"\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b#\u0010\n\u001a\u0004\b$\u0010\f\"!\u0010\"\u001a\u00020\u0007*\u00020\r8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b#\u0010\u000e\u001a\u0004\b$\u0010\u000f\"!\u0010\"\u001a\u00020\u0007*\u00020\u00108FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"storageUnit", "Ljava/util/concurrent/TimeUnit;", "getStorageUnit$annotations", "()V", "getStorageUnit", "()Ljava/util/concurrent/TimeUnit;", "days", "Lkotlin/time/Duration;", "", "getDays$annotations", "(D)V", "getDays", "(D)D", "", "(I)V", "(I)D", "", "(J)V", "(J)D", "hours", "getHours$annotations", "getHours", "microseconds", "getMicroseconds$annotations", "getMicroseconds", "milliseconds", "getMilliseconds$annotations", "getMilliseconds", "minutes", "getMinutes$annotations", "getMinutes", "nanoseconds", "getNanoseconds$annotations", "getNanoseconds", "seconds", "getSeconds$annotations", "getSeconds", "times", "duration", "times-kIfJnKk", "(DD)D", "times-mvk6XK0", "(ID)D", "toDuration", "unit", "Lkotlin/time/DurationUnit;", "(DLjava/util/concurrent/TimeUnit;)D", "(ILjava/util/concurrent/TimeUnit;)D", "(JLjava/util/concurrent/TimeUnit;)D", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class DurationKt {
    public static /* synthetic */ void getDays$annotations(double d) {
    }

    public static /* synthetic */ void getDays$annotations(int i) {
    }

    public static /* synthetic */ void getDays$annotations(long j) {
    }

    public static /* synthetic */ void getHours$annotations(double d) {
    }

    public static /* synthetic */ void getHours$annotations(int i) {
    }

    public static /* synthetic */ void getHours$annotations(long j) {
    }

    public static /* synthetic */ void getMicroseconds$annotations(double d) {
    }

    public static /* synthetic */ void getMicroseconds$annotations(int i) {
    }

    public static /* synthetic */ void getMicroseconds$annotations(long j) {
    }

    public static /* synthetic */ void getMilliseconds$annotations(double d) {
    }

    public static /* synthetic */ void getMilliseconds$annotations(int i) {
    }

    public static /* synthetic */ void getMilliseconds$annotations(long j) {
    }

    public static /* synthetic */ void getMinutes$annotations(double d) {
    }

    public static /* synthetic */ void getMinutes$annotations(int i) {
    }

    public static /* synthetic */ void getMinutes$annotations(long j) {
    }

    public static /* synthetic */ void getNanoseconds$annotations(double d) {
    }

    public static /* synthetic */ void getNanoseconds$annotations(int i) {
    }

    public static /* synthetic */ void getNanoseconds$annotations(long j) {
    }

    public static /* synthetic */ void getSeconds$annotations(double d) {
    }

    public static /* synthetic */ void getSeconds$annotations(int i) {
    }

    public static /* synthetic */ void getSeconds$annotations(long j) {
    }

    private static /* synthetic */ void getStorageUnit$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimeUnit getStorageUnit() {
        return TimeUnit.NANOSECONDS;
    }

    public static final double toDuration(int i, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return toDuration(i, unit);
    }

    public static final double toDuration(long j, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return toDuration(j, unit);
    }

    public static final double getNanoseconds(int i) {
        return toDuration(i, TimeUnit.NANOSECONDS);
    }

    public static final double getNanoseconds(long j) {
        return toDuration(j, TimeUnit.NANOSECONDS);
    }

    public static final double getNanoseconds(double d) {
        return toDuration(d, TimeUnit.NANOSECONDS);
    }

    public static final double getMicroseconds(int i) {
        return toDuration(i, TimeUnit.MICROSECONDS);
    }

    public static final double getMicroseconds(long j) {
        return toDuration(j, TimeUnit.MICROSECONDS);
    }

    public static final double getMicroseconds(double d) {
        return toDuration(d, TimeUnit.MICROSECONDS);
    }

    public static final double getMilliseconds(int i) {
        return toDuration(i, TimeUnit.MILLISECONDS);
    }

    public static final double getMilliseconds(long j) {
        return toDuration(j, TimeUnit.MILLISECONDS);
    }

    public static final double getMilliseconds(double d) {
        return toDuration(d, TimeUnit.MILLISECONDS);
    }

    public static final double getSeconds(int i) {
        return toDuration(i, TimeUnit.SECONDS);
    }

    public static final double getSeconds(long j) {
        return toDuration(j, TimeUnit.SECONDS);
    }

    public static final double getSeconds(double d) {
        return toDuration(d, TimeUnit.SECONDS);
    }

    public static final double getMinutes(int i) {
        return toDuration(i, TimeUnit.MINUTES);
    }

    public static final double getMinutes(long j) {
        return toDuration(j, TimeUnit.MINUTES);
    }

    public static final double getMinutes(double d) {
        return toDuration(d, TimeUnit.MINUTES);
    }

    public static final double getHours(int i) {
        return toDuration(i, TimeUnit.HOURS);
    }

    public static final double getHours(long j) {
        return toDuration(j, TimeUnit.HOURS);
    }

    public static final double getHours(double d) {
        return toDuration(d, TimeUnit.HOURS);
    }

    public static final double getDays(int i) {
        return toDuration(i, TimeUnit.DAYS);
    }

    public static final double getDays(long j) {
        return toDuration(j, TimeUnit.DAYS);
    }

    public static final double getDays(double d) {
        return toDuration(d, TimeUnit.DAYS);
    }

    /* renamed from: times-mvk6XK0  reason: not valid java name */
    private static final double m1333timesmvk6XK0(int i, double d) {
        return Duration.m1313timesUwyO8pc(d, i);
    }

    /* renamed from: times-kIfJnKk  reason: not valid java name */
    private static final double m1332timeskIfJnKk(double d, double d2) {
        return Duration.m1312timesUwyO8pc(d2, d);
    }

    public static final double toDuration(double d, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return Duration.m1286constructorimpl(DurationUnitKt.convertDurationUnit(d, unit, TimeUnit.NANOSECONDS));
    }
}
