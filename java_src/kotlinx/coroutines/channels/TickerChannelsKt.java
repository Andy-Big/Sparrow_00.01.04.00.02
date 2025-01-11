package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.EventLoop_commonKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.TimeSource;
import kotlinx.coroutines.TimeSourceKt;

/* compiled from: TickerChannels.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a/\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"fixedDelayTicker", "", "delayMillis", "", "initialDelayMillis", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedPeriodTicker", "ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "context", "Lkotlin/coroutines/CoroutineContext;", "mode", "Lkotlinx/coroutines/channels/TickerMode;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class TickerChannelsKt {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TickerMode.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TickerMode.FIXED_PERIOD.ordinal()] = 1;
            $EnumSwitchMapping$0[TickerMode.FIXED_DELAY.ordinal()] = 2;
        }
    }

    public static /* synthetic */ ReceiveChannel ticker$default(long j, long j2, CoroutineContext coroutineContext, TickerMode tickerMode, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        if ((i & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return ticker(j, j2, coroutineContext, tickerMode);
    }

    public static final ReceiveChannel<Unit> ticker(long j, long j2, CoroutineContext context, TickerMode mode) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
        }
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
        }
        return ProduceKt.produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(context), 0, new TickerChannelsKt$ticker$3(mode, j, j2, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00df A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0174 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0175  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0147 -> B:50:0x0148). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0175 -> B:50:0x0148). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final /* synthetic */ Object fixedPeriodTicker(long j, long j2, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        TickerChannelsKt$fixedPeriodTicker$1 tickerChannelsKt$fixedPeriodTicker$1;
        Object coroutine_suspended;
        int i;
        SendChannel<? super Unit> sendChannel2;
        long j3;
        long j4;
        Long boxLong;
        long delayToNanos;
        long j5;
        long j6;
        SendChannel<? super Unit> sendChannel3;
        long j7;
        char c;
        long j8;
        long nanoTime;
        TickerChannelsKt$fixedPeriodTicker$1 tickerChannelsKt$fixedPeriodTicker$12;
        long j9;
        long coerceAtLeast;
        long delayNanosToMillis;
        Long boxLong2;
        SendChannel<? super Unit> sendChannel4;
        Unit unit;
        long j10 = j2;
        if (continuation instanceof TickerChannelsKt$fixedPeriodTicker$1) {
            tickerChannelsKt$fixedPeriodTicker$1 = (TickerChannelsKt$fixedPeriodTicker$1) continuation;
            if ((tickerChannelsKt$fixedPeriodTicker$1.label & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedPeriodTicker$1.label -= Integer.MIN_VALUE;
                Object obj = tickerChannelsKt$fixedPeriodTicker$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = tickerChannelsKt$fixedPeriodTicker$1.label;
                int i2 = 2;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    TimeSource timeSource = TimeSourceKt.getTimeSource();
                    long nanoTime2 = ((timeSource == null || (boxLong = Boxing.boxLong(timeSource.nanoTime())) == null) ? System.nanoTime() : boxLong.longValue()) + EventLoop_commonKt.delayToNanos(j2);
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = j10;
                    sendChannel2 = sendChannel;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                    tickerChannelsKt$fixedPeriodTicker$1.J$2 = nanoTime2;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 1;
                    if (DelayKt.delay(j10, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j3 = nanoTime2;
                    j4 = j;
                } else if (i == 1) {
                    long j11 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                    long j12 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                    j4 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                    ResultKt.throwOnFailure(obj);
                    sendChannel2 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                    j10 = j12;
                    j3 = j11;
                } else if (i == 2) {
                    j7 = tickerChannelsKt$fixedPeriodTicker$1.J$3;
                    j8 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                    sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                    j6 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                    j5 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                    ResultKt.throwOnFailure(obj);
                    TimeSource timeSource2 = TimeSourceKt.getTimeSource();
                    nanoTime = (timeSource2 != null || (boxLong2 = Boxing.boxLong(timeSource2.nanoTime())) == null) ? System.nanoTime() : boxLong2.longValue();
                    tickerChannelsKt$fixedPeriodTicker$12 = tickerChannelsKt$fixedPeriodTicker$1;
                    j9 = j8;
                    coerceAtLeast = RangesKt.coerceAtLeast(j8 - nanoTime, 0L);
                    if (coerceAtLeast != 0) {
                    }
                    delayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                    tickerChannelsKt$fixedPeriodTicker$12.J$0 = j5;
                    tickerChannelsKt$fixedPeriodTicker$12.J$1 = j6;
                    tickerChannelsKt$fixedPeriodTicker$12.L$0 = sendChannel3;
                    long j13 = j6;
                    tickerChannelsKt$fixedPeriodTicker$12.J$2 = j9;
                    tickerChannelsKt$fixedPeriodTicker$12.J$3 = j7;
                    tickerChannelsKt$fixedPeriodTicker$12.J$4 = nanoTime;
                    tickerChannelsKt$fixedPeriodTicker$12.J$5 = coerceAtLeast;
                    c = 4;
                    tickerChannelsKt$fixedPeriodTicker$12.label = 4;
                    if (DelayKt.delay(delayNanosToMillis, tickerChannelsKt$fixedPeriodTicker$12) != coroutine_suspended) {
                    }
                } else if (i == 3) {
                    long j14 = tickerChannelsKt$fixedPeriodTicker$1.J$6;
                    long j15 = tickerChannelsKt$fixedPeriodTicker$1.J$5;
                    long j16 = tickerChannelsKt$fixedPeriodTicker$1.J$4;
                    j7 = tickerChannelsKt$fixedPeriodTicker$1.J$3;
                    j3 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                    sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                    j6 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                    j5 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                    ResultKt.throwOnFailure(obj);
                    c = 4;
                    long j17 = j6;
                    j4 = j5;
                    delayToNanos = j7;
                    j10 = j17;
                    sendChannel4 = sendChannel3;
                    i2 = 2;
                    j8 = j3 + delayToNanos;
                    unit = Unit.INSTANCE;
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j4;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = j10;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
                    tickerChannelsKt$fixedPeriodTicker$1.J$2 = j8;
                    tickerChannelsKt$fixedPeriodTicker$1.J$3 = delayToNanos;
                    tickerChannelsKt$fixedPeriodTicker$1.label = i2;
                    if (sendChannel4.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                    }
                } else if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    long j18 = tickerChannelsKt$fixedPeriodTicker$1.J$5;
                    long j19 = tickerChannelsKt$fixedPeriodTicker$1.J$4;
                    j7 = tickerChannelsKt$fixedPeriodTicker$1.J$3;
                    j3 = tickerChannelsKt$fixedPeriodTicker$1.J$2;
                    sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                    j6 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                    j5 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                    ResultKt.throwOnFailure(obj);
                    c = 4;
                    long j172 = j6;
                    j4 = j5;
                    delayToNanos = j7;
                    j10 = j172;
                    sendChannel4 = sendChannel3;
                    i2 = 2;
                    j8 = j3 + delayToNanos;
                    unit = Unit.INSTANCE;
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j4;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = j10;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
                    tickerChannelsKt$fixedPeriodTicker$1.J$2 = j8;
                    tickerChannelsKt$fixedPeriodTicker$1.J$3 = delayToNanos;
                    tickerChannelsKt$fixedPeriodTicker$1.label = i2;
                    if (sendChannel4.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sendChannel3 = sendChannel4;
                    long j20 = j10;
                    j7 = delayToNanos;
                    j5 = j4;
                    j6 = j20;
                    TimeSource timeSource22 = TimeSourceKt.getTimeSource();
                    nanoTime = (timeSource22 != null || (boxLong2 = Boxing.boxLong(timeSource22.nanoTime())) == null) ? System.nanoTime() : boxLong2.longValue();
                    tickerChannelsKt$fixedPeriodTicker$12 = tickerChannelsKt$fixedPeriodTicker$1;
                    j9 = j8;
                    coerceAtLeast = RangesKt.coerceAtLeast(j8 - nanoTime, 0L);
                    if (coerceAtLeast != 0 && j7 != 0) {
                        long j21 = j7 - ((nanoTime - j9) % j7);
                        long j22 = nanoTime + j21;
                        long delayNanosToMillis2 = EventLoop_commonKt.delayNanosToMillis(j21);
                        tickerChannelsKt$fixedPeriodTicker$12.J$0 = j5;
                        tickerChannelsKt$fixedPeriodTicker$12.J$1 = j6;
                        tickerChannelsKt$fixedPeriodTicker$12.L$0 = sendChannel3;
                        tickerChannelsKt$fixedPeriodTicker$12.J$2 = j22;
                        tickerChannelsKt$fixedPeriodTicker$12.J$3 = j7;
                        tickerChannelsKt$fixedPeriodTicker$12.J$4 = nanoTime;
                        tickerChannelsKt$fixedPeriodTicker$12.J$5 = coerceAtLeast;
                        tickerChannelsKt$fixedPeriodTicker$12.J$6 = j21;
                        tickerChannelsKt$fixedPeriodTicker$12.label = 3;
                        if (DelayKt.delay(delayNanosToMillis2, tickerChannelsKt$fixedPeriodTicker$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        tickerChannelsKt$fixedPeriodTicker$1 = tickerChannelsKt$fixedPeriodTicker$12;
                        j3 = j22;
                        c = 4;
                        long j1722 = j6;
                        j4 = j5;
                        delayToNanos = j7;
                        j10 = j1722;
                        sendChannel4 = sendChannel3;
                        i2 = 2;
                        j8 = j3 + delayToNanos;
                        unit = Unit.INSTANCE;
                        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j4;
                        tickerChannelsKt$fixedPeriodTicker$1.J$1 = j10;
                        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
                        tickerChannelsKt$fixedPeriodTicker$1.J$2 = j8;
                        tickerChannelsKt$fixedPeriodTicker$1.J$3 = delayToNanos;
                        tickerChannelsKt$fixedPeriodTicker$1.label = i2;
                        if (sendChannel4.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                        }
                    } else {
                        delayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                        tickerChannelsKt$fixedPeriodTicker$12.J$0 = j5;
                        tickerChannelsKt$fixedPeriodTicker$12.J$1 = j6;
                        tickerChannelsKt$fixedPeriodTicker$12.L$0 = sendChannel3;
                        long j132 = j6;
                        tickerChannelsKt$fixedPeriodTicker$12.J$2 = j9;
                        tickerChannelsKt$fixedPeriodTicker$12.J$3 = j7;
                        tickerChannelsKt$fixedPeriodTicker$12.J$4 = nanoTime;
                        tickerChannelsKt$fixedPeriodTicker$12.J$5 = coerceAtLeast;
                        c = 4;
                        tickerChannelsKt$fixedPeriodTicker$12.label = 4;
                        if (DelayKt.delay(delayNanosToMillis, tickerChannelsKt$fixedPeriodTicker$12) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        tickerChannelsKt$fixedPeriodTicker$1 = tickerChannelsKt$fixedPeriodTicker$12;
                        j3 = j9;
                        j6 = j132;
                        long j17222 = j6;
                        j4 = j5;
                        delayToNanos = j7;
                        j10 = j17222;
                        sendChannel4 = sendChannel3;
                        i2 = 2;
                        j8 = j3 + delayToNanos;
                        unit = Unit.INSTANCE;
                        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j4;
                        tickerChannelsKt$fixedPeriodTicker$1.J$1 = j10;
                        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
                        tickerChannelsKt$fixedPeriodTicker$1.J$2 = j8;
                        tickerChannelsKt$fixedPeriodTicker$1.J$3 = delayToNanos;
                        tickerChannelsKt$fixedPeriodTicker$1.label = i2;
                        if (sendChannel4.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                        }
                    }
                }
                delayToNanos = EventLoop_commonKt.delayToNanos(j4);
                sendChannel4 = sendChannel2;
                j8 = j3 + delayToNanos;
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j4;
                tickerChannelsKt$fixedPeriodTicker$1.J$1 = j10;
                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
                tickerChannelsKt$fixedPeriodTicker$1.J$2 = j8;
                tickerChannelsKt$fixedPeriodTicker$1.J$3 = delayToNanos;
                tickerChannelsKt$fixedPeriodTicker$1.label = i2;
                if (sendChannel4.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
                }
            }
        }
        tickerChannelsKt$fixedPeriodTicker$1 = new TickerChannelsKt$fixedPeriodTicker$1(continuation);
        Object obj2 = tickerChannelsKt$fixedPeriodTicker$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tickerChannelsKt$fixedPeriodTicker$1.label;
        int i22 = 2;
        if (i != 0) {
        }
        delayToNanos = EventLoop_commonKt.delayToNanos(j4);
        sendChannel4 = sendChannel2;
        j8 = j3 + delayToNanos;
        unit = Unit.INSTANCE;
        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j4;
        tickerChannelsKt$fixedPeriodTicker$1.J$1 = j10;
        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel4;
        tickerChannelsKt$fixedPeriodTicker$1.J$2 = j8;
        tickerChannelsKt$fixedPeriodTicker$1.J$3 = delayToNanos;
        tickerChannelsKt$fixedPeriodTicker$1.label = i22;
        if (sendChannel4.send(unit, tickerChannelsKt$fixedPeriodTicker$1) != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0090 -> B:14:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final /* synthetic */ Object fixedDelayTicker(long j, long j2, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        TickerChannelsKt$fixedDelayTicker$1 tickerChannelsKt$fixedDelayTicker$1;
        Object coroutine_suspended;
        int i;
        long j3;
        long j4;
        SendChannel<? super Unit> sendChannel2;
        Unit unit;
        if (continuation instanceof TickerChannelsKt$fixedDelayTicker$1) {
            tickerChannelsKt$fixedDelayTicker$1 = (TickerChannelsKt$fixedDelayTicker$1) continuation;
            if ((tickerChannelsKt$fixedDelayTicker$1.label & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedDelayTicker$1.label -= Integer.MIN_VALUE;
                Object obj = tickerChannelsKt$fixedDelayTicker$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = tickerChannelsKt$fixedDelayTicker$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                    tickerChannelsKt$fixedDelayTicker$1.J$1 = j2;
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                    tickerChannelsKt$fixedDelayTicker$1.label = 1;
                    if (DelayKt.delay(j2, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    sendChannel = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                    j2 = tickerChannelsKt$fixedDelayTicker$1.J$1;
                    j = tickerChannelsKt$fixedDelayTicker$1.J$0;
                    ResultKt.throwOnFailure(obj);
                } else if (i == 2) {
                    sendChannel2 = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                    j4 = tickerChannelsKt$fixedDelayTicker$1.J$1;
                    j3 = tickerChannelsKt$fixedDelayTicker$1.J$0;
                    ResultKt.throwOnFailure(obj);
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j3;
                    tickerChannelsKt$fixedDelayTicker$1.J$1 = j4;
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel2;
                    tickerChannelsKt$fixedDelayTicker$1.label = 3;
                    if (DelayKt.delay(j3, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sendChannel = sendChannel2;
                    j2 = j4;
                    j = j3;
                } else if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    sendChannel2 = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                    j4 = tickerChannelsKt$fixedDelayTicker$1.J$1;
                    j3 = tickerChannelsKt$fixedDelayTicker$1.J$0;
                    ResultKt.throwOnFailure(obj);
                    sendChannel = sendChannel2;
                    j2 = j4;
                    j = j3;
                }
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                tickerChannelsKt$fixedDelayTicker$1.J$1 = j2;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                tickerChannelsKt$fixedDelayTicker$1.label = 2;
                if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                long j5 = j;
                sendChannel2 = sendChannel;
                j4 = j2;
                j3 = j5;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j3;
                tickerChannelsKt$fixedDelayTicker$1.J$1 = j4;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel2;
                tickerChannelsKt$fixedDelayTicker$1.label = 3;
                if (DelayKt.delay(j3, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                }
                sendChannel = sendChannel2;
                j2 = j4;
                j = j3;
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
                tickerChannelsKt$fixedDelayTicker$1.J$1 = j2;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                tickerChannelsKt$fixedDelayTicker$1.label = 2;
                if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                }
            }
        }
        tickerChannelsKt$fixedDelayTicker$1 = new TickerChannelsKt$fixedDelayTicker$1(continuation);
        Object obj2 = tickerChannelsKt$fixedDelayTicker$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tickerChannelsKt$fixedDelayTicker$1.label;
        if (i != 0) {
        }
        unit = Unit.INSTANCE;
        tickerChannelsKt$fixedDelayTicker$1.J$0 = j;
        tickerChannelsKt$fixedDelayTicker$1.J$1 = j2;
        tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
        tickerChannelsKt$fixedDelayTicker$1.label = 2;
        if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
        }
    }
}
