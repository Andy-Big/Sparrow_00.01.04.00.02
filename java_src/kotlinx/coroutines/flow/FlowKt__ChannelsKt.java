package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;
/* compiled from: Channels.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a0\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\nH\u0007\u001a/\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a&\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/BroadcastChannel;", "broadcastIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "start", "Lkotlinx/coroutines/CoroutineStart;", "consumeAsFlow", "Lkotlinx/coroutines/channels/ReceiveChannel;", "emitAll", "", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produceIn", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes2.dex */
public final /* synthetic */ class FlowKt__ChannelsKt {
    /* JADX WARN: Removed duplicated region for block: B:55:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0082 A[Catch: all -> 0x0059, TRY_LEAVE, TryCatch #1 {all -> 0x0059, blocks: (B:58:0x0037, B:68:0x0061, B:72:0x0076, B:74:0x0082, B:78:0x008e, B:79:0x008f, B:63:0x0055), top: B:88:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x008f A[Catch: all -> 0x0059, TRY_LEAVE, TryCatch #1 {all -> 0x0059, blocks: (B:58:0x0037, B:68:0x0061, B:72:0x0076, B:74:0x0082, B:78:0x008e, B:79:0x008f, B:63:0x0055), top: B:88:0x0023 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x00a1 -> B:59:0x003a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object emitAll(kotlinx.coroutines.flow.FlowCollector<? super T> r7, kotlinx.coroutines.channels.ReceiveChannel<? extends T> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAll$1
            if (r0 == 0) goto L14
            r0 = r9
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAll$1 r0 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAll$1 r0 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAll$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L5b
            if (r2 == r4) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r7 = r0.L$3
            java.lang.Object r7 = r0.L$2
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L59
        L3a:
            r9 = r7
            r7 = r2
            goto L61
        L3d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L45:
            java.lang.Object r7 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            java.lang.Object r7 = r0.L$2
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L59
            goto L76
        L59:
            r7 = move-exception
            goto La4
        L5b:
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = 0
            java.lang.Throwable r9 = (java.lang.Throwable) r9
        L61:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L59
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L59
            r0.L$2 = r9     // Catch: java.lang.Throwable -> L59
            r0.L$3 = r7     // Catch: java.lang.Throwable -> L59
            r0.label = r4     // Catch: java.lang.Throwable -> L59
            java.lang.Object r2 = r8.receiveOrClosed(r0)     // Catch: java.lang.Throwable -> L59
            if (r2 != r1) goto L72
            return r1
        L72:
            r6 = r2
            r2 = r7
            r7 = r9
            r9 = r6
        L76:
            kotlinx.coroutines.channels.ValueOrClosed r9 = (kotlinx.coroutines.channels.ValueOrClosed) r9     // Catch: java.lang.Throwable -> L59
            java.lang.Object r9 = r9.m1358unboximpl()     // Catch: java.lang.Throwable -> L59
            boolean r5 = kotlinx.coroutines.channels.ValueOrClosed.m1356isClosedimpl(r9)     // Catch: java.lang.Throwable -> L59
            if (r5 == 0) goto L8f
            java.lang.Throwable r9 = kotlinx.coroutines.channels.ValueOrClosed.m1352getCloseCauseimpl(r9)     // Catch: java.lang.Throwable -> L59
            if (r9 != 0) goto L8e
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r8, r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L8e:
            throw r9     // Catch: java.lang.Throwable -> L59
        L8f:
            java.lang.Object r5 = kotlinx.coroutines.channels.ValueOrClosed.m1353getValueimpl(r9)     // Catch: java.lang.Throwable -> L59
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L59
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L59
            r0.L$2 = r7     // Catch: java.lang.Throwable -> L59
            r0.L$3 = r9     // Catch: java.lang.Throwable -> L59
            r0.label = r3     // Catch: java.lang.Throwable -> L59
            java.lang.Object r9 = r2.emit(r5, r0)     // Catch: java.lang.Throwable -> L59
            if (r9 != r1) goto L3a
            return r1
        La4:
            throw r7     // Catch: java.lang.Throwable -> La5
        La5:
            r9 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r8, r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ChannelsKt.emitAll(kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
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
