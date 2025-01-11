package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.ValueOrClosed;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;

/* compiled from: Channels.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a0\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\nH\u0007\u001a/\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a&\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/BroadcastChannel;", "broadcastIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "start", "Lkotlinx/coroutines/CoroutineStart;", "consumeAsFlow", "Lkotlinx/coroutines/channels/ReceiveChannel;", "emitAll", "", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produceIn", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes2.dex */
final /* synthetic */ class FlowKt__ChannelsKt {
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0082 A[Catch: all -> 0x0059, TRY_LEAVE, TryCatch #1 {all -> 0x0059, blocks: (B:58:0x0037, B:68:0x0061, B:72:0x0076, B:74:0x0082, B:78:0x008e, B:79:0x008f, B:63:0x0055), top: B:88:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x008f A[Catch: all -> 0x0059, TRY_LEAVE, TryCatch #1 {all -> 0x0059, blocks: (B:58:0x0037, B:68:0x0061, B:72:0x0076, B:74:0x0082, B:78:0x008e, B:79:0x008f, B:63:0x0055), top: B:88:0x0023 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x00a1 -> B:59:0x003a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object emitAll(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, Continuation<? super Unit> continuation) {
        FlowKt__ChannelsKt$emitAll$1 flowKt__ChannelsKt$emitAll$1;
        int i;
        Throwable th;
        Throwable th2;
        FlowCollector flowCollector2;
        Object m1358unboximpl;
        Object receiveOrClosed;
        try {
            if (continuation instanceof FlowKt__ChannelsKt$emitAll$1) {
                flowKt__ChannelsKt$emitAll$1 = (FlowKt__ChannelsKt$emitAll$1) continuation;
                if ((flowKt__ChannelsKt$emitAll$1.label & Integer.MIN_VALUE) != 0) {
                    flowKt__ChannelsKt$emitAll$1.label -= Integer.MIN_VALUE;
                    Object obj = flowKt__ChannelsKt$emitAll$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = flowKt__ChannelsKt$emitAll$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        th = null;
                        flowKt__ChannelsKt$emitAll$1.L$0 = flowCollector;
                        flowKt__ChannelsKt$emitAll$1.L$1 = receiveChannel;
                        flowKt__ChannelsKt$emitAll$1.L$2 = th;
                        flowKt__ChannelsKt$emitAll$1.L$3 = flowCollector;
                        flowKt__ChannelsKt$emitAll$1.label = 1;
                        receiveOrClosed = receiveChannel.receiveOrClosed(flowKt__ChannelsKt$emitAll$1);
                        if (receiveOrClosed == coroutine_suspended) {
                        }
                    } else if (i == 1) {
                        FlowCollector flowCollector3 = (FlowCollector) flowKt__ChannelsKt$emitAll$1.L$3;
                        th2 = (Throwable) flowKt__ChannelsKt$emitAll$1.L$2;
                        receiveChannel = (ReceiveChannel) flowKt__ChannelsKt$emitAll$1.L$1;
                        FlowCollector flowCollector4 = (FlowCollector) flowKt__ChannelsKt$emitAll$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        flowCollector2 = flowCollector4;
                        m1358unboximpl = ((ValueOrClosed) obj).m1358unboximpl();
                        if (!ValueOrClosed.m1356isClosedimpl(m1358unboximpl)) {
                        }
                    } else if (i == 2) {
                        Object obj2 = flowKt__ChannelsKt$emitAll$1.L$3;
                        th2 = (Throwable) flowKt__ChannelsKt$emitAll$1.L$2;
                        receiveChannel = (ReceiveChannel) flowKt__ChannelsKt$emitAll$1.L$1;
                        FlowCollector<? super T> flowCollector5 = (FlowCollector) flowKt__ChannelsKt$emitAll$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        FlowCollector<? super T> flowCollector6 = flowCollector5;
                        th = th2;
                        flowCollector = flowCollector6;
                        flowKt__ChannelsKt$emitAll$1.L$0 = flowCollector;
                        flowKt__ChannelsKt$emitAll$1.L$1 = receiveChannel;
                        flowKt__ChannelsKt$emitAll$1.L$2 = th;
                        flowKt__ChannelsKt$emitAll$1.L$3 = flowCollector;
                        flowKt__ChannelsKt$emitAll$1.label = 1;
                        receiveOrClosed = receiveChannel.receiveOrClosed(flowKt__ChannelsKt$emitAll$1);
                        if (receiveOrClosed == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowCollector2 = flowCollector;
                        th2 = th;
                        obj = receiveOrClosed;
                        m1358unboximpl = ((ValueOrClosed) obj).m1358unboximpl();
                        if (!ValueOrClosed.m1356isClosedimpl(m1358unboximpl)) {
                            Throwable m1352getCloseCauseimpl = ValueOrClosed.m1352getCloseCauseimpl(m1358unboximpl);
                            if (m1352getCloseCauseimpl != null) {
                                throw m1352getCloseCauseimpl;
                            }
                            ChannelsKt.cancelConsumed(receiveChannel, th2);
                            return Unit.INSTANCE;
                        }
                        flowKt__ChannelsKt$emitAll$1.L$0 = flowCollector2;
                        flowKt__ChannelsKt$emitAll$1.L$1 = receiveChannel;
                        flowKt__ChannelsKt$emitAll$1.L$2 = th2;
                        flowKt__ChannelsKt$emitAll$1.L$3 = m1358unboximpl;
                        flowKt__ChannelsKt$emitAll$1.label = 2;
                        Object emit = flowCollector2.emit((Object) ValueOrClosed.m1353getValueimpl(m1358unboximpl), flowKt__ChannelsKt$emitAll$1);
                        flowCollector6 = flowCollector2;
                        if (emit == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        th = th2;
                        flowCollector = flowCollector6;
                        flowKt__ChannelsKt$emitAll$1.L$0 = flowCollector;
                        flowKt__ChannelsKt$emitAll$1.L$1 = receiveChannel;
                        flowKt__ChannelsKt$emitAll$1.L$2 = th;
                        flowKt__ChannelsKt$emitAll$1.L$3 = flowCollector;
                        flowKt__ChannelsKt$emitAll$1.label = 1;
                        receiveOrClosed = receiveChannel.receiveOrClosed(flowKt__ChannelsKt$emitAll$1);
                        if (receiveOrClosed == coroutine_suspended) {
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            if (i != 0) {
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                ChannelsKt.cancelConsumed(receiveChannel, th3);
                throw th4;
            }
        }
        flowKt__ChannelsKt$emitAll$1 = new FlowKt__ChannelsKt$emitAll$1(continuation);
        Object obj3 = flowKt__ChannelsKt$emitAll$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ChannelsKt$emitAll$1.label;
    }

    public static final <T> Flow<T> consumeAsFlow(ReceiveChannel<? extends T> consumeAsFlow) {
        Intrinsics.checkParameterIsNotNull(consumeAsFlow, "$this$consumeAsFlow");
        return new ConsumeAsFlow(consumeAsFlow, null, 0, 6, null);
    }

    public static /* synthetic */ BroadcastChannel broadcastIn$default(Flow flow, CoroutineScope coroutineScope, CoroutineStart coroutineStart, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return FlowKt.broadcastIn(flow, coroutineScope, coroutineStart);
    }

    public static final <T> BroadcastChannel<T> broadcastIn(Flow<? extends T> broadcastIn, CoroutineScope scope, CoroutineStart start) {
        Intrinsics.checkParameterIsNotNull(broadcastIn, "$this$broadcastIn");
        Intrinsics.checkParameterIsNotNull(scope, "scope");
        Intrinsics.checkParameterIsNotNull(start, "start");
        return ChannelFlowKt.asChannelFlow(broadcastIn).broadcastImpl(scope, start);
    }

    public static final <T> ReceiveChannel<T> produceIn(Flow<? extends T> produceIn, CoroutineScope scope) {
        Intrinsics.checkParameterIsNotNull(produceIn, "$this$produceIn");
        Intrinsics.checkParameterIsNotNull(scope, "scope");
        return ChannelFlowKt.asChannelFlow(produceIn).produceImpl(scope);
    }

    public static final <T> Flow<T> asFlow(final BroadcastChannel<T> asFlow) {
        Intrinsics.checkParameterIsNotNull(asFlow, "$this$asFlow");
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ChannelsKt$asFlow$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                return FlowKt.emitAll(flowCollector, BroadcastChannel.this.openSubscription(), continuation);
            }
        };
    }
}
