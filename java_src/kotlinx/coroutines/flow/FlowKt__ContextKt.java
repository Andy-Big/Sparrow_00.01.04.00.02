package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
/* compiled from: Context.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\u0004\u001a(\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0006H\u0007\u001a&\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a[\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0006\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\u00070\u00062\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\t2#\u0010\u0010\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u00060\u0011¢\u0006\u0002\b\u0012H\u0007¨\u0006\u0013"}, d2 = {"checkFlowContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "checkFlowContext$FlowKt__ContextKt", "buffer", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "capacity", "", "conflate", "flowOn", "flowWith", "R", "flowContext", "bufferSize", "builder", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes2.dex */
public final /* synthetic */ class FlowKt__ContextKt {
    public static /* synthetic */ Flow buffer$default(Flow flow, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        return FlowKt.buffer(flow, i);
    }

    public static final <T> Flow<T> buffer(Flow<? extends T> buffer, int i) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$buffer");
        if (!(i >= 0 || i == -2 || i == -1)) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i).toString());
        } else if (buffer instanceof ChannelFlow) {
            return ChannelFlow.update$default((ChannelFlow) buffer, null, i, 1, null);
        } else {
            return new ChannelFlowOperatorImpl(buffer, null, i, 2, null);
        }
    }

    public static final <T> Flow<T> conflate(Flow<? extends T> conflate) {
        Intrinsics.checkParameterIsNotNull(conflate, "$this$conflate");
        return FlowKt.buffer(conflate, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Flow<T> flowOn(Flow<? extends T> flowOn, CoroutineContext context) {
        Intrinsics.checkParameterIsNotNull(flowOn, "$this$flowOn");
        Intrinsics.checkParameterIsNotNull(context, "context");
        checkFlowContext$FlowKt__ContextKt(context);
        return Intrinsics.areEqual(context, EmptyCoroutineContext.INSTANCE) ? flowOn : flowOn instanceof ChannelFlow ? ChannelFlow.update$default((ChannelFlow) flowOn, context, 0, 2, null) : new ChannelFlowOperatorImpl(flowOn, context, 0, 4, null);
    }

    public static /* synthetic */ Flow flowWith$default(Flow flow, CoroutineContext coroutineContext, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -2;
        }
        return FlowKt.flowWith(flow, coroutineContext, i, function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "flowWith is deprecated without replacement, please refer to its KDoc for an explanation")
    public static final <T, R> Flow<R> flowWith(final Flow<? extends T> flowWith, final CoroutineContext flowContext, final int i, final Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> builder) {
        Intrinsics.checkParameterIsNotNull(flowWith, "$this$flowWith");
        Intrinsics.checkParameterIsNotNull(flowContext, "flowContext");
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        checkFlowContext$FlowKt__ContextKt(flowContext);
        return new Flow<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ContextKt$flowWith$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(final FlowCollector flowCollector, Continuation continuation) {
                return FlowKt.buffer(FlowKt.flowOn((Flow) builder.invoke(FlowKt.buffer(FlowKt.flowOn(Flow.this, continuation.getContext().minusKey(Job.Key)), i)), flowContext), i).collect(new FlowCollector<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ContextKt$flowWith$$inlined$unsafeFlow$1$lambda$1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(Object obj, Continuation continuation2) {
                        return FlowCollector.this.emit(obj, continuation2);
                    }
                }, continuation);
            }
        };
    }

    private static final void checkFlowContext$FlowKt__ContextKt(CoroutineContext coroutineContext) {
        if (coroutineContext.get(Job.Key) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + coroutineContext).toString());
    }
}
