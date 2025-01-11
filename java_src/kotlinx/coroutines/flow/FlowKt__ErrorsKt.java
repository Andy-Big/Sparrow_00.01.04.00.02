package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.sun.mail.imap.IMAPStore;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

/* compiled from: Errors.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aj\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012B\u0010\u0003\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a1\u0010\u000f\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u0012\u001a\u00020\u0013*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¢\u0006\u0002\b\u0016\u001a\u001b\u0010\u0017\u001a\u00020\u0013*\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\b\u0019\u001aB\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u001dH\u0007\u001a>\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u001dH\u0007\u001ae\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020!23\b\u0002\u0010\u001c\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\"H\u0007ø\u0001\u0000¢\u0006\u0002\u0010#\u001a\u007f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012W\u0010\u001c\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110!¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\f0%¢\u0006\u0002\b\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010'*\\\b\u0007\u0010(\"\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u001d2\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u001dB6\b)\u0012\n\b*\u0012\u0006\b\n0+8,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u001c\b/\u0012\u0018\b\u000bB\u0014\b0\u0012\u0006\b1\u0012\u0002\b\f\u0012\b\b2\u0012\u0004\b\b(3\u0082\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"catch", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ParameterName;", IMAPStore.ID_NAME, "cause", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "catchImpl", "collector", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCancellationCause", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "isCancellationCause$FlowKt__ErrorsKt", "isSameExceptionAs", "other", "isSameExceptionAs$FlowKt__ErrorsKt", "onErrorCollect", "fallback", "predicate", "Lkotlin/Function1;", "retry", "retries", "", "", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;JLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "retryWhen", "Lkotlin/Function4;", "attempt", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "ExceptionPredicate", "Lkotlin/Deprecated;", "level", "Lkotlin/DeprecationLevel;", "ERROR", "message", "Use (Throwable) -> Boolean functional type", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "expression", "(Throwable) -> Boolean", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes2.dex */
final /* synthetic */ class FlowKt__ErrorsKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use (Throwable) -> Boolean functional type", replaceWith = @ReplaceWith(expression = "(Throwable) -> Boolean", imports = {}))
    public static /* synthetic */ void ExceptionPredicate$annotations() {
    }

    public static /* synthetic */ Flow onErrorCollect$default(Flow flow, Flow flow2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<Throwable, Boolean>() { // from class: kotlinx.coroutines.flow.FlowKt__ErrorsKt$onErrorCollect$1
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
                    return Boolean.valueOf(invoke2(th));
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final boolean invoke2(Throwable it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    return true;
                }
            };
        }
        return FlowKt.onErrorCollect(flow, flow2, function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", imports = {}))
    public static final <T> Flow<T> onErrorCollect(Flow<? extends T> onErrorCollect, Flow<? extends T> fallback, Function1<? super Throwable, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(onErrorCollect, "$this$onErrorCollect");
        Intrinsics.checkParameterIsNotNull(fallback, "fallback");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        return FlowKt.m1359catch(onErrorCollect, new FlowKt__ErrorsKt$onErrorCollect$2(predicate, fallback, null));
    }

    public static /* synthetic */ Flow retry$default(Flow flow, long j, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = LongCompanionObject.MAX_VALUE;
        }
        if ((i & 2) != 0) {
            function2 = new FlowKt__ErrorsKt$retry$1(null);
        }
        return FlowKt.retry(flow, j, function2);
    }

    public static final <T> Flow<T> retry(Flow<? extends T> retry, long j, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        Intrinsics.checkParameterIsNotNull(retry, "$this$retry");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        if (!(j > 0)) {
            throw new IllegalArgumentException(("Expected positive amount of retries, but had " + j).toString());
        }
        return FlowKt.retryWhen(retry, new FlowKt__ErrorsKt$retry$3(j, predicate, null));
    }

    public static /* synthetic */ Flow retry$default(Flow flow, int i, Function1 function1, int i2, Object obj) {
        Flow retry;
        if ((i2 & 1) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i2 & 2) != 0) {
            function1 = new Function1<Throwable, Boolean>() { // from class: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$4
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
                    return Boolean.valueOf(invoke2(th));
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final boolean invoke2(Throwable it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    return true;
                }
            };
        }
        retry = retry(flow, i, function1);
        return retry;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "binary compatibility with retries: Int preview version")
    public static final /* synthetic */ <T> Flow<T> retry(Flow<? extends T> retry, int i, Function1<? super Throwable, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(retry, "$this$retry");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        if (!(i > 0)) {
            throw new IllegalArgumentException(("Expected positive amount of retries, but had " + i).toString());
        }
        return FlowKt.retryWhen(retry, new FlowKt__ErrorsKt$retry$6(i, predicate, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object catchImpl(Flow<? extends T> flow, FlowCollector<? super T> flowCollector, Continuation<? super Throwable> continuation) {
        FlowKt__ErrorsKt$catchImpl$1 flowKt__ErrorsKt$catchImpl$1;
        int i;
        Ref.ObjectRef objectRef;
        if (continuation instanceof FlowKt__ErrorsKt$catchImpl$1) {
            flowKt__ErrorsKt$catchImpl$1 = (FlowKt__ErrorsKt$catchImpl$1) continuation;
            if ((flowKt__ErrorsKt$catchImpl$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__ErrorsKt$catchImpl$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__ErrorsKt$catchImpl$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ErrorsKt$catchImpl$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = (T) null;
                    try {
                        flowKt__ErrorsKt$catchImpl$1.L$0 = flow;
                        flowKt__ErrorsKt$catchImpl$1.L$1 = flowCollector;
                        flowKt__ErrorsKt$catchImpl$1.L$2 = objectRef2;
                        flowKt__ErrorsKt$catchImpl$1.L$3 = flow;
                        flowKt__ErrorsKt$catchImpl$1.label = 1;
                        if (flow.collect(new FlowKt__ErrorsKt$catchImpl$$inlined$collect$1<>(flowCollector, objectRef2), flowKt__ErrorsKt$catchImpl$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th) {
                        th = th;
                        objectRef = objectRef2;
                        if (!isSameExceptionAs$FlowKt__ErrorsKt(th, (Throwable) objectRef.element) || isCancellationCause$FlowKt__ErrorsKt(th, flowKt__ErrorsKt$catchImpl$1.getContext())) {
                            throw th;
                        }
                        return th;
                    }
                } else if (i == 1) {
                    Flow flow2 = (Flow) flowKt__ErrorsKt$catchImpl$1.L$3;
                    objectRef = (Ref.ObjectRef) flowKt__ErrorsKt$catchImpl$1.L$2;
                    FlowCollector flowCollector2 = (FlowCollector) flowKt__ErrorsKt$catchImpl$1.L$1;
                    Flow flow3 = (Flow) flowKt__ErrorsKt$catchImpl$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        if (isSameExceptionAs$FlowKt__ErrorsKt(th, (Throwable) objectRef.element)) {
                        }
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return null;
            }
        }
        flowKt__ErrorsKt$catchImpl$1 = new FlowKt__ErrorsKt$catchImpl$1(continuation);
        Object obj2 = flowKt__ErrorsKt$catchImpl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ErrorsKt$catchImpl$1.label;
        if (i != 0) {
        }
        return null;
    }

    private static final boolean isCancellationCause$FlowKt__ErrorsKt(Throwable th, CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job == null || !job.isCancelled()) {
            return false;
        }
        return isSameExceptionAs$FlowKt__ErrorsKt(th, job.getCancellationException());
    }

    private static final boolean isSameExceptionAs$FlowKt__ErrorsKt(Throwable th, Throwable th2) {
        return th2 != null && Intrinsics.areEqual(StackTraceRecoveryKt.unwrap(th2), StackTraceRecoveryKt.unwrap(th));
    }

    /* renamed from: catch */
    public static final <T> Flow<T> m1360catch(Flow<? extends T> flow, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> action) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$catch");
        Intrinsics.checkParameterIsNotNull(action, "action");
        return new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(flow, action);
    }

    public static final <T> Flow<T> retryWhen(Flow<? extends T> retryWhen, Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        Intrinsics.checkParameterIsNotNull(retryWhen, "$this$retryWhen");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        return new FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(retryWhen, predicate);
    }
}
