package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SlidingWindow.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/SequenceScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "$this$iterator", "bufferInitialCapacity", "gap", "buffer"}, s = {"L$0", "I$0", "I$1", "L$1", "I$2", "L$2", "L$0", "I$0", "I$1", "L$1", "I$2", "L$0", "I$0", "I$1", "L$1", "L$2", "L$0", "I$0", "I$1", "L$1", "L$0", "I$0", "I$1", "L$1"})
/* loaded from: classes2.dex */
final class SlidingWindowKt$windowedIterator$1<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Iterator $iterator;
    final /* synthetic */ boolean $partialWindows;
    final /* synthetic */ boolean $reuseBuffer;
    final /* synthetic */ int $size;
    final /* synthetic */ int $step;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    private SequenceScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SlidingWindowKt$windowedIterator$1(int i, int i2, Iterator it, boolean z, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.$size = i;
        this.$step = i2;
        this.$iterator = it;
        this.$reuseBuffer = z;
        this.$partialWindows = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, completion);
        slidingWindowKt$windowedIterator$1.p$ = (SequenceScope) obj;
        return slidingWindowKt$windowedIterator$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((SlidingWindowKt$windowedIterator$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x018f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00bf -> B:31:0x00c1). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x014d -> B:60:0x0150). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0186 -> B:73:0x0189). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        int i;
        RingBuffer ringBuffer;
        SequenceScope sequenceScope2;
        SlidingWindowKt$windowedIterator$1<T> slidingWindowKt$windowedIterator$1;
        int i2;
        Iterator it;
        ArrayList arrayList;
        int i3;
        SlidingWindowKt$windowedIterator$1<T> slidingWindowKt$windowedIterator$12;
        int i4;
        Iterator it2;
        RingBuffer ringBuffer2;
        int i5;
        int i6;
        SequenceScope sequenceScope3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i7 = this.label;
        if (i7 == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = this.p$;
            int coerceAtMost = RangesKt.coerceAtMost(this.$size, 1024);
            i = this.$step - this.$size;
            if (i >= 0) {
                arrayList = new ArrayList(coerceAtMost);
                i3 = 0;
                slidingWindowKt$windowedIterator$12 = this;
                i4 = coerceAtMost;
                it2 = this.$iterator;
                while (it2.hasNext()) {
                }
                if (!arrayList.isEmpty()) {
                    slidingWindowKt$windowedIterator$12.L$0 = sequenceScope;
                    slidingWindowKt$windowedIterator$12.I$0 = i4;
                    slidingWindowKt$windowedIterator$12.I$1 = i;
                    slidingWindowKt$windowedIterator$12.L$1 = arrayList;
                    slidingWindowKt$windowedIterator$12.I$2 = i3;
                    slidingWindowKt$windowedIterator$12.label = 2;
                    if (sequenceScope.yield(arrayList, slidingWindowKt$windowedIterator$12) == coroutine_suspended) {
                    }
                }
                return Unit.INSTANCE;
            }
            ringBuffer = new RingBuffer(coerceAtMost);
            sequenceScope2 = sequenceScope;
            slidingWindowKt$windowedIterator$1 = this;
            i2 = coerceAtMost;
            it = this.$iterator;
            while (it.hasNext()) {
            }
            if (slidingWindowKt$windowedIterator$1.$partialWindows) {
            }
            return Unit.INSTANCE;
        } else if (i7 == 1) {
            it2 = (Iterator) this.L$3;
            arrayList = (ArrayList) this.L$1;
            i3 = this.I$1;
            i4 = this.I$0;
            SequenceScope sequenceScope4 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            slidingWindowKt$windowedIterator$12 = this;
            if (slidingWindowKt$windowedIterator$12.$reuseBuffer) {
                arrayList = new ArrayList(slidingWindowKt$windowedIterator$12.$size);
            } else {
                arrayList.clear();
            }
            sequenceScope = sequenceScope4;
            i = i3;
            while (it2.hasNext()) {
                Object next = it2.next();
                if (i3 > 0) {
                    i3--;
                } else {
                    arrayList.add(next);
                    if (arrayList.size() == slidingWindowKt$windowedIterator$12.$size) {
                        slidingWindowKt$windowedIterator$12.L$0 = sequenceScope;
                        slidingWindowKt$windowedIterator$12.I$0 = i4;
                        slidingWindowKt$windowedIterator$12.I$1 = i;
                        slidingWindowKt$windowedIterator$12.L$1 = arrayList;
                        slidingWindowKt$windowedIterator$12.I$2 = i3;
                        slidingWindowKt$windowedIterator$12.L$2 = next;
                        slidingWindowKt$windowedIterator$12.L$3 = it2;
                        slidingWindowKt$windowedIterator$12.label = 1;
                        if (sequenceScope.yield(arrayList, slidingWindowKt$windowedIterator$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i3 = i;
                        sequenceScope4 = sequenceScope;
                        if (slidingWindowKt$windowedIterator$12.$reuseBuffer) {
                        }
                        sequenceScope = sequenceScope4;
                        i = i3;
                        while (it2.hasNext()) {
                        }
                    }
                }
            }
            if ((!arrayList.isEmpty()) && (slidingWindowKt$windowedIterator$12.$partialWindows || arrayList.size() == slidingWindowKt$windowedIterator$12.$size)) {
                slidingWindowKt$windowedIterator$12.L$0 = sequenceScope;
                slidingWindowKt$windowedIterator$12.I$0 = i4;
                slidingWindowKt$windowedIterator$12.I$1 = i;
                slidingWindowKt$windowedIterator$12.L$1 = arrayList;
                slidingWindowKt$windowedIterator$12.I$2 = i3;
                slidingWindowKt$windowedIterator$12.label = 2;
                if (sequenceScope.yield(arrayList, slidingWindowKt$windowedIterator$12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } else {
            if (i7 == 2) {
                ArrayList arrayList2 = (ArrayList) this.L$1;
            } else if (i7 == 3) {
                it = (Iterator) this.L$3;
                ringBuffer = (RingBuffer) this.L$1;
                i = this.I$1;
                i2 = this.I$0;
                sequenceScope2 = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                slidingWindowKt$windowedIterator$1 = this;
                ringBuffer.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                while (it.hasNext()) {
                    Object next2 = it.next();
                    ringBuffer.add((RingBuffer) next2);
                    if (ringBuffer.isFull()) {
                        int size = ringBuffer.size();
                        int i8 = slidingWindowKt$windowedIterator$1.$size;
                        if (size >= i8) {
                            List arrayList3 = slidingWindowKt$windowedIterator$1.$reuseBuffer ? ringBuffer : new ArrayList(ringBuffer);
                            slidingWindowKt$windowedIterator$1.L$0 = sequenceScope2;
                            slidingWindowKt$windowedIterator$1.I$0 = i2;
                            slidingWindowKt$windowedIterator$1.I$1 = i;
                            slidingWindowKt$windowedIterator$1.L$1 = ringBuffer;
                            slidingWindowKt$windowedIterator$1.L$2 = next2;
                            slidingWindowKt$windowedIterator$1.L$3 = it;
                            slidingWindowKt$windowedIterator$1.label = 3;
                            if (sequenceScope2.yield(arrayList3, slidingWindowKt$windowedIterator$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ringBuffer.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                            while (it.hasNext()) {
                            }
                        } else {
                            ringBuffer = ringBuffer.expanded(i8);
                        }
                    }
                }
                if (slidingWindowKt$windowedIterator$1.$partialWindows) {
                    ringBuffer2 = ringBuffer;
                    i5 = i;
                    i6 = i2;
                    sequenceScope3 = sequenceScope2;
                    if (ringBuffer2.size() <= slidingWindowKt$windowedIterator$1.$step) {
                    }
                }
                return Unit.INSTANCE;
            } else if (i7 == 4) {
                ringBuffer2 = (RingBuffer) this.L$1;
                i5 = this.I$1;
                i6 = this.I$0;
                sequenceScope3 = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                slidingWindowKt$windowedIterator$1 = this;
                ringBuffer2.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                if (ringBuffer2.size() <= slidingWindowKt$windowedIterator$1.$step) {
                    List arrayList4 = slidingWindowKt$windowedIterator$1.$reuseBuffer ? ringBuffer2 : new ArrayList(ringBuffer2);
                    slidingWindowKt$windowedIterator$1.L$0 = sequenceScope3;
                    slidingWindowKt$windowedIterator$1.I$0 = i6;
                    slidingWindowKt$windowedIterator$1.I$1 = i5;
                    slidingWindowKt$windowedIterator$1.L$1 = ringBuffer2;
                    slidingWindowKt$windowedIterator$1.label = 4;
                    if (sequenceScope3.yield(arrayList4, slidingWindowKt$windowedIterator$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ringBuffer2.removeFirst(slidingWindowKt$windowedIterator$1.$step);
                    if (ringBuffer2.size() <= slidingWindowKt$windowedIterator$1.$step) {
                        if (!ringBuffer2.isEmpty()) {
                            slidingWindowKt$windowedIterator$1.L$0 = sequenceScope3;
                            slidingWindowKt$windowedIterator$1.I$0 = i6;
                            slidingWindowKt$windowedIterator$1.I$1 = i5;
                            slidingWindowKt$windowedIterator$1.L$1 = ringBuffer2;
                            slidingWindowKt$windowedIterator$1.label = 5;
                            if (sequenceScope3.yield(ringBuffer2, slidingWindowKt$windowedIterator$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }
            } else if (i7 != 5) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                RingBuffer ringBuffer3 = (RingBuffer) this.L$1;
            }
            SequenceScope sequenceScope5 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }
}
