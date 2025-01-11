package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: Combine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector $this_unsafeFlow;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ CombineKt$zipImpl$$inlined$unsafeFlow$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(FlowCollector flowCollector, Continuation continuation, CombineKt$zipImpl$$inlined$unsafeFlow$1 combineKt$zipImpl$$inlined$unsafeFlow$1) {
        super(2, continuation);
        this.$this_unsafeFlow = flowCollector;
        this.this$0 = combineKt$zipImpl$$inlined$unsafeFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = new CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(this.$this_unsafeFlow, completion, this.this$0);
        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.p$ = (CoroutineScope) obj;
        return combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [103=5] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x016e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0186 A[Catch: all -> 0x0119, TRY_LEAVE, TryCatch #6 {all -> 0x0119, blocks: (B:9:0x003f, B:36:0x017e, B:38:0x0186, B:67:0x025b, B:19:0x00c8, B:22:0x0102, B:30:0x0148), top: B:102:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01c4 A[Catch: all -> 0x0257, TryCatch #5 {all -> 0x0257, blocks: (B:42:0x01af, B:45:0x01c4, B:49:0x01d5, B:52:0x01e0), top: B:100:0x01af }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x023d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x025b A[Catch: all -> 0x0119, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x0119, blocks: (B:9:0x003f, B:36:0x017e, B:38:0x0186, B:67:0x025b, B:19:0x00c8, B:22:0x0102, B:30:0x0148), top: B:102:0x000d }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x01b7 -> B:62:0x024d). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x023e -> B:61:0x0241). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        ReceiveChannel receiveChannel;
        CoroutineScope coroutineScope;
        final ReceiveChannel asChannel;
        ReceiveChannel asChannel2;
        ChannelIterator it;
        AbortFlowException abortFlowException;
        Throwable th2;
        ChannelIterator it2;
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12;
        ReceiveChannel receiveChannel2;
        ReceiveChannel receiveChannel3;
        ReceiveChannel receiveChannel4;
        Object obj2;
        ReceiveChannel receiveChannel5;
        ChannelIterator channelIterator;
        Throwable th3;
        ReceiveChannel receiveChannel6;
        ReceiveChannel receiveChannel7;
        ReceiveChannel receiveChannel8;
        Object obj3;
        ChannelIterator channelIterator2;
        CoroutineScope coroutineScope2;
        FlowCollector flowCollector;
        Object obj4;
        Object obj5;
        CoroutineScope coroutineScope3;
        ReceiveChannel receiveChannel9;
        ChannelIterator channelIterator3;
        ReceiveChannel receiveChannel10;
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13;
        Object obj6;
        Throwable th4;
        ReceiveChannel receiveChannel11;
        Object obj7;
        ReceiveChannel receiveChannel12;
        ChannelIterator channelIterator4;
        Object obj8;
        CoroutineScope coroutineScope4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = this.p$;
                asChannel = CombineKt.asChannel(coroutineScope, this.this$0.$flow$inlined);
                asChannel2 = CombineKt.asChannel(coroutineScope, this.this$0.$flow2$inlined);
                if (asChannel2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
                }
                ((SendChannel) asChannel2).invokeOnClose(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.1
                    {
                        super(1);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                        invoke2(th5);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th5) {
                        if (ReceiveChannel.this.isClosedForReceive()) {
                            return;
                        }
                        ReceiveChannel.this.cancel((CancellationException) new AbortFlowException());
                    }
                });
                it = asChannel2.iterator();
                try {
                    th2 = null;
                    it2 = asChannel.iterator();
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = this;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
                    receiveChannel2 = asChannel;
                    receiveChannel3 = receiveChannel2;
                    receiveChannel4 = receiveChannel3;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$0 = coroutineScope;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$1 = asChannel;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$2 = asChannel2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$3 = it;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$4 = receiveChannel2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$6 = receiveChannel3;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$7 = th2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$8 = receiveChannel4;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$9 = it2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.label = 1;
                    obj8 = it2.hasNext(combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1);
                    if (obj8 != coroutine_suspended) {
                    }
                } catch (AbortFlowException unused) {
                    if (!asChannel2.isClosedForReceive()) {
                        abortFlowException = new AbortFlowException();
                    }
                } catch (Throwable th5) {
                    if (!asChannel2.isClosedForReceive()) {
                        asChannel2.cancel((CancellationException) new AbortFlowException());
                    }
                    throw th5;
                }
            } else if (i == 1) {
                ChannelIterator channelIterator5 = (ChannelIterator) this.L$9;
                ReceiveChannel receiveChannel13 = (ReceiveChannel) this.L$8;
                Throwable th6 = (Throwable) this.L$7;
                receiveChannel = (ReceiveChannel) this.L$6;
                CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14 = (CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) this.L$5;
                ReceiveChannel receiveChannel14 = (ReceiveChannel) this.L$4;
                ChannelIterator channelIterator6 = (ChannelIterator) this.L$3;
                asChannel2 = (ReceiveChannel) this.L$2;
                ReceiveChannel receiveChannel15 = (ReceiveChannel) this.L$1;
                CoroutineScope coroutineScope5 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj8 = obj;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12 = this;
                channelIterator2 = channelIterator5;
                receiveChannel12 = receiveChannel15;
                receiveChannel10 = receiveChannel14;
                th4 = th6;
                receiveChannel11 = receiveChannel13;
                coroutineScope4 = coroutineScope5;
                channelIterator3 = channelIterator6;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$14;
                if (((Boolean) obj8).booleanValue()) {
                }
            } else if (i == 2) {
                Object obj9 = this.L$11;
                Object obj10 = this.L$10;
                channelIterator2 = (ChannelIterator) this.L$9;
                receiveChannel11 = (ReceiveChannel) this.L$8;
                th4 = (Throwable) this.L$7;
                receiveChannel = (ReceiveChannel) this.L$6;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13 = (CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) this.L$5;
                receiveChannel10 = (ReceiveChannel) this.L$4;
                channelIterator3 = (ChannelIterator) this.L$3;
                ReceiveChannel receiveChannel16 = (ReceiveChannel) this.L$2;
                ReceiveChannel receiveChannel17 = (ReceiveChannel) this.L$1;
                CoroutineScope coroutineScope6 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj6 = obj;
                obj2 = obj10;
                obj7 = obj9;
                receiveChannel12 = receiveChannel17;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12 = this;
                coroutineScope3 = coroutineScope6;
                receiveChannel9 = receiveChannel16;
                if (((Boolean) obj6).booleanValue()) {
                }
            } else if (i == 3) {
                flowCollector = (FlowCollector) this.L$12;
                Object obj11 = this.L$11;
                Object obj12 = this.L$10;
                ChannelIterator channelIterator7 = (ChannelIterator) this.L$9;
                ReceiveChannel receiveChannel18 = (ReceiveChannel) this.L$8;
                Throwable th7 = (Throwable) this.L$7;
                ReceiveChannel receiveChannel19 = (ReceiveChannel) this.L$6;
                CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$15 = (CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) this.L$5;
                receiveChannel5 = (ReceiveChannel) this.L$4;
                ChannelIterator channelIterator8 = (ChannelIterator) this.L$3;
                ReceiveChannel receiveChannel20 = (ReceiveChannel) this.L$2;
                ReceiveChannel receiveChannel21 = (ReceiveChannel) this.L$1;
                CoroutineScope coroutineScope7 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    receiveChannel7 = receiveChannel21;
                    obj3 = obj11;
                    coroutineScope2 = coroutineScope7;
                    receiveChannel8 = receiveChannel20;
                    channelIterator2 = channelIterator7;
                    th3 = th7;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$15;
                    channelIterator = channelIterator8;
                    obj2 = obj12;
                    receiveChannel6 = receiveChannel18;
                    receiveChannel = receiveChannel19;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12 = this;
                    obj4 = coroutine_suspended;
                    obj5 = obj;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$0 = coroutineScope2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$1 = receiveChannel7;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$2 = receiveChannel8;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$3 = channelIterator;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$4 = receiveChannel5;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$6 = receiveChannel;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$7 = th3;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$8 = receiveChannel6;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$9 = channelIterator2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$10 = obj2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$11 = obj3;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.label = 4;
                    if (flowCollector.emit(obj5, combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12) != obj4) {
                    }
                } catch (Throwable th8) {
                    th = th8;
                    receiveChannel = receiveChannel19;
                    throw th;
                }
            } else if (i != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ChannelIterator channelIterator9 = (ChannelIterator) this.L$9;
                receiveChannel6 = (ReceiveChannel) this.L$8;
                th3 = (Throwable) this.L$7;
                receiveChannel = (ReceiveChannel) this.L$6;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = (CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) this.L$5;
                ReceiveChannel receiveChannel22 = (ReceiveChannel) this.L$4;
                channelIterator = (ChannelIterator) this.L$3;
                ReceiveChannel receiveChannel23 = (ReceiveChannel) this.L$2;
                ReceiveChannel receiveChannel24 = (ReceiveChannel) this.L$1;
                coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                receiveChannel8 = receiveChannel23;
                receiveChannel5 = receiveChannel22;
                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12 = this;
                try {
                    channelIterator4 = channelIterator9;
                    coroutineScope = coroutineScope2;
                    th2 = th3;
                    it = channelIterator;
                    receiveChannel4 = receiveChannel6;
                    receiveChannel3 = receiveChannel;
                    asChannel = receiveChannel24;
                    ReceiveChannel receiveChannel25 = receiveChannel5;
                    asChannel2 = receiveChannel8;
                    receiveChannel2 = receiveChannel25;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$0 = coroutineScope;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$1 = asChannel;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$2 = asChannel2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$3 = it;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$4 = receiveChannel2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$6 = receiveChannel3;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$7 = th2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$8 = receiveChannel4;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$9 = it2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.label = 1;
                    obj8 = it2.hasNext(combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1);
                    if (obj8 != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ChannelIterator channelIterator10 = it;
                    coroutineScope4 = coroutineScope;
                    receiveChannel12 = asChannel;
                    receiveChannel = receiveChannel3;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
                    channelIterator3 = channelIterator10;
                    ReceiveChannel receiveChannel26 = receiveChannel2;
                    th4 = th2;
                    channelIterator2 = it2;
                    receiveChannel11 = receiveChannel4;
                    receiveChannel10 = receiveChannel26;
                    if (((Boolean) obj8).booleanValue()) {
                        Unit unit = Unit.INSTANCE;
                        ChannelsKt.cancelConsumed(receiveChannel, th4);
                        if (!asChannel2.isClosedForReceive()) {
                            abortFlowException = new AbortFlowException();
                            asChannel2.cancel((CancellationException) abortFlowException);
                        }
                        return Unit.INSTANCE;
                    }
                    obj2 = channelIterator2.next();
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$0 = coroutineScope4;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$1 = receiveChannel12;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$2 = asChannel2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$3 = channelIterator3;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$4 = receiveChannel10;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$6 = receiveChannel;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$7 = th4;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$8 = receiveChannel11;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$9 = channelIterator2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$10 = obj2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$11 = obj2;
                    combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.label = 2;
                    obj6 = channelIterator3.hasNext(combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12);
                    if (obj6 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    receiveChannel9 = asChannel2;
                    coroutineScope3 = coroutineScope4;
                    obj7 = obj2;
                    try {
                        if (((Boolean) obj6).booleanValue()) {
                            channelIterator4 = channelIterator2;
                            th2 = th4;
                            receiveChannel2 = receiveChannel10;
                            it = channelIterator3;
                            receiveChannel4 = receiveChannel11;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13;
                            receiveChannel3 = receiveChannel;
                            asChannel = receiveChannel12;
                            coroutineScope = coroutineScope3;
                            asChannel2 = receiveChannel9;
                            it2 = channelIterator4;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$0 = coroutineScope;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$1 = asChannel;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$2 = asChannel2;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$3 = it;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$4 = receiveChannel2;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$6 = receiveChannel3;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$7 = th2;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$8 = receiveChannel4;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$9 = it2;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.label = 1;
                            obj8 = it2.hasNext(combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1);
                            if (obj8 != coroutine_suspended) {
                            }
                        } else {
                            FlowCollector flowCollector2 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.$this_unsafeFlow;
                            Function3 function3 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.this$0.$transform$inlined;
                            Object obj13 = coroutine_suspended;
                            Object obj14 = obj7 == NullSurrogateKt.NULL ? null : obj7;
                            Symbol symbol = NullSurrogateKt.NULL;
                            Object next = channelIterator3.next();
                            if (next == symbol) {
                                next = null;
                            }
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$0 = coroutineScope3;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$1 = receiveChannel12;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$2 = receiveChannel9;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$3 = channelIterator3;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$4 = receiveChannel10;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$6 = receiveChannel;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$7 = th4;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$8 = receiveChannel11;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$9 = channelIterator2;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$10 = obj2;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$11 = obj7;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$12 = flowCollector2;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.label = 3;
                            Object obj15 = obj14;
                            ReceiveChannel receiveChannel27 = receiveChannel12;
                            obj5 = function3.invoke(obj15, next, combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12);
                            obj4 = obj13;
                            if (obj5 == obj4) {
                                return obj4;
                            }
                            flowCollector = flowCollector2;
                            receiveChannel7 = receiveChannel27;
                            ReceiveChannel receiveChannel28 = receiveChannel11;
                            obj3 = obj7;
                            coroutineScope2 = coroutineScope3;
                            receiveChannel5 = receiveChannel10;
                            th3 = th4;
                            receiveChannel8 = receiveChannel9;
                            channelIterator = channelIterator3;
                            combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$13;
                            receiveChannel6 = receiveChannel28;
                            try {
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$0 = coroutineScope2;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$1 = receiveChannel7;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$2 = receiveChannel8;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$3 = channelIterator;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$4 = receiveChannel5;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$6 = receiveChannel;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$7 = th3;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$8 = receiveChannel6;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$9 = channelIterator2;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$10 = obj2;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$11 = obj3;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.label = 4;
                                if (flowCollector.emit(obj5, combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12) != obj4) {
                                    return obj4;
                                }
                                coroutine_suspended = obj4;
                                channelIterator9 = channelIterator2;
                                receiveChannel24 = receiveChannel7;
                                channelIterator4 = channelIterator9;
                                coroutineScope = coroutineScope2;
                                th2 = th3;
                                it = channelIterator;
                                receiveChannel4 = receiveChannel6;
                                receiveChannel3 = receiveChannel;
                                asChannel = receiveChannel24;
                                ReceiveChannel receiveChannel252 = receiveChannel5;
                                asChannel2 = receiveChannel8;
                                receiveChannel2 = receiveChannel252;
                                it2 = channelIterator4;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$0 = coroutineScope;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$1 = asChannel;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$2 = asChannel2;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$3 = it;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$4 = receiveChannel2;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$5 = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$6 = receiveChannel3;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$7 = th2;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$8 = receiveChannel4;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.L$9 = it2;
                                combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$12.label = 1;
                                obj8 = it2.hasNext(combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1);
                                if (obj8 != coroutine_suspended) {
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                try {
                                    throw th;
                                } catch (Throwable th10) {
                                    ChannelsKt.cancelConsumed(receiveChannel, th);
                                    throw th10;
                                }
                            }
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        throw th;
                    }
                } catch (Throwable th12) {
                    th = th12;
                    receiveChannel = receiveChannel3;
                    throw th;
                }
                it2 = channelIterator4;
            }
        } catch (Throwable th13) {
            th = th13;
        }
    }
}
