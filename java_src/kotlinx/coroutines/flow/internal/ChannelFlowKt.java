package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
/* compiled from: ChannelFlow.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a[\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u00060\b2\u0006\u0010\n\u001a\u0002H\u0002H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00010\r\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u000eH\u0000\u001a&\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0010\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"withContextUndispatched", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "newContext", "Lkotlin/coroutines/CoroutineContext;", "countOrElement", "", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "value", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asChannelFlow", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/Flow;", "withUndispatchedContextCollector", "Lkotlinx/coroutines/flow/FlowCollector;", "emitContext", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ChannelFlowKt {
    public static final <T> ChannelFlow<T> asChannelFlow(Flow<? extends T> asChannelFlow) {
        Intrinsics.checkParameterIsNotNull(asChannelFlow, "$this$asChannelFlow");
        ChannelFlow<T> channelFlow = (ChannelFlow) (!(asChannelFlow instanceof ChannelFlow) ? null : asChannelFlow);
        return channelFlow != null ? channelFlow : new ChannelFlowOperatorImpl(asChannelFlow, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> FlowCollector<T> withUndispatchedContextCollector(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        return ((flowCollector instanceof SendingCollector) || (flowCollector instanceof NopCollector)) ? flowCollector : new UndispatchedContextCollector(flowCollector, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object withContextUndispatched$default(CoroutineContext coroutineContext, Object obj, Function2 function2, Object obj2, Continuation continuation, int i, Object obj3) {
        if ((i & 2) != 0) {
            obj = ThreadContextKt.threadContextElements(coroutineContext);
        }
        return withContextUndispatched(coroutineContext, obj, function2, obj2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ <T, V> Object withContextUndispatched(final CoroutineContext coroutineContext, final Object obj, final Function2<? super V, ? super Continuation<? super T>, ? extends Object> function2, final V v, final Continuation<? super T> continuation) {
        Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, obj);
        try {
            Continuation<T> continuation2 = new Continuation<T>() { // from class: kotlinx.coroutines.flow.internal.ChannelFlowKt$withContextUndispatched$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
                @Override // kotlin.coroutines.Continuation
                public CoroutineContext getContext() {
                    return CoroutineContext.this;
                }

                @Override // kotlin.coroutines.Continuation
                public void resumeWith(Object obj2) {
                    continuation.resumeWith(obj2);
                }
            };
            if (function2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            }
            Object invoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(v, continuation2);
            ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
            if (invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return invoke;
        } catch (Throwable th) {
            ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
            throw th;
        }
    }
}
